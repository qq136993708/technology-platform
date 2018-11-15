package com.pcitc.base.engin.contract.base;

import java.io.Serializable;

import com.pcitc.base.util.SearchInfo;

/**
 * contract_base1
 * @author 
 */
public class ContractBaseVo extends SearchInfo implements Serializable {
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
     * 合同类型
     */
    private String contractType;

    /**
     * 合同标的金额（元）
     */
    private String contractMoney;

    /**
     * 合同类别
     */
    private String contractCategory;

    /**
     * 拟合同签订日期
     */
    private String contractSignDate;

    /**
     * 合同生效日期
     */
    private String contractEffectDate;

    /**
     * 合同开始日期
     */
    private String contractStartDate;

    /**
     * 合同结束日期
     */
    private String contractEndDate;

    /**
     * 主办部门
     */
    private String adminUnitName;

    /**
     * 经办人
     */
    private String adminUserName;

    /**
     * 合同主要内容
     */
    private String contractContent;

    /**
     * 合同明细
     */
    private String contractDetail;

    /**
     * 合同质保金额(元)
     */
    private String contractSafeMoney;

    /**
     * 是否会签
     */
    private String isSigned;

    /**
     * CMIS合同名称
     */
    private String cmisContractName;

    /**
     * CMIS合同编码
     */
    private String cmisContractCode;

    /**
     * 合同流水号
     */
    private String contractRecordNo;

    /**
     * CBS名称
     */
    private String cbsName;

    /**
     * CBS编码
     */
    private String cbsCode;

    /**
     * 合同签订单位名称
     */
    private String contractUnitName;

    /**
     * 合同签订单位ID
     */
    private String contractUnitId;

    /**
     * 合同签订单位编码
     */
    private String contractUnitCode;

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

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public String getContractMoney() {
        return contractMoney;
    }

    public void setContractMoney(String contractMoney) {
        this.contractMoney = contractMoney;
    }

    public String getContractCategory() {
        return contractCategory;
    }

    public void setContractCategory(String contractCategory) {
        this.contractCategory = contractCategory;
    }

    public String getContractSignDate() {
        return contractSignDate;
    }

    public void setContractSignDate(String contractSignDate) {
        this.contractSignDate = contractSignDate;
    }

    public String getContractEffectDate() {
        return contractEffectDate;
    }

    public void setContractEffectDate(String contractEffectDate) {
        this.contractEffectDate = contractEffectDate;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public String getAdminUnitName() {
        return adminUnitName;
    }

    public void setAdminUnitName(String adminUnitName) {
        this.adminUnitName = adminUnitName;
    }

    public String getAdminUserName() {
        return adminUserName;
    }

    public void setAdminUserName(String adminUserName) {
        this.adminUserName = adminUserName;
    }

    public String getContractContent() {
        return contractContent;
    }

    public void setContractContent(String contractContent) {
        this.contractContent = contractContent;
    }

    public String getContractDetail() {
        return contractDetail;
    }

    public void setContractDetail(String contractDetail) {
        this.contractDetail = contractDetail;
    }

    public String getContractSafeMoney() {
        return contractSafeMoney;
    }

    public void setContractSafeMoney(String contractSafeMoney) {
        this.contractSafeMoney = contractSafeMoney;
    }

    public String getIsSigned() {
        return isSigned;
    }

    public void setIsSigned(String isSigned) {
        this.isSigned = isSigned;
    }

    public String getCmisContractName() {
        return cmisContractName;
    }

    public void setCmisContractName(String cmisContractName) {
        this.cmisContractName = cmisContractName;
    }

    public String getCmisContractCode() {
        return cmisContractCode;
    }

    public void setCmisContractCode(String cmisContractCode) {
        this.cmisContractCode = cmisContractCode;
    }

    public String getContractRecordNo() {
        return contractRecordNo;
    }

    public void setContractRecordNo(String contractRecordNo) {
        this.contractRecordNo = contractRecordNo;
    }

    public String getCbsName() {
        return cbsName;
    }

    public void setCbsName(String cbsName) {
        this.cbsName = cbsName;
    }

    public String getCbsCode() {
        return cbsCode;
    }

    public void setCbsCode(String cbsCode) {
        this.cbsCode = cbsCode;
    }

    public String getContractUnitName() {
        return contractUnitName;
    }

    public void setContractUnitName(String contractUnitName) {
        this.contractUnitName = contractUnitName;
    }

    public String getContractUnitId() {
        return contractUnitId;
    }

    public void setContractUnitId(String contractUnitId) {
        this.contractUnitId = contractUnitId;
    }

    public String getContractUnitCode() {
        return contractUnitCode;
    }

    public void setContractUnitCode(String contractUnitCode) {
        this.contractUnitCode = contractUnitCode;
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
        ContractBaseVo other = (ContractBaseVo) that;
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
            && (this.getContractType() == null ? other.getContractType() == null : this.getContractType().equals(other.getContractType()))
            && (this.getContractMoney() == null ? other.getContractMoney() == null : this.getContractMoney().equals(other.getContractMoney()))
            && (this.getContractCategory() == null ? other.getContractCategory() == null : this.getContractCategory().equals(other.getContractCategory()))
            && (this.getContractSignDate() == null ? other.getContractSignDate() == null : this.getContractSignDate().equals(other.getContractSignDate()))
            && (this.getContractEffectDate() == null ? other.getContractEffectDate() == null : this.getContractEffectDate().equals(other.getContractEffectDate()))
            && (this.getContractStartDate() == null ? other.getContractStartDate() == null : this.getContractStartDate().equals(other.getContractStartDate()))
            && (this.getContractEndDate() == null ? other.getContractEndDate() == null : this.getContractEndDate().equals(other.getContractEndDate()))
            && (this.getAdminUnitName() == null ? other.getAdminUnitName() == null : this.getAdminUnitName().equals(other.getAdminUnitName()))
            && (this.getAdminUserName() == null ? other.getAdminUserName() == null : this.getAdminUserName().equals(other.getAdminUserName()))
            && (this.getContractContent() == null ? other.getContractContent() == null : this.getContractContent().equals(other.getContractContent()))
            && (this.getContractDetail() == null ? other.getContractDetail() == null : this.getContractDetail().equals(other.getContractDetail()))
            && (this.getContractSafeMoney() == null ? other.getContractSafeMoney() == null : this.getContractSafeMoney().equals(other.getContractSafeMoney()))
            && (this.getIsSigned() == null ? other.getIsSigned() == null : this.getIsSigned().equals(other.getIsSigned()))
            && (this.getCmisContractName() == null ? other.getCmisContractName() == null : this.getCmisContractName().equals(other.getCmisContractName()))
            && (this.getCmisContractCode() == null ? other.getCmisContractCode() == null : this.getCmisContractCode().equals(other.getCmisContractCode()))
            && (this.getContractRecordNo() == null ? other.getContractRecordNo() == null : this.getContractRecordNo().equals(other.getContractRecordNo()))
            && (this.getCbsName() == null ? other.getCbsName() == null : this.getCbsName().equals(other.getCbsName()))
            && (this.getCbsCode() == null ? other.getCbsCode() == null : this.getCbsCode().equals(other.getCbsCode()))
            && (this.getContractUnitName() == null ? other.getContractUnitName() == null : this.getContractUnitName().equals(other.getContractUnitName()))
            && (this.getContractUnitId() == null ? other.getContractUnitId() == null : this.getContractUnitId().equals(other.getContractUnitId()))
            && (this.getContractUnitCode() == null ? other.getContractUnitCode() == null : this.getContractUnitCode().equals(other.getContractUnitCode()));
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
        result = prime * result + ((getContractType() == null) ? 0 : getContractType().hashCode());
        result = prime * result + ((getContractMoney() == null) ? 0 : getContractMoney().hashCode());
        result = prime * result + ((getContractCategory() == null) ? 0 : getContractCategory().hashCode());
        result = prime * result + ((getContractSignDate() == null) ? 0 : getContractSignDate().hashCode());
        result = prime * result + ((getContractEffectDate() == null) ? 0 : getContractEffectDate().hashCode());
        result = prime * result + ((getContractStartDate() == null) ? 0 : getContractStartDate().hashCode());
        result = prime * result + ((getContractEndDate() == null) ? 0 : getContractEndDate().hashCode());
        result = prime * result + ((getAdminUnitName() == null) ? 0 : getAdminUnitName().hashCode());
        result = prime * result + ((getAdminUserName() == null) ? 0 : getAdminUserName().hashCode());
        result = prime * result + ((getContractContent() == null) ? 0 : getContractContent().hashCode());
        result = prime * result + ((getContractDetail() == null) ? 0 : getContractDetail().hashCode());
        result = prime * result + ((getContractSafeMoney() == null) ? 0 : getContractSafeMoney().hashCode());
        result = prime * result + ((getIsSigned() == null) ? 0 : getIsSigned().hashCode());
        result = prime * result + ((getCmisContractName() == null) ? 0 : getCmisContractName().hashCode());
        result = prime * result + ((getCmisContractCode() == null) ? 0 : getCmisContractCode().hashCode());
        result = prime * result + ((getContractRecordNo() == null) ? 0 : getContractRecordNo().hashCode());
        result = prime * result + ((getCbsName() == null) ? 0 : getCbsName().hashCode());
        result = prime * result + ((getCbsCode() == null) ? 0 : getCbsCode().hashCode());
        result = prime * result + ((getContractUnitName() == null) ? 0 : getContractUnitName().hashCode());
        result = prime * result + ((getContractUnitId() == null) ? 0 : getContractUnitId().hashCode());
        result = prime * result + ((getContractUnitCode() == null) ? 0 : getContractUnitCode().hashCode());
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
        sb.append(", contractType=").append(contractType);
        sb.append(", contractMoney=").append(contractMoney);
        sb.append(", contractCategory=").append(contractCategory);
        sb.append(", contractSignDate=").append(contractSignDate);
        sb.append(", contractEffectDate=").append(contractEffectDate);
        sb.append(", contractStartDate=").append(contractStartDate);
        sb.append(", contractEndDate=").append(contractEndDate);
        sb.append(", adminUnitName=").append(adminUnitName);
        sb.append(", adminUserName=").append(adminUserName);
        sb.append(", contractContent=").append(contractContent);
        sb.append(", contractDetail=").append(contractDetail);
        sb.append(", contractSafeMoney=").append(contractSafeMoney);
        sb.append(", isSigned=").append(isSigned);
        sb.append(", cmisContractName=").append(cmisContractName);
        sb.append(", cmisContractCode=").append(cmisContractCode);
        sb.append(", contractRecordNo=").append(contractRecordNo);
        sb.append(", cbsName=").append(cbsName);
        sb.append(", cbsCode=").append(cbsCode);
        sb.append(", contractUnitName=").append(contractUnitName);
        sb.append(", contractUnitId=").append(contractUnitId);
        sb.append(", contractUnitCode=").append(contractUnitCode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}