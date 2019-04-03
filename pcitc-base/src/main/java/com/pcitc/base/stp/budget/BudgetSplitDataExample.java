package com.pcitc.base.stp.budget;

import java.util.ArrayList;
import java.util.List;

public class BudgetSplitDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BudgetSplitDataExample() {
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

        public Criteria andDataIdIsNull() {
            addCriterion("data_id is null");
            return (Criteria) this;
        }

        public Criteria andDataIdIsNotNull() {
            addCriterion("data_id is not null");
            return (Criteria) this;
        }

        public Criteria andDataIdEqualTo(String value) {
            addCriterion("data_id =", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotEqualTo(String value) {
            addCriterion("data_id <>", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdGreaterThan(String value) {
            addCriterion("data_id >", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdGreaterThanOrEqualTo(String value) {
            addCriterion("data_id >=", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdLessThan(String value) {
            addCriterion("data_id <", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdLessThanOrEqualTo(String value) {
            addCriterion("data_id <=", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdLike(String value) {
            addCriterion("data_id like", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotLike(String value) {
            addCriterion("data_id not like", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdIn(List<String> values) {
            addCriterion("data_id in", values, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotIn(List<String> values) {
            addCriterion("data_id not in", values, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdBetween(String value1, String value2) {
            addCriterion("data_id between", value1, value2, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotBetween(String value1, String value2) {
            addCriterion("data_id not between", value1, value2, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataVersionIsNull() {
            addCriterion("data_version is null");
            return (Criteria) this;
        }

        public Criteria andDataVersionIsNotNull() {
            addCriterion("data_version is not null");
            return (Criteria) this;
        }

        public Criteria andDataVersionEqualTo(String value) {
            addCriterion("data_version =", value, "dataVersion");
            return (Criteria) this;
        }

        public Criteria andDataVersionNotEqualTo(String value) {
            addCriterion("data_version <>", value, "dataVersion");
            return (Criteria) this;
        }

        public Criteria andDataVersionGreaterThan(String value) {
            addCriterion("data_version >", value, "dataVersion");
            return (Criteria) this;
        }

        public Criteria andDataVersionGreaterThanOrEqualTo(String value) {
            addCriterion("data_version >=", value, "dataVersion");
            return (Criteria) this;
        }

        public Criteria andDataVersionLessThan(String value) {
            addCriterion("data_version <", value, "dataVersion");
            return (Criteria) this;
        }

        public Criteria andDataVersionLessThanOrEqualTo(String value) {
            addCriterion("data_version <=", value, "dataVersion");
            return (Criteria) this;
        }

        public Criteria andDataVersionLike(String value) {
            addCriterion("data_version like", value, "dataVersion");
            return (Criteria) this;
        }

        public Criteria andDataVersionNotLike(String value) {
            addCriterion("data_version not like", value, "dataVersion");
            return (Criteria) this;
        }

        public Criteria andDataVersionIn(List<String> values) {
            addCriterion("data_version in", values, "dataVersion");
            return (Criteria) this;
        }

        public Criteria andDataVersionNotIn(List<String> values) {
            addCriterion("data_version not in", values, "dataVersion");
            return (Criteria) this;
        }

        public Criteria andDataVersionBetween(String value1, String value2) {
            addCriterion("data_version between", value1, value2, "dataVersion");
            return (Criteria) this;
        }

        public Criteria andDataVersionNotBetween(String value1, String value2) {
            addCriterion("data_version not between", value1, value2, "dataVersion");
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

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("create_time like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("create_time not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(String value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(String value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(String value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(String value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(String value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLike(String value) {
            addCriterion("update_time like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotLike(String value) {
            addCriterion("update_time not like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<String> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<String> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(String value1, String value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(String value1, String value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andOrganIdIsNull() {
            addCriterion("organ_id is null");
            return (Criteria) this;
        }

        public Criteria andOrganIdIsNotNull() {
            addCriterion("organ_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrganIdEqualTo(Integer value) {
            addCriterion("organ_id =", value, "organId");
            return (Criteria) this;
        }

        public Criteria andOrganIdNotEqualTo(Integer value) {
            addCriterion("organ_id <>", value, "organId");
            return (Criteria) this;
        }

        public Criteria andOrganIdGreaterThan(Integer value) {
            addCriterion("organ_id >", value, "organId");
            return (Criteria) this;
        }

        public Criteria andOrganIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("organ_id >=", value, "organId");
            return (Criteria) this;
        }

        public Criteria andOrganIdLessThan(Integer value) {
            addCriterion("organ_id <", value, "organId");
            return (Criteria) this;
        }

        public Criteria andOrganIdLessThanOrEqualTo(Integer value) {
            addCriterion("organ_id <=", value, "organId");
            return (Criteria) this;
        }

        public Criteria andOrganIdIn(List<Integer> values) {
            addCriterion("organ_id in", values, "organId");
            return (Criteria) this;
        }

        public Criteria andOrganIdNotIn(List<Integer> values) {
            addCriterion("organ_id not in", values, "organId");
            return (Criteria) this;
        }

        public Criteria andOrganIdBetween(Integer value1, Integer value2) {
            addCriterion("organ_id between", value1, value2, "organId");
            return (Criteria) this;
        }

        public Criteria andOrganIdNotBetween(Integer value1, Integer value2) {
            addCriterion("organ_id not between", value1, value2, "organId");
            return (Criteria) this;
        }

        public Criteria andOrganCodeIsNull() {
            addCriterion("organ_code is null");
            return (Criteria) this;
        }

        public Criteria andOrganCodeIsNotNull() {
            addCriterion("organ_code is not null");
            return (Criteria) this;
        }

        public Criteria andOrganCodeEqualTo(String value) {
            addCriterion("organ_code =", value, "organCode");
            return (Criteria) this;
        }

        public Criteria andOrganCodeNotEqualTo(String value) {
            addCriterion("organ_code <>", value, "organCode");
            return (Criteria) this;
        }

        public Criteria andOrganCodeGreaterThan(String value) {
            addCriterion("organ_code >", value, "organCode");
            return (Criteria) this;
        }

        public Criteria andOrganCodeGreaterThanOrEqualTo(String value) {
            addCriterion("organ_code >=", value, "organCode");
            return (Criteria) this;
        }

        public Criteria andOrganCodeLessThan(String value) {
            addCriterion("organ_code <", value, "organCode");
            return (Criteria) this;
        }

        public Criteria andOrganCodeLessThanOrEqualTo(String value) {
            addCriterion("organ_code <=", value, "organCode");
            return (Criteria) this;
        }

        public Criteria andOrganCodeLike(String value) {
            addCriterion("organ_code like", value, "organCode");
            return (Criteria) this;
        }

        public Criteria andOrganCodeNotLike(String value) {
            addCriterion("organ_code not like", value, "organCode");
            return (Criteria) this;
        }

        public Criteria andOrganCodeIn(List<String> values) {
            addCriterion("organ_code in", values, "organCode");
            return (Criteria) this;
        }

        public Criteria andOrganCodeNotIn(List<String> values) {
            addCriterion("organ_code not in", values, "organCode");
            return (Criteria) this;
        }

        public Criteria andOrganCodeBetween(String value1, String value2) {
            addCriterion("organ_code between", value1, value2, "organCode");
            return (Criteria) this;
        }

        public Criteria andOrganCodeNotBetween(String value1, String value2) {
            addCriterion("organ_code not between", value1, value2, "organCode");
            return (Criteria) this;
        }

        public Criteria andNdIsNull() {
            addCriterion("nd is null");
            return (Criteria) this;
        }

        public Criteria andNdIsNotNull() {
            addCriterion("nd is not null");
            return (Criteria) this;
        }

        public Criteria andNdEqualTo(String value) {
            addCriterion("nd =", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdNotEqualTo(String value) {
            addCriterion("nd <>", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdGreaterThan(String value) {
            addCriterion("nd >", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdGreaterThanOrEqualTo(String value) {
            addCriterion("nd >=", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdLessThan(String value) {
            addCriterion("nd <", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdLessThanOrEqualTo(String value) {
            addCriterion("nd <=", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdLike(String value) {
            addCriterion("nd like", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdNotLike(String value) {
            addCriterion("nd not like", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdIn(List<String> values) {
            addCriterion("nd in", values, "nd");
            return (Criteria) this;
        }

        public Criteria andNdNotIn(List<String> values) {
            addCriterion("nd not in", values, "nd");
            return (Criteria) this;
        }

        public Criteria andNdBetween(String value1, String value2) {
            addCriterion("nd between", value1, value2, "nd");
            return (Criteria) this;
        }

        public Criteria andNdNotBetween(String value1, String value2) {
            addCriterion("nd not between", value1, value2, "nd");
            return (Criteria) this;
        }

        public Criteria andBudgetTypeIsNull() {
            addCriterion("budget_type is null");
            return (Criteria) this;
        }

        public Criteria andBudgetTypeIsNotNull() {
            addCriterion("budget_type is not null");
            return (Criteria) this;
        }

        public Criteria andBudgetTypeEqualTo(Integer value) {
            addCriterion("budget_type =", value, "budgetType");
            return (Criteria) this;
        }

        public Criteria andBudgetTypeNotEqualTo(Integer value) {
            addCriterion("budget_type <>", value, "budgetType");
            return (Criteria) this;
        }

        public Criteria andBudgetTypeGreaterThan(Integer value) {
            addCriterion("budget_type >", value, "budgetType");
            return (Criteria) this;
        }

        public Criteria andBudgetTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("budget_type >=", value, "budgetType");
            return (Criteria) this;
        }

        public Criteria andBudgetTypeLessThan(Integer value) {
            addCriterion("budget_type <", value, "budgetType");
            return (Criteria) this;
        }

        public Criteria andBudgetTypeLessThanOrEqualTo(Integer value) {
            addCriterion("budget_type <=", value, "budgetType");
            return (Criteria) this;
        }

        public Criteria andBudgetTypeIn(List<Integer> values) {
            addCriterion("budget_type in", values, "budgetType");
            return (Criteria) this;
        }

        public Criteria andBudgetTypeNotIn(List<Integer> values) {
            addCriterion("budget_type not in", values, "budgetType");
            return (Criteria) this;
        }

        public Criteria andBudgetTypeBetween(Integer value1, Integer value2) {
            addCriterion("budget_type between", value1, value2, "budgetType");
            return (Criteria) this;
        }

        public Criteria andBudgetTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("budget_type not between", value1, value2, "budgetType");
            return (Criteria) this;
        }

        public Criteria andBudgetTypeNameIsNull() {
            addCriterion("budget_type_name is null");
            return (Criteria) this;
        }

        public Criteria andBudgetTypeNameIsNotNull() {
            addCriterion("budget_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andBudgetTypeNameEqualTo(String value) {
            addCriterion("budget_type_name =", value, "budgetTypeName");
            return (Criteria) this;
        }

        public Criteria andBudgetTypeNameNotEqualTo(String value) {
            addCriterion("budget_type_name <>", value, "budgetTypeName");
            return (Criteria) this;
        }

        public Criteria andBudgetTypeNameGreaterThan(String value) {
            addCriterion("budget_type_name >", value, "budgetTypeName");
            return (Criteria) this;
        }

        public Criteria andBudgetTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("budget_type_name >=", value, "budgetTypeName");
            return (Criteria) this;
        }

        public Criteria andBudgetTypeNameLessThan(String value) {
            addCriterion("budget_type_name <", value, "budgetTypeName");
            return (Criteria) this;
        }

        public Criteria andBudgetTypeNameLessThanOrEqualTo(String value) {
            addCriterion("budget_type_name <=", value, "budgetTypeName");
            return (Criteria) this;
        }

        public Criteria andBudgetTypeNameLike(String value) {
            addCriterion("budget_type_name like", value, "budgetTypeName");
            return (Criteria) this;
        }

        public Criteria andBudgetTypeNameNotLike(String value) {
            addCriterion("budget_type_name not like", value, "budgetTypeName");
            return (Criteria) this;
        }

        public Criteria andBudgetTypeNameIn(List<String> values) {
            addCriterion("budget_type_name in", values, "budgetTypeName");
            return (Criteria) this;
        }

        public Criteria andBudgetTypeNameNotIn(List<String> values) {
            addCriterion("budget_type_name not in", values, "budgetTypeName");
            return (Criteria) this;
        }

        public Criteria andBudgetTypeNameBetween(String value1, String value2) {
            addCriterion("budget_type_name between", value1, value2, "budgetTypeName");
            return (Criteria) this;
        }

        public Criteria andBudgetTypeNameNotBetween(String value1, String value2) {
            addCriterion("budget_type_name not between", value1, value2, "budgetTypeName");
            return (Criteria) this;
        }

        public Criteria andSplitCodeIsNull() {
            addCriterion("split_code is null");
            return (Criteria) this;
        }

        public Criteria andSplitCodeIsNotNull() {
            addCriterion("split_code is not null");
            return (Criteria) this;
        }

        public Criteria andSplitCodeEqualTo(String value) {
            addCriterion("split_code =", value, "splitCode");
            return (Criteria) this;
        }

        public Criteria andSplitCodeNotEqualTo(String value) {
            addCriterion("split_code <>", value, "splitCode");
            return (Criteria) this;
        }

        public Criteria andSplitCodeGreaterThan(String value) {
            addCriterion("split_code >", value, "splitCode");
            return (Criteria) this;
        }

        public Criteria andSplitCodeGreaterThanOrEqualTo(String value) {
            addCriterion("split_code >=", value, "splitCode");
            return (Criteria) this;
        }

        public Criteria andSplitCodeLessThan(String value) {
            addCriterion("split_code <", value, "splitCode");
            return (Criteria) this;
        }

        public Criteria andSplitCodeLessThanOrEqualTo(String value) {
            addCriterion("split_code <=", value, "splitCode");
            return (Criteria) this;
        }

        public Criteria andSplitCodeLike(String value) {
            addCriterion("split_code like", value, "splitCode");
            return (Criteria) this;
        }

        public Criteria andSplitCodeNotLike(String value) {
            addCriterion("split_code not like", value, "splitCode");
            return (Criteria) this;
        }

        public Criteria andSplitCodeIn(List<String> values) {
            addCriterion("split_code in", values, "splitCode");
            return (Criteria) this;
        }

        public Criteria andSplitCodeNotIn(List<String> values) {
            addCriterion("split_code not in", values, "splitCode");
            return (Criteria) this;
        }

        public Criteria andSplitCodeBetween(String value1, String value2) {
            addCriterion("split_code between", value1, value2, "splitCode");
            return (Criteria) this;
        }

        public Criteria andSplitCodeNotBetween(String value1, String value2) {
            addCriterion("split_code not between", value1, value2, "splitCode");
            return (Criteria) this;
        }

        public Criteria andSplitNameIsNull() {
            addCriterion("split_name is null");
            return (Criteria) this;
        }

        public Criteria andSplitNameIsNotNull() {
            addCriterion("split_name is not null");
            return (Criteria) this;
        }

        public Criteria andSplitNameEqualTo(String value) {
            addCriterion("split_name =", value, "splitName");
            return (Criteria) this;
        }

        public Criteria andSplitNameNotEqualTo(String value) {
            addCriterion("split_name <>", value, "splitName");
            return (Criteria) this;
        }

        public Criteria andSplitNameGreaterThan(String value) {
            addCriterion("split_name >", value, "splitName");
            return (Criteria) this;
        }

        public Criteria andSplitNameGreaterThanOrEqualTo(String value) {
            addCriterion("split_name >=", value, "splitName");
            return (Criteria) this;
        }

        public Criteria andSplitNameLessThan(String value) {
            addCriterion("split_name <", value, "splitName");
            return (Criteria) this;
        }

        public Criteria andSplitNameLessThanOrEqualTo(String value) {
            addCriterion("split_name <=", value, "splitName");
            return (Criteria) this;
        }

        public Criteria andSplitNameLike(String value) {
            addCriterion("split_name like", value, "splitName");
            return (Criteria) this;
        }

        public Criteria andSplitNameNotLike(String value) {
            addCriterion("split_name not like", value, "splitName");
            return (Criteria) this;
        }

        public Criteria andSplitNameIn(List<String> values) {
            addCriterion("split_name in", values, "splitName");
            return (Criteria) this;
        }

        public Criteria andSplitNameNotIn(List<String> values) {
            addCriterion("split_name not in", values, "splitName");
            return (Criteria) this;
        }

        public Criteria andSplitNameBetween(String value1, String value2) {
            addCriterion("split_name between", value1, value2, "splitName");
            return (Criteria) this;
        }

        public Criteria andSplitNameNotBetween(String value1, String value2) {
            addCriterion("split_name not between", value1, value2, "splitName");
            return (Criteria) this;
        }

        public Criteria andTotalIsNull() {
            addCriterion("total is null");
            return (Criteria) this;
        }

        public Criteria andTotalIsNotNull() {
            addCriterion("total is not null");
            return (Criteria) this;
        }

        public Criteria andTotalEqualTo(Double value) {
            addCriterion("total =", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotEqualTo(Double value) {
            addCriterion("total <>", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThan(Double value) {
            addCriterion("total >", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThanOrEqualTo(Double value) {
            addCriterion("total >=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThan(Double value) {
            addCriterion("total <", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThanOrEqualTo(Double value) {
            addCriterion("total <=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalIn(List<Double> values) {
            addCriterion("total in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotIn(List<Double> values) {
            addCriterion("total not in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalBetween(Double value1, Double value2) {
            addCriterion("total between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotBetween(Double value1, Double value2) {
            addCriterion("total not between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andJzIsNull() {
            addCriterion("jz is null");
            return (Criteria) this;
        }

        public Criteria andJzIsNotNull() {
            addCriterion("jz is not null");
            return (Criteria) this;
        }

        public Criteria andJzEqualTo(Double value) {
            addCriterion("jz =", value, "jz");
            return (Criteria) this;
        }

        public Criteria andJzNotEqualTo(Double value) {
            addCriterion("jz <>", value, "jz");
            return (Criteria) this;
        }

        public Criteria andJzGreaterThan(Double value) {
            addCriterion("jz >", value, "jz");
            return (Criteria) this;
        }

        public Criteria andJzGreaterThanOrEqualTo(Double value) {
            addCriterion("jz >=", value, "jz");
            return (Criteria) this;
        }

        public Criteria andJzLessThan(Double value) {
            addCriterion("jz <", value, "jz");
            return (Criteria) this;
        }

        public Criteria andJzLessThanOrEqualTo(Double value) {
            addCriterion("jz <=", value, "jz");
            return (Criteria) this;
        }

        public Criteria andJzIn(List<Double> values) {
            addCriterion("jz in", values, "jz");
            return (Criteria) this;
        }

        public Criteria andJzNotIn(List<Double> values) {
            addCriterion("jz not in", values, "jz");
            return (Criteria) this;
        }

        public Criteria andJzBetween(Double value1, Double value2) {
            addCriterion("jz between", value1, value2, "jz");
            return (Criteria) this;
        }

        public Criteria andJzNotBetween(Double value1, Double value2) {
            addCriterion("jz not between", value1, value2, "jz");
            return (Criteria) this;
        }

        public Criteria andXqIsNull() {
            addCriterion("xq is null");
            return (Criteria) this;
        }

        public Criteria andXqIsNotNull() {
            addCriterion("xq is not null");
            return (Criteria) this;
        }

        public Criteria andXqEqualTo(Double value) {
            addCriterion("xq =", value, "xq");
            return (Criteria) this;
        }

        public Criteria andXqNotEqualTo(Double value) {
            addCriterion("xq <>", value, "xq");
            return (Criteria) this;
        }

        public Criteria andXqGreaterThan(Double value) {
            addCriterion("xq >", value, "xq");
            return (Criteria) this;
        }

        public Criteria andXqGreaterThanOrEqualTo(Double value) {
            addCriterion("xq >=", value, "xq");
            return (Criteria) this;
        }

        public Criteria andXqLessThan(Double value) {
            addCriterion("xq <", value, "xq");
            return (Criteria) this;
        }

        public Criteria andXqLessThanOrEqualTo(Double value) {
            addCriterion("xq <=", value, "xq");
            return (Criteria) this;
        }

        public Criteria andXqIn(List<Double> values) {
            addCriterion("xq in", values, "xq");
            return (Criteria) this;
        }

        public Criteria andXqNotIn(List<Double> values) {
            addCriterion("xq not in", values, "xq");
            return (Criteria) this;
        }

        public Criteria andXqBetween(Double value1, Double value2) {
            addCriterion("xq between", value1, value2, "xq");
            return (Criteria) this;
        }

        public Criteria andXqNotBetween(Double value1, Double value2) {
            addCriterion("xq not between", value1, value2, "xq");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeIsNull() {
            addCriterion("payment_type is null");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeIsNotNull() {
            addCriterion("payment_type is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeEqualTo(Integer value) {
            addCriterion("payment_type =", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotEqualTo(Integer value) {
            addCriterion("payment_type <>", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeGreaterThan(Integer value) {
            addCriterion("payment_type >", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("payment_type >=", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeLessThan(Integer value) {
            addCriterion("payment_type <", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeLessThanOrEqualTo(Integer value) {
            addCriterion("payment_type <=", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeIn(List<Integer> values) {
            addCriterion("payment_type in", values, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotIn(List<Integer> values) {
            addCriterion("payment_type not in", values, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeBetween(Integer value1, Integer value2) {
            addCriterion("payment_type between", value1, value2, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("payment_type not between", value1, value2, "paymentType");
            return (Criteria) this;
        }

        public Criteria andBudgetInfoIdIsNull() {
            addCriterion("budget_info_id is null");
            return (Criteria) this;
        }

        public Criteria andBudgetInfoIdIsNotNull() {
            addCriterion("budget_info_id is not null");
            return (Criteria) this;
        }

        public Criteria andBudgetInfoIdEqualTo(String value) {
            addCriterion("budget_info_id =", value, "budgetInfoId");
            return (Criteria) this;
        }

        public Criteria andBudgetInfoIdNotEqualTo(String value) {
            addCriterion("budget_info_id <>", value, "budgetInfoId");
            return (Criteria) this;
        }

        public Criteria andBudgetInfoIdGreaterThan(String value) {
            addCriterion("budget_info_id >", value, "budgetInfoId");
            return (Criteria) this;
        }

        public Criteria andBudgetInfoIdGreaterThanOrEqualTo(String value) {
            addCriterion("budget_info_id >=", value, "budgetInfoId");
            return (Criteria) this;
        }

        public Criteria andBudgetInfoIdLessThan(String value) {
            addCriterion("budget_info_id <", value, "budgetInfoId");
            return (Criteria) this;
        }

        public Criteria andBudgetInfoIdLessThanOrEqualTo(String value) {
            addCriterion("budget_info_id <=", value, "budgetInfoId");
            return (Criteria) this;
        }

        public Criteria andBudgetInfoIdLike(String value) {
            addCriterion("budget_info_id like", value, "budgetInfoId");
            return (Criteria) this;
        }

        public Criteria andBudgetInfoIdNotLike(String value) {
            addCriterion("budget_info_id not like", value, "budgetInfoId");
            return (Criteria) this;
        }

        public Criteria andBudgetInfoIdIn(List<String> values) {
            addCriterion("budget_info_id in", values, "budgetInfoId");
            return (Criteria) this;
        }

        public Criteria andBudgetInfoIdNotIn(List<String> values) {
            addCriterion("budget_info_id not in", values, "budgetInfoId");
            return (Criteria) this;
        }

        public Criteria andBudgetInfoIdBetween(String value1, String value2) {
            addCriterion("budget_info_id between", value1, value2, "budgetInfoId");
            return (Criteria) this;
        }

        public Criteria andBudgetInfoIdNotBetween(String value1, String value2) {
            addCriterion("budget_info_id not between", value1, value2, "budgetInfoId");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNull() {
            addCriterion("del_flag is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(Integer value) {
            addCriterion("del_flag =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(Integer value) {
            addCriterion("del_flag <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(Integer value) {
            addCriterion("del_flag >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("del_flag >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(Integer value) {
            addCriterion("del_flag <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(Integer value) {
            addCriterion("del_flag <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<Integer> values) {
            addCriterion("del_flag in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<Integer> values) {
            addCriterion("del_flag not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(Integer value1, Integer value2) {
            addCriterion("del_flag between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("del_flag not between", value1, value2, "delFlag");
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