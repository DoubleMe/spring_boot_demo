package com.chenhm.springboot.util;

import com.chenhm.springboot.manager.holiday.bo.HolidayConfigBO;
import com.chenhm.springboot.util.validate.ValidateResult;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Hongmin.Chen1
 * @date 2018/10/25 16:15
 * @since V1.0
 */
public class ValidateUtilsTest {

    @Test
    public void validate() {


        HolidayConfigBO holidayConfigBO = new HolidayConfigBO();
        holidayConfigBO.setId(123L);
        ValidateResult result = ValidateUtils.validate(holidayConfigBO);

        System.out.println(result.getMessage());
        Assert.assertTrue(result.isError());
    }
}