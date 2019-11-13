package com.pcitc.service.system;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.system.SysFunction;
import com.pcitc.base.system.SysRole;
import com.pcitc.base.system.SysUser;

/**
 * 角色
 * @author fb
 *
 */
public interface RoleService 
{
	/**
	 * 根据角色名称模糊匹配获取角色列表
	 * @param searchStr
	 * @return
	 */
	PageInfo<SysRole> findRoles(String searchStr);
	/**
	 * 获得用户的角色
	 * @param userId
	 * @return
	 */
	List<SysRole> findRoleByUser(String userId);
	/**
	 * 获得当前角色的所有用户(带分页)
	 * @param roleId
	 * @param userName
	 * @return
	 */
	PageInfo<SysUser> findUsersPageByRole(String roleId,String userName,String pageParamJsonStr);
	/**
	 * 根据角色ID获得角色
	 * @param roleId
	 * @return
	 */
	SysRole findById(String roleId);
	/**
	 * 保存角色信息
	 * @param role
	 * @return
	 */
	java.io.Serializable saveRole(SysRole role);
	/**
	 * 用户角色分配
	 * @param userId
	 * @param roles
	 * @return
	 */
	Integer userRoleRelUpdate(String userId,List<SysRole> roles);
	/**
	 * 更新角色
	 * @param role
	 * @return
	 */
	Integer updateRole(SysRole role);
	/**
	 * 删除角色(禁用)
	 * @param id
	 * @return
	 */
	Integer deleteRole(java.io.Serializable id);
	/**
	 * 删除角色(真实删除)
	 * @param id
	 * @return
	 */
	Integer deleteRoleReal(java.io.Serializable id); 
	/**
	 * 绑定用户与角色
	 * @param roleId
	 * @param userIds
	 * @return
	 */
	Integer addUserRoleRel(String roleId,List<String> userIds);
	/**
	 * 解除用户与角色的关系
	 * @param roleId
	 * @param userIds
	 * @return
	 */
	Integer delUserRoleRel(String roleId,List<String> userIds);
	/**
	 * 根据角色获得菜单列表
	 * @param roleId
	 * @return
	 */
	List<SysFunction> findFunctionsByRole(String roleId);
	/**
	 * 根据角色获得授权树
	 * @param roleId
	 * @return
	 */
	List<TreeNode> findFunctionTreeByRole(String roleId);
	/**
	 * 获取所有可用角色
	 * @return
	 */
	List<SysRole> findAllRoles();
	/**
	 *  获取角色列表
	 * @param param
	 * @return
	 */
	LayuiTableData selectRoleList(LayuiTableParam param);
	/**
	 * 获取角色代码
	 * @param role
	 * @return
	 */
	String getRoleCode(SysRole role);
}
