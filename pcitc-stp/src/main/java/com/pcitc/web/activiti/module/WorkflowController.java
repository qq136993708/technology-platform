package com.pcitc.web.activiti.module;

import java.io.IOException;
import java.util.Arrays;
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
import com.pcitc.base.common.Result;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.workflow.SysFunctionProdef;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.OperationFilter;

@Controller
public class WorkflowController extends BaseController {

	private static final String GET_FUNCTION_COMPLETE_TREE = "http://pcitc-zuul/system-proxy/function-provider/function/complete-function-tree";

	private static final String FUNCTION_PROCESS_DEFINE_PAGE = "http://pcitc-zuul/system-proxy/workflow-provider/function/process-list";
	private static final String FUNCTION_PROCESS_DEFINE_ADD = "http://pcitc-zuul/system-proxy/workflow-provider/function/add-config";

	private static final String FUNCTION_CONFIG_DEL = "http://pcitc-zuul/system-proxy/workflow-provider/function/configures";

	private final static String PROCESS_DEF_LIST = "http://pcitc-zuul/system-proxy/workflow-provider/process/defines/list";

	private static final String START_WORKFLOW_URL = "http://pcitc-zuul/system-proxy/workflow-provider/workflow/start";

	private static final String AUDIT_FLAG_URL = "http://pcitc-zuul/system-proxy/task-provider/workflow/start/audit-type";

	private static final String PROJECT_LIST = "http://pcitc-zuul/epms-proxy/engin/preparation/Project-provider/project_list";
	
	/**
	 * 判断是否需要选择审批人,判断流程图的第一个审批节点的类型（通过id来区分）
	 */
	@RequestMapping(value = "/workflow/start/audit-type", method = RequestMethod.POST)
	@ResponseBody
	public Object processAuditFlag(@RequestBody String param, HttpServletRequest request) throws Exception {
		JSONObject reJson = JSONObject.parseObject(param);

		// param中有functionId（projectId、departmentId等属性）
		HttpEntity<JSONObject> entity = new HttpEntity<JSONObject>(reJson, this.httpHeaders);

		ResponseEntity<String> responseEntity = this.restTemplate.exchange(AUDIT_FLAG_URL, HttpMethod.POST, entity, String.class);
		String auditFlag = responseEntity.getBody();

		if (auditFlag != null) {
			System.out.println("1====================" + auditFlag);
			if (auditFlag.startsWith("role")) {
				System.out.println("role====================" + auditFlag.split("--")[1]);
				return new Result(true, auditFlag.split("--")[1], "启动成功", "role");
			} else if (auditFlag.startsWith("unit")) {
				return new Result(true, auditFlag.split("--")[1], "启动成功", "unit");
			} else if (auditFlag.startsWith("post")) {
				return new Result(true, auditFlag.split("--")[1], "启动成功", "post");
			} else if (auditFlag.equals("error-int")) {// 参数输入错误，缺少functionId
				return new Result(false, null, "启动失败", "int");
			} else if (auditFlag.equals("error-con")) {// 参数输入错误，缺少functionId
				return new Result(false, null, "启动失败", "con");
			} else if (auditFlag.startsWith("error-exist")) {// 参数输入错误，缺少functionId
				return new Result(false, auditFlag.split("-")[2], "启动失败", "exist");
			} else {
				return new Result(true, null, "启动成功", "common");
			}
		} else {
			return new Result(false, null, "启动失败", "error");
		}
	}

	@RequestMapping(value = "/workflow/test")
	public String iniWorkflowTest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("=====iniWorkflowTest");

		// SysUser userInfo = JwtTokenUtil.getUserFromToken(httpHeaders);
		// request.setAttribute("userInfo", userInfo);
		return "/pplus/workflow/workflow-example";
	}

	// 流程启动接口,多步审批
	@RequestMapping(value = "/workflow/start-flow2", method = RequestMethod.POST)
	@ResponseBody
	@OperationFilter(modelName = "系统管理", actionName = "启动工作流程（测试）")
	public Result startFlow2(@RequestBody String param, HttpServletRequest request) {
		System.out.println("=====/workflow/start-flow2");
		JSONObject json = JSONObject.parseObject(param);
		String businessId = UUID.randomUUID().toString().replaceAll("-", "");
		WorkflowVo workflowVo = new WorkflowVo();
		workflowVo.setBusinessId(businessId);
		workflowVo.setProcessInstanceName("业务任务名称：" + businessId.substring(0, 10));
		workflowVo.setAuthenticatedUserId(sysUserInfo.getUserId());
		workflowVo.setAuthenticatedUserName(sysUserInfo.getUserDisp());

		// 不清楚此功能菜单要走的审批流程。可以通过菜单id（functionId），部门/组织ID（orgId），项目id（projectId）。其中菜单id必填（和ProcessDefineId两选一）
		workflowVo.setFunctionId(json.getString("functionId"));
		// workflowVo.setUnitId("");
		// workflowVo.setProjectId("");

		Map<String, Object> variables = new HashMap<String, Object>();

		// 发起人之后的审批环节，如果是需要选择审批人的话，此处获取选择的userIds赋值给auditor变量
		if (json.getString("userIds") != null && !json.getString("userIds").equals("")) {
			String[] userIds = json.getString("userIds").split(",");
			variables.put("auditor", Arrays.asList(userIds));
		}

		// 必须设置，统一流程待办任务中需要的业务详情
		variables.put("auditDetailsPath", "/task/test/details/" + businessId);

		// 流程完全审批通过时，调用的方法
		variables.put("auditAgreeMethod", "http://pcitc-zuul/system-proxy/workflow-provider/task/agree/" + businessId);

		// 流程驳回时，调用的方法（可能驳回到第一步，也可能驳回到第1+n步
		variables.put("auditRejectMethod", "http://pcitc-zuul/system-proxy/workflow-provider/task/reject/" + businessId);

		// 对流程中出现的多个判断条件，比如money>100等，需要把事先把money条件输入
		//variables.put("money", 50); // 环节1需要用到
		//variables.put("departmentCode", "1005"); // 环节2需要用到
		variables.put("specialAuditor0", "ZSH_YFGCS_CJCXY"); // 环节n需要用到
		variables.put("specialAuditor1", "ZSH_YFGCS_CJCXY"); // 环节n需要用到
		variables.put("specialAuditor2", "ZSH_YFGCS_CJCXY"); // 环节n需要用到
		variables.put("specialAuditor3", "ZSH_YFGCS_CJCXY"); // 环节n需要用到
		
		
		// 会签时需要的属性，会签里所有的人，同意率（double类型）
		variables.put("signAuditRate", 1d); 

		workflowVo.setVariables(variables);
		ResponseEntity<String> status = this.restTemplate.exchange(START_WORKFLOW_URL, HttpMethod.POST, new HttpEntity<WorkflowVo>(workflowVo, this.httpHeaders), String.class);
		System.out.println("123=================启动成功" + status.getBody());
		if (status.getBody() != null && status.getBody().equals("true")) {
			System.out.println("=================启动成功");
			return new Result(true, "启动成功");
		} else {
			System.out.println("=================启动失败");
			return new Result(false, "启动失败");
		}

	}

	/**
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 *             初始化菜单配置流程的页面，给每个流程配置一个或多个流程，可选属性为项目、部门
	 */
	@RequestMapping(value = "/workflow/function/config")
	public String iniWorkflowFunctionConfig(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String basePath = request.getContextPath();
		System.out.println("=====/workflow/function/config" + basePath);
		request.setAttribute("basePath", basePath);

		return "/pplus/workflow/function-workflow";
	}

	/**
	 * @param param
	 * @param request
	 * @return 获取某个菜单中，已经配置工作流定义、项目、部门等信息
	 */
	@RequestMapping(value = "/workflow/function/process-list", method = RequestMethod.POST)
	@ResponseBody
	public Object functionProcessDefineList(HttpServletRequest request) {
		System.out.println("====/workflow/function/process-list");

		String iDisplayStart = request.getParameter("page"); // 起始索引
		String iDisplayLength = request.getParameter("limit"); // 每页显示的行数
		String functionId = request.getParameter("functionId");
		String functionName = request.getParameter("functionName");
		System.out.println(functionId + "==========" + iDisplayLength + "========" + iDisplayStart);
		JSONObject param1 = new JSONObject();
		JSONObject param2 = new JSONObject();
		JSONObject param3 = new JSONObject();
		JSONObject param4 = new JSONObject();
		param1.put("name", "iDisplayStart");
		param1.put("value", iDisplayStart);
		param2.put("name", "iDisplayLength");
		param2.put("value", iDisplayLength);
		param3.put("name", "functionId");
		param3.put("value", functionId);
		param4.put("name", "functionName");
		param4.put("value", functionName);
		if (functionId == null || functionId.equals("")) {
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("code", "0");
			jsonObj.put("msg", "提示");
			jsonObj.put("count", 0);
			jsonObj.put("data", null);
			return jsonObj.toString();
		}
		JSONArray param = new JSONArray();
		param.add(param1);
		param.add(param2);
		param.add(param3);
		param.add(param4);
		httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
		requestBody.add("jsonStr", param.toJSONString());
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);

		ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(FUNCTION_PROCESS_DEFINE_PAGE, HttpMethod.POST, entity, JSONObject.class);
		JSONObject retJson = responseEntity.getBody();
		Long totalCount = retJson.get("totalCount") != null ? Long.parseLong(retJson.get("totalCount").toString()) : 0l;
		List<SysFunctionProdef> pendingList = JSONArray.parseArray(retJson.getJSONArray("list").toString(), SysFunctionProdef.class);

		JSONObject jsonObj = new JSONObject();
		jsonObj.put("code", "0");
		jsonObj.put("msg", "提示");
		jsonObj.put("count", totalCount);
		jsonObj.put("data", pendingList);

		return jsonObj.toString();
	}

	/**
	 * 批量删除某一个菜单的工作流配置。如果通过某一个值进行删除可以用：@PathVariable
	 * 
	 * @param functionProdefId
	 * @param request
	 * @return
	 * 
	 */
	@RequestMapping(value = "/workflow/function/configures", method = RequestMethod.POST)
	@ResponseBody
	@OperationFilter(modelName = "系统管理", actionName = "删除工作流菜单配置")
	public Result deleteFunctionProdef(@RequestBody SysFunctionProdef sysFunctionProdef) {
		System.out.println("deleteFunctionProdef=================-----------" + sysFunctionProdef.getFunctionProdefId());
		HttpEntity<SysFunctionProdef> entity = new HttpEntity<SysFunctionProdef>(sysFunctionProdef, this.httpHeaders);

		Integer retI = this.restTemplate.exchange(FUNCTION_CONFIG_DEL, HttpMethod.DELETE, entity, Integer.class).getBody();

		System.out.println("=================-----------" + retI);
		if (retI != null && retI >= 1) {
			System.out.println("=================操作成功");
			return new Result(true, "操作成功");
		} else {
			System.out.println("=================操作失败");
			return new Result(false, "操作失败");
		}
	}

	/**
	 * 初始化界面：给某个菜单配置部门、项目等信息
	 * 
	 * @param functionId
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/workflow/function/add/{functionId}")
	public String iniFunctionProcessDefine(@PathVariable("functionId") String functionId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("1========/workflow/function/add=========" + functionId);
		request.setAttribute("userInfo", sysUserInfo);
		
		return "/pplus/workflow/prodef-add";
	}
	
	/**
	 * 跳转到选择工作流定义页面
	 */
	@RequestMapping(value = "/workflow/function-config/ini-workflow-define")
	public String iniProcessForConfig(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/pplus/workflow/workflow-define-list";
	}
	
	/**
	 * 选择生效的工作流定义
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/workflow/function-config/workflow-define-list", method = RequestMethod.POST)
	@ResponseBody
	public Object getWorkflowDefineListForTable(@ModelAttribute("param") LayuiTableParam param) {
		System.out.println("====--------/workflow/function-config/workflow-define-list");
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(PROCESS_DEF_LIST, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();
		return JSON.toJSON(retJson).toString();
	}
	
	/**
	 * 跳转到选择工程项目页面
	 */
	@RequestMapping(value = "/workflow/function-config/ini-project-list")
	public String iniProjectListForConfig(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/pplus/workflow/project-list";
	}
	
	/**
	 * 选择生效的项目
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/workflow/function-config/project-list", method = RequestMethod.POST)
	@ResponseBody
	public Object getProjectListForTable(@ModelAttribute("param") LayuiTableParam param) {
		Map<String, Object> map = param.getParam();
		map.put("projectCondition", "0");
		param.setParam(map);
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
	    ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(PROJECT_LIST, HttpMethod.POST, entity, LayuiTableData.class);
	    LayuiTableData result = responseEntity.getBody();
	    CommonUtil.addAttachmentField(result, restTemplate, httpHeaders);
	    JSONObject retJson = (JSONObject) JSON.toJSON(result);
		return retJson;
	}
	

	/**
	 * 保存配置,同一个菜单同一种配置只能有一个配置
	 * 
	 * @param param
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/workflow/function/prodef/save", method = RequestMethod.POST)
	@ResponseBody
	@OperationFilter(modelName = "系统管理", actionName = "新增工作流菜单配置")
	public Result functionProdefInsert(@RequestBody SysFunctionProdef prodef, HttpServletRequest request) throws Exception {
		prodef.setFunctionProdefId(UUID.randomUUID().toString().replaceAll("-", ""));
		if (prodef.getProjectId() != null && prodef.getProjectId().equals("")) {
			prodef.setProjectId(null);
		}
		if (prodef.getUnitValue() != null && prodef.getUnitValue().equals("")) {
			prodef.setUnitValue(null);
		}
		prodef.setUnitName(prodef.getUnitShow());
		prodef.setStatus("1");
		prodef.setCreateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));

		int retI = this.restTemplate.exchange(FUNCTION_PROCESS_DEFINE_ADD, HttpMethod.POST, new HttpEntity<SysFunctionProdef>(prodef, this.httpHeaders), Integer.class).getBody();
		if (retI >= 1) {
			System.out.println("=================操作成功---" + retI);
			return new Result(true, "操作成功");
		} else if (retI == -1) {
			System.out.println("=================操作失败---" + retI);
			return new Result(false, "此菜单已经配置，请删除后再配置");
		} else {
			System.out.println("=================操作失败---" + retI);
			return new Result(false, "操作失败");
		}
	}

}
