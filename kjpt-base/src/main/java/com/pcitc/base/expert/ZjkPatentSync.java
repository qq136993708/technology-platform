package com.pcitc.base.expert;

import java.io.Serializable;
import java.util.Date;

/**
 * zjk_patent_sync
 * @author 
 */
public class ZjkPatentSync implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 专家编号
     */
    private String expertNum;

    /**
     * 专家ID
     */
    private String expertId;

    /**
     * 删除状态（0未删除，1删除）
     */
    private String delStatus;

    /**
     * 专利名称
     */
    private String patentName;

    /**
     * 专利类型
     */
    private String patentType;

    /**
     * 获得专利时间
     */
    private Date patentTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 说明
     */
    private String notes;

    /**
     * 专利号
     */
    private String patentNum;

    /**
     * 专利排名
     */
    private Integer patentOrder;

    /**
     * 外系统主键
     */
    private String outSysId;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExpertNum() {
        return expertNum;
    }

    public void setExpertNum(String expertNum) {
        this.expertNum = expertNum;
    }

    public String getExpertId() {
        return expertId;
    }

    public void setExpertId(String expertId) {
        this.expertId = expertId;
    }

    public String getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(String delStatus) {
        this.delStatus = delStatus;
    }

    public String getPatentName() {
        return patentName;
    }

    public void setPatentName(String patentName) {
        this.patentName = patentName;
    }

    public String getPatentType() {
        return patentType;
    }

    public void setPatentType(String patentType) {
        this.patentType = patentType;
    }

    public Date getPatentTime() {
        return patentTime;
    }

    public void setPatentTime(Date patentTime) {
        this.patentTime = patentTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPatentNum() {
        return patentNum;
    }

    public void setPatentNum(String patentNum) {
        this.patentNum = patentNum;
    }

    public Integer getPatentOrder() {
        return patentOrder;
    }

    public void setPatentOrder(Integer patentOrder) {
        this.patentOrder = patentOrder;
    }

    public String getOutSysId() {
        return outSysId;
    }

    public void setOutSysId(String outSysId) {
        this.outSysId = outSysId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}