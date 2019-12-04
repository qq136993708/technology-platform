package com.pcitc.base.achieve;

import com.pcitc.base.common.RecordModel;

import java.util.Date;

/**
 * 成果表
 * @author
 */
public class AchieveBase extends RecordModel {

    /**
     * 数据主键
     */
    private String id;
    /**
     * 成果名称
     */
    private String achieveName="";
    /**
     * 技术方向类型(选技术族)
     */
    private String techType="";
    /**
     * 技术方向类型(选技术族)关联名称
     */
    private String techTypeText="";
    /**
     * 完成单位名称
     */
    private String finishUnitName="";
    /**
     * 完成时间
     */
    private Date finishDate = new Date();
    /**
     * 项目渠道
     */
    private String projectChannel="";
    /**
     * 成果简介
     */
    private String brief="";
    /**
     * 转化方式（字典表）
     */
    private String achieveTransType="";
    /**
     * 转化方式（字典表）关联名称
     */
    private String achieveTransTypeText;
    /**
     * 联系人，联系方式
     */
    private String contactInfo="";
    /**
     * 单位意见
     */
    private String unitAdvice="";
    /**
     * 审核状态：0草稿（或驳回），1审批中，2审核通过
     */
    private String auditStatus="";
    /**
     * 审核状态：0草稿（或驳回），1审批中，2审核通过 关联字段
     */
    private String auditStatusText;
    /**
     * 附件
     */
    private String file_doc="";
    /**
     * 成果的团队情况（$和#号分隔）：姓名#性别#所在单位#职务$姓名#性别#所在单位#职务
     */
    private String teamPerson="";
    /**
     * 是否公示：1已公示，0未公示
     */
    private String isPublic="";

    /**
     * 成果转化工作情况
     */
    private String workInfo="";

    /**
     * 附件
     */
    private String fileDoc="";



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAchieveName() {
        return achieveName;
    }

    public void setAchieveName(String achieveName) {
        this.achieveName = achieveName;
    }

    public String getTechType() {
        return techType;
    }

    public void setTechType(String techType) {
        this.techType = techType;
    }

    public String getFinishUnitName() {
        return finishUnitName;
    }

    public void setFinishUnitName(String finishUnitName) {
        this.finishUnitName = finishUnitName;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public String getProjectChannel() {
        return projectChannel;
    }

    public void setProjectChannel(String projectChannel) {
        this.projectChannel = projectChannel;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getAchieveTransType() {
        return achieveTransType;
    }

    public void setAchieveTransType(String achieveTransType) {
        this.achieveTransType = achieveTransType;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getUnitAdvice() {
        return unitAdvice;
    }

    public void setUnitAdvice(String unitAdvice) {
        this.unitAdvice = unitAdvice;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getFile_doc() {
        return file_doc;
    }

    public void setFile_doc(String file_doc) {
        this.file_doc = file_doc;
    }

    public String getTeamPerson() {
        return teamPerson;
    }

    public void setTeamPerson(String teamPerson) {
        this.teamPerson = teamPerson;
    }

    public String getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(String isPublic) {
        this.isPublic = isPublic;
    }

    public String getTechTypeText() {
        return techTypeText;
    }

    public void setTechTypeText(String techTypeText) {
        this.techTypeText = techTypeText;
    }

    public String getAchieveTransTypeText() {
        return achieveTransTypeText;
    }

    public void setAchieveTransTypeText(String achieveTransTypeText) {
        this.achieveTransTypeText = achieveTransTypeText;
    }

    public String getAuditStatusText() {
        return auditStatusText;
    }

    public void setAuditStatusText(String auditStatusText) {
        this.auditStatusText = auditStatusText;
    }

    public String getWorkInfo() {
        return workInfo;
    }

    public void setWorkInfo(String workInfo) {
        this.workInfo = workInfo;
    }

    public String getFileDoc() {
        return fileDoc;
    }

    public void setFileDoc(String fileDoc) {
        this.fileDoc = fileDoc;
    }
}
