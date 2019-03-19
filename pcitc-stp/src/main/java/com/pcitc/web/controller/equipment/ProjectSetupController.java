package com.pcitc.web.controller.equipment;

import java.io.File;
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
import org.springframework.http.HttpHeaders;
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
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.RequestProcessStatusEnum;
import com.pcitc.base.stp.equipment.SreProject;
import com.pcitc.base.stp.equipment.SreProjectSetup;
import com.pcitc.base.stp.equipment.SreProjectTask;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CodeUtil;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.workflow.Constants;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;
import com.pcitc.web.utils.WordUtil;

@Controller
@RequestMapping(value = "/sre_project_setup")
public class ProjectSetupController extends BaseController {


	private static final String PAGE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/project_setup/page";
	private static final String ADD_URL = "http://pcitc-zuul/stp-proxy/sre-provider/project_setup/add";
	private static final String UPDATE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/project_setup/update";
	private static final String DEL_URL = "http://pcitc-zuul/stp-proxy/sre-provider/project_setup/delete/";
	private static final String GET_URL = "http://pcitc-zuul/stp-proxy/sre-provider/project_setup/get/";
	private static final String GET_PROJECT_URL = "http://pcitc-zuul/stp-proxy/sre-provider/project_basic/get/";

	
	
	private static final String GET_URL_TASK = "http://pcitc-zuul/stp-proxy/sre-provider/project_task/get/";
	private static final String GET_URL_PROJECT = "http://pcitc-zuul/stp-proxy/sre-provider/project_basic/get/";
	private static final String UPDATE_URL_TASK = "http://pcitc-zuul/stp-proxy/sre-provider/project_task/update";
	private static final String UPDATE_URL_PROJECT = "http://pcitc-zuul/stp-proxy/sre-provider/project_basic/update";
	
	

	@RequestMapping(value = "/to_list")
	public String list(HttpServletRequest request, HttpServletResponse response) {
		return "/stp/equipment/setup_report/setup_report_list";
	}

	@RequestMapping(value = "/list")
	@ResponseBody
	public String ajaxlist(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {
		
		JSONObject parmamss = JSONObject.parseObject(JSONObject.toJSONString(param));
		logger.info("============参数：" + parmamss.toString());
		
		
		
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

	/**
	 * 增加
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public String add(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		
		
		String leadUnitName = sysUserInfo.getUnitName();
		String leadUnitCode = sysUserInfo.getUnitCode();
		String createUserName=sysUserInfo.getUserDisp();
		String createUserId=sysUserInfo.getUserName();
		String documentDoc= IdUtil.createFileIdByTime();
		
		String taskId = CommonUtil.getParameter(request, "taskId", "");
		request.setAttribute("taskId", taskId);
		
		String setupId = CommonUtil.getParameter(request, "setupId", "");
		request.setAttribute("setupId", setupId);
		
		String topicId = CommonUtil.getParameter(request, "topicId", "");
		request.setAttribute("topicId", topicId);
		
		if(!topicId.equals(""))
		{
			SreProject sreProject=EquipmentUtils.getSreProject(topicId, restTemplate, httpHeaders);
			request.setAttribute("sreProject", sreProject);
		}
		if(!setupId.equals(""))
		{
			ResponseEntity<SreProjectSetup> responseEntity = this.restTemplate.exchange(GET_URL + setupId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreProjectSetup.class);
			int statusCode = responseEntity.getStatusCodeValue();
		
			SreProjectSetup sreProjectSetup = responseEntity.getBody();
			request.setAttribute("sreProjectSetup", sreProjectSetup);
			topicId=sreProjectSetup.getTopicId();
			if(!topicId.equals(""))
			{
				SreProject sreProject=EquipmentUtils.getSreProject(topicId, restTemplate, httpHeaders);
				request.setAttribute("sreProject", sreProject);
			}
		}
		request.setAttribute("documentDoc", documentDoc);
		request.setAttribute("leadUnitName", leadUnitName);
		request.setAttribute("leadUnitCode", leadUnitCode);
		request.setAttribute("createUserId", createUserId);
		List<SysDictionary>  dicList= CommonUtil.getDictionaryByParentCode("ROOT_ZBGL_YTJYSDNR", restTemplate, httpHeaders);
		request.setAttribute("dicList", dicList);
		return "/stp/equipment/setup_report/setup_report_add";
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
		// 业务ID
		String setupId = CommonUtil.getParameter(request, "setupId", "");
		String taskId = CommonUtil.getParameter(request, "taskId", "");
		// 流程状态-是保存还是提交
		String auditStatus = CommonUtil.getParameter(request, "auditStatus", Constant.AUDIT_STATUS_DRAFT);
		String budgetTable = CommonUtil.getParameter(request, "budgetTable", "");
		String notes = CommonUtil.getParameter(request, "notes", "");
		String contractNum = CommonUtil.getParameter(request, "contractNum", "");
		String topicId = CommonUtil.getParameter(request, "topicId", "");
		
		String setupReasons = CommonUtil.getParameter(request, "setupReasons", "");
		String mainTable = CommonUtil.getParameter(request, "mainTable", "");
		String facilities = CommonUtil.getParameter(request, "facilities", "");
		String projectProgress = CommonUtil.getParameter(request, "projectProgress", "");
		String userEffect = CommonUtil.getParameter(request, "userEffect", "");
		String sourcesTable = CommonUtil.getParameter(request, "sourcesTable", "");
		String beginProjectMonth = CommonUtil.getParameter(request, "beginProjectMonth", "");
		String endProjectMonth = CommonUtil.getParameter(request, "endProjectMonth", "");
		
		
		StringBuffer taskCheckContents = new StringBuffer();
		String arr[]=request.getParameterValues("taskCheckContents");
		if(arr!=null && arr.length>0)
		{
			for(int i=0;i<arr.length;i++)
			{
				if(i>0)
				{
					taskCheckContents.append(",");
				}
				taskCheckContents.append(arr[i]);
			}
		}
		SreProjectSetup setup = null;
		ResponseEntity<String> responseEntity = null;
		
		// 判断是新增还是修改
		if (setupId.equals("")) 
		{
			setup = new SreProjectSetup();
			setup.setCreateDate(new Date());
			setup.setCreateUserId(sysUserInfo.getUserId());
			setup.setCreateUserName(sysUserInfo.getUserDisp());
			//String code = CommonUtil.getTableCode("XTBM_0032", restTemplate, httpHeaders);
			String idv = UUID.randomUUID().toString().replaceAll("-", "");
			setup.setSetupId(idv); 
			setup.setAuditStatus(auditStatus);
		} else 
		{
			ResponseEntity<SreProjectSetup> se = this.restTemplate.exchange(GET_URL + setupId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreProjectSetup.class);
			setup = se.getBody();
		}
		// 流程状态
		setup.setAuditStatus(auditStatus);
		SreProject sreProject=EquipmentUtils.getSreProject(topicId, restTemplate, httpHeaders);
		
		if(sreProject!=null)
		{
			setup.setTopicName(sreProject.getName());
			setup.setJoinUnitCode(sreProject.getJoinUnitCode());
			setup.setJoinUnitName(sreProject.getJoinUnitName());
			setup.setLeadUnitCode(sreProject.getLeadUnitCode());
			setup.setLeadUnitName(sreProject.getLeadUnitName());
			setup.setProjectMoney(sreProject.getProjectMoney());
			setup.setFundsTable(sreProject.getYearFeeStr());
			setup.setYearFeeStrJoinUnit(sreProject.getYearFeeStrJoinUnit());
			setup.setBelongDepartmentCode(sreProject.getBelongDepartmentCode());
			setup.setBelongDepartmentName(sreProject.getBelongDepartmentName());
			setup.setProfessionalDepartCode(sreProject.getProfessionalDepartCode());
			setup.setProfessionalDepartName(sreProject.getProfessionalDepartName());
			setup.setSetupYear(sreProject.getSetupYear());
			
		}
		setup.setTaskId(taskId);
		setup.setTopicId(topicId); 
		setup.setContractNum(contractNum);
		setup.setBudgetTable(budgetTable);
		setup.setContractNum(contractNum);
		setup.setFacilities(facilities);
		setup.setNotes(notes);
		setup.setSetupReasons(setupReasons);
		setup.setMainTable(mainTable);
		setup.setProjectProgress(projectProgress);
		setup.setUserEffect(userEffect);
		setup.setSourcesTable(sourcesTable);
		setup.setApplyUnitCode(sysUserInfo.getUnitCode());
		setup.setApplyUnitName(sysUserInfo.getUnitName());
		setup.setBeginProjectMonth(beginProjectMonth);
		setup.setEndProjectMonth(endProjectMonth);
		
		
		// 判断是新增还是修改
		if (setupId.equals("")) 
		{
			responseEntity = this.restTemplate.exchange(ADD_URL, HttpMethod.POST, new HttpEntity<SreProjectSetup>(setup, this.httpHeaders), String.class);

		} else {
			responseEntity = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SreProjectSetup>(setup, this.httpHeaders), String.class);
		}
		// 返回结果代码
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200)
		{
			
			SreProjectTask sreProjectTask=	EquipmentUtils.getSreProjectTask(taskId, restTemplate, httpHeaders);
			sreProjectTask.setSetupId(setup.getSetupId());
			EquipmentUtils.updateSreProjectTask(sreProjectTask, restTemplate, httpHeaders);
			resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
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

	

	
	/**
	 * 详情
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public String get(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		ResponseEntity<SreProjectSetup> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreProjectSetup.class);
		int statusCode = responseEntity.getStatusCodeValue();
		logger.info("============远程返回  statusCode " + statusCode);
		SreProjectSetup SreProjectSetup = responseEntity.getBody();
		request.setAttribute("SreProjectSetup", SreProjectSetup);
		
		return "/stp/equipment/setup_report/setup_report_view";
	}
	
	
	
	@RequestMapping(value = "/createWord/{id}", method = RequestMethod.GET)
	public String createWordv(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		Result resultsDate = new Result();
		String fileName="";//createWord(id);
		if (!fileName.equals("")) {
			resultsDate = new Result(true);
		} else {
			resultsDate = new Result(false, "生成文件失败！");
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		out.println(ob.toString());
		out.flush();
		out.close();
		return null;
	}
	
	
	/*
	//生成word文档
	private String  createWord(String id)
	{
		
		String  resutl="";
		// 文件路径
		String filePath = "D://doc";
				
		// 文件名称
		String fileName;
		try {
			SreProjectSetup SreProjectSetup=this.getSreProjectSetup(id);
			String taskCheckContents=SreProjectSetup.getTaskCheckContents();
			SreProject sreProject=null;
			String projectId=SreProjectSetup.getTopicId();
			if(!projectId.equals(""))
			{
				sreProject=getSreProject(projectId);
			}
			
			Map<String, Object> dataMap = new HashMap<String, Object>();
			*//** 组装数据 *//*
			dataMap.put("name", sreProject.getName());//项目名称
			dataMap.put("leadUnitName", sreProject.getLeadUnitName());//乙方
			dataMap.put("taskMainTaskContent", SreProjectSetup.getTaskMainTaskContent());//项目目标
			
			//项目内容和主要图表
			Float hj_tc=0f;
			List<Map<String, Object>> taskContentList = new ArrayList<Map<String, Object>>();
			String taskContentStr=SreProjectSetup.getTaskContent();
			String taskContent_arr[]=taskContentStr.split("\\|");
			if(taskContent_arr!=null && taskContent_arr.length>0)
			{
			   for(int i=0;i<taskContent_arr.length;i++)
			   {
				   String str=taskContent_arr[i];
				   if(str!=null && !str.equals(""))
				   {
					   String temp[]=str.split("#");
					   System.out.println("----length--"+temp.length);
					   Map<String, Object> map = new HashMap<String, Object>();
					   String taskContent1=temp[0].trim();
					   String taskContent2=temp[1].trim();
					   String taskContent3=temp[2].trim();
					   String taskContent4=temp[3].trim();
					   hj_tc=hj_tc.floatValue()+Float.valueOf(taskContent4.trim()).floatValue();
					   String taskContent5=temp[4];
					   map.put("taskc1", taskContent1);
					   map.put("taskc2", taskContent2);
					   map.put("taskc3", taskContent3);
					   map.put("taskc4", taskContent4);
					   map.put("taskc5", taskContent5);
					   taskContentList.add(map);
					   
				   }
			   }
			}
			dataMap.put("taskContentList", taskContentList);
			int taskContentListCount=taskContentList.size();
			dataMap.put("taskContentListCount", taskContentListCount);//项目内容和主要图表-数量
			dataMap.put("hj_tc", hj_tc);//项目内容和主要图表-经费合计
			JSONArray taskContentList_jSONArray= JSONArray.parseArray(JSON.toJSONString(taskContentList));
			System.out.println("---------项目内容和主要图表    源: "+taskContentStr);
			System.out.println("---------项目内容和主要图表 FTL: "+taskContentList_jSONArray.toString());
			
			//计划进度和考核目标
			List<Map<String, Object>> taskAssessmentList = new ArrayList<Map<String, Object>>();
			String taskAssessmenStr=SreProjectSetup.getTaskAssessmentContent();
			String taskAssessmenStr_arr[]=taskAssessmenStr.split("\\|");//多行
			if(taskAssessmenStr_arr!=null && taskAssessmenStr_arr.length>0)
			{
			   for(int i=0;i<taskAssessmenStr_arr.length;i++)
			   {
				   String str=taskAssessmenStr_arr[i];
				   if(str!=null && !str.equals(""))
				   {
					   String temp[]=str.split("#");
					   Map<String, Object> map = new HashMap<String, Object>();
					   String taskContent1=temp[0].trim();
					   String taskContent2=temp[1].trim();
					   String taskContent3=temp[2].trim();
					   map.put("ta1", taskContent1);
					   map.put("ta2", taskContent2);
					   map.put("ta3", taskContent3);
					   taskAssessmentList.add(map);
					   
				   }
			   }
			}
			dataMap.put("taskAssessmentList", taskAssessmentList);
			System.out.println("---------计划进度和考核目标    源: "+taskAssessmenStr);
			JSONArray taskAssessmentList_jSONArray= JSONArray.parseArray(JSON.toJSONString(taskAssessmentList));
			System.out.println("---------计划进度和考核目标 FTL: "+taskAssessmentList_jSONArray.toString());
			
			//应提交验收的内容
			List<Map<String, Object>> taskCheckContentsList = new ArrayList<Map<String, Object>>();
			List<SysDictionary>  dicList= CommonUtil.getDictionaryByParentCode("ROOT_ZBGL_YTJYSDNR", restTemplate, httpHeaders);
			JSONArray jSONArray= JSONArray.parseArray(JSON.toJSONString(dicList));
			List<SysDictionary> list = JSONObject.parseArray(jSONArray.toJSONString(), SysDictionary.class);
			if(list!=null && list.size()>0)
			{
				
				System.out.println("----------应提交验收的内容: "+jSONArray.toString());
				for(int i=0;i<list.size();i++)
				{
					 SysDictionary  sysDictionary=list.get(i);
					 String code=sysDictionary.getCode();
					 Map<String, Object> map = new HashMap<String, Object>();
					 map.put("tct1", i+1);
					 map.put("tct2", sysDictionary.getName());
					 String tct3="□";
					 String str_arr[]=taskCheckContents.split(",");
					 if(str_arr!=null)
					 {
						 for(int j=0;j<str_arr.length;j++)
						 {
							 String temp_code=str_arr[j];
							 if(temp_code.equals(code))
							 {
								 tct3="√";
							 }
						 }
					 }
					 map.put("tct3",tct3);
					 taskCheckContentsList.add(map);
				}
			}
			dataMap.put("taskCheckContentsList", taskCheckContentsList);
			
			System.out.println("---------应提交验收的内容    源: "+taskCheckContents);
			JSONArray taskCheckContentsList_jSONArray= JSONArray.parseArray(JSON.toJSONString(taskCheckContentsList));
			System.out.println("---------应提交验收的内容  FTL: "+taskCheckContentsList_jSONArray.toString());
			
			
			
			//资金概算表
			List<Map<String, Object>> budgetTableStrList_zb = new ArrayList<Map<String, Object>>();
			List<Map<String, Object>> budgetTableStrList_fy= new ArrayList<Map<String, Object>>();
			String budgetTableStr=SreProjectSetup.getBudgetTable();
			String budgetTableStrList_arr[]=budgetTableStr.split("\\|");//多行
			Float budgetTable_hj=0f;
			if(budgetTableStrList_arr!=null && budgetTableStrList_arr.length>0)
			{
			   for(int i=0;i<budgetTableStrList_arr.length;i++)
			   {
				   String str=budgetTableStrList_arr[i];
				   if(str!=null && !str.equals(""))
				   {
					   String temp[]=str.split("#");
					   Map<String, Object> map = new HashMap<String, Object>();
					   String content1=temp[0];
					   
					   String zj1=temp[1].trim();
					   String zj2=temp[2].trim();
					   String zj3=temp[3].trim();
					   String zj4=temp[4].trim();
					   map.put("zj1", zj1);
					   map.put("zj2", zj2);
					   map.put("zj3", zj3);
					   map.put("zj4", zj4);
					   Float fp3faot= Float.parseFloat(zj3);
					   budgetTable_hj=budgetTable_hj.floatValue()+fp3faot.floatValue();
					  
					   if(content1.equals("资本性"))
					   {
						   budgetTableStrList_zb.add(map);
					   }
					   if(content1.equals("费用性"))
					   {
						   budgetTableStrList_fy.add(map);
					   }
				   }
			   }
			}
			dataMap.put("budgetTableStrList_zb", budgetTableStrList_zb);
			dataMap.put("budgetTableStrList_fy", budgetTableStrList_fy);
			dataMap.put("budgetTable_hj", budgetTable_hj);
			
			System.out.println("---------资金概算表----  源: "+budgetTableStr);
			JSONArray budgetTableStrList_zb_jSONArray= JSONArray.parseArray(JSON.toJSONString(budgetTableStrList_zb));
			System.out.println("---------资金概算表--资本性  FTL: "+budgetTableStrList_zb_jSONArray.toString());
			JSONArray budgetTableStrList_fy_jSONArray= JSONArray.parseArray(JSON.toJSONString(budgetTableStrList_fy));
			System.out.println("---------资金概算表--费用性   FTL: "+budgetTableStrList_fy_jSONArray.toString());
			
			
			///预计资金来源表
			List<Map<String, Object>> fundsSourcesTableList = new ArrayList<Map<String, Object>>();
			String fundsSourcesTableStr=SreProjectSetup.getFundsSourcesTable();
			String fundsSourcesTableStr_arr[]=fundsSourcesTableStr.split("\\|");//多行
			if(fundsSourcesTableStr_arr!=null && fundsSourcesTableStr_arr.length>0)
			{
			   for(int i=0;i<fundsSourcesTableStr_arr.length;i++)
			   {
				   String str=fundsSourcesTableStr_arr[i];
				   if(str!=null && !str.equals(""))
				   {
					   String temp[]=str.split("#");
					   Map<String, Object> map = new HashMap<String, Object>();
					   String taskContent1=temp[0].trim();
					   String taskContent2=temp[1].trim();
					   String taskContent3=temp[2].trim();
					   String taskContent4=temp[3].trim();
					   String taskContent5=temp[4].trim();
					  // String taskContent6=temp[5];
					   
					   map.put("ft1", taskContent1);
					   map.put("ft2", taskContent2);
					   map.put("ft3", taskContent3);
					   map.put("ft4", taskContent4);
					   map.put("ft5", taskContent5);
					  // map.put("ft6", taskContent6);
					   Float ft6=Float.parseFloat(taskContent2)+Float.parseFloat(taskContent3)+Float.parseFloat(taskContent4)+Float.parseFloat(taskContent5);
					   map.put("ft6", ft6);
					   fundsSourcesTableList.add(map);
					   
				   }
			   }
			}
			dataMap.put("fundsSourcesTableList", fundsSourcesTableList);
			
			
			System.out.println("---------预计资金来源表 （源）: "+fundsSourcesTableStr);
			JSONArray fundsSourcesTableList_jSONArray= JSONArray.parseArray(JSON.toJSONString(fundsSourcesTableList));
			System.out.println("---------预计资金来源表 （FTL） : "+fundsSourcesTableList_jSONArray.toString());
			
			
			
			
			//项目资金安排
			List<Map<String, Object>> projectFundsTableList = new ArrayList<Map<String, Object>>();
			String projectFundsTableStr=SreProjectSetup.getProjectFundsTable();
			String projectFundsTableStr_arr[]=projectFundsTableStr.split("#");//多行
			double hj_pt2=0l;
			double hj_pt3=0l;
			double hj_pt4=0l;
			if(projectFundsTableStr_arr!=null && projectFundsTableStr_arr.length>0)
			{
			   for(int i=0;i<projectFundsTableStr_arr.length;i++)
			   {
				   String str=projectFundsTableStr_arr[i];
				   System.out.println("----------项目资金安排--str: "+str);
				   if(str!=null && !str.equals(""))
				   {
					   String temp[]=str.split(",");
					   Map<String, Object> map = new HashMap<String, Object>();
					   String pt1=temp[0];
					   String pt2=temp[1].trim();
					   double pt2_double= Double.valueOf(pt2).doubleValue();
					   hj_pt2=hj_pt2+pt2_double;
					   String pt3=temp[2].trim();
					   double pt3_double= Double.valueOf(pt3).doubleValue();
					   hj_pt3=hj_pt3+pt3_double;
					   String pt4=temp[3].trim();
					   double pt34_double= Double.valueOf(pt4).doubleValue();
					   hj_pt4=hj_pt4+pt34_double;
					   map.put("pt1", pt1);
					   map.put("pt2", pt2);
					   map.put("pt3", pt3);
					   map.put("pt4", pt4);
					   projectFundsTableList.add(map);
					   
				   }
			   }
			}
			
			Map<String, Object> map_temp_pt = new HashMap<String, Object>();
			map_temp_pt.put("pt1", "合  计");
			map_temp_pt.put("pt2", hj_pt2);
			map_temp_pt.put("pt3", hj_pt3);
			map_temp_pt.put("pt4", hj_pt4);
			System.out.println("==========hj_pt2"+hj_pt2+"pt3="+hj_pt3);
			projectFundsTableList.add(map_temp_pt);
			dataMap.put("projectFundsTableList", projectFundsTableList);
			
			System.out.println("---------项目资金安排 （源）: "+projectFundsTableStr);
			JSONArray projectFundsTableList_jSONArray= JSONArray.parseArray(JSON.toJSONString(projectFundsTableList));
			System.out.println("---------项目资金安排（FTL） : "+projectFundsTableList_jSONArray.toString());
			
			
			
			
			
			
			
           String myPic = "";  
			try {  
			     myPic = WordUtil.getImageString("D://doc//20190218155218.jpg");  
			} catch (IOException e) {  
			    e.printStackTrace();  
			}  
			 
			dataMap.put("showPicture", myPic);  
			
			
			fileName = System.currentTimeMillis()+".doc";

			*//** 生成word *//*
			boolean flage=WordUtil.createWord(dataMap, "task.ftl", filePath, fileName);
			if(flage==true)
			{
				resutl=filePath+File.separator+fileName;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resutl;
	}*/
	
	
	

}
