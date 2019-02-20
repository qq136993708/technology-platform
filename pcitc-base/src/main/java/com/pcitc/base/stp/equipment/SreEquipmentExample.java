package com.pcitc.base.stp.equipment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SreEquipmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SreEquipmentExample() {
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

        public Criteria andEquipmentCodeIsNull() {
            addCriterion("equipment_code is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeIsNotNull() {
            addCriterion("equipment_code is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeEqualTo(String value) {
            addCriterion("equipment_code =", value, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeNotEqualTo(String value) {
            addCriterion("equipment_code <>", value, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeGreaterThan(String value) {
            addCriterion("equipment_code >", value, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_code >=", value, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeLessThan(String value) {
            addCriterion("equipment_code <", value, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeLessThanOrEqualTo(String value) {
            addCriterion("equipment_code <=", value, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeLike(String value) {
            addCriterion("equipment_code like", value, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeNotLike(String value) {
            addCriterion("equipment_code not like", value, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeIn(List<String> values) {
            addCriterion("equipment_code in", values, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeNotIn(List<String> values) {
            addCriterion("equipment_code not in", values, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeBetween(String value1, String value2) {
            addCriterion("equipment_code between", value1, value2, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeNotBetween(String value1, String value2) {
            addCriterion("equipment_code not between", value1, value2, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andIsLinkedProjectIsNull() {
            addCriterion("is_linked_project is null");
            return (Criteria) this;
        }

        public Criteria andIsLinkedProjectIsNotNull() {
            addCriterion("is_linked_project is not null");
            return (Criteria) this;
        }

        public Criteria andIsLinkedProjectEqualTo(String value) {
            addCriterion("is_linked_project =", value, "isLinkedProject");
            return (Criteria) this;
        }

        public Criteria andIsLinkedProjectNotEqualTo(String value) {
            addCriterion("is_linked_project <>", value, "isLinkedProject");
            return (Criteria) this;
        }

        public Criteria andIsLinkedProjectGreaterThan(String value) {
            addCriterion("is_linked_project >", value, "isLinkedProject");
            return (Criteria) this;
        }

        public Criteria andIsLinkedProjectGreaterThanOrEqualTo(String value) {
            addCriterion("is_linked_project >=", value, "isLinkedProject");
            return (Criteria) this;
        }

        public Criteria andIsLinkedProjectLessThan(String value) {
            addCriterion("is_linked_project <", value, "isLinkedProject");
            return (Criteria) this;
        }

        public Criteria andIsLinkedProjectLessThanOrEqualTo(String value) {
            addCriterion("is_linked_project <=", value, "isLinkedProject");
            return (Criteria) this;
        }

        public Criteria andIsLinkedProjectLike(String value) {
            addCriterion("is_linked_project like", value, "isLinkedProject");
            return (Criteria) this;
        }

        public Criteria andIsLinkedProjectNotLike(String value) {
            addCriterion("is_linked_project not like", value, "isLinkedProject");
            return (Criteria) this;
        }

        public Criteria andIsLinkedProjectIn(List<String> values) {
            addCriterion("is_linked_project in", values, "isLinkedProject");
            return (Criteria) this;
        }

        public Criteria andIsLinkedProjectNotIn(List<String> values) {
            addCriterion("is_linked_project not in", values, "isLinkedProject");
            return (Criteria) this;
        }

        public Criteria andIsLinkedProjectBetween(String value1, String value2) {
            addCriterion("is_linked_project between", value1, value2, "isLinkedProject");
            return (Criteria) this;
        }

        public Criteria andIsLinkedProjectNotBetween(String value1, String value2) {
            addCriterion("is_linked_project not between", value1, value2, "isLinkedProject");
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

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIsNull() {
            addCriterion("unit_price is null");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIsNotNull() {
            addCriterion("unit_price is not null");
            return (Criteria) this;
        }

        public Criteria andUnitPriceEqualTo(BigDecimal value) {
            addCriterion("unit_price =", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotEqualTo(BigDecimal value) {
            addCriterion("unit_price <>", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceGreaterThan(BigDecimal value) {
            addCriterion("unit_price >", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("unit_price >=", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceLessThan(BigDecimal value) {
            addCriterion("unit_price <", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("unit_price <=", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIn(List<BigDecimal> values) {
            addCriterion("unit_price in", values, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotIn(List<BigDecimal> values) {
            addCriterion("unit_price not in", values, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unit_price between", value1, value2, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unit_price not between", value1, value2, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andAllPriceIsNull() {
            addCriterion("all_price is null");
            return (Criteria) this;
        }

        public Criteria andAllPriceIsNotNull() {
            addCriterion("all_price is not null");
            return (Criteria) this;
        }

        public Criteria andAllPriceEqualTo(BigDecimal value) {
            addCriterion("all_price =", value, "allPrice");
            return (Criteria) this;
        }

        public Criteria andAllPriceNotEqualTo(BigDecimal value) {
            addCriterion("all_price <>", value, "allPrice");
            return (Criteria) this;
        }

        public Criteria andAllPriceGreaterThan(BigDecimal value) {
            addCriterion("all_price >", value, "allPrice");
            return (Criteria) this;
        }

        public Criteria andAllPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("all_price >=", value, "allPrice");
            return (Criteria) this;
        }

        public Criteria andAllPriceLessThan(BigDecimal value) {
            addCriterion("all_price <", value, "allPrice");
            return (Criteria) this;
        }

        public Criteria andAllPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("all_price <=", value, "allPrice");
            return (Criteria) this;
        }

        public Criteria andAllPriceIn(List<BigDecimal> values) {
            addCriterion("all_price in", values, "allPrice");
            return (Criteria) this;
        }

        public Criteria andAllPriceNotIn(List<BigDecimal> values) {
            addCriterion("all_price not in", values, "allPrice");
            return (Criteria) this;
        }

        public Criteria andAllPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("all_price between", value1, value2, "allPrice");
            return (Criteria) this;
        }

        public Criteria andAllPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("all_price not between", value1, value2, "allPrice");
            return (Criteria) this;
        }

        public Criteria andApplyAcountIsNull() {
            addCriterion("apply_acount is null");
            return (Criteria) this;
        }

        public Criteria andApplyAcountIsNotNull() {
            addCriterion("apply_acount is not null");
            return (Criteria) this;
        }

        public Criteria andApplyAcountEqualTo(Integer value) {
            addCriterion("apply_acount =", value, "applyAcount");
            return (Criteria) this;
        }

        public Criteria andApplyAcountNotEqualTo(Integer value) {
            addCriterion("apply_acount <>", value, "applyAcount");
            return (Criteria) this;
        }

        public Criteria andApplyAcountGreaterThan(Integer value) {
            addCriterion("apply_acount >", value, "applyAcount");
            return (Criteria) this;
        }

        public Criteria andApplyAcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("apply_acount >=", value, "applyAcount");
            return (Criteria) this;
        }

        public Criteria andApplyAcountLessThan(Integer value) {
            addCriterion("apply_acount <", value, "applyAcount");
            return (Criteria) this;
        }

        public Criteria andApplyAcountLessThanOrEqualTo(Integer value) {
            addCriterion("apply_acount <=", value, "applyAcount");
            return (Criteria) this;
        }

        public Criteria andApplyAcountIn(List<Integer> values) {
            addCriterion("apply_acount in", values, "applyAcount");
            return (Criteria) this;
        }

        public Criteria andApplyAcountNotIn(List<Integer> values) {
            addCriterion("apply_acount not in", values, "applyAcount");
            return (Criteria) this;
        }

        public Criteria andApplyAcountBetween(Integer value1, Integer value2) {
            addCriterion("apply_acount between", value1, value2, "applyAcount");
            return (Criteria) this;
        }

        public Criteria andApplyAcountNotBetween(Integer value1, Integer value2) {
            addCriterion("apply_acount not between", value1, value2, "applyAcount");
            return (Criteria) this;
        }

        public Criteria andSpecificationIsNull() {
            addCriterion("specification is null");
            return (Criteria) this;
        }

        public Criteria andSpecificationIsNotNull() {
            addCriterion("specification is not null");
            return (Criteria) this;
        }

        public Criteria andSpecificationEqualTo(String value) {
            addCriterion("specification =", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationNotEqualTo(String value) {
            addCriterion("specification <>", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationGreaterThan(String value) {
            addCriterion("specification >", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationGreaterThanOrEqualTo(String value) {
            addCriterion("specification >=", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationLessThan(String value) {
            addCriterion("specification <", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationLessThanOrEqualTo(String value) {
            addCriterion("specification <=", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationLike(String value) {
            addCriterion("specification like", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationNotLike(String value) {
            addCriterion("specification not like", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationIn(List<String> values) {
            addCriterion("specification in", values, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationNotIn(List<String> values) {
            addCriterion("specification not in", values, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationBetween(String value1, String value2) {
            addCriterion("specification between", value1, value2, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationNotBetween(String value1, String value2) {
            addCriterion("specification not between", value1, value2, "specification");
            return (Criteria) this;
        }

        public Criteria andNotesIsNull() {
            addCriterion("notes is null");
            return (Criteria) this;
        }

        public Criteria andNotesIsNotNull() {
            addCriterion("notes is not null");
            return (Criteria) this;
        }

        public Criteria andNotesEqualTo(String value) {
            addCriterion("notes =", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotEqualTo(String value) {
            addCriterion("notes <>", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesGreaterThan(String value) {
            addCriterion("notes >", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesGreaterThanOrEqualTo(String value) {
            addCriterion("notes >=", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesLessThan(String value) {
            addCriterion("notes <", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesLessThanOrEqualTo(String value) {
            addCriterion("notes <=", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesLike(String value) {
            addCriterion("notes like", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotLike(String value) {
            addCriterion("notes not like", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesIn(List<String> values) {
            addCriterion("notes in", values, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotIn(List<String> values) {
            addCriterion("notes not in", values, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesBetween(String value1, String value2) {
            addCriterion("notes between", value1, value2, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotBetween(String value1, String value2) {
            addCriterion("notes not between", value1, value2, "notes");
            return (Criteria) this;
        }

        public Criteria andSpecialNotesIsNull() {
            addCriterion("special_notes is null");
            return (Criteria) this;
        }

        public Criteria andSpecialNotesIsNotNull() {
            addCriterion("special_notes is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialNotesEqualTo(String value) {
            addCriterion("special_notes =", value, "specialNotes");
            return (Criteria) this;
        }

        public Criteria andSpecialNotesNotEqualTo(String value) {
            addCriterion("special_notes <>", value, "specialNotes");
            return (Criteria) this;
        }

        public Criteria andSpecialNotesGreaterThan(String value) {
            addCriterion("special_notes >", value, "specialNotes");
            return (Criteria) this;
        }

        public Criteria andSpecialNotesGreaterThanOrEqualTo(String value) {
            addCriterion("special_notes >=", value, "specialNotes");
            return (Criteria) this;
        }

        public Criteria andSpecialNotesLessThan(String value) {
            addCriterion("special_notes <", value, "specialNotes");
            return (Criteria) this;
        }

        public Criteria andSpecialNotesLessThanOrEqualTo(String value) {
            addCriterion("special_notes <=", value, "specialNotes");
            return (Criteria) this;
        }

        public Criteria andSpecialNotesLike(String value) {
            addCriterion("special_notes like", value, "specialNotes");
            return (Criteria) this;
        }

        public Criteria andSpecialNotesNotLike(String value) {
            addCriterion("special_notes not like", value, "specialNotes");
            return (Criteria) this;
        }

        public Criteria andSpecialNotesIn(List<String> values) {
            addCriterion("special_notes in", values, "specialNotes");
            return (Criteria) this;
        }

        public Criteria andSpecialNotesNotIn(List<String> values) {
            addCriterion("special_notes not in", values, "specialNotes");
            return (Criteria) this;
        }

        public Criteria andSpecialNotesBetween(String value1, String value2) {
            addCriterion("special_notes between", value1, value2, "specialNotes");
            return (Criteria) this;
        }

        public Criteria andSpecialNotesNotBetween(String value1, String value2) {
            addCriterion("special_notes not between", value1, value2, "specialNotes");
            return (Criteria) this;
        }

        public Criteria andAttachmentDocIsNull() {
            addCriterion("attachment_doc is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentDocIsNotNull() {
            addCriterion("attachment_doc is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentDocEqualTo(String value) {
            addCriterion("attachment_doc =", value, "attachmentDoc");
            return (Criteria) this;
        }

        public Criteria andAttachmentDocNotEqualTo(String value) {
            addCriterion("attachment_doc <>", value, "attachmentDoc");
            return (Criteria) this;
        }

        public Criteria andAttachmentDocGreaterThan(String value) {
            addCriterion("attachment_doc >", value, "attachmentDoc");
            return (Criteria) this;
        }

        public Criteria andAttachmentDocGreaterThanOrEqualTo(String value) {
            addCriterion("attachment_doc >=", value, "attachmentDoc");
            return (Criteria) this;
        }

        public Criteria andAttachmentDocLessThan(String value) {
            addCriterion("attachment_doc <", value, "attachmentDoc");
            return (Criteria) this;
        }

        public Criteria andAttachmentDocLessThanOrEqualTo(String value) {
            addCriterion("attachment_doc <=", value, "attachmentDoc");
            return (Criteria) this;
        }

        public Criteria andAttachmentDocLike(String value) {
            addCriterion("attachment_doc like", value, "attachmentDoc");
            return (Criteria) this;
        }

        public Criteria andAttachmentDocNotLike(String value) {
            addCriterion("attachment_doc not like", value, "attachmentDoc");
            return (Criteria) this;
        }

        public Criteria andAttachmentDocIn(List<String> values) {
            addCriterion("attachment_doc in", values, "attachmentDoc");
            return (Criteria) this;
        }

        public Criteria andAttachmentDocNotIn(List<String> values) {
            addCriterion("attachment_doc not in", values, "attachmentDoc");
            return (Criteria) this;
        }

        public Criteria andAttachmentDocBetween(String value1, String value2) {
            addCriterion("attachment_doc between", value1, value2, "attachmentDoc");
            return (Criteria) this;
        }

        public Criteria andAttachmentDocNotBetween(String value1, String value2) {
            addCriterion("attachment_doc not between", value1, value2, "attachmentDoc");
            return (Criteria) this;
        }

        public Criteria andApplyDepartNameIsNull() {
            addCriterion("apply_depart_name is null");
            return (Criteria) this;
        }

        public Criteria andApplyDepartNameIsNotNull() {
            addCriterion("apply_depart_name is not null");
            return (Criteria) this;
        }

        public Criteria andApplyDepartNameEqualTo(String value) {
            addCriterion("apply_depart_name =", value, "applyDepartName");
            return (Criteria) this;
        }

        public Criteria andApplyDepartNameNotEqualTo(String value) {
            addCriterion("apply_depart_name <>", value, "applyDepartName");
            return (Criteria) this;
        }

        public Criteria andApplyDepartNameGreaterThan(String value) {
            addCriterion("apply_depart_name >", value, "applyDepartName");
            return (Criteria) this;
        }

        public Criteria andApplyDepartNameGreaterThanOrEqualTo(String value) {
            addCriterion("apply_depart_name >=", value, "applyDepartName");
            return (Criteria) this;
        }

        public Criteria andApplyDepartNameLessThan(String value) {
            addCriterion("apply_depart_name <", value, "applyDepartName");
            return (Criteria) this;
        }

        public Criteria andApplyDepartNameLessThanOrEqualTo(String value) {
            addCriterion("apply_depart_name <=", value, "applyDepartName");
            return (Criteria) this;
        }

        public Criteria andApplyDepartNameLike(String value) {
            addCriterion("apply_depart_name like", value, "applyDepartName");
            return (Criteria) this;
        }

        public Criteria andApplyDepartNameNotLike(String value) {
            addCriterion("apply_depart_name not like", value, "applyDepartName");
            return (Criteria) this;
        }

        public Criteria andApplyDepartNameIn(List<String> values) {
            addCriterion("apply_depart_name in", values, "applyDepartName");
            return (Criteria) this;
        }

        public Criteria andApplyDepartNameNotIn(List<String> values) {
            addCriterion("apply_depart_name not in", values, "applyDepartName");
            return (Criteria) this;
        }

        public Criteria andApplyDepartNameBetween(String value1, String value2) {
            addCriterion("apply_depart_name between", value1, value2, "applyDepartName");
            return (Criteria) this;
        }

        public Criteria andApplyDepartNameNotBetween(String value1, String value2) {
            addCriterion("apply_depart_name not between", value1, value2, "applyDepartName");
            return (Criteria) this;
        }

        public Criteria andApplyDepartCodeIsNull() {
            addCriterion("apply_depart_code is null");
            return (Criteria) this;
        }

        public Criteria andApplyDepartCodeIsNotNull() {
            addCriterion("apply_depart_code is not null");
            return (Criteria) this;
        }

        public Criteria andApplyDepartCodeEqualTo(String value) {
            addCriterion("apply_depart_code =", value, "applyDepartCode");
            return (Criteria) this;
        }

        public Criteria andApplyDepartCodeNotEqualTo(String value) {
            addCriterion("apply_depart_code <>", value, "applyDepartCode");
            return (Criteria) this;
        }

        public Criteria andApplyDepartCodeGreaterThan(String value) {
            addCriterion("apply_depart_code >", value, "applyDepartCode");
            return (Criteria) this;
        }

        public Criteria andApplyDepartCodeGreaterThanOrEqualTo(String value) {
            addCriterion("apply_depart_code >=", value, "applyDepartCode");
            return (Criteria) this;
        }

        public Criteria andApplyDepartCodeLessThan(String value) {
            addCriterion("apply_depart_code <", value, "applyDepartCode");
            return (Criteria) this;
        }

        public Criteria andApplyDepartCodeLessThanOrEqualTo(String value) {
            addCriterion("apply_depart_code <=", value, "applyDepartCode");
            return (Criteria) this;
        }

        public Criteria andApplyDepartCodeLike(String value) {
            addCriterion("apply_depart_code like", value, "applyDepartCode");
            return (Criteria) this;
        }

        public Criteria andApplyDepartCodeNotLike(String value) {
            addCriterion("apply_depart_code not like", value, "applyDepartCode");
            return (Criteria) this;
        }

        public Criteria andApplyDepartCodeIn(List<String> values) {
            addCriterion("apply_depart_code in", values, "applyDepartCode");
            return (Criteria) this;
        }

        public Criteria andApplyDepartCodeNotIn(List<String> values) {
            addCriterion("apply_depart_code not in", values, "applyDepartCode");
            return (Criteria) this;
        }

        public Criteria andApplyDepartCodeBetween(String value1, String value2) {
            addCriterion("apply_depart_code between", value1, value2, "applyDepartCode");
            return (Criteria) this;
        }

        public Criteria andApplyDepartCodeNotBetween(String value1, String value2) {
            addCriterion("apply_depart_code not between", value1, value2, "applyDepartCode");
            return (Criteria) this;
        }

        public Criteria andFirstApplyUserIsNull() {
            addCriterion("first_apply_user is null");
            return (Criteria) this;
        }

        public Criteria andFirstApplyUserIsNotNull() {
            addCriterion("first_apply_user is not null");
            return (Criteria) this;
        }

        public Criteria andFirstApplyUserEqualTo(String value) {
            addCriterion("first_apply_user =", value, "firstApplyUser");
            return (Criteria) this;
        }

        public Criteria andFirstApplyUserNotEqualTo(String value) {
            addCriterion("first_apply_user <>", value, "firstApplyUser");
            return (Criteria) this;
        }

        public Criteria andFirstApplyUserGreaterThan(String value) {
            addCriterion("first_apply_user >", value, "firstApplyUser");
            return (Criteria) this;
        }

        public Criteria andFirstApplyUserGreaterThanOrEqualTo(String value) {
            addCriterion("first_apply_user >=", value, "firstApplyUser");
            return (Criteria) this;
        }

        public Criteria andFirstApplyUserLessThan(String value) {
            addCriterion("first_apply_user <", value, "firstApplyUser");
            return (Criteria) this;
        }

        public Criteria andFirstApplyUserLessThanOrEqualTo(String value) {
            addCriterion("first_apply_user <=", value, "firstApplyUser");
            return (Criteria) this;
        }

        public Criteria andFirstApplyUserLike(String value) {
            addCriterion("first_apply_user like", value, "firstApplyUser");
            return (Criteria) this;
        }

        public Criteria andFirstApplyUserNotLike(String value) {
            addCriterion("first_apply_user not like", value, "firstApplyUser");
            return (Criteria) this;
        }

        public Criteria andFirstApplyUserIn(List<String> values) {
            addCriterion("first_apply_user in", values, "firstApplyUser");
            return (Criteria) this;
        }

        public Criteria andFirstApplyUserNotIn(List<String> values) {
            addCriterion("first_apply_user not in", values, "firstApplyUser");
            return (Criteria) this;
        }

        public Criteria andFirstApplyUserBetween(String value1, String value2) {
            addCriterion("first_apply_user between", value1, value2, "firstApplyUser");
            return (Criteria) this;
        }

        public Criteria andFirstApplyUserNotBetween(String value1, String value2) {
            addCriterion("first_apply_user not between", value1, value2, "firstApplyUser");
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

        public Criteria andErpNoIsNull() {
            addCriterion("erp_no is null");
            return (Criteria) this;
        }

        public Criteria andErpNoIsNotNull() {
            addCriterion("erp_no is not null");
            return (Criteria) this;
        }

        public Criteria andErpNoEqualTo(String value) {
            addCriterion("erp_no =", value, "erpNo");
            return (Criteria) this;
        }

        public Criteria andErpNoNotEqualTo(String value) {
            addCriterion("erp_no <>", value, "erpNo");
            return (Criteria) this;
        }

        public Criteria andErpNoGreaterThan(String value) {
            addCriterion("erp_no >", value, "erpNo");
            return (Criteria) this;
        }

        public Criteria andErpNoGreaterThanOrEqualTo(String value) {
            addCriterion("erp_no >=", value, "erpNo");
            return (Criteria) this;
        }

        public Criteria andErpNoLessThan(String value) {
            addCriterion("erp_no <", value, "erpNo");
            return (Criteria) this;
        }

        public Criteria andErpNoLessThanOrEqualTo(String value) {
            addCriterion("erp_no <=", value, "erpNo");
            return (Criteria) this;
        }

        public Criteria andErpNoLike(String value) {
            addCriterion("erp_no like", value, "erpNo");
            return (Criteria) this;
        }

        public Criteria andErpNoNotLike(String value) {
            addCriterion("erp_no not like", value, "erpNo");
            return (Criteria) this;
        }

        public Criteria andErpNoIn(List<String> values) {
            addCriterion("erp_no in", values, "erpNo");
            return (Criteria) this;
        }

        public Criteria andErpNoNotIn(List<String> values) {
            addCriterion("erp_no not in", values, "erpNo");
            return (Criteria) this;
        }

        public Criteria andErpNoBetween(String value1, String value2) {
            addCriterion("erp_no between", value1, value2, "erpNo");
            return (Criteria) this;
        }

        public Criteria andErpNoNotBetween(String value1, String value2) {
            addCriterion("erp_no not between", value1, value2, "erpNo");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIsNull() {
            addCriterion("supplier_id is null");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIsNotNull() {
            addCriterion("supplier_id is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierIdEqualTo(String value) {
            addCriterion("supplier_id =", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotEqualTo(String value) {
            addCriterion("supplier_id <>", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdGreaterThan(String value) {
            addCriterion("supplier_id >", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdGreaterThanOrEqualTo(String value) {
            addCriterion("supplier_id >=", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdLessThan(String value) {
            addCriterion("supplier_id <", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdLessThanOrEqualTo(String value) {
            addCriterion("supplier_id <=", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdLike(String value) {
            addCriterion("supplier_id like", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotLike(String value) {
            addCriterion("supplier_id not like", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIn(List<String> values) {
            addCriterion("supplier_id in", values, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotIn(List<String> values) {
            addCriterion("supplier_id not in", values, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdBetween(String value1, String value2) {
            addCriterion("supplier_id between", value1, value2, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotBetween(String value1, String value2) {
            addCriterion("supplier_id not between", value1, value2, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierNameIsNull() {
            addCriterion("supplier_name is null");
            return (Criteria) this;
        }

        public Criteria andSupplierNameIsNotNull() {
            addCriterion("supplier_name is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierNameEqualTo(String value) {
            addCriterion("supplier_name =", value, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameNotEqualTo(String value) {
            addCriterion("supplier_name <>", value, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameGreaterThan(String value) {
            addCriterion("supplier_name >", value, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameGreaterThanOrEqualTo(String value) {
            addCriterion("supplier_name >=", value, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameLessThan(String value) {
            addCriterion("supplier_name <", value, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameLessThanOrEqualTo(String value) {
            addCriterion("supplier_name <=", value, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameLike(String value) {
            addCriterion("supplier_name like", value, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameNotLike(String value) {
            addCriterion("supplier_name not like", value, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameIn(List<String> values) {
            addCriterion("supplier_name in", values, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameNotIn(List<String> values) {
            addCriterion("supplier_name not in", values, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameBetween(String value1, String value2) {
            addCriterion("supplier_name between", value1, value2, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameNotBetween(String value1, String value2) {
            addCriterion("supplier_name not between", value1, value2, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierLinkManIsNull() {
            addCriterion("supplier_link_man is null");
            return (Criteria) this;
        }

        public Criteria andSupplierLinkManIsNotNull() {
            addCriterion("supplier_link_man is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierLinkManEqualTo(String value) {
            addCriterion("supplier_link_man =", value, "supplierLinkMan");
            return (Criteria) this;
        }

        public Criteria andSupplierLinkManNotEqualTo(String value) {
            addCriterion("supplier_link_man <>", value, "supplierLinkMan");
            return (Criteria) this;
        }

        public Criteria andSupplierLinkManGreaterThan(String value) {
            addCriterion("supplier_link_man >", value, "supplierLinkMan");
            return (Criteria) this;
        }

        public Criteria andSupplierLinkManGreaterThanOrEqualTo(String value) {
            addCriterion("supplier_link_man >=", value, "supplierLinkMan");
            return (Criteria) this;
        }

        public Criteria andSupplierLinkManLessThan(String value) {
            addCriterion("supplier_link_man <", value, "supplierLinkMan");
            return (Criteria) this;
        }

        public Criteria andSupplierLinkManLessThanOrEqualTo(String value) {
            addCriterion("supplier_link_man <=", value, "supplierLinkMan");
            return (Criteria) this;
        }

        public Criteria andSupplierLinkManLike(String value) {
            addCriterion("supplier_link_man like", value, "supplierLinkMan");
            return (Criteria) this;
        }

        public Criteria andSupplierLinkManNotLike(String value) {
            addCriterion("supplier_link_man not like", value, "supplierLinkMan");
            return (Criteria) this;
        }

        public Criteria andSupplierLinkManIn(List<String> values) {
            addCriterion("supplier_link_man in", values, "supplierLinkMan");
            return (Criteria) this;
        }

        public Criteria andSupplierLinkManNotIn(List<String> values) {
            addCriterion("supplier_link_man not in", values, "supplierLinkMan");
            return (Criteria) this;
        }

        public Criteria andSupplierLinkManBetween(String value1, String value2) {
            addCriterion("supplier_link_man between", value1, value2, "supplierLinkMan");
            return (Criteria) this;
        }

        public Criteria andSupplierLinkManNotBetween(String value1, String value2) {
            addCriterion("supplier_link_man not between", value1, value2, "supplierLinkMan");
            return (Criteria) this;
        }

        public Criteria andSupplierMobileEmailIsNull() {
            addCriterion("supplier_mobile_email is null");
            return (Criteria) this;
        }

        public Criteria andSupplierMobileEmailIsNotNull() {
            addCriterion("supplier_mobile_email is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierMobileEmailEqualTo(String value) {
            addCriterion("supplier_mobile_email =", value, "supplierMobileEmail");
            return (Criteria) this;
        }

        public Criteria andSupplierMobileEmailNotEqualTo(String value) {
            addCriterion("supplier_mobile_email <>", value, "supplierMobileEmail");
            return (Criteria) this;
        }

        public Criteria andSupplierMobileEmailGreaterThan(String value) {
            addCriterion("supplier_mobile_email >", value, "supplierMobileEmail");
            return (Criteria) this;
        }

        public Criteria andSupplierMobileEmailGreaterThanOrEqualTo(String value) {
            addCriterion("supplier_mobile_email >=", value, "supplierMobileEmail");
            return (Criteria) this;
        }

        public Criteria andSupplierMobileEmailLessThan(String value) {
            addCriterion("supplier_mobile_email <", value, "supplierMobileEmail");
            return (Criteria) this;
        }

        public Criteria andSupplierMobileEmailLessThanOrEqualTo(String value) {
            addCriterion("supplier_mobile_email <=", value, "supplierMobileEmail");
            return (Criteria) this;
        }

        public Criteria andSupplierMobileEmailLike(String value) {
            addCriterion("supplier_mobile_email like", value, "supplierMobileEmail");
            return (Criteria) this;
        }

        public Criteria andSupplierMobileEmailNotLike(String value) {
            addCriterion("supplier_mobile_email not like", value, "supplierMobileEmail");
            return (Criteria) this;
        }

        public Criteria andSupplierMobileEmailIn(List<String> values) {
            addCriterion("supplier_mobile_email in", values, "supplierMobileEmail");
            return (Criteria) this;
        }

        public Criteria andSupplierMobileEmailNotIn(List<String> values) {
            addCriterion("supplier_mobile_email not in", values, "supplierMobileEmail");
            return (Criteria) this;
        }

        public Criteria andSupplierMobileEmailBetween(String value1, String value2) {
            addCriterion("supplier_mobile_email between", value1, value2, "supplierMobileEmail");
            return (Criteria) this;
        }

        public Criteria andSupplierMobileEmailNotBetween(String value1, String value2) {
            addCriterion("supplier_mobile_email not between", value1, value2, "supplierMobileEmail");
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

        public Criteria andVoteCountIsNull() {
            addCriterion("vote_count is null");
            return (Criteria) this;
        }

        public Criteria andVoteCountIsNotNull() {
            addCriterion("vote_count is not null");
            return (Criteria) this;
        }

        public Criteria andVoteCountEqualTo(Integer value) {
            addCriterion("vote_count =", value, "voteCount");
            return (Criteria) this;
        }

        public Criteria andVoteCountNotEqualTo(Integer value) {
            addCriterion("vote_count <>", value, "voteCount");
            return (Criteria) this;
        }

        public Criteria andVoteCountGreaterThan(Integer value) {
            addCriterion("vote_count >", value, "voteCount");
            return (Criteria) this;
        }

        public Criteria andVoteCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("vote_count >=", value, "voteCount");
            return (Criteria) this;
        }

        public Criteria andVoteCountLessThan(Integer value) {
            addCriterion("vote_count <", value, "voteCount");
            return (Criteria) this;
        }

        public Criteria andVoteCountLessThanOrEqualTo(Integer value) {
            addCriterion("vote_count <=", value, "voteCount");
            return (Criteria) this;
        }

        public Criteria andVoteCountIn(List<Integer> values) {
            addCriterion("vote_count in", values, "voteCount");
            return (Criteria) this;
        }

        public Criteria andVoteCountNotIn(List<Integer> values) {
            addCriterion("vote_count not in", values, "voteCount");
            return (Criteria) this;
        }

        public Criteria andVoteCountBetween(Integer value1, Integer value2) {
            addCriterion("vote_count between", value1, value2, "voteCount");
            return (Criteria) this;
        }

        public Criteria andVoteCountNotBetween(Integer value1, Integer value2) {
            addCriterion("vote_count not between", value1, value2, "voteCount");
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