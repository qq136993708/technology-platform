package com.pcitc.service.techFamily;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.stp.techFamily.TechFamily;
import com.pcitc.base.stp.techFamily.TechFamilys;

public interface TechFamilyService {
	
	
	
	


	/**
                * 根据ID获取技术族信息详情
    */
	public TechFamilys selectTechFamilys(String id) throws Exception;
	
	 /**
	     *修改技术族信息
	*/
	public Integer updateTechFamilys(TechFamilys record)throws Exception;
	 /**
	     *根据ID删除技术族信息
	*/
	public int deleteTechFamilys(String id)throws Exception;
	public int deleteLogicTechFamilys(String id)throws Exception;
	 /**
	     * 增加技术族信息
	 */
	public Integer insertTechFamilys(TechFamilys record)throws Exception;
	
	/**
	     * 获取技术族（分页）
	*/
	public LayuiTableData getTechFamilysPage(LayuiTableParam param)throws Exception;
	
	
	public List<TreeNode> getNodeList(Map map)throws Exception;
	
	
	public List<TechFamilys> getChildListByParent(String id)throws Exception;
	
	
	
	
	
	
	
	
	
	
	
	

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

    public JSONObject getTfcProject(JSONObject jsonObject);
    
    
    
    
    public List<TechFamily> getTechFamilyListByCodes(List<String> list)throws Exception;    
    
    
    public List<TechFamily> getTechFamilyList(Map map)throws Exception;   
    
    public TechFamily getTechFamilyById(String tfmTypeId)throws Exception;
}
