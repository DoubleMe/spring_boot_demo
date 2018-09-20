package com.chenhm.springboot.hello;

import com.chenhm.springboot.BaseControllerTest;
import org.junit.Test;

/**
 * @author chen-hongmin
 * @date 2018/8/8 16:58
 * @since V1.0
 */

public class HelloControllerTest extends BaseControllerTest {


    @Test
    public void getHello() {

        String doGet = doGet("/hello");
        System.out.println(doGet);
    }
    @Test
    public void getValidate() {

        String doGet = doGet("/validate");
        System.out.println(doGet);
    }
}