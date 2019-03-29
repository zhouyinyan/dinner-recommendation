package com.zyy.app.dinner.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zyy.app.dinner.integration.mob.CategoryService;
import com.zyy.app.dinner.integration.mob.model.CategoryInfo;
import com.zyy.app.dinner.integration.mob.model.CategoryInfoTree;
import com.zyy.app.dinner.integration.mob.model.CategoryType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by zhouyinyan on 2019/3/27.
 */

@WebMvcTest(CategoryController.class)
public class CategoryControllerTest extends BaseMvcTest{

    protected static final Logger logger = LoggerFactory.getLogger(CategoryControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService categoryService;

    @Test
    public void testLevel1Category() throws Exception {
        logger.info("测试Category控制器的level1Category().....开始");
        List<CategoryInfo> categoryInfos = new ArrayList<>(Arrays.asList(new CategoryInfo("1","name1"), new CategoryInfo("2","name2")));
        given(this.categoryService.level1Category())
                .willReturn(categoryInfos);

        mockMvc.perform(MockMvcRequestBuilders.get("/ctg/l1ctg").accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json(new ObjectMapper().writeValueAsString(categoryInfos)));
        logger.info("测试Category控制器的level1Category().....通过");
    }

    @Test
    public void testRootTree() throws Exception {
        logger.info("测试Category控制器的rootTree().....开始");
        CategoryInfoTree rootTree = new CategoryInfoTree();
        rootTree.setCategoryInfo(new CategoryInfo("1", "name1"));
        rootTree.setChilds(new ArrayList<>());

        given(this.categoryService.categoryTree())
                .willReturn(rootTree);

        mockMvc.perform(MockMvcRequestBuilders.get("/ctg/roottree").accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json(new ObjectMapper().writeValueAsString(rootTree)));
        logger.info("测试Category控制器的rootTree().....通过");
    }

    @Test
    public void testCategoryTree() throws Exception {
        logger.info("测试Category控制器的categoryTree().....开始");
        CategoryInfoTree typeTree = new CategoryInfoTree();
        typeTree.setCategoryInfo(new CategoryInfo("1", "name1"));
        typeTree.setChilds(new ArrayList<>());

        given(this.categoryService.categoryTreeByType(CategoryType.CRAFT))
                .willReturn(typeTree);

        mockMvc.perform(MockMvcRequestBuilders.get("/ctg/typetree").param("l1ctgId", CategoryType.CRAFT.getCtgId()).accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json(new ObjectMapper().writeValueAsString(typeTree)));
        logger.info("测试Category控制器的categoryTree().....通过");
    }

}
