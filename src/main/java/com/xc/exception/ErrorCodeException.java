package com.xc.exception;

import com.xc.domain.ErrorCodeEnum;

/**
 * 自定义异常
 *
 * @author xstarfct
 * @version 2019-02-18 14:16
 */
public class ErrorCodeException extends Exception {
    private ErrorCodeEnum codeEnum;

    public ErrorCodeException(ErrorCodeEnum codeEnum) {
        super(codeEnum.toString());
        this.codeEnum = codeEnum;
    }

    public ErrorCodeEnum getCodeEnum() {
        return codeEnum;
    }
}
