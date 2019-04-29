package com.pcitc.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.pcitc.base.hana.report.ScientificFunds;
import com.pcitc.service.IScientificFundsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
@Api(value = "Decision-API",description = "科技经费相关的接口")
@RestController
public class ScientificFundsProvideClient {
	
	
	@Autowired
	private IScientificFundsService scientificFundsService;
	
	
	
	@ApiOperation(value = "课题直间接费用统计表", notes = "课题直间接费用统计表")
	@RequestMapping(value = "/hana/scientific_funds/ktzjjfytjb", method = RequestMethod.POST)
	public JSONArray getTotalCostProjectPay01Report(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception {
		
		System.out.println(" paramsJson=" + paramsJson);
		JSONObject jo = JSONObject.parseObject(paramsJson);
		String month = jo.getString("month");
		String companyCode = jo.getString("companyCode");

		Map map = new HashMap();
		map.put("month", month);
		map.put("companyCode", companyCode);
		List<ScientificFunds> list = scientificFundsService.getKtzjjfytjbData(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	
	
	
	
	
	
	@ApiOperation(value = "课题直间接费用统计表-详细", notes = "课题直间接费用统计表-详细")
	@RequestMapping(value = "/hana/scientific_funds/getKtzjjfytjbData_detail", method = RequestMethod.POST)
	public JSONArray getKtzjjfytjbData_detail(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception {
		
		System.out.println(" paramsJson=" + paramsJson);
		JSONObject jo = JSONObject.parseObject(paramsJson);
		String month = jo.getString("month");
		String companyCode = jo.getString("companyCode");
		
		
		String g0PROJCODE = jo.getString("g0PROJCODE");
		String g0PROJTXT = jo.getString("g0PROJTXT");
		

		Map map = new HashMap();
		map.put("month", month);
		map.put("companyCode", companyCode);
		map.put("g0PROJCODE", g0PROJCODE);
		map.put("g0PROJTXT", g0PROJTXT);
		List<ScientificFunds> list = scientificFundsService.getKtzjjfytjbData_detail(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	
	
	
	
	@ApiOperation(value = "人工成本支出统计表", notes = "人工成本支出统计表")
	@RequestMapping(value = "/hana/scientific_funds/rgcbzctjb", method = RequestMethod.POST)
	public JSONArray rgcbzctjb(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception {
		
		System.out.println(" paramsJson=" + paramsJson);
		JSONObject jo = JSONObject.parseObject(paramsJson);
		String month = jo.getString("month");
		String companyCode = jo.getString("companyCode");

		Map map = new HashMap();
		map.put("month", month);
		map.put("companyCode", companyCode);
		List<ScientificFunds> list = scientificFundsService.getRgcbzctjbData(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	

	@ApiOperation(value = "人工成本支出详细", notes = "人工成本支出详细")
	@RequestMapping(value = "/hana/scientific_funds/rgcbzctjb_detail", method = RequestMethod.POST)
	public JSONArray rgcbzctjb_detail(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception {
		
		System.out.println(" paramsJson=" + paramsJson);
		JSONObject jo = JSONObject.parseObject(paramsJson);
		String month = jo.getString("month");
		String companyCode = jo.getString("companyCode");

		String g0PROJCODE = jo.getString("g0PROJCODE");
		String g0PROJTXT = jo.getString("g0PROJTXT");
		

		Map map = new HashMap();
		map.put("month", month);
		map.put("companyCode", companyCode);
		map.put("g0PROJCODE", g0PROJCODE);
		map.put("g0PROJTXT", g0PROJTXT);
		List<ScientificFunds> list = scientificFundsService.getRgcbzctjbDataDetail(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	
	
	
	
	
	@ApiOperation(value = "原材料支出统计表", notes = "原材料支出统计表")
	@RequestMapping(value = "/hana/scientific_funds/yclzctjb", method = RequestMethod.POST)
	public JSONArray yclzctjb(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception {
		
		System.out.println(" paramsJson=" + paramsJson);
		JSONObject jo = JSONObject.parseObject(paramsJson);
		String month = jo.getString("month");
		String companyCode = jo.getString("companyCode");

		Map map = new HashMap();
		map.put("month", month);
		map.put("companyCode", companyCode);
		List<ScientificFunds> list = scientificFundsService.getYclzctjbData(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	
	
	
	
	@ApiOperation(value = "原材料支出统计表-详细", notes = "原材料支出统计表-详细")
	@RequestMapping(value = "/hana/scientific_funds/getYclzctjbData_Detail", method = RequestMethod.POST)
	public JSONArray getYclzctjbData_Detail(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception {
		
		System.out.println(" paramsJson=" + paramsJson);
		JSONObject jo = JSONObject.parseObject(paramsJson);
		String month = jo.getString("month");
		String companyCode = jo.getString("companyCode");
		String g0PROJCODE = jo.getString("g0PROJCODE");
		String g0PROJTXT = jo.getString("g0PROJTXT");
		

		Map map = new HashMap();
		map.put("month", month);
		map.put("companyCode", companyCode);
		map.put("g0PROJCODE", g0PROJCODE);
		map.put("g0PROJTXT", g0PROJTXT);
		List<ScientificFunds> list = scientificFundsService.getYclzctjbData_Detail(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	
	
	
	@ApiOperation(value = "能耗支出统计表", notes = "能耗支出统计表")
	@RequestMapping(value = "/hana/scientific_funds/nhzctjb", method = RequestMethod.POST)
	public JSONArray nhzctjb(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception {
		
		System.out.println(" paramsJson=" + paramsJson);
		JSONObject jo = JSONObject.parseObject(paramsJson);
		String month = jo.getString("month");
		String companyCode = jo.getString("companyCode");

		Map map = new HashMap();
		map.put("month", month);
		map.put("companyCode", companyCode);
		List<ScientificFunds> list = scientificFundsService.getNhzctjbData(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	@ApiOperation(value = "能耗支出统计表-详细", notes = "能耗支出统计表-详细")
	@RequestMapping(value = "/hana/scientific_funds/getNhzctjbData_detail", method = RequestMethod.POST)
	public JSONArray getNhzctjbData_detail(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception {
		
		System.out.println(" paramsJson=" + paramsJson);
		JSONObject jo = JSONObject.parseObject(paramsJson);
		String month = jo.getString("month");
		String companyCode = jo.getString("companyCode");

		String g0PROJCODE = jo.getString("g0PROJCODE");
		String g0PROJTXT = jo.getString("g0PROJTXT");
		

		Map map = new HashMap();
		map.put("month", month);
		map.put("companyCode", companyCode);
		map.put("g0PROJCODE", g0PROJCODE);
		map.put("g0PROJTXT", g0PROJTXT);
		List<ScientificFunds> list = scientificFundsService.getNhzctjbData_detail(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	
	
	
	
	@ApiOperation(value = "项目资金流向分析", notes = "项目资金流向分析")
	@RequestMapping(value = "/hana/scientific_funds/xmzjlxfx", method = RequestMethod.POST)
	public JSONArray getXmzjlxfxData(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception {
		
		System.out.println(" paramsJson=" + paramsJson);
		JSONObject jo = JSONObject.parseObject(paramsJson);
		String month = jo.getString("month");
		String companyCode = jo.getString("companyCode");

		Map map = new HashMap();
		map.put("month", month);
		map.put("companyCode", companyCode);
		List<ScientificFunds> list = scientificFundsService.getXmzjlxfxData(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	
	@ApiOperation(value = "项目资金流向分析-详细", notes = "项目资金流向分析-详细")
	@RequestMapping(value = "/hana/scientific_funds/getXmzjlxfxData_detail", method = RequestMethod.POST)
	public JSONArray getXmzjlxfxData_detail(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception {
		
		System.out.println(" paramsJson=" + paramsJson);
		JSONObject jo = JSONObject.parseObject(paramsJson);
		String month = jo.getString("month");
		String companyCode = jo.getString("companyCode");

		Map map = new HashMap();
		map.put("month", month);
		map.put("companyCode", companyCode);
		List<ScientificFunds> list = scientificFundsService.getXmzjlxfxData_detail(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	/*@ApiOperation(value = "项目资金流向分析", notes = "项目资金流向分析")
	@RequestMapping(value = "/hana/scientific_funds/xmzjlxfx", method = RequestMethod.POST)
	public LayuiTableData xmzjlxfx(@RequestBody LayuiTableParam param)throws Exception
	{
		return scientificFundsService.getXmzjlxfxData(param);
	}*/
	
	
}
