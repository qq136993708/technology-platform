package com.pcitc.base.stp.budget;

import java.util.ArrayList;
import java.util.List;

public class BudgetMoneyCompanyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BudgetMoneyCompanyExample() {
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

        public Criteria andJfysIsNull() {
            addCriterion("jfys is null");
            return (Criteria) this;
        }

        public Criteria andJfysIsNotNull() {
            addCriterion("jfys is not null");
            return (Criteria) this;
        }

        public Criteria andJfysEqualTo(String value) {
            addCriterion("jfys =", value, "jfys");
            return (Criteria) this;
        }

        public Criteria andJfysNotEqualTo(String value) {
            addCriterion("jfys <>", value, "jfys");
            return (Criteria) this;
        }

        public Criteria andJfysGreaterThan(String value) {
            addCriterion("jfys >", value, "jfys");
            return (Criteria) this;
        }

        public Criteria andJfysGreaterThanOrEqualTo(String value) {
            addCriterion("jfys >=", value, "jfys");
            return (Criteria) this;
        }

        public Criteria andJfysLessThan(String value) {
            addCriterion("jfys <", value, "jfys");
            return (Criteria) this;
        }

        public Criteria andJfysLessThanOrEqualTo(String value) {
            addCriterion("jfys <=", value, "jfys");
            return (Criteria) this;
        }

        public Criteria andJfysLike(String value) {
            addCriterion("jfys like", value, "jfys");
            return (Criteria) this;
        }

        public Criteria andJfysNotLike(String value) {
            addCriterion("jfys not like", value, "jfys");
            return (Criteria) this;
        }

        public Criteria andJfysIn(List<String> values) {
            addCriterion("jfys in", values, "jfys");
            return (Criteria) this;
        }

        public Criteria andJfysNotIn(List<String> values) {
            addCriterion("jfys not in", values, "jfys");
            return (Criteria) this;
        }

        public Criteria andJfysBetween(String value1, String value2) {
            addCriterion("jfys between", value1, value2, "jfys");
            return (Criteria) this;
        }

        public Criteria andJfysNotBetween(String value1, String value2) {
            addCriterion("jfys not between", value1, value2, "jfys");
            return (Criteria) this;
        }

        public Criteria andJzjfIsNull() {
            addCriterion("jzjf is null");
            return (Criteria) this;
        }

        public Criteria andJzjfIsNotNull() {
            addCriterion("jzjf is not null");
            return (Criteria) this;
        }

        public Criteria andJzjfEqualTo(String value) {
            addCriterion("jzjf =", value, "jzjf");
            return (Criteria) this;
        }

        public Criteria andJzjfNotEqualTo(String value) {
            addCriterion("jzjf <>", value, "jzjf");
            return (Criteria) this;
        }

        public Criteria andJzjfGreaterThan(String value) {
            addCriterion("jzjf >", value, "jzjf");
            return (Criteria) this;
        }

        public Criteria andJzjfGreaterThanOrEqualTo(String value) {
            addCriterion("jzjf >=", value, "jzjf");
            return (Criteria) this;
        }

        public Criteria andJzjfLessThan(String value) {
            addCriterion("jzjf <", value, "jzjf");
            return (Criteria) this;
        }

        public Criteria andJzjfLessThanOrEqualTo(String value) {
            addCriterion("jzjf <=", value, "jzjf");
            return (Criteria) this;
        }

        public Criteria andJzjfLike(String value) {
            addCriterion("jzjf like", value, "jzjf");
            return (Criteria) this;
        }

        public Criteria andJzjfNotLike(String value) {
            addCriterion("jzjf not like", value, "jzjf");
            return (Criteria) this;
        }

        public Criteria andJzjfIn(List<String> values) {
            addCriterion("jzjf in", values, "jzjf");
            return (Criteria) this;
        }

        public Criteria andJzjfNotIn(List<String> values) {
            addCriterion("jzjf not in", values, "jzjf");
            return (Criteria) this;
        }

        public Criteria andJzjfBetween(String value1, String value2) {
            addCriterion("jzjf between", value1, value2, "jzjf");
            return (Criteria) this;
        }

        public Criteria andJzjfNotBetween(String value1, String value2) {
            addCriterion("jzjf not between", value1, value2, "jzjf");
            return (Criteria) this;
        }

        public Criteria andKxqIsNull() {
            addCriterion("kxq is null");
            return (Criteria) this;
        }

        public Criteria andKxqIsNotNull() {
            addCriterion("kxq is not null");
            return (Criteria) this;
        }

        public Criteria andKxqEqualTo(String value) {
            addCriterion("kxq =", value, "kxq");
            return (Criteria) this;
        }

        public Criteria andKxqNotEqualTo(String value) {
            addCriterion("kxq <>", value, "kxq");
            return (Criteria) this;
        }

        public Criteria andKxqGreaterThan(String value) {
            addCriterion("kxq >", value, "kxq");
            return (Criteria) this;
        }

        public Criteria andKxqGreaterThanOrEqualTo(String value) {
            addCriterion("kxq >=", value, "kxq");
            return (Criteria) this;
        }

        public Criteria andKxqLessThan(String value) {
            addCriterion("kxq <", value, "kxq");
            return (Criteria) this;
        }

        public Criteria andKxqLessThanOrEqualTo(String value) {
            addCriterion("kxq <=", value, "kxq");
            return (Criteria) this;
        }

        public Criteria andKxqLike(String value) {
            addCriterion("kxq like", value, "kxq");
            return (Criteria) this;
        }

        public Criteria andKxqNotLike(String value) {
            addCriterion("kxq not like", value, "kxq");
            return (Criteria) this;
        }

        public Criteria andKxqIn(List<String> values) {
            addCriterion("kxq in", values, "kxq");
            return (Criteria) this;
        }

        public Criteria andKxqNotIn(List<String> values) {
            addCriterion("kxq not in", values, "kxq");
            return (Criteria) this;
        }

        public Criteria andKxqBetween(String value1, String value2) {
            addCriterion("kxq between", value1, value2, "kxq");
            return (Criteria) this;
        }

        public Criteria andKxqNotBetween(String value1, String value2) {
            addCriterion("kxq not between", value1, value2, "kxq");
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