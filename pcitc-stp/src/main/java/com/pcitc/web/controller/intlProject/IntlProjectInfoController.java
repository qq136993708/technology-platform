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
import com.pcitc.base.stp.IntlProject.IntlProjectInfo;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.web.common.BaseController;

@RestController
public class IntlProjectInfoController extends BaseController {

	private static final String PROJECT_INFO_LIST = "http://pcitc-zuul/stp-proxy/stp-provider/project/info-list";
	private static final String PROJECT_GET_INFO = "http://pcitc-zuul/stp-proxy/stp-provider/project/get-project/";
	private static final String PROJECT_INFO_ADDORUPD = "http://pcitc-zuul/stp-proxy/stp-provider/project/addorupd-project";
	private static final String PROJECT_INFO_CLOSE_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/close-project/";
	private static final String PROJECT_INFO_DEL = "http://pcitc-zuul/stp-proxy/stp-provider/project/del-project/";
	private static final String PROJECT_INFO_WORKFLOW_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/start-info-activity/";
	
	
	
	@RequestMapping(value = "/project/info-list", method = RequestMethod.POST)
	public Object getTableData(@ModelAttribute("param") LayuiTableParam param) throws IOException {
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(PROJECT_INFO_LIST, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData data = responseEntity.getBody();
		return JSON.toJSON(data).toString();
	}

	@RequestMapping(value = "/project/get-project")
	public Object getProjectInfo(@RequestParam(value = "projectId", required = true) String projectId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		IntlProjectInfo prject = this.restTemplate.exchange(PROJECT_GET_INFO + projectId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), IntlProjectInfo.class).getBody();
		System.out.println(JSON.toJSON(prject));
		return prject;
	}

	@RequestMapping(value = "/project/addorupd-project")
	public Object saveProjectInfo(@ModelAttribute(value = "projectInfo") IntlProjectInfo info) throws Exception {
		info.setDelFlag(DelFlagEnum.STATUS_NORMAL.getCode());
		info.setCreater(sysUserInfo.getUserId());
		info.setCreaterName(sysUserInfo.getUserDisp());
		if (info.getProjectId() == null) {
			info.setProjectId(IdUtil.createIdByTime());
		}
		ResponseEntity<Integer> status = this.restTemplate.exchange(PROJECT_INFO_ADDORUPD, HttpMethod.POST, new HttpEntity<IntlProjectInfo>(info, this.httpHeaders), Integer.class);
		if (status.getBody() == 0) {
			return new Result(false);
		} else {
			return new Result(true);
		}
	}

	@RequestMapping(value = "/project/del-project")
	public Object delProjectInfo(@RequestParam(value = "projectId", required = true) String projectId) throws Exception {
		ResponseEntity<Integer> status = this.restTemplate.exchange(PROJECT_INFO_DEL + projectId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
		if (status.getBody() == 0) {
			return new Result(false);
		} else {
			return new Result(true);
		}
	}

	@RequestMapping(value = "/project/close-project")
	public Object closeProjectInfo(@RequestParam(value = "projectId", required = true) String projectId) throws Exception {
		ResponseEntity<Integer> status = this.restTemplate.exchange(PROJECT_INFO_CLOSE_URL + projectId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
		if (status.getBody() == 0) {
			return new Result(false);
		} else {
			return new Result(true);
		}
	}
	@RequestMapping(value = "/project/project-start-workflow")
	public Object startProjectApplyWorkflow(@RequestParam(value = "projectId", required = true) String projectId,
			@RequestParam(value = "functionId", required = true) String functionId, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("开始审批！！！！" + projectId);
		WorkflowVo vo = new WorkflowVo();
		vo.setAuditUserIds(this.getUserProfile().getUserId());
		vo.setFunctionId(functionId);
		System.out.println("functionId .... "+functionId);
		vo.setAuthenticatedUserId(this.getUserProfile().getUserId());
		HttpEntity<WorkflowVo> entity = new HttpEntity<WorkflowVo>(vo, this.httpHeaders);
		Integer plant = this.restTemplate.exchange(PROJECT_INFO_WORKFLOW_URL + projectId, HttpMethod.POST, entity, Integer.class).getBody();
		System.out.println("审批返回状态：" + plant);
		if (plant == 0) {
			return new Result(false);
		} else {
			return new Result(true);
		}
	}

}
