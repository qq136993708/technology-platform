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
import com.pcitc.service.out.OutProjectService;

@Api(value = "OUTPROJECT-API", description = "项目数据，从项目管理系统中获取")
@RestController
public class OutProjectInfoClient {

	@Autowired
	private OutProjectService outProjectService;
	
	private final static Logger logger = LoggerFactory.getLogger(OutProjectInfoClient.class);

	@ApiOperation(value = "分页显示项目数据", notes = "分页显示项目数据")
	@RequestMapping(value = "/out-provider/project-list", method = RequestMethod.POST)
	public LayuiTableData getOutProjectListPage(@RequestBody LayuiTableParam param) throws Exception {
		logger.info("==================page getOutProjectListPage===========================" + param);
		return outProjectService.getOutProjectPage(param);
	}
	
	@ApiOperation(value = "保存erp课题配置", notes = "删除当前页已有的，保存新选择的")
	@RequestMapping(value = "/out-provider/config-erp-project", method = RequestMethod.POST)
	public String saveErpProjectConfig(@RequestBody JSONObject json) throws Exception {
		System.out.println("==-=-=-="+json);
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
			
			for (int i =0 ; i < tems.length; i++) {
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
			for (int i =0 ; i < newcodes.length; i++) {
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
		System.out.println("==-=-=-="+json);
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

	@ApiOperation(value = "项目总数", notes = "首页查询使用")
	@RequestMapping(value = "/out-provider/project-count", method = RequestMethod.POST)
	public JSONObject getProjectCount(@RequestBody HashMap<String, String> map) {
		String nd = null;
		JSONObject retJson = new JSONObject();
		System.out.println("1jsonStr======" + map);
		if (map != null && map.get("nd") != null && !map.get("nd").equals("")) {
			nd = map.get("nd").toString();
		} else {
			retJson.put("jfTotal", 0);
			retJson.put("kyzbCount", 0);
			retJson.put("projectCount", 0);
		}
		System.out.println("2jsonStr======" + nd);
		
		HashMap<String, String> temMap = outProjectService.getOutProjectInfoCount(map);
		if (temMap != null) {
			retJson.put("jfTotal", temMap.get("jfTotal"));
			retJson.put("kyzbCount", temMap.get("kyzbCount"));
			retJson.put("projectCount", temMap.get("projectCount"));
		} else {
			retJson.put("jfTotal", 0);
			retJson.put("kyzbCount", 0);
			retJson.put("projectCount", 0);
		}
		
		return retJson;
    }
    
	/**
	 * @author Nishikino
	 * 查询id
	 */
	@ApiOperation(value = "根据id查询详情", notes = "根据id查询详情")
	@RequestMapping(value = "/out-provider/get-project-list/{dataId}", method = RequestMethod.POST)
	public OutProjectInfo getOutProjectShow(@PathVariable(value = "dataId", required = true) String dataId) throws Exception{
		return outProjectService.getOutProjectShowById(dataId);
	}
	
	@ApiOperation(value = "首页查询各单位的新开、续建、完结情况", notes = "参数暂时是空")
	@RequestMapping(value = "/out-project-provider/type/unit/list")
	public JSONArray getProjectTypeInfoByUnit(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getProjectTypeInfoByUnit===========================" + map);
		
		List temList = outProjectService.getProjectTypeInfoByUnit(null);
		
		if (!JSON.toJSONString(temList).contains("直属研究院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("wjsl", 0);
			temMap.put("type_flag", "直属研究院");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("分子公司")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("wjsl", 0);
			temMap.put("type_flag", "分子公司");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("集团单位")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("wjsl", 0);
			temMap.put("type_flag", "集团单位");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("外部单位")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("wjsl", 0);
			temMap.put("type_flag", "外部单位");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("盈科")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("wjsl", 0);
			temMap.put("type_flag", "盈科");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("休斯顿研发中心")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("wjsl", 0);
			temMap.put("type_flag", "休斯顿研发中心");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("中东研发中心")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("wjsl", 0);
			temMap.put("type_flag", "中东研发中心");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("集团公司")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("wjsl", 0);
			temMap.put("type_flag", "集团公司");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("资产公司")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("wjsl", 0);
			temMap.put("type_flag", "资产公司");
			temList.add(temMap);
		}
		System.out.println("===="+JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "首页查询各单位的新开、续建、完结情况--装备", notes = "参数暂时是空")
	@RequestMapping(value = "/out-project-provider/type/zb/unit/list")
	public JSONArray getZBProjectTypeInfoByUnit(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getZBProjectTypeInfoByUnit===========================" + map);
		
		List temList = outProjectService.getZBProjectTypeInfoByUnit(null);
		if (!JSON.toJSONString(temList).contains("直属研究院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("wjsl", 0);
			temMap.put("type_flag", "直属研究院");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("分子公司")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("wjsl", 0);
			temMap.put("type_flag", "分子公司");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("集团单位")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("wjsl", 0);
			temMap.put("type_flag", "集团单位");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("外部单位")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("wjsl", 0);
			temMap.put("type_flag", "外部单位");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("盈科")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("wjsl", 0);
			temMap.put("type_flag", "盈科");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("休斯顿研发中心")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("wjsl", 0);
			temMap.put("type_flag", "休斯顿研发中心");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("中东研发中心")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("wjsl", 0);
			temMap.put("type_flag", "中东研发中心");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("集团公司")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("wjsl", 0);
			temMap.put("type_flag", "集团公司");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("资产公司")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("wjsl", 0);
			temMap.put("type_flag", "资产公司");
			temList.add(temMap);
		}
		System.out.println("===="+JSON.toJSONString(temList));
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
			retJson.put("gjxmsl", temMap.get("gjxmsl"));
			retJson.put("zdzzsl", temMap.get("zdzzsl"));
			retJson.put("zdxmsl", temMap.get("zdxmsl"));
			retJson.put("qtsl", temMap.get("qtsl"));
			retJson.put("ldzsl", temMap.get("ldzsl"));
			retJson.put("zsl", temMap.get("zsl"));
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
		String nd = null;
		JSONObject retJson = new JSONObject();
		HashMap<String, String> temMap = outProjectService.getProjectTotalCountYearAndLastYear(null);
		
		if (temMap != null) {
			retJson.put("xkgjsl", temMap.get("xkgjsl"));
			retJson.put("qngjsl", temMap.get("qngjsl"));
			retJson.put("xkzzsl", temMap.get("xkzzsl"));
			retJson.put("qnzzsl", temMap.get("qnzzsl"));
			retJson.put("xkzdsl", temMap.get("xkzdsl"));
			retJson.put("qnzdsl", temMap.get("qnzdsl"));
			
			retJson.put("lysybsl", temMap.get("lysybsl"));
			retJson.put("qnlysybsl", temMap.get("qnlysybsl"));
			retJson.put("hgsybsl", temMap.get("hgsybsl"));
			retJson.put("qnhgsybsl", temMap.get("qnhgsybsl"));
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
		
		List temList = outProjectService.getProjectCountByProjectType("2018");
		
		if (!JSON.toJSONString(temList).contains("三剂处")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zsl", 0);
			temMap.put("zycmc", "三剂处");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("供应协调处")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zsl", 0);
			temMap.put("zycmc", "供应协调处");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("化工事业部")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zsl", 0);
			temMap.put("zycmc", "化工事业部");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("化工处")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zsl", 0);
			temMap.put("zycmc", "化工处");
			temList.add(temMap);
		}
		
		if (!JSON.toJSONString(temList).contains("技术监督处")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zsl", 0);
			temMap.put("zycmc", "技术监督处");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("材料处")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zsl", 0);
			temMap.put("zycmc", "材料处");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("油田处")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zsl", 0);
			temMap.put("zycmc", "油田处");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("炼油事业部")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zsl", 0);
			temMap.put("zycmc", "炼油事业部");
			temList.add(temMap);
		}
		
		if (!JSON.toJSONString(temList).contains("炼油处")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zsl", 0);
			temMap.put("zycmc", "炼油处");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("知识产权处")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zsl", 0);
			temMap.put("zycmc", "知识产权处");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("装备与储运处")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zsl", 0);
			temMap.put("zycmc", "装备与储运处");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("计划处")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zsl", 0);
			temMap.put("zycmc", "计划处");
			temList.add(temMap);
		}
		System.out.println("===="+JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "按照项目类型（新开、续建）来区分国家项目、重点项目、重大项目、其他项目数量", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/project-type-count/project_scope")
	public JSONArray getProjectTypeCountByType(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getProjectTypeCountByType===========================" + map);
		
		List temList = outProjectService.getProjectTypeCountByType("2018");
		
		if (!JSON.toJSONString(temList).contains("新开课题")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("gjxmsl", 0);
			temMap.put("zdzxxmsl", 0);
			temMap.put("zdxmsl", 0);
			temMap.put("qtsl", 0);
			temMap.put("zsl", 0);
			
			temMap.put("ktysl", 0);
			temMap.put("wtysl", 0);
			temMap.put("gcysl", 0);
			temMap.put("skysl", 0);
			temMap.put("dlysl", 0);
			temMap.put("bhysl", 0);
			temMap.put("shysl", 0);
			temMap.put("agysl", 0);
			temMap.put("project_scope", "新开课题");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("结转课题")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("gjxmsl", 0);
			temMap.put("zdzxxmsl", 0);
			temMap.put("zdxmsl", 0);
			temMap.put("qtsl", 0);
			temMap.put("zsl", 0);
			
			temMap.put("ktysl", 0);
			temMap.put("wtysl", 0);
			temMap.put("gcysl", 0);
			temMap.put("skysl", 0);
			temMap.put("dlysl", 0);
			temMap.put("bhysl", 0);
			temMap.put("shysl", 0);
			temMap.put("agysl", 0);
			
			temMap.put("project_scope", "结转课题");
			temList.add(temMap);
		}
		System.out.println("===="+JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "科研装备，科研二级页面，按照项目类型查询新建、结转课题数量", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/project-count/zb/project-type")
	public JSONArray getZBProjectCountByProjectType(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getZBProjectCountByProjectType===========================" + map);
		
		List temList = outProjectService.getZBProjectCountByProjectType("2018");
		
		if (!JSON.toJSONString(temList).contains("公用技术")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zsl", 0);
			temMap.put("zylb", "公用技术");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("勘探开发技术")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zsl", 0);
			temMap.put("zylb", "勘探开发技术");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("材料技术")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zsl", 0);
			temMap.put("zylb", "材料技术");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("炼油技术")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zsl", 0);
			temMap.put("zylb", "炼油技术");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("石油化工")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zsl", 0);
			temMap.put("zylb", "石油化工");
			temList.add(temMap);
		}
		System.out.println("===="+JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "科研装备，按照项目类型（新开、续建）来区分国家项目、重点项目、重大项目、其他项目数量", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/project-type-count/zb/project_scope")
	public JSONArray getZBProjectTypeCountByType(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getProjectTypeCountByType===========================" + map);
		
		List temList = outProjectService.getZBProjectTypeCountByType("2018");
		
		if (!JSON.toJSONString(temList).contains("新开课题")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("gjxmsl", 0);
			temMap.put("zdzxxmsl", 0);
			temMap.put("zdxmsl", 0);
			temMap.put("qtsl", 0);
			temMap.put("zsl", 0);
			
			temMap.put("ktysl", 0);
			temMap.put("wtysl", 0);
			temMap.put("gcysl", 0);
			temMap.put("skysl", 0);
			temMap.put("dlysl", 0);
			temMap.put("bhysl", 0);
			temMap.put("shysl", 0);
			temMap.put("agysl", 0);
			temMap.put("project_scope", "新开课题");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("结转课题")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("gjxmsl", 0);
			temMap.put("zdzxxmsl", 0);
			temMap.put("zdxmsl", 0);
			temMap.put("qtsl", 0);
			temMap.put("zsl", 0);
			
			temMap.put("ktysl", 0);
			temMap.put("wtysl", 0);
			temMap.put("gcysl", 0);
			temMap.put("skysl", 0);
			temMap.put("dlysl", 0);
			temMap.put("bhysl", 0);
			temMap.put("shysl", 0);
			temMap.put("agysl", 0);
			
			temMap.put("project_scope", "结转课题");
			temList.add(temMap);
		}
		System.out.println("===="+JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "预算分析，新开课题、结转课题对应的费用性金额、资本性金额统计", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/project-money/project-type")
	public JSONArray getProjectMoneyByProjectType(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getProjectMoneyByProjectType===========================" + map);
		
		List temList = outProjectService.getProjectMoneyByProjectType("2018");
		
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
		System.out.println("===="+JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "研究院的各项目的费用性金额、资本性金额统计", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/project-money/institute")
	public JSONArray getProjectMoneyByYJY(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getProjectMoneyByYJY===========================" + map);
		
		List temList = outProjectService.getProjectMoneyByYJY("2018");
		
		if (!JSON.toJSONString(temList).contains("勘探院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("fyxje", 0d);
			temMap.put("zbxje", 0d);
			temMap.put("zje", 0d);
			temMap.put("define2", "勘探院");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("物探院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("fyxje", 0d);
			temMap.put("zbxje", 0d);
			temMap.put("zje", 0d);
			temMap.put("define2", "物探院");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("工程院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("fyxje", 0d);
			temMap.put("zbxje", 0d);
			temMap.put("zje", 0d);
			temMap.put("define2", "工程院");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("石科院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("fyxje", 0d);
			temMap.put("zbxje", 0d);
			temMap.put("zje", 0d);
			temMap.put("define2", "石科院");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("大连院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("fyxje", 0d);
			temMap.put("zbxje", 0d);
			temMap.put("zje", 0d);
			temMap.put("define2", "大连院");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("北化院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("fyxje", 0d);
			temMap.put("zbxje", 0d);
			temMap.put("zje", 0d);
			temMap.put("define2", "北化院");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("上海院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("fyxje", 0d);
			temMap.put("zbxje", 0d);
			temMap.put("zje", 0d);
			temMap.put("define2", "上海院");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("安工院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("fyxje", 0d);
			temMap.put("zbxje", 0d);
			temMap.put("zje", 0d);
			temMap.put("define2", "安工院");
			temList.add(temMap);
		}
		
		System.out.println("===="+JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "树形结构，费用性金额、资本性金额和新开、续建情况", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/project-money/scope/type")
	public JSONArray getProjectMoneyForTree(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getProjectMoneyForTree===========================" + map);
		
		List temList = outProjectService.getProjectMoneyForTree("2018");
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
		
		System.out.println("===="+JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "树形结构，费用性金额、资本性金额和各研究院情况", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/project-money/scope/institute")
	public JSONArray getProjectMoneyByIniAndTypeForTree(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getProjectMoneyByIniAndTypeForTree===========================" + map);
		
		List temList = outProjectService.getProjectMoneyByIniAndTypeForTree("2018");
		
		System.out.println("===="+JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "直属院、盈科等单位的费用性金额、资本性金额统计", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/project-money/unit-type")
	public JSONArray getProjectMoneyByUnit(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getProjectMoneyByUnit===========================" + map);
		
		List temList = outProjectService.getProjectMoneyByUnit("2018");
		
		if (!JSON.toJSONString(temList).contains("直属研究院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("fyxje", 0d);
			temMap.put("zbxje", 0d);
			temMap.put("type_flag", "直属研究院");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("分子公司")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("fyxje", 0d);
			temMap.put("zbxje", 0d);
			temMap.put("type_flag", "分子公司");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("集团单位")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("fyxje", 0d);
			temMap.put("zbxje", 0d);
			temMap.put("type_flag", "集团单位");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("外部单位")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("fyxje", 0d);
			temMap.put("zbxje", 0d);
			temMap.put("type_flag", "外部单位");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("盈科")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("fyxje", 0d);
			temMap.put("zbxje", 0d);
			temMap.put("type_flag", "盈科");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("休斯顿研发中心")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("fyxje", 0d);
			temMap.put("zbxje", 0d);
			temMap.put("type_flag", "休斯顿研发中心");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("中东研发中心")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("fyxje", 0d);
			temMap.put("zbxje", 0d);
			temMap.put("type_flag", "中东研发中心");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("集团公司")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("fyxje", 0d);
			temMap.put("zbxje", 0d);
			temMap.put("type_flag", "集团公司");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("资产公司")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("fyxje", 0d);
			temMap.put("zbxje", 0d);
			temMap.put("type_flag", "资产公司");
			temList.add(temMap);
		}
		
		
		System.out.println("===="+JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "科研二级页面，8大院的各个新开、续建情况", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/project-info/unit")
	public JSONArray getProjectTypeCountByUnit(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getProjectTypeCountByUnit===========================" + map);
		
		List temList = outProjectService.getProjectTypeCountByUnit("2018");
		
		if (!JSON.toJSONString(temList).contains("勘探院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zsl", 0);
			temMap.put("define2", "勘探院");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("物探院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zsl", 0);
			temMap.put("define2", "物探院");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("工程院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zsl", 0);
			temMap.put("define2", "工程院");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("石科院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zsl", 0);
			temMap.put("define2", "石科院");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("大连院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zsl", 0);
			temMap.put("define2", "大连院");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("北化院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zsl", 0);
			temMap.put("define2", "北化院");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("上海院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zsl", 0);
			temMap.put("define2", "上海院");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("安工院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zsl", 0);
			temMap.put("define2", "安工院");
			temList.add(temMap);
		}
		System.out.println("===="+JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "科研二级页面，8大院的各个新开、续建情况--装备", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/project-info/zb/unit")
	public JSONArray getZBProjectTypeCountByUnit(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getZBProjectTypeCountByUnit===========================" + map);
		
		List temList = outProjectService.getZBProjectTypeCountByUnit("2018");
		
		if (!JSON.toJSONString(temList).contains("勘探院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zsl", 0);
			temMap.put("define2", "勘探院");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("物探院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zsl", 0);
			temMap.put("define2", "物探院");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("工程院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zsl", 0);
			temMap.put("define2", "工程院");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("石科院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zsl", 0);
			temMap.put("define2", "石科院");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("大连院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zsl", 0);
			temMap.put("define2", "大连院");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("北化院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zsl", 0);
			temMap.put("define2", "北化院");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("上海院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zsl", 0);
			temMap.put("define2", "上海院");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("安工院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zsl", 0);
			temMap.put("define2", "安工院");
			temList.add(temMap);
		}
		System.out.println("===="+JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	
	@ApiOperation(value = "直属研究院、分子公司等9个单位，各个新开、续建情况--树结构", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/project-count/unit/tree")
	public JSONArray getProjectTypeCountForTree(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getProjectTypeCountForTree===========================" + map);
		
		List temList = outProjectService.getProjectTypeCountForTree("2018");
		
		if (!JSON.toJSONString(temList).contains("结转课题")) {
			HashMap<String, Object> temMap1 = new HashMap<String, Object>();
			temMap1.put("zsl", 0);
			temMap1.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap1.put("type_flag", "直属研究院");
			temMap1.put("project_scope", "结转课题");
			temList.add(temMap1);
			
			HashMap<String, Object> temMap2 = new HashMap<String, Object>();
			temMap2.put("zsl", 0);
			temMap2.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap2.put("type_flag", "分子公司");
			temMap2.put("project_scope", "结转课题");
			temList.add(temMap2);
			
			HashMap<String, Object> temMap3 = new HashMap<String, Object>();
			temMap3.put("zsl", 0);
			temMap3.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap3.put("type_flag", "集团单位");
			temMap3.put("project_scope", "结转课题");
			temList.add(temMap3);
			
			
			HashMap<String, Object> temMap4 = new HashMap<String, Object>();
			temMap4.put("zsl", 0);
			temMap4.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap4.put("type_flag", "外部单位");
			temMap4.put("project_scope", "结转课题");
			temList.add(temMap4);
			
			HashMap<String, Object> temMap5 = new HashMap<String, Object>();
			temMap5.put("zsl", 0);
			temMap5.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap5.put("type_flag", "盈科");
			temMap5.put("project_scope", "结转课题");
			temList.add(temMap5);
			
			HashMap<String, Object> temMap6 = new HashMap<String, Object>();
			temMap6.put("zsl", 0);
			temMap6.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap6.put("type_flag", "休斯顿研发中心");
			temMap6.put("project_scope", "结转课题");
			temList.add(temMap6);
			
			HashMap<String, Object> temMap7 = new HashMap<String, Object>();
			temMap7.put("zsl", 0);
			temMap7.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap7.put("type_flag", "中东研发中心");
			temMap7.put("project_scope", "结转课题");
			temList.add(temMap7);
			
			HashMap<String, Object> temMap8 = new HashMap<String, Object>();
			temMap8.put("zsl", 0);
			temMap8.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap8.put("type_flag", "集团公司");
			temMap8.put("project_scope", "结转课题");
			temList.add(temMap8);
			
			HashMap<String, Object> temMap9 = new HashMap<String, Object>();
			temMap9.put("zsl", 0);
			temMap9.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap9.put("type_flag", "资产公司");
			temMap9.put("project_scope", "结转课题");
			temList.add(temMap9);
			
		}
		
		System.out.println("===="+JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "项目类型（国家项目、重点项目、重大项目、其他项目）的各个新开、续建情况--树结构", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/project-count/type/tree")
	public JSONArray getProjectCountByTypeForTree(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getProjectCountByTypeForTree===========================" + map);
		
		List temList = outProjectService.getProjectCountByTypeForTree("2018");
		
		if (!JSON.toJSONString(temList).contains("结转课题")) {
			HashMap<String, Object> temMap1 = new HashMap<String, Object>();
			temMap1.put("zsl", 0);
			temMap1.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap1.put("zycmc", "三剂处");
			temMap1.put("project_scope", "结转课题");
			temList.add(temMap1);
			
			HashMap<String, Object> temMap2 = new HashMap<String, Object>();
			temMap2.put("zsl", 0);
			temMap2.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap2.put("zycmc", "化工处");
			temMap2.put("project_scope", "结转课题");
			temList.add(temMap2);
			
			HashMap<String, Object> temMap3 = new HashMap<String, Object>();
			temMap3.put("zsl", 0);
			temMap3.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap3.put("zycmc", "技术监督处");
			temMap3.put("project_scope", "结转课题");
			temList.add(temMap3);
			
			
			HashMap<String, Object> temMap4 = new HashMap<String, Object>();
			temMap4.put("zsl", 0);
			temMap4.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap4.put("zycmc", "油田处");
			temMap4.put("project_scope", "结转课题");
			temList.add(temMap4);
			
			HashMap<String, Object> temMap5 = new HashMap<String, Object>();
			temMap5.put("zsl", 0);
			temMap5.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap5.put("zycmc", "炼油处");
			temMap5.put("project_scope", "结转课题");
			temList.add(temMap5);
			
			HashMap<String, Object> temMap6 = new HashMap<String, Object>();
			temMap6.put("zsl", 0);
			temMap6.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap6.put("zycmc", "知识产权处");
			temMap6.put("project_scope", "结转课题");
			temList.add(temMap6);
			
			HashMap<String, Object> temMap7 = new HashMap<String, Object>();
			temMap7.put("zsl", 0);
			temMap7.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap7.put("zycmc", "装备与储运处");
			temMap7.put("project_scope", "结转课题");
			temList.add(temMap7);
			
			
			HashMap<String, Object> temMap8 = new HashMap<String, Object>();
			temMap8.put("zsl", 0);
			temMap8.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap8.put("zycmc", "计划处");
			temMap8.put("project_scope", "结转课题");
			temList.add(temMap8);
			
		}
		
		System.out.println("===="+JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "8大院的各个新开、续建情况--装备树结构", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/project-count/zb/unit/tree")
	public JSONArray getZBProjectTypeCountForTree(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getZBProjectTypeCountForTree===========================" + map);
		
		List temList = outProjectService.getZBProjectTypeCountForTree("2018");
		
		/*if (!JSON.toJSONString(temList).contains("结转课题")) {
			HashMap<String, Object> temMap1 = new HashMap<String, Object>();
			temMap1.put("zsl", 0);
			temMap1.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap1.put("define2", "勘探院");
			temMap1.put("project_scope", "结转课题");
			temList.add(temMap1);
			
			HashMap<String, Object> temMap2 = new HashMap<String, Object>();
			temMap2.put("zsl", 0);
			temMap2.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap2.put("define2", "物探院");
			temMap2.put("project_scope", "结转课题");
			temList.add(temMap2);
			
			HashMap<String, Object> temMap3 = new HashMap<String, Object>();
			temMap3.put("zsl", 0);
			temMap3.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap3.put("define2", "工程院");
			temMap3.put("project_scope", "结转课题");
			temList.add(temMap3);
			
			
			HashMap<String, Object> temMap4 = new HashMap<String, Object>();
			temMap4.put("zsl", 0);
			temMap4.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap4.put("define2", "石科院");
			temMap4.put("project_scope", "结转课题");
			temList.add(temMap4);
			
			HashMap<String, Object> temMap5 = new HashMap<String, Object>();
			temMap5.put("zsl", 0);
			temMap5.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap5.put("define2", "大连院");
			temMap5.put("project_scope", "结转课题");
			temList.add(temMap5);
			
			HashMap<String, Object> temMap6 = new HashMap<String, Object>();
			temMap6.put("zsl", 0);
			temMap6.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap6.put("define2", "北化院");
			temMap6.put("project_scope", "结转课题");
			temList.add(temMap6);
			
			HashMap<String, Object> temMap7 = new HashMap<String, Object>();
			temMap7.put("zsl", 0);
			temMap7.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap7.put("define2", "上海院");
			temMap7.put("project_scope", "结转课题");
			temList.add(temMap7);
			
			HashMap<String, Object> temMap8 = new HashMap<String, Object>();
			temMap8.put("zsl", 0);
			temMap8.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap8.put("define2", "安工院");
			temMap8.put("project_scope", "结转课题");
			temList.add(temMap8);
			
		}*/
		
		System.out.println("===="+JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "项目类型（国家项目、重点项目、重大项目、其他项目）的各个新开、续建情况--装备树结构", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/project-count/zb/type/tree")
	public JSONArray getZBProjectCountByTypeForTree(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getZBProjectCountByTypeForTree===========================" + map);
		
		List temList = outProjectService.getZBProjectCountByTypeForTree("2018");
		
		if (!JSON.toJSONString(temList).contains("新开课题")) {
			HashMap<String, Object> temMap1 = new HashMap<String, Object>();
			temMap1.put("zsl", 0);
			temMap1.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap1.put("define2", "勘探院");
			temMap1.put("project_scope", "新开课题");
			temList.add(temMap1);
			
			HashMap<String, Object> temMap2 = new HashMap<String, Object>();
			temMap2.put("zsl", 0);
			temMap2.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap2.put("define2", "物探院");
			temMap2.put("project_scope", "新开课题");
			temList.add(temMap2);
			
			HashMap<String, Object> temMap3 = new HashMap<String, Object>();
			temMap3.put("zsl", 0);
			temMap3.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap3.put("define2", "工程院");
			temMap3.put("project_scope", "新开课题");
			temList.add(temMap3);
			
			
			HashMap<String, Object> temMap4 = new HashMap<String, Object>();
			temMap4.put("zsl", 0);
			temMap4.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap4.put("define2", "石科院");
			temMap4.put("project_scope", "新开课题");
			temList.add(temMap4);
			
			HashMap<String, Object> temMap5 = new HashMap<String, Object>();
			temMap5.put("zsl", 0);
			temMap5.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap5.put("define2", "大连院");
			temMap5.put("project_scope", "新开课题");
			temList.add(temMap5);
			
			HashMap<String, Object> temMap6 = new HashMap<String, Object>();
			temMap6.put("zsl", 0);
			temMap6.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap6.put("define2", "北化院");
			temMap6.put("project_scope", "新开课题");
			temList.add(temMap6);
			
			HashMap<String, Object> temMap7 = new HashMap<String, Object>();
			temMap7.put("zsl", 0);
			temMap7.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap7.put("define2", "上海院");
			temMap7.put("project_scope", "新开课题");
			temList.add(temMap7);
			
			HashMap<String, Object> temMap8 = new HashMap<String, Object>();
			temMap8.put("zsl", 0);
			temMap8.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap8.put("define2", "安工院");
			temMap8.put("project_scope", "新开课题");
			temList.add(temMap8);
		}
		
		if (!JSON.toJSONString(temList).contains("结转课题")) {
			HashMap<String, Object> temMap1 = new HashMap<String, Object>();
			temMap1.put("zsl", 0);
			temMap1.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap1.put("define2", "勘探院");
			temMap1.put("project_scope", "结转课题");
			temList.add(temMap1);
			
			HashMap<String, Object> temMap2 = new HashMap<String, Object>();
			temMap2.put("zsl", 0);
			temMap2.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap2.put("define2", "物探院");
			temMap2.put("project_scope", "结转课题");
			temList.add(temMap2);
			
			HashMap<String, Object> temMap3 = new HashMap<String, Object>();
			temMap3.put("zsl", 0);
			temMap3.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap3.put("define2", "工程院");
			temMap3.put("project_scope", "结转课题");
			temList.add(temMap3);
			
			
			HashMap<String, Object> temMap4 = new HashMap<String, Object>();
			temMap4.put("zsl", 0);
			temMap4.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap4.put("define2", "石科院");
			temMap4.put("project_scope", "结转课题");
			temList.add(temMap4);
			
			HashMap<String, Object> temMap5 = new HashMap<String, Object>();
			temMap5.put("zsl", 0);
			temMap5.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap5.put("define2", "大连院");
			temMap5.put("project_scope", "结转课题");
			temList.add(temMap5);
			
			HashMap<String, Object> temMap6 = new HashMap<String, Object>();
			temMap6.put("zsl", 0);
			temMap6.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap6.put("define2", "北化院");
			temMap6.put("project_scope", "结转课题");
			temList.add(temMap6);
			
			HashMap<String, Object> temMap7 = new HashMap<String, Object>();
			temMap7.put("zsl", 0);
			temMap7.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap7.put("define2", "上海院");
			temMap7.put("project_scope", "结转课题");
			temList.add(temMap7);
			
			HashMap<String, Object> temMap8 = new HashMap<String, Object>();
			temMap8.put("zsl", 0);
			temMap8.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap8.put("define2", "安工院");
			temMap8.put("project_scope", "结转课题");
			temList.add(temMap8);
			
		}
		
		System.out.println("===="+JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "领导页的各类型项目的数量", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/ld/project-type-count")
	public JSONArray getProjectTypeCountForLD(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getProjectTypeCountForLD===========================" + map);
		
		List temList = outProjectService.getProjectTypeCountForLD("2018");
		
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
		logger.info("==================page getProjectTypeCountForTree===========================" + map);
		
		List temList = outProjectService.getProjectTypeCountForTreeLD("2018");
		
		if (!JSON.toJSONString(temList).contains("结转课题")) {
			HashMap<String, Object> temMap1 = new HashMap<String, Object>();
			temMap1.put("zsl", 0);
			temMap1.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap1.put("type_flag", "直属研究院");
			temMap1.put("project_scope", "结转课题");
			temList.add(temMap1);
			
			HashMap<String, Object> temMap2 = new HashMap<String, Object>();
			temMap2.put("zsl", 0);
			temMap2.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap2.put("type_flag", "分子公司");
			temMap2.put("project_scope", "结转课题");
			temList.add(temMap2);
			
			HashMap<String, Object> temMap3 = new HashMap<String, Object>();
			temMap3.put("zsl", 0);
			temMap3.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap3.put("type_flag", "集团单位");
			temMap3.put("project_scope", "结转课题");
			temList.add(temMap3);
			
			
			HashMap<String, Object> temMap4 = new HashMap<String, Object>();
			temMap4.put("zsl", 0);
			temMap4.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap4.put("type_flag", "外部单位");
			temMap4.put("project_scope", "结转课题");
			temList.add(temMap4);
			
			HashMap<String, Object> temMap5 = new HashMap<String, Object>();
			temMap5.put("zsl", 0);
			temMap5.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap5.put("type_flag", "盈科");
			temMap5.put("project_scope", "结转课题");
			temList.add(temMap5);
			
			HashMap<String, Object> temMap6 = new HashMap<String, Object>();
			temMap6.put("zsl", 0);
			temMap6.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap6.put("type_flag", "休斯顿研发中心");
			temMap6.put("project_scope", "结转课题");
			temList.add(temMap6);
			
			HashMap<String, Object> temMap7 = new HashMap<String, Object>();
			temMap7.put("zsl", 0);
			temMap7.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap7.put("type_flag", "中东研发中心");
			temMap7.put("project_scope", "结转课题");
			temList.add(temMap7);
			
			HashMap<String, Object> temMap8 = new HashMap<String, Object>();
			temMap8.put("zsl", 0);
			temMap8.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap8.put("type_flag", "集团公司");
			temMap8.put("project_scope", "结转课题");
			temList.add(temMap8);
			
			HashMap<String, Object> temMap9 = new HashMap<String, Object>();
			temMap9.put("zsl", 0);
			temMap9.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
			temMap9.put("type_flag", "资产公司");
			temMap9.put("project_scope", "结转课题");
			temList.add(temMap9);
			
		}
		
		System.out.println("===="+JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "领导二级页面，直属研究院、分子公司等9个单位，各单位的新开、续建、完结情况", notes = "参数暂时是空")
	@RequestMapping(value = "/out-project-provider/ld/type/unit/list")
	public JSONArray getProjectTypeInfoByUnitLD(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getProjectTypeInfoByUnitLD===========================" + map);
		
		List temList = outProjectService.getProjectTypeInfoByUnitLD(null);
		
		if (!JSON.toJSONString(temList).contains("直属研究院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("type_flag", "直属研究院");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("分子公司")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("type_flag", "分子公司");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("集团单位")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("type_flag", "集团单位");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("外部单位")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("type_flag", "外部单位");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("盈科")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("type_flag", "盈科");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("休斯顿研发中心")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("type_flag", "休斯顿研发中心");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("中东研发中心")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("type_flag", "中东研发中心");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("集团公司")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("type_flag", "集团公司");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("资产公司")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("type_flag", "资产公司");
			temList.add(temMap);
		}
		System.out.println("===="+JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "领导二级页面，各个处室的新开、续建、完结情况", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/ld/project-count/project-type")
	public JSONArray getProjectCountByProjectTypeLD(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getProjectCountByProjectTypeLD===========================" + map);
		
		List temList = outProjectService.getProjectCountByProjectTypeLD("2018");
		
		if (!JSON.toJSONString(temList).contains("三剂处")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zycmc", "三剂处");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("供应协调处")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zycmc", "供应协调处");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("化工事业部")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zycmc", "化工事业部");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("化工处")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zycmc", "化工处");
			temList.add(temMap);
		}
		
		if (!JSON.toJSONString(temList).contains("技术监督处")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zycmc", "技术监督处");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("材料处")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zycmc", "材料处");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("油田处")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zycmc", "油田处");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("炼油事业部")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zycmc", "炼油事业部");
			temList.add(temMap);
		}
		
		if (!JSON.toJSONString(temList).contains("炼油处")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zycmc", "炼油处");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("知识产权处")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zycmc", "知识产权处");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("装备与储运处")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zycmc", "装备与储运处");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("计划处")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zycmc", "计划处");
			temList.add(temMap);
		}
		System.out.println("===="+JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "领导二级页面，8个院及国家级项目等性质的新开、续建、完结情况 ", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/ld/project-type-count/project_scope")
	public JSONArray getProjectTypeCountByTypeLD(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getProjectTypeCountByTypeLD===========================" + map);
		
		List temList = outProjectService.getProjectTypeCountByTypeLD("2018");
		
		if (!JSON.toJSONString(temList).contains("新开课题")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("gjxmsl", 0);
			temMap.put("zdzxxmsl", 0);
			temMap.put("zdxmsl", 0);
			temMap.put("qtsl", 0);
			temMap.put("stlxmsl", 0);
			temMap.put("zsl", 0);
			
			temMap.put("ktysl", 0);
			temMap.put("wtysl", 0);
			temMap.put("gcysl", 0);
			temMap.put("skysl", 0);
			temMap.put("dlysl", 0);
			temMap.put("bhysl", 0);
			temMap.put("shysl", 0);
			temMap.put("agysl", 0);
			temMap.put("project_scope", "新开课题");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("结转课题")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("gjxmsl", 0);
			temMap.put("zdzxxmsl", 0);
			temMap.put("zdxmsl", 0);
			temMap.put("qtsl", 0);
			temMap.put("stlxmsl", 0);
			temMap.put("zsl", 0);
			
			temMap.put("ktysl", 0);
			temMap.put("wtysl", 0);
			temMap.put("gcysl", 0);
			temMap.put("skysl", 0);
			temMap.put("dlysl", 0);
			temMap.put("bhysl", 0);
			temMap.put("shysl", 0);
			temMap.put("agysl", 0);
			
			temMap.put("project_scope", "结转课题");
			temList.add(temMap);
		}
		System.out.println("===="+JSON.toJSONString(temList));
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "领导二级页面，8个院新开、续建情况,每一行是一个院", notes = "参数年度")
	@RequestMapping(value = "/out-project-provider/ld/project-info/unit")
	public JSONArray getProjectTypeCountByUnitLD(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getProjectTypeCountByUnitLD===========================" + map);
		
		List temList = outProjectService.getProjectTypeCountByUnitLD("2018");
		
		if (!JSON.toJSONString(temList).contains("勘探院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zsl", 0);
			temMap.put("define2", "勘探院");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("物探院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zsl", 0);
			temMap.put("define2", "物探院");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("工程院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zsl", 0);
			temMap.put("define2", "工程院");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("石科院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zsl", 0);
			temMap.put("define2", "石科院");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("大连院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zsl", 0);
			temMap.put("define2", "大连院");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("北化院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zsl", 0);
			temMap.put("define2", "北化院");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("上海院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zsl", 0);
			temMap.put("define2", "上海院");
			temList.add(temMap);
		}
		if (!JSON.toJSONString(temList).contains("安工院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("xksl", 0);
			temMap.put("xjsl", 0);
			temMap.put("zsl", 0);
			temMap.put("define2", "安工院");
			temList.add(temMap);
		}
		System.out.println("===="+JSON.toJSONString(temList));
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
	
}
