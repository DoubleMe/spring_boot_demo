package com.chenhm.springboot.mapper;

import com.chenhm.springboot.BaseTest;
import com.chenhm.springboot.mapper.dataobject.HolidayConfigDO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author chen-hongmin
 * @date 2018/8/8 17:16
 * @since V1.0
 */

public class HolidayConfigMapperTest extends BaseTest {

    @Resource
    private HolidayConfigMapper holidayConfigMapper;

    @Test
    public void insert() {

        HolidayConfigDO holidayConfigDO = new HolidayConfigDO();
        holidayConfigDO.setHolidayType(1);
        holidayConfigDO.setEndDate(LocalDate.now());
        holidayConfigDO.setStartDate(LocalDate.MAX);
        holidayConfigDO.setHolidayYear(2018);
        holidayConfigDO.setOperator("mmm");
        holidayConfigMapper.insert(holidayConfigDO);
    }

    @Test
    public void update() {

    }

    @Test
    public void getById() {

        HolidayConfigDO byId = holidayConfigMapper.getById(1L);
    }

    @Test
    public void delById() {

    }

    @Test
    public void list() {

        PageHelper.startPage(1,2);
        Page<HolidayConfigDO> list = holidayConfigMapper.list(2018,2);

    }
}