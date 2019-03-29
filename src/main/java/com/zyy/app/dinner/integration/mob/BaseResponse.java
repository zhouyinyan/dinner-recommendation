package com.zyy.app.dinner.integration.mob;

import java.io.Serializable;

/**
 * Created by zhouyinyan on 2019/3/29.
 */
public class BaseResponse<R> implements Serializable {

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
}
