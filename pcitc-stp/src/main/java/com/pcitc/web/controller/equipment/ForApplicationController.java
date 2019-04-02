package com.pcitc.web.controller.equipment;

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
import com.pcitc.base.stp.equipment.SreEquipment;
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
		if(!unitPathIds.equals(""))
		{
			if(unitPathIds.length()>4)
			{
				parentUnitPathIds=unitPathIds.substring(0, unitPathIds.length()-4);
				
			}
		}
		request.setAttribute("parentUnitPathIds", parentUnitPathIds);
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
		request.setAttribute("attachmentDoc", attachmentDoc);
		request.setAttribute("applyDepartName", applyDepartName);
		request.setAttribute("applyDepartCode", applyDepartCode);
		request.setAttribute("firstApplyUser", firstApplyUser);
		
		List<SrePurchase>  purchaseList= CommonUtil.getPurchaseNameIDList(restTemplate, httpHeaders);
		request.setAttribute("purchaseList", purchaseList);
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
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/sre-forapplicatio/save")
	public String saveOrUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		return null;
	}
}
