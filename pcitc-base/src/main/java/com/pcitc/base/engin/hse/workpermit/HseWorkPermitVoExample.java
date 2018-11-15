package com.pcitc.base.engin.hse.workpermit;

import java.util.ArrayList;
import java.util.List;

public class HseWorkPermitVoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HseWorkPermitVoExample() {
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

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("`status` like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("`status` not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("`status` not between", value1, value2, "status");
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

        public Criteria andCompanyCodeIsNull() {
            addCriterion("company_code is null");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeIsNotNull() {
            addCriterion("company_code is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeEqualTo(String value) {
            addCriterion("company_code =", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotEqualTo(String value) {
            addCriterion("company_code <>", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeGreaterThan(String value) {
            addCriterion("company_code >", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("company_code >=", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeLessThan(String value) {
            addCriterion("company_code <", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeLessThanOrEqualTo(String value) {
            addCriterion("company_code <=", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeLike(String value) {
            addCriterion("company_code like", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotLike(String value) {
            addCriterion("company_code not like", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeIn(List<String> values) {
            addCriterion("company_code in", values, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotIn(List<String> values) {
            addCriterion("company_code not in", values, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeBetween(String value1, String value2) {
            addCriterion("company_code between", value1, value2, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotBetween(String value1, String value2) {
            addCriterion("company_code not between", value1, value2, "companyCode");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(String value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(String value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(String value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(String value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(String value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLike(String value) {
            addCriterion("project_id like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotLike(String value) {
            addCriterion("project_id not like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<String> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<String> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(String value1, String value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(String value1, String value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
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

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectCodeIsNull() {
            addCriterion("project_code is null");
            return (Criteria) this;
        }

        public Criteria andProjectCodeIsNotNull() {
            addCriterion("project_code is not null");
            return (Criteria) this;
        }

        public Criteria andProjectCodeEqualTo(String value) {
            addCriterion("project_code =", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeNotEqualTo(String value) {
            addCriterion("project_code <>", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeGreaterThan(String value) {
            addCriterion("project_code >", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeGreaterThanOrEqualTo(String value) {
            addCriterion("project_code >=", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeLessThan(String value) {
            addCriterion("project_code <", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeLessThanOrEqualTo(String value) {
            addCriterion("project_code <=", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeLike(String value) {
            addCriterion("project_code like", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeNotLike(String value) {
            addCriterion("project_code not like", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeIn(List<String> values) {
            addCriterion("project_code in", values, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeNotIn(List<String> values) {
            addCriterion("project_code not in", values, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeBetween(String value1, String value2) {
            addCriterion("project_code between", value1, value2, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeNotBetween(String value1, String value2) {
            addCriterion("project_code not between", value1, value2, "projectCode");
            return (Criteria) this;
        }

        public Criteria andWbsIdIsNull() {
            addCriterion("wbs_id is null");
            return (Criteria) this;
        }

        public Criteria andWbsIdIsNotNull() {
            addCriterion("wbs_id is not null");
            return (Criteria) this;
        }

        public Criteria andWbsIdEqualTo(String value) {
            addCriterion("wbs_id =", value, "wbsId");
            return (Criteria) this;
        }

        public Criteria andWbsIdNotEqualTo(String value) {
            addCriterion("wbs_id <>", value, "wbsId");
            return (Criteria) this;
        }

        public Criteria andWbsIdGreaterThan(String value) {
            addCriterion("wbs_id >", value, "wbsId");
            return (Criteria) this;
        }

        public Criteria andWbsIdGreaterThanOrEqualTo(String value) {
            addCriterion("wbs_id >=", value, "wbsId");
            return (Criteria) this;
        }

        public Criteria andWbsIdLessThan(String value) {
            addCriterion("wbs_id <", value, "wbsId");
            return (Criteria) this;
        }

        public Criteria andWbsIdLessThanOrEqualTo(String value) {
            addCriterion("wbs_id <=", value, "wbsId");
            return (Criteria) this;
        }

        public Criteria andWbsIdLike(String value) {
            addCriterion("wbs_id like", value, "wbsId");
            return (Criteria) this;
        }

        public Criteria andWbsIdNotLike(String value) {
            addCriterion("wbs_id not like", value, "wbsId");
            return (Criteria) this;
        }

        public Criteria andWbsIdIn(List<String> values) {
            addCriterion("wbs_id in", values, "wbsId");
            return (Criteria) this;
        }

        public Criteria andWbsIdNotIn(List<String> values) {
            addCriterion("wbs_id not in", values, "wbsId");
            return (Criteria) this;
        }

        public Criteria andWbsIdBetween(String value1, String value2) {
            addCriterion("wbs_id between", value1, value2, "wbsId");
            return (Criteria) this;
        }

        public Criteria andWbsIdNotBetween(String value1, String value2) {
            addCriterion("wbs_id not between", value1, value2, "wbsId");
            return (Criteria) this;
        }

        public Criteria andWbsNameIsNull() {
            addCriterion("wbs_name is null");
            return (Criteria) this;
        }

        public Criteria andWbsNameIsNotNull() {
            addCriterion("wbs_name is not null");
            return (Criteria) this;
        }

        public Criteria andWbsNameEqualTo(String value) {
            addCriterion("wbs_name =", value, "wbsName");
            return (Criteria) this;
        }

        public Criteria andWbsNameNotEqualTo(String value) {
            addCriterion("wbs_name <>", value, "wbsName");
            return (Criteria) this;
        }

        public Criteria andWbsNameGreaterThan(String value) {
            addCriterion("wbs_name >", value, "wbsName");
            return (Criteria) this;
        }

        public Criteria andWbsNameGreaterThanOrEqualTo(String value) {
            addCriterion("wbs_name >=", value, "wbsName");
            return (Criteria) this;
        }

        public Criteria andWbsNameLessThan(String value) {
            addCriterion("wbs_name <", value, "wbsName");
            return (Criteria) this;
        }

        public Criteria andWbsNameLessThanOrEqualTo(String value) {
            addCriterion("wbs_name <=", value, "wbsName");
            return (Criteria) this;
        }

        public Criteria andWbsNameLike(String value) {
            addCriterion("wbs_name like", value, "wbsName");
            return (Criteria) this;
        }

        public Criteria andWbsNameNotLike(String value) {
            addCriterion("wbs_name not like", value, "wbsName");
            return (Criteria) this;
        }

        public Criteria andWbsNameIn(List<String> values) {
            addCriterion("wbs_name in", values, "wbsName");
            return (Criteria) this;
        }

        public Criteria andWbsNameNotIn(List<String> values) {
            addCriterion("wbs_name not in", values, "wbsName");
            return (Criteria) this;
        }

        public Criteria andWbsNameBetween(String value1, String value2) {
            addCriterion("wbs_name between", value1, value2, "wbsName");
            return (Criteria) this;
        }

        public Criteria andWbsNameNotBetween(String value1, String value2) {
            addCriterion("wbs_name not between", value1, value2, "wbsName");
            return (Criteria) this;
        }

        public Criteria andWbsCodeIsNull() {
            addCriterion("wbs_code is null");
            return (Criteria) this;
        }

        public Criteria andWbsCodeIsNotNull() {
            addCriterion("wbs_code is not null");
            return (Criteria) this;
        }

        public Criteria andWbsCodeEqualTo(String value) {
            addCriterion("wbs_code =", value, "wbsCode");
            return (Criteria) this;
        }

        public Criteria andWbsCodeNotEqualTo(String value) {
            addCriterion("wbs_code <>", value, "wbsCode");
            return (Criteria) this;
        }

        public Criteria andWbsCodeGreaterThan(String value) {
            addCriterion("wbs_code >", value, "wbsCode");
            return (Criteria) this;
        }

        public Criteria andWbsCodeGreaterThanOrEqualTo(String value) {
            addCriterion("wbs_code >=", value, "wbsCode");
            return (Criteria) this;
        }

        public Criteria andWbsCodeLessThan(String value) {
            addCriterion("wbs_code <", value, "wbsCode");
            return (Criteria) this;
        }

        public Criteria andWbsCodeLessThanOrEqualTo(String value) {
            addCriterion("wbs_code <=", value, "wbsCode");
            return (Criteria) this;
        }

        public Criteria andWbsCodeLike(String value) {
            addCriterion("wbs_code like", value, "wbsCode");
            return (Criteria) this;
        }

        public Criteria andWbsCodeNotLike(String value) {
            addCriterion("wbs_code not like", value, "wbsCode");
            return (Criteria) this;
        }

        public Criteria andWbsCodeIn(List<String> values) {
            addCriterion("wbs_code in", values, "wbsCode");
            return (Criteria) this;
        }

        public Criteria andWbsCodeNotIn(List<String> values) {
            addCriterion("wbs_code not in", values, "wbsCode");
            return (Criteria) this;
        }

        public Criteria andWbsCodeBetween(String value1, String value2) {
            addCriterion("wbs_code between", value1, value2, "wbsCode");
            return (Criteria) this;
        }

        public Criteria andWbsCodeNotBetween(String value1, String value2) {
            addCriterion("wbs_code not between", value1, value2, "wbsCode");
            return (Criteria) this;
        }

        public Criteria andApplicationUnitIsNull() {
            addCriterion("application_unit is null");
            return (Criteria) this;
        }

        public Criteria andApplicationUnitIsNotNull() {
            addCriterion("application_unit is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationUnitEqualTo(String value) {
            addCriterion("application_unit =", value, "applicationUnit");
            return (Criteria) this;
        }

        public Criteria andApplicationUnitNotEqualTo(String value) {
            addCriterion("application_unit <>", value, "applicationUnit");
            return (Criteria) this;
        }

        public Criteria andApplicationUnitGreaterThan(String value) {
            addCriterion("application_unit >", value, "applicationUnit");
            return (Criteria) this;
        }

        public Criteria andApplicationUnitGreaterThanOrEqualTo(String value) {
            addCriterion("application_unit >=", value, "applicationUnit");
            return (Criteria) this;
        }

        public Criteria andApplicationUnitLessThan(String value) {
            addCriterion("application_unit <", value, "applicationUnit");
            return (Criteria) this;
        }

        public Criteria andApplicationUnitLessThanOrEqualTo(String value) {
            addCriterion("application_unit <=", value, "applicationUnit");
            return (Criteria) this;
        }

        public Criteria andApplicationUnitLike(String value) {
            addCriterion("application_unit like", value, "applicationUnit");
            return (Criteria) this;
        }

        public Criteria andApplicationUnitNotLike(String value) {
            addCriterion("application_unit not like", value, "applicationUnit");
            return (Criteria) this;
        }

        public Criteria andApplicationUnitIn(List<String> values) {
            addCriterion("application_unit in", values, "applicationUnit");
            return (Criteria) this;
        }

        public Criteria andApplicationUnitNotIn(List<String> values) {
            addCriterion("application_unit not in", values, "applicationUnit");
            return (Criteria) this;
        }

        public Criteria andApplicationUnitBetween(String value1, String value2) {
            addCriterion("application_unit between", value1, value2, "applicationUnit");
            return (Criteria) this;
        }

        public Criteria andApplicationUnitNotBetween(String value1, String value2) {
            addCriterion("application_unit not between", value1, value2, "applicationUnit");
            return (Criteria) this;
        }

        public Criteria andConstructionUnitIsNull() {
            addCriterion("construction_unit is null");
            return (Criteria) this;
        }

        public Criteria andConstructionUnitIsNotNull() {
            addCriterion("construction_unit is not null");
            return (Criteria) this;
        }

        public Criteria andConstructionUnitEqualTo(String value) {
            addCriterion("construction_unit =", value, "constructionUnit");
            return (Criteria) this;
        }

        public Criteria andConstructionUnitNotEqualTo(String value) {
            addCriterion("construction_unit <>", value, "constructionUnit");
            return (Criteria) this;
        }

        public Criteria andConstructionUnitGreaterThan(String value) {
            addCriterion("construction_unit >", value, "constructionUnit");
            return (Criteria) this;
        }

        public Criteria andConstructionUnitGreaterThanOrEqualTo(String value) {
            addCriterion("construction_unit >=", value, "constructionUnit");
            return (Criteria) this;
        }

        public Criteria andConstructionUnitLessThan(String value) {
            addCriterion("construction_unit <", value, "constructionUnit");
            return (Criteria) this;
        }

        public Criteria andConstructionUnitLessThanOrEqualTo(String value) {
            addCriterion("construction_unit <=", value, "constructionUnit");
            return (Criteria) this;
        }

        public Criteria andConstructionUnitLike(String value) {
            addCriterion("construction_unit like", value, "constructionUnit");
            return (Criteria) this;
        }

        public Criteria andConstructionUnitNotLike(String value) {
            addCriterion("construction_unit not like", value, "constructionUnit");
            return (Criteria) this;
        }

        public Criteria andConstructionUnitIn(List<String> values) {
            addCriterion("construction_unit in", values, "constructionUnit");
            return (Criteria) this;
        }

        public Criteria andConstructionUnitNotIn(List<String> values) {
            addCriterion("construction_unit not in", values, "constructionUnit");
            return (Criteria) this;
        }

        public Criteria andConstructionUnitBetween(String value1, String value2) {
            addCriterion("construction_unit between", value1, value2, "constructionUnit");
            return (Criteria) this;
        }

        public Criteria andConstructionUnitNotBetween(String value1, String value2) {
            addCriterion("construction_unit not between", value1, value2, "constructionUnit");
            return (Criteria) this;
        }

        public Criteria andWorkTimeStartIsNull() {
            addCriterion("work_time_start is null");
            return (Criteria) this;
        }

        public Criteria andWorkTimeStartIsNotNull() {
            addCriterion("work_time_start is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTimeStartEqualTo(String value) {
            addCriterion("work_time_start =", value, "workTimeStart");
            return (Criteria) this;
        }

        public Criteria andWorkTimeStartNotEqualTo(String value) {
            addCriterion("work_time_start <>", value, "workTimeStart");
            return (Criteria) this;
        }

        public Criteria andWorkTimeStartGreaterThan(String value) {
            addCriterion("work_time_start >", value, "workTimeStart");
            return (Criteria) this;
        }

        public Criteria andWorkTimeStartGreaterThanOrEqualTo(String value) {
            addCriterion("work_time_start >=", value, "workTimeStart");
            return (Criteria) this;
        }

        public Criteria andWorkTimeStartLessThan(String value) {
            addCriterion("work_time_start <", value, "workTimeStart");
            return (Criteria) this;
        }

        public Criteria andWorkTimeStartLessThanOrEqualTo(String value) {
            addCriterion("work_time_start <=", value, "workTimeStart");
            return (Criteria) this;
        }

        public Criteria andWorkTimeStartLike(String value) {
            addCriterion("work_time_start like", value, "workTimeStart");
            return (Criteria) this;
        }

        public Criteria andWorkTimeStartNotLike(String value) {
            addCriterion("work_time_start not like", value, "workTimeStart");
            return (Criteria) this;
        }

        public Criteria andWorkTimeStartIn(List<String> values) {
            addCriterion("work_time_start in", values, "workTimeStart");
            return (Criteria) this;
        }

        public Criteria andWorkTimeStartNotIn(List<String> values) {
            addCriterion("work_time_start not in", values, "workTimeStart");
            return (Criteria) this;
        }

        public Criteria andWorkTimeStartBetween(String value1, String value2) {
            addCriterion("work_time_start between", value1, value2, "workTimeStart");
            return (Criteria) this;
        }

        public Criteria andWorkTimeStartNotBetween(String value1, String value2) {
            addCriterion("work_time_start not between", value1, value2, "workTimeStart");
            return (Criteria) this;
        }

        public Criteria andWorkTimeEndIsNull() {
            addCriterion("work_time_end is null");
            return (Criteria) this;
        }

        public Criteria andWorkTimeEndIsNotNull() {
            addCriterion("work_time_end is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTimeEndEqualTo(String value) {
            addCriterion("work_time_end =", value, "workTimeEnd");
            return (Criteria) this;
        }

        public Criteria andWorkTimeEndNotEqualTo(String value) {
            addCriterion("work_time_end <>", value, "workTimeEnd");
            return (Criteria) this;
        }

        public Criteria andWorkTimeEndGreaterThan(String value) {
            addCriterion("work_time_end >", value, "workTimeEnd");
            return (Criteria) this;
        }

        public Criteria andWorkTimeEndGreaterThanOrEqualTo(String value) {
            addCriterion("work_time_end >=", value, "workTimeEnd");
            return (Criteria) this;
        }

        public Criteria andWorkTimeEndLessThan(String value) {
            addCriterion("work_time_end <", value, "workTimeEnd");
            return (Criteria) this;
        }

        public Criteria andWorkTimeEndLessThanOrEqualTo(String value) {
            addCriterion("work_time_end <=", value, "workTimeEnd");
            return (Criteria) this;
        }

        public Criteria andWorkTimeEndLike(String value) {
            addCriterion("work_time_end like", value, "workTimeEnd");
            return (Criteria) this;
        }

        public Criteria andWorkTimeEndNotLike(String value) {
            addCriterion("work_time_end not like", value, "workTimeEnd");
            return (Criteria) this;
        }

        public Criteria andWorkTimeEndIn(List<String> values) {
            addCriterion("work_time_end in", values, "workTimeEnd");
            return (Criteria) this;
        }

        public Criteria andWorkTimeEndNotIn(List<String> values) {
            addCriterion("work_time_end not in", values, "workTimeEnd");
            return (Criteria) this;
        }

        public Criteria andWorkTimeEndBetween(String value1, String value2) {
            addCriterion("work_time_end between", value1, value2, "workTimeEnd");
            return (Criteria) this;
        }

        public Criteria andWorkTimeEndNotBetween(String value1, String value2) {
            addCriterion("work_time_end not between", value1, value2, "workTimeEnd");
            return (Criteria) this;
        }

        public Criteria andWorkAreaIsNull() {
            addCriterion("work_area is null");
            return (Criteria) this;
        }

        public Criteria andWorkAreaIsNotNull() {
            addCriterion("work_area is not null");
            return (Criteria) this;
        }

        public Criteria andWorkAreaEqualTo(String value) {
            addCriterion("work_area =", value, "workArea");
            return (Criteria) this;
        }

        public Criteria andWorkAreaNotEqualTo(String value) {
            addCriterion("work_area <>", value, "workArea");
            return (Criteria) this;
        }

        public Criteria andWorkAreaGreaterThan(String value) {
            addCriterion("work_area >", value, "workArea");
            return (Criteria) this;
        }

        public Criteria andWorkAreaGreaterThanOrEqualTo(String value) {
            addCriterion("work_area >=", value, "workArea");
            return (Criteria) this;
        }

        public Criteria andWorkAreaLessThan(String value) {
            addCriterion("work_area <", value, "workArea");
            return (Criteria) this;
        }

        public Criteria andWorkAreaLessThanOrEqualTo(String value) {
            addCriterion("work_area <=", value, "workArea");
            return (Criteria) this;
        }

        public Criteria andWorkAreaLike(String value) {
            addCriterion("work_area like", value, "workArea");
            return (Criteria) this;
        }

        public Criteria andWorkAreaNotLike(String value) {
            addCriterion("work_area not like", value, "workArea");
            return (Criteria) this;
        }

        public Criteria andWorkAreaIn(List<String> values) {
            addCriterion("work_area in", values, "workArea");
            return (Criteria) this;
        }

        public Criteria andWorkAreaNotIn(List<String> values) {
            addCriterion("work_area not in", values, "workArea");
            return (Criteria) this;
        }

        public Criteria andWorkAreaBetween(String value1, String value2) {
            addCriterion("work_area between", value1, value2, "workArea");
            return (Criteria) this;
        }

        public Criteria andWorkAreaNotBetween(String value1, String value2) {
            addCriterion("work_area not between", value1, value2, "workArea");
            return (Criteria) this;
        }

        public Criteria andWorkContentIsNull() {
            addCriterion("work_content is null");
            return (Criteria) this;
        }

        public Criteria andWorkContentIsNotNull() {
            addCriterion("work_content is not null");
            return (Criteria) this;
        }

        public Criteria andWorkContentEqualTo(String value) {
            addCriterion("work_content =", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentNotEqualTo(String value) {
            addCriterion("work_content <>", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentGreaterThan(String value) {
            addCriterion("work_content >", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentGreaterThanOrEqualTo(String value) {
            addCriterion("work_content >=", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentLessThan(String value) {
            addCriterion("work_content <", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentLessThanOrEqualTo(String value) {
            addCriterion("work_content <=", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentLike(String value) {
            addCriterion("work_content like", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentNotLike(String value) {
            addCriterion("work_content not like", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentIn(List<String> values) {
            addCriterion("work_content in", values, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentNotIn(List<String> values) {
            addCriterion("work_content not in", values, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentBetween(String value1, String value2) {
            addCriterion("work_content between", value1, value2, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentNotBetween(String value1, String value2) {
            addCriterion("work_content not between", value1, value2, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkScopeIsNull() {
            addCriterion("work_scope is null");
            return (Criteria) this;
        }

        public Criteria andWorkScopeIsNotNull() {
            addCriterion("work_scope is not null");
            return (Criteria) this;
        }

        public Criteria andWorkScopeEqualTo(String value) {
            addCriterion("work_scope =", value, "workScope");
            return (Criteria) this;
        }

        public Criteria andWorkScopeNotEqualTo(String value) {
            addCriterion("work_scope <>", value, "workScope");
            return (Criteria) this;
        }

        public Criteria andWorkScopeGreaterThan(String value) {
            addCriterion("work_scope >", value, "workScope");
            return (Criteria) this;
        }

        public Criteria andWorkScopeGreaterThanOrEqualTo(String value) {
            addCriterion("work_scope >=", value, "workScope");
            return (Criteria) this;
        }

        public Criteria andWorkScopeLessThan(String value) {
            addCriterion("work_scope <", value, "workScope");
            return (Criteria) this;
        }

        public Criteria andWorkScopeLessThanOrEqualTo(String value) {
            addCriterion("work_scope <=", value, "workScope");
            return (Criteria) this;
        }

        public Criteria andWorkScopeLike(String value) {
            addCriterion("work_scope like", value, "workScope");
            return (Criteria) this;
        }

        public Criteria andWorkScopeNotLike(String value) {
            addCriterion("work_scope not like", value, "workScope");
            return (Criteria) this;
        }

        public Criteria andWorkScopeIn(List<String> values) {
            addCriterion("work_scope in", values, "workScope");
            return (Criteria) this;
        }

        public Criteria andWorkScopeNotIn(List<String> values) {
            addCriterion("work_scope not in", values, "workScope");
            return (Criteria) this;
        }

        public Criteria andWorkScopeBetween(String value1, String value2) {
            addCriterion("work_scope between", value1, value2, "workScope");
            return (Criteria) this;
        }

        public Criteria andWorkScopeNotBetween(String value1, String value2) {
            addCriterion("work_scope not between", value1, value2, "workScope");
            return (Criteria) this;
        }

        public Criteria andWorkWayIsNull() {
            addCriterion("work_way is null");
            return (Criteria) this;
        }

        public Criteria andWorkWayIsNotNull() {
            addCriterion("work_way is not null");
            return (Criteria) this;
        }

        public Criteria andWorkWayEqualTo(String value) {
            addCriterion("work_way =", value, "workWay");
            return (Criteria) this;
        }

        public Criteria andWorkWayNotEqualTo(String value) {
            addCriterion("work_way <>", value, "workWay");
            return (Criteria) this;
        }

        public Criteria andWorkWayGreaterThan(String value) {
            addCriterion("work_way >", value, "workWay");
            return (Criteria) this;
        }

        public Criteria andWorkWayGreaterThanOrEqualTo(String value) {
            addCriterion("work_way >=", value, "workWay");
            return (Criteria) this;
        }

        public Criteria andWorkWayLessThan(String value) {
            addCriterion("work_way <", value, "workWay");
            return (Criteria) this;
        }

        public Criteria andWorkWayLessThanOrEqualTo(String value) {
            addCriterion("work_way <=", value, "workWay");
            return (Criteria) this;
        }

        public Criteria andWorkWayLike(String value) {
            addCriterion("work_way like", value, "workWay");
            return (Criteria) this;
        }

        public Criteria andWorkWayNotLike(String value) {
            addCriterion("work_way not like", value, "workWay");
            return (Criteria) this;
        }

        public Criteria andWorkWayIn(List<String> values) {
            addCriterion("work_way in", values, "workWay");
            return (Criteria) this;
        }

        public Criteria andWorkWayNotIn(List<String> values) {
            addCriterion("work_way not in", values, "workWay");
            return (Criteria) this;
        }

        public Criteria andWorkWayBetween(String value1, String value2) {
            addCriterion("work_way between", value1, value2, "workWay");
            return (Criteria) this;
        }

        public Criteria andWorkWayNotBetween(String value1, String value2) {
            addCriterion("work_way not between", value1, value2, "workWay");
            return (Criteria) this;
        }

        public Criteria andPitBaseDepthIsNull() {
            addCriterion("pit_base_depth is null");
            return (Criteria) this;
        }

        public Criteria andPitBaseDepthIsNotNull() {
            addCriterion("pit_base_depth is not null");
            return (Criteria) this;
        }

        public Criteria andPitBaseDepthEqualTo(String value) {
            addCriterion("pit_base_depth =", value, "pitBaseDepth");
            return (Criteria) this;
        }

        public Criteria andPitBaseDepthNotEqualTo(String value) {
            addCriterion("pit_base_depth <>", value, "pitBaseDepth");
            return (Criteria) this;
        }

        public Criteria andPitBaseDepthGreaterThan(String value) {
            addCriterion("pit_base_depth >", value, "pitBaseDepth");
            return (Criteria) this;
        }

        public Criteria andPitBaseDepthGreaterThanOrEqualTo(String value) {
            addCriterion("pit_base_depth >=", value, "pitBaseDepth");
            return (Criteria) this;
        }

        public Criteria andPitBaseDepthLessThan(String value) {
            addCriterion("pit_base_depth <", value, "pitBaseDepth");
            return (Criteria) this;
        }

        public Criteria andPitBaseDepthLessThanOrEqualTo(String value) {
            addCriterion("pit_base_depth <=", value, "pitBaseDepth");
            return (Criteria) this;
        }

        public Criteria andPitBaseDepthLike(String value) {
            addCriterion("pit_base_depth like", value, "pitBaseDepth");
            return (Criteria) this;
        }

        public Criteria andPitBaseDepthNotLike(String value) {
            addCriterion("pit_base_depth not like", value, "pitBaseDepth");
            return (Criteria) this;
        }

        public Criteria andPitBaseDepthIn(List<String> values) {
            addCriterion("pit_base_depth in", values, "pitBaseDepth");
            return (Criteria) this;
        }

        public Criteria andPitBaseDepthNotIn(List<String> values) {
            addCriterion("pit_base_depth not in", values, "pitBaseDepth");
            return (Criteria) this;
        }

        public Criteria andPitBaseDepthBetween(String value1, String value2) {
            addCriterion("pit_base_depth between", value1, value2, "pitBaseDepth");
            return (Criteria) this;
        }

        public Criteria andPitBaseDepthNotBetween(String value1, String value2) {
            addCriterion("pit_base_depth not between", value1, value2, "pitBaseDepth");
            return (Criteria) this;
        }

        public Criteria andPitBaseAreaIsNull() {
            addCriterion("pit_base_area is null");
            return (Criteria) this;
        }

        public Criteria andPitBaseAreaIsNotNull() {
            addCriterion("pit_base_area is not null");
            return (Criteria) this;
        }

        public Criteria andPitBaseAreaEqualTo(String value) {
            addCriterion("pit_base_area =", value, "pitBaseArea");
            return (Criteria) this;
        }

        public Criteria andPitBaseAreaNotEqualTo(String value) {
            addCriterion("pit_base_area <>", value, "pitBaseArea");
            return (Criteria) this;
        }

        public Criteria andPitBaseAreaGreaterThan(String value) {
            addCriterion("pit_base_area >", value, "pitBaseArea");
            return (Criteria) this;
        }

        public Criteria andPitBaseAreaGreaterThanOrEqualTo(String value) {
            addCriterion("pit_base_area >=", value, "pitBaseArea");
            return (Criteria) this;
        }

        public Criteria andPitBaseAreaLessThan(String value) {
            addCriterion("pit_base_area <", value, "pitBaseArea");
            return (Criteria) this;
        }

        public Criteria andPitBaseAreaLessThanOrEqualTo(String value) {
            addCriterion("pit_base_area <=", value, "pitBaseArea");
            return (Criteria) this;
        }

        public Criteria andPitBaseAreaLike(String value) {
            addCriterion("pit_base_area like", value, "pitBaseArea");
            return (Criteria) this;
        }

        public Criteria andPitBaseAreaNotLike(String value) {
            addCriterion("pit_base_area not like", value, "pitBaseArea");
            return (Criteria) this;
        }

        public Criteria andPitBaseAreaIn(List<String> values) {
            addCriterion("pit_base_area in", values, "pitBaseArea");
            return (Criteria) this;
        }

        public Criteria andPitBaseAreaNotIn(List<String> values) {
            addCriterion("pit_base_area not in", values, "pitBaseArea");
            return (Criteria) this;
        }

        public Criteria andPitBaseAreaBetween(String value1, String value2) {
            addCriterion("pit_base_area between", value1, value2, "pitBaseArea");
            return (Criteria) this;
        }

        public Criteria andPitBaseAreaNotBetween(String value1, String value2) {
            addCriterion("pit_base_area not between", value1, value2, "pitBaseArea");
            return (Criteria) this;
        }

        public Criteria andAttachIdsIsNull() {
            addCriterion("attach_ids is null");
            return (Criteria) this;
        }

        public Criteria andAttachIdsIsNotNull() {
            addCriterion("attach_ids is not null");
            return (Criteria) this;
        }

        public Criteria andAttachIdsEqualTo(String value) {
            addCriterion("attach_ids =", value, "attachIds");
            return (Criteria) this;
        }

        public Criteria andAttachIdsNotEqualTo(String value) {
            addCriterion("attach_ids <>", value, "attachIds");
            return (Criteria) this;
        }

        public Criteria andAttachIdsGreaterThan(String value) {
            addCriterion("attach_ids >", value, "attachIds");
            return (Criteria) this;
        }

        public Criteria andAttachIdsGreaterThanOrEqualTo(String value) {
            addCriterion("attach_ids >=", value, "attachIds");
            return (Criteria) this;
        }

        public Criteria andAttachIdsLessThan(String value) {
            addCriterion("attach_ids <", value, "attachIds");
            return (Criteria) this;
        }

        public Criteria andAttachIdsLessThanOrEqualTo(String value) {
            addCriterion("attach_ids <=", value, "attachIds");
            return (Criteria) this;
        }

        public Criteria andAttachIdsLike(String value) {
            addCriterion("attach_ids like", value, "attachIds");
            return (Criteria) this;
        }

        public Criteria andAttachIdsNotLike(String value) {
            addCriterion("attach_ids not like", value, "attachIds");
            return (Criteria) this;
        }

        public Criteria andAttachIdsIn(List<String> values) {
            addCriterion("attach_ids in", values, "attachIds");
            return (Criteria) this;
        }

        public Criteria andAttachIdsNotIn(List<String> values) {
            addCriterion("attach_ids not in", values, "attachIds");
            return (Criteria) this;
        }

        public Criteria andAttachIdsBetween(String value1, String value2) {
            addCriterion("attach_ids between", value1, value2, "attachIds");
            return (Criteria) this;
        }

        public Criteria andAttachIdsNotBetween(String value1, String value2) {
            addCriterion("attach_ids not between", value1, value2, "attachIds");
            return (Criteria) this;
        }

        public Criteria andRadiationSourcesIsNull() {
            addCriterion("radiation_sources is null");
            return (Criteria) this;
        }

        public Criteria andRadiationSourcesIsNotNull() {
            addCriterion("radiation_sources is not null");
            return (Criteria) this;
        }

        public Criteria andRadiationSourcesEqualTo(String value) {
            addCriterion("radiation_sources =", value, "radiationSources");
            return (Criteria) this;
        }

        public Criteria andRadiationSourcesNotEqualTo(String value) {
            addCriterion("radiation_sources <>", value, "radiationSources");
            return (Criteria) this;
        }

        public Criteria andRadiationSourcesGreaterThan(String value) {
            addCriterion("radiation_sources >", value, "radiationSources");
            return (Criteria) this;
        }

        public Criteria andRadiationSourcesGreaterThanOrEqualTo(String value) {
            addCriterion("radiation_sources >=", value, "radiationSources");
            return (Criteria) this;
        }

        public Criteria andRadiationSourcesLessThan(String value) {
            addCriterion("radiation_sources <", value, "radiationSources");
            return (Criteria) this;
        }

        public Criteria andRadiationSourcesLessThanOrEqualTo(String value) {
            addCriterion("radiation_sources <=", value, "radiationSources");
            return (Criteria) this;
        }

        public Criteria andRadiationSourcesLike(String value) {
            addCriterion("radiation_sources like", value, "radiationSources");
            return (Criteria) this;
        }

        public Criteria andRadiationSourcesNotLike(String value) {
            addCriterion("radiation_sources not like", value, "radiationSources");
            return (Criteria) this;
        }

        public Criteria andRadiationSourcesIn(List<String> values) {
            addCriterion("radiation_sources in", values, "radiationSources");
            return (Criteria) this;
        }

        public Criteria andRadiationSourcesNotIn(List<String> values) {
            addCriterion("radiation_sources not in", values, "radiationSources");
            return (Criteria) this;
        }

        public Criteria andRadiationSourcesBetween(String value1, String value2) {
            addCriterion("radiation_sources between", value1, value2, "radiationSources");
            return (Criteria) this;
        }

        public Criteria andRadiationSourcesNotBetween(String value1, String value2) {
            addCriterion("radiation_sources not between", value1, value2, "radiationSources");
            return (Criteria) this;
        }

        public Criteria andDefectoscopeTypeIsNull() {
            addCriterion("defectoscope_type is null");
            return (Criteria) this;
        }

        public Criteria andDefectoscopeTypeIsNotNull() {
            addCriterion("defectoscope_type is not null");
            return (Criteria) this;
        }

        public Criteria andDefectoscopeTypeEqualTo(String value) {
            addCriterion("defectoscope_type =", value, "defectoscopeType");
            return (Criteria) this;
        }

        public Criteria andDefectoscopeTypeNotEqualTo(String value) {
            addCriterion("defectoscope_type <>", value, "defectoscopeType");
            return (Criteria) this;
        }

        public Criteria andDefectoscopeTypeGreaterThan(String value) {
            addCriterion("defectoscope_type >", value, "defectoscopeType");
            return (Criteria) this;
        }

        public Criteria andDefectoscopeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("defectoscope_type >=", value, "defectoscopeType");
            return (Criteria) this;
        }

        public Criteria andDefectoscopeTypeLessThan(String value) {
            addCriterion("defectoscope_type <", value, "defectoscopeType");
            return (Criteria) this;
        }

        public Criteria andDefectoscopeTypeLessThanOrEqualTo(String value) {
            addCriterion("defectoscope_type <=", value, "defectoscopeType");
            return (Criteria) this;
        }

        public Criteria andDefectoscopeTypeLike(String value) {
            addCriterion("defectoscope_type like", value, "defectoscopeType");
            return (Criteria) this;
        }

        public Criteria andDefectoscopeTypeNotLike(String value) {
            addCriterion("defectoscope_type not like", value, "defectoscopeType");
            return (Criteria) this;
        }

        public Criteria andDefectoscopeTypeIn(List<String> values) {
            addCriterion("defectoscope_type in", values, "defectoscopeType");
            return (Criteria) this;
        }

        public Criteria andDefectoscopeTypeNotIn(List<String> values) {
            addCriterion("defectoscope_type not in", values, "defectoscopeType");
            return (Criteria) this;
        }

        public Criteria andDefectoscopeTypeBetween(String value1, String value2) {
            addCriterion("defectoscope_type between", value1, value2, "defectoscopeType");
            return (Criteria) this;
        }

        public Criteria andDefectoscopeTypeNotBetween(String value1, String value2) {
            addCriterion("defectoscope_type not between", value1, value2, "defectoscopeType");
            return (Criteria) this;
        }

        public Criteria andOriginalMediumIsNull() {
            addCriterion("original_medium is null");
            return (Criteria) this;
        }

        public Criteria andOriginalMediumIsNotNull() {
            addCriterion("original_medium is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalMediumEqualTo(String value) {
            addCriterion("original_medium =", value, "originalMedium");
            return (Criteria) this;
        }

        public Criteria andOriginalMediumNotEqualTo(String value) {
            addCriterion("original_medium <>", value, "originalMedium");
            return (Criteria) this;
        }

        public Criteria andOriginalMediumGreaterThan(String value) {
            addCriterion("original_medium >", value, "originalMedium");
            return (Criteria) this;
        }

        public Criteria andOriginalMediumGreaterThanOrEqualTo(String value) {
            addCriterion("original_medium >=", value, "originalMedium");
            return (Criteria) this;
        }

        public Criteria andOriginalMediumLessThan(String value) {
            addCriterion("original_medium <", value, "originalMedium");
            return (Criteria) this;
        }

        public Criteria andOriginalMediumLessThanOrEqualTo(String value) {
            addCriterion("original_medium <=", value, "originalMedium");
            return (Criteria) this;
        }

        public Criteria andOriginalMediumLike(String value) {
            addCriterion("original_medium like", value, "originalMedium");
            return (Criteria) this;
        }

        public Criteria andOriginalMediumNotLike(String value) {
            addCriterion("original_medium not like", value, "originalMedium");
            return (Criteria) this;
        }

        public Criteria andOriginalMediumIn(List<String> values) {
            addCriterion("original_medium in", values, "originalMedium");
            return (Criteria) this;
        }

        public Criteria andOriginalMediumNotIn(List<String> values) {
            addCriterion("original_medium not in", values, "originalMedium");
            return (Criteria) this;
        }

        public Criteria andOriginalMediumBetween(String value1, String value2) {
            addCriterion("original_medium between", value1, value2, "originalMedium");
            return (Criteria) this;
        }

        public Criteria andOriginalMediumNotBetween(String value1, String value2) {
            addCriterion("original_medium not between", value1, value2, "originalMedium");
            return (Criteria) this;
        }

        public Criteria andHazardFactorIsNull() {
            addCriterion("hazard_factor is null");
            return (Criteria) this;
        }

        public Criteria andHazardFactorIsNotNull() {
            addCriterion("hazard_factor is not null");
            return (Criteria) this;
        }

        public Criteria andHazardFactorEqualTo(String value) {
            addCriterion("hazard_factor =", value, "hazardFactor");
            return (Criteria) this;
        }

        public Criteria andHazardFactorNotEqualTo(String value) {
            addCriterion("hazard_factor <>", value, "hazardFactor");
            return (Criteria) this;
        }

        public Criteria andHazardFactorGreaterThan(String value) {
            addCriterion("hazard_factor >", value, "hazardFactor");
            return (Criteria) this;
        }

        public Criteria andHazardFactorGreaterThanOrEqualTo(String value) {
            addCriterion("hazard_factor >=", value, "hazardFactor");
            return (Criteria) this;
        }

        public Criteria andHazardFactorLessThan(String value) {
            addCriterion("hazard_factor <", value, "hazardFactor");
            return (Criteria) this;
        }

        public Criteria andHazardFactorLessThanOrEqualTo(String value) {
            addCriterion("hazard_factor <=", value, "hazardFactor");
            return (Criteria) this;
        }

        public Criteria andHazardFactorLike(String value) {
            addCriterion("hazard_factor like", value, "hazardFactor");
            return (Criteria) this;
        }

        public Criteria andHazardFactorNotLike(String value) {
            addCriterion("hazard_factor not like", value, "hazardFactor");
            return (Criteria) this;
        }

        public Criteria andHazardFactorIn(List<String> values) {
            addCriterion("hazard_factor in", values, "hazardFactor");
            return (Criteria) this;
        }

        public Criteria andHazardFactorNotIn(List<String> values) {
            addCriterion("hazard_factor not in", values, "hazardFactor");
            return (Criteria) this;
        }

        public Criteria andHazardFactorBetween(String value1, String value2) {
            addCriterion("hazard_factor between", value1, value2, "hazardFactor");
            return (Criteria) this;
        }

        public Criteria andHazardFactorNotBetween(String value1, String value2) {
            addCriterion("hazard_factor not between", value1, value2, "hazardFactor");
            return (Criteria) this;
        }

        public Criteria andSubContractorIsNull() {
            addCriterion("sub_contractor is null");
            return (Criteria) this;
        }

        public Criteria andSubContractorIsNotNull() {
            addCriterion("sub_contractor is not null");
            return (Criteria) this;
        }

        public Criteria andSubContractorEqualTo(String value) {
            addCriterion("sub_contractor =", value, "subContractor");
            return (Criteria) this;
        }

        public Criteria andSubContractorNotEqualTo(String value) {
            addCriterion("sub_contractor <>", value, "subContractor");
            return (Criteria) this;
        }

        public Criteria andSubContractorGreaterThan(String value) {
            addCriterion("sub_contractor >", value, "subContractor");
            return (Criteria) this;
        }

        public Criteria andSubContractorGreaterThanOrEqualTo(String value) {
            addCriterion("sub_contractor >=", value, "subContractor");
            return (Criteria) this;
        }

        public Criteria andSubContractorLessThan(String value) {
            addCriterion("sub_contractor <", value, "subContractor");
            return (Criteria) this;
        }

        public Criteria andSubContractorLessThanOrEqualTo(String value) {
            addCriterion("sub_contractor <=", value, "subContractor");
            return (Criteria) this;
        }

        public Criteria andSubContractorLike(String value) {
            addCriterion("sub_contractor like", value, "subContractor");
            return (Criteria) this;
        }

        public Criteria andSubContractorNotLike(String value) {
            addCriterion("sub_contractor not like", value, "subContractor");
            return (Criteria) this;
        }

        public Criteria andSubContractorIn(List<String> values) {
            addCriterion("sub_contractor in", values, "subContractor");
            return (Criteria) this;
        }

        public Criteria andSubContractorNotIn(List<String> values) {
            addCriterion("sub_contractor not in", values, "subContractor");
            return (Criteria) this;
        }

        public Criteria andSubContractorBetween(String value1, String value2) {
            addCriterion("sub_contractor between", value1, value2, "subContractor");
            return (Criteria) this;
        }

        public Criteria andSubContractorNotBetween(String value1, String value2) {
            addCriterion("sub_contractor not between", value1, value2, "subContractor");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("`type` is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("`type` is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("`type` =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("`type` <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("`type` >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("`type` >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("`type` <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("`type` <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("`type` like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("`type` not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("`type` in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("`type` not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("`type` between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("`type` not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andWeatherIsNull() {
            addCriterion("weather is null");
            return (Criteria) this;
        }

        public Criteria andWeatherIsNotNull() {
            addCriterion("weather is not null");
            return (Criteria) this;
        }

        public Criteria andWeatherEqualTo(String value) {
            addCriterion("weather =", value, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherNotEqualTo(String value) {
            addCriterion("weather <>", value, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherGreaterThan(String value) {
            addCriterion("weather >", value, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherGreaterThanOrEqualTo(String value) {
            addCriterion("weather >=", value, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherLessThan(String value) {
            addCriterion("weather <", value, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherLessThanOrEqualTo(String value) {
            addCriterion("weather <=", value, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherLike(String value) {
            addCriterion("weather like", value, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherNotLike(String value) {
            addCriterion("weather not like", value, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherIn(List<String> values) {
            addCriterion("weather in", values, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherNotIn(List<String> values) {
            addCriterion("weather not in", values, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherBetween(String value1, String value2) {
            addCriterion("weather between", value1, value2, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherNotBetween(String value1, String value2) {
            addCriterion("weather not between", value1, value2, "weather");
            return (Criteria) this;
        }

        public Criteria andRiskfactorIsNull() {
            addCriterion("riskFactor is null");
            return (Criteria) this;
        }

        public Criteria andRiskfactorIsNotNull() {
            addCriterion("riskFactor is not null");
            return (Criteria) this;
        }

        public Criteria andRiskfactorEqualTo(String value) {
            addCriterion("riskFactor =", value, "riskfactor");
            return (Criteria) this;
        }

        public Criteria andRiskfactorNotEqualTo(String value) {
            addCriterion("riskFactor <>", value, "riskfactor");
            return (Criteria) this;
        }

        public Criteria andRiskfactorGreaterThan(String value) {
            addCriterion("riskFactor >", value, "riskfactor");
            return (Criteria) this;
        }

        public Criteria andRiskfactorGreaterThanOrEqualTo(String value) {
            addCriterion("riskFactor >=", value, "riskfactor");
            return (Criteria) this;
        }

        public Criteria andRiskfactorLessThan(String value) {
            addCriterion("riskFactor <", value, "riskfactor");
            return (Criteria) this;
        }

        public Criteria andRiskfactorLessThanOrEqualTo(String value) {
            addCriterion("riskFactor <=", value, "riskfactor");
            return (Criteria) this;
        }

        public Criteria andRiskfactorLike(String value) {
            addCriterion("riskFactor like", value, "riskfactor");
            return (Criteria) this;
        }

        public Criteria andRiskfactorNotLike(String value) {
            addCriterion("riskFactor not like", value, "riskfactor");
            return (Criteria) this;
        }

        public Criteria andRiskfactorIn(List<String> values) {
            addCriterion("riskFactor in", values, "riskfactor");
            return (Criteria) this;
        }

        public Criteria andRiskfactorNotIn(List<String> values) {
            addCriterion("riskFactor not in", values, "riskfactor");
            return (Criteria) this;
        }

        public Criteria andRiskfactorBetween(String value1, String value2) {
            addCriterion("riskFactor between", value1, value2, "riskfactor");
            return (Criteria) this;
        }

        public Criteria andRiskfactorNotBetween(String value1, String value2) {
            addCriterion("riskFactor not between", value1, value2, "riskfactor");
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