package com.pcitc.web.out;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
import com.pcitc.base.stp.budget.vo.BudgetItemSearchVo;
import com.pcitc.base.stp.out.OutProjectErp;
import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.base.stp.out.OutProjectInfoExample;
import com.pcitc.base.stp.out.OutProjectInfoWithBLOBs;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.service.feign.hana.OutProjectRemoteClient;
import com.pcitc.service.feign.stp.BudgetClient;
import com.pcitc.service.out.OutProjectPlanService;
import com.pcitc.service.out.OutProjectService;

@Api(value = "OUTPROJECT-API", description = "项目数据，从项目管理系统中获取")
@RestController
public class OutProjectInfoClient {

	@Autowired
	private OutProjectService outProjectService;

	@Autowired
	private OutProjectPlanService outProjectPlanService;

	@Autowired
	private BudgetClient budgetClient;

	@Autowired
	private OutProjectRemoteClient outProjectRemoteClient;

	private final static Logger logger = LoggerFactory.getLogger(OutProjectInfoClient.class);

	@ApiOperation(value = "分页显示项目数据", notes = "分页显示项目数据")
	@RequestMapping(value = "/out-provider/project-list", method = RequestMethod.POST)
	public LayuiTableData getOutProjectListPage(@RequestBody LayuiTableParam param) throws Exception {
		logger.info("==================page getOutProjectListPage===========================" + JSONObject.toJSONString(param));
		return outProjectService.getOutProjectPage(param);
	}

	@ApiOperation(value = "分页显示项目数据数据,统计的第三级展示", notes = "分页显示")
	@RequestMapping(value = "/out-project-provider/common-project/list", method = RequestMethod.POST)
	public LayuiTableData selectCommonProjectByCond(@RequestBody LayuiTableParam param) throws Exception {
		logger.info("==================page selectCommonProjectByCond===========================" + JSONObject.toJSONString(param));
		return outProjectService.selectCommonProjectByCond(param);
	}

	@ApiOperation(value = "科研项目分析，包含项目基本信息，同时包含成果、奖励等信息", notes = "分页显示")
	@RequestMapping(value = "/out-project-provider/project/all-info/list", method = RequestMethod.POST)
	public LayuiTableData selectProjectInfoWithAllInfoByCond(@RequestBody LayuiTableParam param) throws Exception {
		logger.info("==================page selectProjectInfoWithAllInfoByCond===========================" + JSONObject.toJSONString(param));
		return outProjectService.selectProjectInfoWithAllInfoByCond(param);
	}

	@ApiOperation(value = "科研项目分析，包含项目基本信息，同时包含成果、奖励等信息", notes = "分页显示")
	@RequestMapping(value = "/out-project-provider/project/all-info/tree/list", method = RequestMethod.POST)
	public LayuiTableData selectProjectInfoWithAllInfoByCondTree(@RequestBody LayuiTableParam param) throws Exception {
		logger.info("==================page selectProjectInfoWithAllInfoByCondTree===========================" + JSONObject.toJSONString(param));
		return outProjectService.selectProjectInfoWithAllInfoByCondTree(param);
	}

	@ApiOperation(value = "科研项目分析，包含项目基本信息，同时包含成果、奖励等信息-专家", notes = "分页显示")
	@RequestMapping(value = "/out-project-provider/project/all-info/year/list_expert", method = RequestMethod.POST)
	public LayuiTableData selectProjectInfoWithAllInfoByCondYearExpert(@RequestBody LayuiTableParam param) throws Exception {
		logger.info("==================page selectProjectInfoWithAllInfoByCondYear===========================" + JSONObject.toJSONString(param));
		return outProjectService.selectProjectInfoWithAllInfoByCondYearExpert(param);
	}

	@ApiOperation(value = "科研项目分析，包含项目基本信息，同时包含成果、奖励等信息", notes = "分页显示")
	@RequestMapping(value = "/out-project-provider/project/all-info/year/list", method = RequestMethod.POST)
	public LayuiTableData selectProjectInfoWithAllInfoByCondYear(@RequestBody LayuiTableParam param) throws Exception {
		logger.info("==================page selectProjectInfoWithAllInfoByCondYear===========================" + JSONObject.toJSONString(param));
		return outProjectService.selectProjectInfoWithAllInfoByCondYear(param);
	}

	@ApiOperation(value = "科研项目分析，包含项目基本信息，同时包含成果、奖励等信息-专家", notes = "分页显示")
	@RequestMapping(value = "/out-project-provider/project/all-info/tree/list_expert", method = RequestMethod.POST)
	public LayuiTableData selectProjectInfoWithAllInfoByCondTreeExpert(@RequestBody LayuiTableParam param) throws Exception {
		logger.info("==================page selectProjectInfoWithAllInfoByCondTree===========================" + JSONObject.toJSONString(param));
		return outProjectService.selectProjectInfoWithAllInfoByCondTreeExpert(param);
	}

	@ApiOperation(value = "分页显示项目数据数据,国拨课题统计的第三级展示", notes = "分页显示")
	@RequestMapping(value = "/out-project-provider/country-project/list", method = RequestMethod.POST)
	public LayuiTableData selectCountryProjectByCond(@RequestBody LayuiTableParam param) throws Exception {
		logger.info("==================page selectCountryProjectByCond===========================" + param);
		return outProjectService.selectCountryProjectByCond(param);
	}

	@ApiOperation(value = "保存erp课题配置", notes = "删除当前页已有的，保存新选择的")
	@RequestMapping(value = "/out-provider/config-erp-project", method = RequestMethod.POST)
	public String saveErpProjectConfig(@RequestBody JSONObject json) throws Exception {
		System.out.println("==-=-=-=" + json);
		String retS = "0";
		String G0PROJCODES = json.getString("G0PROJCODES");
		String G0PROJTXTS = json.getString("G0PROJTXTS");
		String TEMG0PROJCODES = json.getString("TEMG0PROJCODES");

		String data_id = json.getString("data_id");

		String[] tems = TEMG0PROJCODES.split(",");
		if (tems != null && tems.length > 0) {
			Map map = new HashMap();
			map.put("opiId", data_id);
			List<OutProjectErp> opeList = new ArrayList<OutProjectErp>();

			for (int i = 0; i < tems.length; i++) {
				OutProjectErp ope = new OutProjectErp();
				ope.setErpProjectCode(tems[i]);
				opeList.add(ope);
			}
			map.put("list", opeList);
			// 把原有的都删除
			outProjectService.deleteProjectErpBatch(map);
		}

		// 添加新选择的
		String[] newcodes = G0PROJCODES.split(",");
		String[] newnames = G0PROJTXTS.split(",");
		if (newcodes != null && newcodes.length > 0) {
			List<OutProjectErp> newList = new ArrayList<OutProjectErp>();
			for (int i = 0; i < newcodes.length; i++) {
				OutProjectErp ope = new OutProjectErp();
				ope.setErpProjectCode(newcodes[i]);
				ope.setErpProjectName(newnames[i]);
				ope.setCreateDate(new Date());
				ope.setStatus("0");
				ope.setOpiId(data_id);
				ope.setDataId(UUID.randomUUID().toString().replaceAll("-", ""));
				newList.add(ope);
			}
			outProjectService.insertProjectErpBatch(newList);
		}

		return retS;
	}

	@ApiOperation(value = "修改项目数据", notes = "项目的级别、项目属性等属性修改")
	@RequestMapping(value = "/out-provider/update-project", method = RequestMethod.POST)
	public String updateOutProject(@RequestBody JSONObject json) throws Exception {
		System.out.println("==-=-=-=" + json);
		String projectLevel = json.getString("projectLevel");
		String projectProperty = json.getString("projectProperty");
		String projectAbc = json.getString("projectAbc");
		String projectSource = json.getString("projectSource");
		String dataId = json.getString("dataId");
		OutProjectInfoWithBLOBs opi = new OutProjectInfoWithBLOBs();

		opi.setDataId(dataId);
		opi.setProjectLevel(projectLevel);
		opi.setProjectProperty(projectProperty);
		opi.setProjectAbc(projectAbc);
		opi.setProjectSource(projectSource);
		outProjectService.updateOutProjectInfo(opi);
		return "1";
	}

	@ApiOperation(value = "首页计算新开课题总数", notes = "首页查询使用")
	@RequestMapping(value = "/out-provider/project-count", method = RequestMethod.POST)
	public JSONObject getProjectCount(@RequestBody HashMap<String, String> map) {
		String jsonString = JSON.toJSONString(map);
		System.out.println("/out-provider/project-count ==========" + jsonString);
		JSONObject retJson = new JSONObject();
		HashMap<String, String> temMap = outProjectService.getOutProjectInfoCount(map);
		if (temMap != null) {
			retJson.put("projectCount", temMap.get("projectCount"));
		} else {
			retJson.put("projectCount", 0);
		}
		return retJson;
	}

	@ApiOperation(value = "领导页，总的实际新签、预算金额（费用性），按专业处", notes = "首页查询使用")
	@RequestMapping(value = "/out-provider/project-money", method = RequestMethod.POST)
	public JSONObject getProjectMoney(@RequestBody HashMap<String, String> map) {
		JSONObject retJson = new JSONObject();

		BudgetItemSearchVo vo = new BudgetItemSearchVo();
		vo.setNd(map.get("nd"));

		boolean leaderFlag = false;
		this.authControl(map);
		if (map.get("leaderFlag") != null && map.get("leaderFlag").toString().equals("2")) {
			leaderFlag = true;
		}
		
		String zycbm = map.get("zycbm");
		String username = map.get("username");

		Set<String> set = new HashSet<>(Arrays.asList(zycbm.split(",")));
		List<String> list_1 = new ArrayList<>(set);
		vo.getUnitIds().addAll(list_1);
		vo = budgetClient.selectBudgetInfoList(vo);
		// 费用性预算金额
		Double zysje = vo.getBudgetTotal();

		HashMap<String, String> temMap = outProjectService.getOutProjectInfoMoney(map);
		if (temMap != null) {
			retJson.put("projectMoney", temMap.get("projectMoney"));
		} else {
			retJson.put("projectMoney", 0);
		}
		HashMap<String, String> temBudZbxMap = outProjectService.getBudgetZBXMoney(map);
		if (leaderFlag) {
			// 预算金额（费用性）
			if (temBudZbxMap != null) {
				retJson.put("zysje", temBudZbxMap.get("zysje"));
			} else {
				retJson.put("zysje", 0);
			}
		} else {
			// 科研装备特殊，有这个专业类别的可看资本性
			if (username != null && username.equals("wanglj")) {
				Object temMoney = temBudZbxMap.get("budgetZbxMoney");
				retJson.put("zysje", zysje.doubleValue() + Double.valueOf(temMoney.toString()));
			} else {
				retJson.put("zysje", zysje);
			}

		}

		return retJson;
	}

	@ApiOperation(value = "研究院首页计算装备和科研合同总数", notes = "首页查询使用")
	@RequestMapping(value = "/out-provider/kyzb/project-count", method = RequestMethod.POST)
	public JSONObject getOutProjectInfoCountWithKYZB(@RequestBody HashMap<String, String> map) {
		JSONObject retJson = new JSONObject();
		HashMap<String, String> temMap = outProjectService.getOutProjectInfoCountWithKYZB(map);
		if (temMap != null) {
			retJson.put("projectCount", temMap.get("projectCount") == null ? 0 : temMap.get("projectCount"));
			retJson.put("kyzbCount", temMap.get("kyzbCount") == null ? 0 : temMap.get("kyzbCount"));
			retJson.put("zsl", temMap.get("zsl") == null ? 0 : temMap.get("zsl"));
			retJson.put("xkCount", temMap.get("xkCount") == null ? 0 : temMap.get("xkCount"));
			retJson.put("jzCount", temMap.get("jzCount") == null ? 0 : temMap.get("jzCount"));

			retJson.put("xkkyzbCount", temMap.get("xkkyzbCount") == null ? 0 : temMap.get("xkkyzbCount"));
			retJson.put("xkfkyzbCount", temMap.get("xkfkyzbCount") == null ? 0 : temMap.get("xkfkyzbCount"));
			retJson.put("jzkyzbCount", temMap.get("jzkyzbCount") == null ? 0 : temMap.get("jzkyzbCount"));
			retJson.put("jzfkyzbCount", temMap.get("jzfkyzbCount") == null ? 0 : temMap.get("jzfkyzbCount"));
		} else {
			retJson.put("projectCount", 0);
			retJson.put("kyzbCount", 0);
			retJson.put("zsl", 0);
			retJson.put("xkCount", 0);
			retJson.put("jzCount", 0);

			retJson.put("xkkyzbCount", 0);
			retJson.put("xkfkyzbCount", 0);
			retJson.put("jzkyzbCount", 0);
			retJson.put("jzfkyzbCount", 0);
		}
		return retJson;
	}

	@ApiOperation(value = "十条龙及重大专项项目的总数", notes = "首页查询使用")
	@RequestMapping(value = "/out-provider/dragon/project-count", method = RequestMethod.POST)
	public JSONObject getProjectCountForDragon(@RequestBody HashMap<String, String> map) {
		JSONObject retJson = new JSONObject();
		this.authControl(map);
		
		HashMap<String, String> temMap = outProjectService.getOutProjectDragonInfoCount(map);

		if (temMap != null) {
			retJson.put("zsl", temMap.get("zsl") == null ? 0 : temMap.get("zsl"));
			retJson.put("zdzxsl", temMap.get("zdzxsl") == null ? 0 : temMap.get("zdzxsl"));
			retJson.put("stlsl", temMap.get("stlsl") == null ? 0 : temMap.get("stlsl"));
		} else {
			retJson.put("zsl", 0);
			retJson.put("zdzxsl", 0);
			retJson.put("stlsl", 0);
		}
		return retJson;
	}

	/**
	 * @author Nishikino 查询id
	 */
	@ApiOperation(value = "根据id查询详情", notes = "根据id查询详情")
	@RequestMapping(value = "/out-provider/get-project-list/{dataId}", method = RequestMethod.POST)
	public OutProjectInfo getOutProjectShow(@PathVariable(value = "dataId", required = true) String dataId) throws Exception {
		return outProjectService.getOutProjectShowById(dataId);
	}

	@ApiOperation(value = "根据id查询详情", notes = "根据id查询详情")
	@RequestMapping(value = "/out-provider/get-project-list-fc/{dataId}", method = RequestMethod.POST)
	public OutProjectInfo getOutProjectShowFc(@PathVariable(value = "dataId", required = true) String dataId) throws Exception {
		return outProjectService.getOutProjectShowByIdFc(dataId);
	}

	@RequestMapping(value = "/out-provider/get-project-list-count/{dataId}", method = RequestMethod.POST)
	public JSONObject getOutProjectShowCount(@PathVariable(value = "dataId", required = true) String dataId) throws Exception {
		return outProjectService.getOutProjectShowCount(dataId);
	}

	@ApiOperation(value = "首页查询各单位的新开、续建、完结情况--装备", notes = "参数暂时是空")
	@RequestMapping(value = "/out-project-provider/type/zb/unit/list")
	public JSONArray getZBProjectTypeInfoByUnit(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getZBProjectTypeInfoByUnit===========================" + map);
		List temList = outProjectService.getZBProjectTypeInfoByUnit(map);
		List keyList = new ArrayList<String>();
		keyList.add("xksl");
		keyList.add("xjsl");
		logger.info("==================page getZBProjectTypeInfoByUnit===========================" + JSON.toJSONString(temList));
		// 各个组织机构名称，如果有基础数据库的话，也可以直接取，此处就不用写死
		temList = iniListValue(temList, "type_flag", "直属研究院", keyList);
		temList = iniListValue(temList, "type_flag", "分子公司", keyList);
		temList = iniListValue(temList, "type_flag", "集团单位", keyList);
		temList = iniListValue(temList, "type_flag", "资产单位", keyList);
		temList = iniListValue(temList, "type_flag", "外部单位", keyList);
		temList = iniListValue(temList, "type_flag", "集团公司", keyList);
		temList = iniListValue(temList, "type_flag", "资产公司", keyList);
		temList = iniListValue(temList, "type_flag", "盈科", keyList);
		System.out.println("====" + JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "首页查询新开的国家项目、重点项目、重大项目、其他项目的统计", notes = "参数暂时是空")
	@RequestMapping(value = "/out-project-provider/type/new", method = RequestMethod.POST)
	public JSONObject getProjectTotalInfoByNew(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getProjectTotalInfoByNew===========================" + map);
		JSONObject retJson = new JSONObject();
		HashMap<String, String> temMap = outProjectService.getProjectTotalInfoByNew(map);
		if (temMap != null) {
			retJson.put("gjxmsl", temMap.get("gjxmsl") == null ? 0 : temMap.get("gjxmsl"));
			retJson.put("zdzzsl", temMap.get("zdzzsl") == null ? 0 : temMap.get("zdzzsl"));
			retJson.put("zdxmsl", temMap.get("zdxmsl") == null ? 0 : temMap.get("zdxmsl"));
			retJson.put("qtsl", temMap.get("qtsl") == null ? 0 : temMap.get("qtsl"));
			retJson.put("ldzsl", temMap.get("ldzsl") == null ? 0 : temMap.get("ldzsl"));
			retJson.put("zsl", temMap.get("zsl") == null ? 0 : temMap.get("zsl"));
		} else {
			retJson.put("gjxmsl", 0);
			retJson.put("zdzzsl", 0);
			retJson.put("zdxmsl", 0);
			retJson.put("qtsl", 0);
			retJson.put("ldzsl", 0);
			retJson.put("zsl", 0);
		}

		return retJson;
	}

	@ApiOperation(value = "各类型项目数和去年比", notes = "首页查询使用")
	@RequestMapping(value = "/out-project-provider/type/last-year/rate", method = RequestMethod.POST)
	public JSONObject getProjectTotalCountYearAndLastYear(@RequestBody HashMap<String, String> map) {
		JSONObject retJson = new JSONObject();
		HashMap<String, String> temMap = outProjectService.getProjectTotalCountYearAndLastYear(map);

		if (temMap != null) {
			retJson.put("xkgjsl", temMap.get("xkgjsl") == null ? 0 : temMap.get("xkgjsl"));
			retJson.put("qngjsl", temMap.get("qngjsl") == null ? 0 : temMap.get("qngjsl"));
			retJson.put("xkzzsl", temMap.get("xkzzsl") == null ? 0 : temMap.get("xkzzsl"));
			retJson.put("qnzzsl", temMap.get("qnzzsl") == null ? 0 : temMap.get("qnzzsl"));
			retJson.put("xkzdsl", temMap.get("xkzdsl") == null ? 0 : temMap.get("xkzdsl"));
			retJson.put("qnzdsl", temMap.get("qnzdsl") == null ? 0 : temMap.get("qnzdsl"));

			retJson.put("lysybsl", temMap.get("lysybsl") == null ? 0 : temMap.get("lysybsl"));
			retJson.put("qnlysybsl", temMap.get("qnlysybsl") == null ? 0 : temMap.get("qnlysybsl"));
			retJson.put("hgsybsl", temMap.get("hgsybsl") == null ? 0 : temMap.get("hgsybsl"));
			retJson.put("qnhgsybsl", temMap.get("qnhgsybsl") == null ? 0 : temMap.get("qnhgsybsl"));
		} else {
			retJson.put("xkgjsl", 0);
			retJson.put("qngjsl", 0);
			retJson.put("xkzzsl", 0);
			retJson.put("qnzzsl", 0);
			retJson.put("xkzdsl", 0);
			retJson.put("qnzdsl", 0);

			retJson.put("lysybsl", 0);
			retJson.put("qnlysybsl", 0);
			retJson.put("hgsybsl", 0);
			retJson.put("qnhgsybsl", 0);

		}
		return retJson;
	}

	@ApiOperation(value = "科研二级页面，按照项目类型查询新建、数量", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/project-count/project-type")
	public JSONArray getProjectCountByProjectType(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getProjectCountByProjectType===========================" + map);
		List temList = outProjectService.getProjectCountByProjectType(map);
		List keyList = new ArrayList<String>();
		keyList.add("xksl");
		keyList.add("xjsl");
		keyList.add("zsl");
		logger.info("==================page getProjectCountByProjectType===========================" + JSON.toJSONString(temList));
		// 各个处室如果有基础数据库的话，也可以直接取，此处就不用写死
		temList = iniListValue(temList, "zycmc", "油田处", keyList);
		temList = iniListValue(temList, "zycmc", "炼油处", keyList);
		temList = iniListValue(temList, "zycmc", "化工处", keyList);
		temList = iniListValue(temList, "zycmc", "材料处", keyList);
		temList = iniListValue(temList, "zycmc", "装备与储运处", keyList);
		temList = iniListValue(temList, "zycmc", "计划处", keyList);
		temList = iniListValue(temList, "zycmc", "技术监督处", keyList);
		temList = iniListValue(temList, "zycmc", "三剂处", keyList);
		temList = iniListValue(temList, "zycmc", "知识产权处", keyList);
		temList = iniListValue(temList, "zycmc", "物装部", keyList);
		temList = iniListValue(temList, "zycmc", "炼油部", keyList);
		temList = iniListValue(temList, "zycmc", "化工部", keyList);
		logger.info("==================page getProjectCountByProjectType===========================" + JSON.toJSONString(temList));

		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	/**
	 * @param iniList
	 * @param keyWord
	 * @param keyList
	 *            初始值
	 * @return
	 */
	public List iniListValue(List iniList, String key, String value, List keyList) {
		if (!JSON.toJSONString(iniList).contains(value)) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			for (int i = 0; i < keyList.size(); i++) {
				temMap.put(keyList.get(i).toString(), 0);
			}
			temMap.put(key, value);
			iniList.add(temMap);
		}
		return iniList;
	}

	/**
	 * @param iniList
	 * @param key
	 * @param value
	 * @param keyList
	 * @return
	 */
	public List iniListValueTree(List iniList, String key, String value, List keyList, String flagValue) {
		if (!JSON.toJSONString(iniList).contains(value)) {
			for (int i = 0; i < keyList.size(); i++) {
				HashMap<String, Object> temMap = new HashMap<String, Object>();
				temMap.put(flagValue, keyList.get(i).toString());
				temMap.put("zsl", 0);
				temMap.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
				temMap.put(key, value);
				iniList.add(temMap);
			}
		}

		return iniList;
	}

	@ApiOperation(value = "科研装备，科研二级页面，按照项目类型查询新建、结转课题数量", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/project-count/zb/project-type")
	public JSONArray getZBProjectCountByProjectType(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getZBProjectCountByProjectType===========================" + map);
		List temList = outProjectService.getZBProjectCountByProjectType(map);

		System.out.println("====" + JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "预算分析，新开课题、结转课题对应的费用性金额、资本性金额统计", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/project-money/project-type")
	public JSONArray getProjectMoneyByProjectType(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getProjectMoneyByProjectType===========================" + map);
		List temList = outProjectService.getProjectMoneyByProjectType(map);

		if (!JSON.toJSONString(temList).contains("费用性")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xkje", 0d);
			temMap.put("xjje", 0d);
			temMap.put("zje", 0d);
			temMap.put("project_scope", "费用性");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("资本性")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xkje", 0d);
			temMap.put("xjje", 0d);
			temMap.put("zje", 0d);
			temMap.put("project_scope", "资本性");
			temList.add(temMap);
		}
		System.out.println("====" + JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "研究院的各项目的费用性金额、资本性金额统计", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/project-money/institute")
	public JSONArray getProjectMoneyByYJY(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getProjectMoneyByYJY===========================" + map);

		List temList = outProjectService.getProjectMoneyByYJY(map);
		System.out.println("====" + JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "研究院的各项目的费用性金额、资本性金额统计", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/country-project/institute")
	public JSONArray getCountryProjectByYJY(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getCountryProjectByYJY===========================" + map);

		List temList = outProjectService.getCountryProjectByYJY(map);
		System.out.println("====" + JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "树形结构，费用性金额、资本性金额和新开、续建情况", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/project-money/scope/type")
	public JSONArray getProjectMoneyForTree(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getProjectMoneyForTree===========================" + map);
		List temList = outProjectService.getProjectMoneyForTree(map);
		if (!JSON.toJSONString(temList).contains("新开课题")) {
			HashMap<String, Object> temMap1 = new HashMap<String, Object>();
			temMap1.put("zje", 0d);
			temMap1.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap1.put("define1", "费用性");
			temMap1.put("project_scope", "新开课题");
			temList.add(temMap1);

			HashMap<String, Object> temMap2 = new HashMap<String, Object>();
			temMap2.put("zje", 0d);
			temMap2.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap2.put("define1", "资本性");
			temMap2.put("project_scope", "新开课题");
			temList.add(temMap2);
		}
		if (!JSON.toJSONString(temList).contains("结转课题")) {
			HashMap<String, Object> temMap1 = new HashMap<String, Object>();
			temMap1.put("zje", 0d);
			temMap1.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap1.put("define1", "费用性");
			temMap1.put("project_scope", "结转课题");
			temList.add(temMap1);

			HashMap<String, Object> temMap2 = new HashMap<String, Object>();
			temMap2.put("zje", 0d);
			temMap2.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap2.put("define1", "资本性");
			temMap2.put("project_scope", "结转课题");
			temList.add(temMap2);
		}

		System.out.println("====" + JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "树形结构，费用性金额、资本性金额和各研究院情况", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/project-money/scope/institute")
	public JSONArray getProjectMoneyByIniAndTypeForTree(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getProjectMoneyByIniAndTypeForTree===========================" + map);
		List temList = outProjectService.getProjectMoneyByIniAndTypeForTree(map);

		System.out.println("====" + JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "直属院、盈科等单位的费用性金额、资本性金额统计", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/project-money/unit-type")
	public JSONArray getProjectMoneyByUnit(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getProjectMoneyByUnit===========================" + map);
		List temList = outProjectService.getProjectMoneyByUnit(map);

		List keyList = new ArrayList<String>();
		keyList.add("fyxje");
		keyList.add("zbxje");
		keyList.add("zje");
		keyList.add("prefyxje");
		keyList.add("prezbxje");
		keyList.add("prezje");
		keyList.add("ztzwcl");
		keyList.add("fyxtzwcl");
		keyList.add("zbxtzwcl");
		keyList.add("wxd");
		logger.info("==================page getProjectTypeCountByUnit===========================" + JSON.toJSONString(temList));
		// 各个组件机构概念，如果有基础数据库的话，也可以直接取，此处就不用写死
		temList = iniListValue(temList, "type_flag", "直属研究院", keyList);
		temList = iniListValue(temList, "type_flag", "分子公司", keyList);
		temList = iniListValue(temList, "type_flag", "集团单位", keyList);
		temList = iniListValue(temList, "type_flag", "资产单位", keyList);
		temList = iniListValue(temList, "type_flag", "外部单位", keyList);
		temList = iniListValue(temList, "type_flag", "休斯顿", keyList);
		temList = iniListValue(temList, "type_flag", "集团公司", keyList);
		temList = iniListValue(temList, "type_flag", "资产公司", keyList);
		temList = iniListValue(temList, "type_flag", "盈科", keyList);

		System.out.println("====" + JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "科研二级页面，8大院的各个新开、续建情况", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/project-info/unit")
	public JSONArray getProjectTypeCountByUnit(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getProjectTypeCountByUnit===========================" + map);
		List temList = outProjectService.getProjectTypeCountByUnit(map);

		List keyList = new ArrayList<String>();
		keyList.add("xksl");
		keyList.add("xjsl");
		keyList.add("zsl");
		logger.info("==================page getProjectTypeCountByUnit===========================" + JSON.toJSONString(temList));
		// 各个研究院如果有基础数据库的话，也可以直接取，此处就不用写死
		temList = iniListValue(temList, "define2", "勘探院", keyList);
		temList = iniListValue(temList, "define2", "物探院", keyList);
		temList = iniListValue(temList, "define2", "工程院", keyList);
		temList = iniListValue(temList, "define2", "石科院", keyList);
		temList = iniListValue(temList, "define2", "大连院", keyList);
		temList = iniListValue(temList, "define2", "北化院", keyList);
		temList = iniListValue(temList, "define2", "上海院", keyList);
		temList = iniListValue(temList, "define2", "安工院", keyList);

		System.out.println("====" + JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "科研二级页面，8大院的各个新开、续建情况--装备", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/project-info/zb/unit")
	public JSONArray getZBProjectTypeCountByUnit(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getZBProjectTypeCountByUnit===========================" + map);
		List temList = outProjectService.getZBProjectTypeCountByUnit(map);

		List keyList = new ArrayList<String>();
		keyList.add("xksl");
		keyList.add("xjsl");
		keyList.add("zsl");
		logger.info("==================page getProjectTypeCountByUnit===========================" + JSON.toJSONString(temList));
		// 各个研究院如果有基础数据库的话，也可以直接取，此处就不用写死
		temList = iniListValue(temList, "define2", "勘探院", keyList);
		temList = iniListValue(temList, "define2", "物探院", keyList);
		temList = iniListValue(temList, "define2", "工程院", keyList);
		temList = iniListValue(temList, "define2", "石科院", keyList);
		temList = iniListValue(temList, "define2", "大连院", keyList);
		temList = iniListValue(temList, "define2", "北化院", keyList);
		temList = iniListValue(temList, "define2", "上海院", keyList);
		temList = iniListValue(temList, "define2", "安工院", keyList);
		System.out.println("====" + JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "直属研究院、分子公司等9个单位，各个新开、续建情况--树结构", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/project-count/unit/tree")
	public JSONArray getProjectTypeCountForTree(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getProjectTypeCountForTree===========================" + map);
		List temList = outProjectService.getProjectTypeCountForTree(map);

		// 各个组织机构范畴单位，如果有基础数据库的话，也可以直接取，此处就不用写死
		List keyList = new ArrayList<String>();
		keyList.add("直属研究院");
		keyList.add("分子公司");
		keyList.add("集团单位");
		keyList.add("资产单位");
		keyList.add("外部单位");
		keyList.add("休斯顿");
		keyList.add("中东");
		keyList.add("集团公司");
		keyList.add("资产公司");
		keyList.add("盈科");
		logger.info("==================page getProjectTypeCountForTree===========================" + JSON.toJSONString(temList));
		temList = iniListValueTree(temList, "project_scope", "新开课题", keyList, "type_flag");
		temList = iniListValueTree(temList, "project_scope", "结转课题", keyList, "type_flag");

		System.out.println("====" + JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "项目类型（国家项目、重点项目、重大项目、其他项目）的各个新开、续建情况--树结构", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/project-count/type/tree")
	public JSONArray getProjectCountByTypeForTree(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getProjectCountByTypeForTree===========================" + map);
		List temList = outProjectService.getProjectCountByTypeForTree(map);
		// 各个处室如果有基础数据库的话，也可以直接取，此处就不用写死
		List keyList = new ArrayList<String>();
		keyList.add("油田处");
		keyList.add("炼油处");
		keyList.add("化工处");
		keyList.add("材料处");
		keyList.add("装备与储运处");
		keyList.add("计划处");
		keyList.add("技术监督处");
		keyList.add("三剂处");
		keyList.add("知识产权处");
		keyList.add("物装部");
		keyList.add("炼油部");
		keyList.add("化工部");
		logger.info("==================page getProjectCountByTypeForTree===========================" + JSON.toJSONString(temList));
		temList = iniListValueTree(temList, "project_scope", "新开课题", keyList, "zycmc");
		temList = iniListValueTree(temList, "project_scope", "结转课题", keyList, "zycmc");

		System.out.println("====" + JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "8大院的各个新开、续建情况--装备树结构", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/project-count/zb/unit/tree")
	public JSONArray getZBProjectTypeCountForTree(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getZBProjectTypeCountForTree===========================" + map);
		List temList = outProjectService.getZBProjectTypeCountForTree(map);
		// 各个组织机构范畴单位，如果有基础数据库的话，也可以直接取，此处就不用写死
		List keyList = new ArrayList<String>();
		keyList.add("直属研究院");
		keyList.add("分子公司");
		keyList.add("集团单位");
		keyList.add("资产单位");
		keyList.add("外部单位");
		keyList.add("休斯顿");
		keyList.add("集团公司");
		keyList.add("资产公司");
		keyList.add("盈科");
		logger.info("==================page getZBProjectTypeCountForTree===========================" + JSON.toJSONString(temList));
		temList = iniListValueTree(temList, "project_scope", "新开课题", keyList, "type_flag");
		temList = iniListValueTree(temList, "project_scope", "结转课题", keyList, "type_flag");
		System.out.println("====" + JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "项目类型（国家项目、重点项目、重大项目、其他项目）的各个新开、续建情况--装备树结构", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/project-count/zb/type/tree")
	public JSONArray getZBProjectCountByTypeForTree(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getZBProjectCountByTypeForTree===========================" + map);
		List temList = outProjectService.getZBProjectCountByTypeForTree(map);
		// 各个组织机构范畴单位，如果有基础数据库的话，也可以直接取，此处就不用写死
		List keyList = new ArrayList<String>();
		keyList.add("勘探院");
		keyList.add("物探院");
		keyList.add("工程院");
		keyList.add("石科院");
		keyList.add("大连院");
		keyList.add("北化院");
		keyList.add("上海院");
		keyList.add("安工院");
		logger.info("==================page getZBProjectTypeCountForTree===========================" + JSON.toJSONString(temList));
		temList = iniListValueTree(temList, "project_scope", "新开课题", keyList, "define2");
		temList = iniListValueTree(temList, "project_scope", "结转课题", keyList, "define2");

		System.out.println("====" + JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "领导页的各类型项目的数量", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/ld/project-type-count")
	public JSONArray getProjectTypeCountForLD(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getProjectTypeCountForLD===========================" + map);
		List temList = outProjectService.getProjectTypeCountForLD(map);

		if (!JSON.toJSONString(temList).contains("十条龙")) {
			HashMap<String, Object> temMap1 = new HashMap<String, Object>();
			temMap1.put("xmsl", 0);
			temMap1.put("project_property", "十条龙项目");
			temList.add(temMap1);
		}

		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "直属研究院、分子公司等9个单位，各个新开、续建情况--树结构", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/ld/project-count/unit/tree")
	public JSONArray getProjectTypeCountForTreeLD(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getProjectTypeCountForTreeLD===========================" + map);
		List temList = outProjectService.getProjectTypeCountForTreeLD(map);

		// 各个组织机构范畴单位，如果有基础数据库的话，也可以直接取，此处就不用写死
		List keyList = new ArrayList<String>();
		keyList.add("直属研究院");
		keyList.add("分子公司");
		keyList.add("集团单位");
		keyList.add("资产单位");
		keyList.add("外部单位");
		keyList.add("休斯顿");
		keyList.add("中东");
		keyList.add("集团公司");
		keyList.add("资产公司");
		keyList.add("盈科");
		temList = iniListValueTree(temList, "project_scope", "新开课题", keyList, "type_flag");
		temList = iniListValueTree(temList, "project_scope", "结转课题", keyList, "type_flag");

		System.out.println("====" + JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "领导二级页面，直属研究院、分子公司等9个单位，各单位的新开、续建、完结情况", notes = "参数暂时是空")
	@RequestMapping(value = "/out-project-provider/ld/type/unit/list")
	public JSONArray getProjectTypeInfoByUnitLD(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getProjectTypeInfoByUnitLD===========================" + map);
		List temList = outProjectService.getProjectTypeInfoByUnitLD(map);

		List keyList = new ArrayList<String>();
		keyList.add("xksl");
		keyList.add("xjsl");
		logger.info("==================page getProjectTypeInfoByUnit===========================" + JSON.toJSONString(temList));
		// 各个组织机构名称，如果有基础数据库的话，也可以直接取，此处就不用写死
		temList = iniListValue(temList, "type_flag", "直属研究院", keyList);
		temList = iniListValue(temList, "type_flag", "分子公司", keyList);
		temList = iniListValue(temList, "type_flag", "集团单位", keyList);
		temList = iniListValue(temList, "type_flag", "资产单位", keyList);
		temList = iniListValue(temList, "type_flag", "外部单位", keyList);
		temList = iniListValue(temList, "type_flag", "集团公司", keyList);
		temList = iniListValue(temList, "type_flag", "资产公司", keyList);
		temList = iniListValue(temList, "type_flag", "盈科", keyList);

		System.out.println("====" + JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "领导二级页面，各个处室的新开、续建、完结情况", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/ld/project-count/project-type")
	public JSONArray getProjectCountByProjectTypeLD(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getProjectCountByProjectTypeLD===========================" + map);
		List temList = outProjectService.getProjectCountByProjectTypeLD(map);

		List keyList = new ArrayList<String>();
		keyList.add("xksl");
		keyList.add("xjsl");
		// 各个处室如果有基础数据库的话，也可以直接取，此处就不用写死
		temList = iniListValue(temList, "zycmc", "油田处", keyList);
		temList = iniListValue(temList, "zycmc", "炼油处", keyList);
		temList = iniListValue(temList, "zycmc", "化工处", keyList);
		temList = iniListValue(temList, "zycmc", "材料处", keyList);
		temList = iniListValue(temList, "zycmc", "装备与储运处", keyList);
		temList = iniListValue(temList, "zycmc", "计划处", keyList);
		temList = iniListValue(temList, "zycmc", "技术监督处", keyList);
		temList = iniListValue(temList, "zycmc", "三剂处", keyList);
		temList = iniListValue(temList, "zycmc", "知识产权处", keyList);
		temList = iniListValue(temList, "zycmc", "物装部", keyList);
		temList = iniListValue(temList, "zycmc", "炼油部", keyList);
		temList = iniListValue(temList, "zycmc", "化工部", keyList);

		System.out.println("====" + JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "领导二级页面，8个院新开、续建情况,每一行是一个院", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/ld/project-info/unit")
	public JSONArray getProjectTypeCountByUnitLD(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getProjectTypeCountByUnitLD===========================" + map);

		List temList = outProjectService.getProjectTypeCountByUnitLD(map);

		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "预算执行情况，包含股份公司、资产公司、集团公司的", notes = "参数年度，权限控制")
	@RequestMapping(value = "/out-project-provider/budget/all-level")
	public JSONArray getAllBudgetWithAllLevel(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getAllBudgetWithAllLevel===========================" + map);

		List noAuthTotalList = outProjectService.getAllBudgetWithAllLevel(map);

		// temList 为返回数据的架子，里面包含费用性和资本性的金额。如果权限足够不用调整，先清空金额再分别计算
		BudgetItemSearchVo vo = new BudgetItemSearchVo();
		vo.setNd(map.get("nd"));

		boolean leaderFlag = false;
		boolean zbxFlag = false;
		this.authControl(map);
		if (map.get("zbxFlag") != null && map.get("zbxFlag").toString().equals("2")) {
			zbxFlag = true;
		}
		if (map.get("leaderFlag") != null && map.get("leaderFlag").toString().equals("2")) {
			leaderFlag = true;
		}
		System.out.println("2getAllBudgetWithAllLevelleaderFlag--------------"+leaderFlag+"===="+zbxFlag);
		
		String zycbm = map.get("zycbm");
		Set<String> set = new HashSet<>(Arrays.asList(zycbm.split(",")));
		List<String> list_1 = new ArrayList<>(set);
		vo.getUnitIds().addAll(list_1);
		vo = budgetClient.selectBudgetInfoList(vo);
		JSONObject voObject = JSONObject.parseObject(JSONObject.toJSONString(vo));
		System.out.println(">>>>>>>>>>>预算selectBudgetInfoList:"+voObject.toString());
		
		
		// 费用性预算金额
		List<Map<String, Object>> budMoneyList = vo.getBudgetByAllUnit();

		// 实际新签金额（资本性金额、费用性金额）---不包括各个研究院，只有研究院总金额
		List actList = outProjectService.getProjectActMoneyAndCount(map);

		// 实际各个研究院新签金额（资本性金额、费用性金额）
		map.put("typeFlag", "直属研究院");
		List instList = outProjectService.getProjectActMoneyAndCountThreeLevel(map);
		int oneOrder = 0, twoOrder = 0, threeOrder = 0;
		double totalFyxBudget = 0d;
		double totalFyxXqBudget = 0d;
		double totalFyxJzBudget = 0d;
		double totalFyxXqMoney = 0d;
		double totalZbxBudget = 0d;
		double totalZbxXqMoney = 0d;

		double totalFyxBudgetMobile = 0d;
		double totalZbxBudgetMobile = 0d;

		// 马永生工作室的预算，在移动端查看预算总值时，特殊处理，从直属研究院/勘探院中扣除
		double mysBudget = 0d;

		for (int i = 0; i < noAuthTotalList.size(); i++) {
			Map<String, Object> temMap = (Map<String, Object>) noAuthTotalList.get(i);
			for (int j = 0; j < budMoneyList.size(); j++) {
				Map<String, Object> bm = budMoneyList.get(j);
				if (temMap.get("show_ali").toString().equals(bm.get("budgetItemName").toString())) {
					temMap.put("fyxXqBudget", bm.get("xq") == null ? "0" : bm.get("xq"));
					temMap.put("fyxJzBudget", bm.get("jz") == null ? "0" : bm.get("jz"));
					System.out.println("预算各机构金额-----" + bm.get("budgetItemName") + "========" + bm.get("xq") + "========" + bm.get("jz") + "========" + bm.get("otherPayMoney"));
					if (bm.get("budgetItemName").toString().equals("股份公司") || bm.get("budgetItemName").toString().equals("集团公司") || bm.get("budgetItemName").toString().equals("资产公司")) {
						if (leaderFlag) {// 领导在算股份、集团、资产合计的时候，直接按照总表计算。
							temMap.put("fyxBudget", temMap.get("fyxBudget"));
							temMap.put("fyxJzBudget", bm.get("jz") == null ? "0" : bm.get("jz"));
							temMap.put("fyxXqBudget", Double.valueOf(temMap.get("fyxBudget").toString()) - Double.valueOf(temMap.get("fyxJzBudget").toString()));
						}
					}
					temMap.put("fyxBudget", Double.valueOf(temMap.get("fyxXqBudget").toString()) + Double.valueOf(temMap.get("fyxJzBudget").toString()));
					temMap.put("fyxXqMoney", bm.get("otherPayMoney") == null ? "0" : bm.get("otherPayMoney"));

					// 如果费用性为0，说明没有进行分解（中东、休斯顿等），直接按照总表的数值即可
					if (temMap.get("fyxBudget") == null || Double.parseDouble(temMap.get("fyxBudget").toString()) == 0d) {
						if (leaderFlag) { // 领导直接看总表数值
							temMap.put("fyxBudgetMobile", temMap.get("fyxBudgetMobile"));
							if (temMap.get("show_ali").toString().contains("马永生")) {
								mysBudget = Double.parseDouble(temMap.get("fyxBudgetMobile").toString());
							}
						} else {
							temMap.put("fyxBudgetMobile", "0");
						}
					} else {
						temMap.put("fyxBudgetMobile", temMap.get("fyxBudget"));
					}
					break;
				}
			}

			for (int j = 0; j < actList.size(); j++) {
				Map<String, Object> act = (Map<String, Object>) actList.get(j);
				if (temMap.get("show_ali") != null && act.get("type_flag") != null && temMap.get("show_ali").toString().equals(act.get("type_flag").toString())) {
					// 加上手动认定的新签
					if (temMap.get("fyxXqMoney") == null)
						temMap.put("fyxXqMoney", "0");
					temMap.put("fyxXqMoney", act.get("fyxXqMoney") == null ? Double.valueOf(temMap.get("fyxXqMoney").toString()) : Double.valueOf(act.get("fyxXqMoney").toString()) + Double.valueOf(temMap.get("fyxXqMoney").toString()));
					temMap.put("zbxXqMoney", act.get("zbxXqMoney") == null ? "0" : act.get("zbxXqMoney"));
					System.out.println("实际各机构金额-----" + act.get("type_flag") + "========" + act.get("fyxXqMoney") + "========" + act.get("zbxXqMoney"));
					break;
				}
			}

			for (int j = 0; j < instList.size(); j++) {
				Map<String, Object> inst = (Map<String, Object>) instList.get(j);
				if (temMap.get("show_ali") != null && temMap.get("show_ali").toString().equals(inst.get("define2").toString())) {
					temMap.put("fyxXqMoney", inst.get("fyxXqMoney") == null ? "0" : inst.get("fyxXqMoney"));
					temMap.put("zbxXqMoney", inst.get("zbxXqMoney") == null ? "0" : inst.get("zbxXqMoney"));
					System.out.println("研究院实际金额-----" + inst.get("define2") + "========" + inst.get("fyxXqMoney") + "========" + inst.get("zbxXqMoney"));
					break;
				}
			}

			// 不可以看资本性的，直接清空所有资本性
			if (!zbxFlag) {
				temMap.put("zbxBudget", 0);
				temMap.put("zbxBudgetMobile", 0);
				temMap.put("zbxXqMoney", 0);
			}

			// 序号处理
			if (temMap.get("money_level") != null && temMap.get("money_level").toString().equals("1")) {
				oneOrder++;
				if (oneOrder == 1) {
					temMap.put("showOrder", "一、");
					temMap.put("showFlag", "1-1");
				}
				if (oneOrder == 2) {
					temMap.put("showOrder", "二、");
					temMap.put("showFlag", "1-2");
				}
				if (oneOrder == 3) {
					temMap.put("showOrder", "三、");
					temMap.put("showFlag", "1-3");
				}
				temMap.put("levelFlag", "1");
				// 计算总数时，考虑总的一层，不计算“二级”预算，防止重复计算
				totalFyxBudget = totalFyxBudget + Double.parseDouble(temMap.get("fyxBudget") == null ? "0" : temMap.get("fyxBudget").toString());
				totalFyxXqBudget = totalFyxXqBudget + Double.parseDouble(temMap.get("fyxXqBudget") == null ? "0" : temMap.get("fyxXqBudget").toString());
				totalFyxJzBudget = totalFyxJzBudget + Double.parseDouble(temMap.get("fyxJzBudget") == null ? "0" : temMap.get("fyxJzBudget").toString());
				totalZbxBudget = totalZbxBudget + Double.parseDouble(temMap.get("zbxBudget") == null ? "0" : temMap.get("zbxBudget").toString());
				totalFyxXqMoney = totalFyxXqMoney + Double.parseDouble(temMap.get("fyxXqMoney") == null ? "0" : temMap.get("fyxXqMoney").toString());
				totalZbxXqMoney = totalZbxXqMoney + Double.parseDouble(temMap.get("zbxXqMoney") == null ? "0" : temMap.get("zbxXqMoney").toString());

				totalFyxBudgetMobile = totalFyxBudgetMobile + Double.parseDouble(temMap.get("fyxBudgetMobile") == null ? "0" : temMap.get("fyxBudgetMobile").toString());
				totalZbxBudgetMobile = totalZbxBudgetMobile + Double.parseDouble(temMap.get("zbxBudgetMobile") == null ? "0" : temMap.get("zbxBudgetMobile").toString());
			} else if (temMap.get("money_level") != null && temMap.get("money_level").toString().equals("2")) {
				twoOrder++;
				temMap.put("showOrder", twoOrder);
				temMap.put("showFlag", "1-1-" + twoOrder);
				temMap.put("levelFlag", "2");

			} else if (temMap.get("money_level") != null && temMap.get("money_level").toString().equals("3")) {
				threeOrder++;
				temMap.put("showOrder", "1." + String.valueOf(threeOrder));
				temMap.put("showFlag", "1-1-1-" + threeOrder);
				temMap.put("levelFlag", "3");
			}
		}
		Map<String, Object> totalMap = new HashMap<String, Object>();
		totalMap.put("showOrder", "总计");
		totalMap.put("show_ali", "");
		totalMap.put("showFlag", "1");
		totalMap.put("levelFlag", "0");
		totalMap.put("fyxXqBudget", totalFyxXqBudget);
		totalMap.put("fyxJzBudget", totalFyxJzBudget);
		totalMap.put("fyxXqMoney", totalFyxXqMoney);
		totalMap.put("fyxBudget", totalFyxBudget);
		totalMap.put("zbxBudget", totalZbxBudget);
		totalMap.put("zbxXqMoney", totalZbxXqMoney);

		totalMap.put("fyxBudgetMobile", totalFyxBudgetMobile);
		totalMap.put("zbxBudgetMobile", totalZbxBudgetMobile);

		noAuthTotalList.add(0, totalMap);

		System.out.println("特殊马永生-----" + mysBudget);
		// 计算各个比率
		for (int i = 0; i < noAuthTotalList.size(); i++) {
			Map<String, Object> temMap = (Map<String, Object>) noAuthTotalList.get(i);
			if (temMap.get("fyxXqBudget") == null || temMap.get("fyxXqBudget").toString().equals(""))
				temMap.put("fyxXqBudget", 0d);
			if (temMap.get("fyxJzBudget") == null || temMap.get("fyxJzBudget").toString().equals(""))
				temMap.put("fyxJzBudget", 0d);
			if (temMap.get("fyxXqMoney") == null || temMap.get("fyxXqMoney").toString().equals(""))
				temMap.put("fyxXqMoney", 0d);
			if (temMap.get("fyxBudget") == null || temMap.get("fyxBudget").toString().equals(""))
				temMap.put("fyxBudget", 0d);
			if (temMap.get("zbxBudget") == null || temMap.get("zbxBudget").toString().equals(""))
				temMap.put("zbxBudget", 0d);
			if (temMap.get("zbxXqMoney") == null || temMap.get("zbxXqMoney").toString().equals(""))
				temMap.put("zbxXqMoney", 0d);

			if (temMap.get("fyxBudgetMobile") == null || temMap.get("fyxBudgetMobile").toString().equals(""))
				temMap.put("fyxBudgetMobile", 0d);
			if (temMap.get("zbxBudgetMobile") == null || temMap.get("zbxBudgetMobile").toString().equals(""))
				temMap.put("zbxBudgetMobile", 0d);

			if (temMap.get("showFlag") == null || temMap.get("showFlag").toString().equals(""))
				temMap.put("showFlag", "0");

			// 马永生工作室的预算，在移动端查看预算总值时，特殊处理，从直属研究院/勘探院中扣除
			if (temMap.get("show_ali").toString().contains("勘探院") || temMap.get("show_ali").toString().contains("直属研究院")) {
				System.out.println("特殊马永生直属研究院勘探院-----" + mysBudget);
				temMap.put("fyxBudgetMobile", Double.parseDouble(temMap.get("fyxBudgetMobile").toString()) - mysBudget);
			}

			Double fyxXqBudget = Double.valueOf(temMap.get("fyxXqBudget").toString());
			Double fyxJzBudget = Double.valueOf(temMap.get("fyxJzBudget").toString());
			Double fyxXqMoney = Double.valueOf(temMap.get("fyxXqMoney").toString());
			Double fyxBudget = Double.valueOf(temMap.get("fyxBudget").toString());
			Double zbxBudget = Double.valueOf(temMap.get("zbxBudget").toString());
			Double zbxXqMoney = Double.valueOf(temMap.get("zbxXqMoney").toString());

			if (fyxXqMoney != 0 && fyxXqBudget != 0) {
				temMap.put("fyxXqRate", String.format("%.4f", Double.valueOf(fyxXqMoney * 100 / fyxXqBudget)));
			} else {
				temMap.put("fyxXqRate", 0);
			}
			if ((fyxXqMoney + fyxJzBudget) != 0 && fyxBudget != 0) {
				temMap.put("fyxRate", String.format("%.4f", Double.valueOf((fyxXqMoney + fyxJzBudget) * 100 / fyxBudget)));
			} else {
				temMap.put("fyxRate", 0);
			}
			if (zbxXqMoney != 0 && zbxBudget != 0) {
				temMap.put("zbxRate", String.format("%.4f", Double.valueOf(zbxXqMoney * 100 / zbxBudget)));
			} else {
				temMap.put("zbxRate", 0);
			}
		}

		JSONArray json = JSONArray.parseArray(JSON.toJSONString(noAuthTotalList));
		return json;
	}

	@ApiOperation(value = "领导二级页面，预算数据，直属研究院、分子公司等9个维度的费用统计,树形结构", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/ys/tree/company-money")
	public JSONArray getCompanyMoneyTreeWithYS(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getCompanyMoneyTreeWithYS===========================" + map);

		List temList = outProjectService.getCompanyMoneyTreeWithYS(map);

		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "领导二级页面，预算数据，直属研究院、分子公司等9个维度的费用统计", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/ys/company-money")
	public JSONArray getCompanyMoneyWithYS(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getCompanyMoneyWithYS===========================" + map);

		List temList = outProjectService.getCompanyMoneyWithYS(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "领导二级页面，预算数据，17处室的费用统计， 树形结构 ", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/ys/tree/office-money")
	public JSONArray getOfficeMoneyTreeWithYS(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getOfficeMoneyTreeWithYS===========================" + map);

		List temList = outProjectService.getOfficeMoneyTreeWithYS(map);

		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "领导二级页面，预算数据，17处室的费用统计，", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/ys/office-money")
	public JSONArray getOfficeMoneyWithYS(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getOfficeMoneyWithYS===========================" + map);

		List temList = outProjectService.getOfficeMoneyWithYS(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "领导首页，十条龙页面，重大专项项目详情", notes = "参数年度、研究院等")
	@RequestMapping(value = "/out-project-provider/ld/project-info/zdstl")
	public JSONArray getZDSTLProjectInfo(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getZDSTLProjectInfo===========================" + map);
		List temList = outProjectService.getZDSTLProjectInfo(map);
		// 特殊处理，显示序号问题。相同的十条龙项目合并序号
		int realIndex = 0;
		String hth = "";
		for (int i = 0; i < temList.size(); i++) {
			HashMap temMap = (HashMap) temList.get(i);
			String temHth = temMap.get("showHth").toString();
			if (!temHth.equals(hth)) {
				realIndex++;
				hth = temHth;
			}
			temMap.put("realIndex", realIndex);
		}
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "领导二级页面，重点项目、国家项目、重大专项、十条龙、其他项目的新开、结转情况", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/project-info/new-old/lx")
	public JSONArray getProjectNewOldInfoByType(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getProjectNewOldInfoByType===========================" + map);

		List temList = outProjectService.getProjectNewOldInfoByType(map);

		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "领导二级页面，各类型技术的新开、结转情况 ", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/tech/type/project-info")
	public JSONArray getProjectInfoByTecTypeWithOldNew(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getProjectInfoByTecTypeWithOldNew===========================" + map);

		List temList = outProjectService.getProjectInfoByTecTypeWithOldNew(map);

		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "领导首页-十条龙，十条龙项目的类型分布 ", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/dragon/type/project-info")
	public JSONArray getDragonProjectInfoByType(@RequestBody HashMap<String, String> map) throws Exception {
		this.authControl(map);

		List temList = outProjectService.getDragonProjectInfoByType(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "领导首页-十条龙，十条龙项目的出入龙情况 ", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/dragon/out-in/project-info")
	public JSONArray getDragonProjectInfoWithOutIn(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getDragonProjectInfoWithOutIn===========================" + map);
		this.authControl(map);
		List temList = outProjectService.getDragonProjectInfoWithOutIn(map);

		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "领导首页-十条龙，十条龙项目的出入龙情况 ", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/dragon/institute/project-info")
	public JSONArray getDragonProjectInfoByInstitute(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getDragonProjectInfoByInstitute===========================" + map);
		this.authControl(map);
		List temList = outProjectService.getDragonProjectInfoByInstitute(map);
		HashMap<String, String> map1 = new HashMap<String, String>();
		// outProjectRemoteClient.getLastCountryProject(map1);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		// 根据研究院排序
		String[] unitNames = new String[] { "勘探院", "物探院", "工程院", "石科院", "大连院", "北化院", "上海院", "安工院" };
		List<String> ulist = Arrays.asList(unitNames);
		java.util.Collections.sort(json, new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				String d1 = JSONObject.parseObject(o1.toString()).get("define2").toString();
				String d2 = JSONObject.parseObject(o2.toString()).get("define2").toString();
				return ulist.indexOf(d1) - ulist.indexOf(d2);
			}
		});
		return json;
	}

	@ApiOperation(value = "领导首页-十条龙，十条龙项目的详情", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/dragon/details")
	public JSONArray getDragonProjectDetails(@RequestBody HashMap<String, Object> map) throws Exception {
		logger.info("==================page getDragonProjectDetails===========================" + map);
		this.authControl(map);
		List temList = outProjectService.getDragonProjectDetails(map);

		// 特殊处理，显示序号问题。相同的十条龙项目合并序号
		int realIndex = 0;
		String xmid = "";
		for (int i = 0; i < temList.size(); i++) {
			HashMap temMap = (HashMap) temList.get(i);
			String temXmid = temMap.get("xmid").toString();
			if (!temXmid.equals(xmid)) {
				realIndex++;
				xmid = temXmid;
			}
			temMap.put("realIndex", realIndex);
		}
		System.out.println("======JSON.toJSONString(temList)-----" + JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "获取项目详情的查询维度（条件）", notes = "几个维度一次查询，前台特殊处理一下")
	@RequestMapping(value = "/out-project-provider/select-condition/list")
	public JSONArray getProjectInfoSelectCondition(@RequestBody HashMap<String, String> map) {
		logger.info("==================page getProjectInfoSelectCondition===========================" + map);

		List temList = outProjectService.getProjectInfoSelectCondition(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "获取十条龙项目详情的查询维度（条件）", notes = "几个维度一次查询，前台特殊处理一下")
	@RequestMapping(value = "/out-project-provider/dragon/select-condition/list")
	public JSONArray getDragonProjectInfoSelectCondition(@RequestBody HashMap<String, String> map) {
		logger.info("==================page getDragonProjectInfoSelectCondition===========================" + map);

		List temList = outProjectService.getDragonProjectInfoSelectCondition(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "分页显示项目数据", notes = "分页显示项目数据")
	@RequestMapping(value = "/out-provider/project-list-expert", method = RequestMethod.POST)
	public LayuiTableData getOutProjectListPageExpert(@RequestBody LayuiTableParam param) throws Exception {
		return outProjectService.getOutProjectPageExpert(param);
	}

	@ApiOperation(value = "检索项目数据", notes = "检索所有项目数据")
	@RequestMapping(value = "/out-provider/select-all-project-info", method = RequestMethod.POST)
	public Object selectAllOutProjectInfo(@RequestBody HashMap<String, String> param) throws Exception {
		return outProjectService.selectAllProjectInfo();
	}

	@ApiOperation(value = "更新项目数据", notes = "更新项目数据")
	@RequestMapping(value = "/out-provider/update-project-info", method = RequestMethod.POST)
	public Integer updOutProjectInfo(@RequestBody OutProjectInfo project) throws Exception {
		return outProjectService.updateProjectInfoByKey(project);
	}

	@ApiOperation(value = "检索项目数据", notes = "国家项目查阅，“十条龙”项目查阅，重大项目查阅")
	@RequestMapping(value = "/out-provider/report-project-list", method = RequestMethod.POST)
	public LayuiTableData selectOutProjectInfoList(@RequestBody LayuiTableParam param) throws Exception {
		return outProjectService.selectOutProjectInfoList(param);
	}

	@ApiOperation(value = "检索项目数据", notes = "根据自定义条件查询项目信息")
	@RequestMapping(value = "/out-provider/selectByExample", method = RequestMethod.POST)
	public List<OutProjectInfo> selectByExample(OutProjectInfoExample example) throws Exception {
		return outProjectService.selectByExample(example);
	}

	@ApiOperation(value = "检索项目单位", notes = "根据条件检索负责单位")
	@RequestMapping(value = "/out-provider/select-project-unit", method = RequestMethod.POST)
	public List<OutProjectInfo> selectProjectUnit(@RequestBody OutProjectInfo example) {
		return outProjectService.selectProjectUnit(example);
	}

	@ApiOperation(value = "检索结转项目", notes = "根据年度检索结转项目列表")
	@RequestMapping(value = "/out-provider/select-project-jz-items", method = RequestMethod.POST)
	public List<OutProjectInfo> selectProjectInfoJzItems(@RequestBody OutProjectInfo example) {
		return outProjectService.selectProjectInfoJzItems(example);
	}

	@ApiOperation(value = "检索结转金额", notes = "根据年度预算单位、处部门汇总结转金额")
	@RequestMapping(value = "/out-provider/select-project-jz", method = RequestMethod.POST)
	public List<OutProjectInfo> selectProjectInfoJz(@RequestBody OutProjectInfo example) {
		return outProjectService.selectProjectInfoJz(example);
	}

	/**
	 * ===============================================十条龙维护====================
	 * ===============================
	 */

	@ApiOperation(value = "分页显示项目数据", notes = "分页显示项目数据")
	@RequestMapping(value = "/out-project-provider/ten_dragons/page", method = RequestMethod.POST)
	public LayuiTableData page(@RequestBody LayuiTableParam param) throws Exception {
		logger.info("==================page ten_dragons page===========================" + JSONObject.toJSONString(param));
		return outProjectService.getTenDragonsOutProjectPage(param);
	}

	@RequestMapping(value = "/out-project-provider/ten_dragons/add", method = RequestMethod.POST)
	public Integer insertOutProjectInfo(@RequestBody OutProjectInfo outProjectInfo) throws Exception {
		logger.info("====================add ten_dragons....========================");
		Integer count = outProjectService.insertOutProjectInfo(outProjectInfo);
		return count;
	}

	@RequestMapping(value = "/out-project-provider/ten_dragons/addWithBLOB", method = RequestMethod.POST)
	public Integer insertOutProjectInfoWithBLOBs(@RequestBody OutProjectInfoWithBLOBs record) throws Exception {
		logger.info("====================add ten_dragons...addWithBLOB.========================");
		Integer count = outProjectService.insertOutProjectInfoWithBLOBs(record);
		return count;
	}

	@RequestMapping(value = "/out-project-provider/ten_dragons/update", method = RequestMethod.POST)
	public Integer updateOutProjectInfo(@RequestBody OutProjectInfo outProjectInfo) throws Exception {
		logger.info("==================update ten_dragons update===========================");
		return outProjectService.updateOutProject_Info(outProjectInfo);
	}

	@RequestMapping(value = "/out-project-provider/ten_dragons/updateWithBLOB", method = RequestMethod.POST)
	public Integer updateOutProjectInfoWithBLOBs(@RequestBody OutProjectInfoWithBLOBs record) throws Exception {
		logger.info("==================update ten_dragons updateWithBLOB===========================");
		return outProjectService.updateOutProjectInfoWithBLOBs(record);
	}

	@RequestMapping(value = "/out-project-provider/ten_dragons/delete/{id}", method = RequestMethod.POST)
	public int deleteOutProjectInfo(@PathVariable("id") String id) throws Exception {
		logger.info("=============================delete ten_dragons=================");
		return outProjectService.deleteOutProjectInfo(id);
	}

	@RequestMapping(value = "/out-project-provider/ten_dragons/get/{id}", method = RequestMethod.GET)
	public OutProjectInfo selectOutProjectInfo(@PathVariable(value = "id", required = true) String id) throws Exception {
		logger.info("===============================get ten_dragons id " + id + "===========");
		return outProjectService.selectOutProjectInfo(id);
	}

	@RequestMapping(value = "/out-project-provider/ten_dragons/getWithBLOB/{id}", method = RequestMethod.GET)
	public OutProjectInfo selectOutProjectInfoWithBLOB(@PathVariable(value = "id", required = true) String id) throws Exception {
		logger.info("===============================get ten_dragons  WithBLOB id " + id + "===========");
		return outProjectService.selectOutProjectInfoWithBLOBs(id);
	}

	@ApiOperation(value = "查询分子公司数据", notes = "查询分子公司数据")
	@RequestMapping(value = "/out-provider/project-company-list", method = RequestMethod.POST)
	public List<OutProjectInfo> getOutCompanyList(@RequestBody OutProjectInfo outProjectInfo) throws Exception {
		logger.info("==================page getOutProjectCompanyList===========================" + JSONObject.toJSONString(outProjectInfo));
		return outProjectService.getOutCompanyList(outProjectInfo);
	}

	@ApiOperation(value = "查询合同信息", notes = "根据条件查询合同数据")
	@RequestMapping(value = "/out-provider/project-info-list-bycondition", method = RequestMethod.POST)
	public Object selectProjectInfoByCondition(@RequestBody OutProjectInfo outProjectInfo) throws Exception {
		logger.info("==================selectProjectInfoByCondition===========================" + JSONObject.toJSONString(outProjectInfo));
		Map<String,Object> paramMap = MyBeanUtils.transBean2Map(outProjectInfo);
		return outProjectService.selectProjectInfoByCondition(paramMap);
	}

	/**
	 * 访问权限处理，集中控制
	 * authFlag 资本性权利
	 */
	public void authControl(HashMap map) {
		String zycbm = (String) map.get("zycbm");
		// 综合计划处的权限，可以看全部
		if (zycbm != null && zycbm.contains("30130054")) {
			map.put("leaderFlag", "2");
		}
		if (map.get("leaderFlag") != null && map.get("leaderFlag").toString().equals("2")) {
			// 大领导、计划处特殊，能看所有的费用性预算
			map.put("zbxFlag", "2");
			zycbm = "30130055,30130064,30130065,30130056,30130057,30130058,30130059,30130054,30130063,30130062,30130061,30130011,30130010,30130015,3013000902,30130009,30130016,ZX,JD";
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

		Object username = map.get("username");
		// 王丽娟特殊处理，不是大领导，也需要看30130054专业处的预算
		if (username != null && username.toString().equals("wanglj")) {
			zycbm = zycbm + ",30130054";
			map.put("zbxFlag", "2");
		}
		map.put("zycbm", zycbm);
	}
	@ApiOperation(value = "查询合同信息", notes = "根据ID查询合同数据")
	@RequestMapping(value = "/out-project-provider/project/info-detail/{dataId}", method = RequestMethod.POST)
	public OutProjectInfo selectOutProjectInfoDetail(@PathVariable(value = "dataId", required = true) String dataId) throws Exception {
		return outProjectService.selectOutProjectInfo(dataId);
	}
	
}
