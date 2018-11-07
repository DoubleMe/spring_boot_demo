package com.chenhm.springboot.mapper.holiday.domain;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 节假日配置表
 *
 * @author chen-hongmin
 * @date 2018-06-29 13:47:20
 * @since V1.0
 */

@Data
public class HolidayConfigDO {

    private Long id;

    /**
     * 年份
     */
    private Integer holidayYear;

    /**
     * 开始日期
     */
    private LocalDate startDate;

    /**
     * 结束日期
     */
    private LocalDate endDate;

    /**
     * 节假日类型
     */

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