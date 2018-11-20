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
import com.pcitc.service.out.OutDecisionService;

@Api(value = "OUT-DECISION-API", description = "辅助决策相关的接口")
@RestController
public class OutDecisionClient {

	@Autowired
	private OutDecisionService	outDecisionService;

	private final static Logger	logger	= LoggerFactory.getLogger(OutDecisionClient.class);
	
	@ApiOperation(value = "经费预算建议--集团公司总部科技经费预算（建议稿）", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/budget-proposals/group-company/stp-money")
	public JSONArray getGroupCompanyStpMoneyForBudgetProposals(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getGroupCompanyStpMoneyForBudgetProposals===========================" + map);
		
		List temList = outDecisionService.getGroupCompanyStpMoneyForBudgetProposals("2018");
		
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "预算分配,经费预算分析,股份公司总部科技经费预算（建议稿）", notes = "参数年度")
	@RequestMapping(value = "/out-decision-provider/ysfp/jfysfx/stock-company-money")
	public JSONArray getStockCompanyMoneyTable(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getStockCompanyMoneyTable==========================="+map);

		List temList = outDecisionService.getStockCompanyMoneyTable("2018");

		System.out.println("===="+JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "预算分配,经费预算分析,各处、部门科技经费预算总表", notes = "参数年度")
	@RequestMapping(value = "/out-decision-provider/ysfp/jfysfx/department-budget")
	public JSONArray getDepartmentBudgetMoneyTable(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getDepartmentBudgetMoneyTable==========================="+map);

		List temList = outDecisionService.getDepartmentBudgetMoneyTable("2018");

		System.out.println("===="+JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

}
