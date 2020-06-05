package com.pcitc.web.controller.out;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.RequestProcessStatusEnum;
import com.pcitc.base.out.OutPerson;
import com.pcitc.base.system.SysUser;
import com.pcitc.web.common.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


@Api(value = "SyncController-API",tags = {"临时表信息"})
@RestController
public class SyncController extends BaseController {
	
	
	public static final String queryPatent =       "http://kjpt-zuul/stp-proxy/sync-expert-api/queryPatent";
	public static final String queryPunishSSync =       "http://kjpt-zuul/stp-proxy/sync-expert-api/queryPunishSSync";
	
	
    @ApiOperation(value = "查询临时数据-专利列表（分页）", notes = "查询临时数据-专利列表（分页）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page",           value = "页码",        dataType = "string", paramType = "query",required=true),
        @ApiImplicitParam(name = "limit",          value = "每页显示条数",  dataType = "string", paramType = "query",required=true),
        @ApiImplicitParam(name = "expertNum",      value = "专家号",        dataType = "string", paramType = "query"),
    })
    @RequestMapping(value = "/queryPatent/page", method = RequestMethod.GET)
	public String getExpertPage(
			@RequestParam(required = true) Integer page,
            @RequestParam(required = true) Integer limit,
            @RequestParam(required = false) String expertNum,
			HttpServletRequest request, HttpServletResponse response)throws Exception 
     {

    	System.out.println("----------expertNum："+expertNum);
    	LayuiTableParam param =new LayuiTableParam();
    	param.getParam().put("expertNum",expertNum);
    	param.setLimit(limit);
    	param.setPage(page);
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(queryPatent, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		
		return result.toString();
	}


   
	
    
   
    @ApiOperation(value = "查询临时数据-奖惩列表（分页）", notes = "查询临时数据-奖惩列表（分页）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page",           value = "页码",        dataType = "string", paramType = "query",required=true),
        @ApiImplicitParam(name = "limit",          value = "每页显示条数",  dataType = "string", paramType = "query",required=true),
        @ApiImplicitParam(name = "expertNum",      value = "专家号",        dataType = "string", paramType = "query"),
    })
    @RequestMapping(value = "/queryPunishSSync/page", method = RequestMethod.GET)
	public String queryPunishSSync(
			@RequestParam(required = true) Integer page,
            @RequestParam(required = true) Integer limit,
            @RequestParam(required = false) String expertNum,
			HttpServletRequest request, HttpServletResponse response)throws Exception 
     {

    	System.out.println("----------expertNum："+expertNum);
    	LayuiTableParam param =new LayuiTableParam();
    	param.getParam().put("expertNum",expertNum);
    	param.setLimit(limit);
    	param.setPage(page);
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(queryPunishSSync, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		
		return result.toString();
	}


   
	
    

}
