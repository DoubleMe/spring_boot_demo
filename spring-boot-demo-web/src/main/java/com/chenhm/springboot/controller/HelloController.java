package com.chenhm.springboot.controller;

import com.chenhm.springboot.common.BaseJsonObject;
import com.chenhm.springboot.common.ResponseCode;
import com.chenhm.springboot.common.ResponseUtils;
import com.chenhm.springboot.controller.vo.HolidayConfigVO;
import com.chenhm.springboot.dao.HolidayConfigMapper;
import com.chenhm.springboot.dao.dataobject.HolidayConfigDO;
import com.chenhm.springboot.util.JsonUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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

    @Resource
    private HolidayConfigMapper holidayConfigMapper;

    @RequestMapping("/hello")
    @ResponseBody
    public Object index() {

        return BaseJsonObject.success().message("成功").data(holidayConfigMapper.list(1,2));
    }

    @RequestMapping("/validate")
    @ResponseBody
    public Object validate(@Valid @RequestBody HolidayConfigDO holidayConfigDO, BindingResult result) {

        return BaseJsonObject.success().message("成功").data(holidayConfigMapper.list(1,2));
    }

}