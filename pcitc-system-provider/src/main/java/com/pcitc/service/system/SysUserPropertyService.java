package com.pcitc.service.system;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.system.SysUserProperty;

public interface SysUserPropertyService {
	
	/**
	 * 异步加载获取第一层 机构 和人员树
	 * @return
	 * @throws Exception
	 */
	List<TreeNode> selectUnitUserUnderOfRoot() throws Exception;
	
	/**
	 * 获取人员树的数据
	 * @return
	 * @throws Exception
	 */
	List<TreeNode> selectUserUnderOfUnitTree(String parentId,HttpServletRequest request) throws Exception;
	
	
	/**
     * 批量插入人员和数据的关联关系
     * @param currentPageList 当前页所有数据
     * @param list 要保存的数据
     * @return
     */
    Integer bantchInsertRelation(List<SysUserProperty> list,String dataType,List<String> userIds,List<String> currentPageList,String dataIds) throws Exception; 
    
    /**
     * 配置列表
     * @param tableInfo
     * @return
     * @throws Exception
     */
    LayuiTableData selectUserPropertyList(LayuiTableParam param) throws Exception;
    
    
    /**
	 * @param dataTypes
	 * @return
	 * 查询某个人在某些数据控制属性上的具体控制数据内容
	 */
	public List<SysUserProperty> selectUserPropertyByUserAndType(String userId, String functionCode);
	
	/**
	 * 部门配置树
	 */
	List<TreeNode> selectUnitTree(String parentId) throws Exception;
	
	/**
	 * 通过节点id 递归查询所有子节点
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	List<TreeNode> selectChildByChild(String parentId) throws Exception;
    
	/**
	 * @param dataTypes
	 * @return
	 * 查询某人在某个dataType下管理的数据
	 */
	public List<SysUserProperty> selectUserPropertyByUserIdAndDataType(String userId, String dataType);
}
