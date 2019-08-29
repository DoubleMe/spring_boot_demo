package com.chenhm.common.exception;

/**
 * @author chenhongmin
 * @date 2019-08-29 17:34
 * @since V1.0
 */
public enum ErrorLevel {

    DEBUG(1),
    INFO(2),
    WARN(3),
    ERROR(4),
    ;

    int level;

    ErrorLevel(int level) {

        this.level = level;
    }}
