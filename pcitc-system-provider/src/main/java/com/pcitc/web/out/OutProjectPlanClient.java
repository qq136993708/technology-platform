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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.budget.vo.BudgetItemSearchVo;
import com.pcitc.base.stp.equipment.SreEquipment;
import com.pcitc.base.stp.out.OutProjectPlan;
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
	
	@ApiOperation(value = "按照专业处分组，来统计各个专业处计划签订合同数量，实际签订合同数量", notes = "参数年度")
	@RequestMapping(value = "/out-project-plan-provider/zyc/plan/count")
	public JSONArray getPlanCountForZYC(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getPlanCountForZYC===========================" + map);
		List temList = outProjectPlanService.getPlanCountForZYC(map);

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

		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "直属研究院二级页面（领导），各个院的合同签订率", notes = "参数年度")
	@RequestMapping(value = "/out-project-plan-provider/money/complete-rate/institute")
	public JSONArray getPlanMoneyCompleteRateByInstitute(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getPlanMoneyCompleteRateByInstitute===========================" + map);
		String zycbm = map.get("zycbm");
		if (zycbm != null && zycbm.contains("30130054")) {
			map.put("leaderFlag", "2");
		}
		if (map.get("leaderFlag") != null && map.get("leaderFlag").toString().equals("2")) {
			// 大领导特殊，能看所有的费用性预算
			zycbm = "30130055,30130064,30130065,30130056,30130057,30130058,30130059,30130054,30130063,30130062,30130061,30130011,30130010,30130015,3013000902,30130009,30130016,ZX,JD";
		}
		
		List temList = outProjectPlanService.getPlanMoneyCompleteRateByInstitute(map);

		BudgetItemSearchVo vo = new BudgetItemSearchVo();
		vo.setNd(map.get("nd"));
		
		// 预算中，科技部外的部门特殊处理
		if (zycbm.contains("30130011")) {
			zycbm = zycbm + ",30130011";
		}
		if (zycbm.contains("30130016")) {
			zycbm = zycbm + ",30130016";
		}
		if (zycbm.contains("30130009")) {
			zycbm = zycbm + ",30130009";
		}
		Set<String> set = new HashSet<>(Arrays.asList(zycbm.split(",")));
		List<String> list_1 = new ArrayList<>(set);

		vo.getUnitIds().addAll(list_1);
		vo.getBudgetItemCodes().add("ROOT_ZGSHJT_GFGS_ZSYJY_KTY");
		vo.getBudgetItemCodes().add("ROOT_ZGSHJT_GFGS_ZSYJY_GCY");
		vo.getBudgetItemCodes().add("ROOT_ZGSHJT_GFGS_ZSYJY_WTY");
		vo.getBudgetItemCodes().add("ROOT_ZGSHJT_GFGS_ZSYJY_SKY");
		vo.getBudgetItemCodes().add("ROOT_ZGSHJT_GFGS_ZSYJY_DLY");
		vo.getBudgetItemCodes().add("ROOT_ZGSHJT_GFGS_ZSYJY_BHY");
		vo.getBudgetItemCodes().add("ROOT_ZGSHJT_GFGS_ZSYJY_SHY");
		vo.getBudgetItemCodes().add("ROOT_ZGSHJT_GFGS_ZSYJY_AGY");
		vo = budgetClient.selectBudgetInfoList(vo);
		List<Map<String, Object>> budMoneyList = vo.getBudgetByAllUnit();

		for (int i = 0; i < temList.size(); i++) {
			Map<String, Object> temMap = (HashMap<String, Object>) temList.get(i);
			for (int k = 0; i < budMoneyList.size(); k++) {
				Map<String, Object> budMap = budMoneyList.get(k);
				if (budMap.get("budgetItemName") != null && budMap.get("budgetItemName").toString().equals(temMap.get("define2"))) {
					temMap.put("zysje", budMap.get("total") == null ? "0" : budMap.get("total").toString());
					temMap.put("wxdje", Double.parseDouble(temMap.get("zysje").toString()) - Double.parseDouble(temMap.get("zsjje").toString()));
					temMap.put("jeRate", Double.parseDouble(temMap.get("zsjje").toString()) * 100 / Double.parseDouble(temMap.get("zysje").toString()));
					break;
				}
			}
		}

		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		System.out.println("======" + json.toJSONString());
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
		String zycbm = map.get("zycbm");
		boolean zbxFlag = false;
		if (zycbm != null && zycbm.contains("30130054")) {
			map.put("leaderFlag", "2");
		}
		if (map.get("leaderFlag") != null && map.get("leaderFlag").toString().equals("2")) {
			// 大领导、计划处特殊，能看所有的费用性预算
			System.out.println("1大领导、计划处特殊，能看所有的费用性预算、专项机动");
			zbxFlag = true;
			zycbm = "30130055,30130064,30130065,30130056,30130057,30130058,30130059,30130054,30130063,30130062,30130061,30130011,30130010,30130015,3013000902,30130009,30130016,ZX,JD";
		}
		// 实际资本性金额、实际费用性金额、hanaMoney拨款金额
		List temList = outProjectPlanService.getPlanCompleteRateByPlanTypeForHana(map);

		// 获取研究院预算，根据其管理的专业处不同有所不同
		BudgetItemSearchVo vo = new BudgetItemSearchVo();
		vo.setNd(map.get("nd"));
		
		if (zycbm == null) {
			zycbm = "xxxxxxxx";
		}
		// 预算中，科技部外的部门特殊处理
		if (zycbm.contains("30130011")) {
			zycbm = zycbm + ",30130011";
		}
		if (zycbm.contains("30130016")) {
			zycbm = zycbm + ",30130016";
		}
		if (zycbm.contains("30130009")) {
			zycbm = zycbm + ",30130009";
		}
		map.put("zycbm", zycbm);
		System.out.println(zbxFlag + "预算专业处编码-----" + zycbm);
		Set<String> set = new HashSet<>(Arrays.asList(zycbm.split(",")));
		List<String> list_1 = new ArrayList<>(set);
		vo.getUnitIds().addAll(list_1);
		vo.getBudgetItemCodes().add("ROOT_ZGSHJT_GFGS_ZSYJY_KTY");
		vo.getBudgetItemCodes().add("ROOT_ZGSHJT_GFGS_ZSYJY_GCY");
		vo.getBudgetItemCodes().add("ROOT_ZGSHJT_GFGS_ZSYJY_WTY");
		vo.getBudgetItemCodes().add("ROOT_ZGSHJT_GFGS_ZSYJY_SKY");
		vo.getBudgetItemCodes().add("ROOT_ZGSHJT_GFGS_ZSYJY_DLY");
		vo.getBudgetItemCodes().add("ROOT_ZGSHJT_GFGS_ZSYJY_BHY");
		vo.getBudgetItemCodes().add("ROOT_ZGSHJT_GFGS_ZSYJY_SHY");
		vo.getBudgetItemCodes().add("ROOT_ZGSHJT_GFGS_ZSYJY_AGY");
		vo = budgetClient.selectBudgetInfoList(vo);
		// 费用性预算金额
		List<Map<String, Object>> fyxBudgetList = vo.getBudgetByAllUnit();

		// 资本性预算金额
		List<Map<String, Object>> zbxMoneyList = new ArrayList<Map<String, Object>>();
		if (zbxFlag) {
			map.put("moneyLevel", "3");
			map.put("unitCode", "ROOT_ZGSHJT_GFGS_ZSYJY");
			zbxMoneyList = outProjectPlanService.getOutTemMoneyTotalInfoWithCondition(map);
		}

		for (int i = 0; i < temList.size(); i++) {
			Map<String, Object> temMap = (Map<String, Object>) temList.get(i);
			for (int j = 0; j < fyxBudgetList.size(); j++) {
				Map<String, Object> bm = fyxBudgetList.get(j);
				if (temMap.get("define2").toString().equals(bm.get("budgetItemName").toString())) {
					temMap.put("fyxXqBudget", bm.get("xq") == null ? "0" : bm.get("xq"));
					System.out.println("预算各研究院金额fyxXqBudget-----" + bm.get("budgetItemName") + "========" + bm.get("xq"));
					break;
				}
			}
			// 领导及专业处，计算资本性预算金额
			for (int j = 0; j < zbxMoneyList.size(); j++) {
				Map<String, Object> zbxMap = zbxMoneyList.get(j);
				if (temMap.get("define2").toString().equals(zbxMap.get("show_ali").toString())) {
					temMap.put("zbxBudget", Double.parseDouble(zbxMap.get("zbx_money").toString()));
					System.out.println("预算各研究院资本性金额-----" + zbxMap.get("show_ali") + "========" + zbxMap.get("zbx_money"));
					break;
				}
			}
		}

		// 未下单金额（总预算-总实际）、je比率
		for (int i = 0; i < temList.size(); i++) {
			Map<String, Object> temMap = (Map<String, Object>) temList.get(i);
			
			if (temMap.get("ysfyxje") == null) temMap.put("ysfyxje", 0d);
			if (temMap.get("yszbxje") == null) temMap.put("yszbxje", 0d);
			if (temMap.get("fyxXqBudget") == null) temMap.put("fyxXqBudget", 0d);
			if (temMap.get("zbxBudget") == null) temMap.put("zbxBudget", 0d);
			
			
			Double ysfyxje = Double.parseDouble(temMap.get("ysfyxje").toString());
			Double yszbxje = Double.parseDouble(temMap.get("yszbxje").toString());
			Double fyxXqBudget = Double.parseDouble(temMap.get("fyxXqBudget").toString());
			Double zbxBudget = Double.parseDouble(temMap.get("zbxBudget").toString());
			if (ysfyxje != 0 && fyxXqBudget != 0) {
				temMap.put("fyxXqRate", String.format("%.2f", ysfyxje * 100 / fyxXqBudget));
			} else {
				temMap.put("fyxXqRate", 0);
			}
			if (yszbxje != 0 && zbxBudget != 0) {
				temMap.put("zbxRate", String.format("%.2f", yszbxje * 100 / zbxBudget));
			} else {
				temMap.put("zbxRate", 0);
			}
			if (!zbxFlag) {
				temMap.put("hanaMoney", "0");
				temMap.put("yszbxje", "0");
				temMap.put("zbxBudget", "0");
				temMap.put("zbxRate", "0");
			}
		}

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
		boolean zbxFlag = false;
		String zycbm = map.get("zycbm");
		if (zycbm != null && zycbm.contains("30130054")) {
			map.put("leaderFlag", "2");
		}
		if (map.get("leaderFlag") != null && map.get("leaderFlag").toString().equals("2")) {
			// 大领导、计划处特殊，能看所有的费用性预算
			zbxFlag = true;
			System.out.println("1大领导、计划处特殊，能看所有的费用性预算、专项机动");
			zycbm = "30130055,30130064,30130065,30130056,30130057,30130058,30130059,30130054,30130063,30130062,30130061,30130011,30130010,30130015,3013000902,30130009,30130016,ZX,JD";
		}
		
		List temList = outProjectPlanService.getPlanCompleteRateByPlanTypeForHanaMonth(map);

		// 获取研究院预算，根据其管理的专业处不同有所不同
		BudgetItemSearchVo vo = new BudgetItemSearchVo();
		vo.setNd(map.get("nd"));
		
		if (zycbm == null) {
			zycbm = "xxxxxxxx";
		}
		// 预算中，科技部外的部门特殊处理
		if (zycbm.contains("30130011")) {
			zycbm = zycbm + ",30130011";
		}
		if (zycbm.contains("30130016")) {
			zycbm = zycbm + ",30130016";
		}
		if (zycbm.contains("30130009")) {
			zycbm = zycbm + ",30130009";
		}
		map.put("zycbm", zycbm);
		System.out.println("预算专业处编码-----" + zycbm);
		Set<String> set = new HashSet<>(Arrays.asList(zycbm.split(",")));
		List<String> list_1 = new ArrayList<>(set);
		vo.getUnitIds().addAll(list_1);
		vo = budgetClient.selectBudgetInfoList(vo);
		// 费用性预算金额
		List<Map<String, Object>> budMoneyList = vo.getBudgetByAllUnit();

		String fyxXqBudget = "0";
		String zbxBudget = "0";
		for (int i = 0; i < budMoneyList.size(); i++) {
			Map temMap = (HashMap) budMoneyList.get(i);
			if (temMap.get("budgetItemName") != null && temMap.get("budgetItemName").toString().contains("研究院")) {
				// 费用性预算（新签，不含结转）
				fyxXqBudget = temMap.get("xq") == null ? "0" : temMap.get("xq").toString();
				System.out.println("新签预算研究院-----" + temMap.get("budgetItemName") + "========" + fyxXqBudget);
				break;
			}
		}
		// 资本性预算金额(只有领导和计划处计算）、专项机动金额
		List<Map<String, Object>> zbxMoneyList = new ArrayList<Map<String, Object>>();
		if (zbxFlag) {
			zbxMoneyList = outProjectPlanService.getOutTemMoneyTotalInfo(map);
			for (int j = 0; j < zbxMoneyList.size(); j++) {
				Map<String, Object> zbxMap = zbxMoneyList.get(j);
				if (zbxMap.get("show_ali").toString().contains("研究院")) {
					zbxBudget = String.valueOf(Double.parseDouble(zbxMap.get("zbx_money").toString()));
					System.out.println("预算研究院资本性金额-----" + zbxMap.get("zbx_money") + "========" + zbxBudget);
					break;
				}
			}
		}

		System.out.println("2预算金额=========" + zbxBudget);
		for (int i = 0; i < temList.size(); i++) {
			Map temMap = (HashMap) temList.get(i);
			temMap.put("fyxXqBudget", fyxXqBudget);
			temMap.put("zbxBudget", zbxBudget);
			if (!zbxFlag) {
				// 其他部门不让看到拨款金额
				temMap.put("hanaMoney", "0");
			}
		}
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		System.out.println("getPlanCompleteRateByPlanTypeForHanaMonth-----" + JSON.toJSONString(temList));
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
		if (!JSON.toJSONString(temList).contains("集团单位")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("jhqds", 0);
			temMap.put("sjqds", 0);
			temMap.put("qdbl", 0);

			temMap.put("define3", "集团单位");
			temList.add(6, temMap);
		}
		if (!JSON.toJSONString(temList).contains("资产单位")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("jhqds", 0);
			temMap.put("sjqds", 0);
			temMap.put("qdbl", 0);

			temMap.put("define3", "资产单位");
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
		String zylbbm = map.get("zylbbm");
		boolean zbxFlag = false;
		// 获取实际的科研投入(费用性和资本性)
		List actMoneyList = null;

		// 资本性预算，只能由拥有计划处（30130054）等特殊处室的人能看到.X轴显示无合同的（基金、马永生工作室）
		List ysMoneyList = null;

		List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();

		if (zycbm != null && zycbm.contains("30130054")) {
			map.put("leaderFlag", "2");
		}
		if (map.get("leaderFlag") != null && map.get("leaderFlag").toString().equals("2")) {
			// 大领导特殊，能看所有的费用性预算
			zbxFlag = true;
			zycbm = "30130055,30130064,30130065,30130056,30130057,30130058,30130059,30130054,30130063,30130062,30130061,30130011,30130010,30130015,3013000902,30130009,30130016,ZX,JD";
			map.put("zycbm", zycbm);

			actMoneyList = outProjectPlanService.getPlanMoneyCompleteRateByCompanyType(map);

			// 直接获取预算总表数据
			ysMoneyList = outProjectPlanService.getOutTemMoneyTotalInfo(map);

			// 数据处理
			for (int k = 0; k < ysMoneyList.size(); k++) {
				Map<String, Object> ysMoney = (Map<String, Object>) ysMoneyList.get(k);
				boolean configFlag = false;
				for (int j = 0; j < actMoneyList.size(); j++) {
					Map<String, Object> actMoney = (Map<String, Object>) actMoneyList.get(j);
					if (actMoney != null) {
						if (ysMoney.get("show_ali") != null && actMoney.get("type_flag") != null && ysMoney.get("show_ali").toString().equals(actMoney.get("type_flag").toString())) {
							configFlag = true; // 匹配上了，未匹配的说明没有合同
							ysMoney.put("budgetItemName", ysMoney.get("show_ali"));

							// 费用性实际、费用性预算、费用性比率
							ysMoney.put("fyxysje", ysMoney.get("fyx_money") == null ? "0" : ysMoney.get("fyx_money"));
							ysMoney.put("fyxsjje", actMoney.get("fyxsjje") == null ? "0" : actMoney.get("fyxsjje"));
							if (ysMoney.get("fyxysje").toString().equals("0")) {
								ysMoney.put("fyxRate", 0);
							} else {
								ysMoney.put("fyxRate", Double.parseDouble(ysMoney.get("fyxsjje").toString()) * 100 / Double.parseDouble(ysMoney.get("fyxysje").toString()));
							}

							// 资本性实际、资本性预算、资本性比率
							ysMoney.put("zbxysje", ysMoney.get("zbx_money") == null ? "0" : ysMoney.get("zbx_money"));
							ysMoney.put("zbxsjje", actMoney.get("zbxsjje") == null ? "0" : actMoney.get("zbxsjje"));
							if (ysMoney.get("zbxysje").toString().equals("0")) {
								ysMoney.put("zbxRate", 0);
							} else {
								ysMoney.put("zbxRate", Double.parseDouble(ysMoney.get("zbxsjje").toString()) * 100 / Double.parseDouble(ysMoney.get("zbxysje").toString()));
							}

							// 总实际、总预算、预算比率
							ysMoney.put("zysje", ysMoney.get("zysje") == null ? "0" : ysMoney.get("zysje"));
							ysMoney.put("zsjje", actMoney.get("zsjje") == null ? "0" : actMoney.get("zsjje"));
							if (ysMoney.get("zysje").toString().equals("0")) {
								ysMoney.put("zRate", 0);
							} else {
								ysMoney.put("zRate", Double.parseDouble(ysMoney.get("zsjje").toString()) * 100 / Double.parseDouble(ysMoney.get("zysje").toString()));
							}

							System.out.println(ysMoney.get("show_ali") + "====ysMoney.get()-----------" + ysMoney.get("zsjje"));
							break;
						}
					}
				}
				
				if (!configFlag) {
					// 未匹配的，说明没有合同，只有预算
					// 费用性实际、费用性预算、费用性比率
					ysMoney.put("fyxysje", ysMoney.get("fyx_money") == null ? "0" : ysMoney.get("fyx_money"));
					ysMoney.put("fyxsjje", "0");
					ysMoney.put("fyxRate", "0");

					// 资本性实际、资本性预算、资本性比率
					ysMoney.put("zbxysje", ysMoney.get("zbx_money") == null ? "0" : ysMoney.get("zbx_money"));
					ysMoney.put("zbxsjje", "0");
					ysMoney.put("zbxRate", "0");

					// 总实际、总预算、预算比率
					ysMoney.put("zysje", ysMoney.get("zysje") == null ? "0" : ysMoney.get("zysje"));
					ysMoney.put("zsjje", "0");
					ysMoney.put("zRate", "0");
				}
			}

			for (int k = 0; k < ysMoneyList.size(); k++) {

				Map<String, Object> ysMoney = (Map<String, Object>) ysMoneyList.get(k);
				System.out.println("ysMoney.get()-----------" + ysMoney.get("zsjje"));
				ysMoney.put("fyxysje", ysMoney.get("fyxysje") == null ? "0" : ysMoney.get("fyxysje"));
				ysMoney.put("fyxsjje", ysMoney.get("fyxsjje") == null ? "0" : ysMoney.get("fyxsjje"));
				ysMoney.put("fyxRate", ysMoney.get("fyxRate") == null ? "0" : ysMoney.get("fyxRate"));
				ysMoney.put("zbxysje", ysMoney.get("zbxysje") == null ? "0" : ysMoney.get("zbxysje"));
				ysMoney.put("zbxsjje", ysMoney.get("zbxsjje") == null ? "0" : ysMoney.get("zbxsjje"));
				ysMoney.put("zbxRate", ysMoney.get("zbxRate") == null ? "0" : ysMoney.get("zbxRate"));
				ysMoney.put("zysje", ysMoney.get("zysje") == null ? "0" : ysMoney.get("zysje"));
				ysMoney.put("zsjje", ysMoney.get("zsjje") == null ? "0" : ysMoney.get("zsjje"));
				ysMoney.put("zRate", ysMoney.get("zRate") == null ? "0" : ysMoney.get("zRate"));
			}

			retList = ysMoneyList;

			for (int k = 0; k < actMoneyList.size(); k++) {
				Map<String, Object> actMoney = (Map<String, Object>) actMoneyList.get(k);
				// 资产单位，特殊
				if (actMoney.get("type_flag") != null && (actMoney.get("type_flag").toString().contains("资产单位") || actMoney.get("type_flag").toString().contains("资产单位"))) {
					Map<String, Object> bm = new HashMap<String, Object>();
					bm.put("budgetItemName", "资产单位");
					bm.put("fyxysje", "0");
					bm.put("fyxsjje", actMoney.get("fyxsjje") == null ? "0" : actMoney.get("fyxsjje"));
					bm.put("fyxRate", 0);

					bm.put("zbxysje", "0");
					bm.put("zbxsjje", actMoney.get("zbxsjje") == null ? "0" : actMoney.get("zbxsjje"));
					bm.put("zbxRate", 0);

					bm.put("zysje", "0");
					bm.put("zsjje", Double.parseDouble(bm.get("fyxsjje").toString()) + Double.parseDouble(bm.get("zbxsjje").toString()));
					bm.put("zRate", 0);

					if (retList.size() > 3) {
						retList.add(3, bm);
					} else {
						retList.add(bm);
					}
					break;
				}
			}
			return JSONArray.parseArray(JSON.toJSONString(retList));
		}
		if (zycbm == null) {
			zycbm = "xxxxxxxx";
		}
		// 预算中，科技部外的部门特殊处理
		if (zycbm.contains("30130011")) {
			zycbm = zycbm + ",30130011";
		}
		if (zycbm.contains("30130016")) {
			zycbm = zycbm + ",30130016";
		}
		if (zycbm.contains("30130009")) {
			zycbm = zycbm + ",30130009";
		}
		map.put("zycbm", zycbm);

		System.out.println("zycbm========" + zycbm);
		Set<String> set = new HashSet<>(Arrays.asList(zycbm.split(",")));
		List<String> list_1 = new ArrayList<>(set);

		vo.getUnitIds().addAll(list_1);
		vo = budgetClient.selectBudgetInfoList(vo);
		List<Map<String, Object>> budMoneyList = vo.getBudgetByAllUnit();
		String username = map.get("username");
		System.out.println("1username========" + username);
		if (username != null && username.equals("wanglj")) {
			System.out.println("2username========" + username);
			map.put("zycbm", zycbm + ",30130054");
			zbxFlag = true;

			// 直接获取预算总表数据
			ysMoneyList = outProjectPlanService.getOutTemMoneyTotalInfo(map);
		}

		System.out.println("zylbbm========" + zylbbm);
		actMoneyList = outProjectPlanService.getPlanMoneyCompleteRateByCompanyType(map);

		for (int i = 0; i < budMoneyList.size(); i++) {
			Map<String, Object> bm = budMoneyList.get(i);
			System.out.println(zbxFlag + "=====budMoneyList========" + bm.get("budgetItemName") + "====" + bm.get("total"));
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

				if (bm.get("budgetItemName") != null && bm.get("budgetItemName").toString().contains("集团单位") && actMoney.get("type_flag") != null && (actMoney.get("type_flag").toString().contains("集团单位") || actMoney.get("type_flag").toString().contains("集团单位"))) {
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

		for (int i = 0; i < budMoneyList.size(); i++) {
			Map<String, Object> bm = budMoneyList.get(i);

			if (ysMoneyList != null) {
				for (int k = 0; k < ysMoneyList.size(); k++) {
					Map<String, Object> ysMoney = (Map<String, Object>) ysMoneyList.get(k);
					if (bm.get("budgetItemName") != null && ysMoney.get("budgetItemName") != null && bm.get("budgetItemName").toString().equals(ysMoney.get("budgetItemName").toString())) {
						// 资本性预算金额、总预算金额、资本性投入比率、总费用投入比
						bm = this.getMoneyProperty2(bm, ysMoney, zbxFlag);
						break;
					}
				}
			}

		}

		for (int k = 0; k < budMoneyList.size(); k++) {
			Map<String, Object> ysMoney = (Map<String, Object>) budMoneyList.get(k);
			ysMoney.put("fyxysje", ysMoney.get("fyxysje") == null ? "0" : ysMoney.get("fyxysje"));
			ysMoney.put("fyxsjje", ysMoney.get("fyxsjje") == null ? "0" : ysMoney.get("fyxsjje"));
			ysMoney.put("fyxRate", ysMoney.get("fyxRate") == null ? "0" : ysMoney.get("fyxRate"));
			ysMoney.put("zbxysje", ysMoney.get("zbxysje") == null ? "0" : ysMoney.get("zbxysje"));
			ysMoney.put("zbxsjje", ysMoney.get("zbxsjje") == null ? "0" : ysMoney.get("zbxsjje"));
			ysMoney.put("zbxRate", ysMoney.get("zbxRate") == null ? "0" : ysMoney.get("zbxRate"));

			ysMoney.put("zysje", Double.valueOf(ysMoney.get("fyxysje").toString()) + Double.valueOf(ysMoney.get("zbxysje").toString()));
			ysMoney.put("zsjje", Double.valueOf(ysMoney.get("fyxsjje").toString()) + Double.valueOf(ysMoney.get("zbxsjje").toString()));
			if (ysMoney.get("zysje").toString().equals("0")) {
				ysMoney.put("zRate", 0);
			} else {
				ysMoney.put("zRate", Double.parseDouble(ysMoney.get("zsjje").toString()) * 100 / Double.parseDouble(ysMoney.get("zysje").toString()));
			}

			System.out.println("zbxsjje========" + ysMoney.get("zbxsjje"));
		}

		retList = budMoneyList;

		for (int k = 0; k < actMoneyList.size(); k++) {
			Map<String, Object> actMoney = (Map<String, Object>) actMoneyList.get(k);
			// 资产单位，特殊
			if (actMoney.get("type_flag") != null && (actMoney.get("type_flag").toString().contains("资产单位") || actMoney.get("type_flag").toString().contains("资产单位"))) {
				Map<String, Object> bm = new HashMap<String, Object>();
				bm.put("budgetItemName", "资产单位");
				bm.put("fyxysje", "0");
				bm.put("fyxsjje", actMoney.get("fyxsjje") == null ? "0" : actMoney.get("fyxsjje"));
				bm.put("fyxRate", 0);

				bm.put("zbxysje", "0");
				bm.put("zbxsjje", actMoney.get("zbxsjje") == null ? "0" : actMoney.get("zbxsjje"));
				bm.put("zbxRate", 0);

				bm.put("zysje", "0");
				bm.put("zsjje", Double.parseDouble(bm.get("fyxsjje").toString()) + Double.parseDouble(bm.get("zbxsjje").toString()));
				bm.put("zRate", 0);

				if (retList.size() > 3) {
					retList.add(3, bm);
				} else {
					retList.add(bm);
				}
				break;
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
		System.out.println("1zbxsjje========" + actMoney.get("zbxsjje"));
		if (zbxFlag) {
			System.out.println("2zbxsjje========" + actMoney.get("zbxsjje"));
			bm.put("zbxsjje", actMoney.get("zbxsjje") == null ? "0" : actMoney.get("zbxsjje"));
			bm.put("zsjje", Double.parseDouble(actMoney.get("zbxsjje").toString()) + Double.parseDouble(actMoney.get("fyxsjje").toString()));
		} else {
			System.out.println("3zbxsjje========" + actMoney.get("zbxsjje"));
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
		String username = map.get("username");
		String zycbm = map.get("zycbm");

		if (zycbm != null && zycbm.contains("30130054")) {
			// 计划处，能看所有的费用性预算
			zycbm = "30130055,30130064,30130065,30130056,30130057,30130058,30130059,30130054,30130063,30130062,30130061,30130011,30130010,30130015,3013000902,30130009,30130016,ZX,JD";
			map.put("zycbm", zycbm);
			map.put("leaderFlag", "2");
		}

		List temList = outProjectPlanService.getPlanMoneyByDepartment(map);
		if (temList == null || temList.size() == 0) {
			temList = outProjectPlanService.getPlanMoneyByDepartmentSpecial(map);
		} else {
			Double ysje = 0d;
			Double ysjzje = 0d;
			Double ysxkje = 0d;
			Double sjzje = 0d;
			Double xkMoney = 0d;
			Double jzMoney = 0d;
			for (int i = 0; i < temList.size(); i++) {
				HashMap temMap = (HashMap) temList.get(i);
				ysje = ysje + (temMap.get("ysje") == null ? 0d : Double.parseDouble(temMap.get("ysje").toString()));
				ysjzje = ysjzje + (temMap.get("ysjzje") == null ? 0d : Double.parseDouble(temMap.get("ysjzje").toString()));
				ysxkje = ysxkje + (temMap.get("ysxkje") == null ? 0d : Double.parseDouble(temMap.get("ysxkje").toString()));
				sjzje = sjzje + (temMap.get("sjzje") == null ? 0d : Double.parseDouble(temMap.get("sjzje").toString()));
				xkMoney = xkMoney + (temMap.get("xkMoney") == null ? 0d : Double.parseDouble(temMap.get("xkMoney").toString()));
				jzMoney = jzMoney + (temMap.get("jzMoney") == null ? 0d : Double.parseDouble(temMap.get("jzMoney").toString()));
			}
			HashMap addMap = new HashMap();
			addMap.put("zycmc", "合计");
			addMap.put("ysje", String.format("%.2f", ysje));
			addMap.put("ysjzje", String.format("%.2f", ysjzje));
			addMap.put("ysxkje", String.format("%.2f", ysxkje));
			addMap.put("sjzje", String.format("%.2f", sjzje));
			addMap.put("xkMoney", String.format("%.2f", xkMoney));
			addMap.put("jzMoney", String.format("%.2f", jzMoney));
			temList.add(0, addMap);
		}
		System.out.println("getPlanMoneyByDepartment==========" + JSON.toJSONString(temList));
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
	
	
	@ApiOperation(value = "根据项目ID取项目信息", notes = "根据项目ID取项目信息")
	@RequestMapping(value = "/out-project-plan-provider/getOutProjectPlanByXmId/{xmid}", method = RequestMethod.GET)
	public OutProjectPlan getOutProjectPlanByXmId(@PathVariable(value = "xmid", required = true) String xmid) throws Exception {
		logger.info("===============================getOutProjectPlanByXmId  "+xmid+"===========");
		return outProjectPlanService.getOutProjectPlanByXmId(xmid);
	}
	
	

}
