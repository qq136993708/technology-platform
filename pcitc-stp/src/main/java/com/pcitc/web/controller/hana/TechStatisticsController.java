package com.pcitc.web.controller.hana;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.time.DateFormatUtils;
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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.ExcelException;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.RequestProcessStatusEnum;
import com.pcitc.base.hana.report.ScientificInvestment;
import com.pcitc.base.stp.report.TechCost;
import com.pcitc.base.stp.report.TechOrgCount;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.system.SysUnit;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;
import com.pcitc.web.utils.HanaUtil;
import com.pcitc.web.utils.PoiExcelExportUitl;

@Controller
public class TechStatisticsController extends BaseController{
	
	private static final String LIST_ORG_URL =   "http://pcitc-zuul/stp-proxy/sre-provider/techOrgCount/list";
	private static final String PAGE_ORG_URL =   "http://pcitc-zuul/stp-proxy/sre-provider/techOrgCount/page";
	private static final String PAGE_ORG_STATISTICS_URL =   "http://pcitc-zuul/stp-proxy/sre-provider/techOrgCount/statistics_page";
	public static final String  ADD_ORG_URL =    "http://pcitc-zuul/stp-proxy/sre-provider/techOrgCount/add";
	public static final String  UPDATE_ORG_URL = "http://pcitc-zuul/stp-proxy/sre-provider/techOrgCount/update";
	private static final String DEL_ORG_URL =    "http://pcitc-zuul/stp-proxy/sre-provider/techOrgCount/delete/";
	public static final String GET_ORG_URL =     "http://pcitc-zuul/stp-proxy/sre-provider/techOrgCount/get/";
	private static final String ORG_WORKFLOW_URL = "http://pcitc-zuul/stp-proxy/sre-provider/techOrgCount/start_org_activity/";
	
	
	private static final String PAGE_COST_URL =   "http://pcitc-zuul/stp-proxy/sre-provider/techCost/page";
	private static final String PAGE_COST_STATISTICS_URL =   "http://pcitc-zuul/stp-proxy/sre-provider/techCost/statistics_page";
	public static final String  ADD_COST_URL =    "http://pcitc-zuul/stp-proxy/sre-provider/techCost/add";
	public static final String  UPDATE_COST_URL = "http://pcitc-zuul/stp-proxy/sre-provider/techCost/update";
	private static final String DEL_COST_URL =    "http://pcitc-zuul/stp-proxy/sre-provider/techCost/delete/";
	public static final String   GET_COST_URL =   "http://pcitc-zuul/stp-proxy/sre-provider/techCost/get/";
	private static final String COST_WORKFLOW_URL = "http://pcitc-zuul/stp-proxy/sre-provider/techCost/start_cost_activity/";
	private static final String LIST_COST_URL =   "http://pcitc-zuul/stp-proxy/sre-provider/techCost/list";
	

	
	@RequestMapping(value = "/tech_cost/to-list")
	public String tech_cost(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
	
	
	
	@RequestMapping(value = "/tech_cost/statistics_list")
	@ResponseBody
	public String statistics_list(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {

		
		JSONObject paramresult = JSONObject.parseObject(JSONObject.toJSONString(param));
		logger.info("============参数：" + paramresult.toString());
		
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PAGE_COST_STATISTICS_URL, HttpMethod.POST, entity, LayuiTableData.class);
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
	
	@RequestMapping(method = RequestMethod.GET, value = "/tech_cost/exput_excel")
	@ResponseBody
	public String tech_cost_exput_excel(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		
    	
		 
		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);//设置参数类型和编码
		String unitName = CommonUtil.getParameter(request, "unitName", "" );
		String auditStatus = CommonUtil.getParameter(request, "auditStatus", "");
		String year = CommonUtil.getParameter(request, "year", "");
		String type = CommonUtil.getParameter(request, "type", "");
		
		Map<String ,Object> paramMap = new HashMap<String ,Object>();
		paramMap.put("unitName", unitName);
		paramMap.put("auditStatus", auditStatus);
		paramMap.put("year", year);
		paramMap.put("type", type);
		System.out.println(">exput_excel>>>>>>>>>>>>>>>>>>>>参数      type = "+type+" year="+year);
		
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(LIST_COST_URL, HttpMethod.POST, httpEntity, JSONArray.class);
		int statusCode = responseEntity.getStatusCodeValue();
		List<ScientificInvestment> list =new ArrayList();
		JSONArray jSONArray=null;
		if (statusCode == 200)
		{
			jSONArray = responseEntity.getBody();
			list = JSONObject.parseArray(jSONArray.toJSONString(), ScientificInvestment.class);
			
			/*for(int i=0;i<list.size();i++)
			{
				ScientificInvestment scientificInvestment=list.get(i);
				System.out.println(">>>>>>>>>>>>>>>>>>>>>参数      getG0GSJC = "+scientificInvestment.getG0GSJC());
			}*/
		}
		
		
		    String[] headers = { "院所", "计划总投资", "累计支出额",       "预付余额",     "累计投资完成额", "项目资金计划结余",     "本年投资计划",         "本年累计支出"   , "本年预付款", "本年投资完成额"};
		    String[] cols =    {"g0GSJC","k0ZTYSJE","k0LJGLFPHJECB","k0LJSJDJJE","aDD1",       "k0LJYSJY",       "k0BNYSJHJE",       "k0BNGLFPHJECB","k0BNSJDJJE","k0BNSJDJJE"};
	        // 文件名默认设置为当前时间：年月日时分秒
	        String fileName = DateFormatUtils.format(new Date(), "yyyyMMddhhmmss");
	        // 设置response头信息
	        response.reset();
	        response.setContentType("application/vnd.ms-excel");
	        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xls");
	        try {
		        OutputStream os = response.getOutputStream();
		        PoiExcelExportUitl<ScientificInvestment>  pee = new PoiExcelExportUitl<ScientificInvestment>(fileName, headers, cols, list,os);
		        pee.exportExcel();
	            
	        } catch (Exception e)
	        {
	            e.printStackTrace();
	            // 如果是ExcelException,则直接抛出
	            if (e instanceof ExcelException) 
	            {
	                throw (ExcelException) e;
	            } else 
	            {
	                // 否则将其他异常包装成ExcelException再抛出
	                throw new ExcelException("导出excel失败");
	            }
	        }
		   return null;
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

		String year =HanaUtil.getCurrentYear(); 
		
		String unitName = sysUserInfo.getUnitName();// 申报部门
		String unitCode = sysUserInfo.getUnitCode();// 申报部门
		
		String type = CommonUtil.getParameter(request, "type", "");
		request.setAttribute("type", type);

		String id = CommonUtil.getParameter(request, "id", "");
		request.setAttribute("id", id);
		if (!id.equals("")) {
			ResponseEntity<TechCost> responseEntity = this.restTemplate.exchange(GET_COST_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), TechCost.class);
			int statusCode = responseEntity.getStatusCodeValue();
			logger.info("============远程返回  statusCode " + statusCode);
			TechCost techCost = responseEntity.getBody();
			attachmentDoc = techCost.getAttachmentDoc();
			request.setAttribute("techCost", techCost);
			year=techCost.getYear();
			//unitName = techCost.getUnitName();
			//unitCode = techCost.getUnitCode();
			//unitName = techCost.getUnitName();
			//unitCode = techCost.getUnitCode();
			
		}
		request.setAttribute("year", year);
		request.setAttribute("attachmentDoc", attachmentDoc);
		request.setAttribute("createUserName", createUserName);
		request.setAttribute("unitName", unitName);
		request.setAttribute("unitCode", unitCode);
		//request.setAttribute("unitName", unitName);
		//request.setAttribute("unitCode", unitCode);
		request.setAttribute("allUnitName", unitName);
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
		
		String countryLeadCount = CommonUtil.getParameter(request, "countryLeadCount", "");
		String countryJoinCount = CommonUtil.getParameter(request, "countryJoinCount", "");
		String chargeDepartMan = CommonUtil.getParameter(request, "chargeDepartMan", "");
		String provinceFunds = CommonUtil.getParameter(request, "provinceFunds", "");
		String countryFunds = CommonUtil.getParameter(request, "countryFunds", "");
		String techSubtotalCost = CommonUtil.getParameter(request, "techSubtotalCost", "");
		String unitCode = CommonUtil.getParameter(request, "unitCode", "");//其实是UnitId的值
		String unitName = CommonUtil.getParameter(request, "unitName", "");
		String attachmentDoc = CommonUtil.getParameter(request, "attachmentDoc", "");
		String year = CommonUtil.getParameter(request, "year", "");
		String createUserName = CommonUtil.getParameter(request, "createUserName", "");
		String writeType = CommonUtil.getParameter(request, "writeType", "1");
		System.out.println("--------封装前-------unitCode:" + unitCode + " unitName=" + unitName );

		//UnitId-->unitCode
		String parentUnitCode="";
		String parentUnitName="";
		if(!unitCode.equals(""))
		{
			//SysUnit sysUnit=EquipmentUtils.getUnitByUnitId(unitCode, restTemplate, httpHeaders);
			//unitCode=sysUnit.getUnitCode();
			SysUnit sysUnit=EquipmentUtils.getUnitByUnitCode(unitCode, restTemplate, httpHeaders);
			String unitPath=sysUnit.getUnitPath();
			if(unitPath.length()>4)
			{
				String	parentUnitPath=unitPath.substring(0, unitPath.length()-4);
				SysUnit parenSysUnit=EquipmentUtils.getUnitByUnitPath(parentUnitPath, restTemplate, httpHeaders);
				parentUnitCode=parenSysUnit.getUnitCode();
				parentUnitName=parenSysUnit.getUnitName();
			}
			
		}
		System.out.println("--------封装前---------parentUnitName:" + parentUnitName + " parentUnitCode=" + parentUnitCode + " UserId=" + sysUserInfo.getUserId());

		// 流程状态-是保存还是提交
		String auditStatus = CommonUtil.getParameter(request, "auditStatus", Constant.AUDIT_STATUS_DRAFT);
		TechCost techCost = null;
		ResponseEntity<String> responseEntity = null;
		// 判断是新增还是修改
		if (id.equals("")) {
			techCost = new TechCost();
			techCost.setCreateDate(new Date());
			String idv = UUID.randomUUID().toString().replaceAll("-", "");
			techCost.setId(idv); 
			techCost.setAuditStatus(auditStatus);
		} else {
			ResponseEntity<TechCost> se = this.restTemplate.exchange(GET_COST_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), TechCost.class);
			techCost  = se.getBody();
		}
		techCost.setWriteType(writeType);
		techCost.setCreateUserId(sysUserInfo.getUserName());
		techCost.setCreateUserName(createUserName);
		techCost.setAttachmentDoc(attachmentDoc);
		// 流程状态
		techCost.setYear(year);
		techCost.setChargeDepartMan(chargeDepartMan); 
		techCost.setParentUnitCode(parentUnitCode); 
		techCost.setParentUnitName(parentUnitName);
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
	
	
	
	@RequestMapping(value = "/tech_org/statistics_list")
	@ResponseBody
	public String tech_org_statistics_list(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {

		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PAGE_ORG_STATISTICS_URL, HttpMethod.POST, entity, LayuiTableData.class);
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

		String unitName = sysUserInfo.getUnitName();// 申报部门
		String unitCode = sysUserInfo.getUnitCode();// 申报部门
		String year =HanaUtil.getCurrentYear(); 
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
			year=techOrgCount.getYear();
			attachmentDoc= techOrgCount.getAttachmentDoc();
		}
		request.setAttribute("year", year);
		request.setAttribute("attachmentDoc", attachmentDoc);
		request.setAttribute("createUserName", createUserName);
		request.setAttribute("unitName", unitName);
		request.setAttribute("unitCode", unitCode);
		request.setAttribute("allUnitName", unitName);
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
	public String saveOrUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		Result resultsDate = new Result();
		String achievementsCompanyCount = CommonUtil.getParameter(request, "achievementsCompanyCount", "0");
		// 业务ID
		String id = CommonUtil.getParameter(request, "id", "");
		String achievementsCountryCount = CommonUtil.getParameter(request, "achievementsCountryCount", "0");
		String allPatentCount = CommonUtil.getParameter(request, "allPatentCount", "0");
		String notes = CommonUtil.getParameter(request, "notes", "");
		String assetsTotal = CommonUtil.getParameter(request, "assetsTotal", "");
		String type = CommonUtil.getParameter(request, "type", "");
		String assistResearcherCount = CommonUtil.getParameter(request, "assistResearcherCount", "0");
		String chargeDepartMan = CommonUtil.getParameter(request, "chargeDepartMan", "");
		String countryInvestCost = CommonUtil.getParameter(request, "countryInvestCost", "");
		String outInvestCost = CommonUtil.getParameter(request, "outInvestCost", "0");
		String createUserMobile = CommonUtil.getParameter(request, "createUserMobile", "");
		String femaleCount = CommonUtil.getParameter(request, "femaleCount", "0");
		String directResearcherCount = CommonUtil.getParameter(request, "directResearcherCount", "0");
		String diplomaMasterCount = CommonUtil.getParameter(request, "diplomaMasterCount", "0");
		String currentYearPatentCount = CommonUtil.getParameter(request, "currentYearPatentCount", "0");
		String currentPatentLookCount = CommonUtil.getParameter(request, "currentPatentLookCount", "0");
		String diplomaUndergraduateCount = CommonUtil.getParameter(request, "diplomaUndergraduateCount", "0");
		String diplomaDoctorCount = CommonUtil.getParameter(request, "diplomaDoctorCount", "");
		String auditStatus = CommonUtil.getParameter(request, "auditStatus", Constant.AUDIT_STATUS_DRAFT);
		String deviceAssets = CommonUtil.getParameter(request, "deviceAssets", "");
		String researcherCount = CommonUtil.getParameter(request, "researcherCount", "0");
		String techChargeMan = CommonUtil.getParameter(request, "techChargeMan", "");
		String thesisAllCount = CommonUtil.getParameter(request, "thesisAllCount", "0");
		String thesisEiCount = CommonUtil.getParameter(request, "thesisEiCount", "0");
		String thesisIsrCount = CommonUtil.getParameter(request, "thesisIsrCount", "0");
		String thesisIstpCount = CommonUtil.getParameter(request, "thesisIstpCount", "0");
		String thesisSciCount = CommonUtil.getParameter(request, "thesisSciCount", "0");
		String titleLowerCount = CommonUtil.getParameter(request, "titleLowerCount", "0");
		String titleMiddleCount = CommonUtil.getParameter(request, "titleMiddleCount", "0");
		String titleSeniorCount = CommonUtil.getParameter(request, "titleSeniorCount", "0");
		String totaIncome = CommonUtil.getParameter(request, "totaIncome", "");
		String unitCode = CommonUtil.getParameter(request, "unitCode", "");
		String unitName = CommonUtil.getParameter(request, "unitName", "");
		String workerSalary = CommonUtil.getParameter(request, "workerSalary", "");
		String workersCount = CommonUtil.getParameter(request, "workersCount", "0");
		String fixedAssets = CommonUtil.getParameter(request, "fixedAssets", "");
		String groupInvestCost = CommonUtil.getParameter(request, "groupInvestCost", "0");
		String attachmentDoc = CommonUtil.getParameter(request, "attachmentDoc", "");
		String specialistCountryCount = CommonUtil.getParameter(request, "specialistCountryCount", "0");
		String specialistProvinceCount = CommonUtil.getParameter(request, "specialistProvinceCount", "0");
		String subInvestCost = CommonUtil.getParameter(request, "subInvestCost", "0");
		String allPatentLookCount = CommonUtil.getParameter(request, "allPatentLookCount", "0");
		String achievementsPrivanceCount = CommonUtil.getParameter(request, "achievementsPrivanceCount", "0");
		String year = CommonUtil.getParameter(request, "year", "");
		String createUserName = CommonUtil.getParameter(request, "createUserName", "");
		String thesisEiInnerCount = CommonUtil.getParameter(request, "thesisEiInnerCount", "0");
		String thesisSciInnerCount = CommonUtil.getParameter(request, "thesisSciInnerCount", "0");
		String deviceInnnerAssets = CommonUtil.getParameter(request, "deviceInnnerAssets", "0");
		String writeType = CommonUtil.getParameter(request, "writeType", "1");
		
		String parentUnitCode="";
		String parentUnitName="";
		if(!unitCode.equals(""))
		{
			//SysUnit sysUnit=EquipmentUtils.getUnitByUnitId(unitCode, restTemplate, httpHeaders);
			//unitCode=sysUnit.getUnitCode();
			SysUnit sysUnit=EquipmentUtils.getUnitByUnitCode(unitCode, restTemplate, httpHeaders);
			String unitPath=sysUnit.getUnitPath();
			if(unitPath.length()>4)
			{
				String	parentUnitPath=unitPath.substring(0, unitPath.length()-4);
				SysUnit parenSysUnit=EquipmentUtils.getUnitByUnitPath(parentUnitPath, restTemplate, httpHeaders);
				parentUnitCode=parenSysUnit.getUnitCode();
				parentUnitName=parenSysUnit.getUnitName();
			}
			
		}
		
		TechOrgCount techOrgCount = null;
		ResponseEntity<String> responseEntity = null;
		// 判断是新增还是修改
		if (id.equals("")) {
			techOrgCount = new TechOrgCount();
			techOrgCount.setCreateDate(new Date());
			
			String idv = UUID.randomUUID().toString().replaceAll("-", "");
			techOrgCount.setId(idv); 
			techOrgCount.setAuditStatus(auditStatus);
			
		} else {
			ResponseEntity<TechOrgCount> se = this.restTemplate.exchange(GET_ORG_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), TechOrgCount.class);
			techOrgCount  = se.getBody();
		}
		
		System.out.println("---------------parentUnitName:" + parentUnitName + " parentUnitCode=" + parentUnitCode + " UserId=" + sysUserInfo.getUserId());
		techOrgCount.setWriteType(writeType);
		techOrgCount.setThesisEiInnerCount(Integer.valueOf(thesisEiInnerCount));
		techOrgCount.setThesisSciInnerCount(Integer.valueOf(thesisSciInnerCount));
		techOrgCount.setCreateUserId(sysUserInfo.getUserName());
		techOrgCount.setCreateUserName(createUserName);
		techOrgCount.setYear(year);
		techOrgCount.setAttachmentDoc(attachmentDoc);
		techOrgCount.setAchievementsCompanyCount(Integer.valueOf(achievementsCompanyCount));
		techOrgCount.setAchievementsCompanyCount(Integer.valueOf(achievementsCompanyCount));
		techOrgCount.setAchievementsCountryCount(Integer.valueOf(achievementsCountryCount));
		techOrgCount.setAllPatentCount(Integer.valueOf(allPatentCount));
		techOrgCount.setParentUnitCode(parentUnitCode); 
		techOrgCount.setParentUnitName(parentUnitName);
		techOrgCount.setAssetsTotal(new BigDecimal(assetsTotal));
		techOrgCount.setAssistResearcherCount(Integer.valueOf(assistResearcherCount));
		techOrgCount.setChargeDepartMan(chargeDepartMan);
		techOrgCount.setCountryInvestCost(new BigDecimal(countryInvestCost));
		techOrgCount.setCreateUserMobile(createUserMobile);
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
		techOrgCount.setDeviceInnnerAssets(new BigDecimal(deviceInnnerAssets));
		
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

	
	@RequestMapping(method = RequestMethod.GET, value = "/tech_org/exput_excel")
	@ResponseBody
	public String exput_excel(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		
    	
		 
		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);//设置参数类型和编码
		String unitName = CommonUtil.getParameter(request, "unitName", "" );
		String auditStatus = CommonUtil.getParameter(request, "auditStatus", "");
		String year = CommonUtil.getParameter(request, "year", "");
		String type = CommonUtil.getParameter(request, "type", "");
		
		Map<String ,Object> paramMap = new HashMap<String ,Object>();
		paramMap.put("unitName", unitName);
		paramMap.put("auditStatus", auditStatus);
		paramMap.put("year", year);
		paramMap.put("type", type);
		System.out.println(">exput_excel>>>>>>>>>>>>>>>>>>>>参数      type = "+type+" year="+year);
		
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(LIST_ORG_URL, HttpMethod.POST, httpEntity, JSONArray.class);
		int statusCode = responseEntity.getStatusCodeValue();
		List<ScientificInvestment> list =new ArrayList();
		JSONArray jSONArray=null;
		if (statusCode == 200)
		{
			jSONArray = responseEntity.getBody();
			list = JSONObject.parseArray(jSONArray.toJSONString(), ScientificInvestment.class);
			
			/*for(int i=0;i<list.size();i++)
			{
				ScientificInvestment scientificInvestment=list.get(i);
				System.out.println(">>>>>>>>>>>>>>>>>>>>>参数      getG0GSJC = "+scientificInvestment.getG0GSJC());
			}*/
		}
		
		
		    String[] headers = { "院所", "计划总投资", "累计支出额",       "预付余额",     "累计投资完成额", "项目资金计划结余",     "本年投资计划",         "本年累计支出"   , "本年预付款", "本年投资完成额"};
		    String[] cols =    {"g0GSJC","k0ZTYSJE","k0LJGLFPHJECB","k0LJSJDJJE","aDD1",       "k0LJYSJY",       "k0BNYSJHJE",       "k0BNGLFPHJECB","k0BNSJDJJE","k0BNSJDJJE"};
		   
	        // 文件名默认设置为当前时间：年月日时分秒
	        String fileName = DateFormatUtils.format(new Date(), "yyyyMMddhhmmss");
	        // 设置response头信息
	        response.reset();
	        response.setContentType("application/vnd.ms-excel");
	        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xls");
	        try {
		        OutputStream os = response.getOutputStream();
		        PoiExcelExportUitl<ScientificInvestment>  pee = new PoiExcelExportUitl<ScientificInvestment>(fileName, headers, cols, list,os);
		        pee.exportExcel();
	            
	        } catch (Exception e)
	        {
	            e.printStackTrace();
	            // 如果是ExcelException,则直接抛出
	            if (e instanceof ExcelException) 
	            {
	                throw (ExcelException) e;
	            } else 
	            {
	                // 否则将其他异常包装成ExcelException再抛出
	                throw new ExcelException("导出excel失败");
	            }
	        }
		   return null;
	}
	
	

	@RequestMapping(method = RequestMethod.GET, value = "/unit_select_radio")
	public Object unit_select_radio(HttpServletRequest request) throws IOException 
	{
		request.setAttribute("company", request.getParameter("company"));
		
		return "/stp/hana/techStatistics/unit_select_radio";
	}
	
	

}
