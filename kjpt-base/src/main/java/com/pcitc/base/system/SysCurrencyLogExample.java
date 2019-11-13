package com.pcitc.base.system;

import java.util.ArrayList;
import java.util.List;

public class SysCurrencyLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public SysCurrencyLogExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
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

        public Criteria andLogNameIsNull() {
            addCriterion("log_name is null");
            return (Criteria) this;
        }

        public Criteria andLogNameIsNotNull() {
            addCriterion("log_name is not null");
            return (Criteria) this;
        }

        public Criteria andLogNameEqualTo(String value) {
            addCriterion("log_name =", value, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameNotEqualTo(String value) {
            addCriterion("log_name <>", value, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameGreaterThan(String value) {
            addCriterion("log_name >", value, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameGreaterThanOrEqualTo(String value) {
            addCriterion("log_name >=", value, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameLessThan(String value) {
            addCriterion("log_name <", value, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameLessThanOrEqualTo(String value) {
            addCriterion("log_name <=", value, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameLike(String value) {
            addCriterion("log_name like", value, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameNotLike(String value) {
            addCriterion("log_name not like", value, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameIn(List<String> values) {
            addCriterion("log_name in", values, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameNotIn(List<String> values) {
            addCriterion("log_name not in", values, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameBetween(String value1, String value2) {
            addCriterion("log_name between", value1, value2, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameNotBetween(String value1, String value2) {
            addCriterion("log_name not between", value1, value2, "logName");
            return (Criteria) this;
        }

        public Criteria andLogTimeIsNull() {
            addCriterion("log_time is null");
            return (Criteria) this;
        }

        public Criteria andLogTimeIsNotNull() {
            addCriterion("log_time is not null");
            return (Criteria) this;
        }

        public Criteria andLogTimeEqualTo(String value) {
            addCriterion("log_time =", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotEqualTo(String value) {
            addCriterion("log_time <>", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeGreaterThan(String value) {
            addCriterion("log_time >", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeGreaterThanOrEqualTo(String value) {
            addCriterion("log_time >=", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeLessThan(String value) {
            addCriterion("log_time <", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeLessThanOrEqualTo(String value) {
            addCriterion("log_time <=", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeLike(String value) {
            addCriterion("log_time like", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotLike(String value) {
            addCriterion("log_time not like", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeIn(List<String> values) {
            addCriterion("log_time in", values, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotIn(List<String> values) {
            addCriterion("log_time not in", values, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeBetween(String value1, String value2) {
            addCriterion("log_time between", value1, value2, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotBetween(String value1, String value2) {
            addCriterion("log_time not between", value1, value2, "logTime");
            return (Criteria) this;
        }

        public Criteria andDescT1IsNull() {
            addCriterion("desc_t1 is null");
            return (Criteria) this;
        }

        public Criteria andDescT1IsNotNull() {
            addCriterion("desc_t1 is not null");
            return (Criteria) this;
        }

        public Criteria andDescT1EqualTo(String value) {
            addCriterion("desc_t1 =", value, "descT1");
            return (Criteria) this;
        }

        public Criteria andDescT1NotEqualTo(String value) {
            addCriterion("desc_t1 <>", value, "descT1");
            return (Criteria) this;
        }

        public Criteria andDescT1GreaterThan(String value) {
            addCriterion("desc_t1 >", value, "descT1");
            return (Criteria) this;
        }

        public Criteria andDescT1GreaterThanOrEqualTo(String value) {
            addCriterion("desc_t1 >=", value, "descT1");
            return (Criteria) this;
        }

        public Criteria andDescT1LessThan(String value) {
            addCriterion("desc_t1 <", value, "descT1");
            return (Criteria) this;
        }

        public Criteria andDescT1LessThanOrEqualTo(String value) {
            addCriterion("desc_t1 <=", value, "descT1");
            return (Criteria) this;
        }

        public Criteria andDescT1Like(String value) {
            addCriterion("desc_t1 like", value, "descT1");
            return (Criteria) this;
        }

        public Criteria andDescT1NotLike(String value) {
            addCriterion("desc_t1 not like", value, "descT1");
            return (Criteria) this;
        }

        public Criteria andDescT1In(List<String> values) {
            addCriterion("desc_t1 in", values, "descT1");
            return (Criteria) this;
        }

        public Criteria andDescT1NotIn(List<String> values) {
            addCriterion("desc_t1 not in", values, "descT1");
            return (Criteria) this;
        }

        public Criteria andDescT1Between(String value1, String value2) {
            addCriterion("desc_t1 between", value1, value2, "descT1");
            return (Criteria) this;
        }

        public Criteria andDescT1NotBetween(String value1, String value2) {
            addCriterion("desc_t1 not between", value1, value2, "descT1");
            return (Criteria) this;
        }

        public Criteria andDescT2IsNull() {
            addCriterion("desc_t2 is null");
            return (Criteria) this;
        }

        public Criteria andDescT2IsNotNull() {
            addCriterion("desc_t2 is not null");
            return (Criteria) this;
        }

        public Criteria andDescT2EqualTo(String value) {
            addCriterion("desc_t2 =", value, "descT2");
            return (Criteria) this;
        }

        public Criteria andDescT2NotEqualTo(String value) {
            addCriterion("desc_t2 <>", value, "descT2");
            return (Criteria) this;
        }

        public Criteria andDescT2GreaterThan(String value) {
            addCriterion("desc_t2 >", value, "descT2");
            return (Criteria) this;
        }

        public Criteria andDescT2GreaterThanOrEqualTo(String value) {
            addCriterion("desc_t2 >=", value, "descT2");
            return (Criteria) this;
        }

        public Criteria andDescT2LessThan(String value) {
            addCriterion("desc_t2 <", value, "descT2");
            return (Criteria) this;
        }

        public Criteria andDescT2LessThanOrEqualTo(String value) {
            addCriterion("desc_t2 <=", value, "descT2");
            return (Criteria) this;
        }

        public Criteria andDescT2Like(String value) {
            addCriterion("desc_t2 like", value, "descT2");
            return (Criteria) this;
        }

        public Criteria andDescT2NotLike(String value) {
            addCriterion("desc_t2 not like", value, "descT2");
            return (Criteria) this;
        }

        public Criteria andDescT2In(List<String> values) {
            addCriterion("desc_t2 in", values, "descT2");
            return (Criteria) this;
        }

        public Criteria andDescT2NotIn(List<String> values) {
            addCriterion("desc_t2 not in", values, "descT2");
            return (Criteria) this;
        }

        public Criteria andDescT2Between(String value1, String value2) {
            addCriterion("desc_t2 between", value1, value2, "descT2");
            return (Criteria) this;
        }

        public Criteria andDescT2NotBetween(String value1, String value2) {
            addCriterion("desc_t2 not between", value1, value2, "descT2");
            return (Criteria) this;
        }

        public Criteria andDescT3IsNull() {
            addCriterion("desc_t3 is null");
            return (Criteria) this;
        }

        public Criteria andDescT3IsNotNull() {
            addCriterion("desc_t3 is not null");
            return (Criteria) this;
        }

        public Criteria andDescT3EqualTo(String value) {
            addCriterion("desc_t3 =", value, "descT3");
            return (Criteria) this;
        }

        public Criteria andDescT3NotEqualTo(String value) {
            addCriterion("desc_t3 <>", value, "descT3");
            return (Criteria) this;
        }

        public Criteria andDescT3GreaterThan(String value) {
            addCriterion("desc_t3 >", value, "descT3");
            return (Criteria) this;
        }

        public Criteria andDescT3GreaterThanOrEqualTo(String value) {
            addCriterion("desc_t3 >=", value, "descT3");
            return (Criteria) this;
        }

        public Criteria andDescT3LessThan(String value) {
            addCriterion("desc_t3 <", value, "descT3");
            return (Criteria) this;
        }

        public Criteria andDescT3LessThanOrEqualTo(String value) {
            addCriterion("desc_t3 <=", value, "descT3");
            return (Criteria) this;
        }

        public Criteria andDescT3Like(String value) {
            addCriterion("desc_t3 like", value, "descT3");
            return (Criteria) this;
        }

        public Criteria andDescT3NotLike(String value) {
            addCriterion("desc_t3 not like", value, "descT3");
            return (Criteria) this;
        }

        public Criteria andDescT3In(List<String> values) {
            addCriterion("desc_t3 in", values, "descT3");
            return (Criteria) this;
        }

        public Criteria andDescT3NotIn(List<String> values) {
            addCriterion("desc_t3 not in", values, "descT3");
            return (Criteria) this;
        }

        public Criteria andDescT3Between(String value1, String value2) {
            addCriterion("desc_t3 between", value1, value2, "descT3");
            return (Criteria) this;
        }

        public Criteria andDescT3NotBetween(String value1, String value2) {
            addCriterion("desc_t3 not between", value1, value2, "descT3");
            return (Criteria) this;
        }

        public Criteria andDescT4IsNull() {
            addCriterion("desc_t4 is null");
            return (Criteria) this;
        }

        public Criteria andDescT4IsNotNull() {
            addCriterion("desc_t4 is not null");
            return (Criteria) this;
        }

        public Criteria andDescT4EqualTo(String value) {
            addCriterion("desc_t4 =", value, "descT4");
            return (Criteria) this;
        }

        public Criteria andDescT4NotEqualTo(String value) {
            addCriterion("desc_t4 <>", value, "descT4");
            return (Criteria) this;
        }

        public Criteria andDescT4GreaterThan(String value) {
            addCriterion("desc_t4 >", value, "descT4");
            return (Criteria) this;
        }

        public Criteria andDescT4GreaterThanOrEqualTo(String value) {
            addCriterion("desc_t4 >=", value, "descT4");
            return (Criteria) this;
        }

        public Criteria andDescT4LessThan(String value) {
            addCriterion("desc_t4 <", value, "descT4");
            return (Criteria) this;
        }

        public Criteria andDescT4LessThanOrEqualTo(String value) {
            addCriterion("desc_t4 <=", value, "descT4");
            return (Criteria) this;
        }

        public Criteria andDescT4Like(String value) {
            addCriterion("desc_t4 like", value, "descT4");
            return (Criteria) this;
        }

        public Criteria andDescT4NotLike(String value) {
            addCriterion("desc_t4 not like", value, "descT4");
            return (Criteria) this;
        }

        public Criteria andDescT4In(List<String> values) {
            addCriterion("desc_t4 in", values, "descT4");
            return (Criteria) this;
        }

        public Criteria andDescT4NotIn(List<String> values) {
            addCriterion("desc_t4 not in", values, "descT4");
            return (Criteria) this;
        }

        public Criteria andDescT4Between(String value1, String value2) {
            addCriterion("desc_t4 between", value1, value2, "descT4");
            return (Criteria) this;
        }

        public Criteria andDescT4NotBetween(String value1, String value2) {
            addCriterion("desc_t4 not between", value1, value2, "descT4");
            return (Criteria) this;
        }

        public Criteria andDescT5IsNull() {
            addCriterion("desc_t5 is null");
            return (Criteria) this;
        }

        public Criteria andDescT5IsNotNull() {
            addCriterion("desc_t5 is not null");
            return (Criteria) this;
        }

        public Criteria andDescT5EqualTo(String value) {
            addCriterion("desc_t5 =", value, "descT5");
            return (Criteria) this;
        }

        public Criteria andDescT5NotEqualTo(String value) {
            addCriterion("desc_t5 <>", value, "descT5");
            return (Criteria) this;
        }

        public Criteria andDescT5GreaterThan(String value) {
            addCriterion("desc_t5 >", value, "descT5");
            return (Criteria) this;
        }

        public Criteria andDescT5GreaterThanOrEqualTo(String value) {
            addCriterion("desc_t5 >=", value, "descT5");
            return (Criteria) this;
        }

        public Criteria andDescT5LessThan(String value) {
            addCriterion("desc_t5 <", value, "descT5");
            return (Criteria) this;
        }

        public Criteria andDescT5LessThanOrEqualTo(String value) {
            addCriterion("desc_t5 <=", value, "descT5");
            return (Criteria) this;
        }

        public Criteria andDescT5Like(String value) {
            addCriterion("desc_t5 like", value, "descT5");
            return (Criteria) this;
        }

        public Criteria andDescT5NotLike(String value) {
            addCriterion("desc_t5 not like", value, "descT5");
            return (Criteria) this;
        }

        public Criteria andDescT5In(List<String> values) {
            addCriterion("desc_t5 in", values, "descT5");
            return (Criteria) this;
        }

        public Criteria andDescT5NotIn(List<String> values) {
            addCriterion("desc_t5 not in", values, "descT5");
            return (Criteria) this;
        }

        public Criteria andDescT5Between(String value1, String value2) {
            addCriterion("desc_t5 between", value1, value2, "descT5");
            return (Criteria) this;
        }

        public Criteria andDescT5NotBetween(String value1, String value2) {
            addCriterion("desc_t5 not between", value1, value2, "descT5");
            return (Criteria) this;
        }

        public Criteria andDataT1IsNull() {
            addCriterion("data_t1 is null");
            return (Criteria) this;
        }

        public Criteria andDataT1IsNotNull() {
            addCriterion("data_t1 is not null");
            return (Criteria) this;
        }

        public Criteria andDataT1EqualTo(String value) {
            addCriterion("data_t1 =", value, "dataT1");
            return (Criteria) this;
        }

        public Criteria andDataT1NotEqualTo(String value) {
            addCriterion("data_t1 <>", value, "dataT1");
            return (Criteria) this;
        }

        public Criteria andDataT1GreaterThan(String value) {
            addCriterion("data_t1 >", value, "dataT1");
            return (Criteria) this;
        }

        public Criteria andDataT1GreaterThanOrEqualTo(String value) {
            addCriterion("data_t1 >=", value, "dataT1");
            return (Criteria) this;
        }

        public Criteria andDataT1LessThan(String value) {
            addCriterion("data_t1 <", value, "dataT1");
            return (Criteria) this;
        }

        public Criteria andDataT1LessThanOrEqualTo(String value) {
            addCriterion("data_t1 <=", value, "dataT1");
            return (Criteria) this;
        }

        public Criteria andDataT1Like(String value) {
            addCriterion("data_t1 like", value, "dataT1");
            return (Criteria) this;
        }

        public Criteria andDataT1NotLike(String value) {
            addCriterion("data_t1 not like", value, "dataT1");
            return (Criteria) this;
        }

        public Criteria andDataT1In(List<String> values) {
            addCriterion("data_t1 in", values, "dataT1");
            return (Criteria) this;
        }

        public Criteria andDataT1NotIn(List<String> values) {
            addCriterion("data_t1 not in", values, "dataT1");
            return (Criteria) this;
        }

        public Criteria andDataT1Between(String value1, String value2) {
            addCriterion("data_t1 between", value1, value2, "dataT1");
            return (Criteria) this;
        }

        public Criteria andDataT1NotBetween(String value1, String value2) {
            addCriterion("data_t1 not between", value1, value2, "dataT1");
            return (Criteria) this;
        }

        public Criteria andDataT2IsNull() {
            addCriterion("data_t2 is null");
            return (Criteria) this;
        }

        public Criteria andDataT2IsNotNull() {
            addCriterion("data_t2 is not null");
            return (Criteria) this;
        }

        public Criteria andDataT2EqualTo(String value) {
            addCriterion("data_t2 =", value, "dataT2");
            return (Criteria) this;
        }

        public Criteria andDataT2NotEqualTo(String value) {
            addCriterion("data_t2 <>", value, "dataT2");
            return (Criteria) this;
        }

        public Criteria andDataT2GreaterThan(String value) {
            addCriterion("data_t2 >", value, "dataT2");
            return (Criteria) this;
        }

        public Criteria andDataT2GreaterThanOrEqualTo(String value) {
            addCriterion("data_t2 >=", value, "dataT2");
            return (Criteria) this;
        }

        public Criteria andDataT2LessThan(String value) {
            addCriterion("data_t2 <", value, "dataT2");
            return (Criteria) this;
        }

        public Criteria andDataT2LessThanOrEqualTo(String value) {
            addCriterion("data_t2 <=", value, "dataT2");
            return (Criteria) this;
        }

        public Criteria andDataT2Like(String value) {
            addCriterion("data_t2 like", value, "dataT2");
            return (Criteria) this;
        }

        public Criteria andDataT2NotLike(String value) {
            addCriterion("data_t2 not like", value, "dataT2");
            return (Criteria) this;
        }

        public Criteria andDataT2In(List<String> values) {
            addCriterion("data_t2 in", values, "dataT2");
            return (Criteria) this;
        }

        public Criteria andDataT2NotIn(List<String> values) {
            addCriterion("data_t2 not in", values, "dataT2");
            return (Criteria) this;
        }

        public Criteria andDataT2Between(String value1, String value2) {
            addCriterion("data_t2 between", value1, value2, "dataT2");
            return (Criteria) this;
        }

        public Criteria andDataT2NotBetween(String value1, String value2) {
            addCriterion("data_t2 not between", value1, value2, "dataT2");
            return (Criteria) this;
        }

        public Criteria andDataT3IsNull() {
            addCriterion("data_t3 is null");
            return (Criteria) this;
        }

        public Criteria andDataT3IsNotNull() {
            addCriterion("data_t3 is not null");
            return (Criteria) this;
        }

        public Criteria andDataT3EqualTo(String value) {
            addCriterion("data_t3 =", value, "dataT3");
            return (Criteria) this;
        }

        public Criteria andDataT3NotEqualTo(String value) {
            addCriterion("data_t3 <>", value, "dataT3");
            return (Criteria) this;
        }

        public Criteria andDataT3GreaterThan(String value) {
            addCriterion("data_t3 >", value, "dataT3");
            return (Criteria) this;
        }

        public Criteria andDataT3GreaterThanOrEqualTo(String value) {
            addCriterion("data_t3 >=", value, "dataT3");
            return (Criteria) this;
        }

        public Criteria andDataT3LessThan(String value) {
            addCriterion("data_t3 <", value, "dataT3");
            return (Criteria) this;
        }

        public Criteria andDataT3LessThanOrEqualTo(String value) {
            addCriterion("data_t3 <=", value, "dataT3");
            return (Criteria) this;
        }

        public Criteria andDataT3Like(String value) {
            addCriterion("data_t3 like", value, "dataT3");
            return (Criteria) this;
        }

        public Criteria andDataT3NotLike(String value) {
            addCriterion("data_t3 not like", value, "dataT3");
            return (Criteria) this;
        }

        public Criteria andDataT3In(List<String> values) {
            addCriterion("data_t3 in", values, "dataT3");
            return (Criteria) this;
        }

        public Criteria andDataT3NotIn(List<String> values) {
            addCriterion("data_t3 not in", values, "dataT3");
            return (Criteria) this;
        }

        public Criteria andDataT3Between(String value1, String value2) {
            addCriterion("data_t3 between", value1, value2, "dataT3");
            return (Criteria) this;
        }

        public Criteria andDataT3NotBetween(String value1, String value2) {
            addCriterion("data_t3 not between", value1, value2, "dataT3");
            return (Criteria) this;
        }

        public Criteria andDataT4IsNull() {
            addCriterion("data_t4 is null");
            return (Criteria) this;
        }

        public Criteria andDataT4IsNotNull() {
            addCriterion("data_t4 is not null");
            return (Criteria) this;
        }

        public Criteria andDataT4EqualTo(String value) {
            addCriterion("data_t4 =", value, "dataT4");
            return (Criteria) this;
        }

        public Criteria andDataT4NotEqualTo(String value) {
            addCriterion("data_t4 <>", value, "dataT4");
            return (Criteria) this;
        }

        public Criteria andDataT4GreaterThan(String value) {
            addCriterion("data_t4 >", value, "dataT4");
            return (Criteria) this;
        }

        public Criteria andDataT4GreaterThanOrEqualTo(String value) {
            addCriterion("data_t4 >=", value, "dataT4");
            return (Criteria) this;
        }

        public Criteria andDataT4LessThan(String value) {
            addCriterion("data_t4 <", value, "dataT4");
            return (Criteria) this;
        }

        public Criteria andDataT4LessThanOrEqualTo(String value) {
            addCriterion("data_t4 <=", value, "dataT4");
            return (Criteria) this;
        }

        public Criteria andDataT4Like(String value) {
            addCriterion("data_t4 like", value, "dataT4");
            return (Criteria) this;
        }

        public Criteria andDataT4NotLike(String value) {
            addCriterion("data_t4 not like", value, "dataT4");
            return (Criteria) this;
        }

        public Criteria andDataT4In(List<String> values) {
            addCriterion("data_t4 in", values, "dataT4");
            return (Criteria) this;
        }

        public Criteria andDataT4NotIn(List<String> values) {
            addCriterion("data_t4 not in", values, "dataT4");
            return (Criteria) this;
        }

        public Criteria andDataT4Between(String value1, String value2) {
            addCriterion("data_t4 between", value1, value2, "dataT4");
            return (Criteria) this;
        }

        public Criteria andDataT4NotBetween(String value1, String value2) {
            addCriterion("data_t4 not between", value1, value2, "dataT4");
            return (Criteria) this;
        }

        public Criteria andDataT5IsNull() {
            addCriterion("data_t5 is null");
            return (Criteria) this;
        }

        public Criteria andDataT5IsNotNull() {
            addCriterion("data_t5 is not null");
            return (Criteria) this;
        }

        public Criteria andDataT5EqualTo(String value) {
            addCriterion("data_t5 =", value, "dataT5");
            return (Criteria) this;
        }

        public Criteria andDataT5NotEqualTo(String value) {
            addCriterion("data_t5 <>", value, "dataT5");
            return (Criteria) this;
        }

        public Criteria andDataT5GreaterThan(String value) {
            addCriterion("data_t5 >", value, "dataT5");
            return (Criteria) this;
        }

        public Criteria andDataT5GreaterThanOrEqualTo(String value) {
            addCriterion("data_t5 >=", value, "dataT5");
            return (Criteria) this;
        }

        public Criteria andDataT5LessThan(String value) {
            addCriterion("data_t5 <", value, "dataT5");
            return (Criteria) this;
        }

        public Criteria andDataT5LessThanOrEqualTo(String value) {
            addCriterion("data_t5 <=", value, "dataT5");
            return (Criteria) this;
        }

        public Criteria andDataT5Like(String value) {
            addCriterion("data_t5 like", value, "dataT5");
            return (Criteria) this;
        }

        public Criteria andDataT5NotLike(String value) {
            addCriterion("data_t5 not like", value, "dataT5");
            return (Criteria) this;
        }

        public Criteria andDataT5In(List<String> values) {
            addCriterion("data_t5 in", values, "dataT5");
            return (Criteria) this;
        }

        public Criteria andDataT5NotIn(List<String> values) {
            addCriterion("data_t5 not in", values, "dataT5");
            return (Criteria) this;
        }

        public Criteria andDataT5Between(String value1, String value2) {
            addCriterion("data_t5 between", value1, value2, "dataT5");
            return (Criteria) this;
        }

        public Criteria andDataT5NotBetween(String value1, String value2) {
            addCriterion("data_t5 not between", value1, value2, "dataT5");
            return (Criteria) this;
        }

        public Criteria andDataT6IsNull() {
            addCriterion("data_t6 is null");
            return (Criteria) this;
        }

        public Criteria andDataT6IsNotNull() {
            addCriterion("data_t6 is not null");
            return (Criteria) this;
        }

        public Criteria andDataT6EqualTo(String value) {
            addCriterion("data_t6 =", value, "dataT6");
            return (Criteria) this;
        }

        public Criteria andDataT6NotEqualTo(String value) {
            addCriterion("data_t6 <>", value, "dataT6");
            return (Criteria) this;
        }

        public Criteria andDataT6GreaterThan(String value) {
            addCriterion("data_t6 >", value, "dataT6");
            return (Criteria) this;
        }

        public Criteria andDataT6GreaterThanOrEqualTo(String value) {
            addCriterion("data_t6 >=", value, "dataT6");
            return (Criteria) this;
        }

        public Criteria andDataT6LessThan(String value) {
            addCriterion("data_t6 <", value, "dataT6");
            return (Criteria) this;
        }

        public Criteria andDataT6LessThanOrEqualTo(String value) {
            addCriterion("data_t6 <=", value, "dataT6");
            return (Criteria) this;
        }

        public Criteria andDataT6Like(String value) {
            addCriterion("data_t6 like", value, "dataT6");
            return (Criteria) this;
        }

        public Criteria andDataT6NotLike(String value) {
            addCriterion("data_t6 not like", value, "dataT6");
            return (Criteria) this;
        }

        public Criteria andDataT6In(List<String> values) {
            addCriterion("data_t6 in", values, "dataT6");
            return (Criteria) this;
        }

        public Criteria andDataT6NotIn(List<String> values) {
            addCriterion("data_t6 not in", values, "dataT6");
            return (Criteria) this;
        }

        public Criteria andDataT6Between(String value1, String value2) {
            addCriterion("data_t6 between", value1, value2, "dataT6");
            return (Criteria) this;
        }

        public Criteria andDataT6NotBetween(String value1, String value2) {
            addCriterion("data_t6 not between", value1, value2, "dataT6");
            return (Criteria) this;
        }

        public Criteria andDataT7IsNull() {
            addCriterion("data_t7 is null");
            return (Criteria) this;
        }

        public Criteria andDataT7IsNotNull() {
            addCriterion("data_t7 is not null");
            return (Criteria) this;
        }

        public Criteria andDataT7EqualTo(String value) {
            addCriterion("data_t7 =", value, "dataT7");
            return (Criteria) this;
        }

        public Criteria andDataT7NotEqualTo(String value) {
            addCriterion("data_t7 <>", value, "dataT7");
            return (Criteria) this;
        }

        public Criteria andDataT7GreaterThan(String value) {
            addCriterion("data_t7 >", value, "dataT7");
            return (Criteria) this;
        }

        public Criteria andDataT7GreaterThanOrEqualTo(String value) {
            addCriterion("data_t7 >=", value, "dataT7");
            return (Criteria) this;
        }

        public Criteria andDataT7LessThan(String value) {
            addCriterion("data_t7 <", value, "dataT7");
            return (Criteria) this;
        }

        public Criteria andDataT7LessThanOrEqualTo(String value) {
            addCriterion("data_t7 <=", value, "dataT7");
            return (Criteria) this;
        }

        public Criteria andDataT7Like(String value) {
            addCriterion("data_t7 like", value, "dataT7");
            return (Criteria) this;
        }

        public Criteria andDataT7NotLike(String value) {
            addCriterion("data_t7 not like", value, "dataT7");
            return (Criteria) this;
        }

        public Criteria andDataT7In(List<String> values) {
            addCriterion("data_t7 in", values, "dataT7");
            return (Criteria) this;
        }

        public Criteria andDataT7NotIn(List<String> values) {
            addCriterion("data_t7 not in", values, "dataT7");
            return (Criteria) this;
        }

        public Criteria andDataT7Between(String value1, String value2) {
            addCriterion("data_t7 between", value1, value2, "dataT7");
            return (Criteria) this;
        }

        public Criteria andDataT7NotBetween(String value1, String value2) {
            addCriterion("data_t7 not between", value1, value2, "dataT7");
            return (Criteria) this;
        }

        public Criteria andDataT8IsNull() {
            addCriterion("data_t8 is null");
            return (Criteria) this;
        }

        public Criteria andDataT8IsNotNull() {
            addCriterion("data_t8 is not null");
            return (Criteria) this;
        }

        public Criteria andDataT8EqualTo(String value) {
            addCriterion("data_t8 =", value, "dataT8");
            return (Criteria) this;
        }

        public Criteria andDataT8NotEqualTo(String value) {
            addCriterion("data_t8 <>", value, "dataT8");
            return (Criteria) this;
        }

        public Criteria andDataT8GreaterThan(String value) {
            addCriterion("data_t8 >", value, "dataT8");
            return (Criteria) this;
        }

        public Criteria andDataT8GreaterThanOrEqualTo(String value) {
            addCriterion("data_t8 >=", value, "dataT8");
            return (Criteria) this;
        }

        public Criteria andDataT8LessThan(String value) {
            addCriterion("data_t8 <", value, "dataT8");
            return (Criteria) this;
        }

        public Criteria andDataT8LessThanOrEqualTo(String value) {
            addCriterion("data_t8 <=", value, "dataT8");
            return (Criteria) this;
        }

        public Criteria andDataT8Like(String value) {
            addCriterion("data_t8 like", value, "dataT8");
            return (Criteria) this;
        }

        public Criteria andDataT8NotLike(String value) {
            addCriterion("data_t8 not like", value, "dataT8");
            return (Criteria) this;
        }

        public Criteria andDataT8In(List<String> values) {
            addCriterion("data_t8 in", values, "dataT8");
            return (Criteria) this;
        }

        public Criteria andDataT8NotIn(List<String> values) {
            addCriterion("data_t8 not in", values, "dataT8");
            return (Criteria) this;
        }

        public Criteria andDataT8Between(String value1, String value2) {
            addCriterion("data_t8 between", value1, value2, "dataT8");
            return (Criteria) this;
        }

        public Criteria andDataT8NotBetween(String value1, String value2) {
            addCriterion("data_t8 not between", value1, value2, "dataT8");
            return (Criteria) this;
        }

        public Criteria andDataT9IsNull() {
            addCriterion("data_t9 is null");
            return (Criteria) this;
        }

        public Criteria andDataT9IsNotNull() {
            addCriterion("data_t9 is not null");
            return (Criteria) this;
        }

        public Criteria andDataT9EqualTo(String value) {
            addCriterion("data_t9 =", value, "dataT9");
            return (Criteria) this;
        }

        public Criteria andDataT9NotEqualTo(String value) {
            addCriterion("data_t9 <>", value, "dataT9");
            return (Criteria) this;
        }

        public Criteria andDataT9GreaterThan(String value) {
            addCriterion("data_t9 >", value, "dataT9");
            return (Criteria) this;
        }

        public Criteria andDataT9GreaterThanOrEqualTo(String value) {
            addCriterion("data_t9 >=", value, "dataT9");
            return (Criteria) this;
        }

        public Criteria andDataT9LessThan(String value) {
            addCriterion("data_t9 <", value, "dataT9");
            return (Criteria) this;
        }

        public Criteria andDataT9LessThanOrEqualTo(String value) {
            addCriterion("data_t9 <=", value, "dataT9");
            return (Criteria) this;
        }

        public Criteria andDataT9Like(String value) {
            addCriterion("data_t9 like", value, "dataT9");
            return (Criteria) this;
        }

        public Criteria andDataT9NotLike(String value) {
            addCriterion("data_t9 not like", value, "dataT9");
            return (Criteria) this;
        }

        public Criteria andDataT9In(List<String> values) {
            addCriterion("data_t9 in", values, "dataT9");
            return (Criteria) this;
        }

        public Criteria andDataT9NotIn(List<String> values) {
            addCriterion("data_t9 not in", values, "dataT9");
            return (Criteria) this;
        }

        public Criteria andDataT9Between(String value1, String value2) {
            addCriterion("data_t9 between", value1, value2, "dataT9");
            return (Criteria) this;
        }

        public Criteria andDataT9NotBetween(String value1, String value2) {
            addCriterion("data_t9 not between", value1, value2, "dataT9");
            return (Criteria) this;
        }
    }

    /**
     */
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