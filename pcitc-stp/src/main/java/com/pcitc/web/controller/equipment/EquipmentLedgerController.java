package com.pcitc.web.controller.equipment;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;

@Controller
public class EquipmentLedgerController extends BaseController{

	private static final String PAGE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/equipmentLedger/page";
	
	
	
	
	//查某院的
	@RequestMapping(value = "/sre_equipment_ledger/company_list")
	public String company_list(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String unitCode = EquipmentUtils.getEquipmentUnitCode(sysUserInfo, restTemplate, httpHeaders);
		String g0gsjc = EquipmentUtils.getHanaUnitNameByUnitCode(unitCode, restTemplate, httpHeaders);
		request.setAttribute("g0gsjc", g0gsjc);
		return "/stp/equipment/ledger/company_list";
	}
	
	@RequestMapping(value = "/sre_equipment_ledger/company_list_data")
	@ResponseBody
	public String company_list_data(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {
		
		JSONObject parmamss = JSONObject.parseObject(JSONObject.toJSONString(param));
		logger.info("============参数：" + parmamss.toString());
		
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============查询结果：" + result);
		return result.toString();
	}
	
	
	
	//查所有院的
	@RequestMapping(value = "/sre_equipment_ledger/list")
	public String searchEquipment(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<SysDictionary>  leaddicList= CommonUtil.getDictionaryByParentCode("ROOT_FZJCZX_YS", restTemplate, httpHeaders);
		request.setAttribute("leaddicList", leaddicList);
		return "/stp/equipment/ledger/list";
	}
	@RequestMapping(value = "/sre_equipment_ledger/list_data")
	@ResponseBody
	public String ajaxlist(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {
		
		JSONObject parmamss = JSONObject.parseObject(JSONObject.toJSONString(param));
		logger.info("============参数：" + parmamss.toString());
		
		
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============查询结果：" + result);
		return result.toString();
	}
	
}
