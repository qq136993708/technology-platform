package com.pcitc.web.controller.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.pcitc.base.system.SysDictionary;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.OperationFilter;

@Controller
public class SysDictionaryController extends BaseController {

	private static final String TREE_ONE_LEVEL_URL = "http://pcitc-zuul/system-proxy/dictionary-provider/getTreeOneLevel";
	private static final String CHILD_NODE = "http://pcitc-zuul/system-proxy/dictionary-provider/getChildNode/";
	private static final String SAVE_TREENODE = "http://pcitc-zuul/system-proxy/dictionary-provider/saveDictionary";
	private static final String DELETE_TREENODE = "http://pcitc-zuul/system-proxy/dictionary-provider/deleteDictionary/";

	private static final String LEVEL_NODE = "http://pcitc-zuul/system-proxy/dictionary-provider/getTreeByLevel";

	private static final String CHILD_NODE_TABLE = "http://pcitc-zuul/system-proxy/dictionary-provider/getChildNodeForTable";

	private static final String GET_DICTIONARY = "http://pcitc-zuul/system-proxy/dictionary-provider/getDictionary/";

	private static final String DICTIONARY_LIST = "http://pcitc-zuul/system-proxy/dictionary-provider/dictionary/";

	private static final String CREATE_CODE = "http://pcitc-zuul/system-proxy/dictionary-provider/create-code";

	private static final String DICTIONARY_CODE = "http://pcitc-zuul/system-proxy/dictionary-provider/dictionary/";
	private static final String DICTIONARY_MAP_LIST = "http://pcitc-zuul/system-proxy/dictionary-provider/dictionary/get-map-dicionarys";
	private static final String DICTIONARY_DESC = "http://pcitc-zuul/system-proxy/dictionary-provider/getDictionaryByCode/";

	
	private static final String BATCH_DELETE = "http://pcitc-zuul/system-proxy/dictionary-provider/batch-delete/";
	/**
	 * 一级节点
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/dictionary/getTreeOneLevel")
	@ResponseBody
	public String getTreeOneLevel() throws Exception {

		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);
		ResponseEntity<List> responseEntity = restTemplate.exchange(TREE_ONE_LEVEL_URL, HttpMethod.GET, entity, List.class);
		List treeNodes = responseEntity.getBody();
		String n = JSONUtils.toJSONString(treeNodes);

		return n;

	}

	/**
	 * 父节点下子节点（异步加载）
	 * 
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/dictionary/getChildNode")
	@ResponseBody
	public String getChildNode(HttpServletRequest request) throws Exception {
		String parentId = request.getParameter("parentId");
		ResponseEntity<List> responseEntity = restTemplate.exchange(CHILD_NODE + parentId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), List.class);
		List treeNodes = responseEntity.getBody();
		return JSONUtils.toJSONString(treeNodes);

	}

	/**
	 * 保存数据字典
	 * 
	 * @param dictionary
	 * @return
	 */
	@OperationFilter(modelName = "数据字典", actionName = "新增或修改数据字典")
	@RequestMapping(value = "/dictionary/saveDictionary")
	@ResponseBody
	public int saveDictionary(@RequestBody SysDictionary dictionary) {
		HttpEntity<SysDictionary> entity = new HttpEntity<SysDictionary>(dictionary, this.httpHeaders);
		ResponseEntity<Integer> responseEntity = restTemplate.exchange(SAVE_TREENODE, HttpMethod.POST, entity, Integer.class);
		int result = responseEntity.getBody();
		return result;
	}

	/**
	 * 删除数据字典
	 * 
	 * @param request
	 * @return
	 */
	@OperationFilter(modelName = "数据字典", actionName = "删除数据字典")
	@RequestMapping(value = "/dictionary/deleteDictionary")
	@ResponseBody
	public int deleteDictionary(HttpServletRequest request) {
		String id = request.getParameter("id");
		ResponseEntity<Integer> responseEntity = restTemplate.exchange(DELETE_TREENODE + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), Integer.class);
		int result = responseEntity.getBody();
		return result;
	}

	/**
	 * 根据层级获取树
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/dictionary/getTreeByLevel")
	@ResponseBody
	public String getTreeByLevel(HttpServletRequest request) throws Exception {
		String levelCode = request.getParameter("levelCode");
		SysDictionary dictionary = new SysDictionary();
		dictionary.setLevelCode(levelCode == null ? null : Integer.valueOf(levelCode));
		ResponseEntity<List> responseEntity = restTemplate.exchange(LEVEL_NODE, HttpMethod.POST, new HttpEntity<SysDictionary>(dictionary, this.httpHeaders), List.class);
		List treeNodes = responseEntity.getBody();
		return JSONUtils.toJSONString(treeNodes);

	}

	/**
	 * 初始化table父节点下子节点（异步加载）
	 * 
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/dictionary/getChildNodeForTable")
	@ResponseBody
	public Object getChildNodeForTable(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request) throws Exception {

		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(CHILD_NODE_TABLE, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData result = responseEntity.getBody();

		return JSON.toJSONString(result);

	}

	@RequestMapping(value = "/dictionary/getDictionary")
	@ResponseBody
	public Object getDictionary(HttpServletRequest request) {
		String id = request.getParameter("id");
		ResponseEntity<SysDictionary> responseEntity = this.restTemplate.exchange(GET_DICTIONARY + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), SysDictionary.class);
		SysDictionary dic = responseEntity.getBody();
		return dic;
	}

	/**
	 * 跳转至数据字典管理页面
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/dictionary/toDictionaryList" }, method = RequestMethod.GET)
	public String toFuntionList() {
		return "base/system/dictionary";
	}

	/**
	 * 弹出数据字典模态框
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/dictionary/dictionary_info" }, method = RequestMethod.GET)
	public String toDictionaryInfo(String id, String parentId, String parentCode, String levelCode, String parentName, Model model) {
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
		return "base/system/dictionary_info";
	}

	/**
	 * 根据父编码获取字典集合
	 * 
	 * @param parentCode
	 * @return
	 */
	@RequestMapping(value = "/dictionary/dictionaryList", method = RequestMethod.POST)
	@ResponseBody
	public List<SysDictionary> getDictionaryListByParentCode(String parentCode) {
		ResponseEntity<List> responseEntity = this.restTemplate.exchange(DICTIONARY_LIST + parentCode, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), List.class);
		List<SysDictionary> dictionaryList = responseEntity.getBody();
		return dictionaryList;
	}

	/**
	 * 生成code码
	 * 
	 * @param dictionary
	 * @return
	 */
	@RequestMapping(value = "/dictionary/create-code", method = RequestMethod.POST, consumes = "application/json;charset=utf-8")
	@ResponseBody
	public String createCode(@RequestBody SysDictionary dictionary) {
		ResponseEntity<String> responseEntity = this.restTemplate.exchange(CREATE_CODE, HttpMethod.POST, new HttpEntity<SysDictionary>(dictionary, this.httpHeaders), String.class);
		String code = responseEntity.getBody();
		return code;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/dictionary/list/{parentCode}", method = RequestMethod.POST)
	@ResponseBody
	public List<SysDictionary> getByCode(@PathVariable("parentCode") String parentCode, HttpServletRequest request) {
		return this.restTemplate.exchange(DICTIONARY_CODE + parentCode, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class).getBody();
	}

	@RequestMapping(value = "/dictionary/map/getMapListDictionarys", method = RequestMethod.POST)
	@ResponseBody
	public Object getMapListByParentCode(@RequestParam("parentCodes") String parentCodes, HttpServletRequest request) {
		List<String> pcodes = new ArrayList<String>();
		JSONArray array = JSON.parseArray(parentCodes);
		for (java.util.Iterator<Object> iter = array.iterator(); iter.hasNext();) {
			pcodes.add(iter.next().toString());
		}
		return this.restTemplate.exchange(DICTIONARY_MAP_LIST, HttpMethod.POST, new HttpEntity<List<String>>(pcodes, this.httpHeaders), Map.class).getBody();
	}

	@RequestMapping(value = "/dictionary/desc/{code}", method = RequestMethod.POST)
	@ResponseBody
	public Object getDictionaryCode(@PathVariable(value = "code", required = true) String code, HttpServletRequest request) {
		System.out.println("dictionary ..... " + code);
		Object obj = this.restTemplate.exchange(DICTIONARY_DESC + code, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Object.class).getBody();
		System.out.println(JSON.toJSON(obj).toString());

		return obj;
	}
	
	/**
	 * 删除数据字典
	 * 
	 * @param request
	 * @return
	 */
	@OperationFilter(modelName = "数据字典", actionName = "删除数据字典")
	@RequestMapping(value = "/dictionary/batch-delete")
	@ResponseBody
	public int BatchDeleteDictionary(HttpServletRequest request) {
		String ids = request.getParameter("ids");
		ResponseEntity<Integer> responseEntity = restTemplate.exchange(BATCH_DELETE + ids, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), Integer.class);
		int result = responseEntity.getBody();
		return result;
	}


}
