package com.pcitc.web.controller.intlProject;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.pcitc.base.stp.IntlProject.IntlProjectContract;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.base.util.StringProcessUtils;
import com.pcitc.web.common.BaseController;

@RestController
public class IntlProjectContractController extends BaseController {

	private static final String PROJECT_CONTRACT_LIST_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/contract-list";
	private static final String PROJECT_CONTRACT_END_LIST_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/contract-end-list";
	private static final String PROJECT_GET_CONTRACT_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/get-contract/";
	private static final String PROJECT_CONTRACT_ADD_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/add-contract";
	private static final String PROJECT_CONTRACT_UPD_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/upd-contract";
	private static final String PROJECT_CONTRACT_CLOSE_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/contract-close/";
	private static final String PROJECT_CONTRACT_DEL_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/contract-delete/";
	
	private static final String PROJECT_CONTRACT_CODE = "http://pcitc-zuul/stp-proxy/stp-provider/project/project-contract-code";
	
	
	@RequestMapping(value = "/project/contract-list", method = RequestMethod.POST)
	public Object getContractTableData(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request) throws IOException {
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(PROJECT_CONTRACT_LIST_URL, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData data = responseEntity.getBody();
		return JSON.toJSON(data).toString();
	}

	@RequestMapping(value = "/project/contract-end-list", method = RequestMethod.POST)
	public Object getEndContractTableData(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request) throws IOException {
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(PROJECT_CONTRACT_END_LIST_URL, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData data = responseEntity.getBody();
		return JSON.toJSON(data).toString();
	}

	@RequestMapping(value = "/project/contract-saveorupdate", method = RequestMethod.POST)
	public Object updProjectApply(@ModelAttribute("contract") IntlProjectContract contract, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseEntity<Integer> status = null;
		if (StringProcessUtils.isBlank(contract.getContractId())) {
			// 创建一个新的对象
			IntlProjectContract newContract = (IntlProjectContract) MyBeanUtils.createDefaultModel(IntlProjectContract.class);
			MyBeanUtils.copyPropertiesIgnoreNull(contract, newContract);
			newContract.setContractId(IdUtil.createIdByTime());
			newContract.setAppendFiles(IdUtil.createFileIdByTime());
			status = this.restTemplate.exchange(PROJECT_CONTRACT_ADD_URL, HttpMethod.POST, new HttpEntity<IntlProjectContract>(newContract, this.httpHeaders), Integer.class);
		} else {
			IntlProjectContract oldContract = this.restTemplate.exchange(PROJECT_GET_CONTRACT_URL + contract.getContractId(), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), IntlProjectContract.class).getBody();
			// 先查询再更新
			oldContract.setUpdateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
			if (oldContract.getAppendFiles() == null) {
				oldContract.setAppendFiles(IdUtil.createFileIdByTime());
			}
			MyBeanUtils.copyPropertiesIgnoreNull(contract, oldContract);
			status = this.restTemplate.exchange(PROJECT_CONTRACT_UPD_URL, HttpMethod.POST, new HttpEntity<IntlProjectContract>(oldContract, this.httpHeaders), Integer.class);
		}
		if (status.getBody() == 0) {
			return new Result(false);
		} else {
			return new Result(true);
		}
	}

	@RequestMapping(value = "/project/get-contract")
	public Object getProjectApply(@RequestParam(value = "contractId", required = true) String contractId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return this.restTemplate.exchange(PROJECT_GET_CONTRACT_URL + contractId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), IntlProjectContract.class).getBody();
	}
	@RequestMapping(value = "/project/contract-close/{contractId}")
	public Object updContractClose(@PathVariable("contractId") String contractId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer rs = this.restTemplate.exchange(PROJECT_CONTRACT_CLOSE_URL + contractId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class).getBody();
		if(rs > 0) {
			return new Result(true);
		}else {
			return new Result(false);
		}
	}
	@RequestMapping(value = "/project/contract-delete/{contractId}")
	public Object updContractDelete(@PathVariable("contractId") String contractId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer rs = this.restTemplate.exchange(PROJECT_CONTRACT_DEL_URL + contractId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class).getBody();
		if(rs > 0) {
			return new Result(true);
		}else {
			return new Result(false);
		}
	}
	
	@RequestMapping(value = "/project/project-contract-code")
	public Object getContractCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer rs = this.restTemplate.exchange(PROJECT_CONTRACT_CODE, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class).getBody();
		if(rs > 0) {
			return new Result(true);
		}else {
			return new Result(false);
		}
	}
}
