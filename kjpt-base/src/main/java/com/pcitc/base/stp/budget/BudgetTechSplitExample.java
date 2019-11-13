package com.pcitc.base.stp.budget;

import java.util.ArrayList;
import java.util.List;

public class BudgetTechSplitExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BudgetTechSplitExample() {
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

        public Criteria andParentDataIdIsNull() {
            addCriterion("parent_data_id is null");
            return (Criteria) this;
        }

        public Criteria andParentDataIdIsNotNull() {
            addCriterion("parent_data_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentDataIdEqualTo(String value) {
            addCriterion("parent_data_id =", value, "parentDataId");
            return (Criteria) this;
        }

        public Criteria andParentDataIdNotEqualTo(String value) {
            addCriterion("parent_data_id <>", value, "parentDataId");
            return (Criteria) this;
        }

        public Criteria andParentDataIdGreaterThan(String value) {
            addCriterion("parent_data_id >", value, "parentDataId");
            return (Criteria) this;
        }

        public Criteria andParentDataIdGreaterThanOrEqualTo(String value) {
            addCriterion("parent_data_id >=", value, "parentDataId");
            return (Criteria) this;
        }

        public Criteria andParentDataIdLessThan(String value) {
            addCriterion("parent_data_id <", value, "parentDataId");
            return (Criteria) this;
        }

        public Criteria andParentDataIdLessThanOrEqualTo(String value) {
            addCriterion("parent_data_id <=", value, "parentDataId");
            return (Criteria) this;
        }

        public Criteria andParentDataIdLike(String value) {
            addCriterion("parent_data_id like", value, "parentDataId");
            return (Criteria) this;
        }

        public Criteria andParentDataIdNotLike(String value) {
            addCriterion("parent_data_id not like", value, "parentDataId");
            return (Criteria) this;
        }

        public Criteria andParentDataIdIn(List<String> values) {
            addCriterion("parent_data_id in", values, "parentDataId");
            return (Criteria) this;
        }

        public Criteria andParentDataIdNotIn(List<String> values) {
            addCriterion("parent_data_id not in", values, "parentDataId");
            return (Criteria) this;
        }

        public Criteria andParentDataIdBetween(String value1, String value2) {
            addCriterion("parent_data_id between", value1, value2, "parentDataId");
            return (Criteria) this;
        }

        public Criteria andParentDataIdNotBetween(String value1, String value2) {
            addCriterion("parent_data_id not between", value1, value2, "parentDataId");
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

        public Criteria andDataVersionIsNull() {
            addCriterion("data_version is null");
            return (Criteria) this;
        }

        public Criteria andDataVersionIsNotNull() {
            addCriterion("data_version is not null");
            return (Criteria) this;
        }

        public Criteria andDataVersionEqualTo(String value) {
            addCriterion("data_version =", value, "dataVersion");
            return (Criteria) this;
        }

        public Criteria andDataVersionNotEqualTo(String value) {
            addCriterion("data_version <>", value, "dataVersion");
            return (Criteria) this;
        }

        public Criteria andDataVersionGreaterThan(String value) {
            addCriterion("data_version >", value, "dataVersion");
            return (Criteria) this;
        }

        public Criteria andDataVersionGreaterThanOrEqualTo(String value) {
            addCriterion("data_version >=", value, "dataVersion");
            return (Criteria) this;
        }

        public Criteria andDataVersionLessThan(String value) {
            addCriterion("data_version <", value, "dataVersion");
            return (Criteria) this;
        }

        public Criteria andDataVersionLessThanOrEqualTo(String value) {
            addCriterion("data_version <=", value, "dataVersion");
            return (Criteria) this;
        }

        public Criteria andDataVersionLike(String value) {
            addCriterion("data_version like", value, "dataVersion");
            return (Criteria) this;
        }

        public Criteria andDataVersionNotLike(String value) {
            addCriterion("data_version not like", value, "dataVersion");
            return (Criteria) this;
        }

        public Criteria andDataVersionIn(List<String> values) {
            addCriterion("data_version in", values, "dataVersion");
            return (Criteria) this;
        }

        public Criteria andDataVersionNotIn(List<String> values) {
            addCriterion("data_version not in", values, "dataVersion");
            return (Criteria) this;
        }

        public Criteria andDataVersionBetween(String value1, String value2) {
            addCriterion("data_version between", value1, value2, "dataVersion");
            return (Criteria) this;
        }

        public Criteria andDataVersionNotBetween(String value1, String value2) {
            addCriterion("data_version not between", value1, value2, "dataVersion");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("create_time like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("create_time not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(String value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(String value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(String value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(String value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(String value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLike(String value) {
            addCriterion("update_time like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotLike(String value) {
            addCriterion("update_time not like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<String> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<String> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(String value1, String value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(String value1, String value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andCreaterNameIsNull() {
            addCriterion("creater_name is null");
            return (Criteria) this;
        }

        public Criteria andCreaterNameIsNotNull() {
            addCriterion("creater_name is not null");
            return (Criteria) this;
        }

        public Criteria andCreaterNameEqualTo(String value) {
            addCriterion("creater_name =", value, "createrName");
            return (Criteria) this;
        }

        public Criteria andCreaterNameNotEqualTo(String value) {
            addCriterion("creater_name <>", value, "createrName");
            return (Criteria) this;
        }

        public Criteria andCreaterNameGreaterThan(String value) {
            addCriterion("creater_name >", value, "createrName");
            return (Criteria) this;
        }

        public Criteria andCreaterNameGreaterThanOrEqualTo(String value) {
            addCriterion("creater_name >=", value, "createrName");
            return (Criteria) this;
        }

        public Criteria andCreaterNameLessThan(String value) {
            addCriterion("creater_name <", value, "createrName");
            return (Criteria) this;
        }

        public Criteria andCreaterNameLessThanOrEqualTo(String value) {
            addCriterion("creater_name <=", value, "createrName");
            return (Criteria) this;
        }

        public Criteria andCreaterNameLike(String value) {
            addCriterion("creater_name like", value, "createrName");
            return (Criteria) this;
        }

        public Criteria andCreaterNameNotLike(String value) {
            addCriterion("creater_name not like", value, "createrName");
            return (Criteria) this;
        }

        public Criteria andCreaterNameIn(List<String> values) {
            addCriterion("creater_name in", values, "createrName");
            return (Criteria) this;
        }

        public Criteria andCreaterNameNotIn(List<String> values) {
            addCriterion("creater_name not in", values, "createrName");
            return (Criteria) this;
        }

        public Criteria andCreaterNameBetween(String value1, String value2) {
            addCriterion("creater_name between", value1, value2, "createrName");
            return (Criteria) this;
        }

        public Criteria andCreaterNameNotBetween(String value1, String value2) {
            addCriterion("creater_name not between", value1, value2, "createrName");
            return (Criteria) this;
        }

        public Criteria andCreaterIdIsNull() {
            addCriterion("creater_id is null");
            return (Criteria) this;
        }

        public Criteria andCreaterIdIsNotNull() {
            addCriterion("creater_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreaterIdEqualTo(String value) {
            addCriterion("creater_id =", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdNotEqualTo(String value) {
            addCriterion("creater_id <>", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdGreaterThan(String value) {
            addCriterion("creater_id >", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdGreaterThanOrEqualTo(String value) {
            addCriterion("creater_id >=", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdLessThan(String value) {
            addCriterion("creater_id <", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdLessThanOrEqualTo(String value) {
            addCriterion("creater_id <=", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdLike(String value) {
            addCriterion("creater_id like", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdNotLike(String value) {
            addCriterion("creater_id not like", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdIn(List<String> values) {
            addCriterion("creater_id in", values, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdNotIn(List<String> values) {
            addCriterion("creater_id not in", values, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdBetween(String value1, String value2) {
            addCriterion("creater_id between", value1, value2, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdNotBetween(String value1, String value2) {
            addCriterion("creater_id not between", value1, value2, "createrId");
            return (Criteria) this;
        }

        public Criteria andNoIsNull() {
            addCriterion("no is null");
            return (Criteria) this;
        }

        public Criteria andNoIsNotNull() {
            addCriterion("no is not null");
            return (Criteria) this;
        }

        public Criteria andNoEqualTo(Integer value) {
            addCriterion("no =", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotEqualTo(Integer value) {
            addCriterion("no <>", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoGreaterThan(Integer value) {
            addCriterion("no >", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("no >=", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoLessThan(Integer value) {
            addCriterion("no <", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoLessThanOrEqualTo(Integer value) {
            addCriterion("no <=", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoIn(List<Integer> values) {
            addCriterion("no in", values, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotIn(List<Integer> values) {
            addCriterion("no not in", values, "no");
            return (Criteria) this;
        }

        public Criteria andNoBetween(Integer value1, Integer value2) {
            addCriterion("no between", value1, value2, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotBetween(Integer value1, Integer value2) {
            addCriterion("no not between", value1, value2, "no");
            return (Criteria) this;
        }

        public Criteria andDisplayNameIsNull() {
            addCriterion("display_name is null");
            return (Criteria) this;
        }

        public Criteria andDisplayNameIsNotNull() {
            addCriterion("display_name is not null");
            return (Criteria) this;
        }

        public Criteria andDisplayNameEqualTo(String value) {
            addCriterion("display_name =", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameNotEqualTo(String value) {
            addCriterion("display_name <>", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameGreaterThan(String value) {
            addCriterion("display_name >", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameGreaterThanOrEqualTo(String value) {
            addCriterion("display_name >=", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameLessThan(String value) {
            addCriterion("display_name <", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameLessThanOrEqualTo(String value) {
            addCriterion("display_name <=", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameLike(String value) {
            addCriterion("display_name like", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameNotLike(String value) {
            addCriterion("display_name not like", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameIn(List<String> values) {
            addCriterion("display_name in", values, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameNotIn(List<String> values) {
            addCriterion("display_name not in", values, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameBetween(String value1, String value2) {
            addCriterion("display_name between", value1, value2, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameNotBetween(String value1, String value2) {
            addCriterion("display_name not between", value1, value2, "displayName");
            return (Criteria) this;
        }

        public Criteria andSimpleNameIsNull() {
            addCriterion("simple_name is null");
            return (Criteria) this;
        }

        public Criteria andSimpleNameIsNotNull() {
            addCriterion("simple_name is not null");
            return (Criteria) this;
        }

        public Criteria andSimpleNameEqualTo(String value) {
            addCriterion("simple_name =", value, "simpleName");
            return (Criteria) this;
        }

        public Criteria andSimpleNameNotEqualTo(String value) {
            addCriterion("simple_name <>", value, "simpleName");
            return (Criteria) this;
        }

        public Criteria andSimpleNameGreaterThan(String value) {
            addCriterion("simple_name >", value, "simpleName");
            return (Criteria) this;
        }

        public Criteria andSimpleNameGreaterThanOrEqualTo(String value) {
            addCriterion("simple_name >=", value, "simpleName");
            return (Criteria) this;
        }

        public Criteria andSimpleNameLessThan(String value) {
            addCriterion("simple_name <", value, "simpleName");
            return (Criteria) this;
        }

        public Criteria andSimpleNameLessThanOrEqualTo(String value) {
            addCriterion("simple_name <=", value, "simpleName");
            return (Criteria) this;
        }

        public Criteria andSimpleNameLike(String value) {
            addCriterion("simple_name like", value, "simpleName");
            return (Criteria) this;
        }

        public Criteria andSimpleNameNotLike(String value) {
            addCriterion("simple_name not like", value, "simpleName");
            return (Criteria) this;
        }

        public Criteria andSimpleNameIn(List<String> values) {
            addCriterion("simple_name in", values, "simpleName");
            return (Criteria) this;
        }

        public Criteria andSimpleNameNotIn(List<String> values) {
            addCriterion("simple_name not in", values, "simpleName");
            return (Criteria) this;
        }

        public Criteria andSimpleNameBetween(String value1, String value2) {
            addCriterion("simple_name between", value1, value2, "simpleName");
            return (Criteria) this;
        }

        public Criteria andSimpleNameNotBetween(String value1, String value2) {
            addCriterion("simple_name not between", value1, value2, "simpleName");
            return (Criteria) this;
        }

        public Criteria andDisplayCodeIsNull() {
            addCriterion("display_code is null");
            return (Criteria) this;
        }

        public Criteria andDisplayCodeIsNotNull() {
            addCriterion("display_code is not null");
            return (Criteria) this;
        }

        public Criteria andDisplayCodeEqualTo(String value) {
            addCriterion("display_code =", value, "displayCode");
            return (Criteria) this;
        }

        public Criteria andDisplayCodeNotEqualTo(String value) {
            addCriterion("display_code <>", value, "displayCode");
            return (Criteria) this;
        }

        public Criteria andDisplayCodeGreaterThan(String value) {
            addCriterion("display_code >", value, "displayCode");
            return (Criteria) this;
        }

        public Criteria andDisplayCodeGreaterThanOrEqualTo(String value) {
            addCriterion("display_code >=", value, "displayCode");
            return (Criteria) this;
        }

        public Criteria andDisplayCodeLessThan(String value) {
            addCriterion("display_code <", value, "displayCode");
            return (Criteria) this;
        }

        public Criteria andDisplayCodeLessThanOrEqualTo(String value) {
            addCriterion("display_code <=", value, "displayCode");
            return (Criteria) this;
        }

        public Criteria andDisplayCodeLike(String value) {
            addCriterion("display_code like", value, "displayCode");
            return (Criteria) this;
        }

        public Criteria andDisplayCodeNotLike(String value) {
            addCriterion("display_code not like", value, "displayCode");
            return (Criteria) this;
        }

        public Criteria andDisplayCodeIn(List<String> values) {
            addCriterion("display_code in", values, "displayCode");
            return (Criteria) this;
        }

        public Criteria andDisplayCodeNotIn(List<String> values) {
            addCriterion("display_code not in", values, "displayCode");
            return (Criteria) this;
        }

        public Criteria andDisplayCodeBetween(String value1, String value2) {
            addCriterion("display_code between", value1, value2, "displayCode");
            return (Criteria) this;
        }

        public Criteria andDisplayCodeNotBetween(String value1, String value2) {
            addCriterion("display_code not between", value1, value2, "displayCode");
            return (Criteria) this;
        }

        public Criteria andSimpleCodeIsNull() {
            addCriterion("simple_code is null");
            return (Criteria) this;
        }

        public Criteria andSimpleCodeIsNotNull() {
            addCriterion("simple_code is not null");
            return (Criteria) this;
        }

        public Criteria andSimpleCodeEqualTo(String value) {
            addCriterion("simple_code =", value, "simpleCode");
            return (Criteria) this;
        }

        public Criteria andSimpleCodeNotEqualTo(String value) {
            addCriterion("simple_code <>", value, "simpleCode");
            return (Criteria) this;
        }

        public Criteria andSimpleCodeGreaterThan(String value) {
            addCriterion("simple_code >", value, "simpleCode");
            return (Criteria) this;
        }

        public Criteria andSimpleCodeGreaterThanOrEqualTo(String value) {
            addCriterion("simple_code >=", value, "simpleCode");
            return (Criteria) this;
        }

        public Criteria andSimpleCodeLessThan(String value) {
            addCriterion("simple_code <", value, "simpleCode");
            return (Criteria) this;
        }

        public Criteria andSimpleCodeLessThanOrEqualTo(String value) {
            addCriterion("simple_code <=", value, "simpleCode");
            return (Criteria) this;
        }

        public Criteria andSimpleCodeLike(String value) {
            addCriterion("simple_code like", value, "simpleCode");
            return (Criteria) this;
        }

        public Criteria andSimpleCodeNotLike(String value) {
            addCriterion("simple_code not like", value, "simpleCode");
            return (Criteria) this;
        }

        public Criteria andSimpleCodeIn(List<String> values) {
            addCriterion("simple_code in", values, "simpleCode");
            return (Criteria) this;
        }

        public Criteria andSimpleCodeNotIn(List<String> values) {
            addCriterion("simple_code not in", values, "simpleCode");
            return (Criteria) this;
        }

        public Criteria andSimpleCodeBetween(String value1, String value2) {
            addCriterion("simple_code between", value1, value2, "simpleCode");
            return (Criteria) this;
        }

        public Criteria andSimpleCodeNotBetween(String value1, String value2) {
            addCriterion("simple_code not between", value1, value2, "simpleCode");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Integer value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Integer value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Integer value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Integer value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Integer value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Integer> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Integer> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Integer value1, Integer value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andJtgsIsNull() {
            addCriterion("jtgs is null");
            return (Criteria) this;
        }

        public Criteria andJtgsIsNotNull() {
            addCriterion("jtgs is not null");
            return (Criteria) this;
        }

        public Criteria andJtgsEqualTo(Double value) {
            addCriterion("jtgs =", value, "jtgs");
            return (Criteria) this;
        }

        public Criteria andJtgsNotEqualTo(Double value) {
            addCriterion("jtgs <>", value, "jtgs");
            return (Criteria) this;
        }

        public Criteria andJtgsGreaterThan(Double value) {
            addCriterion("jtgs >", value, "jtgs");
            return (Criteria) this;
        }

        public Criteria andJtgsGreaterThanOrEqualTo(Double value) {
            addCriterion("jtgs >=", value, "jtgs");
            return (Criteria) this;
        }

        public Criteria andJtgsLessThan(Double value) {
            addCriterion("jtgs <", value, "jtgs");
            return (Criteria) this;
        }

        public Criteria andJtgsLessThanOrEqualTo(Double value) {
            addCriterion("jtgs <=", value, "jtgs");
            return (Criteria) this;
        }

        public Criteria andJtgsIn(List<Double> values) {
            addCriterion("jtgs in", values, "jtgs");
            return (Criteria) this;
        }

        public Criteria andJtgsNotIn(List<Double> values) {
            addCriterion("jtgs not in", values, "jtgs");
            return (Criteria) this;
        }

        public Criteria andJtgsBetween(Double value1, Double value2) {
            addCriterion("jtgs between", value1, value2, "jtgs");
            return (Criteria) this;
        }

        public Criteria andJtgsNotBetween(Double value1, Double value2) {
            addCriterion("jtgs not between", value1, value2, "jtgs");
            return (Criteria) this;
        }

        public Criteria andGfZsyKtyIsNull() {
            addCriterion("gf_zsy_kty is null");
            return (Criteria) this;
        }

        public Criteria andGfZsyKtyIsNotNull() {
            addCriterion("gf_zsy_kty is not null");
            return (Criteria) this;
        }

        public Criteria andGfZsyKtyEqualTo(Double value) {
            addCriterion("gf_zsy_kty =", value, "gfZsyKty");
            return (Criteria) this;
        }

        public Criteria andGfZsyKtyNotEqualTo(Double value) {
            addCriterion("gf_zsy_kty <>", value, "gfZsyKty");
            return (Criteria) this;
        }

        public Criteria andGfZsyKtyGreaterThan(Double value) {
            addCriterion("gf_zsy_kty >", value, "gfZsyKty");
            return (Criteria) this;
        }

        public Criteria andGfZsyKtyGreaterThanOrEqualTo(Double value) {
            addCriterion("gf_zsy_kty >=", value, "gfZsyKty");
            return (Criteria) this;
        }

        public Criteria andGfZsyKtyLessThan(Double value) {
            addCriterion("gf_zsy_kty <", value, "gfZsyKty");
            return (Criteria) this;
        }

        public Criteria andGfZsyKtyLessThanOrEqualTo(Double value) {
            addCriterion("gf_zsy_kty <=", value, "gfZsyKty");
            return (Criteria) this;
        }

        public Criteria andGfZsyKtyIn(List<Double> values) {
            addCriterion("gf_zsy_kty in", values, "gfZsyKty");
            return (Criteria) this;
        }

        public Criteria andGfZsyKtyNotIn(List<Double> values) {
            addCriterion("gf_zsy_kty not in", values, "gfZsyKty");
            return (Criteria) this;
        }

        public Criteria andGfZsyKtyBetween(Double value1, Double value2) {
            addCriterion("gf_zsy_kty between", value1, value2, "gfZsyKty");
            return (Criteria) this;
        }

        public Criteria andGfZsyKtyNotBetween(Double value1, Double value2) {
            addCriterion("gf_zsy_kty not between", value1, value2, "gfZsyKty");
            return (Criteria) this;
        }

        public Criteria andGfZsyGcyIsNull() {
            addCriterion("gf_zsy_gcy is null");
            return (Criteria) this;
        }

        public Criteria andGfZsyGcyIsNotNull() {
            addCriterion("gf_zsy_gcy is not null");
            return (Criteria) this;
        }

        public Criteria andGfZsyGcyEqualTo(Double value) {
            addCriterion("gf_zsy_gcy =", value, "gfZsyGcy");
            return (Criteria) this;
        }

        public Criteria andGfZsyGcyNotEqualTo(Double value) {
            addCriterion("gf_zsy_gcy <>", value, "gfZsyGcy");
            return (Criteria) this;
        }

        public Criteria andGfZsyGcyGreaterThan(Double value) {
            addCriterion("gf_zsy_gcy >", value, "gfZsyGcy");
            return (Criteria) this;
        }

        public Criteria andGfZsyGcyGreaterThanOrEqualTo(Double value) {
            addCriterion("gf_zsy_gcy >=", value, "gfZsyGcy");
            return (Criteria) this;
        }

        public Criteria andGfZsyGcyLessThan(Double value) {
            addCriterion("gf_zsy_gcy <", value, "gfZsyGcy");
            return (Criteria) this;
        }

        public Criteria andGfZsyGcyLessThanOrEqualTo(Double value) {
            addCriterion("gf_zsy_gcy <=", value, "gfZsyGcy");
            return (Criteria) this;
        }

        public Criteria andGfZsyGcyIn(List<Double> values) {
            addCriterion("gf_zsy_gcy in", values, "gfZsyGcy");
            return (Criteria) this;
        }

        public Criteria andGfZsyGcyNotIn(List<Double> values) {
            addCriterion("gf_zsy_gcy not in", values, "gfZsyGcy");
            return (Criteria) this;
        }

        public Criteria andGfZsyGcyBetween(Double value1, Double value2) {
            addCriterion("gf_zsy_gcy between", value1, value2, "gfZsyGcy");
            return (Criteria) this;
        }

        public Criteria andGfZsyGcyNotBetween(Double value1, Double value2) {
            addCriterion("gf_zsy_gcy not between", value1, value2, "gfZsyGcy");
            return (Criteria) this;
        }

        public Criteria andGfZsyWtyIsNull() {
            addCriterion("gf_zsy_wty is null");
            return (Criteria) this;
        }

        public Criteria andGfZsyWtyIsNotNull() {
            addCriterion("gf_zsy_wty is not null");
            return (Criteria) this;
        }

        public Criteria andGfZsyWtyEqualTo(Double value) {
            addCriterion("gf_zsy_wty =", value, "gfZsyWty");
            return (Criteria) this;
        }

        public Criteria andGfZsyWtyNotEqualTo(Double value) {
            addCriterion("gf_zsy_wty <>", value, "gfZsyWty");
            return (Criteria) this;
        }

        public Criteria andGfZsyWtyGreaterThan(Double value) {
            addCriterion("gf_zsy_wty >", value, "gfZsyWty");
            return (Criteria) this;
        }

        public Criteria andGfZsyWtyGreaterThanOrEqualTo(Double value) {
            addCriterion("gf_zsy_wty >=", value, "gfZsyWty");
            return (Criteria) this;
        }

        public Criteria andGfZsyWtyLessThan(Double value) {
            addCriterion("gf_zsy_wty <", value, "gfZsyWty");
            return (Criteria) this;
        }

        public Criteria andGfZsyWtyLessThanOrEqualTo(Double value) {
            addCriterion("gf_zsy_wty <=", value, "gfZsyWty");
            return (Criteria) this;
        }

        public Criteria andGfZsyWtyIn(List<Double> values) {
            addCriterion("gf_zsy_wty in", values, "gfZsyWty");
            return (Criteria) this;
        }

        public Criteria andGfZsyWtyNotIn(List<Double> values) {
            addCriterion("gf_zsy_wty not in", values, "gfZsyWty");
            return (Criteria) this;
        }

        public Criteria andGfZsyWtyBetween(Double value1, Double value2) {
            addCriterion("gf_zsy_wty between", value1, value2, "gfZsyWty");
            return (Criteria) this;
        }

        public Criteria andGfZsyWtyNotBetween(Double value1, Double value2) {
            addCriterion("gf_zsy_wty not between", value1, value2, "gfZsyWty");
            return (Criteria) this;
        }

        public Criteria andGfZsySkyIsNull() {
            addCriterion("gf_zsy_sky is null");
            return (Criteria) this;
        }

        public Criteria andGfZsySkyIsNotNull() {
            addCriterion("gf_zsy_sky is not null");
            return (Criteria) this;
        }

        public Criteria andGfZsySkyEqualTo(Double value) {
            addCriterion("gf_zsy_sky =", value, "gfZsySky");
            return (Criteria) this;
        }

        public Criteria andGfZsySkyNotEqualTo(Double value) {
            addCriterion("gf_zsy_sky <>", value, "gfZsySky");
            return (Criteria) this;
        }

        public Criteria andGfZsySkyGreaterThan(Double value) {
            addCriterion("gf_zsy_sky >", value, "gfZsySky");
            return (Criteria) this;
        }

        public Criteria andGfZsySkyGreaterThanOrEqualTo(Double value) {
            addCriterion("gf_zsy_sky >=", value, "gfZsySky");
            return (Criteria) this;
        }

        public Criteria andGfZsySkyLessThan(Double value) {
            addCriterion("gf_zsy_sky <", value, "gfZsySky");
            return (Criteria) this;
        }

        public Criteria andGfZsySkyLessThanOrEqualTo(Double value) {
            addCriterion("gf_zsy_sky <=", value, "gfZsySky");
            return (Criteria) this;
        }

        public Criteria andGfZsySkyIn(List<Double> values) {
            addCriterion("gf_zsy_sky in", values, "gfZsySky");
            return (Criteria) this;
        }

        public Criteria andGfZsySkyNotIn(List<Double> values) {
            addCriterion("gf_zsy_sky not in", values, "gfZsySky");
            return (Criteria) this;
        }

        public Criteria andGfZsySkyBetween(Double value1, Double value2) {
            addCriterion("gf_zsy_sky between", value1, value2, "gfZsySky");
            return (Criteria) this;
        }

        public Criteria andGfZsySkyNotBetween(Double value1, Double value2) {
            addCriterion("gf_zsy_sky not between", value1, value2, "gfZsySky");
            return (Criteria) this;
        }

        public Criteria andGfZsyBhyIsNull() {
            addCriterion("gf_zsy_bhy is null");
            return (Criteria) this;
        }

        public Criteria andGfZsyBhyIsNotNull() {
            addCriterion("gf_zsy_bhy is not null");
            return (Criteria) this;
        }

        public Criteria andGfZsyBhyEqualTo(Double value) {
            addCriterion("gf_zsy_bhy =", value, "gfZsyBhy");
            return (Criteria) this;
        }

        public Criteria andGfZsyBhyNotEqualTo(Double value) {
            addCriterion("gf_zsy_bhy <>", value, "gfZsyBhy");
            return (Criteria) this;
        }

        public Criteria andGfZsyBhyGreaterThan(Double value) {
            addCriterion("gf_zsy_bhy >", value, "gfZsyBhy");
            return (Criteria) this;
        }

        public Criteria andGfZsyBhyGreaterThanOrEqualTo(Double value) {
            addCriterion("gf_zsy_bhy >=", value, "gfZsyBhy");
            return (Criteria) this;
        }

        public Criteria andGfZsyBhyLessThan(Double value) {
            addCriterion("gf_zsy_bhy <", value, "gfZsyBhy");
            return (Criteria) this;
        }

        public Criteria andGfZsyBhyLessThanOrEqualTo(Double value) {
            addCriterion("gf_zsy_bhy <=", value, "gfZsyBhy");
            return (Criteria) this;
        }

        public Criteria andGfZsyBhyIn(List<Double> values) {
            addCriterion("gf_zsy_bhy in", values, "gfZsyBhy");
            return (Criteria) this;
        }

        public Criteria andGfZsyBhyNotIn(List<Double> values) {
            addCriterion("gf_zsy_bhy not in", values, "gfZsyBhy");
            return (Criteria) this;
        }

        public Criteria andGfZsyBhyBetween(Double value1, Double value2) {
            addCriterion("gf_zsy_bhy between", value1, value2, "gfZsyBhy");
            return (Criteria) this;
        }

        public Criteria andGfZsyBhyNotBetween(Double value1, Double value2) {
            addCriterion("gf_zsy_bhy not between", value1, value2, "gfZsyBhy");
            return (Criteria) this;
        }

        public Criteria andGfZsyFyyIsNull() {
            addCriterion("gf_zsy_fyy is null");
            return (Criteria) this;
        }

        public Criteria andGfZsyFyyIsNotNull() {
            addCriterion("gf_zsy_fyy is not null");
            return (Criteria) this;
        }

        public Criteria andGfZsyFyyEqualTo(Double value) {
            addCriterion("gf_zsy_fyy =", value, "gfZsyFyy");
            return (Criteria) this;
        }

        public Criteria andGfZsyFyyNotEqualTo(Double value) {
            addCriterion("gf_zsy_fyy <>", value, "gfZsyFyy");
            return (Criteria) this;
        }

        public Criteria andGfZsyFyyGreaterThan(Double value) {
            addCriterion("gf_zsy_fyy >", value, "gfZsyFyy");
            return (Criteria) this;
        }

        public Criteria andGfZsyFyyGreaterThanOrEqualTo(Double value) {
            addCriterion("gf_zsy_fyy >=", value, "gfZsyFyy");
            return (Criteria) this;
        }

        public Criteria andGfZsyFyyLessThan(Double value) {
            addCriterion("gf_zsy_fyy <", value, "gfZsyFyy");
            return (Criteria) this;
        }

        public Criteria andGfZsyFyyLessThanOrEqualTo(Double value) {
            addCriterion("gf_zsy_fyy <=", value, "gfZsyFyy");
            return (Criteria) this;
        }

        public Criteria andGfZsyFyyIn(List<Double> values) {
            addCriterion("gf_zsy_fyy in", values, "gfZsyFyy");
            return (Criteria) this;
        }

        public Criteria andGfZsyFyyNotIn(List<Double> values) {
            addCriterion("gf_zsy_fyy not in", values, "gfZsyFyy");
            return (Criteria) this;
        }

        public Criteria andGfZsyFyyBetween(Double value1, Double value2) {
            addCriterion("gf_zsy_fyy between", value1, value2, "gfZsyFyy");
            return (Criteria) this;
        }

        public Criteria andGfZsyFyyNotBetween(Double value1, Double value2) {
            addCriterion("gf_zsy_fyy not between", value1, value2, "gfZsyFyy");
            return (Criteria) this;
        }

        public Criteria andGfZsyShyIsNull() {
            addCriterion("gf_zsy_shy is null");
            return (Criteria) this;
        }

        public Criteria andGfZsyShyIsNotNull() {
            addCriterion("gf_zsy_shy is not null");
            return (Criteria) this;
        }

        public Criteria andGfZsyShyEqualTo(Double value) {
            addCriterion("gf_zsy_shy =", value, "gfZsyShy");
            return (Criteria) this;
        }

        public Criteria andGfZsyShyNotEqualTo(Double value) {
            addCriterion("gf_zsy_shy <>", value, "gfZsyShy");
            return (Criteria) this;
        }

        public Criteria andGfZsyShyGreaterThan(Double value) {
            addCriterion("gf_zsy_shy >", value, "gfZsyShy");
            return (Criteria) this;
        }

        public Criteria andGfZsyShyGreaterThanOrEqualTo(Double value) {
            addCriterion("gf_zsy_shy >=", value, "gfZsyShy");
            return (Criteria) this;
        }

        public Criteria andGfZsyShyLessThan(Double value) {
            addCriterion("gf_zsy_shy <", value, "gfZsyShy");
            return (Criteria) this;
        }

        public Criteria andGfZsyShyLessThanOrEqualTo(Double value) {
            addCriterion("gf_zsy_shy <=", value, "gfZsyShy");
            return (Criteria) this;
        }

        public Criteria andGfZsyShyIn(List<Double> values) {
            addCriterion("gf_zsy_shy in", values, "gfZsyShy");
            return (Criteria) this;
        }

        public Criteria andGfZsyShyNotIn(List<Double> values) {
            addCriterion("gf_zsy_shy not in", values, "gfZsyShy");
            return (Criteria) this;
        }

        public Criteria andGfZsyShyBetween(Double value1, Double value2) {
            addCriterion("gf_zsy_shy between", value1, value2, "gfZsyShy");
            return (Criteria) this;
        }

        public Criteria andGfZsyShyNotBetween(Double value1, Double value2) {
            addCriterion("gf_zsy_shy not between", value1, value2, "gfZsyShy");
            return (Criteria) this;
        }

        public Criteria andGfZsyQdyIsNull() {
            addCriterion("gf_zsy_qdy is null");
            return (Criteria) this;
        }

        public Criteria andGfZsyQdyIsNotNull() {
            addCriterion("gf_zsy_qdy is not null");
            return (Criteria) this;
        }

        public Criteria andGfZsyQdyEqualTo(Double value) {
            addCriterion("gf_zsy_qdy =", value, "gfZsyQdy");
            return (Criteria) this;
        }

        public Criteria andGfZsyQdyNotEqualTo(Double value) {
            addCriterion("gf_zsy_qdy <>", value, "gfZsyQdy");
            return (Criteria) this;
        }

        public Criteria andGfZsyQdyGreaterThan(Double value) {
            addCriterion("gf_zsy_qdy >", value, "gfZsyQdy");
            return (Criteria) this;
        }

        public Criteria andGfZsyQdyGreaterThanOrEqualTo(Double value) {
            addCriterion("gf_zsy_qdy >=", value, "gfZsyQdy");
            return (Criteria) this;
        }

        public Criteria andGfZsyQdyLessThan(Double value) {
            addCriterion("gf_zsy_qdy <", value, "gfZsyQdy");
            return (Criteria) this;
        }

        public Criteria andGfZsyQdyLessThanOrEqualTo(Double value) {
            addCriterion("gf_zsy_qdy <=", value, "gfZsyQdy");
            return (Criteria) this;
        }

        public Criteria andGfZsyQdyIn(List<Double> values) {
            addCriterion("gf_zsy_qdy in", values, "gfZsyQdy");
            return (Criteria) this;
        }

        public Criteria andGfZsyQdyNotIn(List<Double> values) {
            addCriterion("gf_zsy_qdy not in", values, "gfZsyQdy");
            return (Criteria) this;
        }

        public Criteria andGfZsyQdyBetween(Double value1, Double value2) {
            addCriterion("gf_zsy_qdy between", value1, value2, "gfZsyQdy");
            return (Criteria) this;
        }

        public Criteria andGfZsyQdyNotBetween(Double value1, Double value2) {
            addCriterion("gf_zsy_qdy not between", value1, value2, "gfZsyQdy");
            return (Criteria) this;
        }

        public Criteria andGfFzgsIsNull() {
            addCriterion("gf_fzgs is null");
            return (Criteria) this;
        }

        public Criteria andGfFzgsIsNotNull() {
            addCriterion("gf_fzgs is not null");
            return (Criteria) this;
        }

        public Criteria andGfFzgsEqualTo(Double value) {
            addCriterion("gf_fzgs =", value, "gfFzgs");
            return (Criteria) this;
        }

        public Criteria andGfFzgsNotEqualTo(Double value) {
            addCriterion("gf_fzgs <>", value, "gfFzgs");
            return (Criteria) this;
        }

        public Criteria andGfFzgsGreaterThan(Double value) {
            addCriterion("gf_fzgs >", value, "gfFzgs");
            return (Criteria) this;
        }

        public Criteria andGfFzgsGreaterThanOrEqualTo(Double value) {
            addCriterion("gf_fzgs >=", value, "gfFzgs");
            return (Criteria) this;
        }

        public Criteria andGfFzgsLessThan(Double value) {
            addCriterion("gf_fzgs <", value, "gfFzgs");
            return (Criteria) this;
        }

        public Criteria andGfFzgsLessThanOrEqualTo(Double value) {
            addCriterion("gf_fzgs <=", value, "gfFzgs");
            return (Criteria) this;
        }

        public Criteria andGfFzgsIn(List<Double> values) {
            addCriterion("gf_fzgs in", values, "gfFzgs");
            return (Criteria) this;
        }

        public Criteria andGfFzgsNotIn(List<Double> values) {
            addCriterion("gf_fzgs not in", values, "gfFzgs");
            return (Criteria) this;
        }

        public Criteria andGfFzgsBetween(Double value1, Double value2) {
            addCriterion("gf_fzgs between", value1, value2, "gfFzgs");
            return (Criteria) this;
        }

        public Criteria andGfFzgsNotBetween(Double value1, Double value2) {
            addCriterion("gf_fzgs not between", value1, value2, "gfFzgs");
            return (Criteria) this;
        }

        public Criteria andXtwIsNull() {
            addCriterion("xtw is null");
            return (Criteria) this;
        }

        public Criteria andXtwIsNotNull() {
            addCriterion("xtw is not null");
            return (Criteria) this;
        }

        public Criteria andXtwEqualTo(Double value) {
            addCriterion("xtw =", value, "xtw");
            return (Criteria) this;
        }

        public Criteria andXtwNotEqualTo(Double value) {
            addCriterion("xtw <>", value, "xtw");
            return (Criteria) this;
        }

        public Criteria andXtwGreaterThan(Double value) {
            addCriterion("xtw >", value, "xtw");
            return (Criteria) this;
        }

        public Criteria andXtwGreaterThanOrEqualTo(Double value) {
            addCriterion("xtw >=", value, "xtw");
            return (Criteria) this;
        }

        public Criteria andXtwLessThan(Double value) {
            addCriterion("xtw <", value, "xtw");
            return (Criteria) this;
        }

        public Criteria andXtwLessThanOrEqualTo(Double value) {
            addCriterion("xtw <=", value, "xtw");
            return (Criteria) this;
        }

        public Criteria andXtwIn(List<Double> values) {
            addCriterion("xtw in", values, "xtw");
            return (Criteria) this;
        }

        public Criteria andXtwNotIn(List<Double> values) {
            addCriterion("xtw not in", values, "xtw");
            return (Criteria) this;
        }

        public Criteria andXtwBetween(Double value1, Double value2) {
            addCriterion("xtw between", value1, value2, "xtw");
            return (Criteria) this;
        }

        public Criteria andXtwNotBetween(Double value1, Double value2) {
            addCriterion("xtw not between", value1, value2, "xtw");
            return (Criteria) this;
        }

        public Criteria andTotalIsNull() {
            addCriterion("total is null");
            return (Criteria) this;
        }

        public Criteria andTotalIsNotNull() {
            addCriterion("total is not null");
            return (Criteria) this;
        }

        public Criteria andTotalEqualTo(Double value) {
            addCriterion("total =", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotEqualTo(Double value) {
            addCriterion("total <>", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThan(Double value) {
            addCriterion("total >", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThanOrEqualTo(Double value) {
            addCriterion("total >=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThan(Double value) {
            addCriterion("total <", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThanOrEqualTo(Double value) {
            addCriterion("total <=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalIn(List<Double> values) {
            addCriterion("total in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotIn(List<Double> values) {
            addCriterion("total not in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalBetween(Double value1, Double value2) {
            addCriterion("total between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotBetween(Double value1, Double value2) {
            addCriterion("total not between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andItemTypeIsNull() {
            addCriterion("item_type is null");
            return (Criteria) this;
        }

        public Criteria andItemTypeIsNotNull() {
            addCriterion("item_type is not null");
            return (Criteria) this;
        }

        public Criteria andItemTypeEqualTo(Integer value) {
            addCriterion("item_type =", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotEqualTo(Integer value) {
            addCriterion("item_type <>", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeGreaterThan(Integer value) {
            addCriterion("item_type >", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_type >=", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLessThan(Integer value) {
            addCriterion("item_type <", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLessThanOrEqualTo(Integer value) {
            addCriterion("item_type <=", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeIn(List<Integer> values) {
            addCriterion("item_type in", values, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotIn(List<Integer> values) {
            addCriterion("item_type not in", values, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeBetween(Integer value1, Integer value2) {
            addCriterion("item_type between", value1, value2, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("item_type not between", value1, value2, "itemType");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeIsNull() {
            addCriterion("company_code is null");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeIsNotNull() {
            addCriterion("company_code is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeEqualTo(String value) {
            addCriterion("company_code =", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotEqualTo(String value) {
            addCriterion("company_code <>", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeGreaterThan(String value) {
            addCriterion("company_code >", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("company_code >=", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeLessThan(String value) {
            addCriterion("company_code <", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeLessThanOrEqualTo(String value) {
            addCriterion("company_code <=", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeLike(String value) {
            addCriterion("company_code like", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotLike(String value) {
            addCriterion("company_code not like", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeIn(List<String> values) {
            addCriterion("company_code in", values, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotIn(List<String> values) {
            addCriterion("company_code not in", values, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeBetween(String value1, String value2) {
            addCriterion("company_code between", value1, value2, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotBetween(String value1, String value2) {
            addCriterion("company_code not between", value1, value2, "companyCode");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andBudgetInfoIdIsNull() {
            addCriterion("budget_info_id is null");
            return (Criteria) this;
        }

        public Criteria andBudgetInfoIdIsNotNull() {
            addCriterion("budget_info_id is not null");
            return (Criteria) this;
        }

        public Criteria andBudgetInfoIdEqualTo(String value) {
            addCriterion("budget_info_id =", value, "budgetInfoId");
            return (Criteria) this;
        }

        public Criteria andBudgetInfoIdNotEqualTo(String value) {
            addCriterion("budget_info_id <>", value, "budgetInfoId");
            return (Criteria) this;
        }

        public Criteria andBudgetInfoIdGreaterThan(String value) {
            addCriterion("budget_info_id >", value, "budgetInfoId");
            return (Criteria) this;
        }

        public Criteria andBudgetInfoIdGreaterThanOrEqualTo(String value) {
            addCriterion("budget_info_id >=", value, "budgetInfoId");
            return (Criteria) this;
        }

        public Criteria andBudgetInfoIdLessThan(String value) {
            addCriterion("budget_info_id <", value, "budgetInfoId");
            return (Criteria) this;
        }

        public Criteria andBudgetInfoIdLessThanOrEqualTo(String value) {
            addCriterion("budget_info_id <=", value, "budgetInfoId");
            return (Criteria) this;
        }

        public Criteria andBudgetInfoIdLike(String value) {
            addCriterion("budget_info_id like", value, "budgetInfoId");
            return (Criteria) this;
        }

        public Criteria andBudgetInfoIdNotLike(String value) {
            addCriterion("budget_info_id not like", value, "budgetInfoId");
            return (Criteria) this;
        }

        public Criteria andBudgetInfoIdIn(List<String> values) {
            addCriterion("budget_info_id in", values, "budgetInfoId");
            return (Criteria) this;
        }

        public Criteria andBudgetInfoIdNotIn(List<String> values) {
            addCriterion("budget_info_id not in", values, "budgetInfoId");
            return (Criteria) this;
        }

        public Criteria andBudgetInfoIdBetween(String value1, String value2) {
            addCriterion("budget_info_id between", value1, value2, "budgetInfoId");
            return (Criteria) this;
        }

        public Criteria andBudgetInfoIdNotBetween(String value1, String value2) {
            addCriterion("budget_info_id not between", value1, value2, "budgetInfoId");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNull() {
            addCriterion("del_flag is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(Integer value) {
            addCriterion("del_flag =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(Integer value) {
            addCriterion("del_flag <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(Integer value) {
            addCriterion("del_flag >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("del_flag >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(Integer value) {
            addCriterion("del_flag <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(Integer value) {
            addCriterion("del_flag <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<Integer> values) {
            addCriterion("del_flag in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<Integer> values) {
            addCriterion("del_flag not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(Integer value1, Integer value2) {
            addCriterion("del_flag between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("del_flag not between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andAppendFilesIsNull() {
            addCriterion("append_files is null");
            return (Criteria) this;
        }

        public Criteria andAppendFilesIsNotNull() {
            addCriterion("append_files is not null");
            return (Criteria) this;
        }

        public Criteria andAppendFilesEqualTo(String value) {
            addCriterion("append_files =", value, "appendFiles");
            return (Criteria) this;
        }

        public Criteria andAppendFilesNotEqualTo(String value) {
            addCriterion("append_files <>", value, "appendFiles");
            return (Criteria) this;
        }

        public Criteria andAppendFilesGreaterThan(String value) {
            addCriterion("append_files >", value, "appendFiles");
            return (Criteria) this;
        }

        public Criteria andAppendFilesGreaterThanOrEqualTo(String value) {
            addCriterion("append_files >=", value, "appendFiles");
            return (Criteria) this;
        }

        public Criteria andAppendFilesLessThan(String value) {
            addCriterion("append_files <", value, "appendFiles");
            return (Criteria) this;
        }

        public Criteria andAppendFilesLessThanOrEqualTo(String value) {
            addCriterion("append_files <=", value, "appendFiles");
            return (Criteria) this;
        }

        public Criteria andAppendFilesLike(String value) {
            addCriterion("append_files like", value, "appendFiles");
            return (Criteria) this;
        }

        public Criteria andAppendFilesNotLike(String value) {
            addCriterion("append_files not like", value, "appendFiles");
            return (Criteria) this;
        }

        public Criteria andAppendFilesIn(List<String> values) {
            addCriterion("append_files in", values, "appendFiles");
            return (Criteria) this;
        }

        public Criteria andAppendFilesNotIn(List<String> values) {
            addCriterion("append_files not in", values, "appendFiles");
            return (Criteria) this;
        }

        public Criteria andAppendFilesBetween(String value1, String value2) {
            addCriterion("append_files between", value1, value2, "appendFiles");
            return (Criteria) this;
        }

        public Criteria andAppendFilesNotBetween(String value1, String value2) {
            addCriterion("append_files not between", value1, value2, "appendFiles");
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