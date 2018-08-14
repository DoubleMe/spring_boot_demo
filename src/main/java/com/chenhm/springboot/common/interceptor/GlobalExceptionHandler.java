package com.chenhm.springboot.common.interceptor;

import com.chenhm.springboot.common.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chen-hongmin
 * @date 2018-08-14 13:54
 * @since 1.0.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {


    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Response handleException(HttpServletRequest request, RuntimeException e) {

        Response<String> response = new Response<>();
        response.setMsg(e.getMessage());
        response.setData(request.getRequestURL().toString());

        String url = request.getRequestURL().toString();
        LOGGER.error("访问 {} 出错", url, e);
        return response;
    }
}
