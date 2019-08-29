package com.chenhm.common;

import lombok.Data;

import java.util.function.Function;

/**
 * @author Hongmin.Chen1
 * @date 2018/10/23 19:39
 * @since V1.0
 */

@Data
public class PageQuery<T> {


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


    private PageQuery() {

    }

    public static <T extends PageRequest> PageQuery<T > instance(T query) {

        PageQuery<T> pageQueryBO = new PageQuery<>();
        pageQueryBO.setQuery(query);
        pageQueryBO.setPageNum(query.getPageNum());
        pageQueryBO.setPageSize(query.getPageSize());

        return pageQueryBO;
    }

    public static <T extends PageRequest, R> PageQuery<R> instance(T query, Function<T, R> function) {

        PageQuery<R> pageQueryBO = new PageQuery<>();
        pageQueryBO.setQuery(function.apply(query));
        pageQueryBO.setPageNum(query.getPageNum());
        pageQueryBO.setPageSize(query.getPageSize());

        return pageQueryBO;
    }



    public PageQuery pageNum(Integer pageNum) {

        this.setPageNum(pageNum);
        return this;
    }

    public PageQuery pageSize(Integer pageSize) {

        this.setPageSize(pageSize);
        return this;
    }

    public PageQuery count(Boolean count) {

        this.setCount(count);
        return this;
    }

    public PageQuery pageEnable(Boolean pageEnable) {

        this.setPageEnable(pageEnable);
        return this;
    }

    public PageQuery orderBy(String orderBy) {

        this.setOrderBy(orderBy);
        return this;
    }
}
