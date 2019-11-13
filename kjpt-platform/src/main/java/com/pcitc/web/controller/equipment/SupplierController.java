package com.pcitc.web.controller.equipment;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.RequestProcessStatusEnum;
import com.pcitc.base.hana.report.H1AMKYZH100006;
import com.pcitc.base.stp.equipment.SreEquipment;
import com.pcitc.base.system.SysUnit;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;

@Controller
@RequestMapping(value = "/sre_supplier")
public class SupplierController extends BaseController{
	
	

	private static final String PAGE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/equipment/page";
	public static final String ADD_URL = "http://pcitc-zuul/stp-proxy/sre-provider/equipment/add";
	public static final String UPDATE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/equipment/update";
	private static final String DEL_URL = "http://pcitc-zuul/stp-proxy/sre-provider/equipment/delete/";
	public static final String GET_URL = "http://pcitc-zuul/stp-proxy/sre-provider/equipment/get/";
	private static final String GET_DIC_SUPPLYER_HANA_BY_IDS = "http://pcitc-zuul/hana-proxy/hana/common/dic/get_supplier_hana_by_ids";
	private static final String GET_DIC_SUPPLYER_STP_BY_IDS = "http://pcitc-zuul/stp-proxy/sre-provider/supplier/list-by-ids/";
	
	@RequestMapping(value = "/to_list")
	public String list(HttpServletRequest request, HttpServletResponse response) {
		
		return "/stp/equipment/equipment/supplier/list";
	}

	/**
	 * 列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/list")
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
	
	
	@RequestMapping(value = "/getHanaSupplierByIds")
	@ResponseBody
	public String getHanaSupplierByIds(HttpServletRequest request, HttpServletResponse response)
	{
		String supplierIds = CommonUtil.getParameter(request, "supplierIds", "");
		String companyCode = CommonUtil.getParameter(request, "companyCode", "");
		LayuiTableData layuiTableData =  EquipmentUtils.getHanaSupplierByIds(supplierIds, companyCode, request, response, restTemplate, httpHeaders);
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============getHanaSupplierByIds " + result);
		return result.toString();
		
	}
	
	
	@RequestMapping(value = "/getStpSupplierByIds")
	@ResponseBody
	public String getStpSupplierByIds(HttpServletRequest request, HttpServletResponse response) {
		LayuiTableData layuiTableData = new LayuiTableData();
		ResponseEntity<List> responseEntity = null;
		List returnlist = new ArrayList();
		String ids = CommonUtil.getParameter(request, "supplierIds", "");
		if (!ids.equals("")) 
		{
			String chkbox[] = ids.split(",");
			if (chkbox != null && chkbox.length > 0)
			{
				List<String> list = Arrays.asList(chkbox);
				JSONArray jsonObject = JSONArray.parseArray(JSON.toJSONString(list));
				HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
				responseEntity = restTemplate.exchange(GET_DIC_SUPPLYER_STP_BY_IDS, HttpMethod.POST, entity, List.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					returnlist = responseEntity.getBody();
				}
			}
		}
		layuiTableData.setData(returnlist);
		layuiTableData.setCode(0);
		layuiTableData.setCount(returnlist.size());
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============getHanaSupplierByIds " + result);
		return result.toString();
	}
	
	
	/**
	 * 增加
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/add")
	public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String applyDepartName = sysUserInfo.getUnitName();
		String applyDepartCode = sysUserInfo.getUnitCode();
		String firstApplyUser=sysUserInfo.getUserDisp();
		String attachmentDoc= IdUtil.createFileIdByTime();
		
		String equipmentId = CommonUtil.getParameter(request, "equipmentId", "");
		request.setAttribute("equipmentId", equipmentId);
		if(!equipmentId.equals(""))
		{
			ResponseEntity<SreEquipment> responseEntity = this.restTemplate.exchange(GET_URL + equipmentId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreEquipment.class);
			int statusCode = responseEntity.getStatusCodeValue();
			logger.info("============远程返回  statusCode " + statusCode);
			SreEquipment sreEquipment = responseEntity.getBody();
			request.setAttribute("sreEquipment", sreEquipment);
			
			applyDepartName = sreEquipment.getApplyDepartName();
			applyDepartCode = sreEquipment.getApplyDepartCode();
			firstApplyUser=sreEquipment.getFirstApplyUser();
			attachmentDoc=sreEquipment.getAttachmentDoc();
		}
		request.setAttribute("attachmentDoc", attachmentDoc);
		request.setAttribute("applyDepartName", applyDepartName);
		request.setAttribute("applyDepartCode", applyDepartCode);
		request.setAttribute("firstApplyUser", firstApplyUser);
		return "/stp/equipment/equipment/equipment-add";
	}

	

}
