package com.chenhm.springboot.util.validate;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author Hongmin.Chen1
 * @date 2018/10/25 14:37
 * @since V1.0
 */
@Accessors(chain = true)
@Data
public class ValidateResult {

    /**
     * 是否有错误
     */
    private boolean error;

    /**
     * 错误字段名字
     */
    private List<ErrorField> errorFields;

    public static ValidateResult instance() {

        return new ValidateResult();
    }

    public String getMessage() {

        if (errorFields == null || errorFields.isEmpty()) {
            return "";
        }

        ErrorField errorField = errorFields.get(0);
        StringBuilder sb = new StringBuilder();
        sb.append(errorField.getFiledName()).append(errorField.getErrorMsg())
                .append(",当前值【").append(errorField.getInvalidValue()).append("】");
        return sb.toString();

    }

}
