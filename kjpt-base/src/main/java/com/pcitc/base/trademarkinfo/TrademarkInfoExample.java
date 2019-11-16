package com.pcitc.base.trademarkinfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TrademarkInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public TrademarkInfoExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUnitNameIsNull() {
            addCriterion("unit_name is null");
            return (Criteria) this;
        }

        public Criteria andUnitNameIsNotNull() {
            addCriterion("unit_name is not null");
            return (Criteria) this;
        }

        public Criteria andUnitNameEqualTo(String value) {
            addCriterion("unit_name =", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotEqualTo(String value) {
            addCriterion("unit_name <>", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameGreaterThan(String value) {
            addCriterion("unit_name >", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameGreaterThanOrEqualTo(String value) {
            addCriterion("unit_name >=", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameLessThan(String value) {
            addCriterion("unit_name <", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameLessThanOrEqualTo(String value) {
            addCriterion("unit_name <=", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameLike(String value) {
            addCriterion("unit_name like", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotLike(String value) {
            addCriterion("unit_name not like", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameIn(List<String> values) {
            addCriterion("unit_name in", values, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotIn(List<String> values) {
            addCriterion("unit_name not in", values, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameBetween(String value1, String value2) {
            addCriterion("unit_name between", value1, value2, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotBetween(String value1, String value2) {
            addCriterion("unit_name not between", value1, value2, "unitName");
            return (Criteria) this;
        }

        public Criteria andCommodityCategoryIsNull() {
            addCriterion("commodity_category is null");
            return (Criteria) this;
        }

        public Criteria andCommodityCategoryIsNotNull() {
            addCriterion("commodity_category is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityCategoryEqualTo(String value) {
            addCriterion("commodity_category =", value, "commodityCategory");
            return (Criteria) this;
        }

        public Criteria andCommodityCategoryNotEqualTo(String value) {
            addCriterion("commodity_category <>", value, "commodityCategory");
            return (Criteria) this;
        }

        public Criteria andCommodityCategoryGreaterThan(String value) {
            addCriterion("commodity_category >", value, "commodityCategory");
            return (Criteria) this;
        }

        public Criteria andCommodityCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("commodity_category >=", value, "commodityCategory");
            return (Criteria) this;
        }

        public Criteria andCommodityCategoryLessThan(String value) {
            addCriterion("commodity_category <", value, "commodityCategory");
            return (Criteria) this;
        }

        public Criteria andCommodityCategoryLessThanOrEqualTo(String value) {
            addCriterion("commodity_category <=", value, "commodityCategory");
            return (Criteria) this;
        }

        public Criteria andCommodityCategoryLike(String value) {
            addCriterion("commodity_category like", value, "commodityCategory");
            return (Criteria) this;
        }

        public Criteria andCommodityCategoryNotLike(String value) {
            addCriterion("commodity_category not like", value, "commodityCategory");
            return (Criteria) this;
        }

        public Criteria andCommodityCategoryIn(List<String> values) {
            addCriterion("commodity_category in", values, "commodityCategory");
            return (Criteria) this;
        }

        public Criteria andCommodityCategoryNotIn(List<String> values) {
            addCriterion("commodity_category not in", values, "commodityCategory");
            return (Criteria) this;
        }

        public Criteria andCommodityCategoryBetween(String value1, String value2) {
            addCriterion("commodity_category between", value1, value2, "commodityCategory");
            return (Criteria) this;
        }

        public Criteria andCommodityCategoryNotBetween(String value1, String value2) {
            addCriterion("commodity_category not between", value1, value2, "commodityCategory");
            return (Criteria) this;
        }

        public Criteria andApplicationNumberIsNull() {
            addCriterion("application_number is null");
            return (Criteria) this;
        }

        public Criteria andApplicationNumberIsNotNull() {
            addCriterion("application_number is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationNumberEqualTo(String value) {
            addCriterion("application_number =", value, "applicationNumber");
            return (Criteria) this;
        }

        public Criteria andApplicationNumberNotEqualTo(String value) {
            addCriterion("application_number <>", value, "applicationNumber");
            return (Criteria) this;
        }

        public Criteria andApplicationNumberGreaterThan(String value) {
            addCriterion("application_number >", value, "applicationNumber");
            return (Criteria) this;
        }

        public Criteria andApplicationNumberGreaterThanOrEqualTo(String value) {
            addCriterion("application_number >=", value, "applicationNumber");
            return (Criteria) this;
        }

        public Criteria andApplicationNumberLessThan(String value) {
            addCriterion("application_number <", value, "applicationNumber");
            return (Criteria) this;
        }

        public Criteria andApplicationNumberLessThanOrEqualTo(String value) {
            addCriterion("application_number <=", value, "applicationNumber");
            return (Criteria) this;
        }

        public Criteria andApplicationNumberLike(String value) {
            addCriterion("application_number like", value, "applicationNumber");
            return (Criteria) this;
        }

        public Criteria andApplicationNumberNotLike(String value) {
            addCriterion("application_number not like", value, "applicationNumber");
            return (Criteria) this;
        }

        public Criteria andApplicationNumberIn(List<String> values) {
            addCriterion("application_number in", values, "applicationNumber");
            return (Criteria) this;
        }

        public Criteria andApplicationNumberNotIn(List<String> values) {
            addCriterion("application_number not in", values, "applicationNumber");
            return (Criteria) this;
        }

        public Criteria andApplicationNumberBetween(String value1, String value2) {
            addCriterion("application_number between", value1, value2, "applicationNumber");
            return (Criteria) this;
        }

        public Criteria andApplicationNumberNotBetween(String value1, String value2) {
            addCriterion("application_number not between", value1, value2, "applicationNumber");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateIsNull() {
            addCriterion("effective_date is null");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateIsNotNull() {
            addCriterion("effective_date is not null");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateEqualTo(Date value) {
            addCriterion("effective_date =", value, "effectiveDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateNotEqualTo(Date value) {
            addCriterion("effective_date <>", value, "effectiveDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateGreaterThan(Date value) {
            addCriterion("effective_date >", value, "effectiveDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateGreaterThanOrEqualTo(Date value) {
            addCriterion("effective_date >=", value, "effectiveDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateLessThan(Date value) {
            addCriterion("effective_date <", value, "effectiveDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateLessThanOrEqualTo(Date value) {
            addCriterion("effective_date <=", value, "effectiveDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateIn(List<Date> values) {
            addCriterion("effective_date in", values, "effectiveDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateNotIn(List<Date> values) {
            addCriterion("effective_date not in", values, "effectiveDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateBetween(Date value1, Date value2) {
            addCriterion("effective_date between", value1, value2, "effectiveDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateNotBetween(Date value1, Date value2) {
            addCriterion("effective_date not between", value1, value2, "effectiveDate");
            return (Criteria) this;
        }

        public Criteria andRegisterNoticeDateIsNull() {
            addCriterion("register_notice_date is null");
            return (Criteria) this;
        }

        public Criteria andRegisterNoticeDateIsNotNull() {
            addCriterion("register_notice_date is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterNoticeDateEqualTo(Date value) {
            addCriterion("register_notice_date =", value, "registerNoticeDate");
            return (Criteria) this;
        }

        public Criteria andRegisterNoticeDateNotEqualTo(Date value) {
            addCriterion("register_notice_date <>", value, "registerNoticeDate");
            return (Criteria) this;
        }

        public Criteria andRegisterNoticeDateGreaterThan(Date value) {
            addCriterion("register_notice_date >", value, "registerNoticeDate");
            return (Criteria) this;
        }

        public Criteria andRegisterNoticeDateGreaterThanOrEqualTo(Date value) {
            addCriterion("register_notice_date >=", value, "registerNoticeDate");
            return (Criteria) this;
        }

        public Criteria andRegisterNoticeDateLessThan(Date value) {
            addCriterion("register_notice_date <", value, "registerNoticeDate");
            return (Criteria) this;
        }

        public Criteria andRegisterNoticeDateLessThanOrEqualTo(Date value) {
            addCriterion("register_notice_date <=", value, "registerNoticeDate");
            return (Criteria) this;
        }

        public Criteria andRegisterNoticeDateIn(List<Date> values) {
            addCriterion("register_notice_date in", values, "registerNoticeDate");
            return (Criteria) this;
        }

        public Criteria andRegisterNoticeDateNotIn(List<Date> values) {
            addCriterion("register_notice_date not in", values, "registerNoticeDate");
            return (Criteria) this;
        }

        public Criteria andRegisterNoticeDateBetween(Date value1, Date value2) {
            addCriterion("register_notice_date between", value1, value2, "registerNoticeDate");
            return (Criteria) this;
        }

        public Criteria andRegisterNoticeDateNotBetween(Date value1, Date value2) {
            addCriterion("register_notice_date not between", value1, value2, "registerNoticeDate");
            return (Criteria) this;
        }

        public Criteria andEntryPersonIsNull() {
            addCriterion("entry_person is null");
            return (Criteria) this;
        }

        public Criteria andEntryPersonIsNotNull() {
            addCriterion("entry_person is not null");
            return (Criteria) this;
        }

        public Criteria andEntryPersonEqualTo(String value) {
            addCriterion("entry_person =", value, "entryPerson");
            return (Criteria) this;
        }

        public Criteria andEntryPersonNotEqualTo(String value) {
            addCriterion("entry_person <>", value, "entryPerson");
            return (Criteria) this;
        }

        public Criteria andEntryPersonGreaterThan(String value) {
            addCriterion("entry_person >", value, "entryPerson");
            return (Criteria) this;
        }

        public Criteria andEntryPersonGreaterThanOrEqualTo(String value) {
            addCriterion("entry_person >=", value, "entryPerson");
            return (Criteria) this;
        }

        public Criteria andEntryPersonLessThan(String value) {
            addCriterion("entry_person <", value, "entryPerson");
            return (Criteria) this;
        }

        public Criteria andEntryPersonLessThanOrEqualTo(String value) {
            addCriterion("entry_person <=", value, "entryPerson");
            return (Criteria) this;
        }

        public Criteria andEntryPersonLike(String value) {
            addCriterion("entry_person like", value, "entryPerson");
            return (Criteria) this;
        }

        public Criteria andEntryPersonNotLike(String value) {
            addCriterion("entry_person not like", value, "entryPerson");
            return (Criteria) this;
        }

        public Criteria andEntryPersonIn(List<String> values) {
            addCriterion("entry_person in", values, "entryPerson");
            return (Criteria) this;
        }

        public Criteria andEntryPersonNotIn(List<String> values) {
            addCriterion("entry_person not in", values, "entryPerson");
            return (Criteria) this;
        }

        public Criteria andEntryPersonBetween(String value1, String value2) {
            addCriterion("entry_person between", value1, value2, "entryPerson");
            return (Criteria) this;
        }

        public Criteria andEntryPersonNotBetween(String value1, String value2) {
            addCriterion("entry_person not between", value1, value2, "entryPerson");
            return (Criteria) this;
        }

        public Criteria andTrademarkNameIsNull() {
            addCriterion("trademark_name is null");
            return (Criteria) this;
        }

        public Criteria andTrademarkNameIsNotNull() {
            addCriterion("trademark_name is not null");
            return (Criteria) this;
        }

        public Criteria andTrademarkNameEqualTo(String value) {
            addCriterion("trademark_name =", value, "trademarkName");
            return (Criteria) this;
        }

        public Criteria andTrademarkNameNotEqualTo(String value) {
            addCriterion("trademark_name <>", value, "trademarkName");
            return (Criteria) this;
        }

        public Criteria andTrademarkNameGreaterThan(String value) {
            addCriterion("trademark_name >", value, "trademarkName");
            return (Criteria) this;
        }

        public Criteria andTrademarkNameGreaterThanOrEqualTo(String value) {
            addCriterion("trademark_name >=", value, "trademarkName");
            return (Criteria) this;
        }

        public Criteria andTrademarkNameLessThan(String value) {
            addCriterion("trademark_name <", value, "trademarkName");
            return (Criteria) this;
        }

        public Criteria andTrademarkNameLessThanOrEqualTo(String value) {
            addCriterion("trademark_name <=", value, "trademarkName");
            return (Criteria) this;
        }

        public Criteria andTrademarkNameLike(String value) {
            addCriterion("trademark_name like", value, "trademarkName");
            return (Criteria) this;
        }

        public Criteria andTrademarkNameNotLike(String value) {
            addCriterion("trademark_name not like", value, "trademarkName");
            return (Criteria) this;
        }

        public Criteria andTrademarkNameIn(List<String> values) {
            addCriterion("trademark_name in", values, "trademarkName");
            return (Criteria) this;
        }

        public Criteria andTrademarkNameNotIn(List<String> values) {
            addCriterion("trademark_name not in", values, "trademarkName");
            return (Criteria) this;
        }

        public Criteria andTrademarkNameBetween(String value1, String value2) {
            addCriterion("trademark_name between", value1, value2, "trademarkName");
            return (Criteria) this;
        }

        public Criteria andTrademarkNameNotBetween(String value1, String value2) {
            addCriterion("trademark_name not between", value1, value2, "trademarkName");
            return (Criteria) this;
        }

        public Criteria andApplicantIsNull() {
            addCriterion("applicant is null");
            return (Criteria) this;
        }

        public Criteria andApplicantIsNotNull() {
            addCriterion("applicant is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantEqualTo(String value) {
            addCriterion("applicant =", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotEqualTo(String value) {
            addCriterion("applicant <>", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantGreaterThan(String value) {
            addCriterion("applicant >", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantGreaterThanOrEqualTo(String value) {
            addCriterion("applicant >=", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLessThan(String value) {
            addCriterion("applicant <", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLessThanOrEqualTo(String value) {
            addCriterion("applicant <=", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLike(String value) {
            addCriterion("applicant like", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotLike(String value) {
            addCriterion("applicant not like", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantIn(List<String> values) {
            addCriterion("applicant in", values, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotIn(List<String> values) {
            addCriterion("applicant not in", values, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantBetween(String value1, String value2) {
            addCriterion("applicant between", value1, value2, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotBetween(String value1, String value2) {
            addCriterion("applicant not between", value1, value2, "applicant");
            return (Criteria) this;
        }

        public Criteria andRegisterDateIsNull() {
            addCriterion("register_date is null");
            return (Criteria) this;
        }

        public Criteria andRegisterDateIsNotNull() {
            addCriterion("register_date is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterDateEqualTo(Date value) {
            addCriterion("register_date =", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateNotEqualTo(Date value) {
            addCriterion("register_date <>", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateGreaterThan(Date value) {
            addCriterion("register_date >", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateGreaterThanOrEqualTo(Date value) {
            addCriterion("register_date >=", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateLessThan(Date value) {
            addCriterion("register_date <", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateLessThanOrEqualTo(Date value) {
            addCriterion("register_date <=", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateIn(List<Date> values) {
            addCriterion("register_date in", values, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateNotIn(List<Date> values) {
            addCriterion("register_date not in", values, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateBetween(Date value1, Date value2) {
            addCriterion("register_date between", value1, value2, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateNotBetween(Date value1, Date value2) {
            addCriterion("register_date not between", value1, value2, "registerDate");
            return (Criteria) this;
        }

        public Criteria andLawStatusIsNull() {
            addCriterion("law_status is null");
            return (Criteria) this;
        }

        public Criteria andLawStatusIsNotNull() {
            addCriterion("law_status is not null");
            return (Criteria) this;
        }

        public Criteria andLawStatusEqualTo(String value) {
            addCriterion("law_status =", value, "lawStatus");
            return (Criteria) this;
        }

        public Criteria andLawStatusNotEqualTo(String value) {
            addCriterion("law_status <>", value, "lawStatus");
            return (Criteria) this;
        }

        public Criteria andLawStatusGreaterThan(String value) {
            addCriterion("law_status >", value, "lawStatus");
            return (Criteria) this;
        }

        public Criteria andLawStatusGreaterThanOrEqualTo(String value) {
            addCriterion("law_status >=", value, "lawStatus");
            return (Criteria) this;
        }

        public Criteria andLawStatusLessThan(String value) {
            addCriterion("law_status <", value, "lawStatus");
            return (Criteria) this;
        }

        public Criteria andLawStatusLessThanOrEqualTo(String value) {
            addCriterion("law_status <=", value, "lawStatus");
            return (Criteria) this;
        }

        public Criteria andLawStatusLike(String value) {
            addCriterion("law_status like", value, "lawStatus");
            return (Criteria) this;
        }

        public Criteria andLawStatusNotLike(String value) {
            addCriterion("law_status not like", value, "lawStatus");
            return (Criteria) this;
        }

        public Criteria andLawStatusIn(List<String> values) {
            addCriterion("law_status in", values, "lawStatus");
            return (Criteria) this;
        }

        public Criteria andLawStatusNotIn(List<String> values) {
            addCriterion("law_status not in", values, "lawStatus");
            return (Criteria) this;
        }

        public Criteria andLawStatusBetween(String value1, String value2) {
            addCriterion("law_status between", value1, value2, "lawStatus");
            return (Criteria) this;
        }

        public Criteria andLawStatusNotBetween(String value1, String value2) {
            addCriterion("law_status not between", value1, value2, "lawStatus");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andEntryDateIsNull() {
            addCriterion("entry_date is null");
            return (Criteria) this;
        }

        public Criteria andEntryDateIsNotNull() {
            addCriterion("entry_date is not null");
            return (Criteria) this;
        }

        public Criteria andEntryDateEqualTo(Date value) {
            addCriterion("entry_date =", value, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateNotEqualTo(Date value) {
            addCriterion("entry_date <>", value, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateGreaterThan(Date value) {
            addCriterion("entry_date >", value, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateGreaterThanOrEqualTo(Date value) {
            addCriterion("entry_date >=", value, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateLessThan(Date value) {
            addCriterion("entry_date <", value, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateLessThanOrEqualTo(Date value) {
            addCriterion("entry_date <=", value, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateIn(List<Date> values) {
            addCriterion("entry_date in", values, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateNotIn(List<Date> values) {
            addCriterion("entry_date not in", values, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateBetween(Date value1, Date value2) {
            addCriterion("entry_date between", value1, value2, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateNotBetween(Date value1, Date value2) {
            addCriterion("entry_date not between", value1, value2, "entryDate");
            return (Criteria) this;
        }

        public Criteria andFileIsNull() {
            addCriterion("file is null");
            return (Criteria) this;
        }

        public Criteria andFileIsNotNull() {
            addCriterion("file is not null");
            return (Criteria) this;
        }

        public Criteria andFileEqualTo(String value) {
            addCriterion("file =", value, "file");
            return (Criteria) this;
        }

        public Criteria andFileNotEqualTo(String value) {
            addCriterion("file <>", value, "file");
            return (Criteria) this;
        }

        public Criteria andFileGreaterThan(String value) {
            addCriterion("file >", value, "file");
            return (Criteria) this;
        }

        public Criteria andFileGreaterThanOrEqualTo(String value) {
            addCriterion("file >=", value, "file");
            return (Criteria) this;
        }

        public Criteria andFileLessThan(String value) {
            addCriterion("file <", value, "file");
            return (Criteria) this;
        }

        public Criteria andFileLessThanOrEqualTo(String value) {
            addCriterion("file <=", value, "file");
            return (Criteria) this;
        }

        public Criteria andFileLike(String value) {
            addCriterion("file like", value, "file");
            return (Criteria) this;
        }

        public Criteria andFileNotLike(String value) {
            addCriterion("file not like", value, "file");
            return (Criteria) this;
        }

        public Criteria andFileIn(List<String> values) {
            addCriterion("file in", values, "file");
            return (Criteria) this;
        }

        public Criteria andFileNotIn(List<String> values) {
            addCriterion("file not in", values, "file");
            return (Criteria) this;
        }

        public Criteria andFileBetween(String value1, String value2) {
            addCriterion("file between", value1, value2, "file");
            return (Criteria) this;
        }

        public Criteria andFileNotBetween(String value1, String value2) {
            addCriterion("file not between", value1, value2, "file");
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