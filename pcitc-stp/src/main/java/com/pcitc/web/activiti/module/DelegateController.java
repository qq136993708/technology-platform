package com.pcitc.web.activiti.module;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.workflow.SysDelegate;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.OperationFilter;

/**
 * @author zhf
 * @date 2018年5月13日 上午10:27:55 委托业务
 */
@Controller
public class DelegateController extends BaseController {

	// 委托单列表
	private static final String DELEGATE_PAGE_URL = "http://pcitc-zuul/system-proxy/task-provider/assignees/delegates";

	// 新增委托
	private static final String DELEGATE_ADD_URL = "http://pcitc-zuul/system-proxy/task-provider/delegate";

	/**
	 * @author zhf
	 * @date 2018年5月17日 下午8:09:37 初始化委托查询页面
	 */
	@RequestMapping(value = "/delegate/ini")
	public String iniDelegateList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/pplus/workflow/delegate-list";
	}

	/**
	 * @author zhf
	 * @date 2018年5月17日 下午8:09:37 初始化委托历史查询页面
	 */
	@RequestMapping(value = "/delegate/history/ini")
	public String iniDelegateHistoryList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/pplus/workflow/delegate-history-list";
	}

	/**
	 * @author zhf
	 * @date 2018年5月13日 下午4:44:08 查询所有生效委托
	 */
	@RequestMapping(value = "/delegate/list", method = RequestMethod.POST)
	@ResponseBody
	@OperationFilter(dataFlag = "true")
	public Object getDelegateListForTable(@ModelAttribute("param") LayuiTableParam param) {
		System.out.println("====--------/delegate/list");
		param.getParam().put("assigneeCode", sysUserInfo.getUserId());
		param.getParam().put("status", "1");
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(DELEGATE_PAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();

		return JSON.toJSON(retJson).toString();
	}

	/**
	 * @author zhf
	 * @date 2018年5月13日 下午4:44:08 查询所有委托(生效+失效)
	 */
	@RequestMapping(value = "/delegate/history/list", method = RequestMethod.POST)
	@ResponseBody
	@OperationFilter(dataFlag = "true")
	public Object getDelegateHistoryListForTable(@ModelAttribute("param") LayuiTableParam param) {
		System.out.println("====--------/delegate/history/list");
		// 获取当前登录人信息
		param.getParam().put("assigneeCode", sysUserInfo.getUserId());

		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(DELEGATE_PAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();

		return JSON.toJSON(retJson).toString();
	}

	/**
	 * @author zhf
	 * @date 2018年5月17日 下午8:09:37 初始化新增委托页面
	 */
	@RequestMapping(value = "/delegate/ini-add")
	public String iniAddDelegate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("=====iniAddDelegate");

		request.setAttribute("userInfo", sysUserInfo);

		return "/pplus/workflow/delegate-add";
	}

	/**
	 * 取消委托
	 * 
	 * @author zhf
	 * @date 2018年5月2日 下午4:30:15
	 */
	@RequestMapping(value = "/delegates", method = RequestMethod.DELETE)
	@ResponseBody
	@OperationFilter(modelName = "系统管理--工作流--委托管理", actionName = "取消委托")
	public Result cancelDelegate(@RequestBody SysDelegate delegate) {

		String queryUrl = "http://pcitc-zuul/system-proxy/task-provider/delegates";
		HttpEntity<SysDelegate> entity = new HttpEntity<SysDelegate>(delegate, this.httpHeaders);

		Integer retI = this.restTemplate.exchange(queryUrl, HttpMethod.DELETE, entity, Integer.class).getBody();
		if (retI == 0) {
			return new Result(false, "操作失败!");
		} else {
			return new Result(true, "操作成功!");
		}
	}

	/**
	 * @author zhf
	 * @date 2018年5月9日 上午11:35:32 保存委托
	 */
	@RequestMapping(value = "/delegate", method = RequestMethod.POST)
	@ResponseBody
	@OperationFilter(modelName = "系统管理--工作流--委托管理", actionName = "新增委托")
	public Result delegateInsert(@RequestBody SysDelegate delegate, HttpServletRequest request) throws Exception {
		delegate.setDelegateId(UUID.randomUUID().toString().replaceAll("-", ""));
		delegate.setStatus("1");
		delegate.setCreateUserId(sysUserInfo.getUserId());
		delegate.setCreateUser(sysUserInfo.getUserDisp());
		Integer retI = this.restTemplate.exchange(DELEGATE_ADD_URL, HttpMethod.POST, new HttpEntity<SysDelegate>(delegate, this.httpHeaders), Integer.class).getBody();
		if (retI == 0) {
			return new Result(false, "操作失败!");
		} else if (retI == -1) {
			return new Result(false, "操作失败!此人委托时间内已经委托");
		} else {
			return new Result(true, "操作成功!");
		}
	}

	/**
	 * @param businessId
	 * @param request
	 * @return 获取业务对应的详情信息
	 */
	@RequestMapping(value = "/task/test/details/{businessId}")
	public String testHandleTaskGetDetails(@PathVariable("businessId") String businessId, HttpServletRequest request) {
		System.out.println("1====testHandleTaskGetDetails=========" + businessId);
		httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		SysDelegate delegate = new SysDelegate();
		delegate.setDelegateId(UUID.randomUUID().toString().replaceAll("-", ""));
		delegate.setAssigneeName("后台动态获取姓名张三");
		delegate.setAttorneyName("后台动态获取姓名李四");
		delegate.setCreateDate("2018-02-02");
		delegate.setStartDate("2018-02-02");
		delegate.setEndDate("2018-02-02");
		delegate.setStatus("1");

		request.setAttribute("delegateInfo", delegate);

		return "/pplus/workflow/task-details";
	}

}
