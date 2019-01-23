package com.pcitc.web.controller.hana;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.ChartBarLineResultData;
import com.pcitc.base.common.ChartBarLineSeries;
import com.pcitc.base.common.ChartSingleLineResultData;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.hana.report.DayCashFlow;
import com.pcitc.base.hana.report.TotalCostProjectPay01;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.web.utils.HanaUtil;

//财务
@Controller
public class FinanceController {
	@Autowired
	private HttpHeaders httpHeaders;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static final String getDayCashFlowReport = "http://pcitc-zuul/hana-proxy/hana/decision/financial/getDayCashFlowReport";
	private static final String getDayCashFlowReport2 = "http://pcitc-zuul/hana-proxy/hana/decision/financial/getDayCashFlowReport2";
	private static final String xjrllfx_data = "http://pcitc-zuul/hana-proxy/hana/decision/financial/xjrllfx";

	
	
	
	
	  //研发费用总体情况
	  @RequestMapping(method = RequestMethod.GET, value = "/finance/yffyztqk")
	  public String yffyztqk(HttpServletRequest request) throws Exception
	  {
		  SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	        return "stp/hana/finance/yffyztqk";
	  }
	  
	  //BB11研究开发费用支出情况表
	  @RequestMapping(method = RequestMethod.GET, value = "/finance/BB11yjkffyzcqkb")
	  public String BB11yjkffyzcqkb(HttpServletRequest request) throws Exception
	  {
		  SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	        return "stp/hana/finance/BB11yjkffyzcqkb";
	  }
	  //现金日流量分析
	  @RequestMapping(method = RequestMethod.GET, value = "/finance/xjrllfx")
	  public String xjrllfx(HttpServletRequest request) throws Exception
	  {
		  
		    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
		    String month=CommonUtil.getParameter(request, "month", ""+DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		    List<String> list=HanaUtil.getDayListOfMonth(month);
		    JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		    System.out.println(">>>>>json="+json);
		    request.setAttribute("days", json.toJSONString());
		    String day= DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY_DD);
		    request.setAttribute("day", day);
	        return "stp/hana/finance/xjrllfx";
	  }
	  
	  @RequestMapping(method = RequestMethod.GET, value = "/getDayCashFlowReport01")
		@ResponseBody
		public String getDayCashFlowReport01(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    	Result result = new Result();
	    	String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
			String companyCode = CommonUtil.getParameter(request, "companyCode", "");
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			ChartSingleLineResultData chartSingleLineResultData = new ChartSingleLineResultData();
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getDayCashFlowReport, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					JSONArray jSONArray = responseEntity.getBody();
					System.out.println(">>>>>>>>>>>>>>>getDayCashFlowReport01 jSONArray" + jSONArray.toString());
					List<DayCashFlow> list = JSONObject.parseArray(jSONArray.toJSONString(), DayCashFlow.class);
					List<String> xAxisDataList = new ArrayList<String>();
					List<Object> seriesDataList = new ArrayList<Object>();
					
					for (int i = 0; i < list.size(); i++) {
						DayCashFlow contract = (DayCashFlow) list.get(i);
						String g0CALDAY = contract.getG0CALDAY();
						Object k0XJYE =contract.getK0XJYE();
						if(k0XJYE!=null && !k0XJYE.toString().equals("0"))
						{
							String str=String.format("%.2f", Double.valueOf(String.valueOf(k0XJYE)));
							seriesDataList.add(str);
							xAxisDataList.add(g0CALDAY);
						}
						
						
					}
					chartSingleLineResultData.setxAxisDataList(xAxisDataList);
					chartSingleLineResultData.setSeriesDataList(seriesDataList);
					result.setSuccess(true);
					result.setData(chartSingleLineResultData);
				}
				
			
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
			System.out.println(">>>>>>>>>>>>>>>getDayCashFlowReport01 " + resultObj.toString());
			return resultObj.toString();
		}
	  
	  
		@RequestMapping(method = RequestMethod.POST, value = "/getDayCashFlowReport2")
		@ResponseBody
		public String getDayCashFlowReport2(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response)
		{

			String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY_DD));
			String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
			System.out.println(">>>>>>>>>>getDayCashFlowReport2>>>>>>>>>>>参数      month = "+month+" companyCode="+companyCode);
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			
			LayuiTableData layuiTableData = new LayuiTableData();
			HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
			ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(getDayCashFlowReport2, HttpMethod.POST, entity, LayuiTableData.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200)
			{
				layuiTableData = responseEntity.getBody();
			}
			JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
			System.out.println(">>>>>>>>>>>>>getDayCashFlowReport2:" + result.toString());
			return result.toString();
		}
	
  
		
		
		
	  
	    @RequestMapping(method = RequestMethod.POST, value = "/xjrllfx_data")
		@ResponseBody
		public String xjrllfx_data(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response)
		{

			LayuiTableData layuiTableData = new LayuiTableData();
			HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
			ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(xjrllfx_data, HttpMethod.POST, entity, LayuiTableData.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200)
			{
				layuiTableData = responseEntity.getBody();
			}
			JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
			System.out.println(">>>>>>>>>>>>>xjrllfx_data:" + result.toString());
			return result.toString();
		}
	  
	  
	    //日现金流
	    @RequestMapping(method = RequestMethod.GET, value = "/getDayCashFlowReport")
		@ResponseBody
		public String getDayCashFlowReport(HttpServletRequest request, HttpServletResponse response) throws Exception {

			Result result = new Result();
			String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
			String companyCode = CommonUtil.getParameter(request, "companyCode", "");
			// System.out.println(">>>>>>>>>>>>>>>>>>>>>参数      month = "+month+" companyCode="+companyCode);
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			if (!companyCode.equals("")) {
				// 日现金流
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getDayCashFlowReport, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) {
					JSONArray jSONArray = responseEntity.getBody();
					List<TotalCostProjectPay01> list = JSONObject.parseArray(jSONArray.toJSONString(), TotalCostProjectPay01.class);
					System.out.println(">>>>>>>>>>>>>>>>>>>日现金流  statusCode = " + statusCode + " jSONArray=" + jSONArray.toString());
					ChartBarLineResultData barLine = new ChartBarLineResultData();
					List<String> legendDataList = new ArrayList<String>();
					legendDataList.add("实际支出");
					legendDataList.add("预算批复");
					legendDataList.add("预算结余");
					barLine.setLegendDataList(legendDataList);
					List<String> yAxisDataList = HanaUtil.getYAxisTotalCostProjectPay01(list, "G0XMLXMS");// YAxis
					barLine.setyAxisDataList(yAxisDataList);

					List<ChartBarLineSeries> seriesList = HanaUtil.getSeriesListTotalCostProjectPay01(list);
					barLine.setSeriesList(seriesList);
					result.setSuccess(true);
					result.setData(barLine);
				}
			} else {
				result.setSuccess(false);
				result.setMessage("参数为空");
			}
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
			System.out.println(">>>>>>>>>>>>>>>>>>日现金流分析 " + resultObj.toString());
			return resultObj.toString();

		}
	    
	
	  //现金流量月报分析
	  @RequestMapping(method = RequestMethod.GET, value = "/finance/xjllybfx")
	  public String xjllybfx(HttpServletRequest request) throws Exception
	  {
		  SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	        return "stp/hana/finance/xjllybfx";
	  }
	//BA04现金流量表
	  @RequestMapping(method = RequestMethod.GET, value = "/finance/BA04xjllb")
	  public String BA04xjllb(HttpServletRequest request) throws Exception
	  {
		  SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	        return "stp/hana/finance/BA04xjllb";
	  }
	  //利润分析
	  @RequestMapping(method = RequestMethod.GET, value = "/finance/lrfx")
	  public String lrfx(HttpServletRequest request) throws Exception
	  {
		  
		  SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	        return "stp/hana/finance/lrfx";
	  }
	  
		
	  //BA02利润表
	  @RequestMapping(method = RequestMethod.GET, value = "/finance/BA02lrb")
	  public String BA02lrb(HttpServletRequest request) throws Exception
	  {
		  
		  SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	        return "stp/hana/finance/BA02lrb";
	  }
	  //管理费分析
	  @RequestMapping(method = RequestMethod.GET, value = "/finance/glffx")
	  public String glffx(HttpServletRequest request) throws Exception
	  {
		  SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	        return "stp/hana/finance/glffx";
	  }
	  //BD33管理费用表
	  @RequestMapping(method = RequestMethod.GET, value = "/finance/BD33glfyb")
	  public String BD33glfyb(HttpServletRequest request) throws Exception
	  {
		  
		  SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	        return "stp/hana/finance/BD33glfyb";
	  }
	  //财务费分析
	  @RequestMapping(method = RequestMethod.GET, value = "/finance/cwffx")
	  public String cwffx(HttpServletRequest request) throws Exception
	  {
		  
		  SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	        return "stp/hana/finance/cwffx";
	  }
	  //BD34财务费用表
	  @RequestMapping(method = RequestMethod.GET, value = "/finance/BD34cwfyb")
	  public String BD34cwfyb(HttpServletRequest request) throws Exception
	  {
		  
		  SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	        return "stp/hana/finance/BD34cwfyb";
	  }
	  //六项费用分析
	  @RequestMapping(method = RequestMethod.GET, value = "/finance/lxfyfx")
	  public String lxfyfx(HttpServletRequest request) throws Exception
	  {
		  
		  SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	        return "stp/hana/finance/lxfyfx";
	  }
	  //BQ14-科研单位费用明细表
	  @RequestMapping(method = RequestMethod.GET, value = "/finance/BQ14kydwfymxb")
	  public String BQ14kydwfymxb(HttpServletRequest request) throws Exception
	  {
		  
		  SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	        return "stp/hana/finance/BQ14kydwfymxb";
	  }
	  //主要经营指标分析
	  @RequestMapping(method = RequestMethod.GET, value = "/finance/zyjyzbfx")
	  public String zyjyzbfx(HttpServletRequest request) throws Exception
	  {
		  
		  SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	        return "stp/hana/finance/zyjyzbfx";
	  }
	  //BB04主要经营指标表
	  @RequestMapping(method = RequestMethod.GET, value = "/finance/BB04zyjyzbb")
	  public String BB04zyjyzbb(HttpServletRequest request) throws Exception
	  {
		  
		  SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		  HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	        return "stp/hana/finance/BB04zyjyzbb";
	  }
	  //销售费分析
	  @RequestMapping(method = RequestMethod.GET, value = "/finance/xsffx")
	  public String xsffx(HttpServletRequest request) throws Exception
	  {
		  
		  SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		  HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	        return "stp/hana/finance/xsffx";
	  }
	  //BD32销售费用表
	  @RequestMapping(method = RequestMethod.GET, value = "/finance/BD32xsfyb")
	  public String BD32xsfyb(HttpServletRequest request) throws Exception
	  {
		  SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		  HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	        return "stp/hana/finance/BD32xsfyb";
	  }
	  //盈利能力分析
	  @RequestMapping(method = RequestMethod.GET, value = "/finance/ylnlfx")
	  public String ylnlfx(HttpServletRequest request) throws Exception
	  {
		  
		  SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		  HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	        return "stp/hana/finance/ylnlfx";
	  }
	  //资产负债分析
	  @RequestMapping(method = RequestMethod.GET, value = "/finance/zcfzfx")
	  public String zcfzfx(HttpServletRequest request) throws Exception
	  {
		  SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		  HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	        return "stp/hana/finance/zcfzfx";
	  }
	  //BA01资产负债表
	  @RequestMapping(method = RequestMethod.GET, value = "/finance/BA01zcfzb")
	  public String BA01zcfzb(HttpServletRequest request) throws Exception
	  {
		  
		  SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		  HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	        return "stp/hana/finance/BA01zcfzb";
	  }
	  //应交税费分析
	  @RequestMapping(method = RequestMethod.GET, value = "/finance/yjsffx")
	  public String yjsffx(HttpServletRequest request) throws Exception
	  {
		  
		    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	        return "stp/hana/finance/yjsffx";
	  }
	  
	  
	  //BA08应上交应弥补款项表
	  @RequestMapping(method = RequestMethod.GET, value = "/finance/BA08ysjymbkxb")
	  public String BA08ysjymbkxb(HttpServletRequest request) throws Exception
	  {
		     SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		     HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	         return "stp/hana/finance/BA08ysjymbkxb";
	  }
	 //品牌建设支出分析
	  @RequestMapping(method = RequestMethod.GET, value = "/finance/ppjszcfx")
	  public String ppjszcfx(HttpServletRequest request) throws Exception
	  {
		  
		    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	        return "stp/hana/finance/ppjszcfx";
	  }
	 //品牌建设支出情况明细表
	  @RequestMapping(method = RequestMethod.GET, value = "/finance/ppjszcqkmxb")
	  public String ppjszcqkmxb(HttpServletRequest request) throws Exception
	  {
		  
		    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	        return "stp/hana/finance/ppjszcqkmxb";
	  }
	  
	  
	  
}
