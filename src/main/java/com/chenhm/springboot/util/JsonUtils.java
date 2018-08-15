package com.chenhm.springboot.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author chen-hongmin
 * @since 2017/11/6 16:56
 */
public class JsonUtils {

    private static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
    }


    public static String toJSONString(Object obj) {

        String json = null;
        try {
            json = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }

    /**
     * json to obj
     *
     * @param json
     * @param clz
     * @param <T>
     * @return
     */
    public static <T> T parseObject(String json, Class<T> clz) {

        try {
            return objectMapper.readValue(json, clz);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}

