package com.pcitc.base.engin.quality.examine.vo;

import java.util.ArrayList;
import java.util.List;

public class QualityMonthlySupervisionExamineVoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public QualityMonthlySupervisionExamineVoExample() {
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

        public Criteria andExamineUnitNameIsNull() {
            addCriterion("EXAMINE_UNIT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andExamineUnitNameIsNotNull() {
            addCriterion("EXAMINE_UNIT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andExamineUnitNameEqualTo(String value) {
            addCriterion("EXAMINE_UNIT_NAME =", value, "examineUnitName");
            return (Criteria) this;
        }

        public Criteria andExamineUnitNameNotEqualTo(String value) {
            addCriterion("EXAMINE_UNIT_NAME <>", value, "examineUnitName");
            return (Criteria) this;
        }

        public Criteria andExamineUnitNameGreaterThan(String value) {
            addCriterion("EXAMINE_UNIT_NAME >", value, "examineUnitName");
            return (Criteria) this;
        }

        public Criteria andExamineUnitNameGreaterThanOrEqualTo(String value) {
            addCriterion("EXAMINE_UNIT_NAME >=", value, "examineUnitName");
            return (Criteria) this;
        }

        public Criteria andExamineUnitNameLessThan(String value) {
            addCriterion("EXAMINE_UNIT_NAME <", value, "examineUnitName");
            return (Criteria) this;
        }

        public Criteria andExamineUnitNameLessThanOrEqualTo(String value) {
            addCriterion("EXAMINE_UNIT_NAME <=", value, "examineUnitName");
            return (Criteria) this;
        }

        public Criteria andExamineUnitNameLike(String value) {
            addCriterion("EXAMINE_UNIT_NAME like", value, "examineUnitName");
            return (Criteria) this;
        }

        public Criteria andExamineUnitNameNotLike(String value) {
            addCriterion("EXAMINE_UNIT_NAME not like", value, "examineUnitName");
            return (Criteria) this;
        }

        public Criteria andExamineUnitNameIn(List<String> values) {
            addCriterion("EXAMINE_UNIT_NAME in", values, "examineUnitName");
            return (Criteria) this;
        }

        public Criteria andExamineUnitNameNotIn(List<String> values) {
            addCriterion("EXAMINE_UNIT_NAME not in", values, "examineUnitName");
            return (Criteria) this;
        }

        public Criteria andExamineUnitNameBetween(String value1, String value2) {
            addCriterion("EXAMINE_UNIT_NAME between", value1, value2, "examineUnitName");
            return (Criteria) this;
        }

        public Criteria andExamineUnitNameNotBetween(String value1, String value2) {
            addCriterion("EXAMINE_UNIT_NAME not between", value1, value2, "examineUnitName");
            return (Criteria) this;
        }

        public Criteria andExamineUnitCodeIsNull() {
            addCriterion("EXAMINE_UNIT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andExamineUnitCodeIsNotNull() {
            addCriterion("EXAMINE_UNIT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andExamineUnitCodeEqualTo(String value) {
            addCriterion("EXAMINE_UNIT_CODE =", value, "examineUnitCode");
            return (Criteria) this;
        }

        public Criteria andExamineUnitCodeNotEqualTo(String value) {
            addCriterion("EXAMINE_UNIT_CODE <>", value, "examineUnitCode");
            return (Criteria) this;
        }

        public Criteria andExamineUnitCodeGreaterThan(String value) {
            addCriterion("EXAMINE_UNIT_CODE >", value, "examineUnitCode");
            return (Criteria) this;
        }

        public Criteria andExamineUnitCodeGreaterThanOrEqualTo(String value) {
            addCriterion("EXAMINE_UNIT_CODE >=", value, "examineUnitCode");
            return (Criteria) this;
        }

        public Criteria andExamineUnitCodeLessThan(String value) {
            addCriterion("EXAMINE_UNIT_CODE <", value, "examineUnitCode");
            return (Criteria) this;
        }

        public Criteria andExamineUnitCodeLessThanOrEqualTo(String value) {
            addCriterion("EXAMINE_UNIT_CODE <=", value, "examineUnitCode");
            return (Criteria) this;
        }

        public Criteria andExamineUnitCodeLike(String value) {
            addCriterion("EXAMINE_UNIT_CODE like", value, "examineUnitCode");
            return (Criteria) this;
        }

        public Criteria andExamineUnitCodeNotLike(String value) {
            addCriterion("EXAMINE_UNIT_CODE not like", value, "examineUnitCode");
            return (Criteria) this;
        }

        public Criteria andExamineUnitCodeIn(List<String> values) {
            addCriterion("EXAMINE_UNIT_CODE in", values, "examineUnitCode");
            return (Criteria) this;
        }

        public Criteria andExamineUnitCodeNotIn(List<String> values) {
            addCriterion("EXAMINE_UNIT_CODE not in", values, "examineUnitCode");
            return (Criteria) this;
        }

        public Criteria andExamineUnitCodeBetween(String value1, String value2) {
            addCriterion("EXAMINE_UNIT_CODE between", value1, value2, "examineUnitCode");
            return (Criteria) this;
        }

        public Criteria andExamineUnitCodeNotBetween(String value1, String value2) {
            addCriterion("EXAMINE_UNIT_CODE not between", value1, value2, "examineUnitCode");
            return (Criteria) this;
        }

        public Criteria andExamineUnitIdIsNull() {
            addCriterion("EXAMINE_UNIT_ID is null");
            return (Criteria) this;
        }

        public Criteria andExamineUnitIdIsNotNull() {
            addCriterion("EXAMINE_UNIT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andExamineUnitIdEqualTo(String value) {
            addCriterion("EXAMINE_UNIT_ID =", value, "examineUnitId");
            return (Criteria) this;
        }

        public Criteria andExamineUnitIdNotEqualTo(String value) {
            addCriterion("EXAMINE_UNIT_ID <>", value, "examineUnitId");
            return (Criteria) this;
        }

        public Criteria andExamineUnitIdGreaterThan(String value) {
            addCriterion("EXAMINE_UNIT_ID >", value, "examineUnitId");
            return (Criteria) this;
        }

        public Criteria andExamineUnitIdGreaterThanOrEqualTo(String value) {
            addCriterion("EXAMINE_UNIT_ID >=", value, "examineUnitId");
            return (Criteria) this;
        }

        public Criteria andExamineUnitIdLessThan(String value) {
            addCriterion("EXAMINE_UNIT_ID <", value, "examineUnitId");
            return (Criteria) this;
        }

        public Criteria andExamineUnitIdLessThanOrEqualTo(String value) {
            addCriterion("EXAMINE_UNIT_ID <=", value, "examineUnitId");
            return (Criteria) this;
        }

        public Criteria andExamineUnitIdLike(String value) {
            addCriterion("EXAMINE_UNIT_ID like", value, "examineUnitId");
            return (Criteria) this;
        }

        public Criteria andExamineUnitIdNotLike(String value) {
            addCriterion("EXAMINE_UNIT_ID not like", value, "examineUnitId");
            return (Criteria) this;
        }

        public Criteria andExamineUnitIdIn(List<String> values) {
            addCriterion("EXAMINE_UNIT_ID in", values, "examineUnitId");
            return (Criteria) this;
        }

        public Criteria andExamineUnitIdNotIn(List<String> values) {
            addCriterion("EXAMINE_UNIT_ID not in", values, "examineUnitId");
            return (Criteria) this;
        }

        public Criteria andExamineUnitIdBetween(String value1, String value2) {
            addCriterion("EXAMINE_UNIT_ID between", value1, value2, "examineUnitId");
            return (Criteria) this;
        }

        public Criteria andExamineUnitIdNotBetween(String value1, String value2) {
            addCriterion("EXAMINE_UNIT_ID not between", value1, value2, "examineUnitId");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitNameIsNull() {
            addCriterion("BEING_EXAMINE_UNIT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitNameIsNotNull() {
            addCriterion("BEING_EXAMINE_UNIT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitNameEqualTo(String value) {
            addCriterion("BEING_EXAMINE_UNIT_NAME =", value, "beingExamineUnitName");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitNameNotEqualTo(String value) {
            addCriterion("BEING_EXAMINE_UNIT_NAME <>", value, "beingExamineUnitName");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitNameGreaterThan(String value) {
            addCriterion("BEING_EXAMINE_UNIT_NAME >", value, "beingExamineUnitName");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitNameGreaterThanOrEqualTo(String value) {
            addCriterion("BEING_EXAMINE_UNIT_NAME >=", value, "beingExamineUnitName");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitNameLessThan(String value) {
            addCriterion("BEING_EXAMINE_UNIT_NAME <", value, "beingExamineUnitName");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitNameLessThanOrEqualTo(String value) {
            addCriterion("BEING_EXAMINE_UNIT_NAME <=", value, "beingExamineUnitName");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitNameLike(String value) {
            addCriterion("BEING_EXAMINE_UNIT_NAME like", value, "beingExamineUnitName");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitNameNotLike(String value) {
            addCriterion("BEING_EXAMINE_UNIT_NAME not like", value, "beingExamineUnitName");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitNameIn(List<String> values) {
            addCriterion("BEING_EXAMINE_UNIT_NAME in", values, "beingExamineUnitName");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitNameNotIn(List<String> values) {
            addCriterion("BEING_EXAMINE_UNIT_NAME not in", values, "beingExamineUnitName");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitNameBetween(String value1, String value2) {
            addCriterion("BEING_EXAMINE_UNIT_NAME between", value1, value2, "beingExamineUnitName");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitNameNotBetween(String value1, String value2) {
            addCriterion("BEING_EXAMINE_UNIT_NAME not between", value1, value2, "beingExamineUnitName");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitCodeIsNull() {
            addCriterion("BEING_EXAMINE_UNIT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitCodeIsNotNull() {
            addCriterion("BEING_EXAMINE_UNIT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitCodeEqualTo(String value) {
            addCriterion("BEING_EXAMINE_UNIT_CODE =", value, "beingExamineUnitCode");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitCodeNotEqualTo(String value) {
            addCriterion("BEING_EXAMINE_UNIT_CODE <>", value, "beingExamineUnitCode");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitCodeGreaterThan(String value) {
            addCriterion("BEING_EXAMINE_UNIT_CODE >", value, "beingExamineUnitCode");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitCodeGreaterThanOrEqualTo(String value) {
            addCriterion("BEING_EXAMINE_UNIT_CODE >=", value, "beingExamineUnitCode");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitCodeLessThan(String value) {
            addCriterion("BEING_EXAMINE_UNIT_CODE <", value, "beingExamineUnitCode");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitCodeLessThanOrEqualTo(String value) {
            addCriterion("BEING_EXAMINE_UNIT_CODE <=", value, "beingExamineUnitCode");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitCodeLike(String value) {
            addCriterion("BEING_EXAMINE_UNIT_CODE like", value, "beingExamineUnitCode");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitCodeNotLike(String value) {
            addCriterion("BEING_EXAMINE_UNIT_CODE not like", value, "beingExamineUnitCode");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitCodeIn(List<String> values) {
            addCriterion("BEING_EXAMINE_UNIT_CODE in", values, "beingExamineUnitCode");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitCodeNotIn(List<String> values) {
            addCriterion("BEING_EXAMINE_UNIT_CODE not in", values, "beingExamineUnitCode");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitCodeBetween(String value1, String value2) {
            addCriterion("BEING_EXAMINE_UNIT_CODE between", value1, value2, "beingExamineUnitCode");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitCodeNotBetween(String value1, String value2) {
            addCriterion("BEING_EXAMINE_UNIT_CODE not between", value1, value2, "beingExamineUnitCode");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitIdIsNull() {
            addCriterion("BEING_EXAMINE_UNIT_ID is null");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitIdIsNotNull() {
            addCriterion("BEING_EXAMINE_UNIT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitIdEqualTo(String value) {
            addCriterion("BEING_EXAMINE_UNIT_ID =", value, "beingExamineUnitId");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitIdNotEqualTo(String value) {
            addCriterion("BEING_EXAMINE_UNIT_ID <>", value, "beingExamineUnitId");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitIdGreaterThan(String value) {
            addCriterion("BEING_EXAMINE_UNIT_ID >", value, "beingExamineUnitId");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitIdGreaterThanOrEqualTo(String value) {
            addCriterion("BEING_EXAMINE_UNIT_ID >=", value, "beingExamineUnitId");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitIdLessThan(String value) {
            addCriterion("BEING_EXAMINE_UNIT_ID <", value, "beingExamineUnitId");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitIdLessThanOrEqualTo(String value) {
            addCriterion("BEING_EXAMINE_UNIT_ID <=", value, "beingExamineUnitId");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitIdLike(String value) {
            addCriterion("BEING_EXAMINE_UNIT_ID like", value, "beingExamineUnitId");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitIdNotLike(String value) {
            addCriterion("BEING_EXAMINE_UNIT_ID not like", value, "beingExamineUnitId");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitIdIn(List<String> values) {
            addCriterion("BEING_EXAMINE_UNIT_ID in", values, "beingExamineUnitId");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitIdNotIn(List<String> values) {
            addCriterion("BEING_EXAMINE_UNIT_ID not in", values, "beingExamineUnitId");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitIdBetween(String value1, String value2) {
            addCriterion("BEING_EXAMINE_UNIT_ID between", value1, value2, "beingExamineUnitId");
            return (Criteria) this;
        }

        public Criteria andBeingExamineUnitIdNotBetween(String value1, String value2) {
            addCriterion("BEING_EXAMINE_UNIT_ID not between", value1, value2, "beingExamineUnitId");
            return (Criteria) this;
        }

        public Criteria andExamineDateIsNull() {
            addCriterion("EXAMINE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andExamineDateIsNotNull() {
            addCriterion("EXAMINE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andExamineDateEqualTo(String value) {
            addCriterion("EXAMINE_DATE =", value, "examineDate");
            return (Criteria) this;
        }

        public Criteria andExamineDateNotEqualTo(String value) {
            addCriterion("EXAMINE_DATE <>", value, "examineDate");
            return (Criteria) this;
        }

        public Criteria andExamineDateGreaterThan(String value) {
            addCriterion("EXAMINE_DATE >", value, "examineDate");
            return (Criteria) this;
        }

        public Criteria andExamineDateGreaterThanOrEqualTo(String value) {
            addCriterion("EXAMINE_DATE >=", value, "examineDate");
            return (Criteria) this;
        }

        public Criteria andExamineDateLessThan(String value) {
            addCriterion("EXAMINE_DATE <", value, "examineDate");
            return (Criteria) this;
        }

        public Criteria andExamineDateLessThanOrEqualTo(String value) {
            addCriterion("EXAMINE_DATE <=", value, "examineDate");
            return (Criteria) this;
        }

        public Criteria andExamineDateLike(String value) {
            addCriterion("EXAMINE_DATE like", value, "examineDate");
            return (Criteria) this;
        }

        public Criteria andExamineDateNotLike(String value) {
            addCriterion("EXAMINE_DATE not like", value, "examineDate");
            return (Criteria) this;
        }

        public Criteria andExamineDateIn(List<String> values) {
            addCriterion("EXAMINE_DATE in", values, "examineDate");
            return (Criteria) this;
        }

        public Criteria andExamineDateNotIn(List<String> values) {
            addCriterion("EXAMINE_DATE not in", values, "examineDate");
            return (Criteria) this;
        }

        public Criteria andExamineDateBetween(String value1, String value2) {
            addCriterion("EXAMINE_DATE between", value1, value2, "examineDate");
            return (Criteria) this;
        }

        public Criteria andExamineDateNotBetween(String value1, String value2) {
            addCriterion("EXAMINE_DATE not between", value1, value2, "examineDate");
            return (Criteria) this;
        }

        public Criteria andCurrentGamJeomIsNull() {
            addCriterion("CURRENT_GAM_JEOM is null");
            return (Criteria) this;
        }

        public Criteria andCurrentGamJeomIsNotNull() {
            addCriterion("CURRENT_GAM_JEOM is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentGamJeomEqualTo(String value) {
            addCriterion("CURRENT_GAM_JEOM =", value, "currentGamJeom");
            return (Criteria) this;
        }

        public Criteria andCurrentGamJeomNotEqualTo(String value) {
            addCriterion("CURRENT_GAM_JEOM <>", value, "currentGamJeom");
            return (Criteria) this;
        }

        public Criteria andCurrentGamJeomGreaterThan(String value) {
            addCriterion("CURRENT_GAM_JEOM >", value, "currentGamJeom");
            return (Criteria) this;
        }

        public Criteria andCurrentGamJeomGreaterThanOrEqualTo(String value) {
            addCriterion("CURRENT_GAM_JEOM >=", value, "currentGamJeom");
            return (Criteria) this;
        }

        public Criteria andCurrentGamJeomLessThan(String value) {
            addCriterion("CURRENT_GAM_JEOM <", value, "currentGamJeom");
            return (Criteria) this;
        }

        public Criteria andCurrentGamJeomLessThanOrEqualTo(String value) {
            addCriterion("CURRENT_GAM_JEOM <=", value, "currentGamJeom");
            return (Criteria) this;
        }

        public Criteria andCurrentGamJeomLike(String value) {
            addCriterion("CURRENT_GAM_JEOM like", value, "currentGamJeom");
            return (Criteria) this;
        }

        public Criteria andCurrentGamJeomNotLike(String value) {
            addCriterion("CURRENT_GAM_JEOM not like", value, "currentGamJeom");
            return (Criteria) this;
        }

        public Criteria andCurrentGamJeomIn(List<String> values) {
            addCriterion("CURRENT_GAM_JEOM in", values, "currentGamJeom");
            return (Criteria) this;
        }

        public Criteria andCurrentGamJeomNotIn(List<String> values) {
            addCriterion("CURRENT_GAM_JEOM not in", values, "currentGamJeom");
            return (Criteria) this;
        }

        public Criteria andCurrentGamJeomBetween(String value1, String value2) {
            addCriterion("CURRENT_GAM_JEOM between", value1, value2, "currentGamJeom");
            return (Criteria) this;
        }

        public Criteria andCurrentGamJeomNotBetween(String value1, String value2) {
            addCriterion("CURRENT_GAM_JEOM not between", value1, value2, "currentGamJeom");
            return (Criteria) this;
        }

        public Criteria andExamineTypeIsNull() {
            addCriterion("EXAMINE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andExamineTypeIsNotNull() {
            addCriterion("EXAMINE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andExamineTypeEqualTo(String value) {
            addCriterion("EXAMINE_TYPE =", value, "examineType");
            return (Criteria) this;
        }

        public Criteria andExamineTypeNotEqualTo(String value) {
            addCriterion("EXAMINE_TYPE <>", value, "examineType");
            return (Criteria) this;
        }

        public Criteria andExamineTypeGreaterThan(String value) {
            addCriterion("EXAMINE_TYPE >", value, "examineType");
            return (Criteria) this;
        }

        public Criteria andExamineTypeGreaterThanOrEqualTo(String value) {
            addCriterion("EXAMINE_TYPE >=", value, "examineType");
            return (Criteria) this;
        }

        public Criteria andExamineTypeLessThan(String value) {
            addCriterion("EXAMINE_TYPE <", value, "examineType");
            return (Criteria) this;
        }

        public Criteria andExamineTypeLessThanOrEqualTo(String value) {
            addCriterion("EXAMINE_TYPE <=", value, "examineType");
            return (Criteria) this;
        }

        public Criteria andExamineTypeLike(String value) {
            addCriterion("EXAMINE_TYPE like", value, "examineType");
            return (Criteria) this;
        }

        public Criteria andExamineTypeNotLike(String value) {
            addCriterion("EXAMINE_TYPE not like", value, "examineType");
            return (Criteria) this;
        }

        public Criteria andExamineTypeIn(List<String> values) {
            addCriterion("EXAMINE_TYPE in", values, "examineType");
            return (Criteria) this;
        }

        public Criteria andExamineTypeNotIn(List<String> values) {
            addCriterion("EXAMINE_TYPE not in", values, "examineType");
            return (Criteria) this;
        }

        public Criteria andExamineTypeBetween(String value1, String value2) {
            addCriterion("EXAMINE_TYPE between", value1, value2, "examineType");
            return (Criteria) this;
        }

        public Criteria andExamineTypeNotBetween(String value1, String value2) {
            addCriterion("EXAMINE_TYPE not between", value1, value2, "examineType");
            return (Criteria) this;
        }

        public Criteria andExamineEvaluateIsNull() {
            addCriterion("EXAMINE_EVALUATE is null");
            return (Criteria) this;
        }

        public Criteria andExamineEvaluateIsNotNull() {
            addCriterion("EXAMINE_EVALUATE is not null");
            return (Criteria) this;
        }

        public Criteria andExamineEvaluateEqualTo(String value) {
            addCriterion("EXAMINE_EVALUATE =", value, "examineEvaluate");
            return (Criteria) this;
        }

        public Criteria andExamineEvaluateNotEqualTo(String value) {
            addCriterion("EXAMINE_EVALUATE <>", value, "examineEvaluate");
            return (Criteria) this;
        }

        public Criteria andExamineEvaluateGreaterThan(String value) {
            addCriterion("EXAMINE_EVALUATE >", value, "examineEvaluate");
            return (Criteria) this;
        }

        public Criteria andExamineEvaluateGreaterThanOrEqualTo(String value) {
            addCriterion("EXAMINE_EVALUATE >=", value, "examineEvaluate");
            return (Criteria) this;
        }

        public Criteria andExamineEvaluateLessThan(String value) {
            addCriterion("EXAMINE_EVALUATE <", value, "examineEvaluate");
            return (Criteria) this;
        }

        public Criteria andExamineEvaluateLessThanOrEqualTo(String value) {
            addCriterion("EXAMINE_EVALUATE <=", value, "examineEvaluate");
            return (Criteria) this;
        }

        public Criteria andExamineEvaluateLike(String value) {
            addCriterion("EXAMINE_EVALUATE like", value, "examineEvaluate");
            return (Criteria) this;
        }

        public Criteria andExamineEvaluateNotLike(String value) {
            addCriterion("EXAMINE_EVALUATE not like", value, "examineEvaluate");
            return (Criteria) this;
        }

        public Criteria andExamineEvaluateIn(List<String> values) {
            addCriterion("EXAMINE_EVALUATE in", values, "examineEvaluate");
            return (Criteria) this;
        }

        public Criteria andExamineEvaluateNotIn(List<String> values) {
            addCriterion("EXAMINE_EVALUATE not in", values, "examineEvaluate");
            return (Criteria) this;
        }

        public Criteria andExamineEvaluateBetween(String value1, String value2) {
            addCriterion("EXAMINE_EVALUATE between", value1, value2, "examineEvaluate");
            return (Criteria) this;
        }

        public Criteria andExamineEvaluateNotBetween(String value1, String value2) {
            addCriterion("EXAMINE_EVALUATE not between", value1, value2, "examineEvaluate");
            return (Criteria) this;
        }

        public Criteria andExamineUserNameIsNull() {
            addCriterion("EXAMINE_USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andExamineUserNameIsNotNull() {
            addCriterion("EXAMINE_USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andExamineUserNameEqualTo(String value) {
            addCriterion("EXAMINE_USER_NAME =", value, "examineUserName");
            return (Criteria) this;
        }

        public Criteria andExamineUserNameNotEqualTo(String value) {
            addCriterion("EXAMINE_USER_NAME <>", value, "examineUserName");
            return (Criteria) this;
        }

        public Criteria andExamineUserNameGreaterThan(String value) {
            addCriterion("EXAMINE_USER_NAME >", value, "examineUserName");
            return (Criteria) this;
        }

        public Criteria andExamineUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("EXAMINE_USER_NAME >=", value, "examineUserName");
            return (Criteria) this;
        }

        public Criteria andExamineUserNameLessThan(String value) {
            addCriterion("EXAMINE_USER_NAME <", value, "examineUserName");
            return (Criteria) this;
        }

        public Criteria andExamineUserNameLessThanOrEqualTo(String value) {
            addCriterion("EXAMINE_USER_NAME <=", value, "examineUserName");
            return (Criteria) this;
        }

        public Criteria andExamineUserNameLike(String value) {
            addCriterion("EXAMINE_USER_NAME like", value, "examineUserName");
            return (Criteria) this;
        }

        public Criteria andExamineUserNameNotLike(String value) {
            addCriterion("EXAMINE_USER_NAME not like", value, "examineUserName");
            return (Criteria) this;
        }

        public Criteria andExamineUserNameIn(List<String> values) {
            addCriterion("EXAMINE_USER_NAME in", values, "examineUserName");
            return (Criteria) this;
        }

        public Criteria andExamineUserNameNotIn(List<String> values) {
            addCriterion("EXAMINE_USER_NAME not in", values, "examineUserName");
            return (Criteria) this;
        }

        public Criteria andExamineUserNameBetween(String value1, String value2) {
            addCriterion("EXAMINE_USER_NAME between", value1, value2, "examineUserName");
            return (Criteria) this;
        }

        public Criteria andExamineUserNameNotBetween(String value1, String value2) {
            addCriterion("EXAMINE_USER_NAME not between", value1, value2, "examineUserName");
            return (Criteria) this;
        }

        public Criteria andExamineUserIdIsNull() {
            addCriterion("EXAMINE_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andExamineUserIdIsNotNull() {
            addCriterion("EXAMINE_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andExamineUserIdEqualTo(String value) {
            addCriterion("EXAMINE_USER_ID =", value, "examineUserId");
            return (Criteria) this;
        }

        public Criteria andExamineUserIdNotEqualTo(String value) {
            addCriterion("EXAMINE_USER_ID <>", value, "examineUserId");
            return (Criteria) this;
        }

        public Criteria andExamineUserIdGreaterThan(String value) {
            addCriterion("EXAMINE_USER_ID >", value, "examineUserId");
            return (Criteria) this;
        }

        public Criteria andExamineUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("EXAMINE_USER_ID >=", value, "examineUserId");
            return (Criteria) this;
        }

        public Criteria andExamineUserIdLessThan(String value) {
            addCriterion("EXAMINE_USER_ID <", value, "examineUserId");
            return (Criteria) this;
        }

        public Criteria andExamineUserIdLessThanOrEqualTo(String value) {
            addCriterion("EXAMINE_USER_ID <=", value, "examineUserId");
            return (Criteria) this;
        }

        public Criteria andExamineUserIdLike(String value) {
            addCriterion("EXAMINE_USER_ID like", value, "examineUserId");
            return (Criteria) this;
        }

        public Criteria andExamineUserIdNotLike(String value) {
            addCriterion("EXAMINE_USER_ID not like", value, "examineUserId");
            return (Criteria) this;
        }

        public Criteria andExamineUserIdIn(List<String> values) {
            addCriterion("EXAMINE_USER_ID in", values, "examineUserId");
            return (Criteria) this;
        }

        public Criteria andExamineUserIdNotIn(List<String> values) {
            addCriterion("EXAMINE_USER_ID not in", values, "examineUserId");
            return (Criteria) this;
        }

        public Criteria andExamineUserIdBetween(String value1, String value2) {
            addCriterion("EXAMINE_USER_ID between", value1, value2, "examineUserId");
            return (Criteria) this;
        }

        public Criteria andExamineUserIdNotBetween(String value1, String value2) {
            addCriterion("EXAMINE_USER_ID not between", value1, value2, "examineUserId");
            return (Criteria) this;
        }

        public Criteria andExamineBillNameIsNull() {
            addCriterion("EXAMINE_BILL_NAME is null");
            return (Criteria) this;
        }

        public Criteria andExamineBillNameIsNotNull() {
            addCriterion("EXAMINE_BILL_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andExamineBillNameEqualTo(String value) {
            addCriterion("EXAMINE_BILL_NAME =", value, "examineBillName");
            return (Criteria) this;
        }

        public Criteria andExamineBillNameNotEqualTo(String value) {
            addCriterion("EXAMINE_BILL_NAME <>", value, "examineBillName");
            return (Criteria) this;
        }

        public Criteria andExamineBillNameGreaterThan(String value) {
            addCriterion("EXAMINE_BILL_NAME >", value, "examineBillName");
            return (Criteria) this;
        }

        public Criteria andExamineBillNameGreaterThanOrEqualTo(String value) {
            addCriterion("EXAMINE_BILL_NAME >=", value, "examineBillName");
            return (Criteria) this;
        }

        public Criteria andExamineBillNameLessThan(String value) {
            addCriterion("EXAMINE_BILL_NAME <", value, "examineBillName");
            return (Criteria) this;
        }

        public Criteria andExamineBillNameLessThanOrEqualTo(String value) {
            addCriterion("EXAMINE_BILL_NAME <=", value, "examineBillName");
            return (Criteria) this;
        }

        public Criteria andExamineBillNameLike(String value) {
            addCriterion("EXAMINE_BILL_NAME like", value, "examineBillName");
            return (Criteria) this;
        }

        public Criteria andExamineBillNameNotLike(String value) {
            addCriterion("EXAMINE_BILL_NAME not like", value, "examineBillName");
            return (Criteria) this;
        }

        public Criteria andExamineBillNameIn(List<String> values) {
            addCriterion("EXAMINE_BILL_NAME in", values, "examineBillName");
            return (Criteria) this;
        }

        public Criteria andExamineBillNameNotIn(List<String> values) {
            addCriterion("EXAMINE_BILL_NAME not in", values, "examineBillName");
            return (Criteria) this;
        }

        public Criteria andExamineBillNameBetween(String value1, String value2) {
            addCriterion("EXAMINE_BILL_NAME between", value1, value2, "examineBillName");
            return (Criteria) this;
        }

        public Criteria andExamineBillNameNotBetween(String value1, String value2) {
            addCriterion("EXAMINE_BILL_NAME not between", value1, value2, "examineBillName");
            return (Criteria) this;
        }

        public Criteria andExamineBillCodeIsNull() {
            addCriterion("EXAMINE_BILL_CODE is null");
            return (Criteria) this;
        }

        public Criteria andExamineBillCodeIsNotNull() {
            addCriterion("EXAMINE_BILL_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andExamineBillCodeEqualTo(String value) {
            addCriterion("EXAMINE_BILL_CODE =", value, "examineBillCode");
            return (Criteria) this;
        }

        public Criteria andExamineBillCodeNotEqualTo(String value) {
            addCriterion("EXAMINE_BILL_CODE <>", value, "examineBillCode");
            return (Criteria) this;
        }

        public Criteria andExamineBillCodeGreaterThan(String value) {
            addCriterion("EXAMINE_BILL_CODE >", value, "examineBillCode");
            return (Criteria) this;
        }

        public Criteria andExamineBillCodeGreaterThanOrEqualTo(String value) {
            addCriterion("EXAMINE_BILL_CODE >=", value, "examineBillCode");
            return (Criteria) this;
        }

        public Criteria andExamineBillCodeLessThan(String value) {
            addCriterion("EXAMINE_BILL_CODE <", value, "examineBillCode");
            return (Criteria) this;
        }

        public Criteria andExamineBillCodeLessThanOrEqualTo(String value) {
            addCriterion("EXAMINE_BILL_CODE <=", value, "examineBillCode");
            return (Criteria) this;
        }

        public Criteria andExamineBillCodeLike(String value) {
            addCriterion("EXAMINE_BILL_CODE like", value, "examineBillCode");
            return (Criteria) this;
        }

        public Criteria andExamineBillCodeNotLike(String value) {
            addCriterion("EXAMINE_BILL_CODE not like", value, "examineBillCode");
            return (Criteria) this;
        }

        public Criteria andExamineBillCodeIn(List<String> values) {
            addCriterion("EXAMINE_BILL_CODE in", values, "examineBillCode");
            return (Criteria) this;
        }

        public Criteria andExamineBillCodeNotIn(List<String> values) {
            addCriterion("EXAMINE_BILL_CODE not in", values, "examineBillCode");
            return (Criteria) this;
        }

        public Criteria andExamineBillCodeBetween(String value1, String value2) {
            addCriterion("EXAMINE_BILL_CODE between", value1, value2, "examineBillCode");
            return (Criteria) this;
        }

        public Criteria andExamineBillCodeNotBetween(String value1, String value2) {
            addCriterion("EXAMINE_BILL_CODE not between", value1, value2, "examineBillCode");
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

        public Criteria andExamineTotalPointsIsNull() {
            addCriterion("EXAMINE_TOTAL_POINTS is null");
            return (Criteria) this;
        }

        public Criteria andExamineTotalPointsIsNotNull() {
            addCriterion("EXAMINE_TOTAL_POINTS is not null");
            return (Criteria) this;
        }

        public Criteria andExamineTotalPointsEqualTo(String value) {
            addCriterion("EXAMINE_TOTAL_POINTS =", value, "examineTotalPoints");
            return (Criteria) this;
        }

        public Criteria andExamineTotalPointsNotEqualTo(String value) {
            addCriterion("EXAMINE_TOTAL_POINTS <>", value, "examineTotalPoints");
            return (Criteria) this;
        }

        public Criteria andExamineTotalPointsGreaterThan(String value) {
            addCriterion("EXAMINE_TOTAL_POINTS >", value, "examineTotalPoints");
            return (Criteria) this;
        }

        public Criteria andExamineTotalPointsGreaterThanOrEqualTo(String value) {
            addCriterion("EXAMINE_TOTAL_POINTS >=", value, "examineTotalPoints");
            return (Criteria) this;
        }

        public Criteria andExamineTotalPointsLessThan(String value) {
            addCriterion("EXAMINE_TOTAL_POINTS <", value, "examineTotalPoints");
            return (Criteria) this;
        }

        public Criteria andExamineTotalPointsLessThanOrEqualTo(String value) {
            addCriterion("EXAMINE_TOTAL_POINTS <=", value, "examineTotalPoints");
            return (Criteria) this;
        }

        public Criteria andExamineTotalPointsLike(String value) {
            addCriterion("EXAMINE_TOTAL_POINTS like", value, "examineTotalPoints");
            return (Criteria) this;
        }

        public Criteria andExamineTotalPointsNotLike(String value) {
            addCriterion("EXAMINE_TOTAL_POINTS not like", value, "examineTotalPoints");
            return (Criteria) this;
        }

        public Criteria andExamineTotalPointsIn(List<String> values) {
            addCriterion("EXAMINE_TOTAL_POINTS in", values, "examineTotalPoints");
            return (Criteria) this;
        }

        public Criteria andExamineTotalPointsNotIn(List<String> values) {
            addCriterion("EXAMINE_TOTAL_POINTS not in", values, "examineTotalPoints");
            return (Criteria) this;
        }

        public Criteria andExamineTotalPointsBetween(String value1, String value2) {
            addCriterion("EXAMINE_TOTAL_POINTS between", value1, value2, "examineTotalPoints");
            return (Criteria) this;
        }

        public Criteria andExamineTotalPointsNotBetween(String value1, String value2) {
            addCriterion("EXAMINE_TOTAL_POINTS not between", value1, value2, "examineTotalPoints");
            return (Criteria) this;
        }

        public Criteria andExamineGoalIsNull() {
            addCriterion("EXAMINE_GOAL is null");
            return (Criteria) this;
        }

        public Criteria andExamineGoalIsNotNull() {
            addCriterion("EXAMINE_GOAL is not null");
            return (Criteria) this;
        }

        public Criteria andExamineGoalEqualTo(String value) {
            addCriterion("EXAMINE_GOAL =", value, "examineGoal");
            return (Criteria) this;
        }

        public Criteria andExamineGoalNotEqualTo(String value) {
            addCriterion("EXAMINE_GOAL <>", value, "examineGoal");
            return (Criteria) this;
        }

        public Criteria andExamineGoalGreaterThan(String value) {
            addCriterion("EXAMINE_GOAL >", value, "examineGoal");
            return (Criteria) this;
        }

        public Criteria andExamineGoalGreaterThanOrEqualTo(String value) {
            addCriterion("EXAMINE_GOAL >=", value, "examineGoal");
            return (Criteria) this;
        }

        public Criteria andExamineGoalLessThan(String value) {
            addCriterion("EXAMINE_GOAL <", value, "examineGoal");
            return (Criteria) this;
        }

        public Criteria andExamineGoalLessThanOrEqualTo(String value) {
            addCriterion("EXAMINE_GOAL <=", value, "examineGoal");
            return (Criteria) this;
        }

        public Criteria andExamineGoalLike(String value) {
            addCriterion("EXAMINE_GOAL like", value, "examineGoal");
            return (Criteria) this;
        }

        public Criteria andExamineGoalNotLike(String value) {
            addCriterion("EXAMINE_GOAL not like", value, "examineGoal");
            return (Criteria) this;
        }

        public Criteria andExamineGoalIn(List<String> values) {
            addCriterion("EXAMINE_GOAL in", values, "examineGoal");
            return (Criteria) this;
        }

        public Criteria andExamineGoalNotIn(List<String> values) {
            addCriterion("EXAMINE_GOAL not in", values, "examineGoal");
            return (Criteria) this;
        }

        public Criteria andExamineGoalBetween(String value1, String value2) {
            addCriterion("EXAMINE_GOAL between", value1, value2, "examineGoal");
            return (Criteria) this;
        }

        public Criteria andExamineGoalNotBetween(String value1, String value2) {
            addCriterion("EXAMINE_GOAL not between", value1, value2, "examineGoal");
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