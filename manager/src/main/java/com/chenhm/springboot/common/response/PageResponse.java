package com.chenhm.springboot.common.response;

import lombok.Data;

import java.util.List;

/**
 * @author Hongmin.Chen1
 * @date 2018/10/24 14:18
 * @since V1.0
 */
@Data
public class PageResponse<T> extends BaseResponse<T> {

    /**
     * data
     */
    private List<T> data;

    /**
     * 页码
     */
    private Integer pageNum;

    /**
     * 每页数量
     */
    private Integer pageSize;
    /**
     * 是否有下一页
     */
    private Boolean hasNext;

    /**
     * 总数
     */
    private Long total;
}
