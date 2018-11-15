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
@RequestMapping(value = "/home_project")
public class HomeProjectController {
	
	private static final String getProjectByCountBar =      "http://pcitc-zuul/hana-proxy/hana/home/getProjectByCountBar";
	private static final String getProjectByCountPie =      "http://pcitc-zuul/hana-proxy/hana/home/getProjectByCountPie";
	private static final String getProjectByCountCricle =   "http://pcitc-zuul/hana-proxy/hana/home/getProjectByCountCricle";
	private static final String getProjectByUnitBar =       "http://pcitc-zuul/hana-proxy/hana/home/getProjectByUnitBar";
	private static final String getProjectByUnitPie =       "http://pcitc-zuul/hana-proxy/hana/home/getProjectByUnitPie";
	private static final String getProjectByUnitCricle =    "http://pcitc-zuul/hana-proxy/hana/home/getProjectByUnitCricle";
	private static final String getProjectByDistributeBar = "http://pcitc-zuul/hana-proxy/hana/home/getProjectByDistributeBar";
	private static final String getProjectTable = "http://pcitc-zuul/hana-proxy/hana/home/getProjectTable";
	
	
	
	
	@Autowired
	private HttpHeaders httpHeaders;
	
	@Autowired
	private RestTemplate restTemplate;
	
				
				/**=====================================科研项目二级页面===============================*/
				
				@RequestMapping(method = RequestMethod.GET, value = "/home_project")
				  public String kyzb_level2(HttpServletRequest request) throws Exception
				  {
					    
						
					    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
					    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
					    String unitCode=userInfo.getUnitCode();
					    request.setAttribute("unitCode", unitCode);
				        return "stp/hana/home/level/home_project";
				  }
				
			
				 @RequestMapping(method = RequestMethod.GET, value = "/home_project_table")
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
					    
				        return "stp/hana/home/level/home_project_table";
				  }
				
				
				    //三级表格
				    @RequestMapping(method = RequestMethod.POST, value = "/home_project_table_data")
					@ResponseBody
					public String home_project_table_data(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {


						LayuiTableData layuiTableData = new LayuiTableData();
						HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
						ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(getProjectTable, HttpMethod.POST, entity, LayuiTableData.class);
						int statusCode = responseEntity.getStatusCodeValue();
						if (statusCode == 200) {
							layuiTableData = responseEntity.getBody();
						}
						JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
						System.out.println(">>>>>>>>>>>>>home_project_table_data:" + result.toString());
						return result.toString();
					}
				
				    
				    /**=====================================按数量==============================*/
				    
				    
				    
				    
				    
				@RequestMapping(method = RequestMethod.GET, value = "/getProjectByCountBar")
				@ResponseBody
				public String getProjectByCountBar(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
						ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getProjectByCountBar, HttpMethod.POST, entity, JSONArray.class);
						int statusCode = responseEntity.getStatusCodeValue();
						if (statusCode == 200) 
						{
							JSONArray jSONArray = responseEntity.getBody();
							System.out.println(">>>>>>>>>>>>>>getProjectByCountBar jSONArray-> " + jSONArray.toString());
							
							List<H1AMKYSY100109> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100109.class);
							List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"g0XMGLLX");
			         		barLine.setxAxisDataList(xAxisDataList);
			         	
							List<String> legendDataList = new ArrayList<String>();
							legendDataList.add("新开课题");
							legendDataList.add("结转课题");
							barLine.setxAxisDataList(xAxisDataList);
							barLine.setLegendDataList(legendDataList);
							// X轴数据
							List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
							ChartBarLineSeries s1 = HanaUtil.getHomeProjectLevel2ChartBarLineSeries(list, "K0BNXMXKSL");
							ChartBarLineSeries s2 = HanaUtil.getHomeProjectLevel2ChartBarLineSeries(list, "K0BNXMXJSL");
							
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
					System.out.println(">>>>>>>>>>>>>>getProjectByCountBar " + resultObj.toString());
					return resultObj.toString();
				}
				
				
				@RequestMapping(method = RequestMethod.GET, value = "/getProjectByCountPie")
				@ResponseBody
				public String getProjectByCountPie(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
						ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getProjectByCountPie, HttpMethod.POST, entity, JSONArray.class);
						int statusCode = responseEntity.getStatusCodeValue();
						if (statusCode == 200) 
						{
							JSONArray jSONArray = responseEntity.getBody();
							System.out.println(">>>>>>>>>>>>>>getProjectByCountPie jSONArray-> " + jSONArray.toString());
							List<H1AMKYSY100109> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100109.class);
							ChartPieResultData pie = new ChartPieResultData();
							List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
							List<String> legendDataList = new ArrayList<String>();
							for (int i = 0; i < list.size(); i++) {
								H1AMKYSY100109 f2 = list.get(i);
								String name = f2.getG0XMGLLX();
								String value = f2.getK0BNXMXKSLK0BNXMXJSL();
								
								
								legendDataList.add(name);
								
								if(value!=null && !value.equals(""))
								{
									dataList.add(new ChartPieDataValue(Double.valueOf(value).intValue(), name));
								}else
								{
									dataList.add(new ChartPieDataValue(0, name));
								}
								
								
								
								
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
					System.out.println(">>>>>>>>>>>>>>>getProjectByCountPie " + resultObj.toString());
					return resultObj.toString();
				}
				
				
				
				@RequestMapping(method = RequestMethod.GET, value = "/getProjectByCountCricle")
				@ResponseBody
				public String getProjectByCountCricle(HttpServletRequest request, HttpServletResponse response) throws Exception {

					PageResult pageResult = new PageResult();
					String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
					String companyCode = CommonUtil.getParameter(request, "companyCode", "");
					Map<String, Object> paramsMap = new HashMap<String, Object>();
					paramsMap.put("month", month);
					paramsMap.put("companyCode", companyCode);
					JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
					HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
					
						ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getProjectByCountCricle, HttpMethod.POST, entity, JSONArray.class);
						int statusCode = responseEntity.getStatusCodeValue();
						if (statusCode == 200) 
						{
							JSONArray jSONArray = responseEntity.getBody();
							List<H1AMKYSY100109> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100109.class);
							List<String>  lista=HanaUtil.getduplicatexAxisByList(list,"g0XMXZ");
							List<TreeNode2>  chartCircleList=	HanaUtil.getChildChartCircleForproject(lista,list);
							
							
							pageResult.setData(chartCircleList);
							pageResult.setCode(0);
							pageResult.setCount(Long.valueOf(chartCircleList.size()));
							pageResult.setLimit(1000);
							pageResult.setPage(1l);
							
							
						}
						
					
					JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
					System.out.println(">>>>>>>>>>>>>>>getProjectByCountCricle " + resultObj.toString());
					return resultObj.toString();
				}
				
				
				
				
				
				
				
				
            /**=====================================按单位==============================*/
				
				
			    
							@RequestMapping(method = RequestMethod.GET, value = "/getProjectByUnitBar")
							@ResponseBody
							public String getProjectByUnitBar(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
									ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getProjectByUnitBar, HttpMethod.POST, entity, JSONArray.class);
									int statusCode = responseEntity.getStatusCodeValue();
									if (statusCode == 200) 
									{
										JSONArray jSONArray = responseEntity.getBody();
										System.out.println(">>>>>>>>>>>>>>getProjectByUnitBar jSONArray-> " + jSONArray.toString());
										
										List<H1AMKYSY100109> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100109.class);
										List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"g0GSSP");
						         		barLine.setxAxisDataList(xAxisDataList);
						         	
										List<String> legendDataList = new ArrayList<String>();
										legendDataList.add("新开课题");
										legendDataList.add("结转课题");
										barLine.setxAxisDataList(xAxisDataList);
										barLine.setLegendDataList(legendDataList);
										// X轴数据
										List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
										ChartBarLineSeries s1 = HanaUtil.getChartBarLineSeries_Project_bar(list, "K0BNXMXKSL");
										ChartBarLineSeries s2 = HanaUtil.getChartBarLineSeries_Project_bar(list, "K0BNXMXJSL");
										
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
								System.out.println(">>>>>>>>>>>>>>getProjectByUnitBar " + resultObj.toString());
								return resultObj.toString();
							}
							
							
							@RequestMapping(method = RequestMethod.GET, value = "/getProjectByUnitPie")
							@ResponseBody
							public String getProjectByUnitPie(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
									ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getProjectByUnitPie, HttpMethod.POST, entity, JSONArray.class);
									int statusCode = responseEntity.getStatusCodeValue();
									if (statusCode == 200) 
									{
										JSONArray jSONArray = responseEntity.getBody();
										System.out.println(">>>>>>>>>>>>>>getProjectByUnitPie jSONArray-> " + jSONArray.toString());
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
								System.out.println(">>>>>>>>>>>>>>>getProjectByUnitPie " + resultObj.toString());
								return resultObj.toString();
							}
							
							
							
							
							@RequestMapping(method = RequestMethod.GET, value = "/getProjectByUnitCricle")
							@ResponseBody
							public String getProjectByUnitCricle(HttpServletRequest request, HttpServletResponse response) throws Exception {

								PageResult pageResult = new PageResult();
								String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
								String companyCode = CommonUtil.getParameter(request, "companyCode", "");
								Map<String, Object> paramsMap = new HashMap<String, Object>();
								paramsMap.put("month", month);
								paramsMap.put("companyCode", companyCode);
								JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
								HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
								
									ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getProjectByUnitCricle, HttpMethod.POST, entity, JSONArray.class);
									int statusCode = responseEntity.getStatusCodeValue();
									if (statusCode == 200) 
									{
										JSONArray jSONArray = responseEntity.getBody();
										List<H1AMKYSY100109> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100109.class);
										List<String>  lista=HanaUtil.getduplicatexAxisByList(list,"g0XMXZ");
										List<TreeNode2>  chartCircleList=	HanaUtil.getChildChartCircleuNITForproject(lista,list);
										
										
										pageResult.setData(chartCircleList);
										pageResult.setCode(0);
										pageResult.setCount(Long.valueOf(chartCircleList.size()));
										pageResult.setLimit(1000);
										pageResult.setPage(1l);
										
										
									}
									
								
								JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
								System.out.println(">>>>>>>>>>>>>>>getProjectByCountCricle " + resultObj.toString());
								return resultObj.toString();
							}
							
							
							
							/*@RequestMapping(method = RequestMethod.GET, value = "/getProjectByUnitCricle")
							@ResponseBody
							public String getProjectByUnitCricle(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
									ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getProjectByUnitCricle, HttpMethod.POST, entity, JSONArray.class);
									int statusCode = responseEntity.getStatusCodeValue();
									if (statusCode == 200) 
									{
										JSONArray jSONArray = responseEntity.getBody();
										List<H1AMKYSY100109> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100109.class);
										List<String>  lista=HanaUtil.getduplicatexAxisByList(list,"g0XMXZ");
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
								System.out.println(">>>>>>>>>>>>>>>getProjectByUnitCricle " + resultObj.toString());
								return resultObj.toString();
							}
							
							*/
							
				
				
				
				
				
				
				
				
							@RequestMapping(method = RequestMethod.GET, value = "/getProjectByDistributeBar")
							@ResponseBody
							public String getProjectByDistributeBar(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
									ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getProjectByDistributeBar, HttpMethod.POST, entity, JSONArray.class);
									int statusCode = responseEntity.getStatusCodeValue();
									if (statusCode == 200) 
									{
										JSONArray jSONArray = responseEntity.getBody();
										System.out.println(">>>>>>>>>>>>>>getProjectByDistributeBar jSONArray-> " + jSONArray.toString());
										
										List<H1AMKYSY100109> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100109.class);
										List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"g0GSJC");
						         		barLine.setxAxisDataList(xAxisDataList);
						         	
										List<String> legendDataList = new ArrayList<String>();
										legendDataList.add("新开课题");
										legendDataList.add("结转课题");
										legendDataList.add("完工项目");
										legendDataList.add("延期项目");
										legendDataList.add("应结未结");
										barLine.setxAxisDataList(xAxisDataList);
										barLine.setLegendDataList(legendDataList);
										// X轴数据
										List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
										ChartBarLineSeries s1 = HanaUtil.getChartBarLineSeries_Project_bar(list, "K0BNXMXKSL");
										ChartBarLineSeries s2 = HanaUtil.getChartBarLineSeries_Project_bar(list, "K0BNXMXJSL");
										ChartBarLineSeries s3 = HanaUtil.getChartBarLineSeries_Project_bar(list, "K0BNXMWGSL");
										ChartBarLineSeries s4 = HanaUtil.getChartBarLineSeries_Project_bar(list, "K0BNXMYQSL");
										ChartBarLineSeries s5 = HanaUtil.getChartBarLineSeries_Project_bar(list, "K0BNXMWJSL");
										
										seriesList.add(s1);
										seriesList.add(s2);
										seriesList.add(s3);
										seriesList.add(s4);
										seriesList.add(s5);
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
								System.out.println(">>>>>>>>>>>>>>getProjectByDistributeBar " + resultObj.toString());
								return resultObj.toString();
							}
				
				
					
					
				
				
	  
	  
	  
}
