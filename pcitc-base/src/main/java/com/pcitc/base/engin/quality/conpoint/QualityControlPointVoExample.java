package com.pcitc.base.engin.quality.conpoint;

import java.util.ArrayList;
import java.util.List;

public class QualityControlPointVoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public QualityControlPointVoExample() {
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

        public Criteria andPointNameIsNull() {
            addCriterion("point_name is null");
            return (Criteria) this;
        }

        public Criteria andPointNameIsNotNull() {
            addCriterion("point_name is not null");
            return (Criteria) this;
        }

        public Criteria andPointNameEqualTo(String value) {
            addCriterion("point_name =", value, "pointName");
            return (Criteria) this;
        }

        public Criteria andPointNameNotEqualTo(String value) {
            addCriterion("point_name <>", value, "pointName");
            return (Criteria) this;
        }

        public Criteria andPointNameGreaterThan(String value) {
            addCriterion("point_name >", value, "pointName");
            return (Criteria) this;
        }

        public Criteria andPointNameGreaterThanOrEqualTo(String value) {
            addCriterion("point_name >=", value, "pointName");
            return (Criteria) this;
        }

        public Criteria andPointNameLessThan(String value) {
            addCriterion("point_name <", value, "pointName");
            return (Criteria) this;
        }

        public Criteria andPointNameLessThanOrEqualTo(String value) {
            addCriterion("point_name <=", value, "pointName");
            return (Criteria) this;
        }

        public Criteria andPointNameLike(String value) {
            addCriterion("point_name like", value, "pointName");
            return (Criteria) this;
        }

        public Criteria andPointNameNotLike(String value) {
            addCriterion("point_name not like", value, "pointName");
            return (Criteria) this;
        }

        public Criteria andPointNameIn(List<String> values) {
            addCriterion("point_name in", values, "pointName");
            return (Criteria) this;
        }

        public Criteria andPointNameNotIn(List<String> values) {
            addCriterion("point_name not in", values, "pointName");
            return (Criteria) this;
        }

        public Criteria andPointNameBetween(String value1, String value2) {
            addCriterion("point_name between", value1, value2, "pointName");
            return (Criteria) this;
        }

        public Criteria andPointNameNotBetween(String value1, String value2) {
            addCriterion("point_name not between", value1, value2, "pointName");
            return (Criteria) this;
        }

        public Criteria andPointLevelIsNull() {
            addCriterion("point_level is null");
            return (Criteria) this;
        }

        public Criteria andPointLevelIsNotNull() {
            addCriterion("point_level is not null");
            return (Criteria) this;
        }

        public Criteria andPointLevelEqualTo(String value) {
            addCriterion("point_level =", value, "pointLevel");
            return (Criteria) this;
        }

        public Criteria andPointLevelNotEqualTo(String value) {
            addCriterion("point_level <>", value, "pointLevel");
            return (Criteria) this;
        }

        public Criteria andPointLevelGreaterThan(String value) {
            addCriterion("point_level >", value, "pointLevel");
            return (Criteria) this;
        }

        public Criteria andPointLevelGreaterThanOrEqualTo(String value) {
            addCriterion("point_level >=", value, "pointLevel");
            return (Criteria) this;
        }

        public Criteria andPointLevelLessThan(String value) {
            addCriterion("point_level <", value, "pointLevel");
            return (Criteria) this;
        }

        public Criteria andPointLevelLessThanOrEqualTo(String value) {
            addCriterion("point_level <=", value, "pointLevel");
            return (Criteria) this;
        }

        public Criteria andPointLevelLike(String value) {
            addCriterion("point_level like", value, "pointLevel");
            return (Criteria) this;
        }

        public Criteria andPointLevelNotLike(String value) {
            addCriterion("point_level not like", value, "pointLevel");
            return (Criteria) this;
        }

        public Criteria andPointLevelIn(List<String> values) {
            addCriterion("point_level in", values, "pointLevel");
            return (Criteria) this;
        }

        public Criteria andPointLevelNotIn(List<String> values) {
            addCriterion("point_level not in", values, "pointLevel");
            return (Criteria) this;
        }

        public Criteria andPointLevelBetween(String value1, String value2) {
            addCriterion("point_level between", value1, value2, "pointLevel");
            return (Criteria) this;
        }

        public Criteria andPointLevelNotBetween(String value1, String value2) {
            addCriterion("point_level not between", value1, value2, "pointLevel");
            return (Criteria) this;
        }

        public Criteria andProfessionalNameIsNull() {
            addCriterion("professional_name is null");
            return (Criteria) this;
        }

        public Criteria andProfessionalNameIsNotNull() {
            addCriterion("professional_name is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionalNameEqualTo(String value) {
            addCriterion("professional_name =", value, "professionalName");
            return (Criteria) this;
        }

        public Criteria andProfessionalNameNotEqualTo(String value) {
            addCriterion("professional_name <>", value, "professionalName");
            return (Criteria) this;
        }

        public Criteria andProfessionalNameGreaterThan(String value) {
            addCriterion("professional_name >", value, "professionalName");
            return (Criteria) this;
        }

        public Criteria andProfessionalNameGreaterThanOrEqualTo(String value) {
            addCriterion("professional_name >=", value, "professionalName");
            return (Criteria) this;
        }

        public Criteria andProfessionalNameLessThan(String value) {
            addCriterion("professional_name <", value, "professionalName");
            return (Criteria) this;
        }

        public Criteria andProfessionalNameLessThanOrEqualTo(String value) {
            addCriterion("professional_name <=", value, "professionalName");
            return (Criteria) this;
        }

        public Criteria andProfessionalNameLike(String value) {
            addCriterion("professional_name like", value, "professionalName");
            return (Criteria) this;
        }

        public Criteria andProfessionalNameNotLike(String value) {
            addCriterion("professional_name not like", value, "professionalName");
            return (Criteria) this;
        }

        public Criteria andProfessionalNameIn(List<String> values) {
            addCriterion("professional_name in", values, "professionalName");
            return (Criteria) this;
        }

        public Criteria andProfessionalNameNotIn(List<String> values) {
            addCriterion("professional_name not in", values, "professionalName");
            return (Criteria) this;
        }

        public Criteria andProfessionalNameBetween(String value1, String value2) {
            addCriterion("professional_name between", value1, value2, "professionalName");
            return (Criteria) this;
        }

        public Criteria andProfessionalNameNotBetween(String value1, String value2) {
            addCriterion("professional_name not between", value1, value2, "professionalName");
            return (Criteria) this;
        }

        public Criteria andInspectionTimeIsNull() {
            addCriterion("inspection_time is null");
            return (Criteria) this;
        }

        public Criteria andInspectionTimeIsNotNull() {
            addCriterion("inspection_time is not null");
            return (Criteria) this;
        }

        public Criteria andInspectionTimeEqualTo(String value) {
            addCriterion("inspection_time =", value, "inspectionTime");
            return (Criteria) this;
        }

        public Criteria andInspectionTimeNotEqualTo(String value) {
            addCriterion("inspection_time <>", value, "inspectionTime");
            return (Criteria) this;
        }

        public Criteria andInspectionTimeGreaterThan(String value) {
            addCriterion("inspection_time >", value, "inspectionTime");
            return (Criteria) this;
        }

        public Criteria andInspectionTimeGreaterThanOrEqualTo(String value) {
            addCriterion("inspection_time >=", value, "inspectionTime");
            return (Criteria) this;
        }

        public Criteria andInspectionTimeLessThan(String value) {
            addCriterion("inspection_time <", value, "inspectionTime");
            return (Criteria) this;
        }

        public Criteria andInspectionTimeLessThanOrEqualTo(String value) {
            addCriterion("inspection_time <=", value, "inspectionTime");
            return (Criteria) this;
        }

        public Criteria andInspectionTimeLike(String value) {
            addCriterion("inspection_time like", value, "inspectionTime");
            return (Criteria) this;
        }

        public Criteria andInspectionTimeNotLike(String value) {
            addCriterion("inspection_time not like", value, "inspectionTime");
            return (Criteria) this;
        }

        public Criteria andInspectionTimeIn(List<String> values) {
            addCriterion("inspection_time in", values, "inspectionTime");
            return (Criteria) this;
        }

        public Criteria andInspectionTimeNotIn(List<String> values) {
            addCriterion("inspection_time not in", values, "inspectionTime");
            return (Criteria) this;
        }

        public Criteria andInspectionTimeBetween(String value1, String value2) {
            addCriterion("inspection_time between", value1, value2, "inspectionTime");
            return (Criteria) this;
        }

        public Criteria andInspectionTimeNotBetween(String value1, String value2) {
            addCriterion("inspection_time not between", value1, value2, "inspectionTime");
            return (Criteria) this;
        }

        public Criteria andMainMaterialsIsNull() {
            addCriterion("main_materials is null");
            return (Criteria) this;
        }

        public Criteria andMainMaterialsIsNotNull() {
            addCriterion("main_materials is not null");
            return (Criteria) this;
        }

        public Criteria andMainMaterialsEqualTo(String value) {
            addCriterion("main_materials =", value, "mainMaterials");
            return (Criteria) this;
        }

        public Criteria andMainMaterialsNotEqualTo(String value) {
            addCriterion("main_materials <>", value, "mainMaterials");
            return (Criteria) this;
        }

        public Criteria andMainMaterialsGreaterThan(String value) {
            addCriterion("main_materials >", value, "mainMaterials");
            return (Criteria) this;
        }

        public Criteria andMainMaterialsGreaterThanOrEqualTo(String value) {
            addCriterion("main_materials >=", value, "mainMaterials");
            return (Criteria) this;
        }

        public Criteria andMainMaterialsLessThan(String value) {
            addCriterion("main_materials <", value, "mainMaterials");
            return (Criteria) this;
        }

        public Criteria andMainMaterialsLessThanOrEqualTo(String value) {
            addCriterion("main_materials <=", value, "mainMaterials");
            return (Criteria) this;
        }

        public Criteria andMainMaterialsLike(String value) {
            addCriterion("main_materials like", value, "mainMaterials");
            return (Criteria) this;
        }

        public Criteria andMainMaterialsNotLike(String value) {
            addCriterion("main_materials not like", value, "mainMaterials");
            return (Criteria) this;
        }

        public Criteria andMainMaterialsIn(List<String> values) {
            addCriterion("main_materials in", values, "mainMaterials");
            return (Criteria) this;
        }

        public Criteria andMainMaterialsNotIn(List<String> values) {
            addCriterion("main_materials not in", values, "mainMaterials");
            return (Criteria) this;
        }

        public Criteria andMainMaterialsBetween(String value1, String value2) {
            addCriterion("main_materials between", value1, value2, "mainMaterials");
            return (Criteria) this;
        }

        public Criteria andMainMaterialsNotBetween(String value1, String value2) {
            addCriterion("main_materials not between", value1, value2, "mainMaterials");
            return (Criteria) this;
        }

        public Criteria andStoppingPointIsNull() {
            addCriterion("stopping_point is null");
            return (Criteria) this;
        }

        public Criteria andStoppingPointIsNotNull() {
            addCriterion("stopping_point is not null");
            return (Criteria) this;
        }

        public Criteria andStoppingPointEqualTo(String value) {
            addCriterion("stopping_point =", value, "stoppingPoint");
            return (Criteria) this;
        }

        public Criteria andStoppingPointNotEqualTo(String value) {
            addCriterion("stopping_point <>", value, "stoppingPoint");
            return (Criteria) this;
        }

        public Criteria andStoppingPointGreaterThan(String value) {
            addCriterion("stopping_point >", value, "stoppingPoint");
            return (Criteria) this;
        }

        public Criteria andStoppingPointGreaterThanOrEqualTo(String value) {
            addCriterion("stopping_point >=", value, "stoppingPoint");
            return (Criteria) this;
        }

        public Criteria andStoppingPointLessThan(String value) {
            addCriterion("stopping_point <", value, "stoppingPoint");
            return (Criteria) this;
        }

        public Criteria andStoppingPointLessThanOrEqualTo(String value) {
            addCriterion("stopping_point <=", value, "stoppingPoint");
            return (Criteria) this;
        }

        public Criteria andStoppingPointLike(String value) {
            addCriterion("stopping_point like", value, "stoppingPoint");
            return (Criteria) this;
        }

        public Criteria andStoppingPointNotLike(String value) {
            addCriterion("stopping_point not like", value, "stoppingPoint");
            return (Criteria) this;
        }

        public Criteria andStoppingPointIn(List<String> values) {
            addCriterion("stopping_point in", values, "stoppingPoint");
            return (Criteria) this;
        }

        public Criteria andStoppingPointNotIn(List<String> values) {
            addCriterion("stopping_point not in", values, "stoppingPoint");
            return (Criteria) this;
        }

        public Criteria andStoppingPointBetween(String value1, String value2) {
            addCriterion("stopping_point between", value1, value2, "stoppingPoint");
            return (Criteria) this;
        }

        public Criteria andStoppingPointNotBetween(String value1, String value2) {
            addCriterion("stopping_point not between", value1, value2, "stoppingPoint");
            return (Criteria) this;
        }

        public Criteria andSelfCheckingDateIsNull() {
            addCriterion("self_checking_date is null");
            return (Criteria) this;
        }

        public Criteria andSelfCheckingDateIsNotNull() {
            addCriterion("self_checking_date is not null");
            return (Criteria) this;
        }

        public Criteria andSelfCheckingDateEqualTo(String value) {
            addCriterion("self_checking_date =", value, "selfCheckingDate");
            return (Criteria) this;
        }

        public Criteria andSelfCheckingDateNotEqualTo(String value) {
            addCriterion("self_checking_date <>", value, "selfCheckingDate");
            return (Criteria) this;
        }

        public Criteria andSelfCheckingDateGreaterThan(String value) {
            addCriterion("self_checking_date >", value, "selfCheckingDate");
            return (Criteria) this;
        }

        public Criteria andSelfCheckingDateGreaterThanOrEqualTo(String value) {
            addCriterion("self_checking_date >=", value, "selfCheckingDate");
            return (Criteria) this;
        }

        public Criteria andSelfCheckingDateLessThan(String value) {
            addCriterion("self_checking_date <", value, "selfCheckingDate");
            return (Criteria) this;
        }

        public Criteria andSelfCheckingDateLessThanOrEqualTo(String value) {
            addCriterion("self_checking_date <=", value, "selfCheckingDate");
            return (Criteria) this;
        }

        public Criteria andSelfCheckingDateLike(String value) {
            addCriterion("self_checking_date like", value, "selfCheckingDate");
            return (Criteria) this;
        }

        public Criteria andSelfCheckingDateNotLike(String value) {
            addCriterion("self_checking_date not like", value, "selfCheckingDate");
            return (Criteria) this;
        }

        public Criteria andSelfCheckingDateIn(List<String> values) {
            addCriterion("self_checking_date in", values, "selfCheckingDate");
            return (Criteria) this;
        }

        public Criteria andSelfCheckingDateNotIn(List<String> values) {
            addCriterion("self_checking_date not in", values, "selfCheckingDate");
            return (Criteria) this;
        }

        public Criteria andSelfCheckingDateBetween(String value1, String value2) {
            addCriterion("self_checking_date between", value1, value2, "selfCheckingDate");
            return (Criteria) this;
        }

        public Criteria andSelfCheckingDateNotBetween(String value1, String value2) {
            addCriterion("self_checking_date not between", value1, value2, "selfCheckingDate");
            return (Criteria) this;
        }

        public Criteria andInspectionStatusIsNull() {
            addCriterion("inspection_status is null");
            return (Criteria) this;
        }

        public Criteria andInspectionStatusIsNotNull() {
            addCriterion("inspection_status is not null");
            return (Criteria) this;
        }

        public Criteria andInspectionStatusEqualTo(String value) {
            addCriterion("inspection_status =", value, "inspectionStatus");
            return (Criteria) this;
        }

        public Criteria andInspectionStatusNotEqualTo(String value) {
            addCriterion("inspection_status <>", value, "inspectionStatus");
            return (Criteria) this;
        }

        public Criteria andInspectionStatusGreaterThan(String value) {
            addCriterion("inspection_status >", value, "inspectionStatus");
            return (Criteria) this;
        }

        public Criteria andInspectionStatusGreaterThanOrEqualTo(String value) {
            addCriterion("inspection_status >=", value, "inspectionStatus");
            return (Criteria) this;
        }

        public Criteria andInspectionStatusLessThan(String value) {
            addCriterion("inspection_status <", value, "inspectionStatus");
            return (Criteria) this;
        }

        public Criteria andInspectionStatusLessThanOrEqualTo(String value) {
            addCriterion("inspection_status <=", value, "inspectionStatus");
            return (Criteria) this;
        }

        public Criteria andInspectionStatusLike(String value) {
            addCriterion("inspection_status like", value, "inspectionStatus");
            return (Criteria) this;
        }

        public Criteria andInspectionStatusNotLike(String value) {
            addCriterion("inspection_status not like", value, "inspectionStatus");
            return (Criteria) this;
        }

        public Criteria andInspectionStatusIn(List<String> values) {
            addCriterion("inspection_status in", values, "inspectionStatus");
            return (Criteria) this;
        }

        public Criteria andInspectionStatusNotIn(List<String> values) {
            addCriterion("inspection_status not in", values, "inspectionStatus");
            return (Criteria) this;
        }

        public Criteria andInspectionStatusBetween(String value1, String value2) {
            addCriterion("inspection_status between", value1, value2, "inspectionStatus");
            return (Criteria) this;
        }

        public Criteria andInspectionStatusNotBetween(String value1, String value2) {
            addCriterion("inspection_status not between", value1, value2, "inspectionStatus");
            return (Criteria) this;
        }

        public Criteria andInspectionCountIsNull() {
            addCriterion("inspection_count is null");
            return (Criteria) this;
        }

        public Criteria andInspectionCountIsNotNull() {
            addCriterion("inspection_count is not null");
            return (Criteria) this;
        }

        public Criteria andInspectionCountEqualTo(String value) {
            addCriterion("inspection_count =", value, "inspectionCount");
            return (Criteria) this;
        }

        public Criteria andInspectionCountNotEqualTo(String value) {
            addCriterion("inspection_count <>", value, "inspectionCount");
            return (Criteria) this;
        }

        public Criteria andInspectionCountGreaterThan(String value) {
            addCriterion("inspection_count >", value, "inspectionCount");
            return (Criteria) this;
        }

        public Criteria andInspectionCountGreaterThanOrEqualTo(String value) {
            addCriterion("inspection_count >=", value, "inspectionCount");
            return (Criteria) this;
        }

        public Criteria andInspectionCountLessThan(String value) {
            addCriterion("inspection_count <", value, "inspectionCount");
            return (Criteria) this;
        }

        public Criteria andInspectionCountLessThanOrEqualTo(String value) {
            addCriterion("inspection_count <=", value, "inspectionCount");
            return (Criteria) this;
        }

        public Criteria andInspectionCountLike(String value) {
            addCriterion("inspection_count like", value, "inspectionCount");
            return (Criteria) this;
        }

        public Criteria andInspectionCountNotLike(String value) {
            addCriterion("inspection_count not like", value, "inspectionCount");
            return (Criteria) this;
        }

        public Criteria andInspectionCountIn(List<String> values) {
            addCriterion("inspection_count in", values, "inspectionCount");
            return (Criteria) this;
        }

        public Criteria andInspectionCountNotIn(List<String> values) {
            addCriterion("inspection_count not in", values, "inspectionCount");
            return (Criteria) this;
        }

        public Criteria andInspectionCountBetween(String value1, String value2) {
            addCriterion("inspection_count between", value1, value2, "inspectionCount");
            return (Criteria) this;
        }

        public Criteria andInspectionCountNotBetween(String value1, String value2) {
            addCriterion("inspection_count not between", value1, value2, "inspectionCount");
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