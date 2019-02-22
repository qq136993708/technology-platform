package com.pcitc.base.stp.equipment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SreProjectYearExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SreProjectYearExample() {
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

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(Integer value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(Integer value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(Integer value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(Integer value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(Integer value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<Integer> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<Integer> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(Integer value1, Integer value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(Integer value1, Integer value2) {
            addCriterion("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andCapitalMoneyIsNull() {
            addCriterion("capital_money is null");
            return (Criteria) this;
        }

        public Criteria andCapitalMoneyIsNotNull() {
            addCriterion("capital_money is not null");
            return (Criteria) this;
        }

        public Criteria andCapitalMoneyEqualTo(BigDecimal value) {
            addCriterion("capital_money =", value, "capitalMoney");
            return (Criteria) this;
        }

        public Criteria andCapitalMoneyNotEqualTo(BigDecimal value) {
            addCriterion("capital_money <>", value, "capitalMoney");
            return (Criteria) this;
        }

        public Criteria andCapitalMoneyGreaterThan(BigDecimal value) {
            addCriterion("capital_money >", value, "capitalMoney");
            return (Criteria) this;
        }

        public Criteria andCapitalMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("capital_money >=", value, "capitalMoney");
            return (Criteria) this;
        }

        public Criteria andCapitalMoneyLessThan(BigDecimal value) {
            addCriterion("capital_money <", value, "capitalMoney");
            return (Criteria) this;
        }

        public Criteria andCapitalMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("capital_money <=", value, "capitalMoney");
            return (Criteria) this;
        }

        public Criteria andCapitalMoneyIn(List<BigDecimal> values) {
            addCriterion("capital_money in", values, "capitalMoney");
            return (Criteria) this;
        }

        public Criteria andCapitalMoneyNotIn(List<BigDecimal> values) {
            addCriterion("capital_money not in", values, "capitalMoney");
            return (Criteria) this;
        }

        public Criteria andCapitalMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("capital_money between", value1, value2, "capitalMoney");
            return (Criteria) this;
        }

        public Criteria andCapitalMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("capital_money not between", value1, value2, "capitalMoney");
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

        public Criteria andProjectIdEqualTo(Long value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(Long value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(Long value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(Long value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(Long value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(Long value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<Long> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<Long> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(Long value1, Long value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(Long value1, Long value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andCostMoneyIsNull() {
            addCriterion("cost_money is null");
            return (Criteria) this;
        }

        public Criteria andCostMoneyIsNotNull() {
            addCriterion("cost_money is not null");
            return (Criteria) this;
        }

        public Criteria andCostMoneyEqualTo(BigDecimal value) {
            addCriterion("cost_money =", value, "costMoney");
            return (Criteria) this;
        }

        public Criteria andCostMoneyNotEqualTo(BigDecimal value) {
            addCriterion("cost_money <>", value, "costMoney");
            return (Criteria) this;
        }

        public Criteria andCostMoneyGreaterThan(BigDecimal value) {
            addCriterion("cost_money >", value, "costMoney");
            return (Criteria) this;
        }

        public Criteria andCostMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_money >=", value, "costMoney");
            return (Criteria) this;
        }

        public Criteria andCostMoneyLessThan(BigDecimal value) {
            addCriterion("cost_money <", value, "costMoney");
            return (Criteria) this;
        }

        public Criteria andCostMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_money <=", value, "costMoney");
            return (Criteria) this;
        }

        public Criteria andCostMoneyIn(List<BigDecimal> values) {
            addCriterion("cost_money in", values, "costMoney");
            return (Criteria) this;
        }

        public Criteria andCostMoneyNotIn(List<BigDecimal> values) {
            addCriterion("cost_money not in", values, "costMoney");
            return (Criteria) this;
        }

        public Criteria andCostMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_money between", value1, value2, "costMoney");
            return (Criteria) this;
        }

        public Criteria andCostMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_money not between", value1, value2, "costMoney");
            return (Criteria) this;
        }

        public Criteria andSubtotalMoneyIsNull() {
            addCriterion("subtotal_money is null");
            return (Criteria) this;
        }

        public Criteria andSubtotalMoneyIsNotNull() {
            addCriterion("subtotal_money is not null");
            return (Criteria) this;
        }

        public Criteria andSubtotalMoneyEqualTo(BigDecimal value) {
            addCriterion("subtotal_money =", value, "subtotalMoney");
            return (Criteria) this;
        }

        public Criteria andSubtotalMoneyNotEqualTo(BigDecimal value) {
            addCriterion("subtotal_money <>", value, "subtotalMoney");
            return (Criteria) this;
        }

        public Criteria andSubtotalMoneyGreaterThan(BigDecimal value) {
            addCriterion("subtotal_money >", value, "subtotalMoney");
            return (Criteria) this;
        }

        public Criteria andSubtotalMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("subtotal_money >=", value, "subtotalMoney");
            return (Criteria) this;
        }

        public Criteria andSubtotalMoneyLessThan(BigDecimal value) {
            addCriterion("subtotal_money <", value, "subtotalMoney");
            return (Criteria) this;
        }

        public Criteria andSubtotalMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("subtotal_money <=", value, "subtotalMoney");
            return (Criteria) this;
        }

        public Criteria andSubtotalMoneyIn(List<BigDecimal> values) {
            addCriterion("subtotal_money in", values, "subtotalMoney");
            return (Criteria) this;
        }

        public Criteria andSubtotalMoneyNotIn(List<BigDecimal> values) {
            addCriterion("subtotal_money not in", values, "subtotalMoney");
            return (Criteria) this;
        }

        public Criteria andSubtotalMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("subtotal_money between", value1, value2, "subtotalMoney");
            return (Criteria) this;
        }

        public Criteria andSubtotalMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("subtotal_money not between", value1, value2, "subtotalMoney");
            return (Criteria) this;
        }

        public Criteria andLeadUnitNameIsNull() {
            addCriterion("lead_unit_name is null");
            return (Criteria) this;
        }

        public Criteria andLeadUnitNameIsNotNull() {
            addCriterion("lead_unit_name is not null");
            return (Criteria) this;
        }

        public Criteria andLeadUnitNameEqualTo(String value) {
            addCriterion("lead_unit_name =", value, "leadUnitName");
            return (Criteria) this;
        }

        public Criteria andLeadUnitNameNotEqualTo(String value) {
            addCriterion("lead_unit_name <>", value, "leadUnitName");
            return (Criteria) this;
        }

        public Criteria andLeadUnitNameGreaterThan(String value) {
            addCriterion("lead_unit_name >", value, "leadUnitName");
            return (Criteria) this;
        }

        public Criteria andLeadUnitNameGreaterThanOrEqualTo(String value) {
            addCriterion("lead_unit_name >=", value, "leadUnitName");
            return (Criteria) this;
        }

        public Criteria andLeadUnitNameLessThan(String value) {
            addCriterion("lead_unit_name <", value, "leadUnitName");
            return (Criteria) this;
        }

        public Criteria andLeadUnitNameLessThanOrEqualTo(String value) {
            addCriterion("lead_unit_name <=", value, "leadUnitName");
            return (Criteria) this;
        }

        public Criteria andLeadUnitNameLike(String value) {
            addCriterion("lead_unit_name like", value, "leadUnitName");
            return (Criteria) this;
        }

        public Criteria andLeadUnitNameNotLike(String value) {
            addCriterion("lead_unit_name not like", value, "leadUnitName");
            return (Criteria) this;
        }

        public Criteria andLeadUnitNameIn(List<String> values) {
            addCriterion("lead_unit_name in", values, "leadUnitName");
            return (Criteria) this;
        }

        public Criteria andLeadUnitNameNotIn(List<String> values) {
            addCriterion("lead_unit_name not in", values, "leadUnitName");
            return (Criteria) this;
        }

        public Criteria andLeadUnitNameBetween(String value1, String value2) {
            addCriterion("lead_unit_name between", value1, value2, "leadUnitName");
            return (Criteria) this;
        }

        public Criteria andLeadUnitNameNotBetween(String value1, String value2) {
            addCriterion("lead_unit_name not between", value1, value2, "leadUnitName");
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