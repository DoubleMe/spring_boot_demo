package com.chenhm.springboot.dao.dataobject;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 节假日配置表
 *
 * @author chen-hongmin
 * @date 2018-06-29 13:47:20
 * @since V1.0
 */
public class HolidayConfigDO {

    private Long id;

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


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getHolidayYear() {
        return this.holidayYear;
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
        return this.holidayType;
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