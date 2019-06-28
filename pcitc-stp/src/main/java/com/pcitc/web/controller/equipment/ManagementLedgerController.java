package com.pcitc.web.controller.equipment;

import java.text.SimpleDateFormat;
import java.util.Date;

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
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;

@Controller
public class ManagementLedgerController extends BaseController {

	private static final String SELECT_URL = "http://pcitc-zuul/stp-proxy/sre-provider/Investmentrogress/management";
	private static final String MANA_URL = "http://pcitc-zuul/stp-proxy/sre-provider/mana/erplist";
	private static final String PAG_URL = "http://pcitc-zuul/stp-proxy/sre-provider/mana/page";
	
	@RequestMapping(value = "/sre-mana/to-list")
	public String list(HttpServletRequest request, HttpServletResponse response) {
		String	parentUnitPathIds="";
		String unitPathIds =   sysUserInfo.getUnitPath();
		parentUnitPathIds = EquipmentUtils.getParentUnitPathId(unitPathIds);
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SELECT_URL, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
		int count = responseEntity.getBody();
		Date data = new Date();
		String dateStr = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(data);
		dateStr = dateStr.substring(0, 4);
		request.setAttribute("dateStr", dateStr);
		request.setAttribute("count", count);
		request.setAttribute("parentUnitPathIds", parentUnitPathIds);
		return "/stp/equipment/managementledger/managementledger_list";
	}
	
	/**
	 * 列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sre-mana/list")
	@ResponseBody
	public String ajaxlist(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {
		
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PAG_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============result" + result);
		return result.toString();
	}
	
	/**
	 * 详情
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sre-mana/get/{erpnum}", method = RequestMethod.GET)
	public String get(@PathVariable("erpnum") String erpnum, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String erp = erpnum;
		request.setAttribute("erp", erp);
		return "/stp/equipment/managementledger/mana_view";
	}
	/**
	 * 详情列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sre-mana/manaView")
	@ResponseBody
	public String listView(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {
		
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(MANA_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============result" + result);
		return result.toString();
	}
}