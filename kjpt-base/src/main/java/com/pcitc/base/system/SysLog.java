package com.pcitc.base.system;

import java.io.Serializable;
import java.util.Date;

/**
 * sys_log
 * @author 
 */
public class SysLog implements Serializable {
    private String id;

    /**
     * 操作时间
     */
    private Date logTime;

    /**
     * 登陆人
     */
    private String userId="";

    /**
     * 登陆人
     */
    private String userName="";

    /**
     * 登陆IP
     */
    private String logIp="";

    /**
     * 备注
     */
    private String remarks="";

    /**
     * 日志类型：1登陆日志，2操作日志，3错误日志
     */
    private String logType="2";

    /**
     * GET,POST等
     */
    private String requestType="";

    /**
     * URL
     */
    private String logUrl="";

    /**
     * 操作描述
     */
    private String optDescribe="";

    /**
     * 操作结果
     */
    private String optResult="";

    /**
     * 操作错误信息
     */
    private String optError="";

    /**
     * 用户所属部门
     */
    private String userDepartment="";

    /**
     * 用户所属公司或单位
     */
    private String userCompany="";

    /**
              * 用户类型：1普通用户，2系统管理员，2安全员，3审计员
     */
    private String userType;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLogIp() {
        return logIp;
    }

    public void setLogIp(String logIp) {
        this.logIp = logIp;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getLogUrl() {
        return logUrl;
    }

    public void setLogUrl(String logUrl) {
        this.logUrl = logUrl;
    }

    public String getOptDescribe() {
        return optDescribe;
    }

    public void setOptDescribe(String optDescribe) {
        this.optDescribe = optDescribe;
    }

    public String getOptResult() {
        return optResult;
    }

    public void setOptResult(String optResult) {
        this.optResult = optResult;
    }

    public String getOptError() {
        return optError;
    }

    public void setOptError(String optError) {
        this.optError = optError;
    }

    public String getUserDepartment() {
        return userDepartment;
    }

    public void setUserDepartment(String userDepartment) {
        this.userDepartment = userDepartment;
    }

    public String getUserCompany() {
        return userCompany;
    }

    public void setUserCompany(String userCompany) {
        this.userCompany = userCompany;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}