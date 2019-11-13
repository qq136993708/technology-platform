package com.pcitc.web.controller.hana;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.hana.report.CompanyCode;
import com.pcitc.base.hana.report.ProjectCode;
import com.pcitc.web.common.BaseController;

@Controller
@RequestMapping(value = "/common-dic")
public class CommonDicController extends BaseController {

	// 公司代码
	private static final String GET_COMPANY_DIC_LIST = "http://pcitc-zuul/hana-proxy/hana/common/dic/company-code";
	// 项目代码
	private static final String GET_PROJECT_DIC_LIST = "http://pcitc-zuul/hana-proxy/hana/common/dic/porject-code";

	public List<CompanyCode> getCompanyCode() throws Exception {

		List<CompanyCode> list = null;
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);

		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_COMPANY_DIC_LIST, HttpMethod.GET, entity, JSONArray.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			JSONArray array = responseEntity.getBody();
			list = JSONObject.parseArray(array.toJSONString(), CompanyCode.class);
		}
		return list;
	}

	public List<ProjectCode> getProjectCode() throws Exception {

		List<ProjectCode> list = null;
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_PROJECT_DIC_LIST, HttpMethod.GET, entity, JSONArray.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			JSONArray array = responseEntity.getBody();
			list = JSONObject.parseArray(array.toJSONString(), ProjectCode.class);
		}
		return list;
	}

}
