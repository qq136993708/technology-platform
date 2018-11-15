package com.pcitc.mapper.system;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pcitc.base.common.TreeNode;
import com.pcitc.base.system.SysDictionary;

/**
 * @author masw
 * 数据字典数据访问层
 */
public interface SysDictionaryMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysDictionary record);

    int insertSelective(SysDictionary record);

    SysDictionary selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysDictionary record);

    int updateByPrimaryKeyWithBLOBs(SysDictionary record);

    int updateByPrimaryKey(SysDictionary record);
    
    /**
     * 获取一级树
     * @return
     */
    List<TreeNode> selectTreeNodeOneLevel();
    
    /**
     * 根据父节点查询子节点
     * @param parentId
     * @return
     */
    List<TreeNode> selectChildNodeByParentId(String parentId);
    
    /**
     * 根据层级显示对应层级树
     * @param dictionary
     * @return
     */
    List<TreeNode> selectTreeNodeByLevel(SysDictionary dictionary);
    
    
    /**
     * 查询子节点列表
     * @param record
     * @return
     */
    List<SysDictionary> selectDictionaryList(SysDictionary record);
    
    /**
     * 详情获取
     * @param id
     * @return
     */
    SysDictionary getDictionaryById(String id);
    /**
     * 详情获取
     * @param id
     * @return
     */
    SysDictionary getDictionaryByCode(String code);
    
    /**
     * 修改父节点 是isparent属性
     * @param parentId
     * @return
     */
    int updateNodeIsParent(String parentId);
    
    /**
     * 根据父级编码查询子集
     * @param record
     * @return
     */
    List<SysDictionary> selectDictionaryListByParentCode(SysDictionary record);
    
	/**
	 * 查询子节点数量
	 * @param parentId
	 * @return
	 */
	int getCountByParentId(String parentId);
	
	/**
	 * 检验同一级下是否有重复字典
	 * @param levelCode
	 * @param name
	 * @return
	 */
	int selectSameName(@Param("parentId") String parentId,@Param("name") String name, @Param("id") String id);
}