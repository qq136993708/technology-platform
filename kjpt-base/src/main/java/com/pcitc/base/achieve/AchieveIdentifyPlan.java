package com.pcitc.base.achieve;

import com.pcitc.base.common.RecordModel;

import java.util.Date;

/**
 * @author ty
 */
public class AchieveIdentifyPlan extends RecordModel {
    /**
     * 数据主键
     */
    private String id;
    /**
     * 附件
     */
    private String publicDoc;
    /**
     * 附件
     */
    private String taskSource;
    /**
     * 文件编号
     */
    private String fileNum;
    /**
     * 研究开始时间
     */
    private Date researchBeginTime;
    /**
     * 研究结束时间
     */
    private Date researchEndTime;
    /**
     * 拟定时间
     */
    private Date forTime;
    /**
     * 鉴定形式
     */
    private String identifyForm;
    /**
     * 鉴定地点
     */
    private String identifyLocate;
    /**
     * 备注
     */
    private String notes;


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

    public String getTaskSource() {
        return taskSource;
    }

    public void setTaskSource(String taskSource) {
        this.taskSource = taskSource;
    }

    public String getFileNum() {
        return fileNum;
    }

    public void setFileNum(String fileNum) {
        this.fileNum = fileNum;
    }

    public Date getResearchBeginTime() {
        return researchBeginTime;
    }

    public void setResearchBeginTime(Date researchBeginTime) {
        this.researchBeginTime = researchBeginTime;
    }

    public Date getResearchEndTime() {
        return researchEndTime;
    }

    public void setResearchEndTime(Date researchEndTime) {
        this.researchEndTime = researchEndTime;
    }

    public Date getForTime() {
        return forTime;
    }

    public void setForTime(Date forTime) {
        this.forTime = forTime;
    }

    public String getIdentifyForm() {
        return identifyForm;
    }

    public void setIdentifyForm(String identifyForm) {
        this.identifyForm = identifyForm;
    }

    public String getIdentifyLocate() {
        return identifyLocate;
    }

    public void setIdentifyLocate(String identifyLocate) {
        this.identifyLocate = identifyLocate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
