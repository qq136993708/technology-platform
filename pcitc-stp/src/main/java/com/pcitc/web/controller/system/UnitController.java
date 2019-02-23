package com.pcitc.web.controller.system;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.system.SysUnit;
import com.pcitc.base.util.IdUtil;
import com.pcitc.web.common.BaseController;

@Controller
public class UnitController extends BaseController {

	private static final String UNIT_GET_UNIT = "http://pcitc-zuul/system-proxy/unit-provider/unit/get-unit/";
	private static final String UNIT_TREE_DATA = "http://pcitc-zuul/system-proxy/unit-provider/unit/tree-data";
	private static final String UNIT_ADD_UNIT = "http://pcitc-zuul/system-proxy/unit-provider/unit/add-unit";
	private static final String UNIT_UPDATE_UNIT = "http://pcitc-zuul/system-proxy/unit-provider/unit/upd-unit";
	private static final String UNIT_DEL_UNIT = "http://pcitc-zuul/system-proxy/unit-provider/unit/del-unit/";
	private static final String UNIT_DEL_UNIT_REAL = "http://pcitc-zuul/system-proxy/unit-provider/unit/del-unit-real/";
	private static final String UNIT_LIST_DATA = "http://pcitc-zuul/system-proxy/unit-provider/unit/list-data";
	private static final String UNIT_TREE_NODE = "http://pcitc-zuul/system-proxy/unit-provider/get-unit-tree";
	// private static final String UNIT_LIST =
	// "http://pcitc-zuul/system-proxy/unit-provider/unit-list";
	private static final String GET_UNIT_CODE = "http://pcitc-zuul/system-proxy/unit-provider/unit/unit-code";
	private static final String UNIT_CON_TREE = "http://pcitc-zuul/system-proxy/unit-provider/units-users/tree";
	private static final String UNIT_LIST_ZTREE_DATA = "http://pcitc-zuul/system-proxy/unit-provider/unit/ztree-unit-list";
	private static final String UNIT_POST_CON_TREE = "http://pcitc-zuul/system-proxy/unit-provider/units-posts-users/tree";
	private static final String UNIT_PART_TREE = "http://pcitc-zuul/system-proxy/unit-provider/units-users/part-tree";
	private static final String UNIT_POST_PART_TREE = "http://pcitc-zuul/system-proxy/unit-provider/units-posts-users/part-tree";

	/**
	 * @param request
	 * @return
	 * @throws Exception
	 *             根据查询条件查询树形结构，包含组织机构、用户、岗位
	 */
	@RequestMapping(value = "/unit/units-posts/tree")
	@ResponseBody
	public String getUnitPostTreeByCond(HttpServletRequest request) throws Exception {
		SysUnit unit = new SysUnit();
		unit.setUnitPath("1001"); // 查询根节点对应的树
		ResponseEntity<?> responseEntity = restTemplate.exchange(UNIT_POST_CON_TREE, HttpMethod.POST, new HttpEntity<SysUnit>(unit, this.httpHeaders), List.class);
		// List treeNodes = responseEntity.getBody();
		System.out.println("getUnitPostTreeByCond=====" + JSONUtils.toJSONString(responseEntity.getBody()));
		return JSONUtils.toJSONString(responseEntity.getBody());

	}

	/**
	 * 组织机构树, 有组织机构和人员, 没有岗位-- 查询某些组织机构节点的组织机构树,只查询这些节点的所有子孙和直系父辈
	 */
	@RequestMapping(value = "/unit/units/part-tree")
	@ResponseBody
	public String getUnitTreeAndUserByUnitCodes(HttpServletRequest request) throws Exception {
		httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		JSONObject reJson = new JSONObject();
		System.out.println("1getUnitTreeAndUserByUnitCodes=====" + request.getParameter("unitCodes"));
		reJson.put("unitCodes", request.getParameter("unitCodes"));

		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
		requestBody.add("jsonStr", reJson.toString());
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, httpHeaders);

		ResponseEntity<?> responseEntity = this.restTemplate.exchange(UNIT_PART_TREE, HttpMethod.POST, entity, List.class);
		System.out.println("2getUnitTreeAndUserByUnitCodes=====" + JSONUtils.toJSONString(responseEntity.getBody()));
		return JSONUtils.toJSONString(responseEntity.getBody());
	}

	/**
	 * 组织机构树, 有组织机构和、岗位、人员-- 查询某些岗位节点的组织机构树,只查询这些节点的所有子孙和直系父辈
	 */
	@RequestMapping(value = "/unit/units-posts/part-tree")
	@ResponseBody
	public String getUnitTreeAndPostsAndUserByPostCodes(HttpServletRequest request) throws Exception {
		httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		JSONObject reJson = new JSONObject();
		System.out.println("getUnitTreeAndPostsAndUserByPostCodes=====" + request.getParameter("postCodes"));
		reJson.put("postCodes", request.getParameter("postCodes"));

		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
		requestBody.add("jsonStr", reJson.toString());
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, httpHeaders);

		ResponseEntity<?> responseEntity = this.restTemplate.exchange(UNIT_POST_PART_TREE, HttpMethod.POST, entity, List.class);
		System.out.println("getUnitTreeAndPostsAndUserByPostCodes=====" + JSONUtils.toJSONString(responseEntity.getBody()));
		return JSONUtils.toJSONString(responseEntity.getBody());
	}

	/**
	 * @param request
	 * @return
	 * @throws Exception
	 *             根据查询条件查询树形结构，包含组织机构、用户，不包括岗位
	 */
	@RequestMapping(value = "/unit/units/tree")
	@ResponseBody
	public String getUnitTreeByCond(HttpServletRequest request) throws Exception {

		SysUnit unit = new SysUnit();
		unit.setUnitPath("1001"); // 查询根节点对应的树
		ResponseEntity<?> responseEntity = restTemplate.exchange(UNIT_CON_TREE, HttpMethod.POST, new HttpEntity<SysUnit>(unit, this.httpHeaders), List.class);
		// List treeNodes = responseEntity.getBody();
		// System.out.println("========================getUnitTreeByCond"+JSONUtils.toJSONString(responseEntity.getBody()));
		return JSONUtils.toJSONString(responseEntity.getBody());

	}

	@RequestMapping(value = "/unit/get-unit/{unitId}")
	@ResponseBody
	public Object getUnitInfo(@PathVariable("unitId") String unitId) throws Exception {
		SysUnit unit = this.restTemplate.exchange(UNIT_GET_UNIT + unitId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), SysUnit.class).getBody();
		return unit;
	}

	@RequestMapping(value = "/unit/tree-data")
	@ResponseBody
	public Object getUnitTreeData() throws Exception {
		HttpEntity<Object> node = this.restTemplate.exchange(UNIT_TREE_DATA, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Object.class);
		return node.getBody();
	}

	@RequestMapping(value = "/unit/add-unit")
	@ResponseBody
	public Object addUnit(@ModelAttribute("unit") SysUnit unit, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result rs = null;
		if (StringUtils.isBlank(unit.getUnitId())) {
			// 获得父机构
			SysUnit punit = this.restTemplate.exchange(UNIT_GET_UNIT + unit.getUnitRelation(), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), SysUnit.class).getBody();
			unit.setUnitId(IdUtil.createIdByTime());
			unit.setUnitDelflag(DelFlagEnum.STATUS_NORMAL.getCode());
			unit.setUnitLevel(punit.getUnitLevel() + 1);
			HttpEntity<Object> entit = new HttpEntity<Object>(unit, this.httpHeaders);
			rs = this.restTemplate.exchange(UNIT_ADD_UNIT, HttpMethod.POST, entit, Result.class).getBody();
		} else {
			HttpEntity<Object> entit = new HttpEntity<Object>(unit, this.httpHeaders);
			rs = this.restTemplate.exchange(UNIT_UPDATE_UNIT, HttpMethod.POST, entit, Result.class).getBody();
		}
		return new Result(rs.isSuccess(),unit.getUnitId(),rs.getMessage());
	}

	@RequestMapping(value = "/unit/upd-unit")
	@ResponseBody
	public Object updateUnit(@RequestBody SysUnit unit) throws Exception {
		this.restTemplate.exchange(UNIT_UPDATE_UNIT, HttpMethod.POST, new HttpEntity<Object>(unit, this.httpHeaders), Integer.class).getBody();
		return new Result(true);
	}

	@RequestMapping(value = "/unit/del-unit/{unitId}")
	@ResponseBody
	public Object delUnit(@PathVariable("unitId") String unitId) throws Exception {
		Integer rs = this.restTemplate.exchange(UNIT_DEL_UNIT + unitId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class).getBody();
		if (rs > 0) {
			return new Result(true);
		} else {
			return new Result(false);
		}
	}

	@RequestMapping(value = "/unit/del-unit-real")
	@ResponseBody
	public Object delUnitReal(String unitId) throws Exception {
		this.restTemplate.exchange(UNIT_DEL_UNIT_REAL + unitId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class).getBody();
		return new Result(true);
	}

	@RequestMapping(value = "/unit/list-data")
	@ResponseBody
	public Object getUnitListData() throws Exception {
		HttpEntity<Object> node = this.restTemplate.exchange(UNIT_LIST_DATA, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Object.class);
		return node.getBody();
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/unit/getUnitTree")
	@ResponseBody
	public String getUnitTree(HttpServletRequest request) throws Exception {

		ResponseEntity<List> responseEntity = restTemplate.exchange(UNIT_TREE_NODE, HttpMethod.POST, new HttpEntity<String>(null, this.httpHeaders), List.class);
		List treeNodes = responseEntity.getBody();
		return JSONUtils.toJSONString(treeNodes);

	}

	@RequestMapping(value = "/unit/ztree-unit-list")
	@ResponseBody
	public String getComboboxUnitTree(@RequestParam(value="name", required=false) String name,HttpServletRequest request) throws Exception {
		System.out.println("name:"+name);
		ResponseEntity<String> responseEntity = restTemplate.exchange(UNIT_LIST_ZTREE_DATA, HttpMethod.POST, new HttpEntity<Object>(name,this.httpHeaders), String.class);
		System.out.println(responseEntity.getBody());
		return responseEntity.getBody();

	}

	/**
	 * 获取部门列表
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	/*
	 * @RequestMapping(value = "/getDataTable")
	 * 
	 * @ResponseBody public Object getDataTable(@RequestBody List<Object> param)
	 * throws Exception { DataTableInfoVo tableInfo =
	 * DateTableUtil.getAllParam(param);
	 * this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
	 * HttpEntity<DataTableInfoVo> entity = new
	 * HttpEntity<DataTableInfoVo>(tableInfo, this.httpHeaders);
	 * ResponseEntity<String> responseEntity =
	 * this.restTemplate.exchange(UNIT_LIST, HttpMethod.POST, entity,
	 * String.class);
	 * 
	 * String result = responseEntity.getBody(); //JSONObject retJson =
	 * (JSONObject) JSONUtils.parse(result); JSONObject retJson =
	 * JSONObject.fromObject(result); DataTableParameter data = new
	 * DataTableParameter(); if(retJson != null){ Long totalCount =
	 * retJson.get("totalCount") != null?
	 * Long.parseLong(retJson.get("totalCount").toString()):0l; List<?> dicList
	 * = JSONArray.toList(retJson.getJSONArray("list"), new SysUnit(), new
	 * JsonConfig()); data.setAaData(dicList); //要显示的总条数
	 * data.setiTotalDisplayRecords(totalCount); //真实的总条数
	 * data.setiTotalRecords(totalCount); } return data; }
	 */
	@RequestMapping(value = "/unit/unit-code")
	@ResponseBody
	public Object getUnitCodeByUnitName(@ModelAttribute("unit") SysUnit unit) {
		ResponseEntity<String> responseEntity = restTemplate.exchange(GET_UNIT_CODE, HttpMethod.POST, new HttpEntity<SysUnit>(unit, this.httpHeaders), String.class);
		String rs = responseEntity.getBody();
		return new Result(true, rs);
	}
}
