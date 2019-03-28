package com.pcitc.base.stp.equipment;

import java.util.Date;

public class SrePurchase {
    private String id;

    private String purchaseName;

    private String departName;

    private Integer stage;

    private Integer state;

    private Date createDate;

    private String proposerName;

    private String equipmentId;

    private String parentUnitPathNames;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPurchaseName() {
        return purchaseName;
    }

    public void setPurchaseName(String purchaseName) {
        this.purchaseName = purchaseName;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public Integer getStage() {
        return stage;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getProposerName() {
        return proposerName;
    }

    public void setProposerName(String proposerName) {
        this.proposerName = proposerName;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getParentUnitPathNames() {
        return parentUnitPathNames;
    }

    public void setParentUnitPathNames(String parentUnitPathNames) {
        this.parentUnitPathNames = parentUnitPathNames;
    }
}