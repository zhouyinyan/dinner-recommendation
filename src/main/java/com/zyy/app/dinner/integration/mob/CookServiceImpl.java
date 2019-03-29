package com.zyy.app.dinner.integration.mob;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zyy.app.dinner.integration.OkHTTP;
import com.zyy.app.dinner.integration.ResponseHandler;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by zhouyinyan on 2019/3/29.
 */
@Service
public class CookServiceImpl implements CookService {
    private static final String DINNER_APP_KEY = "2aa3c61ed499d";

    private static final String COOKIE_DETAIL_API_URL = "http://apicloud.mob.com/v1/cook/menu/query?key="+DINNER_APP_KEY;

    protected static Logger logger = LoggerFactory.getLogger(CategoryInfoResponseHandler.class);

    @Override
    public CookItem queryById(String id) {
        CookItemResponse response = OkHTTP.call(COOKIE_DETAIL_API_URL + "&id=" + id, res -> {
            try {
                String body = res.body().string();
                logger.debug(body);
                return new ObjectMapper().readValue(body, CookItemResponse.class);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        });

        return response.getResult();
    }
}
