package com.pcitc.base.expert;

import java.io.Serializable;
import java.util.Date;

/**
 * zjk_project
 * @author 
 */
public class ZjkProject implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 专家ID
     */
    private String expertId;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 负责单位
     */
    private String chargeUnit;

    /**
     * 研究目标
     */
    private String researchTarget;

    /**
     * 立项年度
     */
    private String setupYeat;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 删除状态（0未删除，1删除）
     */
    private String delStatus;

    /**
     * 数据来源（1本系统，2外系统）
     */
    private String sourceType;

    /**
     * 外系统ID
     */
    private String outSystemId;
    
    private String  chargeUnitStr;

    /*
     * 录入/导入标识
     * */
    private String  flag = "";
    
    private String secretLevel="";
    private String secretLevelStr="";
    
    
    private String knowledgeScope="";
    private String knowledgePerson="";
    private String createUser="";
    

    


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

	public String getChargeUnitStr() {
		return chargeUnitStr;
	}

	public void setChargeUnitStr(String chargeUnitStr) {
		this.chargeUnitStr = chargeUnitStr;
	}

	private static final long serialVersionUID = 1L;

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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getChargeUnit() {
        return chargeUnit;
    }

    public void setChargeUnit(String chargeUnit) {
        this.chargeUnit = chargeUnit;
    }

    public String getResearchTarget() {
        return researchTarget;
    }

    public void setResearchTarget(String researchTarget) {
        this.researchTarget = researchTarget;
    }

    public String getSetupYeat() {
        return setupYeat;
    }

    public void setSetupYeat(String setupYeat) {
        this.setupYeat = setupYeat;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public String getOutSystemId() {
        return outSystemId;
    }

    public void setOutSystemId(String outSystemId) {
        this.outSystemId = outSystemId;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
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
        ZjkProject other = (ZjkProject) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getExpertId() == null ? other.getExpertId() == null : this.getExpertId().equals(other.getExpertId()))
            && (this.getProjectName() == null ? other.getProjectName() == null : this.getProjectName().equals(other.getProjectName()))
            && (this.getChargeUnit() == null ? other.getChargeUnit() == null : this.getChargeUnit().equals(other.getChargeUnit()))
            && (this.getResearchTarget() == null ? other.getResearchTarget() == null : this.getResearchTarget().equals(other.getResearchTarget()))
            && (this.getSetupYeat() == null ? other.getSetupYeat() == null : this.getSetupYeat().equals(other.getSetupYeat()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getDelStatus() == null ? other.getDelStatus() == null : this.getDelStatus().equals(other.getDelStatus()))
            && (this.getSourceType() == null ? other.getSourceType() == null : this.getSourceType().equals(other.getSourceType()))
            && (this.getOutSystemId() == null ? other.getOutSystemId() == null : this.getOutSystemId().equals(other.getOutSystemId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getExpertId() == null) ? 0 : getExpertId().hashCode());
        result = prime * result + ((getProjectName() == null) ? 0 : getProjectName().hashCode());
        result = prime * result + ((getChargeUnit() == null) ? 0 : getChargeUnit().hashCode());
        result = prime * result + ((getResearchTarget() == null) ? 0 : getResearchTarget().hashCode());
        result = prime * result + ((getSetupYeat() == null) ? 0 : getSetupYeat().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getDelStatus() == null) ? 0 : getDelStatus().hashCode());
        result = prime * result + ((getSourceType() == null) ? 0 : getSourceType().hashCode());
        result = prime * result + ((getOutSystemId() == null) ? 0 : getOutSystemId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", expertId=").append(expertId);
        sb.append(", projectName=").append(projectName);
        sb.append(", chargeUnit=").append(chargeUnit);
        sb.append(", researchTarget=").append(researchTarget);
        sb.append(", setupYeat=").append(setupYeat);
        sb.append(", createTime=").append(createTime);
        sb.append(", delStatus=").append(delStatus);
        sb.append(", sourceType=").append(sourceType);
        sb.append(", outSystemId=").append(outSystemId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}