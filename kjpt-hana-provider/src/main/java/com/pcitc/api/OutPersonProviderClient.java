package com.pcitc.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.out.OutPerson;
import com.pcitc.base.out.OutPersonVo;
import com.pcitc.service.IOutPersonService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "OutPerson-API",tags = {"外系统-人员接口"})
@RestController
public class OutPersonProviderClient {
	
	private final static Logger logger = LoggerFactory.getLogger(OutPersonProviderClient.class); 
	@Autowired
    private IOutPersonService outPersonService; 
	
	
	
	
	
	
	
	@ApiOperation(value = "test", notes = "test")
	@RequestMapping(value = "/out_person/test", method = RequestMethod.POST)
	public JSONArray test(@RequestBody  Map map) throws Exception {
		logger.info("===============================get OutPerson test iddd==========");
		
		List<OutPersonVo> list = outPersonService.getHanaOutPersonVoList(map) ;
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		System.out.println(">>>>>>>>>>人才转为专家 参数: "+json.toJSONString());
		return json;
	}
	
	
	
	
	
	
	
	

}
