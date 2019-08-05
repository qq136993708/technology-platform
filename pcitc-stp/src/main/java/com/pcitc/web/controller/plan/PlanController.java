package com.pcitc.web.controller.plan;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.druid.support.json.JSONUtils;
import com.pcitc.base.system.SysMessage;
import com.pcitc.web.common.OperationFilter;
import com.pcitc.web.socket.notice.MessageIndexSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.plan.PlanBase;
import com.pcitc.base.plan.PlanBaseDetail;
import com.pcitc.base.util.CodeUtil;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.StrUtil;
import com.pcitc.web.common.BaseController;

@Controller
public class PlanController extends BaseController {

	private String basePath;
	private static final String BOT_WORK_ORDER_LIST = "http://pcitc-zuul/system-proxy/planClient-provider/botWorkOrder_list";
	// 保存新增
	private static final String SAVE_BOT_WORK_ORDER = "http://pcitc-zuul/system-proxy/planClient-provider/saveBotWorkOrder";

	// 转发时新单据的复制
	private static final String SAVE_ZF = "http://pcitc-zuul/system-proxy/planClient-provider/zf/saveBotWorkOrder";

	// 删除
	private static final String DELETE_BOT_WORK_ORDER = "http://pcitc-zuul/system-proxy/planClient-provider/deleteBotWorkOrder/";
	// 修改
	private static final String EDIT_BOT_WORK_ORDER = "http://pcitc-zuul/system-proxy/planClient-provider/editBotWorkOrder";
	// 查询
	private static final String VIEW_BOT_WORK_ORDER = "http://pcitc-zuul/system-proxy/planClient-provider/viewBotWorkOrder/";
	// 提交
	private static final String AFFIRM_BOT_WORK_ORDER = "http://pcitc-zuul/system-proxy/planClient-provider/affirmBotWorkOrder/";
	// 提交
	private static final String SUBMIT_BOT_WORK_ORDER = "http://pcitc-zuul/system-proxy/planClient-provider/submitBotWorkOrder/";
	// 批量保存任务
	private static final String SAVE_PLAN_BASE_BATCH = "http://pcitc-zuul/system-proxy/planClient-provider/savePlanBaseBatch";
	// 转发修改子节点
	private static final String SAVE_PLAN_BASE_BATCHZF = "http://pcitc-zuul/system-proxy/planClient-provider/savePlanBaseBatchZf";
	// 查看工单事项集合
	private static final String VIEW_BOT_WORK_ORDER_MATTER_LIST = "http://pcitc-zuul/system-proxy/planClient-provider/queryBotWorkOrderMatterList";

	// 我的工单
	private static final String MY_BOT_WORK_ORDER_LIST = "http://pcitc-zuul/system-proxy/planClient-provider/my/botWorkOrder_list";
	// 查看我的工单事项反馈集合
	private static final String VIEW_MY_BOT_WORK_ORDER_MATTER_LIST = "http://pcitc-zuul/system-proxy/planClient-provider/queryMyBotWorkOrderMatterList";
	// 批量保存工单事项
	private static final String SAVE_MY_BOT_WORK_ORDER_MATTER_BATCH = "http://pcitc-zuul/system-proxy/planClient-provider/saveMyBotWorkOrderMatterBatch";
	// 提交
	private static final String SUBMIT_MY_BOT_WORK_ORDER = "http://pcitc-zuul/system-proxy/planClient-provider/submitMyBotWorkOrder/";

	private static final String TREE_DATA = "http://pcitc-zuul/system-proxy/planClient-provider/tree-data";


	private static final String TREE_DATA_LIST = "http://pcitc-zuul/system-proxy/planClient-provider/tree-data-list";

	private static final String selectListPlan = "http://pcitc-zuul/system-proxy/planClient-provider/selectListPlan";

	//任务树
	private static final String plan_tree = "http://pcitc-zuul/system-proxy//planClient-provider/plan_tree";



    /**
	 * 用户选择:页面跳转
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/plan/pageSelectUser")
	private String pageSelectUser(HttpServletRequest request) {
		return "stp/plan/pageSelectUser";
	}

	/**
	 * 跳转至任务列表页
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/plan/pagePlanList")
	private String pagePlanList(HttpServletRequest request) {
		return "stp/plan/listPlanPage";
	}

	/**
	 * 工作安排列表数据
	 */
	@RequestMapping(value = "/plan/getTableData", method = RequestMethod.POST)
	@ResponseBody
	public Object getTableData(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request) throws IOException {
		// 只查询本人创建的
		param.getParam().put("createUser", sysUserInfo.getUserId());

		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(BOT_WORK_ORDER_LIST, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData result = responseEntity.getBody();
		CommonUtil.addAttachmentField(result, restTemplate, httpHeaders);
		JSONObject retJson = (JSONObject) JSON.toJSON(result);
		return retJson;
	}

	/**
	 * 主页任务新增
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/plan/addPlanPageMain")
	public String pageAddPlanMain(HttpServletRequest request) {
		Object dataId = request.getParameter("dataId");
		String flag = "edit";
		if (dataId == null || "".equals(dataId)) {
			dataId = UUID.randomUUID().toString().replace("-", "");
			flag = "add";
		}
		request.setAttribute("flag", flag);
		request.setAttribute("dataId", dataId);
		request.setAttribute("userName", sysUserInfo.getUserDisp());
		request.setAttribute("unitName", sysUserInfo.getUnitName());
		request.setAttribute("bak6", sysUserInfo.getUserId());
		request.setAttribute("bak4", sysUserInfo.getUserDisp());
		request.setAttribute("closeType", "1");
		return "stp/plan/addPlanPage";
	}

	/**
	 * 新建任务
	 */
	@RequestMapping(value = "/plan/addPlanPage")
	public String pageAddPlan(HttpServletRequest request) {
		Object dataId = request.getParameter("dataId");
		String flag = "edit";
		if (dataId == null || "".equals(dataId)) {
			dataId = UUID.randomUUID().toString().replace("-", "");
			flag = "add";
		}
		request.setAttribute("flag", flag);
		request.setAttribute("dataId", dataId);
		request.setAttribute("userName", sysUserInfo.getUserDisp());
		request.setAttribute("unitName", sysUserInfo.getUnitName());
		request.setAttribute("bak6", sysUserInfo.getUserId());
		request.setAttribute("bak4", sysUserInfo.getUserDisp());
		// request.setAttribute("closeType", request.getParameter("closeType"));

		request.setAttribute("userInfo", sysUserInfo);
		return "stp/plan/addPlanPage";
	}

	/**
	 * 任务编辑
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/plan/editPlanPage")
	public String editPlanPage(HttpServletRequest request) {
		Object dataId = request.getParameter("dataId");
		String flag = "edit";
		if (dataId == null || "".equals(dataId)) {
			dataId = UUID.randomUUID().toString().replace("-", "");
			flag = "add";
		}
		request.setAttribute("flag", flag);
		request.setAttribute("dataId", dataId);
		request.setAttribute("userName", sysUserInfo.getUserDisp());
		request.setAttribute("unitName", sysUserInfo.getUnitName());
		return "stp/plan/editPlanPage";
	}

	/**
	 * 任务下发
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/plan/goAddBotWorkOrderZp")
	public String goAddBotWorkOrderZp(HttpServletRequest request) {
		Object dataId = request.getParameter("dataId");
		String flag = "add";
		request.setAttribute("flag", flag);
		request.setAttribute("dataId", dataId);
		request.setAttribute("userName", sysUserInfo.getUserDisp());
		request.setAttribute("unitName", sysUserInfo.getUnitName());
		return "stp/plan/botWorkOrderAddZp";
	}

	/**
	 * 跳转任务转发
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/plan/toPageZfPlan")
	public String goAddBotWorkOrderZf(HttpServletRequest request) {
		request.setAttribute("dataId", request.getParameter("dataId"));
		request.setAttribute("userName", sysUserInfo.getUserDisp());
		request.setAttribute("unitName", sysUserInfo.getUnitName());

		String dataId = request.getParameter("dataId");
		ResponseEntity<PlanBase> responseEntity = this.restTemplate.exchange(VIEW_BOT_WORK_ORDER + dataId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), PlanBase.class);
		PlanBase planBase = responseEntity.getBody();
		request.setAttribute("planBase", planBase);

		return "stp/plan/zf_plan_edit_page";
	}

	/**
	 * 保存工单管理
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/plan/saveBotWorkOrder")
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
		if (jsStr.getString("scheduleType") !=null && !jsStr.getString("scheduleType").equals("")) {
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

				System.out.println("announcements = " + detail.get("announcements"));
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

	/**
	 * 新增、编辑工作任务单时的保存方法
	 */
	@RequestMapping(value = "/plan/submitBotWorkOrder")
	@ResponseBody
	public int submitBotWorkOrder(HttpServletRequest request) {
		int result;
		String workOrderStatus = request.getParameter("workOrderStatus");
		if ("0".equals(workOrderStatus)) {
			result = saveBotWorkOrder(request);
		} else {
			result = editBotWorkOrder(request);
		}
		String param = request.getParameter("param");
		JSONObject jsStr = (JSONObject) JSON.parseObject(param);
		String dataId = jsStr.getString("dataId");
		if (result == 200) {
			ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SUBMIT_BOT_WORK_ORDER + dataId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), Integer.class);
			result = responseEntity.getBody();
		}
		return result;
	}

    @Autowired
    private MessageIndexSocket msgSocket;

	/**
	 * 下发时的保存方法
	 */
	@RequestMapping(value = "/plan/xf/submitBotWorkOrder")
	@ResponseBody
	public int submitBotWorkOrderXF(HttpServletRequest request) {
		// 下发时，原任务单据直接修改状态为已完成，新生成n条任务单
		String param = request.getParameter("param");
		String bak7 = request.getParameter("bak7");
		JSONObject jsStr = (JSONObject) JSON.parseObject(param);
		jsStr.put("visaApplyCode", null);
		String dataId = jsStr.getString("dataId");
		ResponseEntity<PlanBase> resultEntity = this.restTemplate.exchange(VIEW_BOT_WORK_ORDER + dataId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), PlanBase.class);
		PlanBase wjbvo = resultEntity.getBody();
        PlanBase base_page = (PlanBase) JSONObject.toJavaObject(jsStr, PlanBase.class);
		wjbvo.setUpdateDate(DateUtil.dateToStr(new Date(), DateUtil.FMT_SS));
		wjbvo.setUpdateUser(sysUserInfo.getUserId());
		wjbvo.setUpdateUserName(sysUserInfo.getUserDisp());
		wjbvo.setDelFlag("0");
//		wjbvo.setBak7(bak7);
		wjbvo.setWorkOrderStatus(request.getParameter("workOrderStatus"));
		wjbvo.setRemarks(base_page.getRemarks());
		wjbvo.setBak4(base_page.getBak4());
		wjbvo.setBak6(base_page.getBak6());

		HttpEntity<PlanBase> entity = new HttpEntity<PlanBase>(wjbvo, this.httpHeaders);
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(EDIT_BOT_WORK_ORDER, HttpMethod.POST, entity, Integer.class);
		int result = responseEntity.getBody();

		List<PlanBase> baseList = new ArrayList<PlanBase>();
		if (jsStr.containsKey("matterList")) {
			JSONArray array = jsStr.getJSONArray("matterList");
			for (int i = 0; i < array.size(); i++) {
				// 取值赋给PlanBase
				JSONObject detail = array.getJSONObject(i);
				PlanBase planBase = JSONObject.toJavaObject((JSON) JSON.toJSON(detail), PlanBase.class);
				planBase.setParentId(wjbvo.getDataId());
				planBase.setDataId("".equals(detail.get("dataId"))||detail.get("dataId")==null ? UUID.randomUUID().toString().replace("-", "") : detail.get("dataId").toString());
				planBase.setWorkOrderStatus("1");
				planBase.setDelFlag("0");
                planBase.setBak8(StrUtil.objectToString(detail.get("bak8")));
                planBase.setRemarks(StrUtil.objectToString(detail.get("bak8")));
				planBase.setWorkOrderType(wjbvo.getWorkOrderType());
				planBase.setRedactUnitName(wjbvo.getRedactUnitName());
				planBase.setCreateDate(DateUtil.dateToStr(new Date(), DateUtil.FMT_SS));
				planBase.setBl(StrUtil.objectToString(detail.get("bl")));
				planBase.setAnnouncements(StrUtil.objectToString(detail.get("announcements")));

				planBase.setBak7(bak7);

				// 记录父节点的相关信息，方便显示
				planBase.setDataCode(wjbvo.getDataCode());
				planBase.setWorkOrderCode(wjbvo.getDataCode());
				planBase.setCreateUser(wjbvo.getWorkOrderAllotUserId());
				planBase.setCreateUserName(wjbvo.getWorkOrderAllotUserName());
				planBase.setStatus(wjbvo.getStatus());
				baseList.add(planBase);
//                try {
////                    SysMessage msg = new SysMessage();
////                    msg.setUserId(planBase.getWorkOrderAllotUserId());
////                    msg.setDataId(UUID.randomUUID().toString());
////                    msg.setMessageContent("您收到一条任务下发信息,请查收");
////                    msg.setIsRead("0");
////                    msgSocket.sendToWeb(msg);
////                } catch (Exception e) {
////                    e.printStackTrace();
////                }
			}
		}

		HttpEntity<List<PlanBase>> entityList = new HttpEntity<List<PlanBase>>(baseList, this.httpHeaders);
		ResponseEntity<Integer> responseEntityList = this.restTemplate.exchange(SAVE_PLAN_BASE_BATCH, HttpMethod.POST, entityList, Integer.class);

		try {
			CommonUtil.updateFileFlag(restTemplate, httpHeaders, wjbvo.getDataId());
		} catch (Exception e) {
			e.printStackTrace();
			result = 500;
		}

		return result;
	}

	/**
	 * 删除工单管理
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/plan/deletePlan")
	@ResponseBody
	public int deletePlan(HttpServletRequest request) {
		String id = request.getParameter("ids");
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(DELETE_BOT_WORK_ORDER + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), Integer.class);
		int result = responseEntity.getBody();
		return result;
	}

	/**
	 * 跳转至修改工单管理页面
	 */
	@RequestMapping(value = "/plan/pagePlanDo")
	public String goEditBotWorkOrder(HttpServletRequest request) {
		request.setAttribute("userName", sysUserInfo.getUserDisp());
		request.setAttribute("unitName", sysUserInfo.getUnitName());
		request.setAttribute("dataId", request.getParameter("dataId"));
		return "stp/plan/do_plan_edit_page";
	}

	/**
	 * 跳转至查看工单管理页面
	 */
	@RequestMapping(value = "/plan/viewPlanPage")
	public String viewPlanPage(HttpServletRequest request) {
		request.setAttribute("dataId", request.getParameter("dataId"));
		return "stp/plan/viewPlanPage";
	}

	/**
	 * 跳转至查看工单管理页面, 换一种链接方法
	 */
	@RequestMapping(value = "/plan/viewPlanPage/{dataId}")
	public String viewPlanPageLD(@PathVariable("dataId") String dataId, HttpServletRequest request) {
		System.out.println("====================viewPlanPageLD" + dataId);
		return "/stp/plan/viewPlanPage";
	}

	/**
	 * 获取工单管理信息
	 */
	@RequestMapping(value = "/plan/viewBotWorkOrder")
	@ResponseBody
	public Object viewBotWorkOrder(HttpServletRequest request) {
		String dataId = request.getParameter("dataId");
		ResponseEntity<PlanBase> responseEntity = this.restTemplate.exchange(VIEW_BOT_WORK_ORDER + dataId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), PlanBase.class);
		PlanBase result = responseEntity.getBody();
		return result;
	}

	/**
	 * 修改保存
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/plan/editBotWorkOrder")
	@ResponseBody
	public int editBotWorkOrder(HttpServletRequest request) {
		String param = request.getParameter("param");
		System.out.println("==============="+param);
		JSONObject jsStr = (JSONObject) JSON.parseObject(param);
		jsStr.put("visaApplyCode", null);
		
		String dataId = jsStr.getString("dataId");
		ResponseEntity<PlanBase> resultEntity = this.restTemplate.exchange(VIEW_BOT_WORK_ORDER + dataId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), PlanBase.class);
		PlanBase wjbvo = resultEntity.getBody();
		wjbvo = (PlanBase) JSONObject.toJavaObject(jsStr, PlanBase.class);
		wjbvo.setUpdateDate(DateUtil.dateToStr(new Date(), DateUtil.FMT_SS));
		wjbvo.setUpdateUser(sysUserInfo.getUserId());
		wjbvo.setUpdateUserName(sysUserInfo.getUserDisp());
		wjbvo.setDelFlag("0");
		if (jsStr.getString("scheduleType") !=null && !jsStr.getString("scheduleType").equals("")) {
			// 需要定时处理
			wjbvo.setScheduleType(jsStr.getString("scheduleType"));
			wjbvo.setIsSchedule("1");
			wjbvo.setScheduleDate(jsStr.getString("scheduleDate"));
		} else {
			// 实时任务
			wjbvo.setScheduleType(jsStr.getString("scheduleType"));
			wjbvo.setIsSchedule("0");
			wjbvo.setScheduleDate(jsStr.getString("scheduleDate"));
		}
		HttpEntity<PlanBase> entity = new HttpEntity<PlanBase>(wjbvo, this.httpHeaders);
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(EDIT_BOT_WORK_ORDER, HttpMethod.POST, entity, Integer.class);
		int result = responseEntity.getBody();

		List<PlanBase> baseList = new ArrayList<PlanBase>();
		if (jsStr.containsKey("matterList")) {
			JSONArray array = jsStr.getJSONArray("matterList");
			for (int i = 0; i < array.size(); i++) {
				// 取值赋给PlanBase
				JSONObject detail = array.getJSONObject(i);
				PlanBase planBase = JSONObject.toJavaObject((JSON) JSON.toJSON(detail), PlanBase.class);
				planBase.setParentId(wjbvo.getDataId());
				System.out.println("dataId = " + "".equals(detail.get("dataId")));
				planBase.setDataId("".equals(detail.get("dataId")) ? UUID.randomUUID().toString().replace("-", "") : detail.get("dataId").toString());
				planBase.setWorkOrderStatus("1");
				planBase.setDelFlag("0");
				planBase.setBl("");
				planBase.setWorkOrderType(wjbvo.getWorkOrderType());
				planBase.setRedactUnitName(wjbvo.getRedactUnitName());
				planBase.setCreateDate(DateUtil.dateToStr(new Date(), DateUtil.FMT_SS));
				planBase.setBl(StrUtil.objectToString(detail.get("bl")));
				planBase.setAnnouncements(StrUtil.objectToString(detail.get("announcements")));

				// 记录父节点的相关信息，方便显示
				planBase.setDataCode(wjbvo.getDataCode());
				planBase.setWorkOrderCode(wjbvo.getDataCode());
				planBase.setCreateUser(wjbvo.getCreateUser());
				planBase.setCreateUserName(wjbvo.getCreateUserName());
				planBase.setCreateDate(wjbvo.getCreateDate());
				planBase.setStatus(wjbvo.getStatus());
				
				// 定时的任务暂时不让受理人看到。子工作任务不用考虑定时时间/类型
				planBase.setIsSchedule(wjbvo.getIsSchedule());
				baseList.add(planBase);
			}
		}

		HttpEntity<List<PlanBase>> entityList = new HttpEntity<List<PlanBase>>(baseList, this.httpHeaders);
		ResponseEntity<Integer> responseEntityList = this.restTemplate.exchange(SAVE_PLAN_BASE_BATCH, HttpMethod.POST, entityList, Integer.class);
		System.out.println(responseEntityList+"=========responseEntityList========"+wjbvo.getDataId());
		try {
			System.out.println(responseEntityList+"=========responseE1ntityList========"+wjbvo.getDataId());
			CommonUtil.updateFileFlag(restTemplate, httpHeaders, wjbvo.getDataId());
		} catch (Exception e) {
			System.out.println(responseEntityList+"=========response3EntityList========"+wjbvo.getDataId());
			e.printStackTrace();
			result = 500;
		}
		return result;
	}

	/**
	 * 任务转发保存
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/plan/editBotWorkOrderZf")
	@ResponseBody
	public int editBotWorkOrderZf(HttpServletRequest request) {
		// 修改原数据 新增新数据 更新
		String param = request.getParameter("param");
		System.out.println("==============="+param);
		JSONObject jsStr = (JSONObject) JSON.parseObject(param);
		jsStr.put("visaApplyCode", null);
		String dataId = jsStr.getString("dataId");
		String newDataId = UUID.randomUUID().toString().replace("-", "");
		ResponseEntity<PlanBase> resultEntity = this.restTemplate.exchange(VIEW_BOT_WORK_ORDER + dataId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), PlanBase.class);
		PlanBase wjbvoOld = resultEntity.getBody();
		PlanBase wjbvo = resultEntity.getBody();
		String workOrderName = wjbvo.getWorkOrderName();
		wjbvo = (PlanBase) JSONObject.toJavaObject(jsStr, PlanBase.class);
		wjbvo.setUpdateDate(DateUtil.dateToStr(new Date(), DateUtil.FMT_SS));
		wjbvo.setUpdateUser(sysUserInfo.getUserId());
		wjbvo.setUpdateUserName(sysUserInfo.getUserDisp());
		wjbvo.setDelFlag("0");
		wjbvo.setWorkOrderName("(已转发)" + workOrderName);
		wjbvo.setBak5("0");// 0:转发
		wjbvo.setZpName(newDataId);
		wjbvo.setWorkOrderStatus("2");// 转发状态设为2,完成
		HttpEntity<PlanBase> entity = new HttpEntity<PlanBase>(wjbvo, this.httpHeaders);
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(EDIT_BOT_WORK_ORDER, HttpMethod.POST, entity, Integer.class);
		int result = responseEntity.getBody();
		// 新增
		wjbvoOld.setWorkOrderName(workOrderName);
		wjbvoOld.setWorkOrderAllotUserId(wjbvo.getBak2());
		wjbvoOld.setWorkOrderAllotUserName(wjbvo.getBak3());
		wjbvoOld.setBak2("");
		wjbvoOld.setBak3("");
		wjbvoOld.setBl(wjbvo.getBl());
		wjbvoOld.setWorkOrderType(wjbvo.getWorkOrderType());
		wjbvoOld.setDataId(newDataId);
		wjbvoOld.setJsId(wjbvo.getDataId());

		// 转发时，实际的分配人就是此次的转发人
		wjbvoOld.setCreateUser(sysUserInfo.getUserId());
		wjbvoOld.setCreateUserName(sysUserInfo.getUserDisp());
		wjbvoOld.setCreateDate(DateUtil.dateToStr(new Date(), DateUtil.FMT_SS));

		HttpEntity<PlanBase> entityNew = new HttpEntity<PlanBase>(wjbvoOld, this.httpHeaders);
		// 保存，同时复制原任务已经办理的业务反馈事项
		ResponseEntity<Integer> responseEntityNew = this.restTemplate.exchange(SAVE_ZF, HttpMethod.POST, entityNew, Integer.class);
		return result;
	}

	/**
	 * 批量提交工单管理
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/plan/affirmBotOccupyRoad")
	@ResponseBody
	public int affirmBotOccupyRoad(HttpServletRequest request) {
		String ids = request.getParameter("ids");
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(AFFIRM_BOT_WORK_ORDER + ids, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), Integer.class);
		int result = responseEntity.getBody();
		return result;
	}

	/**
	 * 获取我的工单管理信息
	 */
	@RequestMapping(value = "/plan/queryBotWorkOrderMatterList")
	@ResponseBody
	public Object queryBotWorkOrderMatterList(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(VIEW_BOT_WORK_ORDER_MATTER_LIST, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData result = responseEntity.getBody();

		// 安全设置：归档文件下载
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		return JSON.toJSONString(result);
	}

	/**
	 * 跳转到我的任务
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/plan/my/goBotWorkOrderListPage")
	private String goMyBotWorkOrderListPage(HttpServletRequest request, HttpServletResponse response) {
		basePath = request.getContextPath();
		request.setAttribute("basePath", basePath);

		// 安全设置：归档文件下载
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		return "stp/plan/my/listMyPlan";
	}

	/**
	 * 我的列表异步加载数据
	 */
	@RequestMapping(value = "/plan/my/getTableData", method = RequestMethod.POST)
	@ResponseBody
	public Object getMyTableData(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request) throws IOException {
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

	/**
	 * 跳转至完成我的工单管理页面
	 */
	@RequestMapping(value = "/plan/my/goEditPlanDetail")
	public String goMyEditBotWorkOrder(HttpServletRequest request) {
		request.setAttribute("dataId", request.getParameter("dataId"));
		return "stp/plan/my/do_plan_edit_page";
	}

	/**
	 * 首页处理任务
	 */
	@RequestMapping(value = "/plan/my/index_show_detail")
	public String index_show_detail(HttpServletRequest request) {
		request.setAttribute("dataId", request.getParameter("dataId"));
		return "stp/plan/my/index_show_detail";
	}

	@RequestMapping(value = "/plan/my/goEditPlanDetailIndex_cl")
	public String goMyEditBotWorkOrderIndexCl(HttpServletRequest request) {
		request.setAttribute("dataId", request.getParameter("dataId"));
		return "stp/plan/my/index_do_plan_cl";
	}
	//转发
    @RequestMapping(value = "/plan/my/goEditPlanDetailIndex_zf")
    public String goMyEditBotWorkOrderIndexZf(HttpServletRequest request) {
        request.setAttribute("dataId", request.getParameter("dataId"));
        request.setAttribute("userName", sysUserInfo.getUserDisp());
        request.setAttribute("unitName", sysUserInfo.getUnitName());

        String dataId = request.getParameter("dataId");
        ResponseEntity<PlanBase> responseEntity = this.restTemplate.exchange(VIEW_BOT_WORK_ORDER + dataId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), PlanBase.class);
        PlanBase planBase = responseEntity.getBody();
        request.setAttribute("planBase", planBase);
        return "stp/plan/my/index_do_plan_zf";
    }
    //下发
    @RequestMapping(value = "/plan/my/goEditPlanDetailIndex_xf")
    public String goMyEditBotWorkOrderIndexXf(HttpServletRequest request) {
        Object dataId = request.getParameter("dataId");
        String flag = "add";
        request.setAttribute("flag", flag);
        request.setAttribute("dataId", dataId);
        request.setAttribute("userName", sysUserInfo.getUserDisp());
        request.setAttribute("unitName", sysUserInfo.getUnitName());
        return "stp/plan/my/index_do_plan_xf";
    }
	/**
	 * 跳转至查看我的工单管理页面
	 */
	@RequestMapping(value = "/plan/my/viewPlanDetail")
	public String goMyViewBotWorkOrder(HttpServletRequest request) {
		request.setAttribute("dataId", request.getParameter("dataId"));
		return "stp/plan/my/viewPlanDetail";
	}

	/**
	 * 获取我的工单事项反馈管理信息
	 */
	@RequestMapping(value = "/plan/queryMyBotWorkOrderMatterList")
	@ResponseBody
	public Object queryMyBotWorkOrderMatterList(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request) {
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(VIEW_MY_BOT_WORK_ORDER_MATTER_LIST, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData result = responseEntity.getBody();
		return JSON.toJSONString(result);
	}

	/**
	 * 保存我的工单事项反馈
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/plan/saveMyBotWorkOrderMatterFeedBack")
	@ResponseBody
	public int saveMyBotWorkOrderMatterFeedBack(HttpServletRequest request) {
		String param = request.getParameter("param");
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

	/**
	 * 提交
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/plan/submitMyBotWorkOrder")
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

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}


    @RequestMapping(value = "/plan/tree-datas-list")
    @ResponseBody
    public String getZjkMsgConfigTreeDatasList(HttpServletRequest request) throws Exception {
        JSONObject o = new JSONObject();
        o.put("dataId",request.getParameter("dataId"));
        o.put("pid",request.getParameter("pid"));
        List list = this.restTemplate.exchange(TREE_DATA, HttpMethod.POST, new HttpEntity<JSONObject>(o,this.httpHeaders), List.class).getBody();
        return JSONUtils.toJSONString(list);
    }

    /**
     * 首页-任务树形
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/plan/tree-datas")
    @ResponseBody
    public String getZjkMsgConfigTreeDatas(HttpServletRequest request) throws Exception {
        JSONObject o = new JSONObject();
        o.put("dataId",request.getParameter("dataId"));
        o.put("pid",request.getParameter("pid"));
//        String object = this.restTemplate.exchange(TREE_DATA_LIST, HttpMethod.POST, new HttpEntity<JSONObject>(o,this.httpHeaders), String.class).getBody();
        List object = this.restTemplate.exchange(plan_tree, HttpMethod.POST, new HttpEntity<JSONObject>(o,this.httpHeaders), List.class).getBody();
        return JSONUtils.toJSONString(object);
    }
}
