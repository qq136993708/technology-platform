package com.pcitc.base.system;

import com.pcitc.base.common.DataEntity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * <p>实体类</p>
 * <p>Table: standard_base - 标准化</p>
 *
 * @since 2019-05-10 03:49:18
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StandardBase extends DataEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * data_id -
     */
    private String dataId;

    /**
     * standard_name - 标准名称
     */
    private String standardName;

    /**
     * standard_desc - 标准内容
     */
    private String standardDesc;

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

    /**
     * bak5 -
     */
    private String bak5;

    /**
     * pid - 父ID
     */
    private String pid;

    /**
     * remark - 备注
     */
    private String remark;

    /**
     * org_type - 组织类别
     */
    private String orgType;

    /**
     * standard_keys - 关键字
     */
    private String standardKeys;

    /**
     * standard_num - 标准号
     */
    private String standardNum;

    /**
     * standard_status - 标准状态
     */
    private String standardStatus;

    /**
     * ics_type - ICS分类
     */
    private String icsType;

    /**
     * choice_type - 选择分类
     */
    private String choiceType;

    /**
     * year_num - 年代号
     */
    private String yearNum;

    public String getDataId() {
        return this.dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getStandardName() {
        return this.standardName;
    }

    public void setStandardName(String standardName) {
        this.standardName = standardName;
    }

    public String getStandardDesc() {
        return this.standardDesc;
    }

    public void setStandardDesc(String standardDesc) {
        this.standardDesc = standardDesc;
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

    public String getBak5() {
        return this.bak5;
    }

    public void setBak5(String bak5) {
        this.bak5 = bak5;
    }

    public String getPid() {
        return this.pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOrgType() {
        return this.orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getStandardKeys() {
        return this.standardKeys;
    }

    public void setStandardKeys(String standardKeys) {
        this.standardKeys = standardKeys;
    }

    public String getStandardNum() {
        return this.standardNum;
    }

    public void setStandardNum(String standardNum) {
        this.standardNum = standardNum;
    }

    public String getStandardStatus() {
        return this.standardStatus;
    }

    public void setStandardStatus(String standardStatus) {
        this.standardStatus = standardStatus;
    }

    public String getIcsType() {
        return this.icsType;
    }

    public void setIcsType(String icsType) {
        this.icsType = icsType;
    }

    public String getChoiceType() {
        return this.choiceType;
    }

    public void setChoiceType(String choiceType) {
        this.choiceType = choiceType;
    }

    public String getYearNum() {
        return this.yearNum;
    }

    public void setYearNum(String yearNum) {
        this.yearNum = yearNum;
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

        StandardBase other = (StandardBase) that;

        return
                (this.getDataId() == null ? other.getDataId() == null : this.getDataId().equals(other.getDataId())) &&

                        (this.getStandardName() == null ? other.getStandardName() == null : this.getStandardName().equals(other.getStandardName())) &&

                        (this.getStandardDesc() == null ? other.getStandardDesc() == null : this.getStandardDesc().equals(other.getStandardDesc())) &&

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

                        (this.getBak1() == null ? other.getBak1() == null : this.getBak1().equals(other.getBak1())) &&

                        (this.getBak2() == null ? other.getBak2() == null : this.getBak2().equals(other.getBak2())) &&

                        (this.getBak3() == null ? other.getBak3() == null : this.getBak3().equals(other.getBak3())) &&

                        (this.getBak4() == null ? other.getBak4() == null : this.getBak4().equals(other.getBak4())) &&

                        (this.getBak5() == null ? other.getBak5() == null : this.getBak5().equals(other.getBak5())) &&

                        (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid())) &&

                        (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark())) &&

                        (this.getOrgType() == null ? other.getOrgType() == null : this.getOrgType().equals(other.getOrgType())) &&

                        (this.getStandardKeys() == null ? other.getStandardKeys() == null : this.getStandardKeys().equals(other.getStandardKeys())) &&

                        (this.getStandardNum() == null ? other.getStandardNum() == null : this.getStandardNum().equals(other.getStandardNum())) &&

                        (this.getStandardStatus() == null ? other.getStandardStatus() == null : this.getStandardStatus().equals(other.getStandardStatus())) &&

                        (this.getIcsType() == null ? other.getIcsType() == null : this.getIcsType().equals(other.getIcsType())) &&

                        (this.getChoiceType() == null ? other.getChoiceType() == null : this.getChoiceType().equals(other.getChoiceType())) &&

                        (this.getYearNum() == null ? other.getYearNum() == null : this.getYearNum().equals(other.getYearNum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataId() == null) ? 0 : getDataId().hashCode());
        result = prime * result + ((getStandardName() == null) ? 0 : getStandardName().hashCode());
        result = prime * result + ((getStandardDesc() == null) ? 0 : getStandardDesc().hashCode());
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
        result = prime * result + ((getBak1() == null) ? 0 : getBak1().hashCode());
        result = prime * result + ((getBak2() == null) ? 0 : getBak2().hashCode());
        result = prime * result + ((getBak3() == null) ? 0 : getBak3().hashCode());
        result = prime * result + ((getBak4() == null) ? 0 : getBak4().hashCode());
        result = prime * result + ((getBak5() == null) ? 0 : getBak5().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getOrgType() == null) ? 0 : getOrgType().hashCode());
        result = prime * result + ((getStandardKeys() == null) ? 0 : getStandardKeys().hashCode());
        result = prime * result + ((getStandardNum() == null) ? 0 : getStandardNum().hashCode());
        result = prime * result + ((getStandardStatus() == null) ? 0 : getStandardStatus().hashCode());
        result = prime * result + ((getIcsType() == null) ? 0 : getIcsType().hashCode());
        result = prime * result + ((getChoiceType() == null) ? 0 : getChoiceType().hashCode());
        result = prime * result + ((getYearNum() == null) ? 0 : getYearNum().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dataId=").append(dataId);
        sb.append(", standardName=").append(standardName);
        sb.append(", standardDesc=").append(standardDesc);
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
        sb.append(", bak1=").append(bak1);
        sb.append(", bak2=").append(bak2);
        sb.append(", bak3=").append(bak3);
        sb.append(", bak4=").append(bak4);
        sb.append(", bak5=").append(bak5);
        sb.append(", pid=").append(pid);
        sb.append(", remark=").append(remark);
        sb.append(", orgType=").append(orgType);
        sb.append(", standardKeys=").append(standardKeys);
        sb.append(", standardNum=").append(standardNum);
        sb.append(", standardStatus=").append(standardStatus);
        sb.append(", icsType=").append(icsType);
        sb.append(", choiceType=").append(choiceType);
        sb.append(", yearNum=").append(yearNum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}