package com.xc.check;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.xc.domain.ErrorCodeEnum;
import com.xc.exception.ErrorCodeException;

/**
 * 参数校验工具类
 *
 * @author xstarfct
 * @version 2019-02-18 14:21
 */
public class ParamCheck {
    /**
     * 参数判断是否为null
     *
     * @param param
     * @throws ErrorCodeException
     */
    public static void nullCheck(Object param) throws ErrorCodeException {
        if (param == null) {
            throw new ErrorCodeException(ErrorCodeEnum.P01);
        }
    }

    /**
     * 参数判断是否为null,重写错误信息
     *
     * @param param
     * @param errorMessage 
     * @throws ErrorCodeException
     */
    public static void nullCheck(Object param, String errorMessage) throws ErrorCodeException {
        if (param == null) {
            ErrorCodeEnum errorCodeEnum = ErrorCodeEnum.P01;
            errorCodeEnum.setDesc(errorMessage);
            throw new ErrorCodeException(errorCodeEnum);
        }
    }

    /**
     * 判断字符串是否为空
     *
     * @param param
     * @throws ErrorCodeException
     */
    public static void emptyCheck(String param) throws ErrorCodeException {
        if (param == null || param.isEmpty()) {
            throw new ErrorCodeException(ErrorCodeEnum.P01);
        }
    }

    /**
     * 小于零的判断
     *
     * @param param
     * @throws
     */
    public static void lessZero(Object param) throws ErrorCodeException {

        if (param instanceof Integer) {
            if ((Integer) param < 0) {
                throw new ErrorCodeException(ErrorCodeEnum.P01);
            }
        } else if (param instanceof Long) {
            if ((Long) param < 0) {
                throw new ErrorCodeException(ErrorCodeEnum.P01);
            }
        } else if (param instanceof Double) {
            if ((Double) param < 0) {
                throw new ErrorCodeException(ErrorCodeEnum.P01);
            }
        } else if (param instanceof Float) {
            if ((Float) param < 0) {
                throw new ErrorCodeException(ErrorCodeEnum.P01);
            }
        } else {
            throw new ErrorCodeException(ErrorCodeEnum.P01);
        }

    }

    /**
     * 判断List是否为空
     *
     * @param <E>
     */
    public static <E> void emptyListCheck(List<E> list) throws ErrorCodeException {
        if (CollectionUtils.isEmpty(list)) {
            throw new ErrorCodeException(ErrorCodeEnum.P01);
        }
    }
}
