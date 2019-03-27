package com.zyy.app.dinner.controller;

import com.zyy.app.dinner.DinnerApplicationTests;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by zhouyinyan on 2019/3/27.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class HelloControllerControllerTest {

    protected static final Logger logger = LoggerFactory.getLogger(HelloControllerControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHello() throws Exception {
        logger.info("测试Hello控制器的hello().....开始");
        mockMvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andExpect(content().string("hello,dinner"));
        logger.info("测试Hello控制器的hello().....通过");
    }
}
