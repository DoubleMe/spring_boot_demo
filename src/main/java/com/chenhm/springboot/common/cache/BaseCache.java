package com.chenhm.springboot.common.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author chen-hongmin
 * @date 2018/8/15 14:06
 * @since V1.0
 */

@Component
public class BaseCache {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    public String get(String key) {

        return redisTemplate.opsForValue().get(key);
    }

    public void set(String key, String object) {

         redisTemplate.opsForValue().set(key,object);
    }


}
