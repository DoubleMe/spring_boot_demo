package com.chenhm.common;

import lombok.Data;

/**
 * @author Hongmin.Chen1
 * @date 2018/10/24 15:03
 * @since V1.0
 */
@Data
public class PageRequest {

    /**
     * 页码
     */
    private Integer pageNum;

    /**
     * 每页大小
     */
    private Integer pageSize;
}
