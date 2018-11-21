package com.chenhm.common.util;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Hongmin.Chen1
 * @date 2018/10/23 20:06
 * @since V1.0
 */
public class Lists {

    /**
     * list 转换
     *
     * @param target
     * @param function
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> List<R> transform(List<T> target, Function<T, R> function) {

        if (target == null || target.isEmpty()) {
            return Collections.emptyList();
        }
        return target.stream().filter(Objects::nonNull).map(function).collect(Collectors.toList());
    }
}
