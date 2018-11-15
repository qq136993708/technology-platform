package com.pcitc.web.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.system.SysUserUnit;
import com.pcitc.service.system.PostService;
import com.pcitc.service.system.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="用户接口类",tags= {"用户相关操作服务接口"})
@RestController
public class UserProviderClient {
	
	private final static Logger logger = LoggerFactory.getLogger(UserProviderClient.class); 
	
	@Autowired
    private UserService userService;
	
	@Autowired
	private PostService postService;
	
	//@Autowired
    //private SysUserPropertyService sysUserPropertyService;
	
	@ApiOperation(value="根据用户名检索用户",notes="根据用户名获取用户信息，返回用户实体数据。")
	@RequestMapping(value = "/user-provider/user/get-user-byname/{username}", method = RequestMethod.GET)
	public SysUser selectUserByUserName(@PathVariable(value = "username", required = true) String username) throws Exception {
		return userService.selectUserByUserName(username);
	}
	
	@ApiOperation(value="根据岗位检索用户列表",notes="根据岗位代号获取用户列表，返回用户实体列表数据。")
	@RequestMapping(value = "/user-provider/user/get-user-bypostcode/{postCode}", method = RequestMethod.POST)
	public List<SysUser> selectUsersByPostCode(@PathVariable(value = "postCode", required = true) String postCode) throws Exception {
		return postService.findUserByPost(postCode);
	}
	
	@ApiOperation(value="根据用户ID检索用户",notes="根据ID获取用户信息，返回用户实体数据。")
	@RequestMapping(value = "/user-provider/user/get-user/{userId}", method = RequestMethod.GET)
	public SysUser selectUserByUserId(@PathVariable(value = "userId", required = true) String userId) throws Exception {
		return userService.selectUserByUserId(userId);
	}
	@ApiOperation(value="更新用户信息",notes="更新用户信息，如果用户角色、组织机构、所属岗位有变化，则同时更新这些信息。")
	@RequestMapping(value = "/user-provider/user/update-user", method = RequestMethod.POST)
	public Integer updateUser(@RequestBody SysUser user) {
		logger.info("update user.... "+JSON.toJSONString(user));
		return userService.updateUser(user);
	}

	@ApiOperation(value="删除用户(逻辑删除)",notes="删除指定ID用户信息，逻辑删除，物理数据依然存在于持久化数据结构中。")
	@RequestMapping(value = "/user-provider/user/delete-user/{userId}", method = RequestMethod.POST)
	public int delUserByUserId(@PathVariable("userId") String userId) {
		logger.info("delete user....");
		return userService.deleteUser(userId);
	}
	
	@ApiOperation(value="添加用户",notes="保存数据到持久化结构中，同时保存用户所属角色、组织机构、所属岗位信息。")
	@RequestMapping(value = "/user-provider/user/add-user", method = RequestMethod.POST)
	public Integer saveUserInfo(@RequestBody SysUser user) {
		logger.info("add user....");
		return userService.insertUser(user);
	}
	@ApiOperation(value="添加用户组织关联",notes="保存数据到持久化结构中。")
	@RequestMapping(value = "/user-provider/user/add-user_unit", method = RequestMethod.POST)
	public Integer saveUserUnitInfo(@RequestBody SysUserUnit user) {
		logger.info("add user....");
		return userService.insertUserUnit(user);
	}
	/*@RequestMapping(value = "/user-provider/all-users", method = RequestMethod.GET)
	public List<SysUser> getAllUsers() {
		logger.info("all user....");
		return userService.getAllUsers();
	}*/

	@ApiOperation(value = "查询用户列表-人员选择", notes = "查询用户列表-人员选择,返回Object对象")
	@RequestMapping(value = "/user-provider/user/users-page")
	public Object selectUserByPage(@RequestBody LayuiTableParam param) {
		return userService.selectUserByPage(param);
	}
	
	@ApiOperation(value="检索用户列表(带分页)",notes="根据检索条件分页获取用户列表信息。")
	@RequestMapping(value = "/user-provider/user/user-list")
	public LayuiTableData selectUserList(@RequestBody LayuiTableParam param) {
		return userService.selectUserList(param);
	}
	
	/** 
	* @author zhf
	* @date 2018年5月17日 下午1:51:15 
	* 包含user基本信息、菜单信息
	*/
	@ApiOperation(value="检索用户(包含权限)",notes="根据ID检索用户信息，同时检索用户菜单权限数据。")
	@RequestMapping(value = "/user-provider/user/user-details/{userId}", method = RequestMethod.GET)
	public SysUser selectUserDetailsByUserId(@PathVariable(value = "userId", required = true) String userId) throws Exception {
		return userService.selectUserDetailsByUserId(userId);
	}
	/**
	 * 当前角色下的所有用户
	 * @param jsonStr
	 * @return
	 */
	@ApiOperation(value="检索用户列表(带分页)已赋角色",notes="根据角色检索用户列表信息。")
	@RequestMapping(value = "/user-provider/user/user-in-role", method = RequestMethod.POST)
	public LayuiTableData selectUserInRole(@RequestBody LayuiTableParam param) 
	{
		return userService.selectUserListByRole(param);
	}
	/**
	 * 没有指定当前角色的用户
	 * @param jsonStr
	 * @return
	 */
	@ApiOperation(value="检索用户列表(带分页)未赋角色",notes="根据角色检索没有赋予该角色的用户列表信息。")
	@RequestMapping(value = "/user-provider/user/user-not-role", method = RequestMethod.POST)
	public LayuiTableData selectUserNotInRole(@RequestBody LayuiTableParam param) {
		return userService.selectNotInRoleUserList(param);
	}
	@ApiOperation(value="用户数据校验",notes="校验用户名、邮箱数据是否重复。")
	@RequestMapping(value = "/user-provider/user/user-validate", method = RequestMethod.POST)
	public List<Boolean> validateUser(@RequestBody SysUser user)throws Exception 
	{
		return userService.userValidate(user);
	}
	/*
	@RequestMapping(value = "/user-provider/user/get-user-by-unit", method = RequestMethod.POST)
	public JSONObject selectUserByUnit(@RequestBody DataTableInfo tableInfo)throws Exception 
	{
		return userService.findUserByUnit(tableInfo);
	}*/
	@ApiOperation(value="批量逻辑删除用户",notes="逻辑删除用户列表，一次批量逻辑删除指定ID列表的用户。")
	@RequestMapping(value = "/user-provider/user/delete-users", method = RequestMethod.POST)
	public int delUsers(@RequestBody List<String> userIds) 
	{
		return userService.delUsers(userIds);
	}
	
	@ApiOperation(value="查询用户详情",notes="包含所属部门信息:登录方法时调用")
	@RequestMapping(value = "/user-provider/user/details", method = RequestMethod.POST)
	public JSONObject selectUserDetail(@RequestParam(value="jsonStr", required=false) String jsonStr) throws Exception {
		String userName = null;
		String userPassword = null;
		String userId = null;
		System.out.println("1后台selectUserDetail==========="+jsonStr);
		JSONObject reJson = JSONObject.parseObject(jsonStr);
		
		if (reJson.get("userName") != null && !reJson.get("userName").equals("")) {
			userName = reJson.get("userName").toString();
		}
		if (reJson.get("userPassword") != null && !reJson.get("userPassword").equals("")) {
			userPassword = reJson.get("userPassword").toString();
		}
		if (reJson.get("userId") != null && !reJson.get("userId").equals("")) {
			userId = reJson.get("userId").toString();
		}
		
		JSONObject retJson = new JSONObject();
		
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("userName", userName);
		paramMap.put("userPassword", userPassword);
		paramMap.put("userId", userId);
		
		retJson = userService.selectUserDetail(paramMap);
		System.out.println("2后台selectUserDetail==========="+retJson);
		return retJson;
	}
}
