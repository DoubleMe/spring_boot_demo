package com.chenhm.common.log;

import java.util.concurrent.ThreadLocalRandom;

/**
 * traceId 生成器
 *
 * @author Hongmin.Chen1
 * @date 2018-11-20 16:27
 * @since V1.0
 */
public class TraceIDGenerator {

    /**
     * 生成id
     *
     * @return
     */
    public static String generate() {

        long currentTime = System.currentTimeMillis();
        long timeStamp = currentTime % 1000000L;
        int randomNumber = ThreadLocalRandom.current().nextInt(1000000);
        long traceID = timeStamp * 10000L + (long) randomNumber;
        return Long.toHexString(traceID).toUpperCase();
    }
}
