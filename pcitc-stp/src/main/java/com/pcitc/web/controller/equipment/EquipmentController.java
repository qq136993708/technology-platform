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
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.RequestProcessStatusEnum;
import com.pcitc.base.hana.report.DicSupplyer;
import com.pcitc.base.hana.report.ScientificCashFlow03;
import com.pcitc.base.stp.equipment.SreEquipment;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.system.SysUserProperty;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.JsonUtil;
import com.pcitc.base.util.ResultsDate;
import com.pcitc.base.workflow.Constants;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.web.utils.EquipmentUtils;

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
	
	
	private static final String chooseBusiness_data = "http://pcitc-zuul/hana-proxy/hana/common/dic/supplyer_table";
	

	
	@RequestMapping(value = "/guihua")
	public String guihua(HttpServletRequest request, HttpServletResponse response) {
		return "/stp/equipment/guihua";
	}
	@RequestMapping(value = "/guihua_list")
	public String guihua_list(HttpServletRequest request, HttpServletResponse response) {
		return "/stp/equipment/guihua_list";
	}
	
	
	//计划上报
	@RequestMapping(value = "/plan_up")
	public String plan_up(HttpServletRequest request, HttpServletResponse response) {
		return "/stp/equipment/plan_up";
	}
	
	
	@RequestMapping(value = "/plan_up_list")
	public String plan_up_list(HttpServletRequest request, HttpServletResponse response) {
		return "/stp/equipment/plan_up_list";
	}
	
	@RequestMapping(value = "/plan_update")
	public String plan_update(HttpServletRequest request, HttpServletResponse response) {
		return "/stp/equipment/plan_update";
	}
	
	
	
	//规划审批
	@RequestMapping(value = "/plan_audit_list")
			public String plan_audit_list(HttpServletRequest request, HttpServletResponse response) {
				return "/stp/equipment/plan_audit_list";
			}
	
	
	
	//规划审批
	@RequestMapping(value = "/plan_audit")
	public String plan_audit(HttpServletRequest request, HttpServletResponse response) {
		return "/stp/equipment/plan_audit";
	}
		
	
	
	
	//接收计划
	@RequestMapping(value = "/over_plan")
	public String over_plan(HttpServletRequest request, HttpServletResponse response) {
		return "/stp/equipment/over_plan";
	}
	
	
	//采购信息
	@RequestMapping(value = "/plan_info")
	public String plan_info(HttpServletRequest request, HttpServletResponse response) {
		return "/stp/equipment/plan_info";
	}
		
		

	//验收
	@RequestMapping(value = "/check_list")
	public String check_list(HttpServletRequest request, HttpServletResponse response) {
		return "/stp/equipment/check_list";
	}
	
	
	  //报废处置
		@RequestMapping(value = "/apply_waste_list")
		public String apply_waste_list(HttpServletRequest request, HttpServletResponse response) {
			return "/stp/equipment/apply_waste_list";
		}
			@RequestMapping(value = "/apply_waste")
			public String apply_waste(HttpServletRequest request, HttpServletResponse response) {
				return "/stp/equipment/apply_waste";
			}
			
			
			
			
			//设备资料归档
			@RequestMapping(value = "/assets_list")
			public String assets_list(HttpServletRequest request, HttpServletResponse response) {
				return "/stp/equipment/assets_list";
			}
			@RequestMapping(value = "/assets")
			public String assets(HttpServletRequest request, HttpServletResponse response) {
				return "/stp/equipment/assets";
			}
			
			

			//转资
			@RequestMapping(value = "/transfer_funds_list")
			public String transfer_funds_list(HttpServletRequest request, HttpServletResponse response) {
				return "/stp/equipment/transfer_funds_list";
			}
			
			
		
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
	
	
	//判断有没有数据权限
	@RequestMapping(value = "/checkSysUserProperty")
	@ResponseBody
	public String checkSysUserProperty(HttpServletRequest request, HttpServletResponse response) 
	{
		Result resultsDate = new Result();
		SysUserProperty sysUserProperty=EquipmentUtils.getSysUserProperty(sysUserInfo.getUserId(), "G0DSM", restTemplate, httpHeaders);
		if(sysUserProperty!=null)
		{
			resultsDate.setSuccess(true);
		}else
		{
			resultsDate.setSuccess(false);
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		return result.toString();
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
		
		SysUserProperty sysUserProperty=EquipmentUtils.getSysUserProperty(sysUserInfo.getUserId(), "G0DSM", restTemplate, httpHeaders);
		String g0GSDM=sysUserProperty.getDataId();
		request.setAttribute("g0GSDM", g0GSDM);
		return "/stp/equipment/equipment/chooseBusiness";
	}
	

	@RequestMapping(value = "/chooseBusiness")
	@ResponseBody
	public String chooseBusiness(HttpServletRequest request) throws Exception {
		
		String name = CommonUtil.getParameter(request, "name", "");
		String cityName = CommonUtil.getParameter(request, "cityName", "");
		String companyCode = CommonUtil.getParameter(request, "companyCode", "");
		
		DicSupplyer function = new DicSupplyer();
		
		function.setG0GSDM(companyCode);
		function.setG0NAME1(name);
		function.setG0MCOD3(cityName);
		
		
		ResponseEntity<List> responseEntity = restTemplate.exchange(GET_DIC_SUPPLYER, HttpMethod.POST, new HttpEntity<DicSupplyer>(function, this.httpHeaders), List.class);
		List treeNodes = responseEntity.getBody();
		return JSONUtils.toJSONString(treeNodes);
	}
	
	
	
	   @RequestMapping( value = "/chooseBusiness_data")
		@ResponseBody
		public String chooseBusiness_data(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {

			System.out.println("equipment_03 param=   " + JSONObject.toJSONString(param));
			LayuiTableData layuiTableData = new LayuiTableData();
			HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
			ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(chooseBusiness_data, HttpMethod.POST, entity, LayuiTableData.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {
				layuiTableData = responseEntity.getBody();
			}
			JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
			System.out.println("chooseBusiness_data result=   " + result.toJSONString());
			return result.toString();
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
		String applyDepartCode=sysUserInfo.getUnitCode();
		request.setAttribute("applyDepartCode", applyDepartCode);
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
	
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/chooseEquipmentByUser")
	private String chooseEquipmentByUser(HttpServletRequest request) 
	{
		String equipmentIds = request.getParameter("equipmentIds");
		request.setAttribute("equipmentIds", equipmentIds);
        String applyDepartCode=sysUserInfo.getUnitCode();
		request.setAttribute("applyDepartCode", applyDepartCode);
		return "/stp/equipment/equipment/chooseEquipment";
		
    }
	
	
	@RequestMapping(value = "/chooseEquipmentByIds")
	@ResponseBody
	public String chooseEquipmentByIds(HttpServletRequest request, HttpServletResponse response) {
		LayuiTableData layuiTableData = new LayuiTableData();
		ResponseEntity<List> responseEntity = null;
		List returnlist = new ArrayList();
		String ids = CommonUtil.getParameter(request, "equipmentIds", "");
		if (!ids.equals("")) 
		{
			String chkbox[] = ids.split(",");
			if (chkbox != null && chkbox.length > 0)
			{
				List<String> list = Arrays.asList(chkbox);
				JSONArray jsonObject = JSONArray.parseArray(JSON.toJSONString(list));
				HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
				responseEntity = restTemplate.exchange(LIST_BY_IDS_URL, HttpMethod.POST, entity, List.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					returnlist = responseEntity.getBody();
				}
			}
		}
		layuiTableData.setData(returnlist);
		layuiTableData.setCode(0);
		layuiTableData.setCount(returnlist.size());
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		//logger.info("============result" + result);
		return result.toString();
		
	}
	
	
	
	//所选装备总金额
	@RequestMapping(value = "/get_money_by_ids")
	@ResponseBody
	public String list_by_ids(HttpServletRequest request, HttpServletResponse response) 
	{
		Result resultsDate = new Result();
		String ids = CommonUtil.getParameter(request, "equipmentIds", "");
		BigDecimal resultMoney=BigDecimal.ZERO;
		if (!ids.equals("")) 
		{
			String chkbox[] = ids.split(",");
			if (chkbox != null && chkbox.length > 0)
			{
				List<String> list = Arrays.asList(chkbox);
				JSONArray jsonObject = JSONArray.parseArray(JSON.toJSONString(list));
				HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
				ResponseEntity<JSONArray> response_Entity = restTemplate.exchange(LIST_BY_IDS_URL, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = response_Entity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					
					JSONArray array = response_Entity.getBody();
					List<SreEquipment> returnlist = JSONObject.parseArray(array.toJSONString(), SreEquipment.class);
					logger.info("============远程返回  list=" + list.size());
					if(returnlist!=null && returnlist.size()>0)
					{
						for(int i=0;i<returnlist.size();i++)
						{
							SreEquipment sreEquipment=(SreEquipment)returnlist.get(i);
							BigDecimal price=sreEquipment.getAllPrice();
							resultMoney=resultMoney.add(price);
							resultsDate.setData(resultMoney);
							resultsDate.setSuccess(true);
						}
					}
				}
			}
		}
		
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
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

	

	
	
	@RequestMapping(value = "/get_sreEquipment")
	public Object get_sreEquipment(@RequestParam(value = "equipmentId", required = true) String equipmentId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("equipmentId................." + equipmentId);
		return this.restTemplate.exchange(GET_URL + equipmentId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), SreEquipment.class).getBody();
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

		String applyDepartName = sysUserInfo.getUnitName();
		String applyDepartCode = sysUserInfo.getUnitCode();
		String firstApplyUser=sysUserInfo.getUserDisp();
		String attachmentDoc= IdUtil.createFileIdByTime();
		
		String equipmentId = CommonUtil.getParameter(request, "equipmentId", "");
		request.setAttribute("equipmentId", equipmentId);
		if(!equipmentId.equals(""))
		{
			ResponseEntity<SreEquipment> responseEntity = this.restTemplate.exchange(GET_URL + equipmentId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreEquipment.class);
			int statusCode = responseEntity.getStatusCodeValue();
			logger.info("============远程返回  statusCode " + statusCode);
			SreEquipment sreEquipment = responseEntity.getBody();
			request.setAttribute("sreEquipment", sreEquipment);
			
			applyDepartName = sreEquipment.getApplyDepartName();
			applyDepartCode = sreEquipment.getApplyDepartCode();
			firstApplyUser=sreEquipment.getFirstApplyUser();
			attachmentDoc=sreEquipment.getAttachmentDoc();
		}
		request.setAttribute("attachmentDoc", attachmentDoc);
		request.setAttribute("applyDepartName", applyDepartName);
		request.setAttribute("applyDepartCode", applyDepartCode);
		request.setAttribute("firstApplyUser", firstApplyUser);
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
		// 业务ID
		String equipmentId = CommonUtil.getParameter(request, "equipmentId", "");
		String firstApplyUser = CommonUtil.getParameter(request, "firstApplyUser", "");
		String specialNotes = CommonUtil.getParameter(request, "specialNotes", "");
		String notes = CommonUtil.getParameter(request, "notes", "");
		String applyAcount = CommonUtil.getParameter(request, "applyAcount", "");
		String type = CommonUtil.getParameter(request, "type", "");
		
		String unitPrice = CommonUtil.getParameter(request, "unitPrice", "");
		String attachmentDoc = CommonUtil.getParameter(request, "attachmentDoc", "");
		String specification = CommonUtil.getParameter(request, "specification", "");
		String voteCount =     CommonUtil.getParameter(request, "voteCount", "1");
		String supplierLinkMan = CommonUtil.getParameter(request, "supplierLinkMan", "");
		String supplierMobileEmail = CommonUtil.getParameter(request, "supplierMobileEmail", "");
		String supplierName =        CommonUtil.getParameter(request, "supplierName", "");
		String erpNo =        CommonUtil.getParameter(request, "erpNo", "");
		
		String applyDepartName =        CommonUtil.getParameter(request, "applyDepartName", "");
		String applyDepartCode =        CommonUtil.getParameter(request, "applyDepartCode", "");
		String originPlace =        CommonUtil.getParameter(request, "originPlace", "");
		
		
		    
		    
		String unitPathIds =        CommonUtil.getParameter(request, "unitPathIds","");
		String unitPathNames =        CommonUtil.getParameter(request, "unitPathNames", "");
		String parentUnitName =        CommonUtil.getParameter(request, "parentUnitName", "");
		String parentUnitCode =        CommonUtil.getParameter(request, "parentUnitCode", "");
		
		
		
		
		
		// 流程状态-是保存还是提交
		String auditStatus = CommonUtil.getParameter(request, "auditStatus", Constant.AUDIT_STATUS_DRAFT);
		String userIds = CommonUtil.getParameter(request, "userIds", "");
		SreEquipment sreEquipment = null;
		ResponseEntity<String> responseEntity = null;
		// 判断是新增还是修改
		if (equipmentId.equals("")) 
		{
			sreEquipment = new SreEquipment();
			sreEquipment.setCreateDate(new Date());
			sreEquipment.setCreateUserId(sysUserInfo.getUserName());
			String code = CommonUtil.getTableCode("XTBM_0016", restTemplate, httpHeaders);
			sreEquipment.setEquipmentCode(code);
			String id = UUID.randomUUID().toString().replaceAll("-", "");
			System.out.println("---------------UUID-id:" + id);
			sreEquipment.setEquipmentId(id);
			sreEquipment.setAttachmentDoc(attachmentDoc);
			sreEquipment.setApplyDepartName(applyDepartName);
			sreEquipment.setApplyDepartCode(applyDepartCode);
			sreEquipment.setIsLinkedProject("0");
			System.out.println("---------------applyDepartCode:" + applyDepartCode + " applyDepartCode=" + applyDepartCode + " UserId=" + sysUserInfo.getUserId());

		} else {
			ResponseEntity<SreEquipment> se = this.restTemplate.exchange(GET_URL + equipmentId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreEquipment.class);
			sreEquipment = se.getBody();
		}
		// 流程状态
		sreEquipment.setAuditStatus(String.valueOf(auditStatus));
		sreEquipment.setName(name);
		sreEquipment.setApplyAcount(Integer.valueOf(applyAcount));
		sreEquipment.setNotes(notes);
		sreEquipment.setSpecialNotes(specialNotes);
		sreEquipment.setType(type);
		sreEquipment.setAllPrice((new BigDecimal(unitPrice)).multiply(new BigDecimal(applyAcount)));
		sreEquipment.setUnitPrice(new BigDecimal(unitPrice));
		sreEquipment.setErpNo(erpNo);
		sreEquipment.setFirstApplyUser(firstApplyUser);
		sreEquipment.setNotes(notes);
		sreEquipment.setSpecialNotes(specialNotes);
		sreEquipment.setSpecification(specification);
		sreEquipment.setAttachmentDoc(attachmentDoc);
		sreEquipment.setVoteCount(Integer.valueOf(voteCount));
		sreEquipment.setSupplierLinkMan(supplierLinkMan);
		sreEquipment.setSupplierMobileEmail(supplierMobileEmail);
		sreEquipment.setSupplierName(supplierName);
		sreEquipment.setFirstApplyUser(firstApplyUser);
		sreEquipment.setOriginPlace(originPlace);
		// 判断是新增还是修改
		if (equipmentId.equals("")) {
			responseEntity = this.restTemplate.exchange(ADD_URL, HttpMethod.POST, new HttpEntity<SreEquipment>(sreEquipment, this.httpHeaders), String.class);

		} else {
			responseEntity = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SreEquipment>(sreEquipment, this.httpHeaders), String.class);
		}
		// 返回结果代码
		int statusCode = responseEntity.getStatusCodeValue();
		System.out.println(">>>>>>>>>>>>>>>>>>>返回  statusCode=" + statusCode);
		if (statusCode == 200) 
		{
			if (auditStatus.equals("0")) 
			{
				resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
			} else if (auditStatus.equals("1")) 
			{
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
	
	
	
	/*private String aa()
	{
		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("userId", sysUserInfo.getUserId());
	    requestBody.add("jsonStr", JsonUtil.parseMapToJson(paramMap));
	    HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);
	    ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(USER_DATA_FILTER_URL+sysUserInfo.getUserId()+"/"+inPro.getParam().get("functionCode"), HttpMethod.POST, entity, JSONArray.class);
	    JSONArray retJson = responseEntity.getBody();
	    if (retJson != null) {
	    	List<SysUserProperty> supList = JSONArray.parseArray(retJson.toString(), SysUserProperty.class);
	    	
	    	System.out.println("此人此功能配置的控制数据 : " + inPro.getParam().get("functionCode"));
    	    for (SysUserProperty supVO : supList) {
        	    if (inPro !=null && inPro.getParam().get(supVO.getDataType()) == null) {
        	    	System.out.println(supVO.getDataType()+"========自动加入的控制数据key-value================"+supVO.getDataId());
        	    	inPro.getParam().put(supVO.getDataType(), supVO.getDataId());
        		}
    	    }
    	    args[0] = inPro;
	    }
	}*/

}
