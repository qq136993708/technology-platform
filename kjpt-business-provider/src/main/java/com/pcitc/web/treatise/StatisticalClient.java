package com.pcitc.web.treatise;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.service.treatise.StatisticalService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "statisticalClient-api", description = "统计")
@RestController
@RequestMapping(value = "/statistical-api")
public class StatisticalClient {
	    @Autowired
	    private StatisticalService statisticalService;

	    @ApiOperation(value = "首页-知识产权", notes = "首页-知识产权")
	    @RequestMapping(value = "/getRightsMap", method = RequestMethod.GET)
	    public JSONObject getRightsMap()
	    {
	    	Map map=statisticalService.getRightsMap();
	    	JSONObject jsonObj = JSONObject.parseObject(JSON.toJSONString(map));
	    	return jsonObj;
	    }

	   

}
