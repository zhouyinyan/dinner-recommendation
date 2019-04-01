package com.zyy.app.dinner.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.weixin4j.WeixinException;
import org.weixin4j.model.menu.ClickButton;
import org.weixin4j.model.menu.Menu;
import org.weixin4j.model.menu.SingleButton;
import org.weixin4j.spi.IMessageHandler;
import org.weixin4j.spring.WeixinTemplate;
import org.weixin4j.util.TokenUtil;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhouyinyan on 2019/3/29.
 */
@RestController
@RequestMapping("/wx/mgr")
public class WeixinManagerController {

    public static final Logger LOGGER = LoggerFactory.getLogger(WeixinManagerController.class);

    @Autowired
    WeixinTemplate weixinTemplate;

    //菜单管理（未认证，不能申请对应接口权限）
    /**
     * 创建自定义菜单
     *
     * @param response
     * @throws IOException
     */
    @RequestMapping("/menu/create")
    public void createMenu(HttpServletResponse response) throws IOException {
        Menu menu = new Menu();
        menu.getButton().add(new ClickButton("查询菜谱", "query_cook"));
        menu.getButton().add(new ClickButton("推荐菜谱", "recommend_cook"));
        try {
            weixinTemplate.menu().create(menu);
            writeResponseMessage(response, "菜单创建成功");

        } catch (WeixinException e) {
            e.printStackTrace();
            writeResponseMessage(response, e.getMessage());
        }

    }

    /**
     * 写返回消息
     *
     * @param response
     * @param message
     * @throws IOException
     */
    private void writeResponseMessage(HttpServletResponse response, String message) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain");
        response.getWriter().write(message);
    }


}
