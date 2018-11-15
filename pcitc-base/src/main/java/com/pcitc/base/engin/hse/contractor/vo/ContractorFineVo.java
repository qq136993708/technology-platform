package com.pcitc.base.engin.hse.contractor.vo;

import java.io.Serializable;

/**
 * hse_contractor_fine
 * @author 
 */
public class ContractorFineVo implements Serializable {
    /**
     * 业务ID
     */
    private String dataId;

    /**
     * 数据编码
     */
    private String dataCode;

    /**
     * 数据排序
     */
    private String dataOrder;

    /**
     * 状态
     */
    private String status;

    /**
     * 是否删除
     */
    private String delFlag;

    /**
     * 创建日期
     */
    private String createDate;

    /**
     * 创建用户ID
     */
    private String createUser;

    /**
     * 创建人名称
     */
    private String createUserName;

    /**
     * 修改日期
     */
    private String updateDate;

    /**
     * 修改用户ID
     */
    private String updateUser;

    /**
     * 修改用户名称
     */
    private String updateUserName;

    /**
     * 项目编码
     */
    private String projectCode;

    /**
     * 项目ID
     */
    private String projectId;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 审批状态
     */
    private String auditSts;

    /**
     * 单位名称
     */
    private String unitName;

    /**
     * 单位编码
     */
    private String unitCode;

    /**
     * 单位ID
     */
    private String unitId;

    /**
     * 工程名称
     */
    private String enginName;

    /**
     * 工程编码
     */
    private String enginCode;

    /**
     * 工程ID
     */
    private String enginId;

    /**
     * 罚款单名称
     */
    private String contractorFineBillName;

    /**
     * 处罚单编码
     */
    private String contractorFineBillCode;

    /**
     * 罚款事由
     */
    private String contractorFineCause;

    /**
     * 承包商类型
     */
    private String contractorType;

    /**
     * 承包商名称
     */
    private String contractorName;

    /**
     * 承包商ID
     */
    private String contractorId;

    /**
     * 承包商编码
     */
    private String contractorCode;

    /**
     * 处罚对象名称
     */
    private String contractorFineUnitName;

    /**
     * 处罚对象编码
     */
    private String contractorFineUnitCode;

    /**
     * 处罚依据
     */
    private String contractorFineGist;

    /**
     * 编制人ID
     */
    private String redactUserId;

    /**
     * 填写人
     */
    private String redactUserName;

    /**
     * 填写日期
     */
    private String redactDate;

    /**
     * 审批人ID
     */
    private String approverId;

    /**
     * 批准人名称
     */
    private String approverName;

    /**
     * 批准日期
     */
    private String ratifyDate;

    /**
     * 处罚分数
     */
    private String fineScore;

    /**
     * 处罚金额
     */
    private String fineMoney;

    /**
     * 是否已缴纳罚款
     */
    private String isProvide;

    /**
     * 备注
     */
    private String remarks;

    private static final long serialVersionUID = 1L;

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getDataCode() {
        return dataCode;
    }

    public void setDataCode(String dataCode) {
        this.dataCode = dataCode;
    }

    public String getDataOrder() {
        return dataOrder;
    }

    public void setDataOrder(String dataOrder) {
        this.dataOrder = dataOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
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

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getAuditSts() {
        return auditSts;
    }

    public void setAuditSts(String auditSts) {
        this.auditSts = auditSts;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getEnginName() {
        return enginName;
    }

    public void setEnginName(String enginName) {
        this.enginName = enginName;
    }

    public String getEnginCode() {
        return enginCode;
    }

    public void setEnginCode(String enginCode) {
        this.enginCode = enginCode;
    }

    public String getEnginId() {
        return enginId;
    }

    public void setEnginId(String enginId) {
        this.enginId = enginId;
    }

    public String getContractorFineBillName() {
        return contractorFineBillName;
    }

    public void setContractorFineBillName(String contractorFineBillName) {
        this.contractorFineBillName = contractorFineBillName;
    }

    public String getContractorFineBillCode() {
        return contractorFineBillCode;
    }

    public void setContractorFineBillCode(String contractorFineBillCode) {
        this.contractorFineBillCode = contractorFineBillCode;
    }

    public String getContractorFineCause() {
        return contractorFineCause;
    }

    public void setContractorFineCause(String contractorFineCause) {
        this.contractorFineCause = contractorFineCause;
    }

    public String getContractorType() {
        return contractorType;
    }

    public void setContractorType(String contractorType) {
        this.contractorType = contractorType;
    }

    public String getContractorName() {
        return contractorName;
    }

    public void setContractorName(String contractorName) {
        this.contractorName = contractorName;
    }

    public String getContractorId() {
        return contractorId;
    }

    public void setContractorId(String contractorId) {
        this.contractorId = contractorId;
    }

    public String getContractorCode() {
        return contractorCode;
    }

    public void setContractorCode(String contractorCode) {
        this.contractorCode = contractorCode;
    }

    public String getContractorFineUnitName() {
        return contractorFineUnitName;
    }

    public void setContractorFineUnitName(String contractorFineUnitName) {
        this.contractorFineUnitName = contractorFineUnitName;
    }

    public String getContractorFineUnitCode() {
        return contractorFineUnitCode;
    }

    public void setContractorFineUnitCode(String contractorFineUnitCode) {
        this.contractorFineUnitCode = contractorFineUnitCode;
    }

    public String getContractorFineGist() {
        return contractorFineGist;
    }

    public void setContractorFineGist(String contractorFineGist) {
        this.contractorFineGist = contractorFineGist;
    }

    public String getRedactUserId() {
        return redactUserId;
    }

    public void setRedactUserId(String redactUserId) {
        this.redactUserId = redactUserId;
    }

    public String getRedactUserName() {
        return redactUserName;
    }

    public void setRedactUserName(String redactUserName) {
        this.redactUserName = redactUserName;
    }

    public String getRedactDate() {
        return redactDate;
    }

    public void setRedactDate(String redactDate) {
        this.redactDate = redactDate;
    }

    public String getApproverId() {
        return approverId;
    }

    public void setApproverId(String approverId) {
        this.approverId = approverId;
    }

    public String getApproverName() {
        return approverName;
    }

    public void setApproverName(String approverName) {
        this.approverName = approverName;
    }

    public String getRatifyDate() {
        return ratifyDate;
    }

    public void setRatifyDate(String ratifyDate) {
        this.ratifyDate = ratifyDate;
    }

    public String getFineScore() {
        return fineScore;
    }

    public void setFineScore(String fineScore) {
        this.fineScore = fineScore;
    }

    public String getFineMoney() {
        return fineMoney;
    }

    public void setFineMoney(String fineMoney) {
        this.fineMoney = fineMoney;
    }

    public String getIsProvide() {
        return isProvide;
    }

    public void setIsProvide(String isProvide) {
        this.isProvide = isProvide;
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
        ContractorFineVo other = (ContractorFineVo) that;
        return (this.getDataId() == null ? other.getDataId() == null : this.getDataId().equals(other.getDataId()))
            && (this.getDataCode() == null ? other.getDataCode() == null : this.getDataCode().equals(other.getDataCode()))
            && (this.getDataOrder() == null ? other.getDataOrder() == null : this.getDataOrder().equals(other.getDataOrder()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getCreateUserName() == null ? other.getCreateUserName() == null : this.getCreateUserName().equals(other.getCreateUserName()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getUpdateUserName() == null ? other.getUpdateUserName() == null : this.getUpdateUserName().equals(other.getUpdateUserName()))
            && (this.getProjectCode() == null ? other.getProjectCode() == null : this.getProjectCode().equals(other.getProjectCode()))
            && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getProjectName() == null ? other.getProjectName() == null : this.getProjectName().equals(other.getProjectName()))
            && (this.getAuditSts() == null ? other.getAuditSts() == null : this.getAuditSts().equals(other.getAuditSts()))
            && (this.getUnitName() == null ? other.getUnitName() == null : this.getUnitName().equals(other.getUnitName()))
            && (this.getUnitCode() == null ? other.getUnitCode() == null : this.getUnitCode().equals(other.getUnitCode()))
            && (this.getUnitId() == null ? other.getUnitId() == null : this.getUnitId().equals(other.getUnitId()))
            && (this.getEnginName() == null ? other.getEnginName() == null : this.getEnginName().equals(other.getEnginName()))
            && (this.getEnginCode() == null ? other.getEnginCode() == null : this.getEnginCode().equals(other.getEnginCode()))
            && (this.getEnginId() == null ? other.getEnginId() == null : this.getEnginId().equals(other.getEnginId()))
            && (this.getContractorFineBillName() == null ? other.getContractorFineBillName() == null : this.getContractorFineBillName().equals(other.getContractorFineBillName()))
            && (this.getContractorFineBillCode() == null ? other.getContractorFineBillCode() == null : this.getContractorFineBillCode().equals(other.getContractorFineBillCode()))
            && (this.getContractorFineCause() == null ? other.getContractorFineCause() == null : this.getContractorFineCause().equals(other.getContractorFineCause()))
            && (this.getContractorType() == null ? other.getContractorType() == null : this.getContractorType().equals(other.getContractorType()))
            && (this.getContractorName() == null ? other.getContractorName() == null : this.getContractorName().equals(other.getContractorName()))
            && (this.getContractorId() == null ? other.getContractorId() == null : this.getContractorId().equals(other.getContractorId()))
            && (this.getContractorCode() == null ? other.getContractorCode() == null : this.getContractorCode().equals(other.getContractorCode()))
            && (this.getContractorFineUnitName() == null ? other.getContractorFineUnitName() == null : this.getContractorFineUnitName().equals(other.getContractorFineUnitName()))
            && (this.getContractorFineUnitCode() == null ? other.getContractorFineUnitCode() == null : this.getContractorFineUnitCode().equals(other.getContractorFineUnitCode()))
            && (this.getContractorFineGist() == null ? other.getContractorFineGist() == null : this.getContractorFineGist().equals(other.getContractorFineGist()))
            && (this.getRedactUserId() == null ? other.getRedactUserId() == null : this.getRedactUserId().equals(other.getRedactUserId()))
            && (this.getRedactUserName() == null ? other.getRedactUserName() == null : this.getRedactUserName().equals(other.getRedactUserName()))
            && (this.getRedactDate() == null ? other.getRedactDate() == null : this.getRedactDate().equals(other.getRedactDate()))
            && (this.getApproverId() == null ? other.getApproverId() == null : this.getApproverId().equals(other.getApproverId()))
            && (this.getApproverName() == null ? other.getApproverName() == null : this.getApproverName().equals(other.getApproverName()))
            && (this.getRatifyDate() == null ? other.getRatifyDate() == null : this.getRatifyDate().equals(other.getRatifyDate()))
            && (this.getFineScore() == null ? other.getFineScore() == null : this.getFineScore().equals(other.getFineScore()))
            && (this.getFineMoney() == null ? other.getFineMoney() == null : this.getFineMoney().equals(other.getFineMoney()))
            && (this.getIsProvide() == null ? other.getIsProvide() == null : this.getIsProvide().equals(other.getIsProvide()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataId() == null) ? 0 : getDataId().hashCode());
        result = prime * result + ((getDataCode() == null) ? 0 : getDataCode().hashCode());
        result = prime * result + ((getDataOrder() == null) ? 0 : getDataOrder().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateUserName() == null) ? 0 : getCreateUserName().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateUserName() == null) ? 0 : getUpdateUserName().hashCode());
        result = prime * result + ((getProjectCode() == null) ? 0 : getProjectCode().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getProjectName() == null) ? 0 : getProjectName().hashCode());
        result = prime * result + ((getAuditSts() == null) ? 0 : getAuditSts().hashCode());
        result = prime * result + ((getUnitName() == null) ? 0 : getUnitName().hashCode());
        result = prime * result + ((getUnitCode() == null) ? 0 : getUnitCode().hashCode());
        result = prime * result + ((getUnitId() == null) ? 0 : getUnitId().hashCode());
        result = prime * result + ((getEnginName() == null) ? 0 : getEnginName().hashCode());
        result = prime * result + ((getEnginCode() == null) ? 0 : getEnginCode().hashCode());
        result = prime * result + ((getEnginId() == null) ? 0 : getEnginId().hashCode());
        result = prime * result + ((getContractorFineBillName() == null) ? 0 : getContractorFineBillName().hashCode());
        result = prime * result + ((getContractorFineBillCode() == null) ? 0 : getContractorFineBillCode().hashCode());
        result = prime * result + ((getContractorFineCause() == null) ? 0 : getContractorFineCause().hashCode());
        result = prime * result + ((getContractorType() == null) ? 0 : getContractorType().hashCode());
        result = prime * result + ((getContractorName() == null) ? 0 : getContractorName().hashCode());
        result = prime * result + ((getContractorId() == null) ? 0 : getContractorId().hashCode());
        result = prime * result + ((getContractorCode() == null) ? 0 : getContractorCode().hashCode());
        result = prime * result + ((getContractorFineUnitName() == null) ? 0 : getContractorFineUnitName().hashCode());
        result = prime * result + ((getContractorFineUnitCode() == null) ? 0 : getContractorFineUnitCode().hashCode());
        result = prime * result + ((getContractorFineGist() == null) ? 0 : getContractorFineGist().hashCode());
        result = prime * result + ((getRedactUserId() == null) ? 0 : getRedactUserId().hashCode());
        result = prime * result + ((getRedactUserName() == null) ? 0 : getRedactUserName().hashCode());
        result = prime * result + ((getRedactDate() == null) ? 0 : getRedactDate().hashCode());
        result = prime * result + ((getApproverId() == null) ? 0 : getApproverId().hashCode());
        result = prime * result + ((getApproverName() == null) ? 0 : getApproverName().hashCode());
        result = prime * result + ((getRatifyDate() == null) ? 0 : getRatifyDate().hashCode());
        result = prime * result + ((getFineScore() == null) ? 0 : getFineScore().hashCode());
        result = prime * result + ((getFineMoney() == null) ? 0 : getFineMoney().hashCode());
        result = prime * result + ((getIsProvide() == null) ? 0 : getIsProvide().hashCode());
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
        sb.append(", dataCode=").append(dataCode);
        sb.append(", dataOrder=").append(dataOrder);
        sb.append(", status=").append(status);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", createDate=").append(createDate);
        sb.append(", createUser=").append(createUser);
        sb.append(", createUserName=").append(createUserName);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateUserName=").append(updateUserName);
        sb.append(", projectCode=").append(projectCode);
        sb.append(", projectId=").append(projectId);
        sb.append(", projectName=").append(projectName);
        sb.append(", auditSts=").append(auditSts);
        sb.append(", unitName=").append(unitName);
        sb.append(", unitCode=").append(unitCode);
        sb.append(", unitId=").append(unitId);
        sb.append(", enginName=").append(enginName);
        sb.append(", enginCode=").append(enginCode);
        sb.append(", enginId=").append(enginId);
        sb.append(", contractorFineBillName=").append(contractorFineBillName);
        sb.append(", contractorFineBillCode=").append(contractorFineBillCode);
        sb.append(", contractorFineCause=").append(contractorFineCause);
        sb.append(", contractorType=").append(contractorType);
        sb.append(", contractorName=").append(contractorName);
        sb.append(", contractorId=").append(contractorId);
        sb.append(", contractorCode=").append(contractorCode);
        sb.append(", contractorFineUnitName=").append(contractorFineUnitName);
        sb.append(", contractorFineUnitCode=").append(contractorFineUnitCode);
        sb.append(", contractorFineGist=").append(contractorFineGist);
        sb.append(", redactUserId=").append(redactUserId);
        sb.append(", redactUserName=").append(redactUserName);
        sb.append(", redactDate=").append(redactDate);
        sb.append(", approverId=").append(approverId);
        sb.append(", approverName=").append(approverName);
        sb.append(", ratifyDate=").append(ratifyDate);
        sb.append(", fineScore=").append(fineScore);
        sb.append(", fineMoney=").append(fineMoney);
        sb.append(", isProvide=").append(isProvide);
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}