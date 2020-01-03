package com.pcitc.mapper.system;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.pcitc.base.system.SysRole;
import com.pcitc.base.system.SysRoleExample;

public interface SysRoleMapper {


	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_role
	 * @mbg.generated  Fri Apr 13 16:40:44 CST 2018
	 */
	int deleteByExample(SysRoleExample example);

	/**
	 * 通过传入的id查询名称
	 */
	SysRole selectNameById(String roleId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_role
	 * @mbg.generated  Fri Apr 13 16:40:44 CST 2018
	 */
	int deleteByPrimaryKey(String roleId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_role
	 * @mbg.generated  Fri Apr 13 16:40:44 CST 2018
	 */
	int insert(SysRole record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_role
	 * @mbg.generated  Fri Apr 13 16:40:44 CST 2018
	 */
	int insertSelective(SysRole record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_role
	 * @mbg.generated  Fri Apr 13 16:40:44 CST 2018
	 */
	List<SysRole> selectByExample(SysRoleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_role
	 * @mbg.generated  Fri Apr 13 16:40:44 CST 2018
	 */
	SysRole selectByPrimaryKey(String roleId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_role
	 * @mbg.generated  Fri Apr 13 16:40:44 CST 2018
	 */
	int updateByExampleSelective(@Param("record") SysRole record, @Param("example") SysRoleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_role
	 * @mbg.generated  Fri Apr 13 16:40:44 CST 2018
	 */
	int updateByExample(@Param("record") SysRole record, @Param("example") SysRoleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_role
	 * @mbg.generated  Fri Apr 13 16:40:44 CST 2018
	 */
	int updateByPrimaryKeySelective(SysRole record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_role
	 * @mbg.generated  Fri Apr 13 16:40:44 CST 2018
	 */
	int updateByPrimaryKey(SysRole record);
	
	
	 List getList(Map map);
	    
	    int getCount(Map map);
	    
}
