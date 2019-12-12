package com.pcitc.base.trademarkinfo;

import com.pcitc.base.common.RecordModel;

import java.io.Serializable;
import java.util.Date;

/**
 * trademark_info
 * @author 
 */
public class TrademarkInfo extends RecordModel implements Serializable {
    /**
     * 主键id
     */
    private String id;

    /**
     * 单位名称
     */
    private String unitName;

    /**
     * 核定使用商品大类
     */
    private String commodityCategory;

    /**
     * 商标申请号
     */
    private String applicationNumber;

    /**
     * 有效日期
     */
    private Date effectiveDate;

    /**
     * 注册公告日
     */
    private Date registerNoticeDate;

    /**
     * 录入人
     */
    private String entryPerson;

    /**
     * 注册商标名称
     */
    private String trademarkName;

    /**
     * 申请人/注册人
     */
    private String applicant;

    /**
     * 注册日期
     */
    private Date registerDate;

    /**
     * 法律状态
     */
    private String lawStatus;

    /**
     * 备注
     */
    private String remark;

    /**
     * 录入时间
     */
    private Date entryDate;

    /**
     * 附件
     */
    private String files;

    /**
     * 删除标识
     */
    private String deleted;

    /**
     * 核定使用商品大类翻译
     */
    private String commodityCategoryText;

    /**
     * 法律状态翻译
     */
    private String legalStatusText;

    /**
     * 单位名称翻译
     */
    private String unitNameText;

    /**
     * 创建人ID
     */
    private String createUnitId;

    /**
     * 创建人名称
     */
    private String createUnitName;

    /**
     * 信息密级翻译
     */
    private String secretLevelText;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getCommodityCategory() {
        return commodityCategory;
    }

    public void setCommodityCategory(String commodityCategory) {
        this.commodityCategory = commodityCategory;
    }

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getRegisterNoticeDate() {
        return registerNoticeDate;
    }

    public void setRegisterNoticeDate(Date registerNoticeDate) {
        this.registerNoticeDate = registerNoticeDate;
    }

    public String getEntryPerson() {
        return entryPerson;
    }

    public void setEntryPerson(String entryPerson) {
        this.entryPerson = entryPerson;
    }

    public String getTrademarkName() {
        return trademarkName;
    }

    public void setTrademarkName(String trademarkName) {
        this.trademarkName = trademarkName;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getLawStatus() {
        return lawStatus;
    }

    public void setLawStatus(String lawStatus) {
        this.lawStatus = lawStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
    }

    public String getCommodityCategoryText() {
        return commodityCategoryText;
    }

    public void setCommodityCategoryText(String commodityCategoryText) {
        this.commodityCategoryText = commodityCategoryText;
    }

    public String getLegalStatusText() {
        return legalStatusText;
    }

    public void setLegalStatusText(String legalStatusText) {
        this.legalStatusText = legalStatusText;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getUnitNameText() {
        return unitNameText;
    }

    public void setUnitNameText(String unitNameText) {
        this.unitNameText = unitNameText;
    }

    public String getCreateUnitId() {
        return createUnitId;
    }

    public void setCreateUnitId(String createUnitId) {
        this.createUnitId = createUnitId;
    }

    public String getCreateUnitName() {
        return createUnitName;
    }

    public void setCreateUnitName(String createUnitName) {
        this.createUnitName = createUnitName;
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
        TrademarkInfo other = (TrademarkInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUnitName() == null ? other.getUnitName() == null : this.getUnitName().equals(other.getUnitName()))
            && (this.getCommodityCategory() == null ? other.getCommodityCategory() == null : this.getCommodityCategory().equals(other.getCommodityCategory()))
            && (this.getApplicationNumber() == null ? other.getApplicationNumber() == null : this.getApplicationNumber().equals(other.getApplicationNumber()))
            && (this.getEffectiveDate() == null ? other.getEffectiveDate() == null : this.getEffectiveDate().equals(other.getEffectiveDate()))
            && (this.getRegisterNoticeDate() == null ? other.getRegisterNoticeDate() == null : this.getRegisterNoticeDate().equals(other.getRegisterNoticeDate()))
            && (this.getEntryPerson() == null ? other.getEntryPerson() == null : this.getEntryPerson().equals(other.getEntryPerson()))
            && (this.getTrademarkName() == null ? other.getTrademarkName() == null : this.getTrademarkName().equals(other.getTrademarkName()))
            && (this.getApplicant() == null ? other.getApplicant() == null : this.getApplicant().equals(other.getApplicant()))
            && (this.getRegisterDate() == null ? other.getRegisterDate() == null : this.getRegisterDate().equals(other.getRegisterDate()))
            && (this.getLawStatus() == null ? other.getLawStatus() == null : this.getLawStatus().equals(other.getLawStatus()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getEntryDate() == null ? other.getEntryDate() == null : this.getEntryDate().equals(other.getEntryDate()))
            && (this.getFiles() == null ? other.getFiles() == null : this.getFiles().equals(other.getFiles()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUnitName() == null) ? 0 : getUnitName().hashCode());
        result = prime * result + ((getCommodityCategory() == null) ? 0 : getCommodityCategory().hashCode());
        result = prime * result + ((getApplicationNumber() == null) ? 0 : getApplicationNumber().hashCode());
        result = prime * result + ((getEffectiveDate() == null) ? 0 : getEffectiveDate().hashCode());
        result = prime * result + ((getRegisterNoticeDate() == null) ? 0 : getRegisterNoticeDate().hashCode());
        result = prime * result + ((getEntryPerson() == null) ? 0 : getEntryPerson().hashCode());
        result = prime * result + ((getTrademarkName() == null) ? 0 : getTrademarkName().hashCode());
        result = prime * result + ((getApplicant() == null) ? 0 : getApplicant().hashCode());
        result = prime * result + ((getRegisterDate() == null) ? 0 : getRegisterDate().hashCode());
        result = prime * result + ((getLawStatus() == null) ? 0 : getLawStatus().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getEntryDate() == null) ? 0 : getEntryDate().hashCode());
        result = prime * result + ((getFiles() == null) ? 0 : getFiles().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", unitName=").append(unitName);
        sb.append(", commodityCategory=").append(commodityCategory);
        sb.append(", applicationNumber=").append(applicationNumber);
        sb.append(", effectiveDate=").append(effectiveDate);
        sb.append(", registerNoticeDate=").append(registerNoticeDate);
        sb.append(", entryPerson=").append(entryPerson);
        sb.append(", trademarkName=").append(trademarkName);
        sb.append(", applicant=").append(applicant);
        sb.append(", registerDate=").append(registerDate);
        sb.append(", lawStatus=").append(lawStatus);
        sb.append(", remark=").append(remark);
        sb.append(", entryDate=").append(entryDate);
        sb.append(", file=").append(files);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}