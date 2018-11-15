package com.pcitc.base.workflow;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.pcitc.base.system.SysFile;

public class WorkflowVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String processDefineId;           //流程定义id
	 
	private String processDefineKey;          //流程定义key
	
	private String processDefinitionName;     //流程定义名称
	
	private String businessId;                //业务id（主表id）
	
	private String authenticatedUserId;       //启动人
	
	private Map<String, Object> variables;    //任务节点需要的变量
	
	private String processInstanceName;       //流程实例名称，当做任务名称来用。每一步的任务本质上是流程图中的节点名称，不满足实际业务需要

	private String taskId;                    //任务id
	
	private String unitId;                     //所属组织不同，流程走不同
	
	private String projectId;                 //所属项目不同，流程走不同
	
	private String functionId;                //所属菜单，每个菜单能配置多个流程（部门、项目等）
	
	private String auditAgree;                //审批是否统一
	
	private String auditRemarks;              //审批意见
	
	private String auditorId;                 //审批人
	
	private String auditorName;               //审批人
	
	private String auditDate;                 //审批时间
	
	private String auditUserIds;              //下一步审批人
	
	private String modelId;					  // 模型id
	
	private String modelName;				  // 模型name
	
	private String modelDescription;          // 模型描述
	
	private String jsonXml; 				  // 模型的json形式数据
	
	private String svgXml;					  // 模型的svg形式数据
	
	private String requestPath;
	
	private String dataType;
	
	private String state;
	
	private String instanceId;
	
	private List<SysFile> fileList;
	
	
	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	private HttpServletResponse response;
	
	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<SysFile> getFileList() {
		return fileList;
	}

	public void setFileList(List<SysFile> fileList) {
		this.fileList = fileList;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getRequestPath() {
		return requestPath;
	}

	public void setRequestPath(String requestPath) {
		this.requestPath = requestPath;
	}

	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getModelDescription() {
		return modelDescription;
	}

	public void setModelDescription(String modelDescription) {
		this.modelDescription = modelDescription;
	}

	public String getJsonXml() {
		return jsonXml;
	}

	public void setJsonXml(String jsonXml) {
		this.jsonXml = jsonXml;
	}

	public String getSvgXml() {
		return svgXml;
	}

	public void setSvgXml(String svgXml) {
		this.svgXml = svgXml;
	}

	public String getProcessDefinitionName() {
		return processDefinitionName;
	}

	public void setProcessDefinitionName(String processDefinitionName) {
		this.processDefinitionName = processDefinitionName;
	}

	public String getAuditorName() {
		return auditorName;
	}

	public void setAuditorName(String auditorName) {
		this.auditorName = auditorName;
	}

	public String getAuditUserIds() {
		return auditUserIds;
	}

	public void setAuditUserIds(String auditUserIds) {
		this.auditUserIds = auditUserIds;
	}

	public String getAuditAgree() {
		return auditAgree;
	}

	public void setAuditAgree(String auditAgree) {
		this.auditAgree = auditAgree;
	}

	public String getAuditRemarks() {
		return auditRemarks;
	}

	public void setAuditRemarks(String auditRemarks) {
		this.auditRemarks = auditRemarks;
	}

	public String getAuditorId() {
		return auditorId;
	}

	public void setAuditorId(String auditorId) {
		this.auditorId = auditorId;
	}

	public String getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(String auditDate) {
		this.auditDate = auditDate;
	}

	public String getFunctionId() {
		return functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	/**
	 * @return the taskId
	 */
	public String getTaskId() {
		return taskId;
	}

	/**
	 * @param taskId the taskId to set
	 */
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	/**
	 * @return the processDefineId
	 */
	public String getProcessDefineId() {
		return processDefineId;
	}

	/**
	 * @param processDefineId the processDefineId to set
	 */
	public void setProcessDefineId(String processDefineId) {
		this.processDefineId = processDefineId;
	}

	/**
	 * @return the processDefineKey
	 */
	public String getProcessDefineKey() {
		return processDefineKey;
	}

	/**
	 * @param processDefineKey the processDefineKey to set
	 */
	public void setProcessDefineKey(String processDefineKey) {
		this.processDefineKey = processDefineKey;
	}

	/**
	 * @return the businessId
	 */
	public String getBusinessId() {
		return businessId;
	}

	/**
	 * @param businessId the businessId to set
	 */
	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	/**
	 * @return the authenticatedUserId
	 */
	public String getAuthenticatedUserId() {
		return authenticatedUserId;
	}

	/**
	 * @param authenticatedUserId the authenticatedUserId to set
	 */
	public void setAuthenticatedUserId(String authenticatedUserId) {
		this.authenticatedUserId = authenticatedUserId;
	}

	/**
	 * @return the variables
	 */
	public Map<String, Object> getVariables() {
		return variables;
	}

	/**
	 * @param variables the variables to set
	 */
	public void setVariables(Map<String, Object> variables) {
		this.variables = variables;
	}

	/**
	 * @return the processInstanceName
	 */
	public String getProcessInstanceName() {
		return processInstanceName;
	}

	/**
	 * @param processInstanceName the processInstanceName to set
	 */
	public void setProcessInstanceName(String processInstanceName) {
		this.processInstanceName = processInstanceName;
	}
	
}
