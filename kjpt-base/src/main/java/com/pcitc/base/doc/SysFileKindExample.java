package com.pcitc.base.doc;

import java.util.ArrayList;
import java.util.List;

public class SysFileKindExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysFileKindExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIdIsNull() {
            addCriterion("create_person_id is null");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIdIsNotNull() {
            addCriterion("create_person_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIdEqualTo(String value) {
            addCriterion("create_person_id =", value, "createPersonId");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIdNotEqualTo(String value) {
            addCriterion("create_person_id <>", value, "createPersonId");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIdGreaterThan(String value) {
            addCriterion("create_person_id >", value, "createPersonId");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIdGreaterThanOrEqualTo(String value) {
            addCriterion("create_person_id >=", value, "createPersonId");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIdLessThan(String value) {
            addCriterion("create_person_id <", value, "createPersonId");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIdLessThanOrEqualTo(String value) {
            addCriterion("create_person_id <=", value, "createPersonId");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIdLike(String value) {
            addCriterion("create_person_id like", value, "createPersonId");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIdNotLike(String value) {
            addCriterion("create_person_id not like", value, "createPersonId");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIdIn(List<String> values) {
            addCriterion("create_person_id in", values, "createPersonId");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIdNotIn(List<String> values) {
            addCriterion("create_person_id not in", values, "createPersonId");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIdBetween(String value1, String value2) {
            addCriterion("create_person_id between", value1, value2, "createPersonId");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIdNotBetween(String value1, String value2) {
            addCriterion("create_person_id not between", value1, value2, "createPersonId");
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

        public Criteria andRamarksIsNull() {
            addCriterion("ramarks is null");
            return (Criteria) this;
        }

        public Criteria andRamarksIsNotNull() {
            addCriterion("ramarks is not null");
            return (Criteria) this;
        }

        public Criteria andRamarksEqualTo(String value) {
            addCriterion("ramarks =", value, "ramarks");
            return (Criteria) this;
        }

        public Criteria andRamarksNotEqualTo(String value) {
            addCriterion("ramarks <>", value, "ramarks");
            return (Criteria) this;
        }

        public Criteria andRamarksGreaterThan(String value) {
            addCriterion("ramarks >", value, "ramarks");
            return (Criteria) this;
        }

        public Criteria andRamarksGreaterThanOrEqualTo(String value) {
            addCriterion("ramarks >=", value, "ramarks");
            return (Criteria) this;
        }

        public Criteria andRamarksLessThan(String value) {
            addCriterion("ramarks <", value, "ramarks");
            return (Criteria) this;
        }

        public Criteria andRamarksLessThanOrEqualTo(String value) {
            addCriterion("ramarks <=", value, "ramarks");
            return (Criteria) this;
        }

        public Criteria andRamarksLike(String value) {
            addCriterion("ramarks like", value, "ramarks");
            return (Criteria) this;
        }

        public Criteria andRamarksNotLike(String value) {
            addCriterion("ramarks not like", value, "ramarks");
            return (Criteria) this;
        }

        public Criteria andRamarksIn(List<String> values) {
            addCriterion("ramarks in", values, "ramarks");
            return (Criteria) this;
        }

        public Criteria andRamarksNotIn(List<String> values) {
            addCriterion("ramarks not in", values, "ramarks");
            return (Criteria) this;
        }

        public Criteria andRamarksBetween(String value1, String value2) {
            addCriterion("ramarks between", value1, value2, "ramarks");
            return (Criteria) this;
        }

        public Criteria andRamarksNotBetween(String value1, String value2) {
            addCriterion("ramarks not between", value1, value2, "ramarks");
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

        public Criteria andUpdatePersonIdIsNull() {
            addCriterion("update_person_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonIdIsNotNull() {
            addCriterion("update_person_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonIdEqualTo(String value) {
            addCriterion("update_person_id =", value, "updatePersonId");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonIdNotEqualTo(String value) {
            addCriterion("update_person_id <>", value, "updatePersonId");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonIdGreaterThan(String value) {
            addCriterion("update_person_id >", value, "updatePersonId");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonIdGreaterThanOrEqualTo(String value) {
            addCriterion("update_person_id >=", value, "updatePersonId");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonIdLessThan(String value) {
            addCriterion("update_person_id <", value, "updatePersonId");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonIdLessThanOrEqualTo(String value) {
            addCriterion("update_person_id <=", value, "updatePersonId");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonIdLike(String value) {
            addCriterion("update_person_id like", value, "updatePersonId");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonIdNotLike(String value) {
            addCriterion("update_person_id not like", value, "updatePersonId");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonIdIn(List<String> values) {
            addCriterion("update_person_id in", values, "updatePersonId");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonIdNotIn(List<String> values) {
            addCriterion("update_person_id not in", values, "updatePersonId");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonIdBetween(String value1, String value2) {
            addCriterion("update_person_id between", value1, value2, "updatePersonId");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonIdNotBetween(String value1, String value2) {
            addCriterion("update_person_id not between", value1, value2, "updatePersonId");
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

        public Criteria andUpdatePersonNameIsNull() {
            addCriterion("update_person_name is null");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonNameIsNotNull() {
            addCriterion("update_person_name is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonNameEqualTo(String value) {
            addCriterion("update_person_name =", value, "updatePersonName");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonNameNotEqualTo(String value) {
            addCriterion("update_person_name <>", value, "updatePersonName");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonNameGreaterThan(String value) {
            addCriterion("update_person_name >", value, "updatePersonName");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonNameGreaterThanOrEqualTo(String value) {
            addCriterion("update_person_name >=", value, "updatePersonName");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonNameLessThan(String value) {
            addCriterion("update_person_name <", value, "updatePersonName");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonNameLessThanOrEqualTo(String value) {
            addCriterion("update_person_name <=", value, "updatePersonName");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonNameLike(String value) {
            addCriterion("update_person_name like", value, "updatePersonName");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonNameNotLike(String value) {
            addCriterion("update_person_name not like", value, "updatePersonName");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonNameIn(List<String> values) {
            addCriterion("update_person_name in", values, "updatePersonName");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonNameNotIn(List<String> values) {
            addCriterion("update_person_name not in", values, "updatePersonName");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonNameBetween(String value1, String value2) {
            addCriterion("update_person_name between", value1, value2, "updatePersonName");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonNameNotBetween(String value1, String value2) {
            addCriterion("update_person_name not between", value1, value2, "updatePersonName");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNameIsNull() {
            addCriterion("create_person_name is null");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNameIsNotNull() {
            addCriterion("create_person_name is not null");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNameEqualTo(String value) {
            addCriterion("create_person_name =", value, "createPersonName");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNameNotEqualTo(String value) {
            addCriterion("create_person_name <>", value, "createPersonName");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNameGreaterThan(String value) {
            addCriterion("create_person_name >", value, "createPersonName");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNameGreaterThanOrEqualTo(String value) {
            addCriterion("create_person_name >=", value, "createPersonName");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNameLessThan(String value) {
            addCriterion("create_person_name <", value, "createPersonName");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNameLessThanOrEqualTo(String value) {
            addCriterion("create_person_name <=", value, "createPersonName");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNameLike(String value) {
            addCriterion("create_person_name like", value, "createPersonName");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNameNotLike(String value) {
            addCriterion("create_person_name not like", value, "createPersonName");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNameIn(List<String> values) {
            addCriterion("create_person_name in", values, "createPersonName");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNameNotIn(List<String> values) {
            addCriterion("create_person_name not in", values, "createPersonName");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNameBetween(String value1, String value2) {
            addCriterion("create_person_name between", value1, value2, "createPersonName");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNameNotBetween(String value1, String value2) {
            addCriterion("create_person_name not between", value1, value2, "createPersonName");
            return (Criteria) this;
        }

        public Criteria andKindNameIsNull() {
            addCriterion("kind_name is null");
            return (Criteria) this;
        }

        public Criteria andKindNameIsNotNull() {
            addCriterion("kind_name is not null");
            return (Criteria) this;
        }

        public Criteria andKindNameEqualTo(String value) {
            addCriterion("kind_name =", value, "kindName");
            return (Criteria) this;
        }

        public Criteria andKindNameNotEqualTo(String value) {
            addCriterion("kind_name <>", value, "kindName");
            return (Criteria) this;
        }

        public Criteria andKindNameGreaterThan(String value) {
            addCriterion("kind_name >", value, "kindName");
            return (Criteria) this;
        }

        public Criteria andKindNameGreaterThanOrEqualTo(String value) {
            addCriterion("kind_name >=", value, "kindName");
            return (Criteria) this;
        }

        public Criteria andKindNameLessThan(String value) {
            addCriterion("kind_name <", value, "kindName");
            return (Criteria) this;
        }

        public Criteria andKindNameLessThanOrEqualTo(String value) {
            addCriterion("kind_name <=", value, "kindName");
            return (Criteria) this;
        }

        public Criteria andKindNameLike(String value) {
            addCriterion("kind_name like", value, "kindName");
            return (Criteria) this;
        }

        public Criteria andKindNameNotLike(String value) {
            addCriterion("kind_name not like", value, "kindName");
            return (Criteria) this;
        }

        public Criteria andKindNameIn(List<String> values) {
            addCriterion("kind_name in", values, "kindName");
            return (Criteria) this;
        }

        public Criteria andKindNameNotIn(List<String> values) {
            addCriterion("kind_name not in", values, "kindName");
            return (Criteria) this;
        }

        public Criteria andKindNameBetween(String value1, String value2) {
            addCriterion("kind_name between", value1, value2, "kindName");
            return (Criteria) this;
        }

        public Criteria andKindNameNotBetween(String value1, String value2) {
            addCriterion("kind_name not between", value1, value2, "kindName");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(String value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(String value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(String value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(String value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(String value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLike(String value) {
            addCriterion("parent_id like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotLike(String value) {
            addCriterion("parent_id not like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<String> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<String> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(String value1, String value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(String value1, String value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andDelIsNull() {
            addCriterion("del is null");
            return (Criteria) this;
        }

        public Criteria andDelIsNotNull() {
            addCriterion("del is not null");
            return (Criteria) this;
        }

        public Criteria andDelEqualTo(String value) {
            addCriterion("del =", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelNotEqualTo(String value) {
            addCriterion("del <>", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelGreaterThan(String value) {
            addCriterion("del >", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelGreaterThanOrEqualTo(String value) {
            addCriterion("del >=", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelLessThan(String value) {
            addCriterion("del <", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelLessThanOrEqualTo(String value) {
            addCriterion("del <=", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelLike(String value) {
            addCriterion("del like", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelNotLike(String value) {
            addCriterion("del not like", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelIn(List<String> values) {
            addCriterion("del in", values, "del");
            return (Criteria) this;
        }

        public Criteria andDelNotIn(List<String> values) {
            addCriterion("del not in", values, "del");
            return (Criteria) this;
        }

        public Criteria andDelBetween(String value1, String value2) {
            addCriterion("del between", value1, value2, "del");
            return (Criteria) this;
        }

        public Criteria andDelNotBetween(String value1, String value2) {
            addCriterion("del not between", value1, value2, "del");
            return (Criteria) this;
        }

        public Criteria andOtherIsNull() {
            addCriterion("other is null");
            return (Criteria) this;
        }

        public Criteria andOtherIsNotNull() {
            addCriterion("other is not null");
            return (Criteria) this;
        }

        public Criteria andOtherEqualTo(String value) {
            addCriterion("other =", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotEqualTo(String value) {
            addCriterion("other <>", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThan(String value) {
            addCriterion("other >", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThanOrEqualTo(String value) {
            addCriterion("other >=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThan(String value) {
            addCriterion("other <", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThanOrEqualTo(String value) {
            addCriterion("other <=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLike(String value) {
            addCriterion("other like", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotLike(String value) {
            addCriterion("other not like", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherIn(List<String> values) {
            addCriterion("other in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotIn(List<String> values) {
            addCriterion("other not in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherBetween(String value1, String value2) {
            addCriterion("other between", value1, value2, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotBetween(String value1, String value2) {
            addCriterion("other not between", value1, value2, "other");
            return (Criteria) this;
        }

        public Criteria andKindPathIsNull() {
            addCriterion("kind_path is null");
            return (Criteria) this;
        }

        public Criteria andKindPathIsNotNull() {
            addCriterion("kind_path is not null");
            return (Criteria) this;
        }

        public Criteria andKindPathEqualTo(String value) {
            addCriterion("kind_path =", value, "kindPath");
            return (Criteria) this;
        }

        public Criteria andKindPathNotEqualTo(String value) {
            addCriterion("kind_path <>", value, "kindPath");
            return (Criteria) this;
        }

        public Criteria andKindPathGreaterThan(String value) {
            addCriterion("kind_path >", value, "kindPath");
            return (Criteria) this;
        }

        public Criteria andKindPathGreaterThanOrEqualTo(String value) {
            addCriterion("kind_path >=", value, "kindPath");
            return (Criteria) this;
        }

        public Criteria andKindPathLessThan(String value) {
            addCriterion("kind_path <", value, "kindPath");
            return (Criteria) this;
        }

        public Criteria andKindPathLessThanOrEqualTo(String value) {
            addCriterion("kind_path <=", value, "kindPath");
            return (Criteria) this;
        }

        public Criteria andKindPathLike(String value) {
            addCriterion("kind_path like", value, "kindPath");
            return (Criteria) this;
        }

        public Criteria andKindPathNotLike(String value) {
            addCriterion("kind_path not like", value, "kindPath");
            return (Criteria) this;
        }

        public Criteria andKindPathIn(List<String> values) {
            addCriterion("kind_path in", values, "kindPath");
            return (Criteria) this;
        }

        public Criteria andKindPathNotIn(List<String> values) {
            addCriterion("kind_path not in", values, "kindPath");
            return (Criteria) this;
        }

        public Criteria andKindPathBetween(String value1, String value2) {
            addCriterion("kind_path between", value1, value2, "kindPath");
            return (Criteria) this;
        }

        public Criteria andKindPathNotBetween(String value1, String value2) {
            addCriterion("kind_path not between", value1, value2, "kindPath");
            return (Criteria) this;
        }

        public Criteria andKindLevelIsNull() {
            addCriterion("kind_level is null");
            return (Criteria) this;
        }

        public Criteria andKindLevelIsNotNull() {
            addCriterion("kind_level is not null");
            return (Criteria) this;
        }

        public Criteria andKindLevelEqualTo(String value) {
            addCriterion("kind_level =", value, "kindLevel");
            return (Criteria) this;
        }

        public Criteria andKindLevelNotEqualTo(String value) {
            addCriterion("kind_level <>", value, "kindLevel");
            return (Criteria) this;
        }

        public Criteria andKindLevelGreaterThan(String value) {
            addCriterion("kind_level >", value, "kindLevel");
            return (Criteria) this;
        }

        public Criteria andKindLevelGreaterThanOrEqualTo(String value) {
            addCriterion("kind_level >=", value, "kindLevel");
            return (Criteria) this;
        }

        public Criteria andKindLevelLessThan(String value) {
            addCriterion("kind_level <", value, "kindLevel");
            return (Criteria) this;
        }

        public Criteria andKindLevelLessThanOrEqualTo(String value) {
            addCriterion("kind_level <=", value, "kindLevel");
            return (Criteria) this;
        }

        public Criteria andKindLevelLike(String value) {
            addCriterion("kind_level like", value, "kindLevel");
            return (Criteria) this;
        }

        public Criteria andKindLevelNotLike(String value) {
            addCriterion("kind_level not like", value, "kindLevel");
            return (Criteria) this;
        }

        public Criteria andKindLevelIn(List<String> values) {
            addCriterion("kind_level in", values, "kindLevel");
            return (Criteria) this;
        }

        public Criteria andKindLevelNotIn(List<String> values) {
            addCriterion("kind_level not in", values, "kindLevel");
            return (Criteria) this;
        }

        public Criteria andKindLevelBetween(String value1, String value2) {
            addCriterion("kind_level between", value1, value2, "kindLevel");
            return (Criteria) this;
        }

        public Criteria andKindLevelNotBetween(String value1, String value2) {
            addCriterion("kind_level not between", value1, value2, "kindLevel");
            return (Criteria) this;
        }

        public Criteria andKindLeafIsNull() {
            addCriterion("kind_leaf is null");
            return (Criteria) this;
        }

        public Criteria andKindLeafIsNotNull() {
            addCriterion("kind_leaf is not null");
            return (Criteria) this;
        }

        public Criteria andKindLeafEqualTo(String value) {
            addCriterion("kind_leaf =", value, "kindLeaf");
            return (Criteria) this;
        }

        public Criteria andKindLeafNotEqualTo(String value) {
            addCriterion("kind_leaf <>", value, "kindLeaf");
            return (Criteria) this;
        }

        public Criteria andKindLeafGreaterThan(String value) {
            addCriterion("kind_leaf >", value, "kindLeaf");
            return (Criteria) this;
        }

        public Criteria andKindLeafGreaterThanOrEqualTo(String value) {
            addCriterion("kind_leaf >=", value, "kindLeaf");
            return (Criteria) this;
        }

        public Criteria andKindLeafLessThan(String value) {
            addCriterion("kind_leaf <", value, "kindLeaf");
            return (Criteria) this;
        }

        public Criteria andKindLeafLessThanOrEqualTo(String value) {
            addCriterion("kind_leaf <=", value, "kindLeaf");
            return (Criteria) this;
        }

        public Criteria andKindLeafLike(String value) {
            addCriterion("kind_leaf like", value, "kindLeaf");
            return (Criteria) this;
        }

        public Criteria andKindLeafNotLike(String value) {
            addCriterion("kind_leaf not like", value, "kindLeaf");
            return (Criteria) this;
        }

        public Criteria andKindLeafIn(List<String> values) {
            addCriterion("kind_leaf in", values, "kindLeaf");
            return (Criteria) this;
        }

        public Criteria andKindLeafNotIn(List<String> values) {
            addCriterion("kind_leaf not in", values, "kindLeaf");
            return (Criteria) this;
        }

        public Criteria andKindLeafBetween(String value1, String value2) {
            addCriterion("kind_leaf between", value1, value2, "kindLeaf");
            return (Criteria) this;
        }

        public Criteria andKindLeafNotBetween(String value1, String value2) {
            addCriterion("kind_leaf not between", value1, value2, "kindLeaf");
            return (Criteria) this;
        }

        public Criteria andKindCodeIsNull() {
            addCriterion("kind_code is null");
            return (Criteria) this;
        }

        public Criteria andKindCodeIsNotNull() {
            addCriterion("kind_code is not null");
            return (Criteria) this;
        }

        public Criteria andKindCodeEqualTo(String value) {
            addCriterion("kind_code =", value, "kindCode");
            return (Criteria) this;
        }

        public Criteria andKindCodeNotEqualTo(String value) {
            addCriterion("kind_code <>", value, "kindCode");
            return (Criteria) this;
        }

        public Criteria andKindCodeGreaterThan(String value) {
            addCriterion("kind_code >", value, "kindCode");
            return (Criteria) this;
        }

        public Criteria andKindCodeGreaterThanOrEqualTo(String value) {
            addCriterion("kind_code >=", value, "kindCode");
            return (Criteria) this;
        }

        public Criteria andKindCodeLessThan(String value) {
            addCriterion("kind_code <", value, "kindCode");
            return (Criteria) this;
        }

        public Criteria andKindCodeLessThanOrEqualTo(String value) {
            addCriterion("kind_code <=", value, "kindCode");
            return (Criteria) this;
        }

        public Criteria andKindCodeLike(String value) {
            addCriterion("kind_code like", value, "kindCode");
            return (Criteria) this;
        }

        public Criteria andKindCodeNotLike(String value) {
            addCriterion("kind_code not like", value, "kindCode");
            return (Criteria) this;
        }

        public Criteria andKindCodeIn(List<String> values) {
            addCriterion("kind_code in", values, "kindCode");
            return (Criteria) this;
        }

        public Criteria andKindCodeNotIn(List<String> values) {
            addCriterion("kind_code not in", values, "kindCode");
            return (Criteria) this;
        }

        public Criteria andKindCodeBetween(String value1, String value2) {
            addCriterion("kind_code between", value1, value2, "kindCode");
            return (Criteria) this;
        }

        public Criteria andKindCodeNotBetween(String value1, String value2) {
            addCriterion("kind_code not between", value1, value2, "kindCode");
            return (Criteria) this;
        }

        public Criteria andBak9IsNull() {
            addCriterion("bak9 is null");
            return (Criteria) this;
        }

        public Criteria andBak9IsNotNull() {
            addCriterion("bak9 is not null");
            return (Criteria) this;
        }

        public Criteria andBak9EqualTo(String value) {
            addCriterion("bak9 =", value, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9NotEqualTo(String value) {
            addCriterion("bak9 <>", value, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9GreaterThan(String value) {
            addCriterion("bak9 >", value, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9GreaterThanOrEqualTo(String value) {
            addCriterion("bak9 >=", value, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9LessThan(String value) {
            addCriterion("bak9 <", value, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9LessThanOrEqualTo(String value) {
            addCriterion("bak9 <=", value, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9Like(String value) {
            addCriterion("bak9 like", value, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9NotLike(String value) {
            addCriterion("bak9 not like", value, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9In(List<String> values) {
            addCriterion("bak9 in", values, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9NotIn(List<String> values) {
            addCriterion("bak9 not in", values, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9Between(String value1, String value2) {
            addCriterion("bak9 between", value1, value2, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9NotBetween(String value1, String value2) {
            addCriterion("bak9 not between", value1, value2, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak10IsNull() {
            addCriterion("bak10 is null");
            return (Criteria) this;
        }

        public Criteria andBak10IsNotNull() {
            addCriterion("bak10 is not null");
            return (Criteria) this;
        }

        public Criteria andBak10EqualTo(String value) {
            addCriterion("bak10 =", value, "bak10");
            return (Criteria) this;
        }

        public Criteria andBak10NotEqualTo(String value) {
            addCriterion("bak10 <>", value, "bak10");
            return (Criteria) this;
        }

        public Criteria andBak10GreaterThan(String value) {
            addCriterion("bak10 >", value, "bak10");
            return (Criteria) this;
        }

        public Criteria andBak10GreaterThanOrEqualTo(String value) {
            addCriterion("bak10 >=", value, "bak10");
            return (Criteria) this;
        }

        public Criteria andBak10LessThan(String value) {
            addCriterion("bak10 <", value, "bak10");
            return (Criteria) this;
        }

        public Criteria andBak10LessThanOrEqualTo(String value) {
            addCriterion("bak10 <=", value, "bak10");
            return (Criteria) this;
        }

        public Criteria andBak10Like(String value) {
            addCriterion("bak10 like", value, "bak10");
            return (Criteria) this;
        }

        public Criteria andBak10NotLike(String value) {
            addCriterion("bak10 not like", value, "bak10");
            return (Criteria) this;
        }

        public Criteria andBak10In(List<String> values) {
            addCriterion("bak10 in", values, "bak10");
            return (Criteria) this;
        }

        public Criteria andBak10NotIn(List<String> values) {
            addCriterion("bak10 not in", values, "bak10");
            return (Criteria) this;
        }

        public Criteria andBak10Between(String value1, String value2) {
            addCriterion("bak10 between", value1, value2, "bak10");
            return (Criteria) this;
        }

        public Criteria andBak10NotBetween(String value1, String value2) {
            addCriterion("bak10 not between", value1, value2, "bak10");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("version like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("version not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<String> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<String> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andIniidIsNull() {
            addCriterion("iniId is null");
            return (Criteria) this;
        }

        public Criteria andIniidIsNotNull() {
            addCriterion("iniId is not null");
            return (Criteria) this;
        }

        public Criteria andIniidEqualTo(String value) {
            addCriterion("iniId =", value, "iniid");
            return (Criteria) this;
        }

        public Criteria andIniidNotEqualTo(String value) {
            addCriterion("iniId <>", value, "iniid");
            return (Criteria) this;
        }

        public Criteria andIniidGreaterThan(String value) {
            addCriterion("iniId >", value, "iniid");
            return (Criteria) this;
        }

        public Criteria andIniidGreaterThanOrEqualTo(String value) {
            addCriterion("iniId >=", value, "iniid");
            return (Criteria) this;
        }

        public Criteria andIniidLessThan(String value) {
            addCriterion("iniId <", value, "iniid");
            return (Criteria) this;
        }

        public Criteria andIniidLessThanOrEqualTo(String value) {
            addCriterion("iniId <=", value, "iniid");
            return (Criteria) this;
        }

        public Criteria andIniidLike(String value) {
            addCriterion("iniId like", value, "iniid");
            return (Criteria) this;
        }

        public Criteria andIniidNotLike(String value) {
            addCriterion("iniId not like", value, "iniid");
            return (Criteria) this;
        }

        public Criteria andIniidIn(List<String> values) {
            addCriterion("iniId in", values, "iniid");
            return (Criteria) this;
        }

        public Criteria andIniidNotIn(List<String> values) {
            addCriterion("iniId not in", values, "iniid");
            return (Criteria) this;
        }

        public Criteria andIniidBetween(String value1, String value2) {
            addCriterion("iniId between", value1, value2, "iniid");
            return (Criteria) this;
        }

        public Criteria andIniidNotBetween(String value1, String value2) {
            addCriterion("iniId not between", value1, value2, "iniid");
            return (Criteria) this;
        }

        public Criteria andBak1IsNull() {
            addCriterion("bak1 is null");
            return (Criteria) this;
        }

        public Criteria andBak1IsNotNull() {
            addCriterion("bak1 is not null");
            return (Criteria) this;
        }

        public Criteria andBak1EqualTo(String value) {
            addCriterion("bak1 =", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1NotEqualTo(String value) {
            addCriterion("bak1 <>", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1GreaterThan(String value) {
            addCriterion("bak1 >", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1GreaterThanOrEqualTo(String value) {
            addCriterion("bak1 >=", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1LessThan(String value) {
            addCriterion("bak1 <", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1LessThanOrEqualTo(String value) {
            addCriterion("bak1 <=", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1Like(String value) {
            addCriterion("bak1 like", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1NotLike(String value) {
            addCriterion("bak1 not like", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1In(List<String> values) {
            addCriterion("bak1 in", values, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1NotIn(List<String> values) {
            addCriterion("bak1 not in", values, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1Between(String value1, String value2) {
            addCriterion("bak1 between", value1, value2, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1NotBetween(String value1, String value2) {
            addCriterion("bak1 not between", value1, value2, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak2IsNull() {
            addCriterion("bak2 is null");
            return (Criteria) this;
        }

        public Criteria andBak2IsNotNull() {
            addCriterion("bak2 is not null");
            return (Criteria) this;
        }

        public Criteria andBak2EqualTo(String value) {
            addCriterion("bak2 =", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2NotEqualTo(String value) {
            addCriterion("bak2 <>", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2GreaterThan(String value) {
            addCriterion("bak2 >", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2GreaterThanOrEqualTo(String value) {
            addCriterion("bak2 >=", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2LessThan(String value) {
            addCriterion("bak2 <", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2LessThanOrEqualTo(String value) {
            addCriterion("bak2 <=", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2Like(String value) {
            addCriterion("bak2 like", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2NotLike(String value) {
            addCriterion("bak2 not like", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2In(List<String> values) {
            addCriterion("bak2 in", values, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2NotIn(List<String> values) {
            addCriterion("bak2 not in", values, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2Between(String value1, String value2) {
            addCriterion("bak2 between", value1, value2, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2NotBetween(String value1, String value2) {
            addCriterion("bak2 not between", value1, value2, "bak2");
            return (Criteria) this;
        }
    }

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