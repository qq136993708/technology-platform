package com.pcitc.base.engin.construct.prepare;

import java.io.Serializable;

/**
 * construct_rework_report
 * @author 
 */
public class ConstructReworkReport implements Serializable {
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
     * 项目名称
     */
    private String projectName;

    /**
     * 项目编号
     */
    private String projectNumber;

    /**
     * 项目wbs名称
     */
    private String projectWbsName;

    /**
     * 项目wbs编号
     */
    private String projectWbsNumber;

    /**
     * 合同名称
     */
    private String contractName;

    /**
     * 合同编号
     */
    private String contractNumber;

    /**
     * 复工报告名称
     */
    private String reworkReportName;

    /**
     * 复工报告编号
     */
    private String reworkReportNumber;

    /**
     * 计划复工时间
     */
    private String planReworkDate;

    /**
     * 申请单位
     */
    private String applyCompany;

    /**
     * 申请人
     */
    private String applyUser;

    /**
     * 申请日期
     */
    private String applyDate;

    /**
     * 附件
     */
    private String attachId;

    /**
     * 复工说明
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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getProjectWbsName() {
        return projectWbsName;
    }

    public void setProjectWbsName(String projectWbsName) {
        this.projectWbsName = projectWbsName;
    }

    public String getProjectWbsNumber() {
        return projectWbsNumber;
    }

    public void setProjectWbsNumber(String projectWbsNumber) {
        this.projectWbsNumber = projectWbsNumber;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getReworkReportName() {
        return reworkReportName;
    }

    public void setReworkReportName(String reworkReportName) {
        this.reworkReportName = reworkReportName;
    }

    public String getReworkReportNumber() {
        return reworkReportNumber;
    }

    public void setReworkReportNumber(String reworkReportNumber) {
        this.reworkReportNumber = reworkReportNumber;
    }

    public String getPlanReworkDate() {
        return planReworkDate;
    }

    public void setPlanReworkDate(String planReworkDate) {
        this.planReworkDate = planReworkDate;
    }

    public String getApplyCompany() {
        return applyCompany;
    }

    public void setApplyCompany(String applyCompany) {
        this.applyCompany = applyCompany;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public String getAttachId() {
        return attachId;
    }

    public void setAttachId(String attachId) {
        this.attachId = attachId;
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
        ConstructReworkReport other = (ConstructReworkReport) that;
        return (this.getDataId() == null ? other.getDataId() == null : this.getDataId().equals(other.getDataId()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getAuditStatus() == null ? other.getAuditStatus() == null : this.getAuditStatus().equals(other.getAuditStatus()))
            && (this.getProjectName() == null ? other.getProjectName() == null : this.getProjectName().equals(other.getProjectName()))
            && (this.getProjectNumber() == null ? other.getProjectNumber() == null : this.getProjectNumber().equals(other.getProjectNumber()))
            && (this.getProjectWbsName() == null ? other.getProjectWbsName() == null : this.getProjectWbsName().equals(other.getProjectWbsName()))
            && (this.getProjectWbsNumber() == null ? other.getProjectWbsNumber() == null : this.getProjectWbsNumber().equals(other.getProjectWbsNumber()))
            && (this.getContractName() == null ? other.getContractName() == null : this.getContractName().equals(other.getContractName()))
            && (this.getContractNumber() == null ? other.getContractNumber() == null : this.getContractNumber().equals(other.getContractNumber()))
            && (this.getReworkReportName() == null ? other.getReworkReportName() == null : this.getReworkReportName().equals(other.getReworkReportName()))
            && (this.getReworkReportNumber() == null ? other.getReworkReportNumber() == null : this.getReworkReportNumber().equals(other.getReworkReportNumber()))
            && (this.getPlanReworkDate() == null ? other.getPlanReworkDate() == null : this.getPlanReworkDate().equals(other.getPlanReworkDate()))
            && (this.getApplyCompany() == null ? other.getApplyCompany() == null : this.getApplyCompany().equals(other.getApplyCompany()))
            && (this.getApplyUser() == null ? other.getApplyUser() == null : this.getApplyUser().equals(other.getApplyUser()))
            && (this.getApplyDate() == null ? other.getApplyDate() == null : this.getApplyDate().equals(other.getApplyDate()))
            && (this.getAttachId() == null ? other.getAttachId() == null : this.getAttachId().equals(other.getAttachId()))
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
        result = prime * result + ((getProjectName() == null) ? 0 : getProjectName().hashCode());
        result = prime * result + ((getProjectNumber() == null) ? 0 : getProjectNumber().hashCode());
        result = prime * result + ((getProjectWbsName() == null) ? 0 : getProjectWbsName().hashCode());
        result = prime * result + ((getProjectWbsNumber() == null) ? 0 : getProjectWbsNumber().hashCode());
        result = prime * result + ((getContractName() == null) ? 0 : getContractName().hashCode());
        result = prime * result + ((getContractNumber() == null) ? 0 : getContractNumber().hashCode());
        result = prime * result + ((getReworkReportName() == null) ? 0 : getReworkReportName().hashCode());
        result = prime * result + ((getReworkReportNumber() == null) ? 0 : getReworkReportNumber().hashCode());
        result = prime * result + ((getPlanReworkDate() == null) ? 0 : getPlanReworkDate().hashCode());
        result = prime * result + ((getApplyCompany() == null) ? 0 : getApplyCompany().hashCode());
        result = prime * result + ((getApplyUser() == null) ? 0 : getApplyUser().hashCode());
        result = prime * result + ((getApplyDate() == null) ? 0 : getApplyDate().hashCode());
        result = prime * result + ((getAttachId() == null) ? 0 : getAttachId().hashCode());
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
        sb.append(", projectName=").append(projectName);
        sb.append(", projectNumber=").append(projectNumber);
        sb.append(", projectWbsName=").append(projectWbsName);
        sb.append(", projectWbsNumber=").append(projectWbsNumber);
        sb.append(", contractName=").append(contractName);
        sb.append(", contractNumber=").append(contractNumber);
        sb.append(", reworkReportName=").append(reworkReportName);
        sb.append(", reworkReportNumber=").append(reworkReportNumber);
        sb.append(", planReworkDate=").append(planReworkDate);
        sb.append(", applyCompany=").append(applyCompany);
        sb.append(", applyUser=").append(applyUser);
        sb.append(", applyDate=").append(applyDate);
        sb.append(", attachId=").append(attachId);
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}