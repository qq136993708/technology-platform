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
import com.pcitc.base.hana.report.BrandConstructionPay;
import com.pcitc.base.hana.report.DayCashFlow;
import com.pcitc.base.hana.report.InvisibleCapitalDevelop;
import com.pcitc.base.hana.report.ScientificBaseBuildFee01;
import com.pcitc.base.hana.report.ScientificBaseBuildFee02;
import com.pcitc.base.hana.report.ScientificBaseBuildFee03;
import com.pcitc.base.hana.report.ScientificInstrumentPay;
import com.pcitc.base.hana.report.TopicDevelop;
import com.pcitc.base.hana.report.TotalCostProjectPay01;
import com.pcitc.base.hana.report.TotalCostProjectPay02;
import com.pcitc.base.hana.report.TotalCostProjectPay03;
import com.pcitc.service.ICommonService;
import com.pcitc.service.IDecisionFinancialService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "Decision-API",description = "经费决策中心相关的接口")
@RestController
@RequestMapping("/hana/decision/financial")  
public class DecisionFinancailProviderClient {

	
	@Autowired
	private IDecisionFinancialService decisionFinancialService;
	
	@Autowired
	private ICommonService commonService;

	
	/**===============================全成本项目支出综合分析 begin==============================*/

	/**
	 * 报表名称: 全成本项目支出综合分析_资金结余对比
	 * 报表编码: H1AS_KY_CB_1001_01
	 */
	@ApiOperation(value = "全成本项目支出综合分析_资金结余对比", notes = "全成本项目支出综合分析_资金结余对比 ")
	@RequestMapping(value = "/total_cost_project_pay/01", method = RequestMethod.POST)
	public JSONArray getTotalCostProjectPay01Report(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception {
		
		System.out.println(" paramsJson=" + paramsJson);
		JSONObject jo = JSONObject.parseObject(paramsJson);
		String month = jo.getString("month");
		String companyCode = jo.getString("companyCode");

		Map map = new HashMap();
		map.put("month", month);
		map.put("companyCode", companyCode);
		List<TotalCostProjectPay01> list = decisionFinancialService.getTotalCostProjectPay01Report(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}

	
	@ApiOperation(value = "项目类型、来源、级别使用率分析", notes = "项目类型、来源、级别使用率分析")
	@RequestMapping(value = "/total_cost_project_pay/type_01", method = RequestMethod.POST)
	public JSONArray getTotalCostProjectPay01TypeReport(@ApiParam(value="月份:month如201812,公司代码:companyCode",required=true)@RequestBody String paramsJson) throws Exception {
		
		System.out.println(" paramsJson=" + paramsJson);
		JSONObject jo = JSONObject.parseObject(paramsJson);
		String month = jo.getString("month");
		String companyCode = jo.getString("companyCode");
		String type = jo.getString("type");//1项目类型,2来源 ,3级别
		
		Map map = new HashMap();
		map.put("month", month);
		map.put("companyCode", companyCode);
		List<TotalCostProjectPay01> list =null;
		if(type.equals("G0XMGLLX"))
		{
			list=decisionFinancialService.getTotalCostProjectPay01ReportBy_G0XMGLLX(map);
		}else if(type.equals("G0XMGLLY"))
		{
			list=decisionFinancialService.getTotalCostProjectPay01ReportBy_G0XMGLLY(map);
		}else if(type.equals("G0XMGLJB"))
		{
			list=decisionFinancialService.getTotalCostProjectPay01ReportBy_G0XMGLJB(map);
		}
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	
	
	
	
	
	@ApiOperation(value = "费用细分类型同比分析、研究院实际支出占比分析", notes = "费用细分类型同比分析、研究院实际支出占比分析")
	@RequestMapping(value = "/total_cost_project_pay/02", method = RequestMethod.POST)
	public JSONArray getTotalCostProjectPay02TypeReport(@ApiParam(value="月份:month如201812,公司代码:companyCode,type:1、2、3",required=true)@RequestBody String paramsJson) throws Exception {
		
		System.out.println(" paramsJson=" + paramsJson);
		JSONObject jo = JSONObject.parseObject(paramsJson);
		String month = jo.getString("month");
		String companyCode = jo.getString("companyCode");
		String type = jo.getString("type");
		
		Map map = new HashMap();
		map.put("month", month);
		map.put("companyCode", companyCode);
		List<TotalCostProjectPay02> list =null;
		if(type.equals("1"))//费用细分类型使用率分析
		{
			list=decisionFinancialService.getTotalCostProjectPay02ReportBy_G0FYFL(map);
		}else if(type.equals("2"))//费用细分类型占比分析
		{
			list=decisionFinancialService.getTotalCostProjectPay02ReportBy_G0FYFL_02(map);
		}else if(type.equals("3"))//研究院实际支出占比分析
		{
			list=decisionFinancialService.getTotalCostProjectPay02ReportBy_G0GSJC(map);
		}
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}


	
	@ApiOperation(value = "研究院人均实际支出分析", notes = "研究院人均实际支出分析")
	@RequestMapping(value = "/total_cost_project_pay/03", method = RequestMethod.POST)
	public JSONArray getTotalCostProjectPay03TypeReport(@ApiParam(value="月份:month如201812",required=true)@RequestBody String paramsJson) throws Exception {
		
		System.out.println(" paramsJson=" + paramsJson);
		JSONObject jo = JSONObject.parseObject(paramsJson);
		String month = jo.getString("month");
		Map map = new HashMap();
		map.put("month", month);
		List<TotalCostProjectPay03> list =decisionFinancialService.getTotalCostProjectPay03Report(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	

	/**===============================全成本项目支出综合分析 end==============================*/
	
	
	
	
	
	
	/**===============================科研基建投资支出分析 ==============================*/
	
	
	
	@ApiOperation(value = "科研基建投资支出分析->科研基建支出年度趋势分析", notes = "科研基建投资支出分析->科研基建支出年度趋势分析")
	@RequestMapping(value = "/base_build_01", method = RequestMethod.POST)
	public JSONArray getScientificBaseBuildFee01Report(@ApiParam(value="月份:month如201812 companyCode",required=true)@RequestBody String paramsJson) throws Exception {
		
		System.out.println(" paramsJson=" + paramsJson);
		JSONObject jo = JSONObject.parseObject(paramsJson);
		String month = jo.getString("month");
		String companyCode = jo.getString("companyCode");
		
		Map map = new HashMap();
		map.put("month", month);
		map.put("companyCode", companyCode);
		
		List<ScientificBaseBuildFee01> list =decisionFinancialService.getScientificBaseBuildFee01Report(map) ;
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	
	
	@ApiOperation(value = "科研基建投资支出分析->同比--占比分析", notes = "科研基建投资支出分析->同比--占比分析")
	@RequestMapping(value = "/base_build_02", method = RequestMethod.POST)
	public JSONArray getScientificBaseBuildFee02Report(@ApiParam(value="月份:month如201812 companyCode",required=true)@RequestBody String paramsJson) throws Exception {
		
		System.out.println(" paramsJson=" + paramsJson);
		JSONObject jo = JSONObject.parseObject(paramsJson);
		String month = jo.getString("month");
		String companyCode = jo.getString("companyCode");
		
		Map map = new HashMap();
		map.put("month", month);
		map.put("companyCode", companyCode);
		
		
		String foreachIn = jo.getString("foreachIn");
		StringBuffer sqlStr=new StringBuffer();
		if(foreachIn!=null && !foreachIn.equals(""))
		{
			String arr[]=foreachIn.split(",");
			sqlStr.append("(");
			for(int i=0;i<arr.length;i++)
			{
				if(i>0)
				{
					sqlStr.append(",");
				}
				sqlStr.append("'").append(arr[i]).append("'");
			}
			sqlStr.append(")");
			
		}
		map.put("g0ZCMS", sqlStr.toString());
		
		List<ScientificBaseBuildFee02> list =decisionFinancialService.getScientificBaseBuildFee02Report(map) ;
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	@ApiOperation(value = "科研基建投资支出分析->研究院基建人均面积|基建面积 分析", notes = "科研基建投资支出分析->研究院基建人均面积|基建面积 分析")
	@RequestMapping(value = "/base_build_03", method = RequestMethod.POST)
	public JSONArray getScientificBaseBuildFee03Report(@ApiParam(value="月份:month如201812 companyCode",required=true)@RequestBody String paramsJson) throws Exception {
		
		System.out.println(" paramsJson=" + paramsJson);
		JSONObject jo = JSONObject.parseObject(paramsJson);
		String month = jo.getString("month");
		String companyCode = jo.getString("companyCode");
		
		Map map = new HashMap();
		map.put("month", month);
		map.put("companyCode", companyCode);
		
		
		
		
		List<ScientificBaseBuildFee03> list =decisionFinancialService.getScientificBaseBuildFee03Report(map) ;
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	
	
	@ApiOperation(value = "科研基建支出情况明细表", notes = "科研基建支出情况明细表")
	@RequestMapping(value = "/base_build_04", method = RequestMethod.POST)
	public LayuiTableData getScientificBaseBuildFee04Page(@RequestBody LayuiTableParam param)throws Exception
	{
		return decisionFinancialService.getScientificBaseBuildFee04Page(param);
	}
	
	
	
	

	@ApiOperation(value = "导出-科研基建支出情况明细表", notes = "导出-科研基建支出情况明细表")
	@RequestMapping(value = "/base_build_04_excel", method = RequestMethod.POST)
	public JSONArray base_build_04_excel(@RequestBody Map map )throws Exception
	{
		
		System.out.println("导出-科研基建支出情况明细表 paramsJson=" + JSONObject.toJSONString(map));
		
		List list= decisionFinancialService.getScientificBaseBuildFee04List(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	/**===============================科研基建投资支出分析 end==============================*/
	
	
	
	/**===============================科研仪器设备支出分析==============================*/
	
	@ApiOperation(value = "科研仪器设备支出分析明细表", notes = "科研仪器设备支出分析明细表")
	@RequestMapping(value = "/scientific_device_pay_detail", method = RequestMethod.POST)
	public LayuiTableData getScientificInstrumentPayDetailPage(@RequestBody LayuiTableParam param)throws Exception
	{
		return decisionFinancialService.getScientificInstrumentPayDetailPage(param);
	}
	
	

	@ApiOperation(value = "导出-科研仪器设备支出分析明细表", notes = "导出-科研仪器设备支出分析明细表")
	@RequestMapping(value = "/scientific_device_pay_detail_excel", method = RequestMethod.POST)
	public JSONArray ScientificInstrumentPayDetailexcel(@RequestBody Map map )throws Exception
	{
		
		System.out.println("导出-科研基建支出情况明细表 paramsJson=" + JSONObject.toJSONString(map));
		
		List list= decisionFinancialService.getScientificInstrumentPayDetailList(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	
	
	
	
	@ApiOperation(value = "科研仪器设备支出分析-5年支出趋势", notes = "科研仪器设备支出分析-5年支出趋势")
	@RequestMapping(value = "/scientific_device_pay_trand", method = RequestMethod.POST)
	public JSONArray getScientificInstrumentPayReport(@ApiParam(value="月份:month如201812 companyCode",required=true)@RequestBody String paramsJson) throws Exception {
		
		System.out.println(" paramsJson=" + paramsJson);
		JSONObject jo = JSONObject.parseObject(paramsJson);
		String month = jo.getString("month");
		String companyCode = jo.getString("companyCode");
		
		Map map = new HashMap();
		map.put("month", month);
		map.put("companyCode", companyCode);
		
		List<ScientificInstrumentPay> list =decisionFinancialService.getScientificInstrumentPayReport(map) ;
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	
	
	
	
	
	
	@ApiOperation(value = "科研仪器设备支出分析-同比占比分析--按资产类别", notes = "科研仪器设备支出分析-同比占比分析--按资产类别")
	@RequestMapping(value = "/scientific_device_pay_by_type", method = RequestMethod.POST)
	public JSONArray getScientificInstrumentPayByG0ZCMSReport(@ApiParam(value="月份:month如201812 companyCode",required=true)@RequestBody String paramsJson) throws Exception {
		
		System.out.println(" paramsJson=" + paramsJson);
		JSONObject jo = JSONObject.parseObject(paramsJson);
		String month = jo.getString("month");
		String companyCode = jo.getString("companyCode");
		
		Map map = new HashMap();
		map.put("month", month);
		map.put("companyCode", companyCode);
		
		List<ScientificInstrumentPay> list =decisionFinancialService.getScientificInstrumentPayByG0ZCMSReport(map) ;
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}

	@ApiOperation(value = "科研仪器设备支出分析-同比占比分析--按研究院", notes = "科研仪器设备支出分析-同比占比分析--按研究院")
	@RequestMapping(value = "/scientific_device_pay_by_department", method = RequestMethod.POST)
	public JSONArray getScientificInstrumentPayByG0GSJCReport(@ApiParam(value="月份:month如201812 companyCode",required=true)@RequestBody String paramsJson) throws Exception {
		
		System.out.println(" paramsJson=" + paramsJson);
		JSONObject jo = JSONObject.parseObject(paramsJson);
		String month = jo.getString("month");
		String companyCode = jo.getString("companyCode");
		String foreachIn = jo.getString("foreachIn");
		
	
		Map map = new HashMap();
		map.put("month", month);
		map.put("companyCode", companyCode);
		StringBuffer sqlStr=new StringBuffer();
		if(foreachIn!=null && !foreachIn.equals(""))
		{
			String arr[]=foreachIn.split(",");
			sqlStr.append("(");
			for(int i=0;i<arr.length;i++)
			{
				if(i>0)
				{
					sqlStr.append(",");
				}
				sqlStr.append("'").append(arr[i]).append("'");
			}
			sqlStr.append(")");
			
		}
		map.put("g0ZCMS", sqlStr.toString());
		List<ScientificInstrumentPay> result =decisionFinancialService.getScientificInstrumentPayByG0GSJCReport(map) ;
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(result));
		return json;
	}
	
	
	/**===============================科研仪器设备支出分析end==============================*/
	
	
	
	
	
	
	
	

	/**===============================无形资产的开发支出----分析  ========== ======== ===== =======*/
	
	@ApiOperation(value = "无形资产支出分析明细表", notes = "无形资产支出分析明细表")
	@RequestMapping(value = "/scientific_invisible_capital_detail", method = RequestMethod.POST)
	public LayuiTableData scientific_invisible_capital_detail(@RequestBody LayuiTableParam param)throws Exception
	{
		return decisionFinancialService.getInvisibleCapitalDevelopDetailPage(param);
	}
	

	@ApiOperation(value = "导出-无形资产支出分析明细表", notes = "导出-无形资产支出分析明细表")
	@RequestMapping(value = "/scientific_invisible_capital_detail_excel", method = RequestMethod.POST)
	public JSONArray scientific_invisible_capital_detail_excel(@RequestBody Map map )throws Exception
	{
		
		System.out.println("导出-科研基建支出情况明细表 paramsJson=" + JSONObject.toJSONString(map));
		
		List list= decisionFinancialService.getInvisibleCapitalDevelopPayDetailList(map) ;
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	
	
	@ApiOperation(value = "无形资产支出分析-5年支出趋势", notes = "无形资产支出分析-5年支出趋势")
	@RequestMapping(value = "/scientific_invisible_capital_trand", method = RequestMethod.POST)
	public JSONArray scientific_invisible_capital_trand(@ApiParam(value="月份:month如201812 companyCode",required=true)@RequestBody String paramsJson) throws Exception {
		
		System.out.println(" paramsJson=" + paramsJson);
		JSONObject jo = JSONObject.parseObject(paramsJson);
		String month = jo.getString("month");
		String companyCode = jo.getString("companyCode");
		
		Map map = new HashMap();
		map.put("month", month);
		map.put("companyCode", companyCode);
		
		List<InvisibleCapitalDevelop> list =decisionFinancialService.getInvisibleCapitalDevelopReport(map) ;
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	
	@ApiOperation(value = "无形资产支出分析-同比占比分析--按资产类别", notes = "无形资产支出分析-同比占比分析--按资产类别")
	@RequestMapping(value = "/scientific_invisible_capital_type", method = RequestMethod.POST)
	public JSONArray scientific_invisible_capital_type(@ApiParam(value="月份:month如201812 companyCode",required=true)@RequestBody String paramsJson) throws Exception {
		
		System.out.println(" paramsJson=" + paramsJson);
		JSONObject jo = JSONObject.parseObject(paramsJson);
		String month = jo.getString("month");
		String companyCode = jo.getString("companyCode");
		
		Map map = new HashMap();
		map.put("month", month);
		map.put("companyCode", companyCode);
		
		List<InvisibleCapitalDevelop> list =decisionFinancialService.getInvisibleCapitalDevelopByG0ZCMSReport(map)  ;
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}

	@ApiOperation(value = "无形资产支出分析-同比占比分析--按研究院", notes = "无形资产支出分析-同比占比分析--按研究院")
	@RequestMapping(value = "/scientific_invisible_capital_department", method = RequestMethod.POST)
	public JSONArray scientific_invisible_capital_department(@ApiParam(value="月份:month如201812 companyCode",required=true)@RequestBody String paramsJson) throws Exception {
		
		System.out.println(" paramsJson=" + paramsJson);
		JSONObject jo = JSONObject.parseObject(paramsJson);
		String month = jo.getString("month");
		String companyCode = jo.getString("companyCode");
		String foreachIn = jo.getString("foreachIn");
		
	
		Map map = new HashMap();
		map.put("month", month);
		map.put("companyCode", companyCode);
		StringBuffer sqlStr=new StringBuffer();
		if(foreachIn!=null && !foreachIn.equals(""))
		{
			String arr[]=foreachIn.split(",");
			sqlStr.append("(");
			for(int i=0;i<arr.length;i++)
			{
				if(i>0)
				{
					sqlStr.append(",");
				}
				sqlStr.append("'").append(arr[i]).append("'");
			}
			sqlStr.append(")");
			
		}
		map.put("g0ZCMS", sqlStr.toString());
		List<InvisibleCapitalDevelop> result =decisionFinancialService.getInvisibleCapitalDevelopByG0GSJCReport(map) ;
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(result));
		return json;
	}
	
	
	/**===============================无形资产的开发支出分析----end==============================*/
	
	
	
	
	
	
	

	/**===============================品牌建设支出分析分析  ========== ======== ===== =======*/
	
	@ApiOperation(value = "品牌建设支出分析明细表", notes = "品牌建设支出分析明细表")
	@RequestMapping(value = "/scientific_brand_pay_detail", method = RequestMethod.POST)
	public LayuiTableData scientific_brand_construction_detail(@RequestBody LayuiTableParam param)throws Exception
	{
		return decisionFinancialService.getBrandConstructionPayDetailPage(param) ;
	}
	

	@ApiOperation(value = "导出-品牌建设支出分析明细表", notes = "导出-品牌建设支出分析明细表")
	@RequestMapping(value = "/scientific_brand_pay_detail_excel", method = RequestMethod.POST)
	public JSONArray scientific_brand_construction_detail_excel(@RequestBody Map map )throws Exception
	{
		
		System.out.println("导出-科研基建支出情况明细表 paramsJson=" + JSONObject.toJSONString(map));
		
		List list= decisionFinancialService.getBrandConstructionPayDetailList(map) ;
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	
	
	@ApiOperation(value = "品牌建设支出分析-5年支出趋势", notes = "品牌建设支出分析-5年支出趋势")
	@RequestMapping(value = "/scientific_brand_pay_trand", method = RequestMethod.POST)
	public JSONArray scientific_brand_construction_trand(@ApiParam(value="月份:month如201812 companyCode",required=true)@RequestBody String paramsJson) throws Exception {
		
		System.out.println(" paramsJson=" + paramsJson);
		JSONObject jo = JSONObject.parseObject(paramsJson);
		String month = jo.getString("month");
		String companyCode = jo.getString("companyCode");
		
		Map map = new HashMap();
		map.put("month", month);
		map.put("companyCode", companyCode);
		
		List<BrandConstructionPay> list =decisionFinancialService.getBrandConstructionPayReport(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	
	@ApiOperation(value = "品牌建设支出分析-同比占比分析--按资产类别", notes = "品牌建设支出分析-同比占比分析--按资产类别")
	@RequestMapping(value = "/scientific_brand_pay_by_type", method = RequestMethod.POST)
	public JSONArray scientific_brand_construction_type(@ApiParam(value="月份:month如201812 companyCode",required=true)@RequestBody String paramsJson) throws Exception {
		
		System.out.println(" paramsJson=" + paramsJson);
		JSONObject jo = JSONObject.parseObject(paramsJson);
		String month = jo.getString("month");
		String companyCode = jo.getString("companyCode");
		
		Map map = new HashMap();
		map.put("month", month);
		map.put("companyCode", companyCode);
		
		List<BrandConstructionPay> list =decisionFinancialService.getBrandConstructionPayByG0ZCMSReport(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}

	@ApiOperation(value = "品牌建设支出分析-同比占比分析--按研究院", notes = "品牌建设支出分析-同比占比分析--按研究院")
	@RequestMapping(value = "/scientific_brand_pay_by_department", method = RequestMethod.POST)
	public JSONArray scientific_brand_construction_department(@ApiParam(value="月份:month如201812 companyCode",required=true)@RequestBody String paramsJson) throws Exception {
		
		System.out.println(" paramsJson=" + paramsJson);
		JSONObject jo = JSONObject.parseObject(paramsJson);
		String month = jo.getString("month");
		String companyCode = jo.getString("companyCode");
		String foreachIn = jo.getString("foreachIn");
		
	
		Map map = new HashMap();
		map.put("month", month);
		map.put("companyCode", companyCode);
		StringBuffer sqlStr=new StringBuffer();
		if(foreachIn!=null && !foreachIn.equals(""))
		{
			String arr[]=foreachIn.split(",");
			sqlStr.append("(");
			for(int i=0;i<arr.length;i++)
			{
				if(i>0)
				{
					sqlStr.append(",");
				}
				sqlStr.append("'").append(arr[i]).append("'");
			}
			sqlStr.append(")");
			
		}
		map.put("g0ZCMS", sqlStr.toString());
		List<BrandConstructionPay> result =decisionFinancialService.getBrandConstructionPayByG0GSJCReport(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(result));
		return json;
	}
	
	
	/**===============================品牌建设支出分析分析----end==============================*/
	
	
	
	
	  /**===================================课题研发支出分析==================================*/
	
	@ApiOperation(value = "课题研发 气泡", notes = "课题研发 气泡")
	@RequestMapping(value = "/scientific_topic_develop_pot", method = RequestMethod.POST)
	public JSONArray getTopicDevelopPotList(@ApiParam(value="月份:month如201812 companyCode",required=true)@RequestBody String paramsJson) throws Exception {
		
		System.out.println(" paramsJson=" + paramsJson);
		JSONObject jo = JSONObject.parseObject(paramsJson);
		String month = jo.getString("month");
		String companyCode = jo.getString("companyCode");
		Map map = new HashMap();
		map.put("month", month);
		map.put("companyCode", companyCode);
		
		String foreachIn = jo.getString("foreachIn");
		StringBuffer sqlStr=new StringBuffer();
		if(foreachIn!=null && !foreachIn.equals(""))
		{
			String arr[]=foreachIn.split(",");
			sqlStr.append("(");
			for(int i=0;i<arr.length;i++)
			{
				if(i>0)
				{
					sqlStr.append(",");
				}
				sqlStr.append("'").append(arr[i]).append("'");
			}
			sqlStr.append(")");
			
		}
		map.put("g0XMGLLX", sqlStr.toString());
		
		List<TopicDevelop> result =decisionFinancialService.getTopicDevelopPotList(map) ;
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(result));
		return json;
	}
	
	
	@ApiOperation(value = "课题研发 详情", notes = "课题研发 详情")
	@RequestMapping(value = "/scientific_topic_develop_detail_by_code", method = RequestMethod.POST)
	public LayuiTableData getTopicDevelopPotById(@RequestBody LayuiTableParam param)throws Exception
	{
		return decisionFinancialService.getTopicDevelopPotByIdPage(param) ;
	}
	
	@ApiOperation(value = "课题研发 详情", notes = "课题研发 详情")
	@RequestMapping(value = "/scientific_topic_develop_detail_pie", method = RequestMethod.POST)
	public JSONArray scientific_topic_develop_detail_pie(@ApiParam(value="月份:month如201812 g0PROJCODE",required=true)@RequestBody String paramsJson) throws Exception {
		
		System.out.println(" paramsJson=" + paramsJson);
		JSONObject jo = JSONObject.parseObject(paramsJson);
		String month = jo.getString("month");
		String g0PROJCODE = jo.getString("g0PROJCODE");
		
		Map map = new HashMap();
		map.put("month", month);
		map.put("g0PROJCODE", g0PROJCODE);
		
		List<TopicDevelop> list =decisionFinancialService.getTopicDevelopPotById(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	  
	  /**===================================课题研发支出分析 end==================================*/
	  
	
	
	
	
	@ApiOperation(value = "日现金流", notes = "日现金流")
	@RequestMapping(value = "/getDayCashFlowReport", method = RequestMethod.POST)
	public JSONArray getDayCashFlowReport(@ApiParam(value="月份:month如201812 g0PROJCODE",required=true)@RequestBody String paramsJson) throws Exception {
		
		System.out.println(" paramsJson=" + paramsJson);
		JSONObject jo = JSONObject.parseObject(paramsJson);
		String month = jo.getString("month");
		String companyCode = jo.getString("companyCode");
		Map map = new HashMap();
		map.put("month", month);
		map.put("companyCode", companyCode);
		
		List<DayCashFlow> list =decisionFinancialService.getDayCashFlowReport(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	  
	
	

}
	
	
	
	
	
	
	
	
