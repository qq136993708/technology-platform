package com.pcitc.base.stp.budget;

import java.util.ArrayList;
import java.util.List;

public class BudgetMoneyDecomposeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BudgetMoneyDecomposeExample() {
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

        public Criteria andBudgetCodeIsNull() {
            addCriterion("budget_code is null");
            return (Criteria) this;
        }

        public Criteria andBudgetCodeIsNotNull() {
            addCriterion("budget_code is not null");
            return (Criteria) this;
        }

        public Criteria andBudgetCodeEqualTo(String value) {
            addCriterion("budget_code =", value, "budgetCode");
            return (Criteria) this;
        }

        public Criteria andBudgetCodeNotEqualTo(String value) {
            addCriterion("budget_code <>", value, "budgetCode");
            return (Criteria) this;
        }

        public Criteria andBudgetCodeGreaterThan(String value) {
            addCriterion("budget_code >", value, "budgetCode");
            return (Criteria) this;
        }

        public Criteria andBudgetCodeGreaterThanOrEqualTo(String value) {
            addCriterion("budget_code >=", value, "budgetCode");
            return (Criteria) this;
        }

        public Criteria andBudgetCodeLessThan(String value) {
            addCriterion("budget_code <", value, "budgetCode");
            return (Criteria) this;
        }

        public Criteria andBudgetCodeLessThanOrEqualTo(String value) {
            addCriterion("budget_code <=", value, "budgetCode");
            return (Criteria) this;
        }

        public Criteria andBudgetCodeLike(String value) {
            addCriterion("budget_code like", value, "budgetCode");
            return (Criteria) this;
        }

        public Criteria andBudgetCodeNotLike(String value) {
            addCriterion("budget_code not like", value, "budgetCode");
            return (Criteria) this;
        }

        public Criteria andBudgetCodeIn(List<String> values) {
            addCriterion("budget_code in", values, "budgetCode");
            return (Criteria) this;
        }

        public Criteria andBudgetCodeNotIn(List<String> values) {
            addCriterion("budget_code not in", values, "budgetCode");
            return (Criteria) this;
        }

        public Criteria andBudgetCodeBetween(String value1, String value2) {
            addCriterion("budget_code between", value1, value2, "budgetCode");
            return (Criteria) this;
        }

        public Criteria andBudgetCodeNotBetween(String value1, String value2) {
            addCriterion("budget_code not between", value1, value2, "budgetCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeIsNull() {
            addCriterion("unit_code is null");
            return (Criteria) this;
        }

        public Criteria andUnitCodeIsNotNull() {
            addCriterion("unit_code is not null");
            return (Criteria) this;
        }

        public Criteria andUnitCodeEqualTo(String value) {
            addCriterion("unit_code =", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeNotEqualTo(String value) {
            addCriterion("unit_code <>", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeGreaterThan(String value) {
            addCriterion("unit_code >", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeGreaterThanOrEqualTo(String value) {
            addCriterion("unit_code >=", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeLessThan(String value) {
            addCriterion("unit_code <", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeLessThanOrEqualTo(String value) {
            addCriterion("unit_code <=", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeLike(String value) {
            addCriterion("unit_code like", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeNotLike(String value) {
            addCriterion("unit_code not like", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeIn(List<String> values) {
            addCriterion("unit_code in", values, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeNotIn(List<String> values) {
            addCriterion("unit_code not in", values, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeBetween(String value1, String value2) {
            addCriterion("unit_code between", value1, value2, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeNotBetween(String value1, String value2) {
            addCriterion("unit_code not between", value1, value2, "unitCode");
            return (Criteria) this;
        }

        public Criteria andJfyszjysIsNull() {
            addCriterion("jfyszjys is null");
            return (Criteria) this;
        }

        public Criteria andJfyszjysIsNotNull() {
            addCriterion("jfyszjys is not null");
            return (Criteria) this;
        }

        public Criteria andJfyszjysEqualTo(String value) {
            addCriterion("jfyszjys =", value, "jfyszjys");
            return (Criteria) this;
        }

        public Criteria andJfyszjysNotEqualTo(String value) {
            addCriterion("jfyszjys <>", value, "jfyszjys");
            return (Criteria) this;
        }

        public Criteria andJfyszjysGreaterThan(String value) {
            addCriterion("jfyszjys >", value, "jfyszjys");
            return (Criteria) this;
        }

        public Criteria andJfyszjysGreaterThanOrEqualTo(String value) {
            addCriterion("jfyszjys >=", value, "jfyszjys");
            return (Criteria) this;
        }

        public Criteria andJfyszjysLessThan(String value) {
            addCriterion("jfyszjys <", value, "jfyszjys");
            return (Criteria) this;
        }

        public Criteria andJfyszjysLessThanOrEqualTo(String value) {
            addCriterion("jfyszjys <=", value, "jfyszjys");
            return (Criteria) this;
        }

        public Criteria andJfyszjysLike(String value) {
            addCriterion("jfyszjys like", value, "jfyszjys");
            return (Criteria) this;
        }

        public Criteria andJfyszjysNotLike(String value) {
            addCriterion("jfyszjys not like", value, "jfyszjys");
            return (Criteria) this;
        }

        public Criteria andJfyszjysIn(List<String> values) {
            addCriterion("jfyszjys in", values, "jfyszjys");
            return (Criteria) this;
        }

        public Criteria andJfyszjysNotIn(List<String> values) {
            addCriterion("jfyszjys not in", values, "jfyszjys");
            return (Criteria) this;
        }

        public Criteria andJfyszjysBetween(String value1, String value2) {
            addCriterion("jfyszjys between", value1, value2, "jfyszjys");
            return (Criteria) this;
        }

        public Criteria andJfyszjysNotBetween(String value1, String value2) {
            addCriterion("jfyszjys not between", value1, value2, "jfyszjys");
            return (Criteria) this;
        }

        public Criteria andJfyszjlhtIsNull() {
            addCriterion("jfyszjlht is null");
            return (Criteria) this;
        }

        public Criteria andJfyszjlhtIsNotNull() {
            addCriterion("jfyszjlht is not null");
            return (Criteria) this;
        }

        public Criteria andJfyszjlhtEqualTo(String value) {
            addCriterion("jfyszjlht =", value, "jfyszjlht");
            return (Criteria) this;
        }

        public Criteria andJfyszjlhtNotEqualTo(String value) {
            addCriterion("jfyszjlht <>", value, "jfyszjlht");
            return (Criteria) this;
        }

        public Criteria andJfyszjlhtGreaterThan(String value) {
            addCriterion("jfyszjlht >", value, "jfyszjlht");
            return (Criteria) this;
        }

        public Criteria andJfyszjlhtGreaterThanOrEqualTo(String value) {
            addCriterion("jfyszjlht >=", value, "jfyszjlht");
            return (Criteria) this;
        }

        public Criteria andJfyszjlhtLessThan(String value) {
            addCriterion("jfyszjlht <", value, "jfyszjlht");
            return (Criteria) this;
        }

        public Criteria andJfyszjlhtLessThanOrEqualTo(String value) {
            addCriterion("jfyszjlht <=", value, "jfyszjlht");
            return (Criteria) this;
        }

        public Criteria andJfyszjlhtLike(String value) {
            addCriterion("jfyszjlht like", value, "jfyszjlht");
            return (Criteria) this;
        }

        public Criteria andJfyszjlhtNotLike(String value) {
            addCriterion("jfyszjlht not like", value, "jfyszjlht");
            return (Criteria) this;
        }

        public Criteria andJfyszjlhtIn(List<String> values) {
            addCriterion("jfyszjlht in", values, "jfyszjlht");
            return (Criteria) this;
        }

        public Criteria andJfyszjlhtNotIn(List<String> values) {
            addCriterion("jfyszjlht not in", values, "jfyszjlht");
            return (Criteria) this;
        }

        public Criteria andJfyszjlhtBetween(String value1, String value2) {
            addCriterion("jfyszjlht between", value1, value2, "jfyszjlht");
            return (Criteria) this;
        }

        public Criteria andJfyszjlhtNotBetween(String value1, String value2) {
            addCriterion("jfyszjlht not between", value1, value2, "jfyszjlht");
            return (Criteria) this;
        }

        public Criteria andJfyszjxqIsNull() {
            addCriterion("jfyszjxq is null");
            return (Criteria) this;
        }

        public Criteria andJfyszjxqIsNotNull() {
            addCriterion("jfyszjxq is not null");
            return (Criteria) this;
        }

        public Criteria andJfyszjxqEqualTo(String value) {
            addCriterion("jfyszjxq =", value, "jfyszjxq");
            return (Criteria) this;
        }

        public Criteria andJfyszjxqNotEqualTo(String value) {
            addCriterion("jfyszjxq <>", value, "jfyszjxq");
            return (Criteria) this;
        }

        public Criteria andJfyszjxqGreaterThan(String value) {
            addCriterion("jfyszjxq >", value, "jfyszjxq");
            return (Criteria) this;
        }

        public Criteria andJfyszjxqGreaterThanOrEqualTo(String value) {
            addCriterion("jfyszjxq >=", value, "jfyszjxq");
            return (Criteria) this;
        }

        public Criteria andJfyszjxqLessThan(String value) {
            addCriterion("jfyszjxq <", value, "jfyszjxq");
            return (Criteria) this;
        }

        public Criteria andJfyszjxqLessThanOrEqualTo(String value) {
            addCriterion("jfyszjxq <=", value, "jfyszjxq");
            return (Criteria) this;
        }

        public Criteria andJfyszjxqLike(String value) {
            addCriterion("jfyszjxq like", value, "jfyszjxq");
            return (Criteria) this;
        }

        public Criteria andJfyszjxqNotLike(String value) {
            addCriterion("jfyszjxq not like", value, "jfyszjxq");
            return (Criteria) this;
        }

        public Criteria andJfyszjxqIn(List<String> values) {
            addCriterion("jfyszjxq in", values, "jfyszjxq");
            return (Criteria) this;
        }

        public Criteria andJfyszjxqNotIn(List<String> values) {
            addCriterion("jfyszjxq not in", values, "jfyszjxq");
            return (Criteria) this;
        }

        public Criteria andJfyszjxqBetween(String value1, String value2) {
            addCriterion("jfyszjxq between", value1, value2, "jfyszjxq");
            return (Criteria) this;
        }

        public Criteria andJfyszjxqNotBetween(String value1, String value2) {
            addCriterion("jfyszjxq not between", value1, value2, "jfyszjxq");
            return (Criteria) this;
        }

        public Criteria andJtyshjysIsNull() {
            addCriterion("jtyshjys is null");
            return (Criteria) this;
        }

        public Criteria andJtyshjysIsNotNull() {
            addCriterion("jtyshjys is not null");
            return (Criteria) this;
        }

        public Criteria andJtyshjysEqualTo(String value) {
            addCriterion("jtyshjys =", value, "jtyshjys");
            return (Criteria) this;
        }

        public Criteria andJtyshjysNotEqualTo(String value) {
            addCriterion("jtyshjys <>", value, "jtyshjys");
            return (Criteria) this;
        }

        public Criteria andJtyshjysGreaterThan(String value) {
            addCriterion("jtyshjys >", value, "jtyshjys");
            return (Criteria) this;
        }

        public Criteria andJtyshjysGreaterThanOrEqualTo(String value) {
            addCriterion("jtyshjys >=", value, "jtyshjys");
            return (Criteria) this;
        }

        public Criteria andJtyshjysLessThan(String value) {
            addCriterion("jtyshjys <", value, "jtyshjys");
            return (Criteria) this;
        }

        public Criteria andJtyshjysLessThanOrEqualTo(String value) {
            addCriterion("jtyshjys <=", value, "jtyshjys");
            return (Criteria) this;
        }

        public Criteria andJtyshjysLike(String value) {
            addCriterion("jtyshjys like", value, "jtyshjys");
            return (Criteria) this;
        }

        public Criteria andJtyshjysNotLike(String value) {
            addCriterion("jtyshjys not like", value, "jtyshjys");
            return (Criteria) this;
        }

        public Criteria andJtyshjysIn(List<String> values) {
            addCriterion("jtyshjys in", values, "jtyshjys");
            return (Criteria) this;
        }

        public Criteria andJtyshjysNotIn(List<String> values) {
            addCriterion("jtyshjys not in", values, "jtyshjys");
            return (Criteria) this;
        }

        public Criteria andJtyshjysBetween(String value1, String value2) {
            addCriterion("jtyshjys between", value1, value2, "jtyshjys");
            return (Criteria) this;
        }

        public Criteria andJtyshjysNotBetween(String value1, String value2) {
            addCriterion("jtyshjys not between", value1, value2, "jtyshjys");
            return (Criteria) this;
        }

        public Criteria andJtyshjlhtIsNull() {
            addCriterion("jtyshjlht is null");
            return (Criteria) this;
        }

        public Criteria andJtyshjlhtIsNotNull() {
            addCriterion("jtyshjlht is not null");
            return (Criteria) this;
        }

        public Criteria andJtyshjlhtEqualTo(String value) {
            addCriterion("jtyshjlht =", value, "jtyshjlht");
            return (Criteria) this;
        }

        public Criteria andJtyshjlhtNotEqualTo(String value) {
            addCriterion("jtyshjlht <>", value, "jtyshjlht");
            return (Criteria) this;
        }

        public Criteria andJtyshjlhtGreaterThan(String value) {
            addCriterion("jtyshjlht >", value, "jtyshjlht");
            return (Criteria) this;
        }

        public Criteria andJtyshjlhtGreaterThanOrEqualTo(String value) {
            addCriterion("jtyshjlht >=", value, "jtyshjlht");
            return (Criteria) this;
        }

        public Criteria andJtyshjlhtLessThan(String value) {
            addCriterion("jtyshjlht <", value, "jtyshjlht");
            return (Criteria) this;
        }

        public Criteria andJtyshjlhtLessThanOrEqualTo(String value) {
            addCriterion("jtyshjlht <=", value, "jtyshjlht");
            return (Criteria) this;
        }

        public Criteria andJtyshjlhtLike(String value) {
            addCriterion("jtyshjlht like", value, "jtyshjlht");
            return (Criteria) this;
        }

        public Criteria andJtyshjlhtNotLike(String value) {
            addCriterion("jtyshjlht not like", value, "jtyshjlht");
            return (Criteria) this;
        }

        public Criteria andJtyshjlhtIn(List<String> values) {
            addCriterion("jtyshjlht in", values, "jtyshjlht");
            return (Criteria) this;
        }

        public Criteria andJtyshjlhtNotIn(List<String> values) {
            addCriterion("jtyshjlht not in", values, "jtyshjlht");
            return (Criteria) this;
        }

        public Criteria andJtyshjlhtBetween(String value1, String value2) {
            addCriterion("jtyshjlht between", value1, value2, "jtyshjlht");
            return (Criteria) this;
        }

        public Criteria andJtyshjlhtNotBetween(String value1, String value2) {
            addCriterion("jtyshjlht not between", value1, value2, "jtyshjlht");
            return (Criteria) this;
        }

        public Criteria andJtyshxqIsNull() {
            addCriterion("jtyshxq is null");
            return (Criteria) this;
        }

        public Criteria andJtyshxqIsNotNull() {
            addCriterion("jtyshxq is not null");
            return (Criteria) this;
        }

        public Criteria andJtyshxqEqualTo(String value) {
            addCriterion("jtyshxq =", value, "jtyshxq");
            return (Criteria) this;
        }

        public Criteria andJtyshxqNotEqualTo(String value) {
            addCriterion("jtyshxq <>", value, "jtyshxq");
            return (Criteria) this;
        }

        public Criteria andJtyshxqGreaterThan(String value) {
            addCriterion("jtyshxq >", value, "jtyshxq");
            return (Criteria) this;
        }

        public Criteria andJtyshxqGreaterThanOrEqualTo(String value) {
            addCriterion("jtyshxq >=", value, "jtyshxq");
            return (Criteria) this;
        }

        public Criteria andJtyshxqLessThan(String value) {
            addCriterion("jtyshxq <", value, "jtyshxq");
            return (Criteria) this;
        }

        public Criteria andJtyshxqLessThanOrEqualTo(String value) {
            addCriterion("jtyshxq <=", value, "jtyshxq");
            return (Criteria) this;
        }

        public Criteria andJtyshxqLike(String value) {
            addCriterion("jtyshxq like", value, "jtyshxq");
            return (Criteria) this;
        }

        public Criteria andJtyshxqNotLike(String value) {
            addCriterion("jtyshxq not like", value, "jtyshxq");
            return (Criteria) this;
        }

        public Criteria andJtyshxqIn(List<String> values) {
            addCriterion("jtyshxq in", values, "jtyshxq");
            return (Criteria) this;
        }

        public Criteria andJtyshxqNotIn(List<String> values) {
            addCriterion("jtyshxq not in", values, "jtyshxq");
            return (Criteria) this;
        }

        public Criteria andJtyshxqBetween(String value1, String value2) {
            addCriterion("jtyshxq between", value1, value2, "jtyshxq");
            return (Criteria) this;
        }

        public Criteria andJtyshxqNotBetween(String value1, String value2) {
            addCriterion("jtyshxq not between", value1, value2, "jtyshxq");
            return (Criteria) this;
        }

        public Criteria andZcyshjysIsNull() {
            addCriterion("zcyshjys is null");
            return (Criteria) this;
        }

        public Criteria andZcyshjysIsNotNull() {
            addCriterion("zcyshjys is not null");
            return (Criteria) this;
        }

        public Criteria andZcyshjysEqualTo(String value) {
            addCriterion("zcyshjys =", value, "zcyshjys");
            return (Criteria) this;
        }

        public Criteria andZcyshjysNotEqualTo(String value) {
            addCriterion("zcyshjys <>", value, "zcyshjys");
            return (Criteria) this;
        }

        public Criteria andZcyshjysGreaterThan(String value) {
            addCriterion("zcyshjys >", value, "zcyshjys");
            return (Criteria) this;
        }

        public Criteria andZcyshjysGreaterThanOrEqualTo(String value) {
            addCriterion("zcyshjys >=", value, "zcyshjys");
            return (Criteria) this;
        }

        public Criteria andZcyshjysLessThan(String value) {
            addCriterion("zcyshjys <", value, "zcyshjys");
            return (Criteria) this;
        }

        public Criteria andZcyshjysLessThanOrEqualTo(String value) {
            addCriterion("zcyshjys <=", value, "zcyshjys");
            return (Criteria) this;
        }

        public Criteria andZcyshjysLike(String value) {
            addCriterion("zcyshjys like", value, "zcyshjys");
            return (Criteria) this;
        }

        public Criteria andZcyshjysNotLike(String value) {
            addCriterion("zcyshjys not like", value, "zcyshjys");
            return (Criteria) this;
        }

        public Criteria andZcyshjysIn(List<String> values) {
            addCriterion("zcyshjys in", values, "zcyshjys");
            return (Criteria) this;
        }

        public Criteria andZcyshjysNotIn(List<String> values) {
            addCriterion("zcyshjys not in", values, "zcyshjys");
            return (Criteria) this;
        }

        public Criteria andZcyshjysBetween(String value1, String value2) {
            addCriterion("zcyshjys between", value1, value2, "zcyshjys");
            return (Criteria) this;
        }

        public Criteria andZcyshjysNotBetween(String value1, String value2) {
            addCriterion("zcyshjys not between", value1, value2, "zcyshjys");
            return (Criteria) this;
        }

        public Criteria andZcyshjlhtIsNull() {
            addCriterion("zcyshjlht is null");
            return (Criteria) this;
        }

        public Criteria andZcyshjlhtIsNotNull() {
            addCriterion("zcyshjlht is not null");
            return (Criteria) this;
        }

        public Criteria andZcyshjlhtEqualTo(String value) {
            addCriterion("zcyshjlht =", value, "zcyshjlht");
            return (Criteria) this;
        }

        public Criteria andZcyshjlhtNotEqualTo(String value) {
            addCriterion("zcyshjlht <>", value, "zcyshjlht");
            return (Criteria) this;
        }

        public Criteria andZcyshjlhtGreaterThan(String value) {
            addCriterion("zcyshjlht >", value, "zcyshjlht");
            return (Criteria) this;
        }

        public Criteria andZcyshjlhtGreaterThanOrEqualTo(String value) {
            addCriterion("zcyshjlht >=", value, "zcyshjlht");
            return (Criteria) this;
        }

        public Criteria andZcyshjlhtLessThan(String value) {
            addCriterion("zcyshjlht <", value, "zcyshjlht");
            return (Criteria) this;
        }

        public Criteria andZcyshjlhtLessThanOrEqualTo(String value) {
            addCriterion("zcyshjlht <=", value, "zcyshjlht");
            return (Criteria) this;
        }

        public Criteria andZcyshjlhtLike(String value) {
            addCriterion("zcyshjlht like", value, "zcyshjlht");
            return (Criteria) this;
        }

        public Criteria andZcyshjlhtNotLike(String value) {
            addCriterion("zcyshjlht not like", value, "zcyshjlht");
            return (Criteria) this;
        }

        public Criteria andZcyshjlhtIn(List<String> values) {
            addCriterion("zcyshjlht in", values, "zcyshjlht");
            return (Criteria) this;
        }

        public Criteria andZcyshjlhtNotIn(List<String> values) {
            addCriterion("zcyshjlht not in", values, "zcyshjlht");
            return (Criteria) this;
        }

        public Criteria andZcyshjlhtBetween(String value1, String value2) {
            addCriterion("zcyshjlht between", value1, value2, "zcyshjlht");
            return (Criteria) this;
        }

        public Criteria andZcyshjlhtNotBetween(String value1, String value2) {
            addCriterion("zcyshjlht not between", value1, value2, "zcyshjlht");
            return (Criteria) this;
        }

        public Criteria andZcyshjxqIsNull() {
            addCriterion("zcyshjxq is null");
            return (Criteria) this;
        }

        public Criteria andZcyshjxqIsNotNull() {
            addCriterion("zcyshjxq is not null");
            return (Criteria) this;
        }

        public Criteria andZcyshjxqEqualTo(String value) {
            addCriterion("zcyshjxq =", value, "zcyshjxq");
            return (Criteria) this;
        }

        public Criteria andZcyshjxqNotEqualTo(String value) {
            addCriterion("zcyshjxq <>", value, "zcyshjxq");
            return (Criteria) this;
        }

        public Criteria andZcyshjxqGreaterThan(String value) {
            addCriterion("zcyshjxq >", value, "zcyshjxq");
            return (Criteria) this;
        }

        public Criteria andZcyshjxqGreaterThanOrEqualTo(String value) {
            addCriterion("zcyshjxq >=", value, "zcyshjxq");
            return (Criteria) this;
        }

        public Criteria andZcyshjxqLessThan(String value) {
            addCriterion("zcyshjxq <", value, "zcyshjxq");
            return (Criteria) this;
        }

        public Criteria andZcyshjxqLessThanOrEqualTo(String value) {
            addCriterion("zcyshjxq <=", value, "zcyshjxq");
            return (Criteria) this;
        }

        public Criteria andZcyshjxqLike(String value) {
            addCriterion("zcyshjxq like", value, "zcyshjxq");
            return (Criteria) this;
        }

        public Criteria andZcyshjxqNotLike(String value) {
            addCriterion("zcyshjxq not like", value, "zcyshjxq");
            return (Criteria) this;
        }

        public Criteria andZcyshjxqIn(List<String> values) {
            addCriterion("zcyshjxq in", values, "zcyshjxq");
            return (Criteria) this;
        }

        public Criteria andZcyshjxqNotIn(List<String> values) {
            addCriterion("zcyshjxq not in", values, "zcyshjxq");
            return (Criteria) this;
        }

        public Criteria andZcyshjxqBetween(String value1, String value2) {
            addCriterion("zcyshjxq between", value1, value2, "zcyshjxq");
            return (Criteria) this;
        }

        public Criteria andZcyshjxqNotBetween(String value1, String value2) {
            addCriterion("zcyshjxq not between", value1, value2, "zcyshjxq");
            return (Criteria) this;
        }

        public Criteria andGfyshjysIsNull() {
            addCriterion("gfyshjys is null");
            return (Criteria) this;
        }

        public Criteria andGfyshjysIsNotNull() {
            addCriterion("gfyshjys is not null");
            return (Criteria) this;
        }

        public Criteria andGfyshjysEqualTo(String value) {
            addCriterion("gfyshjys =", value, "gfyshjys");
            return (Criteria) this;
        }

        public Criteria andGfyshjysNotEqualTo(String value) {
            addCriterion("gfyshjys <>", value, "gfyshjys");
            return (Criteria) this;
        }

        public Criteria andGfyshjysGreaterThan(String value) {
            addCriterion("gfyshjys >", value, "gfyshjys");
            return (Criteria) this;
        }

        public Criteria andGfyshjysGreaterThanOrEqualTo(String value) {
            addCriterion("gfyshjys >=", value, "gfyshjys");
            return (Criteria) this;
        }

        public Criteria andGfyshjysLessThan(String value) {
            addCriterion("gfyshjys <", value, "gfyshjys");
            return (Criteria) this;
        }

        public Criteria andGfyshjysLessThanOrEqualTo(String value) {
            addCriterion("gfyshjys <=", value, "gfyshjys");
            return (Criteria) this;
        }

        public Criteria andGfyshjysLike(String value) {
            addCriterion("gfyshjys like", value, "gfyshjys");
            return (Criteria) this;
        }

        public Criteria andGfyshjysNotLike(String value) {
            addCriterion("gfyshjys not like", value, "gfyshjys");
            return (Criteria) this;
        }

        public Criteria andGfyshjysIn(List<String> values) {
            addCriterion("gfyshjys in", values, "gfyshjys");
            return (Criteria) this;
        }

        public Criteria andGfyshjysNotIn(List<String> values) {
            addCriterion("gfyshjys not in", values, "gfyshjys");
            return (Criteria) this;
        }

        public Criteria andGfyshjysBetween(String value1, String value2) {
            addCriterion("gfyshjys between", value1, value2, "gfyshjys");
            return (Criteria) this;
        }

        public Criteria andGfyshjysNotBetween(String value1, String value2) {
            addCriterion("gfyshjys not between", value1, value2, "gfyshjys");
            return (Criteria) this;
        }

        public Criteria andGfyshjlhtIsNull() {
            addCriterion("gfyshjlht is null");
            return (Criteria) this;
        }

        public Criteria andGfyshjlhtIsNotNull() {
            addCriterion("gfyshjlht is not null");
            return (Criteria) this;
        }

        public Criteria andGfyshjlhtEqualTo(String value) {
            addCriterion("gfyshjlht =", value, "gfyshjlht");
            return (Criteria) this;
        }

        public Criteria andGfyshjlhtNotEqualTo(String value) {
            addCriterion("gfyshjlht <>", value, "gfyshjlht");
            return (Criteria) this;
        }

        public Criteria andGfyshjlhtGreaterThan(String value) {
            addCriterion("gfyshjlht >", value, "gfyshjlht");
            return (Criteria) this;
        }

        public Criteria andGfyshjlhtGreaterThanOrEqualTo(String value) {
            addCriterion("gfyshjlht >=", value, "gfyshjlht");
            return (Criteria) this;
        }

        public Criteria andGfyshjlhtLessThan(String value) {
            addCriterion("gfyshjlht <", value, "gfyshjlht");
            return (Criteria) this;
        }

        public Criteria andGfyshjlhtLessThanOrEqualTo(String value) {
            addCriterion("gfyshjlht <=", value, "gfyshjlht");
            return (Criteria) this;
        }

        public Criteria andGfyshjlhtLike(String value) {
            addCriterion("gfyshjlht like", value, "gfyshjlht");
            return (Criteria) this;
        }

        public Criteria andGfyshjlhtNotLike(String value) {
            addCriterion("gfyshjlht not like", value, "gfyshjlht");
            return (Criteria) this;
        }

        public Criteria andGfyshjlhtIn(List<String> values) {
            addCriterion("gfyshjlht in", values, "gfyshjlht");
            return (Criteria) this;
        }

        public Criteria andGfyshjlhtNotIn(List<String> values) {
            addCriterion("gfyshjlht not in", values, "gfyshjlht");
            return (Criteria) this;
        }

        public Criteria andGfyshjlhtBetween(String value1, String value2) {
            addCriterion("gfyshjlht between", value1, value2, "gfyshjlht");
            return (Criteria) this;
        }

        public Criteria andGfyshjlhtNotBetween(String value1, String value2) {
            addCriterion("gfyshjlht not between", value1, value2, "gfyshjlht");
            return (Criteria) this;
        }

        public Criteria andGfyshjxqIsNull() {
            addCriterion("gfyshjxq is null");
            return (Criteria) this;
        }

        public Criteria andGfyshjxqIsNotNull() {
            addCriterion("gfyshjxq is not null");
            return (Criteria) this;
        }

        public Criteria andGfyshjxqEqualTo(String value) {
            addCriterion("gfyshjxq =", value, "gfyshjxq");
            return (Criteria) this;
        }

        public Criteria andGfyshjxqNotEqualTo(String value) {
            addCriterion("gfyshjxq <>", value, "gfyshjxq");
            return (Criteria) this;
        }

        public Criteria andGfyshjxqGreaterThan(String value) {
            addCriterion("gfyshjxq >", value, "gfyshjxq");
            return (Criteria) this;
        }

        public Criteria andGfyshjxqGreaterThanOrEqualTo(String value) {
            addCriterion("gfyshjxq >=", value, "gfyshjxq");
            return (Criteria) this;
        }

        public Criteria andGfyshjxqLessThan(String value) {
            addCriterion("gfyshjxq <", value, "gfyshjxq");
            return (Criteria) this;
        }

        public Criteria andGfyshjxqLessThanOrEqualTo(String value) {
            addCriterion("gfyshjxq <=", value, "gfyshjxq");
            return (Criteria) this;
        }

        public Criteria andGfyshjxqLike(String value) {
            addCriterion("gfyshjxq like", value, "gfyshjxq");
            return (Criteria) this;
        }

        public Criteria andGfyshjxqNotLike(String value) {
            addCriterion("gfyshjxq not like", value, "gfyshjxq");
            return (Criteria) this;
        }

        public Criteria andGfyshjxqIn(List<String> values) {
            addCriterion("gfyshjxq in", values, "gfyshjxq");
            return (Criteria) this;
        }

        public Criteria andGfyshjxqNotIn(List<String> values) {
            addCriterion("gfyshjxq not in", values, "gfyshjxq");
            return (Criteria) this;
        }

        public Criteria andGfyshjxqBetween(String value1, String value2) {
            addCriterion("gfyshjxq between", value1, value2, "gfyshjxq");
            return (Criteria) this;
        }

        public Criteria andGfyshjxqNotBetween(String value1, String value2) {
            addCriterion("gfyshjxq not between", value1, value2, "gfyshjxq");
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