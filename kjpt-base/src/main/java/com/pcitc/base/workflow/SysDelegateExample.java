package com.pcitc.base.workflow;

import java.util.ArrayList;
import java.util.List;

public class SysDelegateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysDelegateExample() {
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

        public Criteria andDelegateIdIsNull() {
            addCriterion("delegate_id is null");
            return (Criteria) this;
        }

        public Criteria andDelegateIdIsNotNull() {
            addCriterion("delegate_id is not null");
            return (Criteria) this;
        }

        public Criteria andDelegateIdEqualTo(String value) {
            addCriterion("delegate_id =", value, "delegateId");
            return (Criteria) this;
        }

        public Criteria andDelegateIdNotEqualTo(String value) {
            addCriterion("delegate_id <>", value, "delegateId");
            return (Criteria) this;
        }

        public Criteria andDelegateIdGreaterThan(String value) {
            addCriterion("delegate_id >", value, "delegateId");
            return (Criteria) this;
        }

        public Criteria andDelegateIdGreaterThanOrEqualTo(String value) {
            addCriterion("delegate_id >=", value, "delegateId");
            return (Criteria) this;
        }

        public Criteria andDelegateIdLessThan(String value) {
            addCriterion("delegate_id <", value, "delegateId");
            return (Criteria) this;
        }

        public Criteria andDelegateIdLessThanOrEqualTo(String value) {
            addCriterion("delegate_id <=", value, "delegateId");
            return (Criteria) this;
        }

        public Criteria andDelegateIdLike(String value) {
            addCriterion("delegate_id like", value, "delegateId");
            return (Criteria) this;
        }

        public Criteria andDelegateIdNotLike(String value) {
            addCriterion("delegate_id not like", value, "delegateId");
            return (Criteria) this;
        }

        public Criteria andDelegateIdIn(List<String> values) {
            addCriterion("delegate_id in", values, "delegateId");
            return (Criteria) this;
        }

        public Criteria andDelegateIdNotIn(List<String> values) {
            addCriterion("delegate_id not in", values, "delegateId");
            return (Criteria) this;
        }

        public Criteria andDelegateIdBetween(String value1, String value2) {
            addCriterion("delegate_id between", value1, value2, "delegateId");
            return (Criteria) this;
        }

        public Criteria andDelegateIdNotBetween(String value1, String value2) {
            addCriterion("delegate_id not between", value1, value2, "delegateId");
            return (Criteria) this;
        }

        public Criteria andAssigneeCodeIsNull() {
            addCriterion("assignee_code is null");
            return (Criteria) this;
        }

        public Criteria andAssigneeCodeIsNotNull() {
            addCriterion("assignee_code is not null");
            return (Criteria) this;
        }

        public Criteria andAssigneeCodeEqualTo(String value) {
            addCriterion("assignee_code =", value, "assigneeCode");
            return (Criteria) this;
        }

        public Criteria andAssigneeCodeNotEqualTo(String value) {
            addCriterion("assignee_code <>", value, "assigneeCode");
            return (Criteria) this;
        }

        public Criteria andAssigneeCodeGreaterThan(String value) {
            addCriterion("assignee_code >", value, "assigneeCode");
            return (Criteria) this;
        }

        public Criteria andAssigneeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("assignee_code >=", value, "assigneeCode");
            return (Criteria) this;
        }

        public Criteria andAssigneeCodeLessThan(String value) {
            addCriterion("assignee_code <", value, "assigneeCode");
            return (Criteria) this;
        }

        public Criteria andAssigneeCodeLessThanOrEqualTo(String value) {
            addCriterion("assignee_code <=", value, "assigneeCode");
            return (Criteria) this;
        }

        public Criteria andAssigneeCodeLike(String value) {
            addCriterion("assignee_code like", value, "assigneeCode");
            return (Criteria) this;
        }

        public Criteria andAssigneeCodeNotLike(String value) {
            addCriterion("assignee_code not like", value, "assigneeCode");
            return (Criteria) this;
        }

        public Criteria andAssigneeCodeIn(List<String> values) {
            addCriterion("assignee_code in", values, "assigneeCode");
            return (Criteria) this;
        }

        public Criteria andAssigneeCodeNotIn(List<String> values) {
            addCriterion("assignee_code not in", values, "assigneeCode");
            return (Criteria) this;
        }

        public Criteria andAssigneeCodeBetween(String value1, String value2) {
            addCriterion("assignee_code between", value1, value2, "assigneeCode");
            return (Criteria) this;
        }

        public Criteria andAssigneeCodeNotBetween(String value1, String value2) {
            addCriterion("assignee_code not between", value1, value2, "assigneeCode");
            return (Criteria) this;
        }

        public Criteria andAssigneeNameIsNull() {
            addCriterion("assignee_name is null");
            return (Criteria) this;
        }

        public Criteria andAssigneeNameIsNotNull() {
            addCriterion("assignee_name is not null");
            return (Criteria) this;
        }

        public Criteria andAssigneeNameEqualTo(String value) {
            addCriterion("assignee_name =", value, "assigneeName");
            return (Criteria) this;
        }

        public Criteria andAssigneeNameNotEqualTo(String value) {
            addCriterion("assignee_name <>", value, "assigneeName");
            return (Criteria) this;
        }

        public Criteria andAssigneeNameGreaterThan(String value) {
            addCriterion("assignee_name >", value, "assigneeName");
            return (Criteria) this;
        }

        public Criteria andAssigneeNameGreaterThanOrEqualTo(String value) {
            addCriterion("assignee_name >=", value, "assigneeName");
            return (Criteria) this;
        }

        public Criteria andAssigneeNameLessThan(String value) {
            addCriterion("assignee_name <", value, "assigneeName");
            return (Criteria) this;
        }

        public Criteria andAssigneeNameLessThanOrEqualTo(String value) {
            addCriterion("assignee_name <=", value, "assigneeName");
            return (Criteria) this;
        }

        public Criteria andAssigneeNameLike(String value) {
            addCriterion("assignee_name like", value, "assigneeName");
            return (Criteria) this;
        }

        public Criteria andAssigneeNameNotLike(String value) {
            addCriterion("assignee_name not like", value, "assigneeName");
            return (Criteria) this;
        }

        public Criteria andAssigneeNameIn(List<String> values) {
            addCriterion("assignee_name in", values, "assigneeName");
            return (Criteria) this;
        }

        public Criteria andAssigneeNameNotIn(List<String> values) {
            addCriterion("assignee_name not in", values, "assigneeName");
            return (Criteria) this;
        }

        public Criteria andAssigneeNameBetween(String value1, String value2) {
            addCriterion("assignee_name between", value1, value2, "assigneeName");
            return (Criteria) this;
        }

        public Criteria andAssigneeNameNotBetween(String value1, String value2) {
            addCriterion("assignee_name not between", value1, value2, "assigneeName");
            return (Criteria) this;
        }

        public Criteria andAttorneyCodeIsNull() {
            addCriterion("attorney_code is null");
            return (Criteria) this;
        }

        public Criteria andAttorneyCodeIsNotNull() {
            addCriterion("attorney_code is not null");
            return (Criteria) this;
        }

        public Criteria andAttorneyCodeEqualTo(String value) {
            addCriterion("attorney_code =", value, "attorneyCode");
            return (Criteria) this;
        }

        public Criteria andAttorneyCodeNotEqualTo(String value) {
            addCriterion("attorney_code <>", value, "attorneyCode");
            return (Criteria) this;
        }

        public Criteria andAttorneyCodeGreaterThan(String value) {
            addCriterion("attorney_code >", value, "attorneyCode");
            return (Criteria) this;
        }

        public Criteria andAttorneyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("attorney_code >=", value, "attorneyCode");
            return (Criteria) this;
        }

        public Criteria andAttorneyCodeLessThan(String value) {
            addCriterion("attorney_code <", value, "attorneyCode");
            return (Criteria) this;
        }

        public Criteria andAttorneyCodeLessThanOrEqualTo(String value) {
            addCriterion("attorney_code <=", value, "attorneyCode");
            return (Criteria) this;
        }

        public Criteria andAttorneyCodeLike(String value) {
            addCriterion("attorney_code like", value, "attorneyCode");
            return (Criteria) this;
        }

        public Criteria andAttorneyCodeNotLike(String value) {
            addCriterion("attorney_code not like", value, "attorneyCode");
            return (Criteria) this;
        }

        public Criteria andAttorneyCodeIn(List<String> values) {
            addCriterion("attorney_code in", values, "attorneyCode");
            return (Criteria) this;
        }

        public Criteria andAttorneyCodeNotIn(List<String> values) {
            addCriterion("attorney_code not in", values, "attorneyCode");
            return (Criteria) this;
        }

        public Criteria andAttorneyCodeBetween(String value1, String value2) {
            addCriterion("attorney_code between", value1, value2, "attorneyCode");
            return (Criteria) this;
        }

        public Criteria andAttorneyCodeNotBetween(String value1, String value2) {
            addCriterion("attorney_code not between", value1, value2, "attorneyCode");
            return (Criteria) this;
        }

        public Criteria andAttorneyNameIsNull() {
            addCriterion("attorney_name is null");
            return (Criteria) this;
        }

        public Criteria andAttorneyNameIsNotNull() {
            addCriterion("attorney_name is not null");
            return (Criteria) this;
        }

        public Criteria andAttorneyNameEqualTo(String value) {
            addCriterion("attorney_name =", value, "attorneyName");
            return (Criteria) this;
        }

        public Criteria andAttorneyNameNotEqualTo(String value) {
            addCriterion("attorney_name <>", value, "attorneyName");
            return (Criteria) this;
        }

        public Criteria andAttorneyNameGreaterThan(String value) {
            addCriterion("attorney_name >", value, "attorneyName");
            return (Criteria) this;
        }

        public Criteria andAttorneyNameGreaterThanOrEqualTo(String value) {
            addCriterion("attorney_name >=", value, "attorneyName");
            return (Criteria) this;
        }

        public Criteria andAttorneyNameLessThan(String value) {
            addCriterion("attorney_name <", value, "attorneyName");
            return (Criteria) this;
        }

        public Criteria andAttorneyNameLessThanOrEqualTo(String value) {
            addCriterion("attorney_name <=", value, "attorneyName");
            return (Criteria) this;
        }

        public Criteria andAttorneyNameLike(String value) {
            addCriterion("attorney_name like", value, "attorneyName");
            return (Criteria) this;
        }

        public Criteria andAttorneyNameNotLike(String value) {
            addCriterion("attorney_name not like", value, "attorneyName");
            return (Criteria) this;
        }

        public Criteria andAttorneyNameIn(List<String> values) {
            addCriterion("attorney_name in", values, "attorneyName");
            return (Criteria) this;
        }

        public Criteria andAttorneyNameNotIn(List<String> values) {
            addCriterion("attorney_name not in", values, "attorneyName");
            return (Criteria) this;
        }

        public Criteria andAttorneyNameBetween(String value1, String value2) {
            addCriterion("attorney_name between", value1, value2, "attorneyName");
            return (Criteria) this;
        }

        public Criteria andAttorneyNameNotBetween(String value1, String value2) {
            addCriterion("attorney_name not between", value1, value2, "attorneyName");
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

        public Criteria andProcessDefinitionIdIsNull() {
            addCriterion("process_definition_id is null");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionIdIsNotNull() {
            addCriterion("process_definition_id is not null");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionIdEqualTo(String value) {
            addCriterion("process_definition_id =", value, "processDefinitionId");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionIdNotEqualTo(String value) {
            addCriterion("process_definition_id <>", value, "processDefinitionId");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionIdGreaterThan(String value) {
            addCriterion("process_definition_id >", value, "processDefinitionId");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionIdGreaterThanOrEqualTo(String value) {
            addCriterion("process_definition_id >=", value, "processDefinitionId");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionIdLessThan(String value) {
            addCriterion("process_definition_id <", value, "processDefinitionId");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionIdLessThanOrEqualTo(String value) {
            addCriterion("process_definition_id <=", value, "processDefinitionId");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionIdLike(String value) {
            addCriterion("process_definition_id like", value, "processDefinitionId");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionIdNotLike(String value) {
            addCriterion("process_definition_id not like", value, "processDefinitionId");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionIdIn(List<String> values) {
            addCriterion("process_definition_id in", values, "processDefinitionId");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionIdNotIn(List<String> values) {
            addCriterion("process_definition_id not in", values, "processDefinitionId");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionIdBetween(String value1, String value2) {
            addCriterion("process_definition_id between", value1, value2, "processDefinitionId");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionIdNotBetween(String value1, String value2) {
            addCriterion("process_definition_id not between", value1, value2, "processDefinitionId");
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

        public Criteria andModuleCodeIsNull() {
            addCriterion("module_code is null");
            return (Criteria) this;
        }

        public Criteria andModuleCodeIsNotNull() {
            addCriterion("module_code is not null");
            return (Criteria) this;
        }

        public Criteria andModuleCodeEqualTo(String value) {
            addCriterion("module_code =", value, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeNotEqualTo(String value) {
            addCriterion("module_code <>", value, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeGreaterThan(String value) {
            addCriterion("module_code >", value, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeGreaterThanOrEqualTo(String value) {
            addCriterion("module_code >=", value, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeLessThan(String value) {
            addCriterion("module_code <", value, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeLessThanOrEqualTo(String value) {
            addCriterion("module_code <=", value, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeLike(String value) {
            addCriterion("module_code like", value, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeNotLike(String value) {
            addCriterion("module_code not like", value, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeIn(List<String> values) {
            addCriterion("module_code in", values, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeNotIn(List<String> values) {
            addCriterion("module_code not in", values, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeBetween(String value1, String value2) {
            addCriterion("module_code between", value1, value2, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeNotBetween(String value1, String value2) {
            addCriterion("module_code not between", value1, value2, "moduleCode");
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

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNull() {
            addCriterion("create_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("create_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(String value) {
            addCriterion("create_user_id =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(String value) {
            addCriterion("create_user_id <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(String value) {
            addCriterion("create_user_id >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("create_user_id >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(String value) {
            addCriterion("create_user_id <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(String value) {
            addCriterion("create_user_id <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLike(String value) {
            addCriterion("create_user_id like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotLike(String value) {
            addCriterion("create_user_id not like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<String> values) {
            addCriterion("create_user_id in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<String> values) {
            addCriterion("create_user_id not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(String value1, String value2) {
            addCriterion("create_user_id between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(String value1, String value2) {
            addCriterion("create_user_id not between", value1, value2, "createUserId");
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