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
}
