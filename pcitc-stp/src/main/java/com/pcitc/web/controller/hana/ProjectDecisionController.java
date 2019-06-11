package com.pcitc.web.controller.hana;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.ChartBarLineDataValue;
import com.pcitc.base.common.ChartData;
import com.pcitc.base.common.ChartDataMulti;
import com.pcitc.base.hana.report.CompanyCode;
import com.pcitc.base.hana.report.ProjectCode;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.ResultsDate;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.web.utils.HanaUtil;

@Controller
@RequestMapping(value = "/project-decision")
public class ProjectDecisionController extends BaseController {
	
	private static final String GET_LIST = "http://pcitc-zuul/hana-proxy/hana/decision/get";
	
	
	

	  //科研项目综合多维分析
	  @RequestMapping(method = RequestMethod.GET, value = "/kyxmzhdwfx")
	  public String kyxmzhdwfx(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/projectDecision/kyxmzhdwfx";
	  }
	  
	  //重大科研项目多维分析
	  @RequestMapping(method = RequestMethod.GET, value = "/zdkyxmdwfx")
	  public String zdkyxmdwfx(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/projectDecision/zdkyxmdwfx";
	  }
	/**
	  * 项目调整决策分析
	 * @param request
	 * @return
	 */
	 @RequestMapping(method = RequestMethod.GET, value = "/project-adjust-decision-analysis")
	 public String researchanalysis(HttpServletRequest request) throws Exception
	 {
		    
		 
		 SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
			  List<ProjectCode> projectCodeList=HanaUtil.getProjectCode(restTemplate,httpHeaders);
				request.setAttribute("projectCodeList",projectCodeList);
				
			
	        return "stp/hana/decision/project/project-adjust-decision-analysis";
	 }
	 
	 
	 public  int getRandom(int min, int max)
	 {
		    Random random = new Random();
		    int s = random.nextInt(max) % (max - min + 1) + min;
		    return s;

	}

   
    @RequestMapping(method = RequestMethod.GET, value = "/scientific-projects-comprehensive-analysis-html")
    public String scientificProjectsComprehensiveAnalysis(HttpServletRequest request)throws Exception
    {
    	SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
	    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
        return "stp/hana/decision/project/scientific-projects-comprehensive-analysis";
    }
    /**
      * 科研项目综合分析
   * @param request
   * @return
   */
    @RequestMapping(method = RequestMethod.GET, value = "/scientific-projects-comprehensive-analysis")
    public String scientifictest(HttpServletRequest request)throws Exception
    {
    	
    	
    	SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
	    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
		  List<ProjectCode> projectCodeList=HanaUtil.getProjectCode(restTemplate,httpHeaders);
			request.setAttribute("projectCodeList",projectCodeList);
        return "stp/hana/decision/project/scientific-projects-comprehensive-analysis";
    }

   
    
    
    
    /*
	 * @RequestMapping(method = RequestMethod.POST, value =
	 * "/scientific-projects-comprehensive-analysis-new")
	 * 
	 * @ResponseBody public String
	 * scientificProjectsComprehensiveAnalysisNew(HttpServletRequest request,
	 * HttpServletResponse response)throws Exception {
	 * 
	 * 
	 * 
	 * Result resultsDate = new Result();
	 * httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
	 * 
	 * System.out.println(
	 * ">>>>>>>>>>>>>>>>scientificProjectsComprehensiveAnalysisNew>>>>>>>>>>>>>>>>token="
	 * );
	 * 
	 * 
	 * String month=CommonUtil.getParameter(request, "month", "C"); String
	 * organizationName=CommonUtil.getParameter(request, "organizationName",
	 * "aa"); String chartId=CommonUtil.getParameter(request, "chartId", "bb");
	 * 
	 * Map<String, Object> paramsMap = new HashMap<String, Object>();
	 * paramsMap.put("month", month); paramsMap.put("organizationName",
	 * organizationName); JSONObject jsonObject =
	 * JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
	 * 
	 * 
	 * 
	 * HttpEntity<String> entity = new
	 * HttpEntity<String>(jsonObject.toString(),httpHeaders);
	 * ResponseEntity<JSONArray> responseEntity =
	 * restTemplate.exchange(GET_LIST, HttpMethod.POST, entity,
	 * JSONArray.class);
	 * 
	 * 
	 * //传递参数--paramsJson MultiValueMap<String, String> requestBody = new
	 * LinkedMultiValueMap<String, String>(); requestBody.add("paramsJson",
	 * jsonObject.toString()); HttpEntity<MultiValueMap<String, String>> entity
	 * = new HttpEntity<MultiValueMap<String, String>>(requestBody,
	 * this.httpHeaders); ResponseEntity<JSONArray> responseEntity =
	 * this.restTemplate.exchange(GET_LIST, HttpMethod.POST, entity,
	 * JSONArray.class); //封装返回结果 Map<String, Object> result = new
	 * HashMap<String, Object>(); JSONArray page=responseEntity.getBody();
	 * System
	 * .out.println(">>>>>>>>>>>>>>>>>>>>>loadData 返回      status = "+responseEntity
	 * .getStatusCodeValue()+" json="+page.toString());
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * if(chartId.equals("chart_1")) {
	 * 
	 * List<ChartBarLineDataValue> dataList=new
	 * ArrayList<ChartBarLineDataValue>(); dataList.add(new
	 * ChartBarLineDataValue("销量","2014", getRandom(100, 1000)));
	 * dataList.add(new ChartBarLineDataValue("销量","2015", getRandom(100,
	 * 1000))); dataList.add(new ChartBarLineDataValue("销量","2016",
	 * getRandom(100, 1000))); dataList.add(new
	 * ChartBarLineDataValue("销量","2017", getRandom(100, 1000)));
	 * dataList.add(new ChartBarLineDataValue("销量","2018", getRandom(100,
	 * 1000)));
	 * 
	 * //柱型图 ChartBarLineResultData chartBarLineResultData=new
	 * ChartBarLineResultData(); List<String> xAxisDataList=new
	 * ArrayList<String>(); List<String> legendDataList=new ArrayList<String>();
	 * List<ChartBarLineSeries> seriesList=new ArrayList<ChartBarLineSeries>();
	 * //第一个serial ChartBarLineSeries bls=new ChartBarLineSeries();
	 * bls.setName("销量"); bls.setType(Constant.ECHARTS_TYPE_BAR);
	 * List<ChartBarLineDataValue> keyVlueList=dataList; List<Object> data=
	 * getSerialValueList(keyVlueList); bls.setData(data); seriesList.add(bls);
	 * chartBarLineResultData.setSeriesList(seriesList);
	 * 
	 * //封装legendList if(seriesList!=null && seriesList.size()>0) { for(int
	 * i=0;i<seriesList.size();i++) { ChartBarLineSeries cs=seriesList.get(i);
	 * String legendName=cs.getName(); legendDataList.add(legendName); } }
	 * chartBarLineResultData.setLegendDataList(legendDataList); //封装xAxis data
	 * List<ChartBarLineDataValue> data_value_List=dataList;
	 * if(data_value_List!=null && data_value_List.size()>0) { for(int
	 * i=0;i<data_value_List.size();i++) { ChartBarLineDataValue
	 * chartDataValue=data_value_List.get(i); String
	 * name=chartDataValue.getName(); xAxisDataList.add(name); } }
	 * chartBarLineResultData.setxAxisDataList(xAxisDataList);
	 * resultsDate.setData(chartBarLineResultData); }else
	 * if(chartId.equals("chart_2")) {
	 * 
	 * //饼图 ChartPieResultData pieResult=new ChartPieResultData();
	 * List<ChartPieDataValue> piedataList=new ArrayList<ChartPieDataValue>();
	 * piedataList.add(new ChartPieDataValue( getRandom(100, 1000),"国家项目"));
	 * piedataList.add(new ChartPieDataValue( getRandom(100, 1000),"重大项目"));
	 * piedataList.add(new ChartPieDataValue( getRandom(100, 1000),"十条龙"));
	 * piedataList.add(new ChartPieDataValue( getRandom(100, 1000),"其他"));
	 * pieResult.setDataList(piedataList); List<String> legendDataList=new
	 * ArrayList<String>(); if(piedataList!=null && piedataList.size()>0) {
	 * for(int i=0;i<piedataList.size();i++) { ChartPieDataValue
	 * pie=piedataList.get(i); String name=pie.getName();
	 * legendDataList.add(name); } }
	 * pieResult.setLegendDataList(legendDataList);
	 * resultsDate.setData(pieResult); }else if(chartId.equals("chart_3")) {
	 * 
	 * //饼图 ChartPieResultData pieResult=new ChartPieResultData();
	 * List<ChartPieDataValue> piedataList=new ArrayList<ChartPieDataValue>();
	 * piedataList.add(new ChartPieDataValue( getRandom(100, 1000),"石勘院"));
	 * piedataList.add(new ChartPieDataValue( getRandom(100, 1000),"物探院"));
	 * piedataList.add(new ChartPieDataValue( getRandom(100, 1000),"工程院"));
	 * piedataList.add(new ChartPieDataValue( getRandom(100, 1000),"石科院"));
	 * piedataList.add(new ChartPieDataValue( getRandom(100, 1000),"抚研院"));
	 * piedataList.add(new ChartPieDataValue( getRandom(100, 1000),"北化院"));
	 * piedataList.add(new ChartPieDataValue( getRandom(100, 1000),"上海院"));
	 * piedataList.add(new ChartPieDataValue( getRandom(100, 1000),"安工院"));
	 * 
	 * pieResult.setDataList(piedataList); List<String> legendDataList=new
	 * ArrayList<String>(); if(piedataList!=null && piedataList.size()>0) {
	 * for(int i=0;i<piedataList.size();i++) { ChartPieDataValue
	 * pie=piedataList.get(i); String name=pie.getName();
	 * legendDataList.add(name); } }
	 * pieResult.setLegendDataList(legendDataList);
	 * resultsDate.setData(pieResult);
	 * 
	 * }else if(chartId.equals("chart_10")) {
	 * 
	 * List<ChartBarLineDataValue> data_List=new
	 * ArrayList<ChartBarLineDataValue>(); data_List.add(new
	 * ChartBarLineDataValue("人均项目","2014", getRandom(100, 1000)));
	 * data_List.add(new ChartBarLineDataValue("人均项目","2015", getRandom(100,
	 * 1000))); data_List.add(new ChartBarLineDataValue("人均项目","2016",
	 * getRandom(100, 1000))); data_List.add(new
	 * ChartBarLineDataValue("人均项目","2017", getRandom(100, 1000)));
	 * data_List.add(new ChartBarLineDataValue("人均项目","2018", getRandom(100,
	 * 1000)));
	 * 
	 * List<ChartBarLineDataValue> data2List=new
	 * ArrayList<ChartBarLineDataValue>(); data2List.add(new
	 * ChartBarLineDataValue("人均经费","2014", getRandom(100, 1000)));
	 * data2List.add(new ChartBarLineDataValue("人均经费","2015", getRandom(100,
	 * 1000))); data2List.add(new ChartBarLineDataValue("人均经费","2016",
	 * getRandom(100, 1000))); data2List.add(new
	 * ChartBarLineDataValue("人均经费","2017", getRandom(100, 1000)));
	 * data2List.add(new ChartBarLineDataValue("人均经费","2018", getRandom(100,
	 * 1000)));
	 * 
	 * List<ChartBarLineDataValue> data3List=new
	 * ArrayList<ChartBarLineDataValue>(); data3List.add(new
	 * ChartBarLineDataValue("人均专利","2014", getRandom(1, 100)));
	 * data3List.add(new ChartBarLineDataValue("人均专利","2015", getRandom(1,
	 * 100))); data3List.add(new ChartBarLineDataValue("人均专利","2016",
	 * getRandom(1, 100))); data3List.add(new
	 * ChartBarLineDataValue("人均专利","2017", getRandom(1, 100)));
	 * data3List.add(new ChartBarLineDataValue("人均专利","2018", getRandom(1,
	 * 100)));
	 * 
	 * 
	 * //柱型图 ChartBarLineResultData chartBarLineResultData=new
	 * ChartBarLineResultData(); List<String> xAxisDataList=new
	 * ArrayList<String>(); List<String> legendDataList=new ArrayList<String>();
	 * List<ChartBarLineSeries> seriesList=new ArrayList<ChartBarLineSeries>();
	 * //第一个serial ChartBarLineSeries bls=new ChartBarLineSeries();
	 * bls.setName("人均项目"); bls.setType(Constant.ECHARTS_TYPE_BAR);
	 * List<ChartBarLineDataValue> keyVlueList=data_List; List<Object> data=
	 * getSerialValueList(keyVlueList); bls.setData(data); //第二个serial
	 * ChartBarLineSeries bls_2=new ChartBarLineSeries(); bls_2.setName("人均经费");
	 * bls_2.setType(Constant.ECHARTS_TYPE_BAR); List<ChartBarLineDataValue>
	 * keyVlueList2=data2List; List<Object> data2=
	 * getSerialValueList(keyVlueList2); bls_2.setData(data2);
	 * 
	 * //第三个serial ChartBarLineSeries bls_3=new ChartBarLineSeries();
	 * bls_3.setName("人均专利"); bls_3.setType(Constant.ECHARTS_TYPE_LINE);
	 * List<ChartBarLineDataValue> keyVlueList3=data3List; List<Object> data3=
	 * getSerialValueList(keyVlueList3); bls_3.setData(data3);
	 * 
	 * seriesList.add(bls); seriesList.add(bls_2); seriesList.add(bls_3);
	 * chartBarLineResultData.setSeriesList(seriesList);
	 * 
	 * //封装legendList if(seriesList!=null && seriesList.size()>0) { for(int
	 * i=0;i<seriesList.size();i++) { ChartBarLineSeries cs=seriesList.get(i);
	 * String legendName=cs.getName(); legendDataList.add(legendName); } }
	 * chartBarLineResultData.setLegendDataList(legendDataList); //封装xAxis data
	 * List<ChartBarLineDataValue> data_value_List=data_List;
	 * if(data_value_List!=null && data_value_List.size()>0) { for(int
	 * i=0;i<data_value_List.size();i++) { ChartBarLineDataValue
	 * chartDataValue=data_value_List.get(i); String
	 * name=chartDataValue.getName(); System.out.println("name="+name);
	 * xAxisDataList.add(name); } }
	 * chartBarLineResultData.setxAxisDataList(xAxisDataList);
	 * resultsDate.setData(chartBarLineResultData);
	 * 
	 * }
	 * 
	 * response.setContentType("text/html;charset=UTF-8");
	 * resultsDate.setSuccess(true); String
	 * resut=JSON.toJSONString(resultsDate); //JSONObject
	 * ob=JSONObject.fromObject(results);
	 * System.out.println(chartId+" ajax 请求-->:"+resut); return resut; }
	 */
    
    //key--value  -->valueList
    public List<Object> getSerialValueList(List<ChartBarLineDataValue> keyVlueList)
    {
   	 
   	 List<Object> list=new ArrayList();
   	 //根据X轴数据(key--value)得到 valueList
		 if(keyVlueList!=null && keyVlueList.size()>0)
	     {
	    	for(int j=0;j<keyVlueList.size();j++)
	    	{
	    		ChartBarLineDataValue dv=keyVlueList.get(j);
	    		list.add(dv.getValue());
	    	}
	     }
		return list;
    }
    
    
   
	 /**
	  * 科研项目综合分析
	 * @param request
	 * @return
	 */
	 @RequestMapping(method = RequestMethod.POST, value = "/scientific-projects-comprehensive-analysis")
	 public String scientificProjectsComprehensiveAnalysis(HttpServletRequest request, HttpServletResponse response)throws Exception
	 {
	        
		    ResultsDate results=new ResultsDate();
		    Map<String , Object> map = new HashMap<String , Object>();  
		    
		    List<ChartData> chart1List = new ArrayList<ChartData>();
	        //对象都可以看作是一个类别（X轴坐标值）与销量（Y轴坐标值）的集合
		    chart1List.add(new ChartData("2014", getRandom(100, 1000)));
		    chart1List.add(new ChartData("2015", getRandom(100, 1000)));
		    chart1List.add(new ChartData("2016", getRandom(100, 1000)));
		    chart1List.add(new ChartData("2017", getRandom(100, 1000)));
		    chart1List.add(new ChartData("2018", getRandom(100, 1000)));
		    map.put("chart1", chart1List);
		    
		    
		    List<ChartData> chart2List = new ArrayList<ChartData>();
	        //对象都可以看作是一个类别（X轴坐标值）与销量（Y轴坐标值）的集合
		    chart2List.add(new ChartData("国家项目", getRandom(100, 1000)));
		    chart2List.add(new ChartData("重大项目", getRandom(100, 1000)));
		    chart2List.add(new ChartData("十条龙", getRandom(100, 1000)));
		    chart2List.add(new ChartData("其他", getRandom(100, 1000)));
		    map.put("chart2", chart2List);
		    
		    
		    
		    List<ChartDataMulti> chart4List = new ArrayList<ChartDataMulti>();
		    List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
		    Map<String, Object> m=new HashMap<String, Object>();
		    m.put("2014", 200);
		    m.put("2015", 300);
		    m.put("2016", 400);
		    m.put("2017", 400);
		    m.put("2018", 400);
		    list.add(m);
	        //对象都可以看作是一个类别（X轴坐标值）与销量（Y轴坐标值）的集合
		    //chart4List.add(new ChartDataMulti("计划经费", getRandom(100, 1000)));
		    //chart4List.add(new ChartDataMulti("实际经费", getRandom(100, 1000)));
		    //chart4List.add(new ChartDataMulti("达成率", getRandom(100, 1000)));
		    //map.put("chart4", chart4List);
		    
		    
		    
	        response.setContentType("text/html;charset=UTF-8");
	        results.setResultCode(ResultsDate.RETURN_CODE_SUCCESS);
	        results.setReturnData(map);
			PrintWriter out = response.getWriter();
			JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(results));
			out.println(ob.toString());
			out.flush();
			out.close();
			return null;
	 }
	 
	 /**
	  * 重大科研项目分析
	 * @param request
	 * @return
	 */
	 @RequestMapping(method = RequestMethod.GET, value = "/major-scientific-projects-analysis")
	 public String majorScientificProjectsAnalysis(HttpServletRequest request) throws Exception
	 {
		    
		 SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	        return "stp/hana/decision/project/major-scientific-projects-analysis";
	 }
	 
	 
	 /**
	  * “十条龙”项目分析
	 * @param request
	 * @return
	 */
	 @RequestMapping(method = RequestMethod.GET, value = "/ten-dragons-analysis")
	 public String tenDragonsAnalysis(HttpServletRequest request) throws Exception
	 {
		    
		 SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	        return "stp/hana/decision/project/ten-dragons-analysis";
	 }
	 
	 
	 
	 
	 
	 
	 
}
