package com.pcitc.web.controller.mobile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.InforVo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Page;
import com.pcitc.base.system.SysNotice;
import com.pcitc.base.system.SysNoticeVo;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.web.common.BaseController;

@Controller
public class MobileWorkbechController extends BaseController{

	
	// 已办任务列表（每行代表一个任务）
	private static final String DONE_TASK_PAGE_URL = "http://pcitc-zuul/system-proxy/task-provider/done-task-page";
	// 待办任务列表
    private static final String PENDING_PAGE_URL = "http://pcitc-zuul/system-proxy/task-provider/pending-page";
	
    private static final String VIEW_NOTICE = "http://pcitc-zuul/system-proxy/sysNotice-provider/getSysNoticeView/";
    // 消息列表
 	private static final String MESSAGE_LIST = "http://pcitc-zuul/system-proxy/message-provider/message/list";
	// 获取任务详情信息
	private static final String INI_DEAL_TASK = "http://pcitc-zuul/system-proxy/task-provider/deal/task/info";
	// 获取项目管理系统的待办任务
		private static final String XMGL_PENDING = "http://pcitc-zuul/system-proxy/out-wait-work/xmgl/page";
 	
 	@RequestMapping(value = "/mobile/agencyM")
	public String agencyM(HttpServletRequest request) {
		return "/mobile/agencyM";
	}
 	
 	@RequestMapping(value = "/mobile/work")
	public String work(HttpServletRequest request) {
		return "/mobile/work";
	}
 	
 	
 	@RequestMapping(value = "/mobile/work_add")
	public String work_add(HttpServletRequest request) {
		return "/mobile/work_add";
	}
 	@RequestMapping(value = "/mobile/work_details")
	public String work_details(HttpServletRequest request) {
		return "/mobile/work_details";
	}
 	
 	@RequestMapping(value = "/mobile/work_details1")
	public String work_details1(HttpServletRequest request) {
		return "/mobile/work_details1";
	}
 	
 	//处理待办
 	@RequestMapping(value = "/mobile/task/pending/deal/{taskId}")
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
 	
 	
 	
    
    //待办任务数据
	@RequestMapping(value = "/mobile/wait_task_list_data")
	@ResponseBody
	public LayuiTableData wait_task_list_data(HttpServletRequest request) {
		int pageNo = request.getParameter("pageNo") == null ? 1 : Integer.parseInt((String) request.getParameter("pageNo"));
		LayuiTableParam param = new LayuiTableParam();
		param.setPage(pageNo);
		param.setLimit(15);
		// 获取当前登录人信息
		param.getParam().put("userId", sysUserInfo.getUserId());
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(PENDING_PAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();
		
		return retJson;
	}
	//已办任务数据
	@RequestMapping(value = "/mobile/finished_task_list_data")
	@ResponseBody
	public LayuiTableData finished_task_list_data(HttpServletRequest request) {
		int pageNo = request.getParameter("pageNo") == null ? 1 : Integer.parseInt((String) request.getParameter("pageNo"));
		LayuiTableParam param = new LayuiTableParam();
		param.setPage(pageNo);
		param.setLimit(15);
		// 获取当前登录人信息
		param.getParam().put("userId", sysUserInfo.getUserId());
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(DONE_TASK_PAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();
		
		return retJson;
	}
	
	
	/**
	 * @author zhf 其它系统的待办任务列表
	 */
	@RequestMapping(value = "/mobile/task/other/pending-list", method = RequestMethod.POST)
	@ResponseBody
	public Object otherPendingList(HttpServletRequest request) 
	{
		
		int pageNo = request.getParameter("pageNo") == null ? 1 : Integer.parseInt((String) request.getParameter("pageNo"));
		LayuiTableParam param = new LayuiTableParam();
		param.setPage(pageNo);
		param.setLimit(15);
		
		System.out.println("==== 待办 param-->" + JSON.toJSON(param).toString());
		// 获取当前登录人信息, 统一身份名作为用户id
		param.getParam().put("userId", sysUserInfo.getUserName());
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(XMGL_PENDING, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();

		return JSON.toJSON(retJson).toString();
	}
	

	@RequestMapping(value = "/mobile/message_list")
	public String message_list(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/mobile/message_list";
	}

	@RequestMapping(value = "/mobile/message_list_data", method = RequestMethod.POST)
	@ResponseBody
	public Page message_list_data(HttpServletRequest request) {
		int pageNo = request.getParameter("pageNo") == null ? 1 : Integer.parseInt((String) request.getParameter("pageNo"));
		LayuiTableParam param = new LayuiTableParam();
		param.setPage(pageNo);
		param.getParam().put("userId", sysUserInfo.getUserId());
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(MESSAGE_LIST, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();
		Page page = new Page();
		page.setRows(retJson.getData());
		page.setPageNo(pageNo);
		page.setPageSize(param.getLimit());
		page.setTotalRecords(retJson.getCount());
		return page;
	}

	@RequestMapping(value = "/mobile/message_list", method = RequestMethod.POST)
	@ResponseBody
	public Object message_list(@ModelAttribute("param") LayuiTableParam param) {

		// 获取当前登录人信息
		param.getParam().put("userId", sysUserInfo.getUserId());
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(MESSAGE_LIST, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();
		// return JSON.toJSON(retJson).toString();

		return "/mobile/message_list";
	}
    
    
    
    
    
	
	
	
	
	/**
	 * 查看公告
	 * 
	 * @return
	 */
	@RequestMapping(value = "/mobile/sysNotice/readNotice")
	public String readNotice(String id, Model model) {
		SysNoticeVo vo = new SysNoticeVo();
		vo.setNoticeId(id);
		SysUser currentUser = sysUserInfo;
		vo.setUserId(currentUser.getUserId());
		HttpEntity<SysNoticeVo> entity = new HttpEntity<SysNoticeVo>(vo, this.httpHeaders);
		ResponseEntity<SysNotice> responseEntity = this.restTemplate.exchange(VIEW_NOTICE, HttpMethod.POST, entity, SysNotice.class);
		SysNotice sysNotice = responseEntity.getBody();
		InforVo inforVo = new InforVo();
		inforVo.setContent(sysNotice.getNoticeContent());
		inforVo.setDate(sysNotice.getNoticePublishtime());
		inforVo.setTitle(sysNotice.getNoticeTitle());
		model.addAttribute("info", inforVo);
		return "base/system/info-dialog";
	}

	
}
