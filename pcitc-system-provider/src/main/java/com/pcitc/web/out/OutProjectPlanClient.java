package com.pcitc.web.out;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
import com.pcitc.base.stp.out.OutProjectErp;
import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.service.out.OutProjectPlanService;

@Api(value = "OUTPROJECTPLAN-API", description = "项目计划数据，从项目管理系统中获取")
@RestController
public class OutProjectPlanClient {

	@Autowired
	private OutProjectPlanService outProjectPlanService;
	
	private final static Logger logger = LoggerFactory.getLogger(OutProjectPlanClient.class);

	@ApiOperation(value = "直属研究院二级页面（领导），项目计划完成的比率，按照新开续建、资本性费用性来分组 ", notes = "参数年度")
	@RequestMapping(value = "/out-project-plna-provider/complete-rate/old-new")
	public JSONArray getPlanCompleteRateByOldNew(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getPlanCompleteRateByOldNew===========================" + map);
		
		List temList = outProjectPlanService.getPlanCompleteRateByOldNew(map);
		
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "直属研究院二级页面（领导），总的签订率 ", notes = "参数年度")
	@RequestMapping(value = "/out-project-plna-provider/complete-rate/total")
	public JSONArray getPlanTotalCompleteRate(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getPlanTotalCompleteRate===========================" + map);
		
		List temList = outProjectPlanService.getPlanTotalCompleteRate(map);
		
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "直属研究院二级页面（领导），各个院的合同签订率", notes = "参数年度")
	@RequestMapping(value = "/out-project-plna-provider/complete-rate/institute")
	public JSONArray getPlanCompleteRateByInstitute(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getPlanCompleteRateByInstitute===========================" + map);
		
		List temList = outProjectPlanService.getPlanCompleteRateByInstitute(map);
		
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "首页-直属研究院，项目计划完成的比率，按照资本性费用性来分组 ", notes = "参数年度")
	@RequestMapping(value = "/out-project-plna-provider/complete-rate/money-type")
	public JSONArray getPlanCompleteRateByPlanType(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getPlanCompleteRateByPlanType===========================" + map);
		
		List temList = outProjectPlanService.getPlanCompleteRateByPlanType(map);
		
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
}
