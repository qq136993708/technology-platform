package com.pcitc.web.controller.hana;

import java.io.PrintWriter;
import java.math.BigDecimal;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.RequestProcessStatusEnum;
import com.pcitc.base.stp.report.TechCost;
import com.pcitc.base.stp.report.TechOrgCount;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;

@Controller
public class TechStatisticsController extends BaseController{
	
	
	private static final String PAGE_ORG_URL =   "http://pcitc-zuul/stp-proxy/sre-provider/techOrgCount/page";
	public static final String  ADD_ORG_URL =    "http://pcitc-zuul/stp-proxy/sre-provider/techOrgCount/add";
	public static final String  UPDATE_ORG_URL = "http://pcitc-zuul/stp-proxy/sre-provider/techOrgCount/update";
	private static final String DEL_ORG_URL =    "http://pcitc-zuul/stp-proxy/sre-provider/techOrgCount/delete/";
	public static final String GET_ORG_URL =     "http://pcitc-zuul/stp-proxy/sre-provider/techOrgCount/get/";
	private static final String ORG_WORKFLOW_URL = "http://pcitc-zuul/stp-proxy/sre-provider/techOrgCount/start_org_activity/";
	
	
	private static final String PAGE_COST_URL =   "http://pcitc-zuul/stp-proxy/sre-provider/techCost/page";
	public static final String  ADD_COST_URL =    "http://pcitc-zuul/stp-proxy/sre-provider/techCost/add";
	public static final String  UPDATE_COST_URL = "http://pcitc-zuul/stp-proxy/sre-provider/techCost/update";
	private static final String DEL_COST_URL =    "http://pcitc-zuul/stp-proxy/sre-provider/techCost/delete/";
	public static final String   GET_COST_URL =   "http://pcitc-zuul/stp-proxy/sre-provider/techCost/get/";
	private static final String COST_WORKFLOW_URL = "http://pcitc-zuul/stp-proxy/sre-provider/techCost/start_cost_activity/";
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	@RequestMapping(value = "/tech_cost/to-list")
	public String tech_cost(HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*Map<String, String> map = EquipmentUtils.getDepartInfoBySysUser(sysUserInfo, restTemplate, httpHeaders);
		String unitName = map.get("unitName");// 申报单位
		String unitCode = map.get("unitCode");// 申报单位
		String applyDepartName = map.get("applyDepartName");// 申报部门
		String applyDepartCode = map.get("applyDepartCode");// 申报部门
		request.setAttribute("unitName", unitName);
		request.setAttribute("unitCode", unitCode);*/
		
		
		String type = CommonUtil.getParameter(request, "type", "");
		request.setAttribute("type", type);
		//流程状态
		List<SysDictionary> auditStatusList=	EquipmentUtils.getSysDictionaryListByParentCode("ROOT_UNIVERSAL_LCZT", restTemplate, httpHeaders);
		request.setAttribute("auditStatusList", auditStatusList);
				
				
		return "/stp/hana/techStatistics/cost_list";
	}
	
	
	@RequestMapping(value = "/tech_cost/to-list-kjb")
	public String tech_cost_kjb(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//流程状态
		List<SysDictionary> auditStatusList=	EquipmentUtils.getSysDictionaryListByParentCode("ROOT_UNIVERSAL_LCZT", restTemplate, httpHeaders);
		request.setAttribute("auditStatusList", auditStatusList);
				
		return "/stp/hana/techStatistics/cost_list_kjb";
	}
	

	/**
	 * 列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/tech_cost/list")
	@ResponseBody
	public String tech_costajaxlist(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {

		
		JSONObject paramresult = JSONObject.parseObject(JSONObject.toJSONString(param));
		logger.info("============参数：" + paramresult.toString());
		
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PAGE_COST_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		// 安全设置：归档文件下载
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
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
	@RequestMapping(method = RequestMethod.GET, value = "/tech_cost/add")
	public String tech_costadd(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String createUserName = sysUserInfo.getUserDisp();
		String attachmentDoc = IdUtil.createFileIdByTime();

		Map<String, String> map = EquipmentUtils.getDepartInfoBySysUser(sysUserInfo, restTemplate, httpHeaders);
		String unitName = map.get("unitName");// 申报单位
		String unitCode = map.get("unitCode");// 申报单位
		String applyDepartName = map.get("applyDepartName");// 申报部门
		String applyDepartCode = map.get("applyDepartCode");// 申报部门
		String type = CommonUtil.getParameter(request, "type", "");
		request.setAttribute("type", type);

		String id = CommonUtil.getParameter(request, "id", "");
		request.setAttribute("id", id);
		if (!id.equals("")) {
			ResponseEntity<TechCost> responseEntity = this.restTemplate.exchange(GET_COST_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), TechCost.class);
			int statusCode = responseEntity.getStatusCodeValue();
			logger.info("============远程返回  statusCode " + statusCode);
			TechCost techCost = responseEntity.getBody();
			applyDepartName = techCost.getUnitName();
			applyDepartCode = techCost.getUnitCode();
			unitName = techCost.getUnitName();
			attachmentDoc = techCost.getAttachmentDoc();
			unitCode = techCost.getUnitCode();
			request.setAttribute("techCost", techCost);
		}
		request.setAttribute("attachmentDoc", attachmentDoc);
		request.setAttribute("createUserName", createUserName);
		request.setAttribute("applyDepartName", applyDepartName);
		request.setAttribute("applyDepartCode", applyDepartCode);
		request.setAttribute("unitName", unitName);
		request.setAttribute("unitCode", unitCode);
		
		return "/stp/hana/techStatistics/cost_add";
	}

	/**
	 * 保存-更新操作
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/tech_cost/save")
	public String tech_cost_saveOrUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result resultsDate = new Result();
		// 业务ID
		String id = CommonUtil.getParameter(request, "id", "");
		String techSubsidyCost = CommonUtil.getParameter(request, "techSubsidyCost", "");
		String techResearcherCost = CommonUtil.getParameter(request, "techResearcherCost", "");
		String notes = CommonUtil.getParameter(request, "notes", "");
		String techOtherCost = CommonUtil.getParameter(request, "techOtherCost", "");
		String type = CommonUtil.getParameter(request, "type", "");
		String techFacilitiesCost = CommonUtil.getParameter(request, "techFacilitiesCost", "");
		String techChargeMan = CommonUtil.getParameter(request, "techChargeMan", "");
		String techProjectCost = CommonUtil.getParameter(request, "techProjectCost", "");
		String provinceLeadCount = CommonUtil.getParameter(request, "provinceLeadCount", "");
		String provinceJoinCount = CommonUtil.getParameter(request, "provinceJoinCount", "");
		String createUserMobile = CommonUtil.getParameter(request, "createUserMobile", "");
		String applyDepartName = CommonUtil.getParameter(request, "applyDepartName", "");
		String applyDepartCode = CommonUtil.getParameter(request, "applyDepartCode", "");
		String countryLeadCount = CommonUtil.getParameter(request, "countryLeadCount", "");
		String countryJoinCount = CommonUtil.getParameter(request, "countryJoinCount", "");
		String chargeDepartMan = CommonUtil.getParameter(request, "chargeDepartMan", "");
		String provinceFunds = CommonUtil.getParameter(request, "provinceFunds", "");
		String countryFunds = CommonUtil.getParameter(request, "countryFunds", "");
		String techSubtotalCost = CommonUtil.getParameter(request, "techSubtotalCost", "");
		String unitCode = CommonUtil.getParameter(request, "unitCode", "");
		String unitName = CommonUtil.getParameter(request, "unitName", "");
		String attachmentDoc = CommonUtil.getParameter(request, "attachmentDoc", "");
		// 流程状态-是保存还是提交
		String auditStatus = CommonUtil.getParameter(request, "auditStatus", Constant.AUDIT_STATUS_DRAFT);
		TechCost techCost = null;
		ResponseEntity<String> responseEntity = null;
		// 判断是新增还是修改
		if (id.equals("")) {
			techCost = new TechCost();
			techCost.setCreateDate(new Date());
			techCost.setCreateUserId(sysUserInfo.getUserName());
			techCost.setCreateUserName(sysUserInfo.getUserDisp());
			String idv = UUID.randomUUID().toString().replaceAll("-", "");
			techCost.setId(idv); 
			techCost.setAuditStatus(auditStatus);

		} else {
			ResponseEntity<TechCost> se = this.restTemplate.exchange(GET_COST_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), TechCost.class);
			techCost  = se.getBody();
		}
		techCost.setAttachmentDoc(attachmentDoc);
		// 流程状态
		techCost.setChargeDepartMan(chargeDepartMan); 
		techCost.setApplyDepartCode(applyDepartCode);
		techCost.setApplyDepartName(applyDepartName);
		techCost.setChargeDepartMan(chargeDepartMan);
		techCost.setCountryFunds(new BigDecimal(countryFunds));
		techCost.setCountryJoinCount(Integer.valueOf(countryJoinCount));
		techCost.setCountryLeadCount(Integer.valueOf(countryLeadCount));
		techCost.setCreateUserMobile(createUserMobile);
		techCost.setNotes(notes);
		techCost.setProvinceFunds(new BigDecimal(provinceFunds));
		techCost.setProvinceJoinCount(Integer.valueOf(provinceJoinCount));
		techCost.setProvinceLeadCount(Integer.valueOf(provinceLeadCount));
		techCost.setTechProjectCost(new BigDecimal(techProjectCost));
		techCost.setType(type);
		techCost.setTechChargeMan(techChargeMan);
		techCost.setTechFacilitiesCost(new BigDecimal(techFacilitiesCost));
		techCost.setTechOtherCost(new BigDecimal(techOtherCost));
		techCost.setTechProjectCost(new BigDecimal(techProjectCost));
		techCost.setTechResearcherCost(new BigDecimal(techResearcherCost));
		techCost.setTechSubsidyCost(new BigDecimal(techSubsidyCost));
		techCost.setTechSubtotalCost(new BigDecimal(techSubtotalCost));
		techCost.setType(type);
		techCost.setUnitCode(unitCode);
		techCost.setUnitName(unitName);
		// 判断是新增还是修改
		if (id.equals(""))
		{
			responseEntity = this.restTemplate.exchange(ADD_COST_URL, HttpMethod.POST, new HttpEntity<TechCost>(techCost, this.httpHeaders), String.class);
		} else 
		{
			responseEntity = this.restTemplate.exchange(UPDATE_COST_URL, HttpMethod.POST, new HttpEntity<TechCost>(techCost, this.httpHeaders), String.class);
		}
		// 返回结果代码
		int statusCode = responseEntity.getStatusCodeValue();
		System.out.println(">>>>>>>>>>>>>>>>>>>返回  statusCode=" + statusCode);
		if (statusCode == 200) 
		{
			resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
		}else 
		{
			resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
		}

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		out.println(ob.toString());
		out.flush();
		out.close();
		return null;
	}

	
	
	
	
	/**
	 * 删除
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/tech_cost/delete/{id}")
	public String deletetech_cost(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(DEL_COST_URL + id, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
		int statusCode = responseEntity.getStatusCodeValue();
		int status = responseEntity.getBody();
		logger.info("============远程返回  statusCode " + statusCode + "  status=" + status);
		if (responseEntity.getBody() > 0) {
			resultsDate = new Result(true);
		} else {
			resultsDate = new Result(false, "删除失败，请联系系统管理员！");
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		out.println(ob.toString());
		out.flush();
		out.close();
		return null;
	}

	

	/**
	 * 详情
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/tech_cost/get/{id}", method = RequestMethod.GET)
	public String gettech_cost(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseEntity<TechCost> responseEntity = this.restTemplate.exchange(GET_COST_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), TechCost.class);
		int statusCode = responseEntity.getStatusCodeValue();
		logger.info("============远程返回  statusCode " + statusCode);
		TechCost techCost = responseEntity.getBody();
		request.setAttribute("techCost", techCost);
		return "/stp/hana/techStatistics/cost_view";
	}
	
	
	@RequestMapping(value = "/start_cost_workflow")
	@ResponseBody
	public Object start_cost_workflow(HttpServletRequest request, HttpServletResponse response) throws Exception {

		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);// 设置参数类型和编码
		String id = CommonUtil.getParameter(request, "id", "");
		String functionId = CommonUtil.getParameter(request, "functionId", "");
		String userIds = CommonUtil.getParameter(request, "userIds", "");
		
		System.out.println("========start_cost_workflow userIds=" + userIds + " functionId=" + functionId + " id=" + id);
		
		
		TechCost sreProject = EquipmentUtils.getTechCost(id, restTemplate, httpHeaders);
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("functionId", functionId);
		paramMap.put("processInstanceName", "科研投入统计->" + sreProject.getUnitName());
		paramMap.put("authenticatedUserId", sysUserInfo.getUserId());
		paramMap.put("authenticatedUserName", sysUserInfo.getUserDisp());
		paramMap.put("functionId", functionId);
		paramMap.put("auditor", userIds);
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap, this.httpHeaders);
		Result rs = this.restTemplate
				.exchange(COST_WORKFLOW_URL + id, HttpMethod.POST, httpEntity, Result.class).getBody();
		return rs;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@RequestMapping(value = "/tech_org/to-list")
	public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String parentUnitPathIds = EquipmentUtils.getEquipmentUnitCode(sysUserInfo, restTemplate, httpHeaders);
		request.setAttribute("parentUnitPathIds", parentUnitPathIds);
		
		//流程状态
				List<SysDictionary> auditStatusList=	EquipmentUtils.getSysDictionaryListByParentCode("ROOT_UNIVERSAL_LCZT", restTemplate, httpHeaders);
				request.setAttribute("auditStatusList", auditStatusList);
				String type = CommonUtil.getParameter(request, "type", "");
				request.setAttribute("type", type);
		return "/stp/hana/techStatistics/org_list";
	}

	
	
	@RequestMapping(value = "/tech_org/to-list-kjb")
	public String tech_org_kjb(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		//流程状态
				List<SysDictionary> auditStatusList=	EquipmentUtils.getSysDictionaryListByParentCode("ROOT_UNIVERSAL_LCZT", restTemplate, httpHeaders);
				request.setAttribute("auditStatusList", auditStatusList);
		return "/stp/hana/techStatistics/org_list_kjb";
	}
	
	/**
	 * 列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/tech_org/list")
	@ResponseBody
	public String ajaxlist(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {

		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PAGE_ORG_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		// 安全设置：归档文件下载
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
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
	@RequestMapping(method = RequestMethod.GET, value = "/tech_org/add")
	public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String createUserName = sysUserInfo.getUserDisp();
		String attachmentDoc = IdUtil.createFileIdByTime();

		Map<String, String> map = EquipmentUtils.getDepartInfoBySysUser(sysUserInfo, restTemplate, httpHeaders);
		String unitName = map.get("unitName");// 申报单位
		String unitCode = map.get("unitCode");// 申报单位
		String applyDepartName = map.get("applyDepartName");// 申报部门
		String applyDepartCode = map.get("applyDepartCode");// 申报部门
		

		
		String type = CommonUtil.getParameter(request, "type", "");
		request.setAttribute("type", type);
		
		
		String id = CommonUtil.getParameter(request, "id", "");
		request.setAttribute("id", id);
		if (!id.equals("")) {
			ResponseEntity<TechOrgCount> responseEntity = this.restTemplate.exchange(GET_ORG_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), TechOrgCount.class);
			int statusCode = responseEntity.getStatusCodeValue();
			logger.info("============远程返回  statusCode " + statusCode);
			TechOrgCount techOrgCount = responseEntity.getBody();
			request.setAttribute("techOrgCount", techOrgCount);
			applyDepartName = techOrgCount.getUnitName();
			applyDepartCode = techOrgCount.getUnitCode();
			unitName = techOrgCount.getUnitName();
			unitCode = techOrgCount.getUnitCode();
			attachmentDoc= techOrgCount.getAttachmentDoc();
		}
		request.setAttribute("attachmentDoc", attachmentDoc);
		request.setAttribute("createUserName", createUserName);
		request.setAttribute("applyDepartName", applyDepartName);
		request.setAttribute("applyDepartCode", applyDepartCode);
		request.setAttribute("unitName", unitName);
		request.setAttribute("unitCode", unitCode);
		return "/stp/hana/techStatistics/org_add";
	}

	/**
	 * 保存-更新操作
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/tech_org/save")
	public String saveOrUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result resultsDate = new Result();
		String achievementsCompanyCount = CommonUtil.getParameter(request, "achievementsCompanyCount", "");
		// 业务ID
		String id = CommonUtil.getParameter(request, "id", "");
		String achievementsCountryCount = CommonUtil.getParameter(request, "achievementsCountryCount", "");
		String allPatentCount = CommonUtil.getParameter(request, "allPatentCount", "");
		String notes = CommonUtil.getParameter(request, "notes", "");
		String assetsTotal = CommonUtil.getParameter(request, "assetsTotal", "");
		String type = CommonUtil.getParameter(request, "type", "");
		String assistResearcherCount = CommonUtil.getParameter(request, "assistResearcherCount", "");
		String chargeDepartMan = CommonUtil.getParameter(request, "chargeDepartMan", "");
		String countryInvestCost = CommonUtil.getParameter(request, "countryInvestCost", "");
		String outInvestCost = CommonUtil.getParameter(request, "outInvestCost", "");
		String createUserMobile = CommonUtil.getParameter(request, "createUserMobile", "");
		String femaleCount = CommonUtil.getParameter(request, "femaleCount", "");
		String directResearcherCount = CommonUtil.getParameter(request, "directResearcherCount", "");
		String applyDepartName = CommonUtil.getParameter(request, "applyDepartName", "");
		String applyDepartCode = CommonUtil.getParameter(request, "applyDepartCode", "");
		String diplomaMasterCount = CommonUtil.getParameter(request, "diplomaMasterCount", "");
		String currentYearPatentCount = CommonUtil.getParameter(request, "currentYearPatentCount", "");
		String currentPatentLookCount = CommonUtil.getParameter(request, "currentPatentLookCount", "");
		String diplomaUndergraduateCount = CommonUtil.getParameter(request, "diplomaUndergraduateCount", "");
		String diplomaDoctorCount = CommonUtil.getParameter(request, "diplomaDoctorCount", "");
		String auditStatus = CommonUtil.getParameter(request, "auditStatus", Constant.AUDIT_STATUS_DRAFT);
		String deviceAssets = CommonUtil.getParameter(request, "deviceAssets", "");
		String researcherCount = CommonUtil.getParameter(request, "researcherCount", "");
		String techChargeMan = CommonUtil.getParameter(request, "techChargeMan", "");
		String thesisAllCount = CommonUtil.getParameter(request, "thesisAllCount", "");
		String thesisEiCount = CommonUtil.getParameter(request, "thesisEiCount", "");
		String thesisIsrCount = CommonUtil.getParameter(request, "thesisIsrCount", "");
		String thesisIstpCount = CommonUtil.getParameter(request, "thesisIstpCount", "");
		String thesisSciCount = CommonUtil.getParameter(request, "thesisSciCount", "");
		String titleLowerCount = CommonUtil.getParameter(request, "titleLowerCount", "");
		String titleMiddleCount = CommonUtil.getParameter(request, "titleMiddleCount", "");
		String titleSeniorCount = CommonUtil.getParameter(request, "titleSeniorCount", "");
		String totaIncome = CommonUtil.getParameter(request, "totaIncome", "");
		String unitCode = CommonUtil.getParameter(request, "unitCode", "");
		String unitName = CommonUtil.getParameter(request, "unitName", "");
		String workerSalary = CommonUtil.getParameter(request, "workerSalary", "");
		String workersCount = CommonUtil.getParameter(request, "workersCount", "");
		String fixedAssets = CommonUtil.getParameter(request, "fixedAssets", "");
		String groupInvestCost = CommonUtil.getParameter(request, "groupInvestCost", "");
		String attachmentDoc = CommonUtil.getParameter(request, "attachmentDoc", "");
		
		String specialistCountryCount = CommonUtil.getParameter(request, "specialistCountryCount", "");
		String specialistProvinceCount = CommonUtil.getParameter(request, "specialistProvinceCount", "");
		String subInvestCost = CommonUtil.getParameter(request, "subInvestCost", "");
		String allPatentLookCount = CommonUtil.getParameter(request, "allPatentLookCount", "");
		String achievementsPrivanceCount = CommonUtil.getParameter(request, "achievementsPrivanceCount", "");
		
		
		
		TechOrgCount techOrgCount = null;
		ResponseEntity<String> responseEntity = null;
		// 判断是新增还是修改
		if (id.equals("")) {
			techOrgCount = new TechOrgCount();
			techOrgCount.setCreateDate(new Date());
			techOrgCount.setCreateUserId(sysUserInfo.getUserName());
			String idv = UUID.randomUUID().toString().replaceAll("-", "");
			techOrgCount.setId(idv); 
			techOrgCount.setAuditStatus(auditStatus);
			System.out.println("---------------applyDepartCode:" + applyDepartCode + " applyDepartCode=" + applyDepartCode + " UserId=" + sysUserInfo.getUserId());

		} else {
			ResponseEntity<TechOrgCount> se = this.restTemplate.exchange(GET_ORG_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), TechOrgCount.class);
			techOrgCount  = se.getBody();
		}
		techOrgCount.setAttachmentDoc(attachmentDoc);
		techOrgCount.setAchievementsCompanyCount(Integer.valueOf(achievementsCompanyCount));
		techOrgCount.setAchievementsCompanyCount(Integer.valueOf(achievementsCompanyCount));
		techOrgCount.setAchievementsCountryCount(Integer.valueOf(achievementsCountryCount));
		techOrgCount.setAllPatentCount(Integer.valueOf(allPatentCount));
		techOrgCount.setApplyDepartCode(applyDepartCode);
		techOrgCount.setApplyDepartName(applyDepartName);
		techOrgCount.setAssetsTotal(new BigDecimal(assetsTotal));
		techOrgCount.setAssistResearcherCount(Integer.valueOf(assistResearcherCount));
		techOrgCount.setChargeDepartMan(chargeDepartMan);
		techOrgCount.setCountryInvestCost(new BigDecimal(countryInvestCost));
		techOrgCount.setCreateUserMobile(createUserMobile);
		techOrgCount.setCreateUserName(sysUserInfo.getUserDisp());
		techOrgCount.setCurrentPatentLookCount(Integer.valueOf(currentPatentLookCount));
		techOrgCount.setCurrentYearPatentCount(Integer.valueOf(currentYearPatentCount));
		techOrgCount.setAchievementsCompanyCount(Integer.valueOf(achievementsCompanyCount));
		techOrgCount.setDeviceAssets(new BigDecimal(deviceAssets));
		techOrgCount.setDiplomaDoctorCount(Integer.valueOf(diplomaDoctorCount));
		techOrgCount.setDiplomaUndergraduateCount(Integer.valueOf(diplomaUndergraduateCount));
		techOrgCount.setDiplomaMasterCount(Integer.valueOf(diplomaMasterCount));
		techOrgCount.setDirectResearcherCount(Integer.valueOf(directResearcherCount));
		techOrgCount.setFemaleCount(Integer.valueOf(femaleCount));
		techOrgCount.setFixedAssets(new BigDecimal(fixedAssets));
		techOrgCount.setGroupInvestCost(new BigDecimal(groupInvestCost));
		techOrgCount.setNotes(notes);
		techOrgCount.setOutInvestCost(new BigDecimal(outInvestCost));
		techOrgCount.setResearcherCount(Integer.valueOf(researcherCount));
		techOrgCount.setTechChargeMan(techChargeMan);
		techOrgCount.setThesisAllCount(Integer.valueOf(thesisAllCount));
		techOrgCount.setThesisEiCount(Integer.valueOf(thesisEiCount));
		techOrgCount.setThesisIsrCount(Integer.valueOf(thesisIsrCount));
		techOrgCount.setThesisIstpCount(Integer.valueOf(thesisIstpCount));
		techOrgCount.setThesisSciCount(Integer.valueOf(thesisSciCount));
		techOrgCount.setTitleLowerCount(Integer.valueOf(titleLowerCount));
		techOrgCount.setTitleMiddleCount(Integer.valueOf(titleMiddleCount));
		techOrgCount.setTitleSeniorCount(Integer.valueOf(titleSeniorCount));
		techOrgCount.setTotaIncome(new BigDecimal(totaIncome));
		techOrgCount.setType(type);
		techOrgCount.setAssetsTotal(new BigDecimal(assetsTotal));
		techOrgCount.setUnitCode(unitCode);
		techOrgCount.setUnitName(unitName);
		techOrgCount.setWorkerSalary(new BigDecimal(workerSalary));
		techOrgCount.setWorkersCount(Integer.valueOf(workersCount));
		techOrgCount.setSpecialistCountryCount(Integer.valueOf(specialistCountryCount));
		techOrgCount.setSpecialistProvinceCount(Integer.valueOf(specialistProvinceCount));
		techOrgCount.setSubInvestCost(new BigDecimal(subInvestCost));
		techOrgCount.setAllPatentLookCount(Integer.valueOf(allPatentLookCount));
		techOrgCount.setAchievementsPrivanceCount(Integer.valueOf(achievementsPrivanceCount));
		// 判断是新增还是修改
		if (id.equals("")) {
			responseEntity = this.restTemplate.exchange(ADD_ORG_URL, HttpMethod.POST, new HttpEntity<TechOrgCount>(techOrgCount, this.httpHeaders), String.class);

		} else {
			responseEntity = this.restTemplate.exchange(UPDATE_ORG_URL, HttpMethod.POST, new HttpEntity<TechOrgCount>(techOrgCount, this.httpHeaders), String.class);
		}
		// 返回结果代码
		int statusCode = responseEntity.getStatusCodeValue();
		System.out.println(">>>>>>>>>>>>>>>>>>>返回  statusCode=" + statusCode);
		if (statusCode == 200) {
			resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
		} else {
			resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
		}

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		out.println(ob.toString());
		out.flush();
		out.close();
		return null;
	}
	
	
	
	/**
	 * 删除
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/tech_org/delete/{id}")
	public String delete(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(DEL_ORG_URL + id, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
		int statusCode = responseEntity.getStatusCodeValue();
		int status = responseEntity.getBody();
		logger.info("============远程返回  statusCode " + statusCode + "  status=" + status);
		if (responseEntity.getBody() > 0) {
			resultsDate = new Result(true);
		} else {
			resultsDate = new Result(false, "删除失败，请联系系统管理员！");
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		out.println(ob.toString());
		out.flush();
		out.close();
		return null;
	}

	

	/**
	 * 详情
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/tech_org/get/{id}", method = RequestMethod.GET)
	public String get(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseEntity<TechOrgCount> responseEntity = this.restTemplate.exchange(GET_ORG_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), TechOrgCount.class);
		int statusCode = responseEntity.getStatusCodeValue();
		logger.info("============远程返回  statusCode " + statusCode);
		TechOrgCount techOrgCount = responseEntity.getBody();
		request.setAttribute("techOrgCount", techOrgCount);
		return "/stp/hana/techStatistics/org_view";
	}
	
	
	@RequestMapping(value = "/start_org_workflow")
	@ResponseBody
	public Object start_org_workflow(HttpServletRequest request, HttpServletResponse response) throws Exception {

		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);// 设置参数类型和编码
		String id = CommonUtil.getParameter(request, "id", "");
		String functionId = CommonUtil.getParameter(request, "functionId", "");
		String userIds = CommonUtil.getParameter(request, "userIds", "");
		TechOrgCount sreProject = EquipmentUtils.getTechOrgCount(id, restTemplate, httpHeaders);
		System.out.println(
				"============start_org_workflow userIds=" + userIds + " functionId=" + functionId + " id=" + id);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("functionId", functionId);
		paramMap.put("processInstanceName", "科研机构调查表统计->" + sreProject.getUnitName());
		paramMap.put("authenticatedUserId", sysUserInfo.getUserId());
		paramMap.put("authenticatedUserName", sysUserInfo.getUserDisp());
		paramMap.put("functionId", functionId);
		paramMap.put("auditor", userIds);
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap, this.httpHeaders);
		Result rs = this.restTemplate
				.exchange(ORG_WORKFLOW_URL + id, HttpMethod.POST, httpEntity, Result.class).getBody();
		return rs;
	}
	
	
	
	
	

}
