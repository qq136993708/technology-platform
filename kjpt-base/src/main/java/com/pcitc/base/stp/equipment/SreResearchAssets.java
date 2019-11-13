package com.pcitc.base.stp.equipment;

import java.util.Date;

public class SreResearchAssets {
   
	private String applicationName;

	private Date applicationTime;

	private String applicationUserName;
	
	private String applyDepartName;
	
	private String equipmentName;

	private String equipmentType;

	private String equipmentPrice;

	private String equipmenNumber;
	
	private String declareUnit;
	
	private Date declareTime;

    private String assetNumber;
    
    private String isscrap;

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public Date getApplicationTime() {
		return applicationTime;
	}

	public void setApplicationTime(Date applicationTime) {
		this.applicationTime = applicationTime;
	}

	public String getApplicationUserName() {
		return applicationUserName;
	}

	public void setApplicationUserName(String applicationUserName) {
		this.applicationUserName = applicationUserName;
	}

	public String getApplyDepartName() {
		return applyDepartName;
	}

	public void setApplyDepartName(String applyDepartName) {
		this.applyDepartName = applyDepartName;
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public String getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}

	public String getEquipmentPrice() {
		return equipmentPrice;
	}

	public void setEquipmentPrice(String equipmentPrice) {
		this.equipmentPrice = equipmentPrice;
	}

	public String getEquipmenNumber() {
		return equipmenNumber;
	}

	public void setEquipmenNumber(String equipmenNumber) {
		this.equipmenNumber = equipmenNumber;
	}

	public String getDeclareUnit() {
		return declareUnit;
	}

	public void setDeclareUnit(String declareUnit) {
		this.declareUnit = declareUnit;
	}

	public Date getDeclareTime() {
		return declareTime;
	}

	public void setDeclareTime(Date declareTime) {
		this.declareTime = declareTime;
	}

	public String getAssetNumber() {
		return assetNumber;
	}

	public void setAssetNumber(String assetNumber) {
		this.assetNumber = assetNumber;
	}

	public String getIsscrap() {
		return isscrap;
	}

	public void setIsscrap(String isscrap) {
		this.isscrap = isscrap;
	}

	@Override
	public String toString() {
		return "SreResearchAssets [applicationName=" + applicationName + ", applicationTime=" + applicationTime
				+ ", applicationUserName=" + applicationUserName + ", applyDepartName=" + applyDepartName
				+ ", equipmentName=" + equipmentName + ", equipmentType=" + equipmentType + ", equipmentPrice="
				+ equipmentPrice + ", equipmenNumber=" + equipmenNumber + ", declareUnit=" + declareUnit
				+ ", declareTime=" + declareTime + ", assetNumber=" + assetNumber + ", isscrap=" + isscrap
				+ ", getApplicationName()=" + getApplicationName() + ", getApplicationTime()=" + getApplicationTime()
				+ ", getApplicationUserName()=" + getApplicationUserName() + ", getApplyDepartName()="
				+ getApplyDepartName() + ", getEquipmentName()=" + getEquipmentName() + ", getEquipmentType()="
				+ getEquipmentType() + ", getEquipmentPrice()=" + getEquipmentPrice() + ", getEquipmenNumber()="
				+ getEquipmenNumber() + ", getDeclareUnit()=" + getDeclareUnit() + ", getDeclareTime()="
				+ getDeclareTime() + ", getAssetNumber()=" + getAssetNumber() + ", getIsscrap()=" + getIsscrap()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
    
    
}