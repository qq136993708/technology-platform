package com.pcitc.base.stp.IntlProject;

import java.util.ArrayList;
import java.util.List;

public class IntlProjectContractExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IntlProjectContractExample() {
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

        public Criteria andContractIdIsNull() {
            addCriterion("contract_id is null");
            return (Criteria) this;
        }

        public Criteria andContractIdIsNotNull() {
            addCriterion("contract_id is not null");
            return (Criteria) this;
        }

        public Criteria andContractIdEqualTo(String value) {
            addCriterion("contract_id =", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotEqualTo(String value) {
            addCriterion("contract_id <>", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdGreaterThan(String value) {
            addCriterion("contract_id >", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdGreaterThanOrEqualTo(String value) {
            addCriterion("contract_id >=", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdLessThan(String value) {
            addCriterion("contract_id <", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdLessThanOrEqualTo(String value) {
            addCriterion("contract_id <=", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdLike(String value) {
            addCriterion("contract_id like", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotLike(String value) {
            addCriterion("contract_id not like", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdIn(List<String> values) {
            addCriterion("contract_id in", values, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotIn(List<String> values) {
            addCriterion("contract_id not in", values, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdBetween(String value1, String value2) {
            addCriterion("contract_id between", value1, value2, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotBetween(String value1, String value2) {
            addCriterion("contract_id not between", value1, value2, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractNoIsNull() {
            addCriterion("contract_no is null");
            return (Criteria) this;
        }

        public Criteria andContractNoIsNotNull() {
            addCriterion("contract_no is not null");
            return (Criteria) this;
        }

        public Criteria andContractNoEqualTo(String value) {
            addCriterion("contract_no =", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoNotEqualTo(String value) {
            addCriterion("contract_no <>", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoGreaterThan(String value) {
            addCriterion("contract_no >", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoGreaterThanOrEqualTo(String value) {
            addCriterion("contract_no >=", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoLessThan(String value) {
            addCriterion("contract_no <", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoLessThanOrEqualTo(String value) {
            addCriterion("contract_no <=", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoLike(String value) {
            addCriterion("contract_no like", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoNotLike(String value) {
            addCriterion("contract_no not like", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoIn(List<String> values) {
            addCriterion("contract_no in", values, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoNotIn(List<String> values) {
            addCriterion("contract_no not in", values, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoBetween(String value1, String value2) {
            addCriterion("contract_no between", value1, value2, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoNotBetween(String value1, String value2) {
            addCriterion("contract_no not between", value1, value2, "contractNo");
            return (Criteria) this;
        }

        public Criteria andSignDateIsNull() {
            addCriterion("sign_date is null");
            return (Criteria) this;
        }

        public Criteria andSignDateIsNotNull() {
            addCriterion("sign_date is not null");
            return (Criteria) this;
        }

        public Criteria andSignDateEqualTo(String value) {
            addCriterion("sign_date =", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateNotEqualTo(String value) {
            addCriterion("sign_date <>", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateGreaterThan(String value) {
            addCriterion("sign_date >", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateGreaterThanOrEqualTo(String value) {
            addCriterion("sign_date >=", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateLessThan(String value) {
            addCriterion("sign_date <", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateLessThanOrEqualTo(String value) {
            addCriterion("sign_date <=", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateLike(String value) {
            addCriterion("sign_date like", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateNotLike(String value) {
            addCriterion("sign_date not like", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateIn(List<String> values) {
            addCriterion("sign_date in", values, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateNotIn(List<String> values) {
            addCriterion("sign_date not in", values, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateBetween(String value1, String value2) {
            addCriterion("sign_date between", value1, value2, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateNotBetween(String value1, String value2) {
            addCriterion("sign_date not between", value1, value2, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignAddressIsNull() {
            addCriterion("sign_address is null");
            return (Criteria) this;
        }

        public Criteria andSignAddressIsNotNull() {
            addCriterion("sign_address is not null");
            return (Criteria) this;
        }

        public Criteria andSignAddressEqualTo(String value) {
            addCriterion("sign_address =", value, "signAddress");
            return (Criteria) this;
        }

        public Criteria andSignAddressNotEqualTo(String value) {
            addCriterion("sign_address <>", value, "signAddress");
            return (Criteria) this;
        }

        public Criteria andSignAddressGreaterThan(String value) {
            addCriterion("sign_address >", value, "signAddress");
            return (Criteria) this;
        }

        public Criteria andSignAddressGreaterThanOrEqualTo(String value) {
            addCriterion("sign_address >=", value, "signAddress");
            return (Criteria) this;
        }

        public Criteria andSignAddressLessThan(String value) {
            addCriterion("sign_address <", value, "signAddress");
            return (Criteria) this;
        }

        public Criteria andSignAddressLessThanOrEqualTo(String value) {
            addCriterion("sign_address <=", value, "signAddress");
            return (Criteria) this;
        }

        public Criteria andSignAddressLike(String value) {
            addCriterion("sign_address like", value, "signAddress");
            return (Criteria) this;
        }

        public Criteria andSignAddressNotLike(String value) {
            addCriterion("sign_address not like", value, "signAddress");
            return (Criteria) this;
        }

        public Criteria andSignAddressIn(List<String> values) {
            addCriterion("sign_address in", values, "signAddress");
            return (Criteria) this;
        }

        public Criteria andSignAddressNotIn(List<String> values) {
            addCriterion("sign_address not in", values, "signAddress");
            return (Criteria) this;
        }

        public Criteria andSignAddressBetween(String value1, String value2) {
            addCriterion("sign_address between", value1, value2, "signAddress");
            return (Criteria) this;
        }

        public Criteria andSignAddressNotBetween(String value1, String value2) {
            addCriterion("sign_address not between", value1, value2, "signAddress");
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

        public Criteria andContractContentIsNull() {
            addCriterion("contract_content is null");
            return (Criteria) this;
        }

        public Criteria andContractContentIsNotNull() {
            addCriterion("contract_content is not null");
            return (Criteria) this;
        }

        public Criteria andContractContentEqualTo(String value) {
            addCriterion("contract_content =", value, "contractContent");
            return (Criteria) this;
        }

        public Criteria andContractContentNotEqualTo(String value) {
            addCriterion("contract_content <>", value, "contractContent");
            return (Criteria) this;
        }

        public Criteria andContractContentGreaterThan(String value) {
            addCriterion("contract_content >", value, "contractContent");
            return (Criteria) this;
        }

        public Criteria andContractContentGreaterThanOrEqualTo(String value) {
            addCriterion("contract_content >=", value, "contractContent");
            return (Criteria) this;
        }

        public Criteria andContractContentLessThan(String value) {
            addCriterion("contract_content <", value, "contractContent");
            return (Criteria) this;
        }

        public Criteria andContractContentLessThanOrEqualTo(String value) {
            addCriterion("contract_content <=", value, "contractContent");
            return (Criteria) this;
        }

        public Criteria andContractContentLike(String value) {
            addCriterion("contract_content like", value, "contractContent");
            return (Criteria) this;
        }

        public Criteria andContractContentNotLike(String value) {
            addCriterion("contract_content not like", value, "contractContent");
            return (Criteria) this;
        }

        public Criteria andContractContentIn(List<String> values) {
            addCriterion("contract_content in", values, "contractContent");
            return (Criteria) this;
        }

        public Criteria andContractContentNotIn(List<String> values) {
            addCriterion("contract_content not in", values, "contractContent");
            return (Criteria) this;
        }

        public Criteria andContractContentBetween(String value1, String value2) {
            addCriterion("contract_content between", value1, value2, "contractContent");
            return (Criteria) this;
        }

        public Criteria andContractContentNotBetween(String value1, String value2) {
            addCriterion("contract_content not between", value1, value2, "contractContent");
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

        public Criteria andStartDateIsNull() {
            addCriterion("start_date is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("start_date is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(String value) {
            addCriterion("start_date =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(String value) {
            addCriterion("start_date <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(String value) {
            addCriterion("start_date >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(String value) {
            addCriterion("start_date >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(String value) {
            addCriterion("start_date <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(String value) {
            addCriterion("start_date <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLike(String value) {
            addCriterion("start_date like", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotLike(String value) {
            addCriterion("start_date not like", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<String> values) {
            addCriterion("start_date in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<String> values) {
            addCriterion("start_date not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(String value1, String value2) {
            addCriterion("start_date between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(String value1, String value2) {
            addCriterion("start_date not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(String value) {
            addCriterion("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(String value) {
            addCriterion("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(String value) {
            addCriterion("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(String value) {
            addCriterion("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(String value) {
            addCriterion("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(String value) {
            addCriterion("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLike(String value) {
            addCriterion("end_date like", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotLike(String value) {
            addCriterion("end_date not like", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<String> values) {
            addCriterion("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<String> values) {
            addCriterion("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(String value1, String value2) {
            addCriterion("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(String value1, String value2) {
            addCriterion("end_date not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andSecrecyTimesIsNull() {
            addCriterion("secrecy_times is null");
            return (Criteria) this;
        }

        public Criteria andSecrecyTimesIsNotNull() {
            addCriterion("secrecy_times is not null");
            return (Criteria) this;
        }

        public Criteria andSecrecyTimesEqualTo(String value) {
            addCriterion("secrecy_times =", value, "secrecyTimes");
            return (Criteria) this;
        }

        public Criteria andSecrecyTimesNotEqualTo(String value) {
            addCriterion("secrecy_times <>", value, "secrecyTimes");
            return (Criteria) this;
        }

        public Criteria andSecrecyTimesGreaterThan(String value) {
            addCriterion("secrecy_times >", value, "secrecyTimes");
            return (Criteria) this;
        }

        public Criteria andSecrecyTimesGreaterThanOrEqualTo(String value) {
            addCriterion("secrecy_times >=", value, "secrecyTimes");
            return (Criteria) this;
        }

        public Criteria andSecrecyTimesLessThan(String value) {
            addCriterion("secrecy_times <", value, "secrecyTimes");
            return (Criteria) this;
        }

        public Criteria andSecrecyTimesLessThanOrEqualTo(String value) {
            addCriterion("secrecy_times <=", value, "secrecyTimes");
            return (Criteria) this;
        }

        public Criteria andSecrecyTimesLike(String value) {
            addCriterion("secrecy_times like", value, "secrecyTimes");
            return (Criteria) this;
        }

        public Criteria andSecrecyTimesNotLike(String value) {
            addCriterion("secrecy_times not like", value, "secrecyTimes");
            return (Criteria) this;
        }

        public Criteria andSecrecyTimesIn(List<String> values) {
            addCriterion("secrecy_times in", values, "secrecyTimes");
            return (Criteria) this;
        }

        public Criteria andSecrecyTimesNotIn(List<String> values) {
            addCriterion("secrecy_times not in", values, "secrecyTimes");
            return (Criteria) this;
        }

        public Criteria andSecrecyTimesBetween(String value1, String value2) {
            addCriterion("secrecy_times between", value1, value2, "secrecyTimes");
            return (Criteria) this;
        }

        public Criteria andSecrecyTimesNotBetween(String value1, String value2) {
            addCriterion("secrecy_times not between", value1, value2, "secrecyTimes");
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

        public Criteria andFlowAgreementReviewIsNull() {
            addCriterion("flow_agreement_review is null");
            return (Criteria) this;
        }

        public Criteria andFlowAgreementReviewIsNotNull() {
            addCriterion("flow_agreement_review is not null");
            return (Criteria) this;
        }

        public Criteria andFlowAgreementReviewEqualTo(Integer value) {
            addCriterion("flow_agreement_review =", value, "flowAgreementReview");
            return (Criteria) this;
        }

        public Criteria andFlowAgreementReviewNotEqualTo(Integer value) {
            addCriterion("flow_agreement_review <>", value, "flowAgreementReview");
            return (Criteria) this;
        }

        public Criteria andFlowAgreementReviewGreaterThan(Integer value) {
            addCriterion("flow_agreement_review >", value, "flowAgreementReview");
            return (Criteria) this;
        }

        public Criteria andFlowAgreementReviewGreaterThanOrEqualTo(Integer value) {
            addCriterion("flow_agreement_review >=", value, "flowAgreementReview");
            return (Criteria) this;
        }

        public Criteria andFlowAgreementReviewLessThan(Integer value) {
            addCriterion("flow_agreement_review <", value, "flowAgreementReview");
            return (Criteria) this;
        }

        public Criteria andFlowAgreementReviewLessThanOrEqualTo(Integer value) {
            addCriterion("flow_agreement_review <=", value, "flowAgreementReview");
            return (Criteria) this;
        }

        public Criteria andFlowAgreementReviewIn(List<Integer> values) {
            addCriterion("flow_agreement_review in", values, "flowAgreementReview");
            return (Criteria) this;
        }

        public Criteria andFlowAgreementReviewNotIn(List<Integer> values) {
            addCriterion("flow_agreement_review not in", values, "flowAgreementReview");
            return (Criteria) this;
        }

        public Criteria andFlowAgreementReviewBetween(Integer value1, Integer value2) {
            addCriterion("flow_agreement_review between", value1, value2, "flowAgreementReview");
            return (Criteria) this;
        }

        public Criteria andFlowAgreementReviewNotBetween(Integer value1, Integer value2) {
            addCriterion("flow_agreement_review not between", value1, value2, "flowAgreementReview");
            return (Criteria) this;
        }

        public Criteria andFlowTechnologyReviewIsNull() {
            addCriterion("flow_technology_review is null");
            return (Criteria) this;
        }

        public Criteria andFlowTechnologyReviewIsNotNull() {
            addCriterion("flow_technology_review is not null");
            return (Criteria) this;
        }

        public Criteria andFlowTechnologyReviewEqualTo(Integer value) {
            addCriterion("flow_technology_review =", value, "flowTechnologyReview");
            return (Criteria) this;
        }

        public Criteria andFlowTechnologyReviewNotEqualTo(Integer value) {
            addCriterion("flow_technology_review <>", value, "flowTechnologyReview");
            return (Criteria) this;
        }

        public Criteria andFlowTechnologyReviewGreaterThan(Integer value) {
            addCriterion("flow_technology_review >", value, "flowTechnologyReview");
            return (Criteria) this;
        }

        public Criteria andFlowTechnologyReviewGreaterThanOrEqualTo(Integer value) {
            addCriterion("flow_technology_review >=", value, "flowTechnologyReview");
            return (Criteria) this;
        }

        public Criteria andFlowTechnologyReviewLessThan(Integer value) {
            addCriterion("flow_technology_review <", value, "flowTechnologyReview");
            return (Criteria) this;
        }

        public Criteria andFlowTechnologyReviewLessThanOrEqualTo(Integer value) {
            addCriterion("flow_technology_review <=", value, "flowTechnologyReview");
            return (Criteria) this;
        }

        public Criteria andFlowTechnologyReviewIn(List<Integer> values) {
            addCriterion("flow_technology_review in", values, "flowTechnologyReview");
            return (Criteria) this;
        }

        public Criteria andFlowTechnologyReviewNotIn(List<Integer> values) {
            addCriterion("flow_technology_review not in", values, "flowTechnologyReview");
            return (Criteria) this;
        }

        public Criteria andFlowTechnologyReviewBetween(Integer value1, Integer value2) {
            addCriterion("flow_technology_review between", value1, value2, "flowTechnologyReview");
            return (Criteria) this;
        }

        public Criteria andFlowTechnologyReviewNotBetween(Integer value1, Integer value2) {
            addCriterion("flow_technology_review not between", value1, value2, "flowTechnologyReview");
            return (Criteria) this;
        }

        public Criteria andFlowKnowledgeReviewIsNull() {
            addCriterion("flow_knowledge_review is null");
            return (Criteria) this;
        }

        public Criteria andFlowKnowledgeReviewIsNotNull() {
            addCriterion("flow_knowledge_review is not null");
            return (Criteria) this;
        }

        public Criteria andFlowKnowledgeReviewEqualTo(Integer value) {
            addCriterion("flow_knowledge_review =", value, "flowKnowledgeReview");
            return (Criteria) this;
        }

        public Criteria andFlowKnowledgeReviewNotEqualTo(Integer value) {
            addCriterion("flow_knowledge_review <>", value, "flowKnowledgeReview");
            return (Criteria) this;
        }

        public Criteria andFlowKnowledgeReviewGreaterThan(Integer value) {
            addCriterion("flow_knowledge_review >", value, "flowKnowledgeReview");
            return (Criteria) this;
        }

        public Criteria andFlowKnowledgeReviewGreaterThanOrEqualTo(Integer value) {
            addCriterion("flow_knowledge_review >=", value, "flowKnowledgeReview");
            return (Criteria) this;
        }

        public Criteria andFlowKnowledgeReviewLessThan(Integer value) {
            addCriterion("flow_knowledge_review <", value, "flowKnowledgeReview");
            return (Criteria) this;
        }

        public Criteria andFlowKnowledgeReviewLessThanOrEqualTo(Integer value) {
            addCriterion("flow_knowledge_review <=", value, "flowKnowledgeReview");
            return (Criteria) this;
        }

        public Criteria andFlowKnowledgeReviewIn(List<Integer> values) {
            addCriterion("flow_knowledge_review in", values, "flowKnowledgeReview");
            return (Criteria) this;
        }

        public Criteria andFlowKnowledgeReviewNotIn(List<Integer> values) {
            addCriterion("flow_knowledge_review not in", values, "flowKnowledgeReview");
            return (Criteria) this;
        }

        public Criteria andFlowKnowledgeReviewBetween(Integer value1, Integer value2) {
            addCriterion("flow_knowledge_review between", value1, value2, "flowKnowledgeReview");
            return (Criteria) this;
        }

        public Criteria andFlowKnowledgeReviewNotBetween(Integer value1, Integer value2) {
            addCriterion("flow_knowledge_review not between", value1, value2, "flowKnowledgeReview");
            return (Criteria) this;
        }

        public Criteria andFlowComprehensiveReviewIsNull() {
            addCriterion("flow_comprehensive_review is null");
            return (Criteria) this;
        }

        public Criteria andFlowComprehensiveReviewIsNotNull() {
            addCriterion("flow_comprehensive_review is not null");
            return (Criteria) this;
        }

        public Criteria andFlowComprehensiveReviewEqualTo(Integer value) {
            addCriterion("flow_comprehensive_review =", value, "flowComprehensiveReview");
            return (Criteria) this;
        }

        public Criteria andFlowComprehensiveReviewNotEqualTo(Integer value) {
            addCriterion("flow_comprehensive_review <>", value, "flowComprehensiveReview");
            return (Criteria) this;
        }

        public Criteria andFlowComprehensiveReviewGreaterThan(Integer value) {
            addCriterion("flow_comprehensive_review >", value, "flowComprehensiveReview");
            return (Criteria) this;
        }

        public Criteria andFlowComprehensiveReviewGreaterThanOrEqualTo(Integer value) {
            addCriterion("flow_comprehensive_review >=", value, "flowComprehensiveReview");
            return (Criteria) this;
        }

        public Criteria andFlowComprehensiveReviewLessThan(Integer value) {
            addCriterion("flow_comprehensive_review <", value, "flowComprehensiveReview");
            return (Criteria) this;
        }

        public Criteria andFlowComprehensiveReviewLessThanOrEqualTo(Integer value) {
            addCriterion("flow_comprehensive_review <=", value, "flowComprehensiveReview");
            return (Criteria) this;
        }

        public Criteria andFlowComprehensiveReviewIn(List<Integer> values) {
            addCriterion("flow_comprehensive_review in", values, "flowComprehensiveReview");
            return (Criteria) this;
        }

        public Criteria andFlowComprehensiveReviewNotIn(List<Integer> values) {
            addCriterion("flow_comprehensive_review not in", values, "flowComprehensiveReview");
            return (Criteria) this;
        }

        public Criteria andFlowComprehensiveReviewBetween(Integer value1, Integer value2) {
            addCriterion("flow_comprehensive_review between", value1, value2, "flowComprehensiveReview");
            return (Criteria) this;
        }

        public Criteria andFlowComprehensiveReviewNotBetween(Integer value1, Integer value2) {
            addCriterion("flow_comprehensive_review not between", value1, value2, "flowComprehensiveReview");
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

        public Criteria andContractStatusIsNull() {
            addCriterion("contract_status is null");
            return (Criteria) this;
        }

        public Criteria andContractStatusIsNotNull() {
            addCriterion("contract_status is not null");
            return (Criteria) this;
        }

        public Criteria andContractStatusEqualTo(Integer value) {
            addCriterion("contract_status =", value, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andContractStatusNotEqualTo(Integer value) {
            addCriterion("contract_status <>", value, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andContractStatusGreaterThan(Integer value) {
            addCriterion("contract_status >", value, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andContractStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("contract_status >=", value, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andContractStatusLessThan(Integer value) {
            addCriterion("contract_status <", value, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andContractStatusLessThanOrEqualTo(Integer value) {
            addCriterion("contract_status <=", value, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andContractStatusIn(List<Integer> values) {
            addCriterion("contract_status in", values, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andContractStatusNotIn(List<Integer> values) {
            addCriterion("contract_status not in", values, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andContractStatusBetween(Integer value1, Integer value2) {
            addCriterion("contract_status between", value1, value2, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andContractStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("contract_status not between", value1, value2, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andChineseContractCompanyIsNull() {
            addCriterion("chinese_contract_company is null");
            return (Criteria) this;
        }

        public Criteria andChineseContractCompanyIsNotNull() {
            addCriterion("chinese_contract_company is not null");
            return (Criteria) this;
        }

        public Criteria andChineseContractCompanyEqualTo(String value) {
            addCriterion("chinese_contract_company =", value, "chineseContractCompany");
            return (Criteria) this;
        }

        public Criteria andChineseContractCompanyNotEqualTo(String value) {
            addCriterion("chinese_contract_company <>", value, "chineseContractCompany");
            return (Criteria) this;
        }

        public Criteria andChineseContractCompanyGreaterThan(String value) {
            addCriterion("chinese_contract_company >", value, "chineseContractCompany");
            return (Criteria) this;
        }

        public Criteria andChineseContractCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("chinese_contract_company >=", value, "chineseContractCompany");
            return (Criteria) this;
        }

        public Criteria andChineseContractCompanyLessThan(String value) {
            addCriterion("chinese_contract_company <", value, "chineseContractCompany");
            return (Criteria) this;
        }

        public Criteria andChineseContractCompanyLessThanOrEqualTo(String value) {
            addCriterion("chinese_contract_company <=", value, "chineseContractCompany");
            return (Criteria) this;
        }

        public Criteria andChineseContractCompanyLike(String value) {
            addCriterion("chinese_contract_company like", value, "chineseContractCompany");
            return (Criteria) this;
        }

        public Criteria andChineseContractCompanyNotLike(String value) {
            addCriterion("chinese_contract_company not like", value, "chineseContractCompany");
            return (Criteria) this;
        }

        public Criteria andChineseContractCompanyIn(List<String> values) {
            addCriterion("chinese_contract_company in", values, "chineseContractCompany");
            return (Criteria) this;
        }

        public Criteria andChineseContractCompanyNotIn(List<String> values) {
            addCriterion("chinese_contract_company not in", values, "chineseContractCompany");
            return (Criteria) this;
        }

        public Criteria andChineseContractCompanyBetween(String value1, String value2) {
            addCriterion("chinese_contract_company between", value1, value2, "chineseContractCompany");
            return (Criteria) this;
        }

        public Criteria andChineseContractCompanyNotBetween(String value1, String value2) {
            addCriterion("chinese_contract_company not between", value1, value2, "chineseContractCompany");
            return (Criteria) this;
        }

        public Criteria andForeignContractCompanyIsNull() {
            addCriterion("foreign_contract_company is null");
            return (Criteria) this;
        }

        public Criteria andForeignContractCompanyIsNotNull() {
            addCriterion("foreign_contract_company is not null");
            return (Criteria) this;
        }

        public Criteria andForeignContractCompanyEqualTo(String value) {
            addCriterion("foreign_contract_company =", value, "foreignContractCompany");
            return (Criteria) this;
        }

        public Criteria andForeignContractCompanyNotEqualTo(String value) {
            addCriterion("foreign_contract_company <>", value, "foreignContractCompany");
            return (Criteria) this;
        }

        public Criteria andForeignContractCompanyGreaterThan(String value) {
            addCriterion("foreign_contract_company >", value, "foreignContractCompany");
            return (Criteria) this;
        }

        public Criteria andForeignContractCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("foreign_contract_company >=", value, "foreignContractCompany");
            return (Criteria) this;
        }

        public Criteria andForeignContractCompanyLessThan(String value) {
            addCriterion("foreign_contract_company <", value, "foreignContractCompany");
            return (Criteria) this;
        }

        public Criteria andForeignContractCompanyLessThanOrEqualTo(String value) {
            addCriterion("foreign_contract_company <=", value, "foreignContractCompany");
            return (Criteria) this;
        }

        public Criteria andForeignContractCompanyLike(String value) {
            addCriterion("foreign_contract_company like", value, "foreignContractCompany");
            return (Criteria) this;
        }

        public Criteria andForeignContractCompanyNotLike(String value) {
            addCriterion("foreign_contract_company not like", value, "foreignContractCompany");
            return (Criteria) this;
        }

        public Criteria andForeignContractCompanyIn(List<String> values) {
            addCriterion("foreign_contract_company in", values, "foreignContractCompany");
            return (Criteria) this;
        }

        public Criteria andForeignContractCompanyNotIn(List<String> values) {
            addCriterion("foreign_contract_company not in", values, "foreignContractCompany");
            return (Criteria) this;
        }

        public Criteria andForeignContractCompanyBetween(String value1, String value2) {
            addCriterion("foreign_contract_company between", value1, value2, "foreignContractCompany");
            return (Criteria) this;
        }

        public Criteria andForeignContractCompanyNotBetween(String value1, String value2) {
            addCriterion("foreign_contract_company not between", value1, value2, "foreignContractCompany");
            return (Criteria) this;
        }

        public Criteria andCompanyIntroductionIsNull() {
            addCriterion("company_introduction is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIntroductionIsNotNull() {
            addCriterion("company_introduction is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIntroductionEqualTo(String value) {
            addCriterion("company_introduction =", value, "companyIntroduction");
            return (Criteria) this;
        }

        public Criteria andCompanyIntroductionNotEqualTo(String value) {
            addCriterion("company_introduction <>", value, "companyIntroduction");
            return (Criteria) this;
        }

        public Criteria andCompanyIntroductionGreaterThan(String value) {
            addCriterion("company_introduction >", value, "companyIntroduction");
            return (Criteria) this;
        }

        public Criteria andCompanyIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("company_introduction >=", value, "companyIntroduction");
            return (Criteria) this;
        }

        public Criteria andCompanyIntroductionLessThan(String value) {
            addCriterion("company_introduction <", value, "companyIntroduction");
            return (Criteria) this;
        }

        public Criteria andCompanyIntroductionLessThanOrEqualTo(String value) {
            addCriterion("company_introduction <=", value, "companyIntroduction");
            return (Criteria) this;
        }

        public Criteria andCompanyIntroductionLike(String value) {
            addCriterion("company_introduction like", value, "companyIntroduction");
            return (Criteria) this;
        }

        public Criteria andCompanyIntroductionNotLike(String value) {
            addCriterion("company_introduction not like", value, "companyIntroduction");
            return (Criteria) this;
        }

        public Criteria andCompanyIntroductionIn(List<String> values) {
            addCriterion("company_introduction in", values, "companyIntroduction");
            return (Criteria) this;
        }

        public Criteria andCompanyIntroductionNotIn(List<String> values) {
            addCriterion("company_introduction not in", values, "companyIntroduction");
            return (Criteria) this;
        }

        public Criteria andCompanyIntroductionBetween(String value1, String value2) {
            addCriterion("company_introduction between", value1, value2, "companyIntroduction");
            return (Criteria) this;
        }

        public Criteria andCompanyIntroductionNotBetween(String value1, String value2) {
            addCriterion("company_introduction not between", value1, value2, "companyIntroduction");
            return (Criteria) this;
        }

        public Criteria andCompanyAdvantageIsNull() {
            addCriterion("company_advantage is null");
            return (Criteria) this;
        }

        public Criteria andCompanyAdvantageIsNotNull() {
            addCriterion("company_advantage is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyAdvantageEqualTo(String value) {
            addCriterion("company_advantage =", value, "companyAdvantage");
            return (Criteria) this;
        }

        public Criteria andCompanyAdvantageNotEqualTo(String value) {
            addCriterion("company_advantage <>", value, "companyAdvantage");
            return (Criteria) this;
        }

        public Criteria andCompanyAdvantageGreaterThan(String value) {
            addCriterion("company_advantage >", value, "companyAdvantage");
            return (Criteria) this;
        }

        public Criteria andCompanyAdvantageGreaterThanOrEqualTo(String value) {
            addCriterion("company_advantage >=", value, "companyAdvantage");
            return (Criteria) this;
        }

        public Criteria andCompanyAdvantageLessThan(String value) {
            addCriterion("company_advantage <", value, "companyAdvantage");
            return (Criteria) this;
        }

        public Criteria andCompanyAdvantageLessThanOrEqualTo(String value) {
            addCriterion("company_advantage <=", value, "companyAdvantage");
            return (Criteria) this;
        }

        public Criteria andCompanyAdvantageLike(String value) {
            addCriterion("company_advantage like", value, "companyAdvantage");
            return (Criteria) this;
        }

        public Criteria andCompanyAdvantageNotLike(String value) {
            addCriterion("company_advantage not like", value, "companyAdvantage");
            return (Criteria) this;
        }

        public Criteria andCompanyAdvantageIn(List<String> values) {
            addCriterion("company_advantage in", values, "companyAdvantage");
            return (Criteria) this;
        }

        public Criteria andCompanyAdvantageNotIn(List<String> values) {
            addCriterion("company_advantage not in", values, "companyAdvantage");
            return (Criteria) this;
        }

        public Criteria andCompanyAdvantageBetween(String value1, String value2) {
            addCriterion("company_advantage between", value1, value2, "companyAdvantage");
            return (Criteria) this;
        }

        public Criteria andCompanyAdvantageNotBetween(String value1, String value2) {
            addCriterion("company_advantage not between", value1, value2, "companyAdvantage");
            return (Criteria) this;
        }

        public Criteria andProjectTargetIsNull() {
            addCriterion("project_target is null");
            return (Criteria) this;
        }

        public Criteria andProjectTargetIsNotNull() {
            addCriterion("project_target is not null");
            return (Criteria) this;
        }

        public Criteria andProjectTargetEqualTo(String value) {
            addCriterion("project_target =", value, "projectTarget");
            return (Criteria) this;
        }

        public Criteria andProjectTargetNotEqualTo(String value) {
            addCriterion("project_target <>", value, "projectTarget");
            return (Criteria) this;
        }

        public Criteria andProjectTargetGreaterThan(String value) {
            addCriterion("project_target >", value, "projectTarget");
            return (Criteria) this;
        }

        public Criteria andProjectTargetGreaterThanOrEqualTo(String value) {
            addCriterion("project_target >=", value, "projectTarget");
            return (Criteria) this;
        }

        public Criteria andProjectTargetLessThan(String value) {
            addCriterion("project_target <", value, "projectTarget");
            return (Criteria) this;
        }

        public Criteria andProjectTargetLessThanOrEqualTo(String value) {
            addCriterion("project_target <=", value, "projectTarget");
            return (Criteria) this;
        }

        public Criteria andProjectTargetLike(String value) {
            addCriterion("project_target like", value, "projectTarget");
            return (Criteria) this;
        }

        public Criteria andProjectTargetNotLike(String value) {
            addCriterion("project_target not like", value, "projectTarget");
            return (Criteria) this;
        }

        public Criteria andProjectTargetIn(List<String> values) {
            addCriterion("project_target in", values, "projectTarget");
            return (Criteria) this;
        }

        public Criteria andProjectTargetNotIn(List<String> values) {
            addCriterion("project_target not in", values, "projectTarget");
            return (Criteria) this;
        }

        public Criteria andProjectTargetBetween(String value1, String value2) {
            addCriterion("project_target between", value1, value2, "projectTarget");
            return (Criteria) this;
        }

        public Criteria andProjectTargetNotBetween(String value1, String value2) {
            addCriterion("project_target not between", value1, value2, "projectTarget");
            return (Criteria) this;
        }

        public Criteria andResearchContentIsNull() {
            addCriterion("research_content is null");
            return (Criteria) this;
        }

        public Criteria andResearchContentIsNotNull() {
            addCriterion("research_content is not null");
            return (Criteria) this;
        }

        public Criteria andResearchContentEqualTo(String value) {
            addCriterion("research_content =", value, "researchContent");
            return (Criteria) this;
        }

        public Criteria andResearchContentNotEqualTo(String value) {
            addCriterion("research_content <>", value, "researchContent");
            return (Criteria) this;
        }

        public Criteria andResearchContentGreaterThan(String value) {
            addCriterion("research_content >", value, "researchContent");
            return (Criteria) this;
        }

        public Criteria andResearchContentGreaterThanOrEqualTo(String value) {
            addCriterion("research_content >=", value, "researchContent");
            return (Criteria) this;
        }

        public Criteria andResearchContentLessThan(String value) {
            addCriterion("research_content <", value, "researchContent");
            return (Criteria) this;
        }

        public Criteria andResearchContentLessThanOrEqualTo(String value) {
            addCriterion("research_content <=", value, "researchContent");
            return (Criteria) this;
        }

        public Criteria andResearchContentLike(String value) {
            addCriterion("research_content like", value, "researchContent");
            return (Criteria) this;
        }

        public Criteria andResearchContentNotLike(String value) {
            addCriterion("research_content not like", value, "researchContent");
            return (Criteria) this;
        }

        public Criteria andResearchContentIn(List<String> values) {
            addCriterion("research_content in", values, "researchContent");
            return (Criteria) this;
        }

        public Criteria andResearchContentNotIn(List<String> values) {
            addCriterion("research_content not in", values, "researchContent");
            return (Criteria) this;
        }

        public Criteria andResearchContentBetween(String value1, String value2) {
            addCriterion("research_content between", value1, value2, "researchContent");
            return (Criteria) this;
        }

        public Criteria andResearchContentNotBetween(String value1, String value2) {
            addCriterion("research_content not between", value1, value2, "researchContent");
            return (Criteria) this;
        }

        public Criteria andPersonStudyIsNull() {
            addCriterion("person_study is null");
            return (Criteria) this;
        }

        public Criteria andPersonStudyIsNotNull() {
            addCriterion("person_study is not null");
            return (Criteria) this;
        }

        public Criteria andPersonStudyEqualTo(String value) {
            addCriterion("person_study =", value, "personStudy");
            return (Criteria) this;
        }

        public Criteria andPersonStudyNotEqualTo(String value) {
            addCriterion("person_study <>", value, "personStudy");
            return (Criteria) this;
        }

        public Criteria andPersonStudyGreaterThan(String value) {
            addCriterion("person_study >", value, "personStudy");
            return (Criteria) this;
        }

        public Criteria andPersonStudyGreaterThanOrEqualTo(String value) {
            addCriterion("person_study >=", value, "personStudy");
            return (Criteria) this;
        }

        public Criteria andPersonStudyLessThan(String value) {
            addCriterion("person_study <", value, "personStudy");
            return (Criteria) this;
        }

        public Criteria andPersonStudyLessThanOrEqualTo(String value) {
            addCriterion("person_study <=", value, "personStudy");
            return (Criteria) this;
        }

        public Criteria andPersonStudyLike(String value) {
            addCriterion("person_study like", value, "personStudy");
            return (Criteria) this;
        }

        public Criteria andPersonStudyNotLike(String value) {
            addCriterion("person_study not like", value, "personStudy");
            return (Criteria) this;
        }

        public Criteria andPersonStudyIn(List<String> values) {
            addCriterion("person_study in", values, "personStudy");
            return (Criteria) this;
        }

        public Criteria andPersonStudyNotIn(List<String> values) {
            addCriterion("person_study not in", values, "personStudy");
            return (Criteria) this;
        }

        public Criteria andPersonStudyBetween(String value1, String value2) {
            addCriterion("person_study between", value1, value2, "personStudy");
            return (Criteria) this;
        }

        public Criteria andPersonStudyNotBetween(String value1, String value2) {
            addCriterion("person_study not between", value1, value2, "personStudy");
            return (Criteria) this;
        }

        public Criteria andResultStatusIsNull() {
            addCriterion("result_status is null");
            return (Criteria) this;
        }

        public Criteria andResultStatusIsNotNull() {
            addCriterion("result_status is not null");
            return (Criteria) this;
        }

        public Criteria andResultStatusEqualTo(String value) {
            addCriterion("result_status =", value, "resultStatus");
            return (Criteria) this;
        }

        public Criteria andResultStatusNotEqualTo(String value) {
            addCriterion("result_status <>", value, "resultStatus");
            return (Criteria) this;
        }

        public Criteria andResultStatusGreaterThan(String value) {
            addCriterion("result_status >", value, "resultStatus");
            return (Criteria) this;
        }

        public Criteria andResultStatusGreaterThanOrEqualTo(String value) {
            addCriterion("result_status >=", value, "resultStatus");
            return (Criteria) this;
        }

        public Criteria andResultStatusLessThan(String value) {
            addCriterion("result_status <", value, "resultStatus");
            return (Criteria) this;
        }

        public Criteria andResultStatusLessThanOrEqualTo(String value) {
            addCriterion("result_status <=", value, "resultStatus");
            return (Criteria) this;
        }

        public Criteria andResultStatusLike(String value) {
            addCriterion("result_status like", value, "resultStatus");
            return (Criteria) this;
        }

        public Criteria andResultStatusNotLike(String value) {
            addCriterion("result_status not like", value, "resultStatus");
            return (Criteria) this;
        }

        public Criteria andResultStatusIn(List<String> values) {
            addCriterion("result_status in", values, "resultStatus");
            return (Criteria) this;
        }

        public Criteria andResultStatusNotIn(List<String> values) {
            addCriterion("result_status not in", values, "resultStatus");
            return (Criteria) this;
        }

        public Criteria andResultStatusBetween(String value1, String value2) {
            addCriterion("result_status between", value1, value2, "resultStatus");
            return (Criteria) this;
        }

        public Criteria andResultStatusNotBetween(String value1, String value2) {
            addCriterion("result_status not between", value1, value2, "resultStatus");
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

        public Criteria andCountryNameIsNull() {
            addCriterion("country_name is null");
            return (Criteria) this;
        }

        public Criteria andCountryNameIsNotNull() {
            addCriterion("country_name is not null");
            return (Criteria) this;
        }

        public Criteria andCountryNameEqualTo(String value) {
            addCriterion("country_name =", value, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameNotEqualTo(String value) {
            addCriterion("country_name <>", value, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameGreaterThan(String value) {
            addCriterion("country_name >", value, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameGreaterThanOrEqualTo(String value) {
            addCriterion("country_name >=", value, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameLessThan(String value) {
            addCriterion("country_name <", value, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameLessThanOrEqualTo(String value) {
            addCriterion("country_name <=", value, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameLike(String value) {
            addCriterion("country_name like", value, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameNotLike(String value) {
            addCriterion("country_name not like", value, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameIn(List<String> values) {
            addCriterion("country_name in", values, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameNotIn(List<String> values) {
            addCriterion("country_name not in", values, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameBetween(String value1, String value2) {
            addCriterion("country_name between", value1, value2, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameNotBetween(String value1, String value2) {
            addCriterion("country_name not between", value1, value2, "countryName");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeIsNull() {
            addCriterion("money_type is null");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeIsNotNull() {
            addCriterion("money_type is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeEqualTo(String value) {
            addCriterion("money_type =", value, "moneyType");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeNotEqualTo(String value) {
            addCriterion("money_type <>", value, "moneyType");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeGreaterThan(String value) {
            addCriterion("money_type >", value, "moneyType");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("money_type >=", value, "moneyType");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeLessThan(String value) {
            addCriterion("money_type <", value, "moneyType");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeLessThanOrEqualTo(String value) {
            addCriterion("money_type <=", value, "moneyType");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeLike(String value) {
            addCriterion("money_type like", value, "moneyType");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeNotLike(String value) {
            addCriterion("money_type not like", value, "moneyType");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeIn(List<String> values) {
            addCriterion("money_type in", values, "moneyType");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeNotIn(List<String> values) {
            addCriterion("money_type not in", values, "moneyType");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeBetween(String value1, String value2) {
            addCriterion("money_type between", value1, value2, "moneyType");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeNotBetween(String value1, String value2) {
            addCriterion("money_type not between", value1, value2, "moneyType");
            return (Criteria) this;
        }

        public Criteria andForeignMoneyIsNull() {
            addCriterion("foreign_money is null");
            return (Criteria) this;
        }

        public Criteria andForeignMoneyIsNotNull() {
            addCriterion("foreign_money is not null");
            return (Criteria) this;
        }

        public Criteria andForeignMoneyEqualTo(Double value) {
            addCriterion("foreign_money =", value, "foreignMoney");
            return (Criteria) this;
        }

        public Criteria andForeignMoneyNotEqualTo(Double value) {
            addCriterion("foreign_money <>", value, "foreignMoney");
            return (Criteria) this;
        }

        public Criteria andForeignMoneyGreaterThan(Double value) {
            addCriterion("foreign_money >", value, "foreignMoney");
            return (Criteria) this;
        }

        public Criteria andForeignMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("foreign_money >=", value, "foreignMoney");
            return (Criteria) this;
        }

        public Criteria andForeignMoneyLessThan(Double value) {
            addCriterion("foreign_money <", value, "foreignMoney");
            return (Criteria) this;
        }

        public Criteria andForeignMoneyLessThanOrEqualTo(Double value) {
            addCriterion("foreign_money <=", value, "foreignMoney");
            return (Criteria) this;
        }

        public Criteria andForeignMoneyIn(List<Double> values) {
            addCriterion("foreign_money in", values, "foreignMoney");
            return (Criteria) this;
        }

        public Criteria andForeignMoneyNotIn(List<Double> values) {
            addCriterion("foreign_money not in", values, "foreignMoney");
            return (Criteria) this;
        }

        public Criteria andForeignMoneyBetween(Double value1, Double value2) {
            addCriterion("foreign_money between", value1, value2, "foreignMoney");
            return (Criteria) this;
        }

        public Criteria andForeignMoneyNotBetween(Double value1, Double value2) {
            addCriterion("foreign_money not between", value1, value2, "foreignMoney");
            return (Criteria) this;
        }

        public Criteria andRmbMoneyIsNull() {
            addCriterion("rmb_money is null");
            return (Criteria) this;
        }

        public Criteria andRmbMoneyIsNotNull() {
            addCriterion("rmb_money is not null");
            return (Criteria) this;
        }

        public Criteria andRmbMoneyEqualTo(Double value) {
            addCriterion("rmb_money =", value, "rmbMoney");
            return (Criteria) this;
        }

        public Criteria andRmbMoneyNotEqualTo(Double value) {
            addCriterion("rmb_money <>", value, "rmbMoney");
            return (Criteria) this;
        }

        public Criteria andRmbMoneyGreaterThan(Double value) {
            addCriterion("rmb_money >", value, "rmbMoney");
            return (Criteria) this;
        }

        public Criteria andRmbMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("rmb_money >=", value, "rmbMoney");
            return (Criteria) this;
        }

        public Criteria andRmbMoneyLessThan(Double value) {
            addCriterion("rmb_money <", value, "rmbMoney");
            return (Criteria) this;
        }

        public Criteria andRmbMoneyLessThanOrEqualTo(Double value) {
            addCriterion("rmb_money <=", value, "rmbMoney");
            return (Criteria) this;
        }

        public Criteria andRmbMoneyIn(List<Double> values) {
            addCriterion("rmb_money in", values, "rmbMoney");
            return (Criteria) this;
        }

        public Criteria andRmbMoneyNotIn(List<Double> values) {
            addCriterion("rmb_money not in", values, "rmbMoney");
            return (Criteria) this;
        }

        public Criteria andRmbMoneyBetween(Double value1, Double value2) {
            addCriterion("rmb_money between", value1, value2, "rmbMoney");
            return (Criteria) this;
        }

        public Criteria andRmbMoneyNotBetween(Double value1, Double value2) {
            addCriterion("rmb_money not between", value1, value2, "rmbMoney");
            return (Criteria) this;
        }

        public Criteria andAgreementStartDateIsNull() {
            addCriterion("agreement_start_date is null");
            return (Criteria) this;
        }

        public Criteria andAgreementStartDateIsNotNull() {
            addCriterion("agreement_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andAgreementStartDateEqualTo(String value) {
            addCriterion("agreement_start_date =", value, "agreementStartDate");
            return (Criteria) this;
        }

        public Criteria andAgreementStartDateNotEqualTo(String value) {
            addCriterion("agreement_start_date <>", value, "agreementStartDate");
            return (Criteria) this;
        }

        public Criteria andAgreementStartDateGreaterThan(String value) {
            addCriterion("agreement_start_date >", value, "agreementStartDate");
            return (Criteria) this;
        }

        public Criteria andAgreementStartDateGreaterThanOrEqualTo(String value) {
            addCriterion("agreement_start_date >=", value, "agreementStartDate");
            return (Criteria) this;
        }

        public Criteria andAgreementStartDateLessThan(String value) {
            addCriterion("agreement_start_date <", value, "agreementStartDate");
            return (Criteria) this;
        }

        public Criteria andAgreementStartDateLessThanOrEqualTo(String value) {
            addCriterion("agreement_start_date <=", value, "agreementStartDate");
            return (Criteria) this;
        }

        public Criteria andAgreementStartDateLike(String value) {
            addCriterion("agreement_start_date like", value, "agreementStartDate");
            return (Criteria) this;
        }

        public Criteria andAgreementStartDateNotLike(String value) {
            addCriterion("agreement_start_date not like", value, "agreementStartDate");
            return (Criteria) this;
        }

        public Criteria andAgreementStartDateIn(List<String> values) {
            addCriterion("agreement_start_date in", values, "agreementStartDate");
            return (Criteria) this;
        }

        public Criteria andAgreementStartDateNotIn(List<String> values) {
            addCriterion("agreement_start_date not in", values, "agreementStartDate");
            return (Criteria) this;
        }

        public Criteria andAgreementStartDateBetween(String value1, String value2) {
            addCriterion("agreement_start_date between", value1, value2, "agreementStartDate");
            return (Criteria) this;
        }

        public Criteria andAgreementStartDateNotBetween(String value1, String value2) {
            addCriterion("agreement_start_date not between", value1, value2, "agreementStartDate");
            return (Criteria) this;
        }

        public Criteria andAgreementEndDateIsNull() {
            addCriterion("agreement_end_date is null");
            return (Criteria) this;
        }

        public Criteria andAgreementEndDateIsNotNull() {
            addCriterion("agreement_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andAgreementEndDateEqualTo(String value) {
            addCriterion("agreement_end_date =", value, "agreementEndDate");
            return (Criteria) this;
        }

        public Criteria andAgreementEndDateNotEqualTo(String value) {
            addCriterion("agreement_end_date <>", value, "agreementEndDate");
            return (Criteria) this;
        }

        public Criteria andAgreementEndDateGreaterThan(String value) {
            addCriterion("agreement_end_date >", value, "agreementEndDate");
            return (Criteria) this;
        }

        public Criteria andAgreementEndDateGreaterThanOrEqualTo(String value) {
            addCriterion("agreement_end_date >=", value, "agreementEndDate");
            return (Criteria) this;
        }

        public Criteria andAgreementEndDateLessThan(String value) {
            addCriterion("agreement_end_date <", value, "agreementEndDate");
            return (Criteria) this;
        }

        public Criteria andAgreementEndDateLessThanOrEqualTo(String value) {
            addCriterion("agreement_end_date <=", value, "agreementEndDate");
            return (Criteria) this;
        }

        public Criteria andAgreementEndDateLike(String value) {
            addCriterion("agreement_end_date like", value, "agreementEndDate");
            return (Criteria) this;
        }

        public Criteria andAgreementEndDateNotLike(String value) {
            addCriterion("agreement_end_date not like", value, "agreementEndDate");
            return (Criteria) this;
        }

        public Criteria andAgreementEndDateIn(List<String> values) {
            addCriterion("agreement_end_date in", values, "agreementEndDate");
            return (Criteria) this;
        }

        public Criteria andAgreementEndDateNotIn(List<String> values) {
            addCriterion("agreement_end_date not in", values, "agreementEndDate");
            return (Criteria) this;
        }

        public Criteria andAgreementEndDateBetween(String value1, String value2) {
            addCriterion("agreement_end_date between", value1, value2, "agreementEndDate");
            return (Criteria) this;
        }

        public Criteria andAgreementEndDateNotBetween(String value1, String value2) {
            addCriterion("agreement_end_date not between", value1, value2, "agreementEndDate");
            return (Criteria) this;
        }

        public Criteria andSecrecyStartDateIsNull() {
            addCriterion("secrecy_start_date is null");
            return (Criteria) this;
        }

        public Criteria andSecrecyStartDateIsNotNull() {
            addCriterion("secrecy_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andSecrecyStartDateEqualTo(String value) {
            addCriterion("secrecy_start_date =", value, "secrecyStartDate");
            return (Criteria) this;
        }

        public Criteria andSecrecyStartDateNotEqualTo(String value) {
            addCriterion("secrecy_start_date <>", value, "secrecyStartDate");
            return (Criteria) this;
        }

        public Criteria andSecrecyStartDateGreaterThan(String value) {
            addCriterion("secrecy_start_date >", value, "secrecyStartDate");
            return (Criteria) this;
        }

        public Criteria andSecrecyStartDateGreaterThanOrEqualTo(String value) {
            addCriterion("secrecy_start_date >=", value, "secrecyStartDate");
            return (Criteria) this;
        }

        public Criteria andSecrecyStartDateLessThan(String value) {
            addCriterion("secrecy_start_date <", value, "secrecyStartDate");
            return (Criteria) this;
        }

        public Criteria andSecrecyStartDateLessThanOrEqualTo(String value) {
            addCriterion("secrecy_start_date <=", value, "secrecyStartDate");
            return (Criteria) this;
        }

        public Criteria andSecrecyStartDateLike(String value) {
            addCriterion("secrecy_start_date like", value, "secrecyStartDate");
            return (Criteria) this;
        }

        public Criteria andSecrecyStartDateNotLike(String value) {
            addCriterion("secrecy_start_date not like", value, "secrecyStartDate");
            return (Criteria) this;
        }

        public Criteria andSecrecyStartDateIn(List<String> values) {
            addCriterion("secrecy_start_date in", values, "secrecyStartDate");
            return (Criteria) this;
        }

        public Criteria andSecrecyStartDateNotIn(List<String> values) {
            addCriterion("secrecy_start_date not in", values, "secrecyStartDate");
            return (Criteria) this;
        }

        public Criteria andSecrecyStartDateBetween(String value1, String value2) {
            addCriterion("secrecy_start_date between", value1, value2, "secrecyStartDate");
            return (Criteria) this;
        }

        public Criteria andSecrecyStartDateNotBetween(String value1, String value2) {
            addCriterion("secrecy_start_date not between", value1, value2, "secrecyStartDate");
            return (Criteria) this;
        }

        public Criteria andSecrecyEndDateIsNull() {
            addCriterion("secrecy_end_date is null");
            return (Criteria) this;
        }

        public Criteria andSecrecyEndDateIsNotNull() {
            addCriterion("secrecy_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andSecrecyEndDateEqualTo(String value) {
            addCriterion("secrecy_end_date =", value, "secrecyEndDate");
            return (Criteria) this;
        }

        public Criteria andSecrecyEndDateNotEqualTo(String value) {
            addCriterion("secrecy_end_date <>", value, "secrecyEndDate");
            return (Criteria) this;
        }

        public Criteria andSecrecyEndDateGreaterThan(String value) {
            addCriterion("secrecy_end_date >", value, "secrecyEndDate");
            return (Criteria) this;
        }

        public Criteria andSecrecyEndDateGreaterThanOrEqualTo(String value) {
            addCriterion("secrecy_end_date >=", value, "secrecyEndDate");
            return (Criteria) this;
        }

        public Criteria andSecrecyEndDateLessThan(String value) {
            addCriterion("secrecy_end_date <", value, "secrecyEndDate");
            return (Criteria) this;
        }

        public Criteria andSecrecyEndDateLessThanOrEqualTo(String value) {
            addCriterion("secrecy_end_date <=", value, "secrecyEndDate");
            return (Criteria) this;
        }

        public Criteria andSecrecyEndDateLike(String value) {
            addCriterion("secrecy_end_date like", value, "secrecyEndDate");
            return (Criteria) this;
        }

        public Criteria andSecrecyEndDateNotLike(String value) {
            addCriterion("secrecy_end_date not like", value, "secrecyEndDate");
            return (Criteria) this;
        }

        public Criteria andSecrecyEndDateIn(List<String> values) {
            addCriterion("secrecy_end_date in", values, "secrecyEndDate");
            return (Criteria) this;
        }

        public Criteria andSecrecyEndDateNotIn(List<String> values) {
            addCriterion("secrecy_end_date not in", values, "secrecyEndDate");
            return (Criteria) this;
        }

        public Criteria andSecrecyEndDateBetween(String value1, String value2) {
            addCriterion("secrecy_end_date between", value1, value2, "secrecyEndDate");
            return (Criteria) this;
        }

        public Criteria andSecrecyEndDateNotBetween(String value1, String value2) {
            addCriterion("secrecy_end_date not between", value1, value2, "secrecyEndDate");
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