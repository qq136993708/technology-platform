package com.pcitc.base.stp.equipment;

import java.util.Date;

public class SreForApplication {
    private String applicationId;

    private String applicationName;

    private Date applicationTime;

    private String applicationAccount;

    private String applicationUserName;

    private String applicationMoney;

    private String applicationState;

    private String applicationPurchaseid;

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public Date getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }

    public String getApplicationAccount() {
        return applicationAccount;
    }

    public void setApplicationAccount(String applicationAccount) {
        this.applicationAccount = applicationAccount;
    }

    public String getApplicationUserName() {
        return applicationUserName;
    }

    public void setApplicationUserName(String applicationUserName) {
        this.applicationUserName = applicationUserName;
    }

    public String getApplicationMoney() {
        return applicationMoney;
    }

    public void setApplicationMoney(String applicationMoney) {
        this.applicationMoney = applicationMoney;
    }

    public String getApplicationState() {
        return applicationState;
    }

    public void setApplicationState(String applicationState) {
        this.applicationState = applicationState;
    }

    public String getApplicationPurchaseid() {
        return applicationPurchaseid;
    }

    public void setApplicationPurchaseid(String applicationPurchaseid) {
        this.applicationPurchaseid = applicationPurchaseid;
    }

	@Override
	public String toString() {
		return "SreForApplication [applicationId=" + applicationId + ", applicationName=" + applicationName
				+ ", applicationTime=" + applicationTime + ", applicationAccount=" + applicationAccount
				+ ", applicationUserName=" + applicationUserName + ", applicationMoney=" + applicationMoney
				+ ", applicationState=" + applicationState + ", applicationPurchaseid=" + applicationPurchaseid + "]";
	}
    
    
}