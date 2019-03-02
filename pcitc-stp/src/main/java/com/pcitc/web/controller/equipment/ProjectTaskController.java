package com.pcitc.web.controller.equipment;

import java.io.File;
import java.io.IOException;
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
import com.pcitc.base.stp.equipment.SreProject;
import com.pcitc.base.stp.equipment.SreProjectTask;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.workflow.Constants;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.WordUtil;

@Controller
@RequestMapping(value = "/sre_project_task")
public class ProjectTaskController extends BaseController {


	private static final String PAGE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/project_task/page";
	private static final String ADD_URL = "http://pcitc-zuul/stp-proxy/sre-provider/project_task/add";
	private static final String UPDATE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/project_task/update";
	private static final String DEL_URL = "http://pcitc-zuul/stp-proxy/sre-provider/project_task/delete/";
	private static final String BATCH_DEL_URL = "http://pcitc-zuul/stp-proxy/sre-provider/project_task/batch-delete/";
	private static final String GET_URL = "http://pcitc-zuul/stp-proxy/sre-provider/project_task/get/";
	// 流程操作--同意
	private static final String AUDIT_AGREE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/project_task/task/agree/";
	// 流程操作--拒绝
	private static final String AUDIT_REJECT_URL = "http://pcitc-zuul/stp-proxy/sre-provider/project_task/task/reject/";
	
	private final static String process_define_id4 = "equitmentApplyProcess:1:1172522";
	
	private static final String GET_PROJECT_URL = "http://pcitc-zuul/stp-proxy/sre-provider/project_basic/get/";


	@RequestMapping(value = "/to_list")
	public String list(HttpServletRequest request, HttpServletResponse response) {
		return "/stp/equipment/task/project_task_list";
	}

	@RequestMapping(value = "/list")
	@ResponseBody
	public String ajaxlist(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {
		
		JSONObject parmamss = JSONObject.parseObject(JSONObject.toJSONString(param));
		logger.info("============参数：" + parmamss.toString());
		
		
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
			SreProject sreProject=getSreProject(topicId);
			request.setAttribute("sreProject", sreProject);
		}
		if(!taskId.equals(""))
		{
			ResponseEntity<SreProjectTask> responseEntity = this.restTemplate.exchange(GET_URL + taskId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreProjectTask.class);
			int statusCode = responseEntity.getStatusCodeValue();
		
			SreProjectTask sreProjectTask = responseEntity.getBody();
			request.setAttribute("sreProjectTask", sreProjectTask);
			topicId=sreProjectTask.getTopicId();
			if(!topicId.equals(""))
			{
				SreProject sreProject=getSreProject(topicId);
				request.setAttribute("sreProject", sreProject);
			}
		}
		request.setAttribute("documentDoc", documentDoc);
		request.setAttribute("leadUnitName", leadUnitName);
		request.setAttribute("leadUnitCode", leadUnitCode);
		request.setAttribute("createUserId", createUserId);
		List<SysDictionary>  dicList= CommonUtil.getDictionaryByParentCode("ROOT_ZBGL_YTJYSDNR", restTemplate, httpHeaders);
		request.setAttribute("dicList", dicList);
		return "/stp/equipment/task/project_task_add";
	}
	
	private SreProject getSreProject(String id)
	{
		SreProject	sreProjectBasic = null;
		ResponseEntity<SreProject> responseEntity = this.restTemplate.exchange(GET_PROJECT_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreProject.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200)
		{
			sreProjectBasic = responseEntity.getBody();
		}
		return sreProjectBasic;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/project_basic_add_selectapply")
	private String project_basic_add_selectapply(HttpServletRequest request) 
	{
		String plantId = request.getParameter("equipmentIds");
		request.setAttribute("equipmentIds", plantId==null?IdUtil.createIdByTime():plantId);
		
		return "/stp/equipment/task/project_basic_add_selectapply";
		
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
		String auditStatus = CommonUtil.getParameter(request, "auditStatus", Constant.AUDIT_STATUS_DRAFT);
		String userIds = CommonUtil.getParameter(request, "userIds", "");
		String budgetTable = CommonUtil.getParameter(request, "budgetTable", "");
		String fundsSourcesTable = CommonUtil.getParameter(request, "fundsSourcesTable", "");
		String notes = CommonUtil.getParameter(request, "notes", "");
		String contractNum = CommonUtil.getParameter(request, "contractNum", "");
		String projectFundsTable = CommonUtil.getParameter(request, "projectFundsTable", "");
		String leadUnitName = CommonUtil.getParameter(request, "leadUnitName", "");
		String projectNotice = CommonUtil.getParameter(request, "projectNotice", "");
		String taskMainTaskContent = CommonUtil.getParameter(request, "taskMainTaskContent", "");
		String taskContent = CommonUtil.getParameter(request, "taskContent", "");
		String isWorkFlow = CommonUtil.getParameter(request, "isWorkFlow", "0");
	
		String taskAssessmentContent = CommonUtil.getParameter(request, "taskAssessmentContent", "");
		String functionId = CommonUtil.getParameter(request, "functionId", "");
		String topicId = CommonUtil.getParameter(request, "topicId", "");
		
		StringBuffer taskCheckContents = new StringBuffer();
		String arr[]=request.getParameterValues("taskCheckContents");
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
			sreProjectBasic.setCreateUserId(sysUserInfo.getUserId());
			sreProjectBasic.setCreateUserName(sysUserInfo.getUserDisp());
			//String code = CommonUtil.getTableCode("XTBM_0032", restTemplate, httpHeaders);
			String idv = UUID.randomUUID().toString().replaceAll("-", "");
			sreProjectBasic.setTaskId(idv);
			sreProjectBasic.setAuditStatus(auditStatus);
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
		
		SreProject sreProject=this.getSreProject(topicId);
		if(sreProject!=null)
		{
			sreProjectBasic.setTopicName(sreProject.getName());
			sreProjectBasic.setJoinUnitCode(sreProject.getJoinUnitCode());
			sreProjectBasic.setJoinUnitName(sreProject.getJoinUnitName());
			sreProjectBasic.setLeadUnitCode(sreProject.getLeadUnitCode());
			sreProjectBasic.setLeadUnitName(sreProject.getLeadUnitName());
			sreProjectBasic.setProjectMoney(sreProject.getProjectMoney());
			sreProjectBasic.setProjectFundsTable(sreProject.getYearFeeStr());
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
		sreProjectBasic.setApplyUnitCode(sysUserInfo.getUnitCode());
		sreProjectBasic.setApplyUnitName(sysUserInfo.getUnitName());
		
		
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
			//如果是提交
			if(isWorkFlow.equals("1"))
			{
				String dataId = sreProjectBasic.getTaskId();
				// 处理流程相关信息
				boolean flowFlag = dealProjectWorkFlow(dataId, functionId,sysUserInfo, "任务书:"+sreProjectBasic.getTaskId(), userIds, httpHeaders);
				if (flowFlag == true)
				{
					resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
				} else 
				{
					resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
				}
			}
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
	
	

	/**
	 * 加入流程信息
	 * 
	 * @param id
	 * @param instanceName
	 * @param sysUser
	 */
	private boolean dealProjectWorkFlow(String id,String functionId, SysUser sysUser, String instanceName, String userIds, HttpHeaders httpHeaders)
	{
		WorkflowVo workflowVo = new WorkflowVo();
		workflowVo.setBusinessId(String.valueOf(id));
		workflowVo.setProcessInstanceName(instanceName);
		workflowVo.setAuthenticatedUserId(sysUser.getUserId());
		workflowVo.setAuditUserIds(sysUser.getUserId());
		// process_define_id和functionId，两种方式二选一
		// 清楚知道自己要走的流程定义id
		workflowVo.setProcessDefineId(process_define_id4);
		// 不清楚此功能菜单要走的审批流程。可以通过菜单id（functionId），部门/组织ID（orgId），项目id（id）。其中菜单id必填（和ProcessDefineId两选一）
		workflowVo.setFunctionId(functionId);
		workflowVo.setProjectId("");
		Map<String, Object> variables = new HashMap<String, Object>();
		//variables.put("starter", workflowVo.getAuthenticatedUserId());
		
		 //必须设置。流程中，需要的第二个节点的指派人；除starter外，所有待办人变量都指定为auditor(处长审批)
        //处长审批 ZSH_JTZSZYC_GJHZC_CZ
		/*ResponseEntity<List> responseEntity = this.restTemplate.exchange(get_user_bypostcode + "ZSH_JTZSZYC_GJHZC_CZ", HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class);
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
	        
		}*/
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
			SreProjectTask	sreProject = this.getSreProjectTask(id);
			sreProject.setAuditStatus(Constant.AUDIT_STATUS_SUBMIT);
			this.updateSreProject(sreProject);
			return true;
		} else
		{
			System.out.println("=================流程启动失败");
			return false;
		}
	}
	
	
	
	private String updateSreProject(SreProjectTask sreProject)
	{
		String str="";
		ResponseEntity<String> responseEntity =this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SreProjectTask>(sreProject, this.httpHeaders), String.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200)
		{
			str = responseEntity.getBody();
		}
		return str;
	}
	
	
	private SreProjectTask getSreProjectTask(String id)
	{
		SreProjectTask	sreProjectBasic = null;
		ResponseEntity<SreProjectTask> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreProjectTask.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200)
		{
			sreProjectBasic = responseEntity.getBody();
		}
		return sreProjectBasic;
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
		ResponseEntity<SreProjectTask> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreProjectTask.class);
		int statusCode = responseEntity.getStatusCodeValue();
		logger.info("============远程返回  statusCode " + statusCode);
		SreProjectTask sreProjectTask = responseEntity.getBody();
		request.setAttribute("sreProjectTask", sreProjectTask);
		
		return "/stp/equipment/task/project_task_view";
	}
	

	
	
	
	@RequestMapping(value = "/createWord/{id}", method = RequestMethod.GET)
	public String createWordv(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		Result resultsDate = new Result();
		String fileName=createWord(id);
		if (!fileName.equals("")) {
			resultsDate = new Result(true);
		} else {
			resultsDate = new Result(false, "生成文件失败！");
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		out.println(ob.toString());
		out.flush();
		out.close();
		return null;
	}
	
	
	
	//生成word文档
	private String  createWord(String id)
	{
		SreProjectTask sreProjectTask=this.getSreProjectTask(id);
		SreProject sreProject=null;
		String projectId=sreProjectTask.getTopicId();
		if(!projectId.equals(""))
		{
			sreProject=getSreProject(projectId);
		}
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		/** 组装数据 */
		dataMap.put("titleName", "测试标题");
		dataMap.put("userName", "张海峰");
		dataMap.put("userCode", "1001");

		// 文件路径
		String filePath = "D://doc";

		/*List<Map<String, Object>> newsList = new ArrayList<Map<String, Object>>();
		for (int i = 1; i<=10; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("show1", "测试"+i);
			map.put("show2", "137"+i);
			map.put("show3", "年龄"+i);
			map.put("show4", System.currentTimeMillis());
			newsList.add(map);
		}
		dataMap.put("myListData", newsList);*/
		
		dataMap.put("taskMainTaskContent", sreProjectTask.getTaskMainTaskContent());

	   /*String myPic = "";  
        try {  
             myPic = WordUtil.getImageString("D://doc//20190218155218.jpg");  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
         
        dataMap.put("showPicture", myPic);  */
		
		
		// 文件名称
		String fileName = System.currentTimeMillis()+".doc";

		/** 生成word */
		WordUtil.createWord(dataMap, "task.ftl", filePath, fileName);
		return filePath+File.separator+fileName;
	}
	
	
	

}
