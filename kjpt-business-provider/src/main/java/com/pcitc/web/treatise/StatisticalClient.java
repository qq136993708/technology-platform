package com.pcitc.web.treatise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.ChartData;
import com.pcitc.base.researchplatform.PlatformInfoModel;
import com.pcitc.service.researchplatform.PlatformService;
import com.pcitc.service.treatise.StatisticalService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "statisticalClient-api", description = "统计")
@RestController
@RequestMapping(value = "/statistical-api")
public class StatisticalClient {
	    @Autowired
	    private StatisticalService statisticalService;
	    @Autowired
	    private PlatformService platformService;
	    
	    
	    @ApiOperation(value = "首页-知识产权", notes = "首页-知识产权")
	    @RequestMapping(value = "/getRightsMap", method = RequestMethod.POST)
	    public JSONObject getRightsMap(@RequestBody(required = false) Map param)
	    {
	    	Map map=statisticalService.getRightsMap();
	    	JSONObject jsonObj = JSONObject.parseObject(JSON.toJSONString(map));
	    	return jsonObj;
	    }
	    
	    
	    @ApiOperation(value = "科研平台", notes = "科研平台")
	    @RequestMapping(value = "/getKyptInfoGrupCountList", method = RequestMethod.POST)
	    public JSONArray getKyptInfoGrupCountList(@RequestBody(required = false) Map param)
	    {
	        List<PlatformInfoModel>  list=platformService.getKyptInfoGrupCountList();
	        List<ChartData>  reuslt=new ArrayList();
	        if(list!=null) 
	        {
	        	for(int i=0;i<list.size();i++)
	        	{
	        		PlatformInfoModel pm=list.get(i);
	        		ChartData chartData=new ChartData();
	        		chartData.setName(pm.getPlatformName());
	        		chartData.setValue(pm.getNameCount());
	        		reuslt.add(chartData);
	        	}
	        }
	        JSONArray json = JSONArray.parseArray(JSON.toJSONString(reuslt));
	        return json;
	    }
	    
	    
	    
	    
	    @ApiOperation(value = "成果获奖（累计）", notes = "成果获奖（累计）")
	    @RequestMapping(value = "/getAchieveMaintainGrupCountList", method = RequestMethod.POST)
	    public JSONArray getAchieveMaintainGrupCountList(@RequestBody(required = false) Map param)
	    {
	    	List list=statisticalService.getAchieveMaintainGrupCountList();
	    	JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
	        return json;
	    }
	    
	    
	    
	    
	    

	   

}
