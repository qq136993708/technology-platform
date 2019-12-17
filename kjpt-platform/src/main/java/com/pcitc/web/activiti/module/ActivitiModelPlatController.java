package com.pcitc.web.activiti.module;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.OperationFilter;

/**
 * @author zhf 2017-04-18 工作流模型
 */
@Controller
public class ActivitiModelPlatController extends BaseController {
	
	
	

	private static final String DIR_PATH = "";
	private static final String FILES_GET_URL = "http://kjpt-zuul/system-proxy/user-provider/user/{id}";
	private static final String getFilesLayui = "http://kjpt-zuul/system-proxy/sysfile-provider/sysfile/getFilesLayui";

	private static final String MODEL_LIST = "http://kjpt-zuul/system-proxy/activity-provider/model/list";

	private static final String RESOURCE_DATA = "http://kjpt-zuul/system-proxy/modeler-provider/resource/byte";
	private static final String RESOURCE_IMAGE_PATH = "http://kjpt-zuul/system-proxy/modeler-provider/resource/image/path";
	private static final String MODEL_DEPLOY_URL = "http://kjpt-zuul/system-proxy/modeler-provider/model/deploy";
	private static final String MODEL_DELETE_URL = "http://kjpt-zuul/system-proxy/modeler-provider/model/delete";
	private static final String MODEL_EXPORT_URL = "http://kjpt-zuul/system-proxy/modeler-provider/model/export";
	private static final String MODEL_UPLOAD_URL = "http://kjpt-zuul/system-proxy/modeler-provider/model/upload";
	
	
	private static final String RESOURCE_MODEL_IMAGE_PATH = "http://kjpt-zuul/system-proxy/task-provider/getModelImage/";
	

	/**
	 * @author zhf
	 * @date 2018年4月19日 下午1:52:25 流程模型列表
	 */
	@RequestMapping(value = "/activiti-model/model-list", method = RequestMethod.POST)
	@ResponseBody
	public Object getModelList(@ModelAttribute("param") LayuiTableParam param) {
		// 获取当前登录人信息
		SysUser sysUserInfo = getUserProfile();
		param.getParam().put("userId", sysUserInfo.getUserId());
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(MODEL_LIST, HttpMethod.POST, entity,
				LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();

		return JSON.toJSON(retJson).toString();
	}

	@RequestMapping(value = "/activiti-model/model/list")
	public String iniModelList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("=====/activiti-model/model/list");

		return "/pplus/workflow/model-list";
	}

	/**
	 * @author zhf
	 * @date 2018年4月19日 下午1:52:40 跳转到模型资源文件查看界面
	 */
	@RequestMapping(value = "/activiti-model/show/{modelId}")
	public String showResoure(@PathVariable("modelId") String modelId, HttpServletRequest request) {
		WorkflowVo workflowVo = new WorkflowVo();
		workflowVo.setModelId(modelId);
		ResponseEntity<String> fileStream = this.restTemplate.exchange(RESOURCE_IMAGE_PATH, HttpMethod.POST,
				new HttpEntity<WorkflowVo>(workflowVo, this.httpHeaders), String.class);
		String imagePath = fileStream.getBody();
		System.out.println("imagePath=====" + imagePath);
		request.setAttribute("imagePath", imagePath);
		return "/pplus/workflow/model-show";
	}
	
	
	
	
	
	@RequestMapping(value = "/activiti-model/show_image/{modelId}")
	public String model_show(@PathVariable("modelId") String modelId, HttpServletRequest request) {
		//request.setAttribute("modelId", modelId);
		return "/pplus/workflow/model_image_show";
	}
	
	
	@RequestMapping(value = "/activiti-model/get_image/{modelId}")
	@ResponseBody
	public String get_image(@PathVariable("modelId") String modelId, HttpServletRequest request) 
	{
		ResponseEntity<byte[]> responseEntity = this.restTemplate.exchange(RESOURCE_MODEL_IMAGE_PATH + modelId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), byte[].class);
		int statusCode = responseEntity.getStatusCodeValue();
		byte[] image = responseEntity.getBody();
		OutputStream os = null;
		try {
			os = getCurrentResponse().getOutputStream();
			os.write(image);
			os.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	@RequestMapping(value = "/activiti-model/image/{modelId}", method = RequestMethod.GET)
	@ResponseBody
	public String showFlowImage(@PathVariable("modelId") String modelId, HttpServletRequest request,
			HttpServletResponse response) {

		WorkflowVo workflowVo = new WorkflowVo();
		workflowVo.setModelId(modelId);
		workflowVo.setDataType("image");
		ResponseEntity<byte[]> fileStream = this.restTemplate.exchange(RESOURCE_DATA, HttpMethod.POST,
				new HttpEntity<WorkflowVo>(workflowVo, this.httpHeaders), byte[].class);
		byte[] image = fileStream.getBody();
		OutputStream os = null;
		try {
			os = response.getOutputStream();
			os.write(image);
			os.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ok";
	}

	/**
	 * @author zhf
	 * @date 2018年4月20日 上午10:13:39 编辑某个模型
	 */
	@RequestMapping(value = "/activiti-model/edit-flow/{modelId}")
	@OperationFilter(modelName = "系统管理", actionName = "编辑工作流模型")
	public ModelAndView editFlow(@PathVariable("modelId") String modelId, HttpServletRequest request)
			throws UnsupportedEncodingException {

		return new ModelAndView("redirect:/modeler.html?modelId=" + modelId);
	}

	/**
	 * @author zhf
	 * @date 2018年4月20日 上午10:13:27 发布模型为流程定义
	*/
	@RequestMapping(value = "/activiti-model/deploy/{id}", method = RequestMethod.POST)
	@ResponseBody
	@OperationFilter(modelName = "系统管理", actionName = "部署工作流模型")
	public Result deployModel(@PathVariable("id") String id, HttpServletRequest request) throws Exception {

		WorkflowVo workflowVo = new WorkflowVo();
		workflowVo.setModelId(id);
		workflowVo.setRequestPath(request.getRealPath("/"));
		ResponseEntity<Result> resultRes = this.restTemplate.exchange(MODEL_DEPLOY_URL, HttpMethod.POST,
				new HttpEntity<WorkflowVo>(workflowVo, this.httpHeaders), Result.class);
		System.out.println("deployModel=====" + resultRes.getBody());
		return resultRes.getBody();
	}
	 
	
	/*
	 * @RequestMapping(value = "/activiti-model/deploy/{id}", method =
	 * RequestMethod.POST)
	 * 
	 * @ResponseBody
	 * 
	 * @OperationFilter(modelName = "系统管理", actionName = "部署工作流模型") public Result
	 * deployModel(@PathVariable("id") String id, HttpServletRequest request) throws
	 * Exception {
	 * 
	 * 
	 * 
	 * 
	 * Result result=new Result(); result.setSuccess(true); //获取模型 RepositoryService
	 * repositoryService = processEngine.getRepositoryService(); Model modelData =
	 * repositoryService.getModel(id); byte[] bytes =
	 * repositoryService.getModelEditorSource(modelData.getId()); if (bytes == null)
	 * { result.setSuccess(false); result.setMessage("模型数据为空，请先设计流程并成功保存，再进行发布。");
	 * return result ; } JsonNode modelNode = new ObjectMapper().readTree(bytes);
	 * BpmnModel model = new BpmnJsonConverter().convertToBpmnModel(modelNode);
	 * if(model.getProcesses().size()==0) { result.setSuccess(false);
	 * result.setMessage("数据模型不符要求，请至少设计一条主线流程。"); return result ; } byte[]
	 * bpmnBytes = new BpmnXMLConverter().convertToXML(model); //发布流程 String
	 * processName = modelData.getName() + ".bpmn20.xml"; Deployment deployment =
	 * repositoryService.createDeployment() .name(modelData.getName())
	 * .addString(processName, new String(bpmnBytes, "UTF-8")) .deploy();
	 * modelData.setDeploymentId(deployment.getId());
	 * repositoryService.saveModel(modelData); return result;
	 * 
	 * 
	 * 
	 * WorkflowVo workflowVo = new WorkflowVo(); workflowVo.setModelId(id);
	 * workflowVo.setRequestPath(request.getRealPath("/")); ResponseEntity<Result>
	 * resultRes = this.restTemplate.exchange(MODEL_DEPLOY_URL, HttpMethod.POST, new
	 * HttpEntity<WorkflowVo>(workflowVo, this.httpHeaders), Result.class);
	 * System.out.println("deployModel=====" + resultRes.getBody()); return
	 * resultRes.getBody(); }
	 */

	@RequestMapping(value = "/activiti-model/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	@OperationFilter(modelName = "系统管理", actionName = "删除工作流模型")
	public Result deleteModel(@PathVariable("id") String id, HttpServletRequest request) throws Exception {

		WorkflowVo workflowVo = new WorkflowVo();
		workflowVo.setModelId(id);
		ResponseEntity<Result> resultRes = this.restTemplate.exchange(MODEL_DELETE_URL, HttpMethod.POST,
				new HttpEntity<WorkflowVo>(workflowVo, this.httpHeaders), Result.class);
		System.out.println("deleteModel=====" + resultRes.getBody());
		return resultRes.getBody();
	}

	/**
	 * @author zhf
	 * @date 2018年4月20日 模型的导出
	 */
	@RequestMapping(value = "/activiti-model/export/{id}/{name}", method = RequestMethod.GET)
	@OperationFilter(modelName = "系统管理", actionName = "导出工作流文件")
	public ResponseEntity<byte[]> modelExport(@PathVariable("id") String id, @PathVariable("name") String name,
			HttpServletResponse response) throws Exception {
		System.out.println("1======export----------" + id);

		WorkflowVo workflowVo = new WorkflowVo();
		workflowVo.setModelId(id);
		ResponseEntity<byte[]> resultRes = this.restTemplate.exchange(MODEL_EXPORT_URL, HttpMethod.POST,
				new HttpEntity<WorkflowVo>(workflowVo, this.httpHeaders), byte[].class);
		System.out.println("modelExport=====" + resultRes.getBody());
		httpHeaders.add("x-frame-options", "SAMEORIGIN");
		response.addHeader("x-frame-options", "SAMEORIGIN");
		String filename = name + ".bpmn";
		response.setHeader("Content-Disposition",
				"attachment; filename=" + new String(filename.getBytes("gb2312"), "ISO8859-1"));

		/*
		 * try { if (resultRes.getBody() == null) {
		 * response.setCharacterEncoding("utf-8");
		 * response.getWriter().print("<script>modals.error('文件生成错误');</script>");
		 * response.flushBuffer(); return; } System.out.println("1modelExport=====" +
		 * resultRes.getBody()); ByteArrayInputStream in = new
		 * ByteArrayInputStream(resultRes.getBody());
		 * System.out.println("2modelExport=====" + in); IOUtils.copy(in,
		 * response.getOutputStream()); System.out.println("3modelExport=====" +
		 * resultRes.getBody());
		 * 
		 * System.out.println("4modelExport=====" + resultRes.getBody());
		 * response.flushBuffer(); System.out.println("5modelExport=====" +
		 * resultRes.getBody()); } catch (Exception e) {
		 * response.setCharacterEncoding("utf-8");
		 * response.getWriter().print("<script>modals.error('导出失败');</script>");
		 * response.flushBuffer(); }
		 */
		return resultRes;
	}

	/*
	 * @RequestMapping(value = "/activiti-model/file/upload")
	 * 
	 * @ResponseBody
	 * 
	 * @OperationFilter(modelName = "系统管理", actionName = "上传工作流文件") public Result
	 * saveWorkflowUpload(@RequestBody String param) {
	 * System.out.println("saveWorkflowUpload---------" + param); JSONArray jsArr =
	 * JSONObject.parseArray(param); List<SysFile> fileList =
	 * JSONObject.parseArray(jsArr.toJSONString(), SysFile.class); //
	 * 根据文件id获取文件相关信息，进行解析
	 * this.httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
	 * MultiValueMap<String, String> form = new LinkedMultiValueMap<String,
	 * String>(); form.add("fileIds", fileIds); HttpEntity<MultiValueMap<String,
	 * String>> httpEntity = new HttpEntity<>(form, httpHeaders);
	 * ResponseEntity<FileResult> responseEntity =
	 * this.restTemplate.postForEntity(getFilesLayui, httpEntity, FileResult.class);
	 * List<SysFile> fileList = responseEntity.getBody().getList();
	 * 
	 * WorkflowVo workflowVo = new WorkflowVo(); workflowVo.setFileList(fileList);
	 * ResponseEntity<Result> resultRes =
	 * this.restTemplate.exchange(MODEL_UPLOAD_URL, HttpMethod.POST, new
	 * HttpEntity<WorkflowVo>(workflowVo, this.httpHeaders), Result.class);
	 * System.out.println("deployModel=====" + resultRes.getBody()); return
	 * resultRes.getBody(); }
	 */
}
