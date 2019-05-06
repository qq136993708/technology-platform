package com.pcitc.web.controller.equipment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pcitc.web.common.BaseController;

@Controller
public class ManagementLedgerController extends BaseController {

	private static final String SELECT_URL = "http://pcitc-zuul/stp-proxy/sre-provider/Investmentrogress/management";

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
}