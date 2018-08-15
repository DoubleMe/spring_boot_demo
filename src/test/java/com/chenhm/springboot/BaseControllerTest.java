package com.chenhm.springboot;

import com.chenhm.springboot.util.JsonUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.FileInputStream;
import java.net.URI;
import java.util.Map;

/**
 * @author chen-hongmin
 * @date 2018/8/15 10:29
 * @since V1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"env=dev"})
@AutoConfigureMockMvc
public class BaseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private String host = "http://127.0.0.1:8080/hello";

    /**
     * http post request
     *
     * @param url
     * @return
     */
    public String doGet(String url) {

        url = host + url;
        try {
            MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET, new URI(url))
                    .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_FORM_URLENCODED)).andReturn();
            MockHttpServletResponse response = mvcResult.getResponse();


            System.out.println("测试URI: " + url);
            if (response.getStatus() != HttpStatus.OK.value()) {
                throw new RuntimeException("访问 url = " + url + "  出错; status = " + response.getStatus() + " message = " + response.getContentAsString());
            }

            System.out.println("<result>");
            System.out.println(response.getContentAsString());
            System.out.println("<result/>");

            return response.getContentAsString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * http post request
     *
     * @param url
     * @param param
     * @return
     */
    public String doPost(String url, Map<String, Object> param) {

        url = host + url;
        try {
            MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.POST, new URI(url))
                    .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                    .content(JsonUtils.toJSONString(param))).andReturn();
            MockHttpServletResponse response = mvcResult.getResponse();


            System.out.println("测试URI: " + url);
            System.out.println("<param>");
            System.out.println(JsonUtils.toJSONString(param));
            System.out.println("</param>");
            if (response.getStatus() != 200) {
                throw new RuntimeException("访问 url = " + url + "  出错; status = " + response.getStatus() + " message = " + response.getContentAsString());
            }

            System.out.println("<result>");
            System.out.println(response.getContentAsString());
            System.out.println("<result/>");

            return response.getContentAsString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 文件上传
     *
     * @param url
     * @param filePath
     * @return
     * @throws Exception
     */
    public String uploadFile(String url, String filePath, String fileName) throws Exception {

        //把byte[]图片转换成服务器可以都去的MockMultipartFile类型
        MockMultipartFile file = new MockMultipartFile("file", fileName, null, new FileInputStream(filePath));

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.fileUpload(new URI(url))
                .file(file)).andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        System.out.println("<param>");
        System.out.println(JsonUtils.toJSONString(filePath));
        System.out.println("</param>");
        if (response.getStatus() != 200) {
            throw new RuntimeException("访问 url = " + url + "  出错; status = " + response.getStatus() + " message = " + response.getContentAsString());
        }

        System.out.println("<result>");
        System.out.println(response.getContentAsString());
        System.out.println("<result/>");
        return response.getContentAsString();
    }

    @Test
    public void getHello() {

        String doGet = doGet("/");
        System.out.println(doGet);
    }
}
