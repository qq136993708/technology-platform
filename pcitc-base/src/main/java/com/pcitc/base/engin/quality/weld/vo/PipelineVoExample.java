package com.pcitc.base.engin.quality.weld.vo;

import java.util.ArrayList;
import java.util.List;

public class PipelineVoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PipelineVoExample() {
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
            addCriterion("DATA_ID is null");
            return (Criteria) this;
        }

        public Criteria andDataIdIsNotNull() {
            addCriterion("DATA_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDataIdEqualTo(String value) {
            addCriterion("DATA_ID =", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotEqualTo(String value) {
            addCriterion("DATA_ID <>", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdGreaterThan(String value) {
            addCriterion("DATA_ID >", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdGreaterThanOrEqualTo(String value) {
            addCriterion("DATA_ID >=", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdLessThan(String value) {
            addCriterion("DATA_ID <", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdLessThanOrEqualTo(String value) {
            addCriterion("DATA_ID <=", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdLike(String value) {
            addCriterion("DATA_ID like", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotLike(String value) {
            addCriterion("DATA_ID not like", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdIn(List<String> values) {
            addCriterion("DATA_ID in", values, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotIn(List<String> values) {
            addCriterion("DATA_ID not in", values, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdBetween(String value1, String value2) {
            addCriterion("DATA_ID between", value1, value2, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotBetween(String value1, String value2) {
            addCriterion("DATA_ID not between", value1, value2, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataCodeIsNull() {
            addCriterion("DATA_CODE is null");
            return (Criteria) this;
        }

        public Criteria andDataCodeIsNotNull() {
            addCriterion("DATA_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andDataCodeEqualTo(String value) {
            addCriterion("DATA_CODE =", value, "dataCode");
            return (Criteria) this;
        }

        public Criteria andDataCodeNotEqualTo(String value) {
            addCriterion("DATA_CODE <>", value, "dataCode");
            return (Criteria) this;
        }

        public Criteria andDataCodeGreaterThan(String value) {
            addCriterion("DATA_CODE >", value, "dataCode");
            return (Criteria) this;
        }

        public Criteria andDataCodeGreaterThanOrEqualTo(String value) {
            addCriterion("DATA_CODE >=", value, "dataCode");
            return (Criteria) this;
        }

        public Criteria andDataCodeLessThan(String value) {
            addCriterion("DATA_CODE <", value, "dataCode");
            return (Criteria) this;
        }

        public Criteria andDataCodeLessThanOrEqualTo(String value) {
            addCriterion("DATA_CODE <=", value, "dataCode");
            return (Criteria) this;
        }

        public Criteria andDataCodeLike(String value) {
            addCriterion("DATA_CODE like", value, "dataCode");
            return (Criteria) this;
        }

        public Criteria andDataCodeNotLike(String value) {
            addCriterion("DATA_CODE not like", value, "dataCode");
            return (Criteria) this;
        }

        public Criteria andDataCodeIn(List<String> values) {
            addCriterion("DATA_CODE in", values, "dataCode");
            return (Criteria) this;
        }

        public Criteria andDataCodeNotIn(List<String> values) {
            addCriterion("DATA_CODE not in", values, "dataCode");
            return (Criteria) this;
        }

        public Criteria andDataCodeBetween(String value1, String value2) {
            addCriterion("DATA_CODE between", value1, value2, "dataCode");
            return (Criteria) this;
        }

        public Criteria andDataCodeNotBetween(String value1, String value2) {
            addCriterion("DATA_CODE not between", value1, value2, "dataCode");
            return (Criteria) this;
        }

        public Criteria andSysFlagIsNull() {
            addCriterion("SYS_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andSysFlagIsNotNull() {
            addCriterion("SYS_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andSysFlagEqualTo(String value) {
            addCriterion("SYS_FLAG =", value, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagNotEqualTo(String value) {
            addCriterion("SYS_FLAG <>", value, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagGreaterThan(String value) {
            addCriterion("SYS_FLAG >", value, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagGreaterThanOrEqualTo(String value) {
            addCriterion("SYS_FLAG >=", value, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagLessThan(String value) {
            addCriterion("SYS_FLAG <", value, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagLessThanOrEqualTo(String value) {
            addCriterion("SYS_FLAG <=", value, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagLike(String value) {
            addCriterion("SYS_FLAG like", value, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagNotLike(String value) {
            addCriterion("SYS_FLAG not like", value, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagIn(List<String> values) {
            addCriterion("SYS_FLAG in", values, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagNotIn(List<String> values) {
            addCriterion("SYS_FLAG not in", values, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagBetween(String value1, String value2) {
            addCriterion("SYS_FLAG between", value1, value2, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagNotBetween(String value1, String value2) {
            addCriterion("SYS_FLAG not between", value1, value2, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andDataOrderIsNull() {
            addCriterion("DATA_ORDER is null");
            return (Criteria) this;
        }

        public Criteria andDataOrderIsNotNull() {
            addCriterion("DATA_ORDER is not null");
            return (Criteria) this;
        }

        public Criteria andDataOrderEqualTo(String value) {
            addCriterion("DATA_ORDER =", value, "dataOrder");
            return (Criteria) this;
        }

        public Criteria andDataOrderNotEqualTo(String value) {
            addCriterion("DATA_ORDER <>", value, "dataOrder");
            return (Criteria) this;
        }

        public Criteria andDataOrderGreaterThan(String value) {
            addCriterion("DATA_ORDER >", value, "dataOrder");
            return (Criteria) this;
        }

        public Criteria andDataOrderGreaterThanOrEqualTo(String value) {
            addCriterion("DATA_ORDER >=", value, "dataOrder");
            return (Criteria) this;
        }

        public Criteria andDataOrderLessThan(String value) {
            addCriterion("DATA_ORDER <", value, "dataOrder");
            return (Criteria) this;
        }

        public Criteria andDataOrderLessThanOrEqualTo(String value) {
            addCriterion("DATA_ORDER <=", value, "dataOrder");
            return (Criteria) this;
        }

        public Criteria andDataOrderLike(String value) {
            addCriterion("DATA_ORDER like", value, "dataOrder");
            return (Criteria) this;
        }

        public Criteria andDataOrderNotLike(String value) {
            addCriterion("DATA_ORDER not like", value, "dataOrder");
            return (Criteria) this;
        }

        public Criteria andDataOrderIn(List<String> values) {
            addCriterion("DATA_ORDER in", values, "dataOrder");
            return (Criteria) this;
        }

        public Criteria andDataOrderNotIn(List<String> values) {
            addCriterion("DATA_ORDER not in", values, "dataOrder");
            return (Criteria) this;
        }

        public Criteria andDataOrderBetween(String value1, String value2) {
            addCriterion("DATA_ORDER between", value1, value2, "dataOrder");
            return (Criteria) this;
        }

        public Criteria andDataOrderNotBetween(String value1, String value2) {
            addCriterion("DATA_ORDER not between", value1, value2, "dataOrder");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(String value) {
            addCriterion("CREATE_DATE =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(String value) {
            addCriterion("CREATE_DATE <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(String value) {
            addCriterion("CREATE_DATE >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_DATE >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(String value) {
            addCriterion("CREATE_DATE <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(String value) {
            addCriterion("CREATE_DATE <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLike(String value) {
            addCriterion("CREATE_DATE like", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotLike(String value) {
            addCriterion("CREATE_DATE not like", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<String> values) {
            addCriterion("CREATE_DATE in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<String> values) {
            addCriterion("CREATE_DATE not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(String value1, String value2) {
            addCriterion("CREATE_DATE between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(String value1, String value2) {
            addCriterion("CREATE_DATE not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("CREATE_USER is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("CREATE_USER is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("CREATE_USER =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("CREATE_USER <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("CREATE_USER >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_USER >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("CREATE_USER <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("CREATE_USER <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("CREATE_USER like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("CREATE_USER not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("CREATE_USER in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("CREATE_USER not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("CREATE_USER between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("CREATE_USER not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("UPDATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("UPDATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(String value) {
            addCriterion("UPDATE_DATE =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(String value) {
            addCriterion("UPDATE_DATE <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(String value) {
            addCriterion("UPDATE_DATE >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_DATE >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(String value) {
            addCriterion("UPDATE_DATE <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_DATE <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLike(String value) {
            addCriterion("UPDATE_DATE like", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotLike(String value) {
            addCriterion("UPDATE_DATE not like", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<String> values) {
            addCriterion("UPDATE_DATE in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<String> values) {
            addCriterion("UPDATE_DATE not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(String value1, String value2) {
            addCriterion("UPDATE_DATE between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(String value1, String value2) {
            addCriterion("UPDATE_DATE not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("UPDATE_USER is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("UPDATE_USER is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("UPDATE_USER =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("UPDATE_USER <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("UPDATE_USER >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_USER >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("UPDATE_USER <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_USER <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("UPDATE_USER like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("UPDATE_USER not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("UPDATE_USER in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("UPDATE_USER not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("UPDATE_USER between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("UPDATE_USER not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNull() {
            addCriterion("PROJECT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("PROJECT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("PROJECT_NAME =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("PROJECT_NAME <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("PROJECT_NAME >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("PROJECT_NAME >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("PROJECT_NAME <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("PROJECT_NAME <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("PROJECT_NAME like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("PROJECT_NAME not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("PROJECT_NAME in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("PROJECT_NAME not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("PROJECT_NAME between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("PROJECT_NAME not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectCodeIsNull() {
            addCriterion("PROJECT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andProjectCodeIsNotNull() {
            addCriterion("PROJECT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andProjectCodeEqualTo(String value) {
            addCriterion("PROJECT_CODE =", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeNotEqualTo(String value) {
            addCriterion("PROJECT_CODE <>", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeGreaterThan(String value) {
            addCriterion("PROJECT_CODE >", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PROJECT_CODE >=", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeLessThan(String value) {
            addCriterion("PROJECT_CODE <", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeLessThanOrEqualTo(String value) {
            addCriterion("PROJECT_CODE <=", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeLike(String value) {
            addCriterion("PROJECT_CODE like", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeNotLike(String value) {
            addCriterion("PROJECT_CODE not like", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeIn(List<String> values) {
            addCriterion("PROJECT_CODE in", values, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeNotIn(List<String> values) {
            addCriterion("PROJECT_CODE not in", values, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeBetween(String value1, String value2) {
            addCriterion("PROJECT_CODE between", value1, value2, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeNotBetween(String value1, String value2) {
            addCriterion("PROJECT_CODE not between", value1, value2, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNull() {
            addCriterion("PROJECT_ID is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("PROJECT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(String value) {
            addCriterion("PROJECT_ID =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(String value) {
            addCriterion("PROJECT_ID <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(String value) {
            addCriterion("PROJECT_ID >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("PROJECT_ID >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(String value) {
            addCriterion("PROJECT_ID <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(String value) {
            addCriterion("PROJECT_ID <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLike(String value) {
            addCriterion("PROJECT_ID like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotLike(String value) {
            addCriterion("PROJECT_ID not like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<String> values) {
            addCriterion("PROJECT_ID in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<String> values) {
            addCriterion("PROJECT_ID not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(String value1, String value2) {
            addCriterion("PROJECT_ID between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(String value1, String value2) {
            addCriterion("PROJECT_ID not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andAuditStsIsNull() {
            addCriterion("AUDIT_STS is null");
            return (Criteria) this;
        }

        public Criteria andAuditStsIsNotNull() {
            addCriterion("AUDIT_STS is not null");
            return (Criteria) this;
        }

        public Criteria andAuditStsEqualTo(String value) {
            addCriterion("AUDIT_STS =", value, "auditSts");
            return (Criteria) this;
        }

        public Criteria andAuditStsNotEqualTo(String value) {
            addCriterion("AUDIT_STS <>", value, "auditSts");
            return (Criteria) this;
        }

        public Criteria andAuditStsGreaterThan(String value) {
            addCriterion("AUDIT_STS >", value, "auditSts");
            return (Criteria) this;
        }

        public Criteria andAuditStsGreaterThanOrEqualTo(String value) {
            addCriterion("AUDIT_STS >=", value, "auditSts");
            return (Criteria) this;
        }

        public Criteria andAuditStsLessThan(String value) {
            addCriterion("AUDIT_STS <", value, "auditSts");
            return (Criteria) this;
        }

        public Criteria andAuditStsLessThanOrEqualTo(String value) {
            addCriterion("AUDIT_STS <=", value, "auditSts");
            return (Criteria) this;
        }

        public Criteria andAuditStsLike(String value) {
            addCriterion("AUDIT_STS like", value, "auditSts");
            return (Criteria) this;
        }

        public Criteria andAuditStsNotLike(String value) {
            addCriterion("AUDIT_STS not like", value, "auditSts");
            return (Criteria) this;
        }

        public Criteria andAuditStsIn(List<String> values) {
            addCriterion("AUDIT_STS in", values, "auditSts");
            return (Criteria) this;
        }

        public Criteria andAuditStsNotIn(List<String> values) {
            addCriterion("AUDIT_STS not in", values, "auditSts");
            return (Criteria) this;
        }

        public Criteria andAuditStsBetween(String value1, String value2) {
            addCriterion("AUDIT_STS between", value1, value2, "auditSts");
            return (Criteria) this;
        }

        public Criteria andAuditStsNotBetween(String value1, String value2) {
            addCriterion("AUDIT_STS not between", value1, value2, "auditSts");
            return (Criteria) this;
        }

        public Criteria andUnitCodeIsNull() {
            addCriterion("UNIT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andUnitCodeIsNotNull() {
            addCriterion("UNIT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andUnitCodeEqualTo(String value) {
            addCriterion("UNIT_CODE =", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeNotEqualTo(String value) {
            addCriterion("UNIT_CODE <>", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeGreaterThan(String value) {
            addCriterion("UNIT_CODE >", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeGreaterThanOrEqualTo(String value) {
            addCriterion("UNIT_CODE >=", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeLessThan(String value) {
            addCriterion("UNIT_CODE <", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeLessThanOrEqualTo(String value) {
            addCriterion("UNIT_CODE <=", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeLike(String value) {
            addCriterion("UNIT_CODE like", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeNotLike(String value) {
            addCriterion("UNIT_CODE not like", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeIn(List<String> values) {
            addCriterion("UNIT_CODE in", values, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeNotIn(List<String> values) {
            addCriterion("UNIT_CODE not in", values, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeBetween(String value1, String value2) {
            addCriterion("UNIT_CODE between", value1, value2, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeNotBetween(String value1, String value2) {
            addCriterion("UNIT_CODE not between", value1, value2, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitNameIsNull() {
            addCriterion("UNIT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andUnitNameIsNotNull() {
            addCriterion("UNIT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andUnitNameEqualTo(String value) {
            addCriterion("UNIT_NAME =", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotEqualTo(String value) {
            addCriterion("UNIT_NAME <>", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameGreaterThan(String value) {
            addCriterion("UNIT_NAME >", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameGreaterThanOrEqualTo(String value) {
            addCriterion("UNIT_NAME >=", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameLessThan(String value) {
            addCriterion("UNIT_NAME <", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameLessThanOrEqualTo(String value) {
            addCriterion("UNIT_NAME <=", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameLike(String value) {
            addCriterion("UNIT_NAME like", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotLike(String value) {
            addCriterion("UNIT_NAME not like", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameIn(List<String> values) {
            addCriterion("UNIT_NAME in", values, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotIn(List<String> values) {
            addCriterion("UNIT_NAME not in", values, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameBetween(String value1, String value2) {
            addCriterion("UNIT_NAME between", value1, value2, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotBetween(String value1, String value2) {
            addCriterion("UNIT_NAME not between", value1, value2, "unitName");
            return (Criteria) this;
        }

        public Criteria andEnginNameIsNull() {
            addCriterion("ENGIN_NAME is null");
            return (Criteria) this;
        }

        public Criteria andEnginNameIsNotNull() {
            addCriterion("ENGIN_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andEnginNameEqualTo(String value) {
            addCriterion("ENGIN_NAME =", value, "enginName");
            return (Criteria) this;
        }

        public Criteria andEnginNameNotEqualTo(String value) {
            addCriterion("ENGIN_NAME <>", value, "enginName");
            return (Criteria) this;
        }

        public Criteria andEnginNameGreaterThan(String value) {
            addCriterion("ENGIN_NAME >", value, "enginName");
            return (Criteria) this;
        }

        public Criteria andEnginNameGreaterThanOrEqualTo(String value) {
            addCriterion("ENGIN_NAME >=", value, "enginName");
            return (Criteria) this;
        }

        public Criteria andEnginNameLessThan(String value) {
            addCriterion("ENGIN_NAME <", value, "enginName");
            return (Criteria) this;
        }

        public Criteria andEnginNameLessThanOrEqualTo(String value) {
            addCriterion("ENGIN_NAME <=", value, "enginName");
            return (Criteria) this;
        }

        public Criteria andEnginNameLike(String value) {
            addCriterion("ENGIN_NAME like", value, "enginName");
            return (Criteria) this;
        }

        public Criteria andEnginNameNotLike(String value) {
            addCriterion("ENGIN_NAME not like", value, "enginName");
            return (Criteria) this;
        }

        public Criteria andEnginNameIn(List<String> values) {
            addCriterion("ENGIN_NAME in", values, "enginName");
            return (Criteria) this;
        }

        public Criteria andEnginNameNotIn(List<String> values) {
            addCriterion("ENGIN_NAME not in", values, "enginName");
            return (Criteria) this;
        }

        public Criteria andEnginNameBetween(String value1, String value2) {
            addCriterion("ENGIN_NAME between", value1, value2, "enginName");
            return (Criteria) this;
        }

        public Criteria andEnginNameNotBetween(String value1, String value2) {
            addCriterion("ENGIN_NAME not between", value1, value2, "enginName");
            return (Criteria) this;
        }

        public Criteria andEnginCodeIsNull() {
            addCriterion("ENGIN_CODE is null");
            return (Criteria) this;
        }

        public Criteria andEnginCodeIsNotNull() {
            addCriterion("ENGIN_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andEnginCodeEqualTo(String value) {
            addCriterion("ENGIN_CODE =", value, "enginCode");
            return (Criteria) this;
        }

        public Criteria andEnginCodeNotEqualTo(String value) {
            addCriterion("ENGIN_CODE <>", value, "enginCode");
            return (Criteria) this;
        }

        public Criteria andEnginCodeGreaterThan(String value) {
            addCriterion("ENGIN_CODE >", value, "enginCode");
            return (Criteria) this;
        }

        public Criteria andEnginCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ENGIN_CODE >=", value, "enginCode");
            return (Criteria) this;
        }

        public Criteria andEnginCodeLessThan(String value) {
            addCriterion("ENGIN_CODE <", value, "enginCode");
            return (Criteria) this;
        }

        public Criteria andEnginCodeLessThanOrEqualTo(String value) {
            addCriterion("ENGIN_CODE <=", value, "enginCode");
            return (Criteria) this;
        }

        public Criteria andEnginCodeLike(String value) {
            addCriterion("ENGIN_CODE like", value, "enginCode");
            return (Criteria) this;
        }

        public Criteria andEnginCodeNotLike(String value) {
            addCriterion("ENGIN_CODE not like", value, "enginCode");
            return (Criteria) this;
        }

        public Criteria andEnginCodeIn(List<String> values) {
            addCriterion("ENGIN_CODE in", values, "enginCode");
            return (Criteria) this;
        }

        public Criteria andEnginCodeNotIn(List<String> values) {
            addCriterion("ENGIN_CODE not in", values, "enginCode");
            return (Criteria) this;
        }

        public Criteria andEnginCodeBetween(String value1, String value2) {
            addCriterion("ENGIN_CODE between", value1, value2, "enginCode");
            return (Criteria) this;
        }

        public Criteria andEnginCodeNotBetween(String value1, String value2) {
            addCriterion("ENGIN_CODE not between", value1, value2, "enginCode");
            return (Criteria) this;
        }

        public Criteria andEnginIdIsNull() {
            addCriterion("ENGIN_ID is null");
            return (Criteria) this;
        }

        public Criteria andEnginIdIsNotNull() {
            addCriterion("ENGIN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andEnginIdEqualTo(String value) {
            addCriterion("ENGIN_ID =", value, "enginId");
            return (Criteria) this;
        }

        public Criteria andEnginIdNotEqualTo(String value) {
            addCriterion("ENGIN_ID <>", value, "enginId");
            return (Criteria) this;
        }

        public Criteria andEnginIdGreaterThan(String value) {
            addCriterion("ENGIN_ID >", value, "enginId");
            return (Criteria) this;
        }

        public Criteria andEnginIdGreaterThanOrEqualTo(String value) {
            addCriterion("ENGIN_ID >=", value, "enginId");
            return (Criteria) this;
        }

        public Criteria andEnginIdLessThan(String value) {
            addCriterion("ENGIN_ID <", value, "enginId");
            return (Criteria) this;
        }

        public Criteria andEnginIdLessThanOrEqualTo(String value) {
            addCriterion("ENGIN_ID <=", value, "enginId");
            return (Criteria) this;
        }

        public Criteria andEnginIdLike(String value) {
            addCriterion("ENGIN_ID like", value, "enginId");
            return (Criteria) this;
        }

        public Criteria andEnginIdNotLike(String value) {
            addCriterion("ENGIN_ID not like", value, "enginId");
            return (Criteria) this;
        }

        public Criteria andEnginIdIn(List<String> values) {
            addCriterion("ENGIN_ID in", values, "enginId");
            return (Criteria) this;
        }

        public Criteria andEnginIdNotIn(List<String> values) {
            addCriterion("ENGIN_ID not in", values, "enginId");
            return (Criteria) this;
        }

        public Criteria andEnginIdBetween(String value1, String value2) {
            addCriterion("ENGIN_ID between", value1, value2, "enginId");
            return (Criteria) this;
        }

        public Criteria andEnginIdNotBetween(String value1, String value2) {
            addCriterion("ENGIN_ID not between", value1, value2, "enginId");
            return (Criteria) this;
        }

        public Criteria andSpaceCodeIsNull() {
            addCriterion("SPACE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andSpaceCodeIsNotNull() {
            addCriterion("SPACE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andSpaceCodeEqualTo(String value) {
            addCriterion("SPACE_CODE =", value, "spaceCode");
            return (Criteria) this;
        }

        public Criteria andSpaceCodeNotEqualTo(String value) {
            addCriterion("SPACE_CODE <>", value, "spaceCode");
            return (Criteria) this;
        }

        public Criteria andSpaceCodeGreaterThan(String value) {
            addCriterion("SPACE_CODE >", value, "spaceCode");
            return (Criteria) this;
        }

        public Criteria andSpaceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SPACE_CODE >=", value, "spaceCode");
            return (Criteria) this;
        }

        public Criteria andSpaceCodeLessThan(String value) {
            addCriterion("SPACE_CODE <", value, "spaceCode");
            return (Criteria) this;
        }

        public Criteria andSpaceCodeLessThanOrEqualTo(String value) {
            addCriterion("SPACE_CODE <=", value, "spaceCode");
            return (Criteria) this;
        }

        public Criteria andSpaceCodeLike(String value) {
            addCriterion("SPACE_CODE like", value, "spaceCode");
            return (Criteria) this;
        }

        public Criteria andSpaceCodeNotLike(String value) {
            addCriterion("SPACE_CODE not like", value, "spaceCode");
            return (Criteria) this;
        }

        public Criteria andSpaceCodeIn(List<String> values) {
            addCriterion("SPACE_CODE in", values, "spaceCode");
            return (Criteria) this;
        }

        public Criteria andSpaceCodeNotIn(List<String> values) {
            addCriterion("SPACE_CODE not in", values, "spaceCode");
            return (Criteria) this;
        }

        public Criteria andSpaceCodeBetween(String value1, String value2) {
            addCriterion("SPACE_CODE between", value1, value2, "spaceCode");
            return (Criteria) this;
        }

        public Criteria andSpaceCodeNotBetween(String value1, String value2) {
            addCriterion("SPACE_CODE not between", value1, value2, "spaceCode");
            return (Criteria) this;
        }

        public Criteria andPipelineNameIsNull() {
            addCriterion("PIPELINE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPipelineNameIsNotNull() {
            addCriterion("PIPELINE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPipelineNameEqualTo(String value) {
            addCriterion("PIPELINE_NAME =", value, "pipelineName");
            return (Criteria) this;
        }

        public Criteria andPipelineNameNotEqualTo(String value) {
            addCriterion("PIPELINE_NAME <>", value, "pipelineName");
            return (Criteria) this;
        }

        public Criteria andPipelineNameGreaterThan(String value) {
            addCriterion("PIPELINE_NAME >", value, "pipelineName");
            return (Criteria) this;
        }

        public Criteria andPipelineNameGreaterThanOrEqualTo(String value) {
            addCriterion("PIPELINE_NAME >=", value, "pipelineName");
            return (Criteria) this;
        }

        public Criteria andPipelineNameLessThan(String value) {
            addCriterion("PIPELINE_NAME <", value, "pipelineName");
            return (Criteria) this;
        }

        public Criteria andPipelineNameLessThanOrEqualTo(String value) {
            addCriterion("PIPELINE_NAME <=", value, "pipelineName");
            return (Criteria) this;
        }

        public Criteria andPipelineNameLike(String value) {
            addCriterion("PIPELINE_NAME like", value, "pipelineName");
            return (Criteria) this;
        }

        public Criteria andPipelineNameNotLike(String value) {
            addCriterion("PIPELINE_NAME not like", value, "pipelineName");
            return (Criteria) this;
        }

        public Criteria andPipelineNameIn(List<String> values) {
            addCriterion("PIPELINE_NAME in", values, "pipelineName");
            return (Criteria) this;
        }

        public Criteria andPipelineNameNotIn(List<String> values) {
            addCriterion("PIPELINE_NAME not in", values, "pipelineName");
            return (Criteria) this;
        }

        public Criteria andPipelineNameBetween(String value1, String value2) {
            addCriterion("PIPELINE_NAME between", value1, value2, "pipelineName");
            return (Criteria) this;
        }

        public Criteria andPipelineNameNotBetween(String value1, String value2) {
            addCriterion("PIPELINE_NAME not between", value1, value2, "pipelineName");
            return (Criteria) this;
        }

        public Criteria andPipelineCodeIsNull() {
            addCriterion("PIPELINE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andPipelineCodeIsNotNull() {
            addCriterion("PIPELINE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andPipelineCodeEqualTo(String value) {
            addCriterion("PIPELINE_CODE =", value, "pipelineCode");
            return (Criteria) this;
        }

        public Criteria andPipelineCodeNotEqualTo(String value) {
            addCriterion("PIPELINE_CODE <>", value, "pipelineCode");
            return (Criteria) this;
        }

        public Criteria andPipelineCodeGreaterThan(String value) {
            addCriterion("PIPELINE_CODE >", value, "pipelineCode");
            return (Criteria) this;
        }

        public Criteria andPipelineCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PIPELINE_CODE >=", value, "pipelineCode");
            return (Criteria) this;
        }

        public Criteria andPipelineCodeLessThan(String value) {
            addCriterion("PIPELINE_CODE <", value, "pipelineCode");
            return (Criteria) this;
        }

        public Criteria andPipelineCodeLessThanOrEqualTo(String value) {
            addCriterion("PIPELINE_CODE <=", value, "pipelineCode");
            return (Criteria) this;
        }

        public Criteria andPipelineCodeLike(String value) {
            addCriterion("PIPELINE_CODE like", value, "pipelineCode");
            return (Criteria) this;
        }

        public Criteria andPipelineCodeNotLike(String value) {
            addCriterion("PIPELINE_CODE not like", value, "pipelineCode");
            return (Criteria) this;
        }

        public Criteria andPipelineCodeIn(List<String> values) {
            addCriterion("PIPELINE_CODE in", values, "pipelineCode");
            return (Criteria) this;
        }

        public Criteria andPipelineCodeNotIn(List<String> values) {
            addCriterion("PIPELINE_CODE not in", values, "pipelineCode");
            return (Criteria) this;
        }

        public Criteria andPipelineCodeBetween(String value1, String value2) {
            addCriterion("PIPELINE_CODE between", value1, value2, "pipelineCode");
            return (Criteria) this;
        }

        public Criteria andPipelineCodeNotBetween(String value1, String value2) {
            addCriterion("PIPELINE_CODE not between", value1, value2, "pipelineCode");
            return (Criteria) this;
        }

        public Criteria andTextureNameIsNull() {
            addCriterion("TEXTURE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andTextureNameIsNotNull() {
            addCriterion("TEXTURE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andTextureNameEqualTo(String value) {
            addCriterion("TEXTURE_NAME =", value, "textureName");
            return (Criteria) this;
        }

        public Criteria andTextureNameNotEqualTo(String value) {
            addCriterion("TEXTURE_NAME <>", value, "textureName");
            return (Criteria) this;
        }

        public Criteria andTextureNameGreaterThan(String value) {
            addCriterion("TEXTURE_NAME >", value, "textureName");
            return (Criteria) this;
        }

        public Criteria andTextureNameGreaterThanOrEqualTo(String value) {
            addCriterion("TEXTURE_NAME >=", value, "textureName");
            return (Criteria) this;
        }

        public Criteria andTextureNameLessThan(String value) {
            addCriterion("TEXTURE_NAME <", value, "textureName");
            return (Criteria) this;
        }

        public Criteria andTextureNameLessThanOrEqualTo(String value) {
            addCriterion("TEXTURE_NAME <=", value, "textureName");
            return (Criteria) this;
        }

        public Criteria andTextureNameLike(String value) {
            addCriterion("TEXTURE_NAME like", value, "textureName");
            return (Criteria) this;
        }

        public Criteria andTextureNameNotLike(String value) {
            addCriterion("TEXTURE_NAME not like", value, "textureName");
            return (Criteria) this;
        }

        public Criteria andTextureNameIn(List<String> values) {
            addCriterion("TEXTURE_NAME in", values, "textureName");
            return (Criteria) this;
        }

        public Criteria andTextureNameNotIn(List<String> values) {
            addCriterion("TEXTURE_NAME not in", values, "textureName");
            return (Criteria) this;
        }

        public Criteria andTextureNameBetween(String value1, String value2) {
            addCriterion("TEXTURE_NAME between", value1, value2, "textureName");
            return (Criteria) this;
        }

        public Criteria andTextureNameNotBetween(String value1, String value2) {
            addCriterion("TEXTURE_NAME not between", value1, value2, "textureName");
            return (Criteria) this;
        }

        public Criteria andTextureCodeIsNull() {
            addCriterion("TEXTURE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andTextureCodeIsNotNull() {
            addCriterion("TEXTURE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andTextureCodeEqualTo(String value) {
            addCriterion("TEXTURE_CODE =", value, "textureCode");
            return (Criteria) this;
        }

        public Criteria andTextureCodeNotEqualTo(String value) {
            addCriterion("TEXTURE_CODE <>", value, "textureCode");
            return (Criteria) this;
        }

        public Criteria andTextureCodeGreaterThan(String value) {
            addCriterion("TEXTURE_CODE >", value, "textureCode");
            return (Criteria) this;
        }

        public Criteria andTextureCodeGreaterThanOrEqualTo(String value) {
            addCriterion("TEXTURE_CODE >=", value, "textureCode");
            return (Criteria) this;
        }

        public Criteria andTextureCodeLessThan(String value) {
            addCriterion("TEXTURE_CODE <", value, "textureCode");
            return (Criteria) this;
        }

        public Criteria andTextureCodeLessThanOrEqualTo(String value) {
            addCriterion("TEXTURE_CODE <=", value, "textureCode");
            return (Criteria) this;
        }

        public Criteria andTextureCodeLike(String value) {
            addCriterion("TEXTURE_CODE like", value, "textureCode");
            return (Criteria) this;
        }

        public Criteria andTextureCodeNotLike(String value) {
            addCriterion("TEXTURE_CODE not like", value, "textureCode");
            return (Criteria) this;
        }

        public Criteria andTextureCodeIn(List<String> values) {
            addCriterion("TEXTURE_CODE in", values, "textureCode");
            return (Criteria) this;
        }

        public Criteria andTextureCodeNotIn(List<String> values) {
            addCriterion("TEXTURE_CODE not in", values, "textureCode");
            return (Criteria) this;
        }

        public Criteria andTextureCodeBetween(String value1, String value2) {
            addCriterion("TEXTURE_CODE between", value1, value2, "textureCode");
            return (Criteria) this;
        }

        public Criteria andTextureCodeNotBetween(String value1, String value2) {
            addCriterion("TEXTURE_CODE not between", value1, value2, "textureCode");
            return (Criteria) this;
        }

        public Criteria andDyneNumberIsNull() {
            addCriterion("DYNE_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andDyneNumberIsNotNull() {
            addCriterion("DYNE_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andDyneNumberEqualTo(String value) {
            addCriterion("DYNE_NUMBER =", value, "dyneNumber");
            return (Criteria) this;
        }

        public Criteria andDyneNumberNotEqualTo(String value) {
            addCriterion("DYNE_NUMBER <>", value, "dyneNumber");
            return (Criteria) this;
        }

        public Criteria andDyneNumberGreaterThan(String value) {
            addCriterion("DYNE_NUMBER >", value, "dyneNumber");
            return (Criteria) this;
        }

        public Criteria andDyneNumberGreaterThanOrEqualTo(String value) {
            addCriterion("DYNE_NUMBER >=", value, "dyneNumber");
            return (Criteria) this;
        }

        public Criteria andDyneNumberLessThan(String value) {
            addCriterion("DYNE_NUMBER <", value, "dyneNumber");
            return (Criteria) this;
        }

        public Criteria andDyneNumberLessThanOrEqualTo(String value) {
            addCriterion("DYNE_NUMBER <=", value, "dyneNumber");
            return (Criteria) this;
        }

        public Criteria andDyneNumberLike(String value) {
            addCriterion("DYNE_NUMBER like", value, "dyneNumber");
            return (Criteria) this;
        }

        public Criteria andDyneNumberNotLike(String value) {
            addCriterion("DYNE_NUMBER not like", value, "dyneNumber");
            return (Criteria) this;
        }

        public Criteria andDyneNumberIn(List<String> values) {
            addCriterion("DYNE_NUMBER in", values, "dyneNumber");
            return (Criteria) this;
        }

        public Criteria andDyneNumberNotIn(List<String> values) {
            addCriterion("DYNE_NUMBER not in", values, "dyneNumber");
            return (Criteria) this;
        }

        public Criteria andDyneNumberBetween(String value1, String value2) {
            addCriterion("DYNE_NUMBER between", value1, value2, "dyneNumber");
            return (Criteria) this;
        }

        public Criteria andDyneNumberNotBetween(String value1, String value2) {
            addCriterion("DYNE_NUMBER not between", value1, value2, "dyneNumber");
            return (Criteria) this;
        }

        public Criteria andOdIsNull() {
            addCriterion("OD is null");
            return (Criteria) this;
        }

        public Criteria andOdIsNotNull() {
            addCriterion("OD is not null");
            return (Criteria) this;
        }

        public Criteria andOdEqualTo(String value) {
            addCriterion("OD =", value, "od");
            return (Criteria) this;
        }

        public Criteria andOdNotEqualTo(String value) {
            addCriterion("OD <>", value, "od");
            return (Criteria) this;
        }

        public Criteria andOdGreaterThan(String value) {
            addCriterion("OD >", value, "od");
            return (Criteria) this;
        }

        public Criteria andOdGreaterThanOrEqualTo(String value) {
            addCriterion("OD >=", value, "od");
            return (Criteria) this;
        }

        public Criteria andOdLessThan(String value) {
            addCriterion("OD <", value, "od");
            return (Criteria) this;
        }

        public Criteria andOdLessThanOrEqualTo(String value) {
            addCriterion("OD <=", value, "od");
            return (Criteria) this;
        }

        public Criteria andOdLike(String value) {
            addCriterion("OD like", value, "od");
            return (Criteria) this;
        }

        public Criteria andOdNotLike(String value) {
            addCriterion("OD not like", value, "od");
            return (Criteria) this;
        }

        public Criteria andOdIn(List<String> values) {
            addCriterion("OD in", values, "od");
            return (Criteria) this;
        }

        public Criteria andOdNotIn(List<String> values) {
            addCriterion("OD not in", values, "od");
            return (Criteria) this;
        }

        public Criteria andOdBetween(String value1, String value2) {
            addCriterion("OD between", value1, value2, "od");
            return (Criteria) this;
        }

        public Criteria andOdNotBetween(String value1, String value2) {
            addCriterion("OD not between", value1, value2, "od");
            return (Criteria) this;
        }

        public Criteria andDevisePressureIsNull() {
            addCriterion("DEVISE_PRESSURE is null");
            return (Criteria) this;
        }

        public Criteria andDevisePressureIsNotNull() {
            addCriterion("DEVISE_PRESSURE is not null");
            return (Criteria) this;
        }

        public Criteria andDevisePressureEqualTo(String value) {
            addCriterion("DEVISE_PRESSURE =", value, "devisePressure");
            return (Criteria) this;
        }

        public Criteria andDevisePressureNotEqualTo(String value) {
            addCriterion("DEVISE_PRESSURE <>", value, "devisePressure");
            return (Criteria) this;
        }

        public Criteria andDevisePressureGreaterThan(String value) {
            addCriterion("DEVISE_PRESSURE >", value, "devisePressure");
            return (Criteria) this;
        }

        public Criteria andDevisePressureGreaterThanOrEqualTo(String value) {
            addCriterion("DEVISE_PRESSURE >=", value, "devisePressure");
            return (Criteria) this;
        }

        public Criteria andDevisePressureLessThan(String value) {
            addCriterion("DEVISE_PRESSURE <", value, "devisePressure");
            return (Criteria) this;
        }

        public Criteria andDevisePressureLessThanOrEqualTo(String value) {
            addCriterion("DEVISE_PRESSURE <=", value, "devisePressure");
            return (Criteria) this;
        }

        public Criteria andDevisePressureLike(String value) {
            addCriterion("DEVISE_PRESSURE like", value, "devisePressure");
            return (Criteria) this;
        }

        public Criteria andDevisePressureNotLike(String value) {
            addCriterion("DEVISE_PRESSURE not like", value, "devisePressure");
            return (Criteria) this;
        }

        public Criteria andDevisePressureIn(List<String> values) {
            addCriterion("DEVISE_PRESSURE in", values, "devisePressure");
            return (Criteria) this;
        }

        public Criteria andDevisePressureNotIn(List<String> values) {
            addCriterion("DEVISE_PRESSURE not in", values, "devisePressure");
            return (Criteria) this;
        }

        public Criteria andDevisePressureBetween(String value1, String value2) {
            addCriterion("DEVISE_PRESSURE between", value1, value2, "devisePressure");
            return (Criteria) this;
        }

        public Criteria andDevisePressureNotBetween(String value1, String value2) {
            addCriterion("DEVISE_PRESSURE not between", value1, value2, "devisePressure");
            return (Criteria) this;
        }

        public Criteria andDeviseTIsNull() {
            addCriterion("DEVISE_T is null");
            return (Criteria) this;
        }

        public Criteria andDeviseTIsNotNull() {
            addCriterion("DEVISE_T is not null");
            return (Criteria) this;
        }

        public Criteria andDeviseTEqualTo(String value) {
            addCriterion("DEVISE_T =", value, "deviseT");
            return (Criteria) this;
        }

        public Criteria andDeviseTNotEqualTo(String value) {
            addCriterion("DEVISE_T <>", value, "deviseT");
            return (Criteria) this;
        }

        public Criteria andDeviseTGreaterThan(String value) {
            addCriterion("DEVISE_T >", value, "deviseT");
            return (Criteria) this;
        }

        public Criteria andDeviseTGreaterThanOrEqualTo(String value) {
            addCriterion("DEVISE_T >=", value, "deviseT");
            return (Criteria) this;
        }

        public Criteria andDeviseTLessThan(String value) {
            addCriterion("DEVISE_T <", value, "deviseT");
            return (Criteria) this;
        }

        public Criteria andDeviseTLessThanOrEqualTo(String value) {
            addCriterion("DEVISE_T <=", value, "deviseT");
            return (Criteria) this;
        }

        public Criteria andDeviseTLike(String value) {
            addCriterion("DEVISE_T like", value, "deviseT");
            return (Criteria) this;
        }

        public Criteria andDeviseTNotLike(String value) {
            addCriterion("DEVISE_T not like", value, "deviseT");
            return (Criteria) this;
        }

        public Criteria andDeviseTIn(List<String> values) {
            addCriterion("DEVISE_T in", values, "deviseT");
            return (Criteria) this;
        }

        public Criteria andDeviseTNotIn(List<String> values) {
            addCriterion("DEVISE_T not in", values, "deviseT");
            return (Criteria) this;
        }

        public Criteria andDeviseTBetween(String value1, String value2) {
            addCriterion("DEVISE_T between", value1, value2, "deviseT");
            return (Criteria) this;
        }

        public Criteria andDeviseTNotBetween(String value1, String value2) {
            addCriterion("DEVISE_T not between", value1, value2, "deviseT");
            return (Criteria) this;
        }

        public Criteria andPipelineGradeIsNull() {
            addCriterion("PIPELINE_GRADE is null");
            return (Criteria) this;
        }

        public Criteria andPipelineGradeIsNotNull() {
            addCriterion("PIPELINE_GRADE is not null");
            return (Criteria) this;
        }

        public Criteria andPipelineGradeEqualTo(String value) {
            addCriterion("PIPELINE_GRADE =", value, "pipelineGrade");
            return (Criteria) this;
        }

        public Criteria andPipelineGradeNotEqualTo(String value) {
            addCriterion("PIPELINE_GRADE <>", value, "pipelineGrade");
            return (Criteria) this;
        }

        public Criteria andPipelineGradeGreaterThan(String value) {
            addCriterion("PIPELINE_GRADE >", value, "pipelineGrade");
            return (Criteria) this;
        }

        public Criteria andPipelineGradeGreaterThanOrEqualTo(String value) {
            addCriterion("PIPELINE_GRADE >=", value, "pipelineGrade");
            return (Criteria) this;
        }

        public Criteria andPipelineGradeLessThan(String value) {
            addCriterion("PIPELINE_GRADE <", value, "pipelineGrade");
            return (Criteria) this;
        }

        public Criteria andPipelineGradeLessThanOrEqualTo(String value) {
            addCriterion("PIPELINE_GRADE <=", value, "pipelineGrade");
            return (Criteria) this;
        }

        public Criteria andPipelineGradeLike(String value) {
            addCriterion("PIPELINE_GRADE like", value, "pipelineGrade");
            return (Criteria) this;
        }

        public Criteria andPipelineGradeNotLike(String value) {
            addCriterion("PIPELINE_GRADE not like", value, "pipelineGrade");
            return (Criteria) this;
        }

        public Criteria andPipelineGradeIn(List<String> values) {
            addCriterion("PIPELINE_GRADE in", values, "pipelineGrade");
            return (Criteria) this;
        }

        public Criteria andPipelineGradeNotIn(List<String> values) {
            addCriterion("PIPELINE_GRADE not in", values, "pipelineGrade");
            return (Criteria) this;
        }

        public Criteria andPipelineGradeBetween(String value1, String value2) {
            addCriterion("PIPELINE_GRADE between", value1, value2, "pipelineGrade");
            return (Criteria) this;
        }

        public Criteria andPipelineGradeNotBetween(String value1, String value2) {
            addCriterion("PIPELINE_GRADE not between", value1, value2, "pipelineGrade");
            return (Criteria) this;
        }

        public Criteria andTestPressureIsNull() {
            addCriterion("TEST_PRESSURE is null");
            return (Criteria) this;
        }

        public Criteria andTestPressureIsNotNull() {
            addCriterion("TEST_PRESSURE is not null");
            return (Criteria) this;
        }

        public Criteria andTestPressureEqualTo(String value) {
            addCriterion("TEST_PRESSURE =", value, "testPressure");
            return (Criteria) this;
        }

        public Criteria andTestPressureNotEqualTo(String value) {
            addCriterion("TEST_PRESSURE <>", value, "testPressure");
            return (Criteria) this;
        }

        public Criteria andTestPressureGreaterThan(String value) {
            addCriterion("TEST_PRESSURE >", value, "testPressure");
            return (Criteria) this;
        }

        public Criteria andTestPressureGreaterThanOrEqualTo(String value) {
            addCriterion("TEST_PRESSURE >=", value, "testPressure");
            return (Criteria) this;
        }

        public Criteria andTestPressureLessThan(String value) {
            addCriterion("TEST_PRESSURE <", value, "testPressure");
            return (Criteria) this;
        }

        public Criteria andTestPressureLessThanOrEqualTo(String value) {
            addCriterion("TEST_PRESSURE <=", value, "testPressure");
            return (Criteria) this;
        }

        public Criteria andTestPressureLike(String value) {
            addCriterion("TEST_PRESSURE like", value, "testPressure");
            return (Criteria) this;
        }

        public Criteria andTestPressureNotLike(String value) {
            addCriterion("TEST_PRESSURE not like", value, "testPressure");
            return (Criteria) this;
        }

        public Criteria andTestPressureIn(List<String> values) {
            addCriterion("TEST_PRESSURE in", values, "testPressure");
            return (Criteria) this;
        }

        public Criteria andTestPressureNotIn(List<String> values) {
            addCriterion("TEST_PRESSURE not in", values, "testPressure");
            return (Criteria) this;
        }

        public Criteria andTestPressureBetween(String value1, String value2) {
            addCriterion("TEST_PRESSURE between", value1, value2, "testPressure");
            return (Criteria) this;
        }

        public Criteria andTestPressureNotBetween(String value1, String value2) {
            addCriterion("TEST_PRESSURE not between", value1, value2, "testPressure");
            return (Criteria) this;
        }

        public Criteria andPidCodeIsNull() {
            addCriterion("PID_CODE is null");
            return (Criteria) this;
        }

        public Criteria andPidCodeIsNotNull() {
            addCriterion("PID_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andPidCodeEqualTo(String value) {
            addCriterion("PID_CODE =", value, "pidCode");
            return (Criteria) this;
        }

        public Criteria andPidCodeNotEqualTo(String value) {
            addCriterion("PID_CODE <>", value, "pidCode");
            return (Criteria) this;
        }

        public Criteria andPidCodeGreaterThan(String value) {
            addCriterion("PID_CODE >", value, "pidCode");
            return (Criteria) this;
        }

        public Criteria andPidCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PID_CODE >=", value, "pidCode");
            return (Criteria) this;
        }

        public Criteria andPidCodeLessThan(String value) {
            addCriterion("PID_CODE <", value, "pidCode");
            return (Criteria) this;
        }

        public Criteria andPidCodeLessThanOrEqualTo(String value) {
            addCriterion("PID_CODE <=", value, "pidCode");
            return (Criteria) this;
        }

        public Criteria andPidCodeLike(String value) {
            addCriterion("PID_CODE like", value, "pidCode");
            return (Criteria) this;
        }

        public Criteria andPidCodeNotLike(String value) {
            addCriterion("PID_CODE not like", value, "pidCode");
            return (Criteria) this;
        }

        public Criteria andPidCodeIn(List<String> values) {
            addCriterion("PID_CODE in", values, "pidCode");
            return (Criteria) this;
        }

        public Criteria andPidCodeNotIn(List<String> values) {
            addCriterion("PID_CODE not in", values, "pidCode");
            return (Criteria) this;
        }

        public Criteria andPidCodeBetween(String value1, String value2) {
            addCriterion("PID_CODE between", value1, value2, "pidCode");
            return (Criteria) this;
        }

        public Criteria andPidCodeNotBetween(String value1, String value2) {
            addCriterion("PID_CODE not between", value1, value2, "pidCode");
            return (Criteria) this;
        }

        public Criteria andTestPressurePackageCodeIsNull() {
            addCriterion("TEST_PRESSURE_PACKAGE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andTestPressurePackageCodeIsNotNull() {
            addCriterion("TEST_PRESSURE_PACKAGE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andTestPressurePackageCodeEqualTo(String value) {
            addCriterion("TEST_PRESSURE_PACKAGE_CODE =", value, "testPressurePackageCode");
            return (Criteria) this;
        }

        public Criteria andTestPressurePackageCodeNotEqualTo(String value) {
            addCriterion("TEST_PRESSURE_PACKAGE_CODE <>", value, "testPressurePackageCode");
            return (Criteria) this;
        }

        public Criteria andTestPressurePackageCodeGreaterThan(String value) {
            addCriterion("TEST_PRESSURE_PACKAGE_CODE >", value, "testPressurePackageCode");
            return (Criteria) this;
        }

        public Criteria andTestPressurePackageCodeGreaterThanOrEqualTo(String value) {
            addCriterion("TEST_PRESSURE_PACKAGE_CODE >=", value, "testPressurePackageCode");
            return (Criteria) this;
        }

        public Criteria andTestPressurePackageCodeLessThan(String value) {
            addCriterion("TEST_PRESSURE_PACKAGE_CODE <", value, "testPressurePackageCode");
            return (Criteria) this;
        }

        public Criteria andTestPressurePackageCodeLessThanOrEqualTo(String value) {
            addCriterion("TEST_PRESSURE_PACKAGE_CODE <=", value, "testPressurePackageCode");
            return (Criteria) this;
        }

        public Criteria andTestPressurePackageCodeLike(String value) {
            addCriterion("TEST_PRESSURE_PACKAGE_CODE like", value, "testPressurePackageCode");
            return (Criteria) this;
        }

        public Criteria andTestPressurePackageCodeNotLike(String value) {
            addCriterion("TEST_PRESSURE_PACKAGE_CODE not like", value, "testPressurePackageCode");
            return (Criteria) this;
        }

        public Criteria andTestPressurePackageCodeIn(List<String> values) {
            addCriterion("TEST_PRESSURE_PACKAGE_CODE in", values, "testPressurePackageCode");
            return (Criteria) this;
        }

        public Criteria andTestPressurePackageCodeNotIn(List<String> values) {
            addCriterion("TEST_PRESSURE_PACKAGE_CODE not in", values, "testPressurePackageCode");
            return (Criteria) this;
        }

        public Criteria andTestPressurePackageCodeBetween(String value1, String value2) {
            addCriterion("TEST_PRESSURE_PACKAGE_CODE between", value1, value2, "testPressurePackageCode");
            return (Criteria) this;
        }

        public Criteria andTestPressurePackageCodeNotBetween(String value1, String value2) {
            addCriterion("TEST_PRESSURE_PACKAGE_CODE not between", value1, value2, "testPressurePackageCode");
            return (Criteria) this;
        }

        public Criteria andWhetherNdtIsNull() {
            addCriterion("WHETHER_NDT is null");
            return (Criteria) this;
        }

        public Criteria andWhetherNdtIsNotNull() {
            addCriterion("WHETHER_NDT is not null");
            return (Criteria) this;
        }

        public Criteria andWhetherNdtEqualTo(String value) {
            addCriterion("WHETHER_NDT =", value, "whetherNdt");
            return (Criteria) this;
        }

        public Criteria andWhetherNdtNotEqualTo(String value) {
            addCriterion("WHETHER_NDT <>", value, "whetherNdt");
            return (Criteria) this;
        }

        public Criteria andWhetherNdtGreaterThan(String value) {
            addCriterion("WHETHER_NDT >", value, "whetherNdt");
            return (Criteria) this;
        }

        public Criteria andWhetherNdtGreaterThanOrEqualTo(String value) {
            addCriterion("WHETHER_NDT >=", value, "whetherNdt");
            return (Criteria) this;
        }

        public Criteria andWhetherNdtLessThan(String value) {
            addCriterion("WHETHER_NDT <", value, "whetherNdt");
            return (Criteria) this;
        }

        public Criteria andWhetherNdtLessThanOrEqualTo(String value) {
            addCriterion("WHETHER_NDT <=", value, "whetherNdt");
            return (Criteria) this;
        }

        public Criteria andWhetherNdtLike(String value) {
            addCriterion("WHETHER_NDT like", value, "whetherNdt");
            return (Criteria) this;
        }

        public Criteria andWhetherNdtNotLike(String value) {
            addCriterion("WHETHER_NDT not like", value, "whetherNdt");
            return (Criteria) this;
        }

        public Criteria andWhetherNdtIn(List<String> values) {
            addCriterion("WHETHER_NDT in", values, "whetherNdt");
            return (Criteria) this;
        }

        public Criteria andWhetherNdtNotIn(List<String> values) {
            addCriterion("WHETHER_NDT not in", values, "whetherNdt");
            return (Criteria) this;
        }

        public Criteria andWhetherNdtBetween(String value1, String value2) {
            addCriterion("WHETHER_NDT between", value1, value2, "whetherNdt");
            return (Criteria) this;
        }

        public Criteria andWhetherNdtNotBetween(String value1, String value2) {
            addCriterion("WHETHER_NDT not between", value1, value2, "whetherNdt");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("REMARKS is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("REMARKS is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("REMARKS =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("REMARKS <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("REMARKS >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("REMARKS >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("REMARKS <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("REMARKS <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("REMARKS like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("REMARKS not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("REMARKS in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("REMARKS not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("REMARKS between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("REMARKS not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andBuildUnitNameIsNull() {
            addCriterion("BUILD_UNIT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andBuildUnitNameIsNotNull() {
            addCriterion("BUILD_UNIT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andBuildUnitNameEqualTo(String value) {
            addCriterion("BUILD_UNIT_NAME =", value, "buildUnitName");
            return (Criteria) this;
        }

        public Criteria andBuildUnitNameNotEqualTo(String value) {
            addCriterion("BUILD_UNIT_NAME <>", value, "buildUnitName");
            return (Criteria) this;
        }

        public Criteria andBuildUnitNameGreaterThan(String value) {
            addCriterion("BUILD_UNIT_NAME >", value, "buildUnitName");
            return (Criteria) this;
        }

        public Criteria andBuildUnitNameGreaterThanOrEqualTo(String value) {
            addCriterion("BUILD_UNIT_NAME >=", value, "buildUnitName");
            return (Criteria) this;
        }

        public Criteria andBuildUnitNameLessThan(String value) {
            addCriterion("BUILD_UNIT_NAME <", value, "buildUnitName");
            return (Criteria) this;
        }

        public Criteria andBuildUnitNameLessThanOrEqualTo(String value) {
            addCriterion("BUILD_UNIT_NAME <=", value, "buildUnitName");
            return (Criteria) this;
        }

        public Criteria andBuildUnitNameLike(String value) {
            addCriterion("BUILD_UNIT_NAME like", value, "buildUnitName");
            return (Criteria) this;
        }

        public Criteria andBuildUnitNameNotLike(String value) {
            addCriterion("BUILD_UNIT_NAME not like", value, "buildUnitName");
            return (Criteria) this;
        }

        public Criteria andBuildUnitNameIn(List<String> values) {
            addCriterion("BUILD_UNIT_NAME in", values, "buildUnitName");
            return (Criteria) this;
        }

        public Criteria andBuildUnitNameNotIn(List<String> values) {
            addCriterion("BUILD_UNIT_NAME not in", values, "buildUnitName");
            return (Criteria) this;
        }

        public Criteria andBuildUnitNameBetween(String value1, String value2) {
            addCriterion("BUILD_UNIT_NAME between", value1, value2, "buildUnitName");
            return (Criteria) this;
        }

        public Criteria andBuildUnitNameNotBetween(String value1, String value2) {
            addCriterion("BUILD_UNIT_NAME not between", value1, value2, "buildUnitName");
            return (Criteria) this;
        }

        public Criteria andBuildUnitCodeIsNull() {
            addCriterion("BUILD_UNIT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andBuildUnitCodeIsNotNull() {
            addCriterion("BUILD_UNIT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andBuildUnitCodeEqualTo(String value) {
            addCriterion("BUILD_UNIT_CODE =", value, "buildUnitCode");
            return (Criteria) this;
        }

        public Criteria andBuildUnitCodeNotEqualTo(String value) {
            addCriterion("BUILD_UNIT_CODE <>", value, "buildUnitCode");
            return (Criteria) this;
        }

        public Criteria andBuildUnitCodeGreaterThan(String value) {
            addCriterion("BUILD_UNIT_CODE >", value, "buildUnitCode");
            return (Criteria) this;
        }

        public Criteria andBuildUnitCodeGreaterThanOrEqualTo(String value) {
            addCriterion("BUILD_UNIT_CODE >=", value, "buildUnitCode");
            return (Criteria) this;
        }

        public Criteria andBuildUnitCodeLessThan(String value) {
            addCriterion("BUILD_UNIT_CODE <", value, "buildUnitCode");
            return (Criteria) this;
        }

        public Criteria andBuildUnitCodeLessThanOrEqualTo(String value) {
            addCriterion("BUILD_UNIT_CODE <=", value, "buildUnitCode");
            return (Criteria) this;
        }

        public Criteria andBuildUnitCodeLike(String value) {
            addCriterion("BUILD_UNIT_CODE like", value, "buildUnitCode");
            return (Criteria) this;
        }

        public Criteria andBuildUnitCodeNotLike(String value) {
            addCriterion("BUILD_UNIT_CODE not like", value, "buildUnitCode");
            return (Criteria) this;
        }

        public Criteria andBuildUnitCodeIn(List<String> values) {
            addCriterion("BUILD_UNIT_CODE in", values, "buildUnitCode");
            return (Criteria) this;
        }

        public Criteria andBuildUnitCodeNotIn(List<String> values) {
            addCriterion("BUILD_UNIT_CODE not in", values, "buildUnitCode");
            return (Criteria) this;
        }

        public Criteria andBuildUnitCodeBetween(String value1, String value2) {
            addCriterion("BUILD_UNIT_CODE between", value1, value2, "buildUnitCode");
            return (Criteria) this;
        }

        public Criteria andBuildUnitCodeNotBetween(String value1, String value2) {
            addCriterion("BUILD_UNIT_CODE not between", value1, value2, "buildUnitCode");
            return (Criteria) this;
        }

        public Criteria andBuildUnitIdIsNull() {
            addCriterion("BUILD_UNIT_ID is null");
            return (Criteria) this;
        }

        public Criteria andBuildUnitIdIsNotNull() {
            addCriterion("BUILD_UNIT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBuildUnitIdEqualTo(String value) {
            addCriterion("BUILD_UNIT_ID =", value, "buildUnitId");
            return (Criteria) this;
        }

        public Criteria andBuildUnitIdNotEqualTo(String value) {
            addCriterion("BUILD_UNIT_ID <>", value, "buildUnitId");
            return (Criteria) this;
        }

        public Criteria andBuildUnitIdGreaterThan(String value) {
            addCriterion("BUILD_UNIT_ID >", value, "buildUnitId");
            return (Criteria) this;
        }

        public Criteria andBuildUnitIdGreaterThanOrEqualTo(String value) {
            addCriterion("BUILD_UNIT_ID >=", value, "buildUnitId");
            return (Criteria) this;
        }

        public Criteria andBuildUnitIdLessThan(String value) {
            addCriterion("BUILD_UNIT_ID <", value, "buildUnitId");
            return (Criteria) this;
        }

        public Criteria andBuildUnitIdLessThanOrEqualTo(String value) {
            addCriterion("BUILD_UNIT_ID <=", value, "buildUnitId");
            return (Criteria) this;
        }

        public Criteria andBuildUnitIdLike(String value) {
            addCriterion("BUILD_UNIT_ID like", value, "buildUnitId");
            return (Criteria) this;
        }

        public Criteria andBuildUnitIdNotLike(String value) {
            addCriterion("BUILD_UNIT_ID not like", value, "buildUnitId");
            return (Criteria) this;
        }

        public Criteria andBuildUnitIdIn(List<String> values) {
            addCriterion("BUILD_UNIT_ID in", values, "buildUnitId");
            return (Criteria) this;
        }

        public Criteria andBuildUnitIdNotIn(List<String> values) {
            addCriterion("BUILD_UNIT_ID not in", values, "buildUnitId");
            return (Criteria) this;
        }

        public Criteria andBuildUnitIdBetween(String value1, String value2) {
            addCriterion("BUILD_UNIT_ID between", value1, value2, "buildUnitId");
            return (Criteria) this;
        }

        public Criteria andBuildUnitIdNotBetween(String value1, String value2) {
            addCriterion("BUILD_UNIT_ID not between", value1, value2, "buildUnitId");
            return (Criteria) this;
        }

        public Criteria andRadiographedIsNull() {
            addCriterion("RADIOGRAPHED is null");
            return (Criteria) this;
        }

        public Criteria andRadiographedIsNotNull() {
            addCriterion("RADIOGRAPHED is not null");
            return (Criteria) this;
        }

        public Criteria andRadiographedEqualTo(String value) {
            addCriterion("RADIOGRAPHED =", value, "radiographed");
            return (Criteria) this;
        }

        public Criteria andRadiographedNotEqualTo(String value) {
            addCriterion("RADIOGRAPHED <>", value, "radiographed");
            return (Criteria) this;
        }

        public Criteria andRadiographedGreaterThan(String value) {
            addCriterion("RADIOGRAPHED >", value, "radiographed");
            return (Criteria) this;
        }

        public Criteria andRadiographedGreaterThanOrEqualTo(String value) {
            addCriterion("RADIOGRAPHED >=", value, "radiographed");
            return (Criteria) this;
        }

        public Criteria andRadiographedLessThan(String value) {
            addCriterion("RADIOGRAPHED <", value, "radiographed");
            return (Criteria) this;
        }

        public Criteria andRadiographedLessThanOrEqualTo(String value) {
            addCriterion("RADIOGRAPHED <=", value, "radiographed");
            return (Criteria) this;
        }

        public Criteria andRadiographedLike(String value) {
            addCriterion("RADIOGRAPHED like", value, "radiographed");
            return (Criteria) this;
        }

        public Criteria andRadiographedNotLike(String value) {
            addCriterion("RADIOGRAPHED not like", value, "radiographed");
            return (Criteria) this;
        }

        public Criteria andRadiographedIn(List<String> values) {
            addCriterion("RADIOGRAPHED in", values, "radiographed");
            return (Criteria) this;
        }

        public Criteria andRadiographedNotIn(List<String> values) {
            addCriterion("RADIOGRAPHED not in", values, "radiographed");
            return (Criteria) this;
        }

        public Criteria andRadiographedBetween(String value1, String value2) {
            addCriterion("RADIOGRAPHED between", value1, value2, "radiographed");
            return (Criteria) this;
        }

        public Criteria andRadiographedNotBetween(String value1, String value2) {
            addCriterion("RADIOGRAPHED not between", value1, value2, "radiographed");
            return (Criteria) this;
        }

        public Criteria andWbsNameIsNull() {
            addCriterion("WBS_NAME is null");
            return (Criteria) this;
        }

        public Criteria andWbsNameIsNotNull() {
            addCriterion("WBS_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andWbsNameEqualTo(String value) {
            addCriterion("WBS_NAME =", value, "wbsName");
            return (Criteria) this;
        }

        public Criteria andWbsNameNotEqualTo(String value) {
            addCriterion("WBS_NAME <>", value, "wbsName");
            return (Criteria) this;
        }

        public Criteria andWbsNameGreaterThan(String value) {
            addCriterion("WBS_NAME >", value, "wbsName");
            return (Criteria) this;
        }

        public Criteria andWbsNameGreaterThanOrEqualTo(String value) {
            addCriterion("WBS_NAME >=", value, "wbsName");
            return (Criteria) this;
        }

        public Criteria andWbsNameLessThan(String value) {
            addCriterion("WBS_NAME <", value, "wbsName");
            return (Criteria) this;
        }

        public Criteria andWbsNameLessThanOrEqualTo(String value) {
            addCriterion("WBS_NAME <=", value, "wbsName");
            return (Criteria) this;
        }

        public Criteria andWbsNameLike(String value) {
            addCriterion("WBS_NAME like", value, "wbsName");
            return (Criteria) this;
        }

        public Criteria andWbsNameNotLike(String value) {
            addCriterion("WBS_NAME not like", value, "wbsName");
            return (Criteria) this;
        }

        public Criteria andWbsNameIn(List<String> values) {
            addCriterion("WBS_NAME in", values, "wbsName");
            return (Criteria) this;
        }

        public Criteria andWbsNameNotIn(List<String> values) {
            addCriterion("WBS_NAME not in", values, "wbsName");
            return (Criteria) this;
        }

        public Criteria andWbsNameBetween(String value1, String value2) {
            addCriterion("WBS_NAME between", value1, value2, "wbsName");
            return (Criteria) this;
        }

        public Criteria andWbsNameNotBetween(String value1, String value2) {
            addCriterion("WBS_NAME not between", value1, value2, "wbsName");
            return (Criteria) this;
        }

        public Criteria andWbsIdIsNull() {
            addCriterion("WBS_ID is null");
            return (Criteria) this;
        }

        public Criteria andWbsIdIsNotNull() {
            addCriterion("WBS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWbsIdEqualTo(String value) {
            addCriterion("WBS_ID =", value, "wbsId");
            return (Criteria) this;
        }

        public Criteria andWbsIdNotEqualTo(String value) {
            addCriterion("WBS_ID <>", value, "wbsId");
            return (Criteria) this;
        }

        public Criteria andWbsIdGreaterThan(String value) {
            addCriterion("WBS_ID >", value, "wbsId");
            return (Criteria) this;
        }

        public Criteria andWbsIdGreaterThanOrEqualTo(String value) {
            addCriterion("WBS_ID >=", value, "wbsId");
            return (Criteria) this;
        }

        public Criteria andWbsIdLessThan(String value) {
            addCriterion("WBS_ID <", value, "wbsId");
            return (Criteria) this;
        }

        public Criteria andWbsIdLessThanOrEqualTo(String value) {
            addCriterion("WBS_ID <=", value, "wbsId");
            return (Criteria) this;
        }

        public Criteria andWbsIdLike(String value) {
            addCriterion("WBS_ID like", value, "wbsId");
            return (Criteria) this;
        }

        public Criteria andWbsIdNotLike(String value) {
            addCriterion("WBS_ID not like", value, "wbsId");
            return (Criteria) this;
        }

        public Criteria andWbsIdIn(List<String> values) {
            addCriterion("WBS_ID in", values, "wbsId");
            return (Criteria) this;
        }

        public Criteria andWbsIdNotIn(List<String> values) {
            addCriterion("WBS_ID not in", values, "wbsId");
            return (Criteria) this;
        }

        public Criteria andWbsIdBetween(String value1, String value2) {
            addCriterion("WBS_ID between", value1, value2, "wbsId");
            return (Criteria) this;
        }

        public Criteria andWbsIdNotBetween(String value1, String value2) {
            addCriterion("WBS_ID not between", value1, value2, "wbsId");
            return (Criteria) this;
        }

        public Criteria andWbsCodeIsNull() {
            addCriterion("WBS_CODE is null");
            return (Criteria) this;
        }

        public Criteria andWbsCodeIsNotNull() {
            addCriterion("WBS_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andWbsCodeEqualTo(String value) {
            addCriterion("WBS_CODE =", value, "wbsCode");
            return (Criteria) this;
        }

        public Criteria andWbsCodeNotEqualTo(String value) {
            addCriterion("WBS_CODE <>", value, "wbsCode");
            return (Criteria) this;
        }

        public Criteria andWbsCodeGreaterThan(String value) {
            addCriterion("WBS_CODE >", value, "wbsCode");
            return (Criteria) this;
        }

        public Criteria andWbsCodeGreaterThanOrEqualTo(String value) {
            addCriterion("WBS_CODE >=", value, "wbsCode");
            return (Criteria) this;
        }

        public Criteria andWbsCodeLessThan(String value) {
            addCriterion("WBS_CODE <", value, "wbsCode");
            return (Criteria) this;
        }

        public Criteria andWbsCodeLessThanOrEqualTo(String value) {
            addCriterion("WBS_CODE <=", value, "wbsCode");
            return (Criteria) this;
        }

        public Criteria andWbsCodeLike(String value) {
            addCriterion("WBS_CODE like", value, "wbsCode");
            return (Criteria) this;
        }

        public Criteria andWbsCodeNotLike(String value) {
            addCriterion("WBS_CODE not like", value, "wbsCode");
            return (Criteria) this;
        }

        public Criteria andWbsCodeIn(List<String> values) {
            addCriterion("WBS_CODE in", values, "wbsCode");
            return (Criteria) this;
        }

        public Criteria andWbsCodeNotIn(List<String> values) {
            addCriterion("WBS_CODE not in", values, "wbsCode");
            return (Criteria) this;
        }

        public Criteria andWbsCodeBetween(String value1, String value2) {
            addCriterion("WBS_CODE between", value1, value2, "wbsCode");
            return (Criteria) this;
        }

        public Criteria andWbsCodeNotBetween(String value1, String value2) {
            addCriterion("WBS_CODE not between", value1, value2, "wbsCode");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitNameIsNull() {
            addCriterion("SUPERVISION_UNIT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitNameIsNotNull() {
            addCriterion("SUPERVISION_UNIT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitNameEqualTo(String value) {
            addCriterion("SUPERVISION_UNIT_NAME =", value, "supervisionUnitName");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitNameNotEqualTo(String value) {
            addCriterion("SUPERVISION_UNIT_NAME <>", value, "supervisionUnitName");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitNameGreaterThan(String value) {
            addCriterion("SUPERVISION_UNIT_NAME >", value, "supervisionUnitName");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitNameGreaterThanOrEqualTo(String value) {
            addCriterion("SUPERVISION_UNIT_NAME >=", value, "supervisionUnitName");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitNameLessThan(String value) {
            addCriterion("SUPERVISION_UNIT_NAME <", value, "supervisionUnitName");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitNameLessThanOrEqualTo(String value) {
            addCriterion("SUPERVISION_UNIT_NAME <=", value, "supervisionUnitName");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitNameLike(String value) {
            addCriterion("SUPERVISION_UNIT_NAME like", value, "supervisionUnitName");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitNameNotLike(String value) {
            addCriterion("SUPERVISION_UNIT_NAME not like", value, "supervisionUnitName");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitNameIn(List<String> values) {
            addCriterion("SUPERVISION_UNIT_NAME in", values, "supervisionUnitName");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitNameNotIn(List<String> values) {
            addCriterion("SUPERVISION_UNIT_NAME not in", values, "supervisionUnitName");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitNameBetween(String value1, String value2) {
            addCriterion("SUPERVISION_UNIT_NAME between", value1, value2, "supervisionUnitName");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitNameNotBetween(String value1, String value2) {
            addCriterion("SUPERVISION_UNIT_NAME not between", value1, value2, "supervisionUnitName");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitCodeIsNull() {
            addCriterion("SUPERVISION_UNIT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitCodeIsNotNull() {
            addCriterion("SUPERVISION_UNIT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitCodeEqualTo(String value) {
            addCriterion("SUPERVISION_UNIT_CODE =", value, "supervisionUnitCode");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitCodeNotEqualTo(String value) {
            addCriterion("SUPERVISION_UNIT_CODE <>", value, "supervisionUnitCode");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitCodeGreaterThan(String value) {
            addCriterion("SUPERVISION_UNIT_CODE >", value, "supervisionUnitCode");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SUPERVISION_UNIT_CODE >=", value, "supervisionUnitCode");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitCodeLessThan(String value) {
            addCriterion("SUPERVISION_UNIT_CODE <", value, "supervisionUnitCode");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitCodeLessThanOrEqualTo(String value) {
            addCriterion("SUPERVISION_UNIT_CODE <=", value, "supervisionUnitCode");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitCodeLike(String value) {
            addCriterion("SUPERVISION_UNIT_CODE like", value, "supervisionUnitCode");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitCodeNotLike(String value) {
            addCriterion("SUPERVISION_UNIT_CODE not like", value, "supervisionUnitCode");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitCodeIn(List<String> values) {
            addCriterion("SUPERVISION_UNIT_CODE in", values, "supervisionUnitCode");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitCodeNotIn(List<String> values) {
            addCriterion("SUPERVISION_UNIT_CODE not in", values, "supervisionUnitCode");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitCodeBetween(String value1, String value2) {
            addCriterion("SUPERVISION_UNIT_CODE between", value1, value2, "supervisionUnitCode");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitCodeNotBetween(String value1, String value2) {
            addCriterion("SUPERVISION_UNIT_CODE not between", value1, value2, "supervisionUnitCode");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitIdIsNull() {
            addCriterion("SUPERVISION_UNIT_ID is null");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitIdIsNotNull() {
            addCriterion("SUPERVISION_UNIT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitIdEqualTo(String value) {
            addCriterion("SUPERVISION_UNIT_ID =", value, "supervisionUnitId");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitIdNotEqualTo(String value) {
            addCriterion("SUPERVISION_UNIT_ID <>", value, "supervisionUnitId");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitIdGreaterThan(String value) {
            addCriterion("SUPERVISION_UNIT_ID >", value, "supervisionUnitId");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitIdGreaterThanOrEqualTo(String value) {
            addCriterion("SUPERVISION_UNIT_ID >=", value, "supervisionUnitId");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitIdLessThan(String value) {
            addCriterion("SUPERVISION_UNIT_ID <", value, "supervisionUnitId");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitIdLessThanOrEqualTo(String value) {
            addCriterion("SUPERVISION_UNIT_ID <=", value, "supervisionUnitId");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitIdLike(String value) {
            addCriterion("SUPERVISION_UNIT_ID like", value, "supervisionUnitId");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitIdNotLike(String value) {
            addCriterion("SUPERVISION_UNIT_ID not like", value, "supervisionUnitId");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitIdIn(List<String> values) {
            addCriterion("SUPERVISION_UNIT_ID in", values, "supervisionUnitId");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitIdNotIn(List<String> values) {
            addCriterion("SUPERVISION_UNIT_ID not in", values, "supervisionUnitId");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitIdBetween(String value1, String value2) {
            addCriterion("SUPERVISION_UNIT_ID between", value1, value2, "supervisionUnitId");
            return (Criteria) this;
        }

        public Criteria andSupervisionUnitIdNotBetween(String value1, String value2) {
            addCriterion("SUPERVISION_UNIT_ID not between", value1, value2, "supervisionUnitId");
            return (Criteria) this;
        }

        public Criteria andSubmitterNameIsNull() {
            addCriterion("SUBMITTER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSubmitterNameIsNotNull() {
            addCriterion("SUBMITTER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitterNameEqualTo(String value) {
            addCriterion("SUBMITTER_NAME =", value, "submitterName");
            return (Criteria) this;
        }

        public Criteria andSubmitterNameNotEqualTo(String value) {
            addCriterion("SUBMITTER_NAME <>", value, "submitterName");
            return (Criteria) this;
        }

        public Criteria andSubmitterNameGreaterThan(String value) {
            addCriterion("SUBMITTER_NAME >", value, "submitterName");
            return (Criteria) this;
        }

        public Criteria andSubmitterNameGreaterThanOrEqualTo(String value) {
            addCriterion("SUBMITTER_NAME >=", value, "submitterName");
            return (Criteria) this;
        }

        public Criteria andSubmitterNameLessThan(String value) {
            addCriterion("SUBMITTER_NAME <", value, "submitterName");
            return (Criteria) this;
        }

        public Criteria andSubmitterNameLessThanOrEqualTo(String value) {
            addCriterion("SUBMITTER_NAME <=", value, "submitterName");
            return (Criteria) this;
        }

        public Criteria andSubmitterNameLike(String value) {
            addCriterion("SUBMITTER_NAME like", value, "submitterName");
            return (Criteria) this;
        }

        public Criteria andSubmitterNameNotLike(String value) {
            addCriterion("SUBMITTER_NAME not like", value, "submitterName");
            return (Criteria) this;
        }

        public Criteria andSubmitterNameIn(List<String> values) {
            addCriterion("SUBMITTER_NAME in", values, "submitterName");
            return (Criteria) this;
        }

        public Criteria andSubmitterNameNotIn(List<String> values) {
            addCriterion("SUBMITTER_NAME not in", values, "submitterName");
            return (Criteria) this;
        }

        public Criteria andSubmitterNameBetween(String value1, String value2) {
            addCriterion("SUBMITTER_NAME between", value1, value2, "submitterName");
            return (Criteria) this;
        }

        public Criteria andSubmitterNameNotBetween(String value1, String value2) {
            addCriterion("SUBMITTER_NAME not between", value1, value2, "submitterName");
            return (Criteria) this;
        }

        public Criteria andSubmitDateIsNull() {
            addCriterion("SUBMIT_DATE is null");
            return (Criteria) this;
        }

        public Criteria andSubmitDateIsNotNull() {
            addCriterion("SUBMIT_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitDateEqualTo(String value) {
            addCriterion("SUBMIT_DATE =", value, "submitDate");
            return (Criteria) this;
        }

        public Criteria andSubmitDateNotEqualTo(String value) {
            addCriterion("SUBMIT_DATE <>", value, "submitDate");
            return (Criteria) this;
        }

        public Criteria andSubmitDateGreaterThan(String value) {
            addCriterion("SUBMIT_DATE >", value, "submitDate");
            return (Criteria) this;
        }

        public Criteria andSubmitDateGreaterThanOrEqualTo(String value) {
            addCriterion("SUBMIT_DATE >=", value, "submitDate");
            return (Criteria) this;
        }

        public Criteria andSubmitDateLessThan(String value) {
            addCriterion("SUBMIT_DATE <", value, "submitDate");
            return (Criteria) this;
        }

        public Criteria andSubmitDateLessThanOrEqualTo(String value) {
            addCriterion("SUBMIT_DATE <=", value, "submitDate");
            return (Criteria) this;
        }

        public Criteria andSubmitDateLike(String value) {
            addCriterion("SUBMIT_DATE like", value, "submitDate");
            return (Criteria) this;
        }

        public Criteria andSubmitDateNotLike(String value) {
            addCriterion("SUBMIT_DATE not like", value, "submitDate");
            return (Criteria) this;
        }

        public Criteria andSubmitDateIn(List<String> values) {
            addCriterion("SUBMIT_DATE in", values, "submitDate");
            return (Criteria) this;
        }

        public Criteria andSubmitDateNotIn(List<String> values) {
            addCriterion("SUBMIT_DATE not in", values, "submitDate");
            return (Criteria) this;
        }

        public Criteria andSubmitDateBetween(String value1, String value2) {
            addCriterion("SUBMIT_DATE between", value1, value2, "submitDate");
            return (Criteria) this;
        }

        public Criteria andSubmitDateNotBetween(String value1, String value2) {
            addCriterion("SUBMIT_DATE not between", value1, value2, "submitDate");
            return (Criteria) this;
        }

        public Criteria andWeldJunctionNumberIsNull() {
            addCriterion("WELD_JUNCTION_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andWeldJunctionNumberIsNotNull() {
            addCriterion("WELD_JUNCTION_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andWeldJunctionNumberEqualTo(String value) {
            addCriterion("WELD_JUNCTION_NUMBER =", value, "weldJunctionNumber");
            return (Criteria) this;
        }

        public Criteria andWeldJunctionNumberNotEqualTo(String value) {
            addCriterion("WELD_JUNCTION_NUMBER <>", value, "weldJunctionNumber");
            return (Criteria) this;
        }

        public Criteria andWeldJunctionNumberGreaterThan(String value) {
            addCriterion("WELD_JUNCTION_NUMBER >", value, "weldJunctionNumber");
            return (Criteria) this;
        }

        public Criteria andWeldJunctionNumberGreaterThanOrEqualTo(String value) {
            addCriterion("WELD_JUNCTION_NUMBER >=", value, "weldJunctionNumber");
            return (Criteria) this;
        }

        public Criteria andWeldJunctionNumberLessThan(String value) {
            addCriterion("WELD_JUNCTION_NUMBER <", value, "weldJunctionNumber");
            return (Criteria) this;
        }

        public Criteria andWeldJunctionNumberLessThanOrEqualTo(String value) {
            addCriterion("WELD_JUNCTION_NUMBER <=", value, "weldJunctionNumber");
            return (Criteria) this;
        }

        public Criteria andWeldJunctionNumberLike(String value) {
            addCriterion("WELD_JUNCTION_NUMBER like", value, "weldJunctionNumber");
            return (Criteria) this;
        }

        public Criteria andWeldJunctionNumberNotLike(String value) {
            addCriterion("WELD_JUNCTION_NUMBER not like", value, "weldJunctionNumber");
            return (Criteria) this;
        }

        public Criteria andWeldJunctionNumberIn(List<String> values) {
            addCriterion("WELD_JUNCTION_NUMBER in", values, "weldJunctionNumber");
            return (Criteria) this;
        }

        public Criteria andWeldJunctionNumberNotIn(List<String> values) {
            addCriterion("WELD_JUNCTION_NUMBER not in", values, "weldJunctionNumber");
            return (Criteria) this;
        }

        public Criteria andWeldJunctionNumberBetween(String value1, String value2) {
            addCriterion("WELD_JUNCTION_NUMBER between", value1, value2, "weldJunctionNumber");
            return (Criteria) this;
        }

        public Criteria andWeldJunctionNumberNotBetween(String value1, String value2) {
            addCriterion("WELD_JUNCTION_NUMBER not between", value1, value2, "weldJunctionNumber");
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