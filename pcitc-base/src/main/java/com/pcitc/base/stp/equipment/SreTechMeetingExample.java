package com.pcitc.base.stp.equipment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SreTechMeetingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SreTechMeetingExample() {
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

        public Criteria andMeetingIdIsNull() {
            addCriterion("meeting_id is null");
            return (Criteria) this;
        }

        public Criteria andMeetingIdIsNotNull() {
            addCriterion("meeting_id is not null");
            return (Criteria) this;
        }

        public Criteria andMeetingIdEqualTo(String value) {
            addCriterion("meeting_id =", value, "meetingId");
            return (Criteria) this;
        }

        public Criteria andMeetingIdNotEqualTo(String value) {
            addCriterion("meeting_id <>", value, "meetingId");
            return (Criteria) this;
        }

        public Criteria andMeetingIdGreaterThan(String value) {
            addCriterion("meeting_id >", value, "meetingId");
            return (Criteria) this;
        }

        public Criteria andMeetingIdGreaterThanOrEqualTo(String value) {
            addCriterion("meeting_id >=", value, "meetingId");
            return (Criteria) this;
        }

        public Criteria andMeetingIdLessThan(String value) {
            addCriterion("meeting_id <", value, "meetingId");
            return (Criteria) this;
        }

        public Criteria andMeetingIdLessThanOrEqualTo(String value) {
            addCriterion("meeting_id <=", value, "meetingId");
            return (Criteria) this;
        }

        public Criteria andMeetingIdLike(String value) {
            addCriterion("meeting_id like", value, "meetingId");
            return (Criteria) this;
        }

        public Criteria andMeetingIdNotLike(String value) {
            addCriterion("meeting_id not like", value, "meetingId");
            return (Criteria) this;
        }

        public Criteria andMeetingIdIn(List<String> values) {
            addCriterion("meeting_id in", values, "meetingId");
            return (Criteria) this;
        }

        public Criteria andMeetingIdNotIn(List<String> values) {
            addCriterion("meeting_id not in", values, "meetingId");
            return (Criteria) this;
        }

        public Criteria andMeetingIdBetween(String value1, String value2) {
            addCriterion("meeting_id between", value1, value2, "meetingId");
            return (Criteria) this;
        }

        public Criteria andMeetingIdNotBetween(String value1, String value2) {
            addCriterion("meeting_id not between", value1, value2, "meetingId");
            return (Criteria) this;
        }

        public Criteria andMeetingCodeIsNull() {
            addCriterion("meeting_code is null");
            return (Criteria) this;
        }

        public Criteria andMeetingCodeIsNotNull() {
            addCriterion("meeting_code is not null");
            return (Criteria) this;
        }

        public Criteria andMeetingCodeEqualTo(String value) {
            addCriterion("meeting_code =", value, "meetingCode");
            return (Criteria) this;
        }

        public Criteria andMeetingCodeNotEqualTo(String value) {
            addCriterion("meeting_code <>", value, "meetingCode");
            return (Criteria) this;
        }

        public Criteria andMeetingCodeGreaterThan(String value) {
            addCriterion("meeting_code >", value, "meetingCode");
            return (Criteria) this;
        }

        public Criteria andMeetingCodeGreaterThanOrEqualTo(String value) {
            addCriterion("meeting_code >=", value, "meetingCode");
            return (Criteria) this;
        }

        public Criteria andMeetingCodeLessThan(String value) {
            addCriterion("meeting_code <", value, "meetingCode");
            return (Criteria) this;
        }

        public Criteria andMeetingCodeLessThanOrEqualTo(String value) {
            addCriterion("meeting_code <=", value, "meetingCode");
            return (Criteria) this;
        }

        public Criteria andMeetingCodeLike(String value) {
            addCriterion("meeting_code like", value, "meetingCode");
            return (Criteria) this;
        }

        public Criteria andMeetingCodeNotLike(String value) {
            addCriterion("meeting_code not like", value, "meetingCode");
            return (Criteria) this;
        }

        public Criteria andMeetingCodeIn(List<String> values) {
            addCriterion("meeting_code in", values, "meetingCode");
            return (Criteria) this;
        }

        public Criteria andMeetingCodeNotIn(List<String> values) {
            addCriterion("meeting_code not in", values, "meetingCode");
            return (Criteria) this;
        }

        public Criteria andMeetingCodeBetween(String value1, String value2) {
            addCriterion("meeting_code between", value1, value2, "meetingCode");
            return (Criteria) this;
        }

        public Criteria andMeetingCodeNotBetween(String value1, String value2) {
            addCriterion("meeting_code not between", value1, value2, "meetingCode");
            return (Criteria) this;
        }

        public Criteria andMeetingDateIsNull() {
            addCriterion("meeting_date is null");
            return (Criteria) this;
        }

        public Criteria andMeetingDateIsNotNull() {
            addCriterion("meeting_date is not null");
            return (Criteria) this;
        }

        public Criteria andMeetingDateEqualTo(Date value) {
            addCriterion("meeting_date =", value, "meetingDate");
            return (Criteria) this;
        }

        public Criteria andMeetingDateNotEqualTo(Date value) {
            addCriterion("meeting_date <>", value, "meetingDate");
            return (Criteria) this;
        }

        public Criteria andMeetingDateGreaterThan(Date value) {
            addCriterion("meeting_date >", value, "meetingDate");
            return (Criteria) this;
        }

        public Criteria andMeetingDateGreaterThanOrEqualTo(Date value) {
            addCriterion("meeting_date >=", value, "meetingDate");
            return (Criteria) this;
        }

        public Criteria andMeetingDateLessThan(Date value) {
            addCriterion("meeting_date <", value, "meetingDate");
            return (Criteria) this;
        }

        public Criteria andMeetingDateLessThanOrEqualTo(Date value) {
            addCriterion("meeting_date <=", value, "meetingDate");
            return (Criteria) this;
        }

        public Criteria andMeetingDateIn(List<Date> values) {
            addCriterion("meeting_date in", values, "meetingDate");
            return (Criteria) this;
        }

        public Criteria andMeetingDateNotIn(List<Date> values) {
            addCriterion("meeting_date not in", values, "meetingDate");
            return (Criteria) this;
        }

        public Criteria andMeetingDateBetween(Date value1, Date value2) {
            addCriterion("meeting_date between", value1, value2, "meetingDate");
            return (Criteria) this;
        }

        public Criteria andMeetingDateNotBetween(Date value1, Date value2) {
            addCriterion("meeting_date not between", value1, value2, "meetingDate");
            return (Criteria) this;
        }

        public Criteria andMeetingPlaceIsNull() {
            addCriterion("meeting_place is null");
            return (Criteria) this;
        }

        public Criteria andMeetingPlaceIsNotNull() {
            addCriterion("meeting_place is not null");
            return (Criteria) this;
        }

        public Criteria andMeetingPlaceEqualTo(String value) {
            addCriterion("meeting_place =", value, "meetingPlace");
            return (Criteria) this;
        }

        public Criteria andMeetingPlaceNotEqualTo(String value) {
            addCriterion("meeting_place <>", value, "meetingPlace");
            return (Criteria) this;
        }

        public Criteria andMeetingPlaceGreaterThan(String value) {
            addCriterion("meeting_place >", value, "meetingPlace");
            return (Criteria) this;
        }

        public Criteria andMeetingPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("meeting_place >=", value, "meetingPlace");
            return (Criteria) this;
        }

        public Criteria andMeetingPlaceLessThan(String value) {
            addCriterion("meeting_place <", value, "meetingPlace");
            return (Criteria) this;
        }

        public Criteria andMeetingPlaceLessThanOrEqualTo(String value) {
            addCriterion("meeting_place <=", value, "meetingPlace");
            return (Criteria) this;
        }

        public Criteria andMeetingPlaceLike(String value) {
            addCriterion("meeting_place like", value, "meetingPlace");
            return (Criteria) this;
        }

        public Criteria andMeetingPlaceNotLike(String value) {
            addCriterion("meeting_place not like", value, "meetingPlace");
            return (Criteria) this;
        }

        public Criteria andMeetingPlaceIn(List<String> values) {
            addCriterion("meeting_place in", values, "meetingPlace");
            return (Criteria) this;
        }

        public Criteria andMeetingPlaceNotIn(List<String> values) {
            addCriterion("meeting_place not in", values, "meetingPlace");
            return (Criteria) this;
        }

        public Criteria andMeetingPlaceBetween(String value1, String value2) {
            addCriterion("meeting_place between", value1, value2, "meetingPlace");
            return (Criteria) this;
        }

        public Criteria andMeetingPlaceNotBetween(String value1, String value2) {
            addCriterion("meeting_place not between", value1, value2, "meetingPlace");
            return (Criteria) this;
        }

        public Criteria andMeetingEmceeIsNull() {
            addCriterion("meeting_emcee is null");
            return (Criteria) this;
        }

        public Criteria andMeetingEmceeIsNotNull() {
            addCriterion("meeting_emcee is not null");
            return (Criteria) this;
        }

        public Criteria andMeetingEmceeEqualTo(String value) {
            addCriterion("meeting_emcee =", value, "meetingEmcee");
            return (Criteria) this;
        }

        public Criteria andMeetingEmceeNotEqualTo(String value) {
            addCriterion("meeting_emcee <>", value, "meetingEmcee");
            return (Criteria) this;
        }

        public Criteria andMeetingEmceeGreaterThan(String value) {
            addCriterion("meeting_emcee >", value, "meetingEmcee");
            return (Criteria) this;
        }

        public Criteria andMeetingEmceeGreaterThanOrEqualTo(String value) {
            addCriterion("meeting_emcee >=", value, "meetingEmcee");
            return (Criteria) this;
        }

        public Criteria andMeetingEmceeLessThan(String value) {
            addCriterion("meeting_emcee <", value, "meetingEmcee");
            return (Criteria) this;
        }

        public Criteria andMeetingEmceeLessThanOrEqualTo(String value) {
            addCriterion("meeting_emcee <=", value, "meetingEmcee");
            return (Criteria) this;
        }

        public Criteria andMeetingEmceeLike(String value) {
            addCriterion("meeting_emcee like", value, "meetingEmcee");
            return (Criteria) this;
        }

        public Criteria andMeetingEmceeNotLike(String value) {
            addCriterion("meeting_emcee not like", value, "meetingEmcee");
            return (Criteria) this;
        }

        public Criteria andMeetingEmceeIn(List<String> values) {
            addCriterion("meeting_emcee in", values, "meetingEmcee");
            return (Criteria) this;
        }

        public Criteria andMeetingEmceeNotIn(List<String> values) {
            addCriterion("meeting_emcee not in", values, "meetingEmcee");
            return (Criteria) this;
        }

        public Criteria andMeetingEmceeBetween(String value1, String value2) {
            addCriterion("meeting_emcee between", value1, value2, "meetingEmcee");
            return (Criteria) this;
        }

        public Criteria andMeetingEmceeNotBetween(String value1, String value2) {
            addCriterion("meeting_emcee not between", value1, value2, "meetingEmcee");
            return (Criteria) this;
        }

        public Criteria andMeetingContentIsNull() {
            addCriterion("meeting_content is null");
            return (Criteria) this;
        }

        public Criteria andMeetingContentIsNotNull() {
            addCriterion("meeting_content is not null");
            return (Criteria) this;
        }

        public Criteria andMeetingContentEqualTo(String value) {
            addCriterion("meeting_content =", value, "meetingContent");
            return (Criteria) this;
        }

        public Criteria andMeetingContentNotEqualTo(String value) {
            addCriterion("meeting_content <>", value, "meetingContent");
            return (Criteria) this;
        }

        public Criteria andMeetingContentGreaterThan(String value) {
            addCriterion("meeting_content >", value, "meetingContent");
            return (Criteria) this;
        }

        public Criteria andMeetingContentGreaterThanOrEqualTo(String value) {
            addCriterion("meeting_content >=", value, "meetingContent");
            return (Criteria) this;
        }

        public Criteria andMeetingContentLessThan(String value) {
            addCriterion("meeting_content <", value, "meetingContent");
            return (Criteria) this;
        }

        public Criteria andMeetingContentLessThanOrEqualTo(String value) {
            addCriterion("meeting_content <=", value, "meetingContent");
            return (Criteria) this;
        }

        public Criteria andMeetingContentLike(String value) {
            addCriterion("meeting_content like", value, "meetingContent");
            return (Criteria) this;
        }

        public Criteria andMeetingContentNotLike(String value) {
            addCriterion("meeting_content not like", value, "meetingContent");
            return (Criteria) this;
        }

        public Criteria andMeetingContentIn(List<String> values) {
            addCriterion("meeting_content in", values, "meetingContent");
            return (Criteria) this;
        }

        public Criteria andMeetingContentNotIn(List<String> values) {
            addCriterion("meeting_content not in", values, "meetingContent");
            return (Criteria) this;
        }

        public Criteria andMeetingContentBetween(String value1, String value2) {
            addCriterion("meeting_content between", value1, value2, "meetingContent");
            return (Criteria) this;
        }

        public Criteria andMeetingContentNotBetween(String value1, String value2) {
            addCriterion("meeting_content not between", value1, value2, "meetingContent");
            return (Criteria) this;
        }

        public Criteria andMeetingDocIsNull() {
            addCriterion("meeting_doc is null");
            return (Criteria) this;
        }

        public Criteria andMeetingDocIsNotNull() {
            addCriterion("meeting_doc is not null");
            return (Criteria) this;
        }

        public Criteria andMeetingDocEqualTo(String value) {
            addCriterion("meeting_doc =", value, "meetingDoc");
            return (Criteria) this;
        }

        public Criteria andMeetingDocNotEqualTo(String value) {
            addCriterion("meeting_doc <>", value, "meetingDoc");
            return (Criteria) this;
        }

        public Criteria andMeetingDocGreaterThan(String value) {
            addCriterion("meeting_doc >", value, "meetingDoc");
            return (Criteria) this;
        }

        public Criteria andMeetingDocGreaterThanOrEqualTo(String value) {
            addCriterion("meeting_doc >=", value, "meetingDoc");
            return (Criteria) this;
        }

        public Criteria andMeetingDocLessThan(String value) {
            addCriterion("meeting_doc <", value, "meetingDoc");
            return (Criteria) this;
        }

        public Criteria andMeetingDocLessThanOrEqualTo(String value) {
            addCriterion("meeting_doc <=", value, "meetingDoc");
            return (Criteria) this;
        }

        public Criteria andMeetingDocLike(String value) {
            addCriterion("meeting_doc like", value, "meetingDoc");
            return (Criteria) this;
        }

        public Criteria andMeetingDocNotLike(String value) {
            addCriterion("meeting_doc not like", value, "meetingDoc");
            return (Criteria) this;
        }

        public Criteria andMeetingDocIn(List<String> values) {
            addCriterion("meeting_doc in", values, "meetingDoc");
            return (Criteria) this;
        }

        public Criteria andMeetingDocNotIn(List<String> values) {
            addCriterion("meeting_doc not in", values, "meetingDoc");
            return (Criteria) this;
        }

        public Criteria andMeetingDocBetween(String value1, String value2) {
            addCriterion("meeting_doc between", value1, value2, "meetingDoc");
            return (Criteria) this;
        }

        public Criteria andMeetingDocNotBetween(String value1, String value2) {
            addCriterion("meeting_doc not between", value1, value2, "meetingDoc");
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