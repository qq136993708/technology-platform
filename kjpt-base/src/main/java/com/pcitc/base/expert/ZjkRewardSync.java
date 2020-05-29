package com.pcitc.base.expert;

import java.io.Serializable;
import java.util.Date;

/**
 * zjk_reward_sync
 * @author 
 */
public class ZjkRewardSync implements Serializable {
    private String id;

    /**
     * 人员编号
     */
    private String expertNum;

    private String expertId;

    /**
     * 序号
     */
    private String outSysId;

    private Date createTime;

    /**
     * 人才分类
     */
    private String personType;

    /**
     * 高层次人才等级
     */
    private String heightPersonLevel;

    /**
     * 高层次人才类别
     */
    private String heightPersonType;

    /**
     * 获奖级别
     */
    private String rewardLevelCode;

    /**
     * 获奖级别
     */
    private String rewardLevelName;

    /**
     * 获奖类别
     */
    private String rewardTypeCode;

    /**
     * 获奖类别
     */
    private String rewardTypeName;

    /**
     * 授予时间
     */
    private Date rewardDate;
    
    
    private String rewardDateStr;
    
    
    private String heightPersonLevelName;
    private String heightPersonTypeName;
    
    
    
    
    

    public String getHeightPersonLevelName() {
		return heightPersonLevelName;
	}

	public void setHeightPersonLevelName(String heightPersonLevelName) {
		this.heightPersonLevelName = heightPersonLevelName;
	}

	public String getHeightPersonTypeName() {
		return heightPersonTypeName;
	}

	public void setHeightPersonTypeName(String heightPersonTypeName) {
		this.heightPersonTypeName = heightPersonTypeName;
	}

	public String getRewardDateStr() {
		return rewardDateStr;
	}

	public void setRewardDateStr(String rewardDateStr) {
		this.rewardDateStr = rewardDateStr;
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

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public String getHeightPersonLevel() {
        return heightPersonLevel;
    }

    public void setHeightPersonLevel(String heightPersonLevel) {
        this.heightPersonLevel = heightPersonLevel;
    }

    public String getHeightPersonType() {
        return heightPersonType;
    }

    public void setHeightPersonType(String heightPersonType) {
        this.heightPersonType = heightPersonType;
    }

    public String getRewardLevelCode() {
        return rewardLevelCode;
    }

    public void setRewardLevelCode(String rewardLevelCode) {
        this.rewardLevelCode = rewardLevelCode;
    }

    public String getRewardLevelName() {
        return rewardLevelName;
    }

    public void setRewardLevelName(String rewardLevelName) {
        this.rewardLevelName = rewardLevelName;
    }

    public String getRewardTypeCode() {
        return rewardTypeCode;
    }

    public void setRewardTypeCode(String rewardTypeCode) {
        this.rewardTypeCode = rewardTypeCode;
    }

    public String getRewardTypeName() {
        return rewardTypeName;
    }

    public void setRewardTypeName(String rewardTypeName) {
        this.rewardTypeName = rewardTypeName;
    }

    public Date getRewardDate() {
        return rewardDate;
    }

    public void setRewardDate(Date rewardDate) {
        this.rewardDate = rewardDate;
    }
}