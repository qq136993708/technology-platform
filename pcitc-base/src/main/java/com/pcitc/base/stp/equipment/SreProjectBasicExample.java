package com.pcitc.base.stp.equipment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SreProjectBasicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SreProjectBasicExample() {
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

        public Criteria andOrdersIsNull() {
            addCriterion("orders is null");
            return (Criteria) this;
        }

        public Criteria andOrdersIsNotNull() {
            addCriterion("orders is not null");
            return (Criteria) this;
        }

        public Criteria andOrdersEqualTo(Integer value) {
            addCriterion("orders =", value, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersNotEqualTo(Integer value) {
            addCriterion("orders <>", value, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersGreaterThan(Integer value) {
            addCriterion("orders >", value, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersGreaterThanOrEqualTo(Integer value) {
            addCriterion("orders >=", value, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersLessThan(Integer value) {
            addCriterion("orders <", value, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersLessThanOrEqualTo(Integer value) {
            addCriterion("orders <=", value, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersIn(List<Integer> values) {
            addCriterion("orders in", values, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersNotIn(List<Integer> values) {
            addCriterion("orders not in", values, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersBetween(Integer value1, Integer value2) {
            addCriterion("orders between", value1, value2, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersNotBetween(Integer value1, Integer value2) {
            addCriterion("orders not between", value1, value2, "orders");
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

        public Criteria andApplyMoneyIsNull() {
            addCriterion("apply_money is null");
            return (Criteria) this;
        }

        public Criteria andApplyMoneyIsNotNull() {
            addCriterion("apply_money is not null");
            return (Criteria) this;
        }

        public Criteria andApplyMoneyEqualTo(BigDecimal value) {
            addCriterion("apply_money =", value, "applyMoney");
            return (Criteria) this;
        }

        public Criteria andApplyMoneyNotEqualTo(BigDecimal value) {
            addCriterion("apply_money <>", value, "applyMoney");
            return (Criteria) this;
        }

        public Criteria andApplyMoneyGreaterThan(BigDecimal value) {
            addCriterion("apply_money >", value, "applyMoney");
            return (Criteria) this;
        }

        public Criteria andApplyMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("apply_money >=", value, "applyMoney");
            return (Criteria) this;
        }

        public Criteria andApplyMoneyLessThan(BigDecimal value) {
            addCriterion("apply_money <", value, "applyMoney");
            return (Criteria) this;
        }

        public Criteria andApplyMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("apply_money <=", value, "applyMoney");
            return (Criteria) this;
        }

        public Criteria andApplyMoneyIn(List<BigDecimal> values) {
            addCriterion("apply_money in", values, "applyMoney");
            return (Criteria) this;
        }

        public Criteria andApplyMoneyNotIn(List<BigDecimal> values) {
            addCriterion("apply_money not in", values, "applyMoney");
            return (Criteria) this;
        }

        public Criteria andApplyMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("apply_money between", value1, value2, "applyMoney");
            return (Criteria) this;
        }

        public Criteria andApplyMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("apply_money not between", value1, value2, "applyMoney");
            return (Criteria) this;
        }

        public Criteria andCheckMoneyIsNull() {
            addCriterion("check_money is null");
            return (Criteria) this;
        }

        public Criteria andCheckMoneyIsNotNull() {
            addCriterion("check_money is not null");
            return (Criteria) this;
        }

        public Criteria andCheckMoneyEqualTo(BigDecimal value) {
            addCriterion("check_money =", value, "checkMoney");
            return (Criteria) this;
        }

        public Criteria andCheckMoneyNotEqualTo(BigDecimal value) {
            addCriterion("check_money <>", value, "checkMoney");
            return (Criteria) this;
        }

        public Criteria andCheckMoneyGreaterThan(BigDecimal value) {
            addCriterion("check_money >", value, "checkMoney");
            return (Criteria) this;
        }

        public Criteria andCheckMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("check_money >=", value, "checkMoney");
            return (Criteria) this;
        }

        public Criteria andCheckMoneyLessThan(BigDecimal value) {
            addCriterion("check_money <", value, "checkMoney");
            return (Criteria) this;
        }

        public Criteria andCheckMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("check_money <=", value, "checkMoney");
            return (Criteria) this;
        }

        public Criteria andCheckMoneyIn(List<BigDecimal> values) {
            addCriterion("check_money in", values, "checkMoney");
            return (Criteria) this;
        }

        public Criteria andCheckMoneyNotIn(List<BigDecimal> values) {
            addCriterion("check_money not in", values, "checkMoney");
            return (Criteria) this;
        }

        public Criteria andCheckMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("check_money between", value1, value2, "checkMoney");
            return (Criteria) this;
        }

        public Criteria andCheckMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("check_money not between", value1, value2, "checkMoney");
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

        public Criteria andApplyUnitIsNull() {
            addCriterion("apply_unit is null");
            return (Criteria) this;
        }

        public Criteria andApplyUnitIsNotNull() {
            addCriterion("apply_unit is not null");
            return (Criteria) this;
        }

        public Criteria andApplyUnitEqualTo(String value) {
            addCriterion("apply_unit =", value, "applyUnit");
            return (Criteria) this;
        }

        public Criteria andApplyUnitNotEqualTo(String value) {
            addCriterion("apply_unit <>", value, "applyUnit");
            return (Criteria) this;
        }

        public Criteria andApplyUnitGreaterThan(String value) {
            addCriterion("apply_unit >", value, "applyUnit");
            return (Criteria) this;
        }

        public Criteria andApplyUnitGreaterThanOrEqualTo(String value) {
            addCriterion("apply_unit >=", value, "applyUnit");
            return (Criteria) this;
        }

        public Criteria andApplyUnitLessThan(String value) {
            addCriterion("apply_unit <", value, "applyUnit");
            return (Criteria) this;
        }

        public Criteria andApplyUnitLessThanOrEqualTo(String value) {
            addCriterion("apply_unit <=", value, "applyUnit");
            return (Criteria) this;
        }

        public Criteria andApplyUnitLike(String value) {
            addCriterion("apply_unit like", value, "applyUnit");
            return (Criteria) this;
        }

        public Criteria andApplyUnitNotLike(String value) {
            addCriterion("apply_unit not like", value, "applyUnit");
            return (Criteria) this;
        }

        public Criteria andApplyUnitIn(List<String> values) {
            addCriterion("apply_unit in", values, "applyUnit");
            return (Criteria) this;
        }

        public Criteria andApplyUnitNotIn(List<String> values) {
            addCriterion("apply_unit not in", values, "applyUnit");
            return (Criteria) this;
        }

        public Criteria andApplyUnitBetween(String value1, String value2) {
            addCriterion("apply_unit between", value1, value2, "applyUnit");
            return (Criteria) this;
        }

        public Criteria andApplyUnitNotBetween(String value1, String value2) {
            addCriterion("apply_unit not between", value1, value2, "applyUnit");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNull() {
            addCriterion("is_del is null");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNotNull() {
            addCriterion("is_del is not null");
            return (Criteria) this;
        }

        public Criteria andIsDelEqualTo(String value) {
            addCriterion("is_del =", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotEqualTo(String value) {
            addCriterion("is_del <>", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThan(String value) {
            addCriterion("is_del >", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThanOrEqualTo(String value) {
            addCriterion("is_del >=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThan(String value) {
            addCriterion("is_del <", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThanOrEqualTo(String value) {
            addCriterion("is_del <=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLike(String value) {
            addCriterion("is_del like", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotLike(String value) {
            addCriterion("is_del not like", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelIn(List<String> values) {
            addCriterion("is_del in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotIn(List<String> values) {
            addCriterion("is_del not in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelBetween(String value1, String value2) {
            addCriterion("is_del between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotBetween(String value1, String value2) {
            addCriterion("is_del not between", value1, value2, "isDel");
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

        public Criteria andProjectCategoryIsNull() {
            addCriterion("project_category is null");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryIsNotNull() {
            addCriterion("project_category is not null");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryEqualTo(String value) {
            addCriterion("project_category =", value, "projectCategory");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryNotEqualTo(String value) {
            addCriterion("project_category <>", value, "projectCategory");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryGreaterThan(String value) {
            addCriterion("project_category >", value, "projectCategory");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("project_category >=", value, "projectCategory");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryLessThan(String value) {
            addCriterion("project_category <", value, "projectCategory");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryLessThanOrEqualTo(String value) {
            addCriterion("project_category <=", value, "projectCategory");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryLike(String value) {
            addCriterion("project_category like", value, "projectCategory");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryNotLike(String value) {
            addCriterion("project_category not like", value, "projectCategory");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryIn(List<String> values) {
            addCriterion("project_category in", values, "projectCategory");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryNotIn(List<String> values) {
            addCriterion("project_category not in", values, "projectCategory");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryBetween(String value1, String value2) {
            addCriterion("project_category between", value1, value2, "projectCategory");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryNotBetween(String value1, String value2) {
            addCriterion("project_category not between", value1, value2, "projectCategory");
            return (Criteria) this;
        }

        public Criteria andXeStateIsNull() {
            addCriterion("xe_state is null");
            return (Criteria) this;
        }

        public Criteria andXeStateIsNotNull() {
            addCriterion("xe_state is not null");
            return (Criteria) this;
        }

        public Criteria andXeStateEqualTo(String value) {
            addCriterion("xe_state =", value, "xeState");
            return (Criteria) this;
        }

        public Criteria andXeStateNotEqualTo(String value) {
            addCriterion("xe_state <>", value, "xeState");
            return (Criteria) this;
        }

        public Criteria andXeStateGreaterThan(String value) {
            addCriterion("xe_state >", value, "xeState");
            return (Criteria) this;
        }

        public Criteria andXeStateGreaterThanOrEqualTo(String value) {
            addCriterion("xe_state >=", value, "xeState");
            return (Criteria) this;
        }

        public Criteria andXeStateLessThan(String value) {
            addCriterion("xe_state <", value, "xeState");
            return (Criteria) this;
        }

        public Criteria andXeStateLessThanOrEqualTo(String value) {
            addCriterion("xe_state <=", value, "xeState");
            return (Criteria) this;
        }

        public Criteria andXeStateLike(String value) {
            addCriterion("xe_state like", value, "xeState");
            return (Criteria) this;
        }

        public Criteria andXeStateNotLike(String value) {
            addCriterion("xe_state not like", value, "xeState");
            return (Criteria) this;
        }

        public Criteria andXeStateIn(List<String> values) {
            addCriterion("xe_state in", values, "xeState");
            return (Criteria) this;
        }

        public Criteria andXeStateNotIn(List<String> values) {
            addCriterion("xe_state not in", values, "xeState");
            return (Criteria) this;
        }

        public Criteria andXeStateBetween(String value1, String value2) {
            addCriterion("xe_state between", value1, value2, "xeState");
            return (Criteria) this;
        }

        public Criteria andXeStateNotBetween(String value1, String value2) {
            addCriterion("xe_state not between", value1, value2, "xeState");
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

        public Criteria andYearMoneyIsNull() {
            addCriterion("year_money is null");
            return (Criteria) this;
        }

        public Criteria andYearMoneyIsNotNull() {
            addCriterion("year_money is not null");
            return (Criteria) this;
        }

        public Criteria andYearMoneyEqualTo(String value) {
            addCriterion("year_money =", value, "yearMoney");
            return (Criteria) this;
        }

        public Criteria andYearMoneyNotEqualTo(String value) {
            addCriterion("year_money <>", value, "yearMoney");
            return (Criteria) this;
        }

        public Criteria andYearMoneyGreaterThan(String value) {
            addCriterion("year_money >", value, "yearMoney");
            return (Criteria) this;
        }

        public Criteria andYearMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("year_money >=", value, "yearMoney");
            return (Criteria) this;
        }

        public Criteria andYearMoneyLessThan(String value) {
            addCriterion("year_money <", value, "yearMoney");
            return (Criteria) this;
        }

        public Criteria andYearMoneyLessThanOrEqualTo(String value) {
            addCriterion("year_money <=", value, "yearMoney");
            return (Criteria) this;
        }

        public Criteria andYearMoneyLike(String value) {
            addCriterion("year_money like", value, "yearMoney");
            return (Criteria) this;
        }

        public Criteria andYearMoneyNotLike(String value) {
            addCriterion("year_money not like", value, "yearMoney");
            return (Criteria) this;
        }

        public Criteria andYearMoneyIn(List<String> values) {
            addCriterion("year_money in", values, "yearMoney");
            return (Criteria) this;
        }

        public Criteria andYearMoneyNotIn(List<String> values) {
            addCriterion("year_money not in", values, "yearMoney");
            return (Criteria) this;
        }

        public Criteria andYearMoneyBetween(String value1, String value2) {
            addCriterion("year_money between", value1, value2, "yearMoney");
            return (Criteria) this;
        }

        public Criteria andYearMoneyNotBetween(String value1, String value2) {
            addCriterion("year_money not between", value1, value2, "yearMoney");
            return (Criteria) this;
        }

        public Criteria andFirstReportStatusIsNull() {
            addCriterion("first_report_status is null");
            return (Criteria) this;
        }

        public Criteria andFirstReportStatusIsNotNull() {
            addCriterion("first_report_status is not null");
            return (Criteria) this;
        }

        public Criteria andFirstReportStatusEqualTo(String value) {
            addCriterion("first_report_status =", value, "firstReportStatus");
            return (Criteria) this;
        }

        public Criteria andFirstReportStatusNotEqualTo(String value) {
            addCriterion("first_report_status <>", value, "firstReportStatus");
            return (Criteria) this;
        }

        public Criteria andFirstReportStatusGreaterThan(String value) {
            addCriterion("first_report_status >", value, "firstReportStatus");
            return (Criteria) this;
        }

        public Criteria andFirstReportStatusGreaterThanOrEqualTo(String value) {
            addCriterion("first_report_status >=", value, "firstReportStatus");
            return (Criteria) this;
        }

        public Criteria andFirstReportStatusLessThan(String value) {
            addCriterion("first_report_status <", value, "firstReportStatus");
            return (Criteria) this;
        }

        public Criteria andFirstReportStatusLessThanOrEqualTo(String value) {
            addCriterion("first_report_status <=", value, "firstReportStatus");
            return (Criteria) this;
        }

        public Criteria andFirstReportStatusLike(String value) {
            addCriterion("first_report_status like", value, "firstReportStatus");
            return (Criteria) this;
        }

        public Criteria andFirstReportStatusNotLike(String value) {
            addCriterion("first_report_status not like", value, "firstReportStatus");
            return (Criteria) this;
        }

        public Criteria andFirstReportStatusIn(List<String> values) {
            addCriterion("first_report_status in", values, "firstReportStatus");
            return (Criteria) this;
        }

        public Criteria andFirstReportStatusNotIn(List<String> values) {
            addCriterion("first_report_status not in", values, "firstReportStatus");
            return (Criteria) this;
        }

        public Criteria andFirstReportStatusBetween(String value1, String value2) {
            addCriterion("first_report_status between", value1, value2, "firstReportStatus");
            return (Criteria) this;
        }

        public Criteria andFirstReportStatusNotBetween(String value1, String value2) {
            addCriterion("first_report_status not between", value1, value2, "firstReportStatus");
            return (Criteria) this;
        }

        public Criteria andReviewReportStatusIsNull() {
            addCriterion("review_report_status is null");
            return (Criteria) this;
        }

        public Criteria andReviewReportStatusIsNotNull() {
            addCriterion("review_report_status is not null");
            return (Criteria) this;
        }

        public Criteria andReviewReportStatusEqualTo(String value) {
            addCriterion("review_report_status =", value, "reviewReportStatus");
            return (Criteria) this;
        }

        public Criteria andReviewReportStatusNotEqualTo(String value) {
            addCriterion("review_report_status <>", value, "reviewReportStatus");
            return (Criteria) this;
        }

        public Criteria andReviewReportStatusGreaterThan(String value) {
            addCriterion("review_report_status >", value, "reviewReportStatus");
            return (Criteria) this;
        }

        public Criteria andReviewReportStatusGreaterThanOrEqualTo(String value) {
            addCriterion("review_report_status >=", value, "reviewReportStatus");
            return (Criteria) this;
        }

        public Criteria andReviewReportStatusLessThan(String value) {
            addCriterion("review_report_status <", value, "reviewReportStatus");
            return (Criteria) this;
        }

        public Criteria andReviewReportStatusLessThanOrEqualTo(String value) {
            addCriterion("review_report_status <=", value, "reviewReportStatus");
            return (Criteria) this;
        }

        public Criteria andReviewReportStatusLike(String value) {
            addCriterion("review_report_status like", value, "reviewReportStatus");
            return (Criteria) this;
        }

        public Criteria andReviewReportStatusNotLike(String value) {
            addCriterion("review_report_status not like", value, "reviewReportStatus");
            return (Criteria) this;
        }

        public Criteria andReviewReportStatusIn(List<String> values) {
            addCriterion("review_report_status in", values, "reviewReportStatus");
            return (Criteria) this;
        }

        public Criteria andReviewReportStatusNotIn(List<String> values) {
            addCriterion("review_report_status not in", values, "reviewReportStatus");
            return (Criteria) this;
        }

        public Criteria andReviewReportStatusBetween(String value1, String value2) {
            addCriterion("review_report_status between", value1, value2, "reviewReportStatus");
            return (Criteria) this;
        }

        public Criteria andReviewReportStatusNotBetween(String value1, String value2) {
            addCriterion("review_report_status not between", value1, value2, "reviewReportStatus");
            return (Criteria) this;
        }

        public Criteria andApplyDocIsNull() {
            addCriterion("apply_doc is null");
            return (Criteria) this;
        }

        public Criteria andApplyDocIsNotNull() {
            addCriterion("apply_doc is not null");
            return (Criteria) this;
        }

        public Criteria andApplyDocEqualTo(String value) {
            addCriterion("apply_doc =", value, "applyDoc");
            return (Criteria) this;
        }

        public Criteria andApplyDocNotEqualTo(String value) {
            addCriterion("apply_doc <>", value, "applyDoc");
            return (Criteria) this;
        }

        public Criteria andApplyDocGreaterThan(String value) {
            addCriterion("apply_doc >", value, "applyDoc");
            return (Criteria) this;
        }

        public Criteria andApplyDocGreaterThanOrEqualTo(String value) {
            addCriterion("apply_doc >=", value, "applyDoc");
            return (Criteria) this;
        }

        public Criteria andApplyDocLessThan(String value) {
            addCriterion("apply_doc <", value, "applyDoc");
            return (Criteria) this;
        }

        public Criteria andApplyDocLessThanOrEqualTo(String value) {
            addCriterion("apply_doc <=", value, "applyDoc");
            return (Criteria) this;
        }

        public Criteria andApplyDocLike(String value) {
            addCriterion("apply_doc like", value, "applyDoc");
            return (Criteria) this;
        }

        public Criteria andApplyDocNotLike(String value) {
            addCriterion("apply_doc not like", value, "applyDoc");
            return (Criteria) this;
        }

        public Criteria andApplyDocIn(List<String> values) {
            addCriterion("apply_doc in", values, "applyDoc");
            return (Criteria) this;
        }

        public Criteria andApplyDocNotIn(List<String> values) {
            addCriterion("apply_doc not in", values, "applyDoc");
            return (Criteria) this;
        }

        public Criteria andApplyDocBetween(String value1, String value2) {
            addCriterion("apply_doc between", value1, value2, "applyDoc");
            return (Criteria) this;
        }

        public Criteria andApplyDocNotBetween(String value1, String value2) {
            addCriterion("apply_doc not between", value1, value2, "applyDoc");
            return (Criteria) this;
        }

        public Criteria andAuditDocIsNull() {
            addCriterion("audit_doc is null");
            return (Criteria) this;
        }

        public Criteria andAuditDocIsNotNull() {
            addCriterion("audit_doc is not null");
            return (Criteria) this;
        }

        public Criteria andAuditDocEqualTo(String value) {
            addCriterion("audit_doc =", value, "auditDoc");
            return (Criteria) this;
        }

        public Criteria andAuditDocNotEqualTo(String value) {
            addCriterion("audit_doc <>", value, "auditDoc");
            return (Criteria) this;
        }

        public Criteria andAuditDocGreaterThan(String value) {
            addCriterion("audit_doc >", value, "auditDoc");
            return (Criteria) this;
        }

        public Criteria andAuditDocGreaterThanOrEqualTo(String value) {
            addCriterion("audit_doc >=", value, "auditDoc");
            return (Criteria) this;
        }

        public Criteria andAuditDocLessThan(String value) {
            addCriterion("audit_doc <", value, "auditDoc");
            return (Criteria) this;
        }

        public Criteria andAuditDocLessThanOrEqualTo(String value) {
            addCriterion("audit_doc <=", value, "auditDoc");
            return (Criteria) this;
        }

        public Criteria andAuditDocLike(String value) {
            addCriterion("audit_doc like", value, "auditDoc");
            return (Criteria) this;
        }

        public Criteria andAuditDocNotLike(String value) {
            addCriterion("audit_doc not like", value, "auditDoc");
            return (Criteria) this;
        }

        public Criteria andAuditDocIn(List<String> values) {
            addCriterion("audit_doc in", values, "auditDoc");
            return (Criteria) this;
        }

        public Criteria andAuditDocNotIn(List<String> values) {
            addCriterion("audit_doc not in", values, "auditDoc");
            return (Criteria) this;
        }

        public Criteria andAuditDocBetween(String value1, String value2) {
            addCriterion("audit_doc between", value1, value2, "auditDoc");
            return (Criteria) this;
        }

        public Criteria andAuditDocNotBetween(String value1, String value2) {
            addCriterion("audit_doc not between", value1, value2, "auditDoc");
            return (Criteria) this;
        }

        public Criteria andInvestDocIsNull() {
            addCriterion("invest_doc is null");
            return (Criteria) this;
        }

        public Criteria andInvestDocIsNotNull() {
            addCriterion("invest_doc is not null");
            return (Criteria) this;
        }

        public Criteria andInvestDocEqualTo(String value) {
            addCriterion("invest_doc =", value, "investDoc");
            return (Criteria) this;
        }

        public Criteria andInvestDocNotEqualTo(String value) {
            addCriterion("invest_doc <>", value, "investDoc");
            return (Criteria) this;
        }

        public Criteria andInvestDocGreaterThan(String value) {
            addCriterion("invest_doc >", value, "investDoc");
            return (Criteria) this;
        }

        public Criteria andInvestDocGreaterThanOrEqualTo(String value) {
            addCriterion("invest_doc >=", value, "investDoc");
            return (Criteria) this;
        }

        public Criteria andInvestDocLessThan(String value) {
            addCriterion("invest_doc <", value, "investDoc");
            return (Criteria) this;
        }

        public Criteria andInvestDocLessThanOrEqualTo(String value) {
            addCriterion("invest_doc <=", value, "investDoc");
            return (Criteria) this;
        }

        public Criteria andInvestDocLike(String value) {
            addCriterion("invest_doc like", value, "investDoc");
            return (Criteria) this;
        }

        public Criteria andInvestDocNotLike(String value) {
            addCriterion("invest_doc not like", value, "investDoc");
            return (Criteria) this;
        }

        public Criteria andInvestDocIn(List<String> values) {
            addCriterion("invest_doc in", values, "investDoc");
            return (Criteria) this;
        }

        public Criteria andInvestDocNotIn(List<String> values) {
            addCriterion("invest_doc not in", values, "investDoc");
            return (Criteria) this;
        }

        public Criteria andInvestDocBetween(String value1, String value2) {
            addCriterion("invest_doc between", value1, value2, "investDoc");
            return (Criteria) this;
        }

        public Criteria andInvestDocNotBetween(String value1, String value2) {
            addCriterion("invest_doc not between", value1, value2, "investDoc");
            return (Criteria) this;
        }

        public Criteria andTaskMainTaskContentIsNull() {
            addCriterion("task_main_task_content is null");
            return (Criteria) this;
        }

        public Criteria andTaskMainTaskContentIsNotNull() {
            addCriterion("task_main_task_content is not null");
            return (Criteria) this;
        }

        public Criteria andTaskMainTaskContentEqualTo(String value) {
            addCriterion("task_main_task_content =", value, "taskMainTaskContent");
            return (Criteria) this;
        }

        public Criteria andTaskMainTaskContentNotEqualTo(String value) {
            addCriterion("task_main_task_content <>", value, "taskMainTaskContent");
            return (Criteria) this;
        }

        public Criteria andTaskMainTaskContentGreaterThan(String value) {
            addCriterion("task_main_task_content >", value, "taskMainTaskContent");
            return (Criteria) this;
        }

        public Criteria andTaskMainTaskContentGreaterThanOrEqualTo(String value) {
            addCriterion("task_main_task_content >=", value, "taskMainTaskContent");
            return (Criteria) this;
        }

        public Criteria andTaskMainTaskContentLessThan(String value) {
            addCriterion("task_main_task_content <", value, "taskMainTaskContent");
            return (Criteria) this;
        }

        public Criteria andTaskMainTaskContentLessThanOrEqualTo(String value) {
            addCriterion("task_main_task_content <=", value, "taskMainTaskContent");
            return (Criteria) this;
        }

        public Criteria andTaskMainTaskContentLike(String value) {
            addCriterion("task_main_task_content like", value, "taskMainTaskContent");
            return (Criteria) this;
        }

        public Criteria andTaskMainTaskContentNotLike(String value) {
            addCriterion("task_main_task_content not like", value, "taskMainTaskContent");
            return (Criteria) this;
        }

        public Criteria andTaskMainTaskContentIn(List<String> values) {
            addCriterion("task_main_task_content in", values, "taskMainTaskContent");
            return (Criteria) this;
        }

        public Criteria andTaskMainTaskContentNotIn(List<String> values) {
            addCriterion("task_main_task_content not in", values, "taskMainTaskContent");
            return (Criteria) this;
        }

        public Criteria andTaskMainTaskContentBetween(String value1, String value2) {
            addCriterion("task_main_task_content between", value1, value2, "taskMainTaskContent");
            return (Criteria) this;
        }

        public Criteria andTaskMainTaskContentNotBetween(String value1, String value2) {
            addCriterion("task_main_task_content not between", value1, value2, "taskMainTaskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentIsNull() {
            addCriterion("task_content is null");
            return (Criteria) this;
        }

        public Criteria andTaskContentIsNotNull() {
            addCriterion("task_content is not null");
            return (Criteria) this;
        }

        public Criteria andTaskContentEqualTo(String value) {
            addCriterion("task_content =", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotEqualTo(String value) {
            addCriterion("task_content <>", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentGreaterThan(String value) {
            addCriterion("task_content >", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentGreaterThanOrEqualTo(String value) {
            addCriterion("task_content >=", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentLessThan(String value) {
            addCriterion("task_content <", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentLessThanOrEqualTo(String value) {
            addCriterion("task_content <=", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentLike(String value) {
            addCriterion("task_content like", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotLike(String value) {
            addCriterion("task_content not like", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentIn(List<String> values) {
            addCriterion("task_content in", values, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotIn(List<String> values) {
            addCriterion("task_content not in", values, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentBetween(String value1, String value2) {
            addCriterion("task_content between", value1, value2, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotBetween(String value1, String value2) {
            addCriterion("task_content not between", value1, value2, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskAssessmentContentIsNull() {
            addCriterion("task_assessment_content is null");
            return (Criteria) this;
        }

        public Criteria andTaskAssessmentContentIsNotNull() {
            addCriterion("task_assessment_content is not null");
            return (Criteria) this;
        }

        public Criteria andTaskAssessmentContentEqualTo(String value) {
            addCriterion("task_assessment_content =", value, "taskAssessmentContent");
            return (Criteria) this;
        }

        public Criteria andTaskAssessmentContentNotEqualTo(String value) {
            addCriterion("task_assessment_content <>", value, "taskAssessmentContent");
            return (Criteria) this;
        }

        public Criteria andTaskAssessmentContentGreaterThan(String value) {
            addCriterion("task_assessment_content >", value, "taskAssessmentContent");
            return (Criteria) this;
        }

        public Criteria andTaskAssessmentContentGreaterThanOrEqualTo(String value) {
            addCriterion("task_assessment_content >=", value, "taskAssessmentContent");
            return (Criteria) this;
        }

        public Criteria andTaskAssessmentContentLessThan(String value) {
            addCriterion("task_assessment_content <", value, "taskAssessmentContent");
            return (Criteria) this;
        }

        public Criteria andTaskAssessmentContentLessThanOrEqualTo(String value) {
            addCriterion("task_assessment_content <=", value, "taskAssessmentContent");
            return (Criteria) this;
        }

        public Criteria andTaskAssessmentContentLike(String value) {
            addCriterion("task_assessment_content like", value, "taskAssessmentContent");
            return (Criteria) this;
        }

        public Criteria andTaskAssessmentContentNotLike(String value) {
            addCriterion("task_assessment_content not like", value, "taskAssessmentContent");
            return (Criteria) this;
        }

        public Criteria andTaskAssessmentContentIn(List<String> values) {
            addCriterion("task_assessment_content in", values, "taskAssessmentContent");
            return (Criteria) this;
        }

        public Criteria andTaskAssessmentContentNotIn(List<String> values) {
            addCriterion("task_assessment_content not in", values, "taskAssessmentContent");
            return (Criteria) this;
        }

        public Criteria andTaskAssessmentContentBetween(String value1, String value2) {
            addCriterion("task_assessment_content between", value1, value2, "taskAssessmentContent");
            return (Criteria) this;
        }

        public Criteria andTaskAssessmentContentNotBetween(String value1, String value2) {
            addCriterion("task_assessment_content not between", value1, value2, "taskAssessmentContent");
            return (Criteria) this;
        }

        public Criteria andTaskCheckContentsIsNull() {
            addCriterion("task_check_contents is null");
            return (Criteria) this;
        }

        public Criteria andTaskCheckContentsIsNotNull() {
            addCriterion("task_check_contents is not null");
            return (Criteria) this;
        }

        public Criteria andTaskCheckContentsEqualTo(String value) {
            addCriterion("task_check_contents =", value, "taskCheckContents");
            return (Criteria) this;
        }

        public Criteria andTaskCheckContentsNotEqualTo(String value) {
            addCriterion("task_check_contents <>", value, "taskCheckContents");
            return (Criteria) this;
        }

        public Criteria andTaskCheckContentsGreaterThan(String value) {
            addCriterion("task_check_contents >", value, "taskCheckContents");
            return (Criteria) this;
        }

        public Criteria andTaskCheckContentsGreaterThanOrEqualTo(String value) {
            addCriterion("task_check_contents >=", value, "taskCheckContents");
            return (Criteria) this;
        }

        public Criteria andTaskCheckContentsLessThan(String value) {
            addCriterion("task_check_contents <", value, "taskCheckContents");
            return (Criteria) this;
        }

        public Criteria andTaskCheckContentsLessThanOrEqualTo(String value) {
            addCriterion("task_check_contents <=", value, "taskCheckContents");
            return (Criteria) this;
        }

        public Criteria andTaskCheckContentsLike(String value) {
            addCriterion("task_check_contents like", value, "taskCheckContents");
            return (Criteria) this;
        }

        public Criteria andTaskCheckContentsNotLike(String value) {
            addCriterion("task_check_contents not like", value, "taskCheckContents");
            return (Criteria) this;
        }

        public Criteria andTaskCheckContentsIn(List<String> values) {
            addCriterion("task_check_contents in", values, "taskCheckContents");
            return (Criteria) this;
        }

        public Criteria andTaskCheckContentsNotIn(List<String> values) {
            addCriterion("task_check_contents not in", values, "taskCheckContents");
            return (Criteria) this;
        }

        public Criteria andTaskCheckContentsBetween(String value1, String value2) {
            addCriterion("task_check_contents between", value1, value2, "taskCheckContents");
            return (Criteria) this;
        }

        public Criteria andTaskCheckContentsNotBetween(String value1, String value2) {
            addCriterion("task_check_contents not between", value1, value2, "taskCheckContents");
            return (Criteria) this;
        }

        public Criteria andTaskDocIsNull() {
            addCriterion("task_doc is null");
            return (Criteria) this;
        }

        public Criteria andTaskDocIsNotNull() {
            addCriterion("task_doc is not null");
            return (Criteria) this;
        }

        public Criteria andTaskDocEqualTo(String value) {
            addCriterion("task_doc =", value, "taskDoc");
            return (Criteria) this;
        }

        public Criteria andTaskDocNotEqualTo(String value) {
            addCriterion("task_doc <>", value, "taskDoc");
            return (Criteria) this;
        }

        public Criteria andTaskDocGreaterThan(String value) {
            addCriterion("task_doc >", value, "taskDoc");
            return (Criteria) this;
        }

        public Criteria andTaskDocGreaterThanOrEqualTo(String value) {
            addCriterion("task_doc >=", value, "taskDoc");
            return (Criteria) this;
        }

        public Criteria andTaskDocLessThan(String value) {
            addCriterion("task_doc <", value, "taskDoc");
            return (Criteria) this;
        }

        public Criteria andTaskDocLessThanOrEqualTo(String value) {
            addCriterion("task_doc <=", value, "taskDoc");
            return (Criteria) this;
        }

        public Criteria andTaskDocLike(String value) {
            addCriterion("task_doc like", value, "taskDoc");
            return (Criteria) this;
        }

        public Criteria andTaskDocNotLike(String value) {
            addCriterion("task_doc not like", value, "taskDoc");
            return (Criteria) this;
        }

        public Criteria andTaskDocIn(List<String> values) {
            addCriterion("task_doc in", values, "taskDoc");
            return (Criteria) this;
        }

        public Criteria andTaskDocNotIn(List<String> values) {
            addCriterion("task_doc not in", values, "taskDoc");
            return (Criteria) this;
        }

        public Criteria andTaskDocBetween(String value1, String value2) {
            addCriterion("task_doc between", value1, value2, "taskDoc");
            return (Criteria) this;
        }

        public Criteria andTaskDocNotBetween(String value1, String value2) {
            addCriterion("task_doc not between", value1, value2, "taskDoc");
            return (Criteria) this;
        }

        public Criteria andCheckContentNameIsNull() {
            addCriterion("check_content_name is null");
            return (Criteria) this;
        }

        public Criteria andCheckContentNameIsNotNull() {
            addCriterion("check_content_name is not null");
            return (Criteria) this;
        }

        public Criteria andCheckContentNameEqualTo(String value) {
            addCriterion("check_content_name =", value, "checkContentName");
            return (Criteria) this;
        }

        public Criteria andCheckContentNameNotEqualTo(String value) {
            addCriterion("check_content_name <>", value, "checkContentName");
            return (Criteria) this;
        }

        public Criteria andCheckContentNameGreaterThan(String value) {
            addCriterion("check_content_name >", value, "checkContentName");
            return (Criteria) this;
        }

        public Criteria andCheckContentNameGreaterThanOrEqualTo(String value) {
            addCriterion("check_content_name >=", value, "checkContentName");
            return (Criteria) this;
        }

        public Criteria andCheckContentNameLessThan(String value) {
            addCriterion("check_content_name <", value, "checkContentName");
            return (Criteria) this;
        }

        public Criteria andCheckContentNameLessThanOrEqualTo(String value) {
            addCriterion("check_content_name <=", value, "checkContentName");
            return (Criteria) this;
        }

        public Criteria andCheckContentNameLike(String value) {
            addCriterion("check_content_name like", value, "checkContentName");
            return (Criteria) this;
        }

        public Criteria andCheckContentNameNotLike(String value) {
            addCriterion("check_content_name not like", value, "checkContentName");
            return (Criteria) this;
        }

        public Criteria andCheckContentNameIn(List<String> values) {
            addCriterion("check_content_name in", values, "checkContentName");
            return (Criteria) this;
        }

        public Criteria andCheckContentNameNotIn(List<String> values) {
            addCriterion("check_content_name not in", values, "checkContentName");
            return (Criteria) this;
        }

        public Criteria andCheckContentNameBetween(String value1, String value2) {
            addCriterion("check_content_name between", value1, value2, "checkContentName");
            return (Criteria) this;
        }

        public Criteria andCheckContentNameNotBetween(String value1, String value2) {
            addCriterion("check_content_name not between", value1, value2, "checkContentName");
            return (Criteria) this;
        }

        public Criteria andCheckContentDocIsNull() {
            addCriterion("check_content_doc is null");
            return (Criteria) this;
        }

        public Criteria andCheckContentDocIsNotNull() {
            addCriterion("check_content_doc is not null");
            return (Criteria) this;
        }

        public Criteria andCheckContentDocEqualTo(String value) {
            addCriterion("check_content_doc =", value, "checkContentDoc");
            return (Criteria) this;
        }

        public Criteria andCheckContentDocNotEqualTo(String value) {
            addCriterion("check_content_doc <>", value, "checkContentDoc");
            return (Criteria) this;
        }

        public Criteria andCheckContentDocGreaterThan(String value) {
            addCriterion("check_content_doc >", value, "checkContentDoc");
            return (Criteria) this;
        }

        public Criteria andCheckContentDocGreaterThanOrEqualTo(String value) {
            addCriterion("check_content_doc >=", value, "checkContentDoc");
            return (Criteria) this;
        }

        public Criteria andCheckContentDocLessThan(String value) {
            addCriterion("check_content_doc <", value, "checkContentDoc");
            return (Criteria) this;
        }

        public Criteria andCheckContentDocLessThanOrEqualTo(String value) {
            addCriterion("check_content_doc <=", value, "checkContentDoc");
            return (Criteria) this;
        }

        public Criteria andCheckContentDocLike(String value) {
            addCriterion("check_content_doc like", value, "checkContentDoc");
            return (Criteria) this;
        }

        public Criteria andCheckContentDocNotLike(String value) {
            addCriterion("check_content_doc not like", value, "checkContentDoc");
            return (Criteria) this;
        }

        public Criteria andCheckContentDocIn(List<String> values) {
            addCriterion("check_content_doc in", values, "checkContentDoc");
            return (Criteria) this;
        }

        public Criteria andCheckContentDocNotIn(List<String> values) {
            addCriterion("check_content_doc not in", values, "checkContentDoc");
            return (Criteria) this;
        }

        public Criteria andCheckContentDocBetween(String value1, String value2) {
            addCriterion("check_content_doc between", value1, value2, "checkContentDoc");
            return (Criteria) this;
        }

        public Criteria andCheckContentDocNotBetween(String value1, String value2) {
            addCriterion("check_content_doc not between", value1, value2, "checkContentDoc");
            return (Criteria) this;
        }

        public Criteria andCheckUserIsNull() {
            addCriterion("check_user is null");
            return (Criteria) this;
        }

        public Criteria andCheckUserIsNotNull() {
            addCriterion("check_user is not null");
            return (Criteria) this;
        }

        public Criteria andCheckUserEqualTo(String value) {
            addCriterion("check_user =", value, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserNotEqualTo(String value) {
            addCriterion("check_user <>", value, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserGreaterThan(String value) {
            addCriterion("check_user >", value, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserGreaterThanOrEqualTo(String value) {
            addCriterion("check_user >=", value, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserLessThan(String value) {
            addCriterion("check_user <", value, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserLessThanOrEqualTo(String value) {
            addCriterion("check_user <=", value, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserLike(String value) {
            addCriterion("check_user like", value, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserNotLike(String value) {
            addCriterion("check_user not like", value, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserIn(List<String> values) {
            addCriterion("check_user in", values, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserNotIn(List<String> values) {
            addCriterion("check_user not in", values, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserBetween(String value1, String value2) {
            addCriterion("check_user between", value1, value2, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserNotBetween(String value1, String value2) {
            addCriterion("check_user not between", value1, value2, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckDateIsNull() {
            addCriterion("check_date is null");
            return (Criteria) this;
        }

        public Criteria andCheckDateIsNotNull() {
            addCriterion("check_date is not null");
            return (Criteria) this;
        }

        public Criteria andCheckDateEqualTo(Date value) {
            addCriterion("check_date =", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateNotEqualTo(Date value) {
            addCriterion("check_date <>", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateGreaterThan(Date value) {
            addCriterion("check_date >", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateGreaterThanOrEqualTo(Date value) {
            addCriterion("check_date >=", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateLessThan(Date value) {
            addCriterion("check_date <", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateLessThanOrEqualTo(Date value) {
            addCriterion("check_date <=", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateIn(List<Date> values) {
            addCriterion("check_date in", values, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateNotIn(List<Date> values) {
            addCriterion("check_date not in", values, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateBetween(Date value1, Date value2) {
            addCriterion("check_date between", value1, value2, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateNotBetween(Date value1, Date value2) {
            addCriterion("check_date not between", value1, value2, "checkDate");
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