package com.pcitc.web.controller.hanaLeader;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.ChartBarLineResultData;
import com.pcitc.base.common.ChartBarLineSeries;
import com.pcitc.base.common.PageResult;
import com.pcitc.base.common.Result;
import com.pcitc.base.hana.report.BudgetMysql;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.web.utils.HanaUtil;

@Controller
@RequestMapping(value = "/investment")
public class InvestmentController {
	  private static final String get_investment_unit_type = "http://pcitc-zuul/system-proxy/out-project-provider/project-money/unit-type";
	  private static final String getZdstlPie = "http://pcitc-zuul/system-proxy/out-project-provider/ld/zdstl/count";

	  @Autowired
	  private HttpHeaders httpHeaders;
	  @Autowired
	  private RestTemplate restTemplate;
	
	
	  @RequestMapping(method = RequestMethod.GET, value = "/investment")
	  public String kyzb_level2(HttpServletRequest request) throws Exception
	  {
		    
		    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
		    String unitCode=userInfo.getUnitCode();
		    request.setAttribute("unitCode", unitCode);
		    request.setAttribute("YJY_CODE_NOT_YINGKE", HanaUtil.YJY_CODE_NOT_YINGKE);
		    request.setAttribute("YJY_CODE_ALL", HanaUtil.YJY_CODE_ALL);
		    
		    String year= HanaUtil.getCurrrentYear();
		    request.setAttribute("year", year);
	        return "stp/hana/home/direct_depart/investment";
	        
	  }
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/get_investment_unit_type")
	@ResponseBody
	public String get_investment_unit_type(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(get_investment_unit_type, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) 
			{
				JSONArray jSONArray = responseEntity.getBody();
				System.out.println(">>>>>>>>>>>>>>get_investment_unit_type jSONArray-> " + jSONArray.toString());
				List<BudgetMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), BudgetMysql.class);
				List<BudgetMysql> list_more=new ArrayList<BudgetMysql>();
				
				BudgetMysql budgetMysql=new BudgetMysql();
				for(int i=0;i<list.size();i++)
				{
					BudgetMysql bm=list.get(i);
					if(bm.getType_flag().equals("总计"))
					{
						budgetMysql=bm;
					}else
					{
						list_more.add(bm);
					}
				}
				
				
				
				
				
				List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list_more,"type_flag");
         		barLine.setxAxisDataList(xAxisDataList);
         	
				List<String> legendDataList = new ArrayList<String>();
				legendDataList.add("费用性实际下达");
				legendDataList.add("资本性实际下达");
				barLine.setxAxisDataList(xAxisDataList);
				barLine.setLegendDataList(legendDataList);
				// X轴数据
				List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
				ChartBarLineSeries s1 = HanaUtil.getinvestmentChartBarLineSeries(list_more, "fyxje");
				ChartBarLineSeries s2 = HanaUtil.getinvestmentChartBarLineSeries(list_more, "zbxje");
				seriesList.add(s1);
				seriesList.add(s2);
				barLine.setSeriesList(seriesList);
         		result.setSuccess(true);
         		
         		
         		
         		
         		Map map=new HashMap();
         		map.put("budgetMysql", budgetMysql);
         		map.put("barLine", barLine);
         		
         		
				result.setData(map);
			}
			
		} else
		{
			result.setSuccess(false);
			result.setMessage("参数为空");
		}
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
		System.out.println(">>>>>>>>>>>>>>get_investment_unit_type " + resultObj.toString());
		return resultObj.toString();
	}
				
				
				//重在集团
				@RequestMapping(method = RequestMethod.GET, value = "/get_investment_unit_type_table")
				@ResponseBody
				public String getZdstlTable(HttpServletRequest request, HttpServletResponse response) throws Exception {
					PageResult pageResult = new PageResult();
					String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
					String companyCode = CommonUtil.getParameter(request, "companyCode", "");
					String type = CommonUtil.getParameter(request, "type", "重点专项");
					Map<String, Object> paramsMap = new HashMap<String, Object>();
					paramsMap.put("month", month);
					paramsMap.put("type", type);
					paramsMap.put("companyCode", companyCode);
					JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
					HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
					
						ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(get_investment_unit_type, HttpMethod.POST, entity, JSONArray.class);
						int statusCode = responseEntity.getStatusCodeValue();
						if (statusCode == 200) 
						{
							JSONArray jSONArray = responseEntity.getBody();
							System.out.println(">>>>>>>>>>>>get_investment_unit_type_table jSONArray>>> " + jSONArray.toString());
							List<BudgetMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), BudgetMysql.class);
							
							
							
							pageResult.setData(list);
							pageResult.setCode(0);
							pageResult.setCount(Long.valueOf(list.size()));
							pageResult.setLimit(1000);
							pageResult.setPage(1l);
						}
						
					
					JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
					System.out.println(">>>>>>>>>>>>>>>get_investment_unit_type_table " + resultObj.toString());
					return resultObj.toString();
				}
				
				
				
				
				
				
				
				
				
				
				@RequestMapping(method = RequestMethod.GET, value = "/get_investment_unit_type_bar")
				@ResponseBody
				public String get_investment_unit_type_bar(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
						ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(get_investment_unit_type, HttpMethod.POST, entity, JSONArray.class);
						int statusCode = responseEntity.getStatusCodeValue();
						if (statusCode == 200) 
						{
							JSONArray jSONArray = responseEntity.getBody();
							System.out.println(">>>>>>>>>>>>>>get_investment_unit_type_bar jSONArray-> " + jSONArray.toString());
							List<BudgetMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), BudgetMysql.class);
							List<BudgetMysql> list_more=new ArrayList<BudgetMysql>();
							
							BudgetMysql budgetMysql=new BudgetMysql();
							for(int i=0;i<list.size();i++)
							{
								BudgetMysql bm=list.get(i);
								if(bm.getType_flag().equals("总计"))
								{
									budgetMysql=bm;
								}else
								{
									list_more.add(bm);
								}
							}
							
							List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list_more,"type_flag");
			         		barLine.setxAxisDataList(xAxisDataList);
			         	
							List<String> legendDataList = new ArrayList<String>();
							legendDataList.add("实际下达");
							legendDataList.add("未下达");
							legendDataList.add("投资完成率");
							barLine.setxAxisDataList(xAxisDataList);
							barLine.setLegendDataList(legendDataList);
							// X轴数据
							List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
							ChartBarLineSeries s1 = HanaUtil.getinvestmentBarLineSeries(list_more, "zje");
							ChartBarLineSeries s2 = HanaUtil.getinvestmentBarLineSeries(list_more, "wxd");
							ChartBarLineSeries ztzwcl = HanaUtil.getinvestmentBarLineSeries(list_more, "ztzwcl");
							seriesList.add(s1);
							seriesList.add(s2);
							seriesList.add(ztzwcl);
							barLine.setSeriesList(seriesList);
			         		result.setSuccess(true);
			         		
			         		Map map=new HashMap();
			         		map.put("budgetMysql", budgetMysql);
			         		map.put("barLine", barLine);
							result.setData(map);
						}
						
					} else
					{
						result.setSuccess(false);
						result.setMessage("参数为空");
					}
					JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
					System.out.println(">>>>>>>>>>>>>>get_investment_unit_type_bar " + resultObj.toString());
					return resultObj.toString();
				}
						
}
