package com.zyy.app.dinner.integration;

import com.zyy.app.dinner.DinnerApplicationTests;
import com.zyy.app.dinner.integration.mob.model.CookItem;
import com.zyy.app.dinner.integration.mob.CookService;
import com.zyy.app.dinner.integration.mob.model.PagedResult;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * Created by zhouyinyan on 2019/3/29.
 */
public class CookServiceTest extends DinnerApplicationTests {

    @Autowired
    CookService cookService;

    static final String menuId = "00100010070000000001";

    static final String ctgId = "0010001007";

    @Test
    public void testQueryById(){
        CookItem cookItem = cookService.queryById(menuId);
        logger.debug("cookItem,{}",cookItem);
        assertNotNull(cookItem);
        assertEquals(menuId, cookItem.getMenuId());
        assertEquals("三色炒虾仁", cookItem.getName());
    }

    @Test
    public void testQueryBy(){
        PagedResult<CookItem> cookItemPagedResult = cookService.queryByCtgId(ctgId, 1, 10);
        logger.debug("cookItem,{}",cookItemPagedResult);
        assertNotNull(cookItemPagedResult);
        assertEquals(1, cookItemPagedResult.getCurPage());
        assertEquals(10, cookItemPagedResult.getSize());
        assertNotNull(cookItemPagedResult.getList());
        assertFalse(cookItemPagedResult.getList().isEmpty());
        assertEquals(10, cookItemPagedResult.getList().size());
    }
}
