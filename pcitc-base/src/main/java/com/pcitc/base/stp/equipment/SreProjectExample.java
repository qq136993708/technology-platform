package com.pcitc.base.stp.equipment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SreProjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SreProjectExample() {
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

        public Criteria andContractNumIsNull() {
            addCriterion("contract_num is null");
            return (Criteria) this;
        }

        public Criteria andContractNumIsNotNull() {
            addCriterion("contract_num is not null");
            return (Criteria) this;
        }

        public Criteria andContractNumEqualTo(String value) {
            addCriterion("contract_num =", value, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumNotEqualTo(String value) {
            addCriterion("contract_num <>", value, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumGreaterThan(String value) {
            addCriterion("contract_num >", value, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumGreaterThanOrEqualTo(String value) {
            addCriterion("contract_num >=", value, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumLessThan(String value) {
            addCriterion("contract_num <", value, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumLessThanOrEqualTo(String value) {
            addCriterion("contract_num <=", value, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumLike(String value) {
            addCriterion("contract_num like", value, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumNotLike(String value) {
            addCriterion("contract_num not like", value, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumIn(List<String> values) {
            addCriterion("contract_num in", values, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumNotIn(List<String> values) {
            addCriterion("contract_num not in", values, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumBetween(String value1, String value2) {
            addCriterion("contract_num between", value1, value2, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumNotBetween(String value1, String value2) {
            addCriterion("contract_num not between", value1, value2, "contractNum");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
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

        public Criteria andProjectMoneyIsNull() {
            addCriterion("project_money is null");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyIsNotNull() {
            addCriterion("project_money is not null");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyEqualTo(BigDecimal value) {
            addCriterion("project_money =", value, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyNotEqualTo(BigDecimal value) {
            addCriterion("project_money <>", value, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyGreaterThan(BigDecimal value) {
            addCriterion("project_money >", value, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("project_money >=", value, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyLessThan(BigDecimal value) {
            addCriterion("project_money <", value, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("project_money <=", value, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyIn(List<BigDecimal> values) {
            addCriterion("project_money in", values, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyNotIn(List<BigDecimal> values) {
            addCriterion("project_money not in", values, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("project_money between", value1, value2, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("project_money not between", value1, value2, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNull() {
            addCriterion("update_user_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNotNull() {
            addCriterion("update_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdEqualTo(String value) {
            addCriterion("update_user_id =", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotEqualTo(String value) {
            addCriterion("update_user_id <>", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThan(String value) {
            addCriterion("update_user_id >", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("update_user_id >=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThan(String value) {
            addCriterion("update_user_id <", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThanOrEqualTo(String value) {
            addCriterion("update_user_id <=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLike(String value) {
            addCriterion("update_user_id like", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotLike(String value) {
            addCriterion("update_user_id not like", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIn(List<String> values) {
            addCriterion("update_user_id in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotIn(List<String> values) {
            addCriterion("update_user_id not in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdBetween(String value1, String value2) {
            addCriterion("update_user_id between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotBetween(String value1, String value2) {
            addCriterion("update_user_id not between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andBeginYearIsNull() {
            addCriterion("begin_year is null");
            return (Criteria) this;
        }

        public Criteria andBeginYearIsNotNull() {
            addCriterion("begin_year is not null");
            return (Criteria) this;
        }

        public Criteria andBeginYearEqualTo(String value) {
            addCriterion("begin_year =", value, "beginYear");
            return (Criteria) this;
        }

        public Criteria andBeginYearNotEqualTo(String value) {
            addCriterion("begin_year <>", value, "beginYear");
            return (Criteria) this;
        }

        public Criteria andBeginYearGreaterThan(String value) {
            addCriterion("begin_year >", value, "beginYear");
            return (Criteria) this;
        }

        public Criteria andBeginYearGreaterThanOrEqualTo(String value) {
            addCriterion("begin_year >=", value, "beginYear");
            return (Criteria) this;
        }

        public Criteria andBeginYearLessThan(String value) {
            addCriterion("begin_year <", value, "beginYear");
            return (Criteria) this;
        }

        public Criteria andBeginYearLessThanOrEqualTo(String value) {
            addCriterion("begin_year <=", value, "beginYear");
            return (Criteria) this;
        }

        public Criteria andBeginYearLike(String value) {
            addCriterion("begin_year like", value, "beginYear");
            return (Criteria) this;
        }

        public Criteria andBeginYearNotLike(String value) {
            addCriterion("begin_year not like", value, "beginYear");
            return (Criteria) this;
        }

        public Criteria andBeginYearIn(List<String> values) {
            addCriterion("begin_year in", values, "beginYear");
            return (Criteria) this;
        }

        public Criteria andBeginYearNotIn(List<String> values) {
            addCriterion("begin_year not in", values, "beginYear");
            return (Criteria) this;
        }

        public Criteria andBeginYearBetween(String value1, String value2) {
            addCriterion("begin_year between", value1, value2, "beginYear");
            return (Criteria) this;
        }

        public Criteria andBeginYearNotBetween(String value1, String value2) {
            addCriterion("begin_year not between", value1, value2, "beginYear");
            return (Criteria) this;
        }

        public Criteria andEndYearIsNull() {
            addCriterion("end_year is null");
            return (Criteria) this;
        }

        public Criteria andEndYearIsNotNull() {
            addCriterion("end_year is not null");
            return (Criteria) this;
        }

        public Criteria andEndYearEqualTo(String value) {
            addCriterion("end_year =", value, "endYear");
            return (Criteria) this;
        }

        public Criteria andEndYearNotEqualTo(String value) {
            addCriterion("end_year <>", value, "endYear");
            return (Criteria) this;
        }

        public Criteria andEndYearGreaterThan(String value) {
            addCriterion("end_year >", value, "endYear");
            return (Criteria) this;
        }

        public Criteria andEndYearGreaterThanOrEqualTo(String value) {
            addCriterion("end_year >=", value, "endYear");
            return (Criteria) this;
        }

        public Criteria andEndYearLessThan(String value) {
            addCriterion("end_year <", value, "endYear");
            return (Criteria) this;
        }

        public Criteria andEndYearLessThanOrEqualTo(String value) {
            addCriterion("end_year <=", value, "endYear");
            return (Criteria) this;
        }

        public Criteria andEndYearLike(String value) {
            addCriterion("end_year like", value, "endYear");
            return (Criteria) this;
        }

        public Criteria andEndYearNotLike(String value) {
            addCriterion("end_year not like", value, "endYear");
            return (Criteria) this;
        }

        public Criteria andEndYearIn(List<String> values) {
            addCriterion("end_year in", values, "endYear");
            return (Criteria) this;
        }

        public Criteria andEndYearNotIn(List<String> values) {
            addCriterion("end_year not in", values, "endYear");
            return (Criteria) this;
        }

        public Criteria andEndYearBetween(String value1, String value2) {
            addCriterion("end_year between", value1, value2, "endYear");
            return (Criteria) this;
        }

        public Criteria andEndYearNotBetween(String value1, String value2) {
            addCriterion("end_year not between", value1, value2, "endYear");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdsIsNull() {
            addCriterion("equipment_ids is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdsIsNotNull() {
            addCriterion("equipment_ids is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdsEqualTo(String value) {
            addCriterion("equipment_ids =", value, "equipmentIds");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdsNotEqualTo(String value) {
            addCriterion("equipment_ids <>", value, "equipmentIds");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdsGreaterThan(String value) {
            addCriterion("equipment_ids >", value, "equipmentIds");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdsGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_ids >=", value, "equipmentIds");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdsLessThan(String value) {
            addCriterion("equipment_ids <", value, "equipmentIds");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdsLessThanOrEqualTo(String value) {
            addCriterion("equipment_ids <=", value, "equipmentIds");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdsLike(String value) {
            addCriterion("equipment_ids like", value, "equipmentIds");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdsNotLike(String value) {
            addCriterion("equipment_ids not like", value, "equipmentIds");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdsIn(List<String> values) {
            addCriterion("equipment_ids in", values, "equipmentIds");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdsNotIn(List<String> values) {
            addCriterion("equipment_ids not in", values, "equipmentIds");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdsBetween(String value1, String value2) {
            addCriterion("equipment_ids between", value1, value2, "equipmentIds");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdsNotBetween(String value1, String value2) {
            addCriterion("equipment_ids not between", value1, value2, "equipmentIds");
            return (Criteria) this;
        }

        public Criteria andKeyWordIsNull() {
            addCriterion("key_word is null");
            return (Criteria) this;
        }

        public Criteria andKeyWordIsNotNull() {
            addCriterion("key_word is not null");
            return (Criteria) this;
        }

        public Criteria andKeyWordEqualTo(String value) {
            addCriterion("key_word =", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordNotEqualTo(String value) {
            addCriterion("key_word <>", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordGreaterThan(String value) {
            addCriterion("key_word >", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordGreaterThanOrEqualTo(String value) {
            addCriterion("key_word >=", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordLessThan(String value) {
            addCriterion("key_word <", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordLessThanOrEqualTo(String value) {
            addCriterion("key_word <=", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordLike(String value) {
            addCriterion("key_word like", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordNotLike(String value) {
            addCriterion("key_word not like", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordIn(List<String> values) {
            addCriterion("key_word in", values, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordNotIn(List<String> values) {
            addCriterion("key_word not in", values, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordBetween(String value1, String value2) {
            addCriterion("key_word between", value1, value2, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordNotBetween(String value1, String value2) {
            addCriterion("key_word not between", value1, value2, "keyWord");
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

        public Criteria andProjectLeaderIsNull() {
            addCriterion("project_leader is null");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderIsNotNull() {
            addCriterion("project_leader is not null");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderEqualTo(String value) {
            addCriterion("project_leader =", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderNotEqualTo(String value) {
            addCriterion("project_leader <>", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderGreaterThan(String value) {
            addCriterion("project_leader >", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderGreaterThanOrEqualTo(String value) {
            addCriterion("project_leader >=", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderLessThan(String value) {
            addCriterion("project_leader <", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderLessThanOrEqualTo(String value) {
            addCriterion("project_leader <=", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderLike(String value) {
            addCriterion("project_leader like", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderNotLike(String value) {
            addCriterion("project_leader not like", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderIn(List<String> values) {
            addCriterion("project_leader in", values, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderNotIn(List<String> values) {
            addCriterion("project_leader not in", values, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderBetween(String value1, String value2) {
            addCriterion("project_leader between", value1, value2, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderNotBetween(String value1, String value2) {
            addCriterion("project_leader not between", value1, value2, "projectLeader");
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

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
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

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andDocumentDocIsNull() {
            addCriterion("document_doc is null");
            return (Criteria) this;
        }

        public Criteria andDocumentDocIsNotNull() {
            addCriterion("document_doc is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentDocEqualTo(String value) {
            addCriterion("document_doc =", value, "documentDoc");
            return (Criteria) this;
        }

        public Criteria andDocumentDocNotEqualTo(String value) {
            addCriterion("document_doc <>", value, "documentDoc");
            return (Criteria) this;
        }

        public Criteria andDocumentDocGreaterThan(String value) {
            addCriterion("document_doc >", value, "documentDoc");
            return (Criteria) this;
        }

        public Criteria andDocumentDocGreaterThanOrEqualTo(String value) {
            addCriterion("document_doc >=", value, "documentDoc");
            return (Criteria) this;
        }

        public Criteria andDocumentDocLessThan(String value) {
            addCriterion("document_doc <", value, "documentDoc");
            return (Criteria) this;
        }

        public Criteria andDocumentDocLessThanOrEqualTo(String value) {
            addCriterion("document_doc <=", value, "documentDoc");
            return (Criteria) this;
        }

        public Criteria andDocumentDocLike(String value) {
            addCriterion("document_doc like", value, "documentDoc");
            return (Criteria) this;
        }

        public Criteria andDocumentDocNotLike(String value) {
            addCriterion("document_doc not like", value, "documentDoc");
            return (Criteria) this;
        }

        public Criteria andDocumentDocIn(List<String> values) {
            addCriterion("document_doc in", values, "documentDoc");
            return (Criteria) this;
        }

        public Criteria andDocumentDocNotIn(List<String> values) {
            addCriterion("document_doc not in", values, "documentDoc");
            return (Criteria) this;
        }

        public Criteria andDocumentDocBetween(String value1, String value2) {
            addCriterion("document_doc between", value1, value2, "documentDoc");
            return (Criteria) this;
        }

        public Criteria andDocumentDocNotBetween(String value1, String value2) {
            addCriterion("document_doc not between", value1, value2, "documentDoc");
            return (Criteria) this;
        }

        public Criteria andSetupYearIsNull() {
            addCriterion("setup_year is null");
            return (Criteria) this;
        }

        public Criteria andSetupYearIsNotNull() {
            addCriterion("setup_year is not null");
            return (Criteria) this;
        }

        public Criteria andSetupYearEqualTo(String value) {
            addCriterion("setup_year =", value, "setupYear");
            return (Criteria) this;
        }

        public Criteria andSetupYearNotEqualTo(String value) {
            addCriterion("setup_year <>", value, "setupYear");
            return (Criteria) this;
        }

        public Criteria andSetupYearGreaterThan(String value) {
            addCriterion("setup_year >", value, "setupYear");
            return (Criteria) this;
        }

        public Criteria andSetupYearGreaterThanOrEqualTo(String value) {
            addCriterion("setup_year >=", value, "setupYear");
            return (Criteria) this;
        }

        public Criteria andSetupYearLessThan(String value) {
            addCriterion("setup_year <", value, "setupYear");
            return (Criteria) this;
        }

        public Criteria andSetupYearLessThanOrEqualTo(String value) {
            addCriterion("setup_year <=", value, "setupYear");
            return (Criteria) this;
        }

        public Criteria andSetupYearLike(String value) {
            addCriterion("setup_year like", value, "setupYear");
            return (Criteria) this;
        }

        public Criteria andSetupYearNotLike(String value) {
            addCriterion("setup_year not like", value, "setupYear");
            return (Criteria) this;
        }

        public Criteria andSetupYearIn(List<String> values) {
            addCriterion("setup_year in", values, "setupYear");
            return (Criteria) this;
        }

        public Criteria andSetupYearNotIn(List<String> values) {
            addCriterion("setup_year not in", values, "setupYear");
            return (Criteria) this;
        }

        public Criteria andSetupYearBetween(String value1, String value2) {
            addCriterion("setup_year between", value1, value2, "setupYear");
            return (Criteria) this;
        }

        public Criteria andSetupYearNotBetween(String value1, String value2) {
            addCriterion("setup_year not between", value1, value2, "setupYear");
            return (Criteria) this;
        }

        public Criteria andLeadUnitNameIsNull() {
            addCriterion("lead_unit_name is null");
            return (Criteria) this;
        }

        public Criteria andLeadUnitNameIsNotNull() {
            addCriterion("lead_unit_name is not null");
            return (Criteria) this;
        }

        public Criteria andLeadUnitNameEqualTo(String value) {
            addCriterion("lead_unit_name =", value, "leadUnitName");
            return (Criteria) this;
        }

        public Criteria andLeadUnitNameNotEqualTo(String value) {
            addCriterion("lead_unit_name <>", value, "leadUnitName");
            return (Criteria) this;
        }

        public Criteria andLeadUnitNameGreaterThan(String value) {
            addCriterion("lead_unit_name >", value, "leadUnitName");
            return (Criteria) this;
        }

        public Criteria andLeadUnitNameGreaterThanOrEqualTo(String value) {
            addCriterion("lead_unit_name >=", value, "leadUnitName");
            return (Criteria) this;
        }

        public Criteria andLeadUnitNameLessThan(String value) {
            addCriterion("lead_unit_name <", value, "leadUnitName");
            return (Criteria) this;
        }

        public Criteria andLeadUnitNameLessThanOrEqualTo(String value) {
            addCriterion("lead_unit_name <=", value, "leadUnitName");
            return (Criteria) this;
        }

        public Criteria andLeadUnitNameLike(String value) {
            addCriterion("lead_unit_name like", value, "leadUnitName");
            return (Criteria) this;
        }

        public Criteria andLeadUnitNameNotLike(String value) {
            addCriterion("lead_unit_name not like", value, "leadUnitName");
            return (Criteria) this;
        }

        public Criteria andLeadUnitNameIn(List<String> values) {
            addCriterion("lead_unit_name in", values, "leadUnitName");
            return (Criteria) this;
        }

        public Criteria andLeadUnitNameNotIn(List<String> values) {
            addCriterion("lead_unit_name not in", values, "leadUnitName");
            return (Criteria) this;
        }

        public Criteria andLeadUnitNameBetween(String value1, String value2) {
            addCriterion("lead_unit_name between", value1, value2, "leadUnitName");
            return (Criteria) this;
        }

        public Criteria andLeadUnitNameNotBetween(String value1, String value2) {
            addCriterion("lead_unit_name not between", value1, value2, "leadUnitName");
            return (Criteria) this;
        }

        public Criteria andJoinUnitNameIsNull() {
            addCriterion("join_unit_name is null");
            return (Criteria) this;
        }

        public Criteria andJoinUnitNameIsNotNull() {
            addCriterion("join_unit_name is not null");
            return (Criteria) this;
        }

        public Criteria andJoinUnitNameEqualTo(String value) {
            addCriterion("join_unit_name =", value, "joinUnitName");
            return (Criteria) this;
        }

        public Criteria andJoinUnitNameNotEqualTo(String value) {
            addCriterion("join_unit_name <>", value, "joinUnitName");
            return (Criteria) this;
        }

        public Criteria andJoinUnitNameGreaterThan(String value) {
            addCriterion("join_unit_name >", value, "joinUnitName");
            return (Criteria) this;
        }

        public Criteria andJoinUnitNameGreaterThanOrEqualTo(String value) {
            addCriterion("join_unit_name >=", value, "joinUnitName");
            return (Criteria) this;
        }

        public Criteria andJoinUnitNameLessThan(String value) {
            addCriterion("join_unit_name <", value, "joinUnitName");
            return (Criteria) this;
        }

        public Criteria andJoinUnitNameLessThanOrEqualTo(String value) {
            addCriterion("join_unit_name <=", value, "joinUnitName");
            return (Criteria) this;
        }

        public Criteria andJoinUnitNameLike(String value) {
            addCriterion("join_unit_name like", value, "joinUnitName");
            return (Criteria) this;
        }

        public Criteria andJoinUnitNameNotLike(String value) {
            addCriterion("join_unit_name not like", value, "joinUnitName");
            return (Criteria) this;
        }

        public Criteria andJoinUnitNameIn(List<String> values) {
            addCriterion("join_unit_name in", values, "joinUnitName");
            return (Criteria) this;
        }

        public Criteria andJoinUnitNameNotIn(List<String> values) {
            addCriterion("join_unit_name not in", values, "joinUnitName");
            return (Criteria) this;
        }

        public Criteria andJoinUnitNameBetween(String value1, String value2) {
            addCriterion("join_unit_name between", value1, value2, "joinUnitName");
            return (Criteria) this;
        }

        public Criteria andJoinUnitNameNotBetween(String value1, String value2) {
            addCriterion("join_unit_name not between", value1, value2, "joinUnitName");
            return (Criteria) this;
        }

        public Criteria andEntrustUnitNameIsNull() {
            addCriterion("entrust_unit_name is null");
            return (Criteria) this;
        }

        public Criteria andEntrustUnitNameIsNotNull() {
            addCriterion("entrust_unit_name is not null");
            return (Criteria) this;
        }

        public Criteria andEntrustUnitNameEqualTo(String value) {
            addCriterion("entrust_unit_name =", value, "entrustUnitName");
            return (Criteria) this;
        }

        public Criteria andEntrustUnitNameNotEqualTo(String value) {
            addCriterion("entrust_unit_name <>", value, "entrustUnitName");
            return (Criteria) this;
        }

        public Criteria andEntrustUnitNameGreaterThan(String value) {
            addCriterion("entrust_unit_name >", value, "entrustUnitName");
            return (Criteria) this;
        }

        public Criteria andEntrustUnitNameGreaterThanOrEqualTo(String value) {
            addCriterion("entrust_unit_name >=", value, "entrustUnitName");
            return (Criteria) this;
        }

        public Criteria andEntrustUnitNameLessThan(String value) {
            addCriterion("entrust_unit_name <", value, "entrustUnitName");
            return (Criteria) this;
        }

        public Criteria andEntrustUnitNameLessThanOrEqualTo(String value) {
            addCriterion("entrust_unit_name <=", value, "entrustUnitName");
            return (Criteria) this;
        }

        public Criteria andEntrustUnitNameLike(String value) {
            addCriterion("entrust_unit_name like", value, "entrustUnitName");
            return (Criteria) this;
        }

        public Criteria andEntrustUnitNameNotLike(String value) {
            addCriterion("entrust_unit_name not like", value, "entrustUnitName");
            return (Criteria) this;
        }

        public Criteria andEntrustUnitNameIn(List<String> values) {
            addCriterion("entrust_unit_name in", values, "entrustUnitName");
            return (Criteria) this;
        }

        public Criteria andEntrustUnitNameNotIn(List<String> values) {
            addCriterion("entrust_unit_name not in", values, "entrustUnitName");
            return (Criteria) this;
        }

        public Criteria andEntrustUnitNameBetween(String value1, String value2) {
            addCriterion("entrust_unit_name between", value1, value2, "entrustUnitName");
            return (Criteria) this;
        }

        public Criteria andEntrustUnitNameNotBetween(String value1, String value2) {
            addCriterion("entrust_unit_name not between", value1, value2, "entrustUnitName");
            return (Criteria) this;
        }

        public Criteria andLeadUnitTypeIsNull() {
            addCriterion("lead_unit_type is null");
            return (Criteria) this;
        }

        public Criteria andLeadUnitTypeIsNotNull() {
            addCriterion("lead_unit_type is not null");
            return (Criteria) this;
        }

        public Criteria andLeadUnitTypeEqualTo(String value) {
            addCriterion("lead_unit_type =", value, "leadUnitType");
            return (Criteria) this;
        }

        public Criteria andLeadUnitTypeNotEqualTo(String value) {
            addCriterion("lead_unit_type <>", value, "leadUnitType");
            return (Criteria) this;
        }

        public Criteria andLeadUnitTypeGreaterThan(String value) {
            addCriterion("lead_unit_type >", value, "leadUnitType");
            return (Criteria) this;
        }

        public Criteria andLeadUnitTypeGreaterThanOrEqualTo(String value) {
            addCriterion("lead_unit_type >=", value, "leadUnitType");
            return (Criteria) this;
        }

        public Criteria andLeadUnitTypeLessThan(String value) {
            addCriterion("lead_unit_type <", value, "leadUnitType");
            return (Criteria) this;
        }

        public Criteria andLeadUnitTypeLessThanOrEqualTo(String value) {
            addCriterion("lead_unit_type <=", value, "leadUnitType");
            return (Criteria) this;
        }

        public Criteria andLeadUnitTypeLike(String value) {
            addCriterion("lead_unit_type like", value, "leadUnitType");
            return (Criteria) this;
        }

        public Criteria andLeadUnitTypeNotLike(String value) {
            addCriterion("lead_unit_type not like", value, "leadUnitType");
            return (Criteria) this;
        }

        public Criteria andLeadUnitTypeIn(List<String> values) {
            addCriterion("lead_unit_type in", values, "leadUnitType");
            return (Criteria) this;
        }

        public Criteria andLeadUnitTypeNotIn(List<String> values) {
            addCriterion("lead_unit_type not in", values, "leadUnitType");
            return (Criteria) this;
        }

        public Criteria andLeadUnitTypeBetween(String value1, String value2) {
            addCriterion("lead_unit_type between", value1, value2, "leadUnitType");
            return (Criteria) this;
        }

        public Criteria andLeadUnitTypeNotBetween(String value1, String value2) {
            addCriterion("lead_unit_type not between", value1, value2, "leadUnitType");
            return (Criteria) this;
        }

        public Criteria andProfessionalFieldIsNull() {
            addCriterion("professional_field is null");
            return (Criteria) this;
        }

        public Criteria andProfessionalFieldIsNotNull() {
            addCriterion("professional_field is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionalFieldEqualTo(String value) {
            addCriterion("professional_field =", value, "professionalField");
            return (Criteria) this;
        }

        public Criteria andProfessionalFieldNotEqualTo(String value) {
            addCriterion("professional_field <>", value, "professionalField");
            return (Criteria) this;
        }

        public Criteria andProfessionalFieldGreaterThan(String value) {
            addCriterion("professional_field >", value, "professionalField");
            return (Criteria) this;
        }

        public Criteria andProfessionalFieldGreaterThanOrEqualTo(String value) {
            addCriterion("professional_field >=", value, "professionalField");
            return (Criteria) this;
        }

        public Criteria andProfessionalFieldLessThan(String value) {
            addCriterion("professional_field <", value, "professionalField");
            return (Criteria) this;
        }

        public Criteria andProfessionalFieldLessThanOrEqualTo(String value) {
            addCriterion("professional_field <=", value, "professionalField");
            return (Criteria) this;
        }

        public Criteria andProfessionalFieldLike(String value) {
            addCriterion("professional_field like", value, "professionalField");
            return (Criteria) this;
        }

        public Criteria andProfessionalFieldNotLike(String value) {
            addCriterion("professional_field not like", value, "professionalField");
            return (Criteria) this;
        }

        public Criteria andProfessionalFieldIn(List<String> values) {
            addCriterion("professional_field in", values, "professionalField");
            return (Criteria) this;
        }

        public Criteria andProfessionalFieldNotIn(List<String> values) {
            addCriterion("professional_field not in", values, "professionalField");
            return (Criteria) this;
        }

        public Criteria andProfessionalFieldBetween(String value1, String value2) {
            addCriterion("professional_field between", value1, value2, "professionalField");
            return (Criteria) this;
        }

        public Criteria andProfessionalFieldNotBetween(String value1, String value2) {
            addCriterion("professional_field not between", value1, value2, "professionalField");
            return (Criteria) this;
        }

        public Criteria andBelongDepartmentIsNull() {
            addCriterion("belong_department is null");
            return (Criteria) this;
        }

        public Criteria andBelongDepartmentIsNotNull() {
            addCriterion("belong_department is not null");
            return (Criteria) this;
        }

        public Criteria andBelongDepartmentEqualTo(String value) {
            addCriterion("belong_department =", value, "belongDepartment");
            return (Criteria) this;
        }

        public Criteria andBelongDepartmentNotEqualTo(String value) {
            addCriterion("belong_department <>", value, "belongDepartment");
            return (Criteria) this;
        }

        public Criteria andBelongDepartmentGreaterThan(String value) {
            addCriterion("belong_department >", value, "belongDepartment");
            return (Criteria) this;
        }

        public Criteria andBelongDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("belong_department >=", value, "belongDepartment");
            return (Criteria) this;
        }

        public Criteria andBelongDepartmentLessThan(String value) {
            addCriterion("belong_department <", value, "belongDepartment");
            return (Criteria) this;
        }

        public Criteria andBelongDepartmentLessThanOrEqualTo(String value) {
            addCriterion("belong_department <=", value, "belongDepartment");
            return (Criteria) this;
        }

        public Criteria andBelongDepartmentLike(String value) {
            addCriterion("belong_department like", value, "belongDepartment");
            return (Criteria) this;
        }

        public Criteria andBelongDepartmentNotLike(String value) {
            addCriterion("belong_department not like", value, "belongDepartment");
            return (Criteria) this;
        }

        public Criteria andBelongDepartmentIn(List<String> values) {
            addCriterion("belong_department in", values, "belongDepartment");
            return (Criteria) this;
        }

        public Criteria andBelongDepartmentNotIn(List<String> values) {
            addCriterion("belong_department not in", values, "belongDepartment");
            return (Criteria) this;
        }

        public Criteria andBelongDepartmentBetween(String value1, String value2) {
            addCriterion("belong_department between", value1, value2, "belongDepartment");
            return (Criteria) this;
        }

        public Criteria andBelongDepartmentNotBetween(String value1, String value2) {
            addCriterion("belong_department not between", value1, value2, "belongDepartment");
            return (Criteria) this;
        }

        public Criteria andProfessionalDepartmentIsNull() {
            addCriterion("professional_department is null");
            return (Criteria) this;
        }

        public Criteria andProfessionalDepartmentIsNotNull() {
            addCriterion("professional_department is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionalDepartmentEqualTo(String value) {
            addCriterion("professional_department =", value, "professionalDepartment");
            return (Criteria) this;
        }

        public Criteria andProfessionalDepartmentNotEqualTo(String value) {
            addCriterion("professional_department <>", value, "professionalDepartment");
            return (Criteria) this;
        }

        public Criteria andProfessionalDepartmentGreaterThan(String value) {
            addCriterion("professional_department >", value, "professionalDepartment");
            return (Criteria) this;
        }

        public Criteria andProfessionalDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("professional_department >=", value, "professionalDepartment");
            return (Criteria) this;
        }

        public Criteria andProfessionalDepartmentLessThan(String value) {
            addCriterion("professional_department <", value, "professionalDepartment");
            return (Criteria) this;
        }

        public Criteria andProfessionalDepartmentLessThanOrEqualTo(String value) {
            addCriterion("professional_department <=", value, "professionalDepartment");
            return (Criteria) this;
        }

        public Criteria andProfessionalDepartmentLike(String value) {
            addCriterion("professional_department like", value, "professionalDepartment");
            return (Criteria) this;
        }

        public Criteria andProfessionalDepartmentNotLike(String value) {
            addCriterion("professional_department not like", value, "professionalDepartment");
            return (Criteria) this;
        }

        public Criteria andProfessionalDepartmentIn(List<String> values) {
            addCriterion("professional_department in", values, "professionalDepartment");
            return (Criteria) this;
        }

        public Criteria andProfessionalDepartmentNotIn(List<String> values) {
            addCriterion("professional_department not in", values, "professionalDepartment");
            return (Criteria) this;
        }

        public Criteria andProfessionalDepartmentBetween(String value1, String value2) {
            addCriterion("professional_department between", value1, value2, "professionalDepartment");
            return (Criteria) this;
        }

        public Criteria andProfessionalDepartmentNotBetween(String value1, String value2) {
            addCriterion("professional_department not between", value1, value2, "professionalDepartment");
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

        public Criteria andProfessionalIsNull() {
            addCriterion("professional is null");
            return (Criteria) this;
        }

        public Criteria andProfessionalIsNotNull() {
            addCriterion("professional is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionalEqualTo(String value) {
            addCriterion("professional =", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalNotEqualTo(String value) {
            addCriterion("professional <>", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalGreaterThan(String value) {
            addCriterion("professional >", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalGreaterThanOrEqualTo(String value) {
            addCriterion("professional >=", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalLessThan(String value) {
            addCriterion("professional <", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalLessThanOrEqualTo(String value) {
            addCriterion("professional <=", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalLike(String value) {
            addCriterion("professional like", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalNotLike(String value) {
            addCriterion("professional not like", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalIn(List<String> values) {
            addCriterion("professional in", values, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalNotIn(List<String> values) {
            addCriterion("professional not in", values, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalBetween(String value1, String value2) {
            addCriterion("professional between", value1, value2, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalNotBetween(String value1, String value2) {
            addCriterion("professional not between", value1, value2, "professional");
            return (Criteria) this;
        }

        public Criteria andIsContractIsNull() {
            addCriterion("is_contract is null");
            return (Criteria) this;
        }

        public Criteria andIsContractIsNotNull() {
            addCriterion("is_contract is not null");
            return (Criteria) this;
        }

        public Criteria andIsContractEqualTo(String value) {
            addCriterion("is_contract =", value, "isContract");
            return (Criteria) this;
        }

        public Criteria andIsContractNotEqualTo(String value) {
            addCriterion("is_contract <>", value, "isContract");
            return (Criteria) this;
        }

        public Criteria andIsContractGreaterThan(String value) {
            addCriterion("is_contract >", value, "isContract");
            return (Criteria) this;
        }

        public Criteria andIsContractGreaterThanOrEqualTo(String value) {
            addCriterion("is_contract >=", value, "isContract");
            return (Criteria) this;
        }

        public Criteria andIsContractLessThan(String value) {
            addCriterion("is_contract <", value, "isContract");
            return (Criteria) this;
        }

        public Criteria andIsContractLessThanOrEqualTo(String value) {
            addCriterion("is_contract <=", value, "isContract");
            return (Criteria) this;
        }

        public Criteria andIsContractLike(String value) {
            addCriterion("is_contract like", value, "isContract");
            return (Criteria) this;
        }

        public Criteria andIsContractNotLike(String value) {
            addCriterion("is_contract not like", value, "isContract");
            return (Criteria) this;
        }

        public Criteria andIsContractIn(List<String> values) {
            addCriterion("is_contract in", values, "isContract");
            return (Criteria) this;
        }

        public Criteria andIsContractNotIn(List<String> values) {
            addCriterion("is_contract not in", values, "isContract");
            return (Criteria) this;
        }

        public Criteria andIsContractBetween(String value1, String value2) {
            addCriterion("is_contract between", value1, value2, "isContract");
            return (Criteria) this;
        }

        public Criteria andIsContractNotBetween(String value1, String value2) {
            addCriterion("is_contract not between", value1, value2, "isContract");
            return (Criteria) this;
        }

        public Criteria andErpNumIsNull() {
            addCriterion("erp_num is null");
            return (Criteria) this;
        }

        public Criteria andErpNumIsNotNull() {
            addCriterion("erp_num is not null");
            return (Criteria) this;
        }

        public Criteria andErpNumEqualTo(String value) {
            addCriterion("erp_num =", value, "erpNum");
            return (Criteria) this;
        }

        public Criteria andErpNumNotEqualTo(String value) {
            addCriterion("erp_num <>", value, "erpNum");
            return (Criteria) this;
        }

        public Criteria andErpNumGreaterThan(String value) {
            addCriterion("erp_num >", value, "erpNum");
            return (Criteria) this;
        }

        public Criteria andErpNumGreaterThanOrEqualTo(String value) {
            addCriterion("erp_num >=", value, "erpNum");
            return (Criteria) this;
        }

        public Criteria andErpNumLessThan(String value) {
            addCriterion("erp_num <", value, "erpNum");
            return (Criteria) this;
        }

        public Criteria andErpNumLessThanOrEqualTo(String value) {
            addCriterion("erp_num <=", value, "erpNum");
            return (Criteria) this;
        }

        public Criteria andErpNumLike(String value) {
            addCriterion("erp_num like", value, "erpNum");
            return (Criteria) this;
        }

        public Criteria andErpNumNotLike(String value) {
            addCriterion("erp_num not like", value, "erpNum");
            return (Criteria) this;
        }

        public Criteria andErpNumIn(List<String> values) {
            addCriterion("erp_num in", values, "erpNum");
            return (Criteria) this;
        }

        public Criteria andErpNumNotIn(List<String> values) {
            addCriterion("erp_num not in", values, "erpNum");
            return (Criteria) this;
        }

        public Criteria andErpNumBetween(String value1, String value2) {
            addCriterion("erp_num between", value1, value2, "erpNum");
            return (Criteria) this;
        }

        public Criteria andErpNumNotBetween(String value1, String value2) {
            addCriterion("erp_num not between", value1, value2, "erpNum");
            return (Criteria) this;
        }

        public Criteria andLeadUnitCodeIsNull() {
            addCriterion("lead_unit_code is null");
            return (Criteria) this;
        }

        public Criteria andLeadUnitCodeIsNotNull() {
            addCriterion("lead_unit_code is not null");
            return (Criteria) this;
        }

        public Criteria andLeadUnitCodeEqualTo(String value) {
            addCriterion("lead_unit_code =", value, "leadUnitCode");
            return (Criteria) this;
        }

        public Criteria andLeadUnitCodeNotEqualTo(String value) {
            addCriterion("lead_unit_code <>", value, "leadUnitCode");
            return (Criteria) this;
        }

        public Criteria andLeadUnitCodeGreaterThan(String value) {
            addCriterion("lead_unit_code >", value, "leadUnitCode");
            return (Criteria) this;
        }

        public Criteria andLeadUnitCodeGreaterThanOrEqualTo(String value) {
            addCriterion("lead_unit_code >=", value, "leadUnitCode");
            return (Criteria) this;
        }

        public Criteria andLeadUnitCodeLessThan(String value) {
            addCriterion("lead_unit_code <", value, "leadUnitCode");
            return (Criteria) this;
        }

        public Criteria andLeadUnitCodeLessThanOrEqualTo(String value) {
            addCriterion("lead_unit_code <=", value, "leadUnitCode");
            return (Criteria) this;
        }

        public Criteria andLeadUnitCodeLike(String value) {
            addCriterion("lead_unit_code like", value, "leadUnitCode");
            return (Criteria) this;
        }

        public Criteria andLeadUnitCodeNotLike(String value) {
            addCriterion("lead_unit_code not like", value, "leadUnitCode");
            return (Criteria) this;
        }

        public Criteria andLeadUnitCodeIn(List<String> values) {
            addCriterion("lead_unit_code in", values, "leadUnitCode");
            return (Criteria) this;
        }

        public Criteria andLeadUnitCodeNotIn(List<String> values) {
            addCriterion("lead_unit_code not in", values, "leadUnitCode");
            return (Criteria) this;
        }

        public Criteria andLeadUnitCodeBetween(String value1, String value2) {
            addCriterion("lead_unit_code between", value1, value2, "leadUnitCode");
            return (Criteria) this;
        }

        public Criteria andLeadUnitCodeNotBetween(String value1, String value2) {
            addCriterion("lead_unit_code not between", value1, value2, "leadUnitCode");
            return (Criteria) this;
        }

        public Criteria andJoinUnitCodeIsNull() {
            addCriterion("join_unit_code is null");
            return (Criteria) this;
        }

        public Criteria andJoinUnitCodeIsNotNull() {
            addCriterion("join_unit_code is not null");
            return (Criteria) this;
        }

        public Criteria andJoinUnitCodeEqualTo(String value) {
            addCriterion("join_unit_code =", value, "joinUnitCode");
            return (Criteria) this;
        }

        public Criteria andJoinUnitCodeNotEqualTo(String value) {
            addCriterion("join_unit_code <>", value, "joinUnitCode");
            return (Criteria) this;
        }

        public Criteria andJoinUnitCodeGreaterThan(String value) {
            addCriterion("join_unit_code >", value, "joinUnitCode");
            return (Criteria) this;
        }

        public Criteria andJoinUnitCodeGreaterThanOrEqualTo(String value) {
            addCriterion("join_unit_code >=", value, "joinUnitCode");
            return (Criteria) this;
        }

        public Criteria andJoinUnitCodeLessThan(String value) {
            addCriterion("join_unit_code <", value, "joinUnitCode");
            return (Criteria) this;
        }

        public Criteria andJoinUnitCodeLessThanOrEqualTo(String value) {
            addCriterion("join_unit_code <=", value, "joinUnitCode");
            return (Criteria) this;
        }

        public Criteria andJoinUnitCodeLike(String value) {
            addCriterion("join_unit_code like", value, "joinUnitCode");
            return (Criteria) this;
        }

        public Criteria andJoinUnitCodeNotLike(String value) {
            addCriterion("join_unit_code not like", value, "joinUnitCode");
            return (Criteria) this;
        }

        public Criteria andJoinUnitCodeIn(List<String> values) {
            addCriterion("join_unit_code in", values, "joinUnitCode");
            return (Criteria) this;
        }

        public Criteria andJoinUnitCodeNotIn(List<String> values) {
            addCriterion("join_unit_code not in", values, "joinUnitCode");
            return (Criteria) this;
        }

        public Criteria andJoinUnitCodeBetween(String value1, String value2) {
            addCriterion("join_unit_code between", value1, value2, "joinUnitCode");
            return (Criteria) this;
        }

        public Criteria andJoinUnitCodeNotBetween(String value1, String value2) {
            addCriterion("join_unit_code not between", value1, value2, "joinUnitCode");
            return (Criteria) this;
        }

        public Criteria andEntrustUnitCodeIsNull() {
            addCriterion("entrust_unit_code is null");
            return (Criteria) this;
        }

        public Criteria andEntrustUnitCodeIsNotNull() {
            addCriterion("entrust_unit_code is not null");
            return (Criteria) this;
        }

        public Criteria andEntrustUnitCodeEqualTo(String value) {
            addCriterion("entrust_unit_code =", value, "entrustUnitCode");
            return (Criteria) this;
        }

        public Criteria andEntrustUnitCodeNotEqualTo(String value) {
            addCriterion("entrust_unit_code <>", value, "entrustUnitCode");
            return (Criteria) this;
        }

        public Criteria andEntrustUnitCodeGreaterThan(String value) {
            addCriterion("entrust_unit_code >", value, "entrustUnitCode");
            return (Criteria) this;
        }

        public Criteria andEntrustUnitCodeGreaterThanOrEqualTo(String value) {
            addCriterion("entrust_unit_code >=", value, "entrustUnitCode");
            return (Criteria) this;
        }

        public Criteria andEntrustUnitCodeLessThan(String value) {
            addCriterion("entrust_unit_code <", value, "entrustUnitCode");
            return (Criteria) this;
        }

        public Criteria andEntrustUnitCodeLessThanOrEqualTo(String value) {
            addCriterion("entrust_unit_code <=", value, "entrustUnitCode");
            return (Criteria) this;
        }

        public Criteria andEntrustUnitCodeLike(String value) {
            addCriterion("entrust_unit_code like", value, "entrustUnitCode");
            return (Criteria) this;
        }

        public Criteria andEntrustUnitCodeNotLike(String value) {
            addCriterion("entrust_unit_code not like", value, "entrustUnitCode");
            return (Criteria) this;
        }

        public Criteria andEntrustUnitCodeIn(List<String> values) {
            addCriterion("entrust_unit_code in", values, "entrustUnitCode");
            return (Criteria) this;
        }

        public Criteria andEntrustUnitCodeNotIn(List<String> values) {
            addCriterion("entrust_unit_code not in", values, "entrustUnitCode");
            return (Criteria) this;
        }

        public Criteria andEntrustUnitCodeBetween(String value1, String value2) {
            addCriterion("entrust_unit_code between", value1, value2, "entrustUnitCode");
            return (Criteria) this;
        }

        public Criteria andEntrustUnitCodeNotBetween(String value1, String value2) {
            addCriterion("entrust_unit_code not between", value1, value2, "entrustUnitCode");
            return (Criteria) this;
        }

        public Criteria andProjectChargesCodeIsNull() {
            addCriterion("project_charges_code is null");
            return (Criteria) this;
        }

        public Criteria andProjectChargesCodeIsNotNull() {
            addCriterion("project_charges_code is not null");
            return (Criteria) this;
        }

        public Criteria andProjectChargesCodeEqualTo(String value) {
            addCriterion("project_charges_code =", value, "projectChargesCode");
            return (Criteria) this;
        }

        public Criteria andProjectChargesCodeNotEqualTo(String value) {
            addCriterion("project_charges_code <>", value, "projectChargesCode");
            return (Criteria) this;
        }

        public Criteria andProjectChargesCodeGreaterThan(String value) {
            addCriterion("project_charges_code >", value, "projectChargesCode");
            return (Criteria) this;
        }

        public Criteria andProjectChargesCodeGreaterThanOrEqualTo(String value) {
            addCriterion("project_charges_code >=", value, "projectChargesCode");
            return (Criteria) this;
        }

        public Criteria andProjectChargesCodeLessThan(String value) {
            addCriterion("project_charges_code <", value, "projectChargesCode");
            return (Criteria) this;
        }

        public Criteria andProjectChargesCodeLessThanOrEqualTo(String value) {
            addCriterion("project_charges_code <=", value, "projectChargesCode");
            return (Criteria) this;
        }

        public Criteria andProjectChargesCodeLike(String value) {
            addCriterion("project_charges_code like", value, "projectChargesCode");
            return (Criteria) this;
        }

        public Criteria andProjectChargesCodeNotLike(String value) {
            addCriterion("project_charges_code not like", value, "projectChargesCode");
            return (Criteria) this;
        }

        public Criteria andProjectChargesCodeIn(List<String> values) {
            addCriterion("project_charges_code in", values, "projectChargesCode");
            return (Criteria) this;
        }

        public Criteria andProjectChargesCodeNotIn(List<String> values) {
            addCriterion("project_charges_code not in", values, "projectChargesCode");
            return (Criteria) this;
        }

        public Criteria andProjectChargesCodeBetween(String value1, String value2) {
            addCriterion("project_charges_code between", value1, value2, "projectChargesCode");
            return (Criteria) this;
        }

        public Criteria andProjectChargesCodeNotBetween(String value1, String value2) {
            addCriterion("project_charges_code not between", value1, value2, "projectChargesCode");
            return (Criteria) this;
        }

        public Criteria andProjectChargesNameIsNull() {
            addCriterion("project_charges_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectChargesNameIsNotNull() {
            addCriterion("project_charges_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectChargesNameEqualTo(String value) {
            addCriterion("project_charges_name =", value, "projectChargesName");
            return (Criteria) this;
        }

        public Criteria andProjectChargesNameNotEqualTo(String value) {
            addCriterion("project_charges_name <>", value, "projectChargesName");
            return (Criteria) this;
        }

        public Criteria andProjectChargesNameGreaterThan(String value) {
            addCriterion("project_charges_name >", value, "projectChargesName");
            return (Criteria) this;
        }

        public Criteria andProjectChargesNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_charges_name >=", value, "projectChargesName");
            return (Criteria) this;
        }

        public Criteria andProjectChargesNameLessThan(String value) {
            addCriterion("project_charges_name <", value, "projectChargesName");
            return (Criteria) this;
        }

        public Criteria andProjectChargesNameLessThanOrEqualTo(String value) {
            addCriterion("project_charges_name <=", value, "projectChargesName");
            return (Criteria) this;
        }

        public Criteria andProjectChargesNameLike(String value) {
            addCriterion("project_charges_name like", value, "projectChargesName");
            return (Criteria) this;
        }

        public Criteria andProjectChargesNameNotLike(String value) {
            addCriterion("project_charges_name not like", value, "projectChargesName");
            return (Criteria) this;
        }

        public Criteria andProjectChargesNameIn(List<String> values) {
            addCriterion("project_charges_name in", values, "projectChargesName");
            return (Criteria) this;
        }

        public Criteria andProjectChargesNameNotIn(List<String> values) {
            addCriterion("project_charges_name not in", values, "projectChargesName");
            return (Criteria) this;
        }

        public Criteria andProjectChargesNameBetween(String value1, String value2) {
            addCriterion("project_charges_name between", value1, value2, "projectChargesName");
            return (Criteria) this;
        }

        public Criteria andProjectChargesNameNotBetween(String value1, String value2) {
            addCriterion("project_charges_name not between", value1, value2, "projectChargesName");
            return (Criteria) this;
        }

        public Criteria andLeadLinkmansCodeIsNull() {
            addCriterion("lead_linkmans_code is null");
            return (Criteria) this;
        }

        public Criteria andLeadLinkmansCodeIsNotNull() {
            addCriterion("lead_linkmans_code is not null");
            return (Criteria) this;
        }

        public Criteria andLeadLinkmansCodeEqualTo(String value) {
            addCriterion("lead_linkmans_code =", value, "leadLinkmansCode");
            return (Criteria) this;
        }

        public Criteria andLeadLinkmansCodeNotEqualTo(String value) {
            addCriterion("lead_linkmans_code <>", value, "leadLinkmansCode");
            return (Criteria) this;
        }

        public Criteria andLeadLinkmansCodeGreaterThan(String value) {
            addCriterion("lead_linkmans_code >", value, "leadLinkmansCode");
            return (Criteria) this;
        }

        public Criteria andLeadLinkmansCodeGreaterThanOrEqualTo(String value) {
            addCriterion("lead_linkmans_code >=", value, "leadLinkmansCode");
            return (Criteria) this;
        }

        public Criteria andLeadLinkmansCodeLessThan(String value) {
            addCriterion("lead_linkmans_code <", value, "leadLinkmansCode");
            return (Criteria) this;
        }

        public Criteria andLeadLinkmansCodeLessThanOrEqualTo(String value) {
            addCriterion("lead_linkmans_code <=", value, "leadLinkmansCode");
            return (Criteria) this;
        }

        public Criteria andLeadLinkmansCodeLike(String value) {
            addCriterion("lead_linkmans_code like", value, "leadLinkmansCode");
            return (Criteria) this;
        }

        public Criteria andLeadLinkmansCodeNotLike(String value) {
            addCriterion("lead_linkmans_code not like", value, "leadLinkmansCode");
            return (Criteria) this;
        }

        public Criteria andLeadLinkmansCodeIn(List<String> values) {
            addCriterion("lead_linkmans_code in", values, "leadLinkmansCode");
            return (Criteria) this;
        }

        public Criteria andLeadLinkmansCodeNotIn(List<String> values) {
            addCriterion("lead_linkmans_code not in", values, "leadLinkmansCode");
            return (Criteria) this;
        }

        public Criteria andLeadLinkmansCodeBetween(String value1, String value2) {
            addCriterion("lead_linkmans_code between", value1, value2, "leadLinkmansCode");
            return (Criteria) this;
        }

        public Criteria andLeadLinkmansCodeNotBetween(String value1, String value2) {
            addCriterion("lead_linkmans_code not between", value1, value2, "leadLinkmansCode");
            return (Criteria) this;
        }

        public Criteria andLeadLinkmansNameIsNull() {
            addCriterion("lead_linkmans_name is null");
            return (Criteria) this;
        }

        public Criteria andLeadLinkmansNameIsNotNull() {
            addCriterion("lead_linkmans_name is not null");
            return (Criteria) this;
        }

        public Criteria andLeadLinkmansNameEqualTo(String value) {
            addCriterion("lead_linkmans_name =", value, "leadLinkmansName");
            return (Criteria) this;
        }

        public Criteria andLeadLinkmansNameNotEqualTo(String value) {
            addCriterion("lead_linkmans_name <>", value, "leadLinkmansName");
            return (Criteria) this;
        }

        public Criteria andLeadLinkmansNameGreaterThan(String value) {
            addCriterion("lead_linkmans_name >", value, "leadLinkmansName");
            return (Criteria) this;
        }

        public Criteria andLeadLinkmansNameGreaterThanOrEqualTo(String value) {
            addCriterion("lead_linkmans_name >=", value, "leadLinkmansName");
            return (Criteria) this;
        }

        public Criteria andLeadLinkmansNameLessThan(String value) {
            addCriterion("lead_linkmans_name <", value, "leadLinkmansName");
            return (Criteria) this;
        }

        public Criteria andLeadLinkmansNameLessThanOrEqualTo(String value) {
            addCriterion("lead_linkmans_name <=", value, "leadLinkmansName");
            return (Criteria) this;
        }

        public Criteria andLeadLinkmansNameLike(String value) {
            addCriterion("lead_linkmans_name like", value, "leadLinkmansName");
            return (Criteria) this;
        }

        public Criteria andLeadLinkmansNameNotLike(String value) {
            addCriterion("lead_linkmans_name not like", value, "leadLinkmansName");
            return (Criteria) this;
        }

        public Criteria andLeadLinkmansNameIn(List<String> values) {
            addCriterion("lead_linkmans_name in", values, "leadLinkmansName");
            return (Criteria) this;
        }

        public Criteria andLeadLinkmansNameNotIn(List<String> values) {
            addCriterion("lead_linkmans_name not in", values, "leadLinkmansName");
            return (Criteria) this;
        }

        public Criteria andLeadLinkmansNameBetween(String value1, String value2) {
            addCriterion("lead_linkmans_name between", value1, value2, "leadLinkmansName");
            return (Criteria) this;
        }

        public Criteria andLeadLinkmansNameNotBetween(String value1, String value2) {
            addCriterion("lead_linkmans_name not between", value1, value2, "leadLinkmansName");
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