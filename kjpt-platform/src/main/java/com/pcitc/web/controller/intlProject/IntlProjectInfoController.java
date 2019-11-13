package com.pcitc.web.controller.intlProject;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
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
import com.pcitc.base.common.WorkFlowStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.common.enums.FlowStatusEnum;
import com.pcitc.base.stp.IntlProject.IntlProjectInfo;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.web.common.BaseController;

@RestController
public class IntlProjectInfoController extends BaseController {

	private static final String PROJECT_INFO_LIST = "http://pcitc-zuul/stp-proxy/stp-provider/project/info-list";
	private static final String PROJECT_INFO_LIST_ALL = "http://pcitc-zuul/stp-proxy/stp-provider/project/info-list-all";
	private static final String PROJECT_GET_INFO = "http://pcitc-zuul/stp-proxy/stp-provider/project/get-project/";
	private static final String PROJECT_INFO_ADDORUPD = "http://pcitc-zuul/stp-proxy/stp-provider/project/addorupd-project";
	private static final String PROJECT_INFO_CLOSE_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/close-project/";
	private static final String PROJECT_INFO_DEL = "http://pcitc-zuul/stp-proxy/stp-provider/project/del-project/";
	private static final String PROJECT_INFO_WORKFLOW_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/start-info-activity/";
	
	private static final String PROJECT_INFO_CODE = "http://pcitc-zuul/stp-proxy/stp-provider/project/project-info-code";
	private static final String PROJECT_INFO_COUNT = "http://pcitc-zuul/stp-proxy/stp-provider/project/info-count";
	
	private static final String USER_GET_URL = "http://pcitc-zuul/system-proxy/user-provider/user/get-user/";
	
	@RequestMapping(value = "/project/info-list", method = RequestMethod.POST)
	public Object getTableData(@ModelAttribute("param") LayuiTableParam param) throws IOException {
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(PROJECT_INFO_LIST, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData data = responseEntity.getBody();
		return JSON.toJSON(data).toString();
	}
	
	@RequestMapping(value = "/project/info-list-all", method = RequestMethod.POST)
	public Object getListData(HttpServletRequest request) throws IOException {
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(PROJECT_INFO_LIST_ALL, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody()).toString();
	}

	@RequestMapping(value = "/project/get-project")
	public Object getProjectInfo(@RequestParam(value = "projectId", required = true) String projectId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		IntlProjectInfo prject = this.restTemplate.exchange(PROJECT_GET_INFO + projectId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), IntlProjectInfo.class).getBody();
		//System.out.println(JSON.toJSON(prject));
		return prject;
	}

	@RequestMapping(value = "/project/addorupd-project")
	public Object saveProjectInfo(@ModelAttribute(value = "projectInfo") IntlProjectInfo info) throws Exception {
		if(!StringUtils.isBlank(info.getProjectId())) {
			IntlProjectInfo prject = this.restTemplate.exchange(PROJECT_GET_INFO + info.getProjectId(), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), IntlProjectInfo.class).getBody();
			if (prject != null && FlowStatusEnum.FLOW_START_STATUS_YES.getCode().equals(prject.getFlowStartStatus())) {
				return new Result(false, "已提交不可更改");
			}
		}
		if (info.getProjectId() == null || "".equals(info.getProjectId())) {
			info.setFlowCurrentStatus(WorkFlowStatusEnum.STATUS_WAITING.getCode());
			info.setProjectId(IdUtil.createIdByTime());
			info.setDelFlag(DelFlagEnum.STATUS_NORMAL.getCode());
			info.setCreater(sysUserInfo.getUserId());
			info.setCreaterName(sysUserInfo.getUserDisp());
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
		IntlProjectInfo prject = this.restTemplate.exchange(PROJECT_GET_INFO + projectId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), IntlProjectInfo.class).getBody();
		if (prject != null && FlowStatusEnum.FLOW_START_STATUS_YES.getCode().equals(prject.getFlowStartStatus())) {
			return new Result(false, "已提交不可删除");
		}
		ResponseEntity<Integer> status = this.restTemplate.exchange(PROJECT_INFO_DEL + projectId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
		if (status.getBody() == 0) {
			return new Result(false);
		} else {
			return new Result(true);
		}
	}

	@RequestMapping(value = "/project/close-project")
	public Object closeProjectInfo(@RequestParam(value = "projectId", required = true) String projectId) throws Exception {
		IntlProjectInfo prject = this.restTemplate.exchange(PROJECT_GET_INFO + projectId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), IntlProjectInfo.class).getBody();
		if (prject != null && FlowStatusEnum.FLOW_START_STATUS_YES.getCode().equals(prject.getFlowStartStatus())) {
			return new Result(false, "已提交不可删除");
		}
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
		//System.out.println("开始审批！！！！ projectId:" + projectId);
		WorkflowVo vo = new WorkflowVo();
		vo.setFunctionId(functionId);
		vo.setAuthenticatedUserId(this.getUserProfile().getUserId());
		vo.setAuthenticatedUserName(this.getUserProfile().getUserDisp());
		vo.setMessageUserIds(this.getUserProfile().getUserId());
		vo.setBusinessId(projectId);
		vo.setProcessInstanceName("项目立项审批");
		
		HttpEntity<WorkflowVo> entity = new HttpEntity<WorkflowVo>(vo, this.httpHeaders);
		Result rs = this.restTemplate.exchange(PROJECT_INFO_WORKFLOW_URL + projectId, HttpMethod.POST, entity, Result.class).getBody();
		//System.out.println(JSON.toJSONString(rs));
		return rs;
	}
	@RequestMapping(value = "/project/project-info-code", method = RequestMethod.POST)
	public Object getInfoCode(@ModelAttribute(value = "projectInfo") IntlProjectInfo info,HttpServletRequest request) throws IOException {
		//System.out.println("start.................");
		String rs = this.restTemplate.exchange(PROJECT_INFO_CODE, HttpMethod.POST, new HttpEntity<Object>(info,this.httpHeaders), String.class).getBody();
		//System.out.println("rs------------------"+rs);
		return new Result(true, rs);
	}
	@RequestMapping(value = "/project/info-count", method = RequestMethod.POST)
	public Object getProjectInfoCount(@RequestParam(value = "nd", required = false) String nd,HttpServletRequest request, HttpServletResponse response) throws Exception {
		//权限需求20190728 仅允许级别为2的用户查看,或者国际合作处的人能看
		SysUser user =this.restTemplate.exchange(USER_GET_URL + this.sysUserInfo.getUserId(), HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SysUser.class).getBody();
		if(new Integer(2).equals(this.getUserProfile().getUserLevel()) || user.getUserUnit().contains("ddca550d9cf7440a96f149c78956b93d")) 
		{
			if(StringUtils.isBlank(nd)) 
			{
				nd = DateUtil.format(new Date(), DateUtil.FMT_YYYY);
			}
			Integer prject = this.restTemplate.exchange(PROJECT_INFO_COUNT, HttpMethod.POST, new HttpEntity<String>(nd,this.httpHeaders), Integer.class).getBody();
			return JSON.toJSON(prject);
			
		}else {
			return JSON.toJSON("0");
		}
	}
}
