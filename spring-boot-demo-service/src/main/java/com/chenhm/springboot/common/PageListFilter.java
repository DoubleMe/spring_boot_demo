package com.chenhm.springboot.common;

/**
 * @author chen-hongmin
 * @date 2018/9/20 16:53
 * @since V1.0
 */
public class PageListFilter<T> {

    private T data;

    private Integer pageNum;

    private Integer pageSize;

    public T getData() {

        return data;
    }

    public void setData(T data) {

        this.data = data;
    }

    public Integer getPageNum() {

        return pageNum;
    }

    public void setPageNum(Integer pageNum) {

        this.pageNum = pageNum;
    }

    public Integer getPageSize() {

        return pageSize;
    }

    public void setPageSize(Integer pageSize) {

        this.pageSize = pageSize;
    }
}
