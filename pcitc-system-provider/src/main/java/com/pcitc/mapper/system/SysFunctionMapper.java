package com.pcitc.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pcitc.base.common.TreeNode;
import com.pcitc.base.system.SysFunction;
import com.pcitc.base.system.SysFunctionExample;

public interface SysFunctionMapper {
    int deleteByPrimaryKey(String id);

    int insertSelective(SysFunction record);

    SysFunction selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysFunction record);
    
    int countByExample(SysFunctionExample example);

    int deleteByExample(SysFunctionExample example);

    int insert(SysFunction record);

    List<SysFunction> selectByExample(SysFunctionExample example);

    int updateByExampleSelective(@Param("record") SysFunction record, @Param("example") SysFunctionExample example);

    int updateByExample(@Param("record") SysFunction record, @Param("example") SysFunctionExample example);

    int updateByPrimaryKey(SysFunction record);
    
    List<SysFunction> selectFunctionList(SysFunction record);
    
    /**
     * 初始化菜单详情
     * @param id
     * @return
     */
    SysFunction getFunctionById(String id);
    
    
    List<TreeNode> selectTreeNodeByLevel(SysFunction function);
    
    /** 
	* @author zhf
	* @date 2018年5月17日 上午9:36:21 
	* 根据用户id查询所有的功能
	*/
	List<SysFunction> selectFuntionByUserId(String userId);
	
	/**
	 * 查询子节点数量
	 * @param parentId
	 * @return
	 */
	int getCountByParentId(String parentId);
	
	/**
	 * 按照编码最大的排序
	 * @param parentCode
	 * @return
	 */
	List<SysFunction> findByParentCodeOrderByCodeDesc(String parentCode);
	
	/**
	 * 根据id 查询parent_code
	 * @param parentId
	 * @return
	 */
	String  getCodeById(String parentId);

	/**
	 * 查询子节点
	 * @param parentId
	 * @return
	 */
	List<TreeNode> findSons(String parentId);
	
	/**
	 * 查询当前节点下的子节点
	 * @param parentId
	 * @return
	 */
	List<SysFunction> findChildren(String parentId);
	
	/**
	 * 查询level_code 小于3的
	 * @param record
	 * @return
	 */
	List<TreeNode> selectFunctionByLevelCode(@Param("id") String id);
	
	/**
	 * 检验同一级下是否有重复菜单
	 * @param levelCode
	 * @param name
	 * @return
	 */
 	int selectSameName(@Param("parentId") String parentId,@Param("name") String name,@Param("id") String id);
 	
 	/**
 	 * 按排序大小排列的集合
 	 * @param parentCode
 	 * @return
 	 */
 	List<SysFunction> findWeightOrderByDesc(String parentCode);
 	
 	/**
 	 * 修改是否为父节点 0 否 1是
 	 * @param parentId
 	 * @return
 	 */
 	int updateNodeIsParent(@Param("parentId")String parentId,@Param("isParent")Integer isParent);
 	
 	/**
 	 * 获取parentId
 	 * @param id
 	 * @return
 	 */
 	String getParentIdById(String id);
 	
 	/**
 	 * 修改是否为叶子节点  0 否 1是
 	 * @param parentId
 	 * @param isLeaf
 	 * @return
 	 */
 	int updateNodeIsLeaf(@Param("parentId")String parentId,@Param("isLeaf")Integer isLeaf);
 	
	
}
