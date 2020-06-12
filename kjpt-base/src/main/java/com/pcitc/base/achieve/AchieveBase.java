package com.pcitc.base.achieve;

import com.pcitc.base.common.RecordModel;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 成果表
 * @author
 */
public class AchieveBase extends RecordModel implements Serializable {

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
     * 完成单位名称
     */
    private String finishUnitNameText="";

    /**
     * 成果所属单位
     */
    private String affiliatedUnit;
    private String affiliatedUnitText;
    /**
     * 完成时间
     */
    private String finishDate;
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
     * 成果的团队情况（$和#号分隔）：姓名#性别#所在单位#职务$姓名#性别#所在单位#职务
     */
    private String teamPerson="";
    /**
     * 是否公示：1已公示，0未公示
     */
    private String isPublic="0";

    /**
     * 成果转化工作情况
     */
    private String workInfo="";

    /**
     * 附件
     */
    private String fileDoc="";

    /**
     * 外部转化审批表
     * @return
     */
    private String approvalDoc;
    /**
     * 申请状态  01 未提交、02 已提交、03 审批中、04 已通过、05 已完成、06驳回
     * @return
     */
    private String applyStatus;
    /**
     * 申请状态字典翻译
     * @return
     */
    private String applyStatusText;
    /**
     * 是否核心成果  成果类型：1核心，0非核心
     * @return
     */
    private String achieveType;
    private String achieveTypeText;

    private BigDecimal conversionAmount;



    /**
     * 公示附件
     */
    private String publicDoc;


    public String getApprovalDoc() {
        return approvalDoc;
    }

    public void setApprovalDoc(String approvalDoc) {
        this.approvalDoc = approvalDoc;
    }

    public String getPublicDoc() {
        return publicDoc;
    }

    public void setPublicDoc(String publicDoc) {
        this.publicDoc = publicDoc;
    }

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

    public String getAffiliatedUnit() {
        return affiliatedUnit;
    }

    public void setAffiliatedUnit(String affiliatedUnit) {
        this.affiliatedUnit = affiliatedUnit;
    }

    public String getAffiliatedUnitText() {
        return affiliatedUnitText;
    }

    public void setAffiliatedUnitText(String affiliatedUnitText) {
        this.affiliatedUnitText = affiliatedUnitText;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
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

    public String getFinishUnitNameText() {
        return finishUnitNameText;
    }

    public void setFinishUnitNameText(String finishUnitNameText) {
        this.finishUnitNameText = finishUnitNameText;
    }


    public String getapplyStatus() {
        return applyStatus;
    }


    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }

    public String getApplyStatusText() {
        return applyStatusText;
    }

    public void setApplyStatusText(String applyStatusText) {
        this.applyStatusText = applyStatusText;
    }

    public String getAchieveType() {
        return achieveType;
    }

    public void setAchieveType(String achieveType) {
        this.achieveType = achieveType;
    }

    public String getAchieveTypeText() {
        return achieveTypeText;
    }

    public void setAchieveTypeText(String achieveTypeText) {
        this.achieveTypeText = achieveTypeText;
    }

    public BigDecimal getConversionAmount() {
        return conversionAmount;
    }

    public void setConversionAmount(BigDecimal conversionAmount) {
        this.conversionAmount = conversionAmount;
    }
}
