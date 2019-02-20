package com.xc;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.xc.check.ParamCheck;
import com.xc.domain.Page;
import com.xc.enums.AppNameEnum;
import com.xc.exception.ErrorCodeException;
import com.xc.request.BaseRequest;
import com.xc.response.Response;
import com.xc.template.AbstractServiceTemplate;

/**
 * @author xstarfct
 * @version 2019-02-20 17:03
 */
public class TestResponse {

    private Logger logger = LoggerFactory.getLogger("TEST");

    @Test
    public void test() {
        ItemQueryRequest request = new ItemQueryRequest();
        request.setName("test");

        Response<String> response = new AbstractServiceTemplate<String>() {
            @Override
            public void checkParam() throws ErrorCodeException {
                ParamCheck.nullCheck(request);
            }

            @Override
            public Response<String> bizExecute() throws Exception {
                return new Response<>("Test", new Page(1, 10, 100));
//                return new Response<>("Test");
            }

            @Override
            public String initLog() {
                return "TEST";
            }
        }.execute(request);
        logger.info("response = {}", JSON.toJSONString(response));

    }


}
class ItemQueryRequest extends BaseRequest {

    private static final long serialVersionUID = -5649563504280387398L;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public AppNameEnum getInvokeAppName() {
        return AppNameEnum.ITEM;
    }
}
