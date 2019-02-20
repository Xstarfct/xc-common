package com.xc.response;

import com.xc.domain.Page;

/**
 * 返回结果
 *
 * @param <T>
 * @author xstarfct
 */
public class Response<T> extends BaseResult {

    private static final long serialVersionUID = -8001478476958870871L;

    /**
     * 返回值
     */
    private T                 result;
    /**
     * 错误码
     */
    private String            errorCode;
    /**
     * 错误信息
     */
    private String            errorMessage;
    /**
     * 如果是有分页的返回结果，就需要设置
     */
    private Page              page;

    public Response() {
    }

    public Response(T result) {
        this.result = result;
    }

    public Response(T result, Page page) {
        this.result = result;
        this.page = page;
    }

    public Response(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        super.setSuccess(false);
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
