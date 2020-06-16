package com.pcitc.web.patent;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.pcitc.service.patent.PatentInfoBIService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/***
 * @Author xiaoh
 * @Description 知识产权-领导驾驶舱
 * @Date 2020/6/9 17:18
 * @param
 * @return
 **/
@Api(value = "PatentInfoBIClient-API", description = "知识产权领导驾驶舱接口")
@RestController
public class PatentInfoBIClient {
	private final static Logger logger = LoggerFactory.getLogger(PatentInfoBIClient.class);

	@Autowired
	PatentInfoBIService service;

	@ApiOperation(value = "历年申请/授权专利数量统计", notes = "历年申请/授权专利数量统计")
	@RequestMapping(value = "/patentBI/getPatentCountByYear", method = RequestMethod.POST)
	public JSONArray getInternalResearchList(@RequestBody(required = false) Map param){
		List list=service.getPatentCountByYear(param);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}


	@ApiOperation(value = "法律状态", notes = "法律状态")
	@RequestMapping(value = "/patentBI/getPatentCountByLegelStatus", method = RequestMethod.POST)
	public JSONArray getPatentCountByLegelStatus(@RequestBody(required = false) Map param){
		List list=service.getPatentCountByLegelStatus(param);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}


	@ApiOperation(value = "二级单位专利数量统计", notes = "二级单位专利数量统计")
	@RequestMapping(value = "/patentBI/getPatentCountByOffice", method = RequestMethod.POST)
	public JSONArray getPatentCountByOffice(@RequestBody(required = false) Map param){
		List list=service.getPatentCountByOffice(param);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}

}
