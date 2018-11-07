package com.chenhm.springboot.interceptor;

import com.chenhm.springboot.util.JsonUtils;
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

        accessLog(joinPoint);
        try {
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    /**
     * 记录访问日志
     *
     * @param joinPoint
     */
    public void accessLog(ProceedingJoinPoint joinPoint) {

        String requestURI = request.getRequestURI();
        log.info("用户{}访问,{},参数：{}", "123", requestURI, JsonUtils.toJSONString(joinPoint.getArgs()));
    }
}
