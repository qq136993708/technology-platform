package com.pcitc.base.stp.equipment;

import java.util.Date;

public class SreDetail {
    private String id;

    private String equipmentId;

    private String equipmentName;

    private String equipmentType;

    private String equipmentPrice;

    private String equipmenNumber;

    private String declareUnit;

    private String declareDepartment;

    private String declarePeople;

    private Date declareTime;

    private String assetNumber;

    private String configure;

    private String measuringUnit;

    private String assetsClassification;

    private String nationality;

    private String placeUse;

    private String placePeople;

    private String receivePeople;

    private String specification;
    
    private Date arrivaldate;
    
    private String supplier;
    
    private String isscrap;
    
    private String unitPathIds;

    private String parentUnitPathIds;
    
    public String getIsscrap() {
		return isscrap;
	}

	public void setIsscrap(String isscrap) {
		this.isscrap = isscrap;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public Date getArrivaldate() {
		return arrivaldate;
	}

	public void setArrivaldate(Date arrivaldate) {
		this.arrivaldate = arrivaldate;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
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

    public String getDeclareDepartment() {
        return declareDepartment;
    }

    public void setDeclareDepartment(String declareDepartment) {
        this.declareDepartment = declareDepartment;
    }

    public String getDeclarePeople() {
        return declarePeople;
    }

    public void setDeclarePeople(String declarePeople) {
        this.declarePeople = declarePeople;
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

    public String getConfigure() {
        return configure;
    }

    public void setConfigure(String configure) {
        this.configure = configure;
    }

    public String getMeasuringUnit() {
        return measuringUnit;
    }

    public void setMeasuringUnit(String measuringUnit) {
        this.measuringUnit = measuringUnit;
    }

    public String getAssetsClassification() {
        return assetsClassification;
    }

    public void setAssetsClassification(String assetsClassification) {
        this.assetsClassification = assetsClassification;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPlaceUse() {
        return placeUse;
    }

    public void setPlaceUse(String placeUse) {
        this.placeUse = placeUse;
    }

    public String getPlacePeople() {
        return placePeople;
    }

    public void setPlacePeople(String placePeople) {
        this.placePeople = placePeople;
    }

    public String getReceivePeople() {
        return receivePeople;
    }

    public void setReceivePeople(String receivePeople) {
        this.receivePeople = receivePeople;
    }

    
	public String getUnitPathIds() {
		return unitPathIds;
	}

	public void setUnitPathIds(String unitPathIds) {
		this.unitPathIds = unitPathIds;
	}

	public String getParentUnitPathIds() {
		return parentUnitPathIds;
	}

	public void setParentUnitPathIds(String parentUnitPathIds) {
		this.parentUnitPathIds = parentUnitPathIds;
	}

	@Override
	public String toString() {
		return "SreDetail [id=" + id + ", equipmentId=" + equipmentId + ", equipmentName=" + equipmentName
				+ ", equipmentType=" + equipmentType + ", equipmentPrice=" + equipmentPrice + ", equipmenNumber="
				+ equipmenNumber + ", declareUnit=" + declareUnit + ", declareDepartment=" + declareDepartment
				+ ", declarePeople=" + declarePeople + ", declareTime=" + declareTime + ", assetNumber=" + assetNumber
				+ ", configure=" + configure + ", measuringUnit=" + measuringUnit + ", assetsClassification="
				+ assetsClassification + ", nationality=" + nationality + ", placeUse=" + placeUse + ", placePeople="
				+ placePeople + ", receivePeople=" + receivePeople + ", specification=" + specification
				+ ", arrivaldate=" + arrivaldate + ", supplier=" + supplier + ", isscrap=" + isscrap + ", unitPathIds="
				+ unitPathIds + ", parentUnitPathIds=" + parentUnitPathIds + "]";
	}

	
    
}