package com.zzxx.user.manager.utils;

import java.util.List;

public class PageBean<T> {
    // 数据
    private List<T> list;
    // 总记录条数
    private int totalCount;
    // 总页数
    private int totalPage;
    // 当前页数
    private int currentPage;
    // 每页显示条数
    private int pageSize;

    public PageBean() {

    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
