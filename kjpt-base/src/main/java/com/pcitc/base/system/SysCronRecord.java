package com.pcitc.base.system;

import com.pcitc.base.util.DateUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * sys_cron_record
 * @author 
 */
public class SysCronRecord implements Serializable {
    private Integer dataId;

    /**
     * --1，--2，--3...
     */
    private Integer status;

    private String jobName;

    private String jobClass;

    private String jobType;

    private String jobGroup;

    private Date startTime;

    private Date endTime;

    /**
     * 异常记录时间
     */
    private Date excepRecordTime;

    /**
     * 异常记录原因
     */
    private String excepRecordReason;

    private String mark1;

    private String mark2;

    private String mark3;

    private String mark4;

    private String mark5;

    private String createUserId;

    private String updateUserId;

    private String createUser;

    private String updateUser;

    private Date createDate;

    private Date updateDate;

    private String startTimeStr;

    private String endTimeStr;

    private String createDateStr;

    private String updateDateStr;

    private String excepRecordTimeStr;

    private static final long serialVersionUID = 1L;

    public Integer getDataId() {
        return dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobClass() {
        return jobClass;
    }

    public void setJobClass(String jobClass) {
        this.jobClass = jobClass;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getExcepRecordTime() {
        return excepRecordTime;
    }

    public void setExcepRecordTime(Date excepRecordTime) {
        this.excepRecordTime = excepRecordTime;
    }

    public String getExcepRecordReason() {
        return excepRecordReason;
    }

    public void setExcepRecordReason(String excepRecordReason) {
        this.excepRecordReason = excepRecordReason;
    }

    public String getMark1() {
        return mark1;
    }

    public void setMark1(String mark1) {
        this.mark1 = mark1;
    }

    public String getMark2() {
        return mark2;
    }

    public void setMark2(String mark2) {
        this.mark2 = mark2;
    }

    public String getMark3() {
        return mark3;
    }

    public void setMark3(String mark3) {
        this.mark3 = mark3;
    }

    public String getMark4() {
        return mark4;
    }

    public void setMark4(String mark4) {
        this.mark4 = mark4;
    }

    public String getMark5() {
        return mark5;
    }

    public void setMark5(String mark5) {
        this.mark5 = mark5;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getStartTimeStr() {
        return DateUtil.format(this.getStartTime(),DateUtil.FMT_SS);
    }

    public void setStartTimeStr(String startTimeStr) {
        this.startTimeStr = startTimeStr;
    }

    public String getEndTimeStr() {
        return DateUtil.format(this.getEndTime(),DateUtil.FMT_SS);
    }

    public void setEndTimeStr(String endTimeStr) {
        this.endTimeStr = endTimeStr;
    }

    public String getCreateDateStr() {
        return DateUtil.format(this.getCreateDate(),DateUtil.FMT_SS);
    }

    public void setCreateDateStr(String createDateStr) {
        this.createDateStr = createDateStr;
    }

    public String getUpdateDateStr() {
        return DateUtil.format(this.getUpdateDate(),DateUtil.FMT_SS);
    }

    public void setUpdateDateStr(String updateDateStr) {
        this.updateDateStr = updateDateStr;
    }

    public String getExcepRecordTimeStr() {
        return DateUtil.format(this.getExcepRecordTime(),DateUtil.FMT_SS);
    }

    public void setExcepRecordTimeStr(String excepRecordTimeStr) {
        this.excepRecordTimeStr = excepRecordTimeStr;
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
        SysCronRecord other = (SysCronRecord) that;
        return (this.getDataId() == null ? other.getDataId() == null : this.getDataId().equals(other.getDataId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getJobName() == null ? other.getJobName() == null : this.getJobName().equals(other.getJobName()))
            && (this.getJobClass() == null ? other.getJobClass() == null : this.getJobClass().equals(other.getJobClass()))
            && (this.getJobType() == null ? other.getJobType() == null : this.getJobType().equals(other.getJobType()))
            && (this.getJobGroup() == null ? other.getJobGroup() == null : this.getJobGroup().equals(other.getJobGroup()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getExcepRecordTime() == null ? other.getExcepRecordTime() == null : this.getExcepRecordTime().equals(other.getExcepRecordTime()))
            && (this.getExcepRecordReason() == null ? other.getExcepRecordReason() == null : this.getExcepRecordReason().equals(other.getExcepRecordReason()))
            && (this.getMark1() == null ? other.getMark1() == null : this.getMark1().equals(other.getMark1()))
            && (this.getMark2() == null ? other.getMark2() == null : this.getMark2().equals(other.getMark2()))
            && (this.getMark3() == null ? other.getMark3() == null : this.getMark3().equals(other.getMark3()))
            && (this.getMark4() == null ? other.getMark4() == null : this.getMark4().equals(other.getMark4()))
            && (this.getMark5() == null ? other.getMark5() == null : this.getMark5().equals(other.getMark5()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
            && (this.getUpdateUserId() == null ? other.getUpdateUserId() == null : this.getUpdateUserId().equals(other.getUpdateUserId()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataId() == null) ? 0 : getDataId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getJobName() == null) ? 0 : getJobName().hashCode());
        result = prime * result + ((getJobClass() == null) ? 0 : getJobClass().hashCode());
        result = prime * result + ((getJobType() == null) ? 0 : getJobType().hashCode());
        result = prime * result + ((getJobGroup() == null) ? 0 : getJobGroup().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getExcepRecordTime() == null) ? 0 : getExcepRecordTime().hashCode());
        result = prime * result + ((getExcepRecordReason() == null) ? 0 : getExcepRecordReason().hashCode());
        result = prime * result + ((getMark1() == null) ? 0 : getMark1().hashCode());
        result = prime * result + ((getMark2() == null) ? 0 : getMark2().hashCode());
        result = prime * result + ((getMark3() == null) ? 0 : getMark3().hashCode());
        result = prime * result + ((getMark4() == null) ? 0 : getMark4().hashCode());
        result = prime * result + ((getMark5() == null) ? 0 : getMark5().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getUpdateUserId() == null) ? 0 : getUpdateUserId().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dataId=").append(dataId);
        sb.append(", status=").append(status);
        sb.append(", jobName=").append(jobName);
        sb.append(", jobClass=").append(jobClass);
        sb.append(", jobType=").append(jobType);
        sb.append(", jobGroup=").append(jobGroup);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", excepRecordTime=").append(excepRecordTime);
        sb.append(", excepRecordReason=").append(excepRecordReason);
        sb.append(", mark1=").append(mark1);
        sb.append(", mark2=").append(mark2);
        sb.append(", mark3=").append(mark3);
        sb.append(", mark4=").append(mark4);
        sb.append(", mark5=").append(mark5);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", updateUserId=").append(updateUserId);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}