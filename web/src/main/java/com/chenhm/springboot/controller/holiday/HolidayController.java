package com.chenhm.springboot.controller.holiday;

import com.chenhm.common.PageQuery;
import com.chenhm.common.PageResult;
import com.chenhm.springboot.controller.holiday.response.HolidayConfigVO;
import com.chenhm.common.response.Response;
import com.chenhm.common.response.ResponseUtils;
import com.chenhm.springboot.controller.holiday.resquest.HolidayListRequest;
import com.chenhm.springboot.controller.holiday.transform.HolidayTransfer;
import com.chenhm.springboot.manager.holiday.HolidayConfigManager;
import com.chenhm.springboot.manager.holiday.bo.HolidayConfigBO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * HolidayController
 *
 * @author chen-hongmin
 * @date 2018-08-08
 * @since 1.0.0
 */

@RestController
public class HolidayController {

    @Resource
    private HolidayConfigManager holidayConfigManager;

    @RequestMapping("/list")
    @ResponseBody
    public Response<PageResult<HolidayConfigVO>> list(HolidayListRequest request) {

        PageQuery<HolidayConfigBO> pageQueryBO = PageQuery.instance(request, HolidayTransfer::listReqToBO);
        pageQueryBO.pageSize(request.getPageSize()).pageNum(request.getPageNum());

        PageResult<HolidayConfigBO> pageResultBO = holidayConfigManager.list(pageQueryBO);
        return ResponseUtils.loadPageList(pageResultBO, HolidayTransfer::toVO);
    }
}