package com.pcitc.base.patent;


import com.pcitc.base.common.RecordModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * patent_info
 * @author
 */
public class PatentInfo extends RecordModel implements Serializable {
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
    private BigDecimal applicationCost;

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
    private BigDecimal licenseeProfit;

    /**
     * 被转让人
     */
    private String assignor;

    /**
     * 转让收益
     */
    private BigDecimal assignProfit;

    /**
     * 被转让人及转让收益
     */
    private String assignorAndAssignProfit;

    /**
     * 附件上传
     */
    private String files="";

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

	/**
     * 单位名称翻译
     */
	private String unitNameText;

	/**
     * 技术领域
     */
	private String technicalField;


	/**
     * 技术领域名称翻译
     */
	private String technicalFieldText;

    /**
     * 技术领域索引
     */
    private String technicalFieldIndex;

    /**
     * 技术领域索引
     */
    private String applicationDateStr;

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

    /**
     * 失效日期
     */
    private Date expirationDate;

    /**
     * 失效日期翻译
     */
    private String expirationDateStr;

    /**后期需求增加：新增字段 begin*/

    /**
     * 外系统id
     */
    private String outId;
    /**
     * 数据导入文件格式 1 xml 2 excel
     */
    private String inputType;

    /**
     * 授权日期
     */
    private Date authorizationDate;
    /**
     * 终止日期
     */
    private Date terminationDate;
    /**
     * 法律状态变更日期
     */
    private Date legalStatusUpdateTime;

    /**
     * 应用技术领域技术类
     */
    private String applicationTechnologyTechnology;
    /**
     * 应用技术领域技术类文本翻译
     */
    private String applicationTechnologyTechnologyText;

    /**
     * 项目背景
     */
    private String projectBackground;
    /**
     * 项目背景文本翻译
     */
    private String projectBackgroundText;

    //establishment_department project_number project_name
    //application_technology_products application_model_product_name
    //application_subsystem_name name_of_components_and_supporting_materials
    //main_classification_number sub_category_number
    //priority_right joint_applicant public_announcement_no explain legal_person_code

    /**
     * 立项部门
     */
    private String establishmentDepartment;
    /**
     * 项目号
     */
    private String projectNumber;
    /**
     * 项目名称
     */
    private String projectName;
    /**
     * 应用技术领域产品类
     */
    private String applicationTechnologyProducts;
    /**
     * 应用技术领域产品类文本翻译
     */
    private String applicationTechnologyProductsText;
    /**
     * 应用模型产品名称
     */
    private String applicationModelProductName;
    /**
     * 应用分系统名称
     */
    private String applicationSubsystemName;
    /**
     * 元器件及配套材料名称
     */
    private String nameOfComponentsAndSupportingMaterials;
    /**
     * 主分类号
     */
    private String mainClassificationNumber;
    /**
     * 副分类号
     */
    private String subCategoryNumber;
    /**
     * 优先权
     */
    private String priorityRight;
    /**
     * 联合申请人
     */
    private String jointApplicant;
    /**
     * 公开（公告）号
     */
    private String publicAnnouncementNo;
    /**
     * 说明
     */

    private String explain;
    /**
     * 法人代码
     */
    private String legalPersonCode;

    /**
     * 自定义分类
     */
    private String customClassification;
    /**后期需求增加：新增字段 end*/



    private String type;

    /**
     * ---------密级----------
     * 公开
     * 内部
     * 商密
     */
    private String level;

    private String levelText;


    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

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

    public BigDecimal getApplicationCost() {
        return applicationCost;
    }

    public void setApplicationCost(BigDecimal applicationCost) {
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

    public BigDecimal getLicenseeProfit() {
        return licenseeProfit;
    }

    public void setLicenseeProfit(BigDecimal licenseeProfit) {
        this.licenseeProfit = licenseeProfit;
    }

    public String getAssignor() {
        return assignor;
    }

    public void setAssignor(String assignor) {
        this.assignor = assignor;
    }

    public BigDecimal getAssignProfit() {
        return assignProfit;
    }

    public void setAssignProfit(BigDecimal assignProfit) {
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

    @Override
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

	public String getUnitNameText() {
        return unitNameText;
    }

    public void setUnitNameText(String unitNameText) {
        this.unitNameText = unitNameText;
    }
	
	public String getTechnicalField() {
        return technicalField;
    }

    public void setTechnicalField(String technicalField) {
        this.technicalField = technicalField;
    }
	
	public String getTechnicalFieldText() {
        return technicalFieldText;
    }

    public void setTechnicalFieldText(String technicalFieldText) {
        this.technicalFieldText = technicalFieldText;
    }

    public String getTechnicalFieldIndex() {
        return technicalFieldIndex;
    }

    public void setTechnicalFieldIndex(String technicalFieldIndex) {
        this.technicalFieldIndex = technicalFieldIndex;
    }

    public String getApplicationDateStr() {
        return applicationDateStr;
    }

    public void setApplicationDateStr(String applicationDateStr) {
        this.applicationDateStr = applicationDateStr;
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

    public String getSecretLevelText() {
        return secretLevelText;
    }

    public void setSecretLevelText(String secretLevelText) {
        this.secretLevelText = secretLevelText;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getExpirationDateStr() {
        return expirationDateStr;
    }

    public void setExpirationDateStr(String expirationDateStr) {
        this.expirationDateStr = expirationDateStr;
    }

    public String getOutId() {
        return outId;
    }

    public void setOutId(String outId) {
        this.outId = outId;
    }

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public Date getAuthorizationDate() {
        return authorizationDate;
    }

    public void setAuthorizationDate(Date authorizationDate) {
        this.authorizationDate = authorizationDate;
    }

    public Date getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(Date terminationDate) {
        this.terminationDate = terminationDate;
    }

    public Date getLegalStatusUpdateTime() {
        return legalStatusUpdateTime;
    }

    public void setLegalStatusUpdateTime(Date legalStatusUpdateTime) {
        this.legalStatusUpdateTime = legalStatusUpdateTime;
    }

    public String getApplicationTechnologyTechnology() {
        return applicationTechnologyTechnology;
    }

    public void setApplicationTechnologyTechnology(String applicationTechnologyTechnology) {
        this.applicationTechnologyTechnology = applicationTechnologyTechnology;
    }

    public String getProjectBackground() {
        return projectBackground;
    }

    public void setProjectBackground(String projectBackground) {
        this.projectBackground = projectBackground;
    }

    public String getEstablishmentDepartment() {
        return establishmentDepartment;
    }

    public void setEstablishmentDepartment(String establishmentDepartment) {
        this.establishmentDepartment = establishmentDepartment;
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getApplicationTechnologyProducts() {
        return applicationTechnologyProducts;
    }

    public void setApplicationTechnologyProducts(String applicationTechnologyProducts) {
        this.applicationTechnologyProducts = applicationTechnologyProducts;
    }

    public String getApplicationModelProductName() {
        return applicationModelProductName;
    }

    public void setApplicationModelProductName(String applicationModelProductName) {
        this.applicationModelProductName = applicationModelProductName;
    }

    public String getApplicationSubsystemName() {
        return applicationSubsystemName;
    }

    public void setApplicationSubsystemName(String applicationSubsystemName) {
        this.applicationSubsystemName = applicationSubsystemName;
    }

    public String getNameOfComponentsAndSupportingMaterials() {
        return nameOfComponentsAndSupportingMaterials;
    }

    public void setNameOfComponentsAndSupportingMaterials(String nameOfComponentsAndSupportingMaterials) {
        this.nameOfComponentsAndSupportingMaterials = nameOfComponentsAndSupportingMaterials;
    }

    public String getMainClassificationNumber() {
        return mainClassificationNumber;
    }

    public void setMainClassificationNumber(String mainClassificationNumber) {
        this.mainClassificationNumber = mainClassificationNumber;
    }

    public String getSubCategoryNumber() {
        return subCategoryNumber;
    }

    public void setSubCategoryNumber(String subCategoryNumber) {
        this.subCategoryNumber = subCategoryNumber;
    }

    public String getPriorityRight() {
        return priorityRight;
    }

    public void setPriorityRight(String priorityRight) {
        this.priorityRight = priorityRight;
    }

    public String getJointApplicant() {
        return jointApplicant;
    }

    public void setJointApplicant(String jointApplicant) {
        this.jointApplicant = jointApplicant;
    }

    public String getPublicAnnouncementNo() {
        return publicAnnouncementNo;
    }

    public void setPublicAnnouncementNo(String publicAnnouncementNo) {
        this.publicAnnouncementNo = publicAnnouncementNo;
    }

    public String getApplicationTechnologyTechnologyText() {
        return applicationTechnologyTechnologyText;
    }

    public void setApplicationTechnologyTechnologyText(String applicationTechnologyTechnologyText) {
        this.applicationTechnologyTechnologyText = applicationTechnologyTechnologyText;
    }

    public String getProjectBackgroundText() {
        return projectBackgroundText;
    }

    public void setProjectBackgroundText(String projectBackgroundText) {
        this.projectBackgroundText = projectBackgroundText;
    }

    public String getApplicationTechnologyProductsText() {
        return applicationTechnologyProductsText;
    }

    public void setApplicationTechnologyProductsText(String applicationTechnologyProductsText) {
        this.applicationTechnologyProductsText = applicationTechnologyProductsText;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getLegalPersonCode() {
        return legalPersonCode;
    }

    public void setLegalPersonCode(String legalPersonCode) {
        this.legalPersonCode = legalPersonCode;
    }

    public String getCustomClassification() {
        return customClassification;
    }

    public String getAssignorAndAssignProfit() {
        return assignorAndAssignProfit;
    }

    public void setAssignorAndAssignProfit(String assignorAndAssignProfit) {
        this.assignorAndAssignProfit = assignorAndAssignProfit;
    }

    public void setCustomClassification(String customClassification) {
        this.customClassification = customClassification;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevelText() {
        return levelText;
    }

    public void setLevelText(String levelText) {
        this.levelText = levelText;
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
        sb.append("]");
        return sb.toString();
    }
}
