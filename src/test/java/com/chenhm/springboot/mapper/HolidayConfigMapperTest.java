package com.chenhm.springboot.mapper;

import com.chenhm.springboot.mapper.dataobject.HolidayConfigDO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author chen-hongmin
 * @date 2018/8/8 17:16
 * @since V1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HolidayConfigMapperTest {

    @Resource
    private HolidayConfigMapper holidayConfigMapper;

    @Test
    public void insert() {

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

        System.out.println(list);
    }
}