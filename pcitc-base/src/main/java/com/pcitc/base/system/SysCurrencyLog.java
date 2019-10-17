package com.pcitc.base.system;

import java.io.Serializable;

/**
 * sys_currency_log
 * @author 
 */
public class SysCurrencyLog implements Serializable {
    private String dataId;

    private String logName;

    private String logTime;

    private String descT1;

    private String descT2;

    private String descT3;

    private String descT4;

    private String descT5;

    private String dataT1;

    private String dataT2;

    private String dataT3;

    private String dataT4;

    private String dataT5;

    private String dataT6;

    private String dataT7;

    private String dataT8;

    private String dataT9;

    private static final long serialVersionUID = 1L;

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public String getLogTime() {
        return logTime;
    }

    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }

    public String getDescT1() {
        return descT1;
    }

    public void setDescT1(String descT1) {
        this.descT1 = descT1;
    }

    public String getDescT2() {
        return descT2;
    }

    public void setDescT2(String descT2) {
        this.descT2 = descT2;
    }

    public String getDescT3() {
        return descT3;
    }

    public void setDescT3(String descT3) {
        this.descT3 = descT3;
    }

    public String getDescT4() {
        return descT4;
    }

    public void setDescT4(String descT4) {
        this.descT4 = descT4;
    }

    public String getDescT5() {
        return descT5;
    }

    public void setDescT5(String descT5) {
        this.descT5 = descT5;
    }

    public String getDataT1() {
        return dataT1;
    }

    public void setDataT1(String dataT1) {
        this.dataT1 = dataT1;
    }

    public String getDataT2() {
        return dataT2;
    }

    public void setDataT2(String dataT2) {
        this.dataT2 = dataT2;
    }

    public String getDataT3() {
        return dataT3;
    }

    public void setDataT3(String dataT3) {
        this.dataT3 = dataT3;
    }

    public String getDataT4() {
        return dataT4;
    }

    public void setDataT4(String dataT4) {
        this.dataT4 = dataT4;
    }

    public String getDataT5() {
        return dataT5;
    }

    public void setDataT5(String dataT5) {
        this.dataT5 = dataT5;
    }

    public String getDataT6() {
        return dataT6;
    }

    public void setDataT6(String dataT6) {
        this.dataT6 = dataT6;
    }

    public String getDataT7() {
        return dataT7;
    }

    public void setDataT7(String dataT7) {
        this.dataT7 = dataT7;
    }

    public String getDataT8() {
        return dataT8;
    }

    public void setDataT8(String dataT8) {
        this.dataT8 = dataT8;
    }

    public String getDataT9() {
        return dataT9;
    }

    public void setDataT9(String dataT9) {
        this.dataT9 = dataT9;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysCurrencyLog other = (SysCurrencyLog) that;
        return (this.getDataId() == null ? other.getDataId() == null : this.getDataId().equals(other.getDataId()))
            && (this.getLogName() == null ? other.getLogName() == null : this.getLogName().equals(other.getLogName()))
            && (this.getLogTime() == null ? other.getLogTime() == null : this.getLogTime().equals(other.getLogTime()))
            && (this.getDescT1() == null ? other.getDescT1() == null : this.getDescT1().equals(other.getDescT1()))
            && (this.getDescT2() == null ? other.getDescT2() == null : this.getDescT2().equals(other.getDescT2()))
            && (this.getDescT3() == null ? other.getDescT3() == null : this.getDescT3().equals(other.getDescT3()))
            && (this.getDescT4() == null ? other.getDescT4() == null : this.getDescT4().equals(other.getDescT4()))
            && (this.getDescT5() == null ? other.getDescT5() == null : this.getDescT5().equals(other.getDescT5()))
            && (this.getDataT1() == null ? other.getDataT1() == null : this.getDataT1().equals(other.getDataT1()))
            && (this.getDataT2() == null ? other.getDataT2() == null : this.getDataT2().equals(other.getDataT2()))
            && (this.getDataT3() == null ? other.getDataT3() == null : this.getDataT3().equals(other.getDataT3()))
            && (this.getDataT4() == null ? other.getDataT4() == null : this.getDataT4().equals(other.getDataT4()))
            && (this.getDataT5() == null ? other.getDataT5() == null : this.getDataT5().equals(other.getDataT5()))
            && (this.getDataT6() == null ? other.getDataT6() == null : this.getDataT6().equals(other.getDataT6()))
            && (this.getDataT7() == null ? other.getDataT7() == null : this.getDataT7().equals(other.getDataT7()))
            && (this.getDataT8() == null ? other.getDataT8() == null : this.getDataT8().equals(other.getDataT8()))
            && (this.getDataT9() == null ? other.getDataT9() == null : this.getDataT9().equals(other.getDataT9()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataId() == null) ? 0 : getDataId().hashCode());
        result = prime * result + ((getLogName() == null) ? 0 : getLogName().hashCode());
        result = prime * result + ((getLogTime() == null) ? 0 : getLogTime().hashCode());
        result = prime * result + ((getDescT1() == null) ? 0 : getDescT1().hashCode());
        result = prime * result + ((getDescT2() == null) ? 0 : getDescT2().hashCode());
        result = prime * result + ((getDescT3() == null) ? 0 : getDescT3().hashCode());
        result = prime * result + ((getDescT4() == null) ? 0 : getDescT4().hashCode());
        result = prime * result + ((getDescT5() == null) ? 0 : getDescT5().hashCode());
        result = prime * result + ((getDataT1() == null) ? 0 : getDataT1().hashCode());
        result = prime * result + ((getDataT2() == null) ? 0 : getDataT2().hashCode());
        result = prime * result + ((getDataT3() == null) ? 0 : getDataT3().hashCode());
        result = prime * result + ((getDataT4() == null) ? 0 : getDataT4().hashCode());
        result = prime * result + ((getDataT5() == null) ? 0 : getDataT5().hashCode());
        result = prime * result + ((getDataT6() == null) ? 0 : getDataT6().hashCode());
        result = prime * result + ((getDataT7() == null) ? 0 : getDataT7().hashCode());
        result = prime * result + ((getDataT8() == null) ? 0 : getDataT8().hashCode());
        result = prime * result + ((getDataT9() == null) ? 0 : getDataT9().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dataId=").append(dataId);
        sb.append(", logName=").append(logName);
        sb.append(", logTime=").append(logTime);
        sb.append(", descT1=").append(descT1);
        sb.append(", descT2=").append(descT2);
        sb.append(", descT3=").append(descT3);
        sb.append(", descT4=").append(descT4);
        sb.append(", descT5=").append(descT5);
        sb.append(", dataT1=").append(dataT1);
        sb.append(", dataT2=").append(dataT2);
        sb.append(", dataT3=").append(dataT3);
        sb.append(", dataT4=").append(dataT4);
        sb.append(", dataT5=").append(dataT5);
        sb.append(", dataT6=").append(dataT6);
        sb.append(", dataT7=").append(dataT7);
        sb.append(", dataT8=").append(dataT8);
        sb.append(", dataT9=").append(dataT9);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}