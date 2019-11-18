package com.pcitc.web.expert;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "ZjkExtractConfigClient-API", description = "专家抽取逻辑配置服务接口")
@RestController
public class ExpertClient {
	 private final static Logger logger = LoggerFactory.getLogger(ExpertClient.class);

	 
	 
	 @ApiOperation(value = "带参专家抽取逻辑配置查询列表", notes = "根据ID查询查询专家抽取逻辑配置信息,返回一个专家抽取逻辑配置的JSONObject对象")
	    @RequestMapping(value = "/zjkextractconfig-provider/zjkextractconfig/zjkextractconfig_list_param", method = RequestMethod.POST)
	    public JSONObject selectZjkExtractConfigListParam(@RequestParam(value = "id", required = false) String id) {
	        JSONObject retJson = new JSONObject();
	        return retJson;
	    }
	 
}
