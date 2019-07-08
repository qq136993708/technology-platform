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
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.service.out.OutPatentService;

@Api(value = "PATENT-API", description = "专利数据，从项目管理系统中获取")
@RestController
public class OutPatentProviderClient {

	@Autowired
	private OutPatentService outPatentService;
	
	private final static Logger logger = LoggerFactory.getLogger(OutPatentProviderClient.class);

	@ApiOperation(value = "分页显示专利数据", notes = "分页显示专利数据")
	@RequestMapping(value = "/out-patent-provider/patent-list", method = RequestMethod.POST)
	public LayuiTableData getOutPatentListPage(@RequestBody LayuiTableParam param) throws Exception {
		logger.info("==================page getOutPatentPage===========================" + param);
		return outPatentService.getOutPatentPage(param);
	}
	
	@ApiOperation(value = "专利总数查询", notes = "首页显示使用")
	@RequestMapping(value = "/out-patent-provider/patent-count", method = RequestMethod.POST)
	public JSONObject getPatentCount(@RequestBody HashMap<String, String> map) {
		String nd = null;
		JSONObject retJson = new JSONObject();
		System.out.println("1jsonStr======" + map);
		if (map != null && map.get("nd") != null && !map.get("nd").equals("")) {
			nd = map.get("nd").toString();
		} else {
			retJson.put("patentCount", "0");
		}
		System.out.println("2jsonStr======" + nd);
		int count = outPatentService.getOutPatentCount(map);
		System.out.println("3jsonStr======" + count);
		retJson.put("patentCount", count);
		return retJson;
	}
	
	@ApiOperation(value = "按专利类型分组，查询专利申请/授权数量", notes = "参数是年度")
	@RequestMapping(value = "/out-patent-provider/type/apply-agree-list", method = RequestMethod.POST)
	public JSONArray getApplyAgreeCountByPatentType(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getApplyAgreeCountByPatentType===========================" + map);
		
		String nd = map.get("nd");
		List temList = outPatentService.getWXLXInfo(nd);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "按科研院所分组，查询专利类型的数量情况", notes = "参数是年度")
	@RequestMapping(value = "/out-patent-provider/institute/type-list", method = RequestMethod.POST)
	public JSONArray getTypeCountByInstitute(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getTypeCountByInstitute===========================" + map);
		
		String nd = map.get("nd");
		List temList = outPatentService.getTypeInfoByUnit(nd);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "得到某个年度各专利类型在各个研究院、分公司、集团、外部单位、研发中心的分布", notes = "参数是年度")
	@RequestMapping(value = "/out-patent-provider/unit-type/apply-agree-list", method = RequestMethod.POST)
	public JSONArray getApplyAgreeCountByUnitType(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getApplyAgreeCountByUnitType===========================" + map);
		
		String nd = map.get("nd");
		List temList = outPatentService.getApplyAgreeCountBySix(nd);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}

	@ApiOperation(value = "按专利类型分组，查询专利申请/授权数量 详情", notes = "参数是年度、类型、申请、授权")
	@RequestMapping(value = "/out-patent-provider/agree-apply/details", method = RequestMethod.POST)
	public LayuiTableData getWXLXDetailsInfo(@RequestBody LayuiTableParam param) throws Exception {
		LayuiTableData tem = outPatentService.getWXLXDetailsInfo(param);
		return tem;
	}
	
	@ApiOperation(value = "按科研院所分组，查询专利类型的数量情况 详情", notes = "参数是年度、类型、哪个研究所")
	@RequestMapping(value = "/out-patent-provider/type/unit/details", method = RequestMethod.POST)
	public LayuiTableData getTypeInfoByUnitDetails(@RequestBody LayuiTableParam param) throws Exception {
		LayuiTableData tem = outPatentService.getTypeInfoByUnitDetails(param);
		return tem;
	}
	
	@ApiOperation(value = "领导二级页面，直属研究院，8个院专利申请、授权、发明专利数量", notes = "参数是年度、研究院等")
	@RequestMapping(value = "/out-patent-provider/ld/institute/type-count", method = RequestMethod.POST)
	public JSONArray getPatentTypeCountByInstituteForLD(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getPatentTypeCountByInstituteForLD===========================" + map);
		
		String nd = map.get("nd");
		List temList = outPatentService.getPatentTypeCountByInstituteForLD(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "领导二级页面，直属研究院，8个院发明专利、实用新型的申请和授权", notes = "参数是年度、研究院等")
	@RequestMapping(value = "/out-patent-provider/institute/lx/apply-agree", method = RequestMethod.POST)
	public JSONArray getPatentInfoByLXForInstitute(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getPatentInfoByLXForInstitute===========================" + map);
		
		List temList = outPatentService.getPatentInfoByLXForInstitute(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "领导二级页面，直属研究院，专利类型的申请、授权数量", notes = "参数是年度、研究院等")
	@RequestMapping(value = "/out-patent-provider/lx/apply-agree", method = RequestMethod.POST)
	public JSONArray getPatentInfoForLX(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getPatentInfoForLX===========================" + map);
		
		List temList = outPatentService.getPatentInfoForLX(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "按专利类型分组，查询专利申请/授权数量", notes = "参数是年度")
	@RequestMapping(value = "/out-patent-provider/company-type/apply-agree", method = RequestMethod.POST)
	public JSONArray getPatentInfoByCompanyType(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getPatentInfoByCompanyType===========================" + map);
		
		List temList = outPatentService.getPatentInfoByCompanyType(map);
		
		if (!JSON.toJSONString(temList).contains("直属研究院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("syxxApplyCount", 0);
			temMap.put("syxxAgreeCount", 0);
			temMap.put("fmzlApplyCount", 0);
			temMap.put("fmzlAgreeCount", 0);
			temMap.put("applyCount", 0);
			temMap.put("agreeCount", 0);
			temMap.put("define3", "直属研究院");
			temList.add(0, temMap);
		}
		if (!JSON.toJSONString(temList).contains("分子公司")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("syxxApplyCount", 0);
			temMap.put("syxxAgreeCount", 0);
			temMap.put("fmzlApplyCount", 0);
			temMap.put("fmzlAgreeCount", 0);
			temMap.put("applyCount", 0);
			temMap.put("agreeCount", 0);
			temMap.put("define3", "分子公司");
			temList.add(1, temMap);
		}
		/*if (!JSON.toJSONString(temList).contains("外部单位")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("syxxApplyCount", 0);
			temMap.put("syxxAgreeCount", 0);
			temMap.put("fmzlApplyCount", 0);
			temMap.put("fmzlAgreeCount", 0);
			temMap.put("applyCount", 0);
			temMap.put("agreeCount", 0);
			temMap.put("define3", "外部单位");
			temList.add(3, temMap);
		}*/
		
		if (!JSON.toJSONString(temList).contains("休斯顿研发中心")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("syxxApplyCount", 0);
			temMap.put("syxxAgreeCount", 0);
			temMap.put("fmzlApplyCount", 0);
			temMap.put("fmzlAgreeCount", 0);
			temMap.put("applyCount", 0);
			temMap.put("agreeCount", 0);
			temMap.put("define3", "休斯顿研发中心");
			temList.add(2, temMap);
		}
		if (!JSON.toJSONString(temList).contains("中东研发中心")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("syxxApplyCount", 0);
			temMap.put("syxxAgreeCount", 0);
			temMap.put("fmzlApplyCount", 0);
			temMap.put("fmzlAgreeCount", 0);
			temMap.put("applyCount", 0);
			temMap.put("agreeCount", 0);
			temMap.put("define3", "中东研发中心");
			temList.add(3, temMap);
		}
		if (!JSON.toJSONString(temList).contains("盈科")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("syxxApplyCount", 0);
			temMap.put("syxxAgreeCount", 0);
			temMap.put("fmzlApplyCount", 0);
			temMap.put("fmzlAgreeCount", 0);
			temMap.put("applyCount", 0);
			temMap.put("agreeCount", 0);
			temMap.put("define3", "盈科");
			temList.add(4, temMap);
		}
		if (!JSON.toJSONString(temList).contains("集团公司")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("syxxApplyCount", 0);
			temMap.put("syxxAgreeCount", 0);
			temMap.put("fmzlApplyCount", 0);
			temMap.put("fmzlAgreeCount", 0);
			temMap.put("applyCount", 0);
			temMap.put("agreeCount", 0);
			temMap.put("define3", "集团公司");
			temList.add(5, temMap);
		}
		if (!JSON.toJSONString(temList).contains("资产公司")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("syxxApplyCount", 0);
			temMap.put("syxxAgreeCount", 0);
			temMap.put("fmzlApplyCount", 0);
			temMap.put("fmzlAgreeCount", 0);
			temMap.put("applyCount", 0);
			temMap.put("agreeCount", 0);
			temMap.put("define3", "资产公司");
			temList.add(6, temMap);
		}
		
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
}
