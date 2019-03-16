package com.pcitc.web.controller.system;

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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.equipment.SreContract;
import com.pcitc.base.stp.equipment.UnitField;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;


@Controller
@RequestMapping(value = "/unitField")
public class UnitFieldController extends BaseController 
{

	private static final String getUnitNameList = "http://pcitc-zuul/stp-proxy/stp_unitField/getUnitNameList";
	private static final String getProfessionalNameListByUnitNameAndDept = "http://pcitc-zuul/stp-proxy/stp_unitField/getProfessionalNameListByUnitNameAndDept";
	private static final String getDepartmentNameListByUnitName = "http://pcitc-zuul/stp-proxy/stp_unitField/getDepartmentNameListByUnitName";

	
	@RequestMapping(value = "/getUnitNameList")
	@ResponseBody
	public String getUnitNameList(HttpServletRequest request, HttpServletResponse response) 
	{
		List list=new ArrayList();
		ResponseEntity<List> responseEntity = this.restTemplate.exchange(getUnitNameList, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), List.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) 
		{
			list = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(list));
		logger.info("============result" + result);
		return result.toString();
	}
	
	
	
	@RequestMapping(value = "/getDepartmentNameListByUnitName")
	@ResponseBody
	public String getDepartmentNameListByUnitName(HttpServletRequest request, HttpServletResponse response) 
	{
		String unitName = CommonUtil.getParameter(request, "unitName", "");
		UnitField unitField=new UnitField();
		unitField.setUnitName(unitName);
		List list=new ArrayList();
		ResponseEntity<List> responseEntity = this.restTemplate.exchange(getDepartmentNameListByUnitName, HttpMethod.POST, new HttpEntity<UnitField>(unitField, this.httpHeaders), List.class);
	    int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) 
		{
			list = responseEntity.getBody();
		}
		JSONArray result = JSONArray.parseArray(JSON.toJSONString(list));
		logger.info("============result" + result);
		return result.toString();
	}
	
	
	
	@RequestMapping(value = "/getProfessionalNameListByUnitNameAndDept")
	@ResponseBody
	public String getProfessionalNameListByUnitNameAndDept(HttpServletRequest request, HttpServletResponse response) 
	{
		String unitName = CommonUtil.getParameter(request, "unitName", "");
		String departmentName = CommonUtil.getParameter(request, "departmentName", "");
		UnitField unitField=new UnitField();
		unitField.setUnitName(unitName);
		unitField.setDepartmentName(departmentName);
		List list=new ArrayList();
		ResponseEntity<List> responseEntity = this.restTemplate.exchange(getProfessionalNameListByUnitNameAndDept, HttpMethod.POST, new HttpEntity<UnitField>(unitField, this.httpHeaders), List.class);
	    int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) 
		{
			list = responseEntity.getBody();
		}
		JSONArray result = JSONArray.parseArray(JSON.toJSONString(list));
		logger.info("============result" + result);
		return result.toString();
	}
	
	

}
