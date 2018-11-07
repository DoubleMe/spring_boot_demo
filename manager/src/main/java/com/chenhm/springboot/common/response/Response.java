package com.chenhm.springboot.common.response;

import java.io.Serializable;

/**
 * @author chen-hongmin
 * @date 2018/8/14 13:48
 * @since V1.0
 */
public class Response<T> extends BaseResponse<T> implements Serializable {

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
