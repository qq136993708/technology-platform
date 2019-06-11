package com.pcitc.web.controller.equipment;

import java.text.SimpleDateFormat;
import java.util.Date;

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
import com.pcitc.web.common.BaseController;

@Controller
public class ManagementLedgerController extends BaseController {

	private static final String SELECT_URL = "http://pcitc-zuul/stp-proxy/sre-provider/Investmentrogress/management";
	private static final String MANA_URL = "http://pcitc-zuul/stp-proxy/sre-provider/mana/page";
	
	@RequestMapping(value = "/sre-mana/to-list")
	public String list(HttpServletRequest request, HttpServletResponse response) {
		String	parentUnitPathIds="";
		String unitPathIds =   sysUserInfo.getUnitPath();
		if(unitPathIds!=null && !unitPathIds.equals(""))
		{
			if(unitPathIds.length()>4)
			{
				parentUnitPathIds=unitPathIds.substring(0, unitPathIds.length()-4);
				
			}
		}
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SELECT_URL, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
		int count = responseEntity.getBody();
		Date data = new Date();
		String dateStr = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(data);
		dateStr = dateStr.substring(0, 4);
		request.setAttribute("dateStr", dateStr);
		request.setAttribute("count", count);
		request.setAttribute("parentUnitPathIds", parentUnitPathIds);
		return "/stp/equipment/managementledger/managementledger_list";
	}
	
	/**
	 * 列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sre-mana/list")
	@ResponseBody
	public String ajaxlist(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {
		
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(MANA_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============result" + result);
		return result.toString();
	}
}