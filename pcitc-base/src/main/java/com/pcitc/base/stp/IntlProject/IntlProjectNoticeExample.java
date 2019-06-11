package com.pcitc.base.stp.IntlProject;

import java.util.ArrayList;
import java.util.List;

public class IntlProjectNoticeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IntlProjectNoticeExample() {
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

        public Criteria andNoticeIdIsNull() {
            addCriterion("notice_id is null");
            return (Criteria) this;
        }

        public Criteria andNoticeIdIsNotNull() {
            addCriterion("notice_id is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeIdEqualTo(String value) {
            addCriterion("notice_id =", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdNotEqualTo(String value) {
            addCriterion("notice_id <>", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdGreaterThan(String value) {
            addCriterion("notice_id >", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdGreaterThanOrEqualTo(String value) {
            addCriterion("notice_id >=", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdLessThan(String value) {
            addCriterion("notice_id <", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdLessThanOrEqualTo(String value) {
            addCriterion("notice_id <=", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdLike(String value) {
            addCriterion("notice_id like", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdNotLike(String value) {
            addCriterion("notice_id not like", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdIn(List<String> values) {
            addCriterion("notice_id in", values, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdNotIn(List<String> values) {
            addCriterion("notice_id not in", values, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdBetween(String value1, String value2) {
            addCriterion("notice_id between", value1, value2, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdNotBetween(String value1, String value2) {
            addCriterion("notice_id not between", value1, value2, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleIsNull() {
            addCriterion("notice_title is null");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleIsNotNull() {
            addCriterion("notice_title is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleEqualTo(String value) {
            addCriterion("notice_title =", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleNotEqualTo(String value) {
            addCriterion("notice_title <>", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleGreaterThan(String value) {
            addCriterion("notice_title >", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleGreaterThanOrEqualTo(String value) {
            addCriterion("notice_title >=", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleLessThan(String value) {
            addCriterion("notice_title <", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleLessThanOrEqualTo(String value) {
            addCriterion("notice_title <=", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleLike(String value) {
            addCriterion("notice_title like", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleNotLike(String value) {
            addCriterion("notice_title not like", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleIn(List<String> values) {
            addCriterion("notice_title in", values, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleNotIn(List<String> values) {
            addCriterion("notice_title not in", values, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleBetween(String value1, String value2) {
            addCriterion("notice_title between", value1, value2, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleNotBetween(String value1, String value2) {
            addCriterion("notice_title not between", value1, value2, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeContentIsNull() {
            addCriterion("notice_content is null");
            return (Criteria) this;
        }

        public Criteria andNoticeContentIsNotNull() {
            addCriterion("notice_content is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeContentEqualTo(String value) {
            addCriterion("notice_content =", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentNotEqualTo(String value) {
            addCriterion("notice_content <>", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentGreaterThan(String value) {
            addCriterion("notice_content >", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentGreaterThanOrEqualTo(String value) {
            addCriterion("notice_content >=", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentLessThan(String value) {
            addCriterion("notice_content <", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentLessThanOrEqualTo(String value) {
            addCriterion("notice_content <=", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentLike(String value) {
            addCriterion("notice_content like", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentNotLike(String value) {
            addCriterion("notice_content not like", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentIn(List<String> values) {
            addCriterion("notice_content in", values, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentNotIn(List<String> values) {
            addCriterion("notice_content not in", values, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentBetween(String value1, String value2) {
            addCriterion("notice_content between", value1, value2, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentNotBetween(String value1, String value2) {
            addCriterion("notice_content not between", value1, value2, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeIsNull() {
            addCriterion("notice_type is null");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeIsNotNull() {
            addCriterion("notice_type is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeEqualTo(String value) {
            addCriterion("notice_type =", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeNotEqualTo(String value) {
            addCriterion("notice_type <>", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeGreaterThan(String value) {
            addCriterion("notice_type >", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("notice_type >=", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeLessThan(String value) {
            addCriterion("notice_type <", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeLessThanOrEqualTo(String value) {
            addCriterion("notice_type <=", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeLike(String value) {
            addCriterion("notice_type like", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeNotLike(String value) {
            addCriterion("notice_type not like", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeIn(List<String> values) {
            addCriterion("notice_type in", values, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeNotIn(List<String> values) {
            addCriterion("notice_type not in", values, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeBetween(String value1, String value2) {
            addCriterion("notice_type between", value1, value2, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeNotBetween(String value1, String value2) {
            addCriterion("notice_type not between", value1, value2, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeCodeIsNull() {
            addCriterion("notice_code is null");
            return (Criteria) this;
        }

        public Criteria andNoticeCodeIsNotNull() {
            addCriterion("notice_code is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeCodeEqualTo(String value) {
            addCriterion("notice_code =", value, "noticeCode");
            return (Criteria) this;
        }

        public Criteria andNoticeCodeNotEqualTo(String value) {
            addCriterion("notice_code <>", value, "noticeCode");
            return (Criteria) this;
        }

        public Criteria andNoticeCodeGreaterThan(String value) {
            addCriterion("notice_code >", value, "noticeCode");
            return (Criteria) this;
        }

        public Criteria andNoticeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("notice_code >=", value, "noticeCode");
            return (Criteria) this;
        }

        public Criteria andNoticeCodeLessThan(String value) {
            addCriterion("notice_code <", value, "noticeCode");
            return (Criteria) this;
        }

        public Criteria andNoticeCodeLessThanOrEqualTo(String value) {
            addCriterion("notice_code <=", value, "noticeCode");
            return (Criteria) this;
        }

        public Criteria andNoticeCodeLike(String value) {
            addCriterion("notice_code like", value, "noticeCode");
            return (Criteria) this;
        }

        public Criteria andNoticeCodeNotLike(String value) {
            addCriterion("notice_code not like", value, "noticeCode");
            return (Criteria) this;
        }

        public Criteria andNoticeCodeIn(List<String> values) {
            addCriterion("notice_code in", values, "noticeCode");
            return (Criteria) this;
        }

        public Criteria andNoticeCodeNotIn(List<String> values) {
            addCriterion("notice_code not in", values, "noticeCode");
            return (Criteria) this;
        }

        public Criteria andNoticeCodeBetween(String value1, String value2) {
            addCriterion("notice_code between", value1, value2, "noticeCode");
            return (Criteria) this;
        }

        public Criteria andNoticeCodeNotBetween(String value1, String value2) {
            addCriterion("notice_code not between", value1, value2, "noticeCode");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusIsNull() {
            addCriterion("notice_status is null");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusIsNotNull() {
            addCriterion("notice_status is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusEqualTo(String value) {
            addCriterion("notice_status =", value, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusNotEqualTo(String value) {
            addCriterion("notice_status <>", value, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusGreaterThan(String value) {
            addCriterion("notice_status >", value, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusGreaterThanOrEqualTo(String value) {
            addCriterion("notice_status >=", value, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusLessThan(String value) {
            addCriterion("notice_status <", value, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusLessThanOrEqualTo(String value) {
            addCriterion("notice_status <=", value, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusLike(String value) {
            addCriterion("notice_status like", value, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusNotLike(String value) {
            addCriterion("notice_status not like", value, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusIn(List<String> values) {
            addCriterion("notice_status in", values, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusNotIn(List<String> values) {
            addCriterion("notice_status not in", values, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusBetween(String value1, String value2) {
            addCriterion("notice_status between", value1, value2, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusNotBetween(String value1, String value2) {
            addCriterion("notice_status not between", value1, value2, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNull() {
            addCriterion("creater is null");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNotNull() {
            addCriterion("creater is not null");
            return (Criteria) this;
        }

        public Criteria andCreaterEqualTo(String value) {
            addCriterion("creater =", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotEqualTo(String value) {
            addCriterion("creater <>", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThan(String value) {
            addCriterion("creater >", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThanOrEqualTo(String value) {
            addCriterion("creater >=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThan(String value) {
            addCriterion("creater <", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThanOrEqualTo(String value) {
            addCriterion("creater <=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLike(String value) {
            addCriterion("creater like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotLike(String value) {
            addCriterion("creater not like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterIn(List<String> values) {
            addCriterion("creater in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotIn(List<String> values) {
            addCriterion("creater not in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterBetween(String value1, String value2) {
            addCriterion("creater between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotBetween(String value1, String value2) {
            addCriterion("creater not between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("create_time like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("create_time not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(String value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(String value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(String value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(String value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(String value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLike(String value) {
            addCriterion("update_time like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotLike(String value) {
            addCriterion("update_time not like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<String> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<String> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(String value1, String value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(String value1, String value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andDataUuidIsNull() {
            addCriterion("data_uuid is null");
            return (Criteria) this;
        }

        public Criteria andDataUuidIsNotNull() {
            addCriterion("data_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andDataUuidEqualTo(String value) {
            addCriterion("data_uuid =", value, "dataUuid");
            return (Criteria) this;
        }

        public Criteria andDataUuidNotEqualTo(String value) {
            addCriterion("data_uuid <>", value, "dataUuid");
            return (Criteria) this;
        }

        public Criteria andDataUuidGreaterThan(String value) {
            addCriterion("data_uuid >", value, "dataUuid");
            return (Criteria) this;
        }

        public Criteria andDataUuidGreaterThanOrEqualTo(String value) {
            addCriterion("data_uuid >=", value, "dataUuid");
            return (Criteria) this;
        }

        public Criteria andDataUuidLessThan(String value) {
            addCriterion("data_uuid <", value, "dataUuid");
            return (Criteria) this;
        }

        public Criteria andDataUuidLessThanOrEqualTo(String value) {
            addCriterion("data_uuid <=", value, "dataUuid");
            return (Criteria) this;
        }

        public Criteria andDataUuidLike(String value) {
            addCriterion("data_uuid like", value, "dataUuid");
            return (Criteria) this;
        }

        public Criteria andDataUuidNotLike(String value) {
            addCriterion("data_uuid not like", value, "dataUuid");
            return (Criteria) this;
        }

        public Criteria andDataUuidIn(List<String> values) {
            addCriterion("data_uuid in", values, "dataUuid");
            return (Criteria) this;
        }

        public Criteria andDataUuidNotIn(List<String> values) {
            addCriterion("data_uuid not in", values, "dataUuid");
            return (Criteria) this;
        }

        public Criteria andDataUuidBetween(String value1, String value2) {
            addCriterion("data_uuid between", value1, value2, "dataUuid");
            return (Criteria) this;
        }

        public Criteria andDataUuidNotBetween(String value1, String value2) {
            addCriterion("data_uuid not between", value1, value2, "dataUuid");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNull() {
            addCriterion("del_flag is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(Integer value) {
            addCriterion("del_flag =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(Integer value) {
            addCriterion("del_flag <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(Integer value) {
            addCriterion("del_flag >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("del_flag >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(Integer value) {
            addCriterion("del_flag <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(Integer value) {
            addCriterion("del_flag <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<Integer> values) {
            addCriterion("del_flag in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<Integer> values) {
            addCriterion("del_flag not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(Integer value1, Integer value2) {
            addCriterion("del_flag between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("del_flag not between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDataVersionIsNull() {
            addCriterion("data_version is null");
            return (Criteria) this;
        }

        public Criteria andDataVersionIsNotNull() {
            addCriterion("data_version is not null");
            return (Criteria) this;
        }

        public Criteria andDataVersionEqualTo(String value) {
            addCriterion("data_version =", value, "dataVersion");
            return (Criteria) this;
        }

        public Criteria andDataVersionNotEqualTo(String value) {
            addCriterion("data_version <>", value, "dataVersion");
            return (Criteria) this;
        }

        public Criteria andDataVersionGreaterThan(String value) {
            addCriterion("data_version >", value, "dataVersion");
            return (Criteria) this;
        }

        public Criteria andDataVersionGreaterThanOrEqualTo(String value) {
            addCriterion("data_version >=", value, "dataVersion");
            return (Criteria) this;
        }

        public Criteria andDataVersionLessThan(String value) {
            addCriterion("data_version <", value, "dataVersion");
            return (Criteria) this;
        }

        public Criteria andDataVersionLessThanOrEqualTo(String value) {
            addCriterion("data_version <=", value, "dataVersion");
            return (Criteria) this;
        }

        public Criteria andDataVersionLike(String value) {
            addCriterion("data_version like", value, "dataVersion");
            return (Criteria) this;
        }

        public Criteria andDataVersionNotLike(String value) {
            addCriterion("data_version not like", value, "dataVersion");
            return (Criteria) this;
        }

        public Criteria andDataVersionIn(List<String> values) {
            addCriterion("data_version in", values, "dataVersion");
            return (Criteria) this;
        }

        public Criteria andDataVersionNotIn(List<String> values) {
            addCriterion("data_version not in", values, "dataVersion");
            return (Criteria) this;
        }

        public Criteria andDataVersionBetween(String value1, String value2) {
            addCriterion("data_version between", value1, value2, "dataVersion");
            return (Criteria) this;
        }

        public Criteria andDataVersionNotBetween(String value1, String value2) {
            addCriterion("data_version not between", value1, value2, "dataVersion");
            return (Criteria) this;
        }

        public Criteria andUnitIdIsNull() {
            addCriterion("unit_id is null");
            return (Criteria) this;
        }

        public Criteria andUnitIdIsNotNull() {
            addCriterion("unit_id is not null");
            return (Criteria) this;
        }

        public Criteria andUnitIdEqualTo(String value) {
            addCriterion("unit_id =", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdNotEqualTo(String value) {
            addCriterion("unit_id <>", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdGreaterThan(String value) {
            addCriterion("unit_id >", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdGreaterThanOrEqualTo(String value) {
            addCriterion("unit_id >=", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdLessThan(String value) {
            addCriterion("unit_id <", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdLessThanOrEqualTo(String value) {
            addCriterion("unit_id <=", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdLike(String value) {
            addCriterion("unit_id like", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdNotLike(String value) {
            addCriterion("unit_id not like", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdIn(List<String> values) {
            addCriterion("unit_id in", values, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdNotIn(List<String> values) {
            addCriterion("unit_id not in", values, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdBetween(String value1, String value2) {
            addCriterion("unit_id between", value1, value2, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdNotBetween(String value1, String value2) {
            addCriterion("unit_id not between", value1, value2, "unitId");
            return (Criteria) this;
        }

        public Criteria andAppendFilesIsNull() {
            addCriterion("append_files is null");
            return (Criteria) this;
        }

        public Criteria andAppendFilesIsNotNull() {
            addCriterion("append_files is not null");
            return (Criteria) this;
        }

        public Criteria andAppendFilesEqualTo(String value) {
            addCriterion("append_files =", value, "appendFiles");
            return (Criteria) this;
        }

        public Criteria andAppendFilesNotEqualTo(String value) {
            addCriterion("append_files <>", value, "appendFiles");
            return (Criteria) this;
        }

        public Criteria andAppendFilesGreaterThan(String value) {
            addCriterion("append_files >", value, "appendFiles");
            return (Criteria) this;
        }

        public Criteria andAppendFilesGreaterThanOrEqualTo(String value) {
            addCriterion("append_files >=", value, "appendFiles");
            return (Criteria) this;
        }

        public Criteria andAppendFilesLessThan(String value) {
            addCriterion("append_files <", value, "appendFiles");
            return (Criteria) this;
        }

        public Criteria andAppendFilesLessThanOrEqualTo(String value) {
            addCriterion("append_files <=", value, "appendFiles");
            return (Criteria) this;
        }

        public Criteria andAppendFilesLike(String value) {
            addCriterion("append_files like", value, "appendFiles");
            return (Criteria) this;
        }

        public Criteria andAppendFilesNotLike(String value) {
            addCriterion("append_files not like", value, "appendFiles");
            return (Criteria) this;
        }

        public Criteria andAppendFilesIn(List<String> values) {
            addCriterion("append_files in", values, "appendFiles");
            return (Criteria) this;
        }

        public Criteria andAppendFilesNotIn(List<String> values) {
            addCriterion("append_files not in", values, "appendFiles");
            return (Criteria) this;
        }

        public Criteria andAppendFilesBetween(String value1, String value2) {
            addCriterion("append_files between", value1, value2, "appendFiles");
            return (Criteria) this;
        }

        public Criteria andAppendFilesNotBetween(String value1, String value2) {
            addCriterion("append_files not between", value1, value2, "appendFiles");
            return (Criteria) this;
        }

        public Criteria andNoticeSentTimeIsNull() {
            addCriterion("notice_sent_time is null");
            return (Criteria) this;
        }

        public Criteria andNoticeSentTimeIsNotNull() {
            addCriterion("notice_sent_time is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeSentTimeEqualTo(String value) {
            addCriterion("notice_sent_time =", value, "noticeSentTime");
            return (Criteria) this;
        }

        public Criteria andNoticeSentTimeNotEqualTo(String value) {
            addCriterion("notice_sent_time <>", value, "noticeSentTime");
            return (Criteria) this;
        }

        public Criteria andNoticeSentTimeGreaterThan(String value) {
            addCriterion("notice_sent_time >", value, "noticeSentTime");
            return (Criteria) this;
        }

        public Criteria andNoticeSentTimeGreaterThanOrEqualTo(String value) {
            addCriterion("notice_sent_time >=", value, "noticeSentTime");
            return (Criteria) this;
        }

        public Criteria andNoticeSentTimeLessThan(String value) {
            addCriterion("notice_sent_time <", value, "noticeSentTime");
            return (Criteria) this;
        }

        public Criteria andNoticeSentTimeLessThanOrEqualTo(String value) {
            addCriterion("notice_sent_time <=", value, "noticeSentTime");
            return (Criteria) this;
        }

        public Criteria andNoticeSentTimeLike(String value) {
            addCriterion("notice_sent_time like", value, "noticeSentTime");
            return (Criteria) this;
        }

        public Criteria andNoticeSentTimeNotLike(String value) {
            addCriterion("notice_sent_time not like", value, "noticeSentTime");
            return (Criteria) this;
        }

        public Criteria andNoticeSentTimeIn(List<String> values) {
            addCriterion("notice_sent_time in", values, "noticeSentTime");
            return (Criteria) this;
        }

        public Criteria andNoticeSentTimeNotIn(List<String> values) {
            addCriterion("notice_sent_time not in", values, "noticeSentTime");
            return (Criteria) this;
        }

        public Criteria andNoticeSentTimeBetween(String value1, String value2) {
            addCriterion("notice_sent_time between", value1, value2, "noticeSentTime");
            return (Criteria) this;
        }

        public Criteria andNoticeSentTimeNotBetween(String value1, String value2) {
            addCriterion("notice_sent_time not between", value1, value2, "noticeSentTime");
            return (Criteria) this;
        }

        public Criteria andTargetUsersIsNull() {
            addCriterion("target_users is null");
            return (Criteria) this;
        }

        public Criteria andTargetUsersIsNotNull() {
            addCriterion("target_users is not null");
            return (Criteria) this;
        }

        public Criteria andTargetUsersEqualTo(String value) {
            addCriterion("target_users =", value, "targetUsers");
            return (Criteria) this;
        }

        public Criteria andTargetUsersNotEqualTo(String value) {
            addCriterion("target_users <>", value, "targetUsers");
            return (Criteria) this;
        }

        public Criteria andTargetUsersGreaterThan(String value) {
            addCriterion("target_users >", value, "targetUsers");
            return (Criteria) this;
        }

        public Criteria andTargetUsersGreaterThanOrEqualTo(String value) {
            addCriterion("target_users >=", value, "targetUsers");
            return (Criteria) this;
        }

        public Criteria andTargetUsersLessThan(String value) {
            addCriterion("target_users <", value, "targetUsers");
            return (Criteria) this;
        }

        public Criteria andTargetUsersLessThanOrEqualTo(String value) {
            addCriterion("target_users <=", value, "targetUsers");
            return (Criteria) this;
        }

        public Criteria andTargetUsersLike(String value) {
            addCriterion("target_users like", value, "targetUsers");
            return (Criteria) this;
        }

        public Criteria andTargetUsersNotLike(String value) {
            addCriterion("target_users not like", value, "targetUsers");
            return (Criteria) this;
        }

        public Criteria andTargetUsersIn(List<String> values) {
            addCriterion("target_users in", values, "targetUsers");
            return (Criteria) this;
        }

        public Criteria andTargetUsersNotIn(List<String> values) {
            addCriterion("target_users not in", values, "targetUsers");
            return (Criteria) this;
        }

        public Criteria andTargetUsersBetween(String value1, String value2) {
            addCriterion("target_users between", value1, value2, "targetUsers");
            return (Criteria) this;
        }

        public Criteria andTargetUsersNotBetween(String value1, String value2) {
            addCriterion("target_users not between", value1, value2, "targetUsers");
            return (Criteria) this;
        }

        public Criteria andFlowStatusIsNull() {
            addCriterion("flow_status is null");
            return (Criteria) this;
        }

        public Criteria andFlowStatusIsNotNull() {
            addCriterion("flow_status is not null");
            return (Criteria) this;
        }

        public Criteria andFlowStatusEqualTo(Integer value) {
            addCriterion("flow_status =", value, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusNotEqualTo(Integer value) {
            addCriterion("flow_status <>", value, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusGreaterThan(Integer value) {
            addCriterion("flow_status >", value, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("flow_status >=", value, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusLessThan(Integer value) {
            addCriterion("flow_status <", value, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusLessThanOrEqualTo(Integer value) {
            addCriterion("flow_status <=", value, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusIn(List<Integer> values) {
            addCriterion("flow_status in", values, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusNotIn(List<Integer> values) {
            addCriterion("flow_status not in", values, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusBetween(Integer value1, Integer value2) {
            addCriterion("flow_status between", value1, value2, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("flow_status not between", value1, value2, "flowStatus");
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