package com.pcitc.base.standardmaintain;

import com.pcitc.base.common.RecordModel;

import java.util.Date;

/**
 * 国际行业标准维护
 * @author
 */
public class InternationalStandardMaintain extends RecordModel {

    private String id;

    /**
     * 国际标准化组织
     */
    private String internationalStandardOrg;
    /**
     * 对应的国际标准工作组
     */
    private String internationalStandardWorkGroup;
    /**
     * 标准编号
     */
    private String standardNum;
    /**
     * 标准中文名称
     */
    private String standardChineseName;
    /**
     * 标准英文名称
     */
    private String standardEnglishName;
    /**
     * 国内提案单位
     */
    private String domesticProposalUnit;
    /**
     * 参与国家
     */
    private String partakeCountry;
    /**
     * 参与国家字典
     */
    private String partakeCountryText;
    /**
     * 标准状态
     */
    private String standardStatus;
    /**
     * 标准状态字典翻译
     */
    private String standardStatusText;
    /**
     * 管理状态
     */
    private String manageStatus;
    /**
     * 立项时间
     */
    private Date projectApprovalDate;
    /**
     * 发布时间
     */
    private Date publishDate;
    /**
     * 附件
     */
    private String files;

    public String getInternationalStandardOrg() {
        return internationalStandardOrg;
    }

    public void setInternationalStandardOrg(String internationalStandardOrg) {
        this.internationalStandardOrg = internationalStandardOrg;
    }

    public String getInternationalStandardWorkGroup() {
        return internationalStandardWorkGroup;
    }

    public void setInternationalStandardWorkGroup(String internationalStandardWorkGroup) {
        this.internationalStandardWorkGroup = internationalStandardWorkGroup;
    }

    public String getStandardNum() {
        return standardNum;
    }

    public void setStandardNum(String standardNum) {
        this.standardNum = standardNum;
    }

    public String getStandardChineseName() {
        return standardChineseName;
    }

    public void setStandardChineseName(String standardChineseName) {
        this.standardChineseName = standardChineseName;
    }

    public String getStandardEnglishName() {
        return standardEnglishName;
    }

    public void setStandardEnglishName(String standardEnglishName) {
        this.standardEnglishName = standardEnglishName;
    }

    public String getDomesticProposalUnit() {
        return domesticProposalUnit;
    }

    public void setDomesticProposalUnit(String domesticProposalUnit) {
        this.domesticProposalUnit = domesticProposalUnit;
    }

    public String getPartakeCountry() {
        return partakeCountry;
    }

    public void setPartakeCountry(String partakeCountry) {
        this.partakeCountry = partakeCountry;
    }

    public String getStandardStatus() {
        return standardStatus;
    }

    public void setStandardStatus(String standardStatus) {
        this.standardStatus = standardStatus;
    }

    public String getManageStatus() {
        return manageStatus;
    }

    public void setManageStatus(String manageStatus) {
        this.manageStatus = manageStatus;
    }

    public Date getProjectApprovalDate() {
        return projectApprovalDate;
    }

    public void setProjectApprovalDate(Date projectApprovalDate) {
        this.projectApprovalDate = projectApprovalDate;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStandardStatusText() {
        return standardStatusText;
    }

    public void setStandardStatusText(String standardStatusText) {
        this.standardStatusText = standardStatusText;
    }

    public String getPartakeCountryText() {
        return partakeCountryText;
    }

    public void setPartakeCountryText(String partakeCountryText) {
        this.partakeCountryText = partakeCountryText;
    }
}
