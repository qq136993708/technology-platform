package com.pcitc.base.stp.out;

import java.io.Serializable;

/**
 * out_standard_data
 * @author 
 */
public class OutStandardData implements Serializable {
    /**
     * 主键ID
     */
    private String dataId;

    private String nd;

    /**
     * 唯一标识
     */
    private String id;

    /**
     * 资源的展示名称
     */
    private String criterionchname;

    private String criterionegname;

    /**
     * 资源的标准编号
     */
    private String criterionnumber;

    /**
     * 资源的发布日期
     */
    private String pubdate;

    /**
     * 资源的实施时间
     */
    private String implementdate;

    /**
     * 数据版本
     */
    private String dataVersion;

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

    private String dataSource;

    private static final long serialVersionUID = 1L;

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getNd() {
        return nd;
    }

    public void setNd(String nd) {
        this.nd = nd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCriterionchname() {
        return criterionchname;
    }

    public void setCriterionchname(String criterionchname) {
        this.criterionchname = criterionchname;
    }

    public String getCriterionegname() {
        return criterionegname;
    }

    public void setCriterionegname(String criterionegname) {
        this.criterionegname = criterionegname;
    }

    public String getCriterionnumber() {
        return criterionnumber;
    }

    public void setCriterionnumber(String criterionnumber) {
        this.criterionnumber = criterionnumber;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getImplementdate() {
        return implementdate;
    }

    public void setImplementdate(String implementdate) {
        this.implementdate = implementdate;
    }

    public String getDataVersion() {
        return dataVersion;
    }

    public void setDataVersion(String dataVersion) {
        this.dataVersion = dataVersion;
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

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
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
        OutStandardData other = (OutStandardData) that;
        return (this.getDataId() == null ? other.getDataId() == null : this.getDataId().equals(other.getDataId()))
            && (this.getNd() == null ? other.getNd() == null : this.getNd().equals(other.getNd()))
            && (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCriterionchname() == null ? other.getCriterionchname() == null : this.getCriterionchname().equals(other.getCriterionchname()))
            && (this.getCriterionegname() == null ? other.getCriterionegname() == null : this.getCriterionegname().equals(other.getCriterionegname()))
            && (this.getCriterionnumber() == null ? other.getCriterionnumber() == null : this.getCriterionnumber().equals(other.getCriterionnumber()))
            && (this.getPubdate() == null ? other.getPubdate() == null : this.getPubdate().equals(other.getPubdate()))
            && (this.getImplementdate() == null ? other.getImplementdate() == null : this.getImplementdate().equals(other.getImplementdate()))
            && (this.getDataVersion() == null ? other.getDataVersion() == null : this.getDataVersion().equals(other.getDataVersion()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()))
            && (this.getDataSource() == null ? other.getDataSource() == null : this.getDataSource().equals(other.getDataSource()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataId() == null) ? 0 : getDataId().hashCode());
        result = prime * result + ((getNd() == null) ? 0 : getNd().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCriterionchname() == null) ? 0 : getCriterionchname().hashCode());
        result = prime * result + ((getCriterionegname() == null) ? 0 : getCriterionegname().hashCode());
        result = prime * result + ((getCriterionnumber() == null) ? 0 : getCriterionnumber().hashCode());
        result = prime * result + ((getPubdate() == null) ? 0 : getPubdate().hashCode());
        result = prime * result + ((getImplementdate() == null) ? 0 : getImplementdate().hashCode());
        result = prime * result + ((getDataVersion() == null) ? 0 : getDataVersion().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        result = prime * result + ((getDataSource() == null) ? 0 : getDataSource().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dataId=").append(dataId);
        sb.append(", nd=").append(nd);
        sb.append(", id=").append(id);
        sb.append(", criterionchname=").append(criterionchname);
        sb.append(", criterionegname=").append(criterionegname);
        sb.append(", criterionnumber=").append(criterionnumber);
        sb.append(", pubdate=").append(pubdate);
        sb.append(", implementdate=").append(implementdate);
        sb.append(", dataVersion=").append(dataVersion);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", dataSource=").append(dataSource);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}