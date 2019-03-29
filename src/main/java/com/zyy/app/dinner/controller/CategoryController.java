package com.zyy.app.dinner.controller;

import com.zyy.app.dinner.integration.mob.CategoryService;
import com.zyy.app.dinner.integration.mob.model.CategoryInfo;
import com.zyy.app.dinner.integration.mob.model.CategoryInfoTree;
import com.zyy.app.dinner.integration.mob.model.CategoryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zhouyinyan on 2019/3/27.
 */
@RestController
@RequestMapping("/ctg")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping("/l1ctg")
    public List<CategoryInfo> level1Ctg(){
        return categoryService.level1Category();
    }

    @RequestMapping("/roottree")
    public CategoryInfoTree rootTree(){
        return categoryService.categoryTree();
    }

    @RequestMapping("/typetree")
    public CategoryInfoTree categoryTree(String l1ctgId){
        CategoryType type = CategoryType.getByCtgId(l1ctgId);
        return categoryService.categoryTreeByType(type);
    }
}
