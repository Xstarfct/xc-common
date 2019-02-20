package com.xc.response;

/**
 * 分页返回结果
 * 
 * @param <T>
 */
public class PageResponse<T> extends Response<T> {

    /**  */
    private static final long serialVersionUID = 7521047204889985981L;

    /**
     * 每页条数
     */
    private Integer           pageSize         = 0;

    /**
     * 页数
     */
    private Integer           pageNo           = 0;

    /**
     * 返回总数
     */
    private Long              totalCount       = 0L;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

}
