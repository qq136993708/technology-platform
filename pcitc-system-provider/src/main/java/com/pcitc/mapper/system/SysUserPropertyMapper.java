package com.pcitc.mapper.system;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.pcitc.base.common.TreeNode;
import com.pcitc.base.system.SysUserProperty;
import com.pcitc.base.system.SysUserPropertyExample;
import com.pcitc.base.system.vo.SysUserPropertyVo;

public interface SysUserPropertyMapper {
    int countByExample(SysUserPropertyExample example);

    int deleteByExample(SysUserPropertyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysUserProperty record);

    int insertSelective(SysUserProperty record);

    List<SysUserProperty> selectByExample(SysUserPropertyExample example);

    SysUserProperty selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysUserProperty record, @Param("example") SysUserPropertyExample example);

    int updateByExample(@Param("record") SysUserProperty record, @Param("example") SysUserPropertyExample example);

    int updateByPrimaryKeySelective(SysUserProperty record);

    int updateByPrimaryKey(SysUserProperty record);
    
    /**
     * 根节点下部门
     * @return
     */
    List<TreeNode> selectUintTreeByRootId();
    
    
    /**
     * 集团下的人员（大领导董事长级别）
     * @return
     */
    List<TreeNode> selectUserUnderRoot();
    
    /**
     * 集团下的岗位
     * @return
     */
    List<TreeNode> selectPostUnderRoot();
    
    
    
    
    /**
     * 部门下部门
     * @param parentId
     * @return
     */
    List<TreeNode> selectChildUnitByUnitId(String parentId);
    
    /**
     * 部门下人员
     * @param parentId
     * @return
     */
    List<TreeNode> selectUserByUintId(String parentId);
    
    /**
     * 部门下的岗位
     * @param parentId
     * @return
     */
    List<TreeNode> selectPostByUintId(String parentId);
    
    /**
     * 岗位下人员
     * @param parentId
     * @return
     */
    List<TreeNode> selectUserByPostId(String parentId);
    
    /**
     * 批量插入人员和数据的关联关系
     * @param list
     * @return
     */
    Integer bantchInsertRelation(List<SysUserProperty> list);
    
    /**
     * 根据类型删除人员数据关系
     * @param dataType
     * @return
     */
    Integer deleteByDataType(@Param("dataType")String dataType,@Param("userIds")List<String> userIds);
    
    /**
     * 删除当前页数据
     * @param property
     * @return
     */
    Integer deleteCurrentPage(SysUserProperty property);
    
    /**
     * 查询人员配置列表（项目）
     * @param userId
     * @return
     */
    List<SysUserPropertyVo> selectUserPropertyList(SysUserPropertyVo userProperty);
    
    /**
     * 查询人员配置列表（部门）
     * @param userProperty
     * @return
     */
    List<SysUserPropertyVo> selectUserPropertyUnitList(SysUserPropertyVo userProperty);
    
    
    /**
	 * @param dataTypes
	 * @return
	 * 查询某个人在某些数据控制属性上的具体控制数据内容
	 */
	public List<SysUserProperty> selectUserPropertyByUserAndType(Map<String,Object> paramMap);
	public SysUserProperty getSysUserProperty(Map<String,Object> paramMap);
	
	
	/**
	 * 根据userId 获取 data_id 长串
	 * @param userId
	 * @return
	 */
    SysUserProperty getDataIdByUserId(String userId);
	
    /**
     * 根据用户id修改用户关联的数据id串
     * @param userId
     * @return
     */
	Integer updateDataIdByUserId(@Param("dataId")String dataId,@Param("dataType") String dataType,@Param("userId")String userId);
	
	/**
	 * 部门配置关系树
	 * @param userProperty
	 * @return
	 */
	List<TreeNode> selectUserPropertyUnitTree(SysUserPropertyVo userProperty);
	
	/**
	 * 根据dataType和用户id查询配置关系
	 * @param userId
	 * @param dataType
	 * @return
	 */
	SysUserProperty getDataIdByUserIdAndDataType(@Param("userId")String userId,@Param("dataType")String dataType);
	
	
	Integer updateDataIdByUserIdAndDataType(@Param("dataId")String dataId,@Param("dataType") String dataType,@Param("userId")String userId);
	
	/**
	 * 所选部门下所有部门用户
	 * @param parentId
	 * @return
	 */
	List<TreeNode> selectUserByUnitCode(@Param("parentCode") String parentCode);
	
	/**
	 * 所选部门下所有部门岗位
	 * @param parentId
	 * @return
	 */
	List<TreeNode> selectPostByUnitCode(@Param("parentCode") String parentCode);
	
	/**
	 * 所选部门下所有部门岗位人员
	 * @param parentId
	 * @return
	 */
	List<TreeNode> selectPostUserByUnitCode(@Param("parentCode") String parentCode);
	
	/**
	 * 查询直属研究院配置
	 * @param userProperty
	 * @return
	 */
	List<SysUserPropertyVo> selectUserPropertyDicList(SysUserPropertyVo userProperty);
	
	
}