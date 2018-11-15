package com.pcitc.base.engin.hse.workpermit;

import java.io.Serializable;

/**
 * hse_security_measures
 * @author 
 */
public class HseSecurityMeasuresVo implements Serializable {
    /**
     * 安全措施id
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
     * 最后修改人
     */
    private String updateUser;

    /**
     * 最后修改人
     */
    private String updateDate;

    /**
     * 记录状态：删除、停用、正常
     */
    private String status;

    /**
     * 审批状态：草稿、待审批、已审批
     */
    private String auditStatus;

    /**
     * 公司代码
     */
    private String companyCode;

    /**
     * 所属项目
     */
    private String projectId;

    /**
     * 业务编码
     */
    private String formCode;

    /**
     * 作业许可证id
     */
    private String permitId;

    /**
     * 作业许可证类型:夜间、土方、用电等等
     */
    private String permitType;

    /**
     * 安全措施
     */
    private String securityMeasures;

    /**
     * 确认人签字
     */
    private String confirSignature;

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

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getFormCode() {
        return formCode;
    }

    public void setFormCode(String formCode) {
        this.formCode = formCode;
    }

    public String getPermitId() {
        return permitId;
    }

    public void setPermitId(String permitId) {
        this.permitId = permitId;
    }

    public String getPermitType() {
        return permitType;
    }

    public void setPermitType(String permitType) {
        this.permitType = permitType;
    }

    public String getSecurityMeasures() {
        return securityMeasures;
    }

    public void setSecurityMeasures(String securityMeasures) {
        this.securityMeasures = securityMeasures;
    }

    public String getConfirSignature() {
        return confirSignature;
    }

    public void setConfirSignature(String confirSignature) {
        this.confirSignature = confirSignature;
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
        HseSecurityMeasuresVo other = (HseSecurityMeasuresVo) that;
        return (this.getDataId() == null ? other.getDataId() == null : this.getDataId().equals(other.getDataId()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getAuditStatus() == null ? other.getAuditStatus() == null : this.getAuditStatus().equals(other.getAuditStatus()))
            && (this.getCompanyCode() == null ? other.getCompanyCode() == null : this.getCompanyCode().equals(other.getCompanyCode()))
            && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getFormCode() == null ? other.getFormCode() == null : this.getFormCode().equals(other.getFormCode()))
            && (this.getPermitId() == null ? other.getPermitId() == null : this.getPermitId().equals(other.getPermitId()))
            && (this.getPermitType() == null ? other.getPermitType() == null : this.getPermitType().equals(other.getPermitType()))
            && (this.getSecurityMeasures() == null ? other.getSecurityMeasures() == null : this.getSecurityMeasures().equals(other.getSecurityMeasures()))
            && (this.getConfirSignature() == null ? other.getConfirSignature() == null : this.getConfirSignature().equals(other.getConfirSignature()));
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
        result = prime * result + ((getCompanyCode() == null) ? 0 : getCompanyCode().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getFormCode() == null) ? 0 : getFormCode().hashCode());
        result = prime * result + ((getPermitId() == null) ? 0 : getPermitId().hashCode());
        result = prime * result + ((getPermitType() == null) ? 0 : getPermitType().hashCode());
        result = prime * result + ((getSecurityMeasures() == null) ? 0 : getSecurityMeasures().hashCode());
        result = prime * result + ((getConfirSignature() == null) ? 0 : getConfirSignature().hashCode());
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
        sb.append(", companyCode=").append(companyCode);
        sb.append(", projectId=").append(projectId);
        sb.append(", formCode=").append(formCode);
        sb.append(", permitId=").append(permitId);
        sb.append(", permitType=").append(permitType);
        sb.append(", securityMeasures=").append(securityMeasures);
        sb.append(", confirSignature=").append(confirSignature);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}