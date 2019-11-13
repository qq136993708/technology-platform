package com.pcitc.web.controller.out;

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

import com.alibaba.fastjson.JSON;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.out.OutAppraisal;
import com.pcitc.web.common.BaseController;

@Controller
public class OutAppraisalController extends BaseController {
	
	private static final String APPRAISAL_LIST_PAGE = "http://pcitc-zuul/system-proxy/out-provider/appraisal-list";
	private static final String GET_OUT_APPRAISAL = "http://pcitc-zuul/system-proxy/out-provider/get-appraisal-list/";

	@RequestMapping(value = "/out/ini-appraisal-list")
	public String iniOutAppraisalList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/stp/out/out-appraisal-list";
	}
	
	@RequestMapping(value = "/out/appraisal-list", method = RequestMethod.POST)
	@ResponseBody
	public Object outAppraisalList(@ModelAttribute("param") LayuiTableParam param) {

		System.out.println("====/out/appraisal-list");
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(APPRAISAL_LIST_PAGE, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();

		return JSON.toJSON(retJson).toString();
	}

	@RequestMapping(value = "/out/appraisal-detail/{dataId}", method = RequestMethod.GET)
	public String iniOutAppraisalShow(@PathVariable("dataId") String dataId, HttpServletRequest request) {
		return "/stp/out/out-appraisal-show";
	}
	
	/**
	 * @author Nishikino 根据id获取數據
	 */
	@RequestMapping(value = "/out/getOutAppraisalShow/{dataId}", method = RequestMethod.POST)
	@ResponseBody
	public Object getOutAppraisalShow(@PathVariable("dataId") String dataId, HttpServletRequest request) {
		System.out.println("-------------------------getOutProjectShow--------------------------------");
		ResponseEntity<OutAppraisal> responseEntity = this.restTemplate.exchange(GET_OUT_APPRAISAL + dataId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), OutAppraisal.class);
		OutAppraisal outAppraisal = responseEntity.getBody();
		return outAppraisal;
	}
}
