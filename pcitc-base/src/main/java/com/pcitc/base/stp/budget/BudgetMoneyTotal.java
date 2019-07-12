package com.pcitc.base.stp.budget;

import java.io.Serializable;

/**
 * out_tem_money_total
 * @author 
 */
public class BudgetMoneyTotal implements Serializable {
    private Integer dataId;

    private String nd;

    private String showIndex;

    private String unitName;

    private String showAli;

    private String zbxMoney;

    private String fyxMoney;

    private String moneyLevel;

    private String detailsName;

    private String isYjy;

    private String typeName;

    private String sheetFlag;

    private String showOrder;

    private static final long serialVersionUID = 1L;

    public Integer getDataId() {
        return dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }

    public String getNd() {
        return nd;
    }

    public void setNd(String nd) {
        this.nd = nd;
    }

    public String getShowIndex() {
        return showIndex;
    }

    public void setShowIndex(String showIndex) {
        this.showIndex = showIndex;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getShowAli() {
        return showAli;
    }

    public void setShowAli(String showAli) {
        this.showAli = showAli;
    }

    public String getZbxMoney() {
        return zbxMoney;
    }

    public void setZbxMoney(String zbxMoney) {
        this.zbxMoney = zbxMoney;
    }

    public String getFyxMoney() {
        return fyxMoney;
    }

    public void setFyxMoney(String fyxMoney) {
        this.fyxMoney = fyxMoney;
    }

    public String getMoneyLevel() {
        return moneyLevel;
    }

    public void setMoneyLevel(String moneyLevel) {
        this.moneyLevel = moneyLevel;
    }

    public String getDetailsName() {
        return detailsName;
    }

    public void setDetailsName(String detailsName) {
        this.detailsName = detailsName;
    }

    public String getIsYjy() {
        return isYjy;
    }

    public void setIsYjy(String isYjy) {
        this.isYjy = isYjy;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getSheetFlag() {
        return sheetFlag;
    }

    public void setSheetFlag(String sheetFlag) {
        this.sheetFlag = sheetFlag;
    }

    public String getShowOrder() {
        return showOrder;
    }

    public void setShowOrder(String showOrder) {
        this.showOrder = showOrder;
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
        BudgetMoneyTotal other = (BudgetMoneyTotal) that;
        return (this.getDataId() == null ? other.getDataId() == null : this.getDataId().equals(other.getDataId()))
            && (this.getNd() == null ? other.getNd() == null : this.getNd().equals(other.getNd()))
            && (this.getShowIndex() == null ? other.getShowIndex() == null : this.getShowIndex().equals(other.getShowIndex()))
            && (this.getUnitName() == null ? other.getUnitName() == null : this.getUnitName().equals(other.getUnitName()))
            && (this.getShowAli() == null ? other.getShowAli() == null : this.getShowAli().equals(other.getShowAli()))
            && (this.getZbxMoney() == null ? other.getZbxMoney() == null : this.getZbxMoney().equals(other.getZbxMoney()))
            && (this.getFyxMoney() == null ? other.getFyxMoney() == null : this.getFyxMoney().equals(other.getFyxMoney()))
            && (this.getMoneyLevel() == null ? other.getMoneyLevel() == null : this.getMoneyLevel().equals(other.getMoneyLevel()))
            && (this.getDetailsName() == null ? other.getDetailsName() == null : this.getDetailsName().equals(other.getDetailsName()))
            && (this.getIsYjy() == null ? other.getIsYjy() == null : this.getIsYjy().equals(other.getIsYjy()))
            && (this.getTypeName() == null ? other.getTypeName() == null : this.getTypeName().equals(other.getTypeName()))
            && (this.getSheetFlag() == null ? other.getSheetFlag() == null : this.getSheetFlag().equals(other.getSheetFlag()))
            && (this.getShowOrder() == null ? other.getShowOrder() == null : this.getShowOrder().equals(other.getShowOrder()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataId() == null) ? 0 : getDataId().hashCode());
        result = prime * result + ((getNd() == null) ? 0 : getNd().hashCode());
        result = prime * result + ((getShowIndex() == null) ? 0 : getShowIndex().hashCode());
        result = prime * result + ((getUnitName() == null) ? 0 : getUnitName().hashCode());
        result = prime * result + ((getShowAli() == null) ? 0 : getShowAli().hashCode());
        result = prime * result + ((getZbxMoney() == null) ? 0 : getZbxMoney().hashCode());
        result = prime * result + ((getFyxMoney() == null) ? 0 : getFyxMoney().hashCode());
        result = prime * result + ((getMoneyLevel() == null) ? 0 : getMoneyLevel().hashCode());
        result = prime * result + ((getDetailsName() == null) ? 0 : getDetailsName().hashCode());
        result = prime * result + ((getIsYjy() == null) ? 0 : getIsYjy().hashCode());
        result = prime * result + ((getTypeName() == null) ? 0 : getTypeName().hashCode());
        result = prime * result + ((getSheetFlag() == null) ? 0 : getSheetFlag().hashCode());
        result = prime * result + ((getShowOrder() == null) ? 0 : getShowOrder().hashCode());
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
        sb.append(", showIndex=").append(showIndex);
        sb.append(", unitName=").append(unitName);
        sb.append(", showAli=").append(showAli);
        sb.append(", zbxMoney=").append(zbxMoney);
        sb.append(", fyxMoney=").append(fyxMoney);
        sb.append(", moneyLevel=").append(moneyLevel);
        sb.append(", detailsName=").append(detailsName);
        sb.append(", isYjy=").append(isYjy);
        sb.append(", typeName=").append(typeName);
        sb.append(", sheetFlag=").append(sheetFlag);
        sb.append(", showOrder=").append(showOrder);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}