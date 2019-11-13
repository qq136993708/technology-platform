package com.pcitc.base.system;

import com.pcitc.base.util.SearchInfo;

import java.util.Date;

public class SysLog extends SearchInfo {
    /**
     *
     */
    private static final long serialVersionUID = 5350965137472396023L;

    private String logId;

    private String logActionName;

    private String logAction;

    private String logType;

    private String logPersonId;

    private String logPerson;

    private Date logTime;

    private String logsTime;

    private String logStatus;

    private String logIp;

    private String auditStatus;

    private String logRemarks;

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getLogActionName() {
        return logActionName;
    }

    public void setLogActionName(String logActionName) {
        this.logActionName = logActionName;
    }

    public String getLogAction() {
        return logAction;
    }

    public void setLogAction(String logAction) {
        this.logAction = logAction;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getLogPersonId() {
        return logPersonId;
    }

    public void setLogPersonId(String logPersonId) {
        this.logPersonId = logPersonId;
    }

    public String getLogPerson() {
        return logPerson;
    }

    public void setLogPerson(String logPerson) {
        this.logPerson = logPerson;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public String getLogsTime() {
        return logsTime;
    }

    public void setLogsTime(String logsTime) {
        this.logsTime = logsTime;
    }

    public String getLogStatus() {
        return logStatus;
    }

    public void setLogStatus(String logStatus) {
        this.logStatus = logStatus;
    }

    public String getLogIp() {
        return logIp;
    }

    public void setLogIp(String logIp) {
        this.logIp = logIp;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getLogRemarks() {
        return logRemarks;
    }

    public void setLogRemarks(String logRemarks) {
        this.logRemarks = logRemarks;
    }
}