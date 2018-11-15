package com.pcitc.web.controller.equipment;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.RequestProcessStatusEnum;
import com.pcitc.base.hana.report.DicSupplyer;
import com.pcitc.base.stp.equipment.SreEquipment;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.workflow.Constants;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.web.common.BaseController;

@Controller
@RequestMapping(value = "/sre-equipment")
public class EquipmentController extends BaseController {

	/*
	 * 1、可以直接通过注册的服务名来访问，来实现访问和负载。不过如果用zuul的话， 要用zuul的服务名和实际访问的服务名一起
	 * 2、pplus本身是一个微服务，属于微服务之间的调用，可以直接用名称，不用ip.（注意启动类中的注解）
	 */

	private static final String PAGE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/equipment/page";
	public static final String ADD_URL = "http://pcitc-zuul/stp-proxy/sre-provider/equipment/add";
	public static final String UPDATE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/equipment/update";
	private static final String DEL_URL = "http://pcitc-zuul/stp-proxy/sre-provider/equipment/delete/";
	private static final String BATCH_DEL_URL = "http://pcitc-zuul/stp-proxy/sre-provider/equipment/batch-delete/";
	private static final String LIST_BY_IDS_URL = "http://pcitc-zuul/stp-proxy/sre-provider/equipment/list-by-ids/";
	public static final String GET_URL = "http://pcitc-zuul/stp-proxy/sre-provider/equipment/get/";
	// 流程操作--同意
	private static final String AUDIT_AGREE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/equipment/task/agree/";
	// 流程操作--拒绝
	private static final String AUDIT_REJECT_URL = "http://pcitc-zuul/stp-proxy/sre-provider/equipment/task/reject/";
	private final static String process_define_id4 = "oneSelectAuditProcess:1:367511";

	// 公司代码
	private static final String GET_DIC_ASSET_TYPE = "http://pcitc-zuul/hana-proxy/hana/common/dic/asset_type";
	private static final String GET_DIC_SUPPLYER = "http://pcitc-zuul/hana-proxy/hana/common/dic/supplyer";

	/**
	 * 选择资产分类
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/to-chooseType")
	public String toChooseType(HttpServletRequest request, HttpServletResponse response) {
		return "/stp/equipment/equipment/chooseType";
	}

	@RequestMapping(value = "/chooseType")
	@ResponseBody
	public String chooseType(HttpServletRequest request) throws Exception {
		JSONArray treeNodes = new JSONArray();
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		long startTime = System.currentTimeMillis(); // 获取开始时间
		/*
		 * ResponseEntity<JSONArray> responseEntity =
		 * restTemplate.exchange(GET_DIC_ASSET_TYPE, HttpMethod.GET,
		 * entity,JSONArray.class); long endTime = System.currentTimeMillis();
		 * //获取结束时间 System.out.println("程序运行时间：" + (endTime - startTime) +
		 * "ms"); //输出程序运行时间 int statusCode=responseEntity.getStatusCodeValue();
		 */
		int statusCode = 200;
		if (statusCode == 200) {
			// treeNodes = responseEntity.getBody();

			JSONObject json = new JSONObject();
			json.put("id", 1);
			json.put("name", "aaaaaaa");
			json.put("pId", 0);

			JSONObject json2 = new JSONObject();
			json2.put("id", 101);
			json2.put("name", "asdfasdfasdf");
			json2.put("pId", 1);

			JSONObject json3 = new JSONObject();
			json3.put("id", 10101);
			json3.put("name", "asdfasdfasdf");
			json3.put("pId", 101);

			JSONObject json4 = new JSONObject();
			json4.put("id", 1010101);
			json4.put("name", "asdfasdf");
			json4.put("pId", 10101);

			JSONObject json5 = new JSONObject();
			json5.put("id", 0);
			json5.put("name", "aaaaaaaaaaa");
			json5.put("pId", -1);

			treeNodes.add(json);
			treeNodes.add(json2);
			treeNodes.add(json3);
			treeNodes.add(json4);
			treeNodes.add(json5);
		}
		System.out.println("=============treeNodes:" + treeNodes);
		return treeNodes.toString();
	}

	/**
	 * 选择供应商
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/to-choose-chooseBusiness")
	public String tochooseBusiness(HttpServletRequest request, HttpServletResponse response) {
		return "/stp/equipment/equipment/chooseBusiness";
	}

	@RequestMapping(value = "/chooseBusiness")
	@ResponseBody
	public String chooseBusiness(HttpServletRequest request) throws Exception {
		DicSupplyer function = new DicSupplyer();

		ResponseEntity<List> responseEntity = restTemplate.exchange(GET_DIC_SUPPLYER, HttpMethod.POST, new HttpEntity<DicSupplyer>(function, this.httpHeaders), List.class);
		List treeNodes = responseEntity.getBody();
		return JSONUtils.toJSONString(treeNodes);
	}

	@RequestMapping(value = "/uploadFile")
	public String uploadFile(HttpServletRequest request, HttpServletResponse response) {

		String file_edit_detail = CommonUtil.getParameter(request, "file_edit_detail", "");
		request.setAttribute("file_edit_detail", file_edit_detail);
		String file_ids = CommonUtil.getParameter(request, "file_ids", "");
		request.setAttribute("file_ids", file_ids);
		String file_opt_flag = CommonUtil.getParameter(request, "file_opt_flag", "");
		request.setAttribute("file_opt_flag", file_opt_flag);

		String file_ids_value = CommonUtil.getParameter(request, "file_ids_value", "");
		request.setAttribute("file_ids_value", file_ids_value);

		return "/stp/equipment/common/uploadFile";
	}

	@RequestMapping(value = "/to-list")
	public String list(HttpServletRequest request, HttpServletResponse response) {
		return "/stp/equipment/equipment/equipment-list";
	}

	/**
	 * 列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/list")
	@ResponseBody
	public String ajaxlist(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============result" + result);
		return result.toString();
	}

	/**
	 * 选择装备
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/search-equipment")
	public String searchEquipment(HttpServletRequest request, HttpServletResponse response) {

		String equipmentIds = CommonUtil.getParameter(request, "equipmentIds", "");
		request.setAttribute("equipmentIds", equipmentIds);
		return "/stp/equipment/equipment/equipment-search";
	}

	/**
	 * 选择装备
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/iframe-equipment")
	public String iframeEquipment(HttpServletRequest request, HttpServletResponse response) {
		ResponseEntity<List> responseEntity = null;
		List returnlist = null;
		String ids = CommonUtil.getParameter(request, "equipmentIds", "");
		if (!ids.equals("")) {
			String chkbox[] = ids.split(",");
			System.out.println("--------ids=" + ids + " chkbox=" + chkbox.length);
			if (chkbox != null && chkbox.length > 0) {
				List<String> list = Arrays.asList(chkbox);
				List<Long> longList = new ArrayList();
				if (list != null) {
					for (int i = 0; i < list.size(); i++) {
						String str = list.get(i);
						longList.add(Long.valueOf(str));
					}
				}
				JSONArray jsonObject = JSONArray.parseArray(JSON.toJSONString(longList));
				HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
				responseEntity = restTemplate.exchange(LIST_BY_IDS_URL, HttpMethod.POST, entity, List.class);
				int statusCode = responseEntity.getStatusCodeValue();
				returnlist = responseEntity.getBody();
				logger.info("============远程返回  statusCode " + statusCode + "  list=" + list.size());
				if (statusCode == 200) {

				}
			}
		}

		request.setAttribute("list", returnlist);
		return "/stp/equipment/equipment/iframe-equipment";
	}

	/**
	 * 增加
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/add")
	public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/stp/equipment/equipment/equipment-add";
	}

	/**
	 * 保存-更新操作
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/save")
	public String saveOrUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result resultsDate = new Result();
		String name = CommonUtil.getParameter(request, "name", "");
		String equipmentIds = CommonUtil.getParameter(request, "equipmentIds", "");
		String planMoney = CommonUtil.getParameter(request, "planMoney", "");
		// 业务ID
		String equipmentId = CommonUtil.getParameter(request, "equipmentId", "");
		String keyWord = CommonUtil.getParameter(request, "keyWord", "");
		String specialNotes = CommonUtil.getParameter(request, "specialNotes", "");
		String notes = CommonUtil.getParameter(request, "notes", "");
		String applyAcount = CommonUtil.getParameter(request, "applyAcount", "");
		String type = CommonUtil.getParameter(request, "type", "");
		String beginYear = CommonUtil.getParameter(request, "beginYear", "");
		String endYear = CommonUtil.getParameter(request, "endYear", "");
		String typeModel = CommonUtil.getParameter(request, "typeModel", "");

		String attachmentDoc = CommonUtil.getParameter(request, "attachmentDoc", "");

		// 流程状态-是保存还是提交
		String auditStatus = CommonUtil.getParameter(request, "auditStatus", "0");
		String userIds = CommonUtil.getParameter(request, "userIds", "");
		SreEquipment sreEquipment = null;
		ResponseEntity<String> responseEntity = null;
		// 判断是新增还是修改
		if (equipmentId.equals("")) {
			sreEquipment = new SreEquipment();
			sreEquipment.setCreateDate(new Date());
			sreEquipment.setIsDel("0");
			sreEquipment.setCreateUserId(sysUserInfo.getUserId());
			String code = CommonUtil.getTableCode("XTBM_0016", restTemplate, httpHeaders);
			sreEquipment.setEquipmentCode(code);
			String id = UUID.randomUUID().toString().replaceAll("-", "");
			System.out.println("---------------UUID-id:" + id);
			sreEquipment.setEquipmentId(id);
			sreEquipment.setAttachmentDoc(attachmentDoc);
			String unitName = sysUserInfo.getUnitName();
			String userUnit = sysUserInfo.getUserUnit();
			sreEquipment.setApplyDepart(userUnit);

			System.out.println("---------------userUnit:" + userUnit + " unitName=" + unitName + " UserId=" + sysUserInfo.getUserId());

		} else {
			ResponseEntity<SreEquipment> se = this.restTemplate.exchange(GET_URL + equipmentId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreEquipment.class);
			sreEquipment = se.getBody();
		}
		// 流程状态
		sreEquipment.setAuditStatus(String.valueOf(auditStatus));
		sreEquipment.setPlanMoney(new BigDecimal(planMoney));
		// sreEquipment.setApplyMoney(Long.parseLong(applyMoney));
		sreEquipment.setName(name);
		sreEquipment.setApplyAcount(Integer.valueOf(applyAcount));
		sreEquipment.setNotes(notes);
		sreEquipment.setKeyWord(keyWord);
		sreEquipment.setSpecialNotes(specialNotes);
		sreEquipment.setBeginYear(beginYear);
		sreEquipment.setEndYear(endYear);
		sreEquipment.setType(type);
		sreEquipment.setTypeModel(typeModel);
		// 判断是新增还是修改
		if (equipmentId.equals("")) {
			responseEntity = this.restTemplate.exchange(ADD_URL, HttpMethod.POST, new HttpEntity<SreEquipment>(sreEquipment, this.httpHeaders), String.class);

		} else {
			responseEntity = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SreEquipment>(sreEquipment, this.httpHeaders), String.class);
		}
		// 返回结果代码
		int statusCode = responseEntity.getStatusCodeValue();
		System.out.println(">>>>>>>>>>>>>>>>>>>返回  statusCode=" + statusCode);
		if (statusCode == 200) {
			if (auditStatus.equals("0")) {
				resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
			} else if (auditStatus.equals("1")) {
				String dataId = "";
				if (equipmentId.equals("")) {
					dataId = responseEntity.getBody();
				} else {
					dataId = equipmentId;
				}
				// 处理流程相关信息
				boolean flowFlag = dealWorkFlow(dataId, sysUserInfo, "装备管理", userIds, httpHeaders);
				if (flowFlag == true) {
					resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
				} else {
					resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
				}
			}
		} else {
			resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
		}

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		out.println(ob.toString());
		out.flush();
		out.close();
		return null;
	}

	/**
	 * 加入流程信息
	 * 
	 * @param id
	 * @param instanceName
	 * @param sysUser
	 */
	private boolean dealWorkFlow(String id, SysUser sysUser, String instanceName, String userIds, HttpHeaders httpHeaders) {

		WorkflowVo workflowVo = new WorkflowVo();
		workflowVo.setBusinessId(String.valueOf(id));
		workflowVo.setProcessInstanceName("业务任务名称：" + instanceName);
		workflowVo.setAuthenticatedUserId(sysUser.getUserId());

		// process_define_id和functionId，两种方式二选一
		// 清楚知道自己要走的流程定义id
		workflowVo.setProcessDefineId(process_define_id4);
		// 不清楚此功能菜单要走的审批流程。可以通过菜单id（functionId），部门/组织ID（orgId），项目id（projectId）。其中菜单id必填（和ProcessDefineId两选一）
		workflowVo.setFunctionId("");
		workflowVo.setProjectId("");

		Map<String, Object> variables = new HashMap<String, Object>();

		// 发起人之后的审批环节，如果是需要选择审批人的话，此处获取选择的userIds赋值给auditor变量
		if (userIds != null && !userIds.equals("")) {
			String[] userIdsArr = userIds.split(",");
			variables.put("auditor", Arrays.asList(userIdsArr));
		}

		// 必须设置，统一流程待办任务中需要的业务详情
		variables.put("auditDetailsPath", "/sre-equipment/get/" + id);

		// 流程完全审批通过时，调用的方法
		variables.put("auditAgreeMethod", AUDIT_AGREE_URL + id);

		// 流程驳回时，调用的方法（可能驳回到第一步，也可能驳回到第1+n步
		variables.put("auditRejectMethod", AUDIT_REJECT_URL + id);

		// 对流程中出现的多个判断条件，比如money>100等，需要把事先把money条件输入
		variables.put("money", 50); // 环节1需要用到
		variables.put("departmentCode", "1005"); // 环节2需要用到
		variables.put("companyCode", "2006"); // 环节n需要用到

		workflowVo.setVariables(variables);
		ResponseEntity<String> status = this.restTemplate.exchange(Constants.START_WORKFLOW_URL, HttpMethod.POST, new HttpEntity<WorkflowVo>(workflowVo, httpHeaders), String.class);
		if (status.getBody() != null && status.getBody().equals("true")) {
			System.out.println("=================流程启动成功");
			return true;
		} else {
			System.out.println("=================流程启动失败");
			return false;
		}
	}

	/**
	 * 修改
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/update")
	public String update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String equipmentId = CommonUtil.getParameter(request, "equipmentId", "");
		request.setAttribute("equipmentId", equipmentId);
		ResponseEntity<SreEquipment> responseEntity = this.restTemplate.exchange(GET_URL + equipmentId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreEquipment.class);
		int statusCode = responseEntity.getStatusCodeValue();
		logger.info("============远程返回  statusCode " + statusCode);
		SreEquipment sreEquipment = responseEntity.getBody();
		request.setAttribute("sreEquipment", sreEquipment);
		String iframeId = CommonUtil.getParameter(request, "iframeId", "");
		request.setAttribute("iframeId", iframeId);

		String backurl = CommonUtil.getParameter(request, "backurl", "");
		request.setAttribute("backurl", backurl);
		System.out.println(">>>>>>>>>>>>>>>>>>>equipmentId  " + equipmentId);
		return "/stp/equipment/equipment/equipment-add";
	}

	/**
	 * 删除
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete/{equipmentId}")
	public String delete(@PathVariable("equipmentId") String equipmentId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(DEL_URL + equipmentId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
		int statusCode = responseEntity.getStatusCodeValue();
		int status = responseEntity.getBody();
		logger.info("============远程返回  statusCode " + statusCode + "  status=" + status);
		if (responseEntity.getBody() > 0) {
			resultsDate = new Result(true);
		} else {
			resultsDate = new Result(false, "删除失败，请联系系统管理员！");
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		out.println(ob.toString());
		out.flush();
		out.close();
		return null;
	}

	/**
	 * 批量删除
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/bacth-delete")
	public String deleteBatch(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result resultsDate = new Result();
		ResponseEntity<Integer> responseEntity = null;
		// String chkbox[]=request.getParameterValues("chkbox");
		String chkboxstr = CommonUtil.getParameter(request, "ids", "");
		String chkbox[] = chkboxstr.split(",");
		System.out.println("--------chkboxstr=" + chkboxstr + " chkbox=" + chkbox.length);

		if (chkbox != null && chkbox.length > 0) {
			List<String> list = Arrays.asList(chkbox);
			List<Long> longList = new ArrayList();
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					String str = list.get(i);
					longList.add(Long.valueOf(str));
				}
			}
			JSONArray jsonObject = JSONArray.parseArray(JSON.toJSONString(longList));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			responseEntity = restTemplate.exchange(BATCH_DEL_URL, HttpMethod.POST, entity, Integer.class);

		}
		int statusCode = responseEntity.getStatusCodeValue();
		int status = responseEntity.getBody();
		logger.info("============远程返回  statusCode " + statusCode + "  status=" + status);
		if (responseEntity.getBody() > 0) {
			resultsDate = new Result(true);
		} else {
			resultsDate = new Result(false, "删除失败，请联系系统管理员！");
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		out.println(ob.toString());
		out.flush();
		out.close();
		return null;

	}

	/**
	 * 详情
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/get/{equipmentId}", method = RequestMethod.GET)
	public String get(@PathVariable("equipmentId") String equipmentId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseEntity<SreEquipment> responseEntity = this.restTemplate.exchange(GET_URL + equipmentId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreEquipment.class);
		int statusCode = responseEntity.getStatusCodeValue();
		logger.info("============远程返回  statusCode " + statusCode);
		SreEquipment sreEquipment = responseEntity.getBody();
		request.setAttribute("sreEquipment", sreEquipment);
		return "/stp/equipment/equipment/equipment-view";
	}

}
