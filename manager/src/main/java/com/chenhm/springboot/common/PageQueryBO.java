package com.chenhm.springboot.common;

import lombok.Data;

import java.util.function.Function;

/**
 * @author Hongmin.Chen1
 * @date 2018/10/23 19:39
 * @since V1.0
 */

@Data
public class PageQueryBO<T> {

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
    private Boolean count;

    /**
     * 是否分页
     */
    private Boolean pageEnable;

    /**
     * 排序字段
     */
    private String orderBy;

    /**
     * 查询条件
     */
    private T query;

    private PageQueryBO() {

    }

    public static <T> PageQueryBO<T> instance(T query) {

        PageQueryBO<T> pageQueryBO = new PageQueryBO<>();
        pageQueryBO.setQuery(query);

        return pageQueryBO;
    }

    public static <T, R> PageQueryBO<R> instance(T query, Function<T, R> function) {

        PageQueryBO<R> pageQueryBO = new PageQueryBO<>();
        pageQueryBO.setQuery(function.apply(query));

        return pageQueryBO;
    }

    public PageQueryBO pageNum(Integer pageNum) {

        this.setPageNum(pageNum);
        return this;
    }

    public PageQueryBO pageSize(Integer pageSize) {

        this.setPageSize(pageSize);
        return this;
    }

    public PageQueryBO count(Boolean count) {

        this.setCount(count);
        return this;
    }

    public PageQueryBO pageEnable(Boolean pageEnable) {

        this.setPageEnable(pageEnable);
        return this;
    }

    public PageQueryBO orderBy(String orderBy) {

        this.setOrderBy(orderBy);
        return this;
    }
}
