package com.pcitc.base.system;

import java.util.ArrayList;
import java.util.List;

public class SysRestfulapiExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysRestfulapiExample() {
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

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(String value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(String value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(String value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(String value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(String value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(String value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLike(String value) {
            addCriterion("create_date like", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotLike(String value) {
            addCriterion("create_date not like", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<String> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<String> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(String value1, String value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(String value1, String value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(String value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(String value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(String value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(String value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(String value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(String value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLike(String value) {
            addCriterion("update_date like", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotLike(String value) {
            addCriterion("update_date not like", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<String> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<String> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(String value1, String value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(String value1, String value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRestfulapiIdIsNull() {
            addCriterion("restfulapi_id is null");
            return (Criteria) this;
        }

        public Criteria andRestfulapiIdIsNotNull() {
            addCriterion("restfulapi_id is not null");
            return (Criteria) this;
        }

        public Criteria andRestfulapiIdEqualTo(String value) {
            addCriterion("restfulapi_id =", value, "restfulapiId");
            return (Criteria) this;
        }

        public Criteria andRestfulapiIdNotEqualTo(String value) {
            addCriterion("restfulapi_id <>", value, "restfulapiId");
            return (Criteria) this;
        }

        public Criteria andRestfulapiIdGreaterThan(String value) {
            addCriterion("restfulapi_id >", value, "restfulapiId");
            return (Criteria) this;
        }

        public Criteria andRestfulapiIdGreaterThanOrEqualTo(String value) {
            addCriterion("restfulapi_id >=", value, "restfulapiId");
            return (Criteria) this;
        }

        public Criteria andRestfulapiIdLessThan(String value) {
            addCriterion("restfulapi_id <", value, "restfulapiId");
            return (Criteria) this;
        }

        public Criteria andRestfulapiIdLessThanOrEqualTo(String value) {
            addCriterion("restfulapi_id <=", value, "restfulapiId");
            return (Criteria) this;
        }

        public Criteria andRestfulapiIdLike(String value) {
            addCriterion("restfulapi_id like", value, "restfulapiId");
            return (Criteria) this;
        }

        public Criteria andRestfulapiIdNotLike(String value) {
            addCriterion("restfulapi_id not like", value, "restfulapiId");
            return (Criteria) this;
        }

        public Criteria andRestfulapiIdIn(List<String> values) {
            addCriterion("restfulapi_id in", values, "restfulapiId");
            return (Criteria) this;
        }

        public Criteria andRestfulapiIdNotIn(List<String> values) {
            addCriterion("restfulapi_id not in", values, "restfulapiId");
            return (Criteria) this;
        }

        public Criteria andRestfulapiIdBetween(String value1, String value2) {
            addCriterion("restfulapi_id between", value1, value2, "restfulapiId");
            return (Criteria) this;
        }

        public Criteria andRestfulapiIdNotBetween(String value1, String value2) {
            addCriterion("restfulapi_id not between", value1, value2, "restfulapiId");
            return (Criteria) this;
        }

        public Criteria andRestfulapiCodeIsNull() {
            addCriterion("restfulapi_code is null");
            return (Criteria) this;
        }

        public Criteria andRestfulapiCodeIsNotNull() {
            addCriterion("restfulapi_code is not null");
            return (Criteria) this;
        }

        public Criteria andRestfulapiCodeEqualTo(String value) {
            addCriterion("restfulapi_code =", value, "restfulapiCode");
            return (Criteria) this;
        }

        public Criteria andRestfulapiCodeNotEqualTo(String value) {
            addCriterion("restfulapi_code <>", value, "restfulapiCode");
            return (Criteria) this;
        }

        public Criteria andRestfulapiCodeGreaterThan(String value) {
            addCriterion("restfulapi_code >", value, "restfulapiCode");
            return (Criteria) this;
        }

        public Criteria andRestfulapiCodeGreaterThanOrEqualTo(String value) {
            addCriterion("restfulapi_code >=", value, "restfulapiCode");
            return (Criteria) this;
        }

        public Criteria andRestfulapiCodeLessThan(String value) {
            addCriterion("restfulapi_code <", value, "restfulapiCode");
            return (Criteria) this;
        }

        public Criteria andRestfulapiCodeLessThanOrEqualTo(String value) {
            addCriterion("restfulapi_code <=", value, "restfulapiCode");
            return (Criteria) this;
        }

        public Criteria andRestfulapiCodeLike(String value) {
            addCriterion("restfulapi_code like", value, "restfulapiCode");
            return (Criteria) this;
        }

        public Criteria andRestfulapiCodeNotLike(String value) {
            addCriterion("restfulapi_code not like", value, "restfulapiCode");
            return (Criteria) this;
        }

        public Criteria andRestfulapiCodeIn(List<String> values) {
            addCriterion("restfulapi_code in", values, "restfulapiCode");
            return (Criteria) this;
        }

        public Criteria andRestfulapiCodeNotIn(List<String> values) {
            addCriterion("restfulapi_code not in", values, "restfulapiCode");
            return (Criteria) this;
        }

        public Criteria andRestfulapiCodeBetween(String value1, String value2) {
            addCriterion("restfulapi_code between", value1, value2, "restfulapiCode");
            return (Criteria) this;
        }

        public Criteria andRestfulapiCodeNotBetween(String value1, String value2) {
            addCriterion("restfulapi_code not between", value1, value2, "restfulapiCode");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIsNull() {
            addCriterion("audit_status is null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIsNotNull() {
            addCriterion("audit_status is not null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusEqualTo(String value) {
            addCriterion("audit_status =", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotEqualTo(String value) {
            addCriterion("audit_status <>", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThan(String value) {
            addCriterion("audit_status >", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThanOrEqualTo(String value) {
            addCriterion("audit_status >=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThan(String value) {
            addCriterion("audit_status <", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThanOrEqualTo(String value) {
            addCriterion("audit_status <=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLike(String value) {
            addCriterion("audit_status like", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotLike(String value) {
            addCriterion("audit_status not like", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIn(List<String> values) {
            addCriterion("audit_status in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotIn(List<String> values) {
            addCriterion("audit_status not in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusBetween(String value1, String value2) {
            addCriterion("audit_status between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotBetween(String value1, String value2) {
            addCriterion("audit_status not between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andRestfulapiUserIsNull() {
            addCriterion("restfulapi_user is null");
            return (Criteria) this;
        }

        public Criteria andRestfulapiUserIsNotNull() {
            addCriterion("restfulapi_user is not null");
            return (Criteria) this;
        }

        public Criteria andRestfulapiUserEqualTo(String value) {
            addCriterion("restfulapi_user =", value, "restfulapiUser");
            return (Criteria) this;
        }

        public Criteria andRestfulapiUserNotEqualTo(String value) {
            addCriterion("restfulapi_user <>", value, "restfulapiUser");
            return (Criteria) this;
        }

        public Criteria andRestfulapiUserGreaterThan(String value) {
            addCriterion("restfulapi_user >", value, "restfulapiUser");
            return (Criteria) this;
        }

        public Criteria andRestfulapiUserGreaterThanOrEqualTo(String value) {
            addCriterion("restfulapi_user >=", value, "restfulapiUser");
            return (Criteria) this;
        }

        public Criteria andRestfulapiUserLessThan(String value) {
            addCriterion("restfulapi_user <", value, "restfulapiUser");
            return (Criteria) this;
        }

        public Criteria andRestfulapiUserLessThanOrEqualTo(String value) {
            addCriterion("restfulapi_user <=", value, "restfulapiUser");
            return (Criteria) this;
        }

        public Criteria andRestfulapiUserLike(String value) {
            addCriterion("restfulapi_user like", value, "restfulapiUser");
            return (Criteria) this;
        }

        public Criteria andRestfulapiUserNotLike(String value) {
            addCriterion("restfulapi_user not like", value, "restfulapiUser");
            return (Criteria) this;
        }

        public Criteria andRestfulapiUserIn(List<String> values) {
            addCriterion("restfulapi_user in", values, "restfulapiUser");
            return (Criteria) this;
        }

        public Criteria andRestfulapiUserNotIn(List<String> values) {
            addCriterion("restfulapi_user not in", values, "restfulapiUser");
            return (Criteria) this;
        }

        public Criteria andRestfulapiUserBetween(String value1, String value2) {
            addCriterion("restfulapi_user between", value1, value2, "restfulapiUser");
            return (Criteria) this;
        }

        public Criteria andRestfulapiUserNotBetween(String value1, String value2) {
            addCriterion("restfulapi_user not between", value1, value2, "restfulapiUser");
            return (Criteria) this;
        }

        public Criteria andRestfulapiAddressIsNull() {
            addCriterion("restfulapi_address is null");
            return (Criteria) this;
        }

        public Criteria andRestfulapiAddressIsNotNull() {
            addCriterion("restfulapi_address is not null");
            return (Criteria) this;
        }

        public Criteria andRestfulapiAddressEqualTo(String value) {
            addCriterion("restfulapi_address =", value, "restfulapiAddress");
            return (Criteria) this;
        }

        public Criteria andRestfulapiAddressNotEqualTo(String value) {
            addCriterion("restfulapi_address <>", value, "restfulapiAddress");
            return (Criteria) this;
        }

        public Criteria andRestfulapiAddressGreaterThan(String value) {
            addCriterion("restfulapi_address >", value, "restfulapiAddress");
            return (Criteria) this;
        }

        public Criteria andRestfulapiAddressGreaterThanOrEqualTo(String value) {
            addCriterion("restfulapi_address >=", value, "restfulapiAddress");
            return (Criteria) this;
        }

        public Criteria andRestfulapiAddressLessThan(String value) {
            addCriterion("restfulapi_address <", value, "restfulapiAddress");
            return (Criteria) this;
        }

        public Criteria andRestfulapiAddressLessThanOrEqualTo(String value) {
            addCriterion("restfulapi_address <=", value, "restfulapiAddress");
            return (Criteria) this;
        }

        public Criteria andRestfulapiAddressLike(String value) {
            addCriterion("restfulapi_address like", value, "restfulapiAddress");
            return (Criteria) this;
        }

        public Criteria andRestfulapiAddressNotLike(String value) {
            addCriterion("restfulapi_address not like", value, "restfulapiAddress");
            return (Criteria) this;
        }

        public Criteria andRestfulapiAddressIn(List<String> values) {
            addCriterion("restfulapi_address in", values, "restfulapiAddress");
            return (Criteria) this;
        }

        public Criteria andRestfulapiAddressNotIn(List<String> values) {
            addCriterion("restfulapi_address not in", values, "restfulapiAddress");
            return (Criteria) this;
        }

        public Criteria andRestfulapiAddressBetween(String value1, String value2) {
            addCriterion("restfulapi_address between", value1, value2, "restfulapiAddress");
            return (Criteria) this;
        }

        public Criteria andRestfulapiAddressNotBetween(String value1, String value2) {
            addCriterion("restfulapi_address not between", value1, value2, "restfulapiAddress");
            return (Criteria) this;
        }

        public Criteria andRestfulapiPortIsNull() {
            addCriterion("restfulapi_port is null");
            return (Criteria) this;
        }

        public Criteria andRestfulapiPortIsNotNull() {
            addCriterion("restfulapi_port is not null");
            return (Criteria) this;
        }

        public Criteria andRestfulapiPortEqualTo(String value) {
            addCriterion("restfulapi_port =", value, "restfulapiPort");
            return (Criteria) this;
        }

        public Criteria andRestfulapiPortNotEqualTo(String value) {
            addCriterion("restfulapi_port <>", value, "restfulapiPort");
            return (Criteria) this;
        }

        public Criteria andRestfulapiPortGreaterThan(String value) {
            addCriterion("restfulapi_port >", value, "restfulapiPort");
            return (Criteria) this;
        }

        public Criteria andRestfulapiPortGreaterThanOrEqualTo(String value) {
            addCriterion("restfulapi_port >=", value, "restfulapiPort");
            return (Criteria) this;
        }

        public Criteria andRestfulapiPortLessThan(String value) {
            addCriterion("restfulapi_port <", value, "restfulapiPort");
            return (Criteria) this;
        }

        public Criteria andRestfulapiPortLessThanOrEqualTo(String value) {
            addCriterion("restfulapi_port <=", value, "restfulapiPort");
            return (Criteria) this;
        }

        public Criteria andRestfulapiPortLike(String value) {
            addCriterion("restfulapi_port like", value, "restfulapiPort");
            return (Criteria) this;
        }

        public Criteria andRestfulapiPortNotLike(String value) {
            addCriterion("restfulapi_port not like", value, "restfulapiPort");
            return (Criteria) this;
        }

        public Criteria andRestfulapiPortIn(List<String> values) {
            addCriterion("restfulapi_port in", values, "restfulapiPort");
            return (Criteria) this;
        }

        public Criteria andRestfulapiPortNotIn(List<String> values) {
            addCriterion("restfulapi_port not in", values, "restfulapiPort");
            return (Criteria) this;
        }

        public Criteria andRestfulapiPortBetween(String value1, String value2) {
            addCriterion("restfulapi_port between", value1, value2, "restfulapiPort");
            return (Criteria) this;
        }

        public Criteria andRestfulapiPortNotBetween(String value1, String value2) {
            addCriterion("restfulapi_port not between", value1, value2, "restfulapiPort");
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