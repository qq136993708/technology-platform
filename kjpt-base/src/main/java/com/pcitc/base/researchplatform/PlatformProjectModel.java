package com.pcitc.base.researchplatform;

import com.pcitc.base.common.RecordModel;

import java.io.Serializable;

/**
 * <p>科研平台-科研项目</p>
 * <p>Table: kypt_project - 科研平台-科研项目</p>
 * @author ty
 */
public class PlatformProjectModel extends RecordModel implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 数据主键
     */
    private String id;
    /**
     * 对应的平台ID
     */
    private String platformId="";
    /**
     * 系统中的项目表的主键ID
     */
    private String baseId="";
    /**
     * 项目名称
     */
    private String projectName="";
    /**
     * 专业类型
     */
    private String majorType="";
    /**
     * 负责单位
     */
    private String dutyInstitutions="";
    private String dutyInstitutionsText="";
    /**
     * 立项年度
     */
    private String approvalYear="";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getBaseId() {
        return baseId;
    }

    public void setBaseId(String baseId) {
        this.baseId = baseId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getMajorType() {
        return majorType;
    }

    public void setMajorType(String majorType) {
        this.majorType = majorType;
    }

    public String getDutyInstitutions() {
        return dutyInstitutions;
    }

    public void setDutyInstitutions(String dutyInstitutions) {
        this.dutyInstitutions = dutyInstitutions;
    }

    public String getApprovalYear() {
        return approvalYear;
    }

    public void setApprovalYear(String approvalYear) {
        this.approvalYear = approvalYear;
    }

    public String getDutyInstitutionsText() {
        return dutyInstitutionsText;
    }

    public void setDutyInstitutionsText(String dutyInstitutionsText) {
        this.dutyInstitutionsText = dutyInstitutionsText;
    }
}
