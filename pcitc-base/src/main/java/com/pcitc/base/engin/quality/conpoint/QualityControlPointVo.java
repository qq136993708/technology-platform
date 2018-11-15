package com.pcitc.base.engin.quality.conpoint;

import java.io.Serializable;

/**
 * quality_control_point
 * @author 
 */
public class QualityControlPointVo implements Serializable {
    /**
     * 机具id
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
     * 项目名称
     */
    private String projectName;

    /**
     * 编码
     */
    private String formCode;

    /**
     * 控制点申报id
     */
    private String reportId;

    /**
     * 所属单项工程
     */
    private String wbsId;

    /**
     * wbs名称(单项工程）
     */
    private String wbsName;

    /**
     * 施工单位（所属承包商）
     */
    private String contractor;

    /**
     * 控制点名称
     */
    private String pointName;

    /**
     * 控制点等级
     */
    private String pointLevel;

    /**
     * 专业名称
     */
    private String professionalName;

    /**
     * 报验时机
     */
    private String inspectionTime;

    /**
     * 主要备查材料
     */
    private String mainMaterials;

    /**
     * 停监点
     */
    private String stoppingPoint;

    /**
     * 自检日期
     */
    private String selfCheckingDate;

    /**
     * 报验状态
     */
    private String inspectionStatus;

    /**
     * 报验次数
     */
    private String inspectionCount;

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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getFormCode() {
        return formCode;
    }

    public void setFormCode(String formCode) {
        this.formCode = formCode;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getWbsId() {
        return wbsId;
    }

    public void setWbsId(String wbsId) {
        this.wbsId = wbsId;
    }

    public String getWbsName() {
        return wbsName;
    }

    public void setWbsName(String wbsName) {
        this.wbsName = wbsName;
    }

    public String getContractor() {
        return contractor;
    }

    public void setContractor(String contractor) {
        this.contractor = contractor;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public String getPointLevel() {
        return pointLevel;
    }

    public void setPointLevel(String pointLevel) {
        this.pointLevel = pointLevel;
    }

    public String getProfessionalName() {
        return professionalName;
    }

    public void setProfessionalName(String professionalName) {
        this.professionalName = professionalName;
    }

    public String getInspectionTime() {
        return inspectionTime;
    }

    public void setInspectionTime(String inspectionTime) {
        this.inspectionTime = inspectionTime;
    }

    public String getMainMaterials() {
        return mainMaterials;
    }

    public void setMainMaterials(String mainMaterials) {
        this.mainMaterials = mainMaterials;
    }

    public String getStoppingPoint() {
        return stoppingPoint;
    }

    public void setStoppingPoint(String stoppingPoint) {
        this.stoppingPoint = stoppingPoint;
    }

    public String getSelfCheckingDate() {
        return selfCheckingDate;
    }

    public void setSelfCheckingDate(String selfCheckingDate) {
        this.selfCheckingDate = selfCheckingDate;
    }

    public String getInspectionStatus() {
        return inspectionStatus;
    }

    public void setInspectionStatus(String inspectionStatus) {
        this.inspectionStatus = inspectionStatus;
    }

    public String getInspectionCount() {
        return inspectionCount;
    }

    public void setInspectionCount(String inspectionCount) {
        this.inspectionCount = inspectionCount;
    }

}