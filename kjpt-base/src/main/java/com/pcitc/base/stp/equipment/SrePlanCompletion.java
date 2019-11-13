package com.pcitc.base.stp.equipment;

import java.math.BigDecimal;

public class SrePlanCompletion {
   /*
          * 计划完成管理台账实体类
    */
    
	private String projectName;//项目名称
	
	private String equipmentName;//装备名称
	
	private String erpNetwork;//ERP网络号
	
	private BigDecimal projectPrice;//计划万元
	
	private String equipmentType;//科研装备分类
	
	private String declarationUnit;//申报单位
	
	private BigDecimal surplusFund ;//结余资金
	
	private String erpPurchase;//ERP采购申请
	
	private String purchaseOrder;//ERP采购订单
	
	private String contractNumber;//合同号
	
	private String supplier;//供应商
	
	private BigDecimal contractPrice;//合同额(万元)
	
	private BigDecimal delivery;//预付
	
	private BigDecimal metaphase;//中期
	
	private BigDecimal arrears;//尾款
	
	private BigDecimal accumulative;//累计
	
	private String equipmentClassification;//设备分类
	
	private String versionSpecificationModel;//版本、规格型号
	
	private BigDecimal price;//单价
	
	private Integer number;//数量
	
	private BigDecimal totalPrice;//总价
	
	private String useDepartment;//使用部门
	
	private String use;//使用人、管理人
	
	private String fixedAssetsNumber;//固定资产编号
	
	private String transferFunds;//转资情况(0未转资、1已转资)
	
	private String installationLocation;//安装地点
	
	private String scrap;//报废情况(0未报废、1已报废)

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public String getErpNetwork() {
		return erpNetwork;
	}

	public void setErpNetwork(String erpNetwork) {
		this.erpNetwork = erpNetwork;
	}

	public BigDecimal getProjectPrice() {
		return projectPrice;
	}

	public void setProjectPrice(BigDecimal projectPrice) {
		this.projectPrice = projectPrice;
	}

	public String getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}

	public String getDeclarationUnit() {
		return declarationUnit;
	}

	public void setDeclarationUnit(String declarationUnit) {
		this.declarationUnit = declarationUnit;
	}

	public BigDecimal getSurplusFund() {
		return surplusFund;
	}

	public void setSurplusFund(BigDecimal surplusFund) {
		this.surplusFund = surplusFund;
	}

	public String getErpPurchase() {
		return erpPurchase;
	}

	public void setErpPurchase(String erpPurchase) {
		this.erpPurchase = erpPurchase;
	}

	public String getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(String purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public BigDecimal getContractPrice() {
		return contractPrice;
	}

	public void setContractPrice(BigDecimal contractPrice) {
		this.contractPrice = contractPrice;
	}

	public BigDecimal getDelivery() {
		return delivery;
	}

	public void setDelivery(BigDecimal delivery) {
		this.delivery = delivery;
	}

	public BigDecimal getMetaphase() {
		return metaphase;
	}

	public void setMetaphase(BigDecimal metaphase) {
		this.metaphase = metaphase;
	}

	public BigDecimal getArrears() {
		return arrears;
	}

	public void setArrears(BigDecimal arrears) {
		this.arrears = arrears;
	}

	public BigDecimal getAccumulative() {
		return accumulative;
	}

	public void setAccumulative(BigDecimal accumulative) {
		this.accumulative = accumulative;
	}

	public String getEquipmentClassification() {
		return equipmentClassification;
	}

	public void setEquipmentClassification(String equipmentClassification) {
		this.equipmentClassification = equipmentClassification;
	}

	public String getVersionSpecificationModel() {
		return versionSpecificationModel;
	}

	public void setVersionSpecificationModel(String versionSpecificationModel) {
		this.versionSpecificationModel = versionSpecificationModel;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getUseDepartment() {
		return useDepartment;
	}

	public void setUseDepartment(String useDepartment) {
		this.useDepartment = useDepartment;
	}

	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
	}

	public String getFixedAssetsNumber() {
		return fixedAssetsNumber;
	}

	public void setFixedAssetsNumber(String fixedAssetsNumber) {
		this.fixedAssetsNumber = fixedAssetsNumber;
	}

	public String getTransferFunds() {
		return transferFunds;
	}

	public void setTransferFunds(String transferFunds) {
		this.transferFunds = transferFunds;
	}

	public String getInstallationLocation() {
		return installationLocation;
	}

	public void setInstallationLocation(String installationLocation) {
		this.installationLocation = installationLocation;
	}

	public String getScrap() {
		return scrap;
	}

	public void setScrap(String scrap) {
		this.scrap = scrap;
	}

	@Override
	public String toString() {
		return "SrePlanCompletion [projectName=" + projectName + ", equipmentName=" + equipmentName + ", erpNetwork="
				+ erpNetwork + ", projectPrice=" + projectPrice + ", equipmentType=" + equipmentType
				+ ", declarationUnit=" + declarationUnit + ", surplusFund=" + surplusFund + ", erpPurchase="
				+ erpPurchase + ", purchaseOrder=" + purchaseOrder + ", contractNumber=" + contractNumber
				+ ", supplier=" + supplier + ", contractPrice=" + contractPrice + ", delivery=" + delivery
				+ ", metaphase=" + metaphase + ", arrears=" + arrears + ", accumulative=" + accumulative
				+ ", equipmentClassification=" + equipmentClassification + ", versionSpecificationModel="
				+ versionSpecificationModel + ", price=" + price + ", number=" + number + ", totalPrice=" + totalPrice
				+ ", useDepartment=" + useDepartment + ", use=" + use + ", fixedAssetsNumber=" + fixedAssetsNumber
				+ ", transferFunds=" + transferFunds + ", installationLocation=" + installationLocation + ", scrap="
				+ scrap + "]";
	}
	
	
}