package com.pcitc.base.engin.hse.workpermit;

import java.util.ArrayList;
import java.util.List;

public class HsePermitWorkerVoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public HsePermitWorkerVoExample() {
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

        public Criteria andPermitIdIsNull() {
            addCriterion("permit_id is null");
            return (Criteria) this;
        }

        public Criteria andPermitIdIsNotNull() {
            addCriterion("permit_id is not null");
            return (Criteria) this;
        }

        public Criteria andPermitIdEqualTo(String value) {
            addCriterion("permit_id =", value, "permitId");
            return (Criteria) this;
        }

        public Criteria andPermitIdNotEqualTo(String value) {
            addCriterion("permit_id <>", value, "permitId");
            return (Criteria) this;
        }

        public Criteria andPermitIdGreaterThan(String value) {
            addCriterion("permit_id >", value, "permitId");
            return (Criteria) this;
        }

        public Criteria andPermitIdGreaterThanOrEqualTo(String value) {
            addCriterion("permit_id >=", value, "permitId");
            return (Criteria) this;
        }

        public Criteria andPermitIdLessThan(String value) {
            addCriterion("permit_id <", value, "permitId");
            return (Criteria) this;
        }

        public Criteria andPermitIdLessThanOrEqualTo(String value) {
            addCriterion("permit_id <=", value, "permitId");
            return (Criteria) this;
        }

        public Criteria andPermitIdLike(String value) {
            addCriterion("permit_id like", value, "permitId");
            return (Criteria) this;
        }

        public Criteria andPermitIdNotLike(String value) {
            addCriterion("permit_id not like", value, "permitId");
            return (Criteria) this;
        }

        public Criteria andPermitIdIn(List<String> values) {
            addCriterion("permit_id in", values, "permitId");
            return (Criteria) this;
        }

        public Criteria andPermitIdNotIn(List<String> values) {
            addCriterion("permit_id not in", values, "permitId");
            return (Criteria) this;
        }

        public Criteria andPermitIdBetween(String value1, String value2) {
            addCriterion("permit_id between", value1, value2, "permitId");
            return (Criteria) this;
        }

        public Criteria andPermitIdNotBetween(String value1, String value2) {
            addCriterion("permit_id not between", value1, value2, "permitId");
            return (Criteria) this;
        }

        public Criteria andPermitTypeIsNull() {
            addCriterion("permit_type is null");
            return (Criteria) this;
        }

        public Criteria andPermitTypeIsNotNull() {
            addCriterion("permit_type is not null");
            return (Criteria) this;
        }

        public Criteria andPermitTypeEqualTo(String value) {
            addCriterion("permit_type =", value, "permitType");
            return (Criteria) this;
        }

        public Criteria andPermitTypeNotEqualTo(String value) {
            addCriterion("permit_type <>", value, "permitType");
            return (Criteria) this;
        }

        public Criteria andPermitTypeGreaterThan(String value) {
            addCriterion("permit_type >", value, "permitType");
            return (Criteria) this;
        }

        public Criteria andPermitTypeGreaterThanOrEqualTo(String value) {
            addCriterion("permit_type >=", value, "permitType");
            return (Criteria) this;
        }

        public Criteria andPermitTypeLessThan(String value) {
            addCriterion("permit_type <", value, "permitType");
            return (Criteria) this;
        }

        public Criteria andPermitTypeLessThanOrEqualTo(String value) {
            addCriterion("permit_type <=", value, "permitType");
            return (Criteria) this;
        }

        public Criteria andPermitTypeLike(String value) {
            addCriterion("permit_type like", value, "permitType");
            return (Criteria) this;
        }

        public Criteria andPermitTypeNotLike(String value) {
            addCriterion("permit_type not like", value, "permitType");
            return (Criteria) this;
        }

        public Criteria andPermitTypeIn(List<String> values) {
            addCriterion("permit_type in", values, "permitType");
            return (Criteria) this;
        }

        public Criteria andPermitTypeNotIn(List<String> values) {
            addCriterion("permit_type not in", values, "permitType");
            return (Criteria) this;
        }

        public Criteria andPermitTypeBetween(String value1, String value2) {
            addCriterion("permit_type between", value1, value2, "permitType");
            return (Criteria) this;
        }

        public Criteria andPermitTypeNotBetween(String value1, String value2) {
            addCriterion("permit_type not between", value1, value2, "permitType");
            return (Criteria) this;
        }

        public Criteria andWorkerNameIsNull() {
            addCriterion("worker_name is null");
            return (Criteria) this;
        }

        public Criteria andWorkerNameIsNotNull() {
            addCriterion("worker_name is not null");
            return (Criteria) this;
        }

        public Criteria andWorkerNameEqualTo(String value) {
            addCriterion("worker_name =", value, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameNotEqualTo(String value) {
            addCriterion("worker_name <>", value, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameGreaterThan(String value) {
            addCriterion("worker_name >", value, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameGreaterThanOrEqualTo(String value) {
            addCriterion("worker_name >=", value, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameLessThan(String value) {
            addCriterion("worker_name <", value, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameLessThanOrEqualTo(String value) {
            addCriterion("worker_name <=", value, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameLike(String value) {
            addCriterion("worker_name like", value, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameNotLike(String value) {
            addCriterion("worker_name not like", value, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameIn(List<String> values) {
            addCriterion("worker_name in", values, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameNotIn(List<String> values) {
            addCriterion("worker_name not in", values, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameBetween(String value1, String value2) {
            addCriterion("worker_name between", value1, value2, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameNotBetween(String value1, String value2) {
            addCriterion("worker_name not between", value1, value2, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerTitleIsNull() {
            addCriterion("worker_title is null");
            return (Criteria) this;
        }

        public Criteria andWorkerTitleIsNotNull() {
            addCriterion("worker_title is not null");
            return (Criteria) this;
        }

        public Criteria andWorkerTitleEqualTo(String value) {
            addCriterion("worker_title =", value, "workerTitle");
            return (Criteria) this;
        }

        public Criteria andWorkerTitleNotEqualTo(String value) {
            addCriterion("worker_title <>", value, "workerTitle");
            return (Criteria) this;
        }

        public Criteria andWorkerTitleGreaterThan(String value) {
            addCriterion("worker_title >", value, "workerTitle");
            return (Criteria) this;
        }

        public Criteria andWorkerTitleGreaterThanOrEqualTo(String value) {
            addCriterion("worker_title >=", value, "workerTitle");
            return (Criteria) this;
        }

        public Criteria andWorkerTitleLessThan(String value) {
            addCriterion("worker_title <", value, "workerTitle");
            return (Criteria) this;
        }

        public Criteria andWorkerTitleLessThanOrEqualTo(String value) {
            addCriterion("worker_title <=", value, "workerTitle");
            return (Criteria) this;
        }

        public Criteria andWorkerTitleLike(String value) {
            addCriterion("worker_title like", value, "workerTitle");
            return (Criteria) this;
        }

        public Criteria andWorkerTitleNotLike(String value) {
            addCriterion("worker_title not like", value, "workerTitle");
            return (Criteria) this;
        }

        public Criteria andWorkerTitleIn(List<String> values) {
            addCriterion("worker_title in", values, "workerTitle");
            return (Criteria) this;
        }

        public Criteria andWorkerTitleNotIn(List<String> values) {
            addCriterion("worker_title not in", values, "workerTitle");
            return (Criteria) this;
        }

        public Criteria andWorkerTitleBetween(String value1, String value2) {
            addCriterion("worker_title between", value1, value2, "workerTitle");
            return (Criteria) this;
        }

        public Criteria andWorkerTitleNotBetween(String value1, String value2) {
            addCriterion("worker_title not between", value1, value2, "workerTitle");
            return (Criteria) this;
        }

        public Criteria andWorkerTypeIsNull() {
            addCriterion("worker_type is null");
            return (Criteria) this;
        }

        public Criteria andWorkerTypeIsNotNull() {
            addCriterion("worker_type is not null");
            return (Criteria) this;
        }

        public Criteria andWorkerTypeEqualTo(String value) {
            addCriterion("worker_type =", value, "workerType");
            return (Criteria) this;
        }

        public Criteria andWorkerTypeNotEqualTo(String value) {
            addCriterion("worker_type <>", value, "workerType");
            return (Criteria) this;
        }

        public Criteria andWorkerTypeGreaterThan(String value) {
            addCriterion("worker_type >", value, "workerType");
            return (Criteria) this;
        }

        public Criteria andWorkerTypeGreaterThanOrEqualTo(String value) {
            addCriterion("worker_type >=", value, "workerType");
            return (Criteria) this;
        }

        public Criteria andWorkerTypeLessThan(String value) {
            addCriterion("worker_type <", value, "workerType");
            return (Criteria) this;
        }

        public Criteria andWorkerTypeLessThanOrEqualTo(String value) {
            addCriterion("worker_type <=", value, "workerType");
            return (Criteria) this;
        }

        public Criteria andWorkerTypeLike(String value) {
            addCriterion("worker_type like", value, "workerType");
            return (Criteria) this;
        }

        public Criteria andWorkerTypeNotLike(String value) {
            addCriterion("worker_type not like", value, "workerType");
            return (Criteria) this;
        }

        public Criteria andWorkerTypeIn(List<String> values) {
            addCriterion("worker_type in", values, "workerType");
            return (Criteria) this;
        }

        public Criteria andWorkerTypeNotIn(List<String> values) {
            addCriterion("worker_type not in", values, "workerType");
            return (Criteria) this;
        }

        public Criteria andWorkerTypeBetween(String value1, String value2) {
            addCriterion("worker_type between", value1, value2, "workerType");
            return (Criteria) this;
        }

        public Criteria andWorkerTypeNotBetween(String value1, String value2) {
            addCriterion("worker_type not between", value1, value2, "workerType");
            return (Criteria) this;
        }

        public Criteria andWorkerPostIsNull() {
            addCriterion("worker_post is null");
            return (Criteria) this;
        }

        public Criteria andWorkerPostIsNotNull() {
            addCriterion("worker_post is not null");
            return (Criteria) this;
        }

        public Criteria andWorkerPostEqualTo(String value) {
            addCriterion("worker_post =", value, "workerPost");
            return (Criteria) this;
        }

        public Criteria andWorkerPostNotEqualTo(String value) {
            addCriterion("worker_post <>", value, "workerPost");
            return (Criteria) this;
        }

        public Criteria andWorkerPostGreaterThan(String value) {
            addCriterion("worker_post >", value, "workerPost");
            return (Criteria) this;
        }

        public Criteria andWorkerPostGreaterThanOrEqualTo(String value) {
            addCriterion("worker_post >=", value, "workerPost");
            return (Criteria) this;
        }

        public Criteria andWorkerPostLessThan(String value) {
            addCriterion("worker_post <", value, "workerPost");
            return (Criteria) this;
        }

        public Criteria andWorkerPostLessThanOrEqualTo(String value) {
            addCriterion("worker_post <=", value, "workerPost");
            return (Criteria) this;
        }

        public Criteria andWorkerPostLike(String value) {
            addCriterion("worker_post like", value, "workerPost");
            return (Criteria) this;
        }

        public Criteria andWorkerPostNotLike(String value) {
            addCriterion("worker_post not like", value, "workerPost");
            return (Criteria) this;
        }

        public Criteria andWorkerPostIn(List<String> values) {
            addCriterion("worker_post in", values, "workerPost");
            return (Criteria) this;
        }

        public Criteria andWorkerPostNotIn(List<String> values) {
            addCriterion("worker_post not in", values, "workerPost");
            return (Criteria) this;
        }

        public Criteria andWorkerPostBetween(String value1, String value2) {
            addCriterion("worker_post between", value1, value2, "workerPost");
            return (Criteria) this;
        }

        public Criteria andWorkerPostNotBetween(String value1, String value2) {
            addCriterion("worker_post not between", value1, value2, "workerPost");
            return (Criteria) this;
        }

        public Criteria andWorkDeviceIsNull() {
            addCriterion("work_device is null");
            return (Criteria) this;
        }

        public Criteria andWorkDeviceIsNotNull() {
            addCriterion("work_device is not null");
            return (Criteria) this;
        }

        public Criteria andWorkDeviceEqualTo(String value) {
            addCriterion("work_device =", value, "workDevice");
            return (Criteria) this;
        }

        public Criteria andWorkDeviceNotEqualTo(String value) {
            addCriterion("work_device <>", value, "workDevice");
            return (Criteria) this;
        }

        public Criteria andWorkDeviceGreaterThan(String value) {
            addCriterion("work_device >", value, "workDevice");
            return (Criteria) this;
        }

        public Criteria andWorkDeviceGreaterThanOrEqualTo(String value) {
            addCriterion("work_device >=", value, "workDevice");
            return (Criteria) this;
        }

        public Criteria andWorkDeviceLessThan(String value) {
            addCriterion("work_device <", value, "workDevice");
            return (Criteria) this;
        }

        public Criteria andWorkDeviceLessThanOrEqualTo(String value) {
            addCriterion("work_device <=", value, "workDevice");
            return (Criteria) this;
        }

        public Criteria andWorkDeviceLike(String value) {
            addCriterion("work_device like", value, "workDevice");
            return (Criteria) this;
        }

        public Criteria andWorkDeviceNotLike(String value) {
            addCriterion("work_device not like", value, "workDevice");
            return (Criteria) this;
        }

        public Criteria andWorkDeviceIn(List<String> values) {
            addCriterion("work_device in", values, "workDevice");
            return (Criteria) this;
        }

        public Criteria andWorkDeviceNotIn(List<String> values) {
            addCriterion("work_device not in", values, "workDevice");
            return (Criteria) this;
        }

        public Criteria andWorkDeviceBetween(String value1, String value2) {
            addCriterion("work_device between", value1, value2, "workDevice");
            return (Criteria) this;
        }

        public Criteria andWorkDeviceNotBetween(String value1, String value2) {
            addCriterion("work_device not between", value1, value2, "workDevice");
            return (Criteria) this;
        }

        public Criteria andDeviceNumIsNull() {
            addCriterion("device_num is null");
            return (Criteria) this;
        }

        public Criteria andDeviceNumIsNotNull() {
            addCriterion("device_num is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceNumEqualTo(String value) {
            addCriterion("device_num =", value, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumNotEqualTo(String value) {
            addCriterion("device_num <>", value, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumGreaterThan(String value) {
            addCriterion("device_num >", value, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumGreaterThanOrEqualTo(String value) {
            addCriterion("device_num >=", value, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumLessThan(String value) {
            addCriterion("device_num <", value, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumLessThanOrEqualTo(String value) {
            addCriterion("device_num <=", value, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumLike(String value) {
            addCriterion("device_num like", value, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumNotLike(String value) {
            addCriterion("device_num not like", value, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumIn(List<String> values) {
            addCriterion("device_num in", values, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumNotIn(List<String> values) {
            addCriterion("device_num not in", values, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumBetween(String value1, String value2) {
            addCriterion("device_num between", value1, value2, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumNotBetween(String value1, String value2) {
            addCriterion("device_num not between", value1, value2, "deviceNum");
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

        public Criteria andWorkerIdCardIsNull() {
            addCriterion("worker_id_card is null");
            return (Criteria) this;
        }

        public Criteria andWorkerIdCardIsNotNull() {
            addCriterion("worker_id_card is not null");
            return (Criteria) this;
        }

        public Criteria andWorkerIdCardEqualTo(String value) {
            addCriterion("worker_id_card =", value, "workerIdCard");
            return (Criteria) this;
        }

        public Criteria andWorkerIdCardNotEqualTo(String value) {
            addCriterion("worker_id_card <>", value, "workerIdCard");
            return (Criteria) this;
        }

        public Criteria andWorkerIdCardGreaterThan(String value) {
            addCriterion("worker_id_card >", value, "workerIdCard");
            return (Criteria) this;
        }

        public Criteria andWorkerIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("worker_id_card >=", value, "workerIdCard");
            return (Criteria) this;
        }

        public Criteria andWorkerIdCardLessThan(String value) {
            addCriterion("worker_id_card <", value, "workerIdCard");
            return (Criteria) this;
        }

        public Criteria andWorkerIdCardLessThanOrEqualTo(String value) {
            addCriterion("worker_id_card <=", value, "workerIdCard");
            return (Criteria) this;
        }

        public Criteria andWorkerIdCardLike(String value) {
            addCriterion("worker_id_card like", value, "workerIdCard");
            return (Criteria) this;
        }

        public Criteria andWorkerIdCardNotLike(String value) {
            addCriterion("worker_id_card not like", value, "workerIdCard");
            return (Criteria) this;
        }

        public Criteria andWorkerIdCardIn(List<String> values) {
            addCriterion("worker_id_card in", values, "workerIdCard");
            return (Criteria) this;
        }

        public Criteria andWorkerIdCardNotIn(List<String> values) {
            addCriterion("worker_id_card not in", values, "workerIdCard");
            return (Criteria) this;
        }

        public Criteria andWorkerIdCardBetween(String value1, String value2) {
            addCriterion("worker_id_card between", value1, value2, "workerIdCard");
            return (Criteria) this;
        }

        public Criteria andWorkerIdCardNotBetween(String value1, String value2) {
            addCriterion("worker_id_card not between", value1, value2, "workerIdCard");
            return (Criteria) this;
        }

        public Criteria andWorkerKeeperIsNull() {
            addCriterion("worker_keeper is null");
            return (Criteria) this;
        }

        public Criteria andWorkerKeeperIsNotNull() {
            addCriterion("worker_keeper is not null");
            return (Criteria) this;
        }

        public Criteria andWorkerKeeperEqualTo(String value) {
            addCriterion("worker_keeper =", value, "workerKeeper");
            return (Criteria) this;
        }

        public Criteria andWorkerKeeperNotEqualTo(String value) {
            addCriterion("worker_keeper <>", value, "workerKeeper");
            return (Criteria) this;
        }

        public Criteria andWorkerKeeperGreaterThan(String value) {
            addCriterion("worker_keeper >", value, "workerKeeper");
            return (Criteria) this;
        }

        public Criteria andWorkerKeeperGreaterThanOrEqualTo(String value) {
            addCriterion("worker_keeper >=", value, "workerKeeper");
            return (Criteria) this;
        }

        public Criteria andWorkerKeeperLessThan(String value) {
            addCriterion("worker_keeper <", value, "workerKeeper");
            return (Criteria) this;
        }

        public Criteria andWorkerKeeperLessThanOrEqualTo(String value) {
            addCriterion("worker_keeper <=", value, "workerKeeper");
            return (Criteria) this;
        }

        public Criteria andWorkerKeeperLike(String value) {
            addCriterion("worker_keeper like", value, "workerKeeper");
            return (Criteria) this;
        }

        public Criteria andWorkerKeeperNotLike(String value) {
            addCriterion("worker_keeper not like", value, "workerKeeper");
            return (Criteria) this;
        }

        public Criteria andWorkerKeeperIn(List<String> values) {
            addCriterion("worker_keeper in", values, "workerKeeper");
            return (Criteria) this;
        }

        public Criteria andWorkerKeeperNotIn(List<String> values) {
            addCriterion("worker_keeper not in", values, "workerKeeper");
            return (Criteria) this;
        }

        public Criteria andWorkerKeeperBetween(String value1, String value2) {
            addCriterion("worker_keeper between", value1, value2, "workerKeeper");
            return (Criteria) this;
        }

        public Criteria andWorkerKeeperNotBetween(String value1, String value2) {
            addCriterion("worker_keeper not between", value1, value2, "workerKeeper");
            return (Criteria) this;
        }

        public Criteria andSpecialWorkerNumIsNull() {
            addCriterion("special_worker_num is null");
            return (Criteria) this;
        }

        public Criteria andSpecialWorkerNumIsNotNull() {
            addCriterion("special_worker_num is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialWorkerNumEqualTo(String value) {
            addCriterion("special_worker_num =", value, "specialWorkerNum");
            return (Criteria) this;
        }

        public Criteria andSpecialWorkerNumNotEqualTo(String value) {
            addCriterion("special_worker_num <>", value, "specialWorkerNum");
            return (Criteria) this;
        }

        public Criteria andSpecialWorkerNumGreaterThan(String value) {
            addCriterion("special_worker_num >", value, "specialWorkerNum");
            return (Criteria) this;
        }

        public Criteria andSpecialWorkerNumGreaterThanOrEqualTo(String value) {
            addCriterion("special_worker_num >=", value, "specialWorkerNum");
            return (Criteria) this;
        }

        public Criteria andSpecialWorkerNumLessThan(String value) {
            addCriterion("special_worker_num <", value, "specialWorkerNum");
            return (Criteria) this;
        }

        public Criteria andSpecialWorkerNumLessThanOrEqualTo(String value) {
            addCriterion("special_worker_num <=", value, "specialWorkerNum");
            return (Criteria) this;
        }

        public Criteria andSpecialWorkerNumLike(String value) {
            addCriterion("special_worker_num like", value, "specialWorkerNum");
            return (Criteria) this;
        }

        public Criteria andSpecialWorkerNumNotLike(String value) {
            addCriterion("special_worker_num not like", value, "specialWorkerNum");
            return (Criteria) this;
        }

        public Criteria andSpecialWorkerNumIn(List<String> values) {
            addCriterion("special_worker_num in", values, "specialWorkerNum");
            return (Criteria) this;
        }

        public Criteria andSpecialWorkerNumNotIn(List<String> values) {
            addCriterion("special_worker_num not in", values, "specialWorkerNum");
            return (Criteria) this;
        }

        public Criteria andSpecialWorkerNumBetween(String value1, String value2) {
            addCriterion("special_worker_num between", value1, value2, "specialWorkerNum");
            return (Criteria) this;
        }

        public Criteria andSpecialWorkerNumNotBetween(String value1, String value2) {
            addCriterion("special_worker_num not between", value1, value2, "specialWorkerNum");
            return (Criteria) this;
        }

        public Criteria andContactWayIsNull() {
            addCriterion("contact_way is null");
            return (Criteria) this;
        }

        public Criteria andContactWayIsNotNull() {
            addCriterion("contact_way is not null");
            return (Criteria) this;
        }

        public Criteria andContactWayEqualTo(String value) {
            addCriterion("contact_way =", value, "contactWay");
            return (Criteria) this;
        }

        public Criteria andContactWayNotEqualTo(String value) {
            addCriterion("contact_way <>", value, "contactWay");
            return (Criteria) this;
        }

        public Criteria andContactWayGreaterThan(String value) {
            addCriterion("contact_way >", value, "contactWay");
            return (Criteria) this;
        }

        public Criteria andContactWayGreaterThanOrEqualTo(String value) {
            addCriterion("contact_way >=", value, "contactWay");
            return (Criteria) this;
        }

        public Criteria andContactWayLessThan(String value) {
            addCriterion("contact_way <", value, "contactWay");
            return (Criteria) this;
        }

        public Criteria andContactWayLessThanOrEqualTo(String value) {
            addCriterion("contact_way <=", value, "contactWay");
            return (Criteria) this;
        }

        public Criteria andContactWayLike(String value) {
            addCriterion("contact_way like", value, "contactWay");
            return (Criteria) this;
        }

        public Criteria andContactWayNotLike(String value) {
            addCriterion("contact_way not like", value, "contactWay");
            return (Criteria) this;
        }

        public Criteria andContactWayIn(List<String> values) {
            addCriterion("contact_way in", values, "contactWay");
            return (Criteria) this;
        }

        public Criteria andContactWayNotIn(List<String> values) {
            addCriterion("contact_way not in", values, "contactWay");
            return (Criteria) this;
        }

        public Criteria andContactWayBetween(String value1, String value2) {
            addCriterion("contact_way between", value1, value2, "contactWay");
            return (Criteria) this;
        }

        public Criteria andContactWayNotBetween(String value1, String value2) {
            addCriterion("contact_way not between", value1, value2, "contactWay");
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