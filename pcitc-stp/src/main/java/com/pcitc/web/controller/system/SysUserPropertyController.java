package com.pcitc.web.controller.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysFunctionProperty;
import com.pcitc.base.system.SysUnit;
import com.pcitc.base.system.SysUserProperty;
import com.pcitc.base.system.vo.SysUserPropertyVo;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.OperationFilter;

@Controller
public class SysUserPropertyController extends BaseController {

	private static final String FIRST_LEVEL_NODE = "http://pcitc-zuul/system-proxy/userProperty-provider/first-level-tree";

	private static final String LEVEL_NODE = "http://pcitc-zuul/system-proxy/userProperty-provider/selectUserUnderOfUnitTree/";

	private static final String SAVE_USERPROPERTY = "http://pcitc-zuul/system-proxy/userProperty-provider/saveUserPropertyList";

	private static final String PROPERTY_LIST = "http://pcitc-zuul/system-proxy/userProperty-provider/propertyList";

	private static final String UNIT_TREE_PROPERTY = "http://pcitc-zuul/system-proxy/userProperty-provider/select-unit-tree/";

	private static final String CHILD_BY_CHILD = "http://pcitc-zuul/system-proxy/userProperty-provider/child-by-child/";

	private static final String UNIT_POST_CON_TREE = "http://pcitc-zuul/system-proxy/unit-provider/units-posts-users/tree";
	
	private static final String UNIT_POST_TREE = "http://pcitc-zuul/system-proxy/unit-provider/units-posts/tree";
	
	private static final String UNIT_CONFIG = "http://pcitc-zuul/system-proxy/userProperty-provider/units/tree/config";
	
	private static final String SAVE_FUN_CONFIG = "http://pcitc-zuul/system-proxy/userProperty-provider/function/config/post/save";
	
	@ResponseBody
	@RequestMapping(value = { "/userProperty/getOrgTree" }, method = { RequestMethod.POST })
	public String getOrgTree() {
		System.out.println("----------getOrgTree");
		ResponseEntity<List> responseEntity = restTemplate.exchange(FIRST_LEVEL_NODE, HttpMethod.POST, new HttpEntity<String>("", this.httpHeaders), List.class);
		List treeNodes = responseEntity.getBody();
		return JSONUtils.toJSONString(treeNodes);
	}
	
	/**
	 * 检索机构(树),通过岗位、菜单、配置项信息
	 */
	@RequestMapping(value = "/userProperty/units/tree/config")
	@ResponseBody
	public String selectUnitListForUnitDataConfig(HttpServletRequest request) throws Exception {
		String path = request.getContextPath();
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (request.getParameter("functionId")!= null) {
			map.put("functionId", request.getParameter("functionId"));
		}
		if (request.getParameter("postId")!= null) {
			map.put("postId", request.getParameter("postId"));
		}
		if (request.getParameter("proCode")!= null) {
			map.put("proCode", request.getParameter("proCode"));
		}
		HttpEntity<HashMap<String, Object>> entity = new HttpEntity<HashMap<String, Object>>(map, this.httpHeaders);

		ResponseEntity<List> responseEntity = this.restTemplate.exchange(UNIT_CONFIG, HttpMethod.POST, entity, List.class);
		List treeNodes = responseEntity.getBody();
		for (int i = 0; i < treeNodes.size(); i++) {
			Map temNode = (Map)treeNodes.get(i);
			temNode.put("icon", path + "/image/house.png");
		}
		return JSONUtils.toJSONString(responseEntity.getBody());
	}
	
	/**
	 * 用户授权树部门下的部门和用户
	 */
	@RequestMapping(value = "/userProperty/unit-post/tree-data")
	@ResponseBody
	public String getUnitPostTree(HttpServletRequest request) throws Exception {
		String path = request.getContextPath();
		HashMap<String, Object> map = new HashMap<String, Object>();
		HttpEntity<HashMap<String, Object>> entity = new HttpEntity<HashMap<String, Object>>(map, this.httpHeaders);

		ResponseEntity<List> responseEntity = this.restTemplate.exchange(UNIT_POST_TREE, HttpMethod.POST, entity, List.class);
		List treeNodes = responseEntity.getBody();
		for (int i = 0; i < treeNodes.size(); i++) {
			Map temNode = (Map)treeNodes.get(i);
			if (temNode.get("nodeType").equals("unit")) {
				temNode.put("icon", path + "/image/house.png");
			} else if (temNode.get("nodeType").equals("post")) {
				temNode.put("icon", path + "/image/post.png");
			} 
		}
		return JSONUtils.toJSONString(responseEntity.getBody());
	}

	/**
	 * 用户授权树部门下的部门和用户
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/userProperty/selectUserUnderOfUnitTree")
	@ResponseBody
	public String selectUserUnderOfUnitTree(HttpServletRequest request) throws Exception {
		String path = request.getContextPath();
		SysUnit unit = new SysUnit();
		ResponseEntity<List> responseEntity = restTemplate.exchange(UNIT_POST_CON_TREE, HttpMethod.POST, new HttpEntity<SysUnit>(unit, this.httpHeaders), List.class);
		List treeNodes = responseEntity.getBody();
		for (int i = 0; i < treeNodes.size(); i++) {
			Map temNode = (Map)treeNodes.get(i);
			if (temNode.get("nodeType").equals("unit")) {
				temNode.put("icon", path + "/image/house.png");
			} else if (temNode.get("nodeType").equals("post")) {
				temNode.put("icon", path + "/image/post.png");
			} else if (temNode.get("nodeType").equals("user")) {
				temNode.put("icon", path + "/image/humen.png");
			}
		}
		//System.out.println("getUnitPostTreeByCond=====" + JSONUtils.toJSONString(treeNodes));
		return JSONUtils.toJSONString(responseEntity.getBody());

	}

	/**
	 * 批量保存人员和数据绑定关系
	 * 
	 * @param userProperties
	 * @param dataType
	 * @return
	 */
	@OperationFilter(modelName = "用户配置管理", actionName = "保存用户配置关系")
	@RequestMapping(value = "/userProperty/saveUserPropertyList")
	@ResponseBody
	public int saveUserPropertyList(String userProperties, SysUserPropertyVo property) {

		List<SysUserProperty> properties = JSON.parseArray(userProperties, SysUserProperty.class);
		property.setProperties(properties);
		HttpEntity<SysUserPropertyVo> entity = new HttpEntity<SysUserPropertyVo>(property, this.httpHeaders);
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SAVE_USERPROPERTY, HttpMethod.POST, entity, Integer.class);
		int result = responseEntity.getBody();
		return result;
	}
	
	/**
	 * 保存菜单、配置项、岗位三者和配置内容的关联，其中岗位、配置内容可能有多个
	 */
	@OperationFilter(modelName = "数据权限配置", actionName = "保存菜单、配置项、岗位三者和配置内容的关联")
	@RequestMapping(value = "/userProperty/function/config/post/save")
	@ResponseBody
	public int saveFunctionConfigPost(SysFunctionProperty sysFunctionProperty) throws Exception {
		System.out.println("sysFunctionProperty------"+sysFunctionProperty);
		System.out.println("sysFunctionProperty------"+sysFunctionProperty.getPostId());
		sysFunctionProperty.setCreateUserId(sysUserInfo.getUserId());
		HttpEntity<SysFunctionProperty> entity = new HttpEntity<SysFunctionProperty>(sysFunctionProperty, this.httpHeaders);
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SAVE_FUN_CONFIG, HttpMethod.POST, entity, Integer.class);
		int result = responseEntity.getBody();
		return result;
	}

	/**
	 * 跳转至用户配置页面
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/userProperty/toUserPorperty" }, method = { RequestMethod.POST, RequestMethod.GET })
	public String toUserPorperty() {
		return "/base/property/user_property";
	}

	/**
	 * 显示列表
	 * 
	 * @param param
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/userProperty/getTableData")
	@ResponseBody
	public Object getTableData(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request) throws Exception {
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(PROPERTY_LIST, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData result = responseEntity.getBody();

		return JSON.toJSONString(result);

	}

	/**
	 * 用户配置树部门下的部门
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/userProperty/select-unit-tree")
	@ResponseBody
	public String selectUnitTree(HttpServletRequest request) throws Exception {
		String userId = request.getParameter("userId");

		ResponseEntity<List> responseEntity = restTemplate.exchange(UNIT_TREE_PROPERTY + userId, HttpMethod.POST, new HttpEntity<String>("", this.httpHeaders), List.class);
		List treeNodes = responseEntity.getBody();
		return JSONUtils.toJSONString(treeNodes);

	}

	@RequestMapping(value = "/userProperty/child-by-child")
	@ResponseBody
	public String childByChild(HttpServletRequest request) throws Exception {
		String parentCode = request.getParameter("parentCode");

		ResponseEntity<List> responseEntity = restTemplate.exchange(CHILD_BY_CHILD + parentCode, HttpMethod.POST, new HttpEntity<String>("", this.httpHeaders), List.class);
		List treeNodes = responseEntity.getBody();
		return JSONUtils.toJSONString(treeNodes);

	}
}
