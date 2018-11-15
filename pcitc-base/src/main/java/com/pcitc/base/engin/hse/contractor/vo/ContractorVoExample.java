package com.pcitc.base.engin.hse.contractor.vo;

import java.util.ArrayList;
import java.util.List;

public class ContractorVoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public ContractorVoExample() {
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

        public Criteria andContractorStatusIsNull() {
            addCriterion("CONTRACTOR_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andContractorStatusIsNotNull() {
            addCriterion("CONTRACTOR_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andContractorStatusEqualTo(String value) {
            addCriterion("CONTRACTOR_STATUS =", value, "contractorStatus");
            return (Criteria) this;
        }

        public Criteria andContractorStatusNotEqualTo(String value) {
            addCriterion("CONTRACTOR_STATUS <>", value, "contractorStatus");
            return (Criteria) this;
        }

        public Criteria andContractorStatusGreaterThan(String value) {
            addCriterion("CONTRACTOR_STATUS >", value, "contractorStatus");
            return (Criteria) this;
        }

        public Criteria andContractorStatusGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACTOR_STATUS >=", value, "contractorStatus");
            return (Criteria) this;
        }

        public Criteria andContractorStatusLessThan(String value) {
            addCriterion("CONTRACTOR_STATUS <", value, "contractorStatus");
            return (Criteria) this;
        }

        public Criteria andContractorStatusLessThanOrEqualTo(String value) {
            addCriterion("CONTRACTOR_STATUS <=", value, "contractorStatus");
            return (Criteria) this;
        }

        public Criteria andContractorStatusLike(String value) {
            addCriterion("CONTRACTOR_STATUS like", value, "contractorStatus");
            return (Criteria) this;
        }

        public Criteria andContractorStatusNotLike(String value) {
            addCriterion("CONTRACTOR_STATUS not like", value, "contractorStatus");
            return (Criteria) this;
        }

        public Criteria andContractorStatusIn(List<String> values) {
            addCriterion("CONTRACTOR_STATUS in", values, "contractorStatus");
            return (Criteria) this;
        }

        public Criteria andContractorStatusNotIn(List<String> values) {
            addCriterion("CONTRACTOR_STATUS not in", values, "contractorStatus");
            return (Criteria) this;
        }

        public Criteria andContractorStatusBetween(String value1, String value2) {
            addCriterion("CONTRACTOR_STATUS between", value1, value2, "contractorStatus");
            return (Criteria) this;
        }

        public Criteria andContractorStatusNotBetween(String value1, String value2) {
            addCriterion("CONTRACTOR_STATUS not between", value1, value2, "contractorStatus");
            return (Criteria) this;
        }

        public Criteria andContractorGenreIsNull() {
            addCriterion("CONTRACTOR_GENRE is null");
            return (Criteria) this;
        }

        public Criteria andContractorGenreIsNotNull() {
            addCriterion("CONTRACTOR_GENRE is not null");
            return (Criteria) this;
        }

        public Criteria andContractorGenreEqualTo(String value) {
            addCriterion("CONTRACTOR_GENRE =", value, "contractorGenre");
            return (Criteria) this;
        }

        public Criteria andContractorGenreNotEqualTo(String value) {
            addCriterion("CONTRACTOR_GENRE <>", value, "contractorGenre");
            return (Criteria) this;
        }

        public Criteria andContractorGenreGreaterThan(String value) {
            addCriterion("CONTRACTOR_GENRE >", value, "contractorGenre");
            return (Criteria) this;
        }

        public Criteria andContractorGenreGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACTOR_GENRE >=", value, "contractorGenre");
            return (Criteria) this;
        }

        public Criteria andContractorGenreLessThan(String value) {
            addCriterion("CONTRACTOR_GENRE <", value, "contractorGenre");
            return (Criteria) this;
        }

        public Criteria andContractorGenreLessThanOrEqualTo(String value) {
            addCriterion("CONTRACTOR_GENRE <=", value, "contractorGenre");
            return (Criteria) this;
        }

        public Criteria andContractorGenreLike(String value) {
            addCriterion("CONTRACTOR_GENRE like", value, "contractorGenre");
            return (Criteria) this;
        }

        public Criteria andContractorGenreNotLike(String value) {
            addCriterion("CONTRACTOR_GENRE not like", value, "contractorGenre");
            return (Criteria) this;
        }

        public Criteria andContractorGenreIn(List<String> values) {
            addCriterion("CONTRACTOR_GENRE in", values, "contractorGenre");
            return (Criteria) this;
        }

        public Criteria andContractorGenreNotIn(List<String> values) {
            addCriterion("CONTRACTOR_GENRE not in", values, "contractorGenre");
            return (Criteria) this;
        }

        public Criteria andContractorGenreBetween(String value1, String value2) {
            addCriterion("CONTRACTOR_GENRE between", value1, value2, "contractorGenre");
            return (Criteria) this;
        }

        public Criteria andContractorGenreNotBetween(String value1, String value2) {
            addCriterion("CONTRACTOR_GENRE not between", value1, value2, "contractorGenre");
            return (Criteria) this;
        }

        public Criteria andContactsIsNull() {
            addCriterion("CONTACTS is null");
            return (Criteria) this;
        }

        public Criteria andContactsIsNotNull() {
            addCriterion("CONTACTS is not null");
            return (Criteria) this;
        }

        public Criteria andContactsEqualTo(String value) {
            addCriterion("CONTACTS =", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotEqualTo(String value) {
            addCriterion("CONTACTS <>", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsGreaterThan(String value) {
            addCriterion("CONTACTS >", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsGreaterThanOrEqualTo(String value) {
            addCriterion("CONTACTS >=", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLessThan(String value) {
            addCriterion("CONTACTS <", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLessThanOrEqualTo(String value) {
            addCriterion("CONTACTS <=", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLike(String value) {
            addCriterion("CONTACTS like", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotLike(String value) {
            addCriterion("CONTACTS not like", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsIn(List<String> values) {
            addCriterion("CONTACTS in", values, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotIn(List<String> values) {
            addCriterion("CONTACTS not in", values, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsBetween(String value1, String value2) {
            addCriterion("CONTACTS between", value1, value2, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotBetween(String value1, String value2) {
            addCriterion("CONTACTS not between", value1, value2, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneIsNull() {
            addCriterion("CONTACTS_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneIsNotNull() {
            addCriterion("CONTACTS_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneEqualTo(String value) {
            addCriterion("CONTACTS_PHONE =", value, "contactsPhone");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneNotEqualTo(String value) {
            addCriterion("CONTACTS_PHONE <>", value, "contactsPhone");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneGreaterThan(String value) {
            addCriterion("CONTACTS_PHONE >", value, "contactsPhone");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("CONTACTS_PHONE >=", value, "contactsPhone");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneLessThan(String value) {
            addCriterion("CONTACTS_PHONE <", value, "contactsPhone");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneLessThanOrEqualTo(String value) {
            addCriterion("CONTACTS_PHONE <=", value, "contactsPhone");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneLike(String value) {
            addCriterion("CONTACTS_PHONE like", value, "contactsPhone");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneNotLike(String value) {
            addCriterion("CONTACTS_PHONE not like", value, "contactsPhone");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneIn(List<String> values) {
            addCriterion("CONTACTS_PHONE in", values, "contactsPhone");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneNotIn(List<String> values) {
            addCriterion("CONTACTS_PHONE not in", values, "contactsPhone");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneBetween(String value1, String value2) {
            addCriterion("CONTACTS_PHONE between", value1, value2, "contactsPhone");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneNotBetween(String value1, String value2) {
            addCriterion("CONTACTS_PHONE not between", value1, value2, "contactsPhone");
            return (Criteria) this;
        }

        public Criteria andContactsAddressIsNull() {
            addCriterion("CONTACTS_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andContactsAddressIsNotNull() {
            addCriterion("CONTACTS_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andContactsAddressEqualTo(String value) {
            addCriterion("CONTACTS_ADDRESS =", value, "contactsAddress");
            return (Criteria) this;
        }

        public Criteria andContactsAddressNotEqualTo(String value) {
            addCriterion("CONTACTS_ADDRESS <>", value, "contactsAddress");
            return (Criteria) this;
        }

        public Criteria andContactsAddressGreaterThan(String value) {
            addCriterion("CONTACTS_ADDRESS >", value, "contactsAddress");
            return (Criteria) this;
        }

        public Criteria andContactsAddressGreaterThanOrEqualTo(String value) {
            addCriterion("CONTACTS_ADDRESS >=", value, "contactsAddress");
            return (Criteria) this;
        }

        public Criteria andContactsAddressLessThan(String value) {
            addCriterion("CONTACTS_ADDRESS <", value, "contactsAddress");
            return (Criteria) this;
        }

        public Criteria andContactsAddressLessThanOrEqualTo(String value) {
            addCriterion("CONTACTS_ADDRESS <=", value, "contactsAddress");
            return (Criteria) this;
        }

        public Criteria andContactsAddressLike(String value) {
            addCriterion("CONTACTS_ADDRESS like", value, "contactsAddress");
            return (Criteria) this;
        }

        public Criteria andContactsAddressNotLike(String value) {
            addCriterion("CONTACTS_ADDRESS not like", value, "contactsAddress");
            return (Criteria) this;
        }

        public Criteria andContactsAddressIn(List<String> values) {
            addCriterion("CONTACTS_ADDRESS in", values, "contactsAddress");
            return (Criteria) this;
        }

        public Criteria andContactsAddressNotIn(List<String> values) {
            addCriterion("CONTACTS_ADDRESS not in", values, "contactsAddress");
            return (Criteria) this;
        }

        public Criteria andContactsAddressBetween(String value1, String value2) {
            addCriterion("CONTACTS_ADDRESS between", value1, value2, "contactsAddress");
            return (Criteria) this;
        }

        public Criteria andContactsAddressNotBetween(String value1, String value2) {
            addCriterion("CONTACTS_ADDRESS not between", value1, value2, "contactsAddress");
            return (Criteria) this;
        }

        public Criteria andCorporationIsNull() {
            addCriterion("CORPORATION is null");
            return (Criteria) this;
        }

        public Criteria andCorporationIsNotNull() {
            addCriterion("CORPORATION is not null");
            return (Criteria) this;
        }

        public Criteria andCorporationEqualTo(String value) {
            addCriterion("CORPORATION =", value, "corporation");
            return (Criteria) this;
        }

        public Criteria andCorporationNotEqualTo(String value) {
            addCriterion("CORPORATION <>", value, "corporation");
            return (Criteria) this;
        }

        public Criteria andCorporationGreaterThan(String value) {
            addCriterion("CORPORATION >", value, "corporation");
            return (Criteria) this;
        }

        public Criteria andCorporationGreaterThanOrEqualTo(String value) {
            addCriterion("CORPORATION >=", value, "corporation");
            return (Criteria) this;
        }

        public Criteria andCorporationLessThan(String value) {
            addCriterion("CORPORATION <", value, "corporation");
            return (Criteria) this;
        }

        public Criteria andCorporationLessThanOrEqualTo(String value) {
            addCriterion("CORPORATION <=", value, "corporation");
            return (Criteria) this;
        }

        public Criteria andCorporationLike(String value) {
            addCriterion("CORPORATION like", value, "corporation");
            return (Criteria) this;
        }

        public Criteria andCorporationNotLike(String value) {
            addCriterion("CORPORATION not like", value, "corporation");
            return (Criteria) this;
        }

        public Criteria andCorporationIn(List<String> values) {
            addCriterion("CORPORATION in", values, "corporation");
            return (Criteria) this;
        }

        public Criteria andCorporationNotIn(List<String> values) {
            addCriterion("CORPORATION not in", values, "corporation");
            return (Criteria) this;
        }

        public Criteria andCorporationBetween(String value1, String value2) {
            addCriterion("CORPORATION between", value1, value2, "corporation");
            return (Criteria) this;
        }

        public Criteria andCorporationNotBetween(String value1, String value2) {
            addCriterion("CORPORATION not between", value1, value2, "corporation");
            return (Criteria) this;
        }

        public Criteria andTaxCodeIsNull() {
            addCriterion("TAX_CODE is null");
            return (Criteria) this;
        }

        public Criteria andTaxCodeIsNotNull() {
            addCriterion("TAX_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andTaxCodeEqualTo(String value) {
            addCriterion("TAX_CODE =", value, "taxCode");
            return (Criteria) this;
        }

        public Criteria andTaxCodeNotEqualTo(String value) {
            addCriterion("TAX_CODE <>", value, "taxCode");
            return (Criteria) this;
        }

        public Criteria andTaxCodeGreaterThan(String value) {
            addCriterion("TAX_CODE >", value, "taxCode");
            return (Criteria) this;
        }

        public Criteria andTaxCodeGreaterThanOrEqualTo(String value) {
            addCriterion("TAX_CODE >=", value, "taxCode");
            return (Criteria) this;
        }

        public Criteria andTaxCodeLessThan(String value) {
            addCriterion("TAX_CODE <", value, "taxCode");
            return (Criteria) this;
        }

        public Criteria andTaxCodeLessThanOrEqualTo(String value) {
            addCriterion("TAX_CODE <=", value, "taxCode");
            return (Criteria) this;
        }

        public Criteria andTaxCodeLike(String value) {
            addCriterion("TAX_CODE like", value, "taxCode");
            return (Criteria) this;
        }

        public Criteria andTaxCodeNotLike(String value) {
            addCriterion("TAX_CODE not like", value, "taxCode");
            return (Criteria) this;
        }

        public Criteria andTaxCodeIn(List<String> values) {
            addCriterion("TAX_CODE in", values, "taxCode");
            return (Criteria) this;
        }

        public Criteria andTaxCodeNotIn(List<String> values) {
            addCriterion("TAX_CODE not in", values, "taxCode");
            return (Criteria) this;
        }

        public Criteria andTaxCodeBetween(String value1, String value2) {
            addCriterion("TAX_CODE between", value1, value2, "taxCode");
            return (Criteria) this;
        }

        public Criteria andTaxCodeNotBetween(String value1, String value2) {
            addCriterion("TAX_CODE not between", value1, value2, "taxCode");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNull() {
            addCriterion("BANK_NAME is null");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNotNull() {
            addCriterion("BANK_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andBankNameEqualTo(String value) {
            addCriterion("BANK_NAME =", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotEqualTo(String value) {
            addCriterion("BANK_NAME <>", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThan(String value) {
            addCriterion("BANK_NAME >", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("BANK_NAME >=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThan(String value) {
            addCriterion("BANK_NAME <", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThanOrEqualTo(String value) {
            addCriterion("BANK_NAME <=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLike(String value) {
            addCriterion("BANK_NAME like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotLike(String value) {
            addCriterion("BANK_NAME not like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameIn(List<String> values) {
            addCriterion("BANK_NAME in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotIn(List<String> values) {
            addCriterion("BANK_NAME not in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameBetween(String value1, String value2) {
            addCriterion("BANK_NAME between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotBetween(String value1, String value2) {
            addCriterion("BANK_NAME not between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankCodeIsNull() {
            addCriterion("BANK_CODE is null");
            return (Criteria) this;
        }

        public Criteria andBankCodeIsNotNull() {
            addCriterion("BANK_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andBankCodeEqualTo(String value) {
            addCriterion("BANK_CODE =", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotEqualTo(String value) {
            addCriterion("BANK_CODE <>", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeGreaterThan(String value) {
            addCriterion("BANK_CODE >", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeGreaterThanOrEqualTo(String value) {
            addCriterion("BANK_CODE >=", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeLessThan(String value) {
            addCriterion("BANK_CODE <", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeLessThanOrEqualTo(String value) {
            addCriterion("BANK_CODE <=", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeLike(String value) {
            addCriterion("BANK_CODE like", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotLike(String value) {
            addCriterion("BANK_CODE not like", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeIn(List<String> values) {
            addCriterion("BANK_CODE in", values, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotIn(List<String> values) {
            addCriterion("BANK_CODE not in", values, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeBetween(String value1, String value2) {
            addCriterion("BANK_CODE between", value1, value2, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotBetween(String value1, String value2) {
            addCriterion("BANK_CODE not between", value1, value2, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNull() {
            addCriterion("BANK_ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNotNull() {
            addCriterion("BANK_ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andBankAccountEqualTo(String value) {
            addCriterion("BANK_ACCOUNT =", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotEqualTo(String value) {
            addCriterion("BANK_ACCOUNT <>", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThan(String value) {
            addCriterion("BANK_ACCOUNT >", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThanOrEqualTo(String value) {
            addCriterion("BANK_ACCOUNT >=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThan(String value) {
            addCriterion("BANK_ACCOUNT <", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThanOrEqualTo(String value) {
            addCriterion("BANK_ACCOUNT <=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLike(String value) {
            addCriterion("BANK_ACCOUNT like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotLike(String value) {
            addCriterion("BANK_ACCOUNT not like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountIn(List<String> values) {
            addCriterion("BANK_ACCOUNT in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotIn(List<String> values) {
            addCriterion("BANK_ACCOUNT not in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountBetween(String value1, String value2) {
            addCriterion("BANK_ACCOUNT between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotBetween(String value1, String value2) {
            addCriterion("BANK_ACCOUNT not between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitCodeIsNull() {
            addCriterion("PURCHASE_UNIT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitCodeIsNotNull() {
            addCriterion("PURCHASE_UNIT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitCodeEqualTo(String value) {
            addCriterion("PURCHASE_UNIT_CODE =", value, "purchaseUnitCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitCodeNotEqualTo(String value) {
            addCriterion("PURCHASE_UNIT_CODE <>", value, "purchaseUnitCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitCodeGreaterThan(String value) {
            addCriterion("PURCHASE_UNIT_CODE >", value, "purchaseUnitCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PURCHASE_UNIT_CODE >=", value, "purchaseUnitCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitCodeLessThan(String value) {
            addCriterion("PURCHASE_UNIT_CODE <", value, "purchaseUnitCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitCodeLessThanOrEqualTo(String value) {
            addCriterion("PURCHASE_UNIT_CODE <=", value, "purchaseUnitCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitCodeLike(String value) {
            addCriterion("PURCHASE_UNIT_CODE like", value, "purchaseUnitCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitCodeNotLike(String value) {
            addCriterion("PURCHASE_UNIT_CODE not like", value, "purchaseUnitCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitCodeIn(List<String> values) {
            addCriterion("PURCHASE_UNIT_CODE in", values, "purchaseUnitCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitCodeNotIn(List<String> values) {
            addCriterion("PURCHASE_UNIT_CODE not in", values, "purchaseUnitCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitCodeBetween(String value1, String value2) {
            addCriterion("PURCHASE_UNIT_CODE between", value1, value2, "purchaseUnitCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitCodeNotBetween(String value1, String value2) {
            addCriterion("PURCHASE_UNIT_CODE not between", value1, value2, "purchaseUnitCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitNameIsNull() {
            addCriterion("PURCHASE_UNIT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitNameIsNotNull() {
            addCriterion("PURCHASE_UNIT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitNameEqualTo(String value) {
            addCriterion("PURCHASE_UNIT_NAME =", value, "purchaseUnitName");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitNameNotEqualTo(String value) {
            addCriterion("PURCHASE_UNIT_NAME <>", value, "purchaseUnitName");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitNameGreaterThan(String value) {
            addCriterion("PURCHASE_UNIT_NAME >", value, "purchaseUnitName");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitNameGreaterThanOrEqualTo(String value) {
            addCriterion("PURCHASE_UNIT_NAME >=", value, "purchaseUnitName");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitNameLessThan(String value) {
            addCriterion("PURCHASE_UNIT_NAME <", value, "purchaseUnitName");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitNameLessThanOrEqualTo(String value) {
            addCriterion("PURCHASE_UNIT_NAME <=", value, "purchaseUnitName");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitNameLike(String value) {
            addCriterion("PURCHASE_UNIT_NAME like", value, "purchaseUnitName");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitNameNotLike(String value) {
            addCriterion("PURCHASE_UNIT_NAME not like", value, "purchaseUnitName");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitNameIn(List<String> values) {
            addCriterion("PURCHASE_UNIT_NAME in", values, "purchaseUnitName");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitNameNotIn(List<String> values) {
            addCriterion("PURCHASE_UNIT_NAME not in", values, "purchaseUnitName");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitNameBetween(String value1, String value2) {
            addCriterion("PURCHASE_UNIT_NAME between", value1, value2, "purchaseUnitName");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitNameNotBetween(String value1, String value2) {
            addCriterion("PURCHASE_UNIT_NAME not between", value1, value2, "purchaseUnitName");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitIdIsNull() {
            addCriterion("PURCHASE_UNIT_ID is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitIdIsNotNull() {
            addCriterion("PURCHASE_UNIT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitIdEqualTo(String value) {
            addCriterion("PURCHASE_UNIT_ID =", value, "purchaseUnitId");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitIdNotEqualTo(String value) {
            addCriterion("PURCHASE_UNIT_ID <>", value, "purchaseUnitId");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitIdGreaterThan(String value) {
            addCriterion("PURCHASE_UNIT_ID >", value, "purchaseUnitId");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitIdGreaterThanOrEqualTo(String value) {
            addCriterion("PURCHASE_UNIT_ID >=", value, "purchaseUnitId");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitIdLessThan(String value) {
            addCriterion("PURCHASE_UNIT_ID <", value, "purchaseUnitId");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitIdLessThanOrEqualTo(String value) {
            addCriterion("PURCHASE_UNIT_ID <=", value, "purchaseUnitId");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitIdLike(String value) {
            addCriterion("PURCHASE_UNIT_ID like", value, "purchaseUnitId");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitIdNotLike(String value) {
            addCriterion("PURCHASE_UNIT_ID not like", value, "purchaseUnitId");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitIdIn(List<String> values) {
            addCriterion("PURCHASE_UNIT_ID in", values, "purchaseUnitId");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitIdNotIn(List<String> values) {
            addCriterion("PURCHASE_UNIT_ID not in", values, "purchaseUnitId");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitIdBetween(String value1, String value2) {
            addCriterion("PURCHASE_UNIT_ID between", value1, value2, "purchaseUnitId");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitIdNotBetween(String value1, String value2) {
            addCriterion("PURCHASE_UNIT_ID not between", value1, value2, "purchaseUnitId");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressIsNull() {
            addCriterion("REGISTERED_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressIsNotNull() {
            addCriterion("REGISTERED_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressEqualTo(String value) {
            addCriterion("REGISTERED_ADDRESS =", value, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressNotEqualTo(String value) {
            addCriterion("REGISTERED_ADDRESS <>", value, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressGreaterThan(String value) {
            addCriterion("REGISTERED_ADDRESS >", value, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressGreaterThanOrEqualTo(String value) {
            addCriterion("REGISTERED_ADDRESS >=", value, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressLessThan(String value) {
            addCriterion("REGISTERED_ADDRESS <", value, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressLessThanOrEqualTo(String value) {
            addCriterion("REGISTERED_ADDRESS <=", value, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressLike(String value) {
            addCriterion("REGISTERED_ADDRESS like", value, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressNotLike(String value) {
            addCriterion("REGISTERED_ADDRESS not like", value, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressIn(List<String> values) {
            addCriterion("REGISTERED_ADDRESS in", values, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressNotIn(List<String> values) {
            addCriterion("REGISTERED_ADDRESS not in", values, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressBetween(String value1, String value2) {
            addCriterion("REGISTERED_ADDRESS between", value1, value2, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressNotBetween(String value1, String value2) {
            addCriterion("REGISTERED_ADDRESS not between", value1, value2, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIsNull() {
            addCriterion("BUSINESS_SCOPE is null");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIsNotNull() {
            addCriterion("BUSINESS_SCOPE is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeEqualTo(String value) {
            addCriterion("BUSINESS_SCOPE =", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotEqualTo(String value) {
            addCriterion("BUSINESS_SCOPE <>", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeGreaterThan(String value) {
            addCriterion("BUSINESS_SCOPE >", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESS_SCOPE >=", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLessThan(String value) {
            addCriterion("BUSINESS_SCOPE <", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLessThanOrEqualTo(String value) {
            addCriterion("BUSINESS_SCOPE <=", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLike(String value) {
            addCriterion("BUSINESS_SCOPE like", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotLike(String value) {
            addCriterion("BUSINESS_SCOPE not like", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIn(List<String> values) {
            addCriterion("BUSINESS_SCOPE in", values, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotIn(List<String> values) {
            addCriterion("BUSINESS_SCOPE not in", values, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeBetween(String value1, String value2) {
            addCriterion("BUSINESS_SCOPE between", value1, value2, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotBetween(String value1, String value2) {
            addCriterion("BUSINESS_SCOPE not between", value1, value2, "businessScope");
            return (Criteria) this;
        }

        public Criteria andLicenseCodeIsNull() {
            addCriterion("LICENSE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andLicenseCodeIsNotNull() {
            addCriterion("LICENSE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseCodeEqualTo(String value) {
            addCriterion("LICENSE_CODE =", value, "licenseCode");
            return (Criteria) this;
        }

        public Criteria andLicenseCodeNotEqualTo(String value) {
            addCriterion("LICENSE_CODE <>", value, "licenseCode");
            return (Criteria) this;
        }

        public Criteria andLicenseCodeGreaterThan(String value) {
            addCriterion("LICENSE_CODE >", value, "licenseCode");
            return (Criteria) this;
        }

        public Criteria andLicenseCodeGreaterThanOrEqualTo(String value) {
            addCriterion("LICENSE_CODE >=", value, "licenseCode");
            return (Criteria) this;
        }

        public Criteria andLicenseCodeLessThan(String value) {
            addCriterion("LICENSE_CODE <", value, "licenseCode");
            return (Criteria) this;
        }

        public Criteria andLicenseCodeLessThanOrEqualTo(String value) {
            addCriterion("LICENSE_CODE <=", value, "licenseCode");
            return (Criteria) this;
        }

        public Criteria andLicenseCodeLike(String value) {
            addCriterion("LICENSE_CODE like", value, "licenseCode");
            return (Criteria) this;
        }

        public Criteria andLicenseCodeNotLike(String value) {
            addCriterion("LICENSE_CODE not like", value, "licenseCode");
            return (Criteria) this;
        }

        public Criteria andLicenseCodeIn(List<String> values) {
            addCriterion("LICENSE_CODE in", values, "licenseCode");
            return (Criteria) this;
        }

        public Criteria andLicenseCodeNotIn(List<String> values) {
            addCriterion("LICENSE_CODE not in", values, "licenseCode");
            return (Criteria) this;
        }

        public Criteria andLicenseCodeBetween(String value1, String value2) {
            addCriterion("LICENSE_CODE between", value1, value2, "licenseCode");
            return (Criteria) this;
        }

        public Criteria andLicenseCodeNotBetween(String value1, String value2) {
            addCriterion("LICENSE_CODE not between", value1, value2, "licenseCode");
            return (Criteria) this;
        }

        public Criteria andLicenseStartDateIsNull() {
            addCriterion("LICENSE_START_DATE is null");
            return (Criteria) this;
        }

        public Criteria andLicenseStartDateIsNotNull() {
            addCriterion("LICENSE_START_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseStartDateEqualTo(String value) {
            addCriterion("LICENSE_START_DATE =", value, "licenseStartDate");
            return (Criteria) this;
        }

        public Criteria andLicenseStartDateNotEqualTo(String value) {
            addCriterion("LICENSE_START_DATE <>", value, "licenseStartDate");
            return (Criteria) this;
        }

        public Criteria andLicenseStartDateGreaterThan(String value) {
            addCriterion("LICENSE_START_DATE >", value, "licenseStartDate");
            return (Criteria) this;
        }

        public Criteria andLicenseStartDateGreaterThanOrEqualTo(String value) {
            addCriterion("LICENSE_START_DATE >=", value, "licenseStartDate");
            return (Criteria) this;
        }

        public Criteria andLicenseStartDateLessThan(String value) {
            addCriterion("LICENSE_START_DATE <", value, "licenseStartDate");
            return (Criteria) this;
        }

        public Criteria andLicenseStartDateLessThanOrEqualTo(String value) {
            addCriterion("LICENSE_START_DATE <=", value, "licenseStartDate");
            return (Criteria) this;
        }

        public Criteria andLicenseStartDateLike(String value) {
            addCriterion("LICENSE_START_DATE like", value, "licenseStartDate");
            return (Criteria) this;
        }

        public Criteria andLicenseStartDateNotLike(String value) {
            addCriterion("LICENSE_START_DATE not like", value, "licenseStartDate");
            return (Criteria) this;
        }

        public Criteria andLicenseStartDateIn(List<String> values) {
            addCriterion("LICENSE_START_DATE in", values, "licenseStartDate");
            return (Criteria) this;
        }

        public Criteria andLicenseStartDateNotIn(List<String> values) {
            addCriterion("LICENSE_START_DATE not in", values, "licenseStartDate");
            return (Criteria) this;
        }

        public Criteria andLicenseStartDateBetween(String value1, String value2) {
            addCriterion("LICENSE_START_DATE between", value1, value2, "licenseStartDate");
            return (Criteria) this;
        }

        public Criteria andLicenseStartDateNotBetween(String value1, String value2) {
            addCriterion("LICENSE_START_DATE not between", value1, value2, "licenseStartDate");
            return (Criteria) this;
        }

        public Criteria andLicenseEndDateIsNull() {
            addCriterion("LICENSE_END_DATE is null");
            return (Criteria) this;
        }

        public Criteria andLicenseEndDateIsNotNull() {
            addCriterion("LICENSE_END_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseEndDateEqualTo(String value) {
            addCriterion("LICENSE_END_DATE =", value, "licenseEndDate");
            return (Criteria) this;
        }

        public Criteria andLicenseEndDateNotEqualTo(String value) {
            addCriterion("LICENSE_END_DATE <>", value, "licenseEndDate");
            return (Criteria) this;
        }

        public Criteria andLicenseEndDateGreaterThan(String value) {
            addCriterion("LICENSE_END_DATE >", value, "licenseEndDate");
            return (Criteria) this;
        }

        public Criteria andLicenseEndDateGreaterThanOrEqualTo(String value) {
            addCriterion("LICENSE_END_DATE >=", value, "licenseEndDate");
            return (Criteria) this;
        }

        public Criteria andLicenseEndDateLessThan(String value) {
            addCriterion("LICENSE_END_DATE <", value, "licenseEndDate");
            return (Criteria) this;
        }

        public Criteria andLicenseEndDateLessThanOrEqualTo(String value) {
            addCriterion("LICENSE_END_DATE <=", value, "licenseEndDate");
            return (Criteria) this;
        }

        public Criteria andLicenseEndDateLike(String value) {
            addCriterion("LICENSE_END_DATE like", value, "licenseEndDate");
            return (Criteria) this;
        }

        public Criteria andLicenseEndDateNotLike(String value) {
            addCriterion("LICENSE_END_DATE not like", value, "licenseEndDate");
            return (Criteria) this;
        }

        public Criteria andLicenseEndDateIn(List<String> values) {
            addCriterion("LICENSE_END_DATE in", values, "licenseEndDate");
            return (Criteria) this;
        }

        public Criteria andLicenseEndDateNotIn(List<String> values) {
            addCriterion("LICENSE_END_DATE not in", values, "licenseEndDate");
            return (Criteria) this;
        }

        public Criteria andLicenseEndDateBetween(String value1, String value2) {
            addCriterion("LICENSE_END_DATE between", value1, value2, "licenseEndDate");
            return (Criteria) this;
        }

        public Criteria andLicenseEndDateNotBetween(String value1, String value2) {
            addCriterion("LICENSE_END_DATE not between", value1, value2, "licenseEndDate");
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