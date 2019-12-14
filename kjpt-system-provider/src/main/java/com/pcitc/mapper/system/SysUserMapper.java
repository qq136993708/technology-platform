package com.pcitc.mapper.system;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.pcitc.base.system.SysUser;
import com.pcitc.base.system.SysUserExample;

public interface SysUserMapper {
	int countByExample(SysUserExample example);

	int deleteByPrimaryKey(String userId);

	int insert(SysUser record);

	int insertSelective(SysUser record);

	List<SysUser> selectByExample(SysUserExample example);

	SysUser selectByPrimaryKey(String userId);

	SysUser selectUserByIdentityId(String unifyIdentityId);

	//根据用户id查询当前信息-new
	SysUser currentUserInfo(String userId);


	int updateByPrimaryKey(SysUser record);

	/**
	 * @param roleCodes
	 * @return 根据角色编码（多个），获取所属人员
	 */
	public List<SysUser> findUserByRoleCodes(Map<String, Object> paramMap);

	/**
	 * @param paramMap
	 * @return 在act的视图表中，查询某个groupid对应的用户
	 */
	public List<String> findUserByGroupIdFromACT(List list);

	/**
	 * @param roleCodes
	 * @return 根据角色编码（多个），获取所属人员
	 */
	public List<SysUser> selectUserDetail(Map<String, Object> paramMap);

	List<SysUser> getSysUserListByUserUnit(SysUser vo);
	
	
	public	List getList(Map map);
	public  Long getCount(Map map);
	
	public SysUser getUserByUserNameAndPassword(Map<String, String> paramMap);
	

}
