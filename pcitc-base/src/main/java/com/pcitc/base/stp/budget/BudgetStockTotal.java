package com.pcitc.base.stp.budget;

import java.io.Serializable;

/**
 * out_tem_money_stock_total
 * @author 
 */
public class BudgetStockTotal implements Serializable {
    private String dataId;

    private String parentDataId;

    /**
     * 预算年度
     */
    private String nd;

    /**
     * 数据版本号
     */
    private String dataVersion;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 最后更新时间
     */
    private String updateTime;

    /**
     * 创建人
     */
    private String createrName;

    /**
     * 创建人ID
     */
    private String createrId;

    /**
     * 序号
     */
    private Integer no;

    /**
     * 显示名称
     */
    private String displayName;

    /**
     * 简称
     */
    private String simpleName;

    /**
     * 编码(具体到单位时保存单位编码)
     */
    private String displayCode;

    private String simpleCode;

    /**
     * 单位级别（0,1）
     */
    private Integer level;

    /**
     * 项目经费-资本性
     */
    private Double xmjfZbx;

    private Double xmjfZbxJz;

    private Double xmjfZbxXq;

    /**
     * 项目经费-费用性
     */
    private Double xmjfFyx;

    private Double xmjfFyxJz;

    private Double xmjfFyxXq;

    /**
     * 项目经费-总计
     */
    private Double xmjfTotal;

    /**
     * 上年预计完成-资本性
     */
    private Double yjwcZbx;

    /**
     * 上年预计完成-费用性
     */
    private Double yjwcFyx;

    /**
     * 上年预计完成-费用性
     */
    private Double yjwcTotal;

    /**
     * 预算项类型，（1预算项，2预算项参考公司）
     */
    private Integer itemType;

    private String companyCode;

    /**
     * 备注
     */
    private String remark;

    /**
     * 预算表ID
     */
    private String budgetInfoId;

    /**
     * 删除标识
     */
    private Integer delFlag;

    /**
     * 附件
     */
    private String appendFiles;

    private static final long serialVersionUID = 1L;

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getParentDataId() {
        return parentDataId;
    }

    public void setParentDataId(String parentDataId) {
        this.parentDataId = parentDataId;
    }

    public String getNd() {
        return nd;
    }

    public void setNd(String nd) {
        this.nd = nd;
    }

    public String getDataVersion() {
        return dataVersion;
    }

    public void setDataVersion(String dataVersion) {
        this.dataVersion = dataVersion;
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

    public String getCreaterName() {
        return createrName;
    }

    public void setCreaterName(String createrName) {
        this.createrName = createrName;
    }

    public String getCreaterId() {
        return createrId;
    }

    public void setCreaterId(String createrId) {
        this.createrId = createrId;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    public String getDisplayCode() {
        return displayCode;
    }

    public void setDisplayCode(String displayCode) {
        this.displayCode = displayCode;
    }

    public String getSimpleCode() {
        return simpleCode;
    }

    public void setSimpleCode(String simpleCode) {
        this.simpleCode = simpleCode;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Double getXmjfZbx() {
        return xmjfZbx;
    }

    public void setXmjfZbx(Double xmjfZbx) {
        this.xmjfZbx = xmjfZbx;
    }

    public Double getXmjfZbxJz() {
        return xmjfZbxJz;
    }

    public void setXmjfZbxJz(Double xmjfZbxJz) {
        this.xmjfZbxJz = xmjfZbxJz;
    }

    public Double getXmjfZbxXq() {
        return xmjfZbxXq;
    }

    public void setXmjfZbxXq(Double xmjfZbxXq) {
        this.xmjfZbxXq = xmjfZbxXq;
    }

    public Double getXmjfFyx() {
        return xmjfFyx;
    }

    public void setXmjfFyx(Double xmjfFyx) {
        this.xmjfFyx = xmjfFyx;
    }

    public Double getXmjfFyxJz() {
        return xmjfFyxJz;
    }

    public void setXmjfFyxJz(Double xmjfFyxJz) {
        this.xmjfFyxJz = xmjfFyxJz;
    }

    public Double getXmjfFyxXq() {
        return xmjfFyxXq;
    }

    public void setXmjfFyxXq(Double xmjfFyxXq) {
        this.xmjfFyxXq = xmjfFyxXq;
    }

    public Double getXmjfTotal() {
        return xmjfTotal;
    }

    public void setXmjfTotal(Double xmjfTotal) {
        this.xmjfTotal = xmjfTotal;
    }

    public Double getYjwcZbx() {
        return yjwcZbx;
    }

    public void setYjwcZbx(Double yjwcZbx) {
        this.yjwcZbx = yjwcZbx;
    }

    public Double getYjwcFyx() {
        return yjwcFyx;
    }

    public void setYjwcFyx(Double yjwcFyx) {
        this.yjwcFyx = yjwcFyx;
    }

    public Double getYjwcTotal() {
        return yjwcTotal;
    }

    public void setYjwcTotal(Double yjwcTotal) {
        this.yjwcTotal = yjwcTotal;
    }

    public Integer getItemType() {
        return itemType;
    }

    public void setItemType(Integer itemType) {
        this.itemType = itemType;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBudgetInfoId() {
        return budgetInfoId;
    }

    public void setBudgetInfoId(String budgetInfoId) {
        this.budgetInfoId = budgetInfoId;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getAppendFiles() {
        return appendFiles;
    }

    public void setAppendFiles(String appendFiles) {
        this.appendFiles = appendFiles;
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
        BudgetStockTotal other = (BudgetStockTotal) that;
        return (this.getDataId() == null ? other.getDataId() == null : this.getDataId().equals(other.getDataId()))
            && (this.getParentDataId() == null ? other.getParentDataId() == null : this.getParentDataId().equals(other.getParentDataId()))
            && (this.getNd() == null ? other.getNd() == null : this.getNd().equals(other.getNd()))
            && (this.getDataVersion() == null ? other.getDataVersion() == null : this.getDataVersion().equals(other.getDataVersion()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreaterName() == null ? other.getCreaterName() == null : this.getCreaterName().equals(other.getCreaterName()))
            && (this.getCreaterId() == null ? other.getCreaterId() == null : this.getCreaterId().equals(other.getCreaterId()))
            && (this.getNo() == null ? other.getNo() == null : this.getNo().equals(other.getNo()))
            && (this.getDisplayName() == null ? other.getDisplayName() == null : this.getDisplayName().equals(other.getDisplayName()))
            && (this.getSimpleName() == null ? other.getSimpleName() == null : this.getSimpleName().equals(other.getSimpleName()))
            && (this.getDisplayCode() == null ? other.getDisplayCode() == null : this.getDisplayCode().equals(other.getDisplayCode()))
            && (this.getSimpleCode() == null ? other.getSimpleCode() == null : this.getSimpleCode().equals(other.getSimpleCode()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getXmjfZbx() == null ? other.getXmjfZbx() == null : this.getXmjfZbx().equals(other.getXmjfZbx()))
            && (this.getXmjfZbxJz() == null ? other.getXmjfZbxJz() == null : this.getXmjfZbxJz().equals(other.getXmjfZbxJz()))
            && (this.getXmjfZbxXq() == null ? other.getXmjfZbxXq() == null : this.getXmjfZbxXq().equals(other.getXmjfZbxXq()))
            && (this.getXmjfFyx() == null ? other.getXmjfFyx() == null : this.getXmjfFyx().equals(other.getXmjfFyx()))
            && (this.getXmjfFyxJz() == null ? other.getXmjfFyxJz() == null : this.getXmjfFyxJz().equals(other.getXmjfFyxJz()))
            && (this.getXmjfFyxXq() == null ? other.getXmjfFyxXq() == null : this.getXmjfFyxXq().equals(other.getXmjfFyxXq()))
            && (this.getXmjfTotal() == null ? other.getXmjfTotal() == null : this.getXmjfTotal().equals(other.getXmjfTotal()))
            && (this.getYjwcZbx() == null ? other.getYjwcZbx() == null : this.getYjwcZbx().equals(other.getYjwcZbx()))
            && (this.getYjwcFyx() == null ? other.getYjwcFyx() == null : this.getYjwcFyx().equals(other.getYjwcFyx()))
            && (this.getYjwcTotal() == null ? other.getYjwcTotal() == null : this.getYjwcTotal().equals(other.getYjwcTotal()))
            && (this.getItemType() == null ? other.getItemType() == null : this.getItemType().equals(other.getItemType()))
            && (this.getCompanyCode() == null ? other.getCompanyCode() == null : this.getCompanyCode().equals(other.getCompanyCode()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getBudgetInfoId() == null ? other.getBudgetInfoId() == null : this.getBudgetInfoId().equals(other.getBudgetInfoId()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()))
            && (this.getAppendFiles() == null ? other.getAppendFiles() == null : this.getAppendFiles().equals(other.getAppendFiles()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataId() == null) ? 0 : getDataId().hashCode());
        result = prime * result + ((getParentDataId() == null) ? 0 : getParentDataId().hashCode());
        result = prime * result + ((getNd() == null) ? 0 : getNd().hashCode());
        result = prime * result + ((getDataVersion() == null) ? 0 : getDataVersion().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreaterName() == null) ? 0 : getCreaterName().hashCode());
        result = prime * result + ((getCreaterId() == null) ? 0 : getCreaterId().hashCode());
        result = prime * result + ((getNo() == null) ? 0 : getNo().hashCode());
        result = prime * result + ((getDisplayName() == null) ? 0 : getDisplayName().hashCode());
        result = prime * result + ((getSimpleName() == null) ? 0 : getSimpleName().hashCode());
        result = prime * result + ((getDisplayCode() == null) ? 0 : getDisplayCode().hashCode());
        result = prime * result + ((getSimpleCode() == null) ? 0 : getSimpleCode().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getXmjfZbx() == null) ? 0 : getXmjfZbx().hashCode());
        result = prime * result + ((getXmjfZbxJz() == null) ? 0 : getXmjfZbxJz().hashCode());
        result = prime * result + ((getXmjfZbxXq() == null) ? 0 : getXmjfZbxXq().hashCode());
        result = prime * result + ((getXmjfFyx() == null) ? 0 : getXmjfFyx().hashCode());
        result = prime * result + ((getXmjfFyxJz() == null) ? 0 : getXmjfFyxJz().hashCode());
        result = prime * result + ((getXmjfFyxXq() == null) ? 0 : getXmjfFyxXq().hashCode());
        result = prime * result + ((getXmjfTotal() == null) ? 0 : getXmjfTotal().hashCode());
        result = prime * result + ((getYjwcZbx() == null) ? 0 : getYjwcZbx().hashCode());
        result = prime * result + ((getYjwcFyx() == null) ? 0 : getYjwcFyx().hashCode());
        result = prime * result + ((getYjwcTotal() == null) ? 0 : getYjwcTotal().hashCode());
        result = prime * result + ((getItemType() == null) ? 0 : getItemType().hashCode());
        result = prime * result + ((getCompanyCode() == null) ? 0 : getCompanyCode().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getBudgetInfoId() == null) ? 0 : getBudgetInfoId().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        result = prime * result + ((getAppendFiles() == null) ? 0 : getAppendFiles().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dataId=").append(dataId);
        sb.append(", parentDataId=").append(parentDataId);
        sb.append(", nd=").append(nd);
        sb.append(", dataVersion=").append(dataVersion);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createrName=").append(createrName);
        sb.append(", createrId=").append(createrId);
        sb.append(", no=").append(no);
        sb.append(", displayName=").append(displayName);
        sb.append(", simpleName=").append(simpleName);
        sb.append(", displayCode=").append(displayCode);
        sb.append(", simpleCode=").append(simpleCode);
        sb.append(", level=").append(level);
        sb.append(", xmjfZbx=").append(xmjfZbx);
        sb.append(", xmjfZbxJz=").append(xmjfZbxJz);
        sb.append(", xmjfZbxXq=").append(xmjfZbxXq);
        sb.append(", xmjfFyx=").append(xmjfFyx);
        sb.append(", xmjfFyxJz=").append(xmjfFyxJz);
        sb.append(", xmjfFyxXq=").append(xmjfFyxXq);
        sb.append(", xmjfTotal=").append(xmjfTotal);
        sb.append(", yjwcZbx=").append(yjwcZbx);
        sb.append(", yjwcFyx=").append(yjwcFyx);
        sb.append(", yjwcTotal=").append(yjwcTotal);
        sb.append(", itemType=").append(itemType);
        sb.append(", companyCode=").append(companyCode);
        sb.append(", remark=").append(remark);
        sb.append(", budgetInfoId=").append(budgetInfoId);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", appendFiles=").append(appendFiles);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}