package com.chenhm.springboot.mapper.holiday;


import com.chenhm.springboot.mapper.holiday.domain.HolidayConfigDO;

import java.util.List;

/**
 * 节假日配置表
 *
 * @author chen-hongmin
 * @date 2018-06-29 13:47:20
 * @since V1.0
 */
public interface HolidayConfigMapper {
    /**
     * 新增
     *
     * @param holidayConfigDO
     * @return int
     */
    int insert(HolidayConfigDO holidayConfigDO);

    /**
     * 更新
     *
     * @param holidayConfigDO
     * @return int
     */
    int update(HolidayConfigDO holidayConfigDO);

    /**
     * 主键查询
     *
     * @param id
     * @return THolidayConfigDO
     */
    HolidayConfigDO getById(Long id);

    /**
     * 根据主键删除
     *
     * @param id
     * @return int
     */
    int delById(Long id);

    /**
     * 列表查询
     *
     * @return List<HolidayConfigDO>
     */
    List<HolidayConfigDO> list(HolidayConfigDO holidayConfigDO);

}