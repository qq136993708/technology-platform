package com.pcitc.base.engin.hse.contractor.vo;

import java.util.ArrayList;
import java.util.List;

public class ContractorFineVoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public ContractorFineVoExample() {
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

        public Criteria andContractorFineBillNameIsNull() {
            addCriterion("CONTRACTOR_FINE_BILL_NAME is null");
            return (Criteria) this;
        }

        public Criteria andContractorFineBillNameIsNotNull() {
            addCriterion("CONTRACTOR_FINE_BILL_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andContractorFineBillNameEqualTo(String value) {
            addCriterion("CONTRACTOR_FINE_BILL_NAME =", value, "contractorFineBillName");
            return (Criteria) this;
        }

        public Criteria andContractorFineBillNameNotEqualTo(String value) {
            addCriterion("CONTRACTOR_FINE_BILL_NAME <>", value, "contractorFineBillName");
            return (Criteria) this;
        }

        public Criteria andContractorFineBillNameGreaterThan(String value) {
            addCriterion("CONTRACTOR_FINE_BILL_NAME >", value, "contractorFineBillName");
            return (Criteria) this;
        }

        public Criteria andContractorFineBillNameGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACTOR_FINE_BILL_NAME >=", value, "contractorFineBillName");
            return (Criteria) this;
        }

        public Criteria andContractorFineBillNameLessThan(String value) {
            addCriterion("CONTRACTOR_FINE_BILL_NAME <", value, "contractorFineBillName");
            return (Criteria) this;
        }

        public Criteria andContractorFineBillNameLessThanOrEqualTo(String value) {
            addCriterion("CONTRACTOR_FINE_BILL_NAME <=", value, "contractorFineBillName");
            return (Criteria) this;
        }

        public Criteria andContractorFineBillNameLike(String value) {
            addCriterion("CONTRACTOR_FINE_BILL_NAME like", value, "contractorFineBillName");
            return (Criteria) this;
        }

        public Criteria andContractorFineBillNameNotLike(String value) {
            addCriterion("CONTRACTOR_FINE_BILL_NAME not like", value, "contractorFineBillName");
            return (Criteria) this;
        }

        public Criteria andContractorFineBillNameIn(List<String> values) {
            addCriterion("CONTRACTOR_FINE_BILL_NAME in", values, "contractorFineBillName");
            return (Criteria) this;
        }

        public Criteria andContractorFineBillNameNotIn(List<String> values) {
            addCriterion("CONTRACTOR_FINE_BILL_NAME not in", values, "contractorFineBillName");
            return (Criteria) this;
        }

        public Criteria andContractorFineBillNameBetween(String value1, String value2) {
            addCriterion("CONTRACTOR_FINE_BILL_NAME between", value1, value2, "contractorFineBillName");
            return (Criteria) this;
        }

        public Criteria andContractorFineBillNameNotBetween(String value1, String value2) {
            addCriterion("CONTRACTOR_FINE_BILL_NAME not between", value1, value2, "contractorFineBillName");
            return (Criteria) this;
        }

        public Criteria andContractorFineBillCodeIsNull() {
            addCriterion("CONTRACTOR_FINE_BILL_CODE is null");
            return (Criteria) this;
        }

        public Criteria andContractorFineBillCodeIsNotNull() {
            addCriterion("CONTRACTOR_FINE_BILL_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andContractorFineBillCodeEqualTo(String value) {
            addCriterion("CONTRACTOR_FINE_BILL_CODE =", value, "contractorFineBillCode");
            return (Criteria) this;
        }

        public Criteria andContractorFineBillCodeNotEqualTo(String value) {
            addCriterion("CONTRACTOR_FINE_BILL_CODE <>", value, "contractorFineBillCode");
            return (Criteria) this;
        }

        public Criteria andContractorFineBillCodeGreaterThan(String value) {
            addCriterion("CONTRACTOR_FINE_BILL_CODE >", value, "contractorFineBillCode");
            return (Criteria) this;
        }

        public Criteria andContractorFineBillCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACTOR_FINE_BILL_CODE >=", value, "contractorFineBillCode");
            return (Criteria) this;
        }

        public Criteria andContractorFineBillCodeLessThan(String value) {
            addCriterion("CONTRACTOR_FINE_BILL_CODE <", value, "contractorFineBillCode");
            return (Criteria) this;
        }

        public Criteria andContractorFineBillCodeLessThanOrEqualTo(String value) {
            addCriterion("CONTRACTOR_FINE_BILL_CODE <=", value, "contractorFineBillCode");
            return (Criteria) this;
        }

        public Criteria andContractorFineBillCodeLike(String value) {
            addCriterion("CONTRACTOR_FINE_BILL_CODE like", value, "contractorFineBillCode");
            return (Criteria) this;
        }

        public Criteria andContractorFineBillCodeNotLike(String value) {
            addCriterion("CONTRACTOR_FINE_BILL_CODE not like", value, "contractorFineBillCode");
            return (Criteria) this;
        }

        public Criteria andContractorFineBillCodeIn(List<String> values) {
            addCriterion("CONTRACTOR_FINE_BILL_CODE in", values, "contractorFineBillCode");
            return (Criteria) this;
        }

        public Criteria andContractorFineBillCodeNotIn(List<String> values) {
            addCriterion("CONTRACTOR_FINE_BILL_CODE not in", values, "contractorFineBillCode");
            return (Criteria) this;
        }

        public Criteria andContractorFineBillCodeBetween(String value1, String value2) {
            addCriterion("CONTRACTOR_FINE_BILL_CODE between", value1, value2, "contractorFineBillCode");
            return (Criteria) this;
        }

        public Criteria andContractorFineBillCodeNotBetween(String value1, String value2) {
            addCriterion("CONTRACTOR_FINE_BILL_CODE not between", value1, value2, "contractorFineBillCode");
            return (Criteria) this;
        }

        public Criteria andContractorFineCauseIsNull() {
            addCriterion("CONTRACTOR_FINE_CAUSE is null");
            return (Criteria) this;
        }

        public Criteria andContractorFineCauseIsNotNull() {
            addCriterion("CONTRACTOR_FINE_CAUSE is not null");
            return (Criteria) this;
        }

        public Criteria andContractorFineCauseEqualTo(String value) {
            addCriterion("CONTRACTOR_FINE_CAUSE =", value, "contractorFineCause");
            return (Criteria) this;
        }

        public Criteria andContractorFineCauseNotEqualTo(String value) {
            addCriterion("CONTRACTOR_FINE_CAUSE <>", value, "contractorFineCause");
            return (Criteria) this;
        }

        public Criteria andContractorFineCauseGreaterThan(String value) {
            addCriterion("CONTRACTOR_FINE_CAUSE >", value, "contractorFineCause");
            return (Criteria) this;
        }

        public Criteria andContractorFineCauseGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACTOR_FINE_CAUSE >=", value, "contractorFineCause");
            return (Criteria) this;
        }

        public Criteria andContractorFineCauseLessThan(String value) {
            addCriterion("CONTRACTOR_FINE_CAUSE <", value, "contractorFineCause");
            return (Criteria) this;
        }

        public Criteria andContractorFineCauseLessThanOrEqualTo(String value) {
            addCriterion("CONTRACTOR_FINE_CAUSE <=", value, "contractorFineCause");
            return (Criteria) this;
        }

        public Criteria andContractorFineCauseLike(String value) {
            addCriterion("CONTRACTOR_FINE_CAUSE like", value, "contractorFineCause");
            return (Criteria) this;
        }

        public Criteria andContractorFineCauseNotLike(String value) {
            addCriterion("CONTRACTOR_FINE_CAUSE not like", value, "contractorFineCause");
            return (Criteria) this;
        }

        public Criteria andContractorFineCauseIn(List<String> values) {
            addCriterion("CONTRACTOR_FINE_CAUSE in", values, "contractorFineCause");
            return (Criteria) this;
        }

        public Criteria andContractorFineCauseNotIn(List<String> values) {
            addCriterion("CONTRACTOR_FINE_CAUSE not in", values, "contractorFineCause");
            return (Criteria) this;
        }

        public Criteria andContractorFineCauseBetween(String value1, String value2) {
            addCriterion("CONTRACTOR_FINE_CAUSE between", value1, value2, "contractorFineCause");
            return (Criteria) this;
        }

        public Criteria andContractorFineCauseNotBetween(String value1, String value2) {
            addCriterion("CONTRACTOR_FINE_CAUSE not between", value1, value2, "contractorFineCause");
            return (Criteria) this;
        }

        public Criteria andContractorTypeIsNull() {
            addCriterion("CONTRACTOR_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andContractorTypeIsNotNull() {
            addCriterion("CONTRACTOR_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andContractorTypeEqualTo(String value) {
            addCriterion("CONTRACTOR_TYPE =", value, "contractorType");
            return (Criteria) this;
        }

        public Criteria andContractorTypeNotEqualTo(String value) {
            addCriterion("CONTRACTOR_TYPE <>", value, "contractorType");
            return (Criteria) this;
        }

        public Criteria andContractorTypeGreaterThan(String value) {
            addCriterion("CONTRACTOR_TYPE >", value, "contractorType");
            return (Criteria) this;
        }

        public Criteria andContractorTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACTOR_TYPE >=", value, "contractorType");
            return (Criteria) this;
        }

        public Criteria andContractorTypeLessThan(String value) {
            addCriterion("CONTRACTOR_TYPE <", value, "contractorType");
            return (Criteria) this;
        }

        public Criteria andContractorTypeLessThanOrEqualTo(String value) {
            addCriterion("CONTRACTOR_TYPE <=", value, "contractorType");
            return (Criteria) this;
        }

        public Criteria andContractorTypeLike(String value) {
            addCriterion("CONTRACTOR_TYPE like", value, "contractorType");
            return (Criteria) this;
        }

        public Criteria andContractorTypeNotLike(String value) {
            addCriterion("CONTRACTOR_TYPE not like", value, "contractorType");
            return (Criteria) this;
        }

        public Criteria andContractorTypeIn(List<String> values) {
            addCriterion("CONTRACTOR_TYPE in", values, "contractorType");
            return (Criteria) this;
        }

        public Criteria andContractorTypeNotIn(List<String> values) {
            addCriterion("CONTRACTOR_TYPE not in", values, "contractorType");
            return (Criteria) this;
        }

        public Criteria andContractorTypeBetween(String value1, String value2) {
            addCriterion("CONTRACTOR_TYPE between", value1, value2, "contractorType");
            return (Criteria) this;
        }

        public Criteria andContractorTypeNotBetween(String value1, String value2) {
            addCriterion("CONTRACTOR_TYPE not between", value1, value2, "contractorType");
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

        public Criteria andContractorFineUnitNameIsNull() {
            addCriterion("CONTRACTOR_FINE_UNIT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andContractorFineUnitNameIsNotNull() {
            addCriterion("CONTRACTOR_FINE_UNIT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andContractorFineUnitNameEqualTo(String value) {
            addCriterion("CONTRACTOR_FINE_UNIT_NAME =", value, "contractorFineUnitName");
            return (Criteria) this;
        }

        public Criteria andContractorFineUnitNameNotEqualTo(String value) {
            addCriterion("CONTRACTOR_FINE_UNIT_NAME <>", value, "contractorFineUnitName");
            return (Criteria) this;
        }

        public Criteria andContractorFineUnitNameGreaterThan(String value) {
            addCriterion("CONTRACTOR_FINE_UNIT_NAME >", value, "contractorFineUnitName");
            return (Criteria) this;
        }

        public Criteria andContractorFineUnitNameGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACTOR_FINE_UNIT_NAME >=", value, "contractorFineUnitName");
            return (Criteria) this;
        }

        public Criteria andContractorFineUnitNameLessThan(String value) {
            addCriterion("CONTRACTOR_FINE_UNIT_NAME <", value, "contractorFineUnitName");
            return (Criteria) this;
        }

        public Criteria andContractorFineUnitNameLessThanOrEqualTo(String value) {
            addCriterion("CONTRACTOR_FINE_UNIT_NAME <=", value, "contractorFineUnitName");
            return (Criteria) this;
        }

        public Criteria andContractorFineUnitNameLike(String value) {
            addCriterion("CONTRACTOR_FINE_UNIT_NAME like", value, "contractorFineUnitName");
            return (Criteria) this;
        }

        public Criteria andContractorFineUnitNameNotLike(String value) {
            addCriterion("CONTRACTOR_FINE_UNIT_NAME not like", value, "contractorFineUnitName");
            return (Criteria) this;
        }

        public Criteria andContractorFineUnitNameIn(List<String> values) {
            addCriterion("CONTRACTOR_FINE_UNIT_NAME in", values, "contractorFineUnitName");
            return (Criteria) this;
        }

        public Criteria andContractorFineUnitNameNotIn(List<String> values) {
            addCriterion("CONTRACTOR_FINE_UNIT_NAME not in", values, "contractorFineUnitName");
            return (Criteria) this;
        }

        public Criteria andContractorFineUnitNameBetween(String value1, String value2) {
            addCriterion("CONTRACTOR_FINE_UNIT_NAME between", value1, value2, "contractorFineUnitName");
            return (Criteria) this;
        }

        public Criteria andContractorFineUnitNameNotBetween(String value1, String value2) {
            addCriterion("CONTRACTOR_FINE_UNIT_NAME not between", value1, value2, "contractorFineUnitName");
            return (Criteria) this;
        }

        public Criteria andContractorFineUnitCodeIsNull() {
            addCriterion("CONTRACTOR_FINE_UNIT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andContractorFineUnitCodeIsNotNull() {
            addCriterion("CONTRACTOR_FINE_UNIT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andContractorFineUnitCodeEqualTo(String value) {
            addCriterion("CONTRACTOR_FINE_UNIT_CODE =", value, "contractorFineUnitCode");
            return (Criteria) this;
        }

        public Criteria andContractorFineUnitCodeNotEqualTo(String value) {
            addCriterion("CONTRACTOR_FINE_UNIT_CODE <>", value, "contractorFineUnitCode");
            return (Criteria) this;
        }

        public Criteria andContractorFineUnitCodeGreaterThan(String value) {
            addCriterion("CONTRACTOR_FINE_UNIT_CODE >", value, "contractorFineUnitCode");
            return (Criteria) this;
        }

        public Criteria andContractorFineUnitCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACTOR_FINE_UNIT_CODE >=", value, "contractorFineUnitCode");
            return (Criteria) this;
        }

        public Criteria andContractorFineUnitCodeLessThan(String value) {
            addCriterion("CONTRACTOR_FINE_UNIT_CODE <", value, "contractorFineUnitCode");
            return (Criteria) this;
        }

        public Criteria andContractorFineUnitCodeLessThanOrEqualTo(String value) {
            addCriterion("CONTRACTOR_FINE_UNIT_CODE <=", value, "contractorFineUnitCode");
            return (Criteria) this;
        }

        public Criteria andContractorFineUnitCodeLike(String value) {
            addCriterion("CONTRACTOR_FINE_UNIT_CODE like", value, "contractorFineUnitCode");
            return (Criteria) this;
        }

        public Criteria andContractorFineUnitCodeNotLike(String value) {
            addCriterion("CONTRACTOR_FINE_UNIT_CODE not like", value, "contractorFineUnitCode");
            return (Criteria) this;
        }

        public Criteria andContractorFineUnitCodeIn(List<String> values) {
            addCriterion("CONTRACTOR_FINE_UNIT_CODE in", values, "contractorFineUnitCode");
            return (Criteria) this;
        }

        public Criteria andContractorFineUnitCodeNotIn(List<String> values) {
            addCriterion("CONTRACTOR_FINE_UNIT_CODE not in", values, "contractorFineUnitCode");
            return (Criteria) this;
        }

        public Criteria andContractorFineUnitCodeBetween(String value1, String value2) {
            addCriterion("CONTRACTOR_FINE_UNIT_CODE between", value1, value2, "contractorFineUnitCode");
            return (Criteria) this;
        }

        public Criteria andContractorFineUnitCodeNotBetween(String value1, String value2) {
            addCriterion("CONTRACTOR_FINE_UNIT_CODE not between", value1, value2, "contractorFineUnitCode");
            return (Criteria) this;
        }

        public Criteria andContractorFineGistIsNull() {
            addCriterion("CONTRACTOR_FINE_GIST is null");
            return (Criteria) this;
        }

        public Criteria andContractorFineGistIsNotNull() {
            addCriterion("CONTRACTOR_FINE_GIST is not null");
            return (Criteria) this;
        }

        public Criteria andContractorFineGistEqualTo(String value) {
            addCriterion("CONTRACTOR_FINE_GIST =", value, "contractorFineGist");
            return (Criteria) this;
        }

        public Criteria andContractorFineGistNotEqualTo(String value) {
            addCriterion("CONTRACTOR_FINE_GIST <>", value, "contractorFineGist");
            return (Criteria) this;
        }

        public Criteria andContractorFineGistGreaterThan(String value) {
            addCriterion("CONTRACTOR_FINE_GIST >", value, "contractorFineGist");
            return (Criteria) this;
        }

        public Criteria andContractorFineGistGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACTOR_FINE_GIST >=", value, "contractorFineGist");
            return (Criteria) this;
        }

        public Criteria andContractorFineGistLessThan(String value) {
            addCriterion("CONTRACTOR_FINE_GIST <", value, "contractorFineGist");
            return (Criteria) this;
        }

        public Criteria andContractorFineGistLessThanOrEqualTo(String value) {
            addCriterion("CONTRACTOR_FINE_GIST <=", value, "contractorFineGist");
            return (Criteria) this;
        }

        public Criteria andContractorFineGistLike(String value) {
            addCriterion("CONTRACTOR_FINE_GIST like", value, "contractorFineGist");
            return (Criteria) this;
        }

        public Criteria andContractorFineGistNotLike(String value) {
            addCriterion("CONTRACTOR_FINE_GIST not like", value, "contractorFineGist");
            return (Criteria) this;
        }

        public Criteria andContractorFineGistIn(List<String> values) {
            addCriterion("CONTRACTOR_FINE_GIST in", values, "contractorFineGist");
            return (Criteria) this;
        }

        public Criteria andContractorFineGistNotIn(List<String> values) {
            addCriterion("CONTRACTOR_FINE_GIST not in", values, "contractorFineGist");
            return (Criteria) this;
        }

        public Criteria andContractorFineGistBetween(String value1, String value2) {
            addCriterion("CONTRACTOR_FINE_GIST between", value1, value2, "contractorFineGist");
            return (Criteria) this;
        }

        public Criteria andContractorFineGistNotBetween(String value1, String value2) {
            addCriterion("CONTRACTOR_FINE_GIST not between", value1, value2, "contractorFineGist");
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

        public Criteria andRedactDateIsNull() {
            addCriterion("REDACT_DATE is null");
            return (Criteria) this;
        }

        public Criteria andRedactDateIsNotNull() {
            addCriterion("REDACT_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andRedactDateEqualTo(String value) {
            addCriterion("REDACT_DATE =", value, "redactDate");
            return (Criteria) this;
        }

        public Criteria andRedactDateNotEqualTo(String value) {
            addCriterion("REDACT_DATE <>", value, "redactDate");
            return (Criteria) this;
        }

        public Criteria andRedactDateGreaterThan(String value) {
            addCriterion("REDACT_DATE >", value, "redactDate");
            return (Criteria) this;
        }

        public Criteria andRedactDateGreaterThanOrEqualTo(String value) {
            addCriterion("REDACT_DATE >=", value, "redactDate");
            return (Criteria) this;
        }

        public Criteria andRedactDateLessThan(String value) {
            addCriterion("REDACT_DATE <", value, "redactDate");
            return (Criteria) this;
        }

        public Criteria andRedactDateLessThanOrEqualTo(String value) {
            addCriterion("REDACT_DATE <=", value, "redactDate");
            return (Criteria) this;
        }

        public Criteria andRedactDateLike(String value) {
            addCriterion("REDACT_DATE like", value, "redactDate");
            return (Criteria) this;
        }

        public Criteria andRedactDateNotLike(String value) {
            addCriterion("REDACT_DATE not like", value, "redactDate");
            return (Criteria) this;
        }

        public Criteria andRedactDateIn(List<String> values) {
            addCriterion("REDACT_DATE in", values, "redactDate");
            return (Criteria) this;
        }

        public Criteria andRedactDateNotIn(List<String> values) {
            addCriterion("REDACT_DATE not in", values, "redactDate");
            return (Criteria) this;
        }

        public Criteria andRedactDateBetween(String value1, String value2) {
            addCriterion("REDACT_DATE between", value1, value2, "redactDate");
            return (Criteria) this;
        }

        public Criteria andRedactDateNotBetween(String value1, String value2) {
            addCriterion("REDACT_DATE not between", value1, value2, "redactDate");
            return (Criteria) this;
        }

        public Criteria andApproverIdIsNull() {
            addCriterion("APPROVER_ID is null");
            return (Criteria) this;
        }

        public Criteria andApproverIdIsNotNull() {
            addCriterion("APPROVER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andApproverIdEqualTo(String value) {
            addCriterion("APPROVER_ID =", value, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproverIdNotEqualTo(String value) {
            addCriterion("APPROVER_ID <>", value, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproverIdGreaterThan(String value) {
            addCriterion("APPROVER_ID >", value, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproverIdGreaterThanOrEqualTo(String value) {
            addCriterion("APPROVER_ID >=", value, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproverIdLessThan(String value) {
            addCriterion("APPROVER_ID <", value, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproverIdLessThanOrEqualTo(String value) {
            addCriterion("APPROVER_ID <=", value, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproverIdLike(String value) {
            addCriterion("APPROVER_ID like", value, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproverIdNotLike(String value) {
            addCriterion("APPROVER_ID not like", value, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproverIdIn(List<String> values) {
            addCriterion("APPROVER_ID in", values, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproverIdNotIn(List<String> values) {
            addCriterion("APPROVER_ID not in", values, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproverIdBetween(String value1, String value2) {
            addCriterion("APPROVER_ID between", value1, value2, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproverIdNotBetween(String value1, String value2) {
            addCriterion("APPROVER_ID not between", value1, value2, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproverNameIsNull() {
            addCriterion("APPROVER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andApproverNameIsNotNull() {
            addCriterion("APPROVER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andApproverNameEqualTo(String value) {
            addCriterion("APPROVER_NAME =", value, "approverName");
            return (Criteria) this;
        }

        public Criteria andApproverNameNotEqualTo(String value) {
            addCriterion("APPROVER_NAME <>", value, "approverName");
            return (Criteria) this;
        }

        public Criteria andApproverNameGreaterThan(String value) {
            addCriterion("APPROVER_NAME >", value, "approverName");
            return (Criteria) this;
        }

        public Criteria andApproverNameGreaterThanOrEqualTo(String value) {
            addCriterion("APPROVER_NAME >=", value, "approverName");
            return (Criteria) this;
        }

        public Criteria andApproverNameLessThan(String value) {
            addCriterion("APPROVER_NAME <", value, "approverName");
            return (Criteria) this;
        }

        public Criteria andApproverNameLessThanOrEqualTo(String value) {
            addCriterion("APPROVER_NAME <=", value, "approverName");
            return (Criteria) this;
        }

        public Criteria andApproverNameLike(String value) {
            addCriterion("APPROVER_NAME like", value, "approverName");
            return (Criteria) this;
        }

        public Criteria andApproverNameNotLike(String value) {
            addCriterion("APPROVER_NAME not like", value, "approverName");
            return (Criteria) this;
        }

        public Criteria andApproverNameIn(List<String> values) {
            addCriterion("APPROVER_NAME in", values, "approverName");
            return (Criteria) this;
        }

        public Criteria andApproverNameNotIn(List<String> values) {
            addCriterion("APPROVER_NAME not in", values, "approverName");
            return (Criteria) this;
        }

        public Criteria andApproverNameBetween(String value1, String value2) {
            addCriterion("APPROVER_NAME between", value1, value2, "approverName");
            return (Criteria) this;
        }

        public Criteria andApproverNameNotBetween(String value1, String value2) {
            addCriterion("APPROVER_NAME not between", value1, value2, "approverName");
            return (Criteria) this;
        }

        public Criteria andRatifyDateIsNull() {
            addCriterion("RATIFY_DATE is null");
            return (Criteria) this;
        }

        public Criteria andRatifyDateIsNotNull() {
            addCriterion("RATIFY_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andRatifyDateEqualTo(String value) {
            addCriterion("RATIFY_DATE =", value, "ratifyDate");
            return (Criteria) this;
        }

        public Criteria andRatifyDateNotEqualTo(String value) {
            addCriterion("RATIFY_DATE <>", value, "ratifyDate");
            return (Criteria) this;
        }

        public Criteria andRatifyDateGreaterThan(String value) {
            addCriterion("RATIFY_DATE >", value, "ratifyDate");
            return (Criteria) this;
        }

        public Criteria andRatifyDateGreaterThanOrEqualTo(String value) {
            addCriterion("RATIFY_DATE >=", value, "ratifyDate");
            return (Criteria) this;
        }

        public Criteria andRatifyDateLessThan(String value) {
            addCriterion("RATIFY_DATE <", value, "ratifyDate");
            return (Criteria) this;
        }

        public Criteria andRatifyDateLessThanOrEqualTo(String value) {
            addCriterion("RATIFY_DATE <=", value, "ratifyDate");
            return (Criteria) this;
        }

        public Criteria andRatifyDateLike(String value) {
            addCriterion("RATIFY_DATE like", value, "ratifyDate");
            return (Criteria) this;
        }

        public Criteria andRatifyDateNotLike(String value) {
            addCriterion("RATIFY_DATE not like", value, "ratifyDate");
            return (Criteria) this;
        }

        public Criteria andRatifyDateIn(List<String> values) {
            addCriterion("RATIFY_DATE in", values, "ratifyDate");
            return (Criteria) this;
        }

        public Criteria andRatifyDateNotIn(List<String> values) {
            addCriterion("RATIFY_DATE not in", values, "ratifyDate");
            return (Criteria) this;
        }

        public Criteria andRatifyDateBetween(String value1, String value2) {
            addCriterion("RATIFY_DATE between", value1, value2, "ratifyDate");
            return (Criteria) this;
        }

        public Criteria andRatifyDateNotBetween(String value1, String value2) {
            addCriterion("RATIFY_DATE not between", value1, value2, "ratifyDate");
            return (Criteria) this;
        }

        public Criteria andFineScoreIsNull() {
            addCriterion("FINE_SCORE is null");
            return (Criteria) this;
        }

        public Criteria andFineScoreIsNotNull() {
            addCriterion("FINE_SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andFineScoreEqualTo(String value) {
            addCriterion("FINE_SCORE =", value, "fineScore");
            return (Criteria) this;
        }

        public Criteria andFineScoreNotEqualTo(String value) {
            addCriterion("FINE_SCORE <>", value, "fineScore");
            return (Criteria) this;
        }

        public Criteria andFineScoreGreaterThan(String value) {
            addCriterion("FINE_SCORE >", value, "fineScore");
            return (Criteria) this;
        }

        public Criteria andFineScoreGreaterThanOrEqualTo(String value) {
            addCriterion("FINE_SCORE >=", value, "fineScore");
            return (Criteria) this;
        }

        public Criteria andFineScoreLessThan(String value) {
            addCriterion("FINE_SCORE <", value, "fineScore");
            return (Criteria) this;
        }

        public Criteria andFineScoreLessThanOrEqualTo(String value) {
            addCriterion("FINE_SCORE <=", value, "fineScore");
            return (Criteria) this;
        }

        public Criteria andFineScoreLike(String value) {
            addCriterion("FINE_SCORE like", value, "fineScore");
            return (Criteria) this;
        }

        public Criteria andFineScoreNotLike(String value) {
            addCriterion("FINE_SCORE not like", value, "fineScore");
            return (Criteria) this;
        }

        public Criteria andFineScoreIn(List<String> values) {
            addCriterion("FINE_SCORE in", values, "fineScore");
            return (Criteria) this;
        }

        public Criteria andFineScoreNotIn(List<String> values) {
            addCriterion("FINE_SCORE not in", values, "fineScore");
            return (Criteria) this;
        }

        public Criteria andFineScoreBetween(String value1, String value2) {
            addCriterion("FINE_SCORE between", value1, value2, "fineScore");
            return (Criteria) this;
        }

        public Criteria andFineScoreNotBetween(String value1, String value2) {
            addCriterion("FINE_SCORE not between", value1, value2, "fineScore");
            return (Criteria) this;
        }

        public Criteria andFineMoneyIsNull() {
            addCriterion("FINE_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andFineMoneyIsNotNull() {
            addCriterion("FINE_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andFineMoneyEqualTo(String value) {
            addCriterion("FINE_MONEY =", value, "fineMoney");
            return (Criteria) this;
        }

        public Criteria andFineMoneyNotEqualTo(String value) {
            addCriterion("FINE_MONEY <>", value, "fineMoney");
            return (Criteria) this;
        }

        public Criteria andFineMoneyGreaterThan(String value) {
            addCriterion("FINE_MONEY >", value, "fineMoney");
            return (Criteria) this;
        }

        public Criteria andFineMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("FINE_MONEY >=", value, "fineMoney");
            return (Criteria) this;
        }

        public Criteria andFineMoneyLessThan(String value) {
            addCriterion("FINE_MONEY <", value, "fineMoney");
            return (Criteria) this;
        }

        public Criteria andFineMoneyLessThanOrEqualTo(String value) {
            addCriterion("FINE_MONEY <=", value, "fineMoney");
            return (Criteria) this;
        }

        public Criteria andFineMoneyLike(String value) {
            addCriterion("FINE_MONEY like", value, "fineMoney");
            return (Criteria) this;
        }

        public Criteria andFineMoneyNotLike(String value) {
            addCriterion("FINE_MONEY not like", value, "fineMoney");
            return (Criteria) this;
        }

        public Criteria andFineMoneyIn(List<String> values) {
            addCriterion("FINE_MONEY in", values, "fineMoney");
            return (Criteria) this;
        }

        public Criteria andFineMoneyNotIn(List<String> values) {
            addCriterion("FINE_MONEY not in", values, "fineMoney");
            return (Criteria) this;
        }

        public Criteria andFineMoneyBetween(String value1, String value2) {
            addCriterion("FINE_MONEY between", value1, value2, "fineMoney");
            return (Criteria) this;
        }

        public Criteria andFineMoneyNotBetween(String value1, String value2) {
            addCriterion("FINE_MONEY not between", value1, value2, "fineMoney");
            return (Criteria) this;
        }

        public Criteria andIsProvideIsNull() {
            addCriterion("IS_PROVIDE is null");
            return (Criteria) this;
        }

        public Criteria andIsProvideIsNotNull() {
            addCriterion("IS_PROVIDE is not null");
            return (Criteria) this;
        }

        public Criteria andIsProvideEqualTo(String value) {
            addCriterion("IS_PROVIDE =", value, "isProvide");
            return (Criteria) this;
        }

        public Criteria andIsProvideNotEqualTo(String value) {
            addCriterion("IS_PROVIDE <>", value, "isProvide");
            return (Criteria) this;
        }

        public Criteria andIsProvideGreaterThan(String value) {
            addCriterion("IS_PROVIDE >", value, "isProvide");
            return (Criteria) this;
        }

        public Criteria andIsProvideGreaterThanOrEqualTo(String value) {
            addCriterion("IS_PROVIDE >=", value, "isProvide");
            return (Criteria) this;
        }

        public Criteria andIsProvideLessThan(String value) {
            addCriterion("IS_PROVIDE <", value, "isProvide");
            return (Criteria) this;
        }

        public Criteria andIsProvideLessThanOrEqualTo(String value) {
            addCriterion("IS_PROVIDE <=", value, "isProvide");
            return (Criteria) this;
        }

        public Criteria andIsProvideLike(String value) {
            addCriterion("IS_PROVIDE like", value, "isProvide");
            return (Criteria) this;
        }

        public Criteria andIsProvideNotLike(String value) {
            addCriterion("IS_PROVIDE not like", value, "isProvide");
            return (Criteria) this;
        }

        public Criteria andIsProvideIn(List<String> values) {
            addCriterion("IS_PROVIDE in", values, "isProvide");
            return (Criteria) this;
        }

        public Criteria andIsProvideNotIn(List<String> values) {
            addCriterion("IS_PROVIDE not in", values, "isProvide");
            return (Criteria) this;
        }

        public Criteria andIsProvideBetween(String value1, String value2) {
            addCriterion("IS_PROVIDE between", value1, value2, "isProvide");
            return (Criteria) this;
        }

        public Criteria andIsProvideNotBetween(String value1, String value2) {
            addCriterion("IS_PROVIDE not between", value1, value2, "isProvide");
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