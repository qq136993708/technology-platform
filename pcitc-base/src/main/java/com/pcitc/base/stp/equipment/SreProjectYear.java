package com.pcitc.base.stp.equipment;

import java.math.BigDecimal;

public class SreProjectYear {
    private String id;

    private Integer year;

    private BigDecimal capitalMoney;

    private Long projectId;

    private BigDecimal costMoney;

    private BigDecimal subtotalMoney;

    private String leadUnitName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public BigDecimal getCapitalMoney() {
        return capitalMoney;
    }

    public void setCapitalMoney(BigDecimal capitalMoney) {
        this.capitalMoney = capitalMoney;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
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