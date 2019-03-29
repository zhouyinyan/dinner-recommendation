package com.zyy.app.dinner.integration.mob.model;

/**
 * 分类类型
 * Created by zhouyinyan on 2019/3/29.
 */
public enum CategoryType {

    MENU("0010001002","按菜品选择菜谱"),
    CRAFT("0010001003","按工艺选择菜谱"),
    STYLE("0010001004","按菜系选择菜谱"),
    CROWD("0010001005","按人群选择菜谱"),
    FUNCTION("0010001006","按功能选择菜谱"),

    ;

    private String ctgId;

    private String name;

    CategoryType(String ctgId, String name) {
        this.ctgId = ctgId;
        this.name = name;
    }

    public static CategoryType getByCtgId(String ctgId){
        for (CategoryType type : CategoryType.values()) {
            if(type.getCtgId().equals(ctgId)){
                return type;
            }
        }
        return null;
    }

    public String getCtgId() {
        return ctgId;
    }

    public String getName() {
        return name;
    }
}
