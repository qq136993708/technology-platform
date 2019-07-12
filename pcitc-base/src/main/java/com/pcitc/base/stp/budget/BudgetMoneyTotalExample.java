package com.pcitc.base.stp.budget;

import java.util.ArrayList;
import java.util.List;

public class BudgetMoneyTotalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public BudgetMoneyTotalExample() {
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

        public Criteria andShowIndexIsNull() {
            addCriterion("show_index is null");
            return (Criteria) this;
        }

        public Criteria andShowIndexIsNotNull() {
            addCriterion("show_index is not null");
            return (Criteria) this;
        }

        public Criteria andShowIndexEqualTo(String value) {
            addCriterion("show_index =", value, "showIndex");
            return (Criteria) this;
        }

        public Criteria andShowIndexNotEqualTo(String value) {
            addCriterion("show_index <>", value, "showIndex");
            return (Criteria) this;
        }

        public Criteria andShowIndexGreaterThan(String value) {
            addCriterion("show_index >", value, "showIndex");
            return (Criteria) this;
        }

        public Criteria andShowIndexGreaterThanOrEqualTo(String value) {
            addCriterion("show_index >=", value, "showIndex");
            return (Criteria) this;
        }

        public Criteria andShowIndexLessThan(String value) {
            addCriterion("show_index <", value, "showIndex");
            return (Criteria) this;
        }

        public Criteria andShowIndexLessThanOrEqualTo(String value) {
            addCriterion("show_index <=", value, "showIndex");
            return (Criteria) this;
        }

        public Criteria andShowIndexLike(String value) {
            addCriterion("show_index like", value, "showIndex");
            return (Criteria) this;
        }

        public Criteria andShowIndexNotLike(String value) {
            addCriterion("show_index not like", value, "showIndex");
            return (Criteria) this;
        }

        public Criteria andShowIndexIn(List<String> values) {
            addCriterion("show_index in", values, "showIndex");
            return (Criteria) this;
        }

        public Criteria andShowIndexNotIn(List<String> values) {
            addCriterion("show_index not in", values, "showIndex");
            return (Criteria) this;
        }

        public Criteria andShowIndexBetween(String value1, String value2) {
            addCriterion("show_index between", value1, value2, "showIndex");
            return (Criteria) this;
        }

        public Criteria andShowIndexNotBetween(String value1, String value2) {
            addCriterion("show_index not between", value1, value2, "showIndex");
            return (Criteria) this;
        }

        public Criteria andUnitNameIsNull() {
            addCriterion("unit_name is null");
            return (Criteria) this;
        }

        public Criteria andUnitNameIsNotNull() {
            addCriterion("unit_name is not null");
            return (Criteria) this;
        }

        public Criteria andUnitNameEqualTo(String value) {
            addCriterion("unit_name =", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotEqualTo(String value) {
            addCriterion("unit_name <>", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameGreaterThan(String value) {
            addCriterion("unit_name >", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameGreaterThanOrEqualTo(String value) {
            addCriterion("unit_name >=", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameLessThan(String value) {
            addCriterion("unit_name <", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameLessThanOrEqualTo(String value) {
            addCriterion("unit_name <=", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameLike(String value) {
            addCriterion("unit_name like", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotLike(String value) {
            addCriterion("unit_name not like", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameIn(List<String> values) {
            addCriterion("unit_name in", values, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotIn(List<String> values) {
            addCriterion("unit_name not in", values, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameBetween(String value1, String value2) {
            addCriterion("unit_name between", value1, value2, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotBetween(String value1, String value2) {
            addCriterion("unit_name not between", value1, value2, "unitName");
            return (Criteria) this;
        }

        public Criteria andShowAliIsNull() {
            addCriterion("show_ali is null");
            return (Criteria) this;
        }

        public Criteria andShowAliIsNotNull() {
            addCriterion("show_ali is not null");
            return (Criteria) this;
        }

        public Criteria andShowAliEqualTo(String value) {
            addCriterion("show_ali =", value, "showAli");
            return (Criteria) this;
        }

        public Criteria andShowAliNotEqualTo(String value) {
            addCriterion("show_ali <>", value, "showAli");
            return (Criteria) this;
        }

        public Criteria andShowAliGreaterThan(String value) {
            addCriterion("show_ali >", value, "showAli");
            return (Criteria) this;
        }

        public Criteria andShowAliGreaterThanOrEqualTo(String value) {
            addCriterion("show_ali >=", value, "showAli");
            return (Criteria) this;
        }

        public Criteria andShowAliLessThan(String value) {
            addCriterion("show_ali <", value, "showAli");
            return (Criteria) this;
        }

        public Criteria andShowAliLessThanOrEqualTo(String value) {
            addCriterion("show_ali <=", value, "showAli");
            return (Criteria) this;
        }

        public Criteria andShowAliLike(String value) {
            addCriterion("show_ali like", value, "showAli");
            return (Criteria) this;
        }

        public Criteria andShowAliNotLike(String value) {
            addCriterion("show_ali not like", value, "showAli");
            return (Criteria) this;
        }

        public Criteria andShowAliIn(List<String> values) {
            addCriterion("show_ali in", values, "showAli");
            return (Criteria) this;
        }

        public Criteria andShowAliNotIn(List<String> values) {
            addCriterion("show_ali not in", values, "showAli");
            return (Criteria) this;
        }

        public Criteria andShowAliBetween(String value1, String value2) {
            addCriterion("show_ali between", value1, value2, "showAli");
            return (Criteria) this;
        }

        public Criteria andShowAliNotBetween(String value1, String value2) {
            addCriterion("show_ali not between", value1, value2, "showAli");
            return (Criteria) this;
        }

        public Criteria andZbxMoneyIsNull() {
            addCriterion("zbx_money is null");
            return (Criteria) this;
        }

        public Criteria andZbxMoneyIsNotNull() {
            addCriterion("zbx_money is not null");
            return (Criteria) this;
        }

        public Criteria andZbxMoneyEqualTo(String value) {
            addCriterion("zbx_money =", value, "zbxMoney");
            return (Criteria) this;
        }

        public Criteria andZbxMoneyNotEqualTo(String value) {
            addCriterion("zbx_money <>", value, "zbxMoney");
            return (Criteria) this;
        }

        public Criteria andZbxMoneyGreaterThan(String value) {
            addCriterion("zbx_money >", value, "zbxMoney");
            return (Criteria) this;
        }

        public Criteria andZbxMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("zbx_money >=", value, "zbxMoney");
            return (Criteria) this;
        }

        public Criteria andZbxMoneyLessThan(String value) {
            addCriterion("zbx_money <", value, "zbxMoney");
            return (Criteria) this;
        }

        public Criteria andZbxMoneyLessThanOrEqualTo(String value) {
            addCriterion("zbx_money <=", value, "zbxMoney");
            return (Criteria) this;
        }

        public Criteria andZbxMoneyLike(String value) {
            addCriterion("zbx_money like", value, "zbxMoney");
            return (Criteria) this;
        }

        public Criteria andZbxMoneyNotLike(String value) {
            addCriterion("zbx_money not like", value, "zbxMoney");
            return (Criteria) this;
        }

        public Criteria andZbxMoneyIn(List<String> values) {
            addCriterion("zbx_money in", values, "zbxMoney");
            return (Criteria) this;
        }

        public Criteria andZbxMoneyNotIn(List<String> values) {
            addCriterion("zbx_money not in", values, "zbxMoney");
            return (Criteria) this;
        }

        public Criteria andZbxMoneyBetween(String value1, String value2) {
            addCriterion("zbx_money between", value1, value2, "zbxMoney");
            return (Criteria) this;
        }

        public Criteria andZbxMoneyNotBetween(String value1, String value2) {
            addCriterion("zbx_money not between", value1, value2, "zbxMoney");
            return (Criteria) this;
        }

        public Criteria andFyxMoneyIsNull() {
            addCriterion("fyx_money is null");
            return (Criteria) this;
        }

        public Criteria andFyxMoneyIsNotNull() {
            addCriterion("fyx_money is not null");
            return (Criteria) this;
        }

        public Criteria andFyxMoneyEqualTo(String value) {
            addCriterion("fyx_money =", value, "fyxMoney");
            return (Criteria) this;
        }

        public Criteria andFyxMoneyNotEqualTo(String value) {
            addCriterion("fyx_money <>", value, "fyxMoney");
            return (Criteria) this;
        }

        public Criteria andFyxMoneyGreaterThan(String value) {
            addCriterion("fyx_money >", value, "fyxMoney");
            return (Criteria) this;
        }

        public Criteria andFyxMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("fyx_money >=", value, "fyxMoney");
            return (Criteria) this;
        }

        public Criteria andFyxMoneyLessThan(String value) {
            addCriterion("fyx_money <", value, "fyxMoney");
            return (Criteria) this;
        }

        public Criteria andFyxMoneyLessThanOrEqualTo(String value) {
            addCriterion("fyx_money <=", value, "fyxMoney");
            return (Criteria) this;
        }

        public Criteria andFyxMoneyLike(String value) {
            addCriterion("fyx_money like", value, "fyxMoney");
            return (Criteria) this;
        }

        public Criteria andFyxMoneyNotLike(String value) {
            addCriterion("fyx_money not like", value, "fyxMoney");
            return (Criteria) this;
        }

        public Criteria andFyxMoneyIn(List<String> values) {
            addCriterion("fyx_money in", values, "fyxMoney");
            return (Criteria) this;
        }

        public Criteria andFyxMoneyNotIn(List<String> values) {
            addCriterion("fyx_money not in", values, "fyxMoney");
            return (Criteria) this;
        }

        public Criteria andFyxMoneyBetween(String value1, String value2) {
            addCriterion("fyx_money between", value1, value2, "fyxMoney");
            return (Criteria) this;
        }

        public Criteria andFyxMoneyNotBetween(String value1, String value2) {
            addCriterion("fyx_money not between", value1, value2, "fyxMoney");
            return (Criteria) this;
        }

        public Criteria andMoneyLevelIsNull() {
            addCriterion("money_level is null");
            return (Criteria) this;
        }

        public Criteria andMoneyLevelIsNotNull() {
            addCriterion("money_level is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyLevelEqualTo(String value) {
            addCriterion("money_level =", value, "moneyLevel");
            return (Criteria) this;
        }

        public Criteria andMoneyLevelNotEqualTo(String value) {
            addCriterion("money_level <>", value, "moneyLevel");
            return (Criteria) this;
        }

        public Criteria andMoneyLevelGreaterThan(String value) {
            addCriterion("money_level >", value, "moneyLevel");
            return (Criteria) this;
        }

        public Criteria andMoneyLevelGreaterThanOrEqualTo(String value) {
            addCriterion("money_level >=", value, "moneyLevel");
            return (Criteria) this;
        }

        public Criteria andMoneyLevelLessThan(String value) {
            addCriterion("money_level <", value, "moneyLevel");
            return (Criteria) this;
        }

        public Criteria andMoneyLevelLessThanOrEqualTo(String value) {
            addCriterion("money_level <=", value, "moneyLevel");
            return (Criteria) this;
        }

        public Criteria andMoneyLevelLike(String value) {
            addCriterion("money_level like", value, "moneyLevel");
            return (Criteria) this;
        }

        public Criteria andMoneyLevelNotLike(String value) {
            addCriterion("money_level not like", value, "moneyLevel");
            return (Criteria) this;
        }

        public Criteria andMoneyLevelIn(List<String> values) {
            addCriterion("money_level in", values, "moneyLevel");
            return (Criteria) this;
        }

        public Criteria andMoneyLevelNotIn(List<String> values) {
            addCriterion("money_level not in", values, "moneyLevel");
            return (Criteria) this;
        }

        public Criteria andMoneyLevelBetween(String value1, String value2) {
            addCriterion("money_level between", value1, value2, "moneyLevel");
            return (Criteria) this;
        }

        public Criteria andMoneyLevelNotBetween(String value1, String value2) {
            addCriterion("money_level not between", value1, value2, "moneyLevel");
            return (Criteria) this;
        }

        public Criteria andDetailsNameIsNull() {
            addCriterion("details_name is null");
            return (Criteria) this;
        }

        public Criteria andDetailsNameIsNotNull() {
            addCriterion("details_name is not null");
            return (Criteria) this;
        }

        public Criteria andDetailsNameEqualTo(String value) {
            addCriterion("details_name =", value, "detailsName");
            return (Criteria) this;
        }

        public Criteria andDetailsNameNotEqualTo(String value) {
            addCriterion("details_name <>", value, "detailsName");
            return (Criteria) this;
        }

        public Criteria andDetailsNameGreaterThan(String value) {
            addCriterion("details_name >", value, "detailsName");
            return (Criteria) this;
        }

        public Criteria andDetailsNameGreaterThanOrEqualTo(String value) {
            addCriterion("details_name >=", value, "detailsName");
            return (Criteria) this;
        }

        public Criteria andDetailsNameLessThan(String value) {
            addCriterion("details_name <", value, "detailsName");
            return (Criteria) this;
        }

        public Criteria andDetailsNameLessThanOrEqualTo(String value) {
            addCriterion("details_name <=", value, "detailsName");
            return (Criteria) this;
        }

        public Criteria andDetailsNameLike(String value) {
            addCriterion("details_name like", value, "detailsName");
            return (Criteria) this;
        }

        public Criteria andDetailsNameNotLike(String value) {
            addCriterion("details_name not like", value, "detailsName");
            return (Criteria) this;
        }

        public Criteria andDetailsNameIn(List<String> values) {
            addCriterion("details_name in", values, "detailsName");
            return (Criteria) this;
        }

        public Criteria andDetailsNameNotIn(List<String> values) {
            addCriterion("details_name not in", values, "detailsName");
            return (Criteria) this;
        }

        public Criteria andDetailsNameBetween(String value1, String value2) {
            addCriterion("details_name between", value1, value2, "detailsName");
            return (Criteria) this;
        }

        public Criteria andDetailsNameNotBetween(String value1, String value2) {
            addCriterion("details_name not between", value1, value2, "detailsName");
            return (Criteria) this;
        }

        public Criteria andIsYjyIsNull() {
            addCriterion("is_yjy is null");
            return (Criteria) this;
        }

        public Criteria andIsYjyIsNotNull() {
            addCriterion("is_yjy is not null");
            return (Criteria) this;
        }

        public Criteria andIsYjyEqualTo(String value) {
            addCriterion("is_yjy =", value, "isYjy");
            return (Criteria) this;
        }

        public Criteria andIsYjyNotEqualTo(String value) {
            addCriterion("is_yjy <>", value, "isYjy");
            return (Criteria) this;
        }

        public Criteria andIsYjyGreaterThan(String value) {
            addCriterion("is_yjy >", value, "isYjy");
            return (Criteria) this;
        }

        public Criteria andIsYjyGreaterThanOrEqualTo(String value) {
            addCriterion("is_yjy >=", value, "isYjy");
            return (Criteria) this;
        }

        public Criteria andIsYjyLessThan(String value) {
            addCriterion("is_yjy <", value, "isYjy");
            return (Criteria) this;
        }

        public Criteria andIsYjyLessThanOrEqualTo(String value) {
            addCriterion("is_yjy <=", value, "isYjy");
            return (Criteria) this;
        }

        public Criteria andIsYjyLike(String value) {
            addCriterion("is_yjy like", value, "isYjy");
            return (Criteria) this;
        }

        public Criteria andIsYjyNotLike(String value) {
            addCriterion("is_yjy not like", value, "isYjy");
            return (Criteria) this;
        }

        public Criteria andIsYjyIn(List<String> values) {
            addCriterion("is_yjy in", values, "isYjy");
            return (Criteria) this;
        }

        public Criteria andIsYjyNotIn(List<String> values) {
            addCriterion("is_yjy not in", values, "isYjy");
            return (Criteria) this;
        }

        public Criteria andIsYjyBetween(String value1, String value2) {
            addCriterion("is_yjy between", value1, value2, "isYjy");
            return (Criteria) this;
        }

        public Criteria andIsYjyNotBetween(String value1, String value2) {
            addCriterion("is_yjy not between", value1, value2, "isYjy");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNull() {
            addCriterion("type_name is null");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNotNull() {
            addCriterion("type_name is not null");
            return (Criteria) this;
        }

        public Criteria andTypeNameEqualTo(String value) {
            addCriterion("type_name =", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotEqualTo(String value) {
            addCriterion("type_name <>", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThan(String value) {
            addCriterion("type_name >", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("type_name >=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThan(String value) {
            addCriterion("type_name <", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThanOrEqualTo(String value) {
            addCriterion("type_name <=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLike(String value) {
            addCriterion("type_name like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotLike(String value) {
            addCriterion("type_name not like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameIn(List<String> values) {
            addCriterion("type_name in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotIn(List<String> values) {
            addCriterion("type_name not in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameBetween(String value1, String value2) {
            addCriterion("type_name between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotBetween(String value1, String value2) {
            addCriterion("type_name not between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andSheetFlagIsNull() {
            addCriterion("sheet_flag is null");
            return (Criteria) this;
        }

        public Criteria andSheetFlagIsNotNull() {
            addCriterion("sheet_flag is not null");
            return (Criteria) this;
        }

        public Criteria andSheetFlagEqualTo(String value) {
            addCriterion("sheet_flag =", value, "sheetFlag");
            return (Criteria) this;
        }

        public Criteria andSheetFlagNotEqualTo(String value) {
            addCriterion("sheet_flag <>", value, "sheetFlag");
            return (Criteria) this;
        }

        public Criteria andSheetFlagGreaterThan(String value) {
            addCriterion("sheet_flag >", value, "sheetFlag");
            return (Criteria) this;
        }

        public Criteria andSheetFlagGreaterThanOrEqualTo(String value) {
            addCriterion("sheet_flag >=", value, "sheetFlag");
            return (Criteria) this;
        }

        public Criteria andSheetFlagLessThan(String value) {
            addCriterion("sheet_flag <", value, "sheetFlag");
            return (Criteria) this;
        }

        public Criteria andSheetFlagLessThanOrEqualTo(String value) {
            addCriterion("sheet_flag <=", value, "sheetFlag");
            return (Criteria) this;
        }

        public Criteria andSheetFlagLike(String value) {
            addCriterion("sheet_flag like", value, "sheetFlag");
            return (Criteria) this;
        }

        public Criteria andSheetFlagNotLike(String value) {
            addCriterion("sheet_flag not like", value, "sheetFlag");
            return (Criteria) this;
        }

        public Criteria andSheetFlagIn(List<String> values) {
            addCriterion("sheet_flag in", values, "sheetFlag");
            return (Criteria) this;
        }

        public Criteria andSheetFlagNotIn(List<String> values) {
            addCriterion("sheet_flag not in", values, "sheetFlag");
            return (Criteria) this;
        }

        public Criteria andSheetFlagBetween(String value1, String value2) {
            addCriterion("sheet_flag between", value1, value2, "sheetFlag");
            return (Criteria) this;
        }

        public Criteria andSheetFlagNotBetween(String value1, String value2) {
            addCriterion("sheet_flag not between", value1, value2, "sheetFlag");
            return (Criteria) this;
        }

        public Criteria andShowOrderIsNull() {
            addCriterion("show_order is null");
            return (Criteria) this;
        }

        public Criteria andShowOrderIsNotNull() {
            addCriterion("show_order is not null");
            return (Criteria) this;
        }

        public Criteria andShowOrderEqualTo(String value) {
            addCriterion("show_order =", value, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderNotEqualTo(String value) {
            addCriterion("show_order <>", value, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderGreaterThan(String value) {
            addCriterion("show_order >", value, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderGreaterThanOrEqualTo(String value) {
            addCriterion("show_order >=", value, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderLessThan(String value) {
            addCriterion("show_order <", value, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderLessThanOrEqualTo(String value) {
            addCriterion("show_order <=", value, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderLike(String value) {
            addCriterion("show_order like", value, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderNotLike(String value) {
            addCriterion("show_order not like", value, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderIn(List<String> values) {
            addCriterion("show_order in", values, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderNotIn(List<String> values) {
            addCriterion("show_order not in", values, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderBetween(String value1, String value2) {
            addCriterion("show_order between", value1, value2, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderNotBetween(String value1, String value2) {
            addCriterion("show_order not between", value1, value2, "showOrder");
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