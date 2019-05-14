package com.pcitc.base.stp.expenses;

import java.util.ArrayList;
import java.util.List;

public class ExpensesBillsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public ExpensesBillsExample() {
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

        public Criteria andBilltypecodeIsNull() {
            addCriterion("billTypeCode is null");
            return (Criteria) this;
        }

        public Criteria andBilltypecodeIsNotNull() {
            addCriterion("billTypeCode is not null");
            return (Criteria) this;
        }

        public Criteria andBilltypecodeEqualTo(String value) {
            addCriterion("billTypeCode =", value, "billtypecode");
            return (Criteria) this;
        }

        public Criteria andBilltypecodeNotEqualTo(String value) {
            addCriterion("billTypeCode <>", value, "billtypecode");
            return (Criteria) this;
        }

        public Criteria andBilltypecodeGreaterThan(String value) {
            addCriterion("billTypeCode >", value, "billtypecode");
            return (Criteria) this;
        }

        public Criteria andBilltypecodeGreaterThanOrEqualTo(String value) {
            addCriterion("billTypeCode >=", value, "billtypecode");
            return (Criteria) this;
        }

        public Criteria andBilltypecodeLessThan(String value) {
            addCriterion("billTypeCode <", value, "billtypecode");
            return (Criteria) this;
        }

        public Criteria andBilltypecodeLessThanOrEqualTo(String value) {
            addCriterion("billTypeCode <=", value, "billtypecode");
            return (Criteria) this;
        }

        public Criteria andBilltypecodeLike(String value) {
            addCriterion("billTypeCode like", value, "billtypecode");
            return (Criteria) this;
        }

        public Criteria andBilltypecodeNotLike(String value) {
            addCriterion("billTypeCode not like", value, "billtypecode");
            return (Criteria) this;
        }

        public Criteria andBilltypecodeIn(List<String> values) {
            addCriterion("billTypeCode in", values, "billtypecode");
            return (Criteria) this;
        }

        public Criteria andBilltypecodeNotIn(List<String> values) {
            addCriterion("billTypeCode not in", values, "billtypecode");
            return (Criteria) this;
        }

        public Criteria andBilltypecodeBetween(String value1, String value2) {
            addCriterion("billTypeCode between", value1, value2, "billtypecode");
            return (Criteria) this;
        }

        public Criteria andBilltypecodeNotBetween(String value1, String value2) {
            addCriterion("billTypeCode not between", value1, value2, "billtypecode");
            return (Criteria) this;
        }

        public Criteria andBilltypenameIsNull() {
            addCriterion("billTypeName is null");
            return (Criteria) this;
        }

        public Criteria andBilltypenameIsNotNull() {
            addCriterion("billTypeName is not null");
            return (Criteria) this;
        }

        public Criteria andBilltypenameEqualTo(String value) {
            addCriterion("billTypeName =", value, "billtypename");
            return (Criteria) this;
        }

        public Criteria andBilltypenameNotEqualTo(String value) {
            addCriterion("billTypeName <>", value, "billtypename");
            return (Criteria) this;
        }

        public Criteria andBilltypenameGreaterThan(String value) {
            addCriterion("billTypeName >", value, "billtypename");
            return (Criteria) this;
        }

        public Criteria andBilltypenameGreaterThanOrEqualTo(String value) {
            addCriterion("billTypeName >=", value, "billtypename");
            return (Criteria) this;
        }

        public Criteria andBilltypenameLessThan(String value) {
            addCriterion("billTypeName <", value, "billtypename");
            return (Criteria) this;
        }

        public Criteria andBilltypenameLessThanOrEqualTo(String value) {
            addCriterion("billTypeName <=", value, "billtypename");
            return (Criteria) this;
        }

        public Criteria andBilltypenameLike(String value) {
            addCriterion("billTypeName like", value, "billtypename");
            return (Criteria) this;
        }

        public Criteria andBilltypenameNotLike(String value) {
            addCriterion("billTypeName not like", value, "billtypename");
            return (Criteria) this;
        }

        public Criteria andBilltypenameIn(List<String> values) {
            addCriterion("billTypeName in", values, "billtypename");
            return (Criteria) this;
        }

        public Criteria andBilltypenameNotIn(List<String> values) {
            addCriterion("billTypeName not in", values, "billtypename");
            return (Criteria) this;
        }

        public Criteria andBilltypenameBetween(String value1, String value2) {
            addCriterion("billTypeName between", value1, value2, "billtypename");
            return (Criteria) this;
        }

        public Criteria andBilltypenameNotBetween(String value1, String value2) {
            addCriterion("billTypeName not between", value1, value2, "billtypename");
            return (Criteria) this;
        }

        public Criteria andBillcodeIsNull() {
            addCriterion("billCode is null");
            return (Criteria) this;
        }

        public Criteria andBillcodeIsNotNull() {
            addCriterion("billCode is not null");
            return (Criteria) this;
        }

        public Criteria andBillcodeEqualTo(String value) {
            addCriterion("billCode =", value, "billcode");
            return (Criteria) this;
        }

        public Criteria andBillcodeNotEqualTo(String value) {
            addCriterion("billCode <>", value, "billcode");
            return (Criteria) this;
        }

        public Criteria andBillcodeGreaterThan(String value) {
            addCriterion("billCode >", value, "billcode");
            return (Criteria) this;
        }

        public Criteria andBillcodeGreaterThanOrEqualTo(String value) {
            addCriterion("billCode >=", value, "billcode");
            return (Criteria) this;
        }

        public Criteria andBillcodeLessThan(String value) {
            addCriterion("billCode <", value, "billcode");
            return (Criteria) this;
        }

        public Criteria andBillcodeLessThanOrEqualTo(String value) {
            addCriterion("billCode <=", value, "billcode");
            return (Criteria) this;
        }

        public Criteria andBillcodeLike(String value) {
            addCriterion("billCode like", value, "billcode");
            return (Criteria) this;
        }

        public Criteria andBillcodeNotLike(String value) {
            addCriterion("billCode not like", value, "billcode");
            return (Criteria) this;
        }

        public Criteria andBillcodeIn(List<String> values) {
            addCriterion("billCode in", values, "billcode");
            return (Criteria) this;
        }

        public Criteria andBillcodeNotIn(List<String> values) {
            addCriterion("billCode not in", values, "billcode");
            return (Criteria) this;
        }

        public Criteria andBillcodeBetween(String value1, String value2) {
            addCriterion("billCode between", value1, value2, "billcode");
            return (Criteria) this;
        }

        public Criteria andBillcodeNotBetween(String value1, String value2) {
            addCriterion("billCode not between", value1, value2, "billcode");
            return (Criteria) this;
        }

        public Criteria andApplydateIsNull() {
            addCriterion("applyDate is null");
            return (Criteria) this;
        }

        public Criteria andApplydateIsNotNull() {
            addCriterion("applyDate is not null");
            return (Criteria) this;
        }

        public Criteria andApplydateEqualTo(String value) {
            addCriterion("applyDate =", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateNotEqualTo(String value) {
            addCriterion("applyDate <>", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateGreaterThan(String value) {
            addCriterion("applyDate >", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateGreaterThanOrEqualTo(String value) {
            addCriterion("applyDate >=", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateLessThan(String value) {
            addCriterion("applyDate <", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateLessThanOrEqualTo(String value) {
            addCriterion("applyDate <=", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateLike(String value) {
            addCriterion("applyDate like", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateNotLike(String value) {
            addCriterion("applyDate not like", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateIn(List<String> values) {
            addCriterion("applyDate in", values, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateNotIn(List<String> values) {
            addCriterion("applyDate not in", values, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateBetween(String value1, String value2) {
            addCriterion("applyDate between", value1, value2, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateNotBetween(String value1, String value2) {
            addCriterion("applyDate not between", value1, value2, "applydate");
            return (Criteria) this;
        }

        public Criteria andCompcodeIsNull() {
            addCriterion("compCode is null");
            return (Criteria) this;
        }

        public Criteria andCompcodeIsNotNull() {
            addCriterion("compCode is not null");
            return (Criteria) this;
        }

        public Criteria andCompcodeEqualTo(String value) {
            addCriterion("compCode =", value, "compcode");
            return (Criteria) this;
        }

        public Criteria andCompcodeNotEqualTo(String value) {
            addCriterion("compCode <>", value, "compcode");
            return (Criteria) this;
        }

        public Criteria andCompcodeGreaterThan(String value) {
            addCriterion("compCode >", value, "compcode");
            return (Criteria) this;
        }

        public Criteria andCompcodeGreaterThanOrEqualTo(String value) {
            addCriterion("compCode >=", value, "compcode");
            return (Criteria) this;
        }

        public Criteria andCompcodeLessThan(String value) {
            addCriterion("compCode <", value, "compcode");
            return (Criteria) this;
        }

        public Criteria andCompcodeLessThanOrEqualTo(String value) {
            addCriterion("compCode <=", value, "compcode");
            return (Criteria) this;
        }

        public Criteria andCompcodeLike(String value) {
            addCriterion("compCode like", value, "compcode");
            return (Criteria) this;
        }

        public Criteria andCompcodeNotLike(String value) {
            addCriterion("compCode not like", value, "compcode");
            return (Criteria) this;
        }

        public Criteria andCompcodeIn(List<String> values) {
            addCriterion("compCode in", values, "compcode");
            return (Criteria) this;
        }

        public Criteria andCompcodeNotIn(List<String> values) {
            addCriterion("compCode not in", values, "compcode");
            return (Criteria) this;
        }

        public Criteria andCompcodeBetween(String value1, String value2) {
            addCriterion("compCode between", value1, value2, "compcode");
            return (Criteria) this;
        }

        public Criteria andCompcodeNotBetween(String value1, String value2) {
            addCriterion("compCode not between", value1, value2, "compcode");
            return (Criteria) this;
        }

        public Criteria andCompnameIsNull() {
            addCriterion("compName is null");
            return (Criteria) this;
        }

        public Criteria andCompnameIsNotNull() {
            addCriterion("compName is not null");
            return (Criteria) this;
        }

        public Criteria andCompnameEqualTo(String value) {
            addCriterion("compName =", value, "compname");
            return (Criteria) this;
        }

        public Criteria andCompnameNotEqualTo(String value) {
            addCriterion("compName <>", value, "compname");
            return (Criteria) this;
        }

        public Criteria andCompnameGreaterThan(String value) {
            addCriterion("compName >", value, "compname");
            return (Criteria) this;
        }

        public Criteria andCompnameGreaterThanOrEqualTo(String value) {
            addCriterion("compName >=", value, "compname");
            return (Criteria) this;
        }

        public Criteria andCompnameLessThan(String value) {
            addCriterion("compName <", value, "compname");
            return (Criteria) this;
        }

        public Criteria andCompnameLessThanOrEqualTo(String value) {
            addCriterion("compName <=", value, "compname");
            return (Criteria) this;
        }

        public Criteria andCompnameLike(String value) {
            addCriterion("compName like", value, "compname");
            return (Criteria) this;
        }

        public Criteria andCompnameNotLike(String value) {
            addCriterion("compName not like", value, "compname");
            return (Criteria) this;
        }

        public Criteria andCompnameIn(List<String> values) {
            addCriterion("compName in", values, "compname");
            return (Criteria) this;
        }

        public Criteria andCompnameNotIn(List<String> values) {
            addCriterion("compName not in", values, "compname");
            return (Criteria) this;
        }

        public Criteria andCompnameBetween(String value1, String value2) {
            addCriterion("compName between", value1, value2, "compname");
            return (Criteria) this;
        }

        public Criteria andCompnameNotBetween(String value1, String value2) {
            addCriterion("compName not between", value1, value2, "compname");
            return (Criteria) this;
        }

        public Criteria andApprorgnameIsNull() {
            addCriterion("apprOrgName is null");
            return (Criteria) this;
        }

        public Criteria andApprorgnameIsNotNull() {
            addCriterion("apprOrgName is not null");
            return (Criteria) this;
        }

        public Criteria andApprorgnameEqualTo(String value) {
            addCriterion("apprOrgName =", value, "approrgname");
            return (Criteria) this;
        }

        public Criteria andApprorgnameNotEqualTo(String value) {
            addCriterion("apprOrgName <>", value, "approrgname");
            return (Criteria) this;
        }

        public Criteria andApprorgnameGreaterThan(String value) {
            addCriterion("apprOrgName >", value, "approrgname");
            return (Criteria) this;
        }

        public Criteria andApprorgnameGreaterThanOrEqualTo(String value) {
            addCriterion("apprOrgName >=", value, "approrgname");
            return (Criteria) this;
        }

        public Criteria andApprorgnameLessThan(String value) {
            addCriterion("apprOrgName <", value, "approrgname");
            return (Criteria) this;
        }

        public Criteria andApprorgnameLessThanOrEqualTo(String value) {
            addCriterion("apprOrgName <=", value, "approrgname");
            return (Criteria) this;
        }

        public Criteria andApprorgnameLike(String value) {
            addCriterion("apprOrgName like", value, "approrgname");
            return (Criteria) this;
        }

        public Criteria andApprorgnameNotLike(String value) {
            addCriterion("apprOrgName not like", value, "approrgname");
            return (Criteria) this;
        }

        public Criteria andApprorgnameIn(List<String> values) {
            addCriterion("apprOrgName in", values, "approrgname");
            return (Criteria) this;
        }

        public Criteria andApprorgnameNotIn(List<String> values) {
            addCriterion("apprOrgName not in", values, "approrgname");
            return (Criteria) this;
        }

        public Criteria andApprorgnameBetween(String value1, String value2) {
            addCriterion("apprOrgName between", value1, value2, "approrgname");
            return (Criteria) this;
        }

        public Criteria andApprorgnameNotBetween(String value1, String value2) {
            addCriterion("apprOrgName not between", value1, value2, "approrgname");
            return (Criteria) this;
        }

        public Criteria andApprorgcodeIsNull() {
            addCriterion("apprOrgCode is null");
            return (Criteria) this;
        }

        public Criteria andApprorgcodeIsNotNull() {
            addCriterion("apprOrgCode is not null");
            return (Criteria) this;
        }

        public Criteria andApprorgcodeEqualTo(String value) {
            addCriterion("apprOrgCode =", value, "approrgcode");
            return (Criteria) this;
        }

        public Criteria andApprorgcodeNotEqualTo(String value) {
            addCriterion("apprOrgCode <>", value, "approrgcode");
            return (Criteria) this;
        }

        public Criteria andApprorgcodeGreaterThan(String value) {
            addCriterion("apprOrgCode >", value, "approrgcode");
            return (Criteria) this;
        }

        public Criteria andApprorgcodeGreaterThanOrEqualTo(String value) {
            addCriterion("apprOrgCode >=", value, "approrgcode");
            return (Criteria) this;
        }

        public Criteria andApprorgcodeLessThan(String value) {
            addCriterion("apprOrgCode <", value, "approrgcode");
            return (Criteria) this;
        }

        public Criteria andApprorgcodeLessThanOrEqualTo(String value) {
            addCriterion("apprOrgCode <=", value, "approrgcode");
            return (Criteria) this;
        }

        public Criteria andApprorgcodeLike(String value) {
            addCriterion("apprOrgCode like", value, "approrgcode");
            return (Criteria) this;
        }

        public Criteria andApprorgcodeNotLike(String value) {
            addCriterion("apprOrgCode not like", value, "approrgcode");
            return (Criteria) this;
        }

        public Criteria andApprorgcodeIn(List<String> values) {
            addCriterion("apprOrgCode in", values, "approrgcode");
            return (Criteria) this;
        }

        public Criteria andApprorgcodeNotIn(List<String> values) {
            addCriterion("apprOrgCode not in", values, "approrgcode");
            return (Criteria) this;
        }

        public Criteria andApprorgcodeBetween(String value1, String value2) {
            addCriterion("apprOrgCode between", value1, value2, "approrgcode");
            return (Criteria) this;
        }

        public Criteria andApprorgcodeNotBetween(String value1, String value2) {
            addCriterion("apprOrgCode not between", value1, value2, "approrgcode");
            return (Criteria) this;
        }

        public Criteria andCostcentnameIsNull() {
            addCriterion("costCentName is null");
            return (Criteria) this;
        }

        public Criteria andCostcentnameIsNotNull() {
            addCriterion("costCentName is not null");
            return (Criteria) this;
        }

        public Criteria andCostcentnameEqualTo(String value) {
            addCriterion("costCentName =", value, "costcentname");
            return (Criteria) this;
        }

        public Criteria andCostcentnameNotEqualTo(String value) {
            addCriterion("costCentName <>", value, "costcentname");
            return (Criteria) this;
        }

        public Criteria andCostcentnameGreaterThan(String value) {
            addCriterion("costCentName >", value, "costcentname");
            return (Criteria) this;
        }

        public Criteria andCostcentnameGreaterThanOrEqualTo(String value) {
            addCriterion("costCentName >=", value, "costcentname");
            return (Criteria) this;
        }

        public Criteria andCostcentnameLessThan(String value) {
            addCriterion("costCentName <", value, "costcentname");
            return (Criteria) this;
        }

        public Criteria andCostcentnameLessThanOrEqualTo(String value) {
            addCriterion("costCentName <=", value, "costcentname");
            return (Criteria) this;
        }

        public Criteria andCostcentnameLike(String value) {
            addCriterion("costCentName like", value, "costcentname");
            return (Criteria) this;
        }

        public Criteria andCostcentnameNotLike(String value) {
            addCriterion("costCentName not like", value, "costcentname");
            return (Criteria) this;
        }

        public Criteria andCostcentnameIn(List<String> values) {
            addCriterion("costCentName in", values, "costcentname");
            return (Criteria) this;
        }

        public Criteria andCostcentnameNotIn(List<String> values) {
            addCriterion("costCentName not in", values, "costcentname");
            return (Criteria) this;
        }

        public Criteria andCostcentnameBetween(String value1, String value2) {
            addCriterion("costCentName between", value1, value2, "costcentname");
            return (Criteria) this;
        }

        public Criteria andCostcentnameNotBetween(String value1, String value2) {
            addCriterion("costCentName not between", value1, value2, "costcentname");
            return (Criteria) this;
        }

        public Criteria andCostcentcodeIsNull() {
            addCriterion("costCentCode is null");
            return (Criteria) this;
        }

        public Criteria andCostcentcodeIsNotNull() {
            addCriterion("costCentCode is not null");
            return (Criteria) this;
        }

        public Criteria andCostcentcodeEqualTo(String value) {
            addCriterion("costCentCode =", value, "costcentcode");
            return (Criteria) this;
        }

        public Criteria andCostcentcodeNotEqualTo(String value) {
            addCriterion("costCentCode <>", value, "costcentcode");
            return (Criteria) this;
        }

        public Criteria andCostcentcodeGreaterThan(String value) {
            addCriterion("costCentCode >", value, "costcentcode");
            return (Criteria) this;
        }

        public Criteria andCostcentcodeGreaterThanOrEqualTo(String value) {
            addCriterion("costCentCode >=", value, "costcentcode");
            return (Criteria) this;
        }

        public Criteria andCostcentcodeLessThan(String value) {
            addCriterion("costCentCode <", value, "costcentcode");
            return (Criteria) this;
        }

        public Criteria andCostcentcodeLessThanOrEqualTo(String value) {
            addCriterion("costCentCode <=", value, "costcentcode");
            return (Criteria) this;
        }

        public Criteria andCostcentcodeLike(String value) {
            addCriterion("costCentCode like", value, "costcentcode");
            return (Criteria) this;
        }

        public Criteria andCostcentcodeNotLike(String value) {
            addCriterion("costCentCode not like", value, "costcentcode");
            return (Criteria) this;
        }

        public Criteria andCostcentcodeIn(List<String> values) {
            addCriterion("costCentCode in", values, "costcentcode");
            return (Criteria) this;
        }

        public Criteria andCostcentcodeNotIn(List<String> values) {
            addCriterion("costCentCode not in", values, "costcentcode");
            return (Criteria) this;
        }

        public Criteria andCostcentcodeBetween(String value1, String value2) {
            addCriterion("costCentCode between", value1, value2, "costcentcode");
            return (Criteria) this;
        }

        public Criteria andCostcentcodeNotBetween(String value1, String value2) {
            addCriterion("costCentCode not between", value1, value2, "costcentcode");
            return (Criteria) this;
        }

        public Criteria andApplyempidIsNull() {
            addCriterion("applyEmpId is null");
            return (Criteria) this;
        }

        public Criteria andApplyempidIsNotNull() {
            addCriterion("applyEmpId is not null");
            return (Criteria) this;
        }

        public Criteria andApplyempidEqualTo(String value) {
            addCriterion("applyEmpId =", value, "applyempid");
            return (Criteria) this;
        }

        public Criteria andApplyempidNotEqualTo(String value) {
            addCriterion("applyEmpId <>", value, "applyempid");
            return (Criteria) this;
        }

        public Criteria andApplyempidGreaterThan(String value) {
            addCriterion("applyEmpId >", value, "applyempid");
            return (Criteria) this;
        }

        public Criteria andApplyempidGreaterThanOrEqualTo(String value) {
            addCriterion("applyEmpId >=", value, "applyempid");
            return (Criteria) this;
        }

        public Criteria andApplyempidLessThan(String value) {
            addCriterion("applyEmpId <", value, "applyempid");
            return (Criteria) this;
        }

        public Criteria andApplyempidLessThanOrEqualTo(String value) {
            addCriterion("applyEmpId <=", value, "applyempid");
            return (Criteria) this;
        }

        public Criteria andApplyempidLike(String value) {
            addCriterion("applyEmpId like", value, "applyempid");
            return (Criteria) this;
        }

        public Criteria andApplyempidNotLike(String value) {
            addCriterion("applyEmpId not like", value, "applyempid");
            return (Criteria) this;
        }

        public Criteria andApplyempidIn(List<String> values) {
            addCriterion("applyEmpId in", values, "applyempid");
            return (Criteria) this;
        }

        public Criteria andApplyempidNotIn(List<String> values) {
            addCriterion("applyEmpId not in", values, "applyempid");
            return (Criteria) this;
        }

        public Criteria andApplyempidBetween(String value1, String value2) {
            addCriterion("applyEmpId between", value1, value2, "applyempid");
            return (Criteria) this;
        }

        public Criteria andApplyempidNotBetween(String value1, String value2) {
            addCriterion("applyEmpId not between", value1, value2, "applyempid");
            return (Criteria) this;
        }

        public Criteria andApplyempnameIsNull() {
            addCriterion("applyEmpName is null");
            return (Criteria) this;
        }

        public Criteria andApplyempnameIsNotNull() {
            addCriterion("applyEmpName is not null");
            return (Criteria) this;
        }

        public Criteria andApplyempnameEqualTo(String value) {
            addCriterion("applyEmpName =", value, "applyempname");
            return (Criteria) this;
        }

        public Criteria andApplyempnameNotEqualTo(String value) {
            addCriterion("applyEmpName <>", value, "applyempname");
            return (Criteria) this;
        }

        public Criteria andApplyempnameGreaterThan(String value) {
            addCriterion("applyEmpName >", value, "applyempname");
            return (Criteria) this;
        }

        public Criteria andApplyempnameGreaterThanOrEqualTo(String value) {
            addCriterion("applyEmpName >=", value, "applyempname");
            return (Criteria) this;
        }

        public Criteria andApplyempnameLessThan(String value) {
            addCriterion("applyEmpName <", value, "applyempname");
            return (Criteria) this;
        }

        public Criteria andApplyempnameLessThanOrEqualTo(String value) {
            addCriterion("applyEmpName <=", value, "applyempname");
            return (Criteria) this;
        }

        public Criteria andApplyempnameLike(String value) {
            addCriterion("applyEmpName like", value, "applyempname");
            return (Criteria) this;
        }

        public Criteria andApplyempnameNotLike(String value) {
            addCriterion("applyEmpName not like", value, "applyempname");
            return (Criteria) this;
        }

        public Criteria andApplyempnameIn(List<String> values) {
            addCriterion("applyEmpName in", values, "applyempname");
            return (Criteria) this;
        }

        public Criteria andApplyempnameNotIn(List<String> values) {
            addCriterion("applyEmpName not in", values, "applyempname");
            return (Criteria) this;
        }

        public Criteria andApplyempnameBetween(String value1, String value2) {
            addCriterion("applyEmpName between", value1, value2, "applyempname");
            return (Criteria) this;
        }

        public Criteria andApplyempnameNotBetween(String value1, String value2) {
            addCriterion("applyEmpName not between", value1, value2, "applyempname");
            return (Criteria) this;
        }

        public Criteria andReimcodeIsNull() {
            addCriterion("reimCode is null");
            return (Criteria) this;
        }

        public Criteria andReimcodeIsNotNull() {
            addCriterion("reimCode is not null");
            return (Criteria) this;
        }

        public Criteria andReimcodeEqualTo(String value) {
            addCriterion("reimCode =", value, "reimcode");
            return (Criteria) this;
        }

        public Criteria andReimcodeNotEqualTo(String value) {
            addCriterion("reimCode <>", value, "reimcode");
            return (Criteria) this;
        }

        public Criteria andReimcodeGreaterThan(String value) {
            addCriterion("reimCode >", value, "reimcode");
            return (Criteria) this;
        }

        public Criteria andReimcodeGreaterThanOrEqualTo(String value) {
            addCriterion("reimCode >=", value, "reimcode");
            return (Criteria) this;
        }

        public Criteria andReimcodeLessThan(String value) {
            addCriterion("reimCode <", value, "reimcode");
            return (Criteria) this;
        }

        public Criteria andReimcodeLessThanOrEqualTo(String value) {
            addCriterion("reimCode <=", value, "reimcode");
            return (Criteria) this;
        }

        public Criteria andReimcodeLike(String value) {
            addCriterion("reimCode like", value, "reimcode");
            return (Criteria) this;
        }

        public Criteria andReimcodeNotLike(String value) {
            addCriterion("reimCode not like", value, "reimcode");
            return (Criteria) this;
        }

        public Criteria andReimcodeIn(List<String> values) {
            addCriterion("reimCode in", values, "reimcode");
            return (Criteria) this;
        }

        public Criteria andReimcodeNotIn(List<String> values) {
            addCriterion("reimCode not in", values, "reimcode");
            return (Criteria) this;
        }

        public Criteria andReimcodeBetween(String value1, String value2) {
            addCriterion("reimCode between", value1, value2, "reimcode");
            return (Criteria) this;
        }

        public Criteria andReimcodeNotBetween(String value1, String value2) {
            addCriterion("reimCode not between", value1, value2, "reimcode");
            return (Criteria) this;
        }

        public Criteria andReimnameIsNull() {
            addCriterion("reimName is null");
            return (Criteria) this;
        }

        public Criteria andReimnameIsNotNull() {
            addCriterion("reimName is not null");
            return (Criteria) this;
        }

        public Criteria andReimnameEqualTo(String value) {
            addCriterion("reimName =", value, "reimname");
            return (Criteria) this;
        }

        public Criteria andReimnameNotEqualTo(String value) {
            addCriterion("reimName <>", value, "reimname");
            return (Criteria) this;
        }

        public Criteria andReimnameGreaterThan(String value) {
            addCriterion("reimName >", value, "reimname");
            return (Criteria) this;
        }

        public Criteria andReimnameGreaterThanOrEqualTo(String value) {
            addCriterion("reimName >=", value, "reimname");
            return (Criteria) this;
        }

        public Criteria andReimnameLessThan(String value) {
            addCriterion("reimName <", value, "reimname");
            return (Criteria) this;
        }

        public Criteria andReimnameLessThanOrEqualTo(String value) {
            addCriterion("reimName <=", value, "reimname");
            return (Criteria) this;
        }

        public Criteria andReimnameLike(String value) {
            addCriterion("reimName like", value, "reimname");
            return (Criteria) this;
        }

        public Criteria andReimnameNotLike(String value) {
            addCriterion("reimName not like", value, "reimname");
            return (Criteria) this;
        }

        public Criteria andReimnameIn(List<String> values) {
            addCriterion("reimName in", values, "reimname");
            return (Criteria) this;
        }

        public Criteria andReimnameNotIn(List<String> values) {
            addCriterion("reimName not in", values, "reimname");
            return (Criteria) this;
        }

        public Criteria andReimnameBetween(String value1, String value2) {
            addCriterion("reimName between", value1, value2, "reimname");
            return (Criteria) this;
        }

        public Criteria andReimnameNotBetween(String value1, String value2) {
            addCriterion("reimName not between", value1, value2, "reimname");
            return (Criteria) this;
        }

        public Criteria andAccoobjvaluedescIsNull() {
            addCriterion("accoObjValueDesc is null");
            return (Criteria) this;
        }

        public Criteria andAccoobjvaluedescIsNotNull() {
            addCriterion("accoObjValueDesc is not null");
            return (Criteria) this;
        }

        public Criteria andAccoobjvaluedescEqualTo(String value) {
            addCriterion("accoObjValueDesc =", value, "accoobjvaluedesc");
            return (Criteria) this;
        }

        public Criteria andAccoobjvaluedescNotEqualTo(String value) {
            addCriterion("accoObjValueDesc <>", value, "accoobjvaluedesc");
            return (Criteria) this;
        }

        public Criteria andAccoobjvaluedescGreaterThan(String value) {
            addCriterion("accoObjValueDesc >", value, "accoobjvaluedesc");
            return (Criteria) this;
        }

        public Criteria andAccoobjvaluedescGreaterThanOrEqualTo(String value) {
            addCriterion("accoObjValueDesc >=", value, "accoobjvaluedesc");
            return (Criteria) this;
        }

        public Criteria andAccoobjvaluedescLessThan(String value) {
            addCriterion("accoObjValueDesc <", value, "accoobjvaluedesc");
            return (Criteria) this;
        }

        public Criteria andAccoobjvaluedescLessThanOrEqualTo(String value) {
            addCriterion("accoObjValueDesc <=", value, "accoobjvaluedesc");
            return (Criteria) this;
        }

        public Criteria andAccoobjvaluedescLike(String value) {
            addCriterion("accoObjValueDesc like", value, "accoobjvaluedesc");
            return (Criteria) this;
        }

        public Criteria andAccoobjvaluedescNotLike(String value) {
            addCriterion("accoObjValueDesc not like", value, "accoobjvaluedesc");
            return (Criteria) this;
        }

        public Criteria andAccoobjvaluedescIn(List<String> values) {
            addCriterion("accoObjValueDesc in", values, "accoobjvaluedesc");
            return (Criteria) this;
        }

        public Criteria andAccoobjvaluedescNotIn(List<String> values) {
            addCriterion("accoObjValueDesc not in", values, "accoobjvaluedesc");
            return (Criteria) this;
        }

        public Criteria andAccoobjvaluedescBetween(String value1, String value2) {
            addCriterion("accoObjValueDesc between", value1, value2, "accoobjvaluedesc");
            return (Criteria) this;
        }

        public Criteria andAccoobjvaluedescNotBetween(String value1, String value2) {
            addCriterion("accoObjValueDesc not between", value1, value2, "accoobjvaluedesc");
            return (Criteria) this;
        }

        public Criteria andAccoobjvalueIsNull() {
            addCriterion("accoObjValue is null");
            return (Criteria) this;
        }

        public Criteria andAccoobjvalueIsNotNull() {
            addCriterion("accoObjValue is not null");
            return (Criteria) this;
        }

        public Criteria andAccoobjvalueEqualTo(String value) {
            addCriterion("accoObjValue =", value, "accoobjvalue");
            return (Criteria) this;
        }

        public Criteria andAccoobjvalueNotEqualTo(String value) {
            addCriterion("accoObjValue <>", value, "accoobjvalue");
            return (Criteria) this;
        }

        public Criteria andAccoobjvalueGreaterThan(String value) {
            addCriterion("accoObjValue >", value, "accoobjvalue");
            return (Criteria) this;
        }

        public Criteria andAccoobjvalueGreaterThanOrEqualTo(String value) {
            addCriterion("accoObjValue >=", value, "accoobjvalue");
            return (Criteria) this;
        }

        public Criteria andAccoobjvalueLessThan(String value) {
            addCriterion("accoObjValue <", value, "accoobjvalue");
            return (Criteria) this;
        }

        public Criteria andAccoobjvalueLessThanOrEqualTo(String value) {
            addCriterion("accoObjValue <=", value, "accoobjvalue");
            return (Criteria) this;
        }

        public Criteria andAccoobjvalueLike(String value) {
            addCriterion("accoObjValue like", value, "accoobjvalue");
            return (Criteria) this;
        }

        public Criteria andAccoobjvalueNotLike(String value) {
            addCriterion("accoObjValue not like", value, "accoobjvalue");
            return (Criteria) this;
        }

        public Criteria andAccoobjvalueIn(List<String> values) {
            addCriterion("accoObjValue in", values, "accoobjvalue");
            return (Criteria) this;
        }

        public Criteria andAccoobjvalueNotIn(List<String> values) {
            addCriterion("accoObjValue not in", values, "accoobjvalue");
            return (Criteria) this;
        }

        public Criteria andAccoobjvalueBetween(String value1, String value2) {
            addCriterion("accoObjValue between", value1, value2, "accoobjvalue");
            return (Criteria) this;
        }

        public Criteria andAccoobjvalueNotBetween(String value1, String value2) {
            addCriterion("accoObjValue not between", value1, value2, "accoobjvalue");
            return (Criteria) this;
        }

        public Criteria andBillamountIsNull() {
            addCriterion("billAmount is null");
            return (Criteria) this;
        }

        public Criteria andBillamountIsNotNull() {
            addCriterion("billAmount is not null");
            return (Criteria) this;
        }

        public Criteria andBillamountEqualTo(String value) {
            addCriterion("billAmount =", value, "billamount");
            return (Criteria) this;
        }

        public Criteria andBillamountNotEqualTo(String value) {
            addCriterion("billAmount <>", value, "billamount");
            return (Criteria) this;
        }

        public Criteria andBillamountGreaterThan(String value) {
            addCriterion("billAmount >", value, "billamount");
            return (Criteria) this;
        }

        public Criteria andBillamountGreaterThanOrEqualTo(String value) {
            addCriterion("billAmount >=", value, "billamount");
            return (Criteria) this;
        }

        public Criteria andBillamountLessThan(String value) {
            addCriterion("billAmount <", value, "billamount");
            return (Criteria) this;
        }

        public Criteria andBillamountLessThanOrEqualTo(String value) {
            addCriterion("billAmount <=", value, "billamount");
            return (Criteria) this;
        }

        public Criteria andBillamountLike(String value) {
            addCriterion("billAmount like", value, "billamount");
            return (Criteria) this;
        }

        public Criteria andBillamountNotLike(String value) {
            addCriterion("billAmount not like", value, "billamount");
            return (Criteria) this;
        }

        public Criteria andBillamountIn(List<String> values) {
            addCriterion("billAmount in", values, "billamount");
            return (Criteria) this;
        }

        public Criteria andBillamountNotIn(List<String> values) {
            addCriterion("billAmount not in", values, "billamount");
            return (Criteria) this;
        }

        public Criteria andBillamountBetween(String value1, String value2) {
            addCriterion("billAmount between", value1, value2, "billamount");
            return (Criteria) this;
        }

        public Criteria andBillamountNotBetween(String value1, String value2) {
            addCriterion("billAmount not between", value1, value2, "billamount");
            return (Criteria) this;
        }

        public Criteria andInvestmentIsNull() {
            addCriterion("investment is null");
            return (Criteria) this;
        }

        public Criteria andInvestmentIsNotNull() {
            addCriterion("investment is not null");
            return (Criteria) this;
        }

        public Criteria andInvestmentEqualTo(String value) {
            addCriterion("investment =", value, "investment");
            return (Criteria) this;
        }

        public Criteria andInvestmentNotEqualTo(String value) {
            addCriterion("investment <>", value, "investment");
            return (Criteria) this;
        }

        public Criteria andInvestmentGreaterThan(String value) {
            addCriterion("investment >", value, "investment");
            return (Criteria) this;
        }

        public Criteria andInvestmentGreaterThanOrEqualTo(String value) {
            addCriterion("investment >=", value, "investment");
            return (Criteria) this;
        }

        public Criteria andInvestmentLessThan(String value) {
            addCriterion("investment <", value, "investment");
            return (Criteria) this;
        }

        public Criteria andInvestmentLessThanOrEqualTo(String value) {
            addCriterion("investment <=", value, "investment");
            return (Criteria) this;
        }

        public Criteria andInvestmentLike(String value) {
            addCriterion("investment like", value, "investment");
            return (Criteria) this;
        }

        public Criteria andInvestmentNotLike(String value) {
            addCriterion("investment not like", value, "investment");
            return (Criteria) this;
        }

        public Criteria andInvestmentIn(List<String> values) {
            addCriterion("investment in", values, "investment");
            return (Criteria) this;
        }

        public Criteria andInvestmentNotIn(List<String> values) {
            addCriterion("investment not in", values, "investment");
            return (Criteria) this;
        }

        public Criteria andInvestmentBetween(String value1, String value2) {
            addCriterion("investment between", value1, value2, "investment");
            return (Criteria) this;
        }

        public Criteria andInvestmentNotBetween(String value1, String value2) {
            addCriterion("investment not between", value1, value2, "investment");
            return (Criteria) this;
        }

        public Criteria andDeductionamountIsNull() {
            addCriterion("deductionAmount is null");
            return (Criteria) this;
        }

        public Criteria andDeductionamountIsNotNull() {
            addCriterion("deductionAmount is not null");
            return (Criteria) this;
        }

        public Criteria andDeductionamountEqualTo(String value) {
            addCriterion("deductionAmount =", value, "deductionamount");
            return (Criteria) this;
        }

        public Criteria andDeductionamountNotEqualTo(String value) {
            addCriterion("deductionAmount <>", value, "deductionamount");
            return (Criteria) this;
        }

        public Criteria andDeductionamountGreaterThan(String value) {
            addCriterion("deductionAmount >", value, "deductionamount");
            return (Criteria) this;
        }

        public Criteria andDeductionamountGreaterThanOrEqualTo(String value) {
            addCriterion("deductionAmount >=", value, "deductionamount");
            return (Criteria) this;
        }

        public Criteria andDeductionamountLessThan(String value) {
            addCriterion("deductionAmount <", value, "deductionamount");
            return (Criteria) this;
        }

        public Criteria andDeductionamountLessThanOrEqualTo(String value) {
            addCriterion("deductionAmount <=", value, "deductionamount");
            return (Criteria) this;
        }

        public Criteria andDeductionamountLike(String value) {
            addCriterion("deductionAmount like", value, "deductionamount");
            return (Criteria) this;
        }

        public Criteria andDeductionamountNotLike(String value) {
            addCriterion("deductionAmount not like", value, "deductionamount");
            return (Criteria) this;
        }

        public Criteria andDeductionamountIn(List<String> values) {
            addCriterion("deductionAmount in", values, "deductionamount");
            return (Criteria) this;
        }

        public Criteria andDeductionamountNotIn(List<String> values) {
            addCriterion("deductionAmount not in", values, "deductionamount");
            return (Criteria) this;
        }

        public Criteria andDeductionamountBetween(String value1, String value2) {
            addCriterion("deductionAmount between", value1, value2, "deductionamount");
            return (Criteria) this;
        }

        public Criteria andDeductionamountNotBetween(String value1, String value2) {
            addCriterion("deductionAmount not between", value1, value2, "deductionamount");
            return (Criteria) this;
        }

        public Criteria andDataCodeIsNull() {
            addCriterion("data_code is null");
            return (Criteria) this;
        }

        public Criteria andDataCodeIsNotNull() {
            addCriterion("data_code is not null");
            return (Criteria) this;
        }

        public Criteria andDataCodeEqualTo(String value) {
            addCriterion("data_code =", value, "dataCode");
            return (Criteria) this;
        }

        public Criteria andDataCodeNotEqualTo(String value) {
            addCriterion("data_code <>", value, "dataCode");
            return (Criteria) this;
        }

        public Criteria andDataCodeGreaterThan(String value) {
            addCriterion("data_code >", value, "dataCode");
            return (Criteria) this;
        }

        public Criteria andDataCodeGreaterThanOrEqualTo(String value) {
            addCriterion("data_code >=", value, "dataCode");
            return (Criteria) this;
        }

        public Criteria andDataCodeLessThan(String value) {
            addCriterion("data_code <", value, "dataCode");
            return (Criteria) this;
        }

        public Criteria andDataCodeLessThanOrEqualTo(String value) {
            addCriterion("data_code <=", value, "dataCode");
            return (Criteria) this;
        }

        public Criteria andDataCodeLike(String value) {
            addCriterion("data_code like", value, "dataCode");
            return (Criteria) this;
        }

        public Criteria andDataCodeNotLike(String value) {
            addCriterion("data_code not like", value, "dataCode");
            return (Criteria) this;
        }

        public Criteria andDataCodeIn(List<String> values) {
            addCriterion("data_code in", values, "dataCode");
            return (Criteria) this;
        }

        public Criteria andDataCodeNotIn(List<String> values) {
            addCriterion("data_code not in", values, "dataCode");
            return (Criteria) this;
        }

        public Criteria andDataCodeBetween(String value1, String value2) {
            addCriterion("data_code between", value1, value2, "dataCode");
            return (Criteria) this;
        }

        public Criteria andDataCodeNotBetween(String value1, String value2) {
            addCriterion("data_code not between", value1, value2, "dataCode");
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

        public Criteria andStsIsNull() {
            addCriterion("sts is null");
            return (Criteria) this;
        }

        public Criteria andStsIsNotNull() {
            addCriterion("sts is not null");
            return (Criteria) this;
        }

        public Criteria andStsEqualTo(String value) {
            addCriterion("sts =", value, "sts");
            return (Criteria) this;
        }

        public Criteria andStsNotEqualTo(String value) {
            addCriterion("sts <>", value, "sts");
            return (Criteria) this;
        }

        public Criteria andStsGreaterThan(String value) {
            addCriterion("sts >", value, "sts");
            return (Criteria) this;
        }

        public Criteria andStsGreaterThanOrEqualTo(String value) {
            addCriterion("sts >=", value, "sts");
            return (Criteria) this;
        }

        public Criteria andStsLessThan(String value) {
            addCriterion("sts <", value, "sts");
            return (Criteria) this;
        }

        public Criteria andStsLessThanOrEqualTo(String value) {
            addCriterion("sts <=", value, "sts");
            return (Criteria) this;
        }

        public Criteria andStsLike(String value) {
            addCriterion("sts like", value, "sts");
            return (Criteria) this;
        }

        public Criteria andStsNotLike(String value) {
            addCriterion("sts not like", value, "sts");
            return (Criteria) this;
        }

        public Criteria andStsIn(List<String> values) {
            addCriterion("sts in", values, "sts");
            return (Criteria) this;
        }

        public Criteria andStsNotIn(List<String> values) {
            addCriterion("sts not in", values, "sts");
            return (Criteria) this;
        }

        public Criteria andStsBetween(String value1, String value2) {
            addCriterion("sts between", value1, value2, "sts");
            return (Criteria) this;
        }

        public Criteria andStsNotBetween(String value1, String value2) {
            addCriterion("sts not between", value1, value2, "sts");
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

        public Criteria andBak1IsNull() {
            addCriterion("bak1 is null");
            return (Criteria) this;
        }

        public Criteria andBak1IsNotNull() {
            addCriterion("bak1 is not null");
            return (Criteria) this;
        }

        public Criteria andBak1EqualTo(String value) {
            addCriterion("bak1 =", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1NotEqualTo(String value) {
            addCriterion("bak1 <>", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1GreaterThan(String value) {
            addCriterion("bak1 >", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1GreaterThanOrEqualTo(String value) {
            addCriterion("bak1 >=", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1LessThan(String value) {
            addCriterion("bak1 <", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1LessThanOrEqualTo(String value) {
            addCriterion("bak1 <=", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1Like(String value) {
            addCriterion("bak1 like", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1NotLike(String value) {
            addCriterion("bak1 not like", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1In(List<String> values) {
            addCriterion("bak1 in", values, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1NotIn(List<String> values) {
            addCriterion("bak1 not in", values, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1Between(String value1, String value2) {
            addCriterion("bak1 between", value1, value2, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1NotBetween(String value1, String value2) {
            addCriterion("bak1 not between", value1, value2, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak2IsNull() {
            addCriterion("bak2 is null");
            return (Criteria) this;
        }

        public Criteria andBak2IsNotNull() {
            addCriterion("bak2 is not null");
            return (Criteria) this;
        }

        public Criteria andBak2EqualTo(String value) {
            addCriterion("bak2 =", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2NotEqualTo(String value) {
            addCriterion("bak2 <>", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2GreaterThan(String value) {
            addCriterion("bak2 >", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2GreaterThanOrEqualTo(String value) {
            addCriterion("bak2 >=", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2LessThan(String value) {
            addCriterion("bak2 <", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2LessThanOrEqualTo(String value) {
            addCriterion("bak2 <=", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2Like(String value) {
            addCriterion("bak2 like", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2NotLike(String value) {
            addCriterion("bak2 not like", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2In(List<String> values) {
            addCriterion("bak2 in", values, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2NotIn(List<String> values) {
            addCriterion("bak2 not in", values, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2Between(String value1, String value2) {
            addCriterion("bak2 between", value1, value2, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2NotBetween(String value1, String value2) {
            addCriterion("bak2 not between", value1, value2, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak3IsNull() {
            addCriterion("bak3 is null");
            return (Criteria) this;
        }

        public Criteria andBak3IsNotNull() {
            addCriterion("bak3 is not null");
            return (Criteria) this;
        }

        public Criteria andBak3EqualTo(String value) {
            addCriterion("bak3 =", value, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3NotEqualTo(String value) {
            addCriterion("bak3 <>", value, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3GreaterThan(String value) {
            addCriterion("bak3 >", value, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3GreaterThanOrEqualTo(String value) {
            addCriterion("bak3 >=", value, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3LessThan(String value) {
            addCriterion("bak3 <", value, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3LessThanOrEqualTo(String value) {
            addCriterion("bak3 <=", value, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3Like(String value) {
            addCriterion("bak3 like", value, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3NotLike(String value) {
            addCriterion("bak3 not like", value, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3In(List<String> values) {
            addCriterion("bak3 in", values, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3NotIn(List<String> values) {
            addCriterion("bak3 not in", values, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3Between(String value1, String value2) {
            addCriterion("bak3 between", value1, value2, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3NotBetween(String value1, String value2) {
            addCriterion("bak3 not between", value1, value2, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak4IsNull() {
            addCriterion("bak4 is null");
            return (Criteria) this;
        }

        public Criteria andBak4IsNotNull() {
            addCriterion("bak4 is not null");
            return (Criteria) this;
        }

        public Criteria andBak4EqualTo(String value) {
            addCriterion("bak4 =", value, "bak4");
            return (Criteria) this;
        }

        public Criteria andBak4NotEqualTo(String value) {
            addCriterion("bak4 <>", value, "bak4");
            return (Criteria) this;
        }

        public Criteria andBak4GreaterThan(String value) {
            addCriterion("bak4 >", value, "bak4");
            return (Criteria) this;
        }

        public Criteria andBak4GreaterThanOrEqualTo(String value) {
            addCriterion("bak4 >=", value, "bak4");
            return (Criteria) this;
        }

        public Criteria andBak4LessThan(String value) {
            addCriterion("bak4 <", value, "bak4");
            return (Criteria) this;
        }

        public Criteria andBak4LessThanOrEqualTo(String value) {
            addCriterion("bak4 <=", value, "bak4");
            return (Criteria) this;
        }

        public Criteria andBak4Like(String value) {
            addCriterion("bak4 like", value, "bak4");
            return (Criteria) this;
        }

        public Criteria andBak4NotLike(String value) {
            addCriterion("bak4 not like", value, "bak4");
            return (Criteria) this;
        }

        public Criteria andBak4In(List<String> values) {
            addCriterion("bak4 in", values, "bak4");
            return (Criteria) this;
        }

        public Criteria andBak4NotIn(List<String> values) {
            addCriterion("bak4 not in", values, "bak4");
            return (Criteria) this;
        }

        public Criteria andBak4Between(String value1, String value2) {
            addCriterion("bak4 between", value1, value2, "bak4");
            return (Criteria) this;
        }

        public Criteria andBak4NotBetween(String value1, String value2) {
            addCriterion("bak4 not between", value1, value2, "bak4");
            return (Criteria) this;
        }

        public Criteria andBak5IsNull() {
            addCriterion("bak5 is null");
            return (Criteria) this;
        }

        public Criteria andBak5IsNotNull() {
            addCriterion("bak5 is not null");
            return (Criteria) this;
        }

        public Criteria andBak5EqualTo(String value) {
            addCriterion("bak5 =", value, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5NotEqualTo(String value) {
            addCriterion("bak5 <>", value, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5GreaterThan(String value) {
            addCriterion("bak5 >", value, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5GreaterThanOrEqualTo(String value) {
            addCriterion("bak5 >=", value, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5LessThan(String value) {
            addCriterion("bak5 <", value, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5LessThanOrEqualTo(String value) {
            addCriterion("bak5 <=", value, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5Like(String value) {
            addCriterion("bak5 like", value, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5NotLike(String value) {
            addCriterion("bak5 not like", value, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5In(List<String> values) {
            addCriterion("bak5 in", values, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5NotIn(List<String> values) {
            addCriterion("bak5 not in", values, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5Between(String value1, String value2) {
            addCriterion("bak5 between", value1, value2, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5NotBetween(String value1, String value2) {
            addCriterion("bak5 not between", value1, value2, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak6IsNull() {
            addCriterion("bak6 is null");
            return (Criteria) this;
        }

        public Criteria andBak6IsNotNull() {
            addCriterion("bak6 is not null");
            return (Criteria) this;
        }

        public Criteria andBak6EqualTo(String value) {
            addCriterion("bak6 =", value, "bak6");
            return (Criteria) this;
        }

        public Criteria andBak6NotEqualTo(String value) {
            addCriterion("bak6 <>", value, "bak6");
            return (Criteria) this;
        }

        public Criteria andBak6GreaterThan(String value) {
            addCriterion("bak6 >", value, "bak6");
            return (Criteria) this;
        }

        public Criteria andBak6GreaterThanOrEqualTo(String value) {
            addCriterion("bak6 >=", value, "bak6");
            return (Criteria) this;
        }

        public Criteria andBak6LessThan(String value) {
            addCriterion("bak6 <", value, "bak6");
            return (Criteria) this;
        }

        public Criteria andBak6LessThanOrEqualTo(String value) {
            addCriterion("bak6 <=", value, "bak6");
            return (Criteria) this;
        }

        public Criteria andBak6Like(String value) {
            addCriterion("bak6 like", value, "bak6");
            return (Criteria) this;
        }

        public Criteria andBak6NotLike(String value) {
            addCriterion("bak6 not like", value, "bak6");
            return (Criteria) this;
        }

        public Criteria andBak6In(List<String> values) {
            addCriterion("bak6 in", values, "bak6");
            return (Criteria) this;
        }

        public Criteria andBak6NotIn(List<String> values) {
            addCriterion("bak6 not in", values, "bak6");
            return (Criteria) this;
        }

        public Criteria andBak6Between(String value1, String value2) {
            addCriterion("bak6 between", value1, value2, "bak6");
            return (Criteria) this;
        }

        public Criteria andBak6NotBetween(String value1, String value2) {
            addCriterion("bak6 not between", value1, value2, "bak6");
            return (Criteria) this;
        }

        public Criteria andBak7IsNull() {
            addCriterion("bak7 is null");
            return (Criteria) this;
        }

        public Criteria andBak7IsNotNull() {
            addCriterion("bak7 is not null");
            return (Criteria) this;
        }

        public Criteria andBak7EqualTo(String value) {
            addCriterion("bak7 =", value, "bak7");
            return (Criteria) this;
        }

        public Criteria andBak7NotEqualTo(String value) {
            addCriterion("bak7 <>", value, "bak7");
            return (Criteria) this;
        }

        public Criteria andBak7GreaterThan(String value) {
            addCriterion("bak7 >", value, "bak7");
            return (Criteria) this;
        }

        public Criteria andBak7GreaterThanOrEqualTo(String value) {
            addCriterion("bak7 >=", value, "bak7");
            return (Criteria) this;
        }

        public Criteria andBak7LessThan(String value) {
            addCriterion("bak7 <", value, "bak7");
            return (Criteria) this;
        }

        public Criteria andBak7LessThanOrEqualTo(String value) {
            addCriterion("bak7 <=", value, "bak7");
            return (Criteria) this;
        }

        public Criteria andBak7Like(String value) {
            addCriterion("bak7 like", value, "bak7");
            return (Criteria) this;
        }

        public Criteria andBak7NotLike(String value) {
            addCriterion("bak7 not like", value, "bak7");
            return (Criteria) this;
        }

        public Criteria andBak7In(List<String> values) {
            addCriterion("bak7 in", values, "bak7");
            return (Criteria) this;
        }

        public Criteria andBak7NotIn(List<String> values) {
            addCriterion("bak7 not in", values, "bak7");
            return (Criteria) this;
        }

        public Criteria andBak7Between(String value1, String value2) {
            addCriterion("bak7 between", value1, value2, "bak7");
            return (Criteria) this;
        }

        public Criteria andBak7NotBetween(String value1, String value2) {
            addCriterion("bak7 not between", value1, value2, "bak7");
            return (Criteria) this;
        }

        public Criteria andBak8IsNull() {
            addCriterion("bak8 is null");
            return (Criteria) this;
        }

        public Criteria andBak8IsNotNull() {
            addCriterion("bak8 is not null");
            return (Criteria) this;
        }

        public Criteria andBak8EqualTo(String value) {
            addCriterion("bak8 =", value, "bak8");
            return (Criteria) this;
        }

        public Criteria andBak8NotEqualTo(String value) {
            addCriterion("bak8 <>", value, "bak8");
            return (Criteria) this;
        }

        public Criteria andBak8GreaterThan(String value) {
            addCriterion("bak8 >", value, "bak8");
            return (Criteria) this;
        }

        public Criteria andBak8GreaterThanOrEqualTo(String value) {
            addCriterion("bak8 >=", value, "bak8");
            return (Criteria) this;
        }

        public Criteria andBak8LessThan(String value) {
            addCriterion("bak8 <", value, "bak8");
            return (Criteria) this;
        }

        public Criteria andBak8LessThanOrEqualTo(String value) {
            addCriterion("bak8 <=", value, "bak8");
            return (Criteria) this;
        }

        public Criteria andBak8Like(String value) {
            addCriterion("bak8 like", value, "bak8");
            return (Criteria) this;
        }

        public Criteria andBak8NotLike(String value) {
            addCriterion("bak8 not like", value, "bak8");
            return (Criteria) this;
        }

        public Criteria andBak8In(List<String> values) {
            addCriterion("bak8 in", values, "bak8");
            return (Criteria) this;
        }

        public Criteria andBak8NotIn(List<String> values) {
            addCriterion("bak8 not in", values, "bak8");
            return (Criteria) this;
        }

        public Criteria andBak8Between(String value1, String value2) {
            addCriterion("bak8 between", value1, value2, "bak8");
            return (Criteria) this;
        }

        public Criteria andBak8NotBetween(String value1, String value2) {
            addCriterion("bak8 not between", value1, value2, "bak8");
            return (Criteria) this;
        }

        public Criteria andBak9IsNull() {
            addCriterion("bak9 is null");
            return (Criteria) this;
        }

        public Criteria andBak9IsNotNull() {
            addCriterion("bak9 is not null");
            return (Criteria) this;
        }

        public Criteria andBak9EqualTo(String value) {
            addCriterion("bak9 =", value, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9NotEqualTo(String value) {
            addCriterion("bak9 <>", value, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9GreaterThan(String value) {
            addCriterion("bak9 >", value, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9GreaterThanOrEqualTo(String value) {
            addCriterion("bak9 >=", value, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9LessThan(String value) {
            addCriterion("bak9 <", value, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9LessThanOrEqualTo(String value) {
            addCriterion("bak9 <=", value, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9Like(String value) {
            addCriterion("bak9 like", value, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9NotLike(String value) {
            addCriterion("bak9 not like", value, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9In(List<String> values) {
            addCriterion("bak9 in", values, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9NotIn(List<String> values) {
            addCriterion("bak9 not in", values, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9Between(String value1, String value2) {
            addCriterion("bak9 between", value1, value2, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9NotBetween(String value1, String value2) {
            addCriterion("bak9 not between", value1, value2, "bak9");
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