package com.pcitc.base.engin.construct.localConstruct.vo;

import java.util.ArrayList;
import java.util.List;

public class BotTemporaryWaterApplyVoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public BotTemporaryWaterApplyVoExample() {
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

        public Criteria andCompactNameIsNull() {
            addCriterion("COMPACT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCompactNameIsNotNull() {
            addCriterion("COMPACT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCompactNameEqualTo(String value) {
            addCriterion("COMPACT_NAME =", value, "compactName");
            return (Criteria) this;
        }

        public Criteria andCompactNameNotEqualTo(String value) {
            addCriterion("COMPACT_NAME <>", value, "compactName");
            return (Criteria) this;
        }

        public Criteria andCompactNameGreaterThan(String value) {
            addCriterion("COMPACT_NAME >", value, "compactName");
            return (Criteria) this;
        }

        public Criteria andCompactNameGreaterThanOrEqualTo(String value) {
            addCriterion("COMPACT_NAME >=", value, "compactName");
            return (Criteria) this;
        }

        public Criteria andCompactNameLessThan(String value) {
            addCriterion("COMPACT_NAME <", value, "compactName");
            return (Criteria) this;
        }

        public Criteria andCompactNameLessThanOrEqualTo(String value) {
            addCriterion("COMPACT_NAME <=", value, "compactName");
            return (Criteria) this;
        }

        public Criteria andCompactNameLike(String value) {
            addCriterion("COMPACT_NAME like", value, "compactName");
            return (Criteria) this;
        }

        public Criteria andCompactNameNotLike(String value) {
            addCriterion("COMPACT_NAME not like", value, "compactName");
            return (Criteria) this;
        }

        public Criteria andCompactNameIn(List<String> values) {
            addCriterion("COMPACT_NAME in", values, "compactName");
            return (Criteria) this;
        }

        public Criteria andCompactNameNotIn(List<String> values) {
            addCriterion("COMPACT_NAME not in", values, "compactName");
            return (Criteria) this;
        }

        public Criteria andCompactNameBetween(String value1, String value2) {
            addCriterion("COMPACT_NAME between", value1, value2, "compactName");
            return (Criteria) this;
        }

        public Criteria andCompactNameNotBetween(String value1, String value2) {
            addCriterion("COMPACT_NAME not between", value1, value2, "compactName");
            return (Criteria) this;
        }

        public Criteria andCompactCodeIsNull() {
            addCriterion("COMPACT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCompactCodeIsNotNull() {
            addCriterion("COMPACT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCompactCodeEqualTo(String value) {
            addCriterion("COMPACT_CODE =", value, "compactCode");
            return (Criteria) this;
        }

        public Criteria andCompactCodeNotEqualTo(String value) {
            addCriterion("COMPACT_CODE <>", value, "compactCode");
            return (Criteria) this;
        }

        public Criteria andCompactCodeGreaterThan(String value) {
            addCriterion("COMPACT_CODE >", value, "compactCode");
            return (Criteria) this;
        }

        public Criteria andCompactCodeGreaterThanOrEqualTo(String value) {
            addCriterion("COMPACT_CODE >=", value, "compactCode");
            return (Criteria) this;
        }

        public Criteria andCompactCodeLessThan(String value) {
            addCriterion("COMPACT_CODE <", value, "compactCode");
            return (Criteria) this;
        }

        public Criteria andCompactCodeLessThanOrEqualTo(String value) {
            addCriterion("COMPACT_CODE <=", value, "compactCode");
            return (Criteria) this;
        }

        public Criteria andCompactCodeLike(String value) {
            addCriterion("COMPACT_CODE like", value, "compactCode");
            return (Criteria) this;
        }

        public Criteria andCompactCodeNotLike(String value) {
            addCriterion("COMPACT_CODE not like", value, "compactCode");
            return (Criteria) this;
        }

        public Criteria andCompactCodeIn(List<String> values) {
            addCriterion("COMPACT_CODE in", values, "compactCode");
            return (Criteria) this;
        }

        public Criteria andCompactCodeNotIn(List<String> values) {
            addCriterion("COMPACT_CODE not in", values, "compactCode");
            return (Criteria) this;
        }

        public Criteria andCompactCodeBetween(String value1, String value2) {
            addCriterion("COMPACT_CODE between", value1, value2, "compactCode");
            return (Criteria) this;
        }

        public Criteria andCompactCodeNotBetween(String value1, String value2) {
            addCriterion("COMPACT_CODE not between", value1, value2, "compactCode");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitNameIsNull() {
            addCriterion("COMPETENT_UNIT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitNameIsNotNull() {
            addCriterion("COMPETENT_UNIT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitNameEqualTo(String value) {
            addCriterion("COMPETENT_UNIT_NAME =", value, "competentUnitName");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitNameNotEqualTo(String value) {
            addCriterion("COMPETENT_UNIT_NAME <>", value, "competentUnitName");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitNameGreaterThan(String value) {
            addCriterion("COMPETENT_UNIT_NAME >", value, "competentUnitName");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitNameGreaterThanOrEqualTo(String value) {
            addCriterion("COMPETENT_UNIT_NAME >=", value, "competentUnitName");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitNameLessThan(String value) {
            addCriterion("COMPETENT_UNIT_NAME <", value, "competentUnitName");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitNameLessThanOrEqualTo(String value) {
            addCriterion("COMPETENT_UNIT_NAME <=", value, "competentUnitName");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitNameLike(String value) {
            addCriterion("COMPETENT_UNIT_NAME like", value, "competentUnitName");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitNameNotLike(String value) {
            addCriterion("COMPETENT_UNIT_NAME not like", value, "competentUnitName");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitNameIn(List<String> values) {
            addCriterion("COMPETENT_UNIT_NAME in", values, "competentUnitName");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitNameNotIn(List<String> values) {
            addCriterion("COMPETENT_UNIT_NAME not in", values, "competentUnitName");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitNameBetween(String value1, String value2) {
            addCriterion("COMPETENT_UNIT_NAME between", value1, value2, "competentUnitName");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitNameNotBetween(String value1, String value2) {
            addCriterion("COMPETENT_UNIT_NAME not between", value1, value2, "competentUnitName");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitCodeIsNull() {
            addCriterion("COMPETENT_UNIT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitCodeIsNotNull() {
            addCriterion("COMPETENT_UNIT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitCodeEqualTo(String value) {
            addCriterion("COMPETENT_UNIT_CODE =", value, "competentUnitCode");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitCodeNotEqualTo(String value) {
            addCriterion("COMPETENT_UNIT_CODE <>", value, "competentUnitCode");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitCodeGreaterThan(String value) {
            addCriterion("COMPETENT_UNIT_CODE >", value, "competentUnitCode");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitCodeGreaterThanOrEqualTo(String value) {
            addCriterion("COMPETENT_UNIT_CODE >=", value, "competentUnitCode");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitCodeLessThan(String value) {
            addCriterion("COMPETENT_UNIT_CODE <", value, "competentUnitCode");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitCodeLessThanOrEqualTo(String value) {
            addCriterion("COMPETENT_UNIT_CODE <=", value, "competentUnitCode");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitCodeLike(String value) {
            addCriterion("COMPETENT_UNIT_CODE like", value, "competentUnitCode");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitCodeNotLike(String value) {
            addCriterion("COMPETENT_UNIT_CODE not like", value, "competentUnitCode");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitCodeIn(List<String> values) {
            addCriterion("COMPETENT_UNIT_CODE in", values, "competentUnitCode");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitCodeNotIn(List<String> values) {
            addCriterion("COMPETENT_UNIT_CODE not in", values, "competentUnitCode");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitCodeBetween(String value1, String value2) {
            addCriterion("COMPETENT_UNIT_CODE between", value1, value2, "competentUnitCode");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitCodeNotBetween(String value1, String value2) {
            addCriterion("COMPETENT_UNIT_CODE not between", value1, value2, "competentUnitCode");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitIdIsNull() {
            addCriterion("COMPETENT_UNIT_ID is null");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitIdIsNotNull() {
            addCriterion("COMPETENT_UNIT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitIdEqualTo(String value) {
            addCriterion("COMPETENT_UNIT_ID =", value, "competentUnitId");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitIdNotEqualTo(String value) {
            addCriterion("COMPETENT_UNIT_ID <>", value, "competentUnitId");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitIdGreaterThan(String value) {
            addCriterion("COMPETENT_UNIT_ID >", value, "competentUnitId");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitIdGreaterThanOrEqualTo(String value) {
            addCriterion("COMPETENT_UNIT_ID >=", value, "competentUnitId");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitIdLessThan(String value) {
            addCriterion("COMPETENT_UNIT_ID <", value, "competentUnitId");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitIdLessThanOrEqualTo(String value) {
            addCriterion("COMPETENT_UNIT_ID <=", value, "competentUnitId");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitIdLike(String value) {
            addCriterion("COMPETENT_UNIT_ID like", value, "competentUnitId");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitIdNotLike(String value) {
            addCriterion("COMPETENT_UNIT_ID not like", value, "competentUnitId");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitIdIn(List<String> values) {
            addCriterion("COMPETENT_UNIT_ID in", values, "competentUnitId");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitIdNotIn(List<String> values) {
            addCriterion("COMPETENT_UNIT_ID not in", values, "competentUnitId");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitIdBetween(String value1, String value2) {
            addCriterion("COMPETENT_UNIT_ID between", value1, value2, "competentUnitId");
            return (Criteria) this;
        }

        public Criteria andCompetentUnitIdNotBetween(String value1, String value2) {
            addCriterion("COMPETENT_UNIT_ID not between", value1, value2, "competentUnitId");
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

        public Criteria andRedactUnitNameIsNull() {
            addCriterion("REDACT_UNIT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andRedactUnitNameIsNotNull() {
            addCriterion("REDACT_UNIT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andRedactUnitNameEqualTo(String value) {
            addCriterion("REDACT_UNIT_NAME =", value, "redactUnitName");
            return (Criteria) this;
        }

        public Criteria andRedactUnitNameNotEqualTo(String value) {
            addCriterion("REDACT_UNIT_NAME <>", value, "redactUnitName");
            return (Criteria) this;
        }

        public Criteria andRedactUnitNameGreaterThan(String value) {
            addCriterion("REDACT_UNIT_NAME >", value, "redactUnitName");
            return (Criteria) this;
        }

        public Criteria andRedactUnitNameGreaterThanOrEqualTo(String value) {
            addCriterion("REDACT_UNIT_NAME >=", value, "redactUnitName");
            return (Criteria) this;
        }

        public Criteria andRedactUnitNameLessThan(String value) {
            addCriterion("REDACT_UNIT_NAME <", value, "redactUnitName");
            return (Criteria) this;
        }

        public Criteria andRedactUnitNameLessThanOrEqualTo(String value) {
            addCriterion("REDACT_UNIT_NAME <=", value, "redactUnitName");
            return (Criteria) this;
        }

        public Criteria andRedactUnitNameLike(String value) {
            addCriterion("REDACT_UNIT_NAME like", value, "redactUnitName");
            return (Criteria) this;
        }

        public Criteria andRedactUnitNameNotLike(String value) {
            addCriterion("REDACT_UNIT_NAME not like", value, "redactUnitName");
            return (Criteria) this;
        }

        public Criteria andRedactUnitNameIn(List<String> values) {
            addCriterion("REDACT_UNIT_NAME in", values, "redactUnitName");
            return (Criteria) this;
        }

        public Criteria andRedactUnitNameNotIn(List<String> values) {
            addCriterion("REDACT_UNIT_NAME not in", values, "redactUnitName");
            return (Criteria) this;
        }

        public Criteria andRedactUnitNameBetween(String value1, String value2) {
            addCriterion("REDACT_UNIT_NAME between", value1, value2, "redactUnitName");
            return (Criteria) this;
        }

        public Criteria andRedactUnitNameNotBetween(String value1, String value2) {
            addCriterion("REDACT_UNIT_NAME not between", value1, value2, "redactUnitName");
            return (Criteria) this;
        }

        public Criteria andRedactUnitCodeIsNull() {
            addCriterion("REDACT_UNIT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andRedactUnitCodeIsNotNull() {
            addCriterion("REDACT_UNIT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andRedactUnitCodeEqualTo(String value) {
            addCriterion("REDACT_UNIT_CODE =", value, "redactUnitCode");
            return (Criteria) this;
        }

        public Criteria andRedactUnitCodeNotEqualTo(String value) {
            addCriterion("REDACT_UNIT_CODE <>", value, "redactUnitCode");
            return (Criteria) this;
        }

        public Criteria andRedactUnitCodeGreaterThan(String value) {
            addCriterion("REDACT_UNIT_CODE >", value, "redactUnitCode");
            return (Criteria) this;
        }

        public Criteria andRedactUnitCodeGreaterThanOrEqualTo(String value) {
            addCriterion("REDACT_UNIT_CODE >=", value, "redactUnitCode");
            return (Criteria) this;
        }

        public Criteria andRedactUnitCodeLessThan(String value) {
            addCriterion("REDACT_UNIT_CODE <", value, "redactUnitCode");
            return (Criteria) this;
        }

        public Criteria andRedactUnitCodeLessThanOrEqualTo(String value) {
            addCriterion("REDACT_UNIT_CODE <=", value, "redactUnitCode");
            return (Criteria) this;
        }

        public Criteria andRedactUnitCodeLike(String value) {
            addCriterion("REDACT_UNIT_CODE like", value, "redactUnitCode");
            return (Criteria) this;
        }

        public Criteria andRedactUnitCodeNotLike(String value) {
            addCriterion("REDACT_UNIT_CODE not like", value, "redactUnitCode");
            return (Criteria) this;
        }

        public Criteria andRedactUnitCodeIn(List<String> values) {
            addCriterion("REDACT_UNIT_CODE in", values, "redactUnitCode");
            return (Criteria) this;
        }

        public Criteria andRedactUnitCodeNotIn(List<String> values) {
            addCriterion("REDACT_UNIT_CODE not in", values, "redactUnitCode");
            return (Criteria) this;
        }

        public Criteria andRedactUnitCodeBetween(String value1, String value2) {
            addCriterion("REDACT_UNIT_CODE between", value1, value2, "redactUnitCode");
            return (Criteria) this;
        }

        public Criteria andRedactUnitCodeNotBetween(String value1, String value2) {
            addCriterion("REDACT_UNIT_CODE not between", value1, value2, "redactUnitCode");
            return (Criteria) this;
        }

        public Criteria andRedactUnitIdIsNull() {
            addCriterion("REDACT_UNIT_ID is null");
            return (Criteria) this;
        }

        public Criteria andRedactUnitIdIsNotNull() {
            addCriterion("REDACT_UNIT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRedactUnitIdEqualTo(String value) {
            addCriterion("REDACT_UNIT_ID =", value, "redactUnitId");
            return (Criteria) this;
        }

        public Criteria andRedactUnitIdNotEqualTo(String value) {
            addCriterion("REDACT_UNIT_ID <>", value, "redactUnitId");
            return (Criteria) this;
        }

        public Criteria andRedactUnitIdGreaterThan(String value) {
            addCriterion("REDACT_UNIT_ID >", value, "redactUnitId");
            return (Criteria) this;
        }

        public Criteria andRedactUnitIdGreaterThanOrEqualTo(String value) {
            addCriterion("REDACT_UNIT_ID >=", value, "redactUnitId");
            return (Criteria) this;
        }

        public Criteria andRedactUnitIdLessThan(String value) {
            addCriterion("REDACT_UNIT_ID <", value, "redactUnitId");
            return (Criteria) this;
        }

        public Criteria andRedactUnitIdLessThanOrEqualTo(String value) {
            addCriterion("REDACT_UNIT_ID <=", value, "redactUnitId");
            return (Criteria) this;
        }

        public Criteria andRedactUnitIdLike(String value) {
            addCriterion("REDACT_UNIT_ID like", value, "redactUnitId");
            return (Criteria) this;
        }

        public Criteria andRedactUnitIdNotLike(String value) {
            addCriterion("REDACT_UNIT_ID not like", value, "redactUnitId");
            return (Criteria) this;
        }

        public Criteria andRedactUnitIdIn(List<String> values) {
            addCriterion("REDACT_UNIT_ID in", values, "redactUnitId");
            return (Criteria) this;
        }

        public Criteria andRedactUnitIdNotIn(List<String> values) {
            addCriterion("REDACT_UNIT_ID not in", values, "redactUnitId");
            return (Criteria) this;
        }

        public Criteria andRedactUnitIdBetween(String value1, String value2) {
            addCriterion("REDACT_UNIT_ID between", value1, value2, "redactUnitId");
            return (Criteria) this;
        }

        public Criteria andRedactUnitIdNotBetween(String value1, String value2) {
            addCriterion("REDACT_UNIT_ID not between", value1, value2, "redactUnitId");
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

        public Criteria andTemporaryWaterApplyBillNameIsNull() {
            addCriterion("TEMPORARY_WATER_APPLY_BILL_NAME is null");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterApplyBillNameIsNotNull() {
            addCriterion("TEMPORARY_WATER_APPLY_BILL_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterApplyBillNameEqualTo(String value) {
            addCriterion("TEMPORARY_WATER_APPLY_BILL_NAME =", value, "temporaryWaterApplyBillName");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterApplyBillNameNotEqualTo(String value) {
            addCriterion("TEMPORARY_WATER_APPLY_BILL_NAME <>", value, "temporaryWaterApplyBillName");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterApplyBillNameGreaterThan(String value) {
            addCriterion("TEMPORARY_WATER_APPLY_BILL_NAME >", value, "temporaryWaterApplyBillName");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterApplyBillNameGreaterThanOrEqualTo(String value) {
            addCriterion("TEMPORARY_WATER_APPLY_BILL_NAME >=", value, "temporaryWaterApplyBillName");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterApplyBillNameLessThan(String value) {
            addCriterion("TEMPORARY_WATER_APPLY_BILL_NAME <", value, "temporaryWaterApplyBillName");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterApplyBillNameLessThanOrEqualTo(String value) {
            addCriterion("TEMPORARY_WATER_APPLY_BILL_NAME <=", value, "temporaryWaterApplyBillName");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterApplyBillNameLike(String value) {
            addCriterion("TEMPORARY_WATER_APPLY_BILL_NAME like", value, "temporaryWaterApplyBillName");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterApplyBillNameNotLike(String value) {
            addCriterion("TEMPORARY_WATER_APPLY_BILL_NAME not like", value, "temporaryWaterApplyBillName");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterApplyBillNameIn(List<String> values) {
            addCriterion("TEMPORARY_WATER_APPLY_BILL_NAME in", values, "temporaryWaterApplyBillName");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterApplyBillNameNotIn(List<String> values) {
            addCriterion("TEMPORARY_WATER_APPLY_BILL_NAME not in", values, "temporaryWaterApplyBillName");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterApplyBillNameBetween(String value1, String value2) {
            addCriterion("TEMPORARY_WATER_APPLY_BILL_NAME between", value1, value2, "temporaryWaterApplyBillName");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterApplyBillNameNotBetween(String value1, String value2) {
            addCriterion("TEMPORARY_WATER_APPLY_BILL_NAME not between", value1, value2, "temporaryWaterApplyBillName");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterApplyBillCodeIsNull() {
            addCriterion("TEMPORARY_WATER_APPLY_BILL_CODE is null");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterApplyBillCodeIsNotNull() {
            addCriterion("TEMPORARY_WATER_APPLY_BILL_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterApplyBillCodeEqualTo(String value) {
            addCriterion("TEMPORARY_WATER_APPLY_BILL_CODE =", value, "temporaryWaterApplyBillCode");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterApplyBillCodeNotEqualTo(String value) {
            addCriterion("TEMPORARY_WATER_APPLY_BILL_CODE <>", value, "temporaryWaterApplyBillCode");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterApplyBillCodeGreaterThan(String value) {
            addCriterion("TEMPORARY_WATER_APPLY_BILL_CODE >", value, "temporaryWaterApplyBillCode");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterApplyBillCodeGreaterThanOrEqualTo(String value) {
            addCriterion("TEMPORARY_WATER_APPLY_BILL_CODE >=", value, "temporaryWaterApplyBillCode");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterApplyBillCodeLessThan(String value) {
            addCriterion("TEMPORARY_WATER_APPLY_BILL_CODE <", value, "temporaryWaterApplyBillCode");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterApplyBillCodeLessThanOrEqualTo(String value) {
            addCriterion("TEMPORARY_WATER_APPLY_BILL_CODE <=", value, "temporaryWaterApplyBillCode");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterApplyBillCodeLike(String value) {
            addCriterion("TEMPORARY_WATER_APPLY_BILL_CODE like", value, "temporaryWaterApplyBillCode");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterApplyBillCodeNotLike(String value) {
            addCriterion("TEMPORARY_WATER_APPLY_BILL_CODE not like", value, "temporaryWaterApplyBillCode");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterApplyBillCodeIn(List<String> values) {
            addCriterion("TEMPORARY_WATER_APPLY_BILL_CODE in", values, "temporaryWaterApplyBillCode");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterApplyBillCodeNotIn(List<String> values) {
            addCriterion("TEMPORARY_WATER_APPLY_BILL_CODE not in", values, "temporaryWaterApplyBillCode");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterApplyBillCodeBetween(String value1, String value2) {
            addCriterion("TEMPORARY_WATER_APPLY_BILL_CODE between", value1, value2, "temporaryWaterApplyBillCode");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterApplyBillCodeNotBetween(String value1, String value2) {
            addCriterion("TEMPORARY_WATER_APPLY_BILL_CODE not between", value1, value2, "temporaryWaterApplyBillCode");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterStartDatatimeIsNull() {
            addCriterion("TEMPORARY_WATER_START_DATATIME is null");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterStartDatatimeIsNotNull() {
            addCriterion("TEMPORARY_WATER_START_DATATIME is not null");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterStartDatatimeEqualTo(String value) {
            addCriterion("TEMPORARY_WATER_START_DATATIME =", value, "temporaryWaterStartDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterStartDatatimeNotEqualTo(String value) {
            addCriterion("TEMPORARY_WATER_START_DATATIME <>", value, "temporaryWaterStartDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterStartDatatimeGreaterThan(String value) {
            addCriterion("TEMPORARY_WATER_START_DATATIME >", value, "temporaryWaterStartDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterStartDatatimeGreaterThanOrEqualTo(String value) {
            addCriterion("TEMPORARY_WATER_START_DATATIME >=", value, "temporaryWaterStartDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterStartDatatimeLessThan(String value) {
            addCriterion("TEMPORARY_WATER_START_DATATIME <", value, "temporaryWaterStartDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterStartDatatimeLessThanOrEqualTo(String value) {
            addCriterion("TEMPORARY_WATER_START_DATATIME <=", value, "temporaryWaterStartDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterStartDatatimeLike(String value) {
            addCriterion("TEMPORARY_WATER_START_DATATIME like", value, "temporaryWaterStartDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterStartDatatimeNotLike(String value) {
            addCriterion("TEMPORARY_WATER_START_DATATIME not like", value, "temporaryWaterStartDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterStartDatatimeIn(List<String> values) {
            addCriterion("TEMPORARY_WATER_START_DATATIME in", values, "temporaryWaterStartDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterStartDatatimeNotIn(List<String> values) {
            addCriterion("TEMPORARY_WATER_START_DATATIME not in", values, "temporaryWaterStartDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterStartDatatimeBetween(String value1, String value2) {
            addCriterion("TEMPORARY_WATER_START_DATATIME between", value1, value2, "temporaryWaterStartDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterStartDatatimeNotBetween(String value1, String value2) {
            addCriterion("TEMPORARY_WATER_START_DATATIME not between", value1, value2, "temporaryWaterStartDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterEndDatatimeIsNull() {
            addCriterion("TEMPORARY_WATER_END_DATATIME is null");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterEndDatatimeIsNotNull() {
            addCriterion("TEMPORARY_WATER_END_DATATIME is not null");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterEndDatatimeEqualTo(String value) {
            addCriterion("TEMPORARY_WATER_END_DATATIME =", value, "temporaryWaterEndDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterEndDatatimeNotEqualTo(String value) {
            addCriterion("TEMPORARY_WATER_END_DATATIME <>", value, "temporaryWaterEndDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterEndDatatimeGreaterThan(String value) {
            addCriterion("TEMPORARY_WATER_END_DATATIME >", value, "temporaryWaterEndDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterEndDatatimeGreaterThanOrEqualTo(String value) {
            addCriterion("TEMPORARY_WATER_END_DATATIME >=", value, "temporaryWaterEndDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterEndDatatimeLessThan(String value) {
            addCriterion("TEMPORARY_WATER_END_DATATIME <", value, "temporaryWaterEndDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterEndDatatimeLessThanOrEqualTo(String value) {
            addCriterion("TEMPORARY_WATER_END_DATATIME <=", value, "temporaryWaterEndDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterEndDatatimeLike(String value) {
            addCriterion("TEMPORARY_WATER_END_DATATIME like", value, "temporaryWaterEndDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterEndDatatimeNotLike(String value) {
            addCriterion("TEMPORARY_WATER_END_DATATIME not like", value, "temporaryWaterEndDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterEndDatatimeIn(List<String> values) {
            addCriterion("TEMPORARY_WATER_END_DATATIME in", values, "temporaryWaterEndDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterEndDatatimeNotIn(List<String> values) {
            addCriterion("TEMPORARY_WATER_END_DATATIME not in", values, "temporaryWaterEndDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterEndDatatimeBetween(String value1, String value2) {
            addCriterion("TEMPORARY_WATER_END_DATATIME between", value1, value2, "temporaryWaterEndDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterEndDatatimeNotBetween(String value1, String value2) {
            addCriterion("TEMPORARY_WATER_END_DATATIME not between", value1, value2, "temporaryWaterEndDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterPlanStartDatatimeIsNull() {
            addCriterion("TEMPORARY_WATER_PLAN_START_DATATIME is null");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterPlanStartDatatimeIsNotNull() {
            addCriterion("TEMPORARY_WATER_PLAN_START_DATATIME is not null");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterPlanStartDatatimeEqualTo(String value) {
            addCriterion("TEMPORARY_WATER_PLAN_START_DATATIME =", value, "temporaryWaterPlanStartDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterPlanStartDatatimeNotEqualTo(String value) {
            addCriterion("TEMPORARY_WATER_PLAN_START_DATATIME <>", value, "temporaryWaterPlanStartDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterPlanStartDatatimeGreaterThan(String value) {
            addCriterion("TEMPORARY_WATER_PLAN_START_DATATIME >", value, "temporaryWaterPlanStartDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterPlanStartDatatimeGreaterThanOrEqualTo(String value) {
            addCriterion("TEMPORARY_WATER_PLAN_START_DATATIME >=", value, "temporaryWaterPlanStartDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterPlanStartDatatimeLessThan(String value) {
            addCriterion("TEMPORARY_WATER_PLAN_START_DATATIME <", value, "temporaryWaterPlanStartDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterPlanStartDatatimeLessThanOrEqualTo(String value) {
            addCriterion("TEMPORARY_WATER_PLAN_START_DATATIME <=", value, "temporaryWaterPlanStartDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterPlanStartDatatimeLike(String value) {
            addCriterion("TEMPORARY_WATER_PLAN_START_DATATIME like", value, "temporaryWaterPlanStartDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterPlanStartDatatimeNotLike(String value) {
            addCriterion("TEMPORARY_WATER_PLAN_START_DATATIME not like", value, "temporaryWaterPlanStartDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterPlanStartDatatimeIn(List<String> values) {
            addCriterion("TEMPORARY_WATER_PLAN_START_DATATIME in", values, "temporaryWaterPlanStartDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterPlanStartDatatimeNotIn(List<String> values) {
            addCriterion("TEMPORARY_WATER_PLAN_START_DATATIME not in", values, "temporaryWaterPlanStartDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterPlanStartDatatimeBetween(String value1, String value2) {
            addCriterion("TEMPORARY_WATER_PLAN_START_DATATIME between", value1, value2, "temporaryWaterPlanStartDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterPlanStartDatatimeNotBetween(String value1, String value2) {
            addCriterion("TEMPORARY_WATER_PLAN_START_DATATIME not between", value1, value2, "temporaryWaterPlanStartDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterPlanEndDatatimeIsNull() {
            addCriterion("TEMPORARY_WATER_PLAN_END_DATATIME is null");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterPlanEndDatatimeIsNotNull() {
            addCriterion("TEMPORARY_WATER_PLAN_END_DATATIME is not null");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterPlanEndDatatimeEqualTo(String value) {
            addCriterion("TEMPORARY_WATER_PLAN_END_DATATIME =", value, "temporaryWaterPlanEndDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterPlanEndDatatimeNotEqualTo(String value) {
            addCriterion("TEMPORARY_WATER_PLAN_END_DATATIME <>", value, "temporaryWaterPlanEndDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterPlanEndDatatimeGreaterThan(String value) {
            addCriterion("TEMPORARY_WATER_PLAN_END_DATATIME >", value, "temporaryWaterPlanEndDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterPlanEndDatatimeGreaterThanOrEqualTo(String value) {
            addCriterion("TEMPORARY_WATER_PLAN_END_DATATIME >=", value, "temporaryWaterPlanEndDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterPlanEndDatatimeLessThan(String value) {
            addCriterion("TEMPORARY_WATER_PLAN_END_DATATIME <", value, "temporaryWaterPlanEndDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterPlanEndDatatimeLessThanOrEqualTo(String value) {
            addCriterion("TEMPORARY_WATER_PLAN_END_DATATIME <=", value, "temporaryWaterPlanEndDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterPlanEndDatatimeLike(String value) {
            addCriterion("TEMPORARY_WATER_PLAN_END_DATATIME like", value, "temporaryWaterPlanEndDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterPlanEndDatatimeNotLike(String value) {
            addCriterion("TEMPORARY_WATER_PLAN_END_DATATIME not like", value, "temporaryWaterPlanEndDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterPlanEndDatatimeIn(List<String> values) {
            addCriterion("TEMPORARY_WATER_PLAN_END_DATATIME in", values, "temporaryWaterPlanEndDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterPlanEndDatatimeNotIn(List<String> values) {
            addCriterion("TEMPORARY_WATER_PLAN_END_DATATIME not in", values, "temporaryWaterPlanEndDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterPlanEndDatatimeBetween(String value1, String value2) {
            addCriterion("TEMPORARY_WATER_PLAN_END_DATATIME between", value1, value2, "temporaryWaterPlanEndDatatime");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterPlanEndDatatimeNotBetween(String value1, String value2) {
            addCriterion("TEMPORARY_WATER_PLAN_END_DATATIME not between", value1, value2, "temporaryWaterPlanEndDatatime");
            return (Criteria) this;
        }

        public Criteria andAffiliationUnitIsNull() {
            addCriterion("AFFILIATION_UNIT is null");
            return (Criteria) this;
        }

        public Criteria andAffiliationUnitIsNotNull() {
            addCriterion("AFFILIATION_UNIT is not null");
            return (Criteria) this;
        }

        public Criteria andAffiliationUnitEqualTo(String value) {
            addCriterion("AFFILIATION_UNIT =", value, "affiliationUnit");
            return (Criteria) this;
        }

        public Criteria andAffiliationUnitNotEqualTo(String value) {
            addCriterion("AFFILIATION_UNIT <>", value, "affiliationUnit");
            return (Criteria) this;
        }

        public Criteria andAffiliationUnitGreaterThan(String value) {
            addCriterion("AFFILIATION_UNIT >", value, "affiliationUnit");
            return (Criteria) this;
        }

        public Criteria andAffiliationUnitGreaterThanOrEqualTo(String value) {
            addCriterion("AFFILIATION_UNIT >=", value, "affiliationUnit");
            return (Criteria) this;
        }

        public Criteria andAffiliationUnitLessThan(String value) {
            addCriterion("AFFILIATION_UNIT <", value, "affiliationUnit");
            return (Criteria) this;
        }

        public Criteria andAffiliationUnitLessThanOrEqualTo(String value) {
            addCriterion("AFFILIATION_UNIT <=", value, "affiliationUnit");
            return (Criteria) this;
        }

        public Criteria andAffiliationUnitLike(String value) {
            addCriterion("AFFILIATION_UNIT like", value, "affiliationUnit");
            return (Criteria) this;
        }

        public Criteria andAffiliationUnitNotLike(String value) {
            addCriterion("AFFILIATION_UNIT not like", value, "affiliationUnit");
            return (Criteria) this;
        }

        public Criteria andAffiliationUnitIn(List<String> values) {
            addCriterion("AFFILIATION_UNIT in", values, "affiliationUnit");
            return (Criteria) this;
        }

        public Criteria andAffiliationUnitNotIn(List<String> values) {
            addCriterion("AFFILIATION_UNIT not in", values, "affiliationUnit");
            return (Criteria) this;
        }

        public Criteria andAffiliationUnitBetween(String value1, String value2) {
            addCriterion("AFFILIATION_UNIT between", value1, value2, "affiliationUnit");
            return (Criteria) this;
        }

        public Criteria andAffiliationUnitNotBetween(String value1, String value2) {
            addCriterion("AFFILIATION_UNIT not between", value1, value2, "affiliationUnit");
            return (Criteria) this;
        }

        public Criteria andJobContentIsNull() {
            addCriterion("JOB_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andJobContentIsNotNull() {
            addCriterion("JOB_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andJobContentEqualTo(String value) {
            addCriterion("JOB_CONTENT =", value, "jobContent");
            return (Criteria) this;
        }

        public Criteria andJobContentNotEqualTo(String value) {
            addCriterion("JOB_CONTENT <>", value, "jobContent");
            return (Criteria) this;
        }

        public Criteria andJobContentGreaterThan(String value) {
            addCriterion("JOB_CONTENT >", value, "jobContent");
            return (Criteria) this;
        }

        public Criteria andJobContentGreaterThanOrEqualTo(String value) {
            addCriterion("JOB_CONTENT >=", value, "jobContent");
            return (Criteria) this;
        }

        public Criteria andJobContentLessThan(String value) {
            addCriterion("JOB_CONTENT <", value, "jobContent");
            return (Criteria) this;
        }

        public Criteria andJobContentLessThanOrEqualTo(String value) {
            addCriterion("JOB_CONTENT <=", value, "jobContent");
            return (Criteria) this;
        }

        public Criteria andJobContentLike(String value) {
            addCriterion("JOB_CONTENT like", value, "jobContent");
            return (Criteria) this;
        }

        public Criteria andJobContentNotLike(String value) {
            addCriterion("JOB_CONTENT not like", value, "jobContent");
            return (Criteria) this;
        }

        public Criteria andJobContentIn(List<String> values) {
            addCriterion("JOB_CONTENT in", values, "jobContent");
            return (Criteria) this;
        }

        public Criteria andJobContentNotIn(List<String> values) {
            addCriterion("JOB_CONTENT not in", values, "jobContent");
            return (Criteria) this;
        }

        public Criteria andJobContentBetween(String value1, String value2) {
            addCriterion("JOB_CONTENT between", value1, value2, "jobContent");
            return (Criteria) this;
        }

        public Criteria andJobContentNotBetween(String value1, String value2) {
            addCriterion("JOB_CONTENT not between", value1, value2, "jobContent");
            return (Criteria) this;
        }

        public Criteria andApplyContentIsNull() {
            addCriterion("APPLY_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andApplyContentIsNotNull() {
            addCriterion("APPLY_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andApplyContentEqualTo(String value) {
            addCriterion("APPLY_CONTENT =", value, "applyContent");
            return (Criteria) this;
        }

        public Criteria andApplyContentNotEqualTo(String value) {
            addCriterion("APPLY_CONTENT <>", value, "applyContent");
            return (Criteria) this;
        }

        public Criteria andApplyContentGreaterThan(String value) {
            addCriterion("APPLY_CONTENT >", value, "applyContent");
            return (Criteria) this;
        }

        public Criteria andApplyContentGreaterThanOrEqualTo(String value) {
            addCriterion("APPLY_CONTENT >=", value, "applyContent");
            return (Criteria) this;
        }

        public Criteria andApplyContentLessThan(String value) {
            addCriterion("APPLY_CONTENT <", value, "applyContent");
            return (Criteria) this;
        }

        public Criteria andApplyContentLessThanOrEqualTo(String value) {
            addCriterion("APPLY_CONTENT <=", value, "applyContent");
            return (Criteria) this;
        }

        public Criteria andApplyContentLike(String value) {
            addCriterion("APPLY_CONTENT like", value, "applyContent");
            return (Criteria) this;
        }

        public Criteria andApplyContentNotLike(String value) {
            addCriterion("APPLY_CONTENT not like", value, "applyContent");
            return (Criteria) this;
        }

        public Criteria andApplyContentIn(List<String> values) {
            addCriterion("APPLY_CONTENT in", values, "applyContent");
            return (Criteria) this;
        }

        public Criteria andApplyContentNotIn(List<String> values) {
            addCriterion("APPLY_CONTENT not in", values, "applyContent");
            return (Criteria) this;
        }

        public Criteria andApplyContentBetween(String value1, String value2) {
            addCriterion("APPLY_CONTENT between", value1, value2, "applyContent");
            return (Criteria) this;
        }

        public Criteria andApplyContentNotBetween(String value1, String value2) {
            addCriterion("APPLY_CONTENT not between", value1, value2, "applyContent");
            return (Criteria) this;
        }

        public Criteria andJobProgramIsNull() {
            addCriterion("JOB_PROGRAM is null");
            return (Criteria) this;
        }

        public Criteria andJobProgramIsNotNull() {
            addCriterion("JOB_PROGRAM is not null");
            return (Criteria) this;
        }

        public Criteria andJobProgramEqualTo(String value) {
            addCriterion("JOB_PROGRAM =", value, "jobProgram");
            return (Criteria) this;
        }

        public Criteria andJobProgramNotEqualTo(String value) {
            addCriterion("JOB_PROGRAM <>", value, "jobProgram");
            return (Criteria) this;
        }

        public Criteria andJobProgramGreaterThan(String value) {
            addCriterion("JOB_PROGRAM >", value, "jobProgram");
            return (Criteria) this;
        }

        public Criteria andJobProgramGreaterThanOrEqualTo(String value) {
            addCriterion("JOB_PROGRAM >=", value, "jobProgram");
            return (Criteria) this;
        }

        public Criteria andJobProgramLessThan(String value) {
            addCriterion("JOB_PROGRAM <", value, "jobProgram");
            return (Criteria) this;
        }

        public Criteria andJobProgramLessThanOrEqualTo(String value) {
            addCriterion("JOB_PROGRAM <=", value, "jobProgram");
            return (Criteria) this;
        }

        public Criteria andJobProgramLike(String value) {
            addCriterion("JOB_PROGRAM like", value, "jobProgram");
            return (Criteria) this;
        }

        public Criteria andJobProgramNotLike(String value) {
            addCriterion("JOB_PROGRAM not like", value, "jobProgram");
            return (Criteria) this;
        }

        public Criteria andJobProgramIn(List<String> values) {
            addCriterion("JOB_PROGRAM in", values, "jobProgram");
            return (Criteria) this;
        }

        public Criteria andJobProgramNotIn(List<String> values) {
            addCriterion("JOB_PROGRAM not in", values, "jobProgram");
            return (Criteria) this;
        }

        public Criteria andJobProgramBetween(String value1, String value2) {
            addCriterion("JOB_PROGRAM between", value1, value2, "jobProgram");
            return (Criteria) this;
        }

        public Criteria andJobProgramNotBetween(String value1, String value2) {
            addCriterion("JOB_PROGRAM not between", value1, value2, "jobProgram");
            return (Criteria) this;
        }

        public Criteria andRecoverProgramIsNull() {
            addCriterion("RECOVER_PROGRAM is null");
            return (Criteria) this;
        }

        public Criteria andRecoverProgramIsNotNull() {
            addCriterion("RECOVER_PROGRAM is not null");
            return (Criteria) this;
        }

        public Criteria andRecoverProgramEqualTo(String value) {
            addCriterion("RECOVER_PROGRAM =", value, "recoverProgram");
            return (Criteria) this;
        }

        public Criteria andRecoverProgramNotEqualTo(String value) {
            addCriterion("RECOVER_PROGRAM <>", value, "recoverProgram");
            return (Criteria) this;
        }

        public Criteria andRecoverProgramGreaterThan(String value) {
            addCriterion("RECOVER_PROGRAM >", value, "recoverProgram");
            return (Criteria) this;
        }

        public Criteria andRecoverProgramGreaterThanOrEqualTo(String value) {
            addCriterion("RECOVER_PROGRAM >=", value, "recoverProgram");
            return (Criteria) this;
        }

        public Criteria andRecoverProgramLessThan(String value) {
            addCriterion("RECOVER_PROGRAM <", value, "recoverProgram");
            return (Criteria) this;
        }

        public Criteria andRecoverProgramLessThanOrEqualTo(String value) {
            addCriterion("RECOVER_PROGRAM <=", value, "recoverProgram");
            return (Criteria) this;
        }

        public Criteria andRecoverProgramLike(String value) {
            addCriterion("RECOVER_PROGRAM like", value, "recoverProgram");
            return (Criteria) this;
        }

        public Criteria andRecoverProgramNotLike(String value) {
            addCriterion("RECOVER_PROGRAM not like", value, "recoverProgram");
            return (Criteria) this;
        }

        public Criteria andRecoverProgramIn(List<String> values) {
            addCriterion("RECOVER_PROGRAM in", values, "recoverProgram");
            return (Criteria) this;
        }

        public Criteria andRecoverProgramNotIn(List<String> values) {
            addCriterion("RECOVER_PROGRAM not in", values, "recoverProgram");
            return (Criteria) this;
        }

        public Criteria andRecoverProgramBetween(String value1, String value2) {
            addCriterion("RECOVER_PROGRAM between", value1, value2, "recoverProgram");
            return (Criteria) this;
        }

        public Criteria andRecoverProgramNotBetween(String value1, String value2) {
            addCriterion("RECOVER_PROGRAM not between", value1, value2, "recoverProgram");
            return (Criteria) this;
        }

        public Criteria andCompleteDatatimeIsNull() {
            addCriterion("COMPLETE_DATATIME is null");
            return (Criteria) this;
        }

        public Criteria andCompleteDatatimeIsNotNull() {
            addCriterion("COMPLETE_DATATIME is not null");
            return (Criteria) this;
        }

        public Criteria andCompleteDatatimeEqualTo(String value) {
            addCriterion("COMPLETE_DATATIME =", value, "completeDatatime");
            return (Criteria) this;
        }

        public Criteria andCompleteDatatimeNotEqualTo(String value) {
            addCriterion("COMPLETE_DATATIME <>", value, "completeDatatime");
            return (Criteria) this;
        }

        public Criteria andCompleteDatatimeGreaterThan(String value) {
            addCriterion("COMPLETE_DATATIME >", value, "completeDatatime");
            return (Criteria) this;
        }

        public Criteria andCompleteDatatimeGreaterThanOrEqualTo(String value) {
            addCriterion("COMPLETE_DATATIME >=", value, "completeDatatime");
            return (Criteria) this;
        }

        public Criteria andCompleteDatatimeLessThan(String value) {
            addCriterion("COMPLETE_DATATIME <", value, "completeDatatime");
            return (Criteria) this;
        }

        public Criteria andCompleteDatatimeLessThanOrEqualTo(String value) {
            addCriterion("COMPLETE_DATATIME <=", value, "completeDatatime");
            return (Criteria) this;
        }

        public Criteria andCompleteDatatimeLike(String value) {
            addCriterion("COMPLETE_DATATIME like", value, "completeDatatime");
            return (Criteria) this;
        }

        public Criteria andCompleteDatatimeNotLike(String value) {
            addCriterion("COMPLETE_DATATIME not like", value, "completeDatatime");
            return (Criteria) this;
        }

        public Criteria andCompleteDatatimeIn(List<String> values) {
            addCriterion("COMPLETE_DATATIME in", values, "completeDatatime");
            return (Criteria) this;
        }

        public Criteria andCompleteDatatimeNotIn(List<String> values) {
            addCriterion("COMPLETE_DATATIME not in", values, "completeDatatime");
            return (Criteria) this;
        }

        public Criteria andCompleteDatatimeBetween(String value1, String value2) {
            addCriterion("COMPLETE_DATATIME between", value1, value2, "completeDatatime");
            return (Criteria) this;
        }

        public Criteria andCompleteDatatimeNotBetween(String value1, String value2) {
            addCriterion("COMPLETE_DATATIME not between", value1, value2, "completeDatatime");
            return (Criteria) this;
        }

        public Criteria andCompleteCheckUserNameIsNull() {
            addCriterion("COMPLETE_CHECK_USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCompleteCheckUserNameIsNotNull() {
            addCriterion("COMPLETE_CHECK_USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCompleteCheckUserNameEqualTo(String value) {
            addCriterion("COMPLETE_CHECK_USER_NAME =", value, "completeCheckUserName");
            return (Criteria) this;
        }

        public Criteria andCompleteCheckUserNameNotEqualTo(String value) {
            addCriterion("COMPLETE_CHECK_USER_NAME <>", value, "completeCheckUserName");
            return (Criteria) this;
        }

        public Criteria andCompleteCheckUserNameGreaterThan(String value) {
            addCriterion("COMPLETE_CHECK_USER_NAME >", value, "completeCheckUserName");
            return (Criteria) this;
        }

        public Criteria andCompleteCheckUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("COMPLETE_CHECK_USER_NAME >=", value, "completeCheckUserName");
            return (Criteria) this;
        }

        public Criteria andCompleteCheckUserNameLessThan(String value) {
            addCriterion("COMPLETE_CHECK_USER_NAME <", value, "completeCheckUserName");
            return (Criteria) this;
        }

        public Criteria andCompleteCheckUserNameLessThanOrEqualTo(String value) {
            addCriterion("COMPLETE_CHECK_USER_NAME <=", value, "completeCheckUserName");
            return (Criteria) this;
        }

        public Criteria andCompleteCheckUserNameLike(String value) {
            addCriterion("COMPLETE_CHECK_USER_NAME like", value, "completeCheckUserName");
            return (Criteria) this;
        }

        public Criteria andCompleteCheckUserNameNotLike(String value) {
            addCriterion("COMPLETE_CHECK_USER_NAME not like", value, "completeCheckUserName");
            return (Criteria) this;
        }

        public Criteria andCompleteCheckUserNameIn(List<String> values) {
            addCriterion("COMPLETE_CHECK_USER_NAME in", values, "completeCheckUserName");
            return (Criteria) this;
        }

        public Criteria andCompleteCheckUserNameNotIn(List<String> values) {
            addCriterion("COMPLETE_CHECK_USER_NAME not in", values, "completeCheckUserName");
            return (Criteria) this;
        }

        public Criteria andCompleteCheckUserNameBetween(String value1, String value2) {
            addCriterion("COMPLETE_CHECK_USER_NAME between", value1, value2, "completeCheckUserName");
            return (Criteria) this;
        }

        public Criteria andCompleteCheckUserNameNotBetween(String value1, String value2) {
            addCriterion("COMPLETE_CHECK_USER_NAME not between", value1, value2, "completeCheckUserName");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterUseIsNull() {
            addCriterion("TEMPORARY_WATER_USE is null");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterUseIsNotNull() {
            addCriterion("TEMPORARY_WATER_USE is not null");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterUseEqualTo(String value) {
            addCriterion("TEMPORARY_WATER_USE =", value, "temporaryWaterUse");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterUseNotEqualTo(String value) {
            addCriterion("TEMPORARY_WATER_USE <>", value, "temporaryWaterUse");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterUseGreaterThan(String value) {
            addCriterion("TEMPORARY_WATER_USE >", value, "temporaryWaterUse");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterUseGreaterThanOrEqualTo(String value) {
            addCriterion("TEMPORARY_WATER_USE >=", value, "temporaryWaterUse");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterUseLessThan(String value) {
            addCriterion("TEMPORARY_WATER_USE <", value, "temporaryWaterUse");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterUseLessThanOrEqualTo(String value) {
            addCriterion("TEMPORARY_WATER_USE <=", value, "temporaryWaterUse");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterUseLike(String value) {
            addCriterion("TEMPORARY_WATER_USE like", value, "temporaryWaterUse");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterUseNotLike(String value) {
            addCriterion("TEMPORARY_WATER_USE not like", value, "temporaryWaterUse");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterUseIn(List<String> values) {
            addCriterion("TEMPORARY_WATER_USE in", values, "temporaryWaterUse");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterUseNotIn(List<String> values) {
            addCriterion("TEMPORARY_WATER_USE not in", values, "temporaryWaterUse");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterUseBetween(String value1, String value2) {
            addCriterion("TEMPORARY_WATER_USE between", value1, value2, "temporaryWaterUse");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterUseNotBetween(String value1, String value2) {
            addCriterion("TEMPORARY_WATER_USE not between", value1, value2, "temporaryWaterUse");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterNumberIsNull() {
            addCriterion("TEMPORARY_WATER_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterNumberIsNotNull() {
            addCriterion("TEMPORARY_WATER_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterNumberEqualTo(String value) {
            addCriterion("TEMPORARY_WATER_NUMBER =", value, "temporaryWaterNumber");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterNumberNotEqualTo(String value) {
            addCriterion("TEMPORARY_WATER_NUMBER <>", value, "temporaryWaterNumber");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterNumberGreaterThan(String value) {
            addCriterion("TEMPORARY_WATER_NUMBER >", value, "temporaryWaterNumber");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterNumberGreaterThanOrEqualTo(String value) {
            addCriterion("TEMPORARY_WATER_NUMBER >=", value, "temporaryWaterNumber");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterNumberLessThan(String value) {
            addCriterion("TEMPORARY_WATER_NUMBER <", value, "temporaryWaterNumber");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterNumberLessThanOrEqualTo(String value) {
            addCriterion("TEMPORARY_WATER_NUMBER <=", value, "temporaryWaterNumber");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterNumberLike(String value) {
            addCriterion("TEMPORARY_WATER_NUMBER like", value, "temporaryWaterNumber");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterNumberNotLike(String value) {
            addCriterion("TEMPORARY_WATER_NUMBER not like", value, "temporaryWaterNumber");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterNumberIn(List<String> values) {
            addCriterion("TEMPORARY_WATER_NUMBER in", values, "temporaryWaterNumber");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterNumberNotIn(List<String> values) {
            addCriterion("TEMPORARY_WATER_NUMBER not in", values, "temporaryWaterNumber");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterNumberBetween(String value1, String value2) {
            addCriterion("TEMPORARY_WATER_NUMBER between", value1, value2, "temporaryWaterNumber");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterNumberNotBetween(String value1, String value2) {
            addCriterion("TEMPORARY_WATER_NUMBER not between", value1, value2, "temporaryWaterNumber");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameIsNull() {
            addCriterion("APPLY_USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameIsNotNull() {
            addCriterion("APPLY_USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameEqualTo(String value) {
            addCriterion("APPLY_USER_NAME =", value, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameNotEqualTo(String value) {
            addCriterion("APPLY_USER_NAME <>", value, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameGreaterThan(String value) {
            addCriterion("APPLY_USER_NAME >", value, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("APPLY_USER_NAME >=", value, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameLessThan(String value) {
            addCriterion("APPLY_USER_NAME <", value, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameLessThanOrEqualTo(String value) {
            addCriterion("APPLY_USER_NAME <=", value, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameLike(String value) {
            addCriterion("APPLY_USER_NAME like", value, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameNotLike(String value) {
            addCriterion("APPLY_USER_NAME not like", value, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameIn(List<String> values) {
            addCriterion("APPLY_USER_NAME in", values, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameNotIn(List<String> values) {
            addCriterion("APPLY_USER_NAME not in", values, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameBetween(String value1, String value2) {
            addCriterion("APPLY_USER_NAME between", value1, value2, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameNotBetween(String value1, String value2) {
            addCriterion("APPLY_USER_NAME not between", value1, value2, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserIdIsNull() {
            addCriterion("APPLY_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andApplyUserIdIsNotNull() {
            addCriterion("APPLY_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andApplyUserIdEqualTo(String value) {
            addCriterion("APPLY_USER_ID =", value, "applyUserId");
            return (Criteria) this;
        }

        public Criteria andApplyUserIdNotEqualTo(String value) {
            addCriterion("APPLY_USER_ID <>", value, "applyUserId");
            return (Criteria) this;
        }

        public Criteria andApplyUserIdGreaterThan(String value) {
            addCriterion("APPLY_USER_ID >", value, "applyUserId");
            return (Criteria) this;
        }

        public Criteria andApplyUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("APPLY_USER_ID >=", value, "applyUserId");
            return (Criteria) this;
        }

        public Criteria andApplyUserIdLessThan(String value) {
            addCriterion("APPLY_USER_ID <", value, "applyUserId");
            return (Criteria) this;
        }

        public Criteria andApplyUserIdLessThanOrEqualTo(String value) {
            addCriterion("APPLY_USER_ID <=", value, "applyUserId");
            return (Criteria) this;
        }

        public Criteria andApplyUserIdLike(String value) {
            addCriterion("APPLY_USER_ID like", value, "applyUserId");
            return (Criteria) this;
        }

        public Criteria andApplyUserIdNotLike(String value) {
            addCriterion("APPLY_USER_ID not like", value, "applyUserId");
            return (Criteria) this;
        }

        public Criteria andApplyUserIdIn(List<String> values) {
            addCriterion("APPLY_USER_ID in", values, "applyUserId");
            return (Criteria) this;
        }

        public Criteria andApplyUserIdNotIn(List<String> values) {
            addCriterion("APPLY_USER_ID not in", values, "applyUserId");
            return (Criteria) this;
        }

        public Criteria andApplyUserIdBetween(String value1, String value2) {
            addCriterion("APPLY_USER_ID between", value1, value2, "applyUserId");
            return (Criteria) this;
        }

        public Criteria andApplyUserIdNotBetween(String value1, String value2) {
            addCriterion("APPLY_USER_ID not between", value1, value2, "applyUserId");
            return (Criteria) this;
        }

        public Criteria andApplyUserPhoneIsNull() {
            addCriterion("APPLY_USER_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andApplyUserPhoneIsNotNull() {
            addCriterion("APPLY_USER_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andApplyUserPhoneEqualTo(String value) {
            addCriterion("APPLY_USER_PHONE =", value, "applyUserPhone");
            return (Criteria) this;
        }

        public Criteria andApplyUserPhoneNotEqualTo(String value) {
            addCriterion("APPLY_USER_PHONE <>", value, "applyUserPhone");
            return (Criteria) this;
        }

        public Criteria andApplyUserPhoneGreaterThan(String value) {
            addCriterion("APPLY_USER_PHONE >", value, "applyUserPhone");
            return (Criteria) this;
        }

        public Criteria andApplyUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("APPLY_USER_PHONE >=", value, "applyUserPhone");
            return (Criteria) this;
        }

        public Criteria andApplyUserPhoneLessThan(String value) {
            addCriterion("APPLY_USER_PHONE <", value, "applyUserPhone");
            return (Criteria) this;
        }

        public Criteria andApplyUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("APPLY_USER_PHONE <=", value, "applyUserPhone");
            return (Criteria) this;
        }

        public Criteria andApplyUserPhoneLike(String value) {
            addCriterion("APPLY_USER_PHONE like", value, "applyUserPhone");
            return (Criteria) this;
        }

        public Criteria andApplyUserPhoneNotLike(String value) {
            addCriterion("APPLY_USER_PHONE not like", value, "applyUserPhone");
            return (Criteria) this;
        }

        public Criteria andApplyUserPhoneIn(List<String> values) {
            addCriterion("APPLY_USER_PHONE in", values, "applyUserPhone");
            return (Criteria) this;
        }

        public Criteria andApplyUserPhoneNotIn(List<String> values) {
            addCriterion("APPLY_USER_PHONE not in", values, "applyUserPhone");
            return (Criteria) this;
        }

        public Criteria andApplyUserPhoneBetween(String value1, String value2) {
            addCriterion("APPLY_USER_PHONE between", value1, value2, "applyUserPhone");
            return (Criteria) this;
        }

        public Criteria andApplyUserPhoneNotBetween(String value1, String value2) {
            addCriterion("APPLY_USER_PHONE not between", value1, value2, "applyUserPhone");
            return (Criteria) this;
        }

        public Criteria andAnnouncementsIsNull() {
            addCriterion("ANNOUNCEMENTS is null");
            return (Criteria) this;
        }

        public Criteria andAnnouncementsIsNotNull() {
            addCriterion("ANNOUNCEMENTS is not null");
            return (Criteria) this;
        }

        public Criteria andAnnouncementsEqualTo(String value) {
            addCriterion("ANNOUNCEMENTS =", value, "announcements");
            return (Criteria) this;
        }

        public Criteria andAnnouncementsNotEqualTo(String value) {
            addCriterion("ANNOUNCEMENTS <>", value, "announcements");
            return (Criteria) this;
        }

        public Criteria andAnnouncementsGreaterThan(String value) {
            addCriterion("ANNOUNCEMENTS >", value, "announcements");
            return (Criteria) this;
        }

        public Criteria andAnnouncementsGreaterThanOrEqualTo(String value) {
            addCriterion("ANNOUNCEMENTS >=", value, "announcements");
            return (Criteria) this;
        }

        public Criteria andAnnouncementsLessThan(String value) {
            addCriterion("ANNOUNCEMENTS <", value, "announcements");
            return (Criteria) this;
        }

        public Criteria andAnnouncementsLessThanOrEqualTo(String value) {
            addCriterion("ANNOUNCEMENTS <=", value, "announcements");
            return (Criteria) this;
        }

        public Criteria andAnnouncementsLike(String value) {
            addCriterion("ANNOUNCEMENTS like", value, "announcements");
            return (Criteria) this;
        }

        public Criteria andAnnouncementsNotLike(String value) {
            addCriterion("ANNOUNCEMENTS not like", value, "announcements");
            return (Criteria) this;
        }

        public Criteria andAnnouncementsIn(List<String> values) {
            addCriterion("ANNOUNCEMENTS in", values, "announcements");
            return (Criteria) this;
        }

        public Criteria andAnnouncementsNotIn(List<String> values) {
            addCriterion("ANNOUNCEMENTS not in", values, "announcements");
            return (Criteria) this;
        }

        public Criteria andAnnouncementsBetween(String value1, String value2) {
            addCriterion("ANNOUNCEMENTS between", value1, value2, "announcements");
            return (Criteria) this;
        }

        public Criteria andAnnouncementsNotBetween(String value1, String value2) {
            addCriterion("ANNOUNCEMENTS not between", value1, value2, "announcements");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterYieldIsNull() {
            addCriterion("TEMPORARY_WATER_YIELD is null");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterYieldIsNotNull() {
            addCriterion("TEMPORARY_WATER_YIELD is not null");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterYieldEqualTo(String value) {
            addCriterion("TEMPORARY_WATER_YIELD =", value, "temporaryWaterYield");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterYieldNotEqualTo(String value) {
            addCriterion("TEMPORARY_WATER_YIELD <>", value, "temporaryWaterYield");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterYieldGreaterThan(String value) {
            addCriterion("TEMPORARY_WATER_YIELD >", value, "temporaryWaterYield");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterYieldGreaterThanOrEqualTo(String value) {
            addCriterion("TEMPORARY_WATER_YIELD >=", value, "temporaryWaterYield");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterYieldLessThan(String value) {
            addCriterion("TEMPORARY_WATER_YIELD <", value, "temporaryWaterYield");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterYieldLessThanOrEqualTo(String value) {
            addCriterion("TEMPORARY_WATER_YIELD <=", value, "temporaryWaterYield");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterYieldLike(String value) {
            addCriterion("TEMPORARY_WATER_YIELD like", value, "temporaryWaterYield");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterYieldNotLike(String value) {
            addCriterion("TEMPORARY_WATER_YIELD not like", value, "temporaryWaterYield");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterYieldIn(List<String> values) {
            addCriterion("TEMPORARY_WATER_YIELD in", values, "temporaryWaterYield");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterYieldNotIn(List<String> values) {
            addCriterion("TEMPORARY_WATER_YIELD not in", values, "temporaryWaterYield");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterYieldBetween(String value1, String value2) {
            addCriterion("TEMPORARY_WATER_YIELD between", value1, value2, "temporaryWaterYield");
            return (Criteria) this;
        }

        public Criteria andTemporaryWaterYieldNotBetween(String value1, String value2) {
            addCriterion("TEMPORARY_WATER_YIELD not between", value1, value2, "temporaryWaterYield");
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