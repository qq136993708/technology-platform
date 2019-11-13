package com.pcitc.web.controller.hana;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.ChartBarLineResultData;
import com.pcitc.base.common.ChartBarLineSeries;
import com.pcitc.base.common.ChartSingleLineResultData;
import com.pcitc.base.common.ExcelException;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.hana.report.DayCashFlow;
import com.pcitc.base.hana.report.Financial;
import com.pcitc.base.hana.report.ScientificFunds;
import com.pcitc.base.hana.report.TotalCostProjectPay01;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.web.utils.HanaUtil;
import com.pcitc.web.utils.PoiExcelExportUitl;

//财务
@Controller
public class FinanceController extends BaseController {
	
	private static final String getDayCashFlowReport = "http://pcitc-zuul/hana-proxy/hana/decision/financial/getDayCashFlowReport";
	private static final String getDayCashFlowReport2 = "http://pcitc-zuul/hana-proxy/hana/decision/financial/getDayCashFlowReport2";
	private static final String xjrllfx_data = "http://pcitc-zuul/hana-proxy/hana/decision/financial/xjrllfx";
    //研发费统计
	private static final String yfftj_data =        "http://pcitc-zuul/hana-proxy/hana/decision/financial/yfftj";
	private static final String yfftj_data_excel =        "http://pcitc-zuul/hana-proxy/hana/decision/financial/yfftj_list";
	private static final String yfftj_detail_data = "http://pcitc-zuul/hana-proxy/hana/decision/financial/yfftj_detail";
	//技术改造统计
	private static final String jsgztj_data =        "http://pcitc-zuul/hana-proxy/hana/decision/financial/jsgztj";
	private static final String jsgztj_data_excel =        "http://pcitc-zuul/hana-proxy/hana/decision/financial/jsgztj_list";
	private static final String jsgztj_detail_data = "http://pcitc-zuul/hana-proxy/hana/decision/financial/jsgztj_detail";
		
	
	
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
		  
		    String month=CommonUtil.getParameter(request, "month", ""+DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		    List<String> list=HanaUtil.getDayListOfMonth(month);
		    JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		    //System.out.println(">>>>>json="+json);
		    request.setAttribute("days", json.toJSONString());
		    String day= DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY_DD_ZN);
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
					//System.out.println(">>>>>>>>>>>>>>>getDayCashFlowReport01 jSONArray" + jSONArray.toString());
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
			//System.out.println(">>>>>>>>>>>>>>>getDayCashFlowReport01 " + resultObj.toString());
			return resultObj.toString();
		}
	  
	  
		@RequestMapping(method = RequestMethod.POST, value = "/getDayCashFlowReport2")
		@ResponseBody
		public String getDayCashFlowReport2(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response)
		{

			String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY_DD));
			String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
			//System.out.println(">>>>>>>>>>getDayCashFlowReport2>>>>>>>>>>>参数      month = "+month+" companyCode="+companyCode);
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
			//System.out.println(">>>>>>>>>>>>>getDayCashFlowReport2:" + result.toString());
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
			//System.out.println(">>>>>>>>>>>>>xjrllfx_data:" + result.toString());
			return result.toString();
		}
	  
	  
	    //日现金流
	    @RequestMapping(method = RequestMethod.GET, value = "/getDayCashFlowReport")
		@ResponseBody
		public String getDayCashFlowReport(HttpServletRequest request, HttpServletResponse response) throws Exception {

			Result result = new Result();
			String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
			String companyCode = CommonUtil.getParameter(request, "companyCode", "");
			// //System.out.println(">>>>>>>>>>>>>>>>>>>>>参数      month = "+month+" companyCode="+companyCode);
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
					//System.out.println(">>>>>>>>>>>>>>>>>>>日现金流  statusCode = " + statusCode + " jSONArray=" + jSONArray.toString());
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
			//System.out.println(">>>>>>>>>>>>>>>>>>日现金流分析 " + resultObj.toString());
			return resultObj.toString();

		}
	    
	
	  //现金流量月报分析
	  @RequestMapping(method = RequestMethod.GET, value = "/finance/xjllybfx")
	  public String xjllybfx(HttpServletRequest request) throws Exception
	  {
		  SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    HanaUtil.setSearchParaForUser2(userInfo,restTemplate,httpHeaders,request);
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
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	    //研发费统计
	    @RequestMapping(method = RequestMethod.GET, value = "/finance/yfftj")
	    public String yfftj(HttpServletRequest request) throws Exception
	    {
			 String month = HanaUtil.getCurrentYear_Moth();
			 request.setAttribute("month", month);
			 return "stp/hana/finance/yfftj";
			 
	    }
	    
	    // 三级表格
		@RequestMapping(method = RequestMethod.POST, value = "/yfftj_data")
		@ResponseBody
		public String yfftj_data(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response)
		{
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(param));
			//System.out.println(">>>>>>>>>>>>>>>>>yfftj_data 参数 "+resultObj.toString());
			
			LayuiTableData layuiTableData = new LayuiTableData();
			HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
			ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(yfftj_data, HttpMethod.POST, entity, LayuiTableData.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200)
			{
				layuiTableData = responseEntity.getBody();
			}
			JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
			//System.out.println(">>>>>>>>>>>>>yfftj_data:" + result.toString());
			return result.toString();
		}
		
		
		
		
		//研发费用统计表
	    @RequestMapping(method = RequestMethod.GET, value = "/yfftj_data_exput_excel")
	   	@ResponseBody
	   	public String yfftj_data_exput_excel(HttpServletRequest request, HttpServletResponse response) throws Exception
	   	{
	   		
	   		
	   		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);//设置参数类型和编码
	   		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
	   		Map<String ,Object> paramMap = new HashMap<String ,Object>();
	   		paramMap.put("month", month);
	   		//System.out.println(">yfftj_data_exput_excel>>>>>>>>>>>>>>>>>>>>参数      month = "+month);
	   		
	   		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
	   		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(yfftj_data_excel, HttpMethod.POST, httpEntity, JSONArray.class);
	   		int statusCode = responseEntity.getStatusCodeValue();
	   		List<Financial> list =new ArrayList();
	   		JSONArray jSONArray=null;
	   		if (statusCode == 200)
	   		{
	   			jSONArray = responseEntity.getBody();
	   			list = JSONObject.parseArray(jSONArray.toJSONString(), Financial.class);
	   		}
	   		
	   		    String[] headers = { "板块",   
	   		    		             "上年研发支出(万元)",   
	   		    		             "本年研发支出(万元)"  
	   		    		             };
	   		    String[] cols =    {
	   		    		              "g0BK", 
	   		    		              "k0SNYE",
	   		    		              "k0BNYE"
	   		    		              };
	   		   
	   	        // 文件名默认设置为当前时间：年月日时分秒
	   	        String fileName = "研发费用统计表_"+month+"_"+DateFormatUtils.format(new Date(), "ddhhmmss");
	   	        // 设置response头信息
	   	        response.reset();
	   	        response.setCharacterEncoding("UTF-8");
		        response.setContentType("application/vnd.ms-excel");
		        response.setHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO8859-1") + ".xls");
	   	        try {
	   		        OutputStream os = response.getOutputStream();
	   		        PoiExcelExportUitl<Financial>  pee = new PoiExcelExportUitl<Financial>(fileName, headers, cols, list,os);
	   		        pee.exportExcel();
	   	            
	   	        } catch (Exception e)
	   	        {
	   	            e.printStackTrace();
	   	            // 如果是ExcelException,则直接抛出
	   	            if (e instanceof ExcelException) 
	   	            {
	   	                throw (ExcelException) e;
	   	            } else 
	   	            {
	   	                // 否则将其他异常包装成ExcelException再抛出
	   	                throw new ExcelException("导出excel失败");
	   	            }
	   	        }
	   		   return null;
	   	}
	    
		
	    
	    
	    
	    
	    
		//技改支出统计表
	    @RequestMapping(method = RequestMethod.GET, value = "/jsgztj_data_exput_excel")
	   	@ResponseBody
	   	public String jsgztj_data_exput_excel(HttpServletRequest request, HttpServletResponse response) throws Exception
	   	{
	   		
	   		
	   		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);//设置参数类型和编码
	   		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
	   		Map<String ,Object> paramMap = new HashMap<String ,Object>();
	   		paramMap.put("month", month);
	   		//System.out.println(">jsgztj_data_exput_excel>>>>>>>>>>>>>>>>>>>>参数      month = "+month);
	   		
	   		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
	   		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(jsgztj_data_excel, HttpMethod.POST, httpEntity, JSONArray.class);
	   		int statusCode = responseEntity.getStatusCodeValue();
	   		List<Financial> list =new ArrayList();
	   		JSONArray jSONArray=null;
	   		if (statusCode == 200)
	   		{
	   			jSONArray = responseEntity.getBody();
	   			list = JSONObject.parseArray(jSONArray.toJSONString(), Financial.class);
	   		}
	   		
	   		    String[] headers = { "板块",   
	   		    		             "年度计划(万元)",   
	   		    		             "实际完成(万元)"  
	   		    		             };
	   		    String[] cols =    {
	   		    		              "g0BK", 
	   		    		              "k0NDJHTZ",
	   		    		              "k0NDJE"
	   		    		              };
	   		   
	   	        // 文件名默认设置为当前时间：年月日时分秒
	   	        String fileName = "技改支出统计表_"+month+"_"+DateFormatUtils.format(new Date(), "ddhhmmss");
	   	        // 设置response头信息
	   	        response.reset();
	   	        response.setCharacterEncoding("UTF-8");
		        response.setContentType("application/vnd.ms-excel");
		        response.setHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO8859-1") + ".xls");
	   	        try {
	   		        OutputStream os = response.getOutputStream();
	   		        PoiExcelExportUitl<Financial>  pee = new PoiExcelExportUitl<Financial>(fileName, headers, cols, list,os);
	   		        pee.exportExcel();
	   	            
	   	        } catch (Exception e)
	   	        {
	   	            e.printStackTrace();
	   	            // 如果是ExcelException,则直接抛出
	   	            if (e instanceof ExcelException) 
	   	            {
	   	                throw (ExcelException) e;
	   	            } else 
	   	            {
	   	                // 否则将其他异常包装成ExcelException再抛出
	   	                throw new ExcelException("导出excel失败");
	   	            }
	   	        }
	   		   return null;
	   	}
	    
	    
	    
		
		@RequestMapping(method = RequestMethod.GET, value = "/finance/yfftj_detail")
		  public String yfftj_detail(HttpServletRequest request) throws Exception
		  {

				  String month = CommonUtil.getParameter(request, "month", "");
				  request.setAttribute("month", month);
				  String monthstr =DateUtil.dateToStr(DateUtil.strToDate(month, DateUtil.FMT_MM), DateUtil.FMT_YYYY_ZH);
				  request.setAttribute("monthstr", monthstr);
				  
				  
				  String g0BK = CommonUtil.getParameter(request, "g0BK", "");
				  request.setAttribute("g0BK", g0BK);
				  
				  return "stp/hana/finance/yfftj_detail";
		  }
	     
		  
		  
		  @RequestMapping(method = RequestMethod.POST, value = "/yfftj_detail_data")
			@ResponseBody
		  public String yfftj_detail_data(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response)
			{
				JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(param));
				//System.out.println(">>>>>>>>>>>>>>>>>yfftj_detail_data 参数 "+resultObj.toString());
				
				LayuiTableData layuiTableData = new LayuiTableData();
				HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
				ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(yfftj_detail_data, HttpMethod.POST, entity, LayuiTableData.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200)
				{
					layuiTableData = responseEntity.getBody();
				}
				JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
				//System.out.println(">>>>>>>>>>>>>yfftj_detail_data 返回结果:" + result.toString());
				return result.toString();
			}
		  
		  
		  
		  
		  
		//技术改造统计
		  
		  
		  @RequestMapping(method = RequestMethod.GET, value = "/finance/jsgztj")
		    public String jsgztj(HttpServletRequest request) throws Exception
		    {
				String month = HanaUtil.getCurrentYear_Moth();
				request.setAttribute("month", month);
				
				 return "stp/hana/finance/jsgztj";
				 
		    }
		    
		    // 三级表格
			@RequestMapping(method = RequestMethod.POST, value = "/jsgztj_data")
			@ResponseBody
			public String jsgztj_data(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response)
			{
				JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(param));
				//System.out.println(">>>>>>>>>>>>>>>>>jsgztj_data 参数 "+resultObj.toString());
				
				LayuiTableData layuiTableData = new LayuiTableData();
				HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
				ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(jsgztj_data, HttpMethod.POST, entity, LayuiTableData.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200)
				{
					layuiTableData = responseEntity.getBody();
				}
				JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
				//System.out.println(">>>>>>>>>>>>>jsgztj_data:" + result.toString());
				return result.toString();
			}
			
			
			
			@RequestMapping(method = RequestMethod.GET, value = "/finance/jsgztj_detail")
			  public String jsgztj_detail(HttpServletRequest request) throws Exception
			  {

					  String month = CommonUtil.getParameter(request, "month", "");
					  request.setAttribute("month", month);
					  String monthstr =DateUtil.dateToStr(DateUtil.strToDate(month, DateUtil.FMT_MM), DateUtil.FMT_YYYY_ZH);
					  request.setAttribute("monthstr", monthstr);
					  request.setAttribute("monthName",HanaUtil.getMonthName(month));
					  
					  
					  String g0BK = CommonUtil.getParameter(request, "g0BK", "");
					  request.setAttribute("g0BK", g0BK);
					  
					  return "stp/hana/finance/jsgztj_detail";
			  }
		     
			  
			  
			  @RequestMapping(method = RequestMethod.POST, value = "/jsgztj_detail_data")
				@ResponseBody
			  public String jsgztj_detail_data(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response)
				{
					JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(param));
					//System.out.println(">>>>>>>>>>>>>>>>>jsgztj_detail_data 参数 "+resultObj.toString());
					
					LayuiTableData layuiTableData = new LayuiTableData();
					HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
					ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(jsgztj_detail_data, HttpMethod.POST, entity, LayuiTableData.class);
					int statusCode = responseEntity.getStatusCodeValue();
					if (statusCode == 200)
					{
						layuiTableData = responseEntity.getBody();
					}
					JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
					//System.out.println(">>>>>>>>>>>>>jsgztj_detail_data 返回结果:" + result.toString());
					return result.toString();
				}
			  
			  
		  
		  
	  
	  
}
