package com.zyy.app.dinner.integration.mob;

import okhttp3.Response;

/**
 * Created by zhouyinyan on 2019/3/29.
 */
public interface ResponseHandler<T> {

    T handler(Response response);
}
