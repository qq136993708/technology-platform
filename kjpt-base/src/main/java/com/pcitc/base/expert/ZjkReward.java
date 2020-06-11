package com.pcitc.base.expert;

import java.io.Serializable;
import java.util.Date;

/**
 * zjk_reward
 * @author 
 */
public class ZjkReward implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 专家ID
     */
    private String expertId="";

    /**
     * 删除状态（0未删除，1删除）
     */
    private String delStatus="";

    /**
     * 数据来源（1本系统，2外系统）
     */
    private String sourceType="";

    /**
     * 奖励级别
     */
    private String rewarkLevel="";
    
    private String  rewarkLevelStr;
    
    
    
    
    

    public String getRewarkLevelStr() {
		return rewarkLevelStr;
	}

	public void setRewarkLevelStr(String rewarkLevelStr) {
		this.rewarkLevelStr = rewarkLevelStr;
	}

	/**
     * 奖励描述
     */
    private String notes="";

    /**
     * 授奖单位
     */
    private String awardingUnit="";

    /**
     * 奖励时间
     */
    private Date awardingTime;
    
    
    /**
     * 奖励时间
     */
    private String awardingTimeStr;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 外系统ID
     */
    private String outSystemId="";

    /*
     * 录入/导入标识
     * */
    private String  flag = "";
    
    
    private String secretLevel="";
    private String secretLevelStr="";
    private String knowledgeScope="";
    private String knowledgePerson="";
    private String createUser="";

    private String awardingUnitStr;


    public String getAwardingUnitStr() {
        return awardingUnitStr;
    }

    public void setAwardingUnitStr(String awardingUnitStr) {
        this.awardingUnitStr = awardingUnitStr;
    }

    public String getKnowledgeScope() {
		return knowledgeScope;
	}

	public void setKnowledgeScope(String knowledgeScope) {
		this.knowledgeScope = knowledgeScope;
	}

	public String getKnowledgePerson() {
		return knowledgePerson;
	}

	public void setKnowledgePerson(String knowledgePerson) {
		this.knowledgePerson = knowledgePerson;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getSecretLevel() {
		return secretLevel;
	}

	public void setSecretLevel(String secretLevel) {
		this.secretLevel = secretLevel;
	}

	public String getSecretLevelStr() {
		return secretLevelStr;
	}

	public void setSecretLevelStr(String secretLevelStr) {
		this.secretLevelStr = secretLevelStr;
	}

	private static final long serialVersionUID = 1L;
	
	

    public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExpertId() {
        return expertId;
    }

    public void setExpertId(String expertId) {
        this.expertId = expertId;
    }

    public String getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(String delStatus) {
        this.delStatus = delStatus;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getRewarkLevel() {
        return rewarkLevel;
    }

    public void setRewarkLevel(String rewarkLevel) {
        this.rewarkLevel = rewarkLevel;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getAwardingUnit() {
        return awardingUnit;
    }

    public void setAwardingUnit(String awardingUnit) {
        this.awardingUnit = awardingUnit;
    }

    public Date getAwardingTime() {
        return awardingTime;
    }

    public void setAwardingTime(Date awardingTime) {
        this.awardingTime = awardingTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOutSystemId() {
        return outSystemId;
    }

    public void setOutSystemId(String outSystemId) {
        this.outSystemId = outSystemId;
    }

	public String getAwardingTimeStr() {
		return awardingTimeStr;
	}

	public void setAwardingTimeStr(String awardingTimeStr) {
		this.awardingTimeStr = awardingTimeStr;
	}

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }


}