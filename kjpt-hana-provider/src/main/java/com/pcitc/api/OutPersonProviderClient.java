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
	
	
	
	
	
	
	
	@ApiOperation(value = "获取所有专家的基本信息", notes = "获取所有专家的基本信息")
	@RequestMapping(value = "/out_person/getHanaOutPersonBaseInfoList", method = RequestMethod.POST)
	public JSONArray getHanaOutPersonBaseInfoList(@RequestBody  Map map) throws Exception {
		logger.info("===============================getHanaOutPersonBaseInfoList==========");
		
		List<OutPersonVo> list = outPersonService.getHanaOutPersonBaseInfoList(map) ;
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		//System.out.println(">>>>>>>>>>获取所有专家的基本信息: "+json.toJSONString());
		return json;
	}
	
	
	@ApiOperation(value = "获取所有专家相关-专利", notes = "获取所有专家相关--专利")
	@RequestMapping(value = "/out_person/getHanaOutPersonPatentList", method = RequestMethod.POST)
	public JSONArray getHanaOutPersonPatentList(@RequestBody  Map map) throws Exception {
		logger.info("===============================getHanaOutPersonPatentList==========");
		
		List<OutPersonVo> list = outPersonService.getHanaOutPersonPatentList(map) ;
		
		System.out.println("获取所有专家相关专利的基本信息list: "+list.size());
		
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		System.out.println("获取所有专家相关专利的基本信息: "+json.toJSONString());
		return json;
	}
	
	
	@ApiOperation(value = "获取所有专家相关-论著", notes = "获取所有专家相关-论著")
	@RequestMapping(value = "/out_person/getHanaOutPersonBookList", method = RequestMethod.POST)
	public JSONArray getHanaOutPersonBookList(@RequestBody  Map map) throws Exception {
		logger.info("===============================getHanaOutPersonBookList==========");
		
		List<OutPersonVo> list = outPersonService.getHanaOutPersonBookList(map) ;
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		//System.out.println("获取所有专家相关-论著: "+json.toJSONString());
		return json;
	}
	
	@ApiOperation(value = "获取所有专家相关-获奖", notes = "获取所有专家相关-获奖")
	@RequestMapping(value = "/out_person/getHanaOutPersonAwardList", method = RequestMethod.POST)
	public JSONArray getHanaOutPersonAwardList(@RequestBody  Map map) throws Exception {
		logger.info("===============================getHanaOutPersonAwardList==========");
		
		List<OutPersonVo> list = outPersonService.getHanaOutPersonAwardList(map) ;
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		//System.out.println("获取所有专家 获奖: "+json.toJSONString());
		return json;
	}
	
	
	
	@ApiOperation(value = "获取所有专家相关-奖惩", notes = "获取所有专家相关-奖惩")
	@RequestMapping(value = "/out_person/getHanaOutPersonPunishList", method = RequestMethod.POST)
	public JSONArray getHanaOutPersonPunishList(@RequestBody  Map map) throws Exception {
		logger.info("===============================奖惩getHanaOutPersonAwardList==========");
		
		List<OutPersonVo> list = outPersonService.getHanaOutPersonPunishList(map) ;
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	
	
	
	
	
	
	
	
	@ApiOperation(value = "根据专家编号查询专利信息", notes = "根据专家编号查询专利信息")
	@RequestMapping(value = "/out_person/getHanaPantentListByNum", method = RequestMethod.POST)
	public JSONArray getHanaPantentListByNum(@RequestBody  Map map) throws Exception {
		
		String num=(String)map.get("pernr");
		logger.info("========================== getHanaPantentListByNum =====num= "+num);
		
		List<OutPersonVo> list = outPersonService.getHanaPantentListByNum(num) ;
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		System.out.println(">>>>>>>>>>根据专家编号查询专利信息: "+json.toJSONString());
		return json;
	}
	
	
	
	

}
