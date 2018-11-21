package com.chenhm.springboot.manager.holiday.impl;

import com.chenhm.common.util.Lists;
import com.chenhm.common.PageAdaptor;
import com.chenhm.common.PageQuery;
import com.chenhm.common.PageResult;
import com.chenhm.springboot.manager.holiday.HolidayConfigManager;
import com.chenhm.springboot.manager.holiday.bo.HolidayConfigBO;
import com.chenhm.springboot.manager.holiday.transform.HolidayConfigTransfer;
import com.chenhm.springboot.mapper.holiday.HolidayConfigMapper;
import com.chenhm.springboot.mapper.holiday.domain.HolidayConfigDO;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Hongmin.Chen1
 * @date 2018/10/23 19:33
 * @since V1.0
 */
@Service
public class HolidayConfigManagerImpl implements HolidayConfigManager {

    @Resource
    private HolidayConfigMapper holidayConfigMapper;

    @Override
    public boolean insert(HolidayConfigBO holidayConfigBO) {

        HolidayConfigDO holidayConfigDO = HolidayConfigTransfer.toDO(holidayConfigBO);
        return holidayConfigMapper.insert(holidayConfigDO) > 0;
    }

    @Override
    public boolean update(HolidayConfigBO holidayConfigBO) {

        HolidayConfigDO holidayConfigDO = HolidayConfigTransfer.toDO(holidayConfigBO);
        return holidayConfigMapper.update(holidayConfigDO) > 0;
    }

    @Override
    public HolidayConfigBO getById(Long id) {

        return HolidayConfigTransfer.toBO(holidayConfigMapper.getById(id));
    }

    @Override
    public boolean delById(Long id) {

        return holidayConfigMapper.delById(id) > 0;
    }

    @Override
    public PageResult<HolidayConfigBO> list(PageQuery<HolidayConfigBO> pageQueryBO) {

        Page page = PageAdaptor.start(pageQueryBO);
        List<HolidayConfigDO> list = holidayConfigMapper.list(HolidayConfigTransfer.toDO(pageQueryBO.getQuery()));
        return PageAdaptor.processResult(page, Lists.transform(list, HolidayConfigTransfer::toBO));
    }
}


