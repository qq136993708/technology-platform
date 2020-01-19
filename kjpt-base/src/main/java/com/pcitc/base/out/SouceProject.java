package com.pcitc.base.out;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * PS_JH_PROJECT
 * @author 
 */
public class SouceProject implements Serializable {
    /**
     * 编号
     */
    private String id;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目密级
     */
    private String projectLevel;

    /**
     * 项目类型
     */
    private String projectType;

    /**
     * 项目编号(编码)
     */
    private String projectNumber;

    /**
     * 国家投入
     */
    private BigDecimal nationalInput;

    /**
     * 集团投入
     */
    private BigDecimal groupInput;

    /**
     * 单位投入
     */
    private BigDecimal unitInput;

    /**
     * 总投资
     */
    private BigDecimal totalPrice;

    /**
     * 组织单位表(多)
     */
    private String organization;

    /**
     * 主管部门表
     */
    private String administration;

    /**
     * 牵头单位表(多)
     */
    private String leadunit;

    /**
     * 研究目标
     */
    private Object researchArms;

    /**
     * 研究成果
     */
    private String researchResult;

    /**
     * 项目状态
     */
    private String status;

    /**
     * 项目周期
     */
    private String projectCycle;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     *  更新时间
     */
    private Object updateDate;

    /**
     * 备注
     */
    private Object remarks;

    /**
     * 删除标记
     */
    private String delFlag;

    /**
     * 项目开始时间(预留)
     */
    private Date startTime;

    /**
     * 项目结束时间(预留)
     */
    private Date endTime;

    private String organizationId;

    private String administrationId;

    private String leadunitId;

    /**
     * 专业(国防)
     */
    private String major;

    /**
     * 项目负责人(国防)
     */
    private String projectLeader;

    /**
     * 项目负责人联系电话(国防)
     */
    private String phone;

    /**
     * 主承研单位法人代表(国防)
     */
    private String corporator;

    /**
     * 建议书页数(国防)
     */
    private BigDecimal pageNumber;

    /**
     * 五年规划(国防)
     */
    private String fiveYearPlan;

    /**
     * 研究内容(国防)
     */
    private String researchContent;

    /**
     * 针对解决的重大问题(国防)
     */
    private Object problem;

    /**
     * 项目建议书ID(国防)
     */
    private String jysId;

    /**
     * 验收总分数
     */
    private BigDecimal acceptanceScore;

    /**
     * 主承研单位所在省
     */
    private String province;

    /**
     * 建议书编码
     */
    private String jysCode;

    /**
     * 技术族编码
     */
    private String techCode;

    /**
     * 技术族名称
     */
    private String techName;

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

	public Object getResearchArms() {
		return researchArms;
	}

	public void setResearchArms(Object researchArms) {
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

	public Object getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Object updateDate) {
		this.updateDate = updateDate;
	}

	public Object getRemarks() {
		return remarks;
	}

	public void setRemarks(Object remarks) {
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

	public Object getProblem() {
		return problem;
	}

	public void setProblem(Object problem) {
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

   
}