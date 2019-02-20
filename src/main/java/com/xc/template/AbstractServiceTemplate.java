package com.xc.template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.xc.enums.ErrorCodeEnum;
import com.xc.exception.ErrorCodeException;
import com.xc.response.Response;

/**
 * PRC(包含HTTP)调用模版类
 * 
 * @author xstarfct
 * @version 2019-02-20 15:09
 */
public abstract class AbstractServiceTemplate<T> {
    private final Logger logger = LoggerFactory.getLogger(initLog());

    public Response<T> execute(Object... params) {

        long start = System.currentTimeMillis();
        boolean result = true;
        Response<T> response = new Response<>();
        try {
            this.checkParam();
            return bizExecute();
        } catch (ErrorCodeException errorCodeException) {
            logger.warn("level1@errorCodeException,errorCode:{},msg:{}", errorCodeException.getCodeEnum().getCode(), errorCodeException.getCodeEnum().getDesc(), errorCodeException);
            response.setErrorCode(errorCodeException.getCodeEnum().getCode());
            response.setErrorMessage(errorCodeException.getCodeEnum().getDesc());
            result = false;
        } catch (Exception e) {
            logger.error("level0@execute:", e);
            response.setErrorCode(ErrorCodeEnum.P99.getCode());
            response.setErrorMessage(ErrorCodeEnum.P99.getDesc());
            result = false;
        } finally {
            response.setSuccess(result);
            int threadLength = 2;
            if (Thread.currentThread().getStackTrace().length < threadLength) {
                logger.info("info@execute,success={},cost:{},param:{}", result, System.currentTimeMillis() - start, getParam(params));
            } else {
                logger.info("info@{}.{},success={},cost:{},param:{}", Thread.currentThread().getStackTrace()[2].getClassName(), Thread.currentThread().getStackTrace()[2].getMethodName(), result,
                    System.currentTimeMillis() - start, getParam(params));
            }
        }
        return response;
    }

    /**
     * 强制参数校验
     *
     * @throws ErrorCodeException
     */
    public abstract void checkParam() throws ErrorCodeException;

    /**
     * 业务处理
     *
     * @return
     * @throws Exception
     */
    public abstract Response<T> bizExecute() throws Exception;

    /**
     * 定义日志输出,强制定义
     *
     * @return
     */
    public abstract String initLog();

    private String getParam(Object... params) {
        StringBuilder sb = new StringBuilder();
        if (params == null) {
            return sb.toString();
        }
        for (Object param : params) {
            sb.append(JSON.toJSONString(param));
            sb.append(",");
        }
        return sb.toString();
    }

}
