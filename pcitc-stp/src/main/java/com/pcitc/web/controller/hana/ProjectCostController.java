package com.pcitc.web.controller.hana;

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
import com.pcitc.base.common.PageResult;
import com.pcitc.base.hana.report.ProjectCost;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.web.utils.HanaUtil;

//项目成本
@Controller
public class ProjectCostController {
	 @Autowired
	 private HttpHeaders httpHeaders;
	 @Autowired
	 private RestTemplate restTemplate;
	 
	 private static final String kytztjb_data = "http://pcitc-zuul/hana-proxy/hana/projectCost/kytztjb";
	 private static final String kjjftjb_data = "http://pcitc-zuul/hana-proxy/hana/projectCost/kjjftjb";
	 private static final String hxktqcbtjb_data = "http://pcitc-zuul/hana-proxy/hana/projectCost/hxktqcbtjb";
		
	 
	  //项目支出统计表
	  @RequestMapping(method = RequestMethod.GET, value = "/pc/xmzctjb")
	  public String xmzctjb(HttpServletRequest request) throws Exception
	  {
		    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	        return "stp/hana/projectCost/xmzctjb";
	  }
	  
	  
	  //科研投资统计表
	  @RequestMapping(method = RequestMethod.GET, value = "/pc/kytztjb")
	  public String kytztjb(HttpServletRequest request) throws Exception
	  {
		    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
			HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
			String month = HanaUtil.getCurrrent_Year_Moth();
			request.setAttribute("month", month);
	        return "stp/hana/projectCost/kytztjb";
	  }
	  
     @RequestMapping(method = RequestMethod.GET, value = "/kytztjb_data")
	 @ResponseBody
	 public String kytztjb_data(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    PageResult pageResult = new PageResult();
		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
		System.out.println(">>>>>>>>>>>>>>>>>>kytztjb_data>>参数      month = "+month+" companyCode="+companyCode);
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("month", month);
		paramsMap.put("companyCode", companyCode);
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		if (!companyCode.equals(""))
		{
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(kytztjb_data, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) 
			{
				JSONArray jSONArray = responseEntity.getBody();
				List<ProjectCost> list = JSONObject.parseArray(jSONArray.toJSONString(), ProjectCost.class);
				pageResult.setData(list);
				pageResult.setCode(0);
				pageResult.setCount(Long.valueOf(list.size()));
				pageResult.setLimit(1000);
				pageResult.setPage(1l);
			}
		} 
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
		System.out.println(">>>>>>>>>>>>>>>>>kytztjb_data " + resultObj.toString());
		return resultObj.toString();
	}
	  
	  
	  
	  //科技经费统计表
	  @RequestMapping(method = RequestMethod.GET, value = "/pc/kjjftjb")
	  public String kjjftjb(HttpServletRequest request) throws Exception
	  {
		    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
			HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
			String month = HanaUtil.getCurrrent_Year_Moth();
			request.setAttribute("month", month);
	        return "stp/hana/projectCost/kjjftjb";
	  }
	  
	  
	  
	  
	     @RequestMapping(method = RequestMethod.GET, value = "/kjjftjb_data")
		 @ResponseBody
		 public String kjjftjb_data(HttpServletRequest request, HttpServletResponse response) throws Exception {

		    PageResult pageResult = new PageResult();
			String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
			String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
			System.out.println(">>>>>>>>>>>>>>>>>>kjjftjb_data>>参数      month = "+month+" companyCode="+companyCode);
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			if (!companyCode.equals(""))
			{
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(kjjftjb_data, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					JSONArray jSONArray = responseEntity.getBody();
					List<ProjectCost> list = JSONObject.parseArray(jSONArray.toJSONString(), ProjectCost.class);
					pageResult.setData(list);
					pageResult.setCode(0);
					pageResult.setCount(Long.valueOf(list.size()));
					pageResult.setLimit(1000);
					pageResult.setPage(1l);
				}
			} 
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
			System.out.println(">>>>>>>>>>>>>>>>>kjjftjb_data " + resultObj.toString());
			return resultObj.toString();
		}
	  
	  
	  
	  
	  //横向课题全成本统计表
	  @RequestMapping(method = RequestMethod.GET, value = "/pc/hxktqcbtjb")
	  public String hxktqcbtjb(HttpServletRequest request) throws Exception
	  {
		    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
			HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
			String month = HanaUtil.getCurrrent_Year_Moth();
			request.setAttribute("month", month);
	        return "stp/hana/projectCost/hxktqcbtjb";
	  }
	  
	  
	   
	     @RequestMapping(method = RequestMethod.GET, value = "/hxktqcbtjb_data")
		 @ResponseBody
		 public String hxktqcbtjb_data(HttpServletRequest request, HttpServletResponse response) throws Exception 
	     {
		    PageResult pageResult = new PageResult();
			String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
			String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
			System.out.println(">>>>>>>>>>>>>>>>>>hxktqcbtjb_data>>参数      month = "+month+" companyCode="+companyCode);
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			if (!companyCode.equals(""))
			{
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(hxktqcbtjb_data, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					JSONArray jSONArray = responseEntity.getBody();
					List<ProjectCost> list = JSONObject.parseArray(jSONArray.toJSONString(), ProjectCost.class);
					pageResult.setData(list);
					pageResult.setCode(0);
					pageResult.setCount(Long.valueOf(list.size()));
					pageResult.setLimit(1000);
					pageResult.setPage(1l);
				}
			} 
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
			System.out.println(">>>>>>>>>>>>>>>>>hxktqcbtjb_data " + resultObj.toString());
			return resultObj.toString();
		}
	  
	  
	  
}
