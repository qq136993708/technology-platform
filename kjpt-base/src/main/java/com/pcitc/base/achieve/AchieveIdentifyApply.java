package com.pcitc.base.achieve;

import com.pcitc.base.common.RecordModel;

import java.util.Date;

/**
 * @author ty
 */
public class AchieveIdentifyApply extends RecordModel {
    /**
     * 数据主键
     */
    private String id;
    /**
     * 附件
     */
    private String publicDoc;
    /**
     * 成果ID
     */
    private String achieveId;
    /**
     * 成果名称
     */
    private String achieveName;
    /**
     * 第一完成单位
     */
    private Date firstUnit;
    /**
     * 鉴定形式
     */
    private Date identifyForm;
    /**
     * 鉴定单位
     */
    private Date identifyUnit;
    /**
     * 鉴定时间
     */
    private String identifyTime;
    /**
     * 成果简要说明
     */
    private String achieveNotes;
    /**
     * 主要完成人员名单
     */
    private String mainFinishedPersons;
    /**
     * 主要完成单位名单
     */
    private String mainFinishedUnits;
    /**
     * 主要完成委员会名单
     */
    private String mainFinishedCommittee;
    /**
     * 审核状态
     */
    private String auditStatus;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getPublicDoc() {
        return publicDoc;
    }

    public void setPublicDoc(String publicDoc) {
        this.publicDoc = publicDoc;
    }

    public String getAchieveId() {
        return achieveId;
    }

    public void setAchieveId(String achieveId) {
        this.achieveId = achieveId;
    }

    public String getAchieveName() {
        return achieveName;
    }

    public void setAchieveName(String achieveName) {
        this.achieveName = achieveName;
    }

    public Date getFirstUnit() {
        return firstUnit;
    }

    public void setFirstUnit(Date firstUnit) {
        this.firstUnit = firstUnit;
    }

    public Date getIdentifyForm() {
        return identifyForm;
    }

    public void setIdentifyForm(Date identifyForm) {
        this.identifyForm = identifyForm;
    }

    public Date getIdentifyUnit() {
        return identifyUnit;
    }

    public void setIdentifyUnit(Date identifyUnit) {
        this.identifyUnit = identifyUnit;
    }

    public String getIdentifyTime() {
        return identifyTime;
    }

    public void setIdentifyTime(String identifyTime) {
        this.identifyTime = identifyTime;
    }

    public String getAchieveNotes() {
        return achieveNotes;
    }

    public void setAchieveNotes(String achieveNotes) {
        this.achieveNotes = achieveNotes;
    }

    public String getMainFinishedPersons() {
        return mainFinishedPersons;
    }

    public void setMainFinishedPersons(String mainFinishedPersons) {
        this.mainFinishedPersons = mainFinishedPersons;
    }

    public String getMainFinishedUnits() {
        return mainFinishedUnits;
    }

    public void setMainFinishedUnits(String mainFinishedUnits) {
        this.mainFinishedUnits = mainFinishedUnits;
    }

    public String getMainFinishedCommittee() {
        return mainFinishedCommittee;
    }

    public void setMainFinishedCommittee(String mainFinishedCommittee) {
        this.mainFinishedCommittee = mainFinishedCommittee;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }
}
