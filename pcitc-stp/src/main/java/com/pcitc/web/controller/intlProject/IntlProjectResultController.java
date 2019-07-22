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
import com.pcitc.base.stp.IntlProject.IntlProjectResult;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.web.common.BaseController;

@RestController
public class IntlProjectResultController extends BaseController {

	private static final String PROJECT_RESULT_LIST_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/result-list";
	private static final String PROJECT_RESULT_ADD_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/add-result";
	private static final String PROJECT_RESULT_UPD_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/upd-result";
	private static final String PROJECT_RESULT_GET_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/get-result/";
	private static final String PROJECT_RESULT_CLOSE_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/close-result/";
	private static final String PROJECT_RESULT_DEL_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/del-result/";

	@RequestMapping(value = "/project/result-list", method = RequestMethod.POST)
	public Object getResultTableData(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request) throws IOException {
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(PROJECT_RESULT_LIST_URL, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData data = responseEntity.getBody();
		return JSON.toJSON(data).toString();
	}

	@RequestMapping(value = "/project/result-saveorupdate", method = RequestMethod.POST)
	public Object updProjectResult(@ModelAttribute("result") IntlProjectResult result, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseEntity<Integer> status = null;
		if (StringUtils.isBlank(result.getResultId())) {
			// 创建一个新的对象
			IntlProjectResult newResult = (IntlProjectResult) MyBeanUtils.createDefaultModel(IntlProjectResult.class);
			newResult.setResultId(IdUtil.createIdByTime());
			newResult.setAppendFiles(IdUtil.createFileIdByTime());
			MyBeanUtils.copyPropertiesIgnoreNull(result, newResult);
			status = this.restTemplate.exchange(PROJECT_RESULT_ADD_URL, HttpMethod.POST, new HttpEntity<IntlProjectResult>(newResult, this.httpHeaders), Integer.class);
		} else {
			// 先查询再更新
			IntlProjectResult oldResult = this.restTemplate.exchange(PROJECT_RESULT_GET_URL + result.getResultId(), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), IntlProjectResult.class).getBody();
			oldResult.setUpdateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
			if (oldResult.getAppendFiles() == null) {
				oldResult.setAppendFiles(IdUtil.createFileIdByTime());
			}
			MyBeanUtils.copyPropertiesIgnoreNull(result, oldResult);
			status = this.restTemplate.exchange(PROJECT_RESULT_UPD_URL, HttpMethod.POST, new HttpEntity<IntlProjectResult>(oldResult, this.httpHeaders), Integer.class);
		}
		if (status.getBody() == 0) {
			return new Result(false);
		} else {
			return new Result(true);
		}
	}

	@RequestMapping(value = "/project/result-close/{resultId}")
	public Object delResult(@PathVariable("resultId") String resultId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 关闭
		ResponseEntity<Integer> presult = this.restTemplate.exchange(PROJECT_RESULT_CLOSE_URL + resultId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
		if (presult.getBody() > 0) {
			return new Result(true, "关闭成功！");
		} else {
			return new Result(false, "关闭失败，请联系系统管理员！");
		}
	}

	@RequestMapping(value = "/project/result-delete/{resultId}")
	public Object delResultRel(@PathVariable("resultId") String resultId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 先查询再删除
		// IntlProjectResult oldresult =
		// this.restTemplate.exchange(PROJECT_RESULT_GET_URL+resultId,
		// HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders),
		// IntlProjectResult.class).getBody();

		// 删除
		ResponseEntity<Integer> presult = this.restTemplate.exchange(PROJECT_RESULT_DEL_URL + resultId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
		if (presult.getBody() > 0) {
			return new Result(true, "删除成功！");
		} else {
			return new Result(false, "删除失败，请联系系统管理员！");
		}
	}

	@RequestMapping(value = "/project/get-result")
	public Object getProjectResult(@RequestParam(value = "resultId", required = true) String resultId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return this.restTemplate.exchange(PROJECT_RESULT_GET_URL + resultId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), IntlProjectResult.class).getBody();
	}
}
