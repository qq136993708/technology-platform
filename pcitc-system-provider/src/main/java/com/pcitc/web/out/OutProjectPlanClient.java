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

		BudgetItemSearchVo vo = new BudgetItemSearchVo();
		vo.setNd(map.get("nd"));
		String zycbm = map.get("zycbm");
		if ((map.get("leaderFlag") != null && map.get("leaderFlag").toString().equals("2")) || (zycbm != null && zycbm.contains("30130054"))) {
			// 大领导特殊，能看所有的费用性预算
			zycbm = "30130055,30130064,30130065,30130056,30130057,30130058,30130059,30130054,30130063,30130062,30130061,30130011,30130017,30130018,3013000902,30130009,30130016,ZX,JD";
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
		List temList = outProjectPlanService.getPlanCompleteRateByPlanTypeForHana(map);

		// 获取研究院预算，根据其管理的专业处不同有所不同
		BudgetItemSearchVo vo = new BudgetItemSearchVo();
		vo.setNd(map.get("nd"));
		String zycbm = map.get("zycbm");
		boolean zbxFlag = false;
		if ((map.get("leaderFlag") != null && map.get("leaderFlag").toString().equals("2")) || (zycbm != null && zycbm.contains("30130054"))) {
			// 大领导、计划处特殊，能看所有的费用性预算
			System.out.println("1大领导、计划处特殊，能看所有的费用性预算、专项机动");
			zbxFlag = true;
			zycbm = "30130055,30130064,30130065,30130056,30130057,30130058,30130059,30130054,30130063,30130062,30130061,30130011,30130017,30130018,3013000902,30130009,30130016,ZX,JD";
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
		List<Map<String, Object>> budMoneyList = vo.getBudgetByAllUnit();

		// 资本性预算金额
		List<Map<String, Object>> zbxMoneyList = null;
		if (zbxFlag) {
			zbxMoneyList = outProjectPlanService.getOutTemMoneyTotalInfo(map);
		}

		for (int i = 0; i < temList.size(); i++) {
			Map<String, Object> temMap = (Map<String, Object>) temList.get(i);
			for (int j = 0; j < budMoneyList.size(); j++) {
				Map<String, Object> bm = budMoneyList.get(j);
				if (temMap.get("define2").toString().equals(bm.get("budgetItemName").toString())) {
					temMap.put("zysje", bm.get("total") == null ? "0" : bm.get("total"));
					System.out.println("预算各研究院金额-----" + bm.get("budgetItemName") + "========" + bm.get("total"));
					break;
				}
			}
			// 领导及专业处，总预算计算资本性金额
			if (zbxMoneyList != null) {
				for (int j = 0; j < zbxMoneyList.size(); j++) {
					Map<String, Object> zbxMap = zbxMoneyList.get(j);
					if (temMap.get("define2").toString().equals(zbxMap.get("show_ali").toString())) {
						Double zysje = Double.parseDouble(temMap.get("zysje").toString());
						temMap.put("zysje", zysje + Double.parseDouble(zbxMap.get("zbx_money").toString()));
						System.out.println("预算各研究院资本性金额-----" + zbxMap.get("show_ali") + "========" + zbxMap.get("zbx_money"));
						break;
					}
				}
			}
		}

		// 未下单金额（总预算-总实际）、je比率
		for (int i = 0; i < temList.size(); i++) {
			Map<String, Object> temMap = (Map<String, Object>) temList.get(i);
			Double zysje = temMap.get("zysje") == null ? 0d : Double.parseDouble(temMap.get("zysje").toString());
			Double zsjje = temMap.get("zsjje") == null ? 0d : Double.parseDouble(temMap.get("zsjje").toString());
			temMap.put("wqhtzje", String.valueOf(zysje - zsjje));
			temMap.put("jeRate", String.valueOf(zsjje * 100 / zysje));
			if (!zbxFlag) {
				temMap.put("hanaMoney", "0");
				temMap.put("wbkzje", "0");
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
		List temList = outProjectPlanService.getPlanCompleteRateByPlanTypeForHanaMonth(map);

		// 获取研究院预算，根据其管理的专业处不同有所不同
		BudgetItemSearchVo vo = new BudgetItemSearchVo();
		vo.setNd(map.get("nd"));
		String zycbm = map.get("zycbm");
		boolean zbxFlag = false;
		if ((map.get("leaderFlag") != null && map.get("leaderFlag").toString().equals("2")) || (zycbm != null && zycbm.contains("30130054"))) {
			// 大领导、计划处特殊，能看所有的费用性预算
			zbxFlag = true;
			System.out.println("1大领导、计划处特殊，能看所有的费用性预算、专项机动");
			zycbm = "30130055,30130064,30130065,30130056,30130057,30130058,30130059,30130054,30130063,30130062,30130061,30130011,30130017,30130018,3013000902,30130009,30130016,ZX,JD";
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
		System.out.println("预算专业处编码-----" + zycbm);
		Set<String> set = new HashSet<>(Arrays.asList(zycbm.split(",")));
		List<String> list_1 = new ArrayList<>(set);
		vo.getUnitIds().addAll(list_1);
		vo = budgetClient.selectBudgetInfoList(vo);
		// 费用性预算金额
		List<Map<String, Object>> budMoneyList = vo.getBudgetByAllUnit();

		String budMoney = "0";
		for (int i = 0; i < budMoneyList.size(); i++) {
			Map temMap = (HashMap) budMoneyList.get(i);
			if (temMap.get("budgetItemName") != null && temMap.get("budgetItemName").toString().contains("研究院")) {
				// 费用性预算
				budMoney = temMap.get("total") == null ? "0" : temMap.get("total").toString();
				System.out.println("预算研究院金额-----" + temMap.get("budgetItemName") + "========" + budMoney);
				break;
			}
		}
		// 资本性预算金额(只有领导和计划处计算）、专项机动金额
		List<Map<String, Object>> zbxMoneyList = null;
		if (zbxFlag) {
			zbxMoneyList = outProjectPlanService.getOutTemMoneyTotalInfo(map);
			for (int j = 0; j < zbxMoneyList.size(); j++) {
				Map<String, Object> zbxMap = zbxMoneyList.get(j);
				if (zbxMap.get("show_ali").toString().contains("研究院")) {
					budMoney = String.valueOf(Double.parseDouble(budMoney) + Double.parseDouble(zbxMap.get("zbx_money").toString()));
					System.out.println("预算研究院资本性金额-----" + zbxMap.get("zbx_money") + "========" + budMoney);
					break;
				}
			}
		}

		System.out.println("2预算金额=========" + budMoney);
		for (int i = 0; i < temList.size(); i++) {
			Map temMap = (HashMap) temList.get(i);
			temMap.put("zysje", budMoney);
			if (!zbxFlag) {
				// 其他部门不让看到拨款金额
				temMap.put("hanaMoney", "0");
			}
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
		boolean zbxFlag = false;
		// 获取实际的科研投入(费用性和资本性)
		List actMoneyList = null;

		// 资本性预算，只能由拥有计划处（30130054）等特殊处室的人能看到.X轴显示无合同的（基金、马永生工作室）
		List ysMoneyList = null;
		
		List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();

		if ((map.get("leaderFlag") != null && map.get("leaderFlag").toString().equals("2")) || (zycbm != null && zycbm.contains("30130054"))) {
			// 大领导特殊，能看所有的费用性预算
			zbxFlag = true;
			zycbm = "30130055,30130064,30130065,30130056,30130057,30130058,30130059,30130054,30130063,30130062,30130061,30130011,30130017,30130018,3013000902,30130009,30130016,ZX,JD";
			map.put("zycbm", zycbm);
			
			actMoneyList = outProjectPlanService.getPlanMoneyCompleteRateByCompanyType(map);
			
			// 直接获取预算总表数据
			ysMoneyList = outProjectPlanService.getOutTemMoneyTotalInfo(map);
			
			// 数据处理
			for (int k = 0; k < ysMoneyList.size(); k++) {
				Map<String, Object> ysMoney = (Map<String, Object>) ysMoneyList.get(k);
				for (int j = 0; j < actMoneyList.size(); j++) {
					Map<String, Object> actMoney = (Map<String, Object>) actMoneyList.get(j);
					if (ysMoney.get("show_ali") != null && actMoney.get("type_flag") != null && ysMoney.get("show_ali").toString().equals(actMoney.get("type_flag").toString())) {
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
						
						System.out.println(ysMoney.get("show_ali")+"====ysMoney.get()-----------"+ysMoney.get("zsjje"));
						break;
					}
				}
			}
			
			for (int k = 0; k < ysMoneyList.size(); k++) {
				
				Map<String, Object> ysMoney = (Map<String, Object>) ysMoneyList.get(k);
				System.out.println("ysMoney.get()-----------"+ysMoney.get("zsjje"));
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

		
		for (int k = 0; k < budMoneyList.size(); k++) {
			Map<String, Object> ysMoney = (Map<String, Object>) budMoneyList.get(k);
			ysMoney.put("fyxysje", ysMoney.get("fyxysje") == null ? "0" : ysMoney.get("fyxysje"));
			ysMoney.put("fyxsjje", ysMoney.get("fyxsjje") == null ? "0" : ysMoney.get("fyxsjje"));
			ysMoney.put("fyxRate", ysMoney.get("fyxRate") == null ? "0" : ysMoney.get("fyxRate"));
			ysMoney.put("zbxysje", ysMoney.get("zbxysje") == null ? "0" : ysMoney.get("zbxysje"));
			ysMoney.put("zbxsjje", ysMoney.get("zbxsjje") == null ? "0" : ysMoney.get("zbxsjje"));
			ysMoney.put("zbxRate", ysMoney.get("zbxRate") == null ? "0" : ysMoney.get("zbxRate"));
			
			ysMoney.put("zysje", Double.valueOf(ysMoney.get("fyxysje").toString())+Double.valueOf(ysMoney.get("zbxysje").toString()));
			ysMoney.put("zsjje", Double.valueOf(ysMoney.get("fyxsjje").toString())+Double.valueOf(ysMoney.get("zbxsjje").toString()));
			if (ysMoney.get("zysje").toString().equals("0")) {
				ysMoney.put("zRate", 0);
			} else {
				ysMoney.put("zRate", Double.parseDouble(ysMoney.get("zsjje").toString()) * 100 / Double.parseDouble(ysMoney.get("zysje").toString()));
			}
			
			System.out.println("zsjje========" + ysMoney.get("zsjje"));
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
