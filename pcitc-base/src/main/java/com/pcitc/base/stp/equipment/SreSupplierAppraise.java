package com.pcitc.base.stp.equipment;

import java.util.Date;

public class SreSupplierAppraise {
    private String id;

    private String equipmentDetailId;

    private String applicationsSituation;

    private String maintenanceSituation;

    private String supplierAppraise;

    private String equipmentOverallAppraise;

    private Date createDate;

    private Date updateDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEquipmentDetailId() {
        return equipmentDetailId;
    }

    public void setEquipmentDetailId(String equipmentDetailId) {
        this.equipmentDetailId = equipmentDetailId;
    }

    public String getApplicationsSituation() {
        return applicationsSituation;
    }

    public void setApplicationsSituation(String applicationsSituation) {
        this.applicationsSituation = applicationsSituation;
    }

    public String getMaintenanceSituation() {
        return maintenanceSituation;
    }

    public void setMaintenanceSituation(String maintenanceSituation) {
        this.maintenanceSituation = maintenanceSituation;
    }

    public String getSupplierAppraise() {
        return supplierAppraise;
    }

    public void setSupplierAppraise(String supplierAppraise) {
        this.supplierAppraise = supplierAppraise;
    }

    public String getEquipmentOverallAppraise() {
        return equipmentOverallAppraise;
    }

    public void setEquipmentOverallAppraise(String equipmentOverallAppraise) {
        this.equipmentOverallAppraise = equipmentOverallAppraise;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}