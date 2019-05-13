package com.pcitc.web.controller.out;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.web.common.BaseController;

@RestController
public class OutBaseDataController extends BaseController {

	private static final String BASE_DATA_ORG_TYPE = "http://pcitc-zuul/system-proxy/out-basedata-provider/basedata/search-org-type";
	private static final String BASE_DATA_ICS_TYPE = "http://pcitc-zuul/system-proxy/out-basedata-provider/basedata/search-ics-type-code";
	private static final String BASE_DATA_TARGET_TYPE = "http://pcitc-zuul/system-proxy/out-basedata-provider/basedata/search-target-type";

	@RequestMapping(value = "/out/basedata/search-org-type")
	public String getOutSearchOrgType(@ModelAttribute("param") LayuiTableParam param,HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(BASE_DATA_ORG_TYPE, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData data = responseEntity.getBody();
		System.out.println(JSON.toJSON(data).toString());
		return JSON.toJSON(data).toString();
	}
	@RequestMapping(value = "/out/basedata/search-ics-type-code")
	public String getOutSearchIcsType(@ModelAttribute("param") LayuiTableParam param,HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(BASE_DATA_ICS_TYPE, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData data = responseEntity.getBody();
		System.out.println(JSON.toJSON(data).toString());
		return JSON.toJSON(data).toString();
	}
	@RequestMapping(value = "/out/basedata/search-target-type")
	public String getOutSearchTargetType(@ModelAttribute("param") LayuiTableParam param,HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(BASE_DATA_TARGET_TYPE, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData data = responseEntity.getBody();
		System.out.println(JSON.toJSON(data).toString());
		return JSON.toJSON(data).toString();
	}
}
