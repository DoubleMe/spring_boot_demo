package com.chenhm.common.response;

import com.chenhm.common.PageResult;
import com.chenhm.common.util.Lists;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
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
     * response
     *
     * @param responseCode 消息code
     * @param data         消息实体
     * @param <T>          泛型
     * @return response
     */
    public static <T> Response<T> response(ResponseCode responseCode, T data) {

        Response<T> response = new Response<>();
        response.setCode(responseCode.getCode());
        response.setMsg(responseCode.getDesc());
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

        return response(ResponseCode.FAIL.getCode(), message);
    }

    /**
     * response fail default code
     *
     * @param responseCode 消息
     * @return response
     */
    public static Response<String> fail(ResponseCode responseCode) {

        return response(responseCode.getCode(),responseCode.getDesc());
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

        return response(ResponseCode.SUCCESS, data);
    }

    /**
     * response success with message
     *
     * @param data    消息实体
     * @param message 消息
     * @return response
     */
    public static <T> Response<T> success(T data, String message) {


        return response(ResponseCode.SUCCESS.getCode(), message, data);
    }

    /**
     * response success and convert data
     *
     * @param data 消息实体
     * @return response
     */
    public static <T, R> Response<R> load(T data, Function<T, R> function) {

        if (data == null) {
            return response(ResponseCode.SUCCESS, null);
        }

        return response(ResponseCode.SUCCESS, function.apply(data));
    }

    /**
     * response success and convert data
     *
     * @param dataList 消息实体
     * @param function function
     * @return response
     */
    public static <T, R> Response<List<R>> loadList(List<T> dataList, Function<T, R> function) {

        if (dataList == null || dataList.isEmpty()) {
            return response(ResponseCode.SUCCESS, Collections.emptyList());
        }
        List<R> rList = dataList.stream().map(function).collect(Collectors.toList());
        return response(ResponseCode.SUCCESS, rList);
    }

    /**
     * response success and convert data
     *
     * @param pageResultBO 消息实体
     * @param function     function
     * @return response
     */
    public static <T, R> Response<PageResult<R>> loadPageList(PageResult<T> pageResultBO, Function<T, R> function) {

        Response<PageResult<R>> pageResponse = new Response<>();
        PageResult<R> pageResult = new PageResult<>();

        pageResult.setPageNum(pageResultBO.getPageNum());
        pageResult.setPageSize(pageResultBO.getPageSize());
        pageResult.setTotal(pageResultBO.getTotal());
        pageResult.setHasNext(pageResultBO.getHasNext());
        List<R> transform = Lists.transform(pageResultBO.getData(), function);
        pageResult.setData(transform);
        pageResponse.setData(pageResult);
        return pageResponse;
    }


}
