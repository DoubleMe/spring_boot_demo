package com.chenhm.springboot.manager.holiday;


import com.chenhm.springboot.manager.holiday.bo.HolidayConfigBO;
import com.chenhm.springboot.common.PageQueryBO;
import com.chenhm.springboot.common.PageResultBO;

/**
 * 节假日配置表
 *
 * @author chen-hongmin
 * @date 2018-06-29 13:47:20
 * @since V1.0
 */
public interface HolidayConfigManager {
    /**
     * 新增
     *
     * @param holidayConfigBO
     * @return int
     */
    void insert(HolidayConfigBO holidayConfigBO);

    /**
     * 更新
     *
     * @param holidayConfigBO
     * @return int
     */
    void update(HolidayConfigBO holidayConfigBO);

    /**
     * 主键查询
     *
     * @param id
     * @return HolidayConfigBO
     */
    HolidayConfigBO getById(Long id);

    /**
     * 根据主键删除
     *
     * @param id
     * @return int
     */
    void delById(Long id);

    /**
     * 列表查询 pageQueryBO
     *
     * @param pageQueryBO
     * @return List<HolidayConfigDO>
     */
    PageResultBO<HolidayConfigBO> list(PageQueryBO<HolidayConfigBO> pageQueryBO);

}