package com.pcitc.base.out;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * out_project
 * @author 
 */
public class OutProject implements Serializable {
    private String id;

    private String projectName;

    private String projectLevel;

    private String projectType;

    private String projectNumber;

    private BigDecimal nationalInput;

    private BigDecimal groupInput;

    private BigDecimal unitInput;

    private BigDecimal totalPrice;

    private String organization;

    private String administration;

    private String leadunit;

    private String researchArms;

    private String researchResult;

    private String status;

    private String projectCycle;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String remarks;

    private String delFlag;

    private Date startTime;

    private Date endTime;

    private String organizationId;

    private String administrationId;

    private String leadunitId;

    private String major;

    private String projectLeader;

    private String phone;

    private String corporator;

    private BigDecimal pageNumber;

    private String fiveYearPlan;

    private String researchContent;

    private String problem;

    private String jysId;

    private BigDecimal acceptanceScore;

    private String province;

    private String jysCode;

    private String techCode;

    private String techName;

    private String techId;

    private String techPath;
    private String setupYear;
    
	private static final long serialVersionUID = 1L;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectLevel() {
		return projectLevel;
	}
	public void setProjectLevel(String projectLevel) {
		this.projectLevel = projectLevel;
	}
	public String getProjectType() {
		return projectType;
	}
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	public String getProjectNumber() {
		return projectNumber;
	}
	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}
	public BigDecimal getNationalInput() {
		return nationalInput;
	}
	public void setNationalInput(BigDecimal nationalInput) {
		this.nationalInput = nationalInput;
	}
	public BigDecimal getGroupInput() {
		return groupInput;
	}
	public void setGroupInput(BigDecimal groupInput) {
		this.groupInput = groupInput;
	}
	public BigDecimal getUnitInput() {
		return unitInput;
	}
	public void setUnitInput(BigDecimal unitInput) {
		this.unitInput = unitInput;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getAdministration() {
		return administration;
	}
	public void setAdministration(String administration) {
		this.administration = administration;
	}
	public String getLeadunit() {
		return leadunit;
	}
	public void setLeadunit(String leadunit) {
		this.leadunit = leadunit;
	}
	public String getResearchArms() {
		return researchArms;
	}
	public void setResearchArms(String researchArms) {
		this.researchArms = researchArms;
	}
	public String getResearchResult() {
		return researchResult;
	}
	public void setResearchResult(String researchResult) {
		this.researchResult = researchResult;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProjectCycle() {
		return projectCycle;
	}
	public void setProjectCycle(String projectCycle) {
		this.projectCycle = projectCycle;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	public String getAdministrationId() {
		return administrationId;
	}
	public void setAdministrationId(String administrationId) {
		this.administrationId = administrationId;
	}
	public String getLeadunitId() {
		return leadunitId;
	}
	public void setLeadunitId(String leadunitId) {
		this.leadunitId = leadunitId;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getProjectLeader() {
		return projectLeader;
	}
	public void setProjectLeader(String projectLeader) {
		this.projectLeader = projectLeader;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCorporator() {
		return corporator;
	}
	public void setCorporator(String corporator) {
		this.corporator = corporator;
	}
	public BigDecimal getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(BigDecimal pageNumber) {
		this.pageNumber = pageNumber;
	}
	public String getFiveYearPlan() {
		return fiveYearPlan;
	}
	public void setFiveYearPlan(String fiveYearPlan) {
		this.fiveYearPlan = fiveYearPlan;
	}
	public String getResearchContent() {
		return researchContent;
	}
	public void setResearchContent(String researchContent) {
		this.researchContent = researchContent;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getJysId() {
		return jysId;
	}
	public void setJysId(String jysId) {
		this.jysId = jysId;
	}
	public BigDecimal getAcceptanceScore() {
		return acceptanceScore;
	}
	public void setAcceptanceScore(BigDecimal acceptanceScore) {
		this.acceptanceScore = acceptanceScore;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getJysCode() {
		return jysCode;
	}
	public void setJysCode(String jysCode) {
		this.jysCode = jysCode;
	}
	public String getTechCode() {
		return techCode;
	}
	public void setTechCode(String techCode) {
		this.techCode = techCode;
	}
	public String getTechName() {
		return techName;
	}
	public void setTechName(String techName) {
		this.techName = techName;
	}
	public String getTechId() {
		return techId;
	}
	public void setTechId(String techId) {
		this.techId = techId;
	}
	public String getTechPath() {
		return techPath;
	}
	public void setTechPath(String techPath) {
		this.techPath = techPath;
	}
	public String getSetupYear() {
		return setupYear;
	}
	public void setSetupYear(String setupYear) {
		this.setupYear = setupYear;
	}
    
    

  
}