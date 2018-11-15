package com.pcitc.service.techFamily;

import java.util.HashMap;
import java.util.List;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.stp.techFamily.TechFamily;

public interface TechFamilyService {

	/**
	 * 根据层级显示树
	 * @param dictionary
	 * @return
	 * @throws Exception
	 */
	public List<TreeNode> selectTreeNodeByLevel(TechFamily techType);
	
	/**
	 * 根据层级显示树
	 * @param dictionary
	 * @return
	 * @throws Exception
	 */
	public List<TreeNode> selectTreeNodeByLevelCond(TechFamily techType);
	
	/**
	 * 查询技术族分类列表
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public LayuiTableData getTechTypeList(LayuiTableParam param);
	
	
	/**
	 * @param techType
	 * @return
	 * @throws Exception
	 */
	public List<TechFamily> selectTechFamilyTypeList(TechFamily techType);
	
	public int saveTechFamilyType(TechFamily techType);
	
	public int updateTechFamilyType(TechFamily techType);
	
	public int deleteTechFamilyType(TechFamily techType);
	
	/**
	 * 查询最大的分类编码
	 * @param map
	 * @return
	 */
	public String getMaxTechTypeCode(HashMap<String, String> map);
}
