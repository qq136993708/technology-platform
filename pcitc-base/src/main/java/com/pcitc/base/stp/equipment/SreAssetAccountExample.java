package com.pcitc.base.stp.equipment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SreAssetAccountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SreAssetAccountExample() {
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

        public Criteria andAccountIdIsNull() {
            addCriterion("account_id is null");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNotNull() {
            addCriterion("account_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIdEqualTo(String value) {
            addCriterion("account_id =", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotEqualTo(String value) {
            addCriterion("account_id <>", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThan(String value) {
            addCriterion("account_id >", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(String value) {
            addCriterion("account_id >=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThan(String value) {
            addCriterion("account_id <", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThanOrEqualTo(String value) {
            addCriterion("account_id <=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLike(String value) {
            addCriterion("account_id like", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotLike(String value) {
            addCriterion("account_id not like", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIn(List<String> values) {
            addCriterion("account_id in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotIn(List<String> values) {
            addCriterion("account_id not in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdBetween(String value1, String value2) {
            addCriterion("account_id between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotBetween(String value1, String value2) {
            addCriterion("account_id not between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAssetTypeIsNull() {
            addCriterion("asset_type is null");
            return (Criteria) this;
        }

        public Criteria andAssetTypeIsNotNull() {
            addCriterion("asset_type is not null");
            return (Criteria) this;
        }

        public Criteria andAssetTypeEqualTo(String value) {
            addCriterion("asset_type =", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeNotEqualTo(String value) {
            addCriterion("asset_type <>", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeGreaterThan(String value) {
            addCriterion("asset_type >", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeGreaterThanOrEqualTo(String value) {
            addCriterion("asset_type >=", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeLessThan(String value) {
            addCriterion("asset_type <", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeLessThanOrEqualTo(String value) {
            addCriterion("asset_type <=", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeLike(String value) {
            addCriterion("asset_type like", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeNotLike(String value) {
            addCriterion("asset_type not like", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeIn(List<String> values) {
            addCriterion("asset_type in", values, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeNotIn(List<String> values) {
            addCriterion("asset_type not in", values, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeBetween(String value1, String value2) {
            addCriterion("asset_type between", value1, value2, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeNotBetween(String value1, String value2) {
            addCriterion("asset_type not between", value1, value2, "assetType");
            return (Criteria) this;
        }

        public Criteria andProducNameIsNull() {
            addCriterion("produc_name is null");
            return (Criteria) this;
        }

        public Criteria andProducNameIsNotNull() {
            addCriterion("produc_name is not null");
            return (Criteria) this;
        }

        public Criteria andProducNameEqualTo(String value) {
            addCriterion("produc_name =", value, "producName");
            return (Criteria) this;
        }

        public Criteria andProducNameNotEqualTo(String value) {
            addCriterion("produc_name <>", value, "producName");
            return (Criteria) this;
        }

        public Criteria andProducNameGreaterThan(String value) {
            addCriterion("produc_name >", value, "producName");
            return (Criteria) this;
        }

        public Criteria andProducNameGreaterThanOrEqualTo(String value) {
            addCriterion("produc_name >=", value, "producName");
            return (Criteria) this;
        }

        public Criteria andProducNameLessThan(String value) {
            addCriterion("produc_name <", value, "producName");
            return (Criteria) this;
        }

        public Criteria andProducNameLessThanOrEqualTo(String value) {
            addCriterion("produc_name <=", value, "producName");
            return (Criteria) this;
        }

        public Criteria andProducNameLike(String value) {
            addCriterion("produc_name like", value, "producName");
            return (Criteria) this;
        }

        public Criteria andProducNameNotLike(String value) {
            addCriterion("produc_name not like", value, "producName");
            return (Criteria) this;
        }

        public Criteria andProducNameIn(List<String> values) {
            addCriterion("produc_name in", values, "producName");
            return (Criteria) this;
        }

        public Criteria andProducNameNotIn(List<String> values) {
            addCriterion("produc_name not in", values, "producName");
            return (Criteria) this;
        }

        public Criteria andProducNameBetween(String value1, String value2) {
            addCriterion("produc_name between", value1, value2, "producName");
            return (Criteria) this;
        }

        public Criteria andProducNameNotBetween(String value1, String value2) {
            addCriterion("produc_name not between", value1, value2, "producName");
            return (Criteria) this;
        }

        public Criteria andEqModelIsNull() {
            addCriterion("eq_model is null");
            return (Criteria) this;
        }

        public Criteria andEqModelIsNotNull() {
            addCriterion("eq_model is not null");
            return (Criteria) this;
        }

        public Criteria andEqModelEqualTo(String value) {
            addCriterion("eq_model =", value, "eqModel");
            return (Criteria) this;
        }

        public Criteria andEqModelNotEqualTo(String value) {
            addCriterion("eq_model <>", value, "eqModel");
            return (Criteria) this;
        }

        public Criteria andEqModelGreaterThan(String value) {
            addCriterion("eq_model >", value, "eqModel");
            return (Criteria) this;
        }

        public Criteria andEqModelGreaterThanOrEqualTo(String value) {
            addCriterion("eq_model >=", value, "eqModel");
            return (Criteria) this;
        }

        public Criteria andEqModelLessThan(String value) {
            addCriterion("eq_model <", value, "eqModel");
            return (Criteria) this;
        }

        public Criteria andEqModelLessThanOrEqualTo(String value) {
            addCriterion("eq_model <=", value, "eqModel");
            return (Criteria) this;
        }

        public Criteria andEqModelLike(String value) {
            addCriterion("eq_model like", value, "eqModel");
            return (Criteria) this;
        }

        public Criteria andEqModelNotLike(String value) {
            addCriterion("eq_model not like", value, "eqModel");
            return (Criteria) this;
        }

        public Criteria andEqModelIn(List<String> values) {
            addCriterion("eq_model in", values, "eqModel");
            return (Criteria) this;
        }

        public Criteria andEqModelNotIn(List<String> values) {
            addCriterion("eq_model not in", values, "eqModel");
            return (Criteria) this;
        }

        public Criteria andEqModelBetween(String value1, String value2) {
            addCriterion("eq_model between", value1, value2, "eqModel");
            return (Criteria) this;
        }

        public Criteria andEqModelNotBetween(String value1, String value2) {
            addCriterion("eq_model not between", value1, value2, "eqModel");
            return (Criteria) this;
        }

        public Criteria andEqConfigIsNull() {
            addCriterion("eq_config is null");
            return (Criteria) this;
        }

        public Criteria andEqConfigIsNotNull() {
            addCriterion("eq_config is not null");
            return (Criteria) this;
        }

        public Criteria andEqConfigEqualTo(String value) {
            addCriterion("eq_config =", value, "eqConfig");
            return (Criteria) this;
        }

        public Criteria andEqConfigNotEqualTo(String value) {
            addCriterion("eq_config <>", value, "eqConfig");
            return (Criteria) this;
        }

        public Criteria andEqConfigGreaterThan(String value) {
            addCriterion("eq_config >", value, "eqConfig");
            return (Criteria) this;
        }

        public Criteria andEqConfigGreaterThanOrEqualTo(String value) {
            addCriterion("eq_config >=", value, "eqConfig");
            return (Criteria) this;
        }

        public Criteria andEqConfigLessThan(String value) {
            addCriterion("eq_config <", value, "eqConfig");
            return (Criteria) this;
        }

        public Criteria andEqConfigLessThanOrEqualTo(String value) {
            addCriterion("eq_config <=", value, "eqConfig");
            return (Criteria) this;
        }

        public Criteria andEqConfigLike(String value) {
            addCriterion("eq_config like", value, "eqConfig");
            return (Criteria) this;
        }

        public Criteria andEqConfigNotLike(String value) {
            addCriterion("eq_config not like", value, "eqConfig");
            return (Criteria) this;
        }

        public Criteria andEqConfigIn(List<String> values) {
            addCriterion("eq_config in", values, "eqConfig");
            return (Criteria) this;
        }

        public Criteria andEqConfigNotIn(List<String> values) {
            addCriterion("eq_config not in", values, "eqConfig");
            return (Criteria) this;
        }

        public Criteria andEqConfigBetween(String value1, String value2) {
            addCriterion("eq_config between", value1, value2, "eqConfig");
            return (Criteria) this;
        }

        public Criteria andEqConfigNotBetween(String value1, String value2) {
            addCriterion("eq_config not between", value1, value2, "eqConfig");
            return (Criteria) this;
        }

        public Criteria andEqSnIsNull() {
            addCriterion("eq_sN is null");
            return (Criteria) this;
        }

        public Criteria andEqSnIsNotNull() {
            addCriterion("eq_sN is not null");
            return (Criteria) this;
        }

        public Criteria andEqSnEqualTo(String value) {
            addCriterion("eq_sN =", value, "eqSn");
            return (Criteria) this;
        }

        public Criteria andEqSnNotEqualTo(String value) {
            addCriterion("eq_sN <>", value, "eqSn");
            return (Criteria) this;
        }

        public Criteria andEqSnGreaterThan(String value) {
            addCriterion("eq_sN >", value, "eqSn");
            return (Criteria) this;
        }

        public Criteria andEqSnGreaterThanOrEqualTo(String value) {
            addCriterion("eq_sN >=", value, "eqSn");
            return (Criteria) this;
        }

        public Criteria andEqSnLessThan(String value) {
            addCriterion("eq_sN <", value, "eqSn");
            return (Criteria) this;
        }

        public Criteria andEqSnLessThanOrEqualTo(String value) {
            addCriterion("eq_sN <=", value, "eqSn");
            return (Criteria) this;
        }

        public Criteria andEqSnLike(String value) {
            addCriterion("eq_sN like", value, "eqSn");
            return (Criteria) this;
        }

        public Criteria andEqSnNotLike(String value) {
            addCriterion("eq_sN not like", value, "eqSn");
            return (Criteria) this;
        }

        public Criteria andEqSnIn(List<String> values) {
            addCriterion("eq_sN in", values, "eqSn");
            return (Criteria) this;
        }

        public Criteria andEqSnNotIn(List<String> values) {
            addCriterion("eq_sN not in", values, "eqSn");
            return (Criteria) this;
        }

        public Criteria andEqSnBetween(String value1, String value2) {
            addCriterion("eq_sN between", value1, value2, "eqSn");
            return (Criteria) this;
        }

        public Criteria andEqSnNotBetween(String value1, String value2) {
            addCriterion("eq_sN not between", value1, value2, "eqSn");
            return (Criteria) this;
        }

        public Criteria andEqCountryIsNull() {
            addCriterion("eq_country is null");
            return (Criteria) this;
        }

        public Criteria andEqCountryIsNotNull() {
            addCriterion("eq_country is not null");
            return (Criteria) this;
        }

        public Criteria andEqCountryEqualTo(String value) {
            addCriterion("eq_country =", value, "eqCountry");
            return (Criteria) this;
        }

        public Criteria andEqCountryNotEqualTo(String value) {
            addCriterion("eq_country <>", value, "eqCountry");
            return (Criteria) this;
        }

        public Criteria andEqCountryGreaterThan(String value) {
            addCriterion("eq_country >", value, "eqCountry");
            return (Criteria) this;
        }

        public Criteria andEqCountryGreaterThanOrEqualTo(String value) {
            addCriterion("eq_country >=", value, "eqCountry");
            return (Criteria) this;
        }

        public Criteria andEqCountryLessThan(String value) {
            addCriterion("eq_country <", value, "eqCountry");
            return (Criteria) this;
        }

        public Criteria andEqCountryLessThanOrEqualTo(String value) {
            addCriterion("eq_country <=", value, "eqCountry");
            return (Criteria) this;
        }

        public Criteria andEqCountryLike(String value) {
            addCriterion("eq_country like", value, "eqCountry");
            return (Criteria) this;
        }

        public Criteria andEqCountryNotLike(String value) {
            addCriterion("eq_country not like", value, "eqCountry");
            return (Criteria) this;
        }

        public Criteria andEqCountryIn(List<String> values) {
            addCriterion("eq_country in", values, "eqCountry");
            return (Criteria) this;
        }

        public Criteria andEqCountryNotIn(List<String> values) {
            addCriterion("eq_country not in", values, "eqCountry");
            return (Criteria) this;
        }

        public Criteria andEqCountryBetween(String value1, String value2) {
            addCriterion("eq_country between", value1, value2, "eqCountry");
            return (Criteria) this;
        }

        public Criteria andEqCountryNotBetween(String value1, String value2) {
            addCriterion("eq_country not between", value1, value2, "eqCountry");
            return (Criteria) this;
        }

        public Criteria andEqNumIsNull() {
            addCriterion("eq_num is null");
            return (Criteria) this;
        }

        public Criteria andEqNumIsNotNull() {
            addCriterion("eq_num is not null");
            return (Criteria) this;
        }

        public Criteria andEqNumEqualTo(Integer value) {
            addCriterion("eq_num =", value, "eqNum");
            return (Criteria) this;
        }

        public Criteria andEqNumNotEqualTo(Integer value) {
            addCriterion("eq_num <>", value, "eqNum");
            return (Criteria) this;
        }

        public Criteria andEqNumGreaterThan(Integer value) {
            addCriterion("eq_num >", value, "eqNum");
            return (Criteria) this;
        }

        public Criteria andEqNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("eq_num >=", value, "eqNum");
            return (Criteria) this;
        }

        public Criteria andEqNumLessThan(Integer value) {
            addCriterion("eq_num <", value, "eqNum");
            return (Criteria) this;
        }

        public Criteria andEqNumLessThanOrEqualTo(Integer value) {
            addCriterion("eq_num <=", value, "eqNum");
            return (Criteria) this;
        }

        public Criteria andEqNumIn(List<Integer> values) {
            addCriterion("eq_num in", values, "eqNum");
            return (Criteria) this;
        }

        public Criteria andEqNumNotIn(List<Integer> values) {
            addCriterion("eq_num not in", values, "eqNum");
            return (Criteria) this;
        }

        public Criteria andEqNumBetween(Integer value1, Integer value2) {
            addCriterion("eq_num between", value1, value2, "eqNum");
            return (Criteria) this;
        }

        public Criteria andEqNumNotBetween(Integer value1, Integer value2) {
            addCriterion("eq_num not between", value1, value2, "eqNum");
            return (Criteria) this;
        }

        public Criteria andEqModelPriceIsNull() {
            addCriterion("eq_model_price is null");
            return (Criteria) this;
        }

        public Criteria andEqModelPriceIsNotNull() {
            addCriterion("eq_model_price is not null");
            return (Criteria) this;
        }

        public Criteria andEqModelPriceEqualTo(BigDecimal value) {
            addCriterion("eq_model_price =", value, "eqModelPrice");
            return (Criteria) this;
        }

        public Criteria andEqModelPriceNotEqualTo(BigDecimal value) {
            addCriterion("eq_model_price <>", value, "eqModelPrice");
            return (Criteria) this;
        }

        public Criteria andEqModelPriceGreaterThan(BigDecimal value) {
            addCriterion("eq_model_price >", value, "eqModelPrice");
            return (Criteria) this;
        }

        public Criteria andEqModelPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("eq_model_price >=", value, "eqModelPrice");
            return (Criteria) this;
        }

        public Criteria andEqModelPriceLessThan(BigDecimal value) {
            addCriterion("eq_model_price <", value, "eqModelPrice");
            return (Criteria) this;
        }

        public Criteria andEqModelPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("eq_model_price <=", value, "eqModelPrice");
            return (Criteria) this;
        }

        public Criteria andEqModelPriceIn(List<BigDecimal> values) {
            addCriterion("eq_model_price in", values, "eqModelPrice");
            return (Criteria) this;
        }

        public Criteria andEqModelPriceNotIn(List<BigDecimal> values) {
            addCriterion("eq_model_price not in", values, "eqModelPrice");
            return (Criteria) this;
        }

        public Criteria andEqModelPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("eq_model_price between", value1, value2, "eqModelPrice");
            return (Criteria) this;
        }

        public Criteria andEqModelPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("eq_model_price not between", value1, value2, "eqModelPrice");
            return (Criteria) this;
        }

        public Criteria andEqNoIsNull() {
            addCriterion("eq_no is null");
            return (Criteria) this;
        }

        public Criteria andEqNoIsNotNull() {
            addCriterion("eq_no is not null");
            return (Criteria) this;
        }

        public Criteria andEqNoEqualTo(String value) {
            addCriterion("eq_no =", value, "eqNo");
            return (Criteria) this;
        }

        public Criteria andEqNoNotEqualTo(String value) {
            addCriterion("eq_no <>", value, "eqNo");
            return (Criteria) this;
        }

        public Criteria andEqNoGreaterThan(String value) {
            addCriterion("eq_no >", value, "eqNo");
            return (Criteria) this;
        }

        public Criteria andEqNoGreaterThanOrEqualTo(String value) {
            addCriterion("eq_no >=", value, "eqNo");
            return (Criteria) this;
        }

        public Criteria andEqNoLessThan(String value) {
            addCriterion("eq_no <", value, "eqNo");
            return (Criteria) this;
        }

        public Criteria andEqNoLessThanOrEqualTo(String value) {
            addCriterion("eq_no <=", value, "eqNo");
            return (Criteria) this;
        }

        public Criteria andEqNoLike(String value) {
            addCriterion("eq_no like", value, "eqNo");
            return (Criteria) this;
        }

        public Criteria andEqNoNotLike(String value) {
            addCriterion("eq_no not like", value, "eqNo");
            return (Criteria) this;
        }

        public Criteria andEqNoIn(List<String> values) {
            addCriterion("eq_no in", values, "eqNo");
            return (Criteria) this;
        }

        public Criteria andEqNoNotIn(List<String> values) {
            addCriterion("eq_no not in", values, "eqNo");
            return (Criteria) this;
        }

        public Criteria andEqNoBetween(String value1, String value2) {
            addCriterion("eq_no between", value1, value2, "eqNo");
            return (Criteria) this;
        }

        public Criteria andEqNoNotBetween(String value1, String value2) {
            addCriterion("eq_no not between", value1, value2, "eqNo");
            return (Criteria) this;
        }

        public Criteria andEqBuyDateIsNull() {
            addCriterion("eq_buy_date is null");
            return (Criteria) this;
        }

        public Criteria andEqBuyDateIsNotNull() {
            addCriterion("eq_buy_date is not null");
            return (Criteria) this;
        }

        public Criteria andEqBuyDateEqualTo(Date value) {
            addCriterion("eq_buy_date =", value, "eqBuyDate");
            return (Criteria) this;
        }

        public Criteria andEqBuyDateNotEqualTo(Date value) {
            addCriterion("eq_buy_date <>", value, "eqBuyDate");
            return (Criteria) this;
        }

        public Criteria andEqBuyDateGreaterThan(Date value) {
            addCriterion("eq_buy_date >", value, "eqBuyDate");
            return (Criteria) this;
        }

        public Criteria andEqBuyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("eq_buy_date >=", value, "eqBuyDate");
            return (Criteria) this;
        }

        public Criteria andEqBuyDateLessThan(Date value) {
            addCriterion("eq_buy_date <", value, "eqBuyDate");
            return (Criteria) this;
        }

        public Criteria andEqBuyDateLessThanOrEqualTo(Date value) {
            addCriterion("eq_buy_date <=", value, "eqBuyDate");
            return (Criteria) this;
        }

        public Criteria andEqBuyDateIn(List<Date> values) {
            addCriterion("eq_buy_date in", values, "eqBuyDate");
            return (Criteria) this;
        }

        public Criteria andEqBuyDateNotIn(List<Date> values) {
            addCriterion("eq_buy_date not in", values, "eqBuyDate");
            return (Criteria) this;
        }

        public Criteria andEqBuyDateBetween(Date value1, Date value2) {
            addCriterion("eq_buy_date between", value1, value2, "eqBuyDate");
            return (Criteria) this;
        }

        public Criteria andEqBuyDateNotBetween(Date value1, Date value2) {
            addCriterion("eq_buy_date not between", value1, value2, "eqBuyDate");
            return (Criteria) this;
        }

        public Criteria andEqWhereIsNull() {
            addCriterion("eq_where is null");
            return (Criteria) this;
        }

        public Criteria andEqWhereIsNotNull() {
            addCriterion("eq_where is not null");
            return (Criteria) this;
        }

        public Criteria andEqWhereEqualTo(String value) {
            addCriterion("eq_where =", value, "eqWhere");
            return (Criteria) this;
        }

        public Criteria andEqWhereNotEqualTo(String value) {
            addCriterion("eq_where <>", value, "eqWhere");
            return (Criteria) this;
        }

        public Criteria andEqWhereGreaterThan(String value) {
            addCriterion("eq_where >", value, "eqWhere");
            return (Criteria) this;
        }

        public Criteria andEqWhereGreaterThanOrEqualTo(String value) {
            addCriterion("eq_where >=", value, "eqWhere");
            return (Criteria) this;
        }

        public Criteria andEqWhereLessThan(String value) {
            addCriterion("eq_where <", value, "eqWhere");
            return (Criteria) this;
        }

        public Criteria andEqWhereLessThanOrEqualTo(String value) {
            addCriterion("eq_where <=", value, "eqWhere");
            return (Criteria) this;
        }

        public Criteria andEqWhereLike(String value) {
            addCriterion("eq_where like", value, "eqWhere");
            return (Criteria) this;
        }

        public Criteria andEqWhereNotLike(String value) {
            addCriterion("eq_where not like", value, "eqWhere");
            return (Criteria) this;
        }

        public Criteria andEqWhereIn(List<String> values) {
            addCriterion("eq_where in", values, "eqWhere");
            return (Criteria) this;
        }

        public Criteria andEqWhereNotIn(List<String> values) {
            addCriterion("eq_where not in", values, "eqWhere");
            return (Criteria) this;
        }

        public Criteria andEqWhereBetween(String value1, String value2) {
            addCriterion("eq_where between", value1, value2, "eqWhere");
            return (Criteria) this;
        }

        public Criteria andEqWhereNotBetween(String value1, String value2) {
            addCriterion("eq_where not between", value1, value2, "eqWhere");
            return (Criteria) this;
        }

        public Criteria andEqCompanyNameIsNull() {
            addCriterion("eq_company_name is null");
            return (Criteria) this;
        }

        public Criteria andEqCompanyNameIsNotNull() {
            addCriterion("eq_company_name is not null");
            return (Criteria) this;
        }

        public Criteria andEqCompanyNameEqualTo(String value) {
            addCriterion("eq_company_name =", value, "eqCompanyName");
            return (Criteria) this;
        }

        public Criteria andEqCompanyNameNotEqualTo(String value) {
            addCriterion("eq_company_name <>", value, "eqCompanyName");
            return (Criteria) this;
        }

        public Criteria andEqCompanyNameGreaterThan(String value) {
            addCriterion("eq_company_name >", value, "eqCompanyName");
            return (Criteria) this;
        }

        public Criteria andEqCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("eq_company_name >=", value, "eqCompanyName");
            return (Criteria) this;
        }

        public Criteria andEqCompanyNameLessThan(String value) {
            addCriterion("eq_company_name <", value, "eqCompanyName");
            return (Criteria) this;
        }

        public Criteria andEqCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("eq_company_name <=", value, "eqCompanyName");
            return (Criteria) this;
        }

        public Criteria andEqCompanyNameLike(String value) {
            addCriterion("eq_company_name like", value, "eqCompanyName");
            return (Criteria) this;
        }

        public Criteria andEqCompanyNameNotLike(String value) {
            addCriterion("eq_company_name not like", value, "eqCompanyName");
            return (Criteria) this;
        }

        public Criteria andEqCompanyNameIn(List<String> values) {
            addCriterion("eq_company_name in", values, "eqCompanyName");
            return (Criteria) this;
        }

        public Criteria andEqCompanyNameNotIn(List<String> values) {
            addCriterion("eq_company_name not in", values, "eqCompanyName");
            return (Criteria) this;
        }

        public Criteria andEqCompanyNameBetween(String value1, String value2) {
            addCriterion("eq_company_name between", value1, value2, "eqCompanyName");
            return (Criteria) this;
        }

        public Criteria andEqCompanyNameNotBetween(String value1, String value2) {
            addCriterion("eq_company_name not between", value1, value2, "eqCompanyName");
            return (Criteria) this;
        }

        public Criteria andGetUserIsNull() {
            addCriterion("get_user is null");
            return (Criteria) this;
        }

        public Criteria andGetUserIsNotNull() {
            addCriterion("get_user is not null");
            return (Criteria) this;
        }

        public Criteria andGetUserEqualTo(String value) {
            addCriterion("get_user =", value, "getUser");
            return (Criteria) this;
        }

        public Criteria andGetUserNotEqualTo(String value) {
            addCriterion("get_user <>", value, "getUser");
            return (Criteria) this;
        }

        public Criteria andGetUserGreaterThan(String value) {
            addCriterion("get_user >", value, "getUser");
            return (Criteria) this;
        }

        public Criteria andGetUserGreaterThanOrEqualTo(String value) {
            addCriterion("get_user >=", value, "getUser");
            return (Criteria) this;
        }

        public Criteria andGetUserLessThan(String value) {
            addCriterion("get_user <", value, "getUser");
            return (Criteria) this;
        }

        public Criteria andGetUserLessThanOrEqualTo(String value) {
            addCriterion("get_user <=", value, "getUser");
            return (Criteria) this;
        }

        public Criteria andGetUserLike(String value) {
            addCriterion("get_user like", value, "getUser");
            return (Criteria) this;
        }

        public Criteria andGetUserNotLike(String value) {
            addCriterion("get_user not like", value, "getUser");
            return (Criteria) this;
        }

        public Criteria andGetUserIn(List<String> values) {
            addCriterion("get_user in", values, "getUser");
            return (Criteria) this;
        }

        public Criteria andGetUserNotIn(List<String> values) {
            addCriterion("get_user not in", values, "getUser");
            return (Criteria) this;
        }

        public Criteria andGetUserBetween(String value1, String value2) {
            addCriterion("get_user between", value1, value2, "getUser");
            return (Criteria) this;
        }

        public Criteria andGetUserNotBetween(String value1, String value2) {
            addCriterion("get_user not between", value1, value2, "getUser");
            return (Criteria) this;
        }

        public Criteria andGetUserDepartIsNull() {
            addCriterion("get_user_depart is null");
            return (Criteria) this;
        }

        public Criteria andGetUserDepartIsNotNull() {
            addCriterion("get_user_depart is not null");
            return (Criteria) this;
        }

        public Criteria andGetUserDepartEqualTo(String value) {
            addCriterion("get_user_depart =", value, "getUserDepart");
            return (Criteria) this;
        }

        public Criteria andGetUserDepartNotEqualTo(String value) {
            addCriterion("get_user_depart <>", value, "getUserDepart");
            return (Criteria) this;
        }

        public Criteria andGetUserDepartGreaterThan(String value) {
            addCriterion("get_user_depart >", value, "getUserDepart");
            return (Criteria) this;
        }

        public Criteria andGetUserDepartGreaterThanOrEqualTo(String value) {
            addCriterion("get_user_depart >=", value, "getUserDepart");
            return (Criteria) this;
        }

        public Criteria andGetUserDepartLessThan(String value) {
            addCriterion("get_user_depart <", value, "getUserDepart");
            return (Criteria) this;
        }

        public Criteria andGetUserDepartLessThanOrEqualTo(String value) {
            addCriterion("get_user_depart <=", value, "getUserDepart");
            return (Criteria) this;
        }

        public Criteria andGetUserDepartLike(String value) {
            addCriterion("get_user_depart like", value, "getUserDepart");
            return (Criteria) this;
        }

        public Criteria andGetUserDepartNotLike(String value) {
            addCriterion("get_user_depart not like", value, "getUserDepart");
            return (Criteria) this;
        }

        public Criteria andGetUserDepartIn(List<String> values) {
            addCriterion("get_user_depart in", values, "getUserDepart");
            return (Criteria) this;
        }

        public Criteria andGetUserDepartNotIn(List<String> values) {
            addCriterion("get_user_depart not in", values, "getUserDepart");
            return (Criteria) this;
        }

        public Criteria andGetUserDepartBetween(String value1, String value2) {
            addCriterion("get_user_depart between", value1, value2, "getUserDepart");
            return (Criteria) this;
        }

        public Criteria andGetUserDepartNotBetween(String value1, String value2) {
            addCriterion("get_user_depart not between", value1, value2, "getUserDepart");
            return (Criteria) this;
        }

        public Criteria andAssentManUserIsNull() {
            addCriterion("assent_man_user is null");
            return (Criteria) this;
        }

        public Criteria andAssentManUserIsNotNull() {
            addCriterion("assent_man_user is not null");
            return (Criteria) this;
        }

        public Criteria andAssentManUserEqualTo(String value) {
            addCriterion("assent_man_user =", value, "assentManUser");
            return (Criteria) this;
        }

        public Criteria andAssentManUserNotEqualTo(String value) {
            addCriterion("assent_man_user <>", value, "assentManUser");
            return (Criteria) this;
        }

        public Criteria andAssentManUserGreaterThan(String value) {
            addCriterion("assent_man_user >", value, "assentManUser");
            return (Criteria) this;
        }

        public Criteria andAssentManUserGreaterThanOrEqualTo(String value) {
            addCriterion("assent_man_user >=", value, "assentManUser");
            return (Criteria) this;
        }

        public Criteria andAssentManUserLessThan(String value) {
            addCriterion("assent_man_user <", value, "assentManUser");
            return (Criteria) this;
        }

        public Criteria andAssentManUserLessThanOrEqualTo(String value) {
            addCriterion("assent_man_user <=", value, "assentManUser");
            return (Criteria) this;
        }

        public Criteria andAssentManUserLike(String value) {
            addCriterion("assent_man_user like", value, "assentManUser");
            return (Criteria) this;
        }

        public Criteria andAssentManUserNotLike(String value) {
            addCriterion("assent_man_user not like", value, "assentManUser");
            return (Criteria) this;
        }

        public Criteria andAssentManUserIn(List<String> values) {
            addCriterion("assent_man_user in", values, "assentManUser");
            return (Criteria) this;
        }

        public Criteria andAssentManUserNotIn(List<String> values) {
            addCriterion("assent_man_user not in", values, "assentManUser");
            return (Criteria) this;
        }

        public Criteria andAssentManUserBetween(String value1, String value2) {
            addCriterion("assent_man_user between", value1, value2, "assentManUser");
            return (Criteria) this;
        }

        public Criteria andAssentManUserNotBetween(String value1, String value2) {
            addCriterion("assent_man_user not between", value1, value2, "assentManUser");
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

        public Criteria andAccountCodeIsNull() {
            addCriterion("account_code is null");
            return (Criteria) this;
        }

        public Criteria andAccountCodeIsNotNull() {
            addCriterion("account_code is not null");
            return (Criteria) this;
        }

        public Criteria andAccountCodeEqualTo(String value) {
            addCriterion("account_code =", value, "accountCode");
            return (Criteria) this;
        }

        public Criteria andAccountCodeNotEqualTo(String value) {
            addCriterion("account_code <>", value, "accountCode");
            return (Criteria) this;
        }

        public Criteria andAccountCodeGreaterThan(String value) {
            addCriterion("account_code >", value, "accountCode");
            return (Criteria) this;
        }

        public Criteria andAccountCodeGreaterThanOrEqualTo(String value) {
            addCriterion("account_code >=", value, "accountCode");
            return (Criteria) this;
        }

        public Criteria andAccountCodeLessThan(String value) {
            addCriterion("account_code <", value, "accountCode");
            return (Criteria) this;
        }

        public Criteria andAccountCodeLessThanOrEqualTo(String value) {
            addCriterion("account_code <=", value, "accountCode");
            return (Criteria) this;
        }

        public Criteria andAccountCodeLike(String value) {
            addCriterion("account_code like", value, "accountCode");
            return (Criteria) this;
        }

        public Criteria andAccountCodeNotLike(String value) {
            addCriterion("account_code not like", value, "accountCode");
            return (Criteria) this;
        }

        public Criteria andAccountCodeIn(List<String> values) {
            addCriterion("account_code in", values, "accountCode");
            return (Criteria) this;
        }

        public Criteria andAccountCodeNotIn(List<String> values) {
            addCriterion("account_code not in", values, "accountCode");
            return (Criteria) this;
        }

        public Criteria andAccountCodeBetween(String value1, String value2) {
            addCriterion("account_code between", value1, value2, "accountCode");
            return (Criteria) this;
        }

        public Criteria andAccountCodeNotBetween(String value1, String value2) {
            addCriterion("account_code not between", value1, value2, "accountCode");
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