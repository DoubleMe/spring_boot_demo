package com.chenhm.springboot.common.mybatis;

import com.chenhm.springboot.util.DateUtils;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;

/**
 * @author chen-hongmin
 * @date 2018/8/9 13:51
 * @since V1.0
 */

@SuppressWarnings({"rawtypes", "unchecked"})
@Intercepts(
        {
                @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
                @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class}),
                @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
        }
)
public class SqlInterceptor implements Interceptor {


    private final static Logger LOGGER = LoggerFactory.getLogger("SQL");

    /**
     * 是否展示SQL
     */
    private boolean showSql;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        long startMills = System.currentTimeMillis();
        Object proceed = invocation.proceed();
        long endMills = System.currentTimeMillis();

        //不展示sql
        if (!showSql) {
            return proceed;
        }
        Object[] args = invocation.getArgs();
        MappedStatement ms = (MappedStatement) args[0];
        if (args.length < 2) {
            return proceed;
        }
        Object parameter = args[1];
        BoundSql boundSql;

        if (args.length == 6){
            boundSql = (BoundSql)args[5];
        }else {
            boundSql = ms.getBoundSql(parameter);
        }



        String formatSql = showSql(ms.getConfiguration(), boundSql);
        String msId = ms.getId();
        LOGGER.info("{}:耗时 = 【{}】 毫秒,  {}", msId, endMills - startMills, formatSql);
        return proceed;
    }

    public String showSql(Configuration configuration, BoundSql boundSql) {

        Object parameterObject = boundSql.getParameterObject();
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        // sql语句中多个空格都用一个空格代替
        String sql = boundSql.getSql().replaceAll("[\\s]+", " ");
        if (CollectionUtils.isEmpty(parameterMappings) || parameterObject == null) {
            return sql;
        }

        TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
        if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
            // 获取类型处理器注册器，类型处理器的功能是进行java类型和数据库类型的转换
            sql = sql.replaceFirst("\\?", Matcher.quoteReplacement(getParameterValue(parameterObject)));
            return sql;
        }

        // MetaObject主要是封装了originalObject对象，提供了get和set的方法用于获取和设置originalObject的属性值,主要支持对JavaBean、Collection、Map三种类型对象的操作
        MetaObject metaObject = configuration.newMetaObject(parameterObject);

        for (ParameterMapping parameterMapping : parameterMappings) {
            String propertyName = parameterMapping.getProperty();
            if (metaObject.hasGetter(propertyName)) {
                Object obj = metaObject.getValue(propertyName);
                sql = sql.replaceFirst("\\?", Matcher.quoteReplacement(getParameterValue(obj)));
            } else if (boundSql.hasAdditionalParameter(propertyName)) {
                // 该分支是动态sql
                Object obj = boundSql.getAdditionalParameter(propertyName);
                sql = sql.replaceFirst("\\?", Matcher.quoteReplacement(getParameterValue(obj)));
            } else {
                sql = sql.replaceFirst("\\?", "缺失");
            }//打印出缺失，提醒该参数缺失并防止错位
        }

        return sql;
    }

    /**
     * 如果参数是String，则添加单引号， 如果是日期，则转换为时间格式器并加单引号;
     * 对参数是null和不是null的情况作了处理
     *
     * @param obj
     */
    private String getParameterValue(Object obj) {

        String value;
        if (obj instanceof String) {
            value = "'" + obj.toString() + "'";
        } else if (obj instanceof Date) {
            String format = DateUtils.format((Date) obj, DateUtils.YYYY_MM_DD_HH_MM_SS);
            value = "'" + format + "'";
        } else if (obj instanceof LocalDate) {
            String format = ((LocalDate) obj).format(DateTimeFormatter.ofPattern(DateUtils.YYYY_MM_DD));
            value = "'" + format + "'";
        } else if (obj instanceof LocalTime) {
            String format = ((LocalTime) obj).format(DateTimeFormatter.ofPattern(DateUtils.HH_MM_SS));
            value = "'" + format + "'";
        } else if (obj instanceof LocalDateTime) {
            String format = ((LocalDateTime) obj).format(DateTimeFormatter.ofPattern(DateUtils.YYYY_MM_DD_HH_MM_SS));
            value = "'" + format + "'";
        } else {
            if (obj != null) {
                value = obj.toString();
            } else {
                value = "null";
            }

        }
        return value;
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
