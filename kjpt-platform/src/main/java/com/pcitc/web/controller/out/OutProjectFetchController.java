package com.pcitc.web.controller.out;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Result;
import com.pcitc.web.common.RestBaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value = "OutProjectFetch-API",tags = {"对外系统-项目同步接口"})
@RestController
public class OutProjectFetchController extends RestBaseController {
	
	private static final String outProjectFetch = "http://kjpt-zuul/fetchoutdata-proxy/out_project/fetch";
	private static final String insertBatch = "http://kjpt-zuul/stp-proxy/out_project/insertBatch";
	
	
	    @ApiOperation(value = "从外系统同步项目信息数据，然后保存到本地（全量）", notes = "从外系统同步项目信息数据，然后保存到本地（全量）")
	    @RequestMapping(value = "/out_project_fetch", method = RequestMethod.GET)
	    public JSONArray getOutProjectFetch(HttpServletRequest request, HttpServletResponse response) throws Exception 
	    {
	    	Result resultsDate = new Result();
	    	resultsDate.setSuccess(false);
	    	Map  condition = new HashMap();
	    	long startTime = System.currentTimeMillis(); //获取开始时间
	    	ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(outProjectFetch, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), JSONArray.class);
	    	int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) 
			{
				JSONArray jSONArray = responseEntity.getBody();
				if(jSONArray!=null && jSONArray.size()>0)
				{
					ResponseEntity<Integer> rs = this.restTemplate.exchange(insertBatch, HttpMethod.POST, new HttpEntity<JSONArray>(jSONArray, this.httpHeaders), Integer.class);
					int code = rs.getStatusCodeValue();
					if (code == 200) 
					{
						Integer count = rs.getBody();
						System.out.println(">>>>>>>>>>>>>成功插入项目信息数据： "+count+"  条");
						resultsDate.setSuccess(true);
						
					}
				}
			}
			long endTime = System.currentTimeMillis(); //获取结束时间
			System.out.println("---->同步项目-程序运行时间：" + (endTime - startTime) + "ms(毫秒)"); //输出程序运行时间
	    	return responseEntity.getBody();
	    }
	 
	 

}
