package com.chenhm.springboot.interceptor;

import com.chenhm.common.log.LogTraceThreadLocal;
import com.chenhm.common.util.JsonUtils;
import com.chenhm.common.response.ResponseCode;
import com.chenhm.common.response.ResponseUtils;
import com.chenhm.common.util.ValidateUtils;
import com.chenhm.common.util.validate.ValidateResult;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chen-hongmin
 * @date 2018/8/14 14:34
 * @since V1.0
 */
@Aspect
@Component
@Slf4j
public class GlobalInterceptor {

    @Autowired
    private HttpServletRequest request;

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void validPointcut() {

    }

    @Around("validPointcut()")
    public Object process(ProceedingJoinPoint joinPoint) {

        LogTraceThreadLocal.start(true);
        accessLog(joinPoint);
        Object result = null;
        try {

            //参数校验
            Object[] args = joinPoint.getArgs();
            if (args != null && args.length > 0) {
                for (Object arg : args) {
                    ValidateResult validate = ValidateUtils.validate(arg);
                    if (validate.isError()) {
                        return ResponseUtils.fail(validate.getMessage());
                    }
                }
            }
            result = joinPoint.proceed();
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            accessError(throwable);
        } finally {
            accessAfterLog(result);
        }
        return ResponseUtils.fail(ResponseCode.SYSTEM_ERROR);
    }

    /**
     * 记录访问日志
     *
     * @param joinPoint
     */
    private void accessLog(ProceedingJoinPoint joinPoint) {

        String requestURI = request.getRequestURI();
        log.info("=====start==== traceId【{}】访问【{}】,参数：【{}】",
                LogTraceThreadLocal.getTraceId(), requestURI, JsonUtils.toJSONString(joinPoint.getArgs()));
    }

    /**
     * 访问结束日志
     *
     * @param result
     */
    private void accessAfterLog(Object result) {


        String requestURI = request.getRequestURI();
        log.info("=====end==== traceId【{}】,访问【{}】耗时【{}】,返回值：【{}】",
                LogTraceThreadLocal.getTraceId(), requestURI, LogTraceThreadLocal.costTime(), JsonUtils.toJSONString(result));
        LogTraceThreadLocal.end();
    }

    /**
     * 异常访问日志
     *
     * @param throwable
     */
    private void accessError(Throwable throwable) {

        String requestURI = request.getRequestURI();
        log.error("=====end==== traceId【{}】,访问【{}】异常：【{}】",
                LogTraceThreadLocal.getTraceId(), requestURI, throwable);
    }
}
