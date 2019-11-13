package com.pcitc.service.system;

import org.quartz.DateBuilder;
import org.quartz.Job;

import java.util.Date;

public class TimedTask {
    /**
     *
     */
    private String jobName;
    private String jobGroupName;
    private Class<? extends Job> jobClass;
    private DateBuilder.IntervalUnit intervalUnit;
    private Integer timeInterval;
    private String cronExpression;
    private Date startTime;
    private Date endTime;

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroupName() {
        return jobGroupName;
    }

    public void setJobGroupName(String jobGroupName) {
        this.jobGroupName = jobGroupName;
    }

    public Class<? extends Job> getJobClass() {
        return jobClass;
    }

    public void setJobClass(Class<? extends Job> jobClass) {
        this.jobClass = jobClass;
    }

    public DateBuilder.IntervalUnit getIntervalUnit() {
        return intervalUnit;
    }

    public void setIntervalUnit(DateBuilder.IntervalUnit intervalUnit) {
        this.intervalUnit = intervalUnit;
    }

    public Integer getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(Integer timeInterval) {
        this.timeInterval = timeInterval;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
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


}
