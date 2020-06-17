package com.pcitc.base.researchplatform;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pcitc.base.common.RecordModel;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>平台基本信息</p>
 * <p>Table: kypt_info - 科研平台-基本信息</p>
 * @author ty
 */
public class PlatformInfoModel extends RecordModel implements Serializable {

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
    private String researchFieldText="";
    /**
     * 依托单位
     */
    private String supportingInstitutions="";
    private String supportingInstitutionsText="";
    /**
     * 科研经费
     */
    private BigDecimal researchFunds;
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
    private String typeText="";
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
    private String levelText="";

    /**
     * 平台图片
     */
    private String imgId="";

    /**
     * 平台项目数量
     */
    private Integer projectCount=0;

    /**
     * 平台成果数量
     */
    private Integer achievementCount=0;
    
    private Integer nameCount=0;
    
    private String nameKey="";
    

    /**
     * 导入数据的批次标识
     */
    @JsonInclude
    private String batchId="";
    
    

    public String getNameKey() {
		return nameKey;
	}

	public void setNameKey(String nameKey) {
		this.nameKey = nameKey;
	}

	public Integer getNameCount() {
		return nameCount;
	}

	public void setNameCount(Integer nameCount) {
		this.nameCount = nameCount;
	}

	public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

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

    public BigDecimal getResearchFunds() {
        return researchFunds;
    }

    public void setResearchFunds(BigDecimal researchFunds) {
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

    public String getResearchFieldText() {
        return researchFieldText;
    }

    public void setResearchFieldText(String researchFieldText) {
        this.researchFieldText = researchFieldText;
    }

    public String getSupportingInstitutionsText() {
        return supportingInstitutionsText;
    }

    public void setSupportingInstitutionsText(String supportingInstitutionsText) {
        this.supportingInstitutionsText = supportingInstitutionsText;
    }

    public String getTypeText() {
        return typeText;
    }

    public void setTypeText(String typeText) {
        this.typeText = typeText;
    }

    public String getLevelText() {
        return levelText;
    }

    public void setLevelText(String levelText) {
        this.levelText = levelText;
    }

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    public Integer getProjectCount() {
        return projectCount;
    }

    public void setProjectCount(Integer projectCount) {
        this.projectCount = projectCount;
    }

    public Integer getAchievementCount() {
        return achievementCount;
    }

    public void setAchievementCount(Integer achievementCount) {
        this.achievementCount = achievementCount;
    }
}
