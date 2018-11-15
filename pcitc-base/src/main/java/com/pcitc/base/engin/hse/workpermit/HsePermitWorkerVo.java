package com.pcitc.base.engin.hse.workpermit;

import java.io.Serializable;

/**
 * hse_permit_worker
 * @author 
 */
public class HsePermitWorkerVo implements Serializable {
    /**
     * 许可证作业人id
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
     * 修改人
     */
    private String updateUser;

    /**
     * 最后修改人
     */
    private String updateDate;

    /**
     * 记录状态：删除、停用、正常
     */
    private String status;

    /**
     * 审批状态：草稿、待审批、已审批
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
     * 许可证作业人编码
     */
    private String formCode;

    /**
     * 许可证id
     */
    private String permitId;

    /**
     * 许可证类型
     */
    private String permitType;

    /**
     * 许可证申请人员姓名
     */
    private String workerName;

    /**
     * 作业人职称
     */
    private String workerTitle;

    /**
     * 作业人类型
     */
    private String workerType;

    /**
     * 许可证申请人岗位/工种
     */
    private String workerPost;

    /**
     * 主要施工设备(吊车等）
     */
    private String workDevice;

    /**
     * 设备数量 
     */
    private String deviceNum;

    /**
     * 备注
     */
    private String remark;

    /**
     * 身份证号
     */
    private String workerIdCard;

    /**
     * 监护人
     */
    private String workerKeeper;

    /**
     * 特殊工种类型、证号（火电工等）
     */
    private String specialWorkerNum;

    /**
     * 联系方式
     */
    private String contactWay;

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

    public String getPermitId() {
        return permitId;
    }

    public void setPermitId(String permitId) {
        this.permitId = permitId;
    }

    public String getPermitType() {
        return permitType;
    }

    public void setPermitType(String permitType) {
        this.permitType = permitType;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public String getWorkerTitle() {
        return workerTitle;
    }

    public void setWorkerTitle(String workerTitle) {
        this.workerTitle = workerTitle;
    }

    public String getWorkerType() {
        return workerType;
    }

    public void setWorkerType(String workerType) {
        this.workerType = workerType;
    }

    public String getWorkerPost() {
        return workerPost;
    }

    public void setWorkerPost(String workerPost) {
        this.workerPost = workerPost;
    }

    public String getWorkDevice() {
        return workDevice;
    }

    public void setWorkDevice(String workDevice) {
        this.workDevice = workDevice;
    }

    public String getDeviceNum() {
        return deviceNum;
    }

    public void setDeviceNum(String deviceNum) {
        this.deviceNum = deviceNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getWorkerIdCard() {
        return workerIdCard;
    }

    public void setWorkerIdCard(String workerIdCard) {
        this.workerIdCard = workerIdCard;
    }

    public String getWorkerKeeper() {
        return workerKeeper;
    }

    public void setWorkerKeeper(String workerKeeper) {
        this.workerKeeper = workerKeeper;
    }

    public String getSpecialWorkerNum() {
        return specialWorkerNum;
    }

    public void setSpecialWorkerNum(String specialWorkerNum) {
        this.specialWorkerNum = specialWorkerNum;
    }

    public String getContactWay() {
        return contactWay;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay;
    }
}