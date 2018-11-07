package com.chenhm.springboot.test;

import com.chenhm.springboot.util.JsonUtils;

/**
 * @author Hongmin.Chen1
 * @date 2018/10/25 17:37
 * @since V1.0
 */
public class Main {

    public static void main(String[] args) {

        System.out.println(JsonUtils.toJSONString(new CntLocationPoiDO()));
    }
}
