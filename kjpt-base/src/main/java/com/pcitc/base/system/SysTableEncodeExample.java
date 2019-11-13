package com.pcitc.base.system;

import java.util.ArrayList;
import java.util.List;

public class SysTableEncodeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysTableEncodeExample() {
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

        public Criteria andTableEncodeNameIsNull() {
            addCriterion("table_encode_name is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeNameIsNotNull() {
            addCriterion("table_encode_name is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeNameEqualTo(String value) {
            addCriterion("table_encode_name =", value, "tableEncodeName");
            return (Criteria) this;
        }

        public Criteria andTableEncodeNameNotEqualTo(String value) {
            addCriterion("table_encode_name <>", value, "tableEncodeName");
            return (Criteria) this;
        }

        public Criteria andTableEncodeNameGreaterThan(String value) {
            addCriterion("table_encode_name >", value, "tableEncodeName");
            return (Criteria) this;
        }

        public Criteria andTableEncodeNameGreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_name >=", value, "tableEncodeName");
            return (Criteria) this;
        }

        public Criteria andTableEncodeNameLessThan(String value) {
            addCriterion("table_encode_name <", value, "tableEncodeName");
            return (Criteria) this;
        }

        public Criteria andTableEncodeNameLessThanOrEqualTo(String value) {
            addCriterion("table_encode_name <=", value, "tableEncodeName");
            return (Criteria) this;
        }

        public Criteria andTableEncodeNameLike(String value) {
            addCriterion("table_encode_name like", value, "tableEncodeName");
            return (Criteria) this;
        }

        public Criteria andTableEncodeNameNotLike(String value) {
            addCriterion("table_encode_name not like", value, "tableEncodeName");
            return (Criteria) this;
        }

        public Criteria andTableEncodeNameIn(List<String> values) {
            addCriterion("table_encode_name in", values, "tableEncodeName");
            return (Criteria) this;
        }

        public Criteria andTableEncodeNameNotIn(List<String> values) {
            addCriterion("table_encode_name not in", values, "tableEncodeName");
            return (Criteria) this;
        }

        public Criteria andTableEncodeNameBetween(String value1, String value2) {
            addCriterion("table_encode_name between", value1, value2, "tableEncodeName");
            return (Criteria) this;
        }

        public Criteria andTableEncodeNameNotBetween(String value1, String value2) {
            addCriterion("table_encode_name not between", value1, value2, "tableEncodeName");
            return (Criteria) this;
        }

        public Criteria andTableEncodeDemoIsNull() {
            addCriterion("table_encode_demo is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeDemoIsNotNull() {
            addCriterion("table_encode_demo is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeDemoEqualTo(String value) {
            addCriterion("table_encode_demo =", value, "tableEncodeDemo");
            return (Criteria) this;
        }

        public Criteria andTableEncodeDemoNotEqualTo(String value) {
            addCriterion("table_encode_demo <>", value, "tableEncodeDemo");
            return (Criteria) this;
        }

        public Criteria andTableEncodeDemoGreaterThan(String value) {
            addCriterion("table_encode_demo >", value, "tableEncodeDemo");
            return (Criteria) this;
        }

        public Criteria andTableEncodeDemoGreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_demo >=", value, "tableEncodeDemo");
            return (Criteria) this;
        }

        public Criteria andTableEncodeDemoLessThan(String value) {
            addCriterion("table_encode_demo <", value, "tableEncodeDemo");
            return (Criteria) this;
        }

        public Criteria andTableEncodeDemoLessThanOrEqualTo(String value) {
            addCriterion("table_encode_demo <=", value, "tableEncodeDemo");
            return (Criteria) this;
        }

        public Criteria andTableEncodeDemoLike(String value) {
            addCriterion("table_encode_demo like", value, "tableEncodeDemo");
            return (Criteria) this;
        }

        public Criteria andTableEncodeDemoNotLike(String value) {
            addCriterion("table_encode_demo not like", value, "tableEncodeDemo");
            return (Criteria) this;
        }

        public Criteria andTableEncodeDemoIn(List<String> values) {
            addCriterion("table_encode_demo in", values, "tableEncodeDemo");
            return (Criteria) this;
        }

        public Criteria andTableEncodeDemoNotIn(List<String> values) {
            addCriterion("table_encode_demo not in", values, "tableEncodeDemo");
            return (Criteria) this;
        }

        public Criteria andTableEncodeDemoBetween(String value1, String value2) {
            addCriterion("table_encode_demo between", value1, value2, "tableEncodeDemo");
            return (Criteria) this;
        }

        public Criteria andTableEncodeDemoNotBetween(String value1, String value2) {
            addCriterion("table_encode_demo not between", value1, value2, "tableEncodeDemo");
            return (Criteria) this;
        }

        public Criteria andTableEncodeFullValueIsNull() {
            addCriterion("table_encode_full_value is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeFullValueIsNotNull() {
            addCriterion("table_encode_full_value is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeFullValueEqualTo(String value) {
            addCriterion("table_encode_full_value =", value, "tableEncodeFullValue");
            return (Criteria) this;
        }

        public Criteria andTableEncodeFullValueNotEqualTo(String value) {
            addCriterion("table_encode_full_value <>", value, "tableEncodeFullValue");
            return (Criteria) this;
        }

        public Criteria andTableEncodeFullValueGreaterThan(String value) {
            addCriterion("table_encode_full_value >", value, "tableEncodeFullValue");
            return (Criteria) this;
        }

        public Criteria andTableEncodeFullValueGreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_full_value >=", value, "tableEncodeFullValue");
            return (Criteria) this;
        }

        public Criteria andTableEncodeFullValueLessThan(String value) {
            addCriterion("table_encode_full_value <", value, "tableEncodeFullValue");
            return (Criteria) this;
        }

        public Criteria andTableEncodeFullValueLessThanOrEqualTo(String value) {
            addCriterion("table_encode_full_value <=", value, "tableEncodeFullValue");
            return (Criteria) this;
        }

        public Criteria andTableEncodeFullValueLike(String value) {
            addCriterion("table_encode_full_value like", value, "tableEncodeFullValue");
            return (Criteria) this;
        }

        public Criteria andTableEncodeFullValueNotLike(String value) {
            addCriterion("table_encode_full_value not like", value, "tableEncodeFullValue");
            return (Criteria) this;
        }

        public Criteria andTableEncodeFullValueIn(List<String> values) {
            addCriterion("table_encode_full_value in", values, "tableEncodeFullValue");
            return (Criteria) this;
        }

        public Criteria andTableEncodeFullValueNotIn(List<String> values) {
            addCriterion("table_encode_full_value not in", values, "tableEncodeFullValue");
            return (Criteria) this;
        }

        public Criteria andTableEncodeFullValueBetween(String value1, String value2) {
            addCriterion("table_encode_full_value between", value1, value2, "tableEncodeFullValue");
            return (Criteria) this;
        }

        public Criteria andTableEncodeFullValueNotBetween(String value1, String value2) {
            addCriterion("table_encode_full_value not between", value1, value2, "tableEncodeFullValue");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectIdIsNull() {
            addCriterion("table_encode_project_id is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectIdIsNotNull() {
            addCriterion("table_encode_project_id is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectIdEqualTo(String value) {
            addCriterion("table_encode_project_id =", value, "tableEncodeProjectId");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectIdNotEqualTo(String value) {
            addCriterion("table_encode_project_id <>", value, "tableEncodeProjectId");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectIdGreaterThan(String value) {
            addCriterion("table_encode_project_id >", value, "tableEncodeProjectId");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_project_id >=", value, "tableEncodeProjectId");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectIdLessThan(String value) {
            addCriterion("table_encode_project_id <", value, "tableEncodeProjectId");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectIdLessThanOrEqualTo(String value) {
            addCriterion("table_encode_project_id <=", value, "tableEncodeProjectId");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectIdLike(String value) {
            addCriterion("table_encode_project_id like", value, "tableEncodeProjectId");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectIdNotLike(String value) {
            addCriterion("table_encode_project_id not like", value, "tableEncodeProjectId");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectIdIn(List<String> values) {
            addCriterion("table_encode_project_id in", values, "tableEncodeProjectId");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectIdNotIn(List<String> values) {
            addCriterion("table_encode_project_id not in", values, "tableEncodeProjectId");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectIdBetween(String value1, String value2) {
            addCriterion("table_encode_project_id between", value1, value2, "tableEncodeProjectId");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectIdNotBetween(String value1, String value2) {
            addCriterion("table_encode_project_id not between", value1, value2, "tableEncodeProjectId");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectNameIsNull() {
            addCriterion("table_encode_project_name is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectNameIsNotNull() {
            addCriterion("table_encode_project_name is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectNameEqualTo(String value) {
            addCriterion("table_encode_project_name =", value, "tableEncodeProjectName");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectNameNotEqualTo(String value) {
            addCriterion("table_encode_project_name <>", value, "tableEncodeProjectName");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectNameGreaterThan(String value) {
            addCriterion("table_encode_project_name >", value, "tableEncodeProjectName");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_project_name >=", value, "tableEncodeProjectName");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectNameLessThan(String value) {
            addCriterion("table_encode_project_name <", value, "tableEncodeProjectName");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectNameLessThanOrEqualTo(String value) {
            addCriterion("table_encode_project_name <=", value, "tableEncodeProjectName");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectNameLike(String value) {
            addCriterion("table_encode_project_name like", value, "tableEncodeProjectName");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectNameNotLike(String value) {
            addCriterion("table_encode_project_name not like", value, "tableEncodeProjectName");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectNameIn(List<String> values) {
            addCriterion("table_encode_project_name in", values, "tableEncodeProjectName");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectNameNotIn(List<String> values) {
            addCriterion("table_encode_project_name not in", values, "tableEncodeProjectName");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectNameBetween(String value1, String value2) {
            addCriterion("table_encode_project_name between", value1, value2, "tableEncodeProjectName");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectNameNotBetween(String value1, String value2) {
            addCriterion("table_encode_project_name not between", value1, value2, "tableEncodeProjectName");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectCodeIsNull() {
            addCriterion("table_encode_project_code is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectCodeIsNotNull() {
            addCriterion("table_encode_project_code is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectCodeEqualTo(String value) {
            addCriterion("table_encode_project_code =", value, "tableEncodeProjectCode");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectCodeNotEqualTo(String value) {
            addCriterion("table_encode_project_code <>", value, "tableEncodeProjectCode");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectCodeGreaterThan(String value) {
            addCriterion("table_encode_project_code >", value, "tableEncodeProjectCode");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectCodeGreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_project_code >=", value, "tableEncodeProjectCode");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectCodeLessThan(String value) {
            addCriterion("table_encode_project_code <", value, "tableEncodeProjectCode");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectCodeLessThanOrEqualTo(String value) {
            addCriterion("table_encode_project_code <=", value, "tableEncodeProjectCode");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectCodeLike(String value) {
            addCriterion("table_encode_project_code like", value, "tableEncodeProjectCode");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectCodeNotLike(String value) {
            addCriterion("table_encode_project_code not like", value, "tableEncodeProjectCode");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectCodeIn(List<String> values) {
            addCriterion("table_encode_project_code in", values, "tableEncodeProjectCode");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectCodeNotIn(List<String> values) {
            addCriterion("table_encode_project_code not in", values, "tableEncodeProjectCode");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectCodeBetween(String value1, String value2) {
            addCriterion("table_encode_project_code between", value1, value2, "tableEncodeProjectCode");
            return (Criteria) this;
        }

        public Criteria andTableEncodeProjectCodeNotBetween(String value1, String value2) {
            addCriterion("table_encode_project_code not between", value1, value2, "tableEncodeProjectCode");
            return (Criteria) this;
        }

        public Criteria andTableEncodeOrderlyIsNull() {
            addCriterion("table_encode_orderly is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeOrderlyIsNotNull() {
            addCriterion("table_encode_orderly is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeOrderlyEqualTo(String value) {
            addCriterion("table_encode_orderly =", value, "tableEncodeOrderly");
            return (Criteria) this;
        }

        public Criteria andTableEncodeOrderlyNotEqualTo(String value) {
            addCriterion("table_encode_orderly <>", value, "tableEncodeOrderly");
            return (Criteria) this;
        }

        public Criteria andTableEncodeOrderlyGreaterThan(String value) {
            addCriterion("table_encode_orderly >", value, "tableEncodeOrderly");
            return (Criteria) this;
        }

        public Criteria andTableEncodeOrderlyGreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_orderly >=", value, "tableEncodeOrderly");
            return (Criteria) this;
        }

        public Criteria andTableEncodeOrderlyLessThan(String value) {
            addCriterion("table_encode_orderly <", value, "tableEncodeOrderly");
            return (Criteria) this;
        }

        public Criteria andTableEncodeOrderlyLessThanOrEqualTo(String value) {
            addCriterion("table_encode_orderly <=", value, "tableEncodeOrderly");
            return (Criteria) this;
        }

        public Criteria andTableEncodeOrderlyLike(String value) {
            addCriterion("table_encode_orderly like", value, "tableEncodeOrderly");
            return (Criteria) this;
        }

        public Criteria andTableEncodeOrderlyNotLike(String value) {
            addCriterion("table_encode_orderly not like", value, "tableEncodeOrderly");
            return (Criteria) this;
        }

        public Criteria andTableEncodeOrderlyIn(List<String> values) {
            addCriterion("table_encode_orderly in", values, "tableEncodeOrderly");
            return (Criteria) this;
        }

        public Criteria andTableEncodeOrderlyNotIn(List<String> values) {
            addCriterion("table_encode_orderly not in", values, "tableEncodeOrderly");
            return (Criteria) this;
        }

        public Criteria andTableEncodeOrderlyBetween(String value1, String value2) {
            addCriterion("table_encode_orderly between", value1, value2, "tableEncodeOrderly");
            return (Criteria) this;
        }

        public Criteria andTableEncodeOrderlyNotBetween(String value1, String value2) {
            addCriterion("table_encode_orderly not between", value1, value2, "tableEncodeOrderly");
            return (Criteria) this;
        }

        public Criteria andTableEncodeShowIsNull() {
            addCriterion("table_encode_show is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeShowIsNotNull() {
            addCriterion("table_encode_show is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeShowEqualTo(String value) {
            addCriterion("table_encode_show =", value, "tableEncodeShow");
            return (Criteria) this;
        }

        public Criteria andTableEncodeShowNotEqualTo(String value) {
            addCriterion("table_encode_show <>", value, "tableEncodeShow");
            return (Criteria) this;
        }

        public Criteria andTableEncodeShowGreaterThan(String value) {
            addCriterion("table_encode_show >", value, "tableEncodeShow");
            return (Criteria) this;
        }

        public Criteria andTableEncodeShowGreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_show >=", value, "tableEncodeShow");
            return (Criteria) this;
        }

        public Criteria andTableEncodeShowLessThan(String value) {
            addCriterion("table_encode_show <", value, "tableEncodeShow");
            return (Criteria) this;
        }

        public Criteria andTableEncodeShowLessThanOrEqualTo(String value) {
            addCriterion("table_encode_show <=", value, "tableEncodeShow");
            return (Criteria) this;
        }

        public Criteria andTableEncodeShowLike(String value) {
            addCriterion("table_encode_show like", value, "tableEncodeShow");
            return (Criteria) this;
        }

        public Criteria andTableEncodeShowNotLike(String value) {
            addCriterion("table_encode_show not like", value, "tableEncodeShow");
            return (Criteria) this;
        }

        public Criteria andTableEncodeShowIn(List<String> values) {
            addCriterion("table_encode_show in", values, "tableEncodeShow");
            return (Criteria) this;
        }

        public Criteria andTableEncodeShowNotIn(List<String> values) {
            addCriterion("table_encode_show not in", values, "tableEncodeShow");
            return (Criteria) this;
        }

        public Criteria andTableEncodeShowBetween(String value1, String value2) {
            addCriterion("table_encode_show between", value1, value2, "tableEncodeShow");
            return (Criteria) this;
        }

        public Criteria andTableEncodeShowNotBetween(String value1, String value2) {
            addCriterion("table_encode_show not between", value1, value2, "tableEncodeShow");
            return (Criteria) this;
        }

        public Criteria andTableEncodeValidIsNull() {
            addCriterion("table_encode_valid is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeValidIsNotNull() {
            addCriterion("table_encode_valid is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeValidEqualTo(String value) {
            addCriterion("table_encode_valid =", value, "tableEncodeValid");
            return (Criteria) this;
        }

        public Criteria andTableEncodeValidNotEqualTo(String value) {
            addCriterion("table_encode_valid <>", value, "tableEncodeValid");
            return (Criteria) this;
        }

        public Criteria andTableEncodeValidGreaterThan(String value) {
            addCriterion("table_encode_valid >", value, "tableEncodeValid");
            return (Criteria) this;
        }

        public Criteria andTableEncodeValidGreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_valid >=", value, "tableEncodeValid");
            return (Criteria) this;
        }

        public Criteria andTableEncodeValidLessThan(String value) {
            addCriterion("table_encode_valid <", value, "tableEncodeValid");
            return (Criteria) this;
        }

        public Criteria andTableEncodeValidLessThanOrEqualTo(String value) {
            addCriterion("table_encode_valid <=", value, "tableEncodeValid");
            return (Criteria) this;
        }

        public Criteria andTableEncodeValidLike(String value) {
            addCriterion("table_encode_valid like", value, "tableEncodeValid");
            return (Criteria) this;
        }

        public Criteria andTableEncodeValidNotLike(String value) {
            addCriterion("table_encode_valid not like", value, "tableEncodeValid");
            return (Criteria) this;
        }

        public Criteria andTableEncodeValidIn(List<String> values) {
            addCriterion("table_encode_valid in", values, "tableEncodeValid");
            return (Criteria) this;
        }

        public Criteria andTableEncodeValidNotIn(List<String> values) {
            addCriterion("table_encode_valid not in", values, "tableEncodeValid");
            return (Criteria) this;
        }

        public Criteria andTableEncodeValidBetween(String value1, String value2) {
            addCriterion("table_encode_valid between", value1, value2, "tableEncodeValid");
            return (Criteria) this;
        }

        public Criteria andTableEncodeValidNotBetween(String value1, String value2) {
            addCriterion("table_encode_valid not between", value1, value2, "tableEncodeValid");
            return (Criteria) this;
        }

        public Criteria andTableEncodeValueTypeIsNull() {
            addCriterion("table_encode_value_type is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeValueTypeIsNotNull() {
            addCriterion("table_encode_value_type is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeValueTypeEqualTo(String value) {
            addCriterion("table_encode_value_type =", value, "tableEncodeValueType");
            return (Criteria) this;
        }

        public Criteria andTableEncodeValueTypeNotEqualTo(String value) {
            addCriterion("table_encode_value_type <>", value, "tableEncodeValueType");
            return (Criteria) this;
        }

        public Criteria andTableEncodeValueTypeGreaterThan(String value) {
            addCriterion("table_encode_value_type >", value, "tableEncodeValueType");
            return (Criteria) this;
        }

        public Criteria andTableEncodeValueTypeGreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_value_type >=", value, "tableEncodeValueType");
            return (Criteria) this;
        }

        public Criteria andTableEncodeValueTypeLessThan(String value) {
            addCriterion("table_encode_value_type <", value, "tableEncodeValueType");
            return (Criteria) this;
        }

        public Criteria andTableEncodeValueTypeLessThanOrEqualTo(String value) {
            addCriterion("table_encode_value_type <=", value, "tableEncodeValueType");
            return (Criteria) this;
        }

        public Criteria andTableEncodeValueTypeLike(String value) {
            addCriterion("table_encode_value_type like", value, "tableEncodeValueType");
            return (Criteria) this;
        }

        public Criteria andTableEncodeValueTypeNotLike(String value) {
            addCriterion("table_encode_value_type not like", value, "tableEncodeValueType");
            return (Criteria) this;
        }

        public Criteria andTableEncodeValueTypeIn(List<String> values) {
            addCriterion("table_encode_value_type in", values, "tableEncodeValueType");
            return (Criteria) this;
        }

        public Criteria andTableEncodeValueTypeNotIn(List<String> values) {
            addCriterion("table_encode_value_type not in", values, "tableEncodeValueType");
            return (Criteria) this;
        }

        public Criteria andTableEncodeValueTypeBetween(String value1, String value2) {
            addCriterion("table_encode_value_type between", value1, value2, "tableEncodeValueType");
            return (Criteria) this;
        }

        public Criteria andTableEncodeValueTypeNotBetween(String value1, String value2) {
            addCriterion("table_encode_value_type not between", value1, value2, "tableEncodeValueType");
            return (Criteria) this;
        }

        public Criteria andTableEncodeGroupSumIsNull() {
            addCriterion("table_encode_group_sum is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeGroupSumIsNotNull() {
            addCriterion("table_encode_group_sum is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeGroupSumEqualTo(String value) {
            addCriterion("table_encode_group_sum =", value, "tableEncodeGroupSum");
            return (Criteria) this;
        }

        public Criteria andTableEncodeGroupSumNotEqualTo(String value) {
            addCriterion("table_encode_group_sum <>", value, "tableEncodeGroupSum");
            return (Criteria) this;
        }

        public Criteria andTableEncodeGroupSumGreaterThan(String value) {
            addCriterion("table_encode_group_sum >", value, "tableEncodeGroupSum");
            return (Criteria) this;
        }

        public Criteria andTableEncodeGroupSumGreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_group_sum >=", value, "tableEncodeGroupSum");
            return (Criteria) this;
        }

        public Criteria andTableEncodeGroupSumLessThan(String value) {
            addCriterion("table_encode_group_sum <", value, "tableEncodeGroupSum");
            return (Criteria) this;
        }

        public Criteria andTableEncodeGroupSumLessThanOrEqualTo(String value) {
            addCriterion("table_encode_group_sum <=", value, "tableEncodeGroupSum");
            return (Criteria) this;
        }

        public Criteria andTableEncodeGroupSumLike(String value) {
            addCriterion("table_encode_group_sum like", value, "tableEncodeGroupSum");
            return (Criteria) this;
        }

        public Criteria andTableEncodeGroupSumNotLike(String value) {
            addCriterion("table_encode_group_sum not like", value, "tableEncodeGroupSum");
            return (Criteria) this;
        }

        public Criteria andTableEncodeGroupSumIn(List<String> values) {
            addCriterion("table_encode_group_sum in", values, "tableEncodeGroupSum");
            return (Criteria) this;
        }

        public Criteria andTableEncodeGroupSumNotIn(List<String> values) {
            addCriterion("table_encode_group_sum not in", values, "tableEncodeGroupSum");
            return (Criteria) this;
        }

        public Criteria andTableEncodeGroupSumBetween(String value1, String value2) {
            addCriterion("table_encode_group_sum between", value1, value2, "tableEncodeGroupSum");
            return (Criteria) this;
        }

        public Criteria andTableEncodeGroupSumNotBetween(String value1, String value2) {
            addCriterion("table_encode_group_sum not between", value1, value2, "tableEncodeGroupSum");
            return (Criteria) this;
        }

        public Criteria andTableEncodeAnnotationIsNull() {
            addCriterion("table_encode_annotation is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeAnnotationIsNotNull() {
            addCriterion("table_encode_annotation is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeAnnotationEqualTo(String value) {
            addCriterion("table_encode_annotation =", value, "tableEncodeAnnotation");
            return (Criteria) this;
        }

        public Criteria andTableEncodeAnnotationNotEqualTo(String value) {
            addCriterion("table_encode_annotation <>", value, "tableEncodeAnnotation");
            return (Criteria) this;
        }

        public Criteria andTableEncodeAnnotationGreaterThan(String value) {
            addCriterion("table_encode_annotation >", value, "tableEncodeAnnotation");
            return (Criteria) this;
        }

        public Criteria andTableEncodeAnnotationGreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_annotation >=", value, "tableEncodeAnnotation");
            return (Criteria) this;
        }

        public Criteria andTableEncodeAnnotationLessThan(String value) {
            addCriterion("table_encode_annotation <", value, "tableEncodeAnnotation");
            return (Criteria) this;
        }

        public Criteria andTableEncodeAnnotationLessThanOrEqualTo(String value) {
            addCriterion("table_encode_annotation <=", value, "tableEncodeAnnotation");
            return (Criteria) this;
        }

        public Criteria andTableEncodeAnnotationLike(String value) {
            addCriterion("table_encode_annotation like", value, "tableEncodeAnnotation");
            return (Criteria) this;
        }

        public Criteria andTableEncodeAnnotationNotLike(String value) {
            addCriterion("table_encode_annotation not like", value, "tableEncodeAnnotation");
            return (Criteria) this;
        }

        public Criteria andTableEncodeAnnotationIn(List<String> values) {
            addCriterion("table_encode_annotation in", values, "tableEncodeAnnotation");
            return (Criteria) this;
        }

        public Criteria andTableEncodeAnnotationNotIn(List<String> values) {
            addCriterion("table_encode_annotation not in", values, "tableEncodeAnnotation");
            return (Criteria) this;
        }

        public Criteria andTableEncodeAnnotationBetween(String value1, String value2) {
            addCriterion("table_encode_annotation between", value1, value2, "tableEncodeAnnotation");
            return (Criteria) this;
        }

        public Criteria andTableEncodeAnnotationNotBetween(String value1, String value2) {
            addCriterion("table_encode_annotation not between", value1, value2, "tableEncodeAnnotation");
            return (Criteria) this;
        }

        public Criteria andTableEncodeRemarkIsNull() {
            addCriterion("table_encode_remark is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeRemarkIsNotNull() {
            addCriterion("table_encode_remark is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeRemarkEqualTo(String value) {
            addCriterion("table_encode_remark =", value, "tableEncodeRemark");
            return (Criteria) this;
        }

        public Criteria andTableEncodeRemarkNotEqualTo(String value) {
            addCriterion("table_encode_remark <>", value, "tableEncodeRemark");
            return (Criteria) this;
        }

        public Criteria andTableEncodeRemarkGreaterThan(String value) {
            addCriterion("table_encode_remark >", value, "tableEncodeRemark");
            return (Criteria) this;
        }

        public Criteria andTableEncodeRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_remark >=", value, "tableEncodeRemark");
            return (Criteria) this;
        }

        public Criteria andTableEncodeRemarkLessThan(String value) {
            addCriterion("table_encode_remark <", value, "tableEncodeRemark");
            return (Criteria) this;
        }

        public Criteria andTableEncodeRemarkLessThanOrEqualTo(String value) {
            addCriterion("table_encode_remark <=", value, "tableEncodeRemark");
            return (Criteria) this;
        }

        public Criteria andTableEncodeRemarkLike(String value) {
            addCriterion("table_encode_remark like", value, "tableEncodeRemark");
            return (Criteria) this;
        }

        public Criteria andTableEncodeRemarkNotLike(String value) {
            addCriterion("table_encode_remark not like", value, "tableEncodeRemark");
            return (Criteria) this;
        }

        public Criteria andTableEncodeRemarkIn(List<String> values) {
            addCriterion("table_encode_remark in", values, "tableEncodeRemark");
            return (Criteria) this;
        }

        public Criteria andTableEncodeRemarkNotIn(List<String> values) {
            addCriterion("table_encode_remark not in", values, "tableEncodeRemark");
            return (Criteria) this;
        }

        public Criteria andTableEncodeRemarkBetween(String value1, String value2) {
            addCriterion("table_encode_remark between", value1, value2, "tableEncodeRemark");
            return (Criteria) this;
        }

        public Criteria andTableEncodeRemarkNotBetween(String value1, String value2) {
            addCriterion("table_encode_remark not between", value1, value2, "tableEncodeRemark");
            return (Criteria) this;
        }

        public Criteria andTableEncodeLevelIsNull() {
            addCriterion("table_encode_level is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeLevelIsNotNull() {
            addCriterion("table_encode_level is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeLevelEqualTo(String value) {
            addCriterion("table_encode_level =", value, "tableEncodeLevel");
            return (Criteria) this;
        }

        public Criteria andTableEncodeLevelNotEqualTo(String value) {
            addCriterion("table_encode_level <>", value, "tableEncodeLevel");
            return (Criteria) this;
        }

        public Criteria andTableEncodeLevelGreaterThan(String value) {
            addCriterion("table_encode_level >", value, "tableEncodeLevel");
            return (Criteria) this;
        }

        public Criteria andTableEncodeLevelGreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_level >=", value, "tableEncodeLevel");
            return (Criteria) this;
        }

        public Criteria andTableEncodeLevelLessThan(String value) {
            addCriterion("table_encode_level <", value, "tableEncodeLevel");
            return (Criteria) this;
        }

        public Criteria andTableEncodeLevelLessThanOrEqualTo(String value) {
            addCriterion("table_encode_level <=", value, "tableEncodeLevel");
            return (Criteria) this;
        }

        public Criteria andTableEncodeLevelLike(String value) {
            addCriterion("table_encode_level like", value, "tableEncodeLevel");
            return (Criteria) this;
        }

        public Criteria andTableEncodeLevelNotLike(String value) {
            addCriterion("table_encode_level not like", value, "tableEncodeLevel");
            return (Criteria) this;
        }

        public Criteria andTableEncodeLevelIn(List<String> values) {
            addCriterion("table_encode_level in", values, "tableEncodeLevel");
            return (Criteria) this;
        }

        public Criteria andTableEncodeLevelNotIn(List<String> values) {
            addCriterion("table_encode_level not in", values, "tableEncodeLevel");
            return (Criteria) this;
        }

        public Criteria andTableEncodeLevelBetween(String value1, String value2) {
            addCriterion("table_encode_level between", value1, value2, "tableEncodeLevel");
            return (Criteria) this;
        }

        public Criteria andTableEncodeLevelNotBetween(String value1, String value2) {
            addCriterion("table_encode_level not between", value1, value2, "tableEncodeLevel");
            return (Criteria) this;
        }

        public Criteria andTableEncodeRuleIsNull() {
            addCriterion("table_encode_rule is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeRuleIsNotNull() {
            addCriterion("table_encode_rule is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeRuleEqualTo(String value) {
            addCriterion("table_encode_rule =", value, "tableEncodeRule");
            return (Criteria) this;
        }

        public Criteria andTableEncodeRuleNotEqualTo(String value) {
            addCriterion("table_encode_rule <>", value, "tableEncodeRule");
            return (Criteria) this;
        }

        public Criteria andTableEncodeRuleGreaterThan(String value) {
            addCriterion("table_encode_rule >", value, "tableEncodeRule");
            return (Criteria) this;
        }

        public Criteria andTableEncodeRuleGreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_rule >=", value, "tableEncodeRule");
            return (Criteria) this;
        }

        public Criteria andTableEncodeRuleLessThan(String value) {
            addCriterion("table_encode_rule <", value, "tableEncodeRule");
            return (Criteria) this;
        }

        public Criteria andTableEncodeRuleLessThanOrEqualTo(String value) {
            addCriterion("table_encode_rule <=", value, "tableEncodeRule");
            return (Criteria) this;
        }

        public Criteria andTableEncodeRuleLike(String value) {
            addCriterion("table_encode_rule like", value, "tableEncodeRule");
            return (Criteria) this;
        }

        public Criteria andTableEncodeRuleNotLike(String value) {
            addCriterion("table_encode_rule not like", value, "tableEncodeRule");
            return (Criteria) this;
        }

        public Criteria andTableEncodeRuleIn(List<String> values) {
            addCriterion("table_encode_rule in", values, "tableEncodeRule");
            return (Criteria) this;
        }

        public Criteria andTableEncodeRuleNotIn(List<String> values) {
            addCriterion("table_encode_rule not in", values, "tableEncodeRule");
            return (Criteria) this;
        }

        public Criteria andTableEncodeRuleBetween(String value1, String value2) {
            addCriterion("table_encode_rule between", value1, value2, "tableEncodeRule");
            return (Criteria) this;
        }

        public Criteria andTableEncodeRuleNotBetween(String value1, String value2) {
            addCriterion("table_encode_rule not between", value1, value2, "tableEncodeRule");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType0IsNull() {
            addCriterion("table_encode_item_type_0 is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType0IsNotNull() {
            addCriterion("table_encode_item_type_0 is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType0EqualTo(String value) {
            addCriterion("table_encode_item_type_0 =", value, "tableEncodeItemType0");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType0NotEqualTo(String value) {
            addCriterion("table_encode_item_type_0 <>", value, "tableEncodeItemType0");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType0GreaterThan(String value) {
            addCriterion("table_encode_item_type_0 >", value, "tableEncodeItemType0");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType0GreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_item_type_0 >=", value, "tableEncodeItemType0");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType0LessThan(String value) {
            addCriterion("table_encode_item_type_0 <", value, "tableEncodeItemType0");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType0LessThanOrEqualTo(String value) {
            addCriterion("table_encode_item_type_0 <=", value, "tableEncodeItemType0");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType0Like(String value) {
            addCriterion("table_encode_item_type_0 like", value, "tableEncodeItemType0");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType0NotLike(String value) {
            addCriterion("table_encode_item_type_0 not like", value, "tableEncodeItemType0");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType0In(List<String> values) {
            addCriterion("table_encode_item_type_0 in", values, "tableEncodeItemType0");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType0NotIn(List<String> values) {
            addCriterion("table_encode_item_type_0 not in", values, "tableEncodeItemType0");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType0Between(String value1, String value2) {
            addCriterion("table_encode_item_type_0 between", value1, value2, "tableEncodeItemType0");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType0NotBetween(String value1, String value2) {
            addCriterion("table_encode_item_type_0 not between", value1, value2, "tableEncodeItemType0");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty0IsNull() {
            addCriterion("table_encode_item_property_0 is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty0IsNotNull() {
            addCriterion("table_encode_item_property_0 is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty0EqualTo(String value) {
            addCriterion("table_encode_item_property_0 =", value, "tableEncodeItemProperty0");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty0NotEqualTo(String value) {
            addCriterion("table_encode_item_property_0 <>", value, "tableEncodeItemProperty0");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty0GreaterThan(String value) {
            addCriterion("table_encode_item_property_0 >", value, "tableEncodeItemProperty0");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty0GreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_item_property_0 >=", value, "tableEncodeItemProperty0");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty0LessThan(String value) {
            addCriterion("table_encode_item_property_0 <", value, "tableEncodeItemProperty0");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty0LessThanOrEqualTo(String value) {
            addCriterion("table_encode_item_property_0 <=", value, "tableEncodeItemProperty0");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty0Like(String value) {
            addCriterion("table_encode_item_property_0 like", value, "tableEncodeItemProperty0");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty0NotLike(String value) {
            addCriterion("table_encode_item_property_0 not like", value, "tableEncodeItemProperty0");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty0In(List<String> values) {
            addCriterion("table_encode_item_property_0 in", values, "tableEncodeItemProperty0");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty0NotIn(List<String> values) {
            addCriterion("table_encode_item_property_0 not in", values, "tableEncodeItemProperty0");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty0Between(String value1, String value2) {
            addCriterion("table_encode_item_property_0 between", value1, value2, "tableEncodeItemProperty0");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty0NotBetween(String value1, String value2) {
            addCriterion("table_encode_item_property_0 not between", value1, value2, "tableEncodeItemProperty0");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue0IsNull() {
            addCriterion("table_encode_item_value_0 is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue0IsNotNull() {
            addCriterion("table_encode_item_value_0 is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue0EqualTo(String value) {
            addCriterion("table_encode_item_value_0 =", value, "tableEncodeItemValue0");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue0NotEqualTo(String value) {
            addCriterion("table_encode_item_value_0 <>", value, "tableEncodeItemValue0");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue0GreaterThan(String value) {
            addCriterion("table_encode_item_value_0 >", value, "tableEncodeItemValue0");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue0GreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_item_value_0 >=", value, "tableEncodeItemValue0");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue0LessThan(String value) {
            addCriterion("table_encode_item_value_0 <", value, "tableEncodeItemValue0");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue0LessThanOrEqualTo(String value) {
            addCriterion("table_encode_item_value_0 <=", value, "tableEncodeItemValue0");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue0Like(String value) {
            addCriterion("table_encode_item_value_0 like", value, "tableEncodeItemValue0");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue0NotLike(String value) {
            addCriterion("table_encode_item_value_0 not like", value, "tableEncodeItemValue0");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue0In(List<String> values) {
            addCriterion("table_encode_item_value_0 in", values, "tableEncodeItemValue0");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue0NotIn(List<String> values) {
            addCriterion("table_encode_item_value_0 not in", values, "tableEncodeItemValue0");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue0Between(String value1, String value2) {
            addCriterion("table_encode_item_value_0 between", value1, value2, "tableEncodeItemValue0");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue0NotBetween(String value1, String value2) {
            addCriterion("table_encode_item_value_0 not between", value1, value2, "tableEncodeItemValue0");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType1IsNull() {
            addCriterion("table_encode_item_type_1 is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType1IsNotNull() {
            addCriterion("table_encode_item_type_1 is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType1EqualTo(String value) {
            addCriterion("table_encode_item_type_1 =", value, "tableEncodeItemType1");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType1NotEqualTo(String value) {
            addCriterion("table_encode_item_type_1 <>", value, "tableEncodeItemType1");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType1GreaterThan(String value) {
            addCriterion("table_encode_item_type_1 >", value, "tableEncodeItemType1");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType1GreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_item_type_1 >=", value, "tableEncodeItemType1");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType1LessThan(String value) {
            addCriterion("table_encode_item_type_1 <", value, "tableEncodeItemType1");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType1LessThanOrEqualTo(String value) {
            addCriterion("table_encode_item_type_1 <=", value, "tableEncodeItemType1");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType1Like(String value) {
            addCriterion("table_encode_item_type_1 like", value, "tableEncodeItemType1");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType1NotLike(String value) {
            addCriterion("table_encode_item_type_1 not like", value, "tableEncodeItemType1");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType1In(List<String> values) {
            addCriterion("table_encode_item_type_1 in", values, "tableEncodeItemType1");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType1NotIn(List<String> values) {
            addCriterion("table_encode_item_type_1 not in", values, "tableEncodeItemType1");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType1Between(String value1, String value2) {
            addCriterion("table_encode_item_type_1 between", value1, value2, "tableEncodeItemType1");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType1NotBetween(String value1, String value2) {
            addCriterion("table_encode_item_type_1 not between", value1, value2, "tableEncodeItemType1");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty1IsNull() {
            addCriterion("table_encode_item_property_1 is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty1IsNotNull() {
            addCriterion("table_encode_item_property_1 is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty1EqualTo(String value) {
            addCriterion("table_encode_item_property_1 =", value, "tableEncodeItemProperty1");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty1NotEqualTo(String value) {
            addCriterion("table_encode_item_property_1 <>", value, "tableEncodeItemProperty1");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty1GreaterThan(String value) {
            addCriterion("table_encode_item_property_1 >", value, "tableEncodeItemProperty1");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty1GreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_item_property_1 >=", value, "tableEncodeItemProperty1");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty1LessThan(String value) {
            addCriterion("table_encode_item_property_1 <", value, "tableEncodeItemProperty1");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty1LessThanOrEqualTo(String value) {
            addCriterion("table_encode_item_property_1 <=", value, "tableEncodeItemProperty1");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty1Like(String value) {
            addCriterion("table_encode_item_property_1 like", value, "tableEncodeItemProperty1");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty1NotLike(String value) {
            addCriterion("table_encode_item_property_1 not like", value, "tableEncodeItemProperty1");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty1In(List<String> values) {
            addCriterion("table_encode_item_property_1 in", values, "tableEncodeItemProperty1");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty1NotIn(List<String> values) {
            addCriterion("table_encode_item_property_1 not in", values, "tableEncodeItemProperty1");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty1Between(String value1, String value2) {
            addCriterion("table_encode_item_property_1 between", value1, value2, "tableEncodeItemProperty1");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty1NotBetween(String value1, String value2) {
            addCriterion("table_encode_item_property_1 not between", value1, value2, "tableEncodeItemProperty1");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue1IsNull() {
            addCriterion("table_encode_item_value_1 is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue1IsNotNull() {
            addCriterion("table_encode_item_value_1 is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue1EqualTo(String value) {
            addCriterion("table_encode_item_value_1 =", value, "tableEncodeItemValue1");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue1NotEqualTo(String value) {
            addCriterion("table_encode_item_value_1 <>", value, "tableEncodeItemValue1");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue1GreaterThan(String value) {
            addCriterion("table_encode_item_value_1 >", value, "tableEncodeItemValue1");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue1GreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_item_value_1 >=", value, "tableEncodeItemValue1");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue1LessThan(String value) {
            addCriterion("table_encode_item_value_1 <", value, "tableEncodeItemValue1");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue1LessThanOrEqualTo(String value) {
            addCriterion("table_encode_item_value_1 <=", value, "tableEncodeItemValue1");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue1Like(String value) {
            addCriterion("table_encode_item_value_1 like", value, "tableEncodeItemValue1");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue1NotLike(String value) {
            addCriterion("table_encode_item_value_1 not like", value, "tableEncodeItemValue1");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue1In(List<String> values) {
            addCriterion("table_encode_item_value_1 in", values, "tableEncodeItemValue1");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue1NotIn(List<String> values) {
            addCriterion("table_encode_item_value_1 not in", values, "tableEncodeItemValue1");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue1Between(String value1, String value2) {
            addCriterion("table_encode_item_value_1 between", value1, value2, "tableEncodeItemValue1");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue1NotBetween(String value1, String value2) {
            addCriterion("table_encode_item_value_1 not between", value1, value2, "tableEncodeItemValue1");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType2IsNull() {
            addCriterion("table_encode_item_type_2 is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType2IsNotNull() {
            addCriterion("table_encode_item_type_2 is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType2EqualTo(String value) {
            addCriterion("table_encode_item_type_2 =", value, "tableEncodeItemType2");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType2NotEqualTo(String value) {
            addCriterion("table_encode_item_type_2 <>", value, "tableEncodeItemType2");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType2GreaterThan(String value) {
            addCriterion("table_encode_item_type_2 >", value, "tableEncodeItemType2");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType2GreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_item_type_2 >=", value, "tableEncodeItemType2");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType2LessThan(String value) {
            addCriterion("table_encode_item_type_2 <", value, "tableEncodeItemType2");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType2LessThanOrEqualTo(String value) {
            addCriterion("table_encode_item_type_2 <=", value, "tableEncodeItemType2");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType2Like(String value) {
            addCriterion("table_encode_item_type_2 like", value, "tableEncodeItemType2");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType2NotLike(String value) {
            addCriterion("table_encode_item_type_2 not like", value, "tableEncodeItemType2");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType2In(List<String> values) {
            addCriterion("table_encode_item_type_2 in", values, "tableEncodeItemType2");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType2NotIn(List<String> values) {
            addCriterion("table_encode_item_type_2 not in", values, "tableEncodeItemType2");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType2Between(String value1, String value2) {
            addCriterion("table_encode_item_type_2 between", value1, value2, "tableEncodeItemType2");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType2NotBetween(String value1, String value2) {
            addCriterion("table_encode_item_type_2 not between", value1, value2, "tableEncodeItemType2");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty2IsNull() {
            addCriterion("table_encode_item_property_2 is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty2IsNotNull() {
            addCriterion("table_encode_item_property_2 is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty2EqualTo(String value) {
            addCriterion("table_encode_item_property_2 =", value, "tableEncodeItemProperty2");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty2NotEqualTo(String value) {
            addCriterion("table_encode_item_property_2 <>", value, "tableEncodeItemProperty2");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty2GreaterThan(String value) {
            addCriterion("table_encode_item_property_2 >", value, "tableEncodeItemProperty2");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty2GreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_item_property_2 >=", value, "tableEncodeItemProperty2");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty2LessThan(String value) {
            addCriterion("table_encode_item_property_2 <", value, "tableEncodeItemProperty2");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty2LessThanOrEqualTo(String value) {
            addCriterion("table_encode_item_property_2 <=", value, "tableEncodeItemProperty2");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty2Like(String value) {
            addCriterion("table_encode_item_property_2 like", value, "tableEncodeItemProperty2");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty2NotLike(String value) {
            addCriterion("table_encode_item_property_2 not like", value, "tableEncodeItemProperty2");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty2In(List<String> values) {
            addCriterion("table_encode_item_property_2 in", values, "tableEncodeItemProperty2");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty2NotIn(List<String> values) {
            addCriterion("table_encode_item_property_2 not in", values, "tableEncodeItemProperty2");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty2Between(String value1, String value2) {
            addCriterion("table_encode_item_property_2 between", value1, value2, "tableEncodeItemProperty2");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty2NotBetween(String value1, String value2) {
            addCriterion("table_encode_item_property_2 not between", value1, value2, "tableEncodeItemProperty2");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue2IsNull() {
            addCriterion("table_encode_item_value_2 is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue2IsNotNull() {
            addCriterion("table_encode_item_value_2 is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue2EqualTo(String value) {
            addCriterion("table_encode_item_value_2 =", value, "tableEncodeItemValue2");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue2NotEqualTo(String value) {
            addCriterion("table_encode_item_value_2 <>", value, "tableEncodeItemValue2");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue2GreaterThan(String value) {
            addCriterion("table_encode_item_value_2 >", value, "tableEncodeItemValue2");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue2GreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_item_value_2 >=", value, "tableEncodeItemValue2");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue2LessThan(String value) {
            addCriterion("table_encode_item_value_2 <", value, "tableEncodeItemValue2");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue2LessThanOrEqualTo(String value) {
            addCriterion("table_encode_item_value_2 <=", value, "tableEncodeItemValue2");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue2Like(String value) {
            addCriterion("table_encode_item_value_2 like", value, "tableEncodeItemValue2");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue2NotLike(String value) {
            addCriterion("table_encode_item_value_2 not like", value, "tableEncodeItemValue2");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue2In(List<String> values) {
            addCriterion("table_encode_item_value_2 in", values, "tableEncodeItemValue2");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue2NotIn(List<String> values) {
            addCriterion("table_encode_item_value_2 not in", values, "tableEncodeItemValue2");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue2Between(String value1, String value2) {
            addCriterion("table_encode_item_value_2 between", value1, value2, "tableEncodeItemValue2");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue2NotBetween(String value1, String value2) {
            addCriterion("table_encode_item_value_2 not between", value1, value2, "tableEncodeItemValue2");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType3IsNull() {
            addCriterion("table_encode_item_type_3 is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType3IsNotNull() {
            addCriterion("table_encode_item_type_3 is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType3EqualTo(String value) {
            addCriterion("table_encode_item_type_3 =", value, "tableEncodeItemType3");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType3NotEqualTo(String value) {
            addCriterion("table_encode_item_type_3 <>", value, "tableEncodeItemType3");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType3GreaterThan(String value) {
            addCriterion("table_encode_item_type_3 >", value, "tableEncodeItemType3");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType3GreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_item_type_3 >=", value, "tableEncodeItemType3");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType3LessThan(String value) {
            addCriterion("table_encode_item_type_3 <", value, "tableEncodeItemType3");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType3LessThanOrEqualTo(String value) {
            addCriterion("table_encode_item_type_3 <=", value, "tableEncodeItemType3");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType3Like(String value) {
            addCriterion("table_encode_item_type_3 like", value, "tableEncodeItemType3");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType3NotLike(String value) {
            addCriterion("table_encode_item_type_3 not like", value, "tableEncodeItemType3");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType3In(List<String> values) {
            addCriterion("table_encode_item_type_3 in", values, "tableEncodeItemType3");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType3NotIn(List<String> values) {
            addCriterion("table_encode_item_type_3 not in", values, "tableEncodeItemType3");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType3Between(String value1, String value2) {
            addCriterion("table_encode_item_type_3 between", value1, value2, "tableEncodeItemType3");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType3NotBetween(String value1, String value2) {
            addCriterion("table_encode_item_type_3 not between", value1, value2, "tableEncodeItemType3");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty3IsNull() {
            addCriterion("table_encode_item_property_3 is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty3IsNotNull() {
            addCriterion("table_encode_item_property_3 is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty3EqualTo(String value) {
            addCriterion("table_encode_item_property_3 =", value, "tableEncodeItemProperty3");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty3NotEqualTo(String value) {
            addCriterion("table_encode_item_property_3 <>", value, "tableEncodeItemProperty3");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty3GreaterThan(String value) {
            addCriterion("table_encode_item_property_3 >", value, "tableEncodeItemProperty3");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty3GreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_item_property_3 >=", value, "tableEncodeItemProperty3");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty3LessThan(String value) {
            addCriterion("table_encode_item_property_3 <", value, "tableEncodeItemProperty3");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty3LessThanOrEqualTo(String value) {
            addCriterion("table_encode_item_property_3 <=", value, "tableEncodeItemProperty3");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty3Like(String value) {
            addCriterion("table_encode_item_property_3 like", value, "tableEncodeItemProperty3");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty3NotLike(String value) {
            addCriterion("table_encode_item_property_3 not like", value, "tableEncodeItemProperty3");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty3In(List<String> values) {
            addCriterion("table_encode_item_property_3 in", values, "tableEncodeItemProperty3");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty3NotIn(List<String> values) {
            addCriterion("table_encode_item_property_3 not in", values, "tableEncodeItemProperty3");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty3Between(String value1, String value2) {
            addCriterion("table_encode_item_property_3 between", value1, value2, "tableEncodeItemProperty3");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty3NotBetween(String value1, String value2) {
            addCriterion("table_encode_item_property_3 not between", value1, value2, "tableEncodeItemProperty3");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue3IsNull() {
            addCriterion("table_encode_item_value_3 is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue3IsNotNull() {
            addCriterion("table_encode_item_value_3 is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue3EqualTo(String value) {
            addCriterion("table_encode_item_value_3 =", value, "tableEncodeItemValue3");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue3NotEqualTo(String value) {
            addCriterion("table_encode_item_value_3 <>", value, "tableEncodeItemValue3");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue3GreaterThan(String value) {
            addCriterion("table_encode_item_value_3 >", value, "tableEncodeItemValue3");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue3GreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_item_value_3 >=", value, "tableEncodeItemValue3");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue3LessThan(String value) {
            addCriterion("table_encode_item_value_3 <", value, "tableEncodeItemValue3");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue3LessThanOrEqualTo(String value) {
            addCriterion("table_encode_item_value_3 <=", value, "tableEncodeItemValue3");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue3Like(String value) {
            addCriterion("table_encode_item_value_3 like", value, "tableEncodeItemValue3");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue3NotLike(String value) {
            addCriterion("table_encode_item_value_3 not like", value, "tableEncodeItemValue3");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue3In(List<String> values) {
            addCriterion("table_encode_item_value_3 in", values, "tableEncodeItemValue3");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue3NotIn(List<String> values) {
            addCriterion("table_encode_item_value_3 not in", values, "tableEncodeItemValue3");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue3Between(String value1, String value2) {
            addCriterion("table_encode_item_value_3 between", value1, value2, "tableEncodeItemValue3");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue3NotBetween(String value1, String value2) {
            addCriterion("table_encode_item_value_3 not between", value1, value2, "tableEncodeItemValue3");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType4IsNull() {
            addCriterion("table_encode_item_type_4 is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType4IsNotNull() {
            addCriterion("table_encode_item_type_4 is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType4EqualTo(String value) {
            addCriterion("table_encode_item_type_4 =", value, "tableEncodeItemType4");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType4NotEqualTo(String value) {
            addCriterion("table_encode_item_type_4 <>", value, "tableEncodeItemType4");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType4GreaterThan(String value) {
            addCriterion("table_encode_item_type_4 >", value, "tableEncodeItemType4");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType4GreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_item_type_4 >=", value, "tableEncodeItemType4");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType4LessThan(String value) {
            addCriterion("table_encode_item_type_4 <", value, "tableEncodeItemType4");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType4LessThanOrEqualTo(String value) {
            addCriterion("table_encode_item_type_4 <=", value, "tableEncodeItemType4");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType4Like(String value) {
            addCriterion("table_encode_item_type_4 like", value, "tableEncodeItemType4");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType4NotLike(String value) {
            addCriterion("table_encode_item_type_4 not like", value, "tableEncodeItemType4");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType4In(List<String> values) {
            addCriterion("table_encode_item_type_4 in", values, "tableEncodeItemType4");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType4NotIn(List<String> values) {
            addCriterion("table_encode_item_type_4 not in", values, "tableEncodeItemType4");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType4Between(String value1, String value2) {
            addCriterion("table_encode_item_type_4 between", value1, value2, "tableEncodeItemType4");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType4NotBetween(String value1, String value2) {
            addCriterion("table_encode_item_type_4 not between", value1, value2, "tableEncodeItemType4");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty4IsNull() {
            addCriterion("table_encode_item_property_4 is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty4IsNotNull() {
            addCriterion("table_encode_item_property_4 is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty4EqualTo(String value) {
            addCriterion("table_encode_item_property_4 =", value, "tableEncodeItemProperty4");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty4NotEqualTo(String value) {
            addCriterion("table_encode_item_property_4 <>", value, "tableEncodeItemProperty4");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty4GreaterThan(String value) {
            addCriterion("table_encode_item_property_4 >", value, "tableEncodeItemProperty4");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty4GreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_item_property_4 >=", value, "tableEncodeItemProperty4");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty4LessThan(String value) {
            addCriterion("table_encode_item_property_4 <", value, "tableEncodeItemProperty4");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty4LessThanOrEqualTo(String value) {
            addCriterion("table_encode_item_property_4 <=", value, "tableEncodeItemProperty4");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty4Like(String value) {
            addCriterion("table_encode_item_property_4 like", value, "tableEncodeItemProperty4");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty4NotLike(String value) {
            addCriterion("table_encode_item_property_4 not like", value, "tableEncodeItemProperty4");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty4In(List<String> values) {
            addCriterion("table_encode_item_property_4 in", values, "tableEncodeItemProperty4");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty4NotIn(List<String> values) {
            addCriterion("table_encode_item_property_4 not in", values, "tableEncodeItemProperty4");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty4Between(String value1, String value2) {
            addCriterion("table_encode_item_property_4 between", value1, value2, "tableEncodeItemProperty4");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty4NotBetween(String value1, String value2) {
            addCriterion("table_encode_item_property_4 not between", value1, value2, "tableEncodeItemProperty4");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue4IsNull() {
            addCriterion("table_encode_item_value_4 is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue4IsNotNull() {
            addCriterion("table_encode_item_value_4 is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue4EqualTo(String value) {
            addCriterion("table_encode_item_value_4 =", value, "tableEncodeItemValue4");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue4NotEqualTo(String value) {
            addCriterion("table_encode_item_value_4 <>", value, "tableEncodeItemValue4");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue4GreaterThan(String value) {
            addCriterion("table_encode_item_value_4 >", value, "tableEncodeItemValue4");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue4GreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_item_value_4 >=", value, "tableEncodeItemValue4");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue4LessThan(String value) {
            addCriterion("table_encode_item_value_4 <", value, "tableEncodeItemValue4");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue4LessThanOrEqualTo(String value) {
            addCriterion("table_encode_item_value_4 <=", value, "tableEncodeItemValue4");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue4Like(String value) {
            addCriterion("table_encode_item_value_4 like", value, "tableEncodeItemValue4");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue4NotLike(String value) {
            addCriterion("table_encode_item_value_4 not like", value, "tableEncodeItemValue4");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue4In(List<String> values) {
            addCriterion("table_encode_item_value_4 in", values, "tableEncodeItemValue4");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue4NotIn(List<String> values) {
            addCriterion("table_encode_item_value_4 not in", values, "tableEncodeItemValue4");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue4Between(String value1, String value2) {
            addCriterion("table_encode_item_value_4 between", value1, value2, "tableEncodeItemValue4");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue4NotBetween(String value1, String value2) {
            addCriterion("table_encode_item_value_4 not between", value1, value2, "tableEncodeItemValue4");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType5IsNull() {
            addCriterion("table_encode_item_type_5 is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType5IsNotNull() {
            addCriterion("table_encode_item_type_5 is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType5EqualTo(String value) {
            addCriterion("table_encode_item_type_5 =", value, "tableEncodeItemType5");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType5NotEqualTo(String value) {
            addCriterion("table_encode_item_type_5 <>", value, "tableEncodeItemType5");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType5GreaterThan(String value) {
            addCriterion("table_encode_item_type_5 >", value, "tableEncodeItemType5");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType5GreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_item_type_5 >=", value, "tableEncodeItemType5");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType5LessThan(String value) {
            addCriterion("table_encode_item_type_5 <", value, "tableEncodeItemType5");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType5LessThanOrEqualTo(String value) {
            addCriterion("table_encode_item_type_5 <=", value, "tableEncodeItemType5");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType5Like(String value) {
            addCriterion("table_encode_item_type_5 like", value, "tableEncodeItemType5");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType5NotLike(String value) {
            addCriterion("table_encode_item_type_5 not like", value, "tableEncodeItemType5");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType5In(List<String> values) {
            addCriterion("table_encode_item_type_5 in", values, "tableEncodeItemType5");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType5NotIn(List<String> values) {
            addCriterion("table_encode_item_type_5 not in", values, "tableEncodeItemType5");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType5Between(String value1, String value2) {
            addCriterion("table_encode_item_type_5 between", value1, value2, "tableEncodeItemType5");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType5NotBetween(String value1, String value2) {
            addCriterion("table_encode_item_type_5 not between", value1, value2, "tableEncodeItemType5");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty5IsNull() {
            addCriterion("table_encode_item_property_5 is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty5IsNotNull() {
            addCriterion("table_encode_item_property_5 is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty5EqualTo(String value) {
            addCriterion("table_encode_item_property_5 =", value, "tableEncodeItemProperty5");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty5NotEqualTo(String value) {
            addCriterion("table_encode_item_property_5 <>", value, "tableEncodeItemProperty5");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty5GreaterThan(String value) {
            addCriterion("table_encode_item_property_5 >", value, "tableEncodeItemProperty5");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty5GreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_item_property_5 >=", value, "tableEncodeItemProperty5");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty5LessThan(String value) {
            addCriterion("table_encode_item_property_5 <", value, "tableEncodeItemProperty5");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty5LessThanOrEqualTo(String value) {
            addCriterion("table_encode_item_property_5 <=", value, "tableEncodeItemProperty5");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty5Like(String value) {
            addCriterion("table_encode_item_property_5 like", value, "tableEncodeItemProperty5");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty5NotLike(String value) {
            addCriterion("table_encode_item_property_5 not like", value, "tableEncodeItemProperty5");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty5In(List<String> values) {
            addCriterion("table_encode_item_property_5 in", values, "tableEncodeItemProperty5");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty5NotIn(List<String> values) {
            addCriterion("table_encode_item_property_5 not in", values, "tableEncodeItemProperty5");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty5Between(String value1, String value2) {
            addCriterion("table_encode_item_property_5 between", value1, value2, "tableEncodeItemProperty5");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty5NotBetween(String value1, String value2) {
            addCriterion("table_encode_item_property_5 not between", value1, value2, "tableEncodeItemProperty5");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue5IsNull() {
            addCriterion("table_encode_item_value_5 is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue5IsNotNull() {
            addCriterion("table_encode_item_value_5 is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue5EqualTo(String value) {
            addCriterion("table_encode_item_value_5 =", value, "tableEncodeItemValue5");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue5NotEqualTo(String value) {
            addCriterion("table_encode_item_value_5 <>", value, "tableEncodeItemValue5");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue5GreaterThan(String value) {
            addCriterion("table_encode_item_value_5 >", value, "tableEncodeItemValue5");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue5GreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_item_value_5 >=", value, "tableEncodeItemValue5");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue5LessThan(String value) {
            addCriterion("table_encode_item_value_5 <", value, "tableEncodeItemValue5");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue5LessThanOrEqualTo(String value) {
            addCriterion("table_encode_item_value_5 <=", value, "tableEncodeItemValue5");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue5Like(String value) {
            addCriterion("table_encode_item_value_5 like", value, "tableEncodeItemValue5");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue5NotLike(String value) {
            addCriterion("table_encode_item_value_5 not like", value, "tableEncodeItemValue5");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue5In(List<String> values) {
            addCriterion("table_encode_item_value_5 in", values, "tableEncodeItemValue5");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue5NotIn(List<String> values) {
            addCriterion("table_encode_item_value_5 not in", values, "tableEncodeItemValue5");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue5Between(String value1, String value2) {
            addCriterion("table_encode_item_value_5 between", value1, value2, "tableEncodeItemValue5");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue5NotBetween(String value1, String value2) {
            addCriterion("table_encode_item_value_5 not between", value1, value2, "tableEncodeItemValue5");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType6IsNull() {
            addCriterion("table_encode_item_type_6 is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType6IsNotNull() {
            addCriterion("table_encode_item_type_6 is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType6EqualTo(String value) {
            addCriterion("table_encode_item_type_6 =", value, "tableEncodeItemType6");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType6NotEqualTo(String value) {
            addCriterion("table_encode_item_type_6 <>", value, "tableEncodeItemType6");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType6GreaterThan(String value) {
            addCriterion("table_encode_item_type_6 >", value, "tableEncodeItemType6");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType6GreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_item_type_6 >=", value, "tableEncodeItemType6");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType6LessThan(String value) {
            addCriterion("table_encode_item_type_6 <", value, "tableEncodeItemType6");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType6LessThanOrEqualTo(String value) {
            addCriterion("table_encode_item_type_6 <=", value, "tableEncodeItemType6");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType6Like(String value) {
            addCriterion("table_encode_item_type_6 like", value, "tableEncodeItemType6");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType6NotLike(String value) {
            addCriterion("table_encode_item_type_6 not like", value, "tableEncodeItemType6");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType6In(List<String> values) {
            addCriterion("table_encode_item_type_6 in", values, "tableEncodeItemType6");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType6NotIn(List<String> values) {
            addCriterion("table_encode_item_type_6 not in", values, "tableEncodeItemType6");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType6Between(String value1, String value2) {
            addCriterion("table_encode_item_type_6 between", value1, value2, "tableEncodeItemType6");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType6NotBetween(String value1, String value2) {
            addCriterion("table_encode_item_type_6 not between", value1, value2, "tableEncodeItemType6");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty6IsNull() {
            addCriterion("table_encode_item_property_6 is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty6IsNotNull() {
            addCriterion("table_encode_item_property_6 is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty6EqualTo(String value) {
            addCriterion("table_encode_item_property_6 =", value, "tableEncodeItemProperty6");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty6NotEqualTo(String value) {
            addCriterion("table_encode_item_property_6 <>", value, "tableEncodeItemProperty6");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty6GreaterThan(String value) {
            addCriterion("table_encode_item_property_6 >", value, "tableEncodeItemProperty6");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty6GreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_item_property_6 >=", value, "tableEncodeItemProperty6");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty6LessThan(String value) {
            addCriterion("table_encode_item_property_6 <", value, "tableEncodeItemProperty6");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty6LessThanOrEqualTo(String value) {
            addCriterion("table_encode_item_property_6 <=", value, "tableEncodeItemProperty6");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty6Like(String value) {
            addCriterion("table_encode_item_property_6 like", value, "tableEncodeItemProperty6");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty6NotLike(String value) {
            addCriterion("table_encode_item_property_6 not like", value, "tableEncodeItemProperty6");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty6In(List<String> values) {
            addCriterion("table_encode_item_property_6 in", values, "tableEncodeItemProperty6");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty6NotIn(List<String> values) {
            addCriterion("table_encode_item_property_6 not in", values, "tableEncodeItemProperty6");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty6Between(String value1, String value2) {
            addCriterion("table_encode_item_property_6 between", value1, value2, "tableEncodeItemProperty6");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty6NotBetween(String value1, String value2) {
            addCriterion("table_encode_item_property_6 not between", value1, value2, "tableEncodeItemProperty6");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue6IsNull() {
            addCriterion("table_encode_item_value_6 is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue6IsNotNull() {
            addCriterion("table_encode_item_value_6 is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue6EqualTo(String value) {
            addCriterion("table_encode_item_value_6 =", value, "tableEncodeItemValue6");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue6NotEqualTo(String value) {
            addCriterion("table_encode_item_value_6 <>", value, "tableEncodeItemValue6");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue6GreaterThan(String value) {
            addCriterion("table_encode_item_value_6 >", value, "tableEncodeItemValue6");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue6GreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_item_value_6 >=", value, "tableEncodeItemValue6");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue6LessThan(String value) {
            addCriterion("table_encode_item_value_6 <", value, "tableEncodeItemValue6");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue6LessThanOrEqualTo(String value) {
            addCriterion("table_encode_item_value_6 <=", value, "tableEncodeItemValue6");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue6Like(String value) {
            addCriterion("table_encode_item_value_6 like", value, "tableEncodeItemValue6");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue6NotLike(String value) {
            addCriterion("table_encode_item_value_6 not like", value, "tableEncodeItemValue6");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue6In(List<String> values) {
            addCriterion("table_encode_item_value_6 in", values, "tableEncodeItemValue6");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue6NotIn(List<String> values) {
            addCriterion("table_encode_item_value_6 not in", values, "tableEncodeItemValue6");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue6Between(String value1, String value2) {
            addCriterion("table_encode_item_value_6 between", value1, value2, "tableEncodeItemValue6");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue6NotBetween(String value1, String value2) {
            addCriterion("table_encode_item_value_6 not between", value1, value2, "tableEncodeItemValue6");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType7IsNull() {
            addCriterion("table_encode_item_type_7 is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType7IsNotNull() {
            addCriterion("table_encode_item_type_7 is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType7EqualTo(String value) {
            addCriterion("table_encode_item_type_7 =", value, "tableEncodeItemType7");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType7NotEqualTo(String value) {
            addCriterion("table_encode_item_type_7 <>", value, "tableEncodeItemType7");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType7GreaterThan(String value) {
            addCriterion("table_encode_item_type_7 >", value, "tableEncodeItemType7");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType7GreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_item_type_7 >=", value, "tableEncodeItemType7");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType7LessThan(String value) {
            addCriterion("table_encode_item_type_7 <", value, "tableEncodeItemType7");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType7LessThanOrEqualTo(String value) {
            addCriterion("table_encode_item_type_7 <=", value, "tableEncodeItemType7");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType7Like(String value) {
            addCriterion("table_encode_item_type_7 like", value, "tableEncodeItemType7");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType7NotLike(String value) {
            addCriterion("table_encode_item_type_7 not like", value, "tableEncodeItemType7");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType7In(List<String> values) {
            addCriterion("table_encode_item_type_7 in", values, "tableEncodeItemType7");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType7NotIn(List<String> values) {
            addCriterion("table_encode_item_type_7 not in", values, "tableEncodeItemType7");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType7Between(String value1, String value2) {
            addCriterion("table_encode_item_type_7 between", value1, value2, "tableEncodeItemType7");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType7NotBetween(String value1, String value2) {
            addCriterion("table_encode_item_type_7 not between", value1, value2, "tableEncodeItemType7");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty7IsNull() {
            addCriterion("table_encode_item_property_7 is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty7IsNotNull() {
            addCriterion("table_encode_item_property_7 is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty7EqualTo(String value) {
            addCriterion("table_encode_item_property_7 =", value, "tableEncodeItemProperty7");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty7NotEqualTo(String value) {
            addCriterion("table_encode_item_property_7 <>", value, "tableEncodeItemProperty7");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty7GreaterThan(String value) {
            addCriterion("table_encode_item_property_7 >", value, "tableEncodeItemProperty7");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty7GreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_item_property_7 >=", value, "tableEncodeItemProperty7");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty7LessThan(String value) {
            addCriterion("table_encode_item_property_7 <", value, "tableEncodeItemProperty7");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty7LessThanOrEqualTo(String value) {
            addCriterion("table_encode_item_property_7 <=", value, "tableEncodeItemProperty7");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty7Like(String value) {
            addCriterion("table_encode_item_property_7 like", value, "tableEncodeItemProperty7");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty7NotLike(String value) {
            addCriterion("table_encode_item_property_7 not like", value, "tableEncodeItemProperty7");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty7In(List<String> values) {
            addCriterion("table_encode_item_property_7 in", values, "tableEncodeItemProperty7");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty7NotIn(List<String> values) {
            addCriterion("table_encode_item_property_7 not in", values, "tableEncodeItemProperty7");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty7Between(String value1, String value2) {
            addCriterion("table_encode_item_property_7 between", value1, value2, "tableEncodeItemProperty7");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty7NotBetween(String value1, String value2) {
            addCriterion("table_encode_item_property_7 not between", value1, value2, "tableEncodeItemProperty7");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue7IsNull() {
            addCriterion("table_encode_item_value_7 is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue7IsNotNull() {
            addCriterion("table_encode_item_value_7 is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue7EqualTo(String value) {
            addCriterion("table_encode_item_value_7 =", value, "tableEncodeItemValue7");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue7NotEqualTo(String value) {
            addCriterion("table_encode_item_value_7 <>", value, "tableEncodeItemValue7");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue7GreaterThan(String value) {
            addCriterion("table_encode_item_value_7 >", value, "tableEncodeItemValue7");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue7GreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_item_value_7 >=", value, "tableEncodeItemValue7");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue7LessThan(String value) {
            addCriterion("table_encode_item_value_7 <", value, "tableEncodeItemValue7");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue7LessThanOrEqualTo(String value) {
            addCriterion("table_encode_item_value_7 <=", value, "tableEncodeItemValue7");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue7Like(String value) {
            addCriterion("table_encode_item_value_7 like", value, "tableEncodeItemValue7");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue7NotLike(String value) {
            addCriterion("table_encode_item_value_7 not like", value, "tableEncodeItemValue7");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue7In(List<String> values) {
            addCriterion("table_encode_item_value_7 in", values, "tableEncodeItemValue7");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue7NotIn(List<String> values) {
            addCriterion("table_encode_item_value_7 not in", values, "tableEncodeItemValue7");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue7Between(String value1, String value2) {
            addCriterion("table_encode_item_value_7 between", value1, value2, "tableEncodeItemValue7");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue7NotBetween(String value1, String value2) {
            addCriterion("table_encode_item_value_7 not between", value1, value2, "tableEncodeItemValue7");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType8IsNull() {
            addCriterion("table_encode_item_type_8 is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType8IsNotNull() {
            addCriterion("table_encode_item_type_8 is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType8EqualTo(String value) {
            addCriterion("table_encode_item_type_8 =", value, "tableEncodeItemType8");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType8NotEqualTo(String value) {
            addCriterion("table_encode_item_type_8 <>", value, "tableEncodeItemType8");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType8GreaterThan(String value) {
            addCriterion("table_encode_item_type_8 >", value, "tableEncodeItemType8");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType8GreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_item_type_8 >=", value, "tableEncodeItemType8");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType8LessThan(String value) {
            addCriterion("table_encode_item_type_8 <", value, "tableEncodeItemType8");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType8LessThanOrEqualTo(String value) {
            addCriterion("table_encode_item_type_8 <=", value, "tableEncodeItemType8");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType8Like(String value) {
            addCriterion("table_encode_item_type_8 like", value, "tableEncodeItemType8");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType8NotLike(String value) {
            addCriterion("table_encode_item_type_8 not like", value, "tableEncodeItemType8");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType8In(List<String> values) {
            addCriterion("table_encode_item_type_8 in", values, "tableEncodeItemType8");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType8NotIn(List<String> values) {
            addCriterion("table_encode_item_type_8 not in", values, "tableEncodeItemType8");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType8Between(String value1, String value2) {
            addCriterion("table_encode_item_type_8 between", value1, value2, "tableEncodeItemType8");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType8NotBetween(String value1, String value2) {
            addCriterion("table_encode_item_type_8 not between", value1, value2, "tableEncodeItemType8");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty8IsNull() {
            addCriterion("table_encode_item_property_8 is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty8IsNotNull() {
            addCriterion("table_encode_item_property_8 is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty8EqualTo(String value) {
            addCriterion("table_encode_item_property_8 =", value, "tableEncodeItemProperty8");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty8NotEqualTo(String value) {
            addCriterion("table_encode_item_property_8 <>", value, "tableEncodeItemProperty8");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty8GreaterThan(String value) {
            addCriterion("table_encode_item_property_8 >", value, "tableEncodeItemProperty8");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty8GreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_item_property_8 >=", value, "tableEncodeItemProperty8");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty8LessThan(String value) {
            addCriterion("table_encode_item_property_8 <", value, "tableEncodeItemProperty8");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty8LessThanOrEqualTo(String value) {
            addCriterion("table_encode_item_property_8 <=", value, "tableEncodeItemProperty8");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty8Like(String value) {
            addCriterion("table_encode_item_property_8 like", value, "tableEncodeItemProperty8");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty8NotLike(String value) {
            addCriterion("table_encode_item_property_8 not like", value, "tableEncodeItemProperty8");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty8In(List<String> values) {
            addCriterion("table_encode_item_property_8 in", values, "tableEncodeItemProperty8");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty8NotIn(List<String> values) {
            addCriterion("table_encode_item_property_8 not in", values, "tableEncodeItemProperty8");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty8Between(String value1, String value2) {
            addCriterion("table_encode_item_property_8 between", value1, value2, "tableEncodeItemProperty8");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty8NotBetween(String value1, String value2) {
            addCriterion("table_encode_item_property_8 not between", value1, value2, "tableEncodeItemProperty8");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue8IsNull() {
            addCriterion("table_encode_item_value_8 is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue8IsNotNull() {
            addCriterion("table_encode_item_value_8 is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue8EqualTo(String value) {
            addCriterion("table_encode_item_value_8 =", value, "tableEncodeItemValue8");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue8NotEqualTo(String value) {
            addCriterion("table_encode_item_value_8 <>", value, "tableEncodeItemValue8");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue8GreaterThan(String value) {
            addCriterion("table_encode_item_value_8 >", value, "tableEncodeItemValue8");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue8GreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_item_value_8 >=", value, "tableEncodeItemValue8");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue8LessThan(String value) {
            addCriterion("table_encode_item_value_8 <", value, "tableEncodeItemValue8");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue8LessThanOrEqualTo(String value) {
            addCriterion("table_encode_item_value_8 <=", value, "tableEncodeItemValue8");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue8Like(String value) {
            addCriterion("table_encode_item_value_8 like", value, "tableEncodeItemValue8");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue8NotLike(String value) {
            addCriterion("table_encode_item_value_8 not like", value, "tableEncodeItemValue8");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue8In(List<String> values) {
            addCriterion("table_encode_item_value_8 in", values, "tableEncodeItemValue8");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue8NotIn(List<String> values) {
            addCriterion("table_encode_item_value_8 not in", values, "tableEncodeItemValue8");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue8Between(String value1, String value2) {
            addCriterion("table_encode_item_value_8 between", value1, value2, "tableEncodeItemValue8");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue8NotBetween(String value1, String value2) {
            addCriterion("table_encode_item_value_8 not between", value1, value2, "tableEncodeItemValue8");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType9IsNull() {
            addCriterion("table_encode_item_type_9 is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType9IsNotNull() {
            addCriterion("table_encode_item_type_9 is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType9EqualTo(String value) {
            addCriterion("table_encode_item_type_9 =", value, "tableEncodeItemType9");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType9NotEqualTo(String value) {
            addCriterion("table_encode_item_type_9 <>", value, "tableEncodeItemType9");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType9GreaterThan(String value) {
            addCriterion("table_encode_item_type_9 >", value, "tableEncodeItemType9");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType9GreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_item_type_9 >=", value, "tableEncodeItemType9");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType9LessThan(String value) {
            addCriterion("table_encode_item_type_9 <", value, "tableEncodeItemType9");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType9LessThanOrEqualTo(String value) {
            addCriterion("table_encode_item_type_9 <=", value, "tableEncodeItemType9");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType9Like(String value) {
            addCriterion("table_encode_item_type_9 like", value, "tableEncodeItemType9");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType9NotLike(String value) {
            addCriterion("table_encode_item_type_9 not like", value, "tableEncodeItemType9");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType9In(List<String> values) {
            addCriterion("table_encode_item_type_9 in", values, "tableEncodeItemType9");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType9NotIn(List<String> values) {
            addCriterion("table_encode_item_type_9 not in", values, "tableEncodeItemType9");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType9Between(String value1, String value2) {
            addCriterion("table_encode_item_type_9 between", value1, value2, "tableEncodeItemType9");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemType9NotBetween(String value1, String value2) {
            addCriterion("table_encode_item_type_9 not between", value1, value2, "tableEncodeItemType9");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty9IsNull() {
            addCriterion("table_encode_item_property_9 is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty9IsNotNull() {
            addCriterion("table_encode_item_property_9 is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty9EqualTo(String value) {
            addCriterion("table_encode_item_property_9 =", value, "tableEncodeItemProperty9");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty9NotEqualTo(String value) {
            addCriterion("table_encode_item_property_9 <>", value, "tableEncodeItemProperty9");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty9GreaterThan(String value) {
            addCriterion("table_encode_item_property_9 >", value, "tableEncodeItemProperty9");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty9GreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_item_property_9 >=", value, "tableEncodeItemProperty9");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty9LessThan(String value) {
            addCriterion("table_encode_item_property_9 <", value, "tableEncodeItemProperty9");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty9LessThanOrEqualTo(String value) {
            addCriterion("table_encode_item_property_9 <=", value, "tableEncodeItemProperty9");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty9Like(String value) {
            addCriterion("table_encode_item_property_9 like", value, "tableEncodeItemProperty9");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty9NotLike(String value) {
            addCriterion("table_encode_item_property_9 not like", value, "tableEncodeItemProperty9");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty9In(List<String> values) {
            addCriterion("table_encode_item_property_9 in", values, "tableEncodeItemProperty9");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty9NotIn(List<String> values) {
            addCriterion("table_encode_item_property_9 not in", values, "tableEncodeItemProperty9");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty9Between(String value1, String value2) {
            addCriterion("table_encode_item_property_9 between", value1, value2, "tableEncodeItemProperty9");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemProperty9NotBetween(String value1, String value2) {
            addCriterion("table_encode_item_property_9 not between", value1, value2, "tableEncodeItemProperty9");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue9IsNull() {
            addCriterion("table_encode_item_value_9 is null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue9IsNotNull() {
            addCriterion("table_encode_item_value_9 is not null");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue9EqualTo(String value) {
            addCriterion("table_encode_item_value_9 =", value, "tableEncodeItemValue9");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue9NotEqualTo(String value) {
            addCriterion("table_encode_item_value_9 <>", value, "tableEncodeItemValue9");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue9GreaterThan(String value) {
            addCriterion("table_encode_item_value_9 >", value, "tableEncodeItemValue9");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue9GreaterThanOrEqualTo(String value) {
            addCriterion("table_encode_item_value_9 >=", value, "tableEncodeItemValue9");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue9LessThan(String value) {
            addCriterion("table_encode_item_value_9 <", value, "tableEncodeItemValue9");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue9LessThanOrEqualTo(String value) {
            addCriterion("table_encode_item_value_9 <=", value, "tableEncodeItemValue9");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue9Like(String value) {
            addCriterion("table_encode_item_value_9 like", value, "tableEncodeItemValue9");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue9NotLike(String value) {
            addCriterion("table_encode_item_value_9 not like", value, "tableEncodeItemValue9");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue9In(List<String> values) {
            addCriterion("table_encode_item_value_9 in", values, "tableEncodeItemValue9");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue9NotIn(List<String> values) {
            addCriterion("table_encode_item_value_9 not in", values, "tableEncodeItemValue9");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue9Between(String value1, String value2) {
            addCriterion("table_encode_item_value_9 between", value1, value2, "tableEncodeItemValue9");
            return (Criteria) this;
        }

        public Criteria andTableEncodeItemValue9NotBetween(String value1, String value2) {
            addCriterion("table_encode_item_value_9 not between", value1, value2, "tableEncodeItemValue9");
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