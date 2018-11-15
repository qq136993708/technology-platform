package com.pcitc.base.engin.hse.car;

import com.pcitc.base.util.SearchInfo;

import java.io.Serializable;

/**
 * hse_car_apply
 *
 * @author
 */
public class HseCarApplyVo extends SearchInfo implements Serializable {
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
     * 车牌号
     */
    private String carNumber;

    /**
     * 车辆保险有效期
     */
    private String carSafeDate;

    /**
     * 所属单位
     */
    private String fromUnit;

    /**
     * 车辆属性
     */
    private String carProperty;

    /**
     * 行驶证有效期
     */
    private String carRunDate;

    /**
     * 通行证编码
     */
    private String carRunCode;

    /**
     * 车辆类型
     */
    private String carType;

    /**
     * 申请人
     */
    private String carApplyUser;

    /**
     * 联系方式
     */
    private String userContact;

    /**
     * 车辆用途描述
     */
    private String carUseDesc;

    /**
     * 记录编号
     */
    private String recordNo;

    /**
     * 申请日期
     */
    private String applyDate;

    /**
     * 发证情况
     */
    private String certStatus;

    /**
     * 附件
     */
    private String attachment;

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

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarSafeDate() {
        return carSafeDate;
    }

    public void setCarSafeDate(String carSafeDate) {
        this.carSafeDate = carSafeDate;
    }

    public String getFromUnit() {
        return fromUnit;
    }

    public void setFromUnit(String fromUnit) {
        this.fromUnit = fromUnit;
    }

    public String getCarProperty() {
        return carProperty;
    }

    public void setCarProperty(String carProperty) {
        this.carProperty = carProperty;
    }

    public String getCarRunDate() {
        return carRunDate;
    }

    public void setCarRunDate(String carRunDate) {
        this.carRunDate = carRunDate;
    }

    public String getCarRunCode() {
        return carRunCode;
    }

    public void setCarRunCode(String carRunCode) {
        this.carRunCode = carRunCode;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarApplyUser() {
        return carApplyUser;
    }

    public void setCarApplyUser(String carApplyUser) {
        this.carApplyUser = carApplyUser;
    }

    public String getUserContact() {
        return userContact;
    }

    public void setUserContact(String userContact) {
        this.userContact = userContact;
    }

    public String getCarUseDesc() {
        return carUseDesc;
    }

    public void setCarUseDesc(String carUseDesc) {
        this.carUseDesc = carUseDesc;
    }

    public String getRecordNo() {
        return recordNo;
    }

    public void setRecordNo(String recordNo) {
        this.recordNo = recordNo;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public String getCertStatus() {
        return certStatus;
    }

    public void setCertStatus(String certStatus) {
        this.certStatus = certStatus;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }
}