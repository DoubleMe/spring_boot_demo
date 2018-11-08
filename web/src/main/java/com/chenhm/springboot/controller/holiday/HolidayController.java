package com.chenhm.springboot.controller.holiday;

import com.chenhm.springboot.common.PageQueryBO;
import com.chenhm.springboot.common.PageResultBO;
import com.chenhm.springboot.common.response.PageResponse;
import com.chenhm.springboot.common.response.ResponseUtils;
import com.chenhm.springboot.controller.holiday.response.HolidayConfigVO;
import com.chenhm.springboot.controller.holiday.resquest.HolidayListRequest;
import com.chenhm.springboot.controller.holiday.transform.HolidayTransfer;
import com.chenhm.springboot.manager.holiday.HolidayConfigManager;
import com.chenhm.springboot.manager.holiday.bo.HolidayConfigBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * HelloController
 *
 * @author chen-hongmin
 * @date 2018-08-08
 * @since 1.0.0
 */

@RestController
public class HolidayController {

    @Autowired
    private HolidayConfigManager holidayConfigManager;

    @RequestMapping("/list")
    @ResponseBody
    public PageResponse<HolidayConfigVO> list(HolidayListRequest request) {


        PageQueryBO<HolidayConfigBO> pageQueryBO = PageQueryBO.instance(request, HolidayTransfer::listReqToBO);
        pageQueryBO.pageSize(request.getPageSize()).pageNum(request.getPageNum());

        PageResultBO<HolidayConfigBO> pageResultBO = holidayConfigManager.list(pageQueryBO);
        return ResponseUtils.loadPageList(pageResultBO, HolidayTransfer::toVO);
    }
}