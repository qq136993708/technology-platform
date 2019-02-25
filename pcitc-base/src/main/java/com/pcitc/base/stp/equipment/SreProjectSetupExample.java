package com.pcitc.base.stp.equipment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SreProjectSetupExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SreProjectSetupExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andReasonsSetupIsNull() {
            addCriterion("reasons_setup is null");
            return (Criteria) this;
        }

        public Criteria andReasonsSetupIsNotNull() {
            addCriterion("reasons_setup is not null");
            return (Criteria) this;
        }

        public Criteria andReasonsSetupEqualTo(String value) {
            addCriterion("reasons_setup =", value, "reasonsSetup");
            return (Criteria) this;
        }

        public Criteria andReasonsSetupNotEqualTo(String value) {
            addCriterion("reasons_setup <>", value, "reasonsSetup");
            return (Criteria) this;
        }

        public Criteria andReasonsSetupGreaterThan(String value) {
            addCriterion("reasons_setup >", value, "reasonsSetup");
            return (Criteria) this;
        }

        public Criteria andReasonsSetupGreaterThanOrEqualTo(String value) {
            addCriterion("reasons_setup >=", value, "reasonsSetup");
            return (Criteria) this;
        }

        public Criteria andReasonsSetupLessThan(String value) {
            addCriterion("reasons_setup <", value, "reasonsSetup");
            return (Criteria) this;
        }

        public Criteria andReasonsSetupLessThanOrEqualTo(String value) {
            addCriterion("reasons_setup <=", value, "reasonsSetup");
            return (Criteria) this;
        }

        public Criteria andReasonsSetupLike(String value) {
            addCriterion("reasons_setup like", value, "reasonsSetup");
            return (Criteria) this;
        }

        public Criteria andReasonsSetupNotLike(String value) {
            addCriterion("reasons_setup not like", value, "reasonsSetup");
            return (Criteria) this;
        }

        public Criteria andReasonsSetupIn(List<String> values) {
            addCriterion("reasons_setup in", values, "reasonsSetup");
            return (Criteria) this;
        }

        public Criteria andReasonsSetupNotIn(List<String> values) {
            addCriterion("reasons_setup not in", values, "reasonsSetup");
            return (Criteria) this;
        }

        public Criteria andReasonsSetupBetween(String value1, String value2) {
            addCriterion("reasons_setup between", value1, value2, "reasonsSetup");
            return (Criteria) this;
        }

        public Criteria andReasonsSetupNotBetween(String value1, String value2) {
            addCriterion("reasons_setup not between", value1, value2, "reasonsSetup");
            return (Criteria) this;
        }

        public Criteria andScaleProcessTableIsNull() {
            addCriterion("scale_process_table is null");
            return (Criteria) this;
        }

        public Criteria andScaleProcessTableIsNotNull() {
            addCriterion("scale_process_table is not null");
            return (Criteria) this;
        }

        public Criteria andScaleProcessTableEqualTo(String value) {
            addCriterion("scale_process_table =", value, "scaleProcessTable");
            return (Criteria) this;
        }

        public Criteria andScaleProcessTableNotEqualTo(String value) {
            addCriterion("scale_process_table <>", value, "scaleProcessTable");
            return (Criteria) this;
        }

        public Criteria andScaleProcessTableGreaterThan(String value) {
            addCriterion("scale_process_table >", value, "scaleProcessTable");
            return (Criteria) this;
        }

        public Criteria andScaleProcessTableGreaterThanOrEqualTo(String value) {
            addCriterion("scale_process_table >=", value, "scaleProcessTable");
            return (Criteria) this;
        }

        public Criteria andScaleProcessTableLessThan(String value) {
            addCriterion("scale_process_table <", value, "scaleProcessTable");
            return (Criteria) this;
        }

        public Criteria andScaleProcessTableLessThanOrEqualTo(String value) {
            addCriterion("scale_process_table <=", value, "scaleProcessTable");
            return (Criteria) this;
        }

        public Criteria andScaleProcessTableLike(String value) {
            addCriterion("scale_process_table like", value, "scaleProcessTable");
            return (Criteria) this;
        }

        public Criteria andScaleProcessTableNotLike(String value) {
            addCriterion("scale_process_table not like", value, "scaleProcessTable");
            return (Criteria) this;
        }

        public Criteria andScaleProcessTableIn(List<String> values) {
            addCriterion("scale_process_table in", values, "scaleProcessTable");
            return (Criteria) this;
        }

        public Criteria andScaleProcessTableNotIn(List<String> values) {
            addCriterion("scale_process_table not in", values, "scaleProcessTable");
            return (Criteria) this;
        }

        public Criteria andScaleProcessTableBetween(String value1, String value2) {
            addCriterion("scale_process_table between", value1, value2, "scaleProcessTable");
            return (Criteria) this;
        }

        public Criteria andScaleProcessTableNotBetween(String value1, String value2) {
            addCriterion("scale_process_table not between", value1, value2, "scaleProcessTable");
            return (Criteria) this;
        }

        public Criteria andFieldProjectIsNull() {
            addCriterion("field_project is null");
            return (Criteria) this;
        }

        public Criteria andFieldProjectIsNotNull() {
            addCriterion("field_project is not null");
            return (Criteria) this;
        }

        public Criteria andFieldProjectEqualTo(String value) {
            addCriterion("field_project =", value, "fieldProject");
            return (Criteria) this;
        }

        public Criteria andFieldProjectNotEqualTo(String value) {
            addCriterion("field_project <>", value, "fieldProject");
            return (Criteria) this;
        }

        public Criteria andFieldProjectGreaterThan(String value) {
            addCriterion("field_project >", value, "fieldProject");
            return (Criteria) this;
        }

        public Criteria andFieldProjectGreaterThanOrEqualTo(String value) {
            addCriterion("field_project >=", value, "fieldProject");
            return (Criteria) this;
        }

        public Criteria andFieldProjectLessThan(String value) {
            addCriterion("field_project <", value, "fieldProject");
            return (Criteria) this;
        }

        public Criteria andFieldProjectLessThanOrEqualTo(String value) {
            addCriterion("field_project <=", value, "fieldProject");
            return (Criteria) this;
        }

        public Criteria andFieldProjectLike(String value) {
            addCriterion("field_project like", value, "fieldProject");
            return (Criteria) this;
        }

        public Criteria andFieldProjectNotLike(String value) {
            addCriterion("field_project not like", value, "fieldProject");
            return (Criteria) this;
        }

        public Criteria andFieldProjectIn(List<String> values) {
            addCriterion("field_project in", values, "fieldProject");
            return (Criteria) this;
        }

        public Criteria andFieldProjectNotIn(List<String> values) {
            addCriterion("field_project not in", values, "fieldProject");
            return (Criteria) this;
        }

        public Criteria andFieldProjectBetween(String value1, String value2) {
            addCriterion("field_project between", value1, value2, "fieldProject");
            return (Criteria) this;
        }

        public Criteria andFieldProjectNotBetween(String value1, String value2) {
            addCriterion("field_project not between", value1, value2, "fieldProject");
            return (Criteria) this;
        }

        public Criteria andPlanProgressIsNull() {
            addCriterion("plan_progress is null");
            return (Criteria) this;
        }

        public Criteria andPlanProgressIsNotNull() {
            addCriterion("plan_progress is not null");
            return (Criteria) this;
        }

        public Criteria andPlanProgressEqualTo(String value) {
            addCriterion("plan_progress =", value, "planProgress");
            return (Criteria) this;
        }

        public Criteria andPlanProgressNotEqualTo(String value) {
            addCriterion("plan_progress <>", value, "planProgress");
            return (Criteria) this;
        }

        public Criteria andPlanProgressGreaterThan(String value) {
            addCriterion("plan_progress >", value, "planProgress");
            return (Criteria) this;
        }

        public Criteria andPlanProgressGreaterThanOrEqualTo(String value) {
            addCriterion("plan_progress >=", value, "planProgress");
            return (Criteria) this;
        }

        public Criteria andPlanProgressLessThan(String value) {
            addCriterion("plan_progress <", value, "planProgress");
            return (Criteria) this;
        }

        public Criteria andPlanProgressLessThanOrEqualTo(String value) {
            addCriterion("plan_progress <=", value, "planProgress");
            return (Criteria) this;
        }

        public Criteria andPlanProgressLike(String value) {
            addCriterion("plan_progress like", value, "planProgress");
            return (Criteria) this;
        }

        public Criteria andPlanProgressNotLike(String value) {
            addCriterion("plan_progress not like", value, "planProgress");
            return (Criteria) this;
        }

        public Criteria andPlanProgressIn(List<String> values) {
            addCriterion("plan_progress in", values, "planProgress");
            return (Criteria) this;
        }

        public Criteria andPlanProgressNotIn(List<String> values) {
            addCriterion("plan_progress not in", values, "planProgress");
            return (Criteria) this;
        }

        public Criteria andPlanProgressBetween(String value1, String value2) {
            addCriterion("plan_progress between", value1, value2, "planProgress");
            return (Criteria) this;
        }

        public Criteria andPlanProgressNotBetween(String value1, String value2) {
            addCriterion("plan_progress not between", value1, value2, "planProgress");
            return (Criteria) this;
        }

        public Criteria andBenefitIsNull() {
            addCriterion("benefit is null");
            return (Criteria) this;
        }

        public Criteria andBenefitIsNotNull() {
            addCriterion("benefit is not null");
            return (Criteria) this;
        }

        public Criteria andBenefitEqualTo(String value) {
            addCriterion("benefit =", value, "benefit");
            return (Criteria) this;
        }

        public Criteria andBenefitNotEqualTo(String value) {
            addCriterion("benefit <>", value, "benefit");
            return (Criteria) this;
        }

        public Criteria andBenefitGreaterThan(String value) {
            addCriterion("benefit >", value, "benefit");
            return (Criteria) this;
        }

        public Criteria andBenefitGreaterThanOrEqualTo(String value) {
            addCriterion("benefit >=", value, "benefit");
            return (Criteria) this;
        }

        public Criteria andBenefitLessThan(String value) {
            addCriterion("benefit <", value, "benefit");
            return (Criteria) this;
        }

        public Criteria andBenefitLessThanOrEqualTo(String value) {
            addCriterion("benefit <=", value, "benefit");
            return (Criteria) this;
        }

        public Criteria andBenefitLike(String value) {
            addCriterion("benefit like", value, "benefit");
            return (Criteria) this;
        }

        public Criteria andBenefitNotLike(String value) {
            addCriterion("benefit not like", value, "benefit");
            return (Criteria) this;
        }

        public Criteria andBenefitIn(List<String> values) {
            addCriterion("benefit in", values, "benefit");
            return (Criteria) this;
        }

        public Criteria andBenefitNotIn(List<String> values) {
            addCriterion("benefit not in", values, "benefit");
            return (Criteria) this;
        }

        public Criteria andBenefitBetween(String value1, String value2) {
            addCriterion("benefit between", value1, value2, "benefit");
            return (Criteria) this;
        }

        public Criteria andBenefitNotBetween(String value1, String value2) {
            addCriterion("benefit not between", value1, value2, "benefit");
            return (Criteria) this;
        }

        public Criteria andCapitalFundTableIsNull() {
            addCriterion("capital_fund_table is null");
            return (Criteria) this;
        }

        public Criteria andCapitalFundTableIsNotNull() {
            addCriterion("capital_fund_table is not null");
            return (Criteria) this;
        }

        public Criteria andCapitalFundTableEqualTo(String value) {
            addCriterion("capital_fund_table =", value, "capitalFundTable");
            return (Criteria) this;
        }

        public Criteria andCapitalFundTableNotEqualTo(String value) {
            addCriterion("capital_fund_table <>", value, "capitalFundTable");
            return (Criteria) this;
        }

        public Criteria andCapitalFundTableGreaterThan(String value) {
            addCriterion("capital_fund_table >", value, "capitalFundTable");
            return (Criteria) this;
        }

        public Criteria andCapitalFundTableGreaterThanOrEqualTo(String value) {
            addCriterion("capital_fund_table >=", value, "capitalFundTable");
            return (Criteria) this;
        }

        public Criteria andCapitalFundTableLessThan(String value) {
            addCriterion("capital_fund_table <", value, "capitalFundTable");
            return (Criteria) this;
        }

        public Criteria andCapitalFundTableLessThanOrEqualTo(String value) {
            addCriterion("capital_fund_table <=", value, "capitalFundTable");
            return (Criteria) this;
        }

        public Criteria andCapitalFundTableLike(String value) {
            addCriterion("capital_fund_table like", value, "capitalFundTable");
            return (Criteria) this;
        }

        public Criteria andCapitalFundTableNotLike(String value) {
            addCriterion("capital_fund_table not like", value, "capitalFundTable");
            return (Criteria) this;
        }

        public Criteria andCapitalFundTableIn(List<String> values) {
            addCriterion("capital_fund_table in", values, "capitalFundTable");
            return (Criteria) this;
        }

        public Criteria andCapitalFundTableNotIn(List<String> values) {
            addCriterion("capital_fund_table not in", values, "capitalFundTable");
            return (Criteria) this;
        }

        public Criteria andCapitalFundTableBetween(String value1, String value2) {
            addCriterion("capital_fund_table between", value1, value2, "capitalFundTable");
            return (Criteria) this;
        }

        public Criteria andCapitalFundTableNotBetween(String value1, String value2) {
            addCriterion("capital_fund_table not between", value1, value2, "capitalFundTable");
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

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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