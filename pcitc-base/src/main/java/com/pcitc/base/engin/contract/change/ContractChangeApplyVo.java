package com.pcitc.base.engin.contract.change;

import com.pcitc.base.util.SearchInfo;

import java.io.Serializable;

/**
 * contract_change_apply
 * @author 
 */
public class ContractChangeApplyVo extends SearchInfo implements Serializable {
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
     * 项目名称
     */
    private String projectName;

    /**
     * 项目编号
     */
    private String projectCode;

    /**
     * 合同名称
     */
    private String contractName;

    /**
     * 合同编号
     */
    private String contractNo;

    /**
     * 承包商
     */
    private String comName;

    /**
     * 变更申请编号
     */
    private String changeApplyNo;

    /**
     * 变更发起单位
     */
    private String changeUnitName;

    /**
     * 变更主题
     */
    private String changeTopic;

    /**
     * 变更申请接收日期
     */
    private String changeApplyReceiveDate;

    /**
     * 变更申请回复日期
     */
    private String changeApplyReplyDate;

    /**
     * 变更申请生效日期
     */
    private String changeApplyEffectDate;

    /**
     * 变更原因类型
     */
    private String changeReasonType;

    /**
     * 变更价格类型
     */
    private String changePriceType;

    /**
     * 变更原因和内容
     */
    private String changeContent;

    /**
     * 其他
     */
    private String ex;

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

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getChangeApplyNo() {
        return changeApplyNo;
    }

    public void setChangeApplyNo(String changeApplyNo) {
        this.changeApplyNo = changeApplyNo;
    }

    public String getChangeUnitName() {
        return changeUnitName;
    }

    public void setChangeUnitName(String changeUnitName) {
        this.changeUnitName = changeUnitName;
    }

    public String getChangeTopic() {
        return changeTopic;
    }

    public void setChangeTopic(String changeTopic) {
        this.changeTopic = changeTopic;
    }

    public String getChangeApplyReceiveDate() {
        return changeApplyReceiveDate;
    }

    public void setChangeApplyReceiveDate(String changeApplyReceiveDate) {
        this.changeApplyReceiveDate = changeApplyReceiveDate;
    }

    public String getChangeApplyReplyDate() {
        return changeApplyReplyDate;
    }

    public void setChangeApplyReplyDate(String changeApplyReplyDate) {
        this.changeApplyReplyDate = changeApplyReplyDate;
    }

    public String getChangeApplyEffectDate() {
        return changeApplyEffectDate;
    }

    public void setChangeApplyEffectDate(String changeApplyEffectDate) {
        this.changeApplyEffectDate = changeApplyEffectDate;
    }

    public String getChangeReasonType() {
        return changeReasonType;
    }

    public void setChangeReasonType(String changeReasonType) {
        this.changeReasonType = changeReasonType;
    }

    public String getChangePriceType() {
        return changePriceType;
    }

    public void setChangePriceType(String changePriceType) {
        this.changePriceType = changePriceType;
    }

    public String getChangeContent() {
        return changeContent;
    }

    public void setChangeContent(String changeContent) {
        this.changeContent = changeContent;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }
}