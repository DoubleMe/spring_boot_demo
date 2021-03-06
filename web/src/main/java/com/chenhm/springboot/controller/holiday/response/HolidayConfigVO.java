package com.chenhm.springboot.controller.holiday.response;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author chen-hongmin
 * @date 2018/8/15 10:16
 * @since V1.0
 */
@Data
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

}
