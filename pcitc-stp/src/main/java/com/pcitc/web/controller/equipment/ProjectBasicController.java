package com.pcitc.web.controller.equipment;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.RequestProcessStatusEnum;
import com.pcitc.base.stp.equipment.SreEquipment;
import com.pcitc.base.stp.equipment.SreProject;
import com.pcitc.base.stp.equipment.UnitField;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.system.SysUnit;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.workflow.Constants;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;

@Controller
@RequestMapping(value = "/sre-project-basic")
public class ProjectBasicController extends BaseController {

	/*
	 * 1、可以直接通过注册的服务名来访问，来实现访问和负载。不过如果用zuul的话， 要用zuul的服务名和实际访问的服务名一起
	 * 2、pplus本身是一个微服务，属于微服务之间的调用，可以直接用名称，不用ip.（注意启动类中的注解）
	 */

	private static final String PAGE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/project_basic/page";
	private static final String ADD_URL = "http://pcitc-zuul/stp-proxy/sre-provider/project_basic/add";
	private static final String UPDATE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/project_basic/update";
	private static final String DEL_URL = "http://pcitc-zuul/stp-proxy/sre-provider/project_basic/delete/";
	private static final String BATCH_DEL_URL = "http://pcitc-zuul/stp-proxy/sre-provider/project_basic/batch-delete/";
	private static final String GET_URL = "http://pcitc-zuul/stp-proxy/sre-provider/project_basic/get/";

	
	
	private static final String EQUIPMENT_PROJECT_WORKFLOW_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project_basic/start_project_activity/";


	@RequestMapping(value = "/to-list")
	public String list(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		List<UnitField>  unitFieldList= CommonUtil.getUnitNameList(restTemplate, httpHeaders);
		request.setAttribute("unitFieldList", unitFieldList);
		//String applyUnitCode=sysUserInfo.getUnitCode();
		//request.setAttribute("applyUnitCode", applyUnitCode);
		
		

		String	parentUnitPathIds="";
		String unitPathIds =   sysUserInfo.getUnitPath();
		if(unitPathIds!=null && !unitPathIds.equals(""))
		{
			if(unitPathIds.length()>4)
			{
				parentUnitPathIds=unitPathIds.substring(0, unitPathIds.length()-4);
				
			}
		}
		request.setAttribute("parentUnitPathIds", parentUnitPathIds);
		
		return "/stp/equipment/project/project-basic-list";
	}

	@RequestMapping(value = "/list")
	@ResponseBody
	public String ajaxlist(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {
		
		
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============查询结果：" + result);
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
	@RequestMapping(value = "/add")
	public String add(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		
		
		String leadUnitName =  "";
		String leadUnitCode =  "";
		String joinUnitIds =  "";//参与单位IDS
		String unitPathIds =   sysUserInfo.getUnitPath();
		if(unitPathIds!=null && !unitPathIds.equals(""))
		{
			if(unitPathIds.length()>4)
			{
				String	parentUnitPathIds=unitPathIds.substring(0, unitPathIds.length()-4);
				SysUnit sysUnit=EquipmentUtils.getUnitByUnitPath(parentUnitPathIds, restTemplate, httpHeaders);
				if(sysUnit!=null)
				{
					leadUnitName = sysUnit.getUnitName();
					leadUnitCode =sysUnit.getUnitCode();
				}
			}
		}
		
		
		String createUserName=sysUserInfo.getUserDisp();
		String createUserId=sysUserInfo.getUserName();
		String documentDoc= IdUtil.createFileIdByTime();
		String beginYear=EquipmentUtils.getCurrrentYear();
		String endYear=String.valueOf(Integer.valueOf(beginYear).intValue()+1);
		String id = CommonUtil.getParameter(request, "id", "");
		request.setAttribute("id", id);
		if(!id.equals(""))
		{
			ResponseEntity<SreProject> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreProject.class);
			int statusCode = responseEntity.getStatusCodeValue();
		
			SreProject sreEquipment = responseEntity.getBody();
			request.setAttribute("sreProjectBasic", sreEquipment);
			
			leadUnitName = sreEquipment.getLeadUnitName();
			leadUnitCode = sreEquipment.getLeadUnitCode();
			createUserId= sreEquipment.getCreateUserId();
			documentDoc=sreEquipment.getDocumentDoc();
			beginYear		= sreEquipment.getBeginYear();
			endYear		= sreEquipment.getEndYear();
			joinUnitIds=sreEquipment.getJoinUnitIds();
		}
		request.setAttribute("documentDoc", documentDoc);
		request.setAttribute("leadUnitName", leadUnitName);
		request.setAttribute("leadUnitCode", leadUnitCode);
		request.setAttribute("createUserId", createUserId);
		request.setAttribute("endYear", endYear);
		request.setAttribute("beginYear", beginYear);
		request.setAttribute("joinUnitIds", joinUnitIds);
		logger.info("============远程返回  beginYear " + beginYear);
		List<UnitField>  unitFieldList= CommonUtil.getUnitNameList(restTemplate, httpHeaders);
		request.setAttribute("unitFieldList", unitFieldList);
		
		
		
		
		
	
		
		return "/stp/equipment/project/project-basic-add";
	}
	
	
	
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/chooseProject")
	private String chooseProject(HttpServletRequest request) 
	{
		
		String taskWriteUsersIds=sysUserInfo.getUserId();
		request.setAttribute("taskWriteUsersIds",taskWriteUsersIds);
		String topicId = request.getParameter("topicId");
		request.setAttribute("topicId",topicId);
		return "/stp/equipment/task/chooseProject";
    }
	
	@RequestMapping(value = "/chooseProject_data")
	@ResponseBody
	public String chooseProject_data(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {
		
		
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============查询结果：" + result);
		return result.toString();
	}

	/**
	 * 保存-更新操作
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/save")
	@ResponseBody
	public String saveOrUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result resultsDate = dealSaveUpdate(request);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		out.println(ob.toString());
		out.flush();
		out.close();
		return null;
	}
	
	
	private Result dealSaveUpdate(HttpServletRequest request)throws Exception
	{
		
		Result resultsDate = new Result();
		String name = CommonUtil.getParameter(request, "name", "");
		// 业务ID
		String id = CommonUtil.getParameter(request, "id", "");
		// 流程状态-是保存还是提交
		String auditStatus = CommonUtil.getParameter(request, "auditStatus", Constant.AUDIT_STATUS_DRAFT);
		String userIds = CommonUtil.getParameter(request, "userIds", "");
		String equipmentIds = CommonUtil.getParameter(request, "equipmentIds", "");
		String remarks = CommonUtil.getParameter(request, "remarks", "");
		String beginYear = CommonUtil.getParameter(request, "beginYear", "");
		String endYear = CommonUtil.getParameter(request, "endYear", "");
		String projectType = CommonUtil.getParameter(request, "projectType", "");
		String keyWord = CommonUtil.getParameter(request, "keyWord", "");
		String projectLeader = CommonUtil.getParameter(request, "projectLeader", "");
		String erpNum = CommonUtil.getParameter(request, "erpNum", "");
		String documentDoc = CommonUtil.getParameter(request, "documentDoc", "");
		String joinUnitName = CommonUtil.getParameter(request, "joinUnitName", "");
		String joinUnitCode = CommonUtil.getParameter(request, "joinUnitCode", "");
		String leadLinkmansName = CommonUtil.getParameter(request, "leadLinkmansName", "");
		String leadLinkmansCode = CommonUtil.getParameter(request, "leadLinkmansCode", "");
		String leadUnitType = CommonUtil.getParameter(request, "leadUnitType", "");
		String professional = CommonUtil.getParameter(request, "professional", "");
		String projectChargesName = CommonUtil.getParameter(request, "projectChargesName", "");
		String projectChargesCode = CommonUtil.getParameter(request, "projectChargesCode", "");
		String contractNum = CommonUtil.getParameter(request, "contractNum", "");
		String setupYear = CommonUtil.getParameter(request, "setupYear", "");
		String leadUnitName = CommonUtil.getParameter(request, "leadUnitName", "");
		String leadUnitCode = CommonUtil.getParameter(request, "leadUnitCode", "");
		String entrustUnitCode = CommonUtil.getParameter(request, "entrustUnitCode", "");
		String entrustUnitName = CommonUtil.getParameter(request, "entrustUnitName", "");
		String isWorkFlow = CommonUtil.getParameter(request, "isWorkFlow", "0");
		String functionId = CommonUtil.getParameter(request, "functionId", "");
		String yearFeeStr = CommonUtil.getParameter(request, "yearFeeStr", "");
		
		String belongDepartmentName = CommonUtil.getParameter(request, "belongDepartmentName", "");
		String belongDepartmentCode = CommonUtil.getParameter(request, "belongDepartmentCode", "");
		String professionalDepartName = CommonUtil.getParameter(request, "professionalDepartName", "");
		String professionalDepartCode = CommonUtil.getParameter(request, "professionalDepartCode", "");
		String taskWriteUserNames = CommonUtil.getParameter(request, "taskWriteUserNames", "");
		String taskWriteUsersIds = CommonUtil.getParameter(request, "taskWriteUsersIds", "");
		String professionalFieldName = CommonUtil.getParameter(request, "professionalFieldName", "");
		String professionalFieldCode = CommonUtil.getParameter(request, "professionalFieldCode", "");
		String unitPathIds =   CommonUtil.getParameter(request, "unitPathIds",sysUserInfo.getUnitPath());
		String unitPathNames = CommonUtil.getParameter(request, "unitPathNames", sysUserInfo.getUnitName());
		String yearFeeStrJoinUnit = CommonUtil.getParameter(request, "yearFeeStrJoinUnit", "");
		String projectMoney = CommonUtil.getParameter(request, "projectMoney", "");
		String joinUnitIds = CommonUtil.getParameter(request, "joinUnitIds", "");
		
		String joinUnitParentNames="";
		String joinUnitParentCodes="";
		if(!joinUnitIds.equals(""))
		{
			Map map=EquipmentUtils.getJoinUnitParentNamesByUnitId(joinUnitIds, restTemplate, httpHeaders);
			joinUnitParentCodes=(String)map.get("joinUnitParentCodes");
			joinUnitParentNames=(String)map.get("joinUnitParentNames");
		}
		
		System.out.println("============joinUnitParentNames="+joinUnitParentNames+"     joinUnitIds="+joinUnitIds+" joinUnitCode="+joinUnitCode+" joinUnitParentCodes="+joinUnitParentCodes);
		String parentUnitPathIds ="";
		String parentUnitPathNames =  "";
		if(unitPathIds!=null && !unitPathIds.equals(""))
		{
			if(unitPathIds.length()>4)
			{
				parentUnitPathIds=unitPathIds.substring(0, unitPathIds.length()-4);
				SysUnit sysUnit=EquipmentUtils.getUnitByUnitPath(parentUnitPathIds, restTemplate, httpHeaders);
				if(sysUnit!=null)
				{
					parentUnitPathNames = sysUnit.getUnitName();
				}
			}
		}
		
		SreProject sreProjectBasic = null;
		ResponseEntity<String> responseEntity = null;
		// 判断是新增还是修改
		if (id.equals("")) 
		{
			sreProjectBasic = new SreProject();
			sreProjectBasic.setCreateDate(new Date());
			sreProjectBasic.setCreateUserId(sysUserInfo.getUserId());
			sreProjectBasic.setCreateUserName(sysUserInfo.getUserDisp());
			
			String idv = UUID.randomUUID().toString().replaceAll("-", "");
			sreProjectBasic.setId(idv);
			sreProjectBasic.setAuditStatus(auditStatus);
		} else 
		{
			ResponseEntity<SreProject> se = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreProject.class);
			sreProjectBasic = se.getBody();
		}
		// 流程状态
		sreProjectBasic.setJoinUnitParentCodes(joinUnitParentCodes);
		sreProjectBasic.setAuditStatus(auditStatus);
		sreProjectBasic.setJoinUnitParentNames(joinUnitParentNames);
		sreProjectBasic.setJoinUnitIds(joinUnitIds);
		sreProjectBasic.setProjectMoney(new BigDecimal(projectMoney));
		sreProjectBasic.setUnitPathIds(unitPathIds);
		sreProjectBasic.setUnitPathNames(unitPathNames);
		sreProjectBasic.setParentUnitPathIds(parentUnitPathIds); 
		sreProjectBasic.setParentUnitPathNames(parentUnitPathNames); 
		sreProjectBasic.setProfessionalFieldCode(professionalFieldCode);
		sreProjectBasic.setProfessionalFieldName(professionalFieldName);
		sreProjectBasic.setYearFeeStr(yearFeeStr); 
		sreProjectBasic.setDocumentDoc(documentDoc); 
		sreProjectBasic.setName(name);
		sreProjectBasic.setEquipmentIds(equipmentIds);
		sreProjectBasic.setSetupYear(DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
		sreProjectBasic.setRemarks(remarks);
		sreProjectBasic.setBeginYear(beginYear);
		sreProjectBasic.setEndYear(endYear);
		sreProjectBasic.setKeyWord(keyWord);
		sreProjectBasic.setProjectType(projectType);
		sreProjectBasic.setProjectLeader(projectLeader);
		sreProjectBasic.setJoinUnitName(joinUnitName);
		sreProjectBasic.setJoinUnitCode(joinUnitCode);
		sreProjectBasic.setLeadLinkmansName(leadLinkmansName);
		sreProjectBasic.setLeadLinkmansCode(leadLinkmansCode);
		sreProjectBasic.setLeadUnitType(leadUnitType);
		sreProjectBasic.setErpNum(erpNum);
		sreProjectBasic.setProfessional(professional);
		sreProjectBasic.setBelongDepartmentName(belongDepartmentName); 
		sreProjectBasic.setBelongDepartmentCode(belongDepartmentCode);
		sreProjectBasic.setProfessionalDepartName(professionalDepartName);
		sreProjectBasic.setProfessionalDepartCode(professionalDepartCode);
		sreProjectBasic.setProjectChargesName(projectChargesName);
		sreProjectBasic.setProjectChargesCode(projectChargesCode);
		sreProjectBasic.setIsContract("0");
		sreProjectBasic.setContractNum(contractNum);
		sreProjectBasic.setSetupYear(setupYear);
		sreProjectBasic.setLeadUnitName(leadUnitName);
		sreProjectBasic.setLeadUnitCode(leadUnitCode);
		sreProjectBasic.setEntrustUnitCode(entrustUnitCode);
		sreProjectBasic.setEntrustUnitName(entrustUnitName);
		sreProjectBasic.setApplyUnitCode(sysUserInfo.getUnitCode());
		sreProjectBasic.setApplyUnitName(sysUserInfo.getUnitName());
		sreProjectBasic.setApplyUnitId(sysUserInfo.getUnitId());
		String parentApplyUnitCode=EquipmentUtils.getUnitParentCodesByUnitCodes(sysUserInfo.getUnitCode(), restTemplate, httpHeaders);
		sreProjectBasic.setParentApplyUnitCode(parentApplyUnitCode);
		sreProjectBasic.setTaskWriteUserNames(taskWriteUserNames);
		sreProjectBasic.setTaskWriteUsersIds(taskWriteUsersIds);
		sreProjectBasic.setSetupYear(DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
		sreProjectBasic.setYearFeeStrJoinUnit(yearFeeStrJoinUnit);
		// 判断是新增还是修改
		if (id.equals("")) 
		{
			responseEntity = this.restTemplate.exchange(ADD_URL, HttpMethod.POST, new HttpEntity<SreProject>(sreProjectBasic, this.httpHeaders), String.class);

		} else {
			responseEntity = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SreProject>(sreProjectBasic, this.httpHeaders), String.class);
		}
		// 返回结果代码
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200)
		{
			//如果是提交
			if(isWorkFlow.equals("1"))
			{
				String dataId = sreProjectBasic.getId();
				resultsDate.setData(dataId);
				resultsDate.setSuccess(true);
			}
			String arr[]=equipmentIds.split(",");
			if(arr!=null && arr.length>0)
			{
				for(int i=0;i<arr.length;i++)
				{
					String tempid=arr[i];
					if(tempid!=null && !tempid.equals(""))
					{
						SreEquipment sreEquipment=EquipmentUtils.getSreEquipment(tempid, restTemplate, httpHeaders);
						sreEquipment.setIsLinkedProject("1");
						EquipmentUtils.updateSreEquipment(sreEquipment, restTemplate, httpHeaders);
					}
				}
			}
			
		} else 
		{
			resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
		}
		return resultsDate;
	}
	
	
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/update")
	@ResponseBody
	public String update(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		
		Result resultsDate = new Result();
		String id = CommonUtil.getParameter(request, "id", "");
		String taskWriteUserNames = CommonUtil.getParameter(request, "taskWriteUserNames", "");
		String taskWriteUsersIds = CommonUtil.getParameter(request, "taskWriteUsersIds", "");
		logger.info("============远程返回  id " + id+" taskWriteUserNames="+taskWriteUserNames+"  taskWriteUsersIds="+taskWriteUsersIds);
		
		SreProject sreProject=EquipmentUtils.getSreProject(id, restTemplate, httpHeaders);
		sreProject.setTaskWriteUserNames(taskWriteUserNames);
		sreProject.setTaskWriteUsersIds(taskWriteUsersIds);
		String str=EquipmentUtils.updateSreProject(sreProject, restTemplate, httpHeaders);
		
		
		if(!str.equals(""))
		{
			resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
			
			
			
		}else
		{
			resultsDate = new Result(false, RequestProcessStatusEnum.NETWORK_ERROR.getStatusDesc());
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		out.println(ob.toString());
		out.flush();
		out.close();
		return null;
	}
	
	
	
	
	//给填写人发邮件
	@RequestMapping(method = RequestMethod.POST, value = "/sentSreProjectTaskMail")
	@ResponseBody
	public String sentSreProjectTaskMail(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		
		Result resultsDate = new Result(false, RequestProcessStatusEnum.NETWORK_ERROR.getStatusDesc());
		String id = CommonUtil.getParameter(request, "id", "");
		SreProject sreProject=EquipmentUtils.getSreProject(id, restTemplate, httpHeaders);
		//发邮件：
		SysUser sysUser=	EquipmentUtils.getSysUser(sreProject.getTaskWriteUsersIds(), restTemplate, httpHeaders);
		if(sysUser!=null)
		{
			String mail=sysUser.getUserMail();
			if(mail!=null && !mail.equals(""))
			{
				sreProject.setEmail("281722797@qq.com");
				int count=EquipmentUtils.sentSreProjectTaskMail(id, sreProject, restTemplate, httpHeaders);
				if(count>0)
				{
					resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
				}
				
			}
		}
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		out.println(ob.toString());
		out.flush();
		out.close();
		return null;
	}
	
	
	@RequestMapping(value = "/start_workflow")
	@ResponseBody
	public Object start_workflow_new(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		
		
		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);//设置参数类型和编码
		String id = CommonUtil.getParameter(request, "id", "");
		String functionId = CommonUtil.getParameter(request, "functionId", "");
		String userIds = CommonUtil.getParameter(request, "userIds", "");
		SreProject sreProject=EquipmentUtils.getSreProject(id,restTemplate,httpHeaders);
		System.out.println("============start_workflow_new userIds="+userIds+" functionId="+functionId+" id="+id);
		
		Map<String ,Object> paramMap = new HashMap<String ,Object>();
		paramMap.put("id", id);
		paramMap.put("functionId", functionId);
		paramMap.put("userIds", userIds);
		paramMap.put("processInstanceName", "计划上报->"+sreProject.getName());
		paramMap.put("authenticatedUserId", sysUserInfo.getUserId());
		paramMap.put("authenticatedUserName", sysUserInfo.getUserDisp());
		paramMap.put("functionId", functionId);
		paramMap.put("auditor", userIds);
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
		Result rs = this.restTemplate.exchange(EQUIPMENT_PROJECT_WORKFLOW_URL + id, HttpMethod.POST, httpEntity, Result.class).getBody();
		return rs;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	    
		

	

	/**
	 * 删除
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(DEL_URL + id, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
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

	@RequestMapping(value = "/pass-back/{id}")
	public String passBackOPT(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result resultsDate = new Result();
		String status = CommonUtil.getParameter(request, "status", "");
		String checkMoney = CommonUtil.getParameter(request, "checkMoney", "");
		ResponseEntity<SreProject> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreProject.class);
		int statusCode = responseEntity.getStatusCodeValue();
		logger.info("============远程返回  statusCode " + statusCode);
		SreProject sreProjectBasic = responseEntity.getBody();
		if (!checkMoney.equals("")) {
			sreProjectBasic.setProjectMoney(new BigDecimal(checkMoney));
		}
		ResponseEntity<Integer> responseE = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SreProject>(sreProjectBasic, this.httpHeaders), Integer.class);
		// 返回结果代码
		int status_Code = responseE.getStatusCodeValue();
		if (responseE.getBody() > 0) {
			resultsDate = new Result(true);
		} else {
			resultsDate = new Result(false, "操作失败，请联系系统管理员！");
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		out.println(ob.toString());
		out.flush();
		out.close();
		return null;
	}

	@RequestMapping(value = "/bacth-delete")
	public String deleteBatch(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result resultsDate = new Result();
		ResponseEntity<Integer> responseEntity = null;
		String chkboxstr = CommonUtil.getParameter(request, "ids", "");
		String chkbox[] = chkboxstr.split(",");
		System.out.println("--------chkboxstr=" + chkboxstr + " chkbox=" + chkbox.length);

		if (chkbox != null && chkbox.length > 0) {
			List<String> list = Arrays.asList(chkbox);
			List<Long> longList = new ArrayList();
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					String str = list.get(i);
					longList.add(Long.valueOf(str));
				}
			}
			JSONArray jsonObject = JSONArray.parseArray(JSON.toJSONString(longList));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			responseEntity = restTemplate.exchange(BATCH_DEL_URL, HttpMethod.POST, entity, Integer.class);

		}
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
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public String get(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		ResponseEntity<SreProject> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreProject.class);
		int statusCode = responseEntity.getStatusCodeValue();
		logger.info("============远程返回  statusCode " + statusCode);
		SreProject sreProjectBasic = responseEntity.getBody();
		request.setAttribute("sreProjectBasic", sreProjectBasic);
		
		
		
		String leadUnitName = sreProjectBasic.getLeadUnitName();
		String leadUnitCode = sreProjectBasic.getLeadUnitCode();
		String createUserId= sreProjectBasic.getCreateUserId();
		String documentDoc=sreProjectBasic.getDocumentDoc();
		String beginYear		= sreProjectBasic.getBeginYear();
		String endYear		= sreProjectBasic.getEndYear();
	
		request.setAttribute("documentDoc", documentDoc);
		request.setAttribute("leadUnitName", leadUnitName);
		request.setAttribute("leadUnitCode", leadUnitCode);
		request.setAttribute("createUserId", createUserId);
		request.setAttribute("endYear", endYear);
		request.setAttribute("beginYear", beginYear);
		List<UnitField>  unitFieldList= CommonUtil.getUnitNameList(restTemplate, httpHeaders);
		request.setAttribute("unitFieldList", unitFieldList);
		
		List<SysDictionary>  dicList= CommonUtil.getDictionaryByParentCode("ROOT_UNIVERSAL_LCZT", restTemplate, httpHeaders);
		request.setAttribute("dicList", dicList);
		
	
		return "/stp/equipment/project/project-basic-view";
	}
	
	
	
	
	
	

}
