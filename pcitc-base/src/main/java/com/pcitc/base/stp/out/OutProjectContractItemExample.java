package com.pcitc.base.stp.out;

import java.util.ArrayList;
import java.util.List;

public class OutProjectContractItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public OutProjectContractItemExample() {
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

        public Criteria andItemFileIsNull() {
            addCriterion("item_file is null");
            return (Criteria) this;
        }

        public Criteria andItemFileIsNotNull() {
            addCriterion("item_file is not null");
            return (Criteria) this;
        }

        public Criteria andItemFileEqualTo(String value) {
            addCriterion("item_file =", value, "itemFile");
            return (Criteria) this;
        }

        public Criteria andItemFileNotEqualTo(String value) {
            addCriterion("item_file <>", value, "itemFile");
            return (Criteria) this;
        }

        public Criteria andItemFileGreaterThan(String value) {
            addCriterion("item_file >", value, "itemFile");
            return (Criteria) this;
        }

        public Criteria andItemFileGreaterThanOrEqualTo(String value) {
            addCriterion("item_file >=", value, "itemFile");
            return (Criteria) this;
        }

        public Criteria andItemFileLessThan(String value) {
            addCriterion("item_file <", value, "itemFile");
            return (Criteria) this;
        }

        public Criteria andItemFileLessThanOrEqualTo(String value) {
            addCriterion("item_file <=", value, "itemFile");
            return (Criteria) this;
        }

        public Criteria andItemFileLike(String value) {
            addCriterion("item_file like", value, "itemFile");
            return (Criteria) this;
        }

        public Criteria andItemFileNotLike(String value) {
            addCriterion("item_file not like", value, "itemFile");
            return (Criteria) this;
        }

        public Criteria andItemFileIn(List<String> values) {
            addCriterion("item_file in", values, "itemFile");
            return (Criteria) this;
        }

        public Criteria andItemFileNotIn(List<String> values) {
            addCriterion("item_file not in", values, "itemFile");
            return (Criteria) this;
        }

        public Criteria andItemFileBetween(String value1, String value2) {
            addCriterion("item_file between", value1, value2, "itemFile");
            return (Criteria) this;
        }

        public Criteria andItemFileNotBetween(String value1, String value2) {
            addCriterion("item_file not between", value1, value2, "itemFile");
            return (Criteria) this;
        }

        public Criteria andItemUrlIsNull() {
            addCriterion("item_url is null");
            return (Criteria) this;
        }

        public Criteria andItemUrlIsNotNull() {
            addCriterion("item_url is not null");
            return (Criteria) this;
        }

        public Criteria andItemUrlEqualTo(String value) {
            addCriterion("item_url =", value, "itemUrl");
            return (Criteria) this;
        }

        public Criteria andItemUrlNotEqualTo(String value) {
            addCriterion("item_url <>", value, "itemUrl");
            return (Criteria) this;
        }

        public Criteria andItemUrlGreaterThan(String value) {
            addCriterion("item_url >", value, "itemUrl");
            return (Criteria) this;
        }

        public Criteria andItemUrlGreaterThanOrEqualTo(String value) {
            addCriterion("item_url >=", value, "itemUrl");
            return (Criteria) this;
        }

        public Criteria andItemUrlLessThan(String value) {
            addCriterion("item_url <", value, "itemUrl");
            return (Criteria) this;
        }

        public Criteria andItemUrlLessThanOrEqualTo(String value) {
            addCriterion("item_url <=", value, "itemUrl");
            return (Criteria) this;
        }

        public Criteria andItemUrlLike(String value) {
            addCriterion("item_url like", value, "itemUrl");
            return (Criteria) this;
        }

        public Criteria andItemUrlNotLike(String value) {
            addCriterion("item_url not like", value, "itemUrl");
            return (Criteria) this;
        }

        public Criteria andItemUrlIn(List<String> values) {
            addCriterion("item_url in", values, "itemUrl");
            return (Criteria) this;
        }

        public Criteria andItemUrlNotIn(List<String> values) {
            addCriterion("item_url not in", values, "itemUrl");
            return (Criteria) this;
        }

        public Criteria andItemUrlBetween(String value1, String value2) {
            addCriterion("item_url between", value1, value2, "itemUrl");
            return (Criteria) this;
        }

        public Criteria andItemUrlNotBetween(String value1, String value2) {
            addCriterion("item_url not between", value1, value2, "itemUrl");
            return (Criteria) this;
        }

        public Criteria andItemUnitCodeIsNull() {
            addCriterion("item_unit_code is null");
            return (Criteria) this;
        }

        public Criteria andItemUnitCodeIsNotNull() {
            addCriterion("item_unit_code is not null");
            return (Criteria) this;
        }

        public Criteria andItemUnitCodeEqualTo(String value) {
            addCriterion("item_unit_code =", value, "itemUnitCode");
            return (Criteria) this;
        }

        public Criteria andItemUnitCodeNotEqualTo(String value) {
            addCriterion("item_unit_code <>", value, "itemUnitCode");
            return (Criteria) this;
        }

        public Criteria andItemUnitCodeGreaterThan(String value) {
            addCriterion("item_unit_code >", value, "itemUnitCode");
            return (Criteria) this;
        }

        public Criteria andItemUnitCodeGreaterThanOrEqualTo(String value) {
            addCriterion("item_unit_code >=", value, "itemUnitCode");
            return (Criteria) this;
        }

        public Criteria andItemUnitCodeLessThan(String value) {
            addCriterion("item_unit_code <", value, "itemUnitCode");
            return (Criteria) this;
        }

        public Criteria andItemUnitCodeLessThanOrEqualTo(String value) {
            addCriterion("item_unit_code <=", value, "itemUnitCode");
            return (Criteria) this;
        }

        public Criteria andItemUnitCodeLike(String value) {
            addCriterion("item_unit_code like", value, "itemUnitCode");
            return (Criteria) this;
        }

        public Criteria andItemUnitCodeNotLike(String value) {
            addCriterion("item_unit_code not like", value, "itemUnitCode");
            return (Criteria) this;
        }

        public Criteria andItemUnitCodeIn(List<String> values) {
            addCriterion("item_unit_code in", values, "itemUnitCode");
            return (Criteria) this;
        }

        public Criteria andItemUnitCodeNotIn(List<String> values) {
            addCriterion("item_unit_code not in", values, "itemUnitCode");
            return (Criteria) this;
        }

        public Criteria andItemUnitCodeBetween(String value1, String value2) {
            addCriterion("item_unit_code between", value1, value2, "itemUnitCode");
            return (Criteria) this;
        }

        public Criteria andItemUnitCodeNotBetween(String value1, String value2) {
            addCriterion("item_unit_code not between", value1, value2, "itemUnitCode");
            return (Criteria) this;
        }

        public Criteria andItemUnitIsNull() {
            addCriterion("item_unit is null");
            return (Criteria) this;
        }

        public Criteria andItemUnitIsNotNull() {
            addCriterion("item_unit is not null");
            return (Criteria) this;
        }

        public Criteria andItemUnitEqualTo(String value) {
            addCriterion("item_unit =", value, "itemUnit");
            return (Criteria) this;
        }

        public Criteria andItemUnitNotEqualTo(String value) {
            addCriterion("item_unit <>", value, "itemUnit");
            return (Criteria) this;
        }

        public Criteria andItemUnitGreaterThan(String value) {
            addCriterion("item_unit >", value, "itemUnit");
            return (Criteria) this;
        }

        public Criteria andItemUnitGreaterThanOrEqualTo(String value) {
            addCriterion("item_unit >=", value, "itemUnit");
            return (Criteria) this;
        }

        public Criteria andItemUnitLessThan(String value) {
            addCriterion("item_unit <", value, "itemUnit");
            return (Criteria) this;
        }

        public Criteria andItemUnitLessThanOrEqualTo(String value) {
            addCriterion("item_unit <=", value, "itemUnit");
            return (Criteria) this;
        }

        public Criteria andItemUnitLike(String value) {
            addCriterion("item_unit like", value, "itemUnit");
            return (Criteria) this;
        }

        public Criteria andItemUnitNotLike(String value) {
            addCriterion("item_unit not like", value, "itemUnit");
            return (Criteria) this;
        }

        public Criteria andItemUnitIn(List<String> values) {
            addCriterion("item_unit in", values, "itemUnit");
            return (Criteria) this;
        }

        public Criteria andItemUnitNotIn(List<String> values) {
            addCriterion("item_unit not in", values, "itemUnit");
            return (Criteria) this;
        }

        public Criteria andItemUnitBetween(String value1, String value2) {
            addCriterion("item_unit between", value1, value2, "itemUnit");
            return (Criteria) this;
        }

        public Criteria andItemUnitNotBetween(String value1, String value2) {
            addCriterion("item_unit not between", value1, value2, "itemUnit");
            return (Criteria) this;
        }

        public Criteria andItemRequireIsNull() {
            addCriterion("item_require is null");
            return (Criteria) this;
        }

        public Criteria andItemRequireIsNotNull() {
            addCriterion("item_require is not null");
            return (Criteria) this;
        }

        public Criteria andItemRequireEqualTo(String value) {
            addCriterion("item_require =", value, "itemRequire");
            return (Criteria) this;
        }

        public Criteria andItemRequireNotEqualTo(String value) {
            addCriterion("item_require <>", value, "itemRequire");
            return (Criteria) this;
        }

        public Criteria andItemRequireGreaterThan(String value) {
            addCriterion("item_require >", value, "itemRequire");
            return (Criteria) this;
        }

        public Criteria andItemRequireGreaterThanOrEqualTo(String value) {
            addCriterion("item_require >=", value, "itemRequire");
            return (Criteria) this;
        }

        public Criteria andItemRequireLessThan(String value) {
            addCriterion("item_require <", value, "itemRequire");
            return (Criteria) this;
        }

        public Criteria andItemRequireLessThanOrEqualTo(String value) {
            addCriterion("item_require <=", value, "itemRequire");
            return (Criteria) this;
        }

        public Criteria andItemRequireLike(String value) {
            addCriterion("item_require like", value, "itemRequire");
            return (Criteria) this;
        }

        public Criteria andItemRequireNotLike(String value) {
            addCriterion("item_require not like", value, "itemRequire");
            return (Criteria) this;
        }

        public Criteria andItemRequireIn(List<String> values) {
            addCriterion("item_require in", values, "itemRequire");
            return (Criteria) this;
        }

        public Criteria andItemRequireNotIn(List<String> values) {
            addCriterion("item_require not in", values, "itemRequire");
            return (Criteria) this;
        }

        public Criteria andItemRequireBetween(String value1, String value2) {
            addCriterion("item_require between", value1, value2, "itemRequire");
            return (Criteria) this;
        }

        public Criteria andItemRequireNotBetween(String value1, String value2) {
            addCriterion("item_require not between", value1, value2, "itemRequire");
            return (Criteria) this;
        }

        public Criteria andItemCountIsNull() {
            addCriterion("item_count is null");
            return (Criteria) this;
        }

        public Criteria andItemCountIsNotNull() {
            addCriterion("item_count is not null");
            return (Criteria) this;
        }

        public Criteria andItemCountEqualTo(String value) {
            addCriterion("item_count =", value, "itemCount");
            return (Criteria) this;
        }

        public Criteria andItemCountNotEqualTo(String value) {
            addCriterion("item_count <>", value, "itemCount");
            return (Criteria) this;
        }

        public Criteria andItemCountGreaterThan(String value) {
            addCriterion("item_count >", value, "itemCount");
            return (Criteria) this;
        }

        public Criteria andItemCountGreaterThanOrEqualTo(String value) {
            addCriterion("item_count >=", value, "itemCount");
            return (Criteria) this;
        }

        public Criteria andItemCountLessThan(String value) {
            addCriterion("item_count <", value, "itemCount");
            return (Criteria) this;
        }

        public Criteria andItemCountLessThanOrEqualTo(String value) {
            addCriterion("item_count <=", value, "itemCount");
            return (Criteria) this;
        }

        public Criteria andItemCountLike(String value) {
            addCriterion("item_count like", value, "itemCount");
            return (Criteria) this;
        }

        public Criteria andItemCountNotLike(String value) {
            addCriterion("item_count not like", value, "itemCount");
            return (Criteria) this;
        }

        public Criteria andItemCountIn(List<String> values) {
            addCriterion("item_count in", values, "itemCount");
            return (Criteria) this;
        }

        public Criteria andItemCountNotIn(List<String> values) {
            addCriterion("item_count not in", values, "itemCount");
            return (Criteria) this;
        }

        public Criteria andItemCountBetween(String value1, String value2) {
            addCriterion("item_count between", value1, value2, "itemCount");
            return (Criteria) this;
        }

        public Criteria andItemCountNotBetween(String value1, String value2) {
            addCriterion("item_count not between", value1, value2, "itemCount");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNull() {
            addCriterion("item_name is null");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNotNull() {
            addCriterion("item_name is not null");
            return (Criteria) this;
        }

        public Criteria andItemNameEqualTo(String value) {
            addCriterion("item_name =", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotEqualTo(String value) {
            addCriterion("item_name <>", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThan(String value) {
            addCriterion("item_name >", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("item_name >=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThan(String value) {
            addCriterion("item_name <", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThanOrEqualTo(String value) {
            addCriterion("item_name <=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLike(String value) {
            addCriterion("item_name like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotLike(String value) {
            addCriterion("item_name not like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameIn(List<String> values) {
            addCriterion("item_name in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotIn(List<String> values) {
            addCriterion("item_name not in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameBetween(String value1, String value2) {
            addCriterion("item_name between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotBetween(String value1, String value2) {
            addCriterion("item_name not between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemCodeIsNull() {
            addCriterion("item_code is null");
            return (Criteria) this;
        }

        public Criteria andItemCodeIsNotNull() {
            addCriterion("item_code is not null");
            return (Criteria) this;
        }

        public Criteria andItemCodeEqualTo(String value) {
            addCriterion("item_code =", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotEqualTo(String value) {
            addCriterion("item_code <>", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeGreaterThan(String value) {
            addCriterion("item_code >", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeGreaterThanOrEqualTo(String value) {
            addCriterion("item_code >=", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeLessThan(String value) {
            addCriterion("item_code <", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeLessThanOrEqualTo(String value) {
            addCriterion("item_code <=", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeLike(String value) {
            addCriterion("item_code like", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotLike(String value) {
            addCriterion("item_code not like", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeIn(List<String> values) {
            addCriterion("item_code in", values, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotIn(List<String> values) {
            addCriterion("item_code not in", values, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeBetween(String value1, String value2) {
            addCriterion("item_code between", value1, value2, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotBetween(String value1, String value2) {
            addCriterion("item_code not between", value1, value2, "itemCode");
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