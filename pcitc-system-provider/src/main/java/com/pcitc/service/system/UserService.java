package com.pcitc.service.system;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.system.SysUserUnit;
import com.pcitc.base.util.DataTableInfo;

/**
 * @author zhf 服务接口
 */
public interface UserService {

	public SysUser selectUserByUserId(String userId);

	public Integer updateUser(SysUser user);

	public int deleteUser(String userId);
	
	public int deleteUserReal(String userId);

	public Integer insertUser(SysUser user);
	public Integer insertUserUnit(SysUserUnit user);
	public List<SysUser> getAllUsers();
	
	public SysUser selectUserByUserName(String username);

	/**
	 * 条件查询列表
	 * 
	 * @return
	 */
	public LayuiTableData selectUserByPage(LayuiTableParam param);
	/**
	 * 条件查询列表
	 * 
	 * @return
	 */
	public LayuiTableData selectUserList(LayuiTableParam param);
	/**
	 * 检查登录名是否唯一
	 * @param userId
	 * @param userName
	 * @return
	 */
	public List<Boolean> userValidate(SysUser user);
	
	/** 
	* @author zhf
	* @date 2018年5月17日 上午9:30:34 
	* 包含用户本身的熟悉、所拥有的角色、菜单等
	*/
	public SysUser selectUserDetailsByUserId(String userId) throws Exception;
	
	/**
	 * @param roleCodes
	 * @return
	 * 根据角色编码（多个），获取所属人员
	 */
	public Object findUserByRoleCodes(Map<String,Object> paramMap);
	/**
	 * 根据所属机构加载用户信息
	 * @param tableInfo
	 * @return
	 */
	public JSONObject findUserByUnit(DataTableInfo tableInfo);
	/**
	 * 批量删除（逻辑删除）用户
	 * @return
	 */
	public Integer delUsers(List<String> userIds);
	/**
	 * 根据角色获得用户列表（分页）
	 * @param param
	 * @return
	 */
	public LayuiTableData selectUserListByRole(LayuiTableParam param);
	/**
	 *   获得没有绑定指定角色的用户列表（分页）
	 * @param param
	 * @return
	 */
	public LayuiTableData selectNotInRoleUserList(LayuiTableParam param);
	
	/**
	 * @param paramMap
	 * @return
	 * 查询用户信息，包含所属部门，多部门以“，”分开显示
	 */
	public JSONObject selectUserDetail(Map<String,Object> paramMap);

}
