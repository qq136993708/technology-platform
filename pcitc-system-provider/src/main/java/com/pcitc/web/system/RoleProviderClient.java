package com.pcitc.web.system;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysRole;
import com.pcitc.service.system.RoleService;

@Api(value="角色接口",tags= {"角色相关操作服务接口"})
@RestController
public class RoleProviderClient {

	//private final static Logger logger = LoggerFactory.getLogger(RoleProviderClient.class);
	
	@Autowired
	RoleService roleService;
	
	@ApiOperation(value="检索角色信息",notes="根据角色ID检索角色信息。")
	@RequestMapping(value = "/role-provider/role/get-role/{roleId}", method = RequestMethod.POST)
	public SysRole getRoleInfo(@PathVariable(value = "roleId", required = true) String roleId) {
		return roleService.findById(roleId);
	}
	@ApiOperation(value="检索角色列表(带分页)",notes="根据检索条件检索角色信息，分页返回数据。")
	@RequestMapping(value = "/role-provider/role/role-list", method = RequestMethod.POST)
	public LayuiTableData selectRoleByPage(@RequestBody LayuiTableParam param) 
	{
		return roleService.selectRoleList(param);
	}
	
	@ApiOperation(value="添加角色",notes="保存数据到持久化结构中,同名角色禁止添加，操作返回持久化数据的数量，1为成功，0不成功。")
	@RequestMapping(value = "/role-provider/role/add-role", method = RequestMethod.POST)
	public java.io.Serializable addRoleInfo(@RequestBody SysRole role) 
	{
		return roleService.saveRole(role);
	}
	
	@ApiOperation(value="更新角色",notes="持久化结构数据更新,操作返回持久化数据的数量，1为成功，0不成功。")
	@RequestMapping(value = "/role-provider/role/upd-role", method = RequestMethod.POST)
	public java.io.Serializable updRoleInfo(@RequestBody SysRole role) 
	{
		return roleService.updateRole(role);
	}
	
	@ApiOperation(value="删除角色(逻辑删除)",notes="删除指定ID角色信息，逻辑删除，物理数据依然存在于持久化数据结构中。")
	@RequestMapping(value = "/role-provider/role/del-role/{roleId}", method = RequestMethod.DELETE)
	public Integer delRole(@PathVariable(value = "roleId", required = true) String roleId)
	{
		return roleService.deleteRole(roleId);
	}
	@ApiOperation(value="删除角色(物理删除)",notes="删除指定ID角色信息，物理删除，物理数据将从持久化数据结构中删除，同时删除用户角色关系数据！")
	@RequestMapping(value = "/role-provider/role/del-role-real/{roleId}", method = RequestMethod.POST)
	public Integer delRoleReal(@PathVariable(value = "roleId", required = true) String roleId)
	{
		return roleService.deleteRoleReal(roleId);
	}
	@ApiOperation(value="赋予用户角色",notes="指定用户列表赋予角色，输入参数：角色ID，用户ID列表对象，同时会更新用户信息表中关于角色的内容！")
	@RequestMapping(value = "/role-provider/role/user-role-add", method = RequestMethod.POST)
	public Integer addUserRoleRel(
			@RequestParam(value="userIds", required=false)String userIds,
			@RequestParam(value="roleId", required=false)String roleId)
	{
		List<String> userIdArray = new ArrayList<String>();
		if(!StringUtils.isBlank(userIds))
		{
			for(java.util.Iterator<?> iter =JSONArray.parseArray(userIds).iterator();iter.hasNext();)
			{
				userIdArray.add(iter.next().toString());
			}
		}
		return roleService.addUserRoleRel(roleId, userIdArray);
	}
	@ApiOperation(value="移除用户角色",notes="移除用户列表已赋予的角色，输入参数：角色ID，用户ID列表对象，同时会更新用户信息表中关于角色的内容！")
	@RequestMapping(value = "/role-provider/role/user-role-del", method = RequestMethod.POST)
	public Integer delUserRoleRel(
			@RequestParam(value="userIds", required=false)String userIds,
			@RequestParam(value="roleId", required=false)String roleId)
	{
		List<String> userIdArray = new ArrayList<String>();
		if(!StringUtils.isBlank(userIds))
		{
			for(java.util.Iterator<?> iter =JSONArray.parseArray(userIds).iterator();iter.hasNext();)
			{
				userIdArray.add(iter.next().toString());
			}
		}
		return roleService.delUserRoleRel(roleId, userIdArray);
	}
	
	/*
	 * 角色权限接口，已废弃
	 * @RequestMapping(value = "/role-provider/role/role-func-tree/{roleId}", method = RequestMethod.POST)
	public List<TreeNode> getFunctionTreeByRole(@PathVariable(value = "roleId", required = true) String roleId)
	{
		return  roleService.findFunctionTreeByRole(roleId);
	}*/
	@ApiOperation(value="获取角色列表(不分页)",notes="获取所有角色信息，不分页。")
	@RequestMapping(value = "/role-provider/role/role-list-all", method = RequestMethod.POST)
	public List<SysRole> getAllRoles()
	{
		return  roleService.findAllRoles();
	}
	
	@ApiOperation(value="生成角色编码",notes="根据输入角色名称，生成角色编码，编码规则为汉字拼音大写首字母。")
	@RequestMapping(value = "/role-provider/role/role-code",method = RequestMethod.POST)
	public String getRoleCode(@RequestBody SysRole role) {
		
		return roleService.getRoleCode(role);
	}
}
