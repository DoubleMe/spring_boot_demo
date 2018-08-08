package com.chenhm.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 *
 * @author chen-hongmin
 * @date 2018-08-08
 * @since 1.0.0
 */

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {

        return "Hello Spring Boot 2.0!";
    }
}