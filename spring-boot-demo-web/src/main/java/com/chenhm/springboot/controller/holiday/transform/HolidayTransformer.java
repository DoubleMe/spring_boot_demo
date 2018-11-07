package com.chenhm.springboot.controller.holiday.transform;

import com.chenhm.springboot.controller.holiday.response.HolidayConfigVO;
import com.chenhm.springboot.controller.holiday.resquest.HolidayListRequest;
import com.chenhm.springboot.manager.holiday.bo.HolidayConfigBO;

/**
 * @author Hongmin.Chen1
 * @date 2018/10/24 14:23
 * @since V1.0
 */
public class HolidayTransformer {

    public static HolidayConfigVO toVO(HolidayConfigBO holidayConfigBO) {

        if (holidayConfigBO == null) {
            return null;
        }
        HolidayConfigVO holidayConfigVO = new HolidayConfigVO();
        holidayConfigVO.setHolidayYear(holidayConfigBO.getHolidayYear());
        holidayConfigVO.setStartDate(holidayConfigBO.getStartDate());
        holidayConfigVO.setEndDate(holidayConfigBO.getEndDate());
        holidayConfigVO.setHolidayType(holidayConfigBO.getHolidayType());
        holidayConfigVO.setOperator(holidayConfigBO.getOperator());
        holidayConfigVO.setCreateTime(holidayConfigBO.getCreateTime());
        holidayConfigVO.setUpdateTime(holidayConfigBO.getUpdateTime());
        return holidayConfigVO;
    }

    public static HolidayConfigBO listReqToBO(HolidayListRequest holidayListResquest) {

        if (holidayListResquest == null) {
            return null;
        }
        HolidayConfigBO holidayConfigBO = new HolidayConfigBO();
        holidayConfigBO.setHolidayYear(holidayListResquest.getHolidayYear());
        holidayConfigBO.setStartDate(holidayListResquest.getStartDate());
        holidayConfigBO.setEndDate(holidayListResquest.getEndDate());
        holidayConfigBO.setHolidayType(holidayListResquest.getHolidayType());
        holidayConfigBO.setOperator(holidayListResquest.getOperator());
        holidayConfigBO.setCreateTime(holidayListResquest.getCreateTime());
        holidayConfigBO.setUpdateTime(holidayListResquest.getUpdateTime());
        return holidayConfigBO;
    }
}
