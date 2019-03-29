package com.zyy.app.dinner.integration;

import com.zyy.app.dinner.DinnerApplicationTests;
import com.zyy.app.dinner.integration.mob.CookItem;
import com.zyy.app.dinner.integration.mob.CookService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by zhouyinyan on 2019/3/29.
 */
public class CookServiceTest extends DinnerApplicationTests {

    @Autowired
    CookService cookService;

    static final String menuId = "00100010070000000001";

    @Test
    public void testQueryById(){
        CookItem cookItem = cookService.queryById(menuId);
        logger.debug("cookItem,{}",cookItem);
        assertNotNull(cookItem);
        assertEquals(menuId, cookItem.getMenuId());
        assertEquals("三色炒虾仁", cookItem.getName());
    }
}
