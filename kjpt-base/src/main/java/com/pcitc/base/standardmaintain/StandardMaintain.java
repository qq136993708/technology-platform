package com.pcitc.base.standardmaintain;

import com.pcitc.base.common.RecordModel;

import java.util.Date;

/**
 * @author ty
 */
public class StandardMaintain extends RecordModel {

    /**
     * 主键
     */
    private String id;
    /**
     * 计划号
     */
    private String planNum;
    /**
     * 计划中文名称
     */
    private String planChineseName;
    /**
     * 计划英文名称
     */
    private String planEnglishName;
    /**
     * 下达年度
     */
    private String releaseYear;
    /**
     * 标准类型
     */
    private String standardType;
    /**
     * 标准类型字典翻译
     */
    private String standardTypeText;
    /**
     * 主编单位
     */
    private String chiefEditorUnit;
    /**
     * 主编单位翻译
     */
    private String chiefEditorUnitText;
    /**
     * 参编单位
     */
    private String partakeEditorUnit;
    /**
     * 参编单位翻译
     */
    private String partakeEditorUnitText;
    /**
     * 显示密级
     */
    private String level;
    /**
     * 显示密级翻译
     */
    private String levelText;
    /**
     * 修改状态
     */
    private String updateStatus;
    /**
     * 修改状态翻译
     */
    private String updateStatusText;
    /**
     * 文件状态
     */
    private String fileStatus;
    /**
     * 文件状态翻译
     */
    private String fileStatusText;
    /**
     * 是否已发布
     */
    private String isPublish;
    /**
     * 是否已发布翻译
     */
    private String isPublishText;
    /**
     * 主管部门
     */
    private String manageOrg;
    /**
     * 技术委员会
     */
    private String technicalCommittee;
    /**
     * 归口单位
     */
    private String putUnderUnit;
    /**
     * 归口单位翻译
     */
    private String putUnderUnitText;
    /**
     * 参考标准
     */
    private String consultStandard;
    /**
     * 一致性程度
     */
    private String uniformityDegree;
    /**
     * 拟替代标准
     */
    private String toReplacedStandard;
    /**
     * 标准号
     */
    private String standardNum;
    /**
     * 标准名称
     */
    private String standardName;
    /**
     * 英文名称
     */
    private String englishName;
    /**
     * 发布时间
     */
    private Date publishDate;
    /**
     * 实施时间
     */
    private Date effectiveDate;
    /**
     * 是否已发布英文版
     */
    private String isPublishEnglishEdition;
    /**
     * 是否已发布英文版字典翻译
     */
    private String isPublishEnglishEditionText;
    /**
     * 被代替标准
     */
    private String replaceStandard;
    /**
     * 附件
     */
    private String files;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlanNum() {
        return planNum;
    }

    public void setPlanNum(String planNum) {
        this.planNum = planNum;
    }

    public String getPlanChineseName() {
        return planChineseName;
    }

    public void setPlanChineseName(String planChineseName) {
        this.planChineseName = planChineseName;
    }

    public String getPlanEnglishName() {
        return planEnglishName;
    }

    public void setPlanEnglishName(String planEnglishName) {
        this.planEnglishName = planEnglishName;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getStandardType() {
        return standardType;
    }

    public void setStandardType(String standardType) {
        this.standardType = standardType;
    }

    public String getStandardTypeText() {
        return standardTypeText;
    }

    public void setStandardTypeText(String standardTypeText) {
        this.standardTypeText = standardTypeText;
    }

    public String getChiefEditorUnit() {
        return chiefEditorUnit;
    }

    public void setChiefEditorUnit(String chiefEditorUnit) {
        this.chiefEditorUnit = chiefEditorUnit;
    }

    public String getChiefEditorUnitText() {
        return chiefEditorUnitText;
    }

    public void setChiefEditorUnitText(String chiefEditorUnitText) {
        this.chiefEditorUnitText = chiefEditorUnitText;
    }

    public String getPartakeEditorUnit() {
        return partakeEditorUnit;
    }

    public void setPartakeEditorUnit(String partakeEditorUnit) {
        this.partakeEditorUnit = partakeEditorUnit;
    }

    public String getPartakeEditorUnitText() {
        return partakeEditorUnitText;
    }

    public void setPartakeEditorUnitText(String partakeEditorUnitText) {
        this.partakeEditorUnitText = partakeEditorUnitText;
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

    public String getUpdateStatus() {
        return updateStatus;
    }

    public void setUpdateStatus(String updateStatus) {
        this.updateStatus = updateStatus;
    }

    public String getUpdateStatusText() {
        return updateStatusText;
    }

    public void setUpdateStatusText(String updateStatusText) {
        this.updateStatusText = updateStatusText;
    }

    public String getFileStatus() {
        return fileStatus;
    }

    public void setFileStatus(String fileStatus) {
        this.fileStatus = fileStatus;
    }

    public String getFileStatusText() {
        return fileStatusText;
    }

    public void setFileStatusText(String fileStatusText) {
        this.fileStatusText = fileStatusText;
    }

    public String getIsPublish() {
        return isPublish;
    }

    public void setIsPublish(String isPublish) {
        this.isPublish = isPublish;
    }

    public String getIsPublishText() {
        return isPublishText;
    }

    public void setIsPublishText(String isPublishText) {
        this.isPublishText = isPublishText;
    }

    public String getManageOrg() {
        return manageOrg;
    }

    public void setManageOrg(String manageOrg) {
        this.manageOrg = manageOrg;
    }

    public String getTechnicalCommittee() {
        return technicalCommittee;
    }

    public void setTechnicalCommittee(String technicalCommittee) {
        this.technicalCommittee = technicalCommittee;
    }

    public String getPutUnderUnit() {
        return putUnderUnit;
    }

    public void setPutUnderUnit(String putUnderUnit) {
        this.putUnderUnit = putUnderUnit;
    }

    public String getPutUnderUnitText() {
        return putUnderUnitText;
    }

    public void setPutUnderUnitText(String putUnderUnitText) {
        this.putUnderUnitText = putUnderUnitText;
    }

    public String getConsultStandard() {
        return consultStandard;
    }

    public void setConsultStandard(String consultStandard) {
        this.consultStandard = consultStandard;
    }

    public String getUniformityDegree() {
        return uniformityDegree;
    }

    public void setUniformityDegree(String uniformityDegree) {
        this.uniformityDegree = uniformityDegree;
    }

    public String getToReplacedStandard() {
        return toReplacedStandard;
    }

    public void setToReplacedStandard(String toReplacedStandard) {
        this.toReplacedStandard = toReplacedStandard;
    }

    public String getStandardNum() {
        return standardNum;
    }

    public void setStandardNum(String standardNum) {
        this.standardNum = standardNum;
    }

    public String getStandardName() {
        return standardName;
    }

    public void setStandardName(String standardName) {
        this.standardName = standardName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getIsPublishEnglishEdition() {
        return isPublishEnglishEdition;
    }

    public void setIsPublishEnglishEdition(String isPublishEnglishEdition) {
        this.isPublishEnglishEdition = isPublishEnglishEdition;
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
    }

    public String getIsPublishEnglishEditionText() {
        return isPublishEnglishEditionText;
    }

    public void setIsPublishEnglishEditionText(String isPublishEnglishEditionText) {
        this.isPublishEnglishEditionText = isPublishEnglishEditionText;
    }

    public String getReplaceStandard() {
        return replaceStandard;
    }

    public void setReplaceStandard(String replaceStandard) {
        this.replaceStandard = replaceStandard;
    }
}
