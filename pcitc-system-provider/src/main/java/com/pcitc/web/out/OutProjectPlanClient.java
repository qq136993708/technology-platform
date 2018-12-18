package com.pcitc.web.out;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
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
	
	@ApiOperation(value = "领导首页-科研合同，项目计划完成的比率，按照直属研究所、分子公司等9个来分组", notes = "参数年度")
	@RequestMapping(value = "/out-project-plna-provider/complete-rate/company-type")
	public JSONArray getPlanCompleteRateByCompanyType(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getPlanCompleteRateByCompanyType===========================" + map);
		
		List temList = outProjectPlanService.getPlanCompleteRateByCompanyType(map);
		
		if (!JSON.toJSONString(temList).contains("直属研究院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("jhqds", 0);
			temMap.put("sjqds", 0);
			temMap.put("qdbl", 0);
			
			temMap.put("zysje", 0);
			temMap.put("zsjje", 0);
			temMap.put("zRate", 0);
			temMap.put("zbxysje", 0);
			temMap.put("zbxsjje", 0);
			temMap.put("zbxRate", 0);
			temMap.put("fyxysje", 0);
			temMap.put("fyxsjje", 0);
			temMap.put("fyxRate", 0);
			
			temMap.put("define3", "直属研究院");
			temList.add(0, temMap);
		}
		if (!JSON.toJSONString(temList).contains("分子公司")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("jhqds", 0);
			temMap.put("sjqds", 0);
			temMap.put("qdbl", 0);
			
			temMap.put("zysje", 0);
			temMap.put("zsjje", 0);
			temMap.put("zRate", 0);
			temMap.put("zbxysje", 0);
			temMap.put("zbxsjje", 0);
			temMap.put("zbxRate", 0);
			temMap.put("fyxysje", 0);
			temMap.put("fyxsjje", 0);
			temMap.put("fyxRate", 0);
			temMap.put("define3", "分子公司");
			temList.add(1, temMap);
		}
		if (!JSON.toJSONString(temList).contains("集团单位")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("jhqds", 0);
			temMap.put("sjqds", 0);
			temMap.put("qdbl", 0);
			
			temMap.put("zysje", 0);
			temMap.put("zsjje", 0);
			temMap.put("zRate", 0);
			temMap.put("zbxysje", 0);
			temMap.put("zbxsjje", 0);
			temMap.put("zbxRate", 0);
			temMap.put("fyxysje", 0);
			temMap.put("fyxsjje", 0);
			temMap.put("fyxRate", 0);
			temMap.put("define3", "集团单位");
			temList.add(2, temMap);
		}
		if (!JSON.toJSONString(temList).contains("外部单位")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("jhqds", 0);
			temMap.put("sjqds", 0);
			temMap.put("qdbl", 0);
			
			temMap.put("zysje", 0);
			temMap.put("zsjje", 0);
			temMap.put("zRate", 0);
			temMap.put("zbxysje", 0);
			temMap.put("zbxsjje", 0);
			temMap.put("zbxRate", 0);
			temMap.put("fyxysje", 0);
			temMap.put("fyxsjje", 0);
			temMap.put("fyxRate", 0);
			
			temMap.put("define3", "外部单位");
			temList.add(3, temMap);
		}
		
		if (!JSON.toJSONString(temList).contains("休斯顿研发中心")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("jhqds", 0);
			temMap.put("sjqds", 0);
			temMap.put("qdbl", 0);
			
			temMap.put("zysje", 0);
			temMap.put("zsjje", 0);
			temMap.put("zRate", 0);
			temMap.put("zbxysje", 0);
			temMap.put("zbxsjje", 0);
			temMap.put("zbxRate", 0);
			temMap.put("fyxysje", 0);
			temMap.put("fyxsjje", 0);
			temMap.put("fyxRate", 0);
			
			temMap.put("define3", "休斯顿研发中心");
			temList.add(4, temMap);
		}
		if (!JSON.toJSONString(temList).contains("中东研发中心")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("jhqds", 0);
			temMap.put("sjqds", 0);
			temMap.put("qdbl", 0);
			
			temMap.put("zysje", 0);
			temMap.put("zsjje", 0);
			temMap.put("zRate", 0);
			temMap.put("zbxysje", 0);
			temMap.put("zbxsjje", 0);
			temMap.put("zbxRate", 0);
			temMap.put("fyxysje", 0);
			temMap.put("fyxsjje", 0);
			temMap.put("fyxRate", 0);
			
			temMap.put("define3", "中东研发中心");
			temList.add(5, temMap);
		}
		if (!JSON.toJSONString(temList).contains("集团公司")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("jhqds", 0);
			temMap.put("sjqds", 0);
			temMap.put("qdbl", 0);
			
			temMap.put("zysje", 0);
			temMap.put("zsjje", 0);
			temMap.put("zRate", 0);
			temMap.put("zbxysje", 0);
			temMap.put("zbxsjje", 0);
			temMap.put("zbxRate", 0);
			temMap.put("fyxysje", 0);
			temMap.put("fyxsjje", 0);
			temMap.put("fyxRate", 0);
			
			temMap.put("define3", "集团公司");
			temList.add(6, temMap);
		}
		if (!JSON.toJSONString(temList).contains("资产公司")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("jhqds", 0);
			temMap.put("sjqds", 0);
			temMap.put("qdbl", 0);
			
			temMap.put("zysje", 0);
			temMap.put("zsjje", 0);
			temMap.put("zRate", 0);
			temMap.put("zbxysje", 0);
			temMap.put("zbxsjje", 0);
			temMap.put("zbxRate", 0);
			temMap.put("fyxysje", 0);
			temMap.put("fyxsjje", 0);
			temMap.put("fyxRate", 0);
			
			temMap.put("define3", "资产公司");
			temList.add(7, temMap);
		}
		if (!JSON.toJSONString(temList).contains("盈科")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("jhqds", 0);
			temMap.put("sjqds", 0);
			temMap.put("qdbl", 0);
			
			temMap.put("zysje", 0);
			temMap.put("zsjje", 0);
			temMap.put("zRate", 0);
			temMap.put("zbxysje", 0);
			temMap.put("zbxsjje", 0);
			temMap.put("zbxRate", 0);
			temMap.put("fyxysje", 0);
			temMap.put("fyxsjje", 0);
			temMap.put("fyxRate", 0);
			
			temMap.put("define3", "盈科");
			temList.add(8, temMap);
		}
		
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "领导首页-科研合同，科研合同签订率清单", notes = "参数年度")
	@RequestMapping(value = "/out-project-plna-provider/contract-rate/details")
	public JSONArray getPlanCompleteRateDetails(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getPlanCompleteRateDetails===========================" + map);
		
		List temList = outProjectPlanService.getPlanCompleteRateDetails(map);
		
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
}
