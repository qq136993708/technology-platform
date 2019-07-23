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
import com.pcitc.service.feign.hana.OutProjectRemoteClient;
import com.pcitc.service.out.OutProjectService;

@Api(value = "OUTPROJECT-API", description = "项目数据，从项目管理系统中获取")
@RestController
public class OutProjectInfoClient {

	@Autowired
	private OutProjectService outProjectService;

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
		OutProjectInfo opi = new OutProjectInfo();

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
		String zycbm = map.get("zycbm");
		if (map.get("leaderFlag") != null && (map.get("leaderFlag").toString().equals("2"))) {
			// 大领导特殊，能看所有
			zycbm = "30130055,30130064,30130065,30130056,30130057,30130058,30130059,30130054,30130063,30130062,30130061,30130011,30130017,30130018,3013000902,30130009,30130016,ZX,JD";
			map.put("zycbm", zycbm);
		} else {
			// 机动、专项的费用，只能由拥有计划处（30130054）等特殊处室的人能看到
			if (map != null && zycbm != null && (map.get("zycbm").toString().indexOf("30130054") > -1)) {
				map.put("zycbm", map.get("zycbm").toString() + ",ZX,JD");
			}
		}
		System.out.println("1------------------"+map.get("zycbm").toString());
		System.out.println("2------------------"+map.get("leaderFlag").toString());
		HashMap<String, String> temMap = outProjectService.getOutProjectInfoMoney(map);
		
		HashMap<String, String> temBudFyxMap = outProjectService.getProjectBudgetFyxMoney(map);
		
		HashMap<String, String> temBudZbxMap = null;
		// 资本性费用，只能由拥有大领导、计划处（30130054）等特殊处室的人能看到
		if ((map.get("leaderFlag") != null && (map.get("leaderFlag").toString().equals("2"))) || (map != null && map.get("zycbm") != null && (map.get("zycbm").toString().indexOf("30130054") > -1))) {
			temBudZbxMap = outProjectService.getBudgetZBXMoney(map);
		}
		if (temMap != null) {
			retJson.put("projectMoney", temMap.get("projectMoney"));
		} else {
			retJson.put("projectMoney", 0);
		}
		// 预算金额（费用性）
		if (temBudFyxMap != null) {
			retJson.put("budgetFyxMoney", temBudFyxMap.get("budgetFyxMoney"));
		} else {
			retJson.put("budgetFyxMoney", 0);
		}

		// 预算金额（资本性），没办法按照专业处进行权限控制
		if (temBudZbxMap != null) {
			retJson.put("budgetZbxMoney", temBudZbxMap.get("budgetZbxMoney"));
		} else {
			retJson.put("budgetZbxMoney", 0);
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

	@ApiOperation(value = "首页查询各单位的新开、续建、完结情况", notes = "参数暂时是空")
	@RequestMapping(value = "/out-project-provider/type/unit/list")
	public JSONArray getProjectTypeInfoByUnit(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getProjectTypeInfoByUnit===========================" + map);
		List temList = outProjectService.getProjectTypeInfoByUnit(map);

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
		temList = iniListValue(temList, "zycmc", "装储处", keyList);
		temList = iniListValue(temList, "zycmc", "计划处", keyList);
		temList = iniListValue(temList, "zycmc", "技术监督处", keyList);
		temList = iniListValue(temList, "zycmc", "三剂处", keyList);
		temList = iniListValue(temList, "zycmc", "知识产权处", keyList);
		temList = iniListValue(temList, "zycmc", "物装部", keyList);
		temList = iniListValue(temList, "zycmc", "炼油部（B2、C类）", keyList);
		temList = iniListValue(temList, "zycmc", "化工部（B2、C类）", keyList);
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
		keyList.add("装储处");
		keyList.add("计划处");
		keyList.add("技术监督处");
		keyList.add("三剂处");
		keyList.add("知识产权处");
		keyList.add("物装部");
		keyList.add("炼油部（B2、C类）");
		keyList.add("化工部（B2、C类）");
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
		temList = iniListValue(temList, "zycmc", "装储处", keyList);
		temList = iniListValue(temList, "zycmc", "计划处", keyList);
		temList = iniListValue(temList, "zycmc", "技术监督处", keyList);
		temList = iniListValue(temList, "zycmc", "三剂处", keyList);
		temList = iniListValue(temList, "zycmc", "知识产权处", keyList);
		temList = iniListValue(temList, "zycmc", "物装部", keyList);
		temList = iniListValue(temList, "zycmc", "炼油部（B2、C类）", keyList);
		temList = iniListValue(temList, "zycmc", "化工部（B2、C类）", keyList);

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

	@ApiOperation(value = "领导二级页面，预算数据，8个院费用性和资本性的柱状图", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/ys/institute-money")
	public JSONArray getInstituteMoneyWithYS(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getInstituteMoneyWithYS===========================" + map);

		List temList = outProjectService.getInstituteMoneyWithYS(map);

		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
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

	@ApiOperation(value = "领导二级页面，直属研究院，8个院预算金额和实际金额的统计", notes = "参数年度、研究院等")
	@RequestMapping(value = "/out-project-provider/ld/money-rate/institute")
	public JSONArray getProjectMoneyByInstituteForLD(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getProjectMoneyByInstituteForLD===========================" + map);

		List temList = outProjectService.getProjectMoneyByInstituteForLD(map);
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
		logger.info("==================page getDragonProjectInfoByType===========================" + map);

		List temList = outProjectService.getDragonProjectInfoByType(map);

		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "领导首页-十条龙，十条龙项目的出入龙情况 ", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/dragon/out-in/project-info")
	public JSONArray getDragonProjectInfoWithOutIn(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getDragonProjectInfoWithOutIn===========================" + map);

		List temList = outProjectService.getDragonProjectInfoWithOutIn(map);

		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "领导首页-十条龙，十条龙项目的出入龙情况 ", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/dragon/institute/project-info")
	public JSONArray getDragonProjectInfoByInstitute(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getDragonProjectInfoByInstitute===========================" + map);

		List temList = outProjectService.getDragonProjectInfoByInstitute(map);
		HashMap<String, String> map1 = new HashMap<String, String>();
		// outProjectRemoteClient.getLastCountryProject(map1);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "领导首页-十条龙，十条龙项目的详情", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/dragon/details")
	public JSONArray getDragonProjectDetails(@RequestBody HashMap<String, Object> map) throws Exception {
		logger.info("==================page getDragonProjectDetails===========================" + map);
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
}
