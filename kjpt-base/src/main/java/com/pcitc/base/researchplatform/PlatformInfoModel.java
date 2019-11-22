package com.pcitc.base.researchplatform;

import com.pcitc.base.common.RecordModel;

import java.io.Serializable;

/**
 * <p>平台基本信息</p>
 * <p>Table: kypt_info - 科研平台-基本信息</p>
 * @author ty
 */
public class PlatformInfoModel extends RecordModel implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 数据主键
     */
    private String id;
    /**
     * 平台名称
     */
    private String platformName="";
    /**
     * 研究领域
     */
    private String researchField="";
    /**
     * 依托单位
     */
    private String supportingInstitutions="";
    /**
     * 科研经费
     */
    private String researchFunds="";
    /**
     * 平台介绍
     */
    private String platformIntroduction="";
    /**
     * 主要负责人
     */
    private String personLiable="";
    /**
     * 平台类型
     */
    private String type="";
    /**
     * 科研团队介绍
     */
    private String teamIntroduction="";
    /**
     * 科研整体情况
     */
    private String overallSituation="";
    /**
     * 平台评分
     */
    private String platformScoring="";
    /**
     * 平台等级
     */
    private String level="";


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getResearchField() {
        return researchField;
    }

    public void setResearchField(String researchField) {
        this.researchField = researchField;
    }

    public String getSupportingInstitutions() {
        return supportingInstitutions;
    }

    public void setSupportingInstitutions(String supportingInstitutions) {
        this.supportingInstitutions = supportingInstitutions;
    }

    public String getResearchFunds() {
        return researchFunds;
    }

    public void setResearchFunds(String researchFunds) {
        this.researchFunds = researchFunds;
    }

    public String getPlatformIntroduction() {
        return platformIntroduction;
    }

    public void setPlatformIntroduction(String platformIntroduction) {
        this.platformIntroduction = platformIntroduction;
    }

    public String getPersonLiable() {
        return personLiable;
    }

    public void setPersonLiable(String personLiable) {
        this.personLiable = personLiable;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTeamIntroduction() {
        return teamIntroduction;
    }

    public void setTeamIntroduction(String teamIntroduction) {
        this.teamIntroduction = teamIntroduction;
    }

    public String getOverallSituation() {
        return overallSituation;
    }

    public void setOverallSituation(String overallSituation) {
        this.overallSituation = overallSituation;
    }

    public String getPlatformScoring() {
        return platformScoring;
    }

    public void setPlatformScoring(String platformScoring) {
        this.platformScoring = platformScoring;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }


}
