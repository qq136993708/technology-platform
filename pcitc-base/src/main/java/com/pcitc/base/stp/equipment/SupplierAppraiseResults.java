package com.pcitc.base.stp.equipment;

import java.math.BigDecimal;

public class SupplierAppraiseResults {
    private String supplierName;//供应商名称

    private Integer purchaseSum;//采购订单总数

    private BigDecimal purchaseMoneySum;//采购订单总金额

    private Integer _A;//优

    private Integer _B;//良

    private Integer _C;//中

    private Integer _D;//差

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Integer getPurchaseSum() {
        return purchaseSum;
    }

    public void setPurchaseSum(Integer purchaseSum) {
        this.purchaseSum = purchaseSum;
    }

    public BigDecimal getPurchaseMoneySum() {
        return purchaseMoneySum;
    }

    public void setPurchaseMoneySum(BigDecimal purchaseMoneySum) {
        this.purchaseMoneySum = purchaseMoneySum;
    }

    public Integer get_A() {
        return _A;
    }

    public void set_A(Integer _A) {
        this._A = _A;
    }

    public Integer get_B() {
        return _B;
    }

    public void set_B(Integer _B) {
        this._B = _B;
    }

    public Integer get_C() {
        return _C;
    }

    public void set_C(Integer _C) {
        this._C = _C;
    }

    public Integer get_D() {
        return _D;
    }

    public void set_D(Integer _D) {
        this._D = _D;
    }
}
