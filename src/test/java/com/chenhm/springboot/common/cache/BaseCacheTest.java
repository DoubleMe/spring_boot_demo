package com.chenhm.springboot.common.cache;

import com.chenhm.springboot.BaseTest;
import com.chenhm.springboot.mapper.dataobject.HolidayConfigDO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * @author chen-hongmin
 * @date 2018/8/15 14:26
 * @since V1.0
 */
public class BaseCacheTest extends BaseTest {

    @Autowired
    private BaseCache baseCache;

    private static String KEY = "spring_boot_cache_test";

    @Test
    public void get() {

        Object o = baseCache.get(KEY);
    }

    @Test
    public void set() {

        HolidayConfigDO holidayConfigDO = new HolidayConfigDO();
        holidayConfigDO.setOperator("chenhm");
        holidayConfigDO.setHolidayYear(2018);
        holidayConfigDO.setEndDate(LocalDate.now());

        baseCache.set(KEY, "");
    }
}