package com.pcitc.base.engin.project.vo;

import java.util.ArrayList;
import java.util.List;

public class ProjectVoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public ProjectVoExample() {
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

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
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
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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

        public Criteria andProjectScaleIsNull() {
            addCriterion("project_scale is null");
            return (Criteria) this;
        }

        public Criteria andProjectScaleIsNotNull() {
            addCriterion("project_scale is not null");
            return (Criteria) this;
        }

        public Criteria andProjectScaleEqualTo(String value) {
            addCriterion("project_scale =", value, "projectScale");
            return (Criteria) this;
        }

        public Criteria andProjectScaleNotEqualTo(String value) {
            addCriterion("project_scale <>", value, "projectScale");
            return (Criteria) this;
        }

        public Criteria andProjectScaleGreaterThan(String value) {
            addCriterion("project_scale >", value, "projectScale");
            return (Criteria) this;
        }

        public Criteria andProjectScaleGreaterThanOrEqualTo(String value) {
            addCriterion("project_scale >=", value, "projectScale");
            return (Criteria) this;
        }

        public Criteria andProjectScaleLessThan(String value) {
            addCriterion("project_scale <", value, "projectScale");
            return (Criteria) this;
        }

        public Criteria andProjectScaleLessThanOrEqualTo(String value) {
            addCriterion("project_scale <=", value, "projectScale");
            return (Criteria) this;
        }

        public Criteria andProjectScaleLike(String value) {
            addCriterion("project_scale like", value, "projectScale");
            return (Criteria) this;
        }

        public Criteria andProjectScaleNotLike(String value) {
            addCriterion("project_scale not like", value, "projectScale");
            return (Criteria) this;
        }

        public Criteria andProjectScaleIn(List<String> values) {
            addCriterion("project_scale in", values, "projectScale");
            return (Criteria) this;
        }

        public Criteria andProjectScaleNotIn(List<String> values) {
            addCriterion("project_scale not in", values, "projectScale");
            return (Criteria) this;
        }

        public Criteria andProjectScaleBetween(String value1, String value2) {
            addCriterion("project_scale between", value1, value2, "projectScale");
            return (Criteria) this;
        }

        public Criteria andProjectScaleNotBetween(String value1, String value2) {
            addCriterion("project_scale not between", value1, value2, "projectScale");
            return (Criteria) this;
        }

        public Criteria andInvestmentEstimationIsNull() {
            addCriterion("investment_estimation is null");
            return (Criteria) this;
        }

        public Criteria andInvestmentEstimationIsNotNull() {
            addCriterion("investment_estimation is not null");
            return (Criteria) this;
        }

        public Criteria andInvestmentEstimationEqualTo(String value) {
            addCriterion("investment_estimation =", value, "investmentEstimation");
            return (Criteria) this;
        }

        public Criteria andInvestmentEstimationNotEqualTo(String value) {
            addCriterion("investment_estimation <>", value, "investmentEstimation");
            return (Criteria) this;
        }

        public Criteria andInvestmentEstimationGreaterThan(String value) {
            addCriterion("investment_estimation >", value, "investmentEstimation");
            return (Criteria) this;
        }

        public Criteria andInvestmentEstimationGreaterThanOrEqualTo(String value) {
            addCriterion("investment_estimation >=", value, "investmentEstimation");
            return (Criteria) this;
        }

        public Criteria andInvestmentEstimationLessThan(String value) {
            addCriterion("investment_estimation <", value, "investmentEstimation");
            return (Criteria) this;
        }

        public Criteria andInvestmentEstimationLessThanOrEqualTo(String value) {
            addCriterion("investment_estimation <=", value, "investmentEstimation");
            return (Criteria) this;
        }

        public Criteria andInvestmentEstimationLike(String value) {
            addCriterion("investment_estimation like", value, "investmentEstimation");
            return (Criteria) this;
        }

        public Criteria andInvestmentEstimationNotLike(String value) {
            addCriterion("investment_estimation not like", value, "investmentEstimation");
            return (Criteria) this;
        }

        public Criteria andInvestmentEstimationIn(List<String> values) {
            addCriterion("investment_estimation in", values, "investmentEstimation");
            return (Criteria) this;
        }

        public Criteria andInvestmentEstimationNotIn(List<String> values) {
            addCriterion("investment_estimation not in", values, "investmentEstimation");
            return (Criteria) this;
        }

        public Criteria andInvestmentEstimationBetween(String value1, String value2) {
            addCriterion("investment_estimation between", value1, value2, "investmentEstimation");
            return (Criteria) this;
        }

        public Criteria andInvestmentEstimationNotBetween(String value1, String value2) {
            addCriterion("investment_estimation not between", value1, value2, "investmentEstimation");
            return (Criteria) this;
        }

        public Criteria andProjectStructureIsNull() {
            addCriterion("project_structure is null");
            return (Criteria) this;
        }

        public Criteria andProjectStructureIsNotNull() {
            addCriterion("project_structure is not null");
            return (Criteria) this;
        }

        public Criteria andProjectStructureEqualTo(String value) {
            addCriterion("project_structure =", value, "projectStructure");
            return (Criteria) this;
        }

        public Criteria andProjectStructureNotEqualTo(String value) {
            addCriterion("project_structure <>", value, "projectStructure");
            return (Criteria) this;
        }

        public Criteria andProjectStructureGreaterThan(String value) {
            addCriterion("project_structure >", value, "projectStructure");
            return (Criteria) this;
        }

        public Criteria andProjectStructureGreaterThanOrEqualTo(String value) {
            addCriterion("project_structure >=", value, "projectStructure");
            return (Criteria) this;
        }

        public Criteria andProjectStructureLessThan(String value) {
            addCriterion("project_structure <", value, "projectStructure");
            return (Criteria) this;
        }

        public Criteria andProjectStructureLessThanOrEqualTo(String value) {
            addCriterion("project_structure <=", value, "projectStructure");
            return (Criteria) this;
        }

        public Criteria andProjectStructureLike(String value) {
            addCriterion("project_structure like", value, "projectStructure");
            return (Criteria) this;
        }

        public Criteria andProjectStructureNotLike(String value) {
            addCriterion("project_structure not like", value, "projectStructure");
            return (Criteria) this;
        }

        public Criteria andProjectStructureIn(List<String> values) {
            addCriterion("project_structure in", values, "projectStructure");
            return (Criteria) this;
        }

        public Criteria andProjectStructureNotIn(List<String> values) {
            addCriterion("project_structure not in", values, "projectStructure");
            return (Criteria) this;
        }

        public Criteria andProjectStructureBetween(String value1, String value2) {
            addCriterion("project_structure between", value1, value2, "projectStructure");
            return (Criteria) this;
        }

        public Criteria andProjectStructureNotBetween(String value1, String value2) {
            addCriterion("project_structure not between", value1, value2, "projectStructure");
            return (Criteria) this;
        }

        public Criteria andProjectStructureIdIsNull() {
            addCriterion("project_structure_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectStructureIdIsNotNull() {
            addCriterion("project_structure_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectStructureIdEqualTo(String value) {
            addCriterion("project_structure_id =", value, "projectStructureId");
            return (Criteria) this;
        }

        public Criteria andProjectStructureIdNotEqualTo(String value) {
            addCriterion("project_structure_id <>", value, "projectStructureId");
            return (Criteria) this;
        }

        public Criteria andProjectStructureIdGreaterThan(String value) {
            addCriterion("project_structure_id >", value, "projectStructureId");
            return (Criteria) this;
        }

        public Criteria andProjectStructureIdGreaterThanOrEqualTo(String value) {
            addCriterion("project_structure_id >=", value, "projectStructureId");
            return (Criteria) this;
        }

        public Criteria andProjectStructureIdLessThan(String value) {
            addCriterion("project_structure_id <", value, "projectStructureId");
            return (Criteria) this;
        }

        public Criteria andProjectStructureIdLessThanOrEqualTo(String value) {
            addCriterion("project_structure_id <=", value, "projectStructureId");
            return (Criteria) this;
        }

        public Criteria andProjectStructureIdLike(String value) {
            addCriterion("project_structure_id like", value, "projectStructureId");
            return (Criteria) this;
        }

        public Criteria andProjectStructureIdNotLike(String value) {
            addCriterion("project_structure_id not like", value, "projectStructureId");
            return (Criteria) this;
        }

        public Criteria andProjectStructureIdIn(List<String> values) {
            addCriterion("project_structure_id in", values, "projectStructureId");
            return (Criteria) this;
        }

        public Criteria andProjectStructureIdNotIn(List<String> values) {
            addCriterion("project_structure_id not in", values, "projectStructureId");
            return (Criteria) this;
        }

        public Criteria andProjectStructureIdBetween(String value1, String value2) {
            addCriterion("project_structure_id between", value1, value2, "projectStructureId");
            return (Criteria) this;
        }

        public Criteria andProjectStructureIdNotBetween(String value1, String value2) {
            addCriterion("project_structure_id not between", value1, value2, "projectStructureId");
            return (Criteria) this;
        }

        public Criteria andBuildUnitNameIsNull() {
            addCriterion("build_unit_name is null");
            return (Criteria) this;
        }

        public Criteria andBuildUnitNameIsNotNull() {
            addCriterion("build_unit_name is not null");
            return (Criteria) this;
        }

        public Criteria andBuildUnitNameEqualTo(String value) {
            addCriterion("build_unit_name =", value, "buildUnitName");
            return (Criteria) this;
        }

        public Criteria andBuildUnitNameNotEqualTo(String value) {
            addCriterion("build_unit_name <>", value, "buildUnitName");
            return (Criteria) this;
        }

        public Criteria andBuildUnitNameGreaterThan(String value) {
            addCriterion("build_unit_name >", value, "buildUnitName");
            return (Criteria) this;
        }

        public Criteria andBuildUnitNameGreaterThanOrEqualTo(String value) {
            addCriterion("build_unit_name >=", value, "buildUnitName");
            return (Criteria) this;
        }

        public Criteria andBuildUnitNameLessThan(String value) {
            addCriterion("build_unit_name <", value, "buildUnitName");
            return (Criteria) this;
        }

        public Criteria andBuildUnitNameLessThanOrEqualTo(String value) {
            addCriterion("build_unit_name <=", value, "buildUnitName");
            return (Criteria) this;
        }

        public Criteria andBuildUnitNameLike(String value) {
            addCriterion("build_unit_name like", value, "buildUnitName");
            return (Criteria) this;
        }

        public Criteria andBuildUnitNameNotLike(String value) {
            addCriterion("build_unit_name not like", value, "buildUnitName");
            return (Criteria) this;
        }

        public Criteria andBuildUnitNameIn(List<String> values) {
            addCriterion("build_unit_name in", values, "buildUnitName");
            return (Criteria) this;
        }

        public Criteria andBuildUnitNameNotIn(List<String> values) {
            addCriterion("build_unit_name not in", values, "buildUnitName");
            return (Criteria) this;
        }

        public Criteria andBuildUnitNameBetween(String value1, String value2) {
            addCriterion("build_unit_name between", value1, value2, "buildUnitName");
            return (Criteria) this;
        }

        public Criteria andBuildUnitNameNotBetween(String value1, String value2) {
            addCriterion("build_unit_name not between", value1, value2, "buildUnitName");
            return (Criteria) this;
        }

        public Criteria andBuildUnitIdIsNull() {
            addCriterion("build_unit_id is null");
            return (Criteria) this;
        }

        public Criteria andBuildUnitIdIsNotNull() {
            addCriterion("build_unit_id is not null");
            return (Criteria) this;
        }

        public Criteria andBuildUnitIdEqualTo(String value) {
            addCriterion("build_unit_id =", value, "buildUnitId");
            return (Criteria) this;
        }

        public Criteria andBuildUnitIdNotEqualTo(String value) {
            addCriterion("build_unit_id <>", value, "buildUnitId");
            return (Criteria) this;
        }

        public Criteria andBuildUnitIdGreaterThan(String value) {
            addCriterion("build_unit_id >", value, "buildUnitId");
            return (Criteria) this;
        }

        public Criteria andBuildUnitIdGreaterThanOrEqualTo(String value) {
            addCriterion("build_unit_id >=", value, "buildUnitId");
            return (Criteria) this;
        }

        public Criteria andBuildUnitIdLessThan(String value) {
            addCriterion("build_unit_id <", value, "buildUnitId");
            return (Criteria) this;
        }

        public Criteria andBuildUnitIdLessThanOrEqualTo(String value) {
            addCriterion("build_unit_id <=", value, "buildUnitId");
            return (Criteria) this;
        }

        public Criteria andBuildUnitIdLike(String value) {
            addCriterion("build_unit_id like", value, "buildUnitId");
            return (Criteria) this;
        }

        public Criteria andBuildUnitIdNotLike(String value) {
            addCriterion("build_unit_id not like", value, "buildUnitId");
            return (Criteria) this;
        }

        public Criteria andBuildUnitIdIn(List<String> values) {
            addCriterion("build_unit_id in", values, "buildUnitId");
            return (Criteria) this;
        }

        public Criteria andBuildUnitIdNotIn(List<String> values) {
            addCriterion("build_unit_id not in", values, "buildUnitId");
            return (Criteria) this;
        }

        public Criteria andBuildUnitIdBetween(String value1, String value2) {
            addCriterion("build_unit_id between", value1, value2, "buildUnitId");
            return (Criteria) this;
        }

        public Criteria andBuildUnitIdNotBetween(String value1, String value2) {
            addCriterion("build_unit_id not between", value1, value2, "buildUnitId");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIsNull() {
            addCriterion("project_type is null");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIsNotNull() {
            addCriterion("project_type is not null");
            return (Criteria) this;
        }

        public Criteria andProjectTypeEqualTo(String value) {
            addCriterion("project_type =", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotEqualTo(String value) {
            addCriterion("project_type <>", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeGreaterThan(String value) {
            addCriterion("project_type >", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeGreaterThanOrEqualTo(String value) {
            addCriterion("project_type >=", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLessThan(String value) {
            addCriterion("project_type <", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLessThanOrEqualTo(String value) {
            addCriterion("project_type <=", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLike(String value) {
            addCriterion("project_type like", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotLike(String value) {
            addCriterion("project_type not like", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIn(List<String> values) {
            addCriterion("project_type in", values, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotIn(List<String> values) {
            addCriterion("project_type not in", values, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeBetween(String value1, String value2) {
            addCriterion("project_type between", value1, value2, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotBetween(String value1, String value2) {
            addCriterion("project_type not between", value1, value2, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectPropertiesIsNull() {
            addCriterion("project_properties is null");
            return (Criteria) this;
        }

        public Criteria andProjectPropertiesIsNotNull() {
            addCriterion("project_properties is not null");
            return (Criteria) this;
        }

        public Criteria andProjectPropertiesEqualTo(String value) {
            addCriterion("project_properties =", value, "projectProperties");
            return (Criteria) this;
        }

        public Criteria andProjectPropertiesNotEqualTo(String value) {
            addCriterion("project_properties <>", value, "projectProperties");
            return (Criteria) this;
        }

        public Criteria andProjectPropertiesGreaterThan(String value) {
            addCriterion("project_properties >", value, "projectProperties");
            return (Criteria) this;
        }

        public Criteria andProjectPropertiesGreaterThanOrEqualTo(String value) {
            addCriterion("project_properties >=", value, "projectProperties");
            return (Criteria) this;
        }

        public Criteria andProjectPropertiesLessThan(String value) {
            addCriterion("project_properties <", value, "projectProperties");
            return (Criteria) this;
        }

        public Criteria andProjectPropertiesLessThanOrEqualTo(String value) {
            addCriterion("project_properties <=", value, "projectProperties");
            return (Criteria) this;
        }

        public Criteria andProjectPropertiesLike(String value) {
            addCriterion("project_properties like", value, "projectProperties");
            return (Criteria) this;
        }

        public Criteria andProjectPropertiesNotLike(String value) {
            addCriterion("project_properties not like", value, "projectProperties");
            return (Criteria) this;
        }

        public Criteria andProjectPropertiesIn(List<String> values) {
            addCriterion("project_properties in", values, "projectProperties");
            return (Criteria) this;
        }

        public Criteria andProjectPropertiesNotIn(List<String> values) {
            addCriterion("project_properties not in", values, "projectProperties");
            return (Criteria) this;
        }

        public Criteria andProjectPropertiesBetween(String value1, String value2) {
            addCriterion("project_properties between", value1, value2, "projectProperties");
            return (Criteria) this;
        }

        public Criteria andProjectPropertiesNotBetween(String value1, String value2) {
            addCriterion("project_properties not between", value1, value2, "projectProperties");
            return (Criteria) this;
        }

        public Criteria andBuildPropertiesIsNull() {
            addCriterion("build_properties is null");
            return (Criteria) this;
        }

        public Criteria andBuildPropertiesIsNotNull() {
            addCriterion("build_properties is not null");
            return (Criteria) this;
        }

        public Criteria andBuildPropertiesEqualTo(String value) {
            addCriterion("build_properties =", value, "buildProperties");
            return (Criteria) this;
        }

        public Criteria andBuildPropertiesNotEqualTo(String value) {
            addCriterion("build_properties <>", value, "buildProperties");
            return (Criteria) this;
        }

        public Criteria andBuildPropertiesGreaterThan(String value) {
            addCriterion("build_properties >", value, "buildProperties");
            return (Criteria) this;
        }

        public Criteria andBuildPropertiesGreaterThanOrEqualTo(String value) {
            addCriterion("build_properties >=", value, "buildProperties");
            return (Criteria) this;
        }

        public Criteria andBuildPropertiesLessThan(String value) {
            addCriterion("build_properties <", value, "buildProperties");
            return (Criteria) this;
        }

        public Criteria andBuildPropertiesLessThanOrEqualTo(String value) {
            addCriterion("build_properties <=", value, "buildProperties");
            return (Criteria) this;
        }

        public Criteria andBuildPropertiesLike(String value) {
            addCriterion("build_properties like", value, "buildProperties");
            return (Criteria) this;
        }

        public Criteria andBuildPropertiesNotLike(String value) {
            addCriterion("build_properties not like", value, "buildProperties");
            return (Criteria) this;
        }

        public Criteria andBuildPropertiesIn(List<String> values) {
            addCriterion("build_properties in", values, "buildProperties");
            return (Criteria) this;
        }

        public Criteria andBuildPropertiesNotIn(List<String> values) {
            addCriterion("build_properties not in", values, "buildProperties");
            return (Criteria) this;
        }

        public Criteria andBuildPropertiesBetween(String value1, String value2) {
            addCriterion("build_properties between", value1, value2, "buildProperties");
            return (Criteria) this;
        }

        public Criteria andBuildPropertiesNotBetween(String value1, String value2) {
            addCriterion("build_properties not between", value1, value2, "buildProperties");
            return (Criteria) this;
        }

        public Criteria andBuildLimitIsNull() {
            addCriterion("build_limit is null");
            return (Criteria) this;
        }

        public Criteria andBuildLimitIsNotNull() {
            addCriterion("build_limit is not null");
            return (Criteria) this;
        }

        public Criteria andBuildLimitEqualTo(String value) {
            addCriterion("build_limit =", value, "buildLimit");
            return (Criteria) this;
        }

        public Criteria andBuildLimitNotEqualTo(String value) {
            addCriterion("build_limit <>", value, "buildLimit");
            return (Criteria) this;
        }

        public Criteria andBuildLimitGreaterThan(String value) {
            addCriterion("build_limit >", value, "buildLimit");
            return (Criteria) this;
        }

        public Criteria andBuildLimitGreaterThanOrEqualTo(String value) {
            addCriterion("build_limit >=", value, "buildLimit");
            return (Criteria) this;
        }

        public Criteria andBuildLimitLessThan(String value) {
            addCriterion("build_limit <", value, "buildLimit");
            return (Criteria) this;
        }

        public Criteria andBuildLimitLessThanOrEqualTo(String value) {
            addCriterion("build_limit <=", value, "buildLimit");
            return (Criteria) this;
        }

        public Criteria andBuildLimitLike(String value) {
            addCriterion("build_limit like", value, "buildLimit");
            return (Criteria) this;
        }

        public Criteria andBuildLimitNotLike(String value) {
            addCriterion("build_limit not like", value, "buildLimit");
            return (Criteria) this;
        }

        public Criteria andBuildLimitIn(List<String> values) {
            addCriterion("build_limit in", values, "buildLimit");
            return (Criteria) this;
        }

        public Criteria andBuildLimitNotIn(List<String> values) {
            addCriterion("build_limit not in", values, "buildLimit");
            return (Criteria) this;
        }

        public Criteria andBuildLimitBetween(String value1, String value2) {
            addCriterion("build_limit between", value1, value2, "buildLimit");
            return (Criteria) this;
        }

        public Criteria andBuildLimitNotBetween(String value1, String value2) {
            addCriterion("build_limit not between", value1, value2, "buildLimit");
            return (Criteria) this;
        }

        public Criteria andPlanStartDateTimeIsNull() {
            addCriterion("plan_start_date_time is null");
            return (Criteria) this;
        }

        public Criteria andPlanStartDateTimeIsNotNull() {
            addCriterion("plan_start_date_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlanStartDateTimeEqualTo(String value) {
            addCriterion("plan_start_date_time =", value, "planStartDateTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartDateTimeNotEqualTo(String value) {
            addCriterion("plan_start_date_time <>", value, "planStartDateTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartDateTimeGreaterThan(String value) {
            addCriterion("plan_start_date_time >", value, "planStartDateTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartDateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("plan_start_date_time >=", value, "planStartDateTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartDateTimeLessThan(String value) {
            addCriterion("plan_start_date_time <", value, "planStartDateTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartDateTimeLessThanOrEqualTo(String value) {
            addCriterion("plan_start_date_time <=", value, "planStartDateTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartDateTimeLike(String value) {
            addCriterion("plan_start_date_time like", value, "planStartDateTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartDateTimeNotLike(String value) {
            addCriterion("plan_start_date_time not like", value, "planStartDateTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartDateTimeIn(List<String> values) {
            addCriterion("plan_start_date_time in", values, "planStartDateTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartDateTimeNotIn(List<String> values) {
            addCriterion("plan_start_date_time not in", values, "planStartDateTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartDateTimeBetween(String value1, String value2) {
            addCriterion("plan_start_date_time between", value1, value2, "planStartDateTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartDateTimeNotBetween(String value1, String value2) {
            addCriterion("plan_start_date_time not between", value1, value2, "planStartDateTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndDateTimeIsNull() {
            addCriterion("plan_end_date_time is null");
            return (Criteria) this;
        }

        public Criteria andPlanEndDateTimeIsNotNull() {
            addCriterion("plan_end_date_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlanEndDateTimeEqualTo(String value) {
            addCriterion("plan_end_date_time =", value, "planEndDateTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndDateTimeNotEqualTo(String value) {
            addCriterion("plan_end_date_time <>", value, "planEndDateTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndDateTimeGreaterThan(String value) {
            addCriterion("plan_end_date_time >", value, "planEndDateTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndDateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("plan_end_date_time >=", value, "planEndDateTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndDateTimeLessThan(String value) {
            addCriterion("plan_end_date_time <", value, "planEndDateTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndDateTimeLessThanOrEqualTo(String value) {
            addCriterion("plan_end_date_time <=", value, "planEndDateTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndDateTimeLike(String value) {
            addCriterion("plan_end_date_time like", value, "planEndDateTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndDateTimeNotLike(String value) {
            addCriterion("plan_end_date_time not like", value, "planEndDateTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndDateTimeIn(List<String> values) {
            addCriterion("plan_end_date_time in", values, "planEndDateTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndDateTimeNotIn(List<String> values) {
            addCriterion("plan_end_date_time not in", values, "planEndDateTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndDateTimeBetween(String value1, String value2) {
            addCriterion("plan_end_date_time between", value1, value2, "planEndDateTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndDateTimeNotBetween(String value1, String value2) {
            addCriterion("plan_end_date_time not between", value1, value2, "planEndDateTime");
            return (Criteria) this;
        }

        public Criteria andMustStartDateTimeIsNull() {
            addCriterion("must_start_date_time is null");
            return (Criteria) this;
        }

        public Criteria andMustStartDateTimeIsNotNull() {
            addCriterion("must_start_date_time is not null");
            return (Criteria) this;
        }

        public Criteria andMustStartDateTimeEqualTo(String value) {
            addCriterion("must_start_date_time =", value, "mustStartDateTime");
            return (Criteria) this;
        }

        public Criteria andMustStartDateTimeNotEqualTo(String value) {
            addCriterion("must_start_date_time <>", value, "mustStartDateTime");
            return (Criteria) this;
        }

        public Criteria andMustStartDateTimeGreaterThan(String value) {
            addCriterion("must_start_date_time >", value, "mustStartDateTime");
            return (Criteria) this;
        }

        public Criteria andMustStartDateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("must_start_date_time >=", value, "mustStartDateTime");
            return (Criteria) this;
        }

        public Criteria andMustStartDateTimeLessThan(String value) {
            addCriterion("must_start_date_time <", value, "mustStartDateTime");
            return (Criteria) this;
        }

        public Criteria andMustStartDateTimeLessThanOrEqualTo(String value) {
            addCriterion("must_start_date_time <=", value, "mustStartDateTime");
            return (Criteria) this;
        }

        public Criteria andMustStartDateTimeLike(String value) {
            addCriterion("must_start_date_time like", value, "mustStartDateTime");
            return (Criteria) this;
        }

        public Criteria andMustStartDateTimeNotLike(String value) {
            addCriterion("must_start_date_time not like", value, "mustStartDateTime");
            return (Criteria) this;
        }

        public Criteria andMustStartDateTimeIn(List<String> values) {
            addCriterion("must_start_date_time in", values, "mustStartDateTime");
            return (Criteria) this;
        }

        public Criteria andMustStartDateTimeNotIn(List<String> values) {
            addCriterion("must_start_date_time not in", values, "mustStartDateTime");
            return (Criteria) this;
        }

        public Criteria andMustStartDateTimeBetween(String value1, String value2) {
            addCriterion("must_start_date_time between", value1, value2, "mustStartDateTime");
            return (Criteria) this;
        }

        public Criteria andMustStartDateTimeNotBetween(String value1, String value2) {
            addCriterion("must_start_date_time not between", value1, value2, "mustStartDateTime");
            return (Criteria) this;
        }

        public Criteria andMustEndDateTimeIsNull() {
            addCriterion("must_end_date_time is null");
            return (Criteria) this;
        }

        public Criteria andMustEndDateTimeIsNotNull() {
            addCriterion("must_end_date_time is not null");
            return (Criteria) this;
        }

        public Criteria andMustEndDateTimeEqualTo(String value) {
            addCriterion("must_end_date_time =", value, "mustEndDateTime");
            return (Criteria) this;
        }

        public Criteria andMustEndDateTimeNotEqualTo(String value) {
            addCriterion("must_end_date_time <>", value, "mustEndDateTime");
            return (Criteria) this;
        }

        public Criteria andMustEndDateTimeGreaterThan(String value) {
            addCriterion("must_end_date_time >", value, "mustEndDateTime");
            return (Criteria) this;
        }

        public Criteria andMustEndDateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("must_end_date_time >=", value, "mustEndDateTime");
            return (Criteria) this;
        }

        public Criteria andMustEndDateTimeLessThan(String value) {
            addCriterion("must_end_date_time <", value, "mustEndDateTime");
            return (Criteria) this;
        }

        public Criteria andMustEndDateTimeLessThanOrEqualTo(String value) {
            addCriterion("must_end_date_time <=", value, "mustEndDateTime");
            return (Criteria) this;
        }

        public Criteria andMustEndDateTimeLike(String value) {
            addCriterion("must_end_date_time like", value, "mustEndDateTime");
            return (Criteria) this;
        }

        public Criteria andMustEndDateTimeNotLike(String value) {
            addCriterion("must_end_date_time not like", value, "mustEndDateTime");
            return (Criteria) this;
        }

        public Criteria andMustEndDateTimeIn(List<String> values) {
            addCriterion("must_end_date_time in", values, "mustEndDateTime");
            return (Criteria) this;
        }

        public Criteria andMustEndDateTimeNotIn(List<String> values) {
            addCriterion("must_end_date_time not in", values, "mustEndDateTime");
            return (Criteria) this;
        }

        public Criteria andMustEndDateTimeBetween(String value1, String value2) {
            addCriterion("must_end_date_time between", value1, value2, "mustEndDateTime");
            return (Criteria) this;
        }

        public Criteria andMustEndDateTimeNotBetween(String value1, String value2) {
            addCriterion("must_end_date_time not between", value1, value2, "mustEndDateTime");
            return (Criteria) this;
        }

        public Criteria andPlanCenterDateTimeIsNull() {
            addCriterion("plan_center_date_time is null");
            return (Criteria) this;
        }

        public Criteria andPlanCenterDateTimeIsNotNull() {
            addCriterion("plan_center_date_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlanCenterDateTimeEqualTo(String value) {
            addCriterion("plan_center_date_time =", value, "planCenterDateTime");
            return (Criteria) this;
        }

        public Criteria andPlanCenterDateTimeNotEqualTo(String value) {
            addCriterion("plan_center_date_time <>", value, "planCenterDateTime");
            return (Criteria) this;
        }

        public Criteria andPlanCenterDateTimeGreaterThan(String value) {
            addCriterion("plan_center_date_time >", value, "planCenterDateTime");
            return (Criteria) this;
        }

        public Criteria andPlanCenterDateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("plan_center_date_time >=", value, "planCenterDateTime");
            return (Criteria) this;
        }

        public Criteria andPlanCenterDateTimeLessThan(String value) {
            addCriterion("plan_center_date_time <", value, "planCenterDateTime");
            return (Criteria) this;
        }

        public Criteria andPlanCenterDateTimeLessThanOrEqualTo(String value) {
            addCriterion("plan_center_date_time <=", value, "planCenterDateTime");
            return (Criteria) this;
        }

        public Criteria andPlanCenterDateTimeLike(String value) {
            addCriterion("plan_center_date_time like", value, "planCenterDateTime");
            return (Criteria) this;
        }

        public Criteria andPlanCenterDateTimeNotLike(String value) {
            addCriterion("plan_center_date_time not like", value, "planCenterDateTime");
            return (Criteria) this;
        }

        public Criteria andPlanCenterDateTimeIn(List<String> values) {
            addCriterion("plan_center_date_time in", values, "planCenterDateTime");
            return (Criteria) this;
        }

        public Criteria andPlanCenterDateTimeNotIn(List<String> values) {
            addCriterion("plan_center_date_time not in", values, "planCenterDateTime");
            return (Criteria) this;
        }

        public Criteria andPlanCenterDateTimeBetween(String value1, String value2) {
            addCriterion("plan_center_date_time between", value1, value2, "planCenterDateTime");
            return (Criteria) this;
        }

        public Criteria andPlanCenterDateTimeNotBetween(String value1, String value2) {
            addCriterion("plan_center_date_time not between", value1, value2, "planCenterDateTime");
            return (Criteria) this;
        }

        public Criteria andJobPrefixIsNull() {
            addCriterion("job_prefix is null");
            return (Criteria) this;
        }

        public Criteria andJobPrefixIsNotNull() {
            addCriterion("job_prefix is not null");
            return (Criteria) this;
        }

        public Criteria andJobPrefixEqualTo(String value) {
            addCriterion("job_prefix =", value, "jobPrefix");
            return (Criteria) this;
        }

        public Criteria andJobPrefixNotEqualTo(String value) {
            addCriterion("job_prefix <>", value, "jobPrefix");
            return (Criteria) this;
        }

        public Criteria andJobPrefixGreaterThan(String value) {
            addCriterion("job_prefix >", value, "jobPrefix");
            return (Criteria) this;
        }

        public Criteria andJobPrefixGreaterThanOrEqualTo(String value) {
            addCriterion("job_prefix >=", value, "jobPrefix");
            return (Criteria) this;
        }

        public Criteria andJobPrefixLessThan(String value) {
            addCriterion("job_prefix <", value, "jobPrefix");
            return (Criteria) this;
        }

        public Criteria andJobPrefixLessThanOrEqualTo(String value) {
            addCriterion("job_prefix <=", value, "jobPrefix");
            return (Criteria) this;
        }

        public Criteria andJobPrefixLike(String value) {
            addCriterion("job_prefix like", value, "jobPrefix");
            return (Criteria) this;
        }

        public Criteria andJobPrefixNotLike(String value) {
            addCriterion("job_prefix not like", value, "jobPrefix");
            return (Criteria) this;
        }

        public Criteria andJobPrefixIn(List<String> values) {
            addCriterion("job_prefix in", values, "jobPrefix");
            return (Criteria) this;
        }

        public Criteria andJobPrefixNotIn(List<String> values) {
            addCriterion("job_prefix not in", values, "jobPrefix");
            return (Criteria) this;
        }

        public Criteria andJobPrefixBetween(String value1, String value2) {
            addCriterion("job_prefix between", value1, value2, "jobPrefix");
            return (Criteria) this;
        }

        public Criteria andJobPrefixNotBetween(String value1, String value2) {
            addCriterion("job_prefix not between", value1, value2, "jobPrefix");
            return (Criteria) this;
        }

        public Criteria andJobSuffixIsNull() {
            addCriterion("job_suffix is null");
            return (Criteria) this;
        }

        public Criteria andJobSuffixIsNotNull() {
            addCriterion("job_suffix is not null");
            return (Criteria) this;
        }

        public Criteria andJobSuffixEqualTo(String value) {
            addCriterion("job_suffix =", value, "jobSuffix");
            return (Criteria) this;
        }

        public Criteria andJobSuffixNotEqualTo(String value) {
            addCriterion("job_suffix <>", value, "jobSuffix");
            return (Criteria) this;
        }

        public Criteria andJobSuffixGreaterThan(String value) {
            addCriterion("job_suffix >", value, "jobSuffix");
            return (Criteria) this;
        }

        public Criteria andJobSuffixGreaterThanOrEqualTo(String value) {
            addCriterion("job_suffix >=", value, "jobSuffix");
            return (Criteria) this;
        }

        public Criteria andJobSuffixLessThan(String value) {
            addCriterion("job_suffix <", value, "jobSuffix");
            return (Criteria) this;
        }

        public Criteria andJobSuffixLessThanOrEqualTo(String value) {
            addCriterion("job_suffix <=", value, "jobSuffix");
            return (Criteria) this;
        }

        public Criteria andJobSuffixLike(String value) {
            addCriterion("job_suffix like", value, "jobSuffix");
            return (Criteria) this;
        }

        public Criteria andJobSuffixNotLike(String value) {
            addCriterion("job_suffix not like", value, "jobSuffix");
            return (Criteria) this;
        }

        public Criteria andJobSuffixIn(List<String> values) {
            addCriterion("job_suffix in", values, "jobSuffix");
            return (Criteria) this;
        }

        public Criteria andJobSuffixNotIn(List<String> values) {
            addCriterion("job_suffix not in", values, "jobSuffix");
            return (Criteria) this;
        }

        public Criteria andJobSuffixBetween(String value1, String value2) {
            addCriterion("job_suffix between", value1, value2, "jobSuffix");
            return (Criteria) this;
        }

        public Criteria andJobSuffixNotBetween(String value1, String value2) {
            addCriterion("job_suffix not between", value1, value2, "jobSuffix");
            return (Criteria) this;
        }

        public Criteria andIncrementIsNull() {
            addCriterion("increment is null");
            return (Criteria) this;
        }

        public Criteria andIncrementIsNotNull() {
            addCriterion("increment is not null");
            return (Criteria) this;
        }

        public Criteria andIncrementEqualTo(String value) {
            addCriterion("increment =", value, "increment");
            return (Criteria) this;
        }

        public Criteria andIncrementNotEqualTo(String value) {
            addCriterion("increment <>", value, "increment");
            return (Criteria) this;
        }

        public Criteria andIncrementGreaterThan(String value) {
            addCriterion("increment >", value, "increment");
            return (Criteria) this;
        }

        public Criteria andIncrementGreaterThanOrEqualTo(String value) {
            addCriterion("increment >=", value, "increment");
            return (Criteria) this;
        }

        public Criteria andIncrementLessThan(String value) {
            addCriterion("increment <", value, "increment");
            return (Criteria) this;
        }

        public Criteria andIncrementLessThanOrEqualTo(String value) {
            addCriterion("increment <=", value, "increment");
            return (Criteria) this;
        }

        public Criteria andIncrementLike(String value) {
            addCriterion("increment like", value, "increment");
            return (Criteria) this;
        }

        public Criteria andIncrementNotLike(String value) {
            addCriterion("increment not like", value, "increment");
            return (Criteria) this;
        }

        public Criteria andIncrementIn(List<String> values) {
            addCriterion("increment in", values, "increment");
            return (Criteria) this;
        }

        public Criteria andIncrementNotIn(List<String> values) {
            addCriterion("increment not in", values, "increment");
            return (Criteria) this;
        }

        public Criteria andIncrementBetween(String value1, String value2) {
            addCriterion("increment between", value1, value2, "increment");
            return (Criteria) this;
        }

        public Criteria andIncrementNotBetween(String value1, String value2) {
            addCriterion("increment not between", value1, value2, "increment");
            return (Criteria) this;
        }

        public Criteria andProjectStatusIsNull() {
            addCriterion("project_status is null");
            return (Criteria) this;
        }

        public Criteria andProjectStatusIsNotNull() {
            addCriterion("project_status is not null");
            return (Criteria) this;
        }

        public Criteria andProjectStatusEqualTo(String value) {
            addCriterion("project_status =", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusNotEqualTo(String value) {
            addCriterion("project_status <>", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusGreaterThan(String value) {
            addCriterion("project_status >", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusGreaterThanOrEqualTo(String value) {
            addCriterion("project_status >=", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusLessThan(String value) {
            addCriterion("project_status <", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusLessThanOrEqualTo(String value) {
            addCriterion("project_status <=", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusLike(String value) {
            addCriterion("project_status like", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusNotLike(String value) {
            addCriterion("project_status not like", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusIn(List<String> values) {
            addCriterion("project_status in", values, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusNotIn(List<String> values) {
            addCriterion("project_status not in", values, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusBetween(String value1, String value2) {
            addCriterion("project_status between", value1, value2, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusNotBetween(String value1, String value2) {
            addCriterion("project_status not between", value1, value2, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectGenreIsNull() {
            addCriterion("project_genre is null");
            return (Criteria) this;
        }

        public Criteria andProjectGenreIsNotNull() {
            addCriterion("project_genre is not null");
            return (Criteria) this;
        }

        public Criteria andProjectGenreEqualTo(String value) {
            addCriterion("project_genre =", value, "projectGenre");
            return (Criteria) this;
        }

        public Criteria andProjectGenreNotEqualTo(String value) {
            addCriterion("project_genre <>", value, "projectGenre");
            return (Criteria) this;
        }

        public Criteria andProjectGenreGreaterThan(String value) {
            addCriterion("project_genre >", value, "projectGenre");
            return (Criteria) this;
        }

        public Criteria andProjectGenreGreaterThanOrEqualTo(String value) {
            addCriterion("project_genre >=", value, "projectGenre");
            return (Criteria) this;
        }

        public Criteria andProjectGenreLessThan(String value) {
            addCriterion("project_genre <", value, "projectGenre");
            return (Criteria) this;
        }

        public Criteria andProjectGenreLessThanOrEqualTo(String value) {
            addCriterion("project_genre <=", value, "projectGenre");
            return (Criteria) this;
        }

        public Criteria andProjectGenreLike(String value) {
            addCriterion("project_genre like", value, "projectGenre");
            return (Criteria) this;
        }

        public Criteria andProjectGenreNotLike(String value) {
            addCriterion("project_genre not like", value, "projectGenre");
            return (Criteria) this;
        }

        public Criteria andProjectGenreIn(List<String> values) {
            addCriterion("project_genre in", values, "projectGenre");
            return (Criteria) this;
        }

        public Criteria andProjectGenreNotIn(List<String> values) {
            addCriterion("project_genre not in", values, "projectGenre");
            return (Criteria) this;
        }

        public Criteria andProjectGenreBetween(String value1, String value2) {
            addCriterion("project_genre between", value1, value2, "projectGenre");
            return (Criteria) this;
        }

        public Criteria andProjectGenreNotBetween(String value1, String value2) {
            addCriterion("project_genre not between", value1, value2, "projectGenre");
            return (Criteria) this;
        }

        public Criteria andBuildContentIsNull() {
            addCriterion("build_content is null");
            return (Criteria) this;
        }

        public Criteria andBuildContentIsNotNull() {
            addCriterion("build_content is not null");
            return (Criteria) this;
        }

        public Criteria andBuildContentEqualTo(String value) {
            addCriterion("build_content =", value, "buildContent");
            return (Criteria) this;
        }

        public Criteria andBuildContentNotEqualTo(String value) {
            addCriterion("build_content <>", value, "buildContent");
            return (Criteria) this;
        }

        public Criteria andBuildContentGreaterThan(String value) {
            addCriterion("build_content >", value, "buildContent");
            return (Criteria) this;
        }

        public Criteria andBuildContentGreaterThanOrEqualTo(String value) {
            addCriterion("build_content >=", value, "buildContent");
            return (Criteria) this;
        }

        public Criteria andBuildContentLessThan(String value) {
            addCriterion("build_content <", value, "buildContent");
            return (Criteria) this;
        }

        public Criteria andBuildContentLessThanOrEqualTo(String value) {
            addCriterion("build_content <=", value, "buildContent");
            return (Criteria) this;
        }

        public Criteria andBuildContentLike(String value) {
            addCriterion("build_content like", value, "buildContent");
            return (Criteria) this;
        }

        public Criteria andBuildContentNotLike(String value) {
            addCriterion("build_content not like", value, "buildContent");
            return (Criteria) this;
        }

        public Criteria andBuildContentIn(List<String> values) {
            addCriterion("build_content in", values, "buildContent");
            return (Criteria) this;
        }

        public Criteria andBuildContentNotIn(List<String> values) {
            addCriterion("build_content not in", values, "buildContent");
            return (Criteria) this;
        }

        public Criteria andBuildContentBetween(String value1, String value2) {
            addCriterion("build_content between", value1, value2, "buildContent");
            return (Criteria) this;
        }

        public Criteria andBuildContentNotBetween(String value1, String value2) {
            addCriterion("build_content not between", value1, value2, "buildContent");
            return (Criteria) this;
        }

        public Criteria andProjectConditionIsNull() {
            addCriterion("project_condition is null");
            return (Criteria) this;
        }

        public Criteria andProjectConditionIsNotNull() {
            addCriterion("project_condition is not null");
            return (Criteria) this;
        }

        public Criteria andProjectConditionEqualTo(String value) {
            addCriterion("project_condition =", value, "projectCondition");
            return (Criteria) this;
        }

        public Criteria andProjectConditionNotEqualTo(String value) {
            addCriterion("project_condition <>", value, "projectCondition");
            return (Criteria) this;
        }

        public Criteria andProjectConditionGreaterThan(String value) {
            addCriterion("project_condition >", value, "projectCondition");
            return (Criteria) this;
        }

        public Criteria andProjectConditionGreaterThanOrEqualTo(String value) {
            addCriterion("project_condition >=", value, "projectCondition");
            return (Criteria) this;
        }

        public Criteria andProjectConditionLessThan(String value) {
            addCriterion("project_condition <", value, "projectCondition");
            return (Criteria) this;
        }

        public Criteria andProjectConditionLessThanOrEqualTo(String value) {
            addCriterion("project_condition <=", value, "projectCondition");
            return (Criteria) this;
        }

        public Criteria andProjectConditionLike(String value) {
            addCriterion("project_condition like", value, "projectCondition");
            return (Criteria) this;
        }

        public Criteria andProjectConditionNotLike(String value) {
            addCriterion("project_condition not like", value, "projectCondition");
            return (Criteria) this;
        }

        public Criteria andProjectConditionIn(List<String> values) {
            addCriterion("project_condition in", values, "projectCondition");
            return (Criteria) this;
        }

        public Criteria andProjectConditionNotIn(List<String> values) {
            addCriterion("project_condition not in", values, "projectCondition");
            return (Criteria) this;
        }

        public Criteria andProjectConditionBetween(String value1, String value2) {
            addCriterion("project_condition between", value1, value2, "projectCondition");
            return (Criteria) this;
        }

        public Criteria andProjectConditionNotBetween(String value1, String value2) {
            addCriterion("project_condition not between", value1, value2, "projectCondition");
            return (Criteria) this;
        }

        public Criteria andProjectConditionDateIsNull() {
            addCriterion("project_condition_date is null");
            return (Criteria) this;
        }

        public Criteria andProjectConditionDateIsNotNull() {
            addCriterion("project_condition_date is not null");
            return (Criteria) this;
        }

        public Criteria andProjectConditionDateEqualTo(String value) {
            addCriterion("project_condition_date =", value, "projectConditionDate");
            return (Criteria) this;
        }

        public Criteria andProjectConditionDateNotEqualTo(String value) {
            addCriterion("project_condition_date <>", value, "projectConditionDate");
            return (Criteria) this;
        }

        public Criteria andProjectConditionDateGreaterThan(String value) {
            addCriterion("project_condition_date >", value, "projectConditionDate");
            return (Criteria) this;
        }

        public Criteria andProjectConditionDateGreaterThanOrEqualTo(String value) {
            addCriterion("project_condition_date >=", value, "projectConditionDate");
            return (Criteria) this;
        }

        public Criteria andProjectConditionDateLessThan(String value) {
            addCriterion("project_condition_date <", value, "projectConditionDate");
            return (Criteria) this;
        }

        public Criteria andProjectConditionDateLessThanOrEqualTo(String value) {
            addCriterion("project_condition_date <=", value, "projectConditionDate");
            return (Criteria) this;
        }

        public Criteria andProjectConditionDateLike(String value) {
            addCriterion("project_condition_date like", value, "projectConditionDate");
            return (Criteria) this;
        }

        public Criteria andProjectConditionDateNotLike(String value) {
            addCriterion("project_condition_date not like", value, "projectConditionDate");
            return (Criteria) this;
        }

        public Criteria andProjectConditionDateIn(List<String> values) {
            addCriterion("project_condition_date in", values, "projectConditionDate");
            return (Criteria) this;
        }

        public Criteria andProjectConditionDateNotIn(List<String> values) {
            addCriterion("project_condition_date not in", values, "projectConditionDate");
            return (Criteria) this;
        }

        public Criteria andProjectConditionDateBetween(String value1, String value2) {
            addCriterion("project_condition_date between", value1, value2, "projectConditionDate");
            return (Criteria) this;
        }

        public Criteria andProjectConditionDateNotBetween(String value1, String value2) {
            addCriterion("project_condition_date not between", value1, value2, "projectConditionDate");
            return (Criteria) this;
        }

        public Criteria andPspidIsNull() {
            addCriterion("pspid is null");
            return (Criteria) this;
        }

        public Criteria andPspidIsNotNull() {
            addCriterion("pspid is not null");
            return (Criteria) this;
        }

        public Criteria andPspidEqualTo(String value) {
            addCriterion("pspid =", value, "pspid");
            return (Criteria) this;
        }

        public Criteria andPspidNotEqualTo(String value) {
            addCriterion("pspid <>", value, "pspid");
            return (Criteria) this;
        }

        public Criteria andPspidGreaterThan(String value) {
            addCriterion("pspid >", value, "pspid");
            return (Criteria) this;
        }

        public Criteria andPspidGreaterThanOrEqualTo(String value) {
            addCriterion("pspid >=", value, "pspid");
            return (Criteria) this;
        }

        public Criteria andPspidLessThan(String value) {
            addCriterion("pspid <", value, "pspid");
            return (Criteria) this;
        }

        public Criteria andPspidLessThanOrEqualTo(String value) {
            addCriterion("pspid <=", value, "pspid");
            return (Criteria) this;
        }

        public Criteria andPspidLike(String value) {
            addCriterion("pspid like", value, "pspid");
            return (Criteria) this;
        }

        public Criteria andPspidNotLike(String value) {
            addCriterion("pspid not like", value, "pspid");
            return (Criteria) this;
        }

        public Criteria andPspidIn(List<String> values) {
            addCriterion("pspid in", values, "pspid");
            return (Criteria) this;
        }

        public Criteria andPspidNotIn(List<String> values) {
            addCriterion("pspid not in", values, "pspid");
            return (Criteria) this;
        }

        public Criteria andPspidBetween(String value1, String value2) {
            addCriterion("pspid between", value1, value2, "pspid");
            return (Criteria) this;
        }

        public Criteria andPspidNotBetween(String value1, String value2) {
            addCriterion("pspid not between", value1, value2, "pspid");
            return (Criteria) this;
        }

        public Criteria andPspnrIsNull() {
            addCriterion("pspnr is null");
            return (Criteria) this;
        }

        public Criteria andPspnrIsNotNull() {
            addCriterion("pspnr is not null");
            return (Criteria) this;
        }

        public Criteria andPspnrEqualTo(String value) {
            addCriterion("pspnr =", value, "pspnr");
            return (Criteria) this;
        }

        public Criteria andPspnrNotEqualTo(String value) {
            addCriterion("pspnr <>", value, "pspnr");
            return (Criteria) this;
        }

        public Criteria andPspnrGreaterThan(String value) {
            addCriterion("pspnr >", value, "pspnr");
            return (Criteria) this;
        }

        public Criteria andPspnrGreaterThanOrEqualTo(String value) {
            addCriterion("pspnr >=", value, "pspnr");
            return (Criteria) this;
        }

        public Criteria andPspnrLessThan(String value) {
            addCriterion("pspnr <", value, "pspnr");
            return (Criteria) this;
        }

        public Criteria andPspnrLessThanOrEqualTo(String value) {
            addCriterion("pspnr <=", value, "pspnr");
            return (Criteria) this;
        }

        public Criteria andPspnrLike(String value) {
            addCriterion("pspnr like", value, "pspnr");
            return (Criteria) this;
        }

        public Criteria andPspnrNotLike(String value) {
            addCriterion("pspnr not like", value, "pspnr");
            return (Criteria) this;
        }

        public Criteria andPspnrIn(List<String> values) {
            addCriterion("pspnr in", values, "pspnr");
            return (Criteria) this;
        }

        public Criteria andPspnrNotIn(List<String> values) {
            addCriterion("pspnr not in", values, "pspnr");
            return (Criteria) this;
        }

        public Criteria andPspnrBetween(String value1, String value2) {
            addCriterion("pspnr between", value1, value2, "pspnr");
            return (Criteria) this;
        }

        public Criteria andPspnrNotBetween(String value1, String value2) {
            addCriterion("pspnr not between", value1, value2, "pspnr");
            return (Criteria) this;
        }

        public Criteria andObjnrIsNull() {
            addCriterion("objnr is null");
            return (Criteria) this;
        }

        public Criteria andObjnrIsNotNull() {
            addCriterion("objnr is not null");
            return (Criteria) this;
        }

        public Criteria andObjnrEqualTo(String value) {
            addCriterion("objnr =", value, "objnr");
            return (Criteria) this;
        }

        public Criteria andObjnrNotEqualTo(String value) {
            addCriterion("objnr <>", value, "objnr");
            return (Criteria) this;
        }

        public Criteria andObjnrGreaterThan(String value) {
            addCriterion("objnr >", value, "objnr");
            return (Criteria) this;
        }

        public Criteria andObjnrGreaterThanOrEqualTo(String value) {
            addCriterion("objnr >=", value, "objnr");
            return (Criteria) this;
        }

        public Criteria andObjnrLessThan(String value) {
            addCriterion("objnr <", value, "objnr");
            return (Criteria) this;
        }

        public Criteria andObjnrLessThanOrEqualTo(String value) {
            addCriterion("objnr <=", value, "objnr");
            return (Criteria) this;
        }

        public Criteria andObjnrLike(String value) {
            addCriterion("objnr like", value, "objnr");
            return (Criteria) this;
        }

        public Criteria andObjnrNotLike(String value) {
            addCriterion("objnr not like", value, "objnr");
            return (Criteria) this;
        }

        public Criteria andObjnrIn(List<String> values) {
            addCriterion("objnr in", values, "objnr");
            return (Criteria) this;
        }

        public Criteria andObjnrNotIn(List<String> values) {
            addCriterion("objnr not in", values, "objnr");
            return (Criteria) this;
        }

        public Criteria andObjnrBetween(String value1, String value2) {
            addCriterion("objnr between", value1, value2, "objnr");
            return (Criteria) this;
        }

        public Criteria andObjnrNotBetween(String value1, String value2) {
            addCriterion("objnr not between", value1, value2, "objnr");
            return (Criteria) this;
        }

        public Criteria andPost1IsNull() {
            addCriterion("post1 is null");
            return (Criteria) this;
        }

        public Criteria andPost1IsNotNull() {
            addCriterion("post1 is not null");
            return (Criteria) this;
        }

        public Criteria andPost1EqualTo(String value) {
            addCriterion("post1 =", value, "post1");
            return (Criteria) this;
        }

        public Criteria andPost1NotEqualTo(String value) {
            addCriterion("post1 <>", value, "post1");
            return (Criteria) this;
        }

        public Criteria andPost1GreaterThan(String value) {
            addCriterion("post1 >", value, "post1");
            return (Criteria) this;
        }

        public Criteria andPost1GreaterThanOrEqualTo(String value) {
            addCriterion("post1 >=", value, "post1");
            return (Criteria) this;
        }

        public Criteria andPost1LessThan(String value) {
            addCriterion("post1 <", value, "post1");
            return (Criteria) this;
        }

        public Criteria andPost1LessThanOrEqualTo(String value) {
            addCriterion("post1 <=", value, "post1");
            return (Criteria) this;
        }

        public Criteria andPost1Like(String value) {
            addCriterion("post1 like", value, "post1");
            return (Criteria) this;
        }

        public Criteria andPost1NotLike(String value) {
            addCriterion("post1 not like", value, "post1");
            return (Criteria) this;
        }

        public Criteria andPost1In(List<String> values) {
            addCriterion("post1 in", values, "post1");
            return (Criteria) this;
        }

        public Criteria andPost1NotIn(List<String> values) {
            addCriterion("post1 not in", values, "post1");
            return (Criteria) this;
        }

        public Criteria andPost1Between(String value1, String value2) {
            addCriterion("post1 between", value1, value2, "post1");
            return (Criteria) this;
        }

        public Criteria andPost1NotBetween(String value1, String value2) {
            addCriterion("post1 not between", value1, value2, "post1");
            return (Criteria) this;
        }

        public Criteria andVernaIsNull() {
            addCriterion("verna is null");
            return (Criteria) this;
        }

        public Criteria andVernaIsNotNull() {
            addCriterion("verna is not null");
            return (Criteria) this;
        }

        public Criteria andVernaEqualTo(String value) {
            addCriterion("verna =", value, "verna");
            return (Criteria) this;
        }

        public Criteria andVernaNotEqualTo(String value) {
            addCriterion("verna <>", value, "verna");
            return (Criteria) this;
        }

        public Criteria andVernaGreaterThan(String value) {
            addCriterion("verna >", value, "verna");
            return (Criteria) this;
        }

        public Criteria andVernaGreaterThanOrEqualTo(String value) {
            addCriterion("verna >=", value, "verna");
            return (Criteria) this;
        }

        public Criteria andVernaLessThan(String value) {
            addCriterion("verna <", value, "verna");
            return (Criteria) this;
        }

        public Criteria andVernaLessThanOrEqualTo(String value) {
            addCriterion("verna <=", value, "verna");
            return (Criteria) this;
        }

        public Criteria andVernaLike(String value) {
            addCriterion("verna like", value, "verna");
            return (Criteria) this;
        }

        public Criteria andVernaNotLike(String value) {
            addCriterion("verna not like", value, "verna");
            return (Criteria) this;
        }

        public Criteria andVernaIn(List<String> values) {
            addCriterion("verna in", values, "verna");
            return (Criteria) this;
        }

        public Criteria andVernaNotIn(List<String> values) {
            addCriterion("verna not in", values, "verna");
            return (Criteria) this;
        }

        public Criteria andVernaBetween(String value1, String value2) {
            addCriterion("verna between", value1, value2, "verna");
            return (Criteria) this;
        }

        public Criteria andVernaNotBetween(String value1, String value2) {
            addCriterion("verna not between", value1, value2, "verna");
            return (Criteria) this;
        }

        public Criteria andVbukrIsNull() {
            addCriterion("vbukr is null");
            return (Criteria) this;
        }

        public Criteria andVbukrIsNotNull() {
            addCriterion("vbukr is not null");
            return (Criteria) this;
        }

        public Criteria andVbukrEqualTo(String value) {
            addCriterion("vbukr =", value, "vbukr");
            return (Criteria) this;
        }

        public Criteria andVbukrNotEqualTo(String value) {
            addCriterion("vbukr <>", value, "vbukr");
            return (Criteria) this;
        }

        public Criteria andVbukrGreaterThan(String value) {
            addCriterion("vbukr >", value, "vbukr");
            return (Criteria) this;
        }

        public Criteria andVbukrGreaterThanOrEqualTo(String value) {
            addCriterion("vbukr >=", value, "vbukr");
            return (Criteria) this;
        }

        public Criteria andVbukrLessThan(String value) {
            addCriterion("vbukr <", value, "vbukr");
            return (Criteria) this;
        }

        public Criteria andVbukrLessThanOrEqualTo(String value) {
            addCriterion("vbukr <=", value, "vbukr");
            return (Criteria) this;
        }

        public Criteria andVbukrLike(String value) {
            addCriterion("vbukr like", value, "vbukr");
            return (Criteria) this;
        }

        public Criteria andVbukrNotLike(String value) {
            addCriterion("vbukr not like", value, "vbukr");
            return (Criteria) this;
        }

        public Criteria andVbukrIn(List<String> values) {
            addCriterion("vbukr in", values, "vbukr");
            return (Criteria) this;
        }

        public Criteria andVbukrNotIn(List<String> values) {
            addCriterion("vbukr not in", values, "vbukr");
            return (Criteria) this;
        }

        public Criteria andVbukrBetween(String value1, String value2) {
            addCriterion("vbukr between", value1, value2, "vbukr");
            return (Criteria) this;
        }

        public Criteria andVbukrNotBetween(String value1, String value2) {
            addCriterion("vbukr not between", value1, value2, "vbukr");
            return (Criteria) this;
        }

        public Criteria andWerksIsNull() {
            addCriterion("werks is null");
            return (Criteria) this;
        }

        public Criteria andWerksIsNotNull() {
            addCriterion("werks is not null");
            return (Criteria) this;
        }

        public Criteria andWerksEqualTo(String value) {
            addCriterion("werks =", value, "werks");
            return (Criteria) this;
        }

        public Criteria andWerksNotEqualTo(String value) {
            addCriterion("werks <>", value, "werks");
            return (Criteria) this;
        }

        public Criteria andWerksGreaterThan(String value) {
            addCriterion("werks >", value, "werks");
            return (Criteria) this;
        }

        public Criteria andWerksGreaterThanOrEqualTo(String value) {
            addCriterion("werks >=", value, "werks");
            return (Criteria) this;
        }

        public Criteria andWerksLessThan(String value) {
            addCriterion("werks <", value, "werks");
            return (Criteria) this;
        }

        public Criteria andWerksLessThanOrEqualTo(String value) {
            addCriterion("werks <=", value, "werks");
            return (Criteria) this;
        }

        public Criteria andWerksLike(String value) {
            addCriterion("werks like", value, "werks");
            return (Criteria) this;
        }

        public Criteria andWerksNotLike(String value) {
            addCriterion("werks not like", value, "werks");
            return (Criteria) this;
        }

        public Criteria andWerksIn(List<String> values) {
            addCriterion("werks in", values, "werks");
            return (Criteria) this;
        }

        public Criteria andWerksNotIn(List<String> values) {
            addCriterion("werks not in", values, "werks");
            return (Criteria) this;
        }

        public Criteria andWerksBetween(String value1, String value2) {
            addCriterion("werks between", value1, value2, "werks");
            return (Criteria) this;
        }

        public Criteria andWerksNotBetween(String value1, String value2) {
            addCriterion("werks not between", value1, value2, "werks");
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