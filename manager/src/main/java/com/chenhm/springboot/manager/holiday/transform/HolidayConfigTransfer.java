package com.chenhm.springboot.manager.holiday.transform;

import com.chenhm.springboot.manager.holiday.bo.HolidayConfigBO;
import com.chenhm.springboot.mapper.holiday.domain.HolidayConfigDO;

/**
 * @author Hongmin.Chen1
 * @date 2018/10/23 19:31
 * @since V1.0
 */
public class HolidayConfigTransfer {

    public static HolidayConfigBO toBO(HolidayConfigDO holidayConfigDO) {

        if (holidayConfigDO == null) {
            return null;
        }
        HolidayConfigBO holidayConfigBO = new HolidayConfigBO();
        holidayConfigBO.setId(holidayConfigDO.getId());
        holidayConfigBO.setHolidayYear(holidayConfigDO.getHolidayYear());
        holidayConfigBO.setStartDate(holidayConfigDO.getStartDate());
        holidayConfigBO.setEndDate(holidayConfigDO.getEndDate());
        holidayConfigBO.setHolidayType(holidayConfigDO.getHolidayType());
        holidayConfigBO.setOperator(holidayConfigDO.getOperator());
        holidayConfigBO.setCreateTime(holidayConfigDO.getCreateTime());
        holidayConfigBO.setUpdateTime(holidayConfigDO.getUpdateTime());
        return holidayConfigBO;
    }

    public static HolidayConfigDO toDO(HolidayConfigBO holidayConfigBO) {

        if (holidayConfigBO == null) {
            return null;
        }
        HolidayConfigDO holidayConfigDO = new HolidayConfigDO();
        holidayConfigDO.setId(holidayConfigBO.getId());
        holidayConfigDO.setHolidayYear(holidayConfigBO.getHolidayYear());
        holidayConfigDO.setStartDate(holidayConfigBO.getStartDate());
        holidayConfigDO.setEndDate(holidayConfigBO.getEndDate());
        holidayConfigDO.setHolidayType(holidayConfigBO.getHolidayType());
        holidayConfigDO.setOperator(holidayConfigBO.getOperator());
        holidayConfigDO.setCreateTime(holidayConfigBO.getCreateTime());
        holidayConfigDO.setUpdateTime(holidayConfigBO.getUpdateTime());
        return holidayConfigDO;
    }
}
