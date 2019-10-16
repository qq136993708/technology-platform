package com.pcitc.web.controller.mobile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.InforVo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Page;
import com.pcitc.base.common.Result;
import com.pcitc.base.plan.PlanBase;
import com.pcitc.base.plan.PlanBaseDetail;
import com.pcitc.base.system.SysNotice;
import com.pcitc.base.system.SysNoticeVo;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CodeUtil;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.StrUtil;
import com.pcitc.base.workflow.ActivityVo;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.OperationFilter;
import com.pcitc.web.utils.PinyinUtil;

@Controller
public class MobileWorkbechController extends BaseController {

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
	private static final String BOT_WORK_ORDER_LIST = "http://pcitc-zuul/system-proxy/planClient-provider/botWorkOrder_list";
	// 我的工单
	private static final String MY_BOT_WORK_ORDER_LIST = "http://pcitc-zuul/system-proxy/planClient-provider/my/botWorkOrder_list";
	//
	private static final String VIEW_BOT_WORK_ORDER = "http://pcitc-zuul/system-proxy/planClient-provider/viewBotWorkOrder/";
	// 查看我的工单事项反馈集合
	private static final String VIEW_MY_BOT_WORK_ORDER_MATTER_LIST = "http://pcitc-zuul/system-proxy/planClient-provider/queryMyBotWorkOrderMatterList";
	// 查看工单事项集合
	private static final String VIEW_BOT_WORK_ORDER_MATTER_LIST = "http://pcitc-zuul/system-proxy/planClient-provider/queryBotWorkOrderMatterList";
	// 提交
	private static final String SUBMIT_MY_BOT_WORK_ORDER = "http://pcitc-zuul/system-proxy/planClient-provider/submitMyBotWorkOrder/";
	// 修改
	private static final String EDIT_BOT_WORK_ORDER = "http://pcitc-zuul/system-proxy/planClient-provider/editBotWorkOrder";
	// 提交
	private static final String AFFIRM_BOT_WORK_ORDER = "http://pcitc-zuul/system-proxy/planClient-provider/affirmBotWorkOrder/";
	// 批量保存工单事项
	private static final String SAVE_MY_BOT_WORK_ORDER_MATTER_BATCH = "http://pcitc-zuul/system-proxy/planClient-provider/saveMyBotWorkOrderMatterBatch";
	private static final String getAllUserList = "http://pcitc-zuul/system-proxy/user-provider/getAllUserList";
	// 提交
	private static final String SUBMIT_BOT_WORK_ORDER = "http://pcitc-zuul/system-proxy/planClient-provider/submitBotWorkOrder/";
	// 保存新增
	private static final String SAVE_BOT_WORK_ORDER = "http://pcitc-zuul/system-proxy/planClient-provider/saveBotWorkOrder";
	// 批量保存任务
	private static final String SAVE_PLAN_BASE_BATCH = "http://pcitc-zuul/system-proxy/planClient-provider/savePlanBaseBatch";
	// 事例任务列表
	private static final String INSTANCE_TASK_PAGE_URL = "http://pcitc-zuul/system-proxy/task-provider/task/process/list/";

	// 获取审批人是自动配置，还是选择的标识
	private static final String AUDIT_FLAG_URL = "http://pcitc-zuul/system-proxy/task-provider/task/audit/flag/";

	// 获取下一步审批人
	private static final String DEAL_USER_URL = "http://pcitc-zuul/system-proxy/task-provider/task/deal/user";

	private static final String UNIT_POST_PART_TREE = "http://pcitc-zuul/system-proxy/unit-provider/units-posts-users/part-tree";
	private static final String UNIT_PART_TREE = "http://pcitc-zuul/system-proxy/unit-provider/units-users/part-tree";

	// 任务处理
	private static final String COMPLETE_TASK_URL = "http://pcitc-zuul/system-proxy/task-provider/task/complete";

	private String basePath;

	// 添加工作安排
	@RequestMapping(value = "/kjptmobile/work_add")
	public String work_add(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setAttribute("flag", "add");
		request.setAttribute("dataId", UUID.randomUUID().toString().replace("-", ""));
		request.setAttribute("userName", sysUserInfo.getUserDisp());
		request.setAttribute("unitName", sysUserInfo.getUnitName());
		request.setAttribute("bak6", sysUserInfo.getUserId());
		request.setAttribute("bak4", sysUserInfo.getUserDisp());
		request.setAttribute("closeType", "1");
		return "/kjptmobile/work_add";
	}

	// 选下一步处理人
	@RequestMapping(value = "/kjptmobile/implement")
	public String implement(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/kjptmobile/implement";
	}

	// 选下一步处理人
	@RequestMapping(value = "/kjptmobile/user/querySysUserListByPage")
	@ResponseBody
	public Object querySysUserListByPage(HttpServletRequest request) throws IOException {
		// 获取下一步处理人
		String keyWord = CommonUtil.getParameter(request, "keyWord", "");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("keyWord", keyWord);
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap, this.httpHeaders);
		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getAllUserList, HttpMethod.POST, httpEntity, JSONArray.class);
		JSONArray result = responseEntity.getBody();
		List<SysUser> list = JSONObject.parseArray(result.toJSONString(), SysUser.class);
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				SysUser sysUser = list.get(i);
				String unitName = sysUser.getUnitName();
				if (unitName != null) {
					String arr[] = unitName.split(",");
					unitName = arr[arr.length - 1];

				}
				sysUser.setUnitName(unitName.replace("股份有限公司", "").replace("有限责任公司", ""));
				Map<String, String> map = PinyinUtil.changeChinese2Pinyin(sysUser.getUserDisp());

				String fullPin = map.get("fullPin");
				String bigPin = map.get("bigPin");
				String smallPin = map.get("smallPin");
				String bigFirstPin = map.get("bigFirstPin");
				sysUser.setNameBigPin(bigPin);
				sysUser.setNameSmallPin(smallPin);
				sysUser.setNameFullPin(fullPin);
				sysUser.setNameBigFirstPin(bigFirstPin);
			}

			Collections.sort(list, new Comparator<SysUser>() {
				public int compare(SysUser p1, SysUser p2) {
					return p1.getNameBigFirstPin().compareTo(p2.getNameBigFirstPin());
				}
			});
		}

		JSONArray array = JSONArray.parseArray(JSON.toJSONString(list));
		// 安全设置：归档文件下载
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		return array.toArray();
	}

	/**
	 * 用户选择:页面跳转
	 *
	 * @param request
	 * @return
	 */
	/*
	 * @RequestMapping(method = RequestMethod.GET, value =
	 * "/kjptmobile/plan/pageSelectUser") private String
	 * pageSelectUser(HttpServletRequest request) { return
	 * "/kjptmobile/pageSelectUser"; }
	 */

	@RequestMapping(value = "/kjptmobile/agencyM")
	@OperationFilter(modelName = "移动端", actionName = "待办任务模块")
	public String agencyM(HttpServletRequest request) throws IOException {
		return "/kjptmobile/agencyM";
	}

	@RequestMapping(value = "/kjptmobile/work")
	public String work(HttpServletRequest request) throws IOException {

		basePath = request.getContextPath();
		request.setAttribute("basePath", basePath);

		// 安全设置：归档文件下载
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		return "/kjptmobile/work";
	}

	@RequestMapping(value = "/kjptmobile/work_details")
	public String work_details(HttpServletRequest request) throws IOException {

		String dataId = request.getParameter("dataId");
		request.setAttribute("dataId", dataId);
		ResponseEntity<PlanBase> responseEntity = this.restTemplate.exchange(VIEW_BOT_WORK_ORDER + dataId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), PlanBase.class);
		PlanBase planBase = responseEntity.getBody();
		request.setAttribute("planBase", planBase);

		// 工作安排列表
		int page = request.getParameter("page") == null ? 1 : Integer.parseInt((String) request.getParameter("page"));
		LayuiTableParam param = new LayuiTableParam();
		param.setPage(page);
		param.setLimit(100);
		param.getParam().put("workOrderId", dataId);
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> rs = this.restTemplate.exchange(VIEW_BOT_WORK_ORDER_MATTER_LIST, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData layuiTableData = rs.getBody();
		request.setAttribute("list", layuiTableData.getData());

		return "/kjptmobile/work_details";
	}

	// 我处理的
	@RequestMapping(value = "/kjptmobile/work_details_1")
	public String work_details1(HttpServletRequest request) throws IOException {
		String dataId = request.getParameter("dataId");
		request.setAttribute("dataId", dataId);
		ResponseEntity<PlanBase> responseEntity = this.restTemplate.exchange(VIEW_BOT_WORK_ORDER + dataId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), PlanBase.class);
		PlanBase planBase = responseEntity.getBody();
		request.setAttribute("planBase", planBase);
		// 工作处理---我处理的列表
		LayuiTableData finished = this.getDealWorkSendFinished(request, restTemplate, httpHeaders);
		// 工作处理---任务接收后，下发给其他人员的工作安排列表
		LayuiTableData send = this.getDealWorkSendOthedr(request, restTemplate, httpHeaders);

		request.setAttribute("finishedList", finished.getData());
		request.setAttribute("sendList", send.getData());
		return "/kjptmobile/work_details_1";
	}

	// 工作处理---我处理的列表
	@RequestMapping(value = "/kjptmobile/plan/queryMyBotWorkOrderMatterList")
	@ResponseBody
	public Object queryMyBotWorkOrderMatterList(HttpServletRequest request) {

		LayuiTableData result = this.getDealWorkSendFinished(request, restTemplate, httpHeaders);
		// 安全设置：归档文件下载
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		return JSON.toJSONString(result);
	}

	private static LayuiTableData getDealWorkSendFinished(HttpServletRequest request, RestTemplate restTemplate, HttpHeaders httpHeaders) {
		String dataId = request.getParameter("dataId");
		int page = request.getParameter("page") == null ? 1 : Integer.parseInt((String) request.getParameter("page"));
		LayuiTableParam param = new LayuiTableParam();
		param.setPage(page);
		param.setLimit(100);
		param.getParam().put("workOrderId", dataId);
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(VIEW_MY_BOT_WORK_ORDER_MATTER_LIST, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData result = responseEntity.getBody();
		return result;

	}

	// 工作处理---任务接收后，下发给其他人员的工作安排列表
	@RequestMapping(value = "/kjptmobile/plan/queryBotWorkOrderMatterList")
	@ResponseBody
	public Object queryBotWorkOrderMatterList(HttpServletRequest request, HttpServletResponse response) {

		LayuiTableData result = this.getDealWorkSendOthedr(request, restTemplate, httpHeaders);
		// 安全设置：归档文件下载
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		return JSON.toJSONString(result);
	}

	private static LayuiTableData getDealWorkSendOthedr(HttpServletRequest request, RestTemplate restTemplate, HttpHeaders httpHeaders) {
		String dataId = request.getParameter("dataId");
		int page = request.getParameter("page") == null ? 1 : Integer.parseInt((String) request.getParameter("page"));
		LayuiTableParam param = new LayuiTableParam();
		param.setPage(page);
		param.setLimit(100);
		param.getParam().put("workOrderId", dataId);
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(VIEW_BOT_WORK_ORDER_MATTER_LIST, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData result = responseEntity.getBody();
		return result;

	}

	/**
	 * 获取工单管理信息
	 */
	@RequestMapping(value = "/kjptmobile/plan/viewBotWorkOrder")
	@ResponseBody
	public Object viewBotWorkOrder(HttpServletRequest request) {
		String dataId = request.getParameter("dataId");
		ResponseEntity<PlanBase> responseEntity = this.restTemplate.exchange(VIEW_BOT_WORK_ORDER + dataId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), PlanBase.class);
		PlanBase result = responseEntity.getBody();
		return result;
	}

	/**
	 * 工作安排(我安排的)
	 */
	@RequestMapping(value = "/kjptmobile/plan/getTableData", method = RequestMethod.POST)
	@ResponseBody
	public Object getTableData(HttpServletRequest request) throws IOException {

		String parentId = CommonUtil.getParameter(request, "parentId", "");
		int page = request.getParameter("page") == null ? 1 : Integer.parseInt((String) request.getParameter("page"));
		LayuiTableParam param = new LayuiTableParam();
		param.setPage(page);
		param.setLimit(15);
		// 只查询本人创建的
		param.getParam().put("createUser", sysUserInfo.getUserId());
		param.getParam().put("parentId", parentId);

		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(BOT_WORK_ORDER_LIST, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData result = responseEntity.getBody();
		CommonUtil.addAttachmentField(result, restTemplate, httpHeaders);
		JSONObject retJson = (JSONObject) JSON.toJSON(result);
		return retJson;
	}

	/**
	 * 工作安排(别人安排 给我的)
	 */
	@RequestMapping(value = "/kjptmobile/plan/my/getTableData", method = RequestMethod.POST)
	@ResponseBody
	public Object getMyTableData(HttpServletRequest request) throws IOException {

		String isSchedule = CommonUtil.getParameter(request, "isSchedule", "");
		String bak7 = CommonUtil.getParameter(request, "bak7", "");
		String isChildren = CommonUtil.getParameter(request, "isChildren", "");

		int page = request.getParameter("page") == null ? 1 : Integer.parseInt((String) request.getParameter("page"));
		LayuiTableParam param = new LayuiTableParam();
		param.setPage(page);
		param.setLimit(15);

		param.getParam().put("isSchedule", isSchedule);
		param.getParam().put("bak7", bak7);
		param.getParam().put("isChildren", isChildren);

		Map<String, Object> map = param.getParam();
		map.put("workOrderAllotUserId", sysUserInfo.getUserId());
		if (param.getParam().get("workOrderStatus") == null || "".equals(param.getParam().get("workOrderStatus"))) {
			map.put("workOrderStatus", "1,2");
		}
		param.setParam(map);
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(MY_BOT_WORK_ORDER_LIST, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData result = responseEntity.getBody();
		CommonUtil.addAttachmentField(result, restTemplate, httpHeaders);
		JSONObject retJson = (JSONObject) JSON.toJSON(result);
		return retJson;
	}

	// 处理工单
	@RequestMapping(value = "/kjptmobile/plan/submitMyBotWorkOrder")
	@ResponseBody
	public int submitMyBotWorkOrder(HttpServletRequest request) {
		int result;
		result = saveMyBotWorkOrderMatterFeedBack(request);
		String param = request.getParameter("param");
		JSONObject jsStr = (JSONObject) JSON.parseObject(param);
		String dataId = jsStr.getString("dataId");
		// if (result == 200) {
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SUBMIT_MY_BOT_WORK_ORDER + dataId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), Integer.class);
		result = responseEntity.getBody();
		// }
		return result;
	}

	/**
	 * 保存我的工单事项反馈
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/kjptmobile/plan/saveMyBotWorkOrderMatterFeedBack")
	@ResponseBody
	public int saveMyBotWorkOrderMatterFeedBack(HttpServletRequest request) {
		String param = request.getParameter("param");
		// System.out.println("--saveMyBotWorkOrderMatterFeedBack="+param);
		JSONObject jsStr = (JSONObject) JSON.parseObject(param);
		jsStr.put("auditSts", "0");
		jsStr.put("createDate", DateUtil.dateToStr(new Date(), DateUtil.FMT_SS));
		jsStr.put("dataOrder", new Date().getTime() + "");
		jsStr.put("updateDate", DateUtil.dateToStr(new Date(), DateUtil.FMT_SS));
		jsStr.put("updateUser", sysUserInfo.getUserId());
		jsStr.put("updateUserName", sysUserInfo.getUserDisp());
		jsStr.put("status", "0");
		jsStr.put("unitName", sysUserInfo.getUnitName());

		List<PlanBaseDetail> matterList = new ArrayList<PlanBaseDetail>();
		if (jsStr.containsKey("matterList")) {
			JSONArray array = jsStr.getJSONArray("matterList");
			for (int i = 0; i < array.size(); i++) {
				PlanBaseDetail matterVo = JSONObject.toJavaObject(array.getJSONObject(i), PlanBaseDetail.class);
				matterVo.setWorkOrderId(jsStr.getString("dataId"));
				matterVo.setDataOrder(i + "");
				matterVo.setMatterType("1");
				matterVo.setStatus("0");
				matterVo.setDataId(UUID.randomUUID().toString().replace("-", ""));

				matterVo.setCreateUser(sysUserInfo.getUserId());
				matterVo.setCreateUserName(sysUserInfo.getUserDisp());
				matterVo.setCreateDate(DateUtil.dateToStr(new Date(), DateUtil.FMT_SS));

				matterList.add(matterVo);
			}
		}
		// 保存主表信息
		String dataId = jsStr.getString("dataId");
		ResponseEntity<PlanBase> resultEntity = this.restTemplate.exchange(VIEW_BOT_WORK_ORDER + dataId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), PlanBase.class);
		PlanBase wjbvo = resultEntity.getBody();
		wjbvo = (PlanBase) JSONObject.toJavaObject(jsStr, PlanBase.class);
		wjbvo.setUpdateDate(DateUtil.dateToStr(new Date(), DateUtil.FMT_SS));
		wjbvo.setUpdateUser(sysUserInfo.getUserId());
		wjbvo.setUpdateUserName(sysUserInfo.getUserDisp());
		wjbvo.setDelFlag("0");
		HttpEntity<PlanBase> entity = new HttpEntity<PlanBase>(wjbvo, this.httpHeaders);
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(EDIT_BOT_WORK_ORDER, HttpMethod.POST, entity, Integer.class);

		// 保存从表新
		PlanBase pb = new PlanBase();
		pb.setDataId(wjbvo.getDataId());
		pb.setPlanBaseDetailList(matterList);
		HttpEntity<PlanBase> entityList = new HttpEntity<PlanBase>(pb, this.httpHeaders);
		ResponseEntity<Integer> responseEntityList = this.restTemplate.exchange(SAVE_MY_BOT_WORK_ORDER_MATTER_BATCH, HttpMethod.POST, entityList, Integer.class);
		int result = responseEntityList.getBody();
		try {
			CommonUtil.updateFileFlag(restTemplate, httpHeaders, jsStr.getString("dataId"));
		} catch (Exception e) {
			e.printStackTrace();
			result = 500;
		}
		return result;
	}

	// 处理待办
	@RequestMapping(value = "/kjptmobile/task/pending/deal/{taskId}")
	public String iniDealTask(@PathVariable("taskId") String taskId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// System.out.println("1=====iniDealTask====" + taskId);

		WorkflowVo workflowVo = new WorkflowVo();
		workflowVo.setTaskId(taskId);
		ResponseEntity<JSONObject> retJson = this.restTemplate.exchange(INI_DEAL_TASK, HttpMethod.POST, new HttpEntity<WorkflowVo>(workflowVo, this.httpHeaders), JSONObject.class);
		// System.out.println("iniDealTask=====" + retJson.getBody());
		// 当前审批人信息
		request.setAttribute("userInfo", sysUserInfo);
		request.setAttribute("auditDetailsPath", retJson.getBody().get("auditDetailsPath"));
		request.setAttribute("id", retJson.getBody().get("id"));
		return "/kjptmobile/workflow/deal-task";
	}

	// 待办任务数据
	@RequestMapping(value = "/kjptmobile/wait_task_list_data")
	@ResponseBody
	public LayuiTableData wait_task_list_data(HttpServletRequest request) {
		int page = request.getParameter("page") == null ? 1 : Integer.parseInt((String) request.getParameter("page"));
		LayuiTableParam param = new LayuiTableParam();
		param.setPage(page);
		param.setLimit(15);
		// 获取当前登录人信息
		param.getParam().put("userId", sysUserInfo.getUserId());
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(PENDING_PAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();

		return retJson;
	}

	// 已办任务数据
	@RequestMapping(value = "/kjptmobile/finished_task_list_data")
	@ResponseBody
	public LayuiTableData finished_task_list_data(HttpServletRequest request) {
		int page = request.getParameter("page") == null ? 1 : Integer.parseInt((String) request.getParameter("page"));
		LayuiTableParam param = new LayuiTableParam();
		param.setPage(page);
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
	@RequestMapping(value = "/kjptmobile/task/other/pending-list", method = RequestMethod.POST)
	@ResponseBody
	public Object otherPendingList(HttpServletRequest request) {

		int page = request.getParameter("page") == null ? 1 : Integer.parseInt((String) request.getParameter("page"));
		LayuiTableParam param = new LayuiTableParam();
		param.setPage(page);
		param.setLimit(15);

		// System.out.println("==== 待办 param-->" +
		// JSON.toJSON(param).toString());
		// 获取当前登录人信息, 统一身份名作为用户id
		param.getParam().put("userId", sysUserInfo.getUserName());
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(XMGL_PENDING, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();

		return JSON.toJSON(retJson).toString();
	}

	@RequestMapping(value = "/kjptmobile/message_list")
	public String message_list(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/kjptmobile/message_list";
	}

	@RequestMapping(value = "/kjptmobile/message_list_data", method = RequestMethod.POST)
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

	@RequestMapping(value = "/kjptmobile/message_list", method = RequestMethod.POST)
	@ResponseBody
	public Object message_list(@ModelAttribute("param") LayuiTableParam param) {

		// 获取当前登录人信息
		param.getParam().put("userId", sysUserInfo.getUserId());
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(MESSAGE_LIST, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();
		// return JSON.toJSON(retJson).toString();

		return "/kjptmobile/message_list";
	}

	/**
	 * 查看公告
	 * 
	 * @return
	 */
	@RequestMapping(value = "/kjptmobile/sysNotice/readNotice")
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

	/**
	 * 新增、编辑工作任务单时的保存方法
	 */
	@RequestMapping(value = "/kjptmobile/plan/submitBotWorkOrder")
	@ResponseBody
	public int submitBotWorkOrder(HttpServletRequest request) {
		int result;
		String workOrderStatus = request.getParameter("workOrderStatus");
		result = saveBotWorkOrder(request);
		String param = request.getParameter("param");
		JSONObject jsStr = (JSONObject) JSON.parseObject(param);
		String dataId = jsStr.getString("dataId");
		if (result == 200) {
			ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SUBMIT_BOT_WORK_ORDER + dataId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), Integer.class);
			result = responseEntity.getBody();
		}
		return result;
	}

	@RequestMapping(value = "/kjptmobile/plan/saveBotWorkOrder")
	@ResponseBody
	public int saveBotWorkOrder(HttpServletRequest request) {
		String code = CodeUtil.getCode("XTBM_0048", restTemplate, httpHeaders);
		String param = request.getParameter("param");
		// String strCreateUser = sysUserInfo.getUserId();
		JSONObject jsStr = (JSONObject) JSON.parseObject(param);
		jsStr.put("dataCode", code);
		jsStr.put("auditSts", "0");
		jsStr.put("createDate", DateUtil.dateToStr(new Date(), DateUtil.FMT_SS));
		jsStr.put("createUser", sysUserInfo.getUserId());
		jsStr.put("createUserName", sysUserInfo.getUserDisp());
		jsStr.put("dataOrder", new Date().getTime() + "");
		jsStr.put("workOrderStatus", "0");
		jsStr.put("status", "0");
		jsStr.put("workOrderCode", code);
		jsStr.put("unitName", sysUserInfo.getUnitName());
		if (jsStr.getString("scheduleType") != null && !jsStr.getString("scheduleType").equals("")) {
			// 需要定时处理
			jsStr.put("isSchedule", "1");
		} else {
			// 实时任务
			jsStr.put("isSchedule", "0");
			jsStr.put("scheduleDate", "");
		}
		PlanBase bsv = JSONObject.toJavaObject(jsStr, PlanBase.class);

		bsv.setDelFlag("0");
		List<PlanBase> baseList = new ArrayList<PlanBase>();
		if (jsStr.containsKey("matterList")) {
			JSONArray array = jsStr.getJSONArray("matterList");
			for (int i = 0; i < array.size(); i++) {
				// 取值赋给PlanBase
				JSONObject detail = array.getJSONObject(i);
				PlanBase planBase = new PlanBase();
				planBase.setWorkOrderName(detail.get("workOrderName").toString());
				planBase.setWorkOrderAllotUserId(detail.get("workOrderAllotUserId").toString());// 当前节点处理人
				planBase.setParentId(bsv.getDataId());
				planBase.setDelFlag("0");
				planBase.setBl("");
				planBase.setDataId("".equals(detail.get("dataId")) ? UUID.randomUUID().toString().replace("-", "") : detail.get("dataId").toString());
				planBase.setWorkOrderAllotUserName(detail.get("workOrderAllotUserName").toString());// 当前节点处理人
				planBase.setWorkOrderStatus("0");
				planBase.setRedactUnitName(bsv.getRedactUnitName());
				planBase.setWorkOrderType(bsv.getWorkOrderType());

				// 记录父节点的相关信息，方便显示
				planBase.setDataCode(bsv.getDataCode());
				planBase.setWorkOrderCode(bsv.getDataCode());
				planBase.setCreateUser(bsv.getCreateUser());
				planBase.setCreateUserName(bsv.getCreateUserName());
				planBase.setCreateDate(bsv.getCreateDate());
				planBase.setStatus(bsv.getStatus());

				// 定时的任务暂时不让受理人看到。子工作任务不用考虑定时时间/类型
				planBase.setIsSchedule(bsv.getIsSchedule());

				// System.out.println("announcements = " +
				// detail.get("announcements"));
				planBase.setAnnouncements(StrUtil.objectToString(detail.get("announcements")));
				baseList.add(planBase);
			}
		}
		HttpEntity<PlanBase> entity = new HttpEntity<PlanBase>(bsv, this.httpHeaders);
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SAVE_BOT_WORK_ORDER, HttpMethod.POST, entity, Integer.class);
		int result = responseEntity.getBody();

		HttpEntity<List<PlanBase>> entityList = new HttpEntity<List<PlanBase>>(baseList, this.httpHeaders);
		ResponseEntity<Integer> responseEntityList = this.restTemplate.exchange(SAVE_PLAN_BASE_BATCH, HttpMethod.POST, entityList, Integer.class);
		try {
			CommonUtil.updateFileFlag(restTemplate, httpHeaders, bsv.getDataId());
		} catch (Exception e) {
			e.printStackTrace();
			result = 500;
		}
		return result;
	}

	@RequestMapping(value = "/kjptmobile/task/process/{instanceId}", method = RequestMethod.GET)
	public String processShow(@PathVariable("instanceId") String instanceId, HttpServletRequest request) {
		return "/kjptmobile/task_process_show";
	}

	/**
	 * 显示流程的列表
	 * 
	 * @author zhf
	 * @date 2018年4月23日 下午5:19:25
	 */
	@RequestMapping(value = "/kjptmobile/task/process/list/{instanceId}", method = RequestMethod.POST)
	@ResponseBody
	public Object processList(@PathVariable("instanceId") String instanceId, HttpServletRequest request) {

		httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		// 获取当前登录人信息
		JSONObject jsonStr = new JSONObject();
		jsonStr.put("page", request.getParameter("page")); // 起始索引
		jsonStr.put("limit", request.getParameter("limit")); // 每页显示的行数

		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
		requestBody.add("jsonStr", jsonStr.toJSONString());
		// System.out.println("2====processList====" + jsonStr.toJSONString());
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, httpHeaders);

		ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(INSTANCE_TASK_PAGE_URL + instanceId, HttpMethod.POST, entity, JSONObject.class);
		JSONObject retJson = responseEntity.getBody();

		Long totalCount = retJson.get("totalCount") != null ? Long.parseLong(retJson.get("totalCount").toString()) : 0l;
		List<ActivityVo> auditList = JSONArray.parseArray(retJson.getJSONArray("list").toString(), ActivityVo.class);

		JSONObject jsonObj = new JSONObject();
		jsonObj.put("code", "0");
		jsonObj.put("msg", "提示");
		jsonObj.put("count", totalCount);
		jsonObj.put("data", auditList);
		// System.out.println("2====processList====" + jsonObj.toString());
		return jsonObj.toString();
	}

	/**
	 * 判断是否需要选择审批人
	 */
	@RequestMapping(value = "/kjptmobile/task/auditor/flag/{taskId}")
	@ResponseBody
	public Object selectAuditorFlag(@PathVariable("taskId") String taskId, HttpServletRequest request, HttpServletResponse response) throws Exception {

		ResponseEntity<String> responseEntity = this.restTemplate.exchange(AUDIT_FLAG_URL + taskId, HttpMethod.POST, new HttpEntity<Object>(httpHeaders), String.class);
		String auditFlag = responseEntity.getBody();
		System.out.println("====/kjptmobile/task/selectAuditorFlag-------------" + auditFlag);
		if (auditFlag != null) {
			if (auditFlag.startsWith("role")) {
				return new Result(true, auditFlag.split("--")[1], "操作成功", "role");
			} else if (auditFlag.startsWith("unit")) {
				return new Result(true, auditFlag.split("--")[1], "操作成功", "unit");
			} else if (auditFlag.startsWith("post")) {
				return new Result(true, auditFlag.split("--")[1], "操作成功", "post");
			} else {
				return new Result(true, null, "操作成功", "common");
			}
		} else {
			return new Result(true, null, "操作失败", "error");
		}

	}

	/**
	 * 跳转到通过角色选择用户的界面
	 */
	@RequestMapping(value = "/kjptmobile/task/deal/users/ini")
	public String iniDealUser(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/kjptmobile/workflow/deal-user-list";
	}

	/**
	 * 查询所有的下一个节点需要处理的人（角色用列表）
	 * 
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/kjptmobile/task/deal/user", method = RequestMethod.POST)
	@ResponseBody
	public Object getDealUser(@ModelAttribute("param") LayuiTableParam param) {
		System.out.println("====/task/getDealUser---");
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(DEAL_USER_URL, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();

		return JSON.toJSON(retJson).toString();
	}

	/**
	 * 跳转到通过组织机构选择用户的界面
	 */
	@RequestMapping(value = "/kjptmobile/task/deal/user/unit/ini")
	public String iniDealUserUnit(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/kjptmobile/workflow/deal-user-unit";
	}

	/**
	 * 组织机构树, 有组织机构和、岗位、人员-- 查询某些岗位节点的组织机构树,只查询这些节点的所有子孙和直系父辈
	 */
	@RequestMapping(value = "/kjptmobile/unit/units-posts/part-tree")
	@ResponseBody
	public String getUnitTreeAndPostsAndUserByPostCodes(HttpServletRequest request) throws Exception {
		httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		JSONObject reJson = new JSONObject();
		// System.out.println("getUnitTreeAndPostsAndUserByPostCodes=====" +
		// request.getParameter("postCodes"));
		reJson.put("postCodes", request.getParameter("postCodes"));

		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
		requestBody.add("jsonStr", reJson.toString());
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, httpHeaders);

		ResponseEntity<?> responseEntity = this.restTemplate.exchange(UNIT_POST_PART_TREE, HttpMethod.POST, entity, List.class);
		// System.out.println("getUnitTreeAndPostsAndUserByPostCodes=====" +
		// JSONUtils.toJSONString(responseEntity.getBody()));
		return JSONUtils.toJSONString(responseEntity.getBody());
	}

	/**
	 * 组织机构树, 有组织机构和人员, 没有岗位-- 查询某些组织机构节点的组织机构树,只查询这些节点的所有子孙和直系父辈
	 */
	@RequestMapping(value = "/kjptmobile/unit/units/part-tree")
	@ResponseBody
	public String getUnitTreeAndUserByUnitCodes(HttpServletRequest request) throws Exception {
		httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		JSONObject reJson = new JSONObject();
		// System.out.println("1getUnitTreeAndUserByUnitCodes=====" +
		// request.getParameter("unitCodes"));
		reJson.put("unitCodes", request.getParameter("unitCodes"));

		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
		requestBody.add("jsonStr", reJson.toString());
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, httpHeaders);

		ResponseEntity<?> responseEntity = this.restTemplate.exchange(UNIT_PART_TREE, HttpMethod.POST, entity, List.class);
		// System.out.println("2getUnitTreeAndUserByUnitCodes=====" +
		// JSONUtils.toJSONString(responseEntity.getBody()));
		return JSONUtils.toJSONString(responseEntity.getBody());
	}

	/**
	 * 任务办理
	 * 
	 * @author zhf
	 * @date 2018年4月23日 下午5:23:00
	 */
	@RequestMapping(value = "/kjptmobile/task/complete/{taskId}", method = RequestMethod.POST)
	@ResponseBody
	@OperationFilter(modelName = "系统管理", actionName = "处理待办任务")
	public Result completeTask(@PathVariable("taskId") String taskId, @RequestBody String param, HttpServletRequest request) {
		System.out.println("动态获取的前台页面审批意见======" + param);
		JSONArray jsArr = JSONObject.parseArray(param);
		System.out.println("动态获取的前台页面审批意见======" + jsArr.getJSONObject(0));
		JSONObject json = jsArr.getJSONObject(0);
		WorkflowVo workflowVo = new WorkflowVo();
		workflowVo.setTaskId(taskId);
		// 本步审批人(名称为了以后查询方便)
		workflowVo.setAuditorId(sysUserInfo.getUserId());
		workflowVo.setAuditorName(sysUserInfo.getUserDisp());

		Map<String, Object> variables = new HashMap<String, Object>();

		// 传递参数的不同，本次参数名是agree，之后统一在参数中设置
		variables.put("agree", json.getString("agree"));
		variables.put("comment", json.getString("auditRemarks"));

		// 下一步的审批人。审批不通过时，退回到starter，通过画流程图时：开始节点和第一个节点的特定设置来自动完成
		// 下一步的审批人，要么通过此次审批时选择，要么通过角色进行的配置。
		if (json.getString("userIds") != null && !json.getString("userIds").equals("")) {
			// 前端已经选择审批人
			String[] candidateUsers = json.getString("userIds").split(",");
			System.out.println("前端已经选择审批人======" + json.getString("userIds"));
			variables.put("auditor", Arrays.asList(candidateUsers));
		} else {
			// 此时应该是通过角色、部门、特定人等方式已经特殊指定好了，不需要再配置
		}

		workflowVo.setVariables(variables);

		ResponseEntity<JSONObject> status = this.restTemplate.exchange(COMPLETE_TASK_URL, HttpMethod.POST, new HttpEntity<WorkflowVo>(workflowVo, httpHeaders), JSONObject.class);
		// System.out.println("=============completeTask=========" +
		// status.getBody());
		if (status.getBody() != null && status.getBody().get("statusCode") != null) {
			if (status.getBody().get("statusCode").equals("-1")) {
				return new Result(true, "数据异常");
			}
			return new Result(true, "操作成功");
		} else {
			return new Result(false, "操作失败");
		}

	}

}
