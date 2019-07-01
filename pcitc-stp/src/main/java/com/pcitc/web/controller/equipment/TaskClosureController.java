package com.pcitc.web.controller.equipment;

import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.equipment.SreEquipment;
import com.pcitc.base.stp.equipment.SreProject;
import com.pcitc.base.stp.equipment.SreProjectTask;
import com.pcitc.base.workflow.Constants;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;

@Controller
public class TaskClosureController extends BaseController {


	private static final String PAGE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/task_closure/page";
	private static final String UPP_URL = "http://pcitc-zuul/stp-proxy/sre-provider/task_closure/updateID";
	private static final String CLORE_PAGE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/closure/page";
	
	/**
	 * 任务未关闭列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sre-task-closure/list")
	@ResponseBody
	public String taskClosurelist(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {
		
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

	@RequestMapping(value = "/sre-task-closure/to-list")
	public String list(HttpServletRequest request, HttpServletResponse response) {
		String	parentUnitPathIds="";
		String unitPathIds =   sysUserInfo.getUnitPath();
		parentUnitPathIds = EquipmentUtils.getParentUnitPathId(unitPathIds);
		request.setAttribute("parentUnitPathIds", parentUnitPathIds);
		return "/stp/equipment/taskclosure/task_closure_list";
	}
	
	/**
	   *  修改 
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sre-task-closure/uppdata/{taskId}")
	public String uppdata(@PathVariable("taskId") String taskId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();
		String result = "";
		//ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(UPP_URL + taskId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
		SreProjectTask sreProjectTask=EquipmentUtils.getSreProjectTask(taskId, restTemplate, httpHeaders);
		if(sreProjectTask!=null) {
		SreProject  sreProject = EquipmentUtils.getSreProject(sreProjectTask.getTopicId(), restTemplate, httpHeaders);//根据taskid获取课题数据
		int count =0;
		if(sreProject!=null) {
			String equipmentid[] = sreProject.getEquipmentIds().split(",");//取出该课题所绑定装备id
			for(int i=0;i<equipmentid.length;i++){
				SreEquipment  sreEquipment = EquipmentUtils.getSreEquipment(equipmentid[i], restTemplate, httpHeaders);
				if(sreEquipment!=null) {//获取装备采购状态和转资状态
				if(Integer.parseInt(sreEquipment.getPurchaseStatus())< 4 && Integer.parseInt(sreEquipment.getForStatus())< 1) {
					count++;//如果当前有未转资的装备count自增用于逻辑代码判断
					break;
				}
				}
			}
		}
		if(count>0) {//如果count大于0,代表存在未转资的装备，就不能关闭
			result ="2";
		}else {
		sreProjectTask.setCloseStatus(Constants.OK_CLOUSE);
		sreProjectTask.setCloseDate(new Date());
		String  sre = EquipmentUtils.updateSreProjectTask(sreProjectTask, restTemplate, httpHeaders);
		if(sre!=null && sre.equals(Constants.OK_CLOUSE)) {
			result ="1";
		}else {
			result ="3";
		}
		}
		JSONObject jObject=new JSONObject();
		jObject.put("result", result);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(jObject.toString());
		out.flush();
		out.close();
		}
		return null;
	}
	
	
	/**
	 * 任务已关闭列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sre-closure/list")
	@ResponseBody
	public String closurelist(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {
		
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(CLORE_PAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============result" + result);
		return result.toString();
	}

	@RequestMapping(value = "/sre-closure/to-list")
	public String tolist(HttpServletRequest request, HttpServletResponse response) {
		return "/stp/equipment/taskclosure/closure_list";
	}
}