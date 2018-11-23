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
import com.pcitc.base.common.ChartCircle;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.hana.report.CompanyCode;
import com.pcitc.base.hana.report.H1AMKYSY100101;
import com.pcitc.base.hana.report.H1AMKYSY100104;
import com.pcitc.base.hana.report.H1AMKYSY100109;
import com.pcitc.base.hana.report.H1AMKYSY100117;
import com.pcitc.base.hana.report.ProjectCode;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.web.utils.HanaUtil;

@Controller
@RequestMapping(value = "/home")
public class HomePageController {
	
	private static final String GET_H1AMKYSY100101 =  "http://pcitc-zuul/hana-proxy/hana/home/H1AMKYSY100101";
	private static final String GET_H1AMKYSY100104 =      "http://pcitc-zuul/hana-proxy/hana/home/H1AMKYSY100104";
	private static final String GET_XFZC =      "http://pcitc-zuul/hana-proxy/hana/home/getndys_xfzc";
	private static final String GET_H1AMKYSY100109 =      "http://pcitc-zuul/hana-proxy/hana/home/H1AMKYSY100109";
	private static final String GET_H1AMKYSY100109COUNT = "http://pcitc-zuul/hana-proxy/hana/home/H1AMKYSY100109COUNT";
	private static final String GET_H1AMKYSY100109COUNT02 = "http://pcitc-zuul/hana-proxy/hana/home/H1AMKYSY100109COUNT2";
	private static final String GET_getDzzk = "http://pcitc-zuul/hana-proxy/hana/home/getDzzk";
	
	private static final String GET_getDzzk_bar = "http://pcitc-zuul/hana-proxy/hana/home/getDzzk_bar";
	
	// 二级页面
	private static final String ndkyxmzl = "http://pcitc-zuul/hana-proxy/hana/home/getNdkyxmzl";
	private static final String getNdkyxmzl02 = "http://pcitc-zuul/hana-proxy/hana/home/getNdkyxmzl02";
	private static final String getNdkyxmzBar = "http://pcitc-zuul/hana-proxy/hana/home/getNdkyxmzBar";
	private static final String getNdkyxmzCircle = "http://pcitc-zuul/hana-proxy/hana/home/getNdkyxmzCircle";
	private static final String ndkyxmzl_table = "http://pcitc-zuul/hana-proxy/hana/home/getNdkyxmzlTble";
	private static final String getListLevel2 = "http://pcitc-zuul/hana-proxy/hana/home/getListLevel2";
 
    
    //科研装备二级页面
	private static final String getLevel2KYZB01 = "http://pcitc-zuul/hana-proxy/hana/home/getLevel2KYZB01";
	private static final String getLevel2KYZB02Bar = "http://pcitc-zuul/hana-proxy/hana/home/getLevel2KYZB02Bar";
	private static final String getLevel2KYZB03Circle = "http://pcitc-zuul/hana-proxy/hana/home/getLevel2KYZB03Circle";
	private static final String getKYZBTble = "http://pcitc-zuul/hana-proxy/hana/home/getKYZBTble";
	private static final String get_kyzb_table_data = "http://pcitc-zuul/hana-proxy/hana/home/get_kyzb_table_data";
	 
	private static final String getZhuanziTableList = "http://pcitc-zuul/hana-proxy/hana/home/getZhuanziTableList";
	 
	
		 
	
	
	
	private static final String PROJECT_LIST_PAGE = "http://pcitc-zuul/system-proxy/out-provider/project-list";
	
	@Autowired
	private HttpHeaders httpHeaders;
	
	@Autowired
	private RestTemplate restTemplate;
	
	  //科研项目
	 /* @RequestMapping(method = RequestMethod.GET, value = "/mainStp")
	  public String mainStp(HttpServletRequest request) throws Exception
	  {
		    String month = HanaUtil.getCurrrentYearMoth();
			request.setAttribute("month", month);
		    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    String companyCode= userInfo.getManageInstituteCode();
		    request.setAttribute("companyCode", companyCode);
	        return "mainStp";
	  }*/
	  
	
	
	@RequestMapping(value = "/project-list")
	public String iniOutProjectList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//define1   资本性、费用性
		String define1 = CommonUtil.getParameter(request, "define1", "");
		request.setAttribute("define1", define1);
		//project_property  国家项目、重大专项、重点项目、其他项目
		String project_property = CommonUtil.getParameter(request, "project_property", "");
		request.setAttribute("project_property", project_property);
		//project_scope  新开课题、结转课题、完工项目
		String project_scope = CommonUtil.getParameter(request, "project_scope", "");
		request.setAttribute("project_scope", project_scope);
		//type_flag  直属研究院、分子公司、集团等9种类型
		String type_flag = CommonUtil.getParameter(request, "type_flag", "");
		request.setAttribute("type_flag", type_flag);
		String define2 = CommonUtil.getParameter(request, "define2", "");
		request.setAttribute("define2", define2);
		HanaUtil.setHomePageList(request);
		return "stp/hana/home/level/out-project-list";
		
	}
	
	
	@RequestMapping(value = "/project-list", method = RequestMethod.POST)
	@ResponseBody
	public Object outProjectList(@ModelAttribute("param") LayuiTableParam param) {

		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(PROJECT_LIST_PAGE, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();

		return JSON.toJSON(retJson).toString();
	}
	  
	  //科研项目
	  @RequestMapping(method = RequestMethod.GET, value = "/kyys")
	  public String kyys(HttpServletRequest request) throws Exception
	  {
		    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	        return "stp/hana/home/kyys";
	  }
	  
      //科研项目、年度预算、经费支出
	  @RequestMapping(method = RequestMethod.GET, value = "/H1AMKYSY100101")
	  @ResponseBody
	  public String GET_H1AMKYSY100101(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result result = new Result();
		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		String companyCode = CommonUtil.getParameter(request, "companyCode", "");
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("month", month);
		paramsMap.put("companyCode", companyCode);
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		//System.out.println(">>>>>>>>>>>>>>>>>参数 " + jsonObject.toString());
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		if (!companyCode.equals("")) {
			// 科研经费预算投入年度趋势分析
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_H1AMKYSY100101, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {
				JSONArray jSONArray = responseEntity.getBody();
				List<H1AMKYSY100101> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100101.class);
				//System.out.println(">>>>>>>>>>>>>>>>>>>>>科研项目、年度预算、经费支出       statusCode = " + statusCode + " jSONArray=" + jSONArray.toString());
				if(list!=null && list.size()>0)
				{
					result.setSuccess(true);
					result.setData(list.get(0));
				}
				
			}
		} else {
			result.setSuccess(false);
			result.setMessage("参数为空");
		}
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
		System.out.println(">>>>>>>>>>>>>>>>>>科研项目 " + resultObj.toString());
		return resultObj.toString();
	}
		
		
		//科研装备
		@RequestMapping(method = RequestMethod.GET, value = "/H1AMKYSY100104")
		@ResponseBody
		public String GET_H1AMKYSY100104(HttpServletRequest request, HttpServletResponse response) throws Exception {

			Result result = new Result();
			String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
			String companyCode = CommonUtil.getParameter(request, "companyCode", "");
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			if (!companyCode.equals("")) {
				// 科研经费预算投入年度趋势分析
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_H1AMKYSY100104, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) {
					JSONArray jSONArray = responseEntity.getBody();
					List<H1AMKYSY100104> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100104.class);
					
					if(list!=null && list.size()>0)
					{
						result.setSuccess(true);
						result.setData(list.get(0));
					}
				}
			} else {
				result.setSuccess(false);
				result.setMessage("参数为空");
			}
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
			System.out.println(">>>>>>>>>>>>>>>>>>科研装备" + resultObj.toString());
			return resultObj.toString();
		}
		
		
		
		//年度预算 经费支出
		@RequestMapping(method = RequestMethod.GET, value = "/getndys_xfzc")
		@ResponseBody
		public String getndys_xfzc(HttpServletRequest request, HttpServletResponse response) throws Exception {

			Result result = new Result();
			String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
			String companyCode = CommonUtil.getParameter(request, "companyCode", "");
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			if (!companyCode.equals("")) {
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_XFZC, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) {
					JSONArray jSONArray = responseEntity.getBody();
					List<H1AMKYSY100104> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100104.class);
					
					if(list!=null && list.size()>0)
					{
						result.setSuccess(true);
						result.setData(list.get(0));
					}
				}
			} else {
				result.setSuccess(false);
				result.setMessage("参数为空");
			}
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
			System.out.println(">>>>>>>>>>>>>>>>>年度预算 经费支出" + resultObj.toString());
			return resultObj.toString();

		}
		
		
		
		
		
		//年度科研项目总览 
		@RequestMapping(method = RequestMethod.GET, value = "/H1AMKYSY100109")
		@ResponseBody
		public String GET_H1AMKYSY100109(HttpServletRequest request, HttpServletResponse response) throws Exception {

			Result result = new Result();
			 ChartBarLineResultData barLine=new ChartBarLineResultData();
			String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
			String companyCode = CommonUtil.getParameter(request, "companyCode", "");
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			if (!companyCode.equals("")) {
				// 年度科研项目总览
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_H1AMKYSY100109, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) {
					JSONArray jSONArray = responseEntity.getBody();
					List<H1AMKYSY100109> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100109.class);
					List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"g0GSSP");
	         		barLine.setxAxisDataList(xAxisDataList);
	         	
					List<String> legendDataList = new ArrayList<String>();
					legendDataList.add("新开课题");
					legendDataList.add("结转课题");
					legendDataList.add("完工项目");
					legendDataList.add("延期项目");
					legendDataList.add("应结题未结题");
					barLine.setxAxisDataList(xAxisDataList);
					barLine.setLegendDataList(legendDataList);
					// X轴数据
					List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
					ChartBarLineSeries s1 = HanaUtil.getChartBarLineSeries_HOMPAGE02(list, "K0BNXMXKSL");
					ChartBarLineSeries s2 = HanaUtil.getChartBarLineSeries_HOMPAGE02(list, "K0BNXMXJSL");
					ChartBarLineSeries s3 = HanaUtil.getChartBarLineSeries_HOMPAGE02(list, "K0BNXMWGSL");
					
					ChartBarLineSeries K0BNXMYQSL = HanaUtil.getChartBarLineSeries_HOMPAGE02(list, "K0BNXMYQSL");
					ChartBarLineSeries K0BNXMWJSL = HanaUtil.getChartBarLineSeries_HOMPAGE02(list, "K0BNXMWJSL");
					
					seriesList.add(s1);
					seriesList.add(s2);
					seriesList.add(s3);
					seriesList.add(K0BNXMYQSL);
					seriesList.add(K0BNXMWJSL);
					barLine.setSeriesList(seriesList);
	         		
	         		result.setSuccess(true);
					result.setData(barLine);
				}
				
			} else {
				result.setSuccess(false);
				result.setMessage("参数为空");
			}
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
			System.out.println(">>>>>>>>>>>>>>>年度科研项目总览 " + resultObj.toString());
			return resultObj.toString();
		}
			  
		
		
		
		        //新开课题占比情况
				@RequestMapping(method = RequestMethod.GET, value = "/H1AMKYSY100109_COUNT")
				@ResponseBody
				public String GET_H1AMKYSY100109COUNT(HttpServletRequest request, HttpServletResponse response) throws Exception {

					Result result = new Result();
					String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
					String companyCode = CommonUtil.getParameter(request, "companyCode", "");
					Map<String, Object> paramsMap = new HashMap<String, Object>();
					paramsMap.put("month", month);
					paramsMap.put("companyCode", companyCode);
					JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
					HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
					if (!companyCode.equals("")) {
						// 科研经费预算投入年度趋势分析
						ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_H1AMKYSY100109COUNT, HttpMethod.POST, entity, JSONArray.class);
						int statusCode = responseEntity.getStatusCodeValue();
						if (statusCode == 200) {
							JSONArray jSONArray = responseEntity.getBody();
							List<H1AMKYSY100109> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100109.class);
						
							if(list!=null && list.size()>0)
							{
								result.setSuccess(true);
								result.setData(list.get(0));
							}
						}
					} else {
						result.setSuccess(false);
						result.setMessage("参数为空");
					}
					JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
					System.out.println(">>>>>>>>>>>>>>>>>>新开课题占比情况" + resultObj.toString());
					return resultObj.toString();

				}
				
				
				
				
				
				@RequestMapping(method = RequestMethod.GET, value = "/H1AMKYSY100109COUNT02")
				@ResponseBody
				public String GET_H1AMKYSY100109COUNT02(HttpServletRequest request, HttpServletResponse response) throws Exception {

					Result result = new Result();
					String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
					String companyCode = CommonUtil.getParameter(request, "companyCode", "");
					Map<String, Object> paramsMap = new HashMap<String, Object>();
					paramsMap.put("month", month);
					paramsMap.put("companyCode", companyCode);
					JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
					HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
					if (!companyCode.equals("")) {
						// 科研经费预算投入年度趋势分析
						ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_H1AMKYSY100109COUNT02, HttpMethod.POST, entity, JSONArray.class);
						int statusCode = responseEntity.getStatusCodeValue();
						if (statusCode == 200) {
							JSONArray jSONArray = responseEntity.getBody();
							List<H1AMKYSY100109> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100109.class);
							//System.out.println(">>>>>>>>>>>>>>>>>>>ttt     statusCode = " + statusCode + " jSONArray=" + jSONArray.toString());
							if(list!=null && list.size()>0)
							{
								result.setSuccess(true);
								result.setData(list.get(0));
							}
						}
					} else {
						result.setSuccess(false);
						result.setMessage("参数为空");
					}
					JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
					System.out.println(">>>>>>>>>>>>>>>>>x " + resultObj.toString());
					return resultObj.toString();

				}
				
				
				@RequestMapping(method = RequestMethod.GET, value = "/GET_getDzzk")
				@ResponseBody
				public String GET_getDzzk(HttpServletRequest request, HttpServletResponse response) throws Exception 
				{

					Result result = new Result();
					String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
					String companyCode = CommonUtil.getParameter(request, "companyCode", "");
					Map<String, Object> paramsMap = new HashMap<String, Object>();
					paramsMap.put("month", month);
					paramsMap.put("companyCode", companyCode);
					JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
					HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
					if (!companyCode.equals("")) 
					{
						ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_getDzzk, HttpMethod.POST, entity, JSONArray.class);
						int statusCode = responseEntity.getStatusCodeValue();
						if (statusCode == 200) {
							JSONArray jSONArray = responseEntity.getBody();
							System.out.println(">>>>>>>>>>>>>>>>>GET_getDzzk " + jSONArray.toString());
							List<H1AMKYSY100117> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100117.class);
							if(list!=null && list.size()>0)
							{
								result.setSuccess(true);
								result.setData(list.get(0));
							}
						}
						
					} else {
						result.setSuccess(false);
						result.setMessage("参数为空");
					}
					JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
					System.out.println(">>>>>>>>>>>>>>>>>y " + resultObj.toString());
					return resultObj.toString();

				}
				
				
				
				//年度科研项目总览 
				@RequestMapping(method = RequestMethod.GET, value = "/GET_getDzzk_bar")
				@ResponseBody
				public String GET_getDzzk_bar(HttpServletRequest request, HttpServletResponse response) throws Exception {

					Result result = new Result();
					 ChartBarLineResultData barLine=new ChartBarLineResultData();
					String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
					String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
					Map<String, Object> paramsMap = new HashMap<String, Object>();
					paramsMap.put("month", month);
					paramsMap.put("companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
					JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
					HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
					if (!companyCode.equals("")) {
						ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_getDzzk_bar, HttpMethod.POST, entity, JSONArray.class);
						int statusCode = responseEntity.getStatusCodeValue();
						if (statusCode == 200) {
							JSONArray jSONArray = responseEntity.getBody();
							List<H1AMKYSY100117> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100117.class);
							List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"g0GSJC");
			         		barLine.setxAxisDataList(xAxisDataList);
			         	
							List<String> legendDataList = new ArrayList<String>();
							legendDataList.add("大型分析仪器");
							legendDataList.add("中型实验装置");
							legendDataList.add("单台值大于500万");
							legendDataList.add("专业软件（外购）");
							barLine.setxAxisDataList(xAxisDataList);
							barLine.setLegendDataList(legendDataList);
							// X轴数据
							List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
							ChartBarLineSeries s1 = HanaUtil.getChartBarLineSeries_GET_getDzzk_bar(list, "g0SBSL1");
							ChartBarLineSeries s2 = HanaUtil.getChartBarLineSeries_GET_getDzzk_bar(list, "g0SBSL2");
							ChartBarLineSeries s3 = HanaUtil.getChartBarLineSeries_GET_getDzzk_bar(list, "g0SBSL3");
							ChartBarLineSeries K0BNXMYQSL = HanaUtil.getChartBarLineSeries_GET_getDzzk_bar(list, "g0SBSL4");
							seriesList.add(s1);
							seriesList.add(s2);
							seriesList.add(s3);
							seriesList.add(K0BNXMYQSL);
							barLine.setSeriesList(seriesList);
			         		result.setSuccess(true);
							result.setData(barLine);
						}
						
					} else {
						result.setSuccess(false);
						result.setMessage("参数为空");
					}
					JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
					System.out.println(">>>>>>>>>>>>>>GET_getDzzk_bar " + resultObj.toString());
					return resultObj.toString();
				}
				
				
				
				
	  
	  //年度科研项目总览 
	  @RequestMapping(method = RequestMethod.GET, value = "/ndky_xmzl")
	  public String ndkyxmzl(HttpServletRequest request) throws Exception
	  {
		  SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	        return "stp/hana/home/ndkyxmzl";
	  }
	  
	  //新开重大专项 
	  @RequestMapping(method = RequestMethod.GET, value = "/xkzdzx")
	  public String xkzdzx(HttpServletRequest request) throws Exception 
	  {
		  SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	        return "stp/hana/home/xkzdzx";
	  }
	  //新开“十条龙”科技攻关项目
	  @RequestMapping(method = RequestMethod.GET, value = "/stlkjggxm")
	  public String stlkjggxm(HttpServletRequest request) throws Exception
	  {
		    
		    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	        return "stp/hana/home/stlkjggxm";
	  }
	  //新开前瞻性研究项目
	  @RequestMapping(method = RequestMethod.GET, value = "/xkqzxyjxm")
	  public String xkqzxyjxm(HttpServletRequest request) throws Exception
	  {
		    
		    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	        return "stp/hana/home/xkqzxyjxm";
	  }
	  
	  
	  
	  @RequestMapping(method = RequestMethod.GET, value = "/research_project")
	  public String research_project(HttpServletRequest request) throws Exception
	  {
		    
			
		    
		    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
		    
		    String unitCode=userInfo.getUnitCode();
		    request.setAttribute("unitCode", unitCode);
		    
	        return "stp/hana/home/research_project";
	  }
	  
	  
	  
	  
	  @RequestMapping(method = RequestMethod.GET, value = "/research_project_table")
	  public String research_project_table(HttpServletRequest request) throws Exception
	  {
		    
			String month = HanaUtil.getCurrrentYearMoth();
			request.setAttribute("month", month);
		    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    
		    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
		    
		    String unitCode=userInfo.getUnitCode();
		    request.setAttribute("unitCode", unitCode);
		    //项目类型:G0XMGLLX ,项目来源:G0XMGLLY,管理级别:G0XMGLJB,项目类别:G0XMLX,项目状态:G0XMZT
		    List<ProjectCode> G0XMGLLX_LIST=HanaUtil.getBaseCode(restTemplate, httpHeaders, month, "G0XMGLLX");
		    List<ProjectCode> G0XMGLLY_LIST=HanaUtil.getBaseCode(restTemplate, httpHeaders, month, "G0XMGLLY");
		    List<ProjectCode> G0XMGLJB_LIST=HanaUtil.getBaseCode(restTemplate, httpHeaders, month, "G0XMGLJB");
		    List<ProjectCode> G0XMLX_LIST=HanaUtil.getBaseCode(restTemplate, httpHeaders, month, "G0XMLXMS");
		    List<ProjectCode> G0XMZT_LIST=HanaUtil.getBaseCode(restTemplate, httpHeaders, month, "G0XMZTMS");
		    
		    request.setAttribute("G0XMGLLX_LIST", G0XMGLLX_LIST);
		    request.setAttribute("G0XMGLLY_LIST", G0XMGLLY_LIST);
		    request.setAttribute("G0XMGLJB_LIST", G0XMGLJB_LIST);
		    request.setAttribute("G0XMLX_LIST", G0XMLX_LIST);
		    request.setAttribute("G0XMZT_LIST", G0XMZT_LIST);
		    
	        return "stp/hana/home/research_project_table";
	  }
	  
	  
	    @RequestMapping(method = RequestMethod.POST, value = "/research_project_table_data")
		@ResponseBody
		public String research_project_table(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {


			LayuiTableData layuiTableData = new LayuiTableData();
			HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
			ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(getListLevel2, HttpMethod.POST, entity, LayuiTableData.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {
				layuiTableData = responseEntity.getBody();
			}
			JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
			System.out.println(">>>>>>>>>>>>>research_project_table_data:" + result.toString());
			return result.toString();
		}
		
	  
	  
	  
	  
	        //二级页面-年度科研项目总览 
			@RequestMapping(method = RequestMethod.GET, value = "/ndkyxmzl")
			@ResponseBody
			public String ndkyxmzl(HttpServletRequest request, HttpServletResponse response) throws Exception {

				Result result = new Result();
				ChartBarLineResultData barLine=new ChartBarLineResultData();
				String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
				String companyCode = CommonUtil.getParameter(request, "companyCode", "");
				Map<String, Object> paramsMap = new HashMap<String, Object>();
				paramsMap.put("month", month);
				paramsMap.put("companyCode", companyCode);
				JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
				HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
				if (!companyCode.equals(""))
				{
					ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(ndkyxmzl, HttpMethod.POST, entity, JSONArray.class);
					int statusCode = responseEntity.getStatusCodeValue();
					if (statusCode == 200) 
					{
						JSONArray jSONArray = responseEntity.getBody();
						List<H1AMKYSY100109> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100109.class);
						List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"g0GSJC");
		         		barLine.setxAxisDataList(xAxisDataList);
		         	
						List<String> legendDataList = new ArrayList<String>();
						legendDataList.add("新开课题");
						legendDataList.add("结转课题");
						/*legendDataList.add("完工项目");
						legendDataList.add("延期项目");
						legendDataList.add("应结题未结题");*/
						barLine.setxAxisDataList(xAxisDataList);
						barLine.setLegendDataList(legendDataList);
						// X轴数据
						List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
						ChartBarLineSeries s1 = HanaUtil.getChartBarLineSeries_HOMPAGE(list, "K0BNXMXKSL");
						ChartBarLineSeries s2 = HanaUtil.getChartBarLineSeries_HOMPAGE(list, "K0BNXMXJSL");
						/*ChartBarLineSeries s3 = HanaUtil.getChartBarLineSeries_HOMPAGE(list, "K0BNXMWGSL");
						ChartBarLineSeries K0BNXMYQSL = HanaUtil.getChartBarLineSeries_HOMPAGE(list, "K0BNXMYQSL");
						ChartBarLineSeries K0BNXMWJSL = HanaUtil.getChartBarLineSeries_HOMPAGE(list, "K0BNXMWJSL");*/
						seriesList.add(s1);
						seriesList.add(s2);
						/*seriesList.add(s3);
						seriesList.add(K0BNXMYQSL);
						seriesList.add(K0BNXMWJSL);*/
						barLine.setSeriesList(seriesList);
		         		result.setSuccess(true);
						result.setData(barLine);
					}
					
				} else
				{
					result.setSuccess(false);
					result.setMessage("参数为空");
				}
				JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
				System.out.println(">>>>>>>>>>>>>>ndkyxmzl " + resultObj.toString());
				return resultObj.toString();
			}
			
			
			@RequestMapping(method = RequestMethod.POST, value = "/ndkyxmzl_table")
			@ResponseBody
			public String ndkyxmzl_table(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {


				LayuiTableData layuiTableData = new LayuiTableData();
				HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
				ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(ndkyxmzl_table, HttpMethod.POST, entity, LayuiTableData.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) {
					layuiTableData = responseEntity.getBody();
				}
				JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
				System.out.println(">>>>>>>>>>>>>ndkyxmzl_table:" + result.toString());
				return result.toString();
			}
			
			
			
			
			
	  

		       //二级页面-年度科研项目总览 
				@RequestMapping(method = RequestMethod.GET, value = "/getNdkyxmzl02")
				@ResponseBody
				public String getNdkyxmzl02(HttpServletRequest request, HttpServletResponse response) throws Exception {

					Result result = new Result();
					String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
					String companyCode = CommonUtil.getParameter(request, "companyCode", "");
					Map<String, Object> paramsMap = new HashMap<String, Object>();
					paramsMap.put("month", month);
					paramsMap.put("companyCode", companyCode);
					JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
					HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
					if (!companyCode.equals(""))
					{
						ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getNdkyxmzl02, HttpMethod.POST, entity, JSONArray.class);
						int statusCode = responseEntity.getStatusCodeValue();
						if (statusCode == 200) 
						{
							JSONArray jSONArray = responseEntity.getBody();
							List<H1AMKYSY100109> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100109.class);
			         		result.setSuccess(true);
							result.setData(list.get(0));
						}
						
					} else
					{
						result.setSuccess(false);
						result.setMessage("参数为空");
					}
					JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
					System.out.println(">>>>>>>>>>>>>>>getNdkyxmzl02 " + resultObj.toString());
					return resultObj.toString();
				}
				
				
				
				
				
				//二级页面-年度科研项目总览 
				@RequestMapping(method = RequestMethod.GET, value = "/getNdkyxmzBar")
				@ResponseBody
				public String getNdkyxmzBar(HttpServletRequest request, HttpServletResponse response) throws Exception {

					Result result = new Result();
					ChartBarLineResultData barLine=new ChartBarLineResultData();
					String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
					String companyCode = CommonUtil.getParameter(request, "companyCode", "");
					Map<String, Object> paramsMap = new HashMap<String, Object>();
					paramsMap.put("month", month);
					paramsMap.put("companyCode", companyCode);
					JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
					HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
					if (!companyCode.equals(""))
					{
						ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getNdkyxmzBar, HttpMethod.POST, entity, JSONArray.class);
						int statusCode = responseEntity.getStatusCodeValue();
						if (statusCode == 200) 
						{
							JSONArray jSONArray = responseEntity.getBody();
							List<H1AMKYSY100109> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100109.class);
							List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"g0XMXZ");
			         		barLine.setxAxisDataList(xAxisDataList);
			         	
							List<String> legendDataList = new ArrayList<String>();
							legendDataList.add("完工项目");
							legendDataList.add("延期项目");
							legendDataList.add("应结题未结题");
						
							barLine.setxAxisDataList(xAxisDataList);
							barLine.setLegendDataList(legendDataList);
							// X轴数据
							List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
							ChartBarLineSeries s1 = HanaUtil.getChartBarLineSeries_HOMPAGE_bar(list, "K0BNXMWGSL");
							ChartBarLineSeries s2 = HanaUtil.getChartBarLineSeries_HOMPAGE_bar(list, "K0BNXMYQSL");
							ChartBarLineSeries s3 = HanaUtil.getChartBarLineSeries_HOMPAGE_bar(list, "K0BNXMWJSL");
							seriesList.add(s1);
							seriesList.add(s2);
							seriesList.add(s3);
							barLine.setSeriesList(seriesList);
			         		result.setSuccess(true);
							result.setData(barLine);
						}
						
					} else
					{
						result.setSuccess(false);
						result.setMessage("参数为空");
					}
					JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
					System.out.println(">>>>>>>>>>>>>>>getNdkyxmzBar " + resultObj.toString());
					return resultObj.toString();
				}
				
				
				
				
				
				 //二级页面-年度科研项目总览 
				@RequestMapping(method = RequestMethod.GET, value = "/getNdkyxmzCircle")
				@ResponseBody
				public String getNdkyxmzCircle(HttpServletRequest request, HttpServletResponse response) throws Exception {

					Result result = new Result();
					
					String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
					String companyCode = CommonUtil.getParameter(request, "companyCode", "");
					Map<String, Object> paramsMap = new HashMap<String, Object>();
					paramsMap.put("month", month);
					paramsMap.put("companyCode", companyCode);
					JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
					HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
					if (!companyCode.equals(""))
					{
						ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getNdkyxmzCircle, HttpMethod.POST, entity, JSONArray.class);
						int statusCode = responseEntity.getStatusCodeValue();
						if (statusCode == 200) 
						{
							JSONArray jSONArray = responseEntity.getBody();
							List<H1AMKYSY100109> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100109.class);
							List<String>  lista=HanaUtil.getduplicatexAxisByList(list,"g0XMXZ");
							List<ChartCircle>  chartCircleList=	HanaUtil.getChildChartCircle(list);
							result.setSuccess(true);
							result.setData(chartCircleList);
						}
						
					} else
					{
						result.setSuccess(false);
						result.setMessage("参数为空");
					}
					JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
					System.out.println(">>>>>>>>>>>>>>>getNdkyxmzCircle " + resultObj.toString());
					return resultObj.toString();
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				/**=====================================经费二级页面===============================*/
				
				
				
				@RequestMapping(method = RequestMethod.GET, value = "/kyzb_level2")
				  public String kyzb_level2(HttpServletRequest request) throws Exception
				  {
					    
						
					    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
					    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
					    String unitCode=userInfo.getUnitCode();
					    request.setAttribute("unitCode", unitCode);
				        return "stp/hana/home/kyzb_level2";
				  }
				
				//二级表格
				@RequestMapping(method = RequestMethod.POST, value = "/getKYZBTble")
				@ResponseBody
				public String getKYZBTble(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {


					LayuiTableData layuiTableData = new LayuiTableData();
					HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
					ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(getKYZBTble, HttpMethod.POST, entity, LayuiTableData.class);
					int statusCode = responseEntity.getStatusCodeValue();
					if (statusCode == 200) {
						layuiTableData = responseEntity.getBody();
					}
					JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
					System.out.println(">>>>>>>>>>>>>getKYZBTble:" + result.toString());
					return result.toString();
				}
				@RequestMapping(method = RequestMethod.GET, value = "/kyzb_table")
				  public String kyzb_table(HttpServletRequest request) throws Exception
				  {
					    
						String month = HanaUtil.getCurrrentYearMoth();
						request.setAttribute("month", month);
					    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
					    
					    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
					    
					    String unitCode=userInfo.getUnitCode();
					    request.setAttribute("unitCode", unitCode);
					    //项目类型:G0XMGLLX ,项目来源:G0XMGLLY,管理级别:G0XMGLJB,项目类别:G0XMLX,项目状态:G0XMZT
					    List<ProjectCode> G0XMGLLX_LIST=HanaUtil.getBaseCode(restTemplate, httpHeaders, month, "G0XMGLLX");
					    List<ProjectCode> G0XMGLLY_LIST=HanaUtil.getBaseCode(restTemplate, httpHeaders, month, "G0XMGLLY");
					    List<ProjectCode> G0XMGLJB_LIST=HanaUtil.getBaseCode(restTemplate, httpHeaders, month, "G0XMGLJB");
					    List<ProjectCode> G0XMLX_LIST=HanaUtil.getBaseCode(restTemplate, httpHeaders, month, "G0XMLXMS");
					    List<ProjectCode> G0XMZT_LIST=HanaUtil.getBaseCode(restTemplate, httpHeaders, month, "G0XMZTMS");
					    
					    request.setAttribute("G0XMGLLX_LIST", G0XMGLLX_LIST);
					    request.setAttribute("G0XMGLLY_LIST", G0XMGLLY_LIST);
					    request.setAttribute("G0XMGLJB_LIST", G0XMGLJB_LIST);
					    request.setAttribute("G0XMLX_LIST", G0XMLX_LIST);
					    request.setAttribute("G0XMZT_LIST", G0XMZT_LIST);
					    
				        return "stp/hana/home/kyzb_table";
				  }
				
				
				   //三级表格
				   @RequestMapping(method = RequestMethod.POST, value = "/get_kyzb_table_data")
					@ResponseBody
					public String get_kyzb_table_data(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {


						LayuiTableData layuiTableData = new LayuiTableData();
						HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
						ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(get_kyzb_table_data, HttpMethod.POST, entity, LayuiTableData.class);
						int statusCode = responseEntity.getStatusCodeValue();
						if (statusCode == 200) {
							layuiTableData = responseEntity.getBody();
						}
						JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
						System.out.println(">>>>>>>>>>>>>get_kyzb_table_data:" + result.toString());
						return result.toString();
					}
				
				@RequestMapping(method = RequestMethod.GET, value = "/getLevel2KYZB01")
				@ResponseBody
				public String getLevel2KYZB01(HttpServletRequest request, HttpServletResponse response) throws Exception {

					Result result = new Result();
					ChartBarLineResultData barLine=new ChartBarLineResultData();
					String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
					String companyCode = CommonUtil.getParameter(request, "companyCode", "");
					Map<String, Object> paramsMap = new HashMap<String, Object>();
					paramsMap.put("month", month);
					paramsMap.put("companyCode", companyCode);
					JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
					HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
					if (!companyCode.equals(""))
					{
						ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getLevel2KYZB01, HttpMethod.POST, entity, JSONArray.class);
						int statusCode = responseEntity.getStatusCodeValue();
						if (statusCode == 200) 
						{
							JSONArray jSONArray = responseEntity.getBody();
							System.out.println(">>>>>>>>>>>>>>getLevel2KYZB01 jSONArray-> " + jSONArray.toString());
							
							List<H1AMKYSY100109> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100109.class);
							List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"g0GSJC");
			         		barLine.setxAxisDataList(xAxisDataList);
			         	
							List<String> legendDataList = new ArrayList<String>();
							legendDataList.add("新开课题");
							legendDataList.add("结转课题");
							barLine.setxAxisDataList(xAxisDataList);
							barLine.setLegendDataList(legendDataList);
							// X轴数据
							List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
							ChartBarLineSeries s1 = HanaUtil.getKYZBLevel2ChartBarLineSeries(list, "K0BNXMXKSL");
							ChartBarLineSeries s2 = HanaUtil.getKYZBLevel2ChartBarLineSeries(list, "K0BNXMXJSL");
							
							seriesList.add(s1);
							seriesList.add(s2);
							
							barLine.setSeriesList(seriesList);
			         		result.setSuccess(true);
							result.setData(barLine);
						}
						
					} else
					{
						result.setSuccess(false);
						result.setMessage("参数为空");
					}
					JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
					System.out.println(">>>>>>>>>>>>>>getLevel2KYZB01 " + resultObj.toString());
					return resultObj.toString();
				}
				
				
				@RequestMapping(method = RequestMethod.GET, value = "/getLevel2KYZB02Bar")
				@ResponseBody
				public String getLevel2KYZB02Bar(HttpServletRequest request, HttpServletResponse response) throws Exception {

					Result result = new Result();
					ChartBarLineResultData barLine=new ChartBarLineResultData();
					String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
					String companyCode = CommonUtil.getParameter(request, "companyCode", "");
					Map<String, Object> paramsMap = new HashMap<String, Object>();
					paramsMap.put("month", month);
					paramsMap.put("companyCode", companyCode);
					JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
					HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
					if (!companyCode.equals(""))
					{
						ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getLevel2KYZB02Bar, HttpMethod.POST, entity, JSONArray.class);
						int statusCode = responseEntity.getStatusCodeValue();
						if (statusCode == 200) 
						{
							JSONArray jSONArray = responseEntity.getBody();
							
							System.out.println(">>>>>>>>>>>>>>getLevel2KYZB02Bar jSONArray-> " + jSONArray.toString());
							
							
							List<H1AMKYSY100109> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100109.class);
							List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"g0XMXZ");
			         		barLine.setxAxisDataList(xAxisDataList);
			         	
							List<String> legendDataList = new ArrayList<String>();
							legendDataList.add("完工项目");
							legendDataList.add("延期项目");
							legendDataList.add("应结题未结题");
						
							barLine.setxAxisDataList(xAxisDataList);
							barLine.setLegendDataList(legendDataList);
							// X轴数据
							List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
							ChartBarLineSeries s1 = HanaUtil.getChartBarLineSeries_HOMPAGE_bar(list, "K0BNXMWGSL");
							ChartBarLineSeries s2 = HanaUtil.getChartBarLineSeries_HOMPAGE_bar(list, "K0BNXMYQSL");
							ChartBarLineSeries s3 = HanaUtil.getChartBarLineSeries_HOMPAGE_bar(list, "K0BNXMWJSL");
							seriesList.add(s1);
							seriesList.add(s2);
							seriesList.add(s3);
							barLine.setSeriesList(seriesList);
			         		result.setSuccess(true);
							result.setData(barLine);
						}
						
					} else
					{
						result.setSuccess(false);
						result.setMessage("参数为空");
					}
					JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
					System.out.println(">>>>>>>>>>>>>>>getLevel2KYZB02Bar " + resultObj.toString());
					return resultObj.toString();
				}
				
				
				
				@RequestMapping(method = RequestMethod.GET, value = "/getLevel2KYZB03Circle")
				@ResponseBody
				public String getLevel2KYZB03Circle(HttpServletRequest request, HttpServletResponse response) throws Exception {

					Result result = new Result();
					
					String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
					String companyCode = CommonUtil.getParameter(request, "companyCode", "");
					Map<String, Object> paramsMap = new HashMap<String, Object>();
					paramsMap.put("month", month);
					paramsMap.put("companyCode", companyCode);
					JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
					HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
					if (!companyCode.equals(""))
					{
						ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getLevel2KYZB03Circle, HttpMethod.POST, entity, JSONArray.class);
						int statusCode = responseEntity.getStatusCodeValue();
						if (statusCode == 200) 
						{
							JSONArray jSONArray = responseEntity.getBody();
							List<H1AMKYSY100109> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100109.class);
							List<String>  lista=HanaUtil.getduplicatexAxisByList(list,"g0XMXZ");
							List<ChartCircle>  chartCircleList=	HanaUtil.getChildChartCircle(list);
							result.setSuccess(true);
							result.setData(chartCircleList);
						}
						
					} else
					{
						result.setSuccess(false);
						result.setMessage("参数为空");
					}
					JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
					System.out.println(">>>>>>>>>>>>>>>getLevel2KYZB03Circle " + resultObj.toString());
					return resultObj.toString();
				}
				
				
	  
				
				 @RequestMapping(method = RequestMethod.GET, value = "/home_zhuanzi_table")
				  public String home_zhuanzi_table(HttpServletRequest request) throws Exception
				  {
					    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
					    String g0SBFL = CommonUtil.getParameter(request, "g0SBFL", "");
					    
					    request.setAttribute("g0SBFL", g0SBFL);
					    
					    
					    List<String>  propertyList=new ArrayList<String>();
					    propertyList.add("大型分析仪器");
					    propertyList.add("中型实验装置");
					    propertyList.add("单台值大于500万/工业侧线实验装置");
					    propertyList.add("专业软件");
					    request.setAttribute("propertyList", propertyList);
					    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
					    
				        return "stp/hana/home/level/home_zhuanzi_table";
				  }
				
				  @RequestMapping(method = RequestMethod.POST, value = "/getZhuanziTableList")
					@ResponseBody
					public String getZhuanziTableList(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {


						LayuiTableData layuiTableData = new LayuiTableData();
						HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
						ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(getZhuanziTableList, HttpMethod.POST, entity, LayuiTableData.class);
						int statusCode = responseEntity.getStatusCodeValue();
						if (statusCode == 200) {
							layuiTableData = responseEntity.getBody();
						}
						JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
						System.out.println(">>>>>>>>>>>>>getZhuanziTableList:" + result.toString());
						return result.toString();
					}
				  
	  
	  
}
