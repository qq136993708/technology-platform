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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.equipment.SreForApplication;
import com.pcitc.base.stp.equipment.SrePurchase;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;

@Controller
public class ProcurementProgramController extends BaseController {
	
	private static final String PAGE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/purchase/page";
	private static final String PRP_URL = "http://pcitc-zuul/stp-proxy/sre-provider/Investmentrogress/prppage";
	private static final String GET_URL = "http://pcitc-zuul/stp-proxy/sre-provider/purchase/get/";
	/**
	 * 列表
	 * pd
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sre-procurementprogram/list")
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

	@RequestMapping(value = "/sre-procurementprogram/to-list")
	public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> map = EquipmentUtils.getDepartInfoBySysUser(sysUserInfo, restTemplate, httpHeaders);
		String parentUnitPathNames = map.get("unitName");// 申报单位
		String parentUnitPathIds = map.get("unitCode");// 申报单位
		String applyDepartName = map.get("applyDepartName");// 申报部门
		String applyDepartCode = map.get("applyDepartCode");// 申报部门
		String unitPathNames= map.get("applyDepartName");
			request.setAttribute("parentUnitPathIds", parentUnitPathIds);
			String unitPathIds = sysUserInfo.getUnitPath();
			boolean isKJBPerson = EquipmentUtils.isKJBPerson(unitPathIds);
		    request.setAttribute("isKJBPerson", isKJBPerson);
		    List<SysDictionary> dicList = CommonUtil.getDictionaryByParentCode("ROOT_UNIVERSAL_BDYJY", restTemplate,
					httpHeaders);
		    String str ="1";
		    if(isKJBPerson == true) {
		    	//获取研究院
				request.setAttribute("dictonary", dicList);
				request.setAttribute("str", "1");
		    }else {
		    	request.setAttribute("dictonary", dicList);
		    	request.setAttribute("str", "0");
		    }
		return "/stp/equipment/procurementprogram/procurementprogram-list";
	}
	
	
	/**
	 * 采购进度展示页面
	 */
	@RequestMapping(value = "/sre-procurementprogram/get/{purchaseId}", method = RequestMethod.GET)
	public String get(@PathVariable("purchaseId") String purchaseId, HttpServletRequest request, HttpServletResponse response) {
		return "/stp/equipment/procurementprogram/procurementprogram-view";
	}
	
	/**
	 * 投资进度展示列表
	 * pd
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sre-procurementprogram/procurelist")
	@ResponseBody
	public String gresslist(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {
		
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PRP_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============result" + result);
		return result.toString();
	}
}
