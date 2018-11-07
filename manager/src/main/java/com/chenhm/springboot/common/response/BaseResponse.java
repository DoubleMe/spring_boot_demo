package com.chenhm.springboot.common.response;

import java.io.Serializable;

/**
 * @author chen-hongmin
 * @date 2018/8/14 13:48
 * @since V1.0
 */
public class BaseResponse<T> implements Serializable {

    /**
     * response code
     */
    private int code;

    /**
     * response message
     */
    private String msg;


    public int getCode() {

        return code;
    }

    public void setCode(int code) {

        this.code = code;
    }

    public String getMsg() {

        return msg;
    }

    public void setMsg(String msg) {

        this.msg = msg;
    }
}
