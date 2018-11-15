package com.pcitc.base.engin.construct.subcontract;

import java.math.BigDecimal;

public class ConstructSubcontract {
	/**
	 * 业务id
	 */
	private String dataId;

	/**
	 * 业务编码
	 */
	private String formCode;

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
	 * 修改时间
	 */
	private String updateDate;

	/**
	 * 状态
	 */
	private String status;

	/**
	 * 审批状态
	 */
	private String auditStatus;

	/**
	 * 公司代码
	 */
	private String companyCode;

	/**
	 * 项目id
	 */
	private String projectId;

	/**
	 * 装置名称（项目）
	 */
	private String projectName;

	/**
	 * 主合同名称
	 */
	private String contractName;

	/**
	 * 主合同编码
	 */
	private String contractCode;

	/**
	 * wbs名称（单项工程）
	 */
	private String wbsName;

	/**
	 * wbs编码
	 */
	private String wbsCode;

	/**
	 * 承包商名称
	 */
	private String contractor;

	/**
	 * 建设单位
	 */
	private String constructUnit;

	/**
	 * 主合同采购方式
	 */
	private String purchuseType;

	/**
	 * 主合同签订日期
	 */
	private String signDate;

	/**
	 * 主合同开始日期
	 */
	private String startDate;

	/**
	 * 主合同结束日期
	 */
	private String endDate;

	/**
	 * 主合同金额
	 */
	private BigDecimal amount;

	/**
	 * 联系人姓名
	 */
	private String contactName;

	/**
	 * 联系人邮箱
	 */
	private String contactEmail;

	/**
	 * 联系人电话
	 */
	private String contactPhone;

	/**
	 * 合同主要内容
	 */
	private String content;

	/**
	 * 备注
	 */
	private String comment;

	public String getDataId() {
		return dataId;
	}

	public void setDataId(String dataId) {
		this.dataId = dataId == null ? null : dataId.trim();
	}

	public String getFormCode() {
		return formCode;
	}

	public void setFormCode(String formCode) {
		this.formCode = formCode == null ? null : formCode.trim();
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser == null ? null : createUser.trim();
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate == null ? null : createDate.trim();
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser == null ? null : updateUser.trim();
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate == null ? null : updateDate.trim();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus == null ? null : auditStatus.trim();
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode == null ? null : companyCode.trim();
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId == null ? null : projectId.trim();
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName == null ? null : projectName.trim();
	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName == null ? null : contractName.trim();
	}

	public String getContractCode() {
		return contractCode;
	}

	public void setContractCode(String contractCode) {
		this.contractCode = contractCode == null ? null : contractCode.trim();
	}

	public String getWbsName() {
		return wbsName;
	}

	public void setWbsName(String wbsName) {
		this.wbsName = wbsName == null ? null : wbsName.trim();
	}

	public String getWbsCode() {
		return wbsCode;
	}

	public void setWbsCode(String wbsCode) {
		this.wbsCode = wbsCode == null ? null : wbsCode.trim();
	}

	public String getContractor() {
		return contractor;
	}

	public void setContractor(String contractor) {
		this.contractor = contractor == null ? null : contractor.trim();
	}

	public String getConstructUnit() {
		return constructUnit;
	}

	public void setConstructUnit(String constructUnit) {
		this.constructUnit = constructUnit == null ? null : constructUnit.trim();
	}

	public String getPurchuseType() {
		return purchuseType;
	}

	public void setPurchuseType(String purchuseType) {
		this.purchuseType = purchuseType == null ? null : purchuseType.trim();
	}

	public String getSignDate() {
		return signDate;
	}

	public void setSignDate(String signDate) {
		this.signDate = signDate == null ? null : signDate.trim();
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate == null ? null : startDate.trim();
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate == null ? null : endDate.trim();
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName == null ? null : contactName.trim();
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail == null ? null : contactEmail.trim();
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone == null ? null : contactPhone.trim();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment == null ? null : comment.trim();
	}
}