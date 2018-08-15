package com.chenhm.springboot.common;

/**
 * @author chen-hongmin
 * @date 2018/8/15 9:40
 * @since V1.0
 */
public interface ResponseCode {

    /**
     * 成功
     */
    int SUCCESS = 0;

    /**
     * 失败
     */
    int FAIL = 1;

    /**
     * 参数校验失败
     */
    int VALID_FAIL = 2;
}
