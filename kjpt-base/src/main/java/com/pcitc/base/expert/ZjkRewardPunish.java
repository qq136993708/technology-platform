package com.pcitc.base.expert;

import java.io.Serializable;
import java.util.Date;

/**
 * zjk_reward_punish
 * @author 
 */
public class ZjkRewardPunish implements Serializable {
    private String id;

    private String expertNum;

    private String expertId;

    private String outSysId;

    private Date createTime;

    private String title;

    private String rewardType;

    private String notes;

    private String rewardPunishType;

    private String rewardPunishLevel;

    private Date approveDate;

    private String approveUnit;

    private String rewardPunishLevelCode;

    private String rewardPunishTypeCode;

    private String rewardTypeCode;
    
    private String approveDateStr;
    
    
    

    private static final long serialVersionUID = 1L;
    

    public String getApproveDateStr() {
		return approveDateStr;
	}

	public void setApproveDateStr(String approveDateStr) {
		this.approveDateStr = approveDateStr;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExpertNum() {
        return expertNum;
    }

    public void setExpertNum(String expertNum) {
        this.expertNum = expertNum;
    }

    public String getExpertId() {
        return expertId;
    }

    public void setExpertId(String expertId) {
        this.expertId = expertId;
    }

    public String getOutSysId() {
        return outSysId;
    }

    public void setOutSysId(String outSysId) {
        this.outSysId = outSysId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRewardType() {
        return rewardType;
    }

    public void setRewardType(String rewardType) {
        this.rewardType = rewardType;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getRewardPunishType() {
        return rewardPunishType;
    }

    public void setRewardPunishType(String rewardPunishType) {
        this.rewardPunishType = rewardPunishType;
    }

    public String getRewardPunishLevel() {
        return rewardPunishLevel;
    }

    public void setRewardPunishLevel(String rewardPunishLevel) {
        this.rewardPunishLevel = rewardPunishLevel;
    }

    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    public String getApproveUnit() {
        return approveUnit;
    }

    public void setApproveUnit(String approveUnit) {
        this.approveUnit = approveUnit;
    }

    public String getRewardPunishLevelCode() {
        return rewardPunishLevelCode;
    }

    public void setRewardPunishLevelCode(String rewardPunishLevelCode) {
        this.rewardPunishLevelCode = rewardPunishLevelCode;
    }

    public String getRewardPunishTypeCode() {
        return rewardPunishTypeCode;
    }

    public void setRewardPunishTypeCode(String rewardPunishTypeCode) {
        this.rewardPunishTypeCode = rewardPunishTypeCode;
    }

    public String getRewardTypeCode() {
        return rewardTypeCode;
    }

    public void setRewardTypeCode(String rewardTypeCode) {
        this.rewardTypeCode = rewardTypeCode;
    }
}