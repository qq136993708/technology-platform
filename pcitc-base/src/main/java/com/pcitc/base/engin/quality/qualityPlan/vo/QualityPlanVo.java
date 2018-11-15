package com.pcitc.base.engin.quality.qualityPlan.vo;

import java.io.Serializable;

/**
 * t_zlgl_zljh
 * @author 
 */
public class QualityPlanVo implements Serializable {
    /**
     * 主键
     */
    private String dataId;

    /**
     * 系统名称
     */
    private String sysFlag;

    /**
     * 业务数据排序字段
     */
    private String dataOrder;

    /**
     * 1-表示已删除，2-表示未删除
     */
    private String delFlag;

    /**
     * 业务数据创建日期
     */
    private String createDate;

    /**
     * 业务数据创建人
     */
    private String createUser;

    /**
     * 业务数据最后修改日期
     */
    private String modifyDate;

    /**
     * 业务数据最后修改人
     */
    private String modifyUser;

    /**
     * 工作流的状态
     */
    private String workflowState;

    /**
     * 单位编码
     */
    private String companyCode;

    /**
     * 质量计划编码
     */
    private String zljhbm;

    private String zljhid;

    /**
     * 质量计划名称
     */
    private String zljhmc;

    private String xmid;

    /**
     * 项目编码
     */
    private String xmbm;

    /**
     * 项目名称
     */
    private String zxmmc;

    private String wbsid;

    /**
     * WBS编码
     */
    private String wbsbm;

    /**
     * WBS名称
     */
    private String wbsmc;

    private String htid;

    /**
     * 合同编码
     */
    private String htbm;

    /**
     * 合同名称
     */
    private String htmc;

    /**
     * 监理单位编码
     */
    private String jldwbm;

    /**
     * 监理单位名称
     */
    private String jldwmc;

    /**
     * 施工单位编码
     */
    private String sgdwbm;

    /**
     * 施工单位名称
     */
    private String sgdwmc;

    /**
     * 项目分部编码
     */
    private String xmfbbm;

    /**
     * 项目分部名称
     */
    private String xmfbmc;

    /**
     * 最后修改人
     */
    private String zhxgr;

    /**
     * 监理单位ID
     */
    private String jldwid;

    /**
     * 施工单位ID
     */
    private String sgdwid;

    /**
     * 项目分部ID
     */
    private String xmfbid;

    /**
     * 总承包单位名称
     */
    private String zcbdwmc;

    /**
     * 总承包单位编码
     */
    private String zcbdwbm;

    /**
     * 总承包单位ID
     */
    private String zcbdwid;

    private static final long serialVersionUID = 1L;

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getSysFlag() {
        return sysFlag;
    }

    public void setSysFlag(String sysFlag) {
        this.sysFlag = sysFlag;
    }

    public String getDataOrder() {
        return dataOrder;
    }

    public void setDataOrder(String dataOrder) {
        this.dataOrder = dataOrder;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public String getWorkflowState() {
        return workflowState;
    }

    public void setWorkflowState(String workflowState) {
        this.workflowState = workflowState;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getZljhbm() {
        return zljhbm;
    }

    public void setZljhbm(String zljhbm) {
        this.zljhbm = zljhbm;
    }

    public String getZljhid() {
        return zljhid;
    }

    public void setZljhid(String zljhid) {
        this.zljhid = zljhid;
    }

    public String getZljhmc() {
        return zljhmc;
    }

    public void setZljhmc(String zljhmc) {
        this.zljhmc = zljhmc;
    }

    public String getXmid() {
        return xmid;
    }

    public void setXmid(String xmid) {
        this.xmid = xmid;
    }

    public String getXmbm() {
        return xmbm;
    }

    public void setXmbm(String xmbm) {
        this.xmbm = xmbm;
    }

    public String getZxmmc() {
        return zxmmc;
    }

    public void setZxmmc(String zxmmc) {
        this.zxmmc = zxmmc;
    }

    public String getWbsid() {
        return wbsid;
    }

    public void setWbsid(String wbsid) {
        this.wbsid = wbsid;
    }

    public String getWbsbm() {
        return wbsbm;
    }

    public void setWbsbm(String wbsbm) {
        this.wbsbm = wbsbm;
    }

    public String getWbsmc() {
        return wbsmc;
    }

    public void setWbsmc(String wbsmc) {
        this.wbsmc = wbsmc;
    }

    public String getHtid() {
        return htid;
    }

    public void setHtid(String htid) {
        this.htid = htid;
    }

    public String getHtbm() {
        return htbm;
    }

    public void setHtbm(String htbm) {
        this.htbm = htbm;
    }

    public String getHtmc() {
        return htmc;
    }

    public void setHtmc(String htmc) {
        this.htmc = htmc;
    }

    public String getJldwbm() {
        return jldwbm;
    }

    public void setJldwbm(String jldwbm) {
        this.jldwbm = jldwbm;
    }

    public String getJldwmc() {
        return jldwmc;
    }

    public void setJldwmc(String jldwmc) {
        this.jldwmc = jldwmc;
    }

    public String getSgdwbm() {
        return sgdwbm;
    }

    public void setSgdwbm(String sgdwbm) {
        this.sgdwbm = sgdwbm;
    }

    public String getSgdwmc() {
        return sgdwmc;
    }

    public void setSgdwmc(String sgdwmc) {
        this.sgdwmc = sgdwmc;
    }

    public String getXmfbbm() {
        return xmfbbm;
    }

    public void setXmfbbm(String xmfbbm) {
        this.xmfbbm = xmfbbm;
    }

    public String getXmfbmc() {
        return xmfbmc;
    }

    public void setXmfbmc(String xmfbmc) {
        this.xmfbmc = xmfbmc;
    }

    public String getZhxgr() {
        return zhxgr;
    }

    public void setZhxgr(String zhxgr) {
        this.zhxgr = zhxgr;
    }

    public String getJldwid() {
        return jldwid;
    }

    public void setJldwid(String jldwid) {
        this.jldwid = jldwid;
    }

    public String getSgdwid() {
        return sgdwid;
    }

    public void setSgdwid(String sgdwid) {
        this.sgdwid = sgdwid;
    }

    public String getXmfbid() {
        return xmfbid;
    }

    public void setXmfbid(String xmfbid) {
        this.xmfbid = xmfbid;
    }

    public String getZcbdwmc() {
        return zcbdwmc;
    }

    public void setZcbdwmc(String zcbdwmc) {
        this.zcbdwmc = zcbdwmc;
    }

    public String getZcbdwbm() {
        return zcbdwbm;
    }

    public void setZcbdwbm(String zcbdwbm) {
        this.zcbdwbm = zcbdwbm;
    }

    public String getZcbdwid() {
        return zcbdwid;
    }

    public void setZcbdwid(String zcbdwid) {
        this.zcbdwid = zcbdwid;
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
        QualityPlanVo other = (QualityPlanVo) that;
        return (this.getDataId() == null ? other.getDataId() == null : this.getDataId().equals(other.getDataId()))
            && (this.getSysFlag() == null ? other.getSysFlag() == null : this.getSysFlag().equals(other.getSysFlag()))
            && (this.getDataOrder() == null ? other.getDataOrder() == null : this.getDataOrder().equals(other.getDataOrder()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getModifyDate() == null ? other.getModifyDate() == null : this.getModifyDate().equals(other.getModifyDate()))
            && (this.getModifyUser() == null ? other.getModifyUser() == null : this.getModifyUser().equals(other.getModifyUser()))
            && (this.getWorkflowState() == null ? other.getWorkflowState() == null : this.getWorkflowState().equals(other.getWorkflowState()))
            && (this.getCompanyCode() == null ? other.getCompanyCode() == null : this.getCompanyCode().equals(other.getCompanyCode()))
            && (this.getZljhbm() == null ? other.getZljhbm() == null : this.getZljhbm().equals(other.getZljhbm()))
            && (this.getZljhid() == null ? other.getZljhid() == null : this.getZljhid().equals(other.getZljhid()))
            && (this.getZljhmc() == null ? other.getZljhmc() == null : this.getZljhmc().equals(other.getZljhmc()))
            && (this.getXmid() == null ? other.getXmid() == null : this.getXmid().equals(other.getXmid()))
            && (this.getXmbm() == null ? other.getXmbm() == null : this.getXmbm().equals(other.getXmbm()))
            && (this.getZxmmc() == null ? other.getZxmmc() == null : this.getZxmmc().equals(other.getZxmmc()))
            && (this.getWbsid() == null ? other.getWbsid() == null : this.getWbsid().equals(other.getWbsid()))
            && (this.getWbsbm() == null ? other.getWbsbm() == null : this.getWbsbm().equals(other.getWbsbm()))
            && (this.getWbsmc() == null ? other.getWbsmc() == null : this.getWbsmc().equals(other.getWbsmc()))
            && (this.getHtid() == null ? other.getHtid() == null : this.getHtid().equals(other.getHtid()))
            && (this.getHtbm() == null ? other.getHtbm() == null : this.getHtbm().equals(other.getHtbm()))
            && (this.getHtmc() == null ? other.getHtmc() == null : this.getHtmc().equals(other.getHtmc()))
            && (this.getJldwbm() == null ? other.getJldwbm() == null : this.getJldwbm().equals(other.getJldwbm()))
            && (this.getJldwmc() == null ? other.getJldwmc() == null : this.getJldwmc().equals(other.getJldwmc()))
            && (this.getSgdwbm() == null ? other.getSgdwbm() == null : this.getSgdwbm().equals(other.getSgdwbm()))
            && (this.getSgdwmc() == null ? other.getSgdwmc() == null : this.getSgdwmc().equals(other.getSgdwmc()))
            && (this.getXmfbbm() == null ? other.getXmfbbm() == null : this.getXmfbbm().equals(other.getXmfbbm()))
            && (this.getXmfbmc() == null ? other.getXmfbmc() == null : this.getXmfbmc().equals(other.getXmfbmc()))
            && (this.getZhxgr() == null ? other.getZhxgr() == null : this.getZhxgr().equals(other.getZhxgr()))
            && (this.getJldwid() == null ? other.getJldwid() == null : this.getJldwid().equals(other.getJldwid()))
            && (this.getSgdwid() == null ? other.getSgdwid() == null : this.getSgdwid().equals(other.getSgdwid()))
            && (this.getXmfbid() == null ? other.getXmfbid() == null : this.getXmfbid().equals(other.getXmfbid()))
            && (this.getZcbdwmc() == null ? other.getZcbdwmc() == null : this.getZcbdwmc().equals(other.getZcbdwmc()))
            && (this.getZcbdwbm() == null ? other.getZcbdwbm() == null : this.getZcbdwbm().equals(other.getZcbdwbm()))
            && (this.getZcbdwid() == null ? other.getZcbdwid() == null : this.getZcbdwid().equals(other.getZcbdwid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataId() == null) ? 0 : getDataId().hashCode());
        result = prime * result + ((getSysFlag() == null) ? 0 : getSysFlag().hashCode());
        result = prime * result + ((getDataOrder() == null) ? 0 : getDataOrder().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getModifyDate() == null) ? 0 : getModifyDate().hashCode());
        result = prime * result + ((getModifyUser() == null) ? 0 : getModifyUser().hashCode());
        result = prime * result + ((getWorkflowState() == null) ? 0 : getWorkflowState().hashCode());
        result = prime * result + ((getCompanyCode() == null) ? 0 : getCompanyCode().hashCode());
        result = prime * result + ((getZljhbm() == null) ? 0 : getZljhbm().hashCode());
        result = prime * result + ((getZljhid() == null) ? 0 : getZljhid().hashCode());
        result = prime * result + ((getZljhmc() == null) ? 0 : getZljhmc().hashCode());
        result = prime * result + ((getXmid() == null) ? 0 : getXmid().hashCode());
        result = prime * result + ((getXmbm() == null) ? 0 : getXmbm().hashCode());
        result = prime * result + ((getZxmmc() == null) ? 0 : getZxmmc().hashCode());
        result = prime * result + ((getWbsid() == null) ? 0 : getWbsid().hashCode());
        result = prime * result + ((getWbsbm() == null) ? 0 : getWbsbm().hashCode());
        result = prime * result + ((getWbsmc() == null) ? 0 : getWbsmc().hashCode());
        result = prime * result + ((getHtid() == null) ? 0 : getHtid().hashCode());
        result = prime * result + ((getHtbm() == null) ? 0 : getHtbm().hashCode());
        result = prime * result + ((getHtmc() == null) ? 0 : getHtmc().hashCode());
        result = prime * result + ((getJldwbm() == null) ? 0 : getJldwbm().hashCode());
        result = prime * result + ((getJldwmc() == null) ? 0 : getJldwmc().hashCode());
        result = prime * result + ((getSgdwbm() == null) ? 0 : getSgdwbm().hashCode());
        result = prime * result + ((getSgdwmc() == null) ? 0 : getSgdwmc().hashCode());
        result = prime * result + ((getXmfbbm() == null) ? 0 : getXmfbbm().hashCode());
        result = prime * result + ((getXmfbmc() == null) ? 0 : getXmfbmc().hashCode());
        result = prime * result + ((getZhxgr() == null) ? 0 : getZhxgr().hashCode());
        result = prime * result + ((getJldwid() == null) ? 0 : getJldwid().hashCode());
        result = prime * result + ((getSgdwid() == null) ? 0 : getSgdwid().hashCode());
        result = prime * result + ((getXmfbid() == null) ? 0 : getXmfbid().hashCode());
        result = prime * result + ((getZcbdwmc() == null) ? 0 : getZcbdwmc().hashCode());
        result = prime * result + ((getZcbdwbm() == null) ? 0 : getZcbdwbm().hashCode());
        result = prime * result + ((getZcbdwid() == null) ? 0 : getZcbdwid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dataId=").append(dataId);
        sb.append(", sysFlag=").append(sysFlag);
        sb.append(", dataOrder=").append(dataOrder);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", createDate=").append(createDate);
        sb.append(", createUser=").append(createUser);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", modifyUser=").append(modifyUser);
        sb.append(", workflowState=").append(workflowState);
        sb.append(", companyCode=").append(companyCode);
        sb.append(", zljhbm=").append(zljhbm);
        sb.append(", zljhid=").append(zljhid);
        sb.append(", zljhmc=").append(zljhmc);
        sb.append(", xmid=").append(xmid);
        sb.append(", xmbm=").append(xmbm);
        sb.append(", zxmmc=").append(zxmmc);
        sb.append(", wbsid=").append(wbsid);
        sb.append(", wbsbm=").append(wbsbm);
        sb.append(", wbsmc=").append(wbsmc);
        sb.append(", htid=").append(htid);
        sb.append(", htbm=").append(htbm);
        sb.append(", htmc=").append(htmc);
        sb.append(", jldwbm=").append(jldwbm);
        sb.append(", jldwmc=").append(jldwmc);
        sb.append(", sgdwbm=").append(sgdwbm);
        sb.append(", sgdwmc=").append(sgdwmc);
        sb.append(", xmfbbm=").append(xmfbbm);
        sb.append(", xmfbmc=").append(xmfbmc);
        sb.append(", zhxgr=").append(zhxgr);
        sb.append(", jldwid=").append(jldwid);
        sb.append(", sgdwid=").append(sgdwid);
        sb.append(", xmfbid=").append(xmfbid);
        sb.append(", zcbdwmc=").append(zcbdwmc);
        sb.append(", zcbdwbm=").append(zcbdwbm);
        sb.append(", zcbdwid=").append(zcbdwid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}