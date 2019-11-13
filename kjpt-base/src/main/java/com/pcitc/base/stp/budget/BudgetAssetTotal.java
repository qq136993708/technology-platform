package com.pcitc.base.stp.budget;

import java.io.Serializable;

/**
 * out_tem_money_asset_total
 * @author 
 */
public class BudgetAssetTotal implements Serializable {
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
     * 编码
     */
    private String displayCode;

    private String simpleCode;

    /**
     * 单位级别（0,1）
     */
    private Integer level;

    /**
     * 合计
     */
    private Double total;

    /**
     * 上年科技经费预算预计完成
     */
    private Double yjwc;

    /**
     * 科技经费预算
     */
    private Double xmjf;

    private Double xmjfJz;

    private Double xmjfXq;

    /**
     * 预算项类型，（1预算项，2预算项参考公司）
     */
    private Integer itemType;

    /**
     * 公司编码（如果是公司）
     */
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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getYjwc() {
        return yjwc;
    }

    public void setYjwc(Double yjwc) {
        this.yjwc = yjwc;
    }

    public Double getXmjf() {
        return xmjf;
    }

    public void setXmjf(Double xmjf) {
        this.xmjf = xmjf;
    }

    public Double getXmjfJz() {
        return xmjfJz;
    }

    public void setXmjfJz(Double xmjfJz) {
        this.xmjfJz = xmjfJz;
    }

    public Double getXmjfXq() {
        return xmjfXq;
    }

    public void setXmjfXq(Double xmjfXq) {
        this.xmjfXq = xmjfXq;
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
        BudgetAssetTotal other = (BudgetAssetTotal) that;
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
            && (this.getTotal() == null ? other.getTotal() == null : this.getTotal().equals(other.getTotal()))
            && (this.getYjwc() == null ? other.getYjwc() == null : this.getYjwc().equals(other.getYjwc()))
            && (this.getXmjf() == null ? other.getXmjf() == null : this.getXmjf().equals(other.getXmjf()))
            && (this.getXmjfJz() == null ? other.getXmjfJz() == null : this.getXmjfJz().equals(other.getXmjfJz()))
            && (this.getXmjfXq() == null ? other.getXmjfXq() == null : this.getXmjfXq().equals(other.getXmjfXq()))
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
        result = prime * result + ((getTotal() == null) ? 0 : getTotal().hashCode());
        result = prime * result + ((getYjwc() == null) ? 0 : getYjwc().hashCode());
        result = prime * result + ((getXmjf() == null) ? 0 : getXmjf().hashCode());
        result = prime * result + ((getXmjfJz() == null) ? 0 : getXmjfJz().hashCode());
        result = prime * result + ((getXmjfXq() == null) ? 0 : getXmjfXq().hashCode());
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
        sb.append(", total=").append(total);
        sb.append(", yjwc=").append(yjwc);
        sb.append(", xmjf=").append(xmjf);
        sb.append(", xmjfJz=").append(xmjfJz);
        sb.append(", xmjfXq=").append(xmjfXq);
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