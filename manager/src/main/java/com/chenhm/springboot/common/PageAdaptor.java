package com.chenhm.springboot.common;

import com.chenhm.springboot.common.constant.BizConstants;
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
    public static <T> Page start(PageQueryBO<T> pageQueryBO) {

        if (pageQueryBO.getPageEnable() != null && !pageQueryBO.getPageEnable()) {
            return null;
        }
        boolean count = pageQueryBO.getCount() == null ? false : pageQueryBO.getCount();
        int pageNum = pageQueryBO.getPageNum() == null ? BizConstants.DEFAULT_PAGE_NUM : pageQueryBO.getPageNum();
        int pageSize = pageQueryBO.getPageSize() == null ? BizConstants.DEFAULT_PAGE_SIZE : pageQueryBO.getPageSize();

        Page page = PageHelper.startPage(pageNum, pageSize, count);
        if (!StringUtils.isEmpty(pageQueryBO.getOrderBy())) {
            PageHelper.orderBy(pageQueryBO.getOrderBy());
        }
        return page;
    }

    /**
     * 分页结果处理
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> PageResultBO<T> processResult(Page page, List<T> list) {

        PageResultBO<T> pageResultBO = new PageResultBO<>();
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
