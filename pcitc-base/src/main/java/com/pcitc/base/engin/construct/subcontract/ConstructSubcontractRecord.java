package com.pcitc.base.engin.construct.subcontract;

import java.io.Serializable;

/**
 * construct_subcontract_record
 * @author 
 */
public class ConstructSubcontractRecord implements Serializable {
    /**
     * 主键ID
     */
    private String dataId;

    /**
     * 业务编码
     */
    private String formCode;

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
     * 项目名称
     */
    private String projectName;

    private String wbsId;

    /**
     * 单项工程
     */
    private String wbsName;

    /**
     * 单项工程编码
     */
    private String wbsCode;

    /**
     * 主合同名称
     */
    private String mainConstructName;

    /**
     * 主合同编码
     */
    private String mainConstructCode;

    /**
     * 开始日期
     */
    private String startDate;

    /**
     * 结束日期
     */
    private String endDate;

    /**
     * 工程分包发包人名称
     */
    private String contructPerson;

    /**
     * 主合同工期
     */
    private String timeLimitMain;

    /**
     * 主合同金额
     */
    private Long mainAmount;

    /**
     * 联系人电话
     */
    private String contactPhone;

    /**
     * 联系人名称
     */
    private String contactName;

    /**
     * 建设单位
     */
    private String buildUnit;

    /**
     * 承包商单位编码
     */
    private String contractorCode;

    /**
     * 承包商名称
     */
    private String contractor;

    /**
     * 分包合同名称
     */
    private String subContructName;

    /**
     * 分包合同编码
     */
    private String subContructCode;

    /**
     * 分包工作性质
     */
    private String subJobNature;

    /**
     * 分包人名称
     */
    private String subContructPerson;

    /**
     * 分包合同金额
     */
    private Long subContructAmount;

    /**
     * 分包合同类型
     */
    private String subContructType;

    /**
     * 分包合同开始日期
     */
    private String subStartDate;

    /**
     * 分包合同结束日期
     */
    private String subEndDate;

    /**
     * 分包合同工期
     */
    private String subTimeLimit;

    /**
     * 分包合同签订日期
     */
    private String subSignTime;

    /**
     * 资质专业及等级
     */
    private String qualificationLevel;

    /**
     * 分包单位资质备案
     */
    private String subQualificationRecord;

    /**
     * 已签署分包合同
     */
    private String subContructSigned;

    /**
     * 分包合同工作内容
     */
    private String subWorkContent;

    /**
     * 分包合同质量要求
     */
    private String subQualityRequire;

    /**
     * 分包合同其他关键条款
     */
    private String subOtherTerms;

    /**
     * 备注
     */
    private String remark;

    /**
     * 附件id
     */
    private String attachId;

    private static final long serialVersionUID = 1L;

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getFormCode() {
        return formCode;
    }

    public void setFormCode(String formCode) {
        this.formCode = formCode;
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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getWbsId() {
        return wbsId;
    }

    public void setWbsId(String wbsId) {
        this.wbsId = wbsId;
    }

    public String getWbsName() {
        return wbsName;
    }

    public void setWbsName(String wbsName) {
        this.wbsName = wbsName;
    }

    public String getWbsCode() {
        return wbsCode;
    }

    public void setWbsCode(String wbsCode) {
        this.wbsCode = wbsCode;
    }

    public String getMainConstructName() {
        return mainConstructName;
    }

    public void setMainConstructName(String mainConstructName) {
        this.mainConstructName = mainConstructName;
    }

    public String getMainConstructCode() {
        return mainConstructCode;
    }

    public void setMainConstructCode(String mainConstructCode) {
        this.mainConstructCode = mainConstructCode;
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

    public String getContructPerson() {
        return contructPerson;
    }

    public void setContructPerson(String contructPerson) {
        this.contructPerson = contructPerson;
    }

    public String getTimeLimitMain() {
        return timeLimitMain;
    }

    public void setTimeLimitMain(String timeLimitMain) {
        this.timeLimitMain = timeLimitMain;
    }

    public Long getMainAmount() {
        return mainAmount;
    }

    public void setMainAmount(Long mainAmount) {
        this.mainAmount = mainAmount;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getBuildUnit() {
        return buildUnit;
    }

    public void setBuildUnit(String buildUnit) {
        this.buildUnit = buildUnit;
    }

    public String getContractorCode() {
        return contractorCode;
    }

    public void setContractorCode(String contractorCode) {
        this.contractorCode = contractorCode;
    }

    public String getContractor() {
        return contractor;
    }

    public void setContractor(String contractor) {
        this.contractor = contractor;
    }

    public String getSubContructName() {
        return subContructName;
    }

    public void setSubContructName(String subContructName) {
        this.subContructName = subContructName;
    }

    public String getSubContructCode() {
        return subContructCode;
    }

    public void setSubContructCode(String subContructCode) {
        this.subContructCode = subContructCode;
    }

    public String getSubJobNature() {
        return subJobNature;
    }

    public void setSubJobNature(String subJobNature) {
        this.subJobNature = subJobNature;
    }

    public String getSubContructPerson() {
        return subContructPerson;
    }

    public void setSubContructPerson(String subContructPerson) {
        this.subContructPerson = subContructPerson;
    }

    public Long getSubContructAmount() {
        return subContructAmount;
    }

    public void setSubContructAmount(Long subContructAmount) {
        this.subContructAmount = subContructAmount;
    }

    public String getSubContructType() {
        return subContructType;
    }

    public void setSubContructType(String subContructType) {
        this.subContructType = subContructType;
    }

    public String getSubStartDate() {
        return subStartDate;
    }

    public void setSubStartDate(String subStartDate) {
        this.subStartDate = subStartDate;
    }

    public String getSubEndDate() {
        return subEndDate;
    }

    public void setSubEndDate(String subEndDate) {
        this.subEndDate = subEndDate;
    }

    public String getSubTimeLimit() {
        return subTimeLimit;
    }

    public void setSubTimeLimit(String subTimeLimit) {
        this.subTimeLimit = subTimeLimit;
    }

    public String getSubSignTime() {
        return subSignTime;
    }

    public void setSubSignTime(String subSignTime) {
        this.subSignTime = subSignTime;
    }

    public String getQualificationLevel() {
        return qualificationLevel;
    }

    public void setQualificationLevel(String qualificationLevel) {
        this.qualificationLevel = qualificationLevel;
    }

    public String getSubQualificationRecord() {
        return subQualificationRecord;
    }

    public void setSubQualificationRecord(String subQualificationRecord) {
        this.subQualificationRecord = subQualificationRecord;
    }

    public String getSubContructSigned() {
        return subContructSigned;
    }

    public void setSubContructSigned(String subContructSigned) {
        this.subContructSigned = subContructSigned;
    }

    public String getSubWorkContent() {
        return subWorkContent;
    }

    public void setSubWorkContent(String subWorkContent) {
        this.subWorkContent = subWorkContent;
    }

    public String getSubQualityRequire() {
        return subQualityRequire;
    }

    public void setSubQualityRequire(String subQualityRequire) {
        this.subQualityRequire = subQualityRequire;
    }

    public String getSubOtherTerms() {
        return subOtherTerms;
    }

    public void setSubOtherTerms(String subOtherTerms) {
        this.subOtherTerms = subOtherTerms;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAttachId() {
        return attachId;
    }

    public void setAttachId(String attachId) {
        this.attachId = attachId;
    }
}