package com.pcitc.web.controller.equipment;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.RequestProcessStatusEnum;
import com.pcitc.base.stp.equipment.FindView;
import com.pcitc.base.stp.equipment.SreProjectAudit;
import com.pcitc.base.stp.equipment.SrePurchase;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.web.common.BaseController;
@Controller
@RequestMapping(value = "/sre_project_taskac")
public class ProjectTaskAcController extends BaseController{
	private static final String PROJECTPAGE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/sreProjectTaskAc/page";
	private static final String PAGE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/project_basic/pagebyaccept";
	private static final String AUDIT_URL="http://pcitc-zuul/stp-proxy/sre-provider/project_task/audit";
	private static final String SUBMITAUDIT_URL="http://pcitc-zuul/stp-proxy/sre-provider/sreProjectTaskAc/submitaudit";
	private static final String GET_URL = "http://pcitc-zuul/stp-proxy/sre-provider/sreProjectTaskAc/get/";
	private static final String UPDATE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/sreProjectTaskAc/updateAudit";
	private static final String ERPPAGE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/project_taskByErpnum/page";

	private static final String DEL_URL = "http://pcitc-zuul/stp-proxy/sre-provider/sreProjectTaskAc/delete/";

	@RequestMapping(value = "/to_list")
	public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/stp/equipment/taskac/project_taskac_list";
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
		
		return "/stp/equipment/taskac/project_task_list";
	}
	
	@RequestMapping(value = "/notice_list")
	public String noticelist(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return "/stp/equipment/taskac/project_tasknotice_list";
	}
	@RequestMapping(value = "/projectusers")
	public String projectusers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = CommonUtil.getParameter(request, "id", "");
		request.setAttribute("id", id);
		return "/stp/equipment/taskac/project_task_users";
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
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(ERPPAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
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
		return "/stp/equipment/taskac/project_taskpr_list";
	}
	
	@RequestMapping(value = "/to_reportlist")
	public String reportlist(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return "/stp/equipment/taskac/project_taskreport_list";
	}
	@RequestMapping(value = "/project_audit")
	public String audit(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    request.setAttribute("username",sysUserInfo.getUserDisp());
	    request.setAttribute("userDate",new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		return "/stp/equipment/taskac/project_taskac_audit";
	}
	
	@RequestMapping(value = "/addAudit")
	@ResponseBody
	public String addAudit(HttpServletRequest request) throws Exception {
		ResponseEntity<String> responseEntity = null;
		String id = CommonUtil.getParameter(request, "id", "");
		String name = CommonUtil.getParameter(request, "name", "");
		String content = CommonUtil.getParameter(request, "content", "");
		SreProjectAudit s=new SreProjectAudit();
		s.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		s.setProjecttaskid(id);
		s.setProjecttask(name);
		s.setContent(content);
		s.setStatus("20");
		s.setCreateUserid(sysUserInfo.getUserId());
		s.setCreateUser(sysUserInfo.getUserDisp());
		s.setCreateDate(new Date());
		responseEntity = restTemplate.exchange(AUDIT_URL, HttpMethod.POST,new HttpEntity<SreProjectAudit>(s, this.httpHeaders),String.class);
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
		SreProjectAudit record =new  SreProjectAudit();
		record.setId(id);
		record.setStatus(status);
		responseEntity = restTemplate.exchange(SUBMITAUDIT_URL, HttpMethod.POST,new HttpEntity<SreProjectAudit>(record, this.httpHeaders),String.class);
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
            String uploadState = CommonUtil.getParameter(request, "uploadState", "");

          request.setAttribute("id", id);
          request.setAttribute("uploadState", uploadState);
	        if(!id.equals(""))
	        {
	            ResponseEntity<SreProjectAudit> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreProjectAudit.class);
	            SreProjectAudit sreProjectAudit = responseEntity.getBody();
	            request.setAttribute("srePurchase", sreProjectAudit);
	            String documentDoc = sreProjectAudit.getDocumentdoc();
	            String docArriveGoods = sreProjectAudit.getDocumentdoctwo();
	            String stage = sreProjectAudit.getStatus();
	            if(uploadState.equals("1")|| uploadState.equals("3")){//验收准备材料
	                if(documentDoc==null || documentDoc.equals(""))
	                {
	                    documentDoc= IdUtil.createFileIdByTime();
	                }
	                request.setAttribute("documentDoc", documentDoc);
	            }else if(uploadState.equals("2")|| uploadState.equals("4")){
	                if(docArriveGoods==null || docArriveGoods.equals(""))
	                {
	                    docArriveGoods= IdUtil.createFileIdByTime();
	                }
	                request.setAttribute("docArriveGoods", docArriveGoods);
	            }
	            request.setAttribute("stage", stage);

	        }
	        return "/stp/equipment/taskac/project_taskpr_add";
	    }
	  
	  @RequestMapping(value = "/updateFileDoc")
	    public String updateFileDoc(HttpServletRequest request, HttpServletResponse response) throws Exception {

	        Result resultsDate = new Result();
	        String id = CommonUtil.getParameter(request, "id", "");
	        String stage = CommonUtil.getParameter(request, "stage", "");
	        String documentDoc = CommonUtil.getParameter(request, "documentDoc", "");
	        String docArriveGoods = CommonUtil.getParameter(request, "docArriveGoods", "");

          String uploadState = CommonUtil.getParameter(request, "uploadState", "");

          String resutl="";

	        int statusCodeValue = 0;
	        if(!id.equals(""))
	        {
	            if(uploadState.equals("1")){
	                ResponseEntity<SreProjectAudit> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreProjectAudit.class);
	                SreProjectAudit sreProjectAudit = responseEntity.getBody();
	                sreProjectAudit.setDocumentdoc(documentDoc);
	                ResponseEntity<String>  exchange = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SreProjectAudit>(sreProjectAudit, this.httpHeaders), String.class);
	                statusCodeValue = responseEntity.getStatusCodeValue();
	            }else if (uploadState.equals("2")){
	                ResponseEntity<SreProjectAudit> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreProjectAudit.class);
	                SreProjectAudit sreProjectAudit = responseEntity.getBody();
	                sreProjectAudit.setDocumentdoctwo(docArriveGoods);
	                ResponseEntity<String>  exchange = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SreProjectAudit>(sreProjectAudit, this.httpHeaders), String.class);
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
		public Result addUsers(HttpServletRequest request) throws Exception {
			Result resultsDate = new Result();

			String id = CommonUtil.getParameter(request, "id", "");
			String usersid = CommonUtil.getParameter(request, "usersid", "");
			String informcontent = CommonUtil.getParameter(request, "informcontent", "");
			ResponseEntity<SreProjectAudit> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreProjectAudit.class);
			SreProjectAudit sreProjectAudit = responseEntity.getBody();
			sreProjectAudit.setId(id);
			sreProjectAudit.setUsersid(usersid);
			sreProjectAudit.setInformcontent(informcontent);
			sreProjectAudit.setTestdate(new Date());
			sreProjectAudit.setInformuser(sysUserInfo.getUserId());
			sreProjectAudit.setStatus("40");
			ResponseEntity<String>  exchange = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SreProjectAudit>(sreProjectAudit, this.httpHeaders), String.class);

			// 返回结果代码
			int statusCode = exchange.getStatusCodeValue();
			if (statusCode == 200) {

				resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
			} else
			{
				resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
			}

			return resultsDate;
		}

	/**
	 * 根据id删除
	 * @param id
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable("id") String id, HttpServletResponse response)throws Exception{
		Result resultsDate = new Result();
        ResponseEntity<Integer> exchange =null;
		if(StringUtils.isNotBlank(id)){
				exchange = this.restTemplate.exchange(DEL_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), Integer.class);

		}
        int statusCode = exchange.getStatusCodeValue();
        int status = exchange.getBody();
        logger.info("============远程返回  statusCode " + statusCode + "  status=" + status);
        if (exchange.getBody() > 0) {
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
}
