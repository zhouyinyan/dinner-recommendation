package com.zyy.app.dinner.integration.mob;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zyy.app.dinner.integration.ResponseHandler;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by zhouyinyan on 2019/3/29.
 */
public class CategoryInfoResponseHandler implements ResponseHandler<CategoryInfoResponse> {
    Logger logger = LoggerFactory.getLogger(CategoryInfoResponseHandler.class);
    @Override
    public CategoryInfoResponse handler(Response response) {
        try {
            String body = response.body().string();
            logger.debug(body);
            return new ObjectMapper().readValue(body, CategoryInfoResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
            //todo
            return null;
        }
    }
}
