package com.pcitc.base.stp.budget;

import java.util.ArrayList;
import java.util.List;

public class BudgetMoneyGroupExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BudgetMoneyGroupExample() {
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

        public Criteria andJzxmjfbkyfIsNull() {
            addCriterion("jzxmjfbkyf is null");
            return (Criteria) this;
        }

        public Criteria andJzxmjfbkyfIsNotNull() {
            addCriterion("jzxmjfbkyf is not null");
            return (Criteria) this;
        }

        public Criteria andJzxmjfbkyfEqualTo(String value) {
            addCriterion("jzxmjfbkyf =", value, "jzxmjfbkyf");
            return (Criteria) this;
        }

        public Criteria andJzxmjfbkyfNotEqualTo(String value) {
            addCriterion("jzxmjfbkyf <>", value, "jzxmjfbkyf");
            return (Criteria) this;
        }

        public Criteria andJzxmjfbkyfGreaterThan(String value) {
            addCriterion("jzxmjfbkyf >", value, "jzxmjfbkyf");
            return (Criteria) this;
        }

        public Criteria andJzxmjfbkyfGreaterThanOrEqualTo(String value) {
            addCriterion("jzxmjfbkyf >=", value, "jzxmjfbkyf");
            return (Criteria) this;
        }

        public Criteria andJzxmjfbkyfLessThan(String value) {
            addCriterion("jzxmjfbkyf <", value, "jzxmjfbkyf");
            return (Criteria) this;
        }

        public Criteria andJzxmjfbkyfLessThanOrEqualTo(String value) {
            addCriterion("jzxmjfbkyf <=", value, "jzxmjfbkyf");
            return (Criteria) this;
        }

        public Criteria andJzxmjfbkyfLike(String value) {
            addCriterion("jzxmjfbkyf like", value, "jzxmjfbkyf");
            return (Criteria) this;
        }

        public Criteria andJzxmjfbkyfNotLike(String value) {
            addCriterion("jzxmjfbkyf not like", value, "jzxmjfbkyf");
            return (Criteria) this;
        }

        public Criteria andJzxmjfbkyfIn(List<String> values) {
            addCriterion("jzxmjfbkyf in", values, "jzxmjfbkyf");
            return (Criteria) this;
        }

        public Criteria andJzxmjfbkyfNotIn(List<String> values) {
            addCriterion("jzxmjfbkyf not in", values, "jzxmjfbkyf");
            return (Criteria) this;
        }

        public Criteria andJzxmjfbkyfBetween(String value1, String value2) {
            addCriterion("jzxmjfbkyf between", value1, value2, "jzxmjfbkyf");
            return (Criteria) this;
        }

        public Criteria andJzxmjfbkyfNotBetween(String value1, String value2) {
            addCriterion("jzxmjfbkyf not between", value1, value2, "jzxmjfbkyf");
            return (Criteria) this;
        }

        public Criteria andJzxmjfbkjxIsNull() {
            addCriterion("jzxmjfbkjx is null");
            return (Criteria) this;
        }

        public Criteria andJzxmjfbkjxIsNotNull() {
            addCriterion("jzxmjfbkjx is not null");
            return (Criteria) this;
        }

        public Criteria andJzxmjfbkjxEqualTo(String value) {
            addCriterion("jzxmjfbkjx =", value, "jzxmjfbkjx");
            return (Criteria) this;
        }

        public Criteria andJzxmjfbkjxNotEqualTo(String value) {
            addCriterion("jzxmjfbkjx <>", value, "jzxmjfbkjx");
            return (Criteria) this;
        }

        public Criteria andJzxmjfbkjxGreaterThan(String value) {
            addCriterion("jzxmjfbkjx >", value, "jzxmjfbkjx");
            return (Criteria) this;
        }

        public Criteria andJzxmjfbkjxGreaterThanOrEqualTo(String value) {
            addCriterion("jzxmjfbkjx >=", value, "jzxmjfbkjx");
            return (Criteria) this;
        }

        public Criteria andJzxmjfbkjxLessThan(String value) {
            addCriterion("jzxmjfbkjx <", value, "jzxmjfbkjx");
            return (Criteria) this;
        }

        public Criteria andJzxmjfbkjxLessThanOrEqualTo(String value) {
            addCriterion("jzxmjfbkjx <=", value, "jzxmjfbkjx");
            return (Criteria) this;
        }

        public Criteria andJzxmjfbkjxLike(String value) {
            addCriterion("jzxmjfbkjx like", value, "jzxmjfbkjx");
            return (Criteria) this;
        }

        public Criteria andJzxmjfbkjxNotLike(String value) {
            addCriterion("jzxmjfbkjx not like", value, "jzxmjfbkjx");
            return (Criteria) this;
        }

        public Criteria andJzxmjfbkjxIn(List<String> values) {
            addCriterion("jzxmjfbkjx in", values, "jzxmjfbkjx");
            return (Criteria) this;
        }

        public Criteria andJzxmjfbkjxNotIn(List<String> values) {
            addCriterion("jzxmjfbkjx not in", values, "jzxmjfbkjx");
            return (Criteria) this;
        }

        public Criteria andJzxmjfbkjxBetween(String value1, String value2) {
            addCriterion("jzxmjfbkjx between", value1, value2, "jzxmjfbkjx");
            return (Criteria) this;
        }

        public Criteria andJzxmjfbkjxNotBetween(String value1, String value2) {
            addCriterion("jzxmjfbkjx not between", value1, value2, "jzxmjfbkjx");
            return (Criteria) this;
        }

        public Criteria andJzxmjfqtIsNull() {
            addCriterion("jzxmjfqt is null");
            return (Criteria) this;
        }

        public Criteria andJzxmjfqtIsNotNull() {
            addCriterion("jzxmjfqt is not null");
            return (Criteria) this;
        }

        public Criteria andJzxmjfqtEqualTo(String value) {
            addCriterion("jzxmjfqt =", value, "jzxmjfqt");
            return (Criteria) this;
        }

        public Criteria andJzxmjfqtNotEqualTo(String value) {
            addCriterion("jzxmjfqt <>", value, "jzxmjfqt");
            return (Criteria) this;
        }

        public Criteria andJzxmjfqtGreaterThan(String value) {
            addCriterion("jzxmjfqt >", value, "jzxmjfqt");
            return (Criteria) this;
        }

        public Criteria andJzxmjfqtGreaterThanOrEqualTo(String value) {
            addCriterion("jzxmjfqt >=", value, "jzxmjfqt");
            return (Criteria) this;
        }

        public Criteria andJzxmjfqtLessThan(String value) {
            addCriterion("jzxmjfqt <", value, "jzxmjfqt");
            return (Criteria) this;
        }

        public Criteria andJzxmjfqtLessThanOrEqualTo(String value) {
            addCriterion("jzxmjfqt <=", value, "jzxmjfqt");
            return (Criteria) this;
        }

        public Criteria andJzxmjfqtLike(String value) {
            addCriterion("jzxmjfqt like", value, "jzxmjfqt");
            return (Criteria) this;
        }

        public Criteria andJzxmjfqtNotLike(String value) {
            addCriterion("jzxmjfqt not like", value, "jzxmjfqt");
            return (Criteria) this;
        }

        public Criteria andJzxmjfqtIn(List<String> values) {
            addCriterion("jzxmjfqt in", values, "jzxmjfqt");
            return (Criteria) this;
        }

        public Criteria andJzxmjfqtNotIn(List<String> values) {
            addCriterion("jzxmjfqt not in", values, "jzxmjfqt");
            return (Criteria) this;
        }

        public Criteria andJzxmjfqtBetween(String value1, String value2) {
            addCriterion("jzxmjfqt between", value1, value2, "jzxmjfqt");
            return (Criteria) this;
        }

        public Criteria andJzxmjfqtNotBetween(String value1, String value2) {
            addCriterion("jzxmjfqt not between", value1, value2, "jzxmjfqt");
            return (Criteria) this;
        }

        public Criteria andJzxmjfjhIsNull() {
            addCriterion("jzxmjfjh is null");
            return (Criteria) this;
        }

        public Criteria andJzxmjfjhIsNotNull() {
            addCriterion("jzxmjfjh is not null");
            return (Criteria) this;
        }

        public Criteria andJzxmjfjhEqualTo(String value) {
            addCriterion("jzxmjfjh =", value, "jzxmjfjh");
            return (Criteria) this;
        }

        public Criteria andJzxmjfjhNotEqualTo(String value) {
            addCriterion("jzxmjfjh <>", value, "jzxmjfjh");
            return (Criteria) this;
        }

        public Criteria andJzxmjfjhGreaterThan(String value) {
            addCriterion("jzxmjfjh >", value, "jzxmjfjh");
            return (Criteria) this;
        }

        public Criteria andJzxmjfjhGreaterThanOrEqualTo(String value) {
            addCriterion("jzxmjfjh >=", value, "jzxmjfjh");
            return (Criteria) this;
        }

        public Criteria andJzxmjfjhLessThan(String value) {
            addCriterion("jzxmjfjh <", value, "jzxmjfjh");
            return (Criteria) this;
        }

        public Criteria andJzxmjfjhLessThanOrEqualTo(String value) {
            addCriterion("jzxmjfjh <=", value, "jzxmjfjh");
            return (Criteria) this;
        }

        public Criteria andJzxmjfjhLike(String value) {
            addCriterion("jzxmjfjh like", value, "jzxmjfjh");
            return (Criteria) this;
        }

        public Criteria andJzxmjfjhNotLike(String value) {
            addCriterion("jzxmjfjh not like", value, "jzxmjfjh");
            return (Criteria) this;
        }

        public Criteria andJzxmjfjhIn(List<String> values) {
            addCriterion("jzxmjfjh in", values, "jzxmjfjh");
            return (Criteria) this;
        }

        public Criteria andJzxmjfjhNotIn(List<String> values) {
            addCriterion("jzxmjfjh not in", values, "jzxmjfjh");
            return (Criteria) this;
        }

        public Criteria andJzxmjfjhBetween(String value1, String value2) {
            addCriterion("jzxmjfjh between", value1, value2, "jzxmjfjh");
            return (Criteria) this;
        }

        public Criteria andJzxmjfjhNotBetween(String value1, String value2) {
            addCriterion("jzxmjfjh not between", value1, value2, "jzxmjfjh");
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

        public Criteria andXkxmjfbkyfIsNull() {
            addCriterion("xkxmjfbkyf is null");
            return (Criteria) this;
        }

        public Criteria andXkxmjfbkyfIsNotNull() {
            addCriterion("xkxmjfbkyf is not null");
            return (Criteria) this;
        }

        public Criteria andXkxmjfbkyfEqualTo(String value) {
            addCriterion("xkxmjfbkyf =", value, "xkxmjfbkyf");
            return (Criteria) this;
        }

        public Criteria andXkxmjfbkyfNotEqualTo(String value) {
            addCriterion("xkxmjfbkyf <>", value, "xkxmjfbkyf");
            return (Criteria) this;
        }

        public Criteria andXkxmjfbkyfGreaterThan(String value) {
            addCriterion("xkxmjfbkyf >", value, "xkxmjfbkyf");
            return (Criteria) this;
        }

        public Criteria andXkxmjfbkyfGreaterThanOrEqualTo(String value) {
            addCriterion("xkxmjfbkyf >=", value, "xkxmjfbkyf");
            return (Criteria) this;
        }

        public Criteria andXkxmjfbkyfLessThan(String value) {
            addCriterion("xkxmjfbkyf <", value, "xkxmjfbkyf");
            return (Criteria) this;
        }

        public Criteria andXkxmjfbkyfLessThanOrEqualTo(String value) {
            addCriterion("xkxmjfbkyf <=", value, "xkxmjfbkyf");
            return (Criteria) this;
        }

        public Criteria andXkxmjfbkyfLike(String value) {
            addCriterion("xkxmjfbkyf like", value, "xkxmjfbkyf");
            return (Criteria) this;
        }

        public Criteria andXkxmjfbkyfNotLike(String value) {
            addCriterion("xkxmjfbkyf not like", value, "xkxmjfbkyf");
            return (Criteria) this;
        }

        public Criteria andXkxmjfbkyfIn(List<String> values) {
            addCriterion("xkxmjfbkyf in", values, "xkxmjfbkyf");
            return (Criteria) this;
        }

        public Criteria andXkxmjfbkyfNotIn(List<String> values) {
            addCriterion("xkxmjfbkyf not in", values, "xkxmjfbkyf");
            return (Criteria) this;
        }

        public Criteria andXkxmjfbkyfBetween(String value1, String value2) {
            addCriterion("xkxmjfbkyf between", value1, value2, "xkxmjfbkyf");
            return (Criteria) this;
        }

        public Criteria andXkxmjfbkyfNotBetween(String value1, String value2) {
            addCriterion("xkxmjfbkyf not between", value1, value2, "xkxmjfbkyf");
            return (Criteria) this;
        }

        public Criteria andXkxmjfbkjxIsNull() {
            addCriterion("xkxmjfbkjx is null");
            return (Criteria) this;
        }

        public Criteria andXkxmjfbkjxIsNotNull() {
            addCriterion("xkxmjfbkjx is not null");
            return (Criteria) this;
        }

        public Criteria andXkxmjfbkjxEqualTo(String value) {
            addCriterion("xkxmjfbkjx =", value, "xkxmjfbkjx");
            return (Criteria) this;
        }

        public Criteria andXkxmjfbkjxNotEqualTo(String value) {
            addCriterion("xkxmjfbkjx <>", value, "xkxmjfbkjx");
            return (Criteria) this;
        }

        public Criteria andXkxmjfbkjxGreaterThan(String value) {
            addCriterion("xkxmjfbkjx >", value, "xkxmjfbkjx");
            return (Criteria) this;
        }

        public Criteria andXkxmjfbkjxGreaterThanOrEqualTo(String value) {
            addCriterion("xkxmjfbkjx >=", value, "xkxmjfbkjx");
            return (Criteria) this;
        }

        public Criteria andXkxmjfbkjxLessThan(String value) {
            addCriterion("xkxmjfbkjx <", value, "xkxmjfbkjx");
            return (Criteria) this;
        }

        public Criteria andXkxmjfbkjxLessThanOrEqualTo(String value) {
            addCriterion("xkxmjfbkjx <=", value, "xkxmjfbkjx");
            return (Criteria) this;
        }

        public Criteria andXkxmjfbkjxLike(String value) {
            addCriterion("xkxmjfbkjx like", value, "xkxmjfbkjx");
            return (Criteria) this;
        }

        public Criteria andXkxmjfbkjxNotLike(String value) {
            addCriterion("xkxmjfbkjx not like", value, "xkxmjfbkjx");
            return (Criteria) this;
        }

        public Criteria andXkxmjfbkjxIn(List<String> values) {
            addCriterion("xkxmjfbkjx in", values, "xkxmjfbkjx");
            return (Criteria) this;
        }

        public Criteria andXkxmjfbkjxNotIn(List<String> values) {
            addCriterion("xkxmjfbkjx not in", values, "xkxmjfbkjx");
            return (Criteria) this;
        }

        public Criteria andXkxmjfbkjxBetween(String value1, String value2) {
            addCriterion("xkxmjfbkjx between", value1, value2, "xkxmjfbkjx");
            return (Criteria) this;
        }

        public Criteria andXkxmjfbkjxNotBetween(String value1, String value2) {
            addCriterion("xkxmjfbkjx not between", value1, value2, "xkxmjfbkjx");
            return (Criteria) this;
        }

        public Criteria andXkxmjfqtIsNull() {
            addCriterion("xkxmjfqt is null");
            return (Criteria) this;
        }

        public Criteria andXkxmjfqtIsNotNull() {
            addCriterion("xkxmjfqt is not null");
            return (Criteria) this;
        }

        public Criteria andXkxmjfqtEqualTo(String value) {
            addCriterion("xkxmjfqt =", value, "xkxmjfqt");
            return (Criteria) this;
        }

        public Criteria andXkxmjfqtNotEqualTo(String value) {
            addCriterion("xkxmjfqt <>", value, "xkxmjfqt");
            return (Criteria) this;
        }

        public Criteria andXkxmjfqtGreaterThan(String value) {
            addCriterion("xkxmjfqt >", value, "xkxmjfqt");
            return (Criteria) this;
        }

        public Criteria andXkxmjfqtGreaterThanOrEqualTo(String value) {
            addCriterion("xkxmjfqt >=", value, "xkxmjfqt");
            return (Criteria) this;
        }

        public Criteria andXkxmjfqtLessThan(String value) {
            addCriterion("xkxmjfqt <", value, "xkxmjfqt");
            return (Criteria) this;
        }

        public Criteria andXkxmjfqtLessThanOrEqualTo(String value) {
            addCriterion("xkxmjfqt <=", value, "xkxmjfqt");
            return (Criteria) this;
        }

        public Criteria andXkxmjfqtLike(String value) {
            addCriterion("xkxmjfqt like", value, "xkxmjfqt");
            return (Criteria) this;
        }

        public Criteria andXkxmjfqtNotLike(String value) {
            addCriterion("xkxmjfqt not like", value, "xkxmjfqt");
            return (Criteria) this;
        }

        public Criteria andXkxmjfqtIn(List<String> values) {
            addCriterion("xkxmjfqt in", values, "xkxmjfqt");
            return (Criteria) this;
        }

        public Criteria andXkxmjfqtNotIn(List<String> values) {
            addCriterion("xkxmjfqt not in", values, "xkxmjfqt");
            return (Criteria) this;
        }

        public Criteria andXkxmjfqtBetween(String value1, String value2) {
            addCriterion("xkxmjfqt between", value1, value2, "xkxmjfqt");
            return (Criteria) this;
        }

        public Criteria andXkxmjfqtNotBetween(String value1, String value2) {
            addCriterion("xkxmjfqt not between", value1, value2, "xkxmjfqt");
            return (Criteria) this;
        }

        public Criteria andXkxmjfjhIsNull() {
            addCriterion("xkxmjfjh is null");
            return (Criteria) this;
        }

        public Criteria andXkxmjfjhIsNotNull() {
            addCriterion("xkxmjfjh is not null");
            return (Criteria) this;
        }

        public Criteria andXkxmjfjhEqualTo(String value) {
            addCriterion("xkxmjfjh =", value, "xkxmjfjh");
            return (Criteria) this;
        }

        public Criteria andXkxmjfjhNotEqualTo(String value) {
            addCriterion("xkxmjfjh <>", value, "xkxmjfjh");
            return (Criteria) this;
        }

        public Criteria andXkxmjfjhGreaterThan(String value) {
            addCriterion("xkxmjfjh >", value, "xkxmjfjh");
            return (Criteria) this;
        }

        public Criteria andXkxmjfjhGreaterThanOrEqualTo(String value) {
            addCriterion("xkxmjfjh >=", value, "xkxmjfjh");
            return (Criteria) this;
        }

        public Criteria andXkxmjfjhLessThan(String value) {
            addCriterion("xkxmjfjh <", value, "xkxmjfjh");
            return (Criteria) this;
        }

        public Criteria andXkxmjfjhLessThanOrEqualTo(String value) {
            addCriterion("xkxmjfjh <=", value, "xkxmjfjh");
            return (Criteria) this;
        }

        public Criteria andXkxmjfjhLike(String value) {
            addCriterion("xkxmjfjh like", value, "xkxmjfjh");
            return (Criteria) this;
        }

        public Criteria andXkxmjfjhNotLike(String value) {
            addCriterion("xkxmjfjh not like", value, "xkxmjfjh");
            return (Criteria) this;
        }

        public Criteria andXkxmjfjhIn(List<String> values) {
            addCriterion("xkxmjfjh in", values, "xkxmjfjh");
            return (Criteria) this;
        }

        public Criteria andXkxmjfjhNotIn(List<String> values) {
            addCriterion("xkxmjfjh not in", values, "xkxmjfjh");
            return (Criteria) this;
        }

        public Criteria andXkxmjfjhBetween(String value1, String value2) {
            addCriterion("xkxmjfjh between", value1, value2, "xkxmjfjh");
            return (Criteria) this;
        }

        public Criteria andXkxmjfjhNotBetween(String value1, String value2) {
            addCriterion("xkxmjfjh not between", value1, value2, "xkxmjfjh");
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