package com.pcitc.base.engin.qualification.blacklist;

import java.util.ArrayList;
import java.util.List;

public class QlfcUserBlacklistVoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QlfcUserBlacklistVoExample() {
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

        public Criteria andQlfcUserBlacklistIdIsNull() {
            addCriterion("qlfc_user_blacklist_id is null");
            return (Criteria) this;
        }

        public Criteria andQlfcUserBlacklistIdIsNotNull() {
            addCriterion("qlfc_user_blacklist_id is not null");
            return (Criteria) this;
        }

        public Criteria andQlfcUserBlacklistIdEqualTo(String value) {
            addCriterion("qlfc_user_blacklist_id =", value, "qlfcUserBlacklistId");
            return (Criteria) this;
        }

        public Criteria andQlfcUserBlacklistIdNotEqualTo(String value) {
            addCriterion("qlfc_user_blacklist_id <>", value, "qlfcUserBlacklistId");
            return (Criteria) this;
        }

        public Criteria andQlfcUserBlacklistIdGreaterThan(String value) {
            addCriterion("qlfc_user_blacklist_id >", value, "qlfcUserBlacklistId");
            return (Criteria) this;
        }

        public Criteria andQlfcUserBlacklistIdGreaterThanOrEqualTo(String value) {
            addCriterion("qlfc_user_blacklist_id >=", value, "qlfcUserBlacklistId");
            return (Criteria) this;
        }

        public Criteria andQlfcUserBlacklistIdLessThan(String value) {
            addCriterion("qlfc_user_blacklist_id <", value, "qlfcUserBlacklistId");
            return (Criteria) this;
        }

        public Criteria andQlfcUserBlacklistIdLessThanOrEqualTo(String value) {
            addCriterion("qlfc_user_blacklist_id <=", value, "qlfcUserBlacklistId");
            return (Criteria) this;
        }

        public Criteria andQlfcUserBlacklistIdLike(String value) {
            addCriterion("qlfc_user_blacklist_id like", value, "qlfcUserBlacklistId");
            return (Criteria) this;
        }

        public Criteria andQlfcUserBlacklistIdNotLike(String value) {
            addCriterion("qlfc_user_blacklist_id not like", value, "qlfcUserBlacklistId");
            return (Criteria) this;
        }

        public Criteria andQlfcUserBlacklistIdIn(List<String> values) {
            addCriterion("qlfc_user_blacklist_id in", values, "qlfcUserBlacklistId");
            return (Criteria) this;
        }

        public Criteria andQlfcUserBlacklistIdNotIn(List<String> values) {
            addCriterion("qlfc_user_blacklist_id not in", values, "qlfcUserBlacklistId");
            return (Criteria) this;
        }

        public Criteria andQlfcUserBlacklistIdBetween(String value1, String value2) {
            addCriterion("qlfc_user_blacklist_id between", value1, value2, "qlfcUserBlacklistId");
            return (Criteria) this;
        }

        public Criteria andQlfcUserBlacklistIdNotBetween(String value1, String value2) {
            addCriterion("qlfc_user_blacklist_id not between", value1, value2, "qlfcUserBlacklistId");
            return (Criteria) this;
        }

        public Criteria andFormIdIsNull() {
            addCriterion("form_id is null");
            return (Criteria) this;
        }

        public Criteria andFormIdIsNotNull() {
            addCriterion("form_id is not null");
            return (Criteria) this;
        }

        public Criteria andFormIdEqualTo(String value) {
            addCriterion("form_id =", value, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdNotEqualTo(String value) {
            addCriterion("form_id <>", value, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdGreaterThan(String value) {
            addCriterion("form_id >", value, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdGreaterThanOrEqualTo(String value) {
            addCriterion("form_id >=", value, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdLessThan(String value) {
            addCriterion("form_id <", value, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdLessThanOrEqualTo(String value) {
            addCriterion("form_id <=", value, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdLike(String value) {
            addCriterion("form_id like", value, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdNotLike(String value) {
            addCriterion("form_id not like", value, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdIn(List<String> values) {
            addCriterion("form_id in", values, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdNotIn(List<String> values) {
            addCriterion("form_id not in", values, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdBetween(String value1, String value2) {
            addCriterion("form_id between", value1, value2, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdNotBetween(String value1, String value2) {
            addCriterion("form_id not between", value1, value2, "formId");
            return (Criteria) this;
        }

        public Criteria andFormCodeIsNull() {
            addCriterion("form_code is null");
            return (Criteria) this;
        }

        public Criteria andFormCodeIsNotNull() {
            addCriterion("form_code is not null");
            return (Criteria) this;
        }

        public Criteria andFormCodeEqualTo(String value) {
            addCriterion("form_code =", value, "formCode");
            return (Criteria) this;
        }

        public Criteria andFormCodeNotEqualTo(String value) {
            addCriterion("form_code <>", value, "formCode");
            return (Criteria) this;
        }

        public Criteria andFormCodeGreaterThan(String value) {
            addCriterion("form_code >", value, "formCode");
            return (Criteria) this;
        }

        public Criteria andFormCodeGreaterThanOrEqualTo(String value) {
            addCriterion("form_code >=", value, "formCode");
            return (Criteria) this;
        }

        public Criteria andFormCodeLessThan(String value) {
            addCriterion("form_code <", value, "formCode");
            return (Criteria) this;
        }

        public Criteria andFormCodeLessThanOrEqualTo(String value) {
            addCriterion("form_code <=", value, "formCode");
            return (Criteria) this;
        }

        public Criteria andFormCodeLike(String value) {
            addCriterion("form_code like", value, "formCode");
            return (Criteria) this;
        }

        public Criteria andFormCodeNotLike(String value) {
            addCriterion("form_code not like", value, "formCode");
            return (Criteria) this;
        }

        public Criteria andFormCodeIn(List<String> values) {
            addCriterion("form_code in", values, "formCode");
            return (Criteria) this;
        }

        public Criteria andFormCodeNotIn(List<String> values) {
            addCriterion("form_code not in", values, "formCode");
            return (Criteria) this;
        }

        public Criteria andFormCodeBetween(String value1, String value2) {
            addCriterion("form_code between", value1, value2, "formCode");
            return (Criteria) this;
        }

        public Criteria andFormCodeNotBetween(String value1, String value2) {
            addCriterion("form_code not between", value1, value2, "formCode");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("`status` not between", value1, value2, "status");
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

        public Criteria andComIdIsNull() {
            addCriterion("com_id is null");
            return (Criteria) this;
        }

        public Criteria andComIdIsNotNull() {
            addCriterion("com_id is not null");
            return (Criteria) this;
        }

        public Criteria andComIdEqualTo(String value) {
            addCriterion("com_id =", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotEqualTo(String value) {
            addCriterion("com_id <>", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdGreaterThan(String value) {
            addCriterion("com_id >", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdGreaterThanOrEqualTo(String value) {
            addCriterion("com_id >=", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdLessThan(String value) {
            addCriterion("com_id <", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdLessThanOrEqualTo(String value) {
            addCriterion("com_id <=", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdLike(String value) {
            addCriterion("com_id like", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotLike(String value) {
            addCriterion("com_id not like", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdIn(List<String> values) {
            addCriterion("com_id in", values, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotIn(List<String> values) {
            addCriterion("com_id not in", values, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdBetween(String value1, String value2) {
            addCriterion("com_id between", value1, value2, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotBetween(String value1, String value2) {
            addCriterion("com_id not between", value1, value2, "comId");
            return (Criteria) this;
        }

        public Criteria andComNameIsNull() {
            addCriterion("com_name is null");
            return (Criteria) this;
        }

        public Criteria andComNameIsNotNull() {
            addCriterion("com_name is not null");
            return (Criteria) this;
        }

        public Criteria andComNameEqualTo(String value) {
            addCriterion("com_name =", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameNotEqualTo(String value) {
            addCriterion("com_name <>", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameGreaterThan(String value) {
            addCriterion("com_name >", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameGreaterThanOrEqualTo(String value) {
            addCriterion("com_name >=", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameLessThan(String value) {
            addCriterion("com_name <", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameLessThanOrEqualTo(String value) {
            addCriterion("com_name <=", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameLike(String value) {
            addCriterion("com_name like", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameNotLike(String value) {
            addCriterion("com_name not like", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameIn(List<String> values) {
            addCriterion("com_name in", values, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameNotIn(List<String> values) {
            addCriterion("com_name not in", values, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameBetween(String value1, String value2) {
            addCriterion("com_name between", value1, value2, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameNotBetween(String value1, String value2) {
            addCriterion("com_name not between", value1, value2, "comName");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andIdNumberIsNull() {
            addCriterion("id_number is null");
            return (Criteria) this;
        }

        public Criteria andIdNumberIsNotNull() {
            addCriterion("id_number is not null");
            return (Criteria) this;
        }

        public Criteria andIdNumberEqualTo(String value) {
            addCriterion("id_number =", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotEqualTo(String value) {
            addCriterion("id_number <>", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberGreaterThan(String value) {
            addCriterion("id_number >", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberGreaterThanOrEqualTo(String value) {
            addCriterion("id_number >=", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLessThan(String value) {
            addCriterion("id_number <", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLessThanOrEqualTo(String value) {
            addCriterion("id_number <=", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLike(String value) {
            addCriterion("id_number like", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotLike(String value) {
            addCriterion("id_number not like", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberIn(List<String> values) {
            addCriterion("id_number in", values, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotIn(List<String> values) {
            addCriterion("id_number not in", values, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberBetween(String value1, String value2) {
            addCriterion("id_number between", value1, value2, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotBetween(String value1, String value2) {
            addCriterion("id_number not between", value1, value2, "idNumber");
            return (Criteria) this;
        }

        public Criteria andBlackDateIsNull() {
            addCriterion("black_date is null");
            return (Criteria) this;
        }

        public Criteria andBlackDateIsNotNull() {
            addCriterion("black_date is not null");
            return (Criteria) this;
        }

        public Criteria andBlackDateEqualTo(String value) {
            addCriterion("black_date =", value, "blackDate");
            return (Criteria) this;
        }

        public Criteria andBlackDateNotEqualTo(String value) {
            addCriterion("black_date <>", value, "blackDate");
            return (Criteria) this;
        }

        public Criteria andBlackDateGreaterThan(String value) {
            addCriterion("black_date >", value, "blackDate");
            return (Criteria) this;
        }

        public Criteria andBlackDateGreaterThanOrEqualTo(String value) {
            addCriterion("black_date >=", value, "blackDate");
            return (Criteria) this;
        }

        public Criteria andBlackDateLessThan(String value) {
            addCriterion("black_date <", value, "blackDate");
            return (Criteria) this;
        }

        public Criteria andBlackDateLessThanOrEqualTo(String value) {
            addCriterion("black_date <=", value, "blackDate");
            return (Criteria) this;
        }

        public Criteria andBlackDateLike(String value) {
            addCriterion("black_date like", value, "blackDate");
            return (Criteria) this;
        }

        public Criteria andBlackDateNotLike(String value) {
            addCriterion("black_date not like", value, "blackDate");
            return (Criteria) this;
        }

        public Criteria andBlackDateIn(List<String> values) {
            addCriterion("black_date in", values, "blackDate");
            return (Criteria) this;
        }

        public Criteria andBlackDateNotIn(List<String> values) {
            addCriterion("black_date not in", values, "blackDate");
            return (Criteria) this;
        }

        public Criteria andBlackDateBetween(String value1, String value2) {
            addCriterion("black_date between", value1, value2, "blackDate");
            return (Criteria) this;
        }

        public Criteria andBlackDateNotBetween(String value1, String value2) {
            addCriterion("black_date not between", value1, value2, "blackDate");
            return (Criteria) this;
        }

        public Criteria andRemoveBlackDateIsNull() {
            addCriterion("remove_black_date is null");
            return (Criteria) this;
        }

        public Criteria andRemoveBlackDateIsNotNull() {
            addCriterion("remove_black_date is not null");
            return (Criteria) this;
        }

        public Criteria andRemoveBlackDateEqualTo(String value) {
            addCriterion("remove_black_date =", value, "removeBlackDate");
            return (Criteria) this;
        }

        public Criteria andRemoveBlackDateNotEqualTo(String value) {
            addCriterion("remove_black_date <>", value, "removeBlackDate");
            return (Criteria) this;
        }

        public Criteria andRemoveBlackDateGreaterThan(String value) {
            addCriterion("remove_black_date >", value, "removeBlackDate");
            return (Criteria) this;
        }

        public Criteria andRemoveBlackDateGreaterThanOrEqualTo(String value) {
            addCriterion("remove_black_date >=", value, "removeBlackDate");
            return (Criteria) this;
        }

        public Criteria andRemoveBlackDateLessThan(String value) {
            addCriterion("remove_black_date <", value, "removeBlackDate");
            return (Criteria) this;
        }

        public Criteria andRemoveBlackDateLessThanOrEqualTo(String value) {
            addCriterion("remove_black_date <=", value, "removeBlackDate");
            return (Criteria) this;
        }

        public Criteria andRemoveBlackDateLike(String value) {
            addCriterion("remove_black_date like", value, "removeBlackDate");
            return (Criteria) this;
        }

        public Criteria andRemoveBlackDateNotLike(String value) {
            addCriterion("remove_black_date not like", value, "removeBlackDate");
            return (Criteria) this;
        }

        public Criteria andRemoveBlackDateIn(List<String> values) {
            addCriterion("remove_black_date in", values, "removeBlackDate");
            return (Criteria) this;
        }

        public Criteria andRemoveBlackDateNotIn(List<String> values) {
            addCriterion("remove_black_date not in", values, "removeBlackDate");
            return (Criteria) this;
        }

        public Criteria andRemoveBlackDateBetween(String value1, String value2) {
            addCriterion("remove_black_date between", value1, value2, "removeBlackDate");
            return (Criteria) this;
        }

        public Criteria andRemoveBlackDateNotBetween(String value1, String value2) {
            addCriterion("remove_black_date not between", value1, value2, "removeBlackDate");
            return (Criteria) this;
        }

        public Criteria andBlackPlaceIsNull() {
            addCriterion("black_place is null");
            return (Criteria) this;
        }

        public Criteria andBlackPlaceIsNotNull() {
            addCriterion("black_place is not null");
            return (Criteria) this;
        }

        public Criteria andBlackPlaceEqualTo(String value) {
            addCriterion("black_place =", value, "blackPlace");
            return (Criteria) this;
        }

        public Criteria andBlackPlaceNotEqualTo(String value) {
            addCriterion("black_place <>", value, "blackPlace");
            return (Criteria) this;
        }

        public Criteria andBlackPlaceGreaterThan(String value) {
            addCriterion("black_place >", value, "blackPlace");
            return (Criteria) this;
        }

        public Criteria andBlackPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("black_place >=", value, "blackPlace");
            return (Criteria) this;
        }

        public Criteria andBlackPlaceLessThan(String value) {
            addCriterion("black_place <", value, "blackPlace");
            return (Criteria) this;
        }

        public Criteria andBlackPlaceLessThanOrEqualTo(String value) {
            addCriterion("black_place <=", value, "blackPlace");
            return (Criteria) this;
        }

        public Criteria andBlackPlaceLike(String value) {
            addCriterion("black_place like", value, "blackPlace");
            return (Criteria) this;
        }

        public Criteria andBlackPlaceNotLike(String value) {
            addCriterion("black_place not like", value, "blackPlace");
            return (Criteria) this;
        }

        public Criteria andBlackPlaceIn(List<String> values) {
            addCriterion("black_place in", values, "blackPlace");
            return (Criteria) this;
        }

        public Criteria andBlackPlaceNotIn(List<String> values) {
            addCriterion("black_place not in", values, "blackPlace");
            return (Criteria) this;
        }

        public Criteria andBlackPlaceBetween(String value1, String value2) {
            addCriterion("black_place between", value1, value2, "blackPlace");
            return (Criteria) this;
        }

        public Criteria andBlackPlaceNotBetween(String value1, String value2) {
            addCriterion("black_place not between", value1, value2, "blackPlace");
            return (Criteria) this;
        }

        public Criteria andRegistPersonIsNull() {
            addCriterion("regist_person is null");
            return (Criteria) this;
        }

        public Criteria andRegistPersonIsNotNull() {
            addCriterion("regist_person is not null");
            return (Criteria) this;
        }

        public Criteria andRegistPersonEqualTo(String value) {
            addCriterion("regist_person =", value, "registPerson");
            return (Criteria) this;
        }

        public Criteria andRegistPersonNotEqualTo(String value) {
            addCriterion("regist_person <>", value, "registPerson");
            return (Criteria) this;
        }

        public Criteria andRegistPersonGreaterThan(String value) {
            addCriterion("regist_person >", value, "registPerson");
            return (Criteria) this;
        }

        public Criteria andRegistPersonGreaterThanOrEqualTo(String value) {
            addCriterion("regist_person >=", value, "registPerson");
            return (Criteria) this;
        }

        public Criteria andRegistPersonLessThan(String value) {
            addCriterion("regist_person <", value, "registPerson");
            return (Criteria) this;
        }

        public Criteria andRegistPersonLessThanOrEqualTo(String value) {
            addCriterion("regist_person <=", value, "registPerson");
            return (Criteria) this;
        }

        public Criteria andRegistPersonLike(String value) {
            addCriterion("regist_person like", value, "registPerson");
            return (Criteria) this;
        }

        public Criteria andRegistPersonNotLike(String value) {
            addCriterion("regist_person not like", value, "registPerson");
            return (Criteria) this;
        }

        public Criteria andRegistPersonIn(List<String> values) {
            addCriterion("regist_person in", values, "registPerson");
            return (Criteria) this;
        }

        public Criteria andRegistPersonNotIn(List<String> values) {
            addCriterion("regist_person not in", values, "registPerson");
            return (Criteria) this;
        }

        public Criteria andRegistPersonBetween(String value1, String value2) {
            addCriterion("regist_person between", value1, value2, "registPerson");
            return (Criteria) this;
        }

        public Criteria andRegistPersonNotBetween(String value1, String value2) {
            addCriterion("regist_person not between", value1, value2, "registPerson");
            return (Criteria) this;
        }

        public Criteria andRegistUnitIsNull() {
            addCriterion("regist_unit is null");
            return (Criteria) this;
        }

        public Criteria andRegistUnitIsNotNull() {
            addCriterion("regist_unit is not null");
            return (Criteria) this;
        }

        public Criteria andRegistUnitEqualTo(String value) {
            addCriterion("regist_unit =", value, "registUnit");
            return (Criteria) this;
        }

        public Criteria andRegistUnitNotEqualTo(String value) {
            addCriterion("regist_unit <>", value, "registUnit");
            return (Criteria) this;
        }

        public Criteria andRegistUnitGreaterThan(String value) {
            addCriterion("regist_unit >", value, "registUnit");
            return (Criteria) this;
        }

        public Criteria andRegistUnitGreaterThanOrEqualTo(String value) {
            addCriterion("regist_unit >=", value, "registUnit");
            return (Criteria) this;
        }

        public Criteria andRegistUnitLessThan(String value) {
            addCriterion("regist_unit <", value, "registUnit");
            return (Criteria) this;
        }

        public Criteria andRegistUnitLessThanOrEqualTo(String value) {
            addCriterion("regist_unit <=", value, "registUnit");
            return (Criteria) this;
        }

        public Criteria andRegistUnitLike(String value) {
            addCriterion("regist_unit like", value, "registUnit");
            return (Criteria) this;
        }

        public Criteria andRegistUnitNotLike(String value) {
            addCriterion("regist_unit not like", value, "registUnit");
            return (Criteria) this;
        }

        public Criteria andRegistUnitIn(List<String> values) {
            addCriterion("regist_unit in", values, "registUnit");
            return (Criteria) this;
        }

        public Criteria andRegistUnitNotIn(List<String> values) {
            addCriterion("regist_unit not in", values, "registUnit");
            return (Criteria) this;
        }

        public Criteria andRegistUnitBetween(String value1, String value2) {
            addCriterion("regist_unit between", value1, value2, "registUnit");
            return (Criteria) this;
        }

        public Criteria andRegistUnitNotBetween(String value1, String value2) {
            addCriterion("regist_unit not between", value1, value2, "registUnit");
            return (Criteria) this;
        }

        public Criteria andBlackContentIsNull() {
            addCriterion("black_content is null");
            return (Criteria) this;
        }

        public Criteria andBlackContentIsNotNull() {
            addCriterion("black_content is not null");
            return (Criteria) this;
        }

        public Criteria andBlackContentEqualTo(String value) {
            addCriterion("black_content =", value, "blackContent");
            return (Criteria) this;
        }

        public Criteria andBlackContentNotEqualTo(String value) {
            addCriterion("black_content <>", value, "blackContent");
            return (Criteria) this;
        }

        public Criteria andBlackContentGreaterThan(String value) {
            addCriterion("black_content >", value, "blackContent");
            return (Criteria) this;
        }

        public Criteria andBlackContentGreaterThanOrEqualTo(String value) {
            addCriterion("black_content >=", value, "blackContent");
            return (Criteria) this;
        }

        public Criteria andBlackContentLessThan(String value) {
            addCriterion("black_content <", value, "blackContent");
            return (Criteria) this;
        }

        public Criteria andBlackContentLessThanOrEqualTo(String value) {
            addCriterion("black_content <=", value, "blackContent");
            return (Criteria) this;
        }

        public Criteria andBlackContentLike(String value) {
            addCriterion("black_content like", value, "blackContent");
            return (Criteria) this;
        }

        public Criteria andBlackContentNotLike(String value) {
            addCriterion("black_content not like", value, "blackContent");
            return (Criteria) this;
        }

        public Criteria andBlackContentIn(List<String> values) {
            addCriterion("black_content in", values, "blackContent");
            return (Criteria) this;
        }

        public Criteria andBlackContentNotIn(List<String> values) {
            addCriterion("black_content not in", values, "blackContent");
            return (Criteria) this;
        }

        public Criteria andBlackContentBetween(String value1, String value2) {
            addCriterion("black_content between", value1, value2, "blackContent");
            return (Criteria) this;
        }

        public Criteria andBlackContentNotBetween(String value1, String value2) {
            addCriterion("black_content not between", value1, value2, "blackContent");
            return (Criteria) this;
        }

        public Criteria andRemoveBlackContentIsNull() {
            addCriterion("remove_black_content is null");
            return (Criteria) this;
        }

        public Criteria andRemoveBlackContentIsNotNull() {
            addCriterion("remove_black_content is not null");
            return (Criteria) this;
        }

        public Criteria andRemoveBlackContentEqualTo(String value) {
            addCriterion("remove_black_content =", value, "removeBlackContent");
            return (Criteria) this;
        }

        public Criteria andRemoveBlackContentNotEqualTo(String value) {
            addCriterion("remove_black_content <>", value, "removeBlackContent");
            return (Criteria) this;
        }

        public Criteria andRemoveBlackContentGreaterThan(String value) {
            addCriterion("remove_black_content >", value, "removeBlackContent");
            return (Criteria) this;
        }

        public Criteria andRemoveBlackContentGreaterThanOrEqualTo(String value) {
            addCriterion("remove_black_content >=", value, "removeBlackContent");
            return (Criteria) this;
        }

        public Criteria andRemoveBlackContentLessThan(String value) {
            addCriterion("remove_black_content <", value, "removeBlackContent");
            return (Criteria) this;
        }

        public Criteria andRemoveBlackContentLessThanOrEqualTo(String value) {
            addCriterion("remove_black_content <=", value, "removeBlackContent");
            return (Criteria) this;
        }

        public Criteria andRemoveBlackContentLike(String value) {
            addCriterion("remove_black_content like", value, "removeBlackContent");
            return (Criteria) this;
        }

        public Criteria andRemoveBlackContentNotLike(String value) {
            addCriterion("remove_black_content not like", value, "removeBlackContent");
            return (Criteria) this;
        }

        public Criteria andRemoveBlackContentIn(List<String> values) {
            addCriterion("remove_black_content in", values, "removeBlackContent");
            return (Criteria) this;
        }

        public Criteria andRemoveBlackContentNotIn(List<String> values) {
            addCriterion("remove_black_content not in", values, "removeBlackContent");
            return (Criteria) this;
        }

        public Criteria andRemoveBlackContentBetween(String value1, String value2) {
            addCriterion("remove_black_content between", value1, value2, "removeBlackContent");
            return (Criteria) this;
        }

        public Criteria andRemoveBlackContentNotBetween(String value1, String value2) {
            addCriterion("remove_black_content not between", value1, value2, "removeBlackContent");
            return (Criteria) this;
        }

        public Criteria andAttachmentIsNull() {
            addCriterion("attachment is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentIsNotNull() {
            addCriterion("attachment is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentEqualTo(String value) {
            addCriterion("attachment =", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotEqualTo(String value) {
            addCriterion("attachment <>", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentGreaterThan(String value) {
            addCriterion("attachment >", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentGreaterThanOrEqualTo(String value) {
            addCriterion("attachment >=", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentLessThan(String value) {
            addCriterion("attachment <", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentLessThanOrEqualTo(String value) {
            addCriterion("attachment <=", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentLike(String value) {
            addCriterion("attachment like", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotLike(String value) {
            addCriterion("attachment not like", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentIn(List<String> values) {
            addCriterion("attachment in", values, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotIn(List<String> values) {
            addCriterion("attachment not in", values, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentBetween(String value1, String value2) {
            addCriterion("attachment between", value1, value2, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotBetween(String value1, String value2) {
            addCriterion("attachment not between", value1, value2, "attachment");
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