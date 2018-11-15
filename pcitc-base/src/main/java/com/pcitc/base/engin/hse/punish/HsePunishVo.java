package com.pcitc.base.engin.hse.punish;

import com.pcitc.base.util.SearchInfo;

import java.io.Serializable;

/**
 * hse_punish
 * @author ms
 */
public class HsePunishVo extends SearchInfo implements Serializable {
    /**
     * 业务ID
     */
    private String dataId;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 最后修改人
     */
    private String updateUser;

    /**
     * 最后修改时间
     */
    private String updateDate;

    /**
     * 记录状态(1生效,0作废,默认1)
     */
    private String status;

    /**
     * 审批状态
     */
    private String auditStatus;

    /**
     * 公司代码
     */
    private String companyCode;

    /**
     * 所属项目
     */
    private String projectId;

    /**
     * 业务编码
     */
    private String formCode;

    /**
     * 登记单位
     */
    private String registUnit;

    /**
     * 登记单位编码
     */
    private String registUnitCode;

    /**
     * 登记人
     */
    private String registUser;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目编号
     */
    private String projectCode;

    /**
     * 处罚形式
     */
    private String punishKind;

    /**
     * 违章类别
     */
    private String punishType;

    /**
     * 登记日期
     */
    private String registDate;

    /**
     * 处罚编号
     */
    private String punishNo;

    /**
     * 地点
     */
    private String punishPlace;

    /**
     * 日期
     */
    private String punishDate;

    /**
     * 责任单位
     */
    private String punishUnit;

    /**
     * 责任单位编码
     */
    private String punishUnitCode;

    /**
     * 违章描述
     */
    private String punishDesc;

    /**
     * 考核内容
     */
    private String checkContent;

    /**
     * 考核条款
     */
    private String checkClause;

    /**
     * 整改意见
     */
    private String improveOpinion;

    /**
     * 考核标准(元)
     */
    private String checkStandard;

    /**
     * 扣分值(分)
     */
    private String deductMarks;

    /**
     * 下发状态
     */
    private String grantStatus;

    /**
     * 检查id
     */
    private String checkId;

    /**
     * 实际缴纳罚金
     */
    private String payMoney;

    /**
     * 缴纳日期
     */
    private String payDate;

    /**
     * 支付账户
     */
    private String payAccount;

    /**
     * 缴款状态(0未缴款1已缴款)
     */
    private String payStatus;

    private String ex;

    private String payMoneySum;
    private String deductMarksSum;
    private String checkStandardSum;

    private static final long serialVersionUID = 1L;

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getFormCode() {
        return formCode;
    }

    public void setFormCode(String formCode) {
        this.formCode = formCode;
    }

    public String getRegistUnit() {
        return registUnit;
    }

    public void setRegistUnit(String registUnit) {
        this.registUnit = registUnit;
    }

    public String getRegistUnitCode() {
        return registUnitCode;
    }

    public void setRegistUnitCode(String registUnitCode) {
        this.registUnitCode = registUnitCode;
    }

    public String getRegistUser() {
        return registUser;
    }

    public void setRegistUser(String registUser) {
        this.registUser = registUser;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getPunishKind() {
        return punishKind;
    }

    public void setPunishKind(String punishKind) {
        this.punishKind = punishKind;
    }

    public String getPunishType() {
        return punishType;
    }

    public void setPunishType(String punishType) {
        this.punishType = punishType;
    }

    public String getRegistDate() {
        return registDate;
    }

    public void setRegistDate(String registDate) {
        this.registDate = registDate;
    }

    public String getPunishNo() {
        return punishNo;
    }

    public void setPunishNo(String punishNo) {
        this.punishNo = punishNo;
    }

    public String getPunishPlace() {
        return punishPlace;
    }

    public void setPunishPlace(String punishPlace) {
        this.punishPlace = punishPlace;
    }

    public String getPunishDate() {
        return punishDate;
    }

    public void setPunishDate(String punishDate) {
        this.punishDate = punishDate;
    }

    public String getPunishUnit() {
        return punishUnit;
    }

    public void setPunishUnit(String punishUnit) {
        this.punishUnit = punishUnit;
    }

    public String getPunishUnitCode() {
        return punishUnitCode;
    }

    public void setPunishUnitCode(String punishUnitCode) {
        this.punishUnitCode = punishUnitCode;
    }

    public String getPunishDesc() {
        return punishDesc;
    }

    public void setPunishDesc(String punishDesc) {
        this.punishDesc = punishDesc;
    }

    public String getCheckContent() {
        return checkContent;
    }

    public void setCheckContent(String checkContent) {
        this.checkContent = checkContent;
    }

    public String getCheckClause() {
        return checkClause;
    }

    public void setCheckClause(String checkClause) {
        this.checkClause = checkClause;
    }

    public String getImproveOpinion() {
        return improveOpinion;
    }

    public void setImproveOpinion(String improveOpinion) {
        this.improveOpinion = improveOpinion;
    }

    public String getCheckStandard() {
        return checkStandard;
    }

    public void setCheckStandard(String checkStandard) {
        this.checkStandard = checkStandard;
    }

    public String getDeductMarks() {
        return deductMarks;
    }

    public void setDeductMarks(String deductMarks) {
        this.deductMarks = deductMarks;
    }

    public String getGrantStatus() {
        return grantStatus;
    }

    public void setGrantStatus(String grantStatus) {
        this.grantStatus = grantStatus;
    }

    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId;
    }

    public String getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(String payMoney) {
        this.payMoney = payMoney;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public String getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public String getPayMoneySum() {
        return payMoneySum;
    }

    public void setPayMoneySum(String payMoneySum) {
        this.payMoneySum = payMoneySum;
    }

    public String getDeductMarksSum() {
        return deductMarksSum;
    }

    public void setDeductMarksSum(String deductMarksSum) {
        this.deductMarksSum = deductMarksSum;
    }

    public String getCheckStandardSum() {
        return checkStandardSum;
    }

    public void setCheckStandardSum(String checkStandardSum) {
        this.checkStandardSum = checkStandardSum;
    }
}