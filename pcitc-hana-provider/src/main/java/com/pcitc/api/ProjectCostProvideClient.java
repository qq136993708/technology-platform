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
import com.pcitc.base.hana.report.ProjectCost;
import com.pcitc.service.IProjectCostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "Decision-API",description = "项目成本分析相关的接口")
@RestController
@RequestMapping("/hana/projectCost") 
public class ProjectCostProvideClient 
{

	@Autowired
	private IProjectCostService scientificFundsService;
	
	@ApiOperation(value = "科研投资统计表", notes = "科研投资统计表")
	@RequestMapping(value = "/kytztjb", method = RequestMethod.POST)
	public JSONArray kytztjb(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception {
		
		System.out.println(" paramsJson=" + paramsJson);
		JSONObject jo = JSONObject.parseObject(paramsJson);
		String month = jo.getString("month");
		String companyCode = jo.getString("companyCode");

		Map map = new HashMap();
		map.put("month", month);
		map.put("companyCode", companyCode);
		List<ProjectCost> list = scientificFundsService.getKytztjbData(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	@ApiOperation(value = "科研投资统计表", notes = "科研投资统计表")
	@RequestMapping(value = "/kytztjb_detail", method = RequestMethod.POST)
	public LayuiTableData kytztjb_detail(@RequestBody LayuiTableParam param)throws Exception
	{
		return scientificFundsService.getKytztjbData_detail(param);
	}
	
	
	
	@ApiOperation(value = "科技经费统计表", notes = "科技经费统计表")
	@RequestMapping(value = "/kjjftjb", method = RequestMethod.POST)
	public JSONArray kjjftjb(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception {
		
		System.out.println(" paramsJson=" + paramsJson);
		JSONObject jo = JSONObject.parseObject(paramsJson);
		String month = jo.getString("month");
		String companyCode = jo.getString("companyCode");

		Map map = new HashMap();
		map.put("month", month);
		map.put("companyCode", companyCode);
		List<ProjectCost> list = scientificFundsService.getKjjftjbData(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	
	@ApiOperation(value = "科技经费统计表", notes = "科技经费统计表")
	@RequestMapping(value = "/kjjftjb_detail", method = RequestMethod.POST)
	public LayuiTableData kjjftjb_detail(@RequestBody LayuiTableParam param)throws Exception
	{
		return scientificFundsService.getKjjftjbData_detail(param);
	}
	
	

	@ApiOperation(value = "横向课题全成本统计表", notes = "横向课题全成本统计表")
	@RequestMapping(value = "/hxktqcbtjb", method = RequestMethod.POST)
	public JSONArray hxktqcbtjb(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception {
		
		System.out.println(" paramsJson=" + paramsJson);
		JSONObject jo = JSONObject.parseObject(paramsJson);
		String month = jo.getString("month");
		String companyCode = jo.getString("companyCode");
		Map map = new HashMap();
		map.put("month", month);
		map.put("companyCode", companyCode);
		List<ProjectCost> list = scientificFundsService.getHxktqcbtjbData(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	
	
	@ApiOperation(value = "横向课题全成本统计表", notes = "横向课题全成本统计表")
	@RequestMapping(value = "/hxktqcbtjb_detail", method = RequestMethod.POST)
	public LayuiTableData hxktqcbtjb_detail(@RequestBody LayuiTableParam param)throws Exception
	{
		return scientificFundsService.getHxktqcbtjbData_detail(param);
	}
	
	
}
