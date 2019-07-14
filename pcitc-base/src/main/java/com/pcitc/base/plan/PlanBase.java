package com.pcitc.base.plan;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pcitc.base.common.DataEntity;

/**
 * plan_base
 * @author 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlanBase extends DataEntity implements Serializable {
    /**
     * 业务ID
     */
    private String dataId;

    /**
     * 数据编码
     */
    private String dataCode;

    /**
     * 系统标识
     */
    private String sysFlag;

    /**
     * 数据排序
     */
    private String dataOrder;

    /**
     * 数据状态
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
     * 创建用户(任务分配人）
     */
    private String createUser;

    /**
     * 创建用户名称(任务分配人）
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
    private String auditSts;

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
     * 工作流状态
     */
    private String workflowState;

    /**
     * WBS名称
     */
    private String wbsName;

    /**
     * WBS编码
     */
    private String wbsCode;

    private String wbsId;

    /**
     * 合同名称
     */
    private String compactName;

    /**
     * 合同编码
     */
    private String compactCode;

    /**
     * 监理单位名称
     */
    private String supervisionUnitName;

    /**
     * 监理单位编码
     */
    private String supervisionUnitCode;

    /**
     * 监理单位ID
     */
    private String supervisionUnitId;

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
     * 编制单位名称
     */
    private String redactUnitName;

    /**
     * 编制单位编码
     */
    private String redactUnitCode;

    /**
     * 编制单位ID
     */
    private String redactUnitId;

    /**
     * 编制日期
     */
    private String redactDate;

    /**
     * 工单名称
     */
    private String workOrderName;

    /**
     * 工单编码
     */
    private String workOrderCode;

    /**
     * 工单实际开始时间
     */
    private String workOrderStartDatatime;

    /**
     * 工单实际结束时间
     */
    private String workOrderEndDatatime;

    /**
     * 工单计划开始时间
     */
    private String workOrderPlanStartDatatime;

    /**
     * 工单计划结束时间
     */
    private String workOrderPlanEndDatatime;

    /**
     * 工单工作方案
     */
    private String implementationProgram;

    /**
     * 权重
     */
    private String announcements;

    /**
     * 工单类型
     */
    private String workOrderType;

    /**
     * 工单状态,2已完成
     */
    private String workOrderStatus;

    /**
     * 工单接收人名称
     */
    private String workOrderAllotUserName;

    /**
     * 工单接收人ID
     */
    private String workOrderAllotUserId;

    /**
     * 父ID
     */
    private String parentId;

    /**
     * 接收ID,转发时新增一条记录中记忆原任务的dataId
     */
    private String jsId;

    /**
     * 指派ID；转发时，新增一条任务，原任务记录中记忆新增任务的dataId
     */
    private String zpName;

    /**
     * 完成比例
     */
    private String bl;

    /**
     * 协办人
     */
    private String xbr;

    /**
     * 是否指派
     */
    private String bak1;

    private String bak2;

    /**
     * 接收人
     */
    private String bak3;

    /**
     * 下发时下发人员姓名，逗号隔开
     */
    private String bak4;

    /**
     * 任务是否转发标示，0已转发
     */
    private String bak5;

    /**
     * 下发时下发人员ID，逗号隔开
     */
    private String bak6;

    /**
     * 定时（固定）种类工作
     */
    private String scheduleType;

    /**
     * 是否是定时任务
     */
    private String isSchedule;

    /**
     * 定时安排时间
     */
    private String scheduleDate;

    private String bak7;

    private String bak8;

    private String bak9;

    /**
     * 描述
     */
    private String remarks;
    
    private List<PlanBaseDetail> planBaseDetailList;
    

    public List<PlanBaseDetail> getPlanBaseDetailList() {
		return planBaseDetailList;
	}

	public void setPlanBaseDetailList(List<PlanBaseDetail> planBaseDetailList) {
		this.planBaseDetailList = planBaseDetailList;
	}

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

    public String getWorkflowState() {
        return workflowState;
    }

    public void setWorkflowState(String workflowState) {
        this.workflowState = workflowState;
    }

    public String getWbsName() {
        return wbsName;
    }

    public void setWbsName(String wbsName) {
        this.wbsName = wbsName;
    }

    public String getWbsCode() {
        return wbsCode;
    }

    public void setWbsCode(String wbsCode) {
        this.wbsCode = wbsCode;
    }

    public String getWbsId() {
        return wbsId;
    }

    public void setWbsId(String wbsId) {
        this.wbsId = wbsId;
    }

    public String getCompactName() {
        return compactName;
    }

    public void setCompactName(String compactName) {
        this.compactName = compactName;
    }

    public String getCompactCode() {
        return compactCode;
    }

    public void setCompactCode(String compactCode) {
        this.compactCode = compactCode;
    }

    public String getSupervisionUnitName() {
        return supervisionUnitName;
    }

    public void setSupervisionUnitName(String supervisionUnitName) {
        this.supervisionUnitName = supervisionUnitName;
    }

    public String getSupervisionUnitCode() {
        return supervisionUnitCode;
    }

    public void setSupervisionUnitCode(String supervisionUnitCode) {
        this.supervisionUnitCode = supervisionUnitCode;
    }

    public String getSupervisionUnitId() {
        return supervisionUnitId;
    }

    public void setSupervisionUnitId(String supervisionUnitId) {
        this.supervisionUnitId = supervisionUnitId;
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

    public String getRedactUnitName() {
        return redactUnitName;
    }

    public void setRedactUnitName(String redactUnitName) {
        this.redactUnitName = redactUnitName;
    }

    public String getRedactUnitCode() {
        return redactUnitCode;
    }

    public void setRedactUnitCode(String redactUnitCode) {
        this.redactUnitCode = redactUnitCode;
    }

    public String getRedactUnitId() {
        return redactUnitId;
    }

    public void setRedactUnitId(String redactUnitId) {
        this.redactUnitId = redactUnitId;
    }

    public String getRedactDate() {
        return redactDate;
    }

    public void setRedactDate(String redactDate) {
        this.redactDate = redactDate;
    }

    public String getWorkOrderName() {
        return workOrderName;
    }

    public void setWorkOrderName(String workOrderName) {
        this.workOrderName = workOrderName;
    }

    public String getWorkOrderCode() {
        return workOrderCode;
    }

    public void setWorkOrderCode(String workOrderCode) {
        this.workOrderCode = workOrderCode;
    }

    public String getWorkOrderStartDatatime() {
        return workOrderStartDatatime;
    }

    public void setWorkOrderStartDatatime(String workOrderStartDatatime) {
        this.workOrderStartDatatime = workOrderStartDatatime;
    }

    public String getWorkOrderEndDatatime() {
        return workOrderEndDatatime;
    }

    public void setWorkOrderEndDatatime(String workOrderEndDatatime) {
        this.workOrderEndDatatime = workOrderEndDatatime;
    }

    public String getWorkOrderPlanStartDatatime() {
        return workOrderPlanStartDatatime;
    }

    public void setWorkOrderPlanStartDatatime(String workOrderPlanStartDatatime) {
        this.workOrderPlanStartDatatime = workOrderPlanStartDatatime;
    }

    public String getWorkOrderPlanEndDatatime() {
        return workOrderPlanEndDatatime;
    }

    public void setWorkOrderPlanEndDatatime(String workOrderPlanEndDatatime) {
        this.workOrderPlanEndDatatime = workOrderPlanEndDatatime;
    }

    public String getImplementationProgram() {
        return implementationProgram;
    }

    public void setImplementationProgram(String implementationProgram) {
        this.implementationProgram = implementationProgram;
    }

    public String getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(String announcements) {
        this.announcements = announcements;
    }

    public String getWorkOrderType() {
        return workOrderType;
    }

    public void setWorkOrderType(String workOrderType) {
        this.workOrderType = workOrderType;
    }

    public String getWorkOrderStatus() {
        return workOrderStatus;
    }

    public void setWorkOrderStatus(String workOrderStatus) {
        this.workOrderStatus = workOrderStatus;
    }

    public String getWorkOrderAllotUserName() {
        return workOrderAllotUserName;
    }

    public void setWorkOrderAllotUserName(String workOrderAllotUserName) {
        this.workOrderAllotUserName = workOrderAllotUserName;
    }

    public String getWorkOrderAllotUserId() {
        return workOrderAllotUserId;
    }

    public void setWorkOrderAllotUserId(String workOrderAllotUserId) {
        this.workOrderAllotUserId = workOrderAllotUserId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getJsId() {
        return jsId;
    }

    public void setJsId(String jsId) {
        this.jsId = jsId;
    }

    public String getZpName() {
        return zpName;
    }

    public void setZpName(String zpName) {
        this.zpName = zpName;
    }

    public String getBl() {
        return bl;
    }

    public void setBl(String bl) {
        this.bl = bl;
    }

    public String getXbr() {
        return xbr;
    }

    public void setXbr(String xbr) {
        this.xbr = xbr;
    }

    public String getBak1() {
        return bak1;
    }

    public void setBak1(String bak1) {
        this.bak1 = bak1;
    }

    public String getBak2() {
        return bak2;
    }

    public void setBak2(String bak2) {
        this.bak2 = bak2;
    }

    public String getBak3() {
        return bak3;
    }

    public void setBak3(String bak3) {
        this.bak3 = bak3;
    }

    public String getBak4() {
        return bak4;
    }

    public void setBak4(String bak4) {
        this.bak4 = bak4;
    }

    public String getBak5() {
        return bak5;
    }

    public void setBak5(String bak5) {
        this.bak5 = bak5;
    }

    public String getBak6() {
        return bak6;
    }

    public void setBak6(String bak6) {
        this.bak6 = bak6;
    }

    public String getScheduleType() {
        return scheduleType;
    }

    public void setScheduleType(String scheduleType) {
        this.scheduleType = scheduleType;
    }

    public String getIsSchedule() {
        return isSchedule;
    }

    public void setIsSchedule(String isSchedule) {
        this.isSchedule = isSchedule;
    }

    public String getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getBak7() {
        return bak7;
    }

    public void setBak7(String bak7) {
        this.bak7 = bak7;
    }

    public String getBak8() {
        return bak8;
    }

    public void setBak8(String bak8) {
        this.bak8 = bak8;
    }

    public String getBak9() {
        return bak9;
    }

    public void setBak9(String bak9) {
        this.bak9 = bak9;
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
        PlanBase other = (PlanBase) that;
        return (this.getDataId() == null ? other.getDataId() == null : this.getDataId().equals(other.getDataId()))
            && (this.getDataCode() == null ? other.getDataCode() == null : this.getDataCode().equals(other.getDataCode()))
            && (this.getSysFlag() == null ? other.getSysFlag() == null : this.getSysFlag().equals(other.getSysFlag()))
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
            && (this.getUnitCode() == null ? other.getUnitCode() == null : this.getUnitCode().equals(other.getUnitCode()))
            && (this.getUnitName() == null ? other.getUnitName() == null : this.getUnitName().equals(other.getUnitName()))
            && (this.getUnitId() == null ? other.getUnitId() == null : this.getUnitId().equals(other.getUnitId()))
            && (this.getEnginName() == null ? other.getEnginName() == null : this.getEnginName().equals(other.getEnginName()))
            && (this.getEnginCode() == null ? other.getEnginCode() == null : this.getEnginCode().equals(other.getEnginCode()))
            && (this.getEnginId() == null ? other.getEnginId() == null : this.getEnginId().equals(other.getEnginId()))
            && (this.getWorkflowState() == null ? other.getWorkflowState() == null : this.getWorkflowState().equals(other.getWorkflowState()))
            && (this.getWbsName() == null ? other.getWbsName() == null : this.getWbsName().equals(other.getWbsName()))
            && (this.getWbsCode() == null ? other.getWbsCode() == null : this.getWbsCode().equals(other.getWbsCode()))
            && (this.getWbsId() == null ? other.getWbsId() == null : this.getWbsId().equals(other.getWbsId()))
            && (this.getCompactName() == null ? other.getCompactName() == null : this.getCompactName().equals(other.getCompactName()))
            && (this.getCompactCode() == null ? other.getCompactCode() == null : this.getCompactCode().equals(other.getCompactCode()))
            && (this.getSupervisionUnitName() == null ? other.getSupervisionUnitName() == null : this.getSupervisionUnitName().equals(other.getSupervisionUnitName()))
            && (this.getSupervisionUnitCode() == null ? other.getSupervisionUnitCode() == null : this.getSupervisionUnitCode().equals(other.getSupervisionUnitCode()))
            && (this.getSupervisionUnitId() == null ? other.getSupervisionUnitId() == null : this.getSupervisionUnitId().equals(other.getSupervisionUnitId()))
            && (this.getBuildUnitName() == null ? other.getBuildUnitName() == null : this.getBuildUnitName().equals(other.getBuildUnitName()))
            && (this.getBuildUnitCode() == null ? other.getBuildUnitCode() == null : this.getBuildUnitCode().equals(other.getBuildUnitCode()))
            && (this.getBuildUnitId() == null ? other.getBuildUnitId() == null : this.getBuildUnitId().equals(other.getBuildUnitId()))
            && (this.getRedactUnitName() == null ? other.getRedactUnitName() == null : this.getRedactUnitName().equals(other.getRedactUnitName()))
            && (this.getRedactUnitCode() == null ? other.getRedactUnitCode() == null : this.getRedactUnitCode().equals(other.getRedactUnitCode()))
            && (this.getRedactUnitId() == null ? other.getRedactUnitId() == null : this.getRedactUnitId().equals(other.getRedactUnitId()))
            && (this.getRedactDate() == null ? other.getRedactDate() == null : this.getRedactDate().equals(other.getRedactDate()))
            && (this.getWorkOrderName() == null ? other.getWorkOrderName() == null : this.getWorkOrderName().equals(other.getWorkOrderName()))
            && (this.getWorkOrderCode() == null ? other.getWorkOrderCode() == null : this.getWorkOrderCode().equals(other.getWorkOrderCode()))
            && (this.getWorkOrderStartDatatime() == null ? other.getWorkOrderStartDatatime() == null : this.getWorkOrderStartDatatime().equals(other.getWorkOrderStartDatatime()))
            && (this.getWorkOrderEndDatatime() == null ? other.getWorkOrderEndDatatime() == null : this.getWorkOrderEndDatatime().equals(other.getWorkOrderEndDatatime()))
            && (this.getWorkOrderPlanStartDatatime() == null ? other.getWorkOrderPlanStartDatatime() == null : this.getWorkOrderPlanStartDatatime().equals(other.getWorkOrderPlanStartDatatime()))
            && (this.getWorkOrderPlanEndDatatime() == null ? other.getWorkOrderPlanEndDatatime() == null : this.getWorkOrderPlanEndDatatime().equals(other.getWorkOrderPlanEndDatatime()))
            && (this.getImplementationProgram() == null ? other.getImplementationProgram() == null : this.getImplementationProgram().equals(other.getImplementationProgram()))
            && (this.getAnnouncements() == null ? other.getAnnouncements() == null : this.getAnnouncements().equals(other.getAnnouncements()))
            && (this.getWorkOrderType() == null ? other.getWorkOrderType() == null : this.getWorkOrderType().equals(other.getWorkOrderType()))
            && (this.getWorkOrderStatus() == null ? other.getWorkOrderStatus() == null : this.getWorkOrderStatus().equals(other.getWorkOrderStatus()))
            && (this.getWorkOrderAllotUserName() == null ? other.getWorkOrderAllotUserName() == null : this.getWorkOrderAllotUserName().equals(other.getWorkOrderAllotUserName()))
            && (this.getWorkOrderAllotUserId() == null ? other.getWorkOrderAllotUserId() == null : this.getWorkOrderAllotUserId().equals(other.getWorkOrderAllotUserId()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getJsId() == null ? other.getJsId() == null : this.getJsId().equals(other.getJsId()))
            && (this.getZpName() == null ? other.getZpName() == null : this.getZpName().equals(other.getZpName()))
            && (this.getBl() == null ? other.getBl() == null : this.getBl().equals(other.getBl()))
            && (this.getXbr() == null ? other.getXbr() == null : this.getXbr().equals(other.getXbr()))
            && (this.getBak1() == null ? other.getBak1() == null : this.getBak1().equals(other.getBak1()))
            && (this.getBak2() == null ? other.getBak2() == null : this.getBak2().equals(other.getBak2()))
            && (this.getBak3() == null ? other.getBak3() == null : this.getBak3().equals(other.getBak3()))
            && (this.getBak4() == null ? other.getBak4() == null : this.getBak4().equals(other.getBak4()))
            && (this.getBak5() == null ? other.getBak5() == null : this.getBak5().equals(other.getBak5()))
            && (this.getBak6() == null ? other.getBak6() == null : this.getBak6().equals(other.getBak6()))
            && (this.getScheduleType() == null ? other.getScheduleType() == null : this.getScheduleType().equals(other.getScheduleType()))
            && (this.getIsSchedule() == null ? other.getIsSchedule() == null : this.getIsSchedule().equals(other.getIsSchedule()))
            && (this.getScheduleDate() == null ? other.getScheduleDate() == null : this.getScheduleDate().equals(other.getScheduleDate()))
            && (this.getBak7() == null ? other.getBak7() == null : this.getBak7().equals(other.getBak7()))
            && (this.getBak8() == null ? other.getBak8() == null : this.getBak8().equals(other.getBak8()))
            && (this.getBak9() == null ? other.getBak9() == null : this.getBak9().equals(other.getBak9()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()));
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
        result = prime * result + ((getWorkflowState() == null) ? 0 : getWorkflowState().hashCode());
        result = prime * result + ((getWbsName() == null) ? 0 : getWbsName().hashCode());
        result = prime * result + ((getWbsCode() == null) ? 0 : getWbsCode().hashCode());
        result = prime * result + ((getWbsId() == null) ? 0 : getWbsId().hashCode());
        result = prime * result + ((getCompactName() == null) ? 0 : getCompactName().hashCode());
        result = prime * result + ((getCompactCode() == null) ? 0 : getCompactCode().hashCode());
        result = prime * result + ((getSupervisionUnitName() == null) ? 0 : getSupervisionUnitName().hashCode());
        result = prime * result + ((getSupervisionUnitCode() == null) ? 0 : getSupervisionUnitCode().hashCode());
        result = prime * result + ((getSupervisionUnitId() == null) ? 0 : getSupervisionUnitId().hashCode());
        result = prime * result + ((getBuildUnitName() == null) ? 0 : getBuildUnitName().hashCode());
        result = prime * result + ((getBuildUnitCode() == null) ? 0 : getBuildUnitCode().hashCode());
        result = prime * result + ((getBuildUnitId() == null) ? 0 : getBuildUnitId().hashCode());
        result = prime * result + ((getRedactUnitName() == null) ? 0 : getRedactUnitName().hashCode());
        result = prime * result + ((getRedactUnitCode() == null) ? 0 : getRedactUnitCode().hashCode());
        result = prime * result + ((getRedactUnitId() == null) ? 0 : getRedactUnitId().hashCode());
        result = prime * result + ((getRedactDate() == null) ? 0 : getRedactDate().hashCode());
        result = prime * result + ((getWorkOrderName() == null) ? 0 : getWorkOrderName().hashCode());
        result = prime * result + ((getWorkOrderCode() == null) ? 0 : getWorkOrderCode().hashCode());
        result = prime * result + ((getWorkOrderStartDatatime() == null) ? 0 : getWorkOrderStartDatatime().hashCode());
        result = prime * result + ((getWorkOrderEndDatatime() == null) ? 0 : getWorkOrderEndDatatime().hashCode());
        result = prime * result + ((getWorkOrderPlanStartDatatime() == null) ? 0 : getWorkOrderPlanStartDatatime().hashCode());
        result = prime * result + ((getWorkOrderPlanEndDatatime() == null) ? 0 : getWorkOrderPlanEndDatatime().hashCode());
        result = prime * result + ((getImplementationProgram() == null) ? 0 : getImplementationProgram().hashCode());
        result = prime * result + ((getAnnouncements() == null) ? 0 : getAnnouncements().hashCode());
        result = prime * result + ((getWorkOrderType() == null) ? 0 : getWorkOrderType().hashCode());
        result = prime * result + ((getWorkOrderStatus() == null) ? 0 : getWorkOrderStatus().hashCode());
        result = prime * result + ((getWorkOrderAllotUserName() == null) ? 0 : getWorkOrderAllotUserName().hashCode());
        result = prime * result + ((getWorkOrderAllotUserId() == null) ? 0 : getWorkOrderAllotUserId().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getJsId() == null) ? 0 : getJsId().hashCode());
        result = prime * result + ((getZpName() == null) ? 0 : getZpName().hashCode());
        result = prime * result + ((getBl() == null) ? 0 : getBl().hashCode());
        result = prime * result + ((getXbr() == null) ? 0 : getXbr().hashCode());
        result = prime * result + ((getBak1() == null) ? 0 : getBak1().hashCode());
        result = prime * result + ((getBak2() == null) ? 0 : getBak2().hashCode());
        result = prime * result + ((getBak3() == null) ? 0 : getBak3().hashCode());
        result = prime * result + ((getBak4() == null) ? 0 : getBak4().hashCode());
        result = prime * result + ((getBak5() == null) ? 0 : getBak5().hashCode());
        result = prime * result + ((getBak6() == null) ? 0 : getBak6().hashCode());
        result = prime * result + ((getScheduleType() == null) ? 0 : getScheduleType().hashCode());
        result = prime * result + ((getIsSchedule() == null) ? 0 : getIsSchedule().hashCode());
        result = prime * result + ((getScheduleDate() == null) ? 0 : getScheduleDate().hashCode());
        result = prime * result + ((getBak7() == null) ? 0 : getBak7().hashCode());
        result = prime * result + ((getBak8() == null) ? 0 : getBak8().hashCode());
        result = prime * result + ((getBak9() == null) ? 0 : getBak9().hashCode());
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
        sb.append(", workflowState=").append(workflowState);
        sb.append(", wbsName=").append(wbsName);
        sb.append(", wbsCode=").append(wbsCode);
        sb.append(", wbsId=").append(wbsId);
        sb.append(", compactName=").append(compactName);
        sb.append(", compactCode=").append(compactCode);
        sb.append(", supervisionUnitName=").append(supervisionUnitName);
        sb.append(", supervisionUnitCode=").append(supervisionUnitCode);
        sb.append(", supervisionUnitId=").append(supervisionUnitId);
        sb.append(", buildUnitName=").append(buildUnitName);
        sb.append(", buildUnitCode=").append(buildUnitCode);
        sb.append(", buildUnitId=").append(buildUnitId);
        sb.append(", redactUnitName=").append(redactUnitName);
        sb.append(", redactUnitCode=").append(redactUnitCode);
        sb.append(", redactUnitId=").append(redactUnitId);
        sb.append(", redactDate=").append(redactDate);
        sb.append(", workOrderName=").append(workOrderName);
        sb.append(", workOrderCode=").append(workOrderCode);
        sb.append(", workOrderStartDatatime=").append(workOrderStartDatatime);
        sb.append(", workOrderEndDatatime=").append(workOrderEndDatatime);
        sb.append(", workOrderPlanStartDatatime=").append(workOrderPlanStartDatatime);
        sb.append(", workOrderPlanEndDatatime=").append(workOrderPlanEndDatatime);
        sb.append(", implementationProgram=").append(implementationProgram);
        sb.append(", announcements=").append(announcements);
        sb.append(", workOrderType=").append(workOrderType);
        sb.append(", workOrderStatus=").append(workOrderStatus);
        sb.append(", workOrderAllotUserName=").append(workOrderAllotUserName);
        sb.append(", workOrderAllotUserId=").append(workOrderAllotUserId);
        sb.append(", parentId=").append(parentId);
        sb.append(", jsId=").append(jsId);
        sb.append(", zpName=").append(zpName);
        sb.append(", bl=").append(bl);
        sb.append(", xbr=").append(xbr);
        sb.append(", bak1=").append(bak1);
        sb.append(", bak2=").append(bak2);
        sb.append(", bak3=").append(bak3);
        sb.append(", bak4=").append(bak4);
        sb.append(", bak5=").append(bak5);
        sb.append(", bak6=").append(bak6);
        sb.append(", scheduleType=").append(scheduleType);
        sb.append(", isSchedule=").append(isSchedule);
        sb.append(", scheduleDate=").append(scheduleDate);
        sb.append(", bak7=").append(bak7);
        sb.append(", bak8=").append(bak8);
        sb.append(", bak9=").append(bak9);
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}