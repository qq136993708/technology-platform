package com.pcitc.web.controller.out;

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

import com.alibaba.fastjson.JSON;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.web.common.BaseController;

@Controller
public class OutPatentController extends BaseController {
	
	private static final String APPRAISAL_LIST_PAGE = "http://pcitc-zuul/system-proxy/out-patent-provider/patent-list";

	@RequestMapping(value = "/out/ini-patent-list")
	public String iniOutPatentList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/stp/out/out-patent-list";
	}
	
	@RequestMapping(value = "/out/patent-list", method = RequestMethod.POST)
	@ResponseBody
	public Object outPatentList(@ModelAttribute("param") LayuiTableParam param) {

		System.out.println("====/out/patent-list");
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(APPRAISAL_LIST_PAGE, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();

		return JSON.toJSON(retJson).toString();
	}

}
