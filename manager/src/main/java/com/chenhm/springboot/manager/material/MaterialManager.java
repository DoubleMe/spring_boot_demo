package com.chenhm.springboot.manager.material;

import com.chenhm.springboot.mapper.material.domain.MaterialDO;

import java.util.List;

/**
 * 素材库
 *
 * @author chen-hongmin
 * @date 2018-09-20 16:07:07
 * @since V1.0
 */
public interface MaterialManager {
    /**
     * 新增
     *
     * @param cntMaterialDO
     * @return int
     */
    int insert(MaterialDO cntMaterialDO);

    /**
     * 更新
     *
     * @param cntMaterialDO
     * @return int
     */
    int update(MaterialDO cntMaterialDO);

    /**
     * 主键查询
     *
     * @param id
     * @return CntMaterialDO
     */
    MaterialDO getById(Long id);

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
     * @param filter
     * @return List<CntMaterialDO>
     */
    List<MaterialDO> list(MaterialDO filter);

}