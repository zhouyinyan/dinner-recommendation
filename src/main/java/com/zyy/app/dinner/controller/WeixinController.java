package com.zyy.app.dinner.controller;

import com.zyy.app.dinner.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by zhouyinyan on 2019/3/29.
 */
@RestController
public class WeixinController {

    public static final String token = "zhouyinyan_ai_xsp";

    @RequestMapping("/wx")
    public String echo(String signature, String timestamp, String nonce, String echostr) throws NoSuchAlgorithmException {
        List<String> list = new ArrayList<>(Arrays.asList(token, timestamp, nonce));
        list.sort(Comparator.naturalOrder());
        StringJoiner stringJoiner = new StringJoiner("");
        list.forEach(e -> stringJoiner.add(e));
        String sha1DigestAsHex = DigestUtils.sha1DigestAsHex(stringJoiner.toString().getBytes());
        if(sha1DigestAsHex.equals(signature)){
            return echostr;
        }else{
            return "check fail~~~";
        }
    }
}
