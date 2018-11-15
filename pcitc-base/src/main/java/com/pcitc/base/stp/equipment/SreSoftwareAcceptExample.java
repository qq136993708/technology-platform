package com.pcitc.base.stp.equipment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SreSoftwareAcceptExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SreSoftwareAcceptExample() {
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

        public Criteria andSoftwareIdIsNull() {
            addCriterion("software_id is null");
            return (Criteria) this;
        }

        public Criteria andSoftwareIdIsNotNull() {
            addCriterion("software_id is not null");
            return (Criteria) this;
        }

        public Criteria andSoftwareIdEqualTo(String value) {
            addCriterion("software_id =", value, "softwareId");
            return (Criteria) this;
        }

        public Criteria andSoftwareIdNotEqualTo(String value) {
            addCriterion("software_id <>", value, "softwareId");
            return (Criteria) this;
        }

        public Criteria andSoftwareIdGreaterThan(String value) {
            addCriterion("software_id >", value, "softwareId");
            return (Criteria) this;
        }

        public Criteria andSoftwareIdGreaterThanOrEqualTo(String value) {
            addCriterion("software_id >=", value, "softwareId");
            return (Criteria) this;
        }

        public Criteria andSoftwareIdLessThan(String value) {
            addCriterion("software_id <", value, "softwareId");
            return (Criteria) this;
        }

        public Criteria andSoftwareIdLessThanOrEqualTo(String value) {
            addCriterion("software_id <=", value, "softwareId");
            return (Criteria) this;
        }

        public Criteria andSoftwareIdLike(String value) {
            addCriterion("software_id like", value, "softwareId");
            return (Criteria) this;
        }

        public Criteria andSoftwareIdNotLike(String value) {
            addCriterion("software_id not like", value, "softwareId");
            return (Criteria) this;
        }

        public Criteria andSoftwareIdIn(List<String> values) {
            addCriterion("software_id in", values, "softwareId");
            return (Criteria) this;
        }

        public Criteria andSoftwareIdNotIn(List<String> values) {
            addCriterion("software_id not in", values, "softwareId");
            return (Criteria) this;
        }

        public Criteria andSoftwareIdBetween(String value1, String value2) {
            addCriterion("software_id between", value1, value2, "softwareId");
            return (Criteria) this;
        }

        public Criteria andSoftwareIdNotBetween(String value1, String value2) {
            addCriterion("software_id not between", value1, value2, "softwareId");
            return (Criteria) this;
        }

        public Criteria andSoftwareCodeIsNull() {
            addCriterion("software_code is null");
            return (Criteria) this;
        }

        public Criteria andSoftwareCodeIsNotNull() {
            addCriterion("software_code is not null");
            return (Criteria) this;
        }

        public Criteria andSoftwareCodeEqualTo(String value) {
            addCriterion("software_code =", value, "softwareCode");
            return (Criteria) this;
        }

        public Criteria andSoftwareCodeNotEqualTo(String value) {
            addCriterion("software_code <>", value, "softwareCode");
            return (Criteria) this;
        }

        public Criteria andSoftwareCodeGreaterThan(String value) {
            addCriterion("software_code >", value, "softwareCode");
            return (Criteria) this;
        }

        public Criteria andSoftwareCodeGreaterThanOrEqualTo(String value) {
            addCriterion("software_code >=", value, "softwareCode");
            return (Criteria) this;
        }

        public Criteria andSoftwareCodeLessThan(String value) {
            addCriterion("software_code <", value, "softwareCode");
            return (Criteria) this;
        }

        public Criteria andSoftwareCodeLessThanOrEqualTo(String value) {
            addCriterion("software_code <=", value, "softwareCode");
            return (Criteria) this;
        }

        public Criteria andSoftwareCodeLike(String value) {
            addCriterion("software_code like", value, "softwareCode");
            return (Criteria) this;
        }

        public Criteria andSoftwareCodeNotLike(String value) {
            addCriterion("software_code not like", value, "softwareCode");
            return (Criteria) this;
        }

        public Criteria andSoftwareCodeIn(List<String> values) {
            addCriterion("software_code in", values, "softwareCode");
            return (Criteria) this;
        }

        public Criteria andSoftwareCodeNotIn(List<String> values) {
            addCriterion("software_code not in", values, "softwareCode");
            return (Criteria) this;
        }

        public Criteria andSoftwareCodeBetween(String value1, String value2) {
            addCriterion("software_code between", value1, value2, "softwareCode");
            return (Criteria) this;
        }

        public Criteria andSoftwareCodeNotBetween(String value1, String value2) {
            addCriterion("software_code not between", value1, value2, "softwareCode");
            return (Criteria) this;
        }

        public Criteria andInstallPlaceIsNull() {
            addCriterion("install_place is null");
            return (Criteria) this;
        }

        public Criteria andInstallPlaceIsNotNull() {
            addCriterion("install_place is not null");
            return (Criteria) this;
        }

        public Criteria andInstallPlaceEqualTo(String value) {
            addCriterion("install_place =", value, "installPlace");
            return (Criteria) this;
        }

        public Criteria andInstallPlaceNotEqualTo(String value) {
            addCriterion("install_place <>", value, "installPlace");
            return (Criteria) this;
        }

        public Criteria andInstallPlaceGreaterThan(String value) {
            addCriterion("install_place >", value, "installPlace");
            return (Criteria) this;
        }

        public Criteria andInstallPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("install_place >=", value, "installPlace");
            return (Criteria) this;
        }

        public Criteria andInstallPlaceLessThan(String value) {
            addCriterion("install_place <", value, "installPlace");
            return (Criteria) this;
        }

        public Criteria andInstallPlaceLessThanOrEqualTo(String value) {
            addCriterion("install_place <=", value, "installPlace");
            return (Criteria) this;
        }

        public Criteria andInstallPlaceLike(String value) {
            addCriterion("install_place like", value, "installPlace");
            return (Criteria) this;
        }

        public Criteria andInstallPlaceNotLike(String value) {
            addCriterion("install_place not like", value, "installPlace");
            return (Criteria) this;
        }

        public Criteria andInstallPlaceIn(List<String> values) {
            addCriterion("install_place in", values, "installPlace");
            return (Criteria) this;
        }

        public Criteria andInstallPlaceNotIn(List<String> values) {
            addCriterion("install_place not in", values, "installPlace");
            return (Criteria) this;
        }

        public Criteria andInstallPlaceBetween(String value1, String value2) {
            addCriterion("install_place between", value1, value2, "installPlace");
            return (Criteria) this;
        }

        public Criteria andInstallPlaceNotBetween(String value1, String value2) {
            addCriterion("install_place not between", value1, value2, "installPlace");
            return (Criteria) this;
        }

        public Criteria andSoftwareEnvironmentIsNull() {
            addCriterion("software_environment is null");
            return (Criteria) this;
        }

        public Criteria andSoftwareEnvironmentIsNotNull() {
            addCriterion("software_environment is not null");
            return (Criteria) this;
        }

        public Criteria andSoftwareEnvironmentEqualTo(String value) {
            addCriterion("software_environment =", value, "softwareEnvironment");
            return (Criteria) this;
        }

        public Criteria andSoftwareEnvironmentNotEqualTo(String value) {
            addCriterion("software_environment <>", value, "softwareEnvironment");
            return (Criteria) this;
        }

        public Criteria andSoftwareEnvironmentGreaterThan(String value) {
            addCriterion("software_environment >", value, "softwareEnvironment");
            return (Criteria) this;
        }

        public Criteria andSoftwareEnvironmentGreaterThanOrEqualTo(String value) {
            addCriterion("software_environment >=", value, "softwareEnvironment");
            return (Criteria) this;
        }

        public Criteria andSoftwareEnvironmentLessThan(String value) {
            addCriterion("software_environment <", value, "softwareEnvironment");
            return (Criteria) this;
        }

        public Criteria andSoftwareEnvironmentLessThanOrEqualTo(String value) {
            addCriterion("software_environment <=", value, "softwareEnvironment");
            return (Criteria) this;
        }

        public Criteria andSoftwareEnvironmentLike(String value) {
            addCriterion("software_environment like", value, "softwareEnvironment");
            return (Criteria) this;
        }

        public Criteria andSoftwareEnvironmentNotLike(String value) {
            addCriterion("software_environment not like", value, "softwareEnvironment");
            return (Criteria) this;
        }

        public Criteria andSoftwareEnvironmentIn(List<String> values) {
            addCriterion("software_environment in", values, "softwareEnvironment");
            return (Criteria) this;
        }

        public Criteria andSoftwareEnvironmentNotIn(List<String> values) {
            addCriterion("software_environment not in", values, "softwareEnvironment");
            return (Criteria) this;
        }

        public Criteria andSoftwareEnvironmentBetween(String value1, String value2) {
            addCriterion("software_environment between", value1, value2, "softwareEnvironment");
            return (Criteria) this;
        }

        public Criteria andSoftwareEnvironmentNotBetween(String value1, String value2) {
            addCriterion("software_environment not between", value1, value2, "softwareEnvironment");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoIsNull() {
            addCriterion("equipment_no is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoIsNotNull() {
            addCriterion("equipment_no is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoEqualTo(String value) {
            addCriterion("equipment_no =", value, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoNotEqualTo(String value) {
            addCriterion("equipment_no <>", value, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoGreaterThan(String value) {
            addCriterion("equipment_no >", value, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_no >=", value, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoLessThan(String value) {
            addCriterion("equipment_no <", value, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoLessThanOrEqualTo(String value) {
            addCriterion("equipment_no <=", value, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoLike(String value) {
            addCriterion("equipment_no like", value, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoNotLike(String value) {
            addCriterion("equipment_no not like", value, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoIn(List<String> values) {
            addCriterion("equipment_no in", values, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoNotIn(List<String> values) {
            addCriterion("equipment_no not in", values, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoBetween(String value1, String value2) {
            addCriterion("equipment_no between", value1, value2, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoNotBetween(String value1, String value2) {
            addCriterion("equipment_no not between", value1, value2, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andSoftSituationIsNull() {
            addCriterion("soft_situation is null");
            return (Criteria) this;
        }

        public Criteria andSoftSituationIsNotNull() {
            addCriterion("soft_situation is not null");
            return (Criteria) this;
        }

        public Criteria andSoftSituationEqualTo(String value) {
            addCriterion("soft_situation =", value, "softSituation");
            return (Criteria) this;
        }

        public Criteria andSoftSituationNotEqualTo(String value) {
            addCriterion("soft_situation <>", value, "softSituation");
            return (Criteria) this;
        }

        public Criteria andSoftSituationGreaterThan(String value) {
            addCriterion("soft_situation >", value, "softSituation");
            return (Criteria) this;
        }

        public Criteria andSoftSituationGreaterThanOrEqualTo(String value) {
            addCriterion("soft_situation >=", value, "softSituation");
            return (Criteria) this;
        }

        public Criteria andSoftSituationLessThan(String value) {
            addCriterion("soft_situation <", value, "softSituation");
            return (Criteria) this;
        }

        public Criteria andSoftSituationLessThanOrEqualTo(String value) {
            addCriterion("soft_situation <=", value, "softSituation");
            return (Criteria) this;
        }

        public Criteria andSoftSituationLike(String value) {
            addCriterion("soft_situation like", value, "softSituation");
            return (Criteria) this;
        }

        public Criteria andSoftSituationNotLike(String value) {
            addCriterion("soft_situation not like", value, "softSituation");
            return (Criteria) this;
        }

        public Criteria andSoftSituationIn(List<String> values) {
            addCriterion("soft_situation in", values, "softSituation");
            return (Criteria) this;
        }

        public Criteria andSoftSituationNotIn(List<String> values) {
            addCriterion("soft_situation not in", values, "softSituation");
            return (Criteria) this;
        }

        public Criteria andSoftSituationBetween(String value1, String value2) {
            addCriterion("soft_situation between", value1, value2, "softSituation");
            return (Criteria) this;
        }

        public Criteria andSoftSituationNotBetween(String value1, String value2) {
            addCriterion("soft_situation not between", value1, value2, "softSituation");
            return (Criteria) this;
        }

        public Criteria andInstallTimeIsNull() {
            addCriterion("install_time is null");
            return (Criteria) this;
        }

        public Criteria andInstallTimeIsNotNull() {
            addCriterion("install_time is not null");
            return (Criteria) this;
        }

        public Criteria andInstallTimeEqualTo(Date value) {
            addCriterion("install_time =", value, "installTime");
            return (Criteria) this;
        }

        public Criteria andInstallTimeNotEqualTo(Date value) {
            addCriterion("install_time <>", value, "installTime");
            return (Criteria) this;
        }

        public Criteria andInstallTimeGreaterThan(Date value) {
            addCriterion("install_time >", value, "installTime");
            return (Criteria) this;
        }

        public Criteria andInstallTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("install_time >=", value, "installTime");
            return (Criteria) this;
        }

        public Criteria andInstallTimeLessThan(Date value) {
            addCriterion("install_time <", value, "installTime");
            return (Criteria) this;
        }

        public Criteria andInstallTimeLessThanOrEqualTo(Date value) {
            addCriterion("install_time <=", value, "installTime");
            return (Criteria) this;
        }

        public Criteria andInstallTimeIn(List<Date> values) {
            addCriterion("install_time in", values, "installTime");
            return (Criteria) this;
        }

        public Criteria andInstallTimeNotIn(List<Date> values) {
            addCriterion("install_time not in", values, "installTime");
            return (Criteria) this;
        }

        public Criteria andInstallTimeBetween(Date value1, Date value2) {
            addCriterion("install_time between", value1, value2, "installTime");
            return (Criteria) this;
        }

        public Criteria andInstallTimeNotBetween(Date value1, Date value2) {
            addCriterion("install_time not between", value1, value2, "installTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeIsNull() {
            addCriterion("accept_time is null");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeIsNotNull() {
            addCriterion("accept_time is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeEqualTo(Date value) {
            addCriterion("accept_time =", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeNotEqualTo(Date value) {
            addCriterion("accept_time <>", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeGreaterThan(Date value) {
            addCriterion("accept_time >", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("accept_time >=", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeLessThan(Date value) {
            addCriterion("accept_time <", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeLessThanOrEqualTo(Date value) {
            addCriterion("accept_time <=", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeIn(List<Date> values) {
            addCriterion("accept_time in", values, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeNotIn(List<Date> values) {
            addCriterion("accept_time not in", values, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeBetween(Date value1, Date value2) {
            addCriterion("accept_time between", value1, value2, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeNotBetween(Date value1, Date value2) {
            addCriterion("accept_time not between", value1, value2, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andEquipmentUseIsNull() {
            addCriterion("equipment_use is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentUseIsNotNull() {
            addCriterion("equipment_use is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentUseEqualTo(String value) {
            addCriterion("equipment_use =", value, "equipmentUse");
            return (Criteria) this;
        }

        public Criteria andEquipmentUseNotEqualTo(String value) {
            addCriterion("equipment_use <>", value, "equipmentUse");
            return (Criteria) this;
        }

        public Criteria andEquipmentUseGreaterThan(String value) {
            addCriterion("equipment_use >", value, "equipmentUse");
            return (Criteria) this;
        }

        public Criteria andEquipmentUseGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_use >=", value, "equipmentUse");
            return (Criteria) this;
        }

        public Criteria andEquipmentUseLessThan(String value) {
            addCriterion("equipment_use <", value, "equipmentUse");
            return (Criteria) this;
        }

        public Criteria andEquipmentUseLessThanOrEqualTo(String value) {
            addCriterion("equipment_use <=", value, "equipmentUse");
            return (Criteria) this;
        }

        public Criteria andEquipmentUseLike(String value) {
            addCriterion("equipment_use like", value, "equipmentUse");
            return (Criteria) this;
        }

        public Criteria andEquipmentUseNotLike(String value) {
            addCriterion("equipment_use not like", value, "equipmentUse");
            return (Criteria) this;
        }

        public Criteria andEquipmentUseIn(List<String> values) {
            addCriterion("equipment_use in", values, "equipmentUse");
            return (Criteria) this;
        }

        public Criteria andEquipmentUseNotIn(List<String> values) {
            addCriterion("equipment_use not in", values, "equipmentUse");
            return (Criteria) this;
        }

        public Criteria andEquipmentUseBetween(String value1, String value2) {
            addCriterion("equipment_use between", value1, value2, "equipmentUse");
            return (Criteria) this;
        }

        public Criteria andEquipmentUseNotBetween(String value1, String value2) {
            addCriterion("equipment_use not between", value1, value2, "equipmentUse");
            return (Criteria) this;
        }

        public Criteria andSoftWareCountIsNull() {
            addCriterion("soft_ware_count is null");
            return (Criteria) this;
        }

        public Criteria andSoftWareCountIsNotNull() {
            addCriterion("soft_ware_count is not null");
            return (Criteria) this;
        }

        public Criteria andSoftWareCountEqualTo(Integer value) {
            addCriterion("soft_ware_count =", value, "softWareCount");
            return (Criteria) this;
        }

        public Criteria andSoftWareCountNotEqualTo(Integer value) {
            addCriterion("soft_ware_count <>", value, "softWareCount");
            return (Criteria) this;
        }

        public Criteria andSoftWareCountGreaterThan(Integer value) {
            addCriterion("soft_ware_count >", value, "softWareCount");
            return (Criteria) this;
        }

        public Criteria andSoftWareCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("soft_ware_count >=", value, "softWareCount");
            return (Criteria) this;
        }

        public Criteria andSoftWareCountLessThan(Integer value) {
            addCriterion("soft_ware_count <", value, "softWareCount");
            return (Criteria) this;
        }

        public Criteria andSoftWareCountLessThanOrEqualTo(Integer value) {
            addCriterion("soft_ware_count <=", value, "softWareCount");
            return (Criteria) this;
        }

        public Criteria andSoftWareCountIn(List<Integer> values) {
            addCriterion("soft_ware_count in", values, "softWareCount");
            return (Criteria) this;
        }

        public Criteria andSoftWareCountNotIn(List<Integer> values) {
            addCriterion("soft_ware_count not in", values, "softWareCount");
            return (Criteria) this;
        }

        public Criteria andSoftWareCountBetween(Integer value1, Integer value2) {
            addCriterion("soft_ware_count between", value1, value2, "softWareCount");
            return (Criteria) this;
        }

        public Criteria andSoftWareCountNotBetween(Integer value1, Integer value2) {
            addCriterion("soft_ware_count not between", value1, value2, "softWareCount");
            return (Criteria) this;
        }

        public Criteria andSoftMediaCountIsNull() {
            addCriterion("soft_media_count is null");
            return (Criteria) this;
        }

        public Criteria andSoftMediaCountIsNotNull() {
            addCriterion("soft_media_count is not null");
            return (Criteria) this;
        }

        public Criteria andSoftMediaCountEqualTo(Integer value) {
            addCriterion("soft_media_count =", value, "softMediaCount");
            return (Criteria) this;
        }

        public Criteria andSoftMediaCountNotEqualTo(Integer value) {
            addCriterion("soft_media_count <>", value, "softMediaCount");
            return (Criteria) this;
        }

        public Criteria andSoftMediaCountGreaterThan(Integer value) {
            addCriterion("soft_media_count >", value, "softMediaCount");
            return (Criteria) this;
        }

        public Criteria andSoftMediaCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("soft_media_count >=", value, "softMediaCount");
            return (Criteria) this;
        }

        public Criteria andSoftMediaCountLessThan(Integer value) {
            addCriterion("soft_media_count <", value, "softMediaCount");
            return (Criteria) this;
        }

        public Criteria andSoftMediaCountLessThanOrEqualTo(Integer value) {
            addCriterion("soft_media_count <=", value, "softMediaCount");
            return (Criteria) this;
        }

        public Criteria andSoftMediaCountIn(List<Integer> values) {
            addCriterion("soft_media_count in", values, "softMediaCount");
            return (Criteria) this;
        }

        public Criteria andSoftMediaCountNotIn(List<Integer> values) {
            addCriterion("soft_media_count not in", values, "softMediaCount");
            return (Criteria) this;
        }

        public Criteria andSoftMediaCountBetween(Integer value1, Integer value2) {
            addCriterion("soft_media_count between", value1, value2, "softMediaCount");
            return (Criteria) this;
        }

        public Criteria andSoftMediaCountNotBetween(Integer value1, Integer value2) {
            addCriterion("soft_media_count not between", value1, value2, "softMediaCount");
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

        public Criteria andEquipmentIdIsNull() {
            addCriterion("equipment_id is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdIsNotNull() {
            addCriterion("equipment_id is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdEqualTo(String value) {
            addCriterion("equipment_id =", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotEqualTo(String value) {
            addCriterion("equipment_id <>", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdGreaterThan(String value) {
            addCriterion("equipment_id >", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_id >=", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdLessThan(String value) {
            addCriterion("equipment_id <", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdLessThanOrEqualTo(String value) {
            addCriterion("equipment_id <=", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdLike(String value) {
            addCriterion("equipment_id like", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotLike(String value) {
            addCriterion("equipment_id not like", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdIn(List<String> values) {
            addCriterion("equipment_id in", values, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotIn(List<String> values) {
            addCriterion("equipment_id not in", values, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdBetween(String value1, String value2) {
            addCriterion("equipment_id between", value1, value2, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotBetween(String value1, String value2) {
            addCriterion("equipment_id not between", value1, value2, "equipmentId");
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