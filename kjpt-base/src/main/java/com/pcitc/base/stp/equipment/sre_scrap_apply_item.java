package com.pcitc.base.stp.equipment;

import java.util.Date;

public class sre_scrap_apply_item {
    private String accountId;

    private String applyid;

    private String eqdetailid;

    private Date createDate;

    private String createUserId;

    private String updateUserId;

    private Date updateDate;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getApplyid() {
        return applyid;
    }

    public void setApplyid(String applyid) {
        this.applyid = applyid;
    }

    public String getEqdetailid() {
        return eqdetailid;
    }

    public void setEqdetailid(String eqdetailid) {
        this.eqdetailid = eqdetailid;
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

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}