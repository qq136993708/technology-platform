package com.pcitc.base.stp.equipment;

import java.util.Date;

public class SreProjectAudit {
    private String id;

    private String projecttaskid;

    private String content;

    private String createUser;

    private Date createDate;

    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjecttaskid() {
        return projecttaskid;
    }

    public void setProjecttaskid(String projecttaskid) {
        this.projecttaskid = projecttaskid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}