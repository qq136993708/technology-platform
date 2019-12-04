package com.pcitc.base.achieve;

import com.pcitc.base.common.RecordModel;

/**
 * 奖励表
 * @author ty
 */
public class AchieveReward extends RecordModel {

    /**
     * 数据主键
     */
    private String id;
    /**
     * 成果备案ID
     */
    private String achieve_record_id;
    /**
     * 成果ID(非核心成果时为空)
     */
    private String achieveId;
    /**
     * 激励年份
     */
    private String rewardYear;
    /**
     * 转化收入
     */
    private String transIncome;
    /**
     * 核算依据
     */
    private String checkBasis;
    /**
     * 全周期净收入计算
     */
    private String incomeCalculation;
    /**
     * 激励方案
     */
    private String rewardRecord;
    /**
     * 激励额度
     */
    private String rewardQuota;
    /**
     * 工资预算来源
     */
    private String budgetSources;
    /**
     * 激励人员名单
     */
    private String budgetPerson;
    /**
     * 激励总和
     */
    private String budgetAllMoney;
    /**
     * 激励分配方案
     */
    private String assignPlan;
    /**
     * 净收入计算报告：材料
     */
    private String incomeReportDoc;
    /**
     * 激励方案：材料
     */
    private String assignPlanDoc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAchieve_record_id() {
        return achieve_record_id;
    }

    public void setAchieve_record_id(String achieve_record_id) {
        this.achieve_record_id = achieve_record_id;
    }

    public String getAchieveId() {
        return achieveId;
    }

    public void setAchieveId(String achieveId) {
        this.achieveId = achieveId;
    }

    public String getRewardYear() {
        return rewardYear;
    }

    public void setRewardYear(String rewardYear) {
        this.rewardYear = rewardYear;
    }

    public String getTransIncome() {
        return transIncome;
    }

    public void setTransIncome(String transIncome) {
        this.transIncome = transIncome;
    }

    public String getCheckBasis() {
        return checkBasis;
    }

    public void setCheckBasis(String checkBasis) {
        this.checkBasis = checkBasis;
    }

    public String getIncomeCalculation() {
        return incomeCalculation;
    }

    public void setIncomeCalculation(String incomeCalculation) {
        this.incomeCalculation = incomeCalculation;
    }

    public String getRewardRecord() {
        return rewardRecord;
    }

    public void setRewardRecord(String rewardRecord) {
        this.rewardRecord = rewardRecord;
    }

    public String getRewardQuota() {
        return rewardQuota;
    }

    public void setRewardQuota(String rewardQuota) {
        this.rewardQuota = rewardQuota;
    }

    public String getBudgetSources() {
        return budgetSources;
    }

    public void setBudgetSources(String budgetSources) {
        this.budgetSources = budgetSources;
    }

    public String getBudgetPerson() {
        return budgetPerson;
    }

    public void setBudgetPerson(String budgetPerson) {
        this.budgetPerson = budgetPerson;
    }

    public String getBudgetAllMoney() {
        return budgetAllMoney;
    }

    public void setBudgetAllMoney(String budgetAllMoney) {
        this.budgetAllMoney = budgetAllMoney;
    }

    public String getAssignPlan() {
        return assignPlan;
    }

    public void setAssignPlan(String assignPlan) {
        this.assignPlan = assignPlan;
    }

    public String getIncomeReportDoc() {
        return incomeReportDoc;
    }

    public void setIncomeReportDoc(String incomeReportDoc) {
        this.incomeReportDoc = incomeReportDoc;
    }

    public String getAssignPlanDoc() {
        return assignPlanDoc;
    }

    public void setAssignPlanDoc(String assignPlanDoc) {
        this.assignPlanDoc = assignPlanDoc;
    }
}
