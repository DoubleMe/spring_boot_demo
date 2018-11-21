package com.chenhm.common.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chen-hongmin
 * @date 2018/8/14 13:48
 * @since V1.0
 */
@Data
public class Response<T> implements Serializable {

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

    public T getData() {

        return data;
    }

    public void setData(T data) {

        this.data = data;
    }
}
