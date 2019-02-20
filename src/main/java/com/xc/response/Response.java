package com.xc.response;

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

    public Response() {
    }

    public Response(T result) {
        this.result = result;
    }

    public Response(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        super.setSuccess(false);
    }

    public Response(String errorCode, String errorMessage, Boolean isRetry) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.isRetry = isRetry;
        super.setSuccess(false);
    }

    /**
     * 请求是否需要重试
     */
    private Boolean isRetry = Boolean.FALSE;

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

    public Boolean getIsRetry() {
        return isRetry;
    }

    public void setIsRetry(Boolean isRetry) {
        this.isRetry = isRetry;
    }

}
