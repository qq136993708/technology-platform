package com.pcitc.base.engin.quality.weld.vo;

import java.io.Serializable;

import com.pcitc.base.util.DataTableInfo;

/**
 * t_zlgl_hgryb
 * @author 
 */
public class SearchWeldApplyBillVo extends DataTableInfo implements Serializable {
    /**
     * 主键
     */
    private String dataId;

    /**
     * 业务数据编码
     */
    private String dataCode;

    /**
     * 系统名称
     */
    private String sysFlag;

    /**
     * 业务数据排序字段
     */
    private String dataOrder;

    /**
     * 数据状态
     */
    private String status;

    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 创建人ID
     */
    private String createUser;

    /**
     * 创建人名称
     */
    private String createUserName;

    /**
     * 修改时间
     */
    private String updateDate;

    /**
     * 修改人ID
     */
    private String updateUser;

    /**
     * 修改人名称
     */
    private String updateUserName;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目ID
     */
    private String projectId;

    /**
     * 项目编码
     */
    private String projectCode;

    /**
     * 审批状态
     */
    private String auditSts;

    /**
     * 组织机构代码
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
     * 1-表示已删除，2-表示未删除
     */
    private String delFlag;

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
     * 1、承建单位检查（SP_EXAMINE）
2、监理单位检查（SUPERVIS_EXAMINE）
3、项目分部检查（PROJECT_EXAMINE）
4、质量监督管理站检查（QS_EXAMINE）

     */
    private String checkUnit;

    /**
     * 施工单位名称
     */
    private String buildUnitName;

    /**
     * 施工单位编码
     */
    private String buildUnitCode;

    /**
     * 施工单位ID
     */
    private String buildUnitId;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 提交状态
     */
    private String workflowState;

    /**
     * 管线名称（逗号分隔）
     */
    private String pipelineListName;

    /**
     * 管线ID（逗号分隔）
     */
    private String pipelineListId;

    /**
     * 提交人ID
     */
    private String submitUserId;

    /**
     * 提交人名称
     */
    private String submitUserName;

    /**
     * 提交时间
     */
    private String submitDateTime;

    /**
     * 申请焊口数量
     */
    private String applyWeldNumber;

    /**
     * 申请单号
     */
    private String applyBillNumber;

    /**
     * 申请单名称
     */
    private String applyBillName;

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

    public String getSysFlag() {
        return sysFlag;
    }

    public void setSysFlag(String sysFlag) {
        this.sysFlag = sysFlag;
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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getAuditSts() {
        return auditSts;
    }

    public void setAuditSts(String auditSts) {
        this.auditSts = auditSts;
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

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
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

    public String getCheckUnit() {
        return checkUnit;
    }

    public void setCheckUnit(String checkUnit) {
        this.checkUnit = checkUnit;
    }

    public String getBuildUnitName() {
        return buildUnitName;
    }

    public void setBuildUnitName(String buildUnitName) {
        this.buildUnitName = buildUnitName;
    }

    public String getBuildUnitCode() {
        return buildUnitCode;
    }

    public void setBuildUnitCode(String buildUnitCode) {
        this.buildUnitCode = buildUnitCode;
    }

    public String getBuildUnitId() {
        return buildUnitId;
    }

    public void setBuildUnitId(String buildUnitId) {
        this.buildUnitId = buildUnitId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getWorkflowState() {
        return workflowState;
    }

    public void setWorkflowState(String workflowState) {
        this.workflowState = workflowState;
    }

    public String getPipelineListName() {
        return pipelineListName;
    }

    public void setPipelineListName(String pipelineListName) {
        this.pipelineListName = pipelineListName;
    }

    public String getPipelineListId() {
        return pipelineListId;
    }

    public void setPipelineListId(String pipelineListId) {
        this.pipelineListId = pipelineListId;
    }

    public String getSubmitUserId() {
        return submitUserId;
    }

    public void setSubmitUserId(String submitUserId) {
        this.submitUserId = submitUserId;
    }

    public String getSubmitUserName() {
        return submitUserName;
    }

    public void setSubmitUserName(String submitUserName) {
        this.submitUserName = submitUserName;
    }

    public String getSubmitDateTime() {
        return submitDateTime;
    }

    public void setSubmitDateTime(String submitDateTime) {
        this.submitDateTime = submitDateTime;
    }

    public String getApplyWeldNumber() {
        return applyWeldNumber;
    }

    public void setApplyWeldNumber(String applyWeldNumber) {
        this.applyWeldNumber = applyWeldNumber;
    }

    public String getApplyBillNumber() {
        return applyBillNumber;
    }

    public void setApplyBillNumber(String applyBillNumber) {
        this.applyBillNumber = applyBillNumber;
    }

    public String getApplyBillName() {
        return applyBillName;
    }

    public void setApplyBillName(String applyBillName) {
        this.applyBillName = applyBillName;
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
        WeldApplyBillVo other = (WeldApplyBillVo) that;
        return (this.getDataId() == null ? other.getDataId() == null : this.getDataId().equals(other.getDataId()))
            && (this.getDataCode() == null ? other.getDataCode() == null : this.getDataCode().equals(other.getDataCode()))
            && (this.getSysFlag() == null ? other.getSysFlag() == null : this.getSysFlag().equals(other.getSysFlag()))
            && (this.getDataOrder() == null ? other.getDataOrder() == null : this.getDataOrder().equals(other.getDataOrder()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getCreateUserName() == null ? other.getCreateUserName() == null : this.getCreateUserName().equals(other.getCreateUserName()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getUpdateUserName() == null ? other.getUpdateUserName() == null : this.getUpdateUserName().equals(other.getUpdateUserName()))
            && (this.getProjectName() == null ? other.getProjectName() == null : this.getProjectName().equals(other.getProjectName()))
            && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getProjectCode() == null ? other.getProjectCode() == null : this.getProjectCode().equals(other.getProjectCode()))
            && (this.getAuditSts() == null ? other.getAuditSts() == null : this.getAuditSts().equals(other.getAuditSts()))
            && (this.getUnitCode() == null ? other.getUnitCode() == null : this.getUnitCode().equals(other.getUnitCode()))
            && (this.getUnitName() == null ? other.getUnitName() == null : this.getUnitName().equals(other.getUnitName()))
            && (this.getUnitId() == null ? other.getUnitId() == null : this.getUnitId().equals(other.getUnitId()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()))
            && (this.getEnginName() == null ? other.getEnginName() == null : this.getEnginName().equals(other.getEnginName()))
            && (this.getEnginCode() == null ? other.getEnginCode() == null : this.getEnginCode().equals(other.getEnginCode()))
            && (this.getEnginId() == null ? other.getEnginId() == null : this.getEnginId().equals(other.getEnginId()))
            && (this.getCheckUnit() == null ? other.getCheckUnit() == null : this.getCheckUnit().equals(other.getCheckUnit()))
            && (this.getBuildUnitName() == null ? other.getBuildUnitName() == null : this.getBuildUnitName().equals(other.getBuildUnitName()))
            && (this.getBuildUnitCode() == null ? other.getBuildUnitCode() == null : this.getBuildUnitCode().equals(other.getBuildUnitCode()))
            && (this.getBuildUnitId() == null ? other.getBuildUnitId() == null : this.getBuildUnitId().equals(other.getBuildUnitId()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
            && (this.getWorkflowState() == null ? other.getWorkflowState() == null : this.getWorkflowState().equals(other.getWorkflowState()))
            && (this.getPipelineListName() == null ? other.getPipelineListName() == null : this.getPipelineListName().equals(other.getPipelineListName()))
            && (this.getPipelineListId() == null ? other.getPipelineListId() == null : this.getPipelineListId().equals(other.getPipelineListId()))
            && (this.getSubmitUserId() == null ? other.getSubmitUserId() == null : this.getSubmitUserId().equals(other.getSubmitUserId()))
            && (this.getSubmitUserName() == null ? other.getSubmitUserName() == null : this.getSubmitUserName().equals(other.getSubmitUserName()))
            && (this.getSubmitDateTime() == null ? other.getSubmitDateTime() == null : this.getSubmitDateTime().equals(other.getSubmitDateTime()))
            && (this.getApplyWeldNumber() == null ? other.getApplyWeldNumber() == null : this.getApplyWeldNumber().equals(other.getApplyWeldNumber()))
            && (this.getApplyBillNumber() == null ? other.getApplyBillNumber() == null : this.getApplyBillNumber().equals(other.getApplyBillNumber()))
            && (this.getApplyBillName() == null ? other.getApplyBillName() == null : this.getApplyBillName().equals(other.getApplyBillName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataId() == null) ? 0 : getDataId().hashCode());
        result = prime * result + ((getDataCode() == null) ? 0 : getDataCode().hashCode());
        result = prime * result + ((getSysFlag() == null) ? 0 : getSysFlag().hashCode());
        result = prime * result + ((getDataOrder() == null) ? 0 : getDataOrder().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateUserName() == null) ? 0 : getCreateUserName().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateUserName() == null) ? 0 : getUpdateUserName().hashCode());
        result = prime * result + ((getProjectName() == null) ? 0 : getProjectName().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getProjectCode() == null) ? 0 : getProjectCode().hashCode());
        result = prime * result + ((getAuditSts() == null) ? 0 : getAuditSts().hashCode());
        result = prime * result + ((getUnitCode() == null) ? 0 : getUnitCode().hashCode());
        result = prime * result + ((getUnitName() == null) ? 0 : getUnitName().hashCode());
        result = prime * result + ((getUnitId() == null) ? 0 : getUnitId().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        result = prime * result + ((getEnginName() == null) ? 0 : getEnginName().hashCode());
        result = prime * result + ((getEnginCode() == null) ? 0 : getEnginCode().hashCode());
        result = prime * result + ((getEnginId() == null) ? 0 : getEnginId().hashCode());
        result = prime * result + ((getCheckUnit() == null) ? 0 : getCheckUnit().hashCode());
        result = prime * result + ((getBuildUnitName() == null) ? 0 : getBuildUnitName().hashCode());
        result = prime * result + ((getBuildUnitCode() == null) ? 0 : getBuildUnitCode().hashCode());
        result = prime * result + ((getBuildUnitId() == null) ? 0 : getBuildUnitId().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getWorkflowState() == null) ? 0 : getWorkflowState().hashCode());
        result = prime * result + ((getPipelineListName() == null) ? 0 : getPipelineListName().hashCode());
        result = prime * result + ((getPipelineListId() == null) ? 0 : getPipelineListId().hashCode());
        result = prime * result + ((getSubmitUserId() == null) ? 0 : getSubmitUserId().hashCode());
        result = prime * result + ((getSubmitUserName() == null) ? 0 : getSubmitUserName().hashCode());
        result = prime * result + ((getSubmitDateTime() == null) ? 0 : getSubmitDateTime().hashCode());
        result = prime * result + ((getApplyWeldNumber() == null) ? 0 : getApplyWeldNumber().hashCode());
        result = prime * result + ((getApplyBillNumber() == null) ? 0 : getApplyBillNumber().hashCode());
        result = prime * result + ((getApplyBillName() == null) ? 0 : getApplyBillName().hashCode());
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
        sb.append(", sysFlag=").append(sysFlag);
        sb.append(", dataOrder=").append(dataOrder);
        sb.append(", status=").append(status);
        sb.append(", createDate=").append(createDate);
        sb.append(", createUser=").append(createUser);
        sb.append(", createUserName=").append(createUserName);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateUserName=").append(updateUserName);
        sb.append(", projectName=").append(projectName);
        sb.append(", projectId=").append(projectId);
        sb.append(", projectCode=").append(projectCode);
        sb.append(", auditSts=").append(auditSts);
        sb.append(", unitCode=").append(unitCode);
        sb.append(", unitName=").append(unitName);
        sb.append(", unitId=").append(unitId);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", enginName=").append(enginName);
        sb.append(", enginCode=").append(enginCode);
        sb.append(", enginId=").append(enginId);
        sb.append(", checkUnit=").append(checkUnit);
        sb.append(", buildUnitName=").append(buildUnitName);
        sb.append(", buildUnitCode=").append(buildUnitCode);
        sb.append(", buildUnitId=").append(buildUnitId);
        sb.append(", remarks=").append(remarks);
        sb.append(", workflowState=").append(workflowState);
        sb.append(", pipelineListName=").append(pipelineListName);
        sb.append(", pipelineListId=").append(pipelineListId);
        sb.append(", submitUserId=").append(submitUserId);
        sb.append(", submitUserName=").append(submitUserName);
        sb.append(", submitDateTime=").append(submitDateTime);
        sb.append(", applyWeldNumber=").append(applyWeldNumber);
        sb.append(", applyBillNumber=").append(applyBillNumber);
        sb.append(", applyBillName=").append(applyBillName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}