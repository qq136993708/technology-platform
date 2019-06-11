package com.pcitc.base.plan;

import com.pcitc.base.common.DataEntity;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * <p>实体类</p>
 * <p>Table: plan_base_detail - 工程签证申请</p>
 *
 * @since 2018-11-12 10:15:00
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlanBaseDetail extends DataEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * DATA_ID - 业务ID
     */
    private String dataId;

    /**
     * DATA_CODE - 数据编码
     */
    private String dataCode;

    /**
     * SYS_FLAG - 系统标识
     */
    private String sysFlag;

    /**
     * DATA_ORDER - 数据排序
     */
    private String dataOrder;

    /**
     * STATUS - 数据状态
     */
    private String status;

    /**
     * DEL_FLAG - 是否删除
     */
    private String delFlag;

    /**
     * CREATE_DATE - 创建日期
     */
    private String createDate;

    /**
     * CREATE_USER - 创建用户
     */
    private String createUser;

    /**
     * CREATE_USER_NAME - 创建用户名称
     */
    private String createUserName;

    /**
     * UPDATE_DATE - 修改日期
     */
    private String updateDate;

    /**
     * UPDATE_USER - 修改用户
     */
    private String updateUser;

    /**
     * UPDATE_USER_NAME - 修改用户名称
     */
    private String updateUserName;

    /**
     * PROJECT_CODE - 项目编码
     */
    private String projectCode;

    /**
     * PROJECT_ID - 所属项目
     */
    private String projectId;

    /**
     * PROJECT_NAME - 项目名称
     */
    private String projectName;

    /**
     * AUDIT_STS - 审批状态
     */
    private String auditSts;

    /**
     * UNIT_CODE - 单位编码
     */
    private String unitCode;

    /**
     * UNIT_NAME - 单位名称
     */
    private String unitName;

    /**
     * UNIT_ID - 单位ID
     */
    private String unitId;

    /**
     * ENGIN_NAME - 工程名称
     */
    private String enginName;

    /**
     * ENGIN_CODE - 工程编码
     */
    private String enginCode;

    /**
     * ENGIN_ID - 工程ID
     */
    private String enginId;

    /**
     * REMARKS - 描述
     */
    private String remarks;

    /**
     * WORKFLOW_STATE - 工作流状态
     */
    private String workflowState;

    /**
     * WBS_NAME - WBS名称
     */
    private String wbsName;

    /**
     * WBS_CODE - WBS编码
     */
    private String wbsCode;

    /**
     * WBS_ID -
     */
    private String wbsId;

    /**
     * COMPACT_NAME - 合同名称
     */
    private String compactName;

    /**
     * COMPACT_CODE - 合同编码
     */
    private String compactCode;

    /**
     * REDACT_UNIT_NAME - 编制单位名称
     */
    private String redactUnitName;

    /**
     * REDACT_UNIT_CODE - 编制单位编码
     */
    private String redactUnitCode;

    /**
     * REDACT_UNIT_ID - 编制单位ID
     */
    private String redactUnitId;

    /**
     * REDACT_DATE - 编制日期
     */
    private String redactDate;

    /**
     * WORK_ORDER_NAME - 工单名称
     */
    private String workOrderName;

    /**
     * WORK_ORDER_ID - 工程ID
     */
    private String workOrderId;

    /**
     * WORK_ORDER_CODE - 工单编码
     */
    private String workOrderCode;

    /**
     * WORK_ORDER_START_DATATIME - 工单实际开始时间
     */
    private String workOrderStartDatatime;

    /**
     * WORK_ORDER_END_DATATIME - 工单实际结束时间
     */
    private String workOrderEndDatatime;

    /**
     * WORK_ORDER_PLAN_START_DATATIME - 工单计划开始时间
     */
    private String workOrderPlanStartDatatime;

    /**
     * WORK_ORDER_PLAN_END_DATATIME - 工单计划结束时间
     */
    private String workOrderPlanEndDatatime;

    /**
     * MATTER_TYPE - 事项类型
     */
    private String matterType;

    /**
     * MATTER_STATUS - 工单状态
     */
    private String matterStatus;

    /**
     * MATTER_DATA_ID - 事项关联ID
     */
    private String matterDataId;

    /**
     * MATTER_DATA_ORDER - 处理顺序
     */
    private String matterDataOrder;


    public String getDataId() {
        return this.dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getDataCode() {
        return this.dataCode;
    }

    public void setDataCode(String dataCode) {
        this.dataCode = dataCode;
    }

    public String getSysFlag() {
        return this.sysFlag;
    }

    public void setSysFlag(String sysFlag) {
        this.sysFlag = sysFlag;
    }

    public String getDataOrder() {
        return this.dataOrder;
    }

    public void setDataOrder(String dataOrder) {
        this.dataOrder = dataOrder;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelFlag() {
        return this.delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return this.createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateUserName() {
        return this.createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateUser() {
        return this.updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateUserName() {
        return this.updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    public String getProjectCode() {
        return this.projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectId() {
        return this.projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getAuditSts() {
        return this.auditSts;
    }

    public void setAuditSts(String auditSts) {
        this.auditSts = auditSts;
    }

    public String getUnitCode() {
        return this.unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getUnitName() {
        return this.unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitId() {
        return this.unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getEnginName() {
        return this.enginName;
    }

    public void setEnginName(String enginName) {
        this.enginName = enginName;
    }

    public String getEnginCode() {
        return this.enginCode;
    }

    public void setEnginCode(String enginCode) {
        this.enginCode = enginCode;
    }

    public String getEnginId() {
        return this.enginId;
    }

    public void setEnginId(String enginId) {
        this.enginId = enginId;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getWorkflowState() {
        return this.workflowState;
    }

    public void setWorkflowState(String workflowState) {
        this.workflowState = workflowState;
    }

    public String getWbsName() {
        return this.wbsName;
    }

    public void setWbsName(String wbsName) {
        this.wbsName = wbsName;
    }

    public String getWbsCode() {
        return this.wbsCode;
    }

    public void setWbsCode(String wbsCode) {
        this.wbsCode = wbsCode;
    }

    public String getWbsId() {
        return this.wbsId;
    }

    public void setWbsId(String wbsId) {
        this.wbsId = wbsId;
    }

    public String getCompactName() {
        return this.compactName;
    }

    public void setCompactName(String compactName) {
        this.compactName = compactName;
    }

    public String getCompactCode() {
        return this.compactCode;
    }

    public void setCompactCode(String compactCode) {
        this.compactCode = compactCode;
    }

    public String getRedactUnitName() {
        return this.redactUnitName;
    }

    public void setRedactUnitName(String redactUnitName) {
        this.redactUnitName = redactUnitName;
    }

    public String getRedactUnitCode() {
        return this.redactUnitCode;
    }

    public void setRedactUnitCode(String redactUnitCode) {
        this.redactUnitCode = redactUnitCode;
    }

    public String getRedactUnitId() {
        return this.redactUnitId;
    }

    public void setRedactUnitId(String redactUnitId) {
        this.redactUnitId = redactUnitId;
    }

    public String getRedactDate() {
        return this.redactDate;
    }

    public void setRedactDate(String redactDate) {
        this.redactDate = redactDate;
    }

    public String getWorkOrderName() {
        return this.workOrderName;
    }

    public void setWorkOrderName(String workOrderName) {
        this.workOrderName = workOrderName;
    }

    public String getWorkOrderId() {
        return this.workOrderId;
    }

    public void setWorkOrderId(String workOrderId) {
        this.workOrderId = workOrderId;
    }

    public String getWorkOrderCode() {
        return this.workOrderCode;
    }

    public void setWorkOrderCode(String workOrderCode) {
        this.workOrderCode = workOrderCode;
    }

    public String getWorkOrderStartDatatime() {
        return this.workOrderStartDatatime;
    }

    public void setWorkOrderStartDatatime(String workOrderStartDatatime) {
        this.workOrderStartDatatime = workOrderStartDatatime;
    }

    public String getWorkOrderEndDatatime() {
        return this.workOrderEndDatatime;
    }

    public void setWorkOrderEndDatatime(String workOrderEndDatatime) {
        this.workOrderEndDatatime = workOrderEndDatatime;
    }

    public String getWorkOrderPlanStartDatatime() {
        return this.workOrderPlanStartDatatime;
    }

    public void setWorkOrderPlanStartDatatime(String workOrderPlanStartDatatime) {
        this.workOrderPlanStartDatatime = workOrderPlanStartDatatime;
    }

    public String getWorkOrderPlanEndDatatime() {
        return this.workOrderPlanEndDatatime;
    }

    public void setWorkOrderPlanEndDatatime(String workOrderPlanEndDatatime) {
        this.workOrderPlanEndDatatime = workOrderPlanEndDatatime;
    }

    public String getMatterType() {
        return this.matterType;
    }

    public void setMatterType(String matterType) {
        this.matterType = matterType;
    }

    public String getMatterStatus() {
        return this.matterStatus;
    }

    public void setMatterStatus(String matterStatus) {
        this.matterStatus = matterStatus;
    }

    public String getMatterDataId() {
        return this.matterDataId;
    }

    public void setMatterDataId(String matterDataId) {
        this.matterDataId = matterDataId;
    }

    public String getMatterDataOrder() {
        return this.matterDataOrder;
    }

    public void setMatterDataOrder(String matterDataOrder) {
        this.matterDataOrder = matterDataOrder;
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

        PlanBaseDetail other = (PlanBaseDetail) that;


        return
                (this.getDataId() == null ? other.getDataId() == null : this.getDataId().equals(other.getDataId())) &&

                        (this.getDataCode() == null ? other.getDataCode() == null : this.getDataCode().equals(other.getDataCode())) &&

                        (this.getSysFlag() == null ? other.getSysFlag() == null : this.getSysFlag().equals(other.getSysFlag())) &&

                        (this.getDataOrder() == null ? other.getDataOrder() == null : this.getDataOrder().equals(other.getDataOrder())) &&

                        (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus())) &&

                        (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag())) &&

                        (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate())) &&

                        (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser())) &&

                        (this.getCreateUserName() == null ? other.getCreateUserName() == null : this.getCreateUserName().equals(other.getCreateUserName())) &&

                        (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate())) &&

                        (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser())) &&

                        (this.getUpdateUserName() == null ? other.getUpdateUserName() == null : this.getUpdateUserName().equals(other.getUpdateUserName())) &&

                        (this.getProjectCode() == null ? other.getProjectCode() == null : this.getProjectCode().equals(other.getProjectCode())) &&

                        (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId())) &&

                        (this.getProjectName() == null ? other.getProjectName() == null : this.getProjectName().equals(other.getProjectName())) &&

                        (this.getAuditSts() == null ? other.getAuditSts() == null : this.getAuditSts().equals(other.getAuditSts())) &&

                        (this.getUnitCode() == null ? other.getUnitCode() == null : this.getUnitCode().equals(other.getUnitCode())) &&

                        (this.getUnitName() == null ? other.getUnitName() == null : this.getUnitName().equals(other.getUnitName())) &&

                        (this.getUnitId() == null ? other.getUnitId() == null : this.getUnitId().equals(other.getUnitId())) &&

                        (this.getEnginName() == null ? other.getEnginName() == null : this.getEnginName().equals(other.getEnginName())) &&

                        (this.getEnginCode() == null ? other.getEnginCode() == null : this.getEnginCode().equals(other.getEnginCode())) &&

                        (this.getEnginId() == null ? other.getEnginId() == null : this.getEnginId().equals(other.getEnginId())) &&

                        (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks())) &&

                        (this.getWorkflowState() == null ? other.getWorkflowState() == null : this.getWorkflowState().equals(other.getWorkflowState())) &&

                        (this.getWbsName() == null ? other.getWbsName() == null : this.getWbsName().equals(other.getWbsName())) &&

                        (this.getWbsCode() == null ? other.getWbsCode() == null : this.getWbsCode().equals(other.getWbsCode())) &&

                        (this.getWbsId() == null ? other.getWbsId() == null : this.getWbsId().equals(other.getWbsId())) &&

                        (this.getCompactName() == null ? other.getCompactName() == null : this.getCompactName().equals(other.getCompactName())) &&

                        (this.getCompactCode() == null ? other.getCompactCode() == null : this.getCompactCode().equals(other.getCompactCode())) &&

                        (this.getRedactUnitName() == null ? other.getRedactUnitName() == null : this.getRedactUnitName().equals(other.getRedactUnitName())) &&

                        (this.getRedactUnitCode() == null ? other.getRedactUnitCode() == null : this.getRedactUnitCode().equals(other.getRedactUnitCode())) &&

                        (this.getRedactUnitId() == null ? other.getRedactUnitId() == null : this.getRedactUnitId().equals(other.getRedactUnitId())) &&

                        (this.getRedactDate() == null ? other.getRedactDate() == null : this.getRedactDate().equals(other.getRedactDate())) &&

                        (this.getWorkOrderName() == null ? other.getWorkOrderName() == null : this.getWorkOrderName().equals(other.getWorkOrderName())) &&

                        (this.getWorkOrderId() == null ? other.getWorkOrderId() == null : this.getWorkOrderId().equals(other.getWorkOrderId())) &&

                        (this.getWorkOrderCode() == null ? other.getWorkOrderCode() == null : this.getWorkOrderCode().equals(other.getWorkOrderCode())) &&

                        (this.getWorkOrderStartDatatime() == null ? other.getWorkOrderStartDatatime() == null : this.getWorkOrderStartDatatime().equals(other.getWorkOrderStartDatatime())) &&

                        (this.getWorkOrderEndDatatime() == null ? other.getWorkOrderEndDatatime() == null : this.getWorkOrderEndDatatime().equals(other.getWorkOrderEndDatatime())) &&

                        (this.getWorkOrderPlanStartDatatime() == null ? other.getWorkOrderPlanStartDatatime() == null : this.getWorkOrderPlanStartDatatime().equals(other.getWorkOrderPlanStartDatatime())) &&

                        (this.getWorkOrderPlanEndDatatime() == null ? other.getWorkOrderPlanEndDatatime() == null : this.getWorkOrderPlanEndDatatime().equals(other.getWorkOrderPlanEndDatatime())) &&

                        (this.getMatterType() == null ? other.getMatterType() == null : this.getMatterType().equals(other.getMatterType())) &&

                        (this.getMatterStatus() == null ? other.getMatterStatus() == null : this.getMatterStatus().equals(other.getMatterStatus())) &&

                        (this.getMatterDataId() == null ? other.getMatterDataId() == null : this.getMatterDataId().equals(other.getMatterDataId())) &&

                        (this.getMatterDataOrder() == null ? other.getMatterDataOrder() == null : this.getMatterDataOrder().equals(other.getMatterDataOrder()));
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
        result = prime * result + ((getUnitCode() == null) ? 0 : getUnitCode().hashCode());
        result = prime * result + ((getUnitName() == null) ? 0 : getUnitName().hashCode());
        result = prime * result + ((getUnitId() == null) ? 0 : getUnitId().hashCode());
        result = prime * result + ((getEnginName() == null) ? 0 : getEnginName().hashCode());
        result = prime * result + ((getEnginCode() == null) ? 0 : getEnginCode().hashCode());
        result = prime * result + ((getEnginId() == null) ? 0 : getEnginId().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getWorkflowState() == null) ? 0 : getWorkflowState().hashCode());
        result = prime * result + ((getWbsName() == null) ? 0 : getWbsName().hashCode());
        result = prime * result + ((getWbsCode() == null) ? 0 : getWbsCode().hashCode());
        result = prime * result + ((getWbsId() == null) ? 0 : getWbsId().hashCode());
        result = prime * result + ((getCompactName() == null) ? 0 : getCompactName().hashCode());
        result = prime * result + ((getCompactCode() == null) ? 0 : getCompactCode().hashCode());
        result = prime * result + ((getRedactUnitName() == null) ? 0 : getRedactUnitName().hashCode());
        result = prime * result + ((getRedactUnitCode() == null) ? 0 : getRedactUnitCode().hashCode());
        result = prime * result + ((getRedactUnitId() == null) ? 0 : getRedactUnitId().hashCode());
        result = prime * result + ((getRedactDate() == null) ? 0 : getRedactDate().hashCode());
        result = prime * result + ((getWorkOrderName() == null) ? 0 : getWorkOrderName().hashCode());
        result = prime * result + ((getWorkOrderId() == null) ? 0 : getWorkOrderId().hashCode());
        result = prime * result + ((getWorkOrderCode() == null) ? 0 : getWorkOrderCode().hashCode());
        result = prime * result + ((getWorkOrderStartDatatime() == null) ? 0 : getWorkOrderStartDatatime().hashCode());
        result = prime * result + ((getWorkOrderEndDatatime() == null) ? 0 : getWorkOrderEndDatatime().hashCode());
        result = prime * result + ((getWorkOrderPlanStartDatatime() == null) ? 0 : getWorkOrderPlanStartDatatime().hashCode());
        result = prime * result + ((getWorkOrderPlanEndDatatime() == null) ? 0 : getWorkOrderPlanEndDatatime().hashCode());
        result = prime * result + ((getMatterType() == null) ? 0 : getMatterType().hashCode());
        result = prime * result + ((getMatterStatus() == null) ? 0 : getMatterStatus().hashCode());
        result = prime * result + ((getMatterDataId() == null) ? 0 : getMatterDataId().hashCode());
        result = prime * result + ((getMatterDataOrder() == null) ? 0 : getMatterDataOrder().hashCode());
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
        sb.append(", unitCode=").append(unitCode);
        sb.append(", unitName=").append(unitName);
        sb.append(", unitId=").append(unitId);
        sb.append(", enginName=").append(enginName);
        sb.append(", enginCode=").append(enginCode);
        sb.append(", enginId=").append(enginId);
        sb.append(", remarks=").append(remarks);
        sb.append(", workflowState=").append(workflowState);
        sb.append(", wbsName=").append(wbsName);
        sb.append(", wbsCode=").append(wbsCode);
        sb.append(", wbsId=").append(wbsId);
        sb.append(", compactName=").append(compactName);
        sb.append(", compactCode=").append(compactCode);
        sb.append(", redactUnitName=").append(redactUnitName);
        sb.append(", redactUnitCode=").append(redactUnitCode);
        sb.append(", redactUnitId=").append(redactUnitId);
        sb.append(", redactDate=").append(redactDate);
        sb.append(", workOrderName=").append(workOrderName);
        sb.append(", workOrderId=").append(workOrderId);
        sb.append(", workOrderCode=").append(workOrderCode);
        sb.append(", workOrderStartDatatime=").append(workOrderStartDatatime);
        sb.append(", workOrderEndDatatime=").append(workOrderEndDatatime);
        sb.append(", workOrderPlanStartDatatime=").append(workOrderPlanStartDatatime);
        sb.append(", workOrderPlanEndDatatime=").append(workOrderPlanEndDatatime);
        sb.append(", matterType=").append(matterType);
        sb.append(", matterStatus=").append(matterStatus);
        sb.append(", matterDataId=").append(matterDataId);
        sb.append(", matterDataOrder=").append(matterDataOrder);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}