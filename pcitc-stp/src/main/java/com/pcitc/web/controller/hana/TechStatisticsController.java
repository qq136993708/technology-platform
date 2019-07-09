package com.pcitc.web.controller.hana;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
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
import com.pcitc.base.stp.equipment.SreProject;
import com.pcitc.base.stp.report.TechCost;
import com.pcitc.base.stp.report.TechOrgCount;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;

@Controller
public class TechStatisticsController extends BaseController{
	
	
	private static final String PAGE_ORG_URL =   "http://pcitc-zuul/hana-proxy/hana_provider/techOrgCount/page";
	public static final String  ADD_ORG_URL =    "http://pcitc-zuul/hana-proxy/hana_provider/techOrgCount/add";
	public static final String  UPDATE_ORG_URL = "http://pcitc-zuul/hana-proxy/hana_provider/techOrgCount/update";
	private static final String DEL_ORG_URL =    "http://pcitc-zuul/hana-proxy/hana_provider/techOrgCount/delete/";
	public static final String GET_ORG_URL =     "http://pcitc-zuul/hana-proxy/hana_provider/techOrgCount/get/";
	private static final String ORG_WORKFLOW_URL = "http://pcitc-zuul/stp-proxy/hana_provider/techOrgCount/start_org_activity/";
	
	
	private static final String PAGE_COST_URL =   "http://pcitc-zuul/hana-proxy/hana_provider/techCost/page";
	public static final String  ADD_COST_URL =    "http://pcitc-zuul/hana-proxy/hana_provider/techCost/add";
	public static final String  UPDATE_COST_URL = "http://pcitc-zuul/hana-proxy/hana_provider/techCost/update";
	private static final String DEL_COST_URL =    "http://pcitc-zuul/hana-proxy/hana_provider/techCost/delete/";
	public static final String   GET_COST_URL =   "http://pcitc-zuul/hana-proxy/hana_provider/techCost/get/";
	private static final String COST_WORKFLOW_URL = "http://pcitc-zuul/stp-proxy/hana_provider/techCost/start_cost_activity/";
	
	
	
	
	@RequestMapping(value = "/tech_org/to-list")
	public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String unitPathIds = sysUserInfo.getUnitPath();
		String parentUnitPathIds = EquipmentUtils.getEquipmentUnitCode(sysUserInfo, restTemplate, httpHeaders);
		request.setAttribute("parentUnitPathIds", parentUnitPathIds);
		boolean isKJBPerson = EquipmentUtils.isKJBPerson(unitPathIds);
		request.setAttribute("isKJBPerson", isKJBPerson);
		return "/stp/hana/techStatistics/org_list";
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

		String firstApplyUser = sysUserInfo.getUserDisp();
		String attachmentDoc = IdUtil.createFileIdByTime();

		Map<String, String> map = EquipmentUtils.getDepartInfoBySysUser(sysUserInfo, restTemplate, httpHeaders);
		String unitName = map.get("unitName");// 申报单位
		String parentUnitPathIds = map.get("unitCode");// 申报单位
		String applyDepartName = map.get("applyDepartName");// 申报部门
		String applyDepartCode = map.get("applyDepartCode");// 申报部门


		String id = CommonUtil.getParameter(request, "id", "");
		request.setAttribute("id", id);
		if (!id.equals("")) {
			ResponseEntity<TechOrgCount> responseEntity = this.restTemplate.exchange(GET_ORG_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), TechOrgCount.class);
			int statusCode = responseEntity.getStatusCodeValue();
			logger.info("============远程返回  statusCode " + statusCode);
			TechOrgCount techOrgCount = responseEntity.getBody();
			applyDepartName = techOrgCount.getUnitName();
		}

		request.setAttribute("applyDepartName", applyDepartName);
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
		String name = CommonUtil.getParameter(request, "name", "");
		// 业务ID
		String id = CommonUtil.getParameter(request, "id", "");
		String firstApplyUser = CommonUtil.getParameter(request, "firstApplyUser", "");
		String specialNotes = CommonUtil.getParameter(request, "specialNotes", "");
		String notes = CommonUtil.getParameter(request, "notes", "");
		String applyAcount = CommonUtil.getParameter(request, "applyAcount", "");
		String type = CommonUtil.getParameter(request, "type", "");

		String unitPrice = CommonUtil.getParameter(request, "unitPrice", "");
		String attachmentDoc = CommonUtil.getParameter(request, "attachmentDoc", "");
		String specification = CommonUtil.getParameter(request, "specification", "");
		String voteCount = CommonUtil.getParameter(request, "voteCount", "1");
		String supplierWillStr = CommonUtil.getParameter(request, "supplierWillStr", "");
		String supplierStr = CommonUtil.getParameter(request, "supplierStr", "");
		String erpNo = CommonUtil.getParameter(request, "erpNo", "");

		String applyDepartName = CommonUtil.getParameter(request, "applyDepartName", "");
		String applyDepartCode = CommonUtil.getParameter(request, "applyDepartCode", "");
		String originPlace = CommonUtil.getParameter(request, "originPlace", "");

		String unitPathNames = CommonUtil.getParameter(request, "unitPathNames", "");
		String unitPathIds = CommonUtil.getParameter(request, "unitPathIds", "");
		
		

		String parentUnitPathIds = CommonUtil.getParameter(request, "parentUnitPathIds", "");
		String achievementsCompanyCount = CommonUtil.getParameter(request, "achievementsCompanyCount", "");

		// 流程状态-是保存还是提交
		String auditStatus = CommonUtil.getParameter(request, "auditStatus", Constant.AUDIT_STATUS_DRAFT);
		String userIds = CommonUtil.getParameter(request, "userIds", "");
		TechOrgCount techOrgCount = null;
		ResponseEntity<String> responseEntity = null;
		// 判断是新增还是修改
		if (id.equals("")) {
			techOrgCount = new TechOrgCount();
			techOrgCount.setCreateDate(new Date());
			techOrgCount.setCreateUserId(sysUserInfo.getUserName());
			String code = CommonUtil.getTableCode("XTBM_0016", restTemplate, httpHeaders);
			String idv = UUID.randomUUID().toString().replaceAll("-", "");
			techOrgCount.setId(idv); 
			System.out.println("---------------applyDepartCode:" + applyDepartCode + " applyDepartCode=" + applyDepartCode + " UserId=" + sysUserInfo.getUserId());

		} else {
			ResponseEntity<TechOrgCount> se = this.restTemplate.exchange(GET_ORG_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), TechOrgCount.class);
			techOrgCount  = se.getBody();
		}
		// 流程状态
		techOrgCount.setAchievementsCompanyCount(Integer.valueOf(achievementsCompanyCount));
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
		TechOrgCount TechOrgCount = responseEntity.getBody();
		request.setAttribute("TechOrgCount", TechOrgCount);
		return "/stp/equipment/equipment/equipment-view";
	}
	
	
	@RequestMapping(value = "/start_org_workflow")
	@ResponseBody
	public Object start_org_workflow(HttpServletRequest request, HttpServletResponse response) throws Exception {

		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);// 设置参数类型和编码
		String id = CommonUtil.getParameter(request, "id", "");
		String functionId = CommonUtil.getParameter(request, "functionId", "");
		String userIds = CommonUtil.getParameter(request, "userIds", "");
		SreProject sreProject = EquipmentUtils.getSreProject(id, restTemplate, httpHeaders);
		System.out.println(
				"============start_org_workflow userIds=" + userIds + " functionId=" + functionId + " id=" + id);
		String specialAuditor0 = EquipmentUtils
				.getTaskSpecialAuditor0ByProfessionalDepartName(sreProject.getProfessionalDepartName());
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("functionId", functionId);
		paramMap.put("processInstanceName", "科研机构调查表统计->" + sreProject.getName());
		paramMap.put("authenticatedUserId", sysUserInfo.getUserId());
		paramMap.put("authenticatedUserName", sysUserInfo.getUserDisp());
		paramMap.put("functionId", functionId);
		paramMap.put("auditor", userIds);
		paramMap.put("specialAuditor0", specialAuditor0);
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap, this.httpHeaders);
		Result rs = this.restTemplate
				.exchange(ORG_WORKFLOW_URL + id, HttpMethod.POST, httpEntity, Result.class).getBody();
		return rs;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	@RequestMapping(value = "/tech_cost/to-list")
	public String tech_cost(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String unitPathIds = sysUserInfo.getUnitPath();
		String parentUnitPathIds = EquipmentUtils.getEquipmentUnitCode(sysUserInfo, restTemplate, httpHeaders);
		request.setAttribute("parentUnitPathIds", parentUnitPathIds);
		boolean isKJBPerson = EquipmentUtils.isKJBPerson(unitPathIds);
		request.setAttribute("isKJBPerson", isKJBPerson);
		return "/stp/hana/techStatistics/cost_list";
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

		String firstApplyUser = sysUserInfo.getUserDisp();
		String attachmentDoc = IdUtil.createFileIdByTime();

		Map<String, String> map = EquipmentUtils.getDepartInfoBySysUser(sysUserInfo, restTemplate, httpHeaders);
		String unitName = map.get("unitName");// 申报单位
		String parentUnitPathIds = map.get("unitCode");// 申报单位
		String applyDepartName = map.get("applyDepartName");// 申报部门
		String applyDepartCode = map.get("applyDepartCode");// 申报部门


		String id = CommonUtil.getParameter(request, "id", "");
		request.setAttribute("id", id);
		if (!id.equals("")) {
			ResponseEntity<TechCost> responseEntity = this.restTemplate.exchange(GET_COST_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), TechCost.class);
			int statusCode = responseEntity.getStatusCodeValue();
			logger.info("============远程返回  statusCode " + statusCode);
			TechCost TechCost = responseEntity.getBody();
			applyDepartName = TechCost.getUnitName();
		}

		request.setAttribute("applyDepartName", applyDepartName);
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
		String name = CommonUtil.getParameter(request, "name", "");
		// 业务ID
		String id = CommonUtil.getParameter(request, "id", "");
		String firstApplyUser = CommonUtil.getParameter(request, "firstApplyUser", "");
		String specialNotes = CommonUtil.getParameter(request, "specialNotes", "");
		String notes = CommonUtil.getParameter(request, "notes", "");
		String applyAcount = CommonUtil.getParameter(request, "applyAcount", "");
		String type = CommonUtil.getParameter(request, "type", "");

		String unitPrice = CommonUtil.getParameter(request, "unitPrice", "");
		String attachmentDoc = CommonUtil.getParameter(request, "attachmentDoc", "");
		String specification = CommonUtil.getParameter(request, "specification", "");
		String voteCount = CommonUtil.getParameter(request, "voteCount", "1");
		String supplierWillStr = CommonUtil.getParameter(request, "supplierWillStr", "");
		String supplierStr = CommonUtil.getParameter(request, "supplierStr", "");
		String erpNo = CommonUtil.getParameter(request, "erpNo", "");

		String applyDepartName = CommonUtil.getParameter(request, "applyDepartName", "");
		String applyDepartCode = CommonUtil.getParameter(request, "applyDepartCode", "");
		String originPlace = CommonUtil.getParameter(request, "originPlace", "");

		String unitPathNames = CommonUtil.getParameter(request, "unitPathNames", "");
		String chargeDepartMan = CommonUtil.getParameter(request, "chargeDepartMan", "");
		
		

		String parentUnitPathIds = CommonUtil.getParameter(request, "parentUnitPathIds", "");
		String achievementsCompanyCount = CommonUtil.getParameter(request, "achievementsCompanyCount", "");

		// 流程状态-是保存还是提交
		String auditStatus = CommonUtil.getParameter(request, "auditStatus", Constant.AUDIT_STATUS_DRAFT);
		String userIds = CommonUtil.getParameter(request, "userIds", "");
		TechCost techCost = null;
		ResponseEntity<String> responseEntity = null;
		// 判断是新增还是修改
		if (id.equals("")) {
			techCost = new TechCost();
			techCost.setCreateDate(new Date());
			techCost.setCreateUserId(sysUserInfo.getUserName());
			String code = CommonUtil.getTableCode("XTBM_0016", restTemplate, httpHeaders);
			String idv = UUID.randomUUID().toString().replaceAll("-", "");
			techCost.setId(idv); 
			System.out.println("---------------applyDepartCode:" + applyDepartCode + " applyDepartCode=" + applyDepartCode + " UserId=" + sysUserInfo.getUserId());

		} else {
			ResponseEntity<TechCost> se = this.restTemplate.exchange(GET_ORG_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), TechCost.class);
			techCost  = se.getBody();
		}
		// 流程状态
		techCost.setChargeDepartMan(chargeDepartMan); 
		// 判断是新增还是修改
		if (id.equals("")) {
			responseEntity = this.restTemplate.exchange(ADD_COST_URL, HttpMethod.POST, new HttpEntity<TechCost>(techCost, this.httpHeaders), String.class);

		} else {
			responseEntity = this.restTemplate.exchange(UPDATE_COST_URL, HttpMethod.POST, new HttpEntity<TechCost>(techCost, this.httpHeaders), String.class);
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
		TechCost TechCost = responseEntity.getBody();
		request.setAttribute("TechCost", TechCost);
		return "/stp/equipment/equipment/equipment-view";
	}
	
	
	@RequestMapping(value = "/start_cost_workflow")
	@ResponseBody
	public Object start_cost_workflow(HttpServletRequest request, HttpServletResponse response) throws Exception {

		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);// 设置参数类型和编码
		String id = CommonUtil.getParameter(request, "id", "");
		String functionId = CommonUtil.getParameter(request, "functionId", "");
		String userIds = CommonUtil.getParameter(request, "userIds", "");
		SreProject sreProject = EquipmentUtils.getSreProject(id, restTemplate, httpHeaders);
		System.out.println(
				"============start_cost_workflow userIds=" + userIds + " functionId=" + functionId + " id=" + id);
		String specialAuditor0 = EquipmentUtils
				.getTaskSpecialAuditor0ByProfessionalDepartName(sreProject.getProfessionalDepartName());
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("functionId", functionId);
		paramMap.put("processInstanceName", "科研投入统计->" + sreProject.getName());
		paramMap.put("authenticatedUserId", sysUserInfo.getUserId());
		paramMap.put("authenticatedUserName", sysUserInfo.getUserDisp());
		paramMap.put("functionId", functionId);
		paramMap.put("auditor", userIds);
		paramMap.put("specialAuditor0", specialAuditor0);
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap, this.httpHeaders);
		Result rs = this.restTemplate
				.exchange(COST_WORKFLOW_URL + id, HttpMethod.POST, httpEntity, Result.class).getBody();
		return rs;
	}
	
	
	
	
	
	
	
	
	

}
