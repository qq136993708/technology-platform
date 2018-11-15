
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
import com.pcitc.base.common.ChartPieDataValue;
import com.pcitc.base.common.ChartPieResultData;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.PageResult;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.TreeNode2;
import com.pcitc.base.hana.report.BudgetMysql;
import com.pcitc.base.hana.report.H1AMKYSY100109;
import com.pcitc.base.hana.report.H1AMKYZH100006;
import com.pcitc.base.hana.report.ProjectCode;
import com.pcitc.base.hana.report.ProjectForMysql;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.web.utils.HanaUtil;

@Controller
@RequestMapping(value = "/home_device_02")
public class HomeDeviceMsqlController {
	
	private static final String getDeviceByCountBar =      "http://pcitc-zuul/system-proxy/out-project-provider/project-count/zb/project-type";
	private static final String getDeviceByCountPie =      "http://pcitc-zuul/system-proxy/out-project-provider/project-count/zb/project-type";
	private static final String getDeviceByCountCricle =   "http://pcitc-zuul/system-proxy/out-project-provider/project-count/zb/type/tree";
	private static final String getDeviceByUnitBar =       "http://pcitc-zuul/system-proxy/out-project-provider/type/zb/unit/list";
	private static final String getDeviceByUnitPie =       "http://pcitc-zuul/hana-proxy/hana/home/getDeviceByUnitPie";
	private static final String getDeviceByUnitCricle =    "http://pcitc-zuul/system-proxy/out-project-provider/project-count/zb/unit/tree";
	private static final String getDeviceByDistributeBar = "http://pcitc-zuul/system-proxy/out-project-provider/project-info/zb/unit";
	private static final String getDeviceTable = "http://pcitc-zuul/hana-proxy/hana/home/getDeviceTable";
	
	

	
	
	@Autowired
	private HttpHeaders httpHeaders;
	
	@Autowired
	private RestTemplate restTemplate;
	
				
				/**=====================================科研项目二级页面===============================*/
				
				@RequestMapping(method = RequestMethod.GET, value = "/home_device")
				  public String kyzb_level2(HttpServletRequest request) throws Exception
				  {
					    
						
					    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
					    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
					    String unitCode=userInfo.getUnitCode();
					    request.setAttribute("unitCode", unitCode);
					    String year= HanaUtil.getCurrrentYear();
					    request.setAttribute("year", year);
				        return "stp/hana/home/level/home_device_02";
				  }
				
			
				 @RequestMapping(method = RequestMethod.GET, value = "/home_device_table")
				  public String home_device_table(HttpServletRequest request) throws Exception
				  {
					    
						String month = HanaUtil.getCurrrentYearMoth();
						request.setAttribute("month", month);
						String g0XMGLLX=CommonUtil.getParameter(request, "g0XMGLLX", "");
						request.setAttribute("g0XMGLLX", g0XMGLLX);
						
						
						String g0GSSP=CommonUtil.getParameter(request, "g0GSSP", "");
						request.setAttribute("g0GSSP", g0GSSP);
						
						
						
						
					    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
					    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
					    
					    
					    String companyCode=CommonUtil.getParameter(request, "companyCode", "");
						request.setAttribute("companyCode", companyCode);
						
						
					    String unitCode=userInfo.getUnitCode();
					    request.setAttribute("unitCode", unitCode);
					    
					    List<H1AMKYZH100006> ALL_DIC_LIST=HanaUtil.getBaseCodeDic(restTemplate, httpHeaders, month);
					    //项目类型   
					    List<String>  G0XMGLLX_LIST=HanaUtil.getduplicatexAxisByList(ALL_DIC_LIST,"g0XMGLLX");
					    //项目来源
					    List<String>  G0XMGLLY_LIST=HanaUtil.getduplicatexAxisByList(ALL_DIC_LIST,"g0XMGLLY");
					     //管理级别
					    List<String>  G0XMGLJB_LIST=HanaUtil.getduplicatexAxisByList(ALL_DIC_LIST,"g0XMGLJB");
					    //项目类别
					    List<String>  G0XMLX_LIST=HanaUtil.getduplicatexAxisByList(ALL_DIC_LIST,"g0XMLX");
					    
					    request.setAttribute("G0XMGLLX_LIST", G0XMGLLX_LIST);
					    request.setAttribute("G0XMGLLY_LIST", G0XMGLLY_LIST);
					    request.setAttribute("G0XMGLJB_LIST", G0XMGLJB_LIST);
					    request.setAttribute("G0XMLX_LIST", G0XMLX_LIST);
					    
					    
					    //结转课题
					    List<ProjectCode> G0XMXZ_LIST=HanaUtil.getBaseCode(restTemplate, httpHeaders, month, "G0XMXZ");
					    //应结题未结题
					    List<ProjectCode> G0XMJD_LIST=HanaUtil.getBaseCode(restTemplate, httpHeaders, month, "G0XMJD");
					    
					    request.setAttribute("G0XMXZ_LIST", G0XMXZ_LIST);
					    request.setAttribute("G0XMJD_LIST", G0XMJD_LIST);
					    
					    //项目类型:G0XMGLLX ,项目来源:G0XMGLLY,管理级别:G0XMGLJB,项目类别:G0XMLX,项目状态:G0XMZT
					   /* List<ProjectCode> G0XMGLLX_LIST=HanaUtil.getBaseCode(restTemplate, httpHeaders, month, "G0XMGLLX");
					    List<ProjectCode> G0XMGLLY_LIST=HanaUtil.getBaseCode(restTemplate, httpHeaders, month, "G0XMGLLY");
					    List<ProjectCode> G0XMGLJB_LIST=HanaUtil.getBaseCode(restTemplate, httpHeaders, month, "G0XMGLJB");
					    List<ProjectCode> G0XMLX_LIST=HanaUtil.getBaseCode(restTemplate, httpHeaders, month, "G0XMLXMS");
					    List<ProjectCode> G0XMZT_LIST=HanaUtil.getBaseCode(restTemplate, httpHeaders, month, "G0XMZTMS");
					    
					    request.setAttribute("G0XMGLLX_LIST", G0XMGLLX_LIST);
					    request.setAttribute("G0XMGLLY_LIST", G0XMGLLY_LIST);
					    request.setAttribute("G0XMGLJB_LIST", G0XMGLJB_LIST);
					    request.setAttribute("G0XMLX_LIST", G0XMLX_LIST);
					    request.setAttribute("G0XMZT_LIST", G0XMZT_LIST);*/
					    
				        return "stp/hana/home/level/home_device_table";
				  }
				
				
				    //三级表格
				    @RequestMapping(method = RequestMethod.POST, value = "/home_device_table_data")
					@ResponseBody
					public String home_device_table_data(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {


						LayuiTableData layuiTableData = new LayuiTableData();
						HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
						ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(getDeviceTable, HttpMethod.POST, entity, LayuiTableData.class);
						int statusCode = responseEntity.getStatusCodeValue();
						if (statusCode == 200) {
							layuiTableData = responseEntity.getBody();
						}
						JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
						System.out.println(">>>>>>>>>>>>>home_device_table_data:" + result.toString());
						return result.toString();
					}
				
				    
				    /**=====================================按数量==============================*/
				    
				    
				    
				    
				    
				@RequestMapping(method = RequestMethod.GET, value = "/getDeviceByCountBar")
				@ResponseBody
				public String getDeviceByCountBar(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
						ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getDeviceByCountBar, HttpMethod.POST, entity, JSONArray.class);
						int statusCode = responseEntity.getStatusCodeValue();
						if (statusCode == 200) 
						{
							JSONArray jSONArray = responseEntity.getBody();
							System.out.println(">>>>>>>>>>>>>>getProjectByCountBar jSONArray-> " + jSONArray.toString());
							
							List<ProjectForMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), ProjectForMysql.class);
							List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"zylb");
			         		barLine.setxAxisDataList(xAxisDataList);
			         	
							List<String> legendDataList = new ArrayList<String>();
							legendDataList.add("新开课题");
							legendDataList.add("结转课题");
							barLine.setxAxisDataList(xAxisDataList);
							barLine.setLegendDataList(legendDataList);
							// X轴数据
							List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
							ChartBarLineSeries s1 = HanaUtil.getDeviceForMysqlChartBarLineSeries(list, "xksl");
							ChartBarLineSeries s2 = HanaUtil.getDeviceForMysqlChartBarLineSeries(list, "xjsl");
							
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
					System.out.println(">>>>>>>>>>>>>>getDeviceByCountBar " + resultObj.toString());
					return resultObj.toString();
				}
				
				
				@RequestMapping(method = RequestMethod.GET, value = "/getDeviceByCountPie")
				@ResponseBody
				public String getDeviceByCountPie(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
						ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getDeviceByCountPie, HttpMethod.POST, entity, JSONArray.class);
						int statusCode = responseEntity.getStatusCodeValue();
						if (statusCode == 200) 
						{
							JSONArray jSONArray = responseEntity.getBody();
							System.out.println(">>>>>>>>>>>>>>getProjectByCountPie jSONArray-> " + jSONArray.toString());
							List<ProjectForMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), ProjectForMysql.class);
							ChartPieResultData pie = new ChartPieResultData();
							List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
							List<String> legendDataList = new ArrayList<String>();
							for (int i = 0; i < list.size(); i++) {
								ProjectForMysql f2 = list.get(i);
								String name = f2.getZylb();
								Integer value = (Integer)f2.getZsl();
								
								
								legendDataList.add(name);
								
								if(value!=null )
								{
									dataList.add(new ChartPieDataValue(value, name));
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
					System.out.println(">>>>>>>>>>>>>>>getDeviceByCountPie " + resultObj.toString());
					return resultObj.toString();
				}
				
				
				
				@RequestMapping(method = RequestMethod.GET, value = "/getDeviceByCountCricle")
				@ResponseBody
				public String getDeviceByCountCricle(HttpServletRequest request, HttpServletResponse response) throws Exception {

					PageResult pageResult = new PageResult();
					String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
					String companyCode = CommonUtil.getParameter(request, "companyCode", "");
					Map<String, Object> paramsMap = new HashMap<String, Object>();
					paramsMap.put("month", month);
					paramsMap.put("companyCode", companyCode);
					JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
					HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
					
						ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getDeviceByCountCricle, HttpMethod.POST, entity, JSONArray.class);
						int statusCode = responseEntity.getStatusCodeValue();
						if (statusCode == 200) 
						{
                            JSONArray jSONArray = responseEntity.getBody();
							System.out.println(">>>>>>>>>>>>>>>getProjectByCountCricle jSONArray" + jSONArray.toString());
							List<ProjectForMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), ProjectForMysql.class);
							List<String>  lista=HanaUtil.getduplicatexAxisByList(list,"project_scope");
							List<TreeNode2>  chartCircleList=	HanaUtil.getChildChartCircleuNITForproject02type(lista,list);
							pageResult.setData(chartCircleList);
							pageResult.setCode(0);
							pageResult.setCount(Long.valueOf(chartCircleList.size()));
							pageResult.setLimit(1000);
							pageResult.setPage(1l);
							
						}
						
					
					JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
					System.out.println(">>>>>>>>>>>>>>>getDeviceByCountCricle " + resultObj.toString());
					return resultObj.toString();
				}
				
				
				/*@RequestMapping(method = RequestMethod.GET, value = "/getDeviceByCountCricle")
				@ResponseBody
				public String getDeviceByCountCricle(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
						ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getDeviceByCountCricle, HttpMethod.POST, entity, JSONArray.class);
						int statusCode = responseEntity.getStatusCodeValue();
						if (statusCode == 200) 
						{
							JSONArray jSONArray = responseEntity.getBody();
							List<H1AMKYSY100109> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100109.class);
							List<String>  lista=HanaUtil.getduplicatexAxisByList(list,"g0XMXZ");
							List<TreeNode2>  chartCircleList=	HanaUtil.getChildChartCircleForproject(lista,list);
							result.setSuccess(true);
							result.setData(chartCircleList);
						}
						
					} else
					{
						result.setSuccess(false);
						result.setMessage("参数为空");
					}
					JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
					System.out.println(">>>>>>>>>>>>>>>getDeviceByCountCricle " + resultObj.toString());
					return resultObj.toString();
				}
				*/
				
				
				
				
				
				
				
            /**=====================================按单位==============================*/
				
				
			    
							@RequestMapping(method = RequestMethod.GET, value = "/getDeviceByUnitBar")
							@ResponseBody
							public String getDeviceByUnitBar(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
									ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getDeviceByUnitBar, HttpMethod.POST, entity, JSONArray.class);
									int statusCode = responseEntity.getStatusCodeValue();
									if (statusCode == 200) 
									{
										JSONArray jSONArray = responseEntity.getBody();
										System.out.println(">>>>>>>>>>>>>>getDeviceByUnitBar jSONArray-> " + jSONArray.toString());
										
										List<ProjectForMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), ProjectForMysql.class);
										List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"type_flag");
						         		barLine.setxAxisDataList(xAxisDataList);
						         	
										List<String> legendDataList = new ArrayList<String>();
										legendDataList.add("新开课题");
										legendDataList.add("结转课题");
										barLine.setxAxisDataList(xAxisDataList);
										barLine.setLegendDataList(legendDataList);
										// X轴数据 
										List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
										ChartBarLineSeries s1 = HanaUtil.getdevceForMysqlChartBarLineSeries(list, "xksl");
										ChartBarLineSeries s2 = HanaUtil.getdevceForMysqlChartBarLineSeries(list, "xjsl");
										
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
								System.out.println(">>>>>>>>>>>>>>getDeviceByUnitBar " + resultObj.toString());
								return resultObj.toString();
							}
							
							
							@RequestMapping(method = RequestMethod.GET, value = "/getDeviceByUnitPie")
							@ResponseBody
							public String getDeviceByUnitPie(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
									ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getDeviceByUnitPie, HttpMethod.POST, entity, JSONArray.class);
									int statusCode = responseEntity.getStatusCodeValue();
									if (statusCode == 200) 
									{
										JSONArray jSONArray = responseEntity.getBody();
										System.out.println(">>>>>>>>>>>>>>getDeviceByUnitPie jSONArray-> " + jSONArray.toString());
										List<H1AMKYSY100109> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100109.class);
										ChartPieResultData pie = new ChartPieResultData();
										List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
										List<String> legendDataList = new ArrayList<String>();
										for (int i = 0; i < list.size(); i++) {
											H1AMKYSY100109 f2 = list.get(i);
											String name = f2.getG0GSSP();
											String value = f2.getK0XMZXSL();
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
								System.out.println(">>>>>>>>>>>>>>>getDeviceByUnitPie " + resultObj.toString());
								return resultObj.toString();
							}
							
							
							
							
							
							
							
							@RequestMapping(method = RequestMethod.GET, value = "/getDeviceByUnitCricle")
							@ResponseBody
							public String getDeviceByUnitCricle(HttpServletRequest request, HttpServletResponse response) throws Exception {

								PageResult pageResult = new PageResult();
								String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
								String companyCode = CommonUtil.getParameter(request, "companyCode", "");
								Map<String, Object> paramsMap = new HashMap<String, Object>();
								paramsMap.put("month", month);
								paramsMap.put("companyCode", companyCode);
								JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
								HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
								
									ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getDeviceByUnitCricle, HttpMethod.POST, entity, JSONArray.class);
									int statusCode = responseEntity.getStatusCodeValue();
									if (statusCode == 200) 
									{
										JSONArray jSONArray = responseEntity.getBody();
										
										System.out.println(">>>>>>>>>>>>>>>getDeviceByUnitCricle jSONArray " + jSONArray.toString());
										
										List<ProjectForMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), ProjectForMysql.class);
										List<String>  lista=HanaUtil.getduplicatexAxisByList(list,"project_scope");
										List<TreeNode2>  chartCircleList=	HanaUtil.getChildChartCircleuNITForDevice(lista,list);
										
										
										pageResult.setData(chartCircleList);
										pageResult.setCode(0);
										pageResult.setCount(Long.valueOf(chartCircleList.size()));
										pageResult.setLimit(1000);
										pageResult.setPage(1l);
										
										
									}
									
								
								JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
								System.out.println(">>>>>>>>>>>>>>>getDeviceByUnitCricle " + resultObj.toString());
								return resultObj.toString();
							}
							
				
							@RequestMapping(method = RequestMethod.GET, value = "/getDeviceByDistributeBar")
							@ResponseBody
							public String getDeviceByDistributeBar(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
									ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getDeviceByDistributeBar, HttpMethod.POST, entity, JSONArray.class);
									int statusCode = responseEntity.getStatusCodeValue();
									if (statusCode == 200) 
									{
										JSONArray jSONArray = responseEntity.getBody();
										System.out.println(">>>>>>>>>>>>>>getDeviceByDistributeBar jSONArray-> " + jSONArray.toString());
										
										List<ProjectForMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), ProjectForMysql.class);
										
										
										List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"define2");
						         		barLine.setxAxisDataList(xAxisDataList);
						         	
										List<String> legendDataList = new ArrayList<String>();
										legendDataList.add("新开课题");
										legendDataList.add("结转课题");
										
										barLine.setxAxisDataList(xAxisDataList);
										barLine.setLegendDataList(legendDataList);
										// X轴数据
										
										
										List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
										ChartBarLineSeries s1 = HanaUtil.getdevceForMysqlChartBarLineSeries(list, "xksl");
										ChartBarLineSeries s2 = HanaUtil.getdevceForMysqlChartBarLineSeries(list, "xjsl");
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
								System.out.println(">>>>>>>>>>>>>>getDeviceByDistributeBar " + resultObj.toString());
								return resultObj.toString();
							}
				
				
					
				
				
	  
	  
	  
}
