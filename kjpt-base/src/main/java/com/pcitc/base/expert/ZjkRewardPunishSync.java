package com.pcitc.base.expert;

import java.io.Serializable;
import java.util.Date;

/**
 * zjk_reward_punish_sync
 * @author 
 */
public class ZjkRewardPunishSync implements Serializable {
    private String id;

    private String expertNum;

    private String expertId;

    private String outSysId;

    private Date createTime;

    /**
     * 奖励或惩罚名称
     */
    private String title;

    /**
     * 奖励种类
     */
    private String rewardType;

    /**
     * 奖惩情况描述
     */
    private String notes;

    /**
     * 奖惩类别
     */
    private String rewardPunishType;

    /**
     * 奖惩级别
     */
    private String rewardPunishLevel;

    /**
     * 批准时间
     */
    private Date approveDate;

    /**
     * 奖惩批准单位
     */
    private String approveUnit;
    
    
    private String approveDateStr;

    private String rewardPunishLevelCode;
    private String rewardPunishTypeCode;
    private String rewardTypeCode;

    
    
    

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

	public String getApproveDateStr() {
		return approveDateStr;
	}

	public void setApproveDateStr(String approveDateStr) {
		this.approveDateStr = approveDateStr;
	}

	private static final long serialVersionUID = 1L;

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
}