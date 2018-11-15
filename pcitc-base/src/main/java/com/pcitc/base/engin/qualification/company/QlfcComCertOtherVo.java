package com.pcitc.base.engin.qualification.company;

import java.io.Serializable;

/**
 * qlfc_com_cert_other
 * @author 
 */
public class QlfcComCertOtherVo implements Serializable {
    /**
     * 企业其他证书id
     */
    private String qlfcComCertOtherId;

    /**
     * 承包商资质申报id
     */
    private String qlfcComApplyId;

    /**
     * 企业证书类型
     */
    private String comCertType;

    /**
     * 证书名称
     */
    private String comCertName;

    /**
     * 证书编号
     */
    private String comCertNo;

    /**
     * 发证日期
     */
    private String comCertDate;

    /**
     * 证书有效开始日期
     */
    private String comCertStartDate;

    /**
     * 证书有效期截止日期
     */
    private String comCertEndDate;

    /**
     * 证书附件
     */
    private String comCertAttachment;

    /**
     * 状态
     */
    private String status;

    private static final long serialVersionUID = 1L;

    public String getQlfcComCertOtherId() {
        return qlfcComCertOtherId;
    }

    public void setQlfcComCertOtherId(String qlfcComCertOtherId) {
        this.qlfcComCertOtherId = qlfcComCertOtherId;
    }

    public String getQlfcComApplyId() {
        return qlfcComApplyId;
    }

    public void setQlfcComApplyId(String qlfcComApplyId) {
        this.qlfcComApplyId = qlfcComApplyId;
    }

    public String getComCertType() {
        return comCertType;
    }

    public void setComCertType(String comCertType) {
        this.comCertType = comCertType;
    }

    public String getComCertName() {
        return comCertName;
    }

    public void setComCertName(String comCertName) {
        this.comCertName = comCertName;
    }

    public String getComCertNo() {
        return comCertNo;
    }

    public void setComCertNo(String comCertNo) {
        this.comCertNo = comCertNo;
    }

    public String getComCertDate() {
        return comCertDate;
    }

    public void setComCertDate(String comCertDate) {
        this.comCertDate = comCertDate;
    }

    public String getComCertStartDate() {
        return comCertStartDate;
    }

    public void setComCertStartDate(String comCertStartDate) {
        this.comCertStartDate = comCertStartDate;
    }

    public String getComCertEndDate() {
        return comCertEndDate;
    }

    public void setComCertEndDate(String comCertEndDate) {
        this.comCertEndDate = comCertEndDate;
    }

    public String getComCertAttachment() {
        return comCertAttachment;
    }

    public void setComCertAttachment(String comCertAttachment) {
        this.comCertAttachment = comCertAttachment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}