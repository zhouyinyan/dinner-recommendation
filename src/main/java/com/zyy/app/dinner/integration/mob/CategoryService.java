package com.zyy.app.dinner.integration.mob;

/**
 * 菜谱分类标签服务
 * Created by zhouyinyan on 2019/3/28.
 */
public interface CategoryService {

    CategoryInfoTree categoryTree();

    CategoryInfoTree categoryTreeByType(CategoryType type);
}
