package com.pcitc.web.controller.out;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Result;
import com.pcitc.base.out.OutProject;
import com.pcitc.web.common.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Statistical-API",tags = {"领导驾驶仓"})
@RestController
public class StatisticalController extends BaseController
{
	    private static final String getRightsMap = "http://kjpt-zuul/stp-proxy/statistical-api/getRightsMap";
	    private static final String getKyptInfoGrupCountList = "http://kjpt-zuul/stp-proxy/statistical-api/getKyptInfoGrupCountList";
	    private static final String getAchieveMaintainGrupCountList = "http://kjpt-zuul/stp-proxy/statistical-api/getAchieveMaintainGrupCountList";
		
	    
	    
	
	    @ApiOperation(value = "知识产权", notes = "知识产权")
		@RequestMapping(value = "/getRightsMap", method = RequestMethod.GET)
	    @ResponseBody
	   	public String getRightsMap( HttpServletRequest request, HttpServletResponse response) throws Exception
	   	{
	   		
	   		Result resultsDate = new Result();
			Map<String, Object> paramMap = new HashMap<String, Object>();
			HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap, this.httpHeaders);
			ResponseEntity<JSONObject> responseEntity = restTemplate.exchange(getRightsMap, HttpMethod.POST, httpEntity,JSONObject.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {
				JSONObject jSONObject = responseEntity.getBody();
				resultsDate.setData(jSONObject);
			}
			JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
			logger.info("============知识产权result" + result.toString());
			return result.toString();
	   	}
	    
	    
	    
	    @ApiOperation(value = "科研平台", notes = "科研平台")
		@RequestMapping(value = "/getKyptInfoGrupCountList", method = RequestMethod.GET)
	    @ResponseBody
	   	public String getKyptInfoGrupCountList( HttpServletRequest request, HttpServletResponse response) throws Exception
	   	{
	   		
	    	Map  map = new HashMap();
			ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(getKyptInfoGrupCountList, HttpMethod.POST,new HttpEntity<Map>(map, this.httpHeaders), JSONArray.class);
			JSONArray temparray = responseEntity.getBody();
			List<OutProject> list = JSONObject.parseArray(temparray.toJSONString(), OutProject.class);
			JSONArray trreeJsovvn = JSONArray.parseArray(JSON.toJSONString(list));
			System.out.println("-----------------科研平台："+trreeJsovvn.toString());
			return trreeJsovvn.toString();
	   	}
	    
	    
	    

	    @ApiOperation(value = "成果获奖（累计）", notes = "成果获奖（累计）")
		@RequestMapping(value = "/getAchieveMaintainGrupCountList", method = RequestMethod.GET)
	    @ResponseBody
	   	public String getAchieveMaintainGrupCountList( HttpServletRequest request, HttpServletResponse response) throws Exception
	   	{
	   		
	    	Map  map = new HashMap();
			ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(getAchieveMaintainGrupCountList, HttpMethod.POST,new HttpEntity<Map>(map, this.httpHeaders), JSONArray.class);
			JSONArray temparray = responseEntity.getBody();
			List<OutProject> list = JSONObject.parseArray(temparray.toJSONString(), OutProject.class);
			JSONArray trreeJsovvn = JSONArray.parseArray(JSON.toJSONString(list));
			System.out.println("----------------成果获奖（累计）："+trreeJsovvn.toString());
			return trreeJsovvn.toString();
	   	}

}
