package com.pcitc.web.controller.out;

import java.util.HashMap;
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

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Result;
import com.pcitc.web.common.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Statistical-API",tags = {"领导驾驶仓"})
@RestController
public class StatisticalController extends BaseController
{
	    private static final String getRightsMap = "http://kjpt-zuul/stp-proxy/statistical-api/getRightsMap";
		
	
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

}
