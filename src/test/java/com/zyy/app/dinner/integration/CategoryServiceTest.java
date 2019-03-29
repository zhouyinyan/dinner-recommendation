package com.zyy.app.dinner.integration;

import com.zyy.app.dinner.DinnerApplicationTests;
import com.zyy.app.dinner.integration.mob.model.CategoryInfo;
import com.zyy.app.dinner.integration.mob.model.CategoryInfoTree;
import com.zyy.app.dinner.integration.mob.CategoryService;
import com.zyy.app.dinner.integration.mob.model.CategoryType;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * Created by zhouyinyan on 2019/3/29.
 */
public class CategoryServiceTest extends DinnerApplicationTests {

    @Autowired
    CategoryService categoryService;

    static final String rootCtgId = "0010001001";
    static final String menuCtgId = "0010001002";

    @Test
    public void testLevel1Category(){
        List<CategoryInfo> level1Category = categoryService.level1Category();
        assertNotNull(level1Category);
        assertEquals(CategoryType.values().length, level1Category.size());
    }

    @Test
    public void testCategoryTree() throws Exception {

        CategoryInfoTree tree = categoryService.categoryTree();
        assertNotNull(tree);
        assertNotNull(tree.getCategoryInfo());
        Assert.assertEquals(tree.getCategoryInfo().getCtgId(),rootCtgId);

        assertNotNull(tree.getChilds());
        assertFalse(tree.getChilds().isEmpty());
        logger.debug("tree:{}",tree);
    }

    @Test
    public void testCategoryTreeByType() throws Exception {

        CategoryInfoTree tree = categoryService.categoryTreeByType(CategoryType.MENU);
        assertNotNull(tree);
        assertNotNull(tree.getCategoryInfo());
        Assert.assertEquals(tree.getCategoryInfo().getCtgId(),menuCtgId);

        assertNotNull(tree.getChilds());
        assertFalse(tree.getChilds().isEmpty());
        logger.debug("tree:{}",tree);
    }
}
