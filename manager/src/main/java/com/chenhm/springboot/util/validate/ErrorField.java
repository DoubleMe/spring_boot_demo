package com.chenhm.springboot.util.validate;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Hongmin.Chen1
 * @date 2018/10/25 14:42
 * @since V1.0
 */
@Accessors(chain = true)
@Data
public class ErrorField {

    /**
     * 字段名
     */
    private String filedName;

    /**
     * 异常信息
     */
    private String errorMsg;

    /**
     * 异常信息模板
     */
    private String msgTemplate;

    /**
     * 无效值
     */
    private Object invalidValue;
}
