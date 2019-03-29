package com.zyy.app.dinner.integration;

import com.zyy.app.dinner.DinnerApplicationTests;
import com.zyy.app.dinner.integration.mob.CategoryInfoTree;
import com.zyy.app.dinner.integration.mob.CategoryService;
import com.zyy.app.dinner.integration.mob.CategoryType;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by zhouyinyan on 2019/3/29.
 */
public class CategoryServiceTest extends DinnerApplicationTests {

    @Autowired
    CategoryService categoryService;

    static final String rootCtgId = "0010001001";
    static final String menuCtgId = "0010001002";

    @Test
    public void testCategoryTree() throws Exception {

        CategoryInfoTree tree = categoryService.categoryTree();
        Assert.assertNotNull(tree);
        Assert.assertNotNull(tree.getCategoryInfo());
        Assert.assertEquals(tree.getCategoryInfo().getCtgId(),rootCtgId);

        Assert.assertNotNull(tree.getChilds());
        Assert.assertFalse(tree.getChilds().isEmpty());
        logger.debug("tree:{}",tree);
    }

    @Test
    public void testCategoryTreeByType() throws Exception {

        CategoryInfoTree tree = categoryService.categoryTreeByType(CategoryType.MENU);
        Assert.assertNotNull(tree);
        Assert.assertNotNull(tree.getCategoryInfo());
        Assert.assertEquals(tree.getCategoryInfo().getCtgId(),menuCtgId);

        Assert.assertNotNull(tree.getChilds());
        Assert.assertFalse(tree.getChilds().isEmpty());
        logger.debug("tree:{}",tree);
    }
}
