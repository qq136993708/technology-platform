package com.pcitc.base.engin.design.project;

import com.pcitc.base.util.SearchInfo;

import java.io.Serializable;

/**
 * design_project_basic_report
 * @author ms
 */
public class DesignProjectBasicReportVo extends SearchInfo implements Serializable {
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
     * 公司代码
     */
    private String companyCode;

    /**
     * 所属项目
     */
    private String projectId;

    /**
     * 业务编码
     */
    private String formCode;

    /**
     * 设计单位名称
     */
    private String designUnit;

    /**
     * 项目属地
     */
    private String projectFrom;

    /**
     * 可研批复文号
     */
    private String kypfNo;

    /**
     * 基础设计批复文号
     */
    private String jcsjpfNo;

    /**
     * 基础设计批复日期
     */
    private String jcsjpfDate;

    /**
     * 项目概算(元)
     */
    private String projectBudget;

    /**
     * 开工日期
     */
    private String workonDate;

    /**
     * 完工日期
     */
    private String workoffDate;

    /**
     * 基础设计上报文号
     */
    private String jcsjsbNo;

    private String ex;

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

    public String getFormCode() {
        return formCode;
    }

    public void setFormCode(String formCode) {
        this.formCode = formCode;
    }

    public String getDesignUnit() {
        return designUnit;
    }

    public void setDesignUnit(String designUnit) {
        this.designUnit = designUnit;
    }

    public String getProjectFrom() {
        return projectFrom;
    }

    public void setProjectFrom(String projectFrom) {
        this.projectFrom = projectFrom;
    }

    public String getKypfNo() {
        return kypfNo;
    }

    public void setKypfNo(String kypfNo) {
        this.kypfNo = kypfNo;
    }

    public String getJcsjpfNo() {
        return jcsjpfNo;
    }

    public void setJcsjpfNo(String jcsjpfNo) {
        this.jcsjpfNo = jcsjpfNo;
    }

    public String getJcsjpfDate() {
        return jcsjpfDate;
    }

    public void setJcsjpfDate(String jcsjpfDate) {
        this.jcsjpfDate = jcsjpfDate;
    }

    public String getProjectBudget() {
        return projectBudget;
    }

    public void setProjectBudget(String projectBudget) {
        this.projectBudget = projectBudget;
    }

    public String getWorkonDate() {
        return workonDate;
    }

    public void setWorkonDate(String workonDate) {
        this.workonDate = workonDate;
    }

    public String getWorkoffDate() {
        return workoffDate;
    }

    public void setWorkoffDate(String workoffDate) {
        this.workoffDate = workoffDate;
    }

    public String getJcsjsbNo() {
        return jcsjsbNo;
    }

    public void setJcsjsbNo(String jcsjsbNo) {
        this.jcsjsbNo = jcsjsbNo;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }
}