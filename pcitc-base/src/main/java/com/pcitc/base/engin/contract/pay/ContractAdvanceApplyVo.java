package com.pcitc.base.engin.contract.pay;

import java.io.Serializable;

/**
 * contract_advance_apply
 * @author 
 */
public class ContractAdvanceApplyVo implements Serializable {
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
     * 合同标的金额
     */
    private String contractMoney;

    /**
     * 工程款类别
     */
    private String projectFundsType;

    /**
     * 付款类型
     */
    private String payType;

    /**
     * 支付方式
     */
    private String payWay;

    /**
     * 币种
     */
    private String currency;

    /**
     * 申请金额
     */
    private String applyMoney;

    /**
     * 实际支付金额
     */
    private String realityMoney;

    /**
     * 实际应付
     */
    private String accountsPayable;

    /**
     * 支付依据
     */
    private String payGist;

    /**
     * 申请日期
     */
    private String applyDate;

    /**
     * 申请人名称
     */
    private String applyUserName;

    /**
     * 申请人ID
     */
    private String applyUserId;

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

    public String getContractMoney() {
        return contractMoney;
    }

    public void setContractMoney(String contractMoney) {
        this.contractMoney = contractMoney;
    }

    public String getProjectFundsType() {
        return projectFundsType;
    }

    public void setProjectFundsType(String projectFundsType) {
        this.projectFundsType = projectFundsType;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getApplyMoney() {
        return applyMoney;
    }

    public void setApplyMoney(String applyMoney) {
        this.applyMoney = applyMoney;
    }

    public String getRealityMoney() {
        return realityMoney;
    }

    public void setRealityMoney(String realityMoney) {
        this.realityMoney = realityMoney;
    }

    public String getAccountsPayable() {
        return accountsPayable;
    }

    public void setAccountsPayable(String accountsPayable) {
        this.accountsPayable = accountsPayable;
    }

    public String getPayGist() {
        return payGist;
    }

    public void setPayGist(String payGist) {
        this.payGist = payGist;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public String getApplyUserName() {
        return applyUserName;
    }

    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName;
    }

    public String getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(String applyUserId) {
        this.applyUserId = applyUserId;
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
        ContractAdvanceApplyVo other = (ContractAdvanceApplyVo) that;
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
            && (this.getContractMoney() == null ? other.getContractMoney() == null : this.getContractMoney().equals(other.getContractMoney()))
            && (this.getProjectFundsType() == null ? other.getProjectFundsType() == null : this.getProjectFundsType().equals(other.getProjectFundsType()))
            && (this.getPayType() == null ? other.getPayType() == null : this.getPayType().equals(other.getPayType()))
            && (this.getPayWay() == null ? other.getPayWay() == null : this.getPayWay().equals(other.getPayWay()))
            && (this.getCurrency() == null ? other.getCurrency() == null : this.getCurrency().equals(other.getCurrency()))
            && (this.getApplyMoney() == null ? other.getApplyMoney() == null : this.getApplyMoney().equals(other.getApplyMoney()))
            && (this.getRealityMoney() == null ? other.getRealityMoney() == null : this.getRealityMoney().equals(other.getRealityMoney()))
            && (this.getAccountsPayable() == null ? other.getAccountsPayable() == null : this.getAccountsPayable().equals(other.getAccountsPayable()))
            && (this.getPayGist() == null ? other.getPayGist() == null : this.getPayGist().equals(other.getPayGist()))
            && (this.getApplyDate() == null ? other.getApplyDate() == null : this.getApplyDate().equals(other.getApplyDate()))
            && (this.getApplyUserName() == null ? other.getApplyUserName() == null : this.getApplyUserName().equals(other.getApplyUserName()))
            && (this.getApplyUserId() == null ? other.getApplyUserId() == null : this.getApplyUserId().equals(other.getApplyUserId()));
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
        result = prime * result + ((getContractMoney() == null) ? 0 : getContractMoney().hashCode());
        result = prime * result + ((getProjectFundsType() == null) ? 0 : getProjectFundsType().hashCode());
        result = prime * result + ((getPayType() == null) ? 0 : getPayType().hashCode());
        result = prime * result + ((getPayWay() == null) ? 0 : getPayWay().hashCode());
        result = prime * result + ((getCurrency() == null) ? 0 : getCurrency().hashCode());
        result = prime * result + ((getApplyMoney() == null) ? 0 : getApplyMoney().hashCode());
        result = prime * result + ((getRealityMoney() == null) ? 0 : getRealityMoney().hashCode());
        result = prime * result + ((getAccountsPayable() == null) ? 0 : getAccountsPayable().hashCode());
        result = prime * result + ((getPayGist() == null) ? 0 : getPayGist().hashCode());
        result = prime * result + ((getApplyDate() == null) ? 0 : getApplyDate().hashCode());
        result = prime * result + ((getApplyUserName() == null) ? 0 : getApplyUserName().hashCode());
        result = prime * result + ((getApplyUserId() == null) ? 0 : getApplyUserId().hashCode());
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
        sb.append(", contractMoney=").append(contractMoney);
        sb.append(", projectFundsType=").append(projectFundsType);
        sb.append(", payType=").append(payType);
        sb.append(", payWay=").append(payWay);
        sb.append(", currency=").append(currency);
        sb.append(", applyMoney=").append(applyMoney);
        sb.append(", realityMoney=").append(realityMoney);
        sb.append(", accountsPayable=").append(accountsPayable);
        sb.append(", payGist=").append(payGist);
        sb.append(", applyDate=").append(applyDate);
        sb.append(", applyUserName=").append(applyUserName);
        sb.append(", applyUserId=").append(applyUserId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}