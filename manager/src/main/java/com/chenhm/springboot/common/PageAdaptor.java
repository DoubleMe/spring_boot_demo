package com.chenhm.springboot.common;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author Hongmin.Chen1
 * @date 2018/10/23 19:46
 * @since V1.0
 */
public class PageAdaptor {

    /**
     * 开始分页
     *
     * @param pageQueryBO
     * @param <T>
     */
    public static <T> void start(PageQueryBO<T> pageQueryBO) {

        if (pageQueryBO.getPageEnable() != null && !pageQueryBO.getPageEnable()) {
            return;
        }
        boolean count = pageQueryBO.getCount() == null ? false : pageQueryBO.getCount();
        PageHelper.startPage(pageQueryBO.getPageNum(), pageQueryBO.getPageSize(), count);
        if (!StringUtils.isEmpty(pageQueryBO.getOrderBy())) {
            PageHelper.orderBy(pageQueryBO.getOrderBy());
        }
    }

    /**
     * 分页结果处理
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> PageResultBO<T> processResult(List<T> list) {

        PageResultBO<T> pageResultBO = new PageResultBO<>();
        Page page = PageHelper.getLocalPage();

        pageResultBO.setData(list);
        if (page != null) {
            pageResultBO.setPageNum(page.getPageNum());
            pageResultBO.setPageSize(page.getPageSize());
            pageResultBO.setTotal(page.getTotal());
            pageResultBO.setHasNext(page.getPages() > page.getPageNum());
        }
        return pageResultBO;
    }
}
