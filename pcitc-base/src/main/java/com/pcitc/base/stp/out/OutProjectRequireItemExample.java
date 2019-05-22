package com.pcitc.base.stp.out;

import java.util.ArrayList;
import java.util.List;

public class OutProjectRequireItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OutProjectRequireItemExample() {
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

        public Criteria andRequireIdIsNull() {
            addCriterion("require_id is null");
            return (Criteria) this;
        }

        public Criteria andRequireIdIsNotNull() {
            addCriterion("require_id is not null");
            return (Criteria) this;
        }

        public Criteria andRequireIdEqualTo(String value) {
            addCriterion("require_id =", value, "requireId");
            return (Criteria) this;
        }

        public Criteria andRequireIdNotEqualTo(String value) {
            addCriterion("require_id <>", value, "requireId");
            return (Criteria) this;
        }

        public Criteria andRequireIdGreaterThan(String value) {
            addCriterion("require_id >", value, "requireId");
            return (Criteria) this;
        }

        public Criteria andRequireIdGreaterThanOrEqualTo(String value) {
            addCriterion("require_id >=", value, "requireId");
            return (Criteria) this;
        }

        public Criteria andRequireIdLessThan(String value) {
            addCriterion("require_id <", value, "requireId");
            return (Criteria) this;
        }

        public Criteria andRequireIdLessThanOrEqualTo(String value) {
            addCriterion("require_id <=", value, "requireId");
            return (Criteria) this;
        }

        public Criteria andRequireIdLike(String value) {
            addCriterion("require_id like", value, "requireId");
            return (Criteria) this;
        }

        public Criteria andRequireIdNotLike(String value) {
            addCriterion("require_id not like", value, "requireId");
            return (Criteria) this;
        }

        public Criteria andRequireIdIn(List<String> values) {
            addCriterion("require_id in", values, "requireId");
            return (Criteria) this;
        }

        public Criteria andRequireIdNotIn(List<String> values) {
            addCriterion("require_id not in", values, "requireId");
            return (Criteria) this;
        }

        public Criteria andRequireIdBetween(String value1, String value2) {
            addCriterion("require_id between", value1, value2, "requireId");
            return (Criteria) this;
        }

        public Criteria andRequireIdNotBetween(String value1, String value2) {
            addCriterion("require_id not between", value1, value2, "requireId");
            return (Criteria) this;
        }

        public Criteria andRequireItemNameIsNull() {
            addCriterion("require_item_name is null");
            return (Criteria) this;
        }

        public Criteria andRequireItemNameIsNotNull() {
            addCriterion("require_item_name is not null");
            return (Criteria) this;
        }

        public Criteria andRequireItemNameEqualTo(String value) {
            addCriterion("require_item_name =", value, "requireItemName");
            return (Criteria) this;
        }

        public Criteria andRequireItemNameNotEqualTo(String value) {
            addCriterion("require_item_name <>", value, "requireItemName");
            return (Criteria) this;
        }

        public Criteria andRequireItemNameGreaterThan(String value) {
            addCriterion("require_item_name >", value, "requireItemName");
            return (Criteria) this;
        }

        public Criteria andRequireItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("require_item_name >=", value, "requireItemName");
            return (Criteria) this;
        }

        public Criteria andRequireItemNameLessThan(String value) {
            addCriterion("require_item_name <", value, "requireItemName");
            return (Criteria) this;
        }

        public Criteria andRequireItemNameLessThanOrEqualTo(String value) {
            addCriterion("require_item_name <=", value, "requireItemName");
            return (Criteria) this;
        }

        public Criteria andRequireItemNameLike(String value) {
            addCriterion("require_item_name like", value, "requireItemName");
            return (Criteria) this;
        }

        public Criteria andRequireItemNameNotLike(String value) {
            addCriterion("require_item_name not like", value, "requireItemName");
            return (Criteria) this;
        }

        public Criteria andRequireItemNameIn(List<String> values) {
            addCriterion("require_item_name in", values, "requireItemName");
            return (Criteria) this;
        }

        public Criteria andRequireItemNameNotIn(List<String> values) {
            addCriterion("require_item_name not in", values, "requireItemName");
            return (Criteria) this;
        }

        public Criteria andRequireItemNameBetween(String value1, String value2) {
            addCriterion("require_item_name between", value1, value2, "requireItemName");
            return (Criteria) this;
        }

        public Criteria andRequireItemNameNotBetween(String value1, String value2) {
            addCriterion("require_item_name not between", value1, value2, "requireItemName");
            return (Criteria) this;
        }

        public Criteria andRequireItemCodeIsNull() {
            addCriterion("require_item_code is null");
            return (Criteria) this;
        }

        public Criteria andRequireItemCodeIsNotNull() {
            addCriterion("require_item_code is not null");
            return (Criteria) this;
        }

        public Criteria andRequireItemCodeEqualTo(String value) {
            addCriterion("require_item_code =", value, "requireItemCode");
            return (Criteria) this;
        }

        public Criteria andRequireItemCodeNotEqualTo(String value) {
            addCriterion("require_item_code <>", value, "requireItemCode");
            return (Criteria) this;
        }

        public Criteria andRequireItemCodeGreaterThan(String value) {
            addCriterion("require_item_code >", value, "requireItemCode");
            return (Criteria) this;
        }

        public Criteria andRequireItemCodeGreaterThanOrEqualTo(String value) {
            addCriterion("require_item_code >=", value, "requireItemCode");
            return (Criteria) this;
        }

        public Criteria andRequireItemCodeLessThan(String value) {
            addCriterion("require_item_code <", value, "requireItemCode");
            return (Criteria) this;
        }

        public Criteria andRequireItemCodeLessThanOrEqualTo(String value) {
            addCriterion("require_item_code <=", value, "requireItemCode");
            return (Criteria) this;
        }

        public Criteria andRequireItemCodeLike(String value) {
            addCriterion("require_item_code like", value, "requireItemCode");
            return (Criteria) this;
        }

        public Criteria andRequireItemCodeNotLike(String value) {
            addCriterion("require_item_code not like", value, "requireItemCode");
            return (Criteria) this;
        }

        public Criteria andRequireItemCodeIn(List<String> values) {
            addCriterion("require_item_code in", values, "requireItemCode");
            return (Criteria) this;
        }

        public Criteria andRequireItemCodeNotIn(List<String> values) {
            addCriterion("require_item_code not in", values, "requireItemCode");
            return (Criteria) this;
        }

        public Criteria andRequireItemCodeBetween(String value1, String value2) {
            addCriterion("require_item_code between", value1, value2, "requireItemCode");
            return (Criteria) this;
        }

        public Criteria andRequireItemCodeNotBetween(String value1, String value2) {
            addCriterion("require_item_code not between", value1, value2, "requireItemCode");
            return (Criteria) this;
        }

        public Criteria andRequireItemCountIsNull() {
            addCriterion("require_item_count is null");
            return (Criteria) this;
        }

        public Criteria andRequireItemCountIsNotNull() {
            addCriterion("require_item_count is not null");
            return (Criteria) this;
        }

        public Criteria andRequireItemCountEqualTo(String value) {
            addCriterion("require_item_count =", value, "requireItemCount");
            return (Criteria) this;
        }

        public Criteria andRequireItemCountNotEqualTo(String value) {
            addCriterion("require_item_count <>", value, "requireItemCount");
            return (Criteria) this;
        }

        public Criteria andRequireItemCountGreaterThan(String value) {
            addCriterion("require_item_count >", value, "requireItemCount");
            return (Criteria) this;
        }

        public Criteria andRequireItemCountGreaterThanOrEqualTo(String value) {
            addCriterion("require_item_count >=", value, "requireItemCount");
            return (Criteria) this;
        }

        public Criteria andRequireItemCountLessThan(String value) {
            addCriterion("require_item_count <", value, "requireItemCount");
            return (Criteria) this;
        }

        public Criteria andRequireItemCountLessThanOrEqualTo(String value) {
            addCriterion("require_item_count <=", value, "requireItemCount");
            return (Criteria) this;
        }

        public Criteria andRequireItemCountLike(String value) {
            addCriterion("require_item_count like", value, "requireItemCount");
            return (Criteria) this;
        }

        public Criteria andRequireItemCountNotLike(String value) {
            addCriterion("require_item_count not like", value, "requireItemCount");
            return (Criteria) this;
        }

        public Criteria andRequireItemCountIn(List<String> values) {
            addCriterion("require_item_count in", values, "requireItemCount");
            return (Criteria) this;
        }

        public Criteria andRequireItemCountNotIn(List<String> values) {
            addCriterion("require_item_count not in", values, "requireItemCount");
            return (Criteria) this;
        }

        public Criteria andRequireItemCountBetween(String value1, String value2) {
            addCriterion("require_item_count between", value1, value2, "requireItemCount");
            return (Criteria) this;
        }

        public Criteria andRequireItemCountNotBetween(String value1, String value2) {
            addCriterion("require_item_count not between", value1, value2, "requireItemCount");
            return (Criteria) this;
        }

        public Criteria andRequireItemRemarksIsNull() {
            addCriterion("require_item_remarks is null");
            return (Criteria) this;
        }

        public Criteria andRequireItemRemarksIsNotNull() {
            addCriterion("require_item_remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRequireItemRemarksEqualTo(String value) {
            addCriterion("require_item_remarks =", value, "requireItemRemarks");
            return (Criteria) this;
        }

        public Criteria andRequireItemRemarksNotEqualTo(String value) {
            addCriterion("require_item_remarks <>", value, "requireItemRemarks");
            return (Criteria) this;
        }

        public Criteria andRequireItemRemarksGreaterThan(String value) {
            addCriterion("require_item_remarks >", value, "requireItemRemarks");
            return (Criteria) this;
        }

        public Criteria andRequireItemRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("require_item_remarks >=", value, "requireItemRemarks");
            return (Criteria) this;
        }

        public Criteria andRequireItemRemarksLessThan(String value) {
            addCriterion("require_item_remarks <", value, "requireItemRemarks");
            return (Criteria) this;
        }

        public Criteria andRequireItemRemarksLessThanOrEqualTo(String value) {
            addCriterion("require_item_remarks <=", value, "requireItemRemarks");
            return (Criteria) this;
        }

        public Criteria andRequireItemRemarksLike(String value) {
            addCriterion("require_item_remarks like", value, "requireItemRemarks");
            return (Criteria) this;
        }

        public Criteria andRequireItemRemarksNotLike(String value) {
            addCriterion("require_item_remarks not like", value, "requireItemRemarks");
            return (Criteria) this;
        }

        public Criteria andRequireItemRemarksIn(List<String> values) {
            addCriterion("require_item_remarks in", values, "requireItemRemarks");
            return (Criteria) this;
        }

        public Criteria andRequireItemRemarksNotIn(List<String> values) {
            addCriterion("require_item_remarks not in", values, "requireItemRemarks");
            return (Criteria) this;
        }

        public Criteria andRequireItemRemarksBetween(String value1, String value2) {
            addCriterion("require_item_remarks between", value1, value2, "requireItemRemarks");
            return (Criteria) this;
        }

        public Criteria andRequireItemRemarksNotBetween(String value1, String value2) {
            addCriterion("require_item_remarks not between", value1, value2, "requireItemRemarks");
            return (Criteria) this;
        }

        public Criteria andRequireItemUrlIsNull() {
            addCriterion("require_item_url is null");
            return (Criteria) this;
        }

        public Criteria andRequireItemUrlIsNotNull() {
            addCriterion("require_item_url is not null");
            return (Criteria) this;
        }

        public Criteria andRequireItemUrlEqualTo(String value) {
            addCriterion("require_item_url =", value, "requireItemUrl");
            return (Criteria) this;
        }

        public Criteria andRequireItemUrlNotEqualTo(String value) {
            addCriterion("require_item_url <>", value, "requireItemUrl");
            return (Criteria) this;
        }

        public Criteria andRequireItemUrlGreaterThan(String value) {
            addCriterion("require_item_url >", value, "requireItemUrl");
            return (Criteria) this;
        }

        public Criteria andRequireItemUrlGreaterThanOrEqualTo(String value) {
            addCriterion("require_item_url >=", value, "requireItemUrl");
            return (Criteria) this;
        }

        public Criteria andRequireItemUrlLessThan(String value) {
            addCriterion("require_item_url <", value, "requireItemUrl");
            return (Criteria) this;
        }

        public Criteria andRequireItemUrlLessThanOrEqualTo(String value) {
            addCriterion("require_item_url <=", value, "requireItemUrl");
            return (Criteria) this;
        }

        public Criteria andRequireItemUrlLike(String value) {
            addCriterion("require_item_url like", value, "requireItemUrl");
            return (Criteria) this;
        }

        public Criteria andRequireItemUrlNotLike(String value) {
            addCriterion("require_item_url not like", value, "requireItemUrl");
            return (Criteria) this;
        }

        public Criteria andRequireItemUrlIn(List<String> values) {
            addCriterion("require_item_url in", values, "requireItemUrl");
            return (Criteria) this;
        }

        public Criteria andRequireItemUrlNotIn(List<String> values) {
            addCriterion("require_item_url not in", values, "requireItemUrl");
            return (Criteria) this;
        }

        public Criteria andRequireItemUrlBetween(String value1, String value2) {
            addCriterion("require_item_url between", value1, value2, "requireItemUrl");
            return (Criteria) this;
        }

        public Criteria andRequireItemUrlNotBetween(String value1, String value2) {
            addCriterion("require_item_url not between", value1, value2, "requireItemUrl");
            return (Criteria) this;
        }

        public Criteria andRequireItemFileIsNull() {
            addCriterion("require_item_file is null");
            return (Criteria) this;
        }

        public Criteria andRequireItemFileIsNotNull() {
            addCriterion("require_item_file is not null");
            return (Criteria) this;
        }

        public Criteria andRequireItemFileEqualTo(String value) {
            addCriterion("require_item_file =", value, "requireItemFile");
            return (Criteria) this;
        }

        public Criteria andRequireItemFileNotEqualTo(String value) {
            addCriterion("require_item_file <>", value, "requireItemFile");
            return (Criteria) this;
        }

        public Criteria andRequireItemFileGreaterThan(String value) {
            addCriterion("require_item_file >", value, "requireItemFile");
            return (Criteria) this;
        }

        public Criteria andRequireItemFileGreaterThanOrEqualTo(String value) {
            addCriterion("require_item_file >=", value, "requireItemFile");
            return (Criteria) this;
        }

        public Criteria andRequireItemFileLessThan(String value) {
            addCriterion("require_item_file <", value, "requireItemFile");
            return (Criteria) this;
        }

        public Criteria andRequireItemFileLessThanOrEqualTo(String value) {
            addCriterion("require_item_file <=", value, "requireItemFile");
            return (Criteria) this;
        }

        public Criteria andRequireItemFileLike(String value) {
            addCriterion("require_item_file like", value, "requireItemFile");
            return (Criteria) this;
        }

        public Criteria andRequireItemFileNotLike(String value) {
            addCriterion("require_item_file not like", value, "requireItemFile");
            return (Criteria) this;
        }

        public Criteria andRequireItemFileIn(List<String> values) {
            addCriterion("require_item_file in", values, "requireItemFile");
            return (Criteria) this;
        }

        public Criteria andRequireItemFileNotIn(List<String> values) {
            addCriterion("require_item_file not in", values, "requireItemFile");
            return (Criteria) this;
        }

        public Criteria andRequireItemFileBetween(String value1, String value2) {
            addCriterion("require_item_file between", value1, value2, "requireItemFile");
            return (Criteria) this;
        }

        public Criteria andRequireItemFileNotBetween(String value1, String value2) {
            addCriterion("require_item_file not between", value1, value2, "requireItemFile");
            return (Criteria) this;
        }

        public Criteria andRequireItemOrderIsNull() {
            addCriterion("require_item_order is null");
            return (Criteria) this;
        }

        public Criteria andRequireItemOrderIsNotNull() {
            addCriterion("require_item_order is not null");
            return (Criteria) this;
        }

        public Criteria andRequireItemOrderEqualTo(String value) {
            addCriterion("require_item_order =", value, "requireItemOrder");
            return (Criteria) this;
        }

        public Criteria andRequireItemOrderNotEqualTo(String value) {
            addCriterion("require_item_order <>", value, "requireItemOrder");
            return (Criteria) this;
        }

        public Criteria andRequireItemOrderGreaterThan(String value) {
            addCriterion("require_item_order >", value, "requireItemOrder");
            return (Criteria) this;
        }

        public Criteria andRequireItemOrderGreaterThanOrEqualTo(String value) {
            addCriterion("require_item_order >=", value, "requireItemOrder");
            return (Criteria) this;
        }

        public Criteria andRequireItemOrderLessThan(String value) {
            addCriterion("require_item_order <", value, "requireItemOrder");
            return (Criteria) this;
        }

        public Criteria andRequireItemOrderLessThanOrEqualTo(String value) {
            addCriterion("require_item_order <=", value, "requireItemOrder");
            return (Criteria) this;
        }

        public Criteria andRequireItemOrderLike(String value) {
            addCriterion("require_item_order like", value, "requireItemOrder");
            return (Criteria) this;
        }

        public Criteria andRequireItemOrderNotLike(String value) {
            addCriterion("require_item_order not like", value, "requireItemOrder");
            return (Criteria) this;
        }

        public Criteria andRequireItemOrderIn(List<String> values) {
            addCriterion("require_item_order in", values, "requireItemOrder");
            return (Criteria) this;
        }

        public Criteria andRequireItemOrderNotIn(List<String> values) {
            addCriterion("require_item_order not in", values, "requireItemOrder");
            return (Criteria) this;
        }

        public Criteria andRequireItemOrderBetween(String value1, String value2) {
            addCriterion("require_item_order between", value1, value2, "requireItemOrder");
            return (Criteria) this;
        }

        public Criteria andRequireItemOrderNotBetween(String value1, String value2) {
            addCriterion("require_item_order not between", value1, value2, "requireItemOrder");
            return (Criteria) this;
        }

        public Criteria andRequireItemIndexIsNull() {
            addCriterion("require_item_index is null");
            return (Criteria) this;
        }

        public Criteria andRequireItemIndexIsNotNull() {
            addCriterion("require_item_index is not null");
            return (Criteria) this;
        }

        public Criteria andRequireItemIndexEqualTo(String value) {
            addCriterion("require_item_index =", value, "requireItemIndex");
            return (Criteria) this;
        }

        public Criteria andRequireItemIndexNotEqualTo(String value) {
            addCriterion("require_item_index <>", value, "requireItemIndex");
            return (Criteria) this;
        }

        public Criteria andRequireItemIndexGreaterThan(String value) {
            addCriterion("require_item_index >", value, "requireItemIndex");
            return (Criteria) this;
        }

        public Criteria andRequireItemIndexGreaterThanOrEqualTo(String value) {
            addCriterion("require_item_index >=", value, "requireItemIndex");
            return (Criteria) this;
        }

        public Criteria andRequireItemIndexLessThan(String value) {
            addCriterion("require_item_index <", value, "requireItemIndex");
            return (Criteria) this;
        }

        public Criteria andRequireItemIndexLessThanOrEqualTo(String value) {
            addCriterion("require_item_index <=", value, "requireItemIndex");
            return (Criteria) this;
        }

        public Criteria andRequireItemIndexLike(String value) {
            addCriterion("require_item_index like", value, "requireItemIndex");
            return (Criteria) this;
        }

        public Criteria andRequireItemIndexNotLike(String value) {
            addCriterion("require_item_index not like", value, "requireItemIndex");
            return (Criteria) this;
        }

        public Criteria andRequireItemIndexIn(List<String> values) {
            addCriterion("require_item_index in", values, "requireItemIndex");
            return (Criteria) this;
        }

        public Criteria andRequireItemIndexNotIn(List<String> values) {
            addCriterion("require_item_index not in", values, "requireItemIndex");
            return (Criteria) this;
        }

        public Criteria andRequireItemIndexBetween(String value1, String value2) {
            addCriterion("require_item_index between", value1, value2, "requireItemIndex");
            return (Criteria) this;
        }

        public Criteria andRequireItemIndexNotBetween(String value1, String value2) {
            addCriterion("require_item_index not between", value1, value2, "requireItemIndex");
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