package com.chenhm.springboot.dao;

import java.util.List;

import com.chenhm.springboot.common.PageListFilter;
import com.chenhm.springboot.dao.dataobject.CntMaterialDO;

/**
 * 素材库
 *
 * @author chen-hongmin
 * @date 2018-09-20 16:07:07
 * @since V1.0
 */
public interface CntMaterialDAO {
    /**
     * 新增
     *
     * @param cntMaterialDO
     * @return int
     */
    int insert(CntMaterialDO cntMaterialDO);

    /**
     * 更新
     *
     * @param cntMaterialDO
     * @return int
     */
    int update(CntMaterialDO cntMaterialDO);

    /**
     * 主键查询
     *
     * @param id
     * @return CntMaterialDO
     */
    CntMaterialDO getById(Long id);

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
    List<CntMaterialDO> list(PageListFilter<CntMaterialDO> filter);

}