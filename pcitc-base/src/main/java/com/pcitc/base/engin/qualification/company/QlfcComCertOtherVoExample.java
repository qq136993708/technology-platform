package com.pcitc.base.engin.qualification.company;

import java.util.ArrayList;
import java.util.List;

public class QlfcComCertOtherVoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QlfcComCertOtherVoExample() {
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

        public Criteria andQlfcComCertOtherIdIsNull() {
            addCriterion("qlfc_com_cert_other_id is null");
            return (Criteria) this;
        }

        public Criteria andQlfcComCertOtherIdIsNotNull() {
            addCriterion("qlfc_com_cert_other_id is not null");
            return (Criteria) this;
        }

        public Criteria andQlfcComCertOtherIdEqualTo(String value) {
            addCriterion("qlfc_com_cert_other_id =", value, "qlfcComCertOtherId");
            return (Criteria) this;
        }

        public Criteria andQlfcComCertOtherIdNotEqualTo(String value) {
            addCriterion("qlfc_com_cert_other_id <>", value, "qlfcComCertOtherId");
            return (Criteria) this;
        }

        public Criteria andQlfcComCertOtherIdGreaterThan(String value) {
            addCriterion("qlfc_com_cert_other_id >", value, "qlfcComCertOtherId");
            return (Criteria) this;
        }

        public Criteria andQlfcComCertOtherIdGreaterThanOrEqualTo(String value) {
            addCriterion("qlfc_com_cert_other_id >=", value, "qlfcComCertOtherId");
            return (Criteria) this;
        }

        public Criteria andQlfcComCertOtherIdLessThan(String value) {
            addCriterion("qlfc_com_cert_other_id <", value, "qlfcComCertOtherId");
            return (Criteria) this;
        }

        public Criteria andQlfcComCertOtherIdLessThanOrEqualTo(String value) {
            addCriterion("qlfc_com_cert_other_id <=", value, "qlfcComCertOtherId");
            return (Criteria) this;
        }

        public Criteria andQlfcComCertOtherIdLike(String value) {
            addCriterion("qlfc_com_cert_other_id like", value, "qlfcComCertOtherId");
            return (Criteria) this;
        }

        public Criteria andQlfcComCertOtherIdNotLike(String value) {
            addCriterion("qlfc_com_cert_other_id not like", value, "qlfcComCertOtherId");
            return (Criteria) this;
        }

        public Criteria andQlfcComCertOtherIdIn(List<String> values) {
            addCriterion("qlfc_com_cert_other_id in", values, "qlfcComCertOtherId");
            return (Criteria) this;
        }

        public Criteria andQlfcComCertOtherIdNotIn(List<String> values) {
            addCriterion("qlfc_com_cert_other_id not in", values, "qlfcComCertOtherId");
            return (Criteria) this;
        }

        public Criteria andQlfcComCertOtherIdBetween(String value1, String value2) {
            addCriterion("qlfc_com_cert_other_id between", value1, value2, "qlfcComCertOtherId");
            return (Criteria) this;
        }

        public Criteria andQlfcComCertOtherIdNotBetween(String value1, String value2) {
            addCriterion("qlfc_com_cert_other_id not between", value1, value2, "qlfcComCertOtherId");
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

        public Criteria andComCertTypeIsNull() {
            addCriterion("com_cert_type is null");
            return (Criteria) this;
        }

        public Criteria andComCertTypeIsNotNull() {
            addCriterion("com_cert_type is not null");
            return (Criteria) this;
        }

        public Criteria andComCertTypeEqualTo(String value) {
            addCriterion("com_cert_type =", value, "comCertType");
            return (Criteria) this;
        }

        public Criteria andComCertTypeNotEqualTo(String value) {
            addCriterion("com_cert_type <>", value, "comCertType");
            return (Criteria) this;
        }

        public Criteria andComCertTypeGreaterThan(String value) {
            addCriterion("com_cert_type >", value, "comCertType");
            return (Criteria) this;
        }

        public Criteria andComCertTypeGreaterThanOrEqualTo(String value) {
            addCriterion("com_cert_type >=", value, "comCertType");
            return (Criteria) this;
        }

        public Criteria andComCertTypeLessThan(String value) {
            addCriterion("com_cert_type <", value, "comCertType");
            return (Criteria) this;
        }

        public Criteria andComCertTypeLessThanOrEqualTo(String value) {
            addCriterion("com_cert_type <=", value, "comCertType");
            return (Criteria) this;
        }

        public Criteria andComCertTypeLike(String value) {
            addCriterion("com_cert_type like", value, "comCertType");
            return (Criteria) this;
        }

        public Criteria andComCertTypeNotLike(String value) {
            addCriterion("com_cert_type not like", value, "comCertType");
            return (Criteria) this;
        }

        public Criteria andComCertTypeIn(List<String> values) {
            addCriterion("com_cert_type in", values, "comCertType");
            return (Criteria) this;
        }

        public Criteria andComCertTypeNotIn(List<String> values) {
            addCriterion("com_cert_type not in", values, "comCertType");
            return (Criteria) this;
        }

        public Criteria andComCertTypeBetween(String value1, String value2) {
            addCriterion("com_cert_type between", value1, value2, "comCertType");
            return (Criteria) this;
        }

        public Criteria andComCertTypeNotBetween(String value1, String value2) {
            addCriterion("com_cert_type not between", value1, value2, "comCertType");
            return (Criteria) this;
        }

        public Criteria andComCertNameIsNull() {
            addCriterion("com_cert_name is null");
            return (Criteria) this;
        }

        public Criteria andComCertNameIsNotNull() {
            addCriterion("com_cert_name is not null");
            return (Criteria) this;
        }

        public Criteria andComCertNameEqualTo(String value) {
            addCriterion("com_cert_name =", value, "comCertName");
            return (Criteria) this;
        }

        public Criteria andComCertNameNotEqualTo(String value) {
            addCriterion("com_cert_name <>", value, "comCertName");
            return (Criteria) this;
        }

        public Criteria andComCertNameGreaterThan(String value) {
            addCriterion("com_cert_name >", value, "comCertName");
            return (Criteria) this;
        }

        public Criteria andComCertNameGreaterThanOrEqualTo(String value) {
            addCriterion("com_cert_name >=", value, "comCertName");
            return (Criteria) this;
        }

        public Criteria andComCertNameLessThan(String value) {
            addCriterion("com_cert_name <", value, "comCertName");
            return (Criteria) this;
        }

        public Criteria andComCertNameLessThanOrEqualTo(String value) {
            addCriterion("com_cert_name <=", value, "comCertName");
            return (Criteria) this;
        }

        public Criteria andComCertNameLike(String value) {
            addCriterion("com_cert_name like", value, "comCertName");
            return (Criteria) this;
        }

        public Criteria andComCertNameNotLike(String value) {
            addCriterion("com_cert_name not like", value, "comCertName");
            return (Criteria) this;
        }

        public Criteria andComCertNameIn(List<String> values) {
            addCriterion("com_cert_name in", values, "comCertName");
            return (Criteria) this;
        }

        public Criteria andComCertNameNotIn(List<String> values) {
            addCriterion("com_cert_name not in", values, "comCertName");
            return (Criteria) this;
        }

        public Criteria andComCertNameBetween(String value1, String value2) {
            addCriterion("com_cert_name between", value1, value2, "comCertName");
            return (Criteria) this;
        }

        public Criteria andComCertNameNotBetween(String value1, String value2) {
            addCriterion("com_cert_name not between", value1, value2, "comCertName");
            return (Criteria) this;
        }

        public Criteria andComCertNoIsNull() {
            addCriterion("com_cert_no is null");
            return (Criteria) this;
        }

        public Criteria andComCertNoIsNotNull() {
            addCriterion("com_cert_no is not null");
            return (Criteria) this;
        }

        public Criteria andComCertNoEqualTo(String value) {
            addCriterion("com_cert_no =", value, "comCertNo");
            return (Criteria) this;
        }

        public Criteria andComCertNoNotEqualTo(String value) {
            addCriterion("com_cert_no <>", value, "comCertNo");
            return (Criteria) this;
        }

        public Criteria andComCertNoGreaterThan(String value) {
            addCriterion("com_cert_no >", value, "comCertNo");
            return (Criteria) this;
        }

        public Criteria andComCertNoGreaterThanOrEqualTo(String value) {
            addCriterion("com_cert_no >=", value, "comCertNo");
            return (Criteria) this;
        }

        public Criteria andComCertNoLessThan(String value) {
            addCriterion("com_cert_no <", value, "comCertNo");
            return (Criteria) this;
        }

        public Criteria andComCertNoLessThanOrEqualTo(String value) {
            addCriterion("com_cert_no <=", value, "comCertNo");
            return (Criteria) this;
        }

        public Criteria andComCertNoLike(String value) {
            addCriterion("com_cert_no like", value, "comCertNo");
            return (Criteria) this;
        }

        public Criteria andComCertNoNotLike(String value) {
            addCriterion("com_cert_no not like", value, "comCertNo");
            return (Criteria) this;
        }

        public Criteria andComCertNoIn(List<String> values) {
            addCriterion("com_cert_no in", values, "comCertNo");
            return (Criteria) this;
        }

        public Criteria andComCertNoNotIn(List<String> values) {
            addCriterion("com_cert_no not in", values, "comCertNo");
            return (Criteria) this;
        }

        public Criteria andComCertNoBetween(String value1, String value2) {
            addCriterion("com_cert_no between", value1, value2, "comCertNo");
            return (Criteria) this;
        }

        public Criteria andComCertNoNotBetween(String value1, String value2) {
            addCriterion("com_cert_no not between", value1, value2, "comCertNo");
            return (Criteria) this;
        }

        public Criteria andComCertDateIsNull() {
            addCriterion("com_cert_date is null");
            return (Criteria) this;
        }

        public Criteria andComCertDateIsNotNull() {
            addCriterion("com_cert_date is not null");
            return (Criteria) this;
        }

        public Criteria andComCertDateEqualTo(String value) {
            addCriterion("com_cert_date =", value, "comCertDate");
            return (Criteria) this;
        }

        public Criteria andComCertDateNotEqualTo(String value) {
            addCriterion("com_cert_date <>", value, "comCertDate");
            return (Criteria) this;
        }

        public Criteria andComCertDateGreaterThan(String value) {
            addCriterion("com_cert_date >", value, "comCertDate");
            return (Criteria) this;
        }

        public Criteria andComCertDateGreaterThanOrEqualTo(String value) {
            addCriterion("com_cert_date >=", value, "comCertDate");
            return (Criteria) this;
        }

        public Criteria andComCertDateLessThan(String value) {
            addCriterion("com_cert_date <", value, "comCertDate");
            return (Criteria) this;
        }

        public Criteria andComCertDateLessThanOrEqualTo(String value) {
            addCriterion("com_cert_date <=", value, "comCertDate");
            return (Criteria) this;
        }

        public Criteria andComCertDateLike(String value) {
            addCriterion("com_cert_date like", value, "comCertDate");
            return (Criteria) this;
        }

        public Criteria andComCertDateNotLike(String value) {
            addCriterion("com_cert_date not like", value, "comCertDate");
            return (Criteria) this;
        }

        public Criteria andComCertDateIn(List<String> values) {
            addCriterion("com_cert_date in", values, "comCertDate");
            return (Criteria) this;
        }

        public Criteria andComCertDateNotIn(List<String> values) {
            addCriterion("com_cert_date not in", values, "comCertDate");
            return (Criteria) this;
        }

        public Criteria andComCertDateBetween(String value1, String value2) {
            addCriterion("com_cert_date between", value1, value2, "comCertDate");
            return (Criteria) this;
        }

        public Criteria andComCertDateNotBetween(String value1, String value2) {
            addCriterion("com_cert_date not between", value1, value2, "comCertDate");
            return (Criteria) this;
        }

        public Criteria andComCertStartDateIsNull() {
            addCriterion("com_cert_start_date is null");
            return (Criteria) this;
        }

        public Criteria andComCertStartDateIsNotNull() {
            addCriterion("com_cert_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andComCertStartDateEqualTo(String value) {
            addCriterion("com_cert_start_date =", value, "comCertStartDate");
            return (Criteria) this;
        }

        public Criteria andComCertStartDateNotEqualTo(String value) {
            addCriterion("com_cert_start_date <>", value, "comCertStartDate");
            return (Criteria) this;
        }

        public Criteria andComCertStartDateGreaterThan(String value) {
            addCriterion("com_cert_start_date >", value, "comCertStartDate");
            return (Criteria) this;
        }

        public Criteria andComCertStartDateGreaterThanOrEqualTo(String value) {
            addCriterion("com_cert_start_date >=", value, "comCertStartDate");
            return (Criteria) this;
        }

        public Criteria andComCertStartDateLessThan(String value) {
            addCriterion("com_cert_start_date <", value, "comCertStartDate");
            return (Criteria) this;
        }

        public Criteria andComCertStartDateLessThanOrEqualTo(String value) {
            addCriterion("com_cert_start_date <=", value, "comCertStartDate");
            return (Criteria) this;
        }

        public Criteria andComCertStartDateLike(String value) {
            addCriterion("com_cert_start_date like", value, "comCertStartDate");
            return (Criteria) this;
        }

        public Criteria andComCertStartDateNotLike(String value) {
            addCriterion("com_cert_start_date not like", value, "comCertStartDate");
            return (Criteria) this;
        }

        public Criteria andComCertStartDateIn(List<String> values) {
            addCriterion("com_cert_start_date in", values, "comCertStartDate");
            return (Criteria) this;
        }

        public Criteria andComCertStartDateNotIn(List<String> values) {
            addCriterion("com_cert_start_date not in", values, "comCertStartDate");
            return (Criteria) this;
        }

        public Criteria andComCertStartDateBetween(String value1, String value2) {
            addCriterion("com_cert_start_date between", value1, value2, "comCertStartDate");
            return (Criteria) this;
        }

        public Criteria andComCertStartDateNotBetween(String value1, String value2) {
            addCriterion("com_cert_start_date not between", value1, value2, "comCertStartDate");
            return (Criteria) this;
        }

        public Criteria andComCertEndDateIsNull() {
            addCriterion("com_cert_end_date is null");
            return (Criteria) this;
        }

        public Criteria andComCertEndDateIsNotNull() {
            addCriterion("com_cert_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andComCertEndDateEqualTo(String value) {
            addCriterion("com_cert_end_date =", value, "comCertEndDate");
            return (Criteria) this;
        }

        public Criteria andComCertEndDateNotEqualTo(String value) {
            addCriterion("com_cert_end_date <>", value, "comCertEndDate");
            return (Criteria) this;
        }

        public Criteria andComCertEndDateGreaterThan(String value) {
            addCriterion("com_cert_end_date >", value, "comCertEndDate");
            return (Criteria) this;
        }

        public Criteria andComCertEndDateGreaterThanOrEqualTo(String value) {
            addCriterion("com_cert_end_date >=", value, "comCertEndDate");
            return (Criteria) this;
        }

        public Criteria andComCertEndDateLessThan(String value) {
            addCriterion("com_cert_end_date <", value, "comCertEndDate");
            return (Criteria) this;
        }

        public Criteria andComCertEndDateLessThanOrEqualTo(String value) {
            addCriterion("com_cert_end_date <=", value, "comCertEndDate");
            return (Criteria) this;
        }

        public Criteria andComCertEndDateLike(String value) {
            addCriterion("com_cert_end_date like", value, "comCertEndDate");
            return (Criteria) this;
        }

        public Criteria andComCertEndDateNotLike(String value) {
            addCriterion("com_cert_end_date not like", value, "comCertEndDate");
            return (Criteria) this;
        }

        public Criteria andComCertEndDateIn(List<String> values) {
            addCriterion("com_cert_end_date in", values, "comCertEndDate");
            return (Criteria) this;
        }

        public Criteria andComCertEndDateNotIn(List<String> values) {
            addCriterion("com_cert_end_date not in", values, "comCertEndDate");
            return (Criteria) this;
        }

        public Criteria andComCertEndDateBetween(String value1, String value2) {
            addCriterion("com_cert_end_date between", value1, value2, "comCertEndDate");
            return (Criteria) this;
        }

        public Criteria andComCertEndDateNotBetween(String value1, String value2) {
            addCriterion("com_cert_end_date not between", value1, value2, "comCertEndDate");
            return (Criteria) this;
        }

        public Criteria andComCertAttachmentIsNull() {
            addCriterion("com_cert_attachment is null");
            return (Criteria) this;
        }

        public Criteria andComCertAttachmentIsNotNull() {
            addCriterion("com_cert_attachment is not null");
            return (Criteria) this;
        }

        public Criteria andComCertAttachmentEqualTo(String value) {
            addCriterion("com_cert_attachment =", value, "comCertAttachment");
            return (Criteria) this;
        }

        public Criteria andComCertAttachmentNotEqualTo(String value) {
            addCriterion("com_cert_attachment <>", value, "comCertAttachment");
            return (Criteria) this;
        }

        public Criteria andComCertAttachmentGreaterThan(String value) {
            addCriterion("com_cert_attachment >", value, "comCertAttachment");
            return (Criteria) this;
        }

        public Criteria andComCertAttachmentGreaterThanOrEqualTo(String value) {
            addCriterion("com_cert_attachment >=", value, "comCertAttachment");
            return (Criteria) this;
        }

        public Criteria andComCertAttachmentLessThan(String value) {
            addCriterion("com_cert_attachment <", value, "comCertAttachment");
            return (Criteria) this;
        }

        public Criteria andComCertAttachmentLessThanOrEqualTo(String value) {
            addCriterion("com_cert_attachment <=", value, "comCertAttachment");
            return (Criteria) this;
        }

        public Criteria andComCertAttachmentLike(String value) {
            addCriterion("com_cert_attachment like", value, "comCertAttachment");
            return (Criteria) this;
        }

        public Criteria andComCertAttachmentNotLike(String value) {
            addCriterion("com_cert_attachment not like", value, "comCertAttachment");
            return (Criteria) this;
        }

        public Criteria andComCertAttachmentIn(List<String> values) {
            addCriterion("com_cert_attachment in", values, "comCertAttachment");
            return (Criteria) this;
        }

        public Criteria andComCertAttachmentNotIn(List<String> values) {
            addCriterion("com_cert_attachment not in", values, "comCertAttachment");
            return (Criteria) this;
        }

        public Criteria andComCertAttachmentBetween(String value1, String value2) {
            addCriterion("com_cert_attachment between", value1, value2, "comCertAttachment");
            return (Criteria) this;
        }

        public Criteria andComCertAttachmentNotBetween(String value1, String value2) {
            addCriterion("com_cert_attachment not between", value1, value2, "comCertAttachment");
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