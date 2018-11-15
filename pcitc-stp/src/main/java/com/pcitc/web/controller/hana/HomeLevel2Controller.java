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
import com.pcitc.base.hana.report.Knowledge;
import com.pcitc.base.hana.report.ProjectCode;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.web.utils.HanaUtil;

@Controller
@RequestMapping(value = "/home_second")
public class HomeLevel2Controller {
	
	//经费支出二级页面
	private static final String getJFZCLevel2 = "http://pcitc-zuul/hana-proxy/hana/home/getJFZCLevel2";
	private static final String getJFZCLevel2Bar = "http://pcitc-zuul/hana-proxy/hana/home/getJFZCLevel2Bar";
	private static final String getJFZCLevel2Circle = "http://pcitc-zuul/hana-proxy/hana/home/getJFZCLevel2Circle";
	private static final String getJFZCLevel2TAble = "http://pcitc-zuul/hana-proxy/hana/home/getJFZCLevel2TAble";
	private static final String getJFZCLevel3TAble = "http://pcitc-zuul/hana-proxy/hana/home/getJFZCLevel3TAble";
	private static final String getJFXDPie = "http://pcitc-zuul/hana-proxy/hana/home/getJFXDPie";
	
	
	
	
	
	
	@Autowired
	private HttpHeaders httpHeaders;
	
	@Autowired
	private RestTemplate restTemplate;
	
				
				/**=====================================经费二级页面===============================*/
				
				
				
				@RequestMapping(method = RequestMethod.GET, value = "/jfzc_level2")
				  public String kyzb_level2(HttpServletRequest request) throws Exception
				  {
					    
						
					    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
					    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
					    String unitCode=userInfo.getUnitCode();
					    request.setAttribute("unitCode", unitCode);
				        return "stp/hana/home/jfzc_level2";
				  }
				
				//二级表格
				@RequestMapping(method = RequestMethod.POST, value = "/getJFZCLevel2TAble")
				@ResponseBody
				public String getKYZBTble(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {


					LayuiTableData layuiTableData = new LayuiTableData();
					HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
					ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(getJFZCLevel2TAble, HttpMethod.POST, entity, LayuiTableData.class);
					int statusCode = responseEntity.getStatusCodeValue();
					if (statusCode == 200) {
						layuiTableData = responseEntity.getBody();
					}
					JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
					System.out.println(">>>>>>>>>>>>>getKYZBTble:" + result.toString());
					return result.toString();
				}
				 @RequestMapping(method = RequestMethod.GET, value = "/jfzc_table")
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
					    
				        return "stp/hana/home/jfzc_table";
				  }
				
				
				   //三级表格
				   @RequestMapping(method = RequestMethod.POST, value = "/getJFZCLevel3TAble")
					@ResponseBody
					public String getJFZCLevel3TAble(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {


						LayuiTableData layuiTableData = new LayuiTableData();
						HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
						ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(getJFZCLevel3TAble, HttpMethod.POST, entity, LayuiTableData.class);
						int statusCode = responseEntity.getStatusCodeValue();
						if (statusCode == 200) {
							layuiTableData = responseEntity.getBody();
						}
						JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
						System.out.println(">>>>>>>>>>>>>getJFZCLevel3TAble:" + result.toString());
						return result.toString();
					}
				
				@RequestMapping(method = RequestMethod.GET, value = "/getJFZCLevel2")
				@ResponseBody
				public String getJFZCLevel2(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
						ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getJFZCLevel2, HttpMethod.POST, entity, JSONArray.class);
						int statusCode = responseEntity.getStatusCodeValue();
						if (statusCode == 200) 
						{
							JSONArray jSONArray = responseEntity.getBody();
							System.out.println(">>>>>>>>>>>>>>getJFZCLevel2 jSONArray-> " + jSONArray.toString());
							
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
					System.out.println(">>>>>>>>>>>>>>getJFZCLevel2 " + resultObj.toString());
					return resultObj.toString();
				}
				
				
				@RequestMapping(method = RequestMethod.GET, value = "/getJFZCLevel2Bar")
				@ResponseBody
				public String getJFZCLevel2Bar(HttpServletRequest request, HttpServletResponse response) throws Exception {

					Result result = new Result();
					String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
					String companyCode = CommonUtil.getParameter(request, "companyCode", "");
					String g0XMDL = CommonUtil.getParameter(request, "g0XMDL", "");
					Map<String, Object> paramsMap = new HashMap<String, Object>();
					paramsMap.put("month", month);
					paramsMap.put("companyCode", companyCode);
					paramsMap.put("g0XMDL", g0XMDL);
					JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
					HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
					if (!companyCode.equals(""))
					{
						ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getJFZCLevel2Bar, HttpMethod.POST, entity, JSONArray.class);
						int statusCode = responseEntity.getStatusCodeValue();
						if (statusCode == 200) 
						{
							JSONArray jSONArray = responseEntity.getBody();
							System.out.println(">>>>>>>>>>>>>>getJFZCLevel2Pie jSONArray-> " + jSONArray.toString());
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
					System.out.println(">>>>>>>>>>>>>>>getJFZCLevel2Pie " + resultObj.toString());
					return resultObj.toString();
				}
				
				
				
				@RequestMapping(method = RequestMethod.GET, value = "/getJFZCLevel2Circle")
				@ResponseBody
				public String getJFZCLevel2Circle(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
						ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getJFZCLevel2Circle, HttpMethod.POST, entity, JSONArray.class);
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
					System.out.println(">>>>>>>>>>>>>>>getJFZCLevel2Circle " + resultObj.toString());
					return resultObj.toString();
				}
				
				
				
				
				
				
				
				
            /**=====================================年度预算二级页面===============================*/
				
				
				
				@RequestMapping(method = RequestMethod.GET, value = "/ndys_level2")
				  public String ndys_level2(HttpServletRequest request) throws Exception
				  {
					    
						
					    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
					    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
					    String unitCode=userInfo.getUnitCode();
					    request.setAttribute("unitCode", unitCode);
				        return "stp/hana/home/ndys_level2";
				  }
				
				//二级表格
				@RequestMapping(method = RequestMethod.POST, value = "/getNdysLevel2TAble")
				@ResponseBody
				public String getNdysLevel2TAble(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {


					LayuiTableData layuiTableData = new LayuiTableData();
					HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
					ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(getJFZCLevel2TAble, HttpMethod.POST, entity, LayuiTableData.class);
					int statusCode = responseEntity.getStatusCodeValue();
					if (statusCode == 200) {
						layuiTableData = responseEntity.getBody();
					}
					JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
					System.out.println(">>>>>>>>>>>>>getKYZBTble:" + result.toString());
					return result.toString();
				}
				 @RequestMapping(method = RequestMethod.GET, value = "/ndys_table")
				  public String ndys_table(HttpServletRequest request) throws Exception
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
					    
				        return "stp/hana/home/ndys_table";
				  }
				
				
				   //三级表格
				   @RequestMapping(method = RequestMethod.POST, value = "/getNdysLevel3TAble")
					@ResponseBody
					public String getNdysLevel3TAble(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {


						LayuiTableData layuiTableData = new LayuiTableData();
						HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
						ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(getJFZCLevel3TAble, HttpMethod.POST, entity, LayuiTableData.class);
						int statusCode = responseEntity.getStatusCodeValue();
						if (statusCode == 200) {
							layuiTableData = responseEntity.getBody();
						}
						JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
						System.out.println(">>>>>>>>>>>>>getndysLevel3TAble:" + result.toString());
						return result.toString();
					}
				
				@RequestMapping(method = RequestMethod.GET, value = "/getNDYSLevel2")
				@ResponseBody
				public String getNDYSLevel2(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
						ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getJFZCLevel2, HttpMethod.POST, entity, JSONArray.class);
						int statusCode = responseEntity.getStatusCodeValue();
						if (statusCode == 200) 
						{
							JSONArray jSONArray = responseEntity.getBody();
							System.out.println(">>>>>>>>>>>>>>getNDYSLevel2 jSONArray-> " + jSONArray.toString());
							
							List<H1AMKYSY100104> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100104.class);
							List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"g0GSJC");
			         		barLine.setxAxisDataList(xAxisDataList);
			         	
							List<String> legendDataList = new ArrayList<String>();
							legendDataList.add("经费下达");
							barLine.setxAxisDataList(xAxisDataList);
							barLine.setLegendDataList(legendDataList);
							// X轴数据
							List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
							ChartBarLineSeries s1 = HanaUtil.getJFZCLevel2ChartBarLineSeries(list, "K0BNYSJHJE");
							seriesList.add(s1);
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
					System.out.println(">>>>>>>>>>>>>>getNDYSLevel2 " + resultObj.toString());
					return resultObj.toString();
				}
				
				//经费下达
				@RequestMapping(method = RequestMethod.GET, value = "/getNDYSLevel2Bar")
				@ResponseBody
				public String getNDYSLevel2Bar(HttpServletRequest request, HttpServletResponse response) throws Exception {

					Result result = new Result();
					String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
					String companyCode = CommonUtil.getParameter(request, "companyCode", "");
					String g0XMDL = CommonUtil.getParameter(request, "g0XMDL", "");
					Map<String, Object> paramsMap = new HashMap<String, Object>();
					paramsMap.put("month", month);
					paramsMap.put("companyCode", companyCode);
					paramsMap.put("g0XMDL", g0XMDL);
					JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
					HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
					if (!companyCode.equals(""))
					{
						ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getJFXDPie, HttpMethod.POST, entity, JSONArray.class);
						int statusCode = responseEntity.getStatusCodeValue();
						if (statusCode == 200) 
						{
							JSONArray jSONArray = responseEntity.getBody();
							System.out.println(">>>>>>>>>>>>>>getJFXDPie jSONArray-> " + jSONArray.toString());
							List<H1AMKYSY100104> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100104.class);
							ChartPieResultData pie = new ChartPieResultData();
							List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
							List<String> legendDataList = new ArrayList<String>();
							for (int i = 0; i < list.size(); i++) {
								H1AMKYSY100104 f2 = list.get(i);
								String name = f2.getG0GSJC();
								String value = f2.getK0BNYSJHJE();
								
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
					System.out.println(">>>>>>>>>>>>>>>getNDYSLevel2Bar " + resultObj.toString());
					return resultObj.toString();
				}
				
				
				
				@RequestMapping(method = RequestMethod.GET, value = "/getNDYSLevel2Circle")
				@ResponseBody
				public String getNDYSLevel2Circle(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
						ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getJFZCLevel2Circle, HttpMethod.POST, entity, JSONArray.class);
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
					System.out.println(">>>>>>>>>>>>>>>getNDYSLevel2Circle " + resultObj.toString());
					return resultObj.toString();
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
					
					
					
					
					

					
					
					
					
					
					
					
					
				
				
	  
	  
	  
}
