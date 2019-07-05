package com.pcitc.base.stp.equipment;

public class ProjectMoney {
    private String id;

    private String projectId;

    private String year;

    private Integer zbMoney;

    private Integer fyMoney;

    private String unitName;

    private String unitCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getZbMoney() {
        return zbMoney;
    }

    public void setZbMoney(Integer zbMoney) {
        this.zbMoney = zbMoney;
    }

    public Integer getFyMoney() {
        return fyMoney;
    }

    public void setFyMoney(Integer fyMoney) {
        this.fyMoney = fyMoney;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }
}