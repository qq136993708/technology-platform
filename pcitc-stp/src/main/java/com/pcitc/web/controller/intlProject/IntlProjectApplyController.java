package com.pcitc.web.controller.intlProject;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.pcitc.base.common.DataTableParam;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.IntlProject.IntlProjectApply;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.DataTableParameter;

@RestController
public class IntlProjectApplyController extends BaseController {

	private static final String PROJECT_APPLY_LIST_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/apply-list";
	private static final String PROJECT_APPLY_ADD_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/add-apply";
	private static final String PROJECT_APPLY_UPD_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/upd-apply";
	private static final String PROJECT_APPLY_GET_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/get-apply/";
	private static final String PROJECT_APPLY_CLOSE_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/close-apply/";
	private static final String PROJECT_APPLY_DEL_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/del-apply/";
	private static final String PROJECT_APPLY_WORKFLOW_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/start-apply-activity/";
	private static final String PROJECT_APPLY_PASS_LIST = "http://pcitc-zuul/stp-proxy/stp-provider/project/get-pass-apply-list";
	private static final String PROJECT_PASS_PLANT_APPLY_LIST = "http://pcitc-zuul/stp-proxy/stp-provider/project/get-pass-plant-apply-list";
	private static final String PROJECT_APPLY_LIST_ALL_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/apply-list-all";
	private static final String PROJECT_APPLY_SENDMAIL = "http://pcitc-zuul/stp-proxy/stp-provider/project/apply-sendnotice/";

	private static final String PROJECT_APPLY_JOIN_URL = "http://pcitc-zuul/stp-proxy/stp-provider/project/join-plant-apply-list";
	private static final String PROJECT_APPLY_NOTJOIN_LIST = "http://pcitc-zuul/stp-proxy/stp-provider/project/notjoin-plant-apply-list";
	private static final String PROJECT_APPLY_CODE = "http://pcitc-zuul/stp-proxy/stp-provider/project/project-code";
	private static final String PROJECT_WORKFLOW_CHECK = "http://pcitc-zuul/stp-proxy/stp-provider/project/apply-flow-check/";

	/*
	 * @RequestMapping(value = "/project/submit-apply-list", method =
	 * RequestMethod.POST) public Object testSaveApplyTableData(@RequestBody
	 * IntlProjectApply [] applyList,HttpServletRequest request) throws
	 * IOException { System.out.println(JSONArray.toJSON(applyList).toString());
	 * return new Result(true); }
	 */

	@RequestMapping(value = "/project/apply-list", method = RequestMethod.POST)
	public Object getApplyTableData(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request) throws IOException {
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(PROJECT_APPLY_LIST_URL, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData data = responseEntity.getBody();
		System.out.println(JSON.toJSON(data).toString());
		return JSON.toJSON(data).toString();
	}

	@RequestMapping(value = "/project/apply-saveorupdate", method = RequestMethod.POST)
	public Object updProjectApply(@ModelAttribute("apply") IntlProjectApply apply, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseEntity<Integer> status = null;
		if (StringUtils.isBlank(apply.getApplyId())) {
			// 创建一个新的对象
			IntlProjectApply newApply = (IntlProjectApply) MyBeanUtils.createDefaultModel(IntlProjectApply.class);
			apply.setApplyId(IdUtil.createIdByTime());
			apply.setAppendFiles(IdUtil.createFileIdByTime());
			apply.setUnitId(sysUserInfo.getUnitId());
			apply.setCreater(sysUserInfo.getUserId());
			MyBeanUtils.copyPropertiesIgnoreNull(apply, newApply);
			System.out.println(JSON.toJSONString(newApply));
			status = this.restTemplate.exchange(PROJECT_APPLY_ADD_URL, HttpMethod.POST, new HttpEntity<IntlProjectApply>(newApply, this.httpHeaders), Integer.class);
		} else {
			// 先查询再更新
			IntlProjectApply oldApply = this.restTemplate.exchange(PROJECT_APPLY_GET_URL + apply.getApplyId(), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), IntlProjectApply.class).getBody();
			// 如果已提交则不可更新
			/*if (FlowStatusEnum.FLOW_START_STATUS_YES.getCode().equals(oldApply.getFlowStartStatus())) {
				return new Result(false, "申报已提交不可再编辑");
			}*/
			Result result = this.restTemplate.exchange(PROJECT_WORKFLOW_CHECK+oldApply.getApplyId(), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Result.class).getBody();
			if(!result.isSuccess()) {
				return result;
			}
			oldApply.setUnitId(sysUserInfo.getUnitId());
			oldApply.setCreater(sysUserInfo.getUserId());
			oldApply.setUpdateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
			if (oldApply.getAppendFiles() == null) {
				apply.setAppendFiles(IdUtil.createFileIdByTime());
			}
			MyBeanUtils.copyPropertiesIgnoreNull(apply, oldApply);
			status = this.restTemplate.exchange(PROJECT_APPLY_UPD_URL, HttpMethod.POST, new HttpEntity<IntlProjectApply>(oldApply, this.httpHeaders), Integer.class);
		}
		if (status.getBody() == 0) {
			return new Result(false);
		} else {
			return new Result(true);
		}
	}

	@RequestMapping(value = "/project/apply-close/{applyId}")
	public Object delApply(@PathVariable("applyId") String applyId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result = this.restTemplate.exchange(PROJECT_WORKFLOW_CHECK+applyId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Result.class).getBody();
		if(!result.isSuccess()) {
			return result;
		}
		ResponseEntity<Integer> presult = this.restTemplate.exchange(PROJECT_APPLY_CLOSE_URL + applyId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
		if (presult.getBody() > 0) {
			return new Result(true, "关闭成功！");
		} else {
			return new Result(false, "关闭失败，请联系系统管理员！");
		}
	}

	@RequestMapping(value = "/project/apply-delete/{applyId}")
	public Object delApplyRel(@PathVariable("applyId") String applyId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*// 先查询再删除
		IntlProjectApply oldplant = this.restTemplate.exchange(PROJECT_APPLY_GET_URL + applyId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), IntlProjectApply.class).getBody();
		// 如果已提交则不可删除
		if (FlowStatusEnum.FLOW_START_STATUS_YES.getCode().equals(oldplant.getFlowStartStatus())) {
			return new Result(false, "已提交不可删除");
		}*/
		Result result = this.restTemplate.exchange(PROJECT_WORKFLOW_CHECK+applyId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Result.class).getBody();
		if(!result.isSuccess()) {
			return result;
		}
		ResponseEntity<Integer> presult = this.restTemplate.exchange(PROJECT_APPLY_DEL_URL + applyId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
		if (presult.getBody() > 0) {
			return new Result(true, "删除成功！");
		} else {
			return new Result(false, "删除失败，请联系系统管理员！");
		}
	}

	@RequestMapping(value = "/project/get-apply")
	public Object getProjectApply(@RequestParam(value = "applyId", required = true) String applyId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("applyId................." + applyId);
		return this.restTemplate.exchange(PROJECT_APPLY_GET_URL + applyId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), IntlProjectApply.class).getBody();
	}

	@RequestMapping(value = "/project/apply-start-workflow")
	public Object startProjectApplyWorkflow(@RequestParam(value = "applyId", required = true) String applyId,
			@RequestParam(value = "functionId", required = true) String functionId, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		WorkflowVo vo = new WorkflowVo();
		vo.setAuditUserIds(this.getUserProfile().getUserId());
		vo.setFunctionId(functionId);
		vo.setAuthenticatedUserId(this.getUserProfile().getUserId());
		vo.setAuthenticatedUserName(this.getUserProfile().getUserDisp());
		vo.setBusinessId(applyId);
		vo.setProcessDefinitionName("项目申报审批");
		
		HttpEntity<WorkflowVo> entity = new HttpEntity<WorkflowVo>(vo, this.httpHeaders);
		Result rs = this.restTemplate.exchange(PROJECT_APPLY_WORKFLOW_URL + applyId, HttpMethod.POST, entity, Result.class).getBody();
		return rs;
	}

	@RequestMapping(value = "/project/get-apply-list")
	public Object getProjectApplyPlant(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return this.restTemplate.exchange(PROJECT_APPLY_GET_URL, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), IntlProjectApply.class).getBody();
	}

	@RequestMapping(value = "/project/get-pass-apply-list")
	public Object getPassApplyProjectList(@RequestBody List<Object> param, HttpServletRequest request, HttpServletResponse response) throws Exception {
		DataTableParam dataTableParam = new DataTableParam();
		MyBeanUtils.transMap2Bean(MyBeanUtils.priseKVJSONToMap(param), dataTableParam);
		System.out.println("获取已审批通过的申报信息。。。。" + JSON.toJSONString(dataTableParam));
		com.alibaba.fastjson.JSONObject retJson = this.restTemplate.exchange(PROJECT_APPLY_PASS_LIST, HttpMethod.POST, new HttpEntity<DataTableParam>(dataTableParam, this.httpHeaders), com.alibaba.fastjson.JSONObject.class).getBody();
		System.out.println("------------" + retJson.toString());

		DataTableParameter data = new DataTableParameter();
		data.setAaData((List<?>) retJson.get("list"));
		// 要显示的总条数
		data.setiTotalDisplayRecords(Long.valueOf(retJson.get("totalCont") + ""));
		// 真实的总条数
		data.setiTotalRecords(Long.valueOf(retJson.get("totalCont") + ""));
		// System.out.println("------------"+retJson.toString());
		return data;
	}

	@RequestMapping(value = "/project/join-plant-apply-list")
	public Object getJoinPlantApplyList(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(PROJECT_APPLY_JOIN_URL, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData data = responseEntity.getBody();
		return JSON.toJSON(data).toString();
	}

	@RequestMapping(value = "/project/notjoin-plant-apply-list")
	public Object getNotJoinPlantApplyList(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(PROJECT_APPLY_NOTJOIN_LIST, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData data = responseEntity.getBody();
		return JSON.toJSON(data).toString();

	}

	@RequestMapping(value = "/project/get-pass-plant-apply-list")
	public Object getPassPlantApplyList(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(PROJECT_PASS_PLANT_APPLY_LIST, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData data = responseEntity.getBody();
		return JSON.toJSON(data).toString();
	}

	@RequestMapping(value = "/project/project-code")
	public Object getUnitCodeByUnitName(@ModelAttribute("apply") IntlProjectApply apply) {
		ResponseEntity<String> responseEntity = restTemplate.exchange(PROJECT_APPLY_CODE, HttpMethod.POST, new HttpEntity<IntlProjectApply>(apply, this.httpHeaders), String.class);
		String rs = responseEntity.getBody();
		return new Result(true, rs);
	}

	@RequestMapping(value = "/project/apply-list-all", method = RequestMethod.POST)
	public Object getApplyListData(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request) throws IOException {
		HttpEntity<Map<?, ?>> entity = new HttpEntity<Map<?, ?>>(param.getParam(), this.httpHeaders);
		List<?> data = this.restTemplate.exchange(PROJECT_APPLY_LIST_ALL_URL, HttpMethod.POST, entity, List.class).getBody();
		System.out.println(JSON.toJSON(data).toString());
		return JSON.toJSON(data).toString();
	}

	@RequestMapping(value = "/project/apply-sendnotice", method = RequestMethod.POST)
	public Object sentApplyEmailNotice(@RequestParam(value = "noticeId", required = true) String noticeId) throws IOException {
		Integer rs = this.restTemplate.exchange(PROJECT_APPLY_SENDMAIL + noticeId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class).getBody();
		if (rs == 0) {
			return new Result(false);
		} else {
			return new Result(true);
		}
	}
}
