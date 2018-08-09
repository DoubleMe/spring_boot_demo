package com.chenhm.springboot.mybatis;

import com.chenhm.springboot.util.StringFormatUtils;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.*;

/**
 * @author chen-hongmin
 * @date 2018/8/9 13:51
 * @since V1.0
 */

@SuppressWarnings({"rawtypes", "unchecked"})
@Intercepts(
        {
//                @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
                @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class}),
                @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
        }
)
public class SqlInterceptor implements Interceptor {


    private final static Logger LOGGER = LoggerFactory.getLogger(SqlInterceptor.class);

    /**
     * 是否展示SQL
     */
    private boolean showSql;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        if (!showSql) {
            return invocation.proceed();
        }
        Object[] args = invocation.getArgs();
        MappedStatement ms = (MappedStatement) args[0];
        Object parameter = args[1];
        BoundSql boundSql;

        //分页查询
        if (args.length == 6) {
            boundSql = (BoundSql) args[5];
        } else {
            boundSql = ms.getBoundSql(parameter);
        }
        List<Object> paramValueList = paramValueList(boundSql);
        String formatSql = StringFormatUtils.formatSql(boundSql.getSql(), paramValueList);

        long startMills = System.currentTimeMillis();
        Object proceed = invocation.proceed();
        long endMills = System.currentTimeMillis();

        LOGGER.info("sql【{}】 共耗时 = {} ms", formatSql, endMills - startMills);
        return proceed;
    }

    /**
     * 获取sql  值
     *
     * @param boundSql
     * @return
     */
    private List<Object> paramValueList(BoundSql boundSql) {

        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        if (parameterMappings == null || parameterMappings.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        Object parameterObject = boundSql.getParameterObject();
        if (parameterMappings.size() == 1) {
            return Collections.singletonList(parameterObject);
        }
        Map<String, Object> paramMap = (HashMap) parameterObject;
        List<Object> paramValues = new ArrayList<>(parameterMappings.size());
        parameterMappings.forEach(parameterMapping -> {

            paramValues.add(paramMap.get(parameterMapping.getProperty()));

        });

        return paramValues;
    }

    @Override
    public Object plugin(Object target) {

        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

        String showSql = properties.getProperty("showSql");
        if ("true".equals(showSql)) {
            this.showSql = true;
        } else {
            this.showSql = false;
        }
    }
}
