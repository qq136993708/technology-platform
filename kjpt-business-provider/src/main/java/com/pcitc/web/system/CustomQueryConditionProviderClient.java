package com.pcitc.web.system;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.pcitc.base.system.CustomQueryCondition;
import com.pcitc.service.system.ICustomQueryConditionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "查询条件接口", tags = { "查询条件接口" })
@RestController
public class CustomQueryConditionProviderClient {
	private final static Logger logger = LoggerFactory.getLogger(CustomQueryConditionProviderClient.class);

	@Autowired
	private ICustomQueryConditionService customQueryConditionService;
	
	
	
	
	
    
    @ApiOperation(value = "查询条件接口列表", notes = "查询接条件口列表，返回LIST")
    @RequestMapping(value = "/customQueryCondition_provider/getList", method = RequestMethod.POST)
	public JSONArray getCustomQueryConditionList(@RequestBody Map map)throws Exception{
    	List<CustomQueryCondition> list= customQueryConditionService.getCustomQueryConditionList(map);
    	JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
    	return json;
	}
    
    
	
	

}
