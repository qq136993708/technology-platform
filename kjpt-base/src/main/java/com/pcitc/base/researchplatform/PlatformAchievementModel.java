package com.pcitc.base.researchplatform;

import com.pcitc.base.common.RecordModel;

import java.io.Serializable;

/**
 * <p>科研平台-成果</p>
 * <p>Table: kypt_treatise - 科研平台-成果</p>
 * @author ty
 */
public class PlatformAchievementModel extends RecordModel implements Serializable {

    /**
     * 数据主键
     */
    private String id;
    /**
     * 对应的平台ID
     */
    private String platformId="";
    /**
     * 系统中的项目表的主键ID
     */
    private String baseId="";
    /**
     * 成果名称
     */
    private String achievementName="";
    /**
     * 成果类别
     */
    private String achievementType="";
    private String achievementTypeText="";
    /**
     * 申请单位
     */
    private String applicantUnit="";
    private String applicantUnitText="";
    /**
     * 申请年度
     */
    private String applicantYear="";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getBaseId() {
        return baseId;
    }

    public void setBaseId(String baseId) {
        this.baseId = baseId;
    }

    public String getAchievementName() {
        return achievementName;
    }

    public void setAchievementName(String achievementName) {
        this.achievementName = achievementName;
    }

    public String getAchievementType() {
        return achievementType;
    }

    public void setAchievementType(String achievementType) {
        this.achievementType = achievementType;
    }

    public String getApplicantUnit() {
        return applicantUnit;
    }

    public void setApplicantUnit(String applicantUnit) {
        this.applicantUnit = applicantUnit;
    }

    public String getApplicantYear() {
        return applicantYear;
    }

    public void setApplicantYear(String applicantYear) {
        this.applicantYear = applicantYear;
    }

    public String getAchievementTypeText() {
        return achievementTypeText;
    }

    public void setAchievementTypeText(String achievementTypeText) {
        this.achievementTypeText = achievementTypeText;
    }

    public String getApplicantUnitText() {
        return applicantUnitText;
    }

    public void setApplicantUnitText(String applicantUnitText) {
        this.applicantUnitText = applicantUnitText;
    }
}
