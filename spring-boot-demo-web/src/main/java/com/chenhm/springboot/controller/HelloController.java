package com.chenhm.springboot.controller;

import com.chenhm.springboot.common.ResponseUtils;
import com.chenhm.springboot.controller.vo.HolidayConfigVO;
import com.chenhm.springboot.dao.dataobject.HolidayConfigDO;
import com.chenhm.springboot.util.JsonUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;

/**
 * HelloController
 *
 * @author chen-hongmin
 * @date 2018-08-08
 * @since 1.0.0
 */

@RestController
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public Object index() {

        return LocalDateTime.now();
    }

    @RequestMapping("/validate")
    @ResponseBody
    public Object validate(@Valid @RequestBody HolidayConfigDO holidayConfigDO, BindingResult result) {

        return ResponseUtils.load(holidayConfigDO, holiday -> {

            HolidayConfigVO holidayConfigVO = new HolidayConfigVO();
            holidayConfigVO.setHolidayType(holiday.getHolidayType());
            holidayConfigVO.setHolidayYear(holiday.getHolidayYear());
            holidayConfigVO.setCreateTime(holiday.getCreateTime());
            holidayConfigVO.setEndDate(holiday.getEndDate());

            return holidayConfigVO;
        });
    }

}