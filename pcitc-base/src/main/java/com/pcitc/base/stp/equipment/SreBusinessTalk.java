package com.pcitc.base.stp.equipment;

import java.math.BigDecimal;
import java.util.Date;

public class SreBusinessTalk {
    private String talkId;

    private String talkCode;

    private String purchasePlanId;

    private Long supplyId;

    private BigDecimal supplyPrice;

    private BigDecimal supplyQuote;

    private Date createDate;

    private String createUserId;

    private String updateUserId;

    private Date updateTime;

    private String status;

    private String remarks;

    public String getTalkId() {
        return talkId;
    }

    public void setTalkId(String talkId) {
        this.talkId = talkId;
    }

    public String getTalkCode() {
        return talkCode;
    }

    public void setTalkCode(String talkCode) {
        this.talkCode = talkCode;
    }

    public String getPurchasePlanId() {
        return purchasePlanId;
    }

    public void setPurchasePlanId(String purchasePlanId) {
        this.purchasePlanId = purchasePlanId;
    }

    public Long getSupplyId() {
        return supplyId;
    }

    public void setSupplyId(Long supplyId) {
        this.supplyId = supplyId;
    }

    public BigDecimal getSupplyPrice() {
        return supplyPrice;
    }

    public void setSupplyPrice(BigDecimal supplyPrice) {
        this.supplyPrice = supplyPrice;
    }

    public BigDecimal getSupplyQuote() {
        return supplyQuote;
    }

    public void setSupplyQuote(BigDecimal supplyQuote) {
        this.supplyQuote = supplyQuote;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}