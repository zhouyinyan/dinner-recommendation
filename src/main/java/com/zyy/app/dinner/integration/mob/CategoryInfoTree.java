package com.zyy.app.dinner.integration.mob;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhouyinyan on 2019/3/29.
 */
public class CategoryInfoTree implements Serializable{

    private CategoryInfo categoryInfo;

    private List<CategoryInfoTree> childs = new LinkedList<>();

    public CategoryInfo getCategoryInfo() {
        return categoryInfo;
    }

    public void setCategoryInfo(CategoryInfo categoryInfo) {
        this.categoryInfo = categoryInfo;
    }

    public List<CategoryInfoTree> getChilds() {
        return childs;
    }

    public void setChilds(List<CategoryInfoTree> childs) {
        this.childs = childs;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CategoryInfoTree{");
        sb.append("categoryInfo=").append(categoryInfo);
        sb.append(", childs=").append(childs);
        sb.append('}');
        return sb.toString();
    }
}
