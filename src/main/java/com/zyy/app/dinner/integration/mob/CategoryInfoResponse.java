package com.zyy.app.dinner.integration.mob;

import java.io.Serializable;

/**
 * Created by zhouyinyan on 2019/3/29.
 */
public class CategoryInfoResponse implements Serializable{

    private String msg;

    private String retCode;

    private CategoryInfoTree result;

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

    public CategoryInfoTree getResult() {
        return result;
    }

    public void setResult(CategoryInfoTree result) {
        this.result = result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CategoryInfoResponse{");
        sb.append("msg='").append(msg).append('\'');
        sb.append(", retCode='").append(retCode).append('\'');
        sb.append(", result=").append(result);
        sb.append('}');
        return sb.toString();
    }
}
