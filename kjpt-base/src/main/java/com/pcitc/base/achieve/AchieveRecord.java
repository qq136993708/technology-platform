package com.pcitc.base.achieve;

import com.pcitc.base.common.RecordModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *备案表
 * @author
 */
public class AchieveRecord extends RecordModel implements Serializable {
    /**
     * 数据主键
     */
    private String id;
    /**
     * 成果ID(如果是非成果类的，此项为空)
     */
    private String achieveId="";
    /**
     * 成果名称
     */
    private String achieveName="";
    /**
     * 成果类型：1核心，0非核心
     */
    private String achieveType="";
    /**
     * 成果类型：1核心，0非核心 关联名称
     */
    private String achieveTypeText;
    /**
     * 成果转化方式（字典表）
     */
    private String achieveTransType="";
    /**
     * 成果转化方式（字典表） 关联名称
     */
    private String achieveTransTypeText;
    /**
     * 成果转化状态（字典表）
     */
    private String achieveTransStatus="";
    /**
     * 成果转化状态（字典表）关联名称
     */
    private String achieveTransStatusText;
    /**
     * 备案状态：0未完成 1已完成
     */
    private String auditStatus="";
    /**
     * 备案状态：0未完成 1已完成
     */
    private String auditStatusText;
    /**
     * 成果信息
     */
    private String achieveInfo="";
    /**
     * 完成单位名称
     */
    private String finishUnitName="";
    /**
     * 完成单位名称翻译
     */
    private String finishUnitNameText="";
    /**
     * 所属单位（专业化公司/直属单位）
     */
    private String affiliatedUnit="";
    /**
     * 所属单位名称翻译（专业化公司/直属单位）
     */
    private String affiliatedUnitText="";
    /**
     * 公示状态 1未公示  2公式中  3公示完成
     */
    private String publicityStatus;
    /**
     * 公示状态翻译   1未公示  2公式中  3公示完成
     */
    private String publicityStatusText;

    /**
     * 公示开始时间
     */
    private Date publicityStartDate;
    /**
     * 公示结束时间
     */
    private Date publicityEndDate;


    /**
     * 预计净收入
     */
    private BigDecimal incomeMoney = new BigDecimal("0");
    /**
     * 转化金额
     */
    private BigDecimal transMoney = new BigDecimal("0");
    /**
     * 总计激励金额
     */
    private BigDecimal rewardMoney = new BigDecimal("0");
    /**
     * 本年激励金额
     */
    private BigDecimal currentRewardMoney = new BigDecimal("0");
    /**
     * 未完成项目预计完成时间
     */
    private Date aboutCompleteTime=new Date();
    /**
     * 未完成项目预计完成情况
     */
    private String aboutCompleteInfo="";

    /**
     * 未完成项目预计完成情况字典值
     */
    private String aboutCompleteInfoText="";
    /**
     * 技术族类型（技术族）
     */
    private String achieveTechType="";
    /**
     * 技术族类型（技术族）关联名称
     */
    private String achieveTechTypeText;
    /**
     * 渠道
     */
    private String projectChannel="";
    /**
     * 项目来源
     */
    private String projectSource="";
    /**
     * 知识产权情况
     */
    private String intellectualInfo="";
    /**
     * 团队情况
     */
    private String teamInfo="";
    /**
     * 科技成果评价报告（文件上传）
     */
    private String appraisalDoc="";
    /**
     * 授拟-单位
     */
    private String grantUnitName="";
    /**
     * 授拟-原因
     */
    private String grantReason="";
    /**
     * 授拟-调查情况
     */
    private String grantInvest="";
    /**
     * 授拟-选择单位方式或理由
     */
    private String grantChooseWay="";
    /**
     * 授拟-（文件上传）：材料
     */
    private String grantDoc="";
    /**
     * 成果转化-定价原则及依据
     */
    private String transPriceBasis="";
    /**
     * 成果转化-定价方式
     */
    private String transPriceWay="";
    /**
     * 公示结果：材料
     */
    private String transPublicDoc="";
    /**
     * 合同文本：材料
     */
    private String transContractDoc="";
    /**
     * 评估报告：材料
     */
    private String transAssessDoc="";
    /**
     * 决策流程
     */
    private String decisionFlow="";
    /**
     * 决策结果
     */
    private String decisionResult="";
    /**
     * 决策会议纪要：材料
     */
    private String decisionMeetingDoc="";
    /**
     * 规章制度：材料
     */
    private String decisionRuleDoc="";
    /**
     * 团队成员
     */
    private String teamPerson="";

    private List<AchieveReward> achieveRewards;


    /**
     * 附件
     */
    private String files="";

    /**
     * 成果等级
     */
    private String level="";
    /**
     * 成果等级字典表翻译
     */
    private String levelText="";



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getAchieveType() {
        return achieveType;
    }

    public void setAchieveType(String achieveType) {
        this.achieveType = achieveType;
    }

    public String getAchieveTransType() {
        return achieveTransType;
    }

    public void setAchieveTransType(String achieveTransType) {
        this.achieveTransType = achieveTransType;
    }

    public String getAchieveTransStatus() {
        return achieveTransStatus;
    }

    public void setAchieveTransStatus(String achieveTransStatus) {
        this.achieveTransStatus = achieveTransStatus;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getAchieveInfo() {
        return achieveInfo;
    }

    public void setAchieveInfo(String achieveInfo) {
        this.achieveInfo = achieveInfo;
    }

    public String getFinishUnitName() {
        return finishUnitName;
    }

    public void setFinishUnitName(String finishUnitName) {
        this.finishUnitName = finishUnitName;
    }

    public BigDecimal getIncomeMoney() {
        return incomeMoney;
    }

    public void setIncomeMoney(BigDecimal incomeMoney) {
        this.incomeMoney = incomeMoney;
    }

    public BigDecimal getTransMoney() {
        return transMoney;
    }

    public void setTransMoney(BigDecimal transMoney) {
        this.transMoney = transMoney;
    }

    public BigDecimal getRewardMoney() {
        return rewardMoney;
    }

    public void setRewardMoney(BigDecimal rewardMoney) {
        this.rewardMoney = rewardMoney;
    }

    public BigDecimal getCurrentRewardMoney() {
        return currentRewardMoney;
    }

    public void setCurrentRewardMoney(BigDecimal currentRewardMoney) {
        this.currentRewardMoney = currentRewardMoney;
    }

    public Date getAboutCompleteTime() {
        return aboutCompleteTime;
    }

    public void setAboutCompleteTime(Date aboutCompleteTime) {
        this.aboutCompleteTime = aboutCompleteTime;
    }

    public String getAboutCompleteInfo() {
        return aboutCompleteInfo;
    }

    public void setAboutCompleteInfo(String aboutCompleteInfo) {
        this.aboutCompleteInfo = aboutCompleteInfo;
    }

    public String getAchieveTechType() {
        return achieveTechType;
    }

    public void setAchieveTechType(String achieveTechType) {
        this.achieveTechType = achieveTechType;
    }

    public String getProjectChannel() {
        return projectChannel;
    }

    public void setProjectChannel(String projectChannel) {
        this.projectChannel = projectChannel;
    }

    public String getProjectSource() {
        return projectSource;
    }

    public void setProjectSource(String projectSource) {
        this.projectSource = projectSource;
    }

    public String getIntellectualInfo() {
        return intellectualInfo;
    }

    public void setIntellectualInfo(String intellectualInfo) {
        this.intellectualInfo = intellectualInfo;
    }

    public String getTeamInfo() {
        return teamInfo;
    }

    public void setTeamInfo(String teamInfo) {
        this.teamInfo = teamInfo;
    }

    public String getAppraisalDoc() {
        return appraisalDoc;
    }

    public void setAppraisalDoc(String appraisalDoc) {
        this.appraisalDoc = appraisalDoc;
    }

    public String getGrantUnitName() {
        return grantUnitName;
    }

    public void setGrantUnitName(String grantUnitName) {
        this.grantUnitName = grantUnitName;
    }

    public String getGrantReason() {
        return grantReason;
    }

    public void setGrantReason(String grantReason) {
        this.grantReason = grantReason;
    }

    public String getGrantInvest() {
        return grantInvest;
    }

    public void setGrantInvest(String grantInvest) {
        this.grantInvest = grantInvest;
    }

    public String getGrantChooseWay() {
        return grantChooseWay;
    }

    public void setGrantChooseWay(String grantChooseWay) {
        this.grantChooseWay = grantChooseWay;
    }

    public String getGrantDoc() {
        return grantDoc;
    }

    public void setGrantDoc(String grantDoc) {
        this.grantDoc = grantDoc;
    }

    public String getTransPriceBasis() {
        return transPriceBasis;
    }

    public void setTransPriceBasis(String transPriceBasis) {
        this.transPriceBasis = transPriceBasis;
    }

    public String getTransPriceWay() {
        return transPriceWay;
    }

    public void setTransPriceWay(String transPriceWay) {
        this.transPriceWay = transPriceWay;
    }

    public String getTransPublicDoc() {
        return transPublicDoc;
    }

    public void setTransPublicDoc(String transPublicDoc) {
        this.transPublicDoc = transPublicDoc;
    }

    public String getTransContractDoc() {
        return transContractDoc;
    }

    public void setTransContractDoc(String transContractDoc) {
        this.transContractDoc = transContractDoc;
    }

    public String getTransAssessDoc() {
        return transAssessDoc;
    }

    public void setTransAssessDoc(String transAssessDoc) {
        this.transAssessDoc = transAssessDoc;
    }

    public String getDecisionFlow() {
        return decisionFlow;
    }

    public void setDecisionFlow(String decisionFlow) {
        this.decisionFlow = decisionFlow;
    }

    public String getDecisionResult() {
        return decisionResult;
    }

    public void setDecisionResult(String decisionResult) {
        this.decisionResult = decisionResult;
    }

    public String getDecisionMeetingDoc() {
        return decisionMeetingDoc;
    }

    public void setDecisionMeetingDoc(String decisionMeetingDoc) {
        this.decisionMeetingDoc = decisionMeetingDoc;
    }

    public String getDecisionRuleDoc() {
        return decisionRuleDoc;
    }

    public void setDecisionRuleDoc(String decisionRuleDoc) {
        this.decisionRuleDoc = decisionRuleDoc;
    }


    public String getAchieveTypeText() {
        return achieveTypeText;
    }

    public void setAchieveTypeText(String achieveTypeText) {
        this.achieveTypeText = achieveTypeText;
    }

    public String getAchieveTransTypeText() {
        return achieveTransTypeText;
    }

    public void setAchieveTransTypeText(String achieveTransTypeText) {
        this.achieveTransTypeText = achieveTransTypeText;
    }

    public String getAchieveTransStatusText() {
        return achieveTransStatusText;
    }

    public void setAchieveTransStatusText(String achieveTransStatusText) {
        this.achieveTransStatusText = achieveTransStatusText;
    }

    public String getAuditStatusText() {
        return auditStatusText;
    }

    public void setAuditStatusText(String auditStatusText) {
        this.auditStatusText = auditStatusText;
    }

    public String getAchieveTechTypeText() {
        return achieveTechTypeText;
    }

    public void setAchieveTechTypeText(String achieveTechTypeText) {
        this.achieveTechTypeText = achieveTechTypeText;
    }

    public String getTeamPerson() {
        return teamPerson;
    }

    public void setTeamPerson(String teamPerson) {
        this.teamPerson = teamPerson;
    }

    public List<AchieveReward> getAchieveRewards() {
        return achieveRewards;
    }

    public void setAchieveRewards(List<AchieveReward> achieveRewards) {
        this.achieveRewards = achieveRewards;
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
    }

    public String getAboutCompleteInfoText() {
        return aboutCompleteInfoText;
    }

    public void setAboutCompleteInfoText(String aboutCompleteInfoText) {
        this.aboutCompleteInfoText = aboutCompleteInfoText;
    }

    public String getFinishUnitNameText() {
        return finishUnitNameText;
    }

    public void setFinishUnitNameText(String finishUnitNameText) {
        this.finishUnitNameText = finishUnitNameText;
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

    public String getPublicityStatus() {
        return publicityStatus;
    }

    public void setPublicityStatus(String publicityStatus) {
        this.publicityStatus = publicityStatus;
    }

    public String getPublicityStatusText() {
        return publicityStatusText;
    }

    public void setPublicityStatusText(String publicityStatusText) {
        this.publicityStatusText = publicityStatusText;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevelText() {
        return levelText;
    }

    public void setLevelText(String levelText) {
        this.levelText = levelText;
    }

    public Date getPublicityStartDate() {
        return publicityStartDate;
    }

    public void setPublicityStartDate(Date publicityStartDate) {
        this.publicityStartDate = publicityStartDate;
    }

    public Date getPublicityEndDate() {
        return publicityEndDate;
    }

    public void setPublicityEndDate(Date publicityEndDate) {
        this.publicityEndDate = publicityEndDate;
    }
}
