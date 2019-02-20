package com.xc.request;

/**
 * 分页请求基类
 *
 * @author xstarfct
 * @version 2019-02-18 15:07
 */
public abstract class BasePageRequest extends BaseRequest {

    private static final long serialVersionUID = -609264446094177360L;
    /**
     * 每页数量
     */
    private Integer           pageSize;

    /**
     * 当前页码
     */
    private Integer           currentPage;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    /**
     *
     * 获取页码偏移量
     *
     * @return
     */
    public Integer getOffSet() {
        if (null == this.pageSize || null == this.currentPage || this.currentPage < 1) {
            return null;
        }
        return (this.currentPage - 1) * this.pageSize;
    }
}
