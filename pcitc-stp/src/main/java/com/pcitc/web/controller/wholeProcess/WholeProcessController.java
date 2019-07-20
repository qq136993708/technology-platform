package com.pcitc.web.controller.wholeProcess;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.HanaUtil;

/**
 * @author zhf
 * @date 2018年9月11日 上午10:27:55 全流程可视化
 */
@Controller
public class WholeProcessController extends BaseController {

	private static final String TECH_TYPE_STR = "http://pcitc-zuul/stp-proxy//tech-family-provider/max-type-code";
	private static final String TECH_TYPE_LIST = "http://pcitc-zuul/stp-proxy/tech-family-provider/type-list";
	private static final String TECH_TYPE_ADD = "http://pcitc-zuul/stp-proxy/tech-family-provider/type-insert";
	private static final String TECH_TYPE_DELETE = "http://pcitc-zuul/stp-proxy/tech-family-provider/type-delete";
	
	private static final String SCIENCE_LIST = "http://pcitc-zuul/system-proxy/out-project-plan-provider/project-plan/cycle";
	private static final String SCIENCE_CONTRACT_DETAILS = "http://pcitc-zuul/system-proxy/out-project-plan-provider/project-contract/details";
	private static final String SCIENCE_PAY_DETAILS = "http://pcitc-zuul/system-proxy/out-project-plan-provider/project-pay/details";
	private static final String SCIENCE_APPRAISAL_DETAILS = "http://pcitc-zuul/system-proxy/out-project-plan-provider/project-appraisal/details";
	private static final String SCIENCE_REWARD_DETAILS = "http://pcitc-zuul/system-proxy/out-project-plan-provider/project-reward/details";
	
	/**
	 * 获取流程数据，分页
	 */
	@RequestMapping(value = "/whole-process/science/data/list")
	@ResponseBody
	public Object getScienceWholeProcessData(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(SCIENCE_LIST, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();

		return JSON.toJSON(retJson).toString();
	}
	
	/**
	 * 科技全流程可视化：重点项目
	 */
	@RequestMapping(value = "/whole-process/science/ini")
	public String iniScienceWholeProcess(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Date startDate = DateUtil.dateAdd(new Date(), -365);
		Date endDate = new Date();
		request.setAttribute("startDate", DateUtil.dateToStr(startDate, DateUtil.FMT_DD).substring(0, 7));
		request.setAttribute("endDate", DateUtil.dateToStr(endDate, DateUtil.FMT_DD).substring(0, 7));
		String xmmc = CommonUtil.getParameter(request, "xmmc", "");
		request.setAttribute("xmmc", xmmc);
		return "/stp/wholeProcess/scienceProcess";
	}
	
	/**
	 * 科技全流程可视化：重大专项
	 */
	@RequestMapping(value = "/whole-process/major-science/ini")
	public String iniMajorScienceWholeProcess(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*param.getParam().put("showType", "重大专项");
		param.getParam().put("xmlb", "非科研装备");
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(SCIENCE_LIST, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();
		
		request.setAttribute("sciList", retJson.getData());*/
		
		String xmmc = CommonUtil.getParameter(request, "xmmc", "");
		request.setAttribute("xmmc", xmmc);
		
		Date startDate = DateUtil.dateAdd(new Date(), -365);
		Date endDate = new Date();
		request.setAttribute("startDate", DateUtil.dateToStr(startDate, DateUtil.FMT_DD).substring(0, 7));
		request.setAttribute("endDate", DateUtil.dateToStr(endDate, DateUtil.FMT_DD).substring(0, 7));
		return "/stp/wholeProcess/majorScienceProcess";
	}
	
	/**
	 * 科技全流程可视化：国家项目。需要在项目管理中把国家项目和erp关联上
	 */
	@RequestMapping(value = "/whole-process/country-science/ini")
	public String iniCountryScienceWholeProcess(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) throws Exception {
		param.getParam().put("showType", "国家项目");
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(SCIENCE_LIST, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();
		
		request.setAttribute("sciList", retJson.getData());
		
		return "/stp/wholeProcess/countryScienceProcess";
	}
	
	/**
	 * 科技全流程可视化：装备项目
	 */
	@RequestMapping(value = "/whole-process/equipment-science/ini")
	public String iniEquipmentScienceWholeProcess(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Date startDate = DateUtil.dateAdd(new Date(), -365);
		Date endDate = new Date();
		request.setAttribute("startDate", DateUtil.dateToStr(startDate, DateUtil.FMT_DD).substring(0, 7));
		request.setAttribute("endDate", DateUtil.dateToStr(endDate, DateUtil.FMT_DD).substring(0, 7));
		String xmmc = CommonUtil.getParameter(request, "xmmc", "");
		request.setAttribute("xmmc", xmmc);
		return "/stp/wholeProcess/equipmentScienceProcess";
	}

	/**
	 * 科技全流程可视化
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/whole-process/science/details")
	public String getScienceProcessDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String xmid = request.getParameter("xmid");
		request.setAttribute("xmid", xmid);
		
		return "/stp/wholeProcess/scienceProcessDetails";
	}

	/**
	 * 项目的详情：合同信息
	 */
	@RequestMapping(value = "/whole-process/science/contract/data")
	@ResponseBody
	public Object scienceWholeProcessData(@ModelAttribute("param") LayuiTableParam param) throws Exception {
		// param 有xmid属性
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(SCIENCE_CONTRACT_DETAILS, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();

		return JSON.toJSON(retJson).toString();
	}
	
	/**
	 * 合同付款详情
	 */
	@RequestMapping(value = "/whole-process/science/pay/data")
	@ResponseBody
	public Object getContractPayDetails(@ModelAttribute("param") LayuiTableParam param) throws Exception {
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(SCIENCE_PAY_DETAILS, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();

		return JSON.toJSON(retJson).toString();
	}
	
	/**
	 * 合同成果详情
	 */
	@RequestMapping(value = "/whole-process/science/appraisal/data")
	@ResponseBody
	public Object getContractAppraisalDetails(@ModelAttribute("param") LayuiTableParam param) throws Exception {
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(SCIENCE_APPRAISAL_DETAILS, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();

		return JSON.toJSON(retJson).toString();
	}
	
	/**
	 * 项目奖励详情
	 */
	@RequestMapping(value = "/whole-process/science/reward/data")
	@ResponseBody
	public Object getProjectRewardDetails(@ModelAttribute("param") LayuiTableParam param) throws Exception {
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(SCIENCE_REWARD_DETAILS, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();

		return JSON.toJSON(retJson).toString();
	}


}
