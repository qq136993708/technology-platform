package com.pcitc.api;

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
import com.pcitc.service.IOutPersonService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "OutPerson-API",tags = {"外系统-人员接口"})
@RestController
public class OutPersonProviderClient {
	
	private final static Logger logger = LoggerFactory.getLogger(OutPersonProviderClient.class); 
	@Autowired
    private IOutPersonService outPersonService; 
	
	
	
	
	@ApiOperation(value = "获取外系统人员", notes = "获取外系统人员")
	@RequestMapping(value = "/out_person/getOutPersonCount", method = RequestMethod.POST)
	public JSONObject getOutPersonCount(@RequestBody Map map)throws Exception {
		Long count=	outPersonService.getOutPersonCount(map);
		JSONObject jSONObject=new JSONObject();
		jSONObject.put("count", count);
		return jSONObject;
	}
	
	
	@ApiOperation(value = "获取外系统人员列表", notes = "获取外系统人员列表")
	@RequestMapping(value = "/out_person/list", method = RequestMethod.POST)
	public JSONArray getOutPersonList(@RequestBody Map map)throws Exception {
		
		List<OutPerson> list=	outPersonService.getOutPersonList(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	@ApiOperation(value = "获取外系统人员（分页）", notes = "获取外系统人员（分页）")
	@RequestMapping(value = "/out_person/page", method = RequestMethod.POST)
	public LayuiTableData getOutPersonList(@RequestBody LayuiTableParam param)throws Exception
	{
		
		logger.info("=== OutPerson param============"+param);
		return outPersonService.getOutPersonPage(param) ;
	}
	
	@ApiOperation(value = "增加外系统人员信息", notes = "增加外系统人员信息")
	@RequestMapping(value = "/out_person/add", method = RequestMethod.POST)
	public String insertOutPerson(@RequestBody OutPerson OutPerson) throws Exception{
		logger.info("====================add OutPerson....========================");
		Integer count= outPersonService.insertOutPerson(OutPerson);
		return OutPerson.getId();
	}
	
	
	@ApiOperation(value = "修改外系统人员信息", notes = "修改外系统人员信息")
	@RequestMapping(value = "/out_person/update", method = RequestMethod.POST)
	public Integer updateOutPerson(@RequestBody OutPerson OutPerson) throws Exception{
		logger.info("==================update OutPerson===========================");
		return outPersonService.updateOutPerson(OutPerson);
	}
	
	@ApiOperation(value = "根据ID物理删除外系统人员信息", notes = "根据ID删除外系统人员信息")
	@RequestMapping(value = "/out_person/delete/{id}", method = RequestMethod.POST)
	public int deleteOutPerson(@PathVariable("id") String id)throws Exception{
		logger.info("=============================根据ID物理删除外系统人员信息 OutPerson==="+id+"==============");
		return outPersonService.deleteOutPerson(id) ;
	}
	
	
	
	@ApiOperation(value = "根据ID获取外系统人员信息详情", notes = "根据ID获取外系统人员信息详情")
	@RequestMapping(value = "/out_person/get/{id}", method = RequestMethod.GET)
	public OutPerson selectOutPersonId(@PathVariable(value = "id", required = true) String id) throws Exception {
		logger.info("===============================get OutPerson id "+id+"===========");
		return outPersonService.selectOutPerson(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
