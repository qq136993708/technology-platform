package com.pcitc.web.controller.hana;

import java.text.DecimalFormat;
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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.ChartBarLineResultData;
import com.pcitc.base.common.ChartBarLineSeries;
import com.pcitc.base.common.ChartCircle2;
import com.pcitc.base.common.ChartPieDataValue;
import com.pcitc.base.common.ChartPieResultData;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.PageResult;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.TreeNode2;
import com.pcitc.base.hana.report.H1AMKYSY100109;
import com.pcitc.base.hana.report.ProjectCode;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.web.utils.HanaUtil;

@Controller
@RequestMapping(value = "/home_budget")
public class HomeBudgetController {
	
	private static final String getBudgetByCountBar =      "http://pcitc-zuul/hana-proxy/hana/home/getBudgetByCountBar";
	private static final String getBudgetByCountPie =      "http://pcitc-zuul/hana-proxy/hana/home/getBudgetByCountPie";
	private static final String getBudgetByCountCricle =   "http://pcitc-zuul/hana-proxy/hana/home/getBudgetByCountCricle";
	private static final String getBudgetByUnitBar =       "http://pcitc-zuul/hana-proxy/hana/home/getBudgetByUnitBar";
	private static final String getBudgetByUnitPie =       "http://pcitc-zuul/hana-proxy/hana/home/getBudgetByUnitPie";
	private static final String getBudgetByUnitCricle =    "http://pcitc-zuul/hana-proxy/hana/home/getBudgetByUnitCricle";
	private static final String getBudgetByDistributeBar = "http://pcitc-zuul/hana-proxy/hana/home/getBudgetByDistributeBar";
	private static final String getBudgetTable = "http://pcitc-zuul/hana-proxy/hana/home/getBudgetTable";
	
	
	

	@Autowired
	private HttpHeaders httpHeaders;
	
	@Autowired
	private RestTemplate restTemplate;
	
				
				/**=====================================科研项目二级页面===============================*/
				
				@RequestMapping(method = RequestMethod.GET, value = "/home_budget")
				  public String kyzb_level2(HttpServletRequest request) throws Exception
				  {
					    
						
					    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
					    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
					    String unitCode=userInfo.getUnitCode();
					    request.setAttribute("unitCode", unitCode);
					    
					    
					    
					    
					    
					    request.setAttribute("YJY_CODE_ALL", HanaUtil.YJY_CODE_ALL);
				        return "stp/hana/home/level/home_budget";
				  }
				
			
				 @RequestMapping(method = RequestMethod.GET, value = "/home_budget_table")
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
					    
				        return "stp/hana/home/level/home_budget_table";
				  }
				
				
				    //三级表格
				    @RequestMapping(method = RequestMethod.POST, value = "/home_budget_table_data")
					@ResponseBody
					public String home_budget_table_data(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {


						LayuiTableData layuiTableData = new LayuiTableData();
						HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
						ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(getBudgetTable, HttpMethod.POST, entity, LayuiTableData.class);
						int statusCode = responseEntity.getStatusCodeValue();
						if (statusCode == 200) {
							layuiTableData = responseEntity.getBody();
						}
						JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
						System.out.println(">>>>>>>>>>>>>home_budget_table_data:" + result.toString());
						return result.toString();
					}
				
				    
				    /**=====================================按数量==============================*/
				    
				    
				    
				    
				    
				@RequestMapping(method = RequestMethod.GET, value = "/getBudgetByCountBar")
				@ResponseBody
				public String getBudgetByCountBar(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
						ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getBudgetByCountBar, HttpMethod.POST, entity, JSONArray.class);
						int statusCode = responseEntity.getStatusCodeValue();
						if (statusCode == 200) 
						{
							JSONArray jSONArray = responseEntity.getBody();
							System.out.println(">>>>>>>>>>>>>>getBudgetByCountBar jSONArray-> " + jSONArray.toString());
							
			         	
			         		List<H1AMKYSY100109> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100109.class);
							List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"g0XMDL");
			         		barLine.setxAxisDataList(xAxisDataList);
			         	
							List<String> legendDataList = new ArrayList<String>();
							legendDataList.add("总计");
							legendDataList.add("新开课题");
							legendDataList.add("结转课题");
							barLine.setxAxisDataList(xAxisDataList);
							barLine.setLegendDataList(legendDataList);
							// X轴数据
							List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
							ChartBarLineSeries s1 = HanaUtil.getChartBarLineSeries_budget_count_bar(list, "K0BNYSJHJE");
							ChartBarLineSeries s2 = HanaUtil.getChartBarLineSeries_budget_count_bar(list, "K0BNXKJE");
							ChartBarLineSeries s3 = HanaUtil.getChartBarLineSeries_budget_count_bar(list, "K0BNXJJE");
							
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
					System.out.println(">>>>>>>>>>>>>>getBudgetByCountBar " + resultObj.toString());
					return resultObj.toString();
				}
				
				
				@RequestMapping(method = RequestMethod.GET, value = "/getBudgetByCountPie")
				@ResponseBody
				public String getBudgetByCountPie(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
						ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getBudgetByCountPie, HttpMethod.POST, entity, JSONArray.class);
						int statusCode = responseEntity.getStatusCodeValue();
						if (statusCode == 200) 
						{
							JSONArray jSONArray = responseEntity.getBody();
							System.out.println(">>>>>>>>>>>>>>getBudgetByCountPie jSONArray-> " + jSONArray.toString());
							List<H1AMKYSY100109> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100109.class);
							ChartPieResultData pie = new ChartPieResultData();
							List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
							List<String> legendDataList = new ArrayList<String>();
							for (int i = 0; i < list.size(); i++) {
								H1AMKYSY100109 f2 = list.get(i);
								String name = f2.getG0XMDL();
								String value = f2.getK0BNYSJHJE();
								legendDataList.add(name);
								DecimalFormat decimalFormat=new DecimalFormat(".00");
								value=decimalFormat.format(Float.valueOf(value));
								
								dataList.add(new ChartPieDataValue(value, name));
								
							/*	if(value!=null && !value.equals(""))
								{
									dataList.add(new ChartPieDataValue(Double.valueOf(value).intValue(), name));
								}else
								{
									dataList.add(new ChartPieDataValue(0, name));
								}*/
								
								
								
								
								/*legendDataList.add(name);
								dataList.add(new ChartPieDataValue(value, name));*/
								/*DecimalFormat decimalFormat=new DecimalFormat(".00");
								value=decimalFormat.format(Float.valueOf(value));
								
								*/
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
					System.out.println(">>>>>>>>>>>>>>>getBudgetByCountPie " + resultObj.toString());
					return resultObj.toString();
				}
				
				
				
				@RequestMapping(method = RequestMethod.GET, value = "/getBudgetByCountCricle")
				@ResponseBody
				public String getBudgetByCountCricle(HttpServletRequest request, HttpServletResponse response) throws Exception {
					PageResult pageResult = new PageResult();
					String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
					String companyCode = CommonUtil.getParameter(request, "companyCode", "");
					Map<String, Object> paramsMap = new HashMap<String, Object>();
					paramsMap.put("month", month);
					paramsMap.put("companyCode", companyCode);
					JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
					HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
					
						ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getBudgetByCountCricle, HttpMethod.POST, entity, JSONArray.class);
						int statusCode = responseEntity.getStatusCodeValue();
						if (statusCode == 200) 
						{
							JSONArray jSONArray = responseEntity.getBody();
							
							System.out.println(">>>>>>>>>>>>getBudgetByCountCricle jSONArray>>> " + jSONArray.toString());
							List<H1AMKYSY100109> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100109.class);
							List<String>  lista=HanaUtil.getduplicatexAxisByList(list,"g0XMXZ");
							List<TreeNode2>  chartCircleList=	HanaUtil.getChildChartCircleForBudgetCount(lista,list);
							pageResult.setData(chartCircleList);
							pageResult.setCode(0);
							pageResult.setCount(Long.valueOf(chartCircleList.size()));
							pageResult.setLimit(1000);
							pageResult.setPage(1l);
						}
						
					
					JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
					System.out.println(">>>>>>>>>>>>>>>getBudgetByCountCricle " + resultObj.toString());
					return resultObj.toString();
				}
				
				
				
				
				
				
				
				
            /**=====================================按单位==============================*/
				
				
			    
							@RequestMapping(method = RequestMethod.GET, value = "/getBudgetByUnitBar")
							@ResponseBody
							public String getBudgetByUnitBar(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
									ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getBudgetByUnitBar, HttpMethod.POST, entity, JSONArray.class);
									int statusCode = responseEntity.getStatusCodeValue();
									if (statusCode == 200) 
									{
										JSONArray jSONArray = responseEntity.getBody();
										System.out.println(">>>>>>>>>>>>>>getBudgetByUnitBar jSONArray-> " + jSONArray.toString());
										
										List<H1AMKYSY100109> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100109.class);
										List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"g0GSSP");
						         		barLine.setxAxisDataList(xAxisDataList);
						         	
										List<String> legendDataList = new ArrayList<String>();
										legendDataList.add("费用性");
										legendDataList.add("资本性");
										barLine.setxAxisDataList(xAxisDataList);
										barLine.setLegendDataList(legendDataList);
										// X轴数据
										List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
										ChartBarLineSeries s1 = HanaUtil.getChartBarLineSeries_budget_unit_bar(list, "K0BNFYJE");
										ChartBarLineSeries s2 = HanaUtil.getChartBarLineSeries_budget_unit_bar(list, "K0BNZBJE");
										
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
								System.out.println(">>>>>>>>>>>>>>getBudgetByUnitBar " + resultObj.toString());
								return resultObj.toString();
							}
							
							
							@RequestMapping(method = RequestMethod.GET, value = "/getBudgetByUnitPie")
							@ResponseBody
							public String getBudgetByUnitPie(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
									ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getBudgetByUnitPie, HttpMethod.POST, entity, JSONArray.class);
									int statusCode = responseEntity.getStatusCodeValue();
									if (statusCode == 200) 
									{
										JSONArray jSONArray = responseEntity.getBody();
										System.out.println(">>>>>>>>>>>>>>getBudgetByUnitPie jSONArray-> " + jSONArray.toString());
										List<H1AMKYSY100109> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100109.class);
										ChartPieResultData pie = new ChartPieResultData();
										List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
										List<String> legendDataList = new ArrayList<String>();
										for (int i = 0; i < list.size(); i++) {
											H1AMKYSY100109 f2 = list.get(i);
											String name = f2.getG0GSSP();
											String value = f2.getK0BNXMZXSL();
											legendDataList.add(name);
											
											if(value!=null && !value.equals(""))
											{
												dataList.add(new ChartPieDataValue(Double.valueOf(value).intValue(), name));
											}else
											{
												dataList.add(new ChartPieDataValue(0, name));
											}
											
										   /*	DecimalFormat decimalFormat=new DecimalFormat(".00");
											value=decimalFormat.format(Float.valueOf(value));*/
											
											
											
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
								System.out.println(">>>>>>>>>>>>>>>getBudgetByUnitPie " + resultObj.toString());
								return resultObj.toString();
							}
							
							
							
							
							@RequestMapping(method = RequestMethod.GET, value = "/getBudgetByUnitCricle")
							@ResponseBody
							public String getBudgetByUnitCricle(HttpServletRequest request, HttpServletResponse response) throws Exception {

								PageResult pageResult = new PageResult();
								String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
								String companyCode = CommonUtil.getParameter(request, "companyCode", "");
								Map<String, Object> paramsMap = new HashMap<String, Object>();
								paramsMap.put("month", month);
								paramsMap.put("companyCode", companyCode);
								JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
								HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
								
									ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getBudgetByUnitCricle, HttpMethod.POST, entity, JSONArray.class);
									int statusCode = responseEntity.getStatusCodeValue();
									if (statusCode == 200) 
									{
										JSONArray jSONArray = responseEntity.getBody();
										List<H1AMKYSY100109> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100109.class);
										List<String>  lista=HanaUtil.getduplicatexAxisByList(list,"g0XMDL");
										List<TreeNode2>  chartCircleList=	HanaUtil.getChildChartCircleUnitBudger(lista,list);
										
										
										pageResult.setData(chartCircleList);
										pageResult.setCode(0);
										pageResult.setCount(Long.valueOf(chartCircleList.size()));
										pageResult.setLimit(1000);
										pageResult.setPage(1l);
										
									}
									
								
								JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
								System.out.println(">>>>>>>>>>>>>>>getBudgetByUnitCricle " + resultObj.toString());
								return resultObj.toString();
							}
							
							
							
							
							/*@RequestMapping(method = RequestMethod.GET, value = "/getBudgetByUnitCricle")
							@ResponseBody
							public String getBudgetByUnitCricle(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
									ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getBudgetByUnitCricle, HttpMethod.POST, entity, JSONArray.class);
									int statusCode = responseEntity.getStatusCodeValue();
									if (statusCode == 200) 
									{
										JSONArray jSONArray = responseEntity.getBody();
										List<H1AMKYSY100109> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100109.class);
										List<String>  lista=HanaUtil.getduplicatexAxisByList(list,"g0XMDL");
										List<ChartCircle2>  chartCircleList=	HanaUtil.getChildChartCircleForproject02(lista,list);
										result.setSuccess(true);
										result.setData(chartCircleList);
									}
									
								} else
								{
									result.setSuccess(false);
									result.setMessage("参数为空");
								}
								JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
								System.out.println(">>>>>>>>>>>>>>>getBudgetByUnitCricle " + resultObj.toString());
								return resultObj.toString();
							}
							*/
							
							
				
				
				
				
				
				
				
				
							@RequestMapping(method = RequestMethod.GET, value = "/getBudgetByDistributeBar")
							@ResponseBody
							public String getBudgetByDistributeBar(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
									ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getBudgetByDistributeBar, HttpMethod.POST, entity, JSONArray.class);
									int statusCode = responseEntity.getStatusCodeValue();
									if (statusCode == 200) 
									{
										JSONArray jSONArray = responseEntity.getBody();
										System.out.println(">>>>>>>>>>>>>>getBudgetByDistributeBar jSONArray-> " + jSONArray.toString());
										
										List<H1AMKYSY100109> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100109.class);
										List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"g0GSJC");
						         		barLine.setxAxisDataList(xAxisDataList);
						         	
										List<String> legendDataList = new ArrayList<String>();
										legendDataList.add("总计");
										legendDataList.add("费用性");
										legendDataList.add("资本性");
										
										
										barLine.setxAxisDataList(xAxisDataList);
										barLine.setLegendDataList(legendDataList);
										// X轴数据
										List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
										ChartBarLineSeries s1 = HanaUtil.getChartBarLineSeries_budget_unit_bar(list, "K0BNYSJHJE");
										ChartBarLineSeries s2 = HanaUtil.getChartBarLineSeries_budget_unit_bar(list, "K0BNFYJE");
										ChartBarLineSeries s3 = HanaUtil.getChartBarLineSeries_budget_unit_bar(list, "K0BNZBJE");
										
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
								System.out.println(">>>>>>>>>>>>>>getBudgetByDistributeBar " + resultObj.toString());
								return resultObj.toString();
							}
				
				
					
				
				
	  
	  
	  
}
