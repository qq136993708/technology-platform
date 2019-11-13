package com.pcitc.base.system;

import java.io.Serializable;

/**
 * sys_restfulapi
 * @author 
 */
public class SysRestfulapi implements Serializable {
    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 业务表单状态
     */
    private String status;

    /**
     * 修改时间
     */
    private String updateDate;

    /**
     * 修改人
     */
    private String updateUser;

    /**
     * 业务表单说明/备注/注释
     */
    private String remarks;

    /**
     * 业务表单ID
     */
    private String restfulapiId;

    /**
     * 业务表单编码
     */
    private String restfulapiCode;

    /**
     * 审批状态
     */
    private String auditStatus;

    /**
     * 名称
     */
    private String restfulapiUser;

    /**
     * ip地址
     */
    private String restfulapiAddress;

    /**
     * 接口
     */
    private String restfulapiPort;

    private static final long serialVersionUID = 1L;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRestfulapiId() {
        return restfulapiId;
    }

    public void setRestfulapiId(String restfulapiId) {
        this.restfulapiId = restfulapiId;
    }

    public String getRestfulapiCode() {
        return restfulapiCode;
    }

    public void setRestfulapiCode(String restfulapiCode) {
        this.restfulapiCode = restfulapiCode;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getRestfulapiUser() {
        return restfulapiUser;
    }

    public void setRestfulapiUser(String restfulapiUser) {
        this.restfulapiUser = restfulapiUser;
    }

    public String getRestfulapiAddress() {
        return restfulapiAddress;
    }

    public void setRestfulapiAddress(String restfulapiAddress) {
        this.restfulapiAddress = restfulapiAddress;
    }

    public String getRestfulapiPort() {
        return restfulapiPort;
    }

    public void setRestfulapiPort(String restfulapiPort) {
        this.restfulapiPort = restfulapiPort;
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
        SysRestfulapi other = (SysRestfulapi) that;
        return (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
            && (this.getRestfulapiId() == null ? other.getRestfulapiId() == null : this.getRestfulapiId().equals(other.getRestfulapiId()))
            && (this.getRestfulapiCode() == null ? other.getRestfulapiCode() == null : this.getRestfulapiCode().equals(other.getRestfulapiCode()))
            && (this.getAuditStatus() == null ? other.getAuditStatus() == null : this.getAuditStatus().equals(other.getAuditStatus()))
            && (this.getRestfulapiUser() == null ? other.getRestfulapiUser() == null : this.getRestfulapiUser().equals(other.getRestfulapiUser()))
            && (this.getRestfulapiAddress() == null ? other.getRestfulapiAddress() == null : this.getRestfulapiAddress().equals(other.getRestfulapiAddress()))
            && (this.getRestfulapiPort() == null ? other.getRestfulapiPort() == null : this.getRestfulapiPort().equals(other.getRestfulapiPort()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getRestfulapiId() == null) ? 0 : getRestfulapiId().hashCode());
        result = prime * result + ((getRestfulapiCode() == null) ? 0 : getRestfulapiCode().hashCode());
        result = prime * result + ((getAuditStatus() == null) ? 0 : getAuditStatus().hashCode());
        result = prime * result + ((getRestfulapiUser() == null) ? 0 : getRestfulapiUser().hashCode());
        result = prime * result + ((getRestfulapiAddress() == null) ? 0 : getRestfulapiAddress().hashCode());
        result = prime * result + ((getRestfulapiPort() == null) ? 0 : getRestfulapiPort().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", createUser=").append(createUser);
        sb.append(", createDate=").append(createDate);
        sb.append(", status=").append(status);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", remarks=").append(remarks);
        sb.append(", restfulapiId=").append(restfulapiId);
        sb.append(", restfulapiCode=").append(restfulapiCode);
        sb.append(", auditStatus=").append(auditStatus);
        sb.append(", restfulapiUser=").append(restfulapiUser);
        sb.append(", restfulapiAddress=").append(restfulapiAddress);
        sb.append(", restfulapiPort=").append(restfulapiPort);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}