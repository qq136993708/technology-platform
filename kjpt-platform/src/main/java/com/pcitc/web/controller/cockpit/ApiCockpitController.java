package com.pcitc.web.controller.cockpit;

import com.alibaba.fastjson.JSONArray;
import com.pcitc.base.common.Result;
import com.pcitc.base.system.SysUser;
import com.pcitc.web.common.RestBaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


/**
 * @author:Administrator
 * @date:2018/5
 */
@Api(value = "sciencePlan-api", description = "科技平台驾驶舱")
@RestController
public class ApiCockpitController extends RestBaseController {

    /**
     * 根据ID获取对象信息
     */
    private static final String load = "http://10.102.111.112/qims/a/interface/indicator/";

    @Autowired
    public HttpHeaders httpHeaders;

    @ApiOperation(value = "读取API接口")
    @RequestMapping(value = "/apiCommon/{code}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public JSONArray apiCommon(@PathVariable String code) {
        Result r = new Result();
        SysUser sysUserInfo = getUserProfile();
        //String unifyIdentityId = sysUserInfo.getUnifyIdentityId();
        String unifyIdentityId = "622724198802261118";
        if (unifyIdentityId != null && !unifyIdentityId.isEmpty()) {
            String url = load + code + "/" + unifyIdentityId;
            RestTemplate template = new RestTemplate();
            JSONArray responseEntity = template.exchange(url, HttpMethod.GET, new HttpEntity(httpHeaders), JSONArray.class).getBody();
            return responseEntity;
        } else {
            return null;
        }


    }
}
