package com.pcitc.web.controller.equipment;

import java.io.PrintWriter;
import java.util.List;

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

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.equipment.SreEquipment;
import com.pcitc.base.stp.equipment.UnitField;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.web.common.BaseController;

@Controller
public class ForApplicationController extends BaseController {
	
	private static final String PAGE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/forapplication/page";
	private static final String DEL_URL = "http://pcitc-zuul/stp-proxy/sre-provider/forapplication/delete/";
	private static final String ADD_URL = "http://pcitc-zuul/stp-proxy/sre-provider/forapplication/add";
	
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
		
//		List<>  unitFieldList= CommonUtil.getUnitNameList(restTemplate, httpHeaders);
//		request.setAttribute("unitFieldList", unitFieldList);
		return "/stp/equipment/forapplication/application-add";
	}
}
