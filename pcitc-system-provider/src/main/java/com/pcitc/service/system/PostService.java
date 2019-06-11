package com.pcitc.service.system;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysFunction;
import com.pcitc.base.system.SysPost;
import com.pcitc.base.system.SysPostFunction;
import com.pcitc.base.system.SysUser;

/**
 * 岗位Service
 * @author fb
 *
 */
public interface PostService 
{
	/**
	 * 获取当前机构下的所有岗位
	 * @param uintId
	 * @return
	 */
	List<SysPost> findByUnit(String unitId);
	/**
	 * 根据岗位ID获得岗位
	 * @param postId
	 * @return
	 */
	SysPost findById(String postId);
	/**
	 * 根据岗位Code获得岗位
	 * @param postId
	 * @return
	 */
	SysPost findByCode(String postCode);
	/**
	 * 查询岗位下用户列表
	 * @param postCode
	 * @return
	 */
	List<SysUser> findUserByPost(String postCode);
	/**
	 * 保存岗位
	 * @param post
	 * @return
	 */
	Integer saveSysPost(SysPost post);
	/**
	 * 更新岗位
	 * @param post
	 * @return
	 */
	Integer updatePost(SysPost post);
	/**
	 * 删除岗位(逻辑删除)
	 * @param id
	 * @return
	 */
	Integer delPost(java.io.Serializable id);
	/**
	 * 删除岗位（物理删除）
	 * @param id
	 * @return
	 */
	Integer delPostReal(java.io.Serializable id);
	
	/**
	 *  获取机构下所有岗位（带分页）
	 * @param unitId
	 * @return
	 */
	LayuiTableData findByUnit(LayuiTableParam param);
	/**
	 * 删除岗位与权限关系
	 * @param post
	 * @return
	 */
	Integer delPostFunctionRel(String postId,String functionId);
	/**
	 * 添加岗位与权限关系
	 * @param post
	 * @return
	 */
	Integer addPostFunctionRel(String postId,List<SysPostFunction> functions);
	/**
	 * 
	 * @param postId
	 * @return
	 */
	List<SysFunction> getFunctionListByPost(String postId);
	/**
	 * 获取岗位编码
	 * @param post
	 * @return
	 */
	String getPostCode(SysPost post);
	/**
	 *  查找所有岗位
	 * @return
	 */
	List<SysPost> findAllSysPost();
	/**
	 * 根据岗位检索岗位下的菜单以及菜单对应的按钮列表
	 * @param postId
	 * @return
	 */
	Map<String,Set<String>> getFunctionButtonRel(String postId);
	
}
