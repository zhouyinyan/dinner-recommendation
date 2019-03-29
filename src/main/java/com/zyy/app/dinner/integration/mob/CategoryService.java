package com.zyy.app.dinner.integration.mob;

import com.zyy.app.dinner.integration.mob.model.CategoryInfo;
import com.zyy.app.dinner.integration.mob.model.CategoryInfoTree;
import com.zyy.app.dinner.integration.mob.model.CategoryType;

import java.util.List;

/**
 * 菜谱分类标签服务
 * Created by zhouyinyan on 2019/3/28.
 */
public interface CategoryService {

    List<CategoryInfo> level1Category();

    CategoryInfoTree categoryTree();

    CategoryInfoTree categoryTreeByType(CategoryType type);
}
