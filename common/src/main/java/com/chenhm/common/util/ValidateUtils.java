package com.chenhm.common.util;

import com.chenhm.common.util.validate.ErrorField;
import com.chenhm.common.util.validate.ValidateResult;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.*;

/**
 * @author Hongmin.Chen1
 * @date 2018/10/25 14:29
 * @since V1.0
 */
public class ValidateUtils {

    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    /**
     * 参数校验
     *
     * @param target
     * @param groups
     * @return
     */
    public static ValidateResult validate(Object target, Class<?>... groups) {

        Set<ConstraintViolation<Object>> resultSet = validator.validate(target, groups);
        //没有异常
        if (resultSet == null || resultSet.isEmpty()) {
            return ValidateResult.instance().setError(false).setErrorFields(Collections.emptyList());
        }

        // 校验不通过
        List<ErrorField> errorFields = new ArrayList<>();
        Iterator<ConstraintViolation<Object>> iterator = resultSet.iterator();
        while (iterator.hasNext()) {
            ConstraintViolation<Object> next = iterator.next();

            ErrorField errorField = new ErrorField();
            errorField.setFiledName(next.getPropertyPath().toString());
            errorField.setErrorMsg(next.getMessage());
            errorField.setMsgTemplate(next.getMessageTemplate());
            errorField.setInvalidValue(next.getInvalidValue());

            errorFields.add(errorField);
        }

        return ValidateResult.instance().setError(true).setErrorFields(errorFields);
    }

}
