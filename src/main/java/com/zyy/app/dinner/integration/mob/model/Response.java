package com.zyy.app.dinner.integration.mob.model;

import java.io.Serializable;

/**
 * Created by zhouyinyan on 2019/3/29.
 */
public class Response<R> implements Serializable {

    private String msg;

    private String retCode;

    private R result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public R getResult() {
        return result;
    }

    public void setResult(R result) {
        this.result = result;
    }


    public static class CategoryInfoResponse extends Response<CategoryInfoTree> {

    }

    public static class CookItemResponse extends Response<CookItem> {
    }

    public static class PagedCookItemResponse extends Response<PagedResult<CookItem>>{}
}
