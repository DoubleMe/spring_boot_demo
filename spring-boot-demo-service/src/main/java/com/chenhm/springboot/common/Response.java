package com.chenhm.springboot.common;

/**
 * @author chen-hongmin
 * @date 2018/8/14 13:48
 * @since V1.0
 */
public class Response<T> {

    /**
     * response code
     */
    private int code;

    /**
     * response message
     */
    private String msg;

    /**
     * response body
     */
    private T data;

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

    public T getData() {

        return data;
    }

    public void setData(T data) {

        this.data = data;
    }
}
