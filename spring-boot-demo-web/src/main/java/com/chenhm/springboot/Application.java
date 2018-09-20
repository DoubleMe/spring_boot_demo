package com.chenhm.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sun.misc.Unsafe;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;


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

//        SpringApplication.run(Application.class, args);

        ConcurrentHashMap map = new ConcurrentHashMap(16);
        for (int i = 1; i < 100; i++){
            map.put(i,"a");
        }
    }


}
