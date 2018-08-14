package com.chenhm.springboot.common.interceptor;

import com.chenhm.springboot.common.exception.ParamNotValidException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.Optional;

/**
 * @author chen-hongmin
 * @date 2018/8/14 14:34
 * @since V1.0
 */
@Aspect
@Component
public class ParamValidateInterceptor {

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void validPointcut() {

    }

    @Before("validPointcut() && args(..,bindingResult)")
    public void Interceptor(BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Optional<ObjectError> first = bindingResult.getAllErrors().stream().findFirst();
            if (first.isPresent()) {
                throw new ParamNotValidException(first.get().getDefaultMessage());
            }
        }
    }
}
