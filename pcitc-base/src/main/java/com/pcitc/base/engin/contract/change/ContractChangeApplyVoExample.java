package com.pcitc.base.engin.contract.change;

import java.util.ArrayList;
import java.util.List;

public class ContractChangeApplyVoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ContractChangeApplyVoExample() {
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

        public Criteria andContractNameIsNull() {
            addCriterion("contract_name is null");
            return (Criteria) this;
        }

        public Criteria andContractNameIsNotNull() {
            addCriterion("contract_name is not null");
            return (Criteria) this;
        }

        public Criteria andContractNameEqualTo(String value) {
            addCriterion("contract_name =", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotEqualTo(String value) {
            addCriterion("contract_name <>", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameGreaterThan(String value) {
            addCriterion("contract_name >", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameGreaterThanOrEqualTo(String value) {
            addCriterion("contract_name >=", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameLessThan(String value) {
            addCriterion("contract_name <", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameLessThanOrEqualTo(String value) {
            addCriterion("contract_name <=", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameLike(String value) {
            addCriterion("contract_name like", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotLike(String value) {
            addCriterion("contract_name not like", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameIn(List<String> values) {
            addCriterion("contract_name in", values, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotIn(List<String> values) {
            addCriterion("contract_name not in", values, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameBetween(String value1, String value2) {
            addCriterion("contract_name between", value1, value2, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotBetween(String value1, String value2) {
            addCriterion("contract_name not between", value1, value2, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNoIsNull() {
            addCriterion("contract_no is null");
            return (Criteria) this;
        }

        public Criteria andContractNoIsNotNull() {
            addCriterion("contract_no is not null");
            return (Criteria) this;
        }

        public Criteria andContractNoEqualTo(String value) {
            addCriterion("contract_no =", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoNotEqualTo(String value) {
            addCriterion("contract_no <>", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoGreaterThan(String value) {
            addCriterion("contract_no >", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoGreaterThanOrEqualTo(String value) {
            addCriterion("contract_no >=", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoLessThan(String value) {
            addCriterion("contract_no <", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoLessThanOrEqualTo(String value) {
            addCriterion("contract_no <=", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoLike(String value) {
            addCriterion("contract_no like", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoNotLike(String value) {
            addCriterion("contract_no not like", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoIn(List<String> values) {
            addCriterion("contract_no in", values, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoNotIn(List<String> values) {
            addCriterion("contract_no not in", values, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoBetween(String value1, String value2) {
            addCriterion("contract_no between", value1, value2, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoNotBetween(String value1, String value2) {
            addCriterion("contract_no not between", value1, value2, "contractNo");
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

        public Criteria andChangeApplyNoIsNull() {
            addCriterion("change_apply_no is null");
            return (Criteria) this;
        }

        public Criteria andChangeApplyNoIsNotNull() {
            addCriterion("change_apply_no is not null");
            return (Criteria) this;
        }

        public Criteria andChangeApplyNoEqualTo(String value) {
            addCriterion("change_apply_no =", value, "changeApplyNo");
            return (Criteria) this;
        }

        public Criteria andChangeApplyNoNotEqualTo(String value) {
            addCriterion("change_apply_no <>", value, "changeApplyNo");
            return (Criteria) this;
        }

        public Criteria andChangeApplyNoGreaterThan(String value) {
            addCriterion("change_apply_no >", value, "changeApplyNo");
            return (Criteria) this;
        }

        public Criteria andChangeApplyNoGreaterThanOrEqualTo(String value) {
            addCriterion("change_apply_no >=", value, "changeApplyNo");
            return (Criteria) this;
        }

        public Criteria andChangeApplyNoLessThan(String value) {
            addCriterion("change_apply_no <", value, "changeApplyNo");
            return (Criteria) this;
        }

        public Criteria andChangeApplyNoLessThanOrEqualTo(String value) {
            addCriterion("change_apply_no <=", value, "changeApplyNo");
            return (Criteria) this;
        }

        public Criteria andChangeApplyNoLike(String value) {
            addCriterion("change_apply_no like", value, "changeApplyNo");
            return (Criteria) this;
        }

        public Criteria andChangeApplyNoNotLike(String value) {
            addCriterion("change_apply_no not like", value, "changeApplyNo");
            return (Criteria) this;
        }

        public Criteria andChangeApplyNoIn(List<String> values) {
            addCriterion("change_apply_no in", values, "changeApplyNo");
            return (Criteria) this;
        }

        public Criteria andChangeApplyNoNotIn(List<String> values) {
            addCriterion("change_apply_no not in", values, "changeApplyNo");
            return (Criteria) this;
        }

        public Criteria andChangeApplyNoBetween(String value1, String value2) {
            addCriterion("change_apply_no between", value1, value2, "changeApplyNo");
            return (Criteria) this;
        }

        public Criteria andChangeApplyNoNotBetween(String value1, String value2) {
            addCriterion("change_apply_no not between", value1, value2, "changeApplyNo");
            return (Criteria) this;
        }

        public Criteria andChangeUnitNameIsNull() {
            addCriterion("change_unit_name is null");
            return (Criteria) this;
        }

        public Criteria andChangeUnitNameIsNotNull() {
            addCriterion("change_unit_name is not null");
            return (Criteria) this;
        }

        public Criteria andChangeUnitNameEqualTo(String value) {
            addCriterion("change_unit_name =", value, "changeUnitName");
            return (Criteria) this;
        }

        public Criteria andChangeUnitNameNotEqualTo(String value) {
            addCriterion("change_unit_name <>", value, "changeUnitName");
            return (Criteria) this;
        }

        public Criteria andChangeUnitNameGreaterThan(String value) {
            addCriterion("change_unit_name >", value, "changeUnitName");
            return (Criteria) this;
        }

        public Criteria andChangeUnitNameGreaterThanOrEqualTo(String value) {
            addCriterion("change_unit_name >=", value, "changeUnitName");
            return (Criteria) this;
        }

        public Criteria andChangeUnitNameLessThan(String value) {
            addCriterion("change_unit_name <", value, "changeUnitName");
            return (Criteria) this;
        }

        public Criteria andChangeUnitNameLessThanOrEqualTo(String value) {
            addCriterion("change_unit_name <=", value, "changeUnitName");
            return (Criteria) this;
        }

        public Criteria andChangeUnitNameLike(String value) {
            addCriterion("change_unit_name like", value, "changeUnitName");
            return (Criteria) this;
        }

        public Criteria andChangeUnitNameNotLike(String value) {
            addCriterion("change_unit_name not like", value, "changeUnitName");
            return (Criteria) this;
        }

        public Criteria andChangeUnitNameIn(List<String> values) {
            addCriterion("change_unit_name in", values, "changeUnitName");
            return (Criteria) this;
        }

        public Criteria andChangeUnitNameNotIn(List<String> values) {
            addCriterion("change_unit_name not in", values, "changeUnitName");
            return (Criteria) this;
        }

        public Criteria andChangeUnitNameBetween(String value1, String value2) {
            addCriterion("change_unit_name between", value1, value2, "changeUnitName");
            return (Criteria) this;
        }

        public Criteria andChangeUnitNameNotBetween(String value1, String value2) {
            addCriterion("change_unit_name not between", value1, value2, "changeUnitName");
            return (Criteria) this;
        }

        public Criteria andChangeTopicIsNull() {
            addCriterion("change_topic is null");
            return (Criteria) this;
        }

        public Criteria andChangeTopicIsNotNull() {
            addCriterion("change_topic is not null");
            return (Criteria) this;
        }

        public Criteria andChangeTopicEqualTo(String value) {
            addCriterion("change_topic =", value, "changeTopic");
            return (Criteria) this;
        }

        public Criteria andChangeTopicNotEqualTo(String value) {
            addCriterion("change_topic <>", value, "changeTopic");
            return (Criteria) this;
        }

        public Criteria andChangeTopicGreaterThan(String value) {
            addCriterion("change_topic >", value, "changeTopic");
            return (Criteria) this;
        }

        public Criteria andChangeTopicGreaterThanOrEqualTo(String value) {
            addCriterion("change_topic >=", value, "changeTopic");
            return (Criteria) this;
        }

        public Criteria andChangeTopicLessThan(String value) {
            addCriterion("change_topic <", value, "changeTopic");
            return (Criteria) this;
        }

        public Criteria andChangeTopicLessThanOrEqualTo(String value) {
            addCriterion("change_topic <=", value, "changeTopic");
            return (Criteria) this;
        }

        public Criteria andChangeTopicLike(String value) {
            addCriterion("change_topic like", value, "changeTopic");
            return (Criteria) this;
        }

        public Criteria andChangeTopicNotLike(String value) {
            addCriterion("change_topic not like", value, "changeTopic");
            return (Criteria) this;
        }

        public Criteria andChangeTopicIn(List<String> values) {
            addCriterion("change_topic in", values, "changeTopic");
            return (Criteria) this;
        }

        public Criteria andChangeTopicNotIn(List<String> values) {
            addCriterion("change_topic not in", values, "changeTopic");
            return (Criteria) this;
        }

        public Criteria andChangeTopicBetween(String value1, String value2) {
            addCriterion("change_topic between", value1, value2, "changeTopic");
            return (Criteria) this;
        }

        public Criteria andChangeTopicNotBetween(String value1, String value2) {
            addCriterion("change_topic not between", value1, value2, "changeTopic");
            return (Criteria) this;
        }

        public Criteria andChangeApplyReceiveDateIsNull() {
            addCriterion("change_apply_receive_date is null");
            return (Criteria) this;
        }

        public Criteria andChangeApplyReceiveDateIsNotNull() {
            addCriterion("change_apply_receive_date is not null");
            return (Criteria) this;
        }

        public Criteria andChangeApplyReceiveDateEqualTo(String value) {
            addCriterion("change_apply_receive_date =", value, "changeApplyReceiveDate");
            return (Criteria) this;
        }

        public Criteria andChangeApplyReceiveDateNotEqualTo(String value) {
            addCriterion("change_apply_receive_date <>", value, "changeApplyReceiveDate");
            return (Criteria) this;
        }

        public Criteria andChangeApplyReceiveDateGreaterThan(String value) {
            addCriterion("change_apply_receive_date >", value, "changeApplyReceiveDate");
            return (Criteria) this;
        }

        public Criteria andChangeApplyReceiveDateGreaterThanOrEqualTo(String value) {
            addCriterion("change_apply_receive_date >=", value, "changeApplyReceiveDate");
            return (Criteria) this;
        }

        public Criteria andChangeApplyReceiveDateLessThan(String value) {
            addCriterion("change_apply_receive_date <", value, "changeApplyReceiveDate");
            return (Criteria) this;
        }

        public Criteria andChangeApplyReceiveDateLessThanOrEqualTo(String value) {
            addCriterion("change_apply_receive_date <=", value, "changeApplyReceiveDate");
            return (Criteria) this;
        }

        public Criteria andChangeApplyReceiveDateLike(String value) {
            addCriterion("change_apply_receive_date like", value, "changeApplyReceiveDate");
            return (Criteria) this;
        }

        public Criteria andChangeApplyReceiveDateNotLike(String value) {
            addCriterion("change_apply_receive_date not like", value, "changeApplyReceiveDate");
            return (Criteria) this;
        }

        public Criteria andChangeApplyReceiveDateIn(List<String> values) {
            addCriterion("change_apply_receive_date in", values, "changeApplyReceiveDate");
            return (Criteria) this;
        }

        public Criteria andChangeApplyReceiveDateNotIn(List<String> values) {
            addCriterion("change_apply_receive_date not in", values, "changeApplyReceiveDate");
            return (Criteria) this;
        }

        public Criteria andChangeApplyReceiveDateBetween(String value1, String value2) {
            addCriterion("change_apply_receive_date between", value1, value2, "changeApplyReceiveDate");
            return (Criteria) this;
        }

        public Criteria andChangeApplyReceiveDateNotBetween(String value1, String value2) {
            addCriterion("change_apply_receive_date not between", value1, value2, "changeApplyReceiveDate");
            return (Criteria) this;
        }

        public Criteria andChangeApplyReplyDateIsNull() {
            addCriterion("change_apply_reply_date is null");
            return (Criteria) this;
        }

        public Criteria andChangeApplyReplyDateIsNotNull() {
            addCriterion("change_apply_reply_date is not null");
            return (Criteria) this;
        }

        public Criteria andChangeApplyReplyDateEqualTo(String value) {
            addCriterion("change_apply_reply_date =", value, "changeApplyReplyDate");
            return (Criteria) this;
        }

        public Criteria andChangeApplyReplyDateNotEqualTo(String value) {
            addCriterion("change_apply_reply_date <>", value, "changeApplyReplyDate");
            return (Criteria) this;
        }

        public Criteria andChangeApplyReplyDateGreaterThan(String value) {
            addCriterion("change_apply_reply_date >", value, "changeApplyReplyDate");
            return (Criteria) this;
        }

        public Criteria andChangeApplyReplyDateGreaterThanOrEqualTo(String value) {
            addCriterion("change_apply_reply_date >=", value, "changeApplyReplyDate");
            return (Criteria) this;
        }

        public Criteria andChangeApplyReplyDateLessThan(String value) {
            addCriterion("change_apply_reply_date <", value, "changeApplyReplyDate");
            return (Criteria) this;
        }

        public Criteria andChangeApplyReplyDateLessThanOrEqualTo(String value) {
            addCriterion("change_apply_reply_date <=", value, "changeApplyReplyDate");
            return (Criteria) this;
        }

        public Criteria andChangeApplyReplyDateLike(String value) {
            addCriterion("change_apply_reply_date like", value, "changeApplyReplyDate");
            return (Criteria) this;
        }

        public Criteria andChangeApplyReplyDateNotLike(String value) {
            addCriterion("change_apply_reply_date not like", value, "changeApplyReplyDate");
            return (Criteria) this;
        }

        public Criteria andChangeApplyReplyDateIn(List<String> values) {
            addCriterion("change_apply_reply_date in", values, "changeApplyReplyDate");
            return (Criteria) this;
        }

        public Criteria andChangeApplyReplyDateNotIn(List<String> values) {
            addCriterion("change_apply_reply_date not in", values, "changeApplyReplyDate");
            return (Criteria) this;
        }

        public Criteria andChangeApplyReplyDateBetween(String value1, String value2) {
            addCriterion("change_apply_reply_date between", value1, value2, "changeApplyReplyDate");
            return (Criteria) this;
        }

        public Criteria andChangeApplyReplyDateNotBetween(String value1, String value2) {
            addCriterion("change_apply_reply_date not between", value1, value2, "changeApplyReplyDate");
            return (Criteria) this;
        }

        public Criteria andChangeApplyEffectDateIsNull() {
            addCriterion("change_apply_effect_date is null");
            return (Criteria) this;
        }

        public Criteria andChangeApplyEffectDateIsNotNull() {
            addCriterion("change_apply_effect_date is not null");
            return (Criteria) this;
        }

        public Criteria andChangeApplyEffectDateEqualTo(String value) {
            addCriterion("change_apply_effect_date =", value, "changeApplyEffectDate");
            return (Criteria) this;
        }

        public Criteria andChangeApplyEffectDateNotEqualTo(String value) {
            addCriterion("change_apply_effect_date <>", value, "changeApplyEffectDate");
            return (Criteria) this;
        }

        public Criteria andChangeApplyEffectDateGreaterThan(String value) {
            addCriterion("change_apply_effect_date >", value, "changeApplyEffectDate");
            return (Criteria) this;
        }

        public Criteria andChangeApplyEffectDateGreaterThanOrEqualTo(String value) {
            addCriterion("change_apply_effect_date >=", value, "changeApplyEffectDate");
            return (Criteria) this;
        }

        public Criteria andChangeApplyEffectDateLessThan(String value) {
            addCriterion("change_apply_effect_date <", value, "changeApplyEffectDate");
            return (Criteria) this;
        }

        public Criteria andChangeApplyEffectDateLessThanOrEqualTo(String value) {
            addCriterion("change_apply_effect_date <=", value, "changeApplyEffectDate");
            return (Criteria) this;
        }

        public Criteria andChangeApplyEffectDateLike(String value) {
            addCriterion("change_apply_effect_date like", value, "changeApplyEffectDate");
            return (Criteria) this;
        }

        public Criteria andChangeApplyEffectDateNotLike(String value) {
            addCriterion("change_apply_effect_date not like", value, "changeApplyEffectDate");
            return (Criteria) this;
        }

        public Criteria andChangeApplyEffectDateIn(List<String> values) {
            addCriterion("change_apply_effect_date in", values, "changeApplyEffectDate");
            return (Criteria) this;
        }

        public Criteria andChangeApplyEffectDateNotIn(List<String> values) {
            addCriterion("change_apply_effect_date not in", values, "changeApplyEffectDate");
            return (Criteria) this;
        }

        public Criteria andChangeApplyEffectDateBetween(String value1, String value2) {
            addCriterion("change_apply_effect_date between", value1, value2, "changeApplyEffectDate");
            return (Criteria) this;
        }

        public Criteria andChangeApplyEffectDateNotBetween(String value1, String value2) {
            addCriterion("change_apply_effect_date not between", value1, value2, "changeApplyEffectDate");
            return (Criteria) this;
        }

        public Criteria andChangeReasonTypeIsNull() {
            addCriterion("change_reason_type is null");
            return (Criteria) this;
        }

        public Criteria andChangeReasonTypeIsNotNull() {
            addCriterion("change_reason_type is not null");
            return (Criteria) this;
        }

        public Criteria andChangeReasonTypeEqualTo(String value) {
            addCriterion("change_reason_type =", value, "changeReasonType");
            return (Criteria) this;
        }

        public Criteria andChangeReasonTypeNotEqualTo(String value) {
            addCriterion("change_reason_type <>", value, "changeReasonType");
            return (Criteria) this;
        }

        public Criteria andChangeReasonTypeGreaterThan(String value) {
            addCriterion("change_reason_type >", value, "changeReasonType");
            return (Criteria) this;
        }

        public Criteria andChangeReasonTypeGreaterThanOrEqualTo(String value) {
            addCriterion("change_reason_type >=", value, "changeReasonType");
            return (Criteria) this;
        }

        public Criteria andChangeReasonTypeLessThan(String value) {
            addCriterion("change_reason_type <", value, "changeReasonType");
            return (Criteria) this;
        }

        public Criteria andChangeReasonTypeLessThanOrEqualTo(String value) {
            addCriterion("change_reason_type <=", value, "changeReasonType");
            return (Criteria) this;
        }

        public Criteria andChangeReasonTypeLike(String value) {
            addCriterion("change_reason_type like", value, "changeReasonType");
            return (Criteria) this;
        }

        public Criteria andChangeReasonTypeNotLike(String value) {
            addCriterion("change_reason_type not like", value, "changeReasonType");
            return (Criteria) this;
        }

        public Criteria andChangeReasonTypeIn(List<String> values) {
            addCriterion("change_reason_type in", values, "changeReasonType");
            return (Criteria) this;
        }

        public Criteria andChangeReasonTypeNotIn(List<String> values) {
            addCriterion("change_reason_type not in", values, "changeReasonType");
            return (Criteria) this;
        }

        public Criteria andChangeReasonTypeBetween(String value1, String value2) {
            addCriterion("change_reason_type between", value1, value2, "changeReasonType");
            return (Criteria) this;
        }

        public Criteria andChangeReasonTypeNotBetween(String value1, String value2) {
            addCriterion("change_reason_type not between", value1, value2, "changeReasonType");
            return (Criteria) this;
        }

        public Criteria andChangePriceTypeIsNull() {
            addCriterion("change_price_type is null");
            return (Criteria) this;
        }

        public Criteria andChangePriceTypeIsNotNull() {
            addCriterion("change_price_type is not null");
            return (Criteria) this;
        }

        public Criteria andChangePriceTypeEqualTo(String value) {
            addCriterion("change_price_type =", value, "changePriceType");
            return (Criteria) this;
        }

        public Criteria andChangePriceTypeNotEqualTo(String value) {
            addCriterion("change_price_type <>", value, "changePriceType");
            return (Criteria) this;
        }

        public Criteria andChangePriceTypeGreaterThan(String value) {
            addCriterion("change_price_type >", value, "changePriceType");
            return (Criteria) this;
        }

        public Criteria andChangePriceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("change_price_type >=", value, "changePriceType");
            return (Criteria) this;
        }

        public Criteria andChangePriceTypeLessThan(String value) {
            addCriterion("change_price_type <", value, "changePriceType");
            return (Criteria) this;
        }

        public Criteria andChangePriceTypeLessThanOrEqualTo(String value) {
            addCriterion("change_price_type <=", value, "changePriceType");
            return (Criteria) this;
        }

        public Criteria andChangePriceTypeLike(String value) {
            addCriterion("change_price_type like", value, "changePriceType");
            return (Criteria) this;
        }

        public Criteria andChangePriceTypeNotLike(String value) {
            addCriterion("change_price_type not like", value, "changePriceType");
            return (Criteria) this;
        }

        public Criteria andChangePriceTypeIn(List<String> values) {
            addCriterion("change_price_type in", values, "changePriceType");
            return (Criteria) this;
        }

        public Criteria andChangePriceTypeNotIn(List<String> values) {
            addCriterion("change_price_type not in", values, "changePriceType");
            return (Criteria) this;
        }

        public Criteria andChangePriceTypeBetween(String value1, String value2) {
            addCriterion("change_price_type between", value1, value2, "changePriceType");
            return (Criteria) this;
        }

        public Criteria andChangePriceTypeNotBetween(String value1, String value2) {
            addCriterion("change_price_type not between", value1, value2, "changePriceType");
            return (Criteria) this;
        }

        public Criteria andChangeContentIsNull() {
            addCriterion("change_content is null");
            return (Criteria) this;
        }

        public Criteria andChangeContentIsNotNull() {
            addCriterion("change_content is not null");
            return (Criteria) this;
        }

        public Criteria andChangeContentEqualTo(String value) {
            addCriterion("change_content =", value, "changeContent");
            return (Criteria) this;
        }

        public Criteria andChangeContentNotEqualTo(String value) {
            addCriterion("change_content <>", value, "changeContent");
            return (Criteria) this;
        }

        public Criteria andChangeContentGreaterThan(String value) {
            addCriterion("change_content >", value, "changeContent");
            return (Criteria) this;
        }

        public Criteria andChangeContentGreaterThanOrEqualTo(String value) {
            addCriterion("change_content >=", value, "changeContent");
            return (Criteria) this;
        }

        public Criteria andChangeContentLessThan(String value) {
            addCriterion("change_content <", value, "changeContent");
            return (Criteria) this;
        }

        public Criteria andChangeContentLessThanOrEqualTo(String value) {
            addCriterion("change_content <=", value, "changeContent");
            return (Criteria) this;
        }

        public Criteria andChangeContentLike(String value) {
            addCriterion("change_content like", value, "changeContent");
            return (Criteria) this;
        }

        public Criteria andChangeContentNotLike(String value) {
            addCriterion("change_content not like", value, "changeContent");
            return (Criteria) this;
        }

        public Criteria andChangeContentIn(List<String> values) {
            addCriterion("change_content in", values, "changeContent");
            return (Criteria) this;
        }

        public Criteria andChangeContentNotIn(List<String> values) {
            addCriterion("change_content not in", values, "changeContent");
            return (Criteria) this;
        }

        public Criteria andChangeContentBetween(String value1, String value2) {
            addCriterion("change_content between", value1, value2, "changeContent");
            return (Criteria) this;
        }

        public Criteria andChangeContentNotBetween(String value1, String value2) {
            addCriterion("change_content not between", value1, value2, "changeContent");
            return (Criteria) this;
        }

        public Criteria andExIsNull() {
            addCriterion("ex is null");
            return (Criteria) this;
        }

        public Criteria andExIsNotNull() {
            addCriterion("ex is not null");
            return (Criteria) this;
        }

        public Criteria andExEqualTo(String value) {
            addCriterion("ex =", value, "ex");
            return (Criteria) this;
        }

        public Criteria andExNotEqualTo(String value) {
            addCriterion("ex <>", value, "ex");
            return (Criteria) this;
        }

        public Criteria andExGreaterThan(String value) {
            addCriterion("ex >", value, "ex");
            return (Criteria) this;
        }

        public Criteria andExGreaterThanOrEqualTo(String value) {
            addCriterion("ex >=", value, "ex");
            return (Criteria) this;
        }

        public Criteria andExLessThan(String value) {
            addCriterion("ex <", value, "ex");
            return (Criteria) this;
        }

        public Criteria andExLessThanOrEqualTo(String value) {
            addCriterion("ex <=", value, "ex");
            return (Criteria) this;
        }

        public Criteria andExLike(String value) {
            addCriterion("ex like", value, "ex");
            return (Criteria) this;
        }

        public Criteria andExNotLike(String value) {
            addCriterion("ex not like", value, "ex");
            return (Criteria) this;
        }

        public Criteria andExIn(List<String> values) {
            addCriterion("ex in", values, "ex");
            return (Criteria) this;
        }

        public Criteria andExNotIn(List<String> values) {
            addCriterion("ex not in", values, "ex");
            return (Criteria) this;
        }

        public Criteria andExBetween(String value1, String value2) {
            addCriterion("ex between", value1, value2, "ex");
            return (Criteria) this;
        }

        public Criteria andExNotBetween(String value1, String value2) {
            addCriterion("ex not between", value1, value2, "ex");
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