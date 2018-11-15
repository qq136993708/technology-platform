package com.pcitc.base.engin.construct.design;

import java.io.Serializable;

/**
 * construct_organization_design
 * @author 
 */
public class ConstructOrganizationDesign implements Serializable {
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
     * 施工组织设计文件名称
     */
    private String fileName;

    /**
     * 施工组织设计文件编号
     */
    private String fileNumber;

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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber;
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
        ConstructOrganizationDesign other = (ConstructOrganizationDesign) that;
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
            && (this.getFileName() == null ? other.getFileName() == null : this.getFileName().equals(other.getFileName()))
            && (this.getFileNumber() == null ? other.getFileNumber() == null : this.getFileNumber().equals(other.getFileNumber()))
            && (this.getApplyCompany() == null ? other.getApplyCompany() == null : this.getApplyCompany().equals(other.getApplyCompany()))
            && (this.getApplyUser() == null ? other.getApplyUser() == null : this.getApplyUser().equals(other.getApplyUser()))
            && (this.getApplyDate() == null ? other.getApplyDate() == null : this.getApplyDate().equals(other.getApplyDate()))
            && (this.getAttachId() == null ? other.getAttachId() == null : this.getAttachId().equals(other.getAttachId()));
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
        result = prime * result + ((getFileName() == null) ? 0 : getFileName().hashCode());
        result = prime * result + ((getFileNumber() == null) ? 0 : getFileNumber().hashCode());
        result = prime * result + ((getApplyCompany() == null) ? 0 : getApplyCompany().hashCode());
        result = prime * result + ((getApplyUser() == null) ? 0 : getApplyUser().hashCode());
        result = prime * result + ((getApplyDate() == null) ? 0 : getApplyDate().hashCode());
        result = prime * result + ((getAttachId() == null) ? 0 : getAttachId().hashCode());
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
        sb.append(", fileName=").append(fileName);
        sb.append(", fileNumber=").append(fileNumber);
        sb.append(", applyCompany=").append(applyCompany);
        sb.append(", applyUser=").append(applyUser);
        sb.append(", applyDate=").append(applyDate);
        sb.append(", attachId=").append(attachId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}