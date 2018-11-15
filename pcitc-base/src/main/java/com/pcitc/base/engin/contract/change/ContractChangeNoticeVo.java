package com.pcitc.base.engin.contract.change;

import java.io.Serializable;

import com.pcitc.base.util.SearchInfo;

/**
 * contract_change_notice1
 * @author 
 */
public class ContractChangeNoticeVo extends SearchInfo implements Serializable {
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
     * 数据状态
     */
    private String status;

    /**
     * 创建日期
     */
    private String createDate;

    /**
     * 创建用户
     */
    private String createUser;

    /**
     * 创建用户名称
     */
    private String createUserName;

    /**
     * 修改日期
     */
    private String updateDate;

    /**
     * 修改用户
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
     * 所属项目
     */
    private String projectId;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 审批状态
     */
    private String auditStatus;

    /**
     * 单位编码
     */
    private String unitCode;

    /**
     * 单位名称
     */
    private String unitName;

    /**
     * 单位ID
     */
    private String unitId;

    /**
     * 描述
     */
    private String remarks;

    /**
     * 合同名称
     */
    private String contractName;

    /**
     * 合同编码
     */
    private String contractCode;

    /**
     * 承包商名称
     */
    private String contractorName;

    /**
     * 承包商编码
     */
    private String contractorCode;

    /**
     * 承包商ID
     */
    private String contractorId;

    /**
     * 变更通知编号
     */
    private String changeNoticeNo;

    /**
     * 变更通知名称
     */
    private String changeNoticeName;

    /**
     * 变更发起单位
     */
    private String changeUnitName;

    /**
     * 变更发起单位ID
     */
    private String changeUnitId;

    /**
     * 变更主题
     */
    private String changeTopic;

    /**
     * 变更通知生效日期
     */
    private String changeNoticeEffectDate;

    /**
     * 变更通知发出日期
     */
    private String changeNoticeSendDate;

    /**
     * 变更原因类型
     */
    private String changeReasonType;

    /**
     * 变更价格类型
     */
    private String changePriceType;

    /**
     * 变更内容
     */
    private String changeContent;

    /**
     * 变更原因
     */
    private String changeCause;

    /**
     * 变更种类(0通知1申请)
     */
    private String changeType;

    /**
     * 发起人名称
     */
    private String redactUserName;

    /**
     * 发起人ID
     */
    private String redactUserId;

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

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getContractorName() {
        return contractorName;
    }

    public void setContractorName(String contractorName) {
        this.contractorName = contractorName;
    }

    public String getContractorCode() {
        return contractorCode;
    }

    public void setContractorCode(String contractorCode) {
        this.contractorCode = contractorCode;
    }

    public String getContractorId() {
        return contractorId;
    }

    public void setContractorId(String contractorId) {
        this.contractorId = contractorId;
    }

    public String getChangeNoticeNo() {
        return changeNoticeNo;
    }

    public void setChangeNoticeNo(String changeNoticeNo) {
        this.changeNoticeNo = changeNoticeNo;
    }

    public String getChangeNoticeName() {
        return changeNoticeName;
    }

    public void setChangeNoticeName(String changeNoticeName) {
        this.changeNoticeName = changeNoticeName;
    }

    public String getChangeUnitName() {
        return changeUnitName;
    }

    public void setChangeUnitName(String changeUnitName) {
        this.changeUnitName = changeUnitName;
    }

    public String getChangeUnitId() {
        return changeUnitId;
    }

    public void setChangeUnitId(String changeUnitId) {
        this.changeUnitId = changeUnitId;
    }

    public String getChangeTopic() {
        return changeTopic;
    }

    public void setChangeTopic(String changeTopic) {
        this.changeTopic = changeTopic;
    }

    public String getChangeNoticeEffectDate() {
        return changeNoticeEffectDate;
    }

    public void setChangeNoticeEffectDate(String changeNoticeEffectDate) {
        this.changeNoticeEffectDate = changeNoticeEffectDate;
    }

    public String getChangeNoticeSendDate() {
        return changeNoticeSendDate;
    }

    public void setChangeNoticeSendDate(String changeNoticeSendDate) {
        this.changeNoticeSendDate = changeNoticeSendDate;
    }

    public String getChangeReasonType() {
        return changeReasonType;
    }

    public void setChangeReasonType(String changeReasonType) {
        this.changeReasonType = changeReasonType;
    }

    public String getChangePriceType() {
        return changePriceType;
    }

    public void setChangePriceType(String changePriceType) {
        this.changePriceType = changePriceType;
    }

    public String getChangeContent() {
        return changeContent;
    }

    public void setChangeContent(String changeContent) {
        this.changeContent = changeContent;
    }

    public String getChangeCause() {
        return changeCause;
    }

    public void setChangeCause(String changeCause) {
        this.changeCause = changeCause;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    public String getRedactUserName() {
        return redactUserName;
    }

    public void setRedactUserName(String redactUserName) {
        this.redactUserName = redactUserName;
    }

    public String getRedactUserId() {
        return redactUserId;
    }

    public void setRedactUserId(String redactUserId) {
        this.redactUserId = redactUserId;
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
        ContractChangeNoticeVo other = (ContractChangeNoticeVo) that;
        return (this.getDataId() == null ? other.getDataId() == null : this.getDataId().equals(other.getDataId()))
            && (this.getDataCode() == null ? other.getDataCode() == null : this.getDataCode().equals(other.getDataCode()))
            && (this.getDataOrder() == null ? other.getDataOrder() == null : this.getDataOrder().equals(other.getDataOrder()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getCreateUserName() == null ? other.getCreateUserName() == null : this.getCreateUserName().equals(other.getCreateUserName()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getUpdateUserName() == null ? other.getUpdateUserName() == null : this.getUpdateUserName().equals(other.getUpdateUserName()))
            && (this.getProjectCode() == null ? other.getProjectCode() == null : this.getProjectCode().equals(other.getProjectCode()))
            && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getProjectName() == null ? other.getProjectName() == null : this.getProjectName().equals(other.getProjectName()))
            && (this.getAuditStatus() == null ? other.getAuditStatus() == null : this.getAuditStatus().equals(other.getAuditStatus()))
            && (this.getUnitCode() == null ? other.getUnitCode() == null : this.getUnitCode().equals(other.getUnitCode()))
            && (this.getUnitName() == null ? other.getUnitName() == null : this.getUnitName().equals(other.getUnitName()))
            && (this.getUnitId() == null ? other.getUnitId() == null : this.getUnitId().equals(other.getUnitId()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
            && (this.getContractName() == null ? other.getContractName() == null : this.getContractName().equals(other.getContractName()))
            && (this.getContractCode() == null ? other.getContractCode() == null : this.getContractCode().equals(other.getContractCode()))
            && (this.getContractorName() == null ? other.getContractorName() == null : this.getContractorName().equals(other.getContractorName()))
            && (this.getContractorCode() == null ? other.getContractorCode() == null : this.getContractorCode().equals(other.getContractorCode()))
            && (this.getContractorId() == null ? other.getContractorId() == null : this.getContractorId().equals(other.getContractorId()))
            && (this.getChangeNoticeNo() == null ? other.getChangeNoticeNo() == null : this.getChangeNoticeNo().equals(other.getChangeNoticeNo()))
            && (this.getChangeNoticeName() == null ? other.getChangeNoticeName() == null : this.getChangeNoticeName().equals(other.getChangeNoticeName()))
            && (this.getChangeUnitName() == null ? other.getChangeUnitName() == null : this.getChangeUnitName().equals(other.getChangeUnitName()))
            && (this.getChangeUnitId() == null ? other.getChangeUnitId() == null : this.getChangeUnitId().equals(other.getChangeUnitId()))
            && (this.getChangeTopic() == null ? other.getChangeTopic() == null : this.getChangeTopic().equals(other.getChangeTopic()))
            && (this.getChangeNoticeEffectDate() == null ? other.getChangeNoticeEffectDate() == null : this.getChangeNoticeEffectDate().equals(other.getChangeNoticeEffectDate()))
            && (this.getChangeNoticeSendDate() == null ? other.getChangeNoticeSendDate() == null : this.getChangeNoticeSendDate().equals(other.getChangeNoticeSendDate()))
            && (this.getChangeReasonType() == null ? other.getChangeReasonType() == null : this.getChangeReasonType().equals(other.getChangeReasonType()))
            && (this.getChangePriceType() == null ? other.getChangePriceType() == null : this.getChangePriceType().equals(other.getChangePriceType()))
            && (this.getChangeContent() == null ? other.getChangeContent() == null : this.getChangeContent().equals(other.getChangeContent()))
            && (this.getChangeCause() == null ? other.getChangeCause() == null : this.getChangeCause().equals(other.getChangeCause()))
            && (this.getChangeType() == null ? other.getChangeType() == null : this.getChangeType().equals(other.getChangeType()))
            && (this.getRedactUserName() == null ? other.getRedactUserName() == null : this.getRedactUserName().equals(other.getRedactUserName()))
            && (this.getRedactUserId() == null ? other.getRedactUserId() == null : this.getRedactUserId().equals(other.getRedactUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataId() == null) ? 0 : getDataId().hashCode());
        result = prime * result + ((getDataCode() == null) ? 0 : getDataCode().hashCode());
        result = prime * result + ((getDataOrder() == null) ? 0 : getDataOrder().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateUserName() == null) ? 0 : getCreateUserName().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateUserName() == null) ? 0 : getUpdateUserName().hashCode());
        result = prime * result + ((getProjectCode() == null) ? 0 : getProjectCode().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getProjectName() == null) ? 0 : getProjectName().hashCode());
        result = prime * result + ((getAuditStatus() == null) ? 0 : getAuditStatus().hashCode());
        result = prime * result + ((getUnitCode() == null) ? 0 : getUnitCode().hashCode());
        result = prime * result + ((getUnitName() == null) ? 0 : getUnitName().hashCode());
        result = prime * result + ((getUnitId() == null) ? 0 : getUnitId().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getContractName() == null) ? 0 : getContractName().hashCode());
        result = prime * result + ((getContractCode() == null) ? 0 : getContractCode().hashCode());
        result = prime * result + ((getContractorName() == null) ? 0 : getContractorName().hashCode());
        result = prime * result + ((getContractorCode() == null) ? 0 : getContractorCode().hashCode());
        result = prime * result + ((getContractorId() == null) ? 0 : getContractorId().hashCode());
        result = prime * result + ((getChangeNoticeNo() == null) ? 0 : getChangeNoticeNo().hashCode());
        result = prime * result + ((getChangeNoticeName() == null) ? 0 : getChangeNoticeName().hashCode());
        result = prime * result + ((getChangeUnitName() == null) ? 0 : getChangeUnitName().hashCode());
        result = prime * result + ((getChangeUnitId() == null) ? 0 : getChangeUnitId().hashCode());
        result = prime * result + ((getChangeTopic() == null) ? 0 : getChangeTopic().hashCode());
        result = prime * result + ((getChangeNoticeEffectDate() == null) ? 0 : getChangeNoticeEffectDate().hashCode());
        result = prime * result + ((getChangeNoticeSendDate() == null) ? 0 : getChangeNoticeSendDate().hashCode());
        result = prime * result + ((getChangeReasonType() == null) ? 0 : getChangeReasonType().hashCode());
        result = prime * result + ((getChangePriceType() == null) ? 0 : getChangePriceType().hashCode());
        result = prime * result + ((getChangeContent() == null) ? 0 : getChangeContent().hashCode());
        result = prime * result + ((getChangeCause() == null) ? 0 : getChangeCause().hashCode());
        result = prime * result + ((getChangeType() == null) ? 0 : getChangeType().hashCode());
        result = prime * result + ((getRedactUserName() == null) ? 0 : getRedactUserName().hashCode());
        result = prime * result + ((getRedactUserId() == null) ? 0 : getRedactUserId().hashCode());
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
        sb.append(", createDate=").append(createDate);
        sb.append(", createUser=").append(createUser);
        sb.append(", createUserName=").append(createUserName);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateUserName=").append(updateUserName);
        sb.append(", projectCode=").append(projectCode);
        sb.append(", projectId=").append(projectId);
        sb.append(", projectName=").append(projectName);
        sb.append(", auditStatus=").append(auditStatus);
        sb.append(", unitCode=").append(unitCode);
        sb.append(", unitName=").append(unitName);
        sb.append(", unitId=").append(unitId);
        sb.append(", remarks=").append(remarks);
        sb.append(", contractName=").append(contractName);
        sb.append(", contractCode=").append(contractCode);
        sb.append(", contractorName=").append(contractorName);
        sb.append(", contractorCode=").append(contractorCode);
        sb.append(", contractorId=").append(contractorId);
        sb.append(", changeNoticeNo=").append(changeNoticeNo);
        sb.append(", changeNoticeName=").append(changeNoticeName);
        sb.append(", changeUnitName=").append(changeUnitName);
        sb.append(", changeUnitId=").append(changeUnitId);
        sb.append(", changeTopic=").append(changeTopic);
        sb.append(", changeNoticeEffectDate=").append(changeNoticeEffectDate);
        sb.append(", changeNoticeSendDate=").append(changeNoticeSendDate);
        sb.append(", changeReasonType=").append(changeReasonType);
        sb.append(", changePriceType=").append(changePriceType);
        sb.append(", changeContent=").append(changeContent);
        sb.append(", changeCause=").append(changeCause);
        sb.append(", changeType=").append(changeType);
        sb.append(", redactUserName=").append(redactUserName);
        sb.append(", redactUserId=").append(redactUserId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}