package com.pcitc.base.engin.qualification.company;

import java.util.ArrayList;
import java.util.List;

public class QlfcComCertVoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QlfcComCertVoExample() {
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

        public Criteria andQlfcComCertIdIsNull() {
            addCriterion("qlfc_com_cert_id is null");
            return (Criteria) this;
        }

        public Criteria andQlfcComCertIdIsNotNull() {
            addCriterion("qlfc_com_cert_id is not null");
            return (Criteria) this;
        }

        public Criteria andQlfcComCertIdEqualTo(String value) {
            addCriterion("qlfc_com_cert_id =", value, "qlfcComCertId");
            return (Criteria) this;
        }

        public Criteria andQlfcComCertIdNotEqualTo(String value) {
            addCriterion("qlfc_com_cert_id <>", value, "qlfcComCertId");
            return (Criteria) this;
        }

        public Criteria andQlfcComCertIdGreaterThan(String value) {
            addCriterion("qlfc_com_cert_id >", value, "qlfcComCertId");
            return (Criteria) this;
        }

        public Criteria andQlfcComCertIdGreaterThanOrEqualTo(String value) {
            addCriterion("qlfc_com_cert_id >=", value, "qlfcComCertId");
            return (Criteria) this;
        }

        public Criteria andQlfcComCertIdLessThan(String value) {
            addCriterion("qlfc_com_cert_id <", value, "qlfcComCertId");
            return (Criteria) this;
        }

        public Criteria andQlfcComCertIdLessThanOrEqualTo(String value) {
            addCriterion("qlfc_com_cert_id <=", value, "qlfcComCertId");
            return (Criteria) this;
        }

        public Criteria andQlfcComCertIdLike(String value) {
            addCriterion("qlfc_com_cert_id like", value, "qlfcComCertId");
            return (Criteria) this;
        }

        public Criteria andQlfcComCertIdNotLike(String value) {
            addCriterion("qlfc_com_cert_id not like", value, "qlfcComCertId");
            return (Criteria) this;
        }

        public Criteria andQlfcComCertIdIn(List<String> values) {
            addCriterion("qlfc_com_cert_id in", values, "qlfcComCertId");
            return (Criteria) this;
        }

        public Criteria andQlfcComCertIdNotIn(List<String> values) {
            addCriterion("qlfc_com_cert_id not in", values, "qlfcComCertId");
            return (Criteria) this;
        }

        public Criteria andQlfcComCertIdBetween(String value1, String value2) {
            addCriterion("qlfc_com_cert_id between", value1, value2, "qlfcComCertId");
            return (Criteria) this;
        }

        public Criteria andQlfcComCertIdNotBetween(String value1, String value2) {
            addCriterion("qlfc_com_cert_id not between", value1, value2, "qlfcComCertId");
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

        public Criteria andQlfcTypeIsNull() {
            addCriterion("qlfc_type is null");
            return (Criteria) this;
        }

        public Criteria andQlfcTypeIsNotNull() {
            addCriterion("qlfc_type is not null");
            return (Criteria) this;
        }

        public Criteria andQlfcTypeEqualTo(String value) {
            addCriterion("qlfc_type =", value, "qlfcType");
            return (Criteria) this;
        }

        public Criteria andQlfcTypeNotEqualTo(String value) {
            addCriterion("qlfc_type <>", value, "qlfcType");
            return (Criteria) this;
        }

        public Criteria andQlfcTypeGreaterThan(String value) {
            addCriterion("qlfc_type >", value, "qlfcType");
            return (Criteria) this;
        }

        public Criteria andQlfcTypeGreaterThanOrEqualTo(String value) {
            addCriterion("qlfc_type >=", value, "qlfcType");
            return (Criteria) this;
        }

        public Criteria andQlfcTypeLessThan(String value) {
            addCriterion("qlfc_type <", value, "qlfcType");
            return (Criteria) this;
        }

        public Criteria andQlfcTypeLessThanOrEqualTo(String value) {
            addCriterion("qlfc_type <=", value, "qlfcType");
            return (Criteria) this;
        }

        public Criteria andQlfcTypeLike(String value) {
            addCriterion("qlfc_type like", value, "qlfcType");
            return (Criteria) this;
        }

        public Criteria andQlfcTypeNotLike(String value) {
            addCriterion("qlfc_type not like", value, "qlfcType");
            return (Criteria) this;
        }

        public Criteria andQlfcTypeIn(List<String> values) {
            addCriterion("qlfc_type in", values, "qlfcType");
            return (Criteria) this;
        }

        public Criteria andQlfcTypeNotIn(List<String> values) {
            addCriterion("qlfc_type not in", values, "qlfcType");
            return (Criteria) this;
        }

        public Criteria andQlfcTypeBetween(String value1, String value2) {
            addCriterion("qlfc_type between", value1, value2, "qlfcType");
            return (Criteria) this;
        }

        public Criteria andQlfcTypeNotBetween(String value1, String value2) {
            addCriterion("qlfc_type not between", value1, value2, "qlfcType");
            return (Criteria) this;
        }

        public Criteria andQlfcCertNoIsNull() {
            addCriterion("qlfc_cert_no is null");
            return (Criteria) this;
        }

        public Criteria andQlfcCertNoIsNotNull() {
            addCriterion("qlfc_cert_no is not null");
            return (Criteria) this;
        }

        public Criteria andQlfcCertNoEqualTo(String value) {
            addCriterion("qlfc_cert_no =", value, "qlfcCertNo");
            return (Criteria) this;
        }

        public Criteria andQlfcCertNoNotEqualTo(String value) {
            addCriterion("qlfc_cert_no <>", value, "qlfcCertNo");
            return (Criteria) this;
        }

        public Criteria andQlfcCertNoGreaterThan(String value) {
            addCriterion("qlfc_cert_no >", value, "qlfcCertNo");
            return (Criteria) this;
        }

        public Criteria andQlfcCertNoGreaterThanOrEqualTo(String value) {
            addCriterion("qlfc_cert_no >=", value, "qlfcCertNo");
            return (Criteria) this;
        }

        public Criteria andQlfcCertNoLessThan(String value) {
            addCriterion("qlfc_cert_no <", value, "qlfcCertNo");
            return (Criteria) this;
        }

        public Criteria andQlfcCertNoLessThanOrEqualTo(String value) {
            addCriterion("qlfc_cert_no <=", value, "qlfcCertNo");
            return (Criteria) this;
        }

        public Criteria andQlfcCertNoLike(String value) {
            addCriterion("qlfc_cert_no like", value, "qlfcCertNo");
            return (Criteria) this;
        }

        public Criteria andQlfcCertNoNotLike(String value) {
            addCriterion("qlfc_cert_no not like", value, "qlfcCertNo");
            return (Criteria) this;
        }

        public Criteria andQlfcCertNoIn(List<String> values) {
            addCriterion("qlfc_cert_no in", values, "qlfcCertNo");
            return (Criteria) this;
        }

        public Criteria andQlfcCertNoNotIn(List<String> values) {
            addCriterion("qlfc_cert_no not in", values, "qlfcCertNo");
            return (Criteria) this;
        }

        public Criteria andQlfcCertNoBetween(String value1, String value2) {
            addCriterion("qlfc_cert_no between", value1, value2, "qlfcCertNo");
            return (Criteria) this;
        }

        public Criteria andQlfcCertNoNotBetween(String value1, String value2) {
            addCriterion("qlfc_cert_no not between", value1, value2, "qlfcCertNo");
            return (Criteria) this;
        }

        public Criteria andQlfcNameIsNull() {
            addCriterion("qlfc_name is null");
            return (Criteria) this;
        }

        public Criteria andQlfcNameIsNotNull() {
            addCriterion("qlfc_name is not null");
            return (Criteria) this;
        }

        public Criteria andQlfcNameEqualTo(String value) {
            addCriterion("qlfc_name =", value, "qlfcName");
            return (Criteria) this;
        }

        public Criteria andQlfcNameNotEqualTo(String value) {
            addCriterion("qlfc_name <>", value, "qlfcName");
            return (Criteria) this;
        }

        public Criteria andQlfcNameGreaterThan(String value) {
            addCriterion("qlfc_name >", value, "qlfcName");
            return (Criteria) this;
        }

        public Criteria andQlfcNameGreaterThanOrEqualTo(String value) {
            addCriterion("qlfc_name >=", value, "qlfcName");
            return (Criteria) this;
        }

        public Criteria andQlfcNameLessThan(String value) {
            addCriterion("qlfc_name <", value, "qlfcName");
            return (Criteria) this;
        }

        public Criteria andQlfcNameLessThanOrEqualTo(String value) {
            addCriterion("qlfc_name <=", value, "qlfcName");
            return (Criteria) this;
        }

        public Criteria andQlfcNameLike(String value) {
            addCriterion("qlfc_name like", value, "qlfcName");
            return (Criteria) this;
        }

        public Criteria andQlfcNameNotLike(String value) {
            addCriterion("qlfc_name not like", value, "qlfcName");
            return (Criteria) this;
        }

        public Criteria andQlfcNameIn(List<String> values) {
            addCriterion("qlfc_name in", values, "qlfcName");
            return (Criteria) this;
        }

        public Criteria andQlfcNameNotIn(List<String> values) {
            addCriterion("qlfc_name not in", values, "qlfcName");
            return (Criteria) this;
        }

        public Criteria andQlfcNameBetween(String value1, String value2) {
            addCriterion("qlfc_name between", value1, value2, "qlfcName");
            return (Criteria) this;
        }

        public Criteria andQlfcNameNotBetween(String value1, String value2) {
            addCriterion("qlfc_name not between", value1, value2, "qlfcName");
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

        public Criteria andComCertInvalidTimeIsNull() {
            addCriterion("com_cert_invalid_time is null");
            return (Criteria) this;
        }

        public Criteria andComCertInvalidTimeIsNotNull() {
            addCriterion("com_cert_invalid_time is not null");
            return (Criteria) this;
        }

        public Criteria andComCertInvalidTimeEqualTo(String value) {
            addCriterion("com_cert_invalid_time =", value, "comCertInvalidTime");
            return (Criteria) this;
        }

        public Criteria andComCertInvalidTimeNotEqualTo(String value) {
            addCriterion("com_cert_invalid_time <>", value, "comCertInvalidTime");
            return (Criteria) this;
        }

        public Criteria andComCertInvalidTimeGreaterThan(String value) {
            addCriterion("com_cert_invalid_time >", value, "comCertInvalidTime");
            return (Criteria) this;
        }

        public Criteria andComCertInvalidTimeGreaterThanOrEqualTo(String value) {
            addCriterion("com_cert_invalid_time >=", value, "comCertInvalidTime");
            return (Criteria) this;
        }

        public Criteria andComCertInvalidTimeLessThan(String value) {
            addCriterion("com_cert_invalid_time <", value, "comCertInvalidTime");
            return (Criteria) this;
        }

        public Criteria andComCertInvalidTimeLessThanOrEqualTo(String value) {
            addCriterion("com_cert_invalid_time <=", value, "comCertInvalidTime");
            return (Criteria) this;
        }

        public Criteria andComCertInvalidTimeLike(String value) {
            addCriterion("com_cert_invalid_time like", value, "comCertInvalidTime");
            return (Criteria) this;
        }

        public Criteria andComCertInvalidTimeNotLike(String value) {
            addCriterion("com_cert_invalid_time not like", value, "comCertInvalidTime");
            return (Criteria) this;
        }

        public Criteria andComCertInvalidTimeIn(List<String> values) {
            addCriterion("com_cert_invalid_time in", values, "comCertInvalidTime");
            return (Criteria) this;
        }

        public Criteria andComCertInvalidTimeNotIn(List<String> values) {
            addCriterion("com_cert_invalid_time not in", values, "comCertInvalidTime");
            return (Criteria) this;
        }

        public Criteria andComCertInvalidTimeBetween(String value1, String value2) {
            addCriterion("com_cert_invalid_time between", value1, value2, "comCertInvalidTime");
            return (Criteria) this;
        }

        public Criteria andComCertInvalidTimeNotBetween(String value1, String value2) {
            addCriterion("com_cert_invalid_time not between", value1, value2, "comCertInvalidTime");
            return (Criteria) this;
        }

        public Criteria andComCertOrganIsNull() {
            addCriterion("com_cert_organ is null");
            return (Criteria) this;
        }

        public Criteria andComCertOrganIsNotNull() {
            addCriterion("com_cert_organ is not null");
            return (Criteria) this;
        }

        public Criteria andComCertOrganEqualTo(String value) {
            addCriterion("com_cert_organ =", value, "comCertOrgan");
            return (Criteria) this;
        }

        public Criteria andComCertOrganNotEqualTo(String value) {
            addCriterion("com_cert_organ <>", value, "comCertOrgan");
            return (Criteria) this;
        }

        public Criteria andComCertOrganGreaterThan(String value) {
            addCriterion("com_cert_organ >", value, "comCertOrgan");
            return (Criteria) this;
        }

        public Criteria andComCertOrganGreaterThanOrEqualTo(String value) {
            addCriterion("com_cert_organ >=", value, "comCertOrgan");
            return (Criteria) this;
        }

        public Criteria andComCertOrganLessThan(String value) {
            addCriterion("com_cert_organ <", value, "comCertOrgan");
            return (Criteria) this;
        }

        public Criteria andComCertOrganLessThanOrEqualTo(String value) {
            addCriterion("com_cert_organ <=", value, "comCertOrgan");
            return (Criteria) this;
        }

        public Criteria andComCertOrganLike(String value) {
            addCriterion("com_cert_organ like", value, "comCertOrgan");
            return (Criteria) this;
        }

        public Criteria andComCertOrganNotLike(String value) {
            addCriterion("com_cert_organ not like", value, "comCertOrgan");
            return (Criteria) this;
        }

        public Criteria andComCertOrganIn(List<String> values) {
            addCriterion("com_cert_organ in", values, "comCertOrgan");
            return (Criteria) this;
        }

        public Criteria andComCertOrganNotIn(List<String> values) {
            addCriterion("com_cert_organ not in", values, "comCertOrgan");
            return (Criteria) this;
        }

        public Criteria andComCertOrganBetween(String value1, String value2) {
            addCriterion("com_cert_organ between", value1, value2, "comCertOrgan");
            return (Criteria) this;
        }

        public Criteria andComCertOrganNotBetween(String value1, String value2) {
            addCriterion("com_cert_organ not between", value1, value2, "comCertOrgan");
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

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
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