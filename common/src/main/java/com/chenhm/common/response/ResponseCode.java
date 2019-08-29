package com.chenhm.common.response;

import com.chenhm.common.exception.ErrorCode;

/**
 * @author chen-hongmin
 * @date 2018/8/15 9:40
 * @since V1.0
 */
public enum ResponseCode implements ErrorCode {

    SUCCESS(200, "成功"),
    FAIL(1001, "业务异常"),
    VALID_FAIL(1002, "参数异常"),
    SYSTEM_ERROR(10023,"系统繁忙"),
    ;

    /**
     * code
     */
    private int code;

    /**
     * 描述
     */
    private String desc;

    ResponseCode(int code, String desc) {

        this.code = code;
        this.desc = desc;
    }

    @Override
    public int getCode() {

        return code;
    }


    @Override
    public String getMessage() {

        return desc;
    }


}
