package com.pcitc.base.engin.construct.subcontract;

import java.util.ArrayList;
import java.util.List;

public class ConstructSubcontractRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public ConstructSubcontractRecordExample() {
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

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
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

        public Criteria andMainConstructNameIsNull() {
            addCriterion("main_construct_name is null");
            return (Criteria) this;
        }

        public Criteria andMainConstructNameIsNotNull() {
            addCriterion("main_construct_name is not null");
            return (Criteria) this;
        }

        public Criteria andMainConstructNameEqualTo(String value) {
            addCriterion("main_construct_name =", value, "mainConstructName");
            return (Criteria) this;
        }

        public Criteria andMainConstructNameNotEqualTo(String value) {
            addCriterion("main_construct_name <>", value, "mainConstructName");
            return (Criteria) this;
        }

        public Criteria andMainConstructNameGreaterThan(String value) {
            addCriterion("main_construct_name >", value, "mainConstructName");
            return (Criteria) this;
        }

        public Criteria andMainConstructNameGreaterThanOrEqualTo(String value) {
            addCriterion("main_construct_name >=", value, "mainConstructName");
            return (Criteria) this;
        }

        public Criteria andMainConstructNameLessThan(String value) {
            addCriterion("main_construct_name <", value, "mainConstructName");
            return (Criteria) this;
        }

        public Criteria andMainConstructNameLessThanOrEqualTo(String value) {
            addCriterion("main_construct_name <=", value, "mainConstructName");
            return (Criteria) this;
        }

        public Criteria andMainConstructNameLike(String value) {
            addCriterion("main_construct_name like", value, "mainConstructName");
            return (Criteria) this;
        }

        public Criteria andMainConstructNameNotLike(String value) {
            addCriterion("main_construct_name not like", value, "mainConstructName");
            return (Criteria) this;
        }

        public Criteria andMainConstructNameIn(List<String> values) {
            addCriterion("main_construct_name in", values, "mainConstructName");
            return (Criteria) this;
        }

        public Criteria andMainConstructNameNotIn(List<String> values) {
            addCriterion("main_construct_name not in", values, "mainConstructName");
            return (Criteria) this;
        }

        public Criteria andMainConstructNameBetween(String value1, String value2) {
            addCriterion("main_construct_name between", value1, value2, "mainConstructName");
            return (Criteria) this;
        }

        public Criteria andMainConstructNameNotBetween(String value1, String value2) {
            addCriterion("main_construct_name not between", value1, value2, "mainConstructName");
            return (Criteria) this;
        }

        public Criteria andMainConstructCodeIsNull() {
            addCriterion("main_construct_code is null");
            return (Criteria) this;
        }

        public Criteria andMainConstructCodeIsNotNull() {
            addCriterion("main_construct_code is not null");
            return (Criteria) this;
        }

        public Criteria andMainConstructCodeEqualTo(String value) {
            addCriterion("main_construct_code =", value, "mainConstructCode");
            return (Criteria) this;
        }

        public Criteria andMainConstructCodeNotEqualTo(String value) {
            addCriterion("main_construct_code <>", value, "mainConstructCode");
            return (Criteria) this;
        }

        public Criteria andMainConstructCodeGreaterThan(String value) {
            addCriterion("main_construct_code >", value, "mainConstructCode");
            return (Criteria) this;
        }

        public Criteria andMainConstructCodeGreaterThanOrEqualTo(String value) {
            addCriterion("main_construct_code >=", value, "mainConstructCode");
            return (Criteria) this;
        }

        public Criteria andMainConstructCodeLessThan(String value) {
            addCriterion("main_construct_code <", value, "mainConstructCode");
            return (Criteria) this;
        }

        public Criteria andMainConstructCodeLessThanOrEqualTo(String value) {
            addCriterion("main_construct_code <=", value, "mainConstructCode");
            return (Criteria) this;
        }

        public Criteria andMainConstructCodeLike(String value) {
            addCriterion("main_construct_code like", value, "mainConstructCode");
            return (Criteria) this;
        }

        public Criteria andMainConstructCodeNotLike(String value) {
            addCriterion("main_construct_code not like", value, "mainConstructCode");
            return (Criteria) this;
        }

        public Criteria andMainConstructCodeIn(List<String> values) {
            addCriterion("main_construct_code in", values, "mainConstructCode");
            return (Criteria) this;
        }

        public Criteria andMainConstructCodeNotIn(List<String> values) {
            addCriterion("main_construct_code not in", values, "mainConstructCode");
            return (Criteria) this;
        }

        public Criteria andMainConstructCodeBetween(String value1, String value2) {
            addCriterion("main_construct_code between", value1, value2, "mainConstructCode");
            return (Criteria) this;
        }

        public Criteria andMainConstructCodeNotBetween(String value1, String value2) {
            addCriterion("main_construct_code not between", value1, value2, "mainConstructCode");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNull() {
            addCriterion("start_date is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("start_date is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(String value) {
            addCriterion("start_date =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(String value) {
            addCriterion("start_date <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(String value) {
            addCriterion("start_date >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(String value) {
            addCriterion("start_date >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(String value) {
            addCriterion("start_date <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(String value) {
            addCriterion("start_date <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLike(String value) {
            addCriterion("start_date like", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotLike(String value) {
            addCriterion("start_date not like", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<String> values) {
            addCriterion("start_date in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<String> values) {
            addCriterion("start_date not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(String value1, String value2) {
            addCriterion("start_date between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(String value1, String value2) {
            addCriterion("start_date not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(String value) {
            addCriterion("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(String value) {
            addCriterion("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(String value) {
            addCriterion("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(String value) {
            addCriterion("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(String value) {
            addCriterion("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(String value) {
            addCriterion("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLike(String value) {
            addCriterion("end_date like", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotLike(String value) {
            addCriterion("end_date not like", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<String> values) {
            addCriterion("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<String> values) {
            addCriterion("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(String value1, String value2) {
            addCriterion("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(String value1, String value2) {
            addCriterion("end_date not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andContructPersonIsNull() {
            addCriterion("contruct_person is null");
            return (Criteria) this;
        }

        public Criteria andContructPersonIsNotNull() {
            addCriterion("contruct_person is not null");
            return (Criteria) this;
        }

        public Criteria andContructPersonEqualTo(String value) {
            addCriterion("contruct_person =", value, "contructPerson");
            return (Criteria) this;
        }

        public Criteria andContructPersonNotEqualTo(String value) {
            addCriterion("contruct_person <>", value, "contructPerson");
            return (Criteria) this;
        }

        public Criteria andContructPersonGreaterThan(String value) {
            addCriterion("contruct_person >", value, "contructPerson");
            return (Criteria) this;
        }

        public Criteria andContructPersonGreaterThanOrEqualTo(String value) {
            addCriterion("contruct_person >=", value, "contructPerson");
            return (Criteria) this;
        }

        public Criteria andContructPersonLessThan(String value) {
            addCriterion("contruct_person <", value, "contructPerson");
            return (Criteria) this;
        }

        public Criteria andContructPersonLessThanOrEqualTo(String value) {
            addCriterion("contruct_person <=", value, "contructPerson");
            return (Criteria) this;
        }

        public Criteria andContructPersonLike(String value) {
            addCriterion("contruct_person like", value, "contructPerson");
            return (Criteria) this;
        }

        public Criteria andContructPersonNotLike(String value) {
            addCriterion("contruct_person not like", value, "contructPerson");
            return (Criteria) this;
        }

        public Criteria andContructPersonIn(List<String> values) {
            addCriterion("contruct_person in", values, "contructPerson");
            return (Criteria) this;
        }

        public Criteria andContructPersonNotIn(List<String> values) {
            addCriterion("contruct_person not in", values, "contructPerson");
            return (Criteria) this;
        }

        public Criteria andContructPersonBetween(String value1, String value2) {
            addCriterion("contruct_person between", value1, value2, "contructPerson");
            return (Criteria) this;
        }

        public Criteria andContructPersonNotBetween(String value1, String value2) {
            addCriterion("contruct_person not between", value1, value2, "contructPerson");
            return (Criteria) this;
        }

        public Criteria andTimeLimitMainIsNull() {
            addCriterion("time_limit_main is null");
            return (Criteria) this;
        }

        public Criteria andTimeLimitMainIsNotNull() {
            addCriterion("time_limit_main is not null");
            return (Criteria) this;
        }

        public Criteria andTimeLimitMainEqualTo(String value) {
            addCriterion("time_limit_main =", value, "timeLimitMain");
            return (Criteria) this;
        }

        public Criteria andTimeLimitMainNotEqualTo(String value) {
            addCriterion("time_limit_main <>", value, "timeLimitMain");
            return (Criteria) this;
        }

        public Criteria andTimeLimitMainGreaterThan(String value) {
            addCriterion("time_limit_main >", value, "timeLimitMain");
            return (Criteria) this;
        }

        public Criteria andTimeLimitMainGreaterThanOrEqualTo(String value) {
            addCriterion("time_limit_main >=", value, "timeLimitMain");
            return (Criteria) this;
        }

        public Criteria andTimeLimitMainLessThan(String value) {
            addCriterion("time_limit_main <", value, "timeLimitMain");
            return (Criteria) this;
        }

        public Criteria andTimeLimitMainLessThanOrEqualTo(String value) {
            addCriterion("time_limit_main <=", value, "timeLimitMain");
            return (Criteria) this;
        }

        public Criteria andTimeLimitMainLike(String value) {
            addCriterion("time_limit_main like", value, "timeLimitMain");
            return (Criteria) this;
        }

        public Criteria andTimeLimitMainNotLike(String value) {
            addCriterion("time_limit_main not like", value, "timeLimitMain");
            return (Criteria) this;
        }

        public Criteria andTimeLimitMainIn(List<String> values) {
            addCriterion("time_limit_main in", values, "timeLimitMain");
            return (Criteria) this;
        }

        public Criteria andTimeLimitMainNotIn(List<String> values) {
            addCriterion("time_limit_main not in", values, "timeLimitMain");
            return (Criteria) this;
        }

        public Criteria andTimeLimitMainBetween(String value1, String value2) {
            addCriterion("time_limit_main between", value1, value2, "timeLimitMain");
            return (Criteria) this;
        }

        public Criteria andTimeLimitMainNotBetween(String value1, String value2) {
            addCriterion("time_limit_main not between", value1, value2, "timeLimitMain");
            return (Criteria) this;
        }

        public Criteria andMainAmountIsNull() {
            addCriterion("main_amount is null");
            return (Criteria) this;
        }

        public Criteria andMainAmountIsNotNull() {
            addCriterion("main_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMainAmountEqualTo(Long value) {
            addCriterion("main_amount =", value, "mainAmount");
            return (Criteria) this;
        }

        public Criteria andMainAmountNotEqualTo(Long value) {
            addCriterion("main_amount <>", value, "mainAmount");
            return (Criteria) this;
        }

        public Criteria andMainAmountGreaterThan(Long value) {
            addCriterion("main_amount >", value, "mainAmount");
            return (Criteria) this;
        }

        public Criteria andMainAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("main_amount >=", value, "mainAmount");
            return (Criteria) this;
        }

        public Criteria andMainAmountLessThan(Long value) {
            addCriterion("main_amount <", value, "mainAmount");
            return (Criteria) this;
        }

        public Criteria andMainAmountLessThanOrEqualTo(Long value) {
            addCriterion("main_amount <=", value, "mainAmount");
            return (Criteria) this;
        }

        public Criteria andMainAmountIn(List<Long> values) {
            addCriterion("main_amount in", values, "mainAmount");
            return (Criteria) this;
        }

        public Criteria andMainAmountNotIn(List<Long> values) {
            addCriterion("main_amount not in", values, "mainAmount");
            return (Criteria) this;
        }

        public Criteria andMainAmountBetween(Long value1, Long value2) {
            addCriterion("main_amount between", value1, value2, "mainAmount");
            return (Criteria) this;
        }

        public Criteria andMainAmountNotBetween(Long value1, Long value2) {
            addCriterion("main_amount not between", value1, value2, "mainAmount");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIsNull() {
            addCriterion("contact_phone is null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIsNotNull() {
            addCriterion("contact_phone is not null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneEqualTo(String value) {
            addCriterion("contact_phone =", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotEqualTo(String value) {
            addCriterion("contact_phone <>", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneGreaterThan(String value) {
            addCriterion("contact_phone >", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("contact_phone >=", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLessThan(String value) {
            addCriterion("contact_phone <", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLessThanOrEqualTo(String value) {
            addCriterion("contact_phone <=", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLike(String value) {
            addCriterion("contact_phone like", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotLike(String value) {
            addCriterion("contact_phone not like", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIn(List<String> values) {
            addCriterion("contact_phone in", values, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotIn(List<String> values) {
            addCriterion("contact_phone not in", values, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneBetween(String value1, String value2) {
            addCriterion("contact_phone between", value1, value2, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotBetween(String value1, String value2) {
            addCriterion("contact_phone not between", value1, value2, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactNameIsNull() {
            addCriterion("contact_name is null");
            return (Criteria) this;
        }

        public Criteria andContactNameIsNotNull() {
            addCriterion("contact_name is not null");
            return (Criteria) this;
        }

        public Criteria andContactNameEqualTo(String value) {
            addCriterion("contact_name =", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotEqualTo(String value) {
            addCriterion("contact_name <>", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameGreaterThan(String value) {
            addCriterion("contact_name >", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameGreaterThanOrEqualTo(String value) {
            addCriterion("contact_name >=", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLessThan(String value) {
            addCriterion("contact_name <", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLessThanOrEqualTo(String value) {
            addCriterion("contact_name <=", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLike(String value) {
            addCriterion("contact_name like", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotLike(String value) {
            addCriterion("contact_name not like", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameIn(List<String> values) {
            addCriterion("contact_name in", values, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotIn(List<String> values) {
            addCriterion("contact_name not in", values, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameBetween(String value1, String value2) {
            addCriterion("contact_name between", value1, value2, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotBetween(String value1, String value2) {
            addCriterion("contact_name not between", value1, value2, "contactName");
            return (Criteria) this;
        }

        public Criteria andBuildUnitIsNull() {
            addCriterion("build_unit is null");
            return (Criteria) this;
        }

        public Criteria andBuildUnitIsNotNull() {
            addCriterion("build_unit is not null");
            return (Criteria) this;
        }

        public Criteria andBuildUnitEqualTo(String value) {
            addCriterion("build_unit =", value, "buildUnit");
            return (Criteria) this;
        }

        public Criteria andBuildUnitNotEqualTo(String value) {
            addCriterion("build_unit <>", value, "buildUnit");
            return (Criteria) this;
        }

        public Criteria andBuildUnitGreaterThan(String value) {
            addCriterion("build_unit >", value, "buildUnit");
            return (Criteria) this;
        }

        public Criteria andBuildUnitGreaterThanOrEqualTo(String value) {
            addCriterion("build_unit >=", value, "buildUnit");
            return (Criteria) this;
        }

        public Criteria andBuildUnitLessThan(String value) {
            addCriterion("build_unit <", value, "buildUnit");
            return (Criteria) this;
        }

        public Criteria andBuildUnitLessThanOrEqualTo(String value) {
            addCriterion("build_unit <=", value, "buildUnit");
            return (Criteria) this;
        }

        public Criteria andBuildUnitLike(String value) {
            addCriterion("build_unit like", value, "buildUnit");
            return (Criteria) this;
        }

        public Criteria andBuildUnitNotLike(String value) {
            addCriterion("build_unit not like", value, "buildUnit");
            return (Criteria) this;
        }

        public Criteria andBuildUnitIn(List<String> values) {
            addCriterion("build_unit in", values, "buildUnit");
            return (Criteria) this;
        }

        public Criteria andBuildUnitNotIn(List<String> values) {
            addCriterion("build_unit not in", values, "buildUnit");
            return (Criteria) this;
        }

        public Criteria andBuildUnitBetween(String value1, String value2) {
            addCriterion("build_unit between", value1, value2, "buildUnit");
            return (Criteria) this;
        }

        public Criteria andBuildUnitNotBetween(String value1, String value2) {
            addCriterion("build_unit not between", value1, value2, "buildUnit");
            return (Criteria) this;
        }

        public Criteria andContractorCodeIsNull() {
            addCriterion("contractor_code is null");
            return (Criteria) this;
        }

        public Criteria andContractorCodeIsNotNull() {
            addCriterion("contractor_code is not null");
            return (Criteria) this;
        }

        public Criteria andContractorCodeEqualTo(String value) {
            addCriterion("contractor_code =", value, "contractorCode");
            return (Criteria) this;
        }

        public Criteria andContractorCodeNotEqualTo(String value) {
            addCriterion("contractor_code <>", value, "contractorCode");
            return (Criteria) this;
        }

        public Criteria andContractorCodeGreaterThan(String value) {
            addCriterion("contractor_code >", value, "contractorCode");
            return (Criteria) this;
        }

        public Criteria andContractorCodeGreaterThanOrEqualTo(String value) {
            addCriterion("contractor_code >=", value, "contractorCode");
            return (Criteria) this;
        }

        public Criteria andContractorCodeLessThan(String value) {
            addCriterion("contractor_code <", value, "contractorCode");
            return (Criteria) this;
        }

        public Criteria andContractorCodeLessThanOrEqualTo(String value) {
            addCriterion("contractor_code <=", value, "contractorCode");
            return (Criteria) this;
        }

        public Criteria andContractorCodeLike(String value) {
            addCriterion("contractor_code like", value, "contractorCode");
            return (Criteria) this;
        }

        public Criteria andContractorCodeNotLike(String value) {
            addCriterion("contractor_code not like", value, "contractorCode");
            return (Criteria) this;
        }

        public Criteria andContractorCodeIn(List<String> values) {
            addCriterion("contractor_code in", values, "contractorCode");
            return (Criteria) this;
        }

        public Criteria andContractorCodeNotIn(List<String> values) {
            addCriterion("contractor_code not in", values, "contractorCode");
            return (Criteria) this;
        }

        public Criteria andContractorCodeBetween(String value1, String value2) {
            addCriterion("contractor_code between", value1, value2, "contractorCode");
            return (Criteria) this;
        }

        public Criteria andContractorCodeNotBetween(String value1, String value2) {
            addCriterion("contractor_code not between", value1, value2, "contractorCode");
            return (Criteria) this;
        }

        public Criteria andContractorIsNull() {
            addCriterion("contractor is null");
            return (Criteria) this;
        }

        public Criteria andContractorIsNotNull() {
            addCriterion("contractor is not null");
            return (Criteria) this;
        }

        public Criteria andContractorEqualTo(String value) {
            addCriterion("contractor =", value, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorNotEqualTo(String value) {
            addCriterion("contractor <>", value, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorGreaterThan(String value) {
            addCriterion("contractor >", value, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorGreaterThanOrEqualTo(String value) {
            addCriterion("contractor >=", value, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorLessThan(String value) {
            addCriterion("contractor <", value, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorLessThanOrEqualTo(String value) {
            addCriterion("contractor <=", value, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorLike(String value) {
            addCriterion("contractor like", value, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorNotLike(String value) {
            addCriterion("contractor not like", value, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorIn(List<String> values) {
            addCriterion("contractor in", values, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorNotIn(List<String> values) {
            addCriterion("contractor not in", values, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorBetween(String value1, String value2) {
            addCriterion("contractor between", value1, value2, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorNotBetween(String value1, String value2) {
            addCriterion("contractor not between", value1, value2, "contractor");
            return (Criteria) this;
        }

        public Criteria andSubContructNameIsNull() {
            addCriterion("sub_contruct_name is null");
            return (Criteria) this;
        }

        public Criteria andSubContructNameIsNotNull() {
            addCriterion("sub_contruct_name is not null");
            return (Criteria) this;
        }

        public Criteria andSubContructNameEqualTo(String value) {
            addCriterion("sub_contruct_name =", value, "subContructName");
            return (Criteria) this;
        }

        public Criteria andSubContructNameNotEqualTo(String value) {
            addCriterion("sub_contruct_name <>", value, "subContructName");
            return (Criteria) this;
        }

        public Criteria andSubContructNameGreaterThan(String value) {
            addCriterion("sub_contruct_name >", value, "subContructName");
            return (Criteria) this;
        }

        public Criteria andSubContructNameGreaterThanOrEqualTo(String value) {
            addCriterion("sub_contruct_name >=", value, "subContructName");
            return (Criteria) this;
        }

        public Criteria andSubContructNameLessThan(String value) {
            addCriterion("sub_contruct_name <", value, "subContructName");
            return (Criteria) this;
        }

        public Criteria andSubContructNameLessThanOrEqualTo(String value) {
            addCriterion("sub_contruct_name <=", value, "subContructName");
            return (Criteria) this;
        }

        public Criteria andSubContructNameLike(String value) {
            addCriterion("sub_contruct_name like", value, "subContructName");
            return (Criteria) this;
        }

        public Criteria andSubContructNameNotLike(String value) {
            addCriterion("sub_contruct_name not like", value, "subContructName");
            return (Criteria) this;
        }

        public Criteria andSubContructNameIn(List<String> values) {
            addCriterion("sub_contruct_name in", values, "subContructName");
            return (Criteria) this;
        }

        public Criteria andSubContructNameNotIn(List<String> values) {
            addCriterion("sub_contruct_name not in", values, "subContructName");
            return (Criteria) this;
        }

        public Criteria andSubContructNameBetween(String value1, String value2) {
            addCriterion("sub_contruct_name between", value1, value2, "subContructName");
            return (Criteria) this;
        }

        public Criteria andSubContructNameNotBetween(String value1, String value2) {
            addCriterion("sub_contruct_name not between", value1, value2, "subContructName");
            return (Criteria) this;
        }

        public Criteria andSubContructCodeIsNull() {
            addCriterion("sub_contruct_code is null");
            return (Criteria) this;
        }

        public Criteria andSubContructCodeIsNotNull() {
            addCriterion("sub_contruct_code is not null");
            return (Criteria) this;
        }

        public Criteria andSubContructCodeEqualTo(String value) {
            addCriterion("sub_contruct_code =", value, "subContructCode");
            return (Criteria) this;
        }

        public Criteria andSubContructCodeNotEqualTo(String value) {
            addCriterion("sub_contruct_code <>", value, "subContructCode");
            return (Criteria) this;
        }

        public Criteria andSubContructCodeGreaterThan(String value) {
            addCriterion("sub_contruct_code >", value, "subContructCode");
            return (Criteria) this;
        }

        public Criteria andSubContructCodeGreaterThanOrEqualTo(String value) {
            addCriterion("sub_contruct_code >=", value, "subContructCode");
            return (Criteria) this;
        }

        public Criteria andSubContructCodeLessThan(String value) {
            addCriterion("sub_contruct_code <", value, "subContructCode");
            return (Criteria) this;
        }

        public Criteria andSubContructCodeLessThanOrEqualTo(String value) {
            addCriterion("sub_contruct_code <=", value, "subContructCode");
            return (Criteria) this;
        }

        public Criteria andSubContructCodeLike(String value) {
            addCriterion("sub_contruct_code like", value, "subContructCode");
            return (Criteria) this;
        }

        public Criteria andSubContructCodeNotLike(String value) {
            addCriterion("sub_contruct_code not like", value, "subContructCode");
            return (Criteria) this;
        }

        public Criteria andSubContructCodeIn(List<String> values) {
            addCriterion("sub_contruct_code in", values, "subContructCode");
            return (Criteria) this;
        }

        public Criteria andSubContructCodeNotIn(List<String> values) {
            addCriterion("sub_contruct_code not in", values, "subContructCode");
            return (Criteria) this;
        }

        public Criteria andSubContructCodeBetween(String value1, String value2) {
            addCriterion("sub_contruct_code between", value1, value2, "subContructCode");
            return (Criteria) this;
        }

        public Criteria andSubContructCodeNotBetween(String value1, String value2) {
            addCriterion("sub_contruct_code not between", value1, value2, "subContructCode");
            return (Criteria) this;
        }

        public Criteria andSubJobNatureIsNull() {
            addCriterion("sub_job_nature is null");
            return (Criteria) this;
        }

        public Criteria andSubJobNatureIsNotNull() {
            addCriterion("sub_job_nature is not null");
            return (Criteria) this;
        }

        public Criteria andSubJobNatureEqualTo(String value) {
            addCriterion("sub_job_nature =", value, "subJobNature");
            return (Criteria) this;
        }

        public Criteria andSubJobNatureNotEqualTo(String value) {
            addCriterion("sub_job_nature <>", value, "subJobNature");
            return (Criteria) this;
        }

        public Criteria andSubJobNatureGreaterThan(String value) {
            addCriterion("sub_job_nature >", value, "subJobNature");
            return (Criteria) this;
        }

        public Criteria andSubJobNatureGreaterThanOrEqualTo(String value) {
            addCriterion("sub_job_nature >=", value, "subJobNature");
            return (Criteria) this;
        }

        public Criteria andSubJobNatureLessThan(String value) {
            addCriterion("sub_job_nature <", value, "subJobNature");
            return (Criteria) this;
        }

        public Criteria andSubJobNatureLessThanOrEqualTo(String value) {
            addCriterion("sub_job_nature <=", value, "subJobNature");
            return (Criteria) this;
        }

        public Criteria andSubJobNatureLike(String value) {
            addCriterion("sub_job_nature like", value, "subJobNature");
            return (Criteria) this;
        }

        public Criteria andSubJobNatureNotLike(String value) {
            addCriterion("sub_job_nature not like", value, "subJobNature");
            return (Criteria) this;
        }

        public Criteria andSubJobNatureIn(List<String> values) {
            addCriterion("sub_job_nature in", values, "subJobNature");
            return (Criteria) this;
        }

        public Criteria andSubJobNatureNotIn(List<String> values) {
            addCriterion("sub_job_nature not in", values, "subJobNature");
            return (Criteria) this;
        }

        public Criteria andSubJobNatureBetween(String value1, String value2) {
            addCriterion("sub_job_nature between", value1, value2, "subJobNature");
            return (Criteria) this;
        }

        public Criteria andSubJobNatureNotBetween(String value1, String value2) {
            addCriterion("sub_job_nature not between", value1, value2, "subJobNature");
            return (Criteria) this;
        }

        public Criteria andSubContructPersonIsNull() {
            addCriterion("sub_contruct_person is null");
            return (Criteria) this;
        }

        public Criteria andSubContructPersonIsNotNull() {
            addCriterion("sub_contruct_person is not null");
            return (Criteria) this;
        }

        public Criteria andSubContructPersonEqualTo(String value) {
            addCriterion("sub_contruct_person =", value, "subContructPerson");
            return (Criteria) this;
        }

        public Criteria andSubContructPersonNotEqualTo(String value) {
            addCriterion("sub_contruct_person <>", value, "subContructPerson");
            return (Criteria) this;
        }

        public Criteria andSubContructPersonGreaterThan(String value) {
            addCriterion("sub_contruct_person >", value, "subContructPerson");
            return (Criteria) this;
        }

        public Criteria andSubContructPersonGreaterThanOrEqualTo(String value) {
            addCriterion("sub_contruct_person >=", value, "subContructPerson");
            return (Criteria) this;
        }

        public Criteria andSubContructPersonLessThan(String value) {
            addCriterion("sub_contruct_person <", value, "subContructPerson");
            return (Criteria) this;
        }

        public Criteria andSubContructPersonLessThanOrEqualTo(String value) {
            addCriterion("sub_contruct_person <=", value, "subContructPerson");
            return (Criteria) this;
        }

        public Criteria andSubContructPersonLike(String value) {
            addCriterion("sub_contruct_person like", value, "subContructPerson");
            return (Criteria) this;
        }

        public Criteria andSubContructPersonNotLike(String value) {
            addCriterion("sub_contruct_person not like", value, "subContructPerson");
            return (Criteria) this;
        }

        public Criteria andSubContructPersonIn(List<String> values) {
            addCriterion("sub_contruct_person in", values, "subContructPerson");
            return (Criteria) this;
        }

        public Criteria andSubContructPersonNotIn(List<String> values) {
            addCriterion("sub_contruct_person not in", values, "subContructPerson");
            return (Criteria) this;
        }

        public Criteria andSubContructPersonBetween(String value1, String value2) {
            addCriterion("sub_contruct_person between", value1, value2, "subContructPerson");
            return (Criteria) this;
        }

        public Criteria andSubContructPersonNotBetween(String value1, String value2) {
            addCriterion("sub_contruct_person not between", value1, value2, "subContructPerson");
            return (Criteria) this;
        }

        public Criteria andSubContructAmountIsNull() {
            addCriterion("sub_contruct_amount is null");
            return (Criteria) this;
        }

        public Criteria andSubContructAmountIsNotNull() {
            addCriterion("sub_contruct_amount is not null");
            return (Criteria) this;
        }

        public Criteria andSubContructAmountEqualTo(Long value) {
            addCriterion("sub_contruct_amount =", value, "subContructAmount");
            return (Criteria) this;
        }

        public Criteria andSubContructAmountNotEqualTo(Long value) {
            addCriterion("sub_contruct_amount <>", value, "subContructAmount");
            return (Criteria) this;
        }

        public Criteria andSubContructAmountGreaterThan(Long value) {
            addCriterion("sub_contruct_amount >", value, "subContructAmount");
            return (Criteria) this;
        }

        public Criteria andSubContructAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("sub_contruct_amount >=", value, "subContructAmount");
            return (Criteria) this;
        }

        public Criteria andSubContructAmountLessThan(Long value) {
            addCriterion("sub_contruct_amount <", value, "subContructAmount");
            return (Criteria) this;
        }

        public Criteria andSubContructAmountLessThanOrEqualTo(Long value) {
            addCriterion("sub_contruct_amount <=", value, "subContructAmount");
            return (Criteria) this;
        }

        public Criteria andSubContructAmountIn(List<Long> values) {
            addCriterion("sub_contruct_amount in", values, "subContructAmount");
            return (Criteria) this;
        }

        public Criteria andSubContructAmountNotIn(List<Long> values) {
            addCriterion("sub_contruct_amount not in", values, "subContructAmount");
            return (Criteria) this;
        }

        public Criteria andSubContructAmountBetween(Long value1, Long value2) {
            addCriterion("sub_contruct_amount between", value1, value2, "subContructAmount");
            return (Criteria) this;
        }

        public Criteria andSubContructAmountNotBetween(Long value1, Long value2) {
            addCriterion("sub_contruct_amount not between", value1, value2, "subContructAmount");
            return (Criteria) this;
        }

        public Criteria andSubContructTypeIsNull() {
            addCriterion("sub_contruct_type is null");
            return (Criteria) this;
        }

        public Criteria andSubContructTypeIsNotNull() {
            addCriterion("sub_contruct_type is not null");
            return (Criteria) this;
        }

        public Criteria andSubContructTypeEqualTo(String value) {
            addCriterion("sub_contruct_type =", value, "subContructType");
            return (Criteria) this;
        }

        public Criteria andSubContructTypeNotEqualTo(String value) {
            addCriterion("sub_contruct_type <>", value, "subContructType");
            return (Criteria) this;
        }

        public Criteria andSubContructTypeGreaterThan(String value) {
            addCriterion("sub_contruct_type >", value, "subContructType");
            return (Criteria) this;
        }

        public Criteria andSubContructTypeGreaterThanOrEqualTo(String value) {
            addCriterion("sub_contruct_type >=", value, "subContructType");
            return (Criteria) this;
        }

        public Criteria andSubContructTypeLessThan(String value) {
            addCriterion("sub_contruct_type <", value, "subContructType");
            return (Criteria) this;
        }

        public Criteria andSubContructTypeLessThanOrEqualTo(String value) {
            addCriterion("sub_contruct_type <=", value, "subContructType");
            return (Criteria) this;
        }

        public Criteria andSubContructTypeLike(String value) {
            addCriterion("sub_contruct_type like", value, "subContructType");
            return (Criteria) this;
        }

        public Criteria andSubContructTypeNotLike(String value) {
            addCriterion("sub_contruct_type not like", value, "subContructType");
            return (Criteria) this;
        }

        public Criteria andSubContructTypeIn(List<String> values) {
            addCriterion("sub_contruct_type in", values, "subContructType");
            return (Criteria) this;
        }

        public Criteria andSubContructTypeNotIn(List<String> values) {
            addCriterion("sub_contruct_type not in", values, "subContructType");
            return (Criteria) this;
        }

        public Criteria andSubContructTypeBetween(String value1, String value2) {
            addCriterion("sub_contruct_type between", value1, value2, "subContructType");
            return (Criteria) this;
        }

        public Criteria andSubContructTypeNotBetween(String value1, String value2) {
            addCriterion("sub_contruct_type not between", value1, value2, "subContructType");
            return (Criteria) this;
        }

        public Criteria andSubStartDateIsNull() {
            addCriterion("sub_start_date is null");
            return (Criteria) this;
        }

        public Criteria andSubStartDateIsNotNull() {
            addCriterion("sub_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andSubStartDateEqualTo(String value) {
            addCriterion("sub_start_date =", value, "subStartDate");
            return (Criteria) this;
        }

        public Criteria andSubStartDateNotEqualTo(String value) {
            addCriterion("sub_start_date <>", value, "subStartDate");
            return (Criteria) this;
        }

        public Criteria andSubStartDateGreaterThan(String value) {
            addCriterion("sub_start_date >", value, "subStartDate");
            return (Criteria) this;
        }

        public Criteria andSubStartDateGreaterThanOrEqualTo(String value) {
            addCriterion("sub_start_date >=", value, "subStartDate");
            return (Criteria) this;
        }

        public Criteria andSubStartDateLessThan(String value) {
            addCriterion("sub_start_date <", value, "subStartDate");
            return (Criteria) this;
        }

        public Criteria andSubStartDateLessThanOrEqualTo(String value) {
            addCriterion("sub_start_date <=", value, "subStartDate");
            return (Criteria) this;
        }

        public Criteria andSubStartDateLike(String value) {
            addCriterion("sub_start_date like", value, "subStartDate");
            return (Criteria) this;
        }

        public Criteria andSubStartDateNotLike(String value) {
            addCriterion("sub_start_date not like", value, "subStartDate");
            return (Criteria) this;
        }

        public Criteria andSubStartDateIn(List<String> values) {
            addCriterion("sub_start_date in", values, "subStartDate");
            return (Criteria) this;
        }

        public Criteria andSubStartDateNotIn(List<String> values) {
            addCriterion("sub_start_date not in", values, "subStartDate");
            return (Criteria) this;
        }

        public Criteria andSubStartDateBetween(String value1, String value2) {
            addCriterion("sub_start_date between", value1, value2, "subStartDate");
            return (Criteria) this;
        }

        public Criteria andSubStartDateNotBetween(String value1, String value2) {
            addCriterion("sub_start_date not between", value1, value2, "subStartDate");
            return (Criteria) this;
        }

        public Criteria andSubEndDateIsNull() {
            addCriterion("sub_end_date is null");
            return (Criteria) this;
        }

        public Criteria andSubEndDateIsNotNull() {
            addCriterion("sub_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andSubEndDateEqualTo(String value) {
            addCriterion("sub_end_date =", value, "subEndDate");
            return (Criteria) this;
        }

        public Criteria andSubEndDateNotEqualTo(String value) {
            addCriterion("sub_end_date <>", value, "subEndDate");
            return (Criteria) this;
        }

        public Criteria andSubEndDateGreaterThan(String value) {
            addCriterion("sub_end_date >", value, "subEndDate");
            return (Criteria) this;
        }

        public Criteria andSubEndDateGreaterThanOrEqualTo(String value) {
            addCriterion("sub_end_date >=", value, "subEndDate");
            return (Criteria) this;
        }

        public Criteria andSubEndDateLessThan(String value) {
            addCriterion("sub_end_date <", value, "subEndDate");
            return (Criteria) this;
        }

        public Criteria andSubEndDateLessThanOrEqualTo(String value) {
            addCriterion("sub_end_date <=", value, "subEndDate");
            return (Criteria) this;
        }

        public Criteria andSubEndDateLike(String value) {
            addCriterion("sub_end_date like", value, "subEndDate");
            return (Criteria) this;
        }

        public Criteria andSubEndDateNotLike(String value) {
            addCriterion("sub_end_date not like", value, "subEndDate");
            return (Criteria) this;
        }

        public Criteria andSubEndDateIn(List<String> values) {
            addCriterion("sub_end_date in", values, "subEndDate");
            return (Criteria) this;
        }

        public Criteria andSubEndDateNotIn(List<String> values) {
            addCriterion("sub_end_date not in", values, "subEndDate");
            return (Criteria) this;
        }

        public Criteria andSubEndDateBetween(String value1, String value2) {
            addCriterion("sub_end_date between", value1, value2, "subEndDate");
            return (Criteria) this;
        }

        public Criteria andSubEndDateNotBetween(String value1, String value2) {
            addCriterion("sub_end_date not between", value1, value2, "subEndDate");
            return (Criteria) this;
        }

        public Criteria andSubTimeLimitIsNull() {
            addCriterion("sub_time_limit is null");
            return (Criteria) this;
        }

        public Criteria andSubTimeLimitIsNotNull() {
            addCriterion("sub_time_limit is not null");
            return (Criteria) this;
        }

        public Criteria andSubTimeLimitEqualTo(String value) {
            addCriterion("sub_time_limit =", value, "subTimeLimit");
            return (Criteria) this;
        }

        public Criteria andSubTimeLimitNotEqualTo(String value) {
            addCriterion("sub_time_limit <>", value, "subTimeLimit");
            return (Criteria) this;
        }

        public Criteria andSubTimeLimitGreaterThan(String value) {
            addCriterion("sub_time_limit >", value, "subTimeLimit");
            return (Criteria) this;
        }

        public Criteria andSubTimeLimitGreaterThanOrEqualTo(String value) {
            addCriterion("sub_time_limit >=", value, "subTimeLimit");
            return (Criteria) this;
        }

        public Criteria andSubTimeLimitLessThan(String value) {
            addCriterion("sub_time_limit <", value, "subTimeLimit");
            return (Criteria) this;
        }

        public Criteria andSubTimeLimitLessThanOrEqualTo(String value) {
            addCriterion("sub_time_limit <=", value, "subTimeLimit");
            return (Criteria) this;
        }

        public Criteria andSubTimeLimitLike(String value) {
            addCriterion("sub_time_limit like", value, "subTimeLimit");
            return (Criteria) this;
        }

        public Criteria andSubTimeLimitNotLike(String value) {
            addCriterion("sub_time_limit not like", value, "subTimeLimit");
            return (Criteria) this;
        }

        public Criteria andSubTimeLimitIn(List<String> values) {
            addCriterion("sub_time_limit in", values, "subTimeLimit");
            return (Criteria) this;
        }

        public Criteria andSubTimeLimitNotIn(List<String> values) {
            addCriterion("sub_time_limit not in", values, "subTimeLimit");
            return (Criteria) this;
        }

        public Criteria andSubTimeLimitBetween(String value1, String value2) {
            addCriterion("sub_time_limit between", value1, value2, "subTimeLimit");
            return (Criteria) this;
        }

        public Criteria andSubTimeLimitNotBetween(String value1, String value2) {
            addCriterion("sub_time_limit not between", value1, value2, "subTimeLimit");
            return (Criteria) this;
        }

        public Criteria andSubSignTimeIsNull() {
            addCriterion("sub_sign_time is null");
            return (Criteria) this;
        }

        public Criteria andSubSignTimeIsNotNull() {
            addCriterion("sub_sign_time is not null");
            return (Criteria) this;
        }

        public Criteria andSubSignTimeEqualTo(String value) {
            addCriterion("sub_sign_time =", value, "subSignTime");
            return (Criteria) this;
        }

        public Criteria andSubSignTimeNotEqualTo(String value) {
            addCriterion("sub_sign_time <>", value, "subSignTime");
            return (Criteria) this;
        }

        public Criteria andSubSignTimeGreaterThan(String value) {
            addCriterion("sub_sign_time >", value, "subSignTime");
            return (Criteria) this;
        }

        public Criteria andSubSignTimeGreaterThanOrEqualTo(String value) {
            addCriterion("sub_sign_time >=", value, "subSignTime");
            return (Criteria) this;
        }

        public Criteria andSubSignTimeLessThan(String value) {
            addCriterion("sub_sign_time <", value, "subSignTime");
            return (Criteria) this;
        }

        public Criteria andSubSignTimeLessThanOrEqualTo(String value) {
            addCriterion("sub_sign_time <=", value, "subSignTime");
            return (Criteria) this;
        }

        public Criteria andSubSignTimeLike(String value) {
            addCriterion("sub_sign_time like", value, "subSignTime");
            return (Criteria) this;
        }

        public Criteria andSubSignTimeNotLike(String value) {
            addCriterion("sub_sign_time not like", value, "subSignTime");
            return (Criteria) this;
        }

        public Criteria andSubSignTimeIn(List<String> values) {
            addCriterion("sub_sign_time in", values, "subSignTime");
            return (Criteria) this;
        }

        public Criteria andSubSignTimeNotIn(List<String> values) {
            addCriterion("sub_sign_time not in", values, "subSignTime");
            return (Criteria) this;
        }

        public Criteria andSubSignTimeBetween(String value1, String value2) {
            addCriterion("sub_sign_time between", value1, value2, "subSignTime");
            return (Criteria) this;
        }

        public Criteria andSubSignTimeNotBetween(String value1, String value2) {
            addCriterion("sub_sign_time not between", value1, value2, "subSignTime");
            return (Criteria) this;
        }

        public Criteria andQualificationLevelIsNull() {
            addCriterion("qualification_level is null");
            return (Criteria) this;
        }

        public Criteria andQualificationLevelIsNotNull() {
            addCriterion("qualification_level is not null");
            return (Criteria) this;
        }

        public Criteria andQualificationLevelEqualTo(String value) {
            addCriterion("qualification_level =", value, "qualificationLevel");
            return (Criteria) this;
        }

        public Criteria andQualificationLevelNotEqualTo(String value) {
            addCriterion("qualification_level <>", value, "qualificationLevel");
            return (Criteria) this;
        }

        public Criteria andQualificationLevelGreaterThan(String value) {
            addCriterion("qualification_level >", value, "qualificationLevel");
            return (Criteria) this;
        }

        public Criteria andQualificationLevelGreaterThanOrEqualTo(String value) {
            addCriterion("qualification_level >=", value, "qualificationLevel");
            return (Criteria) this;
        }

        public Criteria andQualificationLevelLessThan(String value) {
            addCriterion("qualification_level <", value, "qualificationLevel");
            return (Criteria) this;
        }

        public Criteria andQualificationLevelLessThanOrEqualTo(String value) {
            addCriterion("qualification_level <=", value, "qualificationLevel");
            return (Criteria) this;
        }

        public Criteria andQualificationLevelLike(String value) {
            addCriterion("qualification_level like", value, "qualificationLevel");
            return (Criteria) this;
        }

        public Criteria andQualificationLevelNotLike(String value) {
            addCriterion("qualification_level not like", value, "qualificationLevel");
            return (Criteria) this;
        }

        public Criteria andQualificationLevelIn(List<String> values) {
            addCriterion("qualification_level in", values, "qualificationLevel");
            return (Criteria) this;
        }

        public Criteria andQualificationLevelNotIn(List<String> values) {
            addCriterion("qualification_level not in", values, "qualificationLevel");
            return (Criteria) this;
        }

        public Criteria andQualificationLevelBetween(String value1, String value2) {
            addCriterion("qualification_level between", value1, value2, "qualificationLevel");
            return (Criteria) this;
        }

        public Criteria andQualificationLevelNotBetween(String value1, String value2) {
            addCriterion("qualification_level not between", value1, value2, "qualificationLevel");
            return (Criteria) this;
        }

        public Criteria andSubQualificationRecordIsNull() {
            addCriterion("sub_qualification_record is null");
            return (Criteria) this;
        }

        public Criteria andSubQualificationRecordIsNotNull() {
            addCriterion("sub_qualification_record is not null");
            return (Criteria) this;
        }

        public Criteria andSubQualificationRecordEqualTo(String value) {
            addCriterion("sub_qualification_record =", value, "subQualificationRecord");
            return (Criteria) this;
        }

        public Criteria andSubQualificationRecordNotEqualTo(String value) {
            addCriterion("sub_qualification_record <>", value, "subQualificationRecord");
            return (Criteria) this;
        }

        public Criteria andSubQualificationRecordGreaterThan(String value) {
            addCriterion("sub_qualification_record >", value, "subQualificationRecord");
            return (Criteria) this;
        }

        public Criteria andSubQualificationRecordGreaterThanOrEqualTo(String value) {
            addCriterion("sub_qualification_record >=", value, "subQualificationRecord");
            return (Criteria) this;
        }

        public Criteria andSubQualificationRecordLessThan(String value) {
            addCriterion("sub_qualification_record <", value, "subQualificationRecord");
            return (Criteria) this;
        }

        public Criteria andSubQualificationRecordLessThanOrEqualTo(String value) {
            addCriterion("sub_qualification_record <=", value, "subQualificationRecord");
            return (Criteria) this;
        }

        public Criteria andSubQualificationRecordLike(String value) {
            addCriterion("sub_qualification_record like", value, "subQualificationRecord");
            return (Criteria) this;
        }

        public Criteria andSubQualificationRecordNotLike(String value) {
            addCriterion("sub_qualification_record not like", value, "subQualificationRecord");
            return (Criteria) this;
        }

        public Criteria andSubQualificationRecordIn(List<String> values) {
            addCriterion("sub_qualification_record in", values, "subQualificationRecord");
            return (Criteria) this;
        }

        public Criteria andSubQualificationRecordNotIn(List<String> values) {
            addCriterion("sub_qualification_record not in", values, "subQualificationRecord");
            return (Criteria) this;
        }

        public Criteria andSubQualificationRecordBetween(String value1, String value2) {
            addCriterion("sub_qualification_record between", value1, value2, "subQualificationRecord");
            return (Criteria) this;
        }

        public Criteria andSubQualificationRecordNotBetween(String value1, String value2) {
            addCriterion("sub_qualification_record not between", value1, value2, "subQualificationRecord");
            return (Criteria) this;
        }

        public Criteria andSubContructSignedIsNull() {
            addCriterion("sub_contruct_signed is null");
            return (Criteria) this;
        }

        public Criteria andSubContructSignedIsNotNull() {
            addCriterion("sub_contruct_signed is not null");
            return (Criteria) this;
        }

        public Criteria andSubContructSignedEqualTo(String value) {
            addCriterion("sub_contruct_signed =", value, "subContructSigned");
            return (Criteria) this;
        }

        public Criteria andSubContructSignedNotEqualTo(String value) {
            addCriterion("sub_contruct_signed <>", value, "subContructSigned");
            return (Criteria) this;
        }

        public Criteria andSubContructSignedGreaterThan(String value) {
            addCriterion("sub_contruct_signed >", value, "subContructSigned");
            return (Criteria) this;
        }

        public Criteria andSubContructSignedGreaterThanOrEqualTo(String value) {
            addCriterion("sub_contruct_signed >=", value, "subContructSigned");
            return (Criteria) this;
        }

        public Criteria andSubContructSignedLessThan(String value) {
            addCriterion("sub_contruct_signed <", value, "subContructSigned");
            return (Criteria) this;
        }

        public Criteria andSubContructSignedLessThanOrEqualTo(String value) {
            addCriterion("sub_contruct_signed <=", value, "subContructSigned");
            return (Criteria) this;
        }

        public Criteria andSubContructSignedLike(String value) {
            addCriterion("sub_contruct_signed like", value, "subContructSigned");
            return (Criteria) this;
        }

        public Criteria andSubContructSignedNotLike(String value) {
            addCriterion("sub_contruct_signed not like", value, "subContructSigned");
            return (Criteria) this;
        }

        public Criteria andSubContructSignedIn(List<String> values) {
            addCriterion("sub_contruct_signed in", values, "subContructSigned");
            return (Criteria) this;
        }

        public Criteria andSubContructSignedNotIn(List<String> values) {
            addCriterion("sub_contruct_signed not in", values, "subContructSigned");
            return (Criteria) this;
        }

        public Criteria andSubContructSignedBetween(String value1, String value2) {
            addCriterion("sub_contruct_signed between", value1, value2, "subContructSigned");
            return (Criteria) this;
        }

        public Criteria andSubContructSignedNotBetween(String value1, String value2) {
            addCriterion("sub_contruct_signed not between", value1, value2, "subContructSigned");
            return (Criteria) this;
        }

        public Criteria andSubWorkContentIsNull() {
            addCriterion("sub_work_content is null");
            return (Criteria) this;
        }

        public Criteria andSubWorkContentIsNotNull() {
            addCriterion("sub_work_content is not null");
            return (Criteria) this;
        }

        public Criteria andSubWorkContentEqualTo(String value) {
            addCriterion("sub_work_content =", value, "subWorkContent");
            return (Criteria) this;
        }

        public Criteria andSubWorkContentNotEqualTo(String value) {
            addCriterion("sub_work_content <>", value, "subWorkContent");
            return (Criteria) this;
        }

        public Criteria andSubWorkContentGreaterThan(String value) {
            addCriterion("sub_work_content >", value, "subWorkContent");
            return (Criteria) this;
        }

        public Criteria andSubWorkContentGreaterThanOrEqualTo(String value) {
            addCriterion("sub_work_content >=", value, "subWorkContent");
            return (Criteria) this;
        }

        public Criteria andSubWorkContentLessThan(String value) {
            addCriterion("sub_work_content <", value, "subWorkContent");
            return (Criteria) this;
        }

        public Criteria andSubWorkContentLessThanOrEqualTo(String value) {
            addCriterion("sub_work_content <=", value, "subWorkContent");
            return (Criteria) this;
        }

        public Criteria andSubWorkContentLike(String value) {
            addCriterion("sub_work_content like", value, "subWorkContent");
            return (Criteria) this;
        }

        public Criteria andSubWorkContentNotLike(String value) {
            addCriterion("sub_work_content not like", value, "subWorkContent");
            return (Criteria) this;
        }

        public Criteria andSubWorkContentIn(List<String> values) {
            addCriterion("sub_work_content in", values, "subWorkContent");
            return (Criteria) this;
        }

        public Criteria andSubWorkContentNotIn(List<String> values) {
            addCriterion("sub_work_content not in", values, "subWorkContent");
            return (Criteria) this;
        }

        public Criteria andSubWorkContentBetween(String value1, String value2) {
            addCriterion("sub_work_content between", value1, value2, "subWorkContent");
            return (Criteria) this;
        }

        public Criteria andSubWorkContentNotBetween(String value1, String value2) {
            addCriterion("sub_work_content not between", value1, value2, "subWorkContent");
            return (Criteria) this;
        }

        public Criteria andSubQualityRequireIsNull() {
            addCriterion("sub_quality_require is null");
            return (Criteria) this;
        }

        public Criteria andSubQualityRequireIsNotNull() {
            addCriterion("sub_quality_require is not null");
            return (Criteria) this;
        }

        public Criteria andSubQualityRequireEqualTo(String value) {
            addCriterion("sub_quality_require =", value, "subQualityRequire");
            return (Criteria) this;
        }

        public Criteria andSubQualityRequireNotEqualTo(String value) {
            addCriterion("sub_quality_require <>", value, "subQualityRequire");
            return (Criteria) this;
        }

        public Criteria andSubQualityRequireGreaterThan(String value) {
            addCriterion("sub_quality_require >", value, "subQualityRequire");
            return (Criteria) this;
        }

        public Criteria andSubQualityRequireGreaterThanOrEqualTo(String value) {
            addCriterion("sub_quality_require >=", value, "subQualityRequire");
            return (Criteria) this;
        }

        public Criteria andSubQualityRequireLessThan(String value) {
            addCriterion("sub_quality_require <", value, "subQualityRequire");
            return (Criteria) this;
        }

        public Criteria andSubQualityRequireLessThanOrEqualTo(String value) {
            addCriterion("sub_quality_require <=", value, "subQualityRequire");
            return (Criteria) this;
        }

        public Criteria andSubQualityRequireLike(String value) {
            addCriterion("sub_quality_require like", value, "subQualityRequire");
            return (Criteria) this;
        }

        public Criteria andSubQualityRequireNotLike(String value) {
            addCriterion("sub_quality_require not like", value, "subQualityRequire");
            return (Criteria) this;
        }

        public Criteria andSubQualityRequireIn(List<String> values) {
            addCriterion("sub_quality_require in", values, "subQualityRequire");
            return (Criteria) this;
        }

        public Criteria andSubQualityRequireNotIn(List<String> values) {
            addCriterion("sub_quality_require not in", values, "subQualityRequire");
            return (Criteria) this;
        }

        public Criteria andSubQualityRequireBetween(String value1, String value2) {
            addCriterion("sub_quality_require between", value1, value2, "subQualityRequire");
            return (Criteria) this;
        }

        public Criteria andSubQualityRequireNotBetween(String value1, String value2) {
            addCriterion("sub_quality_require not between", value1, value2, "subQualityRequire");
            return (Criteria) this;
        }

        public Criteria andSubOtherTermsIsNull() {
            addCriterion("sub_other_terms is null");
            return (Criteria) this;
        }

        public Criteria andSubOtherTermsIsNotNull() {
            addCriterion("sub_other_terms is not null");
            return (Criteria) this;
        }

        public Criteria andSubOtherTermsEqualTo(String value) {
            addCriterion("sub_other_terms =", value, "subOtherTerms");
            return (Criteria) this;
        }

        public Criteria andSubOtherTermsNotEqualTo(String value) {
            addCriterion("sub_other_terms <>", value, "subOtherTerms");
            return (Criteria) this;
        }

        public Criteria andSubOtherTermsGreaterThan(String value) {
            addCriterion("sub_other_terms >", value, "subOtherTerms");
            return (Criteria) this;
        }

        public Criteria andSubOtherTermsGreaterThanOrEqualTo(String value) {
            addCriterion("sub_other_terms >=", value, "subOtherTerms");
            return (Criteria) this;
        }

        public Criteria andSubOtherTermsLessThan(String value) {
            addCriterion("sub_other_terms <", value, "subOtherTerms");
            return (Criteria) this;
        }

        public Criteria andSubOtherTermsLessThanOrEqualTo(String value) {
            addCriterion("sub_other_terms <=", value, "subOtherTerms");
            return (Criteria) this;
        }

        public Criteria andSubOtherTermsLike(String value) {
            addCriterion("sub_other_terms like", value, "subOtherTerms");
            return (Criteria) this;
        }

        public Criteria andSubOtherTermsNotLike(String value) {
            addCriterion("sub_other_terms not like", value, "subOtherTerms");
            return (Criteria) this;
        }

        public Criteria andSubOtherTermsIn(List<String> values) {
            addCriterion("sub_other_terms in", values, "subOtherTerms");
            return (Criteria) this;
        }

        public Criteria andSubOtherTermsNotIn(List<String> values) {
            addCriterion("sub_other_terms not in", values, "subOtherTerms");
            return (Criteria) this;
        }

        public Criteria andSubOtherTermsBetween(String value1, String value2) {
            addCriterion("sub_other_terms between", value1, value2, "subOtherTerms");
            return (Criteria) this;
        }

        public Criteria andSubOtherTermsNotBetween(String value1, String value2) {
            addCriterion("sub_other_terms not between", value1, value2, "subOtherTerms");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andAttachIdIsNull() {
            addCriterion("attach_id is null");
            return (Criteria) this;
        }

        public Criteria andAttachIdIsNotNull() {
            addCriterion("attach_id is not null");
            return (Criteria) this;
        }

        public Criteria andAttachIdEqualTo(String value) {
            addCriterion("attach_id =", value, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdNotEqualTo(String value) {
            addCriterion("attach_id <>", value, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdGreaterThan(String value) {
            addCriterion("attach_id >", value, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdGreaterThanOrEqualTo(String value) {
            addCriterion("attach_id >=", value, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdLessThan(String value) {
            addCriterion("attach_id <", value, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdLessThanOrEqualTo(String value) {
            addCriterion("attach_id <=", value, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdLike(String value) {
            addCriterion("attach_id like", value, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdNotLike(String value) {
            addCriterion("attach_id not like", value, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdIn(List<String> values) {
            addCriterion("attach_id in", values, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdNotIn(List<String> values) {
            addCriterion("attach_id not in", values, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdBetween(String value1, String value2) {
            addCriterion("attach_id between", value1, value2, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdNotBetween(String value1, String value2) {
            addCriterion("attach_id not between", value1, value2, "attachId");
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