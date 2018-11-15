package com.pcitc.web.system;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.system.SysButton;
import com.pcitc.base.system.SysFunction;
import com.pcitc.base.system.vo.SysFunctionVo;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.service.system.SysFunctionService;

@RestController
public class SysFunctionProviderClient {
	
	
	@Autowired
	private SysFunctionService functionService;
	
	
	private final static Logger logger = LoggerFactory.getLogger(SysFunctionProviderClient.class);
	
	
	@RequestMapping(value = "/function-provider/function_list",method = RequestMethod.POST)
	public LayuiTableData selectFunctionByPage(@RequestBody LayuiTableParam param) {
		LayuiTableData data = null;
		try {
			data = functionService.selectFunctionList(param);
		} catch (Exception e) {
			logger.error("[菜单管理-查询菜单列表失败：]", e);
		}
		return data;
	}
	
	/**
	 * 新增或修改菜单
	 * @param function
	 * @return
	 */
	@RequestMapping(value = "/function-provider/saveFunction", method = RequestMethod.POST)
	public int saveFunction(@RequestBody SysFunctionVo function){
		int result = 500;
		try {
			result = functionService.updateOrInsertFunction(function);
		} catch (Exception e) {
			logger.error("[菜单管理-保存菜单失败：]", e);
		}
		return result;
	}
	
	/**
	 * 删除菜单
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/function-provider/deleteFunction/{id}", method = RequestMethod.POST)
	public int deleteDictionary(@PathVariable(value = "id", required = true) String id){
		int result = 500;
		try {
			result = functionService.deleteFunction(id);
		} catch (Exception e) {
			logger.error("[菜单管理-删除菜单失败：]", e);
		}
		return result;
	}
	
	
	/**
	 * 初始化菜单详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/function-provider/getFunction/{id}", method = RequestMethod.POST)
	public SysFunction getFunction(@PathVariable(value = "id", required = true) String id){
		SysFunction function = null;
		try {
			function = functionService.getFunctionById(id);
		} catch (Exception e) {
			logger.error("[菜单管理-初始化菜单菜单失败：]", e);
		}
		return function;
	}
	/**
	 * 显示某个节点下的几层
	 * @param dictionary
	 * @return
	 */
	@RequestMapping(value = "/function-provider/getTreeByLevel", method = RequestMethod.POST)
	public List<TreeNode> selectTreeNodeByLevel(@RequestBody SysFunction function) {
		List<TreeNode> list = null;
		try {
			list = functionService.selectTreeNodeByLevel(function);
			for (int i = 0; i < list.size(); i++) {
				TreeNode tree = list.get(i);
				// 前几层默认打开
				if (tree.getLevelCode()<1) {
					tree.setOpen("true");
				} else {
					tree.setOpen("false");
				}
				
				// 判断节点是否有孩子（异步加载用）
				if (tree.getIsLeaf() == 1) {
					tree.setIsParent(false);
				} else {
					tree.setIsParent(true);
				}
			}
		} catch (Exception e) {
			logger.error("[数据字典-获取数据字典树失败：]", e);
		}
		return list;
	}
	
	
	/**
	 * 显示完整的菜单
	 * @param dictionary
	 * @return
	 */
	@RequestMapping(value = "/function-provider/function/complete-function-tree", method = RequestMethod.POST)
	public List<TreeNode> selectCompleteFunctionTreeNode() 
	{
		List<TreeNode> list = null;
		try {
			//获取父节点为空的菜单（root）
			SysFunction function = functionService.getRootFunction();
			list = functionService.selectTreeNodeByLevel(function);
			list = TreeNodeUtil.getfatherNode(list, function.getId());
		} catch (Exception e) {
			logger.error("[数据字典-获取数据字典树失败：]", e);
		}
		return list;
	}
	
	/**
	 * 所有菜单
	 * @return
	 */
	@RequestMapping(value = "/function-provider/list",method = RequestMethod.POST)
	public List<TreeNode> selectList(String id) {
		List<TreeNode> list = null;
		try {
			list = functionService.selectList(id);
		} catch (Exception e) {
			logger.error("[菜单管理-查询菜单select列表失败：]", e);
		}
		return list;
	}
	
	/**
	 * 按钮列表
	 * @param tableInfo
	 * @return
	 */
	@RequestMapping(value = "/function-provider/button-list",method = RequestMethod.POST)
	public LayuiTableData selectButtonByFunctionId(@RequestBody LayuiTableParam param) {
		LayuiTableData tem = null;
		try {
			tem = functionService.selectButtonList(param);
		} catch (Exception e) {
			logger.error("[菜单管理-查询按钮列表失败：]", e);
		}
		return tem;
	}
	
	/**
	 * 保存按钮
	 * @param button
	 * @return
	 */
	@RequestMapping(value = "/function-provider/save-button", method = RequestMethod.POST)
	public int saveButton(@RequestBody SysButton button){
		int result = 500;
		try {
			result = functionService.updateOrInsertButton(button);
		} catch (Exception e) {
			logger.error("[菜单管理-保存按钮失败：]", e);
		}
		return result;
	}
	
	/**
	 * 按钮详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/function-provider/get-button/{id}", method = RequestMethod.POST)
	public SysButton getButton(@PathVariable(value = "id", required = true) String id){
		SysButton button = null;
		try {
			button = functionService.getButtonById(id);
		} catch (Exception e) {
			logger.error("[菜单管理-初始化按钮失败：]", e);
		}
		return button;
	}
	
	@RequestMapping(value = "/function-provider/delete-button/{id}", method = RequestMethod.POST)
	public int deleteButton(@PathVariable(value = "id", required = true) String id){
		int result = 500;
		try {
			result = functionService.deleteButton(id);
		} catch (Exception e) {
			logger.error("[菜单管理-删除按钮失败：]", e);
		}
		return result;
	}
	
	/**
	 * 生成code码
	 * @param dictionary
	 * @return
	 */
	@RequestMapping(value = "/function-provider/create-code", method = RequestMethod.POST,consumes = "application/json;charset=utf-8")
	public String createCode(@RequestBody SysFunction function){
		String code = null;
		try {
			code = functionService.createCode(function);
		} catch (Exception e) {
			logger.error("[菜单管理-自动生成code码失败：]", e);
		} 
		return code;
	}
	
	/**
	 * 生成排序号
	 * @param function
	 * @return
	 */
	@RequestMapping(value = "/function-provider/create-weight", method = RequestMethod.POST,consumes = "application/json;charset=utf-8")
	public String createWeight(@RequestBody SysFunction function){
		String code = null;
		try {
			code = functionService.createWeight(function);
		} catch (Exception e) {
			logger.error("[菜单管理-自动生成排序号失败：]", e);
		} 
		return code;
	}
}
