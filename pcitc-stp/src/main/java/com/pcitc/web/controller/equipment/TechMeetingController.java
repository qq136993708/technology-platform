package com.pcitc.web.controller.equipment;

import java.io.PrintWriter;
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
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Page;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.RequestProcessStatusEnum;
import com.pcitc.base.stp.equipment.SreTechMeeting;
import com.pcitc.base.system.SysUnit;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;

@Controller
@RequestMapping(value = "/sre-meeting")
public class TechMeetingController extends BaseController {

	/*
	 * 1、可以直接通过注册的服务名来访问，来实现访问和负载。不过如果用zuul的话， 要用zuul的服务名和实际访问的服务名一起
	 * 2、pplus本身是一个微服务，属于微服务之间的调用，可以直接用名称，不用ip.（注意启动类中的注解）
	 */

	private static final String PAGE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/meeting/page";
	private static final String ADD_URL = "http://pcitc-zuul/stp-proxy/sre-provider/meeting/add";
	private static final String UPDATE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/meeting/update";
	private static final String DEL_URL = "http://pcitc-zuul/stp-proxy/sre-provider/meeting/delete/";
	private static final String GET_URL = "http://pcitc-zuul/stp-proxy/sre-provider/meeting/get/";
	private static final String BATCH_DEL_URL = "http://pcitc-zuul/stp-proxy/sre-provider/meeting/batch-delete/";

	@RequestMapping(value = "/to-list")
	public String list(HttpServletRequest request, HttpServletResponse response) {
		return "/stp/equipment/meeting/meeting-list";
	}

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

	/**
	 * 选择装备
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/search-equipment")
	public String searchEquipment(HttpServletRequest request, HttpServletResponse response) {

		String name = CommonUtil.getParameter(request, "name", "");
		String equipmentIds = CommonUtil.getParameter(request, "equipmentIds", "");
		request.setAttribute("equipmentIds", equipmentIds);
		String iframeId = CommonUtil.getParameter(request, "iframeId", "");
		request.setAttribute("iframeId", iframeId);
		request.setAttribute("name", name);
		System.out.println(">>>>>>>>>>>>>>>>>>>  name  " + name + " equipmentIds=" + equipmentIds);
		int pageNo = CommonUtil.getParameterPageNo(request);
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("pageNo", pageNo);
		paramsMap.put("pageSize", 10);
		paramsMap.put("name", name);
		// paramsMap.put("equipmentIds", equipmentIds);
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		// 使用exchange请求接口
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		ResponseEntity<Page> responseEntity = restTemplate.exchange(PAGE_URL, HttpMethod.POST, entity, Page.class);

		int statusCode = responseEntity.getStatusCodeValue();
		logger.info("============exchange 远程返回  statusCode " + statusCode);
		if (statusCode == 200) {
			Page page = responseEntity.getBody();
			request.setAttribute("list", page.getRows());
			request.setAttribute("page", page);
		}
		request.setAttribute("backurl", CommonUtil.getRequestUrl(request));
		return "/stp/equipment/meeting/meeting-search";
	}

	/**
	 * 增加
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String equipmentId = CommonUtil.getParameter(request, "equipmentId", "");
		request.setAttribute("equipmentId", equipmentId);
		
		String meetingDoc= IdUtil.createFileIdByTime();
		request.setAttribute("meetingDoc", meetingDoc);

		return "/stp/equipment/meeting/meeting-add";
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
		String meetingPlace = CommonUtil.getParameter(request, "meetingPlace", "");
		String meetingContent = CommonUtil.getParameter(request, "meetingContent", "");
		String remark = CommonUtil.getParameter(request, "remark", "");
		String meetingEmcee = CommonUtil.getParameter(request, "meetingEmcee", "");
		String status = CommonUtil.getParameter(request, "status", "");
		String meetingDate = CommonUtil.getParameter(request, "meetingDate", "");
		String meetingId = CommonUtil.getParameter(request, "meetingId", "");
		String title = CommonUtil.getParameter(request, "title", "");
		String joinUsers = CommonUtil.getParameter(request, "joinUsers", "");
		String projectId = CommonUtil.getParameter(request, "projectId", "");
		String equipmentId = CommonUtil.getParameter(request, "equipmentId", "");
		
		String meetingDoc = CommonUtil.getParameter(request, "meetingDoc", "");
		
		
		String unitPathIds =   CommonUtil.getParameter(request, "unitPathIds",sysUserInfo.getUnitPath());
		String parentUnitPathIds ="";
		String parentUnitPathNames =  "";
		if(!unitPathIds.equals(""))
		{
			if(unitPathIds.length()>4)
			{
				parentUnitPathIds=unitPathIds.substring(0, unitPathIds.length()-4);
				SysUnit sysUnit=EquipmentUtils.getUnitByUnitPath(parentUnitPathIds, restTemplate, httpHeaders);
				if(sysUnit!=null)
				{
					parentUnitPathNames = sysUnit.getUnitName();
				}
			}
		}
		
		
		
		SreTechMeeting sreTechMeeting = null;
		if (meetingId.equals("")) 
		{
			sreTechMeeting = new SreTechMeeting();
			sreTechMeeting.setCreateDate(new Date());
			sreTechMeeting.setCreateUserId(sysUserInfo.getUserId());
			sreTechMeeting.setCreateUserName(sysUserInfo.getUserDisp());
			String id = UUID.randomUUID().toString().replaceAll("-", "");
			sreTechMeeting.setMeetingId(id);
			sreTechMeeting.setCreateDepartCode(sysUserInfo.getUnitCode());
			sreTechMeeting.setCreateDepartName(sysUserInfo.getUnitName());
		} else {
			ResponseEntity<SreTechMeeting> se = this.restTemplate.exchange(GET_URL + meetingId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreTechMeeting.class);
			sreTechMeeting = se.getBody();
		}
		
		sreTechMeeting.setParentUnitPathIds(parentUnitPathIds);
		sreTechMeeting.setParentUnitPathNames(parentUnitPathNames);
		sreTechMeeting.setMeetingDoc(meetingDoc);
		sreTechMeeting.setMeetingContent(meetingContent);
		sreTechMeeting.setMeetingPlace(meetingPlace);
		sreTechMeeting.setRemark(remark);
		sreTechMeeting.setMeetingDate(DateUtil.strToDate(meetingDate, DateUtil.FMT_SS));
		sreTechMeeting.setTitle(title);
		sreTechMeeting.setJoinUsers(joinUsers);
		sreTechMeeting.setEquitmentId(equipmentId); 
		sreTechMeeting.setProjectId(projectId);
		sreTechMeeting.setMeetingEmcee(meetingEmcee);
		sreTechMeeting.setStatus(status);
		// 判断是新增还是修改
		if (meetingId.equals("")) {
			ResponseEntity<String> responseEntity = this.restTemplate.exchange(ADD_URL, HttpMethod.POST, new HttpEntity<SreTechMeeting>(sreTechMeeting, this.httpHeaders), String.class);
			int statusCode = responseEntity.getStatusCodeValue();
			String id = responseEntity.getBody();
			// 返回结果代码
			if (statusCode == 200) {
				resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
			} else {
				resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
			}

		} else {
			ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SreTechMeeting>(sreTechMeeting, this.httpHeaders), Integer.class);
			int statusCode = responseEntity.getStatusCodeValue();
			Integer dataId = responseEntity.getBody();

			// 返回结果代码
			if (statusCode == 200) {
				resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
			} else {
				resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
			}
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
	 * 修改
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/update")
	public String update(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String meetingId = CommonUtil.getParameter(request, "meetingId", "");
		request.setAttribute("meetingId", meetingId);
		ResponseEntity<SreTechMeeting> responseEntity = this.restTemplate.exchange(GET_URL + meetingId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreTechMeeting.class);
		int statusCode = responseEntity.getStatusCodeValue();
		logger.info("============远程返回  statusCode " + statusCode);
		SreTechMeeting sreTechMeeting = responseEntity.getBody();
		request.setAttribute("sreTechMeeting", sreTechMeeting);
		request.setAttribute("meetingDoc", sreTechMeeting.getMeetingDoc());
		String backurl = CommonUtil.getParameter(request, "backurl", "");
		request.setAttribute("backurl", backurl);
		

		return "/stp/equipment/meeting/meeting-add";
	}

	/**
	 * 删除
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete/{id}")
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

	@RequestMapping(value = "/bacth-delete")
	public String deleteBatch(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result resultsDate = new Result();
		ResponseEntity<Integer> responseEntity = null;
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
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public String get(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseEntity<SreTechMeeting> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreTechMeeting.class);
		int statusCode = responseEntity.getStatusCodeValue();
		logger.info("============远程返回  statusCode " + statusCode);
		SreTechMeeting sreTechMeeting = responseEntity.getBody();
		request.setAttribute("sreTechMeeting", sreTechMeeting);
		return "/stp/equipment/meeting/meeting-view";
	}

}
