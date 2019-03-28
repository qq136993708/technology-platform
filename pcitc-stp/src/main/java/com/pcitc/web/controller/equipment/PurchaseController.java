package com.pcitc.web.controller.equipment;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.equipment.SreProject;
import com.pcitc.base.stp.equipment.UnitField;
import com.pcitc.base.system.SysUnit;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;

/*/
 * Created by WSL in 2019/3/26
 */

@Controller
public class PurchaseController extends BaseController{
	
	
	private static final String PAGE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/purchase/page";
	private static final String GET_URL = "http://pcitc-zuul/stp-proxy/sre-provider/purchase/get/";

	//跳转到采购申请页面
	@RequestMapping(value = "/sre_purchase/to-list")
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
		
		return "/stp/equipment/purchase/purchase-list";
	}
	
	/**
	 * 查询列表
	 * @param param
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sre_purchase/list")
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
	 * 增加
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sre_purchase/add")
	public String add(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		
		
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
		
		
		String createUserName=sysUserInfo.getUserDisp();
		String createUserId=sysUserInfo.getUserName();
		String documentDoc= IdUtil.createFileIdByTime();
		String beginYear=EquipmentUtils.getCurrrentYear();
		String endYear=String.valueOf(Integer.valueOf(beginYear).intValue()+1);
		String id = CommonUtil.getParameter(request, "id", "");
		request.setAttribute("id", id);
		if(!id.equals(""))
		{
			ResponseEntity<SreProject> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreProject.class);
			int statusCode = responseEntity.getStatusCodeValue();
		
			SreProject sreEquipment = responseEntity.getBody();
			request.setAttribute("sreProjectBasic", sreEquipment);
			
			leadUnitName = sreEquipment.getLeadUnitName();
			leadUnitCode = sreEquipment.getLeadUnitCode();
			createUserId= sreEquipment.getCreateUserId();
			documentDoc=sreEquipment.getDocumentDoc();
			beginYear		= sreEquipment.getBeginYear();
			endYear		= sreEquipment.getEndYear();
		}
		request.setAttribute("documentDoc", documentDoc);
		request.setAttribute("leadUnitName", leadUnitName);
		request.setAttribute("leadUnitCode", leadUnitCode);
		request.setAttribute("createUserId", createUserId);
		request.setAttribute("endYear", endYear);
		request.setAttribute("beginYear", beginYear);
		logger.info("============远程返回  beginYear " + beginYear);
		List<UnitField>  unitFieldList= CommonUtil.getUnitNameList(restTemplate, httpHeaders);
		request.setAttribute("unitFieldList", unitFieldList);
		
		
		
		
		
	
		
		return "/stp/equipment/purchase/purchase-add";
	}
}
