package com.pcitc.web.controller.system;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.RequestProcessStatusEnum;
import com.pcitc.base.stp.techFamily.TechFamily;
import com.pcitc.base.system.SysCollect;
import com.pcitc.base.system.SysFunction;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.MD5Util;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;
import com.pcitc.web.utils.TokenInterUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "SysUser-API",tags = {"用户管理-用户、岗位、机构 接口"})
@RestController
public class SysUserApiController extends BaseController{
	/**
	 * 获取用户（分页）
	 */
	private static final String USER_LIST_PAGE_URL = "http://kjpt-zuul/system-proxy/user-provider/page";
	
	/**
	 * 新增
	 */
	public static final String ADD_USER_URL = "http://kjpt-zuul/system-proxy/user-provider/add_user";
	
	/**
	 * 修改用户信息
	 */
	public static final String UPDATE_USER_URL = "http://kjpt-zuul/system-proxy/user-provider/update_user";
	/**
	 * 修改岗位
	 */
	public static final String UPDATE_USER_POST_URL = "http://kjpt-zuul/system-proxy/user-provider/update_user_post";
	/**
	 * 修改角色
	 */
	public static final String UPDATE_USER_ROLE_URL = "http://kjpt-zuul/system-proxy/user-provider/update_user_role";
	
	/**
	 * 修改密级
	 */
	public static final String UPDATE_USER_SECRET_URL = "http://kjpt-zuul/system-proxy/user-provider/updateSecretLevel";
	
	/**
	 * 获取用户信息
	 */
	public static final String GET_USER_URL = "http://kjpt-zuul/system-proxy/user-provider/user/get-user/";
	
	private static final String USER_UNIQUE_CHECK_URL = "http://kjpt-zuul/system-proxy/user-provider/user/user-validate";
	
	
	private static final String LIST_BY_IDS_URL = "http://kjpt-zuul/system-proxy/post-provider/post/get_posts_by_list_ids";
	
	private static final String GET_POST_LIST_BYUNIT = "http://kjpt-zuul/system-proxy/post-provider/post/get-post-list";
	
	

	   // 待办任务数
		private static final String PENDING_COUNT_URL = "http://kjpt-zuul/system-proxy/task-provider/getPendingCountByUserId/";

	
	/**
	 * 我的收藏
	 */
	 private static final String USER_DETAILS_URL = "http://kjpt-zuul/system-proxy/user-provider/user/getSysCollectListByUserId/";
	 
	 
	 
	 
	    @ApiOperation(value = "根据单据级别选知悉范围用户（分页）", notes = "根据单据级别选知悉范围用户（分页）")
	    @ApiImplicitParams({
	        @ApiImplicitParam(name = "page",           value = "页码",      dataType = "string", paramType = "query"),
	        @ApiImplicitParam(name = "limit",          value = "每页显示条数", dataType = "string", paramType = "query"),
	        @ApiImplicitParam(name = "recodeLevel",    value = "单据密级",    dataType = "string", paramType = "query"),
	        @ApiImplicitParam(name = "name",    value = "人员或单位名称",    dataType = "string", paramType = "query")
	    })
	    @RequestMapping(value = "/user-api/getSysUserPageByRecodeLevel", method = RequestMethod.GET)
		public String getSysUserPageByRecodeLevel(
				
				@RequestParam(required = true) Integer page,
	            @RequestParam(required = true) Integer limit,
	            @RequestParam(required = false) String recodeLevel,
	            @RequestParam(required = false) String name,
				HttpServletRequest request, HttpServletResponse response)throws Exception
	     {

	    	LayuiTableParam param =new LayuiTableParam();
	    	param.setLimit(limit);
	    	param.setPage(page);
	    	
	    	
	    	param.getParam().put("userDelflag", 0);
	    	param.getParam().put("recodeLevel", String.valueOf(Integer.valueOf(recodeLevel).intValue()));
	    	param.getParam().put("name",name);
	    	
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
		
	 
	 
	
	@ApiOperation(value = "用户查询（分页）", notes = "用户查询（分页）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page",           value = "页码",      dataType = "string", paramType = "query",required=true),
        @ApiImplicitParam(name = "limit",          value = "每页显示条数", dataType = "string", paramType = "query",required=true),
        @ApiImplicitParam(name = "userNameKey",    value = "用户名称",    dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "userUnit",       value = "所在单位",    dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "userPost",       value = "岗位",       dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "userRole",       value = "角色",       dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "secretLevel",    value = "用户密级",    dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "unifyIdentityId",value = "统一身份ID",  dataType = "string", paramType = "query"),
    })
    @RequestMapping(value = "/user-api/query", method = RequestMethod.POST)
	public String queryUserPage(
			
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
    	
    	param.getParam().put("userDelflag", 0);
    	
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
	
	
	
	 /**
	  *根据ID获取用户信息详情
	 */
    @ApiOperation(value = "根据ID获取用户信息详情", notes = "根据ID获取用户信息详情")
	@RequestMapping(value = "/user-api/get/{id}", method = RequestMethod.GET)
	public String getSysUser(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
   	Result resultsDate = new Result();
   	ResponseEntity<SysUser> responseEntity = this.restTemplate.exchange(GET_USER_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SysUser.class);
		int statusCode = responseEntity.getStatusCodeValue();
		SysUser sysUser = responseEntity.getBody();
		logger.info("============远程返回  statusCode " + statusCode);
		if (statusCode == 200) {
			resultsDate = new Result(true,RequestProcessStatusEnum.OK.getStatusDesc());
			resultsDate.setData(sysUser);
		} else {
			resultsDate = new Result(false, "根据ID获取用户信息详情失败");
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		return result.toString();
	}
   
   
   
 
   
   

    @ApiOperation(value = "保存、修改用户信息", notes = "保存、修改用户信息")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "userId",          value = "主键", dataType = "string", paramType = "form"),
    @ApiImplicitParam(name = "userName",        value = "登录名（账号）", dataType = "string", paramType = "form",required=true),
    @ApiImplicitParam(name = "userDisp",        value = "用户姓名", dataType = "string", paramType = "form",required=true),
    @ApiImplicitParam(name = "unifyIdentityId", value = "统一身份ID", dataType = "string", paramType = "form",required=true),
    @ApiImplicitParam(name = "userUnit",        value = "用户所属机构ID", dataType = "string", paramType = "form",required=true),
    @ApiImplicitParam(name = "userUnitName",    value = "用户所属机构名称", dataType = "string", paramType = "form"),
    @ApiImplicitParam(name = "userComment",     value = "描述", dataType = "string", paramType = "form"),
    @ApiImplicitParam(name = "userMail",        value = "用户邮箱", dataType = "string", paramType = "form"),
    @ApiImplicitParam(name = "userMobile",      value = "用户手机号", dataType = "string", paramType = "form"),
    @ApiImplicitParam(name = "userPhone",       value = "用户传真", dataType = "string", paramType = "form")
	})
	@RequestMapping(method = RequestMethod.POST, value = "/user-api/save")
	public String saveExpert(@RequestBody  SysUser sysUser,HttpServletRequest request, HttpServletResponse response) throws Exception {
	Result resultsDate = new Result();
	String id=sysUser.getUserId();
	JSONObject parma = JSONObject.parseObject(JSONObject.toJSONString(sysUser));
    System.out.println(">>>>>>>>>> 参数: "+parma.toJSONString());
		
		if (id!=null && !id.equals("")) 
		{
			ResponseEntity<SysUser> se = this.restTemplate.exchange(GET_USER_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SysUser.class);
			SysUser oldSysUser = se.getBody();
			oldSysUser.setUnifyIdentityId(sysUser.getUnifyIdentityId());
			oldSysUser.setUserComment(sysUser.getUserComment());
			oldSysUser.setUserMail(sysUser.getUserMail());
			oldSysUser.setUserDisp(sysUser.getUserDisp());
			oldSysUser.setUserUnit(sysUser.getUserUnit());
			oldSysUser.setUserUnitName(sysUser.getUserUnitName());;
			oldSysUser.setUserPhone(sysUser.getUserPhone());
			oldSysUser.setUserMobile(sysUser.getUserMobile());
			oldSysUser.setUserMail(sysUser.getUserMail());
			oldSysUser.setUserName(sysUser.getUserName());
			oldSysUser.setUserHeadPic(sysUser.getUserHeadPic());
			ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(UPDATE_USER_URL, HttpMethod.POST, new HttpEntity<SysUser>(oldSysUser, this.httpHeaders), Integer.class);
			int statusCode = responseEntity.getStatusCodeValue();
			Integer dataId = responseEntity.getBody();
			// 返回结果代码
			if (statusCode == 200) {
				resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
			} else {
				resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
			}
		} else 
		{
			
			ResponseEntity<List> checkStatus = this.restTemplate.exchange(USER_UNIQUE_CHECK_URL, HttpMethod.POST, new HttpEntity<SysUser>(sysUser, this.httpHeaders), List.class);
			List<Boolean> unique = checkStatus.getBody();
			if (!unique.get(0)) 
			{
				resultsDate = new Result(false, "登录名不能重复");
			}else if (!unique.get(1)) 
			{
				resultsDate = new Result(false, "邮箱不能重复");
			}else if (!unique.get(2)) 
			{
				resultsDate = new Result(false, "统一身份ID不能重复");
			}else
			{
				sysUser.setUserCreateTime(DateUtil.dateToStr(new Date(), DateUtil.FMT_SS));
				sysUser.setUserDelflag(0);
				String dateid = UUID.randomUUID().toString().replaceAll("-", "");
				sysUser.setUserId(dateid);
				sysUser.setIsDomain(1);
				sysUser.setUserLevel(2);
				sysUser.setUserPassword(MD5Util.MD5Encode(sysUser.getUserPassword()));
				sysUser.setSecretLevel(Constant.USER_SECRET_LEVEL_NOT);
				ResponseEntity<String> responseEntity = this.restTemplate.exchange(ADD_USER_URL, HttpMethod.POST, new HttpEntity<SysUser>(sysUser, this.httpHeaders), String.class);
				int statusCode = responseEntity.getStatusCodeValue();
				String dataId = responseEntity.getBody();
				// 返回结果代码
				if (statusCode == 200) {
					resultsDate = new Result(true,RequestProcessStatusEnum.OK.getStatusDesc());
				} else {
					resultsDate = new Result(false, "保存用户信息失败");
				}
			}
			
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		return result.toString();
}


       

    @ApiOperation(value = "修改岗位信息", notes = "修改岗位信息")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "userId",       value = "主键", dataType = "string", paramType = "form",required=true),
    @ApiImplicitParam(name = "userPost",     value = "用户岗位编码（多个逗号分开）", dataType = "string", paramType = "form",required=true),
    @ApiImplicitParam(name = "postName",     value = "用户岗位名称（多个逗号分开）", dataType = "string", paramType = "form")
	})
	@RequestMapping(method = RequestMethod.POST, value = "/user-api/updateUserPost")
	public String updatePost(@RequestBody  SysUser sysUser,HttpServletRequest request, HttpServletResponse response) throws Exception {
		
    	Result resultsDate = new Result();
		
		
	    System.out.println(">>>>>>>>>> 参数userPost: "+sysUser.getUserPost());
		ResponseEntity<SysUser> se = this.restTemplate.exchange(GET_USER_URL + sysUser.getUserId(), HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SysUser.class);
		SysUser oldSysUser = se.getBody();
		oldSysUser.setUserPost(sysUser.getUserPost());
		oldSysUser.setPostName(sysUser.getPostName());
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(UPDATE_USER_POST_URL, HttpMethod.POST, new HttpEntity<SysUser>(oldSysUser, this.httpHeaders), Integer.class);
		int statusCode = responseEntity.getStatusCodeValue();
		Integer dataId = responseEntity.getBody();
		// 返回结果代码
		if (statusCode == 200) {
			resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
		} else {
			resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		return result.toString();
}
    
    
    
    
    
    @ApiOperation(value = "修改角色信息", notes = "修改角色信息")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "userId",       value = "主键", dataType = "string", paramType = "form",required=true),
    @ApiImplicitParam(name = "userRole",     value = "用户角色编码（多个逗号分开）", dataType = "string", paramType = "form",required=true)
	})
	@RequestMapping(method = RequestMethod.POST, value = "/user-api/updateUserRole")
	public String updateRole(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
    	Result resultsDate = new Result();
		String userId=CommonUtil.getParameter(request, "userId", "");
		String userRole=CommonUtil.getParameter(request, "userRole", "");
	    System.out.println(">>>>>>>>>> 参数userPost: "+userRole);
		ResponseEntity<SysUser> se = this.restTemplate.exchange(GET_USER_URL + userId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SysUser.class);
		SysUser oldSysUser = se.getBody();
		oldSysUser.setUserRole(userRole);
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(UPDATE_USER_ROLE_URL, HttpMethod.POST, new HttpEntity<SysUser>(oldSysUser, this.httpHeaders), Integer.class);
		int statusCode = responseEntity.getStatusCodeValue();
		Integer dataId = responseEntity.getBody();
		// 返回结果代码
		if (statusCode == 200) {
			resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
		} else {
			resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		return result.toString();
}
	
    
    
	
	
    @ApiOperation(value = "修改密级信息", notes = "修改密级信息")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "userId",          value = "主键", dataType = "string", paramType = "form",required=true),
    @ApiImplicitParam(name = "secretLevel",     value = "用户密级", dataType = "string", paramType = "form",required=true),
	})
	@RequestMapping(method = RequestMethod.POST, value = "/user-api/updateUserSecretLevel")
	public String updateSecretLevel(@RequestBody  SysUser sysUser,HttpServletRequest request, HttpServletResponse response) throws Exception {
		
    	Result resultsDate = new Result();
	    System.out.println(">>>>>>>>>> 参数userPost: "+sysUser.getSecretLevel());
		ResponseEntity<SysUser> se = this.restTemplate.exchange(GET_USER_URL + sysUser.getUserId(), HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SysUser.class);
		SysUser oldSysUser = se.getBody();
		//加入日志
		String secretLevelStr=EquipmentUtils.getDicNameByParentCodeAndValue("ROOT_KJPT_YHMJ",  sysUser.getSecretLevel(), restTemplate, httpHeaders);
		TokenInterUtils.saveSecurityadminSecretLevelLog("用户密级:"+oldSysUser.getSecretLevelStr()+"修改为"+secretLevelStr, "/user-api/updateUserSecretLevel", restTemplate, httpHeaders, request, this.getUserProfile());
		
		oldSysUser.setSecretLevel(sysUser.getSecretLevel());
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(UPDATE_USER_SECRET_URL, HttpMethod.POST, new HttpEntity<SysUser>(oldSysUser, this.httpHeaders), Integer.class);
		int statusCode = responseEntity.getStatusCodeValue();
		Integer dataId = responseEntity.getBody();
		// 返回结果代码
		if (statusCode == 200) {
			resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
		} else {
			resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		return result.toString();
}
    
    
    
    @ApiOperation(value = "根据机构ID获取所属的所有岗位", notes = "根据机构ID获取所属的所有岗位")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "unitId",           value = "机构ID", dataType = "string", paramType = "query",required=true)
    })
	@RequestMapping(value = "/post-api/getPostListByUnitId", method = RequestMethod.GET)
	public String getPostListByUnitId(@RequestParam(value = "unitId", required = true) String unitId) throws Exception {
		
		Result resultsDate = new Result();
		System.out.println("unit id :" + unitId);
		List  list = this.restTemplate.exchange(GET_POST_LIST_BYUNIT, HttpMethod.POST, new HttpEntity<String>(unitId, this.httpHeaders), List.class).getBody();
		JSONArray jsonObject = JSONArray.parseArray(JSON.toJSONString(list));
		System.out.println(JSONObject.toJSON(jsonObject).toString());
		resultsDate.setData(list);
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		return result.toString();
	}
    
    @ApiOperation(value = "根据userId获取收藏", notes = "根据userId获取收藏")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "userId",           value = "用户Id", dataType = "string", paramType = "query",required=true)
    })
    @RequestMapping(value = "/collect-api/getSysCollectByUserId", method = RequestMethod.GET)
	public String getSysCollectByUserId(@RequestParam(value = "userId", required = true) String userId) throws Exception {
		
		Result resultsDate = new Result();
		// 用户有哪些菜单权限
		JSONArray jSONArray =   this.restTemplate.exchange(USER_DETAILS_URL + userId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), JSONArray.class).getBody();
		
		System.out.println(jSONArray.toString());
		resultsDate.setData(jSONArray);
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		return result.toString();
	}
    
  
    
    
    @ApiOperation(value = "根据岗位IDS（多个）查询岗位列表", notes = "根据岗位IDS（多个）查询岗位列表")
	@ApiImplicitParams({
        @ApiImplicitParam(name = "ids",           value = "岗位IDS(多个用逗号分开)", dataType = "string", paramType = "query",required=true)
    })
	@RequestMapping(value = "/post-api/getPostListByIds", method = RequestMethod.GET)
	public String getPostListByIds( @RequestParam(required = true) String ids,HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result resultsDate = new Result();
		List returnlist = new ArrayList();
		if (!ids.equals("")) 
		{
			String chkbox[] = ids.split(",");
			if (chkbox != null && chkbox.length > 0)
			{
				List<String> list = Arrays.asList(chkbox);
				JSONArray jsonObject = JSONArray.parseArray(JSON.toJSONString(list));
				HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
				ResponseEntity<List> responseEntity = restTemplate.exchange(LIST_BY_IDS_URL, HttpMethod.POST, entity, List.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					returnlist = responseEntity.getBody();

				}
			}
		}
		resultsDate.setData(returnlist);
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		return result.toString();
	}
    
    
    
    
    
    /**
	  *根据ID获取用户待办任务数
	 */
    @ApiOperation(value = "根据ID获取用户待办任务数", notes = "根据ID获取用户待办任务数")
	@RequestMapping(value = "/task-api/getPendingCountByUserId", method = RequestMethod.GET)
	public String getPendingCountByUserId(@RequestParam(value = "userId", required = true) String userId , HttpServletRequest request, HttpServletResponse response) throws Exception 
    {
  	    Result resultsDate = new Result();
  	    System.out.println(">>>>>>>>>> getPendingCountByUserId参数userId: "+userId);
  	    ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(PENDING_COUNT_URL + userId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), JSONObject.class);
		int statusCode = responseEntity.getStatusCodeValue();
		JSONObject JSONObject = responseEntity.getBody();
		if (statusCode == 200) 
		{
			resultsDate = new Result(true,RequestProcessStatusEnum.OK.getStatusDesc());
			long count=JSONObject.getLongValue("count");
			resultsDate.setData(count);
		} else {
			resultsDate = new Result(false, "根据ID获取用户信息详情失败");
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		return result.toString();
	}
  
   
   
   
}
