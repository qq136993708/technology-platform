package com.pcitc.base.engin.quality.weld.vo;

import java.util.ArrayList;
import java.util.List;

public class WelderVoExample {
	
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public WelderVoExample() {
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

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
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

        public Criteria andCreateUserNameIsNull() {
            addCriterion("CREATE_USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIsNotNull() {
            addCriterion("CREATE_USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameEqualTo(String value) {
            addCriterion("CREATE_USER_NAME =", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotEqualTo(String value) {
            addCriterion("CREATE_USER_NAME <>", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameGreaterThan(String value) {
            addCriterion("CREATE_USER_NAME >", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_USER_NAME >=", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLessThan(String value) {
            addCriterion("CREATE_USER_NAME <", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLessThanOrEqualTo(String value) {
            addCriterion("CREATE_USER_NAME <=", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLike(String value) {
            addCriterion("CREATE_USER_NAME like", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotLike(String value) {
            addCriterion("CREATE_USER_NAME not like", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIn(List<String> values) {
            addCriterion("CREATE_USER_NAME in", values, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotIn(List<String> values) {
            addCriterion("CREATE_USER_NAME not in", values, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameBetween(String value1, String value2) {
            addCriterion("CREATE_USER_NAME between", value1, value2, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotBetween(String value1, String value2) {
            addCriterion("CREATE_USER_NAME not between", value1, value2, "createUserName");
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

        public Criteria andUpdateUserNameIsNull() {
            addCriterion("UPDATE_USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameIsNotNull() {
            addCriterion("UPDATE_USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameEqualTo(String value) {
            addCriterion("UPDATE_USER_NAME =", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotEqualTo(String value) {
            addCriterion("UPDATE_USER_NAME <>", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameGreaterThan(String value) {
            addCriterion("UPDATE_USER_NAME >", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_USER_NAME >=", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLessThan(String value) {
            addCriterion("UPDATE_USER_NAME <", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_USER_NAME <=", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLike(String value) {
            addCriterion("UPDATE_USER_NAME like", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotLike(String value) {
            addCriterion("UPDATE_USER_NAME not like", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameIn(List<String> values) {
            addCriterion("UPDATE_USER_NAME in", values, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotIn(List<String> values) {
            addCriterion("UPDATE_USER_NAME not in", values, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameBetween(String value1, String value2) {
            addCriterion("UPDATE_USER_NAME between", value1, value2, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotBetween(String value1, String value2) {
            addCriterion("UPDATE_USER_NAME not between", value1, value2, "updateUserName");
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

        public Criteria andUnitIdIsNull() {
            addCriterion("UNIT_ID is null");
            return (Criteria) this;
        }

        public Criteria andUnitIdIsNotNull() {
            addCriterion("UNIT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUnitIdEqualTo(String value) {
            addCriterion("UNIT_ID =", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdNotEqualTo(String value) {
            addCriterion("UNIT_ID <>", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdGreaterThan(String value) {
            addCriterion("UNIT_ID >", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdGreaterThanOrEqualTo(String value) {
            addCriterion("UNIT_ID >=", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdLessThan(String value) {
            addCriterion("UNIT_ID <", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdLessThanOrEqualTo(String value) {
            addCriterion("UNIT_ID <=", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdLike(String value) {
            addCriterion("UNIT_ID like", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdNotLike(String value) {
            addCriterion("UNIT_ID not like", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdIn(List<String> values) {
            addCriterion("UNIT_ID in", values, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdNotIn(List<String> values) {
            addCriterion("UNIT_ID not in", values, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdBetween(String value1, String value2) {
            addCriterion("UNIT_ID between", value1, value2, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdNotBetween(String value1, String value2) {
            addCriterion("UNIT_ID not between", value1, value2, "unitId");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNull() {
            addCriterion("DEL_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("DEL_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(String value) {
            addCriterion("DEL_FLAG =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(String value) {
            addCriterion("DEL_FLAG <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(String value) {
            addCriterion("DEL_FLAG >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(String value) {
            addCriterion("DEL_FLAG >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(String value) {
            addCriterion("DEL_FLAG <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(String value) {
            addCriterion("DEL_FLAG <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLike(String value) {
            addCriterion("DEL_FLAG like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotLike(String value) {
            addCriterion("DEL_FLAG not like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<String> values) {
            addCriterion("DEL_FLAG in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<String> values) {
            addCriterion("DEL_FLAG not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(String value1, String value2) {
            addCriterion("DEL_FLAG between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(String value1, String value2) {
            addCriterion("DEL_FLAG not between", value1, value2, "delFlag");
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

        public Criteria andCompanyCodeIsNull() {
            addCriterion("COMPANY_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeIsNotNull() {
            addCriterion("COMPANY_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeEqualTo(String value) {
            addCriterion("COMPANY_CODE =", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotEqualTo(String value) {
            addCriterion("COMPANY_CODE <>", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeGreaterThan(String value) {
            addCriterion("COMPANY_CODE >", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("COMPANY_CODE >=", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeLessThan(String value) {
            addCriterion("COMPANY_CODE <", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeLessThanOrEqualTo(String value) {
            addCriterion("COMPANY_CODE <=", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeLike(String value) {
            addCriterion("COMPANY_CODE like", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotLike(String value) {
            addCriterion("COMPANY_CODE not like", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeIn(List<String> values) {
            addCriterion("COMPANY_CODE in", values, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotIn(List<String> values) {
            addCriterion("COMPANY_CODE not in", values, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeBetween(String value1, String value2) {
            addCriterion("COMPANY_CODE between", value1, value2, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotBetween(String value1, String value2) {
            addCriterion("COMPANY_CODE not between", value1, value2, "companyCode");
            return (Criteria) this;
        }

        public Criteria andWelderCodeIsNull() {
            addCriterion("WELDER_CODE is null");
            return (Criteria) this;
        }

        public Criteria andWelderCodeIsNotNull() {
            addCriterion("WELDER_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andWelderCodeEqualTo(String value) {
            addCriterion("WELDER_CODE =", value, "welderCode");
            return (Criteria) this;
        }

        public Criteria andWelderCodeNotEqualTo(String value) {
            addCriterion("WELDER_CODE <>", value, "welderCode");
            return (Criteria) this;
        }

        public Criteria andWelderCodeGreaterThan(String value) {
            addCriterion("WELDER_CODE >", value, "welderCode");
            return (Criteria) this;
        }

        public Criteria andWelderCodeGreaterThanOrEqualTo(String value) {
            addCriterion("WELDER_CODE >=", value, "welderCode");
            return (Criteria) this;
        }

        public Criteria andWelderCodeLessThan(String value) {
            addCriterion("WELDER_CODE <", value, "welderCode");
            return (Criteria) this;
        }

        public Criteria andWelderCodeLessThanOrEqualTo(String value) {
            addCriterion("WELDER_CODE <=", value, "welderCode");
            return (Criteria) this;
        }

        public Criteria andWelderCodeLike(String value) {
            addCriterion("WELDER_CODE like", value, "welderCode");
            return (Criteria) this;
        }

        public Criteria andWelderCodeNotLike(String value) {
            addCriterion("WELDER_CODE not like", value, "welderCode");
            return (Criteria) this;
        }

        public Criteria andWelderCodeIn(List<String> values) {
            addCriterion("WELDER_CODE in", values, "welderCode");
            return (Criteria) this;
        }

        public Criteria andWelderCodeNotIn(List<String> values) {
            addCriterion("WELDER_CODE not in", values, "welderCode");
            return (Criteria) this;
        }

        public Criteria andWelderCodeBetween(String value1, String value2) {
            addCriterion("WELDER_CODE between", value1, value2, "welderCode");
            return (Criteria) this;
        }

        public Criteria andWelderCodeNotBetween(String value1, String value2) {
            addCriterion("WELDER_CODE not between", value1, value2, "welderCode");
            return (Criteria) this;
        }

        public Criteria andWelderNameIsNull() {
            addCriterion("WELDER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andWelderNameIsNotNull() {
            addCriterion("WELDER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andWelderNameEqualTo(String value) {
            addCriterion("WELDER_NAME =", value, "welderName");
            return (Criteria) this;
        }

        public Criteria andWelderNameNotEqualTo(String value) {
            addCriterion("WELDER_NAME <>", value, "welderName");
            return (Criteria) this;
        }

        public Criteria andWelderNameGreaterThan(String value) {
            addCriterion("WELDER_NAME >", value, "welderName");
            return (Criteria) this;
        }

        public Criteria andWelderNameGreaterThanOrEqualTo(String value) {
            addCriterion("WELDER_NAME >=", value, "welderName");
            return (Criteria) this;
        }

        public Criteria andWelderNameLessThan(String value) {
            addCriterion("WELDER_NAME <", value, "welderName");
            return (Criteria) this;
        }

        public Criteria andWelderNameLessThanOrEqualTo(String value) {
            addCriterion("WELDER_NAME <=", value, "welderName");
            return (Criteria) this;
        }

        public Criteria andWelderNameLike(String value) {
            addCriterion("WELDER_NAME like", value, "welderName");
            return (Criteria) this;
        }

        public Criteria andWelderNameNotLike(String value) {
            addCriterion("WELDER_NAME not like", value, "welderName");
            return (Criteria) this;
        }

        public Criteria andWelderNameIn(List<String> values) {
            addCriterion("WELDER_NAME in", values, "welderName");
            return (Criteria) this;
        }

        public Criteria andWelderNameNotIn(List<String> values) {
            addCriterion("WELDER_NAME not in", values, "welderName");
            return (Criteria) this;
        }

        public Criteria andWelderNameBetween(String value1, String value2) {
            addCriterion("WELDER_NAME between", value1, value2, "welderName");
            return (Criteria) this;
        }

        public Criteria andWelderNameNotBetween(String value1, String value2) {
            addCriterion("WELDER_NAME not between", value1, value2, "welderName");
            return (Criteria) this;
        }

        public Criteria andIdCardNoIsNull() {
            addCriterion("ID_CARD_NO is null");
            return (Criteria) this;
        }

        public Criteria andIdCardNoIsNotNull() {
            addCriterion("ID_CARD_NO is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardNoEqualTo(String value) {
            addCriterion("ID_CARD_NO =", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoNotEqualTo(String value) {
            addCriterion("ID_CARD_NO <>", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoGreaterThan(String value) {
            addCriterion("ID_CARD_NO >", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("ID_CARD_NO >=", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoLessThan(String value) {
            addCriterion("ID_CARD_NO <", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoLessThanOrEqualTo(String value) {
            addCriterion("ID_CARD_NO <=", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoLike(String value) {
            addCriterion("ID_CARD_NO like", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoNotLike(String value) {
            addCriterion("ID_CARD_NO not like", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoIn(List<String> values) {
            addCriterion("ID_CARD_NO in", values, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoNotIn(List<String> values) {
            addCriterion("ID_CARD_NO not in", values, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoBetween(String value1, String value2) {
            addCriterion("ID_CARD_NO between", value1, value2, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoNotBetween(String value1, String value2) {
            addCriterion("ID_CARD_NO not between", value1, value2, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andCiceIsNull() {
            addCriterion("CICE is null");
            return (Criteria) this;
        }

        public Criteria andCiceIsNotNull() {
            addCriterion("CICE is not null");
            return (Criteria) this;
        }

        public Criteria andCiceEqualTo(String value) {
            addCriterion("CICE =", value, "cice");
            return (Criteria) this;
        }

        public Criteria andCiceNotEqualTo(String value) {
            addCriterion("CICE <>", value, "cice");
            return (Criteria) this;
        }

        public Criteria andCiceGreaterThan(String value) {
            addCriterion("CICE >", value, "cice");
            return (Criteria) this;
        }

        public Criteria andCiceGreaterThanOrEqualTo(String value) {
            addCriterion("CICE >=", value, "cice");
            return (Criteria) this;
        }

        public Criteria andCiceLessThan(String value) {
            addCriterion("CICE <", value, "cice");
            return (Criteria) this;
        }

        public Criteria andCiceLessThanOrEqualTo(String value) {
            addCriterion("CICE <=", value, "cice");
            return (Criteria) this;
        }

        public Criteria andCiceLike(String value) {
            addCriterion("CICE like", value, "cice");
            return (Criteria) this;
        }

        public Criteria andCiceNotLike(String value) {
            addCriterion("CICE not like", value, "cice");
            return (Criteria) this;
        }

        public Criteria andCiceIn(List<String> values) {
            addCriterion("CICE in", values, "cice");
            return (Criteria) this;
        }

        public Criteria andCiceNotIn(List<String> values) {
            addCriterion("CICE not in", values, "cice");
            return (Criteria) this;
        }

        public Criteria andCiceBetween(String value1, String value2) {
            addCriterion("CICE between", value1, value2, "cice");
            return (Criteria) this;
        }

        public Criteria andCiceNotBetween(String value1, String value2) {
            addCriterion("CICE not between", value1, value2, "cice");
            return (Criteria) this;
        }

        public Criteria andCheckUnitIsNull() {
            addCriterion("CHECK_UNIT is null");
            return (Criteria) this;
        }

        public Criteria andCheckUnitIsNotNull() {
            addCriterion("CHECK_UNIT is not null");
            return (Criteria) this;
        }

        public Criteria andCheckUnitEqualTo(String value) {
            addCriterion("CHECK_UNIT =", value, "checkUnit");
            return (Criteria) this;
        }

        public Criteria andCheckUnitNotEqualTo(String value) {
            addCriterion("CHECK_UNIT <>", value, "checkUnit");
            return (Criteria) this;
        }

        public Criteria andCheckUnitGreaterThan(String value) {
            addCriterion("CHECK_UNIT >", value, "checkUnit");
            return (Criteria) this;
        }

        public Criteria andCheckUnitGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_UNIT >=", value, "checkUnit");
            return (Criteria) this;
        }

        public Criteria andCheckUnitLessThan(String value) {
            addCriterion("CHECK_UNIT <", value, "checkUnit");
            return (Criteria) this;
        }

        public Criteria andCheckUnitLessThanOrEqualTo(String value) {
            addCriterion("CHECK_UNIT <=", value, "checkUnit");
            return (Criteria) this;
        }

        public Criteria andCheckUnitLike(String value) {
            addCriterion("CHECK_UNIT like", value, "checkUnit");
            return (Criteria) this;
        }

        public Criteria andCheckUnitNotLike(String value) {
            addCriterion("CHECK_UNIT not like", value, "checkUnit");
            return (Criteria) this;
        }

        public Criteria andCheckUnitIn(List<String> values) {
            addCriterion("CHECK_UNIT in", values, "checkUnit");
            return (Criteria) this;
        }

        public Criteria andCheckUnitNotIn(List<String> values) {
            addCriterion("CHECK_UNIT not in", values, "checkUnit");
            return (Criteria) this;
        }

        public Criteria andCheckUnitBetween(String value1, String value2) {
            addCriterion("CHECK_UNIT between", value1, value2, "checkUnit");
            return (Criteria) this;
        }

        public Criteria andCheckUnitNotBetween(String value1, String value2) {
            addCriterion("CHECK_UNIT not between", value1, value2, "checkUnit");
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

        public Criteria andWelderExamStatusIsNull() {
            addCriterion("WELDER_EXAM_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andWelderExamStatusIsNotNull() {
            addCriterion("WELDER_EXAM_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andWelderExamStatusEqualTo(String value) {
            addCriterion("WELDER_EXAM_STATUS =", value, "welderExamStatus");
            return (Criteria) this;
        }

        public Criteria andWelderExamStatusNotEqualTo(String value) {
            addCriterion("WELDER_EXAM_STATUS <>", value, "welderExamStatus");
            return (Criteria) this;
        }

        public Criteria andWelderExamStatusGreaterThan(String value) {
            addCriterion("WELDER_EXAM_STATUS >", value, "welderExamStatus");
            return (Criteria) this;
        }

        public Criteria andWelderExamStatusGreaterThanOrEqualTo(String value) {
            addCriterion("WELDER_EXAM_STATUS >=", value, "welderExamStatus");
            return (Criteria) this;
        }

        public Criteria andWelderExamStatusLessThan(String value) {
            addCriterion("WELDER_EXAM_STATUS <", value, "welderExamStatus");
            return (Criteria) this;
        }

        public Criteria andWelderExamStatusLessThanOrEqualTo(String value) {
            addCriterion("WELDER_EXAM_STATUS <=", value, "welderExamStatus");
            return (Criteria) this;
        }

        public Criteria andWelderExamStatusLike(String value) {
            addCriterion("WELDER_EXAM_STATUS like", value, "welderExamStatus");
            return (Criteria) this;
        }

        public Criteria andWelderExamStatusNotLike(String value) {
            addCriterion("WELDER_EXAM_STATUS not like", value, "welderExamStatus");
            return (Criteria) this;
        }

        public Criteria andWelderExamStatusIn(List<String> values) {
            addCriterion("WELDER_EXAM_STATUS in", values, "welderExamStatus");
            return (Criteria) this;
        }

        public Criteria andWelderExamStatusNotIn(List<String> values) {
            addCriterion("WELDER_EXAM_STATUS not in", values, "welderExamStatus");
            return (Criteria) this;
        }

        public Criteria andWelderExamStatusBetween(String value1, String value2) {
            addCriterion("WELDER_EXAM_STATUS between", value1, value2, "welderExamStatus");
            return (Criteria) this;
        }

        public Criteria andWelderExamStatusNotBetween(String value1, String value2) {
            addCriterion("WELDER_EXAM_STATUS not between", value1, value2, "welderExamStatus");
            return (Criteria) this;
        }

        public Criteria andPhotoLinkIsNull() {
            addCriterion("PHOTO_LINK is null");
            return (Criteria) this;
        }

        public Criteria andPhotoLinkIsNotNull() {
            addCriterion("PHOTO_LINK is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoLinkEqualTo(String value) {
            addCriterion("PHOTO_LINK =", value, "photoLink");
            return (Criteria) this;
        }

        public Criteria andPhotoLinkNotEqualTo(String value) {
            addCriterion("PHOTO_LINK <>", value, "photoLink");
            return (Criteria) this;
        }

        public Criteria andPhotoLinkGreaterThan(String value) {
            addCriterion("PHOTO_LINK >", value, "photoLink");
            return (Criteria) this;
        }

        public Criteria andPhotoLinkGreaterThanOrEqualTo(String value) {
            addCriterion("PHOTO_LINK >=", value, "photoLink");
            return (Criteria) this;
        }

        public Criteria andPhotoLinkLessThan(String value) {
            addCriterion("PHOTO_LINK <", value, "photoLink");
            return (Criteria) this;
        }

        public Criteria andPhotoLinkLessThanOrEqualTo(String value) {
            addCriterion("PHOTO_LINK <=", value, "photoLink");
            return (Criteria) this;
        }

        public Criteria andPhotoLinkLike(String value) {
            addCriterion("PHOTO_LINK like", value, "photoLink");
            return (Criteria) this;
        }

        public Criteria andPhotoLinkNotLike(String value) {
            addCriterion("PHOTO_LINK not like", value, "photoLink");
            return (Criteria) this;
        }

        public Criteria andPhotoLinkIn(List<String> values) {
            addCriterion("PHOTO_LINK in", values, "photoLink");
            return (Criteria) this;
        }

        public Criteria andPhotoLinkNotIn(List<String> values) {
            addCriterion("PHOTO_LINK not in", values, "photoLink");
            return (Criteria) this;
        }

        public Criteria andPhotoLinkBetween(String value1, String value2) {
            addCriterion("PHOTO_LINK between", value1, value2, "photoLink");
            return (Criteria) this;
        }

        public Criteria andPhotoLinkNotBetween(String value1, String value2) {
            addCriterion("PHOTO_LINK not between", value1, value2, "photoLink");
            return (Criteria) this;
        }

        public Criteria andWelderStatusIsNull() {
            addCriterion("WELDER_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andWelderStatusIsNotNull() {
            addCriterion("WELDER_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andWelderStatusEqualTo(String value) {
            addCriterion("WELDER_STATUS =", value, "welderStatus");
            return (Criteria) this;
        }

        public Criteria andWelderStatusNotEqualTo(String value) {
            addCriterion("WELDER_STATUS <>", value, "welderStatus");
            return (Criteria) this;
        }

        public Criteria andWelderStatusGreaterThan(String value) {
            addCriterion("WELDER_STATUS >", value, "welderStatus");
            return (Criteria) this;
        }

        public Criteria andWelderStatusGreaterThanOrEqualTo(String value) {
            addCriterion("WELDER_STATUS >=", value, "welderStatus");
            return (Criteria) this;
        }

        public Criteria andWelderStatusLessThan(String value) {
            addCriterion("WELDER_STATUS <", value, "welderStatus");
            return (Criteria) this;
        }

        public Criteria andWelderStatusLessThanOrEqualTo(String value) {
            addCriterion("WELDER_STATUS <=", value, "welderStatus");
            return (Criteria) this;
        }

        public Criteria andWelderStatusLike(String value) {
            addCriterion("WELDER_STATUS like", value, "welderStatus");
            return (Criteria) this;
        }

        public Criteria andWelderStatusNotLike(String value) {
            addCriterion("WELDER_STATUS not like", value, "welderStatus");
            return (Criteria) this;
        }

        public Criteria andWelderStatusIn(List<String> values) {
            addCriterion("WELDER_STATUS in", values, "welderStatus");
            return (Criteria) this;
        }

        public Criteria andWelderStatusNotIn(List<String> values) {
            addCriterion("WELDER_STATUS not in", values, "welderStatus");
            return (Criteria) this;
        }

        public Criteria andWelderStatusBetween(String value1, String value2) {
            addCriterion("WELDER_STATUS between", value1, value2, "welderStatus");
            return (Criteria) this;
        }

        public Criteria andWelderStatusNotBetween(String value1, String value2) {
            addCriterion("WELDER_STATUS not between", value1, value2, "welderStatus");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIsNull() {
            addCriterion("WORK_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIsNotNull() {
            addCriterion("WORK_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTypeEqualTo(String value) {
            addCriterion("WORK_TYPE =", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotEqualTo(String value) {
            addCriterion("WORK_TYPE <>", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeGreaterThan(String value) {
            addCriterion("WORK_TYPE >", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_TYPE >=", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeLessThan(String value) {
            addCriterion("WORK_TYPE <", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeLessThanOrEqualTo(String value) {
            addCriterion("WORK_TYPE <=", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeLike(String value) {
            addCriterion("WORK_TYPE like", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotLike(String value) {
            addCriterion("WORK_TYPE not like", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIn(List<String> values) {
            addCriterion("WORK_TYPE in", values, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotIn(List<String> values) {
            addCriterion("WORK_TYPE not in", values, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeBetween(String value1, String value2) {
            addCriterion("WORK_TYPE between", value1, value2, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotBetween(String value1, String value2) {
            addCriterion("WORK_TYPE not between", value1, value2, "workType");
            return (Criteria) this;
        }

        public Criteria andValidityPeriodIsNull() {
            addCriterion("VALIDITY_PERIOD is null");
            return (Criteria) this;
        }

        public Criteria andValidityPeriodIsNotNull() {
            addCriterion("VALIDITY_PERIOD is not null");
            return (Criteria) this;
        }

        public Criteria andValidityPeriodEqualTo(String value) {
            addCriterion("VALIDITY_PERIOD =", value, "validityPeriod");
            return (Criteria) this;
        }

        public Criteria andValidityPeriodNotEqualTo(String value) {
            addCriterion("VALIDITY_PERIOD <>", value, "validityPeriod");
            return (Criteria) this;
        }

        public Criteria andValidityPeriodGreaterThan(String value) {
            addCriterion("VALIDITY_PERIOD >", value, "validityPeriod");
            return (Criteria) this;
        }

        public Criteria andValidityPeriodGreaterThanOrEqualTo(String value) {
            addCriterion("VALIDITY_PERIOD >=", value, "validityPeriod");
            return (Criteria) this;
        }

        public Criteria andValidityPeriodLessThan(String value) {
            addCriterion("VALIDITY_PERIOD <", value, "validityPeriod");
            return (Criteria) this;
        }

        public Criteria andValidityPeriodLessThanOrEqualTo(String value) {
            addCriterion("VALIDITY_PERIOD <=", value, "validityPeriod");
            return (Criteria) this;
        }

        public Criteria andValidityPeriodLike(String value) {
            addCriterion("VALIDITY_PERIOD like", value, "validityPeriod");
            return (Criteria) this;
        }

        public Criteria andValidityPeriodNotLike(String value) {
            addCriterion("VALIDITY_PERIOD not like", value, "validityPeriod");
            return (Criteria) this;
        }

        public Criteria andValidityPeriodIn(List<String> values) {
            addCriterion("VALIDITY_PERIOD in", values, "validityPeriod");
            return (Criteria) this;
        }

        public Criteria andValidityPeriodNotIn(List<String> values) {
            addCriterion("VALIDITY_PERIOD not in", values, "validityPeriod");
            return (Criteria) this;
        }

        public Criteria andValidityPeriodBetween(String value1, String value2) {
            addCriterion("VALIDITY_PERIOD between", value1, value2, "validityPeriod");
            return (Criteria) this;
        }

        public Criteria andValidityPeriodNotBetween(String value1, String value2) {
            addCriterion("VALIDITY_PERIOD not between", value1, value2, "validityPeriod");
            return (Criteria) this;
        }

        public Criteria andOneFacadeIsNull() {
            addCriterion("ONE_FACADE is null");
            return (Criteria) this;
        }

        public Criteria andOneFacadeIsNotNull() {
            addCriterion("ONE_FACADE is not null");
            return (Criteria) this;
        }

        public Criteria andOneFacadeEqualTo(String value) {
            addCriterion("ONE_FACADE =", value, "oneFacade");
            return (Criteria) this;
        }

        public Criteria andOneFacadeNotEqualTo(String value) {
            addCriterion("ONE_FACADE <>", value, "oneFacade");
            return (Criteria) this;
        }

        public Criteria andOneFacadeGreaterThan(String value) {
            addCriterion("ONE_FACADE >", value, "oneFacade");
            return (Criteria) this;
        }

        public Criteria andOneFacadeGreaterThanOrEqualTo(String value) {
            addCriterion("ONE_FACADE >=", value, "oneFacade");
            return (Criteria) this;
        }

        public Criteria andOneFacadeLessThan(String value) {
            addCriterion("ONE_FACADE <", value, "oneFacade");
            return (Criteria) this;
        }

        public Criteria andOneFacadeLessThanOrEqualTo(String value) {
            addCriterion("ONE_FACADE <=", value, "oneFacade");
            return (Criteria) this;
        }

        public Criteria andOneFacadeLike(String value) {
            addCriterion("ONE_FACADE like", value, "oneFacade");
            return (Criteria) this;
        }

        public Criteria andOneFacadeNotLike(String value) {
            addCriterion("ONE_FACADE not like", value, "oneFacade");
            return (Criteria) this;
        }

        public Criteria andOneFacadeIn(List<String> values) {
            addCriterion("ONE_FACADE in", values, "oneFacade");
            return (Criteria) this;
        }

        public Criteria andOneFacadeNotIn(List<String> values) {
            addCriterion("ONE_FACADE not in", values, "oneFacade");
            return (Criteria) this;
        }

        public Criteria andOneFacadeBetween(String value1, String value2) {
            addCriterion("ONE_FACADE between", value1, value2, "oneFacade");
            return (Criteria) this;
        }

        public Criteria andOneFacadeNotBetween(String value1, String value2) {
            addCriterion("ONE_FACADE not between", value1, value2, "oneFacade");
            return (Criteria) this;
        }

        public Criteria andOneRtIsNull() {
            addCriterion("ONE_RT is null");
            return (Criteria) this;
        }

        public Criteria andOneRtIsNotNull() {
            addCriterion("ONE_RT is not null");
            return (Criteria) this;
        }

        public Criteria andOneRtEqualTo(String value) {
            addCriterion("ONE_RT =", value, "oneRt");
            return (Criteria) this;
        }

        public Criteria andOneRtNotEqualTo(String value) {
            addCriterion("ONE_RT <>", value, "oneRt");
            return (Criteria) this;
        }

        public Criteria andOneRtGreaterThan(String value) {
            addCriterion("ONE_RT >", value, "oneRt");
            return (Criteria) this;
        }

        public Criteria andOneRtGreaterThanOrEqualTo(String value) {
            addCriterion("ONE_RT >=", value, "oneRt");
            return (Criteria) this;
        }

        public Criteria andOneRtLessThan(String value) {
            addCriterion("ONE_RT <", value, "oneRt");
            return (Criteria) this;
        }

        public Criteria andOneRtLessThanOrEqualTo(String value) {
            addCriterion("ONE_RT <=", value, "oneRt");
            return (Criteria) this;
        }

        public Criteria andOneRtLike(String value) {
            addCriterion("ONE_RT like", value, "oneRt");
            return (Criteria) this;
        }

        public Criteria andOneRtNotLike(String value) {
            addCriterion("ONE_RT not like", value, "oneRt");
            return (Criteria) this;
        }

        public Criteria andOneRtIn(List<String> values) {
            addCriterion("ONE_RT in", values, "oneRt");
            return (Criteria) this;
        }

        public Criteria andOneRtNotIn(List<String> values) {
            addCriterion("ONE_RT not in", values, "oneRt");
            return (Criteria) this;
        }

        public Criteria andOneRtBetween(String value1, String value2) {
            addCriterion("ONE_RT between", value1, value2, "oneRt");
            return (Criteria) this;
        }

        public Criteria andOneRtNotBetween(String value1, String value2) {
            addCriterion("ONE_RT not between", value1, value2, "oneRt");
            return (Criteria) this;
        }

        public Criteria andOneExaminationDateIsNull() {
            addCriterion("ONE_EXAMINATION_DATE is null");
            return (Criteria) this;
        }

        public Criteria andOneExaminationDateIsNotNull() {
            addCriterion("ONE_EXAMINATION_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andOneExaminationDateEqualTo(String value) {
            addCriterion("ONE_EXAMINATION_DATE =", value, "oneExaminationDate");
            return (Criteria) this;
        }

        public Criteria andOneExaminationDateNotEqualTo(String value) {
            addCriterion("ONE_EXAMINATION_DATE <>", value, "oneExaminationDate");
            return (Criteria) this;
        }

        public Criteria andOneExaminationDateGreaterThan(String value) {
            addCriterion("ONE_EXAMINATION_DATE >", value, "oneExaminationDate");
            return (Criteria) this;
        }

        public Criteria andOneExaminationDateGreaterThanOrEqualTo(String value) {
            addCriterion("ONE_EXAMINATION_DATE >=", value, "oneExaminationDate");
            return (Criteria) this;
        }

        public Criteria andOneExaminationDateLessThan(String value) {
            addCriterion("ONE_EXAMINATION_DATE <", value, "oneExaminationDate");
            return (Criteria) this;
        }

        public Criteria andOneExaminationDateLessThanOrEqualTo(String value) {
            addCriterion("ONE_EXAMINATION_DATE <=", value, "oneExaminationDate");
            return (Criteria) this;
        }

        public Criteria andOneExaminationDateLike(String value) {
            addCriterion("ONE_EXAMINATION_DATE like", value, "oneExaminationDate");
            return (Criteria) this;
        }

        public Criteria andOneExaminationDateNotLike(String value) {
            addCriterion("ONE_EXAMINATION_DATE not like", value, "oneExaminationDate");
            return (Criteria) this;
        }

        public Criteria andOneExaminationDateIn(List<String> values) {
            addCriterion("ONE_EXAMINATION_DATE in", values, "oneExaminationDate");
            return (Criteria) this;
        }

        public Criteria andOneExaminationDateNotIn(List<String> values) {
            addCriterion("ONE_EXAMINATION_DATE not in", values, "oneExaminationDate");
            return (Criteria) this;
        }

        public Criteria andOneExaminationDateBetween(String value1, String value2) {
            addCriterion("ONE_EXAMINATION_DATE between", value1, value2, "oneExaminationDate");
            return (Criteria) this;
        }

        public Criteria andOneExaminationDateNotBetween(String value1, String value2) {
            addCriterion("ONE_EXAMINATION_DATE not between", value1, value2, "oneExaminationDate");
            return (Criteria) this;
        }

        public Criteria andTwoExaminationDateIsNull() {
            addCriterion("TWO_EXAMINATION_DATE is null");
            return (Criteria) this;
        }

        public Criteria andTwoExaminationDateIsNotNull() {
            addCriterion("TWO_EXAMINATION_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andTwoExaminationDateEqualTo(String value) {
            addCriterion("TWO_EXAMINATION_DATE =", value, "twoExaminationDate");
            return (Criteria) this;
        }

        public Criteria andTwoExaminationDateNotEqualTo(String value) {
            addCriterion("TWO_EXAMINATION_DATE <>", value, "twoExaminationDate");
            return (Criteria) this;
        }

        public Criteria andTwoExaminationDateGreaterThan(String value) {
            addCriterion("TWO_EXAMINATION_DATE >", value, "twoExaminationDate");
            return (Criteria) this;
        }

        public Criteria andTwoExaminationDateGreaterThanOrEqualTo(String value) {
            addCriterion("TWO_EXAMINATION_DATE >=", value, "twoExaminationDate");
            return (Criteria) this;
        }

        public Criteria andTwoExaminationDateLessThan(String value) {
            addCriterion("TWO_EXAMINATION_DATE <", value, "twoExaminationDate");
            return (Criteria) this;
        }

        public Criteria andTwoExaminationDateLessThanOrEqualTo(String value) {
            addCriterion("TWO_EXAMINATION_DATE <=", value, "twoExaminationDate");
            return (Criteria) this;
        }

        public Criteria andTwoExaminationDateLike(String value) {
            addCriterion("TWO_EXAMINATION_DATE like", value, "twoExaminationDate");
            return (Criteria) this;
        }

        public Criteria andTwoExaminationDateNotLike(String value) {
            addCriterion("TWO_EXAMINATION_DATE not like", value, "twoExaminationDate");
            return (Criteria) this;
        }

        public Criteria andTwoExaminationDateIn(List<String> values) {
            addCriterion("TWO_EXAMINATION_DATE in", values, "twoExaminationDate");
            return (Criteria) this;
        }

        public Criteria andTwoExaminationDateNotIn(List<String> values) {
            addCriterion("TWO_EXAMINATION_DATE not in", values, "twoExaminationDate");
            return (Criteria) this;
        }

        public Criteria andTwoExaminationDateBetween(String value1, String value2) {
            addCriterion("TWO_EXAMINATION_DATE between", value1, value2, "twoExaminationDate");
            return (Criteria) this;
        }

        public Criteria andTwoExaminationDateNotBetween(String value1, String value2) {
            addCriterion("TWO_EXAMINATION_DATE not between", value1, value2, "twoExaminationDate");
            return (Criteria) this;
        }

        public Criteria andTwoRtIsNull() {
            addCriterion("TWO_RT is null");
            return (Criteria) this;
        }

        public Criteria andTwoRtIsNotNull() {
            addCriterion("TWO_RT is not null");
            return (Criteria) this;
        }

        public Criteria andTwoRtEqualTo(String value) {
            addCriterion("TWO_RT =", value, "twoRt");
            return (Criteria) this;
        }

        public Criteria andTwoRtNotEqualTo(String value) {
            addCriterion("TWO_RT <>", value, "twoRt");
            return (Criteria) this;
        }

        public Criteria andTwoRtGreaterThan(String value) {
            addCriterion("TWO_RT >", value, "twoRt");
            return (Criteria) this;
        }

        public Criteria andTwoRtGreaterThanOrEqualTo(String value) {
            addCriterion("TWO_RT >=", value, "twoRt");
            return (Criteria) this;
        }

        public Criteria andTwoRtLessThan(String value) {
            addCriterion("TWO_RT <", value, "twoRt");
            return (Criteria) this;
        }

        public Criteria andTwoRtLessThanOrEqualTo(String value) {
            addCriterion("TWO_RT <=", value, "twoRt");
            return (Criteria) this;
        }

        public Criteria andTwoRtLike(String value) {
            addCriterion("TWO_RT like", value, "twoRt");
            return (Criteria) this;
        }

        public Criteria andTwoRtNotLike(String value) {
            addCriterion("TWO_RT not like", value, "twoRt");
            return (Criteria) this;
        }

        public Criteria andTwoRtIn(List<String> values) {
            addCriterion("TWO_RT in", values, "twoRt");
            return (Criteria) this;
        }

        public Criteria andTwoRtNotIn(List<String> values) {
            addCriterion("TWO_RT not in", values, "twoRt");
            return (Criteria) this;
        }

        public Criteria andTwoRtBetween(String value1, String value2) {
            addCriterion("TWO_RT between", value1, value2, "twoRt");
            return (Criteria) this;
        }

        public Criteria andTwoRtNotBetween(String value1, String value2) {
            addCriterion("TWO_RT not between", value1, value2, "twoRt");
            return (Criteria) this;
        }

        public Criteria andTwoFacadeIsNull() {
            addCriterion("TWO_FACADE is null");
            return (Criteria) this;
        }

        public Criteria andTwoFacadeIsNotNull() {
            addCriterion("TWO_FACADE is not null");
            return (Criteria) this;
        }

        public Criteria andTwoFacadeEqualTo(String value) {
            addCriterion("TWO_FACADE =", value, "twoFacade");
            return (Criteria) this;
        }

        public Criteria andTwoFacadeNotEqualTo(String value) {
            addCriterion("TWO_FACADE <>", value, "twoFacade");
            return (Criteria) this;
        }

        public Criteria andTwoFacadeGreaterThan(String value) {
            addCriterion("TWO_FACADE >", value, "twoFacade");
            return (Criteria) this;
        }

        public Criteria andTwoFacadeGreaterThanOrEqualTo(String value) {
            addCriterion("TWO_FACADE >=", value, "twoFacade");
            return (Criteria) this;
        }

        public Criteria andTwoFacadeLessThan(String value) {
            addCriterion("TWO_FACADE <", value, "twoFacade");
            return (Criteria) this;
        }

        public Criteria andTwoFacadeLessThanOrEqualTo(String value) {
            addCriterion("TWO_FACADE <=", value, "twoFacade");
            return (Criteria) this;
        }

        public Criteria andTwoFacadeLike(String value) {
            addCriterion("TWO_FACADE like", value, "twoFacade");
            return (Criteria) this;
        }

        public Criteria andTwoFacadeNotLike(String value) {
            addCriterion("TWO_FACADE not like", value, "twoFacade");
            return (Criteria) this;
        }

        public Criteria andTwoFacadeIn(List<String> values) {
            addCriterion("TWO_FACADE in", values, "twoFacade");
            return (Criteria) this;
        }

        public Criteria andTwoFacadeNotIn(List<String> values) {
            addCriterion("TWO_FACADE not in", values, "twoFacade");
            return (Criteria) this;
        }

        public Criteria andTwoFacadeBetween(String value1, String value2) {
            addCriterion("TWO_FACADE between", value1, value2, "twoFacade");
            return (Criteria) this;
        }

        public Criteria andTwoFacadeNotBetween(String value1, String value2) {
            addCriterion("TWO_FACADE not between", value1, value2, "twoFacade");
            return (Criteria) this;
        }

        public Criteria andSpecialtyIsNull() {
            addCriterion("SPECIALTY is null");
            return (Criteria) this;
        }

        public Criteria andSpecialtyIsNotNull() {
            addCriterion("SPECIALTY is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialtyEqualTo(String value) {
            addCriterion("SPECIALTY =", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyNotEqualTo(String value) {
            addCriterion("SPECIALTY <>", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyGreaterThan(String value) {
            addCriterion("SPECIALTY >", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyGreaterThanOrEqualTo(String value) {
            addCriterion("SPECIALTY >=", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyLessThan(String value) {
            addCriterion("SPECIALTY <", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyLessThanOrEqualTo(String value) {
            addCriterion("SPECIALTY <=", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyLike(String value) {
            addCriterion("SPECIALTY like", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyNotLike(String value) {
            addCriterion("SPECIALTY not like", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyIn(List<String> values) {
            addCriterion("SPECIALTY in", values, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyNotIn(List<String> values) {
            addCriterion("SPECIALTY not in", values, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyBetween(String value1, String value2) {
            addCriterion("SPECIALTY between", value1, value2, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyNotBetween(String value1, String value2) {
            addCriterion("SPECIALTY not between", value1, value2, "specialty");
            return (Criteria) this;
        }

        public Criteria andWelderCertificateCodeIsNull() {
            addCriterion("WELDER_CERTIFICATE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andWelderCertificateCodeIsNotNull() {
            addCriterion("WELDER_CERTIFICATE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andWelderCertificateCodeEqualTo(String value) {
            addCriterion("WELDER_CERTIFICATE_CODE =", value, "welderCertificateCode");
            return (Criteria) this;
        }

        public Criteria andWelderCertificateCodeNotEqualTo(String value) {
            addCriterion("WELDER_CERTIFICATE_CODE <>", value, "welderCertificateCode");
            return (Criteria) this;
        }

        public Criteria andWelderCertificateCodeGreaterThan(String value) {
            addCriterion("WELDER_CERTIFICATE_CODE >", value, "welderCertificateCode");
            return (Criteria) this;
        }

        public Criteria andWelderCertificateCodeGreaterThanOrEqualTo(String value) {
            addCriterion("WELDER_CERTIFICATE_CODE >=", value, "welderCertificateCode");
            return (Criteria) this;
        }

        public Criteria andWelderCertificateCodeLessThan(String value) {
            addCriterion("WELDER_CERTIFICATE_CODE <", value, "welderCertificateCode");
            return (Criteria) this;
        }

        public Criteria andWelderCertificateCodeLessThanOrEqualTo(String value) {
            addCriterion("WELDER_CERTIFICATE_CODE <=", value, "welderCertificateCode");
            return (Criteria) this;
        }

        public Criteria andWelderCertificateCodeLike(String value) {
            addCriterion("WELDER_CERTIFICATE_CODE like", value, "welderCertificateCode");
            return (Criteria) this;
        }

        public Criteria andWelderCertificateCodeNotLike(String value) {
            addCriterion("WELDER_CERTIFICATE_CODE not like", value, "welderCertificateCode");
            return (Criteria) this;
        }

        public Criteria andWelderCertificateCodeIn(List<String> values) {
            addCriterion("WELDER_CERTIFICATE_CODE in", values, "welderCertificateCode");
            return (Criteria) this;
        }

        public Criteria andWelderCertificateCodeNotIn(List<String> values) {
            addCriterion("WELDER_CERTIFICATE_CODE not in", values, "welderCertificateCode");
            return (Criteria) this;
        }

        public Criteria andWelderCertificateCodeBetween(String value1, String value2) {
            addCriterion("WELDER_CERTIFICATE_CODE between", value1, value2, "welderCertificateCode");
            return (Criteria) this;
        }

        public Criteria andWelderCertificateCodeNotBetween(String value1, String value2) {
            addCriterion("WELDER_CERTIFICATE_CODE not between", value1, value2, "welderCertificateCode");
            return (Criteria) this;
        }

        public Criteria andWelderCertificatePeriodIsNull() {
            addCriterion("WELDER_CERTIFICATE_PERIOD is null");
            return (Criteria) this;
        }

        public Criteria andWelderCertificatePeriodIsNotNull() {
            addCriterion("WELDER_CERTIFICATE_PERIOD is not null");
            return (Criteria) this;
        }

        public Criteria andWelderCertificatePeriodEqualTo(String value) {
            addCriterion("WELDER_CERTIFICATE_PERIOD =", value, "welderCertificatePeriod");
            return (Criteria) this;
        }

        public Criteria andWelderCertificatePeriodNotEqualTo(String value) {
            addCriterion("WELDER_CERTIFICATE_PERIOD <>", value, "welderCertificatePeriod");
            return (Criteria) this;
        }

        public Criteria andWelderCertificatePeriodGreaterThan(String value) {
            addCriterion("WELDER_CERTIFICATE_PERIOD >", value, "welderCertificatePeriod");
            return (Criteria) this;
        }

        public Criteria andWelderCertificatePeriodGreaterThanOrEqualTo(String value) {
            addCriterion("WELDER_CERTIFICATE_PERIOD >=", value, "welderCertificatePeriod");
            return (Criteria) this;
        }

        public Criteria andWelderCertificatePeriodLessThan(String value) {
            addCriterion("WELDER_CERTIFICATE_PERIOD <", value, "welderCertificatePeriod");
            return (Criteria) this;
        }

        public Criteria andWelderCertificatePeriodLessThanOrEqualTo(String value) {
            addCriterion("WELDER_CERTIFICATE_PERIOD <=", value, "welderCertificatePeriod");
            return (Criteria) this;
        }

        public Criteria andWelderCertificatePeriodLike(String value) {
            addCriterion("WELDER_CERTIFICATE_PERIOD like", value, "welderCertificatePeriod");
            return (Criteria) this;
        }

        public Criteria andWelderCertificatePeriodNotLike(String value) {
            addCriterion("WELDER_CERTIFICATE_PERIOD not like", value, "welderCertificatePeriod");
            return (Criteria) this;
        }

        public Criteria andWelderCertificatePeriodIn(List<String> values) {
            addCriterion("WELDER_CERTIFICATE_PERIOD in", values, "welderCertificatePeriod");
            return (Criteria) this;
        }

        public Criteria andWelderCertificatePeriodNotIn(List<String> values) {
            addCriterion("WELDER_CERTIFICATE_PERIOD not in", values, "welderCertificatePeriod");
            return (Criteria) this;
        }

        public Criteria andWelderCertificatePeriodBetween(String value1, String value2) {
            addCriterion("WELDER_CERTIFICATE_PERIOD between", value1, value2, "welderCertificatePeriod");
            return (Criteria) this;
        }

        public Criteria andWelderCertificatePeriodNotBetween(String value1, String value2) {
            addCriterion("WELDER_CERTIFICATE_PERIOD not between", value1, value2, "welderCertificatePeriod");
            return (Criteria) this;
        }

        public Criteria andPassDateIsNull() {
            addCriterion("PASS_DATE is null");
            return (Criteria) this;
        }

        public Criteria andPassDateIsNotNull() {
            addCriterion("PASS_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andPassDateEqualTo(String value) {
            addCriterion("PASS_DATE =", value, "passDate");
            return (Criteria) this;
        }

        public Criteria andPassDateNotEqualTo(String value) {
            addCriterion("PASS_DATE <>", value, "passDate");
            return (Criteria) this;
        }

        public Criteria andPassDateGreaterThan(String value) {
            addCriterion("PASS_DATE >", value, "passDate");
            return (Criteria) this;
        }

        public Criteria andPassDateGreaterThanOrEqualTo(String value) {
            addCriterion("PASS_DATE >=", value, "passDate");
            return (Criteria) this;
        }

        public Criteria andPassDateLessThan(String value) {
            addCriterion("PASS_DATE <", value, "passDate");
            return (Criteria) this;
        }

        public Criteria andPassDateLessThanOrEqualTo(String value) {
            addCriterion("PASS_DATE <=", value, "passDate");
            return (Criteria) this;
        }

        public Criteria andPassDateLike(String value) {
            addCriterion("PASS_DATE like", value, "passDate");
            return (Criteria) this;
        }

        public Criteria andPassDateNotLike(String value) {
            addCriterion("PASS_DATE not like", value, "passDate");
            return (Criteria) this;
        }

        public Criteria andPassDateIn(List<String> values) {
            addCriterion("PASS_DATE in", values, "passDate");
            return (Criteria) this;
        }

        public Criteria andPassDateNotIn(List<String> values) {
            addCriterion("PASS_DATE not in", values, "passDate");
            return (Criteria) this;
        }

        public Criteria andPassDateBetween(String value1, String value2) {
            addCriterion("PASS_DATE between", value1, value2, "passDate");
            return (Criteria) this;
        }

        public Criteria andPassDateNotBetween(String value1, String value2) {
            addCriterion("PASS_DATE not between", value1, value2, "passDate");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("SEX is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("SEX is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("SEX =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("SEX <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("SEX >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("SEX >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("SEX <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("SEX <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("SEX like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("SEX not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("SEX in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("SEX not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("SEX between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("SEX not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("AGE is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("AGE is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(String value) {
            addCriterion("AGE =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(String value) {
            addCriterion("AGE <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(String value) {
            addCriterion("AGE >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(String value) {
            addCriterion("AGE >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(String value) {
            addCriterion("AGE <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(String value) {
            addCriterion("AGE <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLike(String value) {
            addCriterion("AGE like", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotLike(String value) {
            addCriterion("AGE not like", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<String> values) {
            addCriterion("AGE in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<String> values) {
            addCriterion("AGE not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(String value1, String value2) {
            addCriterion("AGE between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(String value1, String value2) {
            addCriterion("AGE not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andExaminationPassProjectIsNull() {
            addCriterion("EXAMINATION_PASS_PROJECT is null");
            return (Criteria) this;
        }

        public Criteria andExaminationPassProjectIsNotNull() {
            addCriterion("EXAMINATION_PASS_PROJECT is not null");
            return (Criteria) this;
        }

        public Criteria andExaminationPassProjectEqualTo(String value) {
            addCriterion("EXAMINATION_PASS_PROJECT =", value, "examinationPassProject");
            return (Criteria) this;
        }

        public Criteria andExaminationPassProjectNotEqualTo(String value) {
            addCriterion("EXAMINATION_PASS_PROJECT <>", value, "examinationPassProject");
            return (Criteria) this;
        }

        public Criteria andExaminationPassProjectGreaterThan(String value) {
            addCriterion("EXAMINATION_PASS_PROJECT >", value, "examinationPassProject");
            return (Criteria) this;
        }

        public Criteria andExaminationPassProjectGreaterThanOrEqualTo(String value) {
            addCriterion("EXAMINATION_PASS_PROJECT >=", value, "examinationPassProject");
            return (Criteria) this;
        }

        public Criteria andExaminationPassProjectLessThan(String value) {
            addCriterion("EXAMINATION_PASS_PROJECT <", value, "examinationPassProject");
            return (Criteria) this;
        }

        public Criteria andExaminationPassProjectLessThanOrEqualTo(String value) {
            addCriterion("EXAMINATION_PASS_PROJECT <=", value, "examinationPassProject");
            return (Criteria) this;
        }

        public Criteria andExaminationPassProjectLike(String value) {
            addCriterion("EXAMINATION_PASS_PROJECT like", value, "examinationPassProject");
            return (Criteria) this;
        }

        public Criteria andExaminationPassProjectNotLike(String value) {
            addCriterion("EXAMINATION_PASS_PROJECT not like", value, "examinationPassProject");
            return (Criteria) this;
        }

        public Criteria andExaminationPassProjectIn(List<String> values) {
            addCriterion("EXAMINATION_PASS_PROJECT in", values, "examinationPassProject");
            return (Criteria) this;
        }

        public Criteria andExaminationPassProjectNotIn(List<String> values) {
            addCriterion("EXAMINATION_PASS_PROJECT not in", values, "examinationPassProject");
            return (Criteria) this;
        }

        public Criteria andExaminationPassProjectBetween(String value1, String value2) {
            addCriterion("EXAMINATION_PASS_PROJECT between", value1, value2, "examinationPassProject");
            return (Criteria) this;
        }

        public Criteria andExaminationPassProjectNotBetween(String value1, String value2) {
            addCriterion("EXAMINATION_PASS_PROJECT not between", value1, value2, "examinationPassProject");
            return (Criteria) this;
        }

        public Criteria andEntryPassCodeIsNull() {
            addCriterion("ENTRY_PASS_CODE is null");
            return (Criteria) this;
        }

        public Criteria andEntryPassCodeIsNotNull() {
            addCriterion("ENTRY_PASS_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andEntryPassCodeEqualTo(String value) {
            addCriterion("ENTRY_PASS_CODE =", value, "entryPassCode");
            return (Criteria) this;
        }

        public Criteria andEntryPassCodeNotEqualTo(String value) {
            addCriterion("ENTRY_PASS_CODE <>", value, "entryPassCode");
            return (Criteria) this;
        }

        public Criteria andEntryPassCodeGreaterThan(String value) {
            addCriterion("ENTRY_PASS_CODE >", value, "entryPassCode");
            return (Criteria) this;
        }

        public Criteria andEntryPassCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ENTRY_PASS_CODE >=", value, "entryPassCode");
            return (Criteria) this;
        }

        public Criteria andEntryPassCodeLessThan(String value) {
            addCriterion("ENTRY_PASS_CODE <", value, "entryPassCode");
            return (Criteria) this;
        }

        public Criteria andEntryPassCodeLessThanOrEqualTo(String value) {
            addCriterion("ENTRY_PASS_CODE <=", value, "entryPassCode");
            return (Criteria) this;
        }

        public Criteria andEntryPassCodeLike(String value) {
            addCriterion("ENTRY_PASS_CODE like", value, "entryPassCode");
            return (Criteria) this;
        }

        public Criteria andEntryPassCodeNotLike(String value) {
            addCriterion("ENTRY_PASS_CODE not like", value, "entryPassCode");
            return (Criteria) this;
        }

        public Criteria andEntryPassCodeIn(List<String> values) {
            addCriterion("ENTRY_PASS_CODE in", values, "entryPassCode");
            return (Criteria) this;
        }

        public Criteria andEntryPassCodeNotIn(List<String> values) {
            addCriterion("ENTRY_PASS_CODE not in", values, "entryPassCode");
            return (Criteria) this;
        }

        public Criteria andEntryPassCodeBetween(String value1, String value2) {
            addCriterion("ENTRY_PASS_CODE between", value1, value2, "entryPassCode");
            return (Criteria) this;
        }

        public Criteria andEntryPassCodeNotBetween(String value1, String value2) {
            addCriterion("ENTRY_PASS_CODE not between", value1, value2, "entryPassCode");
            return (Criteria) this;
        }

        public Criteria andAllowPassCodeIsNull() {
            addCriterion("ALLOW_PASS_CODE is null");
            return (Criteria) this;
        }

        public Criteria andAllowPassCodeIsNotNull() {
            addCriterion("ALLOW_PASS_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andAllowPassCodeEqualTo(String value) {
            addCriterion("ALLOW_PASS_CODE =", value, "allowPassCode");
            return (Criteria) this;
        }

        public Criteria andAllowPassCodeNotEqualTo(String value) {
            addCriterion("ALLOW_PASS_CODE <>", value, "allowPassCode");
            return (Criteria) this;
        }

        public Criteria andAllowPassCodeGreaterThan(String value) {
            addCriterion("ALLOW_PASS_CODE >", value, "allowPassCode");
            return (Criteria) this;
        }

        public Criteria andAllowPassCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ALLOW_PASS_CODE >=", value, "allowPassCode");
            return (Criteria) this;
        }

        public Criteria andAllowPassCodeLessThan(String value) {
            addCriterion("ALLOW_PASS_CODE <", value, "allowPassCode");
            return (Criteria) this;
        }

        public Criteria andAllowPassCodeLessThanOrEqualTo(String value) {
            addCriterion("ALLOW_PASS_CODE <=", value, "allowPassCode");
            return (Criteria) this;
        }

        public Criteria andAllowPassCodeLike(String value) {
            addCriterion("ALLOW_PASS_CODE like", value, "allowPassCode");
            return (Criteria) this;
        }

        public Criteria andAllowPassCodeNotLike(String value) {
            addCriterion("ALLOW_PASS_CODE not like", value, "allowPassCode");
            return (Criteria) this;
        }

        public Criteria andAllowPassCodeIn(List<String> values) {
            addCriterion("ALLOW_PASS_CODE in", values, "allowPassCode");
            return (Criteria) this;
        }

        public Criteria andAllowPassCodeNotIn(List<String> values) {
            addCriterion("ALLOW_PASS_CODE not in", values, "allowPassCode");
            return (Criteria) this;
        }

        public Criteria andAllowPassCodeBetween(String value1, String value2) {
            addCriterion("ALLOW_PASS_CODE between", value1, value2, "allowPassCode");
            return (Criteria) this;
        }

        public Criteria andAllowPassCodeNotBetween(String value1, String value2) {
            addCriterion("ALLOW_PASS_CODE not between", value1, value2, "allowPassCode");
            return (Criteria) this;
        }

        public Criteria andWorkflowStateIsNull() {
            addCriterion("WORKFLOW_STATE is null");
            return (Criteria) this;
        }

        public Criteria andWorkflowStateIsNotNull() {
            addCriterion("WORKFLOW_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andWorkflowStateEqualTo(String value) {
            addCriterion("WORKFLOW_STATE =", value, "workflowState");
            return (Criteria) this;
        }

        public Criteria andWorkflowStateNotEqualTo(String value) {
            addCriterion("WORKFLOW_STATE <>", value, "workflowState");
            return (Criteria) this;
        }

        public Criteria andWorkflowStateGreaterThan(String value) {
            addCriterion("WORKFLOW_STATE >", value, "workflowState");
            return (Criteria) this;
        }

        public Criteria andWorkflowStateGreaterThanOrEqualTo(String value) {
            addCriterion("WORKFLOW_STATE >=", value, "workflowState");
            return (Criteria) this;
        }

        public Criteria andWorkflowStateLessThan(String value) {
            addCriterion("WORKFLOW_STATE <", value, "workflowState");
            return (Criteria) this;
        }

        public Criteria andWorkflowStateLessThanOrEqualTo(String value) {
            addCriterion("WORKFLOW_STATE <=", value, "workflowState");
            return (Criteria) this;
        }

        public Criteria andWorkflowStateLike(String value) {
            addCriterion("WORKFLOW_STATE like", value, "workflowState");
            return (Criteria) this;
        }

        public Criteria andWorkflowStateNotLike(String value) {
            addCriterion("WORKFLOW_STATE not like", value, "workflowState");
            return (Criteria) this;
        }

        public Criteria andWorkflowStateIn(List<String> values) {
            addCriterion("WORKFLOW_STATE in", values, "workflowState");
            return (Criteria) this;
        }

        public Criteria andWorkflowStateNotIn(List<String> values) {
            addCriterion("WORKFLOW_STATE not in", values, "workflowState");
            return (Criteria) this;
        }

        public Criteria andWorkflowStateBetween(String value1, String value2) {
            addCriterion("WORKFLOW_STATE between", value1, value2, "workflowState");
            return (Criteria) this;
        }

        public Criteria andWorkflowStateNotBetween(String value1, String value2) {
            addCriterion("WORKFLOW_STATE not between", value1, value2, "workflowState");
            return (Criteria) this;
        }

        public Criteria andPostStatusIsNull() {
            addCriterion("POST_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andPostStatusIsNotNull() {
            addCriterion("POST_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andPostStatusEqualTo(String value) {
            addCriterion("POST_STATUS =", value, "postStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusNotEqualTo(String value) {
            addCriterion("POST_STATUS <>", value, "postStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusGreaterThan(String value) {
            addCriterion("POST_STATUS >", value, "postStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusGreaterThanOrEqualTo(String value) {
            addCriterion("POST_STATUS >=", value, "postStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusLessThan(String value) {
            addCriterion("POST_STATUS <", value, "postStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusLessThanOrEqualTo(String value) {
            addCriterion("POST_STATUS <=", value, "postStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusLike(String value) {
            addCriterion("POST_STATUS like", value, "postStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusNotLike(String value) {
            addCriterion("POST_STATUS not like", value, "postStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusIn(List<String> values) {
            addCriterion("POST_STATUS in", values, "postStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusNotIn(List<String> values) {
            addCriterion("POST_STATUS not in", values, "postStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusBetween(String value1, String value2) {
            addCriterion("POST_STATUS between", value1, value2, "postStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusNotBetween(String value1, String value2) {
            addCriterion("POST_STATUS not between", value1, value2, "postStatus");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeIsNull() {
            addCriterion("EXAMINATION_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeIsNotNull() {
            addCriterion("EXAMINATION_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeEqualTo(String value) {
            addCriterion("EXAMINATION_TYPE =", value, "examinationType");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeNotEqualTo(String value) {
            addCriterion("EXAMINATION_TYPE <>", value, "examinationType");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeGreaterThan(String value) {
            addCriterion("EXAMINATION_TYPE >", value, "examinationType");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeGreaterThanOrEqualTo(String value) {
            addCriterion("EXAMINATION_TYPE >=", value, "examinationType");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeLessThan(String value) {
            addCriterion("EXAMINATION_TYPE <", value, "examinationType");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeLessThanOrEqualTo(String value) {
            addCriterion("EXAMINATION_TYPE <=", value, "examinationType");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeLike(String value) {
            addCriterion("EXAMINATION_TYPE like", value, "examinationType");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeNotLike(String value) {
            addCriterion("EXAMINATION_TYPE not like", value, "examinationType");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeIn(List<String> values) {
            addCriterion("EXAMINATION_TYPE in", values, "examinationType");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeNotIn(List<String> values) {
            addCriterion("EXAMINATION_TYPE not in", values, "examinationType");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeBetween(String value1, String value2) {
            addCriterion("EXAMINATION_TYPE between", value1, value2, "examinationType");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeNotBetween(String value1, String value2) {
            addCriterion("EXAMINATION_TYPE not between", value1, value2, "examinationType");
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