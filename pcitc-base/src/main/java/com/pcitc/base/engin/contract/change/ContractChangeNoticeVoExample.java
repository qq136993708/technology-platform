package com.pcitc.base.engin.contract.change;

import java.util.ArrayList;
import java.util.List;

public class ContractChangeNoticeVoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public ContractChangeNoticeVoExample() {
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

        public Criteria andChangeNoticeNoIsNull() {
            addCriterion("CHANGE_NOTICE_NO is null");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeNoIsNotNull() {
            addCriterion("CHANGE_NOTICE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeNoEqualTo(String value) {
            addCriterion("CHANGE_NOTICE_NO =", value, "changeNoticeNo");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeNoNotEqualTo(String value) {
            addCriterion("CHANGE_NOTICE_NO <>", value, "changeNoticeNo");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeNoGreaterThan(String value) {
            addCriterion("CHANGE_NOTICE_NO >", value, "changeNoticeNo");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeNoGreaterThanOrEqualTo(String value) {
            addCriterion("CHANGE_NOTICE_NO >=", value, "changeNoticeNo");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeNoLessThan(String value) {
            addCriterion("CHANGE_NOTICE_NO <", value, "changeNoticeNo");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeNoLessThanOrEqualTo(String value) {
            addCriterion("CHANGE_NOTICE_NO <=", value, "changeNoticeNo");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeNoLike(String value) {
            addCriterion("CHANGE_NOTICE_NO like", value, "changeNoticeNo");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeNoNotLike(String value) {
            addCriterion("CHANGE_NOTICE_NO not like", value, "changeNoticeNo");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeNoIn(List<String> values) {
            addCriterion("CHANGE_NOTICE_NO in", values, "changeNoticeNo");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeNoNotIn(List<String> values) {
            addCriterion("CHANGE_NOTICE_NO not in", values, "changeNoticeNo");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeNoBetween(String value1, String value2) {
            addCriterion("CHANGE_NOTICE_NO between", value1, value2, "changeNoticeNo");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeNoNotBetween(String value1, String value2) {
            addCriterion("CHANGE_NOTICE_NO not between", value1, value2, "changeNoticeNo");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeNameIsNull() {
            addCriterion("CHANGE_NOTICE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeNameIsNotNull() {
            addCriterion("CHANGE_NOTICE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeNameEqualTo(String value) {
            addCriterion("CHANGE_NOTICE_NAME =", value, "changeNoticeName");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeNameNotEqualTo(String value) {
            addCriterion("CHANGE_NOTICE_NAME <>", value, "changeNoticeName");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeNameGreaterThan(String value) {
            addCriterion("CHANGE_NOTICE_NAME >", value, "changeNoticeName");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeNameGreaterThanOrEqualTo(String value) {
            addCriterion("CHANGE_NOTICE_NAME >=", value, "changeNoticeName");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeNameLessThan(String value) {
            addCriterion("CHANGE_NOTICE_NAME <", value, "changeNoticeName");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeNameLessThanOrEqualTo(String value) {
            addCriterion("CHANGE_NOTICE_NAME <=", value, "changeNoticeName");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeNameLike(String value) {
            addCriterion("CHANGE_NOTICE_NAME like", value, "changeNoticeName");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeNameNotLike(String value) {
            addCriterion("CHANGE_NOTICE_NAME not like", value, "changeNoticeName");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeNameIn(List<String> values) {
            addCriterion("CHANGE_NOTICE_NAME in", values, "changeNoticeName");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeNameNotIn(List<String> values) {
            addCriterion("CHANGE_NOTICE_NAME not in", values, "changeNoticeName");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeNameBetween(String value1, String value2) {
            addCriterion("CHANGE_NOTICE_NAME between", value1, value2, "changeNoticeName");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeNameNotBetween(String value1, String value2) {
            addCriterion("CHANGE_NOTICE_NAME not between", value1, value2, "changeNoticeName");
            return (Criteria) this;
        }

        public Criteria andChangeUnitNameIsNull() {
            addCriterion("CHANGE_UNIT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andChangeUnitNameIsNotNull() {
            addCriterion("CHANGE_UNIT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andChangeUnitNameEqualTo(String value) {
            addCriterion("CHANGE_UNIT_NAME =", value, "changeUnitName");
            return (Criteria) this;
        }

        public Criteria andChangeUnitNameNotEqualTo(String value) {
            addCriterion("CHANGE_UNIT_NAME <>", value, "changeUnitName");
            return (Criteria) this;
        }

        public Criteria andChangeUnitNameGreaterThan(String value) {
            addCriterion("CHANGE_UNIT_NAME >", value, "changeUnitName");
            return (Criteria) this;
        }

        public Criteria andChangeUnitNameGreaterThanOrEqualTo(String value) {
            addCriterion("CHANGE_UNIT_NAME >=", value, "changeUnitName");
            return (Criteria) this;
        }

        public Criteria andChangeUnitNameLessThan(String value) {
            addCriterion("CHANGE_UNIT_NAME <", value, "changeUnitName");
            return (Criteria) this;
        }

        public Criteria andChangeUnitNameLessThanOrEqualTo(String value) {
            addCriterion("CHANGE_UNIT_NAME <=", value, "changeUnitName");
            return (Criteria) this;
        }

        public Criteria andChangeUnitNameLike(String value) {
            addCriterion("CHANGE_UNIT_NAME like", value, "changeUnitName");
            return (Criteria) this;
        }

        public Criteria andChangeUnitNameNotLike(String value) {
            addCriterion("CHANGE_UNIT_NAME not like", value, "changeUnitName");
            return (Criteria) this;
        }

        public Criteria andChangeUnitNameIn(List<String> values) {
            addCriterion("CHANGE_UNIT_NAME in", values, "changeUnitName");
            return (Criteria) this;
        }

        public Criteria andChangeUnitNameNotIn(List<String> values) {
            addCriterion("CHANGE_UNIT_NAME not in", values, "changeUnitName");
            return (Criteria) this;
        }

        public Criteria andChangeUnitNameBetween(String value1, String value2) {
            addCriterion("CHANGE_UNIT_NAME between", value1, value2, "changeUnitName");
            return (Criteria) this;
        }

        public Criteria andChangeUnitNameNotBetween(String value1, String value2) {
            addCriterion("CHANGE_UNIT_NAME not between", value1, value2, "changeUnitName");
            return (Criteria) this;
        }

        public Criteria andChangeUnitIdIsNull() {
            addCriterion("CHANGE_UNIT_ID is null");
            return (Criteria) this;
        }

        public Criteria andChangeUnitIdIsNotNull() {
            addCriterion("CHANGE_UNIT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andChangeUnitIdEqualTo(String value) {
            addCriterion("CHANGE_UNIT_ID =", value, "changeUnitId");
            return (Criteria) this;
        }

        public Criteria andChangeUnitIdNotEqualTo(String value) {
            addCriterion("CHANGE_UNIT_ID <>", value, "changeUnitId");
            return (Criteria) this;
        }

        public Criteria andChangeUnitIdGreaterThan(String value) {
            addCriterion("CHANGE_UNIT_ID >", value, "changeUnitId");
            return (Criteria) this;
        }

        public Criteria andChangeUnitIdGreaterThanOrEqualTo(String value) {
            addCriterion("CHANGE_UNIT_ID >=", value, "changeUnitId");
            return (Criteria) this;
        }

        public Criteria andChangeUnitIdLessThan(String value) {
            addCriterion("CHANGE_UNIT_ID <", value, "changeUnitId");
            return (Criteria) this;
        }

        public Criteria andChangeUnitIdLessThanOrEqualTo(String value) {
            addCriterion("CHANGE_UNIT_ID <=", value, "changeUnitId");
            return (Criteria) this;
        }

        public Criteria andChangeUnitIdLike(String value) {
            addCriterion("CHANGE_UNIT_ID like", value, "changeUnitId");
            return (Criteria) this;
        }

        public Criteria andChangeUnitIdNotLike(String value) {
            addCriterion("CHANGE_UNIT_ID not like", value, "changeUnitId");
            return (Criteria) this;
        }

        public Criteria andChangeUnitIdIn(List<String> values) {
            addCriterion("CHANGE_UNIT_ID in", values, "changeUnitId");
            return (Criteria) this;
        }

        public Criteria andChangeUnitIdNotIn(List<String> values) {
            addCriterion("CHANGE_UNIT_ID not in", values, "changeUnitId");
            return (Criteria) this;
        }

        public Criteria andChangeUnitIdBetween(String value1, String value2) {
            addCriterion("CHANGE_UNIT_ID between", value1, value2, "changeUnitId");
            return (Criteria) this;
        }

        public Criteria andChangeUnitIdNotBetween(String value1, String value2) {
            addCriterion("CHANGE_UNIT_ID not between", value1, value2, "changeUnitId");
            return (Criteria) this;
        }

        public Criteria andChangeTopicIsNull() {
            addCriterion("CHANGE_TOPIC is null");
            return (Criteria) this;
        }

        public Criteria andChangeTopicIsNotNull() {
            addCriterion("CHANGE_TOPIC is not null");
            return (Criteria) this;
        }

        public Criteria andChangeTopicEqualTo(String value) {
            addCriterion("CHANGE_TOPIC =", value, "changeTopic");
            return (Criteria) this;
        }

        public Criteria andChangeTopicNotEqualTo(String value) {
            addCriterion("CHANGE_TOPIC <>", value, "changeTopic");
            return (Criteria) this;
        }

        public Criteria andChangeTopicGreaterThan(String value) {
            addCriterion("CHANGE_TOPIC >", value, "changeTopic");
            return (Criteria) this;
        }

        public Criteria andChangeTopicGreaterThanOrEqualTo(String value) {
            addCriterion("CHANGE_TOPIC >=", value, "changeTopic");
            return (Criteria) this;
        }

        public Criteria andChangeTopicLessThan(String value) {
            addCriterion("CHANGE_TOPIC <", value, "changeTopic");
            return (Criteria) this;
        }

        public Criteria andChangeTopicLessThanOrEqualTo(String value) {
            addCriterion("CHANGE_TOPIC <=", value, "changeTopic");
            return (Criteria) this;
        }

        public Criteria andChangeTopicLike(String value) {
            addCriterion("CHANGE_TOPIC like", value, "changeTopic");
            return (Criteria) this;
        }

        public Criteria andChangeTopicNotLike(String value) {
            addCriterion("CHANGE_TOPIC not like", value, "changeTopic");
            return (Criteria) this;
        }

        public Criteria andChangeTopicIn(List<String> values) {
            addCriterion("CHANGE_TOPIC in", values, "changeTopic");
            return (Criteria) this;
        }

        public Criteria andChangeTopicNotIn(List<String> values) {
            addCriterion("CHANGE_TOPIC not in", values, "changeTopic");
            return (Criteria) this;
        }

        public Criteria andChangeTopicBetween(String value1, String value2) {
            addCriterion("CHANGE_TOPIC between", value1, value2, "changeTopic");
            return (Criteria) this;
        }

        public Criteria andChangeTopicNotBetween(String value1, String value2) {
            addCriterion("CHANGE_TOPIC not between", value1, value2, "changeTopic");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeEffectDateIsNull() {
            addCriterion("CHANGE_NOTICE_EFFECT_DATE is null");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeEffectDateIsNotNull() {
            addCriterion("CHANGE_NOTICE_EFFECT_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeEffectDateEqualTo(String value) {
            addCriterion("CHANGE_NOTICE_EFFECT_DATE =", value, "changeNoticeEffectDate");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeEffectDateNotEqualTo(String value) {
            addCriterion("CHANGE_NOTICE_EFFECT_DATE <>", value, "changeNoticeEffectDate");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeEffectDateGreaterThan(String value) {
            addCriterion("CHANGE_NOTICE_EFFECT_DATE >", value, "changeNoticeEffectDate");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeEffectDateGreaterThanOrEqualTo(String value) {
            addCriterion("CHANGE_NOTICE_EFFECT_DATE >=", value, "changeNoticeEffectDate");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeEffectDateLessThan(String value) {
            addCriterion("CHANGE_NOTICE_EFFECT_DATE <", value, "changeNoticeEffectDate");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeEffectDateLessThanOrEqualTo(String value) {
            addCriterion("CHANGE_NOTICE_EFFECT_DATE <=", value, "changeNoticeEffectDate");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeEffectDateLike(String value) {
            addCriterion("CHANGE_NOTICE_EFFECT_DATE like", value, "changeNoticeEffectDate");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeEffectDateNotLike(String value) {
            addCriterion("CHANGE_NOTICE_EFFECT_DATE not like", value, "changeNoticeEffectDate");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeEffectDateIn(List<String> values) {
            addCriterion("CHANGE_NOTICE_EFFECT_DATE in", values, "changeNoticeEffectDate");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeEffectDateNotIn(List<String> values) {
            addCriterion("CHANGE_NOTICE_EFFECT_DATE not in", values, "changeNoticeEffectDate");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeEffectDateBetween(String value1, String value2) {
            addCriterion("CHANGE_NOTICE_EFFECT_DATE between", value1, value2, "changeNoticeEffectDate");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeEffectDateNotBetween(String value1, String value2) {
            addCriterion("CHANGE_NOTICE_EFFECT_DATE not between", value1, value2, "changeNoticeEffectDate");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeSendDateIsNull() {
            addCriterion("CHANGE_NOTICE_SEND_DATE is null");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeSendDateIsNotNull() {
            addCriterion("CHANGE_NOTICE_SEND_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeSendDateEqualTo(String value) {
            addCriterion("CHANGE_NOTICE_SEND_DATE =", value, "changeNoticeSendDate");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeSendDateNotEqualTo(String value) {
            addCriterion("CHANGE_NOTICE_SEND_DATE <>", value, "changeNoticeSendDate");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeSendDateGreaterThan(String value) {
            addCriterion("CHANGE_NOTICE_SEND_DATE >", value, "changeNoticeSendDate");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeSendDateGreaterThanOrEqualTo(String value) {
            addCriterion("CHANGE_NOTICE_SEND_DATE >=", value, "changeNoticeSendDate");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeSendDateLessThan(String value) {
            addCriterion("CHANGE_NOTICE_SEND_DATE <", value, "changeNoticeSendDate");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeSendDateLessThanOrEqualTo(String value) {
            addCriterion("CHANGE_NOTICE_SEND_DATE <=", value, "changeNoticeSendDate");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeSendDateLike(String value) {
            addCriterion("CHANGE_NOTICE_SEND_DATE like", value, "changeNoticeSendDate");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeSendDateNotLike(String value) {
            addCriterion("CHANGE_NOTICE_SEND_DATE not like", value, "changeNoticeSendDate");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeSendDateIn(List<String> values) {
            addCriterion("CHANGE_NOTICE_SEND_DATE in", values, "changeNoticeSendDate");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeSendDateNotIn(List<String> values) {
            addCriterion("CHANGE_NOTICE_SEND_DATE not in", values, "changeNoticeSendDate");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeSendDateBetween(String value1, String value2) {
            addCriterion("CHANGE_NOTICE_SEND_DATE between", value1, value2, "changeNoticeSendDate");
            return (Criteria) this;
        }

        public Criteria andChangeNoticeSendDateNotBetween(String value1, String value2) {
            addCriterion("CHANGE_NOTICE_SEND_DATE not between", value1, value2, "changeNoticeSendDate");
            return (Criteria) this;
        }

        public Criteria andChangeReasonTypeIsNull() {
            addCriterion("CHANGE_REASON_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andChangeReasonTypeIsNotNull() {
            addCriterion("CHANGE_REASON_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andChangeReasonTypeEqualTo(String value) {
            addCriterion("CHANGE_REASON_TYPE =", value, "changeReasonType");
            return (Criteria) this;
        }

        public Criteria andChangeReasonTypeNotEqualTo(String value) {
            addCriterion("CHANGE_REASON_TYPE <>", value, "changeReasonType");
            return (Criteria) this;
        }

        public Criteria andChangeReasonTypeGreaterThan(String value) {
            addCriterion("CHANGE_REASON_TYPE >", value, "changeReasonType");
            return (Criteria) this;
        }

        public Criteria andChangeReasonTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CHANGE_REASON_TYPE >=", value, "changeReasonType");
            return (Criteria) this;
        }

        public Criteria andChangeReasonTypeLessThan(String value) {
            addCriterion("CHANGE_REASON_TYPE <", value, "changeReasonType");
            return (Criteria) this;
        }

        public Criteria andChangeReasonTypeLessThanOrEqualTo(String value) {
            addCriterion("CHANGE_REASON_TYPE <=", value, "changeReasonType");
            return (Criteria) this;
        }

        public Criteria andChangeReasonTypeLike(String value) {
            addCriterion("CHANGE_REASON_TYPE like", value, "changeReasonType");
            return (Criteria) this;
        }

        public Criteria andChangeReasonTypeNotLike(String value) {
            addCriterion("CHANGE_REASON_TYPE not like", value, "changeReasonType");
            return (Criteria) this;
        }

        public Criteria andChangeReasonTypeIn(List<String> values) {
            addCriterion("CHANGE_REASON_TYPE in", values, "changeReasonType");
            return (Criteria) this;
        }

        public Criteria andChangeReasonTypeNotIn(List<String> values) {
            addCriterion("CHANGE_REASON_TYPE not in", values, "changeReasonType");
            return (Criteria) this;
        }

        public Criteria andChangeReasonTypeBetween(String value1, String value2) {
            addCriterion("CHANGE_REASON_TYPE between", value1, value2, "changeReasonType");
            return (Criteria) this;
        }

        public Criteria andChangeReasonTypeNotBetween(String value1, String value2) {
            addCriterion("CHANGE_REASON_TYPE not between", value1, value2, "changeReasonType");
            return (Criteria) this;
        }

        public Criteria andChangePriceTypeIsNull() {
            addCriterion("CHANGE_PRICE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andChangePriceTypeIsNotNull() {
            addCriterion("CHANGE_PRICE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andChangePriceTypeEqualTo(String value) {
            addCriterion("CHANGE_PRICE_TYPE =", value, "changePriceType");
            return (Criteria) this;
        }

        public Criteria andChangePriceTypeNotEqualTo(String value) {
            addCriterion("CHANGE_PRICE_TYPE <>", value, "changePriceType");
            return (Criteria) this;
        }

        public Criteria andChangePriceTypeGreaterThan(String value) {
            addCriterion("CHANGE_PRICE_TYPE >", value, "changePriceType");
            return (Criteria) this;
        }

        public Criteria andChangePriceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CHANGE_PRICE_TYPE >=", value, "changePriceType");
            return (Criteria) this;
        }

        public Criteria andChangePriceTypeLessThan(String value) {
            addCriterion("CHANGE_PRICE_TYPE <", value, "changePriceType");
            return (Criteria) this;
        }

        public Criteria andChangePriceTypeLessThanOrEqualTo(String value) {
            addCriterion("CHANGE_PRICE_TYPE <=", value, "changePriceType");
            return (Criteria) this;
        }

        public Criteria andChangePriceTypeLike(String value) {
            addCriterion("CHANGE_PRICE_TYPE like", value, "changePriceType");
            return (Criteria) this;
        }

        public Criteria andChangePriceTypeNotLike(String value) {
            addCriterion("CHANGE_PRICE_TYPE not like", value, "changePriceType");
            return (Criteria) this;
        }

        public Criteria andChangePriceTypeIn(List<String> values) {
            addCriterion("CHANGE_PRICE_TYPE in", values, "changePriceType");
            return (Criteria) this;
        }

        public Criteria andChangePriceTypeNotIn(List<String> values) {
            addCriterion("CHANGE_PRICE_TYPE not in", values, "changePriceType");
            return (Criteria) this;
        }

        public Criteria andChangePriceTypeBetween(String value1, String value2) {
            addCriterion("CHANGE_PRICE_TYPE between", value1, value2, "changePriceType");
            return (Criteria) this;
        }

        public Criteria andChangePriceTypeNotBetween(String value1, String value2) {
            addCriterion("CHANGE_PRICE_TYPE not between", value1, value2, "changePriceType");
            return (Criteria) this;
        }

        public Criteria andChangeContentIsNull() {
            addCriterion("CHANGE_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andChangeContentIsNotNull() {
            addCriterion("CHANGE_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andChangeContentEqualTo(String value) {
            addCriterion("CHANGE_CONTENT =", value, "changeContent");
            return (Criteria) this;
        }

        public Criteria andChangeContentNotEqualTo(String value) {
            addCriterion("CHANGE_CONTENT <>", value, "changeContent");
            return (Criteria) this;
        }

        public Criteria andChangeContentGreaterThan(String value) {
            addCriterion("CHANGE_CONTENT >", value, "changeContent");
            return (Criteria) this;
        }

        public Criteria andChangeContentGreaterThanOrEqualTo(String value) {
            addCriterion("CHANGE_CONTENT >=", value, "changeContent");
            return (Criteria) this;
        }

        public Criteria andChangeContentLessThan(String value) {
            addCriterion("CHANGE_CONTENT <", value, "changeContent");
            return (Criteria) this;
        }

        public Criteria andChangeContentLessThanOrEqualTo(String value) {
            addCriterion("CHANGE_CONTENT <=", value, "changeContent");
            return (Criteria) this;
        }

        public Criteria andChangeContentLike(String value) {
            addCriterion("CHANGE_CONTENT like", value, "changeContent");
            return (Criteria) this;
        }

        public Criteria andChangeContentNotLike(String value) {
            addCriterion("CHANGE_CONTENT not like", value, "changeContent");
            return (Criteria) this;
        }

        public Criteria andChangeContentIn(List<String> values) {
            addCriterion("CHANGE_CONTENT in", values, "changeContent");
            return (Criteria) this;
        }

        public Criteria andChangeContentNotIn(List<String> values) {
            addCriterion("CHANGE_CONTENT not in", values, "changeContent");
            return (Criteria) this;
        }

        public Criteria andChangeContentBetween(String value1, String value2) {
            addCriterion("CHANGE_CONTENT between", value1, value2, "changeContent");
            return (Criteria) this;
        }

        public Criteria andChangeContentNotBetween(String value1, String value2) {
            addCriterion("CHANGE_CONTENT not between", value1, value2, "changeContent");
            return (Criteria) this;
        }

        public Criteria andChangeCauseIsNull() {
            addCriterion("CHANGE_CAUSE is null");
            return (Criteria) this;
        }

        public Criteria andChangeCauseIsNotNull() {
            addCriterion("CHANGE_CAUSE is not null");
            return (Criteria) this;
        }

        public Criteria andChangeCauseEqualTo(String value) {
            addCriterion("CHANGE_CAUSE =", value, "changeCause");
            return (Criteria) this;
        }

        public Criteria andChangeCauseNotEqualTo(String value) {
            addCriterion("CHANGE_CAUSE <>", value, "changeCause");
            return (Criteria) this;
        }

        public Criteria andChangeCauseGreaterThan(String value) {
            addCriterion("CHANGE_CAUSE >", value, "changeCause");
            return (Criteria) this;
        }

        public Criteria andChangeCauseGreaterThanOrEqualTo(String value) {
            addCriterion("CHANGE_CAUSE >=", value, "changeCause");
            return (Criteria) this;
        }

        public Criteria andChangeCauseLessThan(String value) {
            addCriterion("CHANGE_CAUSE <", value, "changeCause");
            return (Criteria) this;
        }

        public Criteria andChangeCauseLessThanOrEqualTo(String value) {
            addCriterion("CHANGE_CAUSE <=", value, "changeCause");
            return (Criteria) this;
        }

        public Criteria andChangeCauseLike(String value) {
            addCriterion("CHANGE_CAUSE like", value, "changeCause");
            return (Criteria) this;
        }

        public Criteria andChangeCauseNotLike(String value) {
            addCriterion("CHANGE_CAUSE not like", value, "changeCause");
            return (Criteria) this;
        }

        public Criteria andChangeCauseIn(List<String> values) {
            addCriterion("CHANGE_CAUSE in", values, "changeCause");
            return (Criteria) this;
        }

        public Criteria andChangeCauseNotIn(List<String> values) {
            addCriterion("CHANGE_CAUSE not in", values, "changeCause");
            return (Criteria) this;
        }

        public Criteria andChangeCauseBetween(String value1, String value2) {
            addCriterion("CHANGE_CAUSE between", value1, value2, "changeCause");
            return (Criteria) this;
        }

        public Criteria andChangeCauseNotBetween(String value1, String value2) {
            addCriterion("CHANGE_CAUSE not between", value1, value2, "changeCause");
            return (Criteria) this;
        }

        public Criteria andChangeTypeIsNull() {
            addCriterion("CHANGE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andChangeTypeIsNotNull() {
            addCriterion("CHANGE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andChangeTypeEqualTo(String value) {
            addCriterion("CHANGE_TYPE =", value, "changeType");
            return (Criteria) this;
        }

        public Criteria andChangeTypeNotEqualTo(String value) {
            addCriterion("CHANGE_TYPE <>", value, "changeType");
            return (Criteria) this;
        }

        public Criteria andChangeTypeGreaterThan(String value) {
            addCriterion("CHANGE_TYPE >", value, "changeType");
            return (Criteria) this;
        }

        public Criteria andChangeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CHANGE_TYPE >=", value, "changeType");
            return (Criteria) this;
        }

        public Criteria andChangeTypeLessThan(String value) {
            addCriterion("CHANGE_TYPE <", value, "changeType");
            return (Criteria) this;
        }

        public Criteria andChangeTypeLessThanOrEqualTo(String value) {
            addCriterion("CHANGE_TYPE <=", value, "changeType");
            return (Criteria) this;
        }

        public Criteria andChangeTypeLike(String value) {
            addCriterion("CHANGE_TYPE like", value, "changeType");
            return (Criteria) this;
        }

        public Criteria andChangeTypeNotLike(String value) {
            addCriterion("CHANGE_TYPE not like", value, "changeType");
            return (Criteria) this;
        }

        public Criteria andChangeTypeIn(List<String> values) {
            addCriterion("CHANGE_TYPE in", values, "changeType");
            return (Criteria) this;
        }

        public Criteria andChangeTypeNotIn(List<String> values) {
            addCriterion("CHANGE_TYPE not in", values, "changeType");
            return (Criteria) this;
        }

        public Criteria andChangeTypeBetween(String value1, String value2) {
            addCriterion("CHANGE_TYPE between", value1, value2, "changeType");
            return (Criteria) this;
        }

        public Criteria andChangeTypeNotBetween(String value1, String value2) {
            addCriterion("CHANGE_TYPE not between", value1, value2, "changeType");
            return (Criteria) this;
        }

        public Criteria andRedactUserNameIsNull() {
            addCriterion("REDACT_USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andRedactUserNameIsNotNull() {
            addCriterion("REDACT_USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andRedactUserNameEqualTo(String value) {
            addCriterion("REDACT_USER_NAME =", value, "redactUserName");
            return (Criteria) this;
        }

        public Criteria andRedactUserNameNotEqualTo(String value) {
            addCriterion("REDACT_USER_NAME <>", value, "redactUserName");
            return (Criteria) this;
        }

        public Criteria andRedactUserNameGreaterThan(String value) {
            addCriterion("REDACT_USER_NAME >", value, "redactUserName");
            return (Criteria) this;
        }

        public Criteria andRedactUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("REDACT_USER_NAME >=", value, "redactUserName");
            return (Criteria) this;
        }

        public Criteria andRedactUserNameLessThan(String value) {
            addCriterion("REDACT_USER_NAME <", value, "redactUserName");
            return (Criteria) this;
        }

        public Criteria andRedactUserNameLessThanOrEqualTo(String value) {
            addCriterion("REDACT_USER_NAME <=", value, "redactUserName");
            return (Criteria) this;
        }

        public Criteria andRedactUserNameLike(String value) {
            addCriterion("REDACT_USER_NAME like", value, "redactUserName");
            return (Criteria) this;
        }

        public Criteria andRedactUserNameNotLike(String value) {
            addCriterion("REDACT_USER_NAME not like", value, "redactUserName");
            return (Criteria) this;
        }

        public Criteria andRedactUserNameIn(List<String> values) {
            addCriterion("REDACT_USER_NAME in", values, "redactUserName");
            return (Criteria) this;
        }

        public Criteria andRedactUserNameNotIn(List<String> values) {
            addCriterion("REDACT_USER_NAME not in", values, "redactUserName");
            return (Criteria) this;
        }

        public Criteria andRedactUserNameBetween(String value1, String value2) {
            addCriterion("REDACT_USER_NAME between", value1, value2, "redactUserName");
            return (Criteria) this;
        }

        public Criteria andRedactUserNameNotBetween(String value1, String value2) {
            addCriterion("REDACT_USER_NAME not between", value1, value2, "redactUserName");
            return (Criteria) this;
        }

        public Criteria andRedactUserIdIsNull() {
            addCriterion("REDACT_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andRedactUserIdIsNotNull() {
            addCriterion("REDACT_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRedactUserIdEqualTo(String value) {
            addCriterion("REDACT_USER_ID =", value, "redactUserId");
            return (Criteria) this;
        }

        public Criteria andRedactUserIdNotEqualTo(String value) {
            addCriterion("REDACT_USER_ID <>", value, "redactUserId");
            return (Criteria) this;
        }

        public Criteria andRedactUserIdGreaterThan(String value) {
            addCriterion("REDACT_USER_ID >", value, "redactUserId");
            return (Criteria) this;
        }

        public Criteria andRedactUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("REDACT_USER_ID >=", value, "redactUserId");
            return (Criteria) this;
        }

        public Criteria andRedactUserIdLessThan(String value) {
            addCriterion("REDACT_USER_ID <", value, "redactUserId");
            return (Criteria) this;
        }

        public Criteria andRedactUserIdLessThanOrEqualTo(String value) {
            addCriterion("REDACT_USER_ID <=", value, "redactUserId");
            return (Criteria) this;
        }

        public Criteria andRedactUserIdLike(String value) {
            addCriterion("REDACT_USER_ID like", value, "redactUserId");
            return (Criteria) this;
        }

        public Criteria andRedactUserIdNotLike(String value) {
            addCriterion("REDACT_USER_ID not like", value, "redactUserId");
            return (Criteria) this;
        }

        public Criteria andRedactUserIdIn(List<String> values) {
            addCriterion("REDACT_USER_ID in", values, "redactUserId");
            return (Criteria) this;
        }

        public Criteria andRedactUserIdNotIn(List<String> values) {
            addCriterion("REDACT_USER_ID not in", values, "redactUserId");
            return (Criteria) this;
        }

        public Criteria andRedactUserIdBetween(String value1, String value2) {
            addCriterion("REDACT_USER_ID between", value1, value2, "redactUserId");
            return (Criteria) this;
        }

        public Criteria andRedactUserIdNotBetween(String value1, String value2) {
            addCriterion("REDACT_USER_ID not between", value1, value2, "redactUserId");
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