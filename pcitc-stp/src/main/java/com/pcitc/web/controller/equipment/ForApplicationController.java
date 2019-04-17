package com.pcitc.web.controller.equipment;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.RequestProcessStatusEnum;
import com.pcitc.base.stp.equipment.SreDetail;
import com.pcitc.base.stp.equipment.SreEquipment;
import com.pcitc.base.stp.equipment.SreForApplication;
import com.pcitc.base.stp.equipment.SreProjectTask;
import com.pcitc.base.stp.equipment.SrePurchase;
import com.pcitc.base.stp.equipment.UnitField;
import com.pcitc.base.system.SysUnit;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;

@Controller
public class ForApplicationController extends BaseController {
	
	private static final String PAGE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/forapplication/page";
	private static final String DEL_URL = "http://pcitc-zuul/stp-proxy/sre-provider/forapplication/delete/";
	private static final String ADD_URL = "http://pcitc-zuul/stp-proxy/sre-provider/forapplication/add";
	private static final String LIST_BY_IDS_URL = "http://pcitc-zuul/stp-proxy/sre-provider/equipment/list-by-ids/";
	private static final String GET_URL = "http://pcitc-zuul/stp-proxy/sre-provider/forapplication/get/";
	private static final String VIEW_URL = "http://pcitc-zuul/stp-proxy/sre-provider/forapplication/pageview";
	private static final String EQU_URL = "http://pcitc-zuul/stp-proxy/sre-provider/forapplicationequipment/page";
	private static final String DETAIL_URL = "http://pcitc-zuul/stp-proxy/sre-provider/Detail/add";
	/**
	 * 列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sre-forapplication/list")
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

	@RequestMapping(value = "/sre-forapplication/to-list")
	public String list(HttpServletRequest request, HttpServletResponse response) {

		String	parentUnitPathIds="";
		String unitPathIds =   sysUserInfo.getUnitPath();
		String applyDepartCode = sysUserInfo.getUnitCode();
		if(!unitPathIds.equals(""))
		{
			if(unitPathIds.length()>4)
			{
				parentUnitPathIds=unitPathIds.substring(0, unitPathIds.length()-4);
				
			}
		}
		request.setAttribute("parentUnitPathIds", parentUnitPathIds);
		request.setAttribute("applyDepartCode", applyDepartCode);
 		return "/stp/equipment/forapplication/application-list";
	}
	
	
	/**
	 * 删除
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sre-forapplication/delete/{applicationId}")
	public String delete(@PathVariable("applicationId") String applicationId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(DEL_URL + applicationId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
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
	 * 列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sre-forapplication/listfor")
	@ResponseBody
	public String list(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {
		
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(EQU_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============result" + result);
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
	@RequestMapping(method = RequestMethod.GET, value = "/sre-forapplication/add")
	public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String applyDepartName = sysUserInfo.getUnitName();
		String applyDepartCode = sysUserInfo.getUnitCode();
		String firstApplyUser=sysUserInfo.getUserDisp();
		String attachmentDoc= IdUtil.createFileIdByTime();
		
		String equipmentId = CommonUtil.getParameter(request, "equipmentId", "");
		request.setAttribute("equipmentId", equipmentId);
		if(!equipmentId.equals(""))
		{
			ResponseEntity<SreEquipment> responseEntity = this.restTemplate.exchange(ADD_URL + equipmentId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreEquipment.class);
			int statusCode = responseEntity.getStatusCodeValue();
			logger.info("============远程返回  statusCode " + statusCode);
			SreEquipment sreEquipment = responseEntity.getBody();
			request.setAttribute("sreEquipment", sreEquipment);
			
			applyDepartName = sreEquipment.getApplyDepartName();
			applyDepartCode = sreEquipment.getApplyDepartCode();
			firstApplyUser=sreEquipment.getFirstApplyUser();
			attachmentDoc=sreEquipment.getAttachmentDoc();
		}
		
		String leadUnitName =  "";
		String leadUnitCode =  "";
		String unitPathIds =   sysUserInfo.getUnitPath();
		if(!unitPathIds.equals(""))
		{
			if(unitPathIds.length()>4)
			{
				String	parentUnitPathIds=unitPathIds.substring(0, unitPathIds.length()-4);
				SysUnit sysUnit=EquipmentUtils.getUnitByUnitPath(parentUnitPathIds, restTemplate, httpHeaders);
				if(sysUnit!=null)
				{
					leadUnitName = sysUnit.getUnitName();
					leadUnitCode =sysUnit.getUnitCode();
				}
			}
		}
		request.setAttribute("leadUnitName", leadUnitName);
		request.setAttribute("leadUnitCode", leadUnitCode);
		request.setAttribute("attachmentDoc", attachmentDoc);
		request.setAttribute("applyDepartName", applyDepartName);
		request.setAttribute("applyDepartCode", applyDepartCode);
		request.setAttribute("firstApplyUser", firstApplyUser);
		
		//List<SrePurchase>  purchaseList= CommonUtil.getPurchaseNameIDList(restTemplate, httpHeaders);
		//request.setAttribute("purchaseList", purchaseList);
//		List<>  unitFieldList= CommonUtil.getUnitNameList(restTemplate, httpHeaders);
//		request.setAttribute("unitFieldList", unitFieldList);
		return "/stp/equipment/forapplication/application-add";
	}
	
	
	@RequestMapping(value = "/sre-forapplicatio/purchaseNameIds")
	@ResponseBody
	public String chooseEquipmentByIds(HttpServletRequest request, HttpServletResponse response) {
		LayuiTableData layuiTableData = new LayuiTableData();
		ResponseEntity<List> responseEntity = null;
		List returnlist = new ArrayList();
		String ids = CommonUtil.getParameter(request, "purchaseNameIds", "");
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
	
	/**
	 * 保存-更新操作
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/sre-forapplicatio/save")
	public String savePrivilege(String[] arr,String equipmentIds,String froname,HttpServletResponse response) throws IOException{ 
		String result = "";
		SreForApplication pplication = new SreForApplication();
		ResponseEntity<String> responseEntity = null;
		ResponseEntity<String> respo = null;
		String applyDepartName = sysUserInfo.getUnitName();
		String applyDepartCode = sysUserInfo.getUnitCode();
		String firstApplyUser=sysUserInfo.getUnitPath();
		String attachmentDoc= IdUtil.createFileIdByTime();
		if(!firstApplyUser.equals(""))
		{
			if(firstApplyUser.length()>4)
			{
				firstApplyUser=firstApplyUser.substring(0, firstApplyUser.length()-4);
				
			}
		}
		String id = UUID.randomUUID().toString().replaceAll("-", "");
		pplication.setApplicationId(id);
		pplication.setApplyDepartName(applyDepartName);
		pplication.setApplyDepartCode(applyDepartCode);
		pplication.setFirstApplyUser(firstApplyUser);
		pplication.setApplicationName(froname);//转资名称
		pplication.setApplicationTime(new Date());//申请时间
		pplication.setApplicationUserName(applyDepartName);//当前操作人
		pplication.setApplicationPurchaseid(equipmentIds);//装备ID
		pplication.setApplicationState("0");//申请状态
		responseEntity = this.restTemplate.exchange(ADD_URL, HttpMethod.POST, new HttpEntity<SreForApplication>(pplication, this.httpHeaders), String.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if(statusCode == 200) {
		String[] equipment = equipmentIds.split(",");
		for(int i = 0; i < equipment.length; i++) {
			SreDetail sreDeta = new SreDetail();
			String equipequipId = equipment[i];
			SreEquipment squipment=EquipmentUtils.getSreEquipment(equipequipId, restTemplate, httpHeaders);
			String sreDetaid = UUID.randomUUID().toString().replaceAll("-", "");
			sreDeta.setId(sreDetaid);//ID
			sreDeta.setEquipmentId(equipequipId);//装备ID
			sreDeta.setEquipmentName(squipment.getName());//装备名称
			sreDeta.setEquipmentType(squipment.getType());//装备分类
			sreDeta.setEquipmentPrice(squipment.getUnitPrice().toString());//装备单价
			sreDeta.setEquipmenNumber(String.valueOf(squipment.getApplyAcount()));//申请数量
			sreDeta.setDeclareUnit(squipment.getParentUnitPathNames());//申报单位
			sreDeta.setDeclareDepartment(squipment.getApplyDepartName());//申报部门
			sreDeta.setDeclareTime(new Date());//转资时间
			sreDeta.setDeclarePeople(squipment.getFirstApplyUser());//第一申报人
			sreDeta.setDeclareTime(squipment.getCreateDate());//申报时间
			sreDeta.setConfigure(id);//转资申请ID
			if(arr!=null) {
			for(int j=0;j<arr.length;j++){
				if(i == j) {
					sreDeta.setAssetNumber(arr[j]);//资产编号
				}
	         }
			}
				respo = this.restTemplate.exchange(DETAIL_URL, HttpMethod.POST, new HttpEntity<SreDetail>(sreDeta, this.httpHeaders), String.class);
				statusCode = respo.getStatusCodeValue();
				if(statusCode == 200) {
					 result = "1";
				}else {
					 result = "2";
				}
		 	}
		
		  }else {
			  result = "2";
		  }
		JSONObject jObject=new JSONObject();
		jObject.put("result", result);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(jObject.toString());
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
	@RequestMapping(value = "/sre-forapplication/get/{applicationId}", method = RequestMethod.GET)
	public String get(@PathVariable("applicationId") String applicationId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseEntity<SreForApplication> responseEntity = this.restTemplate.exchange(GET_URL + applicationId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreForApplication.class);
		int statusCode = responseEntity.getStatusCodeValue();
		logger.info("============远程返回  statusCode " + statusCode);
		SreForApplication pplication =  responseEntity.getBody();
		request.setAttribute("pplication", pplication);
		return "/stp/equipment/forapplication/application-view";
	}
	
	/**
	 * 详情列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sre-forapplication/listView")
	@ResponseBody
	public String listView(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {
		
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(VIEW_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============result" + result);
		return result.toString();
	}
}
