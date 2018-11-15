package com.pcitc.base.engin.construct.subcontract;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * construct_result_detail
 * @author 
 */
public class ConstructResultDetailVo implements Serializable {
    /**
     * 主键ID
     */
    private String dataId;

    /**
     * 分包结果编号
     */
    private String resultId;

    /**
     * 拟分包工作性质
     */
    private String type;

    /**
     * 分包金额
     */
    private BigDecimal amount;

    /**
     * 分包发包方式
     */
    private String sendMode;

    /**
     * 分包发包组织形式
     */
    private String orgMode;

    /**
     * 分包商名称
     */
    private String unitName;

    /**
     * 分包商资质
     */
    private String unitQualify;

    /**
     * 诚信体系编号
     */
    private String creditSystemCode;

    /**
     * 项目经理
     */
    private String pm;

    private String workContent;

    /**
     * 备注
     */
    private String remark;

    private static final long serialVersionUID = 1L;

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getResultId() {
        return resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getSendMode() {
        return sendMode;
    }

    public void setSendMode(String sendMode) {
        this.sendMode = sendMode;
    }

    public String getOrgMode() {
        return orgMode;
    }

    public void setOrgMode(String orgMode) {
        this.orgMode = orgMode;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitQualify() {
        return unitQualify;
    }

    public void setUnitQualify(String unitQualify) {
        this.unitQualify = unitQualify;
    }

    public String getCreditSystemCode() {
        return creditSystemCode;
    }

    public void setCreditSystemCode(String creditSystemCode) {
        this.creditSystemCode = creditSystemCode;
    }

    public String getPm() {
        return pm;
    }

    public void setPm(String pm) {
        this.pm = pm;
    }

    public String getWorkContent() {
        return workContent;
    }

    public void setWorkContent(String workContent) {
        this.workContent = workContent;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}