package com.pcitc.web.controller.system;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.web.common.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "UserTmp-API",tags = {"临时表-用户接口"})
@RestController
public class SysTmpController extends BaseController {
	
	
	private static final String PAGE_USER_TMP_URL = "http://kjpt-zuul/system-proxy/user-tmp-api/querySysUserTmp";
	
	private static final String GET_USER_TREE_URL = "http://kjpt-zuul/system-proxy/user-tmp-api/getSysUnitTmpTreeNodeList";
	
	
	
	
	
	
	
	
   /**
	 * 获取用户（分页）
	*/
   @ApiOperation(value = "获取用户列表（分页）", notes = "获取用户列表（分页）")
   @ApiImplicitParams({
       @ApiImplicitParam(name = "page",           value = "页码", dataType = "string", paramType = "query",required=true),
       @ApiImplicitParam(name = "limit",          value = "每页显示条数", dataType = "string", paramType = "query",required=true),
       @ApiImplicitParam(name = "userUnit",       value = "机构ID", dataType = "string", paramType = "query")
   })
   @RequestMapping(value = "/user-tmp-api/page", method = RequestMethod.POST)
	public String getSysUserTmpPage(
			@RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer limit,
            @RequestParam(required = false) String userUnit,
			HttpServletRequest request, HttpServletResponse response)throws Exception 
    {

	   	LayuiTableParam param =new LayuiTableParam();
	   	param.getParam().put("userUnit", userUnit);
	   	param.setLimit(limit);
	   	param.setPage(page);
	   	//默认查询小于等于用户密级的
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PAGE_USER_TMP_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		String str=	JSON.toJSONString(layuiTableData);
		logger.info("============获取用户列表（分页） " + str);
		return str;
	}
   
   
   
   
   
   @ApiOperation(value = "查询组织机构(树)", notes = "查询组织机构(树)")
   @RequestMapping(value = "/user-tmp-api/getOrgTreeNodeList", method = RequestMethod.GET)
	public String getTreeNodeList(HttpServletRequest request, HttpServletResponse response)throws Exception
   {
           String unitId=CommonUtil.getParameter(request, "unitId", "");
           String unitRelation=CommonUtil.getParameter(request, "unitRelation", "");
           
	   		Map<String ,Object> paramMap = new HashMap<String ,Object>();
	   		paramMap.put("unitId", unitId);
	   	    paramMap.put("unitRelation", unitRelation);
	   	    paramMap.put("status", "1");
	   		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
	   		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_USER_TREE_URL, HttpMethod.POST, httpEntity, JSONArray.class);
	   		int statusCode = responseEntity.getStatusCodeValue();
 	   		JSONArray jSONArray=null;
 	   		if (statusCode == 200)
 	   		{
 	   			jSONArray = responseEntity.getBody();
 	   		}
	   		return jSONArray.toString();
	   		
	}
	

}
