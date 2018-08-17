package com.chenhm.springboot.controller.vo;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author chen-hongmin
 * @date 2018/8/15 10:16
 * @since V1.0
 */
public class HolidayConfigVO {


    /**
     * 年份
     */
    @NotNull(message = "假期年份不能为空")
    private Integer holidayYear;

    /**
     * 开始日期
     */
    @NotNull(message = "假期开始日期不能为空")
    private LocalDate startDate;

    /**
     * 结束日期
     */
    @NotNull(message = "假期结束日期不能为空")
    private LocalDate endDate;

    /**
     * 节假日类型
     */

    @Range(min = 1,max = 7,message = "节假日类型不正确")
    @NotNull(message = "节假日类型不正确")
    private Integer holidayType;

    /**
     * 操作人Id
     */
    private String operator;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    public Integer getHolidayYear() {

        return holidayYear;
    }

    public void setHolidayYear(Integer holidayYear) {

        this.holidayYear = holidayYear;
    }

    public LocalDate getStartDate() {

        return startDate;
    }

    public void setStartDate(LocalDate startDate) {

        this.startDate = startDate;
    }

    public LocalDate getEndDate() {

        return endDate;
    }

    public void setEndDate(LocalDate endDate) {

        this.endDate = endDate;
    }

    public Integer getHolidayType() {

        return holidayType;
    }

    public void setHolidayType(Integer holidayType) {

        this.holidayType = holidayType;
    }

    public String getOperator() {

        return operator;
    }

    public void setOperator(String operator) {

        this.operator = operator;
    }

    public LocalDateTime getCreateTime() {

        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {

        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {

        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {

        this.updateTime = updateTime;
    }
}
