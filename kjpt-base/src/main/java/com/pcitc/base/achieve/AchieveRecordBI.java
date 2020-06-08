package com.pcitc.base.achieve;

import com.pcitc.base.common.RecordModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *备案表--驾驶舱
 * @author
 */
public class AchieveRecordBI extends AchieveRecord {

    /**
     * 成果完成金额
     */
    private BigDecimal transMoneySum = new BigDecimal("0");

    /**
     * 成果完成数量
     */
    private int transAmount = 0;

    /**
     * 年份
     */
    private String year;

    public BigDecimal getTransMoneySum() {
        return transMoneySum;
    }

    public void setTransMoneySum(BigDecimal transMoneySum) {
        this.transMoneySum = transMoneySum;
    }

    public int getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(int transAmount) {
        this.transAmount = transAmount;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
