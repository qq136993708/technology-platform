package com.pcitc.web.controller.intlProject;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.FlowStatusEnum;
import com.pcitc.base.stp.IntlProject.IntlProjectAccept;
import com.pcitc.base.stp.IntlProject.IntlProjectApply;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.web.common.BaseController;

@RestController
public class IntlProjectAcceptController extends BaseController {

	private static final String PROJECT_ACCEPT_LIST_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/accept-list";
	private static final String PROJECT_ACCEPT_PASS_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/accept-pass-list";
	private static final String PROJECT_ACCEPT_REFUSE_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/accept-refuse-list";	
	private static final String PROJECT_ACCEPT_ADD_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/add-accept";
	private static final String PROJECT_ACCEPT_UPD_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/upd-accept";
	private static final String PROJECT_ACCEPT_GET_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/get-accept/";
	private static final String PROJECT_ACCEPT_CLOSE_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/close-accept/";
	private static final String PROJECT_ACCEPT_DEL_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/del-accept/";
	
	private static final String PROJECT_ACCEPT_PROCESS = "http://pcitc-zuul/stp-proxy/stp-provider/project/accept-process";

	@RequestMapping(value = "/project/accept-list", method = RequestMethod.POST)
	public Object getAcceptTableData(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request) throws IOException {
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(PROJECT_ACCEPT_LIST_URL, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData data = responseEntity.getBody();
		//System.out.println(JSON.toJSON(data).toString());
		return JSON.toJSON(data).toString();
	}
	@RequestMapping(value = "/project/accept-process", method = RequestMethod.POST)
	public Object saveAcceptAcceptProcessInfo(@ModelAttribute("project") IntlProjectAccept accept) throws IOException 
	{
		accept.setAcceptId(IdUtil.createIdByTime());
		accept.setAcceptDate(DateUtil.format(new Date(), DateUtil.FMT_DD));
		accept.setCreateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
		accept.setUpdateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
		HttpEntity<IntlProjectAccept> entity = new HttpEntity<IntlProjectAccept>(accept, this.httpHeaders);
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(PROJECT_ACCEPT_PROCESS, HttpMethod.POST, entity, Integer.class);
		if (responseEntity.getBody() >0 ) {
			return new Result(true);
		} else {
			return new Result(false);
		}
	}
	
	@RequestMapping(value = "/project/accept-pass-list", method = RequestMethod.POST)
	public Object getAcceptPassTableData(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request) throws IOException {
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(PROJECT_ACCEPT_PASS_URL, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData data = responseEntity.getBody();
		//System.out.println(JSON.toJSON(data).toString());
		return JSON.toJSON(data).toString();
	}
	@RequestMapping(value = "/project/accept-refuse-list", method = RequestMethod.POST)
	public Object getAcceptRefuseTableData(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request) throws IOException {
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(PROJECT_ACCEPT_REFUSE_URL, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData data = responseEntity.getBody();
		//System.out.println(JSON.toJSON(data).toString());
		return JSON.toJSON(data).toString();
	}

	@RequestMapping(value = "/project/accept-saveorupdate", method = RequestMethod.POST)
	public Object updProjectAccept(@ModelAttribute("accept") IntlProjectAccept accept, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseEntity<Integer> status = null;
		if (StringUtils.isBlank(accept.getAcceptId())) {
			// 创建一个新的对象
			IntlProjectApply newApply = (IntlProjectApply) MyBeanUtils.createDefaultModel(IntlProjectApply.class);
			MyBeanUtils.copyPropertiesIgnoreNull(accept, newApply);
			status = this.restTemplate.exchange(PROJECT_ACCEPT_ADD_URL, HttpMethod.POST, new HttpEntity<IntlProjectApply>(newApply, this.httpHeaders), Integer.class);
		} else {
			// 先查询再更新
			IntlProjectApply oldApply = this.restTemplate.exchange(PROJECT_ACCEPT_GET_URL, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), IntlProjectApply.class).getBody();
			// 如果已提交则不可更新
			if (FlowStatusEnum.FLOW_START_STATUS_YES.getCode().equals(oldApply.getFlowStartStatus())) {
				return new Result(false, "申报已提交不可再编辑");
			}
			oldApply.setUpdateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
			MyBeanUtils.copyPropertiesIgnoreNull(accept, oldApply);
			status = this.restTemplate.exchange(PROJECT_ACCEPT_UPD_URL, HttpMethod.POST, new HttpEntity<IntlProjectApply>(oldApply, this.httpHeaders), Integer.class);
		}
		if (status.getBody() == 0) {
			return new Result(false);
		} else {
			return new Result(true);
		}
	}

	@RequestMapping(value = "/project/accept-close/{acceptId}")
	public Object delAccept(@PathVariable("acceptId") String acceptId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 关闭
		ResponseEntity<Integer> presult = this.restTemplate.exchange(PROJECT_ACCEPT_CLOSE_URL, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
		if (presult.getBody() > 0) {
			return new Result(true, "关闭成功！");
		} else {
			return new Result(false, "关闭失败，请联系系统管理员！");
		}
	}

	@RequestMapping(value = "/project/accept-delete/{acceptId}")
	public Object delAcceptRel(@PathVariable("applyId") String applyId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 先查询再删除
		IntlProjectApply oldplant = this.restTemplate.exchange(PROJECT_ACCEPT_GET_URL + applyId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), IntlProjectApply.class).getBody();
		// 如果已提交则不可删除
		if (FlowStatusEnum.FLOW_START_STATUS_YES.getCode().equals(oldplant.getFlowStartStatus())) {
			return new Result(false, "已提交不可删除");
		}
		// 删除
		ResponseEntity<Integer> presult = this.restTemplate.exchange(PROJECT_ACCEPT_DEL_URL + applyId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
		if (presult.getBody() > 0) {
			return new Result(true, "删除成功！");
		} else {
			return new Result(false, "删除失败，请联系系统管理员！");
		}
	}

	@RequestMapping(value = "/project/get-accept")
	public Object getProjectAccept(@RequestParam(value = "acceptId", required = true) String acceptId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//System.out.println("acceptId................." + acceptId);
		return this.restTemplate.exchange(PROJECT_ACCEPT_GET_URL + acceptId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), IntlProjectApply.class).getBody();
	}
}
