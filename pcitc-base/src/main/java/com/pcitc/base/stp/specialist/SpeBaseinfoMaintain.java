package com.pcitc.base.stp.specialist;

import java.io.Serializable;
import com.pcitc.base.util.SearchInfo;

public class SpeBaseinfoMaintain extends SearchInfo  implements Serializable{
    private String baseId;

	private String baseCode;

	private String createUser;

	private String createDate;

	private String updateUser;

	private String updateDate;

	private String status;

	private String auditStatus;

	private String name;

	private String age;

	private String nativePlace;

	private String education;

	private String titleInfo;

	private String workResume;

	private String technicalField;

	private String rewardPunishmentInfo;

	private String avoidanceInfo;

	private String professionalClassification;

	private String technicalQualificationType;
	
	private static final long serialVersionUID = 1L;

	public String getBaseId() {
		return baseId;
	}

	public void setBaseId(String baseId) {
		this.baseId = baseId;
	}

	public String getBaseCode() {
		return baseCode;
	}

	public void setBaseCode(String baseCode) {
		this.baseCode = baseCode;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getTitleInfo() {
		return titleInfo;
	}

	public void setTitleInfo(String titleInfo) {
		this.titleInfo = titleInfo;
	}

	public String getWorkResume() {
		return workResume;
	}

	public void setWorkResume(String workResume) {
		this.workResume = workResume;
	}

	public String getTechnicalField() {
		return technicalField;
	}

	public void setTechnicalField(String technicalField) {
		this.technicalField = technicalField;
	}

	public String getRewardPunishmentInfo() {
		return rewardPunishmentInfo;
	}

	public void setRewardPunishmentInfo(String rewardPunishmentInfo) {
		this.rewardPunishmentInfo = rewardPunishmentInfo;
	}

	public String getAvoidanceInfo() {
		return avoidanceInfo;
	}

	public void setAvoidanceInfo(String avoidanceInfo) {
		this.avoidanceInfo = avoidanceInfo;
	}

	public String getProfessionalClassification() {
		return professionalClassification;
	}

	public void setProfessionalClassification(String professionalClassification) {
		this.professionalClassification = professionalClassification;
	}

	public String getTechnicalQualificationType() {
		return technicalQualificationType;
	}

	public void setTechnicalQualificationType(String technicalQualificationType) {
		this.technicalQualificationType = technicalQualificationType;
	}
}