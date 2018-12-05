package com.pcitc.web.out;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.HashMap;
import java.util.List;

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
import com.pcitc.base.stp.out.OutAppraisal;
import com.pcitc.service.out.OutAppraisalService;

@Api(value = "APPRAISAL-API", description = "成果数据，从项目管理系统中获取")
@RestController
public class OutAppraisalInfoClient {

	@Autowired
	private OutAppraisalService outAppraisalService;
	
	private final static Logger logger = LoggerFactory.getLogger(OutAppraisalInfoClient.class);

	@ApiOperation(value = "分页显示成果数据", notes = "分页显示成果数据")
	@RequestMapping(value = "/out-provider/appraisal-list", method = RequestMethod.POST)
	public LayuiTableData getOutAppraisalListPage(@RequestBody LayuiTableParam param) throws Exception {
		logger.info("==================page getOutAppraisalPage===========================" + param);
		return outAppraisalService.getOutAppraisalPage(param);
	}
	
	@ApiOperation(value = "成果总数", notes = "首页查询使用")
	@RequestMapping(value = "/out-provider/appraisal-count", method = RequestMethod.POST)
	public JSONObject getAppraisalCount(@RequestBody HashMap<String, String> map) {
		String nd = null;
		JSONObject retJson = new JSONObject();
		System.out.println("1jsonStr======" + map);
		if (map != null && map.get("nd") != null && !map.get("nd").equals("")) {
			nd = map.get("nd").toString();
		} else {
			retJson.put("appraisalCount", "0");
		}
		System.out.println("2jsonStr======" + nd);
		int count = outAppraisalService.getOutAppraisalCount(map);
		System.out.println("3jsonStr======" + count);
		retJson.put("appraisalCount", count);
		return retJson;
	}

	/**
	 * @author Nishikino
	 * 查询id
	 */
	@ApiOperation(value = "根据id查询详情", notes = "根据id查询详情")
	@RequestMapping(value = "/out-provider/get-appraisal-list/{dataId}", method = RequestMethod.POST)
	public OutAppraisal getOutAppraisalShow(@PathVariable(value = "dataId", required = true) String dataId) throws Exception{
		return outAppraisalService.getOutAppraisalShowById(dataId);
	}
	
	@ApiOperation(value = "成果鉴定数量分析", notes = "参数是年度")
	@RequestMapping(value = "/out-appraisal-provider/result-count", method = RequestMethod.POST)
	public JSONArray getAppraisalResultCount(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getAppraisalResultCount===========================" + map);
		
		String nd = map.get("nd");
		List temList = outAppraisalService.getResultInfo(nd);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "成果鉴定数量分析,按分类查询", notes = "参数是年度")
	@RequestMapping(value = "/out-appraisal-provider/type/result-count", method = RequestMethod.POST)
	public JSONArray getAppraisalResultCountByType(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getAppraisalResultCount===========================" + map);
		
		String nd = map.get("nd");
		List temList = outAppraisalService.getResultInfoByType(nd);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "成果鉴定数量分析,按分类查询", notes = "参数是年度")
	@RequestMapping(value = "/out-appraisal-provider/zy/result-count", method = RequestMethod.POST)
	public JSONArray getAppraisalResultCountByZy(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getAppraisalResultCount===========================" + map);
		
		String nd = map.get("nd");
		List temList = outAppraisalService.getResultInfoByZy(nd);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "成果鉴定数量分析,按单位查询", notes = "参数是年度")
	@RequestMapping(value = "/out-appraisal-provider/unit/result-count", method = RequestMethod.POST)
	public JSONArray getAppraisalResultCountByUnit(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getAppraisalResultCountByUnit===========================" + map);
		
		String nd = map.get("nd");
		List temList = outAppraisalService.getResultInfoBySix(nd);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "成果鉴定数量分析,按研究院查询", notes = "参数是年度")
	@RequestMapping(value = "/out-appraisal-provider/institution/result-count", method = RequestMethod.POST)
	public JSONArray getAppraisalResultCountByInstitution(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getAppraisalResultCountByUnit===========================" + map);
		
		String nd = map.get("nd");
		List temList = outAppraisalService.getResultInfoByEight(nd);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "成果鉴定数量分析,按研究院查询", notes = "参数是年度")
	@RequestMapping(value = "/out-appraisal-provider/institution/cg/info", method = RequestMethod.POST)
	public JSONArray getAppraisalInfoByInstitute(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getAppraisalInfoByInstitute===========================" + map);
		
		List temList = outAppraisalService.getAppraisalInfoByInstitute(map);
		if (!JSON.toJSONString(temList).contains("勘探院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("sl", 0);
			temMap.put("gyhsl", 0);
			temMap.put("gysysl", 0);
			temMap.put("define1", "勘探院");
			temList.add(0, temMap);
		}
		if (!JSON.toJSONString(temList).contains("物探院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("sl", 0);
			temMap.put("gyhsl", 0);
			temMap.put("gysysl", 0);
			temMap.put("define1", "物探院");
			temList.add(1, temMap);
		}
		if (!JSON.toJSONString(temList).contains("工程院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("sl", 0);
			temMap.put("gyhsl", 0);
			temMap.put("gysysl", 0);
			temMap.put("define1", "工程院");
			temList.add(2, temMap);
		}
		if (!JSON.toJSONString(temList).contains("石科院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("sl", 0);
			temMap.put("gyhsl", 0);
			temMap.put("gysysl", 0);
			temMap.put("define1", "石科院");
			temList.add(3, temMap);
		}
		if (!JSON.toJSONString(temList).contains("大连院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("sl", 0);
			temMap.put("gyhsl", 0);
			temMap.put("gysysl", 0);
			temMap.put("define1", "大连院");
			temList.add(4, temMap);
		}
		if (!JSON.toJSONString(temList).contains("北化院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("sl", 0);
			temMap.put("gyhsl", 0);
			temMap.put("gysysl", 0);
			temMap.put("define1", "北化院");
			temList.add(5, temMap);
		}
		if (!JSON.toJSONString(temList).contains("上海院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("sl", 0);
			temMap.put("gyhsl", 0);
			temMap.put("gysysl", 0);
			temMap.put("define1", "上海院");
			temList.add(6, temMap);
		}
		
		if (!JSON.toJSONString(temList).contains("安工院")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("sl", 0);
			temMap.put("gyhsl", 0);
			temMap.put("gysysl", 0);
			temMap.put("define1", "安工院");
			temList.add(7, temMap);
		}
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "领导二级页面，各种类型的成果情况", notes = "参数是年度")
	@RequestMapping(value = "/out-appraisal-provider/cglx/cg/info", method = RequestMethod.POST)
	public JSONArray getAppraisalInfoByCglx(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getAppraisalInfoByCglx===========================" + map);
		
		List temList = outAppraisalService.getAppraisalInfoByCglx(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		return json;
	}
	
	@ApiOperation(value = "领导二级页面，各种专业的成果情况", notes = "参数是年度")
	@RequestMapping(value = "/out-appraisal-provider/zy/cg/info", method = RequestMethod.POST)
	public JSONArray getAppraisalInfoByZy(@RequestBody HashMap<String, String> map) throws Exception {
		logger.info("==================page getAppraisalInfoByZy===========================" + map);
		
		List temList = outAppraisalService.getAppraisalInfoByZy(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(temList));
		
		if (!JSON.toJSONString(temList).contains("A.石油勘探")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("sl", 0);
			temMap.put("define1", "A.石油勘探");
			temList.add(0, temMap);
		}
		if (!JSON.toJSONString(temList).contains("B.石油开发")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("sl", 0);
			temMap.put("zy", "B.石油开发");
			temList.add(1, temMap);
		}
		if (!JSON.toJSONString(temList).contains("C.石油工程")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("sl", 0);
			temMap.put("zy", "C.石油工程");
			temList.add(2, temMap);
		}
		if (!JSON.toJSONString(temList).contains("D.石油炼制")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("sl", 0);
			temMap.put("zy", "D.石油炼制");
			temList.add(3, temMap);
		}
		if (!JSON.toJSONString(temList).contains("E.化工")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("sl", 0);
			temMap.put("zy", "E.化工");
			temList.add(4, temMap);
		}
		if (!JSON.toJSONString(temList).contains("F.化纤")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("sl", 0);
			temMap.put("zy", "F.化纤");
			temList.add(5, temMap);
		}
		if (!JSON.toJSONString(temList).contains("G.装备与储运")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("sl", 0);
			temMap.put("zy", "G.装备与储运");
			temList.add(6, temMap);
		}
		
		if (!JSON.toJSONString(temList).contains("H.安全与环保")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("sl", 0);
			temMap.put("zy", "H.安全与环保");
			temList.add(7, temMap);
		}
		if (!JSON.toJSONString(temList).contains("I.信息技术")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("sl", 0);
			temMap.put("zy", "I.信息技术");
			temList.add(8, temMap);
		}
		if (!JSON.toJSONString(temList).contains("J.大型装备国产化")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("sl", 0);
			temMap.put("zy", "J.大型装备国产化");
			temList.add(9, temMap);
		}
		if (!JSON.toJSONString(temList).contains("K.其它")) {
			HashMap<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("sl", 0);
			temMap.put("zy", "K.其它");
			temList.add(10, temMap);
		}
		return json;
	}
}
