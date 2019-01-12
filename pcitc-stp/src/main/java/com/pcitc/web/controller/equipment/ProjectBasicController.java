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
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.RequestProcessStatusEnum;
import com.pcitc.base.stp.equipment.SreProjectBasic;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.workflow.Constants;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.web.common.BaseController;

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

	private static final String LIST_EQUIPMENT_BY_IDS = "http://pcitc-zuul/stp-proxy/sre-provider/equipment/list-by-ids/";

	// 流程操作--同意
	private static final String AUDIT_AGREE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/project_basic/task/agree/";
	// 流程操作--拒绝
	private static final String AUDIT_REJECT_URL = "http://pcitc-zuul/stp-proxy/sre-provider/project_basic/task/reject/";

	private final static String process_define_id4 = "oneSelectAuditProcess:1:367511";

	@RequestMapping(value = "/to-audit-list")
	public String auditlist(HttpServletRequest request, HttpServletResponse response) {
		return "/stp/equipment/project/audit-list";
	}

	@RequestMapping(value = "/to-list")
	public String list(HttpServletRequest request, HttpServletResponse response) {
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
		logger.info("============result" + result);
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
	public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String applyDoc = UUID.randomUUID().toString().replaceAll("-", "");
		String auditDoc = UUID.randomUUID().toString().replaceAll("-", "");
		String investDoc = UUID.randomUUID().toString().replaceAll("-", "");

		request.setAttribute("applyDoc", applyDoc);
		request.setAttribute("auditDoc", auditDoc);
		request.setAttribute("investDoc", investDoc);

		String checkContentDoc = UUID.randomUUID().toString().replaceAll("-", "");
		String taskDoc = UUID.randomUUID().toString().replaceAll("-", "");

		request.setAttribute("checkContentDoc", checkContentDoc);
		request.setAttribute("taskDoc", taskDoc);

		return "/stp/equipment/project/project-basic-add";
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
		String name = CommonUtil.getParameter(request, "name", "");
		String applyMoney = CommonUtil.getParameter(request, "applyMoney", "");
		String projectNo = CommonUtil.getParameter(request, "projectNo", "");
		// 业务ID
		String projectId = CommonUtil.getParameter(request, "projectId", "");

		// 流程状态-是保存还是提交
		String auditStatus = CommonUtil.getParameter(request, "auditStatus", "0");
		String userIds = CommonUtil.getParameter(request, "userIds", "");
		String equipmentIds = CommonUtil.getParameter(request, "equipmentIds", "");
		String remarks = CommonUtil.getParameter(request, "remarks", "");
		String status = CommonUtil.getParameter(request, "status", "0");
		String beginYear = CommonUtil.getParameter(request, "beginYear", "");
		String endYear = CommonUtil.getParameter(request, "endYear", "");
		String projectType = CommonUtil.getParameter(request, "projectType", "");
		String keyWord = CommonUtil.getParameter(request, "keyWord", "");
		String projectLeader = CommonUtil.getParameter(request, "projectLeader", "");
		String applyDoc = CommonUtil.getParameter(request, "applyDoc", "");
		String auditDoc = CommonUtil.getParameter(request, "auditDoc", "");
		String investDoc = CommonUtil.getParameter(request, "investDoc", "");

		SreProjectBasic sreProjectBasic = null;
		ResponseEntity<String> responseEntity = null;
		// 判断是新增还是修改
		if (projectId.equals("")) {
			sreProjectBasic = new SreProjectBasic();
			sreProjectBasic.setCreateDate(new Date());
			sreProjectBasic.setIsDel("0");
			sreProjectBasic.setCreateUserId(sysUserInfo.getUserId());
			String code = CommonUtil.getTableCode("XTBM_0032", restTemplate, httpHeaders);
			sreProjectBasic.setProjectCode(code);
			String id = UUID.randomUUID().toString().replaceAll("-", "");
			sreProjectBasic.setProjectId(id);
		} else {
			ResponseEntity<SreProjectBasic> se = this.restTemplate.exchange(GET_URL + projectId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreProjectBasic.class);
			sreProjectBasic = se.getBody();
		}
		// 流程状态
		sreProjectBasic.setAuditStatus(auditStatus);
		if (!applyMoney.equals("")) {
			sreProjectBasic.setApplyMoney(new BigDecimal(applyMoney));
		}
		sreProjectBasic.setApplyUnit(sysUserInfo.getUnitName());
		sreProjectBasic.setApplyDoc(applyDoc);
		sreProjectBasic.setAuditDoc(auditDoc);
		sreProjectBasic.setInvestDoc(investDoc);
		sreProjectBasic.setName(name);
		sreProjectBasic.setEquipmentIds(equipmentIds);
		sreProjectBasic.setRemarks(remarks);
		sreProjectBasic.setStatus(status);
		sreProjectBasic.setBeginYear(beginYear);
		sreProjectBasic.setEndYear(endYear);
		sreProjectBasic.setKeyWord(keyWord);
		sreProjectBasic.setProjectType(projectType);
		sreProjectBasic.setProjectLeader(projectLeader);

		String taskMainTaskContent = CommonUtil.getParameter(request, "taskMainTaskContent", "");
		String taskContent = CommonUtil.getParameter(request, "taskContent", "");
		String taskAssessmentContent = CommonUtil.getParameter(request, "taskAssessmentContent", "");
		String taskCheckContents = CommonUtil.getParameter(request, "taskCheckContents", "");
		String taskDoc = CommonUtil.getParameter(request, "taskDoc", "");
		// 任务书
		if (status.equals("2")) {
			sreProjectBasic.setTaskAssessmentContent(taskAssessmentContent);
			sreProjectBasic.setTaskCheckContents(taskCheckContents);
			sreProjectBasic.setTaskContent(taskContent);
			sreProjectBasic.setTaskDoc(taskDoc);
			sreProjectBasic.setTaskMainTaskContent(taskMainTaskContent);

		}

		// 判断是新增还是修改
		if (projectId.equals("")) {
			responseEntity = this.restTemplate.exchange(ADD_URL, HttpMethod.POST, new HttpEntity<SreProjectBasic>(sreProjectBasic, this.httpHeaders), String.class);

		} else {
			responseEntity = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SreProjectBasic>(sreProjectBasic, this.httpHeaders), String.class);
		}
		// 返回结果代码
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {

			CommonUtil.updateFileFlag(restTemplate, httpHeaders, applyDoc);
			CommonUtil.updateFileFlag(restTemplate, httpHeaders, auditDoc);
			if (status.equals("2")) {
				CommonUtil.updateFileFlag(restTemplate, httpHeaders, taskDoc);
			}

			if (auditStatus.equals("0")) {
				resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
			} else {
				String dataId = responseEntity.getBody();
				// 处理流程相关信息
				boolean flowFlag = dealWorkFlow(dataId, sysUserInfo, "项目", userIds, httpHeaders);
				if (flowFlag == true) {
					resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
				} else {
					resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
				}
			}
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
	 * 加入流程信息
	 * 
	 * @param id
	 * @param instanceName
	 * @param sysUser
	 */
	private boolean dealWorkFlow(String id, SysUser sysUser, String instanceName, String userIds, HttpHeaders httpHeaders) {

		WorkflowVo workflowVo = new WorkflowVo();
		workflowVo.setBusinessId(String.valueOf(id));
		workflowVo.setProcessInstanceName("业务任务名称：" + instanceName);
		workflowVo.setAuthenticatedUserId(sysUser.getUserId());

		// process_define_id和functionId，两种方式二选一
		// 清楚知道自己要走的流程定义id
		workflowVo.setProcessDefineId(process_define_id4);
		// 不清楚此功能菜单要走的审批流程。可以通过菜单id（functionId），部门/组织ID（orgId），项目id（projectId）。其中菜单id必填（和ProcessDefineId两选一）
		workflowVo.setFunctionId("");
		workflowVo.setProjectId("");

		Map<String, Object> variables = new HashMap<String, Object>();

		// 发起人之后的审批环节，如果是需要选择审批人的话，此处获取选择的userIds赋值给auditor变量
		if (userIds != null && !userIds.equals("")) {
			String[] userIdsArr = userIds.split(",");
			variables.put("auditor", Arrays.asList(userIdsArr));
		}

		// 必须设置，统一流程待办任务中需要的业务详情
		variables.put("auditDetailsPath", "/sre-equipment/get/" + id);

		// 流程完全审批通过时，调用的方法
		variables.put("auditAgreeMethod", AUDIT_AGREE_URL + id);

		// 流程驳回时，调用的方法（可能驳回到第一步，也可能驳回到第1+n步
		variables.put("auditRejectMethod", AUDIT_REJECT_URL + id);

		// 对流程中出现的多个判断条件，比如money>100等，需要把事先把money条件输入
		variables.put("money", 50); // 环节1需要用到
		variables.put("departmentCode", "1005"); // 环节2需要用到
		variables.put("companyCode", "2006"); // 环节n需要用到

		workflowVo.setVariables(variables);
		ResponseEntity<String> status = this.restTemplate.exchange(Constants.START_WORKFLOW_URL, HttpMethod.POST, new HttpEntity<WorkflowVo>(workflowVo, httpHeaders), String.class);
		if (status.getBody() != null && status.getBody().equals("true")) {
			System.out.println("=================流程启动成功");
			return true;
		} else {
			System.out.println("=================流程启动失败");
			return false;
		}
	}

	/**
	 * 修改
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/update")
	public String update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String projectId = CommonUtil.getParameter(request, "projectId", "");
		System.out.println(">>>>>>>>>>>>>>>>>>>projectId  " + projectId);
		request.setAttribute("projectId", projectId);
		ResponseEntity<SreProjectBasic> responseEntity = this.restTemplate.exchange(GET_URL + projectId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreProjectBasic.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			logger.info("============远程返回  statusCode " + statusCode);
			SreProjectBasic sreProjectBasic = responseEntity.getBody();
			request.setAttribute("sreProjectBasic", sreProjectBasic);
			String applyDoc = sreProjectBasic.getApplyDoc();
			request.setAttribute("applyDoc", applyDoc);
			String auditDoc = sreProjectBasic.getAuditDoc();
			request.setAttribute("auditDoc", auditDoc);
			String investDoc = sreProjectBasic.getInvestDoc();
			request.setAttribute("investDoc", investDoc);
		}
		return "/stp/equipment/project/project-basic-add";
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

	@RequestMapping(value = "/pass-back/{projectId}")
	public String passBackOPT(@PathVariable("projectId") String projectId, HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result resultsDate = new Result();
		String status = CommonUtil.getParameter(request, "status", "");
		String checkMoney = CommonUtil.getParameter(request, "checkMoney", "");
		ResponseEntity<SreProjectBasic> responseEntity = this.restTemplate.exchange(GET_URL + projectId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreProjectBasic.class);
		int statusCode = responseEntity.getStatusCodeValue();
		logger.info("============远程返回  statusCode " + statusCode);
		SreProjectBasic sreProjectBasic = responseEntity.getBody();
		sreProjectBasic.setStatus(status);

		if (!checkMoney.equals("")) {
			sreProjectBasic.setCheckMoney(new BigDecimal(checkMoney));
		}
		ResponseEntity<Integer> responseE = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SreProjectBasic>(sreProjectBasic, this.httpHeaders), Integer.class);
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
	public String get(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseEntity<SreProjectBasic> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreProjectBasic.class);
		int statusCode = responseEntity.getStatusCodeValue();
		logger.info("============远程返回  statusCode " + statusCode);
		SreProjectBasic sreProjectBasic = responseEntity.getBody();
		request.setAttribute("sreProjectBasic", sreProjectBasic);

		String applyDoc = sreProjectBasic.getApplyDoc();
		request.setAttribute("applyDoc", applyDoc);
		String auditDoc = sreProjectBasic.getAuditDoc();
		request.setAttribute("auditDoc", auditDoc);
		String investDoc = sreProjectBasic.getInvestDoc();
		request.setAttribute("investDoc", investDoc);

		return "/stp/equipment/project/project-basic-view";
	}
	
	
	
	//计划审核
	@RequestMapping(value = "/audit", method = RequestMethod.GET)
	public String audit( HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/stp/equipment/project/audit";
	}
	
	@RequestMapping(value = "/audit_look", method = RequestMethod.GET)
	public String audit_look( HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/stp/equipment/project/audit_look";
	}
	
	
	

}
