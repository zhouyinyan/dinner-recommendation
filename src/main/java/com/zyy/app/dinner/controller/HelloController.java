package com.zyy.app.dinner.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhouyinyan on 2019/3/27.
 */
@RestController
public class HelloController {

    @RequestMapping({"/","/hello"})
    public String hello(){
        return "hello,dinner";
    }

    @RequestMapping("/hello2")
    public String hello2(){
        return "hello2,dinner";
    }
}
