package com.pcitc.base.stp.out;

import java.io.Serializable;

/**
 * out_project_invoices
 * @author 
 */
public class OutProjectInvoices implements Serializable {
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
     * 报销批次
     */
    private String batchNo;

    /**
     * 发票状态
     */
    private Integer invoiceStatus;

    /**
     * 发票金额
     */
    private Double invoiceFee;

    /**
     * 发票张数
     */
    private Integer invoiceNum;

    /**
     * 发票收取时间
     */
    private String invoiceDate;

    /**
     * 付款状态
     */
    private Integer paymentStatus;

    /**
     * 付款时间
     */
    private String paymentDate;

    /**
     * 付款单号
     */
    private String paymentNo;

    /**
     * 项目唯一识别码
     */
    private String projectIdMd5;

    /**
     * 对应out_project_info表define8
     */
    private String define8;

    /**
     * 对应out_project_info表define9
     */
    private String define9;

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

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public Integer getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(Integer invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public Double getInvoiceFee() {
        return invoiceFee;
    }

    public void setInvoiceFee(Double invoiceFee) {
        this.invoiceFee = invoiceFee;
    }

    public Integer getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(Integer invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
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

    public String getProjectIdMd5() {
        return projectIdMd5;
    }

    public void setProjectIdMd5(String projectIdMd5) {
        this.projectIdMd5 = projectIdMd5;
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
        OutProjectInvoices other = (OutProjectInvoices) that;
        return (this.getDataId() == null ? other.getDataId() == null : this.getDataId().equals(other.getDataId()))
            && (this.getNd() == null ? other.getNd() == null : this.getNd().equals(other.getNd()))
            && (this.getXmid() == null ? other.getXmid() == null : this.getXmid().equals(other.getXmid()))
            && (this.getXmmc() == null ? other.getXmmc() == null : this.getXmmc().equals(other.getXmmc()))
            && (this.getHth() == null ? other.getHth() == null : this.getHth().equals(other.getHth()))
            && (this.getYsnd() == null ? other.getYsnd() == null : this.getYsnd().equals(other.getYsnd()))
            && (this.getBatchNo() == null ? other.getBatchNo() == null : this.getBatchNo().equals(other.getBatchNo()))
            && (this.getInvoiceStatus() == null ? other.getInvoiceStatus() == null : this.getInvoiceStatus().equals(other.getInvoiceStatus()))
            && (this.getInvoiceFee() == null ? other.getInvoiceFee() == null : this.getInvoiceFee().equals(other.getInvoiceFee()))
            && (this.getInvoiceNum() == null ? other.getInvoiceNum() == null : this.getInvoiceNum().equals(other.getInvoiceNum()))
            && (this.getInvoiceDate() == null ? other.getInvoiceDate() == null : this.getInvoiceDate().equals(other.getInvoiceDate()))
            && (this.getPaymentStatus() == null ? other.getPaymentStatus() == null : this.getPaymentStatus().equals(other.getPaymentStatus()))
            && (this.getPaymentDate() == null ? other.getPaymentDate() == null : this.getPaymentDate().equals(other.getPaymentDate()))
            && (this.getPaymentNo() == null ? other.getPaymentNo() == null : this.getPaymentNo().equals(other.getPaymentNo()))
            && (this.getProjectIdMd5() == null ? other.getProjectIdMd5() == null : this.getProjectIdMd5().equals(other.getProjectIdMd5()))
            && (this.getDefine8() == null ? other.getDefine8() == null : this.getDefine8().equals(other.getDefine8()))
            && (this.getDefine9() == null ? other.getDefine9() == null : this.getDefine9().equals(other.getDefine9()));
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
        result = prime * result + ((getBatchNo() == null) ? 0 : getBatchNo().hashCode());
        result = prime * result + ((getInvoiceStatus() == null) ? 0 : getInvoiceStatus().hashCode());
        result = prime * result + ((getInvoiceFee() == null) ? 0 : getInvoiceFee().hashCode());
        result = prime * result + ((getInvoiceNum() == null) ? 0 : getInvoiceNum().hashCode());
        result = prime * result + ((getInvoiceDate() == null) ? 0 : getInvoiceDate().hashCode());
        result = prime * result + ((getPaymentStatus() == null) ? 0 : getPaymentStatus().hashCode());
        result = prime * result + ((getPaymentDate() == null) ? 0 : getPaymentDate().hashCode());
        result = prime * result + ((getPaymentNo() == null) ? 0 : getPaymentNo().hashCode());
        result = prime * result + ((getProjectIdMd5() == null) ? 0 : getProjectIdMd5().hashCode());
        result = prime * result + ((getDefine8() == null) ? 0 : getDefine8().hashCode());
        result = prime * result + ((getDefine9() == null) ? 0 : getDefine9().hashCode());
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
        sb.append(", batchNo=").append(batchNo);
        sb.append(", invoiceStatus=").append(invoiceStatus);
        sb.append(", invoiceFee=").append(invoiceFee);
        sb.append(", invoiceNum=").append(invoiceNum);
        sb.append(", invoiceDate=").append(invoiceDate);
        sb.append(", paymentStatus=").append(paymentStatus);
        sb.append(", paymentDate=").append(paymentDate);
        sb.append(", paymentNo=").append(paymentNo);
        sb.append(", projectIdMd5=").append(projectIdMd5);
        sb.append(", define8=").append(define8);
        sb.append(", define9=").append(define9);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}