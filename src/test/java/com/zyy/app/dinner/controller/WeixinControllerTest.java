package com.zyy.app.dinner.controller;

import com.zyy.app.dinner.DigestUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by zhouyinyan on 2019/3/27.
 */
@WebMvcTest(WeixinController.class)
public class WeixinControllerTest extends BaseMvcTest{

    protected static final Logger logger = LoggerFactory.getLogger(WeixinControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHello() throws Exception {
        logger.info("测试Weixin控制器的echo().....开始");
        String timestamp = "timestamp111";
        String nonce = "saldfaslfjas";
        String echostr = "echostr111";

        MockHttpServletRequestBuilder requestBuilder =
                MockMvcRequestBuilders.get("/wx")
                        .param("timestamp", timestamp)
                        .param("nonce", nonce)
                        .param("echostr", echostr)
                        .param("signature", sign(timestamp, nonce, WeixinController.token))
                        .accept(MediaType.ALL);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string(echostr));
        logger.info("测试Weixin控制器的echo().....通过");
    }

    private String sign(String timestamp, String nonce, String token){
        List<String> list = new ArrayList<>(Arrays.asList(token, timestamp, nonce));
        list.sort(Comparator.naturalOrder());
        StringJoiner stringJoiner = new StringJoiner("");
        list.forEach(e -> stringJoiner.add(e));
        return DigestUtils.sha1DigestAsHex(stringJoiner.toString().getBytes());
    }


}
