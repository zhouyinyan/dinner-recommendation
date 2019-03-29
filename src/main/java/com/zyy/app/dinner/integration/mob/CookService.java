package com.zyy.app.dinner.integration.mob;

import com.zyy.app.dinner.integration.mob.model.PagedResult;
import com.zyy.app.dinner.integration.mob.model.CookItem;

/**
 * Created by zhouyinyan on 2019/3/29.
 */
public interface CookService {

    CookItem queryById(String id);

    PagedResult<CookItem> queryByCtgId(String CategoryId, int page, int size);
}
