package com.xc.domain;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

/**
 * DO基类
 * @author xstarfct
 * @version 2019-02-18 14:55
 */
public class BaseDO implements Serializable {

    private static final long serialVersionUID = -6917490055599392712L;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
