package com.pcitc.base.system;

public class SysUserNotice {
    private String userId;

    private String noticeId;

    private Integer userNoticeStatus;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId;
    }

    public Integer getUserNoticeStatus() {
        return userNoticeStatus;
    }

    public void setUserNoticeStatus(Integer userNoticeStatus) {
        this.userNoticeStatus = userNoticeStatus;
    }
}