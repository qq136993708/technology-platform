package com.pcitc.base.common;

import com.pcitc.base.util.SearchInfo;

import java.io.Serializable;

/**
 * @author:Administrator
 * @date:2018/5/15
 */
public abstract class DataEntity extends SearchInfo{
    private static final long serialVersionUID = 1L;

    private String id;
    private String createPersonId;
    private String createDate;
    private String remarks;
    /** 0代表作废（禁用）、1代表生效（启用）*/
    private String status;
    /** 0：未审批   1：审批中    2：审批通过    3：审批不通过*/
    private String auditStatus;
    private String updatePersonId;
    private String updateDate;
    private String createPersonName;
    private String updatePersonName;
    private String fileIds;
    private String parentId;
    private String parentName;
    private String rootId;


    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getRootId() {
        return rootId;
    }

    public void setRootId(String rootId) {
        this.rootId = rootId;
    }



    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreatePersonId() {
        return createPersonId;
    }

    public void setCreatePersonId(String createPersonId) {
        this.createPersonId = createPersonId;
    }

    public String getCreatePersonName() {
        return createPersonName;
    }

    public void setCreatePersonName(String createPersonName) {
        this.createPersonName = createPersonName;
    }

    public String getFileIds() {
        return fileIds;
    }

    public void setFileIds(String fileIds) {
        this.fileIds = fileIds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdatePersonId() {
        return updatePersonId;
    }

    public void setUpdatePersonId(String updatePersonId) {
        this.updatePersonId = updatePersonId;
    }

    public String getUpdatePersonName() {
        return updatePersonName;
    }

    public void setUpdatePersonName(String updatePersonName) {
        this.updatePersonName = updatePersonName;
    }

}
