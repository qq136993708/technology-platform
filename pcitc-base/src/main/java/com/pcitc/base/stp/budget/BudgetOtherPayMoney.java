package com.pcitc.base.stp.budget;

import java.io.Serializable;

/**
 * out_tem_other_pay_money
 * @author 
 */
public class BudgetOtherPayMoney implements Serializable {
    private String dataId;

    private String creater;

    private String createTime;

    private String updateTime;

    /**
     * 审批状态
     */
    private Integer auditStatus;

    /**
     * 年度
     */
    private String nd;

    /**
     * 处部门编码
     */
    private String organCode;

    /**
     * 处部门名称
     */
    private String organName;

    /**
     * 处部门单位编码
     */
    private String organUnitcode;

    /**
     * 预算分配单位编码
     */
    private String splitCode;

    /**
     * 预算分配单位名称
     */
    private String splitName;

    /**
     * 支出金额
     */
    private Double money;

    /**
     * 支出类型（集团，资产，股份）
     */
    private String budgetType;

    /**
     * 支出日期
     */
    private String payDate;

    private String remark;

    private Integer delFlag;

    private static final long serialVersionUID = 1L;

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getNd() {
        return nd;
    }

    public void setNd(String nd) {
        this.nd = nd;
    }

    public String getOrganCode() {
        return organCode;
    }

    public void setOrganCode(String organCode) {
        this.organCode = organCode;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public String getOrganUnitcode() {
        return organUnitcode;
    }

    public void setOrganUnitcode(String organUnitcode) {
        this.organUnitcode = organUnitcode;
    }

    public String getSplitCode() {
        return splitCode;
    }

    public void setSplitCode(String splitCode) {
        this.splitCode = splitCode;
    }

    public String getSplitName() {
        return splitName;
    }

    public void setSplitName(String splitName) {
        this.splitName = splitName;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getBudgetType() {
        return budgetType;
    }

    public void setBudgetType(String budgetType) {
        this.budgetType = budgetType;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
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
        BudgetOtherPayMoney other = (BudgetOtherPayMoney) that;
        return (this.getDataId() == null ? other.getDataId() == null : this.getDataId().equals(other.getDataId()))
            && (this.getCreater() == null ? other.getCreater() == null : this.getCreater().equals(other.getCreater()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getAuditStatus() == null ? other.getAuditStatus() == null : this.getAuditStatus().equals(other.getAuditStatus()))
            && (this.getNd() == null ? other.getNd() == null : this.getNd().equals(other.getNd()))
            && (this.getOrganCode() == null ? other.getOrganCode() == null : this.getOrganCode().equals(other.getOrganCode()))
            && (this.getOrganName() == null ? other.getOrganName() == null : this.getOrganName().equals(other.getOrganName()))
            && (this.getOrganUnitcode() == null ? other.getOrganUnitcode() == null : this.getOrganUnitcode().equals(other.getOrganUnitcode()))
            && (this.getSplitCode() == null ? other.getSplitCode() == null : this.getSplitCode().equals(other.getSplitCode()))
            && (this.getSplitName() == null ? other.getSplitName() == null : this.getSplitName().equals(other.getSplitName()))
            && (this.getMoney() == null ? other.getMoney() == null : this.getMoney().equals(other.getMoney()))
            && (this.getBudgetType() == null ? other.getBudgetType() == null : this.getBudgetType().equals(other.getBudgetType()))
            && (this.getPayDate() == null ? other.getPayDate() == null : this.getPayDate().equals(other.getPayDate()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataId() == null) ? 0 : getDataId().hashCode());
        result = prime * result + ((getCreater() == null) ? 0 : getCreater().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getAuditStatus() == null) ? 0 : getAuditStatus().hashCode());
        result = prime * result + ((getNd() == null) ? 0 : getNd().hashCode());
        result = prime * result + ((getOrganCode() == null) ? 0 : getOrganCode().hashCode());
        result = prime * result + ((getOrganName() == null) ? 0 : getOrganName().hashCode());
        result = prime * result + ((getOrganUnitcode() == null) ? 0 : getOrganUnitcode().hashCode());
        result = prime * result + ((getSplitCode() == null) ? 0 : getSplitCode().hashCode());
        result = prime * result + ((getSplitName() == null) ? 0 : getSplitName().hashCode());
        result = prime * result + ((getMoney() == null) ? 0 : getMoney().hashCode());
        result = prime * result + ((getBudgetType() == null) ? 0 : getBudgetType().hashCode());
        result = prime * result + ((getPayDate() == null) ? 0 : getPayDate().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dataId=").append(dataId);
        sb.append(", creater=").append(creater);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", auditStatus=").append(auditStatus);
        sb.append(", nd=").append(nd);
        sb.append(", organCode=").append(organCode);
        sb.append(", organName=").append(organName);
        sb.append(", organUnitcode=").append(organUnitcode);
        sb.append(", splitCode=").append(splitCode);
        sb.append(", splitName=").append(splitName);
        sb.append(", money=").append(money);
        sb.append(", budgetType=").append(budgetType);
        sb.append(", payDate=").append(payDate);
        sb.append(", remark=").append(remark);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}