package com.chenhm.springboot.controller.holiday.resquest;

import com.chenhm.common.PageRequest;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Hongmin.Chen1
 * @date 2018/10/24 14:51
 * @since V1.0
 */
@Data
public class HolidayListRequest extends PageRequest {

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
