package com.pcitc.base.engin.quality.weld.vo;

import java.io.Serializable;

/**
 * quality_welder
 * @author 
 */
public class WelderVo implements Serializable {
    /**
     * 主键
     */
    private String dataId;

    /**
     * 业务数据编码
     */
    private String dataCode;

    /**
     * 系统名称
     */
    private String sysFlag;

    /**
     * 业务数据排序字段
     */
    private String dataOrder;

    /**
     * 数据状态
     */
    private String status;

    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 创建人ID
     */
    private String createUser;

    /**
     * 创建人名称
     */
    private String createUserName;

    /**
     * 修改时间
     */
    private String updateDate;

    /**
     * 修改人ID
     */
    private String updateUser;

    /**
     * 修改人名称
     */
    private String updateUserName;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目ID
     */
    private String projectId;

    /**
     * 项目编码
     */
    private String projectCode;

    /**
     * 审批状态
     */
    private String auditSts;

    /**
     * 组织机构代码
     */
    private String unitCode;

    /**
     * 单位名称
     */
    private String unitName;

    /**
     * 单位ID
     */
    private String unitId;

    /**
     * 1-表示已删除，2-表示未删除
     */
    private String delFlag;

    /**
     * 工程名称
     */
    private String enginName;

    /**
     * 工程编码
     */
    private String enginCode;

    /**
     * 工程ID
     */
    private String enginId;

    /**
     * 机构编码
     */
    private String companyCode;

    /**
     * 焊工编号
     */
    private String welderCode;

    /**
     * 焊工姓名
     */
    private String welderName;

    /**
     * 身份证号
     */
    private String idCardNo;

    /**
     * 考核项目
     */
    private String cice;

    /**
     * 1、承建单位检查（SP_EXAMINE）
2、监理单位检查（SUPERVIS_EXAMINE）
3、项目分部检查（PROJECT_EXAMINE）
4、质量监督管理站检查（QS_EXAMINE）

     */
    private String checkUnit;

    /**
     * 施工单位名称
     */
    private String buildUnitName;

    /**
     * 施工单位编码
     */
    private String buildUnitCode;

    /**
     * 施工单位ID
     */
    private String buildUnitId;

    /**
     * 备注
     */
    private String remarks;

    /**
     * （未考试，考试通过，考试不通过，补考通过，补考不通过
     */
    private String welderExamStatus;

    /**
     * 照片连接
     */
    private String photoLink;

    /**
     * 人员状态
     */
    private String welderStatus;

    /**
     * 焊工工种
     */
    private String workType;

    /**
     * 证书有效期
     */
    private String validityPeriod;

    /**
     * 首次外观
     */
    private String oneFacade;

    /**
     * 首次RT
     */
    private String oneRt;

    /**
     * 首次考试日期
     */
    private String oneExaminationDate;

    /**
     * 二次考试日期
     */
    private String twoExaminationDate;

    /**
     * 二次RT
     */
    private String twoRt;

    /**
     * 二次外观
     */
    private String twoFacade;

    /**
     * 专业
     */
    private String specialty;

    /**
     * 焊工证编号
     */
    private String welderCertificateCode;

    /**
     * 焊工证有效期
     */
    private String welderCertificatePeriod;

    private String passDate;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄
     */
    private String age;

    /**
     * 考试合格项目
     */
    private String examinationPassProject;

    /**
     * 入场证编号
     */
    private String entryPassCode;

    /**
     * 准入证编号
     */
    private String allowPassCode;

    /**
     * 提交状态
     */
    private String workflowState;

    /**
     * 是否在职
     */
    private String postStatus;

    /**
     * 考试类型（增项、正常）
     */
    private String examinationType;

    private static final long serialVersionUID = 1L;

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getDataCode() {
        return dataCode;
    }

    public void setDataCode(String dataCode) {
        this.dataCode = dataCode;
    }

    public String getSysFlag() {
        return sysFlag;
    }

    public void setSysFlag(String sysFlag) {
        this.sysFlag = sysFlag;
    }

    public String getDataOrder() {
        return dataOrder;
    }

    public void setDataOrder(String dataOrder) {
        this.dataOrder = dataOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getAuditSts() {
        return auditSts;
    }

    public void setAuditSts(String auditSts) {
        this.auditSts = auditSts;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getEnginName() {
        return enginName;
    }

    public void setEnginName(String enginName) {
        this.enginName = enginName;
    }

    public String getEnginCode() {
        return enginCode;
    }

    public void setEnginCode(String enginCode) {
        this.enginCode = enginCode;
    }

    public String getEnginId() {
        return enginId;
    }

    public void setEnginId(String enginId) {
        this.enginId = enginId;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getWelderCode() {
        return welderCode;
    }

    public void setWelderCode(String welderCode) {
        this.welderCode = welderCode;
    }

    public String getWelderName() {
        return welderName;
    }

    public void setWelderName(String welderName) {
        this.welderName = welderName;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getCice() {
        return cice;
    }

    public void setCice(String cice) {
        this.cice = cice;
    }

    public String getCheckUnit() {
        return checkUnit;
    }

    public void setCheckUnit(String checkUnit) {
        this.checkUnit = checkUnit;
    }

    public String getBuildUnitName() {
        return buildUnitName;
    }

    public void setBuildUnitName(String buildUnitName) {
        this.buildUnitName = buildUnitName;
    }

    public String getBuildUnitCode() {
        return buildUnitCode;
    }

    public void setBuildUnitCode(String buildUnitCode) {
        this.buildUnitCode = buildUnitCode;
    }

    public String getBuildUnitId() {
        return buildUnitId;
    }

    public void setBuildUnitId(String buildUnitId) {
        this.buildUnitId = buildUnitId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getWelderExamStatus() {
        return welderExamStatus;
    }

    public void setWelderExamStatus(String welderExamStatus) {
        this.welderExamStatus = welderExamStatus;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    public String getWelderStatus() {
        return welderStatus;
    }

    public void setWelderStatus(String welderStatus) {
        this.welderStatus = welderStatus;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getValidityPeriod() {
        return validityPeriod;
    }

    public void setValidityPeriod(String validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

    public String getOneFacade() {
        return oneFacade;
    }

    public void setOneFacade(String oneFacade) {
        this.oneFacade = oneFacade;
    }

    public String getOneRt() {
        return oneRt;
    }

    public void setOneRt(String oneRt) {
        this.oneRt = oneRt;
    }

    public String getOneExaminationDate() {
        return oneExaminationDate;
    }

    public void setOneExaminationDate(String oneExaminationDate) {
        this.oneExaminationDate = oneExaminationDate;
    }

    public String getTwoExaminationDate() {
        return twoExaminationDate;
    }

    public void setTwoExaminationDate(String twoExaminationDate) {
        this.twoExaminationDate = twoExaminationDate;
    }

    public String getTwoRt() {
        return twoRt;
    }

    public void setTwoRt(String twoRt) {
        this.twoRt = twoRt;
    }

    public String getTwoFacade() {
        return twoFacade;
    }

    public void setTwoFacade(String twoFacade) {
        this.twoFacade = twoFacade;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getWelderCertificateCode() {
        return welderCertificateCode;
    }

    public void setWelderCertificateCode(String welderCertificateCode) {
        this.welderCertificateCode = welderCertificateCode;
    }

    public String getWelderCertificatePeriod() {
        return welderCertificatePeriod;
    }

    public void setWelderCertificatePeriod(String welderCertificatePeriod) {
        this.welderCertificatePeriod = welderCertificatePeriod;
    }

    public String getPassDate() {
        return passDate;
    }

    public void setPassDate(String passDate) {
        this.passDate = passDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getExaminationPassProject() {
        return examinationPassProject;
    }

    public void setExaminationPassProject(String examinationPassProject) {
        this.examinationPassProject = examinationPassProject;
    }

    public String getEntryPassCode() {
        return entryPassCode;
    }

    public void setEntryPassCode(String entryPassCode) {
        this.entryPassCode = entryPassCode;
    }

    public String getAllowPassCode() {
        return allowPassCode;
    }

    public void setAllowPassCode(String allowPassCode) {
        this.allowPassCode = allowPassCode;
    }

    public String getWorkflowState() {
        return workflowState;
    }

    public void setWorkflowState(String workflowState) {
        this.workflowState = workflowState;
    }

    public String getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(String postStatus) {
        this.postStatus = postStatus;
    }

    public String getExaminationType() {
        return examinationType;
    }

    public void setExaminationType(String examinationType) {
        this.examinationType = examinationType;
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
        WelderVo other = (WelderVo) that;
        return (this.getDataId() == null ? other.getDataId() == null : this.getDataId().equals(other.getDataId()))
            && (this.getDataCode() == null ? other.getDataCode() == null : this.getDataCode().equals(other.getDataCode()))
            && (this.getSysFlag() == null ? other.getSysFlag() == null : this.getSysFlag().equals(other.getSysFlag()))
            && (this.getDataOrder() == null ? other.getDataOrder() == null : this.getDataOrder().equals(other.getDataOrder()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getCreateUserName() == null ? other.getCreateUserName() == null : this.getCreateUserName().equals(other.getCreateUserName()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getUpdateUserName() == null ? other.getUpdateUserName() == null : this.getUpdateUserName().equals(other.getUpdateUserName()))
            && (this.getProjectName() == null ? other.getProjectName() == null : this.getProjectName().equals(other.getProjectName()))
            && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getProjectCode() == null ? other.getProjectCode() == null : this.getProjectCode().equals(other.getProjectCode()))
            && (this.getAuditSts() == null ? other.getAuditSts() == null : this.getAuditSts().equals(other.getAuditSts()))
            && (this.getUnitCode() == null ? other.getUnitCode() == null : this.getUnitCode().equals(other.getUnitCode()))
            && (this.getUnitName() == null ? other.getUnitName() == null : this.getUnitName().equals(other.getUnitName()))
            && (this.getUnitId() == null ? other.getUnitId() == null : this.getUnitId().equals(other.getUnitId()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()))
            && (this.getEnginName() == null ? other.getEnginName() == null : this.getEnginName().equals(other.getEnginName()))
            && (this.getEnginCode() == null ? other.getEnginCode() == null : this.getEnginCode().equals(other.getEnginCode()))
            && (this.getEnginId() == null ? other.getEnginId() == null : this.getEnginId().equals(other.getEnginId()))
            && (this.getCompanyCode() == null ? other.getCompanyCode() == null : this.getCompanyCode().equals(other.getCompanyCode()))
            && (this.getWelderCode() == null ? other.getWelderCode() == null : this.getWelderCode().equals(other.getWelderCode()))
            && (this.getWelderName() == null ? other.getWelderName() == null : this.getWelderName().equals(other.getWelderName()))
            && (this.getIdCardNo() == null ? other.getIdCardNo() == null : this.getIdCardNo().equals(other.getIdCardNo()))
            && (this.getCice() == null ? other.getCice() == null : this.getCice().equals(other.getCice()))
            && (this.getCheckUnit() == null ? other.getCheckUnit() == null : this.getCheckUnit().equals(other.getCheckUnit()))
            && (this.getBuildUnitName() == null ? other.getBuildUnitName() == null : this.getBuildUnitName().equals(other.getBuildUnitName()))
            && (this.getBuildUnitCode() == null ? other.getBuildUnitCode() == null : this.getBuildUnitCode().equals(other.getBuildUnitCode()))
            && (this.getBuildUnitId() == null ? other.getBuildUnitId() == null : this.getBuildUnitId().equals(other.getBuildUnitId()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
            && (this.getWelderExamStatus() == null ? other.getWelderExamStatus() == null : this.getWelderExamStatus().equals(other.getWelderExamStatus()))
            && (this.getPhotoLink() == null ? other.getPhotoLink() == null : this.getPhotoLink().equals(other.getPhotoLink()))
            && (this.getWelderStatus() == null ? other.getWelderStatus() == null : this.getWelderStatus().equals(other.getWelderStatus()))
            && (this.getWorkType() == null ? other.getWorkType() == null : this.getWorkType().equals(other.getWorkType()))
            && (this.getValidityPeriod() == null ? other.getValidityPeriod() == null : this.getValidityPeriod().equals(other.getValidityPeriod()))
            && (this.getOneFacade() == null ? other.getOneFacade() == null : this.getOneFacade().equals(other.getOneFacade()))
            && (this.getOneRt() == null ? other.getOneRt() == null : this.getOneRt().equals(other.getOneRt()))
            && (this.getOneExaminationDate() == null ? other.getOneExaminationDate() == null : this.getOneExaminationDate().equals(other.getOneExaminationDate()))
            && (this.getTwoExaminationDate() == null ? other.getTwoExaminationDate() == null : this.getTwoExaminationDate().equals(other.getTwoExaminationDate()))
            && (this.getTwoRt() == null ? other.getTwoRt() == null : this.getTwoRt().equals(other.getTwoRt()))
            && (this.getTwoFacade() == null ? other.getTwoFacade() == null : this.getTwoFacade().equals(other.getTwoFacade()))
            && (this.getSpecialty() == null ? other.getSpecialty() == null : this.getSpecialty().equals(other.getSpecialty()))
            && (this.getWelderCertificateCode() == null ? other.getWelderCertificateCode() == null : this.getWelderCertificateCode().equals(other.getWelderCertificateCode()))
            && (this.getWelderCertificatePeriod() == null ? other.getWelderCertificatePeriod() == null : this.getWelderCertificatePeriod().equals(other.getWelderCertificatePeriod()))
            && (this.getPassDate() == null ? other.getPassDate() == null : this.getPassDate().equals(other.getPassDate()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
            && (this.getExaminationPassProject() == null ? other.getExaminationPassProject() == null : this.getExaminationPassProject().equals(other.getExaminationPassProject()))
            && (this.getEntryPassCode() == null ? other.getEntryPassCode() == null : this.getEntryPassCode().equals(other.getEntryPassCode()))
            && (this.getAllowPassCode() == null ? other.getAllowPassCode() == null : this.getAllowPassCode().equals(other.getAllowPassCode()))
            && (this.getWorkflowState() == null ? other.getWorkflowState() == null : this.getWorkflowState().equals(other.getWorkflowState()))
            && (this.getPostStatus() == null ? other.getPostStatus() == null : this.getPostStatus().equals(other.getPostStatus()))
            && (this.getExaminationType() == null ? other.getExaminationType() == null : this.getExaminationType().equals(other.getExaminationType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataId() == null) ? 0 : getDataId().hashCode());
        result = prime * result + ((getDataCode() == null) ? 0 : getDataCode().hashCode());
        result = prime * result + ((getSysFlag() == null) ? 0 : getSysFlag().hashCode());
        result = prime * result + ((getDataOrder() == null) ? 0 : getDataOrder().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateUserName() == null) ? 0 : getCreateUserName().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateUserName() == null) ? 0 : getUpdateUserName().hashCode());
        result = prime * result + ((getProjectName() == null) ? 0 : getProjectName().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getProjectCode() == null) ? 0 : getProjectCode().hashCode());
        result = prime * result + ((getAuditSts() == null) ? 0 : getAuditSts().hashCode());
        result = prime * result + ((getUnitCode() == null) ? 0 : getUnitCode().hashCode());
        result = prime * result + ((getUnitName() == null) ? 0 : getUnitName().hashCode());
        result = prime * result + ((getUnitId() == null) ? 0 : getUnitId().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        result = prime * result + ((getEnginName() == null) ? 0 : getEnginName().hashCode());
        result = prime * result + ((getEnginCode() == null) ? 0 : getEnginCode().hashCode());
        result = prime * result + ((getEnginId() == null) ? 0 : getEnginId().hashCode());
        result = prime * result + ((getCompanyCode() == null) ? 0 : getCompanyCode().hashCode());
        result = prime * result + ((getWelderCode() == null) ? 0 : getWelderCode().hashCode());
        result = prime * result + ((getWelderName() == null) ? 0 : getWelderName().hashCode());
        result = prime * result + ((getIdCardNo() == null) ? 0 : getIdCardNo().hashCode());
        result = prime * result + ((getCice() == null) ? 0 : getCice().hashCode());
        result = prime * result + ((getCheckUnit() == null) ? 0 : getCheckUnit().hashCode());
        result = prime * result + ((getBuildUnitName() == null) ? 0 : getBuildUnitName().hashCode());
        result = prime * result + ((getBuildUnitCode() == null) ? 0 : getBuildUnitCode().hashCode());
        result = prime * result + ((getBuildUnitId() == null) ? 0 : getBuildUnitId().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getWelderExamStatus() == null) ? 0 : getWelderExamStatus().hashCode());
        result = prime * result + ((getPhotoLink() == null) ? 0 : getPhotoLink().hashCode());
        result = prime * result + ((getWelderStatus() == null) ? 0 : getWelderStatus().hashCode());
        result = prime * result + ((getWorkType() == null) ? 0 : getWorkType().hashCode());
        result = prime * result + ((getValidityPeriod() == null) ? 0 : getValidityPeriod().hashCode());
        result = prime * result + ((getOneFacade() == null) ? 0 : getOneFacade().hashCode());
        result = prime * result + ((getOneRt() == null) ? 0 : getOneRt().hashCode());
        result = prime * result + ((getOneExaminationDate() == null) ? 0 : getOneExaminationDate().hashCode());
        result = prime * result + ((getTwoExaminationDate() == null) ? 0 : getTwoExaminationDate().hashCode());
        result = prime * result + ((getTwoRt() == null) ? 0 : getTwoRt().hashCode());
        result = prime * result + ((getTwoFacade() == null) ? 0 : getTwoFacade().hashCode());
        result = prime * result + ((getSpecialty() == null) ? 0 : getSpecialty().hashCode());
        result = prime * result + ((getWelderCertificateCode() == null) ? 0 : getWelderCertificateCode().hashCode());
        result = prime * result + ((getWelderCertificatePeriod() == null) ? 0 : getWelderCertificatePeriod().hashCode());
        result = prime * result + ((getPassDate() == null) ? 0 : getPassDate().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getExaminationPassProject() == null) ? 0 : getExaminationPassProject().hashCode());
        result = prime * result + ((getEntryPassCode() == null) ? 0 : getEntryPassCode().hashCode());
        result = prime * result + ((getAllowPassCode() == null) ? 0 : getAllowPassCode().hashCode());
        result = prime * result + ((getWorkflowState() == null) ? 0 : getWorkflowState().hashCode());
        result = prime * result + ((getPostStatus() == null) ? 0 : getPostStatus().hashCode());
        result = prime * result + ((getExaminationType() == null) ? 0 : getExaminationType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dataId=").append(dataId);
        sb.append(", dataCode=").append(dataCode);
        sb.append(", sysFlag=").append(sysFlag);
        sb.append(", dataOrder=").append(dataOrder);
        sb.append(", status=").append(status);
        sb.append(", createDate=").append(createDate);
        sb.append(", createUser=").append(createUser);
        sb.append(", createUserName=").append(createUserName);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateUserName=").append(updateUserName);
        sb.append(", projectName=").append(projectName);
        sb.append(", projectId=").append(projectId);
        sb.append(", projectCode=").append(projectCode);
        sb.append(", auditSts=").append(auditSts);
        sb.append(", unitCode=").append(unitCode);
        sb.append(", unitName=").append(unitName);
        sb.append(", unitId=").append(unitId);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", enginName=").append(enginName);
        sb.append(", enginCode=").append(enginCode);
        sb.append(", enginId=").append(enginId);
        sb.append(", companyCode=").append(companyCode);
        sb.append(", welderCode=").append(welderCode);
        sb.append(", welderName=").append(welderName);
        sb.append(", idCardNo=").append(idCardNo);
        sb.append(", cice=").append(cice);
        sb.append(", checkUnit=").append(checkUnit);
        sb.append(", buildUnitName=").append(buildUnitName);
        sb.append(", buildUnitCode=").append(buildUnitCode);
        sb.append(", buildUnitId=").append(buildUnitId);
        sb.append(", remarks=").append(remarks);
        sb.append(", welderExamStatus=").append(welderExamStatus);
        sb.append(", photoLink=").append(photoLink);
        sb.append(", welderStatus=").append(welderStatus);
        sb.append(", workType=").append(workType);
        sb.append(", validityPeriod=").append(validityPeriod);
        sb.append(", oneFacade=").append(oneFacade);
        sb.append(", oneRt=").append(oneRt);
        sb.append(", oneExaminationDate=").append(oneExaminationDate);
        sb.append(", twoExaminationDate=").append(twoExaminationDate);
        sb.append(", twoRt=").append(twoRt);
        sb.append(", twoFacade=").append(twoFacade);
        sb.append(", specialty=").append(specialty);
        sb.append(", welderCertificateCode=").append(welderCertificateCode);
        sb.append(", welderCertificatePeriod=").append(welderCertificatePeriod);
        sb.append(", passDate=").append(passDate);
        sb.append(", sex=").append(sex);
        sb.append(", age=").append(age);
        sb.append(", examinationPassProject=").append(examinationPassProject);
        sb.append(", entryPassCode=").append(entryPassCode);
        sb.append(", allowPassCode=").append(allowPassCode);
        sb.append(", workflowState=").append(workflowState);
        sb.append(", postStatus=").append(postStatus);
        sb.append(", examinationType=").append(examinationType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}