package com.xc.enums;

/**
 * 错误码枚举类型
 * @author xstarfct
 */
public enum ErrorCodeEnum {

    /**
     *
     */
    P01("P01", "参数传入不符合规则"), P99("P99", "系统异常");
    private String code;
    private String desc;

    ErrorCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "ErrorCodeEnum{" + "code='" + code + '\'' + ", desc='" + desc + '\'' + '}';
    }
}
