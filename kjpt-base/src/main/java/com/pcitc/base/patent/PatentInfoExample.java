package com.pcitc.base.patent;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PatentInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public PatentInfoExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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

        public Criteria andPatentNameIsNull() {
            addCriterion("patent_name is null");
            return (Criteria) this;
        }

        public Criteria andPatentNameIsNotNull() {
            addCriterion("patent_name is not null");
            return (Criteria) this;
        }

        public Criteria andPatentNameEqualTo(String value) {
            addCriterion("patent_name =", value, "patentName");
            return (Criteria) this;
        }

        public Criteria andPatentNameNotEqualTo(String value) {
            addCriterion("patent_name <>", value, "patentName");
            return (Criteria) this;
        }

        public Criteria andPatentNameGreaterThan(String value) {
            addCriterion("patent_name >", value, "patentName");
            return (Criteria) this;
        }

        public Criteria andPatentNameGreaterThanOrEqualTo(String value) {
            addCriterion("patent_name >=", value, "patentName");
            return (Criteria) this;
        }

        public Criteria andPatentNameLessThan(String value) {
            addCriterion("patent_name <", value, "patentName");
            return (Criteria) this;
        }

        public Criteria andPatentNameLessThanOrEqualTo(String value) {
            addCriterion("patent_name <=", value, "patentName");
            return (Criteria) this;
        }

        public Criteria andPatentNameLike(String value) {
            addCriterion("patent_name like", value, "patentName");
            return (Criteria) this;
        }

        public Criteria andPatentNameNotLike(String value) {
            addCriterion("patent_name not like", value, "patentName");
            return (Criteria) this;
        }

        public Criteria andPatentNameIn(List<String> values) {
            addCriterion("patent_name in", values, "patentName");
            return (Criteria) this;
        }

        public Criteria andPatentNameNotIn(List<String> values) {
            addCriterion("patent_name not in", values, "patentName");
            return (Criteria) this;
        }

        public Criteria andPatentNameBetween(String value1, String value2) {
            addCriterion("patent_name between", value1, value2, "patentName");
            return (Criteria) this;
        }

        public Criteria andPatentNameNotBetween(String value1, String value2) {
            addCriterion("patent_name not between", value1, value2, "patentName");
            return (Criteria) this;
        }

        public Criteria andInventorIsNull() {
            addCriterion("inventor is null");
            return (Criteria) this;
        }

        public Criteria andInventorIsNotNull() {
            addCriterion("inventor is not null");
            return (Criteria) this;
        }

        public Criteria andInventorEqualTo(String value) {
            addCriterion("inventor =", value, "inventor");
            return (Criteria) this;
        }

        public Criteria andInventorNotEqualTo(String value) {
            addCriterion("inventor <>", value, "inventor");
            return (Criteria) this;
        }

        public Criteria andInventorGreaterThan(String value) {
            addCriterion("inventor >", value, "inventor");
            return (Criteria) this;
        }

        public Criteria andInventorGreaterThanOrEqualTo(String value) {
            addCriterion("inventor >=", value, "inventor");
            return (Criteria) this;
        }

        public Criteria andInventorLessThan(String value) {
            addCriterion("inventor <", value, "inventor");
            return (Criteria) this;
        }

        public Criteria andInventorLessThanOrEqualTo(String value) {
            addCriterion("inventor <=", value, "inventor");
            return (Criteria) this;
        }

        public Criteria andInventorLike(String value) {
            addCriterion("inventor like", value, "inventor");
            return (Criteria) this;
        }

        public Criteria andInventorNotLike(String value) {
            addCriterion("inventor not like", value, "inventor");
            return (Criteria) this;
        }

        public Criteria andInventorIn(List<String> values) {
            addCriterion("inventor in", values, "inventor");
            return (Criteria) this;
        }

        public Criteria andInventorNotIn(List<String> values) {
            addCriterion("inventor not in", values, "inventor");
            return (Criteria) this;
        }

        public Criteria andInventorBetween(String value1, String value2) {
            addCriterion("inventor between", value1, value2, "inventor");
            return (Criteria) this;
        }

        public Criteria andInventorNotBetween(String value1, String value2) {
            addCriterion("inventor not between", value1, value2, "inventor");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeIsNull() {
            addCriterion("application_type is null");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeIsNotNull() {
            addCriterion("application_type is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeEqualTo(String value) {
            addCriterion("application_type =", value, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeNotEqualTo(String value) {
            addCriterion("application_type <>", value, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeGreaterThan(String value) {
            addCriterion("application_type >", value, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeGreaterThanOrEqualTo(String value) {
            addCriterion("application_type >=", value, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeLessThan(String value) {
            addCriterion("application_type <", value, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeLessThanOrEqualTo(String value) {
            addCriterion("application_type <=", value, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeLike(String value) {
            addCriterion("application_type like", value, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeNotLike(String value) {
            addCriterion("application_type not like", value, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeIn(List<String> values) {
            addCriterion("application_type in", values, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeNotIn(List<String> values) {
            addCriterion("application_type not in", values, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeBetween(String value1, String value2) {
            addCriterion("application_type between", value1, value2, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeNotBetween(String value1, String value2) {
            addCriterion("application_type not between", value1, value2, "applicationType");
            return (Criteria) this;
        }

        public Criteria andPatentTypeIsNull() {
            addCriterion("patent_type is null");
            return (Criteria) this;
        }

        public Criteria andPatentTypeIsNotNull() {
            addCriterion("patent_type is not null");
            return (Criteria) this;
        }

        public Criteria andPatentTypeEqualTo(String value) {
            addCriterion("patent_type =", value, "patentType");
            return (Criteria) this;
        }

        public Criteria andPatentTypeNotEqualTo(String value) {
            addCriterion("patent_type <>", value, "patentType");
            return (Criteria) this;
        }

        public Criteria andPatentTypeGreaterThan(String value) {
            addCriterion("patent_type >", value, "patentType");
            return (Criteria) this;
        }

        public Criteria andPatentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("patent_type >=", value, "patentType");
            return (Criteria) this;
        }

        public Criteria andPatentTypeLessThan(String value) {
            addCriterion("patent_type <", value, "patentType");
            return (Criteria) this;
        }

        public Criteria andPatentTypeLessThanOrEqualTo(String value) {
            addCriterion("patent_type <=", value, "patentType");
            return (Criteria) this;
        }

        public Criteria andPatentTypeLike(String value) {
            addCriterion("patent_type like", value, "patentType");
            return (Criteria) this;
        }

        public Criteria andPatentTypeNotLike(String value) {
            addCriterion("patent_type not like", value, "patentType");
            return (Criteria) this;
        }

        public Criteria andPatentTypeIn(List<String> values) {
            addCriterion("patent_type in", values, "patentType");
            return (Criteria) this;
        }

        public Criteria andPatentTypeNotIn(List<String> values) {
            addCriterion("patent_type not in", values, "patentType");
            return (Criteria) this;
        }

        public Criteria andPatentTypeBetween(String value1, String value2) {
            addCriterion("patent_type between", value1, value2, "patentType");
            return (Criteria) this;
        }

        public Criteria andPatentTypeNotBetween(String value1, String value2) {
            addCriterion("patent_type not between", value1, value2, "patentType");
            return (Criteria) this;
        }

        public Criteria andLegalStatusIsNull() {
            addCriterion("legal_status is null");
            return (Criteria) this;
        }

        public Criteria andLegalStatusIsNotNull() {
            addCriterion("legal_status is not null");
            return (Criteria) this;
        }

        public Criteria andLegalStatusEqualTo(String value) {
            addCriterion("legal_status =", value, "legalStatus");
            return (Criteria) this;
        }

        public Criteria andLegalStatusNotEqualTo(String value) {
            addCriterion("legal_status <>", value, "legalStatus");
            return (Criteria) this;
        }

        public Criteria andLegalStatusGreaterThan(String value) {
            addCriterion("legal_status >", value, "legalStatus");
            return (Criteria) this;
        }

        public Criteria andLegalStatusGreaterThanOrEqualTo(String value) {
            addCriterion("legal_status >=", value, "legalStatus");
            return (Criteria) this;
        }

        public Criteria andLegalStatusLessThan(String value) {
            addCriterion("legal_status <", value, "legalStatus");
            return (Criteria) this;
        }

        public Criteria andLegalStatusLessThanOrEqualTo(String value) {
            addCriterion("legal_status <=", value, "legalStatus");
            return (Criteria) this;
        }

        public Criteria andLegalStatusLike(String value) {
            addCriterion("legal_status like", value, "legalStatus");
            return (Criteria) this;
        }

        public Criteria andLegalStatusNotLike(String value) {
            addCriterion("legal_status not like", value, "legalStatus");
            return (Criteria) this;
        }

        public Criteria andLegalStatusIn(List<String> values) {
            addCriterion("legal_status in", values, "legalStatus");
            return (Criteria) this;
        }

        public Criteria andLegalStatusNotIn(List<String> values) {
            addCriterion("legal_status not in", values, "legalStatus");
            return (Criteria) this;
        }

        public Criteria andLegalStatusBetween(String value1, String value2) {
            addCriterion("legal_status between", value1, value2, "legalStatus");
            return (Criteria) this;
        }

        public Criteria andLegalStatusNotBetween(String value1, String value2) {
            addCriterion("legal_status not between", value1, value2, "legalStatus");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Date value) {
            addCriterion("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterion("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterion("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterion("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterion("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterion("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterion("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterion("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterion("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterion("date not between", value1, value2, "date");
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

        public Criteria andPatentRangeIsNull() {
            addCriterion("patent_range is null");
            return (Criteria) this;
        }

        public Criteria andPatentRangeIsNotNull() {
            addCriterion("patent_range is not null");
            return (Criteria) this;
        }

        public Criteria andPatentRangeEqualTo(String value) {
            addCriterion("patent_range =", value, "patentRange");
            return (Criteria) this;
        }

        public Criteria andPatentRangeNotEqualTo(String value) {
            addCriterion("patent_range <>", value, "patentRange");
            return (Criteria) this;
        }

        public Criteria andPatentRangeGreaterThan(String value) {
            addCriterion("patent_range >", value, "patentRange");
            return (Criteria) this;
        }

        public Criteria andPatentRangeGreaterThanOrEqualTo(String value) {
            addCriterion("patent_range >=", value, "patentRange");
            return (Criteria) this;
        }

        public Criteria andPatentRangeLessThan(String value) {
            addCriterion("patent_range <", value, "patentRange");
            return (Criteria) this;
        }

        public Criteria andPatentRangeLessThanOrEqualTo(String value) {
            addCriterion("patent_range <=", value, "patentRange");
            return (Criteria) this;
        }

        public Criteria andPatentRangeLike(String value) {
            addCriterion("patent_range like", value, "patentRange");
            return (Criteria) this;
        }

        public Criteria andPatentRangeNotLike(String value) {
            addCriterion("patent_range not like", value, "patentRange");
            return (Criteria) this;
        }

        public Criteria andPatentRangeIn(List<String> values) {
            addCriterion("patent_range in", values, "patentRange");
            return (Criteria) this;
        }

        public Criteria andPatentRangeNotIn(List<String> values) {
            addCriterion("patent_range not in", values, "patentRange");
            return (Criteria) this;
        }

        public Criteria andPatentRangeBetween(String value1, String value2) {
            addCriterion("patent_range between", value1, value2, "patentRange");
            return (Criteria) this;
        }

        public Criteria andPatentRangeNotBetween(String value1, String value2) {
            addCriterion("patent_range not between", value1, value2, "patentRange");
            return (Criteria) this;
        }

        public Criteria andAgencyIsNull() {
            addCriterion("agency is null");
            return (Criteria) this;
        }

        public Criteria andAgencyIsNotNull() {
            addCriterion("agency is not null");
            return (Criteria) this;
        }

        public Criteria andAgencyEqualTo(String value) {
            addCriterion("agency =", value, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyNotEqualTo(String value) {
            addCriterion("agency <>", value, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyGreaterThan(String value) {
            addCriterion("agency >", value, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyGreaterThanOrEqualTo(String value) {
            addCriterion("agency >=", value, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyLessThan(String value) {
            addCriterion("agency <", value, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyLessThanOrEqualTo(String value) {
            addCriterion("agency <=", value, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyLike(String value) {
            addCriterion("agency like", value, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyNotLike(String value) {
            addCriterion("agency not like", value, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyIn(List<String> values) {
            addCriterion("agency in", values, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyNotIn(List<String> values) {
            addCriterion("agency not in", values, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyBetween(String value1, String value2) {
            addCriterion("agency between", value1, value2, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyNotBetween(String value1, String value2) {
            addCriterion("agency not between", value1, value2, "agency");
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

        public Criteria andApplicationDateIsNull() {
            addCriterion("application_date is null");
            return (Criteria) this;
        }

        public Criteria andApplicationDateIsNotNull() {
            addCriterion("application_date is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationDateEqualTo(Date value) {
            addCriterion("application_date =", value, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateNotEqualTo(Date value) {
            addCriterion("application_date <>", value, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateGreaterThan(Date value) {
            addCriterion("application_date >", value, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateGreaterThanOrEqualTo(Date value) {
            addCriterion("application_date >=", value, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateLessThan(Date value) {
            addCriterion("application_date <", value, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateLessThanOrEqualTo(Date value) {
            addCriterion("application_date <=", value, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateIn(List<Date> values) {
            addCriterion("application_date in", values, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateNotIn(List<Date> values) {
            addCriterion("application_date not in", values, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateBetween(Date value1, Date value2) {
            addCriterion("application_date between", value1, value2, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateNotBetween(Date value1, Date value2) {
            addCriterion("application_date not between", value1, value2, "applicationDate");
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

        public Criteria andApplicationCostIsNull() {
            addCriterion("application_cost is null");
            return (Criteria) this;
        }

        public Criteria andApplicationCostIsNotNull() {
            addCriterion("application_cost is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationCostEqualTo(Long value) {
            addCriterion("application_cost =", value, "applicationCost");
            return (Criteria) this;
        }

        public Criteria andApplicationCostNotEqualTo(Long value) {
            addCriterion("application_cost <>", value, "applicationCost");
            return (Criteria) this;
        }

        public Criteria andApplicationCostGreaterThan(Long value) {
            addCriterion("application_cost >", value, "applicationCost");
            return (Criteria) this;
        }

        public Criteria andApplicationCostGreaterThanOrEqualTo(Long value) {
            addCriterion("application_cost >=", value, "applicationCost");
            return (Criteria) this;
        }

        public Criteria andApplicationCostLessThan(Long value) {
            addCriterion("application_cost <", value, "applicationCost");
            return (Criteria) this;
        }

        public Criteria andApplicationCostLessThanOrEqualTo(Long value) {
            addCriterion("application_cost <=", value, "applicationCost");
            return (Criteria) this;
        }

        public Criteria andApplicationCostIn(List<Long> values) {
            addCriterion("application_cost in", values, "applicationCost");
            return (Criteria) this;
        }

        public Criteria andApplicationCostNotIn(List<Long> values) {
            addCriterion("application_cost not in", values, "applicationCost");
            return (Criteria) this;
        }

        public Criteria andApplicationCostBetween(Long value1, Long value2) {
            addCriterion("application_cost between", value1, value2, "applicationCost");
            return (Criteria) this;
        }

        public Criteria andApplicationCostNotBetween(Long value1, Long value2) {
            addCriterion("application_cost not between", value1, value2, "applicationCost");
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

        public Criteria andSummaryIsNull() {
            addCriterion("summary is null");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNotNull() {
            addCriterion("summary is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryEqualTo(String value) {
            addCriterion("summary =", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotEqualTo(String value) {
            addCriterion("summary <>", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThan(String value) {
            addCriterion("summary >", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("summary >=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThan(String value) {
            addCriterion("summary <", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThanOrEqualTo(String value) {
            addCriterion("summary <=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLike(String value) {
            addCriterion("summary like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotLike(String value) {
            addCriterion("summary not like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryIn(List<String> values) {
            addCriterion("summary in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotIn(List<String> values) {
            addCriterion("summary not in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryBetween(String value1, String value2) {
            addCriterion("summary between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotBetween(String value1, String value2) {
            addCriterion("summary not between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andApplicationOfPatentTransformationIsNull() {
            addCriterion("application_of_patent_transformation is null");
            return (Criteria) this;
        }

        public Criteria andApplicationOfPatentTransformationIsNotNull() {
            addCriterion("application_of_patent_transformation is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationOfPatentTransformationEqualTo(String value) {
            addCriterion("application_of_patent_transformation =", value, "applicationOfPatentTransformation");
            return (Criteria) this;
        }

        public Criteria andApplicationOfPatentTransformationNotEqualTo(String value) {
            addCriterion("application_of_patent_transformation <>", value, "applicationOfPatentTransformation");
            return (Criteria) this;
        }

        public Criteria andApplicationOfPatentTransformationGreaterThan(String value) {
            addCriterion("application_of_patent_transformation >", value, "applicationOfPatentTransformation");
            return (Criteria) this;
        }

        public Criteria andApplicationOfPatentTransformationGreaterThanOrEqualTo(String value) {
            addCriterion("application_of_patent_transformation >=", value, "applicationOfPatentTransformation");
            return (Criteria) this;
        }

        public Criteria andApplicationOfPatentTransformationLessThan(String value) {
            addCriterion("application_of_patent_transformation <", value, "applicationOfPatentTransformation");
            return (Criteria) this;
        }

        public Criteria andApplicationOfPatentTransformationLessThanOrEqualTo(String value) {
            addCriterion("application_of_patent_transformation <=", value, "applicationOfPatentTransformation");
            return (Criteria) this;
        }

        public Criteria andApplicationOfPatentTransformationLike(String value) {
            addCriterion("application_of_patent_transformation like", value, "applicationOfPatentTransformation");
            return (Criteria) this;
        }

        public Criteria andApplicationOfPatentTransformationNotLike(String value) {
            addCriterion("application_of_patent_transformation not like", value, "applicationOfPatentTransformation");
            return (Criteria) this;
        }

        public Criteria andApplicationOfPatentTransformationIn(List<String> values) {
            addCriterion("application_of_patent_transformation in", values, "applicationOfPatentTransformation");
            return (Criteria) this;
        }

        public Criteria andApplicationOfPatentTransformationNotIn(List<String> values) {
            addCriterion("application_of_patent_transformation not in", values, "applicationOfPatentTransformation");
            return (Criteria) this;
        }

        public Criteria andApplicationOfPatentTransformationBetween(String value1, String value2) {
            addCriterion("application_of_patent_transformation between", value1, value2, "applicationOfPatentTransformation");
            return (Criteria) this;
        }

        public Criteria andApplicationOfPatentTransformationNotBetween(String value1, String value2) {
            addCriterion("application_of_patent_transformation not between", value1, value2, "applicationOfPatentTransformation");
            return (Criteria) this;
        }

        public Criteria andMajorApplicationIsNull() {
            addCriterion("major_application is null");
            return (Criteria) this;
        }

        public Criteria andMajorApplicationIsNotNull() {
            addCriterion("major_application is not null");
            return (Criteria) this;
        }

        public Criteria andMajorApplicationEqualTo(String value) {
            addCriterion("major_application =", value, "majorApplication");
            return (Criteria) this;
        }

        public Criteria andMajorApplicationNotEqualTo(String value) {
            addCriterion("major_application <>", value, "majorApplication");
            return (Criteria) this;
        }

        public Criteria andMajorApplicationGreaterThan(String value) {
            addCriterion("major_application >", value, "majorApplication");
            return (Criteria) this;
        }

        public Criteria andMajorApplicationGreaterThanOrEqualTo(String value) {
            addCriterion("major_application >=", value, "majorApplication");
            return (Criteria) this;
        }

        public Criteria andMajorApplicationLessThan(String value) {
            addCriterion("major_application <", value, "majorApplication");
            return (Criteria) this;
        }

        public Criteria andMajorApplicationLessThanOrEqualTo(String value) {
            addCriterion("major_application <=", value, "majorApplication");
            return (Criteria) this;
        }

        public Criteria andMajorApplicationLike(String value) {
            addCriterion("major_application like", value, "majorApplication");
            return (Criteria) this;
        }

        public Criteria andMajorApplicationNotLike(String value) {
            addCriterion("major_application not like", value, "majorApplication");
            return (Criteria) this;
        }

        public Criteria andMajorApplicationIn(List<String> values) {
            addCriterion("major_application in", values, "majorApplication");
            return (Criteria) this;
        }

        public Criteria andMajorApplicationNotIn(List<String> values) {
            addCriterion("major_application not in", values, "majorApplication");
            return (Criteria) this;
        }

        public Criteria andMajorApplicationBetween(String value1, String value2) {
            addCriterion("major_application between", value1, value2, "majorApplication");
            return (Criteria) this;
        }

        public Criteria andMajorApplicationNotBetween(String value1, String value2) {
            addCriterion("major_application not between", value1, value2, "majorApplication");
            return (Criteria) this;
        }

        public Criteria andUnenforcedReasonIsNull() {
            addCriterion("unenforced_reason is null");
            return (Criteria) this;
        }

        public Criteria andUnenforcedReasonIsNotNull() {
            addCriterion("unenforced_reason is not null");
            return (Criteria) this;
        }

        public Criteria andUnenforcedReasonEqualTo(String value) {
            addCriterion("unenforced_reason =", value, "unenforcedReason");
            return (Criteria) this;
        }

        public Criteria andUnenforcedReasonNotEqualTo(String value) {
            addCriterion("unenforced_reason <>", value, "unenforcedReason");
            return (Criteria) this;
        }

        public Criteria andUnenforcedReasonGreaterThan(String value) {
            addCriterion("unenforced_reason >", value, "unenforcedReason");
            return (Criteria) this;
        }

        public Criteria andUnenforcedReasonGreaterThanOrEqualTo(String value) {
            addCriterion("unenforced_reason >=", value, "unenforcedReason");
            return (Criteria) this;
        }

        public Criteria andUnenforcedReasonLessThan(String value) {
            addCriterion("unenforced_reason <", value, "unenforcedReason");
            return (Criteria) this;
        }

        public Criteria andUnenforcedReasonLessThanOrEqualTo(String value) {
            addCriterion("unenforced_reason <=", value, "unenforcedReason");
            return (Criteria) this;
        }

        public Criteria andUnenforcedReasonLike(String value) {
            addCriterion("unenforced_reason like", value, "unenforcedReason");
            return (Criteria) this;
        }

        public Criteria andUnenforcedReasonNotLike(String value) {
            addCriterion("unenforced_reason not like", value, "unenforcedReason");
            return (Criteria) this;
        }

        public Criteria andUnenforcedReasonIn(List<String> values) {
            addCriterion("unenforced_reason in", values, "unenforcedReason");
            return (Criteria) this;
        }

        public Criteria andUnenforcedReasonNotIn(List<String> values) {
            addCriterion("unenforced_reason not in", values, "unenforcedReason");
            return (Criteria) this;
        }

        public Criteria andUnenforcedReasonBetween(String value1, String value2) {
            addCriterion("unenforced_reason between", value1, value2, "unenforcedReason");
            return (Criteria) this;
        }

        public Criteria andUnenforcedReasonNotBetween(String value1, String value2) {
            addCriterion("unenforced_reason not between", value1, value2, "unenforcedReason");
            return (Criteria) this;
        }

        public Criteria andLicenseeIsNull() {
            addCriterion("licensee is null");
            return (Criteria) this;
        }

        public Criteria andLicenseeIsNotNull() {
            addCriterion("licensee is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseeEqualTo(String value) {
            addCriterion("licensee =", value, "licensee");
            return (Criteria) this;
        }

        public Criteria andLicenseeNotEqualTo(String value) {
            addCriterion("licensee <>", value, "licensee");
            return (Criteria) this;
        }

        public Criteria andLicenseeGreaterThan(String value) {
            addCriterion("licensee >", value, "licensee");
            return (Criteria) this;
        }

        public Criteria andLicenseeGreaterThanOrEqualTo(String value) {
            addCriterion("licensee >=", value, "licensee");
            return (Criteria) this;
        }

        public Criteria andLicenseeLessThan(String value) {
            addCriterion("licensee <", value, "licensee");
            return (Criteria) this;
        }

        public Criteria andLicenseeLessThanOrEqualTo(String value) {
            addCriterion("licensee <=", value, "licensee");
            return (Criteria) this;
        }

        public Criteria andLicenseeLike(String value) {
            addCriterion("licensee like", value, "licensee");
            return (Criteria) this;
        }

        public Criteria andLicenseeNotLike(String value) {
            addCriterion("licensee not like", value, "licensee");
            return (Criteria) this;
        }

        public Criteria andLicenseeIn(List<String> values) {
            addCriterion("licensee in", values, "licensee");
            return (Criteria) this;
        }

        public Criteria andLicenseeNotIn(List<String> values) {
            addCriterion("licensee not in", values, "licensee");
            return (Criteria) this;
        }

        public Criteria andLicenseeBetween(String value1, String value2) {
            addCriterion("licensee between", value1, value2, "licensee");
            return (Criteria) this;
        }

        public Criteria andLicenseeNotBetween(String value1, String value2) {
            addCriterion("licensee not between", value1, value2, "licensee");
            return (Criteria) this;
        }

        public Criteria andLicenseeModeIsNull() {
            addCriterion("licensee_mode is null");
            return (Criteria) this;
        }

        public Criteria andLicenseeModeIsNotNull() {
            addCriterion("licensee_mode is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseeModeEqualTo(String value) {
            addCriterion("licensee_mode =", value, "licenseeMode");
            return (Criteria) this;
        }

        public Criteria andLicenseeModeNotEqualTo(String value) {
            addCriterion("licensee_mode <>", value, "licenseeMode");
            return (Criteria) this;
        }

        public Criteria andLicenseeModeGreaterThan(String value) {
            addCriterion("licensee_mode >", value, "licenseeMode");
            return (Criteria) this;
        }

        public Criteria andLicenseeModeGreaterThanOrEqualTo(String value) {
            addCriterion("licensee_mode >=", value, "licenseeMode");
            return (Criteria) this;
        }

        public Criteria andLicenseeModeLessThan(String value) {
            addCriterion("licensee_mode <", value, "licenseeMode");
            return (Criteria) this;
        }

        public Criteria andLicenseeModeLessThanOrEqualTo(String value) {
            addCriterion("licensee_mode <=", value, "licenseeMode");
            return (Criteria) this;
        }

        public Criteria andLicenseeModeLike(String value) {
            addCriterion("licensee_mode like", value, "licenseeMode");
            return (Criteria) this;
        }

        public Criteria andLicenseeModeNotLike(String value) {
            addCriterion("licensee_mode not like", value, "licenseeMode");
            return (Criteria) this;
        }

        public Criteria andLicenseeModeIn(List<String> values) {
            addCriterion("licensee_mode in", values, "licenseeMode");
            return (Criteria) this;
        }

        public Criteria andLicenseeModeNotIn(List<String> values) {
            addCriterion("licensee_mode not in", values, "licenseeMode");
            return (Criteria) this;
        }

        public Criteria andLicenseeModeBetween(String value1, String value2) {
            addCriterion("licensee_mode between", value1, value2, "licenseeMode");
            return (Criteria) this;
        }

        public Criteria andLicenseeModeNotBetween(String value1, String value2) {
            addCriterion("licensee_mode not between", value1, value2, "licenseeMode");
            return (Criteria) this;
        }

        public Criteria andLicenseeProfitIsNull() {
            addCriterion("licensee_profit is null");
            return (Criteria) this;
        }

        public Criteria andLicenseeProfitIsNotNull() {
            addCriterion("licensee_profit is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseeProfitEqualTo(Long value) {
            addCriterion("licensee_profit =", value, "licenseeProfit");
            return (Criteria) this;
        }

        public Criteria andLicenseeProfitNotEqualTo(Long value) {
            addCriterion("licensee_profit <>", value, "licenseeProfit");
            return (Criteria) this;
        }

        public Criteria andLicenseeProfitGreaterThan(Long value) {
            addCriterion("licensee_profit >", value, "licenseeProfit");
            return (Criteria) this;
        }

        public Criteria andLicenseeProfitGreaterThanOrEqualTo(Long value) {
            addCriterion("licensee_profit >=", value, "licenseeProfit");
            return (Criteria) this;
        }

        public Criteria andLicenseeProfitLessThan(Long value) {
            addCriterion("licensee_profit <", value, "licenseeProfit");
            return (Criteria) this;
        }

        public Criteria andLicenseeProfitLessThanOrEqualTo(Long value) {
            addCriterion("licensee_profit <=", value, "licenseeProfit");
            return (Criteria) this;
        }

        public Criteria andLicenseeProfitIn(List<Long> values) {
            addCriterion("licensee_profit in", values, "licenseeProfit");
            return (Criteria) this;
        }

        public Criteria andLicenseeProfitNotIn(List<Long> values) {
            addCriterion("licensee_profit not in", values, "licenseeProfit");
            return (Criteria) this;
        }

        public Criteria andLicenseeProfitBetween(Long value1, Long value2) {
            addCriterion("licensee_profit between", value1, value2, "licenseeProfit");
            return (Criteria) this;
        }

        public Criteria andLicenseeProfitNotBetween(Long value1, Long value2) {
            addCriterion("licensee_profit not between", value1, value2, "licenseeProfit");
            return (Criteria) this;
        }

        public Criteria andAssignorIsNull() {
            addCriterion("assignor is null");
            return (Criteria) this;
        }

        public Criteria andAssignorIsNotNull() {
            addCriterion("assignor is not null");
            return (Criteria) this;
        }

        public Criteria andAssignorEqualTo(String value) {
            addCriterion("assignor =", value, "assignor");
            return (Criteria) this;
        }

        public Criteria andAssignorNotEqualTo(String value) {
            addCriterion("assignor <>", value, "assignor");
            return (Criteria) this;
        }

        public Criteria andAssignorGreaterThan(String value) {
            addCriterion("assignor >", value, "assignor");
            return (Criteria) this;
        }

        public Criteria andAssignorGreaterThanOrEqualTo(String value) {
            addCriterion("assignor >=", value, "assignor");
            return (Criteria) this;
        }

        public Criteria andAssignorLessThan(String value) {
            addCriterion("assignor <", value, "assignor");
            return (Criteria) this;
        }

        public Criteria andAssignorLessThanOrEqualTo(String value) {
            addCriterion("assignor <=", value, "assignor");
            return (Criteria) this;
        }

        public Criteria andAssignorLike(String value) {
            addCriterion("assignor like", value, "assignor");
            return (Criteria) this;
        }

        public Criteria andAssignorNotLike(String value) {
            addCriterion("assignor not like", value, "assignor");
            return (Criteria) this;
        }

        public Criteria andAssignorIn(List<String> values) {
            addCriterion("assignor in", values, "assignor");
            return (Criteria) this;
        }

        public Criteria andAssignorNotIn(List<String> values) {
            addCriterion("assignor not in", values, "assignor");
            return (Criteria) this;
        }

        public Criteria andAssignorBetween(String value1, String value2) {
            addCriterion("assignor between", value1, value2, "assignor");
            return (Criteria) this;
        }

        public Criteria andAssignorNotBetween(String value1, String value2) {
            addCriterion("assignor not between", value1, value2, "assignor");
            return (Criteria) this;
        }

        public Criteria andAssignProfitIsNull() {
            addCriterion("assign_profit is null");
            return (Criteria) this;
        }

        public Criteria andAssignProfitIsNotNull() {
            addCriterion("assign_profit is not null");
            return (Criteria) this;
        }

        public Criteria andAssignProfitEqualTo(Long value) {
            addCriterion("assign_profit =", value, "assignProfit");
            return (Criteria) this;
        }

        public Criteria andAssignProfitNotEqualTo(Long value) {
            addCriterion("assign_profit <>", value, "assignProfit");
            return (Criteria) this;
        }

        public Criteria andAssignProfitGreaterThan(Long value) {
            addCriterion("assign_profit >", value, "assignProfit");
            return (Criteria) this;
        }

        public Criteria andAssignProfitGreaterThanOrEqualTo(Long value) {
            addCriterion("assign_profit >=", value, "assignProfit");
            return (Criteria) this;
        }

        public Criteria andAssignProfitLessThan(Long value) {
            addCriterion("assign_profit <", value, "assignProfit");
            return (Criteria) this;
        }

        public Criteria andAssignProfitLessThanOrEqualTo(Long value) {
            addCriterion("assign_profit <=", value, "assignProfit");
            return (Criteria) this;
        }

        public Criteria andAssignProfitIn(List<Long> values) {
            addCriterion("assign_profit in", values, "assignProfit");
            return (Criteria) this;
        }

        public Criteria andAssignProfitNotIn(List<Long> values) {
            addCriterion("assign_profit not in", values, "assignProfit");
            return (Criteria) this;
        }

        public Criteria andAssignProfitBetween(Long value1, Long value2) {
            addCriterion("assign_profit between", value1, value2, "assignProfit");
            return (Criteria) this;
        }

        public Criteria andAssignProfitNotBetween(Long value1, Long value2) {
            addCriterion("assign_profit not between", value1, value2, "assignProfit");
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

        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("creator like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("creator not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("creator not between", value1, value2, "creator");
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

        public Criteria andUpdatorIsNull() {
            addCriterion("updator is null");
            return (Criteria) this;
        }

        public Criteria andUpdatorIsNotNull() {
            addCriterion("updator is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatorEqualTo(String value) {
            addCriterion("updator =", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorNotEqualTo(String value) {
            addCriterion("updator <>", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorGreaterThan(String value) {
            addCriterion("updator >", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorGreaterThanOrEqualTo(String value) {
            addCriterion("updator >=", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorLessThan(String value) {
            addCriterion("updator <", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorLessThanOrEqualTo(String value) {
            addCriterion("updator <=", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorLike(String value) {
            addCriterion("updator like", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorNotLike(String value) {
            addCriterion("updator not like", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorIn(List<String> values) {
            addCriterion("updator in", values, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorNotIn(List<String> values) {
            addCriterion("updator not in", values, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorBetween(String value1, String value2) {
            addCriterion("updator between", value1, value2, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorNotBetween(String value1, String value2) {
            addCriterion("updator not between", value1, value2, "updator");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("deleted is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("deleted is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(String value) {
            addCriterion("deleted =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(String value) {
            addCriterion("deleted <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(String value) {
            addCriterion("deleted >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(String value) {
            addCriterion("deleted >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(String value) {
            addCriterion("deleted <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(String value) {
            addCriterion("deleted <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLike(String value) {
            addCriterion("deleted like", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotLike(String value) {
            addCriterion("deleted not like", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<String> values) {
            addCriterion("deleted in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<String> values) {
            addCriterion("deleted not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(String value1, String value2) {
            addCriterion("deleted between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(String value1, String value2) {
            addCriterion("deleted not between", value1, value2, "deleted");
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