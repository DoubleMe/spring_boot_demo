package com.chenhm.springboot.common;

import com.chenhm.springboot.common.convert.BaseConverter;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chen-hongmin
 * @date 2018/8/14 13:48
 * @since V1.0
 */
public class ResponseUtils {

    /**
     * response with no data
     *
     * @param code    消息code
     * @param message 消息
     * @return response
     */
    public static Response<String> response(int code, String message) {

        return response(code, message, "");
    }

    /**
     * response
     *
     * @param code    消息code
     * @param message 消息
     * @param data    消息实体
     * @param <T>     泛型
     * @return response
     */
    public static <T> Response<T> response(int code, String message, T data) {

        Response<T> response = new Response<>();
        response.setCode(code);
        response.setMsg(message);
        response.setData(data);

        return response;
    }

    /**
     * response fail default code
     *
     * @param message 消息
     * @return response
     */
    public static Response<String> fail(String message) {

        return response(ResponseCode.FAIL, message);
    }

    /**
     * response fail
     *
     * @param code    消息code
     * @param message 消息
     * @return response
     */
    public static Response<String> fail(int code, String message) {

        return response(code, message);
    }

    /**
     * response success default message
     *
     * @param data 消息实体
     * @return response
     */
    public static <T> Response<T> success(T data) {

        return response(ResponseCode.SUCCESS, "", data);
    }

    /**
     * response success with message
     *
     * @param data    消息实体
     * @param message 消息
     * @return response
     */
    public static <T> Response<T> success(T data, String message) {

        return response(ResponseCode.SUCCESS, message, data);
    }

    /**
     * response success and convert data
     *
     * @param data 消息实体
     * @return response
     */
    public static <T, R> Response<R> load(T data, BaseConverter<T, R> converter) {


        return response(ResponseCode.SUCCESS, "", converter.apply(data));
    }

    /**
     * response success and convert data
     *
     * @param dataList 消息实体
     * @return response
     */
    public static <T, R> Response<List<R>> loadList(List<T> dataList, BaseConverter<T, R> converter) {

        if (dataList == null || dataList.isEmpty()) {
            return response(ResponseCode.SUCCESS, "", Collections.EMPTY_LIST);
        }
        List<R> rList = dataList.stream().map(converter).collect(Collectors.toList());

        return response(ResponseCode.SUCCESS, "", rList);
    }


}
