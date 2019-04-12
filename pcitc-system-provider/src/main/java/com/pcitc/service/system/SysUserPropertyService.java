package com.pcitc.service.system;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.system.SysFunctionProperty;
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
	List<TreeNode> selectChildByChild(String parentCode) throws Exception;
    
	/**
	 * @param dataTypes
	 * @return
	 * 查询某人在某个dataType下管理的数据
	 */
	public List<SysUserProperty> selectUserPropertyByUserIdAndDataType(String userId, String dataType);
	
	/**
	 * @param paramMap
	 * @return
	 * 检索机构(树),通过岗位、菜单、配置项信息
	 */
	public List<TreeNode> selectUnitListForUnitDataConfig(HashMap<String,Object> paramMap);
	
	/**
	 * @param sysFunctionProperty
	 * @return
	 * 保存菜单、配置项、岗位三者和配置内容的关联
	 */
	public int saveFunctionConfigPost(SysFunctionProperty sysFunctionProperty);
	
	/**
	 * 数据项控制，查询当前人所属岗位、菜单，对应的属性控制信息
	 */
	public List<SysFunctionProperty> dataFilterFunction(HashMap<String,Object> paramMap);
	
}
