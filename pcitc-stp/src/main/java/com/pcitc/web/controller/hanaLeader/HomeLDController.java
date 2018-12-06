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
@RequestMapping(value = "/home_ld")
public class HomeLDController {
	
	private static final String GET_XFZC =      "http://pcitc-zuul/hana-proxy/hana/home/getndys_xfzc";
	private static final String GET_getDzzk = "http://pcitc-zuul/hana-proxy/hana/home/getDzzk";
	private static final String getZhuanziTableList = "http://pcitc-zuul/hana-proxy/hana/home/getZhuanziTableList";
	
	@Autowired
	private HttpHeaders httpHeaders;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@RequestMapping( value = "/mainLeader")
	public String mainLeader(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "stp/hana/home/mainLeader";
	}
	
	
	@RequestMapping( value = "/direct_depart")
	public String direct_depart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
	    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	    String unitCode=userInfo.getUnitCode();
	    request.setAttribute("unitCode", unitCode);
	    String year= HanaUtil.getCurrrentYear();
	    request.setAttribute("year", year);
	    
	    
	    request.setAttribute("companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
		return "stp/hana/home/oneLevelMain/direct_depart";
	}
	
	//科研合同
	@RequestMapping( value = "/contract")
	public String contract(HttpServletRequest request, HttpServletResponse response) throws Exception {
		SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
	    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	    String unitCode=userInfo.getUnitCode();
	    request.setAttribute("unitCode", unitCode);
	    String year= HanaUtil.getCurrrentYear();
	    request.setAttribute("year", year);
	    request.setAttribute("companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
		return "stp/hana/home/oneLevelMain/contract";
	}
	//科研装备
	@RequestMapping( value = "/equipment")
	public String equipment(HttpServletRequest request, HttpServletResponse response) throws Exception {
		SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
	    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	    String unitCode=userInfo.getUnitCode();
	    request.setAttribute("unitCode", unitCode);
	    String year= HanaUtil.getCurrrentYear();
	    request.setAttribute("year", year);
	    request.setAttribute("companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
		return "stp/hana/home/oneLevelMain/equipment";
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
	
	
	  
				
				 
				  
	  
	  
}
