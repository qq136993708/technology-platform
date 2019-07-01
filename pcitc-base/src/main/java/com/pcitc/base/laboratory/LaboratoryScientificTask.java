package com.pcitc.base.laboratory;

import com.pcitc.base.common.DataEntity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * <p>实体类</p>
 * <p>Table: laboratory_scientific_task - 实验室-重大科研任务</p>
 *
 * @since 2019-07-01 09:13:29
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LaboratoryScientificTask extends DataEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * data_id -
     */
    private String dataId;

    /**
     * base_id -
     */
    private String baseId;

    /**
     * project_num - 项目号
     */
    private String projectNum;

    /**
     * project_from - 项目来源
     */
    private String projectFrom;

    /**
     * project_name - 项目名称
     */
    private String projectName;

    /**
     * duty_people - 负责人
     */
    private String dutyPeople;

    /**
     * project_year - 立项年度
     */
    private String projectYear;

    /**
     * project_cycle - 研究周期
     */
    private String projectCycle;

    /**
     * project_funds - 经费（万元）
     */
    private String projectFunds;

    /**
     * topics - 项目/课题
     */
    private String topics;

    /**
     * completion_desc - 完成情况
     */
    private String completionDesc;

    /**
     * remarks - 备注
     */
    private String remarks;

    /**
     * sys_flag -
     */
    private String sysFlag;

    /**
     * data_order - 排序
     */
    private Integer dataOrder;

    /**
     * del_flag - 状态
     */
    private Integer delFlag;

    /**
     * create_date - 创建时间
     */
    private String createDate;

    /**
     * create_user - 创建人id
     */
    private String createUser;

    /**
     * create_user_disp - 创建人姓名
     */
    private String createUserDisp;

    /**
     * modify_date - 修改时间
     */
    private String modifyDate;

    /**
     * modify_user - 修改人id
     */
    private String modifyUser;

    /**
     * modify_user_disp - 修改人姓名
     */
    private String modifyUserDisp;

    /**
     * status - 状态
     */
    private String status;

    /**
     * audit_status - 审批状态
     */
    private String auditStatus;

    /**
     * update_user - 修改人
     */
    private String updateUser;

    /**
     * update_date - 修改时间
     */
    private String updateDate;

    /**
     * bak1 -
     */
    private String bak1;

    /**
     * bak2 -
     */
    private String bak2;

    /**
     * bak3 -
     */
    private String bak3;

    /**
     * bak4 -
     */
    private String bak4;

    public String getDataId() {
        return this.dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getBaseId() {
        return this.baseId;
    }

    public void setBaseId(String baseId) {
        this.baseId = baseId;
    }

    public String getProjectNum() {
        return this.projectNum;
    }

    public void setProjectNum(String projectNum) {
        this.projectNum = projectNum;
    }

    public String getProjectFrom() {
        return this.projectFrom;
    }

    public void setProjectFrom(String projectFrom) {
        this.projectFrom = projectFrom;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDutyPeople() {
        return this.dutyPeople;
    }

    public void setDutyPeople(String dutyPeople) {
        this.dutyPeople = dutyPeople;
    }

    public String getProjectYear() {
        return this.projectYear;
    }

    public void setProjectYear(String projectYear) {
        this.projectYear = projectYear;
    }

    public String getProjectCycle() {
        return this.projectCycle;
    }

    public void setProjectCycle(String projectCycle) {
        this.projectCycle = projectCycle;
    }

    public String getProjectFunds() {
        return this.projectFunds;
    }

    public void setProjectFunds(String projectFunds) {
        this.projectFunds = projectFunds;
    }

    public String getTopics() {
        return this.topics;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }

    public String getCompletionDesc() {
        return this.completionDesc;
    }

    public void setCompletionDesc(String completionDesc) {
        this.completionDesc = completionDesc;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSysFlag() {
        return this.sysFlag;
    }

    public void setSysFlag(String sysFlag) {
        this.sysFlag = sysFlag;
    }

    public Integer getDataOrder() {
        return this.dataOrder;
    }

    public void setDataOrder(Integer dataOrder) {
        this.dataOrder = dataOrder;
    }

    public Integer getDelFlag() {
        return this.delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return this.createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateUserDisp() {
        return this.createUserDisp;
    }

    public void setCreateUserDisp(String createUserDisp) {
        this.createUserDisp = createUserDisp;
    }

    public String getModifyDate() {
        return this.modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getModifyUser() {
        return this.modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public String getModifyUserDisp() {
        return this.modifyUserDisp;
    }

    public void setModifyUserDisp(String modifyUserDisp) {
        this.modifyUserDisp = modifyUserDisp;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAuditStatus() {
        return this.auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getUpdateUser() {
        return this.updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getBak1() {
        return this.bak1;
    }

    public void setBak1(String bak1) {
        this.bak1 = bak1;
    }

    public String getBak2() {
        return this.bak2;
    }

    public void setBak2(String bak2) {
        this.bak2 = bak2;
    }

    public String getBak3() {
        return this.bak3;
    }

    public void setBak3(String bak3) {
        this.bak3 = bak3;
    }

    public String getBak4() {
        return this.bak4;
    }

    public void setBak4(String bak4) {
        this.bak4 = bak4;
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

        LaboratoryScientificTask other = (LaboratoryScientificTask) that;

        return
                (this.getDataId() == null ? other.getDataId() == null : this.getDataId().equals(other.getDataId())) &&

                        (this.getBaseId() == null ? other.getBaseId() == null : this.getBaseId().equals(other.getBaseId())) &&

                        (this.getProjectNum() == null ? other.getProjectNum() == null : this.getProjectNum().equals(other.getProjectNum())) &&

                        (this.getProjectFrom() == null ? other.getProjectFrom() == null : this.getProjectFrom().equals(other.getProjectFrom())) &&

                        (this.getProjectName() == null ? other.getProjectName() == null : this.getProjectName().equals(other.getProjectName())) &&

                        (this.getDutyPeople() == null ? other.getDutyPeople() == null : this.getDutyPeople().equals(other.getDutyPeople())) &&

                        (this.getProjectYear() == null ? other.getProjectYear() == null : this.getProjectYear().equals(other.getProjectYear())) &&

                        (this.getProjectCycle() == null ? other.getProjectCycle() == null : this.getProjectCycle().equals(other.getProjectCycle())) &&

                        (this.getProjectFunds() == null ? other.getProjectFunds() == null : this.getProjectFunds().equals(other.getProjectFunds())) &&

                        (this.getTopics() == null ? other.getTopics() == null : this.getTopics().equals(other.getTopics())) &&

                        (this.getCompletionDesc() == null ? other.getCompletionDesc() == null : this.getCompletionDesc().equals(other.getCompletionDesc())) &&

                        (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks())) &&

                        (this.getSysFlag() == null ? other.getSysFlag() == null : this.getSysFlag().equals(other.getSysFlag())) &&

                        (this.getDataOrder() == null ? other.getDataOrder() == null : this.getDataOrder().equals(other.getDataOrder())) &&

                        (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag())) &&

                        (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate())) &&

                        (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser())) &&

                        (this.getCreateUserDisp() == null ? other.getCreateUserDisp() == null : this.getCreateUserDisp().equals(other.getCreateUserDisp())) &&

                        (this.getModifyDate() == null ? other.getModifyDate() == null : this.getModifyDate().equals(other.getModifyDate())) &&

                        (this.getModifyUser() == null ? other.getModifyUser() == null : this.getModifyUser().equals(other.getModifyUser())) &&

                        (this.getModifyUserDisp() == null ? other.getModifyUserDisp() == null : this.getModifyUserDisp().equals(other.getModifyUserDisp())) &&

                        (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus())) &&

                        (this.getAuditStatus() == null ? other.getAuditStatus() == null : this.getAuditStatus().equals(other.getAuditStatus())) &&

                        (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser())) &&

                        (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate())) &&

                        (this.getBak1() == null ? other.getBak1() == null : this.getBak1().equals(other.getBak1())) &&

                        (this.getBak2() == null ? other.getBak2() == null : this.getBak2().equals(other.getBak2())) &&

                        (this.getBak3() == null ? other.getBak3() == null : this.getBak3().equals(other.getBak3())) &&

                        (this.getBak4() == null ? other.getBak4() == null : this.getBak4().equals(other.getBak4()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataId() == null) ? 0 : getDataId().hashCode());
        result = prime * result + ((getBaseId() == null) ? 0 : getBaseId().hashCode());
        result = prime * result + ((getProjectNum() == null) ? 0 : getProjectNum().hashCode());
        result = prime * result + ((getProjectFrom() == null) ? 0 : getProjectFrom().hashCode());
        result = prime * result + ((getProjectName() == null) ? 0 : getProjectName().hashCode());
        result = prime * result + ((getDutyPeople() == null) ? 0 : getDutyPeople().hashCode());
        result = prime * result + ((getProjectYear() == null) ? 0 : getProjectYear().hashCode());
        result = prime * result + ((getProjectCycle() == null) ? 0 : getProjectCycle().hashCode());
        result = prime * result + ((getProjectFunds() == null) ? 0 : getProjectFunds().hashCode());
        result = prime * result + ((getTopics() == null) ? 0 : getTopics().hashCode());
        result = prime * result + ((getCompletionDesc() == null) ? 0 : getCompletionDesc().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getSysFlag() == null) ? 0 : getSysFlag().hashCode());
        result = prime * result + ((getDataOrder() == null) ? 0 : getDataOrder().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateUserDisp() == null) ? 0 : getCreateUserDisp().hashCode());
        result = prime * result + ((getModifyDate() == null) ? 0 : getModifyDate().hashCode());
        result = prime * result + ((getModifyUser() == null) ? 0 : getModifyUser().hashCode());
        result = prime * result + ((getModifyUserDisp() == null) ? 0 : getModifyUserDisp().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getAuditStatus() == null) ? 0 : getAuditStatus().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getBak1() == null) ? 0 : getBak1().hashCode());
        result = prime * result + ((getBak2() == null) ? 0 : getBak2().hashCode());
        result = prime * result + ((getBak3() == null) ? 0 : getBak3().hashCode());
        result = prime * result + ((getBak4() == null) ? 0 : getBak4().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dataId=").append(dataId);
        sb.append(", baseId=").append(baseId);
        sb.append(", projectNum=").append(projectNum);
        sb.append(", projectFrom=").append(projectFrom);
        sb.append(", projectName=").append(projectName);
        sb.append(", dutyPeople=").append(dutyPeople);
        sb.append(", projectYear=").append(projectYear);
        sb.append(", projectCycle=").append(projectCycle);
        sb.append(", projectFunds=").append(projectFunds);
        sb.append(", topics=").append(topics);
        sb.append(", completionDesc=").append(completionDesc);
        sb.append(", remarks=").append(remarks);
        sb.append(", sysFlag=").append(sysFlag);
        sb.append(", dataOrder=").append(dataOrder);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", createDate=").append(createDate);
        sb.append(", createUser=").append(createUser);
        sb.append(", createUserDisp=").append(createUserDisp);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", modifyUser=").append(modifyUser);
        sb.append(", modifyUserDisp=").append(modifyUserDisp);
        sb.append(", status=").append(status);
        sb.append(", auditStatus=").append(auditStatus);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", bak1=").append(bak1);
        sb.append(", bak2=").append(bak2);
        sb.append(", bak3=").append(bak3);
        sb.append(", bak4=").append(bak4);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}