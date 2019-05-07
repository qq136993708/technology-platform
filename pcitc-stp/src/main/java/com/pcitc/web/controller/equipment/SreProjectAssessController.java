package com.pcitc.web.controller.equipment;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.RequestProcessStatusEnum;
import com.pcitc.base.stp.equipment.SreProjectAssess;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.web.common.BaseController;
@Controller
@RequestMapping(value = "/sre_project_assess")
public class SreProjectAssessController extends BaseController{
	private static final String PROJECTPAGE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/sreProjectAssess/page";
	private static final String PAGE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/project_task/page";
	private static final String AUDIT_URL="http://pcitc-zuul/stp-proxy/sre-provider/sreProjectAssess/Assess";
	private static final String SUBMITAUDIT_URL="http://pcitc-zuul/stp-proxy/sre-provider/sreProjectAssess/submitAssess";
	private static final String GET_URL = "http://pcitc-zuul/stp-proxy/sre-provider/sreProjectAssess/get/";
	private static final String UPDATE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/sreProjectAssess/updateAssess";
	@RequestMapping(value = "/to_list")
	public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/stp/equipment/assess/project_taskac_list";
	}
	@RequestMapping(value = "/list")
	@ResponseBody
	public String ajaxlist(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response)
	{
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PROJECTPAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============result" + result);
		return result.toString();
	}
	@RequestMapping(value = "/task_list")
	public String tasklist(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return "/stp/equipment/assess/project_task_list";
	}
	
	@RequestMapping(value = "/notice_list")
	public String noticelist(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return "/stp/equipment/assess/project_tasknotice_list";
	}
	@RequestMapping(value = "/projectusers")
	public String projectusers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = CommonUtil.getParameter(request, "id", "");
		request.setAttribute("id", id);
		return "/stp/equipment/assess/project_task_users";
	}
	
	@RequestMapping(value = "/projectlist")
	@ResponseBody
	public String projectlist(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {
		
		JSONObject parmamss = JSONObject.parseObject(JSONObject.toJSONString(param));
		logger.info("============参数：" + parmamss.toString());
		//
		String applyDepartCode=sysUserInfo.getUnitCode();

		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============查询结果：" + result);
		return result.toString();
	}
	
	@RequestMapping(value = "/to_prlist")
	public String prlist(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<SysDictionary>  dicList= CommonUtil.getDictionaryByParentCode("ROOT_UNIVERSAL_LCZT", restTemplate, httpHeaders);
		request.setAttribute("dicList", dicList);
		return "/stp/equipment/assess/project_taskpr_list";
	}
	
	@RequestMapping(value = "/to_reportlist")
	public String reportlist(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return "/stp/equipment/assess/project_taskreport_list";
	}
	@RequestMapping(value = "/project_audit")
	public String audit(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    request.setAttribute("username",sysUserInfo.getUserName());
	    request.setAttribute("userDate",new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		return "/stp/equipment/assess/project_taskac_audit";
	}
	
	@RequestMapping(value = "/addAudit")
	@ResponseBody
	public String addAudit(HttpServletRequest request) throws Exception {
		ResponseEntity<String> responseEntity = null;
		String id = CommonUtil.getParameter(request, "id", "");
		String name = CommonUtil.getParameter(request, "name", "");
		String content = CommonUtil.getParameter(request, "content", "");
		SreProjectAssess s=new SreProjectAssess();
		s.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		s.setProjecttaskid(id);
		s.setProjecttask(name);
		s.setContent(content);
		s.setStatus("10");
		s.setCreateUserid(sysUserInfo.getUserId());
		s.setCreateUser(sysUserInfo.getUserName());
		s.setCreateDate(new Date());
		responseEntity = restTemplate.exchange(AUDIT_URL, HttpMethod.POST,new HttpEntity<SreProjectAssess>(s, this.httpHeaders),String.class);
		String success= "{}";
		String getbody=responseEntity.getBody();
	if(getbody.equals("success"))
	{
		 success ="{\"success\":\"success\"}";
	}
	else
	{
		success ="{\"success\":\"error\"}";
	}
		return success;
	}
	@RequestMapping(value = "/submitAudit")
	@ResponseBody
	public String submitAudit(HttpServletRequest request) throws Exception {
		ResponseEntity<String> responseEntity = null;
		String id = CommonUtil.getParameter(request, "id", "");
		String status = CommonUtil.getParameter(request, "status", "");
		SreProjectAssess record =new  SreProjectAssess();
		record.setId(id);
		record.setStatus(status);
		responseEntity = restTemplate.exchange(SUBMITAUDIT_URL, HttpMethod.POST,new HttpEntity<SreProjectAssess>(record, this.httpHeaders),String.class);
		String success= "{}";
		String getbody=responseEntity.getBody();
		if(getbody.equals("success"))
		{
			 success ="{\"success\":\"success\"}";
		}
		else
		{
			success ="{\"success\":\"error\"}";
		}
			return success;
		}
		
	  @RequestMapping(value = "/projecttaskpradd")
	    public String upFileDoc(HttpServletRequest request, HttpServletResponse response) throws Exception {



	        String id = CommonUtil.getParameter(request, "id", "");
	        request.setAttribute("id", id);
	        if(!id.equals(""))
	        {
	            ResponseEntity<SreProjectAssess> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreProjectAssess.class);
	            SreProjectAssess sreProjectAssess = responseEntity.getBody();
	            request.setAttribute("srePurchase", sreProjectAssess);
	            String documentDoc = sreProjectAssess.getDocumentdoc();
	            String docArriveGoods = sreProjectAssess.getDocumentdoctwo();
	            String stage = sreProjectAssess.getStatus();
	            if(stage.equals("20")){//合同系统对接 阶段
	                if(documentDoc==null || documentDoc.equals(""))
	                {
	                    documentDoc= IdUtil.createFileIdByTime();
	                }
	                request.setAttribute("documentDoc", documentDoc);
	            }else if(stage.equals("40")){
	                if(docArriveGoods==null || docArriveGoods.equals(""))
	                {
	                    docArriveGoods= IdUtil.createFileIdByTime();
	                }
	                request.setAttribute("docArriveGoods", docArriveGoods);
	            }
	            request.setAttribute("stage", stage);

	        }
	        return "/stp/equipment/assess/project_taskpr_add";
	    }
	  
	  @RequestMapping(value = "/updateFileDoc")
	    public String updateFileDoc(HttpServletRequest request, HttpServletResponse response) throws Exception {

	        Result resultsDate = new Result();
	        String id = CommonUtil.getParameter(request, "id", "");
	        String stage = CommonUtil.getParameter(request, "stage", "");
	        String documentDoc = CommonUtil.getParameter(request, "documentDoc", "");
	        String docArriveGoods = CommonUtil.getParameter(request, "docArriveGoods", "");
	        String resutl="";

	        int statusCodeValue = 0;
	        if(!id.equals(""))
	        {
	            if(stage.equals("20")){
	                ResponseEntity<SreProjectAssess> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreProjectAssess.class);
	                SreProjectAssess sreProjectAssess = responseEntity.getBody();
	                sreProjectAssess.setDocumentdoc(documentDoc);
	                ResponseEntity<String>  exchange = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SreProjectAssess>(sreProjectAssess, this.httpHeaders), String.class);
	                statusCodeValue = responseEntity.getStatusCodeValue();
	            }else if (stage.equals("40")){
	                ResponseEntity<SreProjectAssess> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreProjectAssess.class);
	                SreProjectAssess sreProjectAssess = responseEntity.getBody();
	                sreProjectAssess.setDocumentdoctwo(docArriveGoods);
	                ResponseEntity<String>  exchange = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SreProjectAssess>(sreProjectAssess, this.httpHeaders), String.class);
	                statusCodeValue = responseEntity.getStatusCodeValue();
	            }
	        }
	        if (statusCodeValue==200)
	        {
	            resultsDate.setSuccess(true);
	        } else
	        {
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
	  
	  
	    @RequestMapping(value = "/addUsers")
	    @ResponseBody
		public String addUsers(HttpServletRequest request) throws Exception {
	    	String id = CommonUtil.getParameter(request, "id", "");
			String usersid = CommonUtil.getParameter(request, "usersid", "");
			String informcontent = CommonUtil.getParameter(request, "informcontent", "");
			 ResponseEntity<SreProjectAssess> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreProjectAssess.class);
             SreProjectAssess sreProjectAssess = responseEntity.getBody();
             sreProjectAssess.setId(id);
             sreProjectAssess.setUsersid(usersid);
             sreProjectAssess.setInformcontent(informcontent);
             sreProjectAssess.setTestdate(new Date());
             sreProjectAssess.setInformuser(sysUserInfo.getUserId());
             ResponseEntity<String>  exchange = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SreProjectAssess>(sreProjectAssess, this.httpHeaders), String.class);
           return "";	
	       }
}
