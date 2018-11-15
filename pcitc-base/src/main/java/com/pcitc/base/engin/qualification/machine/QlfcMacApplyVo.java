package com.pcitc.base.engin.qualification.machine;

import java.io.Serializable;

/**
 * qlfc_mac_apply
 * @author 
 */
public class QlfcMacApplyVo implements Serializable {
    /**
     * 机具报验id
     */
    private String qlfcMacApplyId;

    /**
     * 业务表单id
     */
    private String formId;

    /**
     * 业务表单code
     */
    private String formCode;

    /**
     * 业务表单状态(1、生效；0、作废，默认1)
     */
    private Integer status;

    /**
     * 业务表单说明/备注/注释
     */
    private String remarks;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建人id
     */
    private String createUserId;

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
     * 工作流状态
     */
    private String auditSts;

    /**
     * 所属承包商
     */
    private String comName;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目编号
     */
    private String projectNo;

    /**
     * 人员姓名
     */
    private String userName;

    /**
     * 报验编号
     */
    private String qlfcMacApplyNo;

    /**
     * 其他
     */
    private String ex;

    private static final long serialVersionUID = 1L;

    public String getQlfcMacApplyId() {
        return qlfcMacApplyId;
    }

    public void setQlfcMacApplyId(String qlfcMacApplyId) {
        this.qlfcMacApplyId = qlfcMacApplyId;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getFormCode() {
        return formCode;
    }

    public void setFormCode(String formCode) {
        this.formCode = formCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
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

    public String getAuditSts() {
        return auditSts;
    }

    public void setAuditSts(String auditSts) {
        this.auditSts = auditSts;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getQlfcMacApplyNo() {
        return qlfcMacApplyNo;
    }

    public void setQlfcMacApplyNo(String qlfcMacApplyNo) {
        this.qlfcMacApplyNo = qlfcMacApplyNo;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }
}