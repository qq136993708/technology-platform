package com.pcitc.web.controller.system;

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
import com.pcitc.base.system.SysUnit;
import com.pcitc.base.system.SysUserProperty;
import com.pcitc.base.system.vo.SysUserPropertyVo;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.OperationFilter;

@Controller
@RequestMapping("userProperty")
public class SysUserPropertyController extends BaseController {

	private static final String FIRST_LEVEL_NODE = "http://pcitc-zuul/system-proxy/userProperty-provider/first-level-tree";

	private static final String LEVEL_NODE = "http://pcitc-zuul/system-proxy/userProperty-provider/selectUserUnderOfUnitTree/";

	private static final String SAVE_USERPROPERTY = "http://pcitc-zuul/system-proxy/userProperty-provider/saveUserPropertyList";

	private static final String PROPERTY_LIST = "http://pcitc-zuul/system-proxy/userProperty-provider/propertyList";

	private static final String UNIT_TREE_PROPERTY = "http://pcitc-zuul/system-proxy/userProperty-provider/select-unit-tree/";

	private static final String CHILD_BY_CHILD = "http://pcitc-zuul/system-proxy/userProperty-provider/child-by-child/";

	private static final String UNIT_POST_CON_TREE = "http://pcitc-zuul/system-proxy/unit-provider/units-posts-users/tree";
	
	@ResponseBody
	@RequestMapping(value = { "/getOrgTree" }, method = { RequestMethod.POST })
	public String getOrgTree() {
		System.out.println("----------getOrgTree");
		ResponseEntity<List> responseEntity = restTemplate.exchange(FIRST_LEVEL_NODE, HttpMethod.POST, new HttpEntity<String>("", this.httpHeaders), List.class);
		List treeNodes = responseEntity.getBody();
		return JSONUtils.toJSONString(treeNodes);
	}

	/**
	 * 用户授权树部门下的部门和用户
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectUserUnderOfUnitTree")
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
		System.out.println("getUnitPostTreeByCond=====" + JSONUtils.toJSONString(treeNodes));
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
	@RequestMapping(value = "/saveUserPropertyList")
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
	 * 跳转至用户配置页面
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/toUserPorperty" }, method = { RequestMethod.POST, RequestMethod.GET })
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
	@RequestMapping(value = "/getTableData")
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
	@RequestMapping(value = "/select-unit-tree")
	@ResponseBody
	public String selectUnitTree(HttpServletRequest request) throws Exception {
		String userId = request.getParameter("userId");

		ResponseEntity<List> responseEntity = restTemplate.exchange(UNIT_TREE_PROPERTY + userId, HttpMethod.POST, new HttpEntity<String>("", this.httpHeaders), List.class);
		List treeNodes = responseEntity.getBody();
		return JSONUtils.toJSONString(treeNodes);

	}

	@RequestMapping(value = "/child-by-child")
	@ResponseBody
	public String childByChild(HttpServletRequest request) throws Exception {
		String parentCode = request.getParameter("parentCode");

		ResponseEntity<List> responseEntity = restTemplate.exchange(CHILD_BY_CHILD + parentCode, HttpMethod.POST, new HttpEntity<String>("", this.httpHeaders), List.class);
		List treeNodes = responseEntity.getBody();
		return JSONUtils.toJSONString(treeNodes);

	}
}
