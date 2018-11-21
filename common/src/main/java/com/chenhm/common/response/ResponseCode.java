package com.chenhm.common.response;

/**
 * @author chen-hongmin
 * @date 2018/8/15 9:40
 * @since V1.0
 */
public enum ResponseCode {

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

    public int getCode() {

        return code;
    }

    public void setCode(int code) {

        this.code = code;
    }

    public String getDesc() {

        return desc;
    }

    public void setDesc(String desc) {

        this.desc = desc;
    }
}
