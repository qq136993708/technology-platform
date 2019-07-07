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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.service.out.OutProjectPlanService;

@Api(value = "OUTPROJECTPLAN-API", description = "项目计划数据，从项目管理系统中获取")
@RestController
public class OutProjectPlanClient {

	@Autowired
	private OutProjectPlanService outProjectPlanService;
	
	private final static Logger logger = LoggerFactory.getLogger(OutProjectPlanClient.class);
	
	@ApiOperation(value = "全生命周期查询，计划为起点", notes = "不包含国家项目、十条龙项目等特殊项目，只保护装备、科研")
	@RequestMapping(value = "/out-project-plan-provider/project-plan/cycle", method = RequestMethod.POST)
	public LayuiTableData selectProjectCycleByCondition(@RequestBody LayuiTableParam param) throws Exception {
		logger.info("==================page selectProjectCycleByCondition===========================" + param);
		return outProjectPlanService.selectProjectCycleByCondition(param);
	}
	
	@ApiOperation(value = "全生命周期, 项目的详情：合同信息", notes = " ")
	@RequestMapping(value = "/out-project-plan-provider/project-contract/details", method = RequestMethod.POST)
	public LayuiTableData getScienceProcessDetails(@RequestBody LayuiTableParam param) throws Exception {
		logger.info("==================page getScienceProcessDetails===========================" + param);
		return outProjectPlanService.getScienceProcessDetails(param);
	}
	
	@ApiOperation(value = "全生命周期, 合同付款详情", notes = " ")
	@RequestMapping(value = "/out-project-plan-provider/project-pay/details", method = RequestMethod.POST)
	public LayuiTableData getContractPayDetails(@RequestBody LayuiTableParam param) throws Exception {
		logger.info("==================page getContractPayDetails===========================" + param);
		return outProjectPlanService.getContractPayDetails(param);
	}
	
	@ApiOperation(value = "全生命周期, 合同成果详情", notes = " ")
	@RequestMapping(value = "/out-project-plan-provider/project-appraisal/details", method = RequestMethod.POST)
	public LayuiTableData getContractAppraisalDetails(@RequestBody LayuiTableParam param) throws Exception {
		logger.info("==================page getContractAppraisalDetails===========================" + param);
		return outProjectPlanService.getContractAppraisalDetails(param);
	}
	
	@ApiOperation(value = "全生命周期, 项目奖励信息", notes = " ")
	@RequestMapping(value = "/out-project-plan-provider/project-reward/details", method = RequestMethod.POST)
	public LayuiTableData getProjectRewardDetails(@RequestBody LayuiTableParam param) throws Exception {
		logger.info("==================page getProjectRewardDetails===========================" + param);
		return outProjectPlanService.getProjectRewardDetails(param);
	}
	
	@ApiOperation(value = "分页显示项目计划数据", notes = "分页显示项目计划数据")
	@RequestMapping(value = "/out-project-plan-provider/project-plan/page/list", method = RequestMethod.POST)
	public LayuiTableData selectProjectPlanByCond(@RequestBody LayuiTableParam param) throws Exception {
		logger.info("==================page selectProjectPlanByCond===========================" + param);
		return outProjectPlanService.selectProjectPlanByCond(param);
	}

	@ApiOperation(value = "直属研究院二级页面（领导），项目计划完成的比率，按照新开续建、资本性费用性来分组 ", notes = "参数年度")
	@RequestMapping(value = "/out-project-plan-provider/complete-rate/old-new")
	public JSONArray getPlanCompleteRateByOldNew(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getPlanCompleteRateByOldNew===========================" + map);
		map.put("nd", "2018");
		List temList = outProjectPlanService.getPlanCompleteRateByOldNew(map);
		
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "直属研究院二级页面（领导），总的签订率 ", notes = "参数年度")
	@RequestMapping(value = "/out-project-plan-provider/complete-rate/total")
	public JSONArray getPlanTotalCompleteRate(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getPlanTotalCompleteRate===========================" + map);
		map.put("nd", "2018");
		List temList = outProjectPlanService.getPlanTotalCompleteRate(map);
		
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "直属研究院二级页面（领导），各个院的合同签订率", notes = "参数年度")
	@RequestMapping(value = "/out-project-plan-provider/complete-rate/institute")
	public JSONArray getPlanCompleteRateByInstitute(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getPlanCompleteRateByInstitute===========================" + map);
		map.put("nd", "2018");
		List temList = outProjectPlanService.getPlanCompleteRateByInstitute(map);
		
		if (!JSON.toJSONString(temList).contains("勘探院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("zsl", 0);
			temMap.put("yqhtzj", 0);
			temMap.put("wqhtzj", 0);
			temMap.put("qdlzj", 0);
			temMap.put("zbxRate", 0);
			temMap.put("fyxRate", 0);
			temMap.put("fyxsjsl", 0);
			temMap.put("zbxsjsl", 0);
			temMap.put("define2", "勘探院");
			temList.add(0, temMap);
		}
		if (!JSON.toJSONString(temList).contains("物探院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("zsl", 0);
			temMap.put("yqhtzj", 0);
			temMap.put("wqhtzj", 0);
			temMap.put("qdlzj", 0);
			temMap.put("zbxRate", 0);
			temMap.put("fyxRate", 0);
			temMap.put("fyxsjsl", 0);
			temMap.put("zbxsjsl", 0);
			temMap.put("define2", "物探院");
			temList.add(1, temMap);
		}
		if (!JSON.toJSONString(temList).contains("工程院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("zsl", 0);
			temMap.put("yqhtzj", 0);
			temMap.put("wqhtzj", 0);
			temMap.put("qdlzj", 0);
			temMap.put("zbxRate", 0);
			temMap.put("fyxRate", 0);
			temMap.put("fyxsjsl", 0);
			temMap.put("zbxsjsl", 0);
			temMap.put("define2", "工程院");
			temList.add(2, temMap);
		}
		if (!JSON.toJSONString(temList).contains("石科院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("zsl", 0);
			temMap.put("yqhtzj", 0);
			temMap.put("wqhtzj", 0);
			temMap.put("qdlzj", 0);
			temMap.put("zbxRate", 0);
			temMap.put("fyxRate", 0);
			temMap.put("fyxsjsl", 0);
			temMap.put("zbxsjsl", 0);
			temMap.put("define2", "石科院");
			temList.add(3, temMap);
		}
		if (!JSON.toJSONString(temList).contains("大连院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("zsl", 0);
			temMap.put("yqhtzj", 0);
			temMap.put("wqhtzj", 0);
			temMap.put("qdlzj", 0);
			temMap.put("zbxRate", 0);
			temMap.put("fyxRate", 0);
			temMap.put("fyxsjsl", 0);
			temMap.put("zbxsjsl", 0);
			temMap.put("define2", "大连院");
			temList.add(4, temMap);
		}
		if (!JSON.toJSONString(temList).contains("北化院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("zsl", 0);
			temMap.put("yqhtzj", 0);
			temMap.put("wqhtzj", 0);
			temMap.put("qdlzj", 0);
			temMap.put("zbxRate", 0);
			temMap.put("fyxRate", 0);
			temMap.put("fyxsjsl", 0);
			temMap.put("zbxsjsl", 0);
			temMap.put("define2", "北化院");
			temList.add(5, temMap);
		}
		if (!JSON.toJSONString(temList).contains("上海院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("zsl", 0);
			temMap.put("yqhtzj", 0);
			temMap.put("wqhtzj", 0);
			temMap.put("qdlzj", 0);
			temMap.put("zbxRate", 0);
			temMap.put("fyxRate", 0);
			temMap.put("fyxsjsl", 0);
			temMap.put("zbxsjsl", 0);
			temMap.put("define2", "上海院");
			temList.add(6, temMap);
		}
		if (!JSON.toJSONString(temList).contains("安工院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("zsl", 0);
			temMap.put("yqhtzj", 0);
			temMap.put("wqhtzj", 0);
			temMap.put("qdlzj", 0);
			temMap.put("zbxRate", 0);
			temMap.put("fyxRate", 0);
			temMap.put("fyxsjsl", 0);
			temMap.put("zbxsjsl", 0);
			temMap.put("define2", "安工院");
			temList.add(7, temMap);
		}
		
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "直属研究院二级页面（领导），各个院的合同签订率", notes = "参数年度")
	@RequestMapping(value = "/out-project-plan-provider/money/complete-rate/institute")
	public JSONArray getPlanMoneyCompleteRateByInstitute(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getPlanMoneyCompleteRateByInstitute===========================" + map);
		map.put("nd", "2018");
		List temList = outProjectPlanService.getPlanMoneyCompleteRateByInstitute(map);
		
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "首页-直属研究院，项目计划完成的比率，按照资本性费用性来分组 ", notes = "参数年度")
	@RequestMapping(value = "/out-project-plan-provider/complete-rate/money-type")
	public JSONArray getPlanCompleteRateByPlanType(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getPlanCompleteRateByPlanType===========================" + map);
		map.put("nd", "2018");
		List temList = outProjectPlanService.getPlanCompleteRateByPlanType(map);
		
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "项目计划完成的比率，+ hana支付的费用，按照研究院来分组 ", notes = "参数年度")
	@RequestMapping(value = "/out-project-plan-provider/complete-rate/money-hana-type")
	public JSONArray getPlanCompleteRateByPlanTypeForHana(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getPlanCompleteRateByPlanTypeForHana===========================" + map);
		map.put("nd", "2018");
		map.put("month", "201812");
		List temList = outProjectPlanService.getPlanCompleteRateByPlanTypeForHana(map);
		
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "项目计划完成的比率，+ hana支付的费用，按照月份分组 ", notes = "参数年度")
	@RequestMapping(value = "/out-project-plan-provider/complete-rate/month/money-hana-type")
	public JSONArray getPlanCompleteRateByPlanTypeForHanaMonth(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getPlanCompleteRateByPlanTypeForHanaMonth===========================" + map);
		map.put("startMonth", "201801");
		map.put("endMonth", "201812");
		List temList = outProjectPlanService.getPlanCompleteRateByPlanTypeForHanaMonth(map);
		
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "领导首页-科研合同，项目计划完成的比率，按照直属研究所、分子公司等9个来分组", notes = "参数年度")
	@RequestMapping(value = "/out-project-plan-provider/complete-rate/company-type")
	public JSONArray getPlanCompleteRateByCompanyType(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getPlanCompleteRateByCompanyType===========================" + map);
		map.put("nd", "2018");
		List temList = outProjectPlanService.getPlanCompleteRateByCompanyType(map);
		
		if (!JSON.toJSONString(temList).contains("直属研究院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("jhqds", 0);
			temMap.put("sjqds", 0);
			temMap.put("qdbl", 0);
			
			temMap.put("define3", "直属研究院");
			temList.add(0, temMap);
		}
		if (!JSON.toJSONString(temList).contains("分子公司")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("jhqds", 0);
			temMap.put("sjqds", 0);
			temMap.put("qdbl", 0);
			
			temMap.put("define3", "分子公司");
			temList.add(1, temMap);
		}
		if (!JSON.toJSONString(temList).contains("外部单位")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("jhqds", 0);
			temMap.put("sjqds", 0);
			temMap.put("qdbl", 0);
			
			temMap.put("define3", "外部单位");
			temList.add(2, temMap);
		}
		if (!JSON.toJSONString(temList).contains("盈科")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("jhqds", 0);
			temMap.put("sjqds", 0);
			temMap.put("qdbl", 0);
			
			temMap.put("define3", "盈科");
			temList.add(3, temMap);
		}
		if (!JSON.toJSONString(temList).contains("休斯顿研发中心")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("jhqds", 0);
			temMap.put("sjqds", 0);
			temMap.put("qdbl", 0);
			
			temMap.put("define3", "休斯顿研发中心");
			temList.add(4, temMap);
		}
		if (!JSON.toJSONString(temList).contains("中东研发中心")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("jhqds", 0);
			temMap.put("sjqds", 0);
			temMap.put("qdbl", 0);
			
			temMap.put("define3", "中东研发中心");
			temList.add(5, temMap);
		}
		if (!JSON.toJSONString(temList).contains("股份付集团")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("jhqds", 0);
			temMap.put("sjqds", 0);
			temMap.put("qdbl", 0);

			temMap.put("define3", "股份付集团");
			temList.add(6, temMap);
		}
		if (!JSON.toJSONString(temList).contains("股份付资产")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("jhqds", 0);
			temMap.put("sjqds", 0);
			temMap.put("qdbl", 0);

			temMap.put("define3", "股份付资产");
			temList.add(7, temMap);
		}
		if (!JSON.toJSONString(temList).contains("集团公司")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("jhqds", 0);
			temMap.put("sjqds", 0);
			temMap.put("qdbl", 0);
			
			temMap.put("define3", "集团公司");
			temList.add(8, temMap);
		}
		if (!JSON.toJSONString(temList).contains("资产公司")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("jhqds", 0);
			temMap.put("sjqds", 0);
			temMap.put("qdbl", 0);
			temMap.put("define3", "资产公司");
			temList.add(9, temMap);
		}
		
		
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "领导首页-科研合同，项目计划完成的比率，按照直属研究所、分子公司等9个来分组", notes = "参数年度")
	@RequestMapping(value = "/out-project-plan-provider/money/complete-rate/company-type")
	public JSONArray getPlanMoneyCompleteRateByCompanyType(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getPlanMoneyCompleteRateByCompanyType===========================" + map);
		map.put("nd", "2018");
		List temList = outProjectPlanService.getPlanMoneyCompleteRateByCompanyType(map);
		
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "领导首页--科研投入--各个处室的新开结转情况", notes = "参数年度")
	@RequestMapping(value = "/out-project-plan-provider/plan-money/department")
	public JSONArray getPlanMoneyByDepartment(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getPlanMoneyByDepartment===========================" + map);
		map.put("nd", "2018");
		List temList = outProjectPlanService.getPlanMoneyByDepartment(map);
		
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "领导首页-科研合同，科研合同签订率清单", notes = "参数年度")
	@RequestMapping(value = "/out-project-plan-provider/contract-rate/details")
	public JSONArray getPlanCompleteRateDetails(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getPlanCompleteRateDetails===========================" + map);
		map.put("nd", "2018");
		List temList = outProjectPlanService.getPlanCompleteRateDetails(map);
		
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
}
