package com.zyy.app.dinner.integration.mob;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zyy.app.dinner.integration.OkHTTP;
import com.zyy.app.dinner.integration.mob.model.PagedResult;
import com.zyy.app.dinner.integration.mob.model.CookItem;
import com.zyy.app.dinner.integration.mob.model.Response;
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

    private static final String COOK_DETAIL_API_URL = "http://apicloud.mob.com/v1/cook/menu/query?key="+DINNER_APP_KEY;
    private static final String COOK_PAGE_API_URL = "http://apicloud.mob.com/v1/cook/menu/search?key="+DINNER_APP_KEY;

    protected static Logger logger = LoggerFactory.getLogger(CookServiceImpl.class);

    @Override
    public CookItem queryById(String id) {
        Response<CookItem> response = OkHTTP.call(COOK_DETAIL_API_URL + "&id=" + id, res -> {
            try {
                String body = res.body().string();
                logger.debug(body);
                return new ObjectMapper().readValue(body, Response.CookItemResponse.class);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        });

        return response.getResult();
    }

    @Override
    public PagedResult<CookItem> queryByCtgId(String CategoryId, int page, int size) {
        Response<PagedResult<CookItem>> response = OkHTTP.call(COOK_PAGE_API_URL + "&cid=" + CategoryId + "&page=" + page + "&size=" + size, (ResponseHandler<Response<PagedResult<CookItem>>>) res -> {
            try {
                String body = res.body().string();
                logger.debug(body);
                return new ObjectMapper().readValue(body, Response.PagedCookItemResponse.class);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        });
        PagedResult<CookItem> result = response.getResult();
        result.setSize(size);
        return result;
    }
}
