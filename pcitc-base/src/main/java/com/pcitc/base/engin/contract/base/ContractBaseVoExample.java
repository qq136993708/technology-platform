package com.pcitc.base.engin.contract.base;

import java.util.ArrayList;
import java.util.List;

public class ContractBaseVoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public ContractBaseVoExample() {
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

        public Criteria andAuditStatusIsNull() {
            addCriterion("AUDIT_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIsNotNull() {
            addCriterion("AUDIT_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusEqualTo(String value) {
            addCriterion("AUDIT_STATUS =", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotEqualTo(String value) {
            addCriterion("AUDIT_STATUS <>", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThan(String value) {
            addCriterion("AUDIT_STATUS >", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThanOrEqualTo(String value) {
            addCriterion("AUDIT_STATUS >=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThan(String value) {
            addCriterion("AUDIT_STATUS <", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThanOrEqualTo(String value) {
            addCriterion("AUDIT_STATUS <=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLike(String value) {
            addCriterion("AUDIT_STATUS like", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotLike(String value) {
            addCriterion("AUDIT_STATUS not like", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIn(List<String> values) {
            addCriterion("AUDIT_STATUS in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotIn(List<String> values) {
            addCriterion("AUDIT_STATUS not in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusBetween(String value1, String value2) {
            addCriterion("AUDIT_STATUS between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotBetween(String value1, String value2) {
            addCriterion("AUDIT_STATUS not between", value1, value2, "auditStatus");
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

        public Criteria andContractNameIsNull() {
            addCriterion("CONTRACT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andContractNameIsNotNull() {
            addCriterion("CONTRACT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andContractNameEqualTo(String value) {
            addCriterion("CONTRACT_NAME =", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotEqualTo(String value) {
            addCriterion("CONTRACT_NAME <>", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameGreaterThan(String value) {
            addCriterion("CONTRACT_NAME >", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACT_NAME >=", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameLessThan(String value) {
            addCriterion("CONTRACT_NAME <", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameLessThanOrEqualTo(String value) {
            addCriterion("CONTRACT_NAME <=", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameLike(String value) {
            addCriterion("CONTRACT_NAME like", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotLike(String value) {
            addCriterion("CONTRACT_NAME not like", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameIn(List<String> values) {
            addCriterion("CONTRACT_NAME in", values, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotIn(List<String> values) {
            addCriterion("CONTRACT_NAME not in", values, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameBetween(String value1, String value2) {
            addCriterion("CONTRACT_NAME between", value1, value2, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotBetween(String value1, String value2) {
            addCriterion("CONTRACT_NAME not between", value1, value2, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractCodeIsNull() {
            addCriterion("CONTRACT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andContractCodeIsNotNull() {
            addCriterion("CONTRACT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andContractCodeEqualTo(String value) {
            addCriterion("CONTRACT_CODE =", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeNotEqualTo(String value) {
            addCriterion("CONTRACT_CODE <>", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeGreaterThan(String value) {
            addCriterion("CONTRACT_CODE >", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACT_CODE >=", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeLessThan(String value) {
            addCriterion("CONTRACT_CODE <", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeLessThanOrEqualTo(String value) {
            addCriterion("CONTRACT_CODE <=", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeLike(String value) {
            addCriterion("CONTRACT_CODE like", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeNotLike(String value) {
            addCriterion("CONTRACT_CODE not like", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeIn(List<String> values) {
            addCriterion("CONTRACT_CODE in", values, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeNotIn(List<String> values) {
            addCriterion("CONTRACT_CODE not in", values, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeBetween(String value1, String value2) {
            addCriterion("CONTRACT_CODE between", value1, value2, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeNotBetween(String value1, String value2) {
            addCriterion("CONTRACT_CODE not between", value1, value2, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractorNameIsNull() {
            addCriterion("CONTRACTOR_NAME is null");
            return (Criteria) this;
        }

        public Criteria andContractorNameIsNotNull() {
            addCriterion("CONTRACTOR_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andContractorNameEqualTo(String value) {
            addCriterion("CONTRACTOR_NAME =", value, "contractorName");
            return (Criteria) this;
        }

        public Criteria andContractorNameNotEqualTo(String value) {
            addCriterion("CONTRACTOR_NAME <>", value, "contractorName");
            return (Criteria) this;
        }

        public Criteria andContractorNameGreaterThan(String value) {
            addCriterion("CONTRACTOR_NAME >", value, "contractorName");
            return (Criteria) this;
        }

        public Criteria andContractorNameGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACTOR_NAME >=", value, "contractorName");
            return (Criteria) this;
        }

        public Criteria andContractorNameLessThan(String value) {
            addCriterion("CONTRACTOR_NAME <", value, "contractorName");
            return (Criteria) this;
        }

        public Criteria andContractorNameLessThanOrEqualTo(String value) {
            addCriterion("CONTRACTOR_NAME <=", value, "contractorName");
            return (Criteria) this;
        }

        public Criteria andContractorNameLike(String value) {
            addCriterion("CONTRACTOR_NAME like", value, "contractorName");
            return (Criteria) this;
        }

        public Criteria andContractorNameNotLike(String value) {
            addCriterion("CONTRACTOR_NAME not like", value, "contractorName");
            return (Criteria) this;
        }

        public Criteria andContractorNameIn(List<String> values) {
            addCriterion("CONTRACTOR_NAME in", values, "contractorName");
            return (Criteria) this;
        }

        public Criteria andContractorNameNotIn(List<String> values) {
            addCriterion("CONTRACTOR_NAME not in", values, "contractorName");
            return (Criteria) this;
        }

        public Criteria andContractorNameBetween(String value1, String value2) {
            addCriterion("CONTRACTOR_NAME between", value1, value2, "contractorName");
            return (Criteria) this;
        }

        public Criteria andContractorNameNotBetween(String value1, String value2) {
            addCriterion("CONTRACTOR_NAME not between", value1, value2, "contractorName");
            return (Criteria) this;
        }

        public Criteria andContractorCodeIsNull() {
            addCriterion("CONTRACTOR_CODE is null");
            return (Criteria) this;
        }

        public Criteria andContractorCodeIsNotNull() {
            addCriterion("CONTRACTOR_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andContractorCodeEqualTo(String value) {
            addCriterion("CONTRACTOR_CODE =", value, "contractorCode");
            return (Criteria) this;
        }

        public Criteria andContractorCodeNotEqualTo(String value) {
            addCriterion("CONTRACTOR_CODE <>", value, "contractorCode");
            return (Criteria) this;
        }

        public Criteria andContractorCodeGreaterThan(String value) {
            addCriterion("CONTRACTOR_CODE >", value, "contractorCode");
            return (Criteria) this;
        }

        public Criteria andContractorCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACTOR_CODE >=", value, "contractorCode");
            return (Criteria) this;
        }

        public Criteria andContractorCodeLessThan(String value) {
            addCriterion("CONTRACTOR_CODE <", value, "contractorCode");
            return (Criteria) this;
        }

        public Criteria andContractorCodeLessThanOrEqualTo(String value) {
            addCriterion("CONTRACTOR_CODE <=", value, "contractorCode");
            return (Criteria) this;
        }

        public Criteria andContractorCodeLike(String value) {
            addCriterion("CONTRACTOR_CODE like", value, "contractorCode");
            return (Criteria) this;
        }

        public Criteria andContractorCodeNotLike(String value) {
            addCriterion("CONTRACTOR_CODE not like", value, "contractorCode");
            return (Criteria) this;
        }

        public Criteria andContractorCodeIn(List<String> values) {
            addCriterion("CONTRACTOR_CODE in", values, "contractorCode");
            return (Criteria) this;
        }

        public Criteria andContractorCodeNotIn(List<String> values) {
            addCriterion("CONTRACTOR_CODE not in", values, "contractorCode");
            return (Criteria) this;
        }

        public Criteria andContractorCodeBetween(String value1, String value2) {
            addCriterion("CONTRACTOR_CODE between", value1, value2, "contractorCode");
            return (Criteria) this;
        }

        public Criteria andContractorCodeNotBetween(String value1, String value2) {
            addCriterion("CONTRACTOR_CODE not between", value1, value2, "contractorCode");
            return (Criteria) this;
        }

        public Criteria andContractorIdIsNull() {
            addCriterion("CONTRACTOR_ID is null");
            return (Criteria) this;
        }

        public Criteria andContractorIdIsNotNull() {
            addCriterion("CONTRACTOR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andContractorIdEqualTo(String value) {
            addCriterion("CONTRACTOR_ID =", value, "contractorId");
            return (Criteria) this;
        }

        public Criteria andContractorIdNotEqualTo(String value) {
            addCriterion("CONTRACTOR_ID <>", value, "contractorId");
            return (Criteria) this;
        }

        public Criteria andContractorIdGreaterThan(String value) {
            addCriterion("CONTRACTOR_ID >", value, "contractorId");
            return (Criteria) this;
        }

        public Criteria andContractorIdGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACTOR_ID >=", value, "contractorId");
            return (Criteria) this;
        }

        public Criteria andContractorIdLessThan(String value) {
            addCriterion("CONTRACTOR_ID <", value, "contractorId");
            return (Criteria) this;
        }

        public Criteria andContractorIdLessThanOrEqualTo(String value) {
            addCriterion("CONTRACTOR_ID <=", value, "contractorId");
            return (Criteria) this;
        }

        public Criteria andContractorIdLike(String value) {
            addCriterion("CONTRACTOR_ID like", value, "contractorId");
            return (Criteria) this;
        }

        public Criteria andContractorIdNotLike(String value) {
            addCriterion("CONTRACTOR_ID not like", value, "contractorId");
            return (Criteria) this;
        }

        public Criteria andContractorIdIn(List<String> values) {
            addCriterion("CONTRACTOR_ID in", values, "contractorId");
            return (Criteria) this;
        }

        public Criteria andContractorIdNotIn(List<String> values) {
            addCriterion("CONTRACTOR_ID not in", values, "contractorId");
            return (Criteria) this;
        }

        public Criteria andContractorIdBetween(String value1, String value2) {
            addCriterion("CONTRACTOR_ID between", value1, value2, "contractorId");
            return (Criteria) this;
        }

        public Criteria andContractorIdNotBetween(String value1, String value2) {
            addCriterion("CONTRACTOR_ID not between", value1, value2, "contractorId");
            return (Criteria) this;
        }

        public Criteria andContractTypeIsNull() {
            addCriterion("CONTRACT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andContractTypeIsNotNull() {
            addCriterion("CONTRACT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andContractTypeEqualTo(String value) {
            addCriterion("CONTRACT_TYPE =", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeNotEqualTo(String value) {
            addCriterion("CONTRACT_TYPE <>", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeGreaterThan(String value) {
            addCriterion("CONTRACT_TYPE >", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACT_TYPE >=", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeLessThan(String value) {
            addCriterion("CONTRACT_TYPE <", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeLessThanOrEqualTo(String value) {
            addCriterion("CONTRACT_TYPE <=", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeLike(String value) {
            addCriterion("CONTRACT_TYPE like", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeNotLike(String value) {
            addCriterion("CONTRACT_TYPE not like", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeIn(List<String> values) {
            addCriterion("CONTRACT_TYPE in", values, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeNotIn(List<String> values) {
            addCriterion("CONTRACT_TYPE not in", values, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeBetween(String value1, String value2) {
            addCriterion("CONTRACT_TYPE between", value1, value2, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeNotBetween(String value1, String value2) {
            addCriterion("CONTRACT_TYPE not between", value1, value2, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractMoneyIsNull() {
            addCriterion("CONTRACT_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andContractMoneyIsNotNull() {
            addCriterion("CONTRACT_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andContractMoneyEqualTo(String value) {
            addCriterion("CONTRACT_MONEY =", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyNotEqualTo(String value) {
            addCriterion("CONTRACT_MONEY <>", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyGreaterThan(String value) {
            addCriterion("CONTRACT_MONEY >", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACT_MONEY >=", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyLessThan(String value) {
            addCriterion("CONTRACT_MONEY <", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyLessThanOrEqualTo(String value) {
            addCriterion("CONTRACT_MONEY <=", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyLike(String value) {
            addCriterion("CONTRACT_MONEY like", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyNotLike(String value) {
            addCriterion("CONTRACT_MONEY not like", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyIn(List<String> values) {
            addCriterion("CONTRACT_MONEY in", values, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyNotIn(List<String> values) {
            addCriterion("CONTRACT_MONEY not in", values, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyBetween(String value1, String value2) {
            addCriterion("CONTRACT_MONEY between", value1, value2, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyNotBetween(String value1, String value2) {
            addCriterion("CONTRACT_MONEY not between", value1, value2, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractCategoryIsNull() {
            addCriterion("CONTRACT_CATEGORY is null");
            return (Criteria) this;
        }

        public Criteria andContractCategoryIsNotNull() {
            addCriterion("CONTRACT_CATEGORY is not null");
            return (Criteria) this;
        }

        public Criteria andContractCategoryEqualTo(String value) {
            addCriterion("CONTRACT_CATEGORY =", value, "contractCategory");
            return (Criteria) this;
        }

        public Criteria andContractCategoryNotEqualTo(String value) {
            addCriterion("CONTRACT_CATEGORY <>", value, "contractCategory");
            return (Criteria) this;
        }

        public Criteria andContractCategoryGreaterThan(String value) {
            addCriterion("CONTRACT_CATEGORY >", value, "contractCategory");
            return (Criteria) this;
        }

        public Criteria andContractCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACT_CATEGORY >=", value, "contractCategory");
            return (Criteria) this;
        }

        public Criteria andContractCategoryLessThan(String value) {
            addCriterion("CONTRACT_CATEGORY <", value, "contractCategory");
            return (Criteria) this;
        }

        public Criteria andContractCategoryLessThanOrEqualTo(String value) {
            addCriterion("CONTRACT_CATEGORY <=", value, "contractCategory");
            return (Criteria) this;
        }

        public Criteria andContractCategoryLike(String value) {
            addCriterion("CONTRACT_CATEGORY like", value, "contractCategory");
            return (Criteria) this;
        }

        public Criteria andContractCategoryNotLike(String value) {
            addCriterion("CONTRACT_CATEGORY not like", value, "contractCategory");
            return (Criteria) this;
        }

        public Criteria andContractCategoryIn(List<String> values) {
            addCriterion("CONTRACT_CATEGORY in", values, "contractCategory");
            return (Criteria) this;
        }

        public Criteria andContractCategoryNotIn(List<String> values) {
            addCriterion("CONTRACT_CATEGORY not in", values, "contractCategory");
            return (Criteria) this;
        }

        public Criteria andContractCategoryBetween(String value1, String value2) {
            addCriterion("CONTRACT_CATEGORY between", value1, value2, "contractCategory");
            return (Criteria) this;
        }

        public Criteria andContractCategoryNotBetween(String value1, String value2) {
            addCriterion("CONTRACT_CATEGORY not between", value1, value2, "contractCategory");
            return (Criteria) this;
        }

        public Criteria andContractSignDateIsNull() {
            addCriterion("CONTRACT_SIGN_DATE is null");
            return (Criteria) this;
        }

        public Criteria andContractSignDateIsNotNull() {
            addCriterion("CONTRACT_SIGN_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andContractSignDateEqualTo(String value) {
            addCriterion("CONTRACT_SIGN_DATE =", value, "contractSignDate");
            return (Criteria) this;
        }

        public Criteria andContractSignDateNotEqualTo(String value) {
            addCriterion("CONTRACT_SIGN_DATE <>", value, "contractSignDate");
            return (Criteria) this;
        }

        public Criteria andContractSignDateGreaterThan(String value) {
            addCriterion("CONTRACT_SIGN_DATE >", value, "contractSignDate");
            return (Criteria) this;
        }

        public Criteria andContractSignDateGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACT_SIGN_DATE >=", value, "contractSignDate");
            return (Criteria) this;
        }

        public Criteria andContractSignDateLessThan(String value) {
            addCriterion("CONTRACT_SIGN_DATE <", value, "contractSignDate");
            return (Criteria) this;
        }

        public Criteria andContractSignDateLessThanOrEqualTo(String value) {
            addCriterion("CONTRACT_SIGN_DATE <=", value, "contractSignDate");
            return (Criteria) this;
        }

        public Criteria andContractSignDateLike(String value) {
            addCriterion("CONTRACT_SIGN_DATE like", value, "contractSignDate");
            return (Criteria) this;
        }

        public Criteria andContractSignDateNotLike(String value) {
            addCriterion("CONTRACT_SIGN_DATE not like", value, "contractSignDate");
            return (Criteria) this;
        }

        public Criteria andContractSignDateIn(List<String> values) {
            addCriterion("CONTRACT_SIGN_DATE in", values, "contractSignDate");
            return (Criteria) this;
        }

        public Criteria andContractSignDateNotIn(List<String> values) {
            addCriterion("CONTRACT_SIGN_DATE not in", values, "contractSignDate");
            return (Criteria) this;
        }

        public Criteria andContractSignDateBetween(String value1, String value2) {
            addCriterion("CONTRACT_SIGN_DATE between", value1, value2, "contractSignDate");
            return (Criteria) this;
        }

        public Criteria andContractSignDateNotBetween(String value1, String value2) {
            addCriterion("CONTRACT_SIGN_DATE not between", value1, value2, "contractSignDate");
            return (Criteria) this;
        }

        public Criteria andContractEffectDateIsNull() {
            addCriterion("CONTRACT_EFFECT_DATE is null");
            return (Criteria) this;
        }

        public Criteria andContractEffectDateIsNotNull() {
            addCriterion("CONTRACT_EFFECT_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andContractEffectDateEqualTo(String value) {
            addCriterion("CONTRACT_EFFECT_DATE =", value, "contractEffectDate");
            return (Criteria) this;
        }

        public Criteria andContractEffectDateNotEqualTo(String value) {
            addCriterion("CONTRACT_EFFECT_DATE <>", value, "contractEffectDate");
            return (Criteria) this;
        }

        public Criteria andContractEffectDateGreaterThan(String value) {
            addCriterion("CONTRACT_EFFECT_DATE >", value, "contractEffectDate");
            return (Criteria) this;
        }

        public Criteria andContractEffectDateGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACT_EFFECT_DATE >=", value, "contractEffectDate");
            return (Criteria) this;
        }

        public Criteria andContractEffectDateLessThan(String value) {
            addCriterion("CONTRACT_EFFECT_DATE <", value, "contractEffectDate");
            return (Criteria) this;
        }

        public Criteria andContractEffectDateLessThanOrEqualTo(String value) {
            addCriterion("CONTRACT_EFFECT_DATE <=", value, "contractEffectDate");
            return (Criteria) this;
        }

        public Criteria andContractEffectDateLike(String value) {
            addCriterion("CONTRACT_EFFECT_DATE like", value, "contractEffectDate");
            return (Criteria) this;
        }

        public Criteria andContractEffectDateNotLike(String value) {
            addCriterion("CONTRACT_EFFECT_DATE not like", value, "contractEffectDate");
            return (Criteria) this;
        }

        public Criteria andContractEffectDateIn(List<String> values) {
            addCriterion("CONTRACT_EFFECT_DATE in", values, "contractEffectDate");
            return (Criteria) this;
        }

        public Criteria andContractEffectDateNotIn(List<String> values) {
            addCriterion("CONTRACT_EFFECT_DATE not in", values, "contractEffectDate");
            return (Criteria) this;
        }

        public Criteria andContractEffectDateBetween(String value1, String value2) {
            addCriterion("CONTRACT_EFFECT_DATE between", value1, value2, "contractEffectDate");
            return (Criteria) this;
        }

        public Criteria andContractEffectDateNotBetween(String value1, String value2) {
            addCriterion("CONTRACT_EFFECT_DATE not between", value1, value2, "contractEffectDate");
            return (Criteria) this;
        }

        public Criteria andContractStartDateIsNull() {
            addCriterion("CONTRACT_START_DATE is null");
            return (Criteria) this;
        }

        public Criteria andContractStartDateIsNotNull() {
            addCriterion("CONTRACT_START_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andContractStartDateEqualTo(String value) {
            addCriterion("CONTRACT_START_DATE =", value, "contractStartDate");
            return (Criteria) this;
        }

        public Criteria andContractStartDateNotEqualTo(String value) {
            addCriterion("CONTRACT_START_DATE <>", value, "contractStartDate");
            return (Criteria) this;
        }

        public Criteria andContractStartDateGreaterThan(String value) {
            addCriterion("CONTRACT_START_DATE >", value, "contractStartDate");
            return (Criteria) this;
        }

        public Criteria andContractStartDateGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACT_START_DATE >=", value, "contractStartDate");
            return (Criteria) this;
        }

        public Criteria andContractStartDateLessThan(String value) {
            addCriterion("CONTRACT_START_DATE <", value, "contractStartDate");
            return (Criteria) this;
        }

        public Criteria andContractStartDateLessThanOrEqualTo(String value) {
            addCriterion("CONTRACT_START_DATE <=", value, "contractStartDate");
            return (Criteria) this;
        }

        public Criteria andContractStartDateLike(String value) {
            addCriterion("CONTRACT_START_DATE like", value, "contractStartDate");
            return (Criteria) this;
        }

        public Criteria andContractStartDateNotLike(String value) {
            addCriterion("CONTRACT_START_DATE not like", value, "contractStartDate");
            return (Criteria) this;
        }

        public Criteria andContractStartDateIn(List<String> values) {
            addCriterion("CONTRACT_START_DATE in", values, "contractStartDate");
            return (Criteria) this;
        }

        public Criteria andContractStartDateNotIn(List<String> values) {
            addCriterion("CONTRACT_START_DATE not in", values, "contractStartDate");
            return (Criteria) this;
        }

        public Criteria andContractStartDateBetween(String value1, String value2) {
            addCriterion("CONTRACT_START_DATE between", value1, value2, "contractStartDate");
            return (Criteria) this;
        }

        public Criteria andContractStartDateNotBetween(String value1, String value2) {
            addCriterion("CONTRACT_START_DATE not between", value1, value2, "contractStartDate");
            return (Criteria) this;
        }

        public Criteria andContractEndDateIsNull() {
            addCriterion("CONTRACT_END_DATE is null");
            return (Criteria) this;
        }

        public Criteria andContractEndDateIsNotNull() {
            addCriterion("CONTRACT_END_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andContractEndDateEqualTo(String value) {
            addCriterion("CONTRACT_END_DATE =", value, "contractEndDate");
            return (Criteria) this;
        }

        public Criteria andContractEndDateNotEqualTo(String value) {
            addCriterion("CONTRACT_END_DATE <>", value, "contractEndDate");
            return (Criteria) this;
        }

        public Criteria andContractEndDateGreaterThan(String value) {
            addCriterion("CONTRACT_END_DATE >", value, "contractEndDate");
            return (Criteria) this;
        }

        public Criteria andContractEndDateGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACT_END_DATE >=", value, "contractEndDate");
            return (Criteria) this;
        }

        public Criteria andContractEndDateLessThan(String value) {
            addCriterion("CONTRACT_END_DATE <", value, "contractEndDate");
            return (Criteria) this;
        }

        public Criteria andContractEndDateLessThanOrEqualTo(String value) {
            addCriterion("CONTRACT_END_DATE <=", value, "contractEndDate");
            return (Criteria) this;
        }

        public Criteria andContractEndDateLike(String value) {
            addCriterion("CONTRACT_END_DATE like", value, "contractEndDate");
            return (Criteria) this;
        }

        public Criteria andContractEndDateNotLike(String value) {
            addCriterion("CONTRACT_END_DATE not like", value, "contractEndDate");
            return (Criteria) this;
        }

        public Criteria andContractEndDateIn(List<String> values) {
            addCriterion("CONTRACT_END_DATE in", values, "contractEndDate");
            return (Criteria) this;
        }

        public Criteria andContractEndDateNotIn(List<String> values) {
            addCriterion("CONTRACT_END_DATE not in", values, "contractEndDate");
            return (Criteria) this;
        }

        public Criteria andContractEndDateBetween(String value1, String value2) {
            addCriterion("CONTRACT_END_DATE between", value1, value2, "contractEndDate");
            return (Criteria) this;
        }

        public Criteria andContractEndDateNotBetween(String value1, String value2) {
            addCriterion("CONTRACT_END_DATE not between", value1, value2, "contractEndDate");
            return (Criteria) this;
        }

        public Criteria andAdminUnitNameIsNull() {
            addCriterion("ADMIN_UNIT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andAdminUnitNameIsNotNull() {
            addCriterion("ADMIN_UNIT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andAdminUnitNameEqualTo(String value) {
            addCriterion("ADMIN_UNIT_NAME =", value, "adminUnitName");
            return (Criteria) this;
        }

        public Criteria andAdminUnitNameNotEqualTo(String value) {
            addCriterion("ADMIN_UNIT_NAME <>", value, "adminUnitName");
            return (Criteria) this;
        }

        public Criteria andAdminUnitNameGreaterThan(String value) {
            addCriterion("ADMIN_UNIT_NAME >", value, "adminUnitName");
            return (Criteria) this;
        }

        public Criteria andAdminUnitNameGreaterThanOrEqualTo(String value) {
            addCriterion("ADMIN_UNIT_NAME >=", value, "adminUnitName");
            return (Criteria) this;
        }

        public Criteria andAdminUnitNameLessThan(String value) {
            addCriterion("ADMIN_UNIT_NAME <", value, "adminUnitName");
            return (Criteria) this;
        }

        public Criteria andAdminUnitNameLessThanOrEqualTo(String value) {
            addCriterion("ADMIN_UNIT_NAME <=", value, "adminUnitName");
            return (Criteria) this;
        }

        public Criteria andAdminUnitNameLike(String value) {
            addCriterion("ADMIN_UNIT_NAME like", value, "adminUnitName");
            return (Criteria) this;
        }

        public Criteria andAdminUnitNameNotLike(String value) {
            addCriterion("ADMIN_UNIT_NAME not like", value, "adminUnitName");
            return (Criteria) this;
        }

        public Criteria andAdminUnitNameIn(List<String> values) {
            addCriterion("ADMIN_UNIT_NAME in", values, "adminUnitName");
            return (Criteria) this;
        }

        public Criteria andAdminUnitNameNotIn(List<String> values) {
            addCriterion("ADMIN_UNIT_NAME not in", values, "adminUnitName");
            return (Criteria) this;
        }

        public Criteria andAdminUnitNameBetween(String value1, String value2) {
            addCriterion("ADMIN_UNIT_NAME between", value1, value2, "adminUnitName");
            return (Criteria) this;
        }

        public Criteria andAdminUnitNameNotBetween(String value1, String value2) {
            addCriterion("ADMIN_UNIT_NAME not between", value1, value2, "adminUnitName");
            return (Criteria) this;
        }

        public Criteria andAdminUserNameIsNull() {
            addCriterion("ADMIN_USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andAdminUserNameIsNotNull() {
            addCriterion("ADMIN_USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andAdminUserNameEqualTo(String value) {
            addCriterion("ADMIN_USER_NAME =", value, "adminUserName");
            return (Criteria) this;
        }

        public Criteria andAdminUserNameNotEqualTo(String value) {
            addCriterion("ADMIN_USER_NAME <>", value, "adminUserName");
            return (Criteria) this;
        }

        public Criteria andAdminUserNameGreaterThan(String value) {
            addCriterion("ADMIN_USER_NAME >", value, "adminUserName");
            return (Criteria) this;
        }

        public Criteria andAdminUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("ADMIN_USER_NAME >=", value, "adminUserName");
            return (Criteria) this;
        }

        public Criteria andAdminUserNameLessThan(String value) {
            addCriterion("ADMIN_USER_NAME <", value, "adminUserName");
            return (Criteria) this;
        }

        public Criteria andAdminUserNameLessThanOrEqualTo(String value) {
            addCriterion("ADMIN_USER_NAME <=", value, "adminUserName");
            return (Criteria) this;
        }

        public Criteria andAdminUserNameLike(String value) {
            addCriterion("ADMIN_USER_NAME like", value, "adminUserName");
            return (Criteria) this;
        }

        public Criteria andAdminUserNameNotLike(String value) {
            addCriterion("ADMIN_USER_NAME not like", value, "adminUserName");
            return (Criteria) this;
        }

        public Criteria andAdminUserNameIn(List<String> values) {
            addCriterion("ADMIN_USER_NAME in", values, "adminUserName");
            return (Criteria) this;
        }

        public Criteria andAdminUserNameNotIn(List<String> values) {
            addCriterion("ADMIN_USER_NAME not in", values, "adminUserName");
            return (Criteria) this;
        }

        public Criteria andAdminUserNameBetween(String value1, String value2) {
            addCriterion("ADMIN_USER_NAME between", value1, value2, "adminUserName");
            return (Criteria) this;
        }

        public Criteria andAdminUserNameNotBetween(String value1, String value2) {
            addCriterion("ADMIN_USER_NAME not between", value1, value2, "adminUserName");
            return (Criteria) this;
        }

        public Criteria andContractContentIsNull() {
            addCriterion("CONTRACT_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andContractContentIsNotNull() {
            addCriterion("CONTRACT_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andContractContentEqualTo(String value) {
            addCriterion("CONTRACT_CONTENT =", value, "contractContent");
            return (Criteria) this;
        }

        public Criteria andContractContentNotEqualTo(String value) {
            addCriterion("CONTRACT_CONTENT <>", value, "contractContent");
            return (Criteria) this;
        }

        public Criteria andContractContentGreaterThan(String value) {
            addCriterion("CONTRACT_CONTENT >", value, "contractContent");
            return (Criteria) this;
        }

        public Criteria andContractContentGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACT_CONTENT >=", value, "contractContent");
            return (Criteria) this;
        }

        public Criteria andContractContentLessThan(String value) {
            addCriterion("CONTRACT_CONTENT <", value, "contractContent");
            return (Criteria) this;
        }

        public Criteria andContractContentLessThanOrEqualTo(String value) {
            addCriterion("CONTRACT_CONTENT <=", value, "contractContent");
            return (Criteria) this;
        }

        public Criteria andContractContentLike(String value) {
            addCriterion("CONTRACT_CONTENT like", value, "contractContent");
            return (Criteria) this;
        }

        public Criteria andContractContentNotLike(String value) {
            addCriterion("CONTRACT_CONTENT not like", value, "contractContent");
            return (Criteria) this;
        }

        public Criteria andContractContentIn(List<String> values) {
            addCriterion("CONTRACT_CONTENT in", values, "contractContent");
            return (Criteria) this;
        }

        public Criteria andContractContentNotIn(List<String> values) {
            addCriterion("CONTRACT_CONTENT not in", values, "contractContent");
            return (Criteria) this;
        }

        public Criteria andContractContentBetween(String value1, String value2) {
            addCriterion("CONTRACT_CONTENT between", value1, value2, "contractContent");
            return (Criteria) this;
        }

        public Criteria andContractContentNotBetween(String value1, String value2) {
            addCriterion("CONTRACT_CONTENT not between", value1, value2, "contractContent");
            return (Criteria) this;
        }

        public Criteria andContractDetailIsNull() {
            addCriterion("CONTRACT_DETAIL is null");
            return (Criteria) this;
        }

        public Criteria andContractDetailIsNotNull() {
            addCriterion("CONTRACT_DETAIL is not null");
            return (Criteria) this;
        }

        public Criteria andContractDetailEqualTo(String value) {
            addCriterion("CONTRACT_DETAIL =", value, "contractDetail");
            return (Criteria) this;
        }

        public Criteria andContractDetailNotEqualTo(String value) {
            addCriterion("CONTRACT_DETAIL <>", value, "contractDetail");
            return (Criteria) this;
        }

        public Criteria andContractDetailGreaterThan(String value) {
            addCriterion("CONTRACT_DETAIL >", value, "contractDetail");
            return (Criteria) this;
        }

        public Criteria andContractDetailGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACT_DETAIL >=", value, "contractDetail");
            return (Criteria) this;
        }

        public Criteria andContractDetailLessThan(String value) {
            addCriterion("CONTRACT_DETAIL <", value, "contractDetail");
            return (Criteria) this;
        }

        public Criteria andContractDetailLessThanOrEqualTo(String value) {
            addCriterion("CONTRACT_DETAIL <=", value, "contractDetail");
            return (Criteria) this;
        }

        public Criteria andContractDetailLike(String value) {
            addCriterion("CONTRACT_DETAIL like", value, "contractDetail");
            return (Criteria) this;
        }

        public Criteria andContractDetailNotLike(String value) {
            addCriterion("CONTRACT_DETAIL not like", value, "contractDetail");
            return (Criteria) this;
        }

        public Criteria andContractDetailIn(List<String> values) {
            addCriterion("CONTRACT_DETAIL in", values, "contractDetail");
            return (Criteria) this;
        }

        public Criteria andContractDetailNotIn(List<String> values) {
            addCriterion("CONTRACT_DETAIL not in", values, "contractDetail");
            return (Criteria) this;
        }

        public Criteria andContractDetailBetween(String value1, String value2) {
            addCriterion("CONTRACT_DETAIL between", value1, value2, "contractDetail");
            return (Criteria) this;
        }

        public Criteria andContractDetailNotBetween(String value1, String value2) {
            addCriterion("CONTRACT_DETAIL not between", value1, value2, "contractDetail");
            return (Criteria) this;
        }

        public Criteria andContractSafeMoneyIsNull() {
            addCriterion("CONTRACT_SAFE_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andContractSafeMoneyIsNotNull() {
            addCriterion("CONTRACT_SAFE_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andContractSafeMoneyEqualTo(String value) {
            addCriterion("CONTRACT_SAFE_MONEY =", value, "contractSafeMoney");
            return (Criteria) this;
        }

        public Criteria andContractSafeMoneyNotEqualTo(String value) {
            addCriterion("CONTRACT_SAFE_MONEY <>", value, "contractSafeMoney");
            return (Criteria) this;
        }

        public Criteria andContractSafeMoneyGreaterThan(String value) {
            addCriterion("CONTRACT_SAFE_MONEY >", value, "contractSafeMoney");
            return (Criteria) this;
        }

        public Criteria andContractSafeMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACT_SAFE_MONEY >=", value, "contractSafeMoney");
            return (Criteria) this;
        }

        public Criteria andContractSafeMoneyLessThan(String value) {
            addCriterion("CONTRACT_SAFE_MONEY <", value, "contractSafeMoney");
            return (Criteria) this;
        }

        public Criteria andContractSafeMoneyLessThanOrEqualTo(String value) {
            addCriterion("CONTRACT_SAFE_MONEY <=", value, "contractSafeMoney");
            return (Criteria) this;
        }

        public Criteria andContractSafeMoneyLike(String value) {
            addCriterion("CONTRACT_SAFE_MONEY like", value, "contractSafeMoney");
            return (Criteria) this;
        }

        public Criteria andContractSafeMoneyNotLike(String value) {
            addCriterion("CONTRACT_SAFE_MONEY not like", value, "contractSafeMoney");
            return (Criteria) this;
        }

        public Criteria andContractSafeMoneyIn(List<String> values) {
            addCriterion("CONTRACT_SAFE_MONEY in", values, "contractSafeMoney");
            return (Criteria) this;
        }

        public Criteria andContractSafeMoneyNotIn(List<String> values) {
            addCriterion("CONTRACT_SAFE_MONEY not in", values, "contractSafeMoney");
            return (Criteria) this;
        }

        public Criteria andContractSafeMoneyBetween(String value1, String value2) {
            addCriterion("CONTRACT_SAFE_MONEY between", value1, value2, "contractSafeMoney");
            return (Criteria) this;
        }

        public Criteria andContractSafeMoneyNotBetween(String value1, String value2) {
            addCriterion("CONTRACT_SAFE_MONEY not between", value1, value2, "contractSafeMoney");
            return (Criteria) this;
        }

        public Criteria andIsSignedIsNull() {
            addCriterion("IS_SIGNED is null");
            return (Criteria) this;
        }

        public Criteria andIsSignedIsNotNull() {
            addCriterion("IS_SIGNED is not null");
            return (Criteria) this;
        }

        public Criteria andIsSignedEqualTo(String value) {
            addCriterion("IS_SIGNED =", value, "isSigned");
            return (Criteria) this;
        }

        public Criteria andIsSignedNotEqualTo(String value) {
            addCriterion("IS_SIGNED <>", value, "isSigned");
            return (Criteria) this;
        }

        public Criteria andIsSignedGreaterThan(String value) {
            addCriterion("IS_SIGNED >", value, "isSigned");
            return (Criteria) this;
        }

        public Criteria andIsSignedGreaterThanOrEqualTo(String value) {
            addCriterion("IS_SIGNED >=", value, "isSigned");
            return (Criteria) this;
        }

        public Criteria andIsSignedLessThan(String value) {
            addCriterion("IS_SIGNED <", value, "isSigned");
            return (Criteria) this;
        }

        public Criteria andIsSignedLessThanOrEqualTo(String value) {
            addCriterion("IS_SIGNED <=", value, "isSigned");
            return (Criteria) this;
        }

        public Criteria andIsSignedLike(String value) {
            addCriterion("IS_SIGNED like", value, "isSigned");
            return (Criteria) this;
        }

        public Criteria andIsSignedNotLike(String value) {
            addCriterion("IS_SIGNED not like", value, "isSigned");
            return (Criteria) this;
        }

        public Criteria andIsSignedIn(List<String> values) {
            addCriterion("IS_SIGNED in", values, "isSigned");
            return (Criteria) this;
        }

        public Criteria andIsSignedNotIn(List<String> values) {
            addCriterion("IS_SIGNED not in", values, "isSigned");
            return (Criteria) this;
        }

        public Criteria andIsSignedBetween(String value1, String value2) {
            addCriterion("IS_SIGNED between", value1, value2, "isSigned");
            return (Criteria) this;
        }

        public Criteria andIsSignedNotBetween(String value1, String value2) {
            addCriterion("IS_SIGNED not between", value1, value2, "isSigned");
            return (Criteria) this;
        }

        public Criteria andCmisContractNameIsNull() {
            addCriterion("CMIS_CONTRACT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCmisContractNameIsNotNull() {
            addCriterion("CMIS_CONTRACT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCmisContractNameEqualTo(String value) {
            addCriterion("CMIS_CONTRACT_NAME =", value, "cmisContractName");
            return (Criteria) this;
        }

        public Criteria andCmisContractNameNotEqualTo(String value) {
            addCriterion("CMIS_CONTRACT_NAME <>", value, "cmisContractName");
            return (Criteria) this;
        }

        public Criteria andCmisContractNameGreaterThan(String value) {
            addCriterion("CMIS_CONTRACT_NAME >", value, "cmisContractName");
            return (Criteria) this;
        }

        public Criteria andCmisContractNameGreaterThanOrEqualTo(String value) {
            addCriterion("CMIS_CONTRACT_NAME >=", value, "cmisContractName");
            return (Criteria) this;
        }

        public Criteria andCmisContractNameLessThan(String value) {
            addCriterion("CMIS_CONTRACT_NAME <", value, "cmisContractName");
            return (Criteria) this;
        }

        public Criteria andCmisContractNameLessThanOrEqualTo(String value) {
            addCriterion("CMIS_CONTRACT_NAME <=", value, "cmisContractName");
            return (Criteria) this;
        }

        public Criteria andCmisContractNameLike(String value) {
            addCriterion("CMIS_CONTRACT_NAME like", value, "cmisContractName");
            return (Criteria) this;
        }

        public Criteria andCmisContractNameNotLike(String value) {
            addCriterion("CMIS_CONTRACT_NAME not like", value, "cmisContractName");
            return (Criteria) this;
        }

        public Criteria andCmisContractNameIn(List<String> values) {
            addCriterion("CMIS_CONTRACT_NAME in", values, "cmisContractName");
            return (Criteria) this;
        }

        public Criteria andCmisContractNameNotIn(List<String> values) {
            addCriterion("CMIS_CONTRACT_NAME not in", values, "cmisContractName");
            return (Criteria) this;
        }

        public Criteria andCmisContractNameBetween(String value1, String value2) {
            addCriterion("CMIS_CONTRACT_NAME between", value1, value2, "cmisContractName");
            return (Criteria) this;
        }

        public Criteria andCmisContractNameNotBetween(String value1, String value2) {
            addCriterion("CMIS_CONTRACT_NAME not between", value1, value2, "cmisContractName");
            return (Criteria) this;
        }

        public Criteria andCmisContractCodeIsNull() {
            addCriterion("CMIS_CONTRACT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCmisContractCodeIsNotNull() {
            addCriterion("CMIS_CONTRACT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCmisContractCodeEqualTo(String value) {
            addCriterion("CMIS_CONTRACT_CODE =", value, "cmisContractCode");
            return (Criteria) this;
        }

        public Criteria andCmisContractCodeNotEqualTo(String value) {
            addCriterion("CMIS_CONTRACT_CODE <>", value, "cmisContractCode");
            return (Criteria) this;
        }

        public Criteria andCmisContractCodeGreaterThan(String value) {
            addCriterion("CMIS_CONTRACT_CODE >", value, "cmisContractCode");
            return (Criteria) this;
        }

        public Criteria andCmisContractCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CMIS_CONTRACT_CODE >=", value, "cmisContractCode");
            return (Criteria) this;
        }

        public Criteria andCmisContractCodeLessThan(String value) {
            addCriterion("CMIS_CONTRACT_CODE <", value, "cmisContractCode");
            return (Criteria) this;
        }

        public Criteria andCmisContractCodeLessThanOrEqualTo(String value) {
            addCriterion("CMIS_CONTRACT_CODE <=", value, "cmisContractCode");
            return (Criteria) this;
        }

        public Criteria andCmisContractCodeLike(String value) {
            addCriterion("CMIS_CONTRACT_CODE like", value, "cmisContractCode");
            return (Criteria) this;
        }

        public Criteria andCmisContractCodeNotLike(String value) {
            addCriterion("CMIS_CONTRACT_CODE not like", value, "cmisContractCode");
            return (Criteria) this;
        }

        public Criteria andCmisContractCodeIn(List<String> values) {
            addCriterion("CMIS_CONTRACT_CODE in", values, "cmisContractCode");
            return (Criteria) this;
        }

        public Criteria andCmisContractCodeNotIn(List<String> values) {
            addCriterion("CMIS_CONTRACT_CODE not in", values, "cmisContractCode");
            return (Criteria) this;
        }

        public Criteria andCmisContractCodeBetween(String value1, String value2) {
            addCriterion("CMIS_CONTRACT_CODE between", value1, value2, "cmisContractCode");
            return (Criteria) this;
        }

        public Criteria andCmisContractCodeNotBetween(String value1, String value2) {
            addCriterion("CMIS_CONTRACT_CODE not between", value1, value2, "cmisContractCode");
            return (Criteria) this;
        }

        public Criteria andContractRecordNoIsNull() {
            addCriterion("CONTRACT_RECORD_NO is null");
            return (Criteria) this;
        }

        public Criteria andContractRecordNoIsNotNull() {
            addCriterion("CONTRACT_RECORD_NO is not null");
            return (Criteria) this;
        }

        public Criteria andContractRecordNoEqualTo(String value) {
            addCriterion("CONTRACT_RECORD_NO =", value, "contractRecordNo");
            return (Criteria) this;
        }

        public Criteria andContractRecordNoNotEqualTo(String value) {
            addCriterion("CONTRACT_RECORD_NO <>", value, "contractRecordNo");
            return (Criteria) this;
        }

        public Criteria andContractRecordNoGreaterThan(String value) {
            addCriterion("CONTRACT_RECORD_NO >", value, "contractRecordNo");
            return (Criteria) this;
        }

        public Criteria andContractRecordNoGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACT_RECORD_NO >=", value, "contractRecordNo");
            return (Criteria) this;
        }

        public Criteria andContractRecordNoLessThan(String value) {
            addCriterion("CONTRACT_RECORD_NO <", value, "contractRecordNo");
            return (Criteria) this;
        }

        public Criteria andContractRecordNoLessThanOrEqualTo(String value) {
            addCriterion("CONTRACT_RECORD_NO <=", value, "contractRecordNo");
            return (Criteria) this;
        }

        public Criteria andContractRecordNoLike(String value) {
            addCriterion("CONTRACT_RECORD_NO like", value, "contractRecordNo");
            return (Criteria) this;
        }

        public Criteria andContractRecordNoNotLike(String value) {
            addCriterion("CONTRACT_RECORD_NO not like", value, "contractRecordNo");
            return (Criteria) this;
        }

        public Criteria andContractRecordNoIn(List<String> values) {
            addCriterion("CONTRACT_RECORD_NO in", values, "contractRecordNo");
            return (Criteria) this;
        }

        public Criteria andContractRecordNoNotIn(List<String> values) {
            addCriterion("CONTRACT_RECORD_NO not in", values, "contractRecordNo");
            return (Criteria) this;
        }

        public Criteria andContractRecordNoBetween(String value1, String value2) {
            addCriterion("CONTRACT_RECORD_NO between", value1, value2, "contractRecordNo");
            return (Criteria) this;
        }

        public Criteria andContractRecordNoNotBetween(String value1, String value2) {
            addCriterion("CONTRACT_RECORD_NO not between", value1, value2, "contractRecordNo");
            return (Criteria) this;
        }

        public Criteria andCbsNameIsNull() {
            addCriterion("CBS_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCbsNameIsNotNull() {
            addCriterion("CBS_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCbsNameEqualTo(String value) {
            addCriterion("CBS_NAME =", value, "cbsName");
            return (Criteria) this;
        }

        public Criteria andCbsNameNotEqualTo(String value) {
            addCriterion("CBS_NAME <>", value, "cbsName");
            return (Criteria) this;
        }

        public Criteria andCbsNameGreaterThan(String value) {
            addCriterion("CBS_NAME >", value, "cbsName");
            return (Criteria) this;
        }

        public Criteria andCbsNameGreaterThanOrEqualTo(String value) {
            addCriterion("CBS_NAME >=", value, "cbsName");
            return (Criteria) this;
        }

        public Criteria andCbsNameLessThan(String value) {
            addCriterion("CBS_NAME <", value, "cbsName");
            return (Criteria) this;
        }

        public Criteria andCbsNameLessThanOrEqualTo(String value) {
            addCriterion("CBS_NAME <=", value, "cbsName");
            return (Criteria) this;
        }

        public Criteria andCbsNameLike(String value) {
            addCriterion("CBS_NAME like", value, "cbsName");
            return (Criteria) this;
        }

        public Criteria andCbsNameNotLike(String value) {
            addCriterion("CBS_NAME not like", value, "cbsName");
            return (Criteria) this;
        }

        public Criteria andCbsNameIn(List<String> values) {
            addCriterion("CBS_NAME in", values, "cbsName");
            return (Criteria) this;
        }

        public Criteria andCbsNameNotIn(List<String> values) {
            addCriterion("CBS_NAME not in", values, "cbsName");
            return (Criteria) this;
        }

        public Criteria andCbsNameBetween(String value1, String value2) {
            addCriterion("CBS_NAME between", value1, value2, "cbsName");
            return (Criteria) this;
        }

        public Criteria andCbsNameNotBetween(String value1, String value2) {
            addCriterion("CBS_NAME not between", value1, value2, "cbsName");
            return (Criteria) this;
        }

        public Criteria andCbsCodeIsNull() {
            addCriterion("CBS_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCbsCodeIsNotNull() {
            addCriterion("CBS_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCbsCodeEqualTo(String value) {
            addCriterion("CBS_CODE =", value, "cbsCode");
            return (Criteria) this;
        }

        public Criteria andCbsCodeNotEqualTo(String value) {
            addCriterion("CBS_CODE <>", value, "cbsCode");
            return (Criteria) this;
        }

        public Criteria andCbsCodeGreaterThan(String value) {
            addCriterion("CBS_CODE >", value, "cbsCode");
            return (Criteria) this;
        }

        public Criteria andCbsCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CBS_CODE >=", value, "cbsCode");
            return (Criteria) this;
        }

        public Criteria andCbsCodeLessThan(String value) {
            addCriterion("CBS_CODE <", value, "cbsCode");
            return (Criteria) this;
        }

        public Criteria andCbsCodeLessThanOrEqualTo(String value) {
            addCriterion("CBS_CODE <=", value, "cbsCode");
            return (Criteria) this;
        }

        public Criteria andCbsCodeLike(String value) {
            addCriterion("CBS_CODE like", value, "cbsCode");
            return (Criteria) this;
        }

        public Criteria andCbsCodeNotLike(String value) {
            addCriterion("CBS_CODE not like", value, "cbsCode");
            return (Criteria) this;
        }

        public Criteria andCbsCodeIn(List<String> values) {
            addCriterion("CBS_CODE in", values, "cbsCode");
            return (Criteria) this;
        }

        public Criteria andCbsCodeNotIn(List<String> values) {
            addCriterion("CBS_CODE not in", values, "cbsCode");
            return (Criteria) this;
        }

        public Criteria andCbsCodeBetween(String value1, String value2) {
            addCriterion("CBS_CODE between", value1, value2, "cbsCode");
            return (Criteria) this;
        }

        public Criteria andCbsCodeNotBetween(String value1, String value2) {
            addCriterion("CBS_CODE not between", value1, value2, "cbsCode");
            return (Criteria) this;
        }

        public Criteria andContractUnitNameIsNull() {
            addCriterion("CONTRACT_UNIT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andContractUnitNameIsNotNull() {
            addCriterion("CONTRACT_UNIT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andContractUnitNameEqualTo(String value) {
            addCriterion("CONTRACT_UNIT_NAME =", value, "contractUnitName");
            return (Criteria) this;
        }

        public Criteria andContractUnitNameNotEqualTo(String value) {
            addCriterion("CONTRACT_UNIT_NAME <>", value, "contractUnitName");
            return (Criteria) this;
        }

        public Criteria andContractUnitNameGreaterThan(String value) {
            addCriterion("CONTRACT_UNIT_NAME >", value, "contractUnitName");
            return (Criteria) this;
        }

        public Criteria andContractUnitNameGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACT_UNIT_NAME >=", value, "contractUnitName");
            return (Criteria) this;
        }

        public Criteria andContractUnitNameLessThan(String value) {
            addCriterion("CONTRACT_UNIT_NAME <", value, "contractUnitName");
            return (Criteria) this;
        }

        public Criteria andContractUnitNameLessThanOrEqualTo(String value) {
            addCriterion("CONTRACT_UNIT_NAME <=", value, "contractUnitName");
            return (Criteria) this;
        }

        public Criteria andContractUnitNameLike(String value) {
            addCriterion("CONTRACT_UNIT_NAME like", value, "contractUnitName");
            return (Criteria) this;
        }

        public Criteria andContractUnitNameNotLike(String value) {
            addCriterion("CONTRACT_UNIT_NAME not like", value, "contractUnitName");
            return (Criteria) this;
        }

        public Criteria andContractUnitNameIn(List<String> values) {
            addCriterion("CONTRACT_UNIT_NAME in", values, "contractUnitName");
            return (Criteria) this;
        }

        public Criteria andContractUnitNameNotIn(List<String> values) {
            addCriterion("CONTRACT_UNIT_NAME not in", values, "contractUnitName");
            return (Criteria) this;
        }

        public Criteria andContractUnitNameBetween(String value1, String value2) {
            addCriterion("CONTRACT_UNIT_NAME between", value1, value2, "contractUnitName");
            return (Criteria) this;
        }

        public Criteria andContractUnitNameNotBetween(String value1, String value2) {
            addCriterion("CONTRACT_UNIT_NAME not between", value1, value2, "contractUnitName");
            return (Criteria) this;
        }

        public Criteria andContractUnitIdIsNull() {
            addCriterion("CONTRACT_UNIT_ID is null");
            return (Criteria) this;
        }

        public Criteria andContractUnitIdIsNotNull() {
            addCriterion("CONTRACT_UNIT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andContractUnitIdEqualTo(String value) {
            addCriterion("CONTRACT_UNIT_ID =", value, "contractUnitId");
            return (Criteria) this;
        }

        public Criteria andContractUnitIdNotEqualTo(String value) {
            addCriterion("CONTRACT_UNIT_ID <>", value, "contractUnitId");
            return (Criteria) this;
        }

        public Criteria andContractUnitIdGreaterThan(String value) {
            addCriterion("CONTRACT_UNIT_ID >", value, "contractUnitId");
            return (Criteria) this;
        }

        public Criteria andContractUnitIdGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACT_UNIT_ID >=", value, "contractUnitId");
            return (Criteria) this;
        }

        public Criteria andContractUnitIdLessThan(String value) {
            addCriterion("CONTRACT_UNIT_ID <", value, "contractUnitId");
            return (Criteria) this;
        }

        public Criteria andContractUnitIdLessThanOrEqualTo(String value) {
            addCriterion("CONTRACT_UNIT_ID <=", value, "contractUnitId");
            return (Criteria) this;
        }

        public Criteria andContractUnitIdLike(String value) {
            addCriterion("CONTRACT_UNIT_ID like", value, "contractUnitId");
            return (Criteria) this;
        }

        public Criteria andContractUnitIdNotLike(String value) {
            addCriterion("CONTRACT_UNIT_ID not like", value, "contractUnitId");
            return (Criteria) this;
        }

        public Criteria andContractUnitIdIn(List<String> values) {
            addCriterion("CONTRACT_UNIT_ID in", values, "contractUnitId");
            return (Criteria) this;
        }

        public Criteria andContractUnitIdNotIn(List<String> values) {
            addCriterion("CONTRACT_UNIT_ID not in", values, "contractUnitId");
            return (Criteria) this;
        }

        public Criteria andContractUnitIdBetween(String value1, String value2) {
            addCriterion("CONTRACT_UNIT_ID between", value1, value2, "contractUnitId");
            return (Criteria) this;
        }

        public Criteria andContractUnitIdNotBetween(String value1, String value2) {
            addCriterion("CONTRACT_UNIT_ID not between", value1, value2, "contractUnitId");
            return (Criteria) this;
        }

        public Criteria andContractUnitCodeIsNull() {
            addCriterion("CONTRACT_UNIT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andContractUnitCodeIsNotNull() {
            addCriterion("CONTRACT_UNIT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andContractUnitCodeEqualTo(String value) {
            addCriterion("CONTRACT_UNIT_CODE =", value, "contractUnitCode");
            return (Criteria) this;
        }

        public Criteria andContractUnitCodeNotEqualTo(String value) {
            addCriterion("CONTRACT_UNIT_CODE <>", value, "contractUnitCode");
            return (Criteria) this;
        }

        public Criteria andContractUnitCodeGreaterThan(String value) {
            addCriterion("CONTRACT_UNIT_CODE >", value, "contractUnitCode");
            return (Criteria) this;
        }

        public Criteria andContractUnitCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACT_UNIT_CODE >=", value, "contractUnitCode");
            return (Criteria) this;
        }

        public Criteria andContractUnitCodeLessThan(String value) {
            addCriterion("CONTRACT_UNIT_CODE <", value, "contractUnitCode");
            return (Criteria) this;
        }

        public Criteria andContractUnitCodeLessThanOrEqualTo(String value) {
            addCriterion("CONTRACT_UNIT_CODE <=", value, "contractUnitCode");
            return (Criteria) this;
        }

        public Criteria andContractUnitCodeLike(String value) {
            addCriterion("CONTRACT_UNIT_CODE like", value, "contractUnitCode");
            return (Criteria) this;
        }

        public Criteria andContractUnitCodeNotLike(String value) {
            addCriterion("CONTRACT_UNIT_CODE not like", value, "contractUnitCode");
            return (Criteria) this;
        }

        public Criteria andContractUnitCodeIn(List<String> values) {
            addCriterion("CONTRACT_UNIT_CODE in", values, "contractUnitCode");
            return (Criteria) this;
        }

        public Criteria andContractUnitCodeNotIn(List<String> values) {
            addCriterion("CONTRACT_UNIT_CODE not in", values, "contractUnitCode");
            return (Criteria) this;
        }

        public Criteria andContractUnitCodeBetween(String value1, String value2) {
            addCriterion("CONTRACT_UNIT_CODE between", value1, value2, "contractUnitCode");
            return (Criteria) this;
        }

        public Criteria andContractUnitCodeNotBetween(String value1, String value2) {
            addCriterion("CONTRACT_UNIT_CODE not between", value1, value2, "contractUnitCode");
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