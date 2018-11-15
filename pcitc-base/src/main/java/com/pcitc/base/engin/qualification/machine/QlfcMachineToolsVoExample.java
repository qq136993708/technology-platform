package com.pcitc.base.engin.qualification.machine;

import java.util.ArrayList;
import java.util.List;

public class QlfcMachineToolsVoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public QlfcMachineToolsVoExample() {
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

        public Criteria andReportIdIsNull() {
            addCriterion("report_id is null");
            return (Criteria) this;
        }

        public Criteria andReportIdIsNotNull() {
            addCriterion("report_id is not null");
            return (Criteria) this;
        }

        public Criteria andReportIdEqualTo(String value) {
            addCriterion("report_id =", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotEqualTo(String value) {
            addCriterion("report_id <>", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdGreaterThan(String value) {
            addCriterion("report_id >", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdGreaterThanOrEqualTo(String value) {
            addCriterion("report_id >=", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdLessThan(String value) {
            addCriterion("report_id <", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdLessThanOrEqualTo(String value) {
            addCriterion("report_id <=", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdLike(String value) {
            addCriterion("report_id like", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotLike(String value) {
            addCriterion("report_id not like", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdIn(List<String> values) {
            addCriterion("report_id in", values, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotIn(List<String> values) {
            addCriterion("report_id not in", values, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdBetween(String value1, String value2) {
            addCriterion("report_id between", value1, value2, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotBetween(String value1, String value2) {
            addCriterion("report_id not between", value1, value2, "reportId");
            return (Criteria) this;
        }

        public Criteria andExitIdIsNull() {
            addCriterion("exit_id is null");
            return (Criteria) this;
        }

        public Criteria andExitIdIsNotNull() {
            addCriterion("exit_id is not null");
            return (Criteria) this;
        }

        public Criteria andExitIdEqualTo(String value) {
            addCriterion("exit_id =", value, "exitId");
            return (Criteria) this;
        }

        public Criteria andExitIdNotEqualTo(String value) {
            addCriterion("exit_id <>", value, "exitId");
            return (Criteria) this;
        }

        public Criteria andExitIdGreaterThan(String value) {
            addCriterion("exit_id >", value, "exitId");
            return (Criteria) this;
        }

        public Criteria andExitIdGreaterThanOrEqualTo(String value) {
            addCriterion("exit_id >=", value, "exitId");
            return (Criteria) this;
        }

        public Criteria andExitIdLessThan(String value) {
            addCriterion("exit_id <", value, "exitId");
            return (Criteria) this;
        }

        public Criteria andExitIdLessThanOrEqualTo(String value) {
            addCriterion("exit_id <=", value, "exitId");
            return (Criteria) this;
        }

        public Criteria andExitIdLike(String value) {
            addCriterion("exit_id like", value, "exitId");
            return (Criteria) this;
        }

        public Criteria andExitIdNotLike(String value) {
            addCriterion("exit_id not like", value, "exitId");
            return (Criteria) this;
        }

        public Criteria andExitIdIn(List<String> values) {
            addCriterion("exit_id in", values, "exitId");
            return (Criteria) this;
        }

        public Criteria andExitIdNotIn(List<String> values) {
            addCriterion("exit_id not in", values, "exitId");
            return (Criteria) this;
        }

        public Criteria andExitIdBetween(String value1, String value2) {
            addCriterion("exit_id between", value1, value2, "exitId");
            return (Criteria) this;
        }

        public Criteria andExitIdNotBetween(String value1, String value2) {
            addCriterion("exit_id not between", value1, value2, "exitId");
            return (Criteria) this;
        }

        public Criteria andIsExitIsNull() {
            addCriterion("is_exit is null");
            return (Criteria) this;
        }

        public Criteria andIsExitIsNotNull() {
            addCriterion("is_exit is not null");
            return (Criteria) this;
        }

        public Criteria andIsExitEqualTo(String value) {
            addCriterion("is_exit =", value, "isExit");
            return (Criteria) this;
        }

        public Criteria andIsExitNotEqualTo(String value) {
            addCriterion("is_exit <>", value, "isExit");
            return (Criteria) this;
        }

        public Criteria andIsExitGreaterThan(String value) {
            addCriterion("is_exit >", value, "isExit");
            return (Criteria) this;
        }

        public Criteria andIsExitGreaterThanOrEqualTo(String value) {
            addCriterion("is_exit >=", value, "isExit");
            return (Criteria) this;
        }

        public Criteria andIsExitLessThan(String value) {
            addCriterion("is_exit <", value, "isExit");
            return (Criteria) this;
        }

        public Criteria andIsExitLessThanOrEqualTo(String value) {
            addCriterion("is_exit <=", value, "isExit");
            return (Criteria) this;
        }

        public Criteria andIsExitLike(String value) {
            addCriterion("is_exit like", value, "isExit");
            return (Criteria) this;
        }

        public Criteria andIsExitNotLike(String value) {
            addCriterion("is_exit not like", value, "isExit");
            return (Criteria) this;
        }

        public Criteria andIsExitIn(List<String> values) {
            addCriterion("is_exit in", values, "isExit");
            return (Criteria) this;
        }

        public Criteria andIsExitNotIn(List<String> values) {
            addCriterion("is_exit not in", values, "isExit");
            return (Criteria) this;
        }

        public Criteria andIsExitBetween(String value1, String value2) {
            addCriterion("is_exit between", value1, value2, "isExit");
            return (Criteria) this;
        }

        public Criteria andIsExitNotBetween(String value1, String value2) {
            addCriterion("is_exit not between", value1, value2, "isExit");
            return (Criteria) this;
        }

        public Criteria andIsOldIsNull() {
            addCriterion("is_old is null");
            return (Criteria) this;
        }

        public Criteria andIsOldIsNotNull() {
            addCriterion("is_old is not null");
            return (Criteria) this;
        }

        public Criteria andIsOldEqualTo(String value) {
            addCriterion("is_old =", value, "isOld");
            return (Criteria) this;
        }

        public Criteria andIsOldNotEqualTo(String value) {
            addCriterion("is_old <>", value, "isOld");
            return (Criteria) this;
        }

        public Criteria andIsOldGreaterThan(String value) {
            addCriterion("is_old >", value, "isOld");
            return (Criteria) this;
        }

        public Criteria andIsOldGreaterThanOrEqualTo(String value) {
            addCriterion("is_old >=", value, "isOld");
            return (Criteria) this;
        }

        public Criteria andIsOldLessThan(String value) {
            addCriterion("is_old <", value, "isOld");
            return (Criteria) this;
        }

        public Criteria andIsOldLessThanOrEqualTo(String value) {
            addCriterion("is_old <=", value, "isOld");
            return (Criteria) this;
        }

        public Criteria andIsOldLike(String value) {
            addCriterion("is_old like", value, "isOld");
            return (Criteria) this;
        }

        public Criteria andIsOldNotLike(String value) {
            addCriterion("is_old not like", value, "isOld");
            return (Criteria) this;
        }

        public Criteria andIsOldIn(List<String> values) {
            addCriterion("is_old in", values, "isOld");
            return (Criteria) this;
        }

        public Criteria andIsOldNotIn(List<String> values) {
            addCriterion("is_old not in", values, "isOld");
            return (Criteria) this;
        }

        public Criteria andIsOldBetween(String value1, String value2) {
            addCriterion("is_old between", value1, value2, "isOld");
            return (Criteria) this;
        }

        public Criteria andIsOldNotBetween(String value1, String value2) {
            addCriterion("is_old not between", value1, value2, "isOld");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedIsNull() {
            addCriterion("is_qualified is null");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedIsNotNull() {
            addCriterion("is_qualified is not null");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedEqualTo(String value) {
            addCriterion("is_qualified =", value, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedNotEqualTo(String value) {
            addCriterion("is_qualified <>", value, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedGreaterThan(String value) {
            addCriterion("is_qualified >", value, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedGreaterThanOrEqualTo(String value) {
            addCriterion("is_qualified >=", value, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedLessThan(String value) {
            addCriterion("is_qualified <", value, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedLessThanOrEqualTo(String value) {
            addCriterion("is_qualified <=", value, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedLike(String value) {
            addCriterion("is_qualified like", value, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedNotLike(String value) {
            addCriterion("is_qualified not like", value, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedIn(List<String> values) {
            addCriterion("is_qualified in", values, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedNotIn(List<String> values) {
            addCriterion("is_qualified not in", values, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedBetween(String value1, String value2) {
            addCriterion("is_qualified between", value1, value2, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedNotBetween(String value1, String value2) {
            addCriterion("is_qualified not between", value1, value2, "isQualified");
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

        public Criteria andToolNameIsNull() {
            addCriterion("tool_name is null");
            return (Criteria) this;
        }

        public Criteria andToolNameIsNotNull() {
            addCriterion("tool_name is not null");
            return (Criteria) this;
        }

        public Criteria andToolNameEqualTo(String value) {
            addCriterion("tool_name =", value, "toolName");
            return (Criteria) this;
        }

        public Criteria andToolNameNotEqualTo(String value) {
            addCriterion("tool_name <>", value, "toolName");
            return (Criteria) this;
        }

        public Criteria andToolNameGreaterThan(String value) {
            addCriterion("tool_name >", value, "toolName");
            return (Criteria) this;
        }

        public Criteria andToolNameGreaterThanOrEqualTo(String value) {
            addCriterion("tool_name >=", value, "toolName");
            return (Criteria) this;
        }

        public Criteria andToolNameLessThan(String value) {
            addCriterion("tool_name <", value, "toolName");
            return (Criteria) this;
        }

        public Criteria andToolNameLessThanOrEqualTo(String value) {
            addCriterion("tool_name <=", value, "toolName");
            return (Criteria) this;
        }

        public Criteria andToolNameLike(String value) {
            addCriterion("tool_name like", value, "toolName");
            return (Criteria) this;
        }

        public Criteria andToolNameNotLike(String value) {
            addCriterion("tool_name not like", value, "toolName");
            return (Criteria) this;
        }

        public Criteria andToolNameIn(List<String> values) {
            addCriterion("tool_name in", values, "toolName");
            return (Criteria) this;
        }

        public Criteria andToolNameNotIn(List<String> values) {
            addCriterion("tool_name not in", values, "toolName");
            return (Criteria) this;
        }

        public Criteria andToolNameBetween(String value1, String value2) {
            addCriterion("tool_name between", value1, value2, "toolName");
            return (Criteria) this;
        }

        public Criteria andToolNameNotBetween(String value1, String value2) {
            addCriterion("tool_name not between", value1, value2, "toolName");
            return (Criteria) this;
        }

        public Criteria andToolTypeIsNull() {
            addCriterion("tool_type is null");
            return (Criteria) this;
        }

        public Criteria andToolTypeIsNotNull() {
            addCriterion("tool_type is not null");
            return (Criteria) this;
        }

        public Criteria andToolTypeEqualTo(String value) {
            addCriterion("tool_type =", value, "toolType");
            return (Criteria) this;
        }

        public Criteria andToolTypeNotEqualTo(String value) {
            addCriterion("tool_type <>", value, "toolType");
            return (Criteria) this;
        }

        public Criteria andToolTypeGreaterThan(String value) {
            addCriterion("tool_type >", value, "toolType");
            return (Criteria) this;
        }

        public Criteria andToolTypeGreaterThanOrEqualTo(String value) {
            addCriterion("tool_type >=", value, "toolType");
            return (Criteria) this;
        }

        public Criteria andToolTypeLessThan(String value) {
            addCriterion("tool_type <", value, "toolType");
            return (Criteria) this;
        }

        public Criteria andToolTypeLessThanOrEqualTo(String value) {
            addCriterion("tool_type <=", value, "toolType");
            return (Criteria) this;
        }

        public Criteria andToolTypeLike(String value) {
            addCriterion("tool_type like", value, "toolType");
            return (Criteria) this;
        }

        public Criteria andToolTypeNotLike(String value) {
            addCriterion("tool_type not like", value, "toolType");
            return (Criteria) this;
        }

        public Criteria andToolTypeIn(List<String> values) {
            addCriterion("tool_type in", values, "toolType");
            return (Criteria) this;
        }

        public Criteria andToolTypeNotIn(List<String> values) {
            addCriterion("tool_type not in", values, "toolType");
            return (Criteria) this;
        }

        public Criteria andToolTypeBetween(String value1, String value2) {
            addCriterion("tool_type between", value1, value2, "toolType");
            return (Criteria) this;
        }

        public Criteria andToolTypeNotBetween(String value1, String value2) {
            addCriterion("tool_type not between", value1, value2, "toolType");
            return (Criteria) this;
        }

        public Criteria andToolVersionIsNull() {
            addCriterion("tool_version is null");
            return (Criteria) this;
        }

        public Criteria andToolVersionIsNotNull() {
            addCriterion("tool_version is not null");
            return (Criteria) this;
        }

        public Criteria andToolVersionEqualTo(String value) {
            addCriterion("tool_version =", value, "toolVersion");
            return (Criteria) this;
        }

        public Criteria andToolVersionNotEqualTo(String value) {
            addCriterion("tool_version <>", value, "toolVersion");
            return (Criteria) this;
        }

        public Criteria andToolVersionGreaterThan(String value) {
            addCriterion("tool_version >", value, "toolVersion");
            return (Criteria) this;
        }

        public Criteria andToolVersionGreaterThanOrEqualTo(String value) {
            addCriterion("tool_version >=", value, "toolVersion");
            return (Criteria) this;
        }

        public Criteria andToolVersionLessThan(String value) {
            addCriterion("tool_version <", value, "toolVersion");
            return (Criteria) this;
        }

        public Criteria andToolVersionLessThanOrEqualTo(String value) {
            addCriterion("tool_version <=", value, "toolVersion");
            return (Criteria) this;
        }

        public Criteria andToolVersionLike(String value) {
            addCriterion("tool_version like", value, "toolVersion");
            return (Criteria) this;
        }

        public Criteria andToolVersionNotLike(String value) {
            addCriterion("tool_version not like", value, "toolVersion");
            return (Criteria) this;
        }

        public Criteria andToolVersionIn(List<String> values) {
            addCriterion("tool_version in", values, "toolVersion");
            return (Criteria) this;
        }

        public Criteria andToolVersionNotIn(List<String> values) {
            addCriterion("tool_version not in", values, "toolVersion");
            return (Criteria) this;
        }

        public Criteria andToolVersionBetween(String value1, String value2) {
            addCriterion("tool_version between", value1, value2, "toolVersion");
            return (Criteria) this;
        }

        public Criteria andToolVersionNotBetween(String value1, String value2) {
            addCriterion("tool_version not between", value1, value2, "toolVersion");
            return (Criteria) this;
        }

        public Criteria andToolPhotoIsNull() {
            addCriterion("tool_photo is null");
            return (Criteria) this;
        }

        public Criteria andToolPhotoIsNotNull() {
            addCriterion("tool_photo is not null");
            return (Criteria) this;
        }

        public Criteria andToolPhotoEqualTo(String value) {
            addCriterion("tool_photo =", value, "toolPhoto");
            return (Criteria) this;
        }

        public Criteria andToolPhotoNotEqualTo(String value) {
            addCriterion("tool_photo <>", value, "toolPhoto");
            return (Criteria) this;
        }

        public Criteria andToolPhotoGreaterThan(String value) {
            addCriterion("tool_photo >", value, "toolPhoto");
            return (Criteria) this;
        }

        public Criteria andToolPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("tool_photo >=", value, "toolPhoto");
            return (Criteria) this;
        }

        public Criteria andToolPhotoLessThan(String value) {
            addCriterion("tool_photo <", value, "toolPhoto");
            return (Criteria) this;
        }

        public Criteria andToolPhotoLessThanOrEqualTo(String value) {
            addCriterion("tool_photo <=", value, "toolPhoto");
            return (Criteria) this;
        }

        public Criteria andToolPhotoLike(String value) {
            addCriterion("tool_photo like", value, "toolPhoto");
            return (Criteria) this;
        }

        public Criteria andToolPhotoNotLike(String value) {
            addCriterion("tool_photo not like", value, "toolPhoto");
            return (Criteria) this;
        }

        public Criteria andToolPhotoIn(List<String> values) {
            addCriterion("tool_photo in", values, "toolPhoto");
            return (Criteria) this;
        }

        public Criteria andToolPhotoNotIn(List<String> values) {
            addCriterion("tool_photo not in", values, "toolPhoto");
            return (Criteria) this;
        }

        public Criteria andToolPhotoBetween(String value1, String value2) {
            addCriterion("tool_photo between", value1, value2, "toolPhoto");
            return (Criteria) this;
        }

        public Criteria andToolPhotoNotBetween(String value1, String value2) {
            addCriterion("tool_photo not between", value1, value2, "toolPhoto");
            return (Criteria) this;
        }

        public Criteria andToolPersonIsNull() {
            addCriterion("tool_person is null");
            return (Criteria) this;
        }

        public Criteria andToolPersonIsNotNull() {
            addCriterion("tool_person is not null");
            return (Criteria) this;
        }

        public Criteria andToolPersonEqualTo(String value) {
            addCriterion("tool_person =", value, "toolPerson");
            return (Criteria) this;
        }

        public Criteria andToolPersonNotEqualTo(String value) {
            addCriterion("tool_person <>", value, "toolPerson");
            return (Criteria) this;
        }

        public Criteria andToolPersonGreaterThan(String value) {
            addCriterion("tool_person >", value, "toolPerson");
            return (Criteria) this;
        }

        public Criteria andToolPersonGreaterThanOrEqualTo(String value) {
            addCriterion("tool_person >=", value, "toolPerson");
            return (Criteria) this;
        }

        public Criteria andToolPersonLessThan(String value) {
            addCriterion("tool_person <", value, "toolPerson");
            return (Criteria) this;
        }

        public Criteria andToolPersonLessThanOrEqualTo(String value) {
            addCriterion("tool_person <=", value, "toolPerson");
            return (Criteria) this;
        }

        public Criteria andToolPersonLike(String value) {
            addCriterion("tool_person like", value, "toolPerson");
            return (Criteria) this;
        }

        public Criteria andToolPersonNotLike(String value) {
            addCriterion("tool_person not like", value, "toolPerson");
            return (Criteria) this;
        }

        public Criteria andToolPersonIn(List<String> values) {
            addCriterion("tool_person in", values, "toolPerson");
            return (Criteria) this;
        }

        public Criteria andToolPersonNotIn(List<String> values) {
            addCriterion("tool_person not in", values, "toolPerson");
            return (Criteria) this;
        }

        public Criteria andToolPersonBetween(String value1, String value2) {
            addCriterion("tool_person between", value1, value2, "toolPerson");
            return (Criteria) this;
        }

        public Criteria andToolPersonNotBetween(String value1, String value2) {
            addCriterion("tool_person not between", value1, value2, "toolPerson");
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

        public Criteria andValidTillIsNull() {
            addCriterion("valid_till is null");
            return (Criteria) this;
        }

        public Criteria andValidTillIsNotNull() {
            addCriterion("valid_till is not null");
            return (Criteria) this;
        }

        public Criteria andValidTillEqualTo(String value) {
            addCriterion("valid_till =", value, "validTill");
            return (Criteria) this;
        }

        public Criteria andValidTillNotEqualTo(String value) {
            addCriterion("valid_till <>", value, "validTill");
            return (Criteria) this;
        }

        public Criteria andValidTillGreaterThan(String value) {
            addCriterion("valid_till >", value, "validTill");
            return (Criteria) this;
        }

        public Criteria andValidTillGreaterThanOrEqualTo(String value) {
            addCriterion("valid_till >=", value, "validTill");
            return (Criteria) this;
        }

        public Criteria andValidTillLessThan(String value) {
            addCriterion("valid_till <", value, "validTill");
            return (Criteria) this;
        }

        public Criteria andValidTillLessThanOrEqualTo(String value) {
            addCriterion("valid_till <=", value, "validTill");
            return (Criteria) this;
        }

        public Criteria andValidTillLike(String value) {
            addCriterion("valid_till like", value, "validTill");
            return (Criteria) this;
        }

        public Criteria andValidTillNotLike(String value) {
            addCriterion("valid_till not like", value, "validTill");
            return (Criteria) this;
        }

        public Criteria andValidTillIn(List<String> values) {
            addCriterion("valid_till in", values, "validTill");
            return (Criteria) this;
        }

        public Criteria andValidTillNotIn(List<String> values) {
            addCriterion("valid_till not in", values, "validTill");
            return (Criteria) this;
        }

        public Criteria andValidTillBetween(String value1, String value2) {
            addCriterion("valid_till between", value1, value2, "validTill");
            return (Criteria) this;
        }

        public Criteria andValidTillNotBetween(String value1, String value2) {
            addCriterion("valid_till not between", value1, value2, "validTill");
            return (Criteria) this;
        }

        public Criteria andExitDateIsNull() {
            addCriterion("exit_date is null");
            return (Criteria) this;
        }

        public Criteria andExitDateIsNotNull() {
            addCriterion("exit_date is not null");
            return (Criteria) this;
        }

        public Criteria andExitDateEqualTo(String value) {
            addCriterion("exit_date =", value, "exitDate");
            return (Criteria) this;
        }

        public Criteria andExitDateNotEqualTo(String value) {
            addCriterion("exit_date <>", value, "exitDate");
            return (Criteria) this;
        }

        public Criteria andExitDateGreaterThan(String value) {
            addCriterion("exit_date >", value, "exitDate");
            return (Criteria) this;
        }

        public Criteria andExitDateGreaterThanOrEqualTo(String value) {
            addCriterion("exit_date >=", value, "exitDate");
            return (Criteria) this;
        }

        public Criteria andExitDateLessThan(String value) {
            addCriterion("exit_date <", value, "exitDate");
            return (Criteria) this;
        }

        public Criteria andExitDateLessThanOrEqualTo(String value) {
            addCriterion("exit_date <=", value, "exitDate");
            return (Criteria) this;
        }

        public Criteria andExitDateLike(String value) {
            addCriterion("exit_date like", value, "exitDate");
            return (Criteria) this;
        }

        public Criteria andExitDateNotLike(String value) {
            addCriterion("exit_date not like", value, "exitDate");
            return (Criteria) this;
        }

        public Criteria andExitDateIn(List<String> values) {
            addCriterion("exit_date in", values, "exitDate");
            return (Criteria) this;
        }

        public Criteria andExitDateNotIn(List<String> values) {
            addCriterion("exit_date not in", values, "exitDate");
            return (Criteria) this;
        }

        public Criteria andExitDateBetween(String value1, String value2) {
            addCriterion("exit_date between", value1, value2, "exitDate");
            return (Criteria) this;
        }

        public Criteria andExitDateNotBetween(String value1, String value2) {
            addCriterion("exit_date not between", value1, value2, "exitDate");
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