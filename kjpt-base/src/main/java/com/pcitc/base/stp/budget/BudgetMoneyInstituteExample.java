package com.pcitc.base.stp.budget;

import java.util.ArrayList;
import java.util.List;

public class BudgetMoneyInstituteExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BudgetMoneyInstituteExample() {
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

        public Criteria andHjIsNull() {
            addCriterion("hj is null");
            return (Criteria) this;
        }

        public Criteria andHjIsNotNull() {
            addCriterion("hj is not null");
            return (Criteria) this;
        }

        public Criteria andHjEqualTo(String value) {
            addCriterion("hj =", value, "hj");
            return (Criteria) this;
        }

        public Criteria andHjNotEqualTo(String value) {
            addCriterion("hj <>", value, "hj");
            return (Criteria) this;
        }

        public Criteria andHjGreaterThan(String value) {
            addCriterion("hj >", value, "hj");
            return (Criteria) this;
        }

        public Criteria andHjGreaterThanOrEqualTo(String value) {
            addCriterion("hj >=", value, "hj");
            return (Criteria) this;
        }

        public Criteria andHjLessThan(String value) {
            addCriterion("hj <", value, "hj");
            return (Criteria) this;
        }

        public Criteria andHjLessThanOrEqualTo(String value) {
            addCriterion("hj <=", value, "hj");
            return (Criteria) this;
        }

        public Criteria andHjLike(String value) {
            addCriterion("hj like", value, "hj");
            return (Criteria) this;
        }

        public Criteria andHjNotLike(String value) {
            addCriterion("hj not like", value, "hj");
            return (Criteria) this;
        }

        public Criteria andHjIn(List<String> values) {
            addCriterion("hj in", values, "hj");
            return (Criteria) this;
        }

        public Criteria andHjNotIn(List<String> values) {
            addCriterion("hj not in", values, "hj");
            return (Criteria) this;
        }

        public Criteria andHjBetween(String value1, String value2) {
            addCriterion("hj between", value1, value2, "hj");
            return (Criteria) this;
        }

        public Criteria andHjNotBetween(String value1, String value2) {
            addCriterion("hj not between", value1, value2, "hj");
            return (Criteria) this;
        }

        public Criteria andKtyIsNull() {
            addCriterion("kty is null");
            return (Criteria) this;
        }

        public Criteria andKtyIsNotNull() {
            addCriterion("kty is not null");
            return (Criteria) this;
        }

        public Criteria andKtyEqualTo(String value) {
            addCriterion("kty =", value, "kty");
            return (Criteria) this;
        }

        public Criteria andKtyNotEqualTo(String value) {
            addCriterion("kty <>", value, "kty");
            return (Criteria) this;
        }

        public Criteria andKtyGreaterThan(String value) {
            addCriterion("kty >", value, "kty");
            return (Criteria) this;
        }

        public Criteria andKtyGreaterThanOrEqualTo(String value) {
            addCriterion("kty >=", value, "kty");
            return (Criteria) this;
        }

        public Criteria andKtyLessThan(String value) {
            addCriterion("kty <", value, "kty");
            return (Criteria) this;
        }

        public Criteria andKtyLessThanOrEqualTo(String value) {
            addCriterion("kty <=", value, "kty");
            return (Criteria) this;
        }

        public Criteria andKtyLike(String value) {
            addCriterion("kty like", value, "kty");
            return (Criteria) this;
        }

        public Criteria andKtyNotLike(String value) {
            addCriterion("kty not like", value, "kty");
            return (Criteria) this;
        }

        public Criteria andKtyIn(List<String> values) {
            addCriterion("kty in", values, "kty");
            return (Criteria) this;
        }

        public Criteria andKtyNotIn(List<String> values) {
            addCriterion("kty not in", values, "kty");
            return (Criteria) this;
        }

        public Criteria andKtyBetween(String value1, String value2) {
            addCriterion("kty between", value1, value2, "kty");
            return (Criteria) this;
        }

        public Criteria andKtyNotBetween(String value1, String value2) {
            addCriterion("kty not between", value1, value2, "kty");
            return (Criteria) this;
        }

        public Criteria andGcyIsNull() {
            addCriterion("gcy is null");
            return (Criteria) this;
        }

        public Criteria andGcyIsNotNull() {
            addCriterion("gcy is not null");
            return (Criteria) this;
        }

        public Criteria andGcyEqualTo(String value) {
            addCriterion("gcy =", value, "gcy");
            return (Criteria) this;
        }

        public Criteria andGcyNotEqualTo(String value) {
            addCriterion("gcy <>", value, "gcy");
            return (Criteria) this;
        }

        public Criteria andGcyGreaterThan(String value) {
            addCriterion("gcy >", value, "gcy");
            return (Criteria) this;
        }

        public Criteria andGcyGreaterThanOrEqualTo(String value) {
            addCriterion("gcy >=", value, "gcy");
            return (Criteria) this;
        }

        public Criteria andGcyLessThan(String value) {
            addCriterion("gcy <", value, "gcy");
            return (Criteria) this;
        }

        public Criteria andGcyLessThanOrEqualTo(String value) {
            addCriterion("gcy <=", value, "gcy");
            return (Criteria) this;
        }

        public Criteria andGcyLike(String value) {
            addCriterion("gcy like", value, "gcy");
            return (Criteria) this;
        }

        public Criteria andGcyNotLike(String value) {
            addCriterion("gcy not like", value, "gcy");
            return (Criteria) this;
        }

        public Criteria andGcyIn(List<String> values) {
            addCriterion("gcy in", values, "gcy");
            return (Criteria) this;
        }

        public Criteria andGcyNotIn(List<String> values) {
            addCriterion("gcy not in", values, "gcy");
            return (Criteria) this;
        }

        public Criteria andGcyBetween(String value1, String value2) {
            addCriterion("gcy between", value1, value2, "gcy");
            return (Criteria) this;
        }

        public Criteria andGcyNotBetween(String value1, String value2) {
            addCriterion("gcy not between", value1, value2, "gcy");
            return (Criteria) this;
        }

        public Criteria andWtyIsNull() {
            addCriterion("wty is null");
            return (Criteria) this;
        }

        public Criteria andWtyIsNotNull() {
            addCriterion("wty is not null");
            return (Criteria) this;
        }

        public Criteria andWtyEqualTo(String value) {
            addCriterion("wty =", value, "wty");
            return (Criteria) this;
        }

        public Criteria andWtyNotEqualTo(String value) {
            addCriterion("wty <>", value, "wty");
            return (Criteria) this;
        }

        public Criteria andWtyGreaterThan(String value) {
            addCriterion("wty >", value, "wty");
            return (Criteria) this;
        }

        public Criteria andWtyGreaterThanOrEqualTo(String value) {
            addCriterion("wty >=", value, "wty");
            return (Criteria) this;
        }

        public Criteria andWtyLessThan(String value) {
            addCriterion("wty <", value, "wty");
            return (Criteria) this;
        }

        public Criteria andWtyLessThanOrEqualTo(String value) {
            addCriterion("wty <=", value, "wty");
            return (Criteria) this;
        }

        public Criteria andWtyLike(String value) {
            addCriterion("wty like", value, "wty");
            return (Criteria) this;
        }

        public Criteria andWtyNotLike(String value) {
            addCriterion("wty not like", value, "wty");
            return (Criteria) this;
        }

        public Criteria andWtyIn(List<String> values) {
            addCriterion("wty in", values, "wty");
            return (Criteria) this;
        }

        public Criteria andWtyNotIn(List<String> values) {
            addCriterion("wty not in", values, "wty");
            return (Criteria) this;
        }

        public Criteria andWtyBetween(String value1, String value2) {
            addCriterion("wty between", value1, value2, "wty");
            return (Criteria) this;
        }

        public Criteria andWtyNotBetween(String value1, String value2) {
            addCriterion("wty not between", value1, value2, "wty");
            return (Criteria) this;
        }

        public Criteria andSkyIsNull() {
            addCriterion("sky is null");
            return (Criteria) this;
        }

        public Criteria andSkyIsNotNull() {
            addCriterion("sky is not null");
            return (Criteria) this;
        }

        public Criteria andSkyEqualTo(String value) {
            addCriterion("sky =", value, "sky");
            return (Criteria) this;
        }

        public Criteria andSkyNotEqualTo(String value) {
            addCriterion("sky <>", value, "sky");
            return (Criteria) this;
        }

        public Criteria andSkyGreaterThan(String value) {
            addCriterion("sky >", value, "sky");
            return (Criteria) this;
        }

        public Criteria andSkyGreaterThanOrEqualTo(String value) {
            addCriterion("sky >=", value, "sky");
            return (Criteria) this;
        }

        public Criteria andSkyLessThan(String value) {
            addCriterion("sky <", value, "sky");
            return (Criteria) this;
        }

        public Criteria andSkyLessThanOrEqualTo(String value) {
            addCriterion("sky <=", value, "sky");
            return (Criteria) this;
        }

        public Criteria andSkyLike(String value) {
            addCriterion("sky like", value, "sky");
            return (Criteria) this;
        }

        public Criteria andSkyNotLike(String value) {
            addCriterion("sky not like", value, "sky");
            return (Criteria) this;
        }

        public Criteria andSkyIn(List<String> values) {
            addCriterion("sky in", values, "sky");
            return (Criteria) this;
        }

        public Criteria andSkyNotIn(List<String> values) {
            addCriterion("sky not in", values, "sky");
            return (Criteria) this;
        }

        public Criteria andSkyBetween(String value1, String value2) {
            addCriterion("sky between", value1, value2, "sky");
            return (Criteria) this;
        }

        public Criteria andSkyNotBetween(String value1, String value2) {
            addCriterion("sky not between", value1, value2, "sky");
            return (Criteria) this;
        }

        public Criteria andDlyIsNull() {
            addCriterion("dly is null");
            return (Criteria) this;
        }

        public Criteria andDlyIsNotNull() {
            addCriterion("dly is not null");
            return (Criteria) this;
        }

        public Criteria andDlyEqualTo(String value) {
            addCriterion("dly =", value, "dly");
            return (Criteria) this;
        }

        public Criteria andDlyNotEqualTo(String value) {
            addCriterion("dly <>", value, "dly");
            return (Criteria) this;
        }

        public Criteria andDlyGreaterThan(String value) {
            addCriterion("dly >", value, "dly");
            return (Criteria) this;
        }

        public Criteria andDlyGreaterThanOrEqualTo(String value) {
            addCriterion("dly >=", value, "dly");
            return (Criteria) this;
        }

        public Criteria andDlyLessThan(String value) {
            addCriterion("dly <", value, "dly");
            return (Criteria) this;
        }

        public Criteria andDlyLessThanOrEqualTo(String value) {
            addCriterion("dly <=", value, "dly");
            return (Criteria) this;
        }

        public Criteria andDlyLike(String value) {
            addCriterion("dly like", value, "dly");
            return (Criteria) this;
        }

        public Criteria andDlyNotLike(String value) {
            addCriterion("dly not like", value, "dly");
            return (Criteria) this;
        }

        public Criteria andDlyIn(List<String> values) {
            addCriterion("dly in", values, "dly");
            return (Criteria) this;
        }

        public Criteria andDlyNotIn(List<String> values) {
            addCriterion("dly not in", values, "dly");
            return (Criteria) this;
        }

        public Criteria andDlyBetween(String value1, String value2) {
            addCriterion("dly between", value1, value2, "dly");
            return (Criteria) this;
        }

        public Criteria andDlyNotBetween(String value1, String value2) {
            addCriterion("dly not between", value1, value2, "dly");
            return (Criteria) this;
        }

        public Criteria andBhyIsNull() {
            addCriterion("bhy is null");
            return (Criteria) this;
        }

        public Criteria andBhyIsNotNull() {
            addCriterion("bhy is not null");
            return (Criteria) this;
        }

        public Criteria andBhyEqualTo(String value) {
            addCriterion("bhy =", value, "bhy");
            return (Criteria) this;
        }

        public Criteria andBhyNotEqualTo(String value) {
            addCriterion("bhy <>", value, "bhy");
            return (Criteria) this;
        }

        public Criteria andBhyGreaterThan(String value) {
            addCriterion("bhy >", value, "bhy");
            return (Criteria) this;
        }

        public Criteria andBhyGreaterThanOrEqualTo(String value) {
            addCriterion("bhy >=", value, "bhy");
            return (Criteria) this;
        }

        public Criteria andBhyLessThan(String value) {
            addCriterion("bhy <", value, "bhy");
            return (Criteria) this;
        }

        public Criteria andBhyLessThanOrEqualTo(String value) {
            addCriterion("bhy <=", value, "bhy");
            return (Criteria) this;
        }

        public Criteria andBhyLike(String value) {
            addCriterion("bhy like", value, "bhy");
            return (Criteria) this;
        }

        public Criteria andBhyNotLike(String value) {
            addCriterion("bhy not like", value, "bhy");
            return (Criteria) this;
        }

        public Criteria andBhyIn(List<String> values) {
            addCriterion("bhy in", values, "bhy");
            return (Criteria) this;
        }

        public Criteria andBhyNotIn(List<String> values) {
            addCriterion("bhy not in", values, "bhy");
            return (Criteria) this;
        }

        public Criteria andBhyBetween(String value1, String value2) {
            addCriterion("bhy between", value1, value2, "bhy");
            return (Criteria) this;
        }

        public Criteria andBhyNotBetween(String value1, String value2) {
            addCriterion("bhy not between", value1, value2, "bhy");
            return (Criteria) this;
        }

        public Criteria andShyIsNull() {
            addCriterion("shy is null");
            return (Criteria) this;
        }

        public Criteria andShyIsNotNull() {
            addCriterion("shy is not null");
            return (Criteria) this;
        }

        public Criteria andShyEqualTo(String value) {
            addCriterion("shy =", value, "shy");
            return (Criteria) this;
        }

        public Criteria andShyNotEqualTo(String value) {
            addCriterion("shy <>", value, "shy");
            return (Criteria) this;
        }

        public Criteria andShyGreaterThan(String value) {
            addCriterion("shy >", value, "shy");
            return (Criteria) this;
        }

        public Criteria andShyGreaterThanOrEqualTo(String value) {
            addCriterion("shy >=", value, "shy");
            return (Criteria) this;
        }

        public Criteria andShyLessThan(String value) {
            addCriterion("shy <", value, "shy");
            return (Criteria) this;
        }

        public Criteria andShyLessThanOrEqualTo(String value) {
            addCriterion("shy <=", value, "shy");
            return (Criteria) this;
        }

        public Criteria andShyLike(String value) {
            addCriterion("shy like", value, "shy");
            return (Criteria) this;
        }

        public Criteria andShyNotLike(String value) {
            addCriterion("shy not like", value, "shy");
            return (Criteria) this;
        }

        public Criteria andShyIn(List<String> values) {
            addCriterion("shy in", values, "shy");
            return (Criteria) this;
        }

        public Criteria andShyNotIn(List<String> values) {
            addCriterion("shy not in", values, "shy");
            return (Criteria) this;
        }

        public Criteria andShyBetween(String value1, String value2) {
            addCriterion("shy between", value1, value2, "shy");
            return (Criteria) this;
        }

        public Criteria andShyNotBetween(String value1, String value2) {
            addCriterion("shy not between", value1, value2, "shy");
            return (Criteria) this;
        }

        public Criteria andAgyIsNull() {
            addCriterion("agy is null");
            return (Criteria) this;
        }

        public Criteria andAgyIsNotNull() {
            addCriterion("agy is not null");
            return (Criteria) this;
        }

        public Criteria andAgyEqualTo(String value) {
            addCriterion("agy =", value, "agy");
            return (Criteria) this;
        }

        public Criteria andAgyNotEqualTo(String value) {
            addCriterion("agy <>", value, "agy");
            return (Criteria) this;
        }

        public Criteria andAgyGreaterThan(String value) {
            addCriterion("agy >", value, "agy");
            return (Criteria) this;
        }

        public Criteria andAgyGreaterThanOrEqualTo(String value) {
            addCriterion("agy >=", value, "agy");
            return (Criteria) this;
        }

        public Criteria andAgyLessThan(String value) {
            addCriterion("agy <", value, "agy");
            return (Criteria) this;
        }

        public Criteria andAgyLessThanOrEqualTo(String value) {
            addCriterion("agy <=", value, "agy");
            return (Criteria) this;
        }

        public Criteria andAgyLike(String value) {
            addCriterion("agy like", value, "agy");
            return (Criteria) this;
        }

        public Criteria andAgyNotLike(String value) {
            addCriterion("agy not like", value, "agy");
            return (Criteria) this;
        }

        public Criteria andAgyIn(List<String> values) {
            addCriterion("agy in", values, "agy");
            return (Criteria) this;
        }

        public Criteria andAgyNotIn(List<String> values) {
            addCriterion("agy not in", values, "agy");
            return (Criteria) this;
        }

        public Criteria andAgyBetween(String value1, String value2) {
            addCriterion("agy between", value1, value2, "agy");
            return (Criteria) this;
        }

        public Criteria andAgyNotBetween(String value1, String value2) {
            addCriterion("agy not between", value1, value2, "agy");
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