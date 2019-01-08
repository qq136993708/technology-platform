package com.pcitc.base.stp.out;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OutAppraisalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OutAppraisalExample() {
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

        public Criteria andOrColumn(String value,String[] columns,String opt){
            String sql = "";
            int l = columns.length;
            for (int i = 0; i < l; i++) {
                if(i==0){
                    sql = sql + columns[i]+" "+opt+" '%"+value+"%'";
                }else {
                    sql = sql + " or "+columns[i]+" "+opt+" '%"+value+"%'";
                }
            }
            addCriterion("("+sql+")");
            return (Criteria) this;
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

        public Criteria andCgidIsNull() {
            addCriterion("cgid is null");
            return (Criteria) this;
        }

        public Criteria andCgidIsNotNull() {
            addCriterion("cgid is not null");
            return (Criteria) this;
        }

        public Criteria andCgidEqualTo(String value) {
            addCriterion("cgid =", value, "cgid");
            return (Criteria) this;
        }

        public Criteria andCgidNotEqualTo(String value) {
            addCriterion("cgid <>", value, "cgid");
            return (Criteria) this;
        }

        public Criteria andCgidGreaterThan(String value) {
            addCriterion("cgid >", value, "cgid");
            return (Criteria) this;
        }

        public Criteria andCgidGreaterThanOrEqualTo(String value) {
            addCriterion("cgid >=", value, "cgid");
            return (Criteria) this;
        }

        public Criteria andCgidLessThan(String value) {
            addCriterion("cgid <", value, "cgid");
            return (Criteria) this;
        }

        public Criteria andCgidLessThanOrEqualTo(String value) {
            addCriterion("cgid <=", value, "cgid");
            return (Criteria) this;
        }

        public Criteria andCgidLike(String value) {
            addCriterion("cgid like", value, "cgid");
            return (Criteria) this;
        }

        public Criteria andCgidNotLike(String value) {
            addCriterion("cgid not like", value, "cgid");
            return (Criteria) this;
        }

        public Criteria andCgidIn(List<String> values) {
            addCriterion("cgid in", values, "cgid");
            return (Criteria) this;
        }

        public Criteria andCgidNotIn(List<String> values) {
            addCriterion("cgid not in", values, "cgid");
            return (Criteria) this;
        }

        public Criteria andCgidBetween(String value1, String value2) {
            addCriterion("cgid between", value1, value2, "cgid");
            return (Criteria) this;
        }

        public Criteria andCgidNotBetween(String value1, String value2) {
            addCriterion("cgid not between", value1, value2, "cgid");
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

        public Criteria andCgmcIsNull() {
            addCriterion("cgmc is null");
            return (Criteria) this;
        }

        public Criteria andCgmcIsNotNull() {
            addCriterion("cgmc is not null");
            return (Criteria) this;
        }

        public Criteria andCgmcEqualTo(String value) {
            addCriterion("cgmc =", value, "cgmc");
            return (Criteria) this;
        }

        public Criteria andCgmcNotEqualTo(String value) {
            addCriterion("cgmc <>", value, "cgmc");
            return (Criteria) this;
        }

        public Criteria andCgmcGreaterThan(String value) {
            addCriterion("cgmc >", value, "cgmc");
            return (Criteria) this;
        }

        public Criteria andCgmcGreaterThanOrEqualTo(String value) {
            addCriterion("cgmc >=", value, "cgmc");
            return (Criteria) this;
        }

        public Criteria andCgmcLessThan(String value) {
            addCriterion("cgmc <", value, "cgmc");
            return (Criteria) this;
        }

        public Criteria andCgmcLessThanOrEqualTo(String value) {
            addCriterion("cgmc <=", value, "cgmc");
            return (Criteria) this;
        }

        public Criteria andCgmcLike(String value) {
            addCriterion("cgmc like", value, "cgmc");
            return (Criteria) this;
        }

        public Criteria andCgmcNotLike(String value) {
            addCriterion("cgmc not like", value, "cgmc");
            return (Criteria) this;
        }

        public Criteria andCgmcIn(List<String> values) {
            addCriterion("cgmc in", values, "cgmc");
            return (Criteria) this;
        }

        public Criteria andCgmcNotIn(List<String> values) {
            addCriterion("cgmc not in", values, "cgmc");
            return (Criteria) this;
        }

        public Criteria andCgmcBetween(String value1, String value2) {
            addCriterion("cgmc between", value1, value2, "cgmc");
            return (Criteria) this;
        }

        public Criteria andCgmcNotBetween(String value1, String value2) {
            addCriterion("cgmc not between", value1, value2, "cgmc");
            return (Criteria) this;
        }

        public Criteria andSqjddwIsNull() {
            addCriterion("sqjddw is null");
            return (Criteria) this;
        }

        public Criteria andSqjddwIsNotNull() {
            addCriterion("sqjddw is not null");
            return (Criteria) this;
        }

        public Criteria andSqjddwEqualTo(String value) {
            addCriterion("sqjddw =", value, "sqjddw");
            return (Criteria) this;
        }

        public Criteria andSqjddwNotEqualTo(String value) {
            addCriterion("sqjddw <>", value, "sqjddw");
            return (Criteria) this;
        }

        public Criteria andSqjddwGreaterThan(String value) {
            addCriterion("sqjddw >", value, "sqjddw");
            return (Criteria) this;
        }

        public Criteria andSqjddwGreaterThanOrEqualTo(String value) {
            addCriterion("sqjddw >=", value, "sqjddw");
            return (Criteria) this;
        }

        public Criteria andSqjddwLessThan(String value) {
            addCriterion("sqjddw <", value, "sqjddw");
            return (Criteria) this;
        }

        public Criteria andSqjddwLessThanOrEqualTo(String value) {
            addCriterion("sqjddw <=", value, "sqjddw");
            return (Criteria) this;
        }

        public Criteria andSqjddwLike(String value) {
            addCriterion("sqjddw like", value, "sqjddw");
            return (Criteria) this;
        }

        public Criteria andSqjddwNotLike(String value) {
            addCriterion("sqjddw not like", value, "sqjddw");
            return (Criteria) this;
        }

        public Criteria andSqjddwIn(List<String> values) {
            addCriterion("sqjddw in", values, "sqjddw");
            return (Criteria) this;
        }

        public Criteria andSqjddwNotIn(List<String> values) {
            addCriterion("sqjddw not in", values, "sqjddw");
            return (Criteria) this;
        }

        public Criteria andSqjddwBetween(String value1, String value2) {
            addCriterion("sqjddw between", value1, value2, "sqjddw");
            return (Criteria) this;
        }

        public Criteria andSqjddwNotBetween(String value1, String value2) {
            addCriterion("sqjddw not between", value1, value2, "sqjddw");
            return (Criteria) this;
        }

        public Criteria andSqdjhIsNull() {
            addCriterion("sqdjh is null");
            return (Criteria) this;
        }

        public Criteria andSqdjhIsNotNull() {
            addCriterion("sqdjh is not null");
            return (Criteria) this;
        }

        public Criteria andSqdjhEqualTo(String value) {
            addCriterion("sqdjh =", value, "sqdjh");
            return (Criteria) this;
        }

        public Criteria andSqdjhNotEqualTo(String value) {
            addCriterion("sqdjh <>", value, "sqdjh");
            return (Criteria) this;
        }

        public Criteria andSqdjhGreaterThan(String value) {
            addCriterion("sqdjh >", value, "sqdjh");
            return (Criteria) this;
        }

        public Criteria andSqdjhGreaterThanOrEqualTo(String value) {
            addCriterion("sqdjh >=", value, "sqdjh");
            return (Criteria) this;
        }

        public Criteria andSqdjhLessThan(String value) {
            addCriterion("sqdjh <", value, "sqdjh");
            return (Criteria) this;
        }

        public Criteria andSqdjhLessThanOrEqualTo(String value) {
            addCriterion("sqdjh <=", value, "sqdjh");
            return (Criteria) this;
        }

        public Criteria andSqdjhLike(String value) {
            addCriterion("sqdjh like", value, "sqdjh");
            return (Criteria) this;
        }

        public Criteria andSqdjhNotLike(String value) {
            addCriterion("sqdjh not like", value, "sqdjh");
            return (Criteria) this;
        }

        public Criteria andSqdjhIn(List<String> values) {
            addCriterion("sqdjh in", values, "sqdjh");
            return (Criteria) this;
        }

        public Criteria andSqdjhNotIn(List<String> values) {
            addCriterion("sqdjh not in", values, "sqdjh");
            return (Criteria) this;
        }

        public Criteria andSqdjhBetween(String value1, String value2) {
            addCriterion("sqdjh between", value1, value2, "sqdjh");
            return (Criteria) this;
        }

        public Criteria andSqdjhNotBetween(String value1, String value2) {
            addCriterion("sqdjh not between", value1, value2, "sqdjh");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("startTime is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("startTime is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(String value) {
            addCriterion("startTime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(String value) {
            addCriterion("startTime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(String value) {
            addCriterion("startTime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(String value) {
            addCriterion("startTime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(String value) {
            addCriterion("startTime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(String value) {
            addCriterion("startTime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLike(String value) {
            addCriterion("startTime like", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotLike(String value) {
            addCriterion("startTime not like", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<String> values) {
            addCriterion("startTime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<String> values) {
            addCriterion("startTime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(String value1, String value2) {
            addCriterion("startTime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(String value1, String value2) {
            addCriterion("startTime not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("endTime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("endTime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(String value) {
            addCriterion("endTime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(String value) {
            addCriterion("endTime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(String value) {
            addCriterion("endTime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(String value) {
            addCriterion("endTime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(String value) {
            addCriterion("endTime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(String value) {
            addCriterion("endTime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLike(String value) {
            addCriterion("endTime like", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotLike(String value) {
            addCriterion("endTime not like", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<String> values) {
            addCriterion("endTime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<String> values) {
            addCriterion("endTime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(String value1, String value2) {
            addCriterion("endTime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(String value1, String value2) {
            addCriterion("endTime not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andCglxIsNull() {
            addCriterion("cglx is null");
            return (Criteria) this;
        }

        public Criteria andCglxIsNotNull() {
            addCriterion("cglx is not null");
            return (Criteria) this;
        }

        public Criteria andCglxEqualTo(String value) {
            addCriterion("cglx =", value, "cglx");
            return (Criteria) this;
        }

        public Criteria andCglxNotEqualTo(String value) {
            addCriterion("cglx <>", value, "cglx");
            return (Criteria) this;
        }

        public Criteria andCglxGreaterThan(String value) {
            addCriterion("cglx >", value, "cglx");
            return (Criteria) this;
        }

        public Criteria andCglxGreaterThanOrEqualTo(String value) {
            addCriterion("cglx >=", value, "cglx");
            return (Criteria) this;
        }

        public Criteria andCglxLessThan(String value) {
            addCriterion("cglx <", value, "cglx");
            return (Criteria) this;
        }

        public Criteria andCglxLessThanOrEqualTo(String value) {
            addCriterion("cglx <=", value, "cglx");
            return (Criteria) this;
        }

        public Criteria andCglxLike(String value) {
            addCriterion("cglx like", value, "cglx");
            return (Criteria) this;
        }

        public Criteria andCglxNotLike(String value) {
            addCriterion("cglx not like", value, "cglx");
            return (Criteria) this;
        }

        public Criteria andCglxIn(List<String> values) {
            addCriterion("cglx in", values, "cglx");
            return (Criteria) this;
        }

        public Criteria andCglxNotIn(List<String> values) {
            addCriterion("cglx not in", values, "cglx");
            return (Criteria) this;
        }

        public Criteria andCglxBetween(String value1, String value2) {
            addCriterion("cglx between", value1, value2, "cglx");
            return (Criteria) this;
        }

        public Criteria andCglxNotBetween(String value1, String value2) {
            addCriterion("cglx not between", value1, value2, "cglx");
            return (Criteria) this;
        }

        public Criteria andZyIsNull() {
            addCriterion("zy is null");
            return (Criteria) this;
        }

        public Criteria andZyIsNotNull() {
            addCriterion("zy is not null");
            return (Criteria) this;
        }

        public Criteria andZyEqualTo(String value) {
            addCriterion("zy =", value, "zy");
            return (Criteria) this;
        }

        public Criteria andZyNotEqualTo(String value) {
            addCriterion("zy <>", value, "zy");
            return (Criteria) this;
        }

        public Criteria andZyGreaterThan(String value) {
            addCriterion("zy >", value, "zy");
            return (Criteria) this;
        }

        public Criteria andZyGreaterThanOrEqualTo(String value) {
            addCriterion("zy >=", value, "zy");
            return (Criteria) this;
        }

        public Criteria andZyLessThan(String value) {
            addCriterion("zy <", value, "zy");
            return (Criteria) this;
        }

        public Criteria andZyLessThanOrEqualTo(String value) {
            addCriterion("zy <=", value, "zy");
            return (Criteria) this;
        }

        public Criteria andZyLike(String value) {
            addCriterion("zy like", value, "zy");
            return (Criteria) this;
        }

        public Criteria andZyNotLike(String value) {
            addCriterion("zy not like", value, "zy");
            return (Criteria) this;
        }

        public Criteria andZyIn(List<String> values) {
            addCriterion("zy in", values, "zy");
            return (Criteria) this;
        }

        public Criteria andZyNotIn(List<String> values) {
            addCriterion("zy not in", values, "zy");
            return (Criteria) this;
        }

        public Criteria andZyBetween(String value1, String value2) {
            addCriterion("zy between", value1, value2, "zy");
            return (Criteria) this;
        }

        public Criteria andZyNotBetween(String value1, String value2) {
            addCriterion("zy not between", value1, value2, "zy");
            return (Criteria) this;
        }

        public Criteria andJdhIsNull() {
            addCriterion("jdh is null");
            return (Criteria) this;
        }

        public Criteria andJdhIsNotNull() {
            addCriterion("jdh is not null");
            return (Criteria) this;
        }

        public Criteria andJdhEqualTo(String value) {
            addCriterion("jdh =", value, "jdh");
            return (Criteria) this;
        }

        public Criteria andJdhNotEqualTo(String value) {
            addCriterion("jdh <>", value, "jdh");
            return (Criteria) this;
        }

        public Criteria andJdhGreaterThan(String value) {
            addCriterion("jdh >", value, "jdh");
            return (Criteria) this;
        }

        public Criteria andJdhGreaterThanOrEqualTo(String value) {
            addCriterion("jdh >=", value, "jdh");
            return (Criteria) this;
        }

        public Criteria andJdhLessThan(String value) {
            addCriterion("jdh <", value, "jdh");
            return (Criteria) this;
        }

        public Criteria andJdhLessThanOrEqualTo(String value) {
            addCriterion("jdh <=", value, "jdh");
            return (Criteria) this;
        }

        public Criteria andJdhLike(String value) {
            addCriterion("jdh like", value, "jdh");
            return (Criteria) this;
        }

        public Criteria andJdhNotLike(String value) {
            addCriterion("jdh not like", value, "jdh");
            return (Criteria) this;
        }

        public Criteria andJdhIn(List<String> values) {
            addCriterion("jdh in", values, "jdh");
            return (Criteria) this;
        }

        public Criteria andJdhNotIn(List<String> values) {
            addCriterion("jdh not in", values, "jdh");
            return (Criteria) this;
        }

        public Criteria andJdhBetween(String value1, String value2) {
            addCriterion("jdh between", value1, value2, "jdh");
            return (Criteria) this;
        }

        public Criteria andJdhNotBetween(String value1, String value2) {
            addCriterion("jdh not between", value1, value2, "jdh");
            return (Criteria) this;
        }

        public Criteria andIssczsIsNull() {
            addCriterion("issczs is null");
            return (Criteria) this;
        }

        public Criteria andIssczsIsNotNull() {
            addCriterion("issczs is not null");
            return (Criteria) this;
        }

        public Criteria andIssczsEqualTo(String value) {
            addCriterion("issczs =", value, "issczs");
            return (Criteria) this;
        }

        public Criteria andIssczsNotEqualTo(String value) {
            addCriterion("issczs <>", value, "issczs");
            return (Criteria) this;
        }

        public Criteria andIssczsGreaterThan(String value) {
            addCriterion("issczs >", value, "issczs");
            return (Criteria) this;
        }

        public Criteria andIssczsGreaterThanOrEqualTo(String value) {
            addCriterion("issczs >=", value, "issczs");
            return (Criteria) this;
        }

        public Criteria andIssczsLessThan(String value) {
            addCriterion("issczs <", value, "issczs");
            return (Criteria) this;
        }

        public Criteria andIssczsLessThanOrEqualTo(String value) {
            addCriterion("issczs <=", value, "issczs");
            return (Criteria) this;
        }

        public Criteria andIssczsLike(String value) {
            addCriterion("issczs like", value, "issczs");
            return (Criteria) this;
        }

        public Criteria andIssczsNotLike(String value) {
            addCriterion("issczs not like", value, "issczs");
            return (Criteria) this;
        }

        public Criteria andIssczsIn(List<String> values) {
            addCriterion("issczs in", values, "issczs");
            return (Criteria) this;
        }

        public Criteria andIssczsNotIn(List<String> values) {
            addCriterion("issczs not in", values, "issczs");
            return (Criteria) this;
        }

        public Criteria andIssczsBetween(String value1, String value2) {
            addCriterion("issczs between", value1, value2, "issczs");
            return (Criteria) this;
        }

        public Criteria andIssczsNotBetween(String value1, String value2) {
            addCriterion("issczs not between", value1, value2, "issczs");
            return (Criteria) this;
        }

        public Criteria andSbztIsNull() {
            addCriterion("sbzt is null");
            return (Criteria) this;
        }

        public Criteria andSbztIsNotNull() {
            addCriterion("sbzt is not null");
            return (Criteria) this;
        }

        public Criteria andSbztEqualTo(String value) {
            addCriterion("sbzt =", value, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztNotEqualTo(String value) {
            addCriterion("sbzt <>", value, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztGreaterThan(String value) {
            addCriterion("sbzt >", value, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztGreaterThanOrEqualTo(String value) {
            addCriterion("sbzt >=", value, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztLessThan(String value) {
            addCriterion("sbzt <", value, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztLessThanOrEqualTo(String value) {
            addCriterion("sbzt <=", value, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztLike(String value) {
            addCriterion("sbzt like", value, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztNotLike(String value) {
            addCriterion("sbzt not like", value, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztIn(List<String> values) {
            addCriterion("sbzt in", values, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztNotIn(List<String> values) {
            addCriterion("sbzt not in", values, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztBetween(String value1, String value2) {
            addCriterion("sbzt between", value1, value2, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztNotBetween(String value1, String value2) {
            addCriterion("sbzt not between", value1, value2, "sbzt");
            return (Criteria) this;
        }

        public Criteria andJdjgIsNull() {
            addCriterion("jdjg is null");
            return (Criteria) this;
        }

        public Criteria andJdjgIsNotNull() {
            addCriterion("jdjg is not null");
            return (Criteria) this;
        }

        public Criteria andJdjgEqualTo(String value) {
            addCriterion("jdjg =", value, "jdjg");
            return (Criteria) this;
        }

        public Criteria andJdjgNotEqualTo(String value) {
            addCriterion("jdjg <>", value, "jdjg");
            return (Criteria) this;
        }

        public Criteria andJdjgGreaterThan(String value) {
            addCriterion("jdjg >", value, "jdjg");
            return (Criteria) this;
        }

        public Criteria andJdjgGreaterThanOrEqualTo(String value) {
            addCriterion("jdjg >=", value, "jdjg");
            return (Criteria) this;
        }

        public Criteria andJdjgLessThan(String value) {
            addCriterion("jdjg <", value, "jdjg");
            return (Criteria) this;
        }

        public Criteria andJdjgLessThanOrEqualTo(String value) {
            addCriterion("jdjg <=", value, "jdjg");
            return (Criteria) this;
        }

        public Criteria andJdjgLike(String value) {
            addCriterion("jdjg like", value, "jdjg");
            return (Criteria) this;
        }

        public Criteria andJdjgNotLike(String value) {
            addCriterion("jdjg not like", value, "jdjg");
            return (Criteria) this;
        }

        public Criteria andJdjgIn(List<String> values) {
            addCriterion("jdjg in", values, "jdjg");
            return (Criteria) this;
        }

        public Criteria andJdjgNotIn(List<String> values) {
            addCriterion("jdjg not in", values, "jdjg");
            return (Criteria) this;
        }

        public Criteria andJdjgBetween(String value1, String value2) {
            addCriterion("jdjg between", value1, value2, "jdjg");
            return (Criteria) this;
        }

        public Criteria andJdjgNotBetween(String value1, String value2) {
            addCriterion("jdjg not between", value1, value2, "jdjg");
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

        public Criteria andUpdateUserIdIsNull() {
            addCriterion("update_user_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNotNull() {
            addCriterion("update_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdEqualTo(String value) {
            addCriterion("update_user_id =", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotEqualTo(String value) {
            addCriterion("update_user_id <>", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThan(String value) {
            addCriterion("update_user_id >", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("update_user_id >=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThan(String value) {
            addCriterion("update_user_id <", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThanOrEqualTo(String value) {
            addCriterion("update_user_id <=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLike(String value) {
            addCriterion("update_user_id like", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotLike(String value) {
            addCriterion("update_user_id not like", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIn(List<String> values) {
            addCriterion("update_user_id in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotIn(List<String> values) {
            addCriterion("update_user_id not in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdBetween(String value1, String value2) {
            addCriterion("update_user_id between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotBetween(String value1, String value2) {
            addCriterion("update_user_id not between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andHthIsNull() {
            addCriterion("hth is null");
            return (Criteria) this;
        }

        public Criteria andHthIsNotNull() {
            addCriterion("hth is not null");
            return (Criteria) this;
        }

        public Criteria andHthEqualTo(String value) {
            addCriterion("hth =", value, "hth");
            return (Criteria) this;
        }

        public Criteria andHthNotEqualTo(String value) {
            addCriterion("hth <>", value, "hth");
            return (Criteria) this;
        }

        public Criteria andHthGreaterThan(String value) {
            addCriterion("hth >", value, "hth");
            return (Criteria) this;
        }

        public Criteria andHthGreaterThanOrEqualTo(String value) {
            addCriterion("hth >=", value, "hth");
            return (Criteria) this;
        }

        public Criteria andHthLessThan(String value) {
            addCriterion("hth <", value, "hth");
            return (Criteria) this;
        }

        public Criteria andHthLessThanOrEqualTo(String value) {
            addCriterion("hth <=", value, "hth");
            return (Criteria) this;
        }

        public Criteria andHthLike(String value) {
            addCriterion("hth like", value, "hth");
            return (Criteria) this;
        }

        public Criteria andHthNotLike(String value) {
            addCriterion("hth not like", value, "hth");
            return (Criteria) this;
        }

        public Criteria andHthIn(List<String> values) {
            addCriterion("hth in", values, "hth");
            return (Criteria) this;
        }

        public Criteria andHthNotIn(List<String> values) {
            addCriterion("hth not in", values, "hth");
            return (Criteria) this;
        }

        public Criteria andHthBetween(String value1, String value2) {
            addCriterion("hth between", value1, value2, "hth");
            return (Criteria) this;
        }

        public Criteria andHthNotBetween(String value1, String value2) {
            addCriterion("hth not between", value1, value2, "hth");
            return (Criteria) this;
        }

        public Criteria andXmmcIsNull() {
            addCriterion("xmmc is null");
            return (Criteria) this;
        }

        public Criteria andXmmcIsNotNull() {
            addCriterion("xmmc is not null");
            return (Criteria) this;
        }

        public Criteria andXmmcEqualTo(String value) {
            addCriterion("xmmc =", value, "xmmc");
            return (Criteria) this;
        }

        public Criteria andXmmcNotEqualTo(String value) {
            addCriterion("xmmc <>", value, "xmmc");
            return (Criteria) this;
        }

        public Criteria andXmmcGreaterThan(String value) {
            addCriterion("xmmc >", value, "xmmc");
            return (Criteria) this;
        }

        public Criteria andXmmcGreaterThanOrEqualTo(String value) {
            addCriterion("xmmc >=", value, "xmmc");
            return (Criteria) this;
        }

        public Criteria andXmmcLessThan(String value) {
            addCriterion("xmmc <", value, "xmmc");
            return (Criteria) this;
        }

        public Criteria andXmmcLessThanOrEqualTo(String value) {
            addCriterion("xmmc <=", value, "xmmc");
            return (Criteria) this;
        }

        public Criteria andXmmcLike(String value) {
            addCriterion("xmmc like", value, "xmmc");
            return (Criteria) this;
        }

        public Criteria andXmmcNotLike(String value) {
            addCriterion("xmmc not like", value, "xmmc");
            return (Criteria) this;
        }

        public Criteria andXmmcIn(List<String> values) {
            addCriterion("xmmc in", values, "xmmc");
            return (Criteria) this;
        }

        public Criteria andXmmcNotIn(List<String> values) {
            addCriterion("xmmc not in", values, "xmmc");
            return (Criteria) this;
        }

        public Criteria andXmmcBetween(String value1, String value2) {
            addCriterion("xmmc between", value1, value2, "xmmc");
            return (Criteria) this;
        }

        public Criteria andXmmcNotBetween(String value1, String value2) {
            addCriterion("xmmc not between", value1, value2, "xmmc");
            return (Criteria) this;
        }

        public Criteria andRwlyIsNull() {
            addCriterion("rwly is null");
            return (Criteria) this;
        }

        public Criteria andRwlyIsNotNull() {
            addCriterion("rwly is not null");
            return (Criteria) this;
        }

        public Criteria andRwlyEqualTo(String value) {
            addCriterion("rwly =", value, "rwly");
            return (Criteria) this;
        }

        public Criteria andRwlyNotEqualTo(String value) {
            addCriterion("rwly <>", value, "rwly");
            return (Criteria) this;
        }

        public Criteria andRwlyGreaterThan(String value) {
            addCriterion("rwly >", value, "rwly");
            return (Criteria) this;
        }

        public Criteria andRwlyGreaterThanOrEqualTo(String value) {
            addCriterion("rwly >=", value, "rwly");
            return (Criteria) this;
        }

        public Criteria andRwlyLessThan(String value) {
            addCriterion("rwly <", value, "rwly");
            return (Criteria) this;
        }

        public Criteria andRwlyLessThanOrEqualTo(String value) {
            addCriterion("rwly <=", value, "rwly");
            return (Criteria) this;
        }

        public Criteria andRwlyLike(String value) {
            addCriterion("rwly like", value, "rwly");
            return (Criteria) this;
        }

        public Criteria andRwlyNotLike(String value) {
            addCriterion("rwly not like", value, "rwly");
            return (Criteria) this;
        }

        public Criteria andRwlyIn(List<String> values) {
            addCriterion("rwly in", values, "rwly");
            return (Criteria) this;
        }

        public Criteria andRwlyNotIn(List<String> values) {
            addCriterion("rwly not in", values, "rwly");
            return (Criteria) this;
        }

        public Criteria andRwlyBetween(String value1, String value2) {
            addCriterion("rwly between", value1, value2, "rwly");
            return (Criteria) this;
        }

        public Criteria andRwlyNotBetween(String value1, String value2) {
            addCriterion("rwly not between", value1, value2, "rwly");
            return (Criteria) this;
        }

        public Criteria andDefine1IsNull() {
            addCriterion("define1 is null");
            return (Criteria) this;
        }

        public Criteria andDefine1IsNotNull() {
            addCriterion("define1 is not null");
            return (Criteria) this;
        }

        public Criteria andDefine1EqualTo(String value) {
            addCriterion("define1 =", value, "define1");
            return (Criteria) this;
        }

        public Criteria andDefine1NotEqualTo(String value) {
            addCriterion("define1 <>", value, "define1");
            return (Criteria) this;
        }

        public Criteria andDefine1GreaterThan(String value) {
            addCriterion("define1 >", value, "define1");
            return (Criteria) this;
        }

        public Criteria andDefine1GreaterThanOrEqualTo(String value) {
            addCriterion("define1 >=", value, "define1");
            return (Criteria) this;
        }

        public Criteria andDefine1LessThan(String value) {
            addCriterion("define1 <", value, "define1");
            return (Criteria) this;
        }

        public Criteria andDefine1LessThanOrEqualTo(String value) {
            addCriterion("define1 <=", value, "define1");
            return (Criteria) this;
        }

        public Criteria andDefine1Like(String value) {
            addCriterion("define1 like", value, "define1");
            return (Criteria) this;
        }

        public Criteria andDefine1NotLike(String value) {
            addCriterion("define1 not like", value, "define1");
            return (Criteria) this;
        }

        public Criteria andDefine1In(List<String> values) {
            addCriterion("define1 in", values, "define1");
            return (Criteria) this;
        }

        public Criteria andDefine1NotIn(List<String> values) {
            addCriterion("define1 not in", values, "define1");
            return (Criteria) this;
        }

        public Criteria andDefine1Between(String value1, String value2) {
            addCriterion("define1 between", value1, value2, "define1");
            return (Criteria) this;
        }

        public Criteria andDefine1NotBetween(String value1, String value2) {
            addCriterion("define1 not between", value1, value2, "define1");
            return (Criteria) this;
        }

        public Criteria andDefine2IsNull() {
            addCriterion("define2 is null");
            return (Criteria) this;
        }

        public Criteria andDefine2IsNotNull() {
            addCriterion("define2 is not null");
            return (Criteria) this;
        }

        public Criteria andDefine2EqualTo(String value) {
            addCriterion("define2 =", value, "define2");
            return (Criteria) this;
        }

        public Criteria andDefine2NotEqualTo(String value) {
            addCriterion("define2 <>", value, "define2");
            return (Criteria) this;
        }

        public Criteria andDefine2GreaterThan(String value) {
            addCriterion("define2 >", value, "define2");
            return (Criteria) this;
        }

        public Criteria andDefine2GreaterThanOrEqualTo(String value) {
            addCriterion("define2 >=", value, "define2");
            return (Criteria) this;
        }

        public Criteria andDefine2LessThan(String value) {
            addCriterion("define2 <", value, "define2");
            return (Criteria) this;
        }

        public Criteria andDefine2LessThanOrEqualTo(String value) {
            addCriterion("define2 <=", value, "define2");
            return (Criteria) this;
        }

        public Criteria andDefine2Like(String value) {
            addCriterion("define2 like", value, "define2");
            return (Criteria) this;
        }

        public Criteria andDefine2NotLike(String value) {
            addCriterion("define2 not like", value, "define2");
            return (Criteria) this;
        }

        public Criteria andDefine2In(List<String> values) {
            addCriterion("define2 in", values, "define2");
            return (Criteria) this;
        }

        public Criteria andDefine2NotIn(List<String> values) {
            addCriterion("define2 not in", values, "define2");
            return (Criteria) this;
        }

        public Criteria andDefine2Between(String value1, String value2) {
            addCriterion("define2 between", value1, value2, "define2");
            return (Criteria) this;
        }

        public Criteria andDefine2NotBetween(String value1, String value2) {
            addCriterion("define2 not between", value1, value2, "define2");
            return (Criteria) this;
        }

        public Criteria andDefine3IsNull() {
            addCriterion("define3 is null");
            return (Criteria) this;
        }

        public Criteria andDefine3IsNotNull() {
            addCriterion("define3 is not null");
            return (Criteria) this;
        }

        public Criteria andDefine3EqualTo(String value) {
            addCriterion("define3 =", value, "define3");
            return (Criteria) this;
        }

        public Criteria andDefine3NotEqualTo(String value) {
            addCriterion("define3 <>", value, "define3");
            return (Criteria) this;
        }

        public Criteria andDefine3GreaterThan(String value) {
            addCriterion("define3 >", value, "define3");
            return (Criteria) this;
        }

        public Criteria andDefine3GreaterThanOrEqualTo(String value) {
            addCriterion("define3 >=", value, "define3");
            return (Criteria) this;
        }

        public Criteria andDefine3LessThan(String value) {
            addCriterion("define3 <", value, "define3");
            return (Criteria) this;
        }

        public Criteria andDefine3LessThanOrEqualTo(String value) {
            addCriterion("define3 <=", value, "define3");
            return (Criteria) this;
        }

        public Criteria andDefine3Like(String value) {
            addCriterion("define3 like", value, "define3");
            return (Criteria) this;
        }

        public Criteria andDefine3NotLike(String value) {
            addCriterion("define3 not like", value, "define3");
            return (Criteria) this;
        }

        public Criteria andDefine3In(List<String> values) {
            addCriterion("define3 in", values, "define3");
            return (Criteria) this;
        }

        public Criteria andDefine3NotIn(List<String> values) {
            addCriterion("define3 not in", values, "define3");
            return (Criteria) this;
        }

        public Criteria andDefine3Between(String value1, String value2) {
            addCriterion("define3 between", value1, value2, "define3");
            return (Criteria) this;
        }

        public Criteria andDefine3NotBetween(String value1, String value2) {
            addCriterion("define3 not between", value1, value2, "define3");
            return (Criteria) this;
        }

        public Criteria andDefine4IsNull() {
            addCriterion("define4 is null");
            return (Criteria) this;
        }

        public Criteria andDefine4IsNotNull() {
            addCriterion("define4 is not null");
            return (Criteria) this;
        }

        public Criteria andDefine4EqualTo(String value) {
            addCriterion("define4 =", value, "define4");
            return (Criteria) this;
        }

        public Criteria andDefine4NotEqualTo(String value) {
            addCriterion("define4 <>", value, "define4");
            return (Criteria) this;
        }

        public Criteria andDefine4GreaterThan(String value) {
            addCriterion("define4 >", value, "define4");
            return (Criteria) this;
        }

        public Criteria andDefine4GreaterThanOrEqualTo(String value) {
            addCriterion("define4 >=", value, "define4");
            return (Criteria) this;
        }

        public Criteria andDefine4LessThan(String value) {
            addCriterion("define4 <", value, "define4");
            return (Criteria) this;
        }

        public Criteria andDefine4LessThanOrEqualTo(String value) {
            addCriterion("define4 <=", value, "define4");
            return (Criteria) this;
        }

        public Criteria andDefine4Like(String value) {
            addCriterion("define4 like", value, "define4");
            return (Criteria) this;
        }

        public Criteria andDefine4NotLike(String value) {
            addCriterion("define4 not like", value, "define4");
            return (Criteria) this;
        }

        public Criteria andDefine4In(List<String> values) {
            addCriterion("define4 in", values, "define4");
            return (Criteria) this;
        }

        public Criteria andDefine4NotIn(List<String> values) {
            addCriterion("define4 not in", values, "define4");
            return (Criteria) this;
        }

        public Criteria andDefine4Between(String value1, String value2) {
            addCriterion("define4 between", value1, value2, "define4");
            return (Criteria) this;
        }

        public Criteria andDefine4NotBetween(String value1, String value2) {
            addCriterion("define4 not between", value1, value2, "define4");
            return (Criteria) this;
        }

        public Criteria andDefine5IsNull() {
            addCriterion("define5 is null");
            return (Criteria) this;
        }

        public Criteria andDefine5IsNotNull() {
            addCriterion("define5 is not null");
            return (Criteria) this;
        }

        public Criteria andDefine5EqualTo(String value) {
            addCriterion("define5 =", value, "define5");
            return (Criteria) this;
        }

        public Criteria andDefine5NotEqualTo(String value) {
            addCriterion("define5 <>", value, "define5");
            return (Criteria) this;
        }

        public Criteria andDefine5GreaterThan(String value) {
            addCriterion("define5 >", value, "define5");
            return (Criteria) this;
        }

        public Criteria andDefine5GreaterThanOrEqualTo(String value) {
            addCriterion("define5 >=", value, "define5");
            return (Criteria) this;
        }

        public Criteria andDefine5LessThan(String value) {
            addCriterion("define5 <", value, "define5");
            return (Criteria) this;
        }

        public Criteria andDefine5LessThanOrEqualTo(String value) {
            addCriterion("define5 <=", value, "define5");
            return (Criteria) this;
        }

        public Criteria andDefine5Like(String value) {
            addCriterion("define5 like", value, "define5");
            return (Criteria) this;
        }

        public Criteria andDefine5NotLike(String value) {
            addCriterion("define5 not like", value, "define5");
            return (Criteria) this;
        }

        public Criteria andDefine5In(List<String> values) {
            addCriterion("define5 in", values, "define5");
            return (Criteria) this;
        }

        public Criteria andDefine5NotIn(List<String> values) {
            addCriterion("define5 not in", values, "define5");
            return (Criteria) this;
        }

        public Criteria andDefine5Between(String value1, String value2) {
            addCriterion("define5 between", value1, value2, "define5");
            return (Criteria) this;
        }

        public Criteria andDefine5NotBetween(String value1, String value2) {
            addCriterion("define5 not between", value1, value2, "define5");
            return (Criteria) this;
        }

        public Criteria andDefine6IsNull() {
            addCriterion("define6 is null");
            return (Criteria) this;
        }

        public Criteria andDefine6IsNotNull() {
            addCriterion("define6 is not null");
            return (Criteria) this;
        }

        public Criteria andDefine6EqualTo(String value) {
            addCriterion("define6 =", value, "define6");
            return (Criteria) this;
        }

        public Criteria andDefine6NotEqualTo(String value) {
            addCriterion("define6 <>", value, "define6");
            return (Criteria) this;
        }

        public Criteria andDefine6GreaterThan(String value) {
            addCriterion("define6 >", value, "define6");
            return (Criteria) this;
        }

        public Criteria andDefine6GreaterThanOrEqualTo(String value) {
            addCriterion("define6 >=", value, "define6");
            return (Criteria) this;
        }

        public Criteria andDefine6LessThan(String value) {
            addCriterion("define6 <", value, "define6");
            return (Criteria) this;
        }

        public Criteria andDefine6LessThanOrEqualTo(String value) {
            addCriterion("define6 <=", value, "define6");
            return (Criteria) this;
        }

        public Criteria andDefine6Like(String value) {
            addCriterion("define6 like", value, "define6");
            return (Criteria) this;
        }

        public Criteria andDefine6NotLike(String value) {
            addCriterion("define6 not like", value, "define6");
            return (Criteria) this;
        }

        public Criteria andDefine6In(List<String> values) {
            addCriterion("define6 in", values, "define6");
            return (Criteria) this;
        }

        public Criteria andDefine6NotIn(List<String> values) {
            addCriterion("define6 not in", values, "define6");
            return (Criteria) this;
        }

        public Criteria andDefine6Between(String value1, String value2) {
            addCriterion("define6 between", value1, value2, "define6");
            return (Criteria) this;
        }

        public Criteria andDefine6NotBetween(String value1, String value2) {
            addCriterion("define6 not between", value1, value2, "define6");
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