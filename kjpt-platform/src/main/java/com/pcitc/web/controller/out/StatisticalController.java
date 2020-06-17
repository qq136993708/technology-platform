package com.pcitc.web.controller.out;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.ChartData;
import com.pcitc.base.common.Result;
import com.pcitc.base.out.OutProject;
import com.pcitc.base.researchplatform.PlatformInfoModel;
import com.pcitc.base.system.SysUser;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Statistical-API",tags = {"领导驾驶仓"})
@RestController
public class StatisticalController extends BaseController
{
	    private static final String getRightsMap = "http://kjpt-zuul/stp-proxy/statistical-api/getRightsMap";
	    private static final String getKyptInfoGrupCountList = "http://kjpt-zuul/stp-proxy/statistical-api/getKyptInfoGrupCountList";
	    private static final String getAchieveMaintainGrupCountList = "http://kjpt-zuul/stp-proxy/statistical-api/getAchieveMaintainGrupCountList";
		
	    private static final String countByPatentType = "http://kjpt-zuul/stp-proxy/patent-provider/patentInfo/countByPatentType";
	    private static final String getTongjiList = "http://kjpt-zuul/stp-proxy/statistical-api/getTongjiList";

	    private static final String getPlatFormList = "http://kjpt-zuul/stp-proxy/statistical-api/getPlatFormList";

	    
	    
	    
	    
	
	    @ApiOperation(value = "首页-知识产权", notes = "首页-知识产权")
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
	    
	    
	    
	    @ApiOperation(value = "首页-科研平台", notes = "首页-科研平台")
		@RequestMapping(value = "/getKyptInfoGrupCountList", method = RequestMethod.GET)
	    @ResponseBody
	   	public String getKyptInfoGrupCountList( HttpServletRequest request, HttpServletResponse response) throws Exception
	   	{
	   		
	    	Map  map = new HashMap();
			ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(getKyptInfoGrupCountList, HttpMethod.POST,new HttpEntity<Map>(map, this.httpHeaders), JSONArray.class);
			JSONArray temparray = responseEntity.getBody();
			List<ChartData> list = JSONObject.parseArray(temparray.toJSONString(), ChartData.class);
			JSONArray trreeJsovvn = JSONArray.parseArray(JSON.toJSONString(list));
			System.out.println("-----------------科研平台："+trreeJsovvn.toString());
			return trreeJsovvn.toString();
	   	}
	    
	    

	    @ApiOperation(value = "首页-成果获奖（累计）", notes = "首页-成果获奖（累计）")
		@RequestMapping(value = "/getAchieveMaintainGrupCountList", method = RequestMethod.GET)
	    @ResponseBody
	   	public String getAchieveMaintainGrupCountList( HttpServletRequest request, HttpServletResponse response) throws Exception
	   	{
	    	
	    	Map  map = new HashMap();
			ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(getAchieveMaintainGrupCountList, HttpMethod.POST,new HttpEntity<Map>(map, this.httpHeaders), JSONArray.class);
			JSONArray temparray = responseEntity.getBody();
			List<ChartData> list = JSONObject.parseArray(temparray.toJSONString(), ChartData.class);
			JSONArray trreeJsovvn = JSONArray.parseArray(JSON.toJSONString(list));
			System.out.println("----------------成果获奖（累计）："+trreeJsovvn.toString());
			return trreeJsovvn.toString();
	   	}
	    
	    
	    
	    
	    
	    @ApiOperation(value="首页-专利数量")
	    @RequestMapping(value = "/getPatentCountByType", method = RequestMethod.GET)
	    @ResponseBody
	    public String countByPatentType(@RequestParam(required = false) String type)
	    {
	        Map<String, Object> condition = new HashMap<>(6);
	        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
	        ResponseEntity<List> responseEntity = this.restTemplate.exchange(countByPatentType, HttpMethod.POST, new HttpEntity<Map>(condition,this.httpHeaders),List.class);

	        List<Map> list=responseEntity.getBody();
	        List<ChartData>  reuslt=new ArrayList();
	        if(list!=null) 
	        {
	        	for(int i=0;i<list.size();i++)
	        	{
	        		Map pm=list.get(i);
	        		ChartData chartData=new ChartData();
	        		chartData.setName((String)pm.get("name"));
	        		chartData.setValue((Integer)pm.get("num"));
	        		reuslt.add(chartData);
	        	}
	        }
	        JSONArray json = JSONArray.parseArray(JSON.toJSONString(reuslt));
	        return json.toString();
	    }
	    
	    

	    @ApiOperation(value = "科研能力-科技人才", notes = "科研能力-科技人才")
		@RequestMapping(value = "/getTongjiList", method = RequestMethod.GET)
	    @ResponseBody
	   	public String getTongjiList( HttpServletRequest request, HttpServletResponse response) throws Exception
	   	{
	    	Map  map = new HashMap();
			ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(getTongjiList, HttpMethod.POST,new HttpEntity<Map>(map, this.httpHeaders), JSONArray.class);
			JSONArray temparray = responseEntity.getBody();
			List<ChartData> list = JSONObject.parseArray(temparray.toJSONString(), ChartData.class);
			JSONArray trreeJsovvn = JSONArray.parseArray(JSON.toJSONString(list));
			System.out.println("----------------科研能力-科技人才："+trreeJsovvn.toString());
			return trreeJsovvn.toString();
	   	}
	    
	    @ApiOperation(value = "科研能力-科研平台", notes = "科研能力-科研平台")
		@RequestMapping(value = "/getPlatFormList", method = RequestMethod.GET)
	    @ResponseBody
	   	public String getPlatFormList(@RequestParam(required = false) String level, HttpServletRequest request, HttpServletResponse response) throws Exception
	   	{
	    	Map  map = new HashMap();
	    	map.put("level",level);
			ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(getPlatFormList, HttpMethod.POST,new HttpEntity<Map>(map, this.httpHeaders), JSONArray.class);
			JSONArray temparray = responseEntity.getBody();
			List<PlatformInfoModel> list = JSONObject.parseArray(temparray.toJSONString(), PlatformInfoModel.class);
			JSONArray trreeJsovvn = JSONArray.parseArray(JSON.toJSONString(list));
			System.out.println("----------------科研能力-科技人才："+trreeJsovvn.toString());
			return trreeJsovvn.toString();
	   	}
	    

}
