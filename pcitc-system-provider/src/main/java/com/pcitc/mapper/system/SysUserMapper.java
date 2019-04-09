package com.pcitc.mapper.system;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.pcitc.base.system.SysUser;
import com.pcitc.base.system.SysUserExample;

public interface SysUserMapper {
    int countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(String userId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
    
    /**
	 * @param roleCodes
	 * @return
	 * 根据角色编码（多个），获取所属人员
	 */
	public List<SysUser> findUserByRoleCodes(Map<String,Object> paramMap);
	
	/**
	 * @param paramMap
	 * @return
	 * 在act的视图表中，查询某个groupid对应的用户
	 */
	public List<String> findUserByGroupIdFromACT(String groupId);
	
	/**
	 * @param roleCodes
	 * @return
	 * 根据角色编码（多个），获取所属人员
	 */
	public List<SysUser> selectUserDetail(Map<String,Object> paramMap);
	
	
	List<SysUser> querySysUserListByPage(SysUser vo);

	Long countByQuerySysUserList(SysUser vo);
	
	
	List<SysUser> getSysUserListByUserUnit(SysUser vo);

	Long getSysUserCountByUserUnit(SysUser vo);
	
	
	
	

	
}