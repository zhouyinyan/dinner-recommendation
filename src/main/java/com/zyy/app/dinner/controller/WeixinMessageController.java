package com.zyy.app.dinner.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.weixin4j.WeixinException;
import org.weixin4j.spi.IMessageHandler;
import org.weixin4j.util.TokenUtil;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhouyinyan on 2019/3/29.
 */
@RestController
@RequestMapping("/wx")
public class WeixinMessageController {

    public static final String token = "zhouyinyan_ai_xsp";
    public static final Logger LOGGER = LoggerFactory.getLogger(WeixinMessageController.class);

    @Autowired
    private IMessageHandler messageHandler;

    //开发者接入验证
    @RequestMapping(method = RequestMethod.GET)
    public void get(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.验证消息真实性
        //http://mp.weixin.qq.com/wiki/index.php?title=验证消息真实性
        //成为开发者验证
        String echostr = request.getParameter("echostr");

        try {
            if(checkRequestFromWeixin(request)){
                //确认此次GET请求来自微信服务器，原样返回echostr参数内容，则接入生效，成为开发者成功，否则接入失败
                response.getWriter().write(echostr);
            }else{
                throw new IllegalArgumentException("签名校验错误");
            }
        } catch (Exception e) {
            writeErrorMessage(response, e.getMessage());
        }

    }

    //接收微信消息
    @RequestMapping(method = RequestMethod.POST)
    public void post(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            if(!checkRequestFromWeixin(request)){
                throw new IllegalArgumentException("签名校验错误");
            }else{
                //消息处理
                process(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.debug("处理微信消息错误-->{}",e.getMessage());
            writeErrorMessage(response, e.getMessage());
        }


    }

    /**
     * 微信消息处理
     *
     * @param request
     * @param response
     */
    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //用户每次向公众号发送消息、或者产生自定义菜单点击事件时，响应URL将得到推送
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/xml");
            //获取POST流
            ServletInputStream in = request.getInputStream();
            //处理输入消息，返回结果
            String xml = messageHandler.invoke(in);
            //返回结果
            response.getWriter().write(xml);
        } catch (IOException | WeixinException e) {
            //异常处理返回空（告知微信服务器接受到消息）
            response.getWriter().write("");
        }
    }


    /**
     * 检查请求来源是否来自weixin服务器
     *
     * @param request
     * @return
     */
    private boolean checkRequestFromWeixin(HttpServletRequest request){
        //消息来源可靠性验证
        String signature = request.getParameter("signature");// 微信加密签名
        String timestamp = request.getParameter("timestamp");// 时间戳
        String nonce = request.getParameter("nonce");       // 随机数
        Assert.hasLength(signature, "signature 不能为空");
        Assert.hasLength(timestamp, "timestamp 不能为空");
        Assert.hasLength(nonce, "nonce 不能为空");
        return TokenUtil.checkSignature(token, signature, timestamp, nonce);
    }

    /**
     * 返回错误消息
     *
     * @param response
     * @param errorMessage
     * @throws IOException
     */
    private void writeErrorMessage(HttpServletResponse response, String errorMessage) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain");
        response.getWriter().write(errorMessage);
    }
}
