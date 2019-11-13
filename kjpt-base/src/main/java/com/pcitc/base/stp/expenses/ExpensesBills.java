package com.pcitc.base.stp.expenses;

import java.io.Serializable;
import java.util.List;

/**
 * expenses_bills
 * @author 
 */
public class ExpensesBills implements Serializable {
    /**
     * 主键
     */
    private String dataId;

    /**
     * 单据类型编码
     */
    private String billtypecode;

    /**
     * 单据类型名称
     */
    private String billtypename;

    /**
     * 单据编号
     */
    private String billcode;

    /**
     * 申请日期
     */
    private String applydate;

    /**
     * 公司代码
     */
    private String compcode;

    /**
     * 公司名称
     */
    private String compname;

    /**
     * 费用部门名称
     */
    private String approrgname;

    /**
     * 费用部门编码
     */
    private String approrgcode;

    /**
     * 成本中心名称
     */
    private String costcentname;

    /**
     * 成本中心编码
     */
    private String costcentcode;

    /**
     * 经办人编码
     */
    private String applyempid;

    /**
     * 经办人名称
     */
    private String applyempname;

    /**
     * 报销人编码
     */
    private String reimcode;

    /**
     * 报销人名称
     */
    private String reimname;

    /**
     * 项目名称
     */
    private String accoobjvaluedesc;

    /**
     * 项目编码
     */
    private String accoobjvalue;

    /**
     * 报销金额
     */
    private String billamount;

    /**
     * 是否投资1：是 0：否
     */
    private String investment;

    /**
     * 预付款抵扣金额
     */
    private String deductionamount;

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
    
    private List<ExpensesBillsPay> payList;
    private List<ExpensesBillsItem> itemList;
    private List<ExpensesBillsApproves> apprList;

    private static final long serialVersionUID = 1L;
    
    public List<ExpensesBillsPay> getPayList() {
		return payList;
	}

	public void setPayList(List<ExpensesBillsPay> payList) {
		this.payList = payList;
	}

	public List<ExpensesBillsItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<ExpensesBillsItem> itemList) {
		this.itemList = itemList;
	}

	public List<ExpensesBillsApproves> getApprList() {
		return apprList;
	}

	public void setApprList(List<ExpensesBillsApproves> apprList) {
		this.apprList = apprList;
	}

	public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getBilltypecode() {
        return billtypecode;
    }

    public void setBilltypecode(String billtypecode) {
        this.billtypecode = billtypecode;
    }

    public String getBilltypename() {
        return billtypename;
    }

    public void setBilltypename(String billtypename) {
        this.billtypename = billtypename;
    }

    public String getBillcode() {
        return billcode;
    }

    public void setBillcode(String billcode) {
        this.billcode = billcode;
    }

    public String getApplydate() {
        return applydate;
    }

    public void setApplydate(String applydate) {
        this.applydate = applydate;
    }

    public String getCompcode() {
        return compcode;
    }

    public void setCompcode(String compcode) {
        this.compcode = compcode;
    }

    public String getCompname() {
        return compname;
    }

    public void setCompname(String compname) {
        this.compname = compname;
    }

    public String getApprorgname() {
        return approrgname;
    }

    public void setApprorgname(String approrgname) {
        this.approrgname = approrgname;
    }

    public String getApprorgcode() {
        return approrgcode;
    }

    public void setApprorgcode(String approrgcode) {
        this.approrgcode = approrgcode;
    }

    public String getCostcentname() {
        return costcentname;
    }

    public void setCostcentname(String costcentname) {
        this.costcentname = costcentname;
    }

    public String getCostcentcode() {
        return costcentcode;
    }

    public void setCostcentcode(String costcentcode) {
        this.costcentcode = costcentcode;
    }

    public String getApplyempid() {
        return applyempid;
    }

    public void setApplyempid(String applyempid) {
        this.applyempid = applyempid;
    }

    public String getApplyempname() {
        return applyempname;
    }

    public void setApplyempname(String applyempname) {
        this.applyempname = applyempname;
    }

    public String getReimcode() {
        return reimcode;
    }

    public void setReimcode(String reimcode) {
        this.reimcode = reimcode;
    }

    public String getReimname() {
        return reimname;
    }

    public void setReimname(String reimname) {
        this.reimname = reimname;
    }

    public String getAccoobjvaluedesc() {
        return accoobjvaluedesc;
    }

    public void setAccoobjvaluedesc(String accoobjvaluedesc) {
        this.accoobjvaluedesc = accoobjvaluedesc;
    }

    public String getAccoobjvalue() {
        return accoobjvalue;
    }

    public void setAccoobjvalue(String accoobjvalue) {
        this.accoobjvalue = accoobjvalue;
    }

    public String getBillamount() {
        return billamount;
    }

    public void setBillamount(String billamount) {
        this.billamount = billamount;
    }

    public String getInvestment() {
        return investment;
    }

    public void setInvestment(String investment) {
        this.investment = investment;
    }

    public String getDeductionamount() {
        return deductionamount;
    }

    public void setDeductionamount(String deductionamount) {
        this.deductionamount = deductionamount;
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
        ExpensesBills other = (ExpensesBills) that;
        return (this.getDataId() == null ? other.getDataId() == null : this.getDataId().equals(other.getDataId()))
            && (this.getBilltypecode() == null ? other.getBilltypecode() == null : this.getBilltypecode().equals(other.getBilltypecode()))
            && (this.getBilltypename() == null ? other.getBilltypename() == null : this.getBilltypename().equals(other.getBilltypename()))
            && (this.getBillcode() == null ? other.getBillcode() == null : this.getBillcode().equals(other.getBillcode()))
            && (this.getApplydate() == null ? other.getApplydate() == null : this.getApplydate().equals(other.getApplydate()))
            && (this.getCompcode() == null ? other.getCompcode() == null : this.getCompcode().equals(other.getCompcode()))
            && (this.getCompname() == null ? other.getCompname() == null : this.getCompname().equals(other.getCompname()))
            && (this.getApprorgname() == null ? other.getApprorgname() == null : this.getApprorgname().equals(other.getApprorgname()))
            && (this.getApprorgcode() == null ? other.getApprorgcode() == null : this.getApprorgcode().equals(other.getApprorgcode()))
            && (this.getCostcentname() == null ? other.getCostcentname() == null : this.getCostcentname().equals(other.getCostcentname()))
            && (this.getCostcentcode() == null ? other.getCostcentcode() == null : this.getCostcentcode().equals(other.getCostcentcode()))
            && (this.getApplyempid() == null ? other.getApplyempid() == null : this.getApplyempid().equals(other.getApplyempid()))
            && (this.getApplyempname() == null ? other.getApplyempname() == null : this.getApplyempname().equals(other.getApplyempname()))
            && (this.getReimcode() == null ? other.getReimcode() == null : this.getReimcode().equals(other.getReimcode()))
            && (this.getReimname() == null ? other.getReimname() == null : this.getReimname().equals(other.getReimname()))
            && (this.getAccoobjvaluedesc() == null ? other.getAccoobjvaluedesc() == null : this.getAccoobjvaluedesc().equals(other.getAccoobjvaluedesc()))
            && (this.getAccoobjvalue() == null ? other.getAccoobjvalue() == null : this.getAccoobjvalue().equals(other.getAccoobjvalue()))
            && (this.getBillamount() == null ? other.getBillamount() == null : this.getBillamount().equals(other.getBillamount()))
            && (this.getInvestment() == null ? other.getInvestment() == null : this.getInvestment().equals(other.getInvestment()))
            && (this.getDeductionamount() == null ? other.getDeductionamount() == null : this.getDeductionamount().equals(other.getDeductionamount()))
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
        result = prime * result + ((getBilltypecode() == null) ? 0 : getBilltypecode().hashCode());
        result = prime * result + ((getBilltypename() == null) ? 0 : getBilltypename().hashCode());
        result = prime * result + ((getBillcode() == null) ? 0 : getBillcode().hashCode());
        result = prime * result + ((getApplydate() == null) ? 0 : getApplydate().hashCode());
        result = prime * result + ((getCompcode() == null) ? 0 : getCompcode().hashCode());
        result = prime * result + ((getCompname() == null) ? 0 : getCompname().hashCode());
        result = prime * result + ((getApprorgname() == null) ? 0 : getApprorgname().hashCode());
        result = prime * result + ((getApprorgcode() == null) ? 0 : getApprorgcode().hashCode());
        result = prime * result + ((getCostcentname() == null) ? 0 : getCostcentname().hashCode());
        result = prime * result + ((getCostcentcode() == null) ? 0 : getCostcentcode().hashCode());
        result = prime * result + ((getApplyempid() == null) ? 0 : getApplyempid().hashCode());
        result = prime * result + ((getApplyempname() == null) ? 0 : getApplyempname().hashCode());
        result = prime * result + ((getReimcode() == null) ? 0 : getReimcode().hashCode());
        result = prime * result + ((getReimname() == null) ? 0 : getReimname().hashCode());
        result = prime * result + ((getAccoobjvaluedesc() == null) ? 0 : getAccoobjvaluedesc().hashCode());
        result = prime * result + ((getAccoobjvalue() == null) ? 0 : getAccoobjvalue().hashCode());
        result = prime * result + ((getBillamount() == null) ? 0 : getBillamount().hashCode());
        result = prime * result + ((getInvestment() == null) ? 0 : getInvestment().hashCode());
        result = prime * result + ((getDeductionamount() == null) ? 0 : getDeductionamount().hashCode());
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
        sb.append(", billtypecode=").append(billtypecode);
        sb.append(", billtypename=").append(billtypename);
        sb.append(", billcode=").append(billcode);
        sb.append(", applydate=").append(applydate);
        sb.append(", compcode=").append(compcode);
        sb.append(", compname=").append(compname);
        sb.append(", approrgname=").append(approrgname);
        sb.append(", approrgcode=").append(approrgcode);
        sb.append(", costcentname=").append(costcentname);
        sb.append(", costcentcode=").append(costcentcode);
        sb.append(", applyempid=").append(applyempid);
        sb.append(", applyempname=").append(applyempname);
        sb.append(", reimcode=").append(reimcode);
        sb.append(", reimname=").append(reimname);
        sb.append(", accoobjvaluedesc=").append(accoobjvaluedesc);
        sb.append(", accoobjvalue=").append(accoobjvalue);
        sb.append(", billamount=").append(billamount);
        sb.append(", investment=").append(investment);
        sb.append(", deductionamount=").append(deductionamount);
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