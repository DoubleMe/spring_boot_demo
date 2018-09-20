package com.chenhm.springboot.common;

import java.util.function.Function;

/**
 * @author chen-hongmin
 * @date 2018/9/10 9:32
 * @since V1.0
 */
public class BaseJsonObject {

    /**
     * response code
     */
    private int code;

    /**
     * response message
     */
    private String message;

    /**
     * response body
     */
    private Object data;

    public BaseJsonObject() {

    }

    public BaseJsonObject(int code) {

        this.code = code;
    }

    public int getCode() {

        return code;
    }

    public void setCode(int code) {

        this.code = code;
    }

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {

        this.message = message;
    }

    public Object getData() {

        return data;
    }

    public void setData(Object data) {

        this.data = data;
    }

    public static BaseJsonObject instance() {

        return new BaseJsonObject();
    }

    public static BaseJsonObject fail() {

        return new BaseJsonObject(ResponseCode.FAIL);
    }

    public static BaseJsonObject success() {

        return new BaseJsonObject(ResponseCode.SUCCESS);
    }

    public BaseJsonObject code(int code) {

        this.code = code;
        return this;
    }

    public BaseJsonObject message(String message) {

        this.message = message;
        return this;
    }

    public BaseJsonObject data(Object data) {

        this.data = data;
        return this;
    }

    public BaseJsonObject data(Object data, Function function) {

        if (data == null) {
            this.data = data;
            return this;
        }

        Object apply = function.apply(data);

        this.data = apply;
        return this;
    }
}
