package com.pcitc.base.engin.hse.punish;

import java.util.ArrayList;
import java.util.List;

public class HsePunishVoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HsePunishVoExample() {
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

        public Criteria andRegistUnitCodeIsNull() {
            addCriterion("regist_unit_code is null");
            return (Criteria) this;
        }

        public Criteria andRegistUnitCodeIsNotNull() {
            addCriterion("regist_unit_code is not null");
            return (Criteria) this;
        }

        public Criteria andRegistUnitCodeEqualTo(String value) {
            addCriterion("regist_unit_code =", value, "registUnitCode");
            return (Criteria) this;
        }

        public Criteria andRegistUnitCodeNotEqualTo(String value) {
            addCriterion("regist_unit_code <>", value, "registUnitCode");
            return (Criteria) this;
        }

        public Criteria andRegistUnitCodeGreaterThan(String value) {
            addCriterion("regist_unit_code >", value, "registUnitCode");
            return (Criteria) this;
        }

        public Criteria andRegistUnitCodeGreaterThanOrEqualTo(String value) {
            addCriterion("regist_unit_code >=", value, "registUnitCode");
            return (Criteria) this;
        }

        public Criteria andRegistUnitCodeLessThan(String value) {
            addCriterion("regist_unit_code <", value, "registUnitCode");
            return (Criteria) this;
        }

        public Criteria andRegistUnitCodeLessThanOrEqualTo(String value) {
            addCriterion("regist_unit_code <=", value, "registUnitCode");
            return (Criteria) this;
        }

        public Criteria andRegistUnitCodeLike(String value) {
            addCriterion("regist_unit_code like", value, "registUnitCode");
            return (Criteria) this;
        }

        public Criteria andRegistUnitCodeNotLike(String value) {
            addCriterion("regist_unit_code not like", value, "registUnitCode");
            return (Criteria) this;
        }

        public Criteria andRegistUnitCodeIn(List<String> values) {
            addCriterion("regist_unit_code in", values, "registUnitCode");
            return (Criteria) this;
        }

        public Criteria andRegistUnitCodeNotIn(List<String> values) {
            addCriterion("regist_unit_code not in", values, "registUnitCode");
            return (Criteria) this;
        }

        public Criteria andRegistUnitCodeBetween(String value1, String value2) {
            addCriterion("regist_unit_code between", value1, value2, "registUnitCode");
            return (Criteria) this;
        }

        public Criteria andRegistUnitCodeNotBetween(String value1, String value2) {
            addCriterion("regist_unit_code not between", value1, value2, "registUnitCode");
            return (Criteria) this;
        }

        public Criteria andRegistUserIsNull() {
            addCriterion("regist_user is null");
            return (Criteria) this;
        }

        public Criteria andRegistUserIsNotNull() {
            addCriterion("regist_user is not null");
            return (Criteria) this;
        }

        public Criteria andRegistUserEqualTo(String value) {
            addCriterion("regist_user =", value, "registUser");
            return (Criteria) this;
        }

        public Criteria andRegistUserNotEqualTo(String value) {
            addCriterion("regist_user <>", value, "registUser");
            return (Criteria) this;
        }

        public Criteria andRegistUserGreaterThan(String value) {
            addCriterion("regist_user >", value, "registUser");
            return (Criteria) this;
        }

        public Criteria andRegistUserGreaterThanOrEqualTo(String value) {
            addCriterion("regist_user >=", value, "registUser");
            return (Criteria) this;
        }

        public Criteria andRegistUserLessThan(String value) {
            addCriterion("regist_user <", value, "registUser");
            return (Criteria) this;
        }

        public Criteria andRegistUserLessThanOrEqualTo(String value) {
            addCriterion("regist_user <=", value, "registUser");
            return (Criteria) this;
        }

        public Criteria andRegistUserLike(String value) {
            addCriterion("regist_user like", value, "registUser");
            return (Criteria) this;
        }

        public Criteria andRegistUserNotLike(String value) {
            addCriterion("regist_user not like", value, "registUser");
            return (Criteria) this;
        }

        public Criteria andRegistUserIn(List<String> values) {
            addCriterion("regist_user in", values, "registUser");
            return (Criteria) this;
        }

        public Criteria andRegistUserNotIn(List<String> values) {
            addCriterion("regist_user not in", values, "registUser");
            return (Criteria) this;
        }

        public Criteria andRegistUserBetween(String value1, String value2) {
            addCriterion("regist_user between", value1, value2, "registUser");
            return (Criteria) this;
        }

        public Criteria andRegistUserNotBetween(String value1, String value2) {
            addCriterion("regist_user not between", value1, value2, "registUser");
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

        public Criteria andPunishKindIsNull() {
            addCriterion("punish_kind is null");
            return (Criteria) this;
        }

        public Criteria andPunishKindIsNotNull() {
            addCriterion("punish_kind is not null");
            return (Criteria) this;
        }

        public Criteria andPunishKindEqualTo(String value) {
            addCriterion("punish_kind =", value, "punishKind");
            return (Criteria) this;
        }

        public Criteria andPunishKindNotEqualTo(String value) {
            addCriterion("punish_kind <>", value, "punishKind");
            return (Criteria) this;
        }

        public Criteria andPunishKindGreaterThan(String value) {
            addCriterion("punish_kind >", value, "punishKind");
            return (Criteria) this;
        }

        public Criteria andPunishKindGreaterThanOrEqualTo(String value) {
            addCriterion("punish_kind >=", value, "punishKind");
            return (Criteria) this;
        }

        public Criteria andPunishKindLessThan(String value) {
            addCriterion("punish_kind <", value, "punishKind");
            return (Criteria) this;
        }

        public Criteria andPunishKindLessThanOrEqualTo(String value) {
            addCriterion("punish_kind <=", value, "punishKind");
            return (Criteria) this;
        }

        public Criteria andPunishKindLike(String value) {
            addCriterion("punish_kind like", value, "punishKind");
            return (Criteria) this;
        }

        public Criteria andPunishKindNotLike(String value) {
            addCriterion("punish_kind not like", value, "punishKind");
            return (Criteria) this;
        }

        public Criteria andPunishKindIn(List<String> values) {
            addCriterion("punish_kind in", values, "punishKind");
            return (Criteria) this;
        }

        public Criteria andPunishKindNotIn(List<String> values) {
            addCriterion("punish_kind not in", values, "punishKind");
            return (Criteria) this;
        }

        public Criteria andPunishKindBetween(String value1, String value2) {
            addCriterion("punish_kind between", value1, value2, "punishKind");
            return (Criteria) this;
        }

        public Criteria andPunishKindNotBetween(String value1, String value2) {
            addCriterion("punish_kind not between", value1, value2, "punishKind");
            return (Criteria) this;
        }

        public Criteria andPunishTypeIsNull() {
            addCriterion("punish_type is null");
            return (Criteria) this;
        }

        public Criteria andPunishTypeIsNotNull() {
            addCriterion("punish_type is not null");
            return (Criteria) this;
        }

        public Criteria andPunishTypeEqualTo(String value) {
            addCriterion("punish_type =", value, "punishType");
            return (Criteria) this;
        }

        public Criteria andPunishTypeNotEqualTo(String value) {
            addCriterion("punish_type <>", value, "punishType");
            return (Criteria) this;
        }

        public Criteria andPunishTypeGreaterThan(String value) {
            addCriterion("punish_type >", value, "punishType");
            return (Criteria) this;
        }

        public Criteria andPunishTypeGreaterThanOrEqualTo(String value) {
            addCriterion("punish_type >=", value, "punishType");
            return (Criteria) this;
        }

        public Criteria andPunishTypeLessThan(String value) {
            addCriterion("punish_type <", value, "punishType");
            return (Criteria) this;
        }

        public Criteria andPunishTypeLessThanOrEqualTo(String value) {
            addCriterion("punish_type <=", value, "punishType");
            return (Criteria) this;
        }

        public Criteria andPunishTypeLike(String value) {
            addCriterion("punish_type like", value, "punishType");
            return (Criteria) this;
        }

        public Criteria andPunishTypeNotLike(String value) {
            addCriterion("punish_type not like", value, "punishType");
            return (Criteria) this;
        }

        public Criteria andPunishTypeIn(List<String> values) {
            addCriterion("punish_type in", values, "punishType");
            return (Criteria) this;
        }

        public Criteria andPunishTypeNotIn(List<String> values) {
            addCriterion("punish_type not in", values, "punishType");
            return (Criteria) this;
        }

        public Criteria andPunishTypeBetween(String value1, String value2) {
            addCriterion("punish_type between", value1, value2, "punishType");
            return (Criteria) this;
        }

        public Criteria andPunishTypeNotBetween(String value1, String value2) {
            addCriterion("punish_type not between", value1, value2, "punishType");
            return (Criteria) this;
        }

        public Criteria andRegistDateIsNull() {
            addCriterion("regist_date is null");
            return (Criteria) this;
        }

        public Criteria andRegistDateIsNotNull() {
            addCriterion("regist_date is not null");
            return (Criteria) this;
        }

        public Criteria andRegistDateEqualTo(String value) {
            addCriterion("regist_date =", value, "registDate");
            return (Criteria) this;
        }

        public Criteria andRegistDateNotEqualTo(String value) {
            addCriterion("regist_date <>", value, "registDate");
            return (Criteria) this;
        }

        public Criteria andRegistDateGreaterThan(String value) {
            addCriterion("regist_date >", value, "registDate");
            return (Criteria) this;
        }

        public Criteria andRegistDateGreaterThanOrEqualTo(String value) {
            addCriterion("regist_date >=", value, "registDate");
            return (Criteria) this;
        }

        public Criteria andRegistDateLessThan(String value) {
            addCriterion("regist_date <", value, "registDate");
            return (Criteria) this;
        }

        public Criteria andRegistDateLessThanOrEqualTo(String value) {
            addCriterion("regist_date <=", value, "registDate");
            return (Criteria) this;
        }

        public Criteria andRegistDateLike(String value) {
            addCriterion("regist_date like", value, "registDate");
            return (Criteria) this;
        }

        public Criteria andRegistDateNotLike(String value) {
            addCriterion("regist_date not like", value, "registDate");
            return (Criteria) this;
        }

        public Criteria andRegistDateIn(List<String> values) {
            addCriterion("regist_date in", values, "registDate");
            return (Criteria) this;
        }

        public Criteria andRegistDateNotIn(List<String> values) {
            addCriterion("regist_date not in", values, "registDate");
            return (Criteria) this;
        }

        public Criteria andRegistDateBetween(String value1, String value2) {
            addCriterion("regist_date between", value1, value2, "registDate");
            return (Criteria) this;
        }

        public Criteria andRegistDateNotBetween(String value1, String value2) {
            addCriterion("regist_date not between", value1, value2, "registDate");
            return (Criteria) this;
        }

        public Criteria andPunishNoIsNull() {
            addCriterion("punish_no is null");
            return (Criteria) this;
        }

        public Criteria andPunishNoIsNotNull() {
            addCriterion("punish_no is not null");
            return (Criteria) this;
        }

        public Criteria andPunishNoEqualTo(String value) {
            addCriterion("punish_no =", value, "punishNo");
            return (Criteria) this;
        }

        public Criteria andPunishNoNotEqualTo(String value) {
            addCriterion("punish_no <>", value, "punishNo");
            return (Criteria) this;
        }

        public Criteria andPunishNoGreaterThan(String value) {
            addCriterion("punish_no >", value, "punishNo");
            return (Criteria) this;
        }

        public Criteria andPunishNoGreaterThanOrEqualTo(String value) {
            addCriterion("punish_no >=", value, "punishNo");
            return (Criteria) this;
        }

        public Criteria andPunishNoLessThan(String value) {
            addCriterion("punish_no <", value, "punishNo");
            return (Criteria) this;
        }

        public Criteria andPunishNoLessThanOrEqualTo(String value) {
            addCriterion("punish_no <=", value, "punishNo");
            return (Criteria) this;
        }

        public Criteria andPunishNoLike(String value) {
            addCriterion("punish_no like", value, "punishNo");
            return (Criteria) this;
        }

        public Criteria andPunishNoNotLike(String value) {
            addCriterion("punish_no not like", value, "punishNo");
            return (Criteria) this;
        }

        public Criteria andPunishNoIn(List<String> values) {
            addCriterion("punish_no in", values, "punishNo");
            return (Criteria) this;
        }

        public Criteria andPunishNoNotIn(List<String> values) {
            addCriterion("punish_no not in", values, "punishNo");
            return (Criteria) this;
        }

        public Criteria andPunishNoBetween(String value1, String value2) {
            addCriterion("punish_no between", value1, value2, "punishNo");
            return (Criteria) this;
        }

        public Criteria andPunishNoNotBetween(String value1, String value2) {
            addCriterion("punish_no not between", value1, value2, "punishNo");
            return (Criteria) this;
        }

        public Criteria andPunishPlaceIsNull() {
            addCriterion("punish_place is null");
            return (Criteria) this;
        }

        public Criteria andPunishPlaceIsNotNull() {
            addCriterion("punish_place is not null");
            return (Criteria) this;
        }

        public Criteria andPunishPlaceEqualTo(String value) {
            addCriterion("punish_place =", value, "punishPlace");
            return (Criteria) this;
        }

        public Criteria andPunishPlaceNotEqualTo(String value) {
            addCriterion("punish_place <>", value, "punishPlace");
            return (Criteria) this;
        }

        public Criteria andPunishPlaceGreaterThan(String value) {
            addCriterion("punish_place >", value, "punishPlace");
            return (Criteria) this;
        }

        public Criteria andPunishPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("punish_place >=", value, "punishPlace");
            return (Criteria) this;
        }

        public Criteria andPunishPlaceLessThan(String value) {
            addCriterion("punish_place <", value, "punishPlace");
            return (Criteria) this;
        }

        public Criteria andPunishPlaceLessThanOrEqualTo(String value) {
            addCriterion("punish_place <=", value, "punishPlace");
            return (Criteria) this;
        }

        public Criteria andPunishPlaceLike(String value) {
            addCriterion("punish_place like", value, "punishPlace");
            return (Criteria) this;
        }

        public Criteria andPunishPlaceNotLike(String value) {
            addCriterion("punish_place not like", value, "punishPlace");
            return (Criteria) this;
        }

        public Criteria andPunishPlaceIn(List<String> values) {
            addCriterion("punish_place in", values, "punishPlace");
            return (Criteria) this;
        }

        public Criteria andPunishPlaceNotIn(List<String> values) {
            addCriterion("punish_place not in", values, "punishPlace");
            return (Criteria) this;
        }

        public Criteria andPunishPlaceBetween(String value1, String value2) {
            addCriterion("punish_place between", value1, value2, "punishPlace");
            return (Criteria) this;
        }

        public Criteria andPunishPlaceNotBetween(String value1, String value2) {
            addCriterion("punish_place not between", value1, value2, "punishPlace");
            return (Criteria) this;
        }

        public Criteria andPunishDateIsNull() {
            addCriterion("punish_date is null");
            return (Criteria) this;
        }

        public Criteria andPunishDateIsNotNull() {
            addCriterion("punish_date is not null");
            return (Criteria) this;
        }

        public Criteria andPunishDateEqualTo(String value) {
            addCriterion("punish_date =", value, "punishDate");
            return (Criteria) this;
        }

        public Criteria andPunishDateNotEqualTo(String value) {
            addCriterion("punish_date <>", value, "punishDate");
            return (Criteria) this;
        }

        public Criteria andPunishDateGreaterThan(String value) {
            addCriterion("punish_date >", value, "punishDate");
            return (Criteria) this;
        }

        public Criteria andPunishDateGreaterThanOrEqualTo(String value) {
            addCriterion("punish_date >=", value, "punishDate");
            return (Criteria) this;
        }

        public Criteria andPunishDateLessThan(String value) {
            addCriterion("punish_date <", value, "punishDate");
            return (Criteria) this;
        }

        public Criteria andPunishDateLessThanOrEqualTo(String value) {
            addCriterion("punish_date <=", value, "punishDate");
            return (Criteria) this;
        }

        public Criteria andPunishDateLike(String value) {
            addCriterion("punish_date like", value, "punishDate");
            return (Criteria) this;
        }

        public Criteria andPunishDateNotLike(String value) {
            addCriterion("punish_date not like", value, "punishDate");
            return (Criteria) this;
        }

        public Criteria andPunishDateIn(List<String> values) {
            addCriterion("punish_date in", values, "punishDate");
            return (Criteria) this;
        }

        public Criteria andPunishDateNotIn(List<String> values) {
            addCriterion("punish_date not in", values, "punishDate");
            return (Criteria) this;
        }

        public Criteria andPunishDateBetween(String value1, String value2) {
            addCriterion("punish_date between", value1, value2, "punishDate");
            return (Criteria) this;
        }

        public Criteria andPunishDateNotBetween(String value1, String value2) {
            addCriterion("punish_date not between", value1, value2, "punishDate");
            return (Criteria) this;
        }

        public Criteria andPunishUnitIsNull() {
            addCriterion("punish_unit is null");
            return (Criteria) this;
        }

        public Criteria andPunishUnitIsNotNull() {
            addCriterion("punish_unit is not null");
            return (Criteria) this;
        }

        public Criteria andPunishUnitEqualTo(String value) {
            addCriterion("punish_unit =", value, "punishUnit");
            return (Criteria) this;
        }

        public Criteria andPunishUnitNotEqualTo(String value) {
            addCriterion("punish_unit <>", value, "punishUnit");
            return (Criteria) this;
        }

        public Criteria andPunishUnitGreaterThan(String value) {
            addCriterion("punish_unit >", value, "punishUnit");
            return (Criteria) this;
        }

        public Criteria andPunishUnitGreaterThanOrEqualTo(String value) {
            addCriterion("punish_unit >=", value, "punishUnit");
            return (Criteria) this;
        }

        public Criteria andPunishUnitLessThan(String value) {
            addCriterion("punish_unit <", value, "punishUnit");
            return (Criteria) this;
        }

        public Criteria andPunishUnitLessThanOrEqualTo(String value) {
            addCriterion("punish_unit <=", value, "punishUnit");
            return (Criteria) this;
        }

        public Criteria andPunishUnitLike(String value) {
            addCriterion("punish_unit like", value, "punishUnit");
            return (Criteria) this;
        }

        public Criteria andPunishUnitNotLike(String value) {
            addCriterion("punish_unit not like", value, "punishUnit");
            return (Criteria) this;
        }

        public Criteria andPunishUnitIn(List<String> values) {
            addCriterion("punish_unit in", values, "punishUnit");
            return (Criteria) this;
        }

        public Criteria andPunishUnitNotIn(List<String> values) {
            addCriterion("punish_unit not in", values, "punishUnit");
            return (Criteria) this;
        }

        public Criteria andPunishUnitBetween(String value1, String value2) {
            addCriterion("punish_unit between", value1, value2, "punishUnit");
            return (Criteria) this;
        }

        public Criteria andPunishUnitNotBetween(String value1, String value2) {
            addCriterion("punish_unit not between", value1, value2, "punishUnit");
            return (Criteria) this;
        }

        public Criteria andPunishUnitCodeIsNull() {
            addCriterion("punish_unit_code is null");
            return (Criteria) this;
        }

        public Criteria andPunishUnitCodeIsNotNull() {
            addCriterion("punish_unit_code is not null");
            return (Criteria) this;
        }

        public Criteria andPunishUnitCodeEqualTo(String value) {
            addCriterion("punish_unit_code =", value, "punishUnitCode");
            return (Criteria) this;
        }

        public Criteria andPunishUnitCodeNotEqualTo(String value) {
            addCriterion("punish_unit_code <>", value, "punishUnitCode");
            return (Criteria) this;
        }

        public Criteria andPunishUnitCodeGreaterThan(String value) {
            addCriterion("punish_unit_code >", value, "punishUnitCode");
            return (Criteria) this;
        }

        public Criteria andPunishUnitCodeGreaterThanOrEqualTo(String value) {
            addCriterion("punish_unit_code >=", value, "punishUnitCode");
            return (Criteria) this;
        }

        public Criteria andPunishUnitCodeLessThan(String value) {
            addCriterion("punish_unit_code <", value, "punishUnitCode");
            return (Criteria) this;
        }

        public Criteria andPunishUnitCodeLessThanOrEqualTo(String value) {
            addCriterion("punish_unit_code <=", value, "punishUnitCode");
            return (Criteria) this;
        }

        public Criteria andPunishUnitCodeLike(String value) {
            addCriterion("punish_unit_code like", value, "punishUnitCode");
            return (Criteria) this;
        }

        public Criteria andPunishUnitCodeNotLike(String value) {
            addCriterion("punish_unit_code not like", value, "punishUnitCode");
            return (Criteria) this;
        }

        public Criteria andPunishUnitCodeIn(List<String> values) {
            addCriterion("punish_unit_code in", values, "punishUnitCode");
            return (Criteria) this;
        }

        public Criteria andPunishUnitCodeNotIn(List<String> values) {
            addCriterion("punish_unit_code not in", values, "punishUnitCode");
            return (Criteria) this;
        }

        public Criteria andPunishUnitCodeBetween(String value1, String value2) {
            addCriterion("punish_unit_code between", value1, value2, "punishUnitCode");
            return (Criteria) this;
        }

        public Criteria andPunishUnitCodeNotBetween(String value1, String value2) {
            addCriterion("punish_unit_code not between", value1, value2, "punishUnitCode");
            return (Criteria) this;
        }

        public Criteria andPunishDescIsNull() {
            addCriterion("punish_desc is null");
            return (Criteria) this;
        }

        public Criteria andPunishDescIsNotNull() {
            addCriterion("punish_desc is not null");
            return (Criteria) this;
        }

        public Criteria andPunishDescEqualTo(String value) {
            addCriterion("punish_desc =", value, "punishDesc");
            return (Criteria) this;
        }

        public Criteria andPunishDescNotEqualTo(String value) {
            addCriterion("punish_desc <>", value, "punishDesc");
            return (Criteria) this;
        }

        public Criteria andPunishDescGreaterThan(String value) {
            addCriterion("punish_desc >", value, "punishDesc");
            return (Criteria) this;
        }

        public Criteria andPunishDescGreaterThanOrEqualTo(String value) {
            addCriterion("punish_desc >=", value, "punishDesc");
            return (Criteria) this;
        }

        public Criteria andPunishDescLessThan(String value) {
            addCriterion("punish_desc <", value, "punishDesc");
            return (Criteria) this;
        }

        public Criteria andPunishDescLessThanOrEqualTo(String value) {
            addCriterion("punish_desc <=", value, "punishDesc");
            return (Criteria) this;
        }

        public Criteria andPunishDescLike(String value) {
            addCriterion("punish_desc like", value, "punishDesc");
            return (Criteria) this;
        }

        public Criteria andPunishDescNotLike(String value) {
            addCriterion("punish_desc not like", value, "punishDesc");
            return (Criteria) this;
        }

        public Criteria andPunishDescIn(List<String> values) {
            addCriterion("punish_desc in", values, "punishDesc");
            return (Criteria) this;
        }

        public Criteria andPunishDescNotIn(List<String> values) {
            addCriterion("punish_desc not in", values, "punishDesc");
            return (Criteria) this;
        }

        public Criteria andPunishDescBetween(String value1, String value2) {
            addCriterion("punish_desc between", value1, value2, "punishDesc");
            return (Criteria) this;
        }

        public Criteria andPunishDescNotBetween(String value1, String value2) {
            addCriterion("punish_desc not between", value1, value2, "punishDesc");
            return (Criteria) this;
        }

        public Criteria andCheckContentIsNull() {
            addCriterion("check_content is null");
            return (Criteria) this;
        }

        public Criteria andCheckContentIsNotNull() {
            addCriterion("check_content is not null");
            return (Criteria) this;
        }

        public Criteria andCheckContentEqualTo(String value) {
            addCriterion("check_content =", value, "checkContent");
            return (Criteria) this;
        }

        public Criteria andCheckContentNotEqualTo(String value) {
            addCriterion("check_content <>", value, "checkContent");
            return (Criteria) this;
        }

        public Criteria andCheckContentGreaterThan(String value) {
            addCriterion("check_content >", value, "checkContent");
            return (Criteria) this;
        }

        public Criteria andCheckContentGreaterThanOrEqualTo(String value) {
            addCriterion("check_content >=", value, "checkContent");
            return (Criteria) this;
        }

        public Criteria andCheckContentLessThan(String value) {
            addCriterion("check_content <", value, "checkContent");
            return (Criteria) this;
        }

        public Criteria andCheckContentLessThanOrEqualTo(String value) {
            addCriterion("check_content <=", value, "checkContent");
            return (Criteria) this;
        }

        public Criteria andCheckContentLike(String value) {
            addCriterion("check_content like", value, "checkContent");
            return (Criteria) this;
        }

        public Criteria andCheckContentNotLike(String value) {
            addCriterion("check_content not like", value, "checkContent");
            return (Criteria) this;
        }

        public Criteria andCheckContentIn(List<String> values) {
            addCriterion("check_content in", values, "checkContent");
            return (Criteria) this;
        }

        public Criteria andCheckContentNotIn(List<String> values) {
            addCriterion("check_content not in", values, "checkContent");
            return (Criteria) this;
        }

        public Criteria andCheckContentBetween(String value1, String value2) {
            addCriterion("check_content between", value1, value2, "checkContent");
            return (Criteria) this;
        }

        public Criteria andCheckContentNotBetween(String value1, String value2) {
            addCriterion("check_content not between", value1, value2, "checkContent");
            return (Criteria) this;
        }

        public Criteria andCheckClauseIsNull() {
            addCriterion("check_clause is null");
            return (Criteria) this;
        }

        public Criteria andCheckClauseIsNotNull() {
            addCriterion("check_clause is not null");
            return (Criteria) this;
        }

        public Criteria andCheckClauseEqualTo(String value) {
            addCriterion("check_clause =", value, "checkClause");
            return (Criteria) this;
        }

        public Criteria andCheckClauseNotEqualTo(String value) {
            addCriterion("check_clause <>", value, "checkClause");
            return (Criteria) this;
        }

        public Criteria andCheckClauseGreaterThan(String value) {
            addCriterion("check_clause >", value, "checkClause");
            return (Criteria) this;
        }

        public Criteria andCheckClauseGreaterThanOrEqualTo(String value) {
            addCriterion("check_clause >=", value, "checkClause");
            return (Criteria) this;
        }

        public Criteria andCheckClauseLessThan(String value) {
            addCriterion("check_clause <", value, "checkClause");
            return (Criteria) this;
        }

        public Criteria andCheckClauseLessThanOrEqualTo(String value) {
            addCriterion("check_clause <=", value, "checkClause");
            return (Criteria) this;
        }

        public Criteria andCheckClauseLike(String value) {
            addCriterion("check_clause like", value, "checkClause");
            return (Criteria) this;
        }

        public Criteria andCheckClauseNotLike(String value) {
            addCriterion("check_clause not like", value, "checkClause");
            return (Criteria) this;
        }

        public Criteria andCheckClauseIn(List<String> values) {
            addCriterion("check_clause in", values, "checkClause");
            return (Criteria) this;
        }

        public Criteria andCheckClauseNotIn(List<String> values) {
            addCriterion("check_clause not in", values, "checkClause");
            return (Criteria) this;
        }

        public Criteria andCheckClauseBetween(String value1, String value2) {
            addCriterion("check_clause between", value1, value2, "checkClause");
            return (Criteria) this;
        }

        public Criteria andCheckClauseNotBetween(String value1, String value2) {
            addCriterion("check_clause not between", value1, value2, "checkClause");
            return (Criteria) this;
        }

        public Criteria andImproveOpinionIsNull() {
            addCriterion("improve_opinion is null");
            return (Criteria) this;
        }

        public Criteria andImproveOpinionIsNotNull() {
            addCriterion("improve_opinion is not null");
            return (Criteria) this;
        }

        public Criteria andImproveOpinionEqualTo(String value) {
            addCriterion("improve_opinion =", value, "improveOpinion");
            return (Criteria) this;
        }

        public Criteria andImproveOpinionNotEqualTo(String value) {
            addCriterion("improve_opinion <>", value, "improveOpinion");
            return (Criteria) this;
        }

        public Criteria andImproveOpinionGreaterThan(String value) {
            addCriterion("improve_opinion >", value, "improveOpinion");
            return (Criteria) this;
        }

        public Criteria andImproveOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("improve_opinion >=", value, "improveOpinion");
            return (Criteria) this;
        }

        public Criteria andImproveOpinionLessThan(String value) {
            addCriterion("improve_opinion <", value, "improveOpinion");
            return (Criteria) this;
        }

        public Criteria andImproveOpinionLessThanOrEqualTo(String value) {
            addCriterion("improve_opinion <=", value, "improveOpinion");
            return (Criteria) this;
        }

        public Criteria andImproveOpinionLike(String value) {
            addCriterion("improve_opinion like", value, "improveOpinion");
            return (Criteria) this;
        }

        public Criteria andImproveOpinionNotLike(String value) {
            addCriterion("improve_opinion not like", value, "improveOpinion");
            return (Criteria) this;
        }

        public Criteria andImproveOpinionIn(List<String> values) {
            addCriterion("improve_opinion in", values, "improveOpinion");
            return (Criteria) this;
        }

        public Criteria andImproveOpinionNotIn(List<String> values) {
            addCriterion("improve_opinion not in", values, "improveOpinion");
            return (Criteria) this;
        }

        public Criteria andImproveOpinionBetween(String value1, String value2) {
            addCriterion("improve_opinion between", value1, value2, "improveOpinion");
            return (Criteria) this;
        }

        public Criteria andImproveOpinionNotBetween(String value1, String value2) {
            addCriterion("improve_opinion not between", value1, value2, "improveOpinion");
            return (Criteria) this;
        }

        public Criteria andCheckStandardIsNull() {
            addCriterion("check_standard is null");
            return (Criteria) this;
        }

        public Criteria andCheckStandardIsNotNull() {
            addCriterion("check_standard is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStandardEqualTo(String value) {
            addCriterion("check_standard =", value, "checkStandard");
            return (Criteria) this;
        }

        public Criteria andCheckStandardNotEqualTo(String value) {
            addCriterion("check_standard <>", value, "checkStandard");
            return (Criteria) this;
        }

        public Criteria andCheckStandardGreaterThan(String value) {
            addCriterion("check_standard >", value, "checkStandard");
            return (Criteria) this;
        }

        public Criteria andCheckStandardGreaterThanOrEqualTo(String value) {
            addCriterion("check_standard >=", value, "checkStandard");
            return (Criteria) this;
        }

        public Criteria andCheckStandardLessThan(String value) {
            addCriterion("check_standard <", value, "checkStandard");
            return (Criteria) this;
        }

        public Criteria andCheckStandardLessThanOrEqualTo(String value) {
            addCriterion("check_standard <=", value, "checkStandard");
            return (Criteria) this;
        }

        public Criteria andCheckStandardLike(String value) {
            addCriterion("check_standard like", value, "checkStandard");
            return (Criteria) this;
        }

        public Criteria andCheckStandardNotLike(String value) {
            addCriterion("check_standard not like", value, "checkStandard");
            return (Criteria) this;
        }

        public Criteria andCheckStandardIn(List<String> values) {
            addCriterion("check_standard in", values, "checkStandard");
            return (Criteria) this;
        }

        public Criteria andCheckStandardNotIn(List<String> values) {
            addCriterion("check_standard not in", values, "checkStandard");
            return (Criteria) this;
        }

        public Criteria andCheckStandardBetween(String value1, String value2) {
            addCriterion("check_standard between", value1, value2, "checkStandard");
            return (Criteria) this;
        }

        public Criteria andCheckStandardNotBetween(String value1, String value2) {
            addCriterion("check_standard not between", value1, value2, "checkStandard");
            return (Criteria) this;
        }

        public Criteria andDeductMarksIsNull() {
            addCriterion("deduct_marks is null");
            return (Criteria) this;
        }

        public Criteria andDeductMarksIsNotNull() {
            addCriterion("deduct_marks is not null");
            return (Criteria) this;
        }

        public Criteria andDeductMarksEqualTo(String value) {
            addCriterion("deduct_marks =", value, "deductMarks");
            return (Criteria) this;
        }

        public Criteria andDeductMarksNotEqualTo(String value) {
            addCriterion("deduct_marks <>", value, "deductMarks");
            return (Criteria) this;
        }

        public Criteria andDeductMarksGreaterThan(String value) {
            addCriterion("deduct_marks >", value, "deductMarks");
            return (Criteria) this;
        }

        public Criteria andDeductMarksGreaterThanOrEqualTo(String value) {
            addCriterion("deduct_marks >=", value, "deductMarks");
            return (Criteria) this;
        }

        public Criteria andDeductMarksLessThan(String value) {
            addCriterion("deduct_marks <", value, "deductMarks");
            return (Criteria) this;
        }

        public Criteria andDeductMarksLessThanOrEqualTo(String value) {
            addCriterion("deduct_marks <=", value, "deductMarks");
            return (Criteria) this;
        }

        public Criteria andDeductMarksLike(String value) {
            addCriterion("deduct_marks like", value, "deductMarks");
            return (Criteria) this;
        }

        public Criteria andDeductMarksNotLike(String value) {
            addCriterion("deduct_marks not like", value, "deductMarks");
            return (Criteria) this;
        }

        public Criteria andDeductMarksIn(List<String> values) {
            addCriterion("deduct_marks in", values, "deductMarks");
            return (Criteria) this;
        }

        public Criteria andDeductMarksNotIn(List<String> values) {
            addCriterion("deduct_marks not in", values, "deductMarks");
            return (Criteria) this;
        }

        public Criteria andDeductMarksBetween(String value1, String value2) {
            addCriterion("deduct_marks between", value1, value2, "deductMarks");
            return (Criteria) this;
        }

        public Criteria andDeductMarksNotBetween(String value1, String value2) {
            addCriterion("deduct_marks not between", value1, value2, "deductMarks");
            return (Criteria) this;
        }

        public Criteria andGrantStatusIsNull() {
            addCriterion("grant_status is null");
            return (Criteria) this;
        }

        public Criteria andGrantStatusIsNotNull() {
            addCriterion("grant_status is not null");
            return (Criteria) this;
        }

        public Criteria andGrantStatusEqualTo(String value) {
            addCriterion("grant_status =", value, "grantStatus");
            return (Criteria) this;
        }

        public Criteria andGrantStatusNotEqualTo(String value) {
            addCriterion("grant_status <>", value, "grantStatus");
            return (Criteria) this;
        }

        public Criteria andGrantStatusGreaterThan(String value) {
            addCriterion("grant_status >", value, "grantStatus");
            return (Criteria) this;
        }

        public Criteria andGrantStatusGreaterThanOrEqualTo(String value) {
            addCriterion("grant_status >=", value, "grantStatus");
            return (Criteria) this;
        }

        public Criteria andGrantStatusLessThan(String value) {
            addCriterion("grant_status <", value, "grantStatus");
            return (Criteria) this;
        }

        public Criteria andGrantStatusLessThanOrEqualTo(String value) {
            addCriterion("grant_status <=", value, "grantStatus");
            return (Criteria) this;
        }

        public Criteria andGrantStatusLike(String value) {
            addCriterion("grant_status like", value, "grantStatus");
            return (Criteria) this;
        }

        public Criteria andGrantStatusNotLike(String value) {
            addCriterion("grant_status not like", value, "grantStatus");
            return (Criteria) this;
        }

        public Criteria andGrantStatusIn(List<String> values) {
            addCriterion("grant_status in", values, "grantStatus");
            return (Criteria) this;
        }

        public Criteria andGrantStatusNotIn(List<String> values) {
            addCriterion("grant_status not in", values, "grantStatus");
            return (Criteria) this;
        }

        public Criteria andGrantStatusBetween(String value1, String value2) {
            addCriterion("grant_status between", value1, value2, "grantStatus");
            return (Criteria) this;
        }

        public Criteria andGrantStatusNotBetween(String value1, String value2) {
            addCriterion("grant_status not between", value1, value2, "grantStatus");
            return (Criteria) this;
        }

        public Criteria andCheckIdIsNull() {
            addCriterion("check_id is null");
            return (Criteria) this;
        }

        public Criteria andCheckIdIsNotNull() {
            addCriterion("check_id is not null");
            return (Criteria) this;
        }

        public Criteria andCheckIdEqualTo(String value) {
            addCriterion("check_id =", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdNotEqualTo(String value) {
            addCriterion("check_id <>", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdGreaterThan(String value) {
            addCriterion("check_id >", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdGreaterThanOrEqualTo(String value) {
            addCriterion("check_id >=", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdLessThan(String value) {
            addCriterion("check_id <", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdLessThanOrEqualTo(String value) {
            addCriterion("check_id <=", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdLike(String value) {
            addCriterion("check_id like", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdNotLike(String value) {
            addCriterion("check_id not like", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdIn(List<String> values) {
            addCriterion("check_id in", values, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdNotIn(List<String> values) {
            addCriterion("check_id not in", values, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdBetween(String value1, String value2) {
            addCriterion("check_id between", value1, value2, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdNotBetween(String value1, String value2) {
            addCriterion("check_id not between", value1, value2, "checkId");
            return (Criteria) this;
        }

        public Criteria andPayMoneyIsNull() {
            addCriterion("pay_money is null");
            return (Criteria) this;
        }

        public Criteria andPayMoneyIsNotNull() {
            addCriterion("pay_money is not null");
            return (Criteria) this;
        }

        public Criteria andPayMoneyEqualTo(String value) {
            addCriterion("pay_money =", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyNotEqualTo(String value) {
            addCriterion("pay_money <>", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyGreaterThan(String value) {
            addCriterion("pay_money >", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("pay_money >=", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyLessThan(String value) {
            addCriterion("pay_money <", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyLessThanOrEqualTo(String value) {
            addCriterion("pay_money <=", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyLike(String value) {
            addCriterion("pay_money like", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyNotLike(String value) {
            addCriterion("pay_money not like", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyIn(List<String> values) {
            addCriterion("pay_money in", values, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyNotIn(List<String> values) {
            addCriterion("pay_money not in", values, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyBetween(String value1, String value2) {
            addCriterion("pay_money between", value1, value2, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyNotBetween(String value1, String value2) {
            addCriterion("pay_money not between", value1, value2, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayDateIsNull() {
            addCriterion("pay_date is null");
            return (Criteria) this;
        }

        public Criteria andPayDateIsNotNull() {
            addCriterion("pay_date is not null");
            return (Criteria) this;
        }

        public Criteria andPayDateEqualTo(String value) {
            addCriterion("pay_date =", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateNotEqualTo(String value) {
            addCriterion("pay_date <>", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateGreaterThan(String value) {
            addCriterion("pay_date >", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateGreaterThanOrEqualTo(String value) {
            addCriterion("pay_date >=", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateLessThan(String value) {
            addCriterion("pay_date <", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateLessThanOrEqualTo(String value) {
            addCriterion("pay_date <=", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateLike(String value) {
            addCriterion("pay_date like", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateNotLike(String value) {
            addCriterion("pay_date not like", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateIn(List<String> values) {
            addCriterion("pay_date in", values, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateNotIn(List<String> values) {
            addCriterion("pay_date not in", values, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateBetween(String value1, String value2) {
            addCriterion("pay_date between", value1, value2, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateNotBetween(String value1, String value2) {
            addCriterion("pay_date not between", value1, value2, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayAccountIsNull() {
            addCriterion("pay_account is null");
            return (Criteria) this;
        }

        public Criteria andPayAccountIsNotNull() {
            addCriterion("pay_account is not null");
            return (Criteria) this;
        }

        public Criteria andPayAccountEqualTo(String value) {
            addCriterion("pay_account =", value, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountNotEqualTo(String value) {
            addCriterion("pay_account <>", value, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountGreaterThan(String value) {
            addCriterion("pay_account >", value, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountGreaterThanOrEqualTo(String value) {
            addCriterion("pay_account >=", value, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountLessThan(String value) {
            addCriterion("pay_account <", value, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountLessThanOrEqualTo(String value) {
            addCriterion("pay_account <=", value, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountLike(String value) {
            addCriterion("pay_account like", value, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountNotLike(String value) {
            addCriterion("pay_account not like", value, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountIn(List<String> values) {
            addCriterion("pay_account in", values, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountNotIn(List<String> values) {
            addCriterion("pay_account not in", values, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountBetween(String value1, String value2) {
            addCriterion("pay_account between", value1, value2, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountNotBetween(String value1, String value2) {
            addCriterion("pay_account not between", value1, value2, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNull() {
            addCriterion("pay_status is null");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNotNull() {
            addCriterion("pay_status is not null");
            return (Criteria) this;
        }

        public Criteria andPayStatusEqualTo(String value) {
            addCriterion("pay_status =", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotEqualTo(String value) {
            addCriterion("pay_status <>", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThan(String value) {
            addCriterion("pay_status >", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThanOrEqualTo(String value) {
            addCriterion("pay_status >=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThan(String value) {
            addCriterion("pay_status <", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThanOrEqualTo(String value) {
            addCriterion("pay_status <=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLike(String value) {
            addCriterion("pay_status like", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotLike(String value) {
            addCriterion("pay_status not like", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusIn(List<String> values) {
            addCriterion("pay_status in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotIn(List<String> values) {
            addCriterion("pay_status not in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusBetween(String value1, String value2) {
            addCriterion("pay_status between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotBetween(String value1, String value2) {
            addCriterion("pay_status not between", value1, value2, "payStatus");
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