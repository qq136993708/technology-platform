package com.pcitc.web.controller.mobile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.InforVo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Page;
import com.pcitc.base.plan.PlanBase;
import com.pcitc.base.plan.PlanBaseDetail;
import com.pcitc.base.system.SysNotice;
import com.pcitc.base.system.SysNoticeVo;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.web.common.BaseController;

@Controller
public class MobileWorkbechController extends BaseController
{

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
 	
 	
    private String basePath;	
		
	
	
	
	
		
 	@RequestMapping(value = "/mobile/agencyM")
	public String agencyM(HttpServletRequest request) throws IOException{
		return "/mobile/agencyM";
	}
 	
 	@RequestMapping(value = "/mobile/work")
	public String work(HttpServletRequest request) throws IOException{
 		
 		basePath = request.getContextPath();
		request.setAttribute("basePath", basePath);

		// 安全设置：归档文件下载
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		return "/mobile/work";
	}
 	
 	
 	@RequestMapping(value = "/mobile/work_add")
	public String work_add(HttpServletRequest request) throws IOException{
		return "/mobile/work_add";
	}
 	@RequestMapping(value = "/mobile/work_details")
	public String work_details(HttpServletRequest request)throws IOException {
 		
 		String dataId = request.getParameter("dataId");
 		request.setAttribute("dataId", dataId);
		ResponseEntity<PlanBase> responseEntity = this.restTemplate.exchange(VIEW_BOT_WORK_ORDER + dataId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), PlanBase.class);
		PlanBase planBase = responseEntity.getBody();
		request.setAttribute("planBase", planBase);
		
		
		
		//工作安排列表
		int pageNo = request.getParameter("pageNo") == null ? 1 : Integer.parseInt((String) request.getParameter("pageNo"));
		LayuiTableParam param = new LayuiTableParam();
		param.setPage(pageNo);
		param.setLimit(100);
		param.getParam().put("workOrderId", dataId);
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> rs = this.restTemplate.exchange(VIEW_BOT_WORK_ORDER_MATTER_LIST, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData layuiTableData = rs.getBody();
		request.setAttribute("list", layuiTableData.getData());
		
		return "/mobile/work_details";
	}
 	
 	
 	//我处理的
 	@RequestMapping(value = "/mobile/work_details_1")
	public String work_details1(HttpServletRequest request) throws IOException{
 		String dataId = request.getParameter("dataId");
 		request.setAttribute("dataId", dataId);
		ResponseEntity<PlanBase> responseEntity = this.restTemplate.exchange(VIEW_BOT_WORK_ORDER + dataId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), PlanBase.class);
		PlanBase planBase = responseEntity.getBody();
		request.setAttribute("planBase", planBase);
		return "/mobile/work_details_1";
	}
 	
 	//工作安排列表
 	@RequestMapping(value = "/mobile/plan/queryMyBotWorkOrderMatterList")
	@ResponseBody
	public Object queryMyBotWorkOrderMatterList( HttpServletRequest request) {
 		String dataId = request.getParameter("dataId");
 		int pageNo = request.getParameter("pageNo") == null ? 1 : Integer.parseInt((String) request.getParameter("pageNo"));
		LayuiTableParam param = new LayuiTableParam();
		param.setPage(pageNo);
		param.setLimit(15);
		param.getParam().put("workOrderId", dataId);
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(VIEW_MY_BOT_WORK_ORDER_MATTER_LIST, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData result = responseEntity.getBody();
		return JSON.toJSONString(result);
	}
 	/**
	 * 获取工单管理信息
	 */
	@RequestMapping(value = "/mobile/plan/viewBotWorkOrder")
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
	@RequestMapping(value = "/mobile/plan/getTableData", method = RequestMethod.POST)
	@ResponseBody
	public Object getTableData( HttpServletRequest request) throws IOException 
	{
		
		String parentId=CommonUtil.getParameter(request,"parentId", "");
		int pageNo = request.getParameter("pageNo") == null ? 1 : Integer.parseInt((String) request.getParameter("pageNo"));
		LayuiTableParam param = new LayuiTableParam();
		param.setPage(pageNo);
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
	@RequestMapping(value = "/mobile/plan/my/getTableData", method = RequestMethod.POST)
	@ResponseBody
	public Object getMyTableData( HttpServletRequest request) throws IOException {
		
		String isSchedule=CommonUtil.getParameter(request,"isSchedule", "");
		String bak7=CommonUtil.getParameter(request,"bak7", "");
		String isChildren=CommonUtil.getParameter(request,"isChildren", "");
		
		int pageNo = request.getParameter("pageNo") == null ? 1 : Integer.parseInt((String) request.getParameter("pageNo"));
		LayuiTableParam param = new LayuiTableParam();
		param.setPage(pageNo);
		param.setLimit(15);
		
		param.getParam().put("isSchedule", isSchedule);
		param.getParam().put("bak7", bak7);
		param.getParam().put("isChildren", isChildren);
				
				
		Map<String, Object> map = param.getParam();
		map.put("workOrderAllotUserId", sysUserInfo.getUserId());
		if (param.getParam().get("workOrderStatus") == null || "".equals(param.getParam().get("workOrderStatus"))) 
		{
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
	
	//处理工单
	@RequestMapping(value = "/mobile/plan/submitMyBotWorkOrder")
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
	@RequestMapping(value = "/mobile/plan/saveMyBotWorkOrderMatterFeedBack")
	@ResponseBody
	public int saveMyBotWorkOrderMatterFeedBack(HttpServletRequest request) 
	{
		String param = request.getParameter("param");
		System.out.println("--saveMyBotWorkOrderMatterFeedBack="+param);
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

 	
 	//处理待办
 	@RequestMapping(value = "/mobile/task/pending/deal/{taskId}")
	public String iniDealTask(@PathVariable("taskId") String taskId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("1=====iniDealTask====" + taskId);

		WorkflowVo workflowVo = new WorkflowVo();
		workflowVo.setTaskId(taskId);
		ResponseEntity<JSONObject> retJson = this.restTemplate.exchange(INI_DEAL_TASK, HttpMethod.POST, new HttpEntity<WorkflowVo>(workflowVo, this.httpHeaders), JSONObject.class);
		System.out.println("iniDealTask=====" + retJson.getBody());
		// 当前审批人信息
		request.setAttribute("userInfo", sysUserInfo);
		request.setAttribute("auditDetailsPath", retJson.getBody().get("auditDetailsPath"));
		request.setAttribute("id", retJson.getBody().get("id"));
		return "/pplus/workflow/deal-task";
	}
 	
 	
 	
    
    //待办任务数据
	@RequestMapping(value = "/mobile/wait_task_list_data")
	@ResponseBody
	public LayuiTableData wait_task_list_data(HttpServletRequest request) {
		int pageNo = request.getParameter("pageNo") == null ? 1 : Integer.parseInt((String) request.getParameter("pageNo"));
		LayuiTableParam param = new LayuiTableParam();
		param.setPage(pageNo);
		param.setLimit(15);
		// 获取当前登录人信息
		param.getParam().put("userId", sysUserInfo.getUserId());
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(PENDING_PAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();
		
		return retJson;
	}
	//已办任务数据
	@RequestMapping(value = "/mobile/finished_task_list_data")
	@ResponseBody
	public LayuiTableData finished_task_list_data(HttpServletRequest request) {
		int pageNo = request.getParameter("pageNo") == null ? 1 : Integer.parseInt((String) request.getParameter("pageNo"));
		LayuiTableParam param = new LayuiTableParam();
		param.setPage(pageNo);
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
	@RequestMapping(value = "/mobile/task/other/pending-list", method = RequestMethod.POST)
	@ResponseBody
	public Object otherPendingList(HttpServletRequest request) 
	{
		
		int pageNo = request.getParameter("pageNo") == null ? 1 : Integer.parseInt((String) request.getParameter("pageNo"));
		LayuiTableParam param = new LayuiTableParam();
		param.setPage(pageNo);
		param.setLimit(15);
		
		System.out.println("==== 待办 param-->" + JSON.toJSON(param).toString());
		// 获取当前登录人信息, 统一身份名作为用户id
		param.getParam().put("userId", sysUserInfo.getUserName());
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(XMGL_PENDING, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();

		return JSON.toJSON(retJson).toString();
	}
	

	@RequestMapping(value = "/mobile/message_list")
	public String message_list(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/mobile/message_list";
	}

	@RequestMapping(value = "/mobile/message_list_data", method = RequestMethod.POST)
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

	@RequestMapping(value = "/mobile/message_list", method = RequestMethod.POST)
	@ResponseBody
	public Object message_list(@ModelAttribute("param") LayuiTableParam param) {

		// 获取当前登录人信息
		param.getParam().put("userId", sysUserInfo.getUserId());
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(MESSAGE_LIST, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();
		// return JSON.toJSON(retJson).toString();

		return "/mobile/message_list";
	}
    
    
    
    
    
	
	
	
	
	/**
	 * 查看公告
	 * 
	 * @return
	 */
	@RequestMapping(value = "/mobile/sysNotice/readNotice")
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

	
}
