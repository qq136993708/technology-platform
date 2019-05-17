package com.pcitc.web.controller.equipment;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
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
import com.pcitc.base.stp.equipment.JoinUnitWord;
import com.pcitc.base.stp.equipment.SreEquipment;
import com.pcitc.base.stp.equipment.SreProject;
import com.pcitc.base.stp.equipment.SreProjectSetup;
import com.pcitc.base.stp.equipment.SreProjectTask;
import com.pcitc.base.stp.equipment.UnitField;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.system.SysPost;
import com.pcitc.base.system.SysUnit;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.system.SysUserProperty;
import com.pcitc.base.util.CodeUtil;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.workflow.Constants;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;
import com.pcitc.web.utils.WordUtil;

@Controller
@RequestMapping(value = "/sre_project_task")
public class ProjectTaskController extends BaseController {


	private static final String PAGE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/project_task/page";
	private static final String ADD_URL = "http://pcitc-zuul/stp-proxy/sre-provider/project_task/add";
	private static final String UPDATE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/project_task/update";
	private static final String BATCH_DEL_URL = "http://pcitc-zuul/stp-proxy/sre-provider/project_task/batch-delete/";
	private static final String GET_URL = "http://pcitc-zuul/stp-proxy/sre-provider/project_task/get/";
	//临时导出文件目录
	private static final String TEMP_FILE_PATH = "src/main/resources/tem/";
	private static final String TASK_INNER_WORKFLOW_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project_task/start_inner_activity/";
	private static final String TASK_WORKFLOW_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project_task/start_up_activity/";
	
	
	private static final String GET_BY_TOPICID_URL = "http://pcitc-zuul/stp-proxy/sre-provider/project_task/getSreProjectTaskList/";
	private static final String GET_ERP_NUM =  "http://pcitc-zuul/hana-proxy/hana/common/dic/getErpInfoList";
	
	
	//任务安排
	@RequestMapping(value = "/arrange_list")
	public String arrange_list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<UnitField>  unitFieldList= CommonUtil.getUnitNameList(restTemplate, httpHeaders);
		request.setAttribute("unitFieldList", unitFieldList);
		
		
		String applyUnitCode=sysUserInfo.getUnitCode();
		request.setAttribute("applyUnitCode", applyUnitCode);
		
		String unitPathIds =   sysUserInfo.getUnitPath();
		boolean isKJBPerson=EquipmentUtils.isKJBPerson(unitPathIds);
		request.setAttribute("isKJBPerson", isKJBPerson);
		
		return "/stp/equipment/task/arrange_list";
	}
	
	//任务填写
	@RequestMapping(value = "/write_list")
	public String write_list(HttpServletRequest request, HttpServletResponse response)throws Exception  {
		
		String userId=sysUserInfo.getUserId();
		request.setAttribute("userId", userId);
		
		List<SysDictionary>  dicList= CommonUtil.getDictionaryByParentCode("ROOT_UNIVERSAL_LCZT", restTemplate, httpHeaders);
		request.setAttribute("dicList", dicList);
		List<UnitField>  unitFieldList= CommonUtil.getUnitNameList(restTemplate, httpHeaders);
		request.setAttribute("unitFieldList", unitFieldList);
		return "/stp/equipment/task/write_list";
	}
	
	
	//任务上报
	@RequestMapping(value = "/apply_list")
	public String apply_list(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		
		
		List<SysDictionary>  dicList= CommonUtil.getDictionaryByParentCode("ROOT_UNIVERSAL_LCZT", restTemplate, httpHeaders);
		request.setAttribute("dicList", dicList);
		
		List<UnitField>  unitFieldList= CommonUtil.getUnitNameList(restTemplate, httpHeaders);
		request.setAttribute("unitFieldList", unitFieldList);
		
		
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
		
		boolean isKJBPerson=EquipmentUtils.isKJBPerson(unitPathIds);
		request.setAttribute("isKJBPerson", isKJBPerson);
		
		return "/stp/equipment/task/apply_list";
	}
		
	//任务审核
	@RequestMapping(value = "/audit_list")
	public String audit_list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/stp/equipment/task/audit_list";
	}
	//任务对接--生成合同号
	@RequestMapping(value = "/join_list")
	public String join_list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<SysDictionary>  dicList= CommonUtil.getDictionaryByParentCode("ROOT_UNIVERSAL_LCZT", restTemplate, httpHeaders);
		request.setAttribute("dicList", dicList);
		List<UnitField>  unitFieldList= CommonUtil.getUnitNameList(restTemplate, httpHeaders);
		request.setAttribute("unitFieldList", unitFieldList);
		/*String	parentUnitPathIds="";
		String unitPathIds =   sysUserInfo.getUnitPath();
		if(unitPathIds!=null && !unitPathIds.equals(""))
		{
			if(unitPathIds.length()>4)
			{
				parentUnitPathIds=unitPathIds.substring(0, unitPathIds.length()-4);
				
			}
		}
		request.setAttribute("parentUnitPathIds", parentUnitPathIds);*/
		
		return "/stp/equipment/task/join_list";
	}		
	
	
	
	

	@RequestMapping(value = "/to_list")
	public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<SysDictionary>  dicList= CommonUtil.getDictionaryByParentCode("ROOT_UNIVERSAL_LCZT", restTemplate, httpHeaders);
		request.setAttribute("dicList", dicList);
		return "/stp/equipment/task/project_task_list";
	}

	@RequestMapping(value = "/list")
	@ResponseBody
	public String ajaxlist(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {
		
		JSONObject parmamss = JSONObject.parseObject(JSONObject.toJSONString(param));
		logger.info("============参数：" + parmamss.toString());
		//
		String applyDepartCode=sysUserInfo.getUnitCode();
		
		
		
		
		
		
		
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
	
	
	
	@RequestMapping(value = "/confirm_list")
	public String confirm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<SysDictionary>  dicList= CommonUtil.getDictionaryByParentCode("ROOT_UNIVERSAL_LCZT", restTemplate, httpHeaders);
		request.setAttribute("dicList", dicList);

		List<UnitField>  unitFieldList= CommonUtil.getUnitNameList(restTemplate, httpHeaders);
		request.setAttribute("unitFieldList", unitFieldList);
		
		
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
		return "/stp/equipment/task/confirm_list";
	}
	
	
	@RequestMapping(value = "/upFileDoc")
	public String upFileDoc(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		
		String taskId = CommonUtil.getParameter(request, "taskId", "");
		request.setAttribute("taskId", taskId);
		
		if(!taskId.equals(""))
		{
			SreProjectTask sreProjectTask =EquipmentUtils.getSreProjectTask(taskId, restTemplate, httpHeaders);
			request.setAttribute("sreProjectTask", sreProjectTask);
			String documentDoc=sreProjectTask.getDocumentDoc();
			if(documentDoc==null || documentDoc.equals(""))
			{
				documentDoc= IdUtil.createFileIdByTime();
			}
			request.setAttribute("documentDoc", documentDoc);
		}
		
		return "/stp/equipment/task/upFileDoc";
	}
	
	
	@RequestMapping(value = "/updateFileDoc")
	public String updateFileDoc(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Result resultsDate = new Result();
		String taskId = CommonUtil.getParameter(request, "taskId", "");
		String documentDoc = CommonUtil.getParameter(request, "documentDoc", "");
		String resutl="";
		if(!taskId.equals(""))
		{
			SreProjectTask sreProjectTask =EquipmentUtils.getSreProjectTask(taskId, restTemplate, httpHeaders);
			sreProjectTask.setDocumentDoc(documentDoc);
			resutl=EquipmentUtils.updateSreProjectTask(sreProjectTask, restTemplate, httpHeaders);
		}
		if (resutl.equals(""))
		{
			resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
		} else 
		{
			resultsDate.setSuccess(true);
		}

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		out.println(ob.toString());
		out.flush();
		out.close();
		return null;
	}
	
	
	
	
	@RequestMapping(value = "/updateErp")
	public String updateErp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Result resultsDate = new Result();
		String taskId = CommonUtil.getParameter(request, "taskId", "");
		String erpNum = CommonUtil.getParameter(request, "erpNum", "");
		String resutl="";
		if(!taskId.equals(""))
		{
			SreProjectTask sreProjectTask =EquipmentUtils.getSreProjectTask(taskId, restTemplate, httpHeaders);
			SreProject sreProject=EquipmentUtils.getSreProject(sreProjectTask.getTopicId(), restTemplate, httpHeaders);
			sreProject.setErpNum(erpNum);
			EquipmentUtils.updateSreProject(sreProject, restTemplate, httpHeaders);
			
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_BY_TOPICID_URL+sreProjectTask.getTopicId(), HttpMethod.GET, new HttpEntity<Object>(httpHeaders), JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200)
			{
				
				JSONArray array = responseEntity.getBody();
				List<SreProjectTask> list = JSONObject.parseArray(array.toJSONString(), SreProjectTask.class);
				if(list!=null && list.size()>0)
				{
					for(int i=0;i<list.size();i++)
					{
						SreProjectTask task=list.get(i);
						task.setErpNum(erpNum);
						EquipmentUtils.updateSreProjectTask(task, restTemplate, httpHeaders);
					}
					
				}
			}
			
			
		}
		if (resutl.equals(""))
		{
			resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
		} else 
		{
			resultsDate.setSuccess(true);
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

		
		
		String leadUnitName = sysUserInfo.getUnitName();
		String leadUnitCode = sysUserInfo.getUnitCode();
		String createUserName=sysUserInfo.getUserDisp();
		String createUserId=sysUserInfo.getUserName();
		String documentDoc= IdUtil.createFileIdByTime();
		
		String taskId = CommonUtil.getParameter(request, "taskId", "");
		request.setAttribute("taskId", taskId);
		String topicId = CommonUtil.getParameter(request, "topicId", "");
		request.setAttribute("topicId", topicId);
		if(!topicId.equals(""))
		{
			SreProject sreProject=EquipmentUtils.getSreProject(topicId,restTemplate,httpHeaders);
			request.setAttribute("sreProject", sreProject);
		}
		if(!taskId.equals(""))
		{
			SreProjectTask sreProjectTask =EquipmentUtils.getSreProjectTask(taskId, restTemplate, httpHeaders);
			request.setAttribute("sreProjectTask", sreProjectTask);
		    topicId=sreProjectTask.getTopicId();
			if(!topicId.equals(""))
			{
				SreProject sreProject=EquipmentUtils.getSreProject(topicId,restTemplate,httpHeaders);
				request.setAttribute("sreProject", sreProject);
			}
			documentDoc=sreProjectTask.getDocumentDoc();
		}
		request.setAttribute("documentDoc", documentDoc);
		request.setAttribute("leadUnitName", leadUnitName);
		request.setAttribute("leadUnitCode", leadUnitCode);
		request.setAttribute("createUserId", createUserId);
		List<SysDictionary>  dicList= CommonUtil.getDictionaryByParentCode("ROOT_ZBGL_YTJYSDNR", restTemplate, httpHeaders);
		request.setAttribute("dicList", dicList);
		return "/stp/equipment/task/project_task_add";
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
	public String saveOrUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result resultsDate = new Result();
		// 业务ID
		String taskId = CommonUtil.getParameter(request, "taskId", "");
		// 流程状态-是保存还是提交
		String innerAuditStatus = CommonUtil.getParameter(request, "innerAuditStatus", Constant.AUDIT_STATUS_DRAFT);
		String auditStatus = CommonUtil.getParameter(request, "auditStatus", Constant.AUDIT_STATUS_DRAFT);
		String budgetTable = CommonUtil.getParameter(request, "budgetTable", "");
		String fundsSourcesTable = CommonUtil.getParameter(request, "fundsSourcesTable", "");
		String notes = CommonUtil.getParameter(request, "notes", "");
		String contractNum = CommonUtil.getParameter(request, "contractNum", "");
		String projectNotice = CommonUtil.getParameter(request, "projectNotice", "");
		String taskMainTaskContent = CommonUtil.getParameter(request, "taskMainTaskContent", "");
		String taskContent = CommonUtil.getParameter(request, "taskContent", "");
		String taskAssessmentContent = CommonUtil.getParameter(request, "taskAssessmentContent", "");
		String topicId = CommonUtil.getParameter(request, "topicId", "");
		String beginProjectMonth = CommonUtil.getParameter(request, "beginProjectMonth", "");
		String endProjectMonth = CommonUtil.getParameter(request, "endProjectMonth", "");
		StringBuffer taskCheckContents = new StringBuffer();
		String arr[]=request.getParameterValues("taskCheckContents");
		
		String unitPathIds =   CommonUtil.getParameter(request, "unitPathIds",sysUserInfo.getUnitPath());
		String unitPathNames = CommonUtil.getParameter(request, "unitPathNames", sysUserInfo.getUnitName());
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
		System.out.println("----------------------topicId="+topicId);
		if(arr!=null && arr.length>0)
		{
			for(int i=0;i<arr.length;i++)
			{
				if(i>0)
				{
					taskCheckContents.append(",");
				}
				taskCheckContents.append(arr[i]);
			}
		}
		SreProjectTask sreProjectBasic = null;
		ResponseEntity<String> responseEntity = null;
		
		// 判断是新增还是修改
		if (taskId.equals("")) 
		{
			sreProjectBasic = new SreProjectTask();
			sreProjectBasic.setCreateDate(new Date());
			//创建人
			sreProjectBasic.setCreateUserId(sysUserInfo.getUserId());
			sreProjectBasic.setCreateUserName(sysUserInfo.getUserDisp());
			String idv = UUID.randomUUID().toString().replaceAll("-", "");
			sreProjectBasic.setTaskId(idv);
			sreProjectBasic.setAuditStatus(auditStatus);
			sreProjectBasic.setInnerAuditStatus(innerAuditStatus);
			sreProjectBasic.setSetupYear(DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
			String taskVersion=getVersion(topicId);
			sreProjectBasic.setTaskVersion(taskVersion);
			sreProjectBasic.setCloseStatus("0");
			sreProjectBasic.setIsCheck("0");
		} else 
		{
			ResponseEntity<SreProjectTask> se = this.restTemplate.exchange(GET_URL + taskId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreProjectTask.class);
			sreProjectBasic = se.getBody();
		}
		// 流程状态
		sreProjectBasic.setAuditStatus(auditStatus);
		//BigDecimal projectMoney=BigDecimal.ZERO;
		/*if (!yearFeeStr.equals("")) //2019,55,5,60#2020,553,5,558
		{
			String array[]=yearFeeStr.split("#");
			if(array!=null && array.length>0)
			{
				for(int i=0;i<array.length;i++)
				{
					String year=array[i];
					String arr[]=year.split(",");
					projectMoney=projectMoney.add(new BigDecimal(arr[3]));
				}
			}
			
		}*/
		
		SreProject sreProject=EquipmentUtils.getSreProject(topicId,restTemplate,httpHeaders);
		if(sreProject!=null)
		{
			sreProjectBasic.setTopicName(sreProject.getName());
			sreProjectBasic.setJoinUnitCode(sreProject.getJoinUnitCode());
			sreProjectBasic.setJoinUnitName(sreProject.getJoinUnitName());
			sreProjectBasic.setLeadUnitCode(sreProject.getLeadUnitCode());
			sreProjectBasic.setLeadUnitName(sreProject.getLeadUnitName());
			sreProjectBasic.setProjectMoney(sreProject.getProjectMoney());
			sreProjectBasic.setProjectFundsTable(sreProject.getYearFeeStr());//领导单位
			sreProjectBasic.setYearFeeStrJoinUnit(sreProject.getYearFeeStrJoinUnit());//参与单位
			sreProjectBasic.setBelongDepartmentCode(sreProject.getBelongDepartmentCode());
			sreProjectBasic.setBelongDepartmentName(sreProject.getBelongDepartmentName());
			sreProjectBasic.setProfessionalDepartCode(sreProject.getProfessionalDepartCode());
			sreProjectBasic.setProfessionalDepartName(sreProject.getProfessionalDepartName());
			sreProjectBasic.setProfessionalFieldName(sreProject.getProfessionalFieldName());
			sreProjectBasic.setProfessionalFieldCode(sreProject.getProfessionalFieldCode());
			sreProjectBasic.setJoinUnitParentCodes(sreProject.getJoinUnitParentCodes());
			sreProjectBasic.setJoinUnitParentNames(sreProject.getJoinUnitParentNames());
			
		}
		sreProjectBasic.setTopicId(topicId); 
		sreProjectBasic.setContractNum(contractNum);
		sreProjectBasic.setBudgetTable(budgetTable);
		sreProjectBasic.setContractNum(contractNum);
		sreProjectBasic.setFundsSourcesTable(fundsSourcesTable);
		sreProjectBasic.setNotes(notes);
		sreProjectBasic.setProjectNotice(projectNotice);
		sreProjectBasic.setTaskMainTaskContent(taskMainTaskContent);
		sreProjectBasic.setTaskContent(taskContent);
		sreProjectBasic.setTaskCheckContents(taskCheckContents.toString());
		sreProjectBasic.setTaskAssessmentContent(taskAssessmentContent);
		sreProjectBasic.setBeginProjectMonth(beginProjectMonth);
		sreProjectBasic.setEndProjectMonth(endProjectMonth);
		
		sreProjectBasic.setCreateUnitCode(sysUserInfo.getUnitCode());
		sreProjectBasic.setCreateUnitName(sysUserInfo.getUnitName());
		sreProjectBasic.setParentUnitPathIds(parentUnitPathIds);
		sreProjectBasic.setParentUnitPathNames(parentUnitPathNames); 
		sreProjectBasic.setUnitPathIds(unitPathIds);
		sreProjectBasic.setUnitPathNames(unitPathNames);
		
		
		// 判断是新增还是修改
		if (taskId.equals("")) 
		{
			responseEntity = this.restTemplate.exchange(ADD_URL, HttpMethod.POST, new HttpEntity<SreProjectTask>(sreProjectBasic, this.httpHeaders), String.class);

		} else {
			responseEntity = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SreProjectTask>(sreProjectBasic, this.httpHeaders), String.class);
		}
		// 返回结果代码
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200)
		{
			
			String dataId = sreProjectBasic.getTaskId();
			resultsDate.setData(sreProjectBasic);
			resultsDate.setSuccess(true);
		} else 
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
	
	
	
	
	
	private String  getVersion(String topicId)
	{
		String version="1";
		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_BY_TOPICID_URL+topicId, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), JSONArray.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200)
		{
			
			JSONArray array = responseEntity.getBody();
			List<SreProjectTask> list = JSONObject.parseArray(array.toJSONString(), SreProjectTask.class);
			if(list!=null && list.size()>0)
			{
				version="2";
			}
		}
		return version;
	}
	
	
	

	/**
	 * 加入流程信息
	 * 
	 * @param id
	 * @param instanceName
	 * @param sysUser
	 */
	/*private boolean dealProjectWorkFlow(HttpServletRequest request,String id,String functionId, SysUser sysUser, String instanceName, String userIds, HttpHeaders httpHeaders)throws Exception
	{
		
		
		
		
		
		WorkflowVo workflowVo = new WorkflowVo();
		workflowVo.setBusinessId(String.valueOf(id));
		workflowVo.setProcessInstanceName(instanceName);
		workflowVo.setAuthenticatedUserId(sysUser.getUserId());
		workflowVo.setAuthenticatedUserName(sysUser.getUserDisp());
		workflowVo.setAuditUserIds(sysUser.getUserId());
		// process_define_id和functionId，两种方式二选一
		// 清楚知道自己要走的流程定义id
		// 不清楚此功能菜单要走的审批流程。可以通过菜单id（functionId），部门/组织ID（orgId），项目id（id）。其中菜单id必填（和ProcessDefineId两选一）
		workflowVo.setFunctionId(functionId);
		workflowVo.setProjectId("");
		Map<String, Object> variables = new HashMap<String, Object>();
		//variables.put("starter", workflowVo.getAuthenticatedUserId());
		
		 //必须设置。流程中，需要的第二个节点的指派人；除starter外，所有待办人变量都指定为auditor(处长审批)
        //处长审批 ZSH_JTZSZYC_GJHZC_CZ
		ResponseEntity<List> responseEntity = this.restTemplate.exchange(get_user_bypostcode + "ZSH_JTZSZYC_GJHZC_CZ", HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200)
		{
			List<SysUser> users= responseEntity.getBody();
	        System.out.println("start userIds ... "+JSON.toJSONString(users));
	        variables.put("auditor", workflowVo.getAuthenticatedUserId());
	        if(users != null && users.size()>0)
	        {
	        	variables.put("auditor", users.get(0).getUserId());
	        }
	        
		}
		// 发起人之后的审批环节，如果是需要选择审批人的话，此处获取选择的userIds赋值给auditor变量
		if (userIds != null && !userIds.equals("")) 
		{
			String[] userIdsArr = userIds.split(",");
			variables.put("auditor", Arrays.asList(userIdsArr));
		}
		// 必须设置，统一流程待办任务中需要的业务详情
		variables.put("auditDetailsPath", "/sre_project_task/get/" + id);
		// 流程完全审批通过时，调用的方法
		variables.put("auditAgreeMethod", AUDIT_AGREE_URL + id);
		// 流程驳回时，调用的方法（可能驳回到第一步，也可能驳回到第1+n步
		variables.put("auditRejectMethod", AUDIT_REJECT_URL + id);
		workflowVo.setVariables(variables);
		ResponseEntity<String> status = this.restTemplate.exchange(Constants.START_WORKFLOW_URL, HttpMethod.POST, new HttpEntity<WorkflowVo>(workflowVo, httpHeaders), String.class);
		if (status.getBody() != null && status.getBody().equals("true"))
		{
			System.out.println("=================流程启动成功");
			SreProjectTask sreProject =EquipmentUtils.getSreProjectTask(id,restTemplate,httpHeaders);
			sreProject.setAuditStatus(Constant.AUDIT_STATUS_SUBMIT);
			sreProject.setApplyUnitCode(sysUserInfo.getUnitCode());
			sreProject.setApplyUnitName(sysUserInfo.getUnitName());
			
			String unitPathIds =   sysUserInfo.getUnitPath();
			sreProject.setApplyUnitPathCode(unitPathIds);
			
			String parentApplyUnitPathCode ="";
			String parentApplyUnitPathName =  "";
			if(unitPathIds!=null && !unitPathIds.equals(""))
			{
				if(unitPathIds.length()>4)
				{
					parentApplyUnitPathCode=unitPathIds.substring(0, unitPathIds.length()-4);
					SysUnit sysUnit=EquipmentUtils.getUnitByUnitPath(parentApplyUnitPathCode, restTemplate, httpHeaders);
					if(sysUnit!=null)
					{
						parentApplyUnitPathName = sysUnit.getUnitName();
					}
				}
			}
			sreProject.setParentApplyUnitPathCode(parentApplyUnitPathCode);
			sreProject.setParentApplyUnitPathName(parentApplyUnitPathName);
			
			
			sreProject.setApplyUserId(sysUser.getUserId());
			sreProject.setApplyUserName(sysUser.getUserDisp());
			
			String str=EquipmentUtils.updateSreProjectTask(sreProject,restTemplate,httpHeaders);
			return true;
		} else
		{
			System.out.println("=================流程启动失败");
			return false;
		}
	}
	*/
	
	/**
	 * 任务确认流程信息
	 * 
	 * @param id
	 * @param instanceName
	 * @param sysUser
	 */
	/*private boolean dealConfirmWorkFlow(String id,String functionId, SysUser sysUser, String instanceName, String userIds, HttpHeaders httpHeaders)
	{
		
		
		
		WorkflowVo workflowVo = new WorkflowVo();
		workflowVo.setBusinessId(String.valueOf(id));
		workflowVo.setProcessInstanceName(instanceName);
		workflowVo.setAuthenticatedUserId(sysUser.getUserId());
		workflowVo.setAuthenticatedUserName(sysUser.getUserDisp());
		//workflowVo.setAuditUserIds(sysUser.getUserId());
		// process_define_id和functionId，两种方式二选一
		// 清楚知道自己要走的流程定义id
		//workflowVo.setProcessDefineId(PROCESS_DEFINE_ID_CONFIRM_FLOAT);
		// 不清楚此功能菜单要走的审批流程。可以通过菜单id（functionId），部门/组织ID（orgId），项目id（id）。其中菜单id必填（和ProcessDefineId两选一）
		workflowVo.setFunctionId(functionId);
		workflowVo.setProjectId("");
		Map<String, Object> variables = new HashMap<String, Object>();
		//variables.put("starter", workflowVo.getAuthenticatedUserId());
		
		 //必须设置。流程中，需要的第二个节点的指派人；除starter外，所有待办人变量都指定为auditor(处长审批)
        //处长审批 ZSH_JTZSZYC_GJHZC_CZ
		ResponseEntity<List> responseEntity = this.restTemplate.exchange(get_user_bypostcode + "ZSH_JTZSZYC_GJHZC_CZ", HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200)
		{
			List<SysUser> users= responseEntity.getBody();
	        System.out.println("start userIds ... "+JSON.toJSONString(users));
	        variables.put("auditor", workflowVo.getAuthenticatedUserId());
	        if(users != null && users.size()>0)
	        {
	        	variables.put("auditor", users.get(0).getUserId());
	        }
	        
		}
		// 发起人之后的审批环节，如果是需要选择审批人的话，此处获取选择的userIds赋值给auditor变量
		if (userIds != null && !userIds.equals("")) 
		{
			String[] userIdsArr = userIds.split(",");
			variables.put("auditor", Arrays.asList(userIdsArr));
		}
		
		
		variables.put("specialAuditor0", "ZBGL_KTY_CYDW");
		variables.put("specialAuditor1", "ZBGL_KTY_QYKYZG");
    	variables.put("specialAuditor2", "ZBGL_KTY_FZDWKJCZ");
    	variables.put("specialAuditor3", "ZBGL_KTY_FZDWZGLD");
    	
		//会签
		variables.put("signAuditRate", 1d); 
		
		
		// 必须设置，统一流程待办任务中需要的业务详情
		variables.put("auditDetailsPath", "/sre_project_task/get/" + id);
		// 流程完全审批通过时，调用的方法
		variables.put("auditAgreeMethod", AUDIT_AGREE_URL_INNER + id);
		// 流程驳回时，调用的方法（可能驳回到第一步，也可能驳回到第1+n步
		variables.put("auditRejectMethod", AUDIT_REJECT_URL_INNER + id);
		workflowVo.setVariables(variables);
		ResponseEntity<String> status = this.restTemplate.exchange(Constants.START_WORKFLOW_URL, HttpMethod.POST, new HttpEntity<WorkflowVo>(workflowVo, httpHeaders), String.class);
		if (status.getBody() != null && status.getBody().equals("true"))
		{
			System.out.println("=================流程启动成功");
			
			SreProjectTask sreProject =EquipmentUtils.getSreProjectTask(id,restTemplate,httpHeaders);
			sreProject.setInnerAuditStatus(Constant.AUDIT_STATUS_SUBMIT);
			EquipmentUtils.updateSreProjectTask(sreProject,restTemplate,httpHeaders);
			return true;
		} else
		{
			System.out.println("=================流程启动失败");
			return false;
		}
	}*/
	
	//内部确认流程
	@RequestMapping(value = "/start_confirm_workflow")
	@ResponseBody
	public Object start_confirm_workflow(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);//设置参数类型和编码
		String taskId = CommonUtil.getParameter(request, "taskId", "");
		String functionId = CommonUtil.getParameter(request, "functionId", "");
		String userIds = CommonUtil.getParameter(request, "userIds", "");
		System.out.println("============start_confirm_workflow userIds="+userIds+" functionId="+functionId+" taskId="+taskId);
		SreProjectTask sreProjectTask=EquipmentUtils.getSreProjectTask(taskId, restTemplate, httpHeaders);
		
		String branchFlag="0";
		String joinUnitCode=sreProjectTask.getJoinUnitCode();
		if(joinUnitCode!=null && !joinUnitCode.equals(""))
		{
			branchFlag="1";
		}
		
		Map<String ,Object> paramMap = new HashMap<String ,Object>();
		paramMap.put("taskId", taskId);
		paramMap.put("functionId", functionId);
		paramMap.put("processInstanceName", "计划院内确认->"+sreProjectTask.getTopicName());
		paramMap.put("authenticatedUserId", sysUserInfo.getUserId());
		paramMap.put("authenticatedUserName", sysUserInfo.getUserDisp());
		paramMap.put("auditor", userIds);
		paramMap.put("branchFlag", branchFlag);
		//申请者机构信息
		paramMap.put("applyUnitCode", sysUserInfo.getUnitCode());
		String parentApplyUnitCode=EquipmentUtils.getUnitParentCodesByUnitCodes(sysUserInfo.getUnitCode(), restTemplate, httpHeaders);
		paramMap.put("parentApplyUnitCode", parentApplyUnitCode);
		
		paramMap.put("applyUnitName", sysUserInfo.getUnitName());
		paramMap.put("applyUserId", sysUserInfo.getUserId());
		paramMap.put("applyUserName", sysUserInfo.getUserDisp());
		paramMap.put("applyUnitPathCode", sysUserInfo.getUnitPath());
		String unitPathIds =   sysUserInfo.getUnitPath();
		String parentApplyUnitPathCode ="";
		String parentApplyUnitPathName =  "";
		if(unitPathIds!=null && !unitPathIds.equals(""))
		{
			if(unitPathIds.length()>4)
			{
				parentApplyUnitPathCode=unitPathIds.substring(0, unitPathIds.length()-4);
				SysUnit sysUnit=EquipmentUtils.getUnitByUnitPath(parentApplyUnitPathCode, restTemplate, httpHeaders);
				if(sysUnit!=null)
				{
					parentApplyUnitPathName = sysUnit.getUnitName();
				}
			}
		}
		paramMap.put("parentApplyUnitPathCode", parentApplyUnitPathCode);
		paramMap.put("parentApplyUnitPathName", parentApplyUnitPathName);
		
		
		//指定岗位
		String specialAuditor1 = "";//xxx_装备_企业科研主管-岗位代码
		StringBuffer specialAuditor1_sb = new StringBuffer();
		String specialAuditor2 = "";//xxx_装备_负责单位科技处长-岗位代码
		StringBuffer specialAuditor2_sb = new StringBuffer();
		String specialAuditor3 = "";//xxx_装备_负责单位主管领导-岗位代码
		StringBuffer specialAuditor3_sb = new StringBuffer();
		
		String unitIds=sysUserInfo.getUnitId();
		System.out.println("============unitIds ="+unitIds+" applyUnitName="+sysUserInfo.getUnitName());
		if(unitIds!=null && !unitIds.equals(""))
		{
			String arr[]=unitIds.split(",");
			if(arr!=null && arr.length>0)
			{
				for(int i=0;i<arr.length;i++)
				{
					 String unitId=arr[i];
					
					 List<SysPost> list = EquipmentUtils.getPostListByUnitId(unitId, restTemplate, httpHeaders);
					 if(list!=null && list.size()>0)
					 {
						    for(int j=0;j<list.size();j++)
							{
						    	SysPost sysPost=list.get(j);
						    	String postCode=sysPost.getPostCode();
						    	String postName=sysPost.getPostName();
						    	System.out.println("============ postName ="+ postName);
						    	if(postName.contains("企业科研主管"))
						    	{
						    		specialAuditor1_sb.append(postCode).append("-");
						    	}
						    	if(postName.contains("负责单位科技处长"))
						    	{
						    		specialAuditor2_sb.append(postCode).append("-");
						    	}
						    	if(postName.contains("负责单位主管领导"))
						    	{
						    		specialAuditor3_sb.append(postCode).append("-");
						    	}
							}
					 }
				}
				
			}
			specialAuditor1=specialAuditor1_sb.toString();
			specialAuditor2=specialAuditor2_sb.toString();
			specialAuditor3=specialAuditor3_sb.toString();
			if(!specialAuditor1.equals(""))
			{
				specialAuditor1= specialAuditor1.substring(0,specialAuditor1.length() - 1);
			}
			if(!specialAuditor2.equals(""))
			{
				specialAuditor2= specialAuditor2.substring(0,specialAuditor2.length() - 1);
			}
			if(!specialAuditor3.equals(""))
			{
				specialAuditor3= specialAuditor3.substring(0,specialAuditor3.length() - 1);
			}
		}
		paramMap.put("specialAuditor1", specialAuditor1);
		paramMap.put("specialAuditor2", specialAuditor2);
		paramMap.put("specialAuditor3", specialAuditor3);
		System.out.println("============specialAuditor1 ="+specialAuditor1+" specialAuditor2="+specialAuditor2+" specialAuditor3="+specialAuditor3);
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
		//return null;
		Result rs = this.restTemplate.exchange(TASK_INNER_WORKFLOW_URL + taskId, HttpMethod.POST, httpEntity, Result.class).getBody();
		return rs;
	}
	
	
	//计划总部上服
	@RequestMapping(value = "/start_workflow")
	@ResponseBody
	public Object start_workflow(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);//设置参数类型和编码
		String taskId = CommonUtil.getParameter(request, "taskId", "");
		String functionId = CommonUtil.getParameter(request, "functionId", "");
		String userIds = CommonUtil.getParameter(request, "userIds", "");
		SreProjectTask sreProjectTask =EquipmentUtils.getSreProjectTask(taskId,restTemplate,httpHeaders);
		System.out.println("============start_workflow_new userIds="+userIds+" functionId="+functionId+" taskId="+taskId);
		//根据任务书专处业--》自动到各专业领域
		String professionalDepartName=sreProjectTask.getProfessionalDepartName();
		String specialAuditor0=EquipmentUtils.getTaskSpecialAuditor0ByProfessionalDepartName(professionalDepartName);
		System.out.println("============specialAuditor0 ="+specialAuditor0);
		Map<String ,Object> paramMap = new HashMap<String ,Object>();
		paramMap.put("taskId", taskId);
		paramMap.put("functionId", functionId);
		paramMap.put("processInstanceName", "计划总部上服->"+sreProjectTask.getTopicName());
		paramMap.put("authenticatedUserId", sysUserInfo.getUserId());
		paramMap.put("authenticatedUserName", sysUserInfo.getUserDisp());
		paramMap.put("functionId", functionId);
		paramMap.put("auditor", userIds);
		paramMap.put("specialAuditor0", specialAuditor0);
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
		Result rs = this.restTemplate.exchange(TASK_WORKFLOW_URL + taskId, HttpMethod.POST, httpEntity, Result.class).getBody();
		return rs;
		
		
		
		
		
		
	}
	
	
	/*@RequestMapping(value = "/start_confirm_workflow")
	@ResponseBody
	public Object start_confirm_workflow(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		
		String taskId = CommonUtil.getParameter(request, "taskId", "");
		String functionId = CommonUtil.getParameter(request, "functionId", "");
		String userIds = CommonUtil.getParameter(request, "userIds", "");
		System.out.println("============start_confirm_workflo userIds="+userIds+" functionId="+functionId+" taskId="+taskId);
		
		
		Result resultsDate = new Result();
		SreProjectTask sreProjectTask=EquipmentUtils.getSreProjectTask(taskId, restTemplate, httpHeaders);
		
		
		SreProject sreProject=EquipmentUtils.getSreProject(sreProjectTask.getTopicId(),restTemplate,httpHeaders);
		boolean flowFlag = dealConfirmWorkFlow(taskId, functionId,sysUserInfo, "任务书确认->"+sreProject.getName(), userIds, httpHeaders);
		if (flowFlag == true)
		{
			resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
		} else 
		{
			resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
		}
		return resultsDate;
	}
	*/
	
	
	
	
	
	/*@RequestMapping(value = "/start_workflow")
	@ResponseBody
	public Object startProjectPlantWorkflow(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		
		String taskId = CommonUtil.getParameter(request, "taskId", "");
		String functionId = CommonUtil.getParameter(request, "functionId", "");
		String userIds = CommonUtil.getParameter(request, "userIds", "");
		System.out.println("============start_confirm_workflo userIds="+userIds+" functionId="+functionId+" taskId="+taskId);
		Result resultsDate = new Result();
		SreProjectTask sreProjectTask =EquipmentUtils.getSreProjectTask(taskId,restTemplate,httpHeaders);
		SreProject sreProject=EquipmentUtils.getSreProject(sreProjectTask.getTopicId(),restTemplate,httpHeaders);
		
		boolean flowFlag = dealProjectWorkFlow(request,taskId, functionId,sysUserInfo, "任务书->"+sreProject.getName(), userIds, httpHeaders);
		if (flowFlag == true)
		{
			resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
		} else 
		{
			resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
		}
		return resultsDate;
	}*/
	//生成合同号
	@RequestMapping(value = "/create_num")
	@ResponseBody
	public Object create_num(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		
		String taskId = CommonUtil.getParameter(request, "taskId", "");
		String contractNum = CodeUtil.getCode("XTBM_0072", restTemplate, httpHeaders);
		contractNum=contractNum.replace("-", "");//52019001
		
		String oneStr=contractNum.substring(0, 1);
		String towStr=contractNum.substring(3, 8);
		String num=oneStr+towStr;
		
		Result resultsDate = new Result();
		SreProjectTask sreProjectTask =EquipmentUtils.getSreProjectTask(taskId,restTemplate,httpHeaders);
		sreProjectTask.setContractNum(num);
		String str=EquipmentUtils.updateSreProjectTask(sreProjectTask,restTemplate,httpHeaders);
		if (!str.equals(""))
		{
			resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
		} else 
		{
			resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
		}
		return resultsDate;
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
		
		SreProjectTask sreProjectTask=EquipmentUtils.getSreProjectTask(id, restTemplate, httpHeaders);
		String setupId=sreProjectTask.getSetupId();
		if(setupId!=null && !setupId.equals(""))
		{
			EquipmentUtils.deleteSreProjectSetup(setupId, restTemplate, httpHeaders);
		}
		int status = EquipmentUtils.deleteSreProjectTask(id, restTemplate, httpHeaders);
		
		logger.info("============远程返回    status=" + status);
		if (status > 0)
		{
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
	
	
	
		@RequestMapping(value = "/checkSaveTaskVersion")
		@ResponseBody
		public Object checkSaveTask(HttpServletRequest request, HttpServletResponse response) throws Exception 
		{
			
			Result resultsDate = new Result();
			resultsDate.setSuccess(true);
			resultsDate.setCode("0");
			String topicId = CommonUtil.getParameter(request, "topicId", "");
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_BY_TOPICID_URL+topicId, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200)
			{
				
				JSONArray array = responseEntity.getBody();
				List<SreProjectTask> list = JSONObject.parseArray(array.toJSONString(), SreProjectTask.class);
				if(list!=null && list.size()>0)
				{
					String version="";
					for(int i=0;i<list.size();i++)
					{
						SreProjectTask sreProjectTask=	list.get(i);
						version=sreProjectTask.getTaskVersion();
						if(version.equals("1"))
						{
							String contractNum=sreProjectTask.getContractNum();
							if(contractNum!=null && !contractNum.equals(""))
							{
								resultsDate.setCode("1");//可以
							}else
							{
								resultsDate.setMessage("主任务合同号在审核中...请联系科技部相关人员");
							}
						}
					}
				}else
				{
					resultsDate.setCode("1");//可以
				}
				
			}else
			{
				resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
				resultsDate.setMessage("失败");
			}
			return resultsDate;
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
		ResponseEntity<SreProjectTask> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreProjectTask.class);
		int statusCode = responseEntity.getStatusCodeValue();
		logger.info("============远程返回  statusCode " + statusCode);
		SreProjectTask sreProjectTask = responseEntity.getBody();
		request.setAttribute("sreProjectTask", sreProjectTask);
		
		System.out.println(">>>>>>>>>>>>>id"+id+" TopicId:"+sreProjectTask.getTopicId());
		
		SreProject sreProject=EquipmentUtils.getSreProject(sreProjectTask.getTopicId(), restTemplate, httpHeaders);
		request.setAttribute("sreProject", sreProject);
		List<SysDictionary>  dicList= CommonUtil.getDictionaryByParentCode("ROOT_UNIVERSAL_LCZT", restTemplate, httpHeaders);
		request.setAttribute("dicList", dicList);
		
		
		List<SysDictionary>  checkList= CommonUtil.getDictionaryByParentCode("ROOT_ZBGL_YTJYSDNR", restTemplate, httpHeaders);
		request.setAttribute("checkList", checkList);
		
		
		List<UnitField>  unitFieldList= CommonUtil.getUnitNameList(restTemplate, httpHeaders);
		request.setAttribute("unitFieldList", unitFieldList);
		
		
		return "/stp/equipment/task/project_task_view";
	}
	
	
	
	/**
	 * 选择供应商
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/getErpInfo")
	public String getErpInfo(HttpServletRequest request, HttpServletResponse response) {
		
		SysUserProperty sysUserProperty=EquipmentUtils.getSysUserProperty(sysUserInfo.getUserId(), "G0DSM", restTemplate, httpHeaders);
		String g0GSDM=sysUserProperty.getDataId();
		request.setAttribute("g0GSDM", g0GSDM);
		request.setAttribute("companyCode", g0GSDM);
		
		String taskId = CommonUtil.getParameter(request, "taskId", "");
		request.setAttribute("taskId", taskId);
		return "/stp/equipment/task/getErpInfo";
	}
	
	
	    @RequestMapping( value = "/getErpInfoList")
		@ResponseBody
		public String getErpInfoList(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {

			System.out.println("getErpInfoList param=   " + JSONObject.toJSONString(param));
			LayuiTableData layuiTableData = new LayuiTableData();
			HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
			ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(GET_ERP_NUM, HttpMethod.POST, entity, LayuiTableData.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {
				layuiTableData = responseEntity.getBody();
			}
			JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
			System.out.println("getErpInfoList result=   " + result.toJSONString());
			return result.toString();
		}
	 
	 
	 
	 

	
     //生成签字盖章模板
	@RequestMapping(value = "/createQianEvent/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String createQianEvent(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		Result resultsDate = new Result();
		String fileName=createTaskSignWord( id,"task_sign.ftl",  response);
		if (!fileName.equals("")) 
		{
			resultsDate = new Result(true);
			download(TEMP_FILE_PATH+fileName, response);
			deleteFile(TEMP_FILE_PATH+fileName);
		} else {
			resultsDate = new Result(false, "生成文件失败！");
		}
		return null;
	}
	 //生成word文档--任务书签字盖章页
	private String  createTaskSignWord(String id,String ftlName, HttpServletResponse response)
	{
		
		String  resutl="";
		// 文件路径
		String filePath = TEMP_FILE_PATH;
		// 文件名称
		String fileName =DateUtil.dateToStr(new Date(), DateUtil.FMT_SSS_02)+".doc";
		try {
			
			SreProjectTask task =EquipmentUtils.getSreProjectTask(id,restTemplate,httpHeaders);
			SreProject sreProject=null;
			String projectId=task.getTopicId();
			String topicName="";
			String contractNum="";
			String dateMonthDay="";
			if(!projectId.equals(""))
			{
				
				sreProject=EquipmentUtils.getSreProject(projectId,restTemplate,httpHeaders);
				topicName=sreProject.getName();
			}
			contractNum=task.getContractNum();
			dateMonthDay=DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY_DD_ZN);
			Map<String, Object> dataMap = new HashMap<String, Object>();
			/** 组装数据 */
			dataMap.put("topicName", topicName);//项目名称
			dataMap.put("contractNum", contractNum);//合同号
			dataMap.put("dateMonthDay", dateMonthDay);
			/** 生成word */
			boolean flage=WordUtil.createWord(dataMap, ftlName, filePath, fileName);
			if(flage==true)
			{
				resutl=fileName;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resutl;
	}
	
	
	
	//生成任务书WORD
	@RequestMapping(value = "/createWord/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String createWordTask(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		Result resultsDate = new Result();
		String fileName=createWord_task(id,response);
		if (!fileName.equals("")) 
		{
			resultsDate = new Result(true);
			download(TEMP_FILE_PATH+fileName, response);
			deleteFile(TEMP_FILE_PATH+fileName);
		} else {
			resultsDate = new Result(false, "生成文件失败！");
		}
		/*response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		out.println(ob.toString());
		out.flush();
		out.close();*/
		return null;
	}
	
	
	//生成立项报告WORD
	@RequestMapping(value = "/createWordSetup/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String createWordSetup(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		Result resultsDate = new Result();
		SreProjectSetup sreProjectSetup=EquipmentUtils.getSreProjectSetup(id, restTemplate, httpHeaders);
		SreProject sreProject=EquipmentUtils.getSreProject(sreProjectSetup.getTopicId(), restTemplate, httpHeaders);
		SreProjectTask sreProjectTask=EquipmentUtils.getSreProjectTask(sreProjectSetup.getTaskId(), restTemplate, httpHeaders);
		String fileName=EquipmentUtils.createWord_setup(id, TEMP_FILE_PATH, sreProject, sreProjectTask, sreProjectSetup, response) ;
		if (!fileName.equals("")) 
		{
			resultsDate = new Result(true);
			download(TEMP_FILE_PATH+fileName, response);
			deleteFile(TEMP_FILE_PATH+fileName);
		} else {
			resultsDate = new Result(false, "生成文件失败！");
		}
		return null;
	}
		

	
	
	
	
	//生成word文档
	private String  createWord_task(String id, HttpServletResponse response)
	{
		
		String  resutl="";
		// 文件路径
		String filePath = TEMP_FILE_PATH;
				
		// 文件名称
		String fileName;
		try {
			
			SreProjectTask sreProjectTask =EquipmentUtils.getSreProjectTask(id,restTemplate,httpHeaders);
			
			String taskCheckContents=sreProjectTask.getTaskCheckContents();
			SreProject sreProject=null;
			String projectId=sreProjectTask.getTopicId();
			if(!projectId.equals(""))
			{
				
				sreProject=EquipmentUtils.getSreProject(projectId,restTemplate,httpHeaders);
				
			}
			
			Map<String, Object> dataMap = new HashMap<String, Object>();
			/** 组装数据 */
			dataMap.put("name", sreProject.getName());//项目名称
			dataMap.put("leadUnitName", sreProject.getLeadUnitName());//乙方
			dataMap.put("taskMainTaskContent", sreProjectTask.getTaskMainTaskContent());//项目目标
			dataMap.put("beginProjectMonth", sreProjectTask.getBeginProjectMonth());//项目执行年限
			dataMap.put("endProjectMonth", sreProjectTask.getEndProjectMonth());//项目执行年限
			dataMap.put("contractNum", sreProject.getContractNum());
			
			List<String> unitNameList = new ArrayList<String>();
			unitNameList.add(sreProjectTask.getLeadUnitName());
			String joinUnitName=sreProjectTask.getJoinUnitName();
			if(joinUnitName!=null && !joinUnitName.equals(""))
			{
				String arr[]=joinUnitName.split(",");
				for(int i=0;i<arr.length;i++)
				{
					unitNameList.add(arr[i]);
				}
			}
			dataMap.put("unitNameList", unitNameList);//牵头单位+参与单位
			
			//项目内容和主要图表
			Float hj_tc=0f;
			List<Map<String, Object>> taskContentList = new ArrayList<Map<String, Object>>();
			String taskContentStr=sreProjectTask.getTaskContent();
			String taskContent_arr[]=taskContentStr.split("\\|");
			if(taskContent_arr!=null && taskContent_arr.length>0)
			{
			   for(int i=0;i<taskContent_arr.length;i++)
			   {
				   String str=taskContent_arr[i];
				   if(str!=null && !str.equals(""))
				   {
					   String temp[]=str.split("#");
					   System.out.println("----length--"+temp.length);
					   Map<String, Object> map = new HashMap<String, Object>();
					   String taskContent1=temp[0].trim();
					   String taskContent2=temp[1].trim();
					   String taskContent3=temp[2].trim();
					   String taskContent4=temp[3].trim();
					   hj_tc=hj_tc.floatValue()+Float.valueOf(taskContent4.trim()).floatValue();
					   String taskContent5=temp[4];
					   map.put("taskc1", taskContent1);
					   map.put("taskc2", taskContent2);
					   map.put("taskc3", taskContent3);
					   map.put("taskc4", taskContent4);
					   map.put("taskc5", taskContent5);
					   taskContentList.add(map);
					   
				   }
			   }
			}
			dataMap.put("taskContentList", taskContentList);
			int taskContentListCount=taskContentList.size();
			dataMap.put("taskContentListCount", taskContentListCount);//项目内容和主要图表-数量
			dataMap.put("hj_tc", hj_tc);//项目内容和主要图表-经费合计
			JSONArray taskContentList_jSONArray= JSONArray.parseArray(JSON.toJSONString(taskContentList));
			System.out.println("---------项目内容和主要图表    源: "+taskContentStr);
			System.out.println("---------项目内容和主要图表 FTL: "+taskContentList_jSONArray.toString());
			
			//计划进度和考核目标
			List<Map<String, Object>> taskAssessmentList = new ArrayList<Map<String, Object>>();
			String taskAssessmenStr=sreProjectTask.getTaskAssessmentContent();
			String taskAssessmenStr_arr[]=taskAssessmenStr.split("\\|");//多行
			if(taskAssessmenStr_arr!=null && taskAssessmenStr_arr.length>0)
			{
			   for(int i=0;i<taskAssessmenStr_arr.length;i++)
			   {
				   String str=taskAssessmenStr_arr[i];
				   if(str!=null && !str.equals(""))
				   {
					   String temp[]=str.split("#");
					   Map<String, Object> map = new HashMap<String, Object>();
					   String taskContent1=temp[0].trim();
					   String taskContent2=temp[1].trim();
					   String taskContent3=temp[2].trim();
					   map.put("ta1", taskContent1);
					   map.put("ta2", taskContent2);
					   map.put("ta3", taskContent3);
					   taskAssessmentList.add(map);
					   
				   }
			   }
			}
			dataMap.put("taskAssessmentList", taskAssessmentList);
			System.out.println("---------计划进度和考核目标    源: "+taskAssessmenStr);
			JSONArray taskAssessmentList_jSONArray= JSONArray.parseArray(JSON.toJSONString(taskAssessmentList));
			System.out.println("---------计划进度和考核目标 FTL: "+taskAssessmentList_jSONArray.toString());
			
			//应提交验收的内容
			List<Map<String, Object>> taskCheckContentsList = new ArrayList<Map<String, Object>>();
			List<SysDictionary>  dicList= CommonUtil.getDictionaryByParentCode("ROOT_ZBGL_YTJYSDNR", restTemplate, httpHeaders);
			JSONArray jSONArray= JSONArray.parseArray(JSON.toJSONString(dicList));
			List<SysDictionary> list = JSONObject.parseArray(jSONArray.toJSONString(), SysDictionary.class);
			if(list!=null && list.size()>0)
			{
				
				System.out.println("----------应提交验收的内容: "+jSONArray.toString());
				for(int i=0;i<list.size();i++)
				{
					 SysDictionary  sysDictionary=list.get(i);
					 String code=sysDictionary.getCode();
					 Map<String, Object> map = new HashMap<String, Object>();
					 map.put("tct1", i+1);
					 map.put("tct2", sysDictionary.getName());
					 String tct3="□";
					 String str_arr[]=taskCheckContents.split(",");
					 if(str_arr!=null)
					 {
						 for(int j=0;j<str_arr.length;j++)
						 {
							 String temp_code=str_arr[j];
							 if(temp_code.equals(code))
							 {
								 tct3="√";
							 }
						 }
					 }
					 map.put("tct3",tct3);
					 taskCheckContentsList.add(map);
				}
			}
			dataMap.put("taskCheckContentsList", taskCheckContentsList);
			
			System.out.println("---------应提交验收的内容    源: "+taskCheckContents);
			JSONArray taskCheckContentsList_jSONArray= JSONArray.parseArray(JSON.toJSONString(taskCheckContentsList));
			System.out.println("---------应提交验收的内容  FTL: "+taskCheckContentsList_jSONArray.toString());
			
			
			
			//资金概算表
			String budgetTableStr=sreProjectTask.getBudgetTable();
			Map resultMap= EquipmentUtils.getBudgetTableList(budgetTableStr);
			List<Map<String, Object>> budgetTableStrList_zb =(List<Map<String, Object>>)resultMap.get("budgetTableStrList_zb");
			List<Map<String, Object>> budgetTableStrList_fy =(List<Map<String, Object>>)resultMap.get("budgetTableStrList_fy");
			
			Float budgetTable_hj =(Float)resultMap.get("budgetTable_hj");
			dataMap.put("budgetTableStrList_zb", budgetTableStrList_zb);
			dataMap.put("budgetTableStrList_fy", budgetTableStrList_fy);
			dataMap.put("budgetTable_hj", budgetTable_hj);
			
			
			
			///预计资金来源表
			List<Map<String, Object>> fundsSourcesTableList = new ArrayList<Map<String, Object>>();
			String fundsSourcesTableStr=sreProjectTask.getFundsSourcesTable();
			String fundsSourcesTableStr_arr[]=fundsSourcesTableStr.split("\\|");//多行
			if(fundsSourcesTableStr_arr!=null && fundsSourcesTableStr_arr.length>0)
			{
			   for(int i=0;i<fundsSourcesTableStr_arr.length;i++)
			   {
				   String str=fundsSourcesTableStr_arr[i];
				   if(str!=null && !str.equals(""))
				   {
					   String temp[]=str.split("#");
					   Map<String, Object> map = new HashMap<String, Object>();
					   String taskContent1=temp[0].trim();
					   String taskContent2=temp[1].trim();
					   String taskContent3=temp[2].trim();
					   String taskContent4=temp[3].trim();
					   String taskContent5=temp[4].trim();
					  // String taskContent6=temp[5];
					   
					   map.put("ft1", taskContent1);
					   map.put("ft2", taskContent2);
					   map.put("ft3", taskContent3);
					   map.put("ft4", taskContent4);
					   map.put("ft5", taskContent5);
					  // map.put("ft6", taskContent6);
					   Float ft6=Float.parseFloat(taskContent2)+Float.parseFloat(taskContent3)+Float.parseFloat(taskContent4)+Float.parseFloat(taskContent5);
					   map.put("ft6", ft6);
					   fundsSourcesTableList.add(map);
					   
				   }
			   }
			}
			dataMap.put("fundsSourcesTableList", fundsSourcesTableList);
			
			
			System.out.println("---------预计资金来源表 （源）: "+fundsSourcesTableStr);
			JSONArray fundsSourcesTableList_jSONArray= JSONArray.parseArray(JSON.toJSONString(fundsSourcesTableList));
			System.out.println("---------预计资金来源表 （FTL） : "+fundsSourcesTableList_jSONArray.toString());
			
			
			
			
			//项目资金安排
			List<Map<String, Object>> projectFundsTableList = new ArrayList<Map<String, Object>>();
			String projectFundsTableStr=sreProjectTask.getProjectFundsTable();
			String projectFundsTableStr_arr[]=projectFundsTableStr.split("#");//多行
			double hj_pt2=0l;
			double hj_pt3=0l;
			double hj_pt4=0l;
			if(projectFundsTableStr_arr!=null && projectFundsTableStr_arr.length>0)
			{
			   for(int i=0;i<projectFundsTableStr_arr.length;i++)
			   {
				   String str=projectFundsTableStr_arr[i];
				   System.out.println("----------项目资金安排--str: "+str);
				   if(str!=null && !str.equals(""))
				   {
					   String temp[]=str.split(",");
					   Map<String, Object> map = new HashMap<String, Object>();
					   String pt1=temp[0];
					   String pt2=temp[1].trim();
					   double pt2_double= Double.valueOf(pt2).doubleValue();
					   hj_pt2=hj_pt2+pt2_double;
					   String pt3=temp[2].trim();
					   double pt3_double= Double.valueOf(pt3).doubleValue();
					   hj_pt3=hj_pt3+pt3_double;
					   String pt4=temp[3].trim();
					   double pt34_double= Double.valueOf(pt4).doubleValue();
					   hj_pt4=hj_pt4+pt34_double;
					   map.put("pt1", pt1);
					   map.put("pt2", pt2);
					   map.put("pt3", pt3);
					   map.put("pt4", pt4);
					   projectFundsTableList.add(map);
					   
				   }
			   }
			}
			
			Map<String, Object> map_temp_pt = new HashMap<String, Object>();
			map_temp_pt.put("pt1", "合  计");
			map_temp_pt.put("pt2", hj_pt2);
			map_temp_pt.put("pt3", hj_pt3);
			map_temp_pt.put("pt4", hj_pt4);
			System.out.println("==========hj_pt2"+hj_pt2+"pt3="+hj_pt3);
			projectFundsTableList.add(map_temp_pt);
			dataMap.put("projectFundsTableList", projectFundsTableList);
			
			System.out.println("---------项目资金安排 （源）: "+projectFundsTableStr);
			JSONArray projectFundsTableList_jSONArray= JSONArray.parseArray(JSON.toJSONString(projectFundsTableList));
			System.out.println("---------项目资金安排（FTL） : "+projectFundsTableList_jSONArray.toString());
			
			
			//项目资金安排--参与单位
			String yearFeeStrJoinUnit=sreProjectTask.getYearFeeStrJoinUnit();
			List<JoinUnitWord> joinUnitWordlist=EquipmentUtils.getJoinUnitWordList(yearFeeStrJoinUnit);
			dataMap.put("joinUnitWordlist", joinUnitWordlist);
		
			
			
			fileName =DateUtil.dateToStr(new Date(), DateUtil.FMT_SSS_02)+".doc";
			/** 生成word */
			boolean flage=WordUtil.createWord(dataMap, "task.ftl", filePath, fileName);
			if(flage==true)
			{
				resutl=fileName;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resutl;
	}
	
	
	
	
	
	   
	
	
	public HttpServletResponse download(String path, HttpServletResponse response) 
	{
        try {
            // path是指欲下载的文件的路径。
            File file = new File(path);
            // 取得文件名。
            String filename = file.getName();
            // 取得文件的后缀名。
            String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();

            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(path));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.setCharacterEncoding("UTF-8");
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return response;
    }
	
	
	
	
	 public  boolean deleteFile(String fileName)
	 {
	        File file = new File(fileName);
	        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
	        if (file.exists() && file.isFile())
	        {
	            if (file.delete())
	            {
	                System.out.println("删除单个文件" + fileName + "成功！");
	                return true;
	            } else 
	            {
	                System.out.println("删除单个文件" + fileName + "失败！");
	                return false;
	            }
	        } else 
	        {
	            System.out.println("删除单个文件失败：" + fileName + "不存在！");
	            return false;
	        }
	    }

}
