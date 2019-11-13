package com.pcitc.base.stp.techFamily;

import java.util.List;

public class TechFamily {
    private String tfmTypeId;

    private String typeCode;

    private String typeName;

    private String parentId;

    private String parentCode;

    private String isParent;

    private String typeIndex;

    private String status;

    private String levelCode;

    private String dataOrder;

    private String remarks;

    private String typeScope;

    private String createUser;

    private String createUserId;

    private String createDate;

    private String updateDate;

    private String updateUser;

    private String auditStatus;

    private String isHot;

    private String developInfo;

    private String directionInfo;
    
    private List<String> typeCodeCond;
    
    
    public List<String> getTypeCodeCond() {
		return typeCodeCond;
	}

	public void setTypeCodeCond(List<String> typeCodeCond) {
		this.typeCodeCond = typeCodeCond;
	}

	public String getTfmTypeId() {
        return tfmTypeId;
    }

    public void setTfmTypeId(String tfmTypeId) {
        this.tfmTypeId = tfmTypeId;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getIsParent() {
        return isParent;
    }

    public void setIsParent(String isParent) {
        this.isParent = isParent;
    }

    public String getTypeIndex() {
        return typeIndex;
    }

    public void setTypeIndex(String typeIndex) {
        this.typeIndex = typeIndex;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(String levelCode) {
        this.levelCode = levelCode;
    }

    public String getDataOrder() {
        return dataOrder;
    }

    public void setDataOrder(String dataOrder) {
        this.dataOrder = dataOrder;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTypeScope() {
        return typeScope;
    }

    public void setTypeScope(String typeScope) {
        this.typeScope = typeScope;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getIsHot() {
        return isHot;
    }

    public void setIsHot(String isHot) {
        this.isHot = isHot;
    }

    public String getDevelopInfo() {
        return developInfo;
    }

    public void setDevelopInfo(String developInfo) {
        this.developInfo = developInfo;
    }

    public String getDirectionInfo() {
        return directionInfo;
    }

    public void setDirectionInfo(String directionInfo) {
        this.directionInfo = directionInfo;
    }
}