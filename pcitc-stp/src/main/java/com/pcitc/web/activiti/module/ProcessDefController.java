package com.pcitc.web.activiti.module;

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
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.OperationFilter;

/**
 * @author zhf
 * @date 2018年4月20日 上午10:27:55 流程定义控制器
 */
@Controller
public class ProcessDefController extends BaseController {

	private static final String DIR_PATH = "";

	private static final String PROCESS_DEFINE_LIST = "http://pcitc-zuul/system-proxy/modeler-provider/process/define/list";
	private static final String PROCESS_DEFINE_STATE = "http://pcitc-zuul/system-proxy/modeler-provider/process/define/state";
	private static final String PROCESS_DEFINE_IMAGE = "http://pcitc-zuul/system-proxy/modeler-provider/process/show";

	@RequestMapping(value = "/activiti-def/processdef/list/ini")
	public String iniWorkflowFunctionConfig(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/pplus/workflow/processdef-list";
	}

	@RequestMapping(value = "/activiti-def/tree")
	public String iniWorkflowFunctiontree(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/pplus/workflow/ztreeTable";
	}

	/**
	 * @author zhf
	 * @date 2018年4月20日 上午10:28:42 流程定义列表
	 */
	@RequestMapping(value = "/activiti-def/processdef-list", method = RequestMethod.POST)
	@ResponseBody
	public Object processdefList(@ModelAttribute("param") LayuiTableParam param) {

		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(PROCESS_DEFINE_LIST, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();

		return JSON.toJSON(retJson).toString();
	}

	/**
	 * @author zhf
	 * @date 2018年4月20日 上午10:27:55 删除定义，如果流程定义已被使用，则不删除 type=0 软删除 type=1 强制删除
	 */
	/*
	 * @RequestMapping(value = "/processdef/delete/{delType}/{pdId}", method =
	 * RequestMethod.POST)
	 * 
	 * @ResponseBody
	 * 
	 * @OperationFilter(modelName = "系统管理", actionName = "删除工作流定义") public
	 * Result deleteDeployment(@PathVariable("delType") String delType,
	 * 
	 * @PathVariable("pdId") String pdId) { ProcessDefinition pd =
	 * repositoryService.getProcessDefinition(pdId); try { if
	 * ("0".equals(delType))
	 * repositoryService.deleteDeployment(pd.getDeploymentId()); else
	 * repositoryService.deleteDeployment(pd.getDeploymentId(), true); return
	 * new Result(true, pdId, "成功删除"); } catch (Exception e) { return new
	 * Result(false, pdId, "删除失败，该流程定义已经关联了正在执行的流程"); } }
	 */

	@RequestMapping(value = "/activiti-def/update/{state}/{processDefinitionId}", method = RequestMethod.POST)
	@ResponseBody
	@OperationFilter(modelName = "系统管理", actionName = "修改工作流定义状态")
	public Result updateDeploymentState(@PathVariable("state") String state, @PathVariable("processDefinitionId") String processDefinitionId) {
		WorkflowVo workflowVo = new WorkflowVo();
		workflowVo.setState(state);
		workflowVo.setProcessDefineId(processDefinitionId);
		ResponseEntity<Result> resultRes = this.restTemplate.exchange(PROCESS_DEFINE_STATE, HttpMethod.POST, new HttpEntity<WorkflowVo>(workflowVo, this.httpHeaders), Result.class);
		System.out.println("deleteModel=====" + resultRes.getBody());
		return resultRes.getBody();
	}

	/*
	 * // 导出流程定义资源文件
	 * 
	 * @RequestMapping(value = "/processdef/export/{type}/{id}", method =
	 * RequestMethod.GET)
	 * 
	 * @OperationFilter(modelName = "系统管理", actionName = "导出工作流定义") public void
	 * downloadFlow(@PathVariable("type") String type, @PathVariable("id")
	 * String id, HttpServletResponse response) { try { ProcessDefinition
	 * processDefinition = repositoryService.getProcessDefinition(id); String
	 * resourceName = ""; if (type.equals("image")) { resourceName =
	 * processDefinition.getDiagramResourceName(); } else if
	 * (type.equals("xml")) { resourceName =
	 * processDefinition.getResourceName(); } InputStream resourceAsStream =
	 * repositoryService
	 * .getResourceAsStream(processDefinition.getDeploymentId(), resourceName);
	 * IOUtils.copy(resourceAsStream, response.getOutputStream());
	 * response.setHeader("Content-Disposition", "attachment; filename=" +
	 * resourceName); response.flushBuffer(); } catch (Exception e) { } }
	 */

	/**
	 * @author zhf
	 * @date 2018年4月20日 下午3:07:29 显示流程资源文件 生成资源文件，并返回文件路径 给开发者看的
	 */
	@RequestMapping(value = "/activiti-def/show/{pdId}", method = RequestMethod.GET)
	public String showResoure(@PathVariable("pdId") String pdId, HttpServletRequest request) {
		System.out.println("====showResoure" + pdId);

		WorkflowVo workflowVo = new WorkflowVo();
		workflowVo.setDataType("image");
		workflowVo.setProcessDefineId(pdId);
		ResponseEntity<Result> resultRes = this.restTemplate.exchange(PROCESS_DEFINE_IMAGE, HttpMethod.POST, new HttpEntity<WorkflowVo>(workflowVo, this.httpHeaders), Result.class);
		System.out.println("generateResource=====" + resultRes.getBody());
		request.setAttribute("image", resultRes.getBody().getData());
		
		return "/pplus/workflow/processdef-show";
	}

}
