package com.pcitc.base.system;

import java.io.Serializable;
import java.util.Date;

/**
 * sys_unit_tmp
 * @author 
 */
public class SysUnitTmp implements Serializable {
    /**
     * ID
     */
    private String unitId;

    /**
     * 机构全称
     */
    private String unitName;

    /**
     * 机构简称
     */
    private String unitAbbr;

    /**
     * 机构代码
     */
    private String unitCode;

    /**
     * 系统标识符
     */
    private String unitFlag;

    /**
     * 机构种类（实体：Entity，虚拟：Virtual）
     */
    private String unitKind;

    /**
     * 创建日期
     */
    private Date unitCreateTime;

    /**
     * 机构扩展属性
     */
    private String unitExtend;

    /**
     * 机构排序
     */
    private Integer unitOrder;

    /**
     * 机构注释
     */
    private String unitComment;

    /**
     * 联系电话
     */
    private String unitPhone;

    /**
     * 机构传真
     */
    private String unitFax;

    /**
     * 机构负责人
     */
    private String unitManager;

    /**
     * 联系地址
     */
    private String unitAddress;

    /**
     * ERP控制者
     */
    private String unitControl;

    /**
     * 机构账户
     */
    private String unitAccount;

    /**
     * 是否删除（1是，0否）
     */
    private Integer unitDelflag;

    /**
     * 机构级别（0为顶级）
     */
    private Integer unitLevel;

    /**
     * 机构关系(父节点)
     */
    private String unitRelation;

    /**
     * 机构路径（包含本级节点ID）
     */
    private String unitPath;

    private static final long serialVersionUID = 1L;

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitAbbr() {
        return unitAbbr;
    }

    public void setUnitAbbr(String unitAbbr) {
        this.unitAbbr = unitAbbr;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getUnitFlag() {
        return unitFlag;
    }

    public void setUnitFlag(String unitFlag) {
        this.unitFlag = unitFlag;
    }

    public String getUnitKind() {
        return unitKind;
    }

    public void setUnitKind(String unitKind) {
        this.unitKind = unitKind;
    }

    public Date getUnitCreateTime() {
        return unitCreateTime;
    }

    public void setUnitCreateTime(Date unitCreateTime) {
        this.unitCreateTime = unitCreateTime;
    }

    public String getUnitExtend() {
        return unitExtend;
    }

    public void setUnitExtend(String unitExtend) {
        this.unitExtend = unitExtend;
    }

    public Integer getUnitOrder() {
        return unitOrder;
    }

    public void setUnitOrder(Integer unitOrder) {
        this.unitOrder = unitOrder;
    }

    public String getUnitComment() {
        return unitComment;
    }

    public void setUnitComment(String unitComment) {
        this.unitComment = unitComment;
    }

    public String getUnitPhone() {
        return unitPhone;
    }

    public void setUnitPhone(String unitPhone) {
        this.unitPhone = unitPhone;
    }

    public String getUnitFax() {
        return unitFax;
    }

    public void setUnitFax(String unitFax) {
        this.unitFax = unitFax;
    }

    public String getUnitManager() {
        return unitManager;
    }

    public void setUnitManager(String unitManager) {
        this.unitManager = unitManager;
    }

    public String getUnitAddress() {
        return unitAddress;
    }

    public void setUnitAddress(String unitAddress) {
        this.unitAddress = unitAddress;
    }

    public String getUnitControl() {
        return unitControl;
    }

    public void setUnitControl(String unitControl) {
        this.unitControl = unitControl;
    }

    public String getUnitAccount() {
        return unitAccount;
    }

    public void setUnitAccount(String unitAccount) {
        this.unitAccount = unitAccount;
    }

    public Integer getUnitDelflag() {
        return unitDelflag;
    }

    public void setUnitDelflag(Integer unitDelflag) {
        this.unitDelflag = unitDelflag;
    }

    public Integer getUnitLevel() {
        return unitLevel;
    }

    public void setUnitLevel(Integer unitLevel) {
        this.unitLevel = unitLevel;
    }

    public String getUnitRelation() {
        return unitRelation;
    }

    public void setUnitRelation(String unitRelation) {
        this.unitRelation = unitRelation;
    }

    public String getUnitPath() {
        return unitPath;
    }

    public void setUnitPath(String unitPath) {
        this.unitPath = unitPath;
    }
}