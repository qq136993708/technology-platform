package com.pcitc.base.engin.qualification.blacklist;

import java.io.Serializable;

/**
 * qlfc_user_blacklist
 * @author 
 */
public class QlfcUserBlacklistVo implements Serializable {
    /**
     * 黑名单id
     */
    private String qlfcUserBlacklistId;

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
     * 承包商id
     */
    private String comId;

    /**
     * 承包商名称
     */
    private String comName;

    /**
     * 人员姓名
     */
    private String userName;

    /**
     * 身份证号
     */
    private String idNumber;

    /**
     * 入黑名单日期
     */
    private String blackDate;

    /**
     * 解除黑名单日期
     */
    private String removeBlackDate;

    /**
     * 违纪地点
     */
    private String blackPlace;

    /**
     * 登记人员
     */
    private String registPerson;

    /**
     * 登记部门
     */
    private String registUnit;

    /**
     * 违纪主要内容
     */
    private String blackContent;

    /**
     * 解除黑名单说明
     */
    private String removeBlackContent;

    /**
     * 附件
     */
    private String attachment;

    private static final long serialVersionUID = 1L;

    public String getQlfcUserBlacklistId() {
        return qlfcUserBlacklistId;
    }

    public void setQlfcUserBlacklistId(String qlfcUserBlacklistId) {
        this.qlfcUserBlacklistId = qlfcUserBlacklistId;
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

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getBlackDate() {
        return blackDate;
    }

    public void setBlackDate(String blackDate) {
        this.blackDate = blackDate;
    }

    public String getRemoveBlackDate() {
        return removeBlackDate;
    }

    public void setRemoveBlackDate(String removeBlackDate) {
        this.removeBlackDate = removeBlackDate;
    }

    public String getBlackPlace() {
        return blackPlace;
    }

    public void setBlackPlace(String blackPlace) {
        this.blackPlace = blackPlace;
    }

    public String getRegistPerson() {
        return registPerson;
    }

    public void setRegistPerson(String registPerson) {
        this.registPerson = registPerson;
    }

    public String getRegistUnit() {
        return registUnit;
    }

    public void setRegistUnit(String registUnit) {
        this.registUnit = registUnit;
    }

    public String getBlackContent() {
        return blackContent;
    }

    public void setBlackContent(String blackContent) {
        this.blackContent = blackContent;
    }

    public String getRemoveBlackContent() {
        return removeBlackContent;
    }

    public void setRemoveBlackContent(String removeBlackContent) {
        this.removeBlackContent = removeBlackContent;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }
}