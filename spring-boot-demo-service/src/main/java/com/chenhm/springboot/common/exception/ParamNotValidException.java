package com.chenhm.springboot.common.exception;

import com.chenhm.springboot.common.ResponseCode;

/**
 * 参数校验失败异常
 *
 * @author chen-hongmin
 * @since 2017/11/23 10:20
 */
public class ParamNotValidException extends AbstractException {

    public ParamNotValidException(String message) {

        super(ResponseCode.VALID_FAIL, message);
    }

    public ParamNotValidException(String message, Throwable cause) {

        super(ResponseCode.VALID_FAIL, message, cause);
    }
}
