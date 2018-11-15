package com.pcitc.base.engin.qualification.company;

import java.util.ArrayList;
import java.util.List;

public class QlfcComApplyOtherVoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QlfcComApplyOtherVoExample() {
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

        public Criteria andQlfcComApplyOtherIdIsNull() {
            addCriterion("qlfc_com_apply_other_id is null");
            return (Criteria) this;
        }

        public Criteria andQlfcComApplyOtherIdIsNotNull() {
            addCriterion("qlfc_com_apply_other_id is not null");
            return (Criteria) this;
        }

        public Criteria andQlfcComApplyOtherIdEqualTo(String value) {
            addCriterion("qlfc_com_apply_other_id =", value, "qlfcComApplyOtherId");
            return (Criteria) this;
        }

        public Criteria andQlfcComApplyOtherIdNotEqualTo(String value) {
            addCriterion("qlfc_com_apply_other_id <>", value, "qlfcComApplyOtherId");
            return (Criteria) this;
        }

        public Criteria andQlfcComApplyOtherIdGreaterThan(String value) {
            addCriterion("qlfc_com_apply_other_id >", value, "qlfcComApplyOtherId");
            return (Criteria) this;
        }

        public Criteria andQlfcComApplyOtherIdGreaterThanOrEqualTo(String value) {
            addCriterion("qlfc_com_apply_other_id >=", value, "qlfcComApplyOtherId");
            return (Criteria) this;
        }

        public Criteria andQlfcComApplyOtherIdLessThan(String value) {
            addCriterion("qlfc_com_apply_other_id <", value, "qlfcComApplyOtherId");
            return (Criteria) this;
        }

        public Criteria andQlfcComApplyOtherIdLessThanOrEqualTo(String value) {
            addCriterion("qlfc_com_apply_other_id <=", value, "qlfcComApplyOtherId");
            return (Criteria) this;
        }

        public Criteria andQlfcComApplyOtherIdLike(String value) {
            addCriterion("qlfc_com_apply_other_id like", value, "qlfcComApplyOtherId");
            return (Criteria) this;
        }

        public Criteria andQlfcComApplyOtherIdNotLike(String value) {
            addCriterion("qlfc_com_apply_other_id not like", value, "qlfcComApplyOtherId");
            return (Criteria) this;
        }

        public Criteria andQlfcComApplyOtherIdIn(List<String> values) {
            addCriterion("qlfc_com_apply_other_id in", values, "qlfcComApplyOtherId");
            return (Criteria) this;
        }

        public Criteria andQlfcComApplyOtherIdNotIn(List<String> values) {
            addCriterion("qlfc_com_apply_other_id not in", values, "qlfcComApplyOtherId");
            return (Criteria) this;
        }

        public Criteria andQlfcComApplyOtherIdBetween(String value1, String value2) {
            addCriterion("qlfc_com_apply_other_id between", value1, value2, "qlfcComApplyOtherId");
            return (Criteria) this;
        }

        public Criteria andQlfcComApplyOtherIdNotBetween(String value1, String value2) {
            addCriterion("qlfc_com_apply_other_id not between", value1, value2, "qlfcComApplyOtherId");
            return (Criteria) this;
        }

        public Criteria andQlfcComApplyIdIsNull() {
            addCriterion("qlfc_com_apply_id is null");
            return (Criteria) this;
        }

        public Criteria andQlfcComApplyIdIsNotNull() {
            addCriterion("qlfc_com_apply_id is not null");
            return (Criteria) this;
        }

        public Criteria andQlfcComApplyIdEqualTo(String value) {
            addCriterion("qlfc_com_apply_id =", value, "qlfcComApplyId");
            return (Criteria) this;
        }

        public Criteria andQlfcComApplyIdNotEqualTo(String value) {
            addCriterion("qlfc_com_apply_id <>", value, "qlfcComApplyId");
            return (Criteria) this;
        }

        public Criteria andQlfcComApplyIdGreaterThan(String value) {
            addCriterion("qlfc_com_apply_id >", value, "qlfcComApplyId");
            return (Criteria) this;
        }

        public Criteria andQlfcComApplyIdGreaterThanOrEqualTo(String value) {
            addCriterion("qlfc_com_apply_id >=", value, "qlfcComApplyId");
            return (Criteria) this;
        }

        public Criteria andQlfcComApplyIdLessThan(String value) {
            addCriterion("qlfc_com_apply_id <", value, "qlfcComApplyId");
            return (Criteria) this;
        }

        public Criteria andQlfcComApplyIdLessThanOrEqualTo(String value) {
            addCriterion("qlfc_com_apply_id <=", value, "qlfcComApplyId");
            return (Criteria) this;
        }

        public Criteria andQlfcComApplyIdLike(String value) {
            addCriterion("qlfc_com_apply_id like", value, "qlfcComApplyId");
            return (Criteria) this;
        }

        public Criteria andQlfcComApplyIdNotLike(String value) {
            addCriterion("qlfc_com_apply_id not like", value, "qlfcComApplyId");
            return (Criteria) this;
        }

        public Criteria andQlfcComApplyIdIn(List<String> values) {
            addCriterion("qlfc_com_apply_id in", values, "qlfcComApplyId");
            return (Criteria) this;
        }

        public Criteria andQlfcComApplyIdNotIn(List<String> values) {
            addCriterion("qlfc_com_apply_id not in", values, "qlfcComApplyId");
            return (Criteria) this;
        }

        public Criteria andQlfcComApplyIdBetween(String value1, String value2) {
            addCriterion("qlfc_com_apply_id between", value1, value2, "qlfcComApplyId");
            return (Criteria) this;
        }

        public Criteria andQlfcComApplyIdNotBetween(String value1, String value2) {
            addCriterion("qlfc_com_apply_id not between", value1, value2, "qlfcComApplyId");
            return (Criteria) this;
        }

        public Criteria andMaterialsNameIsNull() {
            addCriterion("materials_name is null");
            return (Criteria) this;
        }

        public Criteria andMaterialsNameIsNotNull() {
            addCriterion("materials_name is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialsNameEqualTo(String value) {
            addCriterion("materials_name =", value, "materialsName");
            return (Criteria) this;
        }

        public Criteria andMaterialsNameNotEqualTo(String value) {
            addCriterion("materials_name <>", value, "materialsName");
            return (Criteria) this;
        }

        public Criteria andMaterialsNameGreaterThan(String value) {
            addCriterion("materials_name >", value, "materialsName");
            return (Criteria) this;
        }

        public Criteria andMaterialsNameGreaterThanOrEqualTo(String value) {
            addCriterion("materials_name >=", value, "materialsName");
            return (Criteria) this;
        }

        public Criteria andMaterialsNameLessThan(String value) {
            addCriterion("materials_name <", value, "materialsName");
            return (Criteria) this;
        }

        public Criteria andMaterialsNameLessThanOrEqualTo(String value) {
            addCriterion("materials_name <=", value, "materialsName");
            return (Criteria) this;
        }

        public Criteria andMaterialsNameLike(String value) {
            addCriterion("materials_name like", value, "materialsName");
            return (Criteria) this;
        }

        public Criteria andMaterialsNameNotLike(String value) {
            addCriterion("materials_name not like", value, "materialsName");
            return (Criteria) this;
        }

        public Criteria andMaterialsNameIn(List<String> values) {
            addCriterion("materials_name in", values, "materialsName");
            return (Criteria) this;
        }

        public Criteria andMaterialsNameNotIn(List<String> values) {
            addCriterion("materials_name not in", values, "materialsName");
            return (Criteria) this;
        }

        public Criteria andMaterialsNameBetween(String value1, String value2) {
            addCriterion("materials_name between", value1, value2, "materialsName");
            return (Criteria) this;
        }

        public Criteria andMaterialsNameNotBetween(String value1, String value2) {
            addCriterion("materials_name not between", value1, value2, "materialsName");
            return (Criteria) this;
        }

        public Criteria andMaterialsDescIsNull() {
            addCriterion("materials_desc is null");
            return (Criteria) this;
        }

        public Criteria andMaterialsDescIsNotNull() {
            addCriterion("materials_desc is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialsDescEqualTo(String value) {
            addCriterion("materials_desc =", value, "materialsDesc");
            return (Criteria) this;
        }

        public Criteria andMaterialsDescNotEqualTo(String value) {
            addCriterion("materials_desc <>", value, "materialsDesc");
            return (Criteria) this;
        }

        public Criteria andMaterialsDescGreaterThan(String value) {
            addCriterion("materials_desc >", value, "materialsDesc");
            return (Criteria) this;
        }

        public Criteria andMaterialsDescGreaterThanOrEqualTo(String value) {
            addCriterion("materials_desc >=", value, "materialsDesc");
            return (Criteria) this;
        }

        public Criteria andMaterialsDescLessThan(String value) {
            addCriterion("materials_desc <", value, "materialsDesc");
            return (Criteria) this;
        }

        public Criteria andMaterialsDescLessThanOrEqualTo(String value) {
            addCriterion("materials_desc <=", value, "materialsDesc");
            return (Criteria) this;
        }

        public Criteria andMaterialsDescLike(String value) {
            addCriterion("materials_desc like", value, "materialsDesc");
            return (Criteria) this;
        }

        public Criteria andMaterialsDescNotLike(String value) {
            addCriterion("materials_desc not like", value, "materialsDesc");
            return (Criteria) this;
        }

        public Criteria andMaterialsDescIn(List<String> values) {
            addCriterion("materials_desc in", values, "materialsDesc");
            return (Criteria) this;
        }

        public Criteria andMaterialsDescNotIn(List<String> values) {
            addCriterion("materials_desc not in", values, "materialsDesc");
            return (Criteria) this;
        }

        public Criteria andMaterialsDescBetween(String value1, String value2) {
            addCriterion("materials_desc between", value1, value2, "materialsDesc");
            return (Criteria) this;
        }

        public Criteria andMaterialsDescNotBetween(String value1, String value2) {
            addCriterion("materials_desc not between", value1, value2, "materialsDesc");
            return (Criteria) this;
        }

        public Criteria andMaterialsAttachmentIsNull() {
            addCriterion("materials_attachment is null");
            return (Criteria) this;
        }

        public Criteria andMaterialsAttachmentIsNotNull() {
            addCriterion("materials_attachment is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialsAttachmentEqualTo(String value) {
            addCriterion("materials_attachment =", value, "materialsAttachment");
            return (Criteria) this;
        }

        public Criteria andMaterialsAttachmentNotEqualTo(String value) {
            addCriterion("materials_attachment <>", value, "materialsAttachment");
            return (Criteria) this;
        }

        public Criteria andMaterialsAttachmentGreaterThan(String value) {
            addCriterion("materials_attachment >", value, "materialsAttachment");
            return (Criteria) this;
        }

        public Criteria andMaterialsAttachmentGreaterThanOrEqualTo(String value) {
            addCriterion("materials_attachment >=", value, "materialsAttachment");
            return (Criteria) this;
        }

        public Criteria andMaterialsAttachmentLessThan(String value) {
            addCriterion("materials_attachment <", value, "materialsAttachment");
            return (Criteria) this;
        }

        public Criteria andMaterialsAttachmentLessThanOrEqualTo(String value) {
            addCriterion("materials_attachment <=", value, "materialsAttachment");
            return (Criteria) this;
        }

        public Criteria andMaterialsAttachmentLike(String value) {
            addCriterion("materials_attachment like", value, "materialsAttachment");
            return (Criteria) this;
        }

        public Criteria andMaterialsAttachmentNotLike(String value) {
            addCriterion("materials_attachment not like", value, "materialsAttachment");
            return (Criteria) this;
        }

        public Criteria andMaterialsAttachmentIn(List<String> values) {
            addCriterion("materials_attachment in", values, "materialsAttachment");
            return (Criteria) this;
        }

        public Criteria andMaterialsAttachmentNotIn(List<String> values) {
            addCriterion("materials_attachment not in", values, "materialsAttachment");
            return (Criteria) this;
        }

        public Criteria andMaterialsAttachmentBetween(String value1, String value2) {
            addCriterion("materials_attachment between", value1, value2, "materialsAttachment");
            return (Criteria) this;
        }

        public Criteria andMaterialsAttachmentNotBetween(String value1, String value2) {
            addCriterion("materials_attachment not between", value1, value2, "materialsAttachment");
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