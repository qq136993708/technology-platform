package com.pcitc.base.engin.mobile.deviceManage;

import java.io.Serializable;

/**
 * mobile_device_manage
 * @author 
 */
public class MobileDeviceManage implements Serializable {
    /**
     * 业务ID
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
     * 修改时间
     */
    private String updateDate;

    /**
     * 业务表单状态
     */
    private String status;

    /**
     * 审批状态
     */
    private String auditStatus;

    /**
     * 用户ID
     */
    private String deviceUserid;

    /**
     * 用户名
     */
    private String deviceUser;

    /**
     * 姓名
     */
    private String deviceUserName;

    /**
     * 所属部门
     */
    private String deviceDepartment;

    /**
     * 设备编号
     */
    private String deviceCode;

    /**
     * 手机唯一识别号
     */
    private String deviceOnlyCode;

    /**
     * 设备类型
     */
    private String deviceType;

    /**
     * 设备型号
     */
    private String deviceModel;

    /**
     * 说明
     */
    private String remarks;

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

    public String getDeviceUserid() {
        return deviceUserid;
    }

    public void setDeviceUserid(String deviceUserid) {
        this.deviceUserid = deviceUserid;
    }

    public String getDeviceUser() {
        return deviceUser;
    }

    public void setDeviceUser(String deviceUser) {
        this.deviceUser = deviceUser;
    }

    public String getDeviceUserName() {
        return deviceUserName;
    }

    public void setDeviceUserName(String deviceUserName) {
        this.deviceUserName = deviceUserName;
    }

    public String getDeviceDepartment() {
        return deviceDepartment;
    }

    public void setDeviceDepartment(String deviceDepartment) {
        this.deviceDepartment = deviceDepartment;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getDeviceOnlyCode() {
        return deviceOnlyCode;
    }

    public void setDeviceOnlyCode(String deviceOnlyCode) {
        this.deviceOnlyCode = deviceOnlyCode;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        MobileDeviceManage other = (MobileDeviceManage) that;
        return (this.getDataId() == null ? other.getDataId() == null : this.getDataId().equals(other.getDataId()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getAuditStatus() == null ? other.getAuditStatus() == null : this.getAuditStatus().equals(other.getAuditStatus()))
            && (this.getDeviceUserid() == null ? other.getDeviceUserid() == null : this.getDeviceUserid().equals(other.getDeviceUserid()))
            && (this.getDeviceUser() == null ? other.getDeviceUser() == null : this.getDeviceUser().equals(other.getDeviceUser()))
            && (this.getDeviceUserName() == null ? other.getDeviceUserName() == null : this.getDeviceUserName().equals(other.getDeviceUserName()))
            && (this.getDeviceDepartment() == null ? other.getDeviceDepartment() == null : this.getDeviceDepartment().equals(other.getDeviceDepartment()))
            && (this.getDeviceCode() == null ? other.getDeviceCode() == null : this.getDeviceCode().equals(other.getDeviceCode()))
            && (this.getDeviceOnlyCode() == null ? other.getDeviceOnlyCode() == null : this.getDeviceOnlyCode().equals(other.getDeviceOnlyCode()))
            && (this.getDeviceType() == null ? other.getDeviceType() == null : this.getDeviceType().equals(other.getDeviceType()))
            && (this.getDeviceModel() == null ? other.getDeviceModel() == null : this.getDeviceModel().equals(other.getDeviceModel()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataId() == null) ? 0 : getDataId().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getAuditStatus() == null) ? 0 : getAuditStatus().hashCode());
        result = prime * result + ((getDeviceUserid() == null) ? 0 : getDeviceUserid().hashCode());
        result = prime * result + ((getDeviceUser() == null) ? 0 : getDeviceUser().hashCode());
        result = prime * result + ((getDeviceUserName() == null) ? 0 : getDeviceUserName().hashCode());
        result = prime * result + ((getDeviceDepartment() == null) ? 0 : getDeviceDepartment().hashCode());
        result = prime * result + ((getDeviceCode() == null) ? 0 : getDeviceCode().hashCode());
        result = prime * result + ((getDeviceOnlyCode() == null) ? 0 : getDeviceOnlyCode().hashCode());
        result = prime * result + ((getDeviceType() == null) ? 0 : getDeviceType().hashCode());
        result = prime * result + ((getDeviceModel() == null) ? 0 : getDeviceModel().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dataId=").append(dataId);
        sb.append(", createUser=").append(createUser);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", status=").append(status);
        sb.append(", auditStatus=").append(auditStatus);
        sb.append(", deviceUserid=").append(deviceUserid);
        sb.append(", deviceUser=").append(deviceUser);
        sb.append(", deviceUserName=").append(deviceUserName);
        sb.append(", deviceDepartment=").append(deviceDepartment);
        sb.append(", deviceCode=").append(deviceCode);
        sb.append(", deviceOnlyCode=").append(deviceOnlyCode);
        sb.append(", deviceType=").append(deviceType);
        sb.append(", deviceModel=").append(deviceModel);
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}