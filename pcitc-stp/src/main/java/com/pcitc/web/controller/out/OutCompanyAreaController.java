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
public class OutCompanyAreaController extends BaseController {

	private static final String COMPANY_LIST_PAGE = "http://pcitc-zuul/system-proxy/out-provider/company-list";

	@RequestMapping(value = "/out/ini-companyArea-list")
	public String iniOutProjectList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/stp/out/out-companyArea-list";
	}
	
	@RequestMapping(value = "/out/company-list", method = RequestMethod.POST)
	@ResponseBody
	public Object outProjectList(@ModelAttribute("param") LayuiTableParam param) {

		System.out.println("====/out/company-list");
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(COMPANY_LIST_PAGE, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();

		return JSON.toJSON(retJson).toString();
	}
	
	/*@RequestMapping(value = "/out/erp-project-config/{dataId}")
	public String iniErpProjectConfig(@PathVariable("dataId") String dataId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("1=====iniDealTask====" + dataId);


		// 当前人信息
		request.setAttribute("userInfo", sysUserInfo);

		return "/stp/out/erp-project-config";
	}*/
	
	/*@RequestMapping(value = "/out/erp-project-list", method = RequestMethod.POST)
	@ResponseBody
	public Object erpProjectList(@ModelAttribute("param") LayuiTableParam param) {

		System.out.println("====/out/erp-project-list");
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(ERP_PROJECT_LIST_PAGE, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();

		return JSON.toJSON(retJson).toString();
	}*/
	
	/*@RequestMapping(value = "/out/config-erp", method = RequestMethod.POST)
	@ResponseBody
	public Object saveErpConfig(@RequestBody String params) {

		System.out.println("1====/out/config-erp----"+params);
		// 把原有的当前页匹配都取消，同时把当前新匹配的配上
		JSONObject reJson = JSONObject.parseObject(params);

		HttpEntity<JSONObject> entity = new HttpEntity<JSONObject>(reJson, this.httpHeaders);

		ResponseEntity<String> responseEntity = this.restTemplate.exchange(CONFIG_ERP_URL, HttpMethod.POST, entity, String.class);
		String retFlag = responseEntity.getBody();
		System.out.println("2====/out/config-erp----"+retFlag);
		return new Result(true, "操作成功!");
	}*/
	
	/**
	 * 修改project
	 * @param params
	 * @return
	 */
	/*@RequestMapping(value = "/out/update-project", method = RequestMethod.POST)
	@ResponseBody
	public Object updateProject(@RequestBody String params) {

		System.out.println("1====/out/update-project----"+params);
		// 把原有的当前页匹配都取消，同时把当前新匹配的配上
		JSONObject reJson = JSONObject.parseObject(params);

		HttpEntity<JSONObject> entity = new HttpEntity<JSONObject>(reJson, this.httpHeaders);

		ResponseEntity<String> responseEntity = this.restTemplate.exchange(UPDATE_PROJECT_URL, HttpMethod.POST, entity, String.class);
		String retFlag = responseEntity.getBody();
		System.out.println("2====/out/update-project----"+retFlag);
		return new Result(true, "操作成功!");
	}*/

//	@RequestMapping(value = "/out/project-detail/{dataId}", method = RequestMethod.GET)
//	public String iniOutProjectShow(@PathVariable("dataId") String dataId, HttpServletRequest request) {
//		return "/stp/out/out-project-show";
//	}
	
	/**
	 * @author Nishikino 
	 * 根据id获取數據
	 */
	/*@RequestMapping(value = "/out/getOutProjectShow/{dataId}", method = RequestMethod.POST)
	@ResponseBody
	public Object getOutProjectShow(@PathVariable("dataId") String dataId, HttpServletRequest request) {
		System.out.println("-------------------------getOutProjectShow--------------------------------");
		ResponseEntity<OutProjectInfo> responseEntity = this.restTemplate.exchange(GET_OUT_PROJECT + dataId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), OutProjectInfo.class);
		OutProjectInfo outProjectInfo = responseEntity.getBody();
		return outProjectInfo;
	}*/
}
