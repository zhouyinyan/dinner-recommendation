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
}
