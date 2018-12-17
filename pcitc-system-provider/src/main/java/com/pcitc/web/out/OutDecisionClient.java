package com.pcitc.web.out;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.HashMap;
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
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.service.out.OutDecisionService;

@Api(value = "OUT-DECISION-API", description = "辅助决策相关的接口")
@RestController
public class OutDecisionClient {

	@Autowired
	private OutDecisionService	outDecisionService;

	private final static Logger	logger	= LoggerFactory.getLogger(OutDecisionClient.class);
	
	@ApiOperation(value = "经费预算建议--集团公司总部科技经费预算（建议稿）", notes = "参数年度")
	@RequestMapping(value = "/out-decision-provider/budget-proposals/group-company/stp-money")
	public JSONArray getGroupCompanyStpMoneyForBudgetProposals(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getGroupCompanyStpMoneyForBudgetProposals===========================" + map);
		
		List temList = outDecisionService.getGroupCompanyStpMoneyForBudgetProposals(map);
		
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "预算分配,经费预算分析,股份公司总部科技经费预算（建议稿）", notes = "参数年度")
	@RequestMapping(value = "/out-decision-provider/ysfp/jfysfx/stock-company-money")
	public JSONArray getStockCompanyMoneyTable(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getStockCompanyMoneyTable==========================="+map);

		List temList = outDecisionService.getStockCompanyMoneyTable(map);

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
	
	@ApiOperation(value = "知识产权分析,国际、国内专利数量统计", notes = "参数年度")
	@RequestMapping(value = "/out-decision-provider/zscq/patent-count/country-type")
	public JSONArray getPatentCountByCountryType(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getPatentCountByCountryType==========================="+map);

		List temList = outDecisionService.getPatentCountByCountryType(null);
		
		int totalsl1 = 0;
		int totalsl2 = 0;
		int totalsl3 = 0;
		for (int i = 0; i < temList.size(); i++) {
			Map temMap = (HashMap) temList.get(i);
			totalsl1 = totalsl1 + Integer.parseInt(temMap.get("sl1").toString());
			totalsl2 = totalsl2 + Integer.parseInt(temMap.get("sl2").toString());
			totalsl3 = totalsl3 + Integer.parseInt(temMap.get("sl3").toString());
		}
		
		HashMap<String, Object> temMap = new HashMap<String, Object>();
		temMap.put("sl1", totalsl1);
		temMap.put("sl2", totalsl2);
		temMap.put("sl3", totalsl3);
		temMap.put("patentName", "专利总数");
		temList.add(temMap);

		System.out.println("===="+JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "知识产权分析,各类型专利的数量，发明公布，发明授权，实用新型等", notes = "参数年度")
	@RequestMapping(value = "/out-decision-provider/zscq/patent-count/patent-type")
	public JSONArray getPatentCountByPatentType(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getPatentCountByPatentType==========================="+map);

		List temList = outDecisionService.getPatentCountByPatentType(null);
		
		if (!JSON.toJSONString(temList).contains("发明专利")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("sl", 0);
			temMap.put("typeName", "发明专利");
			temList.add(temMap);
		}
		
		if (!JSON.toJSONString(temList).contains("实用新型")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("sl", 0);
			temMap.put("typeName", "实用新型");
			temList.add(temMap);
		}
		
		if (!JSON.toJSONString(temList).contains("外观专利")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("sl", 0);
			temMap.put("typeName", "外观专利");
			temList.add(temMap);
		}
		
		if (!JSON.toJSONString(temList).contains("涉外专利")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("sl", 0);
			temMap.put("typeName", "涉外专利");
			temList.add(temMap);
		}

		System.out.println("===="+JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "知识产权分析,各类型专利的数量，8大研究院", notes = "参数年度")
	@RequestMapping(value = "/out-decision-provider/zscq/patent-count/institute")
	public JSONArray getPatentCountByInstitute(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getPatentCountByInstitute==========================="+map);

		List temList = outDecisionService.getPatentCountByInstitute(null);
		
		System.out.println("===="+JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "知识产权分析,专利申报情况明细分析表", notes = "分页显示项目数据")
	@RequestMapping(value = "/out-decision-provider/zscq/patent-detail/page", method = RequestMethod.POST)
	public LayuiTableData selectPatentDetailInfoByCond(@RequestBody LayuiTableParam param) throws Exception {
		logger.info("==================page selectPatentDetailInfoByCond===========================" + param);
		return outDecisionService.selectPatentDetailInfoByCond(param);
	}
	
	@ApiOperation(value = "处部门科技经费预算总表，各处、部门科技经费预算总表", notes = "参数年度")
	@RequestMapping(value = "/out-decision-provider/budget-proposals/department/stp-money")
	public JSONArray selectJFYSZBForDepartment(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page selectJFYSZBForDepartment===========================" + map);
		
		List temList = outDecisionService.selectJFYSZBForDepartment(map);
		
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "科技经费预算总表，集团经费预算明细表", notes = "参数年度")
	@RequestMapping(value = "/out-decision-provider/budget-proposals/group/stp-money")
	public JSONArray selectJFYSForGroup(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page selectJFYSForGroup===========================" + map);
		
		List temList = outDecisionService.selectJFYSForGroup(map);
		
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "科技经费预算总表，资产经费预算明细表", notes = "参数年度")
	@RequestMapping(value = "/out-decision-provider/budget-proposals/asset/stp-money")
	public JSONArray selectJFYSForAsset(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page selectJFYSForAsset===========================" + map);
		
		List temList = outDecisionService.selectJFYSForAsset(map);
		
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "科技经费预算总表，直属研究院科技经费预算表", notes = "参数年度")
	@RequestMapping(value = "/out-decision-provider/budget-proposals/institute/stp-money")
	public JSONArray selectJFYSForInstitute(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page selectJFYSForInstitute===========================" + map);
		
		List temList = outDecisionService.selectJFYSForInstitute(map);
		
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "科技经费预算总表，股份支付集团、外系统及盈科经费预算表", notes = "参数年度")
	@RequestMapping(value = "/out-decision-provider/budget-proposals/other/stp-money")
	public JSONArray selectJFYSForOther(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page selectJFYSForOther===========================" + map);
		
		List temList = outDecisionService.selectJFYSForOther(map);
		
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "科技经费预算总表，分子公司科技经费预算表", notes = "参数年度")
	@RequestMapping(value = "/out-decision-provider/budget-proposals/company/stp-money")
	public JSONArray selectJFYSForCompany(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page selectJFYSForCompany===========================" + map);
		
		List temList = outDecisionService.selectJFYSForCompany(map);
		
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "科技经费预算总表，分子公司科技经费预算表", notes = "参数年度")
	@RequestMapping(value = "/out-decision-provider/budget-proposals/b2c/stp-money")
	public JSONArray selectJFYSForB2c(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page selectJFYSForB2c===========================" + map);
		
		List temList = outDecisionService.selectJFYSForB2c(map);
		
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "科技经费预算总表，股份公司科技专项经费预算表", notes = "参数年度")
	@RequestMapping(value = "/out-decision-provider/budget-proposals/tech/stp-money")
	public JSONArray selectJFYSForTech(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page selectJFYSForTech===========================" + map);
		
		List temList = outDecisionService.selectJFYSForTech(map);
		int jnCount = 0;
		int qnCount = 0;
		int qiannCount = 0;
		for (int i = 0; i < temList.size(); i++) {
			HashMap<String, String> temMap = (HashMap<String, String>)temList.get(i);
			jnCount = jnCount + Integer.parseInt(temMap.get("jnCount"));
			qnCount = qnCount + Integer.parseInt(temMap.get("qnCount"));
			qiannCount = qiannCount + Integer.parseInt(temMap.get("qiannCount"));
		}
		
		HashMap<String, String> totalMap = new HashMap<String, String>();
		totalMap.put("showName", "专利总数");
		totalMap.put("jnCount", String.valueOf(jnCount));
		totalMap.put("qnCount", String.valueOf(qnCount));
		totalMap.put("qiannCount", String.valueOf(qiannCount));
		
		temList.add(0, totalMap);
		
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "知识产权分析，近三年国内外专利的情况", notes = "参数年度")
	@RequestMapping(value = "/out-decision-provider/patent/home-baroad/three-year")
	public JSONArray getPatentInfoByHomeAbroad(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getPatentInfoByHomeAbroad===========================" + map);
		
		List temList = outDecisionService.getPatentInfoByHomeAbroad(map);
		
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "辅助决策中心，知识产权分析,各个研究院知识产权的情况，去年和今年", notes = "参数年度")
	@RequestMapping(value = "/out-decision-provider/zscq/patent-count/year/institute")
	public JSONArray getPatentYearInfoByInstitute(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getPatentYearInfoByInstitute==========================="+map);

		List temList = outDecisionService.getPatentYearInfoByInstitute(map);
		
		System.out.println("===="+JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "辅助决策中心，奖励，最近几年的鉴定结论", notes = "参数年度")
	@RequestMapping(value = "/out-decision-provider/cgjd/appraisal/jdjg")
	public JSONArray getAppraisalInfoByJDJG(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getAppraisalInfoByJDJG==========================="+map);

		List temList = outDecisionService.getAppraisalInfoByJDJG(map);
		
		System.out.println("===="+JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	
	@ApiOperation(value = "辅助决策中心，成果，各个研究院成果情况", notes = "参数年度")
	@RequestMapping(value = "/out-decision-provider/cgjd/appraisal/institute")
	public JSONArray getAppraisalInfoByInstitute(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getAppraisalInfoByInstitute==========================="+map);

		List temList = outDecisionService.getAppraisalInfoByInstitute(map);
		
		System.out.println("===="+JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
}
