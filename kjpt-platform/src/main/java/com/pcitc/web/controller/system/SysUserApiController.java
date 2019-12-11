package com.pcitc.web.controller.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "SysUser-API",tags = {"用户管理-用户接口"})
@RestController
public class SysUserApiController extends BaseController{
	/**
	 * 获取用户（分页）
	 */
	private static final String USER_LIST_PAGE_URL = "http://kjpt-zuul/system-proxy/user-provider/page";
	
	/**
	 * 新增
	 */
	public static final String ADD_USER_URL = "http://kjpt-zuul/system-proxy/user-provider/add";
	
	/**
	 * 修改
	 */
	public static final String UPDATE_USER_URL = "http://kjpt-zuul/system-proxy/user-provider/update";
	
	
	
	
	
	
	@ApiOperation(value = "用户查询（分页）", notes = "用户查询（分页）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page",           value = "页码",      dataType = "string", paramType = "query",required=true),
        @ApiImplicitParam(name = "limit",          value = "每页显示条数", dataType = "string", paramType = "query",required=true),
        @ApiImplicitParam(name = "userNameKey",    value = "用户名称",    dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "userUnit",       value = "所在单位",    dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "userPost",       value = "岗位",       dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "userRole",       value = "角色",       dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "secretLevel",    value = "用户密级",    dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "unifyIdentityId",value = "统一身份ID",  dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/expert-api/query", method = RequestMethod.POST)
	public String queryExpertPage(
			
			@RequestParam(required = true) Integer page,
            @RequestParam(required = true) Integer limit,
            @RequestParam(required = false) String userNameKey,
            @RequestParam(required = false) String userUnit,
            @RequestParam(required = false) String userPost,
            @RequestParam(required = false) String userRole,
            @RequestParam(required = false) String secretLevel,
            @RequestParam(required = false) String unifyIdentityId,
			HttpServletRequest request, HttpServletResponse response)throws Exception 
     {

    	LayuiTableParam param =new LayuiTableParam();
    	param.getParam().put("userNameKey", userNameKey);
    	param.setLimit(limit);
    	param.setPage(page);
    	
    	param.getParam().put("userUnit", userUnit);
    	param.getParam().put("userPost", userPost);
    	param.getParam().put("secretLevel", secretLevel);
    	param.getParam().put("unifyIdentityId", unifyIdentityId);
    	param.getParam().put("userRole", userRole);
    	
    	//默认查询当前人所在机构及子机构的所有用户
    	String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(sysUserInfo.getUnitPath(), restTemplate, httpHeaders);
    	param.getParam().put("childUnitIds", childUnitIds);
    	
    	
    	
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(USER_LIST_PAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============获取用户列表（分页） " + result.toString());
		return result.toString();
	}
	
	
	
	
	
	
	
	

}
