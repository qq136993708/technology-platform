package com.pcitc.base.stp.expenses;

import java.io.Serializable;

/**
 * expenses_bills_item
 * @author 
 */
public class ExpensesBillsItem implements Serializable {
    /**
     * 主键
     */
    private String dataId;

    /**
     * 单据编号
     */
    private String billcode;

    /**
     * 三级费用项目编码
     */
    private String exptypecode;

    /**
     * 三级费用项目名称
     */
    private String exptypename;

    /**
     * 四级费用项目编码
     */
    private String exptypefourth;

    /**
     * 四级费用项目名称
     */
    private String exptypefourthname;

    /**
     * 供应商编码
     */
    private String suppcode;

    /**
     * 供应商名称
     */
    private String suppname;

    /**
     * 发票金额
     */
    private String expamount;

    /**
     * 支付金额
     */
    private String currentamount;

    /**
     * 编码
     */
    private String dataCode;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建人id
     */
    private String createUserId;

    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 修改人
     */
    private String updateUser;

    /**
     * 修改时间
     */
    private String updateDate;

    /**
     * 状态
     */
    private String sts;

    /**
     * 注释
     */
    private String remarks;

    /**
     * 备用
     */
    private String bak1;

    /**
     * 备用
     */
    private String bak2;

    /**
     * 备用
     */
    private String bak3;

    /**
     * 备用
     */
    private String bak4;

    /**
     * 备用
     */
    private String bak5;

    /**
     * 备用
     */
    private String bak6;

    /**
     * 备用
     */
    private String bak7;

    /**
     * 备用
     */
    private String bak8;

    /**
     * 备用
     */
    private String bak9;

    private static final long serialVersionUID = 1L;

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getBillcode() {
        return billcode;
    }

    public void setBillcode(String billcode) {
        this.billcode = billcode;
    }

    public String getExptypecode() {
        return exptypecode;
    }

    public void setExptypecode(String exptypecode) {
        this.exptypecode = exptypecode;
    }

    public String getExptypename() {
        return exptypename;
    }

    public void setExptypename(String exptypename) {
        this.exptypename = exptypename;
    }

    public String getExptypefourth() {
        return exptypefourth;
    }

    public void setExptypefourth(String exptypefourth) {
        this.exptypefourth = exptypefourth;
    }

    public String getExptypefourthname() {
        return exptypefourthname;
    }

    public void setExptypefourthname(String exptypefourthname) {
        this.exptypefourthname = exptypefourthname;
    }

    public String getSuppcode() {
        return suppcode;
    }

    public void setSuppcode(String suppcode) {
        this.suppcode = suppcode;
    }

    public String getSuppname() {
        return suppname;
    }

    public void setSuppname(String suppname) {
        this.suppname = suppname;
    }

    public String getExpamount() {
        return expamount;
    }

    public void setExpamount(String expamount) {
        this.expamount = expamount;
    }

    public String getCurrentamount() {
        return currentamount;
    }

    public void setCurrentamount(String currentamount) {
        this.currentamount = currentamount;
    }

    public String getDataCode() {
        return dataCode;
    }

    public void setDataCode(String dataCode) {
        this.dataCode = dataCode;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getSts() {
        return sts;
    }

    public void setSts(String sts) {
        this.sts = sts;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getBak1() {
        return bak1;
    }

    public void setBak1(String bak1) {
        this.bak1 = bak1;
    }

    public String getBak2() {
        return bak2;
    }

    public void setBak2(String bak2) {
        this.bak2 = bak2;
    }

    public String getBak3() {
        return bak3;
    }

    public void setBak3(String bak3) {
        this.bak3 = bak3;
    }

    public String getBak4() {
        return bak4;
    }

    public void setBak4(String bak4) {
        this.bak4 = bak4;
    }

    public String getBak5() {
        return bak5;
    }

    public void setBak5(String bak5) {
        this.bak5 = bak5;
    }

    public String getBak6() {
        return bak6;
    }

    public void setBak6(String bak6) {
        this.bak6 = bak6;
    }

    public String getBak7() {
        return bak7;
    }

    public void setBak7(String bak7) {
        this.bak7 = bak7;
    }

    public String getBak8() {
        return bak8;
    }

    public void setBak8(String bak8) {
        this.bak8 = bak8;
    }

    public String getBak9() {
        return bak9;
    }

    public void setBak9(String bak9) {
        this.bak9 = bak9;
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
        ExpensesBillsItem other = (ExpensesBillsItem) that;
        return (this.getDataId() == null ? other.getDataId() == null : this.getDataId().equals(other.getDataId()))
            && (this.getBillcode() == null ? other.getBillcode() == null : this.getBillcode().equals(other.getBillcode()))
            && (this.getExptypecode() == null ? other.getExptypecode() == null : this.getExptypecode().equals(other.getExptypecode()))
            && (this.getExptypename() == null ? other.getExptypename() == null : this.getExptypename().equals(other.getExptypename()))
            && (this.getExptypefourth() == null ? other.getExptypefourth() == null : this.getExptypefourth().equals(other.getExptypefourth()))
            && (this.getExptypefourthname() == null ? other.getExptypefourthname() == null : this.getExptypefourthname().equals(other.getExptypefourthname()))
            && (this.getSuppcode() == null ? other.getSuppcode() == null : this.getSuppcode().equals(other.getSuppcode()))
            && (this.getSuppname() == null ? other.getSuppname() == null : this.getSuppname().equals(other.getSuppname()))
            && (this.getExpamount() == null ? other.getExpamount() == null : this.getExpamount().equals(other.getExpamount()))
            && (this.getCurrentamount() == null ? other.getCurrentamount() == null : this.getCurrentamount().equals(other.getCurrentamount()))
            && (this.getDataCode() == null ? other.getDataCode() == null : this.getDataCode().equals(other.getDataCode()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getSts() == null ? other.getSts() == null : this.getSts().equals(other.getSts()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
            && (this.getBak1() == null ? other.getBak1() == null : this.getBak1().equals(other.getBak1()))
            && (this.getBak2() == null ? other.getBak2() == null : this.getBak2().equals(other.getBak2()))
            && (this.getBak3() == null ? other.getBak3() == null : this.getBak3().equals(other.getBak3()))
            && (this.getBak4() == null ? other.getBak4() == null : this.getBak4().equals(other.getBak4()))
            && (this.getBak5() == null ? other.getBak5() == null : this.getBak5().equals(other.getBak5()))
            && (this.getBak6() == null ? other.getBak6() == null : this.getBak6().equals(other.getBak6()))
            && (this.getBak7() == null ? other.getBak7() == null : this.getBak7().equals(other.getBak7()))
            && (this.getBak8() == null ? other.getBak8() == null : this.getBak8().equals(other.getBak8()))
            && (this.getBak9() == null ? other.getBak9() == null : this.getBak9().equals(other.getBak9()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataId() == null) ? 0 : getDataId().hashCode());
        result = prime * result + ((getBillcode() == null) ? 0 : getBillcode().hashCode());
        result = prime * result + ((getExptypecode() == null) ? 0 : getExptypecode().hashCode());
        result = prime * result + ((getExptypename() == null) ? 0 : getExptypename().hashCode());
        result = prime * result + ((getExptypefourth() == null) ? 0 : getExptypefourth().hashCode());
        result = prime * result + ((getExptypefourthname() == null) ? 0 : getExptypefourthname().hashCode());
        result = prime * result + ((getSuppcode() == null) ? 0 : getSuppcode().hashCode());
        result = prime * result + ((getSuppname() == null) ? 0 : getSuppname().hashCode());
        result = prime * result + ((getExpamount() == null) ? 0 : getExpamount().hashCode());
        result = prime * result + ((getCurrentamount() == null) ? 0 : getCurrentamount().hashCode());
        result = prime * result + ((getDataCode() == null) ? 0 : getDataCode().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getSts() == null) ? 0 : getSts().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getBak1() == null) ? 0 : getBak1().hashCode());
        result = prime * result + ((getBak2() == null) ? 0 : getBak2().hashCode());
        result = prime * result + ((getBak3() == null) ? 0 : getBak3().hashCode());
        result = prime * result + ((getBak4() == null) ? 0 : getBak4().hashCode());
        result = prime * result + ((getBak5() == null) ? 0 : getBak5().hashCode());
        result = prime * result + ((getBak6() == null) ? 0 : getBak6().hashCode());
        result = prime * result + ((getBak7() == null) ? 0 : getBak7().hashCode());
        result = prime * result + ((getBak8() == null) ? 0 : getBak8().hashCode());
        result = prime * result + ((getBak9() == null) ? 0 : getBak9().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dataId=").append(dataId);
        sb.append(", billcode=").append(billcode);
        sb.append(", exptypecode=").append(exptypecode);
        sb.append(", exptypename=").append(exptypename);
        sb.append(", exptypefourth=").append(exptypefourth);
        sb.append(", exptypefourthname=").append(exptypefourthname);
        sb.append(", suppcode=").append(suppcode);
        sb.append(", suppname=").append(suppname);
        sb.append(", expamount=").append(expamount);
        sb.append(", currentamount=").append(currentamount);
        sb.append(", dataCode=").append(dataCode);
        sb.append(", createUser=").append(createUser);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", sts=").append(sts);
        sb.append(", remarks=").append(remarks);
        sb.append(", bak1=").append(bak1);
        sb.append(", bak2=").append(bak2);
        sb.append(", bak3=").append(bak3);
        sb.append(", bak4=").append(bak4);
        sb.append(", bak5=").append(bak5);
        sb.append(", bak6=").append(bak6);
        sb.append(", bak7=").append(bak7);
        sb.append(", bak8=").append(bak8);
        sb.append(", bak9=").append(bak9);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}