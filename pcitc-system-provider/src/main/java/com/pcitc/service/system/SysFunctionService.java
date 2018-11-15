package com.pcitc.service.system;

import java.util.List;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.system.SysButton;
import com.pcitc.base.system.SysFunction;
import com.pcitc.base.system.SysRoleFunction;
import com.pcitc.base.system.vo.SysFunctionVo;

public interface SysFunctionService {
	/**
	 * 条件查询菜单列表
	 * @param function
	 * @return
	 * @throws Exception
	 */
	LayuiTableData selectFunctionList(LayuiTableParam param) throws Exception;
	
	/**
	 * 新增或修改菜卿
	 * @param parentName 要移动到的父节点id
	 * @return
	 * @throws Exception
	 */
	int updateOrInsertFunction(SysFunctionVo function) throws Exception;
	
	/**
	 * 删除菜单
	 * @param id
	 * @return
	 * @throws Exception
	 */
	int deleteFunction(String id) throws Exception;
	
	/**
     * 初始化菜单详惿
     * @param id
     * @return
     */
    public SysFunction getFunctionById(String id);
    
    /**
	 * 根据层级显示栿
	 * @param dictionary
	 * @return
	 * @throws Exception
	 */
	List<TreeNode> selectTreeNodeByLevel(SysFunction function) throws Exception;
	
	/**
	 * 根据用户获取权限
	 * @param userId
	 * @return
	 */
	List<SysFunction> findFunctionsByUserId(String userId);
	
	/**
	 * 获取root节点（条件为parent 为空）
	 * @return
	 */
	SysFunction getRootFunction();
	
	/**
	 * 更新角色菜单关系
	 * @param rels
	 * @return
	 */
	Integer updateRoleFunctionRel(String roleId,List<SysRoleFunction> rels);
	
	/**
	 * 获取所有菜单
	 * @return
	 * @throws Exception
	 */
	List<TreeNode> selectList(String id) throws Exception;

	/**
	 * 查询子节点
	 * @param parentId
	 * @return
	 */
	List<TreeNode> findSons(String parentId);

	/**
	 * 获取树种所有节点ID集合
	 * @param treeNodes
	 * @param strings
	 */
	public void getIds(List<TreeNode> treeNodes,List<String> strings);
	
	
	/**
	 * 条件查询按钮列表
	 * @param function
	 * @return
	 * @throws Exception
	 */
	LayuiTableData selectButtonList(LayuiTableParam param) throws Exception;
	
	/**
	 * 保存按钮
	 * @param button
	 * @return
	 * @throws Exception
	 */
	int updateOrInsertButton(SysButton button) throws Exception;
	
	/**
	 * 按钮详情
	 * @param id
	 * @return
	 * @throws Exception
	 */
	SysButton getButtonById(String id) throws Exception;
	
	/**
	 * 删除按钮
	 * @param id
	 * @return
	 * @throws Exception
	 */
	int deleteButton(String id) throws Exception;
	
	String createCode(SysFunction function) throws Exception;
	/**
	 * 自动生成排序号
	 * @param function
	 * @return
	 * @throws Exception
	 */
	String createWeight(SysFunction function) throws Exception;
	
}
