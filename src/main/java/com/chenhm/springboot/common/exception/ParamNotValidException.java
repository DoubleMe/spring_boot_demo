package com.chenhm.springboot.common.exception;

/**
 * 参数校验失败异常
 *
 * @author chen-hongmin
 * @since 2017/11/23 10:20
 */
public class ParamNotValidException extends RuntimeException {

    public ParamNotValidException(String message) {

        super(message);
    }

    public ParamNotValidException(String message, Throwable cause) {

        super(message, cause);
    }
}
