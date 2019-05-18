package com.pcitc.web.activiti.module;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Page;
import com.pcitc.base.common.Result;
import com.pcitc.base.workflow.ActivityVo;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.OperationFilter;

/**
 * @author zhf
 * @date 2018年4月20日 上午10:27:55 任务控制器
 */
@Controller
public class TaskController extends BaseController {

	private static final String DIR_PATH = "";

	// 待办任务列表
	private static final String PENDING_PAGE_URL = "http://pcitc-zuul/system-proxy/task-provider/pending-page";
	private static final String PENDING_PAGE_URL_MOBILE = "http://pcitc-zuul/system-proxy/task-provider/pending_page_mobile";
	// 已办任务列表（每行代表一个流程）
	private static final String DONE_INSTANCE_PAGE_URL = "http://pcitc-zuul/system-proxy/task-provider/done-instance-page";
	// 已办任务列表（每行代表一个任务）
	private static final String DONE_TASK_PAGE_URL = "http://pcitc-zuul/system-proxy/task-provider/done-task-page";

	// 任务处理
	private static final String COMPLETE_TASK_URL = "http://pcitc-zuul/system-proxy/task-provider/task/complete";
	// 事例任务列表
	private static final String INSTANCE_TASK_PAGE_URL = "http://pcitc-zuul/system-proxy/task-provider/task/process/list/";

	// 获取审批人是自动配置，还是选择的标识
	private static final String AUDIT_FLAG_URL = "http://pcitc-zuul/system-proxy/task-provider/task/audit/flag/";

	// 获取下一步审批人
	private static final String DEAL_USER_URL = "http://pcitc-zuul/system-proxy/task-provider/task/deal/user";

	// 获取任务详情信息
	private static final String INI_DEAL_TASK = "http://pcitc-zuul/system-proxy/task-provider/deal/task/info";

	private static final String TASK_PROCESS_INFO = "http://pcitc-zuul/system-proxy/task-provider/task/process/info";
	private static final String BUSINESS_AUDIT_IMAGE = "http://pcitc-zuul/system-proxy/task-provider/task/business/audit/image";
	
	// 任务撤回操作
	private static final String TASK_RECALL = "http://pcitc-zuul/system-proxy/task-provider/task/recall/";

	// 消息列表
	private static final String MESSAGE_LIST = "http://pcitc-zuul/system-proxy/message-provider/message/list";
	
	// 事例任务列表
	private static final String BUSINESS_AUDIT_DETAIL = "http://pcitc-zuul/system-proxy/task-provider/task/business/audit/";
	
	/**
	 * 判断是否需要选择审批人
	 */
	@RequestMapping(value = "/task/auditor/flag/{taskId}")
	@ResponseBody
	public Object selectAuditorFlag(@PathVariable("taskId") String taskId, HttpServletRequest request, HttpServletResponse response) throws Exception {

		ResponseEntity<String> responseEntity = this.restTemplate.exchange(AUDIT_FLAG_URL + taskId, HttpMethod.POST, new HttpEntity<Object>(httpHeaders), String.class);
		String auditFlag = responseEntity.getBody();
		System.out.println("====/task/selectAuditorFlag-------------" + auditFlag);
		if (auditFlag != null) {
			if (auditFlag.startsWith("role")) {
				return new Result(true, auditFlag.split("--")[1], "操作成功", "role");
			} else if (auditFlag.startsWith("unit")) {
				return new Result(true, auditFlag.split("--")[1], "操作成功", "unit");
			} else if (auditFlag.startsWith("post")) {
				return new Result(true, auditFlag.split("--")[1], "操作成功", "post");
			} else {
				return new Result(true, null, "操作成功", "common");
			}
		} else {
			return new Result(true, null, "操作失败", "error");
		}

	}

	/**
	 * 跳转到通过角色选择用户的界面
	 */
	@RequestMapping(value = "/task/deal/users/ini")
	public String iniDealUser(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/pplus/workflow/deal-user-list";
	}
	
	/**
	 * 跳转消息列表
	 */
	@RequestMapping(value = "/task/message/list/ini")
	public String iniMessageList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/pplus/workflow/message-list";
	}
	
	/**
	 * @author zhf
	 * @date 2019年4月16日 上午10:28:42 消息列表数据
	 */
	@RequestMapping(value = "/task/message/list", method = RequestMethod.POST)
	@ResponseBody
	public Object getMessageListData(@ModelAttribute("param") LayuiTableParam param) {

		// 获取当前登录人信息
		param.getParam().put("userId", sysUserInfo.getUserId());
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(MESSAGE_LIST, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();

		return JSON.toJSON(retJson).toString();
	}
	
	/**
	 * 跳转消息详情
	 */
	@RequestMapping(value = "/task/message/details")
	public String messageDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/pplus/workflow/message-details";
	}
	
	/**
	 * 查询所有的下一个节点需要处理的人（角色用列表）
	 * 
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/task/deal/user", method = RequestMethod.POST)
	@ResponseBody
	public Object getDealUser(@ModelAttribute("param") LayuiTableParam param) {
		System.out.println("====/task/getDealUser---");
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(DEAL_USER_URL, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();

		return JSON.toJSON(retJson).toString();
	}

	/**
	 * 跳转到通过组织机构选择用户的界面
	 */
	@RequestMapping(value = "/task/deal/user/unit/ini")
	public String iniDealUserUnit(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/pplus/workflow/deal-user-unit";
	}

	@RequestMapping(value = "/task/pending/list/ini")
	public String iniPendingList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("iniPendingList----------------"+request.getParameter("functionId"));
		request.setAttribute("functionId", request.getParameter("functionId"));
		
		return "/pplus/workflow/pending-list";
	}

	@RequestMapping(value = "/task/done-task/list/ini")
	public String iniDoneTaskList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("iniDoneTaskList----------------"+request.getParameter("functionId"));
		request.setAttribute("functionId", request.getParameter("functionId"));
		
		return "/pplus/workflow/done-task-list";
	}

	@RequestMapping(value = "/task/done-instance/list/ini")
	public String iniDoneInstanceList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("iniDoneInstanceList----------------"+request.getParameter("functionId"));
		request.setAttribute("functionId", request.getParameter("functionId"));
		// response.addHeader("P3P", "CP=CAO PSA OUR");
		return "/pplus/workflow/done-instance-list";
	}

	/**
	 * @author zhf
	 * @date 2018年4月20日 上午10:28:42 待办任务列表
	 */
	@RequestMapping(value = "/task/pending-list", method = RequestMethod.POST)
	@ResponseBody
	public Object pendingList(@ModelAttribute("param") LayuiTableParam param) {

		
		System.out.println("====待办param-->"+JSON.toJSON(param).toString());
		
		// 获取当前登录人信息
		param.getParam().put("userId", sysUserInfo.getUserId());
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(PENDING_PAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();

		return JSON.toJSON(retJson).toString();
	}
	
	
	@RequestMapping(value = "/mobile/wait_task_list_mui")
	public String pending_list_mobile(HttpServletRequest request) {

		int pageNo = request.getParameter("pageNo") == null ? 1 : Integer.parseInt((String) request.getParameter("pageNo"));
		LayuiTableParam param= new LayuiTableParam();
		param.setPage(pageNo);
        // 获取当前登录人信息
		param.getParam().put("userId", sysUserInfo.getUserId());
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(PENDING_PAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();
		Page page =new Page();
		page.setRows(retJson.getData());
		page.setPageNo(pageNo);
		page.setPageSize(param.getLimit());
		page.setTotalRecords(retJson.getCount());
		request.setAttribute("page", page);
		request.setAttribute("list", page.getRows());
		return "/mobile/wait_task_list_mui";
	}
	

	/**
	 * @author zhf
	 * @date 2018年5月11日 上午11:28:43 初始化处理任务界面
	 */
	@RequestMapping(value = "/task/pending/deal/{taskId}")
	public String iniDealTask(@PathVariable("taskId") String taskId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("1=====iniDealTask====" + taskId);

		WorkflowVo workflowVo = new WorkflowVo();
		workflowVo.setTaskId(taskId);
		ResponseEntity<JSONObject> retJson = this.restTemplate.exchange(INI_DEAL_TASK, HttpMethod.POST, new HttpEntity<WorkflowVo>(workflowVo, this.httpHeaders), JSONObject.class);
		System.out.println("iniDealTask=====" + retJson.getBody());

		// 当前审批人信息
		request.setAttribute("userInfo", sysUserInfo);

		request.setAttribute("auditDetailsPath", retJson.getBody().get("auditDetailsPath"));
		request.setAttribute("id", retJson.getBody().get("id"));

		return "/pplus/workflow/deal-task";
	}

	/**
	 * @author zhf
	 * @date 2018年5月4日 下午4:31:47 已办任务列表（每行数据代表一个任务）
	 */
	@RequestMapping(value = "/task/done-task-list", method = RequestMethod.POST)
	@ResponseBody
	public Object doneTaskList(@ModelAttribute("param") LayuiTableParam param) {
		// 获取当前登录人信息
		param.getParam().put("userId", sysUserInfo.getUserId());

		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(DONE_TASK_PAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();

		return JSON.toJSON(retJson).toString();
	}
	
	
	
	@RequestMapping(value = "/mobile/done_task_list")
	public String done_task_list_mui(HttpServletRequest request) {

		int pageNo = request.getParameter("pageNo") == null ? 1 : Integer.parseInt((String) request.getParameter("pageNo"));
		LayuiTableParam param= new LayuiTableParam();
		param.setPage(pageNo);
        // 获取当前登录人信息
		param.getParam().put("userId", sysUserInfo.getUserId());
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(DONE_TASK_PAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();
		
		Page page =new Page();
		page.setRows(retJson.getData());
		page.setPageNo(pageNo);
		page.setPageSize(param.getLimit());
		page.setTotalRecords(retJson.getCount());
		request.setAttribute("page", page);
		request.setAttribute("list", page.getRows());
		return "/mobile/done_task_list";
	}
	

	/**
	 * @author zhf
	 * @date 2018年5月4日 下午4:31:47 已办任务列表（每行数据代表一个流程实例）
	 */
	@RequestMapping(value = "/task/done-instance-list", method = RequestMethod.POST)
	@ResponseBody
	public Object doneInstanceList(@ModelAttribute("param") LayuiTableParam param) {
		// 获取当前登录人信息
		param.getParam().put("userId", sysUserInfo.getUserId());

		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(DONE_INSTANCE_PAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();

		return JSON.toJSON(retJson).toString();
	}

	/**
	 * 任务办理
	 * 
	 * @author zhf
	 * @date 2018年4月23日 下午5:23:00
	 */
	@RequestMapping(value = "/task/complete/{taskId}", method = RequestMethod.POST)
	@ResponseBody
	@OperationFilter(modelName = "系统管理", actionName = "处理待办任务")
	public Result completeTask(@PathVariable("taskId") String taskId, @RequestBody String param, HttpServletRequest request) {
		System.out.println("动态获取的前台页面审批意见======" + param);
		JSONArray jsArr = JSONObject.parseArray(param);
		System.out.println("动态获取的前台页面审批意见======" + jsArr.getJSONObject(0));
		JSONObject json = jsArr.getJSONObject(0);
		WorkflowVo workflowVo = new WorkflowVo();
		workflowVo.setTaskId(taskId);
		// 本步审批人(名称为了以后查询方便)
		workflowVo.setAuditorId(sysUserInfo.getUserId());
		workflowVo.setAuditorName(sysUserInfo.getUserDisp());

		Map<String, Object> variables = new HashMap<String, Object>();

		// 传递参数的不同，本次参数名是agree，之后统一在参数中设置
		variables.put("agree", json.getString("agree"));
		variables.put("comment", json.getString("auditRemarks"));

		// 下一步的审批人。审批不通过时，退回到starter，通过画流程图时：开始节点和第一个节点的特定设置来自动完成
		// 下一步的审批人，要么通过此次审批时选择，要么通过角色进行的配置。
		if (json.getString("userIds") != null && !json.getString("userIds").equals("")) {
			// 前端已经选择审批人
			String[] candidateUsers = json.getString("userIds").split(",");
			System.out.println("前端已经选择审批人======" + json.getString("userIds"));
			variables.put("auditor", Arrays.asList(candidateUsers));
		} else {
			// 此时应该是通过角色、部门、特定人等方式已经特殊指定好了，不需要再配置
		}

		workflowVo.setVariables(variables);

		ResponseEntity<JSONObject> status = this.restTemplate.exchange(COMPLETE_TASK_URL, HttpMethod.POST, new HttpEntity<WorkflowVo>(workflowVo, httpHeaders), JSONObject.class);
		//System.out.println("=============completeTask=========" + status.getBody());
		if (status.getBody() != null && status.getBody().get("result") != null) {
			if (status.getBody().get("result").equals("1")) {
				// 流程结束，调用各个业务的审批通过后的业务处理方法
				//System.out.println("====auditAgreeMethod===============" + status.getBody().get("auditAgreeMethod").toString());
				this.restTemplate.exchange(status.getBody().get("auditAgreeMethod").toString(), HttpMethod.POST, new HttpEntity<Object>(httpHeaders), Integer.class).getBody();

			}
			if (status.getBody().get("result").equals("2")) {
				// 驳回，调用各个业务的审批驳回后的业务处理方法
				//System.out.println("====auditRejectMethod===============" + status.getBody().get("auditRejectMethod").toString());
				this.restTemplate.exchange(status.getBody().get("auditRejectMethod").toString(), HttpMethod.POST, new HttpEntity<Object>(httpHeaders), Integer.class).getBody();
			}
			return new Result(true, "启动成功");
		} else {
			return new Result(false, "启动失败");
		}

	}
	
	/**
	 * 通过业务id，查看此单据的审批信息
	 * 
	 * @author zhf
	 * @date 2019年4月23日 下午5:19:28
	 */
	@RequestMapping(value = "/task/business/audit/{dataId}", method = RequestMethod.GET)
	public String businessAuditDetail(@PathVariable("dataId") String dataId, HttpServletRequest request) {
		return "/pplus/workflow/business-audit-detail";
	}

	/**
	 * 流程监控--已审批、待审批/流程图片
	 * 
	 * @author zhf
	 * @date 2018年4月23日 下午5:19:28
	 */
	@RequestMapping(value = "/task/process/{instanceId}", method = RequestMethod.GET)
	public String processShow(@PathVariable("instanceId") String instanceId, HttpServletRequest request) {
		return "/pplus/workflow/process-show";
	}
	
	@RequestMapping(value = "/mobile/process_mobile/{instanceId}", method = RequestMethod.GET)
	public String process_mobile(@PathVariable("instanceId") String instanceId, HttpServletRequest request) {
		return "/pplus/workflow/process_mobile";
	}

	/**
	 * 显示流程的列表
	 * 
	 * @author zhf
	 * @date 2018年4月23日 下午5:19:25
	 */
	@RequestMapping(value = "/task/process/list/{instanceId}", method = RequestMethod.POST)
	@ResponseBody
	public Object processList(@PathVariable("instanceId") String instanceId, HttpServletRequest request) {

		System.out.println("1====processList====");
		httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		// 获取当前登录人信息
		JSONObject jsonStr = new JSONObject();
		jsonStr.put("page", request.getParameter("page")); // 起始索引
		jsonStr.put("limit", request.getParameter("limit")); // 每页显示的行数

		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
		requestBody.add("jsonStr", jsonStr.toJSONString());
		System.out.println("2====processList====" + jsonStr.toJSONString());
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, httpHeaders);

		ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(INSTANCE_TASK_PAGE_URL + instanceId, HttpMethod.POST, entity, JSONObject.class);
		JSONObject retJson = responseEntity.getBody();

		Long totalCount = retJson.get("totalCount") != null ? Long.parseLong(retJson.get("totalCount").toString()) : 0l;
		List<ActivityVo> auditList = JSONArray.parseArray(retJson.getJSONArray("list").toString(), ActivityVo.class);

		JSONObject jsonObj = new JSONObject();
		jsonObj.put("code", "0");
		jsonObj.put("msg", "提示");
		jsonObj.put("count", totalCount);
		jsonObj.put("data", auditList);
		System.out.println("2====processList====" + jsonObj.toString());
		return jsonObj.toString();
	}
	
	/**
	 * 显示流程的列表
	 * 
	 * @author zhf
	 * @date 2018年4月23日 下午5:19:25
	 */
	@RequestMapping(value = "/task/business/audit/detail/{dataId}", method = RequestMethod.POST)
	@ResponseBody
	public Object getBusinessAuditDetail(@PathVariable("dataId") String dataId, HttpServletRequest request) {

		httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		// 获取当前登录人信息
		JSONObject jsonStr = new JSONObject();
		jsonStr.put("page", request.getParameter("page")); // 起始索引
		jsonStr.put("limit", request.getParameter("limit")); // 每页显示的行数

		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
		requestBody.add("jsonStr", jsonStr.toJSONString());
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, httpHeaders);

		ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(BUSINESS_AUDIT_DETAIL + dataId, HttpMethod.POST, entity, JSONObject.class);
		JSONObject retJson = responseEntity.getBody();

		Long totalCount = retJson.get("totalCount") != null ? Long.parseLong(retJson.get("totalCount").toString()) : 0l;
		List<ActivityVo> auditList = JSONArray.parseArray(retJson.getJSONArray("list").toString(), ActivityVo.class);

		JSONObject jsonObj = new JSONObject();
		jsonObj.put("code", "0");
		jsonObj.put("msg", "提示");
		jsonObj.put("count", totalCount);
		jsonObj.put("data", auditList);
		System.out.println("====getBusinessAuditDetail====" + jsonObj.toString());
		return jsonObj.toString();
	}

	/**
	 * @author zhf
	 * @date 2018年4月20日 下午3:07:29 显示流程资源文件
	 *//*
	@RequestMapping(value = "/task/show/image/{pdId}", method = RequestMethod.GET)
	public String showResoure(@PathVariable("instanceId") String instanceId, HttpServletRequest request) {
		System.out.println("====task/show/image" + instanceId);

		Result image = generateImage(instanceId, request);
		request.setAttribute("image", image.getData());
		return "/pplus/workflow/process-show";
	}*/

	/**
	 * 生成流程实例的流程图片，并重点高亮当前节点，高亮已经执行的链路
	 * 
	 * @author zhf
	 * @date 2018年4月23日 下午5:42:11
	 */
	@RequestMapping(value = "/task/process/image/{instanceId}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String generateImage(@PathVariable("instanceId") String instanceId, HttpServletRequest request) {
		WorkflowVo workflowVo = new WorkflowVo();
		workflowVo.setInstanceId(instanceId);
		ResponseEntity<byte[]> fileStream = this.restTemplate.exchange(TASK_PROCESS_INFO, HttpMethod.POST, new HttpEntity<WorkflowVo>(workflowVo, this.httpHeaders), byte[].class);
		byte[] image = fileStream.getBody();
		OutputStream os = null;
		try {
			os = response.getOutputStream();
			os.write(image);
			os.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ok";
	}
	
	/**
	 * 生成流程实例的流程图片，并重点高亮当前节点，高亮已经执行的链路
	 * 
	 * @author zhf
	 * @date 2018年4月23日 下午5:42:11
	 */
	@RequestMapping(value = "/task/business/image/{dataId}", method = RequestMethod.GET)
	@ResponseBody
	public String getBusinessImageInfo(@PathVariable("dataId") String dataId, HttpServletRequest request) {
		WorkflowVo workflowVo = new WorkflowVo();
		workflowVo.setBusinessId(dataId);
		ResponseEntity<byte[]> fileStream = this.restTemplate.exchange(BUSINESS_AUDIT_IMAGE, HttpMethod.POST, new HttpEntity<WorkflowVo>(workflowVo, this.httpHeaders), byte[].class);
		byte[] image = fileStream.getBody();
		OutputStream os = null;
		try {
			os = response.getOutputStream();
			os.write(image);
			os.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ok";
	}
	
	/**
	 * @param taskId
	 * @param request
	 * @return
	 * 任务撤回
	 */
	@RequestMapping(value = "/task/recall/{taskId}", method = RequestMethod.POST)
	@ResponseBody
	public Object recallTask(@PathVariable("taskId") String taskId, HttpServletRequest request) {

		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, httpHeaders);

		ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(TASK_RECALL + taskId, HttpMethod.POST, entity, JSONObject.class);
		JSONObject retJson = responseEntity.getBody();

		// 撤回的节点如果是开始节点，执行审批不同意的方法
		System.out.println("2====processList====" + retJson.toString());
		return retJson.toString();
	}

}
