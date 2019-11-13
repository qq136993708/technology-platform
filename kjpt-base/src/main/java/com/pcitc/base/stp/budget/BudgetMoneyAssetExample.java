package com.pcitc.base.stp.budget;

import java.util.ArrayList;
import java.util.List;

public class BudgetMoneyAssetExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BudgetMoneyAssetExample() {
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

        public Criteria andDataIdEqualTo(Integer value) {
            addCriterion("data_id =", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotEqualTo(Integer value) {
            addCriterion("data_id <>", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdGreaterThan(Integer value) {
            addCriterion("data_id >", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("data_id >=", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdLessThan(Integer value) {
            addCriterion("data_id <", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdLessThanOrEqualTo(Integer value) {
            addCriterion("data_id <=", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdIn(List<Integer> values) {
            addCriterion("data_id in", values, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotIn(List<Integer> values) {
            addCriterion("data_id not in", values, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdBetween(Integer value1, Integer value2) {
            addCriterion("data_id between", value1, value2, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotBetween(Integer value1, Integer value2) {
            addCriterion("data_id not between", value1, value2, "dataId");
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

        public Criteria andXhIsNull() {
            addCriterion("xh is null");
            return (Criteria) this;
        }

        public Criteria andXhIsNotNull() {
            addCriterion("xh is not null");
            return (Criteria) this;
        }

        public Criteria andXhEqualTo(String value) {
            addCriterion("xh =", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhNotEqualTo(String value) {
            addCriterion("xh <>", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhGreaterThan(String value) {
            addCriterion("xh >", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhGreaterThanOrEqualTo(String value) {
            addCriterion("xh >=", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhLessThan(String value) {
            addCriterion("xh <", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhLessThanOrEqualTo(String value) {
            addCriterion("xh <=", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhLike(String value) {
            addCriterion("xh like", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhNotLike(String value) {
            addCriterion("xh not like", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhIn(List<String> values) {
            addCriterion("xh in", values, "xh");
            return (Criteria) this;
        }

        public Criteria andXhNotIn(List<String> values) {
            addCriterion("xh not in", values, "xh");
            return (Criteria) this;
        }

        public Criteria andXhBetween(String value1, String value2) {
            addCriterion("xh between", value1, value2, "xh");
            return (Criteria) this;
        }

        public Criteria andXhNotBetween(String value1, String value2) {
            addCriterion("xh not between", value1, value2, "xh");
            return (Criteria) this;
        }

        public Criteria andZycIsNull() {
            addCriterion("zyc is null");
            return (Criteria) this;
        }

        public Criteria andZycIsNotNull() {
            addCriterion("zyc is not null");
            return (Criteria) this;
        }

        public Criteria andZycEqualTo(String value) {
            addCriterion("zyc =", value, "zyc");
            return (Criteria) this;
        }

        public Criteria andZycNotEqualTo(String value) {
            addCriterion("zyc <>", value, "zyc");
            return (Criteria) this;
        }

        public Criteria andZycGreaterThan(String value) {
            addCriterion("zyc >", value, "zyc");
            return (Criteria) this;
        }

        public Criteria andZycGreaterThanOrEqualTo(String value) {
            addCriterion("zyc >=", value, "zyc");
            return (Criteria) this;
        }

        public Criteria andZycLessThan(String value) {
            addCriterion("zyc <", value, "zyc");
            return (Criteria) this;
        }

        public Criteria andZycLessThanOrEqualTo(String value) {
            addCriterion("zyc <=", value, "zyc");
            return (Criteria) this;
        }

        public Criteria andZycLike(String value) {
            addCriterion("zyc like", value, "zyc");
            return (Criteria) this;
        }

        public Criteria andZycNotLike(String value) {
            addCriterion("zyc not like", value, "zyc");
            return (Criteria) this;
        }

        public Criteria andZycIn(List<String> values) {
            addCriterion("zyc in", values, "zyc");
            return (Criteria) this;
        }

        public Criteria andZycNotIn(List<String> values) {
            addCriterion("zyc not in", values, "zyc");
            return (Criteria) this;
        }

        public Criteria andZycBetween(String value1, String value2) {
            addCriterion("zyc between", value1, value2, "zyc");
            return (Criteria) this;
        }

        public Criteria andZycNotBetween(String value1, String value2) {
            addCriterion("zyc not between", value1, value2, "zyc");
            return (Criteria) this;
        }

        public Criteria andYshjIsNull() {
            addCriterion("yshj is null");
            return (Criteria) this;
        }

        public Criteria andYshjIsNotNull() {
            addCriterion("yshj is not null");
            return (Criteria) this;
        }

        public Criteria andYshjEqualTo(String value) {
            addCriterion("yshj =", value, "yshj");
            return (Criteria) this;
        }

        public Criteria andYshjNotEqualTo(String value) {
            addCriterion("yshj <>", value, "yshj");
            return (Criteria) this;
        }

        public Criteria andYshjGreaterThan(String value) {
            addCriterion("yshj >", value, "yshj");
            return (Criteria) this;
        }

        public Criteria andYshjGreaterThanOrEqualTo(String value) {
            addCriterion("yshj >=", value, "yshj");
            return (Criteria) this;
        }

        public Criteria andYshjLessThan(String value) {
            addCriterion("yshj <", value, "yshj");
            return (Criteria) this;
        }

        public Criteria andYshjLessThanOrEqualTo(String value) {
            addCriterion("yshj <=", value, "yshj");
            return (Criteria) this;
        }

        public Criteria andYshjLike(String value) {
            addCriterion("yshj like", value, "yshj");
            return (Criteria) this;
        }

        public Criteria andYshjNotLike(String value) {
            addCriterion("yshj not like", value, "yshj");
            return (Criteria) this;
        }

        public Criteria andYshjIn(List<String> values) {
            addCriterion("yshj in", values, "yshj");
            return (Criteria) this;
        }

        public Criteria andYshjNotIn(List<String> values) {
            addCriterion("yshj not in", values, "yshj");
            return (Criteria) this;
        }

        public Criteria andYshjBetween(String value1, String value2) {
            addCriterion("yshj between", value1, value2, "yshj");
            return (Criteria) this;
        }

        public Criteria andYshjNotBetween(String value1, String value2) {
            addCriterion("yshj not between", value1, value2, "yshj");
            return (Criteria) this;
        }

        public Criteria andJzxmjfhjIsNull() {
            addCriterion("jzxmjfhj is null");
            return (Criteria) this;
        }

        public Criteria andJzxmjfhjIsNotNull() {
            addCriterion("jzxmjfhj is not null");
            return (Criteria) this;
        }

        public Criteria andJzxmjfhjEqualTo(String value) {
            addCriterion("jzxmjfhj =", value, "jzxmjfhj");
            return (Criteria) this;
        }

        public Criteria andJzxmjfhjNotEqualTo(String value) {
            addCriterion("jzxmjfhj <>", value, "jzxmjfhj");
            return (Criteria) this;
        }

        public Criteria andJzxmjfhjGreaterThan(String value) {
            addCriterion("jzxmjfhj >", value, "jzxmjfhj");
            return (Criteria) this;
        }

        public Criteria andJzxmjfhjGreaterThanOrEqualTo(String value) {
            addCriterion("jzxmjfhj >=", value, "jzxmjfhj");
            return (Criteria) this;
        }

        public Criteria andJzxmjfhjLessThan(String value) {
            addCriterion("jzxmjfhj <", value, "jzxmjfhj");
            return (Criteria) this;
        }

        public Criteria andJzxmjfhjLessThanOrEqualTo(String value) {
            addCriterion("jzxmjfhj <=", value, "jzxmjfhj");
            return (Criteria) this;
        }

        public Criteria andJzxmjfhjLike(String value) {
            addCriterion("jzxmjfhj like", value, "jzxmjfhj");
            return (Criteria) this;
        }

        public Criteria andJzxmjfhjNotLike(String value) {
            addCriterion("jzxmjfhj not like", value, "jzxmjfhj");
            return (Criteria) this;
        }

        public Criteria andJzxmjfhjIn(List<String> values) {
            addCriterion("jzxmjfhj in", values, "jzxmjfhj");
            return (Criteria) this;
        }

        public Criteria andJzxmjfhjNotIn(List<String> values) {
            addCriterion("jzxmjfhj not in", values, "jzxmjfhj");
            return (Criteria) this;
        }

        public Criteria andJzxmjfhjBetween(String value1, String value2) {
            addCriterion("jzxmjfhj between", value1, value2, "jzxmjfhj");
            return (Criteria) this;
        }

        public Criteria andJzxmjfhjNotBetween(String value1, String value2) {
            addCriterion("jzxmjfhj not between", value1, value2, "jzxmjfhj");
            return (Criteria) this;
        }

        public Criteria andJzxmjfzcbIsNull() {
            addCriterion("jzxmjfzcb is null");
            return (Criteria) this;
        }

        public Criteria andJzxmjfzcbIsNotNull() {
            addCriterion("jzxmjfzcb is not null");
            return (Criteria) this;
        }

        public Criteria andJzxmjfzcbEqualTo(String value) {
            addCriterion("jzxmjfzcb =", value, "jzxmjfzcb");
            return (Criteria) this;
        }

        public Criteria andJzxmjfzcbNotEqualTo(String value) {
            addCriterion("jzxmjfzcb <>", value, "jzxmjfzcb");
            return (Criteria) this;
        }

        public Criteria andJzxmjfzcbGreaterThan(String value) {
            addCriterion("jzxmjfzcb >", value, "jzxmjfzcb");
            return (Criteria) this;
        }

        public Criteria andJzxmjfzcbGreaterThanOrEqualTo(String value) {
            addCriterion("jzxmjfzcb >=", value, "jzxmjfzcb");
            return (Criteria) this;
        }

        public Criteria andJzxmjfzcbLessThan(String value) {
            addCriterion("jzxmjfzcb <", value, "jzxmjfzcb");
            return (Criteria) this;
        }

        public Criteria andJzxmjfzcbLessThanOrEqualTo(String value) {
            addCriterion("jzxmjfzcb <=", value, "jzxmjfzcb");
            return (Criteria) this;
        }

        public Criteria andJzxmjfzcbLike(String value) {
            addCriterion("jzxmjfzcb like", value, "jzxmjfzcb");
            return (Criteria) this;
        }

        public Criteria andJzxmjfzcbNotLike(String value) {
            addCriterion("jzxmjfzcb not like", value, "jzxmjfzcb");
            return (Criteria) this;
        }

        public Criteria andJzxmjfzcbIn(List<String> values) {
            addCriterion("jzxmjfzcb in", values, "jzxmjfzcb");
            return (Criteria) this;
        }

        public Criteria andJzxmjfzcbNotIn(List<String> values) {
            addCriterion("jzxmjfzcb not in", values, "jzxmjfzcb");
            return (Criteria) this;
        }

        public Criteria andJzxmjfzcbBetween(String value1, String value2) {
            addCriterion("jzxmjfzcb between", value1, value2, "jzxmjfzcb");
            return (Criteria) this;
        }

        public Criteria andJzxmjfzcbNotBetween(String value1, String value2) {
            addCriterion("jzxmjfzcb not between", value1, value2, "jzxmjfzcb");
            return (Criteria) this;
        }

        public Criteria andJzxmjfhgbIsNull() {
            addCriterion("jzxmjfhgb is null");
            return (Criteria) this;
        }

        public Criteria andJzxmjfhgbIsNotNull() {
            addCriterion("jzxmjfhgb is not null");
            return (Criteria) this;
        }

        public Criteria andJzxmjfhgbEqualTo(String value) {
            addCriterion("jzxmjfhgb =", value, "jzxmjfhgb");
            return (Criteria) this;
        }

        public Criteria andJzxmjfhgbNotEqualTo(String value) {
            addCriterion("jzxmjfhgb <>", value, "jzxmjfhgb");
            return (Criteria) this;
        }

        public Criteria andJzxmjfhgbGreaterThan(String value) {
            addCriterion("jzxmjfhgb >", value, "jzxmjfhgb");
            return (Criteria) this;
        }

        public Criteria andJzxmjfhgbGreaterThanOrEqualTo(String value) {
            addCriterion("jzxmjfhgb >=", value, "jzxmjfhgb");
            return (Criteria) this;
        }

        public Criteria andJzxmjfhgbLessThan(String value) {
            addCriterion("jzxmjfhgb <", value, "jzxmjfhgb");
            return (Criteria) this;
        }

        public Criteria andJzxmjfhgbLessThanOrEqualTo(String value) {
            addCriterion("jzxmjfhgb <=", value, "jzxmjfhgb");
            return (Criteria) this;
        }

        public Criteria andJzxmjfhgbLike(String value) {
            addCriterion("jzxmjfhgb like", value, "jzxmjfhgb");
            return (Criteria) this;
        }

        public Criteria andJzxmjfhgbNotLike(String value) {
            addCriterion("jzxmjfhgb not like", value, "jzxmjfhgb");
            return (Criteria) this;
        }

        public Criteria andJzxmjfhgbIn(List<String> values) {
            addCriterion("jzxmjfhgb in", values, "jzxmjfhgb");
            return (Criteria) this;
        }

        public Criteria andJzxmjfhgbNotIn(List<String> values) {
            addCriterion("jzxmjfhgb not in", values, "jzxmjfhgb");
            return (Criteria) this;
        }

        public Criteria andJzxmjfhgbBetween(String value1, String value2) {
            addCriterion("jzxmjfhgb between", value1, value2, "jzxmjfhgb");
            return (Criteria) this;
        }

        public Criteria andJzxmjfhgbNotBetween(String value1, String value2) {
            addCriterion("jzxmjfhgb not between", value1, value2, "jzxmjfhgb");
            return (Criteria) this;
        }

        public Criteria andXkxmjfhjIsNull() {
            addCriterion("xkxmjfhj is null");
            return (Criteria) this;
        }

        public Criteria andXkxmjfhjIsNotNull() {
            addCriterion("xkxmjfhj is not null");
            return (Criteria) this;
        }

        public Criteria andXkxmjfhjEqualTo(String value) {
            addCriterion("xkxmjfhj =", value, "xkxmjfhj");
            return (Criteria) this;
        }

        public Criteria andXkxmjfhjNotEqualTo(String value) {
            addCriterion("xkxmjfhj <>", value, "xkxmjfhj");
            return (Criteria) this;
        }

        public Criteria andXkxmjfhjGreaterThan(String value) {
            addCriterion("xkxmjfhj >", value, "xkxmjfhj");
            return (Criteria) this;
        }

        public Criteria andXkxmjfhjGreaterThanOrEqualTo(String value) {
            addCriterion("xkxmjfhj >=", value, "xkxmjfhj");
            return (Criteria) this;
        }

        public Criteria andXkxmjfhjLessThan(String value) {
            addCriterion("xkxmjfhj <", value, "xkxmjfhj");
            return (Criteria) this;
        }

        public Criteria andXkxmjfhjLessThanOrEqualTo(String value) {
            addCriterion("xkxmjfhj <=", value, "xkxmjfhj");
            return (Criteria) this;
        }

        public Criteria andXkxmjfhjLike(String value) {
            addCriterion("xkxmjfhj like", value, "xkxmjfhj");
            return (Criteria) this;
        }

        public Criteria andXkxmjfhjNotLike(String value) {
            addCriterion("xkxmjfhj not like", value, "xkxmjfhj");
            return (Criteria) this;
        }

        public Criteria andXkxmjfhjIn(List<String> values) {
            addCriterion("xkxmjfhj in", values, "xkxmjfhj");
            return (Criteria) this;
        }

        public Criteria andXkxmjfhjNotIn(List<String> values) {
            addCriterion("xkxmjfhj not in", values, "xkxmjfhj");
            return (Criteria) this;
        }

        public Criteria andXkxmjfhjBetween(String value1, String value2) {
            addCriterion("xkxmjfhj between", value1, value2, "xkxmjfhj");
            return (Criteria) this;
        }

        public Criteria andXkxmjfhjNotBetween(String value1, String value2) {
            addCriterion("xkxmjfhj not between", value1, value2, "xkxmjfhj");
            return (Criteria) this;
        }

        public Criteria andXkxmjfzcbIsNull() {
            addCriterion("xkxmjfzcb is null");
            return (Criteria) this;
        }

        public Criteria andXkxmjfzcbIsNotNull() {
            addCriterion("xkxmjfzcb is not null");
            return (Criteria) this;
        }

        public Criteria andXkxmjfzcbEqualTo(String value) {
            addCriterion("xkxmjfzcb =", value, "xkxmjfzcb");
            return (Criteria) this;
        }

        public Criteria andXkxmjfzcbNotEqualTo(String value) {
            addCriterion("xkxmjfzcb <>", value, "xkxmjfzcb");
            return (Criteria) this;
        }

        public Criteria andXkxmjfzcbGreaterThan(String value) {
            addCriterion("xkxmjfzcb >", value, "xkxmjfzcb");
            return (Criteria) this;
        }

        public Criteria andXkxmjfzcbGreaterThanOrEqualTo(String value) {
            addCriterion("xkxmjfzcb >=", value, "xkxmjfzcb");
            return (Criteria) this;
        }

        public Criteria andXkxmjfzcbLessThan(String value) {
            addCriterion("xkxmjfzcb <", value, "xkxmjfzcb");
            return (Criteria) this;
        }

        public Criteria andXkxmjfzcbLessThanOrEqualTo(String value) {
            addCriterion("xkxmjfzcb <=", value, "xkxmjfzcb");
            return (Criteria) this;
        }

        public Criteria andXkxmjfzcbLike(String value) {
            addCriterion("xkxmjfzcb like", value, "xkxmjfzcb");
            return (Criteria) this;
        }

        public Criteria andXkxmjfzcbNotLike(String value) {
            addCriterion("xkxmjfzcb not like", value, "xkxmjfzcb");
            return (Criteria) this;
        }

        public Criteria andXkxmjfzcbIn(List<String> values) {
            addCriterion("xkxmjfzcb in", values, "xkxmjfzcb");
            return (Criteria) this;
        }

        public Criteria andXkxmjfzcbNotIn(List<String> values) {
            addCriterion("xkxmjfzcb not in", values, "xkxmjfzcb");
            return (Criteria) this;
        }

        public Criteria andXkxmjfzcbBetween(String value1, String value2) {
            addCriterion("xkxmjfzcb between", value1, value2, "xkxmjfzcb");
            return (Criteria) this;
        }

        public Criteria andXkxmjfzcbNotBetween(String value1, String value2) {
            addCriterion("xkxmjfzcb not between", value1, value2, "xkxmjfzcb");
            return (Criteria) this;
        }

        public Criteria andXkxmjfhgbIsNull() {
            addCriterion("xkxmjfhgb is null");
            return (Criteria) this;
        }

        public Criteria andXkxmjfhgbIsNotNull() {
            addCriterion("xkxmjfhgb is not null");
            return (Criteria) this;
        }

        public Criteria andXkxmjfhgbEqualTo(String value) {
            addCriterion("xkxmjfhgb =", value, "xkxmjfhgb");
            return (Criteria) this;
        }

        public Criteria andXkxmjfhgbNotEqualTo(String value) {
            addCriterion("xkxmjfhgb <>", value, "xkxmjfhgb");
            return (Criteria) this;
        }

        public Criteria andXkxmjfhgbGreaterThan(String value) {
            addCriterion("xkxmjfhgb >", value, "xkxmjfhgb");
            return (Criteria) this;
        }

        public Criteria andXkxmjfhgbGreaterThanOrEqualTo(String value) {
            addCriterion("xkxmjfhgb >=", value, "xkxmjfhgb");
            return (Criteria) this;
        }

        public Criteria andXkxmjfhgbLessThan(String value) {
            addCriterion("xkxmjfhgb <", value, "xkxmjfhgb");
            return (Criteria) this;
        }

        public Criteria andXkxmjfhgbLessThanOrEqualTo(String value) {
            addCriterion("xkxmjfhgb <=", value, "xkxmjfhgb");
            return (Criteria) this;
        }

        public Criteria andXkxmjfhgbLike(String value) {
            addCriterion("xkxmjfhgb like", value, "xkxmjfhgb");
            return (Criteria) this;
        }

        public Criteria andXkxmjfhgbNotLike(String value) {
            addCriterion("xkxmjfhgb not like", value, "xkxmjfhgb");
            return (Criteria) this;
        }

        public Criteria andXkxmjfhgbIn(List<String> values) {
            addCriterion("xkxmjfhgb in", values, "xkxmjfhgb");
            return (Criteria) this;
        }

        public Criteria andXkxmjfhgbNotIn(List<String> values) {
            addCriterion("xkxmjfhgb not in", values, "xkxmjfhgb");
            return (Criteria) this;
        }

        public Criteria andXkxmjfhgbBetween(String value1, String value2) {
            addCriterion("xkxmjfhgb between", value1, value2, "xkxmjfhgb");
            return (Criteria) this;
        }

        public Criteria andXkxmjfhgbNotBetween(String value1, String value2) {
            addCriterion("xkxmjfhgb not between", value1, value2, "xkxmjfhgb");
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