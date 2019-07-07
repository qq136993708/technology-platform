package com.pcitc.base.stp.budget;

import java.util.ArrayList;
import java.util.List;

public class BudgetMoneyB2cExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BudgetMoneyB2cExample() {
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

        public Criteria andMcIsNull() {
            addCriterion("mc is null");
            return (Criteria) this;
        }

        public Criteria andMcIsNotNull() {
            addCriterion("mc is not null");
            return (Criteria) this;
        }

        public Criteria andMcEqualTo(String value) {
            addCriterion("mc =", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcNotEqualTo(String value) {
            addCriterion("mc <>", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcGreaterThan(String value) {
            addCriterion("mc >", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcGreaterThanOrEqualTo(String value) {
            addCriterion("mc >=", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcLessThan(String value) {
            addCriterion("mc <", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcLessThanOrEqualTo(String value) {
            addCriterion("mc <=", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcLike(String value) {
            addCriterion("mc like", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcNotLike(String value) {
            addCriterion("mc not like", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcIn(List<String> values) {
            addCriterion("mc in", values, "mc");
            return (Criteria) this;
        }

        public Criteria andMcNotIn(List<String> values) {
            addCriterion("mc not in", values, "mc");
            return (Criteria) this;
        }

        public Criteria andMcBetween(String value1, String value2) {
            addCriterion("mc between", value1, value2, "mc");
            return (Criteria) this;
        }

        public Criteria andMcNotBetween(String value1, String value2) {
            addCriterion("mc not between", value1, value2, "mc");
            return (Criteria) this;
        }

        public Criteria andLysybysIsNull() {
            addCriterion("lysybys is null");
            return (Criteria) this;
        }

        public Criteria andLysybysIsNotNull() {
            addCriterion("lysybys is not null");
            return (Criteria) this;
        }

        public Criteria andLysybysEqualTo(String value) {
            addCriterion("lysybys =", value, "lysybys");
            return (Criteria) this;
        }

        public Criteria andLysybysNotEqualTo(String value) {
            addCriterion("lysybys <>", value, "lysybys");
            return (Criteria) this;
        }

        public Criteria andLysybysGreaterThan(String value) {
            addCriterion("lysybys >", value, "lysybys");
            return (Criteria) this;
        }

        public Criteria andLysybysGreaterThanOrEqualTo(String value) {
            addCriterion("lysybys >=", value, "lysybys");
            return (Criteria) this;
        }

        public Criteria andLysybysLessThan(String value) {
            addCriterion("lysybys <", value, "lysybys");
            return (Criteria) this;
        }

        public Criteria andLysybysLessThanOrEqualTo(String value) {
            addCriterion("lysybys <=", value, "lysybys");
            return (Criteria) this;
        }

        public Criteria andLysybysLike(String value) {
            addCriterion("lysybys like", value, "lysybys");
            return (Criteria) this;
        }

        public Criteria andLysybysNotLike(String value) {
            addCriterion("lysybys not like", value, "lysybys");
            return (Criteria) this;
        }

        public Criteria andLysybysIn(List<String> values) {
            addCriterion("lysybys in", values, "lysybys");
            return (Criteria) this;
        }

        public Criteria andLysybysNotIn(List<String> values) {
            addCriterion("lysybys not in", values, "lysybys");
            return (Criteria) this;
        }

        public Criteria andLysybysBetween(String value1, String value2) {
            addCriterion("lysybys between", value1, value2, "lysybys");
            return (Criteria) this;
        }

        public Criteria andLysybysNotBetween(String value1, String value2) {
            addCriterion("lysybys not between", value1, value2, "lysybys");
            return (Criteria) this;
        }

        public Criteria andLysybjzIsNull() {
            addCriterion("lysybjz is null");
            return (Criteria) this;
        }

        public Criteria andLysybjzIsNotNull() {
            addCriterion("lysybjz is not null");
            return (Criteria) this;
        }

        public Criteria andLysybjzEqualTo(String value) {
            addCriterion("lysybjz =", value, "lysybjz");
            return (Criteria) this;
        }

        public Criteria andLysybjzNotEqualTo(String value) {
            addCriterion("lysybjz <>", value, "lysybjz");
            return (Criteria) this;
        }

        public Criteria andLysybjzGreaterThan(String value) {
            addCriterion("lysybjz >", value, "lysybjz");
            return (Criteria) this;
        }

        public Criteria andLysybjzGreaterThanOrEqualTo(String value) {
            addCriterion("lysybjz >=", value, "lysybjz");
            return (Criteria) this;
        }

        public Criteria andLysybjzLessThan(String value) {
            addCriterion("lysybjz <", value, "lysybjz");
            return (Criteria) this;
        }

        public Criteria andLysybjzLessThanOrEqualTo(String value) {
            addCriterion("lysybjz <=", value, "lysybjz");
            return (Criteria) this;
        }

        public Criteria andLysybjzLike(String value) {
            addCriterion("lysybjz like", value, "lysybjz");
            return (Criteria) this;
        }

        public Criteria andLysybjzNotLike(String value) {
            addCriterion("lysybjz not like", value, "lysybjz");
            return (Criteria) this;
        }

        public Criteria andLysybjzIn(List<String> values) {
            addCriterion("lysybjz in", values, "lysybjz");
            return (Criteria) this;
        }

        public Criteria andLysybjzNotIn(List<String> values) {
            addCriterion("lysybjz not in", values, "lysybjz");
            return (Criteria) this;
        }

        public Criteria andLysybjzBetween(String value1, String value2) {
            addCriterion("lysybjz between", value1, value2, "lysybjz");
            return (Criteria) this;
        }

        public Criteria andLysybjzNotBetween(String value1, String value2) {
            addCriterion("lysybjz not between", value1, value2, "lysybjz");
            return (Criteria) this;
        }

        public Criteria andLysybkxqIsNull() {
            addCriterion("lysybkxq is null");
            return (Criteria) this;
        }

        public Criteria andLysybkxqIsNotNull() {
            addCriterion("lysybkxq is not null");
            return (Criteria) this;
        }

        public Criteria andLysybkxqEqualTo(String value) {
            addCriterion("lysybkxq =", value, "lysybkxq");
            return (Criteria) this;
        }

        public Criteria andLysybkxqNotEqualTo(String value) {
            addCriterion("lysybkxq <>", value, "lysybkxq");
            return (Criteria) this;
        }

        public Criteria andLysybkxqGreaterThan(String value) {
            addCriterion("lysybkxq >", value, "lysybkxq");
            return (Criteria) this;
        }

        public Criteria andLysybkxqGreaterThanOrEqualTo(String value) {
            addCriterion("lysybkxq >=", value, "lysybkxq");
            return (Criteria) this;
        }

        public Criteria andLysybkxqLessThan(String value) {
            addCriterion("lysybkxq <", value, "lysybkxq");
            return (Criteria) this;
        }

        public Criteria andLysybkxqLessThanOrEqualTo(String value) {
            addCriterion("lysybkxq <=", value, "lysybkxq");
            return (Criteria) this;
        }

        public Criteria andLysybkxqLike(String value) {
            addCriterion("lysybkxq like", value, "lysybkxq");
            return (Criteria) this;
        }

        public Criteria andLysybkxqNotLike(String value) {
            addCriterion("lysybkxq not like", value, "lysybkxq");
            return (Criteria) this;
        }

        public Criteria andLysybkxqIn(List<String> values) {
            addCriterion("lysybkxq in", values, "lysybkxq");
            return (Criteria) this;
        }

        public Criteria andLysybkxqNotIn(List<String> values) {
            addCriterion("lysybkxq not in", values, "lysybkxq");
            return (Criteria) this;
        }

        public Criteria andLysybkxqBetween(String value1, String value2) {
            addCriterion("lysybkxq between", value1, value2, "lysybkxq");
            return (Criteria) this;
        }

        public Criteria andLysybkxqNotBetween(String value1, String value2) {
            addCriterion("lysybkxq not between", value1, value2, "lysybkxq");
            return (Criteria) this;
        }

        public Criteria andHgsybysIsNull() {
            addCriterion("hgsybys is null");
            return (Criteria) this;
        }

        public Criteria andHgsybysIsNotNull() {
            addCriterion("hgsybys is not null");
            return (Criteria) this;
        }

        public Criteria andHgsybysEqualTo(String value) {
            addCriterion("hgsybys =", value, "hgsybys");
            return (Criteria) this;
        }

        public Criteria andHgsybysNotEqualTo(String value) {
            addCriterion("hgsybys <>", value, "hgsybys");
            return (Criteria) this;
        }

        public Criteria andHgsybysGreaterThan(String value) {
            addCriterion("hgsybys >", value, "hgsybys");
            return (Criteria) this;
        }

        public Criteria andHgsybysGreaterThanOrEqualTo(String value) {
            addCriterion("hgsybys >=", value, "hgsybys");
            return (Criteria) this;
        }

        public Criteria andHgsybysLessThan(String value) {
            addCriterion("hgsybys <", value, "hgsybys");
            return (Criteria) this;
        }

        public Criteria andHgsybysLessThanOrEqualTo(String value) {
            addCriterion("hgsybys <=", value, "hgsybys");
            return (Criteria) this;
        }

        public Criteria andHgsybysLike(String value) {
            addCriterion("hgsybys like", value, "hgsybys");
            return (Criteria) this;
        }

        public Criteria andHgsybysNotLike(String value) {
            addCriterion("hgsybys not like", value, "hgsybys");
            return (Criteria) this;
        }

        public Criteria andHgsybysIn(List<String> values) {
            addCriterion("hgsybys in", values, "hgsybys");
            return (Criteria) this;
        }

        public Criteria andHgsybysNotIn(List<String> values) {
            addCriterion("hgsybys not in", values, "hgsybys");
            return (Criteria) this;
        }

        public Criteria andHgsybysBetween(String value1, String value2) {
            addCriterion("hgsybys between", value1, value2, "hgsybys");
            return (Criteria) this;
        }

        public Criteria andHgsybysNotBetween(String value1, String value2) {
            addCriterion("hgsybys not between", value1, value2, "hgsybys");
            return (Criteria) this;
        }

        public Criteria andHgsybjzIsNull() {
            addCriterion("hgsybjz is null");
            return (Criteria) this;
        }

        public Criteria andHgsybjzIsNotNull() {
            addCriterion("hgsybjz is not null");
            return (Criteria) this;
        }

        public Criteria andHgsybjzEqualTo(String value) {
            addCriterion("hgsybjz =", value, "hgsybjz");
            return (Criteria) this;
        }

        public Criteria andHgsybjzNotEqualTo(String value) {
            addCriterion("hgsybjz <>", value, "hgsybjz");
            return (Criteria) this;
        }

        public Criteria andHgsybjzGreaterThan(String value) {
            addCriterion("hgsybjz >", value, "hgsybjz");
            return (Criteria) this;
        }

        public Criteria andHgsybjzGreaterThanOrEqualTo(String value) {
            addCriterion("hgsybjz >=", value, "hgsybjz");
            return (Criteria) this;
        }

        public Criteria andHgsybjzLessThan(String value) {
            addCriterion("hgsybjz <", value, "hgsybjz");
            return (Criteria) this;
        }

        public Criteria andHgsybjzLessThanOrEqualTo(String value) {
            addCriterion("hgsybjz <=", value, "hgsybjz");
            return (Criteria) this;
        }

        public Criteria andHgsybjzLike(String value) {
            addCriterion("hgsybjz like", value, "hgsybjz");
            return (Criteria) this;
        }

        public Criteria andHgsybjzNotLike(String value) {
            addCriterion("hgsybjz not like", value, "hgsybjz");
            return (Criteria) this;
        }

        public Criteria andHgsybjzIn(List<String> values) {
            addCriterion("hgsybjz in", values, "hgsybjz");
            return (Criteria) this;
        }

        public Criteria andHgsybjzNotIn(List<String> values) {
            addCriterion("hgsybjz not in", values, "hgsybjz");
            return (Criteria) this;
        }

        public Criteria andHgsybjzBetween(String value1, String value2) {
            addCriterion("hgsybjz between", value1, value2, "hgsybjz");
            return (Criteria) this;
        }

        public Criteria andHgsybjzNotBetween(String value1, String value2) {
            addCriterion("hgsybjz not between", value1, value2, "hgsybjz");
            return (Criteria) this;
        }

        public Criteria andHgsybkxqIsNull() {
            addCriterion("hgsybkxq is null");
            return (Criteria) this;
        }

        public Criteria andHgsybkxqIsNotNull() {
            addCriterion("hgsybkxq is not null");
            return (Criteria) this;
        }

        public Criteria andHgsybkxqEqualTo(String value) {
            addCriterion("hgsybkxq =", value, "hgsybkxq");
            return (Criteria) this;
        }

        public Criteria andHgsybkxqNotEqualTo(String value) {
            addCriterion("hgsybkxq <>", value, "hgsybkxq");
            return (Criteria) this;
        }

        public Criteria andHgsybkxqGreaterThan(String value) {
            addCriterion("hgsybkxq >", value, "hgsybkxq");
            return (Criteria) this;
        }

        public Criteria andHgsybkxqGreaterThanOrEqualTo(String value) {
            addCriterion("hgsybkxq >=", value, "hgsybkxq");
            return (Criteria) this;
        }

        public Criteria andHgsybkxqLessThan(String value) {
            addCriterion("hgsybkxq <", value, "hgsybkxq");
            return (Criteria) this;
        }

        public Criteria andHgsybkxqLessThanOrEqualTo(String value) {
            addCriterion("hgsybkxq <=", value, "hgsybkxq");
            return (Criteria) this;
        }

        public Criteria andHgsybkxqLike(String value) {
            addCriterion("hgsybkxq like", value, "hgsybkxq");
            return (Criteria) this;
        }

        public Criteria andHgsybkxqNotLike(String value) {
            addCriterion("hgsybkxq not like", value, "hgsybkxq");
            return (Criteria) this;
        }

        public Criteria andHgsybkxqIn(List<String> values) {
            addCriterion("hgsybkxq in", values, "hgsybkxq");
            return (Criteria) this;
        }

        public Criteria andHgsybkxqNotIn(List<String> values) {
            addCriterion("hgsybkxq not in", values, "hgsybkxq");
            return (Criteria) this;
        }

        public Criteria andHgsybkxqBetween(String value1, String value2) {
            addCriterion("hgsybkxq between", value1, value2, "hgsybkxq");
            return (Criteria) this;
        }

        public Criteria andHgsybkxqNotBetween(String value1, String value2) {
            addCriterion("hgsybkxq not between", value1, value2, "hgsybkxq");
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