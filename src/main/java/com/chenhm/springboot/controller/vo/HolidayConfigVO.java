package com.chenhm.springboot.controller.vo;

/**
 * @author chen-hongmin
 * @date 2018/8/15 10:16
 * @since V1.0
 */
public class HolidayConfigVO {


    /**
     * 年份
     */
    private Integer holidayYear;


    /**
     * 节假日类型
     */
    private Integer holidayType;

    public Integer getHolidayYear() {

        return holidayYear;
    }

    public void setHolidayYear(Integer holidayYear) {

        this.holidayYear = holidayYear;
    }

    public Integer getHolidayType() {

        return holidayType;
    }

    public void setHolidayType(Integer holidayType) {

        this.holidayType = holidayType;
    }
}
