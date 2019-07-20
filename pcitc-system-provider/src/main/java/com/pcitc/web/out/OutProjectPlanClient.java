package com.pcitc.web.out;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.pcitc.base.stp.budget.vo.BudgetItemSearchVo;
import com.pcitc.service.feign.stp.BudgetClient;
import com.pcitc.service.out.OutProjectPlanService;

@Api(value = "OUTPROJECTPLAN-API", description = "项目计划数据，从项目管理系统中获取")
@RestController
public class OutProjectPlanClient {

	@Autowired
	private OutProjectPlanService outProjectPlanService;

	@Autowired
	private BudgetClient budgetClient;

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
		List temList = outProjectPlanService.getPlanCompleteRateByOldNew(map);

		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "直属研究院二级页面（领导），总的签订率 ", notes = "参数年度")
	@RequestMapping(value = "/out-project-plan-provider/complete-rate/total")
	public JSONArray getPlanTotalCompleteRate(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getPlanTotalCompleteRate===========================" + map);
		List temList = outProjectPlanService.getPlanTotalCompleteRate(map);

		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "直属研究院二级页面（领导），总的科研投入，数据来源于hana ", notes = "参数年度")
	@RequestMapping(value = "/out-project-plan-provider/hana-invest/money")
	public JSONArray getTotalInvestMoneyWithHana(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getTotalInvestMoneyWithHana===========================" + map);
		List temList = outProjectPlanService.getTotalInvestMoneyWithHana(map);

		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "直属研究院二级页面（领导），各个院的合同签订率", notes = "参数年度")
	@RequestMapping(value = "/out-project-plan-provider/complete-rate/institute")
	public JSONArray getPlanCompleteRateByInstitute(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getPlanCompleteRateByInstitute===========================" + map);
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
		List temList = outProjectPlanService.getPlanMoneyCompleteRateByInstitute(map);

		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "首页-直属研究院，项目计划完成的比率，按照资本性费用性来分组 ", notes = "参数年度")
	@RequestMapping(value = "/out-project-plan-provider/complete-rate/money-type")
	public JSONArray getPlanCompleteRateByPlanType(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getPlanCompleteRateByPlanType===========================" + map);
		List temList = outProjectPlanService.getPlanCompleteRateByPlanType(map);

		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "项目计划完成的比率，+ hana支付的费用，按照研究院来分组 ", notes = "参数年度")
	@RequestMapping(value = "/out-project-plan-provider/complete-rate/money-hana-type")
	public JSONArray getPlanCompleteRateByPlanTypeForHana(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getPlanCompleteRateByPlanTypeForHana===========================" + map);
		String nd = map.get("nd");
		map.put("startMonth", nd + "01");
		map.put("endMonth", nd + "12");
		List temList = outProjectPlanService.getPlanCompleteRateByPlanTypeForHana(map);

		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "项目计划完成的比率，+ hana支付的费用，按照月份分组 ", notes = "参数年度")
	@RequestMapping(value = "/out-project-plan-provider/complete-rate/month/money-hana-type")
	public JSONArray getPlanCompleteRateByPlanTypeForHanaMonth(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getPlanCompleteRateByPlanTypeForHanaMonth===========================" + map);
		String nd = map.get("nd");
		map.put("startMonth", nd + "01");
		map.put("endMonth", nd + "12");
		List temList = outProjectPlanService.getPlanCompleteRateByPlanTypeForHanaMonth(map);

		String zysje = "0";
		for (int i = 0; i < temList.size(); i++) {
			Map temMap = (HashMap) temList.get(i);
			if (temMap != null && temMap.get("zysje") != null && Float.parseFloat(temMap.get("zysje").toString()) != 0) {
				zysje = temMap.get("zysje").toString();
				break;
			}
		}

		for (int i = 0; i < temList.size(); i++) {
			Map temMap = (HashMap) temList.get(i);
			temMap.put("zysje", zysje);
		}

		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "领导首页-科研合同，项目计划完成的比率，按照直属研究所、分子公司等9个来分组", notes = "参数年度")
	@RequestMapping(value = "/out-project-plan-provider/complete-rate/company-type")
	public JSONArray getPlanCompleteRateByCompanyType(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getPlanCompleteRateByCompanyType===========================" + map);
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
		// 获取费用性预算
		BudgetItemSearchVo vo = new BudgetItemSearchVo();
		vo.setNd(map.get("nd"));
		String zycbm = map.get("zycbm");
		Set<String> set = new HashSet<>(Arrays.asList(zycbm.split(",")));
		List<String> list_1 = new ArrayList<>(set);
		vo.getUnitIds().addAll(list_1);
		vo = budgetClient.selectBudgetInfoList(vo);
		List<Map<String, Object>> budMoneyList = vo.getBudgetByAllUnit();

		// 获取实际的科研投入(费用性和资本性)
		List actMoneyList = outProjectPlanService.getPlanMoneyCompleteRateByCompanyType(map);

		// 资本性预算，只能由拥有计划处（30130054）等特殊处室的人能看到.X轴显示无合同的（基金、马永生工作室）
		List zbxMoneyList = null;
		boolean zbxFlag = false;
		List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();
		if ((zycbm != null && (zycbm.indexOf("30130054") > -1)) || (map.get("leaderFlag") != null && (map.get("leaderFlag").toString().equals("2")))) {
			zbxFlag = true;
			zbxMoneyList = outProjectPlanService.getOutTemMoneyTotalInfo(map);
		}
		for (int i = 0; i < budMoneyList.size(); i++) {
			Map<String, Object> bm = budMoneyList.get(i);
			for (int k = 0; k < actMoneyList.size(); k++) {
				Map<String, Object> actMoney = (Map<String, Object>) actMoneyList.get(k);
				if (bm.get("budgetItemName") != null && bm.get("budgetItemName").toString().contains("研究院") && actMoney.get("type_flag") != null && actMoney.get("type_flag").toString().contains("研究院")) {
					// 费用性预算金额、费用性实际投入金额、投入比率、 资本性实际投入、总实际投入
					bm = this.getMoneyProperty1(bm, actMoney, zbxFlag);
					break;
				}

				if (bm.get("budgetItemName") != null && bm.get("budgetItemName").toString().contains("分子公司") && actMoney.get("type_flag") != null && actMoney.get("type_flag").toString().contains("分子公司")) {
					// 费用性预算金额、费用性实际投入金额、投入比率、 资本性实际投入、总实际投入
					bm = this.getMoneyProperty1(bm, actMoney, zbxFlag);
					break;
				}

				if (bm.get("budgetItemName") != null && bm.get("budgetItemName").toString().contains("集团单位") && actMoney.get("type_flag") != null && (actMoney.get("type_flag").toString().contains("集团单位") || actMoney.get("type_flag").toString().contains("股份付集团"))) {
					// 费用性预算金额、费用性实际投入金额、投入比率、 资本性实际投入、总实际投入
					bm = this.getMoneyProperty1(bm, actMoney, zbxFlag);
					break;
				}

				if (bm.get("budgetItemName") != null && bm.get("budgetItemName").toString().contains("外部单位") && actMoney.get("type_flag") != null && actMoney.get("type_flag").toString().contains("外部单位")) {
					// 费用性预算金额、费用性实际投入金额、投入比率、 资本性实际投入、总实际投入
					bm = this.getMoneyProperty1(bm, actMoney, zbxFlag);
					break;
				}

				if (bm.get("budgetItemName") != null && bm.get("budgetItemName").toString().contains("盈科") && actMoney.get("type_flag") != null && actMoney.get("type_flag").toString().contains("盈科")) {
					// 费用性预算金额、费用性实际投入金额、投入比率、 资本性实际投入、总实际投入
					bm = this.getMoneyProperty1(bm, actMoney, zbxFlag);
					break;
				}

				if (bm.get("budgetItemName") != null && bm.get("budgetItemName").toString().contains("休斯顿") && actMoney.get("type_flag") != null && actMoney.get("type_flag").toString().contains("休斯顿")) {
					// 费用性预算金额、费用性实际投入金额、投入比率、 资本性实际投入、总实际投入
					bm = this.getMoneyProperty1(bm, actMoney, zbxFlag);
					break;
				}

				if (bm.get("budgetItemName") != null && bm.get("budgetItemName").toString().contains("中东") && actMoney.get("type_flag") != null && actMoney.get("type_flag").toString().contains("中东")) {
					// 费用性预算金额、费用性实际投入金额、投入比率、 资本性实际投入、总实际投入
					bm = this.getMoneyProperty1(bm, actMoney, zbxFlag);
					break;
				}

				if (bm.get("budgetItemName") != null && bm.get("budgetItemName").toString().contains("集团公司") && actMoney.get("type_flag") != null && actMoney.get("type_flag").toString().contains("集团公司")) {
					// 费用性预算金额、费用性实际投入金额、投入比率、 资本性实际投入、总实际投入
					bm = this.getMoneyProperty1(bm, actMoney, zbxFlag);
					break;
				}

				if (bm.get("budgetItemName") != null && bm.get("budgetItemName").toString().contains("资产公司") && actMoney.get("type_flag") != null && actMoney.get("type_flag").toString().contains("资产公司")) {
					// 费用性预算金额、费用性实际投入金额、投入比率、 资本性实际投入、总实际投入
					bm = this.getMoneyProperty1(bm, actMoney, zbxFlag);
					break;
				}
			}
		}

		// 如果有看资本性预算的权限的话
		if (zbxFlag) {
			for (int i = 0; i < budMoneyList.size(); i++) {
				Map<String, Object> bm = budMoneyList.get(i);
				for (int k = 0; k < zbxMoneyList.size(); k++) {
					Map<String, Object> zbxMoney = (Map<String, Object>) zbxMoneyList.get(k);
					if (bm.get("budgetItemName") != null && bm.get("budgetItemName").toString().contains("研究院") && zbxMoney.get("show_ali") != null && zbxMoney.get("show_ali").toString().contains("研究院")) {
						// 资本性预算金额、总预算金额、资本性投入比率、总费用投入比
						bm = this.getMoneyProperty2(bm, zbxMoney, zbxFlag);
						break;
					}

					if (bm.get("budgetItemName") != null && bm.get("budgetItemName").toString().contains("分子公司") && zbxMoney.get("show_ali") != null && zbxMoney.get("show_ali").toString().contains("分子公司")) {
						// 资本性预算金额、总预算金额、资本性投入比率、总费用投入比
						bm = this.getMoneyProperty2(bm, zbxMoney, zbxFlag);
						break;
					}

					if (bm.get("budgetItemName") != null && bm.get("budgetItemName").toString().contains("集团单位") && zbxMoney.get("show_ali") != null && (zbxMoney.get("show_ali").toString().contains("集团单位") || zbxMoney.get("show_ali").toString().contains("股份付集团"))) {
						// 资本性预算金额、总预算金额、资本性投入比率、总费用投入比
						bm = this.getMoneyProperty2(bm, zbxMoney, zbxFlag);
						break;
					}

					if (bm.get("budgetItemName") != null && bm.get("budgetItemName").toString().contains("外部单位") && zbxMoney.get("show_ali") != null && zbxMoney.get("show_ali").toString().contains("外部单位")) {
						// 资本性预算金额、总预算金额、资本性投入比率、总费用投入比
						bm = this.getMoneyProperty2(bm, zbxMoney, zbxFlag);
						break;
					}

					if (bm.get("budgetItemName") != null && bm.get("budgetItemName").toString().contains("盈科") && zbxMoney.get("show_ali") != null && zbxMoney.get("show_ali").toString().contains("盈科")) {
						// 资本性预算金额、总预算金额、资本性投入比率、总费用投入比
						bm = this.getMoneyProperty2(bm, zbxMoney, zbxFlag);
						break;
					}

					if (bm.get("budgetItemName") != null && bm.get("budgetItemName").toString().contains("休斯顿") && zbxMoney.get("show_ali") != null && zbxMoney.get("show_ali").toString().contains("休斯顿")) {
						// 资本性预算金额、总预算金额、资本性投入比率、总费用投入比
						bm = this.getMoneyProperty2(bm, zbxMoney, zbxFlag);
						break;
					}

					if (bm.get("budgetItemName") != null && bm.get("budgetItemName").toString().contains("中东") && zbxMoney.get("show_ali") != null && zbxMoney.get("show_ali").toString().contains("中东")) {
						// 资本性预算金额、总预算金额、资本性投入比率、总费用投入比
						bm = this.getMoneyProperty2(bm, zbxMoney, zbxFlag);
						break;
					}

					if (bm.get("budgetItemName") != null && bm.get("budgetItemName").toString().contains("集团公司") && zbxMoney.get("show_ali") != null && zbxMoney.get("show_ali").toString().contains("集团公司")) {
						// 资本性预算金额、总预算金额、资本性投入比率、总费用投入比
						bm = this.getMoneyProperty2(bm, zbxMoney, zbxFlag);
						break;
					}

					if (bm.get("budgetItemName") != null && bm.get("budgetItemName").toString().contains("资产公司") && zbxMoney.get("show_ali") != null && zbxMoney.get("show_ali").toString().contains("资产公司")) {
						// 资本性预算金额、总预算金额、资本性投入比率、总费用投入比
						bm = this.getMoneyProperty2(bm, zbxMoney, zbxFlag);
						break;
					}
				}
			}
		} else {
			for (int i = 0; i < budMoneyList.size(); i++) {
				Map<String, Object> bm = budMoneyList.get(i);
				// 资本性预算金额、资本性投入比率、总预算金额、总费用投入比
				bm.put("zbxysje", "0");
				bm.put("zbxRate", "0");

				bm.put("zysje", Double.parseDouble(bm.get("zbxysje") == null ? "0" : bm.get("zbxysje").toString()) + Double.parseDouble(bm.get("fyxysje") == null ? "0" : bm.get("fyxysje").toString()));

				if (bm.get("zysje") == null || bm.get("zsjje") == null || bm.get("zysje").toString().equals("0") || bm.get("zsjje").toString().equals("0")) {
					bm.put("zRate", "");
				} else {
					bm.put("zRate", Double.parseDouble(bm.get("zsjje").toString()) * 100 / Double.parseDouble(bm.get("zysje").toString()));
				}
			}
		}

		// 应包含专项、机动等费用（预算和实际，都从预算接口中获取）,budMoneyList中添加这些
		if (zbxFlag) {
			map.put("unitCode", "ZX,JD");
			List zxjdList = outProjectPlanService.getOutTemMoneyDecomposeInfo(map);
			for (int i = 0; i < zxjdList.size(); i++) {
				Map<String, Object> temMap = (Map<String, Object>) zxjdList.get(i);
				Map<String, Object> zxjdMap = new HashMap<String, Object>();
				zxjdMap.put("budgetItemName", temMap.get("cb"));
				zxjdMap.put("zysje", temMap.get("jfyszjys"));
				zxjdMap.put("zsjje", "0"); // 暂定
				zxjdMap.put("zRate", "0"); // 暂定

				zxjdMap.put("zbxysje", "0"); // 暂定
				zxjdMap.put("zbxsjje", "0"); // 暂定
				zxjdMap.put("zbxRate", "0"); // 暂定

				zxjdMap.put("fyxysje", temMap.get("jfyszjys")); // 暂定
				zxjdMap.put("fyxsjje", "0"); // 暂定
				zxjdMap.put("fyxRate", "0"); // 暂定
				budMoneyList.add(zxjdMap);
			}
			retList = budMoneyList;
		} else {
			// 没有权限，只能看到研究院、分子公司等常用的几个
			for (int i = 0; i < budMoneyList.size(); i++) {
				Map<String, Object> temMap = (Map<String, Object>) budMoneyList.get(i);
				if (temMap.get("budgetItemName") != null && temMap.get("budgetItemName").toString().contains("研究院")) {
					retList.add(temMap);
				}
				if (temMap.get("budgetItemName") != null && temMap.get("budgetItemName").toString().contains("分子公司")) {
					retList.add(temMap);
				}
				if (temMap.get("budgetItemName") != null && (temMap.get("budgetItemName").toString().contains("集团单位") || temMap.get("budgetItemName").toString().contains("股份付集团"))) {
					retList.add(temMap);
				}
				if (temMap.get("budgetItemName") != null && temMap.get("budgetItemName").toString().contains("外部单位")) {
					retList.add(temMap);
				}
				if (temMap.get("budgetItemName") != null && temMap.get("budgetItemName").toString().contains("盈科")) {
					retList.add(temMap);
				}
				if (temMap.get("budgetItemName") != null && temMap.get("budgetItemName").toString().contains("休斯顿")) {
					retList.add(temMap);
				}
				if (temMap.get("budgetItemName") != null && temMap.get("budgetItemName").toString().contains("中东")) {
					retList.add(temMap);
				}
				if (temMap.get("budgetItemName") != null && temMap.get("budgetItemName").toString().contains("集团公司")) {
					retList.add(temMap);
				}
				if (temMap.get("budgetItemName") != null && temMap.get("budgetItemName").toString().contains("资产公司")) {
					retList.add(temMap);
				}
			}
		}

		JSONArray json = JSONArray.parseArray(JSON.toJSONString(retList));
		return json;
	}

	/**
	 * 费用性预算金额、费用性实际投入金额、费用性投入比率、 资本性实际投入、总实际投入
	 */
	private Map<String, Object> getMoneyProperty1(Map<String, Object> bm, Map<String, Object> actMoney, boolean zbxFlag) {
		bm.put("fyxysje", bm.get("total") == null ? "0" : bm.get("total"));
		bm.put("fyxsjje", actMoney.get("fyxsjje") == null ? "0" : actMoney.get("fyxsjje"));
		if (bm.get("fyxysje").toString().equals("0")) {
			bm.put("fyxRate", 0);
		} else {
			bm.put("fyxRate", Double.parseDouble(actMoney.get("fyxsjje").toString()) * 100 / Double.parseDouble(bm.get("fyxysje").toString()));
		}
		
		if (zbxFlag) {
			bm.put("zbxsjje", actMoney.get("zbxsjje") == null ? "0" : actMoney.get("zbxsjje"));
			bm.put("zsjje", Double.parseDouble(actMoney.get("zbxsjje").toString()) + Double.parseDouble(actMoney.get("fyxsjje").toString()));
		} else {
			bm.put("zbxsjje", 0);
			bm.put("zsjje", actMoney.get("fyxsjje"));
		}
		return bm;
	}

	/**
	 * 资本性预算金额、总预算金额、资本性投入比率、总费用投入比
	 */
	private Map<String, Object> getMoneyProperty2(Map<String, Object> bm, Map<String, Object> zbxMoney, boolean zbxFlag) {
		bm.put("zbxysje", zbxMoney.get("zbx_money").toString());
		bm.put("zysje", Double.parseDouble(bm.get("zbxysje") == null ? "0" : bm.get("zbxysje").toString()) + Double.parseDouble(bm.get("fyxysje") == null ? "0" : bm.get("fyxysje").toString()));
		if (zbxMoney.get("zbx_money").equals("0")) {
			bm.put("zbxRate", "");
		} else {
			bm.put("zbxRate", Double.parseDouble(bm.get("zbxsjje").toString()) * 100 / Double.parseDouble(bm.get("zbxysje").toString()));
		}

		if (bm.get("zysje") == null || bm.get("zsjje") == null || bm.get("zysje").toString().equals("0") || bm.get("zsjje").toString().equals("0")) {
			bm.put("zRate", "");
		} else {
			bm.put("zRate", Double.parseDouble(bm.get("zsjje").toString()) * 100 / Double.parseDouble(bm.get("zysje").toString()));
		}
		return bm;
	}

	@ApiOperation(value = "领导首页--科研投入--各个处室的新开结转情况", notes = "参数年度")
	@RequestMapping(value = "/out-project-plan-provider/plan-money/department")
	public JSONArray getPlanMoneyByDepartment(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getPlanMoneyByDepartment===========================" + map);
		List temList = outProjectPlanService.getPlanMoneyByDepartment(map);

		if (temList == null || temList.size() == 0) {
			temList = outProjectPlanService.getPlanMoneyByDepartmentSpecial(map);
		}

		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "领导首页-科研合同，科研合同签订率清单", notes = "参数年度")
	@RequestMapping(value = "/out-project-plan-provider/contract-rate/details")
	public JSONArray getPlanCompleteRateDetails(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getPlanCompleteRateDetails===========================" + map);
		List temList = outProjectPlanService.getPlanCompleteRateDetails(map);

		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

}
