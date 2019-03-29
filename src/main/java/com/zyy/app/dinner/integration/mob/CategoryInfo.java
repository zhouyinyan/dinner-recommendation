package com.zyy.app.dinner.integration.mob;

import java.io.Serializable;

/**
 * Created by zhouyinyan on 2019/3/28.
 */
public class CategoryInfo implements Serializable{

//    {
//        "ctgId": "0010001001",
//            "name": "全部菜谱"
//    }

    private String ctgId;

    private String name;

    private String parentId;

    public String getCtgId() {
        return ctgId;
    }

    public void setCtgId(String ctgId) {
        this.ctgId = ctgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CategoryInfo{");
        sb.append("ctgId='").append(ctgId).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", parentId='").append(parentId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
