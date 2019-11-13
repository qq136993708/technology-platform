package com.pcitc.base.stp.equipment;

import java.math.BigDecimal;

public class SreInvestmentrogress {
    
	private String equipmentName;//装备名称
	
	private BigDecimal unitPrice;//装备金额
	
	private String  proposalState;//技术方案状态
	
	private String  contractState;//合同状态
	
	private String  forapplicationState;//到货转资状态
	
	private String  acceptanceState;//项目验收状态
	
	private String  taskCloseState;//任务关闭状态
	
	private String  purchaseState;//采购状态
	
	
	public String getEquipmentName() {
		return equipmentName;
	}

	public String getPurchaseState() {
		return purchaseState;
	}

	public void setPurchaseState(String purchaseState) {
		this.purchaseState = purchaseState;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getProposalState() {
		return proposalState;
	}

	public void setProposalState(String proposalState) {
		this.proposalState = proposalState;
	}

	public String getContractState() {
		return contractState;
	}

	public void setContractState(String contractState) {
		this.contractState = contractState;
	}

	public String getForapplicationState() {
		return forapplicationState;
	}

	public void setForapplicationState(String forapplicationState) {
		this.forapplicationState = forapplicationState;
	}

	public String getAcceptanceState() {
		return acceptanceState;
	}

	public void setAcceptanceState(String acceptanceState) {
		this.acceptanceState = acceptanceState;
	}

	public String getTaskCloseState() {
		return taskCloseState;
	}

	public void setTaskCloseState(String taskCloseState) {
		this.taskCloseState = taskCloseState;
	}

	@Override
	public String toString() {
		return "SreInvestmentrogress [equipmentName=" + equipmentName + ", unitPrice=" + unitPrice + ", proposalState="
				+ proposalState + ", contractState=" + contractState + ", forapplicationState=" + forapplicationState
				+ ", acceptanceState=" + acceptanceState + ", taskCloseState=" + taskCloseState + "]";
	}
	
	

	
	
}