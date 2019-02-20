package com.xc.request;

import com.xc.domain.BaseDO;

/**
 * 请求基类
 * @author xstarfct
 * @version 2019-02-18 15:06
 */
public class BaseRequest extends BaseDO {
    private static final long serialVersionUID = -4628706590512455969L;
    /**
     * 调用方的应用名
     */
    private String appName;
    /**
     * 调用的模块名
     */
    private String moduleId;
    /**
     * 使用者
     */
    private String userId;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
