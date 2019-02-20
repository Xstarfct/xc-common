package com.xc.domain;

import java.io.Serializable;

/**
 * 页数是从0开始数起，默认当前页也是0。不适合做前端的翻页器 只是为了接口之间的交互
 * 
 * @author star
 * @date 2017/12/21 下午4:20
 */
public class Page implements Serializable {

    private static final long serialVersionUID = 2596858324983760047L;
    /**
     * 当前页
     */
    private int               currentPage      = 0;
    /**
     * 每页大小
     */
    private int               pageSize         = 10;
    /**
     * 总记录数量
     */
    private int               totalRecordCount = 0;
    /**
     * 总页数
     */
    private int               totalPageCount   = 0;

    public Page() {
    }

    public Page(int pageSize) {
        this.pageSize = (pageSize < 1 ? 1 : pageSize);
    }

    public Page(int curPage, int pageSize) {
        this(pageSize);
        currentPage = curPage;
    }

    public Page(int curPage, int pageSize, int count) {
        this(curPage, pageSize);
        setTotalRecordCount(count);
    }

    public int getTotalRecordCount() {
        return totalRecordCount;
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    /**
     * 获取起始位置
     */
    public int getBeginIndex() {
        return currentPage * pageSize;
    }

    public void setTotalRecordCount(int n) {
        totalRecordCount = n;
        totalPageCount = (n / pageSize) + (0 == (n % pageSize) ? 0 : 1);
    }

    public void setCurrentPage(int n) {
        currentPage = n;
    }

    /**
     * 转到下一页
     */
    public boolean toNextPage() {
        if (totalPageCount < 0) {
            ++currentPage;
            return true;
        }
        if (currentPage < totalPageCount) {
            ++currentPage;
            return true;
        }
        return false;
    }

    /**
     * 判定是否到达最后一页
     */
    public boolean isEndOfPage() {
        return !(currentPage + 1 < totalPageCount);
    }

    /**
     * 判定分页信息是否有效
     */
    public boolean isValid() {
        return (0 < pageSize && 0 < totalRecordCount);
    }

    @Override
    public String toString() {
        return "PageQuery{" + "currentPage=" + currentPage + ", pageSize=" + pageSize + ", totalRecordCount=" + totalRecordCount + ", totalPageCount=" + totalPageCount + '}';
    }
}
