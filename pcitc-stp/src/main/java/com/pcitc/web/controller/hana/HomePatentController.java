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
import com.pcitc.base.common.ChartCircle;
import com.pcitc.base.common.ChartCircle2;
import com.pcitc.base.common.ChartPieDataValue;
import com.pcitc.base.common.ChartPieResultData;
import com.pcitc.base.common.ChartSingleLineResultData;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.hana.report.Award;
import com.pcitc.base.hana.report.H1AMKYSY100104;
import com.pcitc.base.hana.report.H1AMKYSY100109;
import com.pcitc.base.hana.report.Knowledge;
import com.pcitc.base.hana.report.ProjectCode;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.web.utils.HanaUtil;

@Controller
@RequestMapping(value = "/home_patent")
public class HomePatentController {
	
	private static final String getPatentByCountBar =      "http://pcitc-zuul/hana-proxy/hana/home/getPatentByCountBar";
	private static final String getPatentByCountPie =      "http://pcitc-zuul/hana-proxy/hana/home/getPatentByCountPie";
	private static final String getPatentByCountCricle =   "http://pcitc-zuul/hana-proxy/hana/home/getPatentByCountCricle";
	private static final String getPatentByUnitBar =       "http://pcitc-zuul/hana-proxy/hana/home/getPatentByUnitBar";
	private static final String getPatentByUnitPie =       "http://pcitc-zuul/hana-proxy/hana/home/getPatentByUnitPie";
	private static final String getPatentByUnitCricle =    "http://pcitc-zuul/hana-proxy/hana/home/getPatentByUnitCricle";
	private static final String getPatentByDistributeBar = "http://pcitc-zuul/hana-proxy/hana/home/getPatentByDistributeBar";
	private static final String getPatentTable = "http://pcitc-zuul/hana-proxy/hana/home/getPatentTable";
	
	
	
	
	@Autowired
	private HttpHeaders httpHeaders;
	
	@Autowired
	private RestTemplate restTemplate;
	
				
				/**=====================================专利分析二级页面===============================*/
				
				@RequestMapping(method = RequestMethod.GET, value = "/home_patent")
				  public String kyzb_level2(HttpServletRequest request) throws Exception
				  {
					    
						
					    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
					    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
					    String unitCode=userInfo.getUnitCode();
					    request.setAttribute("unitCode", unitCode);
				        return "stp/hana/home/home_patent";
				  }
				
			
				 @RequestMapping(method = RequestMethod.GET, value = "/home_patent_table")
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
					    
				        return "stp/hana/home/home_patent_table";
				  }
				
				
				    //三级表格
				    @RequestMapping(method = RequestMethod.POST, value = "/home_patent_table_data")
					@ResponseBody
					public String home_patent_table_data(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {


						LayuiTableData layuiTableData = new LayuiTableData();
						HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
						ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(getPatentTable, HttpMethod.POST, entity, LayuiTableData.class);
						int statusCode = responseEntity.getStatusCodeValue();
						if (statusCode == 200) {
							layuiTableData = responseEntity.getBody();
						}
						JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
						System.out.println(">>>>>>>>>>>>>home_patent_table_data:" + result.toString());
						return result.toString();
					}
				
				    
				    /**=====================================按数量==============================*/
				    
				    
				    
				    
				    
				@RequestMapping(method = RequestMethod.GET, value = "/getPatentByCountBar")
				@ResponseBody
				public String getPatentByCountBar(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
						ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getPatentByCountBar, HttpMethod.POST, entity, JSONArray.class);
						int statusCode = responseEntity.getStatusCodeValue();
						if (statusCode == 200) 
						{
							JSONArray jSONArray = responseEntity.getBody();
							System.out.println(">>>>>>>>>>>>>>getPatentByCountBar jSONArray-> " + jSONArray.toString());
							
							List<H1AMKYSY100104> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100104.class);
							List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"g0GSJC");
			         		barLine.setxAxisDataList(xAxisDataList);
			         	
							List<String> legendDataList = new ArrayList<String>();
							legendDataList.add("经费下达");
							legendDataList.add("实际经费");
							barLine.setxAxisDataList(xAxisDataList);
							barLine.setLegendDataList(legendDataList);
							// X轴数据
							List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
							ChartBarLineSeries s1 = HanaUtil.getJFZCLevel2ChartBarLineSeries(list, "K0BNYSJHJE");
							ChartBarLineSeries s2 = HanaUtil.getJFZCLevel2ChartBarLineSeries(list, "K0BNGLFPHJECB");
							
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
					System.out.println(">>>>>>>>>>>>>>getPatentByCountBar " + resultObj.toString());
					return resultObj.toString();
				}
				
				
				@RequestMapping(method = RequestMethod.GET, value = "/getPatentByCountPie")
				@ResponseBody
				public String getPatentByCountPie(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
						ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getPatentByCountPie, HttpMethod.POST, entity, JSONArray.class);
						int statusCode = responseEntity.getStatusCodeValue();
						if (statusCode == 200) 
						{
							JSONArray jSONArray = responseEntity.getBody();
							System.out.println(">>>>>>>>>>>>>>getPatentByCountPie jSONArray-> " + jSONArray.toString());
							List<H1AMKYSY100104> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100104.class);
							ChartPieResultData pie = new ChartPieResultData();
							List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
							List<String> legendDataList = new ArrayList<String>();
							for (int i = 0; i < list.size(); i++) {
								H1AMKYSY100104 f2 = list.get(i);
								String name = f2.getG0GSJC();
								String value = f2.getK0BNGLFPHJECB();
								
								DecimalFormat decimalFormat=new DecimalFormat(".00");
								value=decimalFormat.format(Float.valueOf(value));
								
								legendDataList.add(name);
								dataList.add(new ChartPieDataValue(value, name));
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
					System.out.println(">>>>>>>>>>>>>>>getPatentByCountPie " + resultObj.toString());
					return resultObj.toString();
				}
				
				
				
				@RequestMapping(method = RequestMethod.GET, value = "/getPatentByCountCricle")
				@ResponseBody
				public String getPatentByCountCricle(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
						ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getPatentByCountCricle, HttpMethod.POST, entity, JSONArray.class);
						int statusCode = responseEntity.getStatusCodeValue();
						if (statusCode == 200) 
						{
							JSONArray jSONArray = responseEntity.getBody();
							List<H1AMKYSY100104> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100104.class);
							List<String>  lista=HanaUtil.getduplicatexAxisByList(list,"g0XMGLLX");
							List<ChartCircle>  chartCircleList=	HanaUtil.getChildChartCircleForJFZC(lista,list);
							result.setSuccess(true);
							result.setData(chartCircleList);
						}
						
					} else
					{
						result.setSuccess(false);
						result.setMessage("参数为空");
					}
					JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
					System.out.println(">>>>>>>>>>>>>>>getPatentByCountCricle " + resultObj.toString());
					return resultObj.toString();
				}
				
				
				
				
				
				
				
				
            /**=====================================按单位==============================*/
				
				
			    
							@RequestMapping(method = RequestMethod.GET, value = "/getPatentByUnitBar")
							@ResponseBody
							public String getPatentByUnitBar(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
									ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getPatentByUnitBar, HttpMethod.POST, entity, JSONArray.class);
									int statusCode = responseEntity.getStatusCodeValue();
									if (statusCode == 200) 
									{
										JSONArray jSONArray = responseEntity.getBody();
										System.out.println(">>>>>>>>>>>>>>getPatentByUnitBar jSONArray-> " + jSONArray.toString());
										
										List<H1AMKYSY100104> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100104.class);
										List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"g0GSJC");
						         		barLine.setxAxisDataList(xAxisDataList);
						         	
										List<String> legendDataList = new ArrayList<String>();
										legendDataList.add("经费下达");
										legendDataList.add("实际经费");
										barLine.setxAxisDataList(xAxisDataList);
										barLine.setLegendDataList(legendDataList);
										// X轴数据
										List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
										ChartBarLineSeries s1 = HanaUtil.getJFZCLevel2ChartBarLineSeries(list, "K0BNYSJHJE");
										ChartBarLineSeries s2 = HanaUtil.getJFZCLevel2ChartBarLineSeries(list, "K0BNGLFPHJECB");
										
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
								System.out.println(">>>>>>>>>>>>>>getPatentByUnitBar " + resultObj.toString());
								return resultObj.toString();
							}
							
							
							@RequestMapping(method = RequestMethod.GET, value = "/getPatentByUnitPie")
							@ResponseBody
							public String getPatentByUnitPie(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
									ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getPatentByUnitPie, HttpMethod.POST, entity, JSONArray.class);
									int statusCode = responseEntity.getStatusCodeValue();
									if (statusCode == 200) 
									{
										JSONArray jSONArray = responseEntity.getBody();
										System.out.println(">>>>>>>>>>>>>>getPatentByUnitPie jSONArray-> " + jSONArray.toString());
										List<H1AMKYSY100104> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100104.class);
										ChartPieResultData pie = new ChartPieResultData();
										List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
										List<String> legendDataList = new ArrayList<String>();
										for (int i = 0; i < list.size(); i++) {
											H1AMKYSY100104 f2 = list.get(i);
											String name = f2.getG0GSJC();
											String value = f2.getK0BNGLFPHJECB();
											
											DecimalFormat decimalFormat=new DecimalFormat(".00");
											value=decimalFormat.format(Float.valueOf(value));
											
											legendDataList.add(name);
											dataList.add(new ChartPieDataValue(value, name));
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
								System.out.println(">>>>>>>>>>>>>>>getPatentByUnitPie " + resultObj.toString());
								return resultObj.toString();
							}
							
							
							
							@RequestMapping(method = RequestMethod.GET, value = "/getPatentByUnitCricle")
							@ResponseBody
							public String getPatentByUnitCricle(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
									ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getPatentByUnitCricle, HttpMethod.POST, entity, JSONArray.class);
									int statusCode = responseEntity.getStatusCodeValue();
									if (statusCode == 200) 
									{
										JSONArray jSONArray = responseEntity.getBody();
										List<H1AMKYSY100104> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100104.class);
										List<String>  lista=HanaUtil.getduplicatexAxisByList(list,"g0XMGLLX");
										List<ChartCircle>  chartCircleList=	HanaUtil.getChildChartCircleForJFZC(lista,list);
										result.setSuccess(true);
										result.setData(chartCircleList);
									}
									
								} else
								{
									result.setSuccess(false);
									result.setMessage("参数为空");
								}
								JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
								System.out.println(">>>>>>>>>>>>>>>getPatentByUnitCricle " + resultObj.toString());
								return resultObj.toString();
							}
							
							
							
				
				
				
				
				
				
				
				
							@RequestMapping(method = RequestMethod.GET, value = "/getPatentByDistributeBar")
							@ResponseBody
							public String getPatentByDistributeBar(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
									ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getPatentByDistributeBar, HttpMethod.POST, entity, JSONArray.class);
									int statusCode = responseEntity.getStatusCodeValue();
									if (statusCode == 200) 
									{
										JSONArray jSONArray = responseEntity.getBody();
										System.out.println(">>>>>>>>>>>>>>getPatentByDistributeBar jSONArray-> " + jSONArray.toString());
										
										List<H1AMKYSY100104> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100104.class);
										List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"g0GSJC");
						         		barLine.setxAxisDataList(xAxisDataList);
						         	
										List<String> legendDataList = new ArrayList<String>();
										legendDataList.add("经费下达");
										legendDataList.add("实际经费");
										barLine.setxAxisDataList(xAxisDataList);
										barLine.setLegendDataList(legendDataList);
										// X轴数据
										List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
										ChartBarLineSeries s1 = HanaUtil.getJFZCLevel2ChartBarLineSeries(list, "K0BNYSJHJE");
										ChartBarLineSeries s2 = HanaUtil.getJFZCLevel2ChartBarLineSeries(list, "K0BNGLFPHJECB");
										
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
								System.out.println(">>>>>>>>>>>>>>getPatentByDistributeBar " + resultObj.toString());
								return resultObj.toString();
							}
				
				
					
					
				
				
	  
	  
	  
}
