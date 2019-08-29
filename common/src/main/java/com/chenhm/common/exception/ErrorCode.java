package com.chenhm.common.exception;

/**
 * @author chenhongmin
 * @date 2019-08-29 17:12
 * @since V1.0
 */
public interface ErrorCode {

    /**
     * 编码
     *
     * @return
     */
    int getCode();

    /**
     * 信息
     *
     * @return
     */
    String getMessage();

}
