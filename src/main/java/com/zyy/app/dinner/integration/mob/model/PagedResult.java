package com.zyy.app.dinner.integration.mob.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhouyinyan on 2019/3/29.
 */
public class PagedResult<T> implements Serializable{
    private int curPage;
    private int total;
    private int size;
    private List<T> list;

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PagedResult{");
        sb.append("curPage=").append(curPage);
        sb.append(", total=").append(total);
        sb.append(", size=").append(size);
        sb.append(", list=").append(list);
        sb.append('}');
        return sb.toString();
    }

    public static class PagedCookItem extends PagedResult<CookItem>{}
}
