package com.chenhm.springboot.controller;

import com.chenhm.springboot.common.ResponseUtils;
import com.chenhm.springboot.controller.vo.HolidayConfigVO;
import com.chenhm.springboot.mapper.dataobject.HolidayConfigDO;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
    public String index() {

        throw new RuntimeException("hello world");
    }

    @RequestMapping("/validate")
    @ResponseBody
    public Object validate(@Valid HolidayConfigDO holidayConfigDO, BindingResult result) {

        return ResponseUtils.load(holidayConfigDO, holiday -> {

            HolidayConfigVO holidayConfigVO = new HolidayConfigVO();
            holidayConfigVO.setHolidayType(holiday.getHolidayType() + 100);
            holidayConfigVO.setHolidayYear(holiday.getHolidayYear());

            return holidayConfigVO;
        });
    }
}