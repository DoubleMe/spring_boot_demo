package com.chenhm.common;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Hongmin.Chen1
 * @date 2018/10/23 19:43
 * @since V1.0
 */
@Data
public class PageResult<T> implements Serializable {

    /**
     * 页码
     */
    private Integer pageNum;

    /**
     * 每页大小
     */
    private Integer pageSize;

    /**
     * 是否计算总数
     */
    private Long total;

    /**
     * 是否有下一页
     */
    private Boolean hasNext;

    /**
     * 查询条件
     */
    private List<T> data;
}
