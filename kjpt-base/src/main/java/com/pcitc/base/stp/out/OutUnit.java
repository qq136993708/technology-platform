package com.pcitc.base.stp.out;

import java.io.Serializable;
import java.util.Date;

/**
 * out_unit
 * @author 
 */
public class OutUnit implements Serializable {
    private String dataId;

    /**
     * 鍗曚綅鍚嶇О
     */
    private String unitName;

    /**
     * 鍗曚綅缂栫爜
     */
    private String unitCode;

    /**
     * 鍗曚綅绠€绉?
     */
    private String unitAli;

    private String parentCode;

    /**
     * 绱㈠紩
     */
    private String unitIndex;

    /**
     * 灞傜骇
     */
    private String unitLevel;

    private String createUserId;

    private Date createDate;

    private String remarks;

    /**
     * 8绉嶇被鍨?
     */
    private String unitType;

    /**
     * 濡傛灉鏄爺绌堕櫌锛屾爣鏄庢槸浠€涔堢爺绌堕櫌
     */
    private String instituteName;

    private String define1;

    private String define2;

    private String define3;

    /**
     * 绯荤粺澶栧崟浣嶇紪鐮?
     */
    private String outUnitCode;

    /**
     * 鍗曚綅閫氳鍦板潃
     */
    private String unitAddress;

    /**
     * 閭斂缂栫爜
     */
    private String postCode;

    /**
     * 濞夋洑姹夋禒锝堛€?
     */
    private String superLeaderName;

    /**
     * 瀵偓閹寸兘鎽辩悰?
     */
    private String bankName;

    /**
     * 閾惰璐︽埛
     */
    private String bankAccount;

    /**
     * 鍗曚綅绫诲埆锛堟嫧娆惧垎绫伙級
     */
    private String outUnitType;

    /**
     * 椤圭洰璐熻矗浜?
     */
    private String projectLeaderName;

    /**
     * 椤圭洰璐熻矗浜鸿亴鍔?
     */
    private String projectLeaderPost;

    /**
     * 椤圭洰璐熻矗浜虹數璇?
     */
    private String projectLeaderPhone;

    /**
     * 鍏徃棰嗗浜洪偖绠?
     */
    private String projectLeaderEmail;

    /**
     * 璐㈠姟璐熻矗浜哄鍚?
     */
    private String paymentLeaderName;

    /**
     * 璐㈠姟璐熻矗浜鸿亴鍔?
     */
    private String paymentLeaderPost;

    /**
     * 璐㈠姟璐熻矗浜虹數璇?
     */
    private String paymentLeaderPhone;

    /**
     * 璐㈠姟璐熻矗浜洪偖绠?
     */
    private String paymentLeaderEmail;

    private String define4;

    private String define5;

    private String define6;

    private String define7;

    private String define8;

    private String define9;

    private static final long serialVersionUID = 1L;

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
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

    public String getUnitAli() {
        return unitAli;
    }

    public void setUnitAli(String unitAli) {
        this.unitAli = unitAli;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getUnitIndex() {
        return unitIndex;
    }

    public void setUnitIndex(String unitIndex) {
        this.unitIndex = unitIndex;
    }

    public String getUnitLevel() {
        return unitLevel;
    }

    public void setUnitLevel(String unitLevel) {
        this.unitLevel = unitLevel;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public String getDefine1() {
        return define1;
    }

    public void setDefine1(String define1) {
        this.define1 = define1;
    }

    public String getDefine2() {
        return define2;
    }

    public void setDefine2(String define2) {
        this.define2 = define2;
    }

    public String getDefine3() {
        return define3;
    }

    public void setDefine3(String define3) {
        this.define3 = define3;
    }

    public String getOutUnitCode() {
        return outUnitCode;
    }

    public void setOutUnitCode(String outUnitCode) {
        this.outUnitCode = outUnitCode;
    }

    public String getUnitAddress() {
        return unitAddress;
    }

    public void setUnitAddress(String unitAddress) {
        this.unitAddress = unitAddress;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getSuperLeaderName() {
        return superLeaderName;
    }

    public void setSuperLeaderName(String superLeaderName) {
        this.superLeaderName = superLeaderName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getOutUnitType() {
        return outUnitType;
    }

    public void setOutUnitType(String outUnitType) {
        this.outUnitType = outUnitType;
    }

    public String getProjectLeaderName() {
        return projectLeaderName;
    }

    public void setProjectLeaderName(String projectLeaderName) {
        this.projectLeaderName = projectLeaderName;
    }

    public String getProjectLeaderPost() {
        return projectLeaderPost;
    }

    public void setProjectLeaderPost(String projectLeaderPost) {
        this.projectLeaderPost = projectLeaderPost;
    }

    public String getProjectLeaderPhone() {
        return projectLeaderPhone;
    }

    public void setProjectLeaderPhone(String projectLeaderPhone) {
        this.projectLeaderPhone = projectLeaderPhone;
    }

    public String getProjectLeaderEmail() {
        return projectLeaderEmail;
    }

    public void setProjectLeaderEmail(String projectLeaderEmail) {
        this.projectLeaderEmail = projectLeaderEmail;
    }

    public String getPaymentLeaderName() {
        return paymentLeaderName;
    }

    public void setPaymentLeaderName(String paymentLeaderName) {
        this.paymentLeaderName = paymentLeaderName;
    }

    public String getPaymentLeaderPost() {
        return paymentLeaderPost;
    }

    public void setPaymentLeaderPost(String paymentLeaderPost) {
        this.paymentLeaderPost = paymentLeaderPost;
    }

    public String getPaymentLeaderPhone() {
        return paymentLeaderPhone;
    }

    public void setPaymentLeaderPhone(String paymentLeaderPhone) {
        this.paymentLeaderPhone = paymentLeaderPhone;
    }

    public String getPaymentLeaderEmail() {
        return paymentLeaderEmail;
    }

    public void setPaymentLeaderEmail(String paymentLeaderEmail) {
        this.paymentLeaderEmail = paymentLeaderEmail;
    }

    public String getDefine4() {
        return define4;
    }

    public void setDefine4(String define4) {
        this.define4 = define4;
    }

    public String getDefine5() {
        return define5;
    }

    public void setDefine5(String define5) {
        this.define5 = define5;
    }

    public String getDefine6() {
        return define6;
    }

    public void setDefine6(String define6) {
        this.define6 = define6;
    }

    public String getDefine7() {
        return define7;
    }

    public void setDefine7(String define7) {
        this.define7 = define7;
    }

    public String getDefine8() {
        return define8;
    }

    public void setDefine8(String define8) {
        this.define8 = define8;
    }

    public String getDefine9() {
        return define9;
    }

    public void setDefine9(String define9) {
        this.define9 = define9;
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
        OutUnit other = (OutUnit) that;
        return (this.getDataId() == null ? other.getDataId() == null : this.getDataId().equals(other.getDataId()))
            && (this.getUnitName() == null ? other.getUnitName() == null : this.getUnitName().equals(other.getUnitName()))
            && (this.getUnitCode() == null ? other.getUnitCode() == null : this.getUnitCode().equals(other.getUnitCode()))
            && (this.getUnitAli() == null ? other.getUnitAli() == null : this.getUnitAli().equals(other.getUnitAli()))
            && (this.getParentCode() == null ? other.getParentCode() == null : this.getParentCode().equals(other.getParentCode()))
            && (this.getUnitIndex() == null ? other.getUnitIndex() == null : this.getUnitIndex().equals(other.getUnitIndex()))
            && (this.getUnitLevel() == null ? other.getUnitLevel() == null : this.getUnitLevel().equals(other.getUnitLevel()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
            && (this.getUnitType() == null ? other.getUnitType() == null : this.getUnitType().equals(other.getUnitType()))
            && (this.getInstituteName() == null ? other.getInstituteName() == null : this.getInstituteName().equals(other.getInstituteName()))
            && (this.getDefine1() == null ? other.getDefine1() == null : this.getDefine1().equals(other.getDefine1()))
            && (this.getDefine2() == null ? other.getDefine2() == null : this.getDefine2().equals(other.getDefine2()))
            && (this.getDefine3() == null ? other.getDefine3() == null : this.getDefine3().equals(other.getDefine3()))
            && (this.getOutUnitCode() == null ? other.getOutUnitCode() == null : this.getOutUnitCode().equals(other.getOutUnitCode()))
            && (this.getUnitAddress() == null ? other.getUnitAddress() == null : this.getUnitAddress().equals(other.getUnitAddress()))
            && (this.getPostCode() == null ? other.getPostCode() == null : this.getPostCode().equals(other.getPostCode()))
            && (this.getSuperLeaderName() == null ? other.getSuperLeaderName() == null : this.getSuperLeaderName().equals(other.getSuperLeaderName()))
            && (this.getBankName() == null ? other.getBankName() == null : this.getBankName().equals(other.getBankName()))
            && (this.getBankAccount() == null ? other.getBankAccount() == null : this.getBankAccount().equals(other.getBankAccount()))
            && (this.getOutUnitType() == null ? other.getOutUnitType() == null : this.getOutUnitType().equals(other.getOutUnitType()))
            && (this.getProjectLeaderName() == null ? other.getProjectLeaderName() == null : this.getProjectLeaderName().equals(other.getProjectLeaderName()))
            && (this.getProjectLeaderPost() == null ? other.getProjectLeaderPost() == null : this.getProjectLeaderPost().equals(other.getProjectLeaderPost()))
            && (this.getProjectLeaderPhone() == null ? other.getProjectLeaderPhone() == null : this.getProjectLeaderPhone().equals(other.getProjectLeaderPhone()))
            && (this.getProjectLeaderEmail() == null ? other.getProjectLeaderEmail() == null : this.getProjectLeaderEmail().equals(other.getProjectLeaderEmail()))
            && (this.getPaymentLeaderName() == null ? other.getPaymentLeaderName() == null : this.getPaymentLeaderName().equals(other.getPaymentLeaderName()))
            && (this.getPaymentLeaderPost() == null ? other.getPaymentLeaderPost() == null : this.getPaymentLeaderPost().equals(other.getPaymentLeaderPost()))
            && (this.getPaymentLeaderPhone() == null ? other.getPaymentLeaderPhone() == null : this.getPaymentLeaderPhone().equals(other.getPaymentLeaderPhone()))
            && (this.getPaymentLeaderEmail() == null ? other.getPaymentLeaderEmail() == null : this.getPaymentLeaderEmail().equals(other.getPaymentLeaderEmail()))
            && (this.getDefine4() == null ? other.getDefine4() == null : this.getDefine4().equals(other.getDefine4()))
            && (this.getDefine5() == null ? other.getDefine5() == null : this.getDefine5().equals(other.getDefine5()))
            && (this.getDefine6() == null ? other.getDefine6() == null : this.getDefine6().equals(other.getDefine6()))
            && (this.getDefine7() == null ? other.getDefine7() == null : this.getDefine7().equals(other.getDefine7()))
            && (this.getDefine8() == null ? other.getDefine8() == null : this.getDefine8().equals(other.getDefine8()))
            && (this.getDefine9() == null ? other.getDefine9() == null : this.getDefine9().equals(other.getDefine9()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataId() == null) ? 0 : getDataId().hashCode());
        result = prime * result + ((getUnitName() == null) ? 0 : getUnitName().hashCode());
        result = prime * result + ((getUnitCode() == null) ? 0 : getUnitCode().hashCode());
        result = prime * result + ((getUnitAli() == null) ? 0 : getUnitAli().hashCode());
        result = prime * result + ((getParentCode() == null) ? 0 : getParentCode().hashCode());
        result = prime * result + ((getUnitIndex() == null) ? 0 : getUnitIndex().hashCode());
        result = prime * result + ((getUnitLevel() == null) ? 0 : getUnitLevel().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getUnitType() == null) ? 0 : getUnitType().hashCode());
        result = prime * result + ((getInstituteName() == null) ? 0 : getInstituteName().hashCode());
        result = prime * result + ((getDefine1() == null) ? 0 : getDefine1().hashCode());
        result = prime * result + ((getDefine2() == null) ? 0 : getDefine2().hashCode());
        result = prime * result + ((getDefine3() == null) ? 0 : getDefine3().hashCode());
        result = prime * result + ((getOutUnitCode() == null) ? 0 : getOutUnitCode().hashCode());
        result = prime * result + ((getUnitAddress() == null) ? 0 : getUnitAddress().hashCode());
        result = prime * result + ((getPostCode() == null) ? 0 : getPostCode().hashCode());
        result = prime * result + ((getSuperLeaderName() == null) ? 0 : getSuperLeaderName().hashCode());
        result = prime * result + ((getBankName() == null) ? 0 : getBankName().hashCode());
        result = prime * result + ((getBankAccount() == null) ? 0 : getBankAccount().hashCode());
        result = prime * result + ((getOutUnitType() == null) ? 0 : getOutUnitType().hashCode());
        result = prime * result + ((getProjectLeaderName() == null) ? 0 : getProjectLeaderName().hashCode());
        result = prime * result + ((getProjectLeaderPost() == null) ? 0 : getProjectLeaderPost().hashCode());
        result = prime * result + ((getProjectLeaderPhone() == null) ? 0 : getProjectLeaderPhone().hashCode());
        result = prime * result + ((getProjectLeaderEmail() == null) ? 0 : getProjectLeaderEmail().hashCode());
        result = prime * result + ((getPaymentLeaderName() == null) ? 0 : getPaymentLeaderName().hashCode());
        result = prime * result + ((getPaymentLeaderPost() == null) ? 0 : getPaymentLeaderPost().hashCode());
        result = prime * result + ((getPaymentLeaderPhone() == null) ? 0 : getPaymentLeaderPhone().hashCode());
        result = prime * result + ((getPaymentLeaderEmail() == null) ? 0 : getPaymentLeaderEmail().hashCode());
        result = prime * result + ((getDefine4() == null) ? 0 : getDefine4().hashCode());
        result = prime * result + ((getDefine5() == null) ? 0 : getDefine5().hashCode());
        result = prime * result + ((getDefine6() == null) ? 0 : getDefine6().hashCode());
        result = prime * result + ((getDefine7() == null) ? 0 : getDefine7().hashCode());
        result = prime * result + ((getDefine8() == null) ? 0 : getDefine8().hashCode());
        result = prime * result + ((getDefine9() == null) ? 0 : getDefine9().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dataId=").append(dataId);
        sb.append(", unitName=").append(unitName);
        sb.append(", unitCode=").append(unitCode);
        sb.append(", unitAli=").append(unitAli);
        sb.append(", parentCode=").append(parentCode);
        sb.append(", unitIndex=").append(unitIndex);
        sb.append(", unitLevel=").append(unitLevel);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", createDate=").append(createDate);
        sb.append(", remarks=").append(remarks);
        sb.append(", unitType=").append(unitType);
        sb.append(", instituteName=").append(instituteName);
        sb.append(", define1=").append(define1);
        sb.append(", define2=").append(define2);
        sb.append(", define3=").append(define3);
        sb.append(", outUnitCode=").append(outUnitCode);
        sb.append(", unitAddress=").append(unitAddress);
        sb.append(", postCode=").append(postCode);
        sb.append(", superLeaderName=").append(superLeaderName);
        sb.append(", bankName=").append(bankName);
        sb.append(", bankAccount=").append(bankAccount);
        sb.append(", outUnitType=").append(outUnitType);
        sb.append(", projectLeaderName=").append(projectLeaderName);
        sb.append(", projectLeaderPost=").append(projectLeaderPost);
        sb.append(", projectLeaderPhone=").append(projectLeaderPhone);
        sb.append(", projectLeaderEmail=").append(projectLeaderEmail);
        sb.append(", paymentLeaderName=").append(paymentLeaderName);
        sb.append(", paymentLeaderPost=").append(paymentLeaderPost);
        sb.append(", paymentLeaderPhone=").append(paymentLeaderPhone);
        sb.append(", paymentLeaderEmail=").append(paymentLeaderEmail);
        sb.append(", define4=").append(define4);
        sb.append(", define5=").append(define5);
        sb.append(", define6=").append(define6);
        sb.append(", define7=").append(define7);
        sb.append(", define8=").append(define8);
        sb.append(", define9=").append(define9);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}