package com.pcitc.web.controller.equipment;

import java.math.BigDecimal;
import java.util.List;

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
import com.pcitc.base.stp.equipment.SreEquipment;
import com.pcitc.base.stp.equipment.SreProject;
import com.pcitc.base.stp.equipment.SreProjectTask;
import com.pcitc.base.stp.equipment.UnitField;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;

@Controller
public class InvestmentProgressController extends BaseController {
	
	private static final String PAGE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/project_basic/page";
	
	private static final String ESS_URL = "http://pcitc-zuul/stp-proxy/sre-provider/Investmentrogress/page";
	/**
	 * 列表
	 * pd
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sre-Investmentrogress/list")
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

	@RequestMapping(value = "/sre-Investmentrogress/to-list")
	public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String	parentUnitPathIds="";
		String unitPathIds =   sysUserInfo.getUnitPath();
		String applyDepartCode = sysUserInfo.getUnitCode();
		if(!unitPathIds.equals(""))
		{
			if(unitPathIds.length()>4)
			{
				parentUnitPathIds=unitPathIds.substring(0, unitPathIds.length()-4);
				
			}
		}
		request.setAttribute("applyDepartCode", applyDepartCode);
		request.setAttribute("parentUnitPathIds", parentUnitPathIds);
		return "/stp/equipment/Investmentrogress/Investmentrogress-list";
	}
	
	
	/**
	 * 投资进度展示页面
	 */
	@RequestMapping(value = "/sre-Investmentrogress/get/{InvestmentrogressId}", method = RequestMethod.GET)
	public String get(@PathVariable("InvestmentrogressId") String InvestmentrogressId, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		BigDecimal equipmentmoney = new BigDecimal(0);
		SreProject sreProject=EquipmentUtils.getSreProject(InvestmentrogressId, restTemplate, httpHeaders);
		String[] sre = sreProject.getEquipmentIds().split(",");
		for(int i =0;i<sre.length;i++) {
			SreEquipment  sreEquipment= EquipmentUtils.getSreEquipment(sre[i], restTemplate, httpHeaders);
			if(sreEquipment!=null) {
				equipmentmoney = equipmentmoney.add(sreEquipment.getUnitPrice());
			}
		}
		request.setAttribute("equipmentmoney", equipmentmoney);
		return "/stp/equipment/Investmentrogress/Investmentrogress-view";
	}
	
	/**
	 * 投资进度展示列表
	 * pd
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sre-Investmentrogress/gresslist")
	@ResponseBody
	public String gresslist(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {
		
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(ESS_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============result" + result);
		return result.toString();
	}
}
