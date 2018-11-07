package com.chenhm.springboot.exception;

import com.chenhm.springboot.common.response.ResponseCode;

/**
 * 异常基类
 *
 * @author chen-hongmin
 * @date 2018/8/15 9:58
 * @since V1.0
 */
public class AbstractException extends RuntimeException {

    private int code = ResponseCode.FAIL.getCode();

    private String message;

    public AbstractException(String message) {

        super(message);
        this.message = message;
    }

    public AbstractException(String message, Throwable cause) {

        super(message, cause);
        this.message = message;
    }

    public AbstractException(int code, String message) {

        super(message);
        this.code = code;
        this.message = message;
    }

    public AbstractException(int code, String message, Throwable cause) {

        super(message, cause);
        this.code = code;
        this.message = message;
    }

    public int getCode() {

        return code;
    }

    @Override
    public String getMessage() {

        return message;
    }
}
