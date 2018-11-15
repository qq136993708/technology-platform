package com.pcitc.web.controller.out;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
@RequestMapping(value = "/sys_wait")
public class OutWaitWorkController {
	private final static Logger logger = LoggerFactory.getLogger(OutWaitWorkController.class);
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private HttpHeaders httpHeaders;

	private static final String WAIT_WORK_PAGE = "http://pcitc-zuul/system-proxy/sys-wait-work/page";
	private static final String WAIT_WORK_LIST = "http://pcitc-zuul/system-proxy/sys-wait-work/list";

	@RequestMapping(value = "/page")
	@ResponseBody
	public String listSreSoftwareAccept(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(WAIT_WORK_PAGE, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============result" + result);
		return result.toString();
	}

}
