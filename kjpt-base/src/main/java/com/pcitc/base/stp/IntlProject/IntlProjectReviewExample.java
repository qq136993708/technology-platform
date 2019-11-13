package com.pcitc.base.stp.IntlProject;

import java.util.ArrayList;
import java.util.List;

public class IntlProjectReviewExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IntlProjectReviewExample() {
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

        public Criteria andReviewIdIsNull() {
            addCriterion("review_id is null");
            return (Criteria) this;
        }

        public Criteria andReviewIdIsNotNull() {
            addCriterion("review_id is not null");
            return (Criteria) this;
        }

        public Criteria andReviewIdEqualTo(String value) {
            addCriterion("review_id =", value, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdNotEqualTo(String value) {
            addCriterion("review_id <>", value, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdGreaterThan(String value) {
            addCriterion("review_id >", value, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdGreaterThanOrEqualTo(String value) {
            addCriterion("review_id >=", value, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdLessThan(String value) {
            addCriterion("review_id <", value, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdLessThanOrEqualTo(String value) {
            addCriterion("review_id <=", value, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdLike(String value) {
            addCriterion("review_id like", value, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdNotLike(String value) {
            addCriterion("review_id not like", value, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdIn(List<String> values) {
            addCriterion("review_id in", values, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdNotIn(List<String> values) {
            addCriterion("review_id not in", values, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdBetween(String value1, String value2) {
            addCriterion("review_id between", value1, value2, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdNotBetween(String value1, String value2) {
            addCriterion("review_id not between", value1, value2, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewTitleIsNull() {
            addCriterion("review_title is null");
            return (Criteria) this;
        }

        public Criteria andReviewTitleIsNotNull() {
            addCriterion("review_title is not null");
            return (Criteria) this;
        }

        public Criteria andReviewTitleEqualTo(String value) {
            addCriterion("review_title =", value, "reviewTitle");
            return (Criteria) this;
        }

        public Criteria andReviewTitleNotEqualTo(String value) {
            addCriterion("review_title <>", value, "reviewTitle");
            return (Criteria) this;
        }

        public Criteria andReviewTitleGreaterThan(String value) {
            addCriterion("review_title >", value, "reviewTitle");
            return (Criteria) this;
        }

        public Criteria andReviewTitleGreaterThanOrEqualTo(String value) {
            addCriterion("review_title >=", value, "reviewTitle");
            return (Criteria) this;
        }

        public Criteria andReviewTitleLessThan(String value) {
            addCriterion("review_title <", value, "reviewTitle");
            return (Criteria) this;
        }

        public Criteria andReviewTitleLessThanOrEqualTo(String value) {
            addCriterion("review_title <=", value, "reviewTitle");
            return (Criteria) this;
        }

        public Criteria andReviewTitleLike(String value) {
            addCriterion("review_title like", value, "reviewTitle");
            return (Criteria) this;
        }

        public Criteria andReviewTitleNotLike(String value) {
            addCriterion("review_title not like", value, "reviewTitle");
            return (Criteria) this;
        }

        public Criteria andReviewTitleIn(List<String> values) {
            addCriterion("review_title in", values, "reviewTitle");
            return (Criteria) this;
        }

        public Criteria andReviewTitleNotIn(List<String> values) {
            addCriterion("review_title not in", values, "reviewTitle");
            return (Criteria) this;
        }

        public Criteria andReviewTitleBetween(String value1, String value2) {
            addCriterion("review_title between", value1, value2, "reviewTitle");
            return (Criteria) this;
        }

        public Criteria andReviewTitleNotBetween(String value1, String value2) {
            addCriterion("review_title not between", value1, value2, "reviewTitle");
            return (Criteria) this;
        }

        public Criteria andProjectPlantIdIsNull() {
            addCriterion("project_plant_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectPlantIdIsNotNull() {
            addCriterion("project_plant_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectPlantIdEqualTo(String value) {
            addCriterion("project_plant_id =", value, "projectPlantId");
            return (Criteria) this;
        }

        public Criteria andProjectPlantIdNotEqualTo(String value) {
            addCriterion("project_plant_id <>", value, "projectPlantId");
            return (Criteria) this;
        }

        public Criteria andProjectPlantIdGreaterThan(String value) {
            addCriterion("project_plant_id >", value, "projectPlantId");
            return (Criteria) this;
        }

        public Criteria andProjectPlantIdGreaterThanOrEqualTo(String value) {
            addCriterion("project_plant_id >=", value, "projectPlantId");
            return (Criteria) this;
        }

        public Criteria andProjectPlantIdLessThan(String value) {
            addCriterion("project_plant_id <", value, "projectPlantId");
            return (Criteria) this;
        }

        public Criteria andProjectPlantIdLessThanOrEqualTo(String value) {
            addCriterion("project_plant_id <=", value, "projectPlantId");
            return (Criteria) this;
        }

        public Criteria andProjectPlantIdLike(String value) {
            addCriterion("project_plant_id like", value, "projectPlantId");
            return (Criteria) this;
        }

        public Criteria andProjectPlantIdNotLike(String value) {
            addCriterion("project_plant_id not like", value, "projectPlantId");
            return (Criteria) this;
        }

        public Criteria andProjectPlantIdIn(List<String> values) {
            addCriterion("project_plant_id in", values, "projectPlantId");
            return (Criteria) this;
        }

        public Criteria andProjectPlantIdNotIn(List<String> values) {
            addCriterion("project_plant_id not in", values, "projectPlantId");
            return (Criteria) this;
        }

        public Criteria andProjectPlantIdBetween(String value1, String value2) {
            addCriterion("project_plant_id between", value1, value2, "projectPlantId");
            return (Criteria) this;
        }

        public Criteria andProjectPlantIdNotBetween(String value1, String value2) {
            addCriterion("project_plant_id not between", value1, value2, "projectPlantId");
            return (Criteria) this;
        }

        public Criteria andReviewNoIsNull() {
            addCriterion("review_no is null");
            return (Criteria) this;
        }

        public Criteria andReviewNoIsNotNull() {
            addCriterion("review_no is not null");
            return (Criteria) this;
        }

        public Criteria andReviewNoEqualTo(Integer value) {
            addCriterion("review_no =", value, "reviewNo");
            return (Criteria) this;
        }

        public Criteria andReviewNoNotEqualTo(Integer value) {
            addCriterion("review_no <>", value, "reviewNo");
            return (Criteria) this;
        }

        public Criteria andReviewNoGreaterThan(Integer value) {
            addCriterion("review_no >", value, "reviewNo");
            return (Criteria) this;
        }

        public Criteria andReviewNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("review_no >=", value, "reviewNo");
            return (Criteria) this;
        }

        public Criteria andReviewNoLessThan(Integer value) {
            addCriterion("review_no <", value, "reviewNo");
            return (Criteria) this;
        }

        public Criteria andReviewNoLessThanOrEqualTo(Integer value) {
            addCriterion("review_no <=", value, "reviewNo");
            return (Criteria) this;
        }

        public Criteria andReviewNoIn(List<Integer> values) {
            addCriterion("review_no in", values, "reviewNo");
            return (Criteria) this;
        }

        public Criteria andReviewNoNotIn(List<Integer> values) {
            addCriterion("review_no not in", values, "reviewNo");
            return (Criteria) this;
        }

        public Criteria andReviewNoBetween(Integer value1, Integer value2) {
            addCriterion("review_no between", value1, value2, "reviewNo");
            return (Criteria) this;
        }

        public Criteria andReviewNoNotBetween(Integer value1, Integer value2) {
            addCriterion("review_no not between", value1, value2, "reviewNo");
            return (Criteria) this;
        }

        public Criteria andReviewTimeIsNull() {
            addCriterion("review_time is null");
            return (Criteria) this;
        }

        public Criteria andReviewTimeIsNotNull() {
            addCriterion("review_time is not null");
            return (Criteria) this;
        }

        public Criteria andReviewTimeEqualTo(String value) {
            addCriterion("review_time =", value, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewTimeNotEqualTo(String value) {
            addCriterion("review_time <>", value, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewTimeGreaterThan(String value) {
            addCriterion("review_time >", value, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewTimeGreaterThanOrEqualTo(String value) {
            addCriterion("review_time >=", value, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewTimeLessThan(String value) {
            addCriterion("review_time <", value, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewTimeLessThanOrEqualTo(String value) {
            addCriterion("review_time <=", value, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewTimeLike(String value) {
            addCriterion("review_time like", value, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewTimeNotLike(String value) {
            addCriterion("review_time not like", value, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewTimeIn(List<String> values) {
            addCriterion("review_time in", values, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewTimeNotIn(List<String> values) {
            addCriterion("review_time not in", values, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewTimeBetween(String value1, String value2) {
            addCriterion("review_time between", value1, value2, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewTimeNotBetween(String value1, String value2) {
            addCriterion("review_time not between", value1, value2, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewStatusIsNull() {
            addCriterion("review_status is null");
            return (Criteria) this;
        }

        public Criteria andReviewStatusIsNotNull() {
            addCriterion("review_status is not null");
            return (Criteria) this;
        }

        public Criteria andReviewStatusEqualTo(Integer value) {
            addCriterion("review_status =", value, "reviewStatus");
            return (Criteria) this;
        }

        public Criteria andReviewStatusNotEqualTo(Integer value) {
            addCriterion("review_status <>", value, "reviewStatus");
            return (Criteria) this;
        }

        public Criteria andReviewStatusGreaterThan(Integer value) {
            addCriterion("review_status >", value, "reviewStatus");
            return (Criteria) this;
        }

        public Criteria andReviewStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("review_status >=", value, "reviewStatus");
            return (Criteria) this;
        }

        public Criteria andReviewStatusLessThan(Integer value) {
            addCriterion("review_status <", value, "reviewStatus");
            return (Criteria) this;
        }

        public Criteria andReviewStatusLessThanOrEqualTo(Integer value) {
            addCriterion("review_status <=", value, "reviewStatus");
            return (Criteria) this;
        }

        public Criteria andReviewStatusIn(List<Integer> values) {
            addCriterion("review_status in", values, "reviewStatus");
            return (Criteria) this;
        }

        public Criteria andReviewStatusNotIn(List<Integer> values) {
            addCriterion("review_status not in", values, "reviewStatus");
            return (Criteria) this;
        }

        public Criteria andReviewStatusBetween(Integer value1, Integer value2) {
            addCriterion("review_status between", value1, value2, "reviewStatus");
            return (Criteria) this;
        }

        public Criteria andReviewStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("review_status not between", value1, value2, "reviewStatus");
            return (Criteria) this;
        }

        public Criteria andReviewAddressIsNull() {
            addCriterion("review_address is null");
            return (Criteria) this;
        }

        public Criteria andReviewAddressIsNotNull() {
            addCriterion("review_address is not null");
            return (Criteria) this;
        }

        public Criteria andReviewAddressEqualTo(String value) {
            addCriterion("review_address =", value, "reviewAddress");
            return (Criteria) this;
        }

        public Criteria andReviewAddressNotEqualTo(String value) {
            addCriterion("review_address <>", value, "reviewAddress");
            return (Criteria) this;
        }

        public Criteria andReviewAddressGreaterThan(String value) {
            addCriterion("review_address >", value, "reviewAddress");
            return (Criteria) this;
        }

        public Criteria andReviewAddressGreaterThanOrEqualTo(String value) {
            addCriterion("review_address >=", value, "reviewAddress");
            return (Criteria) this;
        }

        public Criteria andReviewAddressLessThan(String value) {
            addCriterion("review_address <", value, "reviewAddress");
            return (Criteria) this;
        }

        public Criteria andReviewAddressLessThanOrEqualTo(String value) {
            addCriterion("review_address <=", value, "reviewAddress");
            return (Criteria) this;
        }

        public Criteria andReviewAddressLike(String value) {
            addCriterion("review_address like", value, "reviewAddress");
            return (Criteria) this;
        }

        public Criteria andReviewAddressNotLike(String value) {
            addCriterion("review_address not like", value, "reviewAddress");
            return (Criteria) this;
        }

        public Criteria andReviewAddressIn(List<String> values) {
            addCriterion("review_address in", values, "reviewAddress");
            return (Criteria) this;
        }

        public Criteria andReviewAddressNotIn(List<String> values) {
            addCriterion("review_address not in", values, "reviewAddress");
            return (Criteria) this;
        }

        public Criteria andReviewAddressBetween(String value1, String value2) {
            addCriterion("review_address between", value1, value2, "reviewAddress");
            return (Criteria) this;
        }

        public Criteria andReviewAddressNotBetween(String value1, String value2) {
            addCriterion("review_address not between", value1, value2, "reviewAddress");
            return (Criteria) this;
        }

        public Criteria andReviewSpeekerIsNull() {
            addCriterion("review_speeker is null");
            return (Criteria) this;
        }

        public Criteria andReviewSpeekerIsNotNull() {
            addCriterion("review_speeker is not null");
            return (Criteria) this;
        }

        public Criteria andReviewSpeekerEqualTo(String value) {
            addCriterion("review_speeker =", value, "reviewSpeeker");
            return (Criteria) this;
        }

        public Criteria andReviewSpeekerNotEqualTo(String value) {
            addCriterion("review_speeker <>", value, "reviewSpeeker");
            return (Criteria) this;
        }

        public Criteria andReviewSpeekerGreaterThan(String value) {
            addCriterion("review_speeker >", value, "reviewSpeeker");
            return (Criteria) this;
        }

        public Criteria andReviewSpeekerGreaterThanOrEqualTo(String value) {
            addCriterion("review_speeker >=", value, "reviewSpeeker");
            return (Criteria) this;
        }

        public Criteria andReviewSpeekerLessThan(String value) {
            addCriterion("review_speeker <", value, "reviewSpeeker");
            return (Criteria) this;
        }

        public Criteria andReviewSpeekerLessThanOrEqualTo(String value) {
            addCriterion("review_speeker <=", value, "reviewSpeeker");
            return (Criteria) this;
        }

        public Criteria andReviewSpeekerLike(String value) {
            addCriterion("review_speeker like", value, "reviewSpeeker");
            return (Criteria) this;
        }

        public Criteria andReviewSpeekerNotLike(String value) {
            addCriterion("review_speeker not like", value, "reviewSpeeker");
            return (Criteria) this;
        }

        public Criteria andReviewSpeekerIn(List<String> values) {
            addCriterion("review_speeker in", values, "reviewSpeeker");
            return (Criteria) this;
        }

        public Criteria andReviewSpeekerNotIn(List<String> values) {
            addCriterion("review_speeker not in", values, "reviewSpeeker");
            return (Criteria) this;
        }

        public Criteria andReviewSpeekerBetween(String value1, String value2) {
            addCriterion("review_speeker between", value1, value2, "reviewSpeeker");
            return (Criteria) this;
        }

        public Criteria andReviewSpeekerNotBetween(String value1, String value2) {
            addCriterion("review_speeker not between", value1, value2, "reviewSpeeker");
            return (Criteria) this;
        }

        public Criteria andReviewResultIsNull() {
            addCriterion("review_result is null");
            return (Criteria) this;
        }

        public Criteria andReviewResultIsNotNull() {
            addCriterion("review_result is not null");
            return (Criteria) this;
        }

        public Criteria andReviewResultEqualTo(String value) {
            addCriterion("review_result =", value, "reviewResult");
            return (Criteria) this;
        }

        public Criteria andReviewResultNotEqualTo(String value) {
            addCriterion("review_result <>", value, "reviewResult");
            return (Criteria) this;
        }

        public Criteria andReviewResultGreaterThan(String value) {
            addCriterion("review_result >", value, "reviewResult");
            return (Criteria) this;
        }

        public Criteria andReviewResultGreaterThanOrEqualTo(String value) {
            addCriterion("review_result >=", value, "reviewResult");
            return (Criteria) this;
        }

        public Criteria andReviewResultLessThan(String value) {
            addCriterion("review_result <", value, "reviewResult");
            return (Criteria) this;
        }

        public Criteria andReviewResultLessThanOrEqualTo(String value) {
            addCriterion("review_result <=", value, "reviewResult");
            return (Criteria) this;
        }

        public Criteria andReviewResultLike(String value) {
            addCriterion("review_result like", value, "reviewResult");
            return (Criteria) this;
        }

        public Criteria andReviewResultNotLike(String value) {
            addCriterion("review_result not like", value, "reviewResult");
            return (Criteria) this;
        }

        public Criteria andReviewResultIn(List<String> values) {
            addCriterion("review_result in", values, "reviewResult");
            return (Criteria) this;
        }

        public Criteria andReviewResultNotIn(List<String> values) {
            addCriterion("review_result not in", values, "reviewResult");
            return (Criteria) this;
        }

        public Criteria andReviewResultBetween(String value1, String value2) {
            addCriterion("review_result between", value1, value2, "reviewResult");
            return (Criteria) this;
        }

        public Criteria andReviewResultNotBetween(String value1, String value2) {
            addCriterion("review_result not between", value1, value2, "reviewResult");
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

        public Criteria andRemarkersIsNull() {
            addCriterion("remarkers is null");
            return (Criteria) this;
        }

        public Criteria andRemarkersIsNotNull() {
            addCriterion("remarkers is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkersEqualTo(String value) {
            addCriterion("remarkers =", value, "remarkers");
            return (Criteria) this;
        }

        public Criteria andRemarkersNotEqualTo(String value) {
            addCriterion("remarkers <>", value, "remarkers");
            return (Criteria) this;
        }

        public Criteria andRemarkersGreaterThan(String value) {
            addCriterion("remarkers >", value, "remarkers");
            return (Criteria) this;
        }

        public Criteria andRemarkersGreaterThanOrEqualTo(String value) {
            addCriterion("remarkers >=", value, "remarkers");
            return (Criteria) this;
        }

        public Criteria andRemarkersLessThan(String value) {
            addCriterion("remarkers <", value, "remarkers");
            return (Criteria) this;
        }

        public Criteria andRemarkersLessThanOrEqualTo(String value) {
            addCriterion("remarkers <=", value, "remarkers");
            return (Criteria) this;
        }

        public Criteria andRemarkersLike(String value) {
            addCriterion("remarkers like", value, "remarkers");
            return (Criteria) this;
        }

        public Criteria andRemarkersNotLike(String value) {
            addCriterion("remarkers not like", value, "remarkers");
            return (Criteria) this;
        }

        public Criteria andRemarkersIn(List<String> values) {
            addCriterion("remarkers in", values, "remarkers");
            return (Criteria) this;
        }

        public Criteria andRemarkersNotIn(List<String> values) {
            addCriterion("remarkers not in", values, "remarkers");
            return (Criteria) this;
        }

        public Criteria andRemarkersBetween(String value1, String value2) {
            addCriterion("remarkers between", value1, value2, "remarkers");
            return (Criteria) this;
        }

        public Criteria andRemarkersNotBetween(String value1, String value2) {
            addCriterion("remarkers not between", value1, value2, "remarkers");
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