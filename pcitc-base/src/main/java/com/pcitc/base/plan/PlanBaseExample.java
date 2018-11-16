package com.pcitc.base.plan;


import java.util.ArrayList;
import java.util.List;

public class PlanBaseExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public PlanBaseExample() {
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

        public Criteria andImplementationProgramIsNull() {
            addCriterion("IMPLEMENTATION_PROGRAM is null");
            return (Criteria) this;
        }

        public Criteria andImplementationProgramIsNotNull() {
            addCriterion("IMPLEMENTATION_PROGRAM is not null");
            return (Criteria) this;
        }

        public Criteria andImplementationProgramEqualTo(String value) {
            addCriterion("IMPLEMENTATION_PROGRAM =", value, "implementationProgram");
            return (Criteria) this;
        }

        public Criteria andImplementationProgramNotEqualTo(String value) {
            addCriterion("IMPLEMENTATION_PROGRAM <>", value, "implementationProgram");
            return (Criteria) this;
        }

        public Criteria andImplementationProgramGreaterThan(String value) {
            addCriterion("IMPLEMENTATION_PROGRAM >", value, "implementationProgram");
            return (Criteria) this;
        }

        public Criteria andImplementationProgramGreaterThanOrEqualTo(String value) {
            addCriterion("IMPLEMENTATION_PROGRAM >=", value, "implementationProgram");
            return (Criteria) this;
        }

        public Criteria andImplementationProgramLessThan(String value) {
            addCriterion("IMPLEMENTATION_PROGRAM <", value, "implementationProgram");
            return (Criteria) this;
        }

        public Criteria andImplementationProgramLessThanOrEqualTo(String value) {
            addCriterion("IMPLEMENTATION_PROGRAM <=", value, "implementationProgram");
            return (Criteria) this;
        }

        public Criteria andImplementationProgramLike(String value) {
            addCriterion("IMPLEMENTATION_PROGRAM like", value, "implementationProgram");
            return (Criteria) this;
        }

        public Criteria andImplementationProgramNotLike(String value) {
            addCriterion("IMPLEMENTATION_PROGRAM not like", value, "implementationProgram");
            return (Criteria) this;
        }

        public Criteria andImplementationProgramIn(List<String> values) {
            addCriterion("IMPLEMENTATION_PROGRAM in", values, "implementationProgram");
            return (Criteria) this;
        }

        public Criteria andImplementationProgramNotIn(List<String> values) {
            addCriterion("IMPLEMENTATION_PROGRAM not in", values, "implementationProgram");
            return (Criteria) this;
        }

        public Criteria andImplementationProgramBetween(String value1, String value2) {
            addCriterion("IMPLEMENTATION_PROGRAM between", value1, value2, "implementationProgram");
            return (Criteria) this;
        }

        public Criteria andImplementationProgramNotBetween(String value1, String value2) {
            addCriterion("IMPLEMENTATION_PROGRAM not between", value1, value2, "implementationProgram");
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

        public Criteria andWorkOrderTypeIsNull() {
            addCriterion("WORK_ORDER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderTypeIsNotNull() {
            addCriterion("WORK_ORDER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderTypeEqualTo(String value) {
            addCriterion("WORK_ORDER_TYPE =", value, "workOrderType");
            return (Criteria) this;
        }

        public Criteria andWorkOrderTypeNotEqualTo(String value) {
            addCriterion("WORK_ORDER_TYPE <>", value, "workOrderType");
            return (Criteria) this;
        }

        public Criteria andWorkOrderTypeGreaterThan(String value) {
            addCriterion("WORK_ORDER_TYPE >", value, "workOrderType");
            return (Criteria) this;
        }

        public Criteria andWorkOrderTypeGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_ORDER_TYPE >=", value, "workOrderType");
            return (Criteria) this;
        }

        public Criteria andWorkOrderTypeLessThan(String value) {
            addCriterion("WORK_ORDER_TYPE <", value, "workOrderType");
            return (Criteria) this;
        }

        public Criteria andWorkOrderTypeLessThanOrEqualTo(String value) {
            addCriterion("WORK_ORDER_TYPE <=", value, "workOrderType");
            return (Criteria) this;
        }

        public Criteria andWorkOrderTypeLike(String value) {
            addCriterion("WORK_ORDER_TYPE like", value, "workOrderType");
            return (Criteria) this;
        }

        public Criteria andWorkOrderTypeNotLike(String value) {
            addCriterion("WORK_ORDER_TYPE not like", value, "workOrderType");
            return (Criteria) this;
        }

        public Criteria andWorkOrderTypeIn(List<String> values) {
            addCriterion("WORK_ORDER_TYPE in", values, "workOrderType");
            return (Criteria) this;
        }

        public Criteria andWorkOrderTypeNotIn(List<String> values) {
            addCriterion("WORK_ORDER_TYPE not in", values, "workOrderType");
            return (Criteria) this;
        }

        public Criteria andWorkOrderTypeBetween(String value1, String value2) {
            addCriterion("WORK_ORDER_TYPE between", value1, value2, "workOrderType");
            return (Criteria) this;
        }

        public Criteria andWorkOrderTypeNotBetween(String value1, String value2) {
            addCriterion("WORK_ORDER_TYPE not between", value1, value2, "workOrderType");
            return (Criteria) this;
        }

        public Criteria andWorkOrderStatusIsNull() {
            addCriterion("WORK_ORDER_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderStatusIsNotNull() {
            addCriterion("WORK_ORDER_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderStatusEqualTo(String value) {
            addCriterion("WORK_ORDER_STATUS =", value, "workOrderStatus");
            return (Criteria) this;
        }

        public Criteria andWorkOrderStatusNotEqualTo(String value) {
            addCriterion("WORK_ORDER_STATUS <>", value, "workOrderStatus");
            return (Criteria) this;
        }

        public Criteria andWorkOrderStatusGreaterThan(String value) {
            addCriterion("WORK_ORDER_STATUS >", value, "workOrderStatus");
            return (Criteria) this;
        }

        public Criteria andWorkOrderStatusGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_ORDER_STATUS >=", value, "workOrderStatus");
            return (Criteria) this;
        }

        public Criteria andWorkOrderStatusLessThan(String value) {
            addCriterion("WORK_ORDER_STATUS <", value, "workOrderStatus");
            return (Criteria) this;
        }

        public Criteria andWorkOrderStatusLessThanOrEqualTo(String value) {
            addCriterion("WORK_ORDER_STATUS <=", value, "workOrderStatus");
            return (Criteria) this;
        }

        public Criteria andWorkOrderStatusLike(String value) {
            addCriterion("WORK_ORDER_STATUS like", value, "workOrderStatus");
            return (Criteria) this;
        }

        public Criteria andWorkOrderStatusNotLike(String value) {
            addCriterion("WORK_ORDER_STATUS not like", value, "workOrderStatus");
            return (Criteria) this;
        }

        public Criteria andWorkOrderStatusIn(List<String> values) {
            addCriterion("WORK_ORDER_STATUS in", values, "workOrderStatus");
            return (Criteria) this;
        }

        public Criteria andWorkOrderStatusNotIn(List<String> values) {
            addCriterion("WORK_ORDER_STATUS not in", values, "workOrderStatus");
            return (Criteria) this;
        }

        public Criteria andWorkOrderStatusBetween(String value1, String value2) {
            addCriterion("WORK_ORDER_STATUS between", value1, value2, "workOrderStatus");
            return (Criteria) this;
        }

        public Criteria andWorkOrderStatusNotBetween(String value1, String value2) {
            addCriterion("WORK_ORDER_STATUS not between", value1, value2, "workOrderStatus");
            return (Criteria) this;
        }

        public Criteria andWorkOrderAllotUserNameIsNull() {
            addCriterion("WORK_ORDER_ALLOT_USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderAllotUserNameIsNotNull() {
            addCriterion("WORK_ORDER_ALLOT_USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderAllotUserNameEqualTo(String value) {
            addCriterion("WORK_ORDER_ALLOT_USER_NAME =", value, "workOrderAllotUserName");
            return (Criteria) this;
        }

        public Criteria andWorkOrderAllotUserNameNotEqualTo(String value) {
            addCriterion("WORK_ORDER_ALLOT_USER_NAME <>", value, "workOrderAllotUserName");
            return (Criteria) this;
        }

        public Criteria andWorkOrderAllotUserNameGreaterThan(String value) {
            addCriterion("WORK_ORDER_ALLOT_USER_NAME >", value, "workOrderAllotUserName");
            return (Criteria) this;
        }

        public Criteria andWorkOrderAllotUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_ORDER_ALLOT_USER_NAME >=", value, "workOrderAllotUserName");
            return (Criteria) this;
        }

        public Criteria andWorkOrderAllotUserNameLessThan(String value) {
            addCriterion("WORK_ORDER_ALLOT_USER_NAME <", value, "workOrderAllotUserName");
            return (Criteria) this;
        }

        public Criteria andWorkOrderAllotUserNameLessThanOrEqualTo(String value) {
            addCriterion("WORK_ORDER_ALLOT_USER_NAME <=", value, "workOrderAllotUserName");
            return (Criteria) this;
        }

        public Criteria andWorkOrderAllotUserNameLike(String value) {
            addCriterion("WORK_ORDER_ALLOT_USER_NAME like", value, "workOrderAllotUserName");
            return (Criteria) this;
        }

        public Criteria andWorkOrderAllotUserNameNotLike(String value) {
            addCriterion("WORK_ORDER_ALLOT_USER_NAME not like", value, "workOrderAllotUserName");
            return (Criteria) this;
        }

        public Criteria andWorkOrderAllotUserNameIn(List<String> values) {
            addCriterion("WORK_ORDER_ALLOT_USER_NAME in", values, "workOrderAllotUserName");
            return (Criteria) this;
        }

        public Criteria andWorkOrderAllotUserNameNotIn(List<String> values) {
            addCriterion("WORK_ORDER_ALLOT_USER_NAME not in", values, "workOrderAllotUserName");
            return (Criteria) this;
        }

        public Criteria andWorkOrderAllotUserNameBetween(String value1, String value2) {
            addCriterion("WORK_ORDER_ALLOT_USER_NAME between", value1, value2, "workOrderAllotUserName");
            return (Criteria) this;
        }

        public Criteria andWorkOrderAllotUserNameNotBetween(String value1, String value2) {
            addCriterion("WORK_ORDER_ALLOT_USER_NAME not between", value1, value2, "workOrderAllotUserName");
            return (Criteria) this;
        }

        public Criteria andWorkOrderAllotUserIdIsNull() {
            addCriterion("WORK_ORDER_ALLOT_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderAllotUserIdIsNotNull() {
            addCriterion("WORK_ORDER_ALLOT_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderAllotUserIdEqualTo(String value) {
            addCriterion("WORK_ORDER_ALLOT_USER_ID =", value, "workOrderAllotUserId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderAllotUserIdNotEqualTo(String value) {
            addCriterion("WORK_ORDER_ALLOT_USER_ID <>", value, "workOrderAllotUserId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderAllotUserIdGreaterThan(String value) {
            addCriterion("WORK_ORDER_ALLOT_USER_ID >", value, "workOrderAllotUserId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderAllotUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_ORDER_ALLOT_USER_ID >=", value, "workOrderAllotUserId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderAllotUserIdLessThan(String value) {
            addCriterion("WORK_ORDER_ALLOT_USER_ID <", value, "workOrderAllotUserId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderAllotUserIdLessThanOrEqualTo(String value) {
            addCriterion("WORK_ORDER_ALLOT_USER_ID <=", value, "workOrderAllotUserId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderAllotUserIdLike(String value) {
            addCriterion("WORK_ORDER_ALLOT_USER_ID like", value, "workOrderAllotUserId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderAllotUserIdNotLike(String value) {
            addCriterion("WORK_ORDER_ALLOT_USER_ID not like", value, "workOrderAllotUserId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderAllotUserIdIn(List<String> values) {
            addCriterion("WORK_ORDER_ALLOT_USER_ID in", values, "workOrderAllotUserId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderAllotUserIdNotIn(List<String> values) {
            addCriterion("WORK_ORDER_ALLOT_USER_ID not in", values, "workOrderAllotUserId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderAllotUserIdBetween(String value1, String value2) {
            addCriterion("WORK_ORDER_ALLOT_USER_ID between", value1, value2, "workOrderAllotUserId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderAllotUserIdNotBetween(String value1, String value2) {
            addCriterion("WORK_ORDER_ALLOT_USER_ID not between", value1, value2, "workOrderAllotUserId");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("PARENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("PARENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(String value) {
            addCriterion("PARENT_ID =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(String value) {
            addCriterion("PARENT_ID <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(String value) {
            addCriterion("PARENT_ID >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("PARENT_ID >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(String value) {
            addCriterion("PARENT_ID <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(String value) {
            addCriterion("PARENT_ID <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLike(String value) {
            addCriterion("PARENT_ID like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotLike(String value) {
            addCriterion("PARENT_ID not like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<String> values) {
            addCriterion("PARENT_ID in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<String> values) {
            addCriterion("PARENT_ID not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(String value1, String value2) {
            addCriterion("PARENT_ID between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(String value1, String value2) {
            addCriterion("PARENT_ID not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andJsIdIsNull() {
            addCriterion("JS_ID is null");
            return (Criteria) this;
        }

        public Criteria andJsIdIsNotNull() {
            addCriterion("JS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andJsIdEqualTo(String value) {
            addCriterion("JS_ID =", value, "jsId");
            return (Criteria) this;
        }

        public Criteria andJsIdNotEqualTo(String value) {
            addCriterion("JS_ID <>", value, "jsId");
            return (Criteria) this;
        }

        public Criteria andJsIdGreaterThan(String value) {
            addCriterion("JS_ID >", value, "jsId");
            return (Criteria) this;
        }

        public Criteria andJsIdGreaterThanOrEqualTo(String value) {
            addCriterion("JS_ID >=", value, "jsId");
            return (Criteria) this;
        }

        public Criteria andJsIdLessThan(String value) {
            addCriterion("JS_ID <", value, "jsId");
            return (Criteria) this;
        }

        public Criteria andJsIdLessThanOrEqualTo(String value) {
            addCriterion("JS_ID <=", value, "jsId");
            return (Criteria) this;
        }

        public Criteria andJsIdLike(String value) {
            addCriterion("JS_ID like", value, "jsId");
            return (Criteria) this;
        }

        public Criteria andJsIdNotLike(String value) {
            addCriterion("JS_ID not like", value, "jsId");
            return (Criteria) this;
        }

        public Criteria andJsIdIn(List<String> values) {
            addCriterion("JS_ID in", values, "jsId");
            return (Criteria) this;
        }

        public Criteria andJsIdNotIn(List<String> values) {
            addCriterion("JS_ID not in", values, "jsId");
            return (Criteria) this;
        }

        public Criteria andJsIdBetween(String value1, String value2) {
            addCriterion("JS_ID between", value1, value2, "jsId");
            return (Criteria) this;
        }

        public Criteria andJsIdNotBetween(String value1, String value2) {
            addCriterion("JS_ID not between", value1, value2, "jsId");
            return (Criteria) this;
        }

        public Criteria andZpNameIsNull() {
            addCriterion("ZP_NAME is null");
            return (Criteria) this;
        }

        public Criteria andZpNameIsNotNull() {
            addCriterion("ZP_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andZpNameEqualTo(String value) {
            addCriterion("ZP_NAME =", value, "zpName");
            return (Criteria) this;
        }

        public Criteria andZpNameNotEqualTo(String value) {
            addCriterion("ZP_NAME <>", value, "zpName");
            return (Criteria) this;
        }

        public Criteria andZpNameGreaterThan(String value) {
            addCriterion("ZP_NAME >", value, "zpName");
            return (Criteria) this;
        }

        public Criteria andZpNameGreaterThanOrEqualTo(String value) {
            addCriterion("ZP_NAME >=", value, "zpName");
            return (Criteria) this;
        }

        public Criteria andZpNameLessThan(String value) {
            addCriterion("ZP_NAME <", value, "zpName");
            return (Criteria) this;
        }

        public Criteria andZpNameLessThanOrEqualTo(String value) {
            addCriterion("ZP_NAME <=", value, "zpName");
            return (Criteria) this;
        }

        public Criteria andZpNameLike(String value) {
            addCriterion("ZP_NAME like", value, "zpName");
            return (Criteria) this;
        }

        public Criteria andZpNameNotLike(String value) {
            addCriterion("ZP_NAME not like", value, "zpName");
            return (Criteria) this;
        }

        public Criteria andZpNameIn(List<String> values) {
            addCriterion("ZP_NAME in", values, "zpName");
            return (Criteria) this;
        }

        public Criteria andZpNameNotIn(List<String> values) {
            addCriterion("ZP_NAME not in", values, "zpName");
            return (Criteria) this;
        }

        public Criteria andZpNameBetween(String value1, String value2) {
            addCriterion("ZP_NAME between", value1, value2, "zpName");
            return (Criteria) this;
        }

        public Criteria andZpNameNotBetween(String value1, String value2) {
            addCriterion("ZP_NAME not between", value1, value2, "zpName");
            return (Criteria) this;
        }

        public Criteria andBlIsNull() {
            addCriterion("BL is null");
            return (Criteria) this;
        }

        public Criteria andBlIsNotNull() {
            addCriterion("BL is not null");
            return (Criteria) this;
        }

        public Criteria andBlEqualTo(String value) {
            addCriterion("BL =", value, "bl");
            return (Criteria) this;
        }

        public Criteria andBlNotEqualTo(String value) {
            addCriterion("BL <>", value, "bl");
            return (Criteria) this;
        }

        public Criteria andBlGreaterThan(String value) {
            addCriterion("BL >", value, "bl");
            return (Criteria) this;
        }

        public Criteria andBlGreaterThanOrEqualTo(String value) {
            addCriterion("BL >=", value, "bl");
            return (Criteria) this;
        }

        public Criteria andBlLessThan(String value) {
            addCriterion("BL <", value, "bl");
            return (Criteria) this;
        }

        public Criteria andBlLessThanOrEqualTo(String value) {
            addCriterion("BL <=", value, "bl");
            return (Criteria) this;
        }

        public Criteria andBlLike(String value) {
            addCriterion("BL like", value, "bl");
            return (Criteria) this;
        }

        public Criteria andBlNotLike(String value) {
            addCriterion("BL not like", value, "bl");
            return (Criteria) this;
        }

        public Criteria andBlIn(List<String> values) {
            addCriterion("BL in", values, "bl");
            return (Criteria) this;
        }

        public Criteria andBlNotIn(List<String> values) {
            addCriterion("BL not in", values, "bl");
            return (Criteria) this;
        }

        public Criteria andBlBetween(String value1, String value2) {
            addCriterion("BL between", value1, value2, "bl");
            return (Criteria) this;
        }

        public Criteria andBlNotBetween(String value1, String value2) {
            addCriterion("BL not between", value1, value2, "bl");
            return (Criteria) this;
        }

        public Criteria andXbrIsNull() {
            addCriterion("XBR is null");
            return (Criteria) this;
        }

        public Criteria andXbrIsNotNull() {
            addCriterion("XBR is not null");
            return (Criteria) this;
        }

        public Criteria andXbrEqualTo(String value) {
            addCriterion("XBR =", value, "xbr");
            return (Criteria) this;
        }

        public Criteria andXbrNotEqualTo(String value) {
            addCriterion("XBR <>", value, "xbr");
            return (Criteria) this;
        }

        public Criteria andXbrGreaterThan(String value) {
            addCriterion("XBR >", value, "xbr");
            return (Criteria) this;
        }

        public Criteria andXbrGreaterThanOrEqualTo(String value) {
            addCriterion("XBR >=", value, "xbr");
            return (Criteria) this;
        }

        public Criteria andXbrLessThan(String value) {
            addCriterion("XBR <", value, "xbr");
            return (Criteria) this;
        }

        public Criteria andXbrLessThanOrEqualTo(String value) {
            addCriterion("XBR <=", value, "xbr");
            return (Criteria) this;
        }

        public Criteria andXbrLike(String value) {
            addCriterion("XBR like", value, "xbr");
            return (Criteria) this;
        }

        public Criteria andXbrNotLike(String value) {
            addCriterion("XBR not like", value, "xbr");
            return (Criteria) this;
        }

        public Criteria andXbrIn(List<String> values) {
            addCriterion("XBR in", values, "xbr");
            return (Criteria) this;
        }

        public Criteria andXbrNotIn(List<String> values) {
            addCriterion("XBR not in", values, "xbr");
            return (Criteria) this;
        }

        public Criteria andXbrBetween(String value1, String value2) {
            addCriterion("XBR between", value1, value2, "xbr");
            return (Criteria) this;
        }

        public Criteria andXbrNotBetween(String value1, String value2) {
            addCriterion("XBR not between", value1, value2, "xbr");
            return (Criteria) this;
        }

        public Criteria andBak1IsNull() {
            addCriterion("bak1 is null");
            return (Criteria) this;
        }

        public Criteria andBak1IsNotNull() {
            addCriterion("bak1 is not null");
            return (Criteria) this;
        }

        public Criteria andBak1EqualTo(String value) {
            addCriterion("bak1 =", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1NotEqualTo(String value) {
            addCriterion("bak1 <>", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1GreaterThan(String value) {
            addCriterion("bak1 >", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1GreaterThanOrEqualTo(String value) {
            addCriterion("bak1 >=", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1LessThan(String value) {
            addCriterion("bak1 <", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1LessThanOrEqualTo(String value) {
            addCriterion("bak1 <=", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1Like(String value) {
            addCriterion("bak1 like", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1NotLike(String value) {
            addCriterion("bak1 not like", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1In(List<String> values) {
            addCriterion("bak1 in", values, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1NotIn(List<String> values) {
            addCriterion("bak1 not in", values, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1Between(String value1, String value2) {
            addCriterion("bak1 between", value1, value2, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1NotBetween(String value1, String value2) {
            addCriterion("bak1 not between", value1, value2, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak2IsNull() {
            addCriterion("bak2 is null");
            return (Criteria) this;
        }

        public Criteria andBak2IsNotNull() {
            addCriterion("bak2 is not null");
            return (Criteria) this;
        }

        public Criteria andBak2EqualTo(String value) {
            addCriterion("bak2 =", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2NotEqualTo(String value) {
            addCriterion("bak2 <>", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2GreaterThan(String value) {
            addCriterion("bak2 >", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2GreaterThanOrEqualTo(String value) {
            addCriterion("bak2 >=", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2LessThan(String value) {
            addCriterion("bak2 <", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2LessThanOrEqualTo(String value) {
            addCriterion("bak2 <=", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2Like(String value) {
            addCriterion("bak2 like", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2NotLike(String value) {
            addCriterion("bak2 not like", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2In(List<String> values) {
            addCriterion("bak2 in", values, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2NotIn(List<String> values) {
            addCriterion("bak2 not in", values, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2Between(String value1, String value2) {
            addCriterion("bak2 between", value1, value2, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2NotBetween(String value1, String value2) {
            addCriterion("bak2 not between", value1, value2, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak3IsNull() {
            addCriterion("bak3 is null");
            return (Criteria) this;
        }

        public Criteria andBak3IsNotNull() {
            addCriterion("bak3 is not null");
            return (Criteria) this;
        }

        public Criteria andBak3EqualTo(String value) {
            addCriterion("bak3 =", value, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3NotEqualTo(String value) {
            addCriterion("bak3 <>", value, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3GreaterThan(String value) {
            addCriterion("bak3 >", value, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3GreaterThanOrEqualTo(String value) {
            addCriterion("bak3 >=", value, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3LessThan(String value) {
            addCriterion("bak3 <", value, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3LessThanOrEqualTo(String value) {
            addCriterion("bak3 <=", value, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3Like(String value) {
            addCriterion("bak3 like", value, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3NotLike(String value) {
            addCriterion("bak3 not like", value, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3In(List<String> values) {
            addCriterion("bak3 in", values, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3NotIn(List<String> values) {
            addCriterion("bak3 not in", values, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3Between(String value1, String value2) {
            addCriterion("bak3 between", value1, value2, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3NotBetween(String value1, String value2) {
            addCriterion("bak3 not between", value1, value2, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak4IsNull() {
            addCriterion("bak4 is null");
            return (Criteria) this;
        }

        public Criteria andBak4IsNotNull() {
            addCriterion("bak4 is not null");
            return (Criteria) this;
        }

        public Criteria andBak4EqualTo(String value) {
            addCriterion("bak4 =", value, "bak4");
            return (Criteria) this;
        }

        public Criteria andBak4NotEqualTo(String value) {
            addCriterion("bak4 <>", value, "bak4");
            return (Criteria) this;
        }

        public Criteria andBak4GreaterThan(String value) {
            addCriterion("bak4 >", value, "bak4");
            return (Criteria) this;
        }

        public Criteria andBak4GreaterThanOrEqualTo(String value) {
            addCriterion("bak4 >=", value, "bak4");
            return (Criteria) this;
        }

        public Criteria andBak4LessThan(String value) {
            addCriterion("bak4 <", value, "bak4");
            return (Criteria) this;
        }

        public Criteria andBak4LessThanOrEqualTo(String value) {
            addCriterion("bak4 <=", value, "bak4");
            return (Criteria) this;
        }

        public Criteria andBak4Like(String value) {
            addCriterion("bak4 like", value, "bak4");
            return (Criteria) this;
        }

        public Criteria andBak4NotLike(String value) {
            addCriterion("bak4 not like", value, "bak4");
            return (Criteria) this;
        }

        public Criteria andBak4In(List<String> values) {
            addCriterion("bak4 in", values, "bak4");
            return (Criteria) this;
        }

        public Criteria andBak4NotIn(List<String> values) {
            addCriterion("bak4 not in", values, "bak4");
            return (Criteria) this;
        }

        public Criteria andBak4Between(String value1, String value2) {
            addCriterion("bak4 between", value1, value2, "bak4");
            return (Criteria) this;
        }

        public Criteria andBak4NotBetween(String value1, String value2) {
            addCriterion("bak4 not between", value1, value2, "bak4");
            return (Criteria) this;
        }

        public Criteria andBak5IsNull() {
            addCriterion("bak5 is null");
            return (Criteria) this;
        }

        public Criteria andBak5IsNotNull() {
            addCriterion("bak5 is not null");
            return (Criteria) this;
        }

        public Criteria andBak5EqualTo(String value) {
            addCriterion("bak5 =", value, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5NotEqualTo(String value) {
            addCriterion("bak5 <>", value, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5GreaterThan(String value) {
            addCriterion("bak5 >", value, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5GreaterThanOrEqualTo(String value) {
            addCriterion("bak5 >=", value, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5LessThan(String value) {
            addCriterion("bak5 <", value, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5LessThanOrEqualTo(String value) {
            addCriterion("bak5 <=", value, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5Like(String value) {
            addCriterion("bak5 like", value, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5NotLike(String value) {
            addCriterion("bak5 not like", value, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5In(List<String> values) {
            addCriterion("bak5 in", values, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5NotIn(List<String> values) {
            addCriterion("bak5 not in", values, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5Between(String value1, String value2) {
            addCriterion("bak5 between", value1, value2, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5NotBetween(String value1, String value2) {
            addCriterion("bak5 not between", value1, value2, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak6IsNull() {
            addCriterion("bak6 is null");
            return (Criteria) this;
        }

        public Criteria andBak6IsNotNull() {
            addCriterion("bak6 is not null");
            return (Criteria) this;
        }

        public Criteria andBak6EqualTo(String value) {
            addCriterion("bak6 =", value, "bak6");
            return (Criteria) this;
        }

        public Criteria andBak6NotEqualTo(String value) {
            addCriterion("bak6 <>", value, "bak6");
            return (Criteria) this;
        }

        public Criteria andBak6GreaterThan(String value) {
            addCriterion("bak6 >", value, "bak6");
            return (Criteria) this;
        }

        public Criteria andBak6GreaterThanOrEqualTo(String value) {
            addCriterion("bak6 >=", value, "bak6");
            return (Criteria) this;
        }

        public Criteria andBak6LessThan(String value) {
            addCriterion("bak6 <", value, "bak6");
            return (Criteria) this;
        }

        public Criteria andBak6LessThanOrEqualTo(String value) {
            addCriterion("bak6 <=", value, "bak6");
            return (Criteria) this;
        }

        public Criteria andBak6Like(String value) {
            addCriterion("bak6 like", value, "bak6");
            return (Criteria) this;
        }

        public Criteria andBak6NotLike(String value) {
            addCriterion("bak6 not like", value, "bak6");
            return (Criteria) this;
        }

        public Criteria andBak6In(List<String> values) {
            addCriterion("bak6 in", values, "bak6");
            return (Criteria) this;
        }

        public Criteria andBak6NotIn(List<String> values) {
            addCriterion("bak6 not in", values, "bak6");
            return (Criteria) this;
        }

        public Criteria andBak6Between(String value1, String value2) {
            addCriterion("bak6 between", value1, value2, "bak6");
            return (Criteria) this;
        }

        public Criteria andBak6NotBetween(String value1, String value2) {
            addCriterion("bak6 not between", value1, value2, "bak6");
            return (Criteria) this;
        }
    }

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