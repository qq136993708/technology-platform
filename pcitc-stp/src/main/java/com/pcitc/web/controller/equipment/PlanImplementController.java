package com.pcitc.web.controller.equipment;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.equipment.SreEquipment;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;

@Controller
public class PlanImplementController extends BaseController {
	
	private static final String PAGE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/planImplement/page";
	
	
	/**
	 * 规划发布列表
	 * 
	 * @param requestPAGE_URL
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sre-planImplement/list")
	@ResponseBody
	public String ajaxlist(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {
		
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============result" + result);
		return result.toString();
	}
	
	/**
	 * 规划发布页
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sre-planImplement/to-list")
	public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> map = EquipmentUtils.getDepartInfoBySysUser(sysUserInfo, restTemplate, httpHeaders);
		String parentUnitPathNames = map.get("unitName");// 申报单位
		String parentUnitPathIds = map.get("unitCode");// 申报单位
		String applyDepartName = map.get("applyDepartName");// 申报部门
		String applyDepartCode = map.get("applyDepartCode");// 申报部门
		String unitPathIds= map.get("applyDepartCode");
		String unitPathNames= map.get("applyDepartName");
		String unitPathId = sysUserInfo.getUnitPath();
		boolean isKJBPerson = EquipmentUtils.isKJBPerson(unitPathId);
	    request.setAttribute("isKJBPerson", isKJBPerson);
	    List<SysDictionary>  dictonary= CommonUtil.getDictionaryByParentCode("ROOT_FZJCZX_YS", restTemplate, httpHeaders);
		request.setAttribute("unitPathIds", unitPathIds);//父id
		request.setAttribute("parentUnitPathIds", parentUnitPathIds);//子id
		request.setAttribute("parentUnitPathNames", parentUnitPathNames);//研究院
		request.setAttribute("applyDepartName", applyDepartName);//当前部门
		return "/stp/equipment/planImplement/planImplement-list";
	}
	
	/**
	 * 新增规划发布页
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/sre-planImplement/add")
	public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> map = EquipmentUtils.getDepartInfoBySysUser(sysUserInfo, restTemplate, httpHeaders);
		String parentUnitPathNames = map.get("unitName");// 申报单位
		String parentUnitPathIds = map.get("unitCode");// 申报单位
		String applyDepartName = map.get("applyDepartName");// 申报部门
		String applyDepartCode = map.get("applyDepartCode");// 申报部门
		String unitPathIds= map.get("applyDepartCode");
		String unitPathNames= map.get("applyDepartName");
		String unitPathId = sysUserInfo.getUnitPath();
		String UserDisp = sysUserInfo.getUserDisp();//申请人
		boolean isKJBPerson = EquipmentUtils.isKJBPerson(unitPathId);
	    request.setAttribute("isKJBPerson", isKJBPerson);
		request.setAttribute("unitPathIds", unitPathIds);//父id
		request.setAttribute("parentUnitPathIds", parentUnitPathIds);//子id
		request.setAttribute("parentUnitPathNames", parentUnitPathNames);//研究院
		request.setAttribute("applyDepartName", applyDepartName);//当前部门
		request.setAttribute("UserDisp", UserDisp);//申请人
		return "/stp/equipment/planImplement/planImplement-add";
	}
	
}		
