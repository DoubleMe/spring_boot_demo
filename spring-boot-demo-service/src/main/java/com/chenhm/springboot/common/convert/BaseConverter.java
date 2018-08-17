package com.chenhm.springboot.common.convert;

import java.util.function.Function;

/**
 * @author chen-hongmin
 * @date 2018/8/15 9:44
 * @since V1.0
 */
public interface BaseConverter<T,R> extends Function<T,R> {

}
