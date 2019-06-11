/**
 * 
 * SysConfigController.java
 * Nishikino
 * 2018年8月20日
 * 
 */
package com.pcitc.web.controller.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import com.pcitc.base.util.DateUtils;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.socket.notice.MessageIndexSocket;

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
	
	@Autowired
	private MessageIndexSocket msgSocket;

	private static final String SYS_MESSAGE_PAGIN_URL = "http://pcitc-zuul/system-proxy/sysmessage-provider/message/message-pagin-list";
	private static final String SYS_MESSAGE_DETAIL_URL = "http://pcitc-zuul/system-proxy/sysmessage-provider/message/message-info";
	private static final String SYS_MESSAGE_READ_URL = "http://pcitc-zuul/system-proxy/sysmessage-provider/message/read-message-info";

	/**
	 * @author 初始化列表页面
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
	 * @author 检索最新未读消息
	 */
	@RequestMapping(value = "/message/get-newest-messages", method = RequestMethod.POST)
	@ResponseBody
	public Object getLastSysMessageList(@ModelAttribute("param") LayuiTableParam param,HttpServletRequest request, HttpServletResponse response) {
		param.getParam().put("userId", this.getUserProfile().getUserId());
		param.getParam().put("isRead", "0");//未读消息
		System.out.println(JSON.toJSONString(param));
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(SYS_MESSAGE_PAGIN_URL, HttpMethod.POST, entity, LayuiTableData.class);
		List<?> data = responseEntity.getBody().getData();
		List<Map<String,Object>> rsmap = new ArrayList<Map<String,Object>>();
		for(java.util.Iterator<?> iter = data.iterator();iter.hasNext();) {
			Map<String,Object> map = MyBeanUtils.java2Map(iter.next());
			map.put("ago", DateUtils.getAgoDesc(DateUtils.strToDate(map.get("createDate").toString(),DateUtils.FMT_SS)));
			rsmap.add(map);
		}
		System.out.println(JSON.toJSONString(rsmap));
		return rsmap;
	}
	/**
	 * @author 分页检索消息
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
	 * @author 获取消息
	 */
	@RequestMapping(value = "/message/message-info/{messageId}")
	@ResponseBody
	public Object getSysMessageInfo(@PathVariable("messageId") String messageId, HttpServletRequest request, HttpServletResponse response) {
		
		ResponseEntity<SysMessage> responseEntity = this.restTemplate.exchange(SYS_MESSAGE_DETAIL_URL, HttpMethod.POST, new HttpEntity<String>(messageId,this.httpHeaders), SysMessage.class);
		SysMessage msg = responseEntity.getBody();
		return msg;
	}
	/**
	 * @author 更新消息阅读信息
	 */
	@RequestMapping(value = "/message/read-message-info/{messageId}")
	@ResponseBody
	public Object updSysMessageInfo(@PathVariable("messageId") String messageId, HttpServletRequest request, HttpServletResponse response) {
		
		ResponseEntity<SysMessage> responseEntity = this.restTemplate.exchange(SYS_MESSAGE_READ_URL, HttpMethod.POST, new HttpEntity<String>(messageId,this.httpHeaders), SysMessage.class);
		SysMessage msg = responseEntity.getBody();
		if(msg != null) {
			//推送一条已读消息
			SysMessage msgInfo = new SysMessage();
			msgInfo.setUserId(this.getUserProfile().getUserId());
			msgSocket.sendToWeb(msgInfo);
		}
		return msg;
	}

}
