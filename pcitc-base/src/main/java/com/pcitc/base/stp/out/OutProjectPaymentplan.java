package com.pcitc.base.stp.out;

import java.io.Serializable;

/**
 * out_project_paymentplan
 * @author 
 */
public class OutProjectPaymentplan implements Serializable {
    /**
     * 主键
     */
    private String dataId;

    /**
     * 合同年度
     */
    private String nd;

    /**
     * 项目ID
     */
    private String xmid;

    /**
     * 项目名称
     */
    private String xmmc;

    /**
     * 合同号
     */
    private String hth;

    /**
     * 预算年度
     */
    private String ysnd;

    /**
     * 预算金额
     */
    private String ysje;

    /**
     * 预算金额资本性
     */
    private String yszbxje;

    /**
     * 预算金额费用性
     */
    private String ysfyxje;

    /**
     * 负责单位
     */
    private String fzdw;

    /**
     * 负责单位代码
     */
    private String fzdwbm;

    /**
     * 是否需要发票（1，需要）
     */
    private Integer invoiceNeed;

    /**
     * 发票抬头（企业名称）
     */
    private String invoiceCompanyName;

    /**
     * 纳税人识别号（企业统一信用代码）
     */
    private String invoiceCompanyCode;

    /**
     * 开户行名称
     */
    private String invoiceBankName;

    /**
     * 银行开户账号
     */
    private String invoiceBankNo;

    /**
     * 联系人姓名
     */
    private String invoiceContactName;

    /**
     * 联系人电话
     */
    private String invoiceContactPhone;

    /**
     * 联系人邮箱
     */
    private String invoiceContactEmail;

    /**
     * 支付状态
     */
    private Integer payStatus;

    /**
     * 支付金额
     */
    private Double payFee;

    /**
     * 报销批次号
     */
    private String payNo;

    /**
     * 拨付状态
     */
    private Integer paymentStatus;

    /**
     * 拨付时间
     */
    private String paymentDate;

    /**
     * 拨付批次号
     */
    private String paymentNo;

    /**
     * 拨付金额
     */
    private String paymentYsje;

    /**
     * 拨付金额资本性
     */
    private String paymentYszbxje;

    /**
     * 拨付金额费用性
     */
    private String paymentYsfyxje;

    /**
     * 项目唯一识别码
     */
    private String projectIdMd5;

    private String projectId;

    private Integer delFlag;

    /**
     * 对应out_project_info表define8
     */
    private String define8;

    /**
     * 对应out_project_info表define9
     */
    private String define9;

    /**
     * 对应out_project_info字段
     */
    private String define10;

    private String define11;

    private String define12;

    private static final long serialVersionUID = 1L;

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getNd() {
        return nd;
    }

    public void setNd(String nd) {
        this.nd = nd;
    }

    public String getXmid() {
        return xmid;
    }

    public void setXmid(String xmid) {
        this.xmid = xmid;
    }

    public String getXmmc() {
        return xmmc;
    }

    public void setXmmc(String xmmc) {
        this.xmmc = xmmc;
    }

    public String getHth() {
        return hth;
    }

    public void setHth(String hth) {
        this.hth = hth;
    }

    public String getYsnd() {
        return ysnd;
    }

    public void setYsnd(String ysnd) {
        this.ysnd = ysnd;
    }

    public String getYsje() {
        return ysje;
    }

    public void setYsje(String ysje) {
        this.ysje = ysje;
    }

    public String getYszbxje() {
        return yszbxje;
    }

    public void setYszbxje(String yszbxje) {
        this.yszbxje = yszbxje;
    }

    public String getYsfyxje() {
        return ysfyxje;
    }

    public void setYsfyxje(String ysfyxje) {
        this.ysfyxje = ysfyxje;
    }

    public String getFzdw() {
        return fzdw;
    }

    public void setFzdw(String fzdw) {
        this.fzdw = fzdw;
    }

    public String getFzdwbm() {
        return fzdwbm;
    }

    public void setFzdwbm(String fzdwbm) {
        this.fzdwbm = fzdwbm;
    }

    public Integer getInvoiceNeed() {
        return invoiceNeed;
    }

    public void setInvoiceNeed(Integer invoiceNeed) {
        this.invoiceNeed = invoiceNeed;
    }

    public String getInvoiceCompanyName() {
        return invoiceCompanyName;
    }

    public void setInvoiceCompanyName(String invoiceCompanyName) {
        this.invoiceCompanyName = invoiceCompanyName;
    }

    public String getInvoiceCompanyCode() {
        return invoiceCompanyCode;
    }

    public void setInvoiceCompanyCode(String invoiceCompanyCode) {
        this.invoiceCompanyCode = invoiceCompanyCode;
    }

    public String getInvoiceBankName() {
        return invoiceBankName;
    }

    public void setInvoiceBankName(String invoiceBankName) {
        this.invoiceBankName = invoiceBankName;
    }

    public String getInvoiceBankNo() {
        return invoiceBankNo;
    }

    public void setInvoiceBankNo(String invoiceBankNo) {
        this.invoiceBankNo = invoiceBankNo;
    }

    public String getInvoiceContactName() {
        return invoiceContactName;
    }

    public void setInvoiceContactName(String invoiceContactName) {
        this.invoiceContactName = invoiceContactName;
    }

    public String getInvoiceContactPhone() {
        return invoiceContactPhone;
    }

    public void setInvoiceContactPhone(String invoiceContactPhone) {
        this.invoiceContactPhone = invoiceContactPhone;
    }

    public String getInvoiceContactEmail() {
        return invoiceContactEmail;
    }

    public void setInvoiceContactEmail(String invoiceContactEmail) {
        this.invoiceContactEmail = invoiceContactEmail;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Double getPayFee() {
        return payFee;
    }

    public void setPayFee(Double payFee) {
        this.payFee = payFee;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo(String paymentNo) {
        this.paymentNo = paymentNo;
    }

    public String getPaymentYsje() {
        return paymentYsje;
    }

    public void setPaymentYsje(String paymentYsje) {
        this.paymentYsje = paymentYsje;
    }

    public String getPaymentYszbxje() {
        return paymentYszbxje;
    }

    public void setPaymentYszbxje(String paymentYszbxje) {
        this.paymentYszbxje = paymentYszbxje;
    }

    public String getPaymentYsfyxje() {
        return paymentYsfyxje;
    }

    public void setPaymentYsfyxje(String paymentYsfyxje) {
        this.paymentYsfyxje = paymentYsfyxje;
    }

    public String getProjectIdMd5() {
        return projectIdMd5;
    }

    public void setProjectIdMd5(String projectIdMd5) {
        this.projectIdMd5 = projectIdMd5;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getDefine8() {
        return define8;
    }

    public void setDefine8(String define8) {
        this.define8 = define8;
    }

    public String getDefine9() {
        return define9;
    }

    public void setDefine9(String define9) {
        this.define9 = define9;
    }

    public String getDefine10() {
        return define10;
    }

    public void setDefine10(String define10) {
        this.define10 = define10;
    }

    public String getDefine11() {
        return define11;
    }

    public void setDefine11(String define11) {
        this.define11 = define11;
    }

    public String getDefine12() {
        return define12;
    }

    public void setDefine12(String define12) {
        this.define12 = define12;
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
        OutProjectPaymentplan other = (OutProjectPaymentplan) that;
        return (this.getDataId() == null ? other.getDataId() == null : this.getDataId().equals(other.getDataId()))
            && (this.getNd() == null ? other.getNd() == null : this.getNd().equals(other.getNd()))
            && (this.getXmid() == null ? other.getXmid() == null : this.getXmid().equals(other.getXmid()))
            && (this.getXmmc() == null ? other.getXmmc() == null : this.getXmmc().equals(other.getXmmc()))
            && (this.getHth() == null ? other.getHth() == null : this.getHth().equals(other.getHth()))
            && (this.getYsnd() == null ? other.getYsnd() == null : this.getYsnd().equals(other.getYsnd()))
            && (this.getYsje() == null ? other.getYsje() == null : this.getYsje().equals(other.getYsje()))
            && (this.getYszbxje() == null ? other.getYszbxje() == null : this.getYszbxje().equals(other.getYszbxje()))
            && (this.getYsfyxje() == null ? other.getYsfyxje() == null : this.getYsfyxje().equals(other.getYsfyxje()))
            && (this.getFzdw() == null ? other.getFzdw() == null : this.getFzdw().equals(other.getFzdw()))
            && (this.getFzdwbm() == null ? other.getFzdwbm() == null : this.getFzdwbm().equals(other.getFzdwbm()))
            && (this.getInvoiceNeed() == null ? other.getInvoiceNeed() == null : this.getInvoiceNeed().equals(other.getInvoiceNeed()))
            && (this.getInvoiceCompanyName() == null ? other.getInvoiceCompanyName() == null : this.getInvoiceCompanyName().equals(other.getInvoiceCompanyName()))
            && (this.getInvoiceCompanyCode() == null ? other.getInvoiceCompanyCode() == null : this.getInvoiceCompanyCode().equals(other.getInvoiceCompanyCode()))
            && (this.getInvoiceBankName() == null ? other.getInvoiceBankName() == null : this.getInvoiceBankName().equals(other.getInvoiceBankName()))
            && (this.getInvoiceBankNo() == null ? other.getInvoiceBankNo() == null : this.getInvoiceBankNo().equals(other.getInvoiceBankNo()))
            && (this.getInvoiceContactName() == null ? other.getInvoiceContactName() == null : this.getInvoiceContactName().equals(other.getInvoiceContactName()))
            && (this.getInvoiceContactPhone() == null ? other.getInvoiceContactPhone() == null : this.getInvoiceContactPhone().equals(other.getInvoiceContactPhone()))
            && (this.getInvoiceContactEmail() == null ? other.getInvoiceContactEmail() == null : this.getInvoiceContactEmail().equals(other.getInvoiceContactEmail()))
            && (this.getPayStatus() == null ? other.getPayStatus() == null : this.getPayStatus().equals(other.getPayStatus()))
            && (this.getPayFee() == null ? other.getPayFee() == null : this.getPayFee().equals(other.getPayFee()))
            && (this.getPayNo() == null ? other.getPayNo() == null : this.getPayNo().equals(other.getPayNo()))
            && (this.getPaymentStatus() == null ? other.getPaymentStatus() == null : this.getPaymentStatus().equals(other.getPaymentStatus()))
            && (this.getPaymentDate() == null ? other.getPaymentDate() == null : this.getPaymentDate().equals(other.getPaymentDate()))
            && (this.getPaymentNo() == null ? other.getPaymentNo() == null : this.getPaymentNo().equals(other.getPaymentNo()))
            && (this.getPaymentYsje() == null ? other.getPaymentYsje() == null : this.getPaymentYsje().equals(other.getPaymentYsje()))
            && (this.getPaymentYszbxje() == null ? other.getPaymentYszbxje() == null : this.getPaymentYszbxje().equals(other.getPaymentYszbxje()))
            && (this.getPaymentYsfyxje() == null ? other.getPaymentYsfyxje() == null : this.getPaymentYsfyxje().equals(other.getPaymentYsfyxje()))
            && (this.getProjectIdMd5() == null ? other.getProjectIdMd5() == null : this.getProjectIdMd5().equals(other.getProjectIdMd5()))
            && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()))
            && (this.getDefine8() == null ? other.getDefine8() == null : this.getDefine8().equals(other.getDefine8()))
            && (this.getDefine9() == null ? other.getDefine9() == null : this.getDefine9().equals(other.getDefine9()))
            && (this.getDefine10() == null ? other.getDefine10() == null : this.getDefine10().equals(other.getDefine10()))
            && (this.getDefine11() == null ? other.getDefine11() == null : this.getDefine11().equals(other.getDefine11()))
            && (this.getDefine12() == null ? other.getDefine12() == null : this.getDefine12().equals(other.getDefine12()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataId() == null) ? 0 : getDataId().hashCode());
        result = prime * result + ((getNd() == null) ? 0 : getNd().hashCode());
        result = prime * result + ((getXmid() == null) ? 0 : getXmid().hashCode());
        result = prime * result + ((getXmmc() == null) ? 0 : getXmmc().hashCode());
        result = prime * result + ((getHth() == null) ? 0 : getHth().hashCode());
        result = prime * result + ((getYsnd() == null) ? 0 : getYsnd().hashCode());
        result = prime * result + ((getYsje() == null) ? 0 : getYsje().hashCode());
        result = prime * result + ((getYszbxje() == null) ? 0 : getYszbxje().hashCode());
        result = prime * result + ((getYsfyxje() == null) ? 0 : getYsfyxje().hashCode());
        result = prime * result + ((getFzdw() == null) ? 0 : getFzdw().hashCode());
        result = prime * result + ((getFzdwbm() == null) ? 0 : getFzdwbm().hashCode());
        result = prime * result + ((getInvoiceNeed() == null) ? 0 : getInvoiceNeed().hashCode());
        result = prime * result + ((getInvoiceCompanyName() == null) ? 0 : getInvoiceCompanyName().hashCode());
        result = prime * result + ((getInvoiceCompanyCode() == null) ? 0 : getInvoiceCompanyCode().hashCode());
        result = prime * result + ((getInvoiceBankName() == null) ? 0 : getInvoiceBankName().hashCode());
        result = prime * result + ((getInvoiceBankNo() == null) ? 0 : getInvoiceBankNo().hashCode());
        result = prime * result + ((getInvoiceContactName() == null) ? 0 : getInvoiceContactName().hashCode());
        result = prime * result + ((getInvoiceContactPhone() == null) ? 0 : getInvoiceContactPhone().hashCode());
        result = prime * result + ((getInvoiceContactEmail() == null) ? 0 : getInvoiceContactEmail().hashCode());
        result = prime * result + ((getPayStatus() == null) ? 0 : getPayStatus().hashCode());
        result = prime * result + ((getPayFee() == null) ? 0 : getPayFee().hashCode());
        result = prime * result + ((getPayNo() == null) ? 0 : getPayNo().hashCode());
        result = prime * result + ((getPaymentStatus() == null) ? 0 : getPaymentStatus().hashCode());
        result = prime * result + ((getPaymentDate() == null) ? 0 : getPaymentDate().hashCode());
        result = prime * result + ((getPaymentNo() == null) ? 0 : getPaymentNo().hashCode());
        result = prime * result + ((getPaymentYsje() == null) ? 0 : getPaymentYsje().hashCode());
        result = prime * result + ((getPaymentYszbxje() == null) ? 0 : getPaymentYszbxje().hashCode());
        result = prime * result + ((getPaymentYsfyxje() == null) ? 0 : getPaymentYsfyxje().hashCode());
        result = prime * result + ((getProjectIdMd5() == null) ? 0 : getProjectIdMd5().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        result = prime * result + ((getDefine8() == null) ? 0 : getDefine8().hashCode());
        result = prime * result + ((getDefine9() == null) ? 0 : getDefine9().hashCode());
        result = prime * result + ((getDefine10() == null) ? 0 : getDefine10().hashCode());
        result = prime * result + ((getDefine11() == null) ? 0 : getDefine11().hashCode());
        result = prime * result + ((getDefine12() == null) ? 0 : getDefine12().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dataId=").append(dataId);
        sb.append(", nd=").append(nd);
        sb.append(", xmid=").append(xmid);
        sb.append(", xmmc=").append(xmmc);
        sb.append(", hth=").append(hth);
        sb.append(", ysnd=").append(ysnd);
        sb.append(", ysje=").append(ysje);
        sb.append(", yszbxje=").append(yszbxje);
        sb.append(", ysfyxje=").append(ysfyxje);
        sb.append(", fzdw=").append(fzdw);
        sb.append(", fzdwbm=").append(fzdwbm);
        sb.append(", invoiceNeed=").append(invoiceNeed);
        sb.append(", invoiceCompanyName=").append(invoiceCompanyName);
        sb.append(", invoiceCompanyCode=").append(invoiceCompanyCode);
        sb.append(", invoiceBankName=").append(invoiceBankName);
        sb.append(", invoiceBankNo=").append(invoiceBankNo);
        sb.append(", invoiceContactName=").append(invoiceContactName);
        sb.append(", invoiceContactPhone=").append(invoiceContactPhone);
        sb.append(", invoiceContactEmail=").append(invoiceContactEmail);
        sb.append(", payStatus=").append(payStatus);
        sb.append(", payFee=").append(payFee);
        sb.append(", payNo=").append(payNo);
        sb.append(", paymentStatus=").append(paymentStatus);
        sb.append(", paymentDate=").append(paymentDate);
        sb.append(", paymentNo=").append(paymentNo);
        sb.append(", paymentYsje=").append(paymentYsje);
        sb.append(", paymentYszbxje=").append(paymentYszbxje);
        sb.append(", paymentYsfyxje=").append(paymentYsfyxje);
        sb.append(", projectIdMd5=").append(projectIdMd5);
        sb.append(", projectId=").append(projectId);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", define8=").append(define8);
        sb.append(", define9=").append(define9);
        sb.append(", define10=").append(define10);
        sb.append(", define11=").append(define11);
        sb.append(", define12=").append(define12);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}