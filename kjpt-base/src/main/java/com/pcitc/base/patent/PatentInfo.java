package com.pcitc.base.patent;

import java.io.Serializable;
import java.util.Date;

/**
 * patent_info
 * @author
 */
public class PatentInfo implements Serializable {
    /**
     * 主键id
     */
    private String id;

    /**
     * 和人员的关联键
     */
    private String userId;

    /**
     * 单位名称
     */
    private String unitName;

    /**
     * 申请人/专利权人
     */
    private String applicant;

    /**
     * 专利名称
     */
    private String patentName;

    /**
     * 发明人
     */
    private String inventor;

    /**
     * 申请类型
     */
    private String applicationType;

    /**
     * 专利类型
     */
    private String patentType;

    /**
     * 法律状态
     */
    private String legalStatus;

    /**
     * 日期
     */
    private Date date;

    /**
     * 申请号
     */
    private String applicationNumber;

    /**
     * 专利范围
     */
    private String patentRange;

    /**
     * 代理机构
     */
    private String agency;

    /**
     * 录入人
     */
    private String entryPerson;

    /**
     * 申请日期
     */
    private Date applicationDate;

    /**
     * 录入时间
     */
    private Date entryDate;

    /**
     * 申请费用
     */
    private Long applicationCost;

    /**
     * 备注
     */
    private String remark;

    /**
     * 摘要
     */
    private String summary;

    /**
     * 专利转化应用
     */
    private String applicationOfPatentTransformation;

    /**
     * 专业化应用
     */
    private String majorApplication;

    /**
     * 未实施原因
     */
    private String unenforcedReason;

    /**
     * 被许可人
     */
    private String licensee;

    /**
     * 被许可方式
     */
    private String licenseeMode;

    /**
     * 许可收益
     */
    private Long licenseeProfit;

    /**
     * 被转让人
     */
    private String assignor;

    /**
     * 转让收益
     */
    private Long assignProfit;

    /**
     * 附件上传
     */
    private String files;

    /**
     * 数据创建人
     */
    private String creator;

    /**
     * 数据创建时间
     */
    private Date createDate;

    /**
     * 数据最后修改时间
     */
    private Date updateDate;

    /**
     * 数据最后修改人
     */
    private String updator;

    /**
     * 删除标识
     */
    private String deleted;

    /**
     * 国别组织
     */
    private String country;

    /**
     * 专利范围翻译
     */
    private String applicationOfPatentTransformationText;

    /**
     * 专利类型翻译
     */
    private String patentTypeText;

    /**
     * 国别组织翻译
     */
    private String countryText;

    /**
     * 申请类型翻译
     */
    private String applicationTypeText;

    /**
     * 法律状态翻译
     */
    private String legalStatusText;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getPatentName() {
        return patentName;
    }

    public void setPatentName(String patentName) {
        this.patentName = patentName;
    }

    public String getInventor() {
        return inventor;
    }

    public void setInventor(String inventor) {
        this.inventor = inventor;
    }

    public String getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }

    public String getPatentType() {
        return patentType;
    }

    public void setPatentType(String patentType) {
        this.patentType = patentType;
    }

    public String getLegalStatus() {
        return legalStatus;
    }

    public void setLegalStatus(String legalStatus) {
        this.legalStatus = legalStatus;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public String getPatentRange() {
        return patentRange;
    }

    public void setPatentRange(String patentRange) {
        this.patentRange = patentRange;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getEntryPerson() {
        return entryPerson;
    }

    public void setEntryPerson(String entryPerson) {
        this.entryPerson = entryPerson;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Long getApplicationCost() {
        return applicationCost;
    }

    public void setApplicationCost(Long applicationCost) {
        this.applicationCost = applicationCost;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getApplicationOfPatentTransformation() {
        return applicationOfPatentTransformation;
    }

    public void setApplicationOfPatentTransformation(String applicationOfPatentTransformation) {
        this.applicationOfPatentTransformation = applicationOfPatentTransformation;
    }

    public String getMajorApplication() {
        return majorApplication;
    }

    public void setMajorApplication(String majorApplication) {
        this.majorApplication = majorApplication;
    }

    public String getUnenforcedReason() {
        return unenforcedReason;
    }

    public void setUnenforcedReason(String unenforcedReason) {
        this.unenforcedReason = unenforcedReason;
    }

    public String getLicensee() {
        return licensee;
    }

    public void setLicensee(String licensee) {
        this.licensee = licensee;
    }

    public String getLicenseeMode() {
        return licenseeMode;
    }

    public void setLicenseeMode(String licenseeMode) {
        this.licenseeMode = licenseeMode;
    }

    public Long getLicenseeProfit() {
        return licenseeProfit;
    }

    public void setLicenseeProfit(Long licenseeProfit) {
        this.licenseeProfit = licenseeProfit;
    }

    public String getAssignor() {
        return assignor;
    }

    public void setAssignor(String assignor) {
        this.assignor = assignor;
    }

    public Long getAssignProfit() {
        return assignProfit;
    }

    public void setAssignProfit(Long assignProfit) {
        this.assignProfit = assignProfit;
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdator() {
        return updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getApplicationOfPatentTransformationText() {
        return applicationOfPatentTransformationText;
    }

    public void setApplicationOfPatentTransformationText(String applicationOfPatentTransformationText) {
        this.applicationOfPatentTransformationText = applicationOfPatentTransformationText;
    }

    public String getPatentTypeText() {
        return patentTypeText;
    }

    public void setPatentTypeText(String patentTypeText) {
        this.patentTypeText = patentTypeText;
    }

    public String getCountryText() {
        return countryText;
    }

    public void setCountryText(String countryText) {
        this.countryText = countryText;
    }

    public String getApplicationTypeText() {
        return applicationTypeText;
    }

    public void setApplicationTypeText(String applicationTypeText) {
        this.applicationTypeText = applicationTypeText;
    }

    public String getLegalStatusText() {
        return legalStatusText;
    }

    public void setLegalStatusText(String legalStatusText) {
        this.legalStatusText = legalStatusText;
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
        PatentInfo other = (PatentInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
                && (this.getUnitName() == null ? other.getUnitName() == null : this.getUnitName().equals(other.getUnitName()))
                && (this.getApplicant() == null ? other.getApplicant() == null : this.getApplicant().equals(other.getApplicant()))
                && (this.getPatentName() == null ? other.getPatentName() == null : this.getPatentName().equals(other.getPatentName()))
                && (this.getInventor() == null ? other.getInventor() == null : this.getInventor().equals(other.getInventor()))
                && (this.getApplicationType() == null ? other.getApplicationType() == null : this.getApplicationType().equals(other.getApplicationType()))
                && (this.getPatentType() == null ? other.getPatentType() == null : this.getPatentType().equals(other.getPatentType()))
                && (this.getLegalStatus() == null ? other.getLegalStatus() == null : this.getLegalStatus().equals(other.getLegalStatus()))
                && (this.getDate() == null ? other.getDate() == null : this.getDate().equals(other.getDate()))
                && (this.getApplicationNumber() == null ? other.getApplicationNumber() == null : this.getApplicationNumber().equals(other.getApplicationNumber()))
                && (this.getPatentRange() == null ? other.getPatentRange() == null : this.getPatentRange().equals(other.getPatentRange()))
                && (this.getAgency() == null ? other.getAgency() == null : this.getAgency().equals(other.getAgency()))
                && (this.getEntryPerson() == null ? other.getEntryPerson() == null : this.getEntryPerson().equals(other.getEntryPerson()))
                && (this.getApplicationDate() == null ? other.getApplicationDate() == null : this.getApplicationDate().equals(other.getApplicationDate()))
                && (this.getEntryDate() == null ? other.getEntryDate() == null : this.getEntryDate().equals(other.getEntryDate()))
                && (this.getApplicationCost() == null ? other.getApplicationCost() == null : this.getApplicationCost().equals(other.getApplicationCost()))
                && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
                && (this.getSummary() == null ? other.getSummary() == null : this.getSummary().equals(other.getSummary()))
                && (this.getApplicationOfPatentTransformation() == null ? other.getApplicationOfPatentTransformation() == null : this.getApplicationOfPatentTransformation().equals(other.getApplicationOfPatentTransformation()))
                && (this.getMajorApplication() == null ? other.getMajorApplication() == null : this.getMajorApplication().equals(other.getMajorApplication()))
                && (this.getUnenforcedReason() == null ? other.getUnenforcedReason() == null : this.getUnenforcedReason().equals(other.getUnenforcedReason()))
                && (this.getLicensee() == null ? other.getLicensee() == null : this.getLicensee().equals(other.getLicensee()))
                && (this.getLicenseeMode() == null ? other.getLicenseeMode() == null : this.getLicenseeMode().equals(other.getLicenseeMode()))
                && (this.getLicenseeProfit() == null ? other.getLicenseeProfit() == null : this.getLicenseeProfit().equals(other.getLicenseeProfit()))
                && (this.getAssignor() == null ? other.getAssignor() == null : this.getAssignor().equals(other.getAssignor()))
                && (this.getAssignProfit() == null ? other.getAssignProfit() == null : this.getAssignProfit().equals(other.getAssignProfit()))
                && (this.getFiles() == null ? other.getFiles() == null : this.getFiles().equals(other.getFiles()))
                && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
                && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
                && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
                && (this.getUpdator() == null ? other.getUpdator() == null : this.getUpdator().equals(other.getUpdator()))
                && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUnitName() == null) ? 0 : getUnitName().hashCode());
        result = prime * result + ((getApplicant() == null) ? 0 : getApplicant().hashCode());
        result = prime * result + ((getPatentName() == null) ? 0 : getPatentName().hashCode());
        result = prime * result + ((getInventor() == null) ? 0 : getInventor().hashCode());
        result = prime * result + ((getApplicationType() == null) ? 0 : getApplicationType().hashCode());
        result = prime * result + ((getPatentType() == null) ? 0 : getPatentType().hashCode());
        result = prime * result + ((getLegalStatus() == null) ? 0 : getLegalStatus().hashCode());
        result = prime * result + ((getDate() == null) ? 0 : getDate().hashCode());
        result = prime * result + ((getApplicationNumber() == null) ? 0 : getApplicationNumber().hashCode());
        result = prime * result + ((getPatentRange() == null) ? 0 : getPatentRange().hashCode());
        result = prime * result + ((getAgency() == null) ? 0 : getAgency().hashCode());
        result = prime * result + ((getEntryPerson() == null) ? 0 : getEntryPerson().hashCode());
        result = prime * result + ((getApplicationDate() == null) ? 0 : getApplicationDate().hashCode());
        result = prime * result + ((getEntryDate() == null) ? 0 : getEntryDate().hashCode());
        result = prime * result + ((getApplicationCost() == null) ? 0 : getApplicationCost().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getSummary() == null) ? 0 : getSummary().hashCode());
        result = prime * result + ((getApplicationOfPatentTransformation() == null) ? 0 : getApplicationOfPatentTransformation().hashCode());
        result = prime * result + ((getMajorApplication() == null) ? 0 : getMajorApplication().hashCode());
        result = prime * result + ((getUnenforcedReason() == null) ? 0 : getUnenforcedReason().hashCode());
        result = prime * result + ((getLicensee() == null) ? 0 : getLicensee().hashCode());
        result = prime * result + ((getLicenseeMode() == null) ? 0 : getLicenseeMode().hashCode());
        result = prime * result + ((getLicenseeProfit() == null) ? 0 : getLicenseeProfit().hashCode());
        result = prime * result + ((getAssignor() == null) ? 0 : getAssignor().hashCode());
        result = prime * result + ((getAssignProfit() == null) ? 0 : getAssignProfit().hashCode());
        result = prime * result + ((getFiles() == null) ? 0 : getFiles().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getUpdator() == null) ? 0 : getUpdator().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", unitName=").append(unitName);
        sb.append(", applicant=").append(applicant);
        sb.append(", patentName=").append(patentName);
        sb.append(", inventor=").append(inventor);
        sb.append(", applicationType=").append(applicationType);
        sb.append(", patentType=").append(patentType);
        sb.append(", legalStatus=").append(legalStatus);
        sb.append(", date=").append(date);
        sb.append(", applicationNumber=").append(applicationNumber);
        sb.append(", patentRange=").append(patentRange);
        sb.append(", agency=").append(agency);
        sb.append(", entryPerson=").append(entryPerson);
        sb.append(", applicationDate=").append(applicationDate);
        sb.append(", entryDate=").append(entryDate);
        sb.append(", applicationCost=").append(applicationCost);
        sb.append(", remark=").append(remark);
        sb.append(", summary=").append(summary);
        sb.append(", applicationOfPatentTransformation=").append(applicationOfPatentTransformation);
        sb.append(", majorApplication=").append(majorApplication);
        sb.append(", unenforcedReason=").append(unenforcedReason);
        sb.append(", licensee=").append(licensee);
        sb.append(", licenseeMode=").append(licenseeMode);
        sb.append(", licenseeProfit=").append(licenseeProfit);
        sb.append(", assignor=").append(assignor);
        sb.append(", assignProfit=").append(assignProfit);
        sb.append(", file=").append(files);
        sb.append(", creator=").append(creator);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", updator=").append(updator);
        sb.append(", deleted=").append(deleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
