package com.pcitc.web.controller.wholeProcess;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.techFamily.TechFamily;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.OperationFilter;

/**
 * @author zhf
 * @date 2018年9月11日 上午10:27:55 全流程可视化
 */
@Controller
public class WholeProcessController extends BaseController {

	private static final String TECH_TYPE_STR = "http://pcitc-zuul/stp-proxy//tech-family-provider/max-type-code";
	private static final String TECH_TYPE_TREE = "http://pcitc-zuul/stp-proxy/tech-family-provider/type-tree";
	private static final String TECH_TYPE_LIST = "http://pcitc-zuul/stp-proxy/tech-family-provider/type-list";
	private static final String TECH_TYPE_ADD = "http://pcitc-zuul/stp-proxy/tech-family-provider/type-insert";
	private static final String TECH_TYPE_DELETE = "http://pcitc-zuul/stp-proxy/tech-family-provider/type-delete";

	/**
	 * 装备全流程可视化
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/whole-process/equipment/ini")
	public String iniEquipmentWholeProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/stp/wholeProcess/equipmentProcess";
	}

	/**
	 * 装备全流程可视化
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/whole-process/equipment-project/ini")
	public String iniEquipmentProjectWholeProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/stp/wholeProcess/equipmentPorjectProcess";
	}

	/**
	 * 科技全流程可视化
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/whole-process/science/ini")
	public String iniScienceWholeProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 查询项目前10条记录
		
		return "/stp/wholeProcess/scienceProcess";
	}

	/**
	 * 科技全流程可视化
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/whole-process/science-project/ini")
	public String iniScienceProjectWholeProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/stp/wholeProcess/sciencePorjectProcess";
	}

	/**
	 * @param request
	 * @return
	 * @throws Exception
	 *             获取技术族分类树，异步方法
	 */
	@RequestMapping(value = "/whole-process/type/tech-type-tree")
	@ResponseBody
	public String getTechTypeTree(HttpServletRequest request) throws Exception {
		System.out.println("/whole-process/type/tech-type-tree==========" + request.getParameter("code"));
		TechFamily techType = new TechFamily();
		if (request.getParameter("code") == null || request.getParameter("code").equals("")) {
			techType.setLevelCode("2");
			techType.setTypeIndex("10");
		} else {
			techType.setTypeIndex(request.getParameter("code"));
		}
		ResponseEntity<List> responseEntity = this.restTemplate.exchange(TECH_TYPE_TREE, HttpMethod.POST, new HttpEntity<TechFamily>(techType, this.httpHeaders), List.class);
		List treeNodes = responseEntity.getBody();
		return JSONUtils.toJSONString(treeNodes);
	}

	/**
	 * @param param
	 * @return 查询分类列表
	 */
	@RequestMapping(value = "/whole-process/type/tech-type-list", method = RequestMethod.POST)
	@ResponseBody
	public Object getTechTypeList(@ModelAttribute("param") LayuiTableParam param) {
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(TECH_TYPE_LIST, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();

		return JSON.toJSON(retJson).toString();
	}

	/**
	 * 初始化节点编码值，保证唯一
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/whole-process/type/ini-add")
	public String iniAddTechFamilyType(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("userInfo", sysUserInfo);

		// 获取当前节点孩子的最大编码，新节点编码在原有基础上加1
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("parentId", request.getParameter("tfmTypeId"));
		HttpEntity<HashMap<String, String>> entity = new HttpEntity<HashMap<String, String>>(map, this.httpHeaders);
		ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(TECH_TYPE_STR, HttpMethod.POST, entity, JSONObject.class);
		JSONObject retJson = responseEntity.getBody();

		request.setAttribute("typeCode", retJson.get("maxTypeCode"));
		return "/stp/techFamily/techType_add";
	}

	@RequestMapping(value = "/whole-process/type/save", method = RequestMethod.POST)
	@ResponseBody
	@OperationFilter(modelName = "技术族", actionName = "新增技术族分类")
	public Result saveTechFamilyType(@RequestBody TechFamily techType, HttpServletRequest request) throws Exception {

		System.out.println("========/whole-process/type/save=========");

		techType.setStatus("1");
		techType.setCreateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
		techType.setIsParent("0");

		int retI = this.restTemplate.exchange(TECH_TYPE_ADD, HttpMethod.POST, new HttpEntity<TechFamily>(techType, this.httpHeaders), Integer.class).getBody();
		if (retI >= 1) {
			System.out.println("=================操作成功---" + retI);
			return new Result(true, "操作成功");
		} else {
			System.out.println("=================操作失败---" + retI);
			return new Result(true, "操作失败");
		}
	}

	/**
	 * @param jsonStr
	 * @return 删除对功能菜单配置的某个工作流
	 */
	@OperationFilter(modelName = "技术族", actionName = "删除技术族分类")
	@RequestMapping(value = "/whole-process/type", method = RequestMethod.DELETE)
	public Result deleteTechFamilyType(@RequestBody TechFamily techFamily) {

		System.out.println("======删除技术族分类=======" + techFamily);
		HttpEntity<TechFamily> entity = new HttpEntity<TechFamily>(techFamily, this.httpHeaders);

		Integer retI = this.restTemplate.exchange(TECH_TYPE_DELETE, HttpMethod.DELETE, entity, Integer.class).getBody();

		System.out.println("=================-----------" + retI);
		if (retI != null && retI >= 1) {
			System.out.println("=================操作成功");
			return new Result(true, "操作成功");
		} else {
			System.out.println("=================操作失败");
			return new Result(true, "操作失败");
		}
	}

}
