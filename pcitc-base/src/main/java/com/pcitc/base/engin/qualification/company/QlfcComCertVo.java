package com.pcitc.base.engin.qualification.company;

import com.pcitc.base.util.SearchInfo;

import java.io.Serializable;

/**
 * qlfc_com_cert
 * @author 
 */
public class QlfcComCertVo extends SearchInfo implements Serializable {
    /**
     * 企业资质证书id
     */
    private String qlfcComCertId;

    /**
     * 承包商资质申报id
     */
    private String qlfcComApplyId;

    /**
     * 资质类别
     */
    private String qlfcType;

    /**
     * 资质证书编号
     */
    private String qlfcCertNo;

    /**
     * 资质名称
     */
    private String qlfcName;

    /**
     * 发证日期
     */
    private String comCertDate;

    /**
     * 证书有效期
     */
    private String comCertInvalidTime;

    /**
     * 发证机关
     */
    private String comCertOrgan;

    /**
     * 证书附件
     */
    private String comCertAttachment;

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
     * 业务表单状态(1、生效；0、作废，默认1)
     */
    private Integer status;

    /**
     * 工作流状态
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
     * 业务表单code
     */
    private String formCode;

    private static final long serialVersionUID = 1L;

    public String getQlfcComCertId() {
        return qlfcComCertId;
    }

    public void setQlfcComCertId(String qlfcComCertId) {
        this.qlfcComCertId = qlfcComCertId;
    }

    public String getQlfcComApplyId() {
        return qlfcComApplyId;
    }

    public void setQlfcComApplyId(String qlfcComApplyId) {
        this.qlfcComApplyId = qlfcComApplyId;
    }

    public String getQlfcType() {
        return qlfcType;
    }

    public void setQlfcType(String qlfcType) {
        this.qlfcType = qlfcType;
    }

    public String getQlfcCertNo() {
        return qlfcCertNo;
    }

    public void setQlfcCertNo(String qlfcCertNo) {
        this.qlfcCertNo = qlfcCertNo;
    }

    public String getQlfcName() {
        return qlfcName;
    }

    public void setQlfcName(String qlfcName) {
        this.qlfcName = qlfcName;
    }

    public String getComCertDate() {
        return comCertDate;
    }

    public void setComCertDate(String comCertDate) {
        this.comCertDate = comCertDate;
    }

    public String getComCertInvalidTime() {
        return comCertInvalidTime;
    }

    public void setComCertInvalidTime(String comCertInvalidTime) {
        this.comCertInvalidTime = comCertInvalidTime;
    }

    public String getComCertOrgan() {
        return comCertOrgan;
    }

    public void setComCertOrgan(String comCertOrgan) {
        this.comCertOrgan = comCertOrgan;
    }

    public String getComCertAttachment() {
        return comCertAttachment;
    }

    public void setComCertAttachment(String comCertAttachment) {
        this.comCertAttachment = comCertAttachment;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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
}