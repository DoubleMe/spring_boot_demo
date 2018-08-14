package com.chenhm.springboot.controller;

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
    public String validate(@Valid HolidayConfigDO holidayConfigDO, BindingResult result) {

        System.out.println(result.hasErrors());
        return "ss";
    }
}