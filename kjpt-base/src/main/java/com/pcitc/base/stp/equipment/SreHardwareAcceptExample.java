package com.pcitc.base.stp.equipment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SreHardwareAcceptExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SreHardwareAcceptExample() {
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

        public Criteria andHardwareIdIsNull() {
            addCriterion("hardware_id is null");
            return (Criteria) this;
        }

        public Criteria andHardwareIdIsNotNull() {
            addCriterion("hardware_id is not null");
            return (Criteria) this;
        }

        public Criteria andHardwareIdEqualTo(String value) {
            addCriterion("hardware_id =", value, "hardwareId");
            return (Criteria) this;
        }

        public Criteria andHardwareIdNotEqualTo(String value) {
            addCriterion("hardware_id <>", value, "hardwareId");
            return (Criteria) this;
        }

        public Criteria andHardwareIdGreaterThan(String value) {
            addCriterion("hardware_id >", value, "hardwareId");
            return (Criteria) this;
        }

        public Criteria andHardwareIdGreaterThanOrEqualTo(String value) {
            addCriterion("hardware_id >=", value, "hardwareId");
            return (Criteria) this;
        }

        public Criteria andHardwareIdLessThan(String value) {
            addCriterion("hardware_id <", value, "hardwareId");
            return (Criteria) this;
        }

        public Criteria andHardwareIdLessThanOrEqualTo(String value) {
            addCriterion("hardware_id <=", value, "hardwareId");
            return (Criteria) this;
        }

        public Criteria andHardwareIdLike(String value) {
            addCriterion("hardware_id like", value, "hardwareId");
            return (Criteria) this;
        }

        public Criteria andHardwareIdNotLike(String value) {
            addCriterion("hardware_id not like", value, "hardwareId");
            return (Criteria) this;
        }

        public Criteria andHardwareIdIn(List<String> values) {
            addCriterion("hardware_id in", values, "hardwareId");
            return (Criteria) this;
        }

        public Criteria andHardwareIdNotIn(List<String> values) {
            addCriterion("hardware_id not in", values, "hardwareId");
            return (Criteria) this;
        }

        public Criteria andHardwareIdBetween(String value1, String value2) {
            addCriterion("hardware_id between", value1, value2, "hardwareId");
            return (Criteria) this;
        }

        public Criteria andHardwareIdNotBetween(String value1, String value2) {
            addCriterion("hardware_id not between", value1, value2, "hardwareId");
            return (Criteria) this;
        }

        public Criteria andHardwareCodeIsNull() {
            addCriterion("hardware_code is null");
            return (Criteria) this;
        }

        public Criteria andHardwareCodeIsNotNull() {
            addCriterion("hardware_code is not null");
            return (Criteria) this;
        }

        public Criteria andHardwareCodeEqualTo(String value) {
            addCriterion("hardware_code =", value, "hardwareCode");
            return (Criteria) this;
        }

        public Criteria andHardwareCodeNotEqualTo(String value) {
            addCriterion("hardware_code <>", value, "hardwareCode");
            return (Criteria) this;
        }

        public Criteria andHardwareCodeGreaterThan(String value) {
            addCriterion("hardware_code >", value, "hardwareCode");
            return (Criteria) this;
        }

        public Criteria andHardwareCodeGreaterThanOrEqualTo(String value) {
            addCriterion("hardware_code >=", value, "hardwareCode");
            return (Criteria) this;
        }

        public Criteria andHardwareCodeLessThan(String value) {
            addCriterion("hardware_code <", value, "hardwareCode");
            return (Criteria) this;
        }

        public Criteria andHardwareCodeLessThanOrEqualTo(String value) {
            addCriterion("hardware_code <=", value, "hardwareCode");
            return (Criteria) this;
        }

        public Criteria andHardwareCodeLike(String value) {
            addCriterion("hardware_code like", value, "hardwareCode");
            return (Criteria) this;
        }

        public Criteria andHardwareCodeNotLike(String value) {
            addCriterion("hardware_code not like", value, "hardwareCode");
            return (Criteria) this;
        }

        public Criteria andHardwareCodeIn(List<String> values) {
            addCriterion("hardware_code in", values, "hardwareCode");
            return (Criteria) this;
        }

        public Criteria andHardwareCodeNotIn(List<String> values) {
            addCriterion("hardware_code not in", values, "hardwareCode");
            return (Criteria) this;
        }

        public Criteria andHardwareCodeBetween(String value1, String value2) {
            addCriterion("hardware_code between", value1, value2, "hardwareCode");
            return (Criteria) this;
        }

        public Criteria andHardwareCodeNotBetween(String value1, String value2) {
            addCriterion("hardware_code not between", value1, value2, "hardwareCode");
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

        public Criteria andPackingDetailsIsNull() {
            addCriterion("packing_details is null");
            return (Criteria) this;
        }

        public Criteria andPackingDetailsIsNotNull() {
            addCriterion("packing_details is not null");
            return (Criteria) this;
        }

        public Criteria andPackingDetailsEqualTo(String value) {
            addCriterion("packing_details =", value, "packingDetails");
            return (Criteria) this;
        }

        public Criteria andPackingDetailsNotEqualTo(String value) {
            addCriterion("packing_details <>", value, "packingDetails");
            return (Criteria) this;
        }

        public Criteria andPackingDetailsGreaterThan(String value) {
            addCriterion("packing_details >", value, "packingDetails");
            return (Criteria) this;
        }

        public Criteria andPackingDetailsGreaterThanOrEqualTo(String value) {
            addCriterion("packing_details >=", value, "packingDetails");
            return (Criteria) this;
        }

        public Criteria andPackingDetailsLessThan(String value) {
            addCriterion("packing_details <", value, "packingDetails");
            return (Criteria) this;
        }

        public Criteria andPackingDetailsLessThanOrEqualTo(String value) {
            addCriterion("packing_details <=", value, "packingDetails");
            return (Criteria) this;
        }

        public Criteria andPackingDetailsLike(String value) {
            addCriterion("packing_details like", value, "packingDetails");
            return (Criteria) this;
        }

        public Criteria andPackingDetailsNotLike(String value) {
            addCriterion("packing_details not like", value, "packingDetails");
            return (Criteria) this;
        }

        public Criteria andPackingDetailsIn(List<String> values) {
            addCriterion("packing_details in", values, "packingDetails");
            return (Criteria) this;
        }

        public Criteria andPackingDetailsNotIn(List<String> values) {
            addCriterion("packing_details not in", values, "packingDetails");
            return (Criteria) this;
        }

        public Criteria andPackingDetailsBetween(String value1, String value2) {
            addCriterion("packing_details between", value1, value2, "packingDetails");
            return (Criteria) this;
        }

        public Criteria andPackingDetailsNotBetween(String value1, String value2) {
            addCriterion("packing_details not between", value1, value2, "packingDetails");
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

        public Criteria andAcceptStatusIsNull() {
            addCriterion("accept_status is null");
            return (Criteria) this;
        }

        public Criteria andAcceptStatusIsNotNull() {
            addCriterion("accept_status is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptStatusEqualTo(String value) {
            addCriterion("accept_status =", value, "acceptStatus");
            return (Criteria) this;
        }

        public Criteria andAcceptStatusNotEqualTo(String value) {
            addCriterion("accept_status <>", value, "acceptStatus");
            return (Criteria) this;
        }

        public Criteria andAcceptStatusGreaterThan(String value) {
            addCriterion("accept_status >", value, "acceptStatus");
            return (Criteria) this;
        }

        public Criteria andAcceptStatusGreaterThanOrEqualTo(String value) {
            addCriterion("accept_status >=", value, "acceptStatus");
            return (Criteria) this;
        }

        public Criteria andAcceptStatusLessThan(String value) {
            addCriterion("accept_status <", value, "acceptStatus");
            return (Criteria) this;
        }

        public Criteria andAcceptStatusLessThanOrEqualTo(String value) {
            addCriterion("accept_status <=", value, "acceptStatus");
            return (Criteria) this;
        }

        public Criteria andAcceptStatusLike(String value) {
            addCriterion("accept_status like", value, "acceptStatus");
            return (Criteria) this;
        }

        public Criteria andAcceptStatusNotLike(String value) {
            addCriterion("accept_status not like", value, "acceptStatus");
            return (Criteria) this;
        }

        public Criteria andAcceptStatusIn(List<String> values) {
            addCriterion("accept_status in", values, "acceptStatus");
            return (Criteria) this;
        }

        public Criteria andAcceptStatusNotIn(List<String> values) {
            addCriterion("accept_status not in", values, "acceptStatus");
            return (Criteria) this;
        }

        public Criteria andAcceptStatusBetween(String value1, String value2) {
            addCriterion("accept_status between", value1, value2, "acceptStatus");
            return (Criteria) this;
        }

        public Criteria andAcceptStatusNotBetween(String value1, String value2) {
            addCriterion("accept_status not between", value1, value2, "acceptStatus");
            return (Criteria) this;
        }

        public Criteria andOutFactoryNoIsNull() {
            addCriterion("out_factory_no is null");
            return (Criteria) this;
        }

        public Criteria andOutFactoryNoIsNotNull() {
            addCriterion("out_factory_no is not null");
            return (Criteria) this;
        }

        public Criteria andOutFactoryNoEqualTo(String value) {
            addCriterion("out_factory_no =", value, "outFactoryNo");
            return (Criteria) this;
        }

        public Criteria andOutFactoryNoNotEqualTo(String value) {
            addCriterion("out_factory_no <>", value, "outFactoryNo");
            return (Criteria) this;
        }

        public Criteria andOutFactoryNoGreaterThan(String value) {
            addCriterion("out_factory_no >", value, "outFactoryNo");
            return (Criteria) this;
        }

        public Criteria andOutFactoryNoGreaterThanOrEqualTo(String value) {
            addCriterion("out_factory_no >=", value, "outFactoryNo");
            return (Criteria) this;
        }

        public Criteria andOutFactoryNoLessThan(String value) {
            addCriterion("out_factory_no <", value, "outFactoryNo");
            return (Criteria) this;
        }

        public Criteria andOutFactoryNoLessThanOrEqualTo(String value) {
            addCriterion("out_factory_no <=", value, "outFactoryNo");
            return (Criteria) this;
        }

        public Criteria andOutFactoryNoLike(String value) {
            addCriterion("out_factory_no like", value, "outFactoryNo");
            return (Criteria) this;
        }

        public Criteria andOutFactoryNoNotLike(String value) {
            addCriterion("out_factory_no not like", value, "outFactoryNo");
            return (Criteria) this;
        }

        public Criteria andOutFactoryNoIn(List<String> values) {
            addCriterion("out_factory_no in", values, "outFactoryNo");
            return (Criteria) this;
        }

        public Criteria andOutFactoryNoNotIn(List<String> values) {
            addCriterion("out_factory_no not in", values, "outFactoryNo");
            return (Criteria) this;
        }

        public Criteria andOutFactoryNoBetween(String value1, String value2) {
            addCriterion("out_factory_no between", value1, value2, "outFactoryNo");
            return (Criteria) this;
        }

        public Criteria andOutFactoryNoNotBetween(String value1, String value2) {
            addCriterion("out_factory_no not between", value1, value2, "outFactoryNo");
            return (Criteria) this;
        }

        public Criteria andOriginPlaceIsNull() {
            addCriterion("origin_place is null");
            return (Criteria) this;
        }

        public Criteria andOriginPlaceIsNotNull() {
            addCriterion("origin_place is not null");
            return (Criteria) this;
        }

        public Criteria andOriginPlaceEqualTo(String value) {
            addCriterion("origin_place =", value, "originPlace");
            return (Criteria) this;
        }

        public Criteria andOriginPlaceNotEqualTo(String value) {
            addCriterion("origin_place <>", value, "originPlace");
            return (Criteria) this;
        }

        public Criteria andOriginPlaceGreaterThan(String value) {
            addCriterion("origin_place >", value, "originPlace");
            return (Criteria) this;
        }

        public Criteria andOriginPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("origin_place >=", value, "originPlace");
            return (Criteria) this;
        }

        public Criteria andOriginPlaceLessThan(String value) {
            addCriterion("origin_place <", value, "originPlace");
            return (Criteria) this;
        }

        public Criteria andOriginPlaceLessThanOrEqualTo(String value) {
            addCriterion("origin_place <=", value, "originPlace");
            return (Criteria) this;
        }

        public Criteria andOriginPlaceLike(String value) {
            addCriterion("origin_place like", value, "originPlace");
            return (Criteria) this;
        }

        public Criteria andOriginPlaceNotLike(String value) {
            addCriterion("origin_place not like", value, "originPlace");
            return (Criteria) this;
        }

        public Criteria andOriginPlaceIn(List<String> values) {
            addCriterion("origin_place in", values, "originPlace");
            return (Criteria) this;
        }

        public Criteria andOriginPlaceNotIn(List<String> values) {
            addCriterion("origin_place not in", values, "originPlace");
            return (Criteria) this;
        }

        public Criteria andOriginPlaceBetween(String value1, String value2) {
            addCriterion("origin_place between", value1, value2, "originPlace");
            return (Criteria) this;
        }

        public Criteria andOriginPlaceNotBetween(String value1, String value2) {
            addCriterion("origin_place not between", value1, value2, "originPlace");
            return (Criteria) this;
        }

        public Criteria andFactAcceptNumberIsNull() {
            addCriterion("fact_accept_number is null");
            return (Criteria) this;
        }

        public Criteria andFactAcceptNumberIsNotNull() {
            addCriterion("fact_accept_number is not null");
            return (Criteria) this;
        }

        public Criteria andFactAcceptNumberEqualTo(Integer value) {
            addCriterion("fact_accept_number =", value, "factAcceptNumber");
            return (Criteria) this;
        }

        public Criteria andFactAcceptNumberNotEqualTo(Integer value) {
            addCriterion("fact_accept_number <>", value, "factAcceptNumber");
            return (Criteria) this;
        }

        public Criteria andFactAcceptNumberGreaterThan(Integer value) {
            addCriterion("fact_accept_number >", value, "factAcceptNumber");
            return (Criteria) this;
        }

        public Criteria andFactAcceptNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("fact_accept_number >=", value, "factAcceptNumber");
            return (Criteria) this;
        }

        public Criteria andFactAcceptNumberLessThan(Integer value) {
            addCriterion("fact_accept_number <", value, "factAcceptNumber");
            return (Criteria) this;
        }

        public Criteria andFactAcceptNumberLessThanOrEqualTo(Integer value) {
            addCriterion("fact_accept_number <=", value, "factAcceptNumber");
            return (Criteria) this;
        }

        public Criteria andFactAcceptNumberIn(List<Integer> values) {
            addCriterion("fact_accept_number in", values, "factAcceptNumber");
            return (Criteria) this;
        }

        public Criteria andFactAcceptNumberNotIn(List<Integer> values) {
            addCriterion("fact_accept_number not in", values, "factAcceptNumber");
            return (Criteria) this;
        }

        public Criteria andFactAcceptNumberBetween(Integer value1, Integer value2) {
            addCriterion("fact_accept_number between", value1, value2, "factAcceptNumber");
            return (Criteria) this;
        }

        public Criteria andFactAcceptNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("fact_accept_number not between", value1, value2, "factAcceptNumber");
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