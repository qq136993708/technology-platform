/**
 * 
 * SysConfigController.java
 * Nishikino
 * 2018年8月20日
 * 
 */
package com.pcitc.web.controller.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysMessage;
import com.pcitc.base.util.IdUtil;
import com.pcitc.web.common.BaseController;

/**
 * @description : TODO
 * @author : Nishikino
 * @date : 2018年8月20日 下午3:35:34
 */
@Controller
public class SysMessageController extends BaseController {

	@Autowired
	private HttpHeaders httpHeaders;

	@Autowired
	private RestTemplate restTemplate;

	private static final String SYS_MESSAGE_PAGIN_URL = "http://pcitc-zuul/system-proxy/sysmessage-provider/message/message-pagin-list";
	private static final String SYS_MESSAGE_DETAIL_URL = "http://pcitc-zuul/system-proxy/sysmessage-provider/message/message-info";

	/**
	 * @author 初始化详情页面
	 */
	@RequestMapping(value = "/message/sys_message_list")
	public String toSysMessageList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return "/stp/system/sys_message_list";
	}

	/**
	 * @author 初始化详情页面
	 */
	@RequestMapping(value = "/message/sys_message_detail")
	public String toSysMessageDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setAttribute("messageId", request.getParameter("messageId"));
		return "/stp/system/sys_message_detail";
	}

	/**
	 * @author Nishikino 查询所有生效配置
	 */
	@RequestMapping(value = "/message/message-pagin-list", method = RequestMethod.POST)
	@ResponseBody
	public Object getSysMessageListForTable(@ModelAttribute("param") LayuiTableParam param) {
		param.getParam().put("userId", this.getUserProfile().getUserId());
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(SYS_MESSAGE_PAGIN_URL, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();

		return JSON.toJSON(retJson).toString();
	}
	

	/**
	 * @author Nishikino 根据id获取配置數據
	 */
	@RequestMapping(value = "/message/message-info/{messageId}")
	@ResponseBody
	public Object getSysMessageInfo(@PathVariable("messageId") String messageId, HttpServletRequest request, HttpServletResponse response) {
		
		ResponseEntity<SysMessage> responseEntity = this.restTemplate.exchange(SYS_MESSAGE_DETAIL_URL, HttpMethod.POST, new HttpEntity<String>(messageId,this.httpHeaders), SysMessage.class);
		SysMessage msg = responseEntity.getBody();
		return msg;
	}


}
