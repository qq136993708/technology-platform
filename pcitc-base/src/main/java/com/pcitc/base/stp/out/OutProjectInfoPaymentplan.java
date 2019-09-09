package com.pcitc.base.stp.out;

import java.io.Serializable;

/**
 * out_project_info_paymentplan
 * @author 
 */
public class OutProjectInfoPaymentplan implements Serializable {
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
     * 付款时间
     */
    private String paymentDate;

    /**
     * 拨付批次号
     */
    private String paymentNo;

    /**
     * 拨付金额
     */
    private String pamentYsje;

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

    public String getPamentYsje() {
        return pamentYsje;
    }

    public void setPamentYsje(String pamentYsje) {
        this.pamentYsje = pamentYsje;
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
        OutProjectInfoPaymentplan other = (OutProjectInfoPaymentplan) that;
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
            && (this.getBatchNo() == null ? other.getBatchNo() == null : this.getBatchNo().equals(other.getBatchNo()))
            && (this.getInvoiceStatus() == null ? other.getInvoiceStatus() == null : this.getInvoiceStatus().equals(other.getInvoiceStatus()))
            && (this.getInvoiceFee() == null ? other.getInvoiceFee() == null : this.getInvoiceFee().equals(other.getInvoiceFee()))
            && (this.getInvoiceNum() == null ? other.getInvoiceNum() == null : this.getInvoiceNum().equals(other.getInvoiceNum()))
            && (this.getPayStatus() == null ? other.getPayStatus() == null : this.getPayStatus().equals(other.getPayStatus()))
            && (this.getPayFee() == null ? other.getPayFee() == null : this.getPayFee().equals(other.getPayFee()))
            && (this.getPayNo() == null ? other.getPayNo() == null : this.getPayNo().equals(other.getPayNo()))
            && (this.getPaymentStatus() == null ? other.getPaymentStatus() == null : this.getPaymentStatus().equals(other.getPaymentStatus()))
            && (this.getPaymentDate() == null ? other.getPaymentDate() == null : this.getPaymentDate().equals(other.getPaymentDate()))
            && (this.getPaymentNo() == null ? other.getPaymentNo() == null : this.getPaymentNo().equals(other.getPaymentNo()))
            && (this.getPamentYsje() == null ? other.getPamentYsje() == null : this.getPamentYsje().equals(other.getPamentYsje()))
            && (this.getPaymentYszbxje() == null ? other.getPaymentYszbxje() == null : this.getPaymentYszbxje().equals(other.getPaymentYszbxje()))
            && (this.getPaymentYsfyxje() == null ? other.getPaymentYsfyxje() == null : this.getPaymentYsfyxje().equals(other.getPaymentYsfyxje()))
            && (this.getProjectIdMd5() == null ? other.getProjectIdMd5() == null : this.getProjectIdMd5().equals(other.getProjectIdMd5()))
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
        result = prime * result + ((getBatchNo() == null) ? 0 : getBatchNo().hashCode());
        result = prime * result + ((getInvoiceStatus() == null) ? 0 : getInvoiceStatus().hashCode());
        result = prime * result + ((getInvoiceFee() == null) ? 0 : getInvoiceFee().hashCode());
        result = prime * result + ((getInvoiceNum() == null) ? 0 : getInvoiceNum().hashCode());
        result = prime * result + ((getPayStatus() == null) ? 0 : getPayStatus().hashCode());
        result = prime * result + ((getPayFee() == null) ? 0 : getPayFee().hashCode());
        result = prime * result + ((getPayNo() == null) ? 0 : getPayNo().hashCode());
        result = prime * result + ((getPaymentStatus() == null) ? 0 : getPaymentStatus().hashCode());
        result = prime * result + ((getPaymentDate() == null) ? 0 : getPaymentDate().hashCode());
        result = prime * result + ((getPaymentNo() == null) ? 0 : getPaymentNo().hashCode());
        result = prime * result + ((getPamentYsje() == null) ? 0 : getPamentYsje().hashCode());
        result = prime * result + ((getPaymentYszbxje() == null) ? 0 : getPaymentYszbxje().hashCode());
        result = prime * result + ((getPaymentYsfyxje() == null) ? 0 : getPaymentYsfyxje().hashCode());
        result = prime * result + ((getProjectIdMd5() == null) ? 0 : getProjectIdMd5().hashCode());
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
        sb.append(", batchNo=").append(batchNo);
        sb.append(", invoiceStatus=").append(invoiceStatus);
        sb.append(", invoiceFee=").append(invoiceFee);
        sb.append(", invoiceNum=").append(invoiceNum);
        sb.append(", payStatus=").append(payStatus);
        sb.append(", payFee=").append(payFee);
        sb.append(", payNo=").append(payNo);
        sb.append(", paymentStatus=").append(paymentStatus);
        sb.append(", paymentDate=").append(paymentDate);
        sb.append(", paymentNo=").append(paymentNo);
        sb.append(", pamentYsje=").append(pamentYsje);
        sb.append(", paymentYszbxje=").append(paymentYszbxje);
        sb.append(", paymentYsfyxje=").append(paymentYsfyxje);
        sb.append(", projectIdMd5=").append(projectIdMd5);
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