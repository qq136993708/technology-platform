package com.pcitc.base.system;

import java.io.Serializable;
import java.util.Date;

/**
 * t_department
 * @author 
 */
public class Department implements Serializable {
    private String id;

    /**
     * 标题
     */
    private String title;

    /**
     * 类别
     */
    private String type;

    private Date createTime;

    private String createUserId;

    private static final long serialVersionUID = 1L;
    
    
    
    /**
     * 简介
     */
    private String breif;

    /**
     * 发展历程
     */
    private String developHistory;

    /**
     * 组织
     */
    private String organization;

    /**
     * 人员
     */
    private String personnel;

    /**
     * 荣誉
     */
    private String honor;

    /**
     * 主要装备
     */
    private String major;

    /**
     * 备注
     */
    private String notes;
    
    
    private String typeCode;
    
    private Integer orders;
    
    
    
    
	public Integer getOrders() {
		return orders;
	}

	public void setOrders(Integer orders) {
		this.orders = orders;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getBreif() {
		return breif;
	}

	public void setBreif(String breif) {
		this.breif = breif;
	}

	public String getDevelopHistory() {
		return developHistory;
	}

	public void setDevelopHistory(String developHistory) {
		this.developHistory = developHistory;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getPersonnel() {
		return personnel;
	}

	public void setPersonnel(String personnel) {
		this.personnel = personnel;
	}

	public String getHonor() {
		return honor;
	}

	public void setHonor(String honor) {
		this.honor = honor;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
    
    

}