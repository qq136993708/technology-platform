package com.pcitc.web.system;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.service.system.SysDictionaryService;

@RestController
public class SysDictionaryProviderClient {
	
	@Autowired
	private SysDictionaryService dictionaryService;
	
	private final static Logger logger = LoggerFactory.getLogger(SysDictionaryProviderClient.class);
	
	/**
	 * 一级树节点
	 * @return
	 */
	@RequestMapping(value = "/dictionary-provider/getTreeOneLevel")
	@ResponseBody
	public List selectTreeNodeOneLevel() {
		List<TreeNode> list = null;
		try {
			list = dictionaryService.selectTreeNodeOneLevel();
			list = TreeNodeUtil.getfatherNode(list, "ROOT");
		} catch (Exception e) {
			logger.error("[数据字典-获取数据字典树失败：]", e);
		}
		return list;
	}
	
	/**
	 * 父节点下子节点
	 * @param parentId
	 * @return
	 */
	@RequestMapping(value = "/dictionary-provider/getChildNode/{parentId}")
	@ResponseBody
	public List getChildNode(@PathVariable(value = "parentId", required = true) String parentId) {
		List<TreeNode> list = null;
		try {
			list = dictionaryService.selectChildNodeByParentId(parentId);
			
		} catch (Exception e) {
			logger.error("[数据字典-获取数据字典树失败：]", e);
		}
		return list;
	}
	
	/**
	 * 新增或修改数据字典
	 * @param dictionary
	 * @return
	 */
	@RequestMapping(value = "/dictionary-provider/saveDictionary", method = RequestMethod.POST)
	public int saveDictionary(@RequestBody SysDictionary dictionary){
		int result = 500;
		try {
			result = dictionaryService.updateOrInsertDictionary(dictionary);
		} catch (Exception e) {
			logger.error("[数据字典-保存数据字典失败：]", e);
		}
		return result;
	}
	
	/**
	 * 删除数据字典
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/dictionary-provider/deleteDictionary/{id}", method = RequestMethod.POST)
	public int deleteDictionary(@PathVariable(value = "id", required = true) String id){
		int result = 500;
		try {
			result = dictionaryService.deleteDictionary(id);
		} catch (Exception e) {
			logger.error("[数据字典-删除数据字典失败：]", e);
		}
		return result;
	}
	
	/**
	 * 根据层级显示树（传过显示几级）
	 * @param dictionary
	 * @return
	 */
	@RequestMapping(value = "/dictionary-provider/getTreeByLevel", method = RequestMethod.POST)
	@ResponseBody
	public List selectTreeNodeByLevel(@RequestBody SysDictionary dictionary) {
		List<TreeNode> list = null;
		try {
			list = dictionaryService.selectTreeNodeByLevel(dictionary);
			for (int i = 0; i < list.size(); i++) {
				TreeNode tree = list.get(i);
				// 前几次默认打开
				if (tree.getLevelCode()<2) {
					tree.setOpen("true");
				} else {
					tree.setOpen("false");
				}
			}
		} catch (Exception e) {
			logger.error("[数据字典-获取数据字典树失败：]", e);
		}
		return list;
	}
	
	
	/**
	 * 获取子节点列表
	 * @param parentId
	 * @return
	 */
	@RequestMapping(value = "/dictionary-provider/getChildNodeForTable", method = RequestMethod.POST)
	public LayuiTableData getChildNodeForTable(@RequestBody LayuiTableParam param) {
		LayuiTableData data = null;
		try {
			data = dictionaryService.selectDictionaryList(param);
			
		} catch (Exception e) {
			logger.error("[数据字典-获取子节点列表失败：]", e);
		}
		return data;
	}
	
	/**
	 * 获取字典详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/dictionary-provider/getDictionary/{id}", method = RequestMethod.POST)
	public SysDictionary getDictionary(@PathVariable(value = "id", required = true) String id){
		SysDictionary dictionary = null;
		try {
			dictionary = dictionaryService.getDictionaryById(id);
		} catch (Exception e) {
			logger.error("[数据字典-初始化详情失败：]", e);
		}
		return dictionary;
	}
	/**
	 * 获取字典详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/dictionary-provider/getDictionaryByCode/{code}", method = RequestMethod.POST)
	public SysDictionary getDictionaryByCode(@PathVariable(value = "code", required = true) String code){
		SysDictionary dictionary = null;
		try {
			dictionary = dictionaryService.getDictionaryByCode(code);
		} catch (Exception e) {
			logger.error("[数据字典-初始化详情失败：]", e);
		}
		return dictionary;
	}
	/**
	 * 根据父编码获取子集
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/dictionary-provider/dictionary/{parentCode}", method = RequestMethod.POST)
	public List<SysDictionary> getDictionaryListByParentCode(@PathVariable(value="parentCode", required=false) String parentCode){
		List<SysDictionary> dictionary = null;
		try {
			dictionary = dictionaryService.getDictionaryListByParentCode(parentCode);
			logger.info("=============数据字典-根据父编码获取子集"+dictionary.size()); 
		} catch (Exception e) {
			logger.error("[数据字典-根据父编码获取子集失败：]", e);
		}
		return dictionary;
	}
	
	/**
	 * 生成code码
	 * @param dictionary
	 * @return
	 */
	@RequestMapping(value = "/dictionary-provider/create-code", method = RequestMethod.POST,consumes = "application/json;charset=utf-8")
	public String createCode(@RequestBody SysDictionary dictionary){
		String code = null;
		try {
			code = dictionaryService.createCode(dictionary);
		} catch (Exception e) {
			logger.error("[数据字典-自动生成code码失败：]", e);
		} 
		return code;
	}
	@RequestMapping(value = "/dictionary-provider/dictionary/get-map-dicionarys", method = RequestMethod.POST)
	public Map<String,List<SysDictionary>> getDictionaryMaps(@RequestBody List<String> parentCodes){
		
		return dictionaryService.getMapDictionaryList(parentCodes);
	}
	
	/**
	 * 删除数据字典
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/dictionary-provider/batch-delete/{ids}", method = RequestMethod.POST)
	public int batchDelete(@PathVariable(value = "ids", required = true) String ids){
		int result = 500;
    	String[] dataIdArr = ids.split("-");
    	List<String> dataIdList = Arrays.asList(dataIdArr);
		try {
			result = dictionaryService.batchDelete(dataIdList);
		} catch (Exception e) {
			logger.error("[数据字典-删除数据字典失败：]", e);
		}
		return result;
	}
}
