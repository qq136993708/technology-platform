package com.pcitc.base.engin.qualification.machine;

import java.io.Serializable;

/**
 * qlfc_machine_tools
 * 
 * @author
 */
public class QlfcMachineToolsVo implements Serializable {
	/**
	 * 机具id
	 */
	private String dataId;

	/**
	 * 创建人
	 */
	private String createUser;

	/**
	 * 创建时间
	 */
	private String createDate;

	/**
	 * 修改人
	 */
	private String updateUser;

	/**
	 * 最后修改人
	 */
	private String updateDate;

	/**
	 * 记录状态：删除、停用、正常
	 */
	private String status;

	/**
	 * 审批状态：草稿、待审批、已审批
	 */
	private String auditStatus;

	/**
	 * 公司代码
	 */
	private String companyCode;

	/**
	 * 所属项目
	 */
	private String projectId;

	/**
	 * 机具编码
	 */
	private String formCode;

	/**
	 * 机具报验id
	 */
	private String reportId;

	/**
	 * 机具退场id
	 */
	private String exitId;

	/**
	 * 是否退场 0 否 1是
	 */
	private String isExit;

	/**
	 * 是否过期 0否 1是
	 */
	private String isOld;

	/**
	 * 是否合格 0 不合格 1合格
	 */
	private String isQualified;

	/**
	 * 附件id
	 */
	private String attachId;

	/**
	 * 机具名称
	 */
	private String toolName;

	/**
	 * 机具类型
	 */
	private String toolType;

	/**
	 * 机具型号
	 */
	private String toolVersion;

	/**
	 * 机具照片（地址）
	 */
	private String toolPhoto;

	/**
	 * 机具负责人
	 */
	private String toolPerson;

	/**
	 * 联系方式
	 */
	private String contactWay;

	/**
	 * 施工区域
	 */
	private String workArea;

	/**
	 * 有效期至
	 */
	private String validTill;

	/**
	 * 退场日期
	 */
	private String exitDate;

	/**
	 * 照片绑定的假dataId
	 */
	private String dataIdPhoto;

	/**
	 * 问题描述
	 */
	private String remark;

	/**
	 * 问题附件需要绑定的假dataId
	 */
	private String dataIdRemark;

	/**
	 * 所属承包商 （也叫单位名称）
	 */
	private String contractor;

	/**
	 * 单项工程（wbs）
	 */
	private String wbsId;

	/**
	 * 单项工程名称
	 */
	private String wbsName;
	
	private static final long serialVersionUID = 1L;

	public String getDataId() {
		return dataId;
	}

	public void setDataId(String dataId) {
		this.dataId = dataId;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getFormCode() {
		return formCode;
	}

	public void setFormCode(String formCode) {
		this.formCode = formCode;
	}

	public String getReportId() {
		return reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	public String getExitId() {
		return exitId;
	}

	public void setExitId(String exitId) {
		this.exitId = exitId;
	}

	public String getIsExit() {
		return isExit;
	}

	public void setIsExit(String isExit) {
		this.isExit = isExit;
	}

	public String getIsOld() {
		return isOld;
	}

	public void setIsOld(String isOld) {
		this.isOld = isOld;
	}

	public String getIsQualified() {
		return isQualified;
	}

	public void setIsQualified(String isQualified) {
		this.isQualified = isQualified;
	}

	public String getAttachId() {
		return attachId;
	}

	public void setAttachId(String attachId) {
		this.attachId = attachId;
	}

	public String getToolName() {
		return toolName;
	}

	public void setToolName(String toolName) {
		this.toolName = toolName;
	}

	public String getToolType() {
		return toolType;
	}

	public void setToolType(String toolType) {
		this.toolType = toolType;
	}

	public String getToolVersion() {
		return toolVersion;
	}

	public void setToolVersion(String toolVersion) {
		this.toolVersion = toolVersion;
	}

	public String getToolPhoto() {
		return toolPhoto;
	}

	public void setToolPhoto(String toolPhoto) {
		this.toolPhoto = toolPhoto;
	}

	public String getToolPerson() {
		return toolPerson;
	}

	public void setToolPerson(String toolPerson) {
		this.toolPerson = toolPerson;
	}

	public String getContactWay() {
		return contactWay;
	}

	public void setContactWay(String contactWay) {
		this.contactWay = contactWay;
	}

	public String getWorkArea() {
		return workArea;
	}

	public void setWorkArea(String workArea) {
		this.workArea = workArea;
	}

	public String getValidTill() {
		return validTill;
	}

	public void setValidTill(String validTill) {
		this.validTill = validTill;
	}

	public String getExitDate() {
		return exitDate;
	}

	public void setExitDate(String exitDate) {
		this.exitDate = exitDate;
	}

	public String getDataIdPhoto() {
		return dataIdPhoto;
	}

	public void setDataIdPhoto(String dataIdPhoto) {
		this.dataIdPhoto = dataIdPhoto;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDataIdRemark() {
		return dataIdRemark;
	}

	public void setDataIdRemark(String dataIdRemark) {
		this.dataIdRemark = dataIdRemark;
	}

	public String getContractor() {
		return contractor;
	}

	public void setContractor(String contractor) {
		this.contractor = contractor;
	}

	public String getWbsId() {
		return wbsId;
	}

	public void setWbsId(String wbsId) {
		this.wbsId = wbsId;
	}

	public String getWbsName() {
		return wbsName;
	}

	public void setWbsName(String wbsName) {
		this.wbsName = wbsName;
	}

}