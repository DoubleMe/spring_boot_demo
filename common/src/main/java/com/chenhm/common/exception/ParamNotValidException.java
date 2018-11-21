package com.chenhm.common.exception;

import com.chenhm.common.response.ResponseCode;

/**
 * 参数校验失败异常
 *
 * @author chen-hongmin
 * @since 2017/11/23 10:20
 */
public class ParamNotValidException extends AbstractException {

    public ParamNotValidException(String message) {

        super(ResponseCode.VALID_FAIL.getCode(), message);
    }

    public ParamNotValidException(String message, Throwable cause) {

        super(ResponseCode.VALID_FAIL.getCode(), message, cause);
    }
}
