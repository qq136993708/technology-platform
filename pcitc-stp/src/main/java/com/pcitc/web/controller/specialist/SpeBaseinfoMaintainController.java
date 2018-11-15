package com.pcitc.web.controller.specialist;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.stp.specialist.SpeBaseinfoMaintain;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.web.common.BaseController;

@Controller
@RequestMapping(value = "/spe-baseinfoMaintain")
public class SpeBaseinfoMaintainController extends BaseController {

	private static final String PAGE_URL = "http://pcitc-zuul/stp-proxy/spe-provider/baseinfomaintain/page";
	private static final String ADD_URL = "http://pcitc-zuul/stp-proxy/spe-provider/baseinfoMaintain/add";
	private static final String DEL_URL = "http://pcitc-zuul/stp-proxy/spe-provider/baseinfoMaintain/delete/";
	private static final String GET_URL = "http://pcitc-zuul/stp-proxy/spe-provider/baseinfoMaintain/getById/";
	// 工作流
	private static final String START_WORKFLOW_URL = "http://pcitc-zuul/system-proxy/workflow-provider/workflow/start";
	private static final String AGREE_WORKFLOW_URL = "http://pcitc-zuul/stp-proxy/spe-provider/baseinfoMaintain/agree/";
	private static final String REJECT_WORKFLOW_URL = "http://pcitc-zuul/stp-proxy/spe-provider/baseinfoMaintain/reject/";

	/**
	 * 跳转到基础信息维护主页面
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/list/ini")
	public String iniBaseinfoMaintain(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/stp/spe/baseinfoProvider/baseinfoProvider_list";
	}

	/**
	 * 跳转到基础信息维护新增、编辑页面
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/toEdit")
	public String toEdit(String id, Model model) {
		if (StringUtils.isEmpty(id))
			id = "";
		model.addAttribute("id", id);
		return "/stp/spe/baseinfoProvider/baseinfoProvider_edit";
	}

	/**
	 * 列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/list")
	@ResponseBody
	public Object listBaseinfoMaintain(HttpServletRequest request, HttpServletResponse response) {
		SpeBaseinfoMaintain searchVO = new SpeBaseinfoMaintain();
		String page = request.getParameter("page"); // 起始索引
		String limit = request.getParameter("limit"); // 每页显示的行数
		String name = request.getParameter("name");
		searchVO.setPage(page);
		searchVO.setLimit(limit);
		if (!"".equals(name)) {
			searchVO.setName(name);
		}
		HttpEntity<SpeBaseinfoMaintain> entity = new HttpEntity<SpeBaseinfoMaintain>(searchVO, this.httpHeaders);
		ResponseEntity<String> responseEntity = this.restTemplate.exchange(PAGE_URL, HttpMethod.POST, entity, String.class);
		String result = responseEntity.getBody();
		JSONObject retJson = JSONObject.parseObject(result);
		return retJson.toString();
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
	public String addBaseinfoMaintain(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String backurl = CommonUtil.getParameter(request, "backurl", "");
		request.setAttribute("backurl", backurl);

		String iframeId = CommonUtil.getParameter(request, "iframeId", "");
		request.setAttribute("iframeId", iframeId);

		String equipmentId = CommonUtil.getParameter(request, "equipmentId", "");
		request.setAttribute("equipmentId", equipmentId);

		return "/stp/equipment/contract/contract-add";
	}

	/**
	 * 保存基础信息维护
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public SpeBaseinfoMaintain saveBaseinfoMaintain(@RequestBody SpeBaseinfoMaintain obj, HttpServletRequest request) {
		HttpEntity<SpeBaseinfoMaintain> entity = new HttpEntity<SpeBaseinfoMaintain>(obj, this.httpHeaders);
		ResponseEntity<SpeBaseinfoMaintain> responseEntity = this.restTemplate.exchange(ADD_URL, HttpMethod.POST, entity, SpeBaseinfoMaintain.class);
		obj = responseEntity.getBody();
		return obj;
	}

	/**
	 * 提交基础信息维护申报流程
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/commit", method = RequestMethod.POST)
	@ResponseBody
	public int commitBaseinfoMaintain(@RequestBody SpeBaseinfoMaintain obj, HttpServletRequest request) {
		int result = 500;
		String ids = obj.getUserIds();
		String functionId = obj.getFunctionId();
		obj.setAuditStatus("2");// 审批状态，0未审批、1审批通过、2审批中、3未通过
		HttpEntity<SpeBaseinfoMaintain> entity = new HttpEntity<SpeBaseinfoMaintain>(obj, this.httpHeaders);
		ResponseEntity<SpeBaseinfoMaintain> responseEntity = this.restTemplate.exchange(ADD_URL, HttpMethod.POST, entity, SpeBaseinfoMaintain.class);
		obj = responseEntity.getBody();
		String businessId = obj.getBaseId();
		WorkflowVo workflowVo = new WorkflowVo();
		workflowVo.setBusinessId(businessId);
		workflowVo.setProcessInstanceName("基础信息维护审核业务流程：" + businessId.substring(0, 10));
		workflowVo.setAuthenticatedUserId(sysUserInfo.getUserId());
		// process_define_id和functionId，两种方式二选一
		// workflowVo.setProcessDefineId("qlfcComApply:4:570008");//指定审批人
		// workflowVo.setProcessDefineId("qlfcComApply:5:575004");//选择审批人
		// 清楚知道自己要走的流程定义id
		// 不清楚此功能菜单要走的审批流程。可以通过菜单id（functionId），部门/组织ID（orgId），项目id（projectId）。其中菜单id必填（和ProcessDefineId两选一）
		workflowVo.setFunctionId(functionId);
		Map<String, Object> variables = new HashMap<String, Object>();
		// 发起人之后的审批环节，如果是需要选择审批人的话，此处获取选择的userIds赋值给auditor变量
		if (StringUtils.isNotEmpty(ids)) {
			String[] userIds = ids.split(",");
			variables.put("auditor", Arrays.asList(userIds));
		}
		// 必须设置，统一流程待办任务中需要的业务详情
		variables.put("auditDetailsPath", "/spe-baseinfoMaintain/view/" + businessId);
		// 流程完全审批通过时，调用的方法
		variables.put("auditAgreeMethod", AGREE_WORKFLOW_URL + businessId);
		// 流程驳回时，调用的方法（可能驳回到第一步，也可能驳回到第1+n步
		variables.put("auditRejectMethod", REJECT_WORKFLOW_URL + businessId);
		// 对流程中出现的多个判断条件，比如money>100等，需要把事先把money条件输入
		// variables.put("money", 50); //环节1需要用到
		// variables.put("departmentCode", "1005"); //环节2需要用到
		// variables.put("companyCode", "2006"); //环节n需要用到
		workflowVo.setVariables(variables);
		ResponseEntity<String> status = this.restTemplate.exchange(START_WORKFLOW_URL, HttpMethod.POST, new HttpEntity<WorkflowVo>(workflowVo, this.httpHeaders), String.class);
		System.out.println("123=================启动成功" + status.getBody());
		if (status.getBody() != null && status.getBody().equals("true")) {
			System.out.println("=================启动成功");
			result = 200;
		} else {
			System.out.println("=================启动失败");
			result = 500;
		}
		return result;
	}

	/**
	 * 删除基础信息维护
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete")
	@ResponseBody
	public int deleteSpeBaseinfoMaintain(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(DEL_URL + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), Integer.class);
		int result = responseEntity.getBody();
		return result;
	}

	/**
	 * 获取基础信息维护详细信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getById")
	@ResponseBody
	public Object getBaseinfoMaintain(HttpServletRequest request) {
		String id = request.getParameter("id");
		ResponseEntity<SpeBaseinfoMaintain> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), SpeBaseinfoMaintain.class);
		SpeBaseinfoMaintain apply = responseEntity.getBody();
		return apply;
	}

	/**
	 * 跳转至基础信息维护详情页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/view/{baseId}")
	public String baseinfoMaintainView(@PathVariable("baseId") String baseId, Model model) {
		ResponseEntity<SpeBaseinfoMaintain> responseEntity = this.restTemplate.exchange(GET_URL + baseId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), SpeBaseinfoMaintain.class);
		SpeBaseinfoMaintain baseInfo = responseEntity.getBody();
		model.addAttribute("baseInfo", baseInfo);
		return "/stp/spe/baseinfoProvider/baseinfoProvider_view";
	}
}
