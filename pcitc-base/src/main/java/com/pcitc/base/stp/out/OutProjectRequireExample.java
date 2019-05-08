package com.pcitc.base.stp.out;

import java.util.ArrayList;
import java.util.List;

public class OutProjectRequireExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OutProjectRequireExample() {
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

        public Criteria andDataIdIsNull() {
            addCriterion("data_id is null");
            return (Criteria) this;
        }

        public Criteria andDataIdIsNotNull() {
            addCriterion("data_id is not null");
            return (Criteria) this;
        }

        public Criteria andDataIdEqualTo(String value) {
            addCriterion("data_id =", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotEqualTo(String value) {
            addCriterion("data_id <>", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdGreaterThan(String value) {
            addCriterion("data_id >", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdGreaterThanOrEqualTo(String value) {
            addCriterion("data_id >=", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdLessThan(String value) {
            addCriterion("data_id <", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdLessThanOrEqualTo(String value) {
            addCriterion("data_id <=", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdLike(String value) {
            addCriterion("data_id like", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotLike(String value) {
            addCriterion("data_id not like", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdIn(List<String> values) {
            addCriterion("data_id in", values, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotIn(List<String> values) {
            addCriterion("data_id not in", values, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdBetween(String value1, String value2) {
            addCriterion("data_id between", value1, value2, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotBetween(String value1, String value2) {
            addCriterion("data_id not between", value1, value2, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataCodeIsNull() {
            addCriterion("data_code is null");
            return (Criteria) this;
        }

        public Criteria andDataCodeIsNotNull() {
            addCriterion("data_code is not null");
            return (Criteria) this;
        }

        public Criteria andDataCodeEqualTo(String value) {
            addCriterion("data_code =", value, "dataCode");
            return (Criteria) this;
        }

        public Criteria andDataCodeNotEqualTo(String value) {
            addCriterion("data_code <>", value, "dataCode");
            return (Criteria) this;
        }

        public Criteria andDataCodeGreaterThan(String value) {
            addCriterion("data_code >", value, "dataCode");
            return (Criteria) this;
        }

        public Criteria andDataCodeGreaterThanOrEqualTo(String value) {
            addCriterion("data_code >=", value, "dataCode");
            return (Criteria) this;
        }

        public Criteria andDataCodeLessThan(String value) {
            addCriterion("data_code <", value, "dataCode");
            return (Criteria) this;
        }

        public Criteria andDataCodeLessThanOrEqualTo(String value) {
            addCriterion("data_code <=", value, "dataCode");
            return (Criteria) this;
        }

        public Criteria andDataCodeLike(String value) {
            addCriterion("data_code like", value, "dataCode");
            return (Criteria) this;
        }

        public Criteria andDataCodeNotLike(String value) {
            addCriterion("data_code not like", value, "dataCode");
            return (Criteria) this;
        }

        public Criteria andDataCodeIn(List<String> values) {
            addCriterion("data_code in", values, "dataCode");
            return (Criteria) this;
        }

        public Criteria andDataCodeNotIn(List<String> values) {
            addCriterion("data_code not in", values, "dataCode");
            return (Criteria) this;
        }

        public Criteria andDataCodeBetween(String value1, String value2) {
            addCriterion("data_code between", value1, value2, "dataCode");
            return (Criteria) this;
        }

        public Criteria andDataCodeNotBetween(String value1, String value2) {
            addCriterion("data_code not between", value1, value2, "dataCode");
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

        public Criteria andCreateUserIdIsNull() {
            addCriterion("create_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("create_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(String value) {
            addCriterion("create_user_id =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(String value) {
            addCriterion("create_user_id <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(String value) {
            addCriterion("create_user_id >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("create_user_id >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(String value) {
            addCriterion("create_user_id <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(String value) {
            addCriterion("create_user_id <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLike(String value) {
            addCriterion("create_user_id like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotLike(String value) {
            addCriterion("create_user_id not like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<String> values) {
            addCriterion("create_user_id in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<String> values) {
            addCriterion("create_user_id not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(String value1, String value2) {
            addCriterion("create_user_id between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(String value1, String value2) {
            addCriterion("create_user_id not between", value1, value2, "createUserId");
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

        public Criteria andStsIsNull() {
            addCriterion("sts is null");
            return (Criteria) this;
        }

        public Criteria andStsIsNotNull() {
            addCriterion("sts is not null");
            return (Criteria) this;
        }

        public Criteria andStsEqualTo(String value) {
            addCriterion("sts =", value, "sts");
            return (Criteria) this;
        }

        public Criteria andStsNotEqualTo(String value) {
            addCriterion("sts <>", value, "sts");
            return (Criteria) this;
        }

        public Criteria andStsGreaterThan(String value) {
            addCriterion("sts >", value, "sts");
            return (Criteria) this;
        }

        public Criteria andStsGreaterThanOrEqualTo(String value) {
            addCriterion("sts >=", value, "sts");
            return (Criteria) this;
        }

        public Criteria andStsLessThan(String value) {
            addCriterion("sts <", value, "sts");
            return (Criteria) this;
        }

        public Criteria andStsLessThanOrEqualTo(String value) {
            addCriterion("sts <=", value, "sts");
            return (Criteria) this;
        }

        public Criteria andStsLike(String value) {
            addCriterion("sts like", value, "sts");
            return (Criteria) this;
        }

        public Criteria andStsNotLike(String value) {
            addCriterion("sts not like", value, "sts");
            return (Criteria) this;
        }

        public Criteria andStsIn(List<String> values) {
            addCriterion("sts in", values, "sts");
            return (Criteria) this;
        }

        public Criteria andStsNotIn(List<String> values) {
            addCriterion("sts not in", values, "sts");
            return (Criteria) this;
        }

        public Criteria andStsBetween(String value1, String value2) {
            addCriterion("sts between", value1, value2, "sts");
            return (Criteria) this;
        }

        public Criteria andStsNotBetween(String value1, String value2) {
            addCriterion("sts not between", value1, value2, "sts");
            return (Criteria) this;
        }

        public Criteria andAuditStsIsNull() {
            addCriterion("audit_sts is null");
            return (Criteria) this;
        }

        public Criteria andAuditStsIsNotNull() {
            addCriterion("audit_sts is not null");
            return (Criteria) this;
        }

        public Criteria andAuditStsEqualTo(String value) {
            addCriterion("audit_sts =", value, "auditSts");
            return (Criteria) this;
        }

        public Criteria andAuditStsNotEqualTo(String value) {
            addCriterion("audit_sts <>", value, "auditSts");
            return (Criteria) this;
        }

        public Criteria andAuditStsGreaterThan(String value) {
            addCriterion("audit_sts >", value, "auditSts");
            return (Criteria) this;
        }

        public Criteria andAuditStsGreaterThanOrEqualTo(String value) {
            addCriterion("audit_sts >=", value, "auditSts");
            return (Criteria) this;
        }

        public Criteria andAuditStsLessThan(String value) {
            addCriterion("audit_sts <", value, "auditSts");
            return (Criteria) this;
        }

        public Criteria andAuditStsLessThanOrEqualTo(String value) {
            addCriterion("audit_sts <=", value, "auditSts");
            return (Criteria) this;
        }

        public Criteria andAuditStsLike(String value) {
            addCriterion("audit_sts like", value, "auditSts");
            return (Criteria) this;
        }

        public Criteria andAuditStsNotLike(String value) {
            addCriterion("audit_sts not like", value, "auditSts");
            return (Criteria) this;
        }

        public Criteria andAuditStsIn(List<String> values) {
            addCriterion("audit_sts in", values, "auditSts");
            return (Criteria) this;
        }

        public Criteria andAuditStsNotIn(List<String> values) {
            addCriterion("audit_sts not in", values, "auditSts");
            return (Criteria) this;
        }

        public Criteria andAuditStsBetween(String value1, String value2) {
            addCriterion("audit_sts between", value1, value2, "auditSts");
            return (Criteria) this;
        }

        public Criteria andAuditStsNotBetween(String value1, String value2) {
            addCriterion("audit_sts not between", value1, value2, "auditSts");
            return (Criteria) this;
        }

        public Criteria andProjectRequireCodeIsNull() {
            addCriterion("project_require_code is null");
            return (Criteria) this;
        }

        public Criteria andProjectRequireCodeIsNotNull() {
            addCriterion("project_require_code is not null");
            return (Criteria) this;
        }

        public Criteria andProjectRequireCodeEqualTo(String value) {
            addCriterion("project_require_code =", value, "projectRequireCode");
            return (Criteria) this;
        }

        public Criteria andProjectRequireCodeNotEqualTo(String value) {
            addCriterion("project_require_code <>", value, "projectRequireCode");
            return (Criteria) this;
        }

        public Criteria andProjectRequireCodeGreaterThan(String value) {
            addCriterion("project_require_code >", value, "projectRequireCode");
            return (Criteria) this;
        }

        public Criteria andProjectRequireCodeGreaterThanOrEqualTo(String value) {
            addCriterion("project_require_code >=", value, "projectRequireCode");
            return (Criteria) this;
        }

        public Criteria andProjectRequireCodeLessThan(String value) {
            addCriterion("project_require_code <", value, "projectRequireCode");
            return (Criteria) this;
        }

        public Criteria andProjectRequireCodeLessThanOrEqualTo(String value) {
            addCriterion("project_require_code <=", value, "projectRequireCode");
            return (Criteria) this;
        }

        public Criteria andProjectRequireCodeLike(String value) {
            addCriterion("project_require_code like", value, "projectRequireCode");
            return (Criteria) this;
        }

        public Criteria andProjectRequireCodeNotLike(String value) {
            addCriterion("project_require_code not like", value, "projectRequireCode");
            return (Criteria) this;
        }

        public Criteria andProjectRequireCodeIn(List<String> values) {
            addCriterion("project_require_code in", values, "projectRequireCode");
            return (Criteria) this;
        }

        public Criteria andProjectRequireCodeNotIn(List<String> values) {
            addCriterion("project_require_code not in", values, "projectRequireCode");
            return (Criteria) this;
        }

        public Criteria andProjectRequireCodeBetween(String value1, String value2) {
            addCriterion("project_require_code between", value1, value2, "projectRequireCode");
            return (Criteria) this;
        }

        public Criteria andProjectRequireCodeNotBetween(String value1, String value2) {
            addCriterion("project_require_code not between", value1, value2, "projectRequireCode");
            return (Criteria) this;
        }

        public Criteria andProjectContentIsNull() {
            addCriterion("project_content is null");
            return (Criteria) this;
        }

        public Criteria andProjectContentIsNotNull() {
            addCriterion("project_content is not null");
            return (Criteria) this;
        }

        public Criteria andProjectContentEqualTo(String value) {
            addCriterion("project_content =", value, "projectContent");
            return (Criteria) this;
        }

        public Criteria andProjectContentNotEqualTo(String value) {
            addCriterion("project_content <>", value, "projectContent");
            return (Criteria) this;
        }

        public Criteria andProjectContentGreaterThan(String value) {
            addCriterion("project_content >", value, "projectContent");
            return (Criteria) this;
        }

        public Criteria andProjectContentGreaterThanOrEqualTo(String value) {
            addCriterion("project_content >=", value, "projectContent");
            return (Criteria) this;
        }

        public Criteria andProjectContentLessThan(String value) {
            addCriterion("project_content <", value, "projectContent");
            return (Criteria) this;
        }

        public Criteria andProjectContentLessThanOrEqualTo(String value) {
            addCriterion("project_content <=", value, "projectContent");
            return (Criteria) this;
        }

        public Criteria andProjectContentLike(String value) {
            addCriterion("project_content like", value, "projectContent");
            return (Criteria) this;
        }

        public Criteria andProjectContentNotLike(String value) {
            addCriterion("project_content not like", value, "projectContent");
            return (Criteria) this;
        }

        public Criteria andProjectContentIn(List<String> values) {
            addCriterion("project_content in", values, "projectContent");
            return (Criteria) this;
        }

        public Criteria andProjectContentNotIn(List<String> values) {
            addCriterion("project_content not in", values, "projectContent");
            return (Criteria) this;
        }

        public Criteria andProjectContentBetween(String value1, String value2) {
            addCriterion("project_content between", value1, value2, "projectContent");
            return (Criteria) this;
        }

        public Criteria andProjectContentNotBetween(String value1, String value2) {
            addCriterion("project_content not between", value1, value2, "projectContent");
            return (Criteria) this;
        }

        public Criteria andProjectCommitUserIsNull() {
            addCriterion("project_commit_user is null");
            return (Criteria) this;
        }

        public Criteria andProjectCommitUserIsNotNull() {
            addCriterion("project_commit_user is not null");
            return (Criteria) this;
        }

        public Criteria andProjectCommitUserEqualTo(String value) {
            addCriterion("project_commit_user =", value, "projectCommitUser");
            return (Criteria) this;
        }

        public Criteria andProjectCommitUserNotEqualTo(String value) {
            addCriterion("project_commit_user <>", value, "projectCommitUser");
            return (Criteria) this;
        }

        public Criteria andProjectCommitUserGreaterThan(String value) {
            addCriterion("project_commit_user >", value, "projectCommitUser");
            return (Criteria) this;
        }

        public Criteria andProjectCommitUserGreaterThanOrEqualTo(String value) {
            addCriterion("project_commit_user >=", value, "projectCommitUser");
            return (Criteria) this;
        }

        public Criteria andProjectCommitUserLessThan(String value) {
            addCriterion("project_commit_user <", value, "projectCommitUser");
            return (Criteria) this;
        }

        public Criteria andProjectCommitUserLessThanOrEqualTo(String value) {
            addCriterion("project_commit_user <=", value, "projectCommitUser");
            return (Criteria) this;
        }

        public Criteria andProjectCommitUserLike(String value) {
            addCriterion("project_commit_user like", value, "projectCommitUser");
            return (Criteria) this;
        }

        public Criteria andProjectCommitUserNotLike(String value) {
            addCriterion("project_commit_user not like", value, "projectCommitUser");
            return (Criteria) this;
        }

        public Criteria andProjectCommitUserIn(List<String> values) {
            addCriterion("project_commit_user in", values, "projectCommitUser");
            return (Criteria) this;
        }

        public Criteria andProjectCommitUserNotIn(List<String> values) {
            addCriterion("project_commit_user not in", values, "projectCommitUser");
            return (Criteria) this;
        }

        public Criteria andProjectCommitUserBetween(String value1, String value2) {
            addCriterion("project_commit_user between", value1, value2, "projectCommitUser");
            return (Criteria) this;
        }

        public Criteria andProjectCommitUserNotBetween(String value1, String value2) {
            addCriterion("project_commit_user not between", value1, value2, "projectCommitUser");
            return (Criteria) this;
        }

        public Criteria andProjectCommitUserIdIsNull() {
            addCriterion("project_commit_user_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectCommitUserIdIsNotNull() {
            addCriterion("project_commit_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectCommitUserIdEqualTo(String value) {
            addCriterion("project_commit_user_id =", value, "projectCommitUserId");
            return (Criteria) this;
        }

        public Criteria andProjectCommitUserIdNotEqualTo(String value) {
            addCriterion("project_commit_user_id <>", value, "projectCommitUserId");
            return (Criteria) this;
        }

        public Criteria andProjectCommitUserIdGreaterThan(String value) {
            addCriterion("project_commit_user_id >", value, "projectCommitUserId");
            return (Criteria) this;
        }

        public Criteria andProjectCommitUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("project_commit_user_id >=", value, "projectCommitUserId");
            return (Criteria) this;
        }

        public Criteria andProjectCommitUserIdLessThan(String value) {
            addCriterion("project_commit_user_id <", value, "projectCommitUserId");
            return (Criteria) this;
        }

        public Criteria andProjectCommitUserIdLessThanOrEqualTo(String value) {
            addCriterion("project_commit_user_id <=", value, "projectCommitUserId");
            return (Criteria) this;
        }

        public Criteria andProjectCommitUserIdLike(String value) {
            addCriterion("project_commit_user_id like", value, "projectCommitUserId");
            return (Criteria) this;
        }

        public Criteria andProjectCommitUserIdNotLike(String value) {
            addCriterion("project_commit_user_id not like", value, "projectCommitUserId");
            return (Criteria) this;
        }

        public Criteria andProjectCommitUserIdIn(List<String> values) {
            addCriterion("project_commit_user_id in", values, "projectCommitUserId");
            return (Criteria) this;
        }

        public Criteria andProjectCommitUserIdNotIn(List<String> values) {
            addCriterion("project_commit_user_id not in", values, "projectCommitUserId");
            return (Criteria) this;
        }

        public Criteria andProjectCommitUserIdBetween(String value1, String value2) {
            addCriterion("project_commit_user_id between", value1, value2, "projectCommitUserId");
            return (Criteria) this;
        }

        public Criteria andProjectCommitUserIdNotBetween(String value1, String value2) {
            addCriterion("project_commit_user_id not between", value1, value2, "projectCommitUserId");
            return (Criteria) this;
        }

        public Criteria andProjectRequireTypeIsNull() {
            addCriterion("project_require_type is null");
            return (Criteria) this;
        }

        public Criteria andProjectRequireTypeIsNotNull() {
            addCriterion("project_require_type is not null");
            return (Criteria) this;
        }

        public Criteria andProjectRequireTypeEqualTo(String value) {
            addCriterion("project_require_type =", value, "projectRequireType");
            return (Criteria) this;
        }

        public Criteria andProjectRequireTypeNotEqualTo(String value) {
            addCriterion("project_require_type <>", value, "projectRequireType");
            return (Criteria) this;
        }

        public Criteria andProjectRequireTypeGreaterThan(String value) {
            addCriterion("project_require_type >", value, "projectRequireType");
            return (Criteria) this;
        }

        public Criteria andProjectRequireTypeGreaterThanOrEqualTo(String value) {
            addCriterion("project_require_type >=", value, "projectRequireType");
            return (Criteria) this;
        }

        public Criteria andProjectRequireTypeLessThan(String value) {
            addCriterion("project_require_type <", value, "projectRequireType");
            return (Criteria) this;
        }

        public Criteria andProjectRequireTypeLessThanOrEqualTo(String value) {
            addCriterion("project_require_type <=", value, "projectRequireType");
            return (Criteria) this;
        }

        public Criteria andProjectRequireTypeLike(String value) {
            addCriterion("project_require_type like", value, "projectRequireType");
            return (Criteria) this;
        }

        public Criteria andProjectRequireTypeNotLike(String value) {
            addCriterion("project_require_type not like", value, "projectRequireType");
            return (Criteria) this;
        }

        public Criteria andProjectRequireTypeIn(List<String> values) {
            addCriterion("project_require_type in", values, "projectRequireType");
            return (Criteria) this;
        }

        public Criteria andProjectRequireTypeNotIn(List<String> values) {
            addCriterion("project_require_type not in", values, "projectRequireType");
            return (Criteria) this;
        }

        public Criteria andProjectRequireTypeBetween(String value1, String value2) {
            addCriterion("project_require_type between", value1, value2, "projectRequireType");
            return (Criteria) this;
        }

        public Criteria andProjectRequireTypeNotBetween(String value1, String value2) {
            addCriterion("project_require_type not between", value1, value2, "projectRequireType");
            return (Criteria) this;
        }

        public Criteria andProjectStartDateIsNull() {
            addCriterion("project_start_date is null");
            return (Criteria) this;
        }

        public Criteria andProjectStartDateIsNotNull() {
            addCriterion("project_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andProjectStartDateEqualTo(String value) {
            addCriterion("project_start_date =", value, "projectStartDate");
            return (Criteria) this;
        }

        public Criteria andProjectStartDateNotEqualTo(String value) {
            addCriterion("project_start_date <>", value, "projectStartDate");
            return (Criteria) this;
        }

        public Criteria andProjectStartDateGreaterThan(String value) {
            addCriterion("project_start_date >", value, "projectStartDate");
            return (Criteria) this;
        }

        public Criteria andProjectStartDateGreaterThanOrEqualTo(String value) {
            addCriterion("project_start_date >=", value, "projectStartDate");
            return (Criteria) this;
        }

        public Criteria andProjectStartDateLessThan(String value) {
            addCriterion("project_start_date <", value, "projectStartDate");
            return (Criteria) this;
        }

        public Criteria andProjectStartDateLessThanOrEqualTo(String value) {
            addCriterion("project_start_date <=", value, "projectStartDate");
            return (Criteria) this;
        }

        public Criteria andProjectStartDateLike(String value) {
            addCriterion("project_start_date like", value, "projectStartDate");
            return (Criteria) this;
        }

        public Criteria andProjectStartDateNotLike(String value) {
            addCriterion("project_start_date not like", value, "projectStartDate");
            return (Criteria) this;
        }

        public Criteria andProjectStartDateIn(List<String> values) {
            addCriterion("project_start_date in", values, "projectStartDate");
            return (Criteria) this;
        }

        public Criteria andProjectStartDateNotIn(List<String> values) {
            addCriterion("project_start_date not in", values, "projectStartDate");
            return (Criteria) this;
        }

        public Criteria andProjectStartDateBetween(String value1, String value2) {
            addCriterion("project_start_date between", value1, value2, "projectStartDate");
            return (Criteria) this;
        }

        public Criteria andProjectStartDateNotBetween(String value1, String value2) {
            addCriterion("project_start_date not between", value1, value2, "projectStartDate");
            return (Criteria) this;
        }

        public Criteria andProjectEndDateIsNull() {
            addCriterion("project_end_date is null");
            return (Criteria) this;
        }

        public Criteria andProjectEndDateIsNotNull() {
            addCriterion("project_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andProjectEndDateEqualTo(String value) {
            addCriterion("project_end_date =", value, "projectEndDate");
            return (Criteria) this;
        }

        public Criteria andProjectEndDateNotEqualTo(String value) {
            addCriterion("project_end_date <>", value, "projectEndDate");
            return (Criteria) this;
        }

        public Criteria andProjectEndDateGreaterThan(String value) {
            addCriterion("project_end_date >", value, "projectEndDate");
            return (Criteria) this;
        }

        public Criteria andProjectEndDateGreaterThanOrEqualTo(String value) {
            addCriterion("project_end_date >=", value, "projectEndDate");
            return (Criteria) this;
        }

        public Criteria andProjectEndDateLessThan(String value) {
            addCriterion("project_end_date <", value, "projectEndDate");
            return (Criteria) this;
        }

        public Criteria andProjectEndDateLessThanOrEqualTo(String value) {
            addCriterion("project_end_date <=", value, "projectEndDate");
            return (Criteria) this;
        }

        public Criteria andProjectEndDateLike(String value) {
            addCriterion("project_end_date like", value, "projectEndDate");
            return (Criteria) this;
        }

        public Criteria andProjectEndDateNotLike(String value) {
            addCriterion("project_end_date not like", value, "projectEndDate");
            return (Criteria) this;
        }

        public Criteria andProjectEndDateIn(List<String> values) {
            addCriterion("project_end_date in", values, "projectEndDate");
            return (Criteria) this;
        }

        public Criteria andProjectEndDateNotIn(List<String> values) {
            addCriterion("project_end_date not in", values, "projectEndDate");
            return (Criteria) this;
        }

        public Criteria andProjectEndDateBetween(String value1, String value2) {
            addCriterion("project_end_date between", value1, value2, "projectEndDate");
            return (Criteria) this;
        }

        public Criteria andProjectEndDateNotBetween(String value1, String value2) {
            addCriterion("project_end_date not between", value1, value2, "projectEndDate");
            return (Criteria) this;
        }

        public Criteria andProjectNdIsNull() {
            addCriterion("project_nd is null");
            return (Criteria) this;
        }

        public Criteria andProjectNdIsNotNull() {
            addCriterion("project_nd is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNdEqualTo(String value) {
            addCriterion("project_nd =", value, "projectNd");
            return (Criteria) this;
        }

        public Criteria andProjectNdNotEqualTo(String value) {
            addCriterion("project_nd <>", value, "projectNd");
            return (Criteria) this;
        }

        public Criteria andProjectNdGreaterThan(String value) {
            addCriterion("project_nd >", value, "projectNd");
            return (Criteria) this;
        }

        public Criteria andProjectNdGreaterThanOrEqualTo(String value) {
            addCriterion("project_nd >=", value, "projectNd");
            return (Criteria) this;
        }

        public Criteria andProjectNdLessThan(String value) {
            addCriterion("project_nd <", value, "projectNd");
            return (Criteria) this;
        }

        public Criteria andProjectNdLessThanOrEqualTo(String value) {
            addCriterion("project_nd <=", value, "projectNd");
            return (Criteria) this;
        }

        public Criteria andProjectNdLike(String value) {
            addCriterion("project_nd like", value, "projectNd");
            return (Criteria) this;
        }

        public Criteria andProjectNdNotLike(String value) {
            addCriterion("project_nd not like", value, "projectNd");
            return (Criteria) this;
        }

        public Criteria andProjectNdIn(List<String> values) {
            addCriterion("project_nd in", values, "projectNd");
            return (Criteria) this;
        }

        public Criteria andProjectNdNotIn(List<String> values) {
            addCriterion("project_nd not in", values, "projectNd");
            return (Criteria) this;
        }

        public Criteria andProjectNdBetween(String value1, String value2) {
            addCriterion("project_nd between", value1, value2, "projectNd");
            return (Criteria) this;
        }

        public Criteria andProjectNdNotBetween(String value1, String value2) {
            addCriterion("project_nd not between", value1, value2, "projectNd");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyIsNull() {
            addCriterion("project_money is null");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyIsNotNull() {
            addCriterion("project_money is not null");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyEqualTo(String value) {
            addCriterion("project_money =", value, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyNotEqualTo(String value) {
            addCriterion("project_money <>", value, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyGreaterThan(String value) {
            addCriterion("project_money >", value, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("project_money >=", value, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyLessThan(String value) {
            addCriterion("project_money <", value, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyLessThanOrEqualTo(String value) {
            addCriterion("project_money <=", value, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyLike(String value) {
            addCriterion("project_money like", value, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyNotLike(String value) {
            addCriterion("project_money not like", value, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyIn(List<String> values) {
            addCriterion("project_money in", values, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyNotIn(List<String> values) {
            addCriterion("project_money not in", values, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyBetween(String value1, String value2) {
            addCriterion("project_money between", value1, value2, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyNotBetween(String value1, String value2) {
            addCriterion("project_money not between", value1, value2, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectNdMoneyIsNull() {
            addCriterion("project_nd_money is null");
            return (Criteria) this;
        }

        public Criteria andProjectNdMoneyIsNotNull() {
            addCriterion("project_nd_money is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNdMoneyEqualTo(String value) {
            addCriterion("project_nd_money =", value, "projectNdMoney");
            return (Criteria) this;
        }

        public Criteria andProjectNdMoneyNotEqualTo(String value) {
            addCriterion("project_nd_money <>", value, "projectNdMoney");
            return (Criteria) this;
        }

        public Criteria andProjectNdMoneyGreaterThan(String value) {
            addCriterion("project_nd_money >", value, "projectNdMoney");
            return (Criteria) this;
        }

        public Criteria andProjectNdMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("project_nd_money >=", value, "projectNdMoney");
            return (Criteria) this;
        }

        public Criteria andProjectNdMoneyLessThan(String value) {
            addCriterion("project_nd_money <", value, "projectNdMoney");
            return (Criteria) this;
        }

        public Criteria andProjectNdMoneyLessThanOrEqualTo(String value) {
            addCriterion("project_nd_money <=", value, "projectNdMoney");
            return (Criteria) this;
        }

        public Criteria andProjectNdMoneyLike(String value) {
            addCriterion("project_nd_money like", value, "projectNdMoney");
            return (Criteria) this;
        }

        public Criteria andProjectNdMoneyNotLike(String value) {
            addCriterion("project_nd_money not like", value, "projectNdMoney");
            return (Criteria) this;
        }

        public Criteria andProjectNdMoneyIn(List<String> values) {
            addCriterion("project_nd_money in", values, "projectNdMoney");
            return (Criteria) this;
        }

        public Criteria andProjectNdMoneyNotIn(List<String> values) {
            addCriterion("project_nd_money not in", values, "projectNdMoney");
            return (Criteria) this;
        }

        public Criteria andProjectNdMoneyBetween(String value1, String value2) {
            addCriterion("project_nd_money between", value1, value2, "projectNdMoney");
            return (Criteria) this;
        }

        public Criteria andProjectNdMoneyNotBetween(String value1, String value2) {
            addCriterion("project_nd_money not between", value1, value2, "projectNdMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMajorUnitIsNull() {
            addCriterion("project_major_unit is null");
            return (Criteria) this;
        }

        public Criteria andProjectMajorUnitIsNotNull() {
            addCriterion("project_major_unit is not null");
            return (Criteria) this;
        }

        public Criteria andProjectMajorUnitEqualTo(String value) {
            addCriterion("project_major_unit =", value, "projectMajorUnit");
            return (Criteria) this;
        }

        public Criteria andProjectMajorUnitNotEqualTo(String value) {
            addCriterion("project_major_unit <>", value, "projectMajorUnit");
            return (Criteria) this;
        }

        public Criteria andProjectMajorUnitGreaterThan(String value) {
            addCriterion("project_major_unit >", value, "projectMajorUnit");
            return (Criteria) this;
        }

        public Criteria andProjectMajorUnitGreaterThanOrEqualTo(String value) {
            addCriterion("project_major_unit >=", value, "projectMajorUnit");
            return (Criteria) this;
        }

        public Criteria andProjectMajorUnitLessThan(String value) {
            addCriterion("project_major_unit <", value, "projectMajorUnit");
            return (Criteria) this;
        }

        public Criteria andProjectMajorUnitLessThanOrEqualTo(String value) {
            addCriterion("project_major_unit <=", value, "projectMajorUnit");
            return (Criteria) this;
        }

        public Criteria andProjectMajorUnitLike(String value) {
            addCriterion("project_major_unit like", value, "projectMajorUnit");
            return (Criteria) this;
        }

        public Criteria andProjectMajorUnitNotLike(String value) {
            addCriterion("project_major_unit not like", value, "projectMajorUnit");
            return (Criteria) this;
        }

        public Criteria andProjectMajorUnitIn(List<String> values) {
            addCriterion("project_major_unit in", values, "projectMajorUnit");
            return (Criteria) this;
        }

        public Criteria andProjectMajorUnitNotIn(List<String> values) {
            addCriterion("project_major_unit not in", values, "projectMajorUnit");
            return (Criteria) this;
        }

        public Criteria andProjectMajorUnitBetween(String value1, String value2) {
            addCriterion("project_major_unit between", value1, value2, "projectMajorUnit");
            return (Criteria) this;
        }

        public Criteria andProjectMajorUnitNotBetween(String value1, String value2) {
            addCriterion("project_major_unit not between", value1, value2, "projectMajorUnit");
            return (Criteria) this;
        }

        public Criteria andProjectMajorUnitCodeIsNull() {
            addCriterion("project_major_unit_code is null");
            return (Criteria) this;
        }

        public Criteria andProjectMajorUnitCodeIsNotNull() {
            addCriterion("project_major_unit_code is not null");
            return (Criteria) this;
        }

        public Criteria andProjectMajorUnitCodeEqualTo(String value) {
            addCriterion("project_major_unit_code =", value, "projectMajorUnitCode");
            return (Criteria) this;
        }

        public Criteria andProjectMajorUnitCodeNotEqualTo(String value) {
            addCriterion("project_major_unit_code <>", value, "projectMajorUnitCode");
            return (Criteria) this;
        }

        public Criteria andProjectMajorUnitCodeGreaterThan(String value) {
            addCriterion("project_major_unit_code >", value, "projectMajorUnitCode");
            return (Criteria) this;
        }

        public Criteria andProjectMajorUnitCodeGreaterThanOrEqualTo(String value) {
            addCriterion("project_major_unit_code >=", value, "projectMajorUnitCode");
            return (Criteria) this;
        }

        public Criteria andProjectMajorUnitCodeLessThan(String value) {
            addCriterion("project_major_unit_code <", value, "projectMajorUnitCode");
            return (Criteria) this;
        }

        public Criteria andProjectMajorUnitCodeLessThanOrEqualTo(String value) {
            addCriterion("project_major_unit_code <=", value, "projectMajorUnitCode");
            return (Criteria) this;
        }

        public Criteria andProjectMajorUnitCodeLike(String value) {
            addCriterion("project_major_unit_code like", value, "projectMajorUnitCode");
            return (Criteria) this;
        }

        public Criteria andProjectMajorUnitCodeNotLike(String value) {
            addCriterion("project_major_unit_code not like", value, "projectMajorUnitCode");
            return (Criteria) this;
        }

        public Criteria andProjectMajorUnitCodeIn(List<String> values) {
            addCriterion("project_major_unit_code in", values, "projectMajorUnitCode");
            return (Criteria) this;
        }

        public Criteria andProjectMajorUnitCodeNotIn(List<String> values) {
            addCriterion("project_major_unit_code not in", values, "projectMajorUnitCode");
            return (Criteria) this;
        }

        public Criteria andProjectMajorUnitCodeBetween(String value1, String value2) {
            addCriterion("project_major_unit_code between", value1, value2, "projectMajorUnitCode");
            return (Criteria) this;
        }

        public Criteria andProjectMajorUnitCodeNotBetween(String value1, String value2) {
            addCriterion("project_major_unit_code not between", value1, value2, "projectMajorUnitCode");
            return (Criteria) this;
        }

        public Criteria andProjectSecondaryUnitIsNull() {
            addCriterion("project_secondary_unit is null");
            return (Criteria) this;
        }

        public Criteria andProjectSecondaryUnitIsNotNull() {
            addCriterion("project_secondary_unit is not null");
            return (Criteria) this;
        }

        public Criteria andProjectSecondaryUnitEqualTo(String value) {
            addCriterion("project_secondary_unit =", value, "projectSecondaryUnit");
            return (Criteria) this;
        }

        public Criteria andProjectSecondaryUnitNotEqualTo(String value) {
            addCriterion("project_secondary_unit <>", value, "projectSecondaryUnit");
            return (Criteria) this;
        }

        public Criteria andProjectSecondaryUnitGreaterThan(String value) {
            addCriterion("project_secondary_unit >", value, "projectSecondaryUnit");
            return (Criteria) this;
        }

        public Criteria andProjectSecondaryUnitGreaterThanOrEqualTo(String value) {
            addCriterion("project_secondary_unit >=", value, "projectSecondaryUnit");
            return (Criteria) this;
        }

        public Criteria andProjectSecondaryUnitLessThan(String value) {
            addCriterion("project_secondary_unit <", value, "projectSecondaryUnit");
            return (Criteria) this;
        }

        public Criteria andProjectSecondaryUnitLessThanOrEqualTo(String value) {
            addCriterion("project_secondary_unit <=", value, "projectSecondaryUnit");
            return (Criteria) this;
        }

        public Criteria andProjectSecondaryUnitLike(String value) {
            addCriterion("project_secondary_unit like", value, "projectSecondaryUnit");
            return (Criteria) this;
        }

        public Criteria andProjectSecondaryUnitNotLike(String value) {
            addCriterion("project_secondary_unit not like", value, "projectSecondaryUnit");
            return (Criteria) this;
        }

        public Criteria andProjectSecondaryUnitIn(List<String> values) {
            addCriterion("project_secondary_unit in", values, "projectSecondaryUnit");
            return (Criteria) this;
        }

        public Criteria andProjectSecondaryUnitNotIn(List<String> values) {
            addCriterion("project_secondary_unit not in", values, "projectSecondaryUnit");
            return (Criteria) this;
        }

        public Criteria andProjectSecondaryUnitBetween(String value1, String value2) {
            addCriterion("project_secondary_unit between", value1, value2, "projectSecondaryUnit");
            return (Criteria) this;
        }

        public Criteria andProjectSecondaryUnitNotBetween(String value1, String value2) {
            addCriterion("project_secondary_unit not between", value1, value2, "projectSecondaryUnit");
            return (Criteria) this;
        }

        public Criteria andProjectSecondaryUnitCodeIsNull() {
            addCriterion("project_secondary_unit_code is null");
            return (Criteria) this;
        }

        public Criteria andProjectSecondaryUnitCodeIsNotNull() {
            addCriterion("project_secondary_unit_code is not null");
            return (Criteria) this;
        }

        public Criteria andProjectSecondaryUnitCodeEqualTo(String value) {
            addCriterion("project_secondary_unit_code =", value, "projectSecondaryUnitCode");
            return (Criteria) this;
        }

        public Criteria andProjectSecondaryUnitCodeNotEqualTo(String value) {
            addCriterion("project_secondary_unit_code <>", value, "projectSecondaryUnitCode");
            return (Criteria) this;
        }

        public Criteria andProjectSecondaryUnitCodeGreaterThan(String value) {
            addCriterion("project_secondary_unit_code >", value, "projectSecondaryUnitCode");
            return (Criteria) this;
        }

        public Criteria andProjectSecondaryUnitCodeGreaterThanOrEqualTo(String value) {
            addCriterion("project_secondary_unit_code >=", value, "projectSecondaryUnitCode");
            return (Criteria) this;
        }

        public Criteria andProjectSecondaryUnitCodeLessThan(String value) {
            addCriterion("project_secondary_unit_code <", value, "projectSecondaryUnitCode");
            return (Criteria) this;
        }

        public Criteria andProjectSecondaryUnitCodeLessThanOrEqualTo(String value) {
            addCriterion("project_secondary_unit_code <=", value, "projectSecondaryUnitCode");
            return (Criteria) this;
        }

        public Criteria andProjectSecondaryUnitCodeLike(String value) {
            addCriterion("project_secondary_unit_code like", value, "projectSecondaryUnitCode");
            return (Criteria) this;
        }

        public Criteria andProjectSecondaryUnitCodeNotLike(String value) {
            addCriterion("project_secondary_unit_code not like", value, "projectSecondaryUnitCode");
            return (Criteria) this;
        }

        public Criteria andProjectSecondaryUnitCodeIn(List<String> values) {
            addCriterion("project_secondary_unit_code in", values, "projectSecondaryUnitCode");
            return (Criteria) this;
        }

        public Criteria andProjectSecondaryUnitCodeNotIn(List<String> values) {
            addCriterion("project_secondary_unit_code not in", values, "projectSecondaryUnitCode");
            return (Criteria) this;
        }

        public Criteria andProjectSecondaryUnitCodeBetween(String value1, String value2) {
            addCriterion("project_secondary_unit_code between", value1, value2, "projectSecondaryUnitCode");
            return (Criteria) this;
        }

        public Criteria andProjectSecondaryUnitCodeNotBetween(String value1, String value2) {
            addCriterion("project_secondary_unit_code not between", value1, value2, "projectSecondaryUnitCode");
            return (Criteria) this;
        }

        public Criteria andProjectContractCodeIsNull() {
            addCriterion("project_contract_code is null");
            return (Criteria) this;
        }

        public Criteria andProjectContractCodeIsNotNull() {
            addCriterion("project_contract_code is not null");
            return (Criteria) this;
        }

        public Criteria andProjectContractCodeEqualTo(String value) {
            addCriterion("project_contract_code =", value, "projectContractCode");
            return (Criteria) this;
        }

        public Criteria andProjectContractCodeNotEqualTo(String value) {
            addCriterion("project_contract_code <>", value, "projectContractCode");
            return (Criteria) this;
        }

        public Criteria andProjectContractCodeGreaterThan(String value) {
            addCriterion("project_contract_code >", value, "projectContractCode");
            return (Criteria) this;
        }

        public Criteria andProjectContractCodeGreaterThanOrEqualTo(String value) {
            addCriterion("project_contract_code >=", value, "projectContractCode");
            return (Criteria) this;
        }

        public Criteria andProjectContractCodeLessThan(String value) {
            addCriterion("project_contract_code <", value, "projectContractCode");
            return (Criteria) this;
        }

        public Criteria andProjectContractCodeLessThanOrEqualTo(String value) {
            addCriterion("project_contract_code <=", value, "projectContractCode");
            return (Criteria) this;
        }

        public Criteria andProjectContractCodeLike(String value) {
            addCriterion("project_contract_code like", value, "projectContractCode");
            return (Criteria) this;
        }

        public Criteria andProjectContractCodeNotLike(String value) {
            addCriterion("project_contract_code not like", value, "projectContractCode");
            return (Criteria) this;
        }

        public Criteria andProjectContractCodeIn(List<String> values) {
            addCriterion("project_contract_code in", values, "projectContractCode");
            return (Criteria) this;
        }

        public Criteria andProjectContractCodeNotIn(List<String> values) {
            addCriterion("project_contract_code not in", values, "projectContractCode");
            return (Criteria) this;
        }

        public Criteria andProjectContractCodeBetween(String value1, String value2) {
            addCriterion("project_contract_code between", value1, value2, "projectContractCode");
            return (Criteria) this;
        }

        public Criteria andProjectContractCodeNotBetween(String value1, String value2) {
            addCriterion("project_contract_code not between", value1, value2, "projectContractCode");
            return (Criteria) this;
        }

        public Criteria andProjectBackgroupIsNull() {
            addCriterion("project_backgroup is null");
            return (Criteria) this;
        }

        public Criteria andProjectBackgroupIsNotNull() {
            addCriterion("project_backgroup is not null");
            return (Criteria) this;
        }

        public Criteria andProjectBackgroupEqualTo(String value) {
            addCriterion("project_backgroup =", value, "projectBackgroup");
            return (Criteria) this;
        }

        public Criteria andProjectBackgroupNotEqualTo(String value) {
            addCriterion("project_backgroup <>", value, "projectBackgroup");
            return (Criteria) this;
        }

        public Criteria andProjectBackgroupGreaterThan(String value) {
            addCriterion("project_backgroup >", value, "projectBackgroup");
            return (Criteria) this;
        }

        public Criteria andProjectBackgroupGreaterThanOrEqualTo(String value) {
            addCriterion("project_backgroup >=", value, "projectBackgroup");
            return (Criteria) this;
        }

        public Criteria andProjectBackgroupLessThan(String value) {
            addCriterion("project_backgroup <", value, "projectBackgroup");
            return (Criteria) this;
        }

        public Criteria andProjectBackgroupLessThanOrEqualTo(String value) {
            addCriterion("project_backgroup <=", value, "projectBackgroup");
            return (Criteria) this;
        }

        public Criteria andProjectBackgroupLike(String value) {
            addCriterion("project_backgroup like", value, "projectBackgroup");
            return (Criteria) this;
        }

        public Criteria andProjectBackgroupNotLike(String value) {
            addCriterion("project_backgroup not like", value, "projectBackgroup");
            return (Criteria) this;
        }

        public Criteria andProjectBackgroupIn(List<String> values) {
            addCriterion("project_backgroup in", values, "projectBackgroup");
            return (Criteria) this;
        }

        public Criteria andProjectBackgroupNotIn(List<String> values) {
            addCriterion("project_backgroup not in", values, "projectBackgroup");
            return (Criteria) this;
        }

        public Criteria andProjectBackgroupBetween(String value1, String value2) {
            addCriterion("project_backgroup between", value1, value2, "projectBackgroup");
            return (Criteria) this;
        }

        public Criteria andProjectBackgroupNotBetween(String value1, String value2) {
            addCriterion("project_backgroup not between", value1, value2, "projectBackgroup");
            return (Criteria) this;
        }

        public Criteria andProjectProfessionIsNull() {
            addCriterion("project_profession is null");
            return (Criteria) this;
        }

        public Criteria andProjectProfessionIsNotNull() {
            addCriterion("project_profession is not null");
            return (Criteria) this;
        }

        public Criteria andProjectProfessionEqualTo(String value) {
            addCriterion("project_profession =", value, "projectProfession");
            return (Criteria) this;
        }

        public Criteria andProjectProfessionNotEqualTo(String value) {
            addCriterion("project_profession <>", value, "projectProfession");
            return (Criteria) this;
        }

        public Criteria andProjectProfessionGreaterThan(String value) {
            addCriterion("project_profession >", value, "projectProfession");
            return (Criteria) this;
        }

        public Criteria andProjectProfessionGreaterThanOrEqualTo(String value) {
            addCriterion("project_profession >=", value, "projectProfession");
            return (Criteria) this;
        }

        public Criteria andProjectProfessionLessThan(String value) {
            addCriterion("project_profession <", value, "projectProfession");
            return (Criteria) this;
        }

        public Criteria andProjectProfessionLessThanOrEqualTo(String value) {
            addCriterion("project_profession <=", value, "projectProfession");
            return (Criteria) this;
        }

        public Criteria andProjectProfessionLike(String value) {
            addCriterion("project_profession like", value, "projectProfession");
            return (Criteria) this;
        }

        public Criteria andProjectProfessionNotLike(String value) {
            addCriterion("project_profession not like", value, "projectProfession");
            return (Criteria) this;
        }

        public Criteria andProjectProfessionIn(List<String> values) {
            addCriterion("project_profession in", values, "projectProfession");
            return (Criteria) this;
        }

        public Criteria andProjectProfessionNotIn(List<String> values) {
            addCriterion("project_profession not in", values, "projectProfession");
            return (Criteria) this;
        }

        public Criteria andProjectProfessionBetween(String value1, String value2) {
            addCriterion("project_profession between", value1, value2, "projectProfession");
            return (Criteria) this;
        }

        public Criteria andProjectProfessionNotBetween(String value1, String value2) {
            addCriterion("project_profession not between", value1, value2, "projectProfession");
            return (Criteria) this;
        }

        public Criteria andProjectRemarksIsNull() {
            addCriterion("project_remarks is null");
            return (Criteria) this;
        }

        public Criteria andProjectRemarksIsNotNull() {
            addCriterion("project_remarks is not null");
            return (Criteria) this;
        }

        public Criteria andProjectRemarksEqualTo(String value) {
            addCriterion("project_remarks =", value, "projectRemarks");
            return (Criteria) this;
        }

        public Criteria andProjectRemarksNotEqualTo(String value) {
            addCriterion("project_remarks <>", value, "projectRemarks");
            return (Criteria) this;
        }

        public Criteria andProjectRemarksGreaterThan(String value) {
            addCriterion("project_remarks >", value, "projectRemarks");
            return (Criteria) this;
        }

        public Criteria andProjectRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("project_remarks >=", value, "projectRemarks");
            return (Criteria) this;
        }

        public Criteria andProjectRemarksLessThan(String value) {
            addCriterion("project_remarks <", value, "projectRemarks");
            return (Criteria) this;
        }

        public Criteria andProjectRemarksLessThanOrEqualTo(String value) {
            addCriterion("project_remarks <=", value, "projectRemarks");
            return (Criteria) this;
        }

        public Criteria andProjectRemarksLike(String value) {
            addCriterion("project_remarks like", value, "projectRemarks");
            return (Criteria) this;
        }

        public Criteria andProjectRemarksNotLike(String value) {
            addCriterion("project_remarks not like", value, "projectRemarks");
            return (Criteria) this;
        }

        public Criteria andProjectRemarksIn(List<String> values) {
            addCriterion("project_remarks in", values, "projectRemarks");
            return (Criteria) this;
        }

        public Criteria andProjectRemarksNotIn(List<String> values) {
            addCriterion("project_remarks not in", values, "projectRemarks");
            return (Criteria) this;
        }

        public Criteria andProjectRemarksBetween(String value1, String value2) {
            addCriterion("project_remarks between", value1, value2, "projectRemarks");
            return (Criteria) this;
        }

        public Criteria andProjectRemarksNotBetween(String value1, String value2) {
            addCriterion("project_remarks not between", value1, value2, "projectRemarks");
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

        public Criteria andBak7IsNull() {
            addCriterion("bak7 is null");
            return (Criteria) this;
        }

        public Criteria andBak7IsNotNull() {
            addCriterion("bak7 is not null");
            return (Criteria) this;
        }

        public Criteria andBak7EqualTo(String value) {
            addCriterion("bak7 =", value, "bak7");
            return (Criteria) this;
        }

        public Criteria andBak7NotEqualTo(String value) {
            addCriterion("bak7 <>", value, "bak7");
            return (Criteria) this;
        }

        public Criteria andBak7GreaterThan(String value) {
            addCriterion("bak7 >", value, "bak7");
            return (Criteria) this;
        }

        public Criteria andBak7GreaterThanOrEqualTo(String value) {
            addCriterion("bak7 >=", value, "bak7");
            return (Criteria) this;
        }

        public Criteria andBak7LessThan(String value) {
            addCriterion("bak7 <", value, "bak7");
            return (Criteria) this;
        }

        public Criteria andBak7LessThanOrEqualTo(String value) {
            addCriterion("bak7 <=", value, "bak7");
            return (Criteria) this;
        }

        public Criteria andBak7Like(String value) {
            addCriterion("bak7 like", value, "bak7");
            return (Criteria) this;
        }

        public Criteria andBak7NotLike(String value) {
            addCriterion("bak7 not like", value, "bak7");
            return (Criteria) this;
        }

        public Criteria andBak7In(List<String> values) {
            addCriterion("bak7 in", values, "bak7");
            return (Criteria) this;
        }

        public Criteria andBak7NotIn(List<String> values) {
            addCriterion("bak7 not in", values, "bak7");
            return (Criteria) this;
        }

        public Criteria andBak7Between(String value1, String value2) {
            addCriterion("bak7 between", value1, value2, "bak7");
            return (Criteria) this;
        }

        public Criteria andBak7NotBetween(String value1, String value2) {
            addCriterion("bak7 not between", value1, value2, "bak7");
            return (Criteria) this;
        }

        public Criteria andBak8IsNull() {
            addCriterion("bak8 is null");
            return (Criteria) this;
        }

        public Criteria andBak8IsNotNull() {
            addCriterion("bak8 is not null");
            return (Criteria) this;
        }

        public Criteria andBak8EqualTo(String value) {
            addCriterion("bak8 =", value, "bak8");
            return (Criteria) this;
        }

        public Criteria andBak8NotEqualTo(String value) {
            addCriterion("bak8 <>", value, "bak8");
            return (Criteria) this;
        }

        public Criteria andBak8GreaterThan(String value) {
            addCriterion("bak8 >", value, "bak8");
            return (Criteria) this;
        }

        public Criteria andBak8GreaterThanOrEqualTo(String value) {
            addCriterion("bak8 >=", value, "bak8");
            return (Criteria) this;
        }

        public Criteria andBak8LessThan(String value) {
            addCriterion("bak8 <", value, "bak8");
            return (Criteria) this;
        }

        public Criteria andBak8LessThanOrEqualTo(String value) {
            addCriterion("bak8 <=", value, "bak8");
            return (Criteria) this;
        }

        public Criteria andBak8Like(String value) {
            addCriterion("bak8 like", value, "bak8");
            return (Criteria) this;
        }

        public Criteria andBak8NotLike(String value) {
            addCriterion("bak8 not like", value, "bak8");
            return (Criteria) this;
        }

        public Criteria andBak8In(List<String> values) {
            addCriterion("bak8 in", values, "bak8");
            return (Criteria) this;
        }

        public Criteria andBak8NotIn(List<String> values) {
            addCriterion("bak8 not in", values, "bak8");
            return (Criteria) this;
        }

        public Criteria andBak8Between(String value1, String value2) {
            addCriterion("bak8 between", value1, value2, "bak8");
            return (Criteria) this;
        }

        public Criteria andBak8NotBetween(String value1, String value2) {
            addCriterion("bak8 not between", value1, value2, "bak8");
            return (Criteria) this;
        }

        public Criteria andBak9IsNull() {
            addCriterion("bak9 is null");
            return (Criteria) this;
        }

        public Criteria andBak9IsNotNull() {
            addCriterion("bak9 is not null");
            return (Criteria) this;
        }

        public Criteria andBak9EqualTo(String value) {
            addCriterion("bak9 =", value, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9NotEqualTo(String value) {
            addCriterion("bak9 <>", value, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9GreaterThan(String value) {
            addCriterion("bak9 >", value, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9GreaterThanOrEqualTo(String value) {
            addCriterion("bak9 >=", value, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9LessThan(String value) {
            addCriterion("bak9 <", value, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9LessThanOrEqualTo(String value) {
            addCriterion("bak9 <=", value, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9Like(String value) {
            addCriterion("bak9 like", value, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9NotLike(String value) {
            addCriterion("bak9 not like", value, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9In(List<String> values) {
            addCriterion("bak9 in", values, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9NotIn(List<String> values) {
            addCriterion("bak9 not in", values, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9Between(String value1, String value2) {
            addCriterion("bak9 between", value1, value2, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9NotBetween(String value1, String value2) {
            addCriterion("bak9 not between", value1, value2, "bak9");
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