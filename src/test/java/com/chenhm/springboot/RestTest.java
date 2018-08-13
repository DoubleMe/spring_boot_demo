package com.chenhm.springboot;

import com.chenhm.springboot.util.RestClient;

import java.net.URLDecoder;

/**
 * @author chen-hongmin
 * @date 2018/8/10 16:51
 * @since V1.0
 */
public class RestTest {

//    private static final String url = "https://www.csdn.net/api/articles?type=more&category=home&shown_offset=1533892047397053";
    private static final String url = "http://www.atzuche.com/car/searchListMap/1?cityCode=330100&sceneCode=U002&filterCondition%5Blon%5D=120.219294&filterCondition%5Blat%5D=30.259258&filterCondition%5Bseq%5D=4&pageNum=1&pageSize=18";


    public static void main(String[] args) throws Exception{

        String exchange = RestClient.get(URLDecoder.decode(url, "utf-8"), String.class);
        System.out.println(exchange);
    }
}
