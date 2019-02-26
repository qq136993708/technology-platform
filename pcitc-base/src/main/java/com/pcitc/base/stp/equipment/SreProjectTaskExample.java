package com.pcitc.base.stp.equipment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SreProjectTaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SreProjectTaskExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(String value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(String value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(String value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(String value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(String value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(String value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLike(String value) {
            addCriterion("task_id like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotLike(String value) {
            addCriterion("task_id not like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<String> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<String> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(String value1, String value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(String value1, String value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(String value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(String value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(String value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(String value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(String value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLike(String value) {
            addCriterion("project_id like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotLike(String value) {
            addCriterion("project_id not like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<String> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<String> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(String value1, String value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(String value1, String value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNull() {
            addCriterion("create_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("create_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(String value) {
            addCriterion("create_user_id =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(String value) {
            addCriterion("create_user_id <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(String value) {
            addCriterion("create_user_id >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("create_user_id >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(String value) {
            addCriterion("create_user_id <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(String value) {
            addCriterion("create_user_id <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLike(String value) {
            addCriterion("create_user_id like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotLike(String value) {
            addCriterion("create_user_id not like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<String> values) {
            addCriterion("create_user_id in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<String> values) {
            addCriterion("create_user_id not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(String value1, String value2) {
            addCriterion("create_user_id between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(String value1, String value2) {
            addCriterion("create_user_id not between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andTaskMainTaskContentIsNull() {
            addCriterion("task_main_task_content is null");
            return (Criteria) this;
        }

        public Criteria andTaskMainTaskContentIsNotNull() {
            addCriterion("task_main_task_content is not null");
            return (Criteria) this;
        }

        public Criteria andTaskMainTaskContentEqualTo(String value) {
            addCriterion("task_main_task_content =", value, "taskMainTaskContent");
            return (Criteria) this;
        }

        public Criteria andTaskMainTaskContentNotEqualTo(String value) {
            addCriterion("task_main_task_content <>", value, "taskMainTaskContent");
            return (Criteria) this;
        }

        public Criteria andTaskMainTaskContentGreaterThan(String value) {
            addCriterion("task_main_task_content >", value, "taskMainTaskContent");
            return (Criteria) this;
        }

        public Criteria andTaskMainTaskContentGreaterThanOrEqualTo(String value) {
            addCriterion("task_main_task_content >=", value, "taskMainTaskContent");
            return (Criteria) this;
        }

        public Criteria andTaskMainTaskContentLessThan(String value) {
            addCriterion("task_main_task_content <", value, "taskMainTaskContent");
            return (Criteria) this;
        }

        public Criteria andTaskMainTaskContentLessThanOrEqualTo(String value) {
            addCriterion("task_main_task_content <=", value, "taskMainTaskContent");
            return (Criteria) this;
        }

        public Criteria andTaskMainTaskContentLike(String value) {
            addCriterion("task_main_task_content like", value, "taskMainTaskContent");
            return (Criteria) this;
        }

        public Criteria andTaskMainTaskContentNotLike(String value) {
            addCriterion("task_main_task_content not like", value, "taskMainTaskContent");
            return (Criteria) this;
        }

        public Criteria andTaskMainTaskContentIn(List<String> values) {
            addCriterion("task_main_task_content in", values, "taskMainTaskContent");
            return (Criteria) this;
        }

        public Criteria andTaskMainTaskContentNotIn(List<String> values) {
            addCriterion("task_main_task_content not in", values, "taskMainTaskContent");
            return (Criteria) this;
        }

        public Criteria andTaskMainTaskContentBetween(String value1, String value2) {
            addCriterion("task_main_task_content between", value1, value2, "taskMainTaskContent");
            return (Criteria) this;
        }

        public Criteria andTaskMainTaskContentNotBetween(String value1, String value2) {
            addCriterion("task_main_task_content not between", value1, value2, "taskMainTaskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentIsNull() {
            addCriterion("task_content is null");
            return (Criteria) this;
        }

        public Criteria andTaskContentIsNotNull() {
            addCriterion("task_content is not null");
            return (Criteria) this;
        }

        public Criteria andTaskContentEqualTo(String value) {
            addCriterion("task_content =", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotEqualTo(String value) {
            addCriterion("task_content <>", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentGreaterThan(String value) {
            addCriterion("task_content >", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentGreaterThanOrEqualTo(String value) {
            addCriterion("task_content >=", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentLessThan(String value) {
            addCriterion("task_content <", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentLessThanOrEqualTo(String value) {
            addCriterion("task_content <=", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentLike(String value) {
            addCriterion("task_content like", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotLike(String value) {
            addCriterion("task_content not like", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentIn(List<String> values) {
            addCriterion("task_content in", values, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotIn(List<String> values) {
            addCriterion("task_content not in", values, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentBetween(String value1, String value2) {
            addCriterion("task_content between", value1, value2, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotBetween(String value1, String value2) {
            addCriterion("task_content not between", value1, value2, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskAssessmentContentIsNull() {
            addCriterion("task_assessment_content is null");
            return (Criteria) this;
        }

        public Criteria andTaskAssessmentContentIsNotNull() {
            addCriterion("task_assessment_content is not null");
            return (Criteria) this;
        }

        public Criteria andTaskAssessmentContentEqualTo(String value) {
            addCriterion("task_assessment_content =", value, "taskAssessmentContent");
            return (Criteria) this;
        }

        public Criteria andTaskAssessmentContentNotEqualTo(String value) {
            addCriterion("task_assessment_content <>", value, "taskAssessmentContent");
            return (Criteria) this;
        }

        public Criteria andTaskAssessmentContentGreaterThan(String value) {
            addCriterion("task_assessment_content >", value, "taskAssessmentContent");
            return (Criteria) this;
        }

        public Criteria andTaskAssessmentContentGreaterThanOrEqualTo(String value) {
            addCriterion("task_assessment_content >=", value, "taskAssessmentContent");
            return (Criteria) this;
        }

        public Criteria andTaskAssessmentContentLessThan(String value) {
            addCriterion("task_assessment_content <", value, "taskAssessmentContent");
            return (Criteria) this;
        }

        public Criteria andTaskAssessmentContentLessThanOrEqualTo(String value) {
            addCriterion("task_assessment_content <=", value, "taskAssessmentContent");
            return (Criteria) this;
        }

        public Criteria andTaskAssessmentContentLike(String value) {
            addCriterion("task_assessment_content like", value, "taskAssessmentContent");
            return (Criteria) this;
        }

        public Criteria andTaskAssessmentContentNotLike(String value) {
            addCriterion("task_assessment_content not like", value, "taskAssessmentContent");
            return (Criteria) this;
        }

        public Criteria andTaskAssessmentContentIn(List<String> values) {
            addCriterion("task_assessment_content in", values, "taskAssessmentContent");
            return (Criteria) this;
        }

        public Criteria andTaskAssessmentContentNotIn(List<String> values) {
            addCriterion("task_assessment_content not in", values, "taskAssessmentContent");
            return (Criteria) this;
        }

        public Criteria andTaskAssessmentContentBetween(String value1, String value2) {
            addCriterion("task_assessment_content between", value1, value2, "taskAssessmentContent");
            return (Criteria) this;
        }

        public Criteria andTaskAssessmentContentNotBetween(String value1, String value2) {
            addCriterion("task_assessment_content not between", value1, value2, "taskAssessmentContent");
            return (Criteria) this;
        }

        public Criteria andTaskCheckContentsIsNull() {
            addCriterion("task_check_contents is null");
            return (Criteria) this;
        }

        public Criteria andTaskCheckContentsIsNotNull() {
            addCriterion("task_check_contents is not null");
            return (Criteria) this;
        }

        public Criteria andTaskCheckContentsEqualTo(String value) {
            addCriterion("task_check_contents =", value, "taskCheckContents");
            return (Criteria) this;
        }

        public Criteria andTaskCheckContentsNotEqualTo(String value) {
            addCriterion("task_check_contents <>", value, "taskCheckContents");
            return (Criteria) this;
        }

        public Criteria andTaskCheckContentsGreaterThan(String value) {
            addCriterion("task_check_contents >", value, "taskCheckContents");
            return (Criteria) this;
        }

        public Criteria andTaskCheckContentsGreaterThanOrEqualTo(String value) {
            addCriterion("task_check_contents >=", value, "taskCheckContents");
            return (Criteria) this;
        }

        public Criteria andTaskCheckContentsLessThan(String value) {
            addCriterion("task_check_contents <", value, "taskCheckContents");
            return (Criteria) this;
        }

        public Criteria andTaskCheckContentsLessThanOrEqualTo(String value) {
            addCriterion("task_check_contents <=", value, "taskCheckContents");
            return (Criteria) this;
        }

        public Criteria andTaskCheckContentsLike(String value) {
            addCriterion("task_check_contents like", value, "taskCheckContents");
            return (Criteria) this;
        }

        public Criteria andTaskCheckContentsNotLike(String value) {
            addCriterion("task_check_contents not like", value, "taskCheckContents");
            return (Criteria) this;
        }

        public Criteria andTaskCheckContentsIn(List<String> values) {
            addCriterion("task_check_contents in", values, "taskCheckContents");
            return (Criteria) this;
        }

        public Criteria andTaskCheckContentsNotIn(List<String> values) {
            addCriterion("task_check_contents not in", values, "taskCheckContents");
            return (Criteria) this;
        }

        public Criteria andTaskCheckContentsBetween(String value1, String value2) {
            addCriterion("task_check_contents between", value1, value2, "taskCheckContents");
            return (Criteria) this;
        }

        public Criteria andTaskCheckContentsNotBetween(String value1, String value2) {
            addCriterion("task_check_contents not between", value1, value2, "taskCheckContents");
            return (Criteria) this;
        }

        public Criteria andBudgetTableIsNull() {
            addCriterion("budget_table is null");
            return (Criteria) this;
        }

        public Criteria andBudgetTableIsNotNull() {
            addCriterion("budget_table is not null");
            return (Criteria) this;
        }

        public Criteria andBudgetTableEqualTo(String value) {
            addCriterion("budget_table =", value, "budgetTable");
            return (Criteria) this;
        }

        public Criteria andBudgetTableNotEqualTo(String value) {
            addCriterion("budget_table <>", value, "budgetTable");
            return (Criteria) this;
        }

        public Criteria andBudgetTableGreaterThan(String value) {
            addCriterion("budget_table >", value, "budgetTable");
            return (Criteria) this;
        }

        public Criteria andBudgetTableGreaterThanOrEqualTo(String value) {
            addCriterion("budget_table >=", value, "budgetTable");
            return (Criteria) this;
        }

        public Criteria andBudgetTableLessThan(String value) {
            addCriterion("budget_table <", value, "budgetTable");
            return (Criteria) this;
        }

        public Criteria andBudgetTableLessThanOrEqualTo(String value) {
            addCriterion("budget_table <=", value, "budgetTable");
            return (Criteria) this;
        }

        public Criteria andBudgetTableLike(String value) {
            addCriterion("budget_table like", value, "budgetTable");
            return (Criteria) this;
        }

        public Criteria andBudgetTableNotLike(String value) {
            addCriterion("budget_table not like", value, "budgetTable");
            return (Criteria) this;
        }

        public Criteria andBudgetTableIn(List<String> values) {
            addCriterion("budget_table in", values, "budgetTable");
            return (Criteria) this;
        }

        public Criteria andBudgetTableNotIn(List<String> values) {
            addCriterion("budget_table not in", values, "budgetTable");
            return (Criteria) this;
        }

        public Criteria andBudgetTableBetween(String value1, String value2) {
            addCriterion("budget_table between", value1, value2, "budgetTable");
            return (Criteria) this;
        }

        public Criteria andBudgetTableNotBetween(String value1, String value2) {
            addCriterion("budget_table not between", value1, value2, "budgetTable");
            return (Criteria) this;
        }

        public Criteria andFundsSourcesTableIsNull() {
            addCriterion("funds_sources_table is null");
            return (Criteria) this;
        }

        public Criteria andFundsSourcesTableIsNotNull() {
            addCriterion("funds_sources_table is not null");
            return (Criteria) this;
        }

        public Criteria andFundsSourcesTableEqualTo(String value) {
            addCriterion("funds_sources_table =", value, "fundsSourcesTable");
            return (Criteria) this;
        }

        public Criteria andFundsSourcesTableNotEqualTo(String value) {
            addCriterion("funds_sources_table <>", value, "fundsSourcesTable");
            return (Criteria) this;
        }

        public Criteria andFundsSourcesTableGreaterThan(String value) {
            addCriterion("funds_sources_table >", value, "fundsSourcesTable");
            return (Criteria) this;
        }

        public Criteria andFundsSourcesTableGreaterThanOrEqualTo(String value) {
            addCriterion("funds_sources_table >=", value, "fundsSourcesTable");
            return (Criteria) this;
        }

        public Criteria andFundsSourcesTableLessThan(String value) {
            addCriterion("funds_sources_table <", value, "fundsSourcesTable");
            return (Criteria) this;
        }

        public Criteria andFundsSourcesTableLessThanOrEqualTo(String value) {
            addCriterion("funds_sources_table <=", value, "fundsSourcesTable");
            return (Criteria) this;
        }

        public Criteria andFundsSourcesTableLike(String value) {
            addCriterion("funds_sources_table like", value, "fundsSourcesTable");
            return (Criteria) this;
        }

        public Criteria andFundsSourcesTableNotLike(String value) {
            addCriterion("funds_sources_table not like", value, "fundsSourcesTable");
            return (Criteria) this;
        }

        public Criteria andFundsSourcesTableIn(List<String> values) {
            addCriterion("funds_sources_table in", values, "fundsSourcesTable");
            return (Criteria) this;
        }

        public Criteria andFundsSourcesTableNotIn(List<String> values) {
            addCriterion("funds_sources_table not in", values, "fundsSourcesTable");
            return (Criteria) this;
        }

        public Criteria andFundsSourcesTableBetween(String value1, String value2) {
            addCriterion("funds_sources_table between", value1, value2, "fundsSourcesTable");
            return (Criteria) this;
        }

        public Criteria andFundsSourcesTableNotBetween(String value1, String value2) {
            addCriterion("funds_sources_table not between", value1, value2, "fundsSourcesTable");
            return (Criteria) this;
        }

        public Criteria andProjectFundsTableIsNull() {
            addCriterion("project_funds_table is null");
            return (Criteria) this;
        }

        public Criteria andProjectFundsTableIsNotNull() {
            addCriterion("project_funds_table is not null");
            return (Criteria) this;
        }

        public Criteria andProjectFundsTableEqualTo(String value) {
            addCriterion("project_funds_table =", value, "projectFundsTable");
            return (Criteria) this;
        }

        public Criteria andProjectFundsTableNotEqualTo(String value) {
            addCriterion("project_funds_table <>", value, "projectFundsTable");
            return (Criteria) this;
        }

        public Criteria andProjectFundsTableGreaterThan(String value) {
            addCriterion("project_funds_table >", value, "projectFundsTable");
            return (Criteria) this;
        }

        public Criteria andProjectFundsTableGreaterThanOrEqualTo(String value) {
            addCriterion("project_funds_table >=", value, "projectFundsTable");
            return (Criteria) this;
        }

        public Criteria andProjectFundsTableLessThan(String value) {
            addCriterion("project_funds_table <", value, "projectFundsTable");
            return (Criteria) this;
        }

        public Criteria andProjectFundsTableLessThanOrEqualTo(String value) {
            addCriterion("project_funds_table <=", value, "projectFundsTable");
            return (Criteria) this;
        }

        public Criteria andProjectFundsTableLike(String value) {
            addCriterion("project_funds_table like", value, "projectFundsTable");
            return (Criteria) this;
        }

        public Criteria andProjectFundsTableNotLike(String value) {
            addCriterion("project_funds_table not like", value, "projectFundsTable");
            return (Criteria) this;
        }

        public Criteria andProjectFundsTableIn(List<String> values) {
            addCriterion("project_funds_table in", values, "projectFundsTable");
            return (Criteria) this;
        }

        public Criteria andProjectFundsTableNotIn(List<String> values) {
            addCriterion("project_funds_table not in", values, "projectFundsTable");
            return (Criteria) this;
        }

        public Criteria andProjectFundsTableBetween(String value1, String value2) {
            addCriterion("project_funds_table between", value1, value2, "projectFundsTable");
            return (Criteria) this;
        }

        public Criteria andProjectFundsTableNotBetween(String value1, String value2) {
            addCriterion("project_funds_table not between", value1, value2, "projectFundsTable");
            return (Criteria) this;
        }

        public Criteria andProjectNoticeIsNull() {
            addCriterion("project_notice is null");
            return (Criteria) this;
        }

        public Criteria andProjectNoticeIsNotNull() {
            addCriterion("project_notice is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNoticeEqualTo(String value) {
            addCriterion("project_notice =", value, "projectNotice");
            return (Criteria) this;
        }

        public Criteria andProjectNoticeNotEqualTo(String value) {
            addCriterion("project_notice <>", value, "projectNotice");
            return (Criteria) this;
        }

        public Criteria andProjectNoticeGreaterThan(String value) {
            addCriterion("project_notice >", value, "projectNotice");
            return (Criteria) this;
        }

        public Criteria andProjectNoticeGreaterThanOrEqualTo(String value) {
            addCriterion("project_notice >=", value, "projectNotice");
            return (Criteria) this;
        }

        public Criteria andProjectNoticeLessThan(String value) {
            addCriterion("project_notice <", value, "projectNotice");
            return (Criteria) this;
        }

        public Criteria andProjectNoticeLessThanOrEqualTo(String value) {
            addCriterion("project_notice <=", value, "projectNotice");
            return (Criteria) this;
        }

        public Criteria andProjectNoticeLike(String value) {
            addCriterion("project_notice like", value, "projectNotice");
            return (Criteria) this;
        }

        public Criteria andProjectNoticeNotLike(String value) {
            addCriterion("project_notice not like", value, "projectNotice");
            return (Criteria) this;
        }

        public Criteria andProjectNoticeIn(List<String> values) {
            addCriterion("project_notice in", values, "projectNotice");
            return (Criteria) this;
        }

        public Criteria andProjectNoticeNotIn(List<String> values) {
            addCriterion("project_notice not in", values, "projectNotice");
            return (Criteria) this;
        }

        public Criteria andProjectNoticeBetween(String value1, String value2) {
            addCriterion("project_notice between", value1, value2, "projectNotice");
            return (Criteria) this;
        }

        public Criteria andProjectNoticeNotBetween(String value1, String value2) {
            addCriterion("project_notice not between", value1, value2, "projectNotice");
            return (Criteria) this;
        }

        public Criteria andNotesIsNull() {
            addCriterion("notes is null");
            return (Criteria) this;
        }

        public Criteria andNotesIsNotNull() {
            addCriterion("notes is not null");
            return (Criteria) this;
        }

        public Criteria andNotesEqualTo(String value) {
            addCriterion("notes =", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotEqualTo(String value) {
            addCriterion("notes <>", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesGreaterThan(String value) {
            addCriterion("notes >", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesGreaterThanOrEqualTo(String value) {
            addCriterion("notes >=", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesLessThan(String value) {
            addCriterion("notes <", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesLessThanOrEqualTo(String value) {
            addCriterion("notes <=", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesLike(String value) {
            addCriterion("notes like", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotLike(String value) {
            addCriterion("notes not like", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesIn(List<String> values) {
            addCriterion("notes in", values, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotIn(List<String> values) {
            addCriterion("notes not in", values, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesBetween(String value1, String value2) {
            addCriterion("notes between", value1, value2, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotBetween(String value1, String value2) {
            addCriterion("notes not between", value1, value2, "notes");
            return (Criteria) this;
        }

        public Criteria andCoverIsNull() {
            addCriterion("cover is null");
            return (Criteria) this;
        }

        public Criteria andCoverIsNotNull() {
            addCriterion("cover is not null");
            return (Criteria) this;
        }

        public Criteria andCoverEqualTo(String value) {
            addCriterion("cover =", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotEqualTo(String value) {
            addCriterion("cover <>", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverGreaterThan(String value) {
            addCriterion("cover >", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverGreaterThanOrEqualTo(String value) {
            addCriterion("cover >=", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverLessThan(String value) {
            addCriterion("cover <", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverLessThanOrEqualTo(String value) {
            addCriterion("cover <=", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverLike(String value) {
            addCriterion("cover like", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotLike(String value) {
            addCriterion("cover not like", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverIn(List<String> values) {
            addCriterion("cover in", values, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotIn(List<String> values) {
            addCriterion("cover not in", values, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverBetween(String value1, String value2) {
            addCriterion("cover between", value1, value2, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotBetween(String value1, String value2) {
            addCriterion("cover not between", value1, value2, "cover");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}