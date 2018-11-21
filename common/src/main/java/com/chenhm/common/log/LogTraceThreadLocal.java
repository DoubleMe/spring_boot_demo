package com.chenhm.common.log;


import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 记录某请求完整调用情况
 * <p>
 * 目前仅记录接口层发送的异常，后期可以记录
 * 1、每个manager方法的耗时
 * 2、sql
 * 3、cache
 * 4、核心rpc调用情况
 * 5、消息
 *
 * @author chenhm
 * @since 2018-11-20 16:27
 */
public class LogTraceThreadLocal {

    private static final ThreadLocal<LogTrace> LOG_TRACE = new ThreadLocal<>();

    /**
     * 开始日志记录
     *
     * @param syn true：同步请求，false：异步请求（job，msg）
     */
    public static void start(boolean syn) {

        LOG_TRACE.set(new LogTrace(syn));
    }

    /**
     * 结束记录，一定要手动释放掉记录
     */
    public static void end() {

        LOG_TRACE.remove();
    }

    /**
     * 获取日志堆栈
     *
     * @return
     */
    public static Map<String, List<Object>> getLogStack() {

        if (LOG_TRACE.get() == null) {
            return Collections.emptyMap();
        }
        return LOG_TRACE.get().getStack();
    }

    /**
     * 获取异常堆栈信息，并从日志堆栈中删除
     *
     * @return
     */
    public static List<Object> getAndRemoveExceptionLogs() {

        if (LOG_TRACE.get() == null) {
            return Collections.emptyList();
        }
        return LOG_TRACE.get().getStack().remove("exception");

    }

    /**
     * 获取traceId
     *
     * @return
     */
    public static String getTraceId() {

        if (LOG_TRACE.get() == null) {
            return "";
        }
        return LOG_TRACE.get().getTraceId();
    }

    /**
     * 请求花费时间
     *
     * @return
     */
    public static long costTime() {

        if (LOG_TRACE.get() == null) {
            return 0L;
        }

        return System.currentTimeMillis() - LOG_TRACE.get().getStartTime();
    }

    /**
     * 当前线程是否是同步请求线程
     *
     * @return
     */
    public static boolean isSyn() {

        if (LOG_TRACE.get() == null) {
            return true;
        }
        return LOG_TRACE.get().isSyn();
    }
}
