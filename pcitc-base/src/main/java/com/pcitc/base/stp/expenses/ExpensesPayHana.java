package com.pcitc.base.stp.expenses;

import java.io.Serializable;

/**
 * expenses_pay_hana
 * @author 
 */
public class ExpensesPayHana implements Serializable {
    /**
     * 主键
     */
    private String dataId;

    /**
     * G0LOGSYS
     */
    private String g0logsys;

    /**
     * 公司代码
     */
    private String g0gsdm;

    /**
     * 公司简称
     */
    private String g0gsjc;

    /**
     * 凭证ID
     */
    private String g0zpzid;

    /**
     * 费用报销系统业务单号
     */
    private String g0zecsid;

    /**
     * 凭证中的过帐日期
     */
    private String g0budat;

    /**
     * TMS指令提交系统交易流水码
     */
    private String g0ztmsvoucherid;

    /**
     * 会计凭证编号
     */
    private String g0belnr;

    /**
     * 会计凭证年
     */
    private String g0gjahr;

    /**
     * 清算单据的单据号码
     */
    private String g0augbl;

    /**
     * 清帐日期
     */
    private String g0augdt;

    /**
     * 供应商或债权人的帐号
     */
    private String g0lifnr;

    /**
     * 本位金额
     */
    private String k0dmbtr;

    /**
     * K0COUNTER
     */
    private String k0counter;

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
     * 科研项目合同号，从备注信息中提取
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

    public String getG0logsys() {
        return g0logsys;
    }

    public void setG0logsys(String g0logsys) {
        this.g0logsys = g0logsys;
    }

    public String getG0gsdm() {
        return g0gsdm;
    }

    public void setG0gsdm(String g0gsdm) {
        this.g0gsdm = g0gsdm;
    }

    public String getG0gsjc() {
        return g0gsjc;
    }

    public void setG0gsjc(String g0gsjc) {
        this.g0gsjc = g0gsjc;
    }

    public String getG0zpzid() {
        return g0zpzid;
    }

    public void setG0zpzid(String g0zpzid) {
        this.g0zpzid = g0zpzid;
    }

    public String getG0zecsid() {
        return g0zecsid;
    }

    public void setG0zecsid(String g0zecsid) {
        this.g0zecsid = g0zecsid;
    }

    public String getG0budat() {
        return g0budat;
    }

    public void setG0budat(String g0budat) {
        this.g0budat = g0budat;
    }

    public String getG0ztmsvoucherid() {
        return g0ztmsvoucherid;
    }

    public void setG0ztmsvoucherid(String g0ztmsvoucherid) {
        this.g0ztmsvoucherid = g0ztmsvoucherid;
    }

    public String getG0belnr() {
        return g0belnr;
    }

    public void setG0belnr(String g0belnr) {
        this.g0belnr = g0belnr;
    }

    public String getG0gjahr() {
        return g0gjahr;
    }

    public void setG0gjahr(String g0gjahr) {
        this.g0gjahr = g0gjahr;
    }

    public String getG0augbl() {
        return g0augbl;
    }

    public void setG0augbl(String g0augbl) {
        this.g0augbl = g0augbl;
    }

    public String getG0augdt() {
        return g0augdt;
    }

    public void setG0augdt(String g0augdt) {
        this.g0augdt = g0augdt;
    }

    public String getG0lifnr() {
        return g0lifnr;
    }

    public void setG0lifnr(String g0lifnr) {
        this.g0lifnr = g0lifnr;
    }

    public String getK0dmbtr() {
        return k0dmbtr;
    }

    public void setK0dmbtr(String k0dmbtr) {
        this.k0dmbtr = k0dmbtr;
    }

    public String getK0counter() {
        return k0counter;
    }

    public void setK0counter(String k0counter) {
        this.k0counter = k0counter;
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
        ExpensesPayHana other = (ExpensesPayHana) that;
        return (this.getDataId() == null ? other.getDataId() == null : this.getDataId().equals(other.getDataId()))
            && (this.getG0logsys() == null ? other.getG0logsys() == null : this.getG0logsys().equals(other.getG0logsys()))
            && (this.getG0gsdm() == null ? other.getG0gsdm() == null : this.getG0gsdm().equals(other.getG0gsdm()))
            && (this.getG0gsjc() == null ? other.getG0gsjc() == null : this.getG0gsjc().equals(other.getG0gsjc()))
            && (this.getG0zpzid() == null ? other.getG0zpzid() == null : this.getG0zpzid().equals(other.getG0zpzid()))
            && (this.getG0zecsid() == null ? other.getG0zecsid() == null : this.getG0zecsid().equals(other.getG0zecsid()))
            && (this.getG0budat() == null ? other.getG0budat() == null : this.getG0budat().equals(other.getG0budat()))
            && (this.getG0ztmsvoucherid() == null ? other.getG0ztmsvoucherid() == null : this.getG0ztmsvoucherid().equals(other.getG0ztmsvoucherid()))
            && (this.getG0belnr() == null ? other.getG0belnr() == null : this.getG0belnr().equals(other.getG0belnr()))
            && (this.getG0gjahr() == null ? other.getG0gjahr() == null : this.getG0gjahr().equals(other.getG0gjahr()))
            && (this.getG0augbl() == null ? other.getG0augbl() == null : this.getG0augbl().equals(other.getG0augbl()))
            && (this.getG0augdt() == null ? other.getG0augdt() == null : this.getG0augdt().equals(other.getG0augdt()))
            && (this.getG0lifnr() == null ? other.getG0lifnr() == null : this.getG0lifnr().equals(other.getG0lifnr()))
            && (this.getK0dmbtr() == null ? other.getK0dmbtr() == null : this.getK0dmbtr().equals(other.getK0dmbtr()))
            && (this.getK0counter() == null ? other.getK0counter() == null : this.getK0counter().equals(other.getK0counter()))
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
        result = prime * result + ((getG0logsys() == null) ? 0 : getG0logsys().hashCode());
        result = prime * result + ((getG0gsdm() == null) ? 0 : getG0gsdm().hashCode());
        result = prime * result + ((getG0gsjc() == null) ? 0 : getG0gsjc().hashCode());
        result = prime * result + ((getG0zpzid() == null) ? 0 : getG0zpzid().hashCode());
        result = prime * result + ((getG0zecsid() == null) ? 0 : getG0zecsid().hashCode());
        result = prime * result + ((getG0budat() == null) ? 0 : getG0budat().hashCode());
        result = prime * result + ((getG0ztmsvoucherid() == null) ? 0 : getG0ztmsvoucherid().hashCode());
        result = prime * result + ((getG0belnr() == null) ? 0 : getG0belnr().hashCode());
        result = prime * result + ((getG0gjahr() == null) ? 0 : getG0gjahr().hashCode());
        result = prime * result + ((getG0augbl() == null) ? 0 : getG0augbl().hashCode());
        result = prime * result + ((getG0augdt() == null) ? 0 : getG0augdt().hashCode());
        result = prime * result + ((getG0lifnr() == null) ? 0 : getG0lifnr().hashCode());
        result = prime * result + ((getK0dmbtr() == null) ? 0 : getK0dmbtr().hashCode());
        result = prime * result + ((getK0counter() == null) ? 0 : getK0counter().hashCode());
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
        sb.append(", g0logsys=").append(g0logsys);
        sb.append(", g0gsdm=").append(g0gsdm);
        sb.append(", g0gsjc=").append(g0gsjc);
        sb.append(", g0zpzid=").append(g0zpzid);
        sb.append(", g0zecsid=").append(g0zecsid);
        sb.append(", g0budat=").append(g0budat);
        sb.append(", g0ztmsvoucherid=").append(g0ztmsvoucherid);
        sb.append(", g0belnr=").append(g0belnr);
        sb.append(", g0gjahr=").append(g0gjahr);
        sb.append(", g0augbl=").append(g0augbl);
        sb.append(", g0augdt=").append(g0augdt);
        sb.append(", g0lifnr=").append(g0lifnr);
        sb.append(", k0dmbtr=").append(k0dmbtr);
        sb.append(", k0counter=").append(k0counter);
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