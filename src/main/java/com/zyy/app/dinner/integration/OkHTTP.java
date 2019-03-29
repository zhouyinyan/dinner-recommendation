package com.zyy.app.dinner.integration;

import com.zyy.app.dinner.integration.mob.ResponseHandler;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * 集成OKHTTP
 * Created by zhouyinyan on 2019/3/29.
 */
public class OkHTTP {

    static final Logger logger = LoggerFactory.getLogger(OkHTTP.class);

    final static OkHttpClient client = new OkHttpClient();

    public static  <T> T call(String url, ResponseHandler<T> responseHandler) {
        logger.debug("begin http call, url: {} ", url);
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        Call call = client.newCall(request);

        try {
            Response response = call.execute();
            logger.debug("end http call, response: {} ", response);
            return responseHandler.handler(response);
        } catch (IOException e) {
            e.printStackTrace();
            //todo 异常处理（重试？）
            logger.error("http call error, exception : {} ", e);
            return null;
        }

    }
}
