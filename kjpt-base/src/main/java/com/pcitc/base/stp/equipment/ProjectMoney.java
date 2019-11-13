package com.pcitc.base.stp.equipment;

import java.math.BigDecimal;

public class ProjectMoney {
    private String id;

    private String projectId;

    private String year;

    private BigDecimal zbMoney;

    private BigDecimal fyMoney;

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

    public BigDecimal getZbMoney() {
        return zbMoney;
    }

    public void setZbMoney(BigDecimal zbMoney) {
        this.zbMoney = zbMoney;
    }

    public BigDecimal getFyMoney() {
        return fyMoney;
    }

    public void setFyMoney(BigDecimal fyMoney) {
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