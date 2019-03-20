package com.pcitc.service.system;



import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.system.SysUnit;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.DataTableInfo;
import com.pcitc.base.util.DataTableInfoVo;

/**
 * 组织机构
 * @author fb
 *
 */
public interface UnitService 
{
	/**
	 * 检索组织机构
	 * @param searchJsonStr
	 * @return
	 */
	public List<TreeNode> selectUnitsByTree();
	/**
	 * 
	 * @param id
	 * @return
	 */
	public SysUnit seletUnitById(java.io.Serializable id);
	/**
	 * 保存并返回ID
	 * @param unit
	 * @return
	 */
	public Integer saveUnit(SysUnit unit);
	
	/**
	 * 更新组织机构
	 * @param unit
	 * @return
	 */
	public Integer updateUnit(SysUnit unit);
	/**
	 * 删除组织机构(禁用)
	 * @param id
	 * @return
	 */
	public Integer deleteUnit(java.io.Serializable id);
	/**
	 * 删除组织机构(真实删除)
	 * @param id
	 * @return
	 */
	public Integer deleteUnitReal(java.io.Serializable id);
	/**
	 * 获取组织机构
	 * @return
	 */
	public List<SysUnit> selectUnitByPath();
	/**
	 * 获取组织机构下的用户，包括子机构
	 * @param unitId
	 * @return
	 */
	public List<SysUser> selectUnitUsers(DataTableInfo searchConn);
	
    /**
     *获取所有组织结构的树节点
     * @return
     * @throws Exception
     */
	List<com.pcitc.base.common.TreeNode> getUnitTree() throws Exception;
	
	/**
	 * 查询部门列表
	 * @param table
	 * @return
	 * @throws Exception
	 */
	JSONObject selectUnitList(DataTableInfoVo table) throws Exception;
	/**
	 * 获取组织机构代码
	 * @param unit
	 * @return
	 */
	String getUnitCode(SysUnit unit);
	
	/**
	 * 查询某种条件下的组织机构节点，只有组织机构，没有人员、没有岗位
	 * @param unit
	 * @return
	 * @throws Exception
	 */
	List<TreeNode> getUnitTreeCond(SysUnit unit);
	
	/**
	 * 查询某种条件下的组织机构节点，有组织机构和人员，没有岗位
	 * @param unit
	 * @return
	 * @throws Exception
	 */
	List<TreeNode> getUnitTreeAndUserCond(SysUnit unit);
	
	/**
	 * 组织机构树, 有组织机构和人员, 没有岗位-- 查询某些组织机构节点的组织机构树,只查询这些节点的所有子孙和直系父辈
	 * @param unit
	 * @return
	 * @throws Exception
	 */
	public List<TreeNode> getUnitTreeAndUserByUnitCodes(Map<String,Object> paramMap);
	
	/**
	 * 通过某几个岗位编码或者这几个岗位的全部其他信息
	 * @param paramMap
	 * @return
	 */
	List<TreeNode> getPostInfoByPostCodes(Map<String,Object> paramMap);
	
	/**
	 * 通过某几个组织机构id获取这几个组织机构的全部其他信息
	 * @param paramMap
	 * @return
	 */
	List<TreeNode> getUnitInfoByUnitIds(Map<String,Object> paramMap);
	
	/**
	 * 查询某种条件下的组织机构节点，有组织机构和人员、岗位
	 * @param unit
	 * @return
	 * @throws Exception
	 */
	List<TreeNode> getUnitTreeAndPostAndUserCond(SysUnit unit);
	/**
	 *  获取组织机构树，ztree
	 * @param unit
	 * @return
	 */
	String getUnitZTreeList(String parentCode);
	/**
	 * 监理单位
	 * @param param
	 * @return
	 * @throws Exception
	 */
	LayuiTableData selectControlUnit(LayuiTableParam param) throws Exception;
	/**
	 * 
	 * @param id
	 * @return
	 */
	public SysUnit seletUnitByCode(String code);
	/**
	 *  根据名称模糊匹配组织机构（包含当前组织机构的所有父节点，不包含子节点），ztree
	 * @param unit
	 * @return
	 */
	String getUnitZTreeListByName(String name);
	
	public SysUnit getUnitByUnitPath(String unitPath);
	
	
}
