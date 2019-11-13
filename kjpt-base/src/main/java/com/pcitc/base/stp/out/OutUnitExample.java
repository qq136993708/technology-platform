package com.pcitc.base.stp.out;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OutUnitExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public OutUnitExample() {
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

        public Criteria andUnitAliIsNull() {
            addCriterion("unit_ali is null");
            return (Criteria) this;
        }

        public Criteria andUnitAliIsNotNull() {
            addCriterion("unit_ali is not null");
            return (Criteria) this;
        }

        public Criteria andUnitAliEqualTo(String value) {
            addCriterion("unit_ali =", value, "unitAli");
            return (Criteria) this;
        }

        public Criteria andUnitAliNotEqualTo(String value) {
            addCriterion("unit_ali <>", value, "unitAli");
            return (Criteria) this;
        }

        public Criteria andUnitAliGreaterThan(String value) {
            addCriterion("unit_ali >", value, "unitAli");
            return (Criteria) this;
        }

        public Criteria andUnitAliGreaterThanOrEqualTo(String value) {
            addCriterion("unit_ali >=", value, "unitAli");
            return (Criteria) this;
        }

        public Criteria andUnitAliLessThan(String value) {
            addCriterion("unit_ali <", value, "unitAli");
            return (Criteria) this;
        }

        public Criteria andUnitAliLessThanOrEqualTo(String value) {
            addCriterion("unit_ali <=", value, "unitAli");
            return (Criteria) this;
        }

        public Criteria andUnitAliLike(String value) {
            addCriterion("unit_ali like", value, "unitAli");
            return (Criteria) this;
        }

        public Criteria andUnitAliNotLike(String value) {
            addCriterion("unit_ali not like", value, "unitAli");
            return (Criteria) this;
        }

        public Criteria andUnitAliIn(List<String> values) {
            addCriterion("unit_ali in", values, "unitAli");
            return (Criteria) this;
        }

        public Criteria andUnitAliNotIn(List<String> values) {
            addCriterion("unit_ali not in", values, "unitAli");
            return (Criteria) this;
        }

        public Criteria andUnitAliBetween(String value1, String value2) {
            addCriterion("unit_ali between", value1, value2, "unitAli");
            return (Criteria) this;
        }

        public Criteria andUnitAliNotBetween(String value1, String value2) {
            addCriterion("unit_ali not between", value1, value2, "unitAli");
            return (Criteria) this;
        }

        public Criteria andParentCodeIsNull() {
            addCriterion("parent_code is null");
            return (Criteria) this;
        }

        public Criteria andParentCodeIsNotNull() {
            addCriterion("parent_code is not null");
            return (Criteria) this;
        }

        public Criteria andParentCodeEqualTo(String value) {
            addCriterion("parent_code =", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeNotEqualTo(String value) {
            addCriterion("parent_code <>", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeGreaterThan(String value) {
            addCriterion("parent_code >", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("parent_code >=", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeLessThan(String value) {
            addCriterion("parent_code <", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeLessThanOrEqualTo(String value) {
            addCriterion("parent_code <=", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeLike(String value) {
            addCriterion("parent_code like", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeNotLike(String value) {
            addCriterion("parent_code not like", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeIn(List<String> values) {
            addCriterion("parent_code in", values, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeNotIn(List<String> values) {
            addCriterion("parent_code not in", values, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeBetween(String value1, String value2) {
            addCriterion("parent_code between", value1, value2, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeNotBetween(String value1, String value2) {
            addCriterion("parent_code not between", value1, value2, "parentCode");
            return (Criteria) this;
        }

        public Criteria andUnitIndexIsNull() {
            addCriterion("unit_index is null");
            return (Criteria) this;
        }

        public Criteria andUnitIndexIsNotNull() {
            addCriterion("unit_index is not null");
            return (Criteria) this;
        }

        public Criteria andUnitIndexEqualTo(String value) {
            addCriterion("unit_index =", value, "unitIndex");
            return (Criteria) this;
        }

        public Criteria andUnitIndexNotEqualTo(String value) {
            addCriterion("unit_index <>", value, "unitIndex");
            return (Criteria) this;
        }

        public Criteria andUnitIndexGreaterThan(String value) {
            addCriterion("unit_index >", value, "unitIndex");
            return (Criteria) this;
        }

        public Criteria andUnitIndexGreaterThanOrEqualTo(String value) {
            addCriterion("unit_index >=", value, "unitIndex");
            return (Criteria) this;
        }

        public Criteria andUnitIndexLessThan(String value) {
            addCriterion("unit_index <", value, "unitIndex");
            return (Criteria) this;
        }

        public Criteria andUnitIndexLessThanOrEqualTo(String value) {
            addCriterion("unit_index <=", value, "unitIndex");
            return (Criteria) this;
        }

        public Criteria andUnitIndexLike(String value) {
            addCriterion("unit_index like", value, "unitIndex");
            return (Criteria) this;
        }

        public Criteria andUnitIndexNotLike(String value) {
            addCriterion("unit_index not like", value, "unitIndex");
            return (Criteria) this;
        }

        public Criteria andUnitIndexIn(List<String> values) {
            addCriterion("unit_index in", values, "unitIndex");
            return (Criteria) this;
        }

        public Criteria andUnitIndexNotIn(List<String> values) {
            addCriterion("unit_index not in", values, "unitIndex");
            return (Criteria) this;
        }

        public Criteria andUnitIndexBetween(String value1, String value2) {
            addCriterion("unit_index between", value1, value2, "unitIndex");
            return (Criteria) this;
        }

        public Criteria andUnitIndexNotBetween(String value1, String value2) {
            addCriterion("unit_index not between", value1, value2, "unitIndex");
            return (Criteria) this;
        }

        public Criteria andUnitLevelIsNull() {
            addCriterion("unit_level is null");
            return (Criteria) this;
        }

        public Criteria andUnitLevelIsNotNull() {
            addCriterion("unit_level is not null");
            return (Criteria) this;
        }

        public Criteria andUnitLevelEqualTo(String value) {
            addCriterion("unit_level =", value, "unitLevel");
            return (Criteria) this;
        }

        public Criteria andUnitLevelNotEqualTo(String value) {
            addCriterion("unit_level <>", value, "unitLevel");
            return (Criteria) this;
        }

        public Criteria andUnitLevelGreaterThan(String value) {
            addCriterion("unit_level >", value, "unitLevel");
            return (Criteria) this;
        }

        public Criteria andUnitLevelGreaterThanOrEqualTo(String value) {
            addCriterion("unit_level >=", value, "unitLevel");
            return (Criteria) this;
        }

        public Criteria andUnitLevelLessThan(String value) {
            addCriterion("unit_level <", value, "unitLevel");
            return (Criteria) this;
        }

        public Criteria andUnitLevelLessThanOrEqualTo(String value) {
            addCriterion("unit_level <=", value, "unitLevel");
            return (Criteria) this;
        }

        public Criteria andUnitLevelLike(String value) {
            addCriterion("unit_level like", value, "unitLevel");
            return (Criteria) this;
        }

        public Criteria andUnitLevelNotLike(String value) {
            addCriterion("unit_level not like", value, "unitLevel");
            return (Criteria) this;
        }

        public Criteria andUnitLevelIn(List<String> values) {
            addCriterion("unit_level in", values, "unitLevel");
            return (Criteria) this;
        }

        public Criteria andUnitLevelNotIn(List<String> values) {
            addCriterion("unit_level not in", values, "unitLevel");
            return (Criteria) this;
        }

        public Criteria andUnitLevelBetween(String value1, String value2) {
            addCriterion("unit_level between", value1, value2, "unitLevel");
            return (Criteria) this;
        }

        public Criteria andUnitLevelNotBetween(String value1, String value2) {
            addCriterion("unit_level not between", value1, value2, "unitLevel");
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

        public Criteria andUnitTypeIsNull() {
            addCriterion("unit_type is null");
            return (Criteria) this;
        }

        public Criteria andUnitTypeIsNotNull() {
            addCriterion("unit_type is not null");
            return (Criteria) this;
        }

        public Criteria andUnitTypeEqualTo(String value) {
            addCriterion("unit_type =", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeNotEqualTo(String value) {
            addCriterion("unit_type <>", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeGreaterThan(String value) {
            addCriterion("unit_type >", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeGreaterThanOrEqualTo(String value) {
            addCriterion("unit_type >=", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeLessThan(String value) {
            addCriterion("unit_type <", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeLessThanOrEqualTo(String value) {
            addCriterion("unit_type <=", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeLike(String value) {
            addCriterion("unit_type like", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeNotLike(String value) {
            addCriterion("unit_type not like", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeIn(List<String> values) {
            addCriterion("unit_type in", values, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeNotIn(List<String> values) {
            addCriterion("unit_type not in", values, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeBetween(String value1, String value2) {
            addCriterion("unit_type between", value1, value2, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeNotBetween(String value1, String value2) {
            addCriterion("unit_type not between", value1, value2, "unitType");
            return (Criteria) this;
        }

        public Criteria andInstituteNameIsNull() {
            addCriterion("institute_name is null");
            return (Criteria) this;
        }

        public Criteria andInstituteNameIsNotNull() {
            addCriterion("institute_name is not null");
            return (Criteria) this;
        }

        public Criteria andInstituteNameEqualTo(String value) {
            addCriterion("institute_name =", value, "instituteName");
            return (Criteria) this;
        }

        public Criteria andInstituteNameNotEqualTo(String value) {
            addCriterion("institute_name <>", value, "instituteName");
            return (Criteria) this;
        }

        public Criteria andInstituteNameGreaterThan(String value) {
            addCriterion("institute_name >", value, "instituteName");
            return (Criteria) this;
        }

        public Criteria andInstituteNameGreaterThanOrEqualTo(String value) {
            addCriterion("institute_name >=", value, "instituteName");
            return (Criteria) this;
        }

        public Criteria andInstituteNameLessThan(String value) {
            addCriterion("institute_name <", value, "instituteName");
            return (Criteria) this;
        }

        public Criteria andInstituteNameLessThanOrEqualTo(String value) {
            addCriterion("institute_name <=", value, "instituteName");
            return (Criteria) this;
        }

        public Criteria andInstituteNameLike(String value) {
            addCriterion("institute_name like", value, "instituteName");
            return (Criteria) this;
        }

        public Criteria andInstituteNameNotLike(String value) {
            addCriterion("institute_name not like", value, "instituteName");
            return (Criteria) this;
        }

        public Criteria andInstituteNameIn(List<String> values) {
            addCriterion("institute_name in", values, "instituteName");
            return (Criteria) this;
        }

        public Criteria andInstituteNameNotIn(List<String> values) {
            addCriterion("institute_name not in", values, "instituteName");
            return (Criteria) this;
        }

        public Criteria andInstituteNameBetween(String value1, String value2) {
            addCriterion("institute_name between", value1, value2, "instituteName");
            return (Criteria) this;
        }

        public Criteria andInstituteNameNotBetween(String value1, String value2) {
            addCriterion("institute_name not between", value1, value2, "instituteName");
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

        public Criteria andOutUnitCodeIsNull() {
            addCriterion("out_unit_code is null");
            return (Criteria) this;
        }

        public Criteria andOutUnitCodeIsNotNull() {
            addCriterion("out_unit_code is not null");
            return (Criteria) this;
        }

        public Criteria andOutUnitCodeEqualTo(String value) {
            addCriterion("out_unit_code =", value, "outUnitCode");
            return (Criteria) this;
        }

        public Criteria andOutUnitCodeNotEqualTo(String value) {
            addCriterion("out_unit_code <>", value, "outUnitCode");
            return (Criteria) this;
        }

        public Criteria andOutUnitCodeGreaterThan(String value) {
            addCriterion("out_unit_code >", value, "outUnitCode");
            return (Criteria) this;
        }

        public Criteria andOutUnitCodeGreaterThanOrEqualTo(String value) {
            addCriterion("out_unit_code >=", value, "outUnitCode");
            return (Criteria) this;
        }

        public Criteria andOutUnitCodeLessThan(String value) {
            addCriterion("out_unit_code <", value, "outUnitCode");
            return (Criteria) this;
        }

        public Criteria andOutUnitCodeLessThanOrEqualTo(String value) {
            addCriterion("out_unit_code <=", value, "outUnitCode");
            return (Criteria) this;
        }

        public Criteria andOutUnitCodeLike(String value) {
            addCriterion("out_unit_code like", value, "outUnitCode");
            return (Criteria) this;
        }

        public Criteria andOutUnitCodeNotLike(String value) {
            addCriterion("out_unit_code not like", value, "outUnitCode");
            return (Criteria) this;
        }

        public Criteria andOutUnitCodeIn(List<String> values) {
            addCriterion("out_unit_code in", values, "outUnitCode");
            return (Criteria) this;
        }

        public Criteria andOutUnitCodeNotIn(List<String> values) {
            addCriterion("out_unit_code not in", values, "outUnitCode");
            return (Criteria) this;
        }

        public Criteria andOutUnitCodeBetween(String value1, String value2) {
            addCriterion("out_unit_code between", value1, value2, "outUnitCode");
            return (Criteria) this;
        }

        public Criteria andOutUnitCodeNotBetween(String value1, String value2) {
            addCriterion("out_unit_code not between", value1, value2, "outUnitCode");
            return (Criteria) this;
        }

        public Criteria andUnitAddressIsNull() {
            addCriterion("unit_address is null");
            return (Criteria) this;
        }

        public Criteria andUnitAddressIsNotNull() {
            addCriterion("unit_address is not null");
            return (Criteria) this;
        }

        public Criteria andUnitAddressEqualTo(String value) {
            addCriterion("unit_address =", value, "unitAddress");
            return (Criteria) this;
        }

        public Criteria andUnitAddressNotEqualTo(String value) {
            addCriterion("unit_address <>", value, "unitAddress");
            return (Criteria) this;
        }

        public Criteria andUnitAddressGreaterThan(String value) {
            addCriterion("unit_address >", value, "unitAddress");
            return (Criteria) this;
        }

        public Criteria andUnitAddressGreaterThanOrEqualTo(String value) {
            addCriterion("unit_address >=", value, "unitAddress");
            return (Criteria) this;
        }

        public Criteria andUnitAddressLessThan(String value) {
            addCriterion("unit_address <", value, "unitAddress");
            return (Criteria) this;
        }

        public Criteria andUnitAddressLessThanOrEqualTo(String value) {
            addCriterion("unit_address <=", value, "unitAddress");
            return (Criteria) this;
        }

        public Criteria andUnitAddressLike(String value) {
            addCriterion("unit_address like", value, "unitAddress");
            return (Criteria) this;
        }

        public Criteria andUnitAddressNotLike(String value) {
            addCriterion("unit_address not like", value, "unitAddress");
            return (Criteria) this;
        }

        public Criteria andUnitAddressIn(List<String> values) {
            addCriterion("unit_address in", values, "unitAddress");
            return (Criteria) this;
        }

        public Criteria andUnitAddressNotIn(List<String> values) {
            addCriterion("unit_address not in", values, "unitAddress");
            return (Criteria) this;
        }

        public Criteria andUnitAddressBetween(String value1, String value2) {
            addCriterion("unit_address between", value1, value2, "unitAddress");
            return (Criteria) this;
        }

        public Criteria andUnitAddressNotBetween(String value1, String value2) {
            addCriterion("unit_address not between", value1, value2, "unitAddress");
            return (Criteria) this;
        }

        public Criteria andPostCodeIsNull() {
            addCriterion("post_code is null");
            return (Criteria) this;
        }

        public Criteria andPostCodeIsNotNull() {
            addCriterion("post_code is not null");
            return (Criteria) this;
        }

        public Criteria andPostCodeEqualTo(String value) {
            addCriterion("post_code =", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeNotEqualTo(String value) {
            addCriterion("post_code <>", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeGreaterThan(String value) {
            addCriterion("post_code >", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeGreaterThanOrEqualTo(String value) {
            addCriterion("post_code >=", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeLessThan(String value) {
            addCriterion("post_code <", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeLessThanOrEqualTo(String value) {
            addCriterion("post_code <=", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeLike(String value) {
            addCriterion("post_code like", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeNotLike(String value) {
            addCriterion("post_code not like", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeIn(List<String> values) {
            addCriterion("post_code in", values, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeNotIn(List<String> values) {
            addCriterion("post_code not in", values, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeBetween(String value1, String value2) {
            addCriterion("post_code between", value1, value2, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeNotBetween(String value1, String value2) {
            addCriterion("post_code not between", value1, value2, "postCode");
            return (Criteria) this;
        }

        public Criteria andSuperLeaderNameIsNull() {
            addCriterion("super_leader_name is null");
            return (Criteria) this;
        }

        public Criteria andSuperLeaderNameIsNotNull() {
            addCriterion("super_leader_name is not null");
            return (Criteria) this;
        }

        public Criteria andSuperLeaderNameEqualTo(String value) {
            addCriterion("super_leader_name =", value, "superLeaderName");
            return (Criteria) this;
        }

        public Criteria andSuperLeaderNameNotEqualTo(String value) {
            addCriterion("super_leader_name <>", value, "superLeaderName");
            return (Criteria) this;
        }

        public Criteria andSuperLeaderNameGreaterThan(String value) {
            addCriterion("super_leader_name >", value, "superLeaderName");
            return (Criteria) this;
        }

        public Criteria andSuperLeaderNameGreaterThanOrEqualTo(String value) {
            addCriterion("super_leader_name >=", value, "superLeaderName");
            return (Criteria) this;
        }

        public Criteria andSuperLeaderNameLessThan(String value) {
            addCriterion("super_leader_name <", value, "superLeaderName");
            return (Criteria) this;
        }

        public Criteria andSuperLeaderNameLessThanOrEqualTo(String value) {
            addCriterion("super_leader_name <=", value, "superLeaderName");
            return (Criteria) this;
        }

        public Criteria andSuperLeaderNameLike(String value) {
            addCriterion("super_leader_name like", value, "superLeaderName");
            return (Criteria) this;
        }

        public Criteria andSuperLeaderNameNotLike(String value) {
            addCriterion("super_leader_name not like", value, "superLeaderName");
            return (Criteria) this;
        }

        public Criteria andSuperLeaderNameIn(List<String> values) {
            addCriterion("super_leader_name in", values, "superLeaderName");
            return (Criteria) this;
        }

        public Criteria andSuperLeaderNameNotIn(List<String> values) {
            addCriterion("super_leader_name not in", values, "superLeaderName");
            return (Criteria) this;
        }

        public Criteria andSuperLeaderNameBetween(String value1, String value2) {
            addCriterion("super_leader_name between", value1, value2, "superLeaderName");
            return (Criteria) this;
        }

        public Criteria andSuperLeaderNameNotBetween(String value1, String value2) {
            addCriterion("super_leader_name not between", value1, value2, "superLeaderName");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNull() {
            addCriterion("bank_name is null");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNotNull() {
            addCriterion("bank_name is not null");
            return (Criteria) this;
        }

        public Criteria andBankNameEqualTo(String value) {
            addCriterion("bank_name =", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotEqualTo(String value) {
            addCriterion("bank_name <>", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThan(String value) {
            addCriterion("bank_name >", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("bank_name >=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThan(String value) {
            addCriterion("bank_name <", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThanOrEqualTo(String value) {
            addCriterion("bank_name <=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLike(String value) {
            addCriterion("bank_name like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotLike(String value) {
            addCriterion("bank_name not like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameIn(List<String> values) {
            addCriterion("bank_name in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotIn(List<String> values) {
            addCriterion("bank_name not in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameBetween(String value1, String value2) {
            addCriterion("bank_name between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotBetween(String value1, String value2) {
            addCriterion("bank_name not between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNull() {
            addCriterion("bank_account is null");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNotNull() {
            addCriterion("bank_account is not null");
            return (Criteria) this;
        }

        public Criteria andBankAccountEqualTo(String value) {
            addCriterion("bank_account =", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotEqualTo(String value) {
            addCriterion("bank_account <>", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThan(String value) {
            addCriterion("bank_account >", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThanOrEqualTo(String value) {
            addCriterion("bank_account >=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThan(String value) {
            addCriterion("bank_account <", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThanOrEqualTo(String value) {
            addCriterion("bank_account <=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLike(String value) {
            addCriterion("bank_account like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotLike(String value) {
            addCriterion("bank_account not like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountIn(List<String> values) {
            addCriterion("bank_account in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotIn(List<String> values) {
            addCriterion("bank_account not in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountBetween(String value1, String value2) {
            addCriterion("bank_account between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotBetween(String value1, String value2) {
            addCriterion("bank_account not between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andOutUnitTypeIsNull() {
            addCriterion("out_unit_type is null");
            return (Criteria) this;
        }

        public Criteria andOutUnitTypeIsNotNull() {
            addCriterion("out_unit_type is not null");
            return (Criteria) this;
        }

        public Criteria andOutUnitTypeEqualTo(String value) {
            addCriterion("out_unit_type =", value, "outUnitType");
            return (Criteria) this;
        }

        public Criteria andOutUnitTypeNotEqualTo(String value) {
            addCriterion("out_unit_type <>", value, "outUnitType");
            return (Criteria) this;
        }

        public Criteria andOutUnitTypeGreaterThan(String value) {
            addCriterion("out_unit_type >", value, "outUnitType");
            return (Criteria) this;
        }

        public Criteria andOutUnitTypeGreaterThanOrEqualTo(String value) {
            addCriterion("out_unit_type >=", value, "outUnitType");
            return (Criteria) this;
        }

        public Criteria andOutUnitTypeLessThan(String value) {
            addCriterion("out_unit_type <", value, "outUnitType");
            return (Criteria) this;
        }

        public Criteria andOutUnitTypeLessThanOrEqualTo(String value) {
            addCriterion("out_unit_type <=", value, "outUnitType");
            return (Criteria) this;
        }

        public Criteria andOutUnitTypeLike(String value) {
            addCriterion("out_unit_type like", value, "outUnitType");
            return (Criteria) this;
        }

        public Criteria andOutUnitTypeNotLike(String value) {
            addCriterion("out_unit_type not like", value, "outUnitType");
            return (Criteria) this;
        }

        public Criteria andOutUnitTypeIn(List<String> values) {
            addCriterion("out_unit_type in", values, "outUnitType");
            return (Criteria) this;
        }

        public Criteria andOutUnitTypeNotIn(List<String> values) {
            addCriterion("out_unit_type not in", values, "outUnitType");
            return (Criteria) this;
        }

        public Criteria andOutUnitTypeBetween(String value1, String value2) {
            addCriterion("out_unit_type between", value1, value2, "outUnitType");
            return (Criteria) this;
        }

        public Criteria andOutUnitTypeNotBetween(String value1, String value2) {
            addCriterion("out_unit_type not between", value1, value2, "outUnitType");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderNameIsNull() {
            addCriterion("project_leader_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderNameIsNotNull() {
            addCriterion("project_leader_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderNameEqualTo(String value) {
            addCriterion("project_leader_name =", value, "projectLeaderName");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderNameNotEqualTo(String value) {
            addCriterion("project_leader_name <>", value, "projectLeaderName");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderNameGreaterThan(String value) {
            addCriterion("project_leader_name >", value, "projectLeaderName");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_leader_name >=", value, "projectLeaderName");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderNameLessThan(String value) {
            addCriterion("project_leader_name <", value, "projectLeaderName");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderNameLessThanOrEqualTo(String value) {
            addCriterion("project_leader_name <=", value, "projectLeaderName");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderNameLike(String value) {
            addCriterion("project_leader_name like", value, "projectLeaderName");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderNameNotLike(String value) {
            addCriterion("project_leader_name not like", value, "projectLeaderName");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderNameIn(List<String> values) {
            addCriterion("project_leader_name in", values, "projectLeaderName");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderNameNotIn(List<String> values) {
            addCriterion("project_leader_name not in", values, "projectLeaderName");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderNameBetween(String value1, String value2) {
            addCriterion("project_leader_name between", value1, value2, "projectLeaderName");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderNameNotBetween(String value1, String value2) {
            addCriterion("project_leader_name not between", value1, value2, "projectLeaderName");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderPostIsNull() {
            addCriterion("project_leader_post is null");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderPostIsNotNull() {
            addCriterion("project_leader_post is not null");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderPostEqualTo(String value) {
            addCriterion("project_leader_post =", value, "projectLeaderPost");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderPostNotEqualTo(String value) {
            addCriterion("project_leader_post <>", value, "projectLeaderPost");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderPostGreaterThan(String value) {
            addCriterion("project_leader_post >", value, "projectLeaderPost");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderPostGreaterThanOrEqualTo(String value) {
            addCriterion("project_leader_post >=", value, "projectLeaderPost");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderPostLessThan(String value) {
            addCriterion("project_leader_post <", value, "projectLeaderPost");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderPostLessThanOrEqualTo(String value) {
            addCriterion("project_leader_post <=", value, "projectLeaderPost");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderPostLike(String value) {
            addCriterion("project_leader_post like", value, "projectLeaderPost");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderPostNotLike(String value) {
            addCriterion("project_leader_post not like", value, "projectLeaderPost");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderPostIn(List<String> values) {
            addCriterion("project_leader_post in", values, "projectLeaderPost");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderPostNotIn(List<String> values) {
            addCriterion("project_leader_post not in", values, "projectLeaderPost");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderPostBetween(String value1, String value2) {
            addCriterion("project_leader_post between", value1, value2, "projectLeaderPost");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderPostNotBetween(String value1, String value2) {
            addCriterion("project_leader_post not between", value1, value2, "projectLeaderPost");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderPhoneIsNull() {
            addCriterion("project_leader_phone is null");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderPhoneIsNotNull() {
            addCriterion("project_leader_phone is not null");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderPhoneEqualTo(String value) {
            addCriterion("project_leader_phone =", value, "projectLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderPhoneNotEqualTo(String value) {
            addCriterion("project_leader_phone <>", value, "projectLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderPhoneGreaterThan(String value) {
            addCriterion("project_leader_phone >", value, "projectLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("project_leader_phone >=", value, "projectLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderPhoneLessThan(String value) {
            addCriterion("project_leader_phone <", value, "projectLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderPhoneLessThanOrEqualTo(String value) {
            addCriterion("project_leader_phone <=", value, "projectLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderPhoneLike(String value) {
            addCriterion("project_leader_phone like", value, "projectLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderPhoneNotLike(String value) {
            addCriterion("project_leader_phone not like", value, "projectLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderPhoneIn(List<String> values) {
            addCriterion("project_leader_phone in", values, "projectLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderPhoneNotIn(List<String> values) {
            addCriterion("project_leader_phone not in", values, "projectLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderPhoneBetween(String value1, String value2) {
            addCriterion("project_leader_phone between", value1, value2, "projectLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderPhoneNotBetween(String value1, String value2) {
            addCriterion("project_leader_phone not between", value1, value2, "projectLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderEmailIsNull() {
            addCriterion("project_leader_email is null");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderEmailIsNotNull() {
            addCriterion("project_leader_email is not null");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderEmailEqualTo(String value) {
            addCriterion("project_leader_email =", value, "projectLeaderEmail");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderEmailNotEqualTo(String value) {
            addCriterion("project_leader_email <>", value, "projectLeaderEmail");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderEmailGreaterThan(String value) {
            addCriterion("project_leader_email >", value, "projectLeaderEmail");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderEmailGreaterThanOrEqualTo(String value) {
            addCriterion("project_leader_email >=", value, "projectLeaderEmail");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderEmailLessThan(String value) {
            addCriterion("project_leader_email <", value, "projectLeaderEmail");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderEmailLessThanOrEqualTo(String value) {
            addCriterion("project_leader_email <=", value, "projectLeaderEmail");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderEmailLike(String value) {
            addCriterion("project_leader_email like", value, "projectLeaderEmail");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderEmailNotLike(String value) {
            addCriterion("project_leader_email not like", value, "projectLeaderEmail");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderEmailIn(List<String> values) {
            addCriterion("project_leader_email in", values, "projectLeaderEmail");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderEmailNotIn(List<String> values) {
            addCriterion("project_leader_email not in", values, "projectLeaderEmail");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderEmailBetween(String value1, String value2) {
            addCriterion("project_leader_email between", value1, value2, "projectLeaderEmail");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderEmailNotBetween(String value1, String value2) {
            addCriterion("project_leader_email not between", value1, value2, "projectLeaderEmail");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderNameIsNull() {
            addCriterion("payment_leader_name is null");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderNameIsNotNull() {
            addCriterion("payment_leader_name is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderNameEqualTo(String value) {
            addCriterion("payment_leader_name =", value, "paymentLeaderName");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderNameNotEqualTo(String value) {
            addCriterion("payment_leader_name <>", value, "paymentLeaderName");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderNameGreaterThan(String value) {
            addCriterion("payment_leader_name >", value, "paymentLeaderName");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderNameGreaterThanOrEqualTo(String value) {
            addCriterion("payment_leader_name >=", value, "paymentLeaderName");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderNameLessThan(String value) {
            addCriterion("payment_leader_name <", value, "paymentLeaderName");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderNameLessThanOrEqualTo(String value) {
            addCriterion("payment_leader_name <=", value, "paymentLeaderName");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderNameLike(String value) {
            addCriterion("payment_leader_name like", value, "paymentLeaderName");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderNameNotLike(String value) {
            addCriterion("payment_leader_name not like", value, "paymentLeaderName");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderNameIn(List<String> values) {
            addCriterion("payment_leader_name in", values, "paymentLeaderName");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderNameNotIn(List<String> values) {
            addCriterion("payment_leader_name not in", values, "paymentLeaderName");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderNameBetween(String value1, String value2) {
            addCriterion("payment_leader_name between", value1, value2, "paymentLeaderName");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderNameNotBetween(String value1, String value2) {
            addCriterion("payment_leader_name not between", value1, value2, "paymentLeaderName");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderPostIsNull() {
            addCriterion("payment_leader_post is null");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderPostIsNotNull() {
            addCriterion("payment_leader_post is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderPostEqualTo(String value) {
            addCriterion("payment_leader_post =", value, "paymentLeaderPost");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderPostNotEqualTo(String value) {
            addCriterion("payment_leader_post <>", value, "paymentLeaderPost");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderPostGreaterThan(String value) {
            addCriterion("payment_leader_post >", value, "paymentLeaderPost");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderPostGreaterThanOrEqualTo(String value) {
            addCriterion("payment_leader_post >=", value, "paymentLeaderPost");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderPostLessThan(String value) {
            addCriterion("payment_leader_post <", value, "paymentLeaderPost");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderPostLessThanOrEqualTo(String value) {
            addCriterion("payment_leader_post <=", value, "paymentLeaderPost");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderPostLike(String value) {
            addCriterion("payment_leader_post like", value, "paymentLeaderPost");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderPostNotLike(String value) {
            addCriterion("payment_leader_post not like", value, "paymentLeaderPost");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderPostIn(List<String> values) {
            addCriterion("payment_leader_post in", values, "paymentLeaderPost");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderPostNotIn(List<String> values) {
            addCriterion("payment_leader_post not in", values, "paymentLeaderPost");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderPostBetween(String value1, String value2) {
            addCriterion("payment_leader_post between", value1, value2, "paymentLeaderPost");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderPostNotBetween(String value1, String value2) {
            addCriterion("payment_leader_post not between", value1, value2, "paymentLeaderPost");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderPhoneIsNull() {
            addCriterion("payment_leader_phone is null");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderPhoneIsNotNull() {
            addCriterion("payment_leader_phone is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderPhoneEqualTo(String value) {
            addCriterion("payment_leader_phone =", value, "paymentLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderPhoneNotEqualTo(String value) {
            addCriterion("payment_leader_phone <>", value, "paymentLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderPhoneGreaterThan(String value) {
            addCriterion("payment_leader_phone >", value, "paymentLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("payment_leader_phone >=", value, "paymentLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderPhoneLessThan(String value) {
            addCriterion("payment_leader_phone <", value, "paymentLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderPhoneLessThanOrEqualTo(String value) {
            addCriterion("payment_leader_phone <=", value, "paymentLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderPhoneLike(String value) {
            addCriterion("payment_leader_phone like", value, "paymentLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderPhoneNotLike(String value) {
            addCriterion("payment_leader_phone not like", value, "paymentLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderPhoneIn(List<String> values) {
            addCriterion("payment_leader_phone in", values, "paymentLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderPhoneNotIn(List<String> values) {
            addCriterion("payment_leader_phone not in", values, "paymentLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderPhoneBetween(String value1, String value2) {
            addCriterion("payment_leader_phone between", value1, value2, "paymentLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderPhoneNotBetween(String value1, String value2) {
            addCriterion("payment_leader_phone not between", value1, value2, "paymentLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderEmailIsNull() {
            addCriterion("payment_leader_email is null");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderEmailIsNotNull() {
            addCriterion("payment_leader_email is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderEmailEqualTo(String value) {
            addCriterion("payment_leader_email =", value, "paymentLeaderEmail");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderEmailNotEqualTo(String value) {
            addCriterion("payment_leader_email <>", value, "paymentLeaderEmail");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderEmailGreaterThan(String value) {
            addCriterion("payment_leader_email >", value, "paymentLeaderEmail");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderEmailGreaterThanOrEqualTo(String value) {
            addCriterion("payment_leader_email >=", value, "paymentLeaderEmail");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderEmailLessThan(String value) {
            addCriterion("payment_leader_email <", value, "paymentLeaderEmail");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderEmailLessThanOrEqualTo(String value) {
            addCriterion("payment_leader_email <=", value, "paymentLeaderEmail");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderEmailLike(String value) {
            addCriterion("payment_leader_email like", value, "paymentLeaderEmail");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderEmailNotLike(String value) {
            addCriterion("payment_leader_email not like", value, "paymentLeaderEmail");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderEmailIn(List<String> values) {
            addCriterion("payment_leader_email in", values, "paymentLeaderEmail");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderEmailNotIn(List<String> values) {
            addCriterion("payment_leader_email not in", values, "paymentLeaderEmail");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderEmailBetween(String value1, String value2) {
            addCriterion("payment_leader_email between", value1, value2, "paymentLeaderEmail");
            return (Criteria) this;
        }

        public Criteria andPaymentLeaderEmailNotBetween(String value1, String value2) {
            addCriterion("payment_leader_email not between", value1, value2, "paymentLeaderEmail");
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

        public Criteria andDefine7IsNull() {
            addCriterion("define7 is null");
            return (Criteria) this;
        }

        public Criteria andDefine7IsNotNull() {
            addCriterion("define7 is not null");
            return (Criteria) this;
        }

        public Criteria andDefine7EqualTo(String value) {
            addCriterion("define7 =", value, "define7");
            return (Criteria) this;
        }

        public Criteria andDefine7NotEqualTo(String value) {
            addCriterion("define7 <>", value, "define7");
            return (Criteria) this;
        }

        public Criteria andDefine7GreaterThan(String value) {
            addCriterion("define7 >", value, "define7");
            return (Criteria) this;
        }

        public Criteria andDefine7GreaterThanOrEqualTo(String value) {
            addCriterion("define7 >=", value, "define7");
            return (Criteria) this;
        }

        public Criteria andDefine7LessThan(String value) {
            addCriterion("define7 <", value, "define7");
            return (Criteria) this;
        }

        public Criteria andDefine7LessThanOrEqualTo(String value) {
            addCriterion("define7 <=", value, "define7");
            return (Criteria) this;
        }

        public Criteria andDefine7Like(String value) {
            addCriterion("define7 like", value, "define7");
            return (Criteria) this;
        }

        public Criteria andDefine7NotLike(String value) {
            addCriterion("define7 not like", value, "define7");
            return (Criteria) this;
        }

        public Criteria andDefine7In(List<String> values) {
            addCriterion("define7 in", values, "define7");
            return (Criteria) this;
        }

        public Criteria andDefine7NotIn(List<String> values) {
            addCriterion("define7 not in", values, "define7");
            return (Criteria) this;
        }

        public Criteria andDefine7Between(String value1, String value2) {
            addCriterion("define7 between", value1, value2, "define7");
            return (Criteria) this;
        }

        public Criteria andDefine7NotBetween(String value1, String value2) {
            addCriterion("define7 not between", value1, value2, "define7");
            return (Criteria) this;
        }

        public Criteria andDefine8IsNull() {
            addCriterion("define8 is null");
            return (Criteria) this;
        }

        public Criteria andDefine8IsNotNull() {
            addCriterion("define8 is not null");
            return (Criteria) this;
        }

        public Criteria andDefine8EqualTo(String value) {
            addCriterion("define8 =", value, "define8");
            return (Criteria) this;
        }

        public Criteria andDefine8NotEqualTo(String value) {
            addCriterion("define8 <>", value, "define8");
            return (Criteria) this;
        }

        public Criteria andDefine8GreaterThan(String value) {
            addCriterion("define8 >", value, "define8");
            return (Criteria) this;
        }

        public Criteria andDefine8GreaterThanOrEqualTo(String value) {
            addCriterion("define8 >=", value, "define8");
            return (Criteria) this;
        }

        public Criteria andDefine8LessThan(String value) {
            addCriterion("define8 <", value, "define8");
            return (Criteria) this;
        }

        public Criteria andDefine8LessThanOrEqualTo(String value) {
            addCriterion("define8 <=", value, "define8");
            return (Criteria) this;
        }

        public Criteria andDefine8Like(String value) {
            addCriterion("define8 like", value, "define8");
            return (Criteria) this;
        }

        public Criteria andDefine8NotLike(String value) {
            addCriterion("define8 not like", value, "define8");
            return (Criteria) this;
        }

        public Criteria andDefine8In(List<String> values) {
            addCriterion("define8 in", values, "define8");
            return (Criteria) this;
        }

        public Criteria andDefine8NotIn(List<String> values) {
            addCriterion("define8 not in", values, "define8");
            return (Criteria) this;
        }

        public Criteria andDefine8Between(String value1, String value2) {
            addCriterion("define8 between", value1, value2, "define8");
            return (Criteria) this;
        }

        public Criteria andDefine8NotBetween(String value1, String value2) {
            addCriterion("define8 not between", value1, value2, "define8");
            return (Criteria) this;
        }

        public Criteria andDefine9IsNull() {
            addCriterion("define9 is null");
            return (Criteria) this;
        }

        public Criteria andDefine9IsNotNull() {
            addCriterion("define9 is not null");
            return (Criteria) this;
        }

        public Criteria andDefine9EqualTo(String value) {
            addCriterion("define9 =", value, "define9");
            return (Criteria) this;
        }

        public Criteria andDefine9NotEqualTo(String value) {
            addCriterion("define9 <>", value, "define9");
            return (Criteria) this;
        }

        public Criteria andDefine9GreaterThan(String value) {
            addCriterion("define9 >", value, "define9");
            return (Criteria) this;
        }

        public Criteria andDefine9GreaterThanOrEqualTo(String value) {
            addCriterion("define9 >=", value, "define9");
            return (Criteria) this;
        }

        public Criteria andDefine9LessThan(String value) {
            addCriterion("define9 <", value, "define9");
            return (Criteria) this;
        }

        public Criteria andDefine9LessThanOrEqualTo(String value) {
            addCriterion("define9 <=", value, "define9");
            return (Criteria) this;
        }

        public Criteria andDefine9Like(String value) {
            addCriterion("define9 like", value, "define9");
            return (Criteria) this;
        }

        public Criteria andDefine9NotLike(String value) {
            addCriterion("define9 not like", value, "define9");
            return (Criteria) this;
        }

        public Criteria andDefine9In(List<String> values) {
            addCriterion("define9 in", values, "define9");
            return (Criteria) this;
        }

        public Criteria andDefine9NotIn(List<String> values) {
            addCriterion("define9 not in", values, "define9");
            return (Criteria) this;
        }

        public Criteria andDefine9Between(String value1, String value2) {
            addCriterion("define9 between", value1, value2, "define9");
            return (Criteria) this;
        }

        public Criteria andDefine9NotBetween(String value1, String value2) {
            addCriterion("define9 not between", value1, value2, "define9");
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