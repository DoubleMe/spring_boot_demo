package com.chenhm.springboot.manager.holiday.impl;

import com.chenhm.springboot.util.Lists;
import com.chenhm.springboot.manager.holiday.HolidayConfigManager;
import com.chenhm.springboot.manager.holiday.bo.HolidayConfigBO;
import com.chenhm.springboot.common.PageAdaptor;
import com.chenhm.springboot.common.PageQueryBO;
import com.chenhm.springboot.common.PageResultBO;
import com.chenhm.springboot.manager.holiday.transform.HolidayConfigTransformer;
import com.chenhm.springboot.mapper.holiday.HolidayConfigMapper;
import com.chenhm.springboot.mapper.holiday.domain.HolidayConfigDO;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Hongmin.Chen1
 * @date 2018/10/23 19:33
 * @since V1.0
 */
public class HolidayConfigManagerImpl implements HolidayConfigManager {

    @Resource
    private HolidayConfigMapper holidayConfigMapper;

    @Override
    public void insert(HolidayConfigBO holidayConfigBO) {

        HolidayConfigDO holidayConfigDO = HolidayConfigTransformer.toDO(holidayConfigBO);
        holidayConfigMapper.insert(holidayConfigDO);
    }

    @Override
    public void update(HolidayConfigBO holidayConfigBO) {

        HolidayConfigDO holidayConfigDO = HolidayConfigTransformer.toDO(holidayConfigBO);
        holidayConfigMapper.update(holidayConfigDO);
    }

    @Override
    public HolidayConfigBO getById(Long id) {

        return HolidayConfigTransformer.toBO(holidayConfigMapper.getById(id));
    }

    @Override
    public void delById(Long id) {

        holidayConfigMapper.delById(id);
    }

    @Override
    public PageResultBO<HolidayConfigBO> list(PageQueryBO<HolidayConfigBO> pageQueryBO) {

        PageAdaptor.start(pageQueryBO);

        List<HolidayConfigDO> list = holidayConfigMapper.list(HolidayConfigTransformer.toDO(pageQueryBO.getQuery()));

        List<HolidayConfigBO> configBOS = Lists.transform(list, HolidayConfigTransformer::toBO);
        return PageAdaptor.processResult(configBOS);
    }
}


