package com.chenhm.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * spring_boot 启动类
 *
 * @author chen-hongmin
 * @date 2018-08-08
 * @since 1.0.0
 */
@MapperScan("com.chenhm.springboot")
@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }


}
