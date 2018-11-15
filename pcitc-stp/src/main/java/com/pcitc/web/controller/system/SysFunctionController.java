package com.pcitc.web.controller.system;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.system.SysButton;
import com.pcitc.base.system.SysFunction;
import com.pcitc.base.system.SysRoleFunction;
import com.pcitc.base.system.vo.SysFunctionVo;
import com.pcitc.base.util.IdUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.OperationFilter;

@Controller
@RequestMapping("function")
public class SysFunctionController extends BaseController {

	private static final String FUNCTION_LIST = "http://pcitc-zuul/system-proxy/function-provider/function_list";

	private static final String SAVE_FUNCTION = "http://pcitc-zuul/system-proxy/function-provider/saveFunction";

	private static final String DELETE_FUNCTION = "http://pcitc-zuul/system-proxy/function-provider/deleteFunction/";

	private static final String GET_FUNCTION = "http://pcitc-zuul/system-proxy/function-provider/getFunction/";

	private static final String LEVEL_NODE = "http://pcitc-zuul/system-proxy/function-provider/getTreeByLevel";

	private static final String GET_FUNCTION_COMPLETE_TREE = "http://pcitc-zuul/system-proxy/function-provider/function/complete-function-tree";

	private static final String SAVE_ROLE_FUNCTION_REL = "http://pcitc-zuul/system-proxy/function-provider/function/save-role-function-rel";

	private static final String GET_FUNCTION_BY_ROLE = "http://pcitc-zuul/system-proxy/function-provider/function/get-function-by-role";

	private static final String LIST = "http://pcitc-zuul/system-proxy/function-provider/list";

	private static final String BUTTON_LIST = "http://pcitc-zuul/system-proxy/function-provider/button-list";

	private static final String SAVE_BUTTON = "http://pcitc-zuul/system-proxy/function-provider/save-button";

	private static final String GET_BUTTON = "http://pcitc-zuul/system-proxy/function-provider/get-button/";

	private static final String DELETE_BUTTON = "http://pcitc-zuul/system-proxy/function-provider/delete-button/";

	private static final String CREATE_CODE = "http://pcitc-zuul/system-proxy/function-provider/create-code";

	private static final String CREATE_WEIGHT = "http://pcitc-zuul/system-proxy/function-provider/create-weight";

	@RequestMapping(value = "/getTableData")
	@ResponseBody
	public Object getTableData(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request) throws IOException {

		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(FUNCTION_LIST, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData result = responseEntity.getBody();

		return JSON.toJSONString(result);
	}

	/**
	 * 保存菜单
	 * 
	 * @param request
	 * @return
	 */
	@OperationFilter(modelName = "菜单管理", actionName = "新增或者修改菜单")
	@RequestMapping(value = "/saveFunction")
	@ResponseBody
	public int saveFunction(@RequestBody SysFunctionVo function) {

		// 如果不加这行代码 报：Could not write request: no suitable HttpMessageConverter
		// found for request type:[SysFunction]
		// this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<SysFunctionVo> entity = new HttpEntity<SysFunctionVo>(function, this.httpHeaders);
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SAVE_FUNCTION, HttpMethod.POST, entity, Integer.class);
		int result = responseEntity.getBody();
		return result;
	}

	/**
	 * 删除菜单
	 * 
	 * @param request
	 * @return
	 */
	@OperationFilter(modelName = "菜单管理", actionName = "删除菜单")
	@RequestMapping(value = "/deleteFunction")
	@ResponseBody
	public int deleteFunction(HttpServletRequest request) {
		String id = request.getParameter("id");
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(DELETE_FUNCTION + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), Integer.class);
		int result = responseEntity.getBody();
		return result;
	}

	@RequestMapping(value = "/getFunction")
	@ResponseBody
	public Object getFunction(HttpServletRequest request) {
		String id = request.getParameter("id");
		ResponseEntity<SysFunction> responseEntity = this.restTemplate.exchange(GET_FUNCTION + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), SysFunction.class);
		SysFunction function = responseEntity.getBody();
		return function;
	}

	/**
	 * 根据层级获取树 adminlte
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	/*
	 * @RequestMapping(value = "/getTreeByLevel")
	 * 
	 * @ResponseBody public String getTreeByLevel(HttpServletRequest request)
	 * throws Exception {
	 * System.out.println("========================getTreeByLevel"); String
	 * token = request.getHeader("access-token");
	 * httpHeaders.set("Authorization", "Bearer " + token);
	 * httpHeaders.setContentType(MediaType.APPLICATION_JSON); String levelCode
	 * = request.getParameter("levelCode"); SysFunction function = new
	 * SysFunction(); function.setLevelCode(levelCode == null ?
	 * null:Integer.valueOf(levelCode)); ResponseEntity<List> responseEntity =
	 * restTemplate.exchange(LEVEL_NODE , HttpMethod.POST, new
	 * HttpEntity<SysFunction>(function,this.httpHeaders), List.class); List
	 * treeNodes = responseEntity.getBody(); return
	 * JSONUtils.toJSONString(treeNodes);
	 * 
	 * }
	 */

	/**
	 * 根据层级获取树,ztree
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getTreeByLevel")
	@ResponseBody
	public String getTreeByLevel(HttpServletRequest request) throws Exception {
		SysFunction function = new SysFunction();
		System.out.println("getTreeByLevel====" + request.getParameter("code"));
		if (request.getParameter("code") == null || request.getParameter("code").equals("")) {
			function.setLevelCode(4);
			function.setParentIndex("10");
		} else {
			function.setParentCode(request.getParameter("code")); // 当前节点的
		}
		ResponseEntity<List> responseEntity = restTemplate.exchange(LEVEL_NODE, HttpMethod.POST, new HttpEntity<SysFunction>(function, this.httpHeaders), List.class);
		List treeNodes = responseEntity.getBody();
		return JSONUtils.toJSONString(treeNodes);
	}

	/**
	 * 根据层级获取树,ztree
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getCommonFunctionTree")
	@ResponseBody
	public String getCommonFunctionTree(HttpServletRequest request) throws Exception {
		String levelCode = request.getParameter("levelCode");
		SysFunction function = new SysFunction();
		function.setLevelCode(levelCode == null ? null : Integer.valueOf(levelCode));
		ResponseEntity<?> responseEntity = restTemplate.exchange(LEVEL_NODE, HttpMethod.POST, new HttpEntity<SysFunction>(function, this.httpHeaders), List.class);
		return JSONUtils.toJSONString(responseEntity.getBody());
	}

	@RequestMapping(value = "/complete-tree")
	@ResponseBody
	public Object getSysFunctionCompleteTree() throws Exception {
		Object obj = this.restTemplate.exchange(GET_FUNCTION_COMPLETE_TREE, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Object.class).getBody();
		return obj;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/saveFunctionRoleRel")
	@ResponseBody
	public Object saveSysFunctionRoleRel(@RequestParam(value = "functionIds", required = false) String functionIds, @RequestParam(value = "roleId", required = false) String roleId) throws Exception {

		List<SysRoleFunction> rels = new ArrayList<SysRoleFunction>();
		JSONArray array = JSONArray.parseArray(functionIds);
		for (java.util.Iterator<Object> iter = array.iterator(); iter.hasNext();) {
			Object functionId = iter.next();
			SysRoleFunction f = new SysRoleFunction();
			f.setRelId(IdUtil.createIdByTime());
			f.setRoleId(roleId);
			f.setFunctionId(functionId.toString());
			rels.add(f);
		}
		Map<String, List<SysRoleFunction>> data = new HashMap<String, List<SysRoleFunction>>();
		data.put(roleId, rels);
		ResponseEntity<Integer> rs = this.restTemplate.exchange(SAVE_ROLE_FUNCTION_REL, HttpMethod.POST, new HttpEntity<Map<String, List<SysRoleFunction>>>(data, this.httpHeaders), Integer.class);
		if (rs.getBody() == 0) {
			return new Result(false);
		} else {
			return new Result(true);
		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/get-function-by-role")
	@ResponseBody
	public List<SysFunction> getFunctionByRole(@RequestParam("roleId") String roleId) throws Exception {
		List<SysFunction> functions = this.restTemplate.exchange(GET_FUNCTION_BY_ROLE, HttpMethod.POST, new HttpEntity<String>(roleId, this.httpHeaders), List.class).getBody();
		return functions;
	}

	/**
	 * 跳转至菜单管理页面
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/toFuntionList" }, method = { RequestMethod.POST, RequestMethod.GET })
	public String toFuntionList() {
		return "base/system/function_list";
	}

	/**
	 * 弹出模态框
	 */
	@RequestMapping(value = "/edit")
	public String pageEdit(String id, String parentId, String parentCode, String levelCode, String parentName, Model model) {
		if (StringUtils.isEmpty(id))
			id = "";
		if (StringUtils.isEmpty(parentId))
			parentId = "";
		if (StringUtils.isEmpty(parentCode))
			parentCode = "";
		if (StringUtils.isEmpty(levelCode))
			levelCode = "";
		if (StringUtils.isEmpty(parentName))
			parentName = "";

		model.addAttribute("id", id);
		model.addAttribute("parentId", parentId);
		model.addAttribute("parentCode", parentCode);
		model.addAttribute("levelCode", levelCode);
		model.addAttribute("parentName", parentName);
		return "base/system/function_info";
	}

	@RequestMapping(value = "/select-tree-function")
	@ResponseBody
	public String getComboboxUnitTree(HttpServletRequest request) throws Exception {
		ResponseEntity<List> responseEntity = restTemplate.exchange(LIST, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class);

		return JSONUtils.toJSONString(responseEntity.getBody());

	}

	/**
	 * 编辑按钮弹出框
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/editBtn")
	public String editBtn(String id, String functionId, Model model) {
		if (StringUtils.isEmpty(id))
			id = "";
		if (StringUtils.isEmpty(functionId))
			functionId = "";
		model.addAttribute("id", id);
		model.addAttribute("functionId", functionId);
		return "base/system/button_info";
	}

	/**
	 * 按钮列表
	 * 
	 * @param aoData
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/getButtonTableData", method = RequestMethod.POST)
	@ResponseBody
	public Object getButtonTableData(@ModelAttribute LayuiTableParam param, HttpServletRequest request) throws IOException {

		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(BUTTON_LIST, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData result = responseEntity.getBody();

		return JSON.toJSONString(result);
	}

	@OperationFilter(modelName = "菜单管理", actionName = "保存按钮")
	@RequestMapping(value = "/saveButton")
	@ResponseBody
	public int saveButton(@RequestBody SysButton button) {

		// 如果不加这行代码 报：Could not write request: no suitable HttpMessageConverter
		// found for request type:[SysFunction]
		HttpEntity<SysButton> entity = new HttpEntity<SysButton>(button, this.httpHeaders);
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SAVE_BUTTON, HttpMethod.POST, entity, Integer.class);
		int result = responseEntity.getBody();
		return result;
	}

	@RequestMapping(value = "/getButton")
	@ResponseBody
	public Object getButton(HttpServletRequest request) {
		String id = request.getParameter("id");
		ResponseEntity<SysButton> responseEntity = this.restTemplate.exchange(GET_BUTTON + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), SysButton.class);
		SysButton function = responseEntity.getBody();
		return function;
	}

	/**
	 * 删除按钮
	 * 
	 * @param request
	 * @return
	 */
	@OperationFilter(modelName = "菜单管理", actionName = "删除按钮")
	@RequestMapping(value = "/deleteButton")
	@ResponseBody
	public int deleteButton(HttpServletRequest request) {
		String id = request.getParameter("id");
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(DELETE_BUTTON + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), Integer.class);
		int result = responseEntity.getBody();
		return result;
	}

	/**
	 * 生成code码
	 * 
	 * @param dictionary
	 * @return
	 */
	@RequestMapping(value = "/create-code", method = RequestMethod.POST, consumes = "application/json;charset=utf-8")
	@ResponseBody
	public String createCode(@RequestBody SysFunction function) {
		ResponseEntity<String> responseEntity = this.restTemplate.exchange(CREATE_CODE, HttpMethod.POST, new HttpEntity<SysFunction>(function, this.httpHeaders), String.class);
		String code = responseEntity.getBody();
		return code;
	}

	/**
	 * 生成code码
	 * 
	 * @param dictionary
	 * @return
	 */
	@RequestMapping(value = "/create-weight", method = RequestMethod.POST, consumes = "application/json;charset=utf-8")
	@ResponseBody
	public String createWeight(@RequestBody SysFunction function) {
		ResponseEntity<String> responseEntity = this.restTemplate.exchange(CREATE_WEIGHT, HttpMethod.POST, new HttpEntity<SysFunction>(function, this.httpHeaders), String.class);
		String code = responseEntity.getBody();
		return code;
	}
}
