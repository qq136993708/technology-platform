package com.pcitc.base.engin.workOrder.vo;

import java.util.ArrayList;
import java.util.List;

public class BotWorkOrderMatterVoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public BotWorkOrderMatterVoExample() {
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

        public Criteria andWorkOrderNameIsNull() {
            addCriterion("WORK_ORDER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNameIsNotNull() {
            addCriterion("WORK_ORDER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNameEqualTo(String value) {
            addCriterion("WORK_ORDER_NAME =", value, "workOrderName");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNameNotEqualTo(String value) {
            addCriterion("WORK_ORDER_NAME <>", value, "workOrderName");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNameGreaterThan(String value) {
            addCriterion("WORK_ORDER_NAME >", value, "workOrderName");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNameGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_ORDER_NAME >=", value, "workOrderName");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNameLessThan(String value) {
            addCriterion("WORK_ORDER_NAME <", value, "workOrderName");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNameLessThanOrEqualTo(String value) {
            addCriterion("WORK_ORDER_NAME <=", value, "workOrderName");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNameLike(String value) {
            addCriterion("WORK_ORDER_NAME like", value, "workOrderName");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNameNotLike(String value) {
            addCriterion("WORK_ORDER_NAME not like", value, "workOrderName");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNameIn(List<String> values) {
            addCriterion("WORK_ORDER_NAME in", values, "workOrderName");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNameNotIn(List<String> values) {
            addCriterion("WORK_ORDER_NAME not in", values, "workOrderName");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNameBetween(String value1, String value2) {
            addCriterion("WORK_ORDER_NAME between", value1, value2, "workOrderName");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNameNotBetween(String value1, String value2) {
            addCriterion("WORK_ORDER_NAME not between", value1, value2, "workOrderName");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIdIsNull() {
            addCriterion("WORK_ORDER_ID is null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIdIsNotNull() {
            addCriterion("WORK_ORDER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIdEqualTo(String value) {
            addCriterion("WORK_ORDER_ID =", value, "workOrderId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIdNotEqualTo(String value) {
            addCriterion("WORK_ORDER_ID <>", value, "workOrderId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIdGreaterThan(String value) {
            addCriterion("WORK_ORDER_ID >", value, "workOrderId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_ORDER_ID >=", value, "workOrderId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIdLessThan(String value) {
            addCriterion("WORK_ORDER_ID <", value, "workOrderId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIdLessThanOrEqualTo(String value) {
            addCriterion("WORK_ORDER_ID <=", value, "workOrderId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIdLike(String value) {
            addCriterion("WORK_ORDER_ID like", value, "workOrderId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIdNotLike(String value) {
            addCriterion("WORK_ORDER_ID not like", value, "workOrderId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIdIn(List<String> values) {
            addCriterion("WORK_ORDER_ID in", values, "workOrderId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIdNotIn(List<String> values) {
            addCriterion("WORK_ORDER_ID not in", values, "workOrderId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIdBetween(String value1, String value2) {
            addCriterion("WORK_ORDER_ID between", value1, value2, "workOrderId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIdNotBetween(String value1, String value2) {
            addCriterion("WORK_ORDER_ID not between", value1, value2, "workOrderId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderCodeIsNull() {
            addCriterion("WORK_ORDER_CODE is null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderCodeIsNotNull() {
            addCriterion("WORK_ORDER_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderCodeEqualTo(String value) {
            addCriterion("WORK_ORDER_CODE =", value, "workOrderCode");
            return (Criteria) this;
        }

        public Criteria andWorkOrderCodeNotEqualTo(String value) {
            addCriterion("WORK_ORDER_CODE <>", value, "workOrderCode");
            return (Criteria) this;
        }

        public Criteria andWorkOrderCodeGreaterThan(String value) {
            addCriterion("WORK_ORDER_CODE >", value, "workOrderCode");
            return (Criteria) this;
        }

        public Criteria andWorkOrderCodeGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_ORDER_CODE >=", value, "workOrderCode");
            return (Criteria) this;
        }

        public Criteria andWorkOrderCodeLessThan(String value) {
            addCriterion("WORK_ORDER_CODE <", value, "workOrderCode");
            return (Criteria) this;
        }

        public Criteria andWorkOrderCodeLessThanOrEqualTo(String value) {
            addCriterion("WORK_ORDER_CODE <=", value, "workOrderCode");
            return (Criteria) this;
        }

        public Criteria andWorkOrderCodeLike(String value) {
            addCriterion("WORK_ORDER_CODE like", value, "workOrderCode");
            return (Criteria) this;
        }

        public Criteria andWorkOrderCodeNotLike(String value) {
            addCriterion("WORK_ORDER_CODE not like", value, "workOrderCode");
            return (Criteria) this;
        }

        public Criteria andWorkOrderCodeIn(List<String> values) {
            addCriterion("WORK_ORDER_CODE in", values, "workOrderCode");
            return (Criteria) this;
        }

        public Criteria andWorkOrderCodeNotIn(List<String> values) {
            addCriterion("WORK_ORDER_CODE not in", values, "workOrderCode");
            return (Criteria) this;
        }

        public Criteria andWorkOrderCodeBetween(String value1, String value2) {
            addCriterion("WORK_ORDER_CODE between", value1, value2, "workOrderCode");
            return (Criteria) this;
        }

        public Criteria andWorkOrderCodeNotBetween(String value1, String value2) {
            addCriterion("WORK_ORDER_CODE not between", value1, value2, "workOrderCode");
            return (Criteria) this;
        }

        public Criteria andWorkOrderStartDatatimeIsNull() {
            addCriterion("WORK_ORDER_START_DATATIME is null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderStartDatatimeIsNotNull() {
            addCriterion("WORK_ORDER_START_DATATIME is not null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderStartDatatimeEqualTo(String value) {
            addCriterion("WORK_ORDER_START_DATATIME =", value, "workOrderStartDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderStartDatatimeNotEqualTo(String value) {
            addCriterion("WORK_ORDER_START_DATATIME <>", value, "workOrderStartDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderStartDatatimeGreaterThan(String value) {
            addCriterion("WORK_ORDER_START_DATATIME >", value, "workOrderStartDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderStartDatatimeGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_ORDER_START_DATATIME >=", value, "workOrderStartDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderStartDatatimeLessThan(String value) {
            addCriterion("WORK_ORDER_START_DATATIME <", value, "workOrderStartDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderStartDatatimeLessThanOrEqualTo(String value) {
            addCriterion("WORK_ORDER_START_DATATIME <=", value, "workOrderStartDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderStartDatatimeLike(String value) {
            addCriterion("WORK_ORDER_START_DATATIME like", value, "workOrderStartDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderStartDatatimeNotLike(String value) {
            addCriterion("WORK_ORDER_START_DATATIME not like", value, "workOrderStartDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderStartDatatimeIn(List<String> values) {
            addCriterion("WORK_ORDER_START_DATATIME in", values, "workOrderStartDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderStartDatatimeNotIn(List<String> values) {
            addCriterion("WORK_ORDER_START_DATATIME not in", values, "workOrderStartDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderStartDatatimeBetween(String value1, String value2) {
            addCriterion("WORK_ORDER_START_DATATIME between", value1, value2, "workOrderStartDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderStartDatatimeNotBetween(String value1, String value2) {
            addCriterion("WORK_ORDER_START_DATATIME not between", value1, value2, "workOrderStartDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderEndDatatimeIsNull() {
            addCriterion("WORK_ORDER_END_DATATIME is null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderEndDatatimeIsNotNull() {
            addCriterion("WORK_ORDER_END_DATATIME is not null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderEndDatatimeEqualTo(String value) {
            addCriterion("WORK_ORDER_END_DATATIME =", value, "workOrderEndDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderEndDatatimeNotEqualTo(String value) {
            addCriterion("WORK_ORDER_END_DATATIME <>", value, "workOrderEndDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderEndDatatimeGreaterThan(String value) {
            addCriterion("WORK_ORDER_END_DATATIME >", value, "workOrderEndDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderEndDatatimeGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_ORDER_END_DATATIME >=", value, "workOrderEndDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderEndDatatimeLessThan(String value) {
            addCriterion("WORK_ORDER_END_DATATIME <", value, "workOrderEndDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderEndDatatimeLessThanOrEqualTo(String value) {
            addCriterion("WORK_ORDER_END_DATATIME <=", value, "workOrderEndDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderEndDatatimeLike(String value) {
            addCriterion("WORK_ORDER_END_DATATIME like", value, "workOrderEndDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderEndDatatimeNotLike(String value) {
            addCriterion("WORK_ORDER_END_DATATIME not like", value, "workOrderEndDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderEndDatatimeIn(List<String> values) {
            addCriterion("WORK_ORDER_END_DATATIME in", values, "workOrderEndDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderEndDatatimeNotIn(List<String> values) {
            addCriterion("WORK_ORDER_END_DATATIME not in", values, "workOrderEndDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderEndDatatimeBetween(String value1, String value2) {
            addCriterion("WORK_ORDER_END_DATATIME between", value1, value2, "workOrderEndDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderEndDatatimeNotBetween(String value1, String value2) {
            addCriterion("WORK_ORDER_END_DATATIME not between", value1, value2, "workOrderEndDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderPlanStartDatatimeIsNull() {
            addCriterion("WORK_ORDER_PLAN_START_DATATIME is null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderPlanStartDatatimeIsNotNull() {
            addCriterion("WORK_ORDER_PLAN_START_DATATIME is not null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderPlanStartDatatimeEqualTo(String value) {
            addCriterion("WORK_ORDER_PLAN_START_DATATIME =", value, "workOrderPlanStartDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderPlanStartDatatimeNotEqualTo(String value) {
            addCriterion("WORK_ORDER_PLAN_START_DATATIME <>", value, "workOrderPlanStartDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderPlanStartDatatimeGreaterThan(String value) {
            addCriterion("WORK_ORDER_PLAN_START_DATATIME >", value, "workOrderPlanStartDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderPlanStartDatatimeGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_ORDER_PLAN_START_DATATIME >=", value, "workOrderPlanStartDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderPlanStartDatatimeLessThan(String value) {
            addCriterion("WORK_ORDER_PLAN_START_DATATIME <", value, "workOrderPlanStartDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderPlanStartDatatimeLessThanOrEqualTo(String value) {
            addCriterion("WORK_ORDER_PLAN_START_DATATIME <=", value, "workOrderPlanStartDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderPlanStartDatatimeLike(String value) {
            addCriterion("WORK_ORDER_PLAN_START_DATATIME like", value, "workOrderPlanStartDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderPlanStartDatatimeNotLike(String value) {
            addCriterion("WORK_ORDER_PLAN_START_DATATIME not like", value, "workOrderPlanStartDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderPlanStartDatatimeIn(List<String> values) {
            addCriterion("WORK_ORDER_PLAN_START_DATATIME in", values, "workOrderPlanStartDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderPlanStartDatatimeNotIn(List<String> values) {
            addCriterion("WORK_ORDER_PLAN_START_DATATIME not in", values, "workOrderPlanStartDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderPlanStartDatatimeBetween(String value1, String value2) {
            addCriterion("WORK_ORDER_PLAN_START_DATATIME between", value1, value2, "workOrderPlanStartDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderPlanStartDatatimeNotBetween(String value1, String value2) {
            addCriterion("WORK_ORDER_PLAN_START_DATATIME not between", value1, value2, "workOrderPlanStartDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderPlanEndDatatimeIsNull() {
            addCriterion("WORK_ORDER_PLAN_END_DATATIME is null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderPlanEndDatatimeIsNotNull() {
            addCriterion("WORK_ORDER_PLAN_END_DATATIME is not null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderPlanEndDatatimeEqualTo(String value) {
            addCriterion("WORK_ORDER_PLAN_END_DATATIME =", value, "workOrderPlanEndDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderPlanEndDatatimeNotEqualTo(String value) {
            addCriterion("WORK_ORDER_PLAN_END_DATATIME <>", value, "workOrderPlanEndDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderPlanEndDatatimeGreaterThan(String value) {
            addCriterion("WORK_ORDER_PLAN_END_DATATIME >", value, "workOrderPlanEndDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderPlanEndDatatimeGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_ORDER_PLAN_END_DATATIME >=", value, "workOrderPlanEndDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderPlanEndDatatimeLessThan(String value) {
            addCriterion("WORK_ORDER_PLAN_END_DATATIME <", value, "workOrderPlanEndDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderPlanEndDatatimeLessThanOrEqualTo(String value) {
            addCriterion("WORK_ORDER_PLAN_END_DATATIME <=", value, "workOrderPlanEndDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderPlanEndDatatimeLike(String value) {
            addCriterion("WORK_ORDER_PLAN_END_DATATIME like", value, "workOrderPlanEndDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderPlanEndDatatimeNotLike(String value) {
            addCriterion("WORK_ORDER_PLAN_END_DATATIME not like", value, "workOrderPlanEndDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderPlanEndDatatimeIn(List<String> values) {
            addCriterion("WORK_ORDER_PLAN_END_DATATIME in", values, "workOrderPlanEndDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderPlanEndDatatimeNotIn(List<String> values) {
            addCriterion("WORK_ORDER_PLAN_END_DATATIME not in", values, "workOrderPlanEndDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderPlanEndDatatimeBetween(String value1, String value2) {
            addCriterion("WORK_ORDER_PLAN_END_DATATIME between", value1, value2, "workOrderPlanEndDatatime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderPlanEndDatatimeNotBetween(String value1, String value2) {
            addCriterion("WORK_ORDER_PLAN_END_DATATIME not between", value1, value2, "workOrderPlanEndDatatime");
            return (Criteria) this;
        }

        public Criteria andMatterTypeIsNull() {
            addCriterion("MATTER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andMatterTypeIsNotNull() {
            addCriterion("MATTER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMatterTypeEqualTo(String value) {
            addCriterion("MATTER_TYPE =", value, "matterType");
            return (Criteria) this;
        }

        public Criteria andMatterTypeNotEqualTo(String value) {
            addCriterion("MATTER_TYPE <>", value, "matterType");
            return (Criteria) this;
        }

        public Criteria andMatterTypeGreaterThan(String value) {
            addCriterion("MATTER_TYPE >", value, "matterType");
            return (Criteria) this;
        }

        public Criteria andMatterTypeGreaterThanOrEqualTo(String value) {
            addCriterion("MATTER_TYPE >=", value, "matterType");
            return (Criteria) this;
        }

        public Criteria andMatterTypeLessThan(String value) {
            addCriterion("MATTER_TYPE <", value, "matterType");
            return (Criteria) this;
        }

        public Criteria andMatterTypeLessThanOrEqualTo(String value) {
            addCriterion("MATTER_TYPE <=", value, "matterType");
            return (Criteria) this;
        }

        public Criteria andMatterTypeLike(String value) {
            addCriterion("MATTER_TYPE like", value, "matterType");
            return (Criteria) this;
        }

        public Criteria andMatterTypeNotLike(String value) {
            addCriterion("MATTER_TYPE not like", value, "matterType");
            return (Criteria) this;
        }

        public Criteria andMatterTypeIn(List<String> values) {
            addCriterion("MATTER_TYPE in", values, "matterType");
            return (Criteria) this;
        }

        public Criteria andMatterTypeNotIn(List<String> values) {
            addCriterion("MATTER_TYPE not in", values, "matterType");
            return (Criteria) this;
        }

        public Criteria andMatterTypeBetween(String value1, String value2) {
            addCriterion("MATTER_TYPE between", value1, value2, "matterType");
            return (Criteria) this;
        }

        public Criteria andMatterTypeNotBetween(String value1, String value2) {
            addCriterion("MATTER_TYPE not between", value1, value2, "matterType");
            return (Criteria) this;
        }

        public Criteria andMatterStatusIsNull() {
            addCriterion("MATTER_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andMatterStatusIsNotNull() {
            addCriterion("MATTER_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andMatterStatusEqualTo(String value) {
            addCriterion("MATTER_STATUS =", value, "matterStatus");
            return (Criteria) this;
        }

        public Criteria andMatterStatusNotEqualTo(String value) {
            addCriterion("MATTER_STATUS <>", value, "matterStatus");
            return (Criteria) this;
        }

        public Criteria andMatterStatusGreaterThan(String value) {
            addCriterion("MATTER_STATUS >", value, "matterStatus");
            return (Criteria) this;
        }

        public Criteria andMatterStatusGreaterThanOrEqualTo(String value) {
            addCriterion("MATTER_STATUS >=", value, "matterStatus");
            return (Criteria) this;
        }

        public Criteria andMatterStatusLessThan(String value) {
            addCriterion("MATTER_STATUS <", value, "matterStatus");
            return (Criteria) this;
        }

        public Criteria andMatterStatusLessThanOrEqualTo(String value) {
            addCriterion("MATTER_STATUS <=", value, "matterStatus");
            return (Criteria) this;
        }

        public Criteria andMatterStatusLike(String value) {
            addCriterion("MATTER_STATUS like", value, "matterStatus");
            return (Criteria) this;
        }

        public Criteria andMatterStatusNotLike(String value) {
            addCriterion("MATTER_STATUS not like", value, "matterStatus");
            return (Criteria) this;
        }

        public Criteria andMatterStatusIn(List<String> values) {
            addCriterion("MATTER_STATUS in", values, "matterStatus");
            return (Criteria) this;
        }

        public Criteria andMatterStatusNotIn(List<String> values) {
            addCriterion("MATTER_STATUS not in", values, "matterStatus");
            return (Criteria) this;
        }

        public Criteria andMatterStatusBetween(String value1, String value2) {
            addCriterion("MATTER_STATUS between", value1, value2, "matterStatus");
            return (Criteria) this;
        }

        public Criteria andMatterStatusNotBetween(String value1, String value2) {
            addCriterion("MATTER_STATUS not between", value1, value2, "matterStatus");
            return (Criteria) this;
        }

        public Criteria andMatterDataIdIsNull() {
            addCriterion("MATTER_DATA_ID is null");
            return (Criteria) this;
        }

        public Criteria andMatterDataIdIsNotNull() {
            addCriterion("MATTER_DATA_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMatterDataIdEqualTo(String value) {
            addCriterion("MATTER_DATA_ID =", value, "matterDataId");
            return (Criteria) this;
        }

        public Criteria andMatterDataIdNotEqualTo(String value) {
            addCriterion("MATTER_DATA_ID <>", value, "matterDataId");
            return (Criteria) this;
        }

        public Criteria andMatterDataIdGreaterThan(String value) {
            addCriterion("MATTER_DATA_ID >", value, "matterDataId");
            return (Criteria) this;
        }

        public Criteria andMatterDataIdGreaterThanOrEqualTo(String value) {
            addCriterion("MATTER_DATA_ID >=", value, "matterDataId");
            return (Criteria) this;
        }

        public Criteria andMatterDataIdLessThan(String value) {
            addCriterion("MATTER_DATA_ID <", value, "matterDataId");
            return (Criteria) this;
        }

        public Criteria andMatterDataIdLessThanOrEqualTo(String value) {
            addCriterion("MATTER_DATA_ID <=", value, "matterDataId");
            return (Criteria) this;
        }

        public Criteria andMatterDataIdLike(String value) {
            addCriterion("MATTER_DATA_ID like", value, "matterDataId");
            return (Criteria) this;
        }

        public Criteria andMatterDataIdNotLike(String value) {
            addCriterion("MATTER_DATA_ID not like", value, "matterDataId");
            return (Criteria) this;
        }

        public Criteria andMatterDataIdIn(List<String> values) {
            addCriterion("MATTER_DATA_ID in", values, "matterDataId");
            return (Criteria) this;
        }

        public Criteria andMatterDataIdNotIn(List<String> values) {
            addCriterion("MATTER_DATA_ID not in", values, "matterDataId");
            return (Criteria) this;
        }

        public Criteria andMatterDataIdBetween(String value1, String value2) {
            addCriterion("MATTER_DATA_ID between", value1, value2, "matterDataId");
            return (Criteria) this;
        }

        public Criteria andMatterDataIdNotBetween(String value1, String value2) {
            addCriterion("MATTER_DATA_ID not between", value1, value2, "matterDataId");
            return (Criteria) this;
        }

        public Criteria andMatterDataOrderIsNull() {
            addCriterion("MATTER_DATA_ORDER is null");
            return (Criteria) this;
        }

        public Criteria andMatterDataOrderIsNotNull() {
            addCriterion("MATTER_DATA_ORDER is not null");
            return (Criteria) this;
        }

        public Criteria andMatterDataOrderEqualTo(String value) {
            addCriterion("MATTER_DATA_ORDER =", value, "matterDataOrder");
            return (Criteria) this;
        }

        public Criteria andMatterDataOrderNotEqualTo(String value) {
            addCriterion("MATTER_DATA_ORDER <>", value, "matterDataOrder");
            return (Criteria) this;
        }

        public Criteria andMatterDataOrderGreaterThan(String value) {
            addCriterion("MATTER_DATA_ORDER >", value, "matterDataOrder");
            return (Criteria) this;
        }

        public Criteria andMatterDataOrderGreaterThanOrEqualTo(String value) {
            addCriterion("MATTER_DATA_ORDER >=", value, "matterDataOrder");
            return (Criteria) this;
        }

        public Criteria andMatterDataOrderLessThan(String value) {
            addCriterion("MATTER_DATA_ORDER <", value, "matterDataOrder");
            return (Criteria) this;
        }

        public Criteria andMatterDataOrderLessThanOrEqualTo(String value) {
            addCriterion("MATTER_DATA_ORDER <=", value, "matterDataOrder");
            return (Criteria) this;
        }

        public Criteria andMatterDataOrderLike(String value) {
            addCriterion("MATTER_DATA_ORDER like", value, "matterDataOrder");
            return (Criteria) this;
        }

        public Criteria andMatterDataOrderNotLike(String value) {
            addCriterion("MATTER_DATA_ORDER not like", value, "matterDataOrder");
            return (Criteria) this;
        }

        public Criteria andMatterDataOrderIn(List<String> values) {
            addCriterion("MATTER_DATA_ORDER in", values, "matterDataOrder");
            return (Criteria) this;
        }

        public Criteria andMatterDataOrderNotIn(List<String> values) {
            addCriterion("MATTER_DATA_ORDER not in", values, "matterDataOrder");
            return (Criteria) this;
        }

        public Criteria andMatterDataOrderBetween(String value1, String value2) {
            addCriterion("MATTER_DATA_ORDER between", value1, value2, "matterDataOrder");
            return (Criteria) this;
        }

        public Criteria andMatterDataOrderNotBetween(String value1, String value2) {
            addCriterion("MATTER_DATA_ORDER not between", value1, value2, "matterDataOrder");
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