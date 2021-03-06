package com.pcitc.base.common;

import java.io.Serializable;
import java.util.Date;

/**
 * 可追踪实体
 *
 */
public class RecordModel implements Serializable {

	//创建人
	private String creator ="";
	//修改人
	private String updator ="";
	//创建时间
	private Date createDate=new Date();
	//修改时间
	private Date updateDate=new Date();
	//删除标识
	private String deleted = "0";
	//创建人所在单位
	private String createUnitId ="";

	//创建人所在单位名称
	private String createUnitName ="";

	//密级
	private String secretLevel ="";

	//密级字典
	private String secretLevelText ="";

	//知悉范围
	private String knowledgeScope ="";

	//知悉范围人员名称
	private String knowledgePerson ="";


	public String getSecretLevel() {
		return secretLevel;
	}

	public void setSecretLevel(String secretLevel) {
		this.secretLevel = secretLevel;
	}

	public String getUpdator() {
		return updator;
	}
	public void setUpdator(String updator) {
		this.updator = updator;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}


	public String getCreateUnitId() {
		return createUnitId;
	}

	public void setCreateUnitId(String createUnitId) {
		this.createUnitId = createUnitId;
	}

	public String getCreateUnitName() {
		return createUnitName;
	}

	public void setCreateUnitName(String createUnitName) {
		this.createUnitName = createUnitName;
	}

	public String getSecretLevelText() {
		return secretLevelText;
	}

	public void setSecretLevelText(String secretLevelText) {
		this.secretLevelText = secretLevelText;
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
}
