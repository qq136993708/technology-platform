package com.pcitc.base.stp.budget;

import java.io.Serializable;

/**
 * out_tem_budget_organ_items
 * @author 
 */
public class OutTemBudgetOrganItems implements Serializable {
    /**
     * 主键ID
     */
    private String dataId;

    /**
     * 数据序号
     */
    private Integer dataNo;

    /**
     * 编码
     */
    private String organCode;

    /**
     * 部门名称
     */
    private String organName;

    private String organDesc;

    /**
     * 创建人
     */
    private String creater;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 删除标识
     */
    private Integer delFlag;

    /**
     * 备注
     */
    private String remark;

    /**
     * 联系人ID列表
     */
    private String contacts;

    private String dataVersion;

    private String appendFiles;

    private static final long serialVersionUID = 1L;

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public Integer getDataNo() {
        return dataNo;
    }

    public void setDataNo(Integer dataNo) {
        this.dataNo = dataNo;
    }

    public String getOrganCode() {
        return organCode;
    }

    public void setOrganCode(String organCode) {
        this.organCode = organCode;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public String getOrganDesc() {
        return organDesc;
    }

    public void setOrganDesc(String organDesc) {
        this.organDesc = organDesc;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getDataVersion() {
        return dataVersion;
    }

    public void setDataVersion(String dataVersion) {
        this.dataVersion = dataVersion;
    }

    public String getAppendFiles() {
        return appendFiles;
    }

    public void setAppendFiles(String appendFiles) {
        this.appendFiles = appendFiles;
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
        OutTemBudgetOrganItems other = (OutTemBudgetOrganItems) that;
        return (this.getDataId() == null ? other.getDataId() == null : this.getDataId().equals(other.getDataId()))
            && (this.getDataNo() == null ? other.getDataNo() == null : this.getDataNo().equals(other.getDataNo()))
            && (this.getOrganCode() == null ? other.getOrganCode() == null : this.getOrganCode().equals(other.getOrganCode()))
            && (this.getOrganName() == null ? other.getOrganName() == null : this.getOrganName().equals(other.getOrganName()))
            && (this.getOrganDesc() == null ? other.getOrganDesc() == null : this.getOrganDesc().equals(other.getOrganDesc()))
            && (this.getCreater() == null ? other.getCreater() == null : this.getCreater().equals(other.getCreater()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getContacts() == null ? other.getContacts() == null : this.getContacts().equals(other.getContacts()))
            && (this.getDataVersion() == null ? other.getDataVersion() == null : this.getDataVersion().equals(other.getDataVersion()))
            && (this.getAppendFiles() == null ? other.getAppendFiles() == null : this.getAppendFiles().equals(other.getAppendFiles()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataId() == null) ? 0 : getDataId().hashCode());
        result = prime * result + ((getDataNo() == null) ? 0 : getDataNo().hashCode());
        result = prime * result + ((getOrganCode() == null) ? 0 : getOrganCode().hashCode());
        result = prime * result + ((getOrganName() == null) ? 0 : getOrganName().hashCode());
        result = prime * result + ((getOrganDesc() == null) ? 0 : getOrganDesc().hashCode());
        result = prime * result + ((getCreater() == null) ? 0 : getCreater().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getContacts() == null) ? 0 : getContacts().hashCode());
        result = prime * result + ((getDataVersion() == null) ? 0 : getDataVersion().hashCode());
        result = prime * result + ((getAppendFiles() == null) ? 0 : getAppendFiles().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dataId=").append(dataId);
        sb.append(", dataNo=").append(dataNo);
        sb.append(", organCode=").append(organCode);
        sb.append(", organName=").append(organName);
        sb.append(", organDesc=").append(organDesc);
        sb.append(", creater=").append(creater);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", remark=").append(remark);
        sb.append(", contacts=").append(contacts);
        sb.append(", dataVersion=").append(dataVersion);
        sb.append(", appendFiles=").append(appendFiles);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}