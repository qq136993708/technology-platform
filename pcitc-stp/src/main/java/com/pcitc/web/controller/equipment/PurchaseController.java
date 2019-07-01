package com.pcitc.web.controller.equipment;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.RequestProcessStatusEnum;
import com.pcitc.base.stp.equipment.SreEquipment;
import com.pcitc.base.stp.equipment.SreProject;
import com.pcitc.base.stp.equipment.SreProjectTask;
import com.pcitc.base.stp.equipment.SrePurchase;
import com.pcitc.base.stp.equipment.UnitField;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;
import com.pcitc.web.utils.WordUtil;

/*/
 * Created by WSL in 2019/3/26
 */

@Controller
public class PurchaseController extends BaseController {

	private static final String PAGE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/purchase/page";
	private static final String GET_URL = "http://pcitc-zuul/stp-proxy/sre-provider/purchase/get/";
	private static final String PAGE_URL_CHOOSE_PROJECT = "http://pcitc-zuul/stp-proxy/sre-provider/purchase/chooseProjectPage";
	private static final String PAGE_URL_PROJECT_TASK = "http://pcitc-zuul/stp-proxy/sre-provider/purchase/projectTask/page";

	private static final String GET_BY_PROJECT_ID = "http://pcitc-zuul/stp-proxy/sre-provider/purchase/getSreProject/";
	private static final String GET_PROJECT_URL = "http://pcitc-zuul/stp-proxy/sre-provider/project_basic/get/";

	private static final String ADD_URL = "http://pcitc-zuul/stp-proxy/sre-provider/purchase/add";
	private static final String UPDATE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/purchase/update";
	private static final String DEL_URL = "http://pcitc-zuul/stp-proxy/sre-provider/purchase/delete/";
	// 临时导出文件目录
	private static final String TEMP_FILE_PATH = "src/main/resources/tem/";
	private static final String PURCHASE_INNER_WORKFLOW_URL = "http://pcitc-zuul/stp-proxy/stp-provider/purchase/start_purchase_activity/";

	// 跳转到采购申请页面
	@RequestMapping(value = "/sre_purchase/to-list")
	public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String departCode = sysUserInfo.getUnitCode();
		request.setAttribute("departCode", departCode);
		String parentUnitPathIds = "";
		String unitPathIds = sysUserInfo.getUnitPath();
		parentUnitPathIds = EquipmentUtils.getParentUnitPathId(unitPathIds);
		request.setAttribute("parentUnitPathIds", parentUnitPathIds);

		return "/stp/equipment/purchase/purchase-list";
	}

	// 跳转到合同系统对接
	@RequestMapping(value = "/sre-purchase/apply_list")
	public String apply_list(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String departCode = sysUserInfo.getUnitCode();
		request.setAttribute("departCode", departCode);
		String parentUnitPathIds = "";
		String unitPathIds = sysUserInfo.getUnitPath();
		parentUnitPathIds = EquipmentUtils.getParentUnitPathId(unitPathIds);
		request.setAttribute("parentUnitPathIds", parentUnitPathIds);

		return "/stp/equipment/purchase/apply-list";
	}

	// 跳转到到货签收页面
	@RequestMapping(value = "/sre-purchase/to-arrive-goods-list")
	public String arriveGoodsList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String departCode = sysUserInfo.getUnitCode();
		request.setAttribute("departCode", departCode);
		String parentUnitPathIds = "";
		String unitPathIds = sysUserInfo.getUnitPath();
		parentUnitPathIds = EquipmentUtils.getParentUnitPathId(unitPathIds);
		request.setAttribute("parentUnitPathIds", parentUnitPathIds);

		return "/stp/equipment/purchase/arrive-goods-list";
	}

	// 跳转到合同验收页面
	@RequestMapping(value = "/sre-purchase/to-contract-acceptance-list")
	public String contracAcceptanceList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String departCode = sysUserInfo.getUnitCode();
		request.setAttribute("departCode", departCode);
		String parentUnitPathIds = "";
		String unitPathIds = sysUserInfo.getUnitPath();
		parentUnitPathIds = EquipmentUtils.getParentUnitPathId(unitPathIds);
		request.setAttribute("parentUnitPathIds", parentUnitPathIds);

		return "/stp/equipment/purchase/contract-acceptance-list";
	}

	// 跳转到安装调试页面
	@RequestMapping(value = "/sre-purchase/to-installation-list")
	public String installationList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String departCode = sysUserInfo.getUnitCode();
		request.setAttribute("departCode", departCode);
		String parentUnitPathIds = "";
		String unitPathIds = sysUserInfo.getUnitPath();
		parentUnitPathIds = EquipmentUtils.getParentUnitPathId(unitPathIds);
		request.setAttribute("parentUnitPathIds", parentUnitPathIds);

		return "/stp/equipment/purchase/installation-list";
	}

	// 跳转到合同关闭页面
	@RequestMapping(value = "/sre-purchase/to-contract-close-list")
	public String contractCloseList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String departCode = sysUserInfo.getUnitCode();
		request.setAttribute("departCode", departCode);
		String parentUnitPathIds = "";
		String unitPathIds = sysUserInfo.getUnitPath();
		parentUnitPathIds = EquipmentUtils.getParentUnitPathId(unitPathIds);
		request.setAttribute("parentUnitPathIds", parentUnitPathIds);

		return "/stp/equipment/purchase/contract-close-list";
	}

	/**
	 * 查询列表
	 * 
	 * @param param
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sre_purchase/list")
	@ResponseBody
	public String ajaxlist(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) throws Exception {

		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		// 安全设置：归档文件下载
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");

		return result.toString();
	}

	/**
	 * 增加
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sre-purchase/add")
	public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String parentUnitPathName = "";
		String parentUnitPathId = "";
		String purchaseName = "";
		String projectId = "";
		String name = "";
		String equipmentId = "";
		String sreProjectEquipmentIds = "";
		String remarks = "";
		String purchaseCode = "";
		String unitPathIds = sysUserInfo.getUnitPath();
		parentUnitPathId = EquipmentUtils.getParentUnitPathId(unitPathIds);
		parentUnitPathName = EquipmentUtils.getParentUnitPathName(parentUnitPathId, restTemplate, httpHeaders);

		String departName = sysUserInfo.getUnitName();
		String departCode = sysUserInfo.getUnitCode();
		String createUserName = sysUserInfo.getUserDisp();
		String createUserId = sysUserInfo.getUserName();
		String id = CommonUtil.getParameter(request, "id", "");
		request.setAttribute("id", id);
		// purchaseCode = CodeUtil.getCode("XTBM_0074", restTemplate,
		// httpHeaders);
		if (!id.equals("")) {
			ResponseEntity<SrePurchase> srePurchaseResponseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePurchase.class);
			int statusCode = srePurchaseResponseEntity.getStatusCodeValue();
			SrePurchase srePurchase = srePurchaseResponseEntity.getBody();
			projectId = srePurchase.getProjectId();
			purchaseName = srePurchase.getPurchaseName();
			equipmentId = srePurchase.getEquipmentId();
			remarks = srePurchase.getRemarks();
			purchaseCode = srePurchase.getPurchaseCode();
			ResponseEntity<SreProject> SreProjectResponseEntity = this.restTemplate.exchange(GET_BY_PROJECT_ID + projectId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreProject.class);
			if (SreProjectResponseEntity != null) {
				SreProject sreProject = SreProjectResponseEntity.getBody();
				name = sreProject.getName();
				sreProjectEquipmentIds = sreProject.getEquipmentIds();
			}
		}

		request.setAttribute("parentUnitPathName", parentUnitPathName);
		request.setAttribute("parentUnitPathId", parentUnitPathId);
		request.setAttribute("departName", departName);
		request.setAttribute("departCode", departCode);
		request.setAttribute("createUserName", createUserName);
		request.setAttribute("createUserId", createUserId);
		request.setAttribute("purchaseName", purchaseName);
		request.setAttribute("topicId", projectId);
		request.setAttribute("name", name);
		request.setAttribute("equipmentIds", equipmentId);
		request.setAttribute("sreProjectEquipmentIds", sreProjectEquipmentIds);
		request.setAttribute("purchaseCode", purchaseCode);
		request.setAttribute("remarks", remarks);

		List<UnitField> unitFieldList = CommonUtil.getUnitNameList(restTemplate, httpHeaders);
		request.setAttribute("unitFieldList", unitFieldList);

		return "/stp/equipment/purchase/purchase-add";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/sre-purchase/chooseProject")
	private String chooseProject(HttpServletRequest request) {
		String applyUnitCode = sysUserInfo.getUnitCode();
		request.setAttribute("applyUnitCode", applyUnitCode);
		String parentUnitPathIds = "";
		String unitPathIds = sysUserInfo.getUnitPath();
		parentUnitPathIds = EquipmentUtils.getParentUnitPathId(unitPathIds);
		request.setAttribute("parentUnitPathIds", parentUnitPathIds);
		return "/stp/equipment/purchase/chooseProject";
	}

	@RequestMapping(value = "/sre-purchase/chooseProject_data")
	@ResponseBody
	public String chooseProject_data(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) throws Exception {

		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PAGE_URL_CHOOSE_PROJECT, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============查询结果：" + result);
		return result.toString();
	}

	/**
	 * 查询合同数据
	 * 
	 * @param param
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sre-purchase/project_task/list")
	@ResponseBody
	public String list(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {

		JSONObject parmamss = JSONObject.parseObject(JSONObject.toJSONString(param));
		logger.info("============参数：" + parmamss.toString());
		//
		String applyDepartCode = sysUserInfo.getUnitCode();

		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PAGE_URL_PROJECT_TASK, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============查询结果：" + result);
		return result.toString();
	}

	/**
	 * 保存-更新操作
	 *
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/sre-purchase/save")
	@ResponseBody
	public String saveOrUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result resultsDate = dealSaveUpdate(request);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		out.println(ob.toString());
		out.flush();
		out.close();
		return null;
	}

	private Result dealSaveUpdate(HttpServletRequest request) throws Exception {
		Result resultsDate = new Result();
		String name = CommonUtil.getParameter(request, "name", "");
		// 业务ID
		String id = CommonUtil.getParameter(request, "id", "");
		// 流程状态-是保存还是提交
		String status = CommonUtil.getParameter(request, "status", Constant.PURCHASE_STATUS_DRAFT);
		String stage = CommonUtil.getParameter(request, "stage", Constant.PURCHASE_REQUEST);
		String topicId = CommonUtil.getParameter(request, "topicId", "");
		String taskWriteUsersIds = CommonUtil.getParameter(request, "taskWriteUsersIds", "");
		String purchaseName = CommonUtil.getParameter(request, "purchaseName", "");
		String equipmentIds = CommonUtil.getParameter(request, "equipmentIds", "");
		String parentUnitPathName = CommonUtil.getParameter(request, "parentUnitPathName", "");
		String parentUnitPathId = CommonUtil.getParameter(request, "parentUnitPathId", "");
		String departName = CommonUtil.getParameter(request, "departName", "");
		String departCode = CommonUtil.getParameter(request, "departCode", "");
		String createUserName = CommonUtil.getParameter(request, "createUserName", "");
		String createUserId = CommonUtil.getParameter(request, "createUserId", "");
		String isContractClosed = CommonUtil.getParameter(request, "isContractClosed", Constant.PURCHASE_CONTRACT_STAY_CLOSE);
		String remarks = CommonUtil.getParameter(request, "remarks", "");
		String purchaseCode = CommonUtil.getParameter(request, "purchaseCode", "");
		String taskId = CommonUtil.getParameter(request, "taskId", "");

		SrePurchase srePurchase = null;
		ResponseEntity<String> responseEntity = null;
		// 判断是新增还是修改
		if (id.equals("")) {
			srePurchase = new SrePurchase();
			srePurchase.setCreateDate(new Date());

			String idv = UUID.randomUUID().toString().replaceAll("-", "");
			srePurchase.setId(idv);
			srePurchase.setState(status);
			srePurchase.setStage(stage);
		} else {
			ResponseEntity<SrePurchase> se = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePurchase.class);
			srePurchase = se.getBody();
		}
		// 流程状态
		srePurchase.setTaskId(taskId);
		srePurchase.setState(status);
		srePurchase.setPurchaseName(purchaseName);// 采购名称
		srePurchase.setParentUnitPathNames(parentUnitPathName);// 单位名称
		srePurchase.setParentUnitPathId(parentUnitPathId);// 单位ID
		srePurchase.setDepartName(departName);// 部门名称
		srePurchase.setDepartCode(departCode);// 部门Code
		srePurchase.setProposerName(createUserName);// 采购员姓名
		srePurchase.setProposerId(createUserId);// 采购员ID

		srePurchase.setEquipmentId(equipmentIds);// 装备ID
		srePurchase.setProjectId(topicId);// 课题ID
		srePurchase.setIsContractClosed(isContractClosed);
		srePurchase.setRemarks(remarks);
		srePurchase.setPurchaseCode(purchaseCode);

		// 判断是新增还是修改
		if (id.equals("")) {
			responseEntity = this.restTemplate.exchange(ADD_URL, HttpMethod.POST, new HttpEntity<SrePurchase>(srePurchase, this.httpHeaders), String.class);

		} else {
			responseEntity = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SrePurchase>(srePurchase, this.httpHeaders), String.class);
		}
		// 返回结果代码
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			String[] arr = equipmentIds.split(",");
			for (int i = 0; i < arr.length; i++) {
				System.err.println(arr[i]);
				SreEquipment sreEquipment = EquipmentUtils.getSreEquipment(arr[i], restTemplate, httpHeaders);
				if (sreEquipment != null) {
					sreEquipment.setPurchaseStatus(Constant.EQUIPMENT_PURCHASE_PRE_PURCHASE);
					EquipmentUtils.updateSreEquipment(sreEquipment, restTemplate, httpHeaders);
				}
			}
			resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
		} else {
			resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
		}

		return resultsDate;
	}

	/**
	 * 删除
	 *
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sre-purchase/delete/{id}")
	public String delete(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();
		if (StringUtils.isNotBlank(id)) {
			/* if(id!=null && !"".equals(id)){ */
			SrePurchase srePurchase = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePurchase.class).getBody();
			if (srePurchase != null) {
				String equipmentIds = srePurchase.getEquipmentId();
				String[] arr = equipmentIds.split(",");
				for (int i = 0; i < arr.length; i++) {
					System.err.println(arr[i]);
					SreEquipment sreEquipment = EquipmentUtils.getSreEquipment(arr[i], restTemplate, httpHeaders);
					sreEquipment.setPurchaseStatus(Constant.EQUIPMENT_PURCHASE_DRAFT);
					EquipmentUtils.updateSreEquipment(sreEquipment, restTemplate, httpHeaders);
				}
			}
		}
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(DEL_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), Integer.class);
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
	 *
	 * @throws Exception
	 */
	@RequestMapping(value = "/sre-purchase/getParticulars/{id}", method = RequestMethod.GET)
	public String getParticulars(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseEntity<SrePurchase> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePurchase.class);
		int statusCode = 0;
		String projectId = null;
		SrePurchase srePurchase = null;
		if (responseEntity != null) {
			statusCode = responseEntity.getStatusCodeValue();
			logger.info("============远程返回  statusCode " + statusCode);
			srePurchase = responseEntity.getBody();
			request.setAttribute("srePurchase", srePurchase);
			projectId = srePurchase.getProjectId();
		}
		ResponseEntity<SreProject> responseEntity1 = this.restTemplate.exchange(GET_PROJECT_URL + projectId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreProject.class);
		if (responseEntity1 != null) {
			int statusCode1 = responseEntity.getStatusCodeValue();
			logger.info("============远程返回  statusCode " + statusCode);
			SreProject sreProjectBasic = responseEntity1.getBody();
			request.setAttribute("sreProjectBasic", sreProjectBasic);
			String name = sreProjectBasic.getName();
			System.out.println(name + "=================================");

			String proposerName = srePurchase.getProposerName();
			String departCode = srePurchase.getDepartCode();
			String departName = srePurchase.getDepartName();
			String parentUnitPathNames = srePurchase.getParentUnitPathNames();
			String remarks = srePurchase.getRemarks();
			String purchaseCode = srePurchase.getPurchaseCode();

			request.setAttribute("proposerName", proposerName);
			request.setAttribute("departCode", departCode);
			request.setAttribute("departName", departName);
			request.setAttribute("parentUnitPathNames", parentUnitPathNames);
			request.setAttribute("remarks", remarks);
			request.setAttribute("purchaseCode", purchaseCode);
			List<UnitField> unitFieldList = CommonUtil.getUnitNameList(restTemplate, httpHeaders);
			request.setAttribute("unitFieldList", unitFieldList);
		}
		List<SysDictionary> dicList = CommonUtil.getDictionaryByParentCode("ROOT_UNIVERSAL_LCZT", restTemplate, httpHeaders);
		request.setAttribute("dicList", dicList);

		return "/stp/equipment/purchase/purchase-view";
	}

	/**
	 * 详情(多参数)
	 *
	 * @param request
	 * @param response
	 * @return
	 *
	 * @throws Exception
	 */
	@RequestMapping(value = "/sre-purchase/getParticularsDouble", method = RequestMethod.GET)
	public String getParticulars(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = CommonUtil.getParameter(request, "id", "");
		String uploadState = CommonUtil.getParameter(request, "uploadState", "");
		System.out.println(id);
		System.out.println(uploadState);
		ResponseEntity<SrePurchase> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePurchase.class);
		int statusCode = 0;
		String projectId = null;
		SrePurchase srePurchase = null;
		if (responseEntity != null) {
			statusCode = responseEntity.getStatusCodeValue();
			logger.info("============远程返回  statusCode " + statusCode);
			srePurchase = responseEntity.getBody();
			request.setAttribute("srePurchase", srePurchase);
			projectId = srePurchase.getProjectId();
		}
		ResponseEntity<SreProject> responseEntity1 = this.restTemplate.exchange(GET_PROJECT_URL + projectId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreProject.class);
		if (responseEntity1 != null) {
			int statusCode1 = responseEntity.getStatusCodeValue();
			logger.info("============远程返回  statusCode " + statusCode);
			SreProject sreProjectBasic = responseEntity1.getBody();
			request.setAttribute("sreProjectBasic", sreProjectBasic);
			String name = sreProjectBasic.getName();
			System.out.println(name + "=================================");

			String proposerName = srePurchase.getProposerName();
			String departCode = srePurchase.getDepartCode();
			String departName = srePurchase.getDepartName();
			String parentUnitPathNames = srePurchase.getParentUnitPathNames();
			String remarks = srePurchase.getRemarks();
			String purchaseCode = srePurchase.getPurchaseCode();

			request.setAttribute("uploadState", uploadState);
			request.setAttribute("proposerName", proposerName);
			request.setAttribute("departCode", departCode);
			request.setAttribute("departName", departName);
			request.setAttribute("parentUnitPathNames", parentUnitPathNames);
			request.setAttribute("remarks", remarks);
			request.setAttribute("purchaseCode", purchaseCode);
			List<UnitField> unitFieldList = CommonUtil.getUnitNameList(restTemplate, httpHeaders);
			request.setAttribute("unitFieldList", unitFieldList);
		}
		List<SysDictionary> dicList = CommonUtil.getDictionaryByParentCode("ROOT_UNIVERSAL_LCZT", restTemplate, httpHeaders);
		request.setAttribute("dicList", dicList);

		return "/stp/equipment/purchase/purchase-view";
	}

	// 启动采购申请 确认上报流程
	@RequestMapping(value = "/sre-purchase/start_purchase_workflow")
	@ResponseBody
	public Object start_purchase_workflow(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result rs = null;
		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);// 设置参数类型和编码
		String id = CommonUtil.getParameter(request, "id", "");
		String functionId = CommonUtil.getParameter(request, "functionId", "");
		String userIds = CommonUtil.getParameter(request, "userIds", "");
		System.out.println("============start_purchase_workflow userIds=" + userIds + " functionId=" + functionId + " id=" + id);

		SrePurchase srePurchase = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePurchase.class).getBody();
		if (srePurchase != null) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("id", id);
			paramMap.put("functionId", functionId);
			paramMap.put("processInstanceName", "采购申请确认->" + srePurchase.getPurchaseName());
			paramMap.put("authenticatedUserId", sysUserInfo.getUserId());
			paramMap.put("authenticatedUserName", sysUserInfo.getUserDisp());
			paramMap.put("auditor", userIds);
			// 申请者机构信息
			paramMap.put("applyUnitCode", sysUserInfo.getUnitCode());
			String parentApplyUnitCode = EquipmentUtils.getUnitParentCodesByUnitCodes(sysUserInfo.getUnitCode(), restTemplate, httpHeaders);
			paramMap.put("parentApplyUnitCode", parentApplyUnitCode);

			HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap, this.httpHeaders);
			rs = this.restTemplate.exchange(PURCHASE_INNER_WORKFLOW_URL + id, HttpMethod.POST, httpEntity, Result.class).getBody();
		}
		return rs;
	}

	// 合同系统对接上报
	@RequestMapping(value = "/sre-purchase/contractSubmission/{id}")
	@ResponseBody
	public Result contractSubmission(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();

		SrePurchase srePurchase = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePurchase.class).getBody();
		if (srePurchase != null) {
			String equipmentIds = srePurchase.getEquipmentId();
			String[] arr = equipmentIds.split(",");
			for (int i = 0; i < arr.length; i++) {
				System.err.println(arr[i]);
				SreEquipment sreEquipment = EquipmentUtils.getSreEquipment(arr[i], restTemplate, httpHeaders);
				sreEquipment.setPurchaseStatus(Constant.EQUIPMENT_PURCHASE_COMPACT);
				EquipmentUtils.updateSreEquipment(sreEquipment, restTemplate, httpHeaders);
			}
			srePurchase.setState(Constant.PURCHASE_STATUS_COMPACT);
			srePurchase.setStage(Constant.PURCHASE_ARRIVE_GOODS);
		}
		ResponseEntity<String> exchange1 = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SrePurchase>(srePurchase, this.httpHeaders), String.class);
		int statusCodeValue = exchange1.getStatusCodeValue();
		if (statusCodeValue == 200) {
			resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
		} else {
			resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
		}
		return resultsDate;
	}

	// 到货验收上报
	@RequestMapping(value = "/sre-purchase/arriveGoodsSubmission/{id}")
	@ResponseBody
	public Result arriveGoodsSubmission(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();

		SrePurchase srePurchase = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePurchase.class).getBody();
		if (srePurchase != null) {
			String equipmentIds = srePurchase.getEquipmentId();
			String[] arr = equipmentIds.split(",");
			for (int i = 0; i < arr.length; i++) {
				System.err.println(arr[i]);
				SreEquipment sreEquipment = EquipmentUtils.getSreEquipment(arr[i], restTemplate, httpHeaders);
				if (sreEquipment != null) {
					sreEquipment.setPurchaseStatus(Constant.EQUIPMENT_PURCHASE_ARRIVE_GOODS);
					EquipmentUtils.updateSreEquipment(sreEquipment, restTemplate, httpHeaders);
				}
			}
			srePurchase.setState(Constant.PURCHASE_STATUS_ARRIVE_GOODS);
			srePurchase.setStage(Constant.PURCHASE_CONTRACT_CHECK);
		}
		ResponseEntity<String> exchange1 = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SrePurchase>(srePurchase, this.httpHeaders), String.class);
		int statusCodeValue = exchange1.getStatusCodeValue();
		if (statusCodeValue == 200) {
			resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
		} else {
			resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
		}
		return resultsDate;
	}

	// 合同验收上报
	@RequestMapping(value = "/sre-purchase/contractAcceptanceSubmission/{id}")
	@ResponseBody
	public Result contractAcceptanceSubmission(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();

		SrePurchase srePurchase = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePurchase.class).getBody();
		if (srePurchase != null) {
			String equipmentIds = srePurchase.getEquipmentId();
			String[] arr = equipmentIds.split(",");
			for (int i = 0; i < arr.length; i++) {
				System.err.println(arr[i]);
				SreEquipment sreEquipment = EquipmentUtils.getSreEquipment(arr[i], restTemplate, httpHeaders);
				if (sreEquipment != null) {
					sreEquipment.setPurchaseStatus(Constant.EQUIPMENT_PURCHASE_CONTRACT_ACCEPTANCE);
					EquipmentUtils.updateSreEquipment(sreEquipment, restTemplate, httpHeaders);
				}
			}
			srePurchase.setState(Constant.PURCHASE_STATUS_CONTRACT_ACCEPTANCE);
			srePurchase.setStage(Constant.PURCHASE_INSTALL_DEBUG);
		}
		ResponseEntity<String> exchange1 = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SrePurchase>(srePurchase, this.httpHeaders), String.class);
		int statusCodeValue = exchange1.getStatusCodeValue();
		if (statusCodeValue == 200) {
			resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
		} else {
			resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
		}
		return resultsDate;
	}

	// 安装调试上报
	@RequestMapping(value = "/sre-purchase/installationSubmission/{id}")
	@ResponseBody
	public Result installationSubmission(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();

		SrePurchase srePurchase = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePurchase.class).getBody();
		if (srePurchase != null) {
			String equipmentIds = srePurchase.getEquipmentId();
			String[] arr = equipmentIds.split(",");
			for (int i = 0; i < arr.length; i++) {
				System.err.println(arr[i]);
				SreEquipment sreEquipment = EquipmentUtils.getSreEquipment(arr[i], restTemplate, httpHeaders);
				if (sreEquipment != null) {
					sreEquipment.setPurchaseStatus(Constant.EQUIPMENT_PURCHASE_INSTALLATION);
					EquipmentUtils.updateSreEquipment(sreEquipment, restTemplate, httpHeaders);
				}
			}
			srePurchase.setState(Constant.PURCHASE_STATUS_INSTALLATION);
			srePurchase.setStage(Constant.PURCHASE_CONTRACT_CLOSE);
		}
		ResponseEntity<String> exchange1 = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SrePurchase>(srePurchase, this.httpHeaders), String.class);
		int statusCodeValue = exchange1.getStatusCodeValue();
		if (statusCodeValue == 200) {
			resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
		} else {
			resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
		}
		return resultsDate;
	}

	// 关闭合同
	@RequestMapping(value = "/sre-purchase/is-contract-closed/{id}")
	@ResponseBody
	public Result isContractClosed(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();

		SrePurchase srePurchase = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePurchase.class).getBody();
		if (srePurchase != null) {
			String equipmentIds = srePurchase.getEquipmentId();
			String[] arr = equipmentIds.split(",");
			for (int i = 0; i < arr.length; i++) {
				System.err.println(arr[i]);
				SreEquipment sreEquipment = EquipmentUtils.getSreEquipment(arr[i], restTemplate, httpHeaders);
				if (sreEquipment != null) {
					sreEquipment.setPurchaseStatus(Constant.EQUIPMENT_PURCHASE_CONTRACT_CLOSE);
					EquipmentUtils.updateSreEquipment(sreEquipment, restTemplate, httpHeaders);
				}
			}
			srePurchase.setState(Constant.PURCHASE_STATUS_CONTRACT_CLOSE);
			srePurchase.setIsContractClosed(Constant.PURCHASE_CONTRACT_CLOSED);
		}
		ResponseEntity<String> exchange1 = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SrePurchase>(srePurchase, this.httpHeaders), String.class);
		int statusCodeValue = exchange1.getStatusCodeValue();
		if (statusCodeValue == 200) {
			resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
		} else {
			resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
		}
		return resultsDate;
	}

	// 根据ID查询课题信息
	@RequestMapping(value = "/sre-purchase/getProject/{topicId}", method = RequestMethod.GET)
	@ResponseBody
	public Result get(@PathVariable("topicId") String topicId) throws Exception {
		Result resultsDate = new Result();

		ResponseEntity<SreProject> exchange = this.restTemplate.exchange(GET_BY_PROJECT_ID + topicId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreProject.class);
		SreProject sreProject = exchange.getBody();
		int statusCodeValue = exchange.getStatusCodeValue();
		if (statusCodeValue == 200) {
			resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
			resultsDate.setData(sreProject);
		} else {
			resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
		}
		return resultsDate;
	}

	/*
	 * =================================生成word文档
	 * START================================
	 */
	// 生成采购单word模板
	@RequestMapping(value = "/sre-purchase/createWord/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String createWord(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();
		String fileName = createPurchaseWord(id, "purchase.ftl", response);
		if (!fileName.equals("")) {
			resultsDate = new Result(true);
			download(TEMP_FILE_PATH + fileName, response);
			deleteFile(TEMP_FILE_PATH + fileName);
		} else {
			resultsDate = new Result(false, "生成文件失败！");
		}
		return null;
	}

	// 导出采购单word数据
	private String createPurchaseWord(String id, String ftlName, HttpServletResponse response) {

		String resutl = "";
		// 文件路径
		String filePath = TEMP_FILE_PATH;
		// 文件名称
		String fileName = DateUtil.dateToStr(new Date(), DateUtil.FMT_SSS_02) + ".doc";
		try {
			List<Map<String, Object>> purchaseEquipmentList = new ArrayList<Map<String, Object>>();
			Map<String, Object> dataMap = new HashMap<String, Object>();
			SrePurchase srePurchase = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePurchase.class).getBody();
			if (srePurchase != null) {
				String projectName = null; // 课题名称
				String purchaseName = srePurchase.getPurchaseName();// 申请名称
				String proposerName = srePurchase.getProposerName();// 申请人姓名
				String parentUnitPathNames = srePurchase.getParentUnitPathNames();// 申请单位
				Date createDate = srePurchase.getCreateDate(); // 申请时间
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dateString = formatter.format(createDate);

				String projectId = srePurchase.getProjectId();
				SreProject sreProject = EquipmentUtils.getSreProject(projectId, restTemplate, httpHeaders);
				if (sreProject != null) {
					projectName = sreProject.getName();// 课题名称
				}
				String[] equipmentIds = srePurchase.getEquipmentId().split(",");// 采购申请下的装备ID
				for (int i = 0; i < equipmentIds.length; i++) {// 循环装备id,获取所有装备信息
					String equipmentId = equipmentIds[i];
					SreEquipment sreEquipment = EquipmentUtils.getSreEquipment(equipmentId, restTemplate, httpHeaders);
					if (sreEquipment != null) {
						String equipmentName = sreEquipment.getName(); // 装备名称
						String specification = sreEquipment.getSpecification();
						Integer applyAcount = sreEquipment.getApplyAcount();
						BigDecimal unitPrice = sreEquipment.getUnitPrice();

						Map<String, Object> map = new HashMap<String, Object>();

						map.put("projectName", projectName); // 课题名称
						map.put("purchaseName", purchaseName); // 申请名称
						map.put("parentUnitPathNames", parentUnitPathNames); // 申请单位
						map.put("proposerName", proposerName); // 申请人
						map.put("createDate", dateString); // 申请时间
						map.put("equipmentName", equipmentName); // 装备名称
						map.put("specification", specification); // 规格型号
						map.put("applyAcount", applyAcount); // 数量
						map.put("unitPrice", unitPrice); // 下达金额（万元）

						purchaseEquipmentList.add(map);
					}
				}
				dataMap.put("purchaseEquipmentList", purchaseEquipmentList);
			}
			/** 生成word */
			boolean flage = WordUtil.createWord(dataMap, ftlName, filePath, fileName);
			if (flage == true) {
				resutl = fileName;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resutl;
	}

	// 生成到货签收单word模板
	@RequestMapping(value = "/sre-purchase/createWordArriveGoods/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String createWordArriveGoods(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();
		String fileName = exportDataArriveGoods(id, "arriveGoods.ftl", response);
		if (!fileName.equals("")) {
			resultsDate = new Result(true);
			download(TEMP_FILE_PATH + fileName, response);
			deleteFile(TEMP_FILE_PATH + fileName);
		} else {
			resultsDate = new Result(false, "生成文件失败！");
		}
		return null;
	}

	// 导出到货签收单word数据
	private String exportDataArriveGoods(String id, String ftlName, HttpServletResponse response) {

		String resutl = "";
		// 文件路径
		String filePath = TEMP_FILE_PATH;
		// 文件名称
		String fileName = DateUtil.dateToStr(new Date(), DateUtil.FMT_SSS_02) + ".doc";
		try {
			List<Map<String, Object>> arriveGoodsListList = new ArrayList<Map<String, Object>>();
			Map<String, Object> dataMap = new HashMap<String, Object>();

			SrePurchase srePurchase = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePurchase.class).getBody();
			if (srePurchase != null) {
				int number = 0;
				String contractNum = null;
				String topicName = null;
				String[] equipmentIds = srePurchase.getEquipmentId().split(",");// 采购下的装备ID
				String taskId = srePurchase.getTaskId();// 任务书ID
				SreProjectTask sreProjectTask = EquipmentUtils.getSreProjectTask(taskId, restTemplate, httpHeaders);// 获取任务书信息
				if (sreProjectTask != null) {
					contractNum = sreProjectTask.getContractNum();// 合同号
					topicName = sreProjectTask.getTopicName();// 合同名称
				}
				for (int i = 0; i < equipmentIds.length; i++) {// 遍历获取所有装备ID
					number++;
					String equipmentId = equipmentIds[i];
					SreEquipment sreEquipment = EquipmentUtils.getSreEquipment(equipmentId, restTemplate, httpHeaders);
					String sreEquipmentName = sreEquipment.getName();// 装备名称
					String specialNotes = sreEquipment.getSpecialNotes();// 主要功能与用途（简述）
					Map<String, Object> equipmentMap = new HashMap<String, Object>();
					equipmentMap.put("number", number);
					equipmentMap.put("sreEquipmentName", sreEquipmentName);
					equipmentMap.put("specialNotes", specialNotes);
					arriveGoodsListList.add(equipmentMap);
				}
				/** 组装数据 */
				dataMap.put("contractNum", contractNum);// 合同编号
				dataMap.put("topicName", topicName);// 合同名称
				dataMap.put("arriveGoodsListList", arriveGoodsListList);

			}
			/** 生成word */
			boolean flage = WordUtil.createWord(dataMap, ftlName, filePath, fileName);
			if (flage == true) {
				resutl = fileName;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resutl;
	}

	public HttpServletResponse download(String path, HttpServletResponse response) {
		try {
			// path是指欲下载的文件的路径。
			File file = new File(path);
			// 取得文件名。
			String filename = file.getName();
			// 取得文件的后缀名。
			String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();

			// 以流的形式下载文件。
			InputStream fis = new BufferedInputStream(new FileInputStream(path));
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			fis.close();
			// 清空response
			response.reset();
			// 设置response的Header
			response.setCharacterEncoding("UTF-8");
			response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
			response.addHeader("Content-Length", "" + file.length());
			OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
			response.setContentType("application/octet-stream");
			toClient.write(buffer);
			toClient.flush();
			toClient.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return response;
	}

	public boolean deleteFile(String fileName) {
		File file = new File(fileName);
		// 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
		if (file.exists() && file.isFile()) {
			if (file.delete()) {
				System.out.println("删除单个文件" + fileName + "成功！");
				return true;
			} else {
				System.out.println("删除单个文件" + fileName + "失败！");
				return false;
			}
		} else {
			System.out.println("删除单个文件失败：" + fileName + "不存在！");
			return false;
		}
	}

	/*
	 * =================================生成word文档
	 * END================================
	 */
	/**
	 * 跳转到上传附件页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sre-purchase/upFileDoc")
	public String upFileDoc(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String id = CommonUtil.getParameter(request, "id", "");
		String uploadState = CommonUtil.getParameter(request, "uploadState", "");
		if (!id.equals("")) {
			ResponseEntity<SrePurchase> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePurchase.class);
			SrePurchase srePurchase = responseEntity.getBody();
			request.setAttribute("srePurchase", srePurchase);
			String documentDocPurchaseRequest = srePurchase.getDocumentDocPurchaseRequest();
			String documentDoc = srePurchase.getDocumentDoc();
			String docArriveGoods = srePurchase.getDocumentDocArriveGoods();
			String documentDocInstallDebug = srePurchase.getDocumentDocInstallDebug();
			String documentDocContractAcceptance = srePurchase.getDocumentDocContractAcceptance();
			String documentDocContractClose = srePurchase.getDocumentDocContractClose();
			String documentDocTender = srePurchase.getDocumentDocTender();
			String documentDocAgreement = srePurchase.getDocumentDocAgreement();

			if (uploadState.equals(Constant.PURCHASE_REQUEST)) {// 采购申请页面标识
				if (documentDocPurchaseRequest == null || documentDocPurchaseRequest.equals("")) {
					documentDocPurchaseRequest = IdUtil.createFileIdByTime();
				}
				request.setAttribute("documentDocPurchaseRequest", documentDocPurchaseRequest);
			} else if (uploadState.equals(Constant.PURCHASE_CONTRACT_DOCKING)) {// 合同系统对接页面标识
				if (documentDoc == null || documentDoc.equals("")) {
					documentDoc = IdUtil.createFileIdByTime();
				}
				request.setAttribute("documentDoc", documentDoc);
			} else if (uploadState.equals(Constant.PURCHASE_ARRIVE_GOODS)) {// 到货签收页面标识
				if (docArriveGoods == null || docArriveGoods.equals("")) {
					docArriveGoods = IdUtil.createFileIdByTime();
				}
				request.setAttribute("docArriveGoods", docArriveGoods);
			} else if (uploadState.equals(Constant.PURCHASE_CONTRACT_CHECK)) {// 合同验收页面标识
				if (documentDocContractAcceptance == null || documentDocContractAcceptance.equals("")) {
					documentDocContractAcceptance = IdUtil.createFileIdByTime();
				}
				request.setAttribute("documentDocContractAcceptance", documentDocContractAcceptance);
			} else if (uploadState.equals(Constant.PURCHASE_INSTALL_DEBUG)) {// 安装调试页面标识
				if (documentDocInstallDebug == null || documentDocInstallDebug.equals("")) {
					documentDocInstallDebug = IdUtil.createFileIdByTime();
				}
				request.setAttribute("documentDocInstallDebug", documentDocInstallDebug);
			} else if (uploadState.equals(Constant.PURCHASE_CONTRACT_CLOSE)) {// 合同关闭页面标识
				if (documentDocContractClose == null || documentDocContractClose.equals("")) {
					documentDocContractClose = IdUtil.createFileIdByTime();
				}
				request.setAttribute("documentDocContractClose", documentDocContractClose);
			} else if (uploadState.equals("7") || uploadState.equals("9")) {// 上传标书
				if (documentDocTender == null || documentDocTender.equals("")) {
					documentDocTender = IdUtil.createFileIdByTime();
				}
				request.setAttribute("documentDocTender", documentDocTender);
			} else if (uploadState.equals("8") || uploadState.equals("10")) {// 上传协议
				if (documentDocAgreement == null || documentDocAgreement.equals("")) {
					documentDocAgreement = IdUtil.createFileIdByTime();
				}
				request.setAttribute("documentDocAgreement", documentDocAgreement);
			}
			request.setAttribute("id", id);
			request.setAttribute("uploadState", uploadState);
		}

		return "/stp/equipment/purchase/upFileDoc";
	}

	@RequestMapping(value = "/sre-purchase/updateFileDoc")
	public String updateFileDoc(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result resultsDate = new Result();
		String id = CommonUtil.getParameter(request, "id", "");
		String uploadState = CommonUtil.getParameter(request, "uploadState", "");

		String documentDocPurchaseRequest = CommonUtil.getParameter(request, "documentDocPurchaseRequest", "");
		String documentDoc = CommonUtil.getParameter(request, "documentDoc", "");
		String docArriveGoods = CommonUtil.getParameter(request, "docArriveGoods", "");
		String documentDocInstallDebug = CommonUtil.getParameter(request, "documentDocInstallDebug", "");
		String documentDocContractAcceptance = CommonUtil.getParameter(request, "documentDocContractAcceptance", "");
		String documentDocContractClose = CommonUtil.getParameter(request, "documentDocContractClose", "");
		String documentDocTender = CommonUtil.getParameter(request, "documentDocTender", "");
		String documentDocAgreement = CommonUtil.getParameter(request, "documentDocAgreement", "");

		String resutl = "";

		int statusCodeValue = 0;
		if (!id.equals("")) {
			if (uploadState.equals(Constant.PURCHASE_REQUEST)) {
				ResponseEntity<SrePurchase> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePurchase.class);
				SrePurchase srePurchase = responseEntity.getBody();
				srePurchase.setDocumentDocPurchaseRequest(documentDocPurchaseRequest);
				ResponseEntity<String> exchange = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SrePurchase>(srePurchase, this.httpHeaders), String.class);
				statusCodeValue = responseEntity.getStatusCodeValue();
			} else if (uploadState.equals(Constant.PURCHASE_CONTRACT_DOCKING)) {
				ResponseEntity<SrePurchase> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePurchase.class);
				SrePurchase srePurchase = responseEntity.getBody();
				srePurchase.setDocumentDoc(documentDoc);
				ResponseEntity<String> exchange = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SrePurchase>(srePurchase, this.httpHeaders), String.class);
				statusCodeValue = responseEntity.getStatusCodeValue();
			} else if (uploadState.equals(Constant.PURCHASE_ARRIVE_GOODS)) {
				ResponseEntity<SrePurchase> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePurchase.class);
				SrePurchase srePurchase = responseEntity.getBody();
				srePurchase.setDocumentDocArriveGoods(docArriveGoods);
				ResponseEntity<String> exchange = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SrePurchase>(srePurchase, this.httpHeaders), String.class);
				statusCodeValue = responseEntity.getStatusCodeValue();
			} else if (uploadState.equals(Constant.PURCHASE_CONTRACT_CHECK)) {
				ResponseEntity<SrePurchase> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePurchase.class);
				SrePurchase srePurchase = responseEntity.getBody();
				srePurchase.setDocumentDocContractAcceptance(documentDocContractAcceptance);
				ResponseEntity<String> exchange = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SrePurchase>(srePurchase, this.httpHeaders), String.class);
				statusCodeValue = responseEntity.getStatusCodeValue();
			} else if (uploadState.equals(Constant.PURCHASE_INSTALL_DEBUG)) {
				ResponseEntity<SrePurchase> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePurchase.class);
				SrePurchase srePurchase = responseEntity.getBody();
				srePurchase.setDocumentDocInstallDebug(documentDocInstallDebug);
				ResponseEntity<String> exchange = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SrePurchase>(srePurchase, this.httpHeaders), String.class);
				statusCodeValue = responseEntity.getStatusCodeValue();
			} else if (uploadState.equals(Constant.PURCHASE_CONTRACT_CLOSE)) {
				ResponseEntity<SrePurchase> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePurchase.class);
				SrePurchase srePurchase = responseEntity.getBody();
				srePurchase.setDocumentDocContractClose(documentDocContractClose);
				ResponseEntity<String> exchange = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SrePurchase>(srePurchase, this.httpHeaders), String.class);
				statusCodeValue = responseEntity.getStatusCodeValue();
			} else if (uploadState.equals("7")) {
				ResponseEntity<SrePurchase> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePurchase.class);
				SrePurchase srePurchase = responseEntity.getBody();
				srePurchase.setDocumentDocTender(documentDocTender);
				ResponseEntity<String> exchange = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SrePurchase>(srePurchase, this.httpHeaders), String.class);
				statusCodeValue = responseEntity.getStatusCodeValue();
			} else if (uploadState.equals("8")) {
				ResponseEntity<SrePurchase> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePurchase.class);
				SrePurchase srePurchase = responseEntity.getBody();
				srePurchase.setDocumentDocAgreement(documentDocAgreement);
				ResponseEntity<String> exchange = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SrePurchase>(srePurchase, this.httpHeaders), String.class);
				statusCodeValue = responseEntity.getStatusCodeValue();
			}
		}
		if (statusCodeValue == 200) {
			resultsDate.setSuccess(true);

			if (uploadState.equals(Constant.PURCHASE_REQUEST)) {// 采购申请通过
				SrePurchase srePurchase = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePurchase.class).getBody();
				if (srePurchase != null) {
					String[] equipmentIds = srePurchase.getEquipmentId().split(",");
					for (int i = 0; i < equipmentIds.length; i++) {
						String equipmentId = equipmentIds[i];
						SreEquipment sreEquipment = EquipmentUtils.getSreEquipment(equipmentId, restTemplate, httpHeaders);
						if (sreEquipment != null) {
							sreEquipment.setPurchaseStatus(Constant.EQUIPMENT_PURCHASE_PASS);
							EquipmentUtils.updateSreEquipment(sreEquipment, restTemplate, httpHeaders);
						}
					}
					srePurchase.setStage(Constant.PURCHASE_CONTRACT_DOCKING);
					srePurchase.setState(Constant.PURCHASE_STATUS_PASS);
					ResponseEntity<String> exchange1 = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SrePurchase>(srePurchase, this.httpHeaders), String.class);
				}
			} else if (uploadState.equals(Constant.PURCHASE_CONTRACT_CLOSE)) {// 关闭合同
				SrePurchase srePurchase = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SrePurchase.class).getBody();
				if (srePurchase != null) {
					String equipmentIds = srePurchase.getEquipmentId();
					String[] arr = equipmentIds.split(",");
					for (int i = 0; i < arr.length; i++) {
						System.err.println(arr[i]);
						SreEquipment sreEquipment = EquipmentUtils.getSreEquipment(arr[i], restTemplate, httpHeaders);
						if (sreEquipment != null) {
							sreEquipment.setPurchaseStatus(Constant.EQUIPMENT_PURCHASE_CONTRACT_CLOSE);
							EquipmentUtils.updateSreEquipment(sreEquipment, restTemplate, httpHeaders);
						}
					}
					srePurchase.setState(Constant.PURCHASE_STATUS_CONTRACT_CLOSE);
					srePurchase.setIsContractClosed(Constant.PURCHASE_CONTRACT_CLOSED);
				}
				ResponseEntity<String> exchange1 = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SrePurchase>(srePurchase, this.httpHeaders), String.class);
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

	/*
	 * =================================导出Excel文档
	 * START================================
	 */
	@RequestMapping("sre_purchase/exportExcel")
	public void downBudgetGroupSplit(HttpServletResponse res) throws IOException {
		LayuiTableParam param = new LayuiTableParam();
		param.setLimit(100);
		param.setPage(1);
		System.out.println(JSON.toJSONString(param));
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(PAGE_URL, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), LayuiTableData.class);
		LayuiTableData tabldata = responseEntity.getBody();

		Map<String, String> parammap = new HashMap<String, String>();

		URL path = this.getClass().getResource("/");
		File f = new File(path.getPath() + "static/template/purchaseExcel.xlsx");/*
																				 * 模板
																				 * ==
																				 * =
																				 */
		// 写入新文件采购申请单
		String newFilePath = path.getPath() + "static/template/采购申请Excel测试_" + DateUtil.dateToStr(new Date(), "yyyyMMddHHmmss") + ".xlsx";
		File outFile = new File(newFilePath);

		processDataAndDownload(f, tabldata, parammap, outFile);
		// 下载文件
		this.fileDownload(new File(newFilePath), res);
	}

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;

	private void processDataAndDownload(File template, LayuiTableData tableData, Map<String, String> param, File outFile) {
		try {
			InputStream is = new FileInputStream(template);
			workbook = new XSSFWorkbook(is);
			sheet = workbook.getSheetAt(0);

			// 从第二行开始数据
			int c_index = 1;
			int cout = 0;
			for (java.util.Iterator<?> iter = tableData.getData().iterator(); iter.hasNext();) {
				c_index++;
				cout++;
				JSONObject json = JSON.parseObject(JSON.toJSONString(iter.next()));
				String purchaseName = json.getString("purchaseName");

				Row row = sheet.getRow(c_index);
				if (row == null) {
					row = sheet.createRow(c_index);
				}

				row.createCell(0).setCellValue(cout);
				row.createCell(1).setCellValue(purchaseName);
			}

			// 写入新文件
			FileOutputStream fos = new FileOutputStream(outFile);
			workbook.write(fos);
			// 关闭流
			closeIO(fos);
			closeIO(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void fileDownload(File file, HttpServletResponse res) {
		OutputStream out = null;
		InputStream in = null;
		try {

			res.setHeader("content-type", "application/octet-stream");
			res.setContentType("application/octet-stream");
			res.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(file.getName(), "UTF-8"));

			out = res.getOutputStream();
			in = new FileInputStream(file);

			byte[] b = new byte[1000];
			int len;
			while ((len = in.read(b)) > 0) {
				out.write(b, 0, len);
			}
			closeIO(in);
			closeIO(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void closeIO(Closeable io) {
		if (io != null) {
			try {
				io.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * =================================导出Excel文档
	 * END================================
	 */
}
