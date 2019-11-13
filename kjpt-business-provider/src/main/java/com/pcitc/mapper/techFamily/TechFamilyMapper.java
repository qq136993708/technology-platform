package com.pcitc.mapper.techFamily;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.stp.techFamily.TechFamily;
import com.pcitc.base.stp.techFamily.TechFamilyExample;

public interface TechFamilyMapper {
    int countByExample(TechFamilyExample example);

    int deleteByExample(TechFamilyExample example);

    int deleteByPrimaryKey(String tfmTypeId);

    int insert(TechFamily record);

    int insertSelective(TechFamily record);

    List<TechFamily> selectByExample(TechFamilyExample example);

    TechFamily selectByPrimaryKey(String tfmTypeId);

    int updateByExampleSelective(@Param("record") TechFamily record, @Param("example") TechFamilyExample example);

    int updateByExample(@Param("record") TechFamily record, @Param("example") TechFamilyExample example);

    int updateByPrimaryKeySelective(TechFamily record);

    int updateByPrimaryKey(TechFamily record);
    
    
    /**
     * 获取技术族分类树
     * @param function
     * @return
     */
    List<TreeNode> selectTreeNodeByLevel(TechFamily techType);
    
    /**
     * 获取技术族分类树
     * @param function
     * @return
     */
    List<TreeNode> selectTreeNodeByLevelCond(TechFamily techType);
    
    /**
	 * 查询技术族分类列表
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public List<TechFamily> getTechTypeList(LayuiTableParam param);
	
	/**
	 * @param techType
	 * @return
	 * 按照固定条件修改类型
	 */
	public int updateTechTypeCondition(TechFamily techType);
	
	/**
	 * 查询最大的分类编码
	 * @param map
	 * @return
	 */
	public String getMaxTechTypeCode(HashMap<String, String> map);
}