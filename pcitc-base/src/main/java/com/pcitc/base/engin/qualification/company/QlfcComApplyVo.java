package com.pcitc.base.engin.qualification.company;

import com.pcitc.base.util.SearchInfo;

import java.io.Serializable;
import java.util.List;

/**
 * qlfc_com_apply
 *
 * @author
 */
public class QlfcComApplyVo extends SearchInfo implements Serializable {
    /**
     * 业务表单id
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
     * 修改时间
     */
    private String updateDate;

    /**
     * 业务表单状态(1、生效；0、作废，默认1)
     */
    private Integer status;

    /**
     * 工作流状态
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
     * 业务表单code
     */
    private String formCode;

    /**
     * 法人姓名
     */
    private String legalPersonName;

    /**
     * 承包商类型
     */
    private String comType;

    /**
     * 承包商编码
     */
    private String comCode;

    /**
     * 公司地址
     */
    private String comAddress;

    /**
     * 单位名称
     */
    private String unitName;

    /**
     * 组织机构代码证号
     */
    private String orgCodeNumber;

    /**
     * 企业资质证书
     */
    private List<QlfcComCertVo> qlfcComCerts;

    /**
     * 企业其他证书
     */
    private List<QlfcComCertOtherVo> qlfcComCertOthers;

    /**
     * 其他材料
     */
    private List<QlfcComApplyOtherVo> qlfcComApplyOthers;

    /**
     * 资质名称
     */
    private String qlfcName;

    /**
     * 资质类型
     */
    private String qlfcType;

    /**
     * 过期资质
     */
    private int overDueQlfc;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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

    public String getLegalPersonName() {
        return legalPersonName;
    }

    public void setLegalPersonName(String legalPersonName) {
        this.legalPersonName = legalPersonName;
    }

    public String getComType() {
        return comType;
    }

    public void setComType(String comType) {
        this.comType = comType;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getComAddress() {
        return comAddress;
    }

    public void setComAddress(String comAddress) {
        this.comAddress = comAddress;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getOrgCodeNumber() {
        return orgCodeNumber;
    }

    public void setOrgCodeNumber(String orgCodeNumber) {
        this.orgCodeNumber = orgCodeNumber;
    }

    public List<QlfcComCertVo> getQlfcComCerts() {
        return qlfcComCerts;
    }

    public void setQlfcComCerts(List<QlfcComCertVo> qlfcComCerts) {
        this.qlfcComCerts = qlfcComCerts;
    }

    public List<QlfcComCertOtherVo> getQlfcComCertOthers() {
        return qlfcComCertOthers;
    }

    public void setQlfcComCertOthers(List<QlfcComCertOtherVo> qlfcComCertOthers) {
        this.qlfcComCertOthers = qlfcComCertOthers;
    }

    public List<QlfcComApplyOtherVo> getQlfcComApplyOthers() {
        return qlfcComApplyOthers;
    }

    public void setQlfcComApplyOthers(List<QlfcComApplyOtherVo> qlfcComApplyOthers) {
        this.qlfcComApplyOthers = qlfcComApplyOthers;
    }

    public String getQlfcName() {
        return qlfcName;
    }

    public void setQlfcName(String qlfcName) {
        this.qlfcName = qlfcName;
    }

    public String getQlfcType() {
        return qlfcType;
    }

    public void setQlfcType(String qlfcType) {
        this.qlfcType = qlfcType;
    }

    public int getOverDueQlfc() {
        return overDueQlfc;
    }

    public void setOverDueQlfc(int overDueQlfc) {
        this.overDueQlfc = overDueQlfc;
    }

}