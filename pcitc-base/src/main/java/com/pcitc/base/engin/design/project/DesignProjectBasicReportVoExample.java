package com.pcitc.base.engin.design.project;

import java.util.ArrayList;
import java.util.List;

public class DesignProjectBasicReportVoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DesignProjectBasicReportVoExample() {
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

        public Criteria andDesignUnitIsNull() {
            addCriterion("design_unit is null");
            return (Criteria) this;
        }

        public Criteria andDesignUnitIsNotNull() {
            addCriterion("design_unit is not null");
            return (Criteria) this;
        }

        public Criteria andDesignUnitEqualTo(String value) {
            addCriterion("design_unit =", value, "designUnit");
            return (Criteria) this;
        }

        public Criteria andDesignUnitNotEqualTo(String value) {
            addCriterion("design_unit <>", value, "designUnit");
            return (Criteria) this;
        }

        public Criteria andDesignUnitGreaterThan(String value) {
            addCriterion("design_unit >", value, "designUnit");
            return (Criteria) this;
        }

        public Criteria andDesignUnitGreaterThanOrEqualTo(String value) {
            addCriterion("design_unit >=", value, "designUnit");
            return (Criteria) this;
        }

        public Criteria andDesignUnitLessThan(String value) {
            addCriterion("design_unit <", value, "designUnit");
            return (Criteria) this;
        }

        public Criteria andDesignUnitLessThanOrEqualTo(String value) {
            addCriterion("design_unit <=", value, "designUnit");
            return (Criteria) this;
        }

        public Criteria andDesignUnitLike(String value) {
            addCriterion("design_unit like", value, "designUnit");
            return (Criteria) this;
        }

        public Criteria andDesignUnitNotLike(String value) {
            addCriterion("design_unit not like", value, "designUnit");
            return (Criteria) this;
        }

        public Criteria andDesignUnitIn(List<String> values) {
            addCriterion("design_unit in", values, "designUnit");
            return (Criteria) this;
        }

        public Criteria andDesignUnitNotIn(List<String> values) {
            addCriterion("design_unit not in", values, "designUnit");
            return (Criteria) this;
        }

        public Criteria andDesignUnitBetween(String value1, String value2) {
            addCriterion("design_unit between", value1, value2, "designUnit");
            return (Criteria) this;
        }

        public Criteria andDesignUnitNotBetween(String value1, String value2) {
            addCriterion("design_unit not between", value1, value2, "designUnit");
            return (Criteria) this;
        }

        public Criteria andProjectFromIsNull() {
            addCriterion("project_from is null");
            return (Criteria) this;
        }

        public Criteria andProjectFromIsNotNull() {
            addCriterion("project_from is not null");
            return (Criteria) this;
        }

        public Criteria andProjectFromEqualTo(String value) {
            addCriterion("project_from =", value, "projectFrom");
            return (Criteria) this;
        }

        public Criteria andProjectFromNotEqualTo(String value) {
            addCriterion("project_from <>", value, "projectFrom");
            return (Criteria) this;
        }

        public Criteria andProjectFromGreaterThan(String value) {
            addCriterion("project_from >", value, "projectFrom");
            return (Criteria) this;
        }

        public Criteria andProjectFromGreaterThanOrEqualTo(String value) {
            addCriterion("project_from >=", value, "projectFrom");
            return (Criteria) this;
        }

        public Criteria andProjectFromLessThan(String value) {
            addCriterion("project_from <", value, "projectFrom");
            return (Criteria) this;
        }

        public Criteria andProjectFromLessThanOrEqualTo(String value) {
            addCriterion("project_from <=", value, "projectFrom");
            return (Criteria) this;
        }

        public Criteria andProjectFromLike(String value) {
            addCriterion("project_from like", value, "projectFrom");
            return (Criteria) this;
        }

        public Criteria andProjectFromNotLike(String value) {
            addCriterion("project_from not like", value, "projectFrom");
            return (Criteria) this;
        }

        public Criteria andProjectFromIn(List<String> values) {
            addCriterion("project_from in", values, "projectFrom");
            return (Criteria) this;
        }

        public Criteria andProjectFromNotIn(List<String> values) {
            addCriterion("project_from not in", values, "projectFrom");
            return (Criteria) this;
        }

        public Criteria andProjectFromBetween(String value1, String value2) {
            addCriterion("project_from between", value1, value2, "projectFrom");
            return (Criteria) this;
        }

        public Criteria andProjectFromNotBetween(String value1, String value2) {
            addCriterion("project_from not between", value1, value2, "projectFrom");
            return (Criteria) this;
        }

        public Criteria andKypfNoIsNull() {
            addCriterion("kypf_no is null");
            return (Criteria) this;
        }

        public Criteria andKypfNoIsNotNull() {
            addCriterion("kypf_no is not null");
            return (Criteria) this;
        }

        public Criteria andKypfNoEqualTo(String value) {
            addCriterion("kypf_no =", value, "kypfNo");
            return (Criteria) this;
        }

        public Criteria andKypfNoNotEqualTo(String value) {
            addCriterion("kypf_no <>", value, "kypfNo");
            return (Criteria) this;
        }

        public Criteria andKypfNoGreaterThan(String value) {
            addCriterion("kypf_no >", value, "kypfNo");
            return (Criteria) this;
        }

        public Criteria andKypfNoGreaterThanOrEqualTo(String value) {
            addCriterion("kypf_no >=", value, "kypfNo");
            return (Criteria) this;
        }

        public Criteria andKypfNoLessThan(String value) {
            addCriterion("kypf_no <", value, "kypfNo");
            return (Criteria) this;
        }

        public Criteria andKypfNoLessThanOrEqualTo(String value) {
            addCriterion("kypf_no <=", value, "kypfNo");
            return (Criteria) this;
        }

        public Criteria andKypfNoLike(String value) {
            addCriterion("kypf_no like", value, "kypfNo");
            return (Criteria) this;
        }

        public Criteria andKypfNoNotLike(String value) {
            addCriterion("kypf_no not like", value, "kypfNo");
            return (Criteria) this;
        }

        public Criteria andKypfNoIn(List<String> values) {
            addCriterion("kypf_no in", values, "kypfNo");
            return (Criteria) this;
        }

        public Criteria andKypfNoNotIn(List<String> values) {
            addCriterion("kypf_no not in", values, "kypfNo");
            return (Criteria) this;
        }

        public Criteria andKypfNoBetween(String value1, String value2) {
            addCriterion("kypf_no between", value1, value2, "kypfNo");
            return (Criteria) this;
        }

        public Criteria andKypfNoNotBetween(String value1, String value2) {
            addCriterion("kypf_no not between", value1, value2, "kypfNo");
            return (Criteria) this;
        }

        public Criteria andJcsjpfNoIsNull() {
            addCriterion("jcsjpf_no is null");
            return (Criteria) this;
        }

        public Criteria andJcsjpfNoIsNotNull() {
            addCriterion("jcsjpf_no is not null");
            return (Criteria) this;
        }

        public Criteria andJcsjpfNoEqualTo(String value) {
            addCriterion("jcsjpf_no =", value, "jcsjpfNo");
            return (Criteria) this;
        }

        public Criteria andJcsjpfNoNotEqualTo(String value) {
            addCriterion("jcsjpf_no <>", value, "jcsjpfNo");
            return (Criteria) this;
        }

        public Criteria andJcsjpfNoGreaterThan(String value) {
            addCriterion("jcsjpf_no >", value, "jcsjpfNo");
            return (Criteria) this;
        }

        public Criteria andJcsjpfNoGreaterThanOrEqualTo(String value) {
            addCriterion("jcsjpf_no >=", value, "jcsjpfNo");
            return (Criteria) this;
        }

        public Criteria andJcsjpfNoLessThan(String value) {
            addCriterion("jcsjpf_no <", value, "jcsjpfNo");
            return (Criteria) this;
        }

        public Criteria andJcsjpfNoLessThanOrEqualTo(String value) {
            addCriterion("jcsjpf_no <=", value, "jcsjpfNo");
            return (Criteria) this;
        }

        public Criteria andJcsjpfNoLike(String value) {
            addCriterion("jcsjpf_no like", value, "jcsjpfNo");
            return (Criteria) this;
        }

        public Criteria andJcsjpfNoNotLike(String value) {
            addCriterion("jcsjpf_no not like", value, "jcsjpfNo");
            return (Criteria) this;
        }

        public Criteria andJcsjpfNoIn(List<String> values) {
            addCriterion("jcsjpf_no in", values, "jcsjpfNo");
            return (Criteria) this;
        }

        public Criteria andJcsjpfNoNotIn(List<String> values) {
            addCriterion("jcsjpf_no not in", values, "jcsjpfNo");
            return (Criteria) this;
        }

        public Criteria andJcsjpfNoBetween(String value1, String value2) {
            addCriterion("jcsjpf_no between", value1, value2, "jcsjpfNo");
            return (Criteria) this;
        }

        public Criteria andJcsjpfNoNotBetween(String value1, String value2) {
            addCriterion("jcsjpf_no not between", value1, value2, "jcsjpfNo");
            return (Criteria) this;
        }

        public Criteria andJcsjpfDateIsNull() {
            addCriterion("jcsjpf_date is null");
            return (Criteria) this;
        }

        public Criteria andJcsjpfDateIsNotNull() {
            addCriterion("jcsjpf_date is not null");
            return (Criteria) this;
        }

        public Criteria andJcsjpfDateEqualTo(String value) {
            addCriterion("jcsjpf_date =", value, "jcsjpfDate");
            return (Criteria) this;
        }

        public Criteria andJcsjpfDateNotEqualTo(String value) {
            addCriterion("jcsjpf_date <>", value, "jcsjpfDate");
            return (Criteria) this;
        }

        public Criteria andJcsjpfDateGreaterThan(String value) {
            addCriterion("jcsjpf_date >", value, "jcsjpfDate");
            return (Criteria) this;
        }

        public Criteria andJcsjpfDateGreaterThanOrEqualTo(String value) {
            addCriterion("jcsjpf_date >=", value, "jcsjpfDate");
            return (Criteria) this;
        }

        public Criteria andJcsjpfDateLessThan(String value) {
            addCriterion("jcsjpf_date <", value, "jcsjpfDate");
            return (Criteria) this;
        }

        public Criteria andJcsjpfDateLessThanOrEqualTo(String value) {
            addCriterion("jcsjpf_date <=", value, "jcsjpfDate");
            return (Criteria) this;
        }

        public Criteria andJcsjpfDateLike(String value) {
            addCriterion("jcsjpf_date like", value, "jcsjpfDate");
            return (Criteria) this;
        }

        public Criteria andJcsjpfDateNotLike(String value) {
            addCriterion("jcsjpf_date not like", value, "jcsjpfDate");
            return (Criteria) this;
        }

        public Criteria andJcsjpfDateIn(List<String> values) {
            addCriterion("jcsjpf_date in", values, "jcsjpfDate");
            return (Criteria) this;
        }

        public Criteria andJcsjpfDateNotIn(List<String> values) {
            addCriterion("jcsjpf_date not in", values, "jcsjpfDate");
            return (Criteria) this;
        }

        public Criteria andJcsjpfDateBetween(String value1, String value2) {
            addCriterion("jcsjpf_date between", value1, value2, "jcsjpfDate");
            return (Criteria) this;
        }

        public Criteria andJcsjpfDateNotBetween(String value1, String value2) {
            addCriterion("jcsjpf_date not between", value1, value2, "jcsjpfDate");
            return (Criteria) this;
        }

        public Criteria andProjectBudgetIsNull() {
            addCriterion("project_budget is null");
            return (Criteria) this;
        }

        public Criteria andProjectBudgetIsNotNull() {
            addCriterion("project_budget is not null");
            return (Criteria) this;
        }

        public Criteria andProjectBudgetEqualTo(String value) {
            addCriterion("project_budget =", value, "projectBudget");
            return (Criteria) this;
        }

        public Criteria andProjectBudgetNotEqualTo(String value) {
            addCriterion("project_budget <>", value, "projectBudget");
            return (Criteria) this;
        }

        public Criteria andProjectBudgetGreaterThan(String value) {
            addCriterion("project_budget >", value, "projectBudget");
            return (Criteria) this;
        }

        public Criteria andProjectBudgetGreaterThanOrEqualTo(String value) {
            addCriterion("project_budget >=", value, "projectBudget");
            return (Criteria) this;
        }

        public Criteria andProjectBudgetLessThan(String value) {
            addCriterion("project_budget <", value, "projectBudget");
            return (Criteria) this;
        }

        public Criteria andProjectBudgetLessThanOrEqualTo(String value) {
            addCriterion("project_budget <=", value, "projectBudget");
            return (Criteria) this;
        }

        public Criteria andProjectBudgetLike(String value) {
            addCriterion("project_budget like", value, "projectBudget");
            return (Criteria) this;
        }

        public Criteria andProjectBudgetNotLike(String value) {
            addCriterion("project_budget not like", value, "projectBudget");
            return (Criteria) this;
        }

        public Criteria andProjectBudgetIn(List<String> values) {
            addCriterion("project_budget in", values, "projectBudget");
            return (Criteria) this;
        }

        public Criteria andProjectBudgetNotIn(List<String> values) {
            addCriterion("project_budget not in", values, "projectBudget");
            return (Criteria) this;
        }

        public Criteria andProjectBudgetBetween(String value1, String value2) {
            addCriterion("project_budget between", value1, value2, "projectBudget");
            return (Criteria) this;
        }

        public Criteria andProjectBudgetNotBetween(String value1, String value2) {
            addCriterion("project_budget not between", value1, value2, "projectBudget");
            return (Criteria) this;
        }

        public Criteria andWorkonDateIsNull() {
            addCriterion("workon_date is null");
            return (Criteria) this;
        }

        public Criteria andWorkonDateIsNotNull() {
            addCriterion("workon_date is not null");
            return (Criteria) this;
        }

        public Criteria andWorkonDateEqualTo(String value) {
            addCriterion("workon_date =", value, "workonDate");
            return (Criteria) this;
        }

        public Criteria andWorkonDateNotEqualTo(String value) {
            addCriterion("workon_date <>", value, "workonDate");
            return (Criteria) this;
        }

        public Criteria andWorkonDateGreaterThan(String value) {
            addCriterion("workon_date >", value, "workonDate");
            return (Criteria) this;
        }

        public Criteria andWorkonDateGreaterThanOrEqualTo(String value) {
            addCriterion("workon_date >=", value, "workonDate");
            return (Criteria) this;
        }

        public Criteria andWorkonDateLessThan(String value) {
            addCriterion("workon_date <", value, "workonDate");
            return (Criteria) this;
        }

        public Criteria andWorkonDateLessThanOrEqualTo(String value) {
            addCriterion("workon_date <=", value, "workonDate");
            return (Criteria) this;
        }

        public Criteria andWorkonDateLike(String value) {
            addCriterion("workon_date like", value, "workonDate");
            return (Criteria) this;
        }

        public Criteria andWorkonDateNotLike(String value) {
            addCriterion("workon_date not like", value, "workonDate");
            return (Criteria) this;
        }

        public Criteria andWorkonDateIn(List<String> values) {
            addCriterion("workon_date in", values, "workonDate");
            return (Criteria) this;
        }

        public Criteria andWorkonDateNotIn(List<String> values) {
            addCriterion("workon_date not in", values, "workonDate");
            return (Criteria) this;
        }

        public Criteria andWorkonDateBetween(String value1, String value2) {
            addCriterion("workon_date between", value1, value2, "workonDate");
            return (Criteria) this;
        }

        public Criteria andWorkonDateNotBetween(String value1, String value2) {
            addCriterion("workon_date not between", value1, value2, "workonDate");
            return (Criteria) this;
        }

        public Criteria andWorkoffDateIsNull() {
            addCriterion("workoff_date is null");
            return (Criteria) this;
        }

        public Criteria andWorkoffDateIsNotNull() {
            addCriterion("workoff_date is not null");
            return (Criteria) this;
        }

        public Criteria andWorkoffDateEqualTo(String value) {
            addCriterion("workoff_date =", value, "workoffDate");
            return (Criteria) this;
        }

        public Criteria andWorkoffDateNotEqualTo(String value) {
            addCriterion("workoff_date <>", value, "workoffDate");
            return (Criteria) this;
        }

        public Criteria andWorkoffDateGreaterThan(String value) {
            addCriterion("workoff_date >", value, "workoffDate");
            return (Criteria) this;
        }

        public Criteria andWorkoffDateGreaterThanOrEqualTo(String value) {
            addCriterion("workoff_date >=", value, "workoffDate");
            return (Criteria) this;
        }

        public Criteria andWorkoffDateLessThan(String value) {
            addCriterion("workoff_date <", value, "workoffDate");
            return (Criteria) this;
        }

        public Criteria andWorkoffDateLessThanOrEqualTo(String value) {
            addCriterion("workoff_date <=", value, "workoffDate");
            return (Criteria) this;
        }

        public Criteria andWorkoffDateLike(String value) {
            addCriterion("workoff_date like", value, "workoffDate");
            return (Criteria) this;
        }

        public Criteria andWorkoffDateNotLike(String value) {
            addCriterion("workoff_date not like", value, "workoffDate");
            return (Criteria) this;
        }

        public Criteria andWorkoffDateIn(List<String> values) {
            addCriterion("workoff_date in", values, "workoffDate");
            return (Criteria) this;
        }

        public Criteria andWorkoffDateNotIn(List<String> values) {
            addCriterion("workoff_date not in", values, "workoffDate");
            return (Criteria) this;
        }

        public Criteria andWorkoffDateBetween(String value1, String value2) {
            addCriterion("workoff_date between", value1, value2, "workoffDate");
            return (Criteria) this;
        }

        public Criteria andWorkoffDateNotBetween(String value1, String value2) {
            addCriterion("workoff_date not between", value1, value2, "workoffDate");
            return (Criteria) this;
        }

        public Criteria andJcsjsbNoIsNull() {
            addCriterion("jcsjsb_no is null");
            return (Criteria) this;
        }

        public Criteria andJcsjsbNoIsNotNull() {
            addCriterion("jcsjsb_no is not null");
            return (Criteria) this;
        }

        public Criteria andJcsjsbNoEqualTo(String value) {
            addCriterion("jcsjsb_no =", value, "jcsjsbNo");
            return (Criteria) this;
        }

        public Criteria andJcsjsbNoNotEqualTo(String value) {
            addCriterion("jcsjsb_no <>", value, "jcsjsbNo");
            return (Criteria) this;
        }

        public Criteria andJcsjsbNoGreaterThan(String value) {
            addCriterion("jcsjsb_no >", value, "jcsjsbNo");
            return (Criteria) this;
        }

        public Criteria andJcsjsbNoGreaterThanOrEqualTo(String value) {
            addCriterion("jcsjsb_no >=", value, "jcsjsbNo");
            return (Criteria) this;
        }

        public Criteria andJcsjsbNoLessThan(String value) {
            addCriterion("jcsjsb_no <", value, "jcsjsbNo");
            return (Criteria) this;
        }

        public Criteria andJcsjsbNoLessThanOrEqualTo(String value) {
            addCriterion("jcsjsb_no <=", value, "jcsjsbNo");
            return (Criteria) this;
        }

        public Criteria andJcsjsbNoLike(String value) {
            addCriterion("jcsjsb_no like", value, "jcsjsbNo");
            return (Criteria) this;
        }

        public Criteria andJcsjsbNoNotLike(String value) {
            addCriterion("jcsjsb_no not like", value, "jcsjsbNo");
            return (Criteria) this;
        }

        public Criteria andJcsjsbNoIn(List<String> values) {
            addCriterion("jcsjsb_no in", values, "jcsjsbNo");
            return (Criteria) this;
        }

        public Criteria andJcsjsbNoNotIn(List<String> values) {
            addCriterion("jcsjsb_no not in", values, "jcsjsbNo");
            return (Criteria) this;
        }

        public Criteria andJcsjsbNoBetween(String value1, String value2) {
            addCriterion("jcsjsb_no between", value1, value2, "jcsjsbNo");
            return (Criteria) this;
        }

        public Criteria andJcsjsbNoNotBetween(String value1, String value2) {
            addCriterion("jcsjsb_no not between", value1, value2, "jcsjsbNo");
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