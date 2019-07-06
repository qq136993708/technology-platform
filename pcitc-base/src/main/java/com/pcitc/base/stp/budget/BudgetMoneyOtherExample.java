package com.pcitc.base.stp.budget;

import java.util.ArrayList;
import java.util.List;

public class BudgetMoneyOtherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BudgetMoneyOtherExample() {
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

        public Criteria andCbIsNull() {
            addCriterion("cb is null");
            return (Criteria) this;
        }

        public Criteria andCbIsNotNull() {
            addCriterion("cb is not null");
            return (Criteria) this;
        }

        public Criteria andCbEqualTo(String value) {
            addCriterion("cb =", value, "cb");
            return (Criteria) this;
        }

        public Criteria andCbNotEqualTo(String value) {
            addCriterion("cb <>", value, "cb");
            return (Criteria) this;
        }

        public Criteria andCbGreaterThan(String value) {
            addCriterion("cb >", value, "cb");
            return (Criteria) this;
        }

        public Criteria andCbGreaterThanOrEqualTo(String value) {
            addCriterion("cb >=", value, "cb");
            return (Criteria) this;
        }

        public Criteria andCbLessThan(String value) {
            addCriterion("cb <", value, "cb");
            return (Criteria) this;
        }

        public Criteria andCbLessThanOrEqualTo(String value) {
            addCriterion("cb <=", value, "cb");
            return (Criteria) this;
        }

        public Criteria andCbLike(String value) {
            addCriterion("cb like", value, "cb");
            return (Criteria) this;
        }

        public Criteria andCbNotLike(String value) {
            addCriterion("cb not like", value, "cb");
            return (Criteria) this;
        }

        public Criteria andCbIn(List<String> values) {
            addCriterion("cb in", values, "cb");
            return (Criteria) this;
        }

        public Criteria andCbNotIn(List<String> values) {
            addCriterion("cb not in", values, "cb");
            return (Criteria) this;
        }

        public Criteria andCbBetween(String value1, String value2) {
            addCriterion("cb between", value1, value2, "cb");
            return (Criteria) this;
        }

        public Criteria andCbNotBetween(String value1, String value2) {
            addCriterion("cb not between", value1, value2, "cb");
            return (Criteria) this;
        }

        public Criteria andGffjtysIsNull() {
            addCriterion("gffjtys is null");
            return (Criteria) this;
        }

        public Criteria andGffjtysIsNotNull() {
            addCriterion("gffjtys is not null");
            return (Criteria) this;
        }

        public Criteria andGffjtysEqualTo(String value) {
            addCriterion("gffjtys =", value, "gffjtys");
            return (Criteria) this;
        }

        public Criteria andGffjtysNotEqualTo(String value) {
            addCriterion("gffjtys <>", value, "gffjtys");
            return (Criteria) this;
        }

        public Criteria andGffjtysGreaterThan(String value) {
            addCriterion("gffjtys >", value, "gffjtys");
            return (Criteria) this;
        }

        public Criteria andGffjtysGreaterThanOrEqualTo(String value) {
            addCriterion("gffjtys >=", value, "gffjtys");
            return (Criteria) this;
        }

        public Criteria andGffjtysLessThan(String value) {
            addCriterion("gffjtys <", value, "gffjtys");
            return (Criteria) this;
        }

        public Criteria andGffjtysLessThanOrEqualTo(String value) {
            addCriterion("gffjtys <=", value, "gffjtys");
            return (Criteria) this;
        }

        public Criteria andGffjtysLike(String value) {
            addCriterion("gffjtys like", value, "gffjtys");
            return (Criteria) this;
        }

        public Criteria andGffjtysNotLike(String value) {
            addCriterion("gffjtys not like", value, "gffjtys");
            return (Criteria) this;
        }

        public Criteria andGffjtysIn(List<String> values) {
            addCriterion("gffjtys in", values, "gffjtys");
            return (Criteria) this;
        }

        public Criteria andGffjtysNotIn(List<String> values) {
            addCriterion("gffjtys not in", values, "gffjtys");
            return (Criteria) this;
        }

        public Criteria andGffjtysBetween(String value1, String value2) {
            addCriterion("gffjtys between", value1, value2, "gffjtys");
            return (Criteria) this;
        }

        public Criteria andGffjtysNotBetween(String value1, String value2) {
            addCriterion("gffjtys not between", value1, value2, "gffjtys");
            return (Criteria) this;
        }

        public Criteria andGffjtlhtIsNull() {
            addCriterion("gffjtlht is null");
            return (Criteria) this;
        }

        public Criteria andGffjtlhtIsNotNull() {
            addCriterion("gffjtlht is not null");
            return (Criteria) this;
        }

        public Criteria andGffjtlhtEqualTo(String value) {
            addCriterion("gffjtlht =", value, "gffjtlht");
            return (Criteria) this;
        }

        public Criteria andGffjtlhtNotEqualTo(String value) {
            addCriterion("gffjtlht <>", value, "gffjtlht");
            return (Criteria) this;
        }

        public Criteria andGffjtlhtGreaterThan(String value) {
            addCriterion("gffjtlht >", value, "gffjtlht");
            return (Criteria) this;
        }

        public Criteria andGffjtlhtGreaterThanOrEqualTo(String value) {
            addCriterion("gffjtlht >=", value, "gffjtlht");
            return (Criteria) this;
        }

        public Criteria andGffjtlhtLessThan(String value) {
            addCriterion("gffjtlht <", value, "gffjtlht");
            return (Criteria) this;
        }

        public Criteria andGffjtlhtLessThanOrEqualTo(String value) {
            addCriterion("gffjtlht <=", value, "gffjtlht");
            return (Criteria) this;
        }

        public Criteria andGffjtlhtLike(String value) {
            addCriterion("gffjtlht like", value, "gffjtlht");
            return (Criteria) this;
        }

        public Criteria andGffjtlhtNotLike(String value) {
            addCriterion("gffjtlht not like", value, "gffjtlht");
            return (Criteria) this;
        }

        public Criteria andGffjtlhtIn(List<String> values) {
            addCriterion("gffjtlht in", values, "gffjtlht");
            return (Criteria) this;
        }

        public Criteria andGffjtlhtNotIn(List<String> values) {
            addCriterion("gffjtlht not in", values, "gffjtlht");
            return (Criteria) this;
        }

        public Criteria andGffjtlhtBetween(String value1, String value2) {
            addCriterion("gffjtlht between", value1, value2, "gffjtlht");
            return (Criteria) this;
        }

        public Criteria andGffjtlhtNotBetween(String value1, String value2) {
            addCriterion("gffjtlht not between", value1, value2, "gffjtlht");
            return (Criteria) this;
        }

        public Criteria andGffjtkxqIsNull() {
            addCriterion("gffjtkxq is null");
            return (Criteria) this;
        }

        public Criteria andGffjtkxqIsNotNull() {
            addCriterion("gffjtkxq is not null");
            return (Criteria) this;
        }

        public Criteria andGffjtkxqEqualTo(String value) {
            addCriterion("gffjtkxq =", value, "gffjtkxq");
            return (Criteria) this;
        }

        public Criteria andGffjtkxqNotEqualTo(String value) {
            addCriterion("gffjtkxq <>", value, "gffjtkxq");
            return (Criteria) this;
        }

        public Criteria andGffjtkxqGreaterThan(String value) {
            addCriterion("gffjtkxq >", value, "gffjtkxq");
            return (Criteria) this;
        }

        public Criteria andGffjtkxqGreaterThanOrEqualTo(String value) {
            addCriterion("gffjtkxq >=", value, "gffjtkxq");
            return (Criteria) this;
        }

        public Criteria andGffjtkxqLessThan(String value) {
            addCriterion("gffjtkxq <", value, "gffjtkxq");
            return (Criteria) this;
        }

        public Criteria andGffjtkxqLessThanOrEqualTo(String value) {
            addCriterion("gffjtkxq <=", value, "gffjtkxq");
            return (Criteria) this;
        }

        public Criteria andGffjtkxqLike(String value) {
            addCriterion("gffjtkxq like", value, "gffjtkxq");
            return (Criteria) this;
        }

        public Criteria andGffjtkxqNotLike(String value) {
            addCriterion("gffjtkxq not like", value, "gffjtkxq");
            return (Criteria) this;
        }

        public Criteria andGffjtkxqIn(List<String> values) {
            addCriterion("gffjtkxq in", values, "gffjtkxq");
            return (Criteria) this;
        }

        public Criteria andGffjtkxqNotIn(List<String> values) {
            addCriterion("gffjtkxq not in", values, "gffjtkxq");
            return (Criteria) this;
        }

        public Criteria andGffjtkxqBetween(String value1, String value2) {
            addCriterion("gffjtkxq between", value1, value2, "gffjtkxq");
            return (Criteria) this;
        }

        public Criteria andGffjtkxqNotBetween(String value1, String value2) {
            addCriterion("gffjtkxq not between", value1, value2, "gffjtkxq");
            return (Criteria) this;
        }

        public Criteria andGffxtwysIsNull() {
            addCriterion("gffxtwys is null");
            return (Criteria) this;
        }

        public Criteria andGffxtwysIsNotNull() {
            addCriterion("gffxtwys is not null");
            return (Criteria) this;
        }

        public Criteria andGffxtwysEqualTo(String value) {
            addCriterion("gffxtwys =", value, "gffxtwys");
            return (Criteria) this;
        }

        public Criteria andGffxtwysNotEqualTo(String value) {
            addCriterion("gffxtwys <>", value, "gffxtwys");
            return (Criteria) this;
        }

        public Criteria andGffxtwysGreaterThan(String value) {
            addCriterion("gffxtwys >", value, "gffxtwys");
            return (Criteria) this;
        }

        public Criteria andGffxtwysGreaterThanOrEqualTo(String value) {
            addCriterion("gffxtwys >=", value, "gffxtwys");
            return (Criteria) this;
        }

        public Criteria andGffxtwysLessThan(String value) {
            addCriterion("gffxtwys <", value, "gffxtwys");
            return (Criteria) this;
        }

        public Criteria andGffxtwysLessThanOrEqualTo(String value) {
            addCriterion("gffxtwys <=", value, "gffxtwys");
            return (Criteria) this;
        }

        public Criteria andGffxtwysLike(String value) {
            addCriterion("gffxtwys like", value, "gffxtwys");
            return (Criteria) this;
        }

        public Criteria andGffxtwysNotLike(String value) {
            addCriterion("gffxtwys not like", value, "gffxtwys");
            return (Criteria) this;
        }

        public Criteria andGffxtwysIn(List<String> values) {
            addCriterion("gffxtwys in", values, "gffxtwys");
            return (Criteria) this;
        }

        public Criteria andGffxtwysNotIn(List<String> values) {
            addCriterion("gffxtwys not in", values, "gffxtwys");
            return (Criteria) this;
        }

        public Criteria andGffxtwysBetween(String value1, String value2) {
            addCriterion("gffxtwys between", value1, value2, "gffxtwys");
            return (Criteria) this;
        }

        public Criteria andGffxtwysNotBetween(String value1, String value2) {
            addCriterion("gffxtwys not between", value1, value2, "gffxtwys");
            return (Criteria) this;
        }

        public Criteria andGffxtwlhtIsNull() {
            addCriterion("gffxtwlht is null");
            return (Criteria) this;
        }

        public Criteria andGffxtwlhtIsNotNull() {
            addCriterion("gffxtwlht is not null");
            return (Criteria) this;
        }

        public Criteria andGffxtwlhtEqualTo(String value) {
            addCriterion("gffxtwlht =", value, "gffxtwlht");
            return (Criteria) this;
        }

        public Criteria andGffxtwlhtNotEqualTo(String value) {
            addCriterion("gffxtwlht <>", value, "gffxtwlht");
            return (Criteria) this;
        }

        public Criteria andGffxtwlhtGreaterThan(String value) {
            addCriterion("gffxtwlht >", value, "gffxtwlht");
            return (Criteria) this;
        }

        public Criteria andGffxtwlhtGreaterThanOrEqualTo(String value) {
            addCriterion("gffxtwlht >=", value, "gffxtwlht");
            return (Criteria) this;
        }

        public Criteria andGffxtwlhtLessThan(String value) {
            addCriterion("gffxtwlht <", value, "gffxtwlht");
            return (Criteria) this;
        }

        public Criteria andGffxtwlhtLessThanOrEqualTo(String value) {
            addCriterion("gffxtwlht <=", value, "gffxtwlht");
            return (Criteria) this;
        }

        public Criteria andGffxtwlhtLike(String value) {
            addCriterion("gffxtwlht like", value, "gffxtwlht");
            return (Criteria) this;
        }

        public Criteria andGffxtwlhtNotLike(String value) {
            addCriterion("gffxtwlht not like", value, "gffxtwlht");
            return (Criteria) this;
        }

        public Criteria andGffxtwlhtIn(List<String> values) {
            addCriterion("gffxtwlht in", values, "gffxtwlht");
            return (Criteria) this;
        }

        public Criteria andGffxtwlhtNotIn(List<String> values) {
            addCriterion("gffxtwlht not in", values, "gffxtwlht");
            return (Criteria) this;
        }

        public Criteria andGffxtwlhtBetween(String value1, String value2) {
            addCriterion("gffxtwlht between", value1, value2, "gffxtwlht");
            return (Criteria) this;
        }

        public Criteria andGffxtwlhtNotBetween(String value1, String value2) {
            addCriterion("gffxtwlht not between", value1, value2, "gffxtwlht");
            return (Criteria) this;
        }

        public Criteria andGffxtwkxqIsNull() {
            addCriterion("gffxtwkxq is null");
            return (Criteria) this;
        }

        public Criteria andGffxtwkxqIsNotNull() {
            addCriterion("gffxtwkxq is not null");
            return (Criteria) this;
        }

        public Criteria andGffxtwkxqEqualTo(String value) {
            addCriterion("gffxtwkxq =", value, "gffxtwkxq");
            return (Criteria) this;
        }

        public Criteria andGffxtwkxqNotEqualTo(String value) {
            addCriterion("gffxtwkxq <>", value, "gffxtwkxq");
            return (Criteria) this;
        }

        public Criteria andGffxtwkxqGreaterThan(String value) {
            addCriterion("gffxtwkxq >", value, "gffxtwkxq");
            return (Criteria) this;
        }

        public Criteria andGffxtwkxqGreaterThanOrEqualTo(String value) {
            addCriterion("gffxtwkxq >=", value, "gffxtwkxq");
            return (Criteria) this;
        }

        public Criteria andGffxtwkxqLessThan(String value) {
            addCriterion("gffxtwkxq <", value, "gffxtwkxq");
            return (Criteria) this;
        }

        public Criteria andGffxtwkxqLessThanOrEqualTo(String value) {
            addCriterion("gffxtwkxq <=", value, "gffxtwkxq");
            return (Criteria) this;
        }

        public Criteria andGffxtwkxqLike(String value) {
            addCriterion("gffxtwkxq like", value, "gffxtwkxq");
            return (Criteria) this;
        }

        public Criteria andGffxtwkxqNotLike(String value) {
            addCriterion("gffxtwkxq not like", value, "gffxtwkxq");
            return (Criteria) this;
        }

        public Criteria andGffxtwkxqIn(List<String> values) {
            addCriterion("gffxtwkxq in", values, "gffxtwkxq");
            return (Criteria) this;
        }

        public Criteria andGffxtwkxqNotIn(List<String> values) {
            addCriterion("gffxtwkxq not in", values, "gffxtwkxq");
            return (Criteria) this;
        }

        public Criteria andGffxtwkxqBetween(String value1, String value2) {
            addCriterion("gffxtwkxq between", value1, value2, "gffxtwkxq");
            return (Criteria) this;
        }

        public Criteria andGffxtwkxqNotBetween(String value1, String value2) {
            addCriterion("gffxtwkxq not between", value1, value2, "gffxtwkxq");
            return (Criteria) this;
        }

        public Criteria andGffykysIsNull() {
            addCriterion("gffykys is null");
            return (Criteria) this;
        }

        public Criteria andGffykysIsNotNull() {
            addCriterion("gffykys is not null");
            return (Criteria) this;
        }

        public Criteria andGffykysEqualTo(String value) {
            addCriterion("gffykys =", value, "gffykys");
            return (Criteria) this;
        }

        public Criteria andGffykysNotEqualTo(String value) {
            addCriterion("gffykys <>", value, "gffykys");
            return (Criteria) this;
        }

        public Criteria andGffykysGreaterThan(String value) {
            addCriterion("gffykys >", value, "gffykys");
            return (Criteria) this;
        }

        public Criteria andGffykysGreaterThanOrEqualTo(String value) {
            addCriterion("gffykys >=", value, "gffykys");
            return (Criteria) this;
        }

        public Criteria andGffykysLessThan(String value) {
            addCriterion("gffykys <", value, "gffykys");
            return (Criteria) this;
        }

        public Criteria andGffykysLessThanOrEqualTo(String value) {
            addCriterion("gffykys <=", value, "gffykys");
            return (Criteria) this;
        }

        public Criteria andGffykysLike(String value) {
            addCriterion("gffykys like", value, "gffykys");
            return (Criteria) this;
        }

        public Criteria andGffykysNotLike(String value) {
            addCriterion("gffykys not like", value, "gffykys");
            return (Criteria) this;
        }

        public Criteria andGffykysIn(List<String> values) {
            addCriterion("gffykys in", values, "gffykys");
            return (Criteria) this;
        }

        public Criteria andGffykysNotIn(List<String> values) {
            addCriterion("gffykys not in", values, "gffykys");
            return (Criteria) this;
        }

        public Criteria andGffykysBetween(String value1, String value2) {
            addCriterion("gffykys between", value1, value2, "gffykys");
            return (Criteria) this;
        }

        public Criteria andGffykysNotBetween(String value1, String value2) {
            addCriterion("gffykys not between", value1, value2, "gffykys");
            return (Criteria) this;
        }

        public Criteria andGffyklhtIsNull() {
            addCriterion("gffyklht is null");
            return (Criteria) this;
        }

        public Criteria andGffyklhtIsNotNull() {
            addCriterion("gffyklht is not null");
            return (Criteria) this;
        }

        public Criteria andGffyklhtEqualTo(String value) {
            addCriterion("gffyklht =", value, "gffyklht");
            return (Criteria) this;
        }

        public Criteria andGffyklhtNotEqualTo(String value) {
            addCriterion("gffyklht <>", value, "gffyklht");
            return (Criteria) this;
        }

        public Criteria andGffyklhtGreaterThan(String value) {
            addCriterion("gffyklht >", value, "gffyklht");
            return (Criteria) this;
        }

        public Criteria andGffyklhtGreaterThanOrEqualTo(String value) {
            addCriterion("gffyklht >=", value, "gffyklht");
            return (Criteria) this;
        }

        public Criteria andGffyklhtLessThan(String value) {
            addCriterion("gffyklht <", value, "gffyklht");
            return (Criteria) this;
        }

        public Criteria andGffyklhtLessThanOrEqualTo(String value) {
            addCriterion("gffyklht <=", value, "gffyklht");
            return (Criteria) this;
        }

        public Criteria andGffyklhtLike(String value) {
            addCriterion("gffyklht like", value, "gffyklht");
            return (Criteria) this;
        }

        public Criteria andGffyklhtNotLike(String value) {
            addCriterion("gffyklht not like", value, "gffyklht");
            return (Criteria) this;
        }

        public Criteria andGffyklhtIn(List<String> values) {
            addCriterion("gffyklht in", values, "gffyklht");
            return (Criteria) this;
        }

        public Criteria andGffyklhtNotIn(List<String> values) {
            addCriterion("gffyklht not in", values, "gffyklht");
            return (Criteria) this;
        }

        public Criteria andGffyklhtBetween(String value1, String value2) {
            addCriterion("gffyklht between", value1, value2, "gffyklht");
            return (Criteria) this;
        }

        public Criteria andGffyklhtNotBetween(String value1, String value2) {
            addCriterion("gffyklht not between", value1, value2, "gffyklht");
            return (Criteria) this;
        }

        public Criteria andGffykkxqIsNull() {
            addCriterion("gffykkxq is null");
            return (Criteria) this;
        }

        public Criteria andGffykkxqIsNotNull() {
            addCriterion("gffykkxq is not null");
            return (Criteria) this;
        }

        public Criteria andGffykkxqEqualTo(String value) {
            addCriterion("gffykkxq =", value, "gffykkxq");
            return (Criteria) this;
        }

        public Criteria andGffykkxqNotEqualTo(String value) {
            addCriterion("gffykkxq <>", value, "gffykkxq");
            return (Criteria) this;
        }

        public Criteria andGffykkxqGreaterThan(String value) {
            addCriterion("gffykkxq >", value, "gffykkxq");
            return (Criteria) this;
        }

        public Criteria andGffykkxqGreaterThanOrEqualTo(String value) {
            addCriterion("gffykkxq >=", value, "gffykkxq");
            return (Criteria) this;
        }

        public Criteria andGffykkxqLessThan(String value) {
            addCriterion("gffykkxq <", value, "gffykkxq");
            return (Criteria) this;
        }

        public Criteria andGffykkxqLessThanOrEqualTo(String value) {
            addCriterion("gffykkxq <=", value, "gffykkxq");
            return (Criteria) this;
        }

        public Criteria andGffykkxqLike(String value) {
            addCriterion("gffykkxq like", value, "gffykkxq");
            return (Criteria) this;
        }

        public Criteria andGffykkxqNotLike(String value) {
            addCriterion("gffykkxq not like", value, "gffykkxq");
            return (Criteria) this;
        }

        public Criteria andGffykkxqIn(List<String> values) {
            addCriterion("gffykkxq in", values, "gffykkxq");
            return (Criteria) this;
        }

        public Criteria andGffykkxqNotIn(List<String> values) {
            addCriterion("gffykkxq not in", values, "gffykkxq");
            return (Criteria) this;
        }

        public Criteria andGffykkxqBetween(String value1, String value2) {
            addCriterion("gffykkxq between", value1, value2, "gffykkxq");
            return (Criteria) this;
        }

        public Criteria andGffykkxqNotBetween(String value1, String value2) {
            addCriterion("gffykkxq not between", value1, value2, "gffykkxq");
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