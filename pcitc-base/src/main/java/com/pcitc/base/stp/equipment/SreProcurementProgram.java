package com.pcitc.base.stp.equipment;

public class SreProcurementProgram {
    
	private String purchaseName;//采购名称
	
	private String purchaseState;//采购状态
	
	private String contractDockingState;//合同对接状态
	
	private String arrivalReceiptState;//到货签收状态
	
	private String contractAcceptanceState;//合同验收状态
	
	private String installationState;//安装调试状态
	
	private String contractSlosureState;//合同关闭状态

	public String getPurchaseName() {
		return purchaseName;
	}

	public void setPurchaseName(String purchaseName) {
		this.purchaseName = purchaseName;
	}

	public String getPurchaseState() {
		return purchaseState;
	}

	public void setPurchaseState(String purchaseState) {
		this.purchaseState = purchaseState;
	}

	public String getContractDockingState() {
		return contractDockingState;
	}

	public void setContractDockingState(String contractDockingState) {
		this.contractDockingState = contractDockingState;
	}

	public String getArrivalReceiptState() {
		return arrivalReceiptState;
	}

	public void setArrivalReceiptState(String arrivalReceiptState) {
		this.arrivalReceiptState = arrivalReceiptState;
	}

	public String getContractAcceptanceState() {
		return contractAcceptanceState;
	}

	public void setContractAcceptanceState(String contractAcceptanceState) {
		this.contractAcceptanceState = contractAcceptanceState;
	}

	public String getInstallationState() {
		return installationState;
	}

	public void setInstallationState(String installationState) {
		this.installationState = installationState;
	}

	public String getContractSlosureState() {
		return contractSlosureState;
	}

	public void setContractSlosureState(String contractSlosureState) {
		this.contractSlosureState = contractSlosureState;
	}

	@Override
	public String toString() {
		return "SreProcurementProgram [purchaseName=" + purchaseName + ", purchaseState=" + purchaseState
				+ ", contractDockingState=" + contractDockingState + ", arrivalReceiptState=" + arrivalReceiptState
				+ ", contractAcceptanceState=" + contractAcceptanceState + ", installationState=" + installationState
				+ ", contractSlosureState=" + contractSlosureState + ", getPurchaseName()=" + getPurchaseName()
				+ ", getPurchaseState()=" + getPurchaseState() + ", getContractDockingState()="
				+ getContractDockingState() + ", getArrivalReceiptState()=" + getArrivalReceiptState()
				+ ", getContractAcceptanceState()=" + getContractAcceptanceState() + ", getInstallationState()="
				+ getInstallationState() + ", getContractSlosureState()=" + getContractSlosureState() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}