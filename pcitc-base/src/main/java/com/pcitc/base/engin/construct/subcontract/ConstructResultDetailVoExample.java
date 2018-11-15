package com.pcitc.base.engin.construct.subcontract;

import java.util.ArrayList;
import java.util.List;

public class ConstructResultDetailVoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public ConstructResultDetailVoExample() {
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

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
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

        public Criteria andDataIdIsNull() {
            addCriterion("data_id is null");
            return (Criteria) this;
        }

        public Criteria andDataIdIsNotNull() {
            addCriterion("data_id is not null");
            return (Criteria) this;
        }

        public Criteria andDataIdEqualTo(String value) {
            addCriterion("data_id =", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotEqualTo(String value) {
            addCriterion("data_id <>", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdGreaterThan(String value) {
            addCriterion("data_id >", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdGreaterThanOrEqualTo(String value) {
            addCriterion("data_id >=", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdLessThan(String value) {
            addCriterion("data_id <", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdLessThanOrEqualTo(String value) {
            addCriterion("data_id <=", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdLike(String value) {
            addCriterion("data_id like", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotLike(String value) {
            addCriterion("data_id not like", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdIn(List<String> values) {
            addCriterion("data_id in", values, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotIn(List<String> values) {
            addCriterion("data_id not in", values, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdBetween(String value1, String value2) {
            addCriterion("data_id between", value1, value2, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotBetween(String value1, String value2) {
            addCriterion("data_id not between", value1, value2, "dataId");
            return (Criteria) this;
        }

        public Criteria andResultIdIsNull() {
            addCriterion("result_id is null");
            return (Criteria) this;
        }

        public Criteria andResultIdIsNotNull() {
            addCriterion("result_id is not null");
            return (Criteria) this;
        }

        public Criteria andResultIdEqualTo(String value) {
            addCriterion("result_id =", value, "resultId");
            return (Criteria) this;
        }

        public Criteria andResultIdNotEqualTo(String value) {
            addCriterion("result_id <>", value, "resultId");
            return (Criteria) this;
        }

        public Criteria andResultIdGreaterThan(String value) {
            addCriterion("result_id >", value, "resultId");
            return (Criteria) this;
        }

        public Criteria andResultIdGreaterThanOrEqualTo(String value) {
            addCriterion("result_id >=", value, "resultId");
            return (Criteria) this;
        }

        public Criteria andResultIdLessThan(String value) {
            addCriterion("result_id <", value, "resultId");
            return (Criteria) this;
        }

        public Criteria andResultIdLessThanOrEqualTo(String value) {
            addCriterion("result_id <=", value, "resultId");
            return (Criteria) this;
        }

        public Criteria andResultIdLike(String value) {
            addCriterion("result_id like", value, "resultId");
            return (Criteria) this;
        }

        public Criteria andResultIdNotLike(String value) {
            addCriterion("result_id not like", value, "resultId");
            return (Criteria) this;
        }

        public Criteria andResultIdIn(List<String> values) {
            addCriterion("result_id in", values, "resultId");
            return (Criteria) this;
        }

        public Criteria andResultIdNotIn(List<String> values) {
            addCriterion("result_id not in", values, "resultId");
            return (Criteria) this;
        }

        public Criteria andResultIdBetween(String value1, String value2) {
            addCriterion("result_id between", value1, value2, "resultId");
            return (Criteria) this;
        }

        public Criteria andResultIdNotBetween(String value1, String value2) {
            addCriterion("result_id not between", value1, value2, "resultId");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("`type` is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("`type` is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("`type` =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("`type` <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("`type` >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("`type` >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("`type` <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("`type` <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("`type` like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("`type` not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("`type` in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("`type` not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("`type` between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("`type` not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Long value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Long value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Long value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Long value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Long value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Long> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Long> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Long value1, Long value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Long value1, Long value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andSendModeIsNull() {
            addCriterion("send_mode is null");
            return (Criteria) this;
        }

        public Criteria andSendModeIsNotNull() {
            addCriterion("send_mode is not null");
            return (Criteria) this;
        }

        public Criteria andSendModeEqualTo(String value) {
            addCriterion("send_mode =", value, "sendMode");
            return (Criteria) this;
        }

        public Criteria andSendModeNotEqualTo(String value) {
            addCriterion("send_mode <>", value, "sendMode");
            return (Criteria) this;
        }

        public Criteria andSendModeGreaterThan(String value) {
            addCriterion("send_mode >", value, "sendMode");
            return (Criteria) this;
        }

        public Criteria andSendModeGreaterThanOrEqualTo(String value) {
            addCriterion("send_mode >=", value, "sendMode");
            return (Criteria) this;
        }

        public Criteria andSendModeLessThan(String value) {
            addCriterion("send_mode <", value, "sendMode");
            return (Criteria) this;
        }

        public Criteria andSendModeLessThanOrEqualTo(String value) {
            addCriterion("send_mode <=", value, "sendMode");
            return (Criteria) this;
        }

        public Criteria andSendModeLike(String value) {
            addCriterion("send_mode like", value, "sendMode");
            return (Criteria) this;
        }

        public Criteria andSendModeNotLike(String value) {
            addCriterion("send_mode not like", value, "sendMode");
            return (Criteria) this;
        }

        public Criteria andSendModeIn(List<String> values) {
            addCriterion("send_mode in", values, "sendMode");
            return (Criteria) this;
        }

        public Criteria andSendModeNotIn(List<String> values) {
            addCriterion("send_mode not in", values, "sendMode");
            return (Criteria) this;
        }

        public Criteria andSendModeBetween(String value1, String value2) {
            addCriterion("send_mode between", value1, value2, "sendMode");
            return (Criteria) this;
        }

        public Criteria andSendModeNotBetween(String value1, String value2) {
            addCriterion("send_mode not between", value1, value2, "sendMode");
            return (Criteria) this;
        }

        public Criteria andOrgModeIsNull() {
            addCriterion("org_mode is null");
            return (Criteria) this;
        }

        public Criteria andOrgModeIsNotNull() {
            addCriterion("org_mode is not null");
            return (Criteria) this;
        }

        public Criteria andOrgModeEqualTo(String value) {
            addCriterion("org_mode =", value, "orgMode");
            return (Criteria) this;
        }

        public Criteria andOrgModeNotEqualTo(String value) {
            addCriterion("org_mode <>", value, "orgMode");
            return (Criteria) this;
        }

        public Criteria andOrgModeGreaterThan(String value) {
            addCriterion("org_mode >", value, "orgMode");
            return (Criteria) this;
        }

        public Criteria andOrgModeGreaterThanOrEqualTo(String value) {
            addCriterion("org_mode >=", value, "orgMode");
            return (Criteria) this;
        }

        public Criteria andOrgModeLessThan(String value) {
            addCriterion("org_mode <", value, "orgMode");
            return (Criteria) this;
        }

        public Criteria andOrgModeLessThanOrEqualTo(String value) {
            addCriterion("org_mode <=", value, "orgMode");
            return (Criteria) this;
        }

        public Criteria andOrgModeLike(String value) {
            addCriterion("org_mode like", value, "orgMode");
            return (Criteria) this;
        }

        public Criteria andOrgModeNotLike(String value) {
            addCriterion("org_mode not like", value, "orgMode");
            return (Criteria) this;
        }

        public Criteria andOrgModeIn(List<String> values) {
            addCriterion("org_mode in", values, "orgMode");
            return (Criteria) this;
        }

        public Criteria andOrgModeNotIn(List<String> values) {
            addCriterion("org_mode not in", values, "orgMode");
            return (Criteria) this;
        }

        public Criteria andOrgModeBetween(String value1, String value2) {
            addCriterion("org_mode between", value1, value2, "orgMode");
            return (Criteria) this;
        }

        public Criteria andOrgModeNotBetween(String value1, String value2) {
            addCriterion("org_mode not between", value1, value2, "orgMode");
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

        public Criteria andUnitQualifyIsNull() {
            addCriterion("unit_qualify is null");
            return (Criteria) this;
        }

        public Criteria andUnitQualifyIsNotNull() {
            addCriterion("unit_qualify is not null");
            return (Criteria) this;
        }

        public Criteria andUnitQualifyEqualTo(String value) {
            addCriterion("unit_qualify =", value, "unitQualify");
            return (Criteria) this;
        }

        public Criteria andUnitQualifyNotEqualTo(String value) {
            addCriterion("unit_qualify <>", value, "unitQualify");
            return (Criteria) this;
        }

        public Criteria andUnitQualifyGreaterThan(String value) {
            addCriterion("unit_qualify >", value, "unitQualify");
            return (Criteria) this;
        }

        public Criteria andUnitQualifyGreaterThanOrEqualTo(String value) {
            addCriterion("unit_qualify >=", value, "unitQualify");
            return (Criteria) this;
        }

        public Criteria andUnitQualifyLessThan(String value) {
            addCriterion("unit_qualify <", value, "unitQualify");
            return (Criteria) this;
        }

        public Criteria andUnitQualifyLessThanOrEqualTo(String value) {
            addCriterion("unit_qualify <=", value, "unitQualify");
            return (Criteria) this;
        }

        public Criteria andUnitQualifyLike(String value) {
            addCriterion("unit_qualify like", value, "unitQualify");
            return (Criteria) this;
        }

        public Criteria andUnitQualifyNotLike(String value) {
            addCriterion("unit_qualify not like", value, "unitQualify");
            return (Criteria) this;
        }

        public Criteria andUnitQualifyIn(List<String> values) {
            addCriterion("unit_qualify in", values, "unitQualify");
            return (Criteria) this;
        }

        public Criteria andUnitQualifyNotIn(List<String> values) {
            addCriterion("unit_qualify not in", values, "unitQualify");
            return (Criteria) this;
        }

        public Criteria andUnitQualifyBetween(String value1, String value2) {
            addCriterion("unit_qualify between", value1, value2, "unitQualify");
            return (Criteria) this;
        }

        public Criteria andUnitQualifyNotBetween(String value1, String value2) {
            addCriterion("unit_qualify not between", value1, value2, "unitQualify");
            return (Criteria) this;
        }

        public Criteria andCreditSystemCodeIsNull() {
            addCriterion("credit_system_code is null");
            return (Criteria) this;
        }

        public Criteria andCreditSystemCodeIsNotNull() {
            addCriterion("credit_system_code is not null");
            return (Criteria) this;
        }

        public Criteria andCreditSystemCodeEqualTo(String value) {
            addCriterion("credit_system_code =", value, "creditSystemCode");
            return (Criteria) this;
        }

        public Criteria andCreditSystemCodeNotEqualTo(String value) {
            addCriterion("credit_system_code <>", value, "creditSystemCode");
            return (Criteria) this;
        }

        public Criteria andCreditSystemCodeGreaterThan(String value) {
            addCriterion("credit_system_code >", value, "creditSystemCode");
            return (Criteria) this;
        }

        public Criteria andCreditSystemCodeGreaterThanOrEqualTo(String value) {
            addCriterion("credit_system_code >=", value, "creditSystemCode");
            return (Criteria) this;
        }

        public Criteria andCreditSystemCodeLessThan(String value) {
            addCriterion("credit_system_code <", value, "creditSystemCode");
            return (Criteria) this;
        }

        public Criteria andCreditSystemCodeLessThanOrEqualTo(String value) {
            addCriterion("credit_system_code <=", value, "creditSystemCode");
            return (Criteria) this;
        }

        public Criteria andCreditSystemCodeLike(String value) {
            addCriterion("credit_system_code like", value, "creditSystemCode");
            return (Criteria) this;
        }

        public Criteria andCreditSystemCodeNotLike(String value) {
            addCriterion("credit_system_code not like", value, "creditSystemCode");
            return (Criteria) this;
        }

        public Criteria andCreditSystemCodeIn(List<String> values) {
            addCriterion("credit_system_code in", values, "creditSystemCode");
            return (Criteria) this;
        }

        public Criteria andCreditSystemCodeNotIn(List<String> values) {
            addCriterion("credit_system_code not in", values, "creditSystemCode");
            return (Criteria) this;
        }

        public Criteria andCreditSystemCodeBetween(String value1, String value2) {
            addCriterion("credit_system_code between", value1, value2, "creditSystemCode");
            return (Criteria) this;
        }

        public Criteria andCreditSystemCodeNotBetween(String value1, String value2) {
            addCriterion("credit_system_code not between", value1, value2, "creditSystemCode");
            return (Criteria) this;
        }

        public Criteria andPmIsNull() {
            addCriterion("pm is null");
            return (Criteria) this;
        }

        public Criteria andPmIsNotNull() {
            addCriterion("pm is not null");
            return (Criteria) this;
        }

        public Criteria andPmEqualTo(String value) {
            addCriterion("pm =", value, "pm");
            return (Criteria) this;
        }

        public Criteria andPmNotEqualTo(String value) {
            addCriterion("pm <>", value, "pm");
            return (Criteria) this;
        }

        public Criteria andPmGreaterThan(String value) {
            addCriterion("pm >", value, "pm");
            return (Criteria) this;
        }

        public Criteria andPmGreaterThanOrEqualTo(String value) {
            addCriterion("pm >=", value, "pm");
            return (Criteria) this;
        }

        public Criteria andPmLessThan(String value) {
            addCriterion("pm <", value, "pm");
            return (Criteria) this;
        }

        public Criteria andPmLessThanOrEqualTo(String value) {
            addCriterion("pm <=", value, "pm");
            return (Criteria) this;
        }

        public Criteria andPmLike(String value) {
            addCriterion("pm like", value, "pm");
            return (Criteria) this;
        }

        public Criteria andPmNotLike(String value) {
            addCriterion("pm not like", value, "pm");
            return (Criteria) this;
        }

        public Criteria andPmIn(List<String> values) {
            addCriterion("pm in", values, "pm");
            return (Criteria) this;
        }

        public Criteria andPmNotIn(List<String> values) {
            addCriterion("pm not in", values, "pm");
            return (Criteria) this;
        }

        public Criteria andPmBetween(String value1, String value2) {
            addCriterion("pm between", value1, value2, "pm");
            return (Criteria) this;
        }

        public Criteria andPmNotBetween(String value1, String value2) {
            addCriterion("pm not between", value1, value2, "pm");
            return (Criteria) this;
        }

        public Criteria andWorkContentIsNull() {
            addCriterion("work_content is null");
            return (Criteria) this;
        }

        public Criteria andWorkContentIsNotNull() {
            addCriterion("work_content is not null");
            return (Criteria) this;
        }

        public Criteria andWorkContentEqualTo(String value) {
            addCriterion("work_content =", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentNotEqualTo(String value) {
            addCriterion("work_content <>", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentGreaterThan(String value) {
            addCriterion("work_content >", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentGreaterThanOrEqualTo(String value) {
            addCriterion("work_content >=", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentLessThan(String value) {
            addCriterion("work_content <", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentLessThanOrEqualTo(String value) {
            addCriterion("work_content <=", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentLike(String value) {
            addCriterion("work_content like", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentNotLike(String value) {
            addCriterion("work_content not like", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentIn(List<String> values) {
            addCriterion("work_content in", values, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentNotIn(List<String> values) {
            addCriterion("work_content not in", values, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentBetween(String value1, String value2) {
            addCriterion("work_content between", value1, value2, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentNotBetween(String value1, String value2) {
            addCriterion("work_content not between", value1, value2, "workContent");
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