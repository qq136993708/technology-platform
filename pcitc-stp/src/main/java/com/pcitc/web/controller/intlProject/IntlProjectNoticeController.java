package com.pcitc.web.controller.intlProject;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.stp.IntlProject.IntlProjectNotice;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.web.common.BaseController;

@RestController
public class IntlProjectNoticeController extends BaseController {

	private static final String PROJECT_NOTICE_LIST_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/notice-list";
	private static final String PROJECT_NOTICE_ADDORUPD = "http://pcitc-zuul/stp-proxy/stp-provider/project/addorupd-notice";
	private static final String PROJECT_NOTICE_GET = "http://pcitc-zuul/stp-proxy/stp-provider/project/get-notice/";
	private static final String PROJECT_NOTICE_CLOSE_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/close-notice/";
	private static final String PROJECT_NOTICE_DEL = "http://pcitc-zuul/stp-proxy/stp-provider/project/del-notice/";
	private static final String PROJECT_NOTICE_SENT = "http://pcitc-zuul/stp-proxy/stp-provider/project/sent-notice/";
	private static final String PROJECT_NOTICE_WORKFLOW_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/start-notice-activity/";
	private static final String PROJECT_WORKFLOW_CHECK = "http://pcitc-zuul/stp-proxy/stp-provider/project/notice-flow-check/";

	
	
	@RequestMapping(value = "/project/notice-start-workflow")
	public Object startProjectPlantWorkflow(@RequestParam(value = "noticeId", required = true) String noticeId,
			@RequestParam(value = "functionId", required = true) String functionId,
			HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		WorkflowVo vo = new WorkflowVo();
		vo.setAuditUserIds(this.getUserProfile().getUserId());
		vo.setFunctionId(functionId);
		vo.setAuthenticatedUserId(this.getUserProfile().getUserId());
		vo.setAuthenticatedUserName(this.getUserProfile().getUserDisp());
		vo.setBusinessId(noticeId);
		vo.setProcessDefinitionName("通知下发审批");
		
		HttpEntity<WorkflowVo> entity = new HttpEntity<WorkflowVo>(vo, this.httpHeaders);
		Result rs = this.restTemplate.exchange(PROJECT_NOTICE_WORKFLOW_URL + noticeId, HttpMethod.POST, entity, Result.class).getBody();
		return rs;
	}
	
	@RequestMapping(value = "/project/notice-list", method = RequestMethod.POST)
	public Object getNoticeTableData(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request) throws IOException {
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(PROJECT_NOTICE_LIST_URL, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData data = responseEntity.getBody();
		System.out.println(JSON.toJSON(data).toString());
		return JSON.toJSON(data).toString();
	}

	@RequestMapping(value = "/project/addorupd-notice", method = RequestMethod.POST)
	public Object saveNoticeInfo(@ModelAttribute(value = "notice") IntlProjectNotice notice, HttpServletRequest request) throws IOException {
		notice.setDelFlag(DelFlagEnum.STATUS_NORMAL.getCode());
		notice.setCreater(sysUserInfo.getUserId());
		ResponseEntity<Result> status = this.restTemplate.exchange(PROJECT_NOTICE_ADDORUPD, HttpMethod.POST, new HttpEntity<IntlProjectNotice>(notice, this.httpHeaders), Result.class);
		return status.getBody();
	}

	@RequestMapping(value = "/project/get-notice")
	public Object getProjectInfo(@RequestParam(value = "noticeId", required = true) String noticeId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		IntlProjectNotice notice = this.restTemplate.exchange(PROJECT_NOTICE_GET + noticeId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), IntlProjectNotice.class).getBody();
		System.out.println(JSON.toJSON(notice));
		return notice;
	}

	@RequestMapping(value = "/project/del-notice")
	public Object delProjectNotice(@RequestParam(value = "noticeId", required = true) String noticeId) throws Exception {
		
		Result result = this.restTemplate.exchange(PROJECT_WORKFLOW_CHECK+noticeId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Result.class).getBody();
		if(!result.isSuccess()) {
			return result;
		}
		ResponseEntity<Integer> status = this.restTemplate.exchange(PROJECT_NOTICE_DEL + noticeId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
		if (status.getBody() == 0) {
			return new Result(false);
		} else {
			return new Result(true);
		}
	}

	@RequestMapping(value = "/project/close-notice")
	public Object closeProjectNotice(@RequestParam(value = "noticeId", required = true) String noticeId) throws Exception {
		Result result = this.restTemplate.exchange(PROJECT_WORKFLOW_CHECK+noticeId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Result.class).getBody();
		if(!result.isSuccess()) {
			return result;
		}
		ResponseEntity<Integer> status = this.restTemplate.exchange(PROJECT_NOTICE_CLOSE_URL + noticeId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
		if (status.getBody() == 0) {
			return new Result(false);
		} else {
			return new Result(true);
		}
	}

	@RequestMapping(value = "/intl_project/sent-notice")
	public Object sentProjectNotice(@RequestParam(value = "noticeId", required = true) String noticeId) throws Exception {
		ResponseEntity<Object> status = this.restTemplate.exchange(PROJECT_NOTICE_SENT + noticeId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Object.class);
		return status.getBody();
	}
}
