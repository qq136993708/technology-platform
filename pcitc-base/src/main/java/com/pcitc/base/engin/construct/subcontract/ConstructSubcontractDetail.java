package com.pcitc.base.engin.construct.subcontract;

import java.math.BigDecimal;

public class ConstructSubcontractDetail {
	/**
	 * 业务id
	 */
	private String dataId;

	/**
	 * 分包方案编号
	 */
	private String subcontractId;

	/**
	 * 拟分包工作名称
	 */
	private String workName;

	/**
	 * 分包性质
	 */
	private String type;

	/**
	 * 分包发包方式
	 */
	private String sendMode;

	/**
	 * 分包发包组织形式
	 */
	private String orgMode;

	/**
	 * 估算合同金额
	 */
	private BigDecimal estimateAmount;

	/**
	 * 分包管理费上限
	 */
	private BigDecimal maxCost;

	/**
	 * 代理机构名称
	 */
	private String agentName;

	/**
	 * 分包发包计划开始时间
	 */
	private String planStartdate;

	/**
	 * 分包发包计划完成时间
	 */
	private String planEnddate;

	/**
	 * 分包实施计划开始时间
	 */
	private String implStartdate;

	/**
	 * 分包实施计划完成时间
	 */
	private String implEnddate;

	/**
	 * 拟分包内容
	 */
	private String content;
	
	/**
	 * 拟分包单位
	 */
	private String unitName;
	
	/**
	 * 拟分包单位资质
	 */
	private String unitQualify;

	public String getDataId() {
		return dataId;
	}

	public void setDataId(String dataId) {
		this.dataId = dataId == null ? null : dataId.trim();
	}

	public String getSubcontractId() {
		return subcontractId;
	}

	public void setSubcontractId(String subcontractId) {
		this.subcontractId = subcontractId == null ? null : subcontractId.trim();
	}

	public String getWorkName() {
		return workName;
	}

	public void setWorkName(String workName) {
		this.workName = workName == null ? null : workName.trim();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	public String getSendMode() {
		return sendMode;
	}

	public void setSendMode(String sendMode) {
		this.sendMode = sendMode == null ? null : sendMode.trim();
	}

	public String getOrgMode() {
		return orgMode;
	}

	public void setOrgMode(String orgMode) {
		this.orgMode = orgMode == null ? null : orgMode.trim();
	}

	public BigDecimal getEstimateAmount() {
		return estimateAmount;
	}

	public void setEstimateAmount(BigDecimal estimateAmount) {
		this.estimateAmount = estimateAmount;
	}

	public BigDecimal getMaxCost() {
		return maxCost;
	}

	public void setMaxCost(BigDecimal maxCost) {
		this.maxCost = maxCost;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName == null ? null : agentName.trim();
	}

	public String getPlanStartdate() {
		return planStartdate;
	}

	public void setPlanStartdate(String planStartdate) {
		this.planStartdate = planStartdate == null ? null : planStartdate.trim();
	}

	public String getPlanEnddate() {
		return planEnddate;
	}

	public void setPlanEnddate(String planEnddate) {
		this.planEnddate = planEnddate == null ? null : planEnddate.trim();
	}

	public String getImplStartdate() {
		return implStartdate;
	}

	public void setImplStartdate(String implStartdate) {
		this.implStartdate = implStartdate == null ? null : implStartdate.trim();
	}

	public String getImplEnddate() {
		return implEnddate;
	}

	public void setImplEnddate(String implEnddate) {
		this.implEnddate = implEnddate == null ? null : implEnddate.trim();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getUnitQualify() {
		return unitQualify;
	}

	public void setUnitQualify(String unitQualify) {
		this.unitQualify = unitQualify;
	}
	
}