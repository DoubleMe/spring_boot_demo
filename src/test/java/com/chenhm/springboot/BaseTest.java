package com.chenhm.springboot;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author chen-hongmin
 * @date 2018/8/15 14:27
 * @since V1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"env=dev"})
public class BaseTest {
}
