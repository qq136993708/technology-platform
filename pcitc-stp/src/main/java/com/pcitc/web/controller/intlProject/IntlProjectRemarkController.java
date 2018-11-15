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
import com.pcitc.base.stp.IntlProject.IntlProjectRemark;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.web.common.BaseController;

@RestController
public class IntlProjectRemarkController extends BaseController {

	private static final String PROJECT_REMARK_LIST_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/remark-list";
	private static final String PROJECT_REMARK_ADD_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/add-remark";
	private static final String PROJECT_REMARK_UPD_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/upd-remark";
	private static final String PROJECT_REMARK_GET_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/get-remark/";
	private static final String PROJECT_REMARK_CLOSE_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/close-remark/";
	private static final String PROJECT_REMARK_DEL_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/del-remark/";

	@RequestMapping(value = "/project/remark-list", method = RequestMethod.POST)
	public Object getApplyTableData(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request) throws IOException {
		System.out.println("get remark_list data ..........");
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(PROJECT_REMARK_LIST_URL, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData data = responseEntity.getBody();
		System.out.println(JSON.toJSON(data).toString());
		return JSON.toJSON(data).toString();
	}

	@RequestMapping(value = "/project/remark-saveorupdate", method = RequestMethod.POST)
	public Object updProjectRemark(@ModelAttribute("remark") IntlProjectRemark remark, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseEntity<Integer> status = null;
		if (StringUtils.isBlank(remark.getRemarkId())) {
			// 创建一个新的对象
			IntlProjectRemark newRemark = (IntlProjectRemark) MyBeanUtils.createDefaultModel(IntlProjectRemark.class);
			remark.setRemarkId(IdUtil.createIdByTime());
			remark.setAppendFiles(IdUtil.createFileIdByTime());
			MyBeanUtils.copyPropertiesIgnoreNull(remark, newRemark);
			status = this.restTemplate.exchange(PROJECT_REMARK_ADD_URL, HttpMethod.POST, new HttpEntity<IntlProjectRemark>(newRemark, this.httpHeaders), Integer.class);
		} else {
			// 先查询再更新
			IntlProjectRemark oldRemark = this.restTemplate.exchange(PROJECT_REMARK_GET_URL + remark.getRemarkId(), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), IntlProjectRemark.class).getBody();

			oldRemark.setUpdateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
			if (oldRemark.getAppendFiles() == null) {
				oldRemark.setAppendFiles(IdUtil.createFileIdByTime());
			}
			MyBeanUtils.copyPropertiesIgnoreNull(remark, oldRemark);
			status = this.restTemplate.exchange(PROJECT_REMARK_UPD_URL, HttpMethod.POST, new HttpEntity<IntlProjectRemark>(oldRemark, this.httpHeaders), Integer.class);
		}
		if (status.getBody() == 0) {
			return new Result(false);
		} else {
			return new Result(true);
		}
	}

	@RequestMapping(value = "/project/remark-close/{remarkId}")
	public Object delRemark(@PathVariable("remarkId") String remarkId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 关闭
		ResponseEntity<Integer> presult = this.restTemplate.exchange(PROJECT_REMARK_CLOSE_URL + remarkId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
		if (presult.getBody() > 0) {
			return new Result(true, "关闭成功！");
		} else {
			return new Result(false, "关闭失败，请联系系统管理员！");
		}
	}

	@RequestMapping(value = "/project/remark-delete/{remarkId}")
	public Object delRemarkRel(@PathVariable("remarkId") String remarkId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 先查询再删除
		// IntlProjectRemark oldplant =
		// this.restTemplate.exchange(PROJECT_REMARK_GET_URL+remarkId,
		// HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders),
		// IntlProjectRemark.class).getBody();

		// 删除
		ResponseEntity<Integer> presult = this.restTemplate.exchange(PROJECT_REMARK_DEL_URL + remarkId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
		if (presult.getBody() > 0) {
			return new Result(true, "删除成功！");
		} else {
			return new Result(false, "删除失败，请联系系统管理员！");
		}
	}

	@RequestMapping(value = "/project/get-remark")
	public Object getProjectApply(@RequestParam(value = "remarkId", required = true) String remarkId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("remarkId................." + remarkId);
		return this.restTemplate.exchange(PROJECT_REMARK_GET_URL + remarkId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), IntlProjectRemark.class).getBody();
	}

}
