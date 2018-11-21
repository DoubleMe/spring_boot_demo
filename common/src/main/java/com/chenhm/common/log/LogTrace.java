package com.chenhm.common.log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 日志记录模型
 *
 * @author chenhm
 * @since 2018-11-20 16:26
 */
class LogTrace {

    private final String traceId = TraceIDGenerator.generate();

    private final boolean syn;

    private final long startTime = System.currentTimeMillis();

    private final Map<String, List<Object>> stack = new HashMap<>();

    long getStartTime() {
        return startTime;
    }

    String getTraceId() {
        return traceId;
    }

    Map<String, List<Object>> getStack() {
        return stack;
    }

    boolean isSyn() {
        return syn;
    }

     LogTrace(boolean syn) {
        this.syn = syn;
    }
}
