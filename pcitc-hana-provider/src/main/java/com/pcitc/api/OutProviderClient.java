package com.pcitc.api;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.service.ICommonService;
import com.pcitc.service.IOutProjectService;

@Api(value = "OUT-HANA-API",description = "为了前端和其他系统集成-相关接口")
@RestController
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class OutProviderClient {


	@Autowired
	private ICommonService commonService;
	
	@Autowired
	private IOutProjectService outProjectService;
	
	
	@ApiOperation(value = "查询erp中课题", notes = "分页显示，和项目管理系统进行关联匹配")
	@RequestMapping(value = "/hana/out/erp-project-list", method = RequestMethod.POST)
	public Object selectErpProjectListByPage(@RequestBody LayuiTableParam param) {
		List temList = commonService.selectErpProjectListByPage(param);
		int temInt = commonService.selectErpProjectListCount(param);
		
		LayuiTableData data = new LayuiTableData();
		data.setData(temList);
		data.setCount(temInt);
		return data;
	}
	
	@RequestMapping(value = "/hana/country-project/list")
	public JSONArray getLastCountryProject(@RequestBody HashMap<String, String> map) {
		System.out.println("=================getLastCountryProject");
		List resultList = outProjectService.getCountryProjectList(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(resultList));
		return json;
	}
	
}
	
	
	
	
	
	
	
	
