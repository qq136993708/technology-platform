package com.pcitc.base.expert;

import java.io.Serializable;
import java.util.Date;

/**
 * zjk_patent
 * @author 
 */
public class ZjkPatent implements Serializable {
	private static final long serialVersionUID = 2L;
    /**
     * 主键
     */
    private String id;

    /**
     * 专家ID
     */
    private String expertId;

    /**
     * 数据来源（1本系统，2外系统）
     */
    private String sourceType="";

    /**
     * 删除状态（0未删除，1删除）
     */
    private String delStatus;

    /**
     * 专利名称
     */
    private String patentName="";

    /**
     * 专利类型
     */
    private String patentType="";
    private String  patentTypeStr;
    /*
     * 录入/导入标识
     * */
    private String  flag = "";
    
    
    private String knowledgeScope="";
    private String knowledgePerson="";
    private String createUser="";
    private String expertNum="";
    
    

	

	/**
     * 专利描述
     */
    private String describer="";

    /**
     * 获得专利时间
     */
    private Date getPatentTime;
    /**
     * 获得专利时间
     */
    private String getPatentTimeStr;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 专利号
     */
    private String patentNo="";

    /**
     * 专利范围
     */
    private String patentScope="";

    /**
     * 专利种类
     */
    private String patentTypes="";

    /**
     * 专利排名
     */
    private String patentRanking="";

    /**
     * 应用效果
     */
    private String applicationEffect="";

    /**
     * 外系统ID
     */
    private String outSystemId="";
    
    private String secretLevel="";
    private String secretLevelStr="";
    
    
    
    
    
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
	public String getSourceType() {
		return sourceType;
	}
	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}
	public String getDelStatus() {
		return delStatus;
	}
	public void setDelStatus(String delStatus) {
		this.delStatus = delStatus;
	}
	public String getPatentName() {
		return patentName;
	}
	public void setPatentName(String patentName) {
		this.patentName = patentName;
	}
	public String getPatentType() {
		return patentType;
	}
	public void setPatentType(String patentType) {
		this.patentType = patentType;
	}
	public String getPatentTypeStr() {
		return patentTypeStr;
	}
	public void setPatentTypeStr(String patentTypeStr) {
		this.patentTypeStr = patentTypeStr;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
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
	public String getExpertNum() {
		return expertNum;
	}
	public void setExpertNum(String expertNum) {
		this.expertNum = expertNum;
	}
	public String getDescriber() {
		return describer;
	}
	public void setDescriber(String describer) {
		this.describer = describer;
	}
	public Date getGetPatentTime() {
		return getPatentTime;
	}
	public void setGetPatentTime(Date getPatentTime) {
		this.getPatentTime = getPatentTime;
	}
	public String getGetPatentTimeStr() {
		return getPatentTimeStr;
	}
	public void setGetPatentTimeStr(String getPatentTimeStr) {
		this.getPatentTimeStr = getPatentTimeStr;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getPatentNo() {
		return patentNo;
	}
	public void setPatentNo(String patentNo) {
		this.patentNo = patentNo;
	}
	public String getPatentScope() {
		return patentScope;
	}
	public void setPatentScope(String patentScope) {
		this.patentScope = patentScope;
	}
	public String getPatentTypes() {
		return patentTypes;
	}
	public void setPatentTypes(String patentTypes) {
		this.patentTypes = patentTypes;
	}
	public String getPatentRanking() {
		return patentRanking;
	}
	public void setPatentRanking(String patentRanking) {
		this.patentRanking = patentRanking;
	}
	public String getApplicationEffect() {
		return applicationEffect;
	}
	public void setApplicationEffect(String applicationEffect) {
		this.applicationEffect = applicationEffect;
	}
	public String getOutSystemId() {
		return outSystemId;
	}
	public void setOutSystemId(String outSystemId) {
		this.outSystemId = outSystemId;
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
    
    

    

	

}