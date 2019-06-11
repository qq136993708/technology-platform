package com.pcitc.base.expert;

import com.pcitc.base.common.DataEntity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * <p>实体类</p>
 * <p>Table: zjk_msg - 专家-回复管理</p>
 *
 * @since 2019-02-25 03:45:21
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ZjkMsg extends DataEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * data_id -
     */
    private String dataId;

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
     * form_code - 业务编码
     */
    private String formCode;

    /**
     * data_index - 序号
     */
    private String dataIndex;

    /**
     * status - 状态
     */
    private String status;

    /**
     * audit_status - 审批状态
     */
    private String auditStatus;

    /**
     * company_code - 公司代码
     */
    private String companyCode;

    /**
     * update_user - 修改人
     */
    private String updateUser;

    /**
     * update_date - 修改时间
     */
    private String updateDate;

    /**
     * project_id - 项目
     */
    private String projectId;

    /**
     * project_name - 项目名称
     */
    private String projectName;

    /**
     * zjk_id - 专家ID
     */
    private String zjkId;

    /**
     * zjk_name - 专家名称
     */
    private String zjkName;

    /**
     * xm_id - 项目ID
     */
    private String xmId;

    /**
     * xm_name - 项目名称
     */
    private String xmName;

    /**
     * xm_steps - 项目阶段
     */
    private String xmSteps;

    /**
     * is_complete - 是否回复
     */
    private String isComplete;

    /**
     * complete_type - 回复方式
     */
    private String completeType;

    public String getDataId() {
        return this.dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
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

    public String getFormCode() {
        return this.formCode;
    }

    public void setFormCode(String formCode) {
        this.formCode = formCode;
    }

    public String getDataIndex() {
        return this.dataIndex;
    }

    public void setDataIndex(String dataIndex) {
        this.dataIndex = dataIndex;
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

    public String getCompanyCode() {
        return this.companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
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

    public String getProjectId() {
        return this.projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getZjkId() {
        return this.zjkId;
    }

    public void setZjkId(String zjkId) {
        this.zjkId = zjkId;
    }

    public String getZjkName() {
        return this.zjkName;
    }

    public void setZjkName(String zjkName) {
        this.zjkName = zjkName;
    }

    public String getXmId() {
        return this.xmId;
    }

    public void setXmId(String xmId) {
        this.xmId = xmId;
    }

    public String getXmName() {
        return this.xmName;
    }

    public void setXmName(String xmName) {
        this.xmName = xmName;
    }

    public String getXmSteps() {
        return this.xmSteps;
    }

    public void setXmSteps(String xmSteps) {
        this.xmSteps = xmSteps;
    }

    public String getIsComplete() {
        return this.isComplete;
    }

    public void setIsComplete(String isComplete) {
        this.isComplete = isComplete;
    }

    public String getCompleteType() {
        return this.completeType;
    }

    public void setCompleteType(String completeType) {
        this.completeType = completeType;
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

        ZjkMsg other = (ZjkMsg) that;

        return
                (this.getDataId() == null ? other.getDataId() == null : this.getDataId().equals(other.getDataId())) &&

                        (this.getSysFlag() == null ? other.getSysFlag() == null : this.getSysFlag().equals(other.getSysFlag())) &&

                        (this.getDataOrder() == null ? other.getDataOrder() == null : this.getDataOrder().equals(other.getDataOrder())) &&

                        (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag())) &&

                        (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate())) &&

                        (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser())) &&

                        (this.getCreateUserDisp() == null ? other.getCreateUserDisp() == null : this.getCreateUserDisp().equals(other.getCreateUserDisp())) &&

                        (this.getModifyDate() == null ? other.getModifyDate() == null : this.getModifyDate().equals(other.getModifyDate())) &&

                        (this.getModifyUser() == null ? other.getModifyUser() == null : this.getModifyUser().equals(other.getModifyUser())) &&

                        (this.getModifyUserDisp() == null ? other.getModifyUserDisp() == null : this.getModifyUserDisp().equals(other.getModifyUserDisp())) &&

                        (this.getFormCode() == null ? other.getFormCode() == null : this.getFormCode().equals(other.getFormCode())) &&

                        (this.getDataIndex() == null ? other.getDataIndex() == null : this.getDataIndex().equals(other.getDataIndex())) &&

                        (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus())) &&

                        (this.getAuditStatus() == null ? other.getAuditStatus() == null : this.getAuditStatus().equals(other.getAuditStatus())) &&

                        (this.getCompanyCode() == null ? other.getCompanyCode() == null : this.getCompanyCode().equals(other.getCompanyCode())) &&

                        (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser())) &&

                        (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate())) &&

                        (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId())) &&

                        (this.getProjectName() == null ? other.getProjectName() == null : this.getProjectName().equals(other.getProjectName())) &&

                        (this.getZjkId() == null ? other.getZjkId() == null : this.getZjkId().equals(other.getZjkId())) &&

                        (this.getZjkName() == null ? other.getZjkName() == null : this.getZjkName().equals(other.getZjkName())) &&

                        (this.getXmId() == null ? other.getXmId() == null : this.getXmId().equals(other.getXmId())) &&

                        (this.getXmName() == null ? other.getXmName() == null : this.getXmName().equals(other.getXmName())) &&

                        (this.getXmSteps() == null ? other.getXmSteps() == null : this.getXmSteps().equals(other.getXmSteps())) &&

                        (this.getIsComplete() == null ? other.getIsComplete() == null : this.getIsComplete().equals(other.getIsComplete())) &&

                        (this.getCompleteType() == null ? other.getCompleteType() == null : this.getCompleteType().equals(other.getCompleteType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataId() == null) ? 0 : getDataId().hashCode());
        result = prime * result + ((getSysFlag() == null) ? 0 : getSysFlag().hashCode());
        result = prime * result + ((getDataOrder() == null) ? 0 : getDataOrder().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateUserDisp() == null) ? 0 : getCreateUserDisp().hashCode());
        result = prime * result + ((getModifyDate() == null) ? 0 : getModifyDate().hashCode());
        result = prime * result + ((getModifyUser() == null) ? 0 : getModifyUser().hashCode());
        result = prime * result + ((getModifyUserDisp() == null) ? 0 : getModifyUserDisp().hashCode());
        result = prime * result + ((getFormCode() == null) ? 0 : getFormCode().hashCode());
        result = prime * result + ((getDataIndex() == null) ? 0 : getDataIndex().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getAuditStatus() == null) ? 0 : getAuditStatus().hashCode());
        result = prime * result + ((getCompanyCode() == null) ? 0 : getCompanyCode().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getProjectName() == null) ? 0 : getProjectName().hashCode());
        result = prime * result + ((getZjkId() == null) ? 0 : getZjkId().hashCode());
        result = prime * result + ((getZjkName() == null) ? 0 : getZjkName().hashCode());
        result = prime * result + ((getXmId() == null) ? 0 : getXmId().hashCode());
        result = prime * result + ((getXmName() == null) ? 0 : getXmName().hashCode());
        result = prime * result + ((getXmSteps() == null) ? 0 : getXmSteps().hashCode());
        result = prime * result + ((getIsComplete() == null) ? 0 : getIsComplete().hashCode());
        result = prime * result + ((getCompleteType() == null) ? 0 : getCompleteType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dataId=").append(dataId);
        sb.append(", sysFlag=").append(sysFlag);
        sb.append(", dataOrder=").append(dataOrder);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", createDate=").append(createDate);
        sb.append(", createUser=").append(createUser);
        sb.append(", createUserDisp=").append(createUserDisp);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", modifyUser=").append(modifyUser);
        sb.append(", modifyUserDisp=").append(modifyUserDisp);
        sb.append(", formCode=").append(formCode);
        sb.append(", dataIndex=").append(dataIndex);
        sb.append(", status=").append(status);
        sb.append(", auditStatus=").append(auditStatus);
        sb.append(", companyCode=").append(companyCode);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", projectId=").append(projectId);
        sb.append(", projectName=").append(projectName);
        sb.append(", zjkId=").append(zjkId);
        sb.append(", zjkName=").append(zjkName);
        sb.append(", xmId=").append(xmId);
        sb.append(", xmName=").append(xmName);
        sb.append(", xmSteps=").append(xmSteps);
        sb.append(", isComplete=").append(isComplete);
        sb.append(", completeType=").append(completeType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}