package com.pcitc.service.system;

import java.util.List;
import java.util.Map;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.system.SysDictionary;

/**
 * @author masw
 * 数据字典业务逻辑层
 */
public interface SysDictionaryService {
	
	/**
	 * 获取树一级
	 * @return
	 * @throws Exception
	 */
	List<TreeNode> selectTreeNodeOneLevel() throws Exception;
	
	/**
	 * 获取子节点
	 * @return
	 * @throws Exception
	 */
	List<TreeNode> selectChildNodeByParentId(String parentId) throws Exception;
	
	/**
	 * 新增或修改数据字典
	 * @param dictionary
	 * @return
	 * @throws Exception
	 */
	int updateOrInsertDictionary(SysDictionary dictionary) throws Exception;
	
	/**
	 * 删除数据字典 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	int deleteDictionary(String id) throws Exception;
	
	/**
	 * 根据层级显示树
	 * @param dictionary
	 * @return
	 * @throws Exception
	 */
	List<TreeNode> selectTreeNodeByLevel(SysDictionary dictionary) throws Exception;

	
	
	/**
	 * 条件查询菜单列表
	 * @param function
	 * @return
	 * @throws Exception
	 */
	LayuiTableData selectDictionaryList(LayuiTableParam param) throws Exception;
	
	/**
	 * 初始化字典详情
	 * @param id
	 * @return
	 * @throws Exception
	 */
	SysDictionary getDictionaryById(String id) throws Exception;
	/**
	 * 初始化字典详情
	 * @param id
	 * @return
	 * @throws Exception
	 */
	SysDictionary getDictionaryByCode(String code) throws Exception;
	
	/**
	 * 根据字典编码查询字典
	 * @param parentCode
	 * @return
	 */
	public List<SysDictionary> getDictionaryListByParentCode(String parentCode);
	
	
	String createCode(SysDictionary dictionary) throws Exception;
	/**
	 *  检索多个字典
	 * @author fb  
	 * @param parentCodes
	 * @return   
	 * Description: 
	 * Title: getMapDictionaryList
	 */
	public Map<String,List<SysDictionary>> getMapDictionaryList(List<String> parentCodes);
	
	
	/**
	 * 批量删除数据字典
	 * @param dataIds
	 * @return
	 */
	int batchDelete(List<String> dataIdList) throws Exception;
}
