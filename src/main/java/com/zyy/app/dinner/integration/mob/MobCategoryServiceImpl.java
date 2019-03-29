package com.zyy.app.dinner.integration.mob;

import com.zyy.app.dinner.integration.OkHTTP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * MobApi
 * http://www.mob.com/product/api/detail/4
 * Created by zhouyinyan on 2019/3/28.
 */
@Service
public class MobCategoryServiceImpl implements CategoryService {

    private static final String DINNER_APP_KEY = "2aa3c61ed499d";

    private static final String CATEGORY_API_URL = "http://apicloud.mob.com/v1/cook/category/query?key="+DINNER_APP_KEY;

    protected static Logger logger = LoggerFactory.getLogger(CategoryInfoResponseHandler.class);

    @Override
    public CategoryInfoTree categoryTree() {
        //缓存查询

        //远程调用
        CategoryInfoResponse response = OkHTTP.call(CATEGORY_API_URL, new CategoryInfoResponseHandler());

        //放置缓存

        return response.getResult();
    }

    @Override
    public CategoryInfoTree categoryTreeByType(final CategoryType type) {

        CategoryInfoTree allTree = categoryTree();

        //获取对应类型的类目树（类型都是在level1下）
        List<CategoryInfoTree> level1Childs = allTree.getChilds();
        Optional<CategoryInfoTree> treeOptional = level1Childs.stream().filter(level1 -> {
            if (level1.getCategoryInfo().getCtgId().equals(type.getCtgId())) {
                return true;
            } else {
                return false;
            }
        }).findFirst();

        return treeOptional.orElse(null);
    }
}
