package com.chenhm.springboot.util;

import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

/**
 * @author chen-hongmin
 * @date 2018/8/10 17:57
 * @since V1.0
 */
public class RestClient {

    /**
     * 获取RestTemplate
     * 修改StringHttpMessageConverter 的编码 和支持的类型
     *
     * @returnRestTemplate
     */
    public static RestTemplate restTemplate() {

        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> converters = restTemplate.getMessageConverters();
        //修改StringHttpMessageConverter 的编码 和支持的类型
        for (HttpMessageConverter converter : converters) {
            if (converter instanceof StringHttpMessageConverter) {

                StringHttpMessageConverter httpMessageConverter = (StringHttpMessageConverter) converter;
                httpMessageConverter.setDefaultCharset(Charset.forName("utf-8"));
                httpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_HTML, MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML));
            }
        }
        return restTemplate;
    }

    /**
     * Execute the HTTP method to the given URI template, writing the given request entity to the request, and
     * returns the response as {@link ResponseEntity body}.
     *
     * @param url        http 地址
     * @param httpMethod @see the #org.springframework.http.HttpMethod
     * @param entity     entity
     * @param clz        类型
     * @param <T>
     * @return the response body
     */
    public static <T> T exchange(String url, HttpMethod httpMethod, HttpEntity entity, Class<T> clz) {

        ResponseEntity<T> exchange = restTemplate().exchange(url, httpMethod, entity, clz);
        return exchange.getBody();
    }

    /**
     * Execute the HTTP get method to the given URI template, writing the given request entity to the request, and
     * returns the response as {@link ResponseEntity body}.
     *
     * @param url http 地址
     * @param clz 类型
     * @param <T>
     * @return the response body
     */
    public static <T> T get(String url, HttpHeaders headers, Class<T> clz) {

        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<T> exchange = restTemplate().exchange(url, HttpMethod.GET, entity, clz);

        return exchange.getBody();
    }

    /**
     * Execute the HTTP get method to the given URI template, writing the given request entity to the request, and
     * returns the response as {@link ResponseEntity body}.
     *
     * @param url http 地址
     * @param clz 类型
     * @param <T>
     * @return the response body
     */
    public static <T> T get(String url, Class<T> clz) {

        ResponseEntity<T> exchange = restTemplate().getForEntity(url, clz);

        return exchange.getBody();
    }


}
