package com.pcitc.web.controller.system;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.RequestProcessStatusEnum;
import com.pcitc.base.stp.equipment.SreEquipment;
import com.pcitc.base.stp.system.SysMeeting;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.web.common.BaseController;
@Controller
public class SysMeetingController extends BaseController {

	public  static final String GET_URL =    "http://pcitc-zuul/system-proxy/system-provider/sys_meeting/get/";
	private static final String PAGE_URL =   "http://pcitc-zuul/system-proxy/system-provider/sys_meeting/page";
	public  static final String ADD_URL =    "http://pcitc-zuul/system-proxy/system-provider/sys_meeting/add";
	public  static final String UPDATE_URL = "http://pcitc-zuul/system-proxy/system-provider/sys_meeting/update";
	private static final String DEL_URL =    "http://pcitc-zuul/system-proxy/system-provider/sys_meeting/delete/";
	
	
	@RequestMapping(value = "/sys_meeting/list")
	public String plan_audit_list(HttpServletRequest request, HttpServletResponse response) 
    {
    	return "/base/sys_meeting/list";
	}
    
    
    
    @RequestMapping(value = "/sys_meeting/list_data")
	@ResponseBody
	public String process_node_list_data(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response)
    {
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200)
		{
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============查询结果：" + result);
		return result.toString();
	}
    
    
    
    @RequestMapping(method = RequestMethod.GET, value = "/sys_meeting/add")
	public String add(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	SysMeeting sysMeeting = null;
    	String id = CommonUtil.getParameter(request, "id", "");
    	String meetingDoc= IdUtil.createFileIdByTime();
    	if(!id.equals(""))
    	{
    		ResponseEntity<SysMeeting> se = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SysMeeting.class);
    		sysMeeting = se.getBody();
    		meetingDoc=sysMeeting.getMeetingDoc();
    	}
    	request.setAttribute("meetingDoc", meetingDoc);
		request.setAttribute("sysMeeting", sysMeeting);
		request.setAttribute("id", id);
		return "/base/sys_meeting/add";
	}

	/**
	 * 保存-更新操作
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/sys_meeting/save")
	public String saveOrUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result resultsDate = new Result();
		String name = CommonUtil.getParameter(request, "name", "");
		String ext1 = CommonUtil.getParameter(request, "ext1", "");
		String ext2 = CommonUtil.getParameter(request, "ext2", "");
		String notes = CommonUtil.getParameter(request, "notes", "");
		String id = CommonUtil.getParameter(request, "id", "");
		String title = CommonUtil.getParameter(request, "title", "");
		String meetingPlace = CommonUtil.getParameter(request, "meetingPlace", "");
		String meetingDate = CommonUtil.getParameter(request, "meetingDate", "");
		String meetingDoc = CommonUtil.getParameter(request, "meetingDoc", "");
		SysMeeting sysMeeting = null;
		ResponseEntity<String> responseEntity = null;
		// 判断是新增还是修改
		if (id.equals("")) 
		{
			String idv = UUID.randomUUID().toString().replaceAll("-", "");
			sysMeeting = new SysMeeting();
			sysMeeting.setId(idv);
			sysMeeting.setCreateTime(new Date());
			System.out.println("---------------ext1:" + ext1 + " name=" + name + " ext2=" + ext2);
		} else {
			ResponseEntity<SysMeeting> se = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SysMeeting.class);
			sysMeeting = se.getBody();
		}
		sysMeeting.setNotes(notes);
		sysMeeting.setExt1(ext1);
		sysMeeting.setExt2(ext2);
		sysMeeting.setTitle(title);
		sysMeeting.setMeetingPlace(meetingPlace);
		sysMeeting.setMeetingDate(DateUtil.strToDate(meetingDate, DateUtil.FMT_SS));
		sysMeeting.setMeetingDoc(meetingDoc);
		// 判断是新增还是修改
		if (id.equals("")) {
			responseEntity = this.restTemplate.exchange(ADD_URL, HttpMethod.POST, new HttpEntity<SysMeeting>(sysMeeting, this.httpHeaders), String.class);

		} else {
			responseEntity = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SysMeeting>(sysMeeting, this.httpHeaders), String.class);
		}
		// 返回结果代码
		int statusCode = responseEntity.getStatusCodeValue();
		System.out.println(">>>>>>>>>>>>>>>>>>>返回  statusCode=" + statusCode);
		if (statusCode == 200) 
		{
			resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
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
	 * 删除
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sys_meeting/delete/{id}")
	public String delete(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(DEL_URL + id, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
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
	
	
	
	@RequestMapping(value = "/sys_meeting/get/{id}", method = RequestMethod.GET)
	public String get(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseEntity<SysMeeting> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SysMeeting.class);
		int statusCode = responseEntity.getStatusCodeValue();
		logger.info("============远程返回  statusCode " + statusCode);
		SysMeeting sysMeeting = responseEntity.getBody();
		request.setAttribute("sysMeeting", sysMeeting);
		return "/base/sys_meeting/view";
	}
	
	
}
