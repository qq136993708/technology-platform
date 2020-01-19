package com.pcitc.web.project;

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
import com.pcitc.base.out.OutProject;
import com.pcitc.service.out.IOutProjectService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "OutProject-API",tags = {"外系统-项目接口"})
@RestController
public class OutProjectProviderClient {
	
	private final static Logger logger = LoggerFactory.getLogger(OutProjectProviderClient.class); 
	@Autowired
    private IOutProjectService outProjectService; 
	
	@ApiOperation(value = "获取项目列表", notes = "获取项目列表")
	@RequestMapping(value = "/out_project/fetch", method = RequestMethod.POST)
	public JSONArray fetch(@RequestBody Map map)throws Exception {
		System.out.println("-------fetch-----");
		List<OutProject> list=	outProjectService.fetch(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		System.out.println("------sd------"+json.toString());
		return json;
	}
	
	
	

}
