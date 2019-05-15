package com.pcitc.web.controller.hana;

import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.ChartPieDataValue;
import com.pcitc.base.common.ChartPieResultData;
import com.pcitc.base.common.ExcelException;
import com.pcitc.base.common.PageResult;
import com.pcitc.base.common.Result;
import com.pcitc.base.hana.report.BudgetMysql;
import com.pcitc.base.hana.report.CompanyCode;
import com.pcitc.base.hana.report.ScientificFunds;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.web.utils.EquipmentUtils;
import com.pcitc.web.utils.HanaUtil;
import com.pcitc.web.utils.PoiExcelExportUitl;

//科技经费
@Controller
public class ScientificFundsContrller {
	
	@Autowired
	private HttpHeaders httpHeaders;
	
	@Autowired
	private RestTemplate restTemplate;
	
	//课题直间接费用统计表
	private static final String ktzjjfytjb_data = "http://pcitc-zuul/hana-proxy/hana/scientific_funds/ktzjjfytjb";
	
	//人工成本支出统计表
	private static final String rgcbzctjb_data = "http://pcitc-zuul/hana-proxy/hana/scientific_funds/rgcbzctjb";
	
	//原材料支出统计表
	private static final String yclzctjb_data = "http://pcitc-zuul/hana-proxy/hana/scientific_funds/yclzctjb";
	
	//能耗支出统计表
	private static final String nhzctjb_data = "http://pcitc-zuul/hana-proxy/hana/scientific_funds/nhzctjb";
	
	 //项目资金流向分析
	private static final String xmzjlxfx_data = "http://pcitc-zuul/hana-proxy/hana/scientific_funds/xmzjlxfx";
	
	
	private static final String investment_02 = "http://pcitc-zuul/system-proxy/out-project-plna-provider/money/complete-rate/institute";
	
	//人工成本支出统计表-详情
	private static final String getRgcbzctjbData_detail = "http://pcitc-zuul/hana-proxy/hana/scientific_funds/rgcbzctjb_detail";
	//课题直间接费用统计表-详情
    private static final String getKtzjjfytjbData_detail = "http://pcitc-zuul/hana-proxy/hana/scientific_funds/getKtzjjfytjbData_detail";
    
    //原材料支出统计表-详情
    private static final String getYclzctjbData_Detail = "http://pcitc-zuul/hana-proxy/hana/scientific_funds/getYclzctjbData_Detail";
    //能耗支出统计表-详情
    private static final String getNhzctjbData_detail = "http://pcitc-zuul/hana-proxy/hana/scientific_funds/getNhzctjbData_detail";
    //项目资金流向分析-详情
    private static final String getXmzjlxfxData_detail = "http://pcitc-zuul/hana-proxy/hana/scientific_funds/getXmzjlxfxData_detail";
	
	  //年度经费预算合同签订进度分析
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/ndjfyshtqdjdfx")
	  public String ndjfyshtqdjdfx(HttpServletRequest request) throws Exception
	  {
		    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    
		    String year = HanaUtil.getCurrrentYear();
			request.setAttribute("year", year);
	        return "stp/hana/scientificFunds/ndjfyshtqdjdfx";
	  }
	  
	  
	    @RequestMapping(method = RequestMethod.GET, value = "/ndjfyshtqdjdfx_data_01")
		@ResponseBody
		public String ndjfyshtqdjdfx_data_01(HttpServletRequest request, HttpServletResponse response) throws Exception {

			Result result = new Result();
			String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("nd", nd);
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			if (!nd.equals(""))
			{
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(investment_02, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					
					JSONArray jSONArray = responseEntity.getBody();
					System.out.println(">>>>>>>>>>>>>>ndjfyshtqdjdfx_data_01 jSONArray-> " + jSONArray.toString());
					List<BudgetMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), BudgetMysql.class);
					ChartPieResultData pie = new ChartPieResultData();
					List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
					List<String> legendDataList = new ArrayList<String>();
					for (int i = 0; i < list.size(); i++) {
						BudgetMysql f2 = list.get(i);
						String projectName = f2.getDefine2();
						String value =((BigDecimal)f2.getZsjje()).toString();
						value=String.format("%.2f", Double.valueOf(value)/10000);
						legendDataList.add(projectName);
						dataList.add(new ChartPieDataValue(value, projectName));
					}
					pie.setDataList(dataList);
					pie.setLegendDataList(legendDataList);
					result.setSuccess(true);
					result.setData(pie);
				}
				
			} else
			{
				result.setSuccess(false);
				result.setMessage("参数为空");
			}
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
			System.out.println(">>>>>>>>>>>>>>ndjfyshtqdjdfx_data_01 " + resultObj.toString());
			return resultObj.toString();
		}
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  //年度预算合同签订差异多维分析
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/ndyshtqdcydwfx")
	  public String ndyshtqdcydwfx(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/scientificFunds/ndyshtqdcydwfx";
	  }
	  //科研经费综合多维分析
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/kyjfzhdwfx")
	  public String kyjfzhdwfx(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/scientificFunds/kyjfzhdwfx";
	  }
	  
	  //课题科研资金使用多维分析
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/ktkyzjsydwfx")
	  public String ktkyzjsydwfx(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/scientificFunds/ktkyzjsydwfx";
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  //课题直间接费用统计表
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/ktzjjfytjb")
	  public String ktzjjfytjb(HttpServletRequest request) throws Exception
	  {
		    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
			String month = HanaUtil.getCurrrent_Year_Moth();
			request.setAttribute("month", month);
	        return "stp/hana/scientificFunds/ktzjjfytjb";
	  }
	  
	  
	        ////数据控制配置（直属院）
		   @RequestMapping(method = RequestMethod.GET, value = "/getDirDeparetMentList")
		   @ResponseBody
		   public Result getDirDeparetMentList(HttpServletRequest request, HttpServletResponse response) throws Exception 
	       {
			    Result resultsDate = new Result();
			    String functionId = CommonUtil.getParameter(request, "functionId", "");
			    List<SysDictionary>  sysDictionaryList=EquipmentUtils.getDirDeparetMentList( functionId , restTemplate, httpHeaders);
			    resultsDate.setData(sysDictionaryList);
			    resultsDate.setSuccess(true);
				return resultsDate;
				
	       }
		   
			
	  
	       @RequestMapping(method = RequestMethod.GET, value = "/ktzjjfytjb_data")
		   @ResponseBody
		   public String ktzjjfytjb_data(HttpServletRequest request, HttpServletResponse response) throws Exception 
	       {
	    	   
	    	   
		    
		    PageResult pageResult = new PageResult();
			String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
			String companyCode = CommonUtil.getParameter(request, "companyCode", "");
			// System.out.println(">>>>>>>>>>>>>>>>>>>>>参数      month = "+month+" companyCode="+companyCode);
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			if (!companyCode.equals("")) {
				// 课题直间接费用统计表
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(ktzjjfytjb_data, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) {
					JSONArray jSONArray = responseEntity.getBody();
					List<ScientificFunds> list = JSONObject.parseArray(jSONArray.toJSONString(), ScientificFunds.class);
					pageResult.setData(list);
					pageResult.setCode(0);
					pageResult.setCount(Long.valueOf(list.size()));
					pageResult.setLimit(1000);
					pageResult.setPage(1l);
				}
			} 
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
			System.out.println(">>>>>>>>>>>>>>>>>ktzjjfytjb_data " + resultObj.toString());
			return resultObj.toString();

		}
	       
        @RequestMapping(method = RequestMethod.GET, value = "/ktzjjfytjb_data_exput_excel")
	   	@ResponseBody
	   	public String ktzjjfytjb_data_exput_excel(HttpServletRequest request, HttpServletResponse response) throws Exception
	   	{
	   		
	   		
	   		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
	   		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
	   		String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
	   		Map<String ,Object> paramMap = new HashMap<String ,Object>();
	   		paramMap.put("month", month);
	   		paramMap.put("companyCode", companyCode);
	   		System.out.println(" ktzjjfytjb_data_exput_excel>>>>>>>>>>>>>>>>>>>>参数      month = "+month+" companyCode="+companyCode);
	   		
	   		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
	   		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(ktzjjfytjb_data, HttpMethod.POST, httpEntity, JSONArray.class);
	   		int statusCode = responseEntity.getStatusCodeValue();
	   		List<ScientificFunds> list =new ArrayList();
	   		JSONArray jSONArray=null;
	   		if (statusCode == 200)
	   		{
	   			jSONArray = responseEntity.getBody();
	   			list = JSONObject.parseArray(jSONArray.toJSONString(), ScientificFunds.class);
	   		}

	   		
	   		    String[] headers = { "院所",   "本年-总计",      "本年-直接费用",  "本年-间接费用", "本年-直间接%", "同年-总计",      "同年-直接费用",     "同年-间接费用", "同年-直间接%", "同比-总计",   "同比-直接费用",     "同比-间接费用", "同比-直间接%"};
	   		    String[] cols =    {"g0GSJC","k0BNGLFPHJECB","k0BNKYFPQCB","k0BNJJCB",  "k0BNBL",    "k0SNLJJJCB",   "k0SNKYFPQCB",   "k0SNJJCB",   "k0SNBL",   "k0TBZJ",   "k0TBZJ2",        "k0TBJJ",   "k0TBBL"};
	   		   
	   	        // 文件名默认设置为当前时间：年月日时分秒
	   	        String fileName = DateFormatUtils.format(new Date(), "yyyyMMddhhmmss");
	   	        // 设置response头信息
	   	        response.reset();
	   	        response.setContentType("application/vnd.ms-excel");
	   	        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xls");
	   	        try {
	   		        OutputStream os = response.getOutputStream();
	   		        PoiExcelExportUitl<ScientificFunds>  pee = new PoiExcelExportUitl<ScientificFunds>(fileName, headers, cols, list,os);
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
		    
		    
	       
	       
	       
	    
	       
	  
	  
	  
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/to_getKtzjjfytjbData_detail")
	  public String to_ktzjjfytjbData_detail(HttpServletRequest request) throws Exception
	  {

		  String month = CommonUtil.getParameter(request, "month", "");
		  String companyName = CommonUtil.getParameter(request, "companyName", HanaUtil.YJY_CODE_NOT_YINGKE);
		  request.setAttribute("month", month);
		  request.setAttribute("companyName", companyName);
		  String monthstr =DateUtil.dateToStr(DateUtil.strToDate(month, DateUtil.FMT_MM), DateUtil.FMT_YYYY_ZH);
			request.setAttribute("monthstr", monthstr);
			
			
			
			List<CompanyCode> companyCodeList = HanaUtil.getCompanyCode(restTemplate, httpHeaders);
			String companyCode =	HanaUtil.getCompanyCodeByName( companyCodeList,companyName);
			if(companyCode.equals(""))
			{
				companyCode=HanaUtil.YJY_CODE_NOT_YINGKE;
			}
			request.setAttribute("companyCode", companyCode);
			
	      return "stp/hana/scientificFunds/getKtzjjfytjbData_detail";
	  }
	  
	  
	  
	  
		//课题直间接费用统计表-详情
	    @RequestMapping(method = RequestMethod.GET, value = "/getKtzjjfytjbData_detail")
		@ResponseBody
		public String getKtzjjfytjbData_detail(HttpServletRequest request, HttpServletResponse response) throws Exception 
	    {
		    PageResult pageResult = new PageResult();
			String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
			String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
			 System.out.println(">>>>>>>>>>>>>>>>>>>>getKtzjjfytjbData_detail>参数      month = "+month+" companyCode="+companyCode);
			

			 String g0PROJCODE = CommonUtil.getParameter(request, "g0PROJCODE", "");
			 String g0PROJTXT = CommonUtil.getParameter(request, "g0PROJTXT", "");
			 
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			
			paramsMap.put("g0PROJCODE", g0PROJCODE);
			paramsMap.put("g0PROJTXT", g0PROJTXT);
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			if (!companyCode.equals("")) 
			{
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getKtzjjfytjbData_detail, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					JSONArray jSONArray = responseEntity.getBody();
					List<ScientificFunds> list = JSONObject.parseArray(jSONArray.toJSONString(), ScientificFunds.class);
					pageResult.setData(list);
					pageResult.setCode(0);
					pageResult.setCount(Long.valueOf(list.size()));
					pageResult.setLimit(1000);
					pageResult.setPage(1l);
				}
			} 
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
			System.out.println(">>>>>>>>>>>>>>>>>getKtzjjfytjbData_detail " + resultObj.toString());
			return resultObj.toString();

		}
	    
	    
	    @RequestMapping(method = RequestMethod.GET, value = "/getKtzjjfytjbData_detail_exput_excel")
	   	@ResponseBody
	   	public String getKtzjjfytjbData_detail_exput_excel(HttpServletRequest request, HttpServletResponse response) throws Exception
	   	{
	   		
	   		
	   		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);//设置参数类型和编码
	   		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
	   		String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
	   		Map<String ,Object> paramMap = new HashMap<String ,Object>();
	   		paramMap.put("month", month);
	   		paramMap.put("companyCode", companyCode);
	   		System.out.println(">getKtzjjfytjbData_detail>>>>>>>>>>>>>>>>>>>>参数      month = "+month+" companyCode="+companyCode);
	   		
	   		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
	   		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getKtzjjfytjbData_detail, HttpMethod.POST, httpEntity, JSONArray.class);
	   		int statusCode = responseEntity.getStatusCodeValue();
	   		List<ScientificFunds> list =new ArrayList();
	   		JSONArray jSONArray=null;
	   		if (statusCode == 200)
	   		{
	   			jSONArray = responseEntity.getBody();
	   			list = JSONObject.parseArray(jSONArray.toJSONString(), ScientificFunds.class);
	   		}
	   		
	   		
	   		
	          
	          
	   		
	   		    String[] headers = { "院所", "课题类型", "课题名称",       "总计",     "直接费用", "间接费用", "直间接%"};
	   		    String[] cols =    {"g0GSJC","g0XMLXMS","g0PROJTXT","k0BNGLFPHJECB","k0BNKYFPQCB",       "k0BNJJCB",       "k0BNBL"};
	   		   
	   	        // 文件名默认设置为当前时间：年月日时分秒
	   	        String fileName = DateFormatUtils.format(new Date(), "yyyyMMddhhmmss");
	   	        // 设置response头信息
	   	        response.reset();
	   	        response.setContentType("application/vnd.ms-excel");
	   	        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xls");
	   	        try {
	   		        OutputStream os = response.getOutputStream();
	   		        PoiExcelExportUitl<ScientificFunds>  pee = new PoiExcelExportUitl<ScientificFunds>(fileName, headers, cols, list,os);
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
	    
	    
	  
	  

				
				
	  //人工成本支出统计表
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/rgcbzctjb")
	  public String rgcbzctjb(HttpServletRequest request) throws Exception
	  {
		  SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
			
			String month = HanaUtil.getCurrrent_Year_Moth();
			request.setAttribute("month", month);
	        return "stp/hana/scientificFunds/rgcbzctjb";
	  }
	  
	  
	  
	  
	  @RequestMapping(method = RequestMethod.GET, value = "/rgcbzctjb_data")
		@ResponseBody
		public String rgcbzctjb_data(HttpServletRequest request, HttpServletResponse response) throws Exception {

		  PageResult pageResult = new PageResult();
			String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
			String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
			// System.out.println(">>>>>>>>>>>>>>>>>>>>>参数      month = "+month+" companyCode="+companyCode);
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			if (!companyCode.equals("")) {
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(rgcbzctjb_data, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) {
					JSONArray jSONArray = responseEntity.getBody();
					List<ScientificFunds> list = JSONObject.parseArray(jSONArray.toJSONString(), ScientificFunds.class);
					pageResult.setData(list);
					pageResult.setCode(0);
					pageResult.setCount(Long.valueOf(list.size()));
					pageResult.setLimit(1000);
					pageResult.setPage(1l);
				}
			} 
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
			System.out.println(">>>>>>>>>>>>>>>>>rgcbzctjb_data " + resultObj.toString());
			return resultObj.toString();

		}
	  
	  
	  
	  
	  
	  
	   
	    @RequestMapping(method = RequestMethod.GET, value = "/rgcbzctjb_data_exput_excel")
	   	@ResponseBody
	   	public String rgcbzctjb_data_exput_excel(HttpServletRequest request, HttpServletResponse response) throws Exception
	   	{
	   		
	   		
	   		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);//设置参数类型和编码
	   		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
	   		String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
	   		Map<String ,Object> paramMap = new HashMap<String ,Object>();
	   		paramMap.put("month", month);
	   		paramMap.put("companyCode", companyCode);
	   		System.out.println(">rgcbzctjb_data_exput_excel>>>>>>>>>>>>>>>>>>>>参数      month = "+month+" companyCode="+companyCode);
	   		
	   		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
	   		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(rgcbzctjb_data, HttpMethod.POST, httpEntity, JSONArray.class);
	   		int statusCode = responseEntity.getStatusCodeValue();
	   		List<ScientificFunds> list =new ArrayList();
	   		JSONArray jSONArray=null;
	   		if (statusCode == 200)
	   		{
	   			jSONArray = responseEntity.getBody();
	   			list = JSONObject.parseArray(jSONArray.toJSONString(), ScientificFunds.class);
	   		}
	   		
	   		

            
	          
	          
	   		
	   		    String[] headers = { "院所",   "本年-总计",    "本年-工资",        "本年-社会保险费",   "本年-其他保险费", "本年-福利费",      "本年-教育经费",     "本年-工会经费",    "本年-住房费用",     "本年-劳务费用",    "本年-非货币性福利",  "本年-辞退福利",    "本年-其他"    ,    "同年-总计",    "同年-工资",        "同年-社会保险费",   "同年-其他保险费", "同年-福利费",      "同年-教育经费",     "同年-工会经费",    "同年-住房费用",     "同年-劳务费用",    "同年-非货币性福利",  "同年-辞退福利",     "同年-其他"      ,     "同比-总计",    "同比-工资",        "同比-社会保险费",   "同比-其他保险费", "同比-福利费",      "同比-教育经费",     "同比-工会经费",    "同比-住房费用",     "同比-劳务费用",    "同比-非货币性福利",  "同比-辞退福利",     "同比-其他"};
	   		    String[] cols =    {"g0GSJC","k0BNCB_4",   "k0BNCB_411",     "k0BNCB_412",   "k0BNCB_413", "k0BNCB_414",     "k0BNCB_415",    "k0BNCB_416",   "k0BNCB_417",    "k0BNCB_418",   "k0BNCB_419",    "k0BNCB_420",    "k0BNCB_430"  ,  "k0SNCB_4",   "k0SNCB_411",     "k0SNCB_412",   "k0SNCB_413", "k0SNCB_414",     "k0SNCB_415",    "k0SNCB_416",   "k0SNCB_417",    "k0SNCB_418",   "k0SNCB_419",    "k0SNCB_420",    "k0SNCB_430"     ,  "k0TQCB_4",   "k0TQCB_411",     "k0TQCB_412",   "k0TQCB_413", "k0TQCB_414",     "k0TQCB_415",    "k0TQCB_416",   "k0TQCB_417",    "k0TQCB_418",   "k0TQCB_419",    "k0TQCB_420",    "k0TQCB_430" };
	   		   
	   	        // 文件名默认设置为当前时间：年月日时分秒
	   	        String fileName = DateFormatUtils.format(new Date(), "yyyyMMddhhmmss");
	   	        // 设置response头信息
	   	        response.reset();
	   	        response.setContentType("application/vnd.ms-excel");
	   	        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xls");
	   	        try {
	   		        OutputStream os = response.getOutputStream();
	   		        PoiExcelExportUitl<ScientificFunds>  pee = new PoiExcelExportUitl<ScientificFunds>(fileName, headers, cols, list,os);
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
	    
	    
	  
	  
	  
	  
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/to_getRgcbzctjbData_detail")
	  public String rgcbzctjb_data_detail(HttpServletRequest request) throws Exception
	  {

		  String month = CommonUtil.getParameter(request, "month", "");
		  String companyName = CommonUtil.getParameter(request, "companyName", HanaUtil.YJY_CODE_NOT_YINGKE);
		  request.setAttribute("month", month);
		  request.setAttribute("companyName", companyName);
		  
		  System.out.println(">>>>>>>>>>>>>>>>>>>>to_getRgcbzctjbData_detail>参数      month = "+month+" companyName="+companyName);
		  
		  String monthstr =DateUtil.dateToStr(DateUtil.strToDate(month, DateUtil.FMT_MM), DateUtil.FMT_YYYY_ZH);
			request.setAttribute("monthstr", monthstr);
			
			
			
			List<CompanyCode> companyCodeList = HanaUtil.getCompanyCode(restTemplate, httpHeaders);
			String companyCode =	HanaUtil.getCompanyCodeByName( companyCodeList,companyName);
			if(companyCode.equals(""))
			{
				companyCode=HanaUtil.YJY_CODE_NOT_YINGKE;
			}
			request.setAttribute("companyCode", companyCode);
			
	      return "stp/hana/scientificFunds/getRgcbzctjbData_detail";
	  }
	  
	  
	  
	  
	  
	  
	    @RequestMapping(method = RequestMethod.GET, value = "/rgcbzctjb_data_detail")
		@ResponseBody
		public String rgcbzctjb_data_detail(HttpServletRequest request, HttpServletResponse response) throws Exception 
	    {
		    PageResult pageResult = new PageResult();
			String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
			String companyName = CommonUtil.getParameter(request, "companyName", HanaUtil.YJY_CODE_NOT_YINGKE);
			List<CompanyCode> companyCodeList = HanaUtil.getCompanyCode(restTemplate, httpHeaders);
			String companyCode =	HanaUtil.getCompanyCodeByName( companyCodeList,companyName);
			if(companyCode.equals(""))
			{
				companyCode=HanaUtil.YJY_CODE_NOT_YINGKE;
			}
			 System.out.println(">>>>>>>>>>>>>>>>>>>>rgcbzctjb_data_detail>参数      month = "+month+" companyCode="+companyCode+" companyName="+companyName);
			
			
			 String g0PROJCODE = CommonUtil.getParameter(request, "g0PROJCODE", "");
			 String g0PROJTXT = CommonUtil.getParameter(request, "g0PROJTXT", "");
			 
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			
			paramsMap.put("g0PROJCODE", g0PROJCODE);
			paramsMap.put("g0PROJTXT", g0PROJTXT);
			
			
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			if (!companyCode.equals("")) 
			{
				// 科研经费预算投入年度趋势分析
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getRgcbzctjbData_detail, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					JSONArray jSONArray = responseEntity.getBody();
					List<ScientificFunds> list = JSONObject.parseArray(jSONArray.toJSONString(), ScientificFunds.class);
					pageResult.setData(list);
					pageResult.setCode(0);
					pageResult.setCount(Long.valueOf(list.size()));
					pageResult.setLimit(1000);
					pageResult.setPage(1l);
				}
			} 
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
			System.out.println(">>>>>>>>>>>>>>>人工成本支出统计表>>rgcbzctjb_data_detail " + resultObj.toString());
			return resultObj.toString();

		}
	  
	  
	    @RequestMapping(method = RequestMethod.GET, value = "/getRgcbzctjbData_detail_exput_excel")
	   	@ResponseBody
	   	public String getRgcbzctjbData_detail_exput_excel(HttpServletRequest request, HttpServletResponse response) throws Exception
	   	{
	   		
	   		
	   		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);//设置参数类型和编码
	   		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
	   		String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
	   		Map<String ,Object> paramMap = new HashMap<String ,Object>();
	   		paramMap.put("month", month);
	   		paramMap.put("companyCode", companyCode);
	   		System.out.println(">rgcbzctjb_data_detail_exput_excel>>>>>>>>>>>>>>>>>>>>参数      month = "+month+" companyCode="+companyCode);
	   		
	   		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
	   		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getRgcbzctjbData_detail, HttpMethod.POST, httpEntity, JSONArray.class);
	   		int statusCode = responseEntity.getStatusCodeValue();
	   		List<ScientificFunds> list =new ArrayList();
	   		JSONArray jSONArray=null;
	   		if (statusCode == 200)
	   		{
	   			jSONArray = responseEntity.getBody();
	   			list = JSONObject.parseArray(jSONArray.toJSONString(), ScientificFunds.class);
	   		}
	   		
	   		
	   		
	   		
	         
	   		
	   		
	   		    String[] headers = { "项目", "本年累计分配", "本年累计分配",       "同比成本",     "同比成本_比例"};
	   		    String[] cols =    {"g0FYXLMS","k0BNCB","k0SNCB","k0TBCB","k0TBBL"};
	   		   
	   	        // 文件名默认设置为当前时间：年月日时分秒
	   	        String fileName = DateFormatUtils.format(new Date(), "yyyyMMddhhmmss");
	   	        // 设置response头信息
	   	        response.reset();
	   	        response.setContentType("application/vnd.ms-excel");
	   	        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xls");
	   	        try {
	   		        OutputStream os = response.getOutputStream();
	   		        PoiExcelExportUitl<ScientificFunds>  pee = new PoiExcelExportUitl<ScientificFunds>(fileName, headers, cols, list,os);
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
	  
	  
	  
	  
		
	  
	  //原材料支出统计表
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/yclzctjb")
	  public String yclzctjb(HttpServletRequest request) throws Exception
	  {
		    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
			
			String month = HanaUtil.getCurrrent_Year_Moth();
			request.setAttribute("month", month);
	        return "stp/hana/scientificFunds/yclzctjb";
	  }
	  
	  
	  
	  @RequestMapping(method = RequestMethod.GET, value = "/yclzctjb_data")
			@ResponseBody
			public String yclzctjb_data(HttpServletRequest request, HttpServletResponse response) throws Exception {

			  PageResult pageResult = new PageResult();
				String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
				String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
				// System.out.println(">>>>>>>>>>>>>>>>>>yclzctjb_data>>参数      month = "+month+" companyCode="+companyCode);
				Map<String, Object> paramsMap = new HashMap<String, Object>();
				paramsMap.put("month", month);
				paramsMap.put("companyCode", companyCode);
				JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
				HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
				if (!companyCode.equals("")) {
					ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(yclzctjb_data, HttpMethod.POST, entity, JSONArray.class);
					int statusCode = responseEntity.getStatusCodeValue();
					if (statusCode == 200) {
						JSONArray jSONArray = responseEntity.getBody();
						List<ScientificFunds> list = JSONObject.parseArray(jSONArray.toJSONString(), ScientificFunds.class);
						pageResult.setData(list);
						pageResult.setCode(0);
						pageResult.setCount(Long.valueOf(list.size()));
						pageResult.setLimit(1000);
						pageResult.setPage(1l);
					}
				} 
				JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
//				System.out.println(">>>>>>>>>>>>>>>>>yclzctjb_data " + resultObj.toString());
				return resultObj.toString();

			}
	  
	  
	  
	  
	  
	  
	  
	  @RequestMapping(method = RequestMethod.GET, value = "/yclzctjb_data_exput_excel")
	   	@ResponseBody
	   	public String yclzctjb_data_exput_excel(HttpServletRequest request, HttpServletResponse response) throws Exception
	   	{
	   		
	   		
	   		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);//设置参数类型和编码
	   		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
	   		String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
	   		Map<String ,Object> paramMap = new HashMap<String ,Object>();
	   		paramMap.put("month", month);
	   		paramMap.put("companyCode", companyCode);
	   		System.out.println(">yclzctjb_data_exput_excel>>>>>>>>>>>>>>>>>>>>参数      month = "+month+" companyCode="+companyCode);
	   		
	   		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
	   		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(yclzctjb_data, HttpMethod.POST, httpEntity, JSONArray.class);
	   		int statusCode = responseEntity.getStatusCodeValue();
	   		List<ScientificFunds> list =new ArrayList();
	   		JSONArray jSONArray=null;
	   		if (statusCode == 200)
	   		{
	   			jSONArray = responseEntity.getBody();
	   			list = JSONObject.parseArray(jSONArray.toJSONString(), ScientificFunds.class);
	   		}

	   		
	   		
	   		    String[] headers = { "项目",    "本年-总计",     "本年-原材料及主要材料","本年-辅助材料",   "同年-总计",  "同年-原材料及主要材料","同年-辅助材料"   ,    "同比-总计",  "同比-原材料及主要材料","同比-辅助材料"};
	   		    String[] cols =    {"g0GSJC","k0BNCB_5",   "k0BNCB_510",     "k0BNCB_520", "k0SNCB_5", "k0SNCB_510",     "k0SNCB_520",      "k0TBCB_5", "k0TBCB_510",     "k0TBCB_520"};
	   		   
	   	        // 文件名默认设置为当前时间：年月日时分秒
	   	        String fileName = DateFormatUtils.format(new Date(), "yyyyMMddhhmmss");
	   	        // 设置response头信息
	   	        response.reset();
	   	        response.setContentType("application/vnd.ms-excel");
	   	        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xls");
	   	        try {
	   		        OutputStream os = response.getOutputStream();
	   		        PoiExcelExportUitl<ScientificFunds>  pee = new PoiExcelExportUitl<ScientificFunds>(fileName, headers, cols, list,os);
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
	  
	  
	  
	  
	  
	  
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/to_getYclzctjbData_Detail")
	  public String to_getYclzctjbData_Detail(HttpServletRequest request) throws Exception
	  {

		  String month = CommonUtil.getParameter(request, "month", "");
		  String companyName = CommonUtil.getParameter(request, "companyName", HanaUtil.YJY_CODE_NOT_YINGKE);
		  request.setAttribute("month", month);
		  request.setAttribute("companyName", companyName);
		  String monthstr =DateUtil.dateToStr(DateUtil.strToDate(month, DateUtil.FMT_MM), DateUtil.FMT_YYYY_ZH);
			request.setAttribute("monthstr", monthstr);
			
			
			List<CompanyCode> companyCodeList = HanaUtil.getCompanyCode(restTemplate, httpHeaders);
			String companyCode =	HanaUtil.getCompanyCodeByName( companyCodeList,companyName);
			if(companyCode.equals(""))
			{
				companyCode=HanaUtil.YJY_CODE_NOT_YINGKE;
			}
			request.setAttribute("companyCode", companyCode);
			
			
	      return "stp/hana/scientificFunds/getYclzctjbData_Detail";
	  }
	  
	    @RequestMapping(method = RequestMethod.GET, value = "/getYclzctjbData_Detail")
		@ResponseBody
		public String getYclzctjbData_Detail(HttpServletRequest request, HttpServletResponse response) throws Exception 
	    {
		    PageResult pageResult = new PageResult();
			String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
			String companyName = CommonUtil.getParameter(request, "companyName", HanaUtil.YJY_CODE_NOT_YINGKE);
			List<CompanyCode> companyCodeList = HanaUtil.getCompanyCode(restTemplate, httpHeaders);
			String companyCode =	HanaUtil.getCompanyCodeByName( companyCodeList,companyName);
			if(companyCode.equals(""))
			{
				companyCode=HanaUtil.YJY_CODE_NOT_YINGKE;
			}
			 System.out.println(">>>>>>>>>>>>>>>>>>>>getYclzctjbData_Detail>参数      month = "+month+" companyCode="+companyCode+" companyName="+companyName);
			
			 
			 String g0PROJCODE = CommonUtil.getParameter(request, "g0PROJCODE", "");
			 String g0PROJTXT = CommonUtil.getParameter(request, "g0PROJTXT", "");
			 
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			
			paramsMap.put("g0PROJCODE", g0PROJCODE);
			paramsMap.put("g0PROJTXT", g0PROJTXT);
			
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			if (!companyCode.equals("")) 
			{
				// 科研经费预算投入年度趋势分析
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getYclzctjbData_Detail, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					JSONArray jSONArray = responseEntity.getBody();
					List<ScientificFunds> list = JSONObject.parseArray(jSONArray.toJSONString(), ScientificFunds.class);
					pageResult.setData(list);
					pageResult.setCode(0);
					pageResult.setCount(Long.valueOf(list.size()));
					pageResult.setLimit(1000);
					pageResult.setPage(1l);
				}
			} 
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
			System.out.println(">>>>>>>>>>>>>>>>>getYclzctjbData_Detail " + resultObj.toString());
			return resultObj.toString();

		}
	  
	    
	    
	    @RequestMapping(method = RequestMethod.GET, value = "/getYclzctjbData_Detail_exput_excel")
	   	@ResponseBody
	   	public String getYclzctjbData_Detail_exput_excel(HttpServletRequest request, HttpServletResponse response) throws Exception
	   	{
	   		
	   		
	   		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);//设置参数类型和编码
	   		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
	   		String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
	   		Map<String ,Object> paramMap = new HashMap<String ,Object>();
	   		paramMap.put("month", month);
	   		paramMap.put("companyCode", companyCode);
	   		System.out.println(">yclzctjb_exput_excel>>>>>>>>>>>>>>>>>>>>参数      month = "+month+" companyCode="+companyCode);
	   		
	   		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
	   		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getYclzctjbData_Detail, HttpMethod.POST, httpEntity, JSONArray.class);
	   		int statusCode = responseEntity.getStatusCodeValue();
	   		List<ScientificFunds> list =new ArrayList();
	   		JSONArray jSONArray=null;
	   		if (statusCode == 200)
	   		{
	   			jSONArray = responseEntity.getBody();
	   			list = JSONObject.parseArray(jSONArray.toJSONString(), ScientificFunds.class);
	   		}
	   		
	   		
        
	   		
	   		    String[] headers = { "院所", "课题类型", "课题编号",       "课题名称",     "总计", "原材料及主要材料",     "辅助材料"};
	   		    String[] cols =    {"g0GSJC","g0XMLXMS","g0PROJCODE","g0PROJTXT","k0BNCB_5",       "k0BNCB_510",       "k0BNCB_520"};
	   		   
	   	        // 文件名默认设置为当前时间：年月日时分秒
	   	        String fileName = DateFormatUtils.format(new Date(), "yyyyMMddhhmmss");
	   	        // 设置response头信息
	   	        response.reset();
	   	        response.setContentType("application/vnd.ms-excel");
	   	        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xls");
	   	        try {
	   		        OutputStream os = response.getOutputStream();
	   		        PoiExcelExportUitl<ScientificFunds>  pee = new PoiExcelExportUitl<ScientificFunds>(fileName, headers, cols, list,os);
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
	    
	    
	  
	  
	  
	  
	  //能耗支出统计表
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/nhzctjb")
	  public String nhzctjb(HttpServletRequest request) throws Exception
	  {
		    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
			
			String month = HanaUtil.getCurrrent_Year_Moth();
			request.setAttribute("month", month);
	        return "stp/hana/scientificFunds/nhzctjb";
	  }
	  
	  
	  
	  
	  @RequestMapping(method = RequestMethod.GET, value = "/nhzctjb_data")
		@ResponseBody
		public String nhzctjb_data(HttpServletRequest request, HttpServletResponse response) throws Exception {

		  PageResult pageResult = new PageResult();
			String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
			String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
			// System.out.println(">>>>>>nhzctjb_data>>>>>>>>>>>>yclzctjb_data>>参数      month = "+month+" companyCode="+companyCode);
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			if (!companyCode.equals("")) {
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(nhzctjb_data, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) {
					JSONArray jSONArray = responseEntity.getBody();
					List<ScientificFunds> list = JSONObject.parseArray(jSONArray.toJSONString(), ScientificFunds.class);
					pageResult.setData(list);
					pageResult.setCode(0);
					pageResult.setCount(Long.valueOf(list.size()));
					pageResult.setLimit(1000);
					pageResult.setPage(1l);
				}
			} 
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
			System.out.println(">>>>>>>>>>>>>>>>>nhzctjb_data " + resultObj.toString());
			return resultObj.toString();

		}
	  
	  
	  
	    @RequestMapping(method = RequestMethod.GET, value = "/nhzctjb_data_exput_excel")
	   	@ResponseBody
	   	public String nhzctjb_data_exput_excel(HttpServletRequest request, HttpServletResponse response) throws Exception
	   	{
	   		
	   		
	   		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);//设置参数类型和编码
	   		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
	   		String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
	   		Map<String ,Object> paramMap = new HashMap<String ,Object>();
	   		paramMap.put("month", month);
	   		paramMap.put("companyCode", companyCode);
	   		System.out.println(">nhzctjb_data_exput_excel>>>>>>>>>>>>>>>>>>>>参数      month = "+month+" companyCode="+companyCode);
	   		
	   		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
	   		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(nhzctjb_data, HttpMethod.POST, httpEntity, JSONArray.class);
	   		int statusCode = responseEntity.getStatusCodeValue();
	   		List<ScientificFunds> list =new ArrayList();
	   		JSONArray jSONArray=null;
	   		if (statusCode == 200)
	   		{
	   			jSONArray = responseEntity.getBody();
	   			list = JSONObject.parseArray(jSONArray.toJSONString(), ScientificFunds.class);
	   		}
	   		
   		    String[] headers = { "院所",   "本年-总计", "本年-燃料油",  "本年-燃料气",  "本年-其他燃料", "本年-动力",    "本年-水",      "本年-电",      "本年-风" ,     "本年-蒸汽",     "本年-燃气",    "本年-其他动力",            "同比-总计", "同比-燃料油",  "同比-燃料气",  "同比-其他燃料", "同比-动力",    "同比-水",      "同比-电",      "同比-风" ,     "同比-蒸汽",     "同比-燃气",    "同比-其他动力"  ,            "同年-总计", "同年-燃料油",  "同年-燃料气",  "同年-其他燃料", "同年-动力",    "同年-水",      "同年-电",      "同年-风" ,     "同年-蒸汽",     "同年-燃气",    "同年-其他动力"};
   		    String[] cols =    {"g0GSJC","k0BNCB_4","k0BNCB_431","k0BNCB_432","k0BNCB_433","k0BNCB_440", "k0BNCB_441", "k0BNCB_442", "k0BNCB_443", "k0BNCB_444", "k0BNCB_445", "k0BNCB_446",           "k0TBCB_4","k0TBCB_431","k0TBCB_432","k0TBCB_433","k0TBCB_440", "k0TBCB_441", "k0TBCB_442", "k0TBCB_443", "k0TBCB_444", "k0TBCB_445", "k0TBCB_446",            "k0SNCB_4","k0SNCB_431","k0SNCB_432","k0SNCB_433","k0SNCB_440", "k0SNCB_441", "k0SNCB_442", "k0SNCB_443", "k0SNCB_444", "k0SNCB_445", "k0SNCB_446"  };
   	        // 文件名默认设置为当前时间：年月日时分秒
   	        String fileName = DateFormatUtils.format(new Date(), "yyyyMMddhhmmss");
   	        // 设置response头信息
   	        response.reset();
   	        response.setContentType("application/vnd.ms-excel");
   	        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xls");
   	        try {
   		        OutputStream os = response.getOutputStream();
   		        PoiExcelExportUitl<ScientificFunds>  pee = new PoiExcelExportUitl<ScientificFunds>(fileName, headers, cols, list,os);
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
	    
	   

	  
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/to_getNhzctjbData_detail")
	  public String getNhzctjbData_detail(HttpServletRequest request) throws Exception
	  {

		  String month = CommonUtil.getParameter(request, "month", "");
		  String companyName = CommonUtil.getParameter(request, "companyName", HanaUtil.YJY_CODE_NOT_YINGKE);
		  request.setAttribute("month", month);
		  request.setAttribute("companyName", companyName);
		  String monthstr =DateUtil.dateToStr(DateUtil.strToDate(month, DateUtil.FMT_MM), DateUtil.FMT_YYYY_ZH);
			request.setAttribute("monthstr", monthstr);
			
			
			List<CompanyCode> companyCodeList = HanaUtil.getCompanyCode(restTemplate, httpHeaders);
			String companyCode =	HanaUtil.getCompanyCodeByName( companyCodeList,companyName);
			if(companyCode.equals(""))
			{
				companyCode=HanaUtil.YJY_CODE_NOT_YINGKE;
			}
			request.setAttribute("companyCode", companyCode);
			
			
	      return "stp/hana/scientificFunds/getNhzctjbData_detail";
	  }
	  
	  
	  
	    @RequestMapping(method = RequestMethod.GET, value = "/getNhzctjbData_detail")
		@ResponseBody
		public String getNhzctjbData_detail(HttpServletRequest request, HttpServletResponse response) throws Exception 
	    {
		    PageResult pageResult = new PageResult();
			String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
			String companyName = CommonUtil.getParameter(request, "companyName", HanaUtil.YJY_CODE_NOT_YINGKE);
			List<CompanyCode> companyCodeList = HanaUtil.getCompanyCode(restTemplate, httpHeaders);
			String companyCode =	HanaUtil.getCompanyCodeByName( companyCodeList,companyName);
			if(companyCode.equals(""))
			{
				companyCode=HanaUtil.YJY_CODE_NOT_YINGKE;
			}
			 System.out.println(">>>>>>>>>>>>>>>>>>>>getNhzctjbData_detail>参数      month = "+month+" companyCode="+companyCode+" companyName="+companyName);
			

			 String g0PROJCODE = CommonUtil.getParameter(request, "g0PROJCODE", "");
			 String g0PROJTXT = CommonUtil.getParameter(request, "g0PROJTXT", "");
			 
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			
			paramsMap.put("g0PROJCODE", g0PROJCODE);
			paramsMap.put("g0PROJTXT", g0PROJTXT);
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			if (!companyCode.equals("")) 
			{
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getNhzctjbData_detail, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					JSONArray jSONArray = responseEntity.getBody();
					List<ScientificFunds> list = JSONObject.parseArray(jSONArray.toJSONString(), ScientificFunds.class);
					pageResult.setData(list);
					pageResult.setCode(0);
					pageResult.setCount(Long.valueOf(list.size()));
					pageResult.setLimit(1000);
					pageResult.setPage(1l);
				}
			} 
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
			System.out.println(">>>>>>>>>>>>能耗支出统计表>>>>>getNhzctjbData_detail " + resultObj.toString());
			return resultObj.toString();

		}
	  
	  
	    @RequestMapping(method = RequestMethod.GET, value = "/getNhzctjbData_detail_exput_excel")
	   	@ResponseBody
	   	public String getNhzctjbData_detail_exput_excel(HttpServletRequest request, HttpServletResponse response) throws Exception
	   	{
	   		
	   		
	   		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);//设置参数类型和编码
	   		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
	   		String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
	   		Map<String ,Object> paramMap = new HashMap<String ,Object>();
	   		paramMap.put("month", month);
	   		paramMap.put("companyCode", companyCode);
	   		System.out.println(">getNhzctjbData_detail_exput_excel>>>>>>>>>>>>>>>>>>>>参数      month = "+month+" companyCode="+companyCode);
	   		
	   		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
	   		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getNhzctjbData_detail, HttpMethod.POST, httpEntity, JSONArray.class);
	   		int statusCode = responseEntity.getStatusCodeValue();
	   		List<ScientificFunds> list =new ArrayList();
	   		JSONArray jSONArray=null;
	   		if (statusCode == 200)
	   		{
	   			jSONArray = responseEntity.getBody();
	   			list = JSONObject.parseArray(jSONArray.toJSONString(), ScientificFunds.class);
	   		}
	   		
	   		    String[] headers = { "院所", "课题类型", "课题编号",       "课题名称",     "总计",           "燃料油",      "燃料气","其他燃料","动力",   "水","电","风","蒸汽","燃气","其他动力"};
	   		    String[] cols =    {"g0GSJC","g0XMLXMS","g0PROJCODE","g0PROJTXT","k0BNCB_4",       "k0BNCB_431","k0BNCB_432","k0BNCB_433","k0BNCB_440","k0BNCB_441","k0BNCB_442","k0BNCB_443","k0BNCB_444","k0BNCB_445","k0BNCB_446"};
	   		   
	   	        // 文件名默认设置为当前时间：年月日时分秒
	   	        String fileName = DateFormatUtils.format(new Date(), "yyyyMMddhhmmss");
	   	        // 设置response头信息
	   	        response.reset();
	   	        response.setContentType("application/vnd.ms-excel");
	   	        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xls");
	   	        try {
	   		        OutputStream os = response.getOutputStream();
	   		        PoiExcelExportUitl<ScientificFunds>  pee = new PoiExcelExportUitl<ScientificFunds>(fileName, headers, cols, list,os);
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
	  
	  
	  
	  
	  
	  
	  //项目资金流向分析
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/xmzjlxfx")
	  public String xmzjlxfx(HttpServletRequest request) throws Exception
	  {
		    
		  
		    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
			String month = HanaUtil.getCurrrent_Year_Moth();
			request.setAttribute("month", month);
			
			  
	        return "stp/hana/scientificFunds/xmzjlxfx";
	  }
	  
	  
	  
	  
	     @RequestMapping(value = "/xmzjlxfx_data")
		 @ResponseBody
		 public String xmzjlxfx_data(HttpServletRequest request, HttpServletResponse response) throws Exception {

		    PageResult pageResult = new PageResult();
			String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
			String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
			System.out.println(">>>>>>xmzjlxfx_data>>>>>>>>>>>>yclzctjb_data>>参数      month = "+month+" companyCode="+companyCode);
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			if (!companyCode.equals(""))
			{
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(xmzjlxfx_data, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) {
					JSONArray jSONArray = responseEntity.getBody();
					List<ScientificFunds> list = JSONObject.parseArray(jSONArray.toJSONString(), ScientificFunds.class);
					pageResult.setData(list);
					pageResult.setCode(0);
					pageResult.setCount(Long.valueOf(list.size()));
					pageResult.setLimit(1000);
					pageResult.setPage(1l);
				}
			} 
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
			System.out.println(">>>>>>>>>>>>>>>>>xmzjlxfx_data " + resultObj.toString());
			return resultObj.toString();
		}

	     
	     
	     
	     
	     
	     
	     
	     @RequestMapping(method = RequestMethod.GET, value = "/sf/to_getXmzjlxfxData_detail")
		  public String getXmzjlxfxData_detail(HttpServletRequest request) throws Exception
		  {

			  String month = CommonUtil.getParameter(request, "month", "");
			  String companyName = CommonUtil.getParameter(request, "companyName", HanaUtil.YJY_CODE_NOT_YINGKE);
			  request.setAttribute("month", month);
			  request.setAttribute("companyName", companyName);
			  String monthstr =DateUtil.dateToStr(DateUtil.strToDate(month, DateUtil.FMT_MM), DateUtil.FMT_YYYY_ZH);
				request.setAttribute("monthstr", monthstr);
				
				
				
				List<CompanyCode> companyCodeList = HanaUtil.getCompanyCode(restTemplate, httpHeaders);
				String companyCode =	HanaUtil.getCompanyCodeByName( companyCodeList,companyName);
				if(companyCode.equals(""))
				{
					companyCode=HanaUtil.YJY_CODE_NOT_YINGKE;
				}
				request.setAttribute("companyCode", companyCode);
		      return "stp/hana/scientificFunds/getXmzjlxfxData_detail";
		  }
	     
	     
	     
	    @RequestMapping(method = RequestMethod.GET, value = "/getXmzjlxfxData_detail")
		@ResponseBody
		public String getXmzjlxfxData_detail(HttpServletRequest request, HttpServletResponse response) throws Exception 
	    {
		    PageResult pageResult = new PageResult();
			String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
			String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
			 System.out.println(">>>>>>>>>>>>>>>>>>>>getXmzjlxfxData_detail>参数      month = "+month+" companyCode="+companyCode);
			

			 String g0PROJCODE = CommonUtil.getParameter(request, "g0PROJCODE", "");
			 String g0PROJTXT = CommonUtil.getParameter(request, "g0PROJTXT", "");
			 
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			
			paramsMap.put("g0PROJCODE", g0PROJCODE);
			paramsMap.put("g0PROJTXT", g0PROJTXT);
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			if (!companyCode.equals("")) 
			{
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getXmzjlxfxData_detail, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					JSONArray jSONArray = responseEntity.getBody();
					List<ScientificFunds> list = JSONObject.parseArray(jSONArray.toJSONString(), ScientificFunds.class);
					pageResult.setData(list);
					pageResult.setCode(0);
					pageResult.setCount(Long.valueOf(list.size()));
					pageResult.setLimit(1000);
					pageResult.setPage(1l);
				}
			} 
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
			System.out.println(">>>>>>>>>>>>项目资金流向分析>>>>>getXmzjlxfxData_detail " + resultObj.toString());
			return resultObj.toString();

		}
	  
	    
	    
	    @RequestMapping(method = RequestMethod.GET, value = "/getXmzjlxfxData_detail_exput_excel")
	   	@ResponseBody
	   	public String getXmzjlxfxData_detail_exput_excel(HttpServletRequest request, HttpServletResponse response) throws Exception
	   	{
	   		
	   		
	   		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);//设置参数类型和编码
	   		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
	   		String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
	   		Map<String ,Object> paramMap = new HashMap<String ,Object>();
	   		paramMap.put("month", month);
	   		paramMap.put("companyCode", companyCode);
	   		System.out.println(">getXmzjlxfxData_detail_exput_excel>>>>>>>>>>>>>>>>>>>>参数      month = "+month+" companyCode="+companyCode);
	   		
	   		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
	   		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getXmzjlxfxData_detail, HttpMethod.POST, httpEntity, JSONArray.class);
	   		int statusCode = responseEntity.getStatusCodeValue();
	   		List<ScientificFunds> list =new ArrayList();
	   		JSONArray jSONArray=null;
	   		if (statusCode == 200)
	   		{
	   			jSONArray = responseEntity.getBody();
	   			list = JSONObject.parseArray(jSONArray.toJSONString(), ScientificFunds.class);
	   		}
	   		
	   		
	   		
	   		    String[] headers = { "院所",   "项目类别",   "项目编码",     "项目名称",   "本年预算",      "科研分配前成本",  "科研分配后成本",  "实际支出合计",    "资金承诺",     "定金-本年",     "资金使用%",     "总体预算",     "科研分配前成本-累计",     "科研分配后成本-累计",     "管理分配后成本-累计",     "实际支出合计-累计",     "资金承诺-累计",     "定金-累计",       "资金结余-累计",   "资金使用%--累计"};
	   		    String[] cols =    {"g0GSJC", "g0XMLXMS","g0PROJCODE","g0PROJTXT","k0BNYSJHJE",  "k0BNKYFPQCB","k0BNKYFPHCB","k0BNGLFPHJECB","k0BNSJCNJE","k0BNSJDJJE",  "k0BNZJSYBL",  "k0ZTYSJE",  "k0LJKYFPQCB",       "k0LJKYFPHCB",       "k0LJGLFPHCB",        "k0LJGLFPHJECB",   "k0LJSJCNJE",    "k0LJSJDJJE",    "k0LJYSJY",    "k0LJZJSYBL"};
	   		   
	   	        // 文件名默认设置为当前时间：年月日时分秒
	   	        String fileName = DateFormatUtils.format(new Date(), "yyyyMMddhhmmss");
	   	        // 设置response头信息
	   	        response.reset();
	   	        response.setContentType("application/vnd.ms-excel");
	   	        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xls");
	   	        try {
	   		        OutputStream os = response.getOutputStream();
	   		        PoiExcelExportUitl<ScientificFunds>  pee = new PoiExcelExportUitl<ScientificFunds>(fileName, headers, cols, list,os);
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
     
	    
	    
	  
	  //加计扣除模拟分析
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/jjkcmnfx")
	  public String jjkcmnfx(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/scientificFunds/jjkcmnfx";
	  }
	  
	  
}
