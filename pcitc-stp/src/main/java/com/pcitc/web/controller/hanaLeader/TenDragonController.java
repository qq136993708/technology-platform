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
import com.pcitc.base.common.TreeNode2;
import com.pcitc.base.hana.report.BudgetMysql;
import com.pcitc.base.hana.report.ProjectForMysql;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.web.utils.HanaUtil;

@Controller
@RequestMapping(value = "/ten_dragon")
public class TenDragonController {
	private static final String getZdstlTable = "http://pcitc-zuul/system-proxy/out-project-provider/ld/project-info/zdstl";
	private static final String getZdstlPie = "http://pcitc-zuul/system-proxy/out-project-provider/ld/zdstl/count";

	@Autowired
	private HttpHeaders httpHeaders;
	@Autowired
	private RestTemplate restTemplate;
	
	
	  @RequestMapping(method = RequestMethod.GET, value = "/ten_dragon")
	  public String kyzb_level2(HttpServletRequest request) throws Exception
	  {
		    
		    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
		    String unitCode=userInfo.getUnitCode();
		    request.setAttribute("unitCode", unitCode);
		    request.setAttribute("YJY_CODE_NOT_YINGKE", HanaUtil.YJY_CODE_NOT_YINGKE);
		    request.setAttribute("YJY_CODE_ALL", HanaUtil.YJY_CODE_ALL);
	        return "stp/hana/home/oneLevelMain/ten_dragon";
	        
	  }
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/getZdstlPie")
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
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getZdstlPie, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) 
			{
				JSONArray jSONArray = responseEntity.getBody();
				System.out.println(">>>>>>>>>>>>>>getZdstlPie jSONArray-> " + jSONArray.toString());
				List<ProjectForMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), ProjectForMysql.class);
				List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"define2");
         		barLine.setxAxisDataList(xAxisDataList);
         	
				List<String> legendDataList = new ArrayList<String>();
				legendDataList.add("十条龙项目");
				legendDataList.add("重大项目");
				barLine.setxAxisDataList(xAxisDataList);
				barLine.setLegendDataList(legendDataList);
				// X轴数据
				List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
				ChartBarLineSeries s1 = HanaUtil.getTenDragonChartBarLineSeries(list, "stlsl");
				ChartBarLineSeries s2 = HanaUtil.getTenDragonChartBarLineSeries(list, "zdzxsl");
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
		System.out.println(">>>>>>>>>>>>>>getZdstlPie " + resultObj.toString());
		return resultObj.toString();
	}
				
				
				//重在集团
				@RequestMapping(method = RequestMethod.GET, value = "/getZdstlTable")
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
					
						ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getZdstlTable, HttpMethod.POST, entity, JSONArray.class);
						int statusCode = responseEntity.getStatusCodeValue();
						if (statusCode == 200) 
						{
							JSONArray jSONArray = responseEntity.getBody();
							System.out.println(">>>>>>>>>>>>getZdstlTable jSONArray>>> " + jSONArray.toString());
							List<ProjectForMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), ProjectForMysql.class);
							pageResult.setData(list);
							pageResult.setCode(0);
							pageResult.setCount(Long.valueOf(list.size()));
							pageResult.setLimit(1000);
							pageResult.setPage(1l);
						}
						
					
					JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
					System.out.println(">>>>>>>>>>>>>>>getZdstlTable " + resultObj.toString());
					return resultObj.toString();
				}
				
				
	
	

}
