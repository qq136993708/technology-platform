package com.pcitc.base.stp.IntlProject;

import java.io.Serializable;

/**
 * intl_project_info
 * @author 
 */
public class IntlProjectInfo implements Serializable {
    /**
     * 项目ID
     */
    private String projectId;

    /**
     * 计划ID
     */
    private String plantId;

    /**
     * 申报ID
     */
    private String applyId;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目编码
     */
    private String projectCode;

    /**
     * 妞ゅ湱娲伴幓蹇氬牚
     */
    private String projectContent;

    /**
     * 项目状态（0未开始，1开始）
     */
    private Integer status;

    /**
     * 阶段（立项、审批、研发....）
     */
    private Integer projectStep;

    /**
     * 创建人
     */
    private String creater;

    /**
     * 创建人名字
     */
    private String createrName;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 最后编辑时间
     */
    private String updateTime;

    /**
     * 删除标识
     */
    private Integer delFlag;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 工作流开始状态(0未开始1已开始)
     */
    private Integer flowStartStatus;

    /**
     * 审批结果(0审批未完成，1审批完成)
     */
    private Integer flowEndStatus;

    /**
     * 当前审批状态（1审批通过，-1审批未通过，0审批中)
     */
    private Integer flowCurrentStatus;

    /**
     * 数据UUID
     */
    private String dataUuid;

    /**
     * 附件
     */
    private String appendFiles;

    /**
     * 数据版本
     */
    private String dataVersion;

    /**
     * 原项目ID（对于续约项目，新项目此值为空）
     */
    private String oldProjectId;

    /**
     * 项目开始日期
     */
    private String startDate;

    /**
     * 项目结束日期
     */
    private String endDate;

    /**
     * 中方签约单位
     */
    private String chineseContractCompany;

    /**
     * 外方签约单位
     */
    private String foreignContractCompany;

    /**
     * 濠㈣埖鐗楅弻鐔煎触閸粎绋婇柛妤佹磻缂嶅懐绮婚埀顒佺?
     */
    private String companyIntroduction;

    /**
     * 濡炪倕婀卞ú浼存儘閺冨倵鏁€濞村吋锚婵?
     */
    private String companyAdvantage;

    /**
     * 閸氬牅缍旈惄顔炬畱
     */
    private String projectTarget;

    /**
     * 閻梻鈹掗崘鍛啇
     */
    private String researchContent;

    /**
     * 妫板嫭婀￠幋鎰亯閸氼偂姹夐崨妯虹吙鐠侇厽鍎忛崘?
     */
    private String personStudy;

    /**
     * 閹存劖鐏夐惃鍕叀鐠囧棔楠囬弶鍐Ц閹?
     */
    private String resultStatus;

    /**
     * 协议审查状态
     */
    private Integer flowAgreementReviewStatus;

    /**
     * 专业技术审查状态
     */
    private Integer flowTechnologyReviewStatus;

    /**
     * 只是产权审查状态
     */
    private Integer flowKnowledgeReviewStatus;

    /**
     * 综合审查状态
     */
    private Integer flowComprehensiveReviewStatus;

    /**
     * 协议审查
     */
    private String flowAgreementReview;

    /**
     * 专业技术审查
     */
    private String flowTechnologyReview;

    /**
     * 知识产权审查
     */
    private String flowKnowledgeReview;

    /**
     * 综合审查
     */
    private String flowComprehensiveReview;

    private Integer externalCheck;

    private String externalRemark;

    private static final long serialVersionUID = 1L;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getPlantId() {
        return plantId;
    }

    public void setPlantId(String plantId) {
        this.plantId = plantId;
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
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

    public String getProjectContent() {
        return projectContent;
    }

    public void setProjectContent(String projectContent) {
        this.projectContent = projectContent;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getProjectStep() {
        return projectStep;
    }

    public void setProjectStep(Integer projectStep) {
        this.projectStep = projectStep;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getCreaterName() {
        return createrName;
    }

    public void setCreaterName(String createrName) {
        this.createrName = createrName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getFlowStartStatus() {
        return flowStartStatus;
    }

    public void setFlowStartStatus(Integer flowStartStatus) {
        this.flowStartStatus = flowStartStatus;
    }

    public Integer getFlowEndStatus() {
        return flowEndStatus;
    }

    public void setFlowEndStatus(Integer flowEndStatus) {
        this.flowEndStatus = flowEndStatus;
    }

    public Integer getFlowCurrentStatus() {
        return flowCurrentStatus;
    }

    public void setFlowCurrentStatus(Integer flowCurrentStatus) {
        this.flowCurrentStatus = flowCurrentStatus;
    }

    public String getDataUuid() {
        return dataUuid;
    }

    public void setDataUuid(String dataUuid) {
        this.dataUuid = dataUuid;
    }

    public String getAppendFiles() {
        return appendFiles;
    }

    public void setAppendFiles(String appendFiles) {
        this.appendFiles = appendFiles;
    }

    public String getDataVersion() {
        return dataVersion;
    }

    public void setDataVersion(String dataVersion) {
        this.dataVersion = dataVersion;
    }

    public String getOldProjectId() {
        return oldProjectId;
    }

    public void setOldProjectId(String oldProjectId) {
        this.oldProjectId = oldProjectId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getChineseContractCompany() {
        return chineseContractCompany;
    }

    public void setChineseContractCompany(String chineseContractCompany) {
        this.chineseContractCompany = chineseContractCompany;
    }

    public String getForeignContractCompany() {
        return foreignContractCompany;
    }

    public void setForeignContractCompany(String foreignContractCompany) {
        this.foreignContractCompany = foreignContractCompany;
    }

    public String getCompanyIntroduction() {
        return companyIntroduction;
    }

    public void setCompanyIntroduction(String companyIntroduction) {
        this.companyIntroduction = companyIntroduction;
    }

    public String getCompanyAdvantage() {
        return companyAdvantage;
    }

    public void setCompanyAdvantage(String companyAdvantage) {
        this.companyAdvantage = companyAdvantage;
    }

    public String getProjectTarget() {
        return projectTarget;
    }

    public void setProjectTarget(String projectTarget) {
        this.projectTarget = projectTarget;
    }

    public String getResearchContent() {
        return researchContent;
    }

    public void setResearchContent(String researchContent) {
        this.researchContent = researchContent;
    }

    public String getPersonStudy() {
        return personStudy;
    }

    public void setPersonStudy(String personStudy) {
        this.personStudy = personStudy;
    }

    public String getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus;
    }

    public Integer getFlowAgreementReviewStatus() {
        return flowAgreementReviewStatus;
    }

    public void setFlowAgreementReviewStatus(Integer flowAgreementReviewStatus) {
        this.flowAgreementReviewStatus = flowAgreementReviewStatus;
    }

    public Integer getFlowTechnologyReviewStatus() {
        return flowTechnologyReviewStatus;
    }

    public void setFlowTechnologyReviewStatus(Integer flowTechnologyReviewStatus) {
        this.flowTechnologyReviewStatus = flowTechnologyReviewStatus;
    }

    public Integer getFlowKnowledgeReviewStatus() {
        return flowKnowledgeReviewStatus;
    }

    public void setFlowKnowledgeReviewStatus(Integer flowKnowledgeReviewStatus) {
        this.flowKnowledgeReviewStatus = flowKnowledgeReviewStatus;
    }

    public Integer getFlowComprehensiveReviewStatus() {
        return flowComprehensiveReviewStatus;
    }

    public void setFlowComprehensiveReviewStatus(Integer flowComprehensiveReviewStatus) {
        this.flowComprehensiveReviewStatus = flowComprehensiveReviewStatus;
    }

    public String getFlowAgreementReview() {
        return flowAgreementReview;
    }

    public void setFlowAgreementReview(String flowAgreementReview) {
        this.flowAgreementReview = flowAgreementReview;
    }

    public String getFlowTechnologyReview() {
        return flowTechnologyReview;
    }

    public void setFlowTechnologyReview(String flowTechnologyReview) {
        this.flowTechnologyReview = flowTechnologyReview;
    }

    public String getFlowKnowledgeReview() {
        return flowKnowledgeReview;
    }

    public void setFlowKnowledgeReview(String flowKnowledgeReview) {
        this.flowKnowledgeReview = flowKnowledgeReview;
    }

    public String getFlowComprehensiveReview() {
        return flowComprehensiveReview;
    }

    public void setFlowComprehensiveReview(String flowComprehensiveReview) {
        this.flowComprehensiveReview = flowComprehensiveReview;
    }

    public Integer getExternalCheck() {
        return externalCheck;
    }

    public void setExternalCheck(Integer externalCheck) {
        this.externalCheck = externalCheck;
    }

    public String getExternalRemark() {
        return externalRemark;
    }

    public void setExternalRemark(String externalRemark) {
        this.externalRemark = externalRemark;
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
        IntlProjectInfo other = (IntlProjectInfo) that;
        return (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getPlantId() == null ? other.getPlantId() == null : this.getPlantId().equals(other.getPlantId()))
            && (this.getApplyId() == null ? other.getApplyId() == null : this.getApplyId().equals(other.getApplyId()))
            && (this.getProjectName() == null ? other.getProjectName() == null : this.getProjectName().equals(other.getProjectName()))
            && (this.getProjectCode() == null ? other.getProjectCode() == null : this.getProjectCode().equals(other.getProjectCode()))
            && (this.getProjectContent() == null ? other.getProjectContent() == null : this.getProjectContent().equals(other.getProjectContent()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getProjectStep() == null ? other.getProjectStep() == null : this.getProjectStep().equals(other.getProjectStep()))
            && (this.getCreater() == null ? other.getCreater() == null : this.getCreater().equals(other.getCreater()))
            && (this.getCreaterName() == null ? other.getCreaterName() == null : this.getCreaterName().equals(other.getCreaterName()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
            && (this.getFlowStartStatus() == null ? other.getFlowStartStatus() == null : this.getFlowStartStatus().equals(other.getFlowStartStatus()))
            && (this.getFlowEndStatus() == null ? other.getFlowEndStatus() == null : this.getFlowEndStatus().equals(other.getFlowEndStatus()))
            && (this.getFlowCurrentStatus() == null ? other.getFlowCurrentStatus() == null : this.getFlowCurrentStatus().equals(other.getFlowCurrentStatus()))
            && (this.getDataUuid() == null ? other.getDataUuid() == null : this.getDataUuid().equals(other.getDataUuid()))
            && (this.getAppendFiles() == null ? other.getAppendFiles() == null : this.getAppendFiles().equals(other.getAppendFiles()))
            && (this.getDataVersion() == null ? other.getDataVersion() == null : this.getDataVersion().equals(other.getDataVersion()))
            && (this.getOldProjectId() == null ? other.getOldProjectId() == null : this.getOldProjectId().equals(other.getOldProjectId()))
            && (this.getStartDate() == null ? other.getStartDate() == null : this.getStartDate().equals(other.getStartDate()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getChineseContractCompany() == null ? other.getChineseContractCompany() == null : this.getChineseContractCompany().equals(other.getChineseContractCompany()))
            && (this.getForeignContractCompany() == null ? other.getForeignContractCompany() == null : this.getForeignContractCompany().equals(other.getForeignContractCompany()))
            && (this.getCompanyIntroduction() == null ? other.getCompanyIntroduction() == null : this.getCompanyIntroduction().equals(other.getCompanyIntroduction()))
            && (this.getCompanyAdvantage() == null ? other.getCompanyAdvantage() == null : this.getCompanyAdvantage().equals(other.getCompanyAdvantage()))
            && (this.getProjectTarget() == null ? other.getProjectTarget() == null : this.getProjectTarget().equals(other.getProjectTarget()))
            && (this.getResearchContent() == null ? other.getResearchContent() == null : this.getResearchContent().equals(other.getResearchContent()))
            && (this.getPersonStudy() == null ? other.getPersonStudy() == null : this.getPersonStudy().equals(other.getPersonStudy()))
            && (this.getResultStatus() == null ? other.getResultStatus() == null : this.getResultStatus().equals(other.getResultStatus()))
            && (this.getFlowAgreementReviewStatus() == null ? other.getFlowAgreementReviewStatus() == null : this.getFlowAgreementReviewStatus().equals(other.getFlowAgreementReviewStatus()))
            && (this.getFlowTechnologyReviewStatus() == null ? other.getFlowTechnologyReviewStatus() == null : this.getFlowTechnologyReviewStatus().equals(other.getFlowTechnologyReviewStatus()))
            && (this.getFlowKnowledgeReviewStatus() == null ? other.getFlowKnowledgeReviewStatus() == null : this.getFlowKnowledgeReviewStatus().equals(other.getFlowKnowledgeReviewStatus()))
            && (this.getFlowComprehensiveReviewStatus() == null ? other.getFlowComprehensiveReviewStatus() == null : this.getFlowComprehensiveReviewStatus().equals(other.getFlowComprehensiveReviewStatus()))
            && (this.getFlowAgreementReview() == null ? other.getFlowAgreementReview() == null : this.getFlowAgreementReview().equals(other.getFlowAgreementReview()))
            && (this.getFlowTechnologyReview() == null ? other.getFlowTechnologyReview() == null : this.getFlowTechnologyReview().equals(other.getFlowTechnologyReview()))
            && (this.getFlowKnowledgeReview() == null ? other.getFlowKnowledgeReview() == null : this.getFlowKnowledgeReview().equals(other.getFlowKnowledgeReview()))
            && (this.getFlowComprehensiveReview() == null ? other.getFlowComprehensiveReview() == null : this.getFlowComprehensiveReview().equals(other.getFlowComprehensiveReview()))
            && (this.getExternalCheck() == null ? other.getExternalCheck() == null : this.getExternalCheck().equals(other.getExternalCheck()))
            && (this.getExternalRemark() == null ? other.getExternalRemark() == null : this.getExternalRemark().equals(other.getExternalRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getPlantId() == null) ? 0 : getPlantId().hashCode());
        result = prime * result + ((getApplyId() == null) ? 0 : getApplyId().hashCode());
        result = prime * result + ((getProjectName() == null) ? 0 : getProjectName().hashCode());
        result = prime * result + ((getProjectCode() == null) ? 0 : getProjectCode().hashCode());
        result = prime * result + ((getProjectContent() == null) ? 0 : getProjectContent().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getProjectStep() == null) ? 0 : getProjectStep().hashCode());
        result = prime * result + ((getCreater() == null) ? 0 : getCreater().hashCode());
        result = prime * result + ((getCreaterName() == null) ? 0 : getCreaterName().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getFlowStartStatus() == null) ? 0 : getFlowStartStatus().hashCode());
        result = prime * result + ((getFlowEndStatus() == null) ? 0 : getFlowEndStatus().hashCode());
        result = prime * result + ((getFlowCurrentStatus() == null) ? 0 : getFlowCurrentStatus().hashCode());
        result = prime * result + ((getDataUuid() == null) ? 0 : getDataUuid().hashCode());
        result = prime * result + ((getAppendFiles() == null) ? 0 : getAppendFiles().hashCode());
        result = prime * result + ((getDataVersion() == null) ? 0 : getDataVersion().hashCode());
        result = prime * result + ((getOldProjectId() == null) ? 0 : getOldProjectId().hashCode());
        result = prime * result + ((getStartDate() == null) ? 0 : getStartDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getChineseContractCompany() == null) ? 0 : getChineseContractCompany().hashCode());
        result = prime * result + ((getForeignContractCompany() == null) ? 0 : getForeignContractCompany().hashCode());
        result = prime * result + ((getCompanyIntroduction() == null) ? 0 : getCompanyIntroduction().hashCode());
        result = prime * result + ((getCompanyAdvantage() == null) ? 0 : getCompanyAdvantage().hashCode());
        result = prime * result + ((getProjectTarget() == null) ? 0 : getProjectTarget().hashCode());
        result = prime * result + ((getResearchContent() == null) ? 0 : getResearchContent().hashCode());
        result = prime * result + ((getPersonStudy() == null) ? 0 : getPersonStudy().hashCode());
        result = prime * result + ((getResultStatus() == null) ? 0 : getResultStatus().hashCode());
        result = prime * result + ((getFlowAgreementReviewStatus() == null) ? 0 : getFlowAgreementReviewStatus().hashCode());
        result = prime * result + ((getFlowTechnologyReviewStatus() == null) ? 0 : getFlowTechnologyReviewStatus().hashCode());
        result = prime * result + ((getFlowKnowledgeReviewStatus() == null) ? 0 : getFlowKnowledgeReviewStatus().hashCode());
        result = prime * result + ((getFlowComprehensiveReviewStatus() == null) ? 0 : getFlowComprehensiveReviewStatus().hashCode());
        result = prime * result + ((getFlowAgreementReview() == null) ? 0 : getFlowAgreementReview().hashCode());
        result = prime * result + ((getFlowTechnologyReview() == null) ? 0 : getFlowTechnologyReview().hashCode());
        result = prime * result + ((getFlowKnowledgeReview() == null) ? 0 : getFlowKnowledgeReview().hashCode());
        result = prime * result + ((getFlowComprehensiveReview() == null) ? 0 : getFlowComprehensiveReview().hashCode());
        result = prime * result + ((getExternalCheck() == null) ? 0 : getExternalCheck().hashCode());
        result = prime * result + ((getExternalRemark() == null) ? 0 : getExternalRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", projectId=").append(projectId);
        sb.append(", plantId=").append(plantId);
        sb.append(", applyId=").append(applyId);
        sb.append(", projectName=").append(projectName);
        sb.append(", projectCode=").append(projectCode);
        sb.append(", projectContent=").append(projectContent);
        sb.append(", status=").append(status);
        sb.append(", projectStep=").append(projectStep);
        sb.append(", creater=").append(creater);
        sb.append(", createrName=").append(createrName);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", remarks=").append(remarks);
        sb.append(", flowStartStatus=").append(flowStartStatus);
        sb.append(", flowEndStatus=").append(flowEndStatus);
        sb.append(", flowCurrentStatus=").append(flowCurrentStatus);
        sb.append(", dataUuid=").append(dataUuid);
        sb.append(", appendFiles=").append(appendFiles);
        sb.append(", dataVersion=").append(dataVersion);
        sb.append(", oldProjectId=").append(oldProjectId);
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", chineseContractCompany=").append(chineseContractCompany);
        sb.append(", foreignContractCompany=").append(foreignContractCompany);
        sb.append(", companyIntroduction=").append(companyIntroduction);
        sb.append(", companyAdvantage=").append(companyAdvantage);
        sb.append(", projectTarget=").append(projectTarget);
        sb.append(", researchContent=").append(researchContent);
        sb.append(", personStudy=").append(personStudy);
        sb.append(", resultStatus=").append(resultStatus);
        sb.append(", flowAgreementReviewStatus=").append(flowAgreementReviewStatus);
        sb.append(", flowTechnologyReviewStatus=").append(flowTechnologyReviewStatus);
        sb.append(", flowKnowledgeReviewStatus=").append(flowKnowledgeReviewStatus);
        sb.append(", flowComprehensiveReviewStatus=").append(flowComprehensiveReviewStatus);
        sb.append(", flowAgreementReview=").append(flowAgreementReview);
        sb.append(", flowTechnologyReview=").append(flowTechnologyReview);
        sb.append(", flowKnowledgeReview=").append(flowKnowledgeReview);
        sb.append(", flowComprehensiveReview=").append(flowComprehensiveReview);
        sb.append(", externalCheck=").append(externalCheck);
        sb.append(", externalRemark=").append(externalRemark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}