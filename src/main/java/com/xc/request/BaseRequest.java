package com.xc.request;

import com.xc.domain.BaseDO;
import com.xc.enums.AppNameEnum;

/**
 * 请求基类
 * @author xstarfct
 * @version 2019-02-18 15:06
 */
public abstract class BaseRequest extends BaseDO {
    private static final long serialVersionUID = -4628706590512455969L;

    /**
     * 调用方的应用名
     * 
     * @return
     */
    public abstract AppNameEnum getInvokeAppName();
}
