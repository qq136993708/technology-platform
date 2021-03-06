package com.pcitc.mapper.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.pcitc.base.common.TreeNode;
import com.pcitc.base.system.SysUnit;
import com.pcitc.base.system.SysUnitExample;

public interface SysUnitMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_unit
	 * @mbg.generated  Fri Apr 13 16:40:44 CST 2018
	 */
	long countByExample(SysUnitExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_unit
	 * @mbg.generated  Fri Apr 13 16:40:44 CST 2018
	 */
	int deleteByExample(SysUnitExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_unit
	 * @mbg.generated  Fri Apr 13 16:40:44 CST 2018
	 */
	int deleteByPrimaryKey(String unitId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_unit
	 * @mbg.generated  Fri Apr 13 16:40:44 CST 2018
	 */
	int insert(SysUnit record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_unit
	 * @mbg.generated  Fri Apr 13 16:40:44 CST 2018
	 */
	int insertSelective(SysUnit record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_unit
	 * @mbg.generated  Fri Apr 13 16:40:44 CST 2018
	 */
	List<SysUnit> selectByExample(SysUnitExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_unit
	 * @mbg.generated  Fri Apr 13 16:40:44 CST 2018
	 */
	SysUnit selectByPrimaryKey(String unitId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_unit
	 * @mbg.generated  Fri Apr 13 16:40:44 CST 2018
	 */
	int updateByExampleSelective(@Param("record") SysUnit record, @Param("example") SysUnitExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_unit
	 * @mbg.generated  Fri Apr 13 16:40:44 CST 2018
	 */
	int updateByExample(@Param("record") SysUnit record, @Param("example") SysUnitExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_unit
	 * @mbg.generated  Fri Apr 13 16:40:44 CST 2018
	 */
	int updateByPrimaryKeySelective(SysUnit record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_unit
	 * @mbg.generated  Fri Apr 13 16:40:44 CST 2018
	 */
	int updateByPrimaryKey(SysUnit record);
	
	/**
	 * 部门树所有节点
	 * @return
	 */
	List<TreeNode> getUnitTree();
	
	/**
	 * 查询部门列表
	 * @param unit
	 * @return
	 */
	List<SysUnit> selectUnitList(SysUnit unit);
	
	
	/**
	 * 组织机构树, 有组织机构和人员, 没有岗位-- 查询某些组织机构节点的组织机构树,只查询这些节点的所有子孙和直系父辈
	 * @param paramMap
	 * @return
	 */
	List<TreeNode> getUnitTreeAndUserByUnitCodes(Map<String,Object> paramMap);
	
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
	 * 查询某种条件下的组织机构节点，有组织机构和人员，没有岗位
	 * @param unit
	 * @return
	 */
	List<TreeNode> getUnitTreeAndUserCond(SysUnit unit);
	
	/**
	 * 查询某种条件下的组织机构节点，有组织机构和人员、岗位
	 * @param unit
	 * @return
	 */
	List<TreeNode> getUnitTreeAndPostAndUserCond(SysUnit unit);
	
	/**
	 * 查询监理单位
	 * @return
	 */
	List<SysUnit> selectControlUnit(SysUnit unit);

	/**
	 * 根据机构id查询机构名称
	 * @return
	 */
	Map<String, Object> selectUnitNameByIds(Map params);
	
	/**
	 * 查询某种条件下的组织机构节点，有组织机构和岗位, 没有人员
	 * @param unit
	 * @return
	 * @throws Exception
	 */
	public List<TreeNode> getUnitPostTree(HashMap<String,Object> paramMap);
	
	
	
	/**
	 * 查询子机构
	 * @param unit
	 * @return
	 * @throws Exception
	 */
	public List<SysUnit> getChildscUnitBycodes(List list);
	
	/**
	 * 查询未删除的机构
	 * @param unit
	 * @return
	 * @throws Exception
	 */
	public List<SysUnit> getAllList();


	/**
	 * 根据单位名称查询单位id
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public String getUnitIdByUnitName(String name);
	
	/**
	 * 根据单位Path查询所有子机构
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public List<SysUnit> getAllChildsByIUnitPath(String unitPath);
	
	
	
	  
}