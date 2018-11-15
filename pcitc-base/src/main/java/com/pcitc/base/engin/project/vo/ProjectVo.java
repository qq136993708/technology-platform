package com.pcitc.base.engin.project.vo;

import java.io.Serializable;

/**
 * epms_project
 * @author 
 */
public class ProjectVo implements Serializable {
    /**
     * 业务ID
     */
    private String dataId;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 修改人
     */
    private String updateUser;

    /**
     * 修改时间
     */
    private String updateDate;

    /**
     * 业务表单状态
     */
    private String status;

    /**
     * 审批状态
     */
    private String auditStatus;

    /**
     * 公司代码
     */
    private String companyCode;

    /**
     * 所属项目
     */
    private String projectId;

    /**
     * 业务编码
     */
    private String formCode;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目编码
     */
    private String projectCode;

    /**
     * 项目规模
     */
    private String projectScale;

    /**
     * 计划投资
     */
    private String investmentEstimation;

    /**
     * 所属结构
     */
    private String projectStructure;

    /**
     * 所属项目结构ID
     */
    private String projectStructureId;

    /**
     * 建设单位名称
     */
    private String buildUnitName;

    /**
     * 建设单位ID
     */
    private String buildUnitId;

    /**
     * 项目类别
     */
    private String projectType;

    /**
     * 项目性质
     */
    private String projectProperties;

    /**
     * 建设性质
     */
    private String buildProperties;

    /**
     * 建设年限
     */
    private String buildLimit;

    /**
     * 计划开始时间
     */
    private String planStartDateTime;

    /**
     * 计划结束时间
     */
    private String planEndDateTime;

    /**
     * 必须开始时间
     */
    private String mustStartDateTime;

    /**
     * 必须结束时间
     */
    private String mustEndDateTime;

    /**
     * 计划中交日期
     */
    private String planCenterDateTime;

    /**
     * 作业前缀
     */
    private String jobPrefix;

    /**
     * 作业后缀
     */
    private String jobSuffix;

    /**
     * 增量
     */
    private String increment;

    /**
     * 项目状态
     */
    private String projectStatus;

    /**
     * 项目类型
     */
    private String projectGenre;

    /**
     * 建设内容
     */
    private String buildContent;

    /**
     * 项目环境（转储、运转）
     */
    private String projectCondition;

    /**
     * 项目(转储、运行)时间
     */
    private String projectConditionDate;

    /**
     * SAP编码
     */
    private String pspid;

    /**
     * SAP内码
     */
    private String pspnr;

    /**
     * 对象号
     */
    private String objnr;

    /**
     * SAP项目名称
     */
    private String post1;

    /**
     * 项目负责人
     */
    private String verna;

    /**
     * 公司代码
     */
    private String vbukr;

    /**
     * 工厂代码
     */
    private String werks;

    private static final long serialVersionUID = 1L;

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
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

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getFormCode() {
        return formCode;
    }

    public void setFormCode(String formCode) {
        this.formCode = formCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectScale() {
        return projectScale;
    }

    public void setProjectScale(String projectScale) {
        this.projectScale = projectScale;
    }

    public String getInvestmentEstimation() {
        return investmentEstimation;
    }

    public void setInvestmentEstimation(String investmentEstimation) {
        this.investmentEstimation = investmentEstimation;
    }

    public String getProjectStructure() {
        return projectStructure;
    }

    public void setProjectStructure(String projectStructure) {
        this.projectStructure = projectStructure;
    }

    public String getProjectStructureId() {
        return projectStructureId;
    }

    public void setProjectStructureId(String projectStructureId) {
        this.projectStructureId = projectStructureId;
    }

    public String getBuildUnitName() {
        return buildUnitName;
    }

    public void setBuildUnitName(String buildUnitName) {
        this.buildUnitName = buildUnitName;
    }

    public String getBuildUnitId() {
        return buildUnitId;
    }

    public void setBuildUnitId(String buildUnitId) {
        this.buildUnitId = buildUnitId;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getProjectProperties() {
        return projectProperties;
    }

    public void setProjectProperties(String projectProperties) {
        this.projectProperties = projectProperties;
    }

    public String getBuildProperties() {
        return buildProperties;
    }

    public void setBuildProperties(String buildProperties) {
        this.buildProperties = buildProperties;
    }

    public String getBuildLimit() {
        return buildLimit;
    }

    public void setBuildLimit(String buildLimit) {
        this.buildLimit = buildLimit;
    }

    public String getPlanStartDateTime() {
        return planStartDateTime;
    }

    public void setPlanStartDateTime(String planStartDateTime) {
        this.planStartDateTime = planStartDateTime;
    }

    public String getPlanEndDateTime() {
        return planEndDateTime;
    }

    public void setPlanEndDateTime(String planEndDateTime) {
        this.planEndDateTime = planEndDateTime;
    }

    public String getMustStartDateTime() {
        return mustStartDateTime;
    }

    public void setMustStartDateTime(String mustStartDateTime) {
        this.mustStartDateTime = mustStartDateTime;
    }

    public String getMustEndDateTime() {
        return mustEndDateTime;
    }

    public void setMustEndDateTime(String mustEndDateTime) {
        this.mustEndDateTime = mustEndDateTime;
    }

    public String getPlanCenterDateTime() {
        return planCenterDateTime;
    }

    public void setPlanCenterDateTime(String planCenterDateTime) {
        this.planCenterDateTime = planCenterDateTime;
    }

    public String getJobPrefix() {
        return jobPrefix;
    }

    public void setJobPrefix(String jobPrefix) {
        this.jobPrefix = jobPrefix;
    }

    public String getJobSuffix() {
        return jobSuffix;
    }

    public void setJobSuffix(String jobSuffix) {
        this.jobSuffix = jobSuffix;
    }

    public String getIncrement() {
        return increment;
    }

    public void setIncrement(String increment) {
        this.increment = increment;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public String getProjectGenre() {
        return projectGenre;
    }

    public void setProjectGenre(String projectGenre) {
        this.projectGenre = projectGenre;
    }

    public String getBuildContent() {
        return buildContent;
    }

    public void setBuildContent(String buildContent) {
        this.buildContent = buildContent;
    }

    public String getProjectCondition() {
        return projectCondition;
    }

    public void setProjectCondition(String projectCondition) {
        this.projectCondition = projectCondition;
    }

    public String getProjectConditionDate() {
        return projectConditionDate;
    }

    public void setProjectConditionDate(String projectConditionDate) {
        this.projectConditionDate = projectConditionDate;
    }

    public String getPspid() {
        return pspid;
    }

    public void setPspid(String pspid) {
        this.pspid = pspid;
    }

    public String getPspnr() {
        return pspnr;
    }

    public void setPspnr(String pspnr) {
        this.pspnr = pspnr;
    }

    public String getObjnr() {
        return objnr;
    }

    public void setObjnr(String objnr) {
        this.objnr = objnr;
    }

    public String getPost1() {
        return post1;
    }

    public void setPost1(String post1) {
        this.post1 = post1;
    }

    public String getVerna() {
        return verna;
    }

    public void setVerna(String verna) {
        this.verna = verna;
    }

    public String getVbukr() {
        return vbukr;
    }

    public void setVbukr(String vbukr) {
        this.vbukr = vbukr;
    }

    public String getWerks() {
        return werks;
    }

    public void setWerks(String werks) {
        this.werks = werks;
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
        ProjectVo other = (ProjectVo) that;
        return (this.getDataId() == null ? other.getDataId() == null : this.getDataId().equals(other.getDataId()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getAuditStatus() == null ? other.getAuditStatus() == null : this.getAuditStatus().equals(other.getAuditStatus()))
            && (this.getCompanyCode() == null ? other.getCompanyCode() == null : this.getCompanyCode().equals(other.getCompanyCode()))
            && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getFormCode() == null ? other.getFormCode() == null : this.getFormCode().equals(other.getFormCode()))
            && (this.getProjectName() == null ? other.getProjectName() == null : this.getProjectName().equals(other.getProjectName()))
            && (this.getProjectCode() == null ? other.getProjectCode() == null : this.getProjectCode().equals(other.getProjectCode()))
            && (this.getProjectScale() == null ? other.getProjectScale() == null : this.getProjectScale().equals(other.getProjectScale()))
            && (this.getInvestmentEstimation() == null ? other.getInvestmentEstimation() == null : this.getInvestmentEstimation().equals(other.getInvestmentEstimation()))
            && (this.getProjectStructure() == null ? other.getProjectStructure() == null : this.getProjectStructure().equals(other.getProjectStructure()))
            && (this.getProjectStructureId() == null ? other.getProjectStructureId() == null : this.getProjectStructureId().equals(other.getProjectStructureId()))
            && (this.getBuildUnitName() == null ? other.getBuildUnitName() == null : this.getBuildUnitName().equals(other.getBuildUnitName()))
            && (this.getBuildUnitId() == null ? other.getBuildUnitId() == null : this.getBuildUnitId().equals(other.getBuildUnitId()))
            && (this.getProjectType() == null ? other.getProjectType() == null : this.getProjectType().equals(other.getProjectType()))
            && (this.getProjectProperties() == null ? other.getProjectProperties() == null : this.getProjectProperties().equals(other.getProjectProperties()))
            && (this.getBuildProperties() == null ? other.getBuildProperties() == null : this.getBuildProperties().equals(other.getBuildProperties()))
            && (this.getBuildLimit() == null ? other.getBuildLimit() == null : this.getBuildLimit().equals(other.getBuildLimit()))
            && (this.getPlanStartDateTime() == null ? other.getPlanStartDateTime() == null : this.getPlanStartDateTime().equals(other.getPlanStartDateTime()))
            && (this.getPlanEndDateTime() == null ? other.getPlanEndDateTime() == null : this.getPlanEndDateTime().equals(other.getPlanEndDateTime()))
            && (this.getMustStartDateTime() == null ? other.getMustStartDateTime() == null : this.getMustStartDateTime().equals(other.getMustStartDateTime()))
            && (this.getMustEndDateTime() == null ? other.getMustEndDateTime() == null : this.getMustEndDateTime().equals(other.getMustEndDateTime()))
            && (this.getPlanCenterDateTime() == null ? other.getPlanCenterDateTime() == null : this.getPlanCenterDateTime().equals(other.getPlanCenterDateTime()))
            && (this.getJobPrefix() == null ? other.getJobPrefix() == null : this.getJobPrefix().equals(other.getJobPrefix()))
            && (this.getJobSuffix() == null ? other.getJobSuffix() == null : this.getJobSuffix().equals(other.getJobSuffix()))
            && (this.getIncrement() == null ? other.getIncrement() == null : this.getIncrement().equals(other.getIncrement()))
            && (this.getProjectStatus() == null ? other.getProjectStatus() == null : this.getProjectStatus().equals(other.getProjectStatus()))
            && (this.getProjectGenre() == null ? other.getProjectGenre() == null : this.getProjectGenre().equals(other.getProjectGenre()))
            && (this.getBuildContent() == null ? other.getBuildContent() == null : this.getBuildContent().equals(other.getBuildContent()))
            && (this.getProjectCondition() == null ? other.getProjectCondition() == null : this.getProjectCondition().equals(other.getProjectCondition()))
            && (this.getProjectConditionDate() == null ? other.getProjectConditionDate() == null : this.getProjectConditionDate().equals(other.getProjectConditionDate()))
            && (this.getPspid() == null ? other.getPspid() == null : this.getPspid().equals(other.getPspid()))
            && (this.getPspnr() == null ? other.getPspnr() == null : this.getPspnr().equals(other.getPspnr()))
            && (this.getObjnr() == null ? other.getObjnr() == null : this.getObjnr().equals(other.getObjnr()))
            && (this.getPost1() == null ? other.getPost1() == null : this.getPost1().equals(other.getPost1()))
            && (this.getVerna() == null ? other.getVerna() == null : this.getVerna().equals(other.getVerna()))
            && (this.getVbukr() == null ? other.getVbukr() == null : this.getVbukr().equals(other.getVbukr()))
            && (this.getWerks() == null ? other.getWerks() == null : this.getWerks().equals(other.getWerks()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataId() == null) ? 0 : getDataId().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getAuditStatus() == null) ? 0 : getAuditStatus().hashCode());
        result = prime * result + ((getCompanyCode() == null) ? 0 : getCompanyCode().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getFormCode() == null) ? 0 : getFormCode().hashCode());
        result = prime * result + ((getProjectName() == null) ? 0 : getProjectName().hashCode());
        result = prime * result + ((getProjectCode() == null) ? 0 : getProjectCode().hashCode());
        result = prime * result + ((getProjectScale() == null) ? 0 : getProjectScale().hashCode());
        result = prime * result + ((getInvestmentEstimation() == null) ? 0 : getInvestmentEstimation().hashCode());
        result = prime * result + ((getProjectStructure() == null) ? 0 : getProjectStructure().hashCode());
        result = prime * result + ((getProjectStructureId() == null) ? 0 : getProjectStructureId().hashCode());
        result = prime * result + ((getBuildUnitName() == null) ? 0 : getBuildUnitName().hashCode());
        result = prime * result + ((getBuildUnitId() == null) ? 0 : getBuildUnitId().hashCode());
        result = prime * result + ((getProjectType() == null) ? 0 : getProjectType().hashCode());
        result = prime * result + ((getProjectProperties() == null) ? 0 : getProjectProperties().hashCode());
        result = prime * result + ((getBuildProperties() == null) ? 0 : getBuildProperties().hashCode());
        result = prime * result + ((getBuildLimit() == null) ? 0 : getBuildLimit().hashCode());
        result = prime * result + ((getPlanStartDateTime() == null) ? 0 : getPlanStartDateTime().hashCode());
        result = prime * result + ((getPlanEndDateTime() == null) ? 0 : getPlanEndDateTime().hashCode());
        result = prime * result + ((getMustStartDateTime() == null) ? 0 : getMustStartDateTime().hashCode());
        result = prime * result + ((getMustEndDateTime() == null) ? 0 : getMustEndDateTime().hashCode());
        result = prime * result + ((getPlanCenterDateTime() == null) ? 0 : getPlanCenterDateTime().hashCode());
        result = prime * result + ((getJobPrefix() == null) ? 0 : getJobPrefix().hashCode());
        result = prime * result + ((getJobSuffix() == null) ? 0 : getJobSuffix().hashCode());
        result = prime * result + ((getIncrement() == null) ? 0 : getIncrement().hashCode());
        result = prime * result + ((getProjectStatus() == null) ? 0 : getProjectStatus().hashCode());
        result = prime * result + ((getProjectGenre() == null) ? 0 : getProjectGenre().hashCode());
        result = prime * result + ((getBuildContent() == null) ? 0 : getBuildContent().hashCode());
        result = prime * result + ((getProjectCondition() == null) ? 0 : getProjectCondition().hashCode());
        result = prime * result + ((getProjectConditionDate() == null) ? 0 : getProjectConditionDate().hashCode());
        result = prime * result + ((getPspid() == null) ? 0 : getPspid().hashCode());
        result = prime * result + ((getPspnr() == null) ? 0 : getPspnr().hashCode());
        result = prime * result + ((getObjnr() == null) ? 0 : getObjnr().hashCode());
        result = prime * result + ((getPost1() == null) ? 0 : getPost1().hashCode());
        result = prime * result + ((getVerna() == null) ? 0 : getVerna().hashCode());
        result = prime * result + ((getVbukr() == null) ? 0 : getVbukr().hashCode());
        result = prime * result + ((getWerks() == null) ? 0 : getWerks().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dataId=").append(dataId);
        sb.append(", createUser=").append(createUser);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", status=").append(status);
        sb.append(", auditStatus=").append(auditStatus);
        sb.append(", companyCode=").append(companyCode);
        sb.append(", projectId=").append(projectId);
        sb.append(", formCode=").append(formCode);
        sb.append(", projectName=").append(projectName);
        sb.append(", projectCode=").append(projectCode);
        sb.append(", projectScale=").append(projectScale);
        sb.append(", investmentEstimation=").append(investmentEstimation);
        sb.append(", projectStructure=").append(projectStructure);
        sb.append(", projectStructureId=").append(projectStructureId);
        sb.append(", buildUnitName=").append(buildUnitName);
        sb.append(", buildUnitId=").append(buildUnitId);
        sb.append(", projectType=").append(projectType);
        sb.append(", projectProperties=").append(projectProperties);
        sb.append(", buildProperties=").append(buildProperties);
        sb.append(", buildLimit=").append(buildLimit);
        sb.append(", planStartDateTime=").append(planStartDateTime);
        sb.append(", planEndDateTime=").append(planEndDateTime);
        sb.append(", mustStartDateTime=").append(mustStartDateTime);
        sb.append(", mustEndDateTime=").append(mustEndDateTime);
        sb.append(", planCenterDateTime=").append(planCenterDateTime);
        sb.append(", jobPrefix=").append(jobPrefix);
        sb.append(", jobSuffix=").append(jobSuffix);
        sb.append(", increment=").append(increment);
        sb.append(", projectStatus=").append(projectStatus);
        sb.append(", projectGenre=").append(projectGenre);
        sb.append(", buildContent=").append(buildContent);
        sb.append(", projectCondition=").append(projectCondition);
        sb.append(", projectConditionDate=").append(projectConditionDate);
        sb.append(", pspid=").append(pspid);
        sb.append(", pspnr=").append(pspnr);
        sb.append(", objnr=").append(objnr);
        sb.append(", post1=").append(post1);
        sb.append(", verna=").append(verna);
        sb.append(", vbukr=").append(vbukr);
        sb.append(", werks=").append(werks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}