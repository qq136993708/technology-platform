package com.pcitc.base.stp.equipment;

import java.math.BigDecimal;

public class SreProjectYear {
    private String id;

    private String projectId;

    private String year;

    private BigDecimal capitalMoney;

    private BigDecimal costMoney;

    private BigDecimal subtotalMoney;

    private String leadUnitName;

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

    public BigDecimal getCapitalMoney() {
        return capitalMoney;
    }

    public void setCapitalMoney(BigDecimal capitalMoney) {
        this.capitalMoney = capitalMoney;
    }

    public BigDecimal getCostMoney() {
        return costMoney;
    }

    public void setCostMoney(BigDecimal costMoney) {
        this.costMoney = costMoney;
    }

    public BigDecimal getSubtotalMoney() {
        return subtotalMoney;
    }

    public void setSubtotalMoney(BigDecimal subtotalMoney) {
        this.subtotalMoney = subtotalMoney;
    }

    public String getLeadUnitName() {
        return leadUnitName;
    }

    public void setLeadUnitName(String leadUnitName) {
        this.leadUnitName = leadUnitName;
    }
}